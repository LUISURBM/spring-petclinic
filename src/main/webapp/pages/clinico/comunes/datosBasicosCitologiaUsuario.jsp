<%@ page contentType="text/html;charset=iso-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsf/html" prefix="h"%>
<%@ taglib uri="http://java.sun.com/jsf/core" prefix="f"%>
<%@ taglib uri="http://richfaces.org/a4j" prefix="a4j"%>
<%@ taglib uri="http://myfaces.apache.org/tomahawk" prefix="t"%>
<%@ taglib uri="http://myfaces.apache.org/sandbox" prefix="s"%>
<a4j:form id="formRegistrarEpicrisis">
<a4j:region id="regionRegistrarEpicrisis" renderRegionOnly="false">
<h:panelGrid columns="1" border="0" cellpadding="0" cellspacing="0" width="100%" id="panelGridDatosUsuarioTab"
             styleClass="tabContainer">
  <t:panelTabbedPane border="0" cellpadding="0" cellspacing="0" serverSideTabSwitch="false" activePanelTabVar="true"
                     width="100%" id="panelTabbedPaneDatosUsuario" styleClass="tabbedPane"
                     activeTabStyleClass="activeTab" inactiveTabStyleClass="inactiveTab"
                     disabledTabStyleClass="disabledTab" activeSubStyleClass="activeSub"
                     selectedIndex = "#{datosUsuarioCitologiaBean.selectedIndex}"
                     inactiveSubStyleClass="inactiveSub" tabContentStyleClass="tabContent">
    <t:panelTab id="panelTabDatosUsuario" disabled="#{datosUsuarioCitologiaBean.mostrarConsentimiento}" label="Datos Usuario">
      <h:panelGrid id="panleDatosBasicos" columns="1" border="0" cellpadding="0" cellspacing="0" width="100%"
                   styleClass="tabContainer">
        <s:fieldset legend="Datos Basicos" id="fieldSetInfoBasica" styleClass="fieldset">
          <h:panelGrid columns="3" border="0" cellpadding="0" cellspacing="0" width="100%" id="panelRegionInfoConsulta"
                       rowClasses="labelText,labelTextInfo">
            <h:outputText value="Clinica" styleClass="labelTextOblig"/>
            <h:outputText value=" Numero Citologia" styleClass="labelTextOblig"/>
            <h:outputText value="Fecha" styleClass="labelTextOblig"/>
            <h:outputText value="#{datosUsuarioCitologiaBean.clinUsuario}"/>
            <h:panelGroup>
              <h:inputText id="inputNumeroCitologia" value="#{datosUsuarioCitologiaBean.citologia.ccinnumero}"
                           onkeydown="return blockEnter(event);" maxlength="9" />
              <a4j:outputPanel ajaxRendered="true">
                <t:message for="inputNumeroCitologia" styleClass="errorMessage"/>
              </a4j:outputPanel>
            </h:panelGroup>
            <h:panelGroup>
              <t:inputCalendar id="fechaActual" onkeydown="return blockEnter(event);"
                               monthYearRowClass="yearMonthHeader" weekRowClass="weekHeader"  
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
              <h:selectOneMenu id="tipoIde"  disabled="true" onkeydown="return blockEnter(event);"
                               value="#{datosUsuarioCitologiaBean.citologia.ccictipide}">
                <f:selectItems value="#{datosUsuarioCitologiaBean.listTipoIdentificacion}"/>
              </h:selectOneMenu>
              <a4j:outputPanel ajaxRendered="true">
                <t:message for="tipoIde" styleClass="errorMessage"/>
              </a4j:outputPanel>
            </h:panelGroup>
            <h:panelGroup>
              <h:inputText id="idtipo" disabled="true"  onkeydown="return blockEnter(event);"
                       styleClass="textmayuscula"
                           maxlength="15" value="#{datosUsuarioCitologiaBean.citologia.ccianumide}" >
                           <f:converter converterId="cadena.stringUpperCaseConverter"/>   
                </h:inputText>
              <a4j:outputPanel ajaxRendered="true">
                <t:message for="idtipo" styleClass="errorMessage"/>
              </a4j:outputPanel>
            </h:panelGroup>
            <h:panelGroup>
              <h:inputText id="itNumeroUsuario" disabled="true" onkeydown="return blockEnter(event);" maxlength="12"
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
              <h:inputText id="primerNombre" disabled="true" onkeydown="return blockEnter(event);" 
              styleClass="textmayuscula"
               maxlength="20"
                            value="#{datosUsuarioCitologiaBean.citologia.ccicprinom}">
                               <f:converter converterId="cadena.stringUpperCaseConverter"/>
                    </h:inputText>
              <a4j:outputPanel ajaxRendered="true">
                <t:message for="primerNombre" styleClass="errorMessage"/>
              </a4j:outputPanel>
            </h:panelGroup>
            <h:panelGroup>
              <h:inputText id="segundoNombre" disabled="true" styleClass="textmayuscula"
                           onkeydown="return blockEnter(event);" maxlength="20"
                             value="#{datosUsuarioCitologiaBean.citologia.ccicsegnom}">
                                <f:converter converterId="cadena.stringUpperCaseConverter"/>
                </h:inputText>
              <a4j:outputPanel ajaxRendered="true">
                <t:message for="segundoNombre" styleClass="errorMessage"/>
              </a4j:outputPanel>
            </h:panelGroup>
            <h:panelGroup>
              <h:inputText id="primerApellido" disabled="true" onkeydown="return blockEnter(event);" maxlength="20" 
                           value="#{datosUsuarioCitologiaBean.citologia.ccicpriape}"/>
              <a4j:outputPanel ajaxRendered="true">
                <t:message for="primerApellido" styleClass="errorMessage"/>
              </a4j:outputPanel>
            </h:panelGroup>
            <h:panelGroup>
              <h:inputText id="segundoApellido" disabled="true" onkeydown="return blockEnter(event);" maxlength="20"
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
              <h:selectOneMenu id="menuDepartamentos" disabled="true" value="#{datosUsuarioCitologiaBean.departamentoSelect}"
                                 onkeydown="return blockEnter(event);"
                               valueChangeListener="#{datosUsuarioCitologiaBean.setDepartamentoSelect}">
                <f:selectItems value="#{datosUsuarioCitologiaBean.listDepartamentos}"/>
                <a4j:support id="support7" oncomplete="jsFunctionDepartamento()"
                             action="#{datosUsuarioCitologiaBean.changeCiudad}" reRender="panleDatosBasicos"
                             event="onchange"  >
                  <a4j:ajaxListener type="org.ajax4jsf.ajax.ForceRender"/>
                </a4j:support>
              </h:selectOneMenu>
              <a4j:outputPanel ajaxRendered="true">
                <t:message for="menuDepartamentos" styleClass="errorMessage"/>
              </a4j:outputPanel>
            </h:panelGroup>
            <h:panelGroup>
              <h:selectOneMenu id="menuCiudad" disabled="true"  style="wdith:200px" onkeydown="return blockEnter(event);"
                               value="#{datosUsuarioCitologiaBean.ciudadSelect}">
                <f:selectItems value="#{datosUsuarioCitologiaBean.listMunicipios}"/>
              </h:selectOneMenu>
              <a4j:outputPanel ajaxRendered="true">
                <t:message for="menuCiudad" styleClass="errorMessage"/>
              </a4j:outputPanel>
            </h:panelGroup>
            <h:panelGroup>
              <h:inputText id="Direccion" disabled="true" onkeydown="return blockEnter(event);"  maxlength="30"
                           value="#{datosUsuarioCitologiaBean.citologia.ccicdirecc}"/>
              <a4j:outputPanel ajaxRendered="true">
                <t:message for="Direccion" styleClass="errorMessage"/>
              </a4j:outputPanel>
            </h:panelGroup>
            <h:panelGroup>
              <h:inputText id="Telefono" disabled="true" onkeydown="return blockEnter(event);"  maxlength="15"
                           value="#{datosUsuarioCitologiaBean.citologia.ccictelefo}"/>
              <a4j:outputPanel ajaxRendered="true">
                <t:message for="Telefono" styleClass="errorMessage"/>
              </a4j:outputPanel>
            </h:panelGroup>
            <h:outputText value="Fecha Nacimiento" styleClass="labelTextOblig"/>
            <h:outputText value="Edad" styleClass="labelTextOblig"/>
            <h:outputText value="Tipo de Afiliación" styleClass="labelTextOblig"/>
            <h:panelGroup id = "panelTextEps" >
            <h:outputText value="EPS" styleClass="labelTextOblig"   
                    rendered="#{!datosUsuarioCitologiaBean.renderEPS}"/>
            </h:panelGroup>
            <h:panelGroup>
              <t:inputCalendar id="fechaNacimiento" disabled="true" onkeydown="return blockEnter(event);"
                               monthYearRowClass="yearMonthHeader" weekRowClass="weekHeader"  
                               title="Formato: dd/mm/yyyy" currentDayCellClass="currentDayCell"
                               popupDateFormat="dd/MM/yyyy" renderAsPopup="true"
                               value="#{datosUsuarioCitologiaBean.fechaNacimiento}"
                               valueChangeListener="#{datosUsuarioCitologiaBean.setFechaNacimiento}"
                               popupTodayString="Hoy" popupWeekString="Semana" popupButtonString="Fecha"
                               readonly="false" maxlength="11" size="11"
                               popupButtonImageUrl="/comun/imagenes/ico_calendario2.gif" renderPopupButtonAsImage="true"
                               align="top" >
                    <f:validator validatorId="dateMenorIgualValidator"/>
                <a4j:support id="supportNacimiento" event="onchange"  
                             action="#{datosUsuarioCitologiaBean.changeEdad}" reRender="panleDatosBasicos">
                  <a4j:ajaxListener type="org.ajax4jsf.ajax.ForceRender"/>
                </a4j:support>
              </t:inputCalendar>
              <a4j:outputPanel ajaxRendered="true">
                <t:message for="fechaNacimiento" styleClass="errorMessage"/>
              </a4j:outputPanel>
            </h:panelGroup>
            <h:panelGroup>
              <h:inputText id="inputEdad" maxlength="4" onkeydown="return blockEnter(event);" disabled="true"
                           value="#{datosUsuarioCitologiaBean.edad}"/>
            </h:panelGroup>
            <a4j:region renderRegionOnly="false">
            <h:panelGroup>
              <h:selectOneMenu id="menuAfiliacion"  disabled="true" 
                               value="#{datosUsuarioCitologiaBean.citologia.ccictipafi}"
                               valueChangeListener="#{datosUsuarioCitologiaBean.setCcictipafi}">
                <f:selectItems value="#{datosUsuarioCitologiaBean.listTipoAfiliacion}"/>
                 <a4j:support id="supportMenuAfiliacion" event="onchange"   
                            action="#{datosUsuarioCitologiaBean.changeAfiliacion}"
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
              <h:selectOneMenu id="menuEps" disabled="true"
                               rendered="#{!datosUsuarioCitologiaBean.renderEPS}"
                               onkeydown="return blockEnter(event);"
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
          <h:panelGrid columns="4" border="0" cellpadding="0" cellspacing="0" width="100%" id="panelRegionInfoAcompa"
                       rowClasses="labelText,labelTextInfo">
            <h:outputText value="Otra Dirección" styleClass="labelTextOblig"/>
            <h:outputText value="Otro Telefono" styleClass="labelTextOblig"/>
            <h:outputText value="Departamento" styleClass="labelTextOblig"/>
            <h:outputText value="Municipio" styleClass="labelTextOblig"/>
            <h:panelGroup>
              <h:inputText id="otraDireccion" immediate="true"  maxlength="30" onkeydown="return blockEnter(event);"
                           value="#{datosUsuarioCitologiaBean.citologia.ccicotrdir}">
                            <a4j:support id="idOtraDirecc"                         
                             event="onchange"  >
                  <a4j:ajaxListener type="org.ajax4jsf.ajax.ForceRender"/>
                </a4j:support>
                           </h:inputText>
              <a4j:outputPanel ajaxRendered="true">
                <t:message for="otraDireccion" styleClass="errorMessage"/>
              </a4j:outputPanel>
            </h:panelGroup>
            <h:panelGroup>
              <h:inputText id="otroTelefono" immediate="true"  maxlength="15" onkeydown="return blockEnter(event);"
                           value="#{datosUsuarioCitologiaBean.citologia.ccicotrtel}">
                              <a4j:support id="idOtroTel"                         
                             event="onchange"  >
                                <a4j:ajaxListener type="org.ajax4jsf.ajax.ForceRender"/>
                            </a4j:support>
                           </h:inputText>
              <a4j:outputPanel ajaxRendered="true">
                <t:message for="otroTelefono" styleClass="errorMessage"/>
              </a4j:outputPanel>
            </h:panelGroup>
            <h:panelGroup>
             <a4j:region renderRegionOnly="false">
              <h:selectOneMenu id="menuOtroDepartamentos" immediate="true" onkeydown="return blockEnter(event);"
                               value="#{datosUsuarioCitologiaBean.departamentoOtroSelect}" 
                                
                               valueChangeListener="#{datosUsuarioCitologiaBean.setDepartamentoOtroSelect}">
                <f:selectItems value="#{datosUsuarioCitologiaBean.listOtrosDepartamentos}"/>
                <a4j:support id="supportOtroDepartamento" oncomplete="jsFunctionOtroDepartamento()"
                             action="#{datosUsuarioCitologiaBean.changeOtraCiudad}" reRender="panelOtraCiudad"
                             event="onchange"  >
                  <a4j:ajaxListener type="org.ajax4jsf.ajax.ForceRender"/>
                </a4j:support>
              </h:selectOneMenu>
              <a4j:outputPanel ajaxRendered="true">
                <t:message for="menuOtroDepartamentos" styleClass="errorMessage"/>
              </a4j:outputPanel>
              </a4j:region>
            </h:panelGroup>
            <h:panelGroup id="panelOtraCiudad">
              <h:selectOneMenu id="menuOtraCiudad" immediate="true"  onkeydown="return blockEnter(event);"
                               value="#{datosUsuarioCitologiaBean.ciudadOtraSelect}">
                <f:selectItems value="#{datosUsuarioCitologiaBean.listOtrosMunicipios}"/>
              </h:selectOneMenu>
              <a4j:outputPanel ajaxRendered="true">
                <t:message for="menuOtraCiudad" styleClass="errorMessage"/>
              </a4j:outputPanel>
            </h:panelGroup>
            
              <h:outputText value=" Identidad Género" styleClass="labelTextOblig"/>
                        <h:outputText value=" Vulnerabilidad" styleClass="labelTextOblig"/>
                        <h:outputText />
                        <h:outputText />
                        <h:panelGroup>
                            <h:selectOneMenu id="ideGen" immediate="true" onkeydown="return blockEnter(event);"
                                             value="#{datosUsuarioCitologiaBean.citologia.ccicidengen}">
                            <a4j:support id="idIdenGen"                         
                                event="onchange"  >
                            <a4j:ajaxListener type="org.ajax4jsf.ajax.ForceRender"/>
                            </a4j:support>
                                <f:selectItems value="#{datosUsuarioCitologiaBean.listIdentidadGenero}"/>
                            </h:selectOneMenu>
                            <a4j:outputPanel ajaxRendered="true">
                                <t:message for="ideGen" styleClass="errorMessage"/>
                            </a4j:outputPanel>
                        </h:panelGroup>
                        <a4j:region renderRegionOnly="false">
                                    <h:panelGroup>
                                    <h:selectManyCheckbox id="idVulnerabilidad"  immediate="true" layout="pageDirection"
                                    onkeydown="return blockEnter(event);"
                                    value="#{datosUsuarioCitologiaBean.lstVulnerabilidadSelect}">
                                      <a4j:support id="idVulnera"                         
                                        event="onchange"  >
                                <a4j:ajaxListener type="org.ajax4jsf.ajax.ForceRender"/>
                                </a4j:support>
                            <f:selectItems value="#{datosUsuarioCitologiaBean.listVulnerabilidad}"/>
                            </h:selectManyCheckbox>
                            <a4j:outputPanel ajaxRendered="true">
                                <t:message for="idVulnerabilidad" styleClass="errorMessage"/>
                            </a4j:outputPanel>
                            </h:panelGroup>
                        </a4j:region>
          </h:panelGrid>
          <h:outputText value=""/>
        </s:fieldset>
         <s:fieldset legend="Consentimiento Informado" id="fieldConsentimiento" styleClass="fieldset" rendered="#{datosUsuarioCitologiaBean.renderConsentimiento}">
       <h:panelGrid columns="1" border="0" cellpadding="0" cellspacing="0" width="100%" 
                 id="panelDatosConsentimiento" rowClasses="labelText,labelTextInfo">
      <h:outputText value="¿Se diligencia consentimiento informado ?" styleClass="labelTextOblig"/>
      <a4j:region renderRegionOnly="false">
        <h:selectOneRadio id="mnuConsentimiento" onkeydown="return blockEnter(event);" required="true" immediate="true"
                          value="#{datosUsuarioCitologiaBean.usuario.hcocreaconinf}"
                          valueChangeListener="#{datosUsuarioCitologiaBean.setHcocreaconinf}">
          <f:selectItems value="#{datosUsuarioCitologiaBean.lstOpciones}"/>
          <a4j:support id="supportmnuConsentimiento" immediate="true"
                       action="#{datosUsuarioCitologiaBean.changeConsentimiento}"
                       reRender="panelTextAutoUsoDatos,panelInputAutoUsoDatos,panelLupaConsentimientos"
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
            <h:outputText value="¿Cuál consentimiento se diligencia?" styleClass="labelTextOblig" rendered="#{datosUsuarioCitologiaBean.renderRealizaConsentimiento}"/>
            <h:outputText/>
            <a4j:region renderRegionOnly="false">
            <h:panelGrid columns="2" border="0" cellpadding="0" cellspacing="0" width="100%" id="panelBotonConsulta">
             <a4j:commandLink value="Agregar" immediate="true" title="Seleccionar Concentimiento"
                               rendered="#{datosUsuarioCitologiaBean.renderRealizaConsentimiento}"
                               action="#{datosUsuarioCitologiaBean.consultarConsentimientos}"
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
                       id="panelTablaConsentimientos" styleClass="tabContainer" rendered="#{not empty datosUsuarioCitologiaBean.lstConsentimientoAceptados && datosUsuarioCitologiaBean.renderRealizaConsentimiento}">
            <t:buffer into="#{table}">
              <h:dataTable var="item" border="1" cellpadding="0" cellspacing="0"
                           binding="#{datosUsuarioCitologiaBean.dtConsentimiento}"
                           value="#{datosUsuarioCitologiaBean.lstConsentimientoAceptados}" rows="10" styleClass="standard_table"
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
                                 action="#{datosUsuarioCitologiaBean.eliminarConsentimiento}">
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
                        rendered="#{datosUsuarioCitologiaBean.renderRealizaConsentimiento}" styleClass="labelTextOblig"/>
      </h:panelGroup>
      <h:panelGroup id="panelInputAutoUsoDatos">
        <h:selectOneRadio id="mnuAutoUsoDato" onkeydown="return blockEnter(event);" 
                          required="true" immediate="true" rendered="#{datosUsuarioCitologiaBean.renderRealizaConsentimiento}"
                          value="#{datosUsuarioCitologiaBean.usuario.hcocautusodat}">
          <f:selectItems value="#{datosUsuarioCitologiaBean.lstOpciones}"/>
        </h:selectOneRadio>
        <a4j:outputPanel ajaxRendered="true" rendered="#{datosUsuarioCitologiaBean.renderRealizaConsentimiento}">
          <t:message for="mnuAutoUsoDato" styleClass="errorMessage"/>
        </a4j:outputPanel>
      </h:panelGroup>
    </h:panelGrid>
      
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
     <t:panelTab id="panelTabBuscadorConsentimiento" label="Buscar Consentimiento"
                rendered="#{datosUsuarioCitologiaBean.mostrarConsentimiento}">
                         <a4j:region renderRegionOnly="false">
      <s:fieldset legend="Consentimientos" id="fieldSetConsentimiento" styleClass="fieldset">
          <jsp:include page="/pages/clinico/registro/buscadorConsentimiento.jsp" flush="true"/>
          <h:panelGrid id="panelGridConsentimiento0Botones" width="100%" columnClasses="columnaBotonesCentrados" dir="RTL">
            <t:htmlTag value="br"/>
            <h:panelGroup id="panelGroupConsentimientoBotones1">
     
              <a4j:commandButton value="Aceptar" styleClass="btn btn btn-success"
                                 action="#{datosUsuarioCitologiaBean.aceptarConsentimientos}"
                                 reRender="panelGridDatosUsuarioTab">
                <a4j:ajaxListener type="org.ajax4jsf.ajax.ForceRender"/>
              </a4j:commandButton>
            </h:panelGroup>
          </h:panelGrid>
        </s:fieldset>
          </a4j:region>
         </t:panelTab>
  </t:panelTabbedPane>
  <script language="javascript" type="text/javascript">
        document.forms[1].elements[6].focus()
</script>
</h:panelGrid>
</a4j:region>
</a4j:form>