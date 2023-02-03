package unical.info.persistenza.dao.postgres;

import unical.info.persistenza.DBManager;
import unical.info.persistenza.dao.RichiesteDao;
import unical.info.model.Richieste;
import unical.info.model.Utente;

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
                richiesta.setMatricola(rs.getString("matricola"));

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
        String query = "select * from richieste where richieste_utente = ?";
        try {
            PreparedStatement st = conn.prepareStatement(query);
            st.setLong(1, idUtente);

            ResultSet rs = st.executeQuery();

            if (rs.next()) {
                richieste = new Richieste();
                richieste.setId(rs.getLong("id"));
                Utente utente  = DBManager.getInstance().getUtenteDao().findByPrimaryKey(rs.getLong("richieste_utente"));
                richieste.setUtente(utente);
                richieste.setMatricola(rs.getString("matricola"));

            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        return richieste;    }

    @Override
    public boolean save(Richieste richieste) {
        if (findByUtente(richieste.getUtente().getId()) == null) {
            String insertStr = "INSERT INTO richieste VALUES (DEFAULT,?,?)";
            PreparedStatement st;
            try {
                st = conn.prepareStatement(insertStr);
                st.setLong(1, richieste.getUtente().getId());
                st.setString(2,richieste.getMatricola());
                st.executeUpdate();

            } catch (SQLException e) {
                throw new RuntimeException(e);
            }
            return true;
        }
        return false;
    }
    @Override
    public boolean delete(Richieste richieste) {
        String query = "DELETE FROM richieste WHERE id = ?";
        try {
            PreparedStatement st = conn.prepareStatement(query);
            st.setLong(1, richieste.getId());
            st.executeUpdate();
        } catch (SQLException e) {
            return false  ;
        }return  true;
    }
    @Override
    public boolean PromuoviASommelier(Richieste richieste) {
        Long iddacamb = richieste.getUtente().getId();
        String updateStr = "UPDATE utente set ruolo = 'SOMMELIER' where id = ? ";
        PreparedStatement st;
        try {
            st = conn.prepareStatement(updateStr);
            st.setLong(1, iddacamb);
            st.executeUpdate();

        }
        catch (SQLException e) {
            return  false;
        }
        DBManager.getInstance().getRichiesteDao().delete(richieste);
        return true;
    }



}
