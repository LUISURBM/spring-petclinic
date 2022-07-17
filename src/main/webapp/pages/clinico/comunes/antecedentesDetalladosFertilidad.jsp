<%@ page contentType="text/html;charset=iso-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsf/html" prefix="h"%>
<%@ taglib uri="http://java.sun.com/jsf/core" prefix="f"%>
<%@ taglib uri="http://richfaces.org/a4j" prefix="a4j"%>
<%@ taglib uri="http://myfaces.apache.org/tomahawk" prefix="t"%>
<%@ taglib uri="http://myfaces.apache.org/sandbox" prefix="s"%>
<h:panelGrid columns="1" border="0" cellpadding="0" cellspacing="0" width="100%" id="panelGridAntecedentesDetalTab" styleClass="tabContainer">
  <jsp:include page="/pages/clinico/comunes/encabezadoDatosUsuario.jsp" flush="true"/>
  <t:panelTabbedPane border="0" cellpadding="0" cellspacing="0" serverSideTabSwitch="false" activePanelTabVar="true" width="100%" id="panelTabbedPaneAntecedentesDetal" styleClass="tabbedPane"
                     activeTabStyleClass="activeTab" inactiveTabStyleClass="inactiveTab" disabledTabStyleClass="disabledTab" activeSubStyleClass="activeSub" inactiveSubStyleClass="inactiveSub"
                     tabContentStyleClass="tabContent">
    <t:panelTab id="panelTabMotivoConsulta" label="Antecedentes Detallados">

            <h:panelGrid columns="1" border="0" cellpadding="0" cellspacing="0"
                         width="100%" id="panelAntecedentes"
                         rowClasses="labelText,labelTextInfo">
              <h:outputText value="Tiene Antecedentes Nuevos"
                            styleClass="labelTextOblig" rendered="#{!antecedentesUsuarioDetalladoBean.renderPrimeraVez}" />
             <a4j:region renderRegionOnly="false">
              <h:selectOneRadio id="mnuAntecedentesNuevos" rendered="#{!antecedentesUsuarioDetalladoBean.renderPrimeraVez}" immediate="true"
                                required="true" onkeydown="return blockEnter(event);"
                                value="#{antecedentesUsuarioDetalladoBean.antedecentesDetallado.hadcantenuev}"
                                valueChangeListener="#{antecedentesUsuarioDetalladoBean.setNuevosAntecedentesEvent}">
                <f:selectItems value="#{antecedentesUsuarioDetalladoBean.lstOpciones}"/>
                <a4j:support id="supportmnuAntecedentes" event="onclick"
                             action="#{antecedentesUsuarioDetalladoBean.changeNuevosAntecedentes}"
                             reRender="fieldAntecedentesMusa,changePreguntas,panelPreguntas">
                  <a4j:ajaxListener type="org.ajax4jsf.ajax.ForceRender"/>
                </a4j:support>
                <a4j:outputPanel ajaxRendered="true">
                  <t:message for="mnuAntecedentesNuevos" styleClass="errorMessage"/>
                </a4j:outputPanel>
              </h:selectOneRadio>
              </a4j:region>
            </h:panelGrid>
            <h:panelGrid columns="9" id="changePreguntas">
             <a4j:region renderRegionOnly="false" rendered="#{antecedentesUsuarioDetalladoBean.renderAntecedentesDetallado}">
              <h:outputText value="[ " style="font-size:8.0pt; font-weight:bold;"/>
              <a4j:commandLink style="font-size:8.0pt; font-weight:bold;" value=" Todos SI" immediate="true"
                               action="#{antecedentesUsuarioDetalladoBean.changeTodosSi}" reRender="panelPreguntas"/>
              <h:outputText value=" | " style="font-size:8.0pt; font-weight:bold;"/>
              <a4j:commandLink style="font-size:8.0pt; font-weight:bold;" value="Todos NO " immediate="true"
                               action="#{antecedentesUsuarioDetalladoBean.changeTodosNo}" reRender="panelPreguntas"/>
              <h:outputText value=" | " style="font-size:8.0pt; font-weight:bold;"/>
              <a4j:commandLink style="font-size:8.0pt; font-weight:bold;" value="Ninguno " immediate="true"
                               action="#{antecedentesUsuarioDetalladoBean.changeNinguno}" reRender="panelPreguntas"/>
             </a4j:region>
            </h:panelGrid>

    
          <h:panelGrid columns="2" border="0" cellpadding="0" cellspacing="0" width="100%" id="panelPreguntas"
                       rowClasses="labelText,labelTextInfo" >
                       <h:panelGroup rendered="#{antecedentesUsuarioDetalladoBean.renderAntecedentesDetallado}" >
                <h:panelGrid columns="7" border="0" cellpadding="0" cellspacing="0" width="100%" id="panelCondiEspecificas" rowClasses="standardTable_ExamenFisico2,standardTable_ExamenFisico">
            <h:outputText value="Patológicos" rendered="#{antecedentesUsuarioDetalladoBean.renderAntecedentesDetallado}" styleClass="labelTextOblig"/>
            <a4j:region renderRegionOnly="false">
              <h:selectOneRadio id="mnupato" required="true" rendered="#{antecedentesUsuarioDetalladoBean.renderAntecedentesDetallado}" immediate="true" binding="#{antecedentesUsuarioDetalladoBean.mnuPatologicos}" 
                                value="#{antecedentesUsuarioDetalladoBean.antedecentesDetallado.hadcantepato}" >
                <f:selectItems value="#{antecedentesUsuarioDetalladoBean.lstOpcionesAntecedentes}"/>
                <a4j:support id="supportmnuDismeno" action="#{antecedentesUsuarioDetalladoBean.changePatologiaFertilidad}" reRender="panelPato,panelInputPato,chkPatologicos,mnupato" event="onclick">
                  <a4j:ajaxListener type="org.ajax4jsf.ajax.ForceRender"/>
                </a4j:support>
              </h:selectOneRadio>
            </a4j:region>
            <a4j:outputPanel ajaxRendered="true">
              <t:message for="mnupato" styleClass="errorMessage"/>
            </a4j:outputPanel>
            <h:panelGroup id="panelPato">
              <h:outputText value="Descripción" styleClass="labelTextOblig" rendered="#{antecedentesUsuarioDetalladoBean.renderPatologia}"/>
             
            </h:panelGroup>
            <h:panelGroup id="panelInputPato">
              <h:inputTextarea id="textPato"  required="true" rendered="#{antecedentesUsuarioDetalladoBean.renderPatologia}" value="#{antecedentesUsuarioDetalladoBean.antedecentesDetallado.hadcpatdes}" style="width:350px">
                <f:validateLength maximum="100"/>
                </h:inputTextarea>
               
            </h:panelGroup>
             <h:panelGroup id="chkPatologicos">
                 <a4j:region renderRegionOnly="false">
                 <h:selectManyCheckbox  style="border-style:none;height:100px;" immediate="true"
                                      id="mnuAreaSomaticoPsicoemocional" rendered="#{antecedentesUsuarioDetalladoBean.renderPatologia}"
                                      value="#{antecedentesUsuarioDetalladoBean.lstPatologicosSelected}"
                                      layout="pageDirection">
                  <f:selectItems value="#{antecedentesUsuarioDetalladoBean.lstPatologicos}"/>
                </h:selectManyCheckbox>
              </a4j:region>
            </h:panelGroup>
            <a4j:outputPanel ajaxRendered="true">
              <t:message for="textPato" styleClass="errorMessage"/>
            </a4j:outputPanel>
            
                <h:outputText value="Quirúrgicos" styleClass="labelTextOblig"/>
            <a4j:region renderRegionOnly="false">
              <h:selectOneRadio id="mnuquir" required="true" immediate="true"  
                                value="#{antecedentesUsuarioDetalladoBean.antedecentesDetallado.hadcanteqx}" >
                <f:selectItems value="#{antecedentesUsuarioDetalladoBean.lstOpcionesAntecedentes}"/>
                <a4j:support id="supportmnuQuir" action="#{antecedentesUsuarioDetalladoBean.changeQuirurgicoFertilidad}" reRender="panelQuir,panelInputQuir,chkQuir,mnuquir" event="onclick">
                  <a4j:ajaxListener type="org.ajax4jsf.ajax.ForceRender"/>
                </a4j:support>
              </h:selectOneRadio>
            </a4j:region>
            <a4j:outputPanel ajaxRendered="true">
              <t:message for="mnuquir" styleClass="errorMessage"/>
            </a4j:outputPanel>
            <h:panelGroup id="panelQuir">
              <h:outputText value="Descripción" styleClass="labelTextOblig" rendered="#{antecedentesUsuarioDetalladoBean.renderQuirurgicos}"/>
             
            </h:panelGroup>
            <h:panelGroup id="panelInputQuir">
              <h:inputTextarea id="textQuir" required="true" rendered="#{antecedentesUsuarioDetalladoBean.renderQuirurgicos}" value="#{antecedentesUsuarioDetalladoBean.antedecentesDetallado.hadcquirdes}" style="width:250px">
                <f:validateLength maximum="100"/>
                </h:inputTextarea>
               
            </h:panelGroup>
             <h:panelGroup id="chkQuir">
                 <a4j:region renderRegionOnly="false">
                 <h:selectManyCheckbox  style="border-style:none;height:50px;" immediate="true"
                                       rendered="#{antecedentesUsuarioDetalladoBean.renderQuirurgicos}"
                                      value="#{antecedentesUsuarioDetalladoBean.lstQuirurgicosSelected}"
                                      layout="pageDirection">
                  <f:selectItems value="#{antecedentesUsuarioDetalladoBean.lstQuirurgicos}"/>
                </h:selectManyCheckbox>
              </a4j:region>
            </h:panelGroup>
            <a4j:outputPanel ajaxRendered="true">
              <t:message for="textQuir" styleClass="errorMessage"/>
            </a4j:outputPanel>
            
             <h:outputText value="Tóxicos" styleClass="labelTextOblig"/>
            <a4j:region renderRegionOnly="false">
              <h:selectOneRadio id="mnutox" required="true" immediate="true"  
                                value="#{antecedentesUsuarioDetalladoBean.antedecentesDetallado.hadcantetoxi}" >
                <f:selectItems value="#{antecedentesUsuarioDetalladoBean.lstOpcionesAntecedentes}"/>
                <a4j:support id="supportmnuTox" action="#{antecedentesUsuarioDetalladoBean.changeToxicoFertilidad}" reRender="panelTox,panelInputTox,mnutox" event="onclick">
                  <a4j:ajaxListener type="org.ajax4jsf.ajax.ForceRender"/>
                </a4j:support>
              </h:selectOneRadio>
            </a4j:region>
            <a4j:outputPanel ajaxRendered="true">
              <t:message for="mnutox" styleClass="errorMessage"/>
            </a4j:outputPanel>
            <h:panelGroup id="panelTox">
              <h:outputText value="Descripción" styleClass="labelTextOblig" rendered="#{antecedentesUsuarioDetalladoBean.renderToxicologico}"/>
             
            </h:panelGroup>
            <h:panelGroup id="panelInputTox">
              <h:inputTextarea id="texTox" required="true" rendered="#{antecedentesUsuarioDetalladoBean.renderToxicologico}" value="#{antecedentesUsuarioDetalladoBean.antedecentesDetallado.hadctoxdes}" style="width:350px">
              <f:validateLength maximum="100"/>
              </h:inputTextarea>
            
               
            </h:panelGroup>
            <h:panelGroup/>
            <a4j:outputPanel ajaxRendered="true">
              <t:message for="textQuir" styleClass="errorMessage"/>
            </a4j:outputPanel>
            
            <h:outputText value="Alérgicos" styleClass="labelTextOblig"/>
            <a4j:region renderRegionOnly="false">
              <h:selectOneRadio id="mnuale" required="true" immediate="true"  
                                value="#{antecedentesUsuarioDetalladoBean.antedecentesDetallado.hadcantealer}" >
                <f:selectItems value="#{antecedentesUsuarioDetalladoBean.lstOpcionesAntecedentes}"/>
                <a4j:support id="supportmnuAge" action="#{antecedentesUsuarioDetalladoBean.changeAlergicoFertilidad}" reRender="panelAle,panelInputAle,mnuale" event="onclick">
                  <a4j:ajaxListener type="org.ajax4jsf.ajax.ForceRender"/>
                </a4j:support>
              </h:selectOneRadio>
            </a4j:region>
            <a4j:outputPanel ajaxRendered="true">
              <t:message for="mnuale" styleClass="errorMessage"/>
            </a4j:outputPanel>
            <h:panelGroup id="panelAle">
              <h:outputText value="Descripción" styleClass="labelTextOblig" rendered="#{antecedentesUsuarioDetalladoBean.renderAlergico}"/>
             
            </h:panelGroup>
            <h:panelGroup id="panelInputAle">
              <h:inputTextarea id="textAle" required="true" rendered="#{antecedentesUsuarioDetalladoBean.renderAlergico}" value="#{antecedentesUsuarioDetalladoBean.antedecentesDetallado.hadcaledes}" style="width:350px">
                <f:validateLength maximum="100"/>
                </h:inputTextarea>
               
            </h:panelGroup>
            <h:panelGroup/>
            <a4j:outputPanel ajaxRendered="true">
              <t:message for="textAle" styleClass="errorMessage"/>
            </a4j:outputPanel>
            
              <h:outputText value="Familiares" styleClass="labelTextOblig"/>
            <a4j:region renderRegionOnly="false">
              <h:selectOneRadio id="mnufam" required="true" immediate="true"  
                                value="#{antecedentesUsuarioDetalladoBean.antedecentesDetallado.hadcantefami}" >
                <f:selectItems value="#{antecedentesUsuarioDetalladoBean.lstOpcionesAntecedentes}"/>
                <a4j:support id="supportmnuFami" action="#{antecedentesUsuarioDetalladoBean.changeFamiliarFertilidad}" reRender="panelFam,panelInputFam,chkFam,mnufam" event="onclick">
                  <a4j:ajaxListener type="org.ajax4jsf.ajax.ForceRender"/>
                </a4j:support>
              </h:selectOneRadio>
            </a4j:region>
            <a4j:outputPanel ajaxRendered="true">
              <t:message for="mnufam" styleClass="errorMessage"/>
            </a4j:outputPanel>
            <h:panelGroup id="panelFam">
              <h:outputText value="Descripción" styleClass="labelTextOblig" rendered="#{antecedentesUsuarioDetalladoBean.renderFamiliar}"/>
             
            </h:panelGroup>
            <h:panelGroup id="panelInputFam">
              <h:inputTextarea id="textFam" required="true" rendered="#{antecedentesUsuarioDetalladoBean.renderFamiliar}" value="#{antecedentesUsuarioDetalladoBean.antedecentesDetallado.hadcfamdes}" style="width:350px">
                <f:validateLength maximum="100"/>
                </h:inputTextarea>
               
            </h:panelGroup>
             <h:panelGroup id="chkFam">
                 <a4j:region renderRegionOnly="false">
                 <h:selectManyCheckbox  style="border-style:none;height:100px;" immediate="true"
                                       rendered="#{antecedentesUsuarioDetalladoBean.renderFamiliar}"
                                      value="#{antecedentesUsuarioDetalladoBean.lstFamiliaresSelected}"
                                      layout="pageDirection">
                  <f:selectItems value="#{antecedentesUsuarioDetalladoBean.lstFamiliares}"/>
                </h:selectManyCheckbox>
              </a4j:region>
            </h:panelGroup>
            <a4j:outputPanel ajaxRendered="true">
              <t:message for="textFam" styleClass="errorMessage"/>
            </a4j:outputPanel>
            
             <h:outputText value="Transfusionales" styleClass="labelTextOblig"/>
            <a4j:region renderRegionOnly="false">
              <h:selectOneRadio id="mnutrans" required="true" immediate="true"  
                                value="#{antecedentesUsuarioDetalladoBean.antedecentesDetallado.hadcantetran}" >
                <f:selectItems value="#{antecedentesUsuarioDetalladoBean.lstOpcionesAntecedentes}"/>
                <a4j:support id="supportmnuTrans" action="#{antecedentesUsuarioDetalladoBean.changeTransfusionalFertilidad}" reRender="panelTrans,panelInputTrans,mnutrans" event="onclick">
                  <a4j:ajaxListener type="org.ajax4jsf.ajax.ForceRender"/>
                </a4j:support>
              </h:selectOneRadio>
            </a4j:region>
            <a4j:outputPanel ajaxRendered="true">
              <t:message for="mnutrans" styleClass="errorMessage"/>
            </a4j:outputPanel>
            <h:panelGroup id="panelTrans">
              <h:outputText value="Descripción" styleClass="labelTextOblig" rendered="#{antecedentesUsuarioDetalladoBean.renderTransfusionales}"/>
             
            </h:panelGroup>
            <h:panelGroup id="panelInputTrans">
              <h:inputTextarea id="textTrans" required="true" rendered="#{antecedentesUsuarioDetalladoBean.renderTransfusionales}" value="#{antecedentesUsuarioDetalladoBean.antedecentesDetallado.hadctransdes}" style="width:350px">
                <f:validateLength maximum="100"/>
                </h:inputTextarea>
               
            </h:panelGroup>
            <h:panelGroup/>
            <a4j:outputPanel ajaxRendered="true">
              <t:message for="textTrans" styleClass="errorMessage"/>
            </a4j:outputPanel>
            
              <h:outputText value="ITS" styleClass="labelTextOblig"/>
            <a4j:region renderRegionOnly="false">
              <h:selectOneRadio id="mnuits" required="true" immediate="true"  
                                value="#{antecedentesUsuarioDetalladoBean.antedecentesDetallado.hadcantits}" >
                <f:selectItems value="#{antecedentesUsuarioDetalladoBean.lstOpcionesAntecedentes}"/>
                <a4j:support id="supportmnuIts" action="#{antecedentesUsuarioDetalladoBean.changeITSFertilidad}" reRender="panelIts,panelInputIts,mnuits" event="onclick">
                  <a4j:ajaxListener type="org.ajax4jsf.ajax.ForceRender"/>
                </a4j:support>
              </h:selectOneRadio>
            </a4j:region>
            <a4j:outputPanel ajaxRendered="true">
              <t:message for="mnuits" styleClass="errorMessage"/>
            </a4j:outputPanel>
            <h:panelGroup id="panelIts">
              <h:outputText value="Descripción" styleClass="labelTextOblig" rendered="#{antecedentesUsuarioDetalladoBean.renderITS}"/>
             
            </h:panelGroup>
            <h:panelGroup id="panelInputIts">
              <h:inputTextarea id="texIts" required="true" rendered="#{antecedentesUsuarioDetalladoBean.renderITS}" value="#{antecedentesUsuarioDetalladoBean.antedecentesDetallado.hadcitsdes}" style="width:350px">
                <f:validateLength maximum="100"/>
                </h:inputTextarea>
               
            </h:panelGroup>
            <h:panelGroup/>
            <a4j:outputPanel ajaxRendered="true">
              <t:message for="texIts" styleClass="errorMessage"/>
            </a4j:outputPanel>
            
              <h:outputText value="Farmacológicos" styleClass="labelTextOblig"/>
            <a4j:region renderRegionOnly="false">
              <h:selectOneRadio id="mnufar" required="true" immediate="true"  
                                value="#{antecedentesUsuarioDetalladoBean.antedecentesDetallado.hadcantefarm}" >
                <f:selectItems value="#{antecedentesUsuarioDetalladoBean.lstOpcionesAntecedentes}"/>
                <a4j:support id="supportmnuFar" action="#{antecedentesUsuarioDetalladoBean.changeFarmacologicosFertilidad}" reRender="panelFar,panelInputFar,mnufar" event="onclick">
                  <a4j:ajaxListener type="org.ajax4jsf.ajax.ForceRender"/>
                </a4j:support>
              </h:selectOneRadio>
            </a4j:region>
            <a4j:outputPanel ajaxRendered="true">
              <t:message for="mnufar" styleClass="errorMessage"/>
            </a4j:outputPanel>
            <h:panelGroup id="panelFar">
              <h:outputText value="Descripción" styleClass="labelTextOblig" rendered="#{antecedentesUsuarioDetalladoBean.renderFarmacologicos}"/>
             
            </h:panelGroup>
            <h:panelGroup id="panelInputFar">
              <h:inputTextarea id="textFar" required="true" rendered="#{antecedentesUsuarioDetalladoBean.renderFarmacologicos}" value="#{antecedentesUsuarioDetalladoBean.antedecentesDetallado.hadcfarmdes}" style="width:350px">
                <f:validateLength maximum="100"/>
                </h:inputTextarea>
               
            </h:panelGroup>
            <h:panelGroup/>
            <a4j:outputPanel ajaxRendered="true">
              <t:message for="textFar" styleClass="errorMessage"/>
            </a4j:outputPanel>
            
             <h:outputText value="Traumáticos" styleClass="labelTextOblig"/>
            <a4j:region renderRegionOnly="false">
              <h:selectOneRadio id="mnutra" required="true" immediate="true"  
                                value="#{antecedentesUsuarioDetalladoBean.antedecentesDetallado.hadcantetrau}" >
                <f:selectItems value="#{antecedentesUsuarioDetalladoBean.lstOpcionesAntecedentes}"/>
                <a4j:support id="supportmnuTra" action="#{antecedentesUsuarioDetalladoBean.changeTraumatologicosFertilidad}" reRender="panelTra,panelInputTra,mnutra" event="onclick">
                  <a4j:ajaxListener type="org.ajax4jsf.ajax.ForceRender"/>
                </a4j:support>
              </h:selectOneRadio>
            </a4j:region>
            <a4j:outputPanel ajaxRendered="true">
              <t:message for="mnutra" styleClass="errorMessage"/>
            </a4j:outputPanel>
            <h:panelGroup id="panelTra">
              <h:outputText value="Descripción" styleClass="labelTextOblig" rendered="#{antecedentesUsuarioDetalladoBean.renderTraumaticos}"/>
             
            </h:panelGroup>
            <h:panelGroup id="panelInputTra">
              <h:inputTextarea id="texTra" required="true" rendered="#{antecedentesUsuarioDetalladoBean.renderTraumaticos}" value="#{antecedentesUsuarioDetalladoBean.antedecentesDetallado.hadctraudes}" style="width:350px">
                <f:validateLength maximum="100"/>
                </h:inputTextarea>
               
            </h:panelGroup>
            <h:panelGroup/>
            <a4j:outputPanel ajaxRendered="true">
              <t:message for="texTra" styleClass="errorMessage"/>
            </a4j:outputPanel>
            
             <h:outputText value="Genéticos" styleClass="labelTextOblig"/>
            <a4j:region renderRegionOnly="false">
              <h:selectOneRadio id="mnugen" required="true" immediate="true"  
                                value="#{antecedentesUsuarioDetalladoBean.antedecentesDetallado.hadcantegen}" >
                <f:selectItems value="#{antecedentesUsuarioDetalladoBean.lstOpcionesAntecedentes}"/>
                <a4j:support id="supportmnuGen" action="#{antecedentesUsuarioDetalladoBean.changeGeneticosFertilidad}" reRender="panelGen,panelInputGen,mnugen" event="onclick">
                  <a4j:ajaxListener type="org.ajax4jsf.ajax.ForceRender"/>
                </a4j:support>
              </h:selectOneRadio>
            </a4j:region>
            <a4j:outputPanel ajaxRendered="true">
              <t:message for="mnugen" styleClass="errorMessage"/>
            </a4j:outputPanel>
            <h:panelGroup id="panelGen">
              <h:outputText value="Descripción" styleClass="labelTextOblig" rendered="#{antecedentesUsuarioDetalladoBean.renderGenetico}"/>
             
            </h:panelGroup>
            <h:panelGroup id="panelInputGen">
              <h:inputTextarea id="textGen" required="true" rendered="#{antecedentesUsuarioDetalladoBean.renderGenetico}" value="#{antecedentesUsuarioDetalladoBean.antedecentesDetallado.hadcgendes}" style="width:350px">
                <f:validateLength maximum="100"/>
                </h:inputTextarea>
               
            </h:panelGroup>
            <h:panelGroup/>
            <a4j:outputPanel ajaxRendered="true">
              <t:message for="textGen" styleClass="errorMessage"/>
            </a4j:outputPanel>
            
             <h:outputText value="Masculinos" styleClass="labelTextOblig"/>
            <a4j:region renderRegionOnly="false">
              <h:selectOneRadio id="mnumas" required="true" immediate="true"  
                                value="#{antecedentesUsuarioDetalladoBean.antedecentesDetallado.hadcantemas}" >
                <f:selectItems value="#{antecedentesUsuarioDetalladoBean.lstOpcionesAntecedentes}"/>
                <a4j:support id="supportmnuMas" action="#{antecedentesUsuarioDetalladoBean.changeMasculinoFertilidad}" reRender="panelMas,panelInputMas,chkMas,mnumas" event="onclick">
                  <a4j:ajaxListener type="org.ajax4jsf.ajax.ForceRender"/>
                </a4j:support>
              </h:selectOneRadio>
            </a4j:region>
            <a4j:outputPanel ajaxRendered="true">
              <t:message for="mnumas" styleClass="errorMessage"/>
            </a4j:outputPanel>
            <h:panelGroup id="panelMas">
              <h:outputText value="Descripción" styleClass="labelTextOblig" rendered="#{antecedentesUsuarioDetalladoBean.renderMasculino}"/>
             
            </h:panelGroup>
            <h:panelGroup id="panelInputMas">
              <h:inputTextarea id="textMas" required="true" rendered="#{antecedentesUsuarioDetalladoBean.renderMasculino}" value="#{antecedentesUsuarioDetalladoBean.antedecentesDetallado.hadcmasdes}" style="width:350px">
                <f:validateLength maximum="500"/>
                </h:inputTextarea>
               
            </h:panelGroup>
             <h:panelGroup id="chkMas">
                 <a4j:region renderRegionOnly="false">
                 <h:selectManyCheckbox   style="border-style:none;height:100px;" immediate="true"
                                       rendered="#{antecedentesUsuarioDetalladoBean.renderMasculino}"
                                      value="#{antecedentesUsuarioDetalladoBean.lstMasculinosSelected}"
                                      layout="pageDirection">
                  <f:selectItems value="#{antecedentesUsuarioDetalladoBean.lstMasculinos}"/>
                </h:selectManyCheckbox>
              </a4j:region>
            </h:panelGroup>
            <a4j:outputPanel ajaxRendered="true">
              <t:message for="textMas" styleClass="errorMessage"/>
            </a4j:outputPanel>
    
    
    
         
             
            </h:panelGrid>
            </h:panelGroup>

          
             <h:panelGroup>
          <a4j:outputPanel id="ajaxRegionMessagesatributo1" ajaxRendered="true">
            <t:htmlTag value="br"/>
            <t:messages id="msgInformationAndErrors" showSummary="false" errorClass="error" globalOnly="true" layout="table" infoClass="informacion" showDetail="true" tooltip="true"
                        styleClass="alert alert-success" warnClass="advertencia"/>
            <t:htmlTag value="br"/>
          </a4j:outputPanel>
        </h:panelGroup>
        <h:panelGrid columns="1" border="0" cellpadding="0" cellspacing="0" width="100%" id="panelBotonModificar" columnClasses="panelGridBotones">
          <h:panelGroup>
            <h:commandButton value="Guardar" styleClass="btn btn btn-success" action="#{antecedentesUsuarioDetalladoBean.aceptarFertilidad}">
              <a4j:support event="onclick" status="statusButton"/>
            </h:commandButton>
          </h:panelGroup>
        </h:panelGrid>
        </h:panelGrid>
        </t:panelTab>
        </t:panelTabbedPane>
        </h:panelGrid>
        