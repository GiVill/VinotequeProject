package unical.info.model;

public class Carrello {
    Long id;
    Carrello_utente carrello_cart;
    Vino carrello_vino;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Carrello_utente getCarrello_cart() {
        return carrello_cart;
    }

    public void setCarrello_cart(Carrello_utente carrello_cart) {
        this.carrello_cart = carrello_cart;
    }

    public Vino getCarrello_vino() {
        return carrello_vino;
    }

    public void setCarrello_vino(Vino carrello_vino) {
        this.carrello_vino = carrello_vino;
    }
}
