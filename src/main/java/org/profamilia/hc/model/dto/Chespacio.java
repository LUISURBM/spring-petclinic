package org.profamilia.hc.model.dto;

public class Chespacio {
   
        private Integer cespnodigo;
        private String cespdescripcio;
        private String cespestado;

        public Chespacio() {
        }


    public void setCespnodigo(Integer cespnodigo) {
        this.cespnodigo = cespnodigo;
    }

    public Integer getCespnodigo() {
        return cespnodigo;
    }

    public void setCespdescripcio(String cespdescripcio) {
        this.cespdescripcio = cespdescripcio;
    }

    public String getCespdescripcio() {
        return cespdescripcio;
    }

    public void setCespestado(String cespestado) {
        this.cespestado = cespestado;
    }

    public String getCespestado() {
        return cespestado;
    }
}
