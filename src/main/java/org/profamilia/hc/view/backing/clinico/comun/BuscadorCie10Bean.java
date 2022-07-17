package org.profamilia.hc.view.backing.clinico.comun;

import java.util.ArrayList;
import java.util.List;

import javax.faces.component.html.HtmlDataTable;

import org.profamilia.hc.model.dto.Crdgncie10;
import org.profamilia.hc.model.exceptions.ModelException;
import org.profamilia.hc.view.backing.BaseBean;


public class BuscadorCie10Bean extends BaseBean {

    private List<Crdgncie10> listCIE10;

    /** Almacena el componente tabla  */
    private HtmlDataTable dtConsultas;

    /** Almacena el objeto que se va a persistir**/
    private Crdgncie10 cie10;

    /** Almacena el objeto seleccionado*/
    private Crdgncie10 cie10Select;

    /**Almacena true si lo que se va a seleccionar es el diagnostico principal */
    private boolean diagnosticoPrincipal;

    /**Almacena true si lo que se va a seleccionar es el diagnostico relacionado 1 */
    private boolean diagnosticoRelacionado1;

    /**Almacena true si lo que se va a seleccionar es el diagnostico relacionado 2 */
    private boolean diagnosticoRelacionado2;

    /**Almacena true si lo que se va a seleccionar es el diagnostico relacionado 3 */
    private boolean diagnosticoRelacionado3;

    private int firstRow;

    public BuscadorCie10Bean() {
    }


    public void init() {
        listCIE10 = new ArrayList<Crdgncie10>();
        cie10 = new Crdgncie10();
        firstRow = 0;
    }


    /**
     * @param listCIE10
     */
    public void setListCIE10(List<Crdgncie10> listCIE10) {
        this.listCIE10 = listCIE10;
    }

    /**
     * @return
     */
    public List<Crdgncie10> getListCIE10() {
        return listCIE10;
    }

    /**
     * @param dtConsultas
     */
    public void setDtConsultas(HtmlDataTable dtConsultas) {
        this.dtConsultas = dtConsultas;
    }

    /**
     * @return
     */
    public HtmlDataTable getDtConsultas() {
        return dtConsultas;
    }

    /**
     * @param cie10
     */
    public void setCie10(Crdgncie10 cie10) {
        this.cie10 = cie10;
    }

    /**
     * @return
     */
    public Crdgncie10 getCie10() {
        return cie10;
    }


    /**
     * @param cie10Select
     */
    public void setCie10Select(Crdgncie10 cie10Select) {
        this.cie10Select = cie10Select;
    }

    /**
     * @return
     */
    public Crdgncie10 getCie10Select() {
        return cie10Select;
    }

    /**
     * @param diagnosticoPrincipal
     */
    public void setDiagnosticoPrincipal(boolean diagnosticoPrincipal) {
        this.diagnosticoPrincipal = diagnosticoPrincipal;
    }

    /**
     * @return
     */
    public boolean isDiagnosticoPrincipal() {
        return diagnosticoPrincipal;
    }

    /**
     * @param diagnosticoRelacionado1
     */
    public void setDiagnosticoRelacionado1(boolean diagnosticoRelacionado1) {
        this.diagnosticoRelacionado1 = diagnosticoRelacionado1;
    }

    /**
     * @return
     */
    public boolean isDiagnosticoRelacionado1() {
        return diagnosticoRelacionado1;
    }

    /**
     * @param diagnosticoRelacionado2
     */
    public void setDiagnosticoRelacionado2(boolean diagnosticoRelacionado2) {
        this.diagnosticoRelacionado2 = diagnosticoRelacionado2;
    }

    /**
     * @return
     */
    public boolean isDiagnosticoRelacionado2() {
        return diagnosticoRelacionado2;
    }

    /**
     * @param diagnosticoRelacionado3
     */
    public void setDiagnosticoRelacionado3(boolean diagnosticoRelacionado3) {
        this.diagnosticoRelacionado3 = diagnosticoRelacionado3;
    }

    /**
     * @return
     */
    public boolean isDiagnosticoRelacionado3() {
        return diagnosticoRelacionado3;
    }

    public void consultarCie10() {

        this.cie10Select = null;
        //this.listCIE10.clear();
        this.dtConsultas.setFirst(0);

        try {
            listCIE10 = 
                    this.getServiceLocator().getClinicoService().getCriteriosCie10(cie10);

        } catch (ModelException e) {
            e.printStackTrace();
        }
    }


    public void clear() {

        this.cie10 = new Crdgncie10();
        this.cie10Select = null;
        this.firstRow = 0;
        this.listCIE10.clear();
    }

    public void seleccionarCie10() {
        cie10Select = (Crdgncie10)dtConsultas.getRowData();
    }

    public void setFirstRow(int firstRow) {
        this.firstRow = firstRow;
    }

    public int getFirstRow() {
        return firstRow;
    }
}
