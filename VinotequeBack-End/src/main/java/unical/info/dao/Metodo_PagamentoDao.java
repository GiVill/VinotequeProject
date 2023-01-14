package unical.info.dao;

import unical.info.model.Metodo_Pagamento;

import java.util.List;

public interface Metodo_PagamentoDao {
    //public List<Utente> findAll();

    public List<Metodo_Pagamento> findByPrimaryKey(String IDutente);

    public void saveOrUpdate(Metodo_Pagamento metodo,String IDutente);

    public void delete(Metodo_Pagamento metodo,String IDutente);
}
