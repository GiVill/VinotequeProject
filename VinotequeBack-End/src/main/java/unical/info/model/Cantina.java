package unical.info.model;

public class Cantina {
    Long id;
    String nome;
    Indirizzo cantina_indirizzo;
    String descrizione ;

    public Cantina(Long id, String nome, Indirizzo cantina_indirizzo, String descrizione) {
        this.id = id;
        this.nome = nome;
        this.cantina_indirizzo = cantina_indirizzo;
        this.descrizione = descrizione;
    }

    public Cantina() {
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public Indirizzo getCantina_indirizzo() {
        return cantina_indirizzo;
    }

    public void setCantina_indirizzo(Indirizzo cantina_indirizzo) {
        this.cantina_indirizzo = cantina_indirizzo;
    }

    public String getDescrizione() {
        return descrizione;
    }

    public void setDescrizione(String descrizione) {
        this.descrizione = descrizione;
    }
}
