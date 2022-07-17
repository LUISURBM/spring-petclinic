<%@ page contentType="text/html;charset=iso-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsf/html" prefix="h"%>
<%@ taglib uri="http://java.sun.com/jsf/core" prefix="f"%>
<%@ taglib uri="http://richfaces.org/a4j" prefix="a4j"%>
<%@ taglib uri="http://myfaces.apache.org/tomahawk" prefix="t"%>
<%@ taglib uri="http://myfaces.apache.org/sandbox" prefix="s"%>
<%@ page import="org.profamilia.hc.view.servlet.XlsServlet"%>
<a4j:form id="reporteActividadesEducativasForm">
  <a4j:region id="bodyRegionReporteActividadesEducativas">
    <a4j:status id="statusButton" for="bodyRegionReporteActividadesEducativas">
      <f:facet name="start">
        <t:div id="charginReporteGestacion" styleClass="loading">
          <h:panelGrid columns="1" cellpadding="0" cellspacing="0" border="0">
            <h:outputText value="Procesando..."/>
            <h:outputText value="Por favor espere."/>
          </h:panelGrid>
        </t:div>
      </f:facet>
      <f:facet name="stop"/>
    </a4j:status>
    <h:panelGrid columns="1" border="0" cellpadding="0" cellspacing="0" width="100%" id="panelGridReporteGestacionTab"
                 styleClass="tabContainer">
      <t:panelTabbedPane border="0" cellpadding="0" cellspacing="0" serverSideTabSwitch="false" activePanelTabVar="true"
                         width="100%" id="panelTabbedPaneReporteActividadesEducativas" styleClass="tabbedPane"
                         activeTabStyleClass="activeTab" inactiveTabStyleClass="inactiveTab"
                         disabledTabStyleClass="disabledTab" activeSubStyleClass="activeSub"
                         inactiveSubStyleClass="inactiveSub" tabContentStyleClass="tabContent">
        <t:panelTab id="panelTabReporteActividadesEducativas" label="Gesti�n de Noticias">
          <h:panelGrid columns="1" border="0" cellpadding="0" cellspacing="0" width="100%"
                       id="panelGridReporteActividadesEducativas">
            <s:fieldset legend="#{noticiasBean.lblFieldset}" id="fieldnoticia" styleClass="fieldset">
              <h:panelGrid columns="2" border="0" cellpadding="0" cellspacing="0" width="70%"
                           id="panelDatosReporteActividadesEducativas" rowClasses="labelText,labelTextInfo">
                <h:outputText value="Nombre de la Noticia" styleClass="labelTextOblig"/>
                <h:outputText value="Link de la Noticia"/>
                <h:panelGroup>
                  <h:inputText id="innom" value="#{noticiasBean.noticia.hnocnomnot}" required="true" maxlength="50"/>
                   <a4j:outputPanel ajaxRendered="true">
                      <t:message for="innom" styleClass="errorMessage"/>
                    </a4j:outputPanel>
                    </h:panelGroup>
                    <h:panelGroup>
                    <h:inputText id="inlin" value="#{noticiasBean.noticia.hnoclinnot}"  maxlength="100"/>
                      <a4j:outputPanel ajaxRendered="true">
                      <t:message for="inlin" styleClass="errorMessage"/>
                    </a4j:outputPanel>
                    </h:panelGroup>
                <h:outputText value="Descripci�n " styleClass="labelTextOblig"/>
                <h:outputText value=""/>
                <h:panelGroup>
                 <h:inputTextarea id="textnot" value="#{noticiasBean.noticia.hnocdesnot}"  required="true"  style="width:350px">
                <f:validateLength maximum="500"/>
                </h:inputTextarea>
                <a4j:outputPanel ajaxRendered="true">
                      <t:message for="textnot" styleClass="errorMessage"/>
                    </a4j:outputPanel>
                </h:panelGroup>
                <h:outputText/>
                 <a4j:commandLink id="agregarAnestesiologo"  action="#{noticiasBean.guardarNoticia}"
                                 value="#{noticiasBean.lblAdicion}" reRender="tableNoticias,fieldnoticia">
                  <t:graphicImage border="0" url="/comun/imagenes/fnd_boton_agregar.gif" alt="Agregar"/>
                </a4j:commandLink>
              
              
           
              </h:panelGrid>     
            </s:fieldset>
            <s:fieldset legend ="Lista de Noticias" styleClass="fieldset" >
                  <a4j:region renderRegionOnly="false">
          <h:panelGrid columns="1" border="0" cellpadding="0" cellspacing="0" width="100%"
                       id="tableNoticias" styleClass="tabContainer">
            <t:buffer into="#{table}">
              <h:dataTable var="item"  border="1" cellpadding="0" cellspacing="0"
               styleClass="standard_table"
                         rowClasses="standardTable_Row1,standardTable_Row2"
                binding="#{noticiasBean.dtnoticia}"
                           rendered="#{not empty noticiasBean.lstnoticia}"
                           value="#{noticiasBean.lstnoticia}" rows="5"
                           id="dtAnestesiologo">
  
             
               <h:column>
                  <f:facet name="header">
                    <h:outputText value="Nombre Noticia"/>
                  </f:facet>
                  <h:outputText value="#{item.hnocnomnot}"/>
                  </h:column>

              <h:column>              
                  <f:facet name="header">
                    <h:outputText value="Descripci�n"/>                   
                  </f:facet>
                    <h:outputText value="#{item.hnocdesnot}"/>
                  </h:column>
                 
            <h:column>
                  <f:facet name="header">
                    <h:outputText value="Link Noticia"/>
                  </f:facet>
                      <h:outputLink  value="#{item.hnoclinnot}"  target="_blank"  >
                        <h:outputText value="#{item.hnoclinnot}" />
                    </h:outputLink>
                   </h:column>
              
                
        <h:column>
                  <f:facet name="header">
                    <h:outputText value="Acciones"/>
                  </f:facet>
                  <h:panelGrid columns="2" >
                  <a4j:commandLink id="Editar"
                              
                                   action="#{noticiasBean.editarNoticia}" immediate="true"
                                   >
                    <t:graphicImage border="0" alt="" url="/comun/imagenes/editar2.gif"/>
                  </a4j:commandLink>
                     <a4j:commandLink id="eliminar"
                                   onclick="if(!confirm(\' Desea remover este registro ? \')){ return false; }"
                                   action="#{noticiasBean.cambiarEstadoNoticia}" immediate="true"
                                   reRender="tableNoticias">
                    <t:graphicImage border="0" alt="" url="/comun/imagenes/eliminar.gif"/>
                  </a4j:commandLink>
                  </h:panelGrid>
                  </h:column>
              </h:dataTable>
            </t:buffer>
            <t:buffer into="#{tableScroller}">
              <h:panelGrid columns="1" rowClasses="labelTextInfo,labelTextInfo">
                <t:dataScroller id="scroll" for="dtAnestesiologo" fastStep="10" pageCountVar="pageCount"
                                pageIndexVar="pageIndex" styleClass="scroller" paginator="true" immediate="true"
                                paginatorMaxPages="9" paginatorTableClass="paginator" renderFacetsIfSinglePage="false"
                                paginatorActiveColumnStyle="font-weight:bold;">
                  <f:facet name="first">
                    <t:graphicImage url="/comun/imagenes/primero.gif" alt="" border="0"/>
                  </f:facet>
                  <f:facet name="last">
                    <t:graphicImage url="/comun/imagenes/ultimo.gif" alt="" border="0"/>
                  </f:facet>
                  <f:facet name="previous">
                    <t:graphicImage url="/comun/imagenes/anterior.gif" alt="" border="0"/>
                  </f:facet>
                  <f:facet name="next">
                    <t:graphicImage url="/comun/imagenes/siguiente.gif" alt="" border="0"/>
                  </f:facet>
                  <f:facet name="fastforward">
                    <t:graphicImage url="/comun/imagenes/adelante.gif" alt="" border="0"/>
                  </f:facet>
                  <f:facet name="fastrewind">
                    <t:graphicImage url="/comun/imagenes/atras.gif" alt="" border="0"/>
                  </f:facet>
                </t:dataScroller>
              </h:panelGrid>
            </t:buffer>
            <h:outputText value="#{tableScroller}" escape="false"/>
            <h:outputText value="#{table}" escape="false"/>
            <h:outputText value="#{tableScroller}" escape="false"/>
          </h:panelGrid>
          </a4j:region>
            </s:fieldset>
          </h:panelGrid>
        </t:panelTab>
        <h:commandLink action="#{reporteActividadesEducativasBean.volverInicio}" immediate="true">
          <t:graphicImage alt="" border="0" url="/comun/imagenes/volver.gif" align="Volver"/>
        </h:commandLink>
      </t:panelTabbedPane>
    </h:panelGrid>
  </a4j:region>
</a4j:form>