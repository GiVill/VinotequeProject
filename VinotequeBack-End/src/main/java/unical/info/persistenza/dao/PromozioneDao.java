package unical.info.persistenza.dao;

import unical.info.model.Promozione;

import java.util.List;

public interface PromozioneDao {
    public List<Promozione> findAll();

    public Promozione findByDescrizione(String codicePromo);

    public int findByDescrizionePrezzo(String codicePromo);

    public boolean save(Promozione promo);

    public boolean delete(Promozione utente);
    public Promozione promoRandom();

}
