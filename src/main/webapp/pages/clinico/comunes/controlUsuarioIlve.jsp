<%@ page contentType="text/html;charset=iso-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsf/html" prefix="h"%>
<%@ taglib uri="http://java.sun.com/jsf/core" prefix="f"%>
<%@ taglib uri="http://richfaces.org/a4j" prefix="a4j"%>
<%@ taglib uri="http://myfaces.apache.org/tomahawk" prefix="t"%>
<%@ taglib uri="http://myfaces.apache.org/sandbox" prefix="s"%>
<h:panelGrid columns="1" border="0" cellpadding="0" cellspacing="0" width="100%"
             id="panelGridConsultaControlSinCostoTab" styleClass="tabContainer">
  <jsp:include page="/pages/clinico/comunes/encabezadoDatosUsuario.jsp" flush="true"/>
  <t:panelTabbedPane border="0" cellpadding="0" cellspacing="0" serverSideTabSwitch="false" activePanelTabVar="true"
                     selectedIndex="#{controlUsuarioIlveBean.selectedIndex}" width="100%"
                     id="panelTabbedPaneControlConsultaControl" styleClass="tabbedPane" activeTabStyleClass="activeTab"
                     inactiveTabStyleClass="inactiveTab" disabledTabStyleClass="disabledTab"
                     activeSubStyleClass="activeSub" inactiveSubStyleClass="inactiveSub"
                     tabContentStyleClass="tabContent">
    <t:panelTab id="panelTabConsultaControl" label=" Control Ive" disabled="#{controlUsuarioIlveBean.mostrarCie10}">
      <a4j:region id="bodyRegionConsultaControl">
        <a4j:status id="statusButton" for="bodyRegionConsultaControl">
          <f:facet name="start">
            <t:div id="chargindConsultaControl" styleClass="loading">
              <h:panelGrid columns="1" cellpadding="0" cellspacing="0" border="0">
                <h:outputText value="Procesando..."/>
                <h:outputText value="Por favor espere."/>
              </h:panelGrid>
            </t:div>
          </f:facet>
          <f:facet name="stop"/>
        </a4j:status>
        <h:panelGrid columns="1" border="0" cellpadding="0" cellspacing="0" width="100%"
                     id="tableContentTabsConsultaControl" styleClass="tabContainerControl" >
           <h:outputText value="Tipo de Control" styleClass="labelTextOblig"/>
                         <a4j:region renderRegionOnly="false">
                <h:selectOneMenu id="menuTipoControl" onkeydown="return blockEnter(event);" immediate="true"
                                 value="#{controlUsuarioIlveBean.motivo.hmcctipocontr}"
                                 valueChangeListener="#{controlUsuarioIlveBean.setHmcctipocontr}">
                  <f:selectItems value="#{controlUsuarioIlveBean.lstTipoControl}"/>
                  <a4j:support id="supportTipoControl" event="onchange" immediate="true"
                               action="#{controlUsuarioIlveBean.changeFarmacologico}"
                               reRender="panelTextCantidad,panelTextDuracion,panelOneMenuCantidad,panelOneMenuDuracion,panelSangro,selectOneSangro,panelInicioSangrado,
                               panelSelectIniSangrado,panelMotivoConsultaControl,panelInicioSangrado,panelmenuMayorSangrado,
                               panelTiempoDuracion,panelHoraExpulsion,textExpulsionPoste,textExpulhoras,tableContentTabsConsultaControlConfEmb,
                               tableContentTabsConsultaControl,menuTipoControlConfEmb,fieldEcografiaConsultaControl,fieldAnticoncepcionConsultaControl,fieldDatosConsultaPrevia">
                    <a4j:ajaxListener type="org.ajax4jsf.ajax.ForceRender"/>
                  </a4j:support>
                </h:selectOneMenu>
              </a4j:region>
              <a4j:outputPanel ajaxRendered="true">
                <t:message for="menuTipoControl" styleClass="errorMessage"/>
              </a4j:outputPanel>
          <s:fieldset legend="Motivo de la Consulta " id="fieldMotivoConsultaControl" styleClass="fieldset" rendered="#{!controlUsuarioIlveBean.renderConfirmaEnbarazo}">
            <h:panelGrid columns="8" border="0" cellpadding="1" cellspacing="0" width="100%"
                         id="panelMotivoConsultaControl" rowClasses="labelText,labelTextInfo">
              <h:outputText value="Causa Externa" styleClass="labelTextOblig"/>
              <h:outputText value=" "/>
              <h:panelGroup>
                <h:outputText value="Finalidad" styleClass="labelTextOblig"/>
              </h:panelGroup>
              <h:outputText value=" "/>
              <h:outputText value="Enfermedad Actual" styleClass="labelTextOblig"/>
              <h:outputText value=" "/>
              <h:panelGroup>
                <h:outputText value=""/>
              </h:panelGroup>
              <h:outputText value=" "/>
              <h:selectOneMenu id="menuMotivoConsultaControl" onkeydown="return blockEnter(event);"
                               value="#{controlUsuarioIlveBean.motivo.hmcncausaexte}">
                <f:selectItems value="#{controlUsuarioIlveBean.lstCausa}"/>
              </h:selectOneMenu>
              <a4j:outputPanel ajaxRendered="true">
                <t:message for="menuMotivoConsultaControl" styleClass="errorMessage"/>
              </a4j:outputPanel>
              <h:selectOneMenu id="menuFinalidadControl" onkeydown="return blockEnter(event);"
                               value="#{controlUsuarioIlveBean.motivo.hmcnfinalidad}" disabled="true">
                <f:selectItems value="#{controlUsuarioIlveBean.lstFinalidades}"/>
              </h:selectOneMenu>
              <a4j:outputPanel ajaxRendered="true">
                <t:message for="menuFinalidadControl" styleClass="errorMessage"/>
              </a4j:outputPanel>
              <h:panelGroup>
                <h:inputTextarea id="textEnfermedaActualControl" value="#{controlUsuarioIlveBean.motivo.hmctenferactal}"
                                 style="width:300px"/>
              </h:panelGroup>
              <a4j:outputPanel ajaxRendered="true">
                <t:message for="textEnfermedaActualControl" styleClass="errorMessage"/>
              </a4j:outputPanel>
              <h:outputText value=" "/>
              <h:outputText value=" "/>
              
              
              <h:outputText value="Efectos Secundarios" styleClass="labelTextOblig"/>
              <h:outputText value=" "/>
              <h:panelGroup>
                <h:outputText value="Escala de Dolor" styleClass="labelTextOblig"
                              rendered="#{controlUsuarioIlveBean.mostrarQuirurgico}"/>
                <h:outputText value="Escala de Dolor durante el procedimiento" styleClass="labelTextOblig"
                              rendered="#{controlUsuarioIlveBean.mostrarFarmacologico}"/>
              </h:panelGroup>
              <h:outputText value=" "/>
              <h:outputText value="Duración del dolor" styleClass="labelTextOblig"/>
              
                  <h:panelGroup id = "itTextUnidadMedida">
               <h:outputText value="Unidad de Medida" 
               styleClass="labelTextOblig"/>
               </h:panelGroup>
               <h:outputText value=" "/>
              <h:outputText value=" "/>
              <h:panelGroup>
                <h:selectManyCheckbox id="checkEfectoSecundario" layout="pageDirection"
                                      value="#{controlUsuarioIlveBean.lstEfectoSecundaSelect}"
                                      onkeydown="return blockEnter(event);">
                  <f:selectItems value="#{controlUsuarioIlveBean.lstEfectoSecunda}"/>
                </h:selectManyCheckbox>
              </h:panelGroup>
              <a4j:outputPanel ajaxRendered="true">
                <t:message for="checkEfectoSecundario" styleClass="errorMessage"/>
              </a4j:outputPanel>
              <h:panelGroup>
                <h:selectOneRadio id="selectEscalaDolor" layout="lineDirection"
                                  value="#{controlUsuarioIlveBean.motivo.hmcnescadolor}" 
                                  style="margin-left:55px; width:580px">
                  <f:selectItems value="#{controlUsuarioIlveBean.listEscala}"/>
                </h:selectOneRadio>
                <h:graphicImage url="/comun/imagenes/escalaDolor2.png" style="width:650px"/>
              </h:panelGroup>
              <a4j:outputPanel ajaxRendered="true">
                <t:message for="selectEscalaDolor" styleClass="errorMessage"/>
              </a4j:outputPanel>
              <h:panelGroup>
                <h:inputText id="menuDuraDolor" maxlength="2" size="2" immediate="true"
                             value="#{controlUsuarioIlveBean.motivo.hmcnduradolor}"
                             onkeypress="return justNumbers(event);">
                              <a4j:support event="onchange" status="statusButton"/>
                             </h:inputText>
              <a4j:outputPanel ajaxRendered="true">
                <t:message for="menuDuraDolor" styleClass="errorMessage"/>
              </a4j:outputPanel>   
              </h:panelGroup>
              <h:panelGroup><h:selectOneMenu id="menuTiempo3" styleClass="input-small labelTextOblig" immediate="true"
                value="#{controlUsuarioIlveBean.motivo.hmccdudointen}">
                    <f:selectItem itemLabel="Seleccione una opción ..." itemValue=""/>
                    <f:selectItem itemLabel="Minuto(s)" itemValue="MI"/>
                    <f:selectItem itemLabel="Hora(s)" itemValue="H"/>
                    <f:selectItem itemLabel="Día(s)" itemValue="D"/>
                    <f:selectItem itemLabel="Semana(s)" itemValue="S"/>
                     <a4j:support event="onchange" status="statusButton"/>
                </h:selectOneMenu>
                <a4j:outputPanel ajaxRendered="true">
                <t:message for="menuTiempo3" styleClass="errorMessage"/>
              </a4j:outputPanel>
              
              </h:panelGroup>
              
             
               <h:outputText value=""/>
                <h:outputText value=""/>
              <h:panelGroup id="panelSangro">
                <h:outputText value="Sangró?"
                              rendered="#{controlUsuarioIlveBean.mostrarQuirurgico}"/>
              </h:panelGroup>
              <h:outputText value=""/>
              <h:panelGroup id="panelInicioSangrado">
                <h:outputText value="El inicio de sangrado fue posterior a la toma de?"
                              styleClass="labelTextOblig"
                              rendered="#{controlUsuarioIlveBean.mostrarQuirurgico && controlUsuarioIlveBean.mostrarSangro}"/>
              </h:panelGroup>
              <h:outputText value=" "/>
              <h:panelGroup id="panelTiempoSangrado">
              <h:outputText value=" Cuanto tiempo?" styleClass="labelTextOblig" rendered="#{controlUsuarioIlveBean.mostrarQuirurgico && controlUsuarioIlveBean.mostrarSangro}"/>
               </h:panelGroup>
            <h:panelGroup>
                <h:outputText value="El dolor o el sangrado la obligaron a consultar al médico?" />
              </h:panelGroup>
               <h:outputText value=" "/>
              
              <h:outputText value=" "/>
              <!--Vamos en sangrado -->
              <h:panelGroup id="selectOneSangro">
                <a4j:region renderRegionOnly="false">
                  <h:selectOneRadio id="selectSangroo" rendered="#{controlUsuarioIlveBean.mostrarQuirurgico}"
                                    value="#{controlUsuarioIlveBean.motivo.hmccpresangro}" immediate="true"
                                    valueChangeListener="#{controlUsuarioIlveBean.setHmccpresangro}"
                                    binding="#{controlUsuarioIlveBean.selectSangroo}">
                    <f:selectItems value="#{controlUsuarioIlveBean.listSangrado}"/>
                    <a4j:support id="supportSelectSangro" event="onclick"
                                 action="#{controlUsuarioIlveBean.changeSangro}" immediate="true"
                                 reRender="panelInicioSangrado,panelSelectIniSangrado,panelSelectIniSangrado2,panelTiempoSangrado">
                      <a4j:ajaxListener type="org.ajax4jsf.ajax.ForceRender"/>
                    </a4j:support>
                  </h:selectOneRadio>
                </a4j:region>
              </h:panelGroup>
              <a4j:outputPanel ajaxRendered="true">
                <t:message for="selectSangroo" styleClass="errorMessage"/>
              </a4j:outputPanel>
              <h:panelGroup id="panelSelectIniSangrado">              
              <h:selectOneMenu id="menuIniSangrado" value="#{controlUsuarioIlveBean.motivo.hmccsangposte}"
                                 rendered="#{controlUsuarioIlveBean.mostrarQuirurgico && controlUsuarioIlveBean.mostrarSangro}">
                  <f:selectItem itemLabel="Seleccione una opción... " itemValue=""/>
                  <f:selectItem itemLabel="Mifepristona " itemValue="MIFE"/>
                  <f:selectItem itemLabel="Misoprostol" itemValue="MISO"/>                  
              </h:selectOneMenu>
                </h:panelGroup>
              
              <h:outputText value=" "/>
              <h:panelGroup id="panelSelectIniSangrado2">
               <h:inputText id="menuIniSangrado2" value="#{controlUsuarioIlveBean.motivo.hmcninicisang}" maxlength="2" styleClass="input-small labelTextOblig"
                             size="2"
                             rendered="#{controlUsuarioIlveBean.mostrarQuirurgico && controlUsuarioIlveBean.mostrarSangro}"
                             onkeypress="return justNumbers(event);"></h:inputText>
               <h:selectOneMenu id="menuTiempo4" styleClass="input-small labelTextOblig" value="#{controlUsuarioIlveBean.motivo.hmcctiemsangro}" rendered="#{controlUsuarioIlveBean.mostrarQuirurgico && controlUsuarioIlveBean.mostrarSangro}">
                    <f:selectItem itemLabel="Tiempo ..." itemValue=""/>
                    <f:selectItem itemLabel="Hora(s)" itemValue="H"/>
                    <f:selectItem itemLabel="Día(s)" itemValue="D"/>
                    <f:selectItem itemLabel="Semana(s)" itemValue="S"/>
                    <f:selectItem itemLabel="Mes(s)" itemValue="M"/>
                    <f:selectItem itemLabel="Año(s)" itemValue="A"/>
                </h:selectOneMenu>
           
            
              <a4j:outputPanel ajaxRendered="true">
                <t:message for="menuIniSangrado" styleClass="errorMessage"/>
              </a4j:outputPanel>  
              </h:panelGroup>
               <h:panelGroup>
               <h:selectOneRadio id="selectConsuMedico" value="#{controlUsuarioIlveBean.motivo.hmccconsumedi}">
                <f:selectItems value="#{controlUsuarioIlveBean.listConsuMedico}"/>
              </h:selectOneRadio>
              <a4j:outputPanel ajaxRendered="true">
                <t:message for="selectConsuMedico" styleClass="errorMessage"/>
              </a4j:outputPanel>
              </h:panelGroup>
              <h:outputText value=" "/>
              <h:outputText value=" "/>
              <h:panelGroup id="panelTextCantidad">
                <h:outputText value="Comparado con una mestruación normal su sangrado fue?" styleClass="labelTextOblig"
                              rendered="#{controlUsuarioIlveBean.mostrarFarmacologico}"/>
              </h:panelGroup>
              <h:outputText value=""/>
              <h:panelGroup id="panelTextDuracion">
                <h:outputText value="Cuanto tiempo duró con sangrado?" styleClass="labelTextOblig"
                              rendered="#{controlUsuarioIlveBean.mostrarFarmacologico}"/>
              </h:panelGroup>
              <h:outputText value=""/>
              <h:outputText value=""/>
               <h:outputText value=""/>
                <h:outputText value=""/>
                
              <h:outputText value=""/>
              
              
                        
           <h:panelGroup id="panelOneMenuCantidad">
                <h:selectOneMenu id="menuCantidadSangrado" value="#{controlUsuarioIlveBean.motivo.hmcccantisang}"
                                 rendered="#{controlUsuarioIlveBean.mostrarFarmacologico}">
                  <f:selectItems value="#{controlUsuarioIlveBean.listCantSangra}"/>
                </h:selectOneMenu>
              </h:panelGroup>
               <h:outputText value=" "/>
              <h:panelGroup id="panelOneMenuDuracion">
                <h:selectOneMenu id="menuDuraDolorDias" value="#{controlUsuarioIlveBean.motivo.hmcndurasangr}"
                                 rendered="#{controlUsuarioIlveBean.mostrarFarmacologico}">
                  <f:selectItems value="#{controlUsuarioIlveBean.listDuraDolor}"/>
                </h:selectOneMenu>
                <h:selectOneMenu id="menuTiempo" styleClass="input-small labelTextOblig" 
                    rendered="#{controlUsuarioIlveBean.mostrarFarmacologico}"
                    value="#{controlUsuarioIlveBean.motivo.hmcctiemdusang}">
                    <f:selectItem itemLabel="Tiempo ..." itemValue=""/>
                    <f:selectItem itemLabel="Hora(s)" itemValue="H"/>
                    <f:selectItem itemLabel="Día(s)" itemValue="D"/>
                    <f:selectItem itemLabel="Semana(s)" itemValue="S"/>
                    <f:selectItem itemLabel="Mes(s)" itemValue="M"/>
                    <f:selectItem itemLabel="Año(s)" itemValue="A"/>
                </h:selectOneMenu>
               </h:panelGroup>
              <a4j:outputPanel ajaxRendered="true">
                <t:message for="menuDuraDolorDias" styleClass="errorMessage"/>
              </a4j:outputPanel>
             
               <h:outputText value=""/>
              <h:outputText value=" "/>
              <h:outputText value=" "/>
               <h:outputText value=" "/>
              <h:outputText value=" "/>
            
                <h:outputText value=""/>
            
              <h:outputText value=""/>
              
              
              
                <h:outputText value=""/>
            
              <h:outputText value=" "/>
              <h:outputText value=""/>
              <h:outputText value=" "/>
            
                <h:outputText value=""/>
             
              <h:outputText value=" "/>
              <h:outputText value=" "/>
             <h:outputText value=" "/>
              
              
              <h:panelGroup>
                <h:outputText value=""/>
              </h:panelGroup>
              <h:outputText value=" "/>
              <h:outputText value=""/>
              
              <h:panelGroup>
                <h:outputText value=""/>
              </h:panelGroup>
              <h:outputText value=" "/>
              <h:panelGroup id="paneltiempoSangro">
                <h:outputText value="Cuanto tiempo duro con sangrado mayor al de una mestruación normal? "
                              styleClass="labelTextOblig"
                              rendered="#{controlUsuarioIlveBean.mostrarQuirurgico && controlUsuarioIlveBean.mostrarSangro}"/>
              </h:panelGroup>
              <h:outputText value=" "/>
              <h:outputText value=" "/>
              <h:outputText value=" "/>
              <h:outputText value=" "/>
              <h:outputText value=" "/>
              <h:outputText value=" "/>
              <h:outputText value=" "/>
              <h:panelGroup id="panelmenuMayorSangrado">
                <h:selectOneMenu id="menuMayorSangrado" value="#{controlUsuarioIlveBean.motivo.hmcnsangmayor}"
                                 rendered="#{controlUsuarioIlveBean.mostrarQuirurgico && controlUsuarioIlveBean.mostrarSangro}">
                  <f:selectItems value="#{controlUsuarioIlveBean.listDuraDolor}"/>
                </h:selectOneMenu>
                <h:selectOneMenu id="menuTiempo5" styleClass="input-small labelTextOblig" 
                    value="#{controlUsuarioIlveBean.motivo.hmcctiemduraci}" 
                    rendered="#{controlUsuarioIlveBean.mostrarQuirurgico && controlUsuarioIlveBean.mostrarSangro}">
                    <f:selectItem itemLabel="Tiempo ..." itemValue=""/>
                    <f:selectItem itemLabel="Hora(s)" itemValue="H"/>
                    <f:selectItem itemLabel="Día(s)" itemValue="D"/>
                    <f:selectItem itemLabel="Semana(s)" itemValue="S"/>
                    <f:selectItem itemLabel="Mes(s)" itemValue="M"/>
                    <f:selectItem itemLabel="Año(s)" itemValue="A"/>
                </h:selectOneMenu>
              
              </h:panelGroup>
              <a4j:outputPanel ajaxRendered="true">
                <t:message for="menuMayorSangrado" styleClass="errorMessage"/>
              </a4j:outputPanel>
              
             
            </h:panelGrid>
          </s:fieldset>
        
          <!-- Reporte de Ecografia -->
          <s:fieldset legend="Reporte de Ecografia" id="fieldEcografiaConsultaControl" styleClass="fieldset" rendered="#{!controlUsuarioIlveBean.renderConfirmaEnbarazo}">
            <h:panelGrid columns="6" border="0" cellpadding="0" cellspacing="0" width="100%"
                         id="panelDatosEcografiaConsultaControl" rowClasses="labelText, labelTextInfo">
              <h:outputText value="Reporta Ecografia?" styleClass="labelTextOblig"/>
              <h:outputText value=""/>
              <h:outputText value=""/>
              <h:outputText value=""/>
              <h:outputText value=""/>
              <h:outputText value=""/>
              <h:panelGroup>
                <a4j:region renderRegionOnly="false">
                  <h:selectOneRadio id="mnuEcografia" onkeydown="return blockEnter(event);" immediate="true"
                                    value="#{controlUsuarioIlveBean.motivo.hmccrepoecogr}"
                                    valueChangeListener="#{controlUsuarioIlveBean.setHmccrepoecogr}">
                    <f:selectItems value="#{controlUsuarioIlveBean.listOpciones}"/>
                    <a4j:support id="supportmnuEcografia" event="onclick"
                                 action="#{controlUsuarioIlveBean.changeEcografia}"
                                 reRender="inputGrosor,panelAcepDoppler, panelGrosor, panelDooppler, panelDoopletCard, panelDoopler,checkComplicaciones,textComplicaciones">
                      <a4j:ajaxListener type="org.ajax4jsf.ajax.ForceRender"/>
                    </a4j:support>
                  </h:selectOneRadio>
                </a4j:region>
                <a4j:outputPanel ajaxRendered="true">
                  <t:message for="mnuEcografia" styleClass="errorMessage"/>
                </a4j:outputPanel>
              </h:panelGroup>
              <h:outputText value=""/>
              <h:outputText value=""/>
              <h:outputText value=""/>
              <h:outputText value=""/>
              <h:outputText value=""/>
              <h:panelGroup id="panelGrosor">
                <h:outputText value="Grosor Endometrial" styleClass="labelTextOblig"
                              rendered="#{controlUsuarioIlveBean.mostrarEcografias}"/>
              </h:panelGroup>
              <h:outputText value=""/>
              <h:panelGroup id="panelDooppler">
                <h:outputText value="Doppler" styleClass="labelTextOblig"
                              rendered="#{controlUsuarioIlveBean.mostrarEcografias}"/>
              </h:panelGroup>
              <h:outputText value=""/>
              <h:panelGroup id="panelDoopler">
                <h:outputText value="Doppler " styleClass="labelTextOblig"
                              rendered="#{controlUsuarioIlveBean.mostrarDoppler}"/>
              </h:panelGroup>
              <h:outputText value=""/>
              <h:panelGroup id="inputGrosor">
                <h:inputText id="inputGrosorEndo" maxlength="4" onkeydown="return blockEnter(event);" 
                             value="#{controlUsuarioIlveBean.motivo.hmcngrosendom}"
                             rendered="#{controlUsuarioIlveBean.mostrarEcografias}">
                             
                             </h:inputText>
                <h:outputLabel value="mm" rendered="#{controlUsuarioIlveBean.mostrarEcografias}"/>
              </h:panelGroup>
              <a4j:outputPanel ajaxRendered="true">
                <t:message for="inputGrosorEndo" styleClass="errorMessage"/>
              </a4j:outputPanel>
              <h:panelGroup id="panelAcepDoppler">
                <a4j:region renderRegionOnly="false">
                  <h:selectOneRadio id="mnuDoppler" onkeydown="return blockEnter(event);" immediate="true"
                                    rendered="#{controlUsuarioIlveBean.mostrarEcografias}"
                                    value="#{controlUsuarioIlveBean.motivo.hmccdopplerva}"
                                    binding="#{controlUsuarioIlveBean.mnuDoppler}"
                                    valueChangeListener="#{controlUsuarioIlveBean.setHmccdopplerva}">
                    <f:selectItems value="#{controlUsuarioIlveBean.listOpciones}"/>
                    <a4j:support id="supportmnuDoppler" event="onclick" action="#{controlUsuarioIlveBean.changeDoppler}"
                                 reRender="panelDoopler, panelDoopletCard ">
                      <a4j:ajaxListener type="org.ajax4jsf.ajax.ForceRender"/>
                    </a4j:support>
                  </h:selectOneRadio>
                </a4j:region>
              </h:panelGroup>
              <a4j:outputPanel ajaxRendered="true">
                <t:message for="mnuDoppler" styleClass="errorMessage"/>
              </a4j:outputPanel>
              <h:panelGroup id="panelDoopletCard">
                <h:selectOneRadio id="selectDooplerCard" rendered="#{controlUsuarioIlveBean.mostrarDoppler}"
                                  value="#{controlUsuarioIlveBean.motivo.hmccdoppcardn}">
                  <f:selectItems value="#{controlUsuarioIlveBean.lstDoppler}"/>
                </h:selectOneRadio>
              </h:panelGroup>
              <a4j:outputPanel>
                <t:message for="selectDooplerCard" styleClass="errorMessage"/>
              </a4j:outputPanel>
              <h:panelGroup id="textComplicaciones">
                <h:outputText value="Complicaciones" styleClass="labelTextOblig"
                              rendered="#{controlUsuarioIlveBean.mostrarEcografias}"/>
              </h:panelGroup>
              <h:outputText value=""/>
              <h:outputText value=""/>
              <h:outputText value=""/>
              <h:outputText value=""/>
              <h:outputText value=""/>
              <h:panelGroup id="checkComplicaciones">
                <h:selectManyCheckbox id="checkMultiCompli" layout="pageDirection"
                                      value="#{controlUsuarioIlveBean.lstComplicacionesSelect}"
                                      rendered="#{controlUsuarioIlveBean.mostrarEcografias}"
                                      onkeydown="return blockEnter(event);">
                  <f:selectItems value="#{controlUsuarioIlveBean.lstComplicaciones}"/>
                </h:selectManyCheckbox>
              </h:panelGroup>
              <a4j:outputPanel ajaxRendered="true">
                <t:message for="checkComplicaciones" styleClass="errorMessage"/>
              </a4j:outputPanel>
              <h:outputText value=""/>
              <h:outputText value=""/>
              <h:outputText value=""/>
              <h:outputText value=""/>
               <h:outputText value="Observaciones" styleClass="labelTextOblig"/>
              <h:outputText value=""/>
              <h:outputText value=""/>
              <h:outputText value=""/>
              <h:outputText value=""/>
              <h:outputText value=""/>
                 <h:panelGroup>
                <h:inputTextarea id="textObservacionesEco" required="true" value="#{controlUsuarioIlveBean.motivo.hmccecoobservac}"
                                 style="width:600px"/>
              </h:panelGroup>
              <a4j:outputPanel ajaxRendered="true">
                <t:message for="textObservacionesEco" styleClass="errorMessage"/>
              </a4j:outputPanel>
            </h:panelGrid>
          </s:fieldset>
          <t:htmlTag value="br"/>
          <!-- Anticoncepcion en IVE -->
          <s:fieldset legend="Anticoncepción" id="fieldAnticoncepcionConsultaControl" styleClass="fieldset" rendered="#{!controlUsuarioIlveBean.renderConfirmaEnbarazo}">
            <h:panelGrid columns="4" border="0" cellpadding="0" cellspacing="0" width="100%"
                         id="panelDatosAnticoncepcionConsultaControl" >
              <h:outputText value="Ya esta Planificando?" styleClass="labelTextOblig"/>
              <h:panelGroup id="panelLabelAnticoncepcionNo">
                <h:outputText value="Va a iniciar Anticoncepción en este Control?" styleClass="labelTextOblig"
                              rendered="#{controlUsuarioIlveBean.mostrarAnticoncepcionNo}"/>
              </h:panelGroup>
              <h:panelGroup id="panelAnticoncepcion2">
                <h:outputText value="Metodo Anticonceptivo" styleClass="labelTextOblig"
                              rendered="#{controlUsuarioIlveBean.mostrarMetodoAnticoncepcion}"/>
              </h:panelGroup>
                <h:panelGroup id="pnelCual">
                <h:outputText value="Cual" styleClass="labelTextOblig"
                              rendered="#{controlUsuarioIlveBean.renderCual}"/>
              </h:panelGroup>
             
              
         
          
             
              <h:panelGroup>
                <a4j:region renderRegionOnly="false">
                  <h:selectOneRadio id="mnuAnticoncepcion" onkeydown="return blockEnter(event);" immediate="true"
                                    value="#{controlUsuarioIlveBean.motivo.hmccanticonce}"
                                    valueChangeListener="#{controlUsuarioIlveBean.setHmccanticonce}">
                    <f:selectItems value="#{controlUsuarioIlveBean.listOpciones}"/>
                    <a4j:support id="supportmnuAnticoncepcion" event="onclick"
                                 action="#{controlUsuarioIlveBean.changeAnticoncepcion}"
                                 reRender="panelAnticoncep,panelMetodoPlan,panelTolerancia,panelToleranciaSelect,panelAnticoncepcionNo,panelLabelAnticoncepcionNo,panelAnticoncepcion2,panelMetodoPlan2                                  ,panelInputOtroMetodo,panelOtroAnticoncep,lblObservaciones,pgObservacionesAnti,pnelCual,panelTextoCual">
                      <a4j:ajaxListener type="org.ajax4jsf.ajax.ForceRender"/>
                    </a4j:support>
                  </h:selectOneRadio>
                </a4j:region>
                <a4j:outputPanel ajaxRendered="true">
                  <t:message for="mnuAnticoncepcion" styleClass="errorMessage"/>
                </a4j:outputPanel>
              </h:panelGroup>
              <h:panelGroup id="panelAnticoncepcionNo">
                <a4j:region renderRegionOnly="false">
                  <h:selectOneRadio id="mnuAnticoncepcionNo" onkeydown="return blockEnter(event);" immediate="true"
                                    rendered="#{controlUsuarioIlveBean.mostrarAnticoncepcionNo}"
                                    value="#{controlUsuarioIlveBean.motivo.hmccinicimetod}"
                                    valueChangeListener="#{controlUsuarioIlveBean.setHmccinicimetod}"
                                    binding="#{controlUsuarioIlveBean.radioInicioAnticon}">
                    <f:selectItems value="#{controlUsuarioIlveBean.listOpciones}"/>
                    <a4j:support id="supportmnuAnticoncepcionNo" event="onclick"
                                 action="#{controlUsuarioIlveBean.changeIniciaAnticoncepcion}"
                                 reRender="panelMetodoPlan2,panelAnticoncepcion2,lblObservaciones,pgObservacionesAnti,pnelCual,panelTextoCual">
                      <a4j:ajaxListener type="org.ajax4jsf.ajax.ForceRender"/>
                    </a4j:support>
                  </h:selectOneRadio>
                </a4j:region>
                <a4j:outputPanel ajaxRendered="true">
                  <t:message for="mnuAnticoncepcionNo" styleClass="errorMessage"/>
                </a4j:outputPanel>
              </h:panelGroup>
              <h:panelGroup id="panelMetodoPlan2">
                <h:selectOneMenu id="mnuMetodoPlanificacion2" immediate="true"
                                 rendered="#{controlUsuarioIlveBean.mostrarMetodoAnticoncepcion}"
                                 value="#{controlUsuarioIlveBean.motivo.hmccmetodantn}"
                                 onkeydown="return blockEnter(event);"
                                 valueChangeListener="#{controlUsuarioIlveBean.setHmccmetodantn}"
                                 binding="#{controlUsuarioIlveBean.mnuMetodoAntico}">
                  <f:selectItems value="#{controlUsuarioIlveBean.lstMetodo}"/>
                        <a4j:support id="supporMetodoPlanificacion1" event="onchange" immediate="true"
                               action="#{controlUsuarioIlveBean.changeAntiCual}"
                               reRender="pnelCual,panelTextoCual">
                    <a4j:ajaxListener type="org.ajax4jsf.ajax.ForceRender"/>
                  </a4j:support>
                </h:selectOneMenu>
              </h:panelGroup>
              <h:panelGroup id="panelTextoCual">
             <h:inputText id="textoCual" maxlength="50" value="#{controlUsuarioIlveBean.motivo.hmccanticual}" required="true" rendered="#{controlUsuarioIlveBean.renderCual}"/>
             </h:panelGroup>
               <a4j:outputPanel ajaxRendered="true">
                  <t:message for="textoCual" styleClass="errorMessage"/>
                </a4j:outputPanel>
                
              <h:panelGroup id="panelAnticoncep">
                <h:outputText value="Metodo Anticonceptivo" styleClass="labelTextOblig"
                              rendered="#{controlUsuarioIlveBean.mostrarAnticoncepcion}"/>
              </h:panelGroup>
            

              <h:panelGroup id="panelOtroAnticoncep">
                <h:outputText value="Cual?" styleClass="labelTextOblig"
                              rendered="#{controlUsuarioIlveBean.mostrarMetodo}"/>
              </h:panelGroup>
            
              <h:panelGroup id="panelTolerancia">
                <h:outputText value="La Tolerancia al metodo actual es?" styleClass="labelTextOblig"
                              rendered="#{controlUsuarioIlveBean.mostrarAnticoncepcion}"/>
              </h:panelGroup>
              <h:outputText value=""/>
              <h:panelGroup id="panelMetodoPlan">
                <h:selectOneMenu id="mnuMetodoPlanificacion" immediate="true"
                                 rendered="#{controlUsuarioIlveBean.mostrarAnticoncepcion}"
                                 value="#{controlUsuarioIlveBean.motivo.hmccmetoantic}"
                                 onkeydown="return blockEnter(event);"
                                 valueChangeListener="#{controlUsuarioIlveBean.setHmccmetoantic}"
                                 binding="#{controlUsuarioIlveBean.radioMetodoAnticon}">
                  <f:selectItems value="#{controlUsuarioIlveBean.lstMetodo}"/>
                  <a4j:support id="supporMetodoPlanificacion" event="onchange" immediate="true"
                               action="#{controlUsuarioIlveBean.ChangeMetodo}"
                               reRender="panelOtroAnticoncep,panelInputOtroMetodo,lblObservaciones,pgObservacionesAnti">
                    <a4j:ajaxListener type="org.ajax4jsf.ajax.ForceRender"/>
                  </a4j:support>
                </h:selectOneMenu>
              </h:panelGroup>
              <h:panelGroup id="panelInputOtroMetodo">
                <h:inputText id="inputOtroMetodo" maxlength="50" onkeydown="return blockEnter(event);" required="false"
                             rendered="#{controlUsuarioIlveBean.mostrarMetodo}"
                             value="#{controlUsuarioIlveBean.motivo.hmccotrometo}"/>
                <a4j:outputPanel ajaxRendered="true">
                  <t:message for="inputOtroMetodo" styleClass="errorMessage"/>
                </a4j:outputPanel>
              </h:panelGroup>
              <h:panelGroup id="panelToleranciaSelect">
                <h:selectOneMenu id="mnuTolerancia" immediate="true"
                                 rendered="#{controlUsuarioIlveBean.mostrarAnticoncepcion}"
                                 value="#{controlUsuarioIlveBean.motivo.hmcctolemetod}"
                                 onkeydown="return blockEnter(event);"
                                 valueChangeListener="#{controlUsuarioIlveBean.setHmcctolemetod}"
                                 binding="#{controlUsuarioIlveBean.mnuTolerancia}">
                  <f:selectItems value="#{controlUsuarioIlveBean.listTolerancia}"/>
                </h:selectOneMenu>
              </h:panelGroup>
              <h:panelGroup id="lblObservaciones">
                <h:outputText styleClass="labelTextOblig"  rendered="#{controlUsuarioIlveBean.renderObservaciones}" value="Observaciones"/>
              </h:panelGroup>
                <h:outputText value=""/>
                  <h:outputText value=""/>
                    <h:outputText value=""/>
                      <h:outputText value=""/>
                        <h:outputText value=""/>
               
              
            </h:panelGrid>
               <h:panelGrid columns="1" border="0" cellpadding="0" cellspacing="0" 
                         id="panelDatosAniconcepcionConsultaControl" >
                           <h:panelGroup id="pgObservacionesAnti">
                <h:inputTextarea id="textObservacionesAnti" required="true" rendered="#{controlUsuarioIlveBean.renderObservaciones}" value="#{controlUsuarioIlveBean.motivo.hmccantiobservac}"
                                 style="width:600px"/>
              </h:panelGroup>
              <a4j:outputPanel ajaxRendered="true">
                <t:message for="textObservacionesAnti" styleClass="errorMessage"/>
              </a4j:outputPanel>
                         </h:panelGrid>
          </s:fieldset>
        </h:panelGrid>
         <h:panelGrid columns="1" border="0" cellpadding="0" cellspacing="0" width="100%"
                     id="tableContentTabsConsultaControlConfEmb" styleClass="tabContainerControl">
          <s:fieldset legend="Motivo de la Consulta " id="fieldMotivoConsultaControlConfEmb" styleClass="fieldset" rendered="#{controlUsuarioIlveBean.renderConfirmaEnbarazo}">
            <h:panelGrid columns="4" border="0" cellpadding="0" cellspacing="0" width="100%" id="panelMotivoConsultaControlConfEmb" rowClasses="labelText,labelTextInfo">
            <h:outputText value="Causa Externa" styleClass="labelTextOblig"/>
            <h:outputText value=" "/>
            <h:panelGroup>
            <h:outputText value="Motivo de Consulta"/>
            </h:panelGroup>
            <h:outputText value=" "/>
            <h:selectOneMenu id="menuCausaExternaControlConfEmb"  
                onkeydown="return blockEnter(event);" 
            value="#{controlUsuarioIlveBean.motivo.hmcncausaexte}">
              <f:selectItems value="#{controlUsuarioIlveBean.lstCausa}"/>
            </h:selectOneMenu>
            <a4j:outputPanel ajaxRendered="true">
              <t:message for="menuCausaExternaControlConfEmb" styleClass="errorMessage"/>
            </a4j:outputPanel>
            <h:panelGroup>
            <h:inputTextarea id="textMotivoConsultaControlConfEmb" 
                 
                value="#{controlUsuarioIlveBean.motivo.hmctdescripcio}" style="width:300px"/>
            </h:panelGroup>
            <a4j:outputPanel ajaxRendered="true">
              <t:message for="textMotivoConsultaControlConfEmb" styleClass="errorMessage"/>
            </a4j:outputPanel>
            <h:outputText value="Finalidad" styleClass="labelTextOblig"/>
            <h:outputText value=" "/>
            <h:panelGroup>
            <h:outputText value="Enfermedad Actual" />
            </h:panelGroup>
            <h:outputText value=" "/>
            <h:selectOneMenu id="menuFinalidadControlConfEmb" onkeydown="return blockEnter(event);"   
            value="#{controlUsuarioIlveBean.motivo.hmcnfinalidad}">
              <f:selectItems value="#{controlUsuarioIlveBean.lstFinalidades}"/>
            </h:selectOneMenu>
            <a4j:outputPanel ajaxRendered="true">
              <t:message for="menuFinalidadControlConfEmb" styleClass="errorMessage"/>
            </a4j:outputPanel>
            <h:panelGroup>
            <h:inputTextarea id="textEnfermedaActualControlConfEmb"   
            value="#{controlUsuarioIlveBean.motivo.hmctenferactal}" style="width:500px"/>
            </h:panelGroup>
            <a4j:outputPanel ajaxRendered="true">
              <t:message for="textEnfermedaActualControlConfEmb" styleClass="errorMessage"/>
            </a4j:outputPanel>
          </h:panelGrid>
          </s:fieldset>
           <s:fieldset legend="Datos consulta previa" id="fieldDatosConsultaPrevia" styleClass="fieldset"  rendered="#{controlUsuarioIlveBean.renderConfirmaEnbarazo}">
             <h:panelGrid columns="1" border="0" cellpadding="0" cellspacing="0" width="100%" id="panelDatosConsultaPrevia" rowClasses="labelText,labelTextInfo" rendered="#{controlUsuarioIlveBean.renderConsultaPrevia}">
              <h:outputText value="F.U.R Normal"/>
                 <h:inputText id="fechaUltRegla" onkeydown="return blockEnter(event);" 
                             value="#{controlUsuarioIlveBean.FUR}" disabled="true">
                             
               </h:inputText>
               <h:outputText value="Semana de Embarazo"/>
                 <h:inputText id="semanaEmbarazo" onkeydown="return blockEnter(event);" 
                             value="#{controlUsuarioIlveBean.semanaEmbarazo}" disabled="true"/>
             </h:panelGrid>
           </s:fieldset>
            <s:fieldset legend="Observaciones:" id="fieldObservacionesConfEmb" styleClass="fieldset"  rendered="#{controlUsuarioIlveBean.renderConfirmaEnbarazo}" >
             <h:panelGrid columns="1" border="0" cellpadding="0" cellspacing="0" width="100%" id="panelObservacionesConfEmb" rowClasses="labelText,labelTextInfo">
                <h:outputText value="Observaciones"/>
                 <h:panelGroup>
                <h:inputTextarea id="textObservacionesConfEmb" required="true" value="#{controlUsuarioIlveBean.motivo.hmccobsconemb}"
                                 style="width:600px"/>
              </h:panelGroup>
              <a4j:outputPanel ajaxRendered="true">
                <t:message for="textObservacionesConfEmb" styleClass="errorMessage"/>
              </a4j:outputPanel>
             </h:panelGrid>
             </s:fieldset>
          </h:panelGrid>
        <h:panelGrid columns="1" border="0" cellpadding="0" cellspacing="0" width="100%"
                     id="panelBotonRegistrarNotaMedicaConsultaControl" columnClasses="panelGridBotones">
          <h:panelGroup>
            <h:commandButton value="Guardar" styleClass="btn btn btn-success"
                             action="#{controlUsuarioIlveBean.aceptar}">
              <a4j:support event="onclick" status="statusButton"/>
            </h:commandButton>
          </h:panelGroup>
        </h:panelGrid>
        <h:panelGrid>
          <h:panelGroup>
            <a4j:outputPanel id="ajaxRegionMessagesatributo1ConsultaControl" ajaxRendered="true">
              <t:htmlTag value="br"/>
              <t:messages id="msgInformationAndErrors1ConsultaControl" showSummary="true" errorClass="error"
                          globalOnly="true" layout="table" infoClass="informacion"/>
            </a4j:outputPanel>
          </h:panelGroup>
        </h:panelGrid>
      </a4j:region>
    </t:panelTab>
    <t:panelTab id="panelBuscadorConsultaControl" label="Buscar Diagnosticos"
                rendered="#{controlUsuarioIlveBean.mostrarCie10}">
      <a4j:region id="regionCie10ConsultaControl" renderRegionOnly="false">
        <a4j:status for="regionCie10ConsultaControl">
          <f:facet name="start">
            <t:div id="chargingCie10ConsultaControl" styleClass="loading">
              <h:panelGrid columns="1" cellpadding="0" cellspacing="0" border="0">
                <h:outputText value="Procesando..."/>
                <h:outputText value="Por favor espere."/>
              </h:panelGrid>
            </t:div>
          </f:facet>
          <f:facet name="stop"/>
        </a4j:status>
        <jsp:include page="/pages/clinico/registro/buscadorCie10.jsp" flush="true"/>
        <h:panelGrid id="panelGridCie10BotonesConsultaControl" width="100%" columnClasses="columnaBotonesCentrados"
                     dir="RTL">
          <t:htmlTag value="br"/>
          <h:panelGroup id="panelGroupCie10Botones1ConsultaControl">
            <a4j:commandButton value="Aceptar" styleClass="btn btn btn-success"
                               action="#{controlUsuarioIlveBean.aceptarDiagnostico}"
                               reRender="panelGridConsultaControlSinCostoTab">
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