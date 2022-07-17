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
          <h:outputText value="Cuales? "  rendered="#{antecedentesGeneralesUsuarioBean.renderReacciones}" styleClass="labelTextOblig"/>
          </h:panelGroup>
          <h:outputText value=""/>
          <h:outputText value=""/>
          <h:outputText value=""/>
          <a4j:region renderRegionOnly="false">
          <h:selectOneRadio id="mnuReaccionesAnteriores" onkeydown="return blockEnter(event);"
                        required="true" immediate="true" 
                           value="#{antecedentesGeneralesUsuarioBean.reaccionVacuna}"
                           valueChangeListener="#{antecedentesGeneralesUsuarioBean.setHancreacvac}">
            <f:selectItems value="#{antecedentesGeneralesUsuarioBean.lstOpciones}"/>
               <a4j:support id="supportmnuReaccionesAnteriores"  immediate="true"
                action="#{antecedentesGeneralesUsuarioBean.changeReacciones}"
                           reRender="panelTextCualesReacciones,panelInputCualesReacciones" event="onclick">
                <a4j:ajaxListener type="org.ajax4jsf.ajax.ForceRender"/>
              </a4j:support>
            
          </h:selectOneRadio>
          </a4j:region>
          <a4j:outputPanel ajaxRendered="true">
            <t:message for="mnuReaccionesAnteriores" styleClass="errorMessage"/>
          </a4j:outputPanel>
          <h:panelGroup id = "panelInputCualesReacciones">
           <h:inputText id="textReacciones" value="#{antecedentesGeneralesUsuarioBean.obsVacuna}" required="true"
            rendered="#{antecedentesGeneralesUsuarioBean.renderReacciones}"
                       style="width:400px" maxlength="200"/>
                       
         </h:panelGroup>    
          <a4j:outputPanel ajaxRendered="true">
            <t:message for="textReacciones" styleClass="errorMessage"/>
          </a4j:outputPanel>
          <h:outputText value=""/>
          <h:outputText value=""/>
          
         
          
          
        </h:panelGrid>
        
             
        

          <h:panelGrid columns="1" border="0" cellpadding="0" cellspacing="0"
                       width="100%" id="tableContentTabsAntecedentes"
                       styleClass="tabContainer">                               
         <s:fieldset legend="Seleccion de Antecedentes" id="fieldAntecedentesSeleccion"
                      styleClass="fieldset"   rendered="#{antecedentesGeneralesUsuarioBean.mostrarAntecedentes}">
                         <h:panelGrid columns="9" id="changePreguntas">
             <a4j:region renderRegionOnly="false" rendered="#{antecedentesGeneralesUsuarioBean.mostrarAntecedentes}">
              <h:outputText value="[ " style="font-size:8.0pt; font-weight:bold;"/>
              <a4j:commandLink style="font-size:8.0pt; font-weight:bold;" value=" Todos SI" immediate="true"
                               action="#{antecedentesGeneralesUsuarioBean.changeTodosSi}" reRender="panelPreguntas"/>
              <h:outputText value=" | " style="font-size:8.0pt; font-weight:bold;"/>
              <a4j:commandLink style="font-size:8.0pt; font-weight:bold;" value="Todos NO " immediate="true"
                               action="#{antecedentesGeneralesUsuarioBean.changeTodosNo}" reRender="panelPreguntas"/>
              <h:outputText value=" | " style="font-size:8.0pt; font-weight:bold;"/>
              <a4j:commandLink style="font-size:8.0pt; font-weight:bold;" value="Ninguno " immediate="true"
                               action="#{antecedentesGeneralesUsuarioBean.changeNinguno}" reRender="panelPreguntas"/>
             </a4j:region>
            </h:panelGrid>
                 <h:panelGrid columns="2" border="0" cellpadding="0" cellspacing="0" width="100%" id="panelPreguntas"
                       rowClasses="labelText,labelTextInfo" >
                       <h:panelGroup rendered="#{antecedentesGeneralesUsuarioBean.mostrarAntecedentes}" >
                <h:panelGrid columns="8" border="0" cellpadding="0" cellspacing="0" width="100%" id="panelCondiEspecificas" rowClasses="standardTable_ExamenFisico2,standardTable_ExamenFisico">
            <h:outputText value="Patológicos" rendered="#{antecedentesGeneralesUsuarioBean.mostrarAntecedentes}" styleClass="labelTextOblig"/>
            <a4j:region renderRegionOnly="false">
              <h:selectOneRadio id="mnupato" required="true" rendered="#{antecedentesGeneralesUsuarioBean.mostrarAntecedentes}" immediate="true"
                                value="#{antecedentesGeneralesUsuarioBean.patologicos.hagcrefiere}" >
                <f:selectItems value="#{antecedentesGeneralesUsuarioBean.lstOpcionesAntecedentes}"/>
                <a4j:support id="support1" action="#{antecedentesGeneralesUsuarioBean.changePatologia}" reRender="panelPato,panelInputPato,chkPatologicos,mnupato" event="onclick">
                  <a4j:ajaxListener type="org.ajax4jsf.ajax.ForceRender"/>
                </a4j:support>
              </h:selectOneRadio>
            </a4j:region>
            <a4j:outputPanel ajaxRendered="true">
              <t:message for="mnupato" styleClass="errorMessage"/>
            </a4j:outputPanel>
            <h:panelGroup id="panelPato">
              <h:outputText value="Descripción" styleClass="labelTextOblig" rendered="#{antecedentesGeneralesUsuarioBean.renderPatologicos}"/>
             
            </h:panelGroup>
            <h:panelGroup id="panelInputPato">
              <h:inputTextarea id="textPato"  required="true" rendered="#{antecedentesGeneralesUsuarioBean.renderPatologicos}" value="#{antecedentesGeneralesUsuarioBean.patologicos.hagcdescri}" style="width:350px">
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
                                value="#{antecedentesGeneralesUsuarioBean.quirurgicos.hanqcrefiere}" >
                <f:selectItems value="#{antecedentesGeneralesUsuarioBean.lstOpcionesAntecedentes}"/>
                <a4j:support id="supportmnuQuir" action="#{antecedentesGeneralesUsuarioBean.changeQuirurgicos}" reRender="panelQuir,panelInputQuir,chkQuir,mnuquir" event="onclick">
                  <a4j:ajaxListener type="org.ajax4jsf.ajax.ForceRender"/>
                </a4j:support>
              </h:selectOneRadio>
            </a4j:region>
            <a4j:outputPanel ajaxRendered="true">
              <t:message for="mnuquir" styleClass="errorMessage"/>
            </a4j:outputPanel>
            <h:panelGroup id="panelQuir">
              <h:outputText value="Descripción" styleClass="labelTextOblig" rendered="#{antecedentesGeneralesUsuarioBean.renderQuirurgicos}"/>
             
            </h:panelGroup>
            <h:panelGroup id="panelInputQuir">
              <h:inputTextarea id="textQuir" required="true" rendered="#{antecedentesGeneralesUsuarioBean.renderQuirurgicos}" value="#{antecedentesGeneralesUsuarioBean.quirurgicos.hanqcdesc}" style="width:250px">
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
                                value="#{antecedentesGeneralesUsuarioBean.toxicos.hantcrefiere}" >
                <f:selectItems value="#{antecedentesGeneralesUsuarioBean.lstOpcionesAntecedentes}"/>
                <a4j:support id="supportmnuTox" action="#{antecedentesGeneralesUsuarioBean.changeToxicos}" reRender="panelTox,panelInputTox,mnutox" event="onclick">
                  <a4j:ajaxListener type="org.ajax4jsf.ajax.ForceRender"/>
                </a4j:support>
              </h:selectOneRadio>
            </a4j:region>
            <a4j:outputPanel ajaxRendered="true">
              <t:message for="mnutox" styleClass="errorMessage"/>
            </a4j:outputPanel>
            <h:panelGroup id="panelTox">
              <h:outputText value="Descripción" styleClass="labelTextOblig" rendered="#{antecedentesGeneralesUsuarioBean.renderToxicos}"/>
             
            </h:panelGroup>
            <h:panelGroup id="panelInputTox">
              <h:inputTextarea id="texTox" required="true" rendered="#{antecedentesGeneralesUsuarioBean.renderToxicos}" value="#{antecedentesGeneralesUsuarioBean.toxicos.hantcdesc}" style="width:350px">
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
                                value="#{antecedentesGeneralesUsuarioBean.alergicos.hanacrefiere}" >
                <f:selectItems value="#{antecedentesGeneralesUsuarioBean.lstOpcionesAntecedentes}"/>
                <a4j:support id="supportmnuAge" action="#{antecedentesGeneralesUsuarioBean.changeAlergicos}" reRender="panelAle,panelInputAle,mnuale,chkAlergicos" event="onclick">
                  <a4j:ajaxListener type="org.ajax4jsf.ajax.ForceRender"/>
                </a4j:support>
              </h:selectOneRadio>
                 
            </a4j:region>
            <a4j:outputPanel ajaxRendered="true">
              <t:message for="mnuale" styleClass="errorMessage"/>
            </a4j:outputPanel>
            <h:panelGroup id="panelAle">
              <h:outputText value="Descripción" styleClass="labelTextOblig" rendered="#{antecedentesGeneralesUsuarioBean.renderAlergicos}"/>
             
            </h:panelGroup>
            <h:panelGroup id="panelInputAle">
              <h:inputTextarea id="textAle" required="true" rendered="#{antecedentesGeneralesUsuarioBean.renderAlergicos}" value="#{antecedentesGeneralesUsuarioBean.alergicos.hanacdesc}" style="width:250px">
                <f:validateLength maximum="100"/>
                </h:inputTextarea>
               
            </h:panelGroup>
             <h:panelGrid columns="3" id="chkAlergicos">
                  <h:panelGroup>              
               <h:outputText value="Medicamento" rendered="#{antecedentesGeneralesUsuarioBean.renderAlergicos}"/>
               </h:panelGroup>
                 <a4j:region renderRegionOnly="false">
                
                  <h:selectBooleanCheckbox style="border-style:none;" immediate="true"   rendered="#{antecedentesGeneralesUsuarioBean.renderAlergicos}"
                                     value="#{antecedentesGeneralesUsuarioBean.renderAlergicosChkbox2}">
                                      <a4j:support id="supportmnuAleChk2" action="#{antecedentesGeneralesUsuarioBean.alergicosChkbox}" reRender="pgMed" event="onclick">
                        <a4j:ajaxListener type="org.ajax4jsf.ajax.ForceRender"/>
                    </a4j:support>
                    </h:selectBooleanCheckbox>
                    </a4j:region>
                    <h:panelGroup id="pgMed">
                        <h:outputText value="¿Cuál?" styleClass="labelTextOblig" rendered="#{antecedentesGeneralesUsuarioBean.renderAlergicosChkbox2}"/>
                         <h:inputText  required="true" rendered="#{antecedentesGeneralesUsuarioBean.renderAlergicosChkbox2}" value="#{antecedentesGeneralesUsuarioBean.alergicos.hanacmedcual}">
                <f:validateLength maximum="100"/>
                </h:inputText>
                 </h:panelGroup>
                <h:panelGroup>              
               <h:outputText value="Alimento" rendered="#{antecedentesGeneralesUsuarioBean.renderAlergicos}"/>
               </h:panelGroup>
                 <a4j:region renderRegionOnly="false">
                  <h:selectBooleanCheckbox style="border-style:none;" immediate="true"   rendered="#{antecedentesGeneralesUsuarioBean.renderAlergicos}"
                                     value="#{antecedentesGeneralesUsuarioBean.renderAlergicosChkbox1}">
                                      <a4j:support id="supportmnuAleChk1" action="#{antecedentesGeneralesUsuarioBean.alergicosChkbox}" reRender="pgAli" event="onclick">
                        <a4j:ajaxListener type="org.ajax4jsf.ajax.ForceRender"/>
                    </a4j:support>
                    </h:selectBooleanCheckbox>
                    </a4j:region>
                    <h:panelGroup id="pgAli">
                        <h:outputText value="¿Cuál?" styleClass="labelTextOblig" rendered="#{antecedentesGeneralesUsuarioBean.renderAlergicosChkbox1}"/>
                         <h:inputText  required="true" rendered="#{antecedentesGeneralesUsuarioBean.renderAlergicosChkbox1}" value="#{antecedentesGeneralesUsuarioBean.alergicos.hanacalicual}">
                <f:validateLength maximum="100"/>
                </h:inputText>
                 </h:panelGroup>
                             <h:panelGroup>              
               <h:outputText value="Sustancia del ambiente" rendered="#{antecedentesGeneralesUsuarioBean.renderAlergicos}"/>
               </h:panelGroup>
                 <a4j:region renderRegionOnly="false">
                  <h:selectBooleanCheckbox style="border-style:none;" immediate="true"   rendered="#{antecedentesGeneralesUsuarioBean.renderAlergicos}"
                                     value="#{antecedentesGeneralesUsuarioBean.renderAlergicosChkbox5}">
                                      <a4j:support id="supportmnuAleChk5" action="#{antecedentesGeneralesUsuarioBean.alergicosChkbox}" reRender="pgSusAmb" event="onclick">
                        <a4j:ajaxListener type="org.ajax4jsf.ajax.ForceRender"/>
                    </a4j:support>
                    </h:selectBooleanCheckbox>
                    </a4j:region>
                    <h:panelGroup id="pgSusAmb">
                        <h:outputText value="¿Cuál?" styleClass="labelTextOblig" rendered="#{antecedentesGeneralesUsuarioBean.renderAlergicosChkbox5}"/>
                         <h:inputText  required="true" rendered="#{antecedentesGeneralesUsuarioBean.renderAlergicosChkbox5}" value="#{antecedentesGeneralesUsuarioBean.alergicos.hanacsusambcual}">
                <f:validateLength maximum="100"/>
                </h:inputText>
                 </h:panelGroup>
                  <h:panelGroup>              
               <h:outputText value="Sustancia que entra en contacto con la piel" rendered="#{antecedentesGeneralesUsuarioBean.renderAlergicos}"/>
               </h:panelGroup>
                 <a4j:region renderRegionOnly="false">
                  <h:selectBooleanCheckbox style="border-style:none;" immediate="true"   rendered="#{antecedentesGeneralesUsuarioBean.renderAlergicos}"
                                     value="#{antecedentesGeneralesUsuarioBean.renderAlergicosChkbox6}">
                                      <a4j:support id="supportmnuAleChk6" action="#{antecedentesGeneralesUsuarioBean.alergicosChkbox}" reRender="pgSusPiel" event="onclick">
                        <a4j:ajaxListener type="org.ajax4jsf.ajax.ForceRender"/>
                    </a4j:support>
                    </h:selectBooleanCheckbox>
                    </a4j:region>
                    <h:panelGroup id="pgSusPiel">
                        <h:outputText value="¿Cuál?" styleClass="labelTextOblig" rendered="#{antecedentesGeneralesUsuarioBean.renderAlergicosChkbox6}"/>
                         <h:inputText  required="true" rendered="#{antecedentesGeneralesUsuarioBean.renderAlergicosChkbox6}" value="#{antecedentesGeneralesUsuarioBean.alergicos.hanacsuspielcual}">
                <f:validateLength maximum="100"/>
                </h:inputText>
                 </h:panelGroup>
                   <h:panelGroup>              
               <h:outputText value="Picadura de insecto" rendered="#{antecedentesGeneralesUsuarioBean.renderAlergicos}"/>
               </h:panelGroup>
                 <a4j:region renderRegionOnly="false">
                  <h:selectBooleanCheckbox style="border-style:none;" immediate="true"   rendered="#{antecedentesGeneralesUsuarioBean.renderAlergicos}"
                                     value="#{antecedentesGeneralesUsuarioBean.renderAlergicosChkbox4}">
                                      <a4j:support id="supportmnuAleChk4" action="#{antecedentesGeneralesUsuarioBean.alergicosChkbox}" reRender="pgPicad" event="onclick">
                        <a4j:ajaxListener type="org.ajax4jsf.ajax.ForceRender"/>
                    </a4j:support>
                    </h:selectBooleanCheckbox>
                    </a4j:region>
                    <h:panelGroup id="pgPicad">
                        <h:outputText value="¿Cuál?" styleClass="labelTextOblig" rendered="#{antecedentesGeneralesUsuarioBean.renderAlergicosChkbox4}"/>
                         <h:inputText  required="true" rendered="#{antecedentesGeneralesUsuarioBean.renderAlergicosChkbox4}" value="#{antecedentesGeneralesUsuarioBean.alergicos.hanacpicadcual}">
                <f:validateLength maximum="100"/>
                </h:inputText>
                 </h:panelGroup>
                  <h:panelGroup>              
               <h:outputText value="Otra" rendered="#{antecedentesGeneralesUsuarioBean.renderAlergicos}"/>
               </h:panelGroup>
                 <a4j:region renderRegionOnly="false">
                  <h:selectBooleanCheckbox style="border-style:none;" immediate="true"   rendered="#{antecedentesGeneralesUsuarioBean.renderAlergicos}"
                                     value="#{antecedentesGeneralesUsuarioBean.renderAlergicosChkbox3}">
                                      <a4j:support id="supportmnuAleChk3" action="#{antecedentesGeneralesUsuarioBean.alergicosChkbox}" reRender="pgOtra" event="onclick">
                        <a4j:ajaxListener type="org.ajax4jsf.ajax.ForceRender"/>
                    </a4j:support>
                    </h:selectBooleanCheckbox>
                    </a4j:region>
                    <h:panelGroup id="pgOtra">
                        <h:outputText value="¿Cuál?" styleClass="labelTextOblig" rendered="#{antecedentesGeneralesUsuarioBean.renderAlergicosChkbox3}"/>
                         <h:inputText  required="true" rendered="#{antecedentesGeneralesUsuarioBean.renderAlergicosChkbox3}" value="#{antecedentesGeneralesUsuarioBean.alergicos.hanacotracual}">
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
                                value="#{antecedentesGeneralesUsuarioBean.familiares.hanfcrefiere}" >
                <f:selectItems value="#{antecedentesGeneralesUsuarioBean.lstOpcionesAntecedentes}"/>
                <a4j:support id="supportmnuFami" action="#{antecedentesGeneralesUsuarioBean.changeFamiliares}" reRender="panelFam,panelInputFam,mnufam" event="onclick">
                  <a4j:ajaxListener type="org.ajax4jsf.ajax.ForceRender"/>
                </a4j:support>
              </h:selectOneRadio>
            </a4j:region>
            <a4j:outputPanel ajaxRendered="true">
              <t:message for="mnufam" styleClass="errorMessage"/>
            </a4j:outputPanel>
            <h:panelGroup id="panelFam">
              <h:outputText value="Descripción" styleClass="labelTextOblig" rendered="#{antecedentesGeneralesUsuarioBean.renderFamiliares}"/>
             
            </h:panelGroup>
            <h:panelGroup id="panelInputFam">
              <h:inputTextarea id="textFam" required="true" rendered="#{antecedentesGeneralesUsuarioBean.renderFamiliares}" value="#{antecedentesGeneralesUsuarioBean.familiares.hanfcdesc}" style="width:350px">
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
                                value="#{antecedentesGeneralesUsuarioBean.transfusionales.hantcrefiere}" >
                <f:selectItems value="#{antecedentesGeneralesUsuarioBean.lstOpcionesAntecedentes}"/>
                <a4j:support id="supportmnuTrans" action="#{antecedentesGeneralesUsuarioBean.changeTransfusionales}" reRender="panelTrans,panelInputTrans,mnutrans" event="onclick">
                  <a4j:ajaxListener type="org.ajax4jsf.ajax.ForceRender"/>
                </a4j:support>
              </h:selectOneRadio>
            </a4j:region>
            <a4j:outputPanel ajaxRendered="true">
              <t:message for="mnutrans" styleClass="errorMessage"/>
            </a4j:outputPanel>
            <h:panelGroup id="panelTrans">
              <h:outputText value="Descripción" styleClass="labelTextOblig" rendered="#{antecedentesGeneralesUsuarioBean.renderTransfusionales}"/>
             
            </h:panelGroup>
            <h:panelGroup id="panelInputTrans">
              <h:inputTextarea id="textTrans" required="true" rendered="#{antecedentesGeneralesUsuarioBean.renderTransfusionales}" value="#{antecedentesGeneralesUsuarioBean.transfusionales.hantcdesc}" style="width:350px">
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
                                value="#{antecedentesGeneralesUsuarioBean.its.hanicrefiere}" >
                <f:selectItems value="#{antecedentesGeneralesUsuarioBean.lstOpcionesAntecedentes}"/>
                <a4j:support id="supportmnuIts" action="#{antecedentesGeneralesUsuarioBean.changeIts}" reRender="panelIts,panelInputIts,mnuits" event="onclick">
                  <a4j:ajaxListener type="org.ajax4jsf.ajax.ForceRender"/>
                </a4j:support>
              </h:selectOneRadio>
            </a4j:region>
            <a4j:outputPanel ajaxRendered="true">
              <t:message for="mnuits" styleClass="errorMessage"/>
            </a4j:outputPanel>
            <h:panelGroup id="panelIts">
              <h:outputText value="Descripción" styleClass="labelTextOblig" rendered="#{antecedentesGeneralesUsuarioBean.renderITS}"/>
             
            </h:panelGroup>
            <h:panelGroup id="panelInputIts">
              <h:inputTextarea id="texIts" required="true" rendered="#{antecedentesGeneralesUsuarioBean.renderITS}" value="#{antecedentesGeneralesUsuarioBean.its.hanicdesc}" style="width:350px">
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
                                value="#{antecedentesGeneralesUsuarioBean.farmacologicos.hanfcrefiere}" >
                <f:selectItems value="#{antecedentesGeneralesUsuarioBean.lstOpcionesAntecedentes}"/>
                <a4j:support id="supportmnuFar" action="#{antecedentesGeneralesUsuarioBean.changeFarmacologicos}" reRender="panelFar,panelInputFar,mnufar" event="onclick">
                  <a4j:ajaxListener type="org.ajax4jsf.ajax.ForceRender"/>
                </a4j:support>
              </h:selectOneRadio>
            </a4j:region>
            <a4j:outputPanel ajaxRendered="true">
              <t:message for="mnufar" styleClass="errorMessage"/>
            </a4j:outputPanel>
            <h:panelGroup id="panelFar">
              <h:outputText value="Descripción" styleClass="labelTextOblig" rendered="#{antecedentesGeneralesUsuarioBean.renderFarmacologicos}"/>
             
            </h:panelGroup>
            <h:panelGroup id="panelInputFar">
              <h:inputTextarea id="textFar" required="true" rendered="#{antecedentesGeneralesUsuarioBean.renderFarmacologicos}" value="#{antecedentesGeneralesUsuarioBean.farmacologicos.hanfcdesc}" style="width:350px">
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
                                value="#{antecedentesGeneralesUsuarioBean.traumacologicos.hantcrefiere}" >
                <f:selectItems value="#{antecedentesGeneralesUsuarioBean.lstOpcionesAntecedentes}"/>
                <a4j:support id="supportmnuTra" action="#{antecedentesGeneralesUsuarioBean.changeTraumaticos}" reRender="panelTra,panelInputTra,mnutra" event="onclick">
                  <a4j:ajaxListener type="org.ajax4jsf.ajax.ForceRender"/>
                </a4j:support>
              </h:selectOneRadio>
            </a4j:region>
            <a4j:outputPanel ajaxRendered="true">
              <t:message for="mnutra" styleClass="errorMessage"/>
            </a4j:outputPanel>
            <h:panelGroup id="panelTra">
              <h:outputText value="Descripción" styleClass="labelTextOblig" rendered="#{antecedentesGeneralesUsuarioBean.renderTraumaticos}"/>
             
            </h:panelGroup>
            <h:panelGroup id="panelInputTra">
              <h:inputTextarea id="texTra" required="true" rendered="#{antecedentesGeneralesUsuarioBean.renderTraumaticos}" value="#{antecedentesGeneralesUsuarioBean.traumacologicos.hantcdesc}" style="width:350px">
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
                                   action="#{antecedentesGeneralesUsuarioBean.aceptar}">
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