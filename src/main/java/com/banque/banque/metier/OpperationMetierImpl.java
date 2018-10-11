/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.banque.banque.metier;

import com.banque.banque.bean.Compte;
import com.banque.banque.bean.Employe;
import com.banque.banque.bean.Opperation;
import com.banque.banque.bean.Retrait;
import com.banque.banque.bean.Versement;
import com.banque.banque.dao.CompteRepository;
import com.banque.banque.dao.EmployeRepository;
import com.banque.banque.dao.OpperationRepository;
import java.util.Date;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

/**
 *
 * @author HP
 */
@Service
public class OpperationMetierImpl implements OpperationMetier {

    @Autowired
    private OpperationRepository opperationRepository;
    @Autowired
    private CompteRepository compteRepository;
    @Autowired
    private EmployeRepository employeRepository;

    @Override
    @Transactional
    public boolean virser(String code, double montant, Long codeEmp) {
        Compte cp = compteRepository.findByCodeCompte(code);
        Employe e = employeRepository.getOne(codeEmp);
        Opperation o = new Versement();
        o.setDateOperation(new Date());
        o.setMontant(montant);
        o.setCompte(cp);
        o.setEmploye(e);
        opperationRepository.save(o);
        cp.setSolde(cp.getSolde() + montant);
        return true;
    }

    @Override
    @Transactional
    public boolean retirer(String code, double montant, Long codeEmp) {
        Compte cp = compteRepository.findByCodeCompte(code);
        if (cp.getSolde() < montant) {
            throw new RuntimeException("Solde insuffisant");
        }
        Employe e = employeRepository.getOne(codeEmp);
        Opperation o = new Retrait();
        o.setDateOperation(new Date());
        o.setMontant(montant);
        o.setCompte(cp);
        o.setEmploye(e);
        opperationRepository.save(o);
        cp.setSolde(cp.getSolde() - montant);
        return true;
    }

    @Override
    @Transactional
    public boolean virement(String cpte1, String cpte2, double montant, Long codeEmp) {
        retirer(cpte1, montant, codeEmp);
        virser(cpte2, montant, codeEmp);
        return true;
    }

    @Override
    public PageOperation getOperations(String codeCompte, int page, int size) {
        Page<Opperation> ops=opperationRepository.findByCompteCodeCompte(codeCompte,new PageRequest(page, size));
        PageOperation pOp=new PageOperation();
        pOp.setOpperations(ops.getContent());
        pOp.setNombreOperations(ops.getNumberOfElements());
        pOp.setPage(ops.getNumber());
        pOp.setTotalPages(ops.getTotalPages());
        pOp.setTotalOperations((int) ops.getTotalElements());
        return  pOp;
    }
}
