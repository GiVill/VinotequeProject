package unical.info.persistenza.dao.postgres;

import unical.info.persistenza.dao.CantinaDao;
import unical.info.persistenza.model.Cantina;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class CantinaDaoPostgres implements CantinaDao {//finito(vedi giu)
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
                cantina.setIndirizzo(rs.getString("indirizzo"));

                cantine.add(cantina);
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
                cantina.setIndirizzo(rs.getString("indirizzo"));


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
    public List<Cantina> findByNameVino(String vino) {//todo se nchiumba è colpa di questa query
        List<Cantina> cantine = new ArrayList<Cantina>();
        String query = "select vino_cantina from vino,cantina where vino.vino_cantina = cantina.id and vino.nome = ?";

        try {
            Statement st = conn.createStatement();
            ResultSet rs = st.executeQuery(query);

            while (rs.next()){
                Cantina cantina = findByPrimaryKey(rs.getLong(1));
                cantine.add(cantina);
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        return cantine;
    }

    @Override
    public void save(Cantina cantina) {
            String insertStr = "INSERT INTO cantina VALUES (DEFAULT,?,?,?)";
            PreparedStatement st;
            try {
                st = conn.prepareStatement(insertStr);
                st.setString(1, cantina.getNome());
                st.setString(2, cantina.getDescrizione());
                st.setString(3, cantina.getIndirizzo());
                st.executeUpdate();

            } catch (SQLException e) {
                throw new RuntimeException(e);
            }
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
        }
    }
}

