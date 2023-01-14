package unical.info.model;

import java.util.Date;

public class Recensione {
    Long id;
    String descrizione;
    Utente recensione_sommelier;
    Vino recensione_vino;
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

    public Date getData() {
        return data;
    }

    public void setData(Date data) {
        this.data = data;
    }
}
