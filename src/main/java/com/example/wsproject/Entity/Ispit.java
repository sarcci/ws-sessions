package com.example.wsproject.Entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;

@Entity
@Table(name = "Ispit")
public class Ispit {

    @Id
    @Column(name="ID")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
/* 
    @ManyToOne
    @JoinColumn(name = "kol", referencedColumnName = "id", nullable = false)
    private Kol kol;
*/
    @ManyToOne
    @JoinColumn(name = "isp")
    private Ispitna isp;

    @Column(name="predmet")
    private String predmet;

    @Column(name="kol")
    private int kol;

    @Column(name="datum")
    private String datum;

    @Column(name="vreme")
    private String vreme;

    @Column(name="prostorija")
    private String prostorija;

    @Column(name="stgod")
    private String stGod;

    @Column(name="sem")
    private int sem;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public Ispitna getIsp() {
        return isp;
    }

    public void setIsp(Ispitna isp) {
        this.isp = isp;
    }

    public String getPredmet() {
        return predmet;
    }

    public void setPredmet(String predmet) {
        this.predmet = predmet;
    }

    public String getDatum() {
        return datum;
    }

    public void setDatum(String datum) {
        this.datum = datum;
    }


    public String getVreme() {
        return vreme;
    }

    public void setVreme(String vreme) {
        this.vreme = vreme;
    }

    public String getProstorija() {
        return prostorija;
    }

    public void setProstorija(String prostorija) {
        this.prostorija = prostorija;
    }

    public String getStGod() {
        return stGod;
    }

    public void setStGod(String stGod) {
        this.stGod = stGod;
    }

    public int getKol() {
        return kol;
    }

    public void setKol(int kol) {
        this.kol = kol;
    } 
    
    public int getSem() {
        return sem;
    }

    public void setSem(int sem) {
        this.sem = sem;
    }

    

    public Ispit() {
    }

    public Ispit(int id, Ispitna isp, String predmet, String datum, String vreme, String prostorija, String stGod) {
        this.id = id;
        this.isp = isp;
        this.predmet = predmet;
        this.datum = datum;
        this.vreme = vreme;
        this.prostorija = prostorija;
        this.stGod = stGod;
    }

    @Override
    public String toString() {
        return "Ispit [id=" + id + ", isp=" + isp + ", predmet=" + predmet + ", datum=" + datum + ", vreme=" + vreme
                + ", prostorija=" + prostorija + ", stGod=" + stGod + "]";
    }

    
}