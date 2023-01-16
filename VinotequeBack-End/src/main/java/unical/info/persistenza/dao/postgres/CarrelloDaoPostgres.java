package unical.info.persistenza.dao.postgres;

import unical.info.persistenza.DBManager;
import unical.info.persistenza.dao.CarrelloDao;
import unical.info.persistenza.model.Carrello;
import unical.info.persistenza.model.Utente;

import java.sql.*;
import java.util.List;

public class CarrelloDaoPostgres implements CarrelloDao {
    Connection conn;

    public CarrelloDaoPostgres(Connection connection) {
        this.conn =connection;
    }

    @Override
    public List<Utente> findAll() {
        return null;
    }

    @Override
    public Carrello findByIdUtente(Long IDutente) {
        String query = "select * from carrello where id_utente = ?";
        Carrello carrello = new Carrello();
        try {
            Statement st = conn.createStatement();
            ResultSet rs = st.executeQuery(query);

            while (rs.next()){
                carrello.setId(Long.valueOf("id"));
                Utente utente = DBManager.getInstance().getUtenteDao().findByPrimaryKey(rs.getLong("id_utente"));
                carrello.setId_utente(utente);
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        return carrello;
    }
    @Override
    public void save(Carrello carrello) {
        if (findByIdUtente(Long.valueOf(carrello.getId_utente().getId())) == null){
            String insertStr = "INSERT INTO carrello VALUES (DEFAULT,?)";
            PreparedStatement st;
            try {
                st = conn.prepareStatement(insertStr);

                st.setLong(1, Long.parseLong("id_utente"));

                st.executeUpdate();

            } catch (SQLException e) {
                throw new RuntimeException(e);
            }
        }

    }

    @Override
    public void delete(Carrello carrello, String IDutente) {

    }
}
