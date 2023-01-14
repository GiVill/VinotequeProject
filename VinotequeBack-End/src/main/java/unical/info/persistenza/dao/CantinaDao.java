package unical.info.persistenza.dao;

import unical.info.persistenza.model.Cantina;

import java.util.List;

public interface CantinaDao {

    public List<Cantina> findAll();

    public Cantina findByPrimaryKey(long id);

    public Cantina findByName(String nome);

    public List<Cantina> findByNameVino(String vino);

    public void saveCantina(Cantina cantina);

    public void delete(Cantina cantina);
}
