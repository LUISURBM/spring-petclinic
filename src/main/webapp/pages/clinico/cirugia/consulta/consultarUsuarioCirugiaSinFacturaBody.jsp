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
                           selectedIndex="#{consultarUsuarioCirugiaSinFacturaBean.selectedIndex}"
                           inactiveSubStyleClass="inactiveSub" tabContentStyleClass="tabContent">
          <t:panelTab id="panelTabDatosUsuario" label="Crear Cirugia Sin Factura "
                      rendered="#{!consultarUsuarioCirugiaSinFacturaBean.renderSelecionarUsuario}">
                   <a4j:commandLink action="#{consultarUsuarioCirugiaSinFacturaBean.resetDatos}" reRender="formDatosUsuarios"
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
                                 disabled="#{consultarUsuarioCirugiaSinFacturaBean.renderUsuario || consultarUsuarioCirugiaSinFacturaBean.renderModificar}"
                                 value="#{consultarUsuarioCirugiaSinFacturaBean.usuario.husetipoiden}"
                                 onkeydown="return blockEnter(event);">
                  <f:selectItems value="#{consultarUsuarioCirugiaSinFacturaBean.listTipoIdentificacion}"/>
                </h:selectOneMenu>
                <a4j:outputPanel ajaxRendered="true">
                  <t:message for="tipoIde" styleClass="errorMessage"/>
                </a4j:outputPanel>
                <h:panelGrid columns="2" border="0" cellpadding="0" cellspacing="0">
                
                  <h:inputText id="itNumeroIdentificacion" maxlength="15" onkeypress="searchByEnterAndReturn(event)"
                               disabled="#{consultarUsuarioCirugiaSinFacturaBean.renderUsuario || consultarUsuarioCirugiaSinFacturaBean.renderModificar}"
                               value="#{consultarUsuarioCirugiaSinFacturaBean.usuario.husanumeiden}"
                               onkeydown="return blockEnter(event);"/>
                               <a4j:commandButton value="Buscar" id="BtnBuscar" oncomplete="numeroJs()"
                                     disabled="#{consultarUsuarioCirugiaSinFacturaBean.renderUsuario || consultarUsuarioCirugiaSinFacturaBean.renderModificar}"
                                     action="#{consultarUsuarioCirugiaSinFacturaBean.buscadorUsuario}" 
                                     image="/comun/imagenes/lupita.png"
                                     reRender="formDatosUsuarios"/>
                   
                </h:panelGrid>
               
                <a4j:outputPanel ajaxRendered="true">
                  <t:message for="itNumeroIdentificacion" styleClass="errorMessage"/>
                </a4j:outputPanel>
                <h:outputText id="idtipo" value="#{consultarUsuarioCirugiaSinFacturaBean.usuario.huslnumero}"></h:outputText>
                <h:outputText/>
                <h:outputText/>
                <h:outputText/>
                <h:outputText value="Primer Nombre" styleClass="labelTextOblig"
                              rendered="#{consultarUsuarioCirugiaSinFacturaBean.renderUsuario || consultarUsuarioCirugiaSinFacturaBean.renderModificar}"/>
                <h:outputText value=""
                              rendered="#{consultarUsuarioCirugiaSinFacturaBean.renderUsuario || consultarUsuarioCirugiaSinFacturaBean.renderModificar}"/>
                <h:outputText value="Segundo Nombre"
                              rendered="#{consultarUsuarioCirugiaSinFacturaBean.renderUsuario || consultarUsuarioCirugiaSinFacturaBean.renderModificar}"/>
                <h:outputText value=""
                              rendered="#{consultarUsuarioCirugiaSinFacturaBean.renderUsuario || consultarUsuarioCirugiaSinFacturaBean.renderModificar}"/>
                <h:outputText value="Primer Apellido" styleClass="labelTextOblig"
                              rendered="#{consultarUsuarioCirugiaSinFacturaBean.renderUsuario || consultarUsuarioCirugiaSinFacturaBean.renderModificar}"/>
                <h:outputText value=""
                              rendered="#{consultarUsuarioCirugiaSinFacturaBean.renderUsuario || consultarUsuarioCirugiaSinFacturaBean.renderModificar}"/>
                <h:outputText value="Segundo Apellido"
                              rendered="#{consultarUsuarioCirugiaSinFacturaBean.renderUsuario || consultarUsuarioCirugiaSinFacturaBean.renderModificar}"/>
                <h:outputText value=""
                              rendered="#{consultarUsuarioCirugiaSinFacturaBean.renderUsuario || consultarUsuarioCirugiaSinFacturaBean.renderModificar}"/>
                <h:inputText id="primerNombre" onkeydown="return blockEnter(event);" maxlength="20"
                             styleClass="textmayuscula"
                             rendered="#{consultarUsuarioCirugiaSinFacturaBean.renderUsuario || consultarUsuarioCirugiaSinFacturaBean.renderModificar}"
                             value="#{consultarUsuarioCirugiaSinFacturaBean.usuario.huscprimernomb}">
                              <f:validator validatorId="cadena.stringValidator"/>
                             </h:inputText>
                <a4j:outputPanel ajaxRendered="true"
                                 rendered="#{consultarUsuarioCirugiaSinFacturaBean.renderUsuario || consultarUsuarioCirugiaSinFacturaBean.renderModificar}">
                  <t:message for="primerNombre" styleClass="errorMessage"/>
                </a4j:outputPanel>
                <h:inputText id="segundoNombre" onkeydown="return blockEnter(event);" styleClass="textmayuscula"
                             rendered="#{consultarUsuarioCirugiaSinFacturaBean.renderUsuario || consultarUsuarioCirugiaSinFacturaBean.renderModificar}"
                             value="#{consultarUsuarioCirugiaSinFacturaBean.usuario.huscsegundnomb}" maxlength="20">
                              <f:validator validatorId="cadena.stringValidator"/>
                              </h:inputText>
                <a4j:outputPanel ajaxRendered="true"
                                 rendered="#{consultarUsuarioCirugiaSinFacturaBean.renderUsuario || consultarUsuarioCirugiaSinFacturaBean.renderModificar}">
                  <t:message for="segundoNombre" styleClass="errorMessage"/>
                </a4j:outputPanel>
                <h:inputText id="primerApellido" onkeydown="return blockEnter(event);" maxlength="20"
                             styleClass="textmayuscula"
                             rendered="#{consultarUsuarioCirugiaSinFacturaBean.renderUsuario || consultarUsuarioCirugiaSinFacturaBean.renderModificar}"
                             value="#{consultarUsuarioCirugiaSinFacturaBean.usuario.huscprimerapel}">
                             <f:validator validatorId="cadena.stringValidator"/>
                             </h:inputText>
                <a4j:outputPanel ajaxRendered="true"
                                 rendered="#{consultarUsuarioCirugiaSinFacturaBean.renderUsuario || consultarUsuarioCirugiaSinFacturaBean.renderModificar}">
                  <t:message for="primerApellido" styleClass="errorMessage"/>
                </a4j:outputPanel>
                <h:inputText id="segundoApellido" onkeydown="return blockEnter(event);" maxlength="20"
                             styleClass="textmayuscula"
                             rendered="#{consultarUsuarioCirugiaSinFacturaBean.renderUsuario || consultarUsuarioCirugiaSinFacturaBean.renderModificar}"
                             value="#{consultarUsuarioCirugiaSinFacturaBean.usuario.huscsegundapel}">
                             <f:validator validatorId="cadena.stringValidator"/>
                             </h:inputText>
                <a4j:outputPanel ajaxRendered="true"
                                 rendered="#{consultarUsuarioCirugiaSinFacturaBean.renderUsuario || consultarUsuarioCirugiaSinFacturaBean.renderModificar}">
                  <t:message for="segundoApellido" styleClass="errorMessage"/>
                </a4j:outputPanel>
                <h:outputText value="Fecha Nacimiento" styleClass="labelTextOblig"
                              rendered="#{consultarUsuarioCirugiaSinFacturaBean.renderUsuario || consultarUsuarioCirugiaSinFacturaBean.renderModificar}"/>
                <h:outputText value=""
                              rendered="#{consultarUsuarioCirugiaSinFacturaBean.renderUsuario || consultarUsuarioCirugiaSinFacturaBean.renderModificar}"/>
                <h:outputText value="Edad" styleClass="labelTextOblig"
                              rendered="#{consultarUsuarioCirugiaSinFacturaBean.renderUsuario || consultarUsuarioCirugiaSinFacturaBean.renderModificar}"/>
                <h:outputText value=""
                              rendered="#{consultarUsuarioCirugiaSinFacturaBean.renderUsuario || consultarUsuarioCirugiaSinFacturaBean.renderModificar}"/>
                <h:outputText value="Sexo" styleClass="labelTextOblig"
                              rendered="#{consultarUsuarioCirugiaSinFacturaBean.renderUsuario || consultarUsuarioCirugiaSinFacturaBean.renderModificar}"/>
                <h:outputText value=""
                              rendered="#{consultarUsuarioCirugiaSinFacturaBean.renderUsuario || consultarUsuarioCirugiaSinFacturaBean.renderModificar}"/>
                <h:outputText value="Escolaridad" styleClass="labelTextOblig"
                              rendered="#{consultarUsuarioCirugiaSinFacturaBean.renderUsuario || consultarUsuarioCirugiaSinFacturaBean.renderModificar}"/>
                <h:outputText value=""
                              rendered="#{consultarUsuarioCirugiaSinFacturaBean.renderUsuario || consultarUsuarioCirugiaSinFacturaBean.renderModificar}"/>
                <t:inputCalendar id="fechaNacimiento"
                                 rendered="#{consultarUsuarioCirugiaSinFacturaBean.renderUsuario || consultarUsuarioCirugiaSinFacturaBean.renderModificar}"
                                 monthYearRowClass="yearMonthHeader" weekRowClass="weekHeader"
                                 title="Formato: dd/mm/yyyy" currentDayCellClass="currentDayCell"
                                 popupDateFormat="dd/MM/yyyy" renderAsPopup="true" disabled="false"
                                 value="#{consultarUsuarioCirugiaSinFacturaBean.usuario.husdfechanacim}"
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
                                 rendered="#{consultarUsuarioCirugiaSinFacturaBean.renderUsuario || consultarUsuarioCirugiaSinFacturaBean.renderModificar}">
                  <t:message for="fechaNacimiento" styleClass="errorMessage"/>
                </a4j:outputPanel>
                <h:panelGroup id="panelEdad">
                  <h:inputText id="inputEdad" onkeydown="return blockEnter(event);" maxlength="4" disabled="true"
                               rendered="#{consultarUsuarioCirugiaSinFacturaBean.renderUsuario || consultarUsuarioCirugiaSinFacturaBean.renderModificar}"
                               value="#{consultarUsuarioCirugiaSinFacturaBean.usuario.edad}"/>
                </h:panelGroup>
                <h:outputText value=""/>
                <h:selectOneMenu id="radioSexo" onkeydown="return blockEnter(event);"
                                 rendered="#{consultarUsuarioCirugiaSinFacturaBean.renderUsuario || consultarUsuarioCirugiaSinFacturaBean.renderModificar}"
                                 value="#{consultarUsuarioCirugiaSinFacturaBean.usuario.husesexo}">
                  <f:selectItems value="#{consultarUsuarioCirugiaSinFacturaBean.listSexos}"/>
                </h:selectOneMenu>
                <a4j:outputPanel ajaxRendered="true"
                                 rendered="#{consultarUsuarioCirugiaSinFacturaBean.renderUsuario || consultarUsuarioCirugiaSinFacturaBean.renderModificar}">
                  <t:message for="radioSexo" styleClass="errorMessage"/>
                </a4j:outputPanel>
                <h:selectOneMenu id="itNivelEducativo"
                                 value="#{consultarUsuarioCirugiaSinFacturaBean.usuario.husnniveledu}"
                                 rendered="#{consultarUsuarioCirugiaSinFacturaBean.renderUsuario || consultarUsuarioCirugiaSinFacturaBean.renderModificar}">
                  <f:selectItems value="#{consultarUsuarioCirugiaSinFacturaBean.lstNivelEducativo}"/>
                </h:selectOneMenu>
                <a4j:outputPanel ajaxRendered="true"
                                 rendered="#{consultarUsuarioCirugiaSinFacturaBean.renderUsuario || consultarUsuarioCirugiaSinFacturaBean.renderModificar}">
                  <t:message for="itNivelEducativo" styleClass="errorMessage"/>
                </a4j:outputPanel>
                <h:outputText value="Estrato "
                              rendered="#{consultarUsuarioCirugiaSinFacturaBean.renderUsuario || consultarUsuarioCirugiaSinFacturaBean.renderModificar}"/>
                <h:outputText value=""
                              rendered="#{consultarUsuarioCirugiaSinFacturaBean.renderUsuario || consultarUsuarioCirugiaSinFacturaBean.renderModificar}"/>
                <h:outputText value="Estado Civil"
                              rendered="#{consultarUsuarioCirugiaSinFacturaBean.renderUsuario || consultarUsuarioCirugiaSinFacturaBean.renderModificar}"/>
                <h:outputText value=""
                              rendered="#{consultarUsuarioCirugiaSinFacturaBean.renderUsuario || consultarUsuarioCirugiaSinFacturaBean.renderModificar}"/>
                <h:outputText value="Correo Electrónico"
                              rendered="#{consultarUsuarioCirugiaSinFacturaBean.renderUsuario || consultarUsuarioCirugiaSinFacturaBean.renderModificar}"/>
                <h:outputText value=""
                              rendered="#{consultarUsuarioCirugiaSinFacturaBean.renderUsuario || consultarUsuarioCirugiaSinFacturaBean.renderModificar}"/>
                <h:outputText value="Etnia" styleClass="labelTextOblig"
                              rendered="#{consultarUsuarioCirugiaSinFacturaBean.renderUsuario || consultarUsuarioCirugiaSinFacturaBean.renderModificar}"/>
                <h:outputText value=""
                              rendered="#{consultarUsuarioCirugiaSinFacturaBean.renderUsuario || consultarUsuarioCirugiaSinFacturaBean.renderModificar}"/>
                <h:selectOneRadio id="mnuEstrato" onkeydown="return blockEnter(event);"
                                  rendered="#{consultarUsuarioCirugiaSinFacturaBean.renderUsuario || consultarUsuarioCirugiaSinFacturaBean.renderModificar}"
                                  value="#{consultarUsuarioCirugiaSinFacturaBean.usuario.husnestrato}">
                  <f:selectItems value="#{consultarUsuarioCirugiaSinFacturaBean.listEstrato}"/>
                </h:selectOneRadio>
                <a4j:outputPanel ajaxRendered="true"
                                 rendered="#{consultarUsuarioCirugiaSinFacturaBean.renderUsuario || consultarUsuarioCirugiaSinFacturaBean.renderModificar}">
                  <t:message for="mnuEstrato" styleClass="errorMessage"/>
                </a4j:outputPanel>
                <h:selectOneMenu id="radioEstadoCivil" onkeydown="return blockEnter(event);"
                                 rendered="#{consultarUsuarioCirugiaSinFacturaBean.renderUsuario || consultarUsuarioCirugiaSinFacturaBean.renderModificar}"
                                 value="#{consultarUsuarioCirugiaSinFacturaBean.usuario.huseestadcivil}">
                  <f:selectItems value="#{consultarUsuarioCirugiaSinFacturaBean.listEstadoCivil}"/>
                </h:selectOneMenu>
                <a4j:outputPanel ajaxRendered="true"
                                 rendered="#{consultarUsuarioCirugiaSinFacturaBean.renderUsuario || consultarUsuarioCirugiaSinFacturaBean.renderModificar}">
                  <t:message for="radioEstadoCivil" styleClass="errorMessage"/>
                </a4j:outputPanel>
                <h:inputText id="itCorreo" maxlength="30" onkeydown="return blockEnter(event);"
                             rendered="#{consultarUsuarioCirugiaSinFacturaBean.renderUsuario || consultarUsuarioCirugiaSinFacturaBean.renderModificar}"
                             value="#{consultarUsuarioCirugiaSinFacturaBean.usuario.husccorreoelec}"/>
                <a4j:outputPanel ajaxRendered="true"
                                 rendered="#{consultarUsuarioCirugiaSinFacturaBean.renderUsuario || consultarUsuarioCirugiaSinFacturaBean.renderModificar}">
                  <t:message for="itCorreo" styleClass="errorMessage"/>
                </a4j:outputPanel>
                <h:selectOneMenu id="radioEtnia" onkeydown="return blockEnter(event);"
                                 rendered="#{consultarUsuarioCirugiaSinFacturaBean.renderUsuario || consultarUsuarioCirugiaSinFacturaBean.renderModificar}"
                                 value="#{consultarUsuarioCirugiaSinFacturaBean.usuario.huscetnia}">
                  <f:selectItems value="#{consultarUsuarioCirugiaSinFacturaBean.lstEtnia}"/>
                </h:selectOneMenu>
                <a4j:outputPanel ajaxRendered="true"
                                 rendered="#{consultarUsuarioCirugiaSinFacturaBean.renderUsuario || consultarUsuarioCirugiaSinFacturaBean.renderModificar}">
                  <t:message for="radioEtnia" styleClass="errorMessage"/>
                </a4j:outputPanel>
                <h:outputText value="Dirección"
                              rendered="#{consultarUsuarioCirugiaSinFacturaBean.renderUsuario || consultarUsuarioCirugiaSinFacturaBean.renderModificar}"
                              styleClass="labelTextOblig"/>
                <h:outputText value=""
                              rendered="#{consultarUsuarioCirugiaSinFacturaBean.renderUsuario || consultarUsuarioCirugiaSinFacturaBean.renderModificar}"/>
                <h:outputText value="Barrio "
                              rendered="#{consultarUsuarioCirugiaSinFacturaBean.renderUsuario || consultarUsuarioCirugiaSinFacturaBean.renderModificar}"
                              styleClass="labelTextOblig"/>
                <h:outputText value=""
                              rendered="#{consultarUsuarioCirugiaSinFacturaBean.renderUsuario || consultarUsuarioCirugiaSinFacturaBean.renderModificar}"/>
                <h:outputText value="Teléfono"
                              rendered="#{consultarUsuarioCirugiaSinFacturaBean.renderUsuario || consultarUsuarioCirugiaSinFacturaBean.renderModificar}"
                              styleClass="labelTextOblig"/>
                <h:outputText value=""
                              rendered="#{consultarUsuarioCirugiaSinFacturaBean.renderUsuario || consultarUsuarioCirugiaSinFacturaBean.renderModificar}"/>
                <h:outputText value="Teléfono Movil" styleClass="labelTextOblig"
                              rendered="#{consultarUsuarioCirugiaSinFacturaBean.renderUsuario || consultarUsuarioCirugiaSinFacturaBean.renderModificar}"/>
                <h:outputText value=""
                              rendered="#{consultarUsuarioCirugiaSinFacturaBean.renderUsuario || consultarUsuarioCirugiaSinFacturaBean.renderModificar}"/>
                <h:inputText id="Direccion" maxlength="20" onkeydown="return blockEnter(event);"
                             rendered="#{consultarUsuarioCirugiaSinFacturaBean.renderUsuario || consultarUsuarioCirugiaSinFacturaBean.renderModificar}"
                             value="#{consultarUsuarioCirugiaSinFacturaBean.usuario.huscdireccion}">
                              <f:validator validatorId="cadena.stringValidator"/>
                              </h:inputText>
                <a4j:outputPanel ajaxRendered="true"
                                 rendered="#{consultarUsuarioCirugiaSinFacturaBean.renderUsuario || consultarUsuarioCirugiaSinFacturaBean.renderModificar}">
                  <t:message for="Direccion" styleClass="errorMessage"/>
                </a4j:outputPanel>
                <h:inputText id="itBarrio" onkeydown="return blockEnter(event);" maxlength="20"
                             rendered="#{consultarUsuarioCirugiaSinFacturaBean.renderUsuario || consultarUsuarioCirugiaSinFacturaBean.renderModificar}"
                             value="#{consultarUsuarioCirugiaSinFacturaBean.usuario.huscbarrio}">
                              <f:validator validatorId="cadena.stringValidator"/>
                              </h:inputText>
                <a4j:outputPanel ajaxRendered="true"
                                 rendered="#{consultarUsuarioCirugiaSinFacturaBean.renderUsuario || consultarUsuarioCirugiaSinFacturaBean.renderModificar}">
                  <t:message for="itBarrio" styleClass="errorMessage"/>
                </a4j:outputPanel>
                <h:inputText id="Telefono" maxlength="20" onkeydown="return blockEnter(event);"
                             rendered="#{consultarUsuarioCirugiaSinFacturaBean.renderUsuario || consultarUsuarioCirugiaSinFacturaBean.renderModificar}"
                             value="#{consultarUsuarioCirugiaSinFacturaBean.usuario.husctelefono}">
                              <f:validator validatorId="cadena.stringValidator"/>
                              </h:inputText>
                <a4j:outputPanel ajaxRendered="true"
                                 rendered="#{consultarUsuarioCirugiaSinFacturaBean.renderUsuario || consultarUsuarioCirugiaSinFacturaBean.renderModificar}">
                  <t:message for="Telefono" styleClass="errorMessage"/>
                </a4j:outputPanel>
                <h:inputText id="TelefonoMovil" maxlength="20" onkeydown="return blockEnter(event);"
                             rendered="#{consultarUsuarioCirugiaSinFacturaBean.renderUsuario || consultarUsuarioCirugiaSinFacturaBean.renderModificar}"
                             value="#{consultarUsuarioCirugiaSinFacturaBean.usuario.husccelular}">
                              <f:validator validatorId="cadena.stringValidator"/>
                             </h:inputText>
                <a4j:outputPanel ajaxRendered="true"
                                 rendered="#{consultarUsuarioCirugiaSinFacturaBean.renderUsuario || consultarUsuarioCirugiaSinFacturaBean.renderModificar}">
                  <t:message for="TelefonoMovil" styleClass="errorMessage"/>
                </a4j:outputPanel>
                <h:outputText value="País de residencia habitual" styleClass="labelTextOblig"
                              rendered="#{consultarUsuarioCirugiaSinFacturaBean.renderUsuario || consultarUsuarioCirugiaSinFacturaBean.renderModificar}"/>
                <h:outputText value=""
                              rendered="#{consultarUsuarioCirugiaSinFacturaBean.renderUsuario || consultarUsuarioCirugiaSinFacturaBean.renderModificar}"/>
                <h:outputText value="Departamento" styleClass="labelTextOblig"
                              rendered="#{consultarUsuarioCirugiaSinFacturaBean.renderUsuario || consultarUsuarioCirugiaSinFacturaBean.renderModificar}"/>
                <h:outputText value=""
                              rendered="#{consultarUsuarioCirugiaSinFacturaBean.renderUsuario || consultarUsuarioCirugiaSinFacturaBean.renderModificar}"/>
                <h:outputText value="Municipio" styleClass="labelTextOblig"
                              rendered="#{consultarUsuarioCirugiaSinFacturaBean.renderUsuario || consultarUsuarioCirugiaSinFacturaBean.renderModificar}"/>
                <h:outputText value=""
                              rendered="#{consultarUsuarioCirugiaSinFacturaBean.renderUsuario || consultarUsuarioCirugiaSinFacturaBean.renderModificar}"/>
                <h:outputText value="Tipo de Afiliación" styleClass="labelTextOblig"
                              rendered="#{consultarUsuarioCirugiaSinFacturaBean.renderUsuario || consultarUsuarioCirugiaSinFacturaBean.renderModificar}"/>
                <h:outputText value=" "
                              rendered="#{consultarUsuarioCirugiaSinFacturaBean.renderUsuario || consultarUsuarioCirugiaSinFacturaBean.renderModificar}"/>

                <h:selectOneMenu id="menuPais" onkeydown="return blockEnter(event);"
                              rendered="#{consultarUsuarioCirugiaSinFacturaBean.renderUsuario || consultarUsuarioCirugiaSinFacturaBean.renderModificar}"
                              value="#{consultarUsuarioCirugiaSinFacturaBean.usuario.huscpaisresi}">
                    <f:selectItems value="#{consultarUsuarioCirugiaSinFacturaBean.listPaises}"/>
                </h:selectOneMenu>
                <a4j:outputPanel ajaxRendered="true"
                              rendered="#{consultarUsuarioCirugiaSinFacturaBean.renderUsuario || consultarUsuarioCirugiaSinFacturaBean.renderModificar}">
                    <t:message for="menuPais" styleClass="errorMessage"/>
                </a4j:outputPanel>

                <h:selectOneMenu id="menuDepartamentos" onkeydown="return blockEnter(event);"
                                 rendered="#{consultarUsuarioCirugiaSinFacturaBean.renderUsuario || consultarUsuarioCirugiaSinFacturaBean.renderModificar}"
                                 value="#{consultarUsuarioCirugiaSinFacturaBean.usuario.husndepartamen}"
                                 valueChangeListener="#{consultarUsuarioCirugiaSinFacturaBean.setDepartamentoSelect}">
                  <f:selectItems value="#{consultarUsuarioCirugiaSinFacturaBean.listDepartamentos}"/>
                  <a4j:support id="support7" action="#{consultarUsuarioCirugiaSinFacturaBean.changeCiudad}"
                               reRender="panelRegionInfoConsulta" event="onchange">
                    <a4j:ajaxListener type="org.ajax4jsf.ajax.ForceRender"/>
                  </a4j:support>
                </h:selectOneMenu>
                <a4j:outputPanel ajaxRendered="true"
                                 rendered="#{consultarUsuarioCirugiaSinFacturaBean.renderUsuario || consultarUsuarioCirugiaSinFacturaBean.renderModificar}">
                  <t:message for="menuDepartamentos" styleClass="errorMessage"/>
                </a4j:outputPanel>
                <h:selectOneMenu id="menuCiudad" onkeydown="return blockEnter(event);"
                                 rendered="#{consultarUsuarioCirugiaSinFacturaBean.renderUsuario || consultarUsuarioCirugiaSinFacturaBean.renderModificar}"
                                 value="#{consultarUsuarioCirugiaSinFacturaBean.usuario.husnciudad}">
                  <f:selectItems value="#{consultarUsuarioCirugiaSinFacturaBean.listMunicipios}"/>
                </h:selectOneMenu>
                <a4j:outputPanel ajaxRendered="true"
                                 rendered="#{consultarUsuarioCirugiaSinFacturaBean.renderUsuario || consultarUsuarioCirugiaSinFacturaBean.renderModificar}">
                  <t:message for="menuCiudad" styleClass="errorMessage"/>
                </a4j:outputPanel>
                <h:selectOneMenu id="menuAfiliacion" onkeydown="return blockEnter(event);"
                                 rendered="#{consultarUsuarioCirugiaSinFacturaBean.renderUsuario || consultarUsuarioCirugiaSinFacturaBean.renderModificar}"
                                 value="#{consultarUsuarioCirugiaSinFacturaBean.usuario.husetipoafilia}"
                                 immediate="true"
                                 valueChangeListener="#{consultarUsuarioCirugiaSinFacturaBean.setHusetipoafilia}">
                  <f:selectItems value="#{consultarUsuarioCirugiaSinFacturaBean.listTipoAfiliacion}"/>
                  <a4j:support id="supportAfiliacion" event="onchange" immediate="true"
                               action="#{consultarUsuarioCirugiaSinFacturaBean.changeAfiliacion}"
                               reRender="panelInputEps,paneltextEps,paneltextAfili,panelInputAfili,paneltextVincula,panelRadioVincula">
                    <a4j:ajaxListener type="org.ajax4jsf.ajax.ForceRender"/>
                  </a4j:support>
                </h:selectOneMenu>
                <a4j:outputPanel ajaxRendered="true"
                                 rendered="#{consultarUsuarioCirugiaSinFacturaBean.renderUsuario || consultarUsuarioCirugiaSinFacturaBean.renderModificar}">
                  <t:message for="menuAfiliacion" styleClass="errorMessage"/>
                </a4j:outputPanel>
                <h:panelGroup id="paneltextEps">
                  <h:outputText value="EPS" styleClass="labelTextOblig"
                                rendered="#{consultarUsuarioCirugiaSinFacturaBean.mostrarAfiliacion}"/>
                </h:panelGroup>
                <h:outputText value=" "
                              rendered="#{consultarUsuarioCirugiaSinFacturaBean.renderUsuario || consultarUsuarioCirugiaSinFacturaBean.renderModificar}"/>
                <h:panelGroup id="paneltextAfili">
                  <h:outputText value="Número de Afiliación"
                                rendered="#{consultarUsuarioCirugiaSinFacturaBean.mostrarAfiliacion}"/>
                </h:panelGroup>
                <h:outputText value=" "
                              rendered="#{consultarUsuarioCirugiaSinFacturaBean.renderUsuario || consultarUsuarioCirugiaSinFacturaBean.renderModificar}"/>
                <h:panelGroup id="paneltextVincula">
                  <h:outputText value="Tipo de Vinculación" styleClass="labelTextOblig"
                                rendered="#{consultarUsuarioCirugiaSinFacturaBean.mostrarAfiliacion}"/>
                </h:panelGroup>
                <h:outputText value=" "
                              rendered="#{consultarUsuarioCirugiaSinFacturaBean.renderUsuario || consultarUsuarioCirugiaSinFacturaBean.renderModificar}"/>
                <h:outputText value="Como conoce de Profamilia" styleClass="labelTextOblig"
                              rendered="#{consultarUsuarioCirugiaSinFacturaBean.renderUsuario || consultarUsuarioCirugiaSinFacturaBean.renderModificar}"/>
                <h:outputText value=" "
                              rendered="#{consultarUsuarioCirugiaSinFacturaBean.renderUsuario || consultarUsuarioCirugiaSinFacturaBean.renderModificar}"/>
                <h:panelGroup id="panelInputEps"
                              rendered="#{consultarUsuarioCirugiaSinFacturaBean.renderUsuario || consultarUsuarioCirugiaSinFacturaBean.renderModificar}">
                  <a4j:region renderRegionOnly="false">
                    <h:inputText id="itEps" value="#{consultarUsuarioCirugiaSinFacturaBean.usuario.huscentidadadm}"
                                 valueChangeListener="#{consultarUsuarioCirugiaSinFacturaBean.setEps}" immediate="true"
                                 binding="#{consultarUsuarioCirugiaSinFacturaBean.itEps}" style="width:100px"
                                 styleClass="textmayuscula"
                                 rendered="#{consultarUsuarioCirugiaSinFacturaBean.mostrarAfiliacion}">
                      <f:validateLength maximum="40"/>
                      <a4j:support id="supportitDiagPrin" event="onchange"
                                   action="#{consultarUsuarioCirugiaSinFacturaBean.changeSeleccionEps}"
                                   reRender="panelEpsSeleccion" immediate="true">
                        <a4j:ajaxListener type="org.ajax4jsf.ajax.ForceRender"/>
                      </a4j:support>
                    </h:inputText>
                    <h:commandLink action="#{consultarUsuarioCirugiaSinFacturaBean.renderEps}"
                                   rendered="#{consultarUsuarioCirugiaSinFacturaBean.mostrarAfiliacion}">
                      <t:graphicImage alt="" border="0" url="/comun/imagenes/lupita.png"/>
                    </h:commandLink>
                    <h:panelGrid columns="1" border="0" cellpadding="0" cellspacing="2" id="panelEpsSeleccion"
                                 rendered="#{consultarUsuarioCirugiaSinFacturaBean.mostrarAfiliacion}">
                      <h:outputText value=" #{consultarUsuarioCirugiaSinFacturaBean.seleccionEps}"
                                    styleClass="buscador"/>
                    </h:panelGrid>
                  </a4j:region>
                </h:panelGroup>
                <a4j:outputPanel ajaxRendered="true">
                  <t:message for="itEps" styleClass="errorMessage"/>
                </a4j:outputPanel>
                <h:panelGroup id="panelInputAfili">
                  <h:inputText id="itNumeroAfiliacion" onkeydown="return blockEnter(event);" maxlength="20"
                               rendered="#{consultarUsuarioCirugiaSinFacturaBean.mostrarAfiliacion}"
                               value="#{consultarUsuarioCirugiaSinFacturaBean.usuario.huscnumafiliac}"></h:inputText>
                </h:panelGroup>
                <a4j:outputPanel ajaxRendered="true"
                                 rendered="#{consultarUsuarioCirugiaSinFacturaBean.renderUsuario || consultarUsuarioCirugiaSinFacturaBean.renderModificar}">
                  <t:message for="itNumeroAfiliacion" styleClass="errorMessage"/>
                </a4j:outputPanel>
                <h:panelGroup id="panelRadioVincula">
                  <h:selectOneRadio id="radioVinculacion" onkeydown="return blockEnter(event);"
                                    rendered="#{consultarUsuarioCirugiaSinFacturaBean.mostrarAfiliacion}"
                                    value="#{consultarUsuarioCirugiaSinFacturaBean.usuario.husetipvincula}">
                    <f:selectItems value="#{consultarUsuarioCirugiaSinFacturaBean.lstTipoVinculacion}"/>
                  </h:selectOneRadio>
                </h:panelGroup>
                <a4j:outputPanel ajaxRendered="true"
                                 rendered="#{consultarUsuarioCirugiaSinFacturaBean.renderUsuario || consultarUsuarioCirugiaSinFacturaBean.renderModificar}">
                  <t:message for="radioVinculacion" styleClass="errorMessage"/>
                </a4j:outputPanel>
                <h:selectOneMenu id="menuConoceProfamilia"
                                 value="#{consultarUsuarioCirugiaSinFacturaBean.usuario.husnconoprofam}"
                                 rendered="#{consultarUsuarioCirugiaSinFacturaBean.renderUsuario || consultarUsuarioCirugiaSinFacturaBean.renderModificar}"
                                 onkeydown="return blockEnter(event);">
                  <f:selectItems value="#{consultarUsuarioCirugiaSinFacturaBean.lstConoceProfamilia}"/>
                </h:selectOneMenu>
                <a4j:outputPanel ajaxRendered="true"
                                 rendered="#{consultarUsuarioCirugiaSinFacturaBean.renderUsuario || consultarUsuarioCirugiaSinFacturaBean.renderModificar}">
                  <t:message for="menuConoceProfamilia" styleClass="errorMessage"/>
                </a4j:outputPanel>
                <h:outputText value="Zona " styleClass="labelTextOblig"
                              rendered="#{consultarUsuarioCirugiaSinFacturaBean.renderUsuario || consultarUsuarioCirugiaSinFacturaBean.renderModificar}"/>
                <h:outputText value=" "
                              rendered="#{consultarUsuarioCirugiaSinFacturaBean.renderUsuario || consultarUsuarioCirugiaSinFacturaBean.renderModificar}"/>
                <h:outputText value="Ocupación" styleClass="labelTextOblig"
                              rendered="#{consultarUsuarioCirugiaSinFacturaBean.renderUsuario || consultarUsuarioCirugiaSinFacturaBean.renderModificar}"/>
                <h:outputText value=" "
                              rendered="#{consultarUsuarioCirugiaSinFacturaBean.renderUsuario || consultarUsuarioCirugiaSinFacturaBean.renderModificar}"/>
                <h:outputText value="Tipo de Cliente" styleClass="labelTextOblig"
                              rendered="#{consultarUsuarioCirugiaSinFacturaBean.renderUsuario || consultarUsuarioCirugiaSinFacturaBean.renderModificar}"/>
                <h:outputText value=" "
                              rendered="#{consultarUsuarioCirugiaSinFacturaBean.renderUsuario || consultarUsuarioCirugiaSinFacturaBean.renderModificar}"/>
                <h:panelGroup id="paneltextOtroTipoCliente">
                  <h:outputText value="Numero de Contrato" styleClass="labelTextOblig"
                                rendered="#{consultarUsuarioCirugiaSinFacturaBean.mostrarContrato}"/>
                </h:panelGroup>
                <h:outputText value=" "
                              rendered="#{consultarUsuarioCirugiaSinFacturaBean.renderUsuario || consultarUsuarioCirugiaSinFacturaBean.renderModificar}"/>
                <h:selectOneRadio id="radioZona" onkeydown="return blockEnter(event);"
                                  rendered="#{consultarUsuarioCirugiaSinFacturaBean.renderUsuario || consultarUsuarioCirugiaSinFacturaBean.renderModificar}"
                                  value="#{consultarUsuarioCirugiaSinFacturaBean.usuario.husezonareside}">
                  <f:selectItems value="#{consultarUsuarioCirugiaSinFacturaBean.listzona}"/>
                </h:selectOneRadio>
                <a4j:outputPanel ajaxRendered="true"
                                 rendered="#{consultarUsuarioCirugiaSinFacturaBean.renderUsuario || consultarUsuarioCirugiaSinFacturaBean.renderModificar}">
                  <t:message for="radioZona" styleClass="errorMessage"/>
                </a4j:outputPanel>
                <h:panelGroup rendered="#{consultarUsuarioCirugiaSinFacturaBean.renderUsuario || consultarUsuarioCirugiaSinFacturaBean.renderModificar}">
                  <a4j:region renderRegionOnly="false">
                    <h:inputText id="itOcupacion" value="#{consultarUsuarioCirugiaSinFacturaBean.usuario.husnocupacion}"
                                 valueChangeListener="#{consultarUsuarioCirugiaSinFacturaBean.setOcupacion}"
                                 binding="#{consultarUsuarioCirugiaSinFacturaBean.itOcupacion}" immediate="true"
                                 style="width:100px">
                      <f:validateLength maximum="40"/>
                      <a4j:support id="supportOcupa" event="onchange"
                                   action="#{consultarUsuarioCirugiaSinFacturaBean.changeSeleccionOcupacion}"
                                   reRender="panelOcupacionSeleccion" immediate="true">
                        <a4j:ajaxListener type="org.ajax4jsf.ajax.ForceRender"/>
                      </a4j:support>
                    </h:inputText>
                    <h:commandLink action="#{consultarUsuarioCirugiaSinFacturaBean.renderOcupacion}">
                      <t:graphicImage alt="" border="0" url="/comun/imagenes/lupita.png"/>
                    </h:commandLink>
                    <h:panelGrid columns="1" border="0" cellpadding="0" cellspacing="2" id="panelOcupacionSeleccion">
                      <h:outputText value=" #{consultarUsuarioCirugiaSinFacturaBean.seleccionOcupacion}"
                                    styleClass="buscador"/>
                    </h:panelGrid>
                  </a4j:region>
                </h:panelGroup>
                <a4j:outputPanel ajaxRendered="true">
                  <t:message for="itOcupacion" styleClass="errorMessage"/>
                </a4j:outputPanel>
                <h:panelGroup>
                  <h:selectOneMenu id="menuCliente"
                                   value="#{consultarUsuarioCirugiaSinFacturaBean.usuario.husetipcliente}"
                                   rendered="#{consultarUsuarioCirugiaSinFacturaBean.renderUsuario || consultarUsuarioCirugiaSinFacturaBean.renderModificar}"
                                   onkeydown="return blockEnter(event);" immediate="true"
                                   valueChangeListener="#{consultarUsuarioCirugiaSinFacturaBean.setHusetipcliente}">
                    <f:selectItems value="#{consultarUsuarioCirugiaSinFacturaBean.listTipoCliente}"/>
                    <a4j:support id="supportContratoCredito" event="onchange" immediate="true"
                                 action="#{consultarUsuarioCirugiaSinFacturaBean.changeContrato}"
                                 reRender="panelInputOtroTipoCliente,paneltextOtroTipoCliente">
                      <a4j:ajaxListener type="org.ajax4jsf.ajax.ForceRender"/>
                    </a4j:support>
                  </h:selectOneMenu>
                </h:panelGroup>
                <a4j:outputPanel ajaxRendered="true"
                                 rendered="#{consultarUsuarioCirugiaSinFacturaBean.renderUsuario || consultarUsuarioCirugiaSinFacturaBean.renderModificar}">
                  <t:message for="menuCliente" styleClass="errorMessage"/>
                </a4j:outputPanel>
                <h:panelGroup id="panelInputOtroTipoCliente">
                  <h:inputText id="inputOtroTipoCliente" maxlength="50" onkeydown="return blockEnter(event);"
                               required="false" rendered="#{consultarUsuarioCirugiaSinFacturaBean.mostrarContrato}"
                               value="#{consultarUsuarioCirugiaSinFacturaBean.usuario.husnnumecontr}"/>
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
                        rendered="#{consultarUsuarioCirugiaSinFacturaBean.renderUsuario || consultarUsuarioCirugiaSinFacturaBean.renderModificar}">
              <h:panelGrid columns="3" border="0" cellpadding="0" cellspacing="0" width="100%"
                           id="panelRegionInfoAcompa" rowClasses="labelText,labelTextInfo">
                <h:outputText value="Nombre Responsable" styleClass="labelTextOblig"
                              rendered="#{consultarUsuarioCirugiaSinFacturaBean.renderUsuario || consultarUsuarioCirugiaSinFacturaBean.renderModificar}"/>
                <h:outputText value="Teléfono Responsable"
                              rendered="#{consultarUsuarioCirugiaSinFacturaBean.renderUsuario || consultarUsuarioCirugiaSinFacturaBean.renderModificar}"/>
                <h:outputText value="Parentesco Responsable"
                              rendered="#{consultarUsuarioCirugiaSinFacturaBean.renderUsuario || consultarUsuarioCirugiaSinFacturaBean.renderModificar}"/>
                <h:panelGroup>
                  <h:inputText id="itAcom" maxlength="40" onkeydown="return blockEnter(event);"
                               styleClass="labelTextOblig, textmayuscula"
                               rendered="#{consultarUsuarioCirugiaSinFacturaBean.renderUsuario || consultarUsuarioCirugiaSinFacturaBean.renderModificar}"
                               value="#{consultarUsuarioCirugiaSinFacturaBean.usuario.huscnomresponsa}">
                               <f:validator validatorId="cadena.stringValidator"/>
                               </h:inputText>
                  <a4j:outputPanel ajaxRendered="true"
                                   rendered="#{consultarUsuarioCirugiaSinFacturaBean.renderUsuario || consultarUsuarioCirugiaSinFacturaBean.renderModificar}">
                    <t:message for="itAcom" styleClass="errorMessage"/>
                  </a4j:outputPanel>
                </h:panelGroup>
                <h:panelGroup>
                  <h:inputText onkeydown="return blockEnter(event);" maxlength="20" id="telAcomp"
                               rendered="#{consultarUsuarioCirugiaSinFacturaBean.renderUsuario || consultarUsuarioCirugiaSinFacturaBean.renderModificar}"
                               value="#{consultarUsuarioCirugiaSinFacturaBean.usuario.husctelresponsa}">
                                <f:validator validatorId="cadena.stringValidator"/>
                                </h:inputText>
                  <t:message for="telAcomp" styleClass="errorMessage"/>
                </h:panelGroup>
                <h:panelGroup>
                  <h:inputText onkeydown="return blockEnter(event);" maxlength="20" id="resAcomp"
                               rendered="#{consultarUsuarioCirugiaSinFacturaBean.renderUsuario || consultarUsuarioCirugiaSinFacturaBean.renderModificar}"
                               value="#{consultarUsuarioCirugiaSinFacturaBean.usuario.huscparresponsa}">
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
                             rendered="#{consultarUsuarioCirugiaSinFacturaBean.renderUsuario || consultarUsuarioCirugiaSinFacturaBean.renderModificar}"
                             styleClass="btn btn btn-success"
                             action="#{consultarUsuarioCirugiaSinFacturaBean.registrarCirugiaSinFactura}"/>
          </h:panelGroup>
        </h:panelGrid>
          </t:panelTab>

        </t:panelTabbedPane>
        
        
        
                        <t:panelTab id="panelTabSeleccionarUsuario" label="Seleccionar Usuario"
                      rendered="#{consultarUsuarioCirugiaSinFacturaBean.renderSelecionarUsuario}">
            <s:fieldset legend="Usuarios" id="fieldSetSeleccionarUsuario" styleClass="fieldset_dataTable">
              <h:panelGrid columns="1" id="panelGridSeleccionarUsuario"
                           rendered="#{empty consultarUsuarioCirugiaSinFacturaBean.lstUsuarios}">
                <h:outputText value="#{msg.msg_sin_consultar}"/>
              </h:panelGrid>
              <h:panelGrid columns="1" border="0" cellpadding="0" cellspacing="0" width="100%"
                           id="tableContentSeleccionarUsuario"
                           rendered="#{not empty consultarUsuarioCirugiaSinFacturaBean.lstUsuarios}"
                           styleClass="tabContainer">
                <t:buffer into="#{table}">
                  <h:dataTable var="item" border="1" cellpadding="0" cellspacing="0"
                               binding="#{consultarUsuarioCirugiaSinFacturaBean.dtConsultaUsuario}"
                               value="#{consultarUsuarioCirugiaSinFacturaBean.lstUsuarios}" rows="10"
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
                      <h:commandLink id="aceptar" action="#{consultarUsuarioCirugiaSinFacturaBean.agregarUsuario}">
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
              <h:outputText value="#{consultarUsuarioCirugiaSinFacturaBean.usuario.huscprimernomb} #{consultarUsuarioCirugiaSinFacturaBean.usuario.huscsegundnomb}  #{consultarUsuarioCirugiaSinFacturaBean.usuario.huscprimerapel}  #{consultarUsuarioCirugiaSinFacturaBean.usuario.huscsegundapel}"
                            escape="false"/>
            </s:fieldset>
            <h:panelGrid columns="1" border="0" cellpadding="0" cellspacing="0" width="100%"
                         id="panelBotonSeleccionarUsuario" columnClasses="panelGridBotones">
              <h:panelGroup>
                <h:commandButton value="Seleccionar Usuario" styleClass="btn btn btn-success" immediate="true"
                                 action="#{consultarUsuarioCirugiaSinFacturaBean.seleccionarUsuario}">
                  <a4j:support event="onclick" status="statusButton"/>
                </h:commandButton>
              </h:panelGroup>
            </h:panelGrid>
          </t:panelTab>

        
        
    
    <t:panelTab id="panelBuscadorEntidad" label="Buscar Entidad Administradora"
                rendered="#{consultarUsuarioCirugiaSinFacturaBean.renderBuscadorEPS}">
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
                rendered="#{consultarUsuarioCirugiaSinFacturaBean.renderBuscadorOcupacion}">
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