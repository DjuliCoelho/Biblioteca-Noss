package Principal.daos;

import java.util.List;

import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.Persistence;
import Principal.model.Livro;

public class LivroDAO implements DAO<Livro> {

	private EntityManager em;
	private EntityManagerFactory emf;

	public LivroDAO() {
		emf = Persistence.createEntityManagerFactory("ex_mysql");
		em = emf.createEntityManager();
	}

	public Livro buscarPorId(Integer id) {
		Livro livro = em.find(Livro.class, id);
		return livro;
	}

	public List<Livro> listar() {
		List<Livro> lista = em.createQuery("from Livro", Livro.class)
		                      .getResultList();
		return lista;
	}

	public Integer salvar(Livro livro) {
		em.getTransaction().begin();
		em.persist(livro);
		em.getTransaction().commit();
		return livro.getId();
	}

	public Integer atualizar(Livro livro) {
		em.getTransaction().begin();
		em.merge(livro);
		em.getTransaction().commit();
		return livro.getId();
	}

	public void apagar(Integer id) {
		Livro livro = em.find(Livro.class, id);
		em.getTransaction().begin();
		em.remove(livro);
		em.getTransaction().commit();
	}

	public void close() {
		em.close();
		emf.close();
	}
}

