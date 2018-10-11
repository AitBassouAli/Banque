/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.banque.banque.bean;

import java.util.Date;
import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;
import javax.xml.bind.annotation.XmlType;

/**
 *
 * @author HP
 */
@Entity
@DiscriminatorValue("CC")
@XmlType(name = "CC")
public class CompteCourant extends Compte{

    private static final long serialVersionUID = 1L;
    private Double decouvert;

    public CompteCourant() {
    }

    public CompteCourant(String codeCompte, Double solde, Date dateCreation,Double decouvert) {
        super(codeCompte, solde, dateCreation);
        this.decouvert = decouvert;
    }

    public Double getDecouvert() {
        return decouvert;
    }

    public void setDecouvert(Double decouvert) {
        this.decouvert = decouvert;
    }
    
    
}
