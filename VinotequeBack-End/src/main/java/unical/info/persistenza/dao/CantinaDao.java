package unical.info.persistenza.dao;

import unical.info.model.Cantina;

import java.util.List;

public interface CantinaDao {

    public List<Cantina> findAll();

    public Cantina findByName(String nome);
    public Cantina findByPrimaryKey(long idCantina);

    public List<Cantina> findByNameVino(String vino);

    public boolean save(Cantina cantina);

    public boolean delete(Cantina cantina);
}
