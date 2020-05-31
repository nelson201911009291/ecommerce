package br.com.lojavirtual.git;

import java.util.Scanner;

import javax.swing.JFrame;
import javax.swing.JOptionPane;

import br.com.design_patters.loja.controller.CarrinhoComprasController;
import br.com.design_patters.loja.dao.DAOGenerico;
import br.com.design_patters.loja.model.Produto;
import br.com.design_patters.loja.utils.CalculoFrete;
import br.com.design_patters.loja.utils.Frete;

public class HelloGit {

	public static void main(String[] args) {
//		Scanner entrada =  new Scanner(System.in);
//		System.out.println("Informe a distância");
//		int distancia = entrada.nextInt();
		
		
		CalculoFrete carrinho = new CalculoFrete();
		Frete frete = new Frete();

		Scanner entrada =  new Scanner(System.in);
		
		JFrame frame = new JFrame("JOptionPane exemplo");
		
		String cep;
		cep = JOptionPane.showInputDialog(null, " Informe o CEP: ");
//		int cep = String.parseInt(numero); // Converte String em Int

		String uf;
		uf = JOptionPane.showInputDialog(null, " Informe o seu Estado: ");
//		int uf = Integer.parseInt(estado); // Converte String em Int
		
		frete = CalculoFrete.calculaFrete(cep);
		String prazoEntrega = carrinho.CalcularTempoFrete(uf);
		
		JOptionPane.showMessageDialog(frame, "O valor do frete é: R$ "+frete.getValorFrete() +"\n" +prazoEntrega);
		
		
//		System.out.println("Informe o CEP:");
//		String cep = entrada.nextLine();
//		
//		 System.out.println("Digite o seu Estado:");
//	     String uf = entrada.nextLine();
		
//	    frete = CalculoFrete.calculaFrete(cep);
//		System.out.printf("O valor do frete é: R$ " +frete.getValorFrete() +"\n");
//		
//		String prazoEntrega = carrinho.CalcularTempoFrete(uf);
//		System.out.printf(prazoEntrega);

	}
	
	
}
