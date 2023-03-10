package unical.info.persistenza.dao.postgres;

import unical.info.persistenza.dao.RecensioneDao;
import unical.info.persistenza.model.Recensione;

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
                recensione.setRecensione_sommelier(rs.getLong("Recensione_sommelier"));
                recensione.setRecensione_vino(rs.getLong("recensione_vino"));

                long secs = rs.getDate("data").getTime();
                recensione.setData(new java.util.Date(secs));

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
                recensione.setRecensione_sommelier(rs.getLong("Recensione_sommelier"));
                recensione.setRecensione_vino(rs.getLong("recensione_vino"));

                long secs = rs.getDate("data").getTime();
                recensione.setData(new java.util.Date(secs));

            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        return recensione;
    }

    @Override
    public List<Recensione> findByVino(long IDvino) {
        List<Recensione> recensioni= new ArrayList<Recensione>();
        String query = "select * from recensioni where recensione_vino = ?";
        try {
            Statement st = conn.createStatement();
            ResultSet rs = st.executeQuery(query);

            while (rs.next()){
                Recensione recensione = new Recensione();
                recensione.setId(rs.getLong("id"));
                recensione.setRecensione_sommelier(rs.getLong("Recensione_sommelier"));
                recensione.setRecensione_vino(rs.getLong("recensione_vino"));

                long secs = rs.getDate("data").getTime();
                recensione.setData(new java.util.Date(secs));

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
        String query = "select * from recensioni where recensione_sommelier = ?";
        try {
            Statement st = conn.createStatement();
            ResultSet rs = st.executeQuery(query);

            while (rs.next()){
                Recensione recensione = new Recensione();
                recensione.setId(rs.getLong("id"));
                recensione.setRecensione_sommelier(rs.getLong("Recensione_sommelier"));
                recensione.setRecensione_vino(rs.getLong("recensione_vino"));

                long secs = rs.getDate("data").getTime();
                recensione.setData(new java.util.Date(secs));

                recensioni.add(recensione);
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        return recensioni;
    }

    @Override
    public void save(Recensione recensione) {
        if (findByVino(recensione.getRecensione_vino()) == null && findBySommelier(recensione.getRecensione_sommelier())==null) {
            String insertStr = "INSERT INTO utente VALUES (DEFAULT,?,?,?,?)";
            PreparedStatement st;
            try {
                st = conn.prepareStatement(insertStr);

                st.setString(1,recensione.getDescrizione());
                st.setFloat(2, recensione.getRecensione_sommelier());
                st.setFloat(3, recensione.getRecensione_vino());
                st.setDate(4, (Date) recensione.getData());

                st.executeUpdate();

            } catch (SQLException e) {
                throw new RuntimeException(e);
            }
        }
    }

    @Override
    public void delete(Recensione recensione) {

    }
}
