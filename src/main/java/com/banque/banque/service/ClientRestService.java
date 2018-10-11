/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.banque.banque.service;

import com.banque.banque.bean.Client;
import com.banque.banque.metier.ClientMetier;
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
public class ClientRestService {
    @Autowired
    private ClientMetier clientMetier;
    
    @RequestMapping(value = "/clients",method = RequestMethod.POST)
    public Client saveClient( @RequestBody Client c) {
        return clientMetier.saveClient(c);
    }
    
    @RequestMapping(value = "/clients",method = RequestMethod.GET)
    public List<Client> listClient() {
        return (List<Client>) clientMetier.listClient();
    }
    
}
