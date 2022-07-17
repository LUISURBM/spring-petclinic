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
            <t:div id="toolBarInstrumentosAnestesia">
                <s:accordionPanel id="menuToolsAccordionAnestesia" layout="accordion" 
                                  style="border-bottom:White !important;">
                    <t:panelTab label="Anestesia" id="divToolsAccordionDir" style="font-size:17px;">
                        <h:panelGrid width="100%" cellpadding="0" cellspacing="0" border="0" columns="1"
                                     columnClasses="nivelTresBarra" >
                            <h:commandLink value="Datos del Paciente" 
                                        action="#{menuAnestesiaBean.irDatosEntrada}"
                                           immediate="true" style="font-size:17px;"/>
                            <h:commandLink value="Posici�n y otras medidas de protecci�n"
                                           action="#{menuAnestesiaBean.irMedidasProteccion}" rendered="#{menuAnestesiaBean.esValidoAnestesia}"
                                           immediate="true" style="font-size:17px;"/>
                            <h:commandLink value="Signos Vitales" action="#{menuAnestesiaBean.irSignosVitales}" 
                                           immediate="true" style="font-size:17px;" rendered="#{menuAnestesiaBean.esValidoAnestesia}"/>
                            <h:commandLink value="Monitor�a" action="#{menuAnestesiaBean.irMonitoria}"
                                            immediate="true" style="font-size:17px;" rendered="#{menuAnestesiaBean.esValidoAnestesia}"/>
                            <h:commandLink value="Balance de l�quidos" action="#{menuAnestesiaBean.irBalanceLiquidos}"
                                           immediate="true" style="font-size:17px;" rendered="#{menuAnestesiaBean.esValidoAnestesia}"/>
                            <h:commandLink value="Control de medicamentos" style="font-size:17px;"
                                           action="#{menuAnestesiaBean.irControlMedicamentos}"  immediate="true" rendered="#{menuAnestesiaBean.esValidoAnestesia}"/>
                            <h:commandLink value="Ventilacion y Manejo de V�a a�rea" style="font-size:17px;"
                                           action="#{menuAnestesiaBean.irViaAerea}" rendered="#{menuAnestesiaBean.esValidoAnestesia}"
                                            immediate="true"/>
                            <h:commandLink value="T�cnica anest�sica" action="#{menuAnestesiaBean.irTecnicaAnestesia}"
                                           rendered="#{menuAnestesiaBean.renderTecnica && menuAnestesiaBean.esValidoAnestesia}" immediate="true" style="font-size:17px;"/>
                            <h:commandLink value="Finalizaci�n de Atenci�n" style="font-size:17px;" rendered="#{menuAnestesiaBean.esValidoAnestesia}"
                                           action="#{menuAnestesiaBean.irCerrarAnestesia}"  immediate="true"/>
                         <h:outputText value=" > Ordenes M�dicas" styleClass="label_itemmenu" style="font-size:17px;" rendered="#{menuAnestesiaBean.esValidoAnestesia}"/>
                            <h:commandLink value=" >> Formular L�quidos" style="font-size:17px;"
                                           action="#{menuAnestesiaBean.irFormularLiquidosAnestesia}" immediate="true" rendered="#{menuAnestesiaBean.esValidoAnestesia}"/>
                            <h:commandLink value=" >> Formular Medicamentos" style="font-size:17px;"
                                           action="#{menuAnestesiaBean.irFormularMedicamentosAnestesia}" immediate="true" rendered="#{menuAnestesiaBean.esValidoAnestesia}"/>
                            <h:commandLink value=" >> Otras Ordenes" style="font-size:17px;"
                                           action="#{menuAnestesiaBean.irRegistrarOtrasOrdenesAnestesia}" immediate="true" rendered="#{menuAnestesiaBean.esValidoAnestesia}"/>               
                            
                                           
                        </h:panelGrid>
                    </t:panelTab>
                    <t:panelTab label="Resumen Cirug�a" id="divToolsAccordionResHi" style="font-size:17px;">
                        <h:panelGrid width="100%" cellpadding="0" cellspacing="0" border="0" columns="1" columnClasses="nivelTresBarra">
                             <h:commandLink value="Consultar Resumen de Cirug�a" action="#{menuAnestesiaBean.irConsultarFoliosUsuarioCirugia}"
                                           immediate="true" style="font-size:17px;"/>    
                             <h:commandLink value="Consultar Historia Total" action="#{menuAnestesiaBean.irResumenHistoriaTotal}"
                                           immediate="true" style="font-size:17px;"/>    
                                           
                       
                      </h:panelGrid>
                    </t:panelTab>
                </s:accordionPanel>
            </t:div>
        </h:panelGrid>
    </t:div>
</h:panelGrid>