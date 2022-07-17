<%@ page contentType="text/html;charset=iso-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsf/html" prefix="h"%>
<%@ taglib uri="http://java.sun.com/jsf/core" prefix="f"%>
<%@ taglib uri="http://richfaces.org/a4j" prefix="a4j"%>
<%@ taglib uri="http://myfaces.apache.org/tomahawk" prefix="t"%>
<%@ taglib uri="http://myfaces.apache.org/sandbox" prefix="s"%>
<%@ page import="org.profamilia.hc.view.servlet.PdfServlet"%>
<h:panelGrid columns="1" border="0" cellpadding="0" cellspacing="0" width="100%" id="panelGridEstFemTab" styleClass="tabContainer">
  <jsp:include page="/pages/clinico/comunes/encabezadoDatosUsuario.jsp" flush="true"/>
  <t:panelTabbedPane border="0" cellpadding="0" cellspacing="0" serverSideTabSwitch="false" activePanelTabVar="true" width="100%" id="panelTabbedPaneEstFem" styleClass="tabbedPane"
                     activeTabStyleClass="activeTab" inactiveTabStyleClass="inactiveTab" disabledTabStyleClass="disabledTab" activeSubStyleClass="activeSub" inactiveSubStyleClass="inactiveSub"
                     tabContentStyleClass="tabContent">
    <t:panelTab id="panelTabEstFem" label="Cuestionario">
      <s:fieldset legend="Preguntas Esterilizaci�n Femenina " id="fieldPreguntas" styleClass="fieldset">
        <a4j:region renderRegionOnly="false">
          <h:panelGrid columns="7">
            <h:outputText value="[ " style="font-size:8.0pt; font-weight:bold;"/>
            <a4j:commandLink style="font-size:8.0pt; font-weight:bold;" value=" Todos SI" immediate="true" action="#{esterFemeninaBean.changeTodosSi}" reRender="tableContentTabsEstFem,tableContentTabsEstFem2,tableContentTabsEstFem3,tableContentTabsEstFem4,tableContentTabsEstFem5,tableContentTabsEstFem6,tableContentTabsEstFem7"/>
            <h:outputText value=" | " style="font-size:8.0pt; font-weight:bold;"/>
            <a4j:commandLink style="font-size:8.0pt; font-weight:bold;" value="Todos NO " immediate="true" action="#{esterFemeninaBean.changeTodosNo}" reRender="tableContentTabsEstFem,tableContentTabsEstFem2,tableContentTabsEstFem3,tableContentTabsEstFem4,tableContentTabsEstFem5,tableContentTabsEstFem6,tableContentTabsEstFem7"/>
            <h:outputText value=" | " style="font-size:8.0pt; font-weight:bold;"/>
            <a4j:commandLink style="font-size:8.0pt; font-weight:bold;" value="Ninguno " immediate="true" action="#{esterFemeninaBean.changeNinguno}" reRender="tableContentTabsEstFem,tableContentTabsEstFem2,tableContentTabsEstFem3,tableContentTabsEstFem4,tableContentTabsEstFem5,tableContentTabsEstFem6,tableContentTabsEstFem7"/>
            <h:outputText value=" ]" style="font-size:8.0pt; font-weight:bold;"/>
          </h:panelGrid>
        </a4j:region>
        <h:outputText value=" "/>
        <h:panelGrid columns="3" border="0" cellpadding="0" cellspacing="0" width="100%" id="tableContentTabsEstFem" 
              rowClasses="standardTable_Row3,standardTable_Row4">
              
         <t:div style="overflow:auto;  width:570px;height:20px;">  
          <h:outputText style="font-size:8.0pt;" value="1.  Se siente Usted actualmente enferma?"  />
          </t:div>
          <h:selectOneRadio id="hcecenfermo" required="true"
                value="#{esterFemeninaBean.cuestEsterilizacion.hcecenfermo}">
            <f:selectItems value="#{esterFemeninaBean.lstOpciones}"/>
          </h:selectOneRadio>
          <h:panelGroup> 
          <h:inputTextarea id = "ithcecanenfermo" value="#{esterFemeninaBean.cuestEsterilizacion.hcecanenfermo}"   style="width:200px">
          <a4j:outputPanel ajaxRendered="true">
            <t:message for="ithcecanenfermo" styleClass="errorMessage"/>
          </a4j:outputPanel>
          </h:inputTextarea>
          </h:panelGroup>
          
          
          <t:div style="overflow:auto;  width:570px;height:20px;">  
          <h:outputText style="font-size:8.0pt;" value="2.  Ha tenido enfermedades graves en el pasado?"  />
          </t:div>
          <h:selectOneRadio id="hcecenfergrav"   required="true"
                value="#{esterFemeninaBean.cuestEsterilizacion.hcecenfergrav}">
            <f:selectItems value="#{esterFemeninaBean.lstOpciones}"/>
          </h:selectOneRadio>
          <h:inputTextarea id="ithcecanenfergrav" value="#{esterFemeninaBean.cuestEsterilizacion.hcecanenfergrav}"   style="width:200px">
          <a4j:outputPanel ajaxRendered="true">
            <t:message for="ithcecanenfergrav" styleClass="errorMessage"/>
          </a4j:outputPanel>
          </h:inputTextarea>
          
           <t:div style="overflow:auto;  width:570px;height:20px;">   
          <h:outputText style="font-size:8.0pt;" value="3.  Ha sido operada o anestesiada alguna vez?"  />
          </t:div>
          <h:selectOneRadio id="hcecoperado"   required="true"
            value="#{esterFemeninaBean.cuestEsterilizacion.hcecoperado}">
            <f:selectItems value="#{esterFemeninaBean.lstOpciones}"/>
          </h:selectOneRadio>
          <h:inputTextarea id = "ithcecanoperado" value="#{esterFemeninaBean.cuestEsterilizacion.hcecanoperado}"   style="width:200px">
          <a4j:outputPanel ajaxRendered="true">
            <t:message for="ithcecanoperado" styleClass="errorMessage"/>
          </a4j:outputPanel>
          </h:inputTextarea>
          <t:div style="overflow:auto;  width:570px;height:20px;">  
          <h:outputText style="font-size:8.0pt;" value="4.  Ha recibido transfusiones de sangre?"  />
          </t:div>
          <h:selectOneRadio id="hcectransfusion"   required="true"
            value="#{esterFemeninaBean.cuestEsterilizacion.hcectransfusion}">
            <f:selectItems value="#{esterFemeninaBean.lstOpciones}"/>
          </h:selectOneRadio>
          <h:inputTextarea id="ithcecantransfusion" 
            value="#{esterFemeninaBean.cuestEsterilizacion.hcecantransfusion}" 
            style="width:200px">
            <a4j:outputPanel ajaxRendered="true">
            <t:message for="ithcecantransfusion" styleClass="errorMessage"/>
          </a4j:outputPanel>
            </h:inputTextarea>
            <t:div style="overflow:auto;  width:570px;height:20px;">  
          <h:outputText style="font-size:8.0pt;" value="5.  Ha tenido o tiene la presion arterial alta?"  />
          </t:div>
          <h:selectOneRadio id="hcecpresionalta"    required="true"
            value="#{esterFemeninaBean.cuestEsterilizacion.hcecpresionalta}">
            <f:selectItems value="#{esterFemeninaBean.lstOpciones}"/>
          </h:selectOneRadio>
          <h:inputTextarea id = "ithcecanpresionalta" value="#{esterFemeninaBean.cuestEsterilizacion.hcecanpresionalta}"   style="width:200px">
          <a4j:outputPanel ajaxRendered="true">
            <t:message for="ithcecanpresionalta" styleClass="errorMessage"/>
          </a4j:outputPanel>
          </h:inputTextarea>
          <t:div style="overflow:auto;  width:570px;height:20px;">  
          <h:outputText style="font-size:8.0pt;" value="6.  Al hacer ejercicio o subir escaleras siente usted: palpitaciones, ahogo o  dolor en el pecho?"  />
          </t:div>
          <h:selectOneRadio id="hcecejercicio"    required="true"
            value="#{esterFemeninaBean.cuestEsterilizacion.hcecejercicio}">
            <f:selectItems value="#{esterFemeninaBean.lstOpciones}"/>
          </h:selectOneRadio>
          <h:inputTextarea id= "ithcecanejercicio" value="#{esterFemeninaBean.cuestEsterilizacion.hcecanejercicio}"   style="width:200px">
          <a4j:outputPanel ajaxRendered="true">
            <t:message for="ithcecanejercicio" styleClass="errorMessage"/>
          </a4j:outputPanel>
          </h:inputTextarea>
          <t:div style="overflow:auto;  width:570px;height:20px;">  
          <h:outputText style="font-size:8.0pt;" value="7.  Ha tenido alguna vez palpitaciones, dolor en el pecho o taquicardia?"  />
          </t:div>
          <h:selectOneRadio id="hcecpalpitacion"   required="true"
            value="#{esterFemeninaBean.cuestEsterilizacion.hcecpalpitacion}">
            <f:selectItems value="#{esterFemeninaBean.lstOpciones}"/>
          </h:selectOneRadio>
          <h:inputTextarea id="ithcecanpalpitacion"  
          value="#{esterFemeninaBean.cuestEsterilizacion.hcecanpalpitacion}" style="width:200px">
          <a4j:outputPanel ajaxRendered="true">
            <t:message for="ithcecanpalpitacion" styleClass="errorMessage"/>
          </a4j:outputPanel>
          </h:inputTextarea>
          <t:div style="overflow:auto;  width:570px;height:20px;">  
          <h:outputText style="font-size:8.0pt;" value="8.  Alguna vez en un examen medico le han encontrado un soplo en el corazon?"  />
          </t:div>
          <h:selectOneRadio id="hcecsoplo"   required="true"
            value="#{esterFemeninaBean.cuestEsterilizacion.hcecsoplo}">
            <f:selectItems value="#{esterFemeninaBean.lstOpciones}"/>
          </h:selectOneRadio>
          <h:inputTextarea id="ithcecansoplo" 
            value="#{esterFemeninaBean.cuestEsterilizacion.hcecansoplo}" style="width:200px">
            <a4j:outputPanel ajaxRendered="true">
            <t:message for="ithcecansoplo" styleClass="errorMessage"/>
          </a4j:outputPanel>
            </h:inputTextarea>
            <t:div style="overflow:auto;  width:570px;height:20px;">  
          <h:outputText style="font-size:8.0pt;" value="9.  Ha tenido o tiene asma o bronquitis?"  />
          </t:div>
          <h:selectOneRadio id="hcecasma"   required="true"
                value="#{esterFemeninaBean.cuestEsterilizacion.hcecasma}">
            <f:selectItems value="#{esterFemeninaBean.lstOpciones}"/>
          </h:selectOneRadio>
          <h:inputTextarea id="ithcecanasma"  
            value="#{esterFemeninaBean.cuestEsterilizacion.hcecanasma}" style="width:200px">
            <a4j:outputPanel ajaxRendered="true">
            <t:message for="ithcecanasma" styleClass="errorMessage"/>
          </a4j:outputPanel>
            </h:inputTextarea>
          <t:div style="overflow:auto;  width:570px;height:20px;">  
          <h:outputText style="font-size:8.0pt;" value="10. Tose con frecuencia?"  />
          </t:div>
          <h:selectOneRadio id="hcectos"    required="true"
          value="#{esterFemeninaBean.cuestEsterilizacion.hcectos}">
            <f:selectItems value="#{esterFemeninaBean.lstOpciones}"/>
          </h:selectOneRadio>
          <h:inputTextarea id="ithcecantos"  
          value="#{esterFemeninaBean.cuestEsterilizacion.hcecantos}" style="width:200px">
          <a4j:outputPanel ajaxRendered="true">
            <t:message for="ithcecantos" styleClass="errorMessage"/>
          </a4j:outputPanel>
          </h:inputTextarea>
          <t:div style="overflow:auto;  width:570px;height:20px;">  
          <h:outputText style="font-size:8.0pt;" value="11. Tiene actualmente gripa?"  />
          </t:div>
          <h:selectOneRadio id="hcecgripa"    required="true"
            value="#{esterFemeninaBean.cuestEsterilizacion.hcecgripa}">
            <f:selectItems value="#{esterFemeninaBean.lstOpciones}"/>
          </h:selectOneRadio>
          <h:inputTextarea id="ithcecangripa"  
            value="#{esterFemeninaBean.cuestEsterilizacion.hcecangripa}" style="width:200px">
             <a4j:outputPanel ajaxRendered="true">
            <t:message for="ithcecangripa" styleClass="errorMessage"/>
          </a4j:outputPanel>
            </h:inputTextarea>
          </h:panelGrid>
          
     <h:panelGrid columns="4" border="0" cellpadding="0" cellspacing="0" width="100%" id="tableContentTabsEstFem2" 
        rowClasses="standardTable_Row4">
          <h:outputText style="font-size:8.0pt;" value="12. Usted fuma o fumo?"  />
          <h:selectOneRadio id="hcecfuma"    required="true"
          value="#{esterFemeninaBean.cuestEsterilizacion.hcecfuma}" immediate="true" 
          valueChangeListener="#{esterFemeninaBean.setFuma}">
            <f:selectItems value="#{esterFemeninaBean.lstOpciones}"/>
            <a4j:support id="supportResFuma" event="onclick" immediate="true" action="#{esterFemeninaBean.changeFumar}" reRender="tableContentTabsEstFem2">
              <a4j:ajaxListener type="org.ajax4jsf.ajax.ForceRender"/>
            </a4j:support>
          </h:selectOneRadio>
           <h:panelGroup id="idPanelGroupFuma">
            <h:outputText style="font-size:8.0pt;" value="�Cuantos al d�a?  " rendered="#{esterFemeninaBean.mostrarFumar}"/>
            <h:inputText id="itFumaDia"  rendered="#{esterFemeninaBean.mostrarFumar}" 
             required="true" 
            value="#{esterFemeninaBean.fumadia}" style="width:20px" maxlength="2" />
            <a4j:outputPanel ajaxRendered="true" rendered="#{esterFemeninaBean.mostrarFumar}">
              <t:message for="itFumaDia" styleClass="errorMessage"/>
            </a4j:outputPanel>
          </h:panelGroup>
          
            <h:inputTextarea id="ithcecanfuma"  
            value="#{esterFemeninaBean.cuestEsterilizacion.hcecanfuma}" style="width:200px">
            <a4j:outputPanel ajaxRendered="true">
            <t:message for="ithcecanfuma" styleClass="errorMessage"/>
          </a4j:outputPanel>
            </h:inputTextarea>
        </h:panelGrid>
          
           <h:panelGrid columns="3" border="0" cellpadding="0" cellspacing="0" width="100%" id="tableContentTabsEstFem3" 
              rowClasses="standardTable_Row3,standardTable_Row4">
          <t:div style="overflow:auto;  width:570px;height:20px;">  
          <h:outputText style="font-size:8.0pt;"  value="13. Ha tenido Usted o algun familiar problemas cuando han recibido anestesia?"  />
          </t:div>
          <h:selectOneRadio id="hcecprobanestesia"     required="true"
          value="#{esterFemeninaBean.cuestEsterilizacion.hcecprobanestesia}">
            <f:selectItems value="#{esterFemeninaBean.lstOpciones}"/>
          </h:selectOneRadio>
          <h:inputTextarea id ="ithcecanprobanestesia" value="#{esterFemeninaBean.cuestEsterilizacion.hcecanprobanestesia}"   style="width:200px">
          <a4j:outputPanel ajaxRendered="true">
            <t:message for="ithcecanprobanestesia" styleClass="errorMessage"/>
          </a4j:outputPanel>
          </h:inputTextarea>
          <t:div style="overflow:auto;  width:570px;height:20px;">  
          <h:outputText style="font-size:8.0pt;" value="14. Ha tenido o tiene alergia a alguna droga?"  />
          </t:div>
          <h:selectOneRadio id="hcecalergia"    required="true"
                value="#{esterFemeninaBean.cuestEsterilizacion.hcecalergia}">
            <f:selectItems value="#{esterFemeninaBean.lstOpciones}"/>
          </h:selectOneRadio>
          <h:inputTextarea id="ithcecanalergia"  value="#{esterFemeninaBean.cuestEsterilizacion.hcecanalergia}" style="width:200px">
          <a4j:outputPanel ajaxRendered="true">
            <t:message for="ithcecanalergia" styleClass="errorMessage"/>
          </a4j:outputPanel>
          </h:inputTextarea>
          <t:div style="overflow:auto;  width:570px;height:20px;">  
          <h:outputText style="font-size:8.0pt;" value="15. Ha tomado alguna droga en los ultimos 6 meses?"  />
          </t:div>
          <h:selectOneRadio id="hcecdrogas"    required="true"
            value="#{esterFemeninaBean.cuestEsterilizacion.hcecdrogas}">
            <f:selectItems value="#{esterFemeninaBean.lstOpciones}"/>
          </h:selectOneRadio>
          <h:inputTextarea id="ithcecandrogas"  
            value="#{esterFemeninaBean.cuestEsterilizacion.hcecandrogas}" style="width:200px">
            <a4j:outputPanel ajaxRendered="true">
            <t:message for="ithcecandrogas" styleClass="errorMessage"/>
          </a4j:outputPanel>
            </h:inputTextarea>
          <t:div style="overflow:auto;  width:570px;height:20px;">  
          <h:outputText style="font-size:8.0pt;" value="16. Ha tenido alguna vez una convulsion? (Epilepsia)"  />
          </t:div>
          <h:selectOneRadio id="hcecconvulsion"    required="true"
            value="#{esterFemeninaBean.cuestEsterilizacion.hcecconvulsion}">
            <f:selectItems value="#{esterFemeninaBean.lstOpciones}"/>
          </h:selectOneRadio>
          <h:inputTextarea id="ithcecanconvulsion"   
            value="#{esterFemeninaBean.cuestEsterilizacion.hcecanconvulsion}" style="width:200px">
              <a4j:outputPanel ajaxRendered="true">
            <t:message for="ithcecanconvulsion" styleClass="errorMessage"/>
          </a4j:outputPanel>
           </h:inputTextarea> 
            
          <t:div style="overflow:auto;  width:570px;height:20px;">  
          <h:outputText style="font-size:8.0pt;" value="17. Ha tenido o tiene enfermedades mentales?"  />
          </t:div>
          <h:selectOneRadio id="hcecenfermental"    required="true"
            value="#{esterFemeninaBean.cuestEsterilizacion.hcecenfermental}">
            <f:selectItems value="#{esterFemeninaBean.lstOpciones}"/>
          </h:selectOneRadio>
          <h:inputTextarea id="ithcecanenfermental"  
            value="#{esterFemeninaBean.cuestEsterilizacion.hcecanenfermental}" style="width:200px">
               <a4j:outputPanel ajaxRendered="true">
            <t:message for="ithcecanenfermental" styleClass="errorMessage"/>
          </a4j:outputPanel>
            </h:inputTextarea>
          <t:div style="overflow:auto;  width:570px;height:20px;">  
          <h:outputText style="font-size:8.0pt;" value="18. Ha tenido o tiene diabetes o hipoglicemia? (Problemas con los niveles de azucar en la sangre)"  />
          </t:div>
          <h:selectOneRadio id="hcecdiabetes"    required="true"
                value="#{esterFemeninaBean.cuestEsterilizacion.hcecdiabetes}">
            <f:selectItems value="#{esterFemeninaBean.lstOpciones}"/>
          </h:selectOneRadio>
          <h:inputTextarea id="ithcecandiabetes"   
            value="#{esterFemeninaBean.cuestEsterilizacion.hcecandiabetes}" style="width:200px">
             <a4j:outputPanel ajaxRendered="true">
            <t:message for="ithcecandiabetes" styleClass="errorMessage"/>
          </a4j:outputPanel>
            </h:inputTextarea>
          <t:div style="overflow:auto;  width:570px;height:20px;">  
          <h:outputText style="font-size:8.0pt;" value="19. Ha tenido hepatitis?"  />
          </t:div>
          <h:selectOneRadio id="hcechepatitis"    required="true"
            value="#{esterFemeninaBean.cuestEsterilizacion.hcechepatitis}">
            <f:selectItems value="#{esterFemeninaBean.lstOpciones}"/>
          </h:selectOneRadio>
          <h:inputTextarea id="ithcecanhepatitis"  
            value="#{esterFemeninaBean.cuestEsterilizacion.hcecanhepatitis}" style="width:200px">
              <a4j:outputPanel ajaxRendered="true">
            <t:message for="ithcecanhepatitis" styleClass="errorMessage"/>
          </a4j:outputPanel>
            </h:inputTextarea>
          <t:div style="overflow:auto;  width:570px;height:20px;">  
          <h:outputText style="font-size:8.0pt;" value="20. Ha tenido o tiene otra enfermedad o alteracion en su salud no  mencionada anteriormente?"  />
          </t:div>
          <h:selectOneRadio id="hcecotraenfer"    required="true"
                value="#{esterFemeninaBean.cuestEsterilizacion.hcecotraenfer}">
            <f:selectItems value="#{esterFemeninaBean.lstOpciones}"/>
          </h:selectOneRadio>
          <h:inputTextarea id="ithcecanotraenfer"   
            value="#{esterFemeninaBean.cuestEsterilizacion.hcecanotraenfer}" style="width:200px">
            <a4j:outputPanel ajaxRendered="true">
            <t:message for="ithcecanotraenfer" styleClass="errorMessage"/>
          </a4j:outputPanel>
            </h:inputTextarea>
          <t:div style="overflow:auto;  width:570px;height:20px;">  
              <h:outputText style="font-size:8.0pt;" value="21. Piensa Usted que esta embarazada?"  />
              </t:div>
          <h:selectOneRadio id="hcecembarazo"    required="true"
            value="#{esterFemeninaBean.cuestEsterilizacion.hcecembarazo}">
            <f:selectItems value="#{esterFemeninaBean.lstOpciones}"/>
          </h:selectOneRadio>
          <h:inputTextarea id="ithcecanembarazo"  
            value="#{esterFemeninaBean.cuestEsterilizacion.hcecanembarazo}" style="width:200px">
            <a4j:outputPanel ajaxRendered="true">
            <t:message for="ithcecanembarazo" styleClass="errorMessage"/>
          </a4j:outputPanel>
            </h:inputTextarea>
         </h:panelGrid> 
         
          <h:panelGrid columns="7" border="0" cellpadding="0" cellspacing="0" width="100%" id="tableContentTabsEstFem4" 
              rowClasses="standardTable_Row4">
              <t:div style="overflow:auto;  width:250px;height:20px;">
                  <h:outputText style="font-size:8.0pt;" value="22. Fecha de la ultima menstruaci�n" />
                  </t:div>
          <t:inputCalendar id="fechaUltimaMens" title="Formato: dd/mm/yyyy"
                                   
                                   value="#{esterFemeninaBean.cuestEsterilizacion.hcedfechultmes}"
                                   onkeydown="return blockEnter(event);" monthYearRowClass="yearMonthHeader"
                                   weekRowClass="weekHeader"
                                   currentDayCellClass="currentDayCell" popupDateFormat="dd/MM/yyyy"
                                   renderAsPopup="true"
                                   popupTodayString="Hoy" popupWeekString="Semana" popupButtonString="Fecha"
                                   readonly="false" maxlength="11" size="11"
                                   popupButtonImageUrl="/comun/imagenes/ico_calendario2.gif"
                                   renderPopupButtonAsImage="true" align="top">
                    <f:validator validatorId="dateMenorIgualValidator"/>
                  </t:inputCalendar>
          <a4j:outputPanel ajaxRendered="true">
            <t:message for="fechaUltimaMens" styleClass="errorMessage"/>
          </a4j:outputPanel>
          <h:outputText style="font-size:8.0pt;" value="Fue normal?"/>
          <h:selectOneRadio id="hcecmesnorm"  
                value="#{esterFemeninaBean.cuestEsterilizacion.hcecmesnorm}" required="true">
            <f:selectItems value="#{esterFemeninaBean.lstOpciones}"/>
          </h:selectOneRadio>
          <a4j:outputPanel ajaxRendered="true">
            <t:message for="hcecmesnorm" styleClass="errorMessage"/>
          </a4j:outputPanel>
          <h:inputTextarea id="ithcecanmesnorm"  
            value="#{esterFemeninaBean.cuestEsterilizacion.hcecanmesnorm}" style="width:200px">
            <a4j:outputPanel ajaxRendered="true">
            <t:message for="ithcecanmesnorm" styleClass="errorMessage"/>
          </a4j:outputPanel>
            </h:inputTextarea>
            </h:panelGrid>
              <h:panelGrid columns="4" border="0" cellpadding="0" cellspacing="0" width="100%" id="tableContentTabsEstFem5" 
        rowClasses="standardTable_Row3">
         <t:div style="overflow:auto;  width:570px;height:20px;">
          <h:outputText style="font-size:8.0pt;" value="23. �Usted o su pareja utiliza(n) actualmente alg�n m�todo de planificaci�n?"  />
          </t:div>
               <h:selectOneRadio id="hcecmetplan"  required="true"
                value="#{esterFemeninaBean.cuestEsterilizacion.hcecutilmetplan}" immediate="true" 
                valueChangeListener="#{esterFemeninaBean.setMetodoPlan}">
            <f:selectItems value="#{esterFemeninaBean.lstOpciones}"/>
            <a4j:support id="supportResMP" event="onclick" immediate="true" action="#{esterFemeninaBean.changeMetodoPlan}" reRender="idPanelGroupMP">
              <a4j:ajaxListener type="org.ajax4jsf.ajax.ForceRender"/>
            </a4j:support>
          </h:selectOneRadio>
          
           <h:panelGroup id="idPanelGroupMP">
            <h:outputText style="font-size:8.0pt;" value="Cual?  " rendered="#{esterFemeninaBean.mostrarMetodoPlan}"/>
            <h:selectOneMenu id="mnuMetodoPlanificacion" rendered="#{esterFemeninaBean.mostrarMetodoPlan}"   
            value="#{esterFemeninaBean.cuestEsterilizacion.hcecmetplan}" required="true">
              <f:selectItems value="#{esterFemeninaBean.lstMetodo}"/>
            </h:selectOneMenu>
            <a4j:outputPanel ajaxRendered="true" rendered="#{esterFemeninaBean.mostrarMetodoPlan}">
              <t:message for="mnuMetodoPlanificacion" styleClass="errorMessage"/>
            </a4j:outputPanel>
          </h:panelGroup>
          
           <h:inputTextarea id="ithcecanmetplan"  value="#{esterFemeninaBean.cuestEsterilizacion.hcecanmetplan}" style="width:200px">
           <a4j:outputPanel ajaxRendered="true">
            <t:message for="ithcecanmetplan" styleClass="errorMessage"/>
          </a4j:outputPanel>
           </h:inputTextarea>
        </h:panelGrid>
         <h:panelGrid columns="7" border="0" cellpadding="0" cellspacing="0" width="100%" id="tableContentTabsEstFem6" 
              rowClasses="standardTable_Row4">
              <h:outputText style="font-size:8.0pt;" value="24. Fecha del ultimo parto/aborto"  />
              
                 <h:outputText style="font-size:8.0pt;" value="Fue?"/>
        <a4j:region renderRegionOnly="false">
          <h:selectOneRadio id="hcecesparto"  
                     required="true" immediate="true"
                     valueChangeListener="#{esterFemeninaBean.setHcecesparto}"
                    value="#{esterFemeninaBean.cuestEsterilizacion.hcecesparto}">
            <f:selectItem itemLabel="Parto" itemValue="P"/>
            <f:selectItem itemLabel="Aborto" itemValue="A"/>
            <f:selectItem itemLabel="Ninguno" itemValue="X"/>
              <a4j:support id="supporthcecesparto" event="onclick" immediate="true"
                         action="#{esterFemeninaBean.changeParto}" reRender="tableContentTabsEstFem6">
              <a4j:ajaxListener type="org.ajax4jsf.ajax.ForceRender"/>
            </a4j:support>            
          </h:selectOneRadio>
          </a4j:region>
          <a4j:outputPanel ajaxRendered="true">
            <t:message for="hcecesparto" styleClass="errorMessage"/>
          </a4j:outputPanel>
          <h:outputText value=" "/>
              
        <t:inputCalendar id="fechaPartoEsterilizacion" title="Formato: dd/mm/yyyy"
                                  
                                   value="#{esterFemeninaBean.cuestEsterilizacion.hcedfechaparto}"
                                   onkeydown="return blockEnter(event);" monthYearRowClass="yearMonthHeader"
                                   weekRowClass="weekHeader"
                                   currentDayCellClass="currentDayCell" popupDateFormat="dd/MM/yyyy"
                                   renderAsPopup="true" rendered = "#{esterFemeninaBean.renderFechaParto}"
                                   popupTodayString="Hoy" popupWeekString="Semana" popupButtonString="Fecha"
                                   readonly="false" maxlength="11" size="11"
                                   popupButtonImageUrl="/comun/imagenes/ico_calendario2.gif"
                                   renderPopupButtonAsImage="true" align="top">
                    <f:validator validatorId="dateMenorIgualValidator"/>
                  </t:inputCalendar>
          <a4j:outputPanel ajaxRendered="true">
            <t:message for="fechaPartoEsterilizacion" styleClass="errorMessage"/>
          </a4j:outputPanel>
  </h:panelGrid>
        
         <h:panelGrid columns="3" border="0" cellpadding="0" cellspacing="0" width="100%" id="tableContentTabsEstFem7" 
              rowClasses="standardTable_Row3,standardTable_Row4">
          <t:div style="overflow:auto;  width:570px;height:20px;">  
          <h:outputText style="font-size:8.0pt;"  value="25. Recibio Usted informacion o asesoria sobre los metodos temporales de planificacion?"  />
          </t:div>
          <h:selectOneRadio id="hcecinfomet"   required="true"
                value="#{esterFemeninaBean.cuestEsterilizacion.hcecinfomet}">
            <f:selectItems value="#{esterFemeninaBean.lstOpciones}"/>
          </h:selectOneRadio>
          <h:inputTextarea id="ithcecaninfomet"   
                value="#{esterFemeninaBean.cuestEsterilizacion.hcecaninfomet}" style="width:200px">
                <a4j:outputPanel ajaxRendered="true">
            <t:message for="ithcecaninfomet" styleClass="errorMessage"/>
          </a4j:outputPanel>
                </h:inputTextarea>
          <h:outputText style="font-size:8.0pt;"  value="26. Sabe usted que la ligadura de trompas es un metodo definitivo de planificacion?"  />
          <h:selectOneRadio id="hcecmetdef"    required="true"
            value="#{esterFemeninaBean.cuestEsterilizacion.hcecmetdef}">
            <f:selectItems value="#{esterFemeninaBean.lstOpciones}"/>
          </h:selectOneRadio>
          <h:inputTextarea id="ithcecanmetdef"  
            value="#{esterFemeninaBean.cuestEsterilizacion.hcecanmetdef}" style="width:200px">
            <a4j:outputPanel ajaxRendered="true">
            <t:message for="ithcecanmetdef" styleClass="errorMessage"/>
          </a4j:outputPanel>
            </h:inputTextarea>
          <h:outputText style="font-size:8.0pt;" value="27. Sabe usted que la ligadura de trompas puede fallar en una de cada 500 mujeres operadas?"  />
          <h:selectOneRadio id="hcecligfalla"   required="true"
            value="#{esterFemeninaBean.cuestEsterilizacion.hcecligfalla}">
            <f:selectItems value="#{esterFemeninaBean.lstOpciones}"/>
          </h:selectOneRadio>
          <h:inputTextarea id="ithcecanligfalla"  
            value="#{esterFemeninaBean.cuestEsterilizacion.hcecanligfalla}" style="width:200px">
            <a4j:outputPanel ajaxRendered="true">
            <t:message for="ithcecanligfalla" styleClass="errorMessage"/>
          </a4j:outputPanel>
            </h:inputTextarea>
          <h:outputText style="font-size:8.0pt;" value="28. Recibio Usted las instrucciones y el consentimiento informado para esterilizacion femenina?"  />
          <h:selectOneRadio id="hcecinsester"   required="true"
            value="#{esterFemeninaBean.cuestEsterilizacion.hcecinsester}">
            <f:selectItems value="#{esterFemeninaBean.lstOpciones}"/>
          </h:selectOneRadio>
          <h:inputTextarea id="ithcecaninsester"  
            value="#{esterFemeninaBean.cuestEsterilizacion.hcecaninsester}" style="width:200px">
            <a4j:outputPanel ajaxRendered="true">
            <t:message for="ithcecaninsester" styleClass="errorMessage"/>
          </a4j:outputPanel>
            </h:inputTextarea>
        </h:panelGrid>
      
      
      </s:fieldset>
      <s:fieldset legend="Generalidades " id="fieldEFGen" styleClass="fieldset">
        <h:panelGrid columns="1" border="0" cellpadding="0" cellspacing="0" width="100%" id="panelObservaciones" rowClasses="labelText,labelTextInfo">
          <h:outputText value="Observaciones Adicionales" style="font-size:8.0pt;"/>
          <h:inputTextarea id="ithcecobserv"   
          value="#{esterFemeninaBean.cuestEsterilizacion.hcecobserv}" style="width:800px">
          <a4j:outputPanel ajaxRendered="true">
            <t:message for="ithcecobserv" styleClass="errorMessage"/>
          </a4j:outputPanel>
          </h:inputTextarea>
        </h:panelGrid>
      </s:fieldset>
    </t:panelTab>
    <h:panelGroup>
      <a4j:outputPanel id="ajaxRegionMensajesCuestEster" ajaxRendered="true">
        <t:htmlTag value="br"/>
        <t:messages id="msgInformationAndErrors" showSummary="false" errorClass="error" globalOnly="true" layout="table" infoClass="informacion" showDetail="true" tooltip="true"
                    warnClass="advertencia"/>
        <t:htmlTag value="br"/>
      </a4j:outputPanel>
    </h:panelGroup>
    <h:panelGrid columns="1" border="0" cellpadding="0" cellspacing="0" width="100%" 
      id="panelBotonModificar" columnClasses="panelGridBotones">
      <h:panelGroup>
        <h:commandButton value="Guardar" styleClass="btn btn btn-success" 
                    action="#{esterFemeninaBean.guardarCuestionario}">
          <a4j:support event="onclick" status="statusButton"/>
        </h:commandButton>
     </h:panelGroup>
    </h:panelGrid>
</t:panelTabbedPane>
     <script language="javascript" type="text/javascript">
        document.forms[1].elements[6].focus()
</script>
</h:panelGrid>