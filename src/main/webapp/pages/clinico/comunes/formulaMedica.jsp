<%@ page contentType="text/html;charset=iso-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsf/html" prefix="h"%>
<%@ taglib uri="http://java.sun.com/jsf/core" prefix="f"%>
<%@ taglib uri="http://richfaces.org/a4j" prefix="a4j"%>
<%@ taglib uri="http://myfaces.apache.org/tomahawk" prefix="t"%>
<%@ taglib uri="http://myfaces.apache.org/sandbox" prefix="s"%>
<%@ page import="org.profamilia.hc.view.servlet.PdfServlet"%>
<h:panelGrid columns="1" border="0" cellpadding="0" cellspacing="0" width="100%" id="panelGridFormulaMedicaTab"
             styleClass="tabContainer">
  <jsp:include page="/pages/clinico/comunes/encabezadoDatosUsuario.jsp" flush="true"/>
  <t:panelTabbedPane border="0" cellpadding="0" cellspacing="0" serverSideTabSwitch="false" activePanelTabVar="true"
                     width="100%" id="panelTabbedPaneFormulaMedica" styleClass="tabbedPane"
                     selectedIndex="#{formulaMedicaUsuarioBean.selectedIndex}" activeTabStyleClass="activeTab"
                     inactiveTabStyleClass="inactiveTab" disabledTabStyleClass="disabledTab"
                     activeSubStyleClass="activeSub" inactiveSubStyleClass="inactiveSub"
                     tabContentStyleClass="tabContent">
    <t:panelTab id="panelTabPrescripcionMedica" label="Prescripci�n Medica"
                disabled="#{formulaMedicaUsuarioBean.renderBuscador}">
      <h:panelGrid columns="1" border="0" cellpadding="0" cellspacing="0" width="100%" id="panelGridFormulaMedica">
        <s:fieldset legend="Prescripci�n Medica" id="fieldFormulaMedica" styleClass="fieldset">
          <a4j:region id="regionFormulaMedica" renderRegionOnly="false">
            <h:panelGrid columns="4" border="0" cellpadding="0" cellspacing="0" width="100%"
                         id="panelDatosFormulaMedica" rowClasses="labelText,labelTextInfo">
              <h:outputText value="Nombre Generico del Medicamento Concentraci�n/ forma farmac�utica"
                            styleClass="labelTextOblig"/>
              <h:outputText value=" "/>
              <h:outputText value="Dosis, frecuencia de administraci�n y duraci�n del tratamiento"
                            styleClass="labelTextOblig"/>
              <h:outputText value=" "/>
              <h:panelGroup>
                <a4j:region renderRegionOnly="false" >
                  <a4j:commandLink action="#{formulaMedicaUsuarioBean.renderMedicamentos}" immediate="true"
                                   reRender="panelGridFormulaMedicaTab">
                    <a4j:ajaxListener type="org.ajax4jsf.ajax.ForceRender"/>
                    <t:graphicImage alt="" border="0" url="/comun/imagenes/lupa.gif"/>
                  </a4j:commandLink>
               
                <h:inputTextarea id="itMedicamento" value="#{formulaMedicaUsuarioBean.medicamento}" 
                                 valueChangeListener="#{formulaMedicaUsuarioBean.setMedicamento}" required="true"
                                 onkeydown="return blockEnter(event);"
                                 disabled="#{formulaMedicaUsuarioBean.deshabilitarMedicamento}"
                                 binding="#{formulaMedicaUsuarioBean.itMedicamento}" style="width:300px">
                  <f:validateLength maximum="4000"/>
                </h:inputTextarea>
                </a4j:region>
              </h:panelGroup>
              <a4j:outputPanel ajaxRendered="true">
                <t:message for="itMedicamento" styleClass="errorMessage"/>
              </a4j:outputPanel>
              <h:inputTextarea id="itTratamiento" required="true" onkeydown="return blockEnter(event);"
                               value="#{formulaMedicaUsuarioBean.tratamiento}" style="width:300px">
                <f:validateLength maximum="4000"/>
              </h:inputTextarea>
              <a4j:outputPanel ajaxRendered="true">
                <t:message for="itTratamiento" styleClass="errorMessage"/>
              </a4j:outputPanel>
              <h:outputText value="Via de administraci�n" styleClass="labelTextOblig"/>
              <h:outputText value=" "/>
              <h:outputText value="Cantidad Requerida" styleClass="labelTextOblig"/>
              <h:outputText value=" "/>
              <h:selectOneMenu id="mnuVia" required="true" onkeydown="return blockEnter(event);"
                               value="#{formulaMedicaUsuarioBean.viaSelect}">
                <f:selectItems value="#{formulaMedicaUsuarioBean.lstVia}"/>
              </h:selectOneMenu>
              <a4j:outputPanel ajaxRendered="true">
                <t:message for="mnuVia" styleClass="errorMessage"/>
              </a4j:outputPanel>
              <h:inputText id="itCantidad" value="#{formulaMedicaUsuarioBean.cantidad}" maxlength="14"
                           onkeydown="return blockEnter(event);" required="true"/>
              <a4j:outputPanel ajaxRendered="true">
                <t:message for="itCantidad" styleClass="errorMessage"/>
              </a4j:outputPanel>
            </h:panelGrid>
            <h:panelGrid columns="2" border="0" cellpadding="0" cellspacing="0" width="100%"
                         id="panelDatosContraindicaciones" rowClasses="labelText,labelTextInfo">
              <h:outputText value="Contraindicaciones/Observaciones"/>
              <h:outputText value=" "/>
              <h:inputTextarea id="itAreaContraindicaciones" onkeydown="return blockEnter(event);"
                               value="#{formulaMedicaUsuarioBean.contraindicaciones}" style="width:600px">
                <f:validateLength maximum="4000"/>
              </h:inputTextarea>
              <a4j:outputPanel ajaxRendered="true">
                <t:message for="itAreaContraindicaciones" styleClass="errorMessage"/>
              </a4j:outputPanel>
            </h:panelGrid>
            <h:panelGrid columns="2" border="0" cellpadding="0" cellspacing="0" width="100%"
                         id="panelBotonAgregarFormula" columnClasses="columnaBotones">
              <h:panelGroup>
                <t:htmlTag value="br"/>
                <a4j:commandButton value="Agregar" styleClass="btn btn btn-success"
                                   action="#{formulaMedicaUsuarioBean.agregarPrescripcion}"
                                   reRender="panelGridFormulaMedicaTab"/>
              </h:panelGroup>
            </h:panelGrid>
          </a4j:region>
        </s:fieldset>
        <a4j:region renderRegionOnly="false">
          <s:fieldset legend="Formula Medicamentos" id="fieldMedicamentosLista" styleClass="fieldset"
                      rendered="#{not empty formulaMedicaUsuarioBean.lstPrescripciones}">
            <h:panelGrid columns="1" border="0" cellpadding="0" cellspacing="0" width="100%" id="panelFormulacionTable">
              <t:buffer into="#{table}">
                <h:dataTable var="item" border="0" cellpadding="0" cellspacing="1" 
                             binding="#{formulaMedicaUsuarioBean.dtFormula}" 
                             value="#{formulaMedicaUsuarioBean.lstPrescripciones}" rows="10" styleClass="standard_table"
                             rowClasses="standardTable_Row1,standardTable_Row2" footerClass="paginacion" id="dtFormula">
                  <h:column>
                    <f:facet name="header">
                      <h:outputText value="Imprimir"/>
                    </f:facet>
                    <h:selectBooleanCheckbox id="checkImprimir" immediate="true"
                                            value="#{item.imprimir}"
                                             valueChangeListener="#{item.setImprimir}">
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
                      <h:outputText value="Dosis"/>
                    </f:facet>
                    <h:outputText value="#{item.hfoctratramien}"/>
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
                    <h:outputText value="#{item.hfocadosis}"/>
                  </h:column>
                  <h:column>
                    <f:facet name="header">
                      <h:outputText value="Contraindicaciones"/>
                    </f:facet>
                    <h:outputText value="#{item.hfoccontraindi}"/>
                  </h:column>
                  <h:column>
                    <f:facet name="header">
                      <h:outputText value="Editar"/>
                    </f:facet>
                    <a4j:commandLink id="editar" immediate="true" rendered="#{!item.modoconsulta}" reRender="panelGridFormulaMedicaTab"
                                   action="#{formulaMedicaUsuarioBean.editarFormula}">
                      <t:graphicImage alt="" border="0" url="/comun/imagenes/editar.gif"/>
                    </a4j:commandLink>
                  </h:column>
                  <h:column>
                    <f:facet name="header">
                      <h:outputText value="Eliminar"/>
                    </f:facet>
                    <h:commandLink id="eliminar" immediate="true" rendered="#{!item.modoconsulta}"
                                   action="#{formulaMedicaUsuarioBean.eliminarFormula}">
                      <t:graphicImage alt="" border="0" url="/comun/imagenes/Delete.png"/>
                    </h:commandLink>
                  </h:column>
                </h:dataTable>
              </t:buffer>
              <t:buffer into="#{tableScroller}">
                <h:panelGrid columns="1" rowClasses="labelTextInfo,labelTextInfo">
                  <t:dataScroller id="scroll_1" for="dtFormula" fastStep="10" pageCountVar="pageCount"
                                  pageIndexVar="pageIndex" styleClass="scroller" paginator="true" immediate="true"
                                  paginatorMaxPages="9" paginatorTableClass="paginator" renderFacetsIfSinglePage="false"
                                  paginatorActiveColumnStyle="font-weight:bold;">
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
            <t:messages id="msgFormulaMedicaMsg" showSummary="false" errorClass="error" globalOnly="true" layout="table"
                        infoClass="informacion" showDetail="true" tooltip="true" warnClass="advertencia"/>
            <t:htmlTag value="br"/>
          </a4j:outputPanel>
        </h:panelGroup>
        <a4j:region renderRegionOnly="false">
          <h:panelGrid columns="2" border="0" cellpadding="0" cellspacing="0" width="100%" id="panelBotonModificar"
                       columnClasses="panelGridBotones">
            <a4j:commandButton value="Generar Formula Medica" reRender="panelGridFormulaMedicaTab"
                               styleClass="btn btn btn-success" action="#{formulaMedicaUsuarioBean.generarFormula}"/>
          </h:panelGrid>
        </a4j:region>
        <f:subview id="generarFormula" rendered="#{formulaMedicaUsuarioBean.generoFormula}">
          <f:verbatim>
            <script type="text/javascript" language="JavaScript">
                    window.open("<%=request.getSession().getAttribute(PdfServlet.DOCUMENT_NAME_ATTRIBUTE_NAME)%>", "Documento" , "width=800,height=600");
            </script>
          </f:verbatim>
        </f:subview>
      </h:panelGrid>
    </t:panelTab>
    <t:panelTab id="panelBuscadorMedicamentos" label="Buscar Medicamentos"
                rendered="#{formulaMedicaUsuarioBean.renderBuscador}">
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
        <jsp:include page="/pages/clinico/comunes/buscador/buscadorMedicamentos.jsp" flush="true"/>
       </a4j:region>
        <h:panelGrid id="panelGridMedicamentosBotones" width="100%" columnClasses="columnaBotonesCentrados" dir="RTL">
          <t:htmlTag value="br"/>
          <h:panelGroup id="panelGroupMedicamentosBotones1">
            <a4j:commandButton value="Aceptar" styleClass="btn btn btn-success"
                               action="#{formulaMedicaUsuarioBean.aceptarMedicamento}"
                               reRender="panelGridFormulaMedicaTab">
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