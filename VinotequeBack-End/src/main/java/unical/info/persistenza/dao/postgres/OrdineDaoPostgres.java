package unical.info.persistenza.dao.postgres;

import unical.info.persistenza.DBManager;
import unical.info.persistenza.dao.OrdineDao;
import unical.info.model.Ordine;
import unical.info.model.Promozione;
import unical.info.model.Utente;

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
            PreparedStatement st = conn.prepareStatement(query);
            st.setLong(1,utente);
            ResultSet rs = st.executeQuery();

            while (rs.next()){
                Ordine ordine = new Ordine();

                ordine.setId(rs.getLong("id"));

                Utente u  = DBManager.getInstance().getUtenteDao().findByPrimaryKey(rs.getLong("ordine_utente"));
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
    public boolean save(Ordine ordine) {
            String insertStr = "INSERT INTO ordine VALUES (DEFAULT,?,?,?,?,?,?,DEFAULT,?)";
            PreparedStatement st;
            try {
                st = conn.prepareStatement(insertStr);
                st.setLong(1,ordine.getOrdine_utente().getId());
                st.setString(2,ordine.getOrdine_carrello());
                st.setString(3, ordine.getMetodo_pag());
                st.setString(4, ordine.getIndirizzo());
                st.setString(5, ordine.getData());
                st.setFloat(6, ordine.getTotale());
                st.setLong(7, ordine.getOrdine_promozione().getId());
                st.execute();
            } catch (SQLException e) {
                e.printStackTrace();
                return  false;
            }return  true;
        }

    @Override
    public boolean delete(Ordine ordine) {
        String query = "DELETE FROM ordine WHERE id = ?";
        try {
            PreparedStatement st = conn.prepareStatement(query);
            st.setLong(1, ordine.getId());
            st.executeUpdate();
        } catch (SQLException e) {
            return  false;
        }return  true;
    }
}
