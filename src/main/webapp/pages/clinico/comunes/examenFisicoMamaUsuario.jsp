<%@ page contentType="text/html;charset=iso-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsf/html" prefix="h"%>
<%@ taglib uri="http://java.sun.com/jsf/core" prefix="f"%>
<%@ taglib uri="http://richfaces.org/a4j" prefix="a4j"%>
<%@ taglib uri="http://myfaces.apache.org/tomahawk" prefix="t"%>
<%@ taglib uri="http://myfaces.apache.org/sandbox" prefix="s"%>
<h:panelGrid columns="1" border="0" cellpadding="0" cellspacing="0" width="100%" id="panelGridRiesgoMamaTab"
             styleClass="tabContainer">
        <jsp:include page="/pages/clinico/comunes/encabezadoDatosUsuario.jsp" flush="true"/>
        <t:panelTabbedPane border="0" cellpadding="0" cellspacing="0" serverSideTabSwitch="false"
                           activePanelTabVar="true" width="100%" id="panelTabbedPaneExamenFisicoMama"
                           styleClass="tabbedPane" activeTabStyleClass="activeTab" inactiveTabStyleClass="inactiveTab"
                           disabledTabStyleClass="disabledTab" activeSubStyleClass="activeSub"
                           inactiveSubStyleClass="inactiveSub" tabContentStyleClass="tabContent">
                <t:panelTab id="panelTabExamenFisicoMama" label="Examen Fisico Mama">
                        <h:panelGrid columns="1" border="0" cellpadding="0" cellspacing="0" width="100%"
                                     id="tableContentTabsExamenFisicoMama" styleClass="tabContainer">
                                <s:fieldset legend="Examen Mama Derecha" id="fieldMamaDer" styleClass="fieldset">
                                        <h:panelGrid columns="3" border="0"
                                                     rendered="#{examenFisicoMamaUsuarioBean.mostrarMamaDerecha}"
                                                     cellpadding="0" cellspacing="0" width="100%" id="panelImagenes"
                                                     rowClasses="labelText,labelTextInfo">
                                                <h:graphicImage url="/comun/imagenes/1.gif"/>
                                                <h:outputText value=""/>
                                                <h:graphicImage url="/comun/imagenes/3.gif"/>
                                        </h:panelGrid>
                                        <h:panelGrid columns="3" border="0" cellpadding="0" cellspacing="0" width="100%"
                                                     id="panelDatosExamenMamaDerecha"
                                                     rowClasses="labelText,labelTextInfo">
                                                <h:outputText value="Examen de Mama Derecha"
                                                              styleClass="labelTextOblig"/>
                                                <h:outputText/>
                                                <h:outputText/>
                                                <a4j:region renderRegionOnly="false">
                                                        <h:panelGroup>
                                                                <h:selectOneMenu id="mnuExamenMamaDer" required="true"
                                                                                 onkeydown="return blockEnter(event);"
                                                                                 immediate="true"
                                                                                 value="#{examenFisicoMamaUsuarioBean.estadoDerSelect}"
                                                                                 valueChangeListener="#{examenFisicoMamaUsuarioBean.setEstadoDerSelect}">
                                                                        <f:selectItems value="#{examenFisicoMamaUsuarioBean.lstEstado}"/>
                                                                        <a4j:support id="supportcheckExamenMamaDer"
                                                                                     event="onchange"
                                                                                     action="#{examenFisicoMamaUsuarioBean.changeMamaDerecha}"
                                                                                     immediate="true"
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
                                                                      rendered="#{examenFisicoMamaUsuarioBean.mostrarMamaDerecha}"/>
                                                </h:panelGroup>
                                                <h:panelGroup id="panelTextLesion">
                                                        <h:outputText value="Tipo Lesión" styleClass="labelTextOblig"
                                                                      rendered="#{examenFisicoMamaUsuarioBean.lesionPesonDerecho}"/>
                                                </h:panelGroup>
                                                <h:outputText/>
                                                <a4j:region renderRegionOnly="false">
                                                        <h:panelGroup>
                                                                <h:selectOneRadio id="checkPesonDerecho"
                                                                                  onkeydown="return blockEnter(event);"
                                                                                  rendered="#{examenFisicoMamaUsuarioBean.mostrarMamaDerecha}"
                                                                                  value="#{examenFisicoMamaUsuarioBean.examen.hemelespezonde}"
                                                                                  valueChangeListener="#{examenFisicoMamaUsuarioBean.setLesionPesonDerecho}"
                                                                                  immediate="true">
                                                                        <f:selectItems value="#{examenFisicoMamaUsuarioBean.lstOpciones}"/>
                                                                        <a4j:support id="supportcheckPesonDerecho"
                                                                                     event="onclick"
                                                                                     action="#{examenFisicoMamaUsuarioBean.changePezonDerecho}"
                                                                                     immediate="true"
                                                                                     reRender="panelTextLesion,panelMenuLesion">
                                                                                <a4j:ajaxListener type="org.ajax4jsf.ajax.ForceRender"/>
                                                                        </a4j:support>
                                                                </h:selectOneRadio>
                                                        </h:panelGroup>
                                                </a4j:region>
                                                <h:panelGroup id="panelMenuLesion">
                                                        <h:inputTextarea id="itTipoLesionPezonDer"
                                                                         style="width:300px"
                                                                         value="#{examenFisicoMamaUsuarioBean.examen.hemctipolepede}"
                                                                         required="true"
                                                                         rendered="#{examenFisicoMamaUsuarioBean.lesionPesonDerecho}"/>
                                                        <a4j:outputPanel ajaxRendered="true">
                                                                <t:message for="itTipoLesionPezonDer"
                                                                           styleClass="errorMessage"/>
                                                        </a4j:outputPanel>
                                                </h:panelGroup>
                                                <h:outputText/>
                                                <h:panelGroup>
                                                        <h:outputText value="Lesión Mama"
                                                                      rendered="#{examenFisicoMamaUsuarioBean.mostrarMamaDerecha}"/>
                                                </h:panelGroup>
                                                <h:panelGroup id="panelTextZonaLesionDerecho">
                                                        <h:outputText value="Zona Lesión"
                                                                      rendered="#{examenFisicoMamaUsuarioBean.lesionMamaDerecha}"/>
                                                </h:panelGroup>
                                                <h:panelGroup id="panelTextCuadranteDerecho">
                                                        <h:outputText value="Cuadrante"
                                                                      rendered="#{examenFisicoMamaUsuarioBean.lesionMamaDerecha}"/>
                                                </h:panelGroup>
                                                <a4j:region renderRegionOnly="false">
                                                        <h:panelGroup>
                                                                <h:selectOneRadio id="checkMamaDerecha" immediate="true"
                                                                                  onkeydown="return blockEnter(event);"
                                                                                  rendered="#{examenFisicoMamaUsuarioBean.mostrarMamaDerecha}"
                                                                                  value="#{examenFisicoMamaUsuarioBean.examen.hemelesimamade}"
                                                                                  valueChangeListener="#{examenFisicoMamaUsuarioBean.setLesionMamaDerecha}">
                                                                        <f:selectItems value="#{examenFisicoMamaUsuarioBean.lstOpciones}"/>
                                                                        <a4j:support id="supportcheckMamaDer"
                                                                                     event="onclick" immediate="true"
                                                                                     action="#{examenFisicoMamaUsuarioBean.changeZonaDerecha}"
                                                                                     reRender="panelTextZonaLesionDerecho,panelTextCuadranteDerecho,panelMenuZonaLesion,panelMenuCuadrante">
                                                                                <a4j:ajaxListener type="org.ajax4jsf.ajax.ForceRender"/>
                                                                        </a4j:support>
                                                                </h:selectOneRadio>
                                                        </h:panelGroup>
                                                </a4j:region>
                                                <h:panelGroup id="panelMenuZonaLesion">
                                                        <h:selectOneMenu id="mnuZonaLesion"
                                                                         onkeydown="return blockEnter(event);"
                                                                         rendered="#{examenFisicoMamaUsuarioBean.lesionMamaDerecha}"
                                                                         required="true"
                                                                         value="#{examenFisicoMamaUsuarioBean.examen.hemczonalesder}">
                                                                <f:selectItems value="#{examenFisicoMamaUsuarioBean.lstZonaLesion}"/>
                                                        </h:selectOneMenu>
                                                        <a4j:outputPanel ajaxRendered="true">
                                                                <t:message for="mnuTipoLesionPielDer"
                                                                           styleClass="errorMessage"/>
                                                        </a4j:outputPanel>
                                                </h:panelGroup>
                                                <h:panelGroup id="panelMenuCuadrante">
                                                        <h:selectOneMenu id="mnuCuadrante"
                                                                         onkeydown="return blockEnter(event);"
                                                                         rendered="#{examenFisicoMamaUsuarioBean.lesionMamaDerecha}"
                                                                         required="true"
                                                                         value="#{examenFisicoMamaUsuarioBean.examen.hemccuadlesder}">
                                                                <f:selectItems value="#{examenFisicoMamaUsuarioBean.lstCuadrante}"/>
                                                        </h:selectOneMenu>
                                                        <a4j:outputPanel ajaxRendered="true">
                                                                <t:message for="mnuTipoLesionPielDer"
                                                                           styleClass="errorMessage"/>
                                                        </a4j:outputPanel>
                                                </h:panelGroup>
                                                <h:panelGroup>
                                                        <h:outputText value="Lesión Axila"
                                                                      rendered="#{examenFisicoMamaUsuarioBean.mostrarMamaDerecha}"/>
                                                </h:panelGroup>
                                                <h:panelGroup id="outputTextLesionAxilaDerecha">
                                                        <h:outputText value="Tipo Lesión Axila"
                                                                      styleClass="labelTextOblig"
                                                                      rendered="#{examenFisicoMamaUsuarioBean.lesionAxilaDerecha}"/>
                                                </h:panelGroup>
                                                <h:outputText/>
                                                <a4j:region renderRegionOnly="false">
                                                        <h:panelGroup>
                                                                <h:selectOneRadio id="checkAxilaDerecha"
                                                                                  onkeydown="return blockEnter(event);"
                                                                                  rendered="#{examenFisicoMamaUsuarioBean.mostrarMamaDerecha}"
                                                                                  value="#{examenFisicoMamaUsuarioBean.examen.hemelesionaxde}"
                                                                                  valueChangeListener="#{examenFisicoMamaUsuarioBean.setLesionAxilaDerecha}"
                                                                                  immediate="true">
                                                                        <f:selectItems value="#{examenFisicoMamaUsuarioBean.lstOpciones}"/>
                                                                        <a4j:support id="supportcheckAxilaDerecha"
                                                                                     event="onclick"
                                                                                     action="#{examenFisicoMamaUsuarioBean.changeAxilaDerecha}"
                                                                                     immediate="true"
                                                                                     reRender="inputTextLesionAxilaDerecha,outputTextLesionAxilaDerecha">
                                                                                <a4j:ajaxListener type="org.ajax4jsf.ajax.ForceRender"/>
                                                                        </a4j:support>
                                                                </h:selectOneRadio>
                                                        </h:panelGroup>
                                                </a4j:region>
                                                <h:panelGroup id="inputTextLesionAxilaDerecha">
                                                        <h:inputTextarea id="itTipoLesionAxilaDerecha"
                                                                         style="width:300px"
                                                                         value="#{examenFisicoMamaUsuarioBean.examen.hemctipolesaxde}"
                                                                         required="true"
                                                                         rendered="#{examenFisicoMamaUsuarioBean.lesionAxilaDerecha}"/>
                                                        <a4j:outputPanel ajaxRendered="true">
                                                                <t:message for="itTipoLesionAxilaDerecha"
                                                                           styleClass="errorMessage"/>
                                                        </a4j:outputPanel>
                                                </h:panelGroup>
                                                <h:outputText/>
                                        </h:panelGrid>
                                        <h:panelGrid columns="3" border="0"
                                                     rendered="#{examenFisicoMamaUsuarioBean.mostrarMamaDerecha}"
                                                     cellpadding="0" cellspacing="0" width="100%" id="panelDatosLesion"
                                                     rowClasses="labelText,labelTextInfo">
                                                <h:outputText value="Lesión en piel " styleClass="labelTextOblig"/>
                                                <h:panelGroup id="panelTextTipoLesion">
                                                        <h:outputText value="Tipo Lesión" styleClass="labelTextOblig"
                                                                      rendered="#{examenFisicoMamaUsuarioBean.mostrarLesionPielDerecho}"/>
                                                </h:panelGroup>
                                                <h:outputText/>
                                                <a4j:region renderRegionOnly="false">
                                                        <h:panelGroup>
                                                                <h:selectOneRadio id="mnuLesionPielDer"
                                                                                  onkeydown="return blockEnter(event);"
                                                                                  required="true" immediate="true"
                                                                                  value="#{examenFisicoMamaUsuarioBean.lesionPielDerecha}"
                                                                                  valueChangeListener="#{examenFisicoMamaUsuarioBean.setLesionPielDerecha}">
                                                                        <f:selectItems value="#{examenFisicoMamaUsuarioBean.lstOpciones}"/>
                                                                        <a4j:support id="supportcheckLesionPielDerecha"
                                                                                     event="onclick"
                                                                                     action="#{examenFisicoMamaUsuarioBean.changeLesionPielDerecha}"
                                                                                     immediate="true"
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
                                                                         onkeydown="return blockEnter(event);"
                                                                         rendered="#{examenFisicoMamaUsuarioBean.mostrarLesionPielDerecho}"
                                                                         required="true"
                                                                         value="#{examenFisicoMamaUsuarioBean.examen.hemetipolepide}">
                                                                <f:selectItems value="#{examenFisicoMamaUsuarioBean.lstTipoLesion}"/>
                                                        </h:selectOneMenu>
                                                        <a4j:outputPanel ajaxRendered="true">
                                                                <t:message for="mnuTipoLesionPielDer"
                                                                           styleClass="errorMessage"/>
                                                        </a4j:outputPanel>
                                                </h:panelGroup>
                                                <h:outputText/>
                                                <h:outputText value="Tiene Secreción" styleClass="labelTextOblig"/>
                                                <h:panelGroup id="panelTextSecrecion">
                                                        <h:outputText value="Secreción" styleClass="labelTextOblig"
                                                                      rendered="#{examenFisicoMamaUsuarioBean.mostrarSecrecionDerecha}"/>
                                                </h:panelGroup>
                                                <h:panelGroup id="panelTextTipoSecrecion">
                                                        <h:outputText value="Tipo Secreción" styleClass="labelTextOblig"
                                                                      rendered="#{examenFisicoMamaUsuarioBean.mostrarSecrecionDerecha}"/>
                                                </h:panelGroup>
                                                <a4j:region renderRegionOnly="false">
                                                        <h:panelGroup>
                                                                <h:selectOneRadio id="mnuTieneSecrecion"
                                                                                  onkeydown="return blockEnter(event);"
                                                                                  immediate="true" required="true"
                                                                                  value="#{examenFisicoMamaUsuarioBean.secrecionDerecha}"
                                                                                  valueChangeListener="#{examenFisicoMamaUsuarioBean.setSecrecionDerecha}">
                                                                        <f:selectItems value="#{examenFisicoMamaUsuarioBean.lstOpciones}"/>
                                                                        <a4j:support id="supportcheckTieneSecrecionDerecha"
                                                                                     event="onclick"
                                                                                     action="#{examenFisicoMamaUsuarioBean.changeSecrecionDerecha}"
                                                                                     immediate="true"
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
                                                                         onkeydown="return blockEnter(event);"
                                                                         rendered="#{examenFisicoMamaUsuarioBean.mostrarSecrecionDerecha}"
                                                                         required="true"
                                                                         value="#{examenFisicoMamaUsuarioBean.examen.hemesecreciode}">
                                                                <f:selectItems value="#{examenFisicoMamaUsuarioBean.lstSecrecion}"/>
                                                        </h:selectOneMenu>
                                                        <a4j:outputPanel ajaxRendered="true">
                                                                <t:message for="mnuSecrecionDe"
                                                                           styleClass="errorMessage"/>
                                                        </a4j:outputPanel>
                                                </h:panelGroup>
                                                <h:panelGroup id="panelMenuTipoSecrecion">
                                                        <h:selectOneMenu id="mnuTipoSecrecionDe"
                                                                         onkeydown="return blockEnter(event);"
                                                                         rendered="#{examenFisicoMamaUsuarioBean.mostrarSecrecionDerecha}"
                                                                         required="true"
                                                                         value="#{examenFisicoMamaUsuarioBean.examen.hemetiposecrde}">
                                                                <f:selectItems value="#{examenFisicoMamaUsuarioBean.lstTipoSecrecion}"/>
                                                        </h:selectOneMenu>
                                                        <a4j:outputPanel ajaxRendered="true">
                                                                <t:message for="mnuTipoSecrecionDe"
                                                                           styleClass="errorMessage"/>
                                                        </a4j:outputPanel>
                                                </h:panelGroup>
                                                <h:outputText value="Masa " styleClass="labelTextOblig"/>
                                                <h:panelGroup id="panelTextDiametro">
                                                        <h:outputText value="Diametro apx en mm"
                                                                      styleClass="labelTextOblig"
                                                                      rendered="#{examenFisicoMamaUsuarioBean.mostrarMasaDerecha}"/>
                                                </h:panelGroup>
                                                <h:outputText value=""/>
                                                <a4j:region renderRegionOnly="false">
                                                        <h:panelGroup>
                                                                <h:selectOneRadio id="mnuMasaDe"
                                                                                  onkeydown="return blockEnter(event);"
                                                                                  immediate="true" required="true"
                                                                                  value="#{examenFisicoMamaUsuarioBean.masaDerecha}"
                                                                                  valueChangeListener="#{examenFisicoMamaUsuarioBean.setMasaDerecha}">
                                                                        <f:selectItems value="#{examenFisicoMamaUsuarioBean.lstOpciones}"/>
                                                                        <a4j:support id="supportcheckMasaDerecha"
                                                                                     event="onclick"
                                                                                     action="#{examenFisicoMamaUsuarioBean.changeMasaDerecha}"
                                                                                     immediate="true"
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
                                                                     value="#{examenFisicoMamaUsuarioBean.examen.hemndiammasade}"
                                                                     required="true" maxlength="2"
                                                                     onkeydown="return blockEnter(event);"
                                                                     style="width:30px"
                                                                     rendered="#{examenFisicoMamaUsuarioBean.mostrarMasaDerecha}"/>
                                                        <a4j:outputPanel ajaxRendered="true">
                                                                <t:message for="itDiametroMasaDerecha"
                                                                           styleClass="errorMessage"/>
                                                        </a4j:outputPanel>
                                                </h:panelGroup>
                                                <h:outputText value=""/>
                                                <h:outputText value="Dolorosa " styleClass="labelTextOblig"/>
                                                <h:panelGroup id="panelTextTipoDolor">
                                                        <h:outputText value="Tipo Dolor" styleClass="labelTextOblig"
                                                                      rendered="#{examenFisicoMamaUsuarioBean.mostrarDolorDerecho}"/>
                                                </h:panelGroup>
                                                <h:outputText value=""/>
                                                <a4j:region renderRegionOnly="false">
                                                        <h:panelGroup>
                                                                <h:selectOneRadio id="mnuDolorDe" immediate="true"
                                                                                  onkeydown="return blockEnter(event);"
                                                                                  required="true"
                                                                                  value="#{examenFisicoMamaUsuarioBean.dolorDerecho}"
                                                                                  valueChangeListener="#{examenFisicoMamaUsuarioBean.setDolorDerecho}">
                                                                        <f:selectItems value="#{examenFisicoMamaUsuarioBean.lstOpciones}"/>
                                                                        <a4j:support id="supportDolorDerecho"
                                                                                     event="onclick"
                                                                                     action="#{examenFisicoMamaUsuarioBean.changeDolorDerecho}"
                                                                                     immediate="true"
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
                                                        <h:inputTextarea id="itDolorDerecho" style="width:300px"
                                                                         value="#{examenFisicoMamaUsuarioBean.examen.hemctipodolode}"
                                                                         required="true"
                                                                         rendered="#{examenFisicoMamaUsuarioBean.mostrarDolorDerecho}"/>
                                                        <a4j:outputPanel ajaxRendered="true">
                                                                <t:message for="itDolorDerecho"
                                                                           styleClass="errorMessage"/>
                                                        </a4j:outputPanel>
                                                </h:panelGroup>
                                        </h:panelGrid>
                                </s:fieldset>
                                <s:fieldset legend="Examen Mama Izquierda" id="fieldMamaIzq" styleClass="fieldset">
                                        <h:panelGrid columns="3" border="0"
                                                     rendered="#{examenFisicoMamaUsuarioBean.mostrarMamaIzquierda}"
                                                     cellpadding="0" cellspacing="0" width="100%"
                                                     id="panelImagenesIzquierda" rowClasses="labelText,labelTextInfo">
                                                <h:graphicImage url="/comun/imagenes/6.gif"/>
                                                <h:panelGroup/>
                                                <h:graphicImage url="/comun/imagenes/4.gif"/>
                                        </h:panelGrid>
                                        <h:panelGrid columns="3" border="0" cellpadding="0" cellspacing="0" width="100%"
                                                     id="panelDatosExamenMamaIzquierda"
                                                     rowClasses="labelText,labelTextInfo">
                                                <h:outputText value="Examen de Mama Izquierda"
                                                              styleClass="labelTextOblig"/>
                                                <h:outputText/>
                                                <h:outputText/>
                                                <a4j:region renderRegionOnly="false">
                                                        <h:panelGroup>
                                                                <h:selectOneMenu id="mnuExamenMamaIzq" required="true"
                                                                                 onkeydown="return blockEnter(event);"
                                                                                 immediate="true"
                                                                                 value="#{examenFisicoMamaUsuarioBean.estadoIzqSelect}"
                                                                                 valueChangeListener="#{examenFisicoMamaUsuarioBean.setEstadoIzqSelect}">
                                                                        <f:selectItems value="#{examenFisicoMamaUsuarioBean.lstEstado}"/>
                                                                        <a4j:support id="supportcheckExamenMamaIzq"
                                                                                     event="onchange"
                                                                                     action="#{examenFisicoMamaUsuarioBean.changeMamaIzquierda}"
                                                                                     immediate="true"
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
                                                                      rendered="#{examenFisicoMamaUsuarioBean.mostrarMamaIzquierda}"/>
                                                </h:panelGroup>
                                                <h:panelGroup id="panelTextLesionIzq">
                                                        <h:outputText value="Tipo Lesión" styleClass="labelTextOblig"
                                                                      rendered="#{examenFisicoMamaUsuarioBean.lesionPesonIzquierdo}"/>
                                                </h:panelGroup>
                                                <h:outputText/>
                                                <a4j:region renderRegionOnly="false">
                                                        <h:panelGroup>
                                                                <h:selectOneRadio id="checkPesonIzquierdo"
                                                                                  onkeydown="return blockEnter(event);"
                                                                                  rendered="#{examenFisicoMamaUsuarioBean.mostrarMamaIzquierda}"
                                                                                  value="#{examenFisicoMamaUsuarioBean.examen.hemelespezoniz}"
                                                                                  valueChangeListener="#{examenFisicoMamaUsuarioBean.setLesionPesonIzquierdo}"
                                                                                  immediate="true">
                                                                        <f:selectItems value="#{examenFisicoMamaUsuarioBean.lstOpciones}"/>
                                                                        <a4j:support id="supportcheckPesonIzquierdo"
                                                                                     event="onclick" immediate="true"
                                                                                     action="#{examenFisicoMamaUsuarioBean.changePezonIzquierdo}"
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
                                                                        style="width:300px" required="true"
                                                                         value="#{examenFisicoMamaUsuarioBean.examen.hemctipolepeiz}"
                                                                         rendered="#{examenFisicoMamaUsuarioBean.lesionPesonIzquierdo}"/>
                                                        <a4j:outputPanel ajaxRendered="true">
                                                                <t:message for="itTipoLesionPezonIzquierdo"
                                                                           styleClass="errorMessage"/>
                                                        </a4j:outputPanel>
                                                </h:panelGroup>
                                                <h:outputText/>
                                                <h:panelGroup>
                                                        <h:outputText value="Mama"
                                                                      rendered="#{examenFisicoMamaUsuarioBean.mostrarMamaIzquierda}"/>
                                                </h:panelGroup>
                                                <h:panelGroup id="panelTextZonaLesionIzquierdo">
                                                        <h:outputText value="Zona Lesión"
                                                                      rendered="#{examenFisicoMamaUsuarioBean.lesionMamaIzquierda}"/>
                                                </h:panelGroup>
                                                <h:panelGroup id="panelTextCuadranteIzquierdo">
                                                        <h:outputText value="Cuadrante"
                                                                      rendered="#{examenFisicoMamaUsuarioBean.lesionMamaIzquierda}"/>
                                                </h:panelGroup>
                                                <a4j:region renderRegionOnly="false">
                                                        <h:panelGroup>
                                                                <h:selectOneRadio id="checkMamaIzquierda"
                                                                                  immediate="true"
                                                                                  rendered="#{examenFisicoMamaUsuarioBean.mostrarMamaIzquierda}"
                                                                                  onkeydown="return blockEnter(event);"
                                                                                  value="#{examenFisicoMamaUsuarioBean.examen.hemelesimamaiz}"
                                                                                  valueChangeListener="#{examenFisicoMamaUsuarioBean.setLesionMamaIzquierda}">
                                                                        <f:selectItems value="#{examenFisicoMamaUsuarioBean.lstOpciones}"/>
                                                                        <a4j:support id="supportcheckMamaDerecha"
                                                                                     event="onclick"
                                                                                     action="#{examenFisicoMamaUsuarioBean.changeZonaIzquierda}"
                                                                                     immediate="true"
                                                                                     reRender="panelTextZonaLesionIzquierdo,panelTextCuadranteIzquierdo,panelMenuZonaLesionIzquierda,panelMenuCuadranteIzquierda">
                                                                                <a4j:ajaxListener type="org.ajax4jsf.ajax.ForceRender"/>
                                                                        </a4j:support>
                                                                </h:selectOneRadio>
                                                        </h:panelGroup>
                                                </a4j:region>
                                                <h:panelGroup id="panelMenuZonaLesionIzquierda">
                                                        <h:selectOneMenu id="mnuZonaLesionIzquierda"
                                                                         onkeydown="return blockEnter(event);"
                                                                         rendered="#{examenFisicoMamaUsuarioBean.lesionMamaIzquierda}"
                                                                         required="true"
                                                                         value="#{examenFisicoMamaUsuarioBean.examen.hemczonalesizq}">
                                                                <f:selectItems value="#{examenFisicoMamaUsuarioBean.lstZonaLesion}"/>
                                                        </h:selectOneMenu>
                                                        <a4j:outputPanel ajaxRendered="true">
                                                                <t:message for="mnuZonaLesionIzquierda"
                                                                           styleClass="errorMessage"/>
                                                        </a4j:outputPanel>
                                                </h:panelGroup>
                                                <h:panelGroup id="panelMenuCuadranteIzquierda">
                                                        <h:selectOneMenu id="mnuCuadranteIzquierda"
                                                                         onkeydown="return blockEnter(event);"
                                                                         rendered="#{examenFisicoMamaUsuarioBean.lesionMamaIzquierda}"
                                                                         required="true"
                                                                         value="#{examenFisicoMamaUsuarioBean.examen.hemccuadlesizq}">
                                                                <f:selectItems value="#{examenFisicoMamaUsuarioBean.lstCuadrante}"/>
                                                        </h:selectOneMenu>
                                                        <a4j:outputPanel ajaxRendered="true">
                                                                <t:message for="mnuCuadranteIzquierda"
                                                                           styleClass="errorMessage"/>
                                                        </a4j:outputPanel>
                                                </h:panelGroup>
                                                <h:panelGroup>
                                                        <h:outputText value="Axila"
                                                                      rendered="#{examenFisicoMamaUsuarioBean.mostrarMamaIzquierda}"/>
                                                </h:panelGroup>
                                                <h:panelGroup id="outputTextLesionAxilaIzquierda">
                                                        <h:outputText value="Tipo Lesión Axila"
                                                                      styleClass="labelTextOblig"
                                                                      rendered="#{examenFisicoMamaUsuarioBean.lesionAxilaIzquierda}"/>
                                                </h:panelGroup>
                                                <h:outputText/>
                                                <a4j:region renderRegionOnly="false">
                                                        <h:panelGroup>
                                                                <h:selectOneRadio id="checkAxilaIzquierda"
                                                                                  onkeydown="return blockEnter(event);"
                                                                                  rendered="#{examenFisicoMamaUsuarioBean.mostrarMamaIzquierda}"
                                                                                  value="#{examenFisicoMamaUsuarioBean.examen.hemelesionaxiz}"
                                                                                  valueChangeListener="#{examenFisicoMamaUsuarioBean.setLesionAxilaIzquierda}"
                                                                                  immediate="true">
                                                                        <f:selectItems value="#{examenFisicoMamaUsuarioBean.lstOpciones}"/>
                                                                        <a4j:support id="supportcheckAxilaIzquierda"
                                                                                     event="onclick"
                                                                                     action="#{examenFisicoMamaUsuarioBean.changeAxilaIzquierda}"
                                                                                     immediate="true"
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
                                                                         style="width:300px" required="true"
                                                                         value="#{examenFisicoMamaUsuarioBean.examen.hemctipolesaxiz}"
                                                                         rendered="#{examenFisicoMamaUsuarioBean.lesionAxilaIzquierda}"/>
                                                        <a4j:outputPanel ajaxRendered="true">
                                                                <t:message for="itLesionAxilaIzquierda"
                                                                           styleClass="errorMessage"/>
                                                        </a4j:outputPanel>
                                                </h:panelGroup>
                                                <h:outputText/>
                                        </h:panelGrid>
                                        <h:panelGrid columns="3" border="0"
                                                     rendered="#{examenFisicoMamaUsuarioBean.mostrarMamaIzquierda}"
                                                     cellpadding="0" cellspacing="0" width="100%"
                                                     id="panelDatosLesionIzquierda"
                                                     rowClasses="labelText,labelTextInfo">
                                                <h:outputText value="Lesión en piel " styleClass="labelTextOblig"/>
                                                <h:panelGroup id="panelTextTipoLesionIzq">
                                                        <h:outputText value="Tipo Lesión" styleClass="labelTextOblig"
                                                                      rendered="#{examenFisicoMamaUsuarioBean.mostrarLesionPielIzquierda}"/>
                                                </h:panelGroup>
                                                <h:outputText/>
                                                <a4j:region renderRegionOnly="false">
                                                        <h:panelGroup>
                                                                <h:selectOneRadio id="mnuLesionPielIzq" immediate="true"
                                                                                  onkeydown="return blockEnter(event);"
                                                                                  required="true"
                                                                                  value="#{examenFisicoMamaUsuarioBean.lesionPielIzquierda}"
                                                                                  valueChangeListener="#{examenFisicoMamaUsuarioBean.setLesionPielIzquierda}">
                                                                        <f:selectItems value="#{examenFisicoMamaUsuarioBean.lstOpciones}"/>
                                                                        <a4j:support id="supportcheckLesionPielIzquierda"
                                                                                     event="onclick"
                                                                                     action="#{examenFisicoMamaUsuarioBean.changeLesionPielIzquierda}"
                                                                                     immediate="true"
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
                                                                         onkeydown="return blockEnter(event);"
                                                                         rendered="#{examenFisicoMamaUsuarioBean.mostrarLesionPielIzquierda}"
                                                                         required="true"
                                                                         value="#{examenFisicoMamaUsuarioBean.examen.hemetipolepiiz}">
                                                                <f:selectItems value="#{examenFisicoMamaUsuarioBean.lstTipoLesion}"/>
                                                        </h:selectOneMenu>
                                                        <a4j:outputPanel ajaxRendered="true">
                                                                <t:message for="mnuTipoLesionPielIzq"
                                                                           styleClass="errorMessage"/>
                                                        </a4j:outputPanel>
                                                </h:panelGroup>
                                                <h:outputText/>
                                                <h:outputText value="Tiene Secreción " styleClass="labelTextOblig"/>
                                                <h:panelGroup id="panelTextSecrecionIzq">
                                                        <h:outputText value="Secreción" styleClass="labelTextOblig"
                                                                      rendered="#{examenFisicoMamaUsuarioBean.mostrarSecrecionIzquierda}"/>
                                                </h:panelGroup>
                                                <h:panelGroup id="panelTextTipoSecrecionIzq">
                                                        <h:outputText value="Tipo Secreción" styleClass="labelTextOblig"
                                                                      rendered="#{examenFisicoMamaUsuarioBean.mostrarSecrecionIzquierda}"/>
                                                </h:panelGroup>
                                                <a4j:region renderRegionOnly="false">
                                                        <h:panelGroup>
                                                                <h:selectOneRadio id="mnuTieneSecrecionIzquierda"
                                                                                  onkeydown="return blockEnter(event);"
                                                                                  immediate="true" required="true"
                                                                                  value="#{examenFisicoMamaUsuarioBean.secrecionIzquierda}"
                                                                                  valueChangeListener="#{examenFisicoMamaUsuarioBean.setSecrecionIzquierda}">
                                                                        <f:selectItems value="#{examenFisicoMamaUsuarioBean.lstOpciones}"/>
                                                                        <a4j:support id="supportcheckTieneSecrecionIzquierda"
                                                                                     event="onclick"
                                                                                     action="#{examenFisicoMamaUsuarioBean.changeSecrecionIzquierda}"
                                                                                     immediate="true"
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
                                                                         onkeydown="return blockEnter(event);"
                                                                         rendered="#{examenFisicoMamaUsuarioBean.mostrarSecrecionIzquierda}"
                                                                         required="true"
                                                                         value="#{examenFisicoMamaUsuarioBean.examen.hemesecrecioiz}">
                                                                <f:selectItems value="#{examenFisicoMamaUsuarioBean.lstSecrecion}"/>
                                                        </h:selectOneMenu>
                                                        <a4j:outputPanel ajaxRendered="true">
                                                                <t:message for="mnuSecrecionIZq"
                                                                           styleClass="errorMessage"/>
                                                        </a4j:outputPanel>
                                                </h:panelGroup>
                                                <h:panelGroup id="panelMenuTipoSecrecionIzq">
                                                        <h:selectOneMenu id="mnuTipoSecrecionIzq"
                                                                         onkeydown="return blockEnter(event);"
                                                                         rendered="#{examenFisicoMamaUsuarioBean.mostrarSecrecionIzquierda}"
                                                                         required="true"
                                                                         value="#{examenFisicoMamaUsuarioBean.examen.hemetiposecriz}">
                                                                <f:selectItems value="#{examenFisicoMamaUsuarioBean.lstTipoSecrecion}"/>
                                                        </h:selectOneMenu>
                                                        <a4j:outputPanel ajaxRendered="true">
                                                                <t:message for="mnuTipoSecrecionIzq"
                                                                           styleClass="errorMessage"/>
                                                        </a4j:outputPanel>
                                                </h:panelGroup>
                                                <h:outputText value="Masa " styleClass="labelTextOblig"/>
                                                <h:panelGroup id="panelTextDiametroIzq">
                                                        <h:outputText value="Diametro apx en cm"
                                                                      styleClass="labelTextOblig"
                                                                      rendered="#{examenFisicoMamaUsuarioBean.mostrarMasaIzquierda}"/>
                                                </h:panelGroup>
                                                <h:outputText value=""/>
                                                <a4j:region renderRegionOnly="false">
                                                        <h:panelGroup>
                                                                <h:selectOneRadio id="mnuMasaIzquierda" immediate="true"
                                                                                  onkeydown="return blockEnter(event);"
                                                                                  required="true"
                                                                                  value="#{examenFisicoMamaUsuarioBean.masaIzquierda}"
                                                                                  valueChangeListener="#{examenFisicoMamaUsuarioBean.setMasaIzquierda}">
                                                                        <f:selectItems value="#{examenFisicoMamaUsuarioBean.lstOpciones}"/>
                                                                        <a4j:support id="supportcheckMasaIzquierda"
                                                                                     event="onclick"
                                                                                     action="#{examenFisicoMamaUsuarioBean.changeMasaIzquierda}"
                                                                                     immediate="true"
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
                                                        <h:inputText id="itDiametroMasaIzquierda" required="true"
                                                                     onkeydown="return blockEnter(event);"
                                                                     value="#{examenFisicoMamaUsuarioBean.examen.hemndiammasaiz}"
                                                                     maxlength="2" style="width:30px"
                                                                     rendered="#{examenFisicoMamaUsuarioBean.mostrarMasaIzquierda}"/>
                                                        <a4j:outputPanel ajaxRendered="true">
                                                                <t:message for="itDiametroMasaIzquierda"
                                                                           styleClass="errorMessage"/>
                                                        </a4j:outputPanel>
                                                </h:panelGroup>
                                                <h:outputText value=""/>
                                                <h:outputText value="Dolorosa " styleClass="labelTextOblig"/>
                                                <h:panelGroup id="panelTextTipoDolorIzq">
                                                        <h:outputText value="Tipo Dolor" styleClass="labelTextOblig"
                                                                      rendered="#{examenFisicoMamaUsuarioBean.mostrarDolorIzquierdo}"/>
                                                </h:panelGroup>
                                                <h:outputText value=""/>
                                                <a4j:region renderRegionOnly="false">
                                                        <h:panelGroup>
                                                                <h:selectOneRadio id="mnuDolorIzq" immediate="true"
                                                                                  onkeydown="return blockEnter(event);"
                                                                                  required="true"
                                                                                  value="#{examenFisicoMamaUsuarioBean.dolorIzquierdo}"
                                                                                  valueChangeListener="#{examenFisicoMamaUsuarioBean.setDolorIzquierdo}">
                                                                        <f:selectItems value="#{examenFisicoMamaUsuarioBean.lstOpciones}"/>
                                                                        <a4j:support id="supportDolorIzquierdo"
                                                                                     event="onclick"
                                                                                     action="#{examenFisicoMamaUsuarioBean.changeDolorIzquierdo}"
                                                                                     immediate="true"
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
                                                        <h:inputTextarea id="itTipoDolorIzquierdo" style="width:300px"
                                                                         required="true"
                                                                         value="#{examenFisicoMamaUsuarioBean.examen.hemctipodoloiz}"
                                                                         rendered="#{examenFisicoMamaUsuarioBean.mostrarDolorIzquierdo}"/>
                                                        <a4j:outputPanel ajaxRendered="true">
                                                                <t:message for="itTipoDolorIzquierdo"
                                                                           styleClass="errorMessage"/>
                                                        </a4j:outputPanel>
                                                </h:panelGroup>
                                        </h:panelGrid>
                                </s:fieldset>
                                <h:panelGrid columns="2" border="0" cellpadding="0" cellspacing="0" width="100%"
                                             id="panelBotonModificarMama" columnClasses="panelGridBotones">
                                        <h:panelGroup>
                                                <h:commandButton value="Guardar" styleClass="boton_fieldset"
                                                                 action="#{examenFisicoMamaUsuarioBean.aceptar}">
                                                        <a4j:support event="onclick" status="statusButton"/>
                                                </h:commandButton>
                                        </h:panelGroup>
                                </h:panelGrid>
                        </h:panelGrid>
                        <h:panelGrid>
                                <h:panelGroup>
                                        <a4j:outputPanel id="ajaxRegionMessagesatributo1" ajaxRendered="true">
                                                <t:htmlTag value="br"/>
                                                <t:messages id="msgInformationAndErrors1" showSummary="true"
                                                            errorClass="error" globalOnly="true" layout="table"
                                                            infoClass="informacion"/>
                                        </a4j:outputPanel>
                                </h:panelGroup>
                        </h:panelGrid>
                </t:panelTab>
        </t:panelTabbedPane>
        <script language="javascript" type="text/javascript">
        document.forms[1].elements[6].focus()
</script>
</h:panelGrid>