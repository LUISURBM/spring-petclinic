<%@ page contentType="text/html;charset=iso-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsf/html" prefix="h"%>
<%@ taglib uri="http://java.sun.com/jsf/core" prefix="f"%>
<%@ taglib uri="http://richfaces.org/a4j" prefix="a4j"%>
<%@ taglib uri="http://myfaces.apache.org/tomahawk" prefix="t"%>
<%@ taglib uri="http://myfaces.apache.org/sandbox" prefix="s"%>
<%@ page import="org.profamilia.hc.view.servlet.PdfServlet"%>
<h:panelGrid columns="1" border="0" cellpadding="0" cellspacing="0" width="100%" id="panelGridRemisionTab" styleClass="tabContainer">
  <jsp:include page="/pages/clinico/comunes/encabezadoDatosUsuario.jsp" flush="true"/>
  <t:panelTabbedPane border="0" cellpadding="0" cellspacing="0" serverSideTabSwitch="false" activePanelTabVar="true" width="100%" id="panelTabbedPaneRemision" styleClass="tabbedPane"
                     activeTabStyleClass="activeTab" inactiveTabStyleClass="inactiveTab" 
                      selectedIndex="#{interConsultaUsuarioBean.selectedIndex}"
                     disabledTabStyleClass="disabledTab" activeSubStyleClass="activeSub" inactiveSubStyleClass="inactiveSub"
                     tabContentStyleClass="tabContent">
    <t:panelTab id="panelTabRemision" label="Remisi�n" rendered="#{!interConsultaUsuarioBean.renderPlantilla}">
      <h:panelGrid columns="1" border="0" cellpadding="0" cellspacing="0" width="100%" id="panelGridInterconsulta">
      <s:fieldset legend="Servicios Propuestos " id="fieldServiAdmision" styleClass="fieldset" rendered="#{not empty interConsultaUsuarioBean.cfdetafacturaList}">
          <h:panelGrid columns="1" border="0" cellpadding="0" cellspacing="0" width="100%" id="tableContentTabsServInter"
                       rendered="#{not empty interConsultaUsuarioBean.cfdetafacturaList}">
            <t:buffer into="#{table}">
              <h:dataTable var="itemAdmin" border="0" cellpadding="0" cellspacing="4"
                           binding="#{interConsultaUsuarioBean.tableServiciosAdmision}"
                           value="#{interConsultaUsuarioBean.cfdetafacturaList}" rows="30" styleClass="standard_table"
                           rowClasses="standardTable_Row1,standardTable_Row2" footerClass="paginacion"
                           id="tdatosServInter">
                <h:column>
                  <f:facet name="header">
                    <h:outputText value="Codigo Servicio"/>
                  </f:facet>
                  <h:outputText value="#{itemAdmin.cdfcservicio}"></h:outputText>
                </h:column>
                <h:column>
                  <f:facet name="header">
                    <h:outputText value="Nombre Servicio"/>
                  </f:facet>
                  <h:outputText value="#{itemAdmin.nombreServicio}"></h:outputText>
                </h:column>
                <h:column>
                  <f:facet name="header">
                    <h:outputText value="Descripcion Servicio"/>
                  </f:facet>
                   <h:inputTextarea immediate="true" value="#{itemAdmin.descripcionServicio}" style="width:350px" valueChangeListener="#{itemAdmin.setDescripcionServi}" disabled="#{itemAdmin.validacionConsultaClinica}" />
                </h:column>
                <h:column>
                  <f:facet name="header">
                    <h:outputText value="Agregar"/>
                  </f:facet>
                  <h:commandLink id="agregarServiAdm" immediate="true" rendered="#{!itemAdmin.validacionConsultaClinica}"
                                 action="#{interConsultaUsuarioBean.agregarServicioPropuesto}">
                    <t:graphicImage alt=""  border="0" url="/comun/imagenes/adicionar.gif" />
                  </h:commandLink>
                </h:column>
              </h:dataTable>
            </t:buffer>
            <t:buffer into="#{tableScroller}">
              <h:panelGrid columns="1" rowClasses="labelTextInfo,labelTextInfo">
                <t:dataScroller id="scroll_Admin" for="tdatosServInter" fastStep="10" pageCountVar="pageCount"
                                pageIndexVar="pageIndex" styleClass="scroller" paginator="true" paginatorMaxPages="9"
                                paginatorTableClass="paginator" renderFacetsIfSinglePage="false"
                                paginatorActiveColumnStyle="font-weight:bold;"></t:dataScroller>
              </h:panelGrid>
            </t:buffer>
            <h:outputText value="#{tableScroller}" escape="false"/>
            <h:outputText value="#{table}" escape="false"/>
            <h:outputText value="#{tableScroller}" escape="false"/>
          </h:panelGrid>

        </s:fieldset> 
      
      
        <s:fieldset legend="Datos Interconsulta" id="fieldInterconsulta" styleClass="fieldset">
          <a4j:region id="regionInterconsulta" renderRegionOnly="false">
            <h:panelGrid columns="4" border="0" cellpadding="0" cellspacing="0" width="100%" 
            id="panelDatosInterconsulta" 
                         rowClasses="labelText,labelTextInfo">
              <h:outputText value="Tipo Interconsulta" styleClass="labelTextOblig"/>
              <h:outputText value=" "/>
              <h:outputText value="Descripcion " styleClass="labelTextOblig"/>
              <h:outputText value=" "/>
          
              
              
         <h:panelGrid columns="4" border="0" cellpadding="0" cellspacing="0">
              <a4j:commandLink action="#{interConsultaUsuarioBean.mostrarInterconsulta}"
                               reRender="panelGridRemisionTab">
                <a4j:ajaxListener type="org.ajax4jsf.ajax.ForceRender"/>
                <t:graphicImage alt="" border="0" url="/comun/imagenes/lupa.gif"/>
              </a4j:commandLink>
              <a4j:region renderRegionOnly="false">
              <h:inputText id="itInterconsulta" onkeydown="return blockEnter(event);" styleClass="textmayuscula"
                           value="#{interConsultaUsuarioBean.consultaSelect}"
                           valueChangeListener="#{interConsultaUsuarioBean.setConsultaSelect}" 
                           style="width:80px"
                           maxlength="12" immediate="true"
                           binding="#{interConsultaUsuarioBean.inputInterconsulta}">
                <f:converter converterId="cadena.stringUpperCaseConverter"/>
                <a4j:support id="supportitInterconsulta" event="onchange" ignoreDupResponses="true"
                             action="#{interConsultaUsuarioBean.changeInterconsulta}"
                             reRender="panelInterconsulta">
                  <a4j:ajaxListener type="org.ajax4jsf.ajax.ForceRender"/>
                </a4j:support>
              </h:inputText>
              </a4j:region>
              <h:panelGrid columns="1" border="0" cellpadding="0" cellspacing="2" id="panelInterconsulta">
                <h:outputText value=" #{interConsultaUsuarioBean.descripcionInterconsulta}" styleClass="buscador"/>
              </h:panelGrid>
              
            </h:panelGrid>
              
              
              <a4j:outputPanel ajaxRendered="true">
                <t:message for="itInterconsulta" styleClass="errorMessage"/>
              </a4j:outputPanel>
              <h:inputTextarea id="inputDescripcionConsulta" onkeydown="return blockEnter(event);"
                value="#{interConsultaUsuarioBean.descripcion}" style="width:350px"/>
              <a4j:outputPanel ajaxRendered="true">
                <t:message for="inputDescripcionConsulta" styleClass="errorMessage"/>
              </a4j:outputPanel>
            </h:panelGrid>
            <h:panelGrid columns="2" border="0" cellpadding="0" cellspacing="0" width="100%" id="panelBotonAgregarInterconsulta" columnClasses="panelGridBotones">
              <h:panelGroup>
                <t:htmlTag value="br"/>
                <a4j:commandButton value="Agregar" styleClass="btn btn btn-success" action="#{interConsultaUsuarioBean.agregarInterconsulta}"
                                   reRender="panelGridRemisionTab"/>
              </h:panelGroup>
            </h:panelGrid>
          </a4j:region>
        </s:fieldset>
        <a4j:region renderRegionOnly="false">
          <s:fieldset legend="Lista Interconsulta " id="fieldInterconsultaLista" styleClass="fieldset"  rendered="#{not empty interConsultaUsuarioBean.lstRemision}">
            <h:panelGrid columns="1" border="0" cellpadding="0" cellspacing="0" width="100%" id="panelInterconsultaTable">
              <t:buffer into="#{table}">
                <h:dataTable var="item" border="0" cellpadding="0" binding="#{interConsultaUsuarioBean.dtRemision}" cellspacing="2" value="#{interConsultaUsuarioBean.lstRemision}" rows="10"
                             styleClass="standard_table" rowClasses="standardTable_Row1,standardTable_Row2" footerClass="paginacion" id="dtRemision">
                  <h:column>
                    <f:facet name="header">
                      <h:outputText value="Tipo Interconsulta"/>
                    </f:facet>
                    
                     <h:selectOneMenu id = "menuTipoInter" value="#{item.hrecservicio}" style="width:500px" disabled="true">
                      <f:selectItems value="#{interConsultaUsuarioBean.lstTipoConsulta}"/>
                      </h:selectOneMenu>
                   
                  </h:column>
                  <h:column>
                    <f:facet name="header">
                      <h:outputText value="Descripcion"/>
                    </f:facet>
                    <h:outputText value="#{item.hrecdescripcio}"/>
                  </h:column>
                  <h:column>
                    <f:facet name="header">
                      <h:outputText value="Eliminar"/>
                    </f:facet>
                    <h:commandLink id="eliminar"  rendered="#{!item.modoconsulta}"
                        immediate="true" action="#{interConsultaUsuarioBean.eliminarRemision}">
                      <t:graphicImage alt=""  border="0" url="/comun/imagenes/editar.gif"/>
                    </h:commandLink>
                  </h:column>
                </h:dataTable>
              </t:buffer>
              <t:buffer into="#{tableScroller}">
                <h:panelGrid columns="1" rowClasses="labelTextInfo,labelTextInfo">
                  <t:dataScroller id="scroll_Interconsulta" for="dtRemision" fastStep="10" pageCountVar="pageCount" pageIndexVar="pageIndex" styleClass="scroller" paginator="true" immediate="true"
                                  paginatorMaxPages="9" paginatorTableClass="paginator" renderFacetsIfSinglePage="false" paginatorActiveColumnStyle="font-weight:bold;">
                    <f:facet name="first">
                      <t:graphicImage alt=""  url="/comun/imagenes/primero.gif" border="0"/>
                    </f:facet>
                    <f:facet name="last">
                      <t:graphicImage alt=""  url="/comun/imagenes/ultimo.gif" border="0"/>
                    </f:facet>
                    <f:facet name="previous">
                      <t:graphicImage alt=""  url="/comun/imagenes/anterior.gif" border="0"/>
                    </f:facet>
                    <f:facet name="next">
                      <t:graphicImage alt=""  url="/comun/imagenes/siguiente.gif" border="0"/>
                    </f:facet>
                    <f:facet name="fastforward">
                      <t:graphicImage alt=""  url="/comun/imagenes/adelante.gif" border="0"/>
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
        <a4j:region renderRegionOnly="false">
          <h:panelGroup>
            <a4j:outputPanel id="ajaxRegionRemisionMsg" ajaxRendered="true">
              <t:htmlTag value="br"/>
              <t:messages id="msgRemisionMsg" showSummary="false" errorClass="error" globalOnly="true" layout="table" infoClass="informacion" showDetail="true" tooltip="true" warnClass="advertencia"/>
              <t:htmlTag value="br"/>
            </a4j:outputPanel>
          </h:panelGroup>
          <h:panelGrid columns="1" border="0" cellpadding="0" cellspacing="0" width="100%" id="panelBotonInterconsulta" columnClasses="panelGridBotones">
            <h:panelGroup>
              <a4j:commandButton value="Generar Remision" reRender="panelGridRemisionTab" styleClass="btn btn btn-success" 
                                 action="#{interConsultaUsuarioBean.generarRemision}"/>
            </h:panelGroup>
          </h:panelGrid>
        </a4j:region>
        <f:subview id="generarInterconsulta" rendered="#{interConsultaUsuarioBean.generoDocPDF}">
          <f:verbatim>
            <script type="text/javascript" language="JavaScript">
                window.open("<%=request.getSession().getAttribute(PdfServlet.DOCUMENT_NAME_ATTRIBUTE_NAME)%>", "Documento" , "width=800,height=600");
            </script>
          </f:verbatim>
        </f:subview>
      </h:panelGrid>
    </t:panelTab>
    
    
    
    
     <t:panelTab id="panelBuscador" label="Buscar Interconsulta"
                rendered="#{interConsultaUsuarioBean.renderPlantilla}">
      <a4j:region id="regionInterconsulta" renderRegionOnly="false">
        <a4j:status id="statusButton" for="regionInterconsulta">
          <f:facet name="start">
            <t:div id="chargingInterconsulta" styleClass="loading">
              <h:panelGrid columns="1" cellpadding="0" cellspacing="0" border="0">
                <h:outputText value="Procesando..."/>
                <h:outputText value="Por favor espere."/>
              </h:panelGrid>
            </t:div>
          </f:facet>
          <f:facet name="stop"/>
        </a4j:status>
        <jsp:include page="/pages/clinico/comunes/buscador/buscadorInterconsulta.jsp" flush="true"/>
      </a4j:region>
    </t:panelTab>
    
    
    
  </t:panelTabbedPane>
      <script language="javascript" type="text/javascript">
        document.forms[1].elements[6].focus()
</script>
</h:panelGrid>