<%@ page contentType="text/html;charset=iso-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsf/html" prefix="h"%>
<%@ taglib uri="http://java.sun.com/jsf/core" prefix="f"%>
<%@ taglib uri="http://richfaces.org/a4j" prefix="a4j"%>
<%@ taglib uri="http://richfaces.org/rich" prefix="rich"%>
<%@ taglib uri="http://myfaces.apache.org/tomahawk" prefix="t"%>
<%@ taglib uri="http://myfaces.apache.org/sandbox" prefix="s"%>

<a4j:form id="infoRegistrarParametroForm">
  <a4j:region id="bodyRegionRegistrarParametro">
    <a4j:status for="bodyRegionRegistrarParametro">
      <f:facet name="start">
        <t:div id="chargindRegistrarParametro" styleClass="loading">
          <h:panelGrid columns="1" cellpadding="0" cellspacing="0" border="0">
            <h:outputText value="Procesando..."/>
            <h:outputText value="Por favor espere."/>
          </h:panelGrid>
        </t:div>
      </f:facet>
      <f:facet name="stop"/>
    </a4j:status>
  <t:panelTabbedPane border="0" cellpadding="0" cellspacing="0" serverSideTabSwitch="false" activePanelTabVar="true"
                       width="100%" id="panelTabbedPaneDatosSAPUsuario" styleClass="tabbedPane"
                       activeTabStyleClass="activeTab" inactiveTabStyleClass="inactiveTab"
                       disabledTabStyleClass="disabledTab" activeSubStyleClass="activeSub"
                       selectedIndex="#{registrarSalaCirugiaBean.selectedIndex}" inactiveSubStyleClass="inactiveSub"
                       tabContentStyleClass="tabContent">
      <t:panelTab id="panelTabDatosSAPUsuario" label="Creación de Consultorios, Salas"
                  rendered="#{!registrarSalaCirugiaBean.renderSelecionarUsuario}">
      
        <s:fieldset legend="Creación de Consultorios, Salas" id="fieldSetInfoSAPBasica" styleClass="fieldset">
          <h:panelGrid columns="6" border="0" cellpadding="0" cellspacing="0" width="100%"
                       id="panelRegionInfoSAPConsulta" rowClasses="labelText,labelTextInfo">
                            
           
            <h:outputText value="Clinica" styleClass="labelTextOblig"/>
            <h:outputText value=""/>
            <h:outputText value="Tipo de Espacio" styleClass="labelTextOblig"/>
            <h:outputText value=""/>
            <h:outputText value="Descripción" styleClass="labelTextOblig"/>
            <h:outputText value=""/>
              
              <h:selectOneMenu id="mnuClinica" required="true"
                                 value="#{registrarSalaCirugiaBean.clinicaSala}">
                  <f:selectItems value="#{registrarSalaCirugiaBean.lstClinicas}"/>
                </h:selectOneMenu>
                <a4j:outputPanel ajaxRendered="true">
                  <t:message for="mnuClinica" styleClass="errorMessage"/>
                </a4j:outputPanel>
              
             <h:selectOneMenu id="mnuEspacio" value="#{registrarSalaCirugiaBean.tipConsulto}"> 
              <f:selectItems value="#{registrarSalaCirugiaBean.listEspacios}"/>
              </h:selectOneMenu>
               <a4j:outputPanel ajaxRendered="true">
                  <t:message for="mnuEspacio" styleClass="errorMessage"/>
                </a4j:outputPanel>
                
             <h:inputTextarea id="inputTareaDescrip" value="#{registrarSalaCirugiaBean.descriSala}" required="true" />   
               <a4j:outputPanel ajaxRendered="true">
                  <t:message for="inputTareaDescrip" styleClass="errorMessage"/>
                </a4j:outputPanel>
            
                
          </h:panelGrid>
            <h:commandButton value="Crear" styleClass="btn btn btn-success" action="#{registrarSalaCirugiaBean.crearSalaCirugia}"/>
        </s:fieldset>
      
          <h:panelGrid columns="1" border="0" cellpadding="0" cellspacing="0" width="100%" styleClass="tabcontainer"
                     id="panelGridServiciosSapTab">
          <s:fieldset legend="Consulta de Consultorios" id="fieldSetInfoServicio" styleClass="fieldset">
            <h:panelGrid columns="1" id="panelGridConsultarFoliosMedico"
                         rendered="#{empty registrarSalaCirugiaBean.lstConsultoriActivos}">
              <h:outputText value="#{msg.msg_sin_consultar}"/>
            </h:panelGrid>
            <h:panelGrid columns="1" id="panelGridEmpresa"
                         rendered="#{not empty registrarSalaCirugiaBean.lstConsultoriActivos}" width="100%"
                         style="text-align:center;">
              <t:buffer into="#{table}">
                <h:dataTable var="item" border="1" cellpadding="0" cellspacing="0"
                             value="#{registrarSalaCirugiaBean.lstConsultoriActivos}"
                             binding="#{registrarSalaCirugiaBean.dtConsulta}" styleClass="standard_table"
                             rowClasses="standardTable_Row1,standardTable_Row2" footerClass="paginacion" rows="10"
                             id="idDtProgHorario">
                  <h:column>
                    <f:facet name="header">
                      <h:outputText value="Clinica"/>
                    </f:facet>
                    <h:outputText value="#{item.id.hconclinica}"/>
                  </h:column>
                  <h:column>
                    <f:facet name="header">
                      <h:outputText value="Tipo Consulta"/>
                    </f:facet>
                    <h:outputText value="#{item.id.hcoctipoconsu}"/>
                  </h:column>
                  <h:column>
                    <f:facet name="header">
                      <h:outputText value="Descripción"/>
                    </f:facet>
                    <h:outputText value="#{item.hcocdescripcio}"/>
                  </h:column>
                  <h:column>
                    <f:facet name="header">
                      <h:outputText value="Fecha de Registro"/>
                    </f:facet>
                    <h:outputText value="#{item.hcodfecregistr}"/>
                  </h:column>
        
           
                </h:dataTable>
              </t:buffer>
              
              <t:buffer into="#{tableScroller}">
                <h:panelGrid columns="1" rowClasses="labelTextInfo,labelTextInfo">
                  <t:dataScroller id="scroll_1" for="idDtProgHorario" fastStep="10" pageCountVar="pageCount"
                                  pageIndexVar="pageIndex" styleClass="scroller" paginator="true"
                                  renderFacetsIfSinglePage="false" paginatorMaxPages="9" paginatorTableClass="paginator"
                                  paginatorActiveColumnStyle="font-weight:bold;">
                    <f:facet name="first">
                      <t:graphicImage url="/comun/imagenes/primero.gif" border="0"/>
                    </f:facet>
                    <f:facet name="last">
                      <t:graphicImage url="/comun/imagenes/ultimo.gif" border="0"/>
                    </f:facet>
                    <f:facet name="previous">
                      <t:graphicImage url="/comun/imagenes/anterior.gif" border="0"/>
                    </f:facet>
                    <f:facet name="next">
                      <t:graphicImage url="/comun/imagenes/siguiente.gif" border="0"/>
                    </f:facet>
                    <f:facet name="fastforward">
                      <t:graphicImage url="/comun/imagenes/adelante.gif" border="0"/>
                    </f:facet>
                    <f:facet name="fastrewind">
                      <t:graphicImage url="/comun/imagenes/atras.gif" border="0"/>
                    </f:facet>
                  </t:dataScroller>
                  <t:dataScroller id="scroll_2" for="idDtProgHorario" rowsCountVar="rowsCount"
                                  displayedRowsCountVar="displayedRowsCountVar" firstRowIndexVar="firstRowIndex"
                                  lastRowIndexVar="lastRowIndex" pageCountVar="pageCount" pageIndexVar="pageIndex">
                    <h:outputFormat value="#{msg.msg_datos_tablas}" styleClass="standard">
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
              <h:outputText value="#{tableScroller}" escape="false"/>
              <h:outputText value="#{table}" escape="false"/>
              <h:outputText value="#{tableScroller}" escape="false"/>
            </h:panelGrid>
          </s:fieldset>
        </h:panelGrid>
       
       
      </t:panelTab>
      
     
   
      <h:commandLink action="#{registrarSalaCirugiaBean.volver}" immediate="true">
        <t:graphicImage id="imageVolver" alt="volver" border="0" url="/comun/imagenes/volver.gif"/>
      </h:commandLink>
   
   
    </t:panelTabbedPane>
    <h:panelGrid>
      <h:panelGroup>
        <a4j:outputPanel id="ajaxRegionMensajes" ajaxRendered="true">
          <t:htmlTag value="br"/>
          <t:messages id="msgInf" showSummary="true" errorClass="error" globalOnly="true" layout="table"
                      infoClass="informacion"/>
        </a4j:outputPanel>
      </h:panelGroup>
    </h:panelGrid>
  </a4j:region>
</a4j:form>