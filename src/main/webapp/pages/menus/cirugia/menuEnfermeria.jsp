<%@ page contentType="text/html;charset=iso-8859-1"%>
<%@ taglib uri="http://richfaces.org/a4j" prefix="a4j"%>
<%@ taglib uri="http://java.sun.com/jsf/html" prefix="h"%>
<%@ taglib uri="http://myfaces.apache.org/tomahawk" prefix="t"%>
<%@ taglib uri="http://myfaces.apache.org/sandbox" prefix="s"%>
<h:panelGrid columns="2" border="0" cellpadding="0" cellspacing="0" id="tableTools" columnClasses="barraHizq,verticalaligntop" width="100%">
    <t:div id="sideBarTab" styleClass="rollover">
        <a4j:commandLink id="sideBarTabClick" immediate="true" onclick="slideSideBar(); return false"/>
    </t:div>
    <t:div id="sideBarContents">
        <!-- style="display:none;"> -->
         
        <h:panelGrid columns="1" border="0" cellpadding="0" cellspacing="0" rowClasses="nivelUnoBarraH,fndBarraH,nivelUnoBarraH,fndBarraHerr" width="100%">
            <t:htmlTag value="h1">
                <h:outputText value=" "/>
            </t:htmlTag>
            <t:div id="toolBarInstrumentos">
                <s:accordionPanel id="menuToolsAccordion" layout="accordion" style="border-bottom:White !important;">
                    <t:panelTab label="Enfermeria" id="divToolsAccordionDir" disabled="#{menuEnfermeriaBean.salidaCirugia}" style="font-size:17px;">
                        <h:panelGrid width="100%" cellpadding="0" cellspacing="0" border="0" columns="1" columnClasses="nivelTresBarra">
                            <h:commandLink value="Notas de Enfermeria" rendered="#{!registrarNotaEnfermeriaBean.esSalida}" action="#{menuEnfermeriaBean.registrarNotasEnfermeria}" immediate="true"
                                           style="font-size:17px;"/>
                            <h:commandLink value="Liquidos" rendered="#{!registrarNotaEnfermeriaBean.esSalida}" action="#{menuEnfermeriaBean.registrarLiquidos}" immediate="true"
                                           style="font-size:17px;"/>
                            <h:commandLink value="Medicamentos" rendered="#{!registrarNotaEnfermeriaBean.esSalida}" action="#{menuEnfermeriaBean.registrarMedicamentos}" immediate="true"
                                           style="font-size:17px;"/>
                            <h:commandLink value="Signos Vitales" rendered="#{!registrarNotaEnfermeriaBean.esSalida}" action="#{menuEnfermeriaBean.registrarSignosVitales}" immediate="true"
                                           style="font-size:17px;"/>
                            <h:commandLink value="Otras Ordenes" rendered="#{!registrarNotaEnfermeriaBean.esSalida}" action="#{menuEnfermeriaBean.otrasOrdenes}" immediate="true"
                                           style="font-size:17px;"/>
                                           
                            <h:commandLink value="Escala Valoración Caidas"
                            action="#{menuEnfermeriaBean.irEscalaValoracionCaidasEnfermeria}" immediate="true"
                                           style="font-size:17px;"/>
                            <h:commandLink value="Aldrete" action="#{menuEnfermeriaBean.registrarAldrete}" rendered="#{menuEnfermeriaBean.renderAldrete  && !registrarNotaEnfermeriaBean.esSalida}"
                                               immediate="true" style="font-size:17px;"/>
                           <h:commandLink value="Bromage" action="#{menuEnfermeriaBean.registrarBromage}" rendered="#{menuEnfermeriaBean.renderBromage  && !registrarNotaEnfermeriaBean.esSalida}"
                                           immediate="true" style="font-size:17px;"/>
                            <h:commandLink value="Volver Listado Enfermeria" action="#{menuEnfermeriaBean.volverListadoEnfermeria}" immediate="true" style="font-size:17px;"/>
                        </h:panelGrid>
                    </t:panelTab>
                    <t:panelTab label="Resumen Historia" id="divToolsAccordionResHis" style="font-size:17px;">
                        <h:panelGrid width="100%" cellpadding="0" cellspacing="0" border="0" columns="1" columnClasses="nivelTresBarra">
                            <h:commandLink value=" Consultar Resumen Cirugia" action="#{menuEnfermeriaBean.irConsultarFoliosUsuarioCirugia}" immediate="true" style="font-size:17px;"/>
                             <h:commandLink value="Resumen Consulta Externa" style="font-size:15px;" 
                             action="#{menuEnfermeriaBean.irResumenHistoriaTotal}"   immediate="true" />    
                        </h:panelGrid>
                    </t:panelTab>
                </s:accordionPanel>
            </t:div>
        </h:panelGrid>
    </t:div>
</h:panelGrid>