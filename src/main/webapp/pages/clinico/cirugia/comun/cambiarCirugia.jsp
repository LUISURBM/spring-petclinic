<%@ page contentType="text/html;charset=iso-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsf/core" prefix="f"%>
<%@ taglib uri="http://myfaces.apache.org/tomahawk" prefix="t"%>
<%@ taglib uri="http://java.sun.com/jsf/html" prefix="h"%>
<%@ taglib uri="http://myfaces.apache.org/sandbox" prefix="s"%>
<%@ taglib uri="http://richfaces.org/a4j" prefix="a4j"%>
    <link rel="stylesheet" type="text/css" href="<%=request.getContextPath()%>/comun/css/estilos.css"/>
        <link rel="stylesheet" type="text/css" href="<%=request.getContextPath()%>/comun/css/estilos2.css"/>
    <link rel="stylesheet" type="text/css" href="<%=request.getContextPath()%>/comun/css/bootstrap.css"/>
    <link rel="stylesheet" type="text/css" href="<%=request.getContextPath()%>/comun/css/bootstrap.min.css"/>
    <link rel="stylesheet" type="text/css" href="<%=request.getContextPath()%>/comun/css/bootstrap-responsive.css"/>
    <link rel="stylesheet" type="text/css" href="<%=request.getContextPath()%>/comun/css/bootstrap-responsive.min.css"/>
<h:panelGrid columns="1" border="0" cellpadding="0" cellspacing="0" width="100%" id="panelGridRegionCambiCirugias"
             styleClass="tabContainer">
  <a4j:region renderRegionOnly="false">
    <t:panelTabbedPane border="0" cellpadding="0" cellspacing="0" serverSideTabSwitch="false" activePanelTabVar="true"
                       width="100%" id="panelTabbedPaneCambiarCirugias" styleClass="tabbedPane"
                       activeTabStyleClass="activeTab" inactiveTabStyleClass="inactiveTab"
                       disabledTabStyleClass="disabledTab" activeSubStyleClass="activeSub"
                       selectedIndex="#{cambiarCirugiaBean.selectedIndex}" inactiveSubStyleClass="inactiveSub"
                       tabContentStyleClass="tabContent">
      <t:panelTab id="panelTabMostrarCambiarCirugias" label="Cirugias Programadas"
                  disabled="#{cambiarCirugiaBean.renderAdicionarCirugia}">
        <h:panelGrid columns="1" border="0" cellpadding="0" cellspacing="0" width="100%"
                     id="panelGridCambiarCirugia">
                        <h:panelGrid columns="1" id="panelGridNoCirugias"
                           >
                <h:outputText value="#{cambiarCirugiaBean.msg_no_cirugia}" style="color:blue"/>
              </h:panelGrid> 
                     
            <s:fieldset legend="Lista Cirugias Facturadas los Ultimos 3 Meses" id="fieldListaCirugias"
                      styleClass="fieldset" rendered="#{not empty cambiarCirugiaBean.lstCirugiasActivas}">
                      
                         
        
            <h:panelGrid columns="1" border="0" cellpadding="0" cellspacing="0" width="100%" id="tableContentTabs"
                         rendered="#{not empty cambiarCirugiaBean.lstCirugiasActivas}" styleClass="tabContainer">
              <t:buffer into="#{table}">
                <h:dataTable var="item" border="0" cellpadding="0" cellspacing="0"
                             binding="#{cambiarCirugiaBean.dtCirugiasActivas}"
                             value="#{cambiarCirugiaBean.lstCirugiasActivas}" styleClass="standard_table"
                             rowClasses="standardTable_Row1,standardTable_Row2" footerClass="paginacion" rows="10"
                             id="idDtCirugias">
                
                  <h:column>
                    <f:facet name="header">
                      <h:outputText value="Servicio"/>
                    </f:facet>
                    <h:outputText value="#{item.ccocservic.csvccodigo} #{item.ccocservic.csvcnombre}"/>
                  </h:column>
                  <h:column>
                    <f:facet name="header">
                      <h:outputText value="Tipo Documento"/>
                    </f:facet>
                    <h:outputText value="#{item.ccontipdoc.ctdnnumero} #{item.ccontipdoc.ctdcdescri}"/>
                  </h:column>
                  <h:column>
                    <f:facet name="header">
                      <h:outputText value="Número Documento"/>
                    </f:facet>
                    <h:outputText value="#{item.cconnumdoc}"/>
                  </h:column>
                  <h:column>
                    <f:facet name="header">
                      <h:outputText value="Fecha Registro"/>
                    </f:facet>
                    <h:outputText value="#{item.ccodfecreg}"/>
                  </h:column>
                     <h:column>
                    <f:facet name="header">
                    
                      <h:outputText value="Adicionar"/>
                      
                    </f:facet>
                    <a4j:commandLink id="adicionarCambiar" immediate="true"
                                     onclick="if(!confirm(\' Desea adicionar este registro ? \')){ return false; }"
                                     action="#{cambiarCirugiaBean.agregarCirugia}"
                                     reRender="panelGridRegionCambiCirugias">
                     <t:graphicImage  alt="" border="0" url="/comun/imagenes/fnd_boton_agregar.gif"/>
                    </a4j:commandLink>
                  </h:column>
                  
                </h:dataTable>
              </t:buffer>
              <t:buffer into="#{tableScroller}">
                <h:panelGrid columns="1" rowClasses="labelTextInfo,labelTextInfo">
                  <t:dataScroller id="scroll_1" for="idDtCirugias" fastStep="10" pageCountVar="pageCount"
                                  pageIndexVar="pageIndex" styleClass="scroller" paginator="true"
                                  renderFacetsIfSinglePage="false" paginatorMaxPages="9" paginatorTableClass="paginator"
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
                  <t:dataScroller id="scroll_2" for="idDtCirugias" rowsCountVar="rowsCount"
                                  displayedRowsCountVar="displayedRowsCountVar" firstRowIndexVar="firstRowIndex"
                                  lastRowIndexVar="lastRowIndex" pageCountVar="pageCount" pageIndexVar="pageIndex">
                    <h:outputFormat value="Registros : Total {0}, mostrados {1} del {2} al {3}  Pagina {4} / {5}"
                                    styleClass="standard">
                      <f:param value="#{rowsCount}"/>
                      <f:param value="#{displayedRowsCountVar}"/>
                      <f:param value="#{firstRowIndex}"/>
                      <f:param value="#{lastRowIndex}"/>
                      <f:param value="#{pageIndex}"/>
                      <f:param value="#{pageCount}"/>
                    </h:outputFormat>
                  </t:dataScroller>
                </h:panelGrid>
              </t:buffer>
              <h:outputText value="#{table}" escape="false"/>
            </h:panelGrid>
          </s:fieldset>
                     
          <s:fieldset legend="Lista Cirugias Programadas" id="fieldListaAgregarCambiarCirugias"
                      styleClass="fieldset">
            <h:panelGrid columns="1" id="panelGridCambiarCirugiasProgramadas"
                         rendered="#{empty cambiarCirugiaBean.lstCirugiasProgramadas}">
              <h:outputText value="#{msg.msg_sin_consultar}"/>
            </h:panelGrid>
            <h:panelGrid columns="1" border="0" cellpadding="0" cellspacing="0" width="100%"
                         id="tableContentCambiarCirugias"
                         rendered="#{not empty cambiarCirugiaBean.lstCirugiasProgramadas}"
                         styleClass="tabContainer">
              <t:buffer into="#{table}">
                <h:dataTable var="item" border="0" cellpadding="0" cellspacing="0"
                             binding="#{cambiarCirugiaBean.dtCirugiasProgramadas}"
                             value="#{cambiarCirugiaBean.lstCirugiasProgramadas}" styleClass="standard_table"
                             rowClasses="standardTable_Row1,standardTable_Row2" footerClass="paginacion" rows="10"
                             id="idDtCirugiasCambiarProgramadas">
                  <h:column>
                    <f:facet name="header">
                      <h:outputText value="Codigo"/>
                    </f:facet>
                    <h:outputText value="#{item.id.hdccservicio}"/>
                  </h:column>
                  <h:column>
                    <f:facet name="header">
                      <h:outputText value="Cirugia"/>
                    </f:facet>
                    <h:outputText value="#{item.hdccdescrservi}"/>
                  </h:column>
                  <h:column>
                    <f:facet name="header">
                      <h:outputText value="Medico"/>
                    </f:facet>
                    <h:panelGroup>
                      <h:selectOneMenu id="mnuProfesionalesCambiar" value="#{item.hdcnmedicatien}"
                                       disabled="#{cambiarCirugiaBean.deshabilitarMedicos}">
                        <f:selectItems value="#{cambiarCirugiaBean.lstProfesionales}"/>
                      </h:selectOneMenu>
                      <a4j:outputPanel ajaxRendered="true">
                        <t:message for="mnuProfesionalesCambiar" styleClass="errorMessage"/>
                      </a4j:outputPanel>
                    </h:panelGroup>
                  </h:column>
                  <h:column>
                    <f:facet name="header">
                    
                      <h:outputText value="Eliminar"/>
                      
                    </f:facet>
                    <a4j:commandLink id="eliminarCambiar" immediate="true"
                                     onclick="if(!confirm(\' Desea remover este registro ? \')){ return false; }"
                                     action="#{cambiarCirugiaBean.eliminarCirugia}"
                                     reRender="panelGridRegionCambiCirugias">
                     <t:graphicImage  alt="" border="0" url="/comun/imagenes/trash.png"/>
                    </a4j:commandLink>
                  </h:column>
                  <f:facet name="footer">
                    <a4j:commandLink id="aceptarCambiar" immediate="true" reRender="panelGridRegionCambiCirugias"
                                    rendered="#{cambiarCirugiaBean.renderIconEliminar}"
                                     action="#{cambiarCirugiaBean.adicionarCirugias}">
                      <t:graphicImage alt="" border="0" url="/comun/imagenes/nuevo.jpg"/>
                    </a4j:commandLink>
                  </f:facet>
                </h:dataTable>
              </t:buffer>
              
              <t:buffer into="#{tableScroller}">
                <h:panelGrid columns="1" rowClasses="labelTextInfo,labelTextInfo">
                  <t:dataScroller id="scroll_Cambiar" for="idDtCirugiasCambiarProgramadas" fastStep="10"
                                  pageCountVar="pageCount" pageIndexVar="pageIndex" styleClass="scroller"
                                  paginator="true" renderFacetsIfSinglePage="false" paginatorMaxPages="9"
                                  paginatorTableClass="paginator" paginatorActiveColumnStyle="font-weight:bold;">
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
          
      
        </h:panelGrid>
      </t:panelTab>
    
      
      
       
        
        <h:panelGrid>
              <h:panelGroup>
                <a4j:outputPanel id="ajaxRegionMensajeCambiarNoFactura" ajaxRendered="true">
                  <t:messages id="msgCambiarNoExisteFactura" showSummary="true" errorClass="error" globalOnly="true"
                              layout="table" infoClass="informacion"/>
                </a4j:outputPanel>
              </h:panelGroup>
            </h:panelGrid>
      
    </t:panelTabbedPane>
  </a4j:region>
</h:panelGrid>