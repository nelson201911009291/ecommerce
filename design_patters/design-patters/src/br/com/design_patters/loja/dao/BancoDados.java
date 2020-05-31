package br.com.design_patters.loja.dao;

import javax.persistence.EntityManager;
import javax.persistence.Persistence;


public class BancoDados {


    private static BancoDados instancia;
    private EntityManager em;

    private BancoDados() {
        em = Persistence.createEntityManagerFactory("CarrinhoComprasPU").createEntityManager();
    }

    public synchronized static BancoDados getInstancia() {
        if (instancia == null) {
            instancia = new BancoDados();
        }else{
        }
        return instancia;
    }

    public EntityManager getEm() {
        return em;
    }
}
