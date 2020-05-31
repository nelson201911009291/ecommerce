package br.com.design_patters.loja.patters;

import java.util.List;

import br.com.design_patters.loja.dao.DAOGenerico;
import br.com.design_patters.loja.model.Produto;

public class ProdutoFacade {
	
	private DAOGenerico dao = new DAOGenerico();

	@SuppressWarnings("unchecked")
	public List<Produto> preenherListaProduto() {
		return dao.listar(Produto.class);
	}
}
