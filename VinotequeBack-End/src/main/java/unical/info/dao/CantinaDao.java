package unical.info.dao;

import unical.info.model.Cantina;

import java.util.List;

public interface CantinaDao {

    public List<Cantina> findAll();

    public Cantina findByName(String nome);

    public List<Cantina> findByNameVino(String vino);

    public void saveOrUpdate(Cantina cantina);

    public void delete(Cantina cantina);
}
