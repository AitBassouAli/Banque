/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.banque.banque.service;

import com.banque.banque.bean.Employe;
import com.banque.banque.metier.EmployeMetier;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

/**
 *
 * @author HP
 */
@RestController
public class EmployeRestService {
    @Autowired
    private EmployeMetier employeMetier;
    
    @RequestMapping(value = "/employes",method =RequestMethod.POST)
    public Employe saveEmploye(@RequestBody Employe e) {
        return employeMetier.saveEmploye(e);
    }

        @RequestMapping(value = "/employes",method =RequestMethod.GET)
    public List<Employe> listEmployes() {
        return employeMetier.listEmployes();
    }
    
}
