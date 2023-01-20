package unical.info.persistenza.dao;

import unical.info.model.Richieste;

import java.util.List;

public interface RichiesteDao {
    public List<Richieste> findAll();

    public Richieste findByUtente(Long idUtente);

    public void save(Richieste richieste);

    public void delete(Richieste richieste);
}
