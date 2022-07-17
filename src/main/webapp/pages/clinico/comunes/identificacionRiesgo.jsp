<%@ page contentType="text/html;charset=iso-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsf/html" prefix="h"%>
<%@ taglib uri="http://java.sun.com/jsf/core" prefix="f"%>
<%@ taglib uri="http://richfaces.org/a4j" prefix="a4j"%>
<%@ taglib uri="http://myfaces.apache.org/tomahawk" prefix="t"%>
<%@ taglib uri="http://myfaces.apache.org/sandbox" prefix="s"%>
<h:panelGrid columns="1" border="0" cellpadding="0" cellspacing="0" width="100%" id="panelGridIdentificacionRiesgosTab"
             styleClass="tabContainer">
  <jsp:include page="/pages/clinico/comunes/encabezadoDatosUsuario.jsp" flush="true"/>
  <s:fieldset legend="Identificación de Riesgos" id="fieldHallazgos" styleClass="fieldset">
    <h:panelGrid columns="8" border="0" cellpadding="0" cellspacing="0" width="100%" id="panelIdentificacionRiesgos"
                 rowClasses="standardTable_ExamenFisico,standardTable_ExamenFisico2">
      <h:outputText value="  Existe riesgo de hemorragia" styleClass="labelTextOblig"/>
      <a4j:region renderRegionOnly="false">
       <h:panelGrid columns="8" id="panelIdentificacionR">
              <h:outputText value="[ " style="font-size:8.0pt; font-weight:bold;"/>
              <a4j:commandLink style="font-size:8.0pt; font-weight:bold;" value=" Todos SI" immediate="true"
                               action="#{identificacionRiesgoBean.changeTodosSiRiesgo}" reRender="panelIdentificacionRiesgos"/>
              <h:outputText value=" | " style="font-size:8.0pt; font-weight:bold;"/>
              <a4j:commandLink style="font-size:8.0pt; font-weight:bold;" value="Todos NO " immediate="true"
                               action="#{identificacionRiesgoBean.changeTodosNoRiesgo}" reRender="panelIdentificacionRiesgos"/>
              <h:outputText value=" | " style="font-size:8.0pt; font-weight:bold;"/>
              <a4j:commandLink style="font-size:8.0pt; font-weight:bold;" value="Ninguno " immediate="true"
                               action="#{identificacionRiesgoBean.changeTodosNingunoRiesgo}" reRender="panelIdentificacionRiesgos"/>
              <h:outputText value=" ]" style="font-size:8.0pt; font-weight:bold;"/>
            </h:panelGrid>
            
        <h:selectOneRadio id="mnuRieHemorragia" required="true" immediate="true" 
                          value="#{identificacionRiesgoBean.identifi.hidecriehemo}"
                          binding="#{identificacionRiesgoBean.mnuRieHemorragia}"
                          valueChangeListener="#{identificacionRiesgoBean.setHidecriehemo}">
          <f:selectItems value="#{identificacionRiesgoBean.lstOpciones}"/>
          <a4j:support id="supportmnuRieHemorragia" action="#{identificacionRiesgoBean.changeRieHemorragia}"
                       reRender="panelTexRieHemorragia,panelRieHemorragia,panelOutputRieHemorragia,panelInputRieHemorragia"
                       event="onclick">
            <a4j:ajaxListener type="org.ajax4jsf.ajax.ForceRender"/>
          </a4j:support>
        </h:selectOneRadio>
      </a4j:region>
      <a4j:outputPanel ajaxRendered="true">
        <t:message for="mnuRieHemorragia" styleClass="errorMessage"/>
      </a4j:outputPanel>
      <h:panelGroup id="panelTexRieHemorragia">
        <h:outputText value="Riesgo de hemorragia" styleClass="labelTextOblig"
                      rendered="#{identificacionRiesgoBean.renderRieHemorragia}"/>
      </h:panelGroup>
      <h:panelGroup id="panelRieHemorragia">
        <h:selectManyCheckbox required="true" style="border-style:none;" immediate="true" id="mnuRiesgoHemorragia"
                              rendered="#{identificacionRiesgoBean.renderRieHemorragia}"
                              value="#{identificacionRiesgoBean.lstRiesgoHemorragiaSelect}"
                              valueChangeListener="#{identificacionRiesgoBean.setLstRiesgoHemorragiaSelect}"
                              >
          <f:selectItems value="#{identificacionRiesgoBean.lstRiesgoHemorragia}"/>
        </h:selectManyCheckbox>
        <a4j:outputPanel ajaxRendered="true">
          <t:message for="mnuRiesgoHemorragia" styleClass="errorMessage"/>
        </a4j:outputPanel>
      </h:panelGroup>
      <h:panelGroup id="panelOutputRieHemorragia">
        <h:outputText value="Descripción " styleClass="labelTextOblig"
                      rendered="#{identificacionRiesgoBean.renderRieHemorragia}"/>
      </h:panelGroup>
      <h:panelGroup id="panelInputRieHemorragia">
        <h:inputTextarea id="inputRieHemorragia" style="width:200px" onkeydown="return blockEnter(event);"
                         required="#{identificacionRiesgoBean.renderRieHemorragia}"
                         value="#{identificacionRiesgoBean.identifi.hidecriheobs}"
                         rendered="#{identificacionRiesgoBean.renderRieHemorragia}"/>
      </h:panelGroup>
      <a4j:outputPanel ajaxRendered="true">
        <t:message for="inputRieHemorragia" styleClass="errorMessage"/>
      </a4j:outputPanel>
      <h:outputText value="Existen patologías crónicas." styleClass="labelTextOblig"/>
      <h:selectOneRadio id="mnuPatCronica" required="true" immediate="true" 
                        value="#{identificacionRiesgoBean.identifi.hidecpatcron}"
                        binding="#{identificacionRiesgoBean.mnuPatCronica}"
                        valueChangeListener="#{identificacionRiesgoBean.setHidecpatcron}">
        <f:selectItems value="#{identificacionRiesgoBean.lstOpciones}"/>
      </h:selectOneRadio>
      <a4j:outputPanel ajaxRendered="true">
        <t:message for="mnuPatCronica" styleClass="errorMessage"/>
      </a4j:outputPanel>
      <h:outputText value=""/>
      <h:outputText value=""/>
      <h:outputText value=""/>
      <h:outputText value=""/>
      <h:outputText value=""/>
      <h:outputText value="  Infección actual" styleClass="labelTextOblig"/>
      <a4j:region renderRegionOnly="false">
        <h:selectOneRadio id="mnuInfActual" required="true" immediate="true" 
                          value="#{identificacionRiesgoBean.identifi.hidecinfactu}"
                          binding="#{identificacionRiesgoBean.mnuInfActual}"
                          valueChangeListener="#{identificacionRiesgoBean.setHidecinfactu}">
          <f:selectItems value="#{identificacionRiesgoBean.lstOpciones}"/>
          <a4j:support id="supportmnuInfActual" action="#{identificacionRiesgoBean.changeInfActual}"
                       reRender="panelTexInfActual,panelInfActual,panelOutputInfActual,panelInputInfActual"
                       event="onclick">
            <a4j:ajaxListener type="org.ajax4jsf.ajax.ForceRender"/>
          </a4j:support>
        </h:selectOneRadio>
      </a4j:region>
      <a4j:outputPanel ajaxRendered="true">
        <t:message for="mnuInfActual" styleClass="errorMessage"/>
      </a4j:outputPanel>
      <h:panelGroup id="panelTexInfActual">
        <h:outputText value="Infección" styleClass="labelTextOblig"
                      rendered="#{identificacionRiesgoBean.renderInfActual}"/>
      </h:panelGroup>
      <h:panelGroup id="panelInfActual">
        <h:selectManyCheckbox required="true" style="border-style:none;" immediate="true" id="mnuInfeccionActual"
                              rendered="#{identificacionRiesgoBean.renderInfActual}"
                              value="#{identificacionRiesgoBean.lstInfeccionActualSelect}"
                              valueChangeListener="#{identificacionRiesgoBean.setLstInfeccionActualSelect}"
                              >
          <f:selectItems value="#{identificacionRiesgoBean.lstInfeccionActual}"/>
        </h:selectManyCheckbox>
        <a4j:outputPanel ajaxRendered="true">
          <t:message for="mnuInfeccionActual" styleClass="errorMessage"/>
        </a4j:outputPanel>
      </h:panelGroup>
      <h:panelGroup id="panelOutputInfActual">
        <h:outputText value="Descripción " styleClass="labelTextOblig"
                      rendered="#{identificacionRiesgoBean.renderInfActual}"/>
      </h:panelGroup>
      <h:panelGroup id="panelInputInfActual">
        <h:inputTextarea id="inputInfActual" style="width:200px" onkeydown="return blockEnter(event);"
                         required="#{identificacionRiesgoBean.renderInfActual}"
                         value="#{identificacionRiesgoBean.identifi.hidecinacobs}"
                         rendered="#{identificacionRiesgoBean.renderInfActual}"/>
      </h:panelGroup>
      <a4j:outputPanel ajaxRendered="true">
        <t:message for="inputInfActual" styleClass="errorMessage"/>
      </a4j:outputPanel>
      <h:outputText value="  Antecedente de malformación mulleriana" styleClass="labelTextOblig"/>
      <a4j:region renderRegionOnly="false">
        <h:selectOneRadio id="mnuMalMulleriana" required="true" immediate="true" 
                          value="#{identificacionRiesgoBean.identifi.hidecantmull}"
                          binding="#{identificacionRiesgoBean.mnuMalMulleriana}"
                          valueChangeListener="#{identificacionRiesgoBean.setHidecantmull}">
          <f:selectItems value="#{identificacionRiesgoBean.lstOpciones}"/>
          <a4j:support id="supportmnuMalMulleriana" action="#{identificacionRiesgoBean.changeMalMulleriana}"
                       reRender="panelOutputMalMulleriana,panelInputMalMulleriana" event="onclick">
            <a4j:ajaxListener type="org.ajax4jsf.ajax.ForceRender"/>
          </a4j:support>
        </h:selectOneRadio>
      </a4j:region>
      <a4j:outputPanel ajaxRendered="true">
        <t:message for="mnuMalMulleriana" styleClass="errorMessage"/>
      </a4j:outputPanel>
      <h:panelGroup id="panelOutputMalMulleriana">
        <h:outputText value="Descripción " styleClass="labelTextOblig"
                      rendered="#{identificacionRiesgoBean.renderMalMulleriana}"/>
      </h:panelGroup>
      <h:panelGroup id="panelInputMalMulleriana">
        <h:inputTextarea id="inputMalMulleriana" style="width:200px" onkeydown="return blockEnter(event);"
                         required="#{identificacionRiesgoBean.renderMalMulleriana}"
                         value="#{identificacionRiesgoBean.identifi.hidecanmuobs}"
                         rendered="#{identificacionRiesgoBean.renderMalMulleriana}"/>
      </h:panelGroup>
      <a4j:outputPanel ajaxRendered="true">
        <t:message for="inputMalMulleriana" styleClass="errorMessage"/>
      </a4j:outputPanel>
      <h:outputText value=""/>
      <h:outputText value=""/>
      <h:outputText value="  Serología recientes" styleClass="labelTextOblig"/>
      <a4j:region renderRegionOnly="false">
        <h:selectOneRadio id="mnuSerVih" required="true" immediate="true" 
                          value="#{identificacionRiesgoBean.identifi.hidecserovih}"
                          binding="#{identificacionRiesgoBean.mnuSerVih}"
                          valueChangeListener="#{identificacionRiesgoBean.setHidecserovih}">
          <f:selectItems value="#{identificacionRiesgoBean.lstOpciones}"/>
          <a4j:support id="supportmnuSerVih" action="#{identificacionRiesgoBean.changeSerVih}"
                       reRender="panelOutputSerVih,panelInputSerVih" event="onclick">
            <a4j:ajaxListener type="org.ajax4jsf.ajax.ForceRender"/>
          </a4j:support>
        </h:selectOneRadio>
      </a4j:region>
      <a4j:outputPanel ajaxRendered="true">
        <t:message for="mnuSerVih" styleClass="errorMessage"/>
      </a4j:outputPanel>
      <h:panelGroup id="panelOutputSerVih">
        <h:outputText value="Descripción " styleClass="labelTextOblig"
                      rendered="#{identificacionRiesgoBean.renderSerVih}"/>
        <h:outputText value="Recuerde solicitar serología" styleClass="labelTextOblig"
                      rendered="#{!identificacionRiesgoBean.renderSerVih}"/>
      </h:panelGroup>
      <h:panelGroup id="panelInputSerVih">
        <h:inputTextarea id="inputSerVih" style="width:200px" onkeydown="return blockEnter(event);"
                         required="#{identificacionRiesgoBean.renderSerVih}"
                         value="#{identificacionRiesgoBean.identifi.hidecseviobs}"
                         rendered="#{identificacionRiesgoBean.renderSerVih}"/>
      </h:panelGroup>
      <a4j:outputPanel ajaxRendered="true">
        <t:message for="inputSerVih" styleClass="errorMessage"/>
      </a4j:outputPanel>
      
       <h:outputText value=""/>
      <h:outputText value=""/>
      <h:outputText value="  VIH recientes" styleClass="labelTextOblig"/>
      <a4j:region renderRegionOnly="false">
        <h:selectOneRadio id="mnuVih" required="true" immediate="true" 
                          value="#{identificacionRiesgoBean.identifi.hidecvih}"
                          binding="#{identificacionRiesgoBean.mnuVih}"
                          valueChangeListener="#{identificacionRiesgoBean.setHidecvih}">
          <f:selectItems value="#{identificacionRiesgoBean.lstOpciones}"/>
          <a4j:support id="supportmnuVih" action="#{identificacionRiesgoBean.changeVih}"
                       reRender="panelOutputVih,panelInputVih" event="onclick">
            <a4j:ajaxListener type="org.ajax4jsf.ajax.ForceRender"/>
          </a4j:support>
        </h:selectOneRadio>
      </a4j:region>
      <a4j:outputPanel ajaxRendered="true">
        <t:message for="mnuVih" styleClass="errorMessage"/>
      </a4j:outputPanel>
      <h:panelGroup id="panelOutputVih">
        <h:outputText value="Descripción " styleClass="labelTextOblig"
                      rendered="#{identificacionRiesgoBean.renderVih}"/>
        <h:outputText value="Recuerde solicitar prueba de VIH" styleClass="labelTextOblig"
                      rendered="#{!identificacionRiesgoBean.renderVih}"/>
      </h:panelGroup>
      <h:panelGroup id="panelInputVih">
        <h:inputTextarea id="inputVih" style="width:200px" onkeydown="return blockEnter(event);"
                         required="#{identificacionRiesgoBean.renderVih}"
                         value="#{identificacionRiesgoBean.identifi.hidecvihobs}"
                         rendered="#{identificacionRiesgoBean.renderVih}"/>
      </h:panelGroup>
      <a4j:outputPanel ajaxRendered="true">
        <t:message for="inputVih" styleClass="errorMessage"/>
      </a4j:outputPanel>
      <h:outputText value=""/>
      <h:outputText value=""/>
     
      <h:outputText value="  Sospecha clínica de anemia" styleClass="labelTextOblig"/>
      <a4j:region renderRegionOnly="false">
        <h:selectOneRadio id="mnuSosAnemia" required="true" immediate="true" 
                          value="#{identificacionRiesgoBean.identifi.hidecsosanem}"
                          binding="#{identificacionRiesgoBean.mnuSosAnemia}"
                          valueChangeListener="#{identificacionRiesgoBean.setHidecsosanem}">
          <f:selectItems value="#{identificacionRiesgoBean.lstOpciones}"/>
          <a4j:support id="supportmnuSosAnemia" action="#{identificacionRiesgoBean.changeSosAnemia}"
                       reRender="panelOutputSosAnemia" event="onclick">
            <a4j:ajaxListener type="org.ajax4jsf.ajax.ForceRender"/>
          </a4j:support>
        </h:selectOneRadio>
      </a4j:region>
      <a4j:outputPanel ajaxRendered="true">
        <t:message for="mnuSosAnemia" styleClass="errorMessage"/>
      </a4j:outputPanel>
      <h:panelGroup id="panelOutputSosAnemia">
        <h:outputText value="Recuerde solicitar Cuadro Hemático" styleClass="labelTextOblig"
                      rendered="#{identificacionRiesgoBean.renderSosAnemia}"/>
      </h:panelGroup>
      <h:outputText value=""/>
      <h:outputText value=""/>
      <h:outputText value=""/>
      <h:outputText value=""/>
    </h:panelGrid>
  </s:fieldset>
  <s:fieldset legend="¿Usted tiene o ha tenido?" id="fieldPreguntaRiesgos" styleClass="fieldset" rendered="#{identificacionRiesgoBean.renderPreguntasIVE}">
    <h:panelGrid columns="8" border="0" cellpadding="0" cellspacing="0" width="100%" id="panelUstedTieneOHaTenido"
                 rowClasses="standardTable_ExamenFisico,standardTable_ExamenFisico2">
        <a4j:region renderRegionOnly="false">
            <h:panelGrid columns="8">
              <h:outputText value="[ " style="font-size:8.0pt; font-weight:bold;"/>
              <a4j:commandLink style="font-size:8.0pt; font-weight:bold;" value=" Todos SI" immediate="true"
                               action="#{identificacionRiesgoBean.changeTodosSi}" reRender="panelUstedTieneOHaTenido"/>
              <h:outputText value=" | " style="font-size:8.0pt; font-weight:bold;"/>
              <a4j:commandLink style="font-size:8.0pt; font-weight:bold;" value="Todos NO " immediate="true"
                               action="#{identificacionRiesgoBean.changeTodosNo}" reRender="panelUstedTieneOHaTenido"/>
              <h:outputText value=" | " style="font-size:8.0pt; font-weight:bold;"/>
              <a4j:commandLink style="font-size:8.0pt; font-weight:bold;" value="Ninguno " immediate="true"
                               action="#{identificacionRiesgoBean.changeNinguno}" reRender="panelUstedTieneOHaTenido"/>
              <h:outputText value=" ]" style="font-size:8.0pt; font-weight:bold;"/>
            </h:panelGrid>
          </a4j:region>
      <h:outputText value=""/>
      <h:outputText value=""/>
      <h:outputText value=""/>
      <h:outputText value=""/>
      <h:outputText value=""/>
      <h:outputText value=""/>
      <h:outputText value=""/>
      

      <h:outputText value=" Antecedentes de patologías descompensadas (incluyendo hipertensión arterial inducida por el embarazo) y que sea catalogada como ASA III."
                    styleClass="labelTextOblig"/>
      <a4j:region renderRegionOnly="false">
        <h:selectOneRadio id="mnuAntePatoDesc" required="true" immediate="true" 
                          value="#{identificacionRiesgoBean.identifi.hidecantpatdes}"
                          valueChangeListener="#{identificacionRiesgoBean.setHidecantpatdes}">
          <f:selectItems value="#{identificacionRiesgoBean.lstOpciones}"/>
          <a4j:support id="supportmnuAntePatoDes" action="#{identificacionRiesgoBean.changePreguntasIVE}"
                       reRender="panelOutputAntePatoDes" event="onclick">
            <a4j:ajaxListener type="org.ajax4jsf.ajax.ForceRender"/>
          </a4j:support>
        </h:selectOneRadio>
      </a4j:region>
      <a4j:outputPanel ajaxRendered="true">
        <t:message for="mnuAntePatoDesc" styleClass="errorMessage"/>
      </a4j:outputPanel>
      <h:panelGroup id="panelOutputAntePatoDes">
        <h:outputText value="Esta paciente debe ser remitida a IPS de III nivel" styleClass="labelTextOblig"
                      rendered="#{identificacionRiesgoBean.renderAntecedentePato}"/>
      </h:panelGroup>
      <h:outputText value=""/>
      <h:outputText value=""/>
      <h:outputText value=""/>
      <h:outputText value=""/>
      <h:outputText value="Una (1) cesárea anterior y antecedente de infección postoperatoria."
                    styleClass="labelTextOblig"/>
      <a4j:region renderRegionOnly="false">
        <h:selectOneRadio id="mnuCesaAnteAnteInfe" required="true" immediate="true" 
                          value="#{identificacionRiesgoBean.identifi.hidecunceananin}"
                          valueChangeListener="#{identificacionRiesgoBean.setHidecunceananin}">
          <f:selectItems value="#{identificacionRiesgoBean.lstOpciones}"/>
          <a4j:support id="supportmnuCesaAnteAnteInfe" action="#{identificacionRiesgoBean.changePreguntasIVE}"
                       reRender="panelOutputCesaAnteAnteInfe" event="onclick">
            <a4j:ajaxListener type="org.ajax4jsf.ajax.ForceRender"/>
          </a4j:support>
        </h:selectOneRadio>
      </a4j:region>
      <a4j:outputPanel ajaxRendered="true">
        <t:message for="mnuCesaAnteAnteInfe" styleClass="errorMessage"/>
      </a4j:outputPanel>
      <h:panelGroup id="panelOutputCesaAnteAnteInfe">
        <h:outputText value="Si la usuaria elige método farmacológico, explique detalladamente los signos de alarma y que en caso que presente alguno de ellos, asista inmediatamente al servicio de urgencias más cercano, o que tome el tratamiento farmacológico durante el horario de apertura de la sede de Profamilia, para que asista allí en caso de presentar alguno de estos signos; si escoge AMEU, ésta debe ser realizada en cirugía y garantizar la disponibilidad de ginecólogo en la clínica" styleClass="labelTextOblig"
                      rendered="#{identificacionRiesgoBean.renderCesareaAnte}"/>
      </h:panelGroup>
      <h:outputText value=""/>
      <h:outputText value=""/>
      <h:outputText value=""/>
      <h:outputText value=""/>
      <h:outputText value="Dos (2) o más cesáreas." styleClass="labelTextOblig"/>
      <a4j:region renderRegionOnly="false">
        <h:selectOneRadio id="mnuDosOMasCesa" required="true" immediate="true" 
                          value="#{identificacionRiesgoBean.identifi.hidecdosmasces}"
                          valueChangeListener="#{identificacionRiesgoBean.setHidecdosmasces}">
          <f:selectItems value="#{identificacionRiesgoBean.lstOpciones}"/>
          <a4j:support id="supportmnuDosOMasCesa" action="#{identificacionRiesgoBean.changePreguntasIVE}"
                       reRender="panelOutputDosOMasCesa" event="onclick">
            <a4j:ajaxListener type="org.ajax4jsf.ajax.ForceRender"/>
          </a4j:support>
        </h:selectOneRadio>
      </a4j:region>
      <a4j:outputPanel ajaxRendered="true">
        <t:message for="mnuDosOMasCesa" styleClass="errorMessage"/>
      </a4j:outputPanel>
      <h:panelGroup id="panelOutputDosOMasCesa">
        <h:outputText value="Si la usuaria elige método farmacológico, explique detalladamente los signos de alarma y que en caso que presente alguno de ellos, asista inmediatamente al servicio de urgencias más cercano, o que tome el tratamiento farmacológico durante el horario de apertura de la sede de Profamilia, para que asista allí en caso de presentar alguno de estos signos; si escoge AMEU, ésta debe ser realizada en cirugía y garantizar la disponibilidad de ginecólogo en la clínica" styleClass="labelTextOblig"
                      rendered="#{identificacionRiesgoBean.renderDosCesareas}"/>
      </h:panelGroup>
      <h:outputText value=""/>
      <h:outputText value=""/>
      <h:outputText value=""/>
      <h:outputText value=""/>
      <h:outputText value="Alteraciones anatómicas (itsmocele, entre otras) confirmada por ecografía."
                    styleClass="labelTextOblig"/>
      <a4j:region renderRegionOnly="false">
        <h:selectOneRadio id="mnuAlteAnat" required="true" immediate="true" 
                          value="#{identificacionRiesgoBean.identifi.hidecalancoec}"
                          valueChangeListener="#{identificacionRiesgoBean.setHidecalancoec}">
          <f:selectItems value="#{identificacionRiesgoBean.lstOpciones}"/>
          <a4j:support id="supportmnuAlteAnat" action="#{identificacionRiesgoBean.changePreguntasIVE}"
                       reRender="panelOutputAlteAnat" event="onclick">
            <a4j:ajaxListener type="org.ajax4jsf.ajax.ForceRender"/>
          </a4j:support>
        </h:selectOneRadio>
      </a4j:region>
      <a4j:outputPanel ajaxRendered="true">
        <t:message for="mnuAlteAnat" styleClass="errorMessage"/>
      </a4j:outputPanel>
      <h:panelGroup id="panelOutputAlteAnat">
        <h:outputText value="Si la usuaria elige método farmacológico, explique detalladamente los signos de alarma y que en caso que presente alguno de ellos, asista inmediatamente al servicio de urgencias más cercano, o que tome el tratamiento farmacológico durante el horario de apertura de la sede de Profamilia, para que asista allí en caso de presentar alguno de estos signos; si escoge AMEU, ésta debe ser realizada en cirugía y garantizar la disponibilidad de ginecólogo en la clínica" styleClass="labelTextOblig"
                      rendered="#{identificacionRiesgoBean.renderAlteracionesAnato}"/>
      </h:panelGroup>
      <h:outputText value=""/>
      <h:outputText value=""/>
      <h:outputText value=""/>
      <h:outputText value=""/>
    </h:panelGrid>
  </s:fieldset>
  <h:panelGrid columns="1" border="0" cellpadding="0" cellspacing="0" width="100%" id="panelBotonModificarGinecologicos"
               columnClasses="panelGridBotones">
    <h:panelGroup>
      <h:commandButton value="Guardar" styleClass="btn btn btn-success" action="#{identificacionRiesgoBean.aceptar}">
        <a4j:support event="onclick" status="statusButton"/>
      </h:commandButton>
    </h:panelGroup>
  </h:panelGrid>
</h:panelGrid>