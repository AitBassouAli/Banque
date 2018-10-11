/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.banque.banque.dao;

import com.banque.banque.bean.Groupe;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 *
 * @author HP
 */
public interface GroupeRepository extends JpaRepository<Groupe, Long>{
    
}
