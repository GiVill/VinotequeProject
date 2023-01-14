package unical.info.dao.postgres;

import unical.info.dao.RecensioneDao;

import java.sql.Connection;

public class RecensioneDaoPostgres implements RecensioneDao {
    Connection conn;

    public RecensioneDaoPostgres(Connection connection) {
        this.conn =connection;
    }
}
