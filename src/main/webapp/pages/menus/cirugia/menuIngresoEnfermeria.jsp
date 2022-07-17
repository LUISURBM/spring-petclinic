<%@ page contentType="text/html;charset=iso-8859-1"%>
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
            <t:div id="toolBarInstrumentos">
                <s:accordionPanel id="menuToolsAccordion" layout="accordion" style="border-bottom:White !important;">
                    <t:panelTab label="Ingreso Enfermeria" id="divToolsAccordionDir" style="font-size:17px;">
                        <h:panelGrid width="100%" cellpadding="0" cellspacing="0" border="0" columns="1"
                                     columnClasses="nivelTresBarra">
                          
                          
                           <h:commandLink value="Cuestionario Covid"
                                           rendered="#{menuIngresoEnfermeriaBean.renderIngreso}"
                                           action="#{menuIngresoEnfermeriaBean.irCuestionarioCovidCirugia}"
                                           immediate="true" style="font-size:17px;"/>            
                                     
                            <h:commandLink value="#{menuIngresoEnfermeriaBean.legendAdmision}"
                                           rendered="#{menuIngresoEnfermeriaBean.renderCovid}"
                                           action="#{menuIngresoEnfermeriaBean.irPreparacionPreoperatoria}"
                                           immediate="true" style="font-size:17px;"/>
                           
                            <h:commandLink value="Signos Vitales"
                                           rendered="#{menuIngresoEnfermeriaBean.renderSignosVitales}"
                                           action="#{menuIngresoEnfermeriaBean.irIngresoSignosVitales}" 
                                           immediate="true"
                                           style="font-size:17px;"/>
                            <h:commandLink value="Notas de Enfermeria"
                                           rendered="#{menuIngresoEnfermeriaBean.renderSignosVitales}"
                                           style="font-size:17px;"
                                           action="#{menuIngresoEnfermeriaBean.irNotasEnfermeria}" immediate="true"/>
                            <h:commandLink value="Ingreso Liquidos" style="font-size:17px;"
                                           rendered="#{menuIngresoEnfermeriaBean.renderLiquidos}"
                                           action="#{menuIngresoEnfermeriaBean.irIngresoLiquidos}" immediate="true"/>
                            <h:commandLink value="Ingreso Medicamentos" style="font-size:17px;"
                                           rendered="#{menuIngresoEnfermeriaBean.renderLiquidos}"
                                           action="#{menuIngresoEnfermeriaBean.irIngresoMedicamento}" immediate="true"/>
                            <h:commandLink value="Otras Ordenes" style="font-size:17px;"
                                           rendered="#{menuIngresoEnfermeriaBean.notaEnferProceConsul}"
                                           action="#{menuIngresoEnfermeriaBean.irOtrasOrdenesIngresoEnfermeriaProcedimiento}" immediate="true"/>               
                                           
                                        
                           <h:commandLink value="Escala de Valoración de Caidas" style="font-size:17px;"
                                 rendered="#{menuIngresoEnfermeriaBean.renderEscalaValoracion}"
                                           action="#{menuIngresoEnfermeriaBean.irEscalaValoracionCaidasEnfermeriaProcedimiento}" immediate="true"/>               
                           
                           
                            <h:commandLink value="Cerrar Ingreso" style="font-size:17px;"
                                           rendered="#{menuIngresoEnfermeriaBean.renderCerrar}"
                                           action="#{menuIngresoEnfermeriaBean.irCerrarIngresoEnfermeria}"
                                           immediate="true"/>
                            <h:commandLink value="Salir" style="font-size:17px;"
                                           rendered="#{menuIngresoEnfermeriaBean.notaEnferProceConsul}"
                                           action="#{menuIngresoEnfermeriaBean.irSalirNortaEnfermeria}"
                                           immediate="true"/>
                        </h:panelGrid>
                    </t:panelTab>
                       <t:panelTab label="Resumen" id="divToolsAccordionResHist" style="font-size:17px;">
                        <h:panelGrid width="100%" cellpadding="0" cellspacing="0" border="0" columns="1" columnClasses="nivelTresBarra" rendered="#{!menuIngresoEnfermeriaBean.notaEnferProceConsul}">
                             <h:commandLink value="Consultar Resumen de Cirugía" action="#{menuIngresoEnfermeriaBean.irConsultarFoliosUsuarioCirugia}"
                                           immediate="true" style="font-size:17px;"/>
                      </h:panelGrid>
                       <h:panelGrid width="100%" cellpadding="0" cellspacing="0" border="0" columns="1" columnClasses="nivelTresBarra" rendered="#{menuIngresoEnfermeriaBean.notaEnferProceConsul}">
                             <h:commandLink value="Consultar Resumen de Procedimientos" action="#{menuIngresoEnfermeriaBean.irResumenHistoriaIngresoEnfermeriaProcedimiento}"
                                           immediate="true" style="font-size:17px;"/>
                      </h:panelGrid>
                    </t:panelTab>
                </s:accordionPanel>
            </t:div>
        </h:panelGrid>
    </t:div>
</h:panelGrid>