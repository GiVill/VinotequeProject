package unical.info.model;

import java.math.BigDecimal;

public class Promozione {
    Long id;
    String descrizione;
    BigDecimal sconto_prezzo;
    Integer sconto_percentuale;

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

    public BigDecimal getSconto_prezzo() {
        return sconto_prezzo;
    }

    public void setSconto_prezzo(BigDecimal sconto_prezzo) {
        this.sconto_prezzo = sconto_prezzo;
    }

    public Integer getSconto_percentuale() {
        return sconto_percentuale;
    }

    public void setSconto_percentuale(Integer sconto_percentuale) {
        this.sconto_percentuale = sconto_percentuale;
    }
}
