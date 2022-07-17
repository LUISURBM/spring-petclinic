<%@ page contentType="text/html;charset=iso-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsf/html" prefix="h"%>
<%@ taglib uri="http://richfaces.org/a4j" prefix="a4j"%>
<%@ taglib uri="http://myfaces.apache.org/tomahawk" prefix="t"%>
<%@ taglib uri="http://myfaces.apache.org/sandbox" prefix="s"%>
<%@ taglib uri="http://java.sun.com/jsf/core" prefix="f"%>
<html>
  <body><h:panelGrid columns="1" border="0" cellpadding="0" cellspacing="0"
                     width="100%" id="tableContentTabsEscalaPrenatal"
                     styleClass="tabContainer">
      <t:htmlTag value="br"/>
      <s:fieldset legend="Historia Reproductiva" id="fieldEscalaBiopsicosocial"
                  styleClass="fieldset">
        <h:panelGrid columns="2" border="0" cellpadding="0" cellspacing="0"
                     width="100%" id="panelDatosHistoriaReproductiva"
                     rowClasses="labelText,labelTextInfo">
          <h:panelGroup>
            <h:outputText value="Edad " styleClass="labelTextOblig"/>
          </h:panelGroup>
          <h:panelGroup>
            <h:outputText value="Paridad " styleClass="labelTextOblig"/>
          </h:panelGroup>
          <h:panelGroup>
            <h:selectOneRadio id="mnuEdad" required="true"
                              value="#{escalaPrenatalBean.edadSelect}">
              <f:selectItems value="#{escalaPrenatalBean.lstEdad}"/>
            </h:selectOneRadio>
            <a4j:outputPanel ajaxRendered="true">
              <t:message for="mnuEdad" styleClass="errorMessage"/>
            </a4j:outputPanel>
            <t:htmlTag value="br"/>
          </h:panelGroup>
          <h:panelGroup>
            <h:selectOneRadio id="mnuParidad" required="true"
                              value="#{escalaPrenatalBean.paridadSelect}">
              <f:selectItems value="#{escalaPrenatalBean.lstParidad}"/>
            </h:selectOneRadio>
            <a4j:outputPanel ajaxRendered="true">
              <t:message for="mnuParidad" styleClass="errorMessage"/>
            </a4j:outputPanel>
            <t:htmlTag value="br"/>
          </h:panelGroup>
        </h:panelGrid>
        <h:panelGrid columns="4" border="0" cellpadding="0" cellspacing="0"
                     width="100%" id="panelDatosHistoriaReproductiva2"
                     rowClasses="labelText,labelTextInfo">
          <h:panelGroup>
            <h:outputText value="Aborto Habitual/Infertilidad "/>
          </h:panelGroup>
          <h:panelGroup>
            <h:outputText value="Retencion Placentaria"/>
          </h:panelGroup>
          <h:panelGroup>
            <h:outputText value="Recien Nacido > 4000 gr "/>
          </h:panelGroup>
          <h:panelGroup>
            <h:outputText value="Recien Nacido < 2500 gr"/>
          </h:panelGroup>
          <h:panelGroup>
            <h:selectBooleanCheckbox id="checkAborto"
                                     value="#{escalaPrenatalBean.sufreAborto}"></h:selectBooleanCheckbox>
          </h:panelGroup>
          <h:panelGroup>
            <h:selectBooleanCheckbox id="checkRetencion"
                                     value="#{escalaPrenatalBean.sufreRetencion}"></h:selectBooleanCheckbox>
          </h:panelGroup>
          <h:panelGroup>
            <h:selectBooleanCheckbox id="checkPesoMayor"
                                     value="#{escalaPrenatalBean.pesoMayor}"></h:selectBooleanCheckbox>
          </h:panelGroup>
          <h:panelGroup>
            <h:selectBooleanCheckbox id="checkPesoMenor"
                                     value="#{escalaPrenatalBean.pesoMenor}"></h:selectBooleanCheckbox>
          </h:panelGroup>
          <h:panelGroup>
            <h:outputText value="HTA Inducida por Embarazo "/>
          </h:panelGroup>
          <h:panelGroup>
            <h:outputText value="Emb. Gemelar/ Cesárea previa"/>
          </h:panelGroup>
          <h:panelGroup>
            <h:outputText value="Mortinato/ Muerte Neonatal"/>
          </h:panelGroup>
          <h:panelGroup>
            <h:outputText value="T.P. Prolongado/ Parto Dificil"/>
          </h:panelGroup>
          <h:panelGroup>
            <h:selectBooleanCheckbox id="checkHTAInducida"
                                     value="#{escalaPrenatalBean.htaInducida}"></h:selectBooleanCheckbox>
          </h:panelGroup>
          <h:panelGroup>
            <h:selectBooleanCheckbox id="checkGemelar"
                                     value="#{escalaPrenatalBean.embarazoGemelar}"></h:selectBooleanCheckbox>
          </h:panelGroup>
          <h:panelGroup>
            <h:selectBooleanCheckbox id="checkMortinato"
                                     value="#{escalaPrenatalBean.muerteNeonatal}"></h:selectBooleanCheckbox>
          </h:panelGroup>
          <h:panelGroup>
            <h:selectBooleanCheckbox id="checkPartoDificil"
                                     value="#{escalaPrenatalBean.partoDificil}"></h:selectBooleanCheckbox>
          </h:panelGroup>
        </h:panelGrid>
      </s:fieldset>
      <s:fieldset legend="CondicionesAsociadas" id="fieldCondicionesAsociadas"
                  styleClass="fieldset">
        <h:panelGrid columns="4" border="0" cellpadding="0" cellspacing="0"
                     width="100%" id="panelDatosCondicionesAsociadas"
                     rowClasses="labelText,labelTextInfo">
          <h:panelGroup>
            <h:outputText value="Qx Ginecologica Previa/Ectopico " />
          </h:panelGroup>
          <h:panelGroup>
            <h:outputText value="Enfermedad Renal Cronica " />
          </h:panelGroup>
          
          <h:panelGroup>
            <h:outputText value="Diabetes Gestacional" />
          </h:panelGroup>
          
          <h:panelGroup>
            <h:outputText value="Diabetes Mellitus" />
          </h:panelGroup>
          
           <h:panelGroup>
            <h:selectBooleanCheckbox id="checkGinecologica" disabled = "#{!escalaPrenatalBean.primerTercio}"
                                     value="#{escalaPrenatalBean.htaInducida}"></h:selectBooleanCheckbox>
            <h:selectBooleanCheckbox id="checkGinecologica2" disabled = "#{!escalaPrenatalBean.segundoTercio}"
                                     value="#{escalaPrenatalBean.htaInducida}"></h:selectBooleanCheckbox>
            <h:selectBooleanCheckbox id="checkGinecologica3" disabled = "#{!escalaPrenatalBean.tercerTercio}"
                                     value="#{escalaPrenatalBean.htaInducida}"></h:selectBooleanCheckbox>
          </h:panelGroup>
          
           <h:panelGroup>
            <h:selectBooleanCheckbox id="checkRenal" disabled = "#{!escalaPrenatalBean.primerTercio}"
                                     value="#{escalaPrenatalBean.htaInducida}"></h:selectBooleanCheckbox>
            <h:selectBooleanCheckbox id="checkRenal2" disabled = "#{!escalaPrenatalBean.segundoTercio}"
                                     value="#{escalaPrenatalBean.htaInducida}"></h:selectBooleanCheckbox>
            <h:selectBooleanCheckbox id="checkRenal3" disabled = "#{!escalaPrenatalBean.tercerTercio}"
                                     value="#{escalaPrenatalBean.htaInducida}"></h:selectBooleanCheckbox>
          </h:panelGroup>
          
           <h:panelGroup>
            <h:selectBooleanCheckbox id="checkDiabetesGestacional" disabled = "#{!escalaPrenatalBean.primerTercio}"
                                     value="#{escalaPrenatalBean.htaInducida}"></h:selectBooleanCheckbox>
            <h:selectBooleanCheckbox id="checkDiabetesGestacional2" disabled = "#{!escalaPrenatalBean.segundoTercio}"
                                     value="#{escalaPrenatalBean.htaInducida}"></h:selectBooleanCheckbox>
            <h:selectBooleanCheckbox id="checkDiabetesGestacional3" disabled = "#{!escalaPrenatalBean.tercerTercio}"
                                     value="#{escalaPrenatalBean.htaInducida}"></h:selectBooleanCheckbox>
          </h:panelGroup>
          
           <h:panelGroup>
            <h:selectBooleanCheckbox id="checkMellitus" disabled = "#{!escalaPrenatalBean.primerTercio}"
                                     value="#{escalaPrenatalBean.htaInducida}"></h:selectBooleanCheckbox>
            <h:selectBooleanCheckbox id="checkMellitus2" disabled = "#{!escalaPrenatalBean.segundoTercio}"
                                     value="#{escalaPrenatalBean.htaInducida}"></h:selectBooleanCheckbox>
                                     
             <h:selectBooleanCheckbox id="checkMellitus3" disabled = "#{!escalaPrenatalBean.tercerTercio}"
                                     value="#{escalaPrenatalBean.htaInducida}"></h:selectBooleanCheckbox>
          </h:panelGroup>
          
             <h:panelGroup>
            <h:outputText value="Enfermedad Cardiaca " />
          </h:panelGroup>
          <h:panelGroup>
            <h:outputText value="Enf. Infecciosa Aguda(Bacteriana)" />
          </h:panelGroup>
          
          <h:panelGroup>
            <h:outputText value="Enfermedad Autoinmune" />
          </h:panelGroup>
          
          <h:panelGroup>
            <h:outputText value="Anemia (Hb < 10g/L)" />
          </h:panelGroup>
          
             <h:panelGroup>
            <h:selectBooleanCheckbox id="checkCardiaca" disabled = "#{!escalaPrenatalBean.primerTercio}"
                                     value="#{escalaPrenatalBean.htaInducida}"></h:selectBooleanCheckbox>
            <h:selectBooleanCheckbox id="checkCardiaca2" disabled = "#{!escalaPrenatalBean.segundoTercio}"
                                     value="#{escalaPrenatalBean.htaInducida}"></h:selectBooleanCheckbox>
            <h:selectBooleanCheckbox id="checkCardiaca3" disabled = "#{!escalaPrenatalBean.tercerTercio}"
                                     value="#{escalaPrenatalBean.htaInducida}"></h:selectBooleanCheckbox>
          </h:panelGroup>
          
           <h:panelGroup>
            <h:selectBooleanCheckbox id="checkInfecciosa" disabled = "#{!escalaPrenatalBean.primerTercio}"
                                     value="#{escalaPrenatalBean.htaInducida}"></h:selectBooleanCheckbox>
            <h:selectBooleanCheckbox id="checkInfecciosa2" disabled = "#{!escalaPrenatalBean.segundoTercio}"
                                     value="#{escalaPrenatalBean.htaInducida}"></h:selectBooleanCheckbox>
            <h:selectBooleanCheckbox id="checkInfecciosa3" disabled = "#{!escalaPrenatalBean.tercerTercio}"
                                     value="#{escalaPrenatalBean.htaInducida}"></h:selectBooleanCheckbox>
          </h:panelGroup>
          
           <h:panelGroup>
            <h:selectBooleanCheckbox id="checkAutoinmune" disabled = "#{!escalaPrenatalBean.primerTercio}"
                                     value="#{escalaPrenatalBean.htaInducida}"></h:selectBooleanCheckbox>
            <h:selectBooleanCheckbox id="checkAutoinmune2" disabled = "#{!escalaPrenatalBean.segundoTercio}"
                                     value="#{escalaPrenatalBean.htaInducida}"></h:selectBooleanCheckbox>
            <h:selectBooleanCheckbox id="checkAutoinmune3" disabled = "#{!escalaPrenatalBean.tercerTercio}"
                                     value="#{escalaPrenatalBean.htaInducida}"></h:selectBooleanCheckbox>
          </h:panelGroup>
          
           <h:panelGroup>
            <h:selectBooleanCheckbox id="checkAnemia" disabled = "#{!escalaPrenatalBean.primerTercio}"
                                     value="#{escalaPrenatalBean.htaInducida}"></h:selectBooleanCheckbox>
            <h:selectBooleanCheckbox id="checkAnemia2" disabled = "#{!escalaPrenatalBean.segundoTercio}"
                                     value="#{escalaPrenatalBean.htaInducida}"></h:selectBooleanCheckbox>
                                     
             <h:selectBooleanCheckbox id="checkAnemia3" disabled = "#{!escalaPrenatalBean.tercerTercio}"
                                     value="#{escalaPrenatalBean.htaInducida}"></h:selectBooleanCheckbox>
          </h:panelGroup>
          
          
        </h:panelGrid>
        
        
        
      </s:fieldset>
      <s:fieldset legend="Embarazo Actual" id="fieldEmbarazoActual"
                  styleClass="fieldset">
        <h:panelGrid columns="5" border="0" cellpadding="0" cellspacing="0"
                     width="100%" id="panelDatosEmbarazoActual"
                     rowClasses="labelText,labelTextInfo">
          <h:panelGroup>
            <h:outputText value="Hemorragia < 20 sem " />
          </h:panelGroup>
          <h:panelGroup>
            <h:outputText value="Vaginal > 20 sem " />
          </h:panelGroup>
             <h:panelGroup>
            <h:outputText value="E. Prolongado(42 sem) " />
          </h:panelGroup>
          <h:panelGroup>
            <h:outputText value="HTA" />
          </h:panelGroup>
             <h:panelGroup>
            <h:outputText value="RPM" />
          </h:panelGroup>
          
            <h:panelGroup>
            <h:selectBooleanCheckbox id="checkHemorragia" disabled = "#{!escalaPrenatalBean.primerTercio}"
                                     value="#{escalaPrenatalBean.htaInducida}"></h:selectBooleanCheckbox>
            <h:selectBooleanCheckbox id="checkHemorragia2" disabled = "#{!escalaPrenatalBean.segundoTercio}"
                                     value="#{escalaPrenatalBean.htaInducida}"></h:selectBooleanCheckbox>
                                     
             <h:selectBooleanCheckbox id="checkHemorragia3" disabled = "#{!escalaPrenatalBean.tercerTercio}"
                                     value="#{escalaPrenatalBean.htaInducida}"></h:selectBooleanCheckbox>
          </h:panelGroup>
          
          
            <h:panelGroup>
            <h:selectBooleanCheckbox id="checkVaginal" disabled = "#{!escalaPrenatalBean.primerTercio}"
                                     value="#{escalaPrenatalBean.htaInducida}"></h:selectBooleanCheckbox>
            <h:selectBooleanCheckbox id="checkVaginal2" disabled = "#{!escalaPrenatalBean.segundoTercio}"
                                     value="#{escalaPrenatalBean.htaInducida}"></h:selectBooleanCheckbox>
                                     
             <h:selectBooleanCheckbox id="checkVaginal3" disabled = "#{!escalaPrenatalBean.tercerTercio}"
                                     value="#{escalaPrenatalBean.htaInducida}"></h:selectBooleanCheckbox>
          </h:panelGroup>
          
          
            <h:panelGroup>
            <h:outputText value = " _ "/>
            <h:outputText value = " _ "/>
            <h:selectBooleanCheckbox id="checkProlongado" disabled = "#{!escalaPrenatalBean.tercerTercio}"
                                     value="#{escalaPrenatalBean.htaInducida}"></h:selectBooleanCheckbox>                                 
          
          </h:panelGroup>
          
          
            <h:panelGroup>
            <h:selectBooleanCheckbox id="checkHTA" disabled = "#{!escalaPrenatalBean.primerTercio}"
                                     value="#{escalaPrenatalBean.htaInducida}"></h:selectBooleanCheckbox>
            <h:selectBooleanCheckbox id="checkHTA2" disabled = "#{!escalaPrenatalBean.segundoTercio}"
                                     value="#{escalaPrenatalBean.htaInducida}"></h:selectBooleanCheckbox>
                                     
             <h:selectBooleanCheckbox id="checkHTA3" disabled = "#{!escalaPrenatalBean.tercerTercio}"
                                     value="#{escalaPrenatalBean.htaInducida}"></h:selectBooleanCheckbox>
          </h:panelGroup>
          
          
            <h:panelGroup>
            <h:selectBooleanCheckbox id="checkRPM" disabled = "#{!escalaPrenatalBean.primerTercio}"
                                     value="#{escalaPrenatalBean.htaInducida}"></h:selectBooleanCheckbox>
            <h:selectBooleanCheckbox id="checkRPM2" disabled = "#{!escalaPrenatalBean.segundoTercio}"
                                     value="#{escalaPrenatalBean.htaInducida}"></h:selectBooleanCheckbox>
                                     
             <h:selectBooleanCheckbox id="checkRPM3" disabled = "#{!escalaPrenatalBean.tercerTercio}"
                                     value="#{escalaPrenatalBean.htaInducida}"></h:selectBooleanCheckbox>
          </h:panelGroup>
          
              <h:panelGroup>
            <h:outputText value="Polihidramnios" />
          </h:panelGroup>
          <h:panelGroup>
            <h:outputText value="RCIU" />
          </h:panelGroup>
             <h:panelGroup>
            <h:outputText value="E. Multiple " />
          </h:panelGroup>
          <h:panelGroup>
            <h:outputText value="Mala Presentación" />
          </h:panelGroup>
             <h:panelGroup>
            <h:outputText value="Isoinmunización" />
          </h:panelGroup>
          
            <h:panelGroup>
            <h:selectBooleanCheckbox id="checkPolihidramnios" disabled = "#{!escalaPrenatalBean.primerTercio}"
                                     value="#{escalaPrenatalBean.htaInducida}"></h:selectBooleanCheckbox>
            <h:selectBooleanCheckbox id="checkPolihidramnios2" disabled = "#{!escalaPrenatalBean.segundoTercio}"
                                     value="#{escalaPrenatalBean.htaInducida}"></h:selectBooleanCheckbox>
                                     
             <h:selectBooleanCheckbox id="checkPolihidramnios3"  disabled = "#{!escalaPrenatalBean.tercerTercio}"
                                     value="#{escalaPrenatalBean.htaInducida}"></h:selectBooleanCheckbox>
          </h:panelGroup>
          
          
            <h:panelGroup>
            <h:selectBooleanCheckbox id="checkRCIU" disabled = "#{!escalaPrenatalBean.primerTercio}"
                                     value="#{escalaPrenatalBean.htaInducida}"></h:selectBooleanCheckbox>
            <h:selectBooleanCheckbox id="checkRCIU2" disabled = "#{!escalaPrenatalBean.segundoTercio}"
                                     value="#{escalaPrenatalBean.htaInducida}"></h:selectBooleanCheckbox>
                                     
             <h:selectBooleanCheckbox id="checkRCIU3" disabled = "#{!escalaPrenatalBean.tercerTercio}"
                                     value="#{escalaPrenatalBean.htaInducida}"></h:selectBooleanCheckbox>
          </h:panelGroup>
          
          
            <h:panelGroup>
            <h:selectBooleanCheckbox id="checkMultiple" disabled = "#{!escalaPrenatalBean.primerTercio}"
                                     value="#{escalaPrenatalBean.htaInducida}"></h:selectBooleanCheckbox>                                 
          <h:selectBooleanCheckbox id="checkMultiple2" disabled = "#{!escalaPrenatalBean.segundoTercio}"
                                     value="#{escalaPrenatalBean.htaInducida}"></h:selectBooleanCheckbox>        
          <h:selectBooleanCheckbox id="checkMultiple3" disabled = "#{!escalaPrenatalBean.tercerTercio}"
                                     value="#{escalaPrenatalBean.htaInducida}"></h:selectBooleanCheckbox>        
          </h:panelGroup>
          
          
            <h:panelGroup>
            <h:selectBooleanCheckbox id="checkPresentacion" disabled = "#{!escalaPrenatalBean.primerTercio}"
                                     value="#{escalaPrenatalBean.htaInducida}"></h:selectBooleanCheckbox>
            <h:selectBooleanCheckbox id="checkPresentacion2" disabled = "#{!escalaPrenatalBean.segundoTercio}"
                                     value="#{escalaPrenatalBean.htaInducida}"></h:selectBooleanCheckbox>
                                     
             <h:selectBooleanCheckbox id="checkPresentacion3" disabled = "#{!escalaPrenatalBean.tercerTercio}"
                                     value="#{escalaPrenatalBean.htaInducida}"></h:selectBooleanCheckbox>
          </h:panelGroup>
          
          
            <h:panelGroup>
            <h:selectBooleanCheckbox id="checkIsoinmunización" disabled = "#{!escalaPrenatalBean.primerTercio}"
                                     value="#{escalaPrenatalBean.htaInducida}"></h:selectBooleanCheckbox>
            <h:selectBooleanCheckbox id="checkIsoinmunización2" disabled = "#{!escalaPrenatalBean.segundoTercio}"
                                     value="#{escalaPrenatalBean.htaInducida}"></h:selectBooleanCheckbox>
                                     
             <h:selectBooleanCheckbox id="checkIsoinmunización3" disabled = "#{!escalaPrenatalBean.tercerTercio}"
                                     value="#{escalaPrenatalBean.htaInducida}"></h:selectBooleanCheckbox>
          </h:panelGroup>
          
          
          
          
        </h:panelGrid>
      </s:fieldset>
      <h:panelGrid columns="2" border="0" cellpadding="0" cellspacing="0"
                   width="100%" id="panelBotonModificar"
                   columnClasses="columnaBotonesCentrados">
        <h:panelGroup>
          <a4j:commandButton value="Guardar" reRender="msgPrenatal"
                             styleClass="boton_fieldset"
                             action="#{antecedentePrenatalBean.aceptar}"/>
        </h:panelGroup>
      </h:panelGrid>
    </h:panelGrid><h:panelGrid>
      <h:panelGroup id="msgPrenatal">
        <a4j:outputPanel id="ajaxRegionMessagesatributo1" ajaxRendered="true">
          <t:htmlTag value="br"/>
          <t:messages id="msgInformationAndErrors1" showSummary="true"
                      errorClass="error" globalOnly="true" layout="table"
                      infoClass="informacion"/>
        </a4j:outputPanel>
      </h:panelGroup>
    </h:panelGrid></body>
</html>