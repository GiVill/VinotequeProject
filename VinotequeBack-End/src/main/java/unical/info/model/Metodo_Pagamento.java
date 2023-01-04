package unical.info.model;

import java.util.Date;

public class Metodo_Pagamento {
    Long id;
    Utente metodo_pag_utente;
    String provider;
    String numero_carta;
    Date data_scadenza;
    String cvv;

    public Metodo_Pagamento(Long id, Utente metodo_pag_utente, String provider, String numero_carta, Date data_scadenza, String cvv) {
        this.id = id;
        this.metodo_pag_utente = metodo_pag_utente;
        this.provider = provider;
        this.numero_carta = numero_carta;
        this.data_scadenza = data_scadenza;
        this.cvv = cvv;
    }

    public Metodo_Pagamento() {
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Utente getMetodo_pag_utente() {
        return metodo_pag_utente;
    }

    public void setMetodo_pag_utente(Utente metodo_pag_utente) {
        this.metodo_pag_utente = metodo_pag_utente;
    }

    public String getProvider() {
        return provider;
    }

    public void setProvider(String provider) {
        this.provider = provider;
    }

    public String getNumero_carta() {
        return numero_carta;
    }

    public void setNumero_carta(String numero_carta) {
        this.numero_carta = numero_carta;
    }

    public Date getData_scadenza() {
        return data_scadenza;
    }

    public void setData_scadenza(Date data_scadenza) {
        this.data_scadenza = data_scadenza;
    }

    public String getCvv() {
        return cvv;
    }

    public void setCvv(String cvv) {
        this.cvv = cvv;
    }
}
