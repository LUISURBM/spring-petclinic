<%@ page contentType="text/html;charset=iso-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsf/html" prefix="h"%>
<%@ taglib uri="http://richfaces.org/a4j" prefix="a4j"%>
<%@ taglib uri="http://myfaces.apache.org/tomahawk" prefix="t"%>
<%@ taglib uri="http://myfaces.apache.org/sandbox" prefix="s"%>
<%@ taglib uri="http://java.sun.com/jsf/core" prefix="f"%>
<a4j:form id="formExamenFisicoMama">
 <a4j:region id="regionExamenFisicoMama" renderRegionOnly="false">
    <a4j:status  id = "statusButton" for="regionExamenFisicoMama">
      <f:facet name="start">
        <t:div id="chargingExamenFisicoMama" styleClass="loading">
          <h:panelGrid columns="1" cellpadding="0" cellspacing="0" border="0">
            <h:outputText value="Procesando..."/>
            <h:outputText value="Por favor espere."/>
          </h:panelGrid>
        </t:div>
      </f:facet>
      <f:facet name="stop"/>
    </a4j:status>

  
         <h:panelGrid columns="1" border="0" cellpadding="0" cellspacing="0"
               width="100%" id="panelGridExamenFisicoMamaTab"
               styleClass="tabContainer">
    <t:panelTabbedPane border="0" cellpadding="0" cellspacing="0"
                       serverSideTabSwitch="false" activePanelTabVar="true"
                       width="100%" id="panelTabbedPaneExamenFisicoMama"
                       styleClass="tabbedPane" activeTabStyleClass="activeTab"
                       inactiveTabStyleClass="inactiveTab"
                       disabledTabStyleClass="disabledTab"
                       activeSubStyleClass="activeSub"
                       inactiveSubStyleClass="inactiveSub"
                       tabContentStyleClass="tabContent">
      <t:panelTab id="panelTabExamenFisicoMama" label="Examen Fisico Mama">
                <h:panelGrid columns="1" border="0" cellpadding="0"
                             cellspacing="0" width="100%"
                             id="tableContentTabsExamenFisicoMama"
                             styleClass="tabContainer">
                        <s:fieldset legend="Examen Mama Derecha"
                                    id="fieldMamaDer" styleClass="fieldset">
                                <h:panelGrid columns="3" border="0"
                                             rendered="#{examenFisicoMamaBean.mostrarMamaDerecha}"
                                             cellpadding="0" cellspacing="0"
                                             width="100%" id="panelImagenes"
                                             rowClasses="labelText,labelTextInfo">
                                        <h:graphicImage url="/comun/imagenes/1.gif"/>
                                        <h:outputText value =""/>
                                        <h:graphicImage url="/comun/imagenes/3.gif"/>
                                </h:panelGrid>
                                <h:panelGrid columns="3" border="0"
                                             cellpadding="0" cellspacing="0"
                                             width="100%"
                                             id="panelDatosExamenMamaDerecha"
                                             rowClasses="labelText,labelTextInfo">
                                        <h:outputText value="Examen de Mama Derecha"
                                                      styleClass="labelTextOblig"/>
                                        <h:outputText/>
                                         <h:outputText/>
                                        <a4j:region renderRegionOnly="false">
                                                <h:panelGroup>
                                                        <h:selectOneMenu id="mnuExamenMamaDer"
                                                                         required="true"
                                                                         immediate="true"
                                                                         value="#{examenFisicoMamaBean.estadoDerSelect}"
                                                                         valueChangeListener="#{examenFisicoMamaBean.setEstadoDerSelect}">
                                                                <f:selectItems value="#{examenFisicoMamaBean.lstEstado}"/>
                                                                <a4j:support id="supportcheckExamenMamaDer"
                                                                             event="onchange"
                                                                             action="#{examenFisicoMamaBean.changeMamaDerecha}"
                                                                             
                                                                             reRender="fieldMamaDer">
                                                                        <a4j:ajaxListener type="org.ajax4jsf.ajax.ForceRender"/>
                                                                </a4j:support>
                                                        </h:selectOneMenu>
                                                        <a4j:outputPanel ajaxRendered="true">
                                                                <t:message for="mnuExamenMamaDer"
                                                                           styleClass="errorMessage"/>
                                                        </a4j:outputPanel>
                                                </h:panelGroup>
                                        </a4j:region>
                                        <h:outputText/>
                                         <h:outputText/>
                                        <h:panelGroup>
                                                <h:outputText value="Lesión Pezón"
                                                              rendered="#{examenFisicoMamaBean.mostrarMamaDerecha}"/>
                                        </h:panelGroup>
                                        <h:panelGroup id="panelTextLesion">
                                                <h:outputText value="Tipo Lesión"
                                                              styleClass="labelTextOblig"
                                                              rendered="#{examenFisicoMamaBean.lesionPesonDerecho}"/>
                                        </h:panelGroup>
                                         <h:outputText/>
                                        <a4j:region renderRegionOnly="false">
                                                <h:panelGroup>
                                                        <h:selectOneRadio id="checkPesonDerecho"
                                                                                 rendered="#{examenFisicoMamaBean.mostrarMamaDerecha}"
                                                                                 value="#{examenFisicoMamaBean.examen.hemelespezonde}"
                                                                                 valueChangeListener="#{examenFisicoMamaBean.setLesionPesonDerecho}"
                                                                                 immediate="true">
                                                                                   <f:selectItems value="#{examenFisicoMamaBean.lstOpciones}"/>
                                                                <a4j:support id="supportcheckPesonDerecho"
                                                                             event="onclick"
                                                                             action="#{examenFisicoMamaBean.changePezonDerecho}"
                                                                             
                                                                             reRender="panelTextLesion,panelMenuLesion">
                                                                        <a4j:ajaxListener type="org.ajax4jsf.ajax.ForceRender"/>
                                                                </a4j:support>
                                                        </h:selectOneRadio>
                                                </h:panelGroup>
                                        </a4j:region>
                                        <h:panelGroup id="panelMenuLesion">
                                                <h:inputTextarea id="itTipoLesionPezonDer"
                                                                 style="width:300px"
                                                                 value="#{examenFisicoMamaBean.examen.hemctipolepede}"
                                                                 required="true"
                                                                 rendered="#{examenFisicoMamaBean.lesionPesonDerecho}"/>
                                                <a4j:outputPanel ajaxRendered="true">
                                                        <t:message for="itTipoLesionPezonDer"
                                                                   styleClass="errorMessage"/>
                                                </a4j:outputPanel>
                                        </h:panelGroup>
                                         <h:outputText/>
                                        <h:panelGroup>
                                                <h:outputText value="Lesión Mama"
                                                              rendered="#{examenFisicoMamaBean.mostrarMamaDerecha}"/>
                                        </h:panelGroup>
                                        <h:panelGroup id = "panelTextZonaLesionDerecho">
                                                <h:outputText value="Zona Lesión"
                                                              rendered="#{examenFisicoMamaBean.lesionMamaDerecha}"/>
                                        </h:panelGroup>
                                         <h:panelGroup id = "panelTextCuadranteDerecho">
                                                <h:outputText value="Cuadrante"
                                                              rendered="#{examenFisicoMamaBean.lesionMamaDerecha}"/>
                                        </h:panelGroup>
                                        <a4j:region renderRegionOnly="false">
                                        <h:panelGroup>
                                                <h:selectOneRadio id="checkMamaDerecha" 
                                                                        immediate="true"
                                                                         rendered="#{examenFisicoMamaBean.mostrarMamaDerecha}"
                                                                         value="#{examenFisicoMamaBean.examen.hemelesimamade}"
                                                                        valueChangeListener="#{examenFisicoMamaBean.setLesionMamaDerecha}">
                                                        <f:selectItems value="#{examenFisicoMamaBean.lstOpciones}"/>
                                                        <a4j:support id="supportcheckMamaDer"
                                                                             event="onclick"
                                                                             
                                                                             action = "#{examenFisicoMamaBean.changeZonaDerecha}"
                                                                             reRender="panelTextZonaLesionDerecho,panelTextCuadranteDerecho,panelMenuZonaLesion,panelMenuCuadrante">
                                                                        <a4j:ajaxListener type="org.ajax4jsf.ajax.ForceRender"/>
                                                                </a4j:support>
                                                         </h:selectOneRadio>
                                        </h:panelGroup>
                                        </a4j:region>
                                           <h:panelGroup id="panelMenuZonaLesion">
                                                <h:selectOneMenu id="mnuZonaLesion"
                                                                rendered="#{examenFisicoMamaBean.lesionMamaDerecha}"
                                                                 required="true"
                                                                 value="#{examenFisicoMamaBean.examen.hemczonalesder}">
                                                        <f:selectItems value="#{examenFisicoMamaBean.lstZonaLesion}"/>
                                                </h:selectOneMenu>
                                                <a4j:outputPanel ajaxRendered="true">
                                                        <t:message for="mnuTipoLesionPielDer"
                                                                   styleClass="errorMessage"/>
                                                </a4j:outputPanel>
                                        </h:panelGroup>
                                            <h:panelGroup id="panelMenuCuadrante">
                                                <h:selectOneMenu id="mnuCuadrante"
                                                                rendered="#{examenFisicoMamaBean.lesionMamaDerecha}"
                                                                 required="true"
                                                                 value="#{examenFisicoMamaBean.examen.hemccuadlesder}">
                                                        <f:selectItems value="#{examenFisicoMamaBean.lstCuadrante}"/>
                                                </h:selectOneMenu>
                                                <a4j:outputPanel ajaxRendered="true">
                                                        <t:message for="mnuTipoLesionPielDer"
                                                                   styleClass="errorMessage"/>
                                                </a4j:outputPanel>
                                        </h:panelGroup>
                                        <h:panelGroup>
                                                <h:outputText value="Lesión Axila"
                                                              rendered="#{examenFisicoMamaBean.mostrarMamaDerecha}"/>
                                        </h:panelGroup>
                                        <h:panelGroup id="outputTextLesionAxilaDerecha">
                                                <h:outputText value="Tipo Lesión Axila"
                                                              styleClass="labelTextOblig"
                                                              rendered="#{examenFisicoMamaBean.lesionAxilaDerecha}"/>
                                        </h:panelGroup>
                                         <h:outputText/>
                                        <a4j:region renderRegionOnly="false">
                                                <h:panelGroup>
                                                        <h:selectOneRadio id="checkAxilaDerecha"
                                                                                 rendered="#{examenFisicoMamaBean.mostrarMamaDerecha}"
                                                                                 value="#{examenFisicoMamaBean.examen.hemelesionaxde}"
                                                                                 valueChangeListener="#{examenFisicoMamaBean.setLesionAxilaDerecha}"
                                                                                 immediate="true">
                                                                 <f:selectItems value="#{examenFisicoMamaBean.lstOpciones}"/>
                                                                <a4j:support id="supportcheckAxilaDerecha"
                                                                             event="onclick"
                                                                             action="#{examenFisicoMamaBean.changeAxilaDerecha}"
                                                                             
                                                                             reRender="inputTextLesionAxilaDerecha,outputTextLesionAxilaDerecha">
                                                                        <a4j:ajaxListener type="org.ajax4jsf.ajax.ForceRender"/>
                                                                </a4j:support>
                                                        </h:selectOneRadio>
                                                </h:panelGroup>
                                        </a4j:region>
                                        <h:panelGroup id="inputTextLesionAxilaDerecha">
                                                <h:inputTextarea id="itTipoLesionAxilaDerecha"
                                                                 style="width:300px"
                                                                 value="#{examenFisicoMamaBean.examen.hemctipolesaxde}"
                                                                 required="true"
                                                                 rendered="#{examenFisicoMamaBean.lesionAxilaDerecha}"/>
                                                <a4j:outputPanel ajaxRendered="true">
                                                        <t:message for="itTipoLesionAxilaDerecha"
                                                                   styleClass="errorMessage"/>
                                                </a4j:outputPanel>
                                        </h:panelGroup>
                                         <h:outputText/>
                                </h:panelGrid>
                                <h:panelGrid columns="3" border="0"
                                             rendered="#{examenFisicoMamaBean.mostrarMamaDerecha}"
                                             cellpadding="0" cellspacing="0"
                                             width="100%" id="panelDatosLesion"
                                             rowClasses="labelText,labelTextInfo">
                                        <h:outputText value="Lesión en piel "
                                                      styleClass="labelTextOblig"/>
                                        <h:panelGroup id="panelTextTipoLesion">
                                                <h:outputText value="Tipo Lesión"
                                                              styleClass="labelTextOblig"
                                                              rendered="#{examenFisicoMamaBean.mostrarLesionPielDerecho}"/>
                                        </h:panelGroup>
                                        <h:outputText/>
                                        <a4j:region renderRegionOnly="false">
                                                <h:panelGroup>
                                                        <h:selectOneRadio id="mnuLesionPielDer"
                                                                          required="true"
                                                                          immediate="true"
                                                                          value="#{examenFisicoMamaBean.lesionPielDerecha}"
                                                                          valueChangeListener="#{examenFisicoMamaBean.setLesionPielDerecha}">
                                                                <f:selectItems value="#{examenFisicoMamaBean.lstOpciones}"/>
                                                                <a4j:support id="supportcheckLesionPielDerecha"
                                                                             event="onclick"
                                                                             action="#{examenFisicoMamaBean.changeLesionPielDerecha}"
                                                                             
                                                                             reRender="panelTextTipoLesion,panelMenuTipoLesion">
                                                                        <a4j:ajaxListener type="org.ajax4jsf.ajax.ForceRender"/>
                                                                </a4j:support>
                                                        </h:selectOneRadio>
                                                        <a4j:outputPanel ajaxRendered="true">
                                                                <t:message for="mnuLesionPielDer"
                                                                           styleClass="errorMessage"/>
                                                        </a4j:outputPanel>
                                                </h:panelGroup>
                                        </a4j:region>
                                        <h:panelGroup id="panelMenuTipoLesion">
                                                <h:selectOneMenu id="mnuTipoLesionPielDer"
                                                                 rendered="#{examenFisicoMamaBean.mostrarLesionPielDerecho}"
                                                                 required="true"
                                                                 value="#{examenFisicoMamaBean.examen.hemetipolepide}">
                                                        <f:selectItems value="#{examenFisicoMamaBean.lstTipoLesion}"/>
                                                </h:selectOneMenu>
                                                <a4j:outputPanel ajaxRendered="true">
                                                        <t:message for="mnuTipoLesionPielDer"
                                                                   styleClass="errorMessage"/>
                                                </a4j:outputPanel>
                                        </h:panelGroup>
                                        <h:outputText/>
                                        <h:outputText value="Tiene Secreción"
                                                      styleClass="labelTextOblig"/>
                                        <h:panelGroup id="panelTextSecrecion">
                                                <h:outputText value="Secreción"
                                                              styleClass="labelTextOblig"
                                                              rendered="#{examenFisicoMamaBean.mostrarSecrecionDerecha}"/>
                                        </h:panelGroup>
                                        <h:panelGroup id="panelTextTipoSecrecion">
                                                <h:outputText value="Tipo Secreción"
                                                              styleClass="labelTextOblig"
                                                              rendered="#{examenFisicoMamaBean.mostrarSecrecionDerecha}"/>
                                        </h:panelGroup>
                                        <a4j:region renderRegionOnly="false">
                                                <h:panelGroup>
                                                        <h:selectOneRadio id="mnuTieneSecrecion"
                                                                          immediate="true"
                                                                          required="true"
                                                                          value="#{examenFisicoMamaBean.secrecionDerecha}"
                                                                          valueChangeListener="#{examenFisicoMamaBean.setSecrecionDerecha}">
                                                                <f:selectItems value="#{examenFisicoMamaBean.lstOpciones}"/>
                                                                <a4j:support id="supportcheckTieneSecrecionDerecha"
                                                                             event="onclick"
                                                                             action="#{examenFisicoMamaBean.changeSecrecionDerecha}"
                                                                             
                                                                             reRender="panelTextSecrecion,panelTextTipoSecrecion,panelMenuSecrecion,panelMenuTipoSecrecion">
                                                                        <a4j:ajaxListener type="org.ajax4jsf.ajax.ForceRender"/>
                                                                </a4j:support>
                                                        </h:selectOneRadio>
                                                        <a4j:outputPanel ajaxRendered="true">
                                                                <t:message for="mnuTieneSecrecion"
                                                                           styleClass="errorMessage"/>
                                                        </a4j:outputPanel>
                                                </h:panelGroup>
                                        </a4j:region>
                                        <h:panelGroup id="panelMenuSecrecion">
                                                <h:selectOneMenu id="mnuSecrecionDe"
                                                                 rendered="#{examenFisicoMamaBean.mostrarSecrecionDerecha}"
                                                                 required="true"
                                                                 value="#{examenFisicoMamaBean.examen.hemesecreciode}">
                                                        <f:selectItems value="#{examenFisicoMamaBean.lstSecrecion}"/>
                                                </h:selectOneMenu>
                                                <a4j:outputPanel ajaxRendered="true">
                                                        <t:message for="mnuSecrecionDe"
                                                                   styleClass="errorMessage"/>
                                                </a4j:outputPanel>
                                        </h:panelGroup>
                                        <h:panelGroup id="panelMenuTipoSecrecion">
                                                <h:selectOneMenu id="mnuTipoSecrecionDe"
                                                                 rendered="#{examenFisicoMamaBean.mostrarSecrecionDerecha}"
                                                                 required="true"
                                                                 value="#{examenFisicoMamaBean.examen.hemetiposecrde}">
                                                        <f:selectItems value="#{examenFisicoMamaBean.lstTipoSecrecion}"/>
                                                </h:selectOneMenu>
                                                <a4j:outputPanel ajaxRendered="true">
                                                        <t:message for="mnuTipoSecrecionDe"
                                                                   styleClass="errorMessage"/>
                                                </a4j:outputPanel>
                                        </h:panelGroup>
                                        <h:outputText value="Masa "
                                                      styleClass="labelTextOblig"/>
                                        <h:panelGroup id="panelTextDiametro">
                                                <h:outputText value="Diametro apx en cm"
                                                              styleClass="labelTextOblig"
                                                              rendered="#{examenFisicoMamaBean.mostrarMasaDerecha}"/>
                                        </h:panelGroup>
                                        <h:outputText value=""/>
                                        <a4j:region renderRegionOnly="false">
                                                <h:panelGroup>
                                                        <h:selectOneRadio id="mnuMasaDe"
                                                                          immediate="true"
                                                                          required="true"
                                                                          value="#{examenFisicoMamaBean.masaDerecha}"
                                                                          valueChangeListener="#{examenFisicoMamaBean.setMasaDerecha}">
                                                                <f:selectItems value="#{examenFisicoMamaBean.lstOpciones}"/>
                                                                <a4j:support id="supportcheckMasaDerecha"
                                                                             event="onclick"
                                                                             action="#{examenFisicoMamaBean.changeMasaDerecha}"
                                                                             
                                                                             reRender="panelTextDiametro,panelInputDiametro">
                                                                        <a4j:ajaxListener type="org.ajax4jsf.ajax.ForceRender"/>
                                                                </a4j:support>
                                                        </h:selectOneRadio>
                                                        <a4j:outputPanel ajaxRendered="true">
                                                                <t:message for="mnuMasaDe"
                                                                           styleClass="errorMessage"/>
                                                        </a4j:outputPanel>
                                                </h:panelGroup>
                                        </a4j:region>
                                        <h:panelGroup id="panelInputDiametro">
                                                <h:inputText id="itDiametroMasaDerecha"
                                                             value="#{examenFisicoMamaBean.examen.hemndiammasade}"
                                                             required="true"
                                                             maxlength="2"
                                                             onkeydown="return blockEnter(event);"
                                                             style="width:30px"
                                                             rendered="#{examenFisicoMamaBean.mostrarMasaDerecha}"/>
                                                <a4j:outputPanel ajaxRendered="true">
                                                        <t:message for="itDiametroMasaDerecha"
                                                                   styleClass="errorMessage"/>
                                                </a4j:outputPanel>
                                        </h:panelGroup>
                                        <h:outputText value=""/>
                                        <h:outputText value="Dolorosa "
                                                      styleClass="labelTextOblig"/>
                                        <h:panelGroup id="panelTextTipoDolor">
                                                <h:outputText value="Tipo Dolor"
                                                              styleClass="labelTextOblig"
                                                              rendered="#{examenFisicoMamaBean.mostrarDolorDerecho}"/>
                                        </h:panelGroup>
                                        <h:outputText value=""/>
                                        <a4j:region renderRegionOnly="false">
                                                <h:panelGroup>
                                                        <h:selectOneRadio id="mnuDolorDe"
                                                                          immediate="true"
                                                                          required="true"
                                                                          value="#{examenFisicoMamaBean.dolorDerecho}"
                                                                          valueChangeListener="#{examenFisicoMamaBean.setDolorDerecho}">
                                                                <f:selectItems value="#{examenFisicoMamaBean.lstOpciones}"/>
                                                                <a4j:support id="supportDolorDerecho"
                                                                             event="onclick"
                                                                             action="#{examenFisicoMamaBean.changeDolorDerecho}"
                                                                            
                                                                             reRender="panelTextTipoDolor,panelCheckTipoDolor">
                                                                        <a4j:ajaxListener type="org.ajax4jsf.ajax.ForceRender"/>
                                                                </a4j:support>
                                                        </h:selectOneRadio>
                                                        <a4j:outputPanel ajaxRendered="true">
                                                                <t:message for="mnuDolorDe"
                                                                           styleClass="errorMessage"/>
                                                        </a4j:outputPanel>
                                                </h:panelGroup>
                                        </a4j:region>
                                        <h:panelGroup id="panelCheckTipoDolor">
                                                <h:inputTextarea id="itDolorDerecho"
                                                                 style="width:300px"
                                                                 value="#{examenFisicoMamaBean.examen.hemctipodolode}"
                                                                 required="true"
                                                                 rendered="#{examenFisicoMamaBean.mostrarDolorDerecho}"/>
                                                <a4j:outputPanel ajaxRendered="true">
                                                        <t:message for="itDolorDerecho"
                                                                   styleClass="errorMessage"/>
                                                </a4j:outputPanel>
                                        </h:panelGroup>
                                </h:panelGrid>
                        </s:fieldset>
                        <s:fieldset legend="Examen Mama Izquierda"
                                    id="fieldMamaIzq" styleClass="fieldset">
                                <h:panelGrid columns="3" border="0"
                                             rendered="#{examenFisicoMamaBean.mostrarMamaIzquierda}"
                                             cellpadding="0" cellspacing="0"
                                             width="100%"
                                             id="panelImagenesIzquierda"
                                             rowClasses="labelText,labelTextInfo">
                                        <h:graphicImage url="/comun/imagenes/6.gif"/>
                                        <h:panelGroup/>
                                        <h:graphicImage url="/comun/imagenes/4.gif"/>
                                </h:panelGrid>
                                <h:panelGrid columns="3" border="0"
                                             cellpadding="0" cellspacing="0"
                                             width="100%"
                                             id="panelDatosExamenMamaIzquierda"
                                             rowClasses="labelText,labelTextInfo">
                                        <h:outputText value="Examen de Mama Izquierda"
                                                      styleClass="labelTextOblig"/>
                                        <h:outputText/>
                                         <h:outputText/>
                                        <a4j:region renderRegionOnly="false">
                                                <h:panelGroup>
                                                        <h:selectOneMenu id="mnuExamenMamaIzq"
                                                                         required="true"
                                                                         immediate="true"
                                                                         value="#{examenFisicoMamaBean.estadoIzqSelect}"
                                                                         valueChangeListener="#{examenFisicoMamaBean.setEstadoIzqSelect}">
                                                                <f:selectItems value="#{examenFisicoMamaBean.lstEstado}"/>
                                                                <a4j:support id="supportcheckExamenMamaIzq"
                                                                             event="onchange"
                                                                             action="#{examenFisicoMamaBean.changeMamaIzquierda}"
                                                                             
                                                                             reRender="fieldMamaIzq">
                                                                        <a4j:ajaxListener type="org.ajax4jsf.ajax.ForceRender"/>
                                                                </a4j:support>
                                                        </h:selectOneMenu>
                                                        <a4j:outputPanel ajaxRendered="true">
                                                                <t:message for="mnuExamenMamaIzq"
                                                                           styleClass="errorMessage"/>
                                                        </a4j:outputPanel>
                                                </h:panelGroup>
                                        </a4j:region>
                                        <h:outputText/>
                                         <h:outputText/>
                                        <h:panelGroup>
                                                <h:outputText value="Pezón"
                                                              rendered="#{examenFisicoMamaBean.mostrarMamaIzquierda}"/>
                                        </h:panelGroup>
                                        <h:panelGroup id="panelTextLesionIzq">
                                                <h:outputText value="Tipo Lesión"
                                                              styleClass="labelTextOblig"
                                                              rendered="#{examenFisicoMamaBean.lesionPesonIzquierdo}"/>
                                        </h:panelGroup>
                                         <h:outputText/>
                                        <a4j:region renderRegionOnly="false">
                                                <h:panelGroup>
                                                        <h:selectOneRadio id="checkPesonIzquierdo"
                                                                                 rendered="#{examenFisicoMamaBean.mostrarMamaIzquierda}"
                                                                                 value="#{examenFisicoMamaBean.examen.hemelespezoniz}"
                                                                                 valueChangeListener="#{examenFisicoMamaBean.setLesionPesonIzquierdo}"
                                                                                 immediate="true">
                                                                <f:selectItems value="#{examenFisicoMamaBean.lstOpciones}"/>
                                                                <a4j:support id="supportcheckPesonIzquierdo"
                                                                             event="onclick"
                                                                             
                                                                             action="#{examenFisicoMamaBean.changePezonIzquierdo}"
                                                                             reRender="panelTextLesionIzq,panelMenuLesionIzq">
                                                                        <a4j:ajaxListener type="org.ajax4jsf.ajax.ForceRender"/>
                                                                </a4j:support>
                                                        </h:selectOneRadio>
                                                        <a4j:outputPanel ajaxRendered="true">
                                                                <t:message for="checkPesonIzquierdo"
                                                                           styleClass="errorMessage"/>
                                                        </a4j:outputPanel>
                                                </h:panelGroup>
                                        </a4j:region>
                                        <h:panelGroup id="panelMenuLesionIzq">
                                                <h:inputTextarea id="itTipoLesionPezonIzquierdo"
                                                                 style="width:300px"
                                                                 required="true"
                                                                 value="#{examenFisicoMamaBean.examen.hemctipolepeiz}"
                                                                 rendered="#{examenFisicoMamaBean.lesionPesonIzquierdo}"/>
                                                <a4j:outputPanel ajaxRendered="true">
                                                        <t:message for="itTipoLesionPezonIzquierdo"
                                                                   styleClass="errorMessage"/>
                                                </a4j:outputPanel>
                                        </h:panelGroup>
                                         <h:outputText/>
                                        <h:panelGroup>
                                                <h:outputText value="Mama"
                                                              rendered="#{examenFisicoMamaBean.mostrarMamaIzquierda}"/>
                                        </h:panelGroup>
                                        <h:panelGroup id = "panelTextZonaLesionIzquierdo">
                                                <h:outputText value="Zona Lesión"
                                                              rendered="#{examenFisicoMamaBean.lesionMamaIzquierda}"/>
                                        </h:panelGroup>
                                         <h:panelGroup  id = "panelTextCuadranteIzquierdo">
                                                <h:outputText value="Cuadrante"
                                                              rendered="#{examenFisicoMamaBean.lesionMamaIzquierda}"/>
                                        </h:panelGroup>
                                        <a4j:region renderRegionOnly="false">
                                        <h:panelGroup>
                                                <h:selectOneRadio id="checkMamaIzquierda" immediate="true"
                                                                         rendered="#{examenFisicoMamaBean.mostrarMamaIzquierda}"
                                                                         value="#{examenFisicoMamaBean.examen.hemelesimamaiz}"
                                                                         valueChangeListener="#{examenFisicoMamaBean.setLesionMamaIzquierda}">
                                                                             <f:selectItems value="#{examenFisicoMamaBean.lstOpciones}"/>
                                                        <a4j:support id="supportcheckMamaDerecha"
                                                                             event="onclick"
                                                                                action = "#{examenFisicoMamaBean.changeZonaIzquierda}"
                                                                             
                                                                             reRender="panelTextZonaLesionIzquierdo,panelTextCuadranteIzquierdo,panelMenuZonaLesionIzquierda,panelMenuCuadranteIzquierda">
                                                                        <a4j:ajaxListener type="org.ajax4jsf.ajax.ForceRender"/>
                                                                </a4j:support>                     
                                                                         
                                                                         
                                                                         
                                                                         </h:selectOneRadio>
                                        </h:panelGroup>
                                        </a4j:region>
                                     <h:panelGroup id="panelMenuZonaLesionIzquierda">
                                                <h:selectOneMenu id="mnuZonaLesionIzquierda"
                                                                rendered="#{examenFisicoMamaBean.lesionMamaIzquierda}"
                                                                 required="true"
                                                                 value="#{examenFisicoMamaBean.examen.hemczonalesizq}">
                                                        <f:selectItems value="#{examenFisicoMamaBean.lstZonaLesion}"/>
                                                </h:selectOneMenu>
                                                <a4j:outputPanel ajaxRendered="true">
                                                        <t:message for="mnuZonaLesionIzquierda"
                                                                   styleClass="errorMessage"/>
                                                </a4j:outputPanel>
                                        </h:panelGroup>
                                            <h:panelGroup id="panelMenuCuadranteIzquierda">
                                                <h:selectOneMenu id="mnuCuadranteIzquierda"
                                                                rendered="#{examenFisicoMamaBean.lesionMamaIzquierda}"
                                                                 required="true"
                                                                 value="#{examenFisicoMamaBean.examen.hemccuadlesizq}">
                                                        <f:selectItems value="#{examenFisicoMamaBean.lstCuadrante}"/>
                                                </h:selectOneMenu>
                                                <a4j:outputPanel ajaxRendered="true">
                                                        <t:message for="mnuCuadranteIzquierda"
                                                                   styleClass="errorMessage"/>
                                                </a4j:outputPanel>
                                        </h:panelGroup>
                                        <h:panelGroup>
                                                <h:outputText value="Axila"
                                                              rendered="#{examenFisicoMamaBean.mostrarMamaIzquierda}"/>
                                        </h:panelGroup>
                                        <h:panelGroup id="outputTextLesionAxilaIzquierda">
                                                <h:outputText value="Tipo Lesión Axila"
                                                              styleClass="labelTextOblig"
                                                              rendered="#{examenFisicoMamaBean.lesionAxilaIzquierda}"/>
                                        </h:panelGroup>
                                         <h:outputText/>
                                        <a4j:region renderRegionOnly="false">
                                                <h:panelGroup>
                                                        <h:selectOneRadio id="checkAxilaIzquierda"
                                                                                 rendered="#{examenFisicoMamaBean.mostrarMamaIzquierda}"
                                                                                 value="#{examenFisicoMamaBean.examen.hemelesionaxiz}"
                                                                                 valueChangeListener="#{examenFisicoMamaBean.setLesionAxilaIzquierda}"
                                                                                 immediate="true">
                                                                        <f:selectItems value="#{examenFisicoMamaBean.lstOpciones}"/>
                                                                <a4j:support id="supportcheckAxilaIzquierda"
                                                                             event="onclick"
                                                                             action="#{examenFisicoMamaBean.changeAxilaIzquierda}"
                                                                             
                                                                             reRender="inputTextLesionAxilaIzquierda,outputTextLesionAxilaIzquierda">
                                                                        <a4j:ajaxListener type="org.ajax4jsf.ajax.ForceRender"/>
                                                                </a4j:support>
                                                                <a4j:outputPanel ajaxRendered="true">
                                                                        <t:message for="checkAxilaIzquierda"
                                                                                   styleClass="errorMessage"/>
                                                                </a4j:outputPanel>
                                                        </h:selectOneRadio>
                                                </h:panelGroup>
                                        </a4j:region>
                                        <h:panelGroup id="inputTextLesionAxilaIzquierda">
                                                <h:inputTextarea id="itLesionAxilaIzquierda"
                                                                 style="width:300px"
                                                                 required="true"
                                                                 value="#{examenFisicoMamaBean.examen.hemctipolesaxiz}"
                                                                 rendered="#{examenFisicoMamaBean.lesionAxilaIzquierda}"/>
                                                <a4j:outputPanel ajaxRendered="true">
                                                        <t:message for="itLesionAxilaIzquierda"
                                                                   styleClass="errorMessage"/>
                                                </a4j:outputPanel>
                                        </h:panelGroup>
                                         <h:outputText/>
                                </h:panelGrid>
                                <h:panelGrid columns="3" border="0"
                                             rendered="#{examenFisicoMamaBean.mostrarMamaIzquierda}"
                                             cellpadding="0" cellspacing="0"
                                             width="100%"
                                             id="panelDatosLesionIzquierda"
                                             rowClasses="labelText,labelTextInfo">
                                        <h:outputText value="Lesión en piel "
                                                      styleClass="labelTextOblig"/>
                                        <h:panelGroup id="panelTextTipoLesionIzq">
                                                <h:outputText value="Tipo Lesión"
                                                              styleClass="labelTextOblig"
                                                              rendered="#{examenFisicoMamaBean.mostrarLesionPielIzquierda}"/>
                                        </h:panelGroup>
                                        <h:outputText/>
                                        <a4j:region renderRegionOnly="false">
                                                <h:panelGroup>
                                                        <h:selectOneRadio id="mnuLesionPielIzq"
                                                                          immediate="true"
                                                                          required="true"
                                                                          value="#{examenFisicoMamaBean.lesionPielIzquierda}"
                                                                          valueChangeListener="#{examenFisicoMamaBean.setLesionPielIzquierda}">
                                                                <f:selectItems value="#{examenFisicoMamaBean.lstOpciones}"/>
                                                                <a4j:support id="supportcheckLesionPielIzquierda"
                                                                             event="onclick"
                                                                             action="#{examenFisicoMamaBean.changeLesionPielIzquierda}"
                                                                             
                                                                             reRender="panelTextTipoLesionIzq,panelMenuTipoLesionIzq">
                                                                        <a4j:ajaxListener type="org.ajax4jsf.ajax.ForceRender"/>
                                                                </a4j:support>
                                                        </h:selectOneRadio>
                                                        <a4j:outputPanel ajaxRendered="true">
                                                                <t:message for="mnuLesionPielIzq"
                                                                           styleClass="errorMessage"/>
                                                        </a4j:outputPanel>
                                                </h:panelGroup>
                                        </a4j:region>
                                        <h:panelGroup id="panelMenuTipoLesionIzq">
                                                <h:selectOneMenu id="mnuTipoLesionPielIzq"
                                                                 rendered="#{examenFisicoMamaBean.mostrarLesionPielIzquierda}"
                                                                 required="true"
                                                                 value="#{examenFisicoMamaBean.examen.hemetipolepiiz}">
                                                        <f:selectItems value="#{examenFisicoMamaBean.lstTipoLesion}"/>
                                                </h:selectOneMenu>
                                                <a4j:outputPanel ajaxRendered="true">
                                                        <t:message for="mnuTipoLesionPielIzq"
                                                                   styleClass="errorMessage"/>
                                                </a4j:outputPanel>
                                        </h:panelGroup>
                                        <h:outputText/>
                                        <h:outputText value="Tiene Secreción "
                                                      styleClass="labelTextOblig"/>
                                        <h:panelGroup id="panelTextSecrecionIzq">
                                                <h:outputText value="Secreción"
                                                              styleClass="labelTextOblig"
                                                              rendered="#{examenFisicoMamaBean.mostrarSecrecionIzquierda}"/>
                                        </h:panelGroup>
                                        <h:panelGroup id="panelTextTipoSecrecionIzq">
                                                <h:outputText value="Tipo Secreción"
                                                              styleClass="labelTextOblig"
                                                              rendered="#{examenFisicoMamaBean.mostrarSecrecionIzquierda}"/>
                                        </h:panelGroup>
                                        <a4j:region renderRegionOnly="false">
                                                <h:panelGroup>
                                                        <h:selectOneRadio id="mnuTieneSecrecionIzquierda"
                                                                          immediate="true"
                                                                          required="true"
                                                                          value="#{examenFisicoMamaBean.secrecionIzquierda}"
                                                                          valueChangeListener="#{examenFisicoMamaBean.setSecrecionIzquierda}">
                                                                <f:selectItems value="#{examenFisicoMamaBean.lstOpciones}"/>
                                                                <a4j:support id="supportcheckTieneSecrecionIzquierda"
                                                                             event="onclick"
                                                                             action="#{examenFisicoMamaBean.changeSecrecionIzquierda}"
                                                                             
                                                                             reRender="panelTextSecrecionIzq,panelTextTipoSecrecionIzq,panelMenuSecrecionIzq,panelMenuTipoSecrecionIzq">
                                                                        <a4j:ajaxListener type="org.ajax4jsf.ajax.ForceRender"/>
                                                                </a4j:support>
                                                        </h:selectOneRadio>
                                                        <a4j:outputPanel ajaxRendered="true">
                                                                <t:message for="mnuTieneSecrecionIzquierda"
                                                                           styleClass="errorMessage"/>
                                                        </a4j:outputPanel>
                                                </h:panelGroup>
                                        </a4j:region>
                                        <h:panelGroup id="panelMenuSecrecionIzq">
                                                <h:selectOneMenu id="mnuSecrecionIZq"
                                                                 rendered="#{examenFisicoMamaBean.mostrarSecrecionIzquierda}"
                                                                 required="true"
                                                                 value="#{examenFisicoMamaBean.examen.hemesecrecioiz}">
                                                        <f:selectItems value="#{examenFisicoMamaBean.lstSecrecion}"/>
                                                </h:selectOneMenu>
                                                <a4j:outputPanel ajaxRendered="true">
                                                        <t:message for="mnuSecrecionIZq"
                                                                   styleClass="errorMessage"/>
                                                </a4j:outputPanel>
                                        </h:panelGroup>
                                        <h:panelGroup id="panelMenuTipoSecrecionIzq">
                                                <h:selectOneMenu id="mnuTipoSecrecionIzq"
                                                                 rendered="#{examenFisicoMamaBean.mostrarSecrecionIzquierda}"
                                                                 required="true"
                                                                 value="#{examenFisicoMamaBean.examen.hemetiposecriz}">
                                                        <f:selectItems value="#{examenFisicoMamaBean.lstTipoSecrecion}"/>
                                                </h:selectOneMenu>
                                                <a4j:outputPanel ajaxRendered="true">
                                                        <t:message for="mnuTipoSecrecionIzq"
                                                                   styleClass="errorMessage"/>
                                                </a4j:outputPanel>
                                        </h:panelGroup>
                                        <h:outputText value="Masa "
                                                      styleClass="labelTextOblig"/>
                                        <h:panelGroup id="panelTextDiametroIzq">
                                                <h:outputText value="Diametro apx en cm"
                                                              styleClass="labelTextOblig"
                                                              rendered="#{examenFisicoMamaBean.mostrarMasaIzquierda}"/>
                                        </h:panelGroup>
                                        <h:outputText value=""/>
                                        <a4j:region renderRegionOnly="false">
                                                <h:panelGroup>
                                                        <h:selectOneRadio id="mnuMasaIzquierda"
                                                                          immediate="true"
                                                                          required="true"
                                                                          value="#{examenFisicoMamaBean.masaIzquierda}"
                                                                          valueChangeListener="#{examenFisicoMamaBean.setMasaIzquierda}">
                                                                <f:selectItems value="#{examenFisicoMamaBean.lstOpciones}"/>
                                                                <a4j:support id="supportcheckMasaIzquierda"
                                                                             event="onclick"
                                                                             action="#{examenFisicoMamaBean.changeMasaIzquierda}"
                                                                            
                                                                             reRender="panelTextDiametroIzq,panelInputDiametroIzq">
                                                                        <a4j:ajaxListener type="org.ajax4jsf.ajax.ForceRender"/>
                                                                </a4j:support>
                                                        </h:selectOneRadio>
                                                        <a4j:outputPanel ajaxRendered="true">
                                                                <t:message for="mnuMasaIzquierda"
                                                                           styleClass="errorMessage"/>
                                                        </a4j:outputPanel>
                                                </h:panelGroup>
                                        </a4j:region>
                                        <h:panelGroup id="panelInputDiametroIzq">
                                                <h:inputText id="itDiametroMasaIzquierda"
                                                             required="true"
                                                             value="#{examenFisicoMamaBean.examen.hemndiammasaiz}"
                                                             onkeydown="return blockEnter(event);"
                                                             maxlength="2"
                                                             style="width:30px"
                                                             rendered="#{examenFisicoMamaBean.mostrarMasaIzquierda}"/>
                                                <a4j:outputPanel ajaxRendered="true">
                                                        <t:message for="itDiametroMasaIzquierda"
                                                                   styleClass="errorMessage"/>
                                                </a4j:outputPanel>
                                        </h:panelGroup>
                                        <h:outputText value=""/>
                                        <h:outputText value="Dolorosa "
                                                      styleClass="labelTextOblig"/>
                                        <h:panelGroup id="panelTextTipoDolorIzq">
                                                <h:outputText value="Tipo Dolor"
                                                              styleClass="labelTextOblig"
                                                              rendered="#{examenFisicoMamaBean.mostrarDolorIzquierdo}"/>
                                        </h:panelGroup>
                                        <h:outputText value=""/>
                                        <a4j:region renderRegionOnly="false">
                                                <h:panelGroup>
                                                        <h:selectOneRadio id="mnuDolorIzq"
                                                                          immediate="true"
                                                                          required="true"
                                                                          value="#{examenFisicoMamaBean.dolorIzquierdo}"
                                                                          valueChangeListener="#{examenFisicoMamaBean.setDolorIzquierdo}">
                                                                <f:selectItems value="#{examenFisicoMamaBean.lstOpciones}"/>
                                                                <a4j:support id="supportDolorIzquierdo"
                                                                             event="onclick"
                                                                             action="#{examenFisicoMamaBean.changeDolorIzquierdo}"
                                                                             
                                                                             reRender="panelTextTipoDolorIzq,panelCheckTipoDolorIzquierdo">
                                                                        <a4j:ajaxListener type="org.ajax4jsf.ajax.ForceRender"/>
                                                                </a4j:support>
                                                        </h:selectOneRadio>
                                                        <a4j:outputPanel ajaxRendered="true">
                                                                <t:message for="mnuDolorIzq"
                                                                           styleClass="errorMessage"/>
                                                        </a4j:outputPanel>
                                                </h:panelGroup>
                                        </a4j:region>
                                        <h:panelGroup id="panelCheckTipoDolorIzquierdo">
                                                <h:inputTextarea id="itTipoDolorIzquierdo"
                                                                 style="width:300px"
                                                                 required="true"
                                                                 value="#{examenFisicoMamaBean.examen.hemctipodoloiz}"
                                                                 rendered="#{examenFisicoMamaBean.mostrarDolorIzquierdo}"/>
                                                <a4j:outputPanel ajaxRendered="true">
                                                        <t:message for="itTipoDolorIzquierdo"
                                                                   styleClass="errorMessage"/>
                                                </a4j:outputPanel>
                                        </h:panelGroup>
                                </h:panelGrid>
                        </s:fieldset>
                        <h:panelGrid columns="2" border="0" cellpadding="0"
                                     cellspacing="0" width="100%"
                                     id="panelBotonModificarMama"
                                     columnClasses="panelGridBotones">
                                <h:panelGroup>
                                        <h:commandButton value="Guardar"
                                                           styleClass="boton_fieldset"
                                                           action="#{examenFisicoMamaBean.aceptar}">
                                                <a4j:support event="onclick" status="statusButton"/>
                                            </h:commandButton>
                                </h:panelGroup>
                        </h:panelGrid>
                </h:panelGrid>
                <h:panelGrid>
                        <h:panelGroup>
                                <a4j:outputPanel id="ajaxRegionMessagesatributo1"
                                                 ajaxRendered="true">
                                        <t:htmlTag value="br"/>
                                        <t:messages id="msgInformationAndErrors1"
                                                    showSummary="true"
                                                    errorClass="error"
                                                    globalOnly="true"
                                                    layout="table"
                                                    infoClass="informacion"/>
                                </a4j:outputPanel>
                        </h:panelGroup>
                </h:panelGrid>
</t:panelTab>
</t:panelTabbedPane>
</h:panelGrid>
</a4j:region>
</a4j:form>