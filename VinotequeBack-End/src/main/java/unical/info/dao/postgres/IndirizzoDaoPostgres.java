package unical.info.dao.postgres;

import unical.info.dao.IndirizzoDao;

import java.sql.Connection;

public class IndirizzoDaoPostgres implements IndirizzoDao {
    Connection conn;

    public IndirizzoDaoPostgres(Connection connection) {
        this.conn =connection;
    }
}
