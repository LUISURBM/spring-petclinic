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
                     selectedIndex = "#{datosBasicosUsuarioBean.selectedIndex}"
                     inactiveSubStyleClass="inactiveSub" tabContentStyleClass="tabContent">
    <t:panelTab id="panelTabDatosUsuario" label="Datos Usuario">
      <s:fieldset legend="Datos Basicos Usuario(a)" id="fieldSetInfoBasica" styleClass="fieldset">
                <h:panelGrid columns="8" border="0" cellpadding="0" cellspacing="0" width="100%"
                             id="panelRegionInfoConsulta" rowClasses="labelText,labelTextInfo">
                    <h:outputText value="Tipo Identificación" styleClass="labelTextOblig"/>
                    <h:outputText value=""/>
                    <h:outputText value=" Número Identificación" styleClass="labelTextOblig"/>
                    <h:outputText value=""/>
                    <h:outputText value="Número Usuario" styleClass="labelTextOblig"/>
                    <h:outputText value=""/>
                    <h:outputText value="Como desea ser llamado" style="color:orange"/>
                    <h:outputText value=""/>
                    <h:selectOneMenu id="tipoIde" disabled="true"
                                     value="#{datosBasicosUsuarioBean.usuario.husetipoiden}"
                                     onkeydown="return blockEnter(event);">
                        <f:selectItems value="#{datosBasicosUsuarioBean.listTipoIdentificacion}"/>
                    </h:selectOneMenu>
                    <h:outputText value=""/>
                    <h:inputText id="itNumeroIdentificacion" maxlength="15" disabled="true"
                                 value="#{datosBasicosUsuarioBean.usuario.husanumeiden}"
                                 onkeydown="return blockEnter(event);"></h:inputText>
                    <a4j:outputPanel ajaxRendered="true">
                        <t:message for="itNumeroIdentificacion" styleClass="errorMessage"/>
                    </a4j:outputPanel>
                    <h:inputText id="itNumeroUsuario" disabled="true" maxlength="12"
                                 value="#{datosBasicosUsuarioBean.usuario.huslnumero}"
                                 onkeydown="return blockEnter(event);"/>
                    <h:outputText value=""/>
                    <h:inputText id="itComoDeseaSerLlamado" maxlength="80" required="true" disabled="true"
                                 value="#{datosBasicosUsuarioBean.usuario.huscnombralter}"
                                 onkeydown="return blockEnter(event);"></h:inputText>
                    <a4j:outputPanel ajaxRendered="true">
                        <t:message for="itComoDeseaSerLlamado" styleClass="errorMessage"/>
                    </a4j:outputPanel>
                    <h:outputText value="Primer Nombre" styleClass="labelTextOblig"/>
                    <h:outputText value=""/>
                    <h:outputText value="Segundo Nombre"/>
                    <h:outputText value=""/>
                    <h:outputText value="Primer Apellido" styleClass="labelTextOblig"/>
                    <h:outputText value=""/>
                    <h:outputText value="Segundo Apellido"/>
                    <h:outputText value=""/>
                    <h:inputText id="primerNombre" onkeydown="return blockEnter(event);" maxlength="20"
                                 value="#{datosBasicosUsuarioBean.usuario.huscprimernomb}" disabled="true"></h:inputText>
                    <a4j:outputPanel ajaxRendered="true">
                        <t:message for="primerNombre" styleClass="errorMessage"/>
                    </a4j:outputPanel>
                    <h:inputText id="segundoNombre" onkeydown="return blockEnter(event);"
                                 value="#{datosBasicosUsuarioBean.usuario.huscsegundnomb}" maxlength="20"
                                 disabled="true"></h:inputText>
                    <a4j:outputPanel ajaxRendered="true">
                        <t:message for="segundoNombre" styleClass="errorMessage"/>
                    </a4j:outputPanel>
                    <h:inputText id="primerApellido" onkeydown="return blockEnter(event);" maxlength="20"
                                 value="#{datosBasicosUsuarioBean.usuario.huscprimerapel}" disabled="true"></h:inputText>
                    <a4j:outputPanel ajaxRendered="true">
                        <t:message for="primerApellido" styleClass="errorMessage"/>
                    </a4j:outputPanel>
                    <h:inputText id="segundoApellido" onkeydown="return blockEnter(event);" maxlength="20"
                                 value="#{datosBasicosUsuarioBean.usuario.huscsegundapel}" disabled="true"></h:inputText>
                    <a4j:outputPanel ajaxRendered="true">
                        <t:message for="segundoApellido" styleClass="errorMessage"/>
                    </a4j:outputPanel>
                    <h:outputText value="Identidad de Genero" styleClass="labelTextOblig"/>
                    <h:outputText value=""/>
                    <h:outputText value="Sexo" styleClass="labelTextOblig"/>
                    <h:outputText value=""/>
                    <h:outputText value="Fecha Nacimiento" styleClass="labelTextOblig"/>
                    <h:outputText value=""/>
                    <h:outputText value="Edad" styleClass="labelTextOblig"/>
                    <h:outputText value=""/>
                    <h:panelGroup>
                        <h:selectOneMenu id="ideGen" onkeydown="return blockEnter(event);" required="true"
                                         value="#{datosBasicosUsuarioBean.usuario.huscidengene}">
                            <f:selectItems value="#{datosBasicosUsuarioBean.listIdentidadGenero}"/>
                        </h:selectOneMenu>
                    </h:panelGroup>
                    <a4j:outputPanel ajaxRendered="true">
                        <t:message for="ideGen" styleClass="errorMessage"/>
                    </a4j:outputPanel>
                    <h:selectOneMenu id="radioSexo" onkeydown="return blockEnter(event);"
                                     value="#{datosBasicosUsuarioBean.usuario.husesexo}" disabled="true">
                        <f:selectItems value="#{datosBasicosUsuarioBean.listSexos}"/>
                    </h:selectOneMenu>
                    <a4j:outputPanel ajaxRendered="true">
                        <t:message for="radioSexo" styleClass="errorMessage"/>
                    </a4j:outputPanel>
                    <a4j:region renderRegionOnly="false">
                        <t:inputCalendar id="fechaNacimiento" onkeydown="return blockEnter(event);"
                                         monthYearRowClass="yearMonthHeader" weekRowClass="weekHeader"
                                         title="Formato: dd/mm/yyyy" currentDayCellClass="currentDayCell"
                                         popupDateFormat="dd/MM/yyyy" renderAsPopup="true"
                                         value="#{datosBasicosUsuarioBean.usuario.husdfechanacim}"
                                         valueChangeListener="#{datosBasicosUsuarioBean.usuario.setHusdfechanacim}"
                                         popupTodayString="Hoy" popupWeekString="Semana" popupButtonString="Fecha"
                                         readonly="false" maxlength="11" size="11"
                                         popupButtonImageUrl="/comun/imagenes/ico_calendario2.gif"
                                         renderPopupButtonAsImage="true" align="top" disabled="true">
                            <f:validator validatorId="dateMenorActualValidator"/>
                            <a4j:support id="supportNacimiento" event="onchange"
                                         action="#{datosBasicosUsuarioBean.changeFechaNacimiento}"
                                         reRender="panelRegionInfoConsulta">
                                <a4j:ajaxListener type="org.ajax4jsf.ajax.ForceRender"/>
                            </a4j:support>
                        </t:inputCalendar>
                    </a4j:region>
                    <a4j:outputPanel ajaxRendered="true">
                        <t:message for="fechaNacimiento" styleClass="errorMessage"/>
                    </a4j:outputPanel>
                    <h:inputText id="inputEdad" onkeydown="return blockEnter(event);" maxlength="4" disabled="true"
                                 value="#{datosBasicosUsuarioBean.usuario.edad}"/>
                    <h:outputText value=""/>
                    <h:outputText value="Estado Civil" styleClass="labelTextOblig"/>
                    <h:outputText value=""/>
                    <h:outputText value="País de residencia habitual" styleClass="labelTextOblig"/>
                    <h:outputText value=""/>
                    <h:outputText value="Departamento" styleClass="labelTextOblig"/>
                    <h:outputText value=""/>
                    <h:outputText value="Municipio" styleClass="labelTextOblig"/>
                    <h:outputText value=""/>
                    <h:selectOneMenu id="radioEstadoCivil" onkeydown="return blockEnter(event);"
                                     value="#{datosBasicosUsuarioBean.usuario.huseestadcivil}" disabled="true">
                        <f:selectItems value="#{datosBasicosUsuarioBean.listEstadoCivil}"/>
                    </h:selectOneMenu>
                    <a4j:outputPanel ajaxRendered="true">
                        <t:message for="radioEstadoCivil" styleClass="errorMessage"/>
                    </a4j:outputPanel>
                    
                    <h:selectOneMenu id="menuPais" onkeydown="return blockEnter(event);"
                              value="#{datosBasicosUsuarioBean.usuario.huscpaisresi}"
                              disabled="true">
                        <f:selectItems value="#{datosBasicosUsuarioBean.listPaises}"/>
                    </h:selectOneMenu>
                    <a4j:outputPanel ajaxRendered="true">
                        <t:message for="menuPais" styleClass="errorMessage"/>
                    </a4j:outputPanel>
                    
                    <h:selectOneMenu id="menuDepartamentos" onkeydown="return blockEnter(event);"
                                     value="#{datosBasicosUsuarioBean.usuario.husndepartamen}"
                                     valueChangeListener="#{datosBasicosUsuarioBean.setDepartamentoSelect}"
                                     disabled="true">
                        <f:selectItems value="#{datosBasicosUsuarioBean.listDepartamentos}"/>
                        <a4j:support id="support7" action="#{datosBasicosUsuarioBean.changeCiudad}"
                                     reRender="panelRegionInfoConsulta" event="onchange">
                            <a4j:ajaxListener type="org.ajax4jsf.ajax.ForceRender"/>
                        </a4j:support>
                    </h:selectOneMenu>
                    <a4j:outputPanel ajaxRendered="true">
                        <t:message for="menuDepartamentos" styleClass="errorMessage"/>
                    </a4j:outputPanel>
                    <h:selectOneMenu id="menuCiudad" onkeydown="return blockEnter(event);"
                                     value="#{datosBasicosUsuarioBean.usuario.husnciudad}" disabled="true">
                        <f:selectItems value="#{datosBasicosUsuarioBean.listMunicipios}"/>
                    </h:selectOneMenu>
                    <a4j:outputPanel ajaxRendered="true">
                        <t:message for="menuCiudad" styleClass="errorMessage"/>
                    </a4j:outputPanel>
                    <h:outputText value="Zona" styleClass="labelTextOblig"/>
                    <h:outputText value=""/>
                    <h:outputText value="Barrio " styleClass="labelTextOblig"/>
                    <h:outputText value=""/>
                    <h:outputText value="Dirección" styleClass="labelTextOblig"/>
                    <h:outputText value=""/>
                    <h:outputText value="Teléfono"/>
                    <h:outputText value=""/>
                    <h:selectOneMenu id="radioZona" onkeydown="return blockEnter(event);"
                                     value="#{datosBasicosUsuarioBean.usuario.husezonareside}" disabled="true">
                        <f:selectItems value="#{datosBasicosUsuarioBean.listzona}"/>
                    </h:selectOneMenu>
                    <a4j:outputPanel ajaxRendered="true">
                        <t:message for="radioZona" styleClass="errorMessage"/>
                    </a4j:outputPanel>
                    <h:inputText id="itBarrio" onkeydown="return blockEnter(event);" maxlength="20"
                                 value="#{datosBasicosUsuarioBean.usuario.huscbarrio}" disabled="true"></h:inputText>
                    <a4j:outputPanel ajaxRendered="true">
                        <t:message for="itBarrio" styleClass="errorMessage"/>
                    </a4j:outputPanel>
                    <h:inputText id="Direccion" maxlength="20" onkeydown="return blockEnter(event);"
                                 value="#{datosBasicosUsuarioBean.usuario.huscdireccion}" disabled="true"></h:inputText>
                    <a4j:outputPanel ajaxRendered="true">
                        <t:message for="Direccion" styleClass="errorMessage"/>
                    </a4j:outputPanel>
                    <h:inputText id="Telefono" maxlength="20" onkeydown="return blockEnter(event);"
                                 value="#{datosBasicosUsuarioBean.usuario.husctelefono}" disabled="true"/>
                    <a4j:outputPanel ajaxRendered="true">
                        <t:message for="Telefono" styleClass="errorMessage"/>
                    </a4j:outputPanel>
                    <h:outputText value="Celular" styleClass="labelTextOblig"/>
                    <h:outputText value=""/>
                    <h:outputText value="Correo Electrónico"/>
                    <h:outputText value=" "/>
                    <h:outputText value="Tipo de Afiliación" styleClass="labelTextOblig"/>
                    <h:outputText value=" "/>
                    <h:outputText value="EPS" styleClass="labelTextOblig" rendered="#{datosBasicosUsuarioBean.renderEPS}"/>
                    <h:outputText value="" rendered="#{!datosBasicosUsuarioBean.renderEPS}"/>
                    <h:outputText value=" "/>
                    <h:inputText id="Celular" maxlength="20" onkeydown="return blockEnter(event);" required="true"
                                 value="#{datosBasicosUsuarioBean.usuario.husccelular}" disabled="true"/>
                    <a4j:outputPanel ajaxRendered="true">
                        <t:message for="Celular" styleClass="errorMessage"/>
                    </a4j:outputPanel>
                    <h:inputText id="itCorreo" maxlength="30" onkeydown="return blockEnter(event);"
                                 value="#{datosBasicosUsuarioBean.usuario.husccorreoelec}" disabled="true"/>
                    <a4j:outputPanel ajaxRendered="true">
                        <t:message for="itCorreo" styleClass="errorMessage"/>
                    </a4j:outputPanel>
                    <h:selectOneMenu id="menuAfiliacion" onkeydown="return blockEnter(event);"
                                     value="#{datosBasicosUsuarioBean.usuario.husetipoafilia}" disabled="true">
                        <f:selectItems value="#{datosBasicosUsuarioBean.listTipoAfiliacion}"/>
                    </h:selectOneMenu>
                    <a4j:outputPanel ajaxRendered="true">
                        <t:message for="menuAfiliacion" styleClass="errorMessage"/>
                    </a4j:outputPanel>
                    <h:panelGroup>
                        <h:selectOneMenu id="menuEps" onkeydown="return blockEnter(event);"
                                         value="#{datosBasicosUsuarioBean.usuario.huscentidadadm}" disabled="true" rendered="#{datosBasicosUsuarioBean.renderEPS}">
                            <f:selectItems value="#{datosBasicosUsuarioBean.listEntidadAdm}"/>
                        </h:selectOneMenu>
                    </h:panelGroup>
                    <h:panelGroup>
                        <a4j:outputPanel ajaxRendered="true" rendered="#{datosBasicosUsuarioBean.renderEPS}">
                            <t:message for="menuEps" styleClass="errorMessage"/>
                        </a4j:outputPanel>
                    </h:panelGroup>
                    <h:panelGroup>
                        <h:outputText value="Orientación Sexual" styleClass="labelTextOblig"
                                      rendered="#{datosBasicosUsuarioBean.renderOrientacionSexual}"/>
                    </h:panelGroup>
                    <h:outputText value=""/>
                    <h:outputText value="Ocupación" styleClass="labelTextOblig"/>
                    <h:outputText/>
                    <h:panelGroup>
                        <h:outputText value="Vive solo(a)" styleClass="labelTextOblig" rendered="false"/>
                    </h:panelGroup>
                    <h:outputText/>
                    <h:outputText/>
                    <h:outputText/>
                    <h:panelGroup>
                        <h:selectOneMenu id="radioOrienSex" onkeydown="return blockEnter(event);"
                                         required="#{datosBasicosUsuarioBean.renderOrientacionSexual}"
                                         rendered="#{datosBasicosUsuarioBean.renderOrientacionSexual}"
                                         value="#{datosBasicosUsuarioBean.usuario.huscoriesexu}">
                            <f:selectItems value="#{datosBasicosUsuarioBean.listOrientacionSexual}"/>
                        </h:selectOneMenu>
                    </h:panelGroup>
                    <a4j:outputPanel ajaxRendered="true">
                        <t:message for="radioOrienSex" styleClass="errorMessage"
                                   rendered="#{datosBasicosUsuarioBean.renderOrientacionSexual}"/>
                    </a4j:outputPanel>
                    <h:panelGroup>
                        <a4j:region renderRegionOnly="false">
                            <h:inputText id="itOcupacion" value="#{datosBasicosUsuarioBean.usuario.husnocupacion}"
                                         valueChangeListener="#{datosBasicosUsuarioBean.setOcupacion}"
                                         binding="#{datosBasicosUsuarioBean.itOcupacion}" immediate="true"
                                         disabled="true" style="width:50px">
                                <f:validateLength maximum="6"/>
                                <a4j:support id="supportOcupa" event="onchange"
                                             action="#{datosBasicosUsuarioBean.changeSeleccionOcupacion}"
                                             reRender="panelOcupacionSeleccion" immediate="true">
                                    <a4j:ajaxListener type="org.ajax4jsf.ajax.ForceRender"/>
                                </a4j:support>
                            </h:inputText>
                            <h:panelGrid columns="1" border="0" cellpadding="0" cellspacing="2"
                                         id="panelOcupacionSeleccion">
                                <h:outputText value=" #{datosBasicosUsuarioBean.seleccionOcupacion}"
                                              styleClass="buscador"/>
                            </h:panelGrid>
                        </a4j:region>
                    </h:panelGroup>
                    <a4j:outputPanel ajaxRendered="true">
                        <t:message for="itOcupacion" styleClass="errorMessage"/>
                    </a4j:outputPanel>
                    <h:panelGroup>
                        <h:selectOneRadio id="mnuViveSolo" onkeydown="return blockEnter(event);" required="true"
                                          value="#{datosBasicosUsuarioBean.usuario.huscvivesolo}" rendered="false">
                            <f:selectItems value="#{antecedentesGinecologicosUsuarioBean.lstOpciones}"/>
                        </h:selectOneRadio>
                    </h:panelGroup>
                    <a4j:outputPanel ajaxRendered="true">
                        <t:message for="mnuViveSolo" styleClass="errorMessage"
                                   rendered="#{datosBasicosUsuarioBean.renderViveSola}"/>
                    </a4j:outputPanel>
                </h:panelGrid>
            </s:fieldset>
      <s:fieldset legend="Datos Acompañante" id="fieldSetInfoBasicaAcompa" styleClass="fieldset">
        <h:panelGrid columns="3" border="0" cellpadding="0" cellspacing="0" width="100%" id="panelRegionInfoAcompa"
                     rowClasses="labelText,labelTextInfo">
          <h:outputText value="Acompañante" styleClass="labelTextOblig"/>
          <h:outputText value="Teléfono Acompañante" styleClass="labelTextOblig"/>
          <h:outputText value=""/>
          <h:panelGroup>
            <h:inputText id="itAcom" maxlength="40" immediate="true" onkeydown="return blockEnter(event);" required="true" 
                         value="#{datosBasicosUsuarioBean.usuario.huscnomacompana}"> 
                    <f:validateLength minimum="1" />
                     <a4j:support id="idAcomp"                         
                             event="onchange"  >
                                <a4j:ajaxListener type="org.ajax4jsf.ajax.ForceRender"/>
                            </a4j:support>
            </h:inputText>
            <a4j:outputPanel ajaxRendered="true">
              <t:message for="itAcom" styleClass="errorMessage"/>
            </a4j:outputPanel>
          </h:panelGroup>
          <h:panelGroup>
          <h:inputText id = "itTelAcom" immediate="true" onkeydown="return blockEnter(event);" 
                        required="true"
                        maxlength="20"
                       value="#{datosBasicosUsuarioBean.usuario.husctelacompana}">
                       <f:validateLength minimum="1" />
                        <a4j:support id="idOtroTel"                         
                             event="onchange"  >
                                <a4j:ajaxListener type="org.ajax4jsf.ajax.ForceRender"/>
                            </a4j:support>
            </h:inputText>
                        <a4j:outputPanel ajaxRendered="true">
              <t:message for="itTelAcom" styleClass="errorMessage"/>
            </a4j:outputPanel>
                       </h:panelGroup>
          <h:outputText/>
          <h:outputText value="Responsable" styleClass="labelTextOblig"/>
          <h:outputText value="Parentesco" styleClass="labelTextOblig"/>
          <h:outputText value="Teléfono Responsable" styleClass="labelTextOblig"/>
          <h:panelGroup>
            <h:inputText id="itRespon" maxlength="40" onkeydown="return blockEnter(event);" required="true" 
                         value="#{datosBasicosUsuarioBean.usuario.huscnomresponsa}">
                         <f:validateLength minimum="1" />
            </h:inputText>
            <a4j:outputPanel ajaxRendered="true">
              <t:message for="itRespon" styleClass="errorMessage"/>
            </a4j:outputPanel>
          </h:panelGroup>
          <h:panelGroup>
            <h:inputText id="itParen" maxlength="15" onkeydown="return blockEnter(event);" required="true"
                         value="#{datosBasicosUsuarioBean.usuario.huscparresponsa}">
                         <f:validateLength minimum="1" />
            </h:inputText>
            <a4j:outputPanel ajaxRendered="true">
              <t:message for="itParen" styleClass="errorMessage"/>
            </a4j:outputPanel>
          </h:panelGroup>
          <h:panelGroup>
          <h:inputText id = "itTelResp" onkeydown="return blockEnter(event);" maxlength="20" required="true"
                       value="#{datosBasicosUsuarioBean.usuario.husctelresponsa}">
                       <f:validateLength minimum="1" />
            </h:inputText>
                 <a4j:outputPanel ajaxRendered="true">  
              <t:message for="itTelResp" styleClass="errorMessage"/>
            </a4j:outputPanel>       
                       </h:panelGroup>
        </h:panelGrid>
        <h:outputText value=""/>
      </s:fieldset>
      <s:fieldset legend="Información Contacto" id="fieldInformacionContacto" styleClass="fieldset"
                  rendered="#{datosBasicosUsuarioBean.renderContacto}">
        <h:panelGrid columns="2" border="0" cellpadding="0" cellspacing="0" width="100%" id="panelAutorizaContacto"
                     rowClasses="labelText,labelTextInfo">
          <h:outputText value="Autorizo a Profamilia para contactarme"/>
          <h:outputText/>
          <h:selectOneRadio id="mnuAutorizo"  value="#{datosBasicosUsuarioBean.usuario.huseautorcont}"
                            valueChangeListener="#{datosBasicosUsuarioBean.setHuseautorcont}">
            <f:selectItems value="#{datosBasicosUsuarioBean.lstOpciones}"/>
            <a4j:support id="supportmnuAutorizo" event="onclick" 
                         action="#{datosBasicosUsuarioBean.changeAutorizo}" reRender="fieldInformacionContacto">
              <a4j:ajaxListener type="org.ajax4jsf.ajax.ForceRender"/>
            </a4j:support>
          </h:selectOneRadio>
          <a4j:outputPanel ajaxRendered="true">
            <t:message for="mnuAutorizo" styleClass="errorMessage"/>
          </a4j:outputPanel>
        </h:panelGrid>
        <h:panelGrid columns="8" border="0" cellpadding="0" cellspacing="0" width="100%" id="panelInformacionContacto"
                      rowClasses="labelText,labelTextInfo">
          <h:outputText value="Oficina"/>
          <h:panelGroup id="panelTextTelefonoOficina">
            <h:outputText value="Telefono"/>
          </h:panelGroup>
          <h:outputText/>
          <h:outputText value="Celular"/>
          <h:panelGroup id="panelTextTelefonoCelular">
            <h:outputText value="Telefono"/>
          </h:panelGroup>
          <h:outputText value=""/>
          <h:outputText value=""/>
          <h:outputText value=""/>
          <h:selectBooleanCheckbox id="checkOficina" onkeydown="return blockEnter(event);"
                                disabled="#{!datosBasicosUsuarioBean.renderAutoriza}"
                                   value="#{datosBasicosUsuarioBean.renderOficina}" ></h:selectBooleanCheckbox>
          <h:panelGroup id="panelInputTelefonoOficina">
            <h:inputText id="itTelOfi" value="#{datosBasicosUsuarioBean.usuario.huscteloficina}"/>
          </h:panelGroup>
          <h:outputText/>
          <h:selectBooleanCheckbox id="checkCelular" onkeydown="return blockEnter(event);"
                                    disabled="#{!datosBasicosUsuarioBean.renderAutoriza}"
                                   value="#{datosBasicosUsuarioBean.renderCelular}" ></h:selectBooleanCheckbox>
          <h:panelGroup id="panelInputTelefonoCelular">
            <h:inputText id="itTelefonoCelular" value="#{datosBasicosUsuarioBean.usuario.husccelular}"/>
          </h:panelGroup>
          <h:outputText/>
          <h:outputText value=""/>
          <h:outputText/>
          <h:outputText value="Casa"/>
          <h:panelGroup id="panelTextTelefonoCasa">
            <h:outputText value="Telefono"/>
          </h:panelGroup>
          <h:outputText/>
          <h:outputText value="Correo Electronico"/>
          <h:panelGroup id="panelTextDireccion">
            <h:outputText value="Dirección"/>
          </h:panelGroup>
          <h:outputText/>
          <h:outputText value=""/>
          <h:outputText value="Mensajes de Texto"/>
          <h:selectBooleanCheckbox id="checkCasa" onkeydown="return blockEnter(event);"
                                    disabled="#{!datosBasicosUsuarioBean.renderAutoriza}"
                                   value="#{datosBasicosUsuarioBean.renderCasa}" ></h:selectBooleanCheckbox>
          <h:panelGroup id="panelInputTelefonoCasa">
            <h:inputText id="itTeleCasa" disabled="true" value="#{datosBasicosUsuarioBean.usuario.husctelefono}"/>
          </h:panelGroup>
          <h:outputText/>
          <h:selectBooleanCheckbox id="checkCorreo" onkeydown="return blockEnter(event);"
                                 disabled="#{!datosBasicosUsuarioBean.renderAutoriza}"
                                   value="#{datosBasicosUsuarioBean.renderCorreo}" ></h:selectBooleanCheckbox>
          <h:panelGroup id="panelInputDireccion">
            <h:inputText id="itDireccionElectronica" disabled="true"
            value="#{datosBasicosUsuarioBean.usuario.husccorreoelec}"/>
          </h:panelGroup>
          <h:outputText/>
           <h:outputText/>
          <h:selectBooleanCheckbox id="checkMensajesTexto" onkeydown="return blockEnter(event);"
                                  disabled="#{!datosBasicosUsuarioBean.renderAutoriza}"
                                   value="#{datosBasicosUsuarioBean.renderMensajes}" ></h:selectBooleanCheckbox>
        </h:panelGrid>
      </s:fieldset>
      <s:fieldset legend="Consentimiento Informado" id="fieldConsentimiento" styleClass="fieldset" rendered="#{datosBasicosUsuarioBean.renderConsentimiento}">
       <h:panelGrid columns="1" border="0" cellpadding="0" cellspacing="0" width="100%" 
                 id="panelDatosConsentimiento" rowClasses="labelText,labelTextInfo">
      <h:outputText value="¿Se diligencia consentimiento informado ?" styleClass="labelTextOblig"/>
      <a4j:region renderRegionOnly="false">
        <h:selectOneRadio id="mnuConsentimiento" onkeydown="return blockEnter(event);" required="true" immediate="true"
                          value="#{datosBasicosUsuarioBean.usuario.hcocreaconinf}"
                          valueChangeListener="#{datosBasicosUsuarioBean.setHcocreaconinf}">
          <f:selectItems value="#{datosBasicosUsuarioBean.lstOpciones}"/>
          <a4j:support id="supportmnuConsentimiento" immediate="true"
                       action="#{datosBasicosUsuarioBean.changeConsentimiento}"
                       reRender="panelInputCualConsentimiento,panelTextAutoUsoDatos,panelInputAutoUsoDatos,panelLupaConsentimientos,fieldConsentimiento"
                       event="onclick">
            <a4j:ajaxListener type="org.ajax4jsf.ajax.ForceRender"/>
          </a4j:support>
        </h:selectOneRadio>
        <a4j:outputPanel ajaxRendered="true">
          <t:message for="mnuConsentimiento" styleClass="errorMessage"/>
        </a4j:outputPanel>
      </a4j:region>
      
          <h:panelGrid columns="2" border="0" cellpadding="0" cellspacing="0" width="100%" id="panelLupaConsentimientos"
                       rowClasses="labelText,labelTextInfo">
            <h:outputText value="¿Cuál consentimiento se diligencia?" styleClass="labelTextOblig" rendered="#{datosBasicosUsuarioBean.renderRealizaConsentimiento}"/>
            <h:outputText/>
            <a4j:region renderRegionOnly="false">
            <h:panelGrid columns="2" border="0" cellpadding="0" cellspacing="0" width="100%" id="panelBotonConsulta">
             <a4j:commandLink value="Agregar" immediate="true" title="Seleccionar Concentimiento"
                               rendered="#{datosBasicosUsuarioBean.renderRealizaConsentimiento}"
                               action="#{datosBasicosUsuarioBean.consultarConsentimientos}"
                               reRender="panelGridDatosUsuarioTab" id="lupaConsentimiento">
                <a4j:ajaxListener type="org.ajax4jsf.ajax.ForceRender"/>
                <t:graphicImage alt=""  border="0" url="/comun/imagenes/lupa.gif"/>
              </a4j:commandLink>
              <a4j:outputPanel ajaxRendered="true">
                <t:message for="lupaConsentimiento" styleClass="errorMessage"/>
              </a4j:outputPanel>
            </h:panelGrid>
            </a4j:region>
          </h:panelGrid>
          <h:panelGrid columns="1" border="0" cellpadding="0" cellspacing="0" width="100%"
                       id="panelTablaConsentimientos" styleClass="tabContainer" rendered="#{not empty datosBasicosUsuarioBean.lstConsentimientoAceptados && datosBasicosUsuarioBean.renderRealizaConsentimiento}">
            <t:buffer into="#{table}">
              <h:dataTable var="item" border="1" cellpadding="0" cellspacing="0"
                           binding="#{datosBasicosUsuarioBean.dtConsentimiento}"
                           value="#{datosBasicosUsuarioBean.lstConsentimientoAceptados}" rows="10" styleClass="standard_table"
                           rowClasses="standardTable_Row1,standardTable_Row2" footerClass="paginacion" id="dtConsentimientos" >
                <h:column>
                  <f:facet name="header">
                    <h:outputText value="Codigo"/>
                  </f:facet>
                  <h:outputText value="#{item.hpciccodigo}"/>
                </h:column>
                <h:column>
                  <f:facet name="header">
                    <h:outputText value="Nombre"/>
                  </f:facet>
                  <h:outputText value="#{item.hpcicnombre}"/>
                </h:column>
                <h:column>
                  <f:facet name="header">
                    <h:outputText value="Eliminar"/>
                  </f:facet>
                  <h:commandLink id="eliminar" immediate="true" rendered="#{!item.modoconsulta}"
                                 action="#{datosBasicosUsuarioBean.eliminarConsentimiento}">
                    <t:graphicImage alt=""  border="0" url="/comun/imagenes/quitar.gif"/>
                  </h:commandLink>
                </h:column>
              </h:dataTable>
            </t:buffer>
            <t:buffer into="#{tableScroller}">
              <h:panelGrid columns="1" rowClasses="labelTextInfo,labelTextInfo">
                <t:dataScroller id="scroll_1" for="dtConsentimientos" fastStep="10" pageCountVar="pageCount"
                                pageIndexVar="pageIndex" styleClass="scroller" paginator="true" immediate="true"
                                paginatorMaxPages="9" paginatorTableClass="paginator" renderFacetsIfSinglePage="false"
                                paginatorActiveColumnStyle="font-weight:bold;">
                  <f:facet name="first">
                    <t:graphicImage alt=""  url="/comun/imagenes/primero.gif" border="0"/>
                  </f:facet>
                  <f:facet name="last">
                    <t:graphicImage alt=""  url="/comun/imagenes/ultimo.gif" border="0"/>
                  </f:facet>
                  <f:facet name="previous">
                    <t:graphicImage alt=""  url="/comun/imagenes/anterior.gif" border="0"/>
                  </f:facet>
                  <f:facet name="next">
                    <t:graphicImage alt=""  url="/comun/imagenes/siguiente.gif" border="0"/>
                  </f:facet>
                  <f:facet name="fastforward">
                    <t:graphicImage alt=""  url="/comun/imagenes/adelante.gif" border="0"/>
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
      <h:panelGroup id="panelTextAutoUsoDatos">
        <h:outputText value="¿El paciente autoriza el uso de los datos clínicos con fines de investigación científica?" 
                        rendered="#{datosBasicosUsuarioBean.renderRealizaConsentimiento}" styleClass="labelTextOblig"/>
      </h:panelGroup>
      <h:panelGroup id="panelInputAutoUsoDatos">
        <h:selectOneRadio id="mnuAutoUsoDato" onkeydown="return blockEnter(event);" 
                          required="true" immediate="true" rendered="#{datosBasicosUsuarioBean.renderRealizaConsentimiento}"
                          value="#{datosBasicosUsuarioBean.usuario.hcocautusodat}">
          <f:selectItems value="#{datosBasicosUsuarioBean.lstOpciones}"/>
        </h:selectOneRadio>
        <a4j:outputPanel ajaxRendered="true" rendered="#{datosBasicosUsuarioBean.renderRealizaConsentimiento}">
          <t:message for="mnuAutoUsoDato" styleClass="errorMessage"/>
        </a4j:outputPanel>
      </h:panelGroup>
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
                           action="#{datosBasicosUsuarioBean.guardarUsuario}">
            <a4j:support event="onclick" status="statusButton"/>
          </h:commandButton>
        </h:panelGroup>
      </h:panelGrid>
    </t:panelTab>
    
    <t:panelTab id="panelTabBuscadorConsentimiento" label="Buscar Consentimiento"
                rendered="#{datosBasicosUsuarioBean.mostrarConsentimiento}">
      <s:fieldset legend="Consentimientos" id="fieldSetConsentimiento" styleClass="fieldset">
          <jsp:include page="/pages/clinico/registro/buscadorConsentimiento.jsp" flush="true"/>
          <h:panelGrid id="panelGridConsentimiento0Botones" width="100%" columnClasses="columnaBotonesCentrados" dir="RTL">
            <t:htmlTag value="br"/>
            <h:panelGroup id="panelGroupConsentimientoBotones1">
              <a4j:region renderRegionOnly="false">
              <a4j:commandButton value="Aceptar" styleClass="btn btn btn-success" immediate="true"
                                 action="#{datosBasicosUsuarioBean.aceptarConsentimientos}"
                                 reRender="panelGridDatosUsuarioTab">
                <a4j:ajaxListener type="org.ajax4jsf.ajax.ForceRender"/>
              </a4j:commandButton>
              </a4j:region>
            </h:panelGroup>
          </h:panelGrid>
        </s:fieldset>
         </t:panelTab>
    
      <t:panelTab id="panelBuscadorOcupacion" label="Buscar Ocupación"
                rendered="#{datosBasicosUsuarioBean.renderBuscadorOcupacion}">
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
  <f:verbatim>
    <script language="javascript" type="text/javascript">
        document.forms[1].elements[6].focus()
</script>
  </f:verbatim>
</h:panelGrid>