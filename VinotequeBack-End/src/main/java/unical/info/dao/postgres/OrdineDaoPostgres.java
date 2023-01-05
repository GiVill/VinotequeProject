package unical.info.dao.postgres;

import unical.info.dao.OrdineDao;
import unical.info.model.Ordine;

import java.sql.Connection;

public class OrdineDaoPostgres implements OrdineDao {
    Connection conn;

    public OrdineDaoPostgres(Connection connection) {
        this.conn =connection;
    }

    @Override
    public Ordine findByPrimaryKey(String codiceOrdine) {
        return null;
    }

    @Override
    public void saveOrUpdate(Ordine utente) {

    }

    @Override
    public void delete(Ordine utente) {

    }
}
