package unical.info.persistenza.dao.postgres;

import unical.info.persistenza.DBManager;
import unical.info.persistenza.dao.OrdineDao;
import unical.info.persistenza.model.Ordine;
import unical.info.persistenza.model.Promozione;
import unical.info.persistenza.model.Utente;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class OrdineDaoPostgres implements OrdineDao {
    Connection conn;

    public OrdineDaoPostgres(Connection connection) {
        this.conn =connection;
    }

    @Override
    public List<Ordine> findByUtente(Long utente){

        String query = "select * from ordine where ordine_utente = ?";
        List<Ordine> ordini = new ArrayList<Ordine>();

        try {
            Statement st = conn.createStatement();
            ResultSet rs = st.executeQuery(query);

            while (rs.next()){
                Ordine ordine = new Ordine();

                Utente u  = DBManager.getInstance().getUtenteDao().findByPrimaryKey(rs.getLong("recensione_sommelier"));
                ordine.setOrdine_utente(u);

                ordine.setOrdine_carrello(rs.getString("ordine_carrello"));
                ordine.setMetodo_pag(rs.getString("metodo_pag"));
                ordine.setIndirizzo(rs.getString("indirizzo"));
                ordine.setData(rs.getString("data"));
                ordine.setTotale(rs.getFloat("totale"));
                ordine.setStatus(rs.getString("status"));

                Promozione p = DBManager.getInstance().getPromozioneDao().findByDescrizione(rs.getString("ordine_promozione"));
                ordine.setOrdine_promozione(p);

                ordini.add(ordine);
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }

        return ordini;
    }

    @Override
    public void save(Ordine ordine) {
            String insertStr = "INSERT INTO ordine VALUES (DEFAULT,?,?,?,?,?,?,?,?)";
            PreparedStatement st;
            try {
                st = conn.prepareStatement(insertStr);

                st.setLong(1,ordine.getOrdine_utente().getId());
                st.setString(2,ordine.getOrdine_carrello());
                st.setString(3, ordine.getMetodo_pag());
                st.setString(4, ordine.getIndirizzo());
                st.setString(5, ordine.getData());
                st.setFloat(6, ordine.getTotale());
                st.setString(7, ordine.getStatus());
                st.setLong(8, ordine.getOrdine_promozione().getId());
                st.executeUpdate();

            } catch (SQLException e) {
                throw new RuntimeException(e);
            }
        }

    @Override
    public void delete(Ordine ordine) {
        String query = "DELETE FROM ordine WHERE id = ?";
        try {
            PreparedStatement st = conn.prepareStatement(query);
            st.setLong(1, ordine.getId());
            st.executeUpdate();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }
}
