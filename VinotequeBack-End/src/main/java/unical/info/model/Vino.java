package unical.info.model;

import java.math.BigDecimal;
import java.util.Date;

public class Vino {
    Long id;
    String nome;
    Date annata;
    BigDecimal prezzo;
    String gradazione_alcolica;
    Long vino_cantina;
    String tipologia;
    String premi;
    byte foto;


    int numCommenti=0;
    int numRecensioni=0;

    public int getNumCommenti() {
        return numCommenti;
    }

    public void setNumCommenti(int numCommenti) {
        this.numCommenti = numCommenti;
    }

    public int getNumRecensioni() {
        return numRecensioni;
    }

    public void setNumRecensioni(int numRecensioni) {
        this.numRecensioni = numRecensioni;
    }

    public String getTipologia() {
        return tipologia;
    }

    public void setTipologia(String tipologia) {
        this.tipologia = tipologia;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getNome() {
        return nome;
    }

    public String getPremi() {
        return premi;
    }

    public byte getFoto() {
        return foto;
    }
    public void setPremi(String premi) {
        this.premi = premi;
    }

    public void setFoto(byte foto) {
        this.foto = foto;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public Date getAnnata() {
        return annata;
    }

    public void setAnnata(Date annata) {
        this.annata = annata;
    }

    public BigDecimal getPrezzo() {
        return prezzo;
    }

    public void setPrezzo(BigDecimal prezzo) {
        this.prezzo = prezzo;
    }

    public String getGradazione_alcolica() {
        return gradazione_alcolica;
    }

    public void setGradazione_alcolica(String gradazione_alcolica) {
        this.gradazione_alcolica = gradazione_alcolica;
    }

    public Long getVino_cantina() {
        return vino_cantina;
    }

    public void setVino_cantina(Long vino_cantina) {
        this.vino_cantina = vino_cantina;
    }
}
