<%@ page contentType="text/html;charset=iso-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsf/html" prefix="h"%>
<%@ taglib uri="http://java.sun.com/jsf/core" prefix="f"%>
<%@ taglib uri="http://richfaces.org/a4j" prefix="a4j"%>
<%@ taglib uri="http://myfaces.apache.org/tomahawk" prefix="t"%>
<%@ taglib uri="http://myfaces.apache.org/sandbox" prefix="s"%>
<h:panelGrid columns="1" border="0" cellpadding="0" cellspacing="0" width="100%" id="panelGridSignosVitalesTab"
             styleClass="tabContainer">
  <jsp:include page="/pages/clinico/comunes/encabezadoDatosUsuario.jsp" flush="true"/>
 <jsp:include page="/pages/clinico/cirugia/registro/enfermera/comun/adicionarSignosVitales.jsp" flush="true"/>
 
 
   <t:commandLink id="commandSignosVitales" action="irListaNotasEnfermeria" immediate="true">
        <t:graphicImage alt="" border="0" url="/comun/imagenes/volver.gif"/>
      </t:commandLink>
</h:panelGrid>