package unical.info.persistenza.model;

public class MiPiace {
    Long mipiace_utente;
    Long mipiace_vino;

    public MiPiace(Long mipiace_utente, Long mipiace_vino) {
        this.mipiace_utente = mipiace_utente;
        this.mipiace_vino = mipiace_vino;
    }

    public MiPiace() {
    }

    public Long getMipiace_utente() {
        return mipiace_utente;
    }

    public void setMipiace_utente(Long mipiace_utente) {
        this.mipiace_utente = mipiace_utente;
    }

    public Long getMipiace_vino() {
        return mipiace_vino;
    }

    public void setMipiace_vino(Long mipiace_vino) {
        this.mipiace_vino = mipiace_vino;
    }
}
