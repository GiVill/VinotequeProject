package unical.info.dao.postgres;

import unical.info.dao.UtenteDao;
import unical.info.model.Promozione;
import unical.info.model.Utente;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Date;

import static java.lang.String.valueOf;

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
                utente.setData_di_nascita(rs.getString("data_di_nascita"));

                //long secs = rs.getDate("data_di_nascita").getTime();
                //utente.setData_di_nascita(new java.util.Date(secs));

                utenti.add(utente);
            }

        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        return utenti;
    }

    @Override
    public void saveOrUpdate(Utente utente) {
        if (findByEmail(utente.getEmail())== null) {
            String insertStr = "INSERT INTO utente VALUES (?,?,?,?,?,?,?,?)";
            PreparedStatement st;
            try {
                st = conn.prepareStatement(insertStr);
                st.setLong(1, utente.getId());
                st.setString(2, utente.getNome());
                st.setString(3, utente.getCognome());

                String data = valueOf(utente.getData_di_nascita());
                /*if(data.equals("") || data==null)
                {
                    System.out.println("data sbagliata");

                }else if(data.compareTo("31/12/2005")>0){
                    //dovrebbe essere minorenne
                    System.out.println("data sbagliata");
                }*/
                st.setString(4, String.valueOf(utente.getData_di_nascita()));

                st.setString(5, utente.getEmail());
                st.setString(6, utente.getPassword());
                st.setString(7, utente.getNumero_telefono());
                st.setString(8, utente.getIndirizzo());

                st.executeUpdate();

            } catch (SQLException e) {
                throw new RuntimeException(e);
            }
        }else{
            String updateStr = "UPDATE utente set password = ? "
                    + "nome = ? "
                    + "cognome = ? "
                    + "data_nascita = ? "
                    + "ruolo = ? "
                    + "numero_telefono = ? "
                    + "indirizzo = ? "
                    + " where email = ? ";

            PreparedStatement st;
            try {
                st = conn.prepareStatement(updateStr);

                st.setString(1, utente.getPassword());
                st.setString(2, utente.getNome());
                st.setString(3, utente.getCognome());

                //TODO
                //long secs = utente.getDataNascita().getTime();
                //st.setDate(4, new java.sql.Date(secs));
                st.setString(4, String.valueOf(utente.getData_di_nascita()));

                st.setString(5, utente.getRuolo());
                st.setString(6,utente.getNumero_telefono());
                st.setString(7, utente.getIndirizzo());

                st.executeUpdate();

            } catch (SQLException e) {
                // TODO Auto-generated catch block
                e.printStackTrace();
            }

        }
    }

    @Override
    public Utente findByPrimaryKey(long id)  {//da controllare forse si puo cancellare
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

                utente.setData_di_nascita(rs.getString("data_di_nascita"));

                //long secs = rs.getDate("data_di_nascita").getTime();
                //utente.setData_di_nascita(new java.util.Date(secs));

            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        return utente;
    }

    @Override
    public Utente findByEmail(String email) {
        Utente utente= null;
        String query = "select * from utente where email = ?";
        try {
            PreparedStatement st = conn.prepareStatement(query);
            st.setString(1,email);
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
                utente.setData_di_nascita(rs.getString("data_di_nascita"));

                //TODO
                //long secs = rs.getDate("data_di_nascita").getTime();
                //utente.setData_di_nascita(new java.util.Date(secs));

            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        return utente;
    }

    @Override
    public List<Promozione> findByPromotion() {
        return null;
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
