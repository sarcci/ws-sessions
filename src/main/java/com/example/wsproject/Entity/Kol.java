package com.example.wsproject.Entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;


@Entity
@Table(name="Kol")
public class Kol {
    @Id
    @Column(name="ID") 
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @Column(name="studiska")
    private String studiska;

    @Column(name="sem")
    private String sem;
    public Kol() {
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getStudiska() {
        return studiska;
    }

    public void setStudiska(String studiska) {
        this.studiska = studiska;
    }

    public String getSem() {
        return sem;
    }

    public void setSem(String sem) {
        this.sem = sem;
    }

    public String getRed() {
        return red;
    }

    public void setRed(String red) {
        this.red = red;
    }

    @Column(name="red")
    private String red;


    public Kol(int id, String studiska, String sem, String red) {
        this.id = id;
        this.studiska = studiska;
        this.sem = sem;
        this.red = red;
    }

    @Override
    public String toString() {
        return "Kol [id=" + id + ", studiska=" + studiska + ", sem=" + sem + ", red=" + red + "]";
    }

    

}
