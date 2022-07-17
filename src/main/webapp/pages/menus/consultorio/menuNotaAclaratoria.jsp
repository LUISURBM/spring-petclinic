<%@ page contentType="text/html;charset=iso-8859-1"%>
<%@ taglib uri="http://richfaces.org/a4j" prefix="a4j"%>
<%@ taglib uri="http://java.sun.com/jsf/html" prefix="h"%>
<%@ taglib uri="http://myfaces.apache.org/tomahawk" prefix="t"%>
<%@ taglib uri="http://myfaces.apache.org/sandbox" prefix="s"%>
<%@ taglib uri="http://java.sun.com/jsf/core" prefix="f"%>
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
            <t:div id="toolBarInstrumentos">
                <s:accordionPanel id="menuToolsAccordion" layout="accordion" style="border-bottom:White !important;">
                    <t:panelTab label="Nota Aclaratoria" id="divToolsAccordionDir">
                        <h:panelGrid width="100%" cellpadding="0" cellspacing="0" border="0" columns="1"
                                     columnClasses="nivelTresBarra">
                            <h:commandLink value="Nota Aclaratoria" action="#{menuNotaAclaratoriaBean.irDatosNotaAclaratoria}"
                                           immediate="true"/>
                            <h:commandLink value="Consultar Folios" action="#{menuNotaAclaratoriaBean.irResumenHistoriaNotaAclaratoria}" rendered="#{menuNotaAclaratoriaBean.renderConsultaFolios}"
                                           immediate="true"/>
                            <h:commandButton value="Salir" action="#{menuNotaAclaratoriaBean.irSalir}" rendered="#{menuNotaAclaratoriaBean.renderSalir}"
                                           immediate="true"  onclick="if (!confirm(\'¿Realmente desea Salir de la Nota Aclaratoria\')) return false"/>                
                             <h:outputText value="Conducta" styleClass="label_itemmenu"
                                          rendered="#{menuNotaAclaratoriaBean.renderConducta}"/>
                            <h:commandLink value=" > Anatomia Patologica"
                                           action="#{menuNotaAclaratoriaBean.irAnatPatologicaNotaAclaratoria}"
                                           immediate="true" rendered="#{menuNotaAclaratoriaBean.renderConducta}"/>
                            <h:commandLink value=" > Violencia Sivigila"
                                           action="#{menuNotaAclaratoriaBean.irViolenciaSivigilaNotaAclaratoria}"
                                           immediate="true" rendered="#{menuNotaAclaratoriaBean.renderConducta}"/>              
                            <h:commandLink value=" > Control"
                                           action="#{menuNotaAclaratoriaBean.irControlSinCostoNotaAclaratoria}"
                                           immediate="true" rendered="#{menuNotaAclaratoriaBean.renderConducta}"/>
                            <h:commandLink value=" > Formula Medica"
                                           action="#{menuNotaAclaratoriaBean.irFormulaMedicaNotaAclaratoria}"
                                           immediate="true"
                                           rendered="#{menuNotaAclaratoriaBean.renderConducta && !menuNotaAclaratoriaBean.renderVademecum}"/>
                            <h:commandLink value=" > Formula Medica"
                                           action="#{menuNotaAclaratoriaBean.irVademecumMedicoNotaAclaratoria}"
                                           immediate="true"
                                           rendered="#{menuNotaAclaratoriaBean.renderConducta && menuNotaAclaratoriaBean.renderVademecum}"/>
                            <h:commandLink value=" > Remisión Hospitalización"
                                           action="#{menuNotaAclaratoriaBean.irRemHospitalizacionNotaAclaratoria}"
                                           immediate="true" rendered="#{menuNotaAclaratoriaBean.renderConducta}"/>
                            <h:commandLink value=" > Incapacidad"
                                           action="#{menuNotaAclaratoriaBean.irIncapacidadNotaAclaratoria}"
                                           immediate="true" rendered="#{menuNotaAclaratoriaBean.renderConducta}"/>
                            <h:commandLink value=" > Inter Consulta"
                                           action="#{menuNotaAclaratoriaBean.irInterConsultaNotaAclaratoria}"
                                           immediate="true" rendered="#{menuNotaAclaratoriaBean.renderConducta}"/>
                            <h:commandLink value=" > Cirugías y procedimientos"
                                           action="#{menuNotaAclaratoriaBean.irOrdenCirugiaNotaAclaratoria}"
                                           immediate="true" rendered="#{menuNotaAclaratoriaBean.renderConducta}"/>
                            <h:commandLink value=" > Recomendaciones" style="color:Green;"
                                           action="#{menuNotaAclaratoriaBean.irRecomedacionNotaAclaratoria}"
                                           immediate="true" rendered="#{menuNotaAclaratoriaBean.renderConducta}"/>
                            <h:commandLink value=" > Referencia"
                                           action="#{menuNotaAclaratoriaBean.irReferenciaNotaAclaratoria}"
                                           immediate="true" rendered="#{menuNotaAclaratoriaBean.renderConducta}"/>
                            <h:commandLink value=" > Autorización Servicios"
                                           action="#{menuNotaAclaratoriaBean.irAutorizacionServicioNotaAclaratoria}"
                                           immediate="true" rendered="#{menuNotaAclaratoriaBean.renderConducta}"/>
                            <h:commandLink value=" > Reserva de Sangre"
                                           action="#{menuNotaAclaratoriaBean.irReservaSangreNotaAclaratoria}"
                                           immediate="true" rendered="#{menuNotaAclaratoriaBean.renderConducta}"/>                                      
                        </h:panelGrid>
                    </t:panelTab>
                </s:accordionPanel>
            </t:div>
        </h:panelGrid>
    </t:div>
</h:panelGrid>