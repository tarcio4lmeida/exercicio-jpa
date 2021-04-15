package br.com.bootcamp.testes;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

import br.com.bootcamp.modelo.Avaliacao;

public class CriaAvaliacaoSemResposta {
	public static void main(String[] args) {
		EntityManagerFactory emf = Persistence.createEntityManagerFactory("bootcamp");
		EntityManager em = emf.createEntityManager(); 
		
		Avaliacao avaliacao = new Avaliacao();
		avaliacao.setTitulo("Java e seus fundamentos");
		avaliacao.setDescricao("Uma breve teoria sobre java");
		
		em.getTransaction().begin();
		
		em.persist(avaliacao);
		
		em.getTransaction().commit();
	}
}

