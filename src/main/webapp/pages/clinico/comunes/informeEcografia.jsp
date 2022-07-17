<%@ page contentType="text/html;charset=iso-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsf/html" prefix="h"%>
<%@ taglib uri="http://java.sun.com/jsf/core" prefix="f"%>
<%@ taglib uri="http://richfaces.org/a4j" prefix="a4j"%>
<%@ taglib uri="http://myfaces.apache.org/tomahawk" prefix="t"%>
<%@ taglib uri="http://myfaces.apache.org/sandbox" prefix="s"%>
<h:panelGrid columns="1" border="0" cellpadding="0" cellspacing="0" width="100%" id="panelGridInformeEcografiaTab"
             styleClass="tabContainer">
  <jsp:include page="/pages/clinico/comunes/encabezadoDatosUsuario.jsp" flush="true"/>
  <t:panelTabbedPane border="0" cellpadding="0" cellspacing="0" serverSideTabSwitch="false" activePanelTabVar="true"
                     selectedIndex="#{informeEcografiaBean.selectIndex}" width="100%"
                     id="panelTabbedPaneInformeEcografia" styleClass="tabbedPane" activeTabStyleClass="activeTab"
                     inactiveTabStyleClass="inactiveTab" disabledTabStyleClass="disabledTab"
                     activeSubStyleClass="activeSub" inactiveSubStyleClass="inactiveSub"
                     tabContentStyleClass="tabContent">
    <t:panelTab id="panelTabInformeEcografia" label="Informe Ecografico">
      <h:panelGrid columns="1" border="0" cellpadding="0" cellspacing="0" width="100%"
                   id="panelGridInformeEcografiaContainer" styleClass="tabContainer">
          <s:fieldset legend="Nombre Informe" id="fieldNombreInforme" styleClass="fieldset">
          <h:panelGrid columns="2" border="0" cellpadding="0" cellspacing="0" width="100%" id="panelDatosNombreInforme"
                       rowClasses="labelText,labelTextInfo">
            <h:outputText value="Nombre Informe"/>           
            <h:outputText value = ""/>
            
            <h:inputText id = "itNombreInforme" required="true" 
                    maxlength="80" style="width:300px"
                    value="#{informeEcografiaBean.informe.himcdescrinfor}"/>
                    
                       <a4j:outputPanel ajaxRendered="true">
                  <t:message for="itNombreInforme" styleClass="errorMessage"/>
                </a4j:outputPanel>
                       
                    </h:panelGrid>
            </s:fieldset> 
                   
        <s:fieldset legend="Informe Ecografico" id="fieldInformeEcografia" styleClass="fieldset">
          <h:panelGrid columns="4" border="0" cellpadding="0" cellspacing="0" width="100%" id="panelDatosAntecedentes"
                       rowClasses="labelText,labelTextInfo">
            <h:outputText value="Gestaciones"/>
            <h:outputText value="Partos"/>
            <h:outputText value="Abortos"/>
            <h:outputText value="Cesareas"/>
             <a4j:region renderRegionOnly="false">
              <h:panelGroup>
                <h:inputText id="mnuNumGesta" immediate="true" binding="#{informeEcografiaBean.itNumGesta}"
                             onkeydown="return blockEnter(event);" title="Numero de Gestaciones" maxlength="2"
                             style="width:30px" value="#{informeEcografiaBean.informe.himnnumgesta}"
                             valueChangeListener="#{informeEcografiaBean.setHimnnumgesta}">
                  <a4j:support id="supportNumGesta" event="onchange" oncomplete="jsFunction()"
                               action="#{informeEcografiaBean.changeNumeroGestaciones}"
                               reRender="panelInputPartos,panelInputAbortos,panelInputCesareas,panelInputVivos,panelInputEctopicos,panelInputMuertos,panelInputMortinatos,panelCursor,panelInputParto">
                    <a4j:ajaxListener type="org.ajax4jsf.ajax.ForceRender"/>
                  </a4j:support>
                </h:inputText>
                <a4j:outputPanel ajaxRendered="true">
                  <t:message for="mnuNumGesta" styleClass="errorMessage"/>
                </a4j:outputPanel>
              </h:panelGroup>
            </a4j:region>
            <h:panelGroup id="panelInputPartos">
              <h:panelGroup>
                <h:inputText id="itNumPartos" immediate="true" onkeydown="return blockEnter(event);"
                             binding="#{informeEcografiaBean.itNumPartos}" title="Numero de Partos"
                             disabled="#{informeEcografiaBean.esCeroGestaciones}"
                             value="#{informeEcografiaBean.informe.himnnumparto}" maxlength="2" style="width:30px"></h:inputText>
                <a4j:outputPanel ajaxRendered="true">
                  <t:message for="itNumPartos" styleClass="errorMessage"/>
                </a4j:outputPanel>
              </h:panelGroup>
            </h:panelGroup>
            <h:panelGroup id="panelInputAbortos">
              <h:panelGroup>
                <h:inputText id="itNumAbortos" immediate="true" onkeydown="return blockEnter(event);"
                             binding="#{informeEcografiaBean.itNumAbortos}" title="Numero de Abortos" maxlength="2"
                             style="width:30px" disabled="#{informeEcografiaBean.esCeroGestaciones}"
                             value="#{informeEcografiaBean.informe.himnnumaborto}"></h:inputText>
                <a4j:outputPanel ajaxRendered="true">
                  <t:message for="itNumAbortos" styleClass="errorMessage"/>
                </a4j:outputPanel>
              </h:panelGroup>
            </h:panelGroup>
            <h:panelGroup id="panelInputCesareas">
              <h:panelGroup>
                <h:inputText id="itNumcesareas" immediate="true" onkeydown="return blockEnter(event);"
                             binding="#{informeEcografiaBean.itNumcesareas}" title="Numero de Cesareas" maxlength="2"
                             style="width:30px" disabled="#{informeEcografiaBean.esCeroGestaciones}"
                             value="#{informeEcografiaBean.informe.himnnumcesare}"></h:inputText>
                <a4j:outputPanel ajaxRendered="true">
                  <t:message for="itNumcesareas" styleClass="errorMessage"/>
                </a4j:outputPanel>
              </h:panelGroup>
            </h:panelGroup>
       
            <h:outputText value="Ectopicos   "/>
            <h:outputText value="EGM"/>
            <h:outputText value="FUR"/>
            <h:outputText value = ""/>
            <h:panelGroup id="panelInputEctopicos">
              <h:panelGroup>
                <h:inputText id="itNumEctopicos" immediate="true" onkeydown="return blockEnter(event);"
                             binding="#{informeEcografiaBean.itNumEctopicos}" title="Numero de Ectopicos" maxlength="2"
                             style="width:30px" disabled="#{informeEcografiaBean.esCeroGestaciones}"
                             value="#{informeEcografiaBean.informe.himnectopico}"></h:inputText>
                <a4j:outputPanel ajaxRendered="true">
                  <t:message for="itNumEctopicos" styleClass="errorMessage"/>
                </a4j:outputPanel>
              </h:panelGroup>
            </h:panelGroup>
       
      
            <h:panelGroup id="panelSemanasEdadGestacional">
              <h:inputText id="itEdadGestacional" style="width:20px" title="Semanas Embarazo" 
                           maxlength="2"
                           value="#{informeEcografiaBean.informe.himnedadgesmes}">
                <f:validator validatorId="validateSemanaEmbarazo"/>
              </h:inputText>
              <a4j:outputPanel ajaxRendered="true">
                <t:message for="itEdadGestacional" styleClass="errorMessage"/>
              </a4j:outputPanel>
              
                 <h:inputText id="itDiasGestacional" style="width:20px" title="Dias Embarazo" 
                           maxlength="1"
                           value="#{informeEcografiaBean.informe.himndiasgestac}">
                <f:validator validatorId="validateDiaEmbarazo"/>
              </h:inputText>
                 <a4j:outputPanel ajaxRendered="true">
                <t:message for="itDiasGestacional" styleClass="errorMessage"/>
              </a4j:outputPanel>
            </h:panelGroup>
            <h:panelGroup>
              <t:inputCalendar id="calendarUltimaRegla" title="Formato: dd/mm/yyyy"
                               onkeydown="return blockEnter(event);"
                               binding="#{informeEcografiaBean.calendarUltimaRegla}" monthYearRowClass="yearMonthHeader"
                               weekRowClass="weekHeader" currentDayCellClass="currentDayCell"
                               popupDateFormat="dd/MM/yyyy" renderAsPopup="true"
                               value="#{informeEcografiaBean.informe.himdfur}" popupTodayString="Hoy"
                               popupWeekString="Semana" popupButtonString="Fecha" readonly="false" maxlength="11"
                               size="11" popupButtonImageUrl="/comun/imagenes/ico_calendario2.gif"
                               renderPopupButtonAsImage="true" align="top">
                <f:validator validatorId="dateMenorIgualValidator"/>
              </t:inputCalendar>
              <a4j:outputPanel ajaxRendered="true">
                <t:message for="calendarUltimaRegla" styleClass="errorMessage"/>
              </a4j:outputPanel>
            </h:panelGroup>
             <h:outputText value = ""/>
          </h:panelGrid>
          <h:panelGrid columns="1" border="0" cellpadding="0" cellspacing="0" width="100%"
                       id="panelGridInformeEcografia2" rowClasses="labelText,labelTextInfo">
            <h:outputText value="Informe" styleClass="labelTextOblig"/>
            <h:panelGrid columns="3" border="0" cellpadding="0" cellspacing="0">
              <a4j:commandLink action="#{informeEcografiaBean.mostrarBuscadorPlantilla}" immediate="true"
                               reRender="panelGridInformeEcografiaTab">
                <a4j:ajaxListener type="org.ajax4jsf.ajax.ForceRender"/>
                <t:graphicImage alt="" border="0" url="/comun/imagenes/lupa.gif"/>
              </a4j:commandLink>
              <h:inputTextarea id="itInformeEcografia" style="width:600px;height:160px" immediate="true"
                               binding="#{informeEcografiaBean.itInforme}"
                               value="#{informeEcografiaBean.informe.himcinformamog}"></h:inputTextarea>
              <a4j:outputPanel ajaxRendered="true">
                <t:message for="itInformeEcografia" styleClass="errorMessage"/>
              </a4j:outputPanel>
            </h:panelGrid>
            <h:outputText value="Conclusión" styleClass="labelTextOblig"/>
            <h:panelGroup>
              <h:inputTextarea id="itOpinionEcografia" required="true" style="width:600px"
                               value="#{informeEcografiaBean.informe.himcopinion}"/>
              <a4j:outputPanel ajaxRendered="true">
                <t:message for="itOpinionEcografia" styleClass="errorMessage"/>
              </a4j:outputPanel>
            </h:panelGroup>
          </h:panelGrid>
          <h:panelGrid columns="1" border="0" cellpadding="0" cellspacing="0" width="100%"
                       id="panelBotonesInformeEcografia" dir="RTL" columnClasses="panelGridBotones">
            <h:panelGroup>
              <h:commandButton value="Aceptar" styleClass="boton_fieldset"
                               action="#{informeEcografiaBean.generarEcografia}"/>
              <a4j:support event="onclick" status="statusButton"/>
            </h:panelGroup>
          </h:panelGrid>
        </s:fieldset>
      </h:panelGrid>
      <h:panelGrid>
        <h:panelGroup>
          <a4j:outputPanel id="ajaxRegionInformeEcografiaMsg" ajaxRendered="true">
            <t:messages id="msgInformationInformeEcografiaMsg" showSummary="true" errorClass="error" globalOnly="true"
                        layout="table" infoClass="informacion"/>
          </a4j:outputPanel>
        </h:panelGroup>
      </h:panelGrid>
    </t:panelTab>
    <t:panelTab id="panelBuscadorEcografia" label="Buscar Plantillas" rendered="#{informeEcografiaBean.renderBuscador}">
      <a4j:region id="regionBuscadorEcografia" renderRegionOnly="false">
        <a4j:status id="statusButton" for="regionBuscadorEcografia">
          <f:facet name="start">
            <t:div id="chargingBuscadorEcografia" styleClass="loading">
              <h:panelGrid columns="1" cellpadding="0" cellspacing="0" border="0">
                <h:outputText value="Procesando..."/>
                <h:outputText value="Por favor espere."/>
              </h:panelGrid>
            </t:div>
          </f:facet>
          <f:facet name="stop"/>
        </a4j:status>
        <jsp:include page="/pages/clinico/comunes/buscador/buscadorPlantillas.jsp" flush="true"/>
        <h:panelGrid id="panelGridBuscadorBotonesEcografia" width="100%" columnClasses="columnaBotonesCentrados"
                     dir="RTL">
          <t:htmlTag value="br"/>
          <h:panelGroup id="panelGroupBuscadorBotones1Ecografia">
            <a4j:commandButton value="Aceptar" styleClass="boton_fieldset"
                               action="#{informeEcografiaBean.aceptarPlantilla}"
                               reRender="panelGridInformeEcografiaTab">
              <a4j:ajaxListener type="org.ajax4jsf.ajax.ForceRender"/>
            </a4j:commandButton>
          </h:panelGroup>
        </h:panelGrid>
      </a4j:region>
    </t:panelTab>
  </t:panelTabbedPane>
  <script language="javascript" type="text/javascript">
        document.forms[1].elements[6].focus()
</script>
</h:panelGrid>