/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.banque.banque.metier;

import com.banque.banque.bean.Employe;
import java.util.List;

/**
 *
 * @author HP
 */
public interface EmployeMetier {
    public Employe saveEmploye(Employe e);
    public List<Employe> listEmployes();
    
}
