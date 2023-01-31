package unical.info.persistenza.dao;

import unical.info.model.Utente;

import java.sql.SQLException;
import java.util.List;

public interface UtenteDao {//finito
    public List<Utente> findAll();

    public Utente findByPrimaryKey(long id) throws SQLException;

    public Utente findByEmail(String id);

    public void NewUtente(Utente utente);

    public void delete(Utente utente);

    public void CambioPassword(Utente utente, String password);

    public void CambioCarrello (long idUtente, String carrello);

    public void aggiornaUtente (Utente utente);



}
