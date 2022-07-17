<%@ page contentType="text/html;charset=iso-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsf/html" prefix="h"%>
<%@ taglib uri="http://java.sun.com/jsf/core" prefix="f"%>
<%@ taglib uri="http://richfaces.org/a4j" prefix="a4j"%>
<%@ taglib uri="http://myfaces.apache.org/tomahawk" prefix="t"%>
<%@ taglib uri="http://myfaces.apache.org/sandbox" prefix="s"%>
<h:panelGrid columns="1" border="0" cellpadding="0" cellspacing="0" width="920px"
             id="panelGridRegistrarUsuarioAsesoriaTab" styleClass="tabContainer">
  <t:panelTabbedPane border="0" cellpadding="0" cellspacing="0" serverSideTabSwitch="false" activePanelTabVar="true"
                     width="100%" id="panelTabbedPaneDatosUsuario" styleClass="tabbedPane"
                     activeTabStyleClass="activeTab" inactiveTabStyleClass="inactiveTab"
                     disabledTabStyleClass="disabledTab" activeSubStyleClass="activeSub"
                     selectedIndex="#{registrarUsuarioAsesoriaBean.selectedIndex}" inactiveSubStyleClass="inactiveSub"
                     tabContentStyleClass="tabContent">
    <t:panelTab id="panelTabDatosUsuario" label="Datos Usuaria"
                rendered="#{!registrarUsuarioAsesoriaBean.renderSeguimiento && !registrarUsuarioAsesoriaBean.renderSelecionarUsuario}">
      <a4j:commandLink action="#{registrarUsuarioAsesoriaBean.resetDatos}"
                       reRender="panelGridRegistrarUsuarioAsesoriaTab"  title="Registrar Nuevo Usuario">
        <t:graphicImage alt="Registrar Nuevo Usuario" title="Registrar Nuevo Usuaria" border="0"
                        url="/comun/imagenes/nuevo.jpg"/>
      </a4j:commandLink>
      <s:fieldset legend="Datos Basicos Usuaria" id="fieldSetInfoBasica" styleClass="fieldset">
        <h:panelGrid columns="8" border="0" cellpadding="0" cellspacing="0" width="100%" id="panelRegionInfoConsulta"
                     rowClasses="labelText,labelTextInfo">
          <h:outputText value="Tipo Identificación" styleClass="labelTextOblig"/>
          <h:outputText value=""/>
          <h:outputText value=" Número Identificación" styleClass="labelTextOblig"/>
          <h:outputText value=""/>
          <h:outputText value="Número Usuaria" styleClass="labelTextOblig"/>
          <h:outputText value=""/>
          <h:outputText value=""/>
          <h:outputText value=""/>
          <h:selectOneMenu id="tipoIde" 
                           disabled="#{registrarUsuarioAsesoriaBean.renderUsuario || registrarUsuarioAsesoriaBean.renderRegistrar}"
                           value="#{registrarUsuarioAsesoriaBean.usuario.husetipoiden}"
                           onkeydown="return blockEnter(event);">
            <f:selectItems value="#{registrarUsuarioAsesoriaBean.listTipoIdentificacion}"/>
          </h:selectOneMenu>
          <a4j:outputPanel ajaxRendered="true">
            <t:message for="tipoIde" styleClass="errorMessage"/>
          </a4j:outputPanel>
          <h:panelGrid columns="2" border="0" cellpadding="0" cellspacing="0">
            <a4j:commandButton value="Buscar"
                               disabled="#{registrarUsuarioAsesoriaBean.renderUsuario || registrarUsuarioAsesoriaBean.renderRegistrar}"
                               action="#{registrarUsuarioAsesoriaBean.buscadorUsuario}"
                               reRender="panelGridRegistrarUsuarioAsesoriaTab" image="/comun/imagenes/lupa.gif"/>
            <h:inputText id="itNumeroIdentificacion" maxlength="15" 
                         disabled="#{registrarUsuarioAsesoriaBean.renderUsuario || registrarUsuarioAsesoriaBean.renderRegistrar}"
                         value="#{registrarUsuarioAsesoriaBean.usuario.husanumeiden}"
                         onkeydown="return blockEnter(event);"/>
          </h:panelGrid>
          <a4j:outputPanel ajaxRendered="true">
            <t:message for="itNumeroIdentificacion" styleClass="errorMessage"/>
          </a4j:outputPanel>
          <h:inputText id="idtipo" maxlength="12" disabled="true"
                       value="#{registrarUsuarioAsesoriaBean.usuario.huslnumero}" 
                       onkeydown="return blockEnter(event);"></h:inputText>
          <a4j:outputPanel ajaxRendered="true">
            <t:message for="idtipo" styleClass="errorMessage"/>
          </a4j:outputPanel>
          <h:outputText/>
          <h:outputText/>
          <h:outputText value="Primer Nombre" styleClass="labelTextOblig"
                        rendered="#{registrarUsuarioAsesoriaBean.renderUsuario || registrarUsuarioAsesoriaBean.renderRegistrar}"/>
          <h:outputText value=""
                        rendered="#{registrarUsuarioAsesoriaBean.renderUsuario || registrarUsuarioAsesoriaBean.renderRegistrar}"/>
          <h:outputText value="Segundo Nombre"
                        rendered="#{registrarUsuarioAsesoriaBean.renderUsuario || registrarUsuarioAsesoriaBean.renderRegistrar}"/>
          <h:outputText value=""
                        rendered="#{registrarUsuarioAsesoriaBean.renderUsuario || registrarUsuarioAsesoriaBean.renderRegistrar}"/>
          <h:outputText value="Primer Apellido" styleClass="labelTextOblig"
                        rendered="#{registrarUsuarioAsesoriaBean.renderUsuario || registrarUsuarioAsesoriaBean.renderRegistrar}"/>
          <h:outputText value=""
                        rendered="#{registrarUsuarioAsesoriaBean.renderUsuario || registrarUsuarioAsesoriaBean.renderRegistrar}"/>
          <h:outputText value="Segundo Apellido"
                        rendered="#{registrarUsuarioAsesoriaBean.renderUsuario || registrarUsuarioAsesoriaBean.renderRegistrar}"/>
          <h:outputText value=""
                        rendered="#{registrarUsuarioAsesoriaBean.renderUsuario || registrarUsuarioAsesoriaBean.renderRegistrar}"/>
          <h:inputText id="primerNombre" onkeydown="return blockEnter(event);" maxlength="20" 
                       rendered="#{registrarUsuarioAsesoriaBean.renderUsuario || registrarUsuarioAsesoriaBean.renderRegistrar}"
                       disabled="#{registrarUsuarioAsesoriaBean.renderUsuario}"
                       value="#{registrarUsuarioAsesoriaBean.usuario.huscprimernomb}"></h:inputText>
          <a4j:outputPanel ajaxRendered="true"
                           rendered="#{registrarUsuarioAsesoriaBean.renderUsuario || registrarUsuarioAsesoriaBean.renderRegistrar}">
            <t:message for="primerNombre" styleClass="errorMessage"/>
          </a4j:outputPanel>
          <h:inputText id="segundoNombre" onkeydown="return blockEnter(event);"
                       rendered="#{registrarUsuarioAsesoriaBean.renderUsuario || registrarUsuarioAsesoriaBean.renderRegistrar}"
                       disabled="#{registrarUsuarioAsesoriaBean.renderUsuario}"
                       value="#{registrarUsuarioAsesoriaBean.usuario.huscsegundnomb}" maxlength="20"></h:inputText>
          <a4j:outputPanel ajaxRendered="true"
                           rendered="#{registrarUsuarioAsesoriaBean.renderUsuario || registrarUsuarioAsesoriaBean.renderRegistrar}">
            <t:message for="segundoNombre" styleClass="errorMessage"/>
          </a4j:outputPanel>
          <h:inputText id="primerApellido" onkeydown="return blockEnter(event);" maxlength="20" 
                       rendered="#{registrarUsuarioAsesoriaBean.renderUsuario || registrarUsuarioAsesoriaBean.renderRegistrar}"
                       disabled="#{registrarUsuarioAsesoriaBean.renderUsuario}"
                       value="#{registrarUsuarioAsesoriaBean.usuario.huscprimerapel}"></h:inputText>
          <a4j:outputPanel ajaxRendered="true"
                           rendered="#{registrarUsuarioAsesoriaBean.renderUsuario || registrarUsuarioAsesoriaBean.renderRegistrar}">
            <t:message for="primerApellido" styleClass="errorMessage"/>
          </a4j:outputPanel>
          <h:inputText id="segundoApellido" onkeydown="return blockEnter(event);" maxlength="20"
                       rendered="#{registrarUsuarioAsesoriaBean.renderUsuario || registrarUsuarioAsesoriaBean.renderRegistrar}"
                       disabled="#{registrarUsuarioAsesoriaBean.renderUsuario}"
                       value="#{registrarUsuarioAsesoriaBean.usuario.huscsegundapel}"></h:inputText>
          <a4j:outputPanel ajaxRendered="true"
                           rendered="#{registrarUsuarioAsesoriaBean.renderUsuario || registrarUsuarioAsesoriaBean.renderRegistrar}">
            <t:message for="segundoApellido" styleClass="errorMessage"/>
          </a4j:outputPanel>
          <h:outputText value="Fecha Nacimiento" styleClass="labelTextOblig"
                        rendered="#{registrarUsuarioAsesoriaBean.renderUsuario || registrarUsuarioAsesoriaBean.renderRegistrar}"/>
          <h:outputText value=""
                        rendered="#{registrarUsuarioAsesoriaBean.renderUsuario || registrarUsuarioAsesoriaBean.renderRegistrar}"/>
          <h:outputText value="Edad" styleClass="labelTextOblig"
                        rendered="#{registrarUsuarioAsesoriaBean.renderUsuario || registrarUsuarioAsesoriaBean.renderRegistrar}"/>
          <h:outputText value=""
                        rendered="#{registrarUsuarioAsesoriaBean.renderUsuario || registrarUsuarioAsesoriaBean.renderRegistrar}"/>
          <h:outputText value="Sexo" styleClass="labelTextOblig"
                        rendered="#{registrarUsuarioAsesoriaBean.renderUsuario || registrarUsuarioAsesoriaBean.renderRegistrar}"/>
          <h:outputText value=""
                        rendered="#{registrarUsuarioAsesoriaBean.renderUsuario || registrarUsuarioAsesoriaBean.renderRegistrar}"/>
          <h:outputText value="Escolaridad" styleClass="labelTextOblig"
                        rendered="#{registrarUsuarioAsesoriaBean.renderUsuario || registrarUsuarioAsesoriaBean.renderRegistrar}"/>
          <h:outputText value=""
                        rendered="#{registrarUsuarioAsesoriaBean.renderUsuario || registrarUsuarioAsesoriaBean.renderRegistrar}"/>
       
          <t:inputCalendar id="fechaNacimiento" 
                           rendered="#{registrarUsuarioAsesoriaBean.renderUsuario || registrarUsuarioAsesoriaBean.renderRegistrar}"
                           monthYearRowClass="yearMonthHeader" weekRowClass="weekHeader" 
                           title="Formato: dd/mm/yyyy" currentDayCellClass="currentDayCell" popupDateFormat="dd/MM/yyyy"
                           renderAsPopup="true" disabled="false"
                           value="#{registrarUsuarioAsesoriaBean.usuario.husdfechanacim}"
                           popupTodayString="Hoy" popupWeekString="Semana" popupButtonString="Fecha" readonly="false"
                           maxlength="11" size="11" popupButtonImageUrl="/comun/imagenes/ico_calendario2.gif"
                           renderPopupButtonAsImage="true" align="top" >
            <f:validator validatorId="dateMenorActualValidator"/>
            <a4j:support id="supportNacimiento" event="onchange"  reRender="panelEdad">
              <a4j:ajaxListener type="org.ajax4jsf.ajax.ForceRender"/>
            </a4j:support>
          </t:inputCalendar>
        
          <a4j:outputPanel ajaxRendered="true"
                           rendered="#{registrarUsuarioAsesoriaBean.renderUsuario || registrarUsuarioAsesoriaBean.renderRegistrar}">
            <t:message for="fechaNacimiento" styleClass="errorMessage"/>
          </a4j:outputPanel>
        <h:panelGroup id="panelEdad">
          <h:inputText id="inputEdad" onkeydown="return blockEnter(event);" maxlength="4" disabled="true"
                       rendered="#{registrarUsuarioAsesoriaBean.renderUsuario || registrarUsuarioAsesoriaBean.renderRegistrar}"
                       value="#{registrarUsuarioAsesoriaBean.usuario.edad}"/>
        </h:panelGroup>
          <h:outputText value=""/>
          <h:selectOneMenu id="radioSexo" onkeydown="return blockEnter(event);" 
                           rendered="#{registrarUsuarioAsesoriaBean.renderUsuario || registrarUsuarioAsesoriaBean.renderRegistrar}"
                           value="#{registrarUsuarioAsesoriaBean.usuario.husesexo}">
            <f:selectItems value="#{registrarUsuarioAsesoriaBean.listSexos}"/>
          </h:selectOneMenu>
          <a4j:outputPanel ajaxRendered="true"
                           rendered="#{registrarUsuarioAsesoriaBean.renderUsuario || registrarUsuarioAsesoriaBean.renderRegistrar}">
            <t:message for="radioSexo" styleClass="errorMessage"/>
          </a4j:outputPanel>
          <h:inputText id="itNivelEducativo" value="#{registrarUsuarioAsesoriaBean.usuario.husnniveledu}" maxlength="2"
                        style="width:40px"
                       rendered="#{registrarUsuarioAsesoriaBean.renderUsuario || registrarUsuarioAsesoriaBean.renderRegistrar}"/>
          <a4j:outputPanel ajaxRendered="true"
                           rendered="#{registrarUsuarioAsesoriaBean.renderUsuario || registrarUsuarioAsesoriaBean.renderRegistrar}">
            <t:message for="itNivelEducativo" styleClass="errorMessage"/>
          </a4j:outputPanel>
          <h:outputText value="Estrato "
                        rendered="#{registrarUsuarioAsesoriaBean.renderUsuario || registrarUsuarioAsesoriaBean.renderRegistrar}"/>
          <h:outputText value=""
                        rendered="#{registrarUsuarioAsesoriaBean.renderUsuario || registrarUsuarioAsesoriaBean.renderRegistrar}"/>
          <h:outputText value="Estado Civil"
                        rendered="#{registrarUsuarioAsesoriaBean.renderUsuario || registrarUsuarioAsesoriaBean.renderRegistrar}"/>
          <h:outputText value=""
                        rendered="#{registrarUsuarioAsesoriaBean.renderUsuario || registrarUsuarioAsesoriaBean.renderRegistrar}"/>
          <h:outputText value="Correo Electrónico"
                        rendered="#{registrarUsuarioAsesoriaBean.renderUsuario || registrarUsuarioAsesoriaBean.renderRegistrar}"/>
          <h:outputText value=""
                        rendered="#{registrarUsuarioAsesoriaBean.renderUsuario || registrarUsuarioAsesoriaBean.renderRegistrar}"/>
          <h:outputText value=""
                        rendered="#{registrarUsuarioAsesoriaBean.renderUsuario || registrarUsuarioAsesoriaBean.renderRegistrar}"/>
          <h:outputText value=""
                        rendered="#{registrarUsuarioAsesoriaBean.renderUsuario || registrarUsuarioAsesoriaBean.renderRegistrar}"/>
          <h:selectOneMenu id="mnuEstrato" onkeydown="return blockEnter(event);" 
                           rendered="#{registrarUsuarioAsesoriaBean.renderUsuario || registrarUsuarioAsesoriaBean.renderRegistrar}"
                           value="#{registrarUsuarioAsesoriaBean.usuario.husnestrato}">
            <f:selectItems value="#{registrarUsuarioAsesoriaBean.listEstrato}"/>
          </h:selectOneMenu>
          <a4j:outputPanel ajaxRendered="true"
                           rendered="#{registrarUsuarioAsesoriaBean.renderUsuario || registrarUsuarioAsesoriaBean.renderRegistrar}">
            <t:message for="mnuEstrato" styleClass="errorMessage"/>
          </a4j:outputPanel>
          <h:selectOneMenu id="radioEstadoCivil" onkeydown="return blockEnter(event);" 
                           rendered="#{registrarUsuarioAsesoriaBean.renderUsuario || registrarUsuarioAsesoriaBean.renderRegistrar}"
                           value="#{registrarUsuarioAsesoriaBean.usuario.huseestadcivil}">
            <f:selectItems value="#{registrarUsuarioAsesoriaBean.listEstadoCivil}"/>
          </h:selectOneMenu>
          <a4j:outputPanel ajaxRendered="true"
                           rendered="#{registrarUsuarioAsesoriaBean.renderUsuario || registrarUsuarioAsesoriaBean.renderRegistrar}">
            <t:message for="radioEstadoCivil" styleClass="errorMessage"/>
          </a4j:outputPanel>
          <h:inputText id="itCorreo" maxlength="30" onkeydown="return blockEnter(event);"
                       rendered="#{registrarUsuarioAsesoriaBean.renderUsuario || registrarUsuarioAsesoriaBean.renderRegistrar}"
                       value="#{registrarUsuarioAsesoriaBean.usuario.husccorreoelec}"/>
          <a4j:outputPanel ajaxRendered="true"
                           rendered="#{registrarUsuarioAsesoriaBean.renderUsuario || registrarUsuarioAsesoriaBean.renderRegistrar}">
            <t:message for="itCorreo" styleClass="errorMessage"/>
          </a4j:outputPanel>
          <h:outputText value=""
                        rendered="#{registrarUsuarioAsesoriaBean.renderUsuario || registrarUsuarioAsesoriaBean.renderRegistrar}"/>
          <h:outputText value=""
                        rendered="#{registrarUsuarioAsesoriaBean.renderUsuario || registrarUsuarioAsesoriaBean.renderRegistrar}"/>
          <h:outputText value="Dirección"
                        rendered="#{registrarUsuarioAsesoriaBean.renderUsuario || registrarUsuarioAsesoriaBean.renderRegistrar}"
                        styleClass="labelTextOblig"/>
          <h:outputText value=""
                        rendered="#{registrarUsuarioAsesoriaBean.renderUsuario || registrarUsuarioAsesoriaBean.renderRegistrar}"/>
          <h:outputText value="Barrio "
                        rendered="#{registrarUsuarioAsesoriaBean.renderUsuario || registrarUsuarioAsesoriaBean.renderRegistrar}"
                        styleClass="labelTextOblig"/>
          <h:outputText value=""
                        rendered="#{registrarUsuarioAsesoriaBean.renderUsuario || registrarUsuarioAsesoriaBean.renderRegistrar}"/>
          <h:outputText value="Teléfono"
                        rendered="#{registrarUsuarioAsesoriaBean.renderUsuario || registrarUsuarioAsesoriaBean.renderRegistrar}"
                        styleClass="labelTextOblig"/>
          <h:outputText value=""
                        rendered="#{registrarUsuarioAsesoriaBean.renderUsuario || registrarUsuarioAsesoriaBean.renderRegistrar}"/>
          <h:outputText value="Zona" styleClass="labelTextOblig"
                        rendered="#{registrarUsuarioAsesoriaBean.renderUsuario || registrarUsuarioAsesoriaBean.renderRegistrar}"/>
          <h:outputText value=""
                        rendered="#{registrarUsuarioAsesoriaBean.renderUsuario || registrarUsuarioAsesoriaBean.renderRegistrar}"/>
          <h:inputText id="Direccion" maxlength="20" onkeydown="return blockEnter(event);" 
                       rendered="#{registrarUsuarioAsesoriaBean.renderUsuario || registrarUsuarioAsesoriaBean.renderRegistrar}"
                       value="#{registrarUsuarioAsesoriaBean.usuario.huscdireccion}"></h:inputText>
          <a4j:outputPanel ajaxRendered="true"
                           rendered="#{registrarUsuarioAsesoriaBean.renderUsuario || registrarUsuarioAsesoriaBean.renderRegistrar}">
            <t:message for="Direccion" styleClass="errorMessage"/>
          </a4j:outputPanel>
          <h:inputText id="itBarrio" onkeydown="return blockEnter(event);" maxlength="20" 
                       rendered="#{registrarUsuarioAsesoriaBean.renderUsuario || registrarUsuarioAsesoriaBean.renderRegistrar}"
                       value="#{registrarUsuarioAsesoriaBean.usuario.huscbarrio}"></h:inputText>
          <a4j:outputPanel ajaxRendered="true"
                           rendered="#{registrarUsuarioAsesoriaBean.renderUsuario || registrarUsuarioAsesoriaBean.renderRegistrar}">
            <t:message for="itBarrio" styleClass="errorMessage"/>
          </a4j:outputPanel>
          <h:inputText id="Telefono" maxlength="20" onkeydown="return blockEnter(event);" 
                       rendered="#{registrarUsuarioAsesoriaBean.renderUsuario || registrarUsuarioAsesoriaBean.renderRegistrar}"
                       value="#{registrarUsuarioAsesoriaBean.usuario.husctelefono}"/>
          <a4j:outputPanel ajaxRendered="true"
                           rendered="#{registrarUsuarioAsesoriaBean.renderUsuario || registrarUsuarioAsesoriaBean.renderRegistrar}">
            <t:message for="Telefono" styleClass="errorMessage"/>
          </a4j:outputPanel>
          <h:selectOneRadio id="radioZona" onkeydown="return blockEnter(event);" 
                            rendered="#{registrarUsuarioAsesoriaBean.renderUsuario || registrarUsuarioAsesoriaBean.renderRegistrar}"
                            value="#{registrarUsuarioAsesoriaBean.usuario.husezonareside}">
            <f:selectItems value="#{registrarUsuarioAsesoriaBean.listzona}"/>
          </h:selectOneRadio>
          <a4j:outputPanel ajaxRendered="true"
                           rendered="#{registrarUsuarioAsesoriaBean.renderUsuario || registrarUsuarioAsesoriaBean.renderRegistrar}">
            <t:message for="radioZona" styleClass="errorMessage"/>
          </a4j:outputPanel>
          <h:outputText value="País de residencia habitual" styleClass="labelTextOblig"
                        rendered="#{registrarUsuarioAsesoriaBean.renderUsuario || registrarUsuarioAsesoriaBean.renderRegistrar}"/>
          <h:outputText value=""
                        rendered="#{registrarUsuarioAsesoriaBean.renderUsuario || registrarUsuarioAsesoriaBean.renderRegistrar}"/>
          <h:outputText value="Departamento" styleClass="labelTextOblig"
                        rendered="#{registrarUsuarioAsesoriaBean.renderUsuario || registrarUsuarioAsesoriaBean.renderRegistrar}"/>
          <h:outputText value=""
                        rendered="#{registrarUsuarioAsesoriaBean.renderUsuario || registrarUsuarioAsesoriaBean.renderRegistrar}"/>
          <h:outputText value="Municipio" styleClass="labelTextOblig"
                        rendered="#{registrarUsuarioAsesoriaBean.renderUsuario || registrarUsuarioAsesoriaBean.renderRegistrar}"/>
          <h:outputText value=""
                        rendered="#{registrarUsuarioAsesoriaBean.renderUsuario || registrarUsuarioAsesoriaBean.renderRegistrar}"/>
          <h:outputText value="Tipo de Afiliación" styleClass="labelTextOblig"
                        rendered="#{registrarUsuarioAsesoriaBean.renderUsuario || registrarUsuarioAsesoriaBean.renderRegistrar}"/>
          <h:outputText value=" "
                        rendered="#{registrarUsuarioAsesoriaBean.renderUsuario || registrarUsuarioAsesoriaBean.renderRegistrar}"/>

          <h:selectOneMenu id="menuPais" onkeydown="return blockEnter(event);"
                           rendered="#{registrarUsuarioAsesoriaBean.renderUsuario || registrarUsuarioAsesoriaBean.renderRegistrar}"
                           value="#{registrarUsuarioAsesoriaBean.usuario.huscpaisresi}">
            <f:selectItems value="#{registrarUsuarioAsesoriaBean.listPaises}"/>
          </h:selectOneMenu>
          <a4j:outputPanel ajaxRendered="true"
                           rendered="#{registrarUsuarioAsesoriaBean.renderUsuario || registrarUsuarioAsesoriaBean.renderRegistrar}">
            <t:message for="menuPais" styleClass="errorMessage"/>
          </a4j:outputPanel>


          <h:selectOneMenu id="menuDepartamentos" onkeydown="return blockEnter(event);"
                           rendered="#{registrarUsuarioAsesoriaBean.renderUsuario || registrarUsuarioAsesoriaBean.renderRegistrar}"
                           value="#{registrarUsuarioAsesoriaBean.usuario.husndepartamen}" 
                           valueChangeListener="#{registrarUsuarioAsesoriaBean.setDepartamentoSelect}">
            <f:selectItems value="#{registrarUsuarioAsesoriaBean.listDepartamentos}"/>
            <a4j:support id="support7" action="#{registrarUsuarioAsesoriaBean.changeCiudad}"
                         reRender="panelRegionInfoConsulta" event="onchange" >
              <a4j:ajaxListener type="org.ajax4jsf.ajax.ForceRender"/>
            </a4j:support>
          </h:selectOneMenu>
          <a4j:outputPanel ajaxRendered="true"
                           rendered="#{registrarUsuarioAsesoriaBean.renderUsuario || registrarUsuarioAsesoriaBean.renderRegistrar}">
            <t:message for="menuDepartamentos" styleClass="errorMessage"/>
          </a4j:outputPanel>
          <h:selectOneMenu id="menuCiudad"  onkeydown="return blockEnter(event);"
                           rendered="#{registrarUsuarioAsesoriaBean.renderUsuario || registrarUsuarioAsesoriaBean.renderRegistrar}"
                           value="#{registrarUsuarioAsesoriaBean.usuario.husnciudad}">
            <f:selectItems value="#{registrarUsuarioAsesoriaBean.listMunicipios}"/>
          </h:selectOneMenu>
          <a4j:outputPanel ajaxRendered="true"
                           rendered="#{registrarUsuarioAsesoriaBean.renderUsuario || registrarUsuarioAsesoriaBean.renderRegistrar}">
            <t:message for="menuCiudad" styleClass="errorMessage"/>
          </a4j:outputPanel>
          <h:selectOneMenu id="menuAfiliacion" onkeydown="return blockEnter(event);" 
                           rendered="#{registrarUsuarioAsesoriaBean.renderUsuario || registrarUsuarioAsesoriaBean.renderRegistrar}"
                           value="#{registrarUsuarioAsesoriaBean.usuario.husetipoafilia}">
            <f:selectItems value="#{registrarUsuarioAsesoriaBean.listTipoAfiliacion}"/>
          </h:selectOneMenu>
          <a4j:outputPanel ajaxRendered="true"
                           rendered="#{registrarUsuarioAsesoriaBean.renderUsuario || registrarUsuarioAsesoriaBean.renderRegistrar}">
            <t:message for="menuAfiliacion" styleClass="errorMessage"/>
          </a4j:outputPanel>


          <h:outputText value="EPS" styleClass="labelTextOblig"
                        rendered="#{registrarUsuarioAsesoriaBean.renderUsuario || registrarUsuarioAsesoriaBean.renderRegistrar}"/>
          <h:outputText value=" "
                        rendered="#{registrarUsuarioAsesoriaBean.renderUsuario || registrarUsuarioAsesoriaBean.renderRegistrar}"/>
          <h:outputText value=" "
                        rendered="#{registrarUsuarioAsesoriaBean.renderUsuario || registrarUsuarioAsesoriaBean.renderRegistrar}"/>
          <h:outputText value=" "
                        rendered="#{registrarUsuarioAsesoriaBean.renderUsuario || registrarUsuarioAsesoriaBean.renderRegistrar}"/>
          <h:outputText value=" "
                        rendered="#{registrarUsuarioAsesoriaBean.renderUsuario || registrarUsuarioAsesoriaBean.renderRegistrar}"/>
          <h:outputText value=" "
                        rendered="#{registrarUsuarioAsesoriaBean.renderUsuario || registrarUsuarioAsesoriaBean.renderRegistrar}"/>
          <h:outputText value=" "
                        rendered="#{registrarUsuarioAsesoriaBean.renderUsuario || registrarUsuarioAsesoriaBean.renderRegistrar}"/>
          <h:outputText value=" "
                        rendered="#{registrarUsuarioAsesoriaBean.renderUsuario || registrarUsuarioAsesoriaBean.renderRegistrar}"/>
          <h:selectOneMenu id="menuEps" onkeydown="return blockEnter(event);" 
                           rendered="#{registrarUsuarioAsesoriaBean.renderUsuario || registrarUsuarioAsesoriaBean.renderRegistrar}"
                           value="#{registrarUsuarioAsesoriaBean.usuario.huscentidadadm}">
            <f:selectItems value="#{registrarUsuarioAsesoriaBean.listEntidadAdm}"/>
          </h:selectOneMenu>
          <a4j:outputPanel ajaxRendered="true"
                           rendered="#{registrarUsuarioAsesoriaBean.renderUsuario || registrarUsuarioAsesoriaBean.renderRegistrar}">
            <t:message for="menuEps" styleClass="errorMessage"/>
          </a4j:outputPanel>
        </h:panelGrid>
        <h:panelGrid columns="2" border="0" cellpadding="0" cellspacing="0" width="100%" id="panelRegionInfoOcupacion"
                     rowClasses="labelText,labelTextInfo">
          <h:outputText value="Ocupación"
                        rendered="#{registrarUsuarioAsesoriaBean.renderUsuario || registrarUsuarioAsesoriaBean.renderRegistrar}"/>
          <h:outputText value=""
                        rendered="#{registrarUsuarioAsesoriaBean.renderUsuario || registrarUsuarioAsesoriaBean.renderRegistrar}"/>
          <h:selectOneMenu id="menuOcupacion" 
                           value="#{registrarUsuarioAsesoriaBean.usuario.husnocupacion}"
                           rendered="#{registrarUsuarioAsesoriaBean.renderUsuario || registrarUsuarioAsesoriaBean.renderRegistrar}"
                           onkeydown="return blockEnter(event);">
            <f:selectItems value="#{registrarUsuarioAsesoriaBean.listOcupaciones}"/>
          </h:selectOneMenu>
          <a4j:outputPanel ajaxRendered="true"
                           rendered="#{registrarUsuarioAsesoriaBean.renderUsuario || registrarUsuarioAsesoriaBean.renderRegistrar}">
            <t:message for="menuOcupacion" styleClass="errorMessage"/>
          </a4j:outputPanel>
        </h:panelGrid>
      </s:fieldset>
      
         <s:fieldset legend="Datos Acompañante" id="fieldSetInfoAcompaAsesoria" styleClass="fieldset" rendered="#{registrarUsuarioAsesoriaBean.renderUsuario || registrarUsuarioAsesoriaBean.renderRegistrar}" >
        <h:panelGrid columns="3" border="0" cellpadding="0" cellspacing="0" width="100%" id="panelRegionInfoAcompa"
                     rowClasses="labelText,labelTextInfo">
          <h:outputText value="Acompañante" rendered="#{registrarUsuarioAsesoriaBean.renderUsuario || registrarUsuarioAsesoriaBean.renderRegistrar}"/>
          <h:outputText value="Teléfono Acompañante" rendered="#{registrarUsuarioAsesoriaBean.renderUsuario || registrarUsuarioAsesoriaBean.renderRegistrar}"/>
          <h:outputText value="" rendered="#{registrarUsuarioAsesoriaBean.renderUsuario || registrarUsuarioAsesoriaBean.renderRegistrar}"/>
          <h:panelGroup>
            <h:inputText id="itAcom" maxlength="40" onkeydown="return blockEnter(event);" 
            rendered="#{registrarUsuarioAsesoriaBean.renderUsuario || registrarUsuarioAsesoriaBean.renderRegistrar}"
                         value="#{registrarUsuarioAsesoriaBean.usuario.huscnomacompana}"></h:inputText>
            <a4j:outputPanel ajaxRendered="true" rendered="#{registrarUsuarioAsesoriaBean.renderUsuario || registrarUsuarioAsesoriaBean.renderRegistrar}">
              <t:message for="itAcom" styleClass="errorMessage"/>
            </a4j:outputPanel>
          </h:panelGroup>
          <h:inputText onkeydown="return blockEnter(event);" maxlength="20" rendered="#{registrarUsuarioAsesoriaBean.renderUsuario || registrarUsuarioAsesoriaBean.renderRegistrar}"
                       value="#{registrarUsuarioAsesoriaBean.usuario.husctelacompana}"/>
          <h:outputText/>
        
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
          <h:commandButton value="Guardar" styleClass="boton_fieldset"
                           rendered="#{registrarUsuarioAsesoriaBean.renderUsuario || registrarUsuarioAsesoriaBean.renderRegistrar}"
                           action="#{registrarUsuarioAsesoriaBean.guardarUsuario}">
            <a4j:support event="onclick" status="statusButton"/>
          </h:commandButton>
        </h:panelGroup>
      </h:panelGrid>
    </t:panelTab>
    <t:panelTab id="panelTabPreguntaSeguimiento" label="Asesoría control"
                rendered="#{registrarUsuarioAsesoriaBean.renderSeguimiento && !registrarUsuarioAsesoriaBean.renderSelecionarUsuario}">
      <h:panelGrid columns="2" border="0" cellpadding="0" cellspacing="0" width="100%" id="panelRegionMensajeAsesoria"
                   rowClasses="labelText,labelTextInfo">
        <h:outputText value="#{registrarUsuarioAsesoriaBean.msg_existe_asesoria}" styleClass="labelTextOblig"/>
        <h:outputText/>
        <h:selectOneRadio id="radioOpcionSeguimiento" onkeydown="return blockEnter(event);" 
                          value="#{registrarUsuarioAsesoriaBean.opcionSelect}">
          <f:selectItems value="#{registrarUsuarioAsesoriaBean.lstOpcionesSeguimiento}"/>
        </h:selectOneRadio>
        <a4j:outputPanel ajaxRendered="true">
          <t:message for="radioOpcionSeguimiento" styleClass="errorMessage"/>
        </a4j:outputPanel>
      </h:panelGrid>
      <h:panelGrid columns="1" border="0" cellpadding="0" cellspacing="0" width="100%" id="panelBotonContinuar"
                   columnClasses="panelGridBotones">
        <h:panelGroup>
          <h:commandButton value="Continuar" styleClass="boton_fieldset"
                           action="#{registrarUsuarioAsesoriaBean.continuarRegistro}">
            <a4j:support event="onclick" status="statusButton"/>
          </h:commandButton>
        </h:panelGroup>
      </h:panelGrid>
    </t:panelTab>
    
     <t:panelTab id="panelTabSeleccionarUsuario" label="Seleccionar Usuario"
                rendered="#{!registrarUsuarioAsesoriaBean.renderSeguimiento && registrarUsuarioAsesoriaBean.renderSelecionarUsuario}">
         
      <s:fieldset legend="Usuarios" id="fieldSetSeleccionarUsuario"
                  styleClass="fieldset_dataTable">
        <h:panelGrid columns="1" id="panelGridSeleccionarUsuario"
                     rendered="#{empty registrarUsuarioAsesoriaBean.lstUsuarios}">
          <h:outputText value="#{msg.msg_sin_consultar}"/>
        </h:panelGrid>
        <h:panelGrid columns="1" border="0" cellpadding="0" cellspacing="0"
                     width="100%" id="tableContentSeleccionarUsuario"
                     rendered="#{not empty registrarUsuarioAsesoriaBean.lstUsuarios}"
                     styleClass="tabContainer">
          <t:buffer into="#{table}">
            <h:dataTable var="item" border="1" cellpadding="0" cellspacing="0"
                         binding="#{registrarUsuarioAsesoriaBean.dtConsultaUsuario}"
                         value="#{registrarUsuarioAsesoriaBean.lstUsuarios}" rows="10"
                         styleClass="standard_table"
                         rowClasses="standardTable_Row1,standardTable_Row2"
                         footerClass="paginacion" id="dtSeleccionarUsuarios">
              <h:column>
                <f:facet name="header">
                  <h:outputText value="Numero Documento"/>
                </f:facet>
                <h:outputText value="#{item.husetipoiden} #{item.husanumeiden}"/>
              </h:column>
              <h:column>
                <f:facet name="header">
                  <h:outputText value="Nombre"/>
                </f:facet>
                <h:outputText value="#{item.huscprimernomb} #{item.huscsegundnomb} #{item.huscprimerapel} #{item.huscsegundapel}"/>
              </h:column>
              <h:column>
                <f:facet name="header">
                  <h:outputText value="Fecha de Nacimiento"/>
                </f:facet>
                <h:outputText value="#{item.husdfechanacim}"/>
              </h:column>
              <h:column>
                <f:facet name="header">
                  <h:outputText value="Numero de Usuario"/>
                </f:facet>
                <h:outputText value="#{item.huslnumero}"/>
              </h:column>
              <h:column>
                <f:facet name="header">
                  <h:outputText value="Seleccione"/>
                </f:facet>
                <h:commandLink id="aceptar"
                               action="#{registrarUsuarioAsesoriaBean.agregarUsuario}">
                  <t:graphicImage alt=""  border="0"
                                  url="/comun/imagenes/adicionar.gif"/>
                </h:commandLink>
              </h:column>
            </h:dataTable>
          </t:buffer>
          <t:buffer into="#{tableScroller}">
            <h:panelGrid columns="1" rowClasses="labelTextInfo,labelTextInfo">
              <t:dataScroller id="scroll_1" for="dtSeleccionarUsuarios" fastStep="10"
                              pageCountVar="pageCount" pageIndexVar="pageIndex"
                              styleClass="scroller" paginator="true"
                               paginatorMaxPages="9"
                              paginatorTableClass="paginator"
                              renderFacetsIfSinglePage="false"
                              paginatorActiveColumnStyle="font-weight:bold;">
                <f:facet name="first">
                  <t:graphicImage alt=""  url="/comun/imagenes/primero.gif" border="0"/>
                </f:facet>
                <f:facet name="last">
                  <t:graphicImage alt=""  url="/comun/imagenes/ultimo.gif" border="0"/>
                </f:facet>
                <f:facet name="previous">
                  <t:graphicImage alt=""  url="/comun/imagenes/anterior.gif"
                                  border="0"/>
                </f:facet>
                <f:facet name="next">
                  <t:graphicImage alt=""  url="/comun/imagenes/siguiente.gif"
                                  border="0"/>
                </f:facet>
                <f:facet name="fastforward">
                  <t:graphicImage alt=""  url="/comun/imagenes/adelante.gif"
                                  border="0"/>
                </f:facet>
                <f:facet name="fastrewind">
                  <t:graphicImage alt=""  url="/comun/imagenes/atras.gif" border="0"/>
                </f:facet>
              </t:dataScroller>
            </h:panelGrid>
          </t:buffer>
          <h:outputText value="#{tableScroller}" escape="false"/>
          <h:outputText value="#{table}" escape="false"/>
          <h:outputText value="#{tableScroller}" escape="false"/>
        </h:panelGrid>
      </s:fieldset>     
    <s:fieldset legend="Usuario Seleccionado" id="fieldUsuarioSelecc" styleClass="fieldset" >
        <h:outputText value="#{registrarUsuarioAsesoriaBean.usuario.huscprimernomb} #{registrarUsuarioAsesoriaBean.usuario.huscsegundnomb}  #{registrarUsuarioAsesoriaBean.usuario.huscprimerapel}  #{registrarUsuarioAsesoriaBean.usuario.huscsegundapel}" escape="false"/>
     </s:fieldset>
      
      
      <h:panelGrid columns="1" border="0" cellpadding="0" cellspacing="0" width="100%" 
      id="panelBotonSeleccionarUsuario"   columnClasses="panelGridBotones">
        <h:panelGroup>
          <h:commandButton value="Seleccionar Usuario" styleClass="boton_fieldset"
                           action="#{registrarUsuarioAsesoriaBean.seleccionarUsuario}">
            <a4j:support event="onclick" status="statusButton"/>
          </h:commandButton>
        </h:panelGroup>
      </h:panelGrid>
    </t:panelTab>
    
    
  </t:panelTabbedPane>
  <script language="javascript" type="text/javascript">
        document.forms[1].elements[6].focus()
</script>
</h:panelGrid>