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

/*
import java.util.ArrayList;
import java.util.List;

public class Carrello {
  private Hashmap<Vino,Int> vini;
  private double totale;
  private double sconto;


  public Carrello() {
    this.prodotti = new Hashmap<>();
    this.totale = 0;
    this.sconto = 0;
  }

  public void aggiungiProdotto(Vino vino, Int quantita) {
    vini.add(vino);
    totale += vino.getPrezzo() * quantita;
  }

  public void rimuoviProdotto(Vino vino, int quantita) {
    vini.remove(vino);
    totale -= prodotto.getPrezzo() * quantita;
  }

  public void applicaSconto(double sconto) {
    this.sconto = sconto;
    calcolaTotale();
  }

  private void calcolaTotale() {
    totale = totale - (totale * sconto);
  }

  public double getTotale() {
    return totale;
  }
}


 */
