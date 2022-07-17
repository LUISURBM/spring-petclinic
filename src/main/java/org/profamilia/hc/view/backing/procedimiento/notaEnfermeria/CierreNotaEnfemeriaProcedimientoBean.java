package org.profamilia.hc.view.backing.procedimiento.notaEnfermeria;

import org.profamilia.hc.model.dto.Chconsulta;
import org.profamilia.hc.model.dto.Cnconsclin;
import org.profamilia.hc.model.exceptions.ModelException;
import org.profamilia.hc.view.backing.BaseBean;
import org.profamilia.hc.view.backing.BeanNavegacion;
import org.profamilia.hc.view.util.FacesUtils;

public class CierreNotaEnfemeriaProcedimientoBean extends BaseBean {

    private Cnconsclin consulta;

    public CierreNotaEnfemeriaProcedimientoBean() {
    }

    public String cierreNotaEnfermeria() {
        Long numConsulta = 
            Long.parseLong(consulta.getCconnumero().toString());
        Chconsulta chconsulta = new Chconsulta();

        try {
            chconsulta = 
                    this.getServiceLocator().getClinicoService().getConsultaActual(numConsulta);
        } catch (ModelException e) {
            e.getMessage();
        }
        chconsulta.setHcoccieringr("S");
        
        try {
            this.getServiceLocator().getClinicoService().saveConsulta(chconsulta);
            FacesUtils.resetManagedBean("listaUsuarioNotaEnfermeriaBean");
            return BeanNavegacion.RUTA_IR_LISTA_USUARIO_NOTA_ENFERMERIA;
        } catch (ModelException e) {
            e.getMessage();
            return BeanNavegacion.RUTA_ACTUAL;
        }
    }

    public void setConsulta(Cnconsclin consulta) {
        this.consulta = consulta;
    }

    public Cnconsclin getConsulta() {
        return consulta;
    }
}
