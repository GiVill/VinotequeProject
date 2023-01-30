package unical.info.model;

import java.util.ArrayList;

public class Carrello {

    private long idUtente;
    private ArrayList<Long> vini;
    private ArrayList<Integer> quantity;
    private int totale;

    public long getIdUtente() {
        return idUtente;
    }

    public void setIdUtente(long idUtente) {
        this.idUtente = idUtente;
    }

    public ArrayList<Long> getVini() {
        return vini;
    }

    public void setVini(ArrayList<Long> vini) {
        this.vini = vini;
    }

    public ArrayList<Integer> getQuantity() {
        return quantity;
    }

    public void setQuantity(ArrayList<Integer> quantity) {
        this.quantity = quantity;
    }

    public int getTotale() {
        return totale;
    }

    public void setTotale(int totale) {
        this.totale = totale;
    }

    public Carrello() {
    }

    public Carrello(long idUtente, ArrayList<Long> vini, ArrayList<Integer> quantity, int totale) {
        this.idUtente = idUtente;
        this.vini = vini;
        this.quantity = quantity;
        this.totale = totale;
    }

    @Override
    public String toString() {
        return "Carrello{" +
                "idUtente=" + idUtente +
                ", vini=" + vini +
                ", quantity=" + quantity +
                ", totale=" + totale +
                '}';
    }
}
