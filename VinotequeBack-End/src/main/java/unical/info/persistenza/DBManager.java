package unical.info.persistenza;

import unical.info.persistenza.dao.*;
import unical.info.persistenza.dao.postgres.*;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DBManager {

    private static DBManager instance = null;

    public static DBManager getInstance() {
        if (instance == null) {
            instance = new DBManager();
        }
        return instance;
    }

    private DBManager() {
    }

    Connection conn = null;

    public Connection getConnection() {
        if (conn == null) {
            try {
                conn = DriverManager.getConnection("jdbc:postgresql://localhost:5432/Vinoteque", "postgres", "luigi170");
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
        return conn;
    }

    public UtenteDao getUtenteDao() {
        return new UtenteDaoPostgres(getConnection());
    }

    public VinoDao getVinoDao(){return new VinoDaoPostgres(getConnection());}

    public RecensioneDao getRecensioneDao(){return new RecensioneDaoPostgres(getConnection());}

    public PromozioneDao getPromozioneDao(){return new PromozioneDaoPostgres(getConnection());}

    public OrdineDao getOrdineDao(){return new OrdineDaoPostgres(getConnection());}

    public PreferitiDao getPreferitiDao(){return new PreferitiDaoPostgres(getConnection());}

    public CantinaDao getCantinaDao(){return new CantinaDaoPostgres(getConnection());}

    public RichiesteDao getRichiesteDao(){return new RichiesteDaoPostgres(getConnection());}

}
