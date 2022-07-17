<%@ page contentType="text/html;charset=iso-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsf/html" prefix="h"%>
<%@ taglib uri="http://java.sun.com/jsf/core" prefix="f"%>
<%@ taglib uri="http://richfaces.org/a4j" prefix="a4j"%>
<%@ taglib uri="http://myfaces.apache.org/tomahawk" prefix="t"%>
<%@ taglib uri="http://myfaces.apache.org/sandbox" prefix="s"%>
<h:panelGrid columns="1" border="0" cellpadding="0" cellspacing="0" width="100%" id="panelGridAntecedentesGeneralesTab"
             styleClass="tabContainer">
  <jsp:include page="/pages/clinico/comunes/encabezadoDatosUsuario.jsp" flush="true"/>
   <t:panelTabbedPane border="0" cellpadding="0" cellspacing="0"
                         serverSideTabSwitch="false" activePanelTabVar="true"
                         width="100%" id="panelTabbedPaneAntecedentes"
                         styleClass="tabbedPane" activeTabStyleClass="activeTab"
                         inactiveTabStyleClass="inactiveTab"
                         disabledTabStyleClass="disabledTab"
                         activeSubStyleClass="activeSub"
                         inactiveSubStyleClass="inactiveSub"
                         tabContentStyleClass="tabContent">
        <t:panelTab id="panelTabAntecedentes" label="Antecedentes Generales ">
        
        <h:panelGrid columns="6" border="0" cellpadding="0" cellspacing="0" width="100%" rendered="false"
                     id="panelDatosAplicacionComplicaciones" rowClasses="labelText,labelTextInfo">
          
          <h:outputText value="Ha presentado reacciones con anteriores vacunas ?"   styleClass="labelTextOblig"/>
          <h:outputText value=""/>
          <h:panelGroup id = "panelTextCualesReacciones">
          <h:outputText value="Cuales? "  rendered="#{antecedentesUsuarioBean.renderReacciones}" styleClass="labelTextOblig"/>
          </h:panelGroup>
          <h:outputText value=""/>
          <h:outputText value=""/>
          <h:outputText value=""/>
          <a4j:region renderRegionOnly="false">
          <h:selectOneRadio id="mnuReaccionesAnteriores" onkeydown="return blockEnter(event);"
                        required="true" immediate="true" 
                           value="#{antecedentesUsuarioBean.reaccionVacuna}"
                           valueChangeListener="#{antecedentesUsuarioBean.setHancreacvac}">
            <f:selectItems value="#{antecedentesUsuarioBean.lstOpciones}"/>
               <a4j:support id="supportmnuReaccionesAnteriores"  immediate="true"
                action="#{antecedentesUsuarioBean.changeReacciones}"
                           reRender="panelTextCualesReacciones,panelInputCualesReacciones" event="onclick">
                <a4j:ajaxListener type="org.ajax4jsf.ajax.ForceRender"/>
              </a4j:support>
            
          </h:selectOneRadio>
          </a4j:region>
          <a4j:outputPanel ajaxRendered="true">
            <t:message for="mnuReaccionesAnteriores" styleClass="errorMessage"/>
          </a4j:outputPanel>
          <h:panelGroup id = "panelInputCualesReacciones">
           <h:inputText id="textReacciones" value="#{antecedentesUsuarioBean.obsVacuna}" required="true"
            rendered="#{antecedentesUsuarioBean.renderReacciones}"
                       style="width:400px" maxlength="200"/>
                       
         </h:panelGroup>    
          <a4j:outputPanel ajaxRendered="true">
            <t:message for="textReacciones" styleClass="errorMessage"/>
          </a4j:outputPanel>
          <h:outputText value=""/>
          <h:outputText value=""/>
          
         
          
          
        </h:panelGrid>
        
              <s:fieldset legend="Antecedentes" id="fieldAntecedentes"
                      styleClass="fieldset">
                      
            <h:panelGrid columns="1" id="panelGridConsultar" rendered="#{empty antecedentesUsuarioBean.lstHistoricoAntecedente}">
              <h:outputText value="#{msg.msg_sin_antecedentes}"/>
            </h:panelGrid>
                 <h:panelGrid columns="1" border="0" cellpadding="0"
                             rendered="#{not empty antecedentesUsuarioBean.lstHistoricoAntecedente}"
                           cellspacing="0" width="100%" id="tableHistorico"
                           styleClass="tabContainer">
                <t:buffer into="#{tableAntecedentes}">
                  <h:dataTable var="item" border="1" cellpadding="0"
                               cellspacing="0"
                               value="#{antecedentesUsuarioBean.lstHistoricoAntecedente}"
                               rows="20" styleClass="standard_table"
                               rowClasses="standardTable_Row1,standardTable_Row2"
                               footerClass="paginacion" id="dtHistoricoAntecedentes">
                    <h:column>
                      <f:facet name="header">
                        <h:outputText value="Tipo Antecedente"/>
                      </f:facet>
                      <h:outputText value="#{item.hancnomtipante}"/>
                    </h:column>
                     <h:column>
                      <f:facet name="header">
                        <h:outputText value="Descripción"/>
                      </f:facet>
                      <h:outputText value="#{item.hantdescripcio}"/>
                    </h:column>
                    
                       <h:column>
                      <f:facet name="header">
                        <h:outputText value="Fecha Registro"/>
                      </f:facet>
                      <h:outputText value="#{item.handfecregistr}"/>
                    </h:column>
                               
                  </h:dataTable>
                </t:buffer>
                <t:buffer into="#{tableScrollerAntecedente}">
                  <h:panelGrid columns="1"
                               rowClasses="labelTextInfo,labelTextInfo">
                    <t:dataScroller id="scroll_Antecedente" for="dtHistoricoAntecedentes"
                                    fastStep="10" pageCountVar="pageCount"
                                    pageIndexVar="pageIndex"
                                    styleClass="scroller" paginator="true"
                                    immediate="true" paginatorMaxPages="9"
                                    paginatorTableClass="paginator"
                                    renderFacetsIfSinglePage="false"
                                    paginatorActiveColumnStyle="font-weight:bold;">
                      <f:facet name="first">
                        <t:graphicImage alt=""  url="/comun/imagenes/primero.gif"
                                        border="0"/>
                      </f:facet>
                      <f:facet name="last">
                        <t:graphicImage alt=""  url="/comun/imagenes/ultimo.gif"
                                        border="0"/>
                      </f:facet>
                      <f:facet name="previous">
                        <t:graphicImage  alt="" url="/comun/imagenes/anterior.gif"
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
                        <t:graphicImage alt=""  url="/comun/imagenes/atras.gif"
                                        border="0"/>
                      </f:facet>
                    </t:dataScroller>
                 
                  </h:panelGrid>
                </t:buffer>
                <h:outputText value="#{tableScrollerAntecedente}" escape="false"/>
                <h:outputText value="#{tableAntecedentes}" escape="false"/>
                <h:outputText value="#{tableScrollerAntecedente}" escape="false"/>
              </h:panelGrid>
              
            <h:panelGrid columns="1" border="0" cellpadding="0" cellspacing="0"
                         width="100%" id="panelAntecedentes"
                         rowClasses="labelText,labelTextInfo">
              <h:outputText value="Tiene Antecedentes Nuevos"
                            styleClass="labelTextOblig"/>
             <a4j:region renderRegionOnly="false">
              <h:selectOneRadio id="mnuAntecedentes" immediate="true"
                                required="true" onkeydown="return blockEnter(event);"
                                value="#{antecedentesUsuarioBean.nuevosAntecedentes}"
                                valueChangeListener="#{antecedentesUsuarioBean.setNuevosAntecedentes}">
                <f:selectItems value="#{antecedentesUsuarioBean.lstOpciones}"/>
                <a4j:support id="supportmnuAntecedentes" event="onclick"
                             
                             action="#{antecedentesUsuarioBean.changeAntecedentes}"
                             reRender="tableContentTabsAntecedentes">
                  <a4j:ajaxListener type="org.ajax4jsf.ajax.ForceRender"/>
                </a4j:support>
                <a4j:outputPanel ajaxRendered="true">
                  <t:message for="mnuAntecedentes" styleClass="errorMessage"/>
                </a4j:outputPanel>
              </h:selectOneRadio>
              </a4j:region>
            </h:panelGrid>
            
            
          </s:fieldset>
        

          <h:panelGrid columns="1" border="0" cellpadding="0" cellspacing="0"
                       width="100%" id="tableContentTabsAntecedentes"
                       styleClass="tabContainer">                               
         <s:fieldset legend="Seleccion de Antecedentes" id="fieldAntecedentesSeleccion"
                      styleClass="fieldset"   rendered="#{antecedentesUsuarioBean.mostrarAntecedentes}">
                         <h:panelGrid columns="9" id="changePreguntas">
             <a4j:region renderRegionOnly="false" rendered="#{antecedentesUsuarioBean.mostrarAntecedentes}">
              <h:outputText value="[ " style="font-size:8.0pt; font-weight:bold;"/>
              <a4j:commandLink style="font-size:8.0pt; font-weight:bold;" value=" Todos SI" immediate="true"
                               action="#{antecedentesUsuarioBean.changeTodosSi}" reRender="panelPreguntas"/>
              <h:outputText value=" | " style="font-size:8.0pt; font-weight:bold;"/>
              <a4j:commandLink style="font-size:8.0pt; font-weight:bold;" value="Todos NO " immediate="true"
                               action="#{antecedentesUsuarioBean.changeTodosNo}" reRender="panelPreguntas"/>
              <h:outputText value=" | " style="font-size:8.0pt; font-weight:bold;"/>
              <a4j:commandLink style="font-size:8.0pt; font-weight:bold;" value="Ninguno " immediate="true"
                               action="#{antecedentesUsuarioBean.changeNinguno}" reRender="panelPreguntas"/>
             </a4j:region>
            </h:panelGrid>
                 <h:panelGrid columns="2" border="0" cellpadding="0" cellspacing="0" width="100%" id="panelPreguntas"
                       rowClasses="labelText,labelTextInfo" >
                       <h:panelGroup rendered="#{antecedentesUsuarioBean.mostrarAntecedentes}" >
                <h:panelGrid columns="8" border="0" cellpadding="0" cellspacing="0" width="100%" id="panelCondiEspecificas" rowClasses="standardTable_ExamenFisico2,standardTable_ExamenFisico">
            <h:outputText value="Patológicos" rendered="#{antecedentesUsuarioBean.mostrarAntecedentes}" styleClass="labelTextOblig"/>
            <a4j:region renderRegionOnly="false">
              <h:selectOneRadio id="mnupato" required="true" rendered="#{antecedentesUsuarioBean.mostrarAntecedentes}" immediate="true"
                                value="#{antecedentesUsuarioBean.patologicos.hagcrefiere}" >
                <f:selectItems value="#{antecedentesUsuarioBean.lstOpcionesAntecedentes}"/>
                <a4j:support id="support1" action="#{antecedentesUsuarioBean.changePatologia}" reRender="panelPato,panelInputPato,chkPatologicos,mnupato" event="onclick">
                  <a4j:ajaxListener type="org.ajax4jsf.ajax.ForceRender"/>
                </a4j:support>
              </h:selectOneRadio>
            </a4j:region>
            <a4j:outputPanel ajaxRendered="true">
              <t:message for="mnupato" styleClass="errorMessage"/>
            </a4j:outputPanel>
            <h:panelGroup id="panelPato">
              <h:outputText value="Descripción" styleClass="labelTextOblig" rendered="#{antecedentesUsuarioBean.renderPatologicos}"/>
             
            </h:panelGroup>
            <h:panelGroup id="panelInputPato">
              <h:inputTextarea id="textPato"  required="true" rendered="#{antecedentesUsuarioBean.renderPatologicos}" value="#{antecedentesUsuarioBean.patologicos.hagcdescri}" style="width:350px">
                <f:validateLength maximum="100"/>
                </h:inputTextarea>
               
            </h:panelGroup>
            <a4j:outputPanel ajaxRendered="true">
              <t:message for="textPato" styleClass="errorMessage"/>
            </a4j:outputPanel>
            <h:outputLabel value=""/>
             <h:outputLabel value=""/>
                <h:outputText value="Quirúrgicos" styleClass="labelTextOblig"/>
            <a4j:region renderRegionOnly="false">
              <h:selectOneRadio id="mnuquir" required="true" immediate="true"  
                                value="#{antecedentesUsuarioBean.quirurgicos.hanqcrefiere}" >
                <f:selectItems value="#{antecedentesUsuarioBean.lstOpcionesAntecedentes}"/>
                <a4j:support id="supportmnuQuir" action="#{antecedentesUsuarioBean.changeQuirurgicos}" reRender="panelQuir,panelInputQuir,chkQuir,mnuquir" event="onclick">
                  <a4j:ajaxListener type="org.ajax4jsf.ajax.ForceRender"/>
                </a4j:support>
              </h:selectOneRadio>
            </a4j:region>
            <a4j:outputPanel ajaxRendered="true">
              <t:message for="mnuquir" styleClass="errorMessage"/>
            </a4j:outputPanel>
            <h:panelGroup id="panelQuir">
              <h:outputText value="Descripción" styleClass="labelTextOblig" rendered="#{antecedentesUsuarioBean.renderQuirurgicos}"/>
             
            </h:panelGroup>
            <h:panelGroup id="panelInputQuir">
              <h:inputTextarea id="textQuir" required="true" rendered="#{antecedentesUsuarioBean.renderQuirurgicos}" value="#{antecedentesUsuarioBean.quirurgicos.hanqcdesc}" style="width:250px">
                <f:validateLength maximum="100"/>
                </h:inputTextarea>
               
            </h:panelGroup>
            <a4j:outputPanel ajaxRendered="true">
              <t:message for="textQuir" styleClass="errorMessage"/>
            </a4j:outputPanel>
            <h:outputLabel value=""/>
             <h:outputLabel value=""/>
             <h:outputText value="Tóxicos" styleClass="labelTextOblig"/>
            <a4j:region renderRegionOnly="false">
              <h:selectOneRadio id="mnutox" required="true" immediate="true"  
                                value="#{antecedentesUsuarioBean.toxicos.hantcrefiere}" >
                <f:selectItems value="#{antecedentesUsuarioBean.lstOpcionesAntecedentes}"/>
                <a4j:support id="supportmnuTox" action="#{antecedentesUsuarioBean.changeToxicos}" reRender="panelTox,panelInputTox,mnutox" event="onclick">
                  <a4j:ajaxListener type="org.ajax4jsf.ajax.ForceRender"/>
                </a4j:support>
              </h:selectOneRadio>
            </a4j:region>
            <a4j:outputPanel ajaxRendered="true">
              <t:message for="mnutox" styleClass="errorMessage"/>
            </a4j:outputPanel>
            <h:panelGroup id="panelTox">
              <h:outputText value="Descripción" styleClass="labelTextOblig" rendered="#{antecedentesUsuarioBean.renderToxicos}"/>
             
            </h:panelGroup>
            <h:panelGroup id="panelInputTox">
              <h:inputTextarea id="texTox" required="true" rendered="#{antecedentesUsuarioBean.renderToxicos}" value="#{antecedentesUsuarioBean.toxicos.hantcdesc}" style="width:350px">
              <f:validateLength maximum="100"/>
              </h:inputTextarea>
            
               
            </h:panelGroup>
            <h:panelGroup/>
            <a4j:outputPanel ajaxRendered="true">
              <t:message for="textQuir" styleClass="errorMessage"/>
            </a4j:outputPanel>
             <h:outputLabel value=""/>
            <h:outputText value="Alérgicos" styleClass="labelTextOblig"/>
            <a4j:region renderRegionOnly="false">
              <h:selectOneRadio id="mnuale" required="true" immediate="true"  
                                value="#{antecedentesUsuarioBean.alergicos.hanacrefiere}" >
                <f:selectItems value="#{antecedentesUsuarioBean.lstOpcionesAntecedentes}"/>
                <a4j:support id="supportmnuAge" action="#{antecedentesUsuarioBean.changeAlergicos}" reRender="panelAle,panelInputAle,mnuale,chkAlergicos" event="onclick">
                  <a4j:ajaxListener type="org.ajax4jsf.ajax.ForceRender"/>
                </a4j:support>
              </h:selectOneRadio>
                 
            </a4j:region>
            <a4j:outputPanel ajaxRendered="true">
              <t:message for="mnuale" styleClass="errorMessage"/>
            </a4j:outputPanel>
            <h:panelGroup id="panelAle">
              <h:outputText value="Descripción" styleClass="labelTextOblig" rendered="#{antecedentesUsuarioBean.renderAlergicos}"/>
             
            </h:panelGroup>
            <h:panelGroup id="panelInputAle">
              <h:inputTextarea id="textAle" required="true" rendered="#{antecedentesUsuarioBean.renderAlergicos}" value="#{antecedentesUsuarioBean.alergicos.hanacdesc}" style="width:250px">
                <f:validateLength maximum="100"/>
                </h:inputTextarea>
               
            </h:panelGroup>
                <h:panelGrid columns="3" id="chkAlergicos">
                  <h:panelGroup>              
               <h:outputText value="Medicamento" rendered="#{antecedentesUsuarioBean.renderAlergicos}"/>
               </h:panelGroup>
                 <a4j:region renderRegionOnly="false">
                
                  <h:selectBooleanCheckbox style="border-style:none;" immediate="true"   rendered="#{antecedentesUsuarioBean.renderAlergicos}"
                                     value="#{antecedentesUsuarioBean.renderAlergicosChkbox2}">
                                      <a4j:support id="supportmnuAleChk2" action="#{antecedentesUsuarioBean.alergicosChkbox}" reRender="pgMed" event="onclick">
                        <a4j:ajaxListener type="org.ajax4jsf.ajax.ForceRender"/>
                    </a4j:support>
                    </h:selectBooleanCheckbox>
                    </a4j:region>
                    <h:panelGroup id="pgMed">
                        <h:outputText value="¿Cuál?" styleClass="labelTextOblig" rendered="#{antecedentesUsuarioBean.renderAlergicosChkbox2}"/>
                         <h:inputText  required="true" rendered="#{antecedentesUsuarioBean.renderAlergicosChkbox2}" value="#{antecedentesUsuarioBean.alergicos.hanacmedcual}">
                <f:validateLength maximum="100"/>
                </h:inputText>
                 </h:panelGroup>
                <h:panelGroup>              
               <h:outputText value="Alimento" rendered="#{antecedentesUsuarioBean.renderAlergicos}"/>
               </h:panelGroup>
                 <a4j:region renderRegionOnly="false">
                  <h:selectBooleanCheckbox style="border-style:none;" immediate="true"   rendered="#{antecedentesUsuarioBean.renderAlergicos}"
                                     value="#{antecedentesUsuarioBean.renderAlergicosChkbox1}">
                                      <a4j:support id="supportmnuAleChk1" action="#{antecedentesUsuarioBean.alergicosChkbox}" reRender="pgAli" event="onclick">
                        <a4j:ajaxListener type="org.ajax4jsf.ajax.ForceRender"/>
                    </a4j:support>
                    </h:selectBooleanCheckbox>
                    </a4j:region>
                    <h:panelGroup id="pgAli">
                        <h:outputText value="¿Cuál?" styleClass="labelTextOblig" rendered="#{antecedentesUsuarioBean.renderAlergicosChkbox1}"/>
                         <h:inputText  required="true" rendered="#{antecedentesUsuarioBean.renderAlergicosChkbox1}" value="#{antecedentesUsuarioBean.alergicos.hanacalicual}">
                <f:validateLength maximum="100"/>
                </h:inputText>
                 </h:panelGroup>
                             <h:panelGroup>              
               <h:outputText value="Sustancia del ambiente" rendered="#{antecedentesUsuarioBean.renderAlergicos}"/>
               </h:panelGroup>
                 <a4j:region renderRegionOnly="false">
                  <h:selectBooleanCheckbox style="border-style:none;" immediate="true"   rendered="#{antecedentesUsuarioBean.renderAlergicos}"
                                     value="#{antecedentesUsuarioBean.renderAlergicosChkbox5}">
                                      <a4j:support id="supportmnuAleChk5" action="#{antecedentesUsuarioBean.alergicosChkbox}" reRender="pgSusAmb" event="onclick">
                        <a4j:ajaxListener type="org.ajax4jsf.ajax.ForceRender"/>
                    </a4j:support>
                    </h:selectBooleanCheckbox>
                    </a4j:region>
                    <h:panelGroup id="pgSusAmb">
                        <h:outputText value="¿Cuál?" styleClass="labelTextOblig" rendered="#{antecedentesUsuarioBean.renderAlergicosChkbox5}"/>
                         <h:inputText  required="true" rendered="#{antecedentesUsuarioBean.renderAlergicosChkbox5}" value="#{antecedentesUsuarioBean.alergicos.hanacsusambcual}">
                <f:validateLength maximum="100"/>
                </h:inputText>
                 </h:panelGroup>
                  <h:panelGroup>              
               <h:outputText value="Sustancia que entra en contacto con la piel" rendered="#{antecedentesUsuarioBean.renderAlergicos}"/>
               </h:panelGroup>
                 <a4j:region renderRegionOnly="false">
                  <h:selectBooleanCheckbox style="border-style:none;" immediate="true"   rendered="#{antecedentesUsuarioBean.renderAlergicos}"
                                     value="#{antecedentesUsuarioBean.renderAlergicosChkbox6}">
                                      <a4j:support id="supportmnuAleChk6" action="#{antecedentesUsuarioBean.alergicosChkbox}" reRender="pgSusPiel" event="onclick">
                        <a4j:ajaxListener type="org.ajax4jsf.ajax.ForceRender"/>
                    </a4j:support>
                    </h:selectBooleanCheckbox>
                    </a4j:region>
                    <h:panelGroup id="pgSusPiel">
                        <h:outputText value="¿Cuál?" styleClass="labelTextOblig" rendered="#{antecedentesUsuarioBean.renderAlergicosChkbox6}"/>
                         <h:inputText  required="true" rendered="#{antecedentesUsuarioBean.renderAlergicosChkbox6}" value="#{antecedentesUsuarioBean.alergicos.hanacsuspielcual}">
                <f:validateLength maximum="100"/>
                </h:inputText>
                 </h:panelGroup>
                   <h:panelGroup>              
               <h:outputText value="Picadura de insecto" rendered="#{antecedentesUsuarioBean.renderAlergicos}"/>
               </h:panelGroup>
                 <a4j:region renderRegionOnly="false">
                  <h:selectBooleanCheckbox style="border-style:none;" immediate="true"   rendered="#{antecedentesUsuarioBean.renderAlergicos}"
                                     value="#{antecedentesUsuarioBean.renderAlergicosChkbox4}">
                                      <a4j:support id="supportmnuAleChk4" action="#{antecedentesUsuarioBean.alergicosChkbox}" reRender="pgPicad" event="onclick">
                        <a4j:ajaxListener type="org.ajax4jsf.ajax.ForceRender"/>
                    </a4j:support>
                    </h:selectBooleanCheckbox>
                    </a4j:region>
                    <h:panelGroup id="pgPicad">
                        <h:outputText value="¿Cuál?" styleClass="labelTextOblig" rendered="#{antecedentesUsuarioBean.renderAlergicosChkbox4}"/>
                         <h:inputText  required="true" rendered="#{antecedentesUsuarioBean.renderAlergicosChkbox4}" value="#{antecedentesUsuarioBean.alergicos.hanacpicadcual}">
                <f:validateLength maximum="100"/>
                </h:inputText>
                 </h:panelGroup>
                  <h:panelGroup>              
               <h:outputText value="Otra" rendered="#{antecedentesUsuarioBean.renderAlergicos}"/>
               </h:panelGroup>
                 <a4j:region renderRegionOnly="false">
                  <h:selectBooleanCheckbox style="border-style:none;" immediate="true"   rendered="#{antecedentesUsuarioBean.renderAlergicos}"
                                     value="#{antecedentesUsuarioBean.renderAlergicosChkbox3}">
                                      <a4j:support id="supportmnuAleChk3" action="#{antecedentesUsuarioBean.alergicosChkbox}" reRender="pgOtra" event="onclick">
                        <a4j:ajaxListener type="org.ajax4jsf.ajax.ForceRender"/>
                    </a4j:support>
                    </h:selectBooleanCheckbox>
                    </a4j:region>
                    <h:panelGroup id="pgOtra">
                        <h:outputText value="¿Cuál?" styleClass="labelTextOblig" rendered="#{antecedentesUsuarioBean.renderAlergicosChkbox3}"/>
                         <h:inputText  required="true" rendered="#{antecedentesUsuarioBean.renderAlergicosChkbox3}" value="#{antecedentesUsuarioBean.alergicos.hanacotracual}">
                <f:validateLength maximum="100"/>
                </h:inputText>
                 </h:panelGroup>
              </h:panelGrid>
            <a4j:outputPanel ajaxRendered="true">
              <t:message for="textAle" styleClass="errorMessage"/>
            </a4j:outputPanel>
            <h:outputText value=""/>
              <h:outputText value="Familiares" styleClass="labelTextOblig"/>
            <a4j:region renderRegionOnly="false">
              <h:selectOneRadio id="mnufam" required="true" immediate="true"  
                                value="#{antecedentesUsuarioBean.familiares.hanfcrefiere}" >
                <f:selectItems value="#{antecedentesUsuarioBean.lstOpcionesAntecedentes}"/>
                <a4j:support id="supportmnuFami" action="#{antecedentesUsuarioBean.changeFamiliares}" reRender="panelFam,panelInputFam,mnufam" event="onclick">
                  <a4j:ajaxListener type="org.ajax4jsf.ajax.ForceRender"/>
                </a4j:support>
              </h:selectOneRadio>
            </a4j:region>
            <a4j:outputPanel ajaxRendered="true">
              <t:message for="mnufam" styleClass="errorMessage"/>
            </a4j:outputPanel>
            <h:panelGroup id="panelFam">
              <h:outputText value="Descripción" styleClass="labelTextOblig" rendered="#{antecedentesUsuarioBean.renderFamiliares}"/>
             
            </h:panelGroup>
            <h:panelGroup id="panelInputFam">
              <h:inputTextarea id="textFam" required="true" rendered="#{antecedentesUsuarioBean.renderFamiliares}" value="#{antecedentesUsuarioBean.familiares.hanfcdesc}" style="width:350px">
                <f:validateLength maximum="100"/>
                </h:inputTextarea>
               
            </h:panelGroup>
            <a4j:outputPanel ajaxRendered="true">
              <t:message for="textFam" styleClass="errorMessage"/>
            </a4j:outputPanel>
             <h:outputText value=""/>
              <h:outputText value=""/>
             <h:outputText value="Transfusionales" styleClass="labelTextOblig"/>
            <a4j:region renderRegionOnly="false">
              <h:selectOneRadio id="mnutrans" required="true" immediate="true"  
                                value="#{antecedentesUsuarioBean.transfusionales.hantcrefiere}" >
                <f:selectItems value="#{antecedentesUsuarioBean.lstOpcionesAntecedentes}"/>
                <a4j:support id="supportmnuTrans" action="#{antecedentesUsuarioBean.changeTransfusionales}" reRender="panelTrans,panelInputTrans,mnutrans" event="onclick">
                  <a4j:ajaxListener type="org.ajax4jsf.ajax.ForceRender"/>
                </a4j:support>
              </h:selectOneRadio>
            </a4j:region>
            <a4j:outputPanel ajaxRendered="true">
              <t:message for="mnutrans" styleClass="errorMessage"/>
            </a4j:outputPanel>
            <h:panelGroup id="panelTrans">
              <h:outputText value="Descripción" styleClass="labelTextOblig" rendered="#{antecedentesUsuarioBean.renderTransfusionales}"/>
             
            </h:panelGroup>
            <h:panelGroup id="panelInputTrans">
              <h:inputTextarea id="textTrans" required="true" rendered="#{antecedentesUsuarioBean.renderTransfusionales}" value="#{antecedentesUsuarioBean.transfusionales.hantcdesc}" style="width:350px">
                <f:validateLength maximum="100"/>
                </h:inputTextarea>
               
            </h:panelGroup>
            <a4j:outputPanel ajaxRendered="true">
              <t:message for="textTrans" styleClass="errorMessage"/>
            </a4j:outputPanel>
              <h:outputText value=""/>
                <h:outputText value=""/>
              <h:outputText value="ITS" styleClass="labelTextOblig"/>
            <a4j:region renderRegionOnly="false">
              <h:selectOneRadio id="mnuits" required="true" immediate="true"  
                                value="#{antecedentesUsuarioBean.its.hanicrefiere}" >
                <f:selectItems value="#{antecedentesUsuarioBean.lstOpcionesAntecedentes}"/>
                <a4j:support id="supportmnuIts" action="#{antecedentesUsuarioBean.changeIts}" reRender="panelIts,panelInputIts,mnuits" event="onclick">
                  <a4j:ajaxListener type="org.ajax4jsf.ajax.ForceRender"/>
                </a4j:support>
              </h:selectOneRadio>
            </a4j:region>
            <a4j:outputPanel ajaxRendered="true">
              <t:message for="mnuits" styleClass="errorMessage"/>
            </a4j:outputPanel>
            <h:panelGroup id="panelIts">
              <h:outputText value="Descripción" styleClass="labelTextOblig" rendered="#{antecedentesUsuarioBean.renderITS}"/>
             
            </h:panelGroup>
            <h:panelGroup id="panelInputIts">
              <h:inputTextarea id="texIts" required="true" rendered="#{antecedentesUsuarioBean.renderITS}" value="#{antecedentesUsuarioBean.its.hanicdesc}" style="width:350px">
                <f:validateLength maximum="100"/>
                </h:inputTextarea>
               
            </h:panelGroup>
            <a4j:outputPanel ajaxRendered="true">
              <t:message for="texIts" styleClass="errorMessage"/>
            </a4j:outputPanel>
             <h:outputText value=""/>
                <h:outputText value=""/>
              <h:outputText value="Farmacológicos" styleClass="labelTextOblig"/>
            <a4j:region renderRegionOnly="false">
              <h:selectOneRadio id="mnufar" required="true" immediate="true"  
                                value="#{antecedentesUsuarioBean.farmacologicos.hanfcrefiere}" >
                <f:selectItems value="#{antecedentesUsuarioBean.lstOpcionesAntecedentes}"/>
                <a4j:support id="supportmnuFar" action="#{antecedentesUsuarioBean.changeFarmacologicos}" reRender="panelFar,panelInputFar,mnufar" event="onclick">
                  <a4j:ajaxListener type="org.ajax4jsf.ajax.ForceRender"/>
                </a4j:support>
              </h:selectOneRadio>
            </a4j:region>
            <a4j:outputPanel ajaxRendered="true">
              <t:message for="mnufar" styleClass="errorMessage"/>
            </a4j:outputPanel>
            <h:panelGroup id="panelFar">
              <h:outputText value="Descripción" styleClass="labelTextOblig" rendered="#{antecedentesUsuarioBean.renderFarmacologicos}"/>
             
            </h:panelGroup>
            <h:panelGroup id="panelInputFar">
              <h:inputTextarea id="textFar" required="true" rendered="#{antecedentesUsuarioBean.renderFarmacologicos}" value="#{antecedentesUsuarioBean.farmacologicos.hanfcdesc}" style="width:350px">
                <f:validateLength maximum="100"/>
                </h:inputTextarea>
               
            </h:panelGroup>
            <a4j:outputPanel ajaxRendered="true">
              <t:message for="textFar" styleClass="errorMessage"/>
            </a4j:outputPanel>
            <h:outputText value=""/>
             <h:outputText value=""/>
             <h:outputText value="Traumáticos" styleClass="labelTextOblig"/>
            <a4j:region renderRegionOnly="false">
              <h:selectOneRadio id="mnutra" required="true" immediate="true"  
                                value="#{antecedentesUsuarioBean.traumacologicos.hantcrefiere}" >
                <f:selectItems value="#{antecedentesUsuarioBean.lstOpcionesAntecedentes}"/>
                <a4j:support id="supportmnuTra" action="#{antecedentesUsuarioBean.changeTraumaticos}" reRender="panelTra,panelInputTra,mnutra" event="onclick">
                  <a4j:ajaxListener type="org.ajax4jsf.ajax.ForceRender"/>
                </a4j:support>
              </h:selectOneRadio>
            </a4j:region>
            <a4j:outputPanel ajaxRendered="true">
              <t:message for="mnutra" styleClass="errorMessage"/>
            </a4j:outputPanel>
            <h:panelGroup id="panelTra">
              <h:outputText value="Descripción" styleClass="labelTextOblig" rendered="#{antecedentesUsuarioBean.renderTraumaticos}"/>
             
            </h:panelGroup>
            <h:panelGroup id="panelInputTra">
              <h:inputTextarea id="texTra" required="true" rendered="#{antecedentesUsuarioBean.renderTraumaticos}" value="#{antecedentesUsuarioBean.traumacologicos.hantcdesc}" style="width:350px">
                <f:validateLength maximum="100"/>
                </h:inputTextarea>
               
            </h:panelGroup>
            <h:panelGroup/>
            <a4j:outputPanel ajaxRendered="true">
              <t:message for="texTra" styleClass="errorMessage"/>
            </a4j:outputPanel>
             <h:outputText value=""/>
              <h:outputText value=""/>    
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
        </h:panelGrid>

       
     
   
              </s:fieldset>
                <a4j:region renderRegionOnly="false">
              <h:panelGrid columns="2" border="0" cellpadding="0"
                           cellspacing="0" width="100%" id="panelBotonModificar"
                           columnClasses="panelGridBotones">
                <h:panelGroup>
                  <h:commandButton value="Guardar" styleClass="btn btn btn-success"
                                   action="#{antecedentesUsuarioBean.aceptar}">
                    <a4j:support event="onclick" status="statusButton"/>
                </h:commandButton>
                </h:panelGroup>
              </h:panelGrid>
            </a4j:region>
          </h:panelGrid>
          <h:panelGrid>
              <h:panelGroup>
                <a4j:outputPanel id="ajaxRegionMensajes" ajaxRendered="true">
                   <t:messages id="msgInf" showSummary="true" errorClass="error"
                              globalOnly="true" layout="table"
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