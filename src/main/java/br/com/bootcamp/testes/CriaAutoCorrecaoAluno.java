package br.com.bootcamp.testes;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

import br.com.bootcamp.modelo.AutoCorrecao;
import br.com.bootcamp.modelo.Resposta;

public class CriaAutoCorrecaoAluno {
	public static void main(String[] args) {
		EntityManagerFactory emf = Persistence.createEntityManagerFactory("bootcamp");
		EntityManager em = emf.createEntityManager(); 
		
		// Seleciona resposta
		Resposta resposta = em.find(Resposta.class, 1l);
		
		AutoCorrecao autoCorrecao = new AutoCorrecao();
		autoCorrecao.setResposta(resposta);
		autoCorrecao.setNota(10);
		
		em.getTransaction().begin();
		
		em.persist(autoCorrecao);
		
		em.getTransaction().commit();
	}
}

