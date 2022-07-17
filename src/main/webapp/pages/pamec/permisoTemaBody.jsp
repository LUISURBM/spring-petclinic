<%@ page contentType="text/html;charset=iso-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsf/html" prefix="h"%>
<%@ taglib uri="http://java.sun.com/jsf/core" prefix="f"%>
<%@ taglib uri="http://richfaces.org/a4j" prefix="a4j"%>
<%@ taglib uri="http://myfaces.apache.org/tomahawk" prefix="t"%>
<%@ taglib uri="http://myfaces.apache.org/sandbox" prefix="s"%>
<a4j:form id="infoPermisoTemaForm">
  <a4j:region id="bodyRegionPermisoTema">
    <a4j:status for="bodyRegionPermisoTema">
      <f:facet name="start">
        <t:div id="chargindPermisoTema" styleClass="loading">
          <h:panelGrid columns="1" cellpadding="0" cellspacing="0" border="0">
            <h:outputText value="Procesando..."/>
            <h:outputText value="Por favor espere."/>
          </h:panelGrid>
        </t:div>
      </f:facet>
      <f:facet name="stop"/>
    </a4j:status>
     <t:panelTabbedPane border="0" cellpadding="0" cellspacing="0" serverSideTabSwitch="false" activePanelTabVar="true" width="100%" id="panelTabbedPanePermisoTema" styleClass="tabbedPane"
                     activeTabStyleClass="activeTab" inactiveTabStyleClass="inactiveTab" disabledTabStyleClass="disabledTab" activeSubStyleClass="activeSub" inactiveSubStyleClass="inactiveSub"
                     tabContentStyleClass="tabContent">

    
     <t:panelTab id="panelTabPermisoTema" label="Permisos Tema">
    <a4j:region renderRegionOnly="false">
      <s:fieldset legend="Permisos Tema" id="fieldSetInfoPermisoTema" styleClass="fieldset">
        <h:panelGrid columns="4" border="0" cellpadding="0" cellspacing="0" width="100%" id="panelRegionPermisoTema"
                     rowClasses="labelText,labelTextInfo"> 
                     
                  
                    <h:outputText value = "Tema" styleClass="labelTextOblig"/>
                    <h:outputText value = ""/>
                    
                    <h:outputText value = "Usuario" styleClass="labelTextOblig"/>
                    <h:outputText value = ""/>
                    
                    
                      <h:selectOneMenu id = "menuTema" value ="#{permisoTemaBean.wcodigoTema}" required="true">
                       <f:selectItems value = "#{permisoTemaBean.lstTema}"/>
                     </h:selectOneMenu>
                      <a4j:outputPanel ajaxRendered="true">
                           <t:message for="menuTema" styleClass="errorMessage"/>
                     </a4j:outputPanel>
                     
                      <h:selectOneMenu id = "menuUsuario" value ="#{permisoTemaBean.wusuario}" required="true">
                       <f:selectItems value = "#{permisoTemaBean.lstUsuario}"/>
                     </h:selectOneMenu>
                      <a4j:outputPanel ajaxRendered="true">
                           <t:message for="menuUsuario" styleClass="errorMessage"/>
                     </a4j:outputPanel>
                     
                  
          
        </h:panelGrid>
           <h:panelGrid columns="1" border="0" cellpadding="0" cellspacing="0" width="100%" id="panelBotonPermisoTema"
      columnClasses="panelGridBotones">
        <h:commandButton value="Asignar Permiso" styleClass="boton"  
                           action="#{permisoTemaBean.asignarPermiso}"/>
      </h:panelGrid>
      </s:fieldset>
      
     <s:fieldset legend="Lista Permisos Temas" id="fieldListaPermisosTema" styleClass="fieldset">
          <h:panelGrid columns="1" id="panelGridListaPermisosTemas" 
          rendered="#{empty permisoTemaBean.lstPermiso}">
            <h:outputText value="No existen Permisos "/>
          </h:panelGrid>
          <a4j:region renderRegionOnly="false">
            <h:panelGrid columns="1" border="0" cellpadding="0" cellspacing="0" width="100%" id="panelTemasTable"
                         styleClass="tabContainer" rendered="#{not empty permisoTemaBean.lstPermiso}">
              <t:buffer into="#{table}">
                <h:dataTable var="item" border="0" cellpadding="0" 
                            binding="#{permisoTemaBean.dtPermiso}" cellspacing="0"
                             value="#{permisoTemaBean.lstPermiso}" rows="10" styleClass="standard_table"
                             rowClasses="standardTable_Row1,standardTable_Row2" footerClass="paginacion" 
                             id="dtPermiso">
                             
                             
                <h:column>
                    <f:facet name="header">
                      <h:outputText value="Tema"/>
                    </f:facet>
                    <h:outputText value="#{item[1]}"/>
                  </h:column>
                  <h:column>
                    <f:facet name="header">
                      <h:outputText value="Usuario"/>
                    </f:facet>
                    <h:outputText value="#{item[3]}"/>
                  </h:column>
              
                  <h:column>
                    <f:facet name="header">
                      <h:outputText value="Eliminar "/>
                    </f:facet>
                    <t:commandButton id="eliminarTema" value="Eliminar" immediate="true"
                                     action="#{permisoTemaBean.eliminarPermiso}"
                                     onclick="return confirmar(\'Realmente desea eliminar el permiso?\')"
                                     image="/comun/imagenes/eliminarObj.gif"></t:commandButton>
                  </h:column>
                   
                </h:dataTable>
              </t:buffer>
              <t:buffer into="#{tableScroller}">
                <h:panelGrid columns="1" rowClasses="labelTextInfo,labelTextInfo">
                  <t:dataScroller id="scroll_Grupo" for="dtPermiso" fastStep="10" pageCountVar="pageCount"
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
          </a4j:region>
        </s:fieldset>
      
      </a4j:region>
      
         
    </t:panelTab>
    </t:panelTabbedPane>
     <h:panelGrid>
          <h:panelGroup>
            <a4j:outputPanel id="ajaxRegionMensajesPermisoTema" ajaxRendered="true">
              <t:htmlTag value="br"/>
              <t:messages id="msgInfPermisoTema" showSummary="true" errorClass="error" globalOnly="true" layout="table"
                          infoClass="informacion"/>
            </a4j:outputPanel>
          </h:panelGroup>
        </h:panelGrid>
         
  </a4j:region>
</a4j:form>