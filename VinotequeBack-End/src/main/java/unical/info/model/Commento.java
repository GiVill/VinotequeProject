package unical.info.model;

import java.util.Date;

public class Commento {
    Long id;
    String descrizione;
    Utente commento_utente;
    Vino commento_vino;
    Date data;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getDescrizione() {
        return descrizione;
    }

    public void setDescrizione(String descrizione) {
        this.descrizione = descrizione;
    }

    public Utente getCommento_utente() {
        return commento_utente;
    }

    public void setCommento_utente(Utente commento_utente) {
        this.commento_utente = commento_utente;
    }

    public Vino getCommento_vino() {
        return commento_vino;
    }

    public void setCommento_vino(Vino commento_vino) {
        this.commento_vino = commento_vino;
    }

    public Date getData() {
        return data;
    }

    public void setData(Date data) {
        this.data = data;
    }
}
