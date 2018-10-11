/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.banque.banque.metier;

/**
 *
 * @author HP
 */
public interface OpperationMetier {

    public boolean virser(String code, double montant, Long codeEmp);

    public boolean retirer(String code, double montant, Long codeEmp);

    public boolean virement(String cpte1, String cpte2, double montant, Long codeEmp);

    public PageOperation getOperations(String codeCompte, int page, int size);
}
