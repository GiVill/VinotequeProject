package unical.info.dao;

import unical.info.model.Indirizzo;

import java.util.List;

public interface IndirizzoDao {
    //public List<Utente> findAll();

    public List<Indirizzo> findByPrimaryKey(String IDutente);

    public void saveOrUpdate(Indirizzo indirizzo,String utente);

    public void delete(Indirizzo indirizzo,String utente);
}
