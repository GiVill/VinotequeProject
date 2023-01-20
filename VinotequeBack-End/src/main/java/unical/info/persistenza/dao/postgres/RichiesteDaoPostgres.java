package unical.info.persistenza.dao.postgres;

import unical.info.persistenza.DBManager;
import unical.info.persistenza.dao.RichiesteDao;
import unical.info.persistenza.model.Richieste;
import unical.info.persistenza.model.Utente;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class RichiesteDaoPostgres implements RichiesteDao {
    Connection conn;
    public RichiesteDaoPostgres(Connection connection) {
        this.conn = connection;
    }
    @Override
    public List<Richieste> findAll() {
        List<Richieste> richieste = new ArrayList<Richieste>();
        String query = "select * from richieste";
        try {
            Statement st = conn.createStatement();
            ResultSet rs = st.executeQuery(query);

            while (rs.next()) {
                Richieste richiesta = new Richieste();
                richiesta.setId(rs.getLong("id"));
                Utente utente  = DBManager.getInstance().getUtenteDao().findByPrimaryKey(rs.getLong("richieste_utente"));
                richiesta.setUtente(utente);

                richieste.add(richiesta);
            }

        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        return richieste;
    }

    @Override
    public Richieste findByUtente(Long idUtente) {
        Richieste richieste = null;
        String query = "select * from richieste where id = ?";
        try {
            PreparedStatement st = conn.prepareStatement(query);
            st.setLong(1, idUtente);
            ResultSet rs = st.executeQuery();

            if (rs.next()) {
                richieste = new Richieste();
                richieste.setId(rs.getLong("id"));
                Utente utente  = DBManager.getInstance().getUtenteDao().findByPrimaryKey(rs.getLong("richieste_utente"));
                richieste.setUtente(utente);

            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        return richieste;    }

    @Override
    public void save(Richieste richieste) {

    }

    @Override
    public void delete(Richieste richieste) {

    }


}
