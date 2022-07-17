<%@ page contentType="text/html;charset=iso-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsf/html" prefix="h"%>
<%@ taglib uri="http://java.sun.com/jsf/core" prefix="f"%>
<%@ taglib uri="http://richfaces.org/a4j" prefix="a4j"%>
<%@ taglib uri="http://myfaces.apache.org/tomahawk" prefix="t"%>
<%@ taglib uri="http://myfaces.apache.org/sandbox" prefix="s"%>
<%@ page import="org.profamilia.hc.view.servlet.PdfServlet"%>
<h:panelGrid columns="1" border="0" cellpadding="0" cellspacing="0" width="100%" id="panelGridCuestTab"
             styleClass="tabContainer">
  <jsp:include page="/pages/clinico/comunes/encabezadoDatosUsuario.jsp" flush="true"/>
  <t:panelTabbedPane border="0" cellpadding="0" cellspacing="0" serverSideTabSwitch="false" activePanelTabVar="true"
                     width="100%" id="panelTabbedPaneEstFem" styleClass="tabbedPane" activeTabStyleClass="activeTab"
                     inactiveTabStyleClass="inactiveTab" disabledTabStyleClass="disabledTab"
                     activeSubStyleClass="activeSub" inactiveSubStyleClass="inactiveSub"
                     tabContentStyleClass="tabContent">
    <t:panelTab id="panelTabCuest" label="Cuestionario">
      <s:fieldset legend="Informaci�n relacionada con la vacuna contra el virus de papiloma humano - VPH "
                  id="fieldPreguntas" styleClass="fieldset">
        <a4j:region renderRegionOnly="false">
          <h:panelGrid columns="7">
            <h:outputText value="[ " style="font-size:8.0pt; font-weight:bold;"/>
            <a4j:commandLink style="font-size:8.0pt; font-weight:bold;" value=" Todos SI" immediate="true"
                             action="#{cuestionarioCervixUsuarioBean.changeTodosSi}" reRender="tableContentTabsCervix"/>
            <h:outputText value=" | " style="font-size:8.0pt; font-weight:bold;"/>
            <a4j:commandLink style="font-size:8.0pt; font-weight:bold;" value="Todos NO " immediate="true"
                             action="#{cuestionarioCervixUsuarioBean.changeTodosNo}" reRender="tableContentTabsCervix"/>
            <h:outputText value=" | " style="font-size:8.0pt; font-weight:bold;"/>
            <a4j:commandLink style="font-size:8.0pt; font-weight:bold;" value="Ninguno " immediate="true"
                             action="#{cuestionarioCervixUsuarioBean.changeNinguno}"
                             reRender=" tableContentTabsCervix"/>
            <h:outputText value=" ]" style="font-size:8.0pt; font-weight:bold;"/>
          </h:panelGrid>
        </a4j:region>
        <h:outputText value=" "/>
        <t:htmlTag value="br"/>
        <h:panelGrid columns="3" border="0" cellpadding="0" cellspacing="0" width="100%" id="tableContentTabsCervix"
                     rowClasses="labelCuestionario,labelCuestionario2">
          <t:div style="overflow:auto;width:550px;height:40px;" rendered="#{cuestionarioCervixUsuarioBean.renderFemenino}">
            <h:outputText style="font-size:8.0pt;" rendered="#{cuestionarioCervixUsuarioBean.renderFemenino}"
                          value=" �Recibi� usted informaci�n o asesor�a sobre el c�ncer de cuello uterino y sus formas de prevenci�n?"/>
          </t:div>
          <h:selectOneRadio id="mnuasesocancer" 
                            rendered="#{cuestionarioCervixUsuarioBean.renderFemenino}"
                            binding="#{cuestionarioCervixUsuarioBean.mnuasesocancer}"
                            value="#{cuestionarioCervixUsuarioBean.cuestionarioCervix.hcccasesocance}">
            <f:selectItems value="#{cuestionarioCervixUsuarioBean.lstOpciones}"/>
          </h:selectOneRadio>
          <h:outputText  rendered="#{cuestionarioCervixUsuarioBean.renderFemenino}"/>
          <t:div style="overflow:auto;width:550px;height:70px;" rendered="#{cuestionarioCervixUsuarioBean.renderFemenino}">
            <h:outputText style="font-size:8.0pt;"  rendered="#{cuestionarioCervixUsuarioBean.renderFemenino}"
                              value=" �Se le inform� que dentro de las recomendaciones para prevenir o diagnosticar oportunamente el c�ncer de c�rvix en la mujer est�n: asistir a consulta ginecol�gica; tomarse peri�dicamente una citolog�a vaginal y reclamar el resultado; usar de manera consistente el cond�n y aplicarse de forma adecuada un esquema de la vacuna contra VPH?"/>
          </t:div>
          <h:selectOneRadio id="mnurecompreve" immediate="true" 
                            rendered="#{cuestionarioCervixUsuarioBean.renderFemenino}"
                            binding="#{cuestionarioCervixUsuarioBean.mnurecompreve}"
                            value="#{cuestionarioCervixUsuarioBean.cuestionarioCervix.hcccrecompreve}">
            <f:selectItems value="#{cuestionarioCervixUsuarioBean.lstOpciones}"/>
          </h:selectOneRadio>
          <h:outputText  rendered="#{cuestionarioCervixUsuarioBean.renderFemenino}"/>
          <t:div style="overflow:auto;width:550px;height:50px;"  rendered="#{cuestionarioCervixUsuarioBean.renderFemenino}">
            <h:outputText style="font-size:8.0pt;"  rendered="#{cuestionarioCervixUsuarioBean.renderFemenino}"
                          value=" �Se le inform� que la vacuna contra el VPH complementa y hace parte del programa de prevenci�n del c�ncer de c�rvix, pero no reemplaza las otras recomendaciones para la protecci�n o diagn�stico oportuno?"/>
          </t:div>
          <h:selectOneRadio id="mnuvphcomppre"  rendered="#{cuestionarioCervixUsuarioBean.renderFemenino}"
                            binding="#{cuestionarioCervixUsuarioBean.mnuvphcomppre}"
                            value="#{cuestionarioCervixUsuarioBean.cuestionarioCervix.hcccvphcomppre}">
            <f:selectItems value="#{cuestionarioCervixUsuarioBean.lstOpciones}"/>
          </h:selectOneRadio>
          <h:outputText  rendered="#{cuestionarioCervixUsuarioBean.renderFemenino}"/>
          <t:div style="overflow:auto;width:550px;height:50px;"  rendered="#{cuestionarioCervixUsuarioBean.renderFemenino}">
            <h:outputText style="font-size:8.0pt;"  rendered="#{cuestionarioCervixUsuarioBean.renderFemenino}"
                          value=" �Sabe usted que en las mujeres estar vacunada no significa que no vaya a desarrollar c�ncer de cuello uterino por otros tipos de virus y que es improbable que la vacuna la beneficie si ya ha  estado expuesta a un tipo de virus que previene la vacuna?"/>
          </t:div>
          <h:selectOneRadio id="mnuotrostipos" immediate="true"
                            rendered="#{cuestionarioCervixUsuarioBean.renderFemenino}"
                            binding="#{cuestionarioCervixUsuarioBean.mnuotrostipos}"
                            value="#{cuestionarioCervixUsuarioBean.cuestionarioCervix.hcccotrostipos}">
            <f:selectItems value="#{cuestionarioCervixUsuarioBean.lstOpciones}"/>
          </h:selectOneRadio>
          <h:outputText  rendered="#{cuestionarioCervixUsuarioBean.renderFemenino}"/>
          <t:div style="overflow:auto;width:550px;height:50px;">
            <h:outputText style="font-size:8.0pt;"
                          value=" �Se le inform� que existen m�s de cien tipos del virus del papiloma humano (VPH), que es  transmitido sexualmente y es reconocido como causa del 99% del c�ncer cervical y puede tardar a�os en manifestarse a trav�s de una lesi�n? "/>
          </t:div>
          <h:selectOneRadio id="mnucienvirus" immediate="true" 
                            binding="#{cuestionarioCervixUsuarioBean.mnucienvirus}"
                            value="#{cuestionarioCervixUsuarioBean.cuestionarioCervix.hccccienvirus}">
            <f:selectItems value="#{cuestionarioCervixUsuarioBean.lstOpciones}"/>
          </h:selectOneRadio>
         
          <h:outputText/>
          <t:div style="overflow:auto;width:550px;height:40px;">
            <h:outputText style="font-size:8.0pt;"
                          value=" �Sabe usted que el virus VPH tipos 16, 18, 31 y 45 son los causantes del 80% del c�ncer de cuello uterino?"/>
          </t:div>
          <h:selectOneRadio id="mnuvphcausant" immediate="true" 
                            binding="#{cuestionarioCervixUsuarioBean.mnuvphcausant}"
                            value="#{cuestionarioCervixUsuarioBean.cuestionarioCervix.hcccvphcausant}">
            <f:selectItems value="#{cuestionarioCervixUsuarioBean.lstOpciones}"/>
          </h:selectOneRadio>
          
          
          <h:outputText/>
          <t:div style="overflow:auto;width:550px;height:70px;">
            <h:outputText style="font-size:8.0pt;"
                          value=" �Sabe usted que existe en Colombia dos tipos de vacunas  contra el VPH que no son terap�uticas ni infecciosas y que disponibles en Profamilia?, la bivalente previene directamente contra la infecci�n del VPH tipo 16,18 y de forma cruzada contra el VPH tipo 31,45 y comercialmente es el CERVARIX. La otra es tetravalente previene directamente contra la infecci�n del VPH tipo 6,11,16,18 y se conoce comercialmente con el nombre de GARDASIL"/>
          </t:div>
          <h:selectOneRadio id="mnudosvacucol" immediate="true"
                            binding="#{cuestionarioCervixUsuarioBean.mnudosvacucol}"
                            value="#{cuestionarioCervixUsuarioBean.cuestionarioCervix.hcccdosvacucol}">
            <f:selectItems value="#{cuestionarioCervixUsuarioBean.lstOpciones}"/>
          </h:selectOneRadio>
          
          
        <h:outputText/>
          <t:div style="overflow:auto;width:550px;height:40px;">
            <h:outputText style="font-size:8.0pt;"
                          value="Se le inform� que GARDASIL est� indicada en ni�os y j�venes de 9 a 17 a�os para la prevenci�n de lesiones en genitales externos e infecci�n causada por VPH tipos 6,11,16,18? "/>
          </t:div>
          <h:selectOneRadio id="mnuGardasil" immediate="true"
                            binding="#{cuestionarioCervixUsuarioBean.mnugardasil}"
                            value="#{cuestionarioCervixUsuarioBean.cuestionarioCervix.hcccinforgarda}">
            <f:selectItems value="#{cuestionarioCervixUsuarioBean.lstOpciones}"/>
          </h:selectOneRadio>
          <h:outputText/>
          <t:div style="overflow:auto;width:550px;height:40px;">
            <h:outputText style="font-size:8.0pt;"
                          value=" �Se le inform� que para que la vacuna alcance una eficacia m�nima del 95% se debe aplicar tres dosis de acuerdo con un esquema y no haber estado en contacto con el VPH? "/>
          </t:div>
          <h:selectOneRadio id="mnutresdosis" immediate="true" 
                            binding="#{cuestionarioCervixUsuarioBean.mnutresdosis}"
                            value="#{cuestionarioCervixUsuarioBean.cuestionarioCervix.hccctresdosis}">
            <f:selectItems value="#{cuestionarioCervixUsuarioBean.lstOpciones}"/>
          </h:selectOneRadio>
          <h:outputText/>
          
          <t:div style="overflow:auto;width:550px;height:40px;">
            <h:outputText style="font-size:8.0pt;"
                          value=" �Recibi� usted informaci�n sobre todos los beneficios, eficacia y efectos colaterales de cada vacuna? "/>
          </t:div>
          <h:selectOneRadio id="mnuinfocerva" immediate="true" 
                            binding="#{cuestionarioCervixUsuarioBean.mnuinfocerva}"
                            value="#{cuestionarioCervixUsuarioBean.cuestionarioCervix.hcccinfocerva}">
            <f:selectItems value="#{cuestionarioCervixUsuarioBean.lstOpciones}"/>
          </h:selectOneRadio>
          <h:outputText/>
          <t:div style="overflow:auto;width:550px;height:20px;"  rendered="#{cuestionarioCervixUsuarioBean.renderFemenino}">
            <h:outputText style="font-size:8.0pt;"  rendered="#{cuestionarioCervixUsuarioBean.renderFemenino}" value=" �Ha tenido resultados anormales de la citolog�a?  "/>
          </t:div>
          <h:selectOneRadio id="mnuanormcitol" immediate="true" 
           rendered="#{cuestionarioCervixUsuarioBean.renderFemenino}"
                            binding="#{cuestionarioCervixUsuarioBean.mnuanormcitol}"
                            value="#{cuestionarioCervixUsuarioBean.cuestionarioCervix.hcccanormcitol}"
                            valueChangeListener="#{cuestionarioCervixUsuarioBean.setHcccanormcitol}">
            <f:selectItems value="#{cuestionarioCervixUsuarioBean.lstOpciones}"/>
            <a4j:support id="supportmnuanormcitol" event="onclick" immediate="true"
                         action="#{cuestionarioCervixUsuarioBean.changeCitologia}" reRender="panelCual">
              <a4j:ajaxListener type="org.ajax4jsf.ajax.ForceRender"/>
            </a4j:support>
          </h:selectOneRadio>
          <h:panelGrid id="panelCual" columns="1" border="0" cellpadding="0" cellspacing="0"
           rendered="#{cuestionarioCervixUsuarioBean.renderFemenino}"
                       rowClasses="labelText,labelTextInfo">
            <h:outputText id="otCualResultado" value="Cual?" 
                          rendered="#{cuestionarioCervixUsuarioBean.renderCualResul}"/>
            <h:inputTextarea id="itCualResultado" 
                             rendered="#{cuestionarioCervixUsuarioBean.renderCualResul}"
                             value="#{cuestionarioCervixUsuarioBean.cuestionarioCervix.hccccualresul}"/>
          </h:panelGrid>
          <t:div style="overflow:auto;width:550px;height:40px;">
            <h:outputText style="font-size:8.0pt;"
                          value=" �Ha sufrido de alteraciones en la coagulaci�n, de  antecedentes de alergias u otras patolog�as cr�nicas o catastr�ficas?"/>
          </t:div>
          <h:selectOneRadio id="mnuantecalerg" immediate="true" 
                            binding="#{cuestionarioCervixUsuarioBean.mnuantecalerg}"
                            value="#{cuestionarioCervixUsuarioBean.cuestionarioCervix.hcccantecalerg}">
            <f:selectItems value="#{cuestionarioCervixUsuarioBean.lstOpciones}"/>
          </h:selectOneRadio>
          <h:outputText/>
          <t:div style="overflow:auto;width:550px;height:20px;">
            <h:outputText style="font-size:8.0pt;"
                          value=" �Ha tenido alguna reacci�n al�rgica a la aplicaci�n de alguna vacuna?"/>
          </t:div>
          <h:selectOneRadio id="mnureacivacun" immediate="true" 
                            binding="#{cuestionarioCervixUsuarioBean.mnureacivacun}"
                            value="#{cuestionarioCervixUsuarioBean.cuestionarioCervix.hcccreacivacun}">
            <f:selectItems value="#{cuestionarioCervixUsuarioBean.lstOpciones}"/>
          </h:selectOneRadio>
          <h:outputText/>
          <t:div style="overflow:auto;width:550px;height:20px;">
            <h:outputText style="font-size:8.0pt;"
                          value=" �Est� Usted enferma/o - gripa o cualquier otra patolog�a -  o cree que lo est�?"/>
          </t:div>
          <h:selectOneRadio id="mnuenfergripa" immediate="true" 
                            binding="#{cuestionarioCervixUsuarioBean.mnuenfergripa}"
                            value="#{cuestionarioCervixUsuarioBean.cuestionarioCervix.hcccenfergripa}">
            <f:selectItems value="#{cuestionarioCervixUsuarioBean.lstOpciones}"/>
          </h:selectOneRadio>
          <h:outputText/>
          <t:div style="overflow:auto;width:550px;height:20px;"  rendered="#{cuestionarioCervixUsuarioBean.renderFemenino}">
            <h:outputText style="font-size:8.0pt;" value=" �Est� Usted embarazada o cree que lo est�?"
             rendered="#{cuestionarioCervixUsuarioBean.renderFemenino}"/>
          </t:div>
          <h:selectOneRadio id="mnuestaembar" immediate="true" 
                        rendered="#{cuestionarioCervixUsuarioBean.renderFemenino}"
                            binding="#{cuestionarioCervixUsuarioBean.mnuestaembar}"
                            value="#{cuestionarioCervixUsuarioBean.cuestionarioCervix.hcccestaembar}">
            <f:selectItems value="#{cuestionarioCervixUsuarioBean.lstOpciones}"/>
          </h:selectOneRadio>
          <h:outputText  rendered="#{cuestionarioCervixUsuarioBean.renderFemenino}"/>
         
          <t:div style="overflow:auto;width:550px;height:20px;"  rendered="#{cuestionarioCervixUsuarioBean.renderFemenino}">
            <h:outputText style="font-size:8.0pt;" value=" �Su �ltima menstruaci�n fue normal?"  rendered="#{cuestionarioCervixUsuarioBean.renderFemenino}"/>
          </t:div>
          <h:selectOneRadio id="mnumestrnorma" binding="#{cuestionarioCervixUsuarioBean.mnumestrnorma}" immediate="true"
                                rendered="#{cuestionarioCervixUsuarioBean.renderFemenino}"
                            
                            value="#{cuestionarioCervixUsuarioBean.cuestionarioCervix.hcccmestrnorma}">
            <f:selectItems value="#{cuestionarioCervixUsuarioBean.lstOpciones}"/>
          </h:selectOneRadio>
          <h:panelGrid id="panelUltimaMestruacion" columns="1" border="0" cellpadding="0" cellspacing="0"
           rendered="#{cuestionarioCervixUsuarioBean.renderFemenino}"
                       rowClasses="labelText,labelTextInfo">
            <h:outputText id="otUltimaMestruacion" value="F.U.R."/>
            <h:panelGroup>
              <t:inputCalendar id="calendarUltimaReglaCervix" title="Formato: dd/mm/yyyy"
                               onkeydown="return blockEnter(event);" monthYearRowClass="yearMonthHeader"
                               weekRowClass="weekHeader" 
                               currentDayCellClass="currentDayCell" popupDateFormat="dd/MM/yyyy" renderAsPopup="true"
                               value="#{cuestionarioCervixUsuarioBean.cuestionarioCervix.hccdfecharegla}"
                               popupTodayString="Hoy" popupWeekString="Semana" popupButtonString="Fecha"
                               readonly="false" maxlength="11" size="11"
                               popupButtonImageUrl="/comun/imagenes/ico_calendario2.gif" renderPopupButtonAsImage="true"
                               align="top">
                <f:validator validatorId="dateMenorIgualValidator"/>
              </t:inputCalendar>
              <a4j:outputPanel ajaxRendered="true">
                <t:message for="calendarUltimaReglaCervix" styleClass="errorMessage"/>
              </a4j:outputPanel>
            </h:panelGroup>
          </h:panelGrid>
          <t:div style="overflow:auto;width:550px;height:20px;"  rendered="#{cuestionarioCervixUsuarioBean.renderFemenino}">
            <h:outputText style="font-size:8.0pt;" value=" �Fecha �ltimo parto/aborto "  rendered="#{cuestionarioCervixUsuarioBean.renderFemenino}"/>
          </t:div>
          <h:selectOneRadio id="mnutieneparto" immediate="true" 
                            rendered="#{cuestionarioCervixUsuarioBean.renderFemenino}"
                            binding="#{cuestionarioCervixUsuarioBean.mnutieneparto}"
                            value="#{cuestionarioCervixUsuarioBean.cuestionarioCervix.hccctieneparto}"
                            valueChangeListener="#{cuestionarioCervixUsuarioBean.setHccctieneparto}">
            <f:selectItems value="#{cuestionarioCervixUsuarioBean.lstOpciones}"/>
            <a4j:support id="supportmnutieneparto" event="onclick" immediate="true"
                         action="#{cuestionarioCervixUsuarioBean.changeParto}" reRender="panelUltimoPartoAborto">
              <a4j:ajaxListener type="org.ajax4jsf.ajax.ForceRender"/>
            </a4j:support>
          </h:selectOneRadio>
          <h:panelGrid id="panelUltimoPartoAborto" columns="1" border="0" cellpadding="0" cellspacing="0"
                       rendered="#{cuestionarioCervixUsuarioBean.renderFemenino}"
                       rowClasses="labelText,labelTextInfo">
            <h:outputText id="otUltimaPartoAborto" value="F.U.P.A. "
                          rendered="#{cuestionarioCervixUsuarioBean.renderFechaParto}"/>
            <h:panelGroup>
              <t:inputCalendar id="calendarUltimaPartoAbortoCervix" title="Formato: dd/mm/yyyy"
                               onkeydown="return blockEnter(event);" monthYearRowClass="yearMonthHeader"
                               weekRowClass="weekHeader" rendered="#{cuestionarioCervixUsuarioBean.renderFechaParto}"
                               
                               currentDayCellClass="currentDayCell" popupDateFormat="dd/MM/yyyy" renderAsPopup="true"
                               value="#{cuestionarioCervixUsuarioBean.cuestionarioCervix.hccdfechaparto}"
                               popupTodayString="Hoy" popupWeekString="Semana" popupButtonString="Fecha"
                               readonly="false" maxlength="11" size="11"
                               popupButtonImageUrl="/comun/imagenes/ico_calendario2.gif" renderPopupButtonAsImage="true"
                               align="top">
                <f:validator validatorId="dateMenorIgualValidator"/>
              </t:inputCalendar>
              <a4j:outputPanel ajaxRendered="true" rendered="#{cuestionarioCervixUsuarioBean.renderFechaParto}">
                <t:message for="calendarUltimaPartoAbortoCervix" styleClass="errorMessage"/>
              </a4j:outputPanel>
            </h:panelGroup>
          </h:panelGrid>
          <t:div style="overflow:auto;width:550px;height:40px;">
            <h:outputText style="font-size:8.0pt;"
                          value=" �Usted o su pareja utiliza(n) de manera consistente en la actualidad un m�todo de planificaci�n familiar?"/>
          </t:div>
          <h:selectOneRadio id="mnumetodplani" immediate="true" 
                            binding="#{cuestionarioCervixUsuarioBean.mnumetodplani}"
                            value="#{cuestionarioCervixUsuarioBean.cuestionarioCervix.hcccmetodplani}">
            <f:selectItems value="#{cuestionarioCervixUsuarioBean.lstOpciones}"/>
          </h:selectOneRadio>
          <h:outputText/>
          <t:div style="overflow:auto;width:550px;height:40px;"  rendered="#{cuestionarioCervixUsuarioBean.renderFemenino}">
            <h:outputText style="font-size:8.0pt;"  rendered="#{cuestionarioCervixUsuarioBean.renderFemenino}"
                          value=" �Sabe usted que si est� embarazada o piensa embarazarse en los pr�ximos seis meses no debe colocarse la vacuna?"/>
          </t:div>
          <h:selectOneRadio id="mnupiensembar" immediate="true" 
                            rendered="#{cuestionarioCervixUsuarioBean.renderFemenino}"
                            binding="#{cuestionarioCervixUsuarioBean.mnupiensembar}"
                            value="#{cuestionarioCervixUsuarioBean.cuestionarioCervix.hcccpiensembar}">
            <f:selectItems value="#{cuestionarioCervixUsuarioBean.lstOpciones}"/>
          </h:selectOneRadio>
          <h:outputText  rendered="#{cuestionarioCervixUsuarioBean.renderFemenino}"/>
          <t:div style="overflow:auto;width:550px;height:40px;">
            <h:outputText style="font-size:8.0pt;"
                          value=" �Sabe usted que despu�s de aplicada cada dosis de la vacuna debe permanecer en nuestras instalaciones por media hora?"/>
          </t:div>
          <h:selectOneRadio id="mnumediahora" immediate="true" 
                            binding="#{cuestionarioCervixUsuarioBean.mnumediahora}"
                            value="#{cuestionarioCervixUsuarioBean.cuestionarioCervix.hcccmediahora}">
            <f:selectItems value="#{cuestionarioCervixUsuarioBean.lstOpciones}"/>
          </h:selectOneRadio>
          <h:outputText/>
          <t:div style="overflow:auto;width:550px;height:40px;">
            <h:outputText style="font-size:8.0pt;"
                          value=" �Recibi� informaci�n suficiente para suscribir el consentimiento informado para la aplicaci�n de la vacuna?"/>
          </t:div>
          <h:selectOneRadio id="mnuinforconse" immediate="true" 
                            binding="#{cuestionarioCervixUsuarioBean.mnuinforconse}"
                            value="#{cuestionarioCervixUsuarioBean.cuestionarioCervix.hcccinforconse}">
            <f:selectItems value="#{cuestionarioCervixUsuarioBean.lstOpciones}"/>
          </h:selectOneRadio>
          <h:outputText/>
          <t:div style="overflow:auto;width:550px;height:70px;">
            <h:outputText style="font-size:8.0pt;"
                          value="  �Sabe usted que si se presenta una situaci�n imprevista o que no se considere normal de acuerdo con la informaci�n, las instrucciones o las explicaciones que a usted se le han brindado en forma verbal y personal, como usuaria/o o como responsable DEBE CONSULTAR EN Profamilia DE MANERA INMEDIATA?"/>
          </t:div>
          <h:selectOneRadio id="mnuconsuprofa" immediate="true" 
                            binding="#{cuestionarioCervixUsuarioBean.mnuconsuprofa}"
                            value="#{cuestionarioCervixUsuarioBean.cuestionarioCervix.hcccconsuprofa}">
            <f:selectItems value="#{cuestionarioCervixUsuarioBean.lstOpciones}"/>
          </h:selectOneRadio>
          <h:outputText/>
        </h:panelGrid>
      </s:fieldset>
      <s:fieldset legend="OBSERVACIONES AL INTERROGATORIO " id="fieldObservacionInterrogatorio" styleClass="fieldset">
        <h:panelGrid columns="2" border="0" cellpadding="0" cellspacing="0" width="100%" id="panelObservaciones"
                     rowClasses="labelText,labelTextInfo">
          <h:outputText value="Observaciones" style="font-size:10.0pt;"/>
          <h:outputText/>
          <h:inputTextarea id="hcecobservcervix"
                           value="#{cuestionarioCervixUsuarioBean.cuestionarioCervix.hcccobserinter}"
                           style="width:800px">
            <f:validateLength maximum="999"/>
          </h:inputTextarea>
          <a4j:outputPanel ajaxRendered="true">
            <t:message for="hcecobservcervix" styleClass="errorMessage"/>
          </a4j:outputPanel>
        </h:panelGrid>
      </s:fieldset>
    </t:panelTab>
    <h:panelGroup>
      <a4j:outputPanel id="ajaxRegionMensajesCuestEster" ajaxRendered="true">
        <t:htmlTag value="br"/>
        <t:messages id="msgInformationAndErrors" showSummary="false" errorClass="error" globalOnly="true" layout="table"
                    infoClass="informacion" showDetail="true" tooltip="true" warnClass="advertencia"/>
        <t:htmlTag value="br"/>
      </a4j:outputPanel>
    </h:panelGroup>
    <h:panelGrid columns="1" border="0" cellpadding="0" cellspacing="0" width="100%" id="panelBotonModificar"
                 columnClasses="panelGridBotones">
      <h:panelGroup>
        <h:commandButton value="Guardar" styleClass="boton_fieldset"
                        
                         action="#{cuestionarioCervixUsuarioBean.guardarCuestionario}">
          <a4j:support event="onclick" status="statusButton"/>
        </h:commandButton>
      </h:panelGroup>
    </h:panelGrid>
  </t:panelTabbedPane>
  <f:subview id="generarAnatomia" rendered="#{cuestionarioCervixUsuarioBean.generoCuestionario}">
    <f:verbatim>
      <script type="text/javascript" language="JavaScript">
           window.open("<%=request.getSession().getAttribute(PdfServlet.DOCUMENT_NAME_ATTRIBUTE_NAME)%>", "Documento" , "width=800,height=600");
        </script>
    </f:verbatim>
  </f:subview>
  <script language="javascript" type="text/javascript">
        document.forms[1].elements[6].focus()
</script>
</h:panelGrid>