package br.com.netfood_2.dao;

import br.com.netfood_2.entity.TipoProduto;

/**
 *
 * @author Elisiandro
 */
public class TipoProdutoDao extends GenericDao<TipoProduto, Long> {

    public TipoProdutoDao() {
        super(TipoProduto.class);
    }
}
