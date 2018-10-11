/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.banque.banque.dao;

import com.banque.banque.bean.Opperation;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

/**
 *
 * @author HP
 */
public interface OpperationRepository extends JpaRepository<Opperation, Long> {

   // @Query("SELEC o FROM Opperation o WHERE o.compte.codeCompte =:x")
    public Page<Opperation> findByCompteCodeCompte(String code, Pageable pageable);
}
