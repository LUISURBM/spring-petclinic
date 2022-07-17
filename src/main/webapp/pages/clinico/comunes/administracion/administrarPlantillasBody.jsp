<%@ page contentType="text/html;charset=windows-1252"%>
<%@ taglib uri="http://java.sun.com/jsf/html" prefix="h"%>
<%@ taglib uri="http://java.sun.com/jsf/core" prefix="f"%>
<%@ taglib uri="http://richfaces.org/a4j" prefix="a4j"%>
<%@ taglib uri="http://myfaces.apache.org/tomahawk" prefix="t"%>
<%@ taglib uri="http://myfaces.apache.org/sandbox" prefix="s"%>
<a4j:form id="AdministrarPlantillaForm">
  <a4j:region id="bodyRegionAdministrarPlantilla">
    <a4j:status  id = "statusButton" for="bodyRegionAdministrarPlantilla">
      <f:facet name="start">
        <t:div id="charginAdministrarPlantilla" styleClass="loading">
          <h:panelGrid columns="1" cellpadding="0" cellspacing="0" border="0">
            <h:outputText value="Procesando..."/>
            <h:outputText value="Por favor espere."/>
          </h:panelGrid>
        </t:div>
      </f:facet>
      <f:facet name="stop"/>
    </a4j:status>
  
    <h:panelGrid columns="1" border="0" cellpadding="0" cellspacing="0" width="100%" id="panelGridAdministrarPlantillasTab" styleClass="tabContainer">
  <t:panelTabbedPane border="0" cellpadding="0" cellspacing="0" serverSideTabSwitch="false" activePanelTabVar="true" width="100%" id="panelTabbedPaneAdministrarPlantillas" styleClass="tabbedPane"
                     activeTabStyleClass="activeTab" inactiveTabStyleClass="inactiveTab" disabledTabStyleClass="disabledTab" activeSubStyleClass="activeSub" inactiveSubStyleClass="inactiveSub"
                     tabContentStyleClass="tabContent">
    <t:panelTab id="panelTabAdministrarPlantillas" label="Administrar Plantillas">
      <h:panelGrid columns="1" border="0" cellpadding="0" cellspacing="0" width="100%" id="panelGridAdministrarPlantilla">
        <s:fieldset legend="Datos Plantilla " id="fieldSetOrigen" styleClass="fieldset">
          <h:panelGrid columns="2" border="0" cellpadding="0" cellspacing="0" width="100%" id="panelDatosOrigen" rowClasses="labelText,labelTextInfo">
              <h:outputText id ="otPlantilla" value = "Nombre Plantilla"  styleClass="labelTextOblig"/>           
              <h:outputText/>
              <h:inputText id ="itPlantilla" required="true"
                  value = "#{administrarPlantillaBean.plantilla.hplcnombrplant}" style="width:300px"/>           
              <a4j:outputPanel ajaxRendered="true">
                    <t:message for="itPlantilla" styleClass="errorMessage"/>
              </a4j:outputPanel>
              
              <h:outputText id ="otDescripcionPlantilla" value = "Descripción Plantilla"  styleClass="labelTextOblig"/>   
              <h:outputText/>
              <h:inputTextarea id ="itDescripcionPlantilla" 
                    style="width:800px;height:100px" required="true"
                    value = "#{administrarPlantillaBean.plantilla.hplcdescripcio}"/>           
               <a4j:outputPanel ajaxRendered="true">
                    <t:message for="itDescripcionPlantilla" styleClass="errorMessage"/>
              </a4j:outputPanel>
              
          </h:panelGrid>
          
                <h:panelGrid columns="2" border="0" cellpadding="0" cellspacing="0" width="100%"
                         id="panelBotonAgregarFormula" columnClasses="columnaBotones">
              <h:panelGroup>
                <t:htmlTag value="br"/>
                <a4j:commandButton value="Agregar" styleClass="boton_fieldset"
                                   action="#{administrarPlantillaBean.agregarPlantilla}"
                                   reRender="panelGridAdministrarPlantillasTab"/>
              </h:panelGroup>
            </h:panelGrid>
        </s:fieldset>
        <a4j:region renderRegionOnly="false">
          <s:fieldset legend="Lista Plantillas" id="fieldPlantillas" styleClass="fieldset">
        <h:panelGrid columns="1" id="panelGridNoPlantillasSeleccionados" 
             rendered="#{empty administrarPlantillaBean.lstPlantillas}">
            <h:outputText value="#{msg.msg_sin_consultar}"/>
          </h:panelGrid>
      
              <h:panelGrid columns="1" border="0" cellpadding="0" cellspacing="0" width="100%" id="panelPlantillasTable" styleClass="tabContainer" 
              rendered="#{not empty administrarPlantillaBean.lstPlantillas}">
                <t:buffer into="#{table}">
                  <h:dataTable var="item" border="0" cellpadding="0" 
                               binding="#{administrarPlantillaBean.dtPlantilla}"  cellspacing="0" 
                               value="#{administrarPlantillaBean.lstPlantillas}" rows="10"
                               styleClass="standard_table" rowClasses="standardTable_Row1,standardTable_Row2" 
                               footerClass="paginacion" id="dtPlantilla">
                    <h:column>
                      <f:facet name="header">
                        <h:outputText value="Nombre Plantilla"/>
                      </f:facet>
                      <h:outputText value="#{item.hplcnombrplant}"/>
                    </h:column>
                    
                              
                    
                    <h:column>
                    <f:facet name="header">
                      <h:outputText value="Descripción Plantillas"/>
                    </f:facet>
                    <t:div style="overflow:auto;width:500px;height:50px;">
                      <h:panelGrid>
                        <h:outputText value="#{item.hplcdescripcio}"/>
                      </h:panelGrid>
                    </t:div>
                  </h:column>
                  <h:column>
                      <f:facet name="header">
                        <h:outputText value="Eliminar"/>
                      </f:facet>
                      <h:commandLink id="eliminar" immediate="true"  action="#{administrarPlantillaBean.eliminarPlantilla}">
                        <t:graphicImage alt=""  border="0" url="/comun/imagenes/eliminar.gif"/>
                      </h:commandLink>
                    </h:column>
                   
                   
                     <h:column>
                      <f:facet name="header">
                        <h:outputText value="Modificar"/>
                      </f:facet>
                      <h:commandLink id="modificar" immediate="true"  action="#{administrarPlantillaBean.verModificarPlantilla}">
                        <t:graphicImage alt=""  border="0" url="/comun/imagenes/editar.gif"/>
                      </h:commandLink>
                    </h:column>
                   
                  </h:dataTable>
                </t:buffer>
                <t:buffer into="#{tableScroller}">
                  <h:panelGrid columns="1" rowClasses="labelTextInfo,labelTextInfo">
                    <t:dataScroller id="scroll_Plantillas" for="dtPlantilla" fastStep="10" 
                          pageCountVar="pageCount" pageIndexVar="pageIndex" styleClass="scroller" paginator="true"
                          immediate="true" paginatorMaxPages="9" paginatorTableClass="paginator" 
                          renderFacetsIfSinglePage="false" paginatorActiveColumnStyle="font-weight:bold;">
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
        <h:panelGroup>
          <a4j:outputPanel id="ajaxRegionAdministrarPlantillaMsg" ajaxRendered="true">
            <t:htmlTag value="br"/>
            <t:messages id="msgInformationAdministrarPlantillaMsg" showSummary="false" errorClass="error" globalOnly="true" layout="table" infoClass="informacion" showDetail="true" tooltip="true"
                        warnClass="advertencia"/>
            <t:htmlTag value="br"/>
          </a4j:outputPanel>
        </h:panelGroup>
        
        <h:panelGrid columns="1" border="0" cellpadding="0" cellspacing="0" width="100%" id="panelBotonesAdministrarPlantilla" columnClasses="panelGridBotones">
          <h:panelGroup>
            <a4j:commandButton value="Guardar Plantilla" styleClass="boton_fieldset"
                               action="#{administrarPlantillaBean.aceptar}"/>
          </h:panelGroup>
        </h:panelGrid>
      </a4j:region>
      </h:panelGrid>
    </t:panelTab>
       <h:commandLink action="#{administrarPlantillaBean.volverInicio}" immediate="true">
          <t:graphicImage alt=""  border="0" url="/comun/imagenes/volver.gif" align="Volver"/>
        </h:commandLink>     
  </t:panelTabbedPane>
  </h:panelGrid>
  </a4j:region>
</a4j:form>