<%@ page contentType="text/html;charset=windows-1252"%>
<%@ taglib uri="http://java.sun.com/jsf/html" prefix="h"%>
<%@ taglib uri="http://java.sun.com/jsf/core" prefix="f"%>
<%@ taglib uri="http://richfaces.org/a4j" prefix="a4j"%>
<%@ taglib uri="http://myfaces.apache.org/tomahawk" prefix="t"%>
<%@ taglib uri="http://myfaces.apache.org/sandbox" prefix="s"%>
<a4j:form id="formDatosUsuarios">
  <a4j:region id="bodyRegionRegistrarCirugiaSinFactura">
    <a4j:status id="statusButton" for="bodyRegionRegistrarCirugiaSinFactura">
      <f:facet name="start">
        <t:div id="chargindRegistrarCirugiaSinFactura" styleClass="loading">
          <h:panelGrid columns="1" cellpadding="0" cellspacing="0" border="0">
            <h:outputText value="Procesando..."/>
            <h:outputText value="Por favor espere."/>
          </h:panelGrid>
        </t:div>
      </f:facet>
      <f:facet name="stop"/>
    </a4j:status>
 
        <t:panelTabbedPane border="0" cellpadding="0" cellspacing="0" serverSideTabSwitch="false"
                           activePanelTabVar="true" width="100%" id="panelTabbedPaneDatosUsuario"
                           styleClass="tabbedPane" activeTabStyleClass="activeTab" inactiveTabStyleClass="inactiveTab"
                           disabledTabStyleClass="disabledTab" activeSubStyleClass="activeSub"
                           selectedIndex="#{consultarUsuarioConsultaSinFacturaBean.selectedIndex}"
                           inactiveSubStyleClass="inactiveSub" tabContentStyleClass="tabContent">
          <t:panelTab id="panelTabDatosUsuario" label="Crear Consulta Sin Factura "
                      rendered="#{!consultarUsuarioConsultaSinFacturaBean.renderSelecionarUsuario}">
                   <a4j:commandLink action="#{consultarUsuarioConsultaSinFacturaBean.resetDatos}" reRender="formDatosUsuarios"
                         title="Registrar Nuevo Usuario">
          <t:graphicImage alt="Registrar Nuevo Usuario" title="Registrar Nuevo Usuario" border="0"
                          url="/comun/imagenes/nuevo1.png" width="100" height="100"/>
        </a4j:commandLink>
                      
            <s:fieldset legend="Modificar Datos Basicos Usuario" id="fieldSetInfoBasica" styleClass="fieldset">
              <h:panelGrid columns="8" border="0" cellpadding="0" cellspacing="0" width="100%"
                           id="panelRegionInfoConsulta" rowClasses="labelText,labelTextInfo">
                <h:outputText value="Tipo Identificación" styleClass="labelTextOblig"/>
                <h:outputText value=""/>
                <h:outputText value=" Número Identificación" styleClass="labelTextOblig"/>
                <h:outputText value=""/>
                <h:outputText value="Número Usuario"/>
                <h:outputText value=""/>
                <h:outputText value=""/>
                <h:outputText value=""/>
                <h:selectOneMenu id="tipoIde"
                                 disabled="#{consultarUsuarioConsultaSinFacturaBean.renderUsuario || consultarUsuarioConsultaSinFacturaBean.renderModificar}"
                                 value="#{consultarUsuarioConsultaSinFacturaBean.usuario.husetipoiden}"
                                 onkeydown="return blockEnter(event);">
                  <f:selectItems value="#{consultarUsuarioConsultaSinFacturaBean.listTipoIdentificacion}"/>
                </h:selectOneMenu>
                <a4j:outputPanel ajaxRendered="true">
                  <t:message for="tipoIde" styleClass="errorMessage"/>
                </a4j:outputPanel>
                <h:panelGrid columns="2" border="0" cellpadding="0" cellspacing="0">
                
                  <h:inputText id="itNumeroIdentificacion" maxlength="15" onkeypress="searchByEnterAndReturn(event)"
                               disabled="#{consultarUsuarioConsultaSinFacturaBean.renderUsuario || consultarUsuarioConsultaSinFacturaBean.renderModificar}"
                               value="#{consultarUsuarioConsultaSinFacturaBean.usuario.husanumeiden}"
                               onkeydown="return blockEnter(event);"/>
                               <a4j:commandButton value="Buscar" id="BtnBuscar" oncomplete="numeroJs()"
                                     disabled="#{consultarUsuarioConsultaSinFacturaBean.renderUsuario || consultarUsuarioConsultaSinFacturaBean.renderModificar}"
                                     action="#{consultarUsuarioConsultaSinFacturaBean.buscadorUsuario}" 
                                     image="/comun/imagenes/lupita.png"
                                     reRender="formDatosUsuarios"/>
                   
                </h:panelGrid>
               
                <a4j:outputPanel ajaxRendered="true">
                  <t:message for="itNumeroIdentificacion" styleClass="errorMessage"/>
                </a4j:outputPanel>
                <h:outputText id="idtipo" value="#{consultarUsuarioConsultaSinFacturaBean.usuario.huslnumero}"></h:outputText>
                <h:outputText/>
                <h:outputText/>
                <h:outputText/>
                <h:outputText value="Primer Nombre" styleClass="labelTextOblig"
                              rendered="#{consultarUsuarioConsultaSinFacturaBean.renderUsuario || consultarUsuarioConsultaSinFacturaBean.renderModificar}"/>
                <h:outputText value=""
                              rendered="#{consultarUsuarioConsultaSinFacturaBean.renderUsuario || consultarUsuarioConsultaSinFacturaBean.renderModificar}"/>
                <h:outputText value="Segundo Nombre"
                              rendered="#{consultarUsuarioConsultaSinFacturaBean.renderUsuario || consultarUsuarioConsultaSinFacturaBean.renderModificar}"/>
                <h:outputText value=""
                              rendered="#{consultarUsuarioConsultaSinFacturaBean.renderUsuario || consultarUsuarioConsultaSinFacturaBean.renderModificar}"/>
                <h:outputText value="Primer Apellido" styleClass="labelTextOblig"
                              rendered="#{consultarUsuarioConsultaSinFacturaBean.renderUsuario || consultarUsuarioConsultaSinFacturaBean.renderModificar}"/>
                <h:outputText value=""
                              rendered="#{consultarUsuarioConsultaSinFacturaBean.renderUsuario || consultarUsuarioConsultaSinFacturaBean.renderModificar}"/>
                <h:outputText value="Segundo Apellido"
                              rendered="#{consultarUsuarioConsultaSinFacturaBean.renderUsuario || consultarUsuarioConsultaSinFacturaBean.renderModificar}"/>
                <h:outputText value=""
                              rendered="#{consultarUsuarioConsultaSinFacturaBean.renderUsuario || consultarUsuarioConsultaSinFacturaBean.renderModificar}"/>
                <h:inputText id="primerNombre" onkeydown="return blockEnter(event);" maxlength="20"
                             styleClass="textmayuscula"
                             rendered="#{consultarUsuarioConsultaSinFacturaBean.renderUsuario || consultarUsuarioConsultaSinFacturaBean.renderModificar}"
                             value="#{consultarUsuarioConsultaSinFacturaBean.usuario.huscprimernomb}">
                              <f:validator validatorId="cadena.stringValidator"/>
                             </h:inputText>
                <a4j:outputPanel ajaxRendered="true"
                                 rendered="#{consultarUsuarioConsultaSinFacturaBean.renderUsuario || consultarUsuarioConsultaSinFacturaBean.renderModificar}">
                  <t:message for="primerNombre" styleClass="errorMessage"/>
                </a4j:outputPanel>
                <h:inputText id="segundoNombre" onkeydown="return blockEnter(event);" styleClass="textmayuscula"
                             rendered="#{consultarUsuarioConsultaSinFacturaBean.renderUsuario || consultarUsuarioConsultaSinFacturaBean.renderModificar}"
                             value="#{consultarUsuarioConsultaSinFacturaBean.usuario.huscsegundnomb}" maxlength="20">
                              <f:validator validatorId="cadena.stringValidator"/>
                              </h:inputText>
                <a4j:outputPanel ajaxRendered="true"
                                 rendered="#{consultarUsuarioConsultaSinFacturaBean.renderUsuario || consultarUsuarioConsultaSinFacturaBean.renderModificar}">
                  <t:message for="segundoNombre" styleClass="errorMessage"/>
                </a4j:outputPanel>
                <h:inputText id="primerApellido" onkeydown="return blockEnter(event);" maxlength="20"
                             styleClass="textmayuscula"
                             rendered="#{consultarUsuarioConsultaSinFacturaBean.renderUsuario || consultarUsuarioConsultaSinFacturaBean.renderModificar}"
                             value="#{consultarUsuarioConsultaSinFacturaBean.usuario.huscprimerapel}">
                             <f:validator validatorId="cadena.stringValidator"/>
                             </h:inputText>
                <a4j:outputPanel ajaxRendered="true"
                                 rendered="#{consultarUsuarioConsultaSinFacturaBean.renderUsuario || consultarUsuarioConsultaSinFacturaBean.renderModificar}">
                  <t:message for="primerApellido" styleClass="errorMessage"/>
                </a4j:outputPanel>
                <h:inputText id="segundoApellido" onkeydown="return blockEnter(event);" maxlength="20"
                             styleClass="textmayuscula"
                             rendered="#{consultarUsuarioConsultaSinFacturaBean.renderUsuario || consultarUsuarioConsultaSinFacturaBean.renderModificar}"
                             value="#{consultarUsuarioConsultaSinFacturaBean.usuario.huscsegundapel}">
                             <f:validator validatorId="cadena.stringValidator"/>
                             </h:inputText>
                <a4j:outputPanel ajaxRendered="true"
                                 rendered="#{consultarUsuarioConsultaSinFacturaBean.renderUsuario || consultarUsuarioConsultaSinFacturaBean.renderModificar}">
                  <t:message for="segundoApellido" styleClass="errorMessage"/>
                </a4j:outputPanel>
                <h:outputText value="Fecha Nacimiento" styleClass="labelTextOblig"
                              rendered="#{consultarUsuarioConsultaSinFacturaBean.renderUsuario || consultarUsuarioConsultaSinFacturaBean.renderModificar}"/>
                <h:outputText value=""
                              rendered="#{consultarUsuarioConsultaSinFacturaBean.renderUsuario || consultarUsuarioConsultaSinFacturaBean.renderModificar}"/>
                <h:outputText value="Edad" styleClass="labelTextOblig"
                              rendered="#{consultarUsuarioConsultaSinFacturaBean.renderUsuario || consultarUsuarioConsultaSinFacturaBean.renderModificar}"/>
                <h:outputText value=""
                              rendered="#{consultarUsuarioConsultaSinFacturaBean.renderUsuario || consultarUsuarioConsultaSinFacturaBean.renderModificar}"/>
                <h:outputText value="Sexo" styleClass="labelTextOblig"
                              rendered="#{consultarUsuarioConsultaSinFacturaBean.renderUsuario || consultarUsuarioConsultaSinFacturaBean.renderModificar}"/>
                <h:outputText value=""
                              rendered="#{consultarUsuarioConsultaSinFacturaBean.renderUsuario || consultarUsuarioConsultaSinFacturaBean.renderModificar}"/>
                <h:outputText value="Escolaridad" styleClass="labelTextOblig"
                              rendered="#{consultarUsuarioConsultaSinFacturaBean.renderUsuario || consultarUsuarioConsultaSinFacturaBean.renderModificar}"/>
                <h:outputText value=""
                              rendered="#{consultarUsuarioConsultaSinFacturaBean.renderUsuario || consultarUsuarioConsultaSinFacturaBean.renderModificar}"/>
                <t:inputCalendar id="fechaNacimiento"
                                 rendered="#{consultarUsuarioConsultaSinFacturaBean.renderUsuario || consultarUsuarioConsultaSinFacturaBean.renderModificar}"
                                 monthYearRowClass="yearMonthHeader" weekRowClass="weekHeader"
                                 title="Formato: dd/mm/yyyy" currentDayCellClass="currentDayCell"
                                 popupDateFormat="dd/MM/yyyy" renderAsPopup="true" disabled="false"
                                 value="#{consultarUsuarioConsultaSinFacturaBean.usuario.husdfechanacim}"
                                 popupTodayString="Hoy" popupWeekString="Semana" popupButtonString="Fecha"
                                 readonly="false" maxlength="11" size="11"
                                 popupButtonImageUrl="/comun/imagenes/ico_calendario2.gif"
                                 renderPopupButtonAsImage="true" align="top">
                  <f:validator validatorId="dateMenorActualValidator"/>
                  <a4j:support id="supportNacimiento" event="onchange" reRender="panelEdad">
                    <a4j:ajaxListener type="org.ajax4jsf.ajax.ForceRender"/>
                  </a4j:support>
                </t:inputCalendar>
                <a4j:outputPanel ajaxRendered="true"
                                 rendered="#{consultarUsuarioConsultaSinFacturaBean.renderUsuario || consultarUsuarioConsultaSinFacturaBean.renderModificar}">
                  <t:message for="fechaNacimiento" styleClass="errorMessage"/>
                </a4j:outputPanel>
                <h:panelGroup id="panelEdad">
                  <h:inputText id="inputEdad" onkeydown="return blockEnter(event);" maxlength="4" disabled="true"
                               rendered="#{consultarUsuarioConsultaSinFacturaBean.renderUsuario || consultarUsuarioConsultaSinFacturaBean.renderModificar}"
                               value="#{consultarUsuarioConsultaSinFacturaBean.usuario.edad}"/>
                </h:panelGroup>
                <h:outputText value=""/>
                <h:selectOneMenu id="radioSexo" onkeydown="return blockEnter(event);"
                                 rendered="#{consultarUsuarioConsultaSinFacturaBean.renderUsuario || consultarUsuarioConsultaSinFacturaBean.renderModificar}"
                                 value="#{consultarUsuarioConsultaSinFacturaBean.usuario.husesexo}">
                  <f:selectItems value="#{consultarUsuarioConsultaSinFacturaBean.listSexos}"/>
                </h:selectOneMenu>
                <a4j:outputPanel ajaxRendered="true"
                                 rendered="#{consultarUsuarioConsultaSinFacturaBean.renderUsuario || consultarUsuarioConsultaSinFacturaBean.renderModificar}">
                  <t:message for="radioSexo" styleClass="errorMessage"/>
                </a4j:outputPanel>
                <h:selectOneMenu id="itNivelEducativo"
                                 value="#{consultarUsuarioConsultaSinFacturaBean.usuario.husnniveledu}"
                                 rendered="#{consultarUsuarioConsultaSinFacturaBean.renderUsuario || consultarUsuarioConsultaSinFacturaBean.renderModificar}">
                  <f:selectItems value="#{consultarUsuarioConsultaSinFacturaBean.lstNivelEducativo}"/>
                </h:selectOneMenu>
                <a4j:outputPanel ajaxRendered="true"
                                 rendered="#{consultarUsuarioConsultaSinFacturaBean.renderUsuario || consultarUsuarioConsultaSinFacturaBean.renderModificar}">
                  <t:message for="itNivelEducativo" styleClass="errorMessage"/>
                </a4j:outputPanel>
                <h:outputText value="Estrato "
                              rendered="#{consultarUsuarioConsultaSinFacturaBean.renderUsuario || consultarUsuarioConsultaSinFacturaBean.renderModificar}"/>
                <h:outputText value=""
                              rendered="#{consultarUsuarioConsultaSinFacturaBean.renderUsuario || consultarUsuarioConsultaSinFacturaBean.renderModificar}"/>
                <h:outputText value="Estado Civil"
                              rendered="#{consultarUsuarioConsultaSinFacturaBean.renderUsuario || consultarUsuarioConsultaSinFacturaBean.renderModificar}"/>
                <h:outputText value=""
                              rendered="#{consultarUsuarioConsultaSinFacturaBean.renderUsuario || consultarUsuarioConsultaSinFacturaBean.renderModificar}"/>
                <h:outputText value="Correo Electrónico"
                              rendered="#{consultarUsuarioConsultaSinFacturaBean.renderUsuario || consultarUsuarioConsultaSinFacturaBean.renderModificar}"/>
                <h:outputText value=""
                              rendered="#{consultarUsuarioConsultaSinFacturaBean.renderUsuario || consultarUsuarioConsultaSinFacturaBean.renderModificar}"/>
                <h:outputText value="Etnia" styleClass="labelTextOblig"
                              rendered="#{consultarUsuarioConsultaSinFacturaBean.renderUsuario || consultarUsuarioConsultaSinFacturaBean.renderModificar}"/>
                <h:outputText value=""
                              rendered="#{consultarUsuarioConsultaSinFacturaBean.renderUsuario || consultarUsuarioConsultaSinFacturaBean.renderModificar}"/>
                <h:selectOneRadio id="mnuEstrato" onkeydown="return blockEnter(event);"
                                  rendered="#{consultarUsuarioConsultaSinFacturaBean.renderUsuario || consultarUsuarioConsultaSinFacturaBean.renderModificar}"
                                  value="#{consultarUsuarioConsultaSinFacturaBean.usuario.husnestrato}">
                  <f:selectItems value="#{consultarUsuarioConsultaSinFacturaBean.listEstrato}"/>
                </h:selectOneRadio>
                <a4j:outputPanel ajaxRendered="true"
                                 rendered="#{consultarUsuarioConsultaSinFacturaBean.renderUsuario || consultarUsuarioConsultaSinFacturaBean.renderModificar}">
                  <t:message for="mnuEstrato" styleClass="errorMessage"/>
                </a4j:outputPanel>
                <h:selectOneMenu id="radioEstadoCivil" onkeydown="return blockEnter(event);"
                                 rendered="#{consultarUsuarioConsultaSinFacturaBean.renderUsuario || consultarUsuarioConsultaSinFacturaBean.renderModificar}"
                                 value="#{consultarUsuarioConsultaSinFacturaBean.usuario.huseestadcivil}">
                  <f:selectItems value="#{consultarUsuarioConsultaSinFacturaBean.listEstadoCivil}"/>
                </h:selectOneMenu>
                <a4j:outputPanel ajaxRendered="true"
                                 rendered="#{consultarUsuarioConsultaSinFacturaBean.renderUsuario || consultarUsuarioConsultaSinFacturaBean.renderModificar}">
                  <t:message for="radioEstadoCivil" styleClass="errorMessage"/>
                </a4j:outputPanel>
                <h:inputText id="itCorreo" maxlength="30" onkeydown="return blockEnter(event);"
                             rendered="#{consultarUsuarioConsultaSinFacturaBean.renderUsuario || consultarUsuarioConsultaSinFacturaBean.renderModificar}"
                             value="#{consultarUsuarioConsultaSinFacturaBean.usuario.husccorreoelec}"/>
                <a4j:outputPanel ajaxRendered="true"
                                 rendered="#{consultarUsuarioConsultaSinFacturaBean.renderUsuario || consultarUsuarioConsultaSinFacturaBean.renderModificar}">
                  <t:message for="itCorreo" styleClass="errorMessage"/>
                </a4j:outputPanel>
                <h:selectOneMenu id="radioEtnia" onkeydown="return blockEnter(event);"
                                 rendered="#{consultarUsuarioConsultaSinFacturaBean.renderUsuario || consultarUsuarioConsultaSinFacturaBean.renderModificar}"
                                 value="#{consultarUsuarioConsultaSinFacturaBean.usuario.huscetnia}">
                  <f:selectItems value="#{consultarUsuarioConsultaSinFacturaBean.lstEtnia}"/>
                </h:selectOneMenu>
                <a4j:outputPanel ajaxRendered="true"
                                 rendered="#{consultarUsuarioConsultaSinFacturaBean.renderUsuario || consultarUsuarioConsultaSinFacturaBean.renderModificar}">
                  <t:message for="radioEtnia" styleClass="errorMessage"/>
                </a4j:outputPanel>
                <h:outputText value="Dirección"
                              rendered="#{consultarUsuarioConsultaSinFacturaBean.renderUsuario || consultarUsuarioConsultaSinFacturaBean.renderModificar}"
                              styleClass="labelTextOblig"/>
                <h:outputText value=""
                              rendered="#{consultarUsuarioConsultaSinFacturaBean.renderUsuario || consultarUsuarioConsultaSinFacturaBean.renderModificar}"/>
                <h:outputText value="Barrio "
                              rendered="#{consultarUsuarioConsultaSinFacturaBean.renderUsuario || consultarUsuarioConsultaSinFacturaBean.renderModificar}"
                              styleClass="labelTextOblig"/>
                <h:outputText value=""
                              rendered="#{consultarUsuarioConsultaSinFacturaBean.renderUsuario || consultarUsuarioConsultaSinFacturaBean.renderModificar}"/>
                <h:outputText value="Teléfono"
                              rendered="#{consultarUsuarioConsultaSinFacturaBean.renderUsuario || consultarUsuarioConsultaSinFacturaBean.renderModificar}"
                              styleClass="labelTextOblig"/>
                <h:outputText value=""
                              rendered="#{consultarUsuarioConsultaSinFacturaBean.renderUsuario || consultarUsuarioConsultaSinFacturaBean.renderModificar}"/>
                <h:outputText value="Teléfono Movil" styleClass="labelTextOblig"
                              rendered="#{consultarUsuarioConsultaSinFacturaBean.renderUsuario || consultarUsuarioConsultaSinFacturaBean.renderModificar}"/>
                <h:outputText value=""
                              rendered="#{consultarUsuarioConsultaSinFacturaBean.renderUsuario || consultarUsuarioConsultaSinFacturaBean.renderModificar}"/>
                <h:inputText id="Direccion" maxlength="20" onkeydown="return blockEnter(event);"
                             rendered="#{consultarUsuarioConsultaSinFacturaBean.renderUsuario || consultarUsuarioConsultaSinFacturaBean.renderModificar}"
                             value="#{consultarUsuarioConsultaSinFacturaBean.usuario.huscdireccion}">
                              <f:validator validatorId="cadena.stringValidator"/>
                              </h:inputText>
                <a4j:outputPanel ajaxRendered="true"
                                 rendered="#{consultarUsuarioConsultaSinFacturaBean.renderUsuario || consultarUsuarioConsultaSinFacturaBean.renderModificar}">
                  <t:message for="Direccion" styleClass="errorMessage"/>
                </a4j:outputPanel>
                <h:inputText id="itBarrio" onkeydown="return blockEnter(event);" maxlength="20"
                             rendered="#{consultarUsuarioConsultaSinFacturaBean.renderUsuario || consultarUsuarioConsultaSinFacturaBean.renderModificar}"
                             value="#{consultarUsuarioConsultaSinFacturaBean.usuario.huscbarrio}">
                              <f:validator validatorId="cadena.stringValidator"/>
                              </h:inputText>
                <a4j:outputPanel ajaxRendered="true"
                                 rendered="#{consultarUsuarioConsultaSinFacturaBean.renderUsuario || consultarUsuarioConsultaSinFacturaBean.renderModificar}">
                  <t:message for="itBarrio" styleClass="errorMessage"/>
                </a4j:outputPanel>
                <h:inputText id="Telefono" maxlength="20" onkeydown="return blockEnter(event);"
                             rendered="#{consultarUsuarioConsultaSinFacturaBean.renderUsuario || consultarUsuarioConsultaSinFacturaBean.renderModificar}"
                             value="#{consultarUsuarioConsultaSinFacturaBean.usuario.husctelefono}">
                              <f:validator validatorId="cadena.stringValidator"/>
                              </h:inputText>
                <a4j:outputPanel ajaxRendered="true"
                                 rendered="#{consultarUsuarioConsultaSinFacturaBean.renderUsuario || consultarUsuarioConsultaSinFacturaBean.renderModificar}">
                  <t:message for="Telefono" styleClass="errorMessage"/>
                </a4j:outputPanel>
                <h:inputText id="TelefonoMovil" maxlength="20" onkeydown="return blockEnter(event);"
                             rendered="#{consultarUsuarioConsultaSinFacturaBean.renderUsuario || consultarUsuarioConsultaSinFacturaBean.renderModificar}"
                             value="#{consultarUsuarioConsultaSinFacturaBean.usuario.husccelular}">
                              <f:validator validatorId="cadena.stringValidator"/>
                             </h:inputText>
                <a4j:outputPanel ajaxRendered="true"
                                 rendered="#{consultarUsuarioConsultaSinFacturaBean.renderUsuario || consultarUsuarioConsultaSinFacturaBean.renderModificar}">
                  <t:message for="TelefonoMovil" styleClass="errorMessage"/>
                </a4j:outputPanel>
                <h:outputText value="País de residencia habitual" styleClass="labelTextOblig"
                              rendered="#{consultarUsuarioConsultaSinFacturaBean.renderUsuario || consultarUsuarioConsultaSinFacturaBean.renderModificar}"/>
                <h:outputText value=""
                              rendered="#{consultarUsuarioConsultaSinFacturaBean.renderUsuario || consultarUsuarioConsultaSinFacturaBean.renderModificar}"/>
                <h:outputText value="Departamento" styleClass="labelTextOblig"
                              rendered="#{consultarUsuarioConsultaSinFacturaBean.renderUsuario || consultarUsuarioConsultaSinFacturaBean.renderModificar}"/>
                <h:outputText value=""
                              rendered="#{consultarUsuarioConsultaSinFacturaBean.renderUsuario || consultarUsuarioConsultaSinFacturaBean.renderModificar}"/>
                <h:outputText value="Municipio" styleClass="labelTextOblig"
                              rendered="#{consultarUsuarioConsultaSinFacturaBean.renderUsuario || consultarUsuarioConsultaSinFacturaBean.renderModificar}"/>
                <h:outputText value=""
                              rendered="#{consultarUsuarioConsultaSinFacturaBean.renderUsuario || consultarUsuarioConsultaSinFacturaBean.renderModificar}"/>
                <h:outputText value="Tipo de Afiliación" styleClass="labelTextOblig"
                              rendered="#{consultarUsuarioConsultaSinFacturaBean.renderUsuario || consultarUsuarioConsultaSinFacturaBean.renderModificar}"/>
                <h:outputText value=" "
                              rendered="#{consultarUsuarioConsultaSinFacturaBean.renderUsuario || consultarUsuarioConsultaSinFacturaBean.renderModificar}"/>

                <h:selectOneMenu id="menuPais" onkeydown="return blockEnter(event);"
                              rendered="#{consultarUsuarioConsultaSinFacturaBean.renderUsuario || consultarUsuarioConsultaSinFacturaBean.renderModificar}"
                              value="#{consultarUsuarioConsultaSinFacturaBean.usuario.huscpaisresi}">
                    <f:selectItems value="#{consultarUsuarioConsultaSinFacturaBean.listPaises}"/>
                </h:selectOneMenu>
                <a4j:outputPanel ajaxRendered="true"
                              rendered="#{consultarUsuarioConsultaSinFacturaBean.renderUsuario || consultarUsuarioConsultaSinFacturaBean.renderModificar}">
                    <t:message for="menuPais" styleClass="errorMessage"/>
                </a4j:outputPanel>

                <h:selectOneMenu id="menuDepartamentos" onkeydown="return blockEnter(event);"
                                 rendered="#{consultarUsuarioConsultaSinFacturaBean.renderUsuario || consultarUsuarioConsultaSinFacturaBean.renderModificar}"
                                 value="#{consultarUsuarioConsultaSinFacturaBean.usuario.husndepartamen}"
                                 valueChangeListener="#{consultarUsuarioConsultaSinFacturaBean.setDepartamentoSelect}">
                  <f:selectItems value="#{consultarUsuarioConsultaSinFacturaBean.listDepartamentos}"/>
                  <a4j:support id="support7" action="#{consultarUsuarioConsultaSinFacturaBean.changeCiudad}"
                               reRender="panelRegionInfoConsulta" event="onchange">
                    <a4j:ajaxListener type="org.ajax4jsf.ajax.ForceRender"/>
                  </a4j:support>
                </h:selectOneMenu>
                <a4j:outputPanel ajaxRendered="true"
                                 rendered="#{consultarUsuarioConsultaSinFacturaBean.renderUsuario || consultarUsuarioConsultaSinFacturaBean.renderModificar}">
                  <t:message for="menuDepartamentos" styleClass="errorMessage"/>
                </a4j:outputPanel>
                <h:selectOneMenu id="menuCiudad" onkeydown="return blockEnter(event);"
                                 rendered="#{consultarUsuarioConsultaSinFacturaBean.renderUsuario || consultarUsuarioConsultaSinFacturaBean.renderModificar}"
                                 value="#{consultarUsuarioConsultaSinFacturaBean.usuario.husnciudad}">
                  <f:selectItems value="#{consultarUsuarioConsultaSinFacturaBean.listMunicipios}"/>
                </h:selectOneMenu>
                <a4j:outputPanel ajaxRendered="true"
                                 rendered="#{consultarUsuarioConsultaSinFacturaBean.renderUsuario || consultarUsuarioConsultaSinFacturaBean.renderModificar}">
                  <t:message for="menuCiudad" styleClass="errorMessage"/>
                </a4j:outputPanel>
                <h:selectOneMenu id="menuAfiliacion" onkeydown="return blockEnter(event);"
                                 rendered="#{consultarUsuarioConsultaSinFacturaBean.renderUsuario || consultarUsuarioConsultaSinFacturaBean.renderModificar}"
                                 value="#{consultarUsuarioConsultaSinFacturaBean.usuario.husetipoafilia}"
                                 immediate="true"
                                 valueChangeListener="#{consultarUsuarioConsultaSinFacturaBean.setHusetipoafilia}">
                  <f:selectItems value="#{consultarUsuarioConsultaSinFacturaBean.listTipoAfiliacion}"/>
                  <a4j:support id="supportAfiliacion" event="onchange" immediate="true"
                               action="#{consultarUsuarioConsultaSinFacturaBean.changeAfiliacion}"
                               reRender="panelInputEps,paneltextEps,paneltextAfili,panelInputAfili,paneltextVincula,panelRadioVincula">
                    <a4j:ajaxListener type="org.ajax4jsf.ajax.ForceRender"/>
                  </a4j:support>
                </h:selectOneMenu>
                <a4j:outputPanel ajaxRendered="true"
                                 rendered="#{consultarUsuarioConsultaSinFacturaBean.renderUsuario || consultarUsuarioConsultaSinFacturaBean.renderModificar}">
                  <t:message for="menuAfiliacion" styleClass="errorMessage"/>
                </a4j:outputPanel>
                <h:panelGroup id="paneltextEps">
                  <h:outputText value="EPS" styleClass="labelTextOblig"
                                rendered="#{consultarUsuarioConsultaSinFacturaBean.mostrarAfiliacion}"/>
                </h:panelGroup>
                <h:outputText value=" "
                              rendered="#{consultarUsuarioConsultaSinFacturaBean.renderUsuario || consultarUsuarioConsultaSinFacturaBean.renderModificar}"/>
                <h:panelGroup id="paneltextAfili">
                  <h:outputText value="Número de Afiliación"
                                rendered="#{consultarUsuarioConsultaSinFacturaBean.mostrarAfiliacion}"/>
                </h:panelGroup>
                <h:outputText value=" "
                              rendered="#{consultarUsuarioConsultaSinFacturaBean.renderUsuario || consultarUsuarioConsultaSinFacturaBean.renderModificar}"/>
                <h:panelGroup id="paneltextVincula">
                  <h:outputText value="Tipo de Vinculación" styleClass="labelTextOblig"
                                rendered="#{consultarUsuarioConsultaSinFacturaBean.mostrarAfiliacion}"/>
                </h:panelGroup>
                <h:outputText value=" "
                              rendered="#{consultarUsuarioConsultaSinFacturaBean.renderUsuario || consultarUsuarioConsultaSinFacturaBean.renderModificar}"/>
                <h:outputText value="Como conoce de Profamilia" styleClass="labelTextOblig"
                              rendered="#{consultarUsuarioConsultaSinFacturaBean.renderUsuario || consultarUsuarioConsultaSinFacturaBean.renderModificar}"/>
                <h:outputText value=" "
                              rendered="#{consultarUsuarioConsultaSinFacturaBean.renderUsuario || consultarUsuarioConsultaSinFacturaBean.renderModificar}"/>
                <h:panelGroup id="panelInputEps"
                              rendered="#{consultarUsuarioConsultaSinFacturaBean.renderUsuario || consultarUsuarioConsultaSinFacturaBean.renderModificar}">
                  <a4j:region renderRegionOnly="false">
                    <h:inputText id="itEps" value="#{consultarUsuarioConsultaSinFacturaBean.usuario.huscentidadadm}"
                                 valueChangeListener="#{consultarUsuarioConsultaSinFacturaBean.setEps}" immediate="true"
                                 binding="#{consultarUsuarioConsultaSinFacturaBean.itEps}" style="width:100px"
                                 styleClass="textmayuscula"
                                 rendered="#{consultarUsuarioConsultaSinFacturaBean.mostrarAfiliacion}">
                      <f:validateLength maximum="40"/>
                      <a4j:support id="supportitDiagPrin" event="onchange"
                                   action="#{consultarUsuarioConsultaSinFacturaBean.changeSeleccionEps}"
                                   reRender="panelEpsSeleccion" immediate="true">
                        <a4j:ajaxListener type="org.ajax4jsf.ajax.ForceRender"/>
                      </a4j:support>
                    </h:inputText>
                    <h:commandLink action="#{consultarUsuarioConsultaSinFacturaBean.renderEps}"
                                   rendered="#{consultarUsuarioConsultaSinFacturaBean.mostrarAfiliacion}">
                      <t:graphicImage alt="" border="0" url="/comun/imagenes/lupita.png"/>
                    </h:commandLink>
                    <h:panelGrid columns="1" border="0" cellpadding="0" cellspacing="2" id="panelEpsSeleccion"
                                 rendered="#{consultarUsuarioConsultaSinFacturaBean.mostrarAfiliacion}">
                      <h:outputText value=" #{consultarUsuarioConsultaSinFacturaBean.seleccionEps}"
                                    styleClass="buscador"/>
                    </h:panelGrid>
                  </a4j:region>
                </h:panelGroup>
                <a4j:outputPanel ajaxRendered="true">
                  <t:message for="itEps" styleClass="errorMessage"/>
                </a4j:outputPanel>
                <h:panelGroup id="panelInputAfili">
                  <h:inputText id="itNumeroAfiliacion" onkeydown="return blockEnter(event);" maxlength="20"
                               rendered="#{consultarUsuarioConsultaSinFacturaBean.mostrarAfiliacion}"
                               value="#{consultarUsuarioConsultaSinFacturaBean.usuario.huscnumafiliac}"></h:inputText>
                </h:panelGroup>
                <a4j:outputPanel ajaxRendered="true"
                                 rendered="#{consultarUsuarioConsultaSinFacturaBean.renderUsuario || consultarUsuarioConsultaSinFacturaBean.renderModificar}">
                  <t:message for="itNumeroAfiliacion" styleClass="errorMessage"/>
                </a4j:outputPanel>
                <h:panelGroup id="panelRadioVincula">
                  <h:selectOneRadio id="radioVinculacion" onkeydown="return blockEnter(event);"
                                    rendered="#{consultarUsuarioConsultaSinFacturaBean.mostrarAfiliacion}"
                                    value="#{consultarUsuarioConsultaSinFacturaBean.usuario.husetipvincula}">
                    <f:selectItems value="#{consultarUsuarioConsultaSinFacturaBean.lstTipoVinculacion}"/>
                  </h:selectOneRadio>
                </h:panelGroup>
                <a4j:outputPanel ajaxRendered="true"
                                 rendered="#{consultarUsuarioConsultaSinFacturaBean.renderUsuario || consultarUsuarioConsultaSinFacturaBean.renderModificar}">
                  <t:message for="radioVinculacion" styleClass="errorMessage"/>
                </a4j:outputPanel>
                <h:selectOneMenu id="menuConoceProfamilia"
                                 value="#{consultarUsuarioConsultaSinFacturaBean.usuario.husnconoprofam}"
                                 rendered="#{consultarUsuarioConsultaSinFacturaBean.renderUsuario || consultarUsuarioConsultaSinFacturaBean.renderModificar}"
                                 onkeydown="return blockEnter(event);">
                  <f:selectItems value="#{consultarUsuarioConsultaSinFacturaBean.lstConoceProfamilia}"/>
                </h:selectOneMenu>
                <a4j:outputPanel ajaxRendered="true"
                                 rendered="#{consultarUsuarioConsultaSinFacturaBean.renderUsuario || consultarUsuarioConsultaSinFacturaBean.renderModificar}">
                  <t:message for="menuConoceProfamilia" styleClass="errorMessage"/>
                </a4j:outputPanel>
                <h:outputText value="Zona " styleClass="labelTextOblig"
                              rendered="#{consultarUsuarioConsultaSinFacturaBean.renderUsuario || consultarUsuarioConsultaSinFacturaBean.renderModificar}"/>
                <h:outputText value=" "
                              rendered="#{consultarUsuarioConsultaSinFacturaBean.renderUsuario || consultarUsuarioConsultaSinFacturaBean.renderModificar}"/>
                <h:outputText value="Ocupación" styleClass="labelTextOblig"
                              rendered="#{consultarUsuarioConsultaSinFacturaBean.renderUsuario || consultarUsuarioConsultaSinFacturaBean.renderModificar}"/>
                <h:outputText value=" "
                              rendered="#{consultarUsuarioConsultaSinFacturaBean.renderUsuario || consultarUsuarioConsultaSinFacturaBean.renderModificar}"/>
                <h:outputText value="Tipo de Cliente" styleClass="labelTextOblig"
                              rendered="#{consultarUsuarioConsultaSinFacturaBean.renderUsuario || consultarUsuarioConsultaSinFacturaBean.renderModificar}"/>
                <h:outputText value=" "
                              rendered="#{consultarUsuarioConsultaSinFacturaBean.renderUsuario || consultarUsuarioConsultaSinFacturaBean.renderModificar}"/>
                <h:panelGroup id="paneltextOtroTipoCliente">
                  <h:outputText value="Numero de Contrato" styleClass="labelTextOblig"
                                rendered="#{consultarUsuarioConsultaSinFacturaBean.mostrarContrato}"/>
                </h:panelGroup>
                <h:outputText value=" "
                              rendered="#{consultarUsuarioConsultaSinFacturaBean.renderUsuario || consultarUsuarioConsultaSinFacturaBean.renderModificar}"/>
                <h:selectOneRadio id="radioZona" onkeydown="return blockEnter(event);"
                                  rendered="#{consultarUsuarioConsultaSinFacturaBean.renderUsuario || consultarUsuarioConsultaSinFacturaBean.renderModificar}"
                                  value="#{consultarUsuarioConsultaSinFacturaBean.usuario.husezonareside}">
                  <f:selectItems value="#{consultarUsuarioConsultaSinFacturaBean.listzona}"/>
                </h:selectOneRadio>
                <a4j:outputPanel ajaxRendered="true"
                                 rendered="#{consultarUsuarioConsultaSinFacturaBean.renderUsuario || consultarUsuarioConsultaSinFacturaBean.renderModificar}">
                  <t:message for="radioZona" styleClass="errorMessage"/>
                </a4j:outputPanel>
                <h:panelGroup rendered="#{consultarUsuarioConsultaSinFacturaBean.renderUsuario || consultarUsuarioConsultaSinFacturaBean.renderModificar}">
                  <a4j:region renderRegionOnly="false">
                    <h:inputText id="itOcupacion" value="#{consultarUsuarioConsultaSinFacturaBean.usuario.husnocupacion}"
                                 valueChangeListener="#{consultarUsuarioConsultaSinFacturaBean.setOcupacion}"
                                 binding="#{consultarUsuarioConsultaSinFacturaBean.itOcupacion}" immediate="true"
                                 style="width:100px">
                      <f:validateLength maximum="40"/>
                      <a4j:support id="supportOcupa" event="onchange"
                                   action="#{consultarUsuarioConsultaSinFacturaBean.changeSeleccionOcupacion}"
                                   reRender="panelOcupacionSeleccion" immediate="true">
                        <a4j:ajaxListener type="org.ajax4jsf.ajax.ForceRender"/>
                      </a4j:support>
                    </h:inputText>
                    <h:commandLink action="#{consultarUsuarioConsultaSinFacturaBean.renderOcupacion}">
                      <t:graphicImage alt="" border="0" url="/comun/imagenes/lupita.png"/>
                    </h:commandLink>
                    <h:panelGrid columns="1" border="0" cellpadding="0" cellspacing="2" id="panelOcupacionSeleccion">
                      <h:outputText value=" #{consultarUsuarioConsultaSinFacturaBean.seleccionOcupacion}"
                                    styleClass="buscador"/>
                    </h:panelGrid>
                  </a4j:region>
                </h:panelGroup>
                <a4j:outputPanel ajaxRendered="true">
                  <t:message for="itOcupacion" styleClass="errorMessage"/>
                </a4j:outputPanel>
                <h:panelGroup>
                  <h:selectOneMenu id="menuCliente"
                                   value="#{consultarUsuarioConsultaSinFacturaBean.usuario.husetipcliente}"
                                   rendered="#{consultarUsuarioConsultaSinFacturaBean.renderUsuario || consultarUsuarioConsultaSinFacturaBean.renderModificar}"
                                   onkeydown="return blockEnter(event);" immediate="true"
                                   valueChangeListener="#{consultarUsuarioConsultaSinFacturaBean.setHusetipcliente}">
                    <f:selectItems value="#{consultarUsuarioConsultaSinFacturaBean.listTipoCliente}"/>
                    <a4j:support id="supportContratoCredito" event="onchange" immediate="true"
                                 action="#{consultarUsuarioConsultaSinFacturaBean.changeContrato}"
                                 reRender="panelInputOtroTipoCliente,paneltextOtroTipoCliente">
                      <a4j:ajaxListener type="org.ajax4jsf.ajax.ForceRender"/>
                    </a4j:support>
                  </h:selectOneMenu>
                </h:panelGroup>
                <a4j:outputPanel ajaxRendered="true"
                                 rendered="#{consultarUsuarioConsultaSinFacturaBean.renderUsuario || consultarUsuarioConsultaSinFacturaBean.renderModificar}">
                  <t:message for="menuCliente" styleClass="errorMessage"/>
                </a4j:outputPanel>
                <h:panelGroup id="panelInputOtroTipoCliente">
                  <h:inputText id="inputOtroTipoCliente" maxlength="50" onkeydown="return blockEnter(event);"
                               required="false" rendered="#{consultarUsuarioConsultaSinFacturaBean.mostrarContrato}"
                               value="#{consultarUsuarioConsultaSinFacturaBean.usuario.husnnumecontr}"/>
                  <a4j:outputPanel ajaxRendered="true">
                    <t:message for="inputOtroTipoCliente" styleClass="errorMessage"/>
                  </a4j:outputPanel>
                </h:panelGroup>
              </h:panelGrid>
              
                <h:panelGrid columns="4" border="0" cellpadding="0" cellspacing="0">
                <h:outputText value=""/>
                <h:outputText value=""/>
                <h:outputText value=""/>
                    
                </h:panelGrid>
            </s:fieldset>
           
            <s:fieldset legend="Datos Acompañante" id="fieldSetInfoAcompaAsesoria" styleClass="fieldset"
                        rendered="#{consultarUsuarioConsultaSinFacturaBean.renderUsuario || consultarUsuarioConsultaSinFacturaBean.renderModificar}">
              <h:panelGrid columns="3" border="0" cellpadding="0" cellspacing="0" width="100%"
                           id="panelRegionInfoAcompa" rowClasses="labelText,labelTextInfo">
                <h:outputText value="Nombre Responsable" styleClass="labelTextOblig"
                              rendered="#{consultarUsuarioConsultaSinFacturaBean.renderUsuario || consultarUsuarioConsultaSinFacturaBean.renderModificar}"/>
                <h:outputText value="Teléfono Responsable"
                              rendered="#{consultarUsuarioConsultaSinFacturaBean.renderUsuario || consultarUsuarioConsultaSinFacturaBean.renderModificar}"/>
                <h:outputText value="Parentesco Responsable"
                              rendered="#{consultarUsuarioConsultaSinFacturaBean.renderUsuario || consultarUsuarioConsultaSinFacturaBean.renderModificar}"/>
                <h:panelGroup>
                  <h:inputText id="itAcom" maxlength="40" onkeydown="return blockEnter(event);"
                               styleClass="labelTextOblig, textmayuscula"
                               rendered="#{consultarUsuarioConsultaSinFacturaBean.renderUsuario || consultarUsuarioConsultaSinFacturaBean.renderModificar}"
                               value="#{consultarUsuarioConsultaSinFacturaBean.usuario.huscnomresponsa}">
                               <f:validator validatorId="cadena.stringValidator"/>
                               </h:inputText>
                  <a4j:outputPanel ajaxRendered="true"
                                   rendered="#{consultarUsuarioConsultaSinFacturaBean.renderUsuario || consultarUsuarioConsultaSinFacturaBean.renderModificar}">
                    <t:message for="itAcom" styleClass="errorMessage"/>
                  </a4j:outputPanel>
                </h:panelGroup>
                <h:panelGroup>
                  <h:inputText onkeydown="return blockEnter(event);" maxlength="20" id="telAcomp"
                               rendered="#{consultarUsuarioConsultaSinFacturaBean.renderUsuario || consultarUsuarioConsultaSinFacturaBean.renderModificar}"
                               value="#{consultarUsuarioConsultaSinFacturaBean.usuario.husctelresponsa}">
                                <f:validator validatorId="cadena.stringValidator"/>
                                </h:inputText>
                  <t:message for="telAcomp" styleClass="errorMessage"/>
                </h:panelGroup>
                <h:panelGroup>
                  <h:inputText onkeydown="return blockEnter(event);" maxlength="20" id="resAcomp"
                               rendered="#{consultarUsuarioConsultaSinFacturaBean.renderUsuario || consultarUsuarioConsultaSinFacturaBean.renderModificar}"
                               value="#{consultarUsuarioConsultaSinFacturaBean.usuario.huscparresponsa}">
                                <f:validator validatorId="cadena.stringValidator"/>
                               </h:inputText>
                  <t:message for="resAcomp" styleClass="errorMessage"/>
                </h:panelGroup>
                <h:outputText/>
              </h:panelGrid>
              <h:panelGrid>
                <h:panelGroup>
                  <a4j:outputPanel id="ajaxRegionMensajesRegistrarUsuario" ajaxRendered="true">
                    <t:htmlTag value="br"/>
                    <t:messages id="msgInfRegistrarUsuario" showSummary="true" errorClass="error" globalOnly="true"
                                layout="table" infoClass="registrar"/>
                  </a4j:outputPanel>
                </h:panelGroup>
              </h:panelGrid>
            </s:fieldset>
            <h:panelGroup>
              <a4j:outputPanel id="ajaxRegionMessagesatributo1" ajaxRendered="true">
                <t:htmlTag value="br"/>
                <t:messages id="msgInformationAndErrors" showSummary="false" errorClass="error" globalOnly="true"
                            layout="table" infoClass="informacion" showDetail="true" tooltip="true"
                            warnClass="advertencia"/>
                <t:htmlTag value="br"/>
              </a4j:outputPanel>
            </h:panelGroup>
            <h:panelGrid columns="1" border="0" cellpadding="0" cellspacing="0" width="100%" id="panelBotonModificar"
                         columnClasses="panelGridBotones"></h:panelGrid>
         
         <h:panelGrid columns="1" border="0" cellpadding="0" cellspacing="0" width="100%" id="panelBotonesRegistro"
                     columnClasses="panelGridBotones">
          <h:panelGroup>
            <h:commandButton value="Guardar"
                             rendered="#{consultarUsuarioConsultaSinFacturaBean.renderUsuario || consultarUsuarioConsultaSinFacturaBean.renderModificar}"
                             styleClass="btn btn btn-success"
                             action="#{consultarUsuarioConsultaSinFacturaBean.registrarConsultaSinFactura}"/>
          </h:panelGroup>
        </h:panelGrid>
          </t:panelTab>
          
             <t:panelTab id="panelTabSeleccionarUsuario" label="Seleccionar Usuario"
                      rendered="#{consultarUsuarioConsultaSinFacturaBean.renderSelecionarUsuario}">
            <s:fieldset legend="Usuarios" id="fieldSetSeleccionarUsuario" styleClass="fieldset_dataTable">
              <h:panelGrid columns="1" id="panelGridSeleccionarUsuario"
                           rendered="#{empty consultarUsuarioConsultaSinFacturaBean.lstUsuarios}">
                <h:outputText value="#{msg.msg_sin_consultar}"/>
              </h:panelGrid>
              <h:panelGrid columns="1" border="0" cellpadding="0" cellspacing="0" width="100%"
                           id="tableContentSeleccionarUsuario"
                           rendered="#{not empty consultarUsuarioConsultaSinFacturaBean.lstUsuarios}"
                           styleClass="tabContainer">
                <t:buffer into="#{table}">
                  <h:dataTable var="item" border="1" cellpadding="0" cellspacing="0"
                               binding="#{consultarUsuarioConsultaSinFacturaBean.dtConsultaUsuario}"
                               value="#{consultarUsuarioConsultaSinFacturaBean.lstUsuarios}" rows="10"
                               styleClass="standard_table" rowClasses="standardTable_Row1,standardTable_Row2"
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
                        <h:outputText value="Estado Usuario"/>
                      </f:facet>
                      <h:outputText value="#{item.huseestado}"/>
                    </h:column>
                    <h:column>
                      <f:facet name="header">
                        <h:outputText value="Seleccione"/>
                      </f:facet>
                      <h:commandLink id="aceptar" action="#{consultarUsuarioConsultaSinFacturaBean.agregarUsuario}">
                        <t:graphicImage alt="" border="0" url="/comun/imagenes/adicionar.gif"/>
                      </h:commandLink>
                    </h:column>
                  </h:dataTable>
                </t:buffer>
                <t:buffer into="#{tableScroller}">
                  <h:panelGrid columns="1" rowClasses="labelTextInfo,labelTextInfo">
                    <t:dataScroller id="scroll_1" for="dtSeleccionarUsuarios" fastStep="10" pageCountVar="pageCount"
                                    pageIndexVar="pageIndex" styleClass="scroller" paginator="true"
                                    paginatorMaxPages="9" paginatorTableClass="paginator"
                                    renderFacetsIfSinglePage="false" paginatorActiveColumnStyle="font-weight:bold;">
                      <f:facet name="first">
                        <t:graphicImage alt="" url="/comun/imagenes/primero.gif" border="0"/>
                      </f:facet>
                      <f:facet name="last">
                        <t:graphicImage alt="" url="/comun/imagenes/ultimo.gif" border="0"/>
                      </f:facet>
                      <f:facet name="previous">
                        <t:graphicImage alt="" url="/comun/imagenes/anterior.gif" border="0"/>
                      </f:facet>
                      <f:facet name="next">
                        <t:graphicImage alt="" url="/comun/imagenes/siguiente.gif" border="0"/>
                      </f:facet>
                      <f:facet name="fastforward">
                        <t:graphicImage alt="" url="/comun/imagenes/adelante.gif" border="0"/>
                      </f:facet>
                      <f:facet name="fastrewind">
                        <t:graphicImage alt="" url="/comun/imagenes/atras.gif" border="0"/>
                      </f:facet>
                    </t:dataScroller>
                  </h:panelGrid>
                </t:buffer>
                <h:outputText value="#{tableScroller}" escape="false"/>
                <h:outputText value="#{table}" escape="false"/>
                <h:outputText value="#{tableScroller}" escape="false"/>
              </h:panelGrid>
            </s:fieldset>
            <s:fieldset legend="Usuario Seleccionado" id="fieldUsuarioSelecc" styleClass="fieldset">
              <h:outputText value="#{consultarUsuarioConsultaSinFacturaBean.usuario.huscprimernomb} #{consultarUsuarioConsultaSinFacturaBean.usuario.huscsegundnomb}  #{consultarUsuarioConsultaSinFacturaBean.usuario.huscprimerapel}  #{consultarUsuarioConsultaSinFacturaBean.usuario.huscsegundapel}"
                            escape="false"/>
            </s:fieldset>
            <h:panelGrid columns="1" border="0" cellpadding="0" cellspacing="0" width="100%"
                         id="panelBotonSeleccionarUsuario" columnClasses="panelGridBotones">
              <h:panelGroup>
                <h:commandButton value="Seleccionar Usuario" styleClass="btn btn btn-success" immediate="true"
                                 action="#{consultarUsuarioConsultaSinFacturaBean.seleccionarUsuario}">
                  <a4j:support event="onclick" status="statusButton"/>
                </h:commandButton>
              </h:panelGroup>
            </h:panelGrid>
          </t:panelTab>
          
           <t:panelTab id="panelBuscadorEntidad" label="Buscar Entidad Administradora"
                rendered="#{consultarUsuarioConsultaSinFacturaBean.renderBuscadorEPS}">
      <a4j:region id="regionEntidad" renderRegionOnly="false">
        <a4j:status id="statusButton" for="regionEntidad">
          <f:facet name="start">
            <t:div id="chargingEntidad" styleClass="loading">
              <h:panelGrid columns="1" cellpadding="0" cellspacing="0" border="0">
                <h:outputText value="Procesando..."/>
                <h:outputText value="Por favor espere."/>
              </h:panelGrid>
            </t:div>
          </f:facet>
          <f:facet name="stop"/>
        </a4j:status>
        <a4j:region renderRegionOnly="false">
          <jsp:include page="/pages/clinico/comunes/buscador/buscadorEPS.jsp" flush="true"/>
        </a4j:region>
      </a4j:region>
    </t:panelTab>
    
       <t:panelTab id="panelBuscadorOcupacion" label="Buscar Ocupación"
                rendered="#{consultarUsuarioConsultaSinFacturaBean.renderBuscadorOcupacion}">
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
        
        
        
                     

        
        
    
   
 
    <h:panelGrid>
      <h:panelGroup>
        <a4j:outputPanel id="ajaxRegionMsgUsuarioRegistrarCirugia" ajaxRendered="true">
          <t:htmlTag value="br"/>
          <t:messages id="msgInformationMsgUsuarioRegistrarCirugia" showSummary="true" errorClass="error"
                      globalOnly="true" layout="table" infoClass="informacion"/>
        </a4j:outputPanel>
      </h:panelGroup>
    </h:panelGrid>
  </a4j:region>
</a4j:form>