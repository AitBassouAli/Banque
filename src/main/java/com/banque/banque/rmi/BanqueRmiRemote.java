/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.banque.banque.rmi;

import com.banque.banque.bean.Compte;
import java.rmi.Remote;
import java.rmi.RemoteException;

/**
 *
 * @author HP
 */
public interface BanqueRmiRemote extends Remote {

    public Compte saveCompte(Compte cp) throws RemoteException;

    public Compte getCompte(String code) throws RemoteException;

    public boolean virser(String code, double montant, Long codeEmp) throws RemoteException;

    public boolean retirer(String code, double montant, Long codeEmp) throws RemoteException;

    public boolean virement(String cpte1, String cpte2, double montant, Long codeEmp) throws RemoteException;
}
