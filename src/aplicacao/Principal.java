package aplicacao;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Locale;

import entidades.Produto;

public class Principal {

	public static void main(String[] args) {
		
		Locale.setDefault(Locale.US);
		List<Produto> listaProduto = new ArrayList<>();
		
		String caminho = "C:\\Users\\Leandro\\Documents\\itens.csv";
	
		File arquivo = new File(caminho);
		String caminhoArquivo = arquivo.getParent();
		
		boolean pastaCriada = new File(caminhoArquivo + "\\out").mkdir();
		
		try (BufferedReader br = new BufferedReader(new FileReader(arquivo))){
			
			do {
				String[] posicao = br.readLine().split(",");
				double valor = Double.parseDouble(posicao[1]);
				int quantidade = Integer.parseInt(posicao[2]);
				Produto produto = new Produto(posicao[0], valor, quantidade);
				listaProduto.add(produto);
			} while (br.ready());
			
		}
		catch (IOException e) {
			System.out.println("Erro: " + e.getMessage());
		}
		finally {
			try (BufferedWriter bw = new BufferedWriter(new FileWriter(caminhoArquivo + "\\out\\summary.csv"))) {
				for (Produto cd : listaProduto) {
					bw.write(cd.toString());
					bw.newLine();
				}
			}
			catch (IOException e){
				System.out.println("Erro: " + e.getMessage());
			}
		}
	}
}
