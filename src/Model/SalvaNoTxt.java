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
import java.util.ArrayList;
import java.util.List;


import javax.swing.JOptionPane;

public class SalvaNoTxt 
{
	
   // File arquivo = new File("F:\\Arquivos HD\\Java Web\\workspaces\\ProjetoCarteiraWeb\\carteiraWewbJsp\\arquivo.txt");
   // File arquivo2 = new File("C:\\Users\\Adm\\Desktop\\trabalho Prog web\\JavaWeb\\TrabalhoJava\\arquivoTmp.txt");
	File arquivo;
    public String insereDadosNoTxt(String codProduto,String produto, int quantidade, double precoUnitario, double total, int pagamento, int parcelas, String descProduto, String destProduto, String arquivoDeDados)
    {
    	arquivo = new File("F:\\Arquivos HD\\Java Web\\workspaces\\ProjetoCarteiraWeb\\carteiraWewbJsp\\"+arquivoDeDados);
		    String textoCompleto="";  

		    
		    try 
		    {
		      arquivo.createNewFile();

		        
			    //escreve no arquivo
			    FileWriter fw = new FileWriter(arquivo, true);
			    BufferedWriter bw = new BufferedWriter(fw);
			    textoCompleto =codProduto+";"+produto+";"+quantidade+";"+precoUnitario+";"+total+";"+descProduto+";"+pagamento+";"+parcelas+";"+destProduto;
			    bw.write(textoCompleto);
			    bw.newLine();
			    bw.close();
			    fw.close();
			    return "Inserido com sucesso!";
			    //System.out.println("Inserido com sucesso!");
		   
		    }
		    catch(Exception e) 
			{
			    //System.out.println(e.getMessage());
			    //JOptionPane.showMessageDialog(null,"Erro ao inserir dados no txt" ,e.getMessage(), JOptionPane.ERROR_MESSAGE);
		    	return  "catch linha 51 salva no txt - Erro ao inserir dados no txt";
			}	     
    }
    
    
    public String pesquisa(String codProduto,  String arquivoDeDados) throws IOException
    {
    		arquivo = new File("F:\\Arquivos HD\\Java Web\\workspaces\\ProjetoCarteiraWeb\\carteiraWewbJsp\\"+arquivoDeDados);
	    	
    		FileReader fr = null; 
	    	try 
	    	{
	    		fr = new FileReader(this.arquivo);
	    		
			} 
	    	catch (FileNotFoundException e) 
	    	{
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
	    		 
	    	BufferedReader br = new BufferedReader(fr);
	    	int vezesQueRodou=0;
	    	
	    	while (br.ready()) 
	 		{
		 		   String linha = br.readLine()+";"+String.valueOf(vezesQueRodou);
		 		   //String linhaRecebidaDaBase=linha;
		 		   //System.out.println(linha);
		 		   String[] arrayLinhaDoBanco = linha.split(";"); //gera um array separandoas posiçoes quando encontra um ponto e virgula.
		 		      
		 		   if(codProduto.equals(arrayLinhaDoBanco[0]))
		 		   {
		 			   return linha;
		 			   
		 		   }
	 		   
		 	   vezesQueRodou++;
		        
	 		 }
	    	
		return null;
	 		
    } 
    
    public String[] pesquisaTodosDados(String arquivoDeDados) throws IOException
    {
    	FileReader fr = new FileReader("F:\\Arquivos HD\\Java Web\\workspaces\\ProjetoCarteiraWeb\\carteiraWewbJsp\\"+arquivoDeDados);
        BufferedReader br = new BufferedReader(fr);
 		String dadosDoBanco[] = new String[10];
 		int cont = 0;
        String str;
        while((str = br.readLine()) != null){
            //System.out.println(str + "\n");
        	//System.out.println(dadosDoBanco[cont]);
        	dadosDoBanco[cont] = str;        	
        	cont++;
        	
        }  
        
        return dadosDoBanco;
        
        
        
 		 
    	
    } 
    

   //classes com errro nao esta alterando/ excluido 
  //NAO ALTEROU alteraçao é feita no objeto lancamento de vendas linha opc3 (linha129)
    	public String alterar(String caminhoTxt,int linhaAserRemovida,String novoConteudo,String arquivoDeDados) throws IOException
    	{

    		//nao Alterou
    		
	    		Path path = Paths.get("F:\\Arquivos HD\\Java Web\\workspaces\\ProjetoCarteiraWeb\\carteiraWewbJsp\\"+arquivoDeDados);
	    		List<String> linhas  = Files.readAllLines(path);
	    		linhas.add(0,novoConteudo);
	    		linhas.remove(0);
				Files.write(path,linhas);
			    
    
				return "Alterado";	
    	}
    	
 // NAO ESTA FUNCIONANO NAO  REMOVE exclusao feira no objeto lançamento de venda ((ELSE DA OPC4))
    	
        public String remove( String caminhoTxt,String linhaAserRemovida ) throws IOException 
        {
            Path path = Paths.get("F:\\Arquivos HD\\Java Web\\workspaces\\ProjetoCarteiraWeb\\carteiraWewbJsp\\arquivo.txt");
            List<String> linhas = Files.readAllLines(path);

        	linhas.remove(Integer.parseInt(linhaAserRemovida));
        	//Files.write(path, linhas);
            System.out.println("removido!");
            return null;
        	
        }

}
    
    
	
	
	
	
	
	
	
	

