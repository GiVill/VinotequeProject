package unical.info.model;

public class Richieste {
    long id;
    Utente utente;
    String matricola;

    public Richieste(long id, Utente utente, String matricola) {
        this.id = id;
        this.utente = utente;
        this.matricola = matricola;
    }

    public Richieste() {
    }

    public String getMatricola() {
        return matricola;
    }

    public void setMatricola(String matricola) {
        this.matricola = matricola;
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
