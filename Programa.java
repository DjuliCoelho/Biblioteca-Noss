package Principal;
import Principal.model.*;
import java.io.File;
import java.io.FileNotFoundException;
import java.util.Formatter;
import java.util.Scanner;
public class Programa {
	private static final Menu Livros = null;

	public static void main(String[] args) throws FileNotFoundException {
	

		    
		        //leitura de arquivos
		        String arquivoOrigemLivros = "C:\\Users\\djuli\\OneDrive\\Documentos\\gravaArq\\BibliotecaDoLeo\\Catalogos";
				File arquivo = new File(arquivoOrigemLivros);
				Scanner leitor = new Scanner(arquivo);
				String arquivoOrigemClientes = "C:\\Users\\djuli\\OneDrive\\Documentos\\gravaArq\\BibliotecaDoLeo\\Clientes";
				File arquivoClientes = new File(arquivoOrigemClientes);
				Scanner leitorClientes = new Scanner(arquivoClientes);

		        //gravação de arquivos

		        String arquivoDestinoLivros = "C:\\Users\\djuli\\OneDrive\\Documentos\\gravaArq\\BibliotecaDoLeo\\Catalogos";
				Formatter gravador = new Formatter(arquivoDestinoLivros);
		        while(leitor.hasNextLine()) {
					String linha = leitor.nextLine();
					String[] vetor = linha.split(";");
					
					//Imprimir no console/terminal
					System.out.println("Banco: " + linha);
					
					//Gravar no arquivo de destino
					gravador.format("Banco: " + linha + "\n");
					gravador.format("\n");
		        }

		    		
		    		Menu menu = new Menu(Livros);
		    		menu.mostrarMenu();
		    		
		    		
		    		
		    		Livro livro = new Livro(0, null, 0, 0);
		    		livro.getLivros();
		    		
		    	}
		    

		       
		       
		        
		            
		        
		        

		    }
		
	    
	

		    
		    

	
		    
    

