package unical.info.dao.postgres;

import unical.info.dao.UtenteDao;

import java.sql.Connection;

public class UtenteDaoPostgres implements UtenteDao {
    Connection conn;

    public UtenteDaoPostgres(Connection connection) {
        this.conn =connection;
    }
}
