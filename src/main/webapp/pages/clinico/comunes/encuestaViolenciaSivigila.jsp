<%@ page contentType="text/html;charset=iso-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsf/html" prefix="h"%>
<%@ taglib uri="http://java.sun.com/jsf/core" prefix="f"%>
<%@ taglib uri="http://richfaces.org/a4j" prefix="a4j"%>
<%@ taglib uri="http://myfaces.apache.org/tomahawk" prefix="t"%>
<%@ taglib uri="http://myfaces.apache.org/sandbox" prefix="s"%>
<%@ page import="org.profamilia.hc.view.servlet.PdfServlet"%>
<h:panelGrid columns="1" border="0" cellpadding="0" cellspacing="0" width="100%" id="panelGridEncuestaViolenciaTab"
             styleClass="tabContainer">
  <jsp:include page="/pages/clinico/comunes/encabezadoDatosUsuario.jsp" flush="true"/>
  <t:panelTabbedPane border="0" cellpadding="0" cellspacing="0" serverSideTabSwitch="false" activePanelTabVar="true"
                     width="100%" id="panelTabbedPaneEncuestaViolencia" styleClass="tabbedPane"
                     activeTabStyleClass="activeTab" inactiveTabStyleClass="inactiveTab"
                     disabledTabStyleClass="disabledTab" activeSubStyleClass="activeSub"
                     inactiveSubStyleClass="inactiveSub" tabContentStyleClass="tabContent">
    <t:panelTab id="panelTabEncuestaViolencia" label="Encuesta Violencia">
      <h:panelGrid columns="1" border="0" cellpadding="0" cellspacing="0" width="100%"
                   id="tableContentTabsEncuestaViolencia" styleClass="tabContainer">
        <s:fieldset legend="MODALIDAD DE LA VIOLENCIA" id="fieldEnc" styleClass="fieldset">
          <h:panelGrid columns="2" border="0" cellpadding="0" cellspacing="0" width="100%" id="panelEncustaViolencia"
                       rowClasses="labelText,labelTextInfo">
            <h:outputText value="Modalidad de la Violencia " styleClass="labelTextOblig"/>
            <h:outputText/>
            <h:selectManyCheckbox required="true" style="border-style:none;height:300px;" immediate="true"
                                  id="mnuModalidadViolencia" value="#{encuestaViolenciaSivigilaBean.lstModalidadSelect}"
                                  layout="pageDirection">
              <f:selectItems value="#{encuestaViolenciaSivigilaBean.lstModalidadViolencia}"/>
            </h:selectManyCheckbox>
            <a4j:outputPanel ajaxRendered="true">
              <t:message for="mnuModalidadViolencia" styleClass="errorMessage"/>
            </a4j:outputPanel>
          </h:panelGrid>
        </s:fieldset>
        <s:fieldset legend="DATOS DE LA VICTIMA" id="fieldDatosVictima" styleClass="fieldset">
          <h:panelGrid columns="8" border="0" cellpadding="0" cellspacing="0" width="100%" id="panelDatosVictima"
                       rowClasses="labelText,labelTextInfo">
            <h:outputText value="Situaci�n o condici�n de vulnerabilidad " styleClass="labelTextOblig"/>
            <h:outputText/>
            <h:outputText/>
            <h:outputText/>
            <h:outputText/>
            <h:outputText/>
            <h:outputText/>
            <h:outputText/>
            <h:selectOneMenu id="menuSituacionVulnerabilidad" onkeydown="return blockEnter(event);" required="false"
                             value="#{encuestaViolenciaSivigilaBean.violencia.hvscdatvicacti}">
              <f:selectItems value="#{encuestaViolenciaSivigilaBean.lstActividadVicitima}"/>
            </h:selectOneMenu>
            <a4j:outputPanel ajaxRendered="true">
              <t:message for="menuSituacionVulnerabilidad" styleClass="errorMessage"/>
            </a4j:outputPanel>
            <h:outputText/>
            <h:outputText/>
            <h:outputText/>
            <h:outputText/>
            <h:outputText/>
            <h:outputText/>
            <h:outputText value="Poblaci�n LGTB " styleClass="labelTextOblig"/>
            <h:outputText/>
            <h:outputText value="Consumo de SPA " styleClass="labelTextOblig"/>
            <h:outputText/>
            <h:outputText value="Trabajo sex " styleClass="labelTextOblig"/>
            <h:outputText/>
            <h:outputText value="Desmovilizado " styleClass="labelTextOblig"/>
            <h:outputText/>
            <h:selectOneRadio id="menuPoblacionLGTB" onkeydown="return blockEnter(event);" required="false"
                              value="#{encuestaViolenciaSivigilaBean.violencia.hvscpoblaclgtb}">
              <f:selectItems value="#{encuestaViolenciaSivigilaBean.lstOpciones}"/>
            </h:selectOneRadio>
            <a4j:outputPanel ajaxRendered="true">
              <t:message for="menuPoblacionLGTB" styleClass="errorMessage"/>
            </a4j:outputPanel>
            <h:selectOneRadio id="menuConsumoSPA" onkeydown="return blockEnter(event);" required="false"
                              value="#{encuestaViolenciaSivigilaBean.violencia.hvscconsumespa}">
              <f:selectItems value="#{encuestaViolenciaSivigilaBean.lstOpciones}"/>
            </h:selectOneRadio>
            <a4j:outputPanel ajaxRendered="true">
              <t:message for="menuConsumoSPA" styleClass="errorMessage"/>
            </a4j:outputPanel>
            <h:selectOneRadio id="menuTrabajoSex" onkeydown="return blockEnter(event);" required="false"
                              value="#{encuestaViolenciaSivigilaBean.violencia.hvsctrabajosex}">
              <f:selectItems value="#{encuestaViolenciaSivigilaBean.lstOpciones}"/>
            </h:selectOneRadio>
            <a4j:outputPanel ajaxRendered="true">
              <t:message for="menuTrabajoSex" styleClass="errorMessage"/>
            </a4j:outputPanel>
            <h:selectOneRadio id="menuDesmovilizado" onkeydown="return blockEnter(event);" required="false"
                              value="#{encuestaViolenciaSivigilaBean.violencia.hvscdesmoviliz}">
              <f:selectItems value="#{encuestaViolenciaSivigilaBean.lstOpciones}"/>
            </h:selectOneRadio>
            <a4j:outputPanel ajaxRendered="true">
              <t:message for="menuDesmovilizado" styleClass="errorMessage"/>
            </a4j:outputPanel>
            <h:outputText value="Campesino (a) " styleClass="labelTextOblig"/>
            <h:outputText/>
            <h:outputText value="Mujer cabeza de familia " styleClass="labelTextOblig"/>
            <h:outputText/>
            <h:outputText value="Ama de casa " styleClass="labelTextOblig"/>
            <h:outputText/>
            <h:outputText value="NNA SNBF" styleClass="labelTextOblig"/>
            <h:outputText/>
            <h:selectOneRadio id="menuCampesino" onkeydown="return blockEnter(event);" required="false"
                              value="#{encuestaViolenciaSivigilaBean.violencia.hvsccampesino}">
              <f:selectItems value="#{encuestaViolenciaSivigilaBean.lstOpciones}"/>
            </h:selectOneRadio>
            <a4j:outputPanel ajaxRendered="true">
              <t:message for="menuCampesino" styleClass="errorMessage"/>
            </a4j:outputPanel>
            <h:selectOneRadio id="menuMujerCabeza" onkeydown="return blockEnter(event);" required="false"
                              value="#{encuestaViolenciaSivigilaBean.violencia.hvscmujercabfa}">
              <f:selectItems value="#{encuestaViolenciaSivigilaBean.lstOpciones}"/>
            </h:selectOneRadio>
            <a4j:outputPanel ajaxRendered="true">
              <t:message for="menuMujerCabeza" styleClass="errorMessage"/>
            </a4j:outputPanel>
            <h:selectOneRadio id="menuAmaCasa" onkeydown="return blockEnter(event);" required="false"
                              value="#{encuestaViolenciaSivigilaBean.violencia.hvscamadecasa}">
              <f:selectItems value="#{encuestaViolenciaSivigilaBean.lstOpciones}"/>
            </h:selectOneRadio>
            <a4j:outputPanel ajaxRendered="true">
              <t:message for="menuAmaCasa" styleClass="errorMessage"/>
            </a4j:outputPanel>
            <h:selectOneRadio id="menuNna" onkeydown="return blockEnter(event);" required="false"
                              value="#{encuestaViolenciaSivigilaBean.violencia.hvscnnasnbf}">
              <f:selectItems value="#{encuestaViolenciaSivigilaBean.lstOpciones}"/>
            </h:selectOneRadio>
            <a4j:outputPanel ajaxRendered="true">
              <t:message for="menuNna" styleClass="errorMessage"/>
            </a4j:outputPanel>
            <h:outputText value="Privad. libertad" styleClass="labelTextOblig"/>
            <h:outputText/>
            <h:outputText value="Victima del conflicto armado " styleClass="labelTextOblig"/>
            <h:outputText/>
            <h:outputText value="Reincidencia " styleClass="labelTextOblig"/>
            <h:outputText/>
            <h:outputText value="Alcohol v�ctima" styleClass="labelTextOblig"/>
            <h:outputText/>
            <h:selectOneRadio id="menuPrivaLiber" onkeydown="return blockEnter(event);" required="false"
                              value="#{encuestaViolenciaSivigilaBean.violencia.hvscprivaliber}">
              <f:selectItems value="#{encuestaViolenciaSivigilaBean.lstOpciones}"/>
            </h:selectOneRadio>
            <a4j:outputPanel ajaxRendered="true">
              <t:message for="menuPrivaLiber" styleClass="errorMessage"/>
            </a4j:outputPanel>
            <h:selectOneRadio id="menuVictimaConflicto" onkeydown="return blockEnter(event);" required="false"
                              value="#{encuestaViolenciaSivigilaBean.violencia.hvscvicconarma}">
              <f:selectItems value="#{encuestaViolenciaSivigilaBean.lstOpciones}"/>
            </h:selectOneRadio>
            <a4j:outputPanel ajaxRendered="true">
              <t:message for="menuVictimaConflicto" styleClass="errorMessage"/>
            </a4j:outputPanel>
            <h:selectOneRadio id="menuReincidencia" onkeydown="return blockEnter(event);" required="false"
                              value="#{encuestaViolenciaSivigilaBean.violencia.hvscreincidenc}">
              <f:selectItems value="#{encuestaViolenciaSivigilaBean.lstOpciones}"/>
            </h:selectOneRadio>
            <a4j:outputPanel ajaxRendered="true">
              <t:message for="menuReincidencia" styleClass="errorMessage"/>
            </a4j:outputPanel>
            <h:selectOneRadio id="menuAlcohol" onkeydown="return blockEnter(event);" required="false"
                              value="#{encuestaViolenciaSivigilaBean.violencia.hvscalcoholvic}">
              <f:selectItems value="#{encuestaViolenciaSivigilaBean.lstOpciones}"/>
            </h:selectOneRadio>
            <a4j:outputPanel ajaxRendered="true">
              <t:message for="menuAlcohol" styleClass="errorMessage"/>
            </a4j:outputPanel>
            <h:outputText value="Otro" styleClass="labelTextOblig"/>
            <h:outputText/>
            <h:outputText/>
            <h:outputText/>
            <h:outputText/>
            <h:outputText/>
            <h:outputText/>
            <h:outputText/>
            <h:selectOneRadio id="menuOtro" onkeydown="return blockEnter(event);" required="false"
                              value="#{encuestaViolenciaSivigilaBean.violencia.hvscotro}">
              <f:selectItems value="#{encuestaViolenciaSivigilaBean.lstOpciones}"/>
            </h:selectOneRadio>
            <a4j:outputPanel ajaxRendered="true">
              <t:message for="menuOtro" styleClass="errorMessage"/>
            </a4j:outputPanel>
            <h:outputText/>
            <h:outputText/>
            <h:outputText/>
            <h:outputText/>
            <h:outputText/>
            <h:outputText/>
          </h:panelGrid>
        </s:fieldset>
        <s:fieldset legend="DATOS DEL AGRESOR" id="fieldDatosAgresor" styleClass="fieldset">
          <h:panelGrid columns="6" border="0" cellpadding="0" cellspacing="0" width="100%" id="panelDatosAgresor"
                       rowClasses="labelText,labelTextInfo">
            <h:outputText value="Edad Agresor " styleClass="labelTextOblig"/>
            <h:outputText/>
            <h:outputText value="Sexo Agresor " styleClass="labelTextOblig"/>
            <h:outputText/>
            <h:outputText value="Parentesco con v�ctima " styleClass="labelTextOblig"/>
            <h:outputText/>
            <h:inputText id="itEdadAgresor" value="#{encuestaViolenciaSivigilaBean.violencia.hvsnedadagre}"
                         required="true" style="width:50px"/>
            <a4j:outputPanel ajaxRendered="true">
              <t:message for="itEdadAgresor" styleClass="errorMessage"/>
            </a4j:outputPanel>
            <h:selectOneRadio id="menuSexoAgresor" onkeydown="return blockEnter(event);" required="false"
                              style="width:50px" value="#{encuestaViolenciaSivigilaBean.violencia.hvscsexoagre}">
              <f:selectItems value="#{encuestaViolenciaSivigilaBean.lstSexo}"/>
            </h:selectOneRadio>
            <a4j:outputPanel ajaxRendered="true">
              <t:message for="menuSexoAgresor" styleClass="errorMessage"/>
            </a4j:outputPanel>
            <h:selectOneMenu required="true" immediate="true" id="mnuParentesco"
                             value="#{encuestaViolenciaSivigilaBean.violencia.hvscparentvict}">
              <f:selectItems value="#{encuestaViolenciaSivigilaBean.lstParentesco}"/>
            </h:selectOneMenu>
            <a4j:outputPanel ajaxRendered="true">
              <t:message for="mnuParentesco" styleClass="errorMessage"/>
            </a4j:outputPanel>
            <h:outputText value="Convive con el agresor (a) " styleClass="labelTextOblig"/>
            <h:outputText/>
            <h:outputText value="Agresor no familiar " styleClass="labelTextOblig"/>
            <h:outputText/>
            <h:outputText value="Grupo perpetuador de la violencia " styleClass="labelTextOblig"/>
            <h:outputText/>
            <h:selectOneRadio id="menuConvive" onkeydown="return blockEnter(event);" required="false"
                              value="#{encuestaViolenciaSivigilaBean.violencia.hvscconvcagres}">
              <f:selectItems value="#{encuestaViolenciaSivigilaBean.lstOpciones}"/>
            </h:selectOneRadio>
            <a4j:outputPanel ajaxRendered="true">
              <t:message for="menuConvive" styleClass="errorMessage"/>
            </a4j:outputPanel>
            <h:selectOneMenu id="menuAgresorNoFamiliar" onkeydown="return blockEnter(event);" required="false"
                             value="#{encuestaViolenciaSivigilaBean.violencia.hvscagrenofami}">
              <f:selectItems value="#{encuestaViolenciaSivigilaBean.lstNoFamiliar}"/>
            </h:selectOneMenu>
            <a4j:outputPanel ajaxRendered="true">
              <t:message for="menuAgresorNoFamiliar" styleClass="errorMessage"/>
            </a4j:outputPanel>
            <h:selectOneMenu id="menuGrupoPerpetuador" onkeydown="return blockEnter(event);" required="false"
                             value="#{encuestaViolenciaSivigilaBean.violencia.hvscgruperviol}">
              <f:selectItems value="#{encuestaViolenciaSivigilaBean.lstGrupoPerpetuador}"/>
            </h:selectOneMenu>
            <a4j:outputPanel ajaxRendered="true">
              <t:message for="menuGrupoPerpetuador" styleClass="errorMessage"/>
            </a4j:outputPanel>
          </h:panelGrid>
        </s:fieldset>
        <s:fieldset legend="DATOS DEL HECHO" id="fieldDatosDelHecho" styleClass="fieldset">
          <h:panelGrid columns="6" border="0" cellpadding="0" cellspacing="0" width="100%" id="panelDatosDelHecho"
                       rowClasses="labelText,labelTextInfo">
            <h:outputText value="Mecanismo utlizado para la agresi�n " styleClass="labelTextOblig"/>
            <h:outputText/>
            <h:outputText/>
            <h:outputText/>
            <h:outputText/>
            <h:outputText/>
            <h:selectOneMenu id="menuMecanismo" onkeydown="return blockEnter(event);" required="false"
                             value="#{encuestaViolenciaSivigilaBean.violencia.hvscmecanutili}">
              <f:selectItems value="#{encuestaViolenciaSivigilaBean.lstMecanismo}"/>
            </h:selectOneMenu>
            <a4j:outputPanel ajaxRendered="true">
              <t:message for="menuMecanismo" styleClass="errorMessage"/>
            </a4j:outputPanel>
            <h:outputText/>
            <h:outputText/>
            <h:outputText/>
            <h:outputText/>
            <h:outputText value="Sitio an�tomico comprometido con la quemadura " styleClass="labelTextOblig"/>
            <h:outputText/>
            <h:outputText value="Grado " styleClass="labelTextOblig"/>
            <h:outputText/>
            <h:outputText value="Extensi�n " styleClass="labelTextOblig"/>
            <h:outputText/>
            <h:selectManyCheckbox required="true" style="border-style:none;height:300px;" immediate="true" id="mnuSitio"
                                  value="#{encuestaViolenciaSivigilaBean.lstSitioSelect}" layout="pageDirection">
              <f:selectItems value="#{encuestaViolenciaSivigilaBean.lstSitioQuemadura}"/>
            </h:selectManyCheckbox>
            <a4j:outputPanel ajaxRendered="true">
              <t:message for="menuMecanismo" styleClass="errorMessage"/>
            </a4j:outputPanel>
            <h:selectOneRadio id="menuGrado" onkeydown="return blockEnter(event);" required="false"
                              value="#{encuestaViolenciaSivigilaBean.violencia.hvsngrado}">
              <f:selectItems value="#{encuestaViolenciaSivigilaBean.lstGradoQuemadura}"/>
            </h:selectOneRadio>
            <a4j:outputPanel ajaxRendered="true">
              <t:message for="menuGrado" styleClass="errorMessage"/>
            </a4j:outputPanel>
            <h:selectOneRadio id="menuExtension" onkeydown="return blockEnter(event);" required="false"
                              value="#{encuestaViolenciaSivigilaBean.violencia.hvsnextension}">
              <f:selectItems value="#{encuestaViolenciaSivigilaBean.lstExtension}"/>
            </h:selectOneRadio>
            <a4j:outputPanel ajaxRendered="true">
              <t:message for="menuExtension" styleClass="errorMessage"/>
            </a4j:outputPanel>
            <h:outputText value="Fecha del hecho " styleClass="labelTextOblig"/>
            <h:outputText/>
            <h:outputText value="Hora del hecho " styleClass="labelTextOblig"/>
            <h:outputText/>
            <h:outputText value="Escenario " styleClass="labelTextOblig"/>
            <h:outputText/>
            <t:inputCalendar id="calendarHecho" monthYearRowClass="yearMonthHeader" weekRowClass="weekHeader"
                             title="Formato: dd/mm/yyyy" currentDayCellClass="currentDayCell"
                             popupDateFormat="dd/MM/yyyy" renderAsPopup="true" disabled="false"
                             value="#{encuestaViolenciaSivigilaBean.violencia.hvsdfechaecho}" popupTodayString="Hoy"
                             popupWeekString="Semana" popupButtonString="Fecha" readonly="false" maxlength="11"
                             size="11" popupButtonImageUrl="/comun/imagenes/ico_calendario2.gif"
                             renderPopupButtonAsImage="true" align="top">
              <f:validator validatorId="dateMenorActualValidator"/>
            </t:inputCalendar>
            <a4j:outputPanel ajaxRendered="true">
              <t:message for="calendarHecho" styleClass="errorMessage"/>
            </a4j:outputPanel>
            <h:panelGroup>
              <h:panelGroup>
                <h:selectOneMenu id="mnuHoraCirugia1" value="#{encuestaViolenciaSivigilaBean.violencia.hvschoraecho}"
                                 styleClass="input-small">
                  <f:selectItems value="#{encuestaViolenciaSivigilaBean.listHora}"/>
                </h:selectOneMenu>
                <a4j:outputPanel ajaxRendered="true">
                  <t:message for="mnuHoraCirugia1" styleClass="errorMessage"/>
                </a4j:outputPanel>
              </h:panelGroup>
              <h:outputText value=" : Horas "/>
              <h:panelGroup>
                <h:selectOneMenu id="mnuMinutos1" value="#{encuestaViolenciaSivigilaBean.violencia.hvscminuecho}" required="true"
                                 styleClass="dropdown-toggle, input-small">
                  <f:selectItems value="#{encuestaViolenciaSivigilaBean.lstMinutos}"/>
                </h:selectOneMenu>
                <a4j:outputPanel ajaxRendered="true">
                  <t:message for="mnuMinutos1" styleClass="errorMessage"/>
                </a4j:outputPanel>
              </h:panelGroup>
              <h:outputText value=" Minutos"/>
            </h:panelGroup>
            <h:outputText/>
            <h:selectOneMenu id="menuEscenario" onkeydown="return blockEnter(event);" required="true"
                             value="#{encuestaViolenciaSivigilaBean.violencia.hvscescenario}">
              <f:selectItems value="#{encuestaViolenciaSivigilaBean.lstEscenario}"/>
            </h:selectOneMenu>
            <a4j:outputPanel ajaxRendered="true">
              <t:message for="menuEscenario" styleClass="errorMessage"/>
            </a4j:outputPanel>
            <h:outputText value="�Hecho violento en el marco del conflicto armado? " styleClass="labelTextOblig"/>
            <h:outputText/>
            <h:outputText/>
            <h:outputText/>
            <h:outputText/>
            <h:outputText/>
            <h:selectOneRadio id="menuConflictoArmadoB" onkeydown="return blockEnter(event);" required="true"
                              value="#{encuestaViolenciaSivigilaBean.violencia.hvscmarcocoar}">
              <f:selectItems value="#{encuestaViolenciaSivigilaBean.lstOpciones}"/>
            </h:selectOneRadio>
            <a4j:outputPanel ajaxRendered="true">
              <t:message for="menuConflictoArmadoB" styleClass="errorMessage"/>
            </a4j:outputPanel>
          </h:panelGrid>
        </s:fieldset>
        <s:fieldset legend="ATENCI�N EN SALUD" id="fieldDatosAtencionSalud" styleClass="fieldset">
          <h:panelGrid columns="6" border="0" cellpadding="0" cellspacing="0" width="100%" id="panelAtencionSalud"
                       rowClasses="labelText,labelTextInfo">
            <h:outputText value="Profilaxis VIH " styleClass="labelTextOblig"/>
            <h:outputText/>
            <h:outputText value="Profilaxis Hep B. " styleClass="labelTextOblig"/>
            <h:outputText/>
            <h:outputText value="Otras profilaxis" styleClass="labelTextOblig"/>
            <h:outputText/>
            <h:selectOneRadio id="menuProfiVIH" onkeydown="return blockEnter(event);" required="false"
                              value="#{encuestaViolenciaSivigilaBean.violencia.hvscprofilavih}">
              <f:selectItems value="#{encuestaViolenciaSivigilaBean.lstOpciones}"/>
            </h:selectOneRadio>
            <a4j:outputPanel ajaxRendered="true">
              <t:message for="menuProfiVIH" styleClass="errorMessage"/>
            </a4j:outputPanel>
            <h:selectOneRadio id="menuProfiHepB" onkeydown="return blockEnter(event);" required="false"
                              value="#{encuestaViolenciaSivigilaBean.violencia.hvscprofilhepb}">
              <f:selectItems value="#{encuestaViolenciaSivigilaBean.lstOpciones}"/>
            </h:selectOneRadio>
            <a4j:outputPanel ajaxRendered="true">
              <t:message for="menuProfiHepB" styleClass="errorMessage"/>
            </a4j:outputPanel>
            <h:selectOneRadio id="menuOtrasProf" onkeydown="return blockEnter(event);" required="false"
                              value="#{encuestaViolenciaSivigilaBean.violencia.hvscotrasprofi}">
              <f:selectItems value="#{encuestaViolenciaSivigilaBean.lstOpciones}"/>
            </h:selectOneRadio>
            <a4j:outputPanel ajaxRendered="true">
              <t:message for="menuOtrasProf" styleClass="errorMessage"/>
            </a4j:outputPanel>
            <h:outputText value="Anticoncepci�n de emergencia" styleClass="labelTextOblig"/>
            <h:outputText/>
            <h:outputText value="Orientaci�n IVE. " styleClass="labelTextOblig"/>
            <h:outputText/>
            <h:outputText value="Salud Mental" styleClass="labelTextOblig"/>
            <h:outputText/>
            <h:selectOneRadio id="menuAnticoncepcion" onkeydown="return blockEnter(event);" required="false"
                              value="#{encuestaViolenciaSivigilaBean.violencia.hvscanticoemer}">
              <f:selectItems value="#{encuestaViolenciaSivigilaBean.lstOpciones}"/>
            </h:selectOneRadio>
            <a4j:outputPanel ajaxRendered="true">
              <t:message for="menuAnticoncepcion" styleClass="errorMessage"/>
            </a4j:outputPanel>
            <h:selectOneRadio id="menuOrientacion" onkeydown="return blockEnter(event);" required="false"
                              value="#{encuestaViolenciaSivigilaBean.violencia.hvscorientaive}">
              <f:selectItems value="#{encuestaViolenciaSivigilaBean.lstOpciones}"/>
            </h:selectOneRadio>
            <a4j:outputPanel ajaxRendered="true">
              <t:message for="menuOrientacion" styleClass="errorMessage"/>
            </a4j:outputPanel>
            <h:selectOneRadio id="menuSaludMental" onkeydown="return blockEnter(event);" required="false"
                              value="#{encuestaViolenciaSivigilaBean.violencia.hvscsaludmenta}">
              <f:selectItems value="#{encuestaViolenciaSivigilaBean.lstOpciones}"/>
            </h:selectOneRadio>
            <a4j:outputPanel ajaxRendered="true">
              <t:message for="menuSaludMental" styleClass="errorMessage"/>
            </a4j:outputPanel>
            <h:outputText value="Remisi�n a protecci�n" styleClass="labelTextOblig"/>
            <h:outputText/>
            <h:outputText value="Aviso/denuncia a polic�a judic�al(URI, CTI),fiscal�a,policia nacional "
                          styleClass="labelTextOblig"/>
            <h:outputText/>
            <h:outputText value="Recolecci�n de evidencia m�dico legal" styleClass="labelTextOblig"/>
            <h:outputText/>
            <h:selectOneRadio id="menuRemisionProteccion" onkeydown="return blockEnter(event);" required="false"
                              value="#{encuestaViolenciaSivigilaBean.violencia.hvscremaprotec}">
              <f:selectItems value="#{encuestaViolenciaSivigilaBean.lstOpciones}"/>
            </h:selectOneRadio>
            <a4j:outputPanel ajaxRendered="true">
              <t:message for="menuRemisionProteccion" styleClass="errorMessage"/>
            </a4j:outputPanel>
            <h:selectOneRadio id="menuAvisoPolicia" onkeydown="return blockEnter(event);" required="false"
                              value="#{encuestaViolenciaSivigilaBean.violencia.hvscdenuncia}">
              <f:selectItems value="#{encuestaViolenciaSivigilaBean.lstOpciones}"/>
            </h:selectOneRadio>
            <a4j:outputPanel ajaxRendered="true">
              <t:message for="menuAvisoPolicia" styleClass="errorMessage"/>
            </a4j:outputPanel>
            <h:selectOneRadio id="menuSaludMedioLegal" onkeydown="return blockEnter(event);" required="false"
                              value="#{encuestaViolenciaSivigilaBean.violencia.hvscrecoevimed}">
              <f:selectItems value="#{encuestaViolenciaSivigilaBean.lstOpciones}"/>
            </h:selectOneRadio>
            <a4j:outputPanel ajaxRendered="true">
              <t:message for="menuSaludMedioLegal" styleClass="errorMessage"/>
            </a4j:outputPanel>
          </h:panelGrid>
        </s:fieldset>
      </h:panelGrid>
    </t:panelTab>
           <h:panelGrid id="panelGridViolenciaSivigilaBotones" width="100%" columnClasses="columnaBotonesCentrados"
                         dir="RTL">
              <t:htmlTag value="br"/>
              <h:panelGroup id="panelGroupViolenciaSivigila1">
                <h:commandButton value="Guardar" styleClass="btn btn btn-success"
                                   action="#{encuestaViolenciaSivigilaBean.guardarViolencia}">
                </h:commandButton>
              </h:panelGroup>
              
              
                   <f:subview id="generarCitologia" rendered="#{encuestaViolenciaSivigilaBean.generoReporte}">
          <f:verbatim>
            <script type="text/javascript" language="JavaScript">
           window.open("<%=request.getSession().getAttribute(PdfServlet.DOCUMENT_NAME_ATTRIBUTE_NAME)%>", "Documento" , "width=800,height=600");
        </script>
          </f:verbatim>
        </f:subview>
            </h:panelGrid>
            
        
            
  </t:panelTabbedPane>
       <h:panelGroup>
          <a4j:outputPanel id="ajaxRegionMessagesatributo1" ajaxRendered="true">
            <t:htmlTag value="br"/>
            <t:messages id="msgInformationAndErrors" showSummary="false" errorClass="error" globalOnly="true" layout="table" infoClass="informacion" showDetail="true" tooltip="true"
                        warnClass="advertencia"/>
            <t:htmlTag value="br"/>
          </a4j:outputPanel>
          </h:panelGroup>
  
  <f:verbatim>
    <script language="javascript" type="text/javascript">
        document.forms[1].elements[6].focus()
    </script>
  </f:verbatim>
</h:panelGrid>