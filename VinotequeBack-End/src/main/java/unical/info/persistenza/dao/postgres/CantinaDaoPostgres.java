package unical.info.persistenza.dao.postgres;

import unical.info.persistenza.dao.CantinaDao;
import unical.info.persistenza.model.Cantina;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class CantinaDaoPostgres implements CantinaDao {
    Connection conn;
    public CantinaDaoPostgres(Connection connection) {
        this.conn =connection;
    }

    @Override
    public List<Cantina> findAll() {
        List<Cantina> cantine = new ArrayList<Cantina>();
        String query = "select * from cantina";

        try {
            Statement st = conn.createStatement();
            ResultSet rs = st.executeQuery(query);

            while (rs.next()){
                Cantina cantina = new Cantina();
                cantina.setId(rs.getLong("id"));
                cantina.setNome(rs.getString("nome"));
                cantina.setDescrizione(rs.getString("descrizione"));
                //cantina.setCantina_indirizzo(rs.getLong("Canrina_indirizzo"));
                //todo
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        return cantine;
    }

    @Override
    public Cantina findByName(String nome) {
        Cantina cantina = null;
        String query = "select * from cantina where nome = ?";
        try {
            PreparedStatement st = conn.prepareStatement(query);
            st.setString(1,nome);
            ResultSet rs = st.executeQuery();

            if (rs.next()){
                cantina = new Cantina();
                cantina.setId(rs.getLong("id"));
                cantina.setNome(rs.getString("nome"));
                cantina.setDescrizione(rs.getString("descrizione"));
                //cantina.setCantina_indirizzo(rs.getLong("Canrina_indirizzo"));
                //todo

            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        return cantina;
    }

    @Override
    public Cantina findByPrimaryKey(long id) {
        Cantina cantina = null;
        String query = "select * from cantina where id = ?";
        try {
            PreparedStatement st = conn.prepareStatement(query);
            st.setLong(1,id);
            ResultSet rs = st.executeQuery();

            if (rs.next()){
                cantina = new Cantina();
                cantina.setId(rs.getLong("id"));
                cantina.setNome(rs.getString("nome"));
                cantina.setDescrizione(rs.getString("descrizione"));
                cantina.setIndirizzo(rs.getString("indirizzo"));

            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        return cantina;
    }


    @Override
    public List<Cantina> findByNameVino(String vino) {
        return null;
    }

    @Override
    public void saveOrUpdate(Cantina cantina) {

    }

    @Override
    public void delete(Cantina cantina) {
        String query = "DELETE FROM cantina WHERE id = ?";
        try {
            PreparedStatement st = conn.prepareStatement(query);
            st.setLong(1,cantina.getId());
            st.executeUpdate();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }//todo
    }
}

