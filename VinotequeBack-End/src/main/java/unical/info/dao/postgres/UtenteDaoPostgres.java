package unical.info.dao.postgres;

import unical.info.dao.UtenteDao;
import unical.info.model.Utente;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class UtenteDaoPostgres implements UtenteDao {
    Connection conn;

    public UtenteDaoPostgres(Connection connection) {
        this.conn =connection;
    }

    @Override
    public List<Utente> findAll() {
        List<Utente> utenti = new ArrayList<Utente>();
        String query = "select * from utente";
        try {
            Statement st = conn.createStatement();
            ResultSet rs = st.executeQuery(query);

            while (rs.next()){
                Utente utente = new Utente();
                utente.setId(rs.getLong("id"));
                utente.setNome(rs.getString("nome"));
                utente.setCognome(rs.getString("cognome"));
                utente.setEmail(rs.getString("email"));
                utente.setNumero_telefono(rs.getString("numero_telefono"));
                utente.setPassword(rs.getString("password"));
                utente.setRuolo(rs.getString("ruolo"));

                long secs = rs.getDate("data_di_nascita").getTime();
                utente.setData_di_nascita(new java.util.Date(secs));

                utenti.add(utente);
            }

        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        return utenti;
    }

    @Override
    public void saveOrUpdate(Utente utente) {
        if (findByPrimaryKey(utente.getId())== null) {
            String insertStr = "INSERT INTO utente VALUES (?,?,?,?,?,?,?,?)";
            PreparedStatement st;
            try {
                st = conn.prepareStatement(insertStr);
                st.setLong(1, utente.getId());
                st.setString(2, utente.getNome());
                st.setString(3, utente.getCognome());

                long secs = utente.getData_di_nascita().getTime();
                st.setDate(4, new java.sql.Date(secs));

                st.setString(5, utente.getEmail());
                st.setString(6, utente.getPassword());
                st.setString(7, utente.getNumero_telefono());
                st.setString(8, utente.getRuolo());

                st.executeUpdate();

            } catch (SQLException e) {
                throw new RuntimeException(e);
            }
        }else{
            //todo
        }
    }

    @Override
    public Utente findByPrimaryKey(long id)  {
        Utente utente= null;
        String query = "select * from utente where id = ?";
        try {
            PreparedStatement st = conn.prepareStatement(query);
            st.setLong(1,id);
            ResultSet rs = st.executeQuery();

            if (rs.next()){
                utente = new Utente();
                utente.setId(rs.getLong("id"));
                utente.setNome(rs.getString("nome"));
                utente.setCognome(rs.getString("cognome"));
                utente.setEmail(rs.getString("email"));
                utente.setNumero_telefono(rs.getString("numero_telefono"));
                utente.setPassword(rs.getString("password"));
                utente.setRuolo(rs.getString("ruolo"));

                long secs = rs.getDate("data_di_nascita").getTime();
                utente.setData_di_nascita(new java.util.Date(secs));

            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        return utente;
    }

    @Override
    public void delete(Utente utente) {
        String query = "DELETE FROM utente WHERE id = ?";
        try {
            PreparedStatement st = conn.prepareStatement(query);
            st.setLong(1,utente.getId());
            st.executeUpdate();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }//todo
    }
}
