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
            <t:div id="toolBarMnuTuberculina">
                <s:accordionPanel id="menuToolsTuberculina" layout="accordion"
                                  style="border-bottom:White !important;">
                    <t:panelTab label="Tuberculina" id="divToolsTuberculinaDir">
                        <h:panelGrid width="100%" cellpadding="0" cellspacing="0" border="0" columns="1"
                                     columnClasses="nivelTresBarra">
                                                                     
                            <h:commandLink value="Datos Usuario"
                                           action="#{menuTuberculinaBean.irDatosTuberculina}"
                                           immediate="true"/>
                             <h:commandLink value="Cuestionario Covid"
                                           rendered="#{menuTuberculinaBean.renderIngreso}"
                                           action="#{menuTuberculinaBean.irCuestionarioCovidTuberculina}"
                                           immediate="true" />  
                            <h:commandLink value="Antecedentes Especificos Tuberculina"
                                           action="#{menuTuberculinaBean.irAntecedentesTuberculina}"
                                           immediate="true" rendered="#{menuTuberculinaBean.primeraConsultacovid && menuTuberculinaBean.renderIngreso}"/>
                            <h:commandLink value="Antecedentes Patol�gicos Tuberculina"
                                           action="#{menuTuberculinaBean.irAntecedentesPatologicosTuberculina}"
                                           immediate="true" rendered="#{menuTuberculinaBean.renderAntpato}"/>
                            <h:commandLink value="Antecedentes Farmacol�gicos Actuales"
                                            action="#{menuTuberculinaBean.irAntecedentesFarmacologicosTuberculina}"
                                           immediate="true"  rendered="#{menuTuberculinaBean.renderAntfarm}"/>
                                             
                            <h:commandLink value="Pre - visualizar"
                                           action="#{menuTuberculinaBean.irCierreTuberculina}"
                                           immediate="true" rendered="#{menuTuberculinaBean.renderCierre}"/>
                        </h:panelGrid>
                    </t:panelTab>
                     
                </s:accordionPanel>
            </t:div>
        </h:panelGrid>
    </t:div>
</h:panelGrid>