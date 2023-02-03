package unical.info.persistenza.dao;

import unical.info.model.Utente;

import java.sql.SQLException;
import java.util.List;

public interface UtenteDao {//finito
    public List<Utente> findAll();

    public Utente findByPrimaryKey(long id) throws SQLException;

    public Utente findByEmail(String id);

    public boolean NewUtente(Utente utente);

    public boolean delete(Utente utente);

    public boolean CambioPassword(Utente utente, String password);

    public boolean CambioCarrello (long idUtente, String carrello);

    public boolean aggiornaUtente (Utente utente);



}
