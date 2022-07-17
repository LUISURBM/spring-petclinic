package org.profamilia.hc.view.backing.webService;

public class DatosCodigoQRDTO {

         private String nombre;
         private String tipoIdentificacion;
         private Long numeroIdentificacion;
         private String fechaToma;
         private String numeroCitologia;
         private String clinica;

        public DatosCodigoQRDTO() {
        }

        public String getNombre() {
            return nombre;
        }

        public void setNombre(String nombre) {
            this.nombre = nombre;
        }

        public String getTipoIdentificacion() {
            return tipoIdentificacion;
        }

        public void setTipoIdentificacion(String tipoIdentificacion) {
            this.tipoIdentificacion = tipoIdentificacion;
        }

        public Long getNumeroIdentificacion() {
            return numeroIdentificacion;
        }

        public void setNumeroIdentificacion(Long numeroIdentificacion) {
            this.numeroIdentificacion = numeroIdentificacion;
        }

        public String getFechaToma() {
            return fechaToma;
        }

        public void setFechaToma(String fechaToma) {
            this.fechaToma = fechaToma;
        }

        public String getNumeroCitologia() {
            return numeroCitologia;
        }

        public void setNumeroCitologia(String numeroCitologia) {
            this.numeroCitologia = numeroCitologia;
        }

        public String getClinica() {
            return clinica;
        }

        public void setClinica(String clinica) {
            this.clinica = clinica;
        }
        
}
