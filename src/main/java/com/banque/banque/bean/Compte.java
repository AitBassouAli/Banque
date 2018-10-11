/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.banque.banque.bean;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonSubTypes;
import com.fasterxml.jackson.annotation.JsonTypeInfo;
import java.io.Serializable;
import java.util.Date;
import java.util.List;
import javax.persistence.DiscriminatorColumn;
import javax.persistence.DiscriminatorType;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Inheritance;
import javax.persistence.InheritanceType;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Temporal;
import javax.xml.bind.annotation.XmlSeeAlso;
import javax.xml.bind.annotation.XmlTransient;

/**
 *
 * @author HP
 */
@Entity
@Inheritance(strategy = InheritanceType.SINGLE_TABLE)
@DiscriminatorColumn(name = "Type_CPTE",
        discriminatorType = DiscriminatorType.STRING, length = 2)

@JsonTypeInfo(use = JsonTypeInfo.Id.NAME, include = JsonTypeInfo.As.PROPERTY, property = "type")
@JsonSubTypes({
    @JsonSubTypes.Type(name = "CC", value = CompteCourant.class),
    @JsonSubTypes.Type(name = "CE", value = CompteEpargne.class)
})

@XmlSeeAlso({CompteCourant.class, CompteEpargne.class})
public abstract class Compte implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    private String codeCompte;
    private Double solde;
    @Temporal(javax.persistence.TemporalType.TIMESTAMP)
    private Date dateCreation;
    @ManyToOne
    @JoinColumn(name = "CODE_CLI")
    private Client client;
    @ManyToOne
    @JoinColumn(name = "CODE_EMP")
    private Employe employe;
    @OneToMany(mappedBy = "compte")
    private List<Opperation> operations;

    @JsonIgnore
    @XmlTransient
    public List<Opperation> getOperations() {
        return operations;
    }

    public void setOperations(List<Opperation> operations) {
        this.operations = operations;
    }

    public Compte(String codeCompte, Double solde, Date dateCreation) {
        this.codeCompte = codeCompte;
        this.solde = solde;
        this.dateCreation = dateCreation;
    }

    public Compte() {
    }

    public String getCodeCompte() {
        return codeCompte;
    }

    public void setCodeCompte(String codeCompte) {
        this.codeCompte = codeCompte;
    }

    public Double getSolde() {
        return solde;
    }

    public void setSolde(Double solde) {
        this.solde = solde;
    }

    public Date getDateCreation() {
        return dateCreation;
    }

    public void setDateCreation(Date dateCreation) {
        this.dateCreation = dateCreation;
    }

    public Client getClient() {
        return client;
    }

    public void setClient(Client client) {
        this.client = client;
    }

    public Employe getEmploye() {
        return employe;
    }

    public void setEmploye(Employe employe) {
        this.employe = employe;
    }

}
