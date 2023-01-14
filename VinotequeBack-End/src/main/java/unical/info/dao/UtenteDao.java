package unical.info.dao;

import unical.info.model.Promozione;
import unical.info.model.Utente;

import java.util.List;

public interface UtenteDao {
    public List<Utente> findAll();

    public List<Promozione> findByPromotion();

    public void saveOrUpdate(Utente utente);

    public void delete(Utente utente);
}
