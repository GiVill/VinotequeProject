package unical.info.dao;

import unical.info.model.Promozione;

import java.util.List;

public interface PromozioneDao {
    public List<Promozione> findAll();

    public Promozione findByDescrizione(String codicePromo);

    public void save(Promozione promo);

    public void delete(Promozione utente);

}
