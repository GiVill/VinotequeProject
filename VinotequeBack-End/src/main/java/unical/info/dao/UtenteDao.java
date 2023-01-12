package unical.info.dao;

import unical.info.model.Promozione;
import unical.info.model.Utente;

import java.sql.SQLException;
import java.util.List;

public interface UtenteDao {
    public List<Utente> findAll();

    public Utente findByPrimaryKey(long id) throws SQLException;

    public Utente findByEmail(String id);

    public void NewUtente(Utente utente);

    public void delete(Utente utente);

    public void PromuoviASommelier(Utente utente,int matricola);
}
