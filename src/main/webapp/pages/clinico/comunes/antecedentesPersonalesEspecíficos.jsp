<%@ page contentType="text/html;charset=iso-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsf/html" prefix="h"%>
<%@ taglib uri="http://java.sun.com/jsf/core" prefix="f"%>
<%@ taglib uri="http://richfaces.org/a4j" prefix="a4j"%>
<%@ taglib uri="http://myfaces.apache.org/tomahawk" prefix="t"%>
<%@ taglib uri="http://myfaces.apache.org/sandbox" prefix="s"%>
<h:panelGrid columns="1" border="0" cellpadding="0" cellspacing="0" width="100%" id="panelAntecedentes"
             rowClasses="labelText,labelTextInfo">
  <h:outputText value="Tiene Antecedentes Nuevos" styleClass="labelTextOblig" rendered="#{antecedentesUsuarioDetalladoBean.renderNuevoAntecedente}"/>
  <a4j:region renderRegionOnly="false">
    <h:selectOneRadio id="mnuAntecedentesNuevos" immediate="true" required="true" onkeydown="return blockEnter(event);"
                      value="#{antecedentesUsuarioDetalladoBean.antedecentesDetallado.hadcantenuev}"
                      valueChangeListener="#{antecedentesUsuarioDetalladoBean.setNuevosAntecedentesEvent}"
                      rendered="#{antecedentesUsuarioDetalladoBean.renderNuevoAntecedente}">
      <f:selectItems value="#{antecedentesUsuarioDetalladoBean.lstOpciones}"/>
      <a4j:support id="supportmnuAntecedentes" event="onclick"
                   action="#{antecedentesUsuarioDetalladoBean.changeNuevosAntecedentes}"
                   reRender="fieldAntecedentesMusa,changePreguntas">
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
<h:panelGrid columns="3" border="0" cellpadding="0" cellspacing="0" width="100%" id="panelPreguntas"
             rowClasses="standardTable_ExamenFisico2,standardTable_ExamenFisico"
             rendered="#{antecedentesUsuarioDetalladoBean.renderAntecedentesDetallado}">
  <h:panelGroup>
    <h:outputText value="Patologicos" styleClass="labelTextOblig"/>
    <a4j:region renderRegionOnly="false">
      <h:selectOneRadio id="menuPatologia" immediate="true" required="true"
                        value="#{antecedentesUsuarioDetalladoBean.antedecentesDetallado.hadcantepato}">
        <f:selectItems value="#{antecedentesUsuarioDetalladoBean.lstOpcionesAntecedentes}"/>
        <a4j:support id="supportmnuPatologia" event="onclick"
                     action="#{antecedentesUsuarioDetalladoBean.changePatologia}"
                     reRender="panelGPreguntas,panelDescripPato">
          <a4j:ajaxListener type="org.ajax4jsf.ajax.ForceRender"/>
        </a4j:support>
      </h:selectOneRadio>
    </a4j:region>
    <a4j:outputPanel ajaxRendered="true">
      <t:message for="menuPatologia" styleClass="errorMessage"/>
    </a4j:outputPanel>
  </h:panelGroup>
  <h:panelGrid id="panelDescripPato" columns="1" border="0" cellpadding="0" cellspacing="2">
    <h:outputText value="Descripcion:" styleClass="labelTextOblig"
                  rendered="#{antecedentesUsuarioDetalladoBean.renderPatologia}"/>
    <h:panelGroup>
      <h:inputTextarea id="patoText" immediate="true" required="#{antecedentesUsuarioDetalladoBean.renderPatologia}"
                       rendered="#{antecedentesUsuarioDetalladoBean.renderPatologia}"
                       value="#{antecedentesUsuarioDetalladoBean.antedecentesDetallado.hadcpatdes}">
                        <f:validateLength maximum="250"/>
                       </h:inputTextarea>
      <a4j:outputPanel ajaxRendered="true" rendered="#{antecedentesUsuarioDetalladoBean.renderPatologia}">
        <t:message for="patoText" styleClass="errorMessage"/>
      </a4j:outputPanel>
    </h:panelGroup>
  </h:panelGrid>
  <h:panelGroup id="panelGPreguntas">
    <h:panelGrid columns="1" border="0" cellpadding="0" cellspacing="0" id="panelOpcionesAntecedentes"
                 rendered="#{antecedentesUsuarioDetalladoBean.renderPatologia}">
      <h:panelGroup>
        <a4j:region renderRegionOnly="false">
          <h:selectManyCheckbox required="false" style="border-style:none;" immediate="true" id="mnuPreguntasPatologia"
                                value="#{antecedentesUsuarioDetalladoBean.lstPatologicosIveSelected}"
                                valueChangeListener="#{antecedentesUsuarioDetalladoBean.setPreguntasPatologicosIveSelected}"
                                layout="pageDirection">
            <f:selectItems value="#{antecedentesUsuarioDetalladoBean.lstPatologicosIve}"/>
            <a4j:support id="supportmnuListaPatologia" event="onclick" immediate="true"
                         action="#{antecedentesUsuarioDetalladoBean.changePreguntasPatologias}">
              <a4j:ajaxListener type="org.ajax4jsf.ajax.ForceRender"/>
            </a4j:support>
          </h:selectManyCheckbox>
        </a4j:region>
        <a4j:outputPanel ajaxRendered="true">
          <t:message for="mnuPreguntasPatologia" styleClass="errorMessage"/>
        </a4j:outputPanel>
      </h:panelGroup>
    </h:panelGrid>
  </h:panelGroup>
  <h:panelGroup>
    <h:outputText value="Quirúrgicos" styleClass="labelTextOblig"/>
    <a4j:region renderRegionOnly="false">
      <h:selectOneRadio id="menuQuirurgicos" immediate="true" required="true"
                        value="#{antecedentesUsuarioDetalladoBean.antedecentesDetallado.hadcanteqx}">
        <f:selectItems value="#{antecedentesUsuarioDetalladoBean.lstOpcionesAntecedentes}"/>
        <a4j:support id="supportmnuQuirurgicos" event="onclick"
                     action="#{antecedentesUsuarioDetalladoBean.changeAntQuirurgicos}"
                     reRender="panelPreguntasQuirurgicos,panelGPreguntasQuirurgicos,panelDescripQuiru">
          <a4j:ajaxListener type="org.ajax4jsf.ajax.ForceRender"/>
        </a4j:support>
      </h:selectOneRadio>
    </a4j:region>
    <a4j:outputPanel ajaxRendered="true">
      <t:message for="menuQuirurgicos" styleClass="errorMessage"/>
    </a4j:outputPanel>
  </h:panelGroup>
  <h:panelGrid id="panelDescripQuiru" columns="1" border="0" cellpadding="0" cellspacing="2">
    <h:outputText value="Descripcion:" styleClass="labelTextOblig"
                  rendered="#{antecedentesUsuarioDetalladoBean.renderQuirurgicos}"/>
    <h:panelGroup>
      <h:inputTextarea id="quiruText" immediate="true" required="#{antecedentesUsuarioDetalladoBean.renderQuirurgicos}"
                       rendered="#{antecedentesUsuarioDetalladoBean.renderQuirurgicos}"
                       value="#{antecedentesUsuarioDetalladoBean.antedecentesDetallado.hadcquirdes}">
                          <f:validateLength maximum="250"/>
                       </h:inputTextarea>
      <a4j:outputPanel ajaxRendered="true" rendered="#{antecedentesUsuarioDetalladoBean.renderQuirurgicos}">
        <t:message for="quiruText" styleClass="errorMessage"/>
      </a4j:outputPanel>
    </h:panelGroup>
  </h:panelGrid>
  <h:panelGroup id="panelGPreguntasQuirurgicos">
    <h:panelGrid columns="2" border="0" cellpadding="0" cellspacing="2" id="panelOpcionesAntecedentesQuirugicos"
                 rendered="#{antecedentesUsuarioDetalladoBean.renderQuirurgicos}">
      <h:panelGroup>
        <a4j:region renderRegionOnly="false">
          <h:selectManyCheckbox required="false" style="border-style:none;" immediate="true"
                                id="mnuPreguntasQuirurgicos"
                                value="#{antecedentesUsuarioDetalladoBean.lstQuirurgicosIveSelected}"
                                valueChangeListener="#{antecedentesUsuarioDetalladoBean.setPreguntasQuirurgicosIveSelected}"
                                layout="pageDirection">
            <f:selectItems value="#{antecedentesUsuarioDetalladoBean.lstQuirurgicosIve}"/>
            <a4j:support id="supportmnuPreQuirurgicos" event="onclick" immediate="true"
                         action="#{antecedentesUsuarioDetalladoBean.changePreguntasAntQuirurgicos}">
              <a4j:ajaxListener type="org.ajax4jsf.ajax.ForceRender"/>
            </a4j:support>
          </h:selectManyCheckbox>
        </a4j:region>
        <a4j:outputPanel ajaxRendered="true">
          <t:message for="mnuPreguntasQuirurgicos" styleClass="errorMessage"/>
        </a4j:outputPanel>
      </h:panelGroup>
    </h:panelGrid>
  </h:panelGroup>
    <h:panelGroup>
    <h:outputText value="Tóxicos" styleClass="labelTextOblig"/>
    <a4j:region renderRegionOnly="false">
      <h:selectOneRadio id="menuToxicologico" immediate="true" required="true"
                        value="#{antecedentesUsuarioDetalladoBean.antedecentesDetallado.hadcantetoxi}">
        <f:selectItems value="#{antecedentesUsuarioDetalladoBean.lstOpcionesAntecedentes}"/>
        <a4j:support id="supportmnuToxicologico" event="onclick"
                     action="#{antecedentesUsuarioDetalladoBean.changeAntToxicologicos}"
                     reRender="panelPreguntasToxicologicas,panelGPreguntasToxicologicas,panelDescripToxico">
          <a4j:ajaxListener type="org.ajax4jsf.ajax.ForceRender"/>
        </a4j:support>
      </h:selectOneRadio>
    </a4j:region>
    <a4j:outputPanel ajaxRendered="true">
      <t:message for="menuToxicologico" styleClass="errorMessage"/>
    </a4j:outputPanel>
  </h:panelGroup>
  <h:panelGrid id="panelDescripToxico" columns="1" border="0" cellpadding="0" cellspacing="2">
    <h:outputText value="Descripcion:" styleClass="labelTextOblig"
                  rendered="#{antecedentesUsuarioDetalladoBean.renderToxicologico}"/>
    <h:panelGroup>
      <h:inputTextarea id="toxText" immediate="true" required="#{antecedentesUsuarioDetalladoBean.renderToxicologico}"
                       rendered="#{antecedentesUsuarioDetalladoBean.renderToxicologico}"
                       value="#{antecedentesUsuarioDetalladoBean.antedecentesDetallado.hadctoxdes}">
                         <f:validateLength maximum="250"/>
                       </h:inputTextarea>
      <a4j:outputPanel ajaxRendered="true" rendered="#{antecedentesUsuarioDetalladoBean.renderToxicologico}">
        <t:message for="toxText" styleClass="errorMessage"/>
      </a4j:outputPanel>
    </h:panelGroup>
  </h:panelGrid>
  <h:panelGroup id="panelPreguntasToxicologicas">
    <h:panelGrid columns="1" border="0" cellpadding="0" cellspacing="1" id="panelGPreguntasToxicologicas"
                 rendered="#{antecedentesUsuarioDetalladoBean.renderToxicologico}">
      <h:panelGroup>
        <a4j:region renderRegionOnly="false">
          <h:selectManyCheckbox required="false" style="border-style:none;" immediate="true"
                                id="mnuPreguntasToxicologicas"
                                value="#{antecedentesUsuarioDetalladoBean.lstPreguntasToxicologicasSelect}"
                                valueChangeListener="#{antecedentesUsuarioDetalladoBean.setPreguntasToxicologicasSelect}"
                                layout="pageDirection">
            <f:selectItems value="#{antecedentesUsuarioDetalladoBean.lstPreguntasToxicologicas}"/>
            <a4j:support id="supportmnuPreToxicologicas" event="onclick" immediate="true"
                         action="#{antecedentesUsuarioDetalladoBean.changePreguntasToxicologicas}">
              <a4j:ajaxListener type="org.ajax4jsf.ajax.ForceRender"/>
            </a4j:support>
          </h:selectManyCheckbox>
        </a4j:region>
        <a4j:outputPanel ajaxRendered="true">
          <t:message for="mnuPreguntasToxicologicas" styleClass="errorMessage"/>
        </a4j:outputPanel>
      </h:panelGroup>
    </h:panelGrid>
  </h:panelGroup>
  <h:panelGroup>
    <h:outputText value="Alérgicos" styleClass="labelTextOblig"/>
    <a4j:region renderRegionOnly="false">
      <h:selectOneRadio id="menuAlergicos" immediate="true" required="true"
                        value="#{antecedentesUsuarioDetalladoBean.antedecentesDetallado.hadcantealer}">
        <f:selectItems value="#{antecedentesUsuarioDetalladoBean.lstOpcionesAntecedentes}"/>
        <a4j:support id="supportmnuAlergicos" event="onclick"
                     action="#{antecedentesUsuarioDetalladoBean.changeAntAlergico}"
                     reRender="panelGPreguntasAlergicos,panelOpcionesAntecedentesAlergicos">
          <a4j:ajaxListener type="org.ajax4jsf.ajax.ForceRender"/>
        </a4j:support>
      </h:selectOneRadio>
    </a4j:region>
    <a4j:outputPanel ajaxRendered="true">
      <t:message for="menuAlergicos" styleClass="errorMessage"/>
    </a4j:outputPanel>
  </h:panelGroup>
  <h:panelGroup id="panelGPreguntasAlergicos">
    <h:panelGrid columns="1" border="0" cellpadding="0" cellspacing="2" id="panelOpcionesAntecedentesAlergicos"
                 rendered="#{antecedentesUsuarioDetalladoBean.renderAlergico}">
      <h:outputText value="Descripcion:" styleClass="labelTextOblig"
                    rendered="#{antecedentesUsuarioDetalladoBean.renderAlergico}"/>
      <h:panelGroup>
        <h:inputTextarea id="alergicosDecrip" immediate="true"
                         required="#{antecedentesUsuarioDetalladoBean.renderAlergico}"
                         rendered="#{antecedentesUsuarioDetalladoBean.renderAlergico}"
                         value="#{antecedentesUsuarioDetalladoBean.antedecentesDetallado.hadcantaledes}">
                           <f:validateLength maximum="250"/>
                         </h:inputTextarea>
        <a4j:outputPanel ajaxRendered="true" rendered="#{antecedentesUsuarioDetalladoBean.renderAlergico}">
          <t:message for="alergicosDecrip" styleClass="errorMessage"/>
        </a4j:outputPanel>
      </h:panelGroup>
    </h:panelGrid>
  </h:panelGroup>
  <h:panelGroup>
    <h:outputText value="" rendered="#{!antecedentesUsuarioDetalladoBean.renderAlergico}"/>
  </h:panelGroup>
  <h:panelGroup>
    <h:outputText value="Transfusionales" styleClass="labelTextOblig"/>
    <a4j:region renderRegionOnly="false">
      <h:selectOneRadio id="menuTransfusionales" immediate="true" required="true"
                        value="#{antecedentesUsuarioDetalladoBean.antedecentesDetallado.hadcantetran}">
        <f:selectItems value="#{antecedentesUsuarioDetalladoBean.lstOpcionesAntecedentes}"/>
        <a4j:support id="supportmnuTransfusionales" event="onclick"
                     action="#{antecedentesUsuarioDetalladoBean.changeAntTransfusionales}"
                     reRender="panelGPreguntasTransfusionales,panelOpcionesAntecedentesTransfusionales">
          <a4j:ajaxListener type="org.ajax4jsf.ajax.ForceRender"/>
        </a4j:support>
      </h:selectOneRadio>
    </a4j:region>
    <a4j:outputPanel ajaxRendered="true">
      <t:message for="menuTransfusionales" styleClass="errorMessage"/>
    </a4j:outputPanel>
  </h:panelGroup>
  <h:panelGroup id="panelGPreguntasTransfusionales">
    <h:panelGrid columns="1" border="0" cellpadding="0" cellspacing="2" id="panelOpcionesAntecedentesTransfusionales"
                 rendered="#{antecedentesUsuarioDetalladoBean.renderTransfusionales}">
      <h:outputText value="Descripcion:" styleClass="labelTextOblig"
                    rendered="#{antecedentesUsuarioDetalladoBean.renderTransfusionales}"/>
      <h:panelGroup>
        <h:inputTextarea id="transfusionalesDecrip" immediate="true"
                         required="#{antecedentesUsuarioDetalladoBean.renderTransfusionales}"
                         rendered="#{antecedentesUsuarioDetalladoBean.renderTransfusionales}"
                         value="#{antecedentesUsuarioDetalladoBean.antedecentesDetallado.hadcanttrades}">
                           <f:validateLength maximum="250"/>
                         </h:inputTextarea>
        <a4j:outputPanel ajaxRendered="true" rendered="#{antecedentesUsuarioDetalladoBean.renderTransfusionales}">
          <t:message for="transfusionalesDecrip" styleClass="errorMessage"/>
        </a4j:outputPanel>
      </h:panelGroup>
    </h:panelGrid>
  </h:panelGroup>
  <h:panelGroup>
  <h:outputText value="" rendered="#{!antecedentesUsuarioDetalladoBean.renderTransfusionales}"/>
  </h:panelGroup>
  <h:panelGroup>
    <h:outputText value="ITS" styleClass="labelTextOblig"/>
    <a4j:region renderRegionOnly="false">
      <h:selectOneRadio id="menuITS" immediate="true" required="true"
                        value="#{antecedentesUsuarioDetalladoBean.antedecentesDetallado.hadcantits}">
        <f:selectItems value="#{antecedentesUsuarioDetalladoBean.lstOpcionesAntecedentes}"/>
        <a4j:support id="supportmnuITS" event="onclick" action="#{antecedentesUsuarioDetalladoBean.changeAntITS}"
                     reRender="panelGPreguntasITS,panelOpcionesAntecedentesITS">
          <a4j:ajaxListener type="org.ajax4jsf.ajax.ForceRender"/>
        </a4j:support>
      </h:selectOneRadio>
    </a4j:region>
    <a4j:outputPanel ajaxRendered="true">
      <t:message for="menuTransfusionales" styleClass="errorMessage"/>
    </a4j:outputPanel>
  </h:panelGroup>
  <h:panelGroup id="panelGPreguntasITS">
    <h:panelGrid columns="1" border="0" cellpadding="0" cellspacing="2" id="panelOpcionesAntecedentesITS"
                 rendered="#{antecedentesUsuarioDetalladoBean.renderITS}">
      <h:outputText value="Descripcion:" styleClass="labelTextOblig"
                    rendered="#{antecedentesUsuarioDetalladoBean.renderITS}"/>
      <h:panelGroup>
        <h:inputTextarea id="ITSDecrip" immediate="true" required="#{antecedentesUsuarioDetalladoBean.renderITS}"
                         rendered="#{antecedentesUsuarioDetalladoBean.renderITS}"
                         value="#{antecedentesUsuarioDetalladoBean.antedecentesDetallado.hadcantitsdes}">
                           <f:validateLength maximum="250"/>
                         </h:inputTextarea>
        <a4j:outputPanel ajaxRendered="true" rendered="#{antecedentesUsuarioDetalladoBean.renderITS}">
          <t:message for="ITSDecrip" styleClass="errorMessage"/>
        </a4j:outputPanel>
      </h:panelGroup>
    </h:panelGrid>
  </h:panelGroup>
   <h:panelGroup>
  <h:outputText value="" rendered="#{!antecedentesUsuarioDetalladoBean.renderITS}"/>
    </h:panelGroup>
  <h:panelGroup>
    <h:outputText value="Farmacológicos" styleClass="labelTextOblig"/>
    <a4j:region renderRegionOnly="false">
      <h:selectOneRadio id="menuFarmacologicos" immediate="true" required="true"
                        value="#{antecedentesUsuarioDetalladoBean.antedecentesDetallado.hadcantefarm}">
        <f:selectItems value="#{antecedentesUsuarioDetalladoBean.lstOpcionesAntecedentes}"/>
        <a4j:support id="supportmnuFarmacologicos" event="onclick"
                     action="#{antecedentesUsuarioDetalladoBean.changeAntFarmacologicos}"
                     reRender="panelGPreguntasFarmacologicos,panelOpcionesAntecedentesFarmacologicos">
          <a4j:ajaxListener type="org.ajax4jsf.ajax.ForceRender"/>
        </a4j:support>
      </h:selectOneRadio>
    </a4j:region>
    <a4j:outputPanel ajaxRendered="true">
      <t:message for="menuFarmacologicos" styleClass="errorMessage"/>
    </a4j:outputPanel>
  </h:panelGroup>
  <h:panelGroup id="panelGPreguntasFarmacologicos">
    <h:panelGrid columns="1" border="0" cellpadding="0" cellspacing="2" id="panelOpcionesAntecedentesFarmacologicos"
                 rendered="#{antecedentesUsuarioDetalladoBean.renderFarmacologicos}">
      <h:outputText value="Descripcion:" styleClass="labelTextOblig"
                    rendered="#{antecedentesUsuarioDetalladoBean.renderFarmacologicos}"/>
      <h:panelGroup>
        <h:inputTextarea id="farmacologicosDecrip" immediate="true"
                         required="#{antecedentesUsuarioDetalladoBean.renderFarmacologicos}"
                         rendered="#{antecedentesUsuarioDetalladoBean.renderFarmacologicos}"
                         value="#{antecedentesUsuarioDetalladoBean.antedecentesDetallado.hadcantfardes}">
                           <f:validateLength maximum="250"/>
                         </h:inputTextarea>
        <a4j:outputPanel ajaxRendered="true" rendered="#{antecedentesUsuarioDetalladoBean.renderFarmacologicos}">
          <t:message for="farmacologicosDecrip" styleClass="errorMessage"/>
        </a4j:outputPanel>
      </h:panelGroup>
    </h:panelGrid>
  </h:panelGroup>
  <h:panelGroup>
  <h:outputText value="" rendered="#{!antecedentesUsuarioDetalladoBean.renderFarmacologicos}"/>
  </h:panelGroup>
  <h:panelGroup>
    <h:outputText value="Traumáticos" styleClass="labelTextOblig"/>
    <a4j:region renderRegionOnly="false">
      <h:selectOneRadio id="menuTraumaticos" immediate="true" required="true"
                        value="#{antecedentesUsuarioDetalladoBean.antedecentesDetallado.hadcantetrau}">
        <f:selectItems value="#{antecedentesUsuarioDetalladoBean.lstOpcionesAntecedentes}"/>
        <a4j:support id="supportmnuTraumaticos" event="onclick"
                     action="#{antecedentesUsuarioDetalladoBean.changeAntTraumaticos}"
                     reRender="panelGPreguntasTraumaticos,panelOpcionesAntecedentesTraumaticos">
          <a4j:ajaxListener type="org.ajax4jsf.ajax.ForceRender"/>
        </a4j:support>
      </h:selectOneRadio>
    </a4j:region>
    <a4j:outputPanel ajaxRendered="true">
      <t:message for="menuTraumaticos" styleClass="errorMessage"/>
    </a4j:outputPanel>
  </h:panelGroup>
  <h:panelGroup id="panelGPreguntasTraumaticos">
    <h:panelGrid columns="1" border="0" cellpadding="0" cellspacing="2" id="panelOpcionesAntecedentesTraumaticos"
                 rendered="#{antecedentesUsuarioDetalladoBean.renderTraumaticos}">
      <h:outputText value="Descripcion:" styleClass="labelTextOblig"
                    rendered="#{antecedentesUsuarioDetalladoBean.renderTraumaticos}"/>
      <h:panelGroup>
        <h:inputTextarea id="traumaticosDecrip" immediate="true"
                         required="#{antecedentesUsuarioDetalladoBean.renderTraumaticos}"
                         rendered="#{antecedentesUsuarioDetalladoBean.renderTraumaticos}"
                         value="#{antecedentesUsuarioDetalladoBean.antedecentesDetallado.hadctraantdesc}">
                           <f:validateLength maximum="250"/>
                         </h:inputTextarea>
        <a4j:outputPanel ajaxRendered="true" rendered="#{antecedentesUsuarioDetalladoBean.renderTraumaticos}">
          <t:message for="traumaticosDecrip" styleClass="errorMessage"/>
        </a4j:outputPanel>
      </h:panelGroup>
    </h:panelGrid>
  </h:panelGroup>
  <h:panelGroup>
  <h:outputText value="" rendered="#{!antecedentesUsuarioDetalladoBean.renderTraumaticos}"/>
  </h:panelGroup>
  <h:panelGroup>
    <h:outputText value="Familiares" styleClass="labelTextOblig"/>
    <a4j:region renderRegionOnly="false">
      <h:selectOneRadio id="menuFamiliar" immediate="true" required="true"
                        value="#{antecedentesUsuarioDetalladoBean.antedecentesDetallado.hadcantefami}">
        <f:selectItems value="#{antecedentesUsuarioDetalladoBean.lstOpcionesAntecedentes}"/>
        <a4j:support id="supportmnuFamiliar" event="onclick"
                     action="#{antecedentesUsuarioDetalladoBean.changeAntFamiliares}"
                     reRender="panelGPreguntasFamiliar,panelDescripFami">
          <a4j:ajaxListener type="org.ajax4jsf.ajax.ForceRender"/>
        </a4j:support>
      </h:selectOneRadio>
    </a4j:region>
    <a4j:outputPanel ajaxRendered="true">
      <t:message for="menuFamiliar" styleClass="errorMessage"/>
    </a4j:outputPanel>
  </h:panelGroup>
  <h:panelGrid id="panelDescripFami" columns="1" border="0" cellpadding="0" cellspacing="2">
    <h:outputText value="Descripcion:" styleClass="labelTextOblig"
                  rendered="#{antecedentesUsuarioDetalladoBean.renderFamiliar}"/>
    <h:panelGroup>
      <h:inputTextarea id="famiText" immediate="true" required="#{antecedentesUsuarioDetalladoBean.renderFamiliar}"
                       rendered="#{antecedentesUsuarioDetalladoBean.renderFamiliar}"
                       value="#{antecedentesUsuarioDetalladoBean.antedecentesDetallado.hadcfamdes}">
                         <f:validateLength maximum="250"/>
                       </h:inputTextarea>
      <a4j:outputPanel ajaxRendered="true" rendered="#{antecedentesUsuarioDetalladoBean.renderFamiliar}">
        <t:message for="famiText" styleClass="errorMessage"/>
      </a4j:outputPanel>
    </h:panelGroup>
  </h:panelGrid>
  <h:panelGroup id="panelGPreguntasFamiliar">
    <h:panelGrid columns="1" border="0" cellpadding="0" cellspacing="0" id="panelOpcionesAntecedentesFamiliar"
                 rendered="#{antecedentesUsuarioDetalladoBean.renderFamiliar}">
      <h:panelGroup>
        <a4j:region renderRegionOnly="false">
          <h:selectManyCheckbox required="false" style="border-style:none;" immediate="true" id="mnuPreguntasFamiliares"
                                value="#{antecedentesUsuarioDetalladoBean.lstFamiliaresIveSelected}"
                                valueChangeListener="#{antecedentesUsuarioDetalladoBean.setPreguntasFamiliaresIveSelected}"
                                layout="pageDirection">
            <f:selectItems value="#{antecedentesUsuarioDetalladoBean.lstFamiliaresIve}"/>
            <a4j:support id="supportmnuListaFamiliares" event="onclick" immediate="true"
                         action="#{antecedentesUsuarioDetalladoBean.changePreguntasAnteceFamiliares}">
              <a4j:ajaxListener type="org.ajax4jsf.ajax.ForceRender"/>
            </a4j:support>
          </h:selectManyCheckbox>
        </a4j:region>
        <a4j:outputPanel ajaxRendered="true">
          <t:message for="mnuPreguntasFamiliares" styleClass="errorMessage"/>
        </a4j:outputPanel>
      </h:panelGroup>
    </h:panelGrid>
  </h:panelGroup>
</h:panelGrid>