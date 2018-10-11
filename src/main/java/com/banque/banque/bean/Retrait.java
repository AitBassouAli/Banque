/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.banque.banque.bean;

import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;

/**
 *
 * @author HP
 */
@Entity
@DiscriminatorValue("R")
public class Retrait extends Opperation {


}
