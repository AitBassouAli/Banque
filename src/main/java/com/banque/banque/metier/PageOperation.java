/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.banque.banque.metier;

import com.banque.banque.bean.Opperation;
import java.io.Serializable;
import java.util.List;

/**
 *
 * @author HP
 */
public class PageOperation implements Serializable{
    
    private List<Opperation> opperations;
    private int page;
    private int nombreOperations;
    private int totalOperations;
    private int totalPages;

    public List<Opperation> getOpperations() {
        return opperations;
    }

    public void setOpperations(List<Opperation> opperations) {
        this.opperations = opperations;
    }

    public int getPage() {
        return page;
    }

    public void setPage(int page) {
        this.page = page;
    }

    public int getNombreOperations() {
        return nombreOperations;
    }

    public void setNombreOperations(int nombreOperations) {
        this.nombreOperations = nombreOperations;
    }

    public int getTotalOperations() {
        return totalOperations;
    }

    public void setTotalOperations(int totalOperations) {
        this.totalOperations = totalOperations;
    }

    public int getTotalPages() {
        return totalPages;
    }

    public void setTotalPages(int totalPages) {
        this.totalPages = totalPages;
    }
    
}
