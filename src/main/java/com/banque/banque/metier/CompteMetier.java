/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.banque.banque.metier;

import com.banque.banque.bean.Compte;

/**
 *
 * @author HP
 */
public interface CompteMetier {

    public Compte saveCompte(Compte c);

    public Compte getCompte(String code);
}
