<%@ page contentType="text/html;charset=iso-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsf/html" prefix="h"%>
<%@ taglib uri="http://java.sun.com/jsf/core" prefix="f"%>
<%@ taglib uri="http://richfaces.org/a4j" prefix="a4j"%>
<%@ taglib uri="http://myfaces.apache.org/tomahawk" prefix="t"%>
<%@ taglib uri="http://myfaces.apache.org/sandbox" prefix="s"%>

 
    <h:panelGrid columns="1" id="panelHisteroscopia">
      <h:outputText id="InterPr" value="Intervenciones Propuestas:" styleClass="labelTextOblig"/>
      <h:panelGroup>
        <h:inputTextarea id="textInterHisteroscopia" value="#{descripcionQuirurgicaBean.histeroscopia.hhtcintpro}"
                         style="width:650px;height:70px" required="true"/>
        <a4j:outputPanel ajaxRendered="true">
          <t:message for="textInterHisteroscopia" styleClass="errorMessage"/>
        </a4j:outputPanel>
      </h:panelGroup>
      <h:panelGroup>
        <h:panelGrid columns="2" id="panelMedioDistincion" border="0" cellpadding="0" cellspacing="0"
                     rowClasses="labelText,labelTextInfo">
          <h:outputText id="menuMedioDist" value="Medio Distención:" styleClass="labelTextOblig"/>
          <h:panelGroup>
            <a4j:region renderRegionOnly="false">
              <h:selectOneMenu id="idMedioDistencion" immediate="true"
                               value="#{descripcionQuirurgicaBean.histeroscopia.hhtcmedidist}"
                               valueChangeListener="#{descripcionQuirurgicaBean.setHhtcmedidist}">
                <f:selectItems value="#{descripcionQuirurgicaBean.lstMedioDistencion}"/>
                <a4j:support id="supportMenuMedioDistin" event="onchange" ignoreDupResponses="true"
                             action="#{descripcionQuirurgicaBean.changeMedioDistincion}" reRender="panelBalance">
                  <a4j:ajaxListener type="org.ajax4jsf.ajax.ForceRender"/>
                </a4j:support>
              </h:selectOneMenu>
            </a4j:region>
            <a4j:outputPanel ajaxRendered="true">
              <t:message for="idMedioDistencion" styleClass="errorMessage"/>
            </a4j:outputPanel>
          </h:panelGroup>
          
          <h:outputText value="Cantidad Irrigada en ml:" styleClass="labelTextOblig"/>
          <h:panelGroup>
            <h:inputText id="textCantidadIrr" onkeydown="return blockEnter(event);" immediate="true"
                         binding="#{descripcionQuirurgicaBean.itCantIrrigada}" required="false"
                         title="Cantidad Irrigada en ml" maxlength="5" style="width:50px;height:20px"
                         value="#{descripcionQuirurgicaBean.histeroscopia.hhtlcantirri}"
                         valueChangeListener="#{descripcionQuirurgicaBean.setCantIrrigada}">
              <a4j:support id="supportCantidadIrr" event="onchange" oncomplete="jsFunction()"
                           action="#{descripcionQuirurgicaBean.changeCantidadIrrig}"
                           reRender="panelBalance,panelHisteroscopia,panelMensaje">
                <a4j:ajaxListener type="org.ajax4jsf.ajax.ForceRender"/>
              </a4j:support>
            </h:inputText>
            <a4j:outputPanel ajaxRendered="true">
              <t:message for="textCantidadIrr" styleClass="errorMessage"/>
            </a4j:outputPanel>
          </h:panelGroup>
          
          <h:outputText value="Cantidad Recolectada en ml:" styleClass="labelTextOblig"/>
          <h:panelGroup>
            <h:inputText id="textCantidadRec" onkeydown="return blockEnter(event);" immediate="true"
                         binding="#{descripcionQuirurgicaBean.itCantRecolectada}" required="false"
                         title="Cantidad Recolectada en ml" maxlength="5" style="width:50px;height:20px"
                         value="#{descripcionQuirurgicaBean.histeroscopia.httlcantreco}"
                         valueChangeListener="#{descripcionQuirurgicaBean.setCantRecolectada}">
              <a4j:support id="supportCantidadRec" event="onchange" oncomplete="jsFunction()"
                           action="#{descripcionQuirurgicaBean.changeBalance}"
                           reRender="panelBalance,panelHisteroscopia,panelMensaje">
                <a4j:ajaxListener type="org.ajax4jsf.ajax.ForceRender"/>
              </a4j:support>
            </h:inputText>
            <a4j:outputPanel ajaxRendered="true">
              <t:message for="textCantidadRec" styleClass="errorMessage"/>
            </a4j:outputPanel>
          </h:panelGroup>
        </h:panelGrid>
        <h:panelGrid id="panelBalance" columns="2">
          <h:outputText value="Balance:" styleClass="labelTextOblig"/>
          <h:outputText id="textBalance"
                        value="#{descripcionQuirurgicaBean.histeroscopia.httlbalance} - #{descripcionQuirurgicaBean.histeroscopia.httlbalposneg}"
                        style="width:80px;height:20px"/>
        </h:panelGrid>
        <h:panelGroup id="panelMensaje">
          <h:outputText id="msgElectrolitros" value="#{descripcionQuirurgicaBean.msgElectrolitros}" style="color:blue"/>
        </h:panelGroup>
      </h:panelGroup>
    </h:panelGrid>