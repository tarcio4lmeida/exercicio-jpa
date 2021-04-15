package br.com.bootcamp.testes;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

import br.com.bootcamp.modelo.Aluno;

public class CriaAluno {
	public static void main(String[] args) {
		EntityManagerFactory emf = Persistence.createEntityManagerFactory("bootcamp");
		EntityManager em = emf.createEntityManager(); 
		
		Aluno aluno = new Aluno();
		aluno.setNome("Tarcio Almeida");
		aluno.setEmail("tarcio.lima@zup.com.br");
		
		em.getTransaction().begin();
		
		em.persist(aluno);
		
		em.getTransaction().commit();
	}
}

