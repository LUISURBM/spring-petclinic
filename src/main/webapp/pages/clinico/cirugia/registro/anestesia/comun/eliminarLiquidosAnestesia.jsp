<%@ page contentType="text/html;charset=iso-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsf/html" prefix="h"%>
<%@ taglib uri="http://java.sun.com/jsf/core" prefix="f"%>
<%@ taglib uri="http://myfaces.apache.org/tomahawk" prefix="t"%>
<%@ taglib uri="http://myfaces.apache.org/sandbox" prefix="s"%>
<%@ taglib uri="http://richfaces.org/a4j" prefix="a4j"%>
<a4j:region renderRegionOnly="false">
  <s:fieldset legend="Liquidos Eliminados" id="fieldLiquidosEliminados" styleClass="fieldset">
    <h:panelGrid columns="8" border="0" cellpadding="0" cellspacing="0" width="100%"
                 rowClasses="labelText,labelTextInfo" id="panelEliminarLiquidos">
      <h:outputText value="Diuresis" styleClass="labelTextOblig"/>
      <h:outputText/>
      <h:panelGroup id="panelTextTipoDiuresis">
        <h:outputText value="Tipo Diuresis" styleClass="labelTextOblig"
                      rendered="#{registrarLiquidosAnestesiaBean.renderDiuresis}"/>
      </h:panelGroup>
      <h:outputText/>
      <h:panelGroup id="panelTextCuantificadaDiuresis">
        <h:outputText value="Cuantificada" styleClass="labelTextOblig"
                      rendered="#{registrarLiquidosAnestesiaBean.renderDiuresis}"/>
      </h:panelGroup>
      <h:outputText/>
      <h:panelGroup id="panelTextCantidadDiuresis">
        <h:outputText value="Cantidad(mL)" styleClass="labelTextOblig"
                      rendered="#{registrarLiquidosAnestesiaBean.renderCantidadDiuresis && registrarLiquidosAnestesiaBean.renderDiuresis}"/>
      </h:panelGroup>
      <h:outputText/>
      <!-- segunda fila -->
      <a4j:region renderRegionOnly="false">
        <h:selectOneRadio id="mnuDiuresis" immediate="true" 
                          value="#{registrarLiquidosAnestesiaBean.liquidoDelete.hclcdiuresis}"
                          binding="#{registrarLiquidosAnestesiaBean.mnuDiuresis}"
                          valueChangeListener="#{registrarLiquidosAnestesiaBean.setHclcdiuresis}">
          <f:selectItems value="#{registrarLiquidosAnestesiaBean.lstOpciones}"/>
          <a4j:support id="supportmnuDiuresis" event="onclick" action="#{registrarLiquidosAnestesiaBean.changeDiuresis}"
                       reRender="panelTextTipoDiuresis,panelTextCuantificadaDiuresis,panelTextCantidadDiuresis,panelMenuTipoDiuresis,panelMsgTipoDiuresis,panelMenuCuantificadaDiuresis,panelInputCantidadDiuresis,panelMsgCantidadDiuresis">
            <a4j:ajaxListener type="org.ajax4jsf.ajax.ForceRender"/>
          </a4j:support>
        </h:selectOneRadio>
      </a4j:region>
      <a4j:outputPanel ajaxRendered="true">
        <t:message for="mnuDiuresis" styleClass="errorMessage"/>
      </a4j:outputPanel>
      <h:panelGroup id="panelMenuTipoDiuresis">
        <h:selectOneRadio id="mnuTipoDiuresis" immediate="true" 
                          rendered="#{registrarLiquidosAnestesiaBean.renderDiuresis}"
                          binding="#{registrarLiquidosAnestesiaBean.mnuTipoDiuresis}"
                          value="#{registrarLiquidosAnestesiaBean.liquidoDelete.hclctipodiure}">
          <f:selectItems value="#{registrarLiquidosAnestesiaBean.lstTipoDiuresis}"/>
        </h:selectOneRadio>
      </h:panelGroup>
      <h:panelGroup id="panelMsgTipoDiuresis">
        <a4j:outputPanel ajaxRendered="true" rendered="#{registrarLiquidosAnestesiaBean.renderDiuresis}">
          <t:message for="mnuTipoDiuresis" styleClass="errorMessage"/>
        </a4j:outputPanel>
      </h:panelGroup>
      <a4j:region renderRegionOnly="false">
        <h:panelGroup id="panelMenuCuantificadaDiuresis">
          <h:selectOneRadio id="mnuCuantificadaDiuresis" immediate="true" 
                            binding="#{registrarLiquidosAnestesiaBean.mnuCuantificadaDiuresis}"
                            rendered="#{registrarLiquidosAnestesiaBean.renderDiuresis}"
                            value="#{registrarLiquidosAnestesiaBean.liquidoDelete.hclccuantdiure}"
                            valueChangeListener="#{registrarLiquidosAnestesiaBean.setHclccuantdiure}">
            <f:selectItems value="#{registrarLiquidosAnestesiaBean.lstOpciones}"/>
            <a4j:support id="supportmnuCuantificadaDiuresis" event="onclick"
                         action="#{registrarLiquidosAnestesiaBean.changeCuantificadaDiuresis}"
                         reRender="panelTextCantidadDiuresis,panelInputCantidadDiuresis,panelMsgCantidadDiuresis">
              <a4j:ajaxListener type="org.ajax4jsf.ajax.ForceRender"/>
            </a4j:support>
          </h:selectOneRadio>
        </h:panelGroup>
      </a4j:region>
      <h:panelGroup id="panelMsgCuantificadaDiuresis">
        <a4j:outputPanel ajaxRendered="true" rendered="#{registrarLiquidosAnestesiaBean.renderDiuresis}">
          <t:message for="mnuCuantificadaDiuresis" styleClass="errorMessage"/>
        </a4j:outputPanel>
      </h:panelGroup>
      <h:panelGroup id="panelInputCantidadDiuresis">
        <h:inputText id="itCantidadDiuresis" immediate="true" 
                     binding="#{registrarLiquidosAnestesiaBean.itCantidadDiuresis}"
                     rendered="#{registrarLiquidosAnestesiaBean.renderCantidadDiuresis && registrarLiquidosAnestesiaBean.renderDiuresis}"
                     maxlength="4" style="width:50px" value="#{registrarLiquidosAnestesiaBean.liquidoDelete.hclndiuresis}"/>
      </h:panelGroup>
      <h:panelGroup id="panelMsgCantidadDiuresis">
        <a4j:outputPanel ajaxRendered="true"
                         rendered="#{registrarLiquidosAnestesiaBean.renderCantidadDiuresis && registrarLiquidosAnestesiaBean.renderDiuresis}">
          <t:message for="itCantidadDiuresis" styleClass="errorMessage"/>
        </a4j:outputPanel>
      </h:panelGroup>
      
      <!-- tercera fila -->
      
      <h:outputText value="Deposiciones" styleClass="labelTextOblig"/>
      <h:outputText/>
      <h:panelGroup id="panelTextCuantificadaDeposiciones">
        <h:outputText value="Cuantificada" styleClass="labelTextOblig"
                      rendered="#{registrarLiquidosAnestesiaBean.renderDeposiciones}"/>
      </h:panelGroup>
      <h:outputText/>
      <h:panelGroup id="panelTextCantidadDeposiciones">
        <h:outputText value="Cantidad(mL)" styleClass="labelTextOblig"
                      rendered="#{registrarLiquidosAnestesiaBean.renderCantidadDeposiciones && registrarLiquidosAnestesiaBean.renderDeposiciones}"/>
      </h:panelGroup>
      <h:outputText/>
      <h:outputText/>
      <h:outputText/>
      <!-- Cuarta fila-->
      <a4j:region renderRegionOnly="false">
        <h:selectOneRadio id="mnuDeposiciones" immediate="true" 
                          value="#{registrarLiquidosAnestesiaBean.liquidoDelete.hclcdeposicion}"
                          binding="#{registrarLiquidosAnestesiaBean.mnuDeposiciones}"
                          valueChangeListener="#{registrarLiquidosAnestesiaBean.setHclcdeposicion}">
          <f:selectItems value="#{registrarLiquidosAnestesiaBean.lstOpciones}"/>
          <a4j:support id="supportmnuDeposiciones" event="onclick" action="#{registrarLiquidosAnestesiaBean.changeDeposiciones}"
                       reRender="panelTextCuantificadaDeposiciones,panelTextCantidadDeposiciones,panelMenuCuantificadaDeposiciones,panelMsgCuantificadaDeposiciones,panelInputCantidadDeposiciones,panelMsgCantidadDeposiciones">
            <a4j:ajaxListener type="org.ajax4jsf.ajax.ForceRender"/>
          </a4j:support>
        </h:selectOneRadio>
      </a4j:region>
      <a4j:outputPanel ajaxRendered="true">
        <t:message for="mnuDeposiciones" styleClass="errorMessage"/>
      </a4j:outputPanel>
      <a4j:region renderRegionOnly="false">
        <h:panelGroup id="panelMenuCuantificadaDeposiciones">
          <a4j:region renderRegionOnly="false">
            <h:selectOneRadio id="mnuCuantificadaDeposiciones" immediate="true" 
                              binding="#{registrarLiquidosAnestesiaBean.mnuCuantificadaDeposiciones}"
                              rendered="#{registrarLiquidosAnestesiaBean.renderDeposiciones}"
                              value="#{registrarLiquidosAnestesiaBean.liquidoDelete.hclccuantdepos}"
                              valueChangeListener="#{registrarLiquidosAnestesiaBean.setHclccuantdepos}">
              <f:selectItems value="#{registrarLiquidosAnestesiaBean.lstOpciones}"/>
              <a4j:support id="supportmnuCuantificadaDeposiciones" event="onclick"
                           action="#{registrarLiquidosAnestesiaBean.changeCuantificadaDeposiciones}"
                           reRender="panelTextCantidadDeposiciones,panelInputCantidadDeposiciones,panelMsgCantidadDeposiciones">
                <a4j:ajaxListener type="org.ajax4jsf.ajax.ForceRender"/>
              </a4j:support>
            </h:selectOneRadio>
          </a4j:region>
        </h:panelGroup>
      </a4j:region>
      <h:panelGroup id="panelMsgCuantificadaDeposiciones">
        <a4j:outputPanel ajaxRendered="true" rendered="#{registrarLiquidosAnestesiaBean.renderDeposiciones}">
          <t:message for="mnuCuantificadaDeposiciones" styleClass="errorMessage"/>
        </a4j:outputPanel>
      </h:panelGroup>
      <h:panelGroup id="panelInputCantidadDeposiciones">
        <h:inputText id="itCantidadDeposiciones"  immediate="true"
                     binding="#{registrarLiquidosAnestesiaBean.itCantidadDeposiciones}"
                     rendered="#{registrarLiquidosAnestesiaBean.renderCantidadDeposiciones && registrarLiquidosAnestesiaBean.renderDeposiciones}"
                     maxlength="4" style="width:50px" value="#{registrarLiquidosAnestesiaBean.liquidoDelete.hclndeposicion}"/>
      </h:panelGroup>
      <h:panelGroup id="panelMsgCantidadDeposiciones">
        <a4j:outputPanel ajaxRendered="true"
                         rendered="#{registrarLiquidosAnestesiaBean.renderCantidadDeposiciones && registrarLiquidosAnestesiaBean.renderDeposiciones}">
          <t:message for="itCantidadDeposiciones" styleClass="errorMessage"/>
        </a4j:outputPanel>
      </h:panelGroup>
      <h:outputText/>
      <h:outputText/>
      <!-- Quinta fila -->
      <h:outputText value="Emesis" styleClass="labelTextOblig"/>
      <h:outputText/>
      <h:panelGroup id="panelCuantifiEme">
      <h:outputText value="Cuantificada" styleClass="labelTextOblig" rendered="#{registrarLiquidosAnestesiaBean.renderEmesis}"/>
      </h:panelGroup>
      <h:outputText/>
      <h:panelGroup id="panelCantiEme">
      <h:outputText value="Cantidad mL" styleClass="labelTextOblig" rendered="#{registrarLiquidosAnestesiaBean.renderEmeCuanti}"/>
      </h:panelGroup>
      <h:outputText/>
      <h:outputText/>
      <h:outputText/>
      <!-- -->
      <a4j:region renderRegionOnly="false">
        <h:selectOneRadio id="mnuEmesis" immediate="true" 
                          value="#{registrarLiquidosAnestesiaBean.liquidoDelete.hclcemesis}"
                          binding="#{registrarLiquidosAnestesiaBean.mnuEmesis}"
                          valueChangeListener="#{registrarLiquidosAnestesiaBean.setHclcemesis}">
          <f:selectItems value="#{registrarLiquidosAnestesiaBean.lstOpciones}"/>
          <a4j:support id="supportmnuEmesis" event="onclick" action="#{registrarLiquidosAnestesiaBean.changeEmesis}"
                       reRender="panelMenuCuantificadaEmesis, panelCuantifiEme">
            <a4j:ajaxListener type="org.ajax4jsf.ajax.ForceRender"/>
          </a4j:support>
        </h:selectOneRadio>
      </a4j:region>
      <h:outputText/>
      
        <a4j:region renderRegionOnly="false">
        <h:panelGroup id="panelMenuCuantificadaEmesis">
          <a4j:region renderRegionOnly="false">
        <h:selectOneRadio id="mnuCuantifi" immediate="true"
                            rendered="#{registrarLiquidosAnestesiaBean.renderEmesis}"
                            value="#{registrarLiquidosAnestesiaBean.liquidoDelete.hclcemecua}"
                            binding="#{registrarLiquidosAnestesiaBean.mnuCuantifi}"
                            valueChangeListener="#{registrarLiquidosAnestesiaBean.setHclcemecua}">
          <f:selectItems value="#{registrarLiquidosAnestesiaBean.lstOpciones}"/>
          <a4j:support id="supportmnuCuantifi" event="onclick" action="#{registrarLiquidosAnestesiaBean.changeEmesisCuanti}"
                        reRender="cantidadCuanti,panelCantiEme">
            <a4j:ajaxListener type="org.ajax4jsf.ajax.ForceRender"/>
          </a4j:support>
        </h:selectOneRadio>
      </a4j:region>
      </h:panelGroup>
      </a4j:region>
      <h:outputText/>
      <h:panelGroup id="cantidadCuanti">
      <h:inputText id="itCantidadEmesis" maxlength="3" style="width:50px" rendered="#{registrarLiquidosAnestesiaBean.renderEmeCuanti}" immediate="true"
      binding="#{registrarLiquidosAnestesiaBean.itCantidadEmesis}" value="#{registrarLiquidosAnestesiaBean.liquidoDelete.hclnemecan}"/>
      </h:panelGroup>
      <h:outputText/>
      <h:outputText/>
      <h:outputText/>
      <!-- -->
      <h:outputText value="Drenaje" styleClass="labelTextOblig"/>
      <h:outputText/>
      <h:panelGroup id="panelTextTipoDrenaje">
        <h:outputText value="Tipo Drenaje" styleClass="labelTextOblig" rendered="#{registrarLiquidosAnestesiaBean.renderDrenaje}"/>
      </h:panelGroup>
      <h:outputText/>
      <h:panelGroup id="panelTextCuantificadaDrenaje">
        <h:outputText value="Cuantificado" styleClass="labelTextOblig" rendered="#{registrarLiquidosAnestesiaBean.renderDrenaje}"/>
      </h:panelGroup>
      <h:outputText/>
      <h:panelGroup id="panelTextCantidadDrenaje">
        <h:outputText value="Cantidad en mililitros" styleClass="labelTextOblig"
                      rendered="#{registrarLiquidosAnestesiaBean.renderCantidadDrenaje && registrarLiquidosAnestesiaBean.renderDrenaje}"/>
      </h:panelGroup>
      <h:outputText/>
      <!-- -->
      <a4j:region renderRegionOnly="false">
        <h:selectOneRadio id="mnuDrenaje" immediate="true"  binding="#{registrarLiquidosAnestesiaBean.mnuDrenaje}"
                          value="#{registrarLiquidosAnestesiaBean.liquidoDelete.hclcdrenaje}"
                          valueChangeListener="#{registrarLiquidosAnestesiaBean.setHclcdrenaje}">
          <f:selectItems value="#{registrarLiquidosAnestesiaBean.lstOpciones}"/>
          <a4j:support id="supportmnuDrenaje" event="onclick" action="#{registrarLiquidosAnestesiaBean.changeDrenaje}"
                       reRender="panelTextTipoDrenaje,panelTextCuantificadaDrenaje,panelTextCantidadDrenaje,panelMenuTipoDrenaje,panelMsgTipoDrenaje,panelMenuCuantificadaDrenaje,panelMsgCuantificadaDrenaje,panelInputCantidadDrenaje,panelMsgCantidadDrenaje">
            <a4j:ajaxListener type="org.ajax4jsf.ajax.ForceRender"/>
          </a4j:support>
        </h:selectOneRadio>
      </a4j:region>
      <a4j:outputPanel ajaxRendered="true">
        <t:message for="mnuDrenaje" styleClass="errorMessage"/>
      </a4j:outputPanel>
      <h:panelGroup id="panelMenuTipoDrenaje">
        <h:selectOneRadio id="mnuTipoDrenaje" immediate="true" 
                          rendered="#{registrarLiquidosAnestesiaBean.renderDrenaje}"
                          binding="#{registrarLiquidosAnestesiaBean.mnuTipoDrenaje}"
                          value="#{registrarLiquidosAnestesiaBean.liquidoDelete.hclctipodrena}">
          <f:selectItems value="#{registrarLiquidosAnestesiaBean.lstTipoDrenaje}"/>
        </h:selectOneRadio>
      </h:panelGroup>
      <h:panelGroup id="panelMsgTipoDrenaje">
        <a4j:outputPanel ajaxRendered="true" rendered="#{registrarLiquidosAnestesiaBean.renderDrenaje}">
          <t:message for="mnuTipoDrenaje" styleClass="errorMessage"/>
        </a4j:outputPanel>
      </h:panelGroup>
      <a4j:region renderRegionOnly="false">
        <h:panelGroup id="panelMenuCuantificadaDrenaje">
          <a4j:region renderRegionOnly="false">
            <h:selectOneRadio id="mnuCuantificadaDrenaje" immediate="true" 
                              binding="#{registrarLiquidosAnestesiaBean.mnuCuantificadaDrenaje}"
                              rendered="#{registrarLiquidosAnestesiaBean.renderDrenaje}"
                              value="#{registrarLiquidosAnestesiaBean.liquidoDelete.hclccuantdrena}"
                              valueChangeListener="#{registrarLiquidosAnestesiaBean.setHclccuantdrena}">
              <f:selectItems value="#{registrarLiquidosAnestesiaBean.lstOpciones}"/>
              <a4j:support id="supportmnuCuantificadaDrenaje" event="onclick"
                           action="#{registrarLiquidosAnestesiaBean.changeCuantificadaDrenaje}"
                           reRender="panelTextCantidadDrenaje,panelInputCantidadDrenaje,panelMsgCantidadDrenaje">
                <a4j:ajaxListener type="org.ajax4jsf.ajax.ForceRender"/>
              </a4j:support>
            </h:selectOneRadio>
          </a4j:region>
        </h:panelGroup>
      </a4j:region>
      <h:panelGroup id="panelMsgCuantificadaDrenaje">
        <a4j:outputPanel ajaxRendered="true" rendered="#{registrarLiquidosAnestesiaBean.renderDrenaje}">
          <t:message for="mnuCuantificadaDrenaje" styleClass="errorMessage"/>
        </a4j:outputPanel>
      </h:panelGroup>
      <h:panelGroup id="panelInputCantidadDrenaje">
        <h:inputText id="itCantidadDrenaje"  maxlength="4" style="width:50px" immediate="true"
                     binding="#{registrarLiquidosAnestesiaBean.itCantidadDrenaje}"
                     rendered="#{registrarLiquidosAnestesiaBean.renderCantidadDrenaje && registrarLiquidosAnestesiaBean.renderDrenaje}"
                     value="#{registrarLiquidosAnestesiaBean.liquidoDelete.hclndrenaje}"/>
      </h:panelGroup>
      <h:panelGroup id="panelMsgCantidadDrenaje">
        <a4j:outputPanel ajaxRendered="true"
                         rendered="#{registrarLiquidosAnestesiaBean.renderCantidadDrenaje && registrarLiquidosAnestesiaBean.renderDrenaje}">
          <t:message for="itCantidadDrenaje" styleClass="errorMessage"/>
        </a4j:outputPanel>
      </h:panelGroup>
      <!--  -->
      <h:outputText value="Observaciones"/>
      <h:outputText/>
      <h:outputText/>
      <h:outputText/>
      <h:outputText/>
      <h:outputText/>
      <h:outputText/>
      <h:outputText/>
      <!-- -->
      <h:panelGroup>
        <h:inputTextarea id="itObservacionesElimi" style="width:600px" onkeydown="return blockEnter(event);"
                         value="#{registrarLiquidosAnestesiaBean.liquidoDelete.hclcobsliqelim}" immediate="true" >
          <f:validateLength maximum="600"/>
        </h:inputTextarea>
        <a4j:outputPanel ajaxRendered="true">
          <t:message for="itObservacionesElimi" styleClass="errorMessage"/>
        </a4j:outputPanel>
      </h:panelGroup>
      <h:outputText/>
      <h:outputText/>
      <h:outputText/>
    </h:panelGrid>
    <h:panelGrid columns="2" border="0" cellpadding="0" cellspacing="0" width="100%" id="panelBotonAgregarEliminar"
                 columnClasses="columnaBotones">
      <h:panelGroup>
        <t:htmlTag value="br"/>
        <a4j:commandButton value="Agregar" styleClass="btn btn btn-success"
                           action="#{registrarLiquidosAnestesiaBean.agregarLiquidoEliminacion}"
                           reRender="panelTabEliminarLiquidos"/>
      </h:panelGroup>
    </h:panelGrid>
  </s:fieldset>
</a4j:region>


<s:fieldset legend="Liquidos Eliminados" id="fieldListaLiquidosEliminados" styleClass="fieldset">
  <h:panelGrid columns="1" border="0" cellpadding="0" cellspacing="0" width="100%" id="tableLiquidosEliminadosSinDatos"
               rendered="#{empty registrarLiquidosAnestesiaBean.lstLiquidosEliminadosSelect}" styleClass="tabContainer">
    <h:outputText value="#{msg.msg_sin_Datos}"/>
  </h:panelGrid>
  <h:panelGrid columns="1" border="0" cellpadding="0" cellspacing="0" width="100%" id="tableLiquidosEliminados"
               rendered="#{not empty registrarLiquidosAnestesiaBean.lstLiquidosEliminadosSelect}" styleClass="tabContainer">
    <t:buffer into="#{table}">
      <h:dataTable var="item" border="1" cellpadding="0" cellspacing="0"
                   value="#{registrarLiquidosAnestesiaBean.lstLiquidosEliminadosSelect}"
                   binding="#{registrarLiquidosAnestesiaBean.dtLiquidosEliminados}" rows="5" styleClass="standard_table"
                   rowClasses="standardTable_Row1,standardTable_Row2" footerClass="paginacion"
                   id="dtLiquidosEliminados">
        <h:column> 
          <f:facet name="header">
            <h:outputText value="Hora  Registro"/>
          </f:facet>
          <h:outputText value="#{item.hcldhoraactivi}" style="align:center"/>
        </h:column>
        <h:column>
          <f:facet name="header">
            <h:outputText value="Tipo Diuresis "/>
          </f:facet>
          <h:outputText value="#{item.desTipoDiuresis}"/>
        </h:column>
        <h:column>
          <f:facet name="header">
            <h:outputText value="Cantidad Diuresis"/>
          </f:facet>
          <h:outputText value="#{item.cantidadDiuresis}"/>
        </h:column>
        <h:column>
          <f:facet name="header">
            <h:outputText value="Cantidad  Deposiciones"/>
          </f:facet>
          <h:outputText value="#{item.cantidadDeposiciones}"/>
        </h:column>
        <h:column>
          <f:facet name="header">
            <h:outputText value="Cantidad Emesis"/>
          </f:facet>
          <h:outputText value="#{item.hclnemecan}"/>
        </h:column>
        <h:column>
          <f:facet name="header">
            <h:outputText value="Tipo Drenaje"/>
          </f:facet>
          <h:outputText value="#{item.desTipoDrenaje}"/>
        </h:column>
        <h:column>
          <f:facet name="header">
            <h:outputText value="Cantidad Drenaje"/>
          </f:facet>
          <h:outputText value="#{item.cantidadDrenaje}"/>
        </h:column>
        <h:column>
          <f:facet name="header">
            <h:outputText value="Observaciones"/>
          </f:facet>
          <h:outputText value="#{item.hclcobsliqelim}"/>
        </h:column>
        <h:column>
          <f:facet name="header">
            <h:outputText value="Eliminar"/>
          </f:facet>
          <a4j:commandLink id="eliminar" immediate="true"
                           onclick="if(!confirm(\' Desea remover este registro ? \')){ return false; }"
                           action="#{registrarLiquidosAnestesiaBean.deleteLiquidoEliminado}"
                           reRender="fieldListaLiquidosEliminados">
            <t:graphicImage alt="" border="0" url="/comun/imagenes/quitar.gif"/>
          </a4j:commandLink>
        </h:column>
      </h:dataTable>
    </t:buffer>
    <t:buffer into="#{tableScroller}">
      <h:panelGrid columns="1" rowClasses="labelTextInfo,labelTextInfo">
        <t:dataScroller id="scroll_7" for="dtLiquidosEliminados" fastStep="10" pageCountVar="pageCount"
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
<h:panelGrid columns="1" border="0" cellpadding="0" cellspacing="0" width="100%" id="panelBotonesEliminacion"
             columnClasses="panelGridBotones">
  <h:panelGroup>
    <h:commandButton value="Registrar Eliminación Líquidos" styleClass="btn btn btn-success" immediate="true"
                     action="#{registrarLiquidosAnestesiaBean.IngresoLiquidosEliminados}"/>
  </h:panelGroup>
</h:panelGrid>