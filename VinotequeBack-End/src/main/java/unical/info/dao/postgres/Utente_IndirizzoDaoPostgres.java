package unical.info.dao.postgres;

import unical.info.dao.Utente_IndirizzoDao;

import java.sql.Connection;

public class Utente_IndirizzoDaoPostgres implements Utente_IndirizzoDao {
    Connection conn;

    public Utente_IndirizzoDaoPostgres(Connection connection) {
        this.conn =connection;
    }
}
