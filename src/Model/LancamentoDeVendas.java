package Model;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.List;
import java.util.Scanner;
import javax.swing.JOptionPane;

public class LancamentoDeVendas {


	public String principal(String ParametroOpc,String ParametroCodProduto,int ParametroCampoAlterar,String ParametroNovoValorAlterar,String ParametroProduto,int ParametroQuantidade,double ParametroPrecoUnitario,double ParametroTotal,String ParametroRadioPagto,int ParametroQuantidadeParcelas,String ParametroDesProduto,String ParametroDestProdutoComp,String arquivoDeDados)	
	{
		SalvaNoTxt crud = new SalvaNoTxt();
		int opc =  Integer.parseInt(ParametroOpc);
		
		// entra com a opcao selecionada pelo usuario 
		
		// 1 Salvar
		if(opc == 1) 
		{
			
			String codProduto = ParametroCodProduto ;
			
			String produto =  ParametroProduto;
			
			int quantidade = ParametroQuantidade;
			
			double precoUnitario = ParametroPrecoUnitario;

			double total = precoUnitario*quantidade;
			
			int qtdParcelas = ParametroQuantidadeParcelas;
			
			String descProduto = ParametroDesProduto;
			String destProd = ParametroDestProdutoComp;
			int formaDePagto;
			
			switch (ParametroRadioPagto) 
			{
				case "Dinheiro":
					formaDePagto=1;
					break;
				case "Debito":
					formaDePagto=2;
					break;
				case "Transferencia":
					formaDePagto=3;
					break;
				case "Credito":
					formaDePagto=4;
					break;
				default:
					return "Tipo de pagamento invalido";
					

			}
	
			
			
			String retornoInsere = crud.insereDadosNoTxt(codProduto, produto, quantidade, precoUnitario, total,formaDePagto,qtdParcelas,descProduto,destProd,arquivoDeDados); 
			
			if(retornoInsere.equals("Inserido com sucesso!"))
			{
				return"Inserido com sucesso!";
			}
			else
			{
				return "Erro ao inserir!";
			}
			
			
			
		}

		//2 Pesquisar
		else if(opc == 2) 
		{

			String pesqCodProduto =  ParametroCodProduto;
			
		
			try 
			{
				if(crud.pesquisa(pesqCodProduto,arquivoDeDados)==null) 
				{
					return "Produto nao encontrado!";
					
				}
				else
				{
					return crud.pesquisa(pesqCodProduto,arquivoDeDados);
				}	
			} 
			catch (IOException e)
			{
				
				e.printStackTrace();
			}
			
		}
		
		//3 Alterar
		else if(opc == 3) 
			
		{
			   
			String codigoAltera =  ParametroCodProduto;
			try {
				String valorQueRecebiDaPesquisa = crud.pesquisa(codigoAltera,arquivoDeDados);
				if(valorQueRecebiDaPesquisa==null) 
				{
					return "Codigo Invalido, Produto nao encontrado!";
				}
				else
				{
			
	 		        String[] arrayvalorQueRecebiDaPesquisa = valorQueRecebiDaPesquisa.split(";");

	 		        int posicaoAlterar = ParametroCampoAlterar;
	 		        String valorAlterar = ParametroNovoValorAlterar;
					
					String novoConteudo ="" ;
					switch (posicaoAlterar) {
					case 1:

						novoConteudo = arrayvalorQueRecebiDaPesquisa[0]+";"+valorAlterar+";"+arrayvalorQueRecebiDaPesquisa[2]+";"+ arrayvalorQueRecebiDaPesquisa[3]+";"+Double.parseDouble(arrayvalorQueRecebiDaPesquisa[4])+";"+arrayvalorQueRecebiDaPesquisa[5]+";"+arrayvalorQueRecebiDaPesquisa[6]+";"+arrayvalorQueRecebiDaPesquisa[7]+";"+arrayvalorQueRecebiDaPesquisa[8];
						break;
					case 2:
						novoConteudo =arrayvalorQueRecebiDaPesquisa[0]+";"+arrayvalorQueRecebiDaPesquisa[1]+";"+valorAlterar+";"+ arrayvalorQueRecebiDaPesquisa[3]+";"+Double.parseDouble(arrayvalorQueRecebiDaPesquisa[4])+";"+arrayvalorQueRecebiDaPesquisa[5]+";"+arrayvalorQueRecebiDaPesquisa[6]+";"+arrayvalorQueRecebiDaPesquisa[7]+";"+arrayvalorQueRecebiDaPesquisa[8];

						break;
					case 3:
						novoConteudo =arrayvalorQueRecebiDaPesquisa[0]+";"+arrayvalorQueRecebiDaPesquisa[1]+arrayvalorQueRecebiDaPesquisa[2]+";"+valorAlterar+";"+Double.parseDouble(arrayvalorQueRecebiDaPesquisa[4])+";"+arrayvalorQueRecebiDaPesquisa[5]+";"+arrayvalorQueRecebiDaPesquisa[6]+";"+arrayvalorQueRecebiDaPesquisa[7]+";"+arrayvalorQueRecebiDaPesquisa[8];
					
						break;

					case 5:
						novoConteudo =arrayvalorQueRecebiDaPesquisa[0]+";"+arrayvalorQueRecebiDaPesquisa[1]+arrayvalorQueRecebiDaPesquisa[2]+";"+ arrayvalorQueRecebiDaPesquisa[3]+";"+Double.parseDouble(arrayvalorQueRecebiDaPesquisa[4])+";"+valorAlterar+";"+arrayvalorQueRecebiDaPesquisa[6]+";"+arrayvalorQueRecebiDaPesquisa[7]+";"+arrayvalorQueRecebiDaPesquisa[8];

						break;
					
					default:
						return"Este campo nao pode ser alterado!";
				
					}
	
					Path path = Paths.get("F:\\Arquivos HD\\Java Web\\workspaces\\ProjetoCarteiraWeb\\carteiraWewbJsp\\"+arquivoDeDados);
				    List<String> linhas = Files.readAllLines(path);
				
					linhas.remove(Integer.parseInt(arrayvalorQueRecebiDaPesquisa[9]));
				    linhas.add(Integer.parseInt(arrayvalorQueRecebiDaPesquisa[9]), novoConteudo);
					Files.write(path, linhas);
				    //System.out.println("Alterado!");
				    return "Alterado!";
	
				}	
				
			} 
			catch (IOException e) 
			{
			
				//System.out.println("Erro inesperado try classe lançamento de venda: " + e);
				return ("Erro inesperado try classe lançamento de venda: " + e);
			}
						
			
		}
		//4 - excluir
		else if(opc == 4) 
		{
			
			
			//System.out.println("codigo : ");
			//String codigoPesquisa =  lerDados.next();
			String codigoPesquisa =  ParametroCodProduto;
					
			String retornoPesquisa = null;
			try {
				retornoPesquisa = crud.pesquisa(codigoPesquisa,arquivoDeDados);
			} catch (IOException e) {
				// TODO Auto-generated catch block
				return "Erro ao pesquisar para excluir dado!";
			}
			
			String[] arrayRetornoPesquisa = retornoPesquisa.split(";");
			
			if(retornoPesquisa.equals(null)) 
			{
				//System.out.println("Produto nao encontrado!");
				return "produo nao encontrado";
				
			}
			else // TRECHO ABAIXO EXCLUI LINHA
			{
					
					// ************************AQUI EXCLUI O DADO DO TXT *****************
					Path path = Paths.get("F:\\Arquivos HD\\Java Web\\workspaces\\ProjetoCarteiraWeb\\carteiraWewbJsp\\"+arquivoDeDados);
				    List<String> linhas = null;
					try {
						linhas = Files.readAllLines(path);
					} catch (IOException e) {
						e.printStackTrace();
					}
				
					linhas.remove(Integer.parseInt(arrayRetornoPesquisa[9]));
					try {
						Files.write(path, linhas);
					} catch (IOException e) {
						e.printStackTrace();
					}
				    return "removido!";

			}
		}
		return "Opção invalida!";
	}
}


