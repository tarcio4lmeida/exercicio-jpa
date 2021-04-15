package br.com.bootcamp.testes;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.TypedQuery;

import br.com.bootcamp.modelo.Aluno;
import br.com.bootcamp.modelo.Resposta;

public class SelecionarRespostasAluno {
	public static void main(String[] args) {

		//Caso voc� precise carregar as respostas de um(a) aluno(a) a partir 
		//do objeto da classe Aluno, como voc� faria? Algum ponto de aten��o?

		EntityManagerFactory emf = Persistence.createEntityManagerFactory("bootcamp");
		EntityManager em = emf.createEntityManager();

		Aluno aluno = new Aluno();
		aluno.setId(1L);

		TypedQuery<Resposta> query = em.createQuery(
				"select r from Resposta r " + "where r.aluno = :pAluno", Resposta.class);
		query.setParameter("pAluno", aluno);

		List<Resposta> respostas = query.getResultList();

		for (Resposta r: respostas) {
			System.out.println("Resposta: " + r.getSolucao() + " Do aluno -> " + r.getAluno().getNome());
		}

	}
}
