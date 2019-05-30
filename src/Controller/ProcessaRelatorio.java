package Controller;

import java.awt.List;
import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import Model.SalvaNoTxt;

/**
 * Servlet implementation class ProcessaRelatorio
 */
@WebServlet("/ProcessaRelatorio")
public class ProcessaRelatorio extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
  
    public ProcessaRelatorio() {
        super();
        
    }


	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException
	{
		String tipoDeRelatorio =  (String) request.getAttribute("qualRelatorio");

		SalvaNoTxt	pesquisaTodosValoreres = new SalvaNoTxt();
		String relatorioComInformacao[]=new String[1000];

		request.setAttribute("tipoRelatorio", "1");

		request.getRequestDispatcher("retornoRelatorio.jsp").forward(request,response);
		
		
		
		
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
