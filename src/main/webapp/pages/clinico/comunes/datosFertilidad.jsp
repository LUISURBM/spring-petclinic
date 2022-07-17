<%@ page contentType="text/html;charset=iso-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsf/html" prefix="h"%>
<%@ taglib uri="http://richfaces.org/a4j" prefix="a4j"%>
<%@ taglib uri="http://myfaces.apache.org/tomahawk" prefix="t"%>
<%@ taglib uri="http://myfaces.apache.org/sandbox" prefix="s"%>
<%@ taglib uri="http://java.sun.com/jsf/core" prefix="f"%>
<%@ page import="org.profamilia.hc.view.servlet.PdfServlet"%>

<h:panelGrid columns="1" border="0" cellpadding="0" cellspacing="0" width="100%" id="panelGridDatosParejaTab"
             styleClass="tabContainer">
  <jsp:include page="/pages/clinico/comunes/encabezadoDatosUsuario.jsp" flush="true"/>
  <t:panelTabbedPane border="0" cellpadding="0" cellspacing="0" serverSideTabSwitch="false" activePanelTabVar="true"
                     width="100%" id="panelTabbedPaneDatosPareja" styleClass="tabbedPane"
                     activeTabStyleClass="activeTab" inactiveTabStyleClass="inactiveTab"
                     disabledTabStyleClass="disabledTab" activeSubStyleClass="activeSub"
                     selectedIndex = "#{datosFertilidadBean.selectedIndex}"
                     inactiveSubStyleClass="inactiveSub" tabContentStyleClass="tabContent">
    <t:panelTab id="panelTabDatosPareja" label="Datos Fertilidad ">
    <s:fieldset legend="Fertilidad" id="fieldDatosDonante" styleClass="fieldset_report">
      <h:panelGrid columns="3" border="0" cellpadding="0" cellspacing="0" width="100%" id="panelDonante"
                       rowClasses="labelText,labelTextInfo">
             <h:outputText value="Donante de Gametos" styleClass="labelTextOblig"/>
             <h:selectOneRadio id="mnuDonante" required="true" immediate="true"
                              value="#{datosFertilidadBean.esDonante}"
                              valueChangeListener="#{datosFertilidadBean.setEsDonante}">
                <f:selectItems value="#{datosFertilidadBean.lstOpciones}"/>
                 <a4j:support id="supportmnuDonante" event="onclick" immediate="true"
                          action="#{datosFertilidadBean.changeDonante}"
                         reRender="panelTabDatosPareja,fieldDatosPareja">
                   <a4j:ajaxListener type="org.ajax4jsf.ajax.ForceRender"/>
                 </a4j:support>
             </h:selectOneRadio>
             <a4j:outputPanel ajaxRendered="true">
                 <t:message for="mnuDonante" styleClass="errorMessage"/>
             </a4j:outputPanel>
      <h:panelGroup id="panelNumeroDonante">
             <h:outputText value="C�digo Donante" rendered="#{datosFertilidadBean.mostrarDonante}"
                             styleClass="labelTextOblig"/>
             <h:inputText id="textCodDonante" required="true" rendered="#{datosFertilidadBean.mostrarDonante}"
                                   value="#{datosFertilidadBean.fertdato.hfdncoddon}" style="width:100px"/>
             <a4j:outputPanel ajaxRendered="true">
                 <t:message for="textCodDonante" styleClass="errorMessage"/>
             </a4j:outputPanel>
      </h:panelGroup>
      <h:outputText value=""/>
      <h:outputText value=""/>
      
          <h:outputText value="Tiene Pareja" styleClass="labelTextOblig" rendered="#{!datosFertilidadBean.mostrarDonante}"/>
        
          <h:selectOneRadio id="mnuPareja" required="true" immediate="true" rendered="#{!datosFertilidadBean.mostrarDonante}"
                         value="#{datosFertilidadBean.tienePareja}" 
                         valueChangeListener="#{datosFertilidadBean.setTienePareja}">
              <f:selectItems value="#{datosFertilidadBean.lstOpciones}"/>
               <a4j:support id="supportmnuPareja" event="onclick" immediate="true"
                       action="#{datosFertilidadBean.changePareja}"
                       reRender="fieldDatosPareja,panelDatosPareja">
                <a4j:ajaxListener type="org.ajax4jsf.ajax.ForceRender"/>
               </a4j:support>
           </h:selectOneRadio>
           <a4j:outputPanel ajaxRendered="true">
                <t:message for="mnuPareja" styleClass="errorMessage"/>
           </a4j:outputPanel>
        </h:panelGrid>
        
        <h:panelGrid columns="1" border="0" cellpadding="0" cellspacing="0" width="100%" id="panelDatosPareja"
                       rowClasses="labelText,labelTextInfo">
        <s:fieldset legend="Datos Pareja" id="fieldDatosPareja" styleClass="fieldset_report" rendered="#{datosFertilidadBean.mostrarPareja}">
         <h:outputText value="Conoce el n�mero de documento de identidad de su pareja" styleClass="labelTextOblig" rendered="#{!datosFertilidadBean.mostrarDonante}"/>
             <h:selectOneRadio id="mnuNuPareja" required="true" immediate="true" rendered="#{!datosFertilidadBean.mostrarDonante}"
                         value="#{datosFertilidadBean.tieneNumeroIdPareja}" 
                         valueChangeListener="#{datosFertilidadBean.setTieneNumeroIdPareja}">
              <f:selectItems value="#{datosFertilidadBean.lstOpciones}"/>
               <a4j:support id="supportmnuNuPareja" event="onclick" immediate="true"
                       action="#{datosFertilidadBean.changeNumeroIdPareja}"
                       reRender="fieldDatosPareja,panelDatosPareja">
                <a4j:ajaxListener type="org.ajax4jsf.ajax.ForceRender"/>
               </a4j:support>
           </h:selectOneRadio>
           <a4j:outputPanel ajaxRendered="true">
                <t:message for="mnuNuPareja" styleClass="errorMessage"/>
           </a4j:outputPanel>
         <h:panelGroup id="panelGDatosPareja" rendered="#{datosFertilidadBean.numeroIdPareja}">
        <h:panelGrid columns="4" border="0" cellpadding="0" cellspacing="0" width="100%" id="datosPareja"
                       rowClasses="labelText,labelTextInfo">
          <h:outputText value="Tipo Identificaci�n" styleClass="labelTextOblig" rendered="#{datosFertilidadBean.mostrarPareja}" />
          <h:outputText value="" rendered="#{datosFertilidadBean.mostrarPareja}"/>
          <h:outputText value="N�mero Identificaci�n" styleClass="labelTextOblig" rendered="#{datosFertilidadBean.mostrarPareja}" />
          <h:outputText value="" rendered="#{datosFertilidadBean.mostrarPareja}" />
          <h:selectOneMenu id="tipoIde" rendered="#{datosFertilidadBean.mostrarPareja}"
                           value="#{datosFertilidadBean.fertdato.hfdctipide}"
                           onkeydown="return blockEnter(event);">
            <f:selectItems value="#{datosFertilidadBean.listTipoIdentificacion}"/>
          </h:selectOneMenu>
           <a4j:outputPanel ajaxRendered="true">
                <t:message for="tipoIde" styleClass="errorMessage"/>
           </a4j:outputPanel>
          <h:inputText id="itNumeroIdentificacion" maxlength="15" rendered="#{datosFertilidadBean.mostrarPareja}"
                       value="#{datosFertilidadBean.fertdato.hfdanumide}" 
                       onkeydown="return blockEnter(event);"></h:inputText>
           <a4j:outputPanel ajaxRendered="true">
            <t:message for="itNumeroIdentificacion" styleClass="errorMessage"/>
          </a4j:outputPanel>
          
          <h:outputText value="Primer Nombre" styleClass="labelTextOblig" rendered="#{datosFertilidadBean.mostrarPareja}" />
          <h:outputText value="" rendered="#{datosFertilidadBean.mostrarPareja}" />
         
          <h:outputText value="Segundo Nombre" rendered="#{datosFertilidadBean.mostrarPareja}" />
          <h:outputText value="" rendered="#{datosFertilidadBean.mostrarPareja}" />
        
          <h:inputText id="primerNombre" onkeydown="return blockEnter(event);" maxlength="20" 
                       value="#{datosFertilidadBean.fertdato.hfdcprinom}" rendered="#{datosFertilidadBean.mostrarPareja}" >
          </h:inputText>
          <a4j:outputPanel ajaxRendered="true">
            <t:message for="primerNombre" styleClass="errorMessage"/>
          </a4j:outputPanel>
         
          <h:inputText id="segundoNombre" onkeydown="return blockEnter(event);" maxlength="20" 
                       value="#{datosFertilidadBean.fertdato.hfdcsegnom}" rendered="#{datosFertilidadBean.mostrarPareja}" >
           </h:inputText>
          <a4j:outputPanel ajaxRendered="true">
            <t:message for="segundoNombre" styleClass="errorMessage"/>
          </a4j:outputPanel>

          <h:outputText value="Primer Apellido" styleClass="labelTextOblig" rendered="#{datosFertilidadBean.mostrarPareja}" />
          <h:outputText value="" rendered="#{datosFertilidadBean.mostrarPareja}" />
         
          <h:outputText value="Segundo Apellido" rendered="#{datosFertilidadBean.mostrarPareja}" />
          <h:outputText value="" rendered="#{datosFertilidadBean.mostrarPareja}" />
        
          <h:inputText id="primerApellido" onkeydown="return blockEnter(event);" maxlength="20" 
                       value="#{datosFertilidadBean.fertdato.hfdcpriape}" rendered="#{datosFertilidadBean.mostrarPareja}" >
          </h:inputText>
          <a4j:outputPanel ajaxRendered="true">
            <t:message for="primerApellido" styleClass="errorMessage"/>
          </a4j:outputPanel>
         
          <h:inputText id="segundoApellido" onkeydown="return blockEnter(event);" maxlength="20" 
                       value="#{datosFertilidadBean.fertdato.hfdcsegape}" rendered="#{datosFertilidadBean.mostrarPareja}" >
           </h:inputText>
          <a4j:outputPanel ajaxRendered="true">
            <t:message for="segundoApellido" styleClass="errorMessage"/>
          </a4j:outputPanel>
          
           <h:outputText value="Fecha Nacimiento" styleClass="labelTextOblig" rendered="#{datosFertilidadBean.mostrarPareja}"/>
          <h:outputText value="" rendered="#{datosFertilidadBean.mostrarPareja}"/>
          
           <h:outputText value="Ocupaci�n" styleClass="labelTextOblig" rendered="#{datosFertilidadBean.mostrarPareja}"/>
          <h:outputText value="" rendered="#{datosFertilidadBean.mostrarPareja}"/>
          
          
              <t:inputCalendar id="fechaNacimiento" onkeydown="return blockEnter(event);" rendered="#{datosFertilidadBean.mostrarPareja}"   
                           monthYearRowClass="yearMonthHeader" weekRowClass="weekHeader"
                           title="Formato: dd/mm/yyyy" currentDayCellClass="currentDayCell" popupDateFormat="dd/MM/yyyy"
                           renderAsPopup="true" value="#{datosFertilidadBean.fertdato.hfddfecnac}"
                           popupTodayString="Hoy" popupWeekString="Semana" popupButtonString="Fecha" readonly="false"
                           maxlength="11" size="11" popupButtonImageUrl="/comun/imagenes/ico_calendario2.gif"
                           renderPopupButtonAsImage="true" align="top" >
            <f:validator validatorId="dateMenorActualValidator"/>
          </t:inputCalendar>
          <a4j:outputPanel ajaxRendered="true">
            <t:message for="fechaNacimiento" styleClass="errorMessage"/>
          </a4j:outputPanel>
          
          
             <h:panelGroup>
                    <a4j:region renderRegionOnly="false">
                        <h:inputText id="itOcupacion" value="#{datosFertilidadBean.fertdato.hfdncodocupac}"
                                     valueChangeListener="#{datosFertilidadBean.setOcupacion}"
                                     binding="#{datosFertilidadBean.itOcupacion}" immediate="true"
                                     style="width:50px">
                            <f:validateLength maximum="6"/>
                            <a4j:support id="supportOcupa" event="onchange"
                                         action="#{datosFertilidadBean.changeSeleccionOcupacion}"
                                         reRender="panelOcupacionSeleccion" immediate="true">
                                <a4j:ajaxListener type="org.ajax4jsf.ajax.ForceRender"/>
                            </a4j:support>
                        </h:inputText>
                        <h:commandLink action="#{datosFertilidadBean.renderOcupacion}">
                            <t:graphicImage alt="" border="0" url="/comun/imagenes/lupita.png"/>
                        </h:commandLink>
                        <h:panelGrid columns="1" border="0" cellpadding="0" cellspacing="2"
                                     id="panelOcupacionSeleccion">
                            <h:outputText value=" #{datosFertilidadBean.seleccionOcupacion}" styleClass="buscador"/>
                        </h:panelGrid>
                    </a4j:region>
                    </h:panelGroup>
          <a4j:outputPanel ajaxRendered="true">
            <t:message for="itOcupacion" styleClass="errorMessage"/>
          </a4j:outputPanel>
          </h:panelGrid>
          </h:panelGroup>
          </s:fieldset>
          </h:panelGrid>
     
        </s:fieldset>
        <h:panelGroup>
          <a4j:outputPanel id="ajaxRegionMessagesatributo1" ajaxRendered="true">
            <t:htmlTag value="br"/>
            <t:messages id="msgInformationAndErrors1" showSummary="false" errorClass="error" globalOnly="true"
                        layout="table" infoClass="informacion" showDetail="true" tooltip="true"
                        warnClass="advertencia"/>
            <t:htmlTag value="br"/>
          </a4j:outputPanel>
        </h:panelGroup>
        <h:panelGrid columns="1" border="0" cellpadding="0" cellspacing="0" width="100%" id="panelBotonDatosPareja"
                     columnClasses="panelGridBotones">
          <h:panelGroup>
            <h:commandButton value="Guardar" styleClass="btn btn btn-success" action="#{datosFertilidadBean.guardar}">
              <a4j:support event="onclick" status="statusButton"/>
            </h:commandButton>
          </h:panelGroup>
        </h:panelGrid>
    </t:panelTab>
    
          <t:panelTab id="panelBuscadorOcupacion" label="Buscar Ocupaci�n"
                rendered="#{datosFertilidadBean.renderBuscadorOcupacion}">
      <a4j:region id="regionOcupacion" renderRegionOnly="false">
        <a4j:status id="statusButton" for="regionOcupacion">
          <f:facet name="start">
            <t:div id="chargingOcupacion" styleClass="loading">
              <h:panelGrid columns="1" cellpadding="0" cellspacing="0" border="0">
                <h:outputText value="Procesando..."/>
                <h:outputText value="Por favor espere."/>
              </h:panelGrid>
            </t:div>
          </f:facet>
          <f:facet name="stop"/>
        </a4j:status>
        <a4j:region renderRegionOnly="false">
          <jsp:include page="/pages/clinico/comunes/buscador/buscadorOcupacion.jsp" flush="true"/>
        </a4j:region>
      </a4j:region>
    </t:panelTab>

  </t:panelTabbedPane>
  <script language="javascript" type="text/javascript">
        document.forms[1].elements[6].focus()
</script>
</h:panelGrid>