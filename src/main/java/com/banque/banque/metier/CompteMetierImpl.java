/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.banque.banque.metier;

import com.banque.banque.bean.Compte;
import com.banque.banque.dao.CompteRepository;
import java.util.Date;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 *
 * @author HP
 */
@Service
public class CompteMetierImpl implements CompteMetier {

    @Autowired
    private CompteRepository compteRepository;

    @Override
    public Compte saveCompte(Compte c) {
        c.setDateCreation(new Date());
        return compteRepository.save(c);
    }

    @Override
    public Compte getCompte(String code) {
        return compteRepository.findByCodeCompte(code);
    }

}
