package unical.info.model;

import java.math.BigDecimal;

public class Promozione {
    Long id;
    String descrizione;
    int sconto_prezzo;


    public Promozione(){}

    public Promozione(Long id, String descrizione, int sconto_prezzo) {
        this.id = id;
        this.descrizione = descrizione;
        this.sconto_prezzo = sconto_prezzo;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getDescrizione() {
        return descrizione;
    }

    public void setDescrizione(String descrizione) {
        this.descrizione = descrizione;
    }

    public int getSconto_prezzo() {
        return sconto_prezzo;
    }

    public void setSconto_prezzo(int sconto_prezzo) {
        this.sconto_prezzo = sconto_prezzo;
    }


}
