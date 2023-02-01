package unical.info.persistenza.dao.postgres;

import unical.info.persistenza.dao.PromozioneDao;
import unical.info.model.Promozione;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class PromozioneDaoPostgres implements PromozioneDao {
    Connection conn;

    public PromozioneDaoPostgres(Connection connection) {
        this.conn =connection;
    }

    @Override
    public List<Promozione> findAll() {
        List<Promozione> promozioni = new ArrayList<Promozione>();
        String query = "select * from promozione";
        try {
            Statement st = conn.createStatement();
            ResultSet rs = st.executeQuery(query);

            while (rs.next()) {
                Promozione promozione = new Promozione();
                promozione.setId(rs.getLong("id"));
                promozione.setDescrizione(rs.getString("descrizione"));
                promozione.setSconto_prezzo(rs.getInt("sconto_prezzo"));

                promozioni.add(promozione);
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        return promozioni;
    }

    @Override
    public Promozione findByDescrizione(String codicePromo) {
        String query = "select * from promozione where descrizione = ?";
        Promozione promozione = new Promozione();
        try {
            PreparedStatement st = conn.prepareStatement(query);
            st.setString(1,codicePromo);
            ResultSet rs = st.executeQuery();

            while (rs.next()){

                promozione.setId(Long.valueOf("id"));
                promozione.setDescrizione("descrizione");
                promozione.setSconto_prezzo(rs.getInt("sconto_prezzo"));
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        return promozione;
    }

    @Override
    public void save(Promozione promo) {
        if (findByDescrizione(promo.getDescrizione()) == null){
            String insertStr = "INSERT INTO promozione VALUES (DEFAULT,?,?)";
            PreparedStatement st;
            try {
                st = conn.prepareStatement(insertStr);

                st.setString(1,promo.getDescrizione());
                st.setFloat(2, promo.getSconto_prezzo());

                st.executeUpdate();

            } catch (SQLException e) {
                throw new RuntimeException(e);
            }
        }

    }

    @Override
    public void delete(Promozione promozione) {
        String query = "DELETE FROM promozione WHERE id = ?";
        try {
            PreparedStatement st = conn.prepareStatement(query);
            st.setLong(1, promozione.getId());
            st.executeUpdate();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }
}
