package unical.info.model;

import java.math.BigDecimal;
import java.util.Date;

public class Ordine {
    Long id;
    Utente ordine_utente;
    Carrello ordine_carrello;
    Metodo_Pagamento ordine_metodo_pag;
    Indirizzo ordine_indirizzo;
    BigDecimal totale;
    String status;
    Promozione ordine_promozione;
    Date data;

    public Date getData() {
        return data;
    }

    public void setData(Date data) {
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

    public Carrello getOrdine_carrello() {
        return ordine_carrello;
    }

    public void setOrdine_carrello(Carrello ordine_carrello) {
        this.ordine_carrello = ordine_carrello;
    }

    public Metodo_Pagamento getOrdine_metodo_pag() {
        return ordine_metodo_pag;
    }

    public void setOrdine_metodo_pag(Metodo_Pagamento ordine_metodo_pag) {
        this.ordine_metodo_pag = ordine_metodo_pag;
    }

    public Indirizzo getOrdine_indirizzo() {
        return ordine_indirizzo;
    }

    public void setOrdine_indirizzo(Indirizzo ordine_indirizzo) {
        this.ordine_indirizzo = ordine_indirizzo;
    }

    public BigDecimal getTotale() {
        return totale;
    }

    public void setTotale(BigDecimal totale) {
        this.totale = totale;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }
}
