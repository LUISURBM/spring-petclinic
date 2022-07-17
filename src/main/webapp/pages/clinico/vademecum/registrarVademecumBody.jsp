<%@ page contentType="text/html;charset=iso-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsf/html" prefix="h"%>
<%@ taglib uri="http://java.sun.com/jsf/core" prefix="f"%>
<%@ taglib uri="http://richfaces.org/a4j" prefix="a4j"%>
<%@ taglib uri="http://richfaces.org/rich" prefix="rich"%>
<%@ taglib uri="http://myfaces.apache.org/tomahawk" prefix="t"%>
<%@ taglib uri="http://myfaces.apache.org/sandbox" prefix="s"%>
<a4j:form id="formDatosVademecum">
  <a4j:region id="regionVademecum" renderRegionOnly="false">
   <a4j:status id="statusButton" for="regionVademecum">
      <f:facet name="start">
        <t:div id="chargindDiv2" styleClass="loading">
          <h:panelGrid columns="1" cellpadding="0" cellspacing="0" border="0">
            <h:outputText value="Procesando..."/>
            <h:outputText value="Por favor espere."/>
          </h:panelGrid>
        </t:div>
      </f:facet>
      <f:facet name="stop"/>
    </a4j:status>
    <t:panelTabbedPane border="0" cellpadding="0" cellspacing="0" serverSideTabSwitch="false" activePanelTabVar="true"
                       width="100%" id="panelTabbedPaneDatosVademecum" styleClass="tabbedPane"
                       activeTabStyleClass="activeTab" inactiveTabStyleClass="inactiveTab"
                       disabledTabStyleClass="disabledTab" activeSubStyleClass="activeSub"
                       inactiveSubStyleClass="inactiveSub"
                       tabContentStyleClass="tabContent">
      <t:panelTab id="panelTabDatosVademecum" label="Registrar Medicamento Vademecum">

        <s:fieldset legend="Datos del Medicamento" id="fieldSetInfoDatosMedicamento" styleClass="fieldset">
          <h:panelGrid columns="6" border="0" cellpadding="0" cellspacing="0" width="100%" id="panelDatosMedicamento"
                       rowClasses="labelText,labelTextInfo">
            
            
             <h:outputText value="Principio Activo" styleClass="labelTextOblig" />
            <h:outputText/>
     
            <h:outputText value="Marca" styleClass="labelTextOblig"/>
            <h:outputText/>
            
            <h:outputText value="Concentración" styleClass="labelTextOblig"/>
            <h:outputText/>
            
            
            <h:inputText id="itPrincipioActivo" value="#{registrarVademecumBean.vademecum.hvpcprincactiv}" required="true" maxlength="99"/>
              <a4j:outputPanel ajaxRendered="true">
                      <t:message for="mnuPrincipioActivo" styleClass="errorMessage"/>
                    </a4j:outputPanel>
           
              <h:inputText id="itMarca" value="#{registrarVademecumBean.vademecum.hvpcmarca}" required="true" maxlength="29"/>
              <a4j:outputPanel ajaxRendered="true">
                      <t:message for="itMarca" styleClass="errorMessage"/>
                    </a4j:outputPanel>
           
           
           
            <h:inputText id="itConcentracion" value="#{registrarVademecumBean.vademecum.hvpcconcentrac}" required="true" maxlength="49"/>
             <a4j:outputPanel ajaxRendered="true">
                <t:message for="itConcentracion" styleClass="errorMessage"/>
             </a4j:outputPanel>
           
            
            <h:outputText value="Unidad de Medida" styleClass="labelTextOblig"/>
            <h:outputText/>
     
            <h:outputText value="Forma Farmaceutica" styleClass="labelTextOblig"/>
            <h:outputText/>
            
            <h:outputText value="Presentacion Comercial" styleClass="labelTextOblig"/>
            <h:outputText/>
            
            
             <h:panelGroup>
                <h:selectOneMenu id = "itUnidadMedidaText" 
                value = "#{registrarVademecumBean.vademecum.hvpcunidmedi}">
                <f:selectItems value = "#{registrarVademecumBean.lstUnidadMedida}"/>       
            </h:selectOneMenu>
                
              </h:panelGroup>
              <a4j:outputPanel ajaxRendered="true">
                <t:message for="itUnidadMedidaText" styleClass="errorMessage"/>
              </a4j:outputPanel>
            <h:selectOneMenu id = "itFormaFarmaceuticaText" 
                value = "#{registrarVademecumBean.vademecum.hvpcformafarma}"> 
                <f:selectItems value = "#{registrarVademecumBean.lstFormaFarmaceutica}"/>
                
            </h:selectOneMenu>
                
             <a4j:outputPanel ajaxRendered="true">
                <t:message for="itFormaFarmaceuticaText" styleClass="errorMessage"/>
              </a4j:outputPanel>
             <h:inputText id="itPresentacionComercial" value="#{registrarVademecumBean.vademecum.hvpcprescome}" required="true" maxlength="49"/>
             <a4j:outputPanel ajaxRendered="true">
                <t:message for="itPresentacionComercial" styleClass="errorMessage"/>
             </a4j:outputPanel>
           
            
            
            <h:outputText value="Registro Sanitario" styleClass="labelTextOblig"/>
            <h:outputText/>
     
            <h:outputText value="Fabricante" styleClass="labelTextOblig"/>
            <h:outputText/>
            
            <h:outputText value="Via de Administración" styleClass="labelTextOblig"/>
            <h:outputText/>
            
           
             <h:inputText id="itRegistroSanitario" value="#{registrarVademecumBean.vademecum.hvpcregisani}" required="true" maxlength="49"/>
             <a4j:outputPanel ajaxRendered="true">
                <t:message for="itRegistroSanitario" styleClass="errorMessage"/>
             </a4j:outputPanel>
           
           
                  
             <h:inputText id="itFabricante" value="#{registrarVademecumBean.vademecum.hvpcfabrican}" required="true" maxlength="49"/>
             <a4j:outputPanel ajaxRendered="true">
                <t:message for="itFabricante" styleClass="errorMessage"/>
             </a4j:outputPanel>
           <h:selectOneMenu id = "mnuViaAdministracion" 
                value = "#{registrarVademecumBean.vademecum.hvpcviaadmo"> 
                <f:selectItems value = "#{registrarVademecumBean.lstViaAdministracion}"/>
                
            </h:selectOneMenu>
                
             <a4j:outputPanel ajaxRendered="true">
                <t:message for="mnuViaAdministracion" styleClass="errorMessage"/>
              </a4j:outputPanel>
            
            
            
            
              <h:outputText value="Tipo de Venta" styleClass="labelTextOblig"/>
            <h:outputText/>
     
            <h:outputText value="Nombre Comercial" styleClass="labelTextOblig"/>
            <h:outputText/>
            
            <h:outputText value="Codigo Comercial" styleClass="labelTextOblig"/>
            <h:outputText/>
            
            
              <h:outputText/>
            <h:outputText/>
            <h:outputText/>
            <h:outputText/>
            <h:outputText/>
            <h:outputText/>
            
            
                   <h:outputText value="Anestesia" styleClass="labelTextOblig"/>
            <h:outputText/>
     
            <h:outputText value="Inicia Anestesia" styleClass="labelTextOblig"/>
            <h:outputText/>
            
            <h:outputText value=""/>
            <h:outputText/>
            
            
              <h:outputText/>
            <h:outputText/>
            
            
                <h:panelGrid columns="2" border="0" cellpadding="0" cellspacing="0" width="100%" id="panelDatosMedicamento2"
                       rowClasses="labelText,labelTextInfo">
                       
            <h:outputText value="Indicaciones"/>
            <h:outputText/>
            
            <h:outputText/>
            <h:outputText/>
            
            
            
                <h:outputText value="ContraIndicaciones" />
            <h:outputText/>
            
            <h:outputText/>
            <h:outputText/>
            
            
           <h:outputText value="Observaciones" />
            <h:outputText/>
            
            <h:outputText/>
            <h:outputText/>
            
            
            
            
                       
                       
                       
                       </h:panelGrid>
            
          </h:panelGrid>
          <h:panelGrid>
            <h:panelGroup>
              <a4j:outputPanel id="ajaxRegionMensajesDatosVademecum" ajaxRendered="true">
                <t:htmlTag value="br"/>
                <t:messages id="msgInfRegistrarDatosVademecum" showSummary="true" errorClass="error" globalOnly="true"
                            layout="table" infoClass="registrar"/>
              </a4j:outputPanel>
            </h:panelGroup>
          </h:panelGrid>
        </s:fieldset>
        <h:panelGroup>
          <a4j:outputPanel id="ajaxRegionMessagesatributoVademecum" ajaxRendered="true">
            <t:htmlTag value="br"/>
            <t:messages id="msgInformationAndErrorsVademecum" showSummary="false" errorClass="error" globalOnly="true"
                        layout="table" infoClass="informacion" showDetail="true" tooltip="true"
                        warnClass="advertencia"/>
            <t:htmlTag value="br"/>
          </a4j:outputPanel>
        </h:panelGroup>
        <h:panelGrid columns="1" border="0" cellpadding="0" cellspacing="0" width="100%" id="panelBotonDatosVademecum"
                     columnClasses="panelGridBotones">
          <h:panelGroup>
            <h:commandButton value="Guardar" styleClass="btn btn btn-success" 
                         action="#{registrarVademecumBean.registrarVademecum}">
              <a4j:support event="onclick" status="statusButton"/>
            </h:commandButton>
          </h:panelGroup>
        </h:panelGrid>
      </t:panelTab>
    </t:panelTabbedPane>
  </a4j:region>
</a4j:form>
