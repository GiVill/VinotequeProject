package unical.info.model;

import java.lang.Float;


public class Ordine {
    Long id;
    Long ordine_utente;
    Long ordine_carrello;
    String ordine_metodo_pag;
    String indirizzo;
    Float totale;
    String status;
    Long ordine_promozione;
    String data;

    public Ordine() {
    }

    public Ordine(Long id, Long ordine_utente, Long ordine_carrello, String ordine_metodo_pag, String indirizzo, Float totale, String status, Long ordine_promozione, String data) {
        this.id = id;
        this.ordine_utente = ordine_utente;
        this.ordine_carrello = ordine_carrello;
        this.ordine_metodo_pag = ordine_metodo_pag;
        this.indirizzo = indirizzo;
        this.totale = totale;
        this.status = status;
        this.ordine_promozione = ordine_promozione;
        this.data = data;
    }

    public String getData() {
        return data;
    }

    public void setData(String data) {
        this.data = data;
    }

    public Long getOrdine_promozione() {
        return ordine_promozione;
    }

    public void setOrdine_promozione(Long ordine_promozione) {
        this.ordine_promozione = ordine_promozione;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Long getOrdine_utente() {
        return ordine_utente;
    }

    public void setOrdine_utente(Long ordine_utente) {
        this.ordine_utente = ordine_utente;
    }

    public Long getOrdine_carrello() {
        return ordine_carrello;
    }

    public void setOrdine_carrello(Long ordine_carrello) {
        this.ordine_carrello = ordine_carrello;
    }

    public String getOrdine_metodo_pag() {
        return ordine_metodo_pag;
    }

    public void setOrdine_metodo_pag(String ordine_metodo_pag) {
        this.ordine_metodo_pag = ordine_metodo_pag;
    }

    public Float getTotale() {
        return totale;
    }

    public void setTotale(Float totale) {
        this.totale = totale;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public String getIndirizzo() {
        return indirizzo;
    }

    public void setIndirizzo(String indirizzo) {
        this.indirizzo = indirizzo;
    }

}
