package unical.info.dao.postgres;

import unical.info.dao.CarrelloDao;
import unical.info.model.Carrello;
import unical.info.model.Utente;

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
