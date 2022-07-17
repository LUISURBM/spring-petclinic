</html><%@ page contentType="text/html;charset=iso-8859-1"%>
<%@ taglib uri="http://richfaces.org/a4j" prefix="a4j"%>
<%@ taglib uri="http://java.sun.com/jsf/html" prefix="h"%>
<%@ taglib uri="http://myfaces.apache.org/tomahawk" prefix="t"%>
<%@ taglib uri="http://myfaces.apache.org/sandbox" prefix="s"%>
<h:panelGrid columns="2" border="0" cellpadding="0" cellspacing="0" id="tableTools"
             columnClasses="barraHizq,verticalaligntop" width="100%">
    <t:div id="sideBarTab" styleClass="rollover">
        <a4j:commandLink id="sideBarTabClick" immediate="true" onclick="slideSideBar(); return false"/>
    </t:div>
    <t:div id="sideBarContents">
        <!-- style="display:none;"> -->
         
        <h:panelGrid columns="1" border="0" cellpadding="0" cellspacing="0"
                     rowClasses="nivelUnoBarraH,fndBarraH,nivelUnoBarraH,fndBarraHerr" width="100%">
            <t:htmlTag value="h1">
                <h:outputText value=" "/>
            </t:htmlTag>
            <t:div id="toolBarMnuFragmentacionEsperma">
                <s:accordionPanel id="menuToolsFragmentacionEsperma" layout="accordion"
                                  style="border-bottom:White !important;">
                    <t:panelTab label="Test Fragmentacion Espermatica" id="divToolsFragmentacionEspermaDir">
                        <h:panelGrid width="100%" cellpadding="0" cellspacing="0" border="0" columns="1"
                                     columnClasses="nivelTresBarra">
                                                                     
                            <h:commandLink value="Datos Usuario"
                                           action="#{menuFragmentacionEspermaBean.irDatosFragmentacionEsperma}"
                                           immediate="true"/>
                             <h:commandLink value="Cuestionario Covid"
                                           rendered="#{menuFragmentacionEspermaBean.renderIngreso}"
                                           action="#{menuFragmentacionEspermaBean.irCuestionarioCovidFragmentacionEsperma}"
                                           immediate="true" />  
                            <h:commandLink value="Test de Fragmentacion Espermática"
                                           action="#{menuFragmentacionEspermaBean.irTestFragmentacionEsperma}"
                                           immediate="true" rendered="#{menuFragmentacionEspermaBean.primeraConsultacovid && menuFragmentacionEspermaBean.renderIngreso}"/>
                                                                        
                            <h:commandLink value="Pre - visualizar"
                                           action="#{menuFragmentacionEspermaBean.irCierreFragmentacionEsperma}"
                                           immediate="true" rendered="#{menuFragmentacionEspermaBean.renderCierre}"/>
                        </h:panelGrid>
                    </t:panelTab>
                     
                </s:accordionPanel>
            </t:div>
        </h:panelGrid>
    </t:div>
</h:panelGrid>