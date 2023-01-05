package unical.info.dao.postgres;

import unical.info.dao.PromozioneDao;
import unical.info.model.Promozione;

import java.sql.Connection;
import java.util.List;

public class PromozioneDaoPostgres implements PromozioneDao {
    Connection conn;

    public PromozioneDaoPostgres(Connection connection) {
        this.conn =connection;
    }

    @Override
    public List<Promozione> findAll() {
        return null;
    }

    @Override
    public Promozione findByPrimaryKey(String codicePromo) {
        return null;
    }

    @Override
    public void saveOrUpdate(Promozione utente) {

    }

    @Override
    public void delete(Promozione utente) {

    }
}
