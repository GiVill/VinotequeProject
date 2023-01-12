package unical.info.dao.postgres;

import unical.info.dao.MiPiaceDao;
import unical.info.model.MiPiace;
import unical.info.model.Utente;
import unical.info.model.Vino;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.List;

public class MiPiaceDaoPostgres implements MiPiaceDao {

    Connection conn;
    public MiPiaceDaoPostgres(Connection connection) {
        this.conn =connection;
    }
    @Override
    public List<Vino> findAll() {
        return null;
    }

    @Override
    public List<Vino> findByUtente(long id) throws SQLException {
        return null;
    }

    @Override
    public int countByVino(long id) throws SQLException {
        return 0;
    }

    @Override
    public void save(MiPiace mipiace) {

    }

    @Override
    public void delete(Utente utente) {

    }
}
