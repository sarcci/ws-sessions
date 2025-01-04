package com.example.wsproject.Entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name="Ispitna")
public class Ispitna {
    @Id
    @Column(name="ID") 
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @Column(name="studiska")
    private String studiska;


    @Column(name="mesec")
    private String mesec;

    public Ispitna() {
    }

    public Ispitna(int iD, String mesec, String studiska) {
        id = iD;
        this.mesec = mesec;
        this.studiska = studiska;
    }

    public int getID() {
        return id;
    }

    public void setID(int iD) {
        id = iD;
    }

    public String getMesec() {
        return mesec;
    }

    public void setMesec(String mesec) {
        this.mesec = mesec;
    }
    

    public String getStudiska() {
        return studiska;
    }

    public void setStudiska(String studiska) {
        this.studiska = studiska;
    }

    @Override
    public String toString() {
        return "Ispitna [ID=" + id + ", mesec=" + mesec + ", studiska="+ studiska+"]";
    }
    

}
