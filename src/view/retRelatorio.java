package view;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class retRelatorio
 */
@WebServlet("/retRelatorio")
public class retRelatorio extends HttpServlet {
	private static final long serialVersionUID = 1L;
       

    public retRelatorio() {
        super();
    
    }


	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException
	{
		
		String tipoRelatorio = (String) request.getAttribute("tipoRelatorio");
		System.out.println(tipoRelatorio);
		String arquivo="1";
		arquivo="arquivo.txt";


		FileReader fr = new FileReader("F:\\Arquivos HD\\Java Web\\workspaces\\ProjetoCarteiraWeb\\carteiraWewbJsp\\"+arquivo);
		BufferedReader br = new BufferedReader(fr);
		PrintWriter out = response.getWriter();
		String dadosDoBanco[] = new String[10];
		int cont = 0; 
		String str; 
		out.print("<html><head><link rel='stylesheet' type='text/css' href='arquivo.css' media='screen'></head>" 
				+ "<button type='button' onClick='window.print()' id='btn-salvar'> Imprimir / Salvar  </button><h4 align='center'>Relatorio de Vendas!</h4><html>");

		while((str = br.readLine()) != null)
		{ 

			dadosDoBanco[cont] = str;
			out.print("<html>"+dadosDoBanco[cont]+"<br><hr><html>");
			cont++; 
		
		}

	}


	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
