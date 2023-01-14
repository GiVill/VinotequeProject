package unical.info.dao;

import unical.info.model.Indirizzo;
import unical.info.model.Utente;
import unical.info.model.Utente_Indirizzo;

import java.util.List;

public interface Utente_IndirizzoDao {
    //public List<Utente> findAll();

    public Indirizzo findByPrimaryKey(String nomeUtente);

    public List<Indirizzo> indirizziDiUnUtente(String utente);

    public Utente findByPrimaryKeyByIndirizzo(String indirizzo);


    public void saveOrUpdate(Utente_Indirizzo UtI, String nomeUtente, String indirizzo);

    public void delete(Utente_Indirizzo UtI, String IDutente);
}
