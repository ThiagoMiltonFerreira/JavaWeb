package Controller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import Model.LancamentoDeVendas;
import Model.SalvaNoTxt;
/**
 * Servlet implementation class ProcessaLancamentoDeCompra
 */
@WebServlet("/ProcessaLancamentoDeCompra")
public class ProcessaLancamentoDeCompra extends HttpServlet {
	private static final long serialVersionUID = 1L;

    public ProcessaLancamentoDeCompra() {
        super();
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {


		String opc =  request.getParameter("crudLancVenda");
		String codProduto="codProduto";
		String produto="Produto";
		int quantidade=0;
		double precoUnitario=0;
		double total=0;
		int campoAlterar=10;
		String novoValorAlterar=null;
		String descProduto="DescProd";
		String radioPagto="RadioPagto";
		int quantidadeParcelas=0;
		String destinoProdutoComprado="DestProd";

		if(opc.equals("1"))
		{
			codProduto =  request.getParameter("txtLancVendasCodigo");
			campoAlterar =  Integer.parseInt(request.getParameter("qualCampoAlterar"));
			novoValorAlterar=null;
			produto = request.getParameter("txtLancVendasProduto");
			quantidade =  Integer.parseInt(request.getParameter("txtLancVendasQuantidade"));
			precoUnitario = Double.parseDouble(request.getParameter("txtLancVendasPrecoUnitario"));
			total = Double.parseDouble(request.getParameter("txtLancVendasTotal"));
			radioPagto = request.getParameter("radioPagamento");
			quantidadeParcelas =  Integer.parseInt(request.getParameter("txtParcelas"));
			descProduto =  request.getParameter("txtAreaDescricao");
			destinoProdutoComprado =  request.getParameter("txtDestProdutoComprado");
			
		}
		else if(opc.equals("3"))
		{
			
			campoAlterar =Integer.parseInt(request.getParameter("qualCampoAlterar"));
			codProduto= request.getParameter("txtLancVendasCodigo");
			//produto = request.getParameter("txtLancVendasProduto");
			

			
			
			switch (campoAlterar) 
			{
			

				case 1:
					
					//novoConteudo =arrayvalorQueRecebiDaPesquisa[0]+";"+valorAlterar+";"+arrayvalorQueRecebiDaPesquisa[2]+";"+ arrayvalorQueRecebiDaPesquisa[3]+";"+Double.parseDouble(arrayvalorQueRecebiDaPesquisa[4])+";"+arrayvalorQueRecebiDaPesquisa[5]+";"+arrayvalorQueRecebiDaPesquisa[6];
					produto = request.getParameter("txtLancVendasProduto");
					novoValorAlterar = produto;
					break;
				case 2:
					quantidade =  Integer.parseInt(request.getParameter("txtLancVendasQuantidade"));
		            novoValorAlterar = String.valueOf(quantidade);
					break;
				case 3:
					precoUnitario = Double.parseDouble(request.getParameter("txtLancVendasPrecoUnitario"));
					novoValorAlterar = String.valueOf(precoUnitario);
					break;
				case 4:
					total = Double.parseDouble(request.getParameter("txtLancVendasTotal"));
					novoValorAlterar = String.valueOf(total);
					break;
				case 5:
					descProduto =  request.getParameter("txtAreaDescricao");
					novoValorAlterar = descProduto;
					break;
				case 6:
					destinoProdutoComprado =  request.getParameter("txtDestProdutoComprado");
					novoValorAlterar = destinoProdutoComprado;
					break;
			

			}
		
		}		
		else if(opc.equals("2")||opc.equals("4"))
		{
			
			codProduto =  request.getParameter("txtLancVendasCodigo");

		
		}
		
		
		LancamentoDeVendas lancarVenda = new LancamentoDeVendas();		
		String retornoLancamentoCompra = lancarVenda.principal(opc, codProduto,campoAlterar,novoValorAlterar, produto, quantidade, precoUnitario, total, radioPagto, quantidadeParcelas, descProduto, destinoProdutoComprado,"compra.txt");
		
		
		request.setAttribute("codProduto", codProduto); //SETA O ATRIBUTO CONTA COM O VALOR DA CONTA(variavel)
		request.setAttribute("produto", produto);
		request.setAttribute("quantidade", quantidade);
		request.setAttribute("precoUnitario", precoUnitario);
		request.setAttribute("total", total);
		request.setAttribute("radioPagto", radioPagto);
		request.setAttribute("quantidadeParcelas", quantidadeParcelas);
		request.setAttribute("desProduto", descProduto);
		request.setAttribute("retornoLancamentoVenda", retornoLancamentoCompra);
		request.getRequestDispatcher("Retorno.jsp").forward(request,response); //ENVIA PARA MOSTRACONTA.JSP O ATRIBUTO CONTA
		
		
	

		
	}


	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		doGet(request, response);
	}

}
