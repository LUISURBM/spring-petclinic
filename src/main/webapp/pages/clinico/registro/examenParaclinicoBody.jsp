<%@ page contentType="text/html;charset=iso-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsf/html" prefix="h"%>
<%@ taglib uri="http://java.sun.com/jsf/core" prefix="f"%>
<%@ taglib uri="http://richfaces.org/a4j" prefix="a4j"%>
<%@ taglib uri="http://myfaces.apache.org/tomahawk" prefix="t"%>
<%@ taglib uri="http://myfaces.apache.org/sandbox" prefix="s"%>
<%@ page import="org.profamilia.hc.view.servlet.PdfServlet"%>
<a4j:form id="formExamenParaclinico">
 <a4j:region id="regionExamenParaclinico" renderRegionOnly="false">
    <a4j:status id="statusButton" for="regionExamenParaclinico">
      <f:facet name="start">
        <t:div id="chargingExamenParaclinico" styleClass="loading">
          <h:panelGrid columns="1" cellpadding="0" cellspacing="0" border="0">
            <h:outputText value="Procesando..."/>
            <h:outputText value="Por favor espere."/>
          </h:panelGrid>
        </t:div>
      </f:facet>
      <f:facet name="stop"/>
    </a4j:status>


   <h:panelGrid columns="1" border="0" cellpadding="0" cellspacing="0"
               width="100%" id="panelGridExamenParaclinicoTab"
               styleClass="tabContainer">
    <t:panelTabbedPane border="0" cellpadding="0" cellspacing="0"
                       serverSideTabSwitch="false" activePanelTabVar="true"
                       width="100%" id="panelTabbedPaneExamenParaclinico"
                       styleClass="tabbedPane" activeTabStyleClass="activeTab"
                       inactiveTabStyleClass="inactiveTab"
                       disabledTabStyleClass="disabledTab"
                       activeSubStyleClass="activeSub"
                       inactiveSubStyleClass="inactiveSub"
                       tabContentStyleClass="tabContent">
      <t:panelTab id="panelTabExamenParaclinico" label="Examen Paraclinico">
<a4j:region renderRegionOnly="false">
  <h:panelGrid columns="1" border="0" cellpadding="0" cellspacing="0"
               width="100%" id="panelGridExamenParaclinico"
               styleClass="tabContainer">
    <s:fieldset legend="Datos Examenes Paraclinicos" id="fieldExamenParaclinico"
                styleClass="fieldset">
      <a4j:region id="regionExamenParaclinico" renderRegionOnly="false">
        <h:panelGrid columns="2" border="0" cellpadding="0" cellspacing="0"
                     width="100%" id="panelDatosExamenParaclinico"
                     rendered="#{!examenParaclinicoBean.modoConsulta}"
                     rowClasses="labelText">
          <h:outputText value="Tipo Examen" styleClass="labelTextOblig"/>
          <h:outputText value="Examen " styleClass="labelTextOblig"/>
          <h:panelGroup>
            <h:selectOneMenu id="mnuTipoExamenParaclinico" required="true"
                             disabled="#{examenParaclinicoBean.modoConsulta}"
                             value="#{examenParaclinicoBean.remisionSelect}">
              <f:selectItems value="#{examenParaclinicoBean.lstTipoRemision}"/>
            </h:selectOneMenu>
            <a4j:outputPanel ajaxRendered="true">
              <t:message for="mnuTipoExamenParaclinico"
                         styleClass="errorMessage"/>
            </a4j:outputPanel>
          </h:panelGroup>
          <h:panelGroup>
            <h:inputTextarea id = "inputDescripcionRemision" required="true"
                           value="#{examenParaclinicoBean.descripcionRemision}"
                           disabled="#{examenParaclinicoBean.modoConsulta}"
                           style="width:300px"/>
                  <a4j:outputPanel ajaxRendered="true">
              <t:message for="inputDescripcionRemision"
                         styleClass="errorMessage"/>
            </a4j:outputPanel>
          </h:panelGroup>
        
        </h:panelGrid>
        <h:panelGrid columns="2" border="0" cellpadding="0" cellspacing="0"
                     width="100%" id="panelBotonAgregarExamenParaclinico"
                     columnClasses="columnaBotones">
          <h:panelGroup>
            <t:htmlTag value="br"/>
            <a4j:commandButton value="Agregar" styleClass="boton_fieldset"
                               rendered="#{!examenParaclinicoBean.modoConsulta}"
                               action="#{examenParaclinicoBean.agregarRemision}"
                               reRender="panelGridExamenParaclinico"/>
          </h:panelGroup>
        </h:panelGrid>
      </a4j:region>
      <a4j:region renderRegionOnly="false">
        <s:fieldset legend="Lista Examenes Paraclinicos "
                    id="fieldExamenParaclinicoLista" styleClass="fieldset">
          <h:panelGrid columns="1" border="0" cellpadding="0" cellspacing="0"
                       width="100%" id="panelExamenParaclinicoTable"
                       styleClass="tabContainer">
            <t:buffer into="#{table}">
              <h:dataTable var="item" border="1" cellpadding="0"
                           binding="#{examenParaclinicoBean.dtRemision}"
                           cellspacing="0"
                           value="#{examenParaclinicoBean.lstRemision}"
                           rows="10" styleClass="standard_table"
                           rowClasses="standardTable_Row1,standardTable_Row2"
                           footerClass="paginacion" id="dtExamenParaclinico">
                <h:column>
                  <f:facet name="header">
                    <h:outputText value="Tipo Remision"/>
                  </f:facet>
                  <h:outputText value="#{item.hepcdestipexam}"/>
                </h:column>
                <h:column>
                  <f:facet name="header">
                    <h:outputText value="Descripcion"/>
                  </f:facet>
                  <h:outputText value="#{item.hepcdescripc}"/>
                </h:column>
                <h:column rendered="#{!examenParaclinicoBean.modoConsulta}">
                  <f:facet name="header">
                    <h:outputText value="Eliminar"/>
                  </f:facet>
                  <h:commandLink id="eliminar" immediate="true"
                                 action="#{examenParaclinicoBean.eliminarRemision}">
                    <t:graphicImage alt=""  border="0"
                                    url="/comun/imagenes/editar.gif"/>
                  </h:commandLink>
                </h:column>
              </h:dataTable>
            </t:buffer>
            <t:buffer into="#{tableScroller}">
              <h:panelGrid columns="1" rowClasses="labelTextInfo,labelTextInfo">
                <t:dataScroller id="scroll_ExamenParaclinico" for="dtExamenParaclinico"
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
                    <t:graphicImage  alt="" url="/comun/imagenes/ultimo.gif"
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
                 width="100%" id="panelBotonExamenParaclinico"
                 columnClasses="panelGridBotones">
      <h:panelGroup>
        <a4j:commandButton value="Generar Remision" 
                           styleClass="boton_fieldset"
                           reRender = "formExamenParaclinico"
                           disabled="#{examenParaclinicoBean.modoConsulta}"
                           action="#{examenParaclinicoBean.generarRemision}"/>
      </h:panelGroup>
    </h:panelGrid>
    </a4j:region>
    <f:subview id="generarExamenParaclinico"
               rendered="#{examenParaclinicoBean.generoDocPDF}">
      <f:verbatim>
        <script type="text/javascript" language="JavaScript">
           window.open("<%=request.getSession().getAttribute(PdfServlet.DOCUMENT_NAME_ATTRIBUTE_NAME)%>", "Documento" , "width=800,height=600");
        </script>
      </f:verbatim>
    </f:subview>
  </h:panelGrid>
</a4j:region>

</t:panelTab>
</t:panelTabbedPane>
</h:panelGrid>
</a4j:region>
</a4j:form>