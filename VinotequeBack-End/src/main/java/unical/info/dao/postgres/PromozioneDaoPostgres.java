package unical.info.dao.postgres;

import unical.info.dao.PromozioneDao;

import java.sql.Connection;

public class PromozioneDaoPostgres implements PromozioneDao {
    Connection conn;

    public PromozioneDaoPostgres(Connection connection) {
        this.conn =connection;
    }
}
