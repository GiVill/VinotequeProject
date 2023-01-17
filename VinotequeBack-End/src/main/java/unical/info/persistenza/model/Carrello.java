package unical.info.persistenza.model;

import java.util.HashMap;

public class Carrello {

    private HashMap<Long, Integer> prodotti;

    Utente carrello_utente;
    Long id;

    public Carrello(HashMap<Long, Integer> prodotti, Utente carrello_utente, Long id) {
        this.prodotti = prodotti;
        this.carrello_utente = carrello_utente;
        this.id = id;
    }

    public Carrello(HashMap<Long, Integer> prodotti, Utente carrello_utente) {
        this.prodotti = prodotti;
        this.carrello_utente = carrello_utente;
    }

    public void aggiungiProdotto(Long item, int quantity) {
        prodotti.put(item, quantity);
    }

    public void rimuoviProdotto(Long item) {
        int quantita = prodotti.get(item);
        if (quantita < 2)
            prodotti.remove(item);
        else {
            prodotti.replace(item, quantita-1);
        }
    }

    public HashMap<Long, Integer> getProdotto() {
        return prodotti;
    }

    public Utente getCarrello_utente() {
        return carrello_utente;
    }

    public void setCarrello_utente(Utente carrello_utente) {
        this.carrello_utente = carrello_utente;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }
    public void setProdotti(HashMap<Long, Integer> prodotti) {
        this.prodotti = prodotti;
    }



}


































/*
 long id;
    Utente id_utente;



     * Allor il carrello viene creato appena un utente clicca sul carrello
     * vengo generate nel di tante righe quanti vini sono presenti nel carrello:
     *
     *
     *   |id_cart|   |id_utente|   |id_vino1|
     *   |id_cart|   |id_utente|   |id_vino2|
     *   |id_cart|   |id_utente|   |id_vino2|
     *
     *
     * Le righe nl db del carrello verrano svuotate una volta completato l'ordine
     *
     *



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
 */
