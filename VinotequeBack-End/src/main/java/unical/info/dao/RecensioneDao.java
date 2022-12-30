package unical.info.dao;

import unical.info.model.Recensione;

import java.util.List;

public interface RecensioneDao {
    public List<Recensione> findAll();

    public Recensione findByPrimaryKey(long id);

    public List<Recensione> findByVino(long IDvino);

    public List<Recensione> findBySommelier(long IDutente);

    public void saveOrUpdate(Recensione recensione);

    public void delete(Recensione recensione);
}
