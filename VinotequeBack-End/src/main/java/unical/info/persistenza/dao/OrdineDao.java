package unical.info.persistenza.dao;

import unical.info.model.Ordine;

import java.util.List;

public interface OrdineDao {
    //public List<Utente> findAll();

    public List<Ordine> findByUtente(Long utente);

    public void save(Ordine ordine);

    public void delete(Ordine utente);
}
