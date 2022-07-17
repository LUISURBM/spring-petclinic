<%@ page contentType="text/html;charset=iso-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsf/html" prefix="h"%>
<%@ taglib uri="http://java.sun.com/jsf/core" prefix="f"%>
<%@ taglib uri="http://richfaces.org/a4j" prefix="a4j"%>
<%@ taglib uri="http://myfaces.apache.org/tomahawk" prefix="t"%>
<%@ taglib uri="http://myfaces.apache.org/sandbox" prefix="s"%>
<%@ page import="org.profamilia.hc.view.servlet.PdfServlet"%>
<a4j:form id="formRemision">
 <a4j:region id="regionRemision" renderRegionOnly="false">
    <a4j:status  id = "statusButton" for="regionRemision">
      <f:facet name="start">
        <t:div id="chargingRemision" styleClass="loading">
          <h:panelGrid columns="1" cellpadding="0" cellspacing="0" border="0">
            <h:outputText value="Procesando..."/>
            <h:outputText value="Por favor espere."/>
          </h:panelGrid>
        </t:div>
      </f:facet>
      <f:facet name="stop"/>
    </a4j:status>


  <h:panelGrid columns="1" border="0" cellpadding="0" cellspacing="0"
               width="100%" id="panelGridRemisionTab"
               styleClass="tabContainer">
    <t:panelTabbedPane border="0" cellpadding="0" cellspacing="0"
                       serverSideTabSwitch="false" activePanelTabVar="true"
                       width="100%" id="panelTabbedPaneRemision"
                       styleClass="tabbedPane" activeTabStyleClass="activeTab"
                       inactiveTabStyleClass="inactiveTab"
                       disabledTabStyleClass="disabledTab"
                       activeSubStyleClass="activeSub"
                       inactiveSubStyleClass="inactiveSub"
                       tabContentStyleClass="tabContent">
      <t:panelTab id="panelTabRemision" label="Remisi�n">
  <h:panelGrid columns="1" border="0" cellpadding="0" cellspacing="0"
               width="100%" id="panelGridInterconsulta"
               styleClass="tabContainer">
    <s:fieldset legend="Datos Interconsulta" id="fieldInterconsulta"
                styleClass="fieldset">
      <a4j:region id="regionInterconsulta" renderRegionOnly="false">
        <h:panelGrid columns="2" border="0" cellpadding="0" cellspacing="0"
                     width="100%" id="panelDatosInterconsulta"
                     rendered="#{!interconsultaBean.modoConsulta}"
                     rowClasses="labelText">
          <h:outputText value="Tipo Interconsulta" styleClass="labelTextOblig"/>
          <h:outputText value="Descripcion " styleClass="labelTextOblig"/>
          <h:panelGroup>
            <h:selectOneMenu id="mnuTipoInterconsulta" required="true"
                             disabled="#{interconsultaBean.modoConsulta}"
                             value="#{interconsultaBean.consultaSelect}">
              <f:selectItems value="#{interconsultaBean.lstTipoConsulta}"/>
            </h:selectOneMenu>
            <a4j:outputPanel ajaxRendered="true">
              <t:message for="mnuTipoInterconsulta"
                         styleClass="errorMessage"/>
            </a4j:outputPanel>
          </h:panelGroup>
          <h:panelGroup>
            <h:inputTextarea id = "inputDescripcionConsulta" required="true"
                           value="#{interconsultaBean.descripcion}"
                           disabled="#{interconsultaBean.modoConsulta}"
                           style="width:350px"/>
                  <a4j:outputPanel ajaxRendered="true">
              <t:message for="inputDescripcionConsulta"
                         styleClass="errorMessage"/>
            </a4j:outputPanel>
          </h:panelGroup>
        
        </h:panelGrid>
        <h:panelGrid columns="2" border="0" cellpadding="0" cellspacing="0"
                     width="100%" id="panelBotonAgregarInterconsulta"
                     columnClasses="panelGridBotones">
          <h:panelGroup>
            <t:htmlTag value="br"/>
            <a4j:commandButton value="Agregar" styleClass="boton_fieldset_Naranja"
                               rendered="#{!interconsultaBean.modoConsulta}"
                               action="#{interconsultaBean.agregarInterconsulta}"
                               reRender="panelGridInterconsulta"/>
          </h:panelGroup>
        </h:panelGrid>
      </a4j:region>
      <a4j:region renderRegionOnly="false">
        <s:fieldset legend="Lista Interconsulta "
                    id="fieldInterconsultaLista" styleClass="fieldset">
          <h:panelGrid columns="1" border="0" cellpadding="0" cellspacing="0"
                       width="100%" id="panelInterconsultaTable"
                       styleClass="tabContainer">
            <t:buffer into="#{table}">
              <h:dataTable var="item" border="1" cellpadding="0"
                           binding="#{interconsultaBean.dtRemision}"
                           cellspacing="0"
                           value="#{interconsultaBean.lstRemision}"
                           rows="10" styleClass="standard_table"
                           rowClasses="standardTable_Row1,standardTable_Row2"
                           footerClass="paginacion" id="dtRemision">
                <h:column>
                  <f:facet name="header">
                    <h:outputText value="Tipo Interconsulta"/>
                  </f:facet>
                  <h:outputText value="#{item.hrecdesservici}"/>
                </h:column>
                <h:column>
                  <f:facet name="header">
                    <h:outputText value="Descripcion"/>
                  </f:facet>
                  <h:outputText value="#{item.hrecdescripcio}"/>
                </h:column>
                <h:column rendered="#{!interconsultaBean.modoConsulta}">
                  <f:facet name="header">
                    <h:outputText value="Eliminar"/>
                  </f:facet>
                  <h:commandLink id="eliminar" immediate="true"
                                 action="#{interconsultaBean.eliminarRemision}">
                    <t:graphicImage alt=""  border="0"
                                    url="/comun/imagenes/editar.gif"/>
                  </h:commandLink>
                </h:column>
              </h:dataTable>
            </t:buffer>
            <t:buffer into="#{tableScroller}">
              <h:panelGrid columns="1" rowClasses="labelTextInfo,labelTextInfo">
                <t:dataScroller id="scroll_Interconsulta" for="dtRemision"
                                fastStep="10" pageCountVar="pageCount"
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
                 width="100%" id="panelBotonInterconsulta"
                 columnClasses="panelGridBotones">
      <h:panelGroup>
        <a4j:commandButton value="Generar Remision" reRender="panelGridInterconsulta"
                           styleClass="boton_fieldset"
                           disabled="#{interconsultaBean.modoConsulta}"
                           action="#{interconsultaBean.generarRemision}"/>
      </h:panelGroup>
    </h:panelGrid>
    </a4j:region>
    <h:panelGrid>
              <h:panelGroup>
                <a4j:outputPanel id="ajaxRegionRemisionMsg"
                                 ajaxRendered="true">
                  <t:messages id="msgRemisionMsg" showSummary="true"
                              errorClass="error" globalOnly="true"
                              layout="table" infoClass="informacion"/>
                </a4j:outputPanel>
              </h:panelGroup>
            </h:panelGrid>
    
    <f:subview id="generarInterconsulta"
               rendered="#{interconsultaBean.generoDocPDF}">
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