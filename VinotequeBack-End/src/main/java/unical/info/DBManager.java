package unical.info;

import unical.info.dao.*;
import unical.info.dao.postgres.*;

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
                conn = DriverManager.getConnection("jdbc:postgresql://localhost:5432/", "postgres", "postgres");
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
        return conn;
    }

    public CantinaDao getCantinaDao() {
        return new CantinaDaoPostgres(getConnection());
    }

    public UtenteDao getUtenteDao() {
        return new UtenteDaoPostgres(getConnection());
    }

    public CarrelloDao getCarrelloDao() {
        return new CarrelloDaoPostgres(getConnection());
    }

    public CommentoDao getCommentoDao() {
        return new CommentoDaoPostgres(getConnection());
    }

    public IndirizzoDao getIndirizzoDao() {
        return new IndirizzoDaoPostgres(getConnection());
    }

    public Metodo_PagamentoDao getMetodo_PagamentoDao() {
        return new Metodo_pagamentoDaoPostgres(getConnection());
    }

    public OrdineDao getOrdineDao() {
        return new OrdineDaoPostgres(getConnection());
    }

    public PromozioneDao getPromozioneDao() {
        return new PromozioneDaoPostgres(getConnection());
    }

    public RecensioneDao getRecensioneDao() {
        return new RecensioneDaoPostgres(getConnection());
    }

    public Utente_IndirizzoDao getUtente_IndirizzoDao() {
        return new Utente_IndirizzoDaoPostgres(getConnection());
    }

    public VinoDao getVinoeDao() {
        return new VinoDaoPostgres(getConnection());
    }

}
