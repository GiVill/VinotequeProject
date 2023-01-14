package unical.info.persistenza.model;

public class MiPiace {
    Utente mipiace_utente;
    Vino mipiace_vino;

    public MiPiace(Utente mipiace_utente, Vino mipiace_vino) {
        this.mipiace_utente = mipiace_utente;
        this.mipiace_vino = mipiace_vino;
    }

    public MiPiace() {
    }

    public Utente getMipiace_utente() {
        return mipiace_utente;
    }

    public void setMipiace_utente(Utente mipiace_utente) {
        this.mipiace_utente = mipiace_utente;
    }

    public Vino getMipiace_vino() {
        return mipiace_vino;
    }

    public void setMipiace_vino(Vino mipiace_vino) {
        this.mipiace_vino = mipiace_vino;
    }
}
