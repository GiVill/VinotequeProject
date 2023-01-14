package unical.info.persistenza.dao.postgres;

import unical.info.persistenza.DBManager;
import unical.info.persistenza.dao.VinoDao;
import unical.info.persistenza.model.Cantina;
import unical.info.persistenza.model.Utente;
import unical.info.persistenza.model.Vino;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class VinoDaoPostgres implements VinoDao{
    Connection conn;

    public VinoDaoPostgres(Connection connection) {
        this.conn =connection;
    }

    @Override
    public void save(Vino vino) {
        if (findByNome(vino.getNome())== null) {
            String insertStr = "INSERT INTO utente VALUES (DEFAULT,?,?,?,?,?,?,?,?,?)";
            PreparedStatement st;
            try {
                st = conn.prepareStatement(insertStr);

                st.setString(1, vino.getNome());
                st.setInt(2, vino.getAnnata());
                st.setFloat(3, vino.getPrezzo());
                st.setInt(4, vino.getGradazione_alcolica());

                //TODO controllare
                st.setLong(5, vino.getVino_cantina().getId());

                st.setString(6, vino.getTipologia());
                st.setString(7, vino.getPremi());
                st.setBytes(8, vino.getFoto());
                st.setInt(9, vino.getMipiace());

                st.executeUpdate();

            } catch (SQLException e) {
                throw new RuntimeException(e);
            }
        }
    }

    @Override
    public List<Vino> findAll() {
        List<Vino> vini = new ArrayList<Vino>();
        String query = "select * from vino";
        try {
            Statement st = conn.createStatement();
            ResultSet rs = st.executeQuery(query);

            while (rs.next()){
                Vino vino = new Vino();
                vino.setId(rs.getLong("id"));
                vino.setNome(rs.getString("nome"));
                vino.setAnnata(rs.getInt("annata"));
                vino.setPrezzo(rs.getFloat("prezzo"));
                vino.setGradazione_alcolica(rs.getInt("gradazione_alcolica"));
                vino.setTipologia(rs.getString("tipologia"));
                vino.setPremi(rs.getString("premi"));
                vino.setFoto(rs.getBytes("foto"));

                Cantina cant = DBManager.getInstance().getCantinaDao().findByPrimaryKey(rs.getLong("vino_cantina"));
                vino.setVino_cantina(cant);

                vini.add(vino);
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        return vini;
    }

    @Override
    public List<Vino> findByCantina(String cantina) {
        return null;
    }

    @Override
    public Vino findBYPrimaryKey(long id) {
        Vino vino = null;
        String query = "select * from vino where id= ?";
        try {
            PreparedStatement st = conn.prepareStatement(query);
            st.setLong(1,id);
            ResultSet rs = st.executeQuery();

            if (rs.next()){
                vino = new Vino();
                vino.setId(rs.getLong("id"));
                vino.setNome(rs.getString("nome"));
                vino.setAnnata(rs.getInt("annata"));
                vino.setPrezzo(rs.getFloat("prezzo"));
                vino.setGradazione_alcolica(rs.getInt("gradazione_alcolica"));
                vino.setTipologia(rs.getString("tipologia"));
                vino.setPremi(rs.getString("premi"));
                vino.setFoto(rs.getBytes("foto"));

                Cantina cant = DBManager.getInstance().getCantinaDao().findByPrimaryKey(rs.getLong("vino_cantina"));
                vino.setVino_cantina(cant);

            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        return vino;
    }

    @Override
    public List<Vino> findBYAnnata(int annata) {
        List<Vino> vini = new ArrayList<Vino>();
        String query = "select * from vino where annata = ?";

        try {
            Statement st = conn.createStatement();
            ResultSet rs = st.executeQuery(query);

            while (rs.next()){
                Vino vino = new Vino();
                vino.setId(rs.getLong("id"));
                vino.setNome(rs.getString("nome"));
                vino.setAnnata(rs.getInt("annata"));
                vino.setPrezzo(rs.getFloat("prezzo"));
                vino.setGradazione_alcolica(rs.getInt("gradazione_alcolica"));
                vino.setTipologia(rs.getString("tipologia"));
                vino.setPremi(rs.getString("premi"));
                vino.setFoto(rs.getBytes("foto"));

                Cantina cant = DBManager.getInstance().getCantinaDao().findByPrimaryKey(rs.getLong("vino_cantina"));
                vino.setVino_cantina(cant);

                vini.add(vino);
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        return vini;
    }

    @Override
    public List<Vino> findByTipologia(String tipologia) {
        List<Vino> vini = new ArrayList<Vino>();
        String query = "select * from vino where tipologia = ?";

        try {
            Statement st = conn.createStatement();
            ResultSet rs = st.executeQuery(query);

            while (rs.next()){
                Vino vino = new Vino();
                vino.setId(rs.getLong("id"));
                vino.setNome(rs.getString("nome"));
                vino.setAnnata(rs.getInt("annata"));
                vino.setPrezzo(rs.getFloat("prezzo"));
                vino.setGradazione_alcolica(rs.getInt("gradazione_alcolica"));
                vino.setTipologia(rs.getString("tipologia"));
                vino.setPremi(rs.getString("premi"));
                vino.setFoto(rs.getBytes("foto"));

                Cantina cant = DBManager.getInstance().getCantinaDao().findByPrimaryKey(rs.getLong("vino_cantina"));
                vino.setVino_cantina(cant);

                vini.add(vino);
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        return vini;

    }

    @Override
    public List<Vino> findByGradazione(int gradazione) {
        List<Vino> vini = new ArrayList<Vino>();
        String query = "select * from vino where gradazione = ?";

        try {
            Statement st = conn.createStatement();
            ResultSet rs = st.executeQuery(query);

            while (rs.next()){
                Vino vino = new Vino();
                vino.setId(rs.getLong("id"));
                vino.setNome(rs.getString("nome"));
                vino.setAnnata(rs.getInt("annata"));
                vino.setPrezzo(rs.getFloat("prezzo"));
                vino.setGradazione_alcolica(rs.getInt("gradazione_alcolica"));
                vino.setTipologia(rs.getString("tipologia"));
                vino.setPremi(rs.getString("premi"));
                vino.setFoto(rs.getBytes("foto"));

                Cantina cant = DBManager.getInstance().getCantinaDao().findByPrimaryKey(rs.getLong("vino_cantina"));
                vino.setVino_cantina(cant);

                vini.add(vino);
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        return vini;
    }

    @Override
    public List<Vino> findPlusRecensioni() {
        return null;
    }

    @Override
    public List<Vino> findRangePrezzo(int prezzoMin, int prezzoMax) {
        List<Vino> vini = new ArrayList<Vino>();
        String query = "select * from vino where prezzo => ? and prezzo <= ?";

        try {
            Statement st = conn.createStatement();
            ResultSet rs = st.executeQuery(query);

            while (rs.next()){
                Vino vino = new Vino();
                vino.setId(rs.getLong("id"));
                vino.setNome(rs.getString("nome"));
                vino.setAnnata(rs.getInt("annata"));
                vino.setPrezzo(rs.getFloat("prezzo"));
                vino.setGradazione_alcolica(rs.getInt("gradazione_alcolica"));
                vino.setTipologia(rs.getString("tipologia"));
                vino.setPremi(rs.getString("premi"));
                vino.setFoto(rs.getBytes("foto"));

                Cantina cant = DBManager.getInstance().getCantinaDao().findByPrimaryKey(rs.getLong("vino_cantina"));
                vino.setVino_cantina(cant);

                vini.add(vino);
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        return vini;
    }

    @Override
    public Vino findByNome(String nome) {
        Vino vino = null;
        String query = "select * from vino where nome= ?";
        try {
            PreparedStatement st = conn.prepareStatement(query);
            st.setString(1,nome);
            ResultSet rs = st.executeQuery();

            if (rs.next()){
                vino = new Vino();
                vino.setId(rs.getLong("id"));
                vino.setNome(rs.getString("nome"));
                vino.setAnnata(rs.getInt("annata"));
                vino.setPrezzo(rs.getFloat("prezzo"));
                vino.setGradazione_alcolica(rs.getInt("gradazione_alcolica"));
                vino.setTipologia(rs.getString("tipologia"));
                vino.setPremi(rs.getString("premi"));
                vino.setFoto(rs.getBytes("foto"));

                Cantina cant = DBManager.getInstance().getCantinaDao().findByPrimaryKey(rs.getLong("vino_cantina"));
                vino.setVino_cantina(cant);


            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        return vino;
    }

    @Override
    public void delete(Vino vino) {
        String query = "DELETE FROM vino WHERE id = ?";
        try {
            PreparedStatement st = conn.prepareStatement(query);
            st.setLong(1,vino.getId());
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
                if(data.equals("") || data==null)
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


                        //long secs = utente.getDataNascita().getTime();
                        //st.setDate(4, new java.sql.Date(secs));
                        st.setString(4, String.valueOf(utente.getData_di_nascita()));

                        st.setString(5, utente.getRuolo());
                        st.setString(6,utente.getNumero_telefono());
                        st.setString(7, utente.getIndirizzo());

                        st.executeUpdate();

                        } catch (SQLException e) {

                        e.printStackTrace();
                        }

                        }
                        }

*/