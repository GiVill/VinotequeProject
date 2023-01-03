package unical.info.model;

public class Carrello {
    long id;

    Vino carrello_vino;

    long id_utente;

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }



    public Vino getCarrello_vino() {
        return carrello_vino;
    }

    public void setCarrello_vino(Vino carrello_vino) {
        this.carrello_vino = carrello_vino;
    }

    public long getId_utente() {
        return id_utente;
    }

    public void setId_utente(long id_utente) {
        this.id_utente = id_utente;
    }
}
