<%@ page contentType="text/html;charset=iso-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsf/html" prefix="h"%>
<%@ taglib uri="http://java.sun.com/jsf/core" prefix="f"%>
<%@ taglib uri="http://richfaces.org/a4j" prefix="a4j"%>
<%@ taglib uri="http://myfaces.apache.org/tomahawk" prefix="t"%>
<%@ taglib uri="http://myfaces.apache.org/sandbox" prefix="s"%>
<h:panelGrid columns="1" border="0" cellpadding="0" cellspacing="0" width="100%" id="panelGridDatosUsuarioTab" styleClass="tabContainer">
  <t:panelTabbedPane border="0" cellpadding="0" cellspacing="0" serverSideTabSwitch="false" activePanelTabVar="true" width="100%" id="panelTabbedPaneDatosUsuario" styleClass="tabbedPane"
                     activeTabStyleClass="activeTab" inactiveTabStyleClass="inactiveTab" disabledTabStyleClass="disabledTab" activeSubStyleClass="activeSub" inactiveSubStyleClass="inactiveSub"
                     tabContentStyleClass="tabContent">
    <t:panelTab id="panelTabDatosUsuario" label="Datos Usuario">
      <s:fieldset legend="Datos Basicos Usuario(a)" id="fieldSetInfoBasica" styleClass="fieldset">
        <h:panelGrid columns="8" border="0" cellpadding="0" cellspacing="0" width="100%" id="panelRegionInfoConsulta" rowClasses="labelText,labelTextInfo">
          <h:outputText value="Tipo Identificación" styleClass="labelTextOblig"/>
          <h:outputText value=""/>
          <h:outputText value=" Número Identificación" styleClass="labelTextOblig"/>
          <h:outputText value=""/>
          <h:outputText value="Número Usuario" styleClass="labelTextOblig"/>
          <h:outputText value=""/>
          <h:outputText value=""/>
          <h:outputText value=""/>
          <h:selectOneMenu id="tipoIde" required="true"  value="#{modificarDatosUsuarioBean.usuario.husetipoiden}"
          onkeydown="return blockEnter(event);">
            <f:selectItems value="#{modificarDatosUsuarioBean.listTipoIdentificacion}"/>
          </h:selectOneMenu>
          <h:outputText value=""/>
          <h:inputText id="idtipo" maxlength="15"
                value="#{modificarDatosUsuarioBean.usuario.husanumeiden}" 
              required="true" onkeydown="return blockEnter(event);">
          </h:inputText>
          <h:outputText value=""/>
          <h:inputText id="itNumeroUsuario" 
              disabled="true" maxlength="12"
                value="#{modificarDatosUsuarioBean.usuario.huslnumero}" onkeydown="return blockEnter(event);"/>
          <h:outputText value=""/>
          <h:outputText value=""/>
          <h:outputText value=""/>
          <h:outputText value="Primer Nombre" styleClass="labelTextOblig"/>
          <h:outputText value=""/>
          <h:outputText value="Segundo Nombre"/>
          <h:outputText value=""/>
          <h:outputText value="Primer Apellido" styleClass="labelTextOblig"/>
          <h:outputText value=""/>
          <h:outputText value="Segundo Apellido"/>
          <h:outputText value=""/>
          <h:inputText id="primerNombre" onkeydown="return blockEnter(event);"  maxlength="20"
              required="true"  value="#{modificarDatosUsuarioBean.usuario.huscprimernomb}">
            </h:inputText>
          <a4j:outputPanel ajaxRendered="true">
            <t:message for="primerNombre" styleClass="errorMessage"/>
          </a4j:outputPanel>
          <h:inputText id="segundoNombre" onkeydown="return blockEnter(event);"  value="#{modificarDatosUsuarioBean.usuario.huscsegundnomb}"
                maxlength="20">
           </h:inputText>
          <a4j:outputPanel ajaxRendered="true">
            <t:message for="segundoNombre" styleClass="errorMessage"/>
          </a4j:outputPanel>
          <h:inputText id="primerApellido" onkeydown="return blockEnter(event);" maxlength="20" required="true" value="#{modificarDatosUsuarioBean.usuario.huscprimerapel}">
           </h:inputText>
          <a4j:outputPanel ajaxRendered="true">
            <t:message for="primerApellido" styleClass="errorMessage"/>
          </a4j:outputPanel>
          <h:inputText id="segundoApellido" onkeydown="return blockEnter(event);" maxlength="20"  value="#{modificarDatosUsuarioBean.usuario.huscsegundapel}">
           </h:inputText>
          <a4j:outputPanel ajaxRendered="true">
            <t:message for="segundoApellido" styleClass="errorMessage"/>
          </a4j:outputPanel>
          <h:outputText value="Estado Civil" styleClass="labelTextOblig"/>
          <h:outputText value=""/>
          <h:outputText value="Sexo" styleClass="labelTextOblig"/>
          <h:outputText value=""/>
          <h:outputText value="Fecha Nacimiento" styleClass="labelTextOblig"/>
          <h:outputText value=""/>
          <h:outputText value="Edad" styleClass="labelTextOblig"/>
          <h:outputText value=""/>
          <h:selectOneMenu id="radioEstadoCivil" onkeydown="return blockEnter(event);" required="true" value="#{modificarDatosUsuarioBean.usuario.huseestadcivil}">
            <f:selectItems value="#{modificarDatosUsuarioBean.listEstadoCivil}"/>
          </h:selectOneMenu>
          <a4j:outputPanel ajaxRendered="true">
            <t:message for="radioEstadoCivil" styleClass="errorMessage"/>
          </a4j:outputPanel>
          <h:selectOneMenu id="radioSexo" onkeydown="return blockEnter(event);" required="true" value="#{modificarDatosUsuarioBean.usuario.husesexo}">
            <f:selectItems value="#{modificarDatosUsuarioBean.listSexos}"/>
          </h:selectOneMenu>
          <a4j:outputPanel ajaxRendered="true">
            <t:message for="radioSexo" styleClass="errorMessage"/>
          </a4j:outputPanel>
          <t:inputCalendar id="fechaNacimiento" onkeydown="return blockEnter(event);" monthYearRowClass="yearMonthHeader" weekRowClass="weekHeader" immediate="true" title="Formato: dd/mm/yyyy"
                           currentDayCellClass="currentDayCell" popupDateFormat="dd/MM/yyyy" renderAsPopup="true" value="#{modificarDatosUsuarioBean.usuario.husdfechanacim}"
                           valueChangeListener="#{modificarDatosUsuarioBean.usuario.setHusdfechanacim}" popupTodayString="Hoy" popupWeekString="Semana" popupButtonString="Fecha" readonly="false"
                           maxlength="11" size="11" popupButtonImageUrl="/comun/imagenes/ico_calendario2.gif" renderPopupButtonAsImage="true" align="top" required="true">
            <f:validator validatorId="dateMenorActualValidator"/>
            <a4j:support id="supportNacimiento" event="onchange" immediate="true" reRender="panelRegionInfoConsulta">
              <a4j:ajaxListener type="org.ajax4jsf.ajax.ForceRender"/>
            </a4j:support>
          </t:inputCalendar>
          <a4j:outputPanel ajaxRendered="true">
            <t:message for="fechaNacimiento" styleClass="errorMessage"/>
          </a4j:outputPanel>
          <h:inputText id="inputEdad" onkeydown="return blockEnter(event);" maxlength="4" disabled="true" value="#{modificarDatosUsuarioBean.usuario.edad}"/>
          <h:outputText value=""/>
          <h:outputText value="País de residencia habitual" styleClass="labelTextOblig"/>
          <h:outputText value=""/>
          <h:outputText value="Departamento" styleClass="labelTextOblig"/>
          <h:outputText value=""/>
          <h:outputText value="Municipio" styleClass="labelTextOblig"/>
          <h:outputText value=""/>
          <h:outputText value="Zona" styleClass="labelTextOblig"/>
          <h:outputText value=""/>

          <h:selectOneMenu id="menuPais" required="true" onkeydown="return blockEnter(event);" value="#{modificarDatosUsuarioBean.usuario.huscpaisresi}" >
               <f:selectItems value="#{modificarDatosUsuarioBean.listPaises}"/>
          </h:selectOneMenu>
          <a4j:outputPanel ajaxRendered="true">
                <t:message for="menuPais" styleClass="errorMessage"/>
          </a4j:outputPanel>

          <h:selectOneMenu id="menuDepartamentos" onkeydown="return blockEnter(event);" value="#{modificarDatosUsuarioBean.departamentoSelect}" immediate="true" valueChangeListener="#{modificarDatosUsuarioBean.setDepartamentoSelect}">
            <f:selectItems value="#{modificarDatosUsuarioBean.listDepartamentos}"/>
            <a4j:support id="support7" action="#{modificarDatosUsuarioBean.changeCiudad}" reRender="panelRegionInfoConsulta" event="onchange" immediate="true">
              <a4j:ajaxListener type="org.ajax4jsf.ajax.ForceRender"/>
            </a4j:support>
          </h:selectOneMenu>
          <a4j:outputPanel ajaxRendered="true">
            <t:message for="menuDepartamentos" styleClass="errorMessage"/>
          </a4j:outputPanel>
          <h:selectOneMenu id="menuCiudad" required="true"  onkeydown="return blockEnter(event);" value="#{modificarDatosUsuarioBean.ciudadSelect}">
            <f:selectItems value="#{modificarDatosUsuarioBean.listMunicipios}"/>
          </h:selectOneMenu>
          <a4j:outputPanel ajaxRendered="true">
            <t:message for="menuCiudad" styleClass="errorMessage"/>
          </a4j:outputPanel>
          <h:selectOneMenu id="radioZona" onkeydown="return blockEnter(event);" required="true" value="#{modificarDatosUsuarioBean.usuario.husezonareside}">
            <f:selectItems value="#{modificarDatosUsuarioBean.listzona}"/>
          </h:selectOneMenu>
          <a4j:outputPanel ajaxRendered="true">
            <t:message for="radioZona" styleClass="errorMessage"/>
          </a4j:outputPanel>
          <h:outputText value="Barrio " styleClass="labelTextOblig"/>
          <h:outputText value=""/>
          <h:outputText value="Dirección" styleClass="labelTextOblig"/>
          <h:outputText value=""/>
          <h:outputText value="Teléfono" styleClass="labelTextOblig"/>
          <h:outputText value=""/>
          <h:outputText value="Correo Electrónico"/>
          <h:outputText value=""/>
          <h:inputText id="itBarrio" onkeydown="return blockEnter(event);" maxlength="20"
                required="true" value="#{modificarDatosUsuarioBean.usuario.huscbarrio}">
          </h:inputText>
          <a4j:outputPanel ajaxRendered="true">
            <t:message for="itBarrio" styleClass="errorMessage"/>
          </a4j:outputPanel>
          <h:inputText id="Direccion" maxlength="20"
              onkeydown="return blockEnter(event);" required="true" value="#{modificarDatosUsuarioBean.usuario.huscdireccion}">
          </h:inputText>
          <a4j:outputPanel ajaxRendered="true">
            <t:message for="Direccion" styleClass="errorMessage"/>
          </a4j:outputPanel>
          <h:inputText id="Telefono"  maxlength="20"
              onkeydown="return blockEnter(event);" required="true" value="#{modificarDatosUsuarioBean.usuario.husctelefono}"/>
          <a4j:outputPanel ajaxRendered="true">
            <t:message for="Direccion" styleClass="errorMessage"/>
          </a4j:outputPanel>
          <h:inputText id="itCorreo" maxlength="30"
            onkeydown="return blockEnter(event);" value="#{modificarDatosUsuarioBean.usuario.husccorreoelec}"/>
          <h:outputText value=""/>
          <h:outputText value="Tipo de Afiliación" styleClass="labelTextOblig"/>
          <h:outputText value=" "/>
          <h:outputText value="EPS" styleClass="labelTextOblig"/>
          <h:outputText value=" "/>
          <h:outputText value=" "/>
          <h:outputText value=" "/>
          <h:outputText value=" "/>
          <h:outputText value=" "/>
          <h:selectOneMenu id="menuAfiliacion" onkeydown="return blockEnter(event);" required="true" value="#{modificarDatosUsuarioBean.afiliacion}">
            <f:selectItems value="#{modificarDatosUsuarioBean.listTipoAfiliacion}"/>
          </h:selectOneMenu>
          <a4j:outputPanel ajaxRendered="true">
            <t:message for="menuAfiliacion" styleClass="errorMessage"/>
          </a4j:outputPanel>
          <h:selectOneMenu id="menuEps" onkeydown="return blockEnter(event);" required="true" value="#{modificarDatosUsuarioBean.usuario.huscentidadadm}">
            <f:selectItems value="#{modificarDatosUsuarioBean.listEntidadAdm}"/>
          </h:selectOneMenu>
          <a4j:outputPanel ajaxRendered="true">
            <t:message for="menuEps" styleClass="errorMessage"/>
          </a4j:outputPanel>
          <h:outputText value=" "/>
          <h:outputText value=" "/>
          <h:outputText value=" "/>
          <h:outputText value=" "/>
        </h:panelGrid>
        <h:panelGrid columns="2" border="0" cellpadding="0" cellspacing="0" width="100%" id="panelDatosPersonalesLaboral" rowClasses="labelText,labelTextInfo">
          <h:outputText value="Ocupación" styleClass="labelTextOblig"/>
          <h:outputText value=" "/>
          <h:selectOneMenu id="menuOcupacion" required="true" value="#{modificarDatosUsuarioBean.ocupacionSelect}" onkeydown="return blockEnter(event);">
            <f:selectItems value="#{modificarDatosUsuarioBean.listOcupaciones}"/>
          </h:selectOneMenu>
          <a4j:outputPanel ajaxRendered="true">
            <t:message for="menuOcupacion" styleClass="errorMessage"/>
          </a4j:outputPanel>
        </h:panelGrid>
      </s:fieldset>
      <s:fieldset legend="Datos Acompañante" id="fieldSetInfoBasicaAcompa" styleClass="fieldset">
        <h:panelGrid columns="3" border="0" cellpadding="0" cellspacing="0" width="100%" id="panelRegionInfoAcompa" rowClasses="labelText,labelTextInfo">
          <h:outputText value="Acompañante"/>
          <h:outputText value="Teléfono Acompañante"/>
          <h:outputText value=""/>
          <h:panelGroup>
            <h:inputText id="itAcom"  maxlength="40"
                onkeydown="return blockEnter(event);" required="true" value="#{modificarDatosUsuarioBean.usuario.huscnomacompana}">
            </h:inputText>
            <a4j:outputPanel ajaxRendered="true">
              <t:message for="itAcom" styleClass="errorMessage"/>
            </a4j:outputPanel>
          </h:panelGroup>
          <h:inputText onkeydown="return blockEnter(event);" maxlength="20" value="#{modificarDatosUsuarioBean.usuario.husctelacompana}"/>
          <h:outputText/>
          <h:outputText value="Responsable"/>
          <h:outputText value="Parentesco"/>
          <h:outputText value="Teléfono Responsable"/>
          <h:panelGroup>
            <h:inputText id="itRespon"  maxlength="40"
                onkeydown="return blockEnter(event);" required="true" value="#{modificarDatosUsuarioBean.usuario.huscnomresponsa}">
            </h:inputText>
            <a4j:outputPanel ajaxRendered="true">
              <t:message for="itRespon" styleClass="errorMessage"/>
            </a4j:outputPanel>
          </h:panelGroup>
          <h:panelGroup>
            <h:inputText id="itParen" maxlength="15"
                onkeydown="return blockEnter(event);" required="true" value="#{modificarDatosUsuarioBean.usuario.huscparresponsa}">
            </h:inputText>
            <a4j:outputPanel ajaxRendered="true">
              <t:message for="itParen" styleClass="errorMessage"/>
            </a4j:outputPanel>
          </h:panelGroup>
          <h:inputText onkeydown="return blockEnter(event);" maxlength="20"
          value="#{modificarDatosUsuarioBean.usuario.husctelresponsa}"/>
        </h:panelGrid>
        <h:outputText value=""/>
      </s:fieldset>
      <h:panelGroup>
        <a4j:outputPanel id="ajaxRegionMessagesatributo1" ajaxRendered="true">
          <t:htmlTag value="br"/>
          <t:messages id="msgInformationAndErrors" showSummary="false" errorClass="error" globalOnly="true" layout="table" infoClass="informacion" showDetail="true" tooltip="true"
                      warnClass="advertencia"/>
          <t:htmlTag value="br"/>
        </a4j:outputPanel>
      </h:panelGroup>
      <h:panelGrid columns="1" border="0" cellpadding="0" cellspacing="0" width="100%" id="panelBotonModificar" columnClasses="panelGridBotones">
        <h:panelGroup>
          <h:commandButton value="Guardar" styleClass="boton_fieldset" action="#{modificarDatosUsuarioBean.guardarUsuario}">
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