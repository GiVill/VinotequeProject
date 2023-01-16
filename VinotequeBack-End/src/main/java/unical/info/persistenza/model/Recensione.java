package unical.info.persistenza.model;

import java.util.Date;

public class Recensione {
    Long id;
    String descrizione;
    Utente recensione_sommelier;
    Vino recensione_vino;
    String data;

    public Recensione(Long id, String descrizione, Utente recensione_sommelier, Vino recensione_vino, String data) {
        this.id = id;
        this.descrizione = descrizione;
        this.recensione_sommelier = recensione_sommelier;
        this.recensione_vino = recensione_vino;
        this.data = data;
    }

    public Recensione() {
    }

    public Utente getRecensione_sommelier() {
        return recensione_sommelier;
    }

    public void setRecensione_sommelier(Utente recensione_sommelier) {
        this.recensione_sommelier = recensione_sommelier;
    }

    public Vino getRecensione_vino() {
        return recensione_vino;
    }

    public void setRecensione_vino(Vino recensione_vino) {
        this.recensione_vino = recensione_vino;
    }



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

    public String getData() {
        return data;
    }

    public void setData(String data) {
        this.data = data;
    }
}
