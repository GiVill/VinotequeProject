package unical.info.persistenza.model;


import java.util.Date;

public class Vino {
    Long id;
    String nome;
    int annata;
    float prezzo;
    int gradazione_alcolica;
    Cantina vino_cantina;
    String tipologia;
    String premi;
    byte[] foto;
    int mipiace=0;

    public Vino(Long id, String nome, int annata, float prezzo, int gradazione_alcolica, Cantina vino_cantina, String tipologia, String premi, byte[] foto) {
        this.id = id;
        this.nome = nome;
        this.annata = annata;
        this.prezzo = prezzo;
        this.gradazione_alcolica = gradazione_alcolica;
        this.vino_cantina = vino_cantina; //TODO:!!!!!! NEL MODEL LE CHIAVI ESTENRE SONO ALTRI MODEL
        this.tipologia = tipologia;
        this.premi = premi;
        this.foto = foto;
    }

    public Vino() {
    }

    public int getMipiace() {
        return mipiace;
    }

    public void setMipiace(int mipiace) {
        this.mipiace = mipiace;
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

    public byte[] getFoto() {
        return foto;
    }
    public void setPremi(String premi) {
        this.premi = premi;
    }

    public void setFoto(byte[] foto) {
        this.foto = foto;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }



    public float getPrezzo() {
        return prezzo;
    }

    public void setPrezzo(float prezzo) {
        this.prezzo = prezzo;
    }


    public Cantina getVino_cantina() {
        return vino_cantina;
    }


    public void setVino_cantina(Cantina vino_cantina) {
        this.vino_cantina = vino_cantina;
    }

    public int getAnnata() {
        return annata;
    }

    public void setAnnata(int annata) {
        this.annata = annata;
    }

    public int getGradazione_alcolica() {
        return gradazione_alcolica;
    }

    public void setGradazione_alcolica(int gradazione_alcolica) {
        this.gradazione_alcolica = gradazione_alcolica;
    }
}
