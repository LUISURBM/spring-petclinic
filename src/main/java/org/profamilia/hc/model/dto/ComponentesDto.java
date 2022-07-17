package org.profamilia.hc.model.dto;

public class ComponentesDto {

    //Constantes Tipos de Datos
    public static String TIPO_LONG = "Long";
    public static String TIPO_DOUBLE = "Double";
    public static String TIPO_STRING = "String";
    public static String TIPO_DATE = "Date";
    public static String TIPO_EMAIL = "Email";

    //Constantes Requerido o No Requerido	
    public static String REQUERIDO = "S";
    public static String NO_REQUERIDO = "N";

    private String id;
    private String valor;
    private String tipo;
    private String requerido;

    public ComponentesDto(String id, String valor, String tipo, 
                          String requerido) {
        this.id = id;
        this.valor = valor;
        this.tipo = tipo;
        this.requerido = requerido;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getValor() {
        return valor;
    }

    public void setValor(String valor) {
        this.valor = valor;
    }

    public String getTipo() {
        return tipo;
    }

    public void setTipo(String tipo) {
        this.tipo = tipo;
    }

    public String getRequerido() {
        return requerido;
    }

    public void setRequerido(String requerido) {
        this.requerido = requerido;
    }


}
