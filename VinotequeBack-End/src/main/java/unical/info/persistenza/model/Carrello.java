package unical.info.persistenza.model;

import java.util.HashMap;

public class Carrello {
    long id;
    Utente id_utente;


    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public Utente getId_utente() {
        return id_utente;
    }

    public void setId_utente(Utente id_utente) {
        this.id_utente = id_utente;
    }


    private HashMap<Vino, Integer> vini;
    private double totale;

    public Carrello() {
        this.vini = new HashMap<>();
        this.totale = 0;
    }

    public void aggiungiProdotto(Vino vino, Integer quantita) {
        vini.put(vino, quantita);
        totale += vino.getPrezzo() * quantita;
    }

    public void rimuoviProdotto(Vino vino, int quantita) {
        vini.remove(vino);
        totale -= vino.getPrezzo() * quantita;
    }

    public double getTotale() {
        return totale;
    }
}

