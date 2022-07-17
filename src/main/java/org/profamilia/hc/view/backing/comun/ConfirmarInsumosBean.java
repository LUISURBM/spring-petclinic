package org.profamilia.hc.view.backing.comun;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.faces.component.html.HtmlDataTable;

import org.profamilia.hc.model.dto.Chreginsumo;
import org.profamilia.hc.model.dto.ChreginsumoPK;
import org.profamilia.hc.model.dto.confirmarInsumoDTO;
import org.profamilia.hc.model.exceptions.ModelException;
import org.profamilia.hc.view.backing.BaseBean;

public class ConfirmarInsumosBean extends BaseBean {

    private String codigoServicio;
    private Long numeroConsulta;
    private List<Chreginsumo> chreginsumoList;
    private List<confirmarInsumoDTO> confirmarInsumoDTOList;
    private confirmarInsumoDTO confirmarInsumoDTO;
    private HtmlDataTable tableInsumos;
    private Chreginsumo chreginsumo;
    private List<Object[]> resultadoCpcanaserv;
    private List<Object[]> resultadoChreginsumo;

    public ConfirmarInsumosBean() {
    }

    public void init() {

        chreginsumo = new Chreginsumo();
        chreginsumoList = new ArrayList();
        confirmarInsumoDTOList = new ArrayList();
        confirmarInsumoDTO = new confirmarInsumoDTO();
        tableInsumos = new HtmlDataTable();

    }

    public void consultarInsumos() {
        tableInsumos = new HtmlDataTable();
        resultadoCpcanaserv = new ArrayList();
        resultadoChreginsumo = new ArrayList();
        confirmarInsumoDTOList = new ArrayList();
        confirmarInsumoDTO = new confirmarInsumoDTO();

        try {

            if (codigoServicio != null && numeroConsulta != null) {
                resultadoChreginsumo = 
                        getServiceLocator().getClinicoService().getRegistroInsumosBynumeroConsulta(numeroConsulta);
                if (!resultadoChreginsumo.isEmpty()) {

                    for (Object[] objeto: resultadoChreginsumo) {
                        confirmarInsumoDTO.setHrinconsulta(validarLong(objeto[0]));
                        confirmarInsumoDTO.setHrinconsecuti(validarLong(objeto[1]));
                        confirmarInsumoDTO.setHricservicio(validarString(objeto[2]));
                        confirmarInsumoDTO.setHricobserv(validarString(objeto[3]));
                        if ("S".equals(validarString(objeto[4]))) {
                            confirmarInsumoDTO.setConsumo(true);
                        } else {
                            confirmarInsumoDTO.setConsumo(false);
                        }
                        confirmarInsumoDTO.setNombreServicio(validarString(objeto[6]));

                        confirmarInsumoDTOList.add(confirmarInsumoDTO);
                        confirmarInsumoDTO = new confirmarInsumoDTO();

                    }

                } else {

                    resultadoCpcanaserv = 
                            getServiceLocator().getClinicoService().getInsumosByServicio(codigoServicio);
                    if (resultadoCpcanaserv != null) {

                        for (Object[] objeto: resultadoCpcanaserv) {
                            confirmarInsumoDTO.setHricservicio(validarString(objeto[1]));
                            confirmarInsumoDTO.setNombreServicio(validarString(objeto[2]));
                            confirmarInsumoDTO.setConsumo(false);

                            confirmarInsumoDTOList.add(confirmarInsumoDTO);
                            confirmarInsumoDTO = new confirmarInsumoDTO();

                        }
                    }
                }
            }


        } catch (ModelException e) {
            e.printStackTrace();
        }
    }

    public void guardarInsumos() {
        try {
            resultadoChreginsumo = 
                    getServiceLocator().getClinicoService().getRegistroInsumosBynumeroConsulta(numeroConsulta);
        } catch (ModelException e) {
            e.printStackTrace();
        }
        
        Long contador = 1L;
        chreginsumoList = new ArrayList();
        chreginsumo = new Chreginsumo();

        for (confirmarInsumoDTO insumo: confirmarInsumoDTOList) {
            chreginsumo.setHridfecregistr(new Date());
            if (insumo.getConsumo() == true) {
                chreginsumo.setHricutilizo("S");
            } else {
                chreginsumo.setHricutilizo("N");
            }
            chreginsumo.setHricobserv(insumo.getHricobserv());
            chreginsumo.setHricservicio(insumo.getHricservicio());
            if (resultadoChreginsumo.isEmpty()) {
                chreginsumo.setId(new ChreginsumoPK(numeroConsulta, contador));
            }else{
                chreginsumo.setId(new ChreginsumoPK(insumo.getHrinconsulta(), insumo.getHrinconsecuti()));
            }
            chreginsumoList.add(chreginsumo);
            chreginsumo = new Chreginsumo();
            contador++;
        }

        try {
            this.getServiceLocator().getClinicoService().saveRegistroInsumos(chreginsumoList);
        } catch (ModelException e) {
            e.printStackTrace();
        }

    }

    public Long validarLong(Object valor) {
        return valor == null ? null : Long.parseLong(valor.toString());
    }

    public Double validarDouble(Object valor) {
        return valor == null ? null : Double.parseDouble(valor.toString());
    }

    public String validarString(Object valor) {
        return valor == null ? null : valor.toString();
    }

    public void setCodigoServicio(String codigoServicio) {
        this.codigoServicio = codigoServicio;
    }

    public String getCodigoServicio() {
        return codigoServicio;
    }

    public void setTableInsumos(HtmlDataTable tableInsumos) {
        this.tableInsumos = tableInsumos;
    }

    public HtmlDataTable getTableInsumos() {
        return tableInsumos;
    }

    public void setChreginsumo(Chreginsumo chreginsumo) {
        this.chreginsumo = chreginsumo;
    }

    public Chreginsumo getChreginsumo() {
        return chreginsumo;
    }

    public void setChreginsumoList(List<Chreginsumo> chreginsumoList) {
        this.chreginsumoList = chreginsumoList;
    }

    public List<Chreginsumo> getChreginsumoList() {
        return chreginsumoList;
    }

    public void setNumeroConsulta(Long numeroConsulta) {
        this.numeroConsulta = numeroConsulta;
    }

    public Long getNumeroConsulta() {
        return numeroConsulta;
    }


    public void setResultadoCpcanaserv(List<Object[]> resultadoCpcanaserv) {
        this.resultadoCpcanaserv = resultadoCpcanaserv;
    }

    public List<Object[]> getResultadoCpcanaserv() {
        return resultadoCpcanaserv;
    }

    public void setResultadoChreginsumo(List<Object[]> resultadoChreginsumo) {
        this.resultadoChreginsumo = resultadoChreginsumo;
    }

    public List<Object[]> getResultadoChreginsumo() {
        return resultadoChreginsumo;
    }

    public void setConfirmarInsumoDTOList(List<confirmarInsumoDTO> confirmarInsumoDTOList) {
        this.confirmarInsumoDTOList = confirmarInsumoDTOList;
    }

    public List<confirmarInsumoDTO> getConfirmarInsumoDTOList() {
        return confirmarInsumoDTOList;
    }

    public void setConfirmarInsumoDTO(confirmarInsumoDTO confirmarInsumoDTO) {
        this.confirmarInsumoDTO = confirmarInsumoDTO;
    }

    public confirmarInsumoDTO getConfirmarInsumoDTO() {
        return confirmarInsumoDTO;
    }
}
