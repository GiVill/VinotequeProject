package unical.info.persistenza.dao.postgres;

import unical.info.persistenza.dao.OrdineDao;
import unical.info.persistenza.model.Ordine;

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
                ordine.setOrdine_utente(Long.valueOf("ordine_utente"));
                ordine.setOrdine_carrello(Long.valueOf("ordine_carrello"));
                ordine.setOrdine_metodo_pag("ordine_metodo_pag");
                ordine.setIndirizzo("indirizzo");
                ordine.setTotale(Float.valueOf("totale"));
                ordine.setStatus("status");
                ordine.setOrdine_promozione(Long.valueOf("ordine_promozione"));
                ordine.setData("data");
                ordini.add(ordine);
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }

        return ordini;
    }

    @Override
    public void save(Ordine ordine) {
        if (findByUtente(ordine.getOrdine_utente()) == null){
            String insertStr = "INSERT INTO utente VALUES (DEFAULT,?,?,?,?,?,?,?,?)";
            PreparedStatement st;
            try {
                st = conn.prepareStatement(insertStr);

                st.setLong(1, Long.parseLong("ordine_utente"));
                st.setLong(2, Long.parseLong("ordine_carrello"));
                st.setString(3,"ordine_metodo_pag");
                st.setString(4,"indirizzo");
                st.setFloat(5, Float.parseFloat("totale"));
                st.setString(6,"status");
                st.setLong(7, Long.parseLong("ordine_promozione"));
                st.setString(8,"data");
                st.executeUpdate();

            } catch (SQLException e) {
                throw new RuntimeException(e);
            }
        }


    }

    @Override
    public void delete(Ordine utente) {

    }
}
