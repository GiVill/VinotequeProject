package unical.info.model;

public class Carrello_utente {
    Long id;
    Utente cart_cliente;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Utente getCart_cliente() {
        return cart_cliente;
    }

    public void setCart_cliente(Utente cart_cliente) {
        this.cart_cliente = cart_cliente;
    }
}
