package unical.info.dao.postgres;

import unical.info.dao.VinoDao;
import unical.info.model.Vino;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class VinoDaoPostgres implements VinoDao{
    Connection conn;

    public VinoDaoPostgres(Connection connection) {
        this.conn =connection;
    }

    @Override
    public void saveOrUpdate(Vino vino) {

    }

    @Override
    public List<Vino> findAll() {
        List<Vino> vini = new ArrayList<Vino>();
        String query = "select * from vino";
        try {
            Statement st = conn.createStatement();
            ResultSet rs = st.executeQuery(query);

            while (rs.next()){
                Vino vino = new Vino();
                vino.setId(rs.getLong("id"));
                vino.setNome(rs.getString("nome"));
                vino.setAnnata(rs.getInt("annata"));
                vino.setPrezzo(rs.getBigDecimal("prezzo"));
                vino.setGradazione_alcolica(rs.getInt("gradazione_alcolica"));
                vino.setTipologia(rs.getString("tipologia"));
                vino.setPremi(rs.getString("premi"));
                vino.setFoto(rs.getByte("foto"));
                //manca vino_cantina
                //todo

                vini.add(vino);
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        return vini;
    }

    @Override
    public List<Vino> findByCantina(String cantina) {
        return null;
    }

    @Override
    public Vino findBYPrimaryKey(long id) {
        Vino vino = null;
        String query = "select * from vino where id= ?";
        try {
            PreparedStatement st = conn.prepareStatement(query);
            st.setLong(1,id);
            ResultSet rs = st.executeQuery();

            if (rs.next()){
                vino = new Vino();
                vino.setId(rs.getLong("id"));
                vino.setNome(rs.getString("nome"));
                vino.setAnnata(rs.getInt("annata"));
                vino.setPrezzo(rs.getBigDecimal("prezzo"));
                vino.setGradazione_alcolica(rs.getInt("gradazione_alcolica"));
                vino.setTipologia(rs.getString("tipologia"));
                vino.setPremi(rs.getString("premi"));
                vino.setFoto(rs.getByte("foto"));
                //todo
                //manca vino_cantina

            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        return vino;
    }

    @Override
    public List<Vino> findBYAnnata(int annata) {
        List<Vino> vini = new ArrayList<Vino>();
        String query = "select * from vino where annata = ?";

        try {
            Statement st = conn.createStatement();
            ResultSet rs = st.executeQuery(query);

            while (rs.next()){
                Vino vino = new Vino();
                vino.setId(rs.getLong("id"));
                vino.setNome(rs.getString("nome"));
                vino.setAnnata(rs.getInt("annata"));
                vino.setPrezzo(rs.getBigDecimal("prezzo"));
                vino.setGradazione_alcolica(rs.getInt("gradazione_alcolica"));
                vino.setTipologia(rs.getString("tipologia"));
                vino.setPremi(rs.getString("premi"));
                vino.setFoto(rs.getByte("foto"));
                //manca vino_cantina
                //todo
                vini.add(vino);
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        return vini;
    }

    @Override
    public List<Vino> findByTipologia(String tipologia) {
        List<Vino> vini = new ArrayList<Vino>();
        String query = "select * from vino where tipologia = ?";

        try {
            Statement st = conn.createStatement();
            ResultSet rs = st.executeQuery(query);

            while (rs.next()){
                Vino vino = new Vino();
                vino.setId(rs.getLong("id"));
                vino.setNome(rs.getString("nome"));
                vino.setAnnata(rs.getInt("annata"));
                vino.setPrezzo(rs.getBigDecimal("prezzo"));
                vino.setGradazione_alcolica(rs.getInt("gradazione_alcolica"));
                vino.setTipologia(rs.getString("tipologia"));
                vino.setPremi(rs.getString("premi"));
                vino.setFoto(rs.getByte("foto"));
                //manca vino_cantina
                //todo
                vini.add(vino);
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        return vini;

    }

    @Override
    public List<Vino> findByGradazione(int gradazione) {
        List<Vino> vini = new ArrayList<Vino>();
        String query = "select * from vino where gradazione = ?";

        try {
            Statement st = conn.createStatement();
            ResultSet rs = st.executeQuery(query);

            while (rs.next()){
                Vino vino = new Vino();
                vino.setId(rs.getLong("id"));
                vino.setNome(rs.getString("nome"));
                vino.setAnnata(rs.getInt("annata"));
                vino.setPrezzo(rs.getBigDecimal("prezzo"));
                vino.setGradazione_alcolica(rs.getInt("gradazione_alcolica"));
                vino.setTipologia(rs.getString("tipologia"));
                vino.setPremi(rs.getString("premi"));
                vino.setFoto(rs.getByte("foto"));
                //manca vino_cantina
                //todo
                vini.add(vino);
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        return vini;
    }

    @Override
    public List<Vino> findPlusRecensioni() {
        return null;
    }

    @Override
    public List<Vino> findRangePrezzo(int prezzoMin, int prezzoMax) {
        List<Vino> vini = new ArrayList<Vino>();
        String query = "select * from vino where prezzo => ? and prezzo <= ?";

        try {
            Statement st = conn.createStatement();
            ResultSet rs = st.executeQuery(query);

            while (rs.next()){
                Vino vino = new Vino();
                vino.setId(rs.getLong("id"));
                vino.setNome(rs.getString("nome"));
                vino.setAnnata(rs.getInt("annata"));
                vino.setPrezzo(rs.getBigDecimal("prezzo"));
                vino.setGradazione_alcolica(rs.getInt("gradazione_alcolica"));
                vino.setTipologia(rs.getString("tipologia"));
                vino.setPremi(rs.getString("premi"));
                vino.setFoto(rs.getByte("foto"));
                //manca vino_cantina
                //todo
                vini.add(vino);
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        return vini;
    }

    @Override
    public Vino findByNome(String nome) {
        Vino vino = null;
        String query = "select * from vino where nome= ?";
        try {
            PreparedStatement st = conn.prepareStatement(query);
            st.setString(1,nome);
            ResultSet rs = st.executeQuery();

            if (rs.next()){
                vino = new Vino();
                vino.setId(rs.getLong("id"));
                vino.setNome(rs.getString("nome"));
                vino.setAnnata(rs.getInt("annata"));
                vino.setPrezzo(rs.getBigDecimal("prezzo"));
                vino.setGradazione_alcolica(rs.getInt("gradazione_alcolica"));
                vino.setTipologia(rs.getString("tipologia"));
                vino.setPremi(rs.getString("premi"));
                vino.setFoto(rs.getByte("foto"));
                //todo
                //manca vino_cantina

            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        return vino;
    }

    @Override
    public void delete(Vino vino) {
        String query = "DELETE FROM vino WHERE id = ?";
        try {
            PreparedStatement st = conn.prepareStatement(query);
            st.setLong(1,vino.getId());
            st.executeUpdate();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }

    }
}
