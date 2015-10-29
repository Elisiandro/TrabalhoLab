package br.com.netfood_2.rn;

import br.com.netfood_2.dao.GarcomDao;
import br.com.netfood_2.entity.Garcom;
import br.com.netfood_2.rnval.GarcomRNVal;


public class GarcomRN {
    private final GarcomRNVal seriadoRNVal;
    private final GarcomDao garcomDao;

    public GarcomRN() {
        seriadoRNVal = new GarcomRNVal();
        garcomDao = new GarcomDao();
    }

    public void salvar(Garcom garcom) {
        seriadoRNVal.validarSalvar(garcom);
        garcomDao.salvar(garcom);
    }
    
}
