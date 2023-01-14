package unical.info.dao.postgres;

import unical.info.dao.CommentoDao;

import java.sql.Connection;

public class CommentoDaoPostgres implements CommentoDao {
    Connection conn;

    public CommentoDaoPostgres(Connection connection) {
        this.conn =connection;
    }
}
