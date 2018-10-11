/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.banque.banque.service;

import com.banque.banque.bean.Compte;
import com.banque.banque.metier.CompteMetier;
import com.banque.banque.metier.OpperationMetier;
import com.banque.banque.metier.PageOperation;
import javax.jws.WebMethod;
import javax.jws.WebParam;
import javax.jws.WebService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

/**
 *
 * @author HP
 */
@Component
@WebService
public class BanqueSoapService {

    @Autowired
    private CompteMetier compteMetier;
    @Autowired
    private OpperationMetier opperationMetier;

    @WebMethod
    public Compte getCompte(@WebParam(name = "code") String code) {
        return compteMetier.getCompte(code);
    }

    @WebMethod
    public boolean virser(@WebParam(name = "code") String code,
            @WebParam(name = "montant") double montant,
            @WebParam(name = "codeEmp") Long codeEmp) {
        return opperationMetier.virser(code, montant, codeEmp);
    }

    @WebMethod
    public boolean retirer(@WebParam(name = "code") String code,
            @WebParam(name = "montant") double montant,
            @WebParam(name = "codeEmp") Long codeEmp) {
        return opperationMetier.retirer(code, montant, codeEmp);
    }

    @WebMethod
    public boolean virement(@WebParam(name = "cpte1") String cpte1,
            @WebParam(name = "cpte2") String cpte2,
            @WebParam(name = "montant") double montant,
            @WebParam(name = "codeEmp") Long codeEmp) {
        return opperationMetier.virement(cpte1, cpte2, montant, codeEmp);
    }

    @WebMethod
    public PageOperation getOperations(@WebParam(name = "code") String codeCompte,
            @WebParam(name = "page") int page,
            @WebParam(name = "size") int size) {
        return opperationMetier.getOperations(codeCompte, page, size);
    }

}
