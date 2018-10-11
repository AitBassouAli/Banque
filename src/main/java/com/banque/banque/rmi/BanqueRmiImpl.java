/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.banque.banque.rmi;

import com.banque.banque.bean.Compte;
import com.banque.banque.metier.CompteMetier;
import com.banque.banque.metier.OpperationMetier;
import java.rmi.RemoteException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

/**
 *
 * @author HP
 */
@Component("myRmiService")
public class BanqueRmiImpl implements BanqueRmiRemote {

    @Autowired
    private CompteMetier compteMetier;
    @Autowired
    private OpperationMetier opperationMetier;

    @Override
    public Compte saveCompte(Compte cp) throws RemoteException {
        return compteMetier.saveCompte(cp);
    }

    @Override
    public Compte getCompte(String code) throws RemoteException {
        return compteMetier.getCompte(code);
    }

    @Override
    public boolean virser(String code, double montant, Long codeEmp) throws RemoteException {
        return opperationMetier.virser(code, montant, codeEmp);
    }

    @Override
    public boolean retirer(String code, double montant, Long codeEmp) throws RemoteException {
        return opperationMetier.retirer(code, montant, codeEmp);
    }

    @Override
    public boolean virement(String cpte1, String cpte2, double montant, Long codeEmp) throws RemoteException {
        return opperationMetier.virement(cpte1, cpte2, montant, codeEmp);
    }

}
