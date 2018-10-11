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
@DiscriminatorValue("CE")
@XmlType(name = "CE")
public class CompteEpargne extends Compte {

    private static final long serialVersionUID = 1L;
    private Double taux;

    public CompteEpargne() {
    }

    public CompteEpargne(Double taux, String codeCompte, Double solde, Date dateCreation) {
        super(codeCompte, solde, dateCreation);
        this.taux = taux;
    }

    public Double getTaux() {
        return taux;
    }

    public void setTaux(Double taux) {
        this.taux = taux;
    }

}
