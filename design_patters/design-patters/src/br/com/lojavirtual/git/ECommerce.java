package br.com.lojavirtual.git;

import java.util.Scanner;

import javax.swing.JFrame;
import javax.swing.JOptionPane;

import br.com.design_patters.loja.controller.CarrinhoComprasController;
import br.com.design_patters.loja.dao.DAOGenerico;
import br.com.design_patters.loja.model.Produto;
import br.com.design_patters.loja.utils.CalculoFrete;
import br.com.design_patters.loja.utils.Frete;

public class ECommerce {

	public static void main(String[] args) {
		CarrinhoComprasController carrinho = new CarrinhoComprasController();
		Frete frete = new Frete();
		JFrame frame = new JFrame("JOptionPane exemplo");
		
		String cep;
		cep = JOptionPane.showInputDialog(null, " Informe o CEP: ");
//		int cep = String.parseInt(numero); // Converte String em Int

		String uf;
		uf = JOptionPane.showInputDialog(null, " Informe o seu Estado: ");
		
		frete = carrinho.calcularFrete(cep);
		String prazoEntrega = carrinho.calcularTempoFrete(uf);
		
		JOptionPane.showMessageDialog(frame, "O valor do frete é: R$ "+frete.getValorFrete() +"\n" +prazoEntrega);
		
		


	}
	
	
}
