package unical.info.model;

import java.lang.Float;


public class Ordine {
    Long id;
    Utente ordine_utente;
    String ordine_carrello;
    String metodo_pag;
    String indirizzo;
    Float totale;
    String status;
    Promozione ordine_promozione;
    String data;

    public Ordine() {
    }

    public Ordine(Long id, Utente ordine_utente, String ordine_carrello, String metodo_pag, String indirizzo, Float totale, String status, Promozione ordine_promozione, String data) {
        this.id = id;
        this.ordine_utente = ordine_utente;
        this.ordine_carrello = ordine_carrello;
        this.metodo_pag = metodo_pag;
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

    public Promozione getOrdine_promozione() {
        return ordine_promozione;
    }

    public void setOrdine_promozione(Promozione ordine_promozione) {
        this.ordine_promozione = ordine_promozione;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Utente getOrdine_utente() {
        return ordine_utente;
    }

    public void setOrdine_utente(Utente ordine_utente) {
        this.ordine_utente = ordine_utente;
    }

    public String getOrdine_carrello() {
        return ordine_carrello;
    }

    public void setOrdine_carrello(String ordine_carrello) {
        this.ordine_carrello = ordine_carrello;
    }

    public String getMetodo_pag() {
        return metodo_pag;
    }

    public void setMetodo_pag(String metodo_pag) {
        this.metodo_pag = metodo_pag;
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

    @Override
    public String toString() {
        return "Ordine{" +
                "id=" + id +
                ", ordine_utente=" + ordine_utente +
                ", ordine_carrello='" + ordine_carrello + '\'' +
                ", metodo_pag='" + metodo_pag + '\'' +
                ", indirizzo='" + indirizzo + '\'' +
                ", totale=" + totale +
                ", status='" + status + '\'' +
                ", ordine_promozione=" + ordine_promozione +
                ", data='" + data + '\'' +
                '}';
    }
}
