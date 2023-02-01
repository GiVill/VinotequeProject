package unical.info.persistenza.dao.postgres;

import unical.info.persistenza.DBManager;
import unical.info.persistenza.dao.RecensioneDao;
import unical.info.model.Recensione;
import unical.info.model.Utente;
import unical.info.model.Vino;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class RecensioneDaoPostgres implements RecensioneDao {
    Connection conn;

    public RecensioneDaoPostgres(Connection connection) {
        this.conn =connection;
    }

    @Override
    public List<Recensione> findAll() {
        List<Recensione> recensioni = new ArrayList<Recensione>();
        String query = "select * from recensione";

        try {
            Statement st = conn.createStatement();
            ResultSet rs = st.executeQuery(query);

            while (rs.next()){
                Recensione recensione = new Recensione();
                recensione.setId(rs.getLong("id"));

                Utente sommelier  = DBManager.getInstance().getUtenteDao().findByPrimaryKey(rs.getLong("recensione_sommelier"));
                recensione.setRecensione_sommelier(sommelier);

                Vino vino = DBManager.getInstance().getVinoDao().findBYPrimaryKey(rs.getLong("recensione_vino"));
                recensione.setRecensione_vino(vino);

                recensione.setData(rs.getString("data"));

                recensioni.add(recensione);
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        return recensioni;
    }

    @Override
    public Recensione findByPrimaryKey(long id) {
        Recensione recensione= null;
        String query = "select * from recensione where id = ?";
        try {
            PreparedStatement st = conn.prepareStatement(query);
            st.setLong(1,id);
            ResultSet rs = st.executeQuery();

            if (rs.next()){
                recensione = new Recensione();
                recensione.setId(rs.getLong("id"));
                Utente sommelier  = DBManager.getInstance().getUtenteDao().findByPrimaryKey(rs.getLong("recensione_sommelier"));
                recensione.setRecensione_sommelier(sommelier);

                Vino vino = DBManager.getInstance().getVinoDao().findBYPrimaryKey(rs.getLong("recensione_vino"));
                recensione.setRecensione_vino(vino);

                recensione.setData(rs.getString("data"));

            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        return recensione;
    }

    @Override
    public List<Recensione> findByVino(long IDvino) {
        List<Recensione> recensioni= new ArrayList<Recensione>();
        String query = "select * from recensione where recensione_vino = ?";
        try {
            PreparedStatement st = conn.prepareStatement(query);
            st.setLong(1,IDvino);
            ResultSet rs = st.executeQuery();

            while (rs.next()){
                Recensione recensione = new Recensione();
                recensione.setId(rs.getLong("id"));
                recensione.setDescrizione(rs.getString("descrizione"));
                Utente sommelier  = DBManager.getInstance().getUtenteDao().findByPrimaryKey(rs.getLong("recensione_sommelier"));
                recensione.setRecensione_sommelier(sommelier);

                Vino vino = DBManager.getInstance().getVinoDao().findBYPrimaryKey(rs.getLong("recensione_vino"));
                recensione.setRecensione_vino(vino);

                recensione.setData(rs.getString("data"));

                recensioni.add(recensione);
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        return recensioni;
    }

    @Override
    public List<Recensione> findBySommelier(long IDutente) {
        List<Recensione> recensioni= new ArrayList<Recensione>();
        String query = "select * from recensione where recensione_sommelier = ?";
        try {
            PreparedStatement st = conn.prepareStatement(query);
            st.setLong(1,IDutente);
            ResultSet rs = st.executeQuery();

            while (rs.next()){
                Recensione recensione = new Recensione();
                recensione.setId(rs.getLong("id"));
                Utente sommelier  = DBManager.getInstance().getUtenteDao().findByPrimaryKey(rs.getLong("recensione_sommelier"));
                recensione.setRecensione_sommelier(sommelier);

                Vino vino = DBManager.getInstance().getVinoDao().findBYPrimaryKey(rs.getLong("recensione_vino"));
                recensione.setRecensione_vino(vino);

                recensione.setData(rs.getString("data"));

                recensioni.add(recensione);
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        return recensioni;
    }

    @Override
    public void save(Recensione recensione) {

            String insertStr = "INSERT INTO recensione VALUES (DEFAULT,?,?,?,?)";
            PreparedStatement st;
            try {
                st = conn.prepareStatement(insertStr);

                st.setString(1,recensione.getDescrizione());
                st.setFloat(2, recensione.getRecensione_sommelier().getId());
                st.setFloat(3, recensione.getRecensione_vino().getId());
                st.setString(4, recensione.getData());

                st.executeUpdate();

            } catch (SQLException e) {
                throw new RuntimeException(e);
            }
        }
    

    @Override
    public void delete(Recensione recensione) {
        String query = "DELETE FROM recensione WHERE id = ?";
        try {
            PreparedStatement st = conn.prepareStatement(query);
            st.setLong(1, recensione.getId());
            st.executeUpdate();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }

    }
}
