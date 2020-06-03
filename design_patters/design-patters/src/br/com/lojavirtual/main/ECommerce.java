package br.com.lojavirtual.main;

import java.util.Scanner;

import javax.inject.Inject;
import javax.swing.JFrame;
import javax.swing.JOptionPane;

import br.com.design_patters.loja.controller.CarrinhoComprasController;
import br.com.design_patters.loja.dao.DAOGenerico;
import br.com.design_patters.loja.model.Frete;
import br.com.design_patters.loja.model.Produto;
import br.com.design_patters.loja.strategy.CalculoFrete;

public class ECommerce {

	public static void main(String[] args) {
		CarrinhoComprasController carrinho = new CarrinhoComprasController();
		int valorTotal, condi��odepagamento;
		String valor, condicao; 

        Scanner numeros = new Scanner(System.in);

        System.out.println("");

        valor = JOptionPane.showInputDialog(null, " digite o Pre�o da Etiqueta R$: ");
        valorTotal = Integer.parseInt(valor);

        System.out.println("digite a condi��o de pagamento");

        condicao = JOptionPane.showInputDialog(null,"digite a condi��o de pagamento"+"\n"+ "1 -A vista em dinheiro ou cheque,recebe 10% de desconto " +"\n"
                		+"2 -A vista no cart�o de cr�dito, recebe 5% de desconto" +"\n"
                		+"3 -em duas vezes,pre�o normal da etiqueta sem juros" +"\n"
                		+"4 -em tres vezes, pre�o normal da etiqueta mas juros de 10%");
        
        condi��odepagamento = Integer.parseInt(condicao);
        
//        condi��odepagamento = carrinho.calcularValorPagamento(condi��odepagamento, valorTotal);

        switch (condi��odepagamento) {

        case 1:

            condi��odepagamento = (int) (valorTotal - valorTotal*0.10); 

            break;

        case 2:

            condi��odepagamento = (int) (valorTotal - valorTotal*0.05);

            break;

        case 3:

            condi��odepagamento = valorTotal / +0;

            break;

        case 4:
            condi��odepagamento = (int) (valorTotal  + valorTotal*0.10);

            break;

        default:
            System.out.println("op��o invalida");

        }// fim do metodo switch

        System.out.println("o valor da etiqueta � R$:" + condi��odepagamento);

    
		
		
		
		Frete frete = new Frete();
		String prazoEntrega = "";
		
		
		
		String cep;
		cep = JOptionPane.showInputDialog(null, " Informe o CEP: ");
//		int cep = String.parseInt(numero); // Converte String em Int

		String uf;
		uf = JOptionPane.showInputDialog(null, " Informe o seu Estado: ");
		
		frete = carrinho.calcularFrete(cep);
		prazoEntrega = carrinho.calcularTempoFrete(uf);
		
		JOptionPane.showMessageDialog(null,"o valor total da compra � R$:" + condi��odepagamento +"\n"+ "O valor do frete �: R$ "+frete.getValorFrete() +"\n" +prazoEntrega);
		


	}
	
	
}
