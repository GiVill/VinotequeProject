package unical.info.model;

import java.util.Date;

public class Recensione {
    Long id;
    String descrizione;
    Long recensione_sommelier;

    public Recensione(Long id, String descrizione, Long recensione_sommelier, Long recensione_vino, Date data) {
        this.id = id;
        this.descrizione = descrizione;
        this.recensione_sommelier = recensione_sommelier;
        this.recensione_vino = recensione_vino;
        this.data = data;
    }

    public Recensione() {
    }

    public Long getRecensione_sommelier() {
        return recensione_sommelier;
    }

    public void setRecensione_sommelier(Long recensione_sommelier) {
        this.recensione_sommelier = recensione_sommelier;
    }

    public Long getRecensione_vino() {
        return recensione_vino;
    }

    public void setRecensione_vino(Long recensione_vino) {
        this.recensione_vino = recensione_vino;
    }

    Long recensione_vino;
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

    public Date getData() {
        return data;
    }

    public void setData(Date data) {
        this.data = data;
    }
}
