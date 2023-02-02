package unical.info.persistenza.dao;

import unical.info.model.Vino;

import java.util.List;

public interface VinoDao {
    public void save(Vino vino);

    public List<Vino> findAll();

    public List<Vino> findByCantina(long cantina);

    public Vino findByNome(String vino);

    public List<Vino> findBYAnnata(int annata);

    public Vino findBYPrimaryKey(long id);

    public List<Vino> findRangePrezzo(int prezzoMin,int prezzoMax);

    public List<Vino> findByGradazione(int gradazione);

    public List<Vino> findByTipologia(String tipologia);

    public List<Vino> findRandomWine();

    public void delete(Vino vino);
}
