package unical.info.dao;

import unical.info.model.Vino;

import java.util.List;

public interface VinoDao {
    public void saveOrUpdate(Vino vino);

    public List<Vino> findAll();

    public List<Vino> findByPrimaryKeyByCantina(String cantina);

    public Vino findByPrimaryKeyByNome(String vino);

    public List<Vino> findByPrimaryKeyByAnnata(int annata);

    public List<Vino> findRangePrezzo(int prezzoMin,int prezzoMax);

    public List<Vino> findByPrimaryKeyByGradazione(int gradazione);

    public List<Vino> findPlusCommenti();

    public List<Vino> findPlusRecensioni();

    public List<Vino> findByPrimaryKeyByTipologia(String tipologia);

    public void delete(Vino vino);
}
