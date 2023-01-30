package unical.info.model;

import java.util.ArrayList;

public class Carrello {
    private ArrayList<Vino> vini;
    private ArrayList<Integer> quantita;

    public ArrayList<Vino> getVini() {
        return vini;
    }

    public void setVini(ArrayList<Vino> vini) {
        this.vini = vini;
    }

    public ArrayList<Integer> getQuantita() {
        return quantita;
    }

    public void setQuantita(ArrayList<Integer> quantita) {
        this.quantita = quantita;
    }

    public Carrello(ArrayList<Vino> vini, ArrayList<Integer> quantita) {
        this.vini = vini;
        this.quantita = quantita;
    }

    public Carrello(){}

    @Override
    public String toString() {
        return "Carrello{" +
                "vini=" + vini +
                ", quantita=" + quantita +
                '}';
    }
}
