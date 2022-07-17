<%@ page contentType="text/html;charset=iso-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsf/html" prefix="h"%>
<%@ taglib uri="http://java.sun.com/jsf/core" prefix="f"%>
<%@ taglib uri="http://richfaces.org/a4j" prefix="a4j"%>
<%@ taglib uri="http://myfaces.apache.org/tomahawk" prefix="t"%>
<%@ taglib uri="http://myfaces.apache.org/sandbox" prefix="s"%>
<h:panelGrid columns="1" border="0" cellpadding="0" cellspacing="0" width="100%" id="panelGridAplicacionVacunaTab"
             styleClass="tabContainer">
  <jsp:include page="/pages/clinico/comunes/encabezadoDatosUsuario.jsp" flush="true"/>
  <t:panelTabbedPane border="0" cellpadding="0" cellspacing="0" serverSideTabSwitch="false" activePanelTabVar="true"
                     width="100%" id="panelTabbedPaneAplicacionVacuna" styleClass="tabbedPane"
                     activeTabStyleClass="activeTab" inactiveTabStyleClass="inactiveTab"
                     disabledTabStyleClass="disabledTab" activeSubStyleClass="activeSub"
                     inactiveSubStyleClass="inactiveSub" tabContentStyleClass="tabContent">
    <t:panelTab id="panelTabAplicacionVacuna" label="Aplicación Vacuna">
      <s:fieldset legend="Aplicacion Vacuna" id="fieldSetAplicacionVacuna" styleClass="fieldset">
        <h:panelGrid columns="6" border="0" cellpadding="0" cellspacing="0" width="100%"
                     id="panelDatosAplicacionVacuna" rowClasses="labelText,labelTextInfo">
          <h:outputText value="Vacuna"   styleClass="labelTextOblig"/>
          <h:outputText value=""/>
          
          <h:outputText value="Dosis"   styleClass="labelTextOblig"/>
          <h:outputText value=""/>
          
          <h:outputText value=""   />
          <h:outputText value=""/>
          
          <h:outputText value="#{aplicacionVacunaBean.vacuna.hvaccodigservi} #{aplicacionVacunaBean.vacuna.hvacnombrservi}"/>
             <h:outputText value=""   />
           <h:selectOneMenu id="mnuDosis" onkeydown="return blockEnter(event);" required="true"
                           value="#{aplicacionVacunaBean.vacuna.hvacnumervacun}">
            <f:selectItems value="#{aplicacionVacunaBean.lstNumeroDosis}"/>
          </h:selectOneMenu>
          <a4j:outputPanel ajaxRendered="true">
            <t:message for="mnuDosis" styleClass="errorMessage"/>
          </a4j:outputPanel>
   
          
          <h:outputText value=""/>
          <h:outputText value=""/>
          
          <h:outputText value="Lote"   styleClass="labelTextOblig"/>
          <h:outputText value=""/>
          <h:outputText value="Fecha de Vencimiento"   styleClass="labelTextOblig"/>
          <h:outputText value=""/>
          <h:outputText value="Via Administración"   styleClass="labelTextOblig" />
          <h:outputText value=""/>
          <h:inputText id="textLote" value="#{aplicacionVacunaBean.vacuna.hvacnumerlote}" required="true"
                       style="width:200px" maxlength="50"/>
          <a4j:outputPanel ajaxRendered="true">
            <t:message for="textLote" styleClass="errorMessage"/>
          </a4j:outputPanel>
          <t:inputCalendar id="fechaVencimiento" title="Formato: dd/mm/yyyy" monthYearRowClass="yearMonthHeader"
                           weekRowClass="weekHeader" onkeydown="return blockEnter(event);"
                           currentDayCellClass="currentDayCell" popupDateFormat="dd/MM/yyyy" renderAsPopup="true"
                           value="#{aplicacionVacunaBean.vacuna.hvadfechavenci}" popupTodayString="Hoy"
                           popupWeekString="Semana" popupButtonString="Fecha" readonly="false" maxlength="11" size="11"
                           popupButtonImageUrl="/comun/imagenes/ico_calendario2.gif" renderPopupButtonAsImage="true"
                           align="top" required="true"/>
          <a4j:outputPanel ajaxRendered="true">
            <t:message for="fechaVencimiento" styleClass="errorMessage"/>
          </a4j:outputPanel>
          <h:selectOneMenu id="mnuViaAdministracion" onkeydown="return blockEnter(event);" required="true"
                           value="#{aplicacionVacunaBean.vacuna.hvacviaadmin}">
            <f:selectItems value="#{aplicacionVacunaBean.lstVia}"/>
          </h:selectOneMenu>
          <a4j:outputPanel ajaxRendered="true">
            <t:message for="mnuViaAdministracion" styleClass="errorMessage"/>
          </a4j:outputPanel>
          
          <h:outputText value="Ha presentado reacciones con anteriores vacunas ?"   styleClass="labelTextOblig"/>
          <h:outputText value=""/>
          <h:panelGroup id = "panelTextCualesReacciones">
          <h:outputText value="Cuales? "  rendered="#{aplicacionVacunaBean.renderReacciones}"/>
          </h:panelGroup>
          <h:outputText value=""/>
          <h:outputText value=""/>
          <h:outputText value=""/>
          <a4j:region renderRegionOnly="false">
          <h:selectOneRadio id="mnuReaccionesAnteriores" onkeydown="return blockEnter(event);"
                        required="true" immediate="true" 
                           value="#{aplicacionVacunaBean.vacuna.hvacpresereacc}"
                           valueChangeListener="#{aplicacionVacunaBean.setHvacpresereacc}">
            <f:selectItems value="#{aplicacionVacunaBean.lstOpciones}"/>
               <a4j:support id="supportmnuReaccionesAnteriores"  immediate="true"
                action="#{aplicacionVacunaBean.changeReacciones}"
                           reRender="panelTextCualesReacciones,mnuReaccionesAnteriores" event="onclick">
                <a4j:ajaxListener type="org.ajax4jsf.ajax.ForceRender"/>
              </a4j:support>
            
          </h:selectOneRadio>
          </a4j:region>
          <a4j:outputPanel ajaxRendered="true">
            <t:message for="mnuReaccionesAnteriores" styleClass="errorMessage"/>
          </a4j:outputPanel>
          <h:panelGroup id = "panelInputCualesReacciones">
           <h:inputText id="textReacciones" value="#{aplicacionVacunaBean.vacuna.hvaccualreacc}" required="true"
            rendered="#{aplicacionVacunaBean.renderReacciones}"
                       style="width:400px" maxlength="200"/>
                       
         </h:panelGroup>    
          <a4j:outputPanel ajaxRendered="true">
            <t:message for="textReacciones" styleClass="errorMessage"/>
          </a4j:outputPanel>
          <h:outputText value=""/>
          <h:outputText value=""/>
          
          
          <h:outputText value="Sitio Aplicación"   styleClass="labelTextOblig"/>
          <h:outputText value=""/>
          <h:outputText value=""/>
          <h:outputText value=""/>
          <h:outputText value=""/>
          <h:outputText value=""/>
          
          <h:selectOneMenu id="mnuSitioAdministracion" onkeydown="return blockEnter(event);" required="true"
                           value="#{aplicacionVacunaBean.vacuna.hvacsitioaplic}">
            <f:selectItems value="#{aplicacionVacunaBean.lstSitioAplicacion}"/>
          </h:selectOneMenu>
          <a4j:outputPanel ajaxRendered="true">
            <t:message for="mnuSitioAdministracion" styleClass="errorMessage"/>
          </a4j:outputPanel>
          <h:outputText value=""/>
          <h:outputText value=""/>
          <h:outputText value=""/>
          <h:outputText value=""/>
          
          
          <h:outputText value="Presento complicacion en la actual aplicación?"   styleClass="labelTextOblig"/>
          <h:outputText value=""/>
          <h:panelGroup id = "panelTextCualesComplicaciones">
          <h:outputText value="Cuales? " rendered="#{aplicacionVacunaBean.renderComplicaciones}"/>
          </h:panelGroup>
          <h:outputText value=""/>
          <h:outputText value=""/>
          <h:outputText value=""/>
             <a4j:region renderRegionOnly="false">
          <h:selectOneRadio id="mnuReaccioneActuales" onkeydown="return blockEnter(event);"
                            required="true" immediate="true"
                           value="#{aplicacionVacunaBean.vacuna.hvacpresecompl}"
                             valueChangeListener="#{aplicacionVacunaBean.setHvacpresecompl}">
            <f:selectItems value="#{aplicacionVacunaBean.lstOpciones}"/>
               <a4j:support id="supportmnuReaccioneActuales" immediate="true"
                action="#{aplicacionVacunaBean.changeComplicaciones}"
                           reRender="panelTextCualesComplicaciones,panelInputCualesComplicaciones" event="onclick">
                <a4j:ajaxListener type="org.ajax4jsf.ajax.ForceRender"/>
              </a4j:support>
          </h:selectOneRadio>
          </a4j:region>
          <a4j:outputPanel ajaxRendered="true">
            <t:message for="mnuReaccioneActuales" styleClass="errorMessage"/>
          </a4j:outputPanel>
          <h:panelGroup id = "panelInputCualesComplicaciones">
              <h:inputText id="textReaccionesActuales" value="#{aplicacionVacunaBean.vacuna.hvaccualcompl}" required="true"
                rendered="#{aplicacionVacunaBean.renderComplicaciones}"
                       style="width:400px" maxlength="200"/>
          </h:panelGroup>
          <a4j:outputPanel ajaxRendered="true">
            <t:message for="textReaccionesActuales" styleClass="errorMessage"/>
          </a4j:outputPanel>
          <h:outputText value=""/>
          <h:outputText value=""/>
          
          
        </h:panelGrid>
        
             <h:panelGrid columns="1" border="0" cellpadding="0" cellspacing="0" width="100%"
                     id="panelBotonesAdministrarMedicamento" columnClasses="panelGridBotones">
          <h:panelGroup>
            <h:commandButton value="Aceptar" styleClass="boton_fieldset" 
                               action="#{aplicacionVacunaBean.guardar}">
                <a4j:support event="onclick" status="statusButton"/> 
            </h:commandButton>
          </h:panelGroup>
        </h:panelGrid>
      </s:fieldset>
    </t:panelTab>
  </t:panelTabbedPane>
  <script language="javascript" type="text/javascript">
        document.forms[1].elements[6].focus()
</script>
</h:panelGrid>