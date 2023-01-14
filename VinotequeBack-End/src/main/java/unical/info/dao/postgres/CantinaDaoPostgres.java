package unical.info.dao.postgres;

import unical.info.dao.CantinaDao;

import java.sql.Connection;

public class CantinaDaoPostgres implements CantinaDao {
    Connection conn;
    public CantinaDaoPostgres(Connection connection) {
        this.conn =connection;
    }
}
