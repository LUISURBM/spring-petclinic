<%@ page contentType="text/html;charset=iso-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsf/html" prefix="h"%>
<%@ taglib uri="http://java.sun.com/jsf/core" prefix="f"%>
<%@ taglib uri="http://richfaces.org/a4j" prefix="a4j"%>
<%@ taglib uri="http://myfaces.apache.org/tomahawk" prefix="t"%>
<%@ taglib uri="http://myfaces.apache.org/sandbox" prefix="s"%>
<%@ page import="org.profamilia.hc.view.servlet.PdfServlet"%>

<h:panelGrid columns="1" border="0" cellpadding="0" cellspacing="0" width="100%" id="panelGridEspermogramaFertilidadTab"
             styleClass="tabContainer">
  <jsp:include page="/pages/clinico/comunes/encabezadoDatosUsuario.jsp" flush="true"/>
  <t:panelTabbedPane border="0" cellpadding="0" cellspacing="0" serverSideTabSwitch="false" activePanelTabVar="true"
                     width="100%" id="panelTabbedPaneEspermogramaFertilidad" styleClass="tabbedPane"
                     activeTabStyleClass="activeTab" inactiveTabStyleClass="inactiveTab"
                     disabledTabStyleClass="disabledTab" activeSubStyleClass="activeSub"
                     inactiveSubStyleClass="inactiveSub" tabContentStyleClass="tabContent">
    <t:panelTab id="panelTabEspermogramaFertilidad" label="Espermograma Fertilidad">
      <s:fieldset legend="Registrar Espermograma Fertilidad" id="fieldSetEspermograma" styleClass="fieldset">
        <h:panelGrid columns="4" border="0" cellpadding="0" cellspacing="0" width="100%"
                     id="panelDatosEspermograma" rowClasses="labelText,labelTextInfo">
          <h:outputText value="Tipo Espermograma"   styleClass="labelTextOblig"/>
          <h:outputText value=""/>
          <h:outputText value=""/>
          <h:outputText value=""/>
           <a4j:region renderRegionOnly="false">
          <h:selectOneMenu id="mnuTipoEspe" onkeydown="return blockEnter(event);" required="true" 
                           binding="#{espermogramaFertilidadBean.mnuTipoEspe}"
                           value="#{espermogramaFertilidadBean.espermograma.cesntipesp}" immediate="true"
                           valueChangeListener="#{espermogramaFertilidadBean.setCesntipesp}">
            <f:selectItems value="#{espermogramaFertilidadBean.lstTipoEspermograma}"/>
            <a4j:support id="supportmnuTipoEspe" action="#{espermogramaFertilidadBean.changeTipoEspermograma}" 
                         reRender="panelTabEspermogramaFertilidad" 
                         event="onchange" immediate="true">
              <a4j:ajaxListener type="org.ajax4jsf.ajax.ForceRender"/>
            </a4j:support>
          </h:selectOneMenu>
          <a4j:outputPanel ajaxRendered="true">
            <t:message for="mnuTipoEspe" styleClass="errorMessage"/>
          </a4j:outputPanel>
          </a4j:region>
          <h:outputText value=""/>
          <h:outputText value=""/>
          <h:outputText value=""/>

          <h:outputText value="N�mero"   styleClass="labelTextOblig"/>
          <h:outputText value=""/>
          <h:outputText value="Fecha Resultado"   styleClass="labelTextOblig"/>
          <h:outputText value=""/>
          <h:inputText id="textNumero" value="#{espermogramaFertilidadBean.espermograma.cesnnumero}" required="true"
                      style="width:80px" maxlength="8" disabled="#{espermogramaFertilidadBean.modoconsulta}"/>
          <a4j:outputPanel ajaxRendered="true">
              <t:message for="textNumero" styleClass="errorMessage"/>
          </a4j:outputPanel>
          
          <t:inputCalendar id="fechaResultado" title="Formato: dd/mm/yyyy" monthYearRowClass="yearMonthHeader"
                           weekRowClass="weekHeader" onkeydown="return blockEnter(event);" disabled="#{espermogramaFertilidadBean.modoconsulta}"
                           currentDayCellClass="currentDayCell" popupDateFormat="dd/MM/yyyy" renderAsPopup="true"
                           value="#{espermogramaFertilidadBean.espermograma.cesdfecesp}" popupTodayString="Hoy"
                           popupWeekString="Semana" popupButtonString="Fecha" readonly="false" maxlength="11" size="11"
                           popupButtonImageUrl="/comun/imagenes/ico_calendario.gif" renderPopupButtonAsImage="true"
                           align="top" required="true"/>
          <a4j:outputPanel ajaxRendered="true">
              <t:message for="fechaResultado" styleClass="errorMessage"/>
          </a4j:outputPanel>

          <h:outputText value="Remite" />
          <h:outputText value=""/>
          <h:outputText value="Abstinencia Sexual"   styleClass="labelTextOblig"/>
          <h:outputText value=""/>
          <h:inputText id="txtRemite" value="#{espermogramaFertilidadBean.espermograma.cescremite}" 
                      style="width:300px" maxlength="30" disabled="#{espermogramaFertilidadBean.modoconsulta}"/>
          <a4j:outputPanel ajaxRendered="true">
               <t:message for="txtRemite" styleClass="errorMessage"/>
          </a4j:outputPanel>
          <h:panelGroup>
             <h:inputText id="txtAbstiene" value="#{espermogramaFertilidadBean.espermograma.cesndiaabs}" required="true"
                      style="width:40px" maxlength="4" disabled="#{espermogramaFertilidadBean.modoconsulta}"/>
             <h:outputText value="dias"/>
          </h:panelGroup>
          <a4j:outputPanel ajaxRendered="true">
               <t:message for="txtAbstiene" styleClass="errorMessage"/>
          </a4j:outputPanel>

        </h:panelGrid>
     
        <s:fieldset legend="Antecedentes" id="fieldAntecedentes" styleClass="fieldset" rendered="#{espermogramaFertilidadBean.renderBasico}">
        <h:panelGrid columns="10" border="0" cellpadding="0" cellspacing="0" width="100%" id="panelAntecedentes" 
                   rowClasses="labelText,labelTextInfo" rendered="#{espermogramaFertilidadBean.renderBasico}">
          <h:outputText value="Parotiditis"   styleClass="labelTextOblig"/>
          <h:outputText value=""/>
          <h:outputText value="Orquitis"   styleClass="labelTextOblig"/>
          <h:outputText value=""/>
          <h:outputText value="Fuma"   styleClass="labelTextOblig"/>
          <h:outputText value=""/>
          <h:outputText value="ITS"   styleClass="labelTextOblig"/>
          <h:outputText value=""/>
          <h:outputText value="Hijos biol�gicos"   styleClass="labelTextOblig"/>
          <h:outputText value=""/>
          <h:selectOneRadio id="mnuParotiditis" required="true"
                       onkeydown="return blockEnter(event);"  disabled="#{espermogramaFertilidadBean.modoconsulta}"
                       value="#{espermogramaFertilidadBean.espermograma.cescparoti}">
               <f:selectItems value="#{espermogramaFertilidadBean.lstSiNo}"/>
          </h:selectOneRadio>
          <a4j:outputPanel ajaxRendered="true">
               <t:message for="mnuParotiditis" styleClass="errorMessage"/>
          </a4j:outputPanel>
          <h:selectOneRadio id="mnuOrquitis" required="true"
                       onkeydown="return blockEnter(event);"  disabled="#{espermogramaFertilidadBean.modoconsulta}"
                       value="#{espermogramaFertilidadBean.espermograma.cescorquit}">
               <f:selectItems value="#{espermogramaFertilidadBean.lstSiNo}"/>
          </h:selectOneRadio>
          <a4j:outputPanel ajaxRendered="true">
               <t:message for="mnuOrquitis" styleClass="errorMessage"/>
          </a4j:outputPanel>
          <h:selectOneRadio id="mnuFuma" required="true"
                       onkeydown="return blockEnter(event);"  disabled="#{espermogramaFertilidadBean.modoconsulta}"
                       value="#{espermogramaFertilidadBean.espermograma.cescfumar}">
               <f:selectItems value="#{espermogramaFertilidadBean.lstSiNo}"/>
          </h:selectOneRadio>
          <a4j:outputPanel ajaxRendered="true">
               <t:message for="mnuFuma" styleClass="errorMessage"/>
          </a4j:outputPanel>
          <h:selectOneRadio id="mnuEts" required="true"
                       onkeydown="return blockEnter(event);"  disabled="#{espermogramaFertilidadBean.modoconsulta}"
                       value="#{espermogramaFertilidadBean.espermograma.cescets}">
               <f:selectItems value="#{espermogramaFertilidadBean.lstSiNo}"/>
          </h:selectOneRadio>
          <a4j:outputPanel ajaxRendered="true">
               <t:message for="mnuEts" styleClass="errorMessage"/>
          </a4j:outputPanel>
          <h:inputText id="txtHijos" value="#{espermogramaFertilidadBean.espermograma.cesnhijos}" 
                        required="true"
                        style="width:40px" maxlength="2" disabled="#{espermogramaFertilidadBean.modoconsulta}"/>
          <a4j:outputPanel ajaxRendered="true">
               <t:message for="txtHijos" styleClass="errorMessage"/>
          </a4j:outputPanel>
        </h:panelGrid>

        <h:panelGrid columns="4" border="0" cellpadding="0" cellspacing="0" width="100%" id="panelAntecedentes1"
                   rowClasses="labelText,labelTextInfo" rendered="#{espermogramaFertilidadBean.renderBasico}">
          <h:outputText value="Medicamentos actualmente"   styleClass="labelTextOblig"/>
          <h:outputText value=""/>
          <h:outputText value="Cirug�as"   styleClass="labelTextOblig"/>
          <h:outputText value=""/>
          <h:inputText id="txtMedica" value="#{espermogramaFertilidadBean.espermograma.cescmedact}" 
                      style="width:150px" maxlength="15" disabled="#{espermogramaFertilidadBean.modoconsulta}"/>
          <a4j:outputPanel ajaxRendered="true">
               <t:message for="txtMedica" styleClass="errorMessage"/>
          </a4j:outputPanel>
          <h:inputText id="txtCirugia" value="#{espermogramaFertilidadBean.espermograma.cesccirugi}" 
                      style="width:300px" maxlength="30" disabled="#{espermogramaFertilidadBean.modoconsulta}"/>
          <a4j:outputPanel ajaxRendered="true">
               <t:message for="txtCirugia" styleClass="errorMessage"/>
          </a4j:outputPanel>
          <h:outputText value="Infertilidad"   styleClass="labelTextOblig"/>
          <h:outputText value=""/>
          <h:outputText value="Urolog�a"   styleClass="labelTextOblig"/>
          <h:outputText value=""/>
          <h:inputText id="txtInfertilidad" value="#{espermogramaFertilidadBean.espermograma.cescinfert}" 
                      style="width:100px" maxlength="10" disabled="#{espermogramaFertilidadBean.modoconsulta}"/>
          <a4j:outputPanel ajaxRendered="true">
               <t:message for="txtInfertilidad" styleClass="errorMessage"/>
          </a4j:outputPanel>
          <h:inputText id="txtUrologia" value="#{espermogramaFertilidadBean.espermograma.cescurolog}" 
                      style="width:350px" maxlength="35" disabled="#{espermogramaFertilidadBean.modoconsulta}"/>
          <a4j:outputPanel ajaxRendered="true">
               <t:message for="txtUrologia" styleClass="errorMessage"/>
          </a4j:outputPanel>
          <h:outputText value="Otros"   styleClass="labelTextOblig"/>
          <h:outputText value=""/>
          <h:outputText value=""/>
          <h:outputText value=""/>
          <h:inputText id="txtOtros" value="#{espermogramaFertilidadBean.espermograma.cescotros}" 
                      style="width:300px" maxlength="35" disabled="#{espermogramaFertilidadBean.modoconsulta}"/>
          <a4j:outputPanel ajaxRendered="true">
               <t:message for="txtOtros" styleClass="errorMessage"/>
          </a4j:outputPanel>
        </h:panelGrid>
        </s:fieldset>

        <s:fieldset legend="Recuento Esperm�tico" id="fieldRecuento" styleClass="fieldset" rendered="#{espermogramaFertilidadBean.renderBasico}">
        <h:panelGrid columns="6" border="0" cellpadding="0" cellspacing="0" width="100%" id="panelRecuento"
                   rowClasses="labelText,labelTextInfo" rendered="#{espermogramaFertilidadBean.renderBasico}">
          <h:outputText value="Volumen"   styleClass="labelTextOblig"/>
          <h:outputText value=""/>
          <h:outputText value="Viscosidad (LICUEFACCI�N)"   styleClass="labelTextOblig"/>
          <h:outputText value=""/>
          <h:outputText value="Color"   styleClass="labelTextOblig"/>
          <h:outputText value=""/>
          <a4j:region renderRegionOnly="false">
          <h:panelGroup>   
            <h:inputText id="txtVolumen" value="#{espermogramaFertilidadBean.volumen}" 
                    required="#{espermogramaFertilidadBean.renderBasico}" immediate="true"
                    onkeydown="return blockEnter(event);" valueChangeListener="#{espermogramaFertilidadBean.setVolumen}"
                   style="width:50px" disabled="#{espermogramaFertilidadBean.modoconsulta}">
               <a4j:support id="supportVolumen" event="onchange" immediate="true"
                          reRender="idTotal,panelCapacita" action="#{espermogramaFertilidadBean.setCesatotal}">
                  <a4j:ajaxListener type="org.ajax4jsf.ajax.ForceRender"/>
               </a4j:support>
            </h:inputText>     
            <h:outputText value="ml"/>
          </h:panelGroup>
          </a4j:region>
          <a4j:outputPanel ajaxRendered="true">
               <t:message for="txtVolumen" styleClass="errorMessage"/>
          </a4j:outputPanel>
          <h:selectOneMenu id="mnuViscosidad" onkeydown="return blockEnter(event);" required="true" 
                           value="#{espermogramaFertilidadBean.espermograma.cescviscos}">
            <f:selectItems value="#{espermogramaFertilidadBean.lstViscosidad}"/>
          </h:selectOneMenu>
          <a4j:outputPanel ajaxRendered="true">
            <t:message for="mnuViscosidad" styleClass="errorMessage"/>
          </a4j:outputPanel>
          <h:selectOneMenu id="mnuColor" onkeydown="return blockEnter(event);" required="true" 
                           value="#{espermogramaFertilidadBean.espermograma.cesccolor}">
            <f:selectItems value="#{espermogramaFertilidadBean.lstColor}"/>
          </h:selectOneMenu>
          <a4j:outputPanel ajaxRendered="true">
            <t:message for="mnuColor" styleClass="errorMessage"/>
          </a4j:outputPanel>
          <h:outputText value="Cantidad"   styleClass="labelTextOblig"/>
          <h:outputText value=""/>
          <h:outputText value="Total"   styleClass="labelTextOblig"/>
          <h:outputText value=""/>
          <h:outputText value=""/>
          <h:outputText value=""/>
          <a4j:region renderRegionOnly="false">
          <h:panelGroup>          
            <h:inputText id="txtCantidad" value="#{espermogramaFertilidadBean.cantidad}" 
                   required="#{espermogramaFertilidadBean.renderBasico}" immediate="true"
                   onkeydown="return blockEnter(event);" valueChangeListener="#{espermogramaFertilidadBean.setCantidad}"
                   style="width:50px" disabled="#{espermogramaFertilidadBean.modoconsulta}">
               <a4j:support id="supportCantidad" event="onchange" immediate="true"
                          reRender="idTotal,panelCapacita" action="#{espermogramaFertilidadBean.setCesatotal}">
                  <a4j:ajaxListener type="org.ajax4jsf.ajax.ForceRender"/>
               </a4j:support>
            </h:inputText>
            <h:outputText value="x 10(6)/ml"/>
          </h:panelGroup>
          </a4j:region>
          <a4j:outputPanel ajaxRendered="true">
               <t:message for="txtCantidad" styleClass="errorMessage"/>
          </a4j:outputPanel>
          <h:panelGroup id="idTotal">          
            <h:outputText id="txtTotal" value="#{espermogramaFertilidadBean.total} x 10(6)/ml" 
                   style="width:80px"/>
            <a4j:outputPanel ajaxRendered="true">
               <t:message for="txtTotal" styleClass="errorMessage"/>
            </a4j:outputPanel>
          </h:panelGroup>
        </h:panelGrid>
        </s:fieldset>

        <s:fieldset legend="Movilidad" id="fieldMovilidad" styleClass="fieldset" rendered="#{espermogramaFertilidadBean.renderBasico}">
        <h:panelGrid columns="6" border="0" cellpadding="0" cellspacing="0" width="100%" id="panelMovilidad"
                   rowClasses="labelText,labelTextInfo">
          <h:outputText value="M�vil progresivo"   styleClass="labelTextOblig"/>
          <h:outputText value=""/>
          <h:outputText value="No progresivos"   styleClass="labelTextOblig"/>
          <h:outputText value=""/>
          <h:outputText value="Inm�vil"   styleClass="labelTextOblig"/>
          <h:outputText value=""/>
          <a4j:region renderRegionOnly="false">
          <h:panelGroup>          
            <h:inputText id="txtProgresivos" value="#{espermogramaFertilidadBean.progresivo}" 
                    required="#{espermogramaFertilidadBean.renderBasico}" immediate="true"
                    onkeydown="return blockEnter(event);" valueChangeListener="#{espermogramaFertilidadBean.setProgresivo}"
                   style="width:50px" disabled="#{espermogramaFertilidadBean.modoconsulta}">
               <a4j:support id="supportProgresivo" event="onchange" immediate="true"
                          reRender="panelCapacita" action="#{espermogramaFertilidadBean.muestraFresco}">
                  <a4j:ajaxListener type="org.ajax4jsf.ajax.ForceRender"/>
               </a4j:support>
            </h:inputText>     
            <h:outputText value="%"/>
          </h:panelGroup>
          </a4j:region>
          <a4j:outputPanel ajaxRendered="true">
               <t:message for="txtProgresivos" styleClass="errorMessage"/>
          </a4j:outputPanel>
          <a4j:region renderRegionOnly="false">
          <h:panelGroup>          
            <h:inputText id="txtNoProgresivos" value="#{espermogramaFertilidadBean.pendulares}" 
                    required="#{espermogramaFertilidadBean.renderBasico}" immediate="true"
                    onkeydown="return blockEnter(event);" valueChangeListener="#{espermogramaFertilidadBean.setPendulares}"
                   style="width:50px" disabled="#{espermogramaFertilidadBean.modoconsulta}">
               <a4j:support id="supportNoProgresivo" event="onchange" immediate="true"
                          reRender="panelCapacita" action="#{espermogramaFertilidadBean.muestraFresco}">
                  <a4j:ajaxListener type="org.ajax4jsf.ajax.ForceRender"/>
               </a4j:support>
            </h:inputText>     
            <h:outputText value="%"/>
          </h:panelGroup>
          </a4j:region>
          <a4j:outputPanel ajaxRendered="true">
               <t:message for="txtNoProgresivos" styleClass="errorMessage"/>
          </a4j:outputPanel>
          <a4j:region renderRegionOnly="false">
          <h:panelGroup>          
            <h:inputText id="txtInmovil" value="#{espermogramaFertilidadBean.inmovil}" 
                    required="#{espermogramaFertilidadBean.renderBasico}" immediate="true"
                    onkeydown="return blockEnter(event);" valueChangeListener="#{espermogramaFertilidadBean.setInmovil}"
                   style="width:50px" disabled="#{espermogramaFertilidadBean.modoconsulta}">
               <a4j:support id="supportInmovil" event="onchange" immediate="true"
                          reRender="panelCapacita" action="#{espermogramaFertilidadBean.muestraFresco}">
                  <a4j:ajaxListener type="org.ajax4jsf.ajax.ForceRender"/>
               </a4j:support>
            </h:inputText>     
            <h:outputText value="%"/>
          </h:panelGroup>
          </a4j:region>
          <a4j:outputPanel ajaxRendered="true">
               <t:message for="txtInmovil" styleClass="errorMessage"/>
          </a4j:outputPanel>
        </h:panelGrid>
        </s:fieldset>

        <s:fieldset legend="Vitalidad" id="fieldVitalidad" styleClass="fieldset" rendered="#{espermogramaFertilidadBean.renderBasico}">
        <h:panelGrid columns="4" border="0" cellpadding="0" cellspacing="0" width="100%" id="panelVitalidad"
                   rowClasses="labelText,labelTextInfo">
          <h:outputText value="Vivos"   styleClass="labelTextOblig"/>
          <h:outputText value=""/>
          <h:outputText value="Muertos"   styleClass="labelTextOblig"/>
          <h:outputText value=""/>
          <a4j:region renderRegionOnly="false">
          <h:panelGroup>          
            <h:inputText id="txtVivos" value="#{espermogramaFertilidadBean.vivos}" 
                    required="#{espermogramaFertilidadBean.renderBasico}" immediate="true"
                    onkeydown="return blockEnter(event);" valueChangeListener="#{espermogramaFertilidadBean.setVivos}"
                   style="width:50px" disabled="#{espermogramaFertilidadBean.modoconsulta}">
               <a4j:support id="supportVivos" event="onchange" immediate="true"
                          reRender="panelCapacita" action="#{espermogramaFertilidadBean.muestraFresco}">
                  <a4j:ajaxListener type="org.ajax4jsf.ajax.ForceRender"/>
               </a4j:support>
            </h:inputText>     
            <h:outputText value="%"/>
          </h:panelGroup>
          </a4j:region>
          <a4j:outputPanel ajaxRendered="true">
               <t:message for="txtVivos" styleClass="errorMessage"/>
          </a4j:outputPanel>
          <h:panelGroup>          
            <h:inputText id="txtMuertos" value="#{espermogramaFertilidadBean.espermograma.cesnmuerto}" required="true"
                   style="width:50px" disabled="#{espermogramaFertilidadBean.modoconsulta}"/>
            <h:outputText value="%"/>
          </h:panelGroup>
          <a4j:outputPanel ajaxRendered="true">
               <t:message for="txtMuertos" styleClass="errorMessage"/>
          </a4j:outputPanel>
        </h:panelGrid>
        </s:fieldset>
        
        <s:fieldset legend="Morfologia" id="fieldMorfologia" styleClass="fieldset" rendered="#{espermogramaFertilidadBean.renderBasico}">
        <h:panelGrid columns="6" border="0" cellpadding="0" cellspacing="0" width="100%" id="panelMorfologia"
                   rowClasses="labelText,labelTextInfo">
          <h:outputText value="Normales"   styleClass="labelTextOblig"/>
          <h:outputText value=""/>
          <h:outputText value="Anormales"   styleClass="labelTextOblig"/>
          <h:outputText value=""/>
          <h:outputText value="�ndice de Teratozoospermia"   styleClass="labelTextOblig"/>
          <h:outputText value=""/>
          <h:panelGroup>          
            <h:inputText id="txtNormales" value="#{espermogramaFertilidadBean.espermograma.cesnnormal}" required="true"
                   style="width:50px" disabled="#{espermogramaFertilidadBean.modoconsulta}"/>
            <h:outputText value="%"/>
          </h:panelGroup>
          <a4j:outputPanel ajaxRendered="true">
               <t:message for="txtNormales" styleClass="errorMessage"/>
          </a4j:outputPanel>
          <a4j:region renderRegionOnly="false">
          <h:panelGroup>          
            <h:inputText id="txtAnormales" value="#{espermogramaFertilidadBean.anormales}" 
                   required="#{espermogramaFertilidadBean.renderBasico}" immediate="true"
                   onkeydown="return blockEnter(event);" valueChangeListener="#{espermogramaFertilidadBean.setAnormales}"
                   style="width:50px" disabled="#{espermogramaFertilidadBean.modoconsulta}">
               <a4j:support id="supportAnormales" event="onchange" immediate="true"
                          reRender="idIndice" action="#{espermogramaFertilidadBean.setIndiceTera}">
                  <a4j:ajaxListener type="org.ajax4jsf.ajax.ForceRender"/>
               </a4j:support>
            </h:inputText>
            <h:outputText value="%"/>
          </h:panelGroup>
          </a4j:region>
          <a4j:outputPanel ajaxRendered="true">
               <t:message for="txtAnormales" styleClass="errorMessage"/>
          </a4j:outputPanel>
          <h:panelGroup id="idIndice">          
            <h:outputText id="txtIndice" value="#{espermogramaFertilidadBean.indice}" 
                   style="width:60px"/>
          </h:panelGroup>
          <a4j:outputPanel ajaxRendered="true">
             <t:message for="txtIndice" styleClass="errorMessage"/>
          </a4j:outputPanel>
          <h:outputText value="Anomal�as de cabeza"   styleClass="labelTextOblig"/>
          <h:outputText value=""/>
          <h:outputText value="Anomal�as de pieza media"   styleClass="labelTextOblig"/>
          <h:outputText value=""/>
          <h:outputText value="Anomal�as de flagelo"   styleClass="labelTextOblig"/>
          <h:outputText value=""/>
          <a4j:region renderRegionOnly="false">
          <h:panelGroup>          
            <h:inputText id="txtAnoCabeza" value="#{espermogramaFertilidadBean.anomaliaCab}" 
                   required="#{espermogramaFertilidadBean.renderBasico}" immediate="true"
                   onkeydown="return blockEnter(event);" valueChangeListener="#{espermogramaFertilidadBean.setAnomaliaCab}"
                   style="width:50px" disabled="#{espermogramaFertilidadBean.modoconsulta}">
               <a4j:support id="supportAnoCabeza" event="onchange" immediate="true"
                          reRender="idIndice" action="#{espermogramaFertilidadBean.setIndiceTera}">
                  <a4j:ajaxListener type="org.ajax4jsf.ajax.ForceRender"/>
               </a4j:support>
            </h:inputText>
            <h:outputText value="%"/>
          </h:panelGroup>
          </a4j:region>
          <a4j:outputPanel ajaxRendered="true">
               <t:message for="txtAnoCabeza" styleClass="errorMessage"/>
          </a4j:outputPanel>
          <a4j:region renderRegionOnly="false">
          <h:panelGroup>          
            <h:inputText id="txtAnoPieza" value="#{espermogramaFertilidadBean.anomaliaPie}" 
                   required="#{espermogramaFertilidadBean.renderBasico}" immediate="true"
                   onkeydown="return blockEnter(event);" valueChangeListener="#{espermogramaFertilidadBean.setAnomaliaPie}"
                   style="width:50px" disabled="#{espermogramaFertilidadBean.modoconsulta}">
               <a4j:support id="supportAnoPieza" event="onchange" immediate="true"
                          reRender="idIndice" action="#{espermogramaFertilidadBean.setIndiceTera}">
                  <a4j:ajaxListener type="org.ajax4jsf.ajax.ForceRender"/>
               </a4j:support>
            </h:inputText>
            <h:outputText value="%"/>
          </h:panelGroup>
          </a4j:region>
          <a4j:outputPanel ajaxRendered="true">
               <t:message for="txtAnoPieza" styleClass="errorMessage"/>
          </a4j:outputPanel>
          <a4j:region renderRegionOnly="false">
          <h:panelGroup>          
            <h:inputText id="txtAnoFlagelo" value="#{espermogramaFertilidadBean.anomaliaFla}" 
                   required="#{espermogramaFertilidadBean.renderBasico}" immediate="true"
                   onkeydown="return blockEnter(event);" valueChangeListener="#{espermogramaFertilidadBean.setAnomaliaFla}"
                   style="width:50px" disabled="#{espermogramaFertilidadBean.modoconsulta}">
               <a4j:support id="supportAnoFlagelo" event="onchange" immediate="true"
                          reRender="idIndice" action="#{espermogramaFertilidadBean.setIndiceTera}">
                  <a4j:ajaxListener type="org.ajax4jsf.ajax.ForceRender"/>
               </a4j:support>
            </h:inputText>
            <h:outputText value="%"/>
          </h:panelGroup>
          </a4j:region>
          <a4j:outputPanel ajaxRendered="true">
               <t:message for="txtAnoFlagelo" styleClass="errorMessage"/>
          </a4j:outputPanel>
          <h:outputText value="Leucocitos"   styleClass="labelTextOblig"/>
          <h:outputText value=""/>
          <h:outputText value="Piocitos"   styleClass="labelTextOblig"/>
          <h:outputText value=""/>
          <h:outputText value="Hemat�es"   styleClass="labelTextOblig"/>
          <h:outputText value=""/>
          <h:inputText id="txtLeucocitos" value="#{espermogramaFertilidadBean.espermograma.cescleucoc}" 
                      style="width:100px" maxlength="10" disabled="#{espermogramaFertilidadBean.modoconsulta}"/>
          <a4j:outputPanel ajaxRendered="true">
               <t:message for="txtLeucocitos" styleClass="errorMessage"/>
          </a4j:outputPanel>
          <h:inputText id="txtPiocitos" value="#{espermogramaFertilidadBean.espermograma.cescpiocit}" 
                      style="width:100px" maxlength="10" disabled="#{espermogramaFertilidadBean.modoconsulta}"/>
          <a4j:outputPanel ajaxRendered="true">
               <t:message for="txtPiocitos" styleClass="errorMessage"/>
          </a4j:outputPanel>
          <h:inputText id="txtHematies" value="#{espermogramaFertilidadBean.espermograma.ceschemati}" 
                      style="width:100px" maxlength="10" disabled="#{espermogramaFertilidadBean.modoconsulta}"/>
          <a4j:outputPanel ajaxRendered="true">
               <t:message for="txtHematies" styleClass="errorMessage"/>
          </a4j:outputPanel>

        </h:panelGrid>
        </s:fieldset>

        <s:fieldset legend="Diagn�stico de la Muestra" id="fieldDiagnostico" styleClass="fieldset"
             rendered="#{espermogramaFertilidadBean.renderBasico}">
          <h:panelGrid columns="8" border="0" cellpadding="0" cellspacing="0" width="100%" id="panelDiagnostico"
                   rowClasses="labelText,labelTextInfo" rendered="#{espermogramaFertilidadBean.renderBasico}">
          <h:outputText value="Oligozoospermia"   styleClass="labelTextOblig"/>
          <h:outputText value=""/>
          <h:outputText value="Astenozoospermia"   styleClass="labelTextOblig"/>
          <h:outputText value=""/>
          <h:outputText value="Teratozoospermia"   styleClass="labelTextOblig"/>
          <h:outputText value=""/>
          <h:outputText value="Normozoospermia"   styleClass="labelTextOblig"/>
          <h:outputText value=""/>
          <a4j:region renderRegionOnly="false">
          <h:panelGroup id="panelOligoz">
          <h:selectOneRadio id="mnuOligoz" required="true"
                       onkeydown="return blockEnter(event);"  disabled="#{espermogramaFertilidadBean.modoconsulta}"
                           binding="#{espermogramaFertilidadBean.inpOligoz}"
                       value="#{espermogramaFertilidadBean.oligoz}" 
                       immediate="true" valueChangeListener="#{espermogramaFertilidadBean.setOligoz}">
              <f:selectItems value="#{espermogramaFertilidadBean.lstSiNo}"/>
              <a4j:support id="supportmnuOligoz" action="#{espermogramaFertilidadBean.changeDiagnostico}" 
                         reRender="panelNormoz" event="onchange" immediate="true">
                <a4j:ajaxListener type="org.ajax4jsf.ajax.ForceRender"/>
              </a4j:support>
          </h:selectOneRadio>
          </h:panelGroup>
          </a4j:region>
          <a4j:outputPanel ajaxRendered="true">
               <t:message for="mnuOligoz" styleClass="errorMessage"/>
          </a4j:outputPanel>
          <a4j:region renderRegionOnly="false">
          <h:panelGroup id="panelAsteno">
          <h:selectOneRadio id="mnuAsteno" required="true"
                       onkeydown="return blockEnter(event);"  disabled="#{espermogramaFertilidadBean.modoconsulta}"
                           binding="#{espermogramaFertilidadBean.inpAsteno}"
                       value="#{espermogramaFertilidadBean.asteno}" 
                       immediate="true" valueChangeListener="#{espermogramaFertilidadBean.setAsteno}">
               <f:selectItems value="#{espermogramaFertilidadBean.lstSiNo}"/>
              <a4j:support id="supportmnuAsteno" action="#{espermogramaFertilidadBean.changeDiagnostico}" 
                         reRender="panelNormoz" event="onchange" immediate="true">
                <a4j:ajaxListener type="org.ajax4jsf.ajax.ForceRender"/>
              </a4j:support>
          </h:selectOneRadio>
          </h:panelGroup>
          </a4j:region>
          <a4j:outputPanel ajaxRendered="true">
               <t:message for="mnuAsteno" styleClass="errorMessage"/>
          </a4j:outputPanel>
          <a4j:region renderRegionOnly="false">
          <h:panelGroup id="panelTerato">
          <h:selectOneRadio id="mnuTerato" required="true"
                       onkeydown="return blockEnter(event);"  disabled="#{espermogramaFertilidadBean.modoconsulta}"
                           binding="#{espermogramaFertilidadBean.inpTerato}"
                       value="#{espermogramaFertilidadBean.terato}" 
                       immediate="true" valueChangeListener="#{espermogramaFertilidadBean.setTerato}">
               <f:selectItems value="#{espermogramaFertilidadBean.lstSiNo}"/>
              <a4j:support id="supportmnuTerato" action="#{espermogramaFertilidadBean.changeDiagnostico}" 
                         reRender="panelNormoz" event="onchange" immediate="true">
                <a4j:ajaxListener type="org.ajax4jsf.ajax.ForceRender"/>
              </a4j:support>
          </h:selectOneRadio>
          </h:panelGroup>
          </a4j:region>
          <a4j:outputPanel ajaxRendered="true">
               <t:message for="mnuTerato" styleClass="errorMessage"/>
          </a4j:outputPanel>
          <a4j:region renderRegionOnly="false">
          <h:panelGroup id="panelNormoz">
          <h:selectOneRadio id="mnuNormoz" required="true"
                       onkeydown="return blockEnter(event);"  disabled="#{espermogramaFertilidadBean.modoconsulta}"
                           binding="#{espermogramaFertilidadBean.inpNormoz}"
                       value="#{espermogramaFertilidadBean.normoz}" 
                       immediate="true" valueChangeListener="#{espermogramaFertilidadBean.setNormoz}">
               <f:selectItems value="#{espermogramaFertilidadBean.lstSiNo}"/>
              <a4j:support id="supportmnuNormoz" action="#{espermogramaFertilidadBean.changeDiagnosticoNormoz}" 
                         reRender="panelTerato,panelAsteno,panelOligoz" event="onchange" >
                <a4j:ajaxListener type="org.ajax4jsf.ajax.ForceRender"/>
              </a4j:support>
          </h:selectOneRadio>
          </h:panelGroup>
          </a4j:region>
          <a4j:outputPanel ajaxRendered="true">
               <t:message for="mnuNormoz" styleClass="errorMessage"/>
          </a4j:outputPanel>
          </h:panelGrid>
        </s:fieldset>

        <h:panelGrid columns="2" border="0" cellpadding="0" cellspacing="0" width="100%" id="panelDatosEspermograma2"
                   rowClasses="labelText,labelTextInfo" rendered="#{espermogramaFertilidadBean.renderBasico}">
          <h:outputText value="Observaciones Espermograma" styleClass="labelTextOblig"/>
          <h:outputText value=""/>
          <h:inputTextarea id="textObsEspermograma" value="#{espermogramaFertilidadBean.espermograma.cesxobserv}"
                   style="width:500px;height:70px" disabled="#{espermogramaFertilidadBean.modoconsulta}"/>
          <a4j:outputPanel ajaxRendered="true">
               <t:message for="textObsEspermograma" styleClass="errorMessage"/>
          </a4j:outputPanel>
        </h:panelGrid>

        
        <s:fieldset legend="Capacitaci�n Esperm�tica" id="fieldCapacitacion" styleClass="fieldset"
             rendered="#{espermogramaFertilidadBean.renderCapacitacion}">
        <h:panelGrid columns="1" border="0" cellpadding="0" cellspacing="0" width="100%" id="panelCapacita" 
             rendered="#{espermogramaFertilidadBean.renderCapacitacion}" title="Capacitacion Esperm�tica">
          <s:fieldset legend="Muestra en Fresco" id="fieldFresco" styleClass="fieldset">
            <h:panelGrid columns="12" border="0" cellpadding="0" cellspacing="0" width="100%" id="panelCapacitacion"
                   rowClasses="labelText,labelTextInfo">
            <h:outputText value="Volumen"   styleClass="labelTextOblig"/>
            <h:outputText value=""/>
            <h:outputText value="Cantidad"   styleClass="labelTextOblig"/>
            <h:outputText value=""/>
            <h:outputText value="Movil Progresivo"   styleClass="labelTextOblig"/>
            <h:outputText value=""/>
            <h:outputText value="No Progresivos"   styleClass="labelTextOblig"/>
            <h:outputText value=""/>
            <h:outputText value="Inmovil"   styleClass="labelTextOblig"/>
            <h:outputText value=""/>
            <h:outputText value="Vitalidad"   styleClass="labelTextOblig"/>
            <h:outputText value=""/>
            <h:inputText id="txtCapVolumen" value="#{espermogramaFertilidadBean.capVolumen}" required="true"
                  style="width:50px" disabled="#{espermogramaFertilidadBean.modoconsulta || espermogramaFertilidadBean.renderBasico}"/>
            <a4j:outputPanel ajaxRendered="true">
                 <t:message for="txtCapVolumen" styleClass="errorMessage"/>
            </a4j:outputPanel>
            <h:inputText id="txtCapCantidad" value="#{espermogramaFertilidadBean.capCantidad}" required="true"
                  style="width:50px" disabled="#{espermogramaFertilidadBean.modoconsulta || espermogramaFertilidadBean.renderBasico}"/>
            <a4j:outputPanel ajaxRendered="true">
                 <t:message for="txtCapCantidad" styleClass="errorMessage"/>
            </a4j:outputPanel>
            <h:panelGroup>          
              <h:inputText id="txtCapProgresivo" value="#{espermogramaFertilidadBean.capProgresivos}" required="true"
                   style="width:50px" disabled="#{espermogramaFertilidadBean.modoconsulta || espermogramaFertilidadBean.renderBasico}"/>
              <h:outputText value="%"/>
            </h:panelGroup>
            <a4j:outputPanel ajaxRendered="true">
                 <t:message for="txtCapProgresivo" styleClass="errorMessage"/>
            </a4j:outputPanel>
            <h:panelGroup>          
              <h:inputText id="txtCapNoprogre" value="#{espermogramaFertilidadBean.capPendulares}" required="true"
                   style="width:50px" disabled="#{espermogramaFertilidadBean.modoconsulta || espermogramaFertilidadBean.renderBasico}"/>
              <h:outputText value="%"/>
            </h:panelGroup>
            <a4j:outputPanel ajaxRendered="true">
                 <t:message for="txtCapNoprogre" styleClass="errorMessage"/>
            </a4j:outputPanel>
            <h:panelGroup>          
              <h:inputText id="txtCapInmovil" value="#{espermogramaFertilidadBean.capInmoviles}" required="true"
                   style="width:50px" disabled="#{espermogramaFertilidadBean.modoconsulta || espermogramaFertilidadBean.renderBasico}"/>
              <h:outputText value="%"/>
            </h:panelGroup>
            <a4j:outputPanel ajaxRendered="true">
                 <t:message for="txtCapInmovil" styleClass="errorMessage"/>
            </a4j:outputPanel>
            <h:panelGroup>          
              <h:inputText id="txtCapVitalidad" value="#{espermogramaFertilidadBean.capVivos}" required="true"
                   style="width:50px" disabled="#{espermogramaFertilidadBean.modoconsulta || espermogramaFertilidadBean.renderBasico}"/>
              <h:outputText value="%"/>
            </h:panelGroup>
            <a4j:outputPanel ajaxRendered="true">
                 <t:message for="txtCapVitalidad" styleClass="errorMessage"/>
            </a4j:outputPanel>
            </h:panelGrid>
            </s:fieldset>
        

          <s:fieldset legend="Muestra Posterior a Capacitaci�n" id="fieldCapacitada" styleClass="fieldset">
            <h:panelGrid columns="12" border="0" cellpadding="0" cellspacing="0" width="100%" id="panelPosCapacitacion"
                   rowClasses="labelText,labelTextInfo">
              <h:outputText value="Volumen"   styleClass="labelTextOblig"/>
              <h:outputText value=""/>
              <h:outputText value="Cantidad"   styleClass="labelTextOblig"/>
              <h:outputText value=""/>
              <h:outputText value="Movil Progresivo"   styleClass="labelTextOblig"/>
              <h:outputText value=""/>
              <h:outputText value="No Progresivos"   styleClass="labelTextOblig"/>
              <h:outputText value=""/>
              <h:outputText value="Inmovil"   styleClass="labelTextOblig"/>
              <h:outputText value=""/>
              <h:outputText value="Vitalidad"   styleClass="labelTextOblig"/>
              <h:outputText value=""/>
              <a4j:region renderRegionOnly="false">
              <h:inputText id="txtPosVolumen" value="#{espermogramaFertilidadBean.posVolumen}" 
                    required="#{espermogramaFertilidadBean.renderCapacitacion}" immediate="true"
                    onkeydown="return blockEnter(event);" valueChangeListener="#{espermogramaFertilidadBean.setPosVolumen}"
                   style="width:50px" disabled="#{espermogramaFertilidadBean.modoconsulta}">
                <a4j:support id="supportPosVolumen" event="onchange" immediate="true"
                          reRender="idRecuento" action="#{espermogramaFertilidadBean.setRecuentoPos}">
                  <a4j:ajaxListener type="org.ajax4jsf.ajax.ForceRender"/>
                </a4j:support>
              </h:inputText>     
              </a4j:region>
              <a4j:outputPanel ajaxRendered="true">
                 <t:message for="txtPosVolumen" styleClass="errorMessage"/>
              </a4j:outputPanel>
              <a4j:region renderRegionOnly="false">
              <h:inputText id="txtPosCantidad" value="#{espermogramaFertilidadBean.posCantidad}" 
                    required="#{espermogramaFertilidadBean.renderCapacitacion}" immediate="true"
                    onkeydown="return blockEnter(event);" valueChangeListener="#{espermogramaFertilidadBean.setPosCantidad}"
                   style="width:50px" disabled="#{espermogramaFertilidadBean.modoconsulta}">
                <a4j:support id="supportPosCantidad" event="onchange" immediate="true"
                          reRender="idRecuento" action="#{espermogramaFertilidadBean.setRecuentoPos}">
                  <a4j:ajaxListener type="org.ajax4jsf.ajax.ForceRender"/>
                </a4j:support>
              </h:inputText>     
              </a4j:region>
              <a4j:outputPanel ajaxRendered="true">
                 <t:message for="txtPosCantidad" styleClass="errorMessage"/>
              </a4j:outputPanel>
              <a4j:region renderRegionOnly="false">
              <h:panelGroup>          
                <h:inputText id="txtPosProgresivos" value="#{espermogramaFertilidadBean.posProgresivos}" 
                    required="#{espermogramaFertilidadBean.renderCapacitacion}" immediate="true"
                    onkeydown="return blockEnter(event);" valueChangeListener="#{espermogramaFertilidadBean.setPosProgresivos}"
                   style="width:50px" disabled="#{espermogramaFertilidadBean.modoconsulta}">
                  <a4j:support id="supportPosProgresivos" event="onchange" immediate="true"
                          reRender="idRecuento" action="#{espermogramaFertilidadBean.setRecuentoPos}">
                    <a4j:ajaxListener type="org.ajax4jsf.ajax.ForceRender"/>
                  </a4j:support>
                </h:inputText>     
                <h:outputText value="%"/>
              </h:panelGroup>
              </a4j:region>
              <a4j:outputPanel ajaxRendered="true">
                 <t:message for="txtPosProgresivos" styleClass="errorMessage"/>
              </a4j:outputPanel>
              <h:panelGroup>          
                <h:inputText id="txtPosNoprogre" value="#{espermogramaFertilidadBean.posPendulares}" required="true"
                   style="width:50px" disabled="#{espermogramaFertilidadBean.modoconsulta}"/>
                <h:outputText value="%"/>
              </h:panelGroup>
              <a4j:outputPanel ajaxRendered="true">
                 <t:message for="txtPosNoprogre" styleClass="errorMessage"/>
              </a4j:outputPanel>
              <h:panelGroup>          
                <h:inputText id="txtPosInmovil" value="#{espermogramaFertilidadBean.posInmoviles}" required="true"
                   style="width:50px" disabled="#{espermogramaFertilidadBean.modoconsulta}"/>
                <h:outputText value="%"/>
              </h:panelGroup>
              <a4j:outputPanel ajaxRendered="true">
                 <t:message for="txtPosInmovil" styleClass="errorMessage"/>
              </a4j:outputPanel>
              <h:panelGroup>          
                <h:inputText id="txtPosVitalidad" value="#{espermogramaFertilidadBean.posVivos}" required="true"
                   style="width:50px" disabled="#{espermogramaFertilidadBean.modoconsulta}"/>
                <h:outputText value="%"/>
              </h:panelGroup>
              <a4j:outputPanel ajaxRendered="true">
                 <t:message for="txtPosVitalidad" styleClass="errorMessage"/>
              </a4j:outputPanel>
            </h:panelGrid>

            <h:panelGrid columns="2" border="0" cellpadding="0" cellspacing="0" width="100%" id="panelObsCapacitacion"
                   rowClasses="labelText,labelTextInfo">
              <h:outputText value="Recuento Espermatozoides Moviles Totales"   styleClass="labelTextOblig"/>
              <h:outputText value=""/>
              <h:panelGroup id="idRecuento">
                 <h:outputText id="txtRecuento" value="#{espermogramaFertilidadBean.recuento} Millones" 
                       style="width:80px"/>
              </h:panelGroup>
              <a4j:outputPanel ajaxRendered="true">
                 <t:message for="txtRecuento" styleClass="errorMessage"/>
              </a4j:outputPanel>
              <h:outputText value="Observaciones Capacitaci�n" styleClass="labelTextOblig"/>
              <h:outputText value=""/>
              <h:inputTextarea id="textObsCapacitacion" value="#{espermogramaFertilidadBean.capObservaciones}"
                   style="width:500px;height:70px" disabled="#{espermogramaFertilidadBean.modoconsulta}"/>
              <a4j:outputPanel ajaxRendered="true">
                 <t:message for="textObsCapacitacion" styleClass="errorMessage"/>
              </a4j:outputPanel>
            </h:panelGrid>
          </s:fieldset>
        </h:panelGrid>
        </s:fieldset>
      
        <h:panelGrid columns="1" border="0" cellpadding="10" width="100%"
                 id="panelBotonesEspermograma" columnClasses="panelGridBotones">
          <h:panelGroup>
              <h:commandButton value="Aceptar" styleClass="btn btn btn-success" 
                           action="#{espermogramaFertilidadBean.guardar}">
                 <a4j:support event="onclick" status="statusButton"/> 
              </h:commandButton>
              <h:commandButton value="Siguiente" styleClass="btn btn btn-warning" 
                            rendered="#{espermogramaFertilidadBean.modoconsulta}"
                                 action="#{espermogramaFertilidadBean.siguiente}"/>


          </h:panelGroup>
          <h:panelGroup>
            <h:commandButton value="Cerrar Espermograma" styleClass="btn btn btn-success" onclick="if (!confirm(\'�Realmente desea Cerrar la Consulta\')) return false"
                             action="#{espermogramaFertilidadBean.cerrarEspermograma}" disabled="#{!espermogramaFertilidadBean.guardado}" rendered="#{!espermogramaFertilidadBean.modoconsulta}">
                 <a4j:support event="onclick" status="statusButton"/> 
            </h:commandButton>
          </h:panelGroup>
        </h:panelGrid>
     
      </s:fieldset>
    </t:panelTab>
    <h:panelGrid rendered="#{espermogramaFertilidadBean.generoEspermograma}" >
      <f:subview id="generarEspermograma" rendered="#{espermogramaFertilidadBean.generoEspermograma}">
        <f:verbatim>
          <script type="text/javascript" language="JavaScript">
           window.open("<%=request.getSession().getAttribute(PdfServlet.DOCUMENT_NAME_ATTRIBUTE_NAME)%>", "Documento" , "width=800,height=600");
          </script>
        </f:verbatim>
      </f:subview>
    </h:panelGrid>
  </t:panelTabbedPane>
  <script language="javascript" type="text/javascript">
        document.forms[1].elements[6].focus()
</script>
</h:panelGrid>
