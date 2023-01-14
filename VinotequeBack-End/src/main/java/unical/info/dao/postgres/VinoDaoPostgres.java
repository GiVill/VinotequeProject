package unical.info.dao.postgres;

import unical.info.dao.VinoDao;
import unical.info.model.Vino;

import java.sql.Connection;
import java.util.List;

public class VinoDaoPostgres implements VinoDao{
    Connection conn;

    public VinoDaoPostgres(Connection connection) {
        this.conn =connection;
    }

}
