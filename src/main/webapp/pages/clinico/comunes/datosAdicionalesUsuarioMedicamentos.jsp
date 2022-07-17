<%@ page contentType="text/html;charset=iso-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsf/html" prefix="h"%>
<%@ taglib uri="http://java.sun.com/jsf/core" prefix="f"%>
<%@ taglib uri="http://richfaces.org/a4j" prefix="a4j"%>
<%@ taglib uri="http://myfaces.apache.org/tomahawk" prefix="t"%>
<%@ taglib uri="http://myfaces.apache.org/sandbox" prefix="s"%>
  <link rel="stylesheet" type="text/css" href="<%=request.getContextPath()%>/comun/css/bootstrap.css"/>
    <link rel="stylesheet" type="text/css" href="<%=request.getContextPath()%>/comun/css/bootstrap.min.css"/>
    <link rel="stylesheet" type="text/css" href="<%=request.getContextPath()%>/comun/css/bootstrap-responsive.css"/>
    <link rel="stylesheet" type="text/css" href="<%=request.getContextPath()%>/comun/css/bootstrap-responsive.min.css"/>
<h:panelGrid columns="1" border="0" cellpadding="0" cellspacing="0" width="100%" id="panelGridDatosUsuarioTab"
             styleClass="tabContainer">
  <t:panelTabbedPane border="0" cellpadding="0" cellspacing="0" serverSideTabSwitch="false" activePanelTabVar="true"
                     width="100%" id="panelTabbedPaneDatosUsuario" styleClass="tabbedPane"
                     activeTabStyleClass="activeTab" inactiveTabStyleClass="inactiveTab"
                     disabledTabStyleClass="disabledTab" activeSubStyleClass="activeSub"
                     selectedIndex = "#{datosAdicionalesMedicamentoBean.selectedIndex}"
                     inactiveSubStyleClass="inactiveSub" tabContentStyleClass="tabContent">
    <t:panelTab id="panelTabDatosUsuario" label="Datos Usuario">
      <s:fieldset legend="Datos Basicos Usuario(a)" id="fieldSetInfoBasica" styleClass="fieldset">
                <h:panelGrid columns="6" border="0" cellpadding="0" cellspacing="0" width="100%"
                             id="panelRegionInfoConsulta" rowClasses="labelText,labelTextInfo">
                    <h:outputText value="Departamento nacimiento" styleClass="labelTextOblig"/>
                    <h:outputText value=""/>
                    <h:outputText value=" Municipio nacimiento" styleClass="labelTextOblig"/>
                    <h:outputText value=""/>
                    <h:outputText value="Número Comuna"/>
                    <h:outputText value=""/>
                     <h:selectOneMenu id="menuDepartamentos" immediate="true" required="true" onkeydown="return blockEnter(event);"
                                     value="#{datosAdicionalesMedicamentoBean.chdatosadvacuna.hdavndepart}"
                                     valueChangeListener="#{datosAdicionalesMedicamentoBean.setDepartamentoSelect}">
                        <f:selectItems  value="#{datosAdicionalesMedicamentoBean.listDepartamentos}"/>
                        <a4j:support id="support7" immediate="true" action="#{datosAdicionalesMedicamentoBean.changeCiudad}"
                                     reRender="menuCiudad" event="onchange">
                            <a4j:ajaxListener type="org.ajax4jsf.ajax.ForceRender"/>
                        </a4j:support>
                    </h:selectOneMenu>
                    <a4j:outputPanel ajaxRendered="true">
                        <t:message for="menuDepartamentos" styleClass="errorMessage"/>
                    </a4j:outputPanel>
                    <h:selectOneMenu id="menuCiudad" required="true" onkeydown="return blockEnter(event);"
                                     value="#{datosAdicionalesMedicamentoBean.chdatosadvacuna.hdavnmuni}">
                        <f:selectItems value="#{datosAdicionalesMedicamentoBean.listMunicipios}"/>
                    </h:selectOneMenu>
                    <a4j:outputPanel ajaxRendered="true">
                        <t:message for="menuCiudad" styleClass="errorMessage"/>
                    </a4j:outputPanel>
                    <h:inputText id="itNumeroIdentificacion" maxlength="2"
                                     value="#{datosAdicionalesMedicamentoBean.chdatosadvacuna.hdavnumcom}"
                                     onkeydown="return blockEnter(event);">                   
                    </h:inputText>
                    <a4j:outputPanel ajaxRendered="true">
                        <t:message for="itNumeroIdentificacion" styleClass="errorMessage"/>
                    </a4j:outputPanel>
                     <h:outputText value="Condición de desplazamiento" styleClass="labelTextOblig"/>
                    <h:outputText value=""/>
                     <h:outputText value="Víctima de conflicto" styleClass="labelTextOblig"/>
                    <h:outputText value=""/>
                     <h:outputText value="Estudia actualmente" styleClass="labelTextOblig"/>
                    <h:outputText value=""/>
                     <h:selectOneRadio id="radioDesplazamiento" required="true" onkeydown="return blockEnter(event);"
                                     value="#{datosAdicionalesMedicamentoBean.chdatosadvacuna.hdavccondesplaz}" >
                        <f:selectItems value="#{datosAdicionalesMedicamentoBean.lstSiNo}"/>
                    </h:selectOneRadio>
                    <a4j:outputPanel ajaxRendered="true">
                        <t:message for="radioDesplazamiento" styleClass="errorMessage"/>
                    </a4j:outputPanel>
                     <h:selectOneRadio id="radioVictimDesplaz" required="true" onkeydown="return blockEnter(event);"
                                     value="#{datosAdicionalesMedicamentoBean.chdatosadvacuna.hdavcvicconflic}">
                        <f:selectItems value="#{datosAdicionalesMedicamentoBean.lstSiNo}"/>
                    </h:selectOneRadio>
                    <a4j:outputPanel ajaxRendered="true">
                        <t:message for="radioVictimDesplaz" styleClass="errorMessage"/>
                    </a4j:outputPanel>
                    <a4j:region renderRegionOnly="false">
                     <h:selectOneRadio id="radioEstudiaActualmente" required="true" immediate="true" onkeydown="return blockEnter(event);"
                                     value="#{datosAdicionalesMedicamentoBean.chdatosadvacuna.hdavcestuact}"
                                      valueChangeListener="#{datosAdicionalesMedicamentoBean.setHdavcestuact}">
                        <f:selectItems value="#{datosAdicionalesMedicamentoBean.lstSiNo}"/>
                         <a4j:support id="support8" immediate="true" action="#{datosAdicionalesMedicamentoBean.onChangeInstitucion}"
                                     reRender="lblInstEstudia,pgInstEstudia" event="onchange">
                            <a4j:ajaxListener type="org.ajax4jsf.ajax.ForceRender"/>
                        </a4j:support>
                    </h:selectOneRadio>
                    <a4j:outputPanel ajaxRendered="true">
                        <t:message for="radioEstudiaActualmente" styleClass="errorMessage"/>
                    </a4j:outputPanel>
                    </a4j:region>
                    <h:outputText value=""/>
                    <h:panelGroup id="lblInstEstudia">
                        <h:outputText value="Institución donde estudia" rendered="#{datosAdicionalesMedicamentoBean.renderInstitucion}" styleClass="labelTextOblig"/>
                    </h:panelGroup>
                    <h:outputText value=""/>
                    <h:panelGroup id="lblDatosEmba">
                    <h:outputText value="F.U.R. normal" rendered="#{datosAdicionalesMedicamentoBean.renderDatosEmbarazo}" styleClass="labelTextOblig"/>
                    </h:panelGroup>
                    <h:outputText value=""/>
                    <h:outputText value=""/>
                    <h:outputText value=""/>
                    <h:panelGroup id="pgInstEstudia">
                     <h:inputText id="itInstEstudia" required="true" maxlength="20" rendered="#{datosAdicionalesMedicamentoBean.renderInstitucion}"
                                     value="#{datosAdicionalesMedicamentoBean.chdatosadvacuna.hdavcinstitucion}"
                                     onkeydown="return blockEnter(event);">                   
                    </h:inputText>                  
                    </h:panelGroup>
                    <a4j:outputPanel ajaxRendered="true">
                        <t:message for="itInstEstudia" styleClass="errorMessage"/>
                    </a4j:outputPanel>
                     <t:inputCalendar id="fechaFUR" required="true" onkeydown="return blockEnter(event);"
                                        rendered="#{datosAdicionalesMedicamentoBean.renderDatosEmbarazo}"
                                         monthYearRowClass="yearMonthHeader" weekRowClass="weekHeader"
                                         title="Formato: dd/mm/yyyy" currentDayCellClass="currentDayCell"
                                         popupDateFormat="dd/MM/yyyy" renderAsPopup="true"
                                         value="#{datosAdicionalesMedicamentoBean.chdatosadvacuna.hdavdfur}"
                                         popupTodayString="Hoy" popupWeekString="Semana" popupButtonString="Fecha"
                                         readonly="false" maxlength="11" size="11"
                                         popupButtonImageUrl="/comun/imagenes/ico_calendario2.gif"
                                         renderPopupButtonAsImage="true" align="top">
                            
                        </t:inputCalendar>
                         <a4j:outputPanel ajaxRendered="true">
                        <t:message for="fechaFUR" styleClass="errorMessage"/>
                    </a4j:outputPanel>
                        <h:outputText value=""/>
                        <h:outputText value=""/>
                          <h:panelGroup>
                         <h:outputText value="Condición de usuaria" styleClass="labelTextOblig" rendered="#{datosAdicionalesMedicamentoBean.renderDatosEmbarazo}"/>
                         </h:panelGroup>
                    <h:outputText value=""/>
                    <h:panelGroup id="lblEmbActu">
                      <h:outputText value="Número embarazo actual" styleClass="labelTextOblig" rendered="#{datosAdicionalesMedicamentoBean.renderEmbarazo}"/>
                      </h:panelGroup>
                    <h:outputText value=""/>
                    <h:panelGroup id="lblFacParto">
                        <h:outputText value="Fecha probable de parto" styleClass="labelTextOblig" rendered="#{datosAdicionalesMedicamentoBean.renderEmbarazo}"/>
                    </h:panelGroup>
                    <h:outputText value=""/>
                     <a4j:region renderRegionOnly="false">
                     <h:selectOneRadio id="radioCondicionEmba" required="true" rendered="#{datosAdicionalesMedicamentoBean.renderDatosEmbarazo}" immediate="true" onkeydown="return blockEnter(event);"
                                     value="#{datosAdicionalesMedicamentoBean.chdatosadvacuna.hdavccondusua}"
                                      valueChangeListener="#{datosAdicionalesMedicamentoBean.setHdavccondusua}">
                        <f:selectItems value="#{datosAdicionalesMedicamentoBean.lstCondEmbarazo}"/>
                         <a4j:support id="support10" immediate="true" action="#{datosAdicionalesMedicamentoBean.onChangeCondEmbarazo}"
                                     reRender="lblEmbActu,lblFacParto,pgEmbActu,pgFacParto" event="onchange">
                            <a4j:ajaxListener type="org.ajax4jsf.ajax.ForceRender"/>
                        </a4j:support>
                    </h:selectOneRadio>                 
                    </a4j:region>
                     <a4j:outputPanel ajaxRendered="true">
                        <t:message for="radioCondicionEmba" styleClass="errorMessage"/>
                    </a4j:outputPanel>
                    <h:panelGroup id="pgEmbActu">
                        <h:inputText id="itNumEmba" required="true" maxlength="2" rendered="#{datosAdicionalesMedicamentoBean.renderEmbarazo}"
                                     value="#{datosAdicionalesMedicamentoBean.chdatosadvacuna.hdavcembact}"
                                     onkeydown="return blockEnter(event);">                   
                        </h:inputText>
                    </h:panelGroup>
                     <a4j:outputPanel ajaxRendered="true">
                        <t:message for="itInstEstudia" styleClass="errorMessage"/>
                    </a4j:outputPanel>
                    <h:panelGroup id="pgFacParto">
                     <t:inputCalendar id="fechaPart" required="true" rendered="#{datosAdicionalesMedicamentoBean.renderEmbarazo}" onkeydown="return blockEnter(event);"
                                         monthYearRowClass="yearMonthHeader" weekRowClass="weekHeader"
                                         title="Formato: dd/mm/yyyy" currentDayCellClass="currentDayCell"
                                         popupDateFormat="dd/MM/yyyy" renderAsPopup="true"
                                         value="#{datosAdicionalesMedicamentoBean.chdatosadvacuna.hdavdfecpart}"
                                         popupTodayString="Hoy" popupWeekString="Semana" popupButtonString="Fecha"
                                         readonly="false" maxlength="11" size="11"
                                         popupButtonImageUrl="/comun/imagenes/ico_calendario2.gif"
                                         renderPopupButtonAsImage="true" align="top">                           
                        </t:inputCalendar>
                        </h:panelGroup>
                         <a4j:outputPanel ajaxRendered="true">
                        <t:message for="fechaPart" styleClass="errorMessage"/>
                    </a4j:outputPanel>
                </h:panelGrid>
                
                 <h:panelGrid columns="4" border="0" width="100%" id="panelDatosdeDiscapacidad">
              <h:outputText value="Discapacidad" 
                            styleClass="labelTextOblig"/>
              <h:outputText value=""/>
              <h:panelGroup id="panelTipoDiscapacidad1">
                <h:outputText value="Tipos de Discapacidad" rendered="#{datosAdicionalesMedicamentoBean.renderDiscapacidad}"
                              styleClass="labelTextOblig"/>
              </h:panelGroup>
              <h:outputText value=""/>
              <a4j:region renderRegionOnly="false">
              <h:selectOneRadio id="radioDiscapacidad" value="#{datosAdicionalesMedicamentoBean.chdatosadvacuna.hdacdiscapadid}"
                                 required="true" >
                <f:selectItem itemValue="S" itemLabel="SI"/>
                <f:selectItem itemValue="N" itemLabel="NO"/>
                <a4j:support id="supportmnumnuDiscapacidad" action="#{datosAdicionalesMedicamentoBean.changeDiscapacidad}"
                             reRender="panelTipoDiscapacidad1,panelDiscapaci" event="onclick">
                  <a4j:ajaxListener type="org.ajax4jsf.ajax.ForceRender"/>
                </a4j:support>
              </h:selectOneRadio>
              </a4j:region>
              <a4j:outputPanel ajaxRendered="true">
                <t:message for="radioDiscapacidad" styleClass="errorMessage"/>
              </a4j:outputPanel>
              <h:panelGroup id="panelDiscapaci">
                <h:selectOneMenu id="panelDiscapacidad" rendered="#{datosAdicionalesMedicamentoBean.renderDiscapacidad}"
                                 immediate="true" value="#{datosAdicionalesMedicamentoBean.chdatosadvacuna.hdacdiscaselec}" required="true">
                  <f:selectItems value="#{datosAdicionalesMedicamentoBean.lstDiscapacidad}"/>
                </h:selectOneMenu>
                <a4j:outputPanel ajaxRendered="true">
                  <t:message for="panelDiscapacidad" styleClass="errorMessage"/>
                </a4j:outputPanel>
              </h:panelGroup>
              <h:outputText value=""/>
            </h:panelGrid>
            </s:fieldset>
    
  
 
      
      <h:panelGroup>
        <a4j:outputPanel id="ajaxRegionMessagesatributo1" ajaxRendered="true">
          <t:htmlTag value="br"/>
          <t:messages id="msgInformationAndErrors" showSummary="false" errorClass="error" globalOnly="true"
                      layout="table" infoClass="informacion" showDetail="true" tooltip="true" warnClass="advertencia"/>
          <t:htmlTag value="br"/>
        </a4j:outputPanel>
      </h:panelGroup>
      <h:panelGrid columns="1" border="0" cellpadding="0" cellspacing="0" width="100%" id="panelBotonModificar"
                   columnClasses="panelGridBotones">
        <h:panelGroup>
          <h:commandButton value="Guardar" styleClass="btn btn btn-success"
                           action="#{datosAdicionalesMedicamentoBean.guardarUsuario}">
            <a4j:support event="onclick" status="statusButton"/>
          </h:commandButton>
        </h:panelGroup>
      </h:panelGrid>
    </t:panelTab>   
  </t:panelTabbedPane>
  <f:verbatim>
    <script language="javascript" type="text/javascript">
        document.forms[1].elements[6].focus()
</script>
  </f:verbatim>
</h:panelGrid>