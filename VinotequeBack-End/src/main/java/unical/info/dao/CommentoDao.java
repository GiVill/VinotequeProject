package unical.info.dao;

import unical.info.model.Commento;

import java.util.List;

public interface CommentoDao {
    public List<Commento> findAll();

    public List<Commento> findAllByVino(String vino);

    public List<Commento> findByPrimaryKey(String username);

    public void saveOrUpdate(Commento commento,String vino);

    public void delete(Commento commento,String vino);
}
