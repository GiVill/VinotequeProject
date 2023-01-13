package unical.info.dao.postgres;

import unical.info.dao.PromozioneDao;
import unical.info.model.Promozione;
import unical.info.model.Recensione;

import java.sql.*;
import java.util.List;

public class PromozioneDaoPostgres implements PromozioneDao {
    Connection conn;

    public PromozioneDaoPostgres(Connection connection) {
        this.conn =connection;
    }

    @Override
    public List<Promozione> findAll() {
        return null;
    }

    @Override
    public Promozione findByDescrizione(String codicePromo) {
        String query = "select * from promozione where descrizione = ?";
        Promozione promozione = new Promozione();
        try {
            Statement st = conn.createStatement();
            ResultSet rs = st.executeQuery(query);

            while (rs.next()){

                promozione.setId(Long.valueOf("id"));
                promozione.setDescrizione("descrizione");
                promozione.setSconto_percentuale(Integer.valueOf("sconto_percentuale"));
                promozione.setSconto_prezzo(Float.valueOf("sconto_prezzo"));
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        return promozione;
    }

    @Override
    public void save(Promozione promo) {
        if (findByDescrizione(promo.getDescrizione()) == null){
            String insertStr = "INSERT INTO utente VALUES (DEFAULT,?,?,?,?)";
            PreparedStatement st;
            try {
                st = conn.prepareStatement(insertStr);

                st.setString(1,promo.getDescrizione());
                st.setFloat(2, promo.getSconto_prezzo());
                st.setInt(3, promo.getSconto_percentuale());

                st.executeUpdate();

            } catch (SQLException e) {
                throw new RuntimeException(e);
            }
        }

    }

    @Override
    public void delete(Promozione utente) {

    }
}
