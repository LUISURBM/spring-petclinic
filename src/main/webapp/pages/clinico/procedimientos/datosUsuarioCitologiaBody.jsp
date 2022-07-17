<%@ page contentType="text/html;charset=iso-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsf/html" prefix="h"%>
<%@ taglib uri="http://java.sun.com/jsf/core" prefix="f"%>
<%@ taglib uri="http://richfaces.org/a4j" prefix="a4j"%>
<%@ taglib uri="http://myfaces.apache.org/tomahawk" prefix="t"%>
<%@ taglib uri="http://myfaces.apache.org/sandbox" prefix="s"%>
<a4j:keepAlive beanName="datosUsuarioCitologiaBean"/>
<a4j:form id="formDatosUsuarioCitologia">
  <a4j:region id="regionDatosUsuario" renderRegionOnly="false">
    <a4j:status id="statusButton" for="regionDatosUsuario">
      <f:facet name="start">
        <t:div id="chargingDatosUsuario" styleClass="loading">
          <h:panelGrid columns="1" cellpadding="0" cellspacing="0" border="0">
            <h:outputText value="Procesando..."/>
            <h:outputText value="Por favor espere."/>
          </h:panelGrid>
        </t:div>
      </f:facet>
      <f:facet name="stop"/>
    </a4j:status>
    
    <h:panelGrid columns="1" border="0" cellpadding="0" cellspacing="0" width="100%" id="panelGridDatosUsuarioTab"
                 styleClass="tabContainer">
      <t:panelTabbedPane border="0" cellpadding="0" cellspacing="0" serverSideTabSwitch="false" activePanelTabVar="true"
                         width="100%" id="panelTabbedPaneDatosUsuario" styleClass="tabbedPane"
                         activeTabStyleClass="activeTab" inactiveTabStyleClass="inactiveTab"
                         disabledTabStyleClass="disabledTab" activeSubStyleClass="activeSub"
                         inactiveSubStyleClass="inactiveSub" tabContentStyleClass="tabContent">
        <t:panelTab id="panelTabDatosUsuario" label="Datos Usuario">
          <h:panelGrid id="panleDatosBasicos" columns="1" border="0" cellpadding="0" cellspacing="0" width="100%"
                       styleClass="tabContainer">
            <s:fieldset legend="Datos Basicos" id="fieldSetInfoBasica" styleClass="fieldset">
              <h:panelGrid columns="3" border="0" cellpadding="0" cellspacing="0" width="100%"
                           id="panelRegionInfoConsulta" rowClasses="labelText,labelTextInfo">
                <h:outputText value="Clinica" styleClass="labelTextOblig"/>
                <h:outputText value=" Numero Citologia" styleClass="labelTextOblig"/>
                <h:outputText value="Fecha" styleClass="labelTextOblig"/>
                <h:outputText value="#{datosUsuarioCitologiaBean.clinUsuario}"/>
                <h:panelGroup>
                  <h:inputText id="inputNumeroCitologia" value="#{datosUsuarioCitologiaBean.citologia.ccinnumero}"
                               required="true"/>
                  <a4j:outputPanel ajaxRendered="true">
                    <t:message for="inputNumeroCitologia" styleClass="errorMessage"/>
                  </a4j:outputPanel>
                </h:panelGroup>
                <h:panelGroup>
                  <t:inputCalendar id="fechaActual" onkeydown="return blockEnter(event);"
                                   monthYearRowClass="yearMonthHeader" weekRowClass="weekHeader" immediate="true"
                                   title="Formato: dd/mm/yyyy" currentDayCellClass="currentDayCell"
                                   popupDateFormat="dd/MM/yyyy" renderAsPopup="true"
                                   value="#{datosUsuarioCitologiaBean.fecha}" popupTodayString="Hoy"
                                   popupWeekString="Semana" popupButtonString="Fecha" readonly="false" maxlength="11"
                                   size="11" popupButtonImageUrl="/comun/imagenes/ico_calendario2.gif"
                                   renderPopupButtonAsImage="true" align="top" disabled="true"></t:inputCalendar>
                </h:panelGroup>
                <h:outputText value="Tipo Identificación" styleClass="labelTextOblig"/>
                <h:outputText value=" Numero Identificación" styleClass="labelTextOblig"/>
                <h:outputText value="Número Usuario" styleClass="labelTextOblig"/>
                <h:panelGroup>
                  <h:selectOneMenu id="tipoIde" required="true" disabled="true"
                                   value="#{datosUsuarioCitologiaBean.citologia.ccictipide}">
                    <f:selectItems value="#{datosUsuarioCitologiaBean.listTipoIdentificacion}"/>
                  </h:selectOneMenu>
                  <a4j:outputPanel ajaxRendered="true">
                    <t:message for="tipoIde" styleClass="errorMessage"/>
                  </a4j:outputPanel>
                </h:panelGroup>
                <h:panelGroup>
                  <h:inputText id="idtipo" disabled="true" styleClass="textmayuscula"
                               value="#{datosUsuarioCitologiaBean.citologia.ccianumide}" required="true">
                                <f:converter converterId="cadena.stringUpperCaseConverter"/>
                               </h:inputText>
                  <a4j:outputPanel ajaxRendered="true">
                    <t:message for="idtipo" styleClass="errorMessage"/>
                  </a4j:outputPanel>
                </h:panelGroup>
                <h:panelGroup>
                  <h:inputText id="itNumeroUsuario" disabled="true"
                               value="#{datosUsuarioCitologiaBean.citologia.ccilusuario.huslnumero}"/>
                </h:panelGroup>
              </h:panelGrid>
              <h:panelGrid columns="4" border="0" cellpadding="0" cellspacing="0" width="100%" id="panelDatosNombre"
                           rowClasses="labelText,labelTextInfo">
                <h:outputText value="Primer Nombre" styleClass="labelTextOblig"/>
                <h:outputText value="Segundo Nombre" styleClass="labelTextOblig"/>
                <h:outputText value="Primer Apellido" styleClass="labelTextOblig"/>
                <h:outputText value="Segundo Apellido" styleClass="labelTextOblig"/>
                <h:panelGroup>
                  <h:inputText id="primerNombre" styleClass="textmayuscula" onkeydown="return blockEnter(event);"
                               required="true" value="#{datosUsuarioCitologiaBean.citologia.ccicprinom}">
                                <f:converter converterId="cadena.stringUpperCaseConverter"/>
                               </h:inputText>
                  <a4j:outputPanel ajaxRendered="true">
                    <t:message for="primerNombre" styleClass="errorMessage"/>
                  </a4j:outputPanel>
                </h:panelGroup>
                <h:panelGroup>
                  <h:inputText id="segundoNombre" styleClass="textmayuscula" onkeydown="return blockEnter(event);"
                               value="#{datosUsuarioCitologiaBean.citologia.ccicsegnom}">
                                <f:converter converterId="cadena.stringUpperCaseConverter"/>
                               </h:inputText>
                  <a4j:outputPanel ajaxRendered="true">
                    <t:message for="segundoNombre" styleClass="errorMessage"/>
                  </a4j:outputPanel>
                </h:panelGroup>
                <h:panelGroup>
                  <h:inputText id="primerApellido" onkeydown="return blockEnter(event);" required="true"
                               value="#{datosUsuarioCitologiaBean.citologia.ccicpriape}"/>
                  <a4j:outputPanel ajaxRendered="true">
                    <t:message for="primerApellido" styleClass="errorMessage"/>
                  </a4j:outputPanel>
                </h:panelGroup>
                <h:panelGroup>
                  <h:inputText id="segundoApellido" onkeydown="return blockEnter(event);"
                               value="#{datosUsuarioCitologiaBean.citologia.ccicsegape}"/>
                  <a4j:outputPanel ajaxRendered="true">
                    <t:message for="segundoApellido" styleClass="errorMessage"/>
                  </a4j:outputPanel>
                </h:panelGroup>
                <h:outputText value="Departamento" styleClass="labelTextOblig"/>
                <h:outputText value="Municipio" styleClass="labelTextOblig"/>
                <h:outputText value="Direccion" styleClass="labelTextOblig"/>
                <h:outputText value="Telefono" styleClass="labelTextOblig"/>
                <h:panelGroup>
                  <h:selectOneMenu id="menuDepartamentos" value="#{datosUsuarioCitologiaBean.departamentoSelect}"
                                   immediate="true"
                                   valueChangeListener="#{datosUsuarioCitologiaBean.setDepartamentoSelect}">
                    <f:selectItems value="#{datosUsuarioCitologiaBean.listDepartamentos}"/>
                    <a4j:support id="support7" oncomplete="jsFunctionDepartamento()"
                                 action="#{datosUsuarioCitologiaBean.changeCiudad}" reRender="panleDatosBasicos"
                                 event="onchange" immediate="true">
                      <a4j:ajaxListener type="org.ajax4jsf.ajax.ForceRender"/>
                    </a4j:support>
                  </h:selectOneMenu>
                  <a4j:outputPanel ajaxRendered="true">
                    <t:message for="menuDepartamentos" styleClass="errorMessage"/>
                  </a4j:outputPanel>
                </h:panelGroup>
                <h:panelGroup>
                  <h:selectOneMenu id="menuCiudad" required="true" style="wdith:200px"
                                   value="#{datosUsuarioCitologiaBean.ciudadSelect}">
                    <f:selectItems value="#{datosUsuarioCitologiaBean.listMunicipios}"/>
                  </h:selectOneMenu>
                  <a4j:outputPanel ajaxRendered="true">
                    <t:message for="menuCiudad" styleClass="errorMessage"/>
                  </a4j:outputPanel>
                </h:panelGroup>
                <h:panelGroup>
                  <h:inputText id="Direccion" onkeydown="return blockEnter(event);" required="true"
                               value="#{datosUsuarioCitologiaBean.citologia.ccicdirecc}"/>
                  <a4j:outputPanel ajaxRendered="true">
                    <t:message for="Direccion" styleClass="errorMessage"/>
                  </a4j:outputPanel>
                </h:panelGroup>
                <h:panelGroup>
                  <h:inputText id="Telefono" onkeydown="return blockEnter(event);" required="true"
                               value="#{datosUsuarioCitologiaBean.citologia.ccictelefo}"/>
                  <a4j:outputPanel ajaxRendered="true">
                    <t:message for="Telefono" styleClass="errorMessage"/>
                  </a4j:outputPanel>
                </h:panelGroup>
                <h:outputText value="Fecha Nacimiento" styleClass="labelTextOblig"/>
                <h:outputText value="Edad" styleClass="labelTextOblig"/>
                <h:outputText value="Tipo de Afiliación" styleClass="labelTextOblig"/>
                <h:outputText value="EPS" styleClass="labelTextOblig"/>
                <h:panelGroup>
                  <t:inputCalendar id="fechaNacimiento" onkeydown="return blockEnter(event);"
                                   monthYearRowClass="yearMonthHeader" weekRowClass="weekHeader" immediate="true"
                                   title="Formato: dd/mm/yyyy" currentDayCellClass="currentDayCell"
                                   popupDateFormat="dd/MM/yyyy" renderAsPopup="true"
                                   value="#{datosUsuarioCitologiaBean.fechaNacimiento}"
                                   valueChangeListener="#{datosUsuarioCitologiaBean.setFechaNacimiento}"
                                   popupTodayString="Hoy" popupWeekString="Semana" popupButtonString="Fecha"
                                   readonly="false" maxlength="11" size="11"
                                   popupButtonImageUrl="/comun/imagenes/ico_calendario2.gif"
                                   renderPopupButtonAsImage="true" align="top" required="true">
                    <a4j:support id="supportNacimiento" event="onchange" immediate="true"
                                 action="#{datosUsuarioCitologiaBean.changeEdad}" reRender="panleDatosBasicos">
                      <a4j:ajaxListener type="org.ajax4jsf.ajax.ForceRender"/>
                    </a4j:support>
                  </t:inputCalendar>
                  <a4j:outputPanel ajaxRendered="true">
                    <t:message for="fechaNacimiento" styleClass="errorMessage"/>
                  </a4j:outputPanel>
                </h:panelGroup>
                <h:panelGroup>
                  <h:inputText id="inputEdad" disabled="true" value="#{datosUsuarioCitologiaBean.edad}"/>
                </h:panelGroup>
                <h:panelGroup>
                  <h:selectOneMenu id="menuAfiliacion" required="true"
                                   value="#{datosUsuarioCitologiaBean.citologia.ccictipafi}">
                    <f:selectItems value="#{datosUsuarioCitologiaBean.listTipoAfiliacion}"/>
                  </h:selectOneMenu>
                  <a4j:outputPanel ajaxRendered="true">
                    <t:message for="menuAfiliacion" styleClass="errorMessage"/>
                  </a4j:outputPanel>
                </h:panelGroup>
                <h:panelGroup>
                  <h:selectOneMenu id="menuEps" required="true"
                                   value="#{datosUsuarioCitologiaBean.citologia.ccicasegur}">
                    <f:selectItems value="#{datosUsuarioCitologiaBean.listEntidadAdm}"/>
                  </h:selectOneMenu>
                  <a4j:outputPanel ajaxRendered="true">
                    <t:message for="menuEps" styleClass="errorMessage"/>
                  </a4j:outputPanel>
                </h:panelGroup>
              </h:panelGrid>
            </s:fieldset>
            <s:fieldset legend="Otros Datos" id="fieldSetInfoBasicaAcompa" styleClass="fieldset">
              <h:panelGrid columns="4" border="0" cellpadding="0" cellspacing="0" width="100%"
                           id="panelRegionInfoAcompa" rowClasses="labelText,labelTextInfo">
                <h:outputText value="Otra Dirección" styleClass="labelTextOblig"/>
                <h:outputText value="Otro Telefono" styleClass="labelTextOblig"/>
                <h:outputText value="Departamento" styleClass="labelTextOblig"/>
                <h:outputText value="Municipio" styleClass="labelTextOblig"/>
                <h:panelGroup>
                  <h:inputText id="otraDireccion" required="true" onkeydown="return blockEnter(event);"
                               value="#{datosUsuarioCitologiaBean.citologia.ccicotrdir}"/>
                  <a4j:outputPanel ajaxRendered="true">
                    <t:message for="otraDireccion" styleClass="errorMessage"/>
                  </a4j:outputPanel>
                </h:panelGroup>
                <h:panelGroup>
                  <h:inputText id="otroTelefono" required="true" onkeydown="return blockEnter(event);"
                               value="#{datosUsuarioCitologiaBean.citologia.ccicotrtel}"/>
                  <a4j:outputPanel ajaxRendered="true">
                    <t:message for="otroTelefono" styleClass="errorMessage"/>
                  </a4j:outputPanel>
                </h:panelGroup>
                <h:panelGroup>
                  <h:selectOneMenu id="menuOtroDepartamentos"
                                   value="#{datosUsuarioCitologiaBean.departamentoOtroSelect}" required="true"
                                   immediate="true"
                                   valueChangeListener="#{datosUsuarioCitologiaBean.setDepartamentoOtroSelect}">
                    <f:selectItems value="#{datosUsuarioCitologiaBean.listOtrosDepartamentos}"/>
                    <a4j:support id="supportOtroDepartamento" oncomplete="jsFunctionOtroDepartamento()"
                                 action="#{datosUsuarioCitologiaBean.changeOtraCiudad}" reRender="panleDatosBasicos"
                                 event="onchange" immediate="true">
                      <a4j:ajaxListener type="org.ajax4jsf.ajax.ForceRender"/>
                    </a4j:support>
                  </h:selectOneMenu>
                  <a4j:outputPanel ajaxRendered="true">
                    <t:message for="menuOtroDepartamentos" styleClass="errorMessage"/>
                  </a4j:outputPanel>
                </h:panelGroup>
                <h:panelGroup>
                  <h:selectOneMenu id="menuOtraCiudad" required="true"
                                   value="#{datosUsuarioCitologiaBean.ciudadOtraSelect}">
                    <f:selectItems value="#{datosUsuarioCitologiaBean.listOtrosMunicipios}"/>
                  </h:selectOneMenu>
                  <a4j:outputPanel ajaxRendered="true">
                    <t:message for="menuOtraCiudad" styleClass="errorMessage"/>
                  </a4j:outputPanel>
                </h:panelGroup>
              </h:panelGrid>
              <h:outputText value=""/>
            </s:fieldset>
            <h:panelGrid columns="2" border="0" cellpadding="0" cellspacing="0" width="100%" id="panelBotonModificar"
                         columnClasses="panelGridBotones">
              <h:panelGroup>
                <h:commandButton value="Guardar" styleClass="boton_fieldset"
                                 action="#{datosUsuarioCitologiaBean.guardarUsuario}">
                  <a4j:support event="onclick" status="statusButton"/>
                </h:commandButton>
              </h:panelGroup>
            </h:panelGrid>
            <h:panelGrid>
              <h:panelGroup>
                <a4j:outputPanel id="ajaxRegionMessagesatributo1" ajaxRendered="true">
                  <t:messages id="msgInformationAndErrors1" showSummary="true" errorClass="error" globalOnly="true"
                              layout="table" infoClass="informacion"/>
                </a4j:outputPanel>
              </h:panelGroup>
            </h:panelGrid>
          </h:panelGrid>
        </t:panelTab>
      </t:panelTabbedPane>
    </h:panelGrid>
  </a4j:region>
  <script type="text/javascript">
    document.forms['body:formDatosUsuarioCitologia'].elements[4].focus(); 
  </script>
</a4j:form>