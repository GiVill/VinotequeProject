package unical.info.dao;

import unical.info.model.Recensione;

import java.util.List;

public interface RecensioneDao {
    public List<Recensione> findAll();

    public List<Recensione> findByPrimaryKey(String username);

    public List<Recensione> findByVino(String IDvino);

    public List<Recensione> findBySommelier(String IDutente);

    public void saveOrUpdate(Recensione recensione);

    public void delete(Recensione recensione);
}
