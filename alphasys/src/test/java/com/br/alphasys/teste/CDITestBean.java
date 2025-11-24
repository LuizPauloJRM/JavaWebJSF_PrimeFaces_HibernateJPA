package com.br.alphasys.teste;

import javax.enterprise.context.ApplicationScoped;
import javax.inject.Named;

@Named
@ApplicationScoped
public class CDITestBean {

    public String getMensagem() {
        return "CDI Funcionando!";
    }
}
