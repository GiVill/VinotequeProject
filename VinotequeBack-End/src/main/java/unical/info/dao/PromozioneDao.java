package unical.info.dao;

import unical.info.model.Promozione;

import java.util.List;

public interface PromozioneDao {
    public List<Promozione> findAll();

    public Promozione findByPrimaryKey(String codicePromo);

    public void saveOrUpdate(Promozione utente);

    public void delete(Promozione utente);

}
