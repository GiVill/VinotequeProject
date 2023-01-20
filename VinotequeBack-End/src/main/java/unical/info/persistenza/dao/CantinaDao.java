package unical.info.persistenza.dao;

import unical.info.persistenza.model.Cantina;

import java.util.List;

public interface CantinaDao {

    public List<Cantina> findAll();

    public Cantina findByName(String nome);
    public Cantina findByPrimaryKey(long idCantina);

    public List<Cantina> findByNameVino(String vino);

    public void save(Cantina cantina);

    public void delete(Cantina cantina);
}
