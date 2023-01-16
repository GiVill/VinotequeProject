package unical.info.persistenza.dao.postgres;

import unical.info.persistenza.dao.CarrelloDao;
import unical.info.persistenza.model.Carrello;
import unical.info.persistenza.model.Utente;

import java.sql.Connection;
import java.util.List;

public class CarrelloDaoPostgres implements CarrelloDao {
    Connection conn;

    public CarrelloDaoPostgres(Connection connection) {
        this.conn =connection;
    }

    @Override
    public List<Utente> findAll() {
        return null;
    }

    @Override
    public Carrello findByPrimaryKey(String IDutente) {
        return null;
    }

    @Override
    public void saveOrUpdate(Carrello carrello, String IDutente) {

    }

    @Override
    public void delete(Carrello carrello, String IDutente) {

    }
}
