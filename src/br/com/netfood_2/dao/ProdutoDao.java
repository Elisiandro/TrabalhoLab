package br.com.netfood_2.dao;

import br.com.netfood_2.entity.Produto;

/**
 *
 * @author Elisiandro
 */
public class ProdutoDao extends GenericDao<Produto, Long> {

    public ProdutoDao() {
        super(Produto.class);
    }
}
