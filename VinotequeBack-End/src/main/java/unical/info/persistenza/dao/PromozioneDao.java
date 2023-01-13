package unical.info.persistenza.dao;

import unical.info.persistenza.model.Promozione;

import java.util.List;

public interface PromozioneDao {
    public List<Promozione> findAll();

    public Promozione findByDescrizione(String codicePromo);

    public void save(Promozione promo);

    public void delete(Promozione utente);

}
