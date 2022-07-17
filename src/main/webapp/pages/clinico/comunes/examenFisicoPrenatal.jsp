<%@ page contentType="text/html;charset=iso-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsf/html" prefix="h"%>
<%@ taglib uri="http://java.sun.com/jsf/core" prefix="f"%>
<%@ taglib uri="http://richfaces.org/a4j" prefix="a4j"%>
<%@ taglib uri="http://myfaces.apache.org/tomahawk" prefix="t"%>
<%@ taglib uri="http://myfaces.apache.org/sandbox" prefix="s"%>
  <h:panelGrid columns="1" border="0" cellpadding="0" cellspacing="0"
               width="100%" id="panelGridexamenFisicoPrenatalUsuarioBeanTab"
               styleClass="tabContainer">
  <jsp:include page="/pages/clinico/comunes/encabezadoDatosUsuario.jsp" flush="true"/>

    <t:panelTabbedPane border="0" cellpadding="0" cellspacing="0"
                       serverSideTabSwitch="false" activePanelTabVar="true"
                       width="100%" id="panelTabbedPaneexamenFisicoPrenatalUsuarioBean"
                       styleClass="tabbedPane" activeTabStyleClass="activeTab"
                       inactiveTabStyleClass="inactiveTab"
                       disabledTabStyleClass="disabledTab"
                       activeSubStyleClass="activeSub"
                       inactiveSubStyleClass="inactiveSub"
                       tabContentStyleClass="tabContent">
      <t:panelTab id="panelTabExamenFisiscoPrenatal" label="Examen Fisico Prenatal">
    <h:panelGrid columns="1" border="0" cellpadding="0" cellspacing="0"
                     width="100%"
                     id="tableContentTabsexamenFisicoPrenatalUsuarioBean"
                     styleClass="tabContainer">
        <h:panelGrid columns="2" id="tableInfoUbicationSemanaPrenatal" border="0" cellpadding="0" 
                    cellspacing="0" width="100%" columnClasses="td_alertas">
            <h:outputText styleClass="lableTextOblig"
                            value = "  Numero de Semanas de embarazo: "/>
            <h:outputText value = "#{examenFisicoPrenatalUsuarioBean.semanaGestacion}">
            <f:convertNumber maxFractionDigits="2"/>
            </h:outputText>
        </h:panelGrid>
      <s:fieldset legend="Datos Examen Fisico" id="fieldExamenFisico"
                  styleClass="fieldset" rendered="#{examenFisicoPrenatalUsuarioBean.renderExamenFisico}">
        <a4j:region renderRegionOnly="false">
          <h:panelGrid columns="3" border="0" cellpadding="0" cellspacing="0"
                       width="100%" id="panelDatosExamen"
                       rowClasses="labelText,labelTextInfo">
            <h:outputText value="Presion Arterial" styleClass="labelTextOblig"/>
            <h:outputText value="Frecuencia Cardiaca"
                          styleClass="labelTextOblig"/>
            <h:outputText value="Frecuencia Respiratoria"
                          styleClass="labelTextOblig"/>
            <h:panelGroup>
              <h:inputText id="itPresion" title="mm Hg" required="true"
                           onkeydown="return blockEnter(event);"
                           value="#{examenFisicoPrenatalUsuarioBean.control.hcpcpresart1}"
                           style="width:30px" maxlength="3"/>
              <a4j:outputPanel ajaxRendered="true">
                <t:message for="itPresion" styleClass="errorMessage"/>
              </a4j:outputPanel>
              <h:outputText value="/"/>
              <h:inputText id="itPresion2" title="mm Hg" required="true"
                           onkeydown="return blockEnter(event);"
                           value="#{examenFisicoPrenatalUsuarioBean.control.hcpcpresart2}"
                           style="width:30px" maxlength="3"/>
              <h:outputText value="  mm Hg"/>
              <a4j:outputPanel ajaxRendered="true">
                <t:message for="itPresion2" styleClass="errorMessage"/>
              </a4j:outputPanel>
            </h:panelGroup>
            <h:panelGroup>
              <h:inputText id="itCardiaca" title="latidos por minuto"
                           onkeydown="return blockEnter(event);" required="true"
                           value="#{examenFisicoPrenatalUsuarioBean.control.hcpnfreccard}"
                           style="width:30px" maxlength="3"/>
              <h:outputText value="  l.p.m"/>
              <a4j:outputPanel ajaxRendered="true">
                <t:message for="itCardiaca" styleClass="errorMessage"/>
              </a4j:outputPanel>
            </h:panelGroup>
            <h:panelGroup>
              <h:inputText id="itRespiratoria" title="respiraciones por minuto"
                           onkeydown="return blockEnter(event);" required="true"
                           value="#{examenFisicoPrenatalUsuarioBean.control.hcpnfrecresp}"
                           style="width:30px" maxlength="2"/>
              <h:outputText value="  r.p.m"/>
              <a4j:outputPanel ajaxRendered="true">
                <t:message for="itRespiratoria" styleClass="errorMessage"/>
              </a4j:outputPanel>
            </h:panelGroup>
            <h:outputText value="Peso" styleClass="labelTextOblig"/>
            <h:outputText value="Talla" styleClass="labelTextOblig"/>
            <h:outputText value="IMC" styleClass="labelTextOblig"/>
             <a4j:region renderRegionOnly="false">
            <h:panelGroup>
              <h:panelGroup>
                <h:inputText id="itPeso" required="true"
                             onkeydown="return blockEnter(event);"
                             value="#{examenFisicoPrenatalUsuarioBean.control.hcpapeso}"
                             valueChangeListener="#{examenFisicoPrenatalUsuarioBean.setHcpapeso}"
                             style="width:40px" maxlength="4"
                             title="Peso en Kilogramos">
                <a4j:support id="supportPesoIMC" event="onchange" 
                    action="#{examenFisicoPrenatalUsuarioBean.calcularIMC}"
                                 reRender="itIndiceMasaCorporal">
                      <a4j:ajaxListener type="org.ajax4jsf.ajax.ForceRender"/>
                    </a4j:support>
                        </h:inputText>
                <a4j:outputPanel ajaxRendered="true">
                  <t:message for="itPeso" styleClass="errorMessage"/>
                </a4j:outputPanel>
              </h:panelGroup>
              <h:panelGroup>
                <h:outputText value="  kg"/>
              </h:panelGroup>
            </h:panelGroup>
            </a4j:region>
            <h:panelGroup>
              <h:inputText id="itTalla" title="Talla en metros" required="true"
                           onkeydown="return blockEnter(event);"
                           value="#{examenFisicoPrenatalUsuarioBean.control.hcpatalla}"
                           valueChangeListener="#{examenFisicoPrenatalUsuarioBean.setTalla}"
                           style="width:40px" maxlength="4">
                <a4j:support id="supportIMC" event="onchange"
                             action="#{examenFisicoPrenatalUsuarioBean.calcularIMC}"
                             reRender="itIndiceMasaCorporal">
                  <a4j:ajaxListener type="org.ajax4jsf.ajax.ForceRender"/>
                </a4j:support>
              </h:inputText>
              <a4j:outputPanel ajaxRendered="true">
                <t:message for="itTalla" styleClass="errorMessage"/>
              </a4j:outputPanel>
              <h:outputText value="  mts  "/>
            </h:panelGroup>
            <h:panelGroup id = "itIndiceMasaCorporal">
              <h:inputText value="#{examenFisicoPrenatalUsuarioBean.imc}" disabled="true"/>
            </h:panelGroup>
            <h:panelGroup>
              <h:outputText value="Temperatura"/>
            </h:panelGroup>
             <h:outputText value=""/>
            <h:panelGroup>
                <h:outputText value=""/>
            </h:panelGroup>
            <h:panelGroup>
              <h:inputText id="itTemperaura" required="true"
                           onkeydown="return blockEnter(event);"
                           title="Temperatura en grados centígrados"
                           value="#{examenFisicoPrenatalUsuarioBean.control.hcpatemperatu}"
                           style="width:50px" maxlength="5"/>
              <a4j:outputPanel ajaxRendered="true">
                <t:message for="itTemperaura" styleClass="errorMessage"/>
              </a4j:outputPanel>
              <h:outputText value="  ºC"/>
            </h:panelGroup>
            <h:outputText value=""/>
            <h:outputText value=""/>
          </h:panelGrid>
        </a4j:region>
      </s:fieldset>
      <s:fieldset legend="Examen Fisico Prenatal"
                  id="fieldExamenesFisicoPrenatal" styleClass="fieldset">
                  
        <h:panelGrid columns="4" border="0" cellpadding="0" cellspacing="0"
                     width="100%" id="panelexamenFisicoPrenatalUsuarioBean"
                     rowClasses="labelText,labelTextInfo">
          <h:outputText value="Examen Clinico" styleClass="labelTextOblig"/>
          <h:outputText value="Examen de Mamas" styleClass="labelTextOblig"/>
          <h:outputText value="Examen Odontologico"
                        styleClass="labelTextOblig"/>
         <h:outputText/>
          <h:panelGroup>
            <h:selectOneRadio id="mnuExamenClinico" immediate="true"
                              required="true"  
                              value="#{examenFisicoPrenatalUsuarioBean.control.hcpeexaclinico}">
              <f:selectItems value="#{examenFisicoPrenatalUsuarioBean.lstNormal}"/>
            </h:selectOneRadio>
            <a4j:outputPanel ajaxRendered="true">
              <t:message for="mnuExamenClinico" styleClass="errorMessage"/>
            </a4j:outputPanel>
          </h:panelGroup>
          <h:panelGroup>
            <h:selectOneRadio id="mnuExamenMama" immediate="true"
                                 required="true"
                              value="#{examenFisicoPrenatalUsuarioBean.control.hcpeexamemamas}">
              <f:selectItems value="#{examenFisicoPrenatalUsuarioBean.lstNormal}"/>
            </h:selectOneRadio>
            <a4j:outputPanel ajaxRendered="true">
              <t:message for="mnuExamenMama" styleClass="errorMessage"/>
            </a4j:outputPanel>
          </h:panelGroup>
          <h:panelGroup>
            <h:selectOneRadio id="mnuExamenOdontologico" immediate="true"
                                 required="true"
                              value="#{examenFisicoPrenatalUsuarioBean.control.hcpeexaodontol}">
              <f:selectItems value="#{examenFisicoPrenatalUsuarioBean.lstNormal}"/>
            </h:selectOneRadio>
            <a4j:outputPanel ajaxRendered="true">
              <t:message for="mnuExamenOdontologico" styleClass="errorMessage"/>
            </a4j:outputPanel>
          </h:panelGroup>
          <h:outputText/>
          <h:outputText value="Pelvis" styleClass="labelTextOblig"/>
          <h:outputText value="Citologia" styleClass="labelTextOblig"/>
          <h:outputText value="Cervix" styleClass="labelTextOblig"/>
          <h:outputText value="IMC" styleClass="labelTextOblig"/>
          <h:panelGroup>
            <h:selectOneRadio id="mnuExamenPelvis" immediate="true"
                                 required="true"
                              value="#{examenFisicoPrenatalUsuarioBean.control.hcpeexamepelvi}">
              <f:selectItems value="#{examenFisicoPrenatalUsuarioBean.lstNormal}"/>
            </h:selectOneRadio>
            <a4j:outputPanel ajaxRendered="true">
              <t:message for="mnuExamenPelvis" styleClass="errorMessage"/>
            </a4j:outputPanel>
          </h:panelGroup>
          <h:panelGroup>
            <h:selectOneRadio id="mnuExamenCitologia" immediate="true"
                                 required="true"
                              value="#{examenFisicoPrenatalUsuarioBean.control.hcpeexacitolog}">
              <f:selectItems value="#{examenFisicoPrenatalUsuarioBean.lstNormal}"/>
            </h:selectOneRadio>
            <a4j:outputPanel ajaxRendered="true">
              <t:message for="mnuExamenCitologia" styleClass="errorMessage"/>
            </a4j:outputPanel>
          </h:panelGroup>
          <h:panelGroup>
            <h:selectOneRadio id="mnuExamenCervix" immediate="true"
                                 required="true"
                              value="#{examenFisicoPrenatalUsuarioBean.control.hcpeexamcervix}">
              <f:selectItems value="#{examenFisicoPrenatalUsuarioBean.lstNormal}"/>
            </h:selectOneRadio>
            <a4j:outputPanel ajaxRendered="true">
              <t:message for="mnuExamenCervix" styleClass="errorMessage"/>
            </a4j:outputPanel>
          </h:panelGroup>
          <h:outputText value = "#{examenFisicoUsuarioBean.examen.hefaimc}"/>
          <h:outputText value="Altura Uterina" />
          <h:outputText value="Frecuencia Cardiaca Fetal"
                        styleClass="labelTextOblig"/>
          <h:outputText value="Valoración Cuello Uterino" styleClass="labelTextOblig"/>
           <h:outputText/>
          <h:panelGroup>
          <h:inputText value="#{examenFisicoPrenatalUsuarioBean.control.hcpnaltuterina}"
                       rendered="#{examenFisicoPrenatalUsuarioBean.habilitarAlturaUterina}"
                       maxlength="2" style="width:30px"/>
            <h:outputText value = "N/A" rendered="#{!examenFisicoPrenatalUsuarioBean.habilitarAlturaUterina}"/>
          </h:panelGroup>
          <h:panelGroup>
          <h:inputText id = "itFCF" value="#{examenFisicoPrenatalUsuarioBean.control.hcpnfcf}" required="true"
                       rendered="#{examenFisicoPrenatalUsuarioBean.habilitarFCF}"
                       maxlength="3" style="width:30px"/>
              <h:outputText value = "N/A" rendered="#{!examenFisicoPrenatalUsuarioBean.habilitarFCF}"/>
               <a4j:outputPanel ajaxRendered="true">
              <t:message for="itFCF" styleClass="errorMessage"/>
            </a4j:outputPanel>
            </h:panelGroup>
            
          <h:panelGroup>
          
          
            <h:selectOneRadio id="mnuValoracionCuello" immediate="true"
                                 required="true"
                              value="#{examenFisicoPrenatalUsuarioBean.control.hcpevalcueuter}">
              <f:selectItems value="#{examenFisicoPrenatalUsuarioBean.lstOpciones}"/>
            </h:selectOneRadio>
            <a4j:outputPanel ajaxRendered="true">
              <t:message for="mnuValoracionCuello" styleClass="errorMessage"/>
            </a4j:outputPanel>
          </h:panelGroup>
          
          <h:outputText/>
          <h:outputText value="Presentación Fetal"/>
          <h:outputText value="Edemas" styleClass="labelTextOblig"/>
          <h:outputText value="Estado Nutricional"
                        styleClass="labelTextOblig"/>
                        <h:outputText/>
        <h:panelGroup>
          <h:inputText value="#{examenFisicoPrenatalUsuarioBean.control.hcpcpresefetal}" required="false"
                      rendered="#{examenFisicoPrenatalUsuarioBean.habilitarpresentacionFetal}"
                       maxlength="10"/>
        <h:outputText value = "N/A" rendered="#{!examenFisicoPrenatalUsuarioBean.habilitarpresentacionFetal}"/>
        </h:panelGroup>
         <h:panelGroup>
            <h:selectOneRadio id="mnuEdemas" immediate="true"
                                 required="true"
                              value="#{examenFisicoPrenatalUsuarioBean.control.hcpeedemas}">
              <f:selectItems value="#{examenFisicoPrenatalUsuarioBean.lstOpciones}"/>
            </h:selectOneRadio>
            <a4j:outputPanel ajaxRendered="true">
              <t:message for="mnuEdemas" styleClass="errorMessage"/>
            </a4j:outputPanel>
          </h:panelGroup>
           <h:panelGroup>
                <h:selectOneMenu id="mnuEstadoNutricional" onkeydown="return blockEnter(event);" required="true"
                                 value="#{examenFisicoPrenatalUsuarioBean.control.hcpcestanutri}" styleClass="labelRadio">
                  <f:selectItems value="#{examenFisicoPrenatalUsuarioBean.lstEstadoNutricional}"/>
                </h:selectOneMenu>
                <a4j:outputPanel ajaxRendered="true">
                  <t:message for="mnuEstadoNutricional" styleClass="errorMessage"/>
                </a4j:outputPanel>
              </h:panelGroup>
            <h:panelGroup/>
            <h:outputText/>

        </h:panelGrid>
      
      </s:fieldset>

      
      <h:panelGrid columns="2" border="0" cellpadding="0" cellspacing="0"
                   width="100%" id="panelexamenFisicoPrenatalUsuarioBeanBoton"
                   columnClasses="panelGridBotones">
        <h:panelGroup>
          <h:commandButton value="Guardar" styleClass="boton_fieldset"
                             action="#{examenFisicoPrenatalUsuarioBean.aceptar}">
            <a4j:support event="onclick" status="statusButton"/>
            </h:commandButton>
        </h:panelGroup>
      </h:panelGrid>
    
    </h:panelGrid><h:panelGrid>
      <h:panelGroup>
        <a4j:outputPanel id="ajaxRegionexamenFisicoPrenatalUsuarioBean"
                         ajaxRendered="true">
          <t:htmlTag value="br"/>
          <t:messages id="msgInformationAndErrorsexamenFisicoPrenatalUsuarioBean"
                      showSummary="true" errorClass="error" globalOnly="true"
                      layout="table" infoClass="informacion"/>
        </a4j:outputPanel>
      </h:panelGroup>
    </h:panelGrid>
    
       <s:fieldset legend="Control Prenatal" id="fieldListaExamenesPrenatal"
                  styleClass="fieldset" rendered="#{not empty examenFisicoPrenatalUsuarioBean.lstControlPrenatal}">
        <h:panelGrid columns="1" border="0" cellpadding="0" cellspacing="0"
                     width="100%" id="tableControlPrenatal"
                     styleClass="tabContainer">
          <t:buffer into="#{table}">
            <h:dataTable var="item" border="1" cellpadding="0" cellspacing="0"
                         binding="#{examenFisicoPrenatalUsuarioBean.dtControl}"
                         value="#{examenFisicoPrenatalUsuarioBean.lstControlPrenatal}"
                         rows="10" styleClass="standard_table"
                         rowClasses="standardTable_Row1,standardTable_Row2"
                         footerClass="paginacion" id="dtControlPrenatal">
              <h:column>
                <f:facet name="header">
                  <h:outputText value="Fecha"/>
                </f:facet>
                <h:outputText value="#{item.hcpdfecharegis}"/>
              </h:column>
              <h:column>
                <f:facet name="header">
                  <h:outputText value="Peso"/>
                </f:facet>
                <h:outputText value="#{item.hcpapeso}"/>
              </h:column>
              <h:column>
                <f:facet name="header">
                  <h:outputText value="Altura Uterina"/>
                </f:facet>
                <h:outputText value="#{item.hcpnaltuterina}"/>
              </h:column>
              <h:column>
                <f:facet name="header">
                  <h:outputText value="Tension Arterial"/>
                </f:facet>
                <h:outputText value="#{item.hcpcpresart1} / #{item.hcpcpresart2} "/>
              </h:column>
              <h:column>
                <f:facet name="header">
                  <h:outputText value="FCF"/>
                </f:facet>
                <h:outputText value="#{item.hcpnfcf}"/>
              </h:column>
              
                <h:column>
                <f:facet name="header">
                  <h:outputText value="Mov Fetal"/>
                </f:facet>
                <h:outputText value="#{item.hcpcmovimfetal}"/>
              </h:column>
              
              <h:column>
                <f:facet name="header">
                  <h:outputText value="Presentación Fetal"/>
                </f:facet>
                <h:outputText value="#{item.hcpcpresefetal}"/>
              </h:column>
               <h:column>
                <f:facet name="header">
                  <h:outputText value="Val Cuello Uterino"/>
                </f:facet>
                <h:outputText value="#{item.hcpevalcueuter}"/>
              </h:column>
              <h:column>
                <f:facet name="header">
                  <h:outputText value="Edemas"/>
                </f:facet>
                <h:outputText value="#{item.hcpeedemas}"/>
              </h:column>
            </h:dataTable>
          </t:buffer>
          <t:buffer into="#{tableScroller}">
            <h:panelGrid columns="1" rowClasses="labelTextInfo,labelTextInfo">
              <t:dataScroller id="scroll_1" for="dtControlPrenatal"
                              fastStep="10" pageCountVar="pageCount"
                              pageIndexVar="pageIndex" styleClass="scroller"
                              paginator="true" immediate="true"
                              paginatorMaxPages="9"
                              paginatorTableClass="paginator"
                              renderFacetsIfSinglePage="false"
                              paginatorActiveColumnStyle="font-weight:bold;">
                <f:facet name="first">
                  <t:graphicImage alt=""  url="/comun/imagenes/primero.gif" border="0"/>
                </f:facet>
                <f:facet name="last">
                  <t:graphicImage alt=""  url="/comun/imagenes/ultimo.gif" border="0"/>
                </f:facet>
                <f:facet name="previous">
                  <t:graphicImage alt=""  url="/comun/imagenes/anterior.gif"
                                  border="0"/>
                </f:facet>
                <f:facet name="next">
                  <t:graphicImage alt=""  url="/comun/imagenes/siguiente.gif"
                                  border="0"/>
                </f:facet>
                <f:facet name="fastforward">
                  <t:graphicImage alt=""  url="/comun/imagenes/adelante.gif"
                                  border="0"/>
                </f:facet>
                <f:facet name="fastrewind">
                  <t:graphicImage alt=""  url="/comun/imagenes/atras.gif" border="0"/>
                </f:facet>
              </t:dataScroller>
            </h:panelGrid>
          </t:buffer>
          <h:outputText value="#{tableScroller}" escape="false"/>
          <h:outputText value="#{table}" escape="false"/>
          <h:outputText value="#{tableScroller}" escape="false"/>
        </h:panelGrid>
      </s:fieldset>
</t:panelTab>
</t:panelTabbedPane>
</h:panelGrid>
 
