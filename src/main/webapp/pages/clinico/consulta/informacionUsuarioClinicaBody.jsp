<%@ page contentType="text/html;charset=windows-1252"%>
<%@ taglib uri="http://java.sun.com/jsf/html" prefix="h"%>
<%@ taglib uri="http://java.sun.com/jsf/core" prefix="f"%>
<%@ taglib uri="http://richfaces.org/a4j" prefix="a4j"%>
<%@ taglib uri="http://myfaces.apache.org/tomahawk" prefix="t"%>
<%@ taglib uri="http://myfaces.apache.org/sandbox" prefix="s"%>
<a4j:form id="infoUsuarioClinicaForm">
  <a4j:region id="bodyRegionUsuarioClinica">
    <a4j:status id="statusButton" for="bodyRegionUsuarioClinica">
      <f:facet name="start">
        <t:div id="chargindDivUsuarioClinica" styleClass="loading">
          <h:panelGrid columns="1" cellpadding="0" cellspacing="0" border="0">
            <h:outputText value="Procesando..."/>
            <h:outputText value="Por favor espere."/>
          </h:panelGrid>
        </t:div>
      </f:facet>
      <f:facet name="stop"/>
    </a4j:status>
    
      <h:panelGrid columns="1" id="tableInformacionClinicaUsuario" border="0" cellpadding="0"
                 cellspacing="0" width="100%" styleClass="td_ubicador">
        <h:outputText value="Informacion Usuario "
                      id="infoUbication"/>
    </h:panelGrid>
    
        <h:panelGrid columns="1" border="0" cellpadding="0" cellspacing="0" width="100%" id="tableContentInfoUsuario"
                 styleClass="tabContainer">
      <s:fieldset legend="Datos Usuario" id="fieldSetInfoUsuario" styleClass="fieldset">
        <h:panelGrid columns="4" border="0" cellpadding="0" cellspacing="0" width="100%" id="panelRegionInfoUsuario"
                     rowClasses="labelText,labelTextInfo">
          <h:outputText value="Nombre del Usuario"/>   
          <h:outputText value = ""/>
          <h:outputText value="Centro"/>   
          <h:outputText value = ""/>
          <h:outputText  value="#{informacionUsuarioClinicaBean.usuario.curcnombre}"/>      
          <h:outputText value = ""/>
           <h:selectOneMenu id = "mnuClinicas" value = "#{informacionUsuarioClinicaBean.clinselec}" required="true">
           <f:selectItems value="#{informacionUsuarioClinicaBean.lstClinicaUsuario}"/>
           </h:selectOneMenu>
             <a4j:outputPanel ajaxRendered="true">
              <t:message for="mnuClinicas" styleClass="errorMessage"/>
            </a4j:outputPanel>
        </h:panelGrid>
          <h:panelGrid columns="2" border="0" cellpadding="0" cellspacing="0"
                     width="100%" id="panelBotonContinuar"
                     columnClasses="columnaBotonesCentrados">
         
          <t:htmlTag value="br"/>
          <h:commandButton value="Continuar"
                             action="#{informacionUsuarioClinicaBean.continuar}"
                             styleClass="boton_fieldset"
                             id="idButtonBuscarHistoria">
                             <a4j:support event="onclick" status="statusButton"/> 
                    </h:commandButton>
        </h:panelGrid>

      </s:fieldset>
    </h:panelGrid>
    
     

  
    
  </a4j:region>
</a4j:form>