<%@ page contentType="text/html;charset=iso-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsf/html" prefix="h"%>
<%@ taglib uri="http://java.sun.com/jsf/core" prefix="f"%>
<%@ taglib uri="http://richfaces.org/a4j" prefix="a4j"%>
<%@ taglib uri="http://myfaces.apache.org/tomahawk" prefix="t"%>
<%@ taglib uri="http://myfaces.apache.org/sandbox" prefix="s"%>
<h:panelGrid columns="1" border="0" cellpadding="0" cellspacing="0" width="920px"
             id="panelGridRegistrarUsuarioComplementarioTab" styleClass="tabContainer">
  <t:panelTabbedPane border="0" cellpadding="0" cellspacing="0" serverSideTabSwitch="false" activePanelTabVar="true"
                     width="100%" id="panelTabbedPaneDatosUsuario" styleClass="tabbedPane"
                     activeTabStyleClass="activeTab" inactiveTabStyleClass="inactiveTab"
                     disabledTabStyleClass="disabledTab" activeSubStyleClass="activeSub"
                     selectedIndex="#{registrarUsuarioComplementarioBean.selectedIndex}" inactiveSubStyleClass="inactiveSub"
                     tabContentStyleClass="tabContent">
    <t:panelTab id="panelTabDatosUsuario" label="Datos Usuario"
                rendered="#{!registrarUsuarioComplementarioBean.renderSelecionarUsuario}">
      <a4j:commandLink action="#{registrarUsuarioComplementarioBean.resetDatos}"
                       reRender="panelGridRegistrarUsuarioComplementarioTab"  title="Registrar Nuevo Usuario">
        <t:graphicImage alt="Registrar Nuevo Usuario" title="Registrar Nuevo Usuaria" border="0"
                        url="/comun/imagenes/nuevo.jpg"/>
      </a4j:commandLink>
      <s:fieldset legend="Datos Básicos Usuario" id="fieldSetInfoBasica" styleClass="fieldset">
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
                           disabled="#{registrarUsuarioComplementarioBean.renderUsuario || registrarUsuarioComplementarioBean.renderRegistrar}"
                           value="#{registrarUsuarioComplementarioBean.usuario.husetipoiden}"
                           onkeydown="return blockEnter(event);">
            <f:selectItems value="#{registrarUsuarioComplementarioBean.listTipoIdentificacion}"/>
          </h:selectOneMenu>
          <a4j:outputPanel ajaxRendered="true">
            <t:message for="tipoIde" styleClass="errorMessage"/>
          </a4j:outputPanel>
          <h:panelGrid columns="2" border="0" cellpadding="0" cellspacing="0">
            <a4j:commandButton value="Buscar"
                               disabled="#{registrarUsuarioComplementarioBean.renderUsuario || registrarUsuarioComplementarioBean.renderRegistrar}"
                               action="#{registrarUsuarioComplementarioBean.buscadorUsuario}"
                               reRender="panelGridRegistrarUsuarioComplementarioTab" image="/comun/imagenes/lupa.gif"/>
            <h:inputText id="itNumeroIdentificacion" maxlength="15" 
                         disabled="#{registrarUsuarioComplementarioBean.renderUsuario || registrarUsuarioComplementarioBean.renderRegistrar}"
                         value="#{registrarUsuarioComplementarioBean.usuario.husanumeiden}"
                         onkeydown="return blockEnter(event);"/>
          </h:panelGrid>
          <a4j:outputPanel ajaxRendered="true">
            <t:message for="itNumeroIdentificacion" styleClass="errorMessage"/>
          </a4j:outputPanel>
          <h:inputText id="idtipo" maxlength="12" disabled="true"
                       value="#{registrarUsuarioComplementarioBean.usuario.huslnumero}" 
                       onkeydown="return blockEnter(event);"></h:inputText>
          <a4j:outputPanel ajaxRendered="true">
            <t:message for="idtipo" styleClass="errorMessage"/>
          </a4j:outputPanel>
          <h:outputText/>
          <h:outputText/>
          <h:outputText value="Primer Nombre" styleClass="labelTextOblig"
                        rendered="#{registrarUsuarioComplementarioBean.renderUsuario || registrarUsuarioComplementarioBean.renderRegistrar}"/>
          <h:outputText value=""
                        rendered="#{registrarUsuarioComplementarioBean.renderUsuario || registrarUsuarioComplementarioBean.renderRegistrar}"/>
          <h:outputText value="Segundo Nombre"
                        rendered="#{registrarUsuarioComplementarioBean.renderUsuario || registrarUsuarioComplementarioBean.renderRegistrar}"/>
          <h:outputText value=""
                        rendered="#{registrarUsuarioComplementarioBean.renderUsuario || registrarUsuarioComplementarioBean.renderRegistrar}"/>
          <h:outputText value="Primer Apellido" styleClass="labelTextOblig"
                        rendered="#{registrarUsuarioComplementarioBean.renderUsuario || registrarUsuarioComplementarioBean.renderRegistrar}"/>
          <h:outputText value=""
                        rendered="#{registrarUsuarioComplementarioBean.renderUsuario || registrarUsuarioComplementarioBean.renderRegistrar}"/>
          <h:outputText value="Segundo Apellido"
                        rendered="#{registrarUsuarioComplementarioBean.renderUsuario || registrarUsuarioComplementarioBean.renderRegistrar}"/>
          <h:outputText value=""
                        rendered="#{registrarUsuarioComplementarioBean.renderUsuario || registrarUsuarioComplementarioBean.renderRegistrar}"/>
          <h:inputText id="primerNombre" onkeydown="return blockEnter(event);" maxlength="20" 
                       rendered="#{registrarUsuarioComplementarioBean.renderUsuario || registrarUsuarioComplementarioBean.renderRegistrar}"
                       disabled="#{registrarUsuarioComplementarioBean.renderUsuario}"
                       value="#{registrarUsuarioComplementarioBean.usuario.huscprimernomb}"></h:inputText>
          <a4j:outputPanel ajaxRendered="true"
                           rendered="#{registrarUsuarioComplementarioBean.renderUsuario || registrarUsuarioComplementarioBean.renderRegistrar}">
            <t:message for="primerNombre" styleClass="errorMessage"/>
          </a4j:outputPanel>
          <h:inputText id="segundoNombre" onkeydown="return blockEnter(event);"
                       rendered="#{registrarUsuarioComplementarioBean.renderUsuario || registrarUsuarioComplementarioBean.renderRegistrar}"
                       disabled="#{registrarUsuarioComplementarioBean.renderUsuario}"
                       value="#{registrarUsuarioComplementarioBean.usuario.huscsegundnomb}" maxlength="20"></h:inputText>
          <a4j:outputPanel ajaxRendered="true"
                           rendered="#{registrarUsuarioComplementarioBean.renderUsuario || registrarUsuarioComplementarioBean.renderRegistrar}">
            <t:message for="segundoNombre" styleClass="errorMessage"/>
          </a4j:outputPanel>
          <h:inputText id="primerApellido" onkeydown="return blockEnter(event);" maxlength="20" 
                       rendered="#{registrarUsuarioComplementarioBean.renderUsuario || registrarUsuarioComplementarioBean.renderRegistrar}"
                       disabled="#{registrarUsuarioComplementarioBean.renderUsuario}"
                       value="#{registrarUsuarioComplementarioBean.usuario.huscprimerapel}"></h:inputText>
          <a4j:outputPanel ajaxRendered="true"
                           rendered="#{registrarUsuarioComplementarioBean.renderUsuario || registrarUsuarioComplementarioBean.renderRegistrar}">
            <t:message for="primerApellido" styleClass="errorMessage"/>
          </a4j:outputPanel>
          <h:inputText id="segundoApellido" onkeydown="return blockEnter(event);" maxlength="20"
                       rendered="#{registrarUsuarioComplementarioBean.renderUsuario || registrarUsuarioComplementarioBean.renderRegistrar}"
                       disabled="#{registrarUsuarioComplementarioBean.renderUsuario}"
                       value="#{registrarUsuarioComplementarioBean.usuario.huscsegundapel}"></h:inputText>
          <a4j:outputPanel ajaxRendered="true"
                           rendered="#{registrarUsuarioComplementarioBean.renderUsuario || registrarUsuarioComplementarioBean.renderRegistrar}">
            <t:message for="segundoApellido" styleClass="errorMessage"/>
          </a4j:outputPanel>
          <h:outputText value="Fecha Nacimiento" styleClass="labelTextOblig"
                        rendered="#{registrarUsuarioComplementarioBean.renderUsuario || registrarUsuarioComplementarioBean.renderRegistrar}"/>
          <h:outputText value=""
                        rendered="#{registrarUsuarioComplementarioBean.renderUsuario || registrarUsuarioComplementarioBean.renderRegistrar}"/>
          <h:outputText value="Edad" styleClass="labelTextOblig"
                        rendered="#{registrarUsuarioComplementarioBean.renderUsuario || registrarUsuarioComplementarioBean.renderRegistrar}"/>
          <h:outputText value=""
                        rendered="#{registrarUsuarioComplementarioBean.renderUsuario || registrarUsuarioComplementarioBean.renderRegistrar}"/>
          <h:outputText value="Sexo" styleClass="labelTextOblig"
                        rendered="#{registrarUsuarioComplementarioBean.renderUsuario || registrarUsuarioComplementarioBean.renderRegistrar}"/>
          <h:outputText value=""
                        rendered="#{registrarUsuarioComplementarioBean.renderUsuario || registrarUsuarioComplementarioBean.renderRegistrar}"/>
          <h:outputText value="Escolaridad" styleClass="labelTextOblig"
                        rendered="#{registrarUsuarioComplementarioBean.renderUsuario || registrarUsuarioComplementarioBean.renderRegistrar}"/>
          <h:outputText value=""
                        rendered="#{registrarUsuarioComplementarioBean.renderUsuario || registrarUsuarioComplementarioBean.renderRegistrar}"/>
       
          <t:inputCalendar id="fechaNacimiento" 
                           rendered="#{registrarUsuarioComplementarioBean.renderUsuario || registrarUsuarioComplementarioBean.renderRegistrar}"
                           monthYearRowClass="yearMonthHeader" weekRowClass="weekHeader" 
                           title="Formato: dd/mm/yyyy" currentDayCellClass="currentDayCell" popupDateFormat="dd/MM/yyyy"
                           renderAsPopup="true" disabled="false"
                           value="#{registrarUsuarioComplementarioBean.usuario.husdfechanacim}"
                           popupTodayString="Hoy" popupWeekString="Semana" popupButtonString="Fecha" readonly="false"
                           maxlength="11" size="11" popupButtonImageUrl="/comun/imagenes/ico_calendario2.gif"
                           renderPopupButtonAsImage="true" align="top" >
            <f:validator validatorId="dateMenorActualValidator"/>
            <a4j:support id="supportNacimiento" event="onchange"  reRender="panelEdad">
              <a4j:ajaxListener type="org.ajax4jsf.ajax.ForceRender"/>
            </a4j:support>
          </t:inputCalendar>
        
          <a4j:outputPanel ajaxRendered="true"
                           rendered="#{registrarUsuarioComplementarioBean.renderUsuario || registrarUsuarioComplementarioBean.renderRegistrar}">
            <t:message for="fechaNacimiento" styleClass="errorMessage"/>
          </a4j:outputPanel>
        <h:panelGroup id="panelEdad">
          <h:inputText id="inputEdad" onkeydown="return blockEnter(event);" maxlength="4" disabled="true"
                       rendered="#{registrarUsuarioComplementarioBean.renderUsuario || registrarUsuarioComplementarioBean.renderRegistrar}"
                       value="#{registrarUsuarioComplementarioBean.usuario.edad}"/>
        </h:panelGroup>
          <h:outputText value=""/>
          <h:selectOneMenu id="radioSexo" onkeydown="return blockEnter(event);" 
                           rendered="#{registrarUsuarioComplementarioBean.renderUsuario || registrarUsuarioComplementarioBean.renderRegistrar}"
                           value="#{registrarUsuarioComplementarioBean.usuario.husesexo}">
            <f:selectItems value="#{registrarUsuarioComplementarioBean.listSexos}"/>
          </h:selectOneMenu>
          <a4j:outputPanel ajaxRendered="true"
                           rendered="#{registrarUsuarioComplementarioBean.renderUsuario || registrarUsuarioComplementarioBean.renderRegistrar}">
            <t:message for="radioSexo" styleClass="errorMessage"/>
          </a4j:outputPanel>
          <h:inputText id="itNivelEducativo" value="#{registrarUsuarioComplementarioBean.usuario.husnniveledu}" maxlength="2"
                        style="width:40px"
                       rendered="#{registrarUsuarioComplementarioBean.renderUsuario || registrarUsuarioComplementarioBean.renderRegistrar}"/>
          <a4j:outputPanel ajaxRendered="true"
                           rendered="#{registrarUsuarioComplementarioBean.renderUsuario || registrarUsuarioComplementarioBean.renderRegistrar}">
            <t:message for="itNivelEducativo" styleClass="errorMessage"/>
          </a4j:outputPanel>
          <h:outputText value="Estrato "
                        rendered="#{registrarUsuarioComplementarioBean.renderUsuario || registrarUsuarioComplementarioBean.renderRegistrar}"/>
          <h:outputText value=""
                        rendered="#{registrarUsuarioComplementarioBean.renderUsuario || registrarUsuarioComplementarioBean.renderRegistrar}"/>
          <h:outputText value="Estado Civil"
                        rendered="#{registrarUsuarioComplementarioBean.renderUsuario || registrarUsuarioComplementarioBean.renderRegistrar}"/>
          <h:outputText value=""
                        rendered="#{registrarUsuarioComplementarioBean.renderUsuario || registrarUsuarioComplementarioBean.renderRegistrar}"/>
          <h:outputText value="Correo Electrónico"
                        rendered="#{registrarUsuarioComplementarioBean.renderUsuario || registrarUsuarioComplementarioBean.renderRegistrar}"/>
          <h:outputText value=""
                        rendered="#{registrarUsuarioComplementarioBean.renderUsuario || registrarUsuarioComplementarioBean.renderRegistrar}"/>
          <h:outputText value=""
                        rendered="#{registrarUsuarioComplementarioBean.renderUsuario || registrarUsuarioComplementarioBean.renderRegistrar}"/>
          <h:outputText value=""
                        rendered="#{registrarUsuarioComplementarioBean.renderUsuario || registrarUsuarioComplementarioBean.renderRegistrar}"/>
          <h:selectOneMenu id="mnuEstrato" onkeydown="return blockEnter(event);" 
                           rendered="#{registrarUsuarioComplementarioBean.renderUsuario || registrarUsuarioComplementarioBean.renderRegistrar}"
                           value="#{registrarUsuarioComplementarioBean.usuario.husnestrato}">
            <f:selectItems value="#{registrarUsuarioComplementarioBean.listEstrato}"/>
          </h:selectOneMenu>
          <a4j:outputPanel ajaxRendered="true"
                           rendered="#{registrarUsuarioComplementarioBean.renderUsuario || registrarUsuarioComplementarioBean.renderRegistrar}">
            <t:message for="mnuEstrato" styleClass="errorMessage"/>
          </a4j:outputPanel>
          <h:selectOneMenu id="radioEstadoCivil" onkeydown="return blockEnter(event);" 
                           rendered="#{registrarUsuarioComplementarioBean.renderUsuario || registrarUsuarioComplementarioBean.renderRegistrar}"
                           value="#{registrarUsuarioComplementarioBean.usuario.huseestadcivil}">
            <f:selectItems value="#{registrarUsuarioComplementarioBean.listEstadoCivil}"/>
          </h:selectOneMenu>
          <a4j:outputPanel ajaxRendered="true"
                           rendered="#{registrarUsuarioComplementarioBean.renderUsuario || registrarUsuarioComplementarioBean.renderRegistrar}">
            <t:message for="radioEstadoCivil" styleClass="errorMessage"/>
          </a4j:outputPanel>
          <h:inputText id="itCorreo" maxlength="30" onkeydown="return blockEnter(event);"
                       rendered="#{registrarUsuarioComplementarioBean.renderUsuario || registrarUsuarioComplementarioBean.renderRegistrar}"
                       value="#{registrarUsuarioComplementarioBean.usuario.husccorreoelec}"/>
          <a4j:outputPanel ajaxRendered="true"
                           rendered="#{registrarUsuarioComplementarioBean.renderUsuario || registrarUsuarioComplementarioBean.renderRegistrar}">
            <t:message for="itCorreo" styleClass="errorMessage"/>
          </a4j:outputPanel>
          <h:outputText value=""
                        rendered="#{registrarUsuarioComplementarioBean.renderUsuario || registrarUsuarioComplementarioBean.renderRegistrar}"/>
          <h:outputText value=""
                        rendered="#{registrarUsuarioComplementarioBean.renderUsuario || registrarUsuarioComplementarioBean.renderRegistrar}"/>
          <h:outputText value="Dirección"
                        rendered="#{registrarUsuarioComplementarioBean.renderUsuario || registrarUsuarioComplementarioBean.renderRegistrar}"
                        styleClass="labelTextOblig"/>
          <h:outputText value=""
                        rendered="#{registrarUsuarioComplementarioBean.renderUsuario || registrarUsuarioComplementarioBean.renderRegistrar}"/>
          <h:outputText value="Barrio "
                        rendered="#{registrarUsuarioComplementarioBean.renderUsuario || registrarUsuarioComplementarioBean.renderRegistrar}"
                        styleClass="labelTextOblig"/>
          <h:outputText value=""
                        rendered="#{registrarUsuarioComplementarioBean.renderUsuario || registrarUsuarioComplementarioBean.renderRegistrar}"/>
          <h:outputText value="Teléfono"
                        rendered="#{registrarUsuarioComplementarioBean.renderUsuario || registrarUsuarioComplementarioBean.renderRegistrar}"
                        styleClass="labelTextOblig"/>
          <h:outputText value=""
                        rendered="#{registrarUsuarioComplementarioBean.renderUsuario || registrarUsuarioComplementarioBean.renderRegistrar}"/>
          <h:outputText value="Zona" styleClass="labelTextOblig"
                        rendered="#{registrarUsuarioComplementarioBean.renderUsuario || registrarUsuarioComplementarioBean.renderRegistrar}"/>
          <h:outputText value=""
                        rendered="#{registrarUsuarioComplementarioBean.renderUsuario || registrarUsuarioComplementarioBean.renderRegistrar}"/>
          <h:inputText id="Direccion" maxlength="20" onkeydown="return blockEnter(event);" 
                       rendered="#{registrarUsuarioComplementarioBean.renderUsuario || registrarUsuarioComplementarioBean.renderRegistrar}"
                       value="#{registrarUsuarioComplementarioBean.usuario.huscdireccion}"></h:inputText>
          <a4j:outputPanel ajaxRendered="true"
                           rendered="#{registrarUsuarioComplementarioBean.renderUsuario || registrarUsuarioComplementarioBean.renderRegistrar}">
            <t:message for="Direccion" styleClass="errorMessage"/>
          </a4j:outputPanel>
          <h:inputText id="itBarrio" onkeydown="return blockEnter(event);" maxlength="20" 
                       rendered="#{registrarUsuarioComplementarioBean.renderUsuario || registrarUsuarioComplementarioBean.renderRegistrar}"
                       value="#{registrarUsuarioComplementarioBean.usuario.huscbarrio}"></h:inputText>
          <a4j:outputPanel ajaxRendered="true"
                           rendered="#{registrarUsuarioComplementarioBean.renderUsuario || registrarUsuarioComplementarioBean.renderRegistrar}">
            <t:message for="itBarrio" styleClass="errorMessage"/>
          </a4j:outputPanel>
          <h:inputText id="Telefono" maxlength="20" onkeydown="return blockEnter(event);" 
                       rendered="#{registrarUsuarioComplementarioBean.renderUsuario || registrarUsuarioComplementarioBean.renderRegistrar}"
                       value="#{registrarUsuarioComplementarioBean.usuario.husctelefono}"/>
          <a4j:outputPanel ajaxRendered="true"
                           rendered="#{registrarUsuarioComplementarioBean.renderUsuario || registrarUsuarioComplementarioBean.renderRegistrar}">
            <t:message for="Telefono" styleClass="errorMessage"/>
          </a4j:outputPanel>
          <h:selectOneRadio id="radioZona" onkeydown="return blockEnter(event);" 
                            rendered="#{registrarUsuarioComplementarioBean.renderUsuario || registrarUsuarioComplementarioBean.renderRegistrar}"
                            value="#{registrarUsuarioComplementarioBean.usuario.husezonareside}">
            <f:selectItems value="#{registrarUsuarioComplementarioBean.listzona}"/>
          </h:selectOneRadio>
          <a4j:outputPanel ajaxRendered="true"
                           rendered="#{registrarUsuarioComplementarioBean.renderUsuario || registrarUsuarioComplementarioBean.renderRegistrar}">
            <t:message for="radioZona" styleClass="errorMessage"/>
          </a4j:outputPanel>
          <h:outputText value="País de residencia habitual" styleClass="labelTextOblig"
                        rendered="#{registrarUsuarioComplementarioBean.renderUsuario || registrarUsuarioComplementarioBean.renderRegistrar}"/>
          <h:outputText value=""
                        rendered="#{registrarUsuarioComplementarioBean.renderUsuario || registrarUsuarioComplementarioBean.renderRegistrar}"/>
          <h:outputText value="Departamento" styleClass="labelTextOblig"
                        rendered="#{registrarUsuarioComplementarioBean.renderUsuario || registrarUsuarioComplementarioBean.renderRegistrar}"/>
          <h:outputText value=""
                        rendered="#{registrarUsuarioComplementarioBean.renderUsuario || registrarUsuarioComplementarioBean.renderRegistrar}"/>
          <h:outputText value="Municipio" styleClass="labelTextOblig"
                        rendered="#{registrarUsuarioComplementarioBean.renderUsuario || registrarUsuarioComplementarioBean.renderRegistrar}"/>
          <h:outputText value=""
                        rendered="#{registrarUsuarioComplementarioBean.renderUsuario || registrarUsuarioComplementarioBean.renderRegistrar}"/>
          <h:outputText value="Tipo de Afiliación" styleClass="labelTextOblig"
                        rendered="#{registrarUsuarioComplementarioBean.renderUsuario || registrarUsuarioComplementarioBean.renderRegistrar}"/>
          <h:outputText value=" "
                        rendered="#{registrarUsuarioComplementarioBean.renderUsuario || registrarUsuarioComplementarioBean.renderRegistrar}"/>

          <h:selectOneMenu id="menuPais" onkeydown="return blockEnter(event);"
                        rendered="#{registrarUsuarioComplementarioBean.renderUsuario || registrarUsuarioComplementarioBean.renderRegistrar}" 
                        value="#{registrarUsuarioComplementarioBean.usuario.huscpaisresi}">
               <f:selectItems value="#{registrarUsuarioComplementarioBean.listPaises}"/>
          </h:selectOneMenu>
          <a4j:outputPanel ajaxRendered="true"
                        rendered="#{registrarUsuarioComplementarioBean.renderUsuario || registrarUsuarioComplementarioBean.renderRegistrar}">
                <t:message for="menuPais" styleClass="errorMessage"/>
          </a4j:outputPanel>

          <h:selectOneMenu id="menuDepartamentos" onkeydown="return blockEnter(event);"
                           rendered="#{registrarUsuarioComplementarioBean.renderUsuario || registrarUsuarioComplementarioBean.renderRegistrar}"
                           value="#{registrarUsuarioComplementarioBean.usuario.husndepartamen}" 
                           valueChangeListener="#{registrarUsuarioComplementarioBean.setDepartamentoSelect}">
            <f:selectItems value="#{registrarUsuarioComplementarioBean.listDepartamentos}"/>
            <a4j:support id="support7" action="#{registrarUsuarioComplementarioBean.changeCiudad}"
                         reRender="panelRegionInfoConsulta" event="onchange" >
              <a4j:ajaxListener type="org.ajax4jsf.ajax.ForceRender"/>
            </a4j:support>
          </h:selectOneMenu>
          <a4j:outputPanel ajaxRendered="true"
                           rendered="#{registrarUsuarioComplementarioBean.renderUsuario || registrarUsuarioComplementarioBean.renderRegistrar}">
            <t:message for="menuDepartamentos" styleClass="errorMessage"/>
          </a4j:outputPanel>
          <h:selectOneMenu id="menuCiudad"  onkeydown="return blockEnter(event);"
                           rendered="#{registrarUsuarioComplementarioBean.renderUsuario || registrarUsuarioComplementarioBean.renderRegistrar}"
                           value="#{registrarUsuarioComplementarioBean.usuario.husnciudad}">
            <f:selectItems value="#{registrarUsuarioComplementarioBean.listMunicipios}"/>
          </h:selectOneMenu>
          <a4j:outputPanel ajaxRendered="true"
                           rendered="#{registrarUsuarioComplementarioBean.renderUsuario || registrarUsuarioComplementarioBean.renderRegistrar}">
            <t:message for="menuCiudad" styleClass="errorMessage"/>
          </a4j:outputPanel>
          <h:selectOneMenu id="menuAfiliacion" onkeydown="return blockEnter(event);" 
                           rendered="#{registrarUsuarioComplementarioBean.renderUsuario || registrarUsuarioComplementarioBean.renderRegistrar}"
                           value="#{registrarUsuarioComplementarioBean.usuario.husetipoafilia}">
            <f:selectItems value="#{registrarUsuarioComplementarioBean.listTipoAfiliacion}"/>
          </h:selectOneMenu>
          <a4j:outputPanel ajaxRendered="true"
                           rendered="#{registrarUsuarioComplementarioBean.renderUsuario || registrarUsuarioComplementarioBean.renderRegistrar}">
            <t:message for="menuAfiliacion" styleClass="errorMessage"/>
          </a4j:outputPanel>
        </h:panelGrid>
        <h:panelGrid columns="2" border="0" cellpadding="0" cellspacing="0" width="100%" id="panelRegionInfoOcupacion"
                     rowClasses="labelText,labelTextInfo">
          <h:outputText value="EPS" styleClass="labelTextOblig"
                        rendered="#{registrarUsuarioComplementarioBean.renderUsuario || registrarUsuarioComplementarioBean.renderRegistrar}"/>
          <h:outputText value=" "
                        rendered="#{registrarUsuarioComplementarioBean.renderUsuario || registrarUsuarioComplementarioBean.renderRegistrar}"/>
          <h:outputText value="Ocupación"
                        rendered="#{registrarUsuarioComplementarioBean.renderUsuario || registrarUsuarioComplementarioBean.renderRegistrar}"/>
          <h:outputText value=""
                        rendered="#{registrarUsuarioComplementarioBean.renderUsuario || registrarUsuarioComplementarioBean.renderRegistrar}"/>
          <h:selectOneMenu id="menuEps" onkeydown="return blockEnter(event);" 
                           rendered="#{registrarUsuarioComplementarioBean.renderUsuario || registrarUsuarioComplementarioBean.renderRegistrar}"
                           value="#{registrarUsuarioComplementarioBean.usuario.huscentidadadm}">
            <f:selectItems value="#{registrarUsuarioComplementarioBean.listEntidadAdm}"/>
          </h:selectOneMenu>
          <a4j:outputPanel ajaxRendered="true"
                           rendered="#{registrarUsuarioComplementarioBean.renderUsuario || registrarUsuarioComplementarioBean.renderRegistrar}">
            <t:message for="menuEps" styleClass="errorMessage"/>
          </a4j:outputPanel>
          <h:selectOneMenu id="menuOcupacion" 
                           value="#{registrarUsuarioComplementarioBean.usuario.husnocupacion}"
                           rendered="#{registrarUsuarioComplementarioBean.renderUsuario || registrarUsuarioComplementarioBean.renderRegistrar}"
                           onkeydown="return blockEnter(event);">
            <f:selectItems value="#{registrarUsuarioComplementarioBean.listOcupaciones}"/>
          </h:selectOneMenu>
          <a4j:outputPanel ajaxRendered="true"
                           rendered="#{registrarUsuarioComplementarioBean.renderUsuario || registrarUsuarioComplementarioBean.renderRegistrar}">
            <t:message for="menuOcupacion" styleClass="errorMessage"/>
          </a4j:outputPanel>
        </h:panelGrid>
      </s:fieldset>
      
         <s:fieldset legend="Datos Acompañante" id="fieldSetInfoAcompaComplementario" styleClass="fieldset" rendered="#{registrarUsuarioComplementarioBean.renderUsuario || registrarUsuarioComplementarioBean.renderRegistrar}" >
        <h:panelGrid columns="3" border="0" cellpadding="0" cellspacing="0" width="100%" id="panelRegionInfoAcompa"
                     rowClasses="labelText,labelTextInfo">
          <h:outputText value="Acompañante" rendered="#{registrarUsuarioComplementarioBean.renderUsuario || registrarUsuarioComplementarioBean.renderRegistrar}"/>
          <h:outputText value="Teléfono Acompañante" rendered="#{registrarUsuarioComplementarioBean.renderUsuario || registrarUsuarioComplementarioBean.renderRegistrar}"/>
          <h:outputText value="" rendered="#{registrarUsuarioComplementarioBean.renderUsuario || registrarUsuarioComplementarioBean.renderRegistrar}"/>
          <h:panelGroup>
            <h:inputText id="itAcom" maxlength="40" onkeydown="return blockEnter(event);" 
            rendered="#{registrarUsuarioComplementarioBean.renderUsuario || registrarUsuarioComplementarioBean.renderRegistrar}"
                         value="#{registrarUsuarioComplementarioBean.usuario.huscnomacompana}"></h:inputText>
            <a4j:outputPanel ajaxRendered="true" rendered="#{registrarUsuarioComplementarioBean.renderUsuario || registrarUsuarioComplementarioBean.renderRegistrar}">
              <t:message for="itAcom" styleClass="errorMessage"/>
            </a4j:outputPanel>
          </h:panelGroup>
          <h:inputText onkeydown="return blockEnter(event);" maxlength="20" rendered="#{registrarUsuarioComplementarioBean.renderUsuario || registrarUsuarioComplementarioBean.renderRegistrar}"
                       value="#{registrarUsuarioComplementarioBean.usuario.husctelacompana}"/>
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
                           rendered="#{registrarUsuarioComplementarioBean.renderUsuario || registrarUsuarioComplementarioBean.renderRegistrar}"
                           action="#{registrarUsuarioComplementarioBean.guardarUsuario}">
            <a4j:support event="onclick" status="statusButton"/>
          </h:commandButton>
        </h:panelGroup>
      </h:panelGrid>
    </t:panelTab>
    
     <t:panelTab id="panelTabSeleccionarUsuario" label="Seleccionar Usuario"
                rendered="#{registrarUsuarioComplementarioBean.renderSelecionarUsuario}">
         
      <s:fieldset legend="Usuarios" id="fieldSetSeleccionarUsuario"
                  styleClass="fieldset_dataTable">
        <h:panelGrid columns="1" id="panelGridSeleccionarUsuario"
                     rendered="#{empty registrarUsuarioComplementarioBean.lstUsuarios}">
          <h:outputText value="#{msg.msg_sin_consultar}"/>
        </h:panelGrid>
        <h:panelGrid columns="1" border="0" cellpadding="0" cellspacing="0"
                     width="100%" id="tableContentSeleccionarUsuario"
                     rendered="#{not empty registrarUsuarioComplementarioBean.lstUsuarios}"
                     styleClass="tabContainer">
          <t:buffer into="#{table}">
            <h:dataTable var="item" border="1" cellpadding="0" cellspacing="0"
                         binding="#{registrarUsuarioComplementarioBean.dtConsultaUsuario}"
                         value="#{registrarUsuarioComplementarioBean.lstUsuarios}" rows="10"
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
                               action="#{registrarUsuarioComplementarioBean.agregarUsuario}">
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
        <h:outputText value="#{registrarUsuarioComplementarioBean.usuario.huscprimernomb} #{registrarUsuarioComplementarioBean.usuario.huscsegundnomb}  #{registrarUsuarioComplementarioBean.usuario.huscprimerapel}  #{registrarUsuarioComplementarioBean.usuario.huscsegundapel}" escape="false"/>
     </s:fieldset>
      
      
      <h:panelGrid columns="1" border="0" cellpadding="0" cellspacing="0" width="100%" 
      id="panelBotonSeleccionarUsuario"   columnClasses="panelGridBotones">
        <h:panelGroup>
          <h:commandButton value="Seleccionar Usuario" styleClass="boton_fieldset"
                           action="#{registrarUsuarioComplementarioBean.seleccionarUsuario}">
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