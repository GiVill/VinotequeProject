package unical.info.persistenza.dao.postgres;

import unical.info.controller.PasswordCrypt;
import unical.info.persistenza.dao.UtenteDao;
import unical.info.persistenza.model.Utente;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;


import static java.lang.String.copyValueOf;
import static java.lang.String.valueOf;

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
                utente.setIndirizzo(rs.getString("indirizzo"));
                utente.setCarrello(rs.getString("carrello"));

                utenti.add(utente);
            }

        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        return utenti;
    }

    @Override
    public void NewUtente(Utente utente) {
        if (findByEmail(utente.getEmail()) == null) {
            String insertStr = "INSERT INTO utente VALUES (DEFAULT,?,?,?,?,?,?,?)";
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
                st.setString(6,utente.getIndirizzo());
                st.setString(7, utente.getCarrello());
                st.executeUpdate();

            } catch (SQLException e) {
                throw new RuntimeException(e);
            }
        }
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
                utente.setIndirizzo(rs.getString("indirizzo"));
                utente.setCarrello(rs.getString("carrello"));

            }
        } catch (SQLException e) {
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
                utente.setIndirizzo(rs.getString("indirizzo"));
                utente.setCarrello(rs.getString("carrello"));

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
            st.setLong(1, utente.getId());
            st.executeUpdate();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    @Override
    public void PromuoviASommelier(Utente utente, int matricola) {
        for (int i = 0; i < matricoleSommelier.length; i++) {
            if (matricola == matricoleSommelier[i]) {
                Long iddacamb = utente.getId();
                //manda notifica all admin
                String updateStr = "UPDATE utente set ruolo = sommelier where id = iddacamb ";
                PreparedStatement st;
                try {
                    st = conn.prepareStatement(updateStr);
                    st.executeUpdate();

                } catch (SQLException e) {
                    throw new RuntimeException(e);
                }
            }
        }
    }
    int[] matricoleSommelier = {219922, 283130, 549172, 393784, 303154};

    @Override
    public void CambioPassword(Utente utente, String password) {
        String passC = password;
        String newPass = p.encode(passC);
        Long idute = utente.getId();
        String updateStr = "UPDATE utente set password = newPass where id = idute";
        PreparedStatement st;
        try {
            st = conn.prepareStatement(updateStr);
            st.executeUpdate();

        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }
}

/*
    @Override
    public void saveOrUpdate(Utente utente) {
        if (findByEmail(utente.getEmail())== null) {
            String insertStr = "INSERT INTO utente VALUES (?,?,?,?,?,?,?,?)";
            PreparedStatement st;
            try {
                st = conn.prepareStatement(insertStr);
                st.setLong(1, myLongVariable);
                st.setString(2, utente.getNome());
                st.setString(3, utente.getCognome());

                String data = valueOf(utente.getData_di_nascita());
                /*if(data.equals("") || data==null)
                {
                    System.out.println("data sbagliata");

                }else if(data.compareTo("31/12/2005")>0){
                    //dovrebbe essere minorenne
                    System.out.println("data sbagliata");
                }
                st.setString(4, String.valueOf(utente.getData_di_nascita()));

                        st.setString(5, utente.getEmail());
                        st.setString(6, utente.getPassword());
                        st.setString(7, numero);
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
 */