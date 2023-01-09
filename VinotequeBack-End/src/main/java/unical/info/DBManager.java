package unical.info;

import unical.info.dao.*;
import unical.info.dao.postgres.*;
import unical.info.model.Utente;

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
                conn = DriverManager.getConnection("jdbc:postgres://localhost:5432/Vinoteque", "postgres", "postgres123");
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

    public MiPiaceDao getMiPiace(){return new MiPiaceDaoPostgres(getConnection());}

    public Metodo_PagamentoDao getMetodo_PagamentoDao(){return new Metodo_pagamentoDaoPostgres(getConnection());}

    public CarrelloDao getCarrelloDao(){return new CarrelloDaoPostgres(getConnection());}

    public CantinaDao getCantinaDao(){return new CantinaDaoPostgres(getConnection());}

}
