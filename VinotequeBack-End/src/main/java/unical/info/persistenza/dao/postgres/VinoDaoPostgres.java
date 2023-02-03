package unical.info.persistenza.dao.postgres;

import unical.info.persistenza.DBManager;
import unical.info.persistenza.dao.VinoDao;
import unical.info.model.Cantina;
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
    public boolean save(Vino vino) {
        if (findByNome(vino.getNome())== null) {
            String insertStr = "INSERT INTO vino VALUES (DEFAULT,?,?,?,?,?,?,?,?,?,?)";
            PreparedStatement st;
            try {
                st = conn.prepareStatement(insertStr);

                st.setString(1, vino.getNome());
                st.setInt(2, vino.getAnnata());
                st.setFloat(3, vino.getPrezzo());
                st.setInt(4, vino.getGradazione_alcolica());
                st.setLong(5, vino.getVino_cantina().getId());
                st.setString(6, vino.getTipologia());
                st.setString(7, vino.getPremi());
                st.setBytes(8, vino.getFoto());
                st.setString(9, vino.getDescrizione());
                st.setString(10,vino.getVigneto());

                st.executeUpdate();

            } catch (SQLException e) {
                return false;
            }
        }return  true;
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
                vino.setPrezzo(rs.getFloat("prezzo"));
                vino.setGradazione_alcolica(rs.getInt("gradazione_alcolica"));
                vino.setTipologia(rs.getString("tipologia"));
                vino.setPremi(rs.getString("premi"));
                vino.setFoto(rs.getBytes("foto"));
                vino.setDescrizione(rs.getString("descrizione"));
                Cantina cantina = DBManager.getInstance().getCantinaDao().findByPrimaryKey(rs.getLong("vino_cantina"));
                vino.setVino_cantina(cantina);
                vino.setVigneto(rs.getString("vigneto"));
                vini.add(vino);
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        return vini;
    }

    @Override
    public List<Vino> findByCantina(long cantina) {//todo
        List<Vino> vini = new ArrayList<Vino>();
        String query = "select * from vino where vino_cantina = ? ";

        try {
            PreparedStatement st = conn.prepareStatement(query);
            st.setLong(1,cantina);
            ResultSet rs = st.executeQuery();

            while (rs.next()){
                Vino vino = new Vino();
                vino.setId(rs.getLong("id"));
                vino.setNome(rs.getString("nome"));
                vino.setAnnata(rs.getInt("annata"));
                vino.setPrezzo(rs.getFloat("prezzo"));
                vino.setGradazione_alcolica(rs.getInt("gradazione_alcolica"));
                vino.setTipologia(rs.getString("tipologia"));
                vino.setPremi(rs.getString("premi"));
                vino.setFoto(rs.getBytes("foto"));
                vino.setDescrizione(rs.getString("descrizione"));
                Cantina canti = DBManager.getInstance().getCantinaDao().findByPrimaryKey(rs.getLong("vino_cantina"));
                vino.setVino_cantina(canti);
                vino.setVigneto(rs.getString("vigneto"));
                vini.add(vino);
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        return vini;
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
                vino.setPrezzo(rs.getFloat("prezzo"));
                vino.setGradazione_alcolica(rs.getInt("gradazione_alcolica"));
                vino.setTipologia(rs.getString("tipologia"));
                vino.setPremi(rs.getString("premi"));
                vino.setFoto(rs.getBytes("foto"));
                vino.setDescrizione(rs.getString("descrizione"));
                Cantina cantina = DBManager.getInstance().getCantinaDao().findByPrimaryKey(rs.getLong("vino_cantina"));
                vino.setVino_cantina(cantina);
                vino.setVigneto(rs.getString("vigneto"));

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
            PreparedStatement st = conn.prepareStatement(query);
            st.setInt(1,annata);
            ResultSet rs = st.executeQuery();

            while (rs.next()){
                Vino vino = new Vino();
                vino.setId(rs.getLong("id"));
                vino.setNome(rs.getString("nome"));
                vino.setAnnata(rs.getInt("annata"));
                vino.setPrezzo(rs.getFloat("prezzo"));
                vino.setGradazione_alcolica(rs.getInt("gradazione_alcolica"));
                vino.setTipologia(rs.getString("tipologia"));
                vino.setPremi(rs.getString("premi"));
                vino.setFoto(rs.getBytes("foto"));
                vino.setDescrizione(rs.getString("descrizione"));
                Cantina cantina = DBManager.getInstance().getCantinaDao().findByPrimaryKey(rs.getLong("vino_cantina"));
                vino.setVino_cantina(cantina);
                vino.setVigneto(rs.getString("vigneto"));
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
            PreparedStatement st = conn.prepareStatement(query);
            st.setString(1,tipologia);
            ResultSet rs = st.executeQuery();

            while (rs.next()){
                Vino vino = new Vino();
                vino.setId(rs.getLong("id"));
                vino.setNome(rs.getString("nome"));
                vino.setAnnata(rs.getInt("annata"));
                vino.setPrezzo(rs.getFloat("prezzo"));
                vino.setGradazione_alcolica(rs.getInt("gradazione_alcolica"));
                vino.setTipologia(rs.getString("tipologia"));
                vino.setPremi(rs.getString("premi"));
                vino.setFoto(rs.getBytes("foto"));
                vino.setDescrizione(rs.getString("descrizione"));
                Cantina cantina = DBManager.getInstance().getCantinaDao().findByPrimaryKey(rs.getLong("vino_cantina"));
                vino.setVino_cantina(cantina);
                vino.setVigneto(rs.getString("vigneto"));
                vini.add(vino);
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        return vini;

    }

    @Override
    public List<Vino> findRandomWine() {
        List<Vino> vini = new ArrayList<Vino>();
        String query = "select * from vino where vino.id in (select recensione_vino from recensione)order by random() limit 3";
        try {
            Statement st = conn.createStatement();
            ResultSet rs = st.executeQuery(query);

            while (rs.next()){
                Vino vino = new Vino();
                vino.setId(rs.getLong("id"));
                vino.setNome(rs.getString("nome"));
                vino.setAnnata(rs.getInt("annata"));
                vino.setPrezzo(rs.getFloat("prezzo"));
                vino.setGradazione_alcolica(rs.getInt("gradazione_alcolica"));
                vino.setTipologia(rs.getString("tipologia"));
                vino.setPremi(rs.getString("premi"));
                vino.setFoto(rs.getBytes("foto"));
                vino.setDescrizione(rs.getString("descrizione"));
                Cantina cantina = DBManager.getInstance().getCantinaDao().findByPrimaryKey(rs.getLong("vino_cantina"));
                vino.setVino_cantina(cantina);
                vino.setVigneto(rs.getString("vigneto"));
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
        String query = "select * from vino where gradazione > ?";

        try {
            PreparedStatement st = conn.prepareStatement(query);
            st.setInt(1,gradazione);
            ResultSet rs = st.executeQuery();

            while (rs.next()){
                Vino vino = new Vino();
                vino.setId(rs.getLong("id"));
                vino.setNome(rs.getString("nome"));
                vino.setAnnata(rs.getInt("annata"));
                vino.setPrezzo(rs.getFloat("prezzo"));
                vino.setGradazione_alcolica(rs.getInt("gradazione_alcolica"));
                vino.setTipologia(rs.getString("tipologia"));
                vino.setPremi(rs.getString("premi"));
                vino.setFoto(rs.getBytes("foto"));
                vino.setDescrizione(rs.getString("descrizione"));
                Cantina cantina = DBManager.getInstance().getCantinaDao().findByPrimaryKey(rs.getLong("vino_cantina"));
                vino.setVino_cantina(cantina);
                vino.setVigneto(rs.getString("vigneto"));
                vini.add(vino);
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        return vini;
    }

    @Override
    public List<Vino> findRangePrezzo(int prezzoMin, int prezzoMax) {
        List<Vino> vini = new ArrayList<Vino>();
        String query = "select * from vino where prezzo => ? and prezzo <= ?";

        try {
            PreparedStatement st = conn.prepareStatement(query);
            st.setInt(1,prezzoMin);
            st.setInt(2,prezzoMax);
            ResultSet rs = st.executeQuery();

            while (rs.next()){
                Vino vino = new Vino();
                vino.setId(rs.getLong("id"));
                vino.setNome(rs.getString("nome"));
                vino.setAnnata(rs.getInt("annata"));
                vino.setPrezzo(rs.getFloat("prezzo"));
                vino.setGradazione_alcolica(rs.getInt("gradazione_alcolica"));
                vino.setTipologia(rs.getString("tipologia"));
                vino.setPremi(rs.getString("premi"));
                vino.setFoto(rs.getBytes("foto"));
                vino.setDescrizione(rs.getString("descrizione"));
                Cantina cantina = DBManager.getInstance().getCantinaDao().findByPrimaryKey(rs.getLong("vino_cantina"));
                vino.setVino_cantina(cantina);
                vino.setVigneto(rs.getString("vigneto"));
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
                vino.setPrezzo(rs.getFloat("prezzo"));
                vino.setGradazione_alcolica(rs.getInt("gradazione_alcolica"));
                vino.setTipologia(rs.getString("tipologia"));
                vino.setPremi(rs.getString("premi"));
                vino.setFoto(rs.getBytes("foto"));
                vino.setDescrizione(rs.getString("descrizione"));
                Cantina cantina = DBManager.getInstance().getCantinaDao().findByPrimaryKey(rs.getLong("vino_cantina"));
                vino.setVino_cantina(cantina);
                vino.setVigneto(rs.getString("vigneto"));

            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        return vino;
    }

    @Override
    public boolean delete(Vino vino) {
        String query = "DELETE FROM vino WHERE id = ?";
        try {
            PreparedStatement st = conn.prepareStatement(query);
            st.setLong(1,vino.getId());
            st.executeUpdate();
        } catch (SQLException e) {
            return  false;
        }
        return  true;
    }
}
