package unical.info.dao;

import unical.info.model.Carrello;
import unical.info.model.Commento;

public interface CarrelloDao {

    //public List<Utente> findAll();

    public Carrello findByPrimaryKey(String IDutente);

    public void saveOrUpdate(Carrello carrello,String IDutente);

    public void delete(Carrello carrello,String IDutente);
}
