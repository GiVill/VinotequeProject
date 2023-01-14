package unical.info.model;

public class Recensione {
    Long id;
    String descrizione;
    Long recensione_sommelier;
    Long recensione_vino;
    String data;

    public Recensione(Long id, String descrizione, Long recensione_sommelier, Long recensione_vino, String data) {
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
