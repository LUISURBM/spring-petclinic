<%@ page contentType="text/html;charset=iso-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsf/html" prefix="h"%>
<%@ taglib uri="http://java.sun.com/jsf/core" prefix="f"%>
<%@ taglib uri="http://richfaces.org/a4j" prefix="a4j"%>
<%@ taglib uri="http://myfaces.apache.org/tomahawk" prefix="t"%>
<%@ taglib uri="http://myfaces.apache.org/sandbox" prefix="s"%>
<%@ page import="org.profamilia.hc.view.servlet.PdfServlet"%>
<a4j:form id="formFormulaMedica">
 <a4j:region id="regionFormulaMedica" renderRegionOnly="false">
    <a4j:status id="statusButton" for="regionFormulaMedica">
      <f:facet name="start">
        <t:div id="chargingFormulaMedica" styleClass="loading">
          <h:panelGrid columns="1" cellpadding="0" cellspacing="0" border="0">
            <h:outputText value="Procesando..."/>
            <h:outputText value="Por favor espere."/>
          </h:panelGrid>
        </t:div>
      </f:facet>
      <f:facet name="stop"/>
    </a4j:status>

  

  <h:panelGrid columns="1" border="0" cellpadding="0" cellspacing="0"
               width="100%" id="panelGridFormulaMedicaTab"
               styleClass="tabContainer">
    <t:panelTabbedPane border="0" cellpadding="0" cellspacing="0"
                       serverSideTabSwitch="false" activePanelTabVar="true"
                       width="100%" id="panelTabbedPaneFormulaMedica"
                       styleClass="tabbedPane" activeTabStyleClass="activeTab"
                       inactiveTabStyleClass="inactiveTab"
                       disabledTabStyleClass="disabledTab"
                       activeSubStyleClass="activeSub"
                       inactiveSubStyleClass="inactiveSub"
                       tabContentStyleClass="tabContent">
      <t:panelTab id="panelTabPrescripcionMedica" label="Prescripci�n Medica">
  <h:panelGrid columns="1" border="0" cellpadding="0" cellspacing="0"
               width="100%" id="panelGridFormulaMedica"
               styleClass="tabContainer">
    <s:fieldset legend="Prescripci�n Medica" id="fieldFormulaMedica"
                styleClass="fieldset">
      <a4j:region id="regionFormulaMedica" renderRegionOnly="false">
        <h:panelGrid columns="2" border="0" cellpadding="0" cellspacing="0"
                     width="100%" id="panelDatosFormulaMedica" rendered="#{!formulaMedicaBean.modoConsulta}"
                     rowClasses="labelText">
          <h:outputText value="Nombre Generico del Medicamento Concentraci�n/ forma farmac�utica" styleClass="labelTextOblig"/>
          <h:outputText value="Dosis, frecuencia de administraci�n y duraci�n del tratamiento" styleClass="labelTextOblig"/>
          <h:panelGroup>
          <h:inputTextarea id = "itMedicamento" required="true"
                           value="#{formulaMedicaBean.medicamento}"
                           disabled="#{formulaMedicaBean.modoConsulta}"
                           style="width:300px"/>
                  <a4j:outputPanel ajaxRendered="true">
              <t:message for="itMedicamento" styleClass="errorMessage"/>
            </a4j:outputPanel>
          </h:panelGroup>
          
          <h:panelGroup>
          <h:inputTextarea id = "itTratamiento" required="true"
                            value="#{formulaMedicaBean.tratamiento}"
                           disabled="#{formulaMedicaBean.modoConsulta}"
                           style="width:300px"/>
                <a4j:outputPanel ajaxRendered="true">
              <t:message for="itTratamiento" styleClass="errorMessage"/>
            </a4j:outputPanel>
          </h:panelGroup>
          
          
          <h:outputText value="Via de administraci�n" styleClass="labelTextOblig"/>
          <h:outputText value="Cantidad Requerida" styleClass="labelTextOblig"/>
          <h:panelGroup>
            <h:selectOneMenu id="mnuVia" required="true"
                             disabled="#{formulaMedicaBean.modoConsulta}"
                             value="#{formulaMedicaBean.viaSelect}">
              <f:selectItems value="#{formulaMedicaBean.lstVia}"/>
            </h:selectOneMenu>
            <a4j:outputPanel ajaxRendered="true">
              <t:message for="mnuVia" styleClass="errorMessage"/>
            </a4j:outputPanel>
          </h:panelGroup>
          <h:panelGroup>
            <h:inputText id="itCantidad" value="#{formulaMedicaBean.cantidad}"
             onkeydown="return blockEnter(event);" 
                        required="true"
                         disabled="#{formulaMedicaBean.modoConsulta}"/>
            <a4j:outputPanel ajaxRendered="true">
              <t:message for="itCantidad" styleClass="errorMessage"/>
            </a4j:outputPanel>
          </h:panelGroup>
        </h:panelGrid>

        
        <h:panelGrid columns="1" border="0" cellpadding="0" cellspacing="0"
                     width="100%" id="panelDatosContraindicaciones" rendered="#{!formulaMedicaBean.modoConsulta}"
                     rowClasses="labelText">
               <h:panelGroup>
               <h:outputText value ="Contraindicaciones/Observaciones" styleClass="labelTextOblig"/>
               </h:panelGroup>
               <h:panelGroup>
               <h:inputTextarea id = "itAreaContraindicaciones" value = "#{formulaMedicaBean.contraindicaciones}" style="width:600px" required="true"/>
                 <a4j:outputPanel ajaxRendered="true">
              <t:message for="itAreaContraindicaciones" styleClass="errorMessage"/>
            </a4j:outputPanel>
               </h:panelGroup>
                     
                     </h:panelGrid>
                        <h:panelGrid columns="2" border="0" cellpadding="0" cellspacing="0"
                     width="100%" id="panelBotonAgregarFormula"
                     columnClasses="columnaBotones">
          <h:panelGroup>
            <t:htmlTag value="br"/>
            <a4j:commandButton value="Agregar" styleClass="btn btn btn-warning"
                               rendered="#{!formulaMedicaBean.modoConsulta}"
                               action="#{formulaMedicaBean.agregarPrescripci�n}"
                               reRender="panelGridFormulaMedica"/>
          </h:panelGroup>
        </h:panelGrid>
        
      </a4j:region>
      <a4j:region renderRegionOnly="false">
        <s:fieldset legend="Formula Medicamentos" id="fieldMedicamentosLista"
                    styleClass="fieldset">
          <h:panelGrid columns="1" border="0" cellpadding="0" cellspacing="0"
                       width="100%" id="panelFormulacionTable"
                       styleClass="tabContainer">
            <t:buffer into="#{table}">
              <h:dataTable var="item" border="1" cellpadding="0"
                           binding="#{formulaMedicaBean.dtFormula}"
                           cellspacing="0"
                           value="#{formulaMedicaBean.lstPrescripciones}"
                           rows="10" styleClass="standard_table"
                           rowClasses="standardTable_Row1,standardTable_Row2"
                           footerClass="paginacion" id="dtFormula">
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

                <h:column rendered="#{!formulaMedicaBean.modoConsulta}">
                  <f:facet name="header">
                    <h:outputText value="Eliminar"/>
                  </f:facet>
                  <h:commandLink id="eliminar" immediate="true" 
                                 action="#{formulaMedicaBean.eliminarFormula}">
                    <t:graphicImage alt=""  border="0"
                                    url="/comun/imagenes/editar.gif"/>
                  </h:commandLink>
                </h:column>
              </h:dataTable>
            </t:buffer>
            <t:buffer into="#{tableScroller}">
              <h:panelGrid columns="1" rowClasses="labelTextInfo,labelTextInfo">
                <t:dataScroller id="scroll_1" for="dtFormula" fastStep="10"
                                pageCountVar="pageCount"
                                pageIndexVar="pageIndex" styleClass="scroller"
                                paginator="true" immediate="true"
                                paginatorMaxPages="9"
                                paginatorTableClass="paginator"
                                renderFacetsIfSinglePage="false"
                                paginatorActiveColumnStyle="font-weight:bold;">
                  <f:facet name="first">
                    <t:graphicImage alt=""  url="/comun/imagenes/primero.gif"
                                    border="0"/>
                  </f:facet>
                  <f:facet name="last">
                    <t:graphicImage alt=""  url="/comun/imagenes/ultimo.gif"
                                    border="0"/>
                  </f:facet>
                  <f:facet name="previous">
                    <t:graphicImage alt=""  url="/comun/imagenes/anterior.gif"
                                    border="0"/>
                  </f:facet>
                  <f:facet name="next">
                    <t:graphicImage alt=""  url="/comun/imagenes/siguiente.gif"
                                    border="0"/>
                  </f:facet>
                  <f:facet name="fastforward">
                    <t:graphicImage alt=""  url="/comun/imagenes/adelante.gif"
                                    border="0"/>
                  </f:facet>
                  <f:facet name="fastrewind">
                    <t:graphicImage alt=""  url="/comun/imagenes/atras.gif" border="0"/>
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
    </s:fieldset>
    <a4j:region renderRegionOnly="false">
    <h:panelGrid columns="2" border="0" cellpadding="0" cellspacing="0"
                 width="100%" id="panelBotonModificar"
                 columnClasses="panelGridBotones">
        <a4j:commandButton value="Generar Formula Medica" reRender="panelGridFormulaMedica" styleClass="btn btn btn-success"
                           disabled="#{formulaMedicaBean.modoConsulta}"
                           action="#{formulaMedicaBean.generarFormula}"/>
    </h:panelGrid>
    </a4j:region>
       <h:panelGrid>
              <h:panelGroup>
                <a4j:outputPanel id="ajaxRegionFormulaMedicaMsg"
                                 ajaxRendered="true">
                  <t:messages id="msgFormulaMedicaMsg" showSummary="true"
                              errorClass="error" globalOnly="true"
                              layout="table" infoClass="informacion"/>
                </a4j:outputPanel>
              </h:panelGroup>
            </h:panelGrid>
    
    <f:subview id="generarFormula"
               rendered="#{formulaMedicaBean.generoFormula}">
      <f:verbatim>
        <script type="text/javascript" language="JavaScript">
           window.open("<%=request.getSession().getAttribute(PdfServlet.DOCUMENT_NAME_ATTRIBUTE_NAME)%>", "Documento" , "width=800,height=600");
        </script>
      </f:verbatim>
    </f:subview>
  </h:panelGrid>

</t:panelTab>
</t:panelTabbedPane>
</h:panelGrid>
</a4j:region>
</a4j:form>