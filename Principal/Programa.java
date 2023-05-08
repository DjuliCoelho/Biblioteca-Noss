package Principal;


import java.io.File;
import java.io.FileNotFoundException;
import java.util.Formatter;
import java.util.Scanner;
import java.util.List;
import java.util.ArrayList;
import Principal.model.*;
import Principal.view.*;

public class Programa{

    public static void main(String[] args) throws FileNotFoundException {
    	
    	Catalogo catalogo = new Catalogo();
    	
    	List<Cliente> listaClientes = new ArrayList<>();

        //leitura de arquivos
    	
        String arquivoOrigemLivros = "C:\\Users\\djuli\\OneDrive\\Documentos\\gravaArq\\BibliotecaDoLeo\\livros.csv";
		File arquivoLivros = new File(arquivoOrigemLivros);
		Scanner leitorLivros = new Scanner(arquivoLivros);
		
		String arquivoOrigemClientes = "C:\\Users\\djuli\\OneDrive\\Documentos\\gravaArq\\BibliotecaDoLeo\\clientes.csv";
		File arquivoCliente = new File(arquivoOrigemClientes);
		Scanner leitorClientes = new Scanner(arquivoCliente);

		String headerLivros = leitorLivros.nextLine();
		String headerClientes = leitorClientes.nextLine();

        while(leitorLivros.hasNextLine()) {
        	String linha = leitorLivros.nextLine();
        	String[] valores = linha.split(";");
        	
        	catalogo.addLivro(new Livro(Integer.parseInt(valores[0]), valores[1], Integer.parseInt(valores[2]), Integer.parseInt(valores[3])));
        }
        
        
        while(leitorClientes.hasNextLine()) {
        	String linha = leitorClientes.nextLine();
        	String[] valores = linha.split(";");
        	
        	listaClientes.add(new Cliente(valores[0], Integer.parseInt(valores[1]), Integer.parseInt(valores[2])));
        	
        }
		
        
        //menu e execução
        
        Menu menu = new Menu(catalogo, listaClientes);
        
        menu.mostrarMenu();
        	
        
        

        
        //gravação de arquivos

        String arquivoDestinoLivros = "C:\\Users\\djuli\\OneDrive\\Documentos\\gravaArq\\BibliotecaDoLeo\\livros.csv";
		Formatter gravador = new Formatter(arquivoDestinoLivros);
		
		gravador.format(headerLivros + "\n");
		for(int i=0; i<catalogo.ultimo(); i++) {
			gravador.format(catalogo.getLivro(i).getId() + ";" + catalogo.getLivro(i).getNome() + ";" + catalogo.getLivro(i).getQuantidade() + ";" + catalogo.getLivro(i).getQteretirada() + ";\n");
		}
		
		String arquivoDestinoClientes = "C:\\Users\\djuli\\OneDrive\\Documentos\\gravaArq\\BibliotecaDoLeo\\clientes.csv";
		Formatter gravadorClientes = new Formatter(arquivoDestinoClientes);
		
		gravadorClientes.format(headerClientes + "\n");
		
		for(Cliente c : listaClientes) {
			gravadorClientes.format(c.getNome() + ";" + c.getEspera() + ";" + c.getRetirado() + ";\n");
		}
       
		leitorClientes.close();
        leitorLivros.close();
        gravador.close();
        gravadorClientes.close();
        
        
            
        
        

    }
}
		        
		        

		    
		
	    
	

		    
		    

	
		    
    

