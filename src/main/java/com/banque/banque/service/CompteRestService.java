/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.banque.banque.service;

import com.banque.banque.bean.Compte;
import com.banque.banque.metier.CompteMetier;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

/**
 *
 * @author HP
 */
@RestController
public class CompteRestService {

    @Autowired
    private CompteMetier compteMetier;

    @RequestMapping(value = "/comptes", method = RequestMethod.POST)
    public Compte saveCompte(@RequestBody Compte c) {
        return compteMetier.saveCompte(c);
    }

    @RequestMapping(value = "/comptes/{code}", method = RequestMethod.GET)
    public Compte getCompte(@PathVariable String code) {
        return compteMetier.getCompte(code);
    }

}
