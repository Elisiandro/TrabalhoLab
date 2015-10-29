package br.com.netfood_2.rnval;

import br.com.netfood_2.entity.Garcom;

public class GarcomRNVal {

    public void validarSalvar(Garcom garcom) {
        if (garcom.getNome() == null) {
            throw new RuntimeException("Campo Nome não informado");
        }
        if (garcom.getCpf() == null) {
            throw new RuntimeException("Campo Cpf não informado");
        }
        if (garcom.getEmail() == null) {
            throw new RuntimeException("Campo E-mail não informado");
        }
        if (garcom.getSalario() == 0) {
            throw new RuntimeException("Campo E-mail não informado");
        }

    }

}
