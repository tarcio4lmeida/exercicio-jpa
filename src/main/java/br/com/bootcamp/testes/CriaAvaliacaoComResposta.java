package br.com.bootcamp.testes;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

import br.com.bootcamp.modelo.Aluno;
import br.com.bootcamp.modelo.Avaliacao;
import br.com.bootcamp.modelo.Resposta;

public class CriaAvaliacaoComResposta {
	public static void main(String[] args) {
		EntityManagerFactory emf = Persistence.createEntityManagerFactory("bootcamp");
		EntityManager em = emf.createEntityManager();

		// Seleciona aluno
		Aluno aluno = em.find(Aluno.class, 1L);
		// Seleciona avaliacao
		Avaliacao avaliacao = em.find(Avaliacao.class, 1l);
		
		Resposta resposta = new Resposta();
		resposta.setSolucao("O java é uma linguagem de programacao antiga porém bastante utilizada até hoje.");
		resposta.setAluno(aluno);
		resposta.setAvaliacao(avaliacao);
		
		em.getTransaction().begin();

		em.persist(resposta);

		em.getTransaction().commit();
	}
}
