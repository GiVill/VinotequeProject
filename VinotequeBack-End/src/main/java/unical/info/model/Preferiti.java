package unical.info.model;

public class Preferiti {
    Utente preferiti_utente;
    Vino preferiti_vino;

    public Preferiti(Utente mipiace_utente, Vino mipiace_vino) {
        this.preferiti_utente = mipiace_utente;
        this.preferiti_vino = mipiace_vino;
    }

    public Preferiti() {
    }

    public Utente getPreferiti_utente() {
        return preferiti_utente;
    }

    public void setPreferiti_utente(Utente preferiti_utente) {
        this.preferiti_utente = preferiti_utente;
    }

    public Vino getPreferiti_vino() {
        return preferiti_vino;
    }

    public void setPreferiti_vino(Vino preferiti_vino) {
        this.preferiti_vino = preferiti_vino;
    }
}
