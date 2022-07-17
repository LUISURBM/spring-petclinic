<%@ page contentType="text/html;charset=iso-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsf/html" prefix="h"%>
<%@ taglib uri="http://java.sun.com/jsf/core" prefix="f"%>
<%@ taglib uri="http://richfaces.org/a4j" prefix="a4j"%>
<%@ taglib uri="http://myfaces.apache.org/tomahawk" prefix="t"%>
<%@ taglib uri="http://myfaces.apache.org/sandbox" prefix="s"%>
<%@ page import="org.profamilia.hc.view.servlet.XlsServlet"%>
<h:panelGrid columns="1" border="0" cellpadding="0" cellspacing="0" width="100%" id="panelGridIngresoCirugiaTab" styleClass="tabContainer">
  <jsp:include page="/pages/clinico/comunes/encabezadoDatosCirugia.jsp" flush="true"/>
  <h:panelGrid columns="1" border="0" cellpadding="0" cellspacing="0" width="100%" id="panelGridIngresoEnfermeriaTab" styleClass="tabContainer">
    <s:fieldset legend="Accesos Directos" id="accesosDirectos" styleClass="fieldset">
      <h:panelGrid columns="5" border="0" cellpadding="0" cellspacing="0" width="100%" id="panelAccesosDirectos" rowClasses="labelText,labelTextInfo">
        <h:panelGrid columns="1" id="notasEnfermeria">
          <h:outputText value="Notas Enfermeria"/>
          <h:commandLink id="visualizarNotasEnfermeria" action="#{menuEnfermeriaBean.registrarNotasEnfermeria}" immediate="true">
            <t:graphicImage alt="" border="0" align="center" url="/comun/imagenes/Prescription.png"/>
          </h:commandLink>
        </h:panelGrid>
        <h:panelGrid columns="1" id="liquidos">
          <f:facet name="header">
            <h:outputText value="Liquidos"/>
          </f:facet>
          <h:commandLink id="visualizarLiquidos" action="#{menuEnfermeriaBean.registrarLiquidos}" immediate="true">
            <t:graphicImage alt="" border="0" align="center" url="/comun/imagenes/Syringe.png"/>
          </h:commandLink>
        </h:panelGrid>
        <h:panelGrid columns="1" id="medicamentos">
          <f:facet name="header">
            <h:outputText value="Medicamentos"/>
          </f:facet>
          <h:commandLink id="visualizarMedicamentos" action="#{menuEnfermeriaBean.registrarMedicamentos}" immediate="true">
            <t:graphicImage alt="" border="0" align="center" url="/comun/imagenes/Vial-Pills.png"/>
          </h:commandLink>
        </h:panelGrid>
        <h:panelGrid columns="1" id="signosvitales">
          <f:facet name="header">
            <h:outputText value="Signos Vitales"/>
          </f:facet>
          <h:commandLink id="visualizarSignosVitales" action="#{menuEnfermeriaBean.registrarSignosVitales}" immediate="true">
            <t:graphicImage alt="" border="0" align="center" url="/comun/imagenes/RerunQualityControl.png"/>
          </h:commandLink>
        </h:panelGrid>
        <h:panelGrid columns="1" id="otrasOrdenes">
          <f:facet name="header">
            <h:outputText value="Otras Ordenes"/>
          </f:facet>
          <h:commandLink id="visualizarOtrasOrdenes" action="#{menuEnfermeriaBean.otrasOrdenes}" immediate="true">
            <t:graphicImage alt="" border="0" align="center" url="/comun/imagenes/Edit.png"/>
          </h:commandLink>
        </h:panelGrid>
        <h:panelGrid columns="1" id="aldrete" rendered="#{menuEnfermeriaBean.renderAldrete}">
          <f:facet name="header">
            <h:outputText value="Aldrete" rendered="#{menuEnfermeriaBean.renderAldrete}"/>
          </f:facet>
          <h:commandLink id="visualizarAldrete" action="#{menuEnfermeriaBean.registrarAldrete}" rendered="#{menuEnfermeriaBean.renderAldrete}" immediate="true">
            <t:graphicImage alt="" border="0" align="center" url="/comun/imagenes/BandAid.png"/>
          </h:commandLink>
        </h:panelGrid>
        <h:panelGrid columns="1" id="bromage" rendered="#{menuEnfermeriaBean.renderBromage}">
          <f:facet name="header">
            <h:outputText value="Bromage" rendered="#{menuEnfermeriaBean.renderBromage}"/>
          </f:facet>
          <h:commandLink id="visualizarBromage" action="#{menuEnfermeriaBean.registrarBromage}" rendered="#{menuEnfermeriaBean.renderBromage}" immediate="true">
            <t:graphicImage alt="" border="0" align="center" url="/comun/imagenes/BandAid.png"/>
          </h:commandLink>
        </h:panelGrid>
      </h:panelGrid>
    </s:fieldset>
    <jsp:include page="/pages/clinico/cirugia/registro/enfermera/comun/adicionarSignosVitales.jsp" flush="true"/>
  </h:panelGrid>
  <f:subview id="generarContLiq" rendered="#{registrarNotaEnfermeriaBean.generoReporte}">
    <f:subview id="generarReporteContLiq" rendered="#{registrarNotaEnfermeriaBean.generoReporte}">
      <f:verbatim>
        <script type="text/javascript" language="JavaScript">
                    window.open("<%=request.getSession().getAttribute(XlsServlet.DOCUMENT_NAME_ATTRIBUTE_NAME)%>", "Documento" , "width=1200,height=900");
                </script>
      </f:verbatim>
    </f:subview>
  </f:subview>
</h:panelGrid>