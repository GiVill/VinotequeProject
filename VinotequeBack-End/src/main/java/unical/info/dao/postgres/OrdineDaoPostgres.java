package unical.info.dao.postgres;

import unical.info.dao.OrdineDao;

import java.sql.Connection;

public class OrdineDaoPostgres implements OrdineDao {
    Connection conn;

    public OrdineDaoPostgres(Connection connection) {
        this.conn =connection;
    }
}
