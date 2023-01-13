package unical.info.dao;

import unical.info.model.Carrello;
import unical.info.model.Utente;

import java.util.List;

public interface CarrelloDao {

    public List<Utente> findAll();

    public Carrello findByPrimaryKey(String IDutente);

    public void saveOrUpdate(Carrello carrello,String IDutente);

    public void delete(Carrello carrello,String IDutente);
}
