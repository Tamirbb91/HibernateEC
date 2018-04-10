package mum.edu.cs544.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

@Entity
public class Beneficiary{

    @Id
    @GeneratedValue
    private int Id;

    private String information;

    public int getId() {
        return Id;
    }

    public void setId(int id) {
        Id = id;
    }

    public String getInformation() {
        return information;
    }

    public void setInformation(String information) {
        this.information = information;
    }
}
