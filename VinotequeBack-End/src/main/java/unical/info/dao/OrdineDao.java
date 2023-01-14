package unical.info.dao;

import unical.info.model.Ordine;

public interface OrdineDao {
    //public List<Utente> findAll();

    public Ordine findByPrimaryKey(String codiceOrdine);

    public void saveOrUpdate(Ordine utente);

    public void delete(Ordine utente);
}
