package br.com.bootcamp.testes;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.TypedQuery;

import br.com.bootcamp.modelo.AutoCorrecao;

public class SelecionarAutoCorrecaoAluno {
	public static void main(String[] args) {

		// Caso você precise carregar uma auto correção e tenha que descobrir o nome
		// do(a) aluno(a) que fez,
		// como você faria? Algum ponto de atenção que deveria ter?

		EntityManagerFactory emf = Persistence.createEntityManagerFactory("bootcamp");
		EntityManager em = emf.createEntityManager();

		AutoCorrecao autoCorrecao = new AutoCorrecao();
		autoCorrecao.setId(1L);

		TypedQuery<String> query = em.createQuery(
				"select a.resposta.aluno.nome from AutoCorrecao a " + "where a = :pAutoCorrecao", String.class);
		query.setParameter("pAutoCorrecao", autoCorrecao);

		List<String> nomeAluno = query.getResultList();

		System.out.println("Aluno: " + nomeAluno);

	}
}
