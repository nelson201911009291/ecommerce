package br.com.design_patters.loja.dao;

import java.lang.reflect.Method;
import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.Query;

public class DAOGenerico {

	EntityManager em;
	
	public EntityManager getEntityManager() {
	    EntityManagerFactory factory = Persistence.createEntityManagerFactory("ExemplosJPAPU");
	    em = factory.createEntityManager();
	    factory.close();

	    return em;
	  }

	public List listar(Class classe) {
		Query q = null;
		try {
			em = BancoDados.getInstancia().getEm();
			em.getTransaction().begin();
			q = em.createQuery("from " + classe.getSimpleName());
			em.getTransaction().commit();
		} catch (Exception e) {
			em.getTransaction().rollback();
			e.printStackTrace();
		}
		return q.getResultList();
	}

	public List listaCondicao(Class classe, String condicao) {
		em = BancoDados.getInstancia().getEm();
		em.getTransaction().begin();
		Query q = em.createQuery("from " + classe.getSimpleName() + " where " + condicao);
		em.getTransaction().commit();
		return q.getResultList();
	}

	public void inserir(Object marca) {
		getEntityManager();
		try {
			em = BancoDados.getInstancia().getEm();
			em.getTransaction().begin();
			em.persist(marca);
			em.getTransaction().commit();
		} catch (Exception e) {
			em.getTransaction().rollback();
			e.printStackTrace();
		}
	}

	public void exluir(Object objeto) throws Exception {
		try {
			em = BancoDados.getInstancia().getEm();
			em.getTransaction().begin();
			Method getChave = objeto.getClass().getMethod("getId", new Class[0]);
			objeto = em.find(objeto.getClass(), getChave.invoke(objeto, new Object[0]));
			em.remove(objeto);
			em.getTransaction().commit();
		} catch (Exception e) {
			em.getTransaction().rollback();
			e.printStackTrace();
		}

	}

	public void alterar(Object objeto) {
		em = BancoDados.getInstancia().getEm();
		em.getTransaction().begin();
		em.merge(objeto);
		em.getTransaction().commit();
	}

	public Object recupera(Class classe, Long id) {
		em = BancoDados.getInstancia().getEm();
		Object retornando = null;
		em.getTransaction().begin();
		retornando = em.find(classe, id);
		em.getTransaction().commit();
		return retornando;
	}
}
