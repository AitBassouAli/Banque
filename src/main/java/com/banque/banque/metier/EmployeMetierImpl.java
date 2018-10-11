/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.banque.banque.metier;

import com.banque.banque.bean.Employe;
import com.banque.banque.dao.EmployeRepository;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 *
 * @author HP
 */
@Service
public class EmployeMetierImpl implements EmployeMetier{
     
    @Autowired
    private EmployeRepository employeRepository;
    @Override
    public Employe saveEmploye(Employe e) {
        return employeRepository.save(e);
    }

    @Override
    public List<Employe> listEmployes() {
        return (List<Employe>) employeRepository.findAll();
    }
    
}
