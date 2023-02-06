package unical.info.persistenza.dao.postgres;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.JsonMappingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import unical.info.util.PasswordCrypt;
import unical.info.model.Carrello;
import unical.info.persistenza.dao.UtenteDao;
import unical.info.model.Utente;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class UtenteDaoPostgres implements UtenteDao {
    Connection conn;
    PasswordCrypt p = new PasswordCrypt();

    public UtenteDaoPostgres(Connection connection) {
        this.conn = connection;
    }

    @Override
    public List<Utente> findAll() {
        List<Utente> utenti = new ArrayList<Utente>();
        String query = "select * from utente";
        try {
            Statement st = conn.createStatement();
            ResultSet rs = st.executeQuery(query);

            while (rs.next()) {
                Utente utente = new Utente();
                utente.setId(rs.getLong("id"));
                utente.setNome(rs.getString("nome"));
                utente.setCognome(rs.getString("cognome"));
                utente.setData_di_nascita(rs.getString("data_di_nascita"));
                utente.setEmail(rs.getString("email"));
                utente.setPassword(rs.getString("password"));
                utente.setRuolo(rs.getString("ruolo"));

                if(rs.getString("carrello").equals(" "))
                {
                    utente.setCarrello(new Carrello(rs.getLong("id"),new ArrayList<>(),new ArrayList<>(),0));}
                else {
                    ObjectMapper objectMapper = new ObjectMapper();
                    Carrello carrello = objectMapper.readValue(rs.getString("carrello"),Carrello.class);
                    utente.setCarrello(carrello);
                }

                utente.setVia(rs.getString("via"));
                utente.setCivico(rs.getString("civico"));
                utente.setCap(rs.getString("cap"));
                utente.setTelefono(rs.getString("telefono"));

                utenti.add(utente);
            }

        } catch (SQLException e) {
            throw new RuntimeException(e);
        } catch (JsonMappingException e) {
            throw new RuntimeException(e);
        } catch (JsonProcessingException e) {
            throw new RuntimeException(e);
        }
        return utenti;
    }

    @Override
    public boolean NewUtente(Utente utente) {
            String insertStr = "INSERT INTO utente VALUES (DEFAULT,?,?,?,?,?,DEFAULT,DEFAULT)";
            PreparedStatement st;
            try {
                st = conn.prepareStatement(insertStr);
                st.setString(1, utente.getNome());
                st.setString(2, utente.getCognome());
                st.setString(3, utente.getData_di_nascita());
                st.setString(4, utente.getEmail());
                String passC = utente.getPassword();
                utente.setPassword(p.encode(passC));
                st.setString(5, utente.getPassword());

                st.executeUpdate();

            } catch (SQLException e) {
                return  false;
            }
        return  true;
        }


    @Override
    public Utente findByPrimaryKey(long id) {
        Utente utente = null;
        String query = "select * from utente where id = ?";
        try {
            PreparedStatement st = conn.prepareStatement(query);
            st.setLong(1, id);
            ResultSet rs = st.executeQuery();

            if (rs.next()) {
                utente = new Utente();
                utente.setId(rs.getLong("id"));
                utente.setNome(rs.getString("nome"));
                utente.setCognome(rs.getString("cognome"));
                utente.setData_di_nascita(rs.getString("data_di_nascita"));
                utente.setEmail(rs.getString("email"));
                utente.setPassword(rs.getString("password"));
                utente.setRuolo(rs.getString("ruolo"));

                if(rs.getString("carrello").equals(" "))
                {
                    utente.setCarrello(new Carrello(rs.getLong("id"),new ArrayList<>(),new ArrayList<>(),0));}
                else {
                    ObjectMapper objectMapper = new ObjectMapper();
                    Carrello carrello = objectMapper.readValue(rs.getString("carrello"),Carrello.class);
                    utente.setCarrello(carrello);
                }

                utente.setVia(rs.getString("via"));
                utente.setCivico(rs.getString("civico"));
                utente.setCap(rs.getString("cap"));
                utente.setTelefono(rs.getString("telefono"));

            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        } catch (JsonMappingException e) {
            throw new RuntimeException(e);
        } catch (JsonProcessingException e) {
            throw new RuntimeException(e);
        }
        return utente;
    }

    @Override
    public Utente findByEmail(String email) {
        Utente utente = null;
        String query = "select * from utente where email = ?";
        try {
            PreparedStatement st = conn.prepareStatement(query);
            st.setString(1, email);
            ResultSet rs = st.executeQuery();

            if (rs.next()) {
                utente = new Utente();
                utente.setId(rs.getLong("id"));
                utente.setNome(rs.getString("nome"));
                utente.setCognome(rs.getString("cognome"));
                utente.setData_di_nascita(rs.getString("data_di_nascita"));
                utente.setEmail(rs.getString("email"));
                utente.setPassword(rs.getString("password"));
                utente.setRuolo(rs.getString("ruolo"));

                if(rs.getString("carrello").equals(" "))
                {
                    utente.setCarrello(new Carrello(rs.getLong("id"),new ArrayList<>(),new ArrayList<>(),0));}
                else {
                    ObjectMapper objectMapper = new ObjectMapper();
                    Carrello carrello = objectMapper.readValue(rs.getString("carrello"),Carrello.class);
                    utente.setCarrello(carrello);
                }

                utente.setVia(rs.getString("via"));
                utente.setCivico(rs.getString("civico"));
                utente.setCap(rs.getString("cap"));
                utente.setTelefono(rs.getString("telefono"));

            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        } catch (JsonMappingException e) {
            throw new RuntimeException(e);
        } catch (JsonProcessingException e) {
            throw new RuntimeException(e);
        }
        return utente;
    }

    @Override
    public boolean delete(Utente utente) {
        String query = "DELETE FROM utente WHERE id = ?";
        try {
            PreparedStatement st = conn.prepareStatement(query);
            st.setLong(1, utente.getId());
            st.executeUpdate();
        } catch (SQLException e) {
            return  false;
        }return  true;
    }
    @Override
    public boolean CambioPassword (Long utente, String password){
        String newPass = p.encode(password);
        String updateStr = "UPDATE utente set password = ? where id = ?";
        PreparedStatement st;
        try {
            st = conn.prepareStatement(updateStr);
            st.setString(1, newPass);
            st.setLong(2, utente);
            st.executeUpdate();

        } catch (SQLException e) {
            return  false;
        }return  true;
    }


    public boolean CambioCarrello (long idUtente, String carrello){

        String updateStr = "UPDATE utente set carrello = ? where id = ?";
        PreparedStatement st;
        try {
            st = conn.prepareStatement(updateStr);
            st.setString(1, carrello);
            st.setLong(2, idUtente);
            st.executeUpdate();

        } catch (SQLException e) {
            return  false;
        }return  true;
    }

    @Override
    public boolean aggiornaUtente(Utente utente) {

        String update = "UPDATE utente set via = ?, civico = ?, cap = ?, telefono = ? where id = ?";
        PreparedStatement st;
        try {
            st = conn.prepareStatement(update);
            st.setString(1,utente.getVia());
            st.setString(2,utente.getCivico());
            st.setString(3,utente.getCap());
            st.setString(4,utente.getTelefono());
            st.setLong(5,utente.getId());
            st.executeUpdate();
        } catch (SQLException e) {
            return false;
        }
        return true;
    }
}



