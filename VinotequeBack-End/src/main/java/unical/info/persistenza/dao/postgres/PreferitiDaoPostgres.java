package unical.info.persistenza.dao.postgres;

import unical.info.persistenza.DBManager;
import unical.info.persistenza.dao.PreferitiDao;
import unical.info.model.Cantina;
import unical.info.model.Preferiti;
import unical.info.model.Vino;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class PreferitiDaoPostgres implements PreferitiDao {

    Connection conn;
    public PreferitiDaoPostgres(Connection connection) {
        this.conn =connection;
    }
    @Override
    public List<Vino> findByUtente(long id){
        String query = "select * from preferiti where preferiti_utente = ?";
        List<Vino> vini = new ArrayList<Vino>();
        try {
            PreparedStatement st = conn.prepareStatement(query);
            st.setLong(1,id);
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

                Cantina cant = DBManager.getInstance().getCantinaDao().findByPrimaryKey(rs.getLong("vino_cantina"));
                vino.setVino_cantina(cant);

                vini.add(vino);
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        return vini;
    }
/*
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
 */

    @Override
    public void save(Preferiti preferiti) throws SQLException {

            String insertStr = "INSERT INTO preferiti VALUES (?,?)";
            PreparedStatement st;
            try {
                st = conn.prepareStatement(insertStr);

                st.setLong(1, preferiti.getPreferiti_utente().getId());
                st.setLong(2, preferiti.getPreferiti_vino().getId());

                st.executeUpdate();
            } catch (SQLException e) {
                throw new RuntimeException(e);
            }
    }


    @Override
    public void delete(Preferiti preferiti) {
        String query = "DELETE FROM preferiti WHERE preferiti_utente = ? AND preferiti_vino = ?";
        try {
            PreparedStatement st = conn.prepareStatement(query);
            st.setLong(1, preferiti.getPreferiti_utente().getId());
            st.setLong(2,preferiti.getPreferiti_vino().getId());
            st.executeUpdate();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }

    }
}
