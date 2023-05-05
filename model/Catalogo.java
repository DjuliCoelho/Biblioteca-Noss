package Principal.model;
import java.util.ArrayList;
import java.util.List;

public class Catalogo {
	
		private List<Livro> lista = new ArrayList<>();
		
		public void addLivro(Livro livro) {
			lista.add(livro);
		}

	}


