<%@ page contentType="text/html;charset=iso-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsf/html" prefix="h"%>
<%@ taglib uri="http://java.sun.com/jsf/core" prefix="f"%>
<%@ taglib uri="http://richfaces.org/a4j" prefix="a4j"%>
<%@ taglib uri="http://myfaces.apache.org/tomahawk" prefix="t"%>
<%@ taglib uri="http://myfaces.apache.org/sandbox" prefix="s"%>
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
                    <h:panelGrid columns="3" border="0" cellpadding="0" cellspacing="0" width="100%" id="panelRegionInfoConsulta"
                                 rowClasses="labelText,labelTextInfo">
                        <h:outputText value="Clinica" styleClass="labelTextOblig"/>
                        <h:outputText value=" Numero VPH" styleClass="labelTextOblig"/>
                        <h:outputText value="Fecha" styleClass="labelTextOblig"/>
                        <h:outputText value="#{datosUsuarioVphBean.clinUsuario}"/>
                        <h:panelGroup>
                            <h:inputText id="inputNumeroVph" value="#{datosUsuarioVphBean.vph.hdvnnumero}"
                                         onkeydown="return blockEnter(event);" maxlength="9" />
                            <a4j:outputPanel ajaxRendered="true">
                                <t:message for="inputNumeroVph" styleClass="errorMessage"/>
                            </a4j:outputPanel>
                        </h:panelGroup>
                        <h:panelGroup>
                            <t:inputCalendar id="fechaActual" onkeydown="return blockEnter(event);"
                                             monthYearRowClass="yearMonthHeader" weekRowClass="weekHeader"  
                                             title="Formato: dd/mm/yyyy" currentDayCellClass="currentDayCell"
                                             popupDateFormat="dd/MM/yyyy" renderAsPopup="true"
                                             value="#{datosUsuarioVphBean.fecha}" popupTodayString="Hoy"
                                             popupWeekString="Semana" popupButtonString="Fecha" readonly="false" maxlength="11"
                                             size="11" popupButtonImageUrl="/comun/imagenes/ico_calendario2.gif"
                                             renderPopupButtonAsImage="true" align="top" disabled="true"></t:inputCalendar>
                        </h:panelGroup>
                    </h:panelGrid>

                    <h:panelGrid columns="3" border="0" cellpadding="0" cellspacing="0" width="100%" id="panelDatosUsuario"
                                 rowClasses="labelText,labelTextInfo">

                        <h:outputText value="Tipo Identificación" styleClass="labelTextOblig"/>
                        <h:outputText value=" Numero Identificación" styleClass="labelTextOblig"/>
                        <h:outputText value="Número Usuario" styleClass="labelTextOblig"/>
                        <h:panelGroup>
                            <h:selectOneMenu id="tipoIde"  disabled="true" onkeydown="return blockEnter(event);"
                                             value="#{datosUsuarioVphBean.vph.hdvctipide}">
                                <f:selectItems value="#{datosUsuarioVphBean.listTipoIdentificacion}"/>
                            </h:selectOneMenu>
                            <a4j:outputPanel ajaxRendered="true">
                                <t:message for="tipoIde" styleClass="errorMessage"/>
                            </a4j:outputPanel>
                        </h:panelGroup>
                        <h:panelGroup>
                            <h:inputText id="idtipo" disabled="true"  onkeydown="return blockEnter(event);"
                                         styleClass="textmayuscula"
                                         maxlength="15" value="#{datosUsuarioVphBean.vph.hdvanumide}" >
                                <f:converter converterId="cadena.stringUpperCaseConverter"/>   
                            </h:inputText>
                            <a4j:outputPanel ajaxRendered="true">
                                <t:message for="idtipo" styleClass="errorMessage"/>
                            </a4j:outputPanel>
                        </h:panelGroup>


                        <h:panelGroup>
                            <h:inputText id="itNumeroUsuario" disabled="true" onkeydown="return blockEnter(event);" maxlength="12"
                                         value="#{datosUsuarioVphBean.vph.hdvlusuario.huslnumero}"/>
                        </h:panelGroup>
                    </h:panelGrid>

                    <h:panelGrid columns="4" border="0" cellpadding="0" cellspacing="0" width="100%" id="panelDatosNombre"
                                 rowClasses="labelText,labelTextInfo">


                        <h:outputText value="Primer Nombre" styleClass="labelTextOblig"/>
                        <h:outputText value="Segundo Nombre" styleClass="labelTextOblig"/>
                        <h:outputText value="Primer Apellido" styleClass="labelTextOblig"/>
                        <h:outputText value="Segundo Apellido" styleClass="labelTextOblig"/>
                        <h:panelGroup>
                            <h:inputText id="primerNombre" onkeydown="return blockEnter(event);" 
                                         styleClass="textmayuscula"
                                         maxlength="20"
                                         value="#{datosUsuarioVphBean.vph.hdvcprinom}">
                                <f:converter converterId="cadena.stringUpperCaseConverter"/>
                            </h:inputText>
                            <a4j:outputPanel ajaxRendered="true">
                                <t:message for="primerNombre" styleClass="errorMessage"/>
                            </a4j:outputPanel>
                        </h:panelGroup>
                        <h:panelGroup>
                            <h:inputText id="segundoNombre" styleClass="textmayuscula"
                                         onkeydown="return blockEnter(event);" maxlength="20"
                                         value="#{datosUsuarioVphBean.vph.hdvcsegnom}">
                                <f:converter converterId="cadena.stringUpperCaseConverter"/>
                            </h:inputText>
                            <a4j:outputPanel ajaxRendered="true">
                                <t:message for="segundoNombre" styleClass="errorMessage"/>
                            </a4j:outputPanel>
                        </h:panelGroup>
                        <h:panelGroup>
                            <h:inputText id="primerApellido" onkeydown="return blockEnter(event);" maxlength="20" 
                                         value="#{datosUsuarioVphBean.vph.hdvcpriape}"/>
                            <a4j:outputPanel ajaxRendered="true">
                                <t:message for="primerApellido" styleClass="errorMessage"/>
                            </a4j:outputPanel>
                        </h:panelGroup>
                        <h:panelGroup>
                            <h:inputText id="segundoApellido" onkeydown="return blockEnter(event);" maxlength="20"
                                         value="#{datosUsuarioVphBean.vph.hdvcsegape}"/>
                            <a4j:outputPanel ajaxRendered="true">
                                <t:message for="segundoApellido" styleClass="errorMessage"/>
                            </a4j:outputPanel>
                        </h:panelGroup>
                        <h:outputText value="Departamento" styleClass="labelTextOblig"/>
                        <h:outputText value="Municipio" styleClass="labelTextOblig"/>
                        <h:outputText value="Direccion" styleClass="labelTextOblig"/>
                        <h:outputText value="Telefono" styleClass="labelTextOblig"/>
                        <h:panelGroup>
                            <h:selectOneMenu id="menuDepartamentos" value="#{datosUsuarioVphBean.departamentoSelect}"
                                             onkeydown="return blockEnter(event);"
                                             valueChangeListener="#{datosUsuarioVphBean.setDepartamentoSelect}">
                                <f:selectItems value="#{datosUsuarioVphBean.listDepartamentos}"/>
                                <a4j:support id="support7" oncomplete="jsFunctionDepartamento()"
                                             action="#{datosUsuarioVphBean.changeCiudad}" reRender="panleDatosBasicos"
                                             event="onchange"  >
                                    <a4j:ajaxListener type="org.ajax4jsf.ajax.ForceRender"/>
                                </a4j:support>
                            </h:selectOneMenu>
                            <a4j:outputPanel ajaxRendered="true">
                                <t:message for="menuDepartamentos" styleClass="errorMessage"/>
                            </a4j:outputPanel>
                        </h:panelGroup>
                        <h:panelGroup>
                            <h:selectOneMenu id="menuCiudad"  style="wdith:200px" onkeydown="return blockEnter(event);"
                                             value="#{datosUsuarioVphBean.ciudadSelect}">
                                <f:selectItems value="#{datosUsuarioVphBean.listMunicipios}"/>
                            </h:selectOneMenu>
                            <a4j:outputPanel ajaxRendered="true">
                                <t:message for="menuCiudad" styleClass="errorMessage"/>
                            </a4j:outputPanel>
                        </h:panelGroup>
                        <h:panelGroup>
                            <h:inputText id="Direccion" onkeydown="return blockEnter(event);"  maxlength="30"
                                         value="#{datosUsuarioVphBean.vph.hdvcdirecc}"/>
                            <a4j:outputPanel ajaxRendered="true">
                                <t:message for="Direccion" styleClass="errorMessage"/>
                            </a4j:outputPanel>
                        </h:panelGroup>
                        <h:panelGroup>
                            <h:inputText id="Telefono" onkeydown="return blockEnter(event);"  maxlength="15"
                                         value="#{datosUsuarioVphBean.vph.hdvctelefo}"/>
                            <a4j:outputPanel ajaxRendered="true">
                                <t:message for="Telefono" styleClass="errorMessage"/>
                            </a4j:outputPanel>
                        </h:panelGroup>
                        <h:outputText value="Fecha Nacimiento" styleClass="labelTextOblig"/>
                        <h:outputText value="Edad" styleClass="labelTextOblig"/>
                        <h:outputText value="Tipo de Afiliación" styleClass="labelTextOblig"/>
                        <h:panelGroup id = "panelTextEps" >
                            <h:outputText value="EPS" styleClass="labelTextOblig"   
                                          rendered="#{!datosUsuarioVphBean.renderEPS}"/>
                        </h:panelGroup>
                        <h:panelGroup>
                            <t:inputCalendar id="fechaNacimiento" onkeydown="return blockEnter(event);"
                                             monthYearRowClass="yearMonthHeader" weekRowClass="weekHeader"  
                                             title="Formato: dd/mm/yyyy" currentDayCellClass="currentDayCell"
                                             popupDateFormat="dd/MM/yyyy" renderAsPopup="true"
                                             value="#{datosUsuarioVphBean.fechaNacimiento}"
                                             valueChangeListener="#{datosUsuarioVphBean.setFechaNacimiento}"
                                             popupTodayString="Hoy" popupWeekString="Semana" popupButtonString="Fecha"
                                             readonly="false" maxlength="11" size="11"
                                             popupButtonImageUrl="/comun/imagenes/ico_calendario2.gif" renderPopupButtonAsImage="true"
                                             align="top" >
                                <f:validator validatorId="dateMenorIgualValidator"/>
                                <a4j:support id="supportNacimiento" event="onchange"  
                                             action="#{datosUsuarioVphBean.changeEdad}" reRender="panleDatosBasicos">
                                    <a4j:ajaxListener type="org.ajax4jsf.ajax.ForceRender"/>
                                </a4j:support>
                            </t:inputCalendar>
                            <a4j:outputPanel ajaxRendered="true">
                                <t:message for="fechaNacimiento" styleClass="errorMessage"/>
                            </a4j:outputPanel>
                        </h:panelGroup>
                        <h:panelGroup>
                            <h:inputText id="inputEdad" maxlength="4" onkeydown="return blockEnter(event);" disabled="true"
                                         value="#{datosUsuarioVphBean.edad}"/>
                        </h:panelGroup>
                        <a4j:region renderRegionOnly="false">
                            <h:panelGroup>
                                <h:selectOneMenu id="menuAfiliacion"   
                                                 value="#{datosUsuarioVphBean.vph.hdvctipafi}"
                                                 valueChangeListener="#{datosUsuarioVphBean.setCcictipafi}">
                                    <f:selectItems value="#{datosUsuarioVphBean.listTipoAfiliacion}"/>
                                    <a4j:support id="supportMenuAfiliacion" event="onchange"   
                                                 action="#{datosUsuarioVphBean.changeAfiliacion}"
                                                 reRender="panelMnuEps,panelTextEps">
                                        <a4j:ajaxListener type="org.ajax4jsf.ajax.ForceRender"/>
                                    </a4j:support>
                                </h:selectOneMenu>
                                <a4j:outputPanel ajaxRendered="true">
                                    <t:message for="menuAfiliacion" styleClass="errorMessage"/>
                                </a4j:outputPanel>
                            </h:panelGroup>
                        </a4j:region>
                        <h:panelGroup id = "panelMnuEps">
                            <h:selectOneMenu id="menuEps"  
                                             rendered="#{!datosUsuarioVphBean.renderEPS}"
                                             onkeydown="return blockEnter(event);"
                                             value="#{datosUsuarioVphBean.vph.hdvcasegur}">
                                <f:selectItems value="#{datosUsuarioVphBean.listEntidadAdm}"/>
                            </h:selectOneMenu>
                            <a4j:outputPanel ajaxRendered="true">
                                <t:message for="menuEps" styleClass="errorMessage"/>
                            </a4j:outputPanel>
                        </h:panelGroup>
                    </h:panelGrid>
                </s:fieldset>
                <s:fieldset legend="Otros Datos Vph" id="fieldSetInfoBasicaAcompa" styleClass="fieldset">
                    <h:panelGrid columns="4" border="0" cellpadding="0" cellspacing="0" width="100%" id="panelRegionInfoAcompa"
                                 rowClasses="labelText,labelTextInfo">
                        <h:outputText value="Otra Dirección" styleClass="labelTextOblig"/>
                        <h:outputText value="Otro Telefono" styleClass="labelTextOblig"/>
                        <h:outputText value="Departamento" styleClass="labelTextOblig"/>
                        <h:outputText value="Municipio" styleClass="labelTextOblig"/>
                        <h:panelGroup>
                            <h:inputText id="otraDireccion"  maxlength="30" onkeydown="return blockEnter(event);"
                                         value="#{datosUsuarioVphBean.vph.hdvcotrdir}"/>
                            <a4j:outputPanel ajaxRendered="true">
                                <t:message for="otraDireccion" styleClass="errorMessage"/>
                            </a4j:outputPanel>
                        </h:panelGroup>
                        <h:panelGroup>
                            <h:inputText id="otroTelefono"  maxlength="15" onkeydown="return blockEnter(event);"
                                         value="#{datosUsuarioVphBean.vph.hdvcotrtel}"/>
                            <a4j:outputPanel ajaxRendered="true">
                                <t:message for="otroTelefono" styleClass="errorMessage"/>
                            </a4j:outputPanel>
                        </h:panelGroup>
                        <a4j:region renderRegionOnly="false">
                            <h:panelGroup>
                                <h:selectOneMenu id="menuOtroDepartamentos" onkeydown="return blockEnter(event);"
                                                 value="#{datosUsuarioVphBean.departamentoOtroSelect}" 

                                                 valueChangeListener="#{datosUsuarioVphBean.setDepartamentoOtroSelect}">
                                    <f:selectItems value="#{datosUsuarioVphBean.listOtrosDepartamentos}"/>
                                    <a4j:support id="supportOtroDepartamento" oncomplete="jsFunctionOtroDepartamento()"
                                                 action="#{datosUsuarioVphBean.changeOtraCiudad}" reRender="panleDatosBasicos"
                                                 event="onchange"  >
                                        <a4j:ajaxListener type="org.ajax4jsf.ajax.ForceRender"/>
                                    </a4j:support>
                                </h:selectOneMenu>
                                <a4j:outputPanel ajaxRendered="true">
                                    <t:message for="menuOtroDepartamentos" styleClass="errorMessage"/>
                                </a4j:outputPanel>
                            </h:panelGroup>
                        </a4j:region>
                        <a4j:region renderRegionOnly="false">
                            <h:panelGroup>
                                <h:selectOneMenu id="menuOtraCiudad"  onkeydown="return blockEnter(event);"
                                                 value="#{datosUsuarioVphBean.ciudadOtraSelect}">
                                    <f:selectItems value="#{datosUsuarioVphBean.listOtrosMunicipios}"/>
                                </h:selectOneMenu>
                                <a4j:outputPanel ajaxRendered="true">
                                    <t:message for="menuOtraCiudad" styleClass="errorMessage"/>
                                </a4j:outputPanel>
                            </h:panelGroup>
                        </a4j:region>


                        <h:outputText value=" Identidad Género" styleClass="labelTextOblig"/>
                        <h:outputText value=" Vulnerabilidad" styleClass="labelTextOblig"/>
                        <h:outputText />
                        <h:outputText />
                        <h:panelGroup>
                            <h:selectOneMenu id="ideGen" onkeydown="return blockEnter(event);"
                                             value="#{datosUsuarioVphBean.vph.hdvcidengen}">
                                <f:selectItems value="#{datosUsuarioVphBean.listIdentidadGenero}"/>
                            </h:selectOneMenu>
                            <a4j:outputPanel ajaxRendered="true">
                                <t:message for="ideGen" styleClass="errorMessage"/>
                            </a4j:outputPanel>
                        </h:panelGroup>
                        <a4j:region renderRegionOnly="false">
                                    <h:panelGroup>
                                    <h:selectManyCheckbox id="idVulnerabilidad" required="true" immediate="true" layout="pageDirection"
                                    onkeydown="return blockEnter(event);"
                                    value="#{datosUsuarioVphBean.lstVulnerabilidadSelect}">
                            <f:selectItems value="#{datosUsuarioVphBean.listVulnerabilidad}"/>
                            </h:selectManyCheckbox>
                            <a4j:outputPanel ajaxRendered="true">
                                <t:message for="idVulnerabilidad" styleClass="errorMessage"/>
                            </a4j:outputPanel>
                            </h:panelGroup>
                        </a4j:region>

                    </h:panelGrid>
                    <h:outputText value=""/>
                </s:fieldset>
                <h:panelGrid columns="2" border="0" cellpadding="0" cellspacing="0" width="100%" id="panelBotonModificar"
                             columnClasses="panelGridBotones">
                    <h:panelGroup>
                        <h:commandButton value="Guardar" styleClass="boton_fieldset"
                                         action="#{datosUsuarioVphBean.guardarUsuario}">
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
    <script language="javascript" type="text/javascript">
        document.forms[1].elements[6].focus()
    </script>
</h:panelGrid>