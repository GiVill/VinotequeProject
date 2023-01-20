package unical.info.persistenza.dao;

import unical.info.model.Preferiti;
import unical.info.model.Vino;

import java.sql.SQLException;
import java.util.List;

public interface PreferitiDao {

    public List<Vino> findByUtente(long id) throws SQLException;
    public void save(Preferiti preferiti) throws SQLException;
    public void delete(Preferiti preferiti);
}
