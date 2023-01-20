package unical.info.model;

public class Cantina {
    Long id;
    String nome;
    String indirizzo;
    String descrizione ;

    public Cantina(Long id, String nome, String indirizzo, String descrizione) {
        this.id = id;
        this.nome = nome;
        this.indirizzo = indirizzo;
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

    public String getDescrizione() {
        return descrizione;
    }

    public void setDescrizione(String descrizione) {
        this.descrizione = descrizione;
    }

    public String getIndirizzo() {
        return indirizzo;
    }

    public void setIndirizzo(String indirizzo) {
        this.indirizzo = indirizzo;
    }
}
