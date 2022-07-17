<%@ page contentType="text/html;charset=iso-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsf/html" prefix="h"%>
<%@ taglib uri="http://java.sun.com/jsf/core" prefix="f"%>
<%@ taglib uri="http://richfaces.org/a4j" prefix="a4j"%>
<%@ taglib uri="http://myfaces.apache.org/tomahawk" prefix="t"%>
<%@ taglib uri="http://myfaces.apache.org/sandbox" prefix="s"%>
<a4j:keepAlive beanName="datosUsuarioBean"/>
<a4j:form id="formDatosUsuario">
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
  

    <h:panelGrid columns="1" border="0" cellpadding="0" cellspacing="0" width="100%" id="panelGridDatosUsuarioTab" styleClass="tabContainer">
      <t:panelTabbedPane border="0" cellpadding="0" cellspacing="0" serverSideTabSwitch="false" activePanelTabVar="true" width="100%" id="panelTabbedPaneDatosUsuario" styleClass="tabbedPane"
                         activeTabStyleClass="activeTab" inactiveTabStyleClass="inactiveTab" disabledTabStyleClass="disabledTab" activeSubStyleClass="activeSub" inactiveSubStyleClass="inactiveSub"
                         tabContentStyleClass="tabContent">
        <t:panelTab id="panelTabDatosUsuario" label="Datos Usuario">
          <h:panelGrid id="panleDatosBasicos" columns="1" border="0" cellpadding="0" cellspacing="0" width="100%" styleClass="tabContainer">
            <s:fieldset legend="Datos Basicos" id="fieldSetInfoBasica" styleClass="fieldset">
              <h:panelGrid columns="3" border="0" cellpadding="0" cellspacing="0" width="100%" id="panelRegionInfoConsulta" rowClasses="labelText,labelTextInfo">
                <h:outputText value="Tipo Identificación" styleClass="labelTextOblig"/>
                <h:outputText value=" Numero Identificación" styleClass="labelTextOblig"/>
                <h:outputText value="Número Usuario" styleClass="labelTextOblig"/>
                <h:panelGroup>
                  <h:selectOneMenu id="tipoIde" required="true" disabled="true" value="#{datosUsuarioBean.usuario.husetipoiden}">
                    <f:selectItems value="#{datosUsuarioBean.listTipoIdentificacion}"/>
                  </h:selectOneMenu>
                  <a4j:outputPanel ajaxRendered="true">
                    <t:message for="tipoIde" styleClass="errorMessage"/>
                  </a4j:outputPanel>
                </h:panelGroup>
                <h:panelGroup>
                  <h:inputText id="idtipo" 
                    disabled="true" value="#{datosUsuarioBean.usuario.husanumeiden}"
                  required="true">
                    </h:inputText>
                  <a4j:outputPanel ajaxRendered="true">
                    <t:message for="idtipo" styleClass="errorMessage"/>
                  </a4j:outputPanel>
                </h:panelGroup>
                <h:panelGroup>
                  <h:inputText id="itNumeroUsuario" disabled="true" value="#{datosUsuarioBean.usuario.huslnumero}"/>
                </h:panelGroup>
              </h:panelGrid>
              <h:panelGrid columns="4" border="0" cellpadding="0" cellspacing="0" width="100%" id="panelDatosNombre" rowClasses="labelText,labelTextInfo">
                <h:outputText value="Primer Nombre" styleClass="labelTextOblig"/>
                <h:outputText value="Segundo Nombre" styleClass="labelTextOblig"/>
                <h:outputText value="Primer Apellido" styleClass="labelTextOblig"/>
                <h:outputText value="Segundo Apellido" styleClass="labelTextOblig"/>
                <h:panelGroup>
                  <h:inputText id="primerNombre" styleClass="textmayuscula"
                  onkeydown="return blockEnter(event);" required="true"  value="#{datosUsuarioBean.usuario.huscprimernomb}">
                   <f:converter converterId="cadena.stringUpperCaseConverter"/>
                </h:inputText>
                  <a4j:outputPanel ajaxRendered="true">
                    <t:message for="primerNombre" styleClass="errorMessage"/>
                  </a4j:outputPanel>
                </h:panelGroup>
                <h:panelGroup>
                  <h:inputText id="segundoNombre" styleClass="textmayuscula"
                    onkeydown="return blockEnter(event);"  value="#{datosUsuarioBean.usuario.huscsegundnomb}">
                   <f:converter converterId="cadena.stringUpperCaseConverter"/>
                </h:inputText>
                  <a4j:outputPanel ajaxRendered="true">
                    <t:message for="segundoNombre" styleClass="errorMessage"/>
                  </a4j:outputPanel>
                </h:panelGroup>
                <h:panelGroup>
                  <h:inputText id="primerApellido" onkeydown="return blockEnter(event);" required="true" value="#{datosUsuarioBean.usuario.huscprimerapel}"/>
                  <a4j:outputPanel ajaxRendered="true">
                    <t:message for="primerApellido" styleClass="errorMessage"/>
                  </a4j:outputPanel>
                </h:panelGroup>
                <h:panelGroup>
                  <h:inputText id="segundoApellido" onkeydown="return blockEnter(event);" value="#{datosUsuarioBean.usuario.huscsegundapel}"/>
                  <a4j:outputPanel ajaxRendered="true">
                    <t:message for="segundoApellido" styleClass="errorMessage"/>
                  </a4j:outputPanel>
                </h:panelGroup>
                <h:outputText value="Fecha Nacimiento" styleClass="labelTextOblig"/>
                <h:outputText value="Edad" styleClass="labelTextOblig"/>
                <h:outputText value="Sexo" styleClass="labelTextOblig"/>
                <h:outputText value="Estado Civil" styleClass="labelTextOblig"/>
                <h:panelGroup>
                  <t:inputCalendar id="fechaNacimiento" onkeydown="return blockEnter(event);" monthYearRowClass="yearMonthHeader" weekRowClass="weekHeader" immediate="true" title="Formato: dd/mm/yyyy"
                                   currentDayCellClass="currentDayCell" popupDateFormat="dd/MM/yyyy" renderAsPopup="true" value="#{datosUsuarioBean.fechaNacimiento}"
                                   valueChangeListener="#{datosUsuarioBean.setFechaNacimiento}" popupTodayString="Hoy" popupWeekString="Semana" popupButtonString="Fecha" readonly="false"
                                   maxlength="11" size="11" popupButtonImageUrl="/comun/imagenes/ico_calendario2.gif" renderPopupButtonAsImage="true" align="top" required="true">
                    <a4j:support id="supportNacimiento" event="onchange" immediate="true" action="#{datosUsuarioBean.changeEdad}" reRender="panleDatosBasicos">
                      <a4j:ajaxListener type="org.ajax4jsf.ajax.ForceRender"/>
                    </a4j:support>
                  </t:inputCalendar>
                  <a4j:outputPanel ajaxRendered="true">
                    <t:message for="fechaNacimiento" styleClass="errorMessage"/>
                  </a4j:outputPanel>
                </h:panelGroup>
                <h:panelGroup>
                  <h:inputText id="inputEdad" disabled="true" value="#{datosUsuarioBean.edad}"/>
                </h:panelGroup>
                <h:panelGroup>
                  <h:selectOneMenu id="radioSexo" required="true" value="#{datosUsuarioBean.usuario.husesexo}">
                    <f:selectItems value="#{datosUsuarioBean.listSexos}"/>
                  </h:selectOneMenu>
                  <a4j:outputPanel ajaxRendered="true">
                    <t:message for="radioSexo" styleClass="errorMessage"/>
                  </a4j:outputPanel>
                </h:panelGroup>
                <h:panelGroup>
                  <h:selectOneMenu id="radioEstadoCivil" required="true" value="#{datosUsuarioBean.usuario.huseestadcivil}">
                    <f:selectItems value="#{datosUsuarioBean.listEstadoCivil}"/>
                  </h:selectOneMenu>
                  <a4j:outputPanel ajaxRendered="true">
                    <t:message for="radioEstadoCivil" styleClass="errorMessage"/>
                  </a4j:outputPanel>
                </h:panelGroup>
              </h:panelGrid>
              <h:panelGrid columns="4" border="0" cellpadding="0" cellspacing="0" width="100%" id="panelDatosPersonales" rowClasses="labelText,labelTextInfo">
                <h:outputText value="Correo Electronico"/>
                <h:outputText value="País de residencia habitual" styleClass="labelTextOblig"/>
                <h:outputText value="Departamento" styleClass="labelTextOblig"/>
                <h:outputText value="Municipio" styleClass="labelTextOblig"/>
                <h:inputText id="itCorreo" onkeydown="return blockEnter(event);" value="#{datosUsuarioBean.usuario.husccorreoelec}"/>
                <h:selectOneMenu id="menuPais" onkeydown="return blockEnter(event);"
                       value="#{datosUsuarioBean.usuario.huscpaisresi}">
                    <f:selectItems value="#{datosUsuarioBean.listPaises}"/>
                </h:selectOneMenu>
                <a4j:outputPanel ajaxRendered="true">
                    <t:message for="menuPais" styleClass="errorMessage"/>
                </a4j:outputPanel>

                <h:panelGroup>
                  <h:selectOneMenu id="menuDepartamentos" value="#{datosUsuarioBean.departamentoSelect}" immediate="true" valueChangeListener="#{datosUsuarioBean.setDepartamentoSelect}">
                    <f:selectItems value="#{datosUsuarioBean.listDepartamentos}"/>
                    <a4j:support id="support7" action="#{datosUsuarioBean.changeCiudad}" reRender="panleDatosBasicos" event="onchange" immediate="true">
                      <a4j:ajaxListener type="org.ajax4jsf.ajax.ForceRender"/>
                    </a4j:support>
                  </h:selectOneMenu>
                  <a4j:outputPanel ajaxRendered="true">
                    <t:message for="menuDepartamentos" styleClass="errorMessage"/>
                  </a4j:outputPanel>
                </h:panelGroup>
                <h:panelGroup>
                  <h:selectOneMenu id="menuCiudad" required="true" value="#{datosUsuarioBean.ciudadSelect}">
                    <f:selectItems value="#{datosUsuarioBean.listMunicipios}"/>
                  </h:selectOneMenu>
                  <a4j:outputPanel ajaxRendered="true">
                    <t:message for="menuCiudad" styleClass="errorMessage"/>
                  </a4j:outputPanel>
                </h:panelGroup>
                <h:outputText value="Zona" styleClass="labelTextOblig"/>
                <h:outputText value="Barrio " styleClass="labelTextOblig"/>
                <h:outputText value="Direccion" styleClass="labelTextOblig"/>
                <h:outputText value="Telefono" styleClass="labelTextOblig"/>
                <h:panelGroup>
                  <h:selectOneMenu id="radioZona" required="true" value="#{datosUsuarioBean.usuario.husezonareside}">
                    <f:selectItems value="#{datosUsuarioBean.listzona}"/>
                  </h:selectOneMenu>
                  <a4j:outputPanel ajaxRendered="true">
                    <t:message for="radioZona" styleClass="errorMessage"/>
                  </a4j:outputPanel>
                </h:panelGroup>
                <h:panelGroup>
                  <h:inputText id="itBarrio" onkeydown="return blockEnter(event);" required="true" value="#{datosUsuarioBean.usuario.huscbarrio}"/>
                  <a4j:outputPanel ajaxRendered="true">
                    <t:message for="itBarrio" styleClass="errorMessage"/>
                  </a4j:outputPanel>
                </h:panelGroup>
                <h:panelGroup>
                  <h:inputText id="Direccion" onkeydown="return blockEnter(event);" required="true" value="#{datosUsuarioBean.usuario.huscdireccion}"/>
                  <a4j:outputPanel ajaxRendered="true">
                    <t:message for="Direccion" styleClass="errorMessage"/>
                  </a4j:outputPanel>
                </h:panelGroup>
                <h:panelGroup>
                  <h:inputText id="Telefono" onkeydown="return blockEnter(event);" required="true" value="#{datosUsuarioBean.usuario.husctelefono}"/>
                  <a4j:outputPanel ajaxRendered="true">
                    <t:message for="Direccion" styleClass="errorMessage"/>
                  </a4j:outputPanel>
                </h:panelGroup>
              </h:panelGrid>
              <h:panelGrid columns="2" border="0" cellpadding="0" cellspacing="0" width="100%" id="panelDatosPersonalesLaboral" rowClasses="labelText,labelTextInfo">
                <h:outputText value="Ocupacion" styleClass="labelTextOblig"/>
                <h:outputText value="Tipo de Afiliacion" styleClass="labelTextOblig"/>
                <h:panelGroup>
                  <h:selectOneMenu id="menuOcupacion" required="true" value="#{datosUsuarioBean.ocupacionSelect}">
                    <f:selectItems value="#{datosUsuarioBean.listOcupaciones}"/>
                  </h:selectOneMenu>
                  <a4j:outputPanel ajaxRendered="true">
                    <t:message for="menuOcupacion" styleClass="errorMessage"/>
                  </a4j:outputPanel>
                </h:panelGroup>
                <h:panelGroup>
                  <h:selectOneMenu id="menuAfiliacion" required="true" value="#{datosUsuarioBean.afiliacion}">
                    <f:selectItems value="#{datosUsuarioBean.listTipoAfiliacion}"/>
                  </h:selectOneMenu>
                  <a4j:outputPanel ajaxRendered="true">
                    <t:message for="menuAfiliacion" styleClass="errorMessage"/>
                  </a4j:outputPanel>
                </h:panelGroup>
                <h:outputText value="EPS" styleClass="labelTextOblig"/>
                <h:outputText value=" "/>
                <h:panelGroup>
                  <h:selectOneMenu id="menuEps" required="true" value="#{datosUsuarioBean.usuario.huscentidadadm}">
                    <f:selectItems value="#{datosUsuarioBean.listEntidadAdm}"/>
                  </h:selectOneMenu>
                  <a4j:outputPanel ajaxRendered="true">
                    <t:message for="menuEps" styleClass="errorMessage"/>
                  </a4j:outputPanel>
                </h:panelGroup>
              </h:panelGrid>
            </s:fieldset>
            <s:fieldset legend="Datos Acompañante" id="fieldSetInfoBasicaAcompa" styleClass="fieldset">
              <h:panelGrid columns="3" border="0" cellpadding="0" cellspacing="0" width="100%" id="panelRegionInfoAcompa" rowClasses="labelText,labelTextInfo">
                <h:outputText value="Acompañante" styleClass="labelTextOblig"/>
                <h:outputText value="Telefono Acompañante"/>
                <h:outputText value=""/>
                <h:panelGroup>
                  <h:inputText id="itAcom" onkeydown="return blockEnter(event);" required="true" value="#{datosUsuarioBean.usuario.huscnomacompana}"/>
                  <a4j:outputPanel ajaxRendered="true">
                    <t:message for="itAcom" styleClass="errorMessage"/>
                  </a4j:outputPanel>
                </h:panelGroup>
                <h:inputText onkeydown="return blockEnter(event);" value="#{datosUsuarioBean.usuario.husctelacompana}"/>
                <h:outputText/>
                <h:outputText value="Responsable" styleClass="labelTextOblig"/>
                <h:outputText value="Parentesco" styleClass="labelTextOblig"/>
                <h:outputText value="Telefono Responsable"/>
                <h:panelGroup>
                  <h:inputText id="itRespon" onkeydown="return blockEnter(event);" required="true" value="#{datosUsuarioBean.usuario.huscnomresponsa}"/>
                  <a4j:outputPanel ajaxRendered="true">
                    <t:message for="itRespon" styleClass="errorMessage"/>
                  </a4j:outputPanel>
                </h:panelGroup>
                <h:panelGroup>
                  <h:inputText id="itParen" onkeydown="return blockEnter(event);" required="true" value="#{datosUsuarioBean.usuario.huscparresponsa}"/>
                  <a4j:outputPanel ajaxRendered="true">
                    <t:message for="itParen" styleClass="errorMessage"/>
                  </a4j:outputPanel>
                </h:panelGroup>
                <h:inputText onkeydown="return blockEnter(event);" value="#{datosUsuarioBean.usuario.husctelresponsa}"/>
              </h:panelGrid>
              <h:outputText value=""/>
            </s:fieldset>
            <h:panelGrid columns="2" border="0" cellpadding="0" cellspacing="0" width="100%" id="panelBotonModificar" columnClasses="panelGridBotones">
              <h:panelGroup>
                <h:commandButton value="Guardar" styleClass="boton_fieldset" action="#{datosUsuarioBean.guardarUsuario}">
                  <a4j:support event="onclick" status="statusButton"/>
                </h:commandButton>
              </h:panelGroup>
            </h:panelGrid>
            <h:panelGrid>
              <h:panelGroup>
                <a4j:outputPanel id="ajaxRegionMessagesatributo1" ajaxRendered="true">
                  <t:messages id="msgInformationAndErrors1" showSummary="true" errorClass="error" globalOnly="true" layout="table" infoClass="informacion"/>
                </a4j:outputPanel>
              </h:panelGroup>
            </h:panelGrid>
          </h:panelGrid>
        </t:panelTab>
      </t:panelTabbedPane>
    </h:panelGrid>
  </a4j:region>
</a4j:form>