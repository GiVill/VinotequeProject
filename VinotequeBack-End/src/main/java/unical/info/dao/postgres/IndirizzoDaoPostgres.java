package unical.info.dao.postgres;

import unical.info.dao.IndirizzoDao;
import unical.info.model.Indirizzo;

import java.sql.Connection;
import java.util.List;

public class IndirizzoDaoPostgres implements IndirizzoDao {
    Connection conn;

    public IndirizzoDaoPostgres(Connection connection) {
        this.conn =connection;
    }

    @Override
    public List<Indirizzo> findByPrimaryKey(String IDutente) {
        return null;
    }

    @Override
    public void saveOrUpdate(Indirizzo indirizzo, String utente) {

    }

    @Override
    public void delete(Indirizzo indirizzo, String utente) {

    }
}
