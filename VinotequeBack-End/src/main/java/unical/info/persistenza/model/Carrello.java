package unical.info.persistenza.model;

import java.util.HashMap;

public class Carrello {
    long id;
    long id_utente;
    public HashMap<Vino, Integer> vini;
    public double totale;

    public Carrello() {
        this.vini = new HashMap<>();
        this.totale = 0;
    }

    public Carrello(long id, long id_utente) {
        this.id = id;
        this.id_utente = id_utente;
        this.vini = new HashMap<>();
        this.totale = 0;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public long getId_utente() {
        return id_utente;
    }

    public void setId_utente(long id_utente) {
        this.id_utente = id_utente;
    }

    public HashMap<Vino, Integer> getVini() {
        return vini;
    }

    public void setVini(HashMap<Vino, Integer> vini) {
        this.vini = vini;
    }

    public void setTotale(double totale) {
        this.totale = totale;
    }

    public double getTotale() {
        return totale;
    }
}

