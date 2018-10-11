/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.banque.banque.service;

import com.banque.banque.metier.OpperationMetier;
import com.banque.banque.metier.PageOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

/**
 *
 * @author HP
 */
@RestController
public class OpperationRestService {

    @Autowired
    private OpperationMetier opperationMetier;

    @RequestMapping(value = "/versement", method = RequestMethod.PUT)
    public boolean virser(@RequestParam String code,
            @RequestParam double montant,
            @RequestParam Long codeEmp) {
        return opperationMetier.virser(code, montant, codeEmp);
    }

    @RequestMapping(value = "/retrait", method = RequestMethod.PUT)
    public boolean retirer(@RequestParam String code,
            @RequestParam double montant,
            @RequestParam Long codeEmp) {
        return opperationMetier.retirer(code, montant, codeEmp);
    }

    @RequestMapping(value = "/virement", method = RequestMethod.PUT)
    public boolean virement(@RequestParam String cpte1,
            @RequestParam String cpte2,
            @RequestParam double montant,
            @RequestParam Long codeEmp) {
        return opperationMetier.virement(cpte1, cpte2, montant, codeEmp);
    }

    @RequestMapping(value = "/operations", method = RequestMethod.GET)
    public PageOperation getOperations(@RequestParam String codeCompte,
            @RequestParam int page,
            @RequestParam int size) {
        return opperationMetier.getOperations(codeCompte, page, size);
    }
}
