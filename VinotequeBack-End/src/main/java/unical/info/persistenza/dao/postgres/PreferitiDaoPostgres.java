package unical.info.persistenza.dao.postgres;

import unical.info.persistenza.DBManager;
import unical.info.persistenza.dao.MiPiaceDao;
import unical.info.persistenza.model.Cantina;
import unical.info.persistenza.model.MiPiace;
import unical.info.persistenza.model.Utente;
import unical.info.persistenza.model.Vino;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class MiPiaceDaoPostgres implements MiPiaceDao {

    Connection conn;
    public MiPiaceDaoPostgres(Connection connection) {
        this.conn =connection;
    }
    @Override
    public List<Vino> findAll() {
        return null;
    }

    @Override
    public List<Vino> findByUtente(long id) throws SQLException {
        String query = "select * from mipiace where mipiace_utente = ?";
        List<Vino> vini = new ArrayList<Vino>();
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

                Cantina cant = DBManager.getInstance().getCantinaDao().findByPrimaryKey(rs.getLong("vino_cantina"));
                vino.setVino_cantina(cant);

                vini.add(vino);
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        return vini;
    }

    @Override
    public int countByVino(long id) throws SQLException {
        String query = "select * from mipiace where mipiace_vino = ?";
        int count=0;
        try {
            Statement st = conn.createStatement();
            ResultSet rs = st.executeQuery(query);

            while (rs.next()){
                count+=1;
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        return count;
    }



    @Override
    public boolean newMiPiace(long idUtente, long idVino) throws SQLException {
        String query = "select * from mipiace where mipiace_utente = ? AND mipiace_vino = ?";
        Boolean cond = false;
        try {
            Statement st = conn.createStatement();
            ResultSet rs = st.executeQuery(query);

            while (rs.next()){
                cond=true;
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }

        return cond;
    }

    @Override
    public void save(MiPiace mipiace,long idUtente,long idVino) throws SQLException {
        if (newMiPiace(idUtente,idVino)==false){
            String insertStr = "INSERT INTO mipiace VALUES (?,?)";
            PreparedStatement st;
            try {
                st = conn.prepareStatement(insertStr);

                st.setLong(1, Long.parseLong("mipiace_utente"));
                st.setLong(2, Long.parseLong("mipiace_vino"));

                st.executeUpdate();

            } catch (SQLException e) {
                throw new RuntimeException(e);
            }
        }

    }


    @Override
    public void delete(Utente utente) {

    }
}
