<%@ page contentType="text/html;charset=windows-1252"%>
<%@ taglib uri="http://java.sun.com/jsf/html" prefix="h"%>
<%@ taglib uri="http://java.sun.com/jsf/core" prefix="f"%>
<h:panelGrid columns="3" cellpadding="0" border="0" cellspacing="2" id="tableUser1" style="text-align:left;"
             width="100%" styleClass="imagenProfa">
             
   <h:outputText value=" " styleClass="header2" />
   <h:outputText value=" " styleClass="header2" />
   <h:outputText value="Usuario: #{MenuBean.nombUsuario}" id="idUsuario" styleClass="header2" style="font-size:10.0px; font-weight:bold;color:white"/>
   <h:outputText value=" " styleClass="header2" />
   <h:outputText value=" " styleClass="header2" />
   <h:outputText value="Clinica: #{MenuBean.clinUsuario}" id="idClinica" styleClass="header2" style="font-size:10.0px; font-weight:bold;color:white"/>
  <h:outputText value=" " styleClass="header2" />
  <h:outputText value=" " styleClass="header2" />
    <h:outputText value="IP ADDRESS: #{MenuBean.direccionIP}" id="idDireccionIP" styleClass="header2" style="font-size:10.0px; font-weight:bold;color:white"/>
  <h:outputText value=" " styleClass="header2" />
  <h:outputText value=" " styleClass="header2" />
   <h:outputText value="#{MenuBean.msgExpira}" id="idMsgExpira"
                 rendered="#{MenuBean.mostarMsgExpira}" styleClass="td_mensaje header2" style="font-size:10.0px; font-weight:bold;color:white"/>
  
 
   <h:outputLink id="link1" value="http://www.profamilia.org.co/intranet/" styleClass="header2" target="_blank" style="font-size:10.0px; font-weight:bold;color:white;float:right">
   <h:outputText value="[ Intranet ]" />
   </h:outputLink>
   <h:outputText value=" " styleClass="header2" />
  <h:outputText value=" " styleClass="header2" />
  
   <h:outputLink id="link2" value="http://10.250.25.15/wrgea/" styleClass="header2" target="_blank" style="font-size:11.0px; font-weight:bold;color:white;float:right">
   <h:outputText value="[ Eventos Adversos ]" />
   </h:outputLink>
</h:panelGrid>