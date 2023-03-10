package unical.info.persistenza.dao;

import unical.info.persistenza.model.Recensione;

import java.util.List;

public interface RecensioneDao {
    public List<Recensione> findAll();

    public Recensione findByPrimaryKey(long id);

    public List<Recensione> findByVino(long IDvino);

    public List<Recensione> findBySommelier(long IDutente);

    public void save(Recensione recensione);

    public void delete(Recensione recensione);
}
