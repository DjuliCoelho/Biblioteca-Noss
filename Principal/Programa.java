package Principal;


import java.io.File;
import java.io.FileNotFoundException;
import java.util.Formatter;
import java.util.Scanner;
import java.util.List;
import java.util.ArrayList;
import Principal.model.*;
import Principal.view.*;

import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.Persistence;

public class Programa{

	public static void main(String[] args) {
        EntityManagerFactory emf = Persistence.createEntityManagerFactory("ex_mysql");
        EntityManager em = emf.createEntityManager();

        Catalogo catalogo = new Catalogo();
        List<Cliente> listaClientes = new ArrayList<>();

        // Leitura de entidades do banco de dados
        List<Livro> livros = em.createQuery("SELECT l FROM Livro l", Livro.class).getResultList();
        for (Livro livro : livros) {
            catalogo.addLivro(livro);
        }

        List<Cliente> clientes = em.createQuery("SELECT c FROM Cliente c", Cliente.class).getResultList();
        listaClientes.addAll(clientes);

        // Menu e execução
        Menu menu = new Menu(catalogo, listaClientes);
        menu.mostrarMenu();

        // Gravação de entidades no banco de dados
        em.getTransaction().begin();
        for (Livro livro : catalogo.getLivros()) {
            em.persist(livro);
        }
        for (Cliente cliente : listaClientes) {
            em.persist(cliente);
        }
        em.getTransaction().commit();

        em.close();
        emf.close();
    }
}
		    
		
	    
	

		    
		    

	
		    
    

