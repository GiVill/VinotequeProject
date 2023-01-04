package unical.info.dao;

import unical.info.model.Promozione;
import unical.info.model.Utente;
import unical.info.model.Vino;

import java.sql.SQLException;
import java.util.List;

public interface MiPiaceDao {
    public List<Vino> findAll();

    public List<Vino> findByUtente(long id) throws SQLException;

    public int countByVino(long id) throws SQLException;

    public void saveOrUpdate(Utente utente);

    public void delete(Utente utente);
}
