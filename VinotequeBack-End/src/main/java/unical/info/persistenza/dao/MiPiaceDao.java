package unical.info.persistenza.dao;

import unical.info.persistenza.model.MiPiace;
import unical.info.persistenza.model.Utente;
import unical.info.persistenza.model.Vino;

import java.sql.SQLException;
import java.util.List;

public interface MiPiaceDao {
    public List<Vino> findAll();

    public List<Vino> findByUtente(long id) throws SQLException;

    public int countByVino(long id) throws SQLException;

    public void save(MiPiace mipiace);

    public void delete(Utente utente);
}
