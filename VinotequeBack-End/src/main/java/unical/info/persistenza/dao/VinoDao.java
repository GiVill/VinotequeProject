package unical.info.persistenza.dao;

import unical.info.model.Vino;

import java.util.List;

public interface VinoDao {
    public boolean save(Vino vino);

    public List<Vino> findAll();

    public List<Vino> findByCantina(long cantina);

    public Vino findByNome(String vino);

    public List<Vino> findBYAnnata(int annata);

    public Vino findBYPrimaryKey(long id);

    public List<Vino> findMaxPrezzoRosso(int prezzoMax);

    public List<Vino> findByGradazioneRosso(int gradazione);

    public List<Vino> findMaxPrezzoBianco(int prezzoMax);

    public List<Vino> findByGradazioneBianco(int gradazione);

    public List<Vino> findMaxPrezzoRose(int prezzoMax);

    public List<Vino> findByGradazioneRose(int gradazione);

    public List<Vino> findMaxPrezzo(int prezzoMax);

    public List<Vino> findByGradazione(int gradazione);
    public List<Vino> findByTipologia(String tipologia);

    public List<Vino> findRandomWine();

    public boolean delete(Vino vino);
}
