package br.com.design_patters.loja.patters;

import java.util.List;

import javax.ejb.EJB;

import br.com.design_patters.loja.business.CalculoRN;
import br.com.design_patters.loja.dao.DAOGenerico;
import br.com.design_patters.loja.model.Produto;
import br.com.design_patters.loja.utils.CalculoFrete;

public class ProdutoFacade implements CalculoFrete{
	
	private DAOGenerico dao = new DAOGenerico();
	
	@EJB
	private CalculoRN calculoRN;
	
	
	public String calcularTempoFrete(String estado) {
		return calculoRN.calcularTempoFrete(estado) ;
	}

	@SuppressWarnings("unchecked")
	public List<Produto> preenherListaProduto() {
		return dao.listar(Produto.class);
	}
}
