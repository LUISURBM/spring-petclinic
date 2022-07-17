<%@ page contentType="text/html;charset=iso-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsf/html" prefix="h"%>
<%@ taglib uri="http://java.sun.com/jsf/core" prefix="f"%>
<%@ taglib uri="http://richfaces.org/a4j" prefix="a4j"%>
<%@ taglib uri="http://richfaces.org/rich" prefix="rich"%>
<%@ taglib uri="http://myfaces.apache.org/tomahawk" prefix="t"%>
<%@ taglib uri="http://myfaces.apache.org/sandbox" prefix="s"%>
<h:panelGrid columns="1" border="0" cellpadding="0" cellspacing="0" width="100%" id="panelGridIngresoCirugiaTab"
             styleClass="tabContainer">
  <jsp:include page="/pages/clinico/comunes/encabezadoDatosCirugia.jsp" flush="true"/>
  <h:panelGrid columns="1" border="0" cellpadding="0" cellspacing="0" width="100%" id="panelGridIngresoEnfermeriaTab"
               styleClass="tabContainer">
    <t:panelTabbedPane border="0" cellpadding="0" cellspacing="0" serverSideTabSwitch="false" activePanelTabVar="true"
                       width="100%" id="panelTabbedPaneIngresoEnfermeria" styleClass="tabbedPane"
                       activeTabStyleClass="activeTab" inactiveTabStyleClass="inactiveTab"
                       selectedIndex="#{ingresoCirugiaEnfermeria.selectedIndex}" disabledTabStyleClass="disabledTab"
                       activeSubStyleClass="activeSub" inactiveSubStyleClass="inactiveSub"
                       tabContentStyleClass="tabContent">
      <t:panelTab id="panelTabIngresoEnfermeria" label="#{ingresoCirugiaEnfermeria.legendIngresoEnfermeria}"
                  disabled="ingresoCirugiaEnfermeria.mostrarPreparacion}">
        <h:panelGrid columns="1" border="0" cellpadding="0" cellspacing="0" width="100%" id="panelGridIngresoEnfermeria"
                     styleClass="tabContainer">
          <s:fieldset legend="#{ingresoCirugiaEnfermeria.legendServicio}" id="fieldCirugiasIngreso" styleClass="fieldset">
            <h:panelGrid columns="2" border="0" cellpadding="0" cellspacing="0" width="100%" id="panelCirugiasIngreso"
                         rowClasses="labelText,labelTextInfo">
              <h:outputText value="#{ingresoCirugiaEnfermeria.legendTablaServicio}" styleClass="labelTextOblig"/>
              <h:outputText/>
            </h:panelGrid>
            <h:panelGrid columns="1" border="0" cellpadding="0"
                         rendered="#{not empty ingresoCirugiaEnfermeria.lstCirugias}" cellspacing="0" width="100%"
                         id="tableCirugiasProgramadasIngreso" styleClass="tabContainer">
              <t:buffer into="#{table}">
                <h:dataTable var="item" border="1" cellpadding="0" cellspacing="0"
                             binding="#{ingresoCirugiaEnfermeria.dtCirugias}"
                             value="#{ingresoCirugiaEnfermeria.lstCirugias}" rows="10" styleClass="standard_table"
                             rowClasses="standardTable_Row1,standardTable_Row2" footerClass="paginacion"
                             id="dtCirugiasProgramadas">
                  <h:column>
                    <f:facet name="header">
                      <h:outputText value="Codigo"/>
                    </f:facet>
                    <h:outputText value="#{item.csvccodigo}"/>
                  </h:column>
                  <h:column>
                    <f:facet name="header">
                      <h:outputText value="Nombre"/>
                    </f:facet>
                    <h:outputText value="#{item.csvcnombre}"/>
                  </h:column>
                  <h:column>
                    <f:facet name="header">
                      <h:outputText value="Estado"/>
                    </f:facet>
                    <h:outputText value="#{item.csvcestado}"/>
                  </h:column>
                </h:dataTable>
              </t:buffer>
              <t:buffer into="#{tableScroller}">
                <h:panelGrid columns="1" rowClasses="labelTextInfo,labelTextInfo">
                  <t:dataScroller id="scroll_1" for="dtCirugiasProgramadas" fastStep="10" pageCountVar="pageCount"
                                  pageIndexVar="pageIndex" styleClass="scroller" paginator="true" immediate="true"
                                  paginatorMaxPages="9" paginatorTableClass="paginator" renderFacetsIfSinglePage="false"
                                  paginatorActiveColumnStyle="font-weight:bold;">
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
          <s:fieldset legend="#{ingresoCirugiaEnfermeria.legendAdmision}" id="fieldPreparacionPreparatoria" styleClass="fieldset">
          
                 <a4j:region renderRegionOnly="false">
            <h:panelGrid columns="7">
              <h:outputText value="[ " style="font-size:8.0pt; font-weight:bold;"/>
              <a4j:commandLink style="font-size:8.0pt; font-weight:bold;" value=" Todos SI" immediate="true"
                               action="#{ingresoCirugiaEnfermeria.changeTodosSi}" reRender="panelGridIngresoEnfermeria"/>
              <h:outputText value=" | " style="font-size:8.0pt; font-weight:bold;"/>
              <a4j:commandLink style="font-size:8.0pt; font-weight:bold;" value="Todos NO " immediate="true"
                               action="#{ingresoCirugiaEnfermeria.changeTodosNo}" reRender="panelGridIngresoEnfermeria"/>
              <h:outputText value=" | " style="font-size:8.0pt; font-weight:bold;"/>
              <a4j:commandLink style="font-size:8.0pt; font-weight:bold;" value="Ninguno " immediate="true"
                               action="#{ingresoCirugiaEnfermeria.changeNinguno}" reRender="panelGridIngresoEnfermeria"/>
              <h:outputText value=" ]" style="font-size:8.0pt; font-weight:bold;"/>
            </h:panelGrid>
          </a4j:region>
          
            <h:panelGrid columns="8" border="0" cellpadding="0" cellspacing="0" width="100%"
                         rowClasses="labelText,labelTextInfo" id="panelIngresoEnfermeria">
         
              <h:outputText value="No Sala" styleClass="labelTextOblig" rendered="#{!ingresoCirugiaEnfermeria.notaEnfeProce}"/>
              <h:outputText value="" rendered="#{!ingresoCirugiaEnfermeria.notaEnfeProce}"/>
              <h:outputText value="" rendered="#{!ingresoCirugiaEnfermeria.notaEnfeProce}"/>
              <h:outputText value="" rendered="#{!ingresoCirugiaEnfermeria.notaEnfeProce}"/>
              <h:outputText value="" rendered="#{!ingresoCirugiaEnfermeria.notaEnfeProce}"/>
              <h:outputText value="" rendered="#{!ingresoCirugiaEnfermeria.notaEnfeProce}"/>
              <h:outputText value="" rendered="#{!ingresoCirugiaEnfermeria.notaEnfeProce}"/>
              <h:outputText value="" rendered="#{!ingresoCirugiaEnfermeria.notaEnfeProce}"/>    
              
              
             <h:selectOneMenu id="mnuSala" value="#{ingresoCirugiaEnfermeria.ingreso.sala}" styleClass="dropdown-toggle, input-medium" rendered="#{!ingresoCirugiaEnfermeria.notaEnfeProce}">
                <f:selectItems value="#{ingresoCirugiaEnfermeria.lstSalasCirugia}"/>
              </h:selectOneMenu>
              <a4j:outputPanel ajaxRendered="true" rendered="#{!ingresoCirugiaEnfermeria.notaEnfeProce}">
                <t:message for="mnuSala" styleClass="errorMessage"/>
              </a4j:outputPanel>
              <h:outputText value="" rendered="#{!ingresoCirugiaEnfermeria.notaEnfeProce}"/>
              <h:outputText value="" rendered="#{!ingresoCirugiaEnfermeria.notaEnfeProce}"/>
              <h:outputText value="" rendered="#{!ingresoCirugiaEnfermeria.notaEnfeProce}"/>
              <h:outputText value="" rendered="#{!ingresoCirugiaEnfermeria.notaEnfeProce}"/>
              <h:outputText value="" rendered="#{!ingresoCirugiaEnfermeria.notaEnfeProce}"/> 
              <h:outputText value="" rendered="#{!ingresoCirugiaEnfermeria.notaEnfeProce}"/>
                                                 
              <h:outputText value="El usuario confirma sitio y lado de la cirugía? " styleClass="labelTextOblig"  rendered="#{!ingresoCirugiaEnfermeria.notaEnfeProce}"/>
              <h:outputText value="" rendered="#{!ingresoCirugiaEnfermeria.notaEnfeProce}"/>
              <h:outputText value="" rendered="#{!ingresoCirugiaEnfermeria.notaEnfeProce}"/>
              <h:outputText value="" rendered="#{!ingresoCirugiaEnfermeria.notaEnfeProce}"/>
              <h:outputText value="" rendered="#{!ingresoCirugiaEnfermeria.notaEnfeProce}"/>
              <h:outputText value="" rendered="#{!ingresoCirugiaEnfermeria.notaEnfeProce}"/>
              <h:outputText value="" rendered="#{!ingresoCirugiaEnfermeria.notaEnfeProce}"/>
              <h:outputText value="" rendered="#{!ingresoCirugiaEnfermeria.notaEnfeProce}"/>
              
              
              <h:panelGroup style="border-style:none;font-size:10px" rendered="#{!ingresoCirugiaEnfermeria.notaEnfeProce}" >
                <a4j:region renderRegionOnly="false">
                  <h:selectOneRadio id="mnuConfirmaCirugia" required="false" immediate="true"
                                    value="#{ingresoCirugiaEnfermeria.ingreso.hiecconficirug}"
                                    binding="#{ingresoCirugiaEnfermeria.conficirug}"
                                    valueChangeListener="#{ingresoCirugiaEnfermeria.setHiecconficirug}">
                    <f:selectItems value="#{ingresoCirugiaEnfermeria.lstOpciones}"/>
                    <a4j:support id="supportmnuConfirmaCirugia" event="onclick" immediate="true"
                                 action="#{ingresoCirugiaEnfermeria.changeConfirma}"
                                 reRender="panelValida">
                      <a4j:ajaxListener type="org.ajax4jsf.ajax.ForceRender"/>
                    </a4j:support>
                  </h:selectOneRadio>
                </a4j:region>
              </h:panelGroup>
              
              <a4j:outputPanel ajaxRendered="true" rendered="#{!ingresoCirugiaEnfermeria.notaEnfeProce}">
                <t:message for="mnuConfirmaCirugia" styleClass="errorMessage"/>
              </a4j:outputPanel>
              <h:panelGroup id="panelValida">
                <h:outputText value="No olvide colocar la manilla color VERDE"
                              rendered="#{ingresoCirugiaEnfermeria.renderVerde}" style="color:green;"/>
                <h:outputText value="No olvide colocar la manilla color AZUL"
                              rendered="#{ingresoCirugiaEnfermeria.renderAzul}" style="color:blue;"/>
                <h:graphicImage url="/comun/imagenes/manilla-verde.png" width="70" height="70"
                                rendered="#{ingresoCirugiaEnfermeria.renderVerde}"/>
                <h:graphicImage url="/comun/imagenes/manilla-azul.png" width="70" height="70"
                                rendered="#{ingresoCirugiaEnfermeria.renderAzul}"/>
                <h:outputText value="Verifique con el usuario sitio y lado de la cirugía"
                              rendered="#{ingresoCirugiaEnfermeria.renderAlertaNoConfirma}" style="color:red;"/>
              </h:panelGroup>
              <h:outputText value="" rendered="#{!ingresoCirugiaEnfermeria.notaEnfeProce}"/>
              <h:outputText value="" rendered="#{!ingresoCirugiaEnfermeria.notaEnfeProce}"/>
              <h:outputText value="" rendered="#{!ingresoCirugiaEnfermeria.notaEnfeProce}"/>
              <h:outputText value="" rendered="#{!ingresoCirugiaEnfermeria.notaEnfeProce}"/>
              <h:outputText value="" rendered="#{!ingresoCirugiaEnfermeria.notaEnfeProce}"/>
                           
              <h:outputText value="El usuario confirma el procedimiento?" styleClass="labelTextOblig" rendered="#{ingresoCirugiaEnfermeria.notaEnfeProce}"/>
              <h:outputText value="" rendered="#{ingresoCirugiaEnfermeria.notaEnfeProce}"/>
              <h:outputText value="" rendered="#{ingresoCirugiaEnfermeria.notaEnfeProce}"/>
              <h:outputText value="" rendered="#{ingresoCirugiaEnfermeria.notaEnfeProce}"/>
              <h:outputText value="" rendered="#{ingresoCirugiaEnfermeria.notaEnfeProce}"/>
              <h:outputText value="" rendered="#{ingresoCirugiaEnfermeria.notaEnfeProce}"/>
              <h:outputText value="" rendered="#{ingresoCirugiaEnfermeria.notaEnfeProce}"/>
              <h:outputText value="" rendered="#{ingresoCirugiaEnfermeria.notaEnfeProce}"/>
              
              
              <h:panelGroup style="border-style:none;font-size:10px" rendered="#{ingresoCirugiaEnfermeria.notaEnfeProce}">
               <a4j:region renderRegionOnly="false">
                  <h:selectOneRadio id="mnuConfirmaProcedimiento" required="false" immediate="true"
                                    value="#{ingresoCirugiaEnfermeria.ingreso.hiecconfiproce}"
                                    binding="#{ingresoCirugiaEnfermeria.confiproce}"
                                    valueChangeListener="#{ingresoCirugiaEnfermeria.setHiecconfiproce}">
                    <f:selectItems value="#{ingresoCirugiaEnfermeria.lstOpciones}"/>
                    <a4j:support id="supportmnuConfirmaProcedimiento" event="onclick" immediate="true"
                                 action="#{ingresoCirugiaEnfermeria.changeConfirmaProcedimiento}"
                                 reRender="panelMensajeProcedimiento">
                      <a4j:ajaxListener type="org.ajax4jsf.ajax.ForceRender"/>
                    </a4j:support>
                  </h:selectOneRadio>
                </a4j:region>
              </h:panelGroup>
              <a4j:outputPanel ajaxRendered="true" rendered="#{ingresoCirugiaEnfermeria.notaEnfeProce}">
                <t:message for="mnuConfirmaProcedimiento" styleClass="errorMessage"/>
              </a4j:outputPanel>
              <h:panelGroup id="panelMensajeProcedimiento" rendered="#{ingresoCirugiaEnfermeria.notaEnfeProce}">
                <h:outputText value="Verifique con el usuario el procedimiento."
                              rendered="#{ingresoCirugiaEnfermeria.renderAlertaNoConfirmaProce}" style="color:red;"/>
              </h:panelGroup>
              <h:outputText value="" rendered="#{ingresoCirugiaEnfermeria.notaEnfeProce}"/>
              <h:outputText value="" rendered="#{ingresoCirugiaEnfermeria.notaEnfeProce}"/>
              <h:outputText value="" rendered="#{ingresoCirugiaEnfermeria.notaEnfeProce}"/>
              <h:outputText value="" rendered="#{ingresoCirugiaEnfermeria.notaEnfeProce}"/>
              <h:outputText value="" rendered="#{ingresoCirugiaEnfermeria.notaEnfeProce}"/>
              
              <h:outputText value="Verifica que el/los consentimiento/s informado/s esten diligenciado/s? "
                            styleClass="labelTextOblig"/>
              <h:outputText value=""/>
              <h:panelGroup id="lblcualcons">
              <h:outputText value="¿Cuál consentimiento se diligencia?" rendered="#{ingresoCirugiaEnfermeria.renderDatosConsentimiento}"/>
              </h:panelGroup>
               <h:outputText value=""/>
               <h:panelGroup id="lblpacautdat">
                <h:outputText value="¿El paciente autoriza el uso de los datos clínicos con fines de investigación científica?"   styleClass="labelTextOblig" rendered="#{ingresoCirugiaEnfermeria.renderDatosConsentimiento}"/>
              </h:panelGroup>
             
              <h:outputText value=""/>
              <h:outputText value=""/>
              <h:outputText value=""/>
              
              
              <a4j:region renderRegionOnly="false">
                <h:selectOneRadio id="mnuConsenInformado" required="false" immediate="true"
                                  value="#{ingresoCirugiaEnfermeria.ingreso.hiecconsinfor}"
                                  binding="#{ingresoCirugiaEnfermeria.consinfor}"
                                  valueChangeListener="#{ingresoCirugiaEnfermeria.setHiecconsinfor}">
                  <f:selectItems value="#{ingresoCirugiaEnfermeria.lstOpciones}"/>
                  <a4j:support id="supportConsenInformado" event="onclick" immediate="true"
                               action="#{ingresoCirugiaEnfermeria.changeConsentimiento}" reRender="panelConsentimiento,paneCualconse,lblcualcons,lblpacautdat,panelPacAutDat">
                    <a4j:ajaxListener type="org.ajax4jsf.ajax.ForceRender"/>
                  </a4j:support>
                </h:selectOneRadio>
              </a4j:region>
              <a4j:outputPanel ajaxRendered="true">
                <t:message for="mnuConsenInformado" styleClass="errorMessage"/>
              </a4j:outputPanel>
              <h:panelGroup id="paneCualconse">
                <h:inputTextarea id="cualconse" style="width:300px" value="#{ingresoCirugiaEnfermeria.ingreso.hieccualconse}" rendered="#{ingresoCirugiaEnfermeria.renderDatosConsentimiento}" >
                    <f:validateLength maximum="100"/>
                    </h:inputTextarea>
              </h:panelGroup>
               <a4j:outputPanel ajaxRendered="true">
                <t:message for="cualconse" styleClass="errorMessage"/>
              </a4j:outputPanel>
              <h:panelGroup id="panelPacAutDat">
                 <a4j:region renderRegionOnly="false">
                <h:selectOneRadio id="mnuPacAutDat" required="true" rendered="#{ingresoCirugiaEnfermeria.renderDatosConsentimiento}"
                                  value="#{ingresoCirugiaEnfermeria.ingreso.hieccpacautdat}">
                  <f:selectItems value="#{ingresoCirugiaEnfermeria.lstOpciones}"/>
                </h:selectOneRadio>
              </a4j:region>
              <a4j:outputPanel ajaxRendered="true">
                <t:message for="mnuPacAutDat" styleClass="errorMessage"/>
              </a4j:outputPanel>
              </h:panelGroup>
              <h:panelGroup id="panelConsentimiento">
                <h:outputText value="Recuerde diligenciar completamente el consentimiento informado antes de continuar con el paciente"
                              rendered="#{ingresoCirugiaEnfermeria.renderConsentimiento}" style="color:red;"/>
              </h:panelGroup>
            
             
              <h:outputText value=""/>
              <h:outputText value=""/>
 
                
              
               
              <h:panelGroup id="panelTextTieneDIU" rendered="#{!ingresoCirugiaEnfermeria.notaEnfeProce}">
                <h:outputText value="El paciente tiene DIU?" styleClass="labelTextOblig"
                              rendered="#{ingresoCirugiaEnfermeria.renderTieneDIU}"/>
              </h:panelGroup>
              <h:outputText value="" rendered="#{!ingresoCirugiaEnfermeria.notaEnfeProce}"/>
              <h:outputText value="" rendered="#{!ingresoCirugiaEnfermeria.notaEnfeProce}"/>
              <h:outputText value="" rendered="#{!ingresoCirugiaEnfermeria.notaEnfeProce}"/>
              <h:outputText value="" rendered="#{!ingresoCirugiaEnfermeria.notaEnfeProce}"/>
              <h:outputText value="" rendered="#{!ingresoCirugiaEnfermeria.notaEnfeProce}"/>
              <h:outputText value="" rendered="#{!ingresoCirugiaEnfermeria.notaEnfeProce}"/>
              <h:outputText value="" rendered="#{!ingresoCirugiaEnfermeria.notaEnfeProce}"/>
              
               <a4j:region renderRegionOnly="false" rendered="#{!ingresoCirugiaEnfermeria.notaEnfeProce}" >
              <h:selectOneRadio id="mnuTieneDIU" required="false" immediate="true"
                                  value="#{ingresoCirugiaEnfermeria.ingreso.hiectienediu}"
                                  binding="#{ingresoCirugiaEnfermeria.tienediu}"
                                  valueChangeListener="#{ingresoCirugiaEnfermeria.setHiectienediu}"
                                  rendered="#{ingresoCirugiaEnfermeria.renderTieneDIU}">
                  <f:selectItems value="#{ingresoCirugiaEnfermeria.lstOpciones}"/>
                </h:selectOneRadio>
                </a4j:region>
              <a4j:outputPanel ajaxRendered="true" rendered="#{!ingresoCirugiaEnfermeria.notaEnfeProce}">
                <t:message for="mnuTieneDIU" styleClass="errorMessage"/>
              </a4j:outputPanel>
              <h:outputText value="" rendered="#{!ingresoCirugiaEnfermeria.notaEnfeProce}"/>
              <h:outputText value="" rendered="#{!ingresoCirugiaEnfermeria.notaEnfeProce}"/>
              <h:outputText value="" rendered="#{!ingresoCirugiaEnfermeria.notaEnfeProce}"/>
              <h:outputText value="" rendered="#{!ingresoCirugiaEnfermeria.notaEnfeProce}"/>
              <h:outputText value="" rendered="#{!ingresoCirugiaEnfermeria.notaEnfeProce}"/>
              <h:outputText value="" rendered="#{!ingresoCirugiaEnfermeria.notaEnfeProce}"/>
              
              
              <h:outputText value="Requiere ayuno preoperatorio? " styleClass="labelTextOblig" rendered="#{!ingresoCirugiaEnfermeria.notaEnfeProce}" />
              <h:outputText value="" rendered="#{!ingresoCirugiaEnfermeria.notaEnfeProce}"  />
              <h:panelGroup id="panelVerificaAyuno" rendered="#{!ingresoCirugiaEnfermeria.notaEnfeProce}">
                <h:outputText value="Verifica ayuno preoperatorio?"
                              rendered="#{ingresoCirugiaEnfermeria.renderVerifiAyuno}" styleClass="labelTextOblig"/>
              </h:panelGroup>
              <h:outputText value=""  rendered="#{!ingresoCirugiaEnfermeria.notaEnfeProce}" />
              <h:panelGroup id="panelTextAyunoSolido" rendered="#{!ingresoCirugiaEnfermeria.notaEnfeProce}">
                <h:outputText value="Hace cuánto consumió el último sólido? "
                              rendered="#{ingresoCirugiaEnfermeria.renderAyuno}"/>
              </h:panelGroup>
                <h:outputText value="" rendered="#{!ingresoCirugiaEnfermeria.notaEnfeProce}" />
              <h:panelGroup id="panelTextAyunoLiquido" rendered="#{!ingresoCirugiaEnfermeria.notaEnfeProce}" >
                <h:outputText value="Hace cuánto consumió el último líquido? "
                              rendered="#{ingresoCirugiaEnfermeria.renderAyuno}"/>
              </h:panelGroup>
              <h:panelGroup id="panelTexTareaAyuno" rendered="#{!ingresoCirugiaEnfermeria.notaEnfeProce}">
                <h:outputText value="Observaciones Ayuno " styleClass="labelTextOblig"
                              rendered="#{ingresoCirugiaEnfermeria.renderAyuno}"/>
              </h:panelGroup>
               
             
              <h:panelGroup id="panelmnuAyunoPreopera" rendered="#{!ingresoCirugiaEnfermeria.notaEnfeProce}">
              <a4j:region renderRegionOnly="false" >
                <h:selectOneRadio id="mnuAyunoPreopera" required="false" immediate="true"
                                  value="#{ingresoCirugiaEnfermeria.ingreso.hiecverifayun}"
                                  binding="#{ingresoCirugiaEnfermeria.verifayun}"
                                  valueChangeListener="#{ingresoCirugiaEnfermeria.setHiecverifayun}"
                                  rendered="#{!ingresoCirugiaEnfermeria.notaEnfeProce}">
                  <f:selectItems value="#{ingresoCirugiaEnfermeria.lstOpciones}"/>
                  <a4j:support id="supportAyunoPreopera" event="onclick" immediate="true"
                               action="#{ingresoCirugiaEnfermeria.changeVerifica}"
                               reRender="selecVerifiAyuno,panelVerificaAyuno,panelTextAyunoSolido,panelAyunoSolido,itHorasAyunoSolido,panelTextAyunoLiquido,panelAyunoLiquido,itHorasAyunoLiquido,panelTexTareaAyuno,panelTextAreaAyunoLiquido,itTextAreaAyunoLiquido">
                    <a4j:ajaxListener type="org.ajax4jsf.ajax.ForceRender"/>
                  </a4j:support>
                </h:selectOneRadio>
              </a4j:region>
              </h:panelGroup>
              <a4j:outputPanel ajaxRendered="true" rendered="#{!ingresoCirugiaEnfermeria.notaEnfeProce}">
                <t:message for="mnuAyunoPreopera" styleClass="errorMessage"/>
              </a4j:outputPanel>
              <t:popup styleClass="popup" closePopupOnExitingElement="true" closePopupOnExitingPopup="true"
                       displayAtDistanceX="110" displayAtDistanceY="2" rendered="#{!ingresoCirugiaEnfermeria.notaEnfeProce}">
                <h:panelGroup id="selecVerifiAyuno" rendered="#{!ingresoCirugiaEnfermeria.notaEnfeProce}">
                  <h:selectOneRadio id="mnuAyunoPreoper" required="false" immediate="true"
                                    rendered="#{ingresoCirugiaEnfermeria.renderVerifiAyuno}"
                                    value="#{ingresoCirugiaEnfermeria.ingreso.hiecayunopre}"
                                    valueChangeListener="#{ingresoCirugiaEnfermeria.setHiecayunopre}">
                    <f:selectItems value="#{ingresoCirugiaEnfermeria.lstOpciones}"/>
                    <a4j:support id="supportAyunoPreope" event="onclick" immediate="true"
                                 action="#{ingresoCirugiaEnfermeria.changeAyuno}"
                                 reRender="selecVerifiAyuno,panelVerificaAyuno,panelTextAyunoSolido,panelAyunoSolido,itHorasAyunoSolido,panelTextAyunoLiquido,panelAyunoLiquido,itHorasAyunoLiquido,panelTexTareaAyuno,panelTextAreaAyunoLiquido,itTextAreaAyunoLiquido">
                      <a4j:ajaxListener type="org.ajax4jsf.ajax.ForceRender"/>
                    </a4j:support>
                  </h:selectOneRadio>
                </h:panelGroup>
                <f:facet name="popup">
                  <h:panelGroup>
                    <h:panelGrid columns="2">
                      <h:graphicImage url="/comun/imagenes/doctorPausaAyuno.jpg" alt="doctorPausa" width="400"
                                      height="340"/>
                    </h:panelGrid>
                  </h:panelGroup>
                </f:facet>
              </t:popup>
              
            <h:outputText value="" rendered="#{!ingresoCirugiaEnfermeria.notaEnfeProce}"/>
              <h:panelGroup id="panelAyunoSolido" rendered="#{!ingresoCirugiaEnfermeria.notaEnfeProce}">
                <h:inputText id="itHorasAyunoSolido" style="width:50px" maxlength="2"
                             value="#{ingresoCirugiaEnfermeria.ingreso.hienayunosolid}"
                             rendered="#{ingresoCirugiaEnfermeria.renderAyuno}"/>
                <h:outputText value=" Horas" rendered="#{ingresoCirugiaEnfermeria.renderAyuno}"/>
              </h:panelGroup>
             <h:panelGroup rendered="#{!ingresoCirugiaEnfermeria.notaEnfeProce}">
                <a4j:outputPanel ajaxRendered="true" >
                    <t:message for="itHorasAyunoSolido" styleClass="errorMessage"/>
                </a4j:outputPanel>
             </h:panelGroup>
            <h:panelGroup id="panelAyunoLiquido" rendered="#{!ingresoCirugiaEnfermeria.notaEnfeProce}">
                <h:inputText id="itHorasAyunoLiquido" style="width:50px" maxlength="2"
                             value="#{ingresoCirugiaEnfermeria.ingreso.hienayunoliqui}"
                             rendered="#{ingresoCirugiaEnfermeria.renderAyuno}"/>
                <h:outputText value=" Horas" rendered="#{ingresoCirugiaEnfermeria.renderAyuno}"/>
                <h:panelGroup>
                  <a4j:outputPanel ajaxRendered="true">
                    <t:message for="itHorasAyunoLiquido" styleClass="errorMessage"/>
                  </a4j:outputPanel>
                </h:panelGroup>
              </h:panelGroup>
              
            <h:panelGroup id="panelTextAreaAyunoLiquido" rendered="#{!ingresoCirugiaEnfermeria.notaEnfeProce}">
                <h:inputTextarea id="itTextAreaAyunoLiquido" style="width:150px"
                                 value="#{ingresoCirugiaEnfermeria.ingreso.hiecobserayu}"
                                 rendered="#{ingresoCirugiaEnfermeria.renderAyuno}"/>
                <a4j:outputPanel ajaxRendered="true" >
                  <t:message for="itTextAreaAyunoLiquido" styleClass="errorMessage"/>
                </a4j:outputPanel>
              </h:panelGroup>

              <h:outputText value="Tiene antecedentes patológicos? " styleClass="labelTextOblig"/>
              <h:outputText value=""/>
              <h:panelGroup id="panelTextCualPatologico">
                <h:outputText value="Cuales?" styleClass="labelTextOblig"
                              rendered="#{ingresoCirugiaEnfermeria.mostrarPatologico}"/>
              </h:panelGroup>
              <h:outputText value=""/>
              <h:outputText value=""/>
              <h:outputText value=""/>
              <h:outputText value=""/>
              <h:outputText value=""/>
              <a4j:region renderRegionOnly="false">
                <h:selectOneRadio id="mnuPatologico" immediate="true" required="false"
                                  value="#{ingresoCirugiaEnfermeria.ingreso.hiecantepatol}"
                                  binding="#{ingresoCirugiaEnfermeria.antepatol}"
                                  valueChangeListener="#{ingresoCirugiaEnfermeria.setHiecantepatol}">
                  <f:selectItems value="#{ingresoCirugiaEnfermeria.lstOpciones}"/>
                  <a4j:support id="supportmnuPatologico" event="onclick" immediate="true"
                               action="#{ingresoCirugiaEnfermeria.changePatologico}"
                               reRender="panelInputPatologico,panelTextCualPatologico">
                    <a4j:ajaxListener type="org.ajax4jsf.ajax.ForceRender"/>
                  </a4j:support>
                </h:selectOneRadio>
              </a4j:region>
              <a4j:outputPanel ajaxRendered="true">
                <t:message for="mnuPatologico" styleClass="errorMessage"/>
              </a4j:outputPanel>
              <h:panelGroup id="panelInputPatologico">
                <h:inputTextarea id="textCualPatologico" required="false"
                                 rendered="#{ingresoCirugiaEnfermeria.mostrarPatologico}"
                                 value="#{ingresoCirugiaEnfermeria.ingreso.hieccualpatol}" style="width:300px"/>
              </h:panelGroup>
              <a4j:outputPanel ajaxRendered="true">
                <t:message for="textCualPatologico" styleClass="errorMessage"/>
              </a4j:outputPanel>
              <h:outputText value=""/>
              <h:outputText value=""/>
              <h:outputText value=""/>
              <h:outputText value=""/>
              <h:outputText value="Tiene antecedentes toxicoalérgicos? " styleClass="labelTextOblig"/>
              <h:outputText value=""/>
              <h:panelGroup id="panelTextCualToxico">
                <h:outputText value="Cuales?" styleClass="labelTextOblig"
                              rendered="#{ingresoCirugiaEnfermeria.mostrarToxico}"/>
              </h:panelGroup>
              <h:outputText value=""/>
              <h:outputText value=""/>
              <h:outputText value=""/>
              <h:outputText value=""/>
              <h:outputText value=""/>
              <a4j:region renderRegionOnly="false">
                <h:selectOneRadio id="mnuToxico" immediate="true" required="false"
                                  value="#{ingresoCirugiaEnfermeria.ingreso.hiecantetoxic}"
                                   binding="#{ingresoCirugiaEnfermeria.antetoxic}"
                                  valueChangeListener="#{ingresoCirugiaEnfermeria.setHiecantetoxic}">
                  <f:selectItems value="#{ingresoCirugiaEnfermeria.lstOpciones}"/>
                  <a4j:support id="supportmnuToxico" event="onclick" immediate="true"
                               action="#{ingresoCirugiaEnfermeria.changeToxico}"
                               reRender="panelInputToxico,panelTextCualToxico,panelValidaToxico">
                    <a4j:ajaxListener type="org.ajax4jsf.ajax.ForceRender"/>
                  </a4j:support>
                </h:selectOneRadio>
              </a4j:region>
              <a4j:outputPanel ajaxRendered="true">
                <t:message for="mnuToxico" styleClass="errorMessage"/>
              </a4j:outputPanel>
              <h:panelGroup id="panelInputToxico">
                <h:inputTextarea id="textCualToxico" required="true"
                                 rendered="#{ingresoCirugiaEnfermeria.mostrarToxico}"
                                 value="#{ingresoCirugiaEnfermeria.ingreso.hieccualtoxic}" style="width:300px"/>
              </h:panelGroup>
              <a4j:outputPanel ajaxRendered="true">
                <t:message for="textCualToxico" styleClass="errorMessage"/>
              </a4j:outputPanel>
              <h:panelGroup id="panelValidaToxico">
                <h:outputText value="No olvide colocar la manilla color ROJO"
                              rendered="#{ingresoCirugiaEnfermeria.renderRojo}" style="color:red;"/>
                <h:graphicImage url="/comun/imagenes/manilla-roja.png" width="70" height="70"
                                rendered="#{ingresoCirugiaEnfermeria.renderRojo}"/>
              </h:panelGroup>
              <h:outputText value=""/>
              <h:outputText value=""/>
              <h:outputText value=""/>
              <h:outputText value="Está tomando en la actualidad algún medicamento? " styleClass="labelTextOblig"/>
              <h:outputText value=""/>
              <h:panelGroup id="panelTextCualPremedicacion">
                <h:outputText value="Cuales y hace cuantas horas los tomo?" styleClass="labelTextOblig"
                              rendered="#{ingresoCirugiaEnfermeria.mostrarPremedicacion}"/>
              </h:panelGroup>
              <h:outputText value=""/>
              <h:panelGroup id="panelTextCuantasHorasPremedicacion">
                <h:outputText/>
              </h:panelGroup>
              <h:outputText value=""/>
              <h:outputText value=""/>
              <h:outputText value=""/>
              <a4j:region renderRegionOnly="false">
                <h:selectOneRadio id="mnuPremedicacion" immediate="true"
                                  value="#{ingresoCirugiaEnfermeria.ingreso.hiecpremedicac}"
                                  binding="#{ingresoCirugiaEnfermeria.premedicac}"
                                  valueChangeListener="#{ingresoCirugiaEnfermeria.setHiecpremedicac}">
                  <f:selectItems value="#{ingresoCirugiaEnfermeria.lstOpciones}"/>
                  <a4j:support id="supportmnuPremedicacion" event="onclick" immediate="true"
                               action="#{ingresoCirugiaEnfermeria.changePremedicacion}"
                               reRender="panelTextPremedicacion,panelInputPremedicacion,panelTextCualPremedicacion,panelTextCuantasHorasPremedicacion">
                    <a4j:ajaxListener type="org.ajax4jsf.ajax.ForceRender"/>
                  </a4j:support>
                </h:selectOneRadio>
              </a4j:region>
              <a4j:outputPanel ajaxRendered="true">
                <t:message for="mnuPremedicacion" styleClass="errorMessage"/>
              </a4j:outputPanel>
              <h:panelGroup id="panelInputPremedicacion">
                <h:inputTextarea id="textCualPremedicacion" immediate="true"
                                 rendered="#{ingresoCirugiaEnfermeria.mostrarPremedicacion}"
                                 value="#{ingresoCirugiaEnfermeria.ingreso.hieccualpremed}" style="width:300px"/>
              </h:panelGroup>
              <a4j:outputPanel ajaxRendered="true">
                <t:message for="textCualPremedicacion" styleClass="errorMessage"/>
              </a4j:outputPanel>
              <h:panelGroup id="itHorasPremedicacion">
                <h:outputText/>
              </h:panelGroup>
              <a4j:outputPanel ajaxRendered="true">
                <t:message for="itHorasPremedicacion" styleClass="errorMessage"/>
              </a4j:outputPanel>
              <h:outputText value=""/>
              <h:outputText value=""/>
              <h:outputText value="Se retira, maquillaje, protesis removible, lentes de contacto, anteojos, joyas u objetos de valor? "
                            styleClass="labelTextOblig" rendered="#{!ingresoCirugiaEnfermeria.notaEnfeProce}"/>
              <h:outputText value="" rendered="#{!ingresoCirugiaEnfermeria.notaEnfeProce}"/>
              <h:panelGroup id="panelTextJoyas" rendered="#{!ingresoCirugiaEnfermeria.notaEnfeProce}">
                <h:outputText value="Custodia a cargo de" styleClass="labelTextOblig"
                              rendered="#{ingresoCirugiaEnfermeria.renderJoyas && !ingresoCirugiaEnfermeria.notaEnfeProce}"/>
              </h:panelGroup>
              <h:outputText value="" rendered="#{!ingresoCirugiaEnfermeria.notaEnfeProce}"/>
              <h:outputText value="" rendered="#{!ingresoCirugiaEnfermeria.notaEnfeProce}"/>
              <h:outputText value="" rendered="#{!ingresoCirugiaEnfermeria.notaEnfeProce}"/>
              <h:outputText value="" rendered="#{!ingresoCirugiaEnfermeria.notaEnfeProce}"/>
              <h:outputText value="" rendered="#{!ingresoCirugiaEnfermeria.notaEnfeProce}"/>
              
              <a4j:region renderRegionOnly="false" rendered="#{!ingresoCirugiaEnfermeria.notaEnfeProce}">
                <h:selectOneRadio id="mnuJoyas" immediate="true"
                                  value="#{ingresoCirugiaEnfermeria.ingreso.hiecobjetvalor}"
                                  binding="#{ingresoCirugiaEnfermeria.objetvalor}"
                                  valueChangeListener="#{ingresoCirugiaEnfermeria.setHiecobjetvalor}">
                  <f:selectItems value="#{ingresoCirugiaEnfermeria.lstOpciones}"/>
                  <a4j:support id="supportmnuJoyas" event="onclick" immediate="true"
                               action="#{ingresoCirugiaEnfermeria.changeJoyas}"
                               reRender="panelTextJoyas,panelMenuJoyas">
                    <a4j:ajaxListener type="org.ajax4jsf.ajax.ForceRender"/>
                  </a4j:support>
                </h:selectOneRadio>
              </a4j:region>
              <a4j:outputPanel ajaxRendered="true" rendered="#{!ingresoCirugiaEnfermeria.notaEnfeProce}">
                <t:message for="mnuJoyas" styleClass="errorMessage"/>
              </a4j:outputPanel>
              <h:panelGroup id="panelMenuJoyas" rendered="#{!ingresoCirugiaEnfermeria.notaEnfeProce}">
                <h:selectOneMenu id="mnuCustodiaJoyas" immediate="true"
                                 rendered="#{ingresoCirugiaEnfermeria.renderJoyas && !ingresoCirugiaEnfermeria.notaEnfeProce}"
                                 value="#{ingresoCirugiaEnfermeria.ingreso.hiecentreobjec}">
                  <f:selectItems value="#{ingresoCirugiaEnfermeria.lstEntrega}"/>
                </h:selectOneMenu>
                <h:outputText rendered="#{ingresoCirugiaEnfermeria.renderElementos && !ingresoCirugiaEnfermeria.notaEnfeProce}"
                              value="Verifique el retiro de estos elementos antes de ingresar al quirofano"
                              style="color:red"/>
              </h:panelGroup>
              <a4j:outputPanel ajaxRendered="true" rendered="#{!ingresoCirugiaEnfermeria.notaEnfeProce}">
                <t:message for="mnuCustodiaJoyas" styleClass="errorMessage"/>
              </a4j:outputPanel>
              <h:outputText value="" rendered="#{!ingresoCirugiaEnfermeria.notaEnfeProce}"/>
              <h:outputText value="" rendered="#{!ingresoCirugiaEnfermeria.notaEnfeProce}"/>
              <h:outputText value="" rendered="#{!ingresoCirugiaEnfermeria.notaEnfeProce}"/>
              <h:outputText value="" rendered="#{!ingresoCirugiaEnfermeria.notaEnfeProce}"/>
              
              <h:outputText value="La zona a intervenir esta rasurada?" styleClass="labelTextOblig" rendered="#{!ingresoCirugiaEnfermeria.notaEnfeProce}"/>
              <h:outputText value="" rendered="#{!ingresoCirugiaEnfermeria.notaEnfeProce}"/>
              <h:outputText value="" rendered="#{!ingresoCirugiaEnfermeria.notaEnfeProce}"/>
              <h:outputText value="" rendered="#{!ingresoCirugiaEnfermeria.notaEnfeProce}"/>
              <h:outputText value="" rendered="#{!ingresoCirugiaEnfermeria.notaEnfeProce}"/>
              <h:outputText value="" rendered="#{!ingresoCirugiaEnfermeria.notaEnfeProce}"/>
              <h:outputText value="" rendered="#{!ingresoCirugiaEnfermeria.notaEnfeProce}"/>
              <h:outputText value="" rendered="#{!ingresoCirugiaEnfermeria.notaEnfeProce}"/>
              <a4j:region renderRegionOnly="false" rendered="#{!ingresoCirugiaEnfermeria.notaEnfeProce}">
                <h:selectOneRadio id="mnuRasurada" immediate="true"
                                  value="#{ingresoCirugiaEnfermeria.ingreso.hiecarearasur}"
                                  binding="#{ingresoCirugiaEnfermeria.arearasur}"
                                  valueChangeListener="#{ingresoCirugiaEnfermeria.setHiecarearasur}">
                  <f:selectItems value="#{ingresoCirugiaEnfermeria.lstOpciones}"/>
                  <a4j:support id="supportmnuRasura" event="onclick" immediate="true"
                               action="#{ingresoCirugiaEnfermeria.changeRasura}" reRender="panelRasura">
                    <a4j:ajaxListener type="org.ajax4jsf.ajax.ForceRender"/>
                  </a4j:support>
                </h:selectOneRadio>
              </a4j:region>
              <h:outputText value="" rendered="#{!ingresoCirugiaEnfermeria.notaEnfeProce}"/>
              <h:panelGroup id="panelRasura" rendered="#{!ingresoCirugiaEnfermeria.notaEnfeProce}">
                <h:outputText value="Verifique si es necesario RASURAR"
                              rendered="#{ingresoCirugiaEnfermeria.renderRasura}" style="color:blue;"/>
              </h:panelGroup>
              <h:outputText value="" rendered="#{!ingresoCirugiaEnfermeria.notaEnfeProce}"/>
              <h:outputText value="" rendered="#{!ingresoCirugiaEnfermeria.notaEnfeProce}"/>
              <h:outputText value="" rendered="#{!ingresoCirugiaEnfermeria.notaEnfeProce}"/>
              <h:outputText value="" rendered="#{!ingresoCirugiaEnfermeria.notaEnfeProce}"/>
              <h:outputText value="" rendered="#{!ingresoCirugiaEnfermeria.notaEnfeProce}"/>
              <h:outputText value="Requiere profilaxis antitrombótica? (Medias de compresión elástica y/o Anticoagulantes) "
                            styleClass="labelTextOblig" rendered="#{!ingresoCirugiaEnfermeria.notaEnfeProce}"/>
              <h:outputText value="" rendered="#{!ingresoCirugiaEnfermeria.notaEnfeProce}"/>
              <h:outputText value="" rendered="#{!ingresoCirugiaEnfermeria.notaEnfeProce}"/>
              <h:outputText value="" rendered="#{!ingresoCirugiaEnfermeria.notaEnfeProce}"/>
              <h:outputText value="" rendered="#{!ingresoCirugiaEnfermeria.notaEnfeProce}"/>
              <h:outputText value="" rendered="#{!ingresoCirugiaEnfermeria.notaEnfeProce}"/>
              <h:outputText value="" rendered="#{!ingresoCirugiaEnfermeria.notaEnfeProce}"/>
              <h:outputText value="" rendered="#{!ingresoCirugiaEnfermeria.notaEnfeProce}"/>
              <h:panelGroup id="camaElastica" rendered="#{!ingresoCirugiaEnfermeria.notaEnfeProce}">
              <h:selectOneRadio id="mnuCompresionElastica" immediate="true"
                                value="#{ingresoCirugiaEnfermeria.ingreso.hieccomprelast}"
                                 binding="#{ingresoCirugiaEnfermeria.comprelast}"
                                valueChangeListener="#{ingresoCirugiaEnfermeria.setHieccomprelast}">
                <f:selectItems value="#{ingresoCirugiaEnfermeria.lstOpciones}"/>
                <a4j:support id="supportmnuMedias" event="onclick" immediate="true"
                             action="#{ingresoCirugiaEnfermeria.changeMedias}" reRender="panelMedias">
                  <a4j:ajaxListener type="org.ajax4jsf.ajax.ForceRender"/>
                </a4j:support>
              </h:selectOneRadio>
              </h:panelGroup>
              <a4j:outputPanel ajaxRendered="true" rendered="#{!ingresoCirugiaEnfermeria.notaEnfeProce}" >
                <t:message for="mnuCompresionElastica" styleClass="errorMessage"/>
              </a4j:outputPanel>
              <h:outputText value="" rendered="#{!ingresoCirugiaEnfermeria.notaEnfeProce}"/>
              <h:panelGroup id="panelMedias" rendered="#{!ingresoCirugiaEnfermeria.notaEnfeProce}">
                <h:outputText value="Recuerde colocar medias de compresion elastica, o anticoagulantes según orden medica"
                              rendered="#{ingresoCirugiaEnfermeria.renderMedias}" style="color:blue;"/>
              </h:panelGroup>
              <h:outputText value="" rendered="#{!ingresoCirugiaEnfermeria.notaEnfeProce}"/>
              <h:outputText value="" rendered="#{!ingresoCirugiaEnfermeria.notaEnfeProce}"/>
              <h:outputText value="" rendered="#{!ingresoCirugiaEnfermeria.notaEnfeProce}"/>
              <h:outputText value="" rendered="#{!ingresoCirugiaEnfermeria.notaEnfeProce}"/>
              
              <h:outputText value="Autoriza ser contactada telefónicamente después de la cirugía para verificar su evolución? "
                            styleClass="labelTextOblig" rendered="#{!ingresoCirugiaEnfermeria.notaEnfeProce}"/>
              <h:outputText value="Autoriza ser contactada telefónicamente después del procedimiento para verificar su evolución?  "
                            styleClass="labelTextOblig" rendered="#{ingresoCirugiaEnfermeria.notaEnfeProce}" />              
              <h:outputText value=""/>
              <h:outputText value=""/>
              <h:panelGroup id="panelTextContacto">
                <h:outputText value="Telefono Celular Contacto" rendered="#{ingresoCirugiaEnfermeria.renderContacto}"
                              styleClass="labelTextOblig"/>
              </h:panelGroup>
              <h:outputText value=""/>
              <h:panelGroup id="panelTextContacto2">
                <h:outputText value="Telefono Fijo Contacto" rendered="#{ingresoCirugiaEnfermeria.renderContacto}"
                              styleClass="labelTextOblig"/>
              </h:panelGroup>
              <h:outputText value=""/>
              <h:outputText value=""/>
              <h:selectOneRadio id="mnuContactoTelefono" immediate="true"
                                value="#{ingresoCirugiaEnfermeria.ingreso.hiecautocntel}"
                                 binding="#{ingresoCirugiaEnfermeria.autocntel}"
                                valueChangeListener="#{ingresoCirugiaEnfermeria.setHiecautocntel}">
                <f:selectItems value="#{ingresoCirugiaEnfermeria.lstOpciones}"/>
                <a4j:support id="supportmnuContacto" event="onclick" immediate="true"
                             action="#{ingresoCirugiaEnfermeria.changeContacto}"
                             reRender="panelContacto, panelTextContacto2, panelTextContacto,panelContacto2">
                  <a4j:ajaxListener type="org.ajax4jsf.ajax.ForceRender"/>
                </a4j:support>
              </h:selectOneRadio>
              <a4j:outputPanel ajaxRendered="true">
                <t:message for="mnuContactoTelefono" styleClass="errorMessage"/>
              </a4j:outputPanel>
              <h:outputText value=""/>
              <h:panelGroup id="panelContacto">
                <h:inputText value="#{ingresoCirugiaEnfermeria.cirugia.hcplusuario.husccelular}"
                             rendered="#{ingresoCirugiaEnfermeria.renderContacto}"/>
              </h:panelGroup>
              <h:outputText value=""/>
              <h:panelGroup id="panelContacto2">
                <h:inputText value="#{ingresoCirugiaEnfermeria.cirugia.hcplusuario.husctelefono}"
                             rendered="#{ingresoCirugiaEnfermeria.renderContacto}"/>
              </h:panelGroup>
              <h:outputText value=""/>
              <h:outputText value=""/>
              <h:panelGrid rendered="#{ingresoCirugiaEnfermeria.renderLigadura}">
              <s:fieldset legend="PRUEBA DE EMBARAZO EN ORINA sensible a 10 mUI/mL de HCG" >
                <h:panelGrid columns="8">
 
 
                
                  <h:outputText value="Se realizo prueba de embarazo? " styleClass="labelTextOblig"/>
                  <h:outputText value=""/>
                  <h:outputText value=""/>
                  <h:panelGroup id="panelTextPruebaEmb">
                    <h:outputText value="Fecha de la Toma" styleClass="labelTextOblig"
                              rendered="#{ingresoCirugiaEnfermeria.mostrarPruebaEmb}"/>
                  </h:panelGroup>
                  <h:outputText value=""/>
                  <h:panelGroup id="panelTextResPruebaEmb">
                    <h:outputText value="Resultado Prueba: " styleClass="labelTextOblig"
                              rendered="#{ingresoCirugiaEnfermeria.mostrarPruebaEmb}"/>
                  </h:panelGroup>
                  <h:outputText value=""/>
                  <h:outputText value=""/>
                  <a4j:region renderRegionOnly="false">
                  <h:selectOneRadio id="mnuPruebaEmb" required="true" immediate="true"
                                  value="#{ingresoCirugiaEnfermeria.pruebaEmbarazo}"
                                  binding="#{ingresoCirugiaEnfermeria.pruebaEmb}"
                                  valueChangeListener="#{ingresoCirugiaEnfermeria.setPruebaEmbarazo}">
                     <f:selectItems value="#{ingresoCirugiaEnfermeria.lstOpciones}"/>
                     <a4j:support id="supportmnuPruebaEmb" event="onclick" immediate="true"
                                  action="#{ingresoCirugiaEnfermeria.changePruebaEmb}"
                                  reRender="panelTextPruebaEmb,panelTextResPruebaEmb,panelTextFechaPrueba,panelTextResPrueba">
                       <a4j:ajaxListener type="org.ajax4jsf.ajax.ForceRender"/>
                     </a4j:support>
                  </h:selectOneRadio>
                  </a4j:region>
                  <a4j:outputPanel ajaxRendered="true">
                  <t:message for="mnuPruebaEmb" styleClass="errorMessage"/>
                  </a4j:outputPanel>
                  <h:outputText value=""/>
                  <h:panelGroup id="panelTextFechaPrueba">
                  <h:panelGrid columns="2">
                    <t:inputCalendar id="fechaInicialPrueba" monthYearRowClass="yearMonthHeader"
                                     title="Formato: dd/mm/yyyy" styleClass="input-small" weekRowClass="weekHeader"
                                     currentDayCellClass="currentDayCell" popupDateFormat="dd/MM/yyyy"
                                     renderAsPopup="true" value="#{ingresoCirugiaEnfermeria.ingreso.hiedfechapremb}"
                                     valueChangeListener="#{ingresoCirugiaEnfermeria.setFechaActual}"
                                     popupTodayString="Hoy" popupWeekString="Semana" popupButtonString="Fecha"
                                     readonly="false" maxlength="11" size="11"
                                     popupButtonImageUrl="/comun/imagenes/ico_calendario2.gif"
                                     renderPopupButtonAsImage="true" align="top"
                                     rendered="#{ingresoCirugiaEnfermeria.mostrarPruebaEmb}">
                      <f:validator validatorId="dateValidatorEmbarazoCirugia"/>
                      <a4j:support id="supportFechaInicialPrueba" event="onchange" reRender="panelTabIngresoEnfermeria">
                        <a4j:ajaxListener type="org.ajax4jsf.ajax.ForceRender"/>
                      </a4j:support>
                    </t:inputCalendar>
                    <a4j:outputPanel ajaxRendered="true">
                      <t:message for="fechaInicialPrueba" styleClass="errorMessage"/>
                    </a4j:outputPanel>
                  </h:panelGrid>
                  </h:panelGroup>
                  <h:outputText value=""/>
                  <h:panelGroup id="panelTextResPrueba">
                  <h:selectOneRadio id="mnuResultadoPrueba" immediate="true"
                                    value="#{ingresoCirugiaEnfermeria.ingreso.hiecresulpruemb}"
                                    binding="#{ingresoCirugiaEnfermeria.resulPEmb}"
                                    valueChangeListener="#{ingresoCirugiaEnfermeria.setHiecresulpruemb}"
                                    rendered="#{ingresoCirugiaEnfermeria.mostrarPruebaEmb}">
                    <f:selectItems value="#{ingresoCirugiaEnfermeria.lstOpcionesEmbarazo}"/>
                    <a4j:support id="supportmnuResultadoPrueba" event="onclick" immediate="true" reRender="panelMedias" action="#{ingresoCirugiaEnfermeria.changeEmbarazo}">
                      <a4j:ajaxListener type="org.ajax4jsf.ajax.ForceRender"/>
                    </a4j:support>
                  </h:selectOneRadio>
                  <a4j:outputPanel ajaxRendered="true">
                    <t:message for="supportmnuResultadoPrueba" styleClass="errorMessage"/>
                  </a4j:outputPanel>
                  </h:panelGroup>
                </h:panelGrid>
              </s:fieldset>
              </h:panelGrid>
            </h:panelGrid>
          </s:fieldset>
          <h:panelGrid columns="1" border="0" cellpadding="0" cellspacing="0" width="100%" id="panelBotonesProgramacion"
                       columnClasses="panelGridBotones">
            <h:panelGroup>
              <h:commandButton value="Siguiente" styleClass="btn btn btn-success"
                               action="#{ingresoCirugiaEnfermeria.IngresoEnfermeria}"/>
            </h:panelGroup>
          </h:panelGrid>
          <h:panelGrid></h:panelGrid>
          <h:panelGrid>
            <h:panelGroup>
              <a4j:outputPanel id="ajaxRegionIngresoEnfermeriaMsg" ajaxRendered="true">
                <t:messages id="msgIngresoEnfermeriaMsg" showSummary="true" errorClass="error" globalOnly="true"
                            layout="table" infoClass="informacion"/>
              </a4j:outputPanel>
            </h:panelGroup>
          </h:panelGrid>
        </h:panelGrid>
      </t:panelTab>
    </t:panelTabbedPane>
  </h:panelGrid>
</h:panelGrid>