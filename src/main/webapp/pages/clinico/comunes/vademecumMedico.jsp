<%@ page contentType="text/html;charset=iso-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsf/html" prefix="h"%>
<%@ taglib uri="http://java.sun.com/jsf/core" prefix="f"%>
<%@ taglib uri="http://richfaces.org/a4j" prefix="a4j"%>
<%@ taglib uri="http://myfaces.apache.org/tomahawk" prefix="t"%>
<%@ taglib uri="http://myfaces.apache.org/sandbox" prefix="s"%>
<%@ page import="org.profamilia.hc.view.servlet.PdfServlet"%>
<h:panelGrid columns="1" border="0" cellpadding="0" cellspacing="0" width="100%" id="panelGridFormulaMedicaTab" styleClass="tabContainer">
  <jsp:include page="/pages/clinico/comunes/encabezadoDatosUsuario.jsp" flush="true"/>
  <t:panelTabbedPane border="0" cellpadding="0" cellspacing="0" serverSideTabSwitch="false" activePanelTabVar="true" width="100%" id="panelTabbedPaneFormulaMedica" styleClass="tabbedPane"
                     selectedIndex="#{vademecumMedicoBean.selectedIndex}" activeTabStyleClass="activeTab" inactiveTabStyleClass="inactiveTab" disabledTabStyleClass="disabledTab"
                     activeSubStyleClass="activeSub" inactiveSubStyleClass="inactiveSub" tabContentStyleClass="tabContent">
    <t:panelTab id="panelTabPrescripcionMedica" label="Prescripci�n Medica" disabled="#{vademecumMedicoBean.renderBuscador}">
      <h:panelGrid columns="1" border="0" cellpadding="0" cellspacing="0" width="100%" id="panelGridFormulaMedica">
        <s:fieldset legend="Conciliaci�n Medicamentosa" id="fieldConciliaci�n" styleClass="fieldset">
          <h:panelGrid columns="2" border="0" cellpadding="0" cellspacing="0" width="100%" id="panelDatosConciliacion" rowClasses="labelText,labelTextInfo">
            <h:outputText value="Se realizo reconciliaci�n medicamentosa?" styleClass="labelTextOblig"/>
            <h:outputText value=" "/>
            <h:selectOneRadio id="selectConciliaci�n" required="true" immediate="true" value="#{vademecumMedicoBean.conciliacionMedicamentosa}"
                              valueChangeListener="#{vademecumMedicoBean.setConciliacionMedicamentosa}">
              <f:selectItems value="#{vademecumMedicoBean.listOpciones}"/>
              <a4j:support id="support7" action="#{vademecumMedicoBean.confirmaConciliacion}" event="onchange" immediate="true">
                <a4j:ajaxListener type="org.ajax4jsf.ajax.ForceRender"/>
              </a4j:support>
              <a4j:outputPanel ajaxRendered="true">
                <t:message for="selectConciliaci�n" styleClass="errorMessage"/>
              </a4j:outputPanel>
            </h:selectOneRadio>
          </h:panelGrid>
        </s:fieldset>
        <s:fieldset legend="Prescripci�n Medica (Vademecum)" id="fieldFormulaMedica" styleClass="fieldset">
          <a4j:region id="regionFormulaMedica" renderRegionOnly="false">
            <h:panelGrid columns="6" border="0" cellpadding="0" cellspacing="0" width="100%"
            id="panelDatosFormulaMedica" rowClasses="labelText,labelTextInfo">
              <h:outputText value="Nombre Generico del Medicamento" styleClass="labelTextOblig"/>
              <h:outputText value=" "/>
              <h:outputText value="Concentracion" styleClass="labelTextOblig"/>
              <h:outputText value=" "/>
              <h:outputText value="Presentaci�n " styleClass="labelTextOblig"/>
              <h:outputText value=" "/>
              <h:panelGroup>
                <a4j:commandLink action="#{vademecumMedicoBean.renderMedicamentos}" immediate="true" reRender="panelGridFormulaMedicaTab">
                  <a4j:ajaxListener type="org.ajax4jsf.ajax.ForceRender"/>
                  <t:graphicImage alt="" border="0" url="/comun/imagenes/lupa.gif"/>
                </a4j:commandLink>
                <h:inputText id="itMedicamentoText" value="#{vademecumMedicoBean.vademecum.hvpcprincactiv}" rendered="#{vademecumMedicoBean.renderDescripcion}"/>
                <h:outputText id="otMedicamentoText" value="#{vademecumMedicoBean.vademecum.hvpcprincactiv}" rendered="#{!vademecumMedicoBean.renderDescripcion}"/>
              </h:panelGroup>
              <a4j:outputPanel ajaxRendered="true">
                <t:message for="itMedicamentoText" styleClass="errorMessage"/>
              </a4j:outputPanel>
              <h:panelGroup>
                <h:inputText id="itConcentracionText" value="#{vademecumMedicoBean.vademecum.hvpcconcentrac}" rendered="#{vademecumMedicoBean.renderDescripcion}"/>
                <h:outputText id="otConcentracionText" value="#{vademecumMedicoBean.vademecum.hvpcconcentrac}" rendered="#{!vademecumMedicoBean.renderDescripcion}"/>
              </h:panelGroup>
              <a4j:outputPanel ajaxRendered="true">
                <t:message for="itMedicamento" styleClass="errorMessage"/>
              </a4j:outputPanel>
              <h:selectOneMenu id="itFormaFarmaceuticaText" value="#{vademecumMedicoBean.vademecum.hvpcformafarma}" disabled="#{!vademecumMedicoBean.renderDescripcion}">
                <f:selectItems value="#{vademecumMedicoBean.lstFormaFarmaceutica}"/>
              </h:selectOneMenu>
              <a4j:outputPanel ajaxRendered="true">
                <t:message for="itFormaFarmaceuticaText" styleClass="errorMessage"/>
              </a4j:outputPanel>
              <h:outputText value="Unidad de Medida" styleClass="labelTextOblig"/>
              <h:outputText value=" "/>
              <h:outputText value="Via de Administraci�n" styleClass="labelTextOblig"/>
              <h:outputText value=" "/>
              <h:outputText value="Cantidad" styleClass="labelTextOblig"/>
              <h:outputText value=" "/>
              <h:panelGroup>
                <h:selectOneMenu id="itUnidadMedidaText" value="#{vademecumMedicoBean.vademecum.hvpcunidmedi}" disabled="#{!vademecumMedicoBean.renderDescripcion}">
                  <f:selectItems value="#{vademecumMedicoBean.lstUnidadMedida}"/>
                </h:selectOneMenu>
              </h:panelGroup>
              <a4j:outputPanel ajaxRendered="true">
                <t:message for="itUnidadMedidaText" styleClass="errorMessage"/>
              </a4j:outputPanel>
              <h:panelGroup>
                <h:selectOneMenu id="itViaAdministracionText" value="#{vademecumMedicoBean.vademecum.hvpcviaadmo}">
                  <f:selectItems value="#{vademecumMedicoBean.lstViaAdministracion}"/>
                </h:selectOneMenu>
              </h:panelGroup>
              <a4j:outputPanel ajaxRendered="true">
                <t:message for="itViaAdministracionText" styleClass="errorMessage"/>
              </a4j:outputPanel>
              <h:inputText id="itCantidad" value="#{vademecumMedicoBean.vademecum.hvpncantidad}" style="width:30px" maxlength="3" required="true"/>
              <a4j:outputPanel ajaxRendered="true">
                <t:message for="itCantidad" styleClass="errorMessage"/>
              </a4j:outputPanel>
            </h:panelGrid>
            <h:panelGrid columns="2" border="0" cellpadding="0" cellspacing="0" width="100%"
                         id="panelDatosContraindicacionesVademecum" rowClasses="labelText,labelTextInfo">
              <h:outputText value="Tratamiento/Dosis"/>
              <h:outputText value=" "/>
              <h:inputTextarea id="itDosis" onkeydown="return blockEnter(event);" required="true"
                               value="#{vademecumMedicoBean.vademecum.hvpctratamiento}" style="width:600px">
                <f:validateLength maximum="4000"/>
              </h:inputTextarea>
              <a4j:outputPanel ajaxRendered="true">
                <t:message for="itDosis" styleClass="errorMessage"/>
              </a4j:outputPanel>
              <h:outputText value="Observaciones"/>
              <h:outputText value=" "/>
              <h:inputTextarea id="itAreaContraindicacionesVademecum" onkeydown="return blockEnter(event);"
                               value="#{vademecumMedicoBean.vademecum.hvpcobservaci}" style="width:600px">
                <f:validateLength maximum="4000"/>
              </h:inputTextarea>
              <a4j:outputPanel ajaxRendered="true">
                <t:message for="itAreaContraindicaciones" styleClass="errorMessage"/>
              </a4j:outputPanel>
            </h:panelGrid>
            <h:panelGrid columns="1" border="0" cellpadding="0" cellspacing="0" width="100%" id="panelBotonAgregarFormulaIve"
            rowClasses="labelText,labelTextInfo">
            
                          <h:outputText value="Alerta" rendered="#{vademecumMedicoBean.renderAlertaIve}"/>
              
              
              <h:outputText id = "otAlerta"  rendered="#{vademecumMedicoBean.renderAlertaIve}"
              value = "#{vademecumMedicoBean.vademecum.hvpcalerta}" style="color:red"/>
              
        
               </h:panelGrid>
            <h:panelGrid columns="2" border="0" cellpadding="0" cellspacing="0" width="100%" id="panelBotonAgregarFormula" columnClasses="columnaBotones">
              <h:panelGroup>
                <t:htmlTag value="br"/>
                <a4j:commandButton value="Agregar" styleClass="btn btn btn-success" action="#{vademecumMedicoBean.agregarPrescripcion}" reRender="panelGridFormulaMedicaTab"/>
              </h:panelGroup>
            </h:panelGrid>
          </a4j:region>
        </s:fieldset>
        <a4j:region renderRegionOnly="false">
          <s:fieldset legend="Formula Medicamentos" id="fieldMedicamentosLista" styleClass="fieldset" rendered="#{not empty vademecumMedicoBean.lstPrescripciones}">
            <h:panelGrid columns="1" border="0" cellpadding="0" cellspacing="0" width="100%" id="panelFormulacionTable">
              <t:buffer into="#{table}">
                <h:dataTable var="item" border="0" cellpadding="0" cellspacing="1" binding="#{vademecumMedicoBean.dtFormula}" value="#{vademecumMedicoBean.lstPrescripciones}" rows="10"
                             styleClass="standard_table" rowClasses="standardTable_Row1,standardTable_Row2" footerClass="paginacion" id="dtFormula">
                  <h:column>
                    <f:facet name="header">
                      <h:outputText value="Imprimir"/>
                    </f:facet>
                    <h:selectBooleanCheckbox id="checkImprimir" immediate="true" value="#{item.imprimir}" valueChangeListener="#{item.setImprimir}">
                      <a4j:support id="supportcheckImprimir" event="onchange" immediate="true">
                        <a4j:ajaxListener type="org.ajax4jsf.ajax.ForceRender"/>
                      </a4j:support>
                    </h:selectBooleanCheckbox>
                  </h:column>
                  <h:column>
                    <f:facet name="header">
                      <h:outputText value="Medicamento"/>
                    </f:facet>
                    <h:outputText value="#{item.hfocmedicament}"/>
                  </h:column>
                  <h:column>
                    <f:facet name="header">
                      <h:outputText value="Concentracion"/>
                    </f:facet>
                    <h:outputText value="#{item.hfocconcentr}"/>
                  </h:column>
                  <h:column>
                    <f:facet name="header">
                      <h:outputText value="Via"/>
                    </f:facet>
                    <h:outputText value="#{item.hfocviadministr} #{item.hfocviadminotr}"/>
                  </h:column>
                  <h:column>
                    <f:facet name="header">
                      <h:outputText value="Cantidad"/>
                    </f:facet>
                    <h:outputText value="#{item.hfocadosis}  #{item.hfocformafarma}"/>
                  </h:column>
                  <h:column>
                    <f:facet name="header">
                      <h:outputText value="Venta Por Mostrador"/>
                    </f:facet>
                    <h:outputText value="#{item.hfocventmostra}"/>
                  </h:column>
                  <h:column>
                    <f:facet name="header">
                      <h:outputText value="Editar"/>
                    </f:facet>
                    <a4j:commandLink id="editar" immediate="true" rendered="#{!item.modoconsulta}" reRender="panelGridFormulaMedicaTab" action="#{vademecumMedicoBean.editarFormula}">
                      <t:graphicImage alt="" border="0" url="/comun/imagenes/editar.gif"/>
                    </a4j:commandLink>
                  </h:column>
                  <h:column>
                    <f:facet name="header">
                      <h:outputText value="Eliminar"/>
                    </f:facet>
                    <h:commandLink id="eliminar" immediate="true" rendered="#{!item.modoconsulta}" action="#{vademecumMedicoBean.eliminarFormula}">
                      <t:graphicImage alt="" border="0" url="/comun/imagenes/Delete.png"/>
                    </h:commandLink>
                  </h:column>
                </h:dataTable>
              </t:buffer>
              <t:buffer into="#{tableScroller}">
                <h:panelGrid columns="1" rowClasses="labelTextInfo,labelTextInfo">
                  <t:dataScroller id="scroll_1" for="dtFormula" fastStep="10" pageCountVar="pageCount" pageIndexVar="pageIndex" styleClass="scroller" paginator="true" immediate="true"
                                  paginatorMaxPages="9" paginatorTableClass="paginator" renderFacetsIfSinglePage="false" paginatorActiveColumnStyle="font-weight:bold;">
                    <f:facet name="first">
                      <t:graphicImage alt="" url="/comun/imagenes/primero.gif" border="0"/>
                    </f:facet>
                    <f:facet name="last">
                      <t:graphicImage alt="" url="/comun/imagenes/ultimo.gif" border="0"/>
                    </f:facet>
                    <f:facet name="previous">
                      <t:graphicImage alt="" url="/comun/imagenes/anterior.gif" border="0"/>
                    </f:facet>
                    <f:facet name="next">
                      <t:graphicImage alt="" url="/comun/imagenes/siguiente.gif" border="0"/>
                    </f:facet>
                    <f:facet name="fastforward">
                      <t:graphicImage alt="" url="/comun/imagenes/adelante.gif" border="0"/>
                    </f:facet>
                    <f:facet name="fastrewind">
                      <t:graphicImage alt="" url="/comun/imagenes/atras.gif" border="0"/>
                    </f:facet>
                  </t:dataScroller>
                </h:panelGrid>
              </t:buffer>
              <h:outputText value="#{tableScroller}" escape="false"/>
              <h:outputText value="#{table}" escape="false"/>
              <h:outputText value="#{tableScroller}" escape="false"/>
            </h:panelGrid>
          </s:fieldset>
        </a4j:region>
        <h:panelGroup>
          <a4j:outputPanel id="ajaxRegionFormulaMedicaMsg" ajaxRendered="true">
            <t:htmlTag value="br"/>
            <t:messages id="msgFormulaMedicaMsg" showSummary="false" errorClass="error" globalOnly="true" layout="table" infoClass="informacion" showDetail="true" tooltip="true"
                        warnClass="advertencia"/>
            <t:htmlTag value="br"/>
          </a4j:outputPanel>
        </h:panelGroup>
        <a4j:region renderRegionOnly="false">
          <h:panelGrid columns="2" border="0" cellpadding="0" cellspacing="0" width="100%" id="panelBotonModificar" columnClasses="panelGridBotones">
            <a4j:commandButton value="Generar Formula Medica" reRender="panelGridFormulaMedicaTab" styleClass="btn btn btn-success" action="#{vademecumMedicoBean.generarFormula}"/>
          </h:panelGrid>
        </a4j:region>
        <f:subview id="generarFormula" rendered="#{vademecumMedicoBean.generoFormula}">
          <f:verbatim>
            <script type="text/javascript" language="JavaScript">
                    window.open("<%=request.getSession().getAttribute(PdfServlet.DOCUMENT_NAME_ATTRIBUTE_NAME)%>", "Documento" , "width=800,height=600");
            </script>
          </f:verbatim>
        </f:subview>
      </h:panelGrid>
    </t:panelTab>
    <t:panelTab id="panelBuscadorMedicamentos" label="Buscar Medicamentos" rendered="#{vademecumMedicoBean.renderBuscador}">
      <a4j:region id="regionMedicamento" renderRegionOnly="false">
        <a4j:status id="statusButton" for="regionMedicamento">
          <f:facet name="start">
            <t:div id="chargingMedicamento" styleClass="loading">
              <h:panelGrid columns="1" cellpadding="0" cellspacing="0" border="0">
                <h:outputText value="Procesando..."/>
                <h:outputText value="Por favor espere."/>
              </h:panelGrid>
            </t:div>
          </f:facet>
          <f:facet name="stop"/>
        </a4j:status>
        <a4j:region renderRegionOnly="false">
          <jsp:include page="/pages/clinico/comunes/buscador/buscadorVademecum.jsp" flush="true"/>
        </a4j:region>
        <h:panelGrid id="panelGridMedicamentosBotones" width="100%" columnClasses="columnaBotonesCentrados" dir="RTL">
          <t:htmlTag value="br"/>
          <h:panelGroup id="panelGroupMedicamentosBotones1">
            <a4j:commandButton value="Aceptar" styleClass="btn btn btn-success" action="#{vademecumMedicoBean.aceptarMedicamento}" reRender="panelGridFormulaMedicaTab">
              <a4j:ajaxListener type="org.ajax4jsf.ajax.ForceRender"/>
            </a4j:commandButton>
          </h:panelGroup>
        </h:panelGrid>
      </a4j:region>
    </t:panelTab>
  </t:panelTabbedPane>
  <script language="javascript" type="text/javascript">
        document.forms[1].elements[6].focus()
</script>
</h:panelGrid>