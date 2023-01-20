package unical.info.model;

public class Richieste {
    long id;
    Utente utente;

    public Richieste(long id, Utente utente) {
        this.id = id;
        this.utente = utente;
    }

    public Richieste() {
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public Utente getUtente() {
        return utente;
    }

    public void setUtente(Utente utente) {
        this.utente = utente;
    }
}
