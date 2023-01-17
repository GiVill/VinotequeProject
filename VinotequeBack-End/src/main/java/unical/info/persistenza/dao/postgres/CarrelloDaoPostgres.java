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
        return null;
    }
    /*
    @Override
    public Carrello findByIdUtente(Long IDutente) {
        String query = "select * from carrello where id_utente = ?";
        try {
            Statement st = conn.createStatement();
            ResultSet rs = st.executeQuery(query);

            while (rs.next()){
                Long id = rs.getLong("id");
                Utente utente = DBManager.getInstance().getUtenteDao().findByPrimaryKey(rs.getLong("id_utente"));
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        return carrello;
    }
    */

    @Override
    public void save(Carrello carrello) throws SQLException {
        if (findByIdUtente(Long.valueOf(carrello.getCarrello_utente().getId())) == null){
            String sql = "INSERT INTO carrello (id ,carrello_vino, quantita,carrello_utente) VALUES (DEFAULT,?, ?, ?)";
            PreparedStatement stmt = conn.prepareStatement(sql);
            for (Long vino : carrello.getProdotto().keySet()){
                int quantita = carrello.getProdotto().get(vino);
                stmt.setLong(1,vino);
                stmt.setInt(2,quantita);
                stmt.setLong(3,carrello.getCarrello_utente().getId());
                stmt.addBatch();
            }
            stmt.executeBatch();
        }

    }

    @Override
    public void delete(Carrello carrello, String IDutente) {

    }
}
