/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package entity;

import java.io.Serializable;
import javax.persistence.*;

/**
 *
 * @author trez__000
 */
@Entity
public class Company extends InfoEntity implements Serializable {
    
    private String name;
    private String description;
    private int cvr;
    private int NumEmpoyees;
    private int marketValue;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public int getCvr() {
        return cvr;
    }

    public void setCvr(int cvr) {
        this.cvr = cvr;
    }

    public int getNumEmpoyees() {
        return NumEmpoyees;
    }

    public void setNumEmpoyees(int NumEmpoyees) {
        this.NumEmpoyees = NumEmpoyees;
    }

    public int getMarketValue() {
        return marketValue;
    }

    public void setMarketValue(int marketValue) {
        this.marketValue = marketValue;
    }

    @Override
    public String toString() {
        return "Company{" + "name=" + name + ", description=" + description + ", cvr=" + cvr + ", NumEmpoyees=" + NumEmpoyees + ", marketValue=" + marketValue + '}';
    }
    
    
}
