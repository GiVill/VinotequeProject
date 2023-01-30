package unical.info.model;


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
    String descrizione;


    String vigneto;

    public Vino(Long id, String nome, int annata, float prezzo, int gradazione_alcolica, Cantina vino_cantina, String tipologia, String premi, byte[] foto, String descrizione, String vigneto) {
        this.id = id;
        this.nome = nome;
        this.annata = annata;
        this.prezzo = prezzo;
        this.gradazione_alcolica = gradazione_alcolica;
        this.vino_cantina = vino_cantina;
        this.tipologia = tipologia;
        this.premi = premi;
        this.foto = foto;
        this.descrizione = descrizione;
        this.vigneto = vigneto;
    }

    public Vino() {
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

    public void setNome(String nome) {
        this.nome = nome;
    }

    public int getAnnata() {
        return annata;
    }

    public void setAnnata(int annata) {
        this.annata = annata;
    }

    public float getPrezzo() {
        return prezzo;
    }

    public void setPrezzo(float prezzo) {
        this.prezzo = prezzo;
    }

    public int getGradazione_alcolica() {
        return gradazione_alcolica;
    }

    public void setGradazione_alcolica(int gradazione_alcolica) {
        this.gradazione_alcolica = gradazione_alcolica;
    }

    public Cantina getVino_cantina() {
        return vino_cantina;
    }

    public void setVino_cantina(Cantina vino_cantina) {
        this.vino_cantina = vino_cantina;
    }

    public String getTipologia() {
        return tipologia;
    }

    public void setTipologia(String tipologia) {
        this.tipologia = tipologia;
    }

    public String getPremi() {
        return premi;
    }

    public void setPremi(String premi) {
        this.premi = premi;
    }

    public byte[] getFoto() {
        return foto;
    }

    public void setFoto(byte[] foto) {
        this.foto = foto;
    }

    public String getDescrizione() {
        return descrizione;
    }

    public void setDescrizione(String descrizione) {
        this.descrizione = descrizione;
    }
    public String getVigneto() {
        return vigneto;
    }

    public void setVigneto(String vigneto) {
        this.vigneto = vigneto;
    }

}
