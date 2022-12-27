package unical.info.dao.postgres;

import unical.info.dao.CarrelloDao;

import java.sql.Connection;

public class CarrelloDaoPostgres implements CarrelloDao {
    Connection conn;

    public CarrelloDaoPostgres(Connection connection) {
        this.conn =connection;
    }
}
