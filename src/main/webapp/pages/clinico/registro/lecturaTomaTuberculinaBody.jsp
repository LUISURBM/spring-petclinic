<%@ page contentType="text/html;charset=windows-1252"%>
<%@ taglib uri="http://java.sun.com/jsf/html" prefix="h"%>
<%@ taglib uri="http://java.sun.com/jsf/core" prefix="f"%>
<%@ taglib uri="http://richfaces.org/a4j" prefix="a4j"%>
<%@ taglib uri="http://myfaces.apache.org/tomahawk" prefix="t"%>
<%@ taglib uri="http://myfaces.apache.org/sandbox" prefix="s"%>
<%@ page import="org.profamilia.hc.view.servlet.PdfServlet"%>
<a4j:form id="consultarHistoriaForm">
  <a4j:region id="bodyRegionHistoria">
    <a4j:status id="statusButton" for="bodyRegionHistoria">
      <f:facet name="start">
        <t:div id="chargindConsultarFolio" styleClass="loading">
          <h:panelGrid columns="1" cellpadding="0" cellspacing="0" border="0">
            <h:outputText value="Procesando..."/>
            <h:outputText value="Por favor espere."/>
          </h:panelGrid>
        </t:div>
      </f:facet>
      <f:facet name="stop"/>
    </a4j:status>
    <h:panelGrid columns="1" id="tableConsultarFolio" border="0" cellpadding="0" cellspacing="0" width="100%" styleClass="td_ubicador">
      <h:outputText value="Lectura Prueba Tuberculina" id="infoUbication"/>
    </h:panelGrid>
    <h:panelGrid columns="1" border="0" cellpadding="0" cellspacing="0" width="100%" id="tableContentConsultarFolios" styleClass="tabContainer">
      <s:fieldset legend="Antecedentes Especificos" id="fieldSetInfoAnteceEspe" styleClass="fieldset">
        <h:panelGrid columns="2" border="0" cellpadding="0" cellspacing="0" width="100%" id="panelRegionInfoAnteceEspe" rowClasses="labelTextInfo">
          <h:panelGroup>
            <h:panelGrid columns="1" rowClasses="labelText,labelTextInfo">
              <h:outputText value="Presenta o ha presentado tuberculosis  "/>
              <h:outputText value="#{(consultarFoliosCitologiaBean.antecespec.haecprestuber == \'N\' ? \'No\' : \'Si\')}" />
            </h:panelGrid>
          </h:panelGroup>
          <h:panelGroup rendered="#{(consultarFoliosCitologiaBean.antecespec.haecprestuber == \'N\' ? false : true)}">
            <h:panelGrid columns="1" rowClasses="labelText,labelTextInfo">
              <h:outputText value="Cuando?  "/>
              <h:outputText value="#{consultarFoliosCitologiaBean.antecespec.haeccuantuber}" />
            </h:panelGrid>
          </h:panelGroup>
          <h:panelGroup >
            <h:panelGrid columns="1" rowClasses="labelText,labelTextInfo">
              <h:outputText value="Recibi� tratamiento?"/>
              <h:outputText value="#{(consultarFoliosCitologiaBean.antecespec.haecrecibtrata== \'N\' ? \'No\' : \'Si\')}" />
            </h:panelGrid>
          </h:panelGroup>
          <h:panelGroup rendered="#{(consultarFoliosCitologiaBean.antecespec.haecrecibtrata == \'N\' ? false : true)}">
            <h:panelGrid columns="1" rowClasses="labelText,labelTextInfo">
              <h:outputText value="�Por cu�nto tiempo ? "/>
              <h:outputText value="#{consultarFoliosCitologiaBean.antecespec.haectiemptrata}" />
            </h:panelGrid>
          </h:panelGroup>
          <h:panelGroup>
            <h:panelGrid columns="1" rowClasses="labelText,labelTextInfo">
              <h:outputText value="Ha estado en contacto con alguien que tenga o hay tenido tuberculosis?"/>
              <h:outputText value="#{(consultarFoliosCitologiaBean.antecespec.haeccontactubercu== \'N\' ? \'No\' : \'Si\')}" />
            </h:panelGrid>
          </h:panelGroup>
          <h:panelGroup rendered="#{(consultarFoliosCitologiaBean.antecespec.haeccontactubercu == \'N\' ? false : true)}">
            <h:panelGrid columns="1" rowClasses="labelText,labelTextInfo">
              <h:outputText value="�Qui�n?"/>
              <h:outputText value="#{consultarFoliosCitologiaBean.antecespec.haecquiencontac}" />
            </h:panelGrid>
          </h:panelGroup>
          <h:panelGroup>
            <h:panelGrid columns="1" rowClasses="labelText,labelTextInfo">
              <h:outputText value="Vive con el? "/>
              <h:outputText value="#{(consultarFoliosCitologiaBean.antecespec.haecviveconel== \'N\' ? \'No\' : \'Si\')}" />
            </h:panelGrid>
          </h:panelGroup>
          <h:panelGroup rendered="#{(consultarFoliosCitologiaBean.antecespec.haecviveconel == \'N\' ? false : true)}">
            <h:panelGrid columns="1" rowClasses="labelText,labelTextInfo">
              <h:outputText value="�Cuanto tiempo comparti� con el?:  "/>
              <h:outputText value="#{consultarFoliosCitologiaBean.antecespec.haectiempocompart}" />
            </h:panelGrid>
          </h:panelGroup>
        </h:panelGrid>
      </s:fieldset>
      <s:fieldset legend="Antecedentes Patol�gicos" id="fieldSetInfoAntecePatol" styleClass="fieldset">
        <h:panelGrid columns="2" border="0" cellpadding="0" cellspacing="0" width="100%" id="panelRegionInfoAntecePatol" rowClasses="labelTextInfo">
          <h:panelGroup>
            <h:panelGrid columns="1" rowClasses="labelText,labelTextInfo">
              <h:outputText value="VIH/SIDA"/>
              <h:outputText value="#{(consultarFoliosCitologiaBean.antepatol.hapcvih== \'N\' ? \'No\' : \'Si\')}" />
            </h:panelGrid>
          </h:panelGroup>
          <h:panelGroup>
            <h:panelGrid columns="1" rowClasses="labelText,labelTextInfo">
              <h:outputText value="Diabetes Mellitus "/>
              <h:outputText value="#{(consultarFoliosCitologiaBean.antepatol.hapcdiabmelli== \'N\' ? \'No\' : \'Si\')}" />
            </h:panelGrid>
          </h:panelGroup>
          <h:panelGroup>
            <h:panelGrid columns="1" rowClasses="labelText,labelTextInfo">
              <h:outputText value="Artritis  Reumatoide"/>
              <h:outputText value="#{(consultarFoliosCitologiaBean.antepatol.hapcartrireuma== \'N\' ? \'No\' : \'Si\')}" />
            </h:panelGrid>
          </h:panelGroup>
          <h:panelGroup>
            <h:panelGrid columns="1" rowClasses="labelText,labelTextInfo">
              <h:outputText value="Esclerosis m�ltiple "/>
              <h:outputText value="#{(consultarFoliosCitologiaBean.antepatol.hapcesclmult== \'N\' ? \'No\' : \'Si\')}" />
            </h:panelGrid>
          </h:panelGroup>
          <h:panelGroup>
            <h:panelGrid columns="1" rowClasses="labelText,labelTextInfo">
              <h:outputText value="C�ncer"/>
              <h:outputText value="#{(consultarFoliosCitologiaBean.antepatol.hapccancer== \'N\' ? \'No\' : \'Si\')}" />
            </h:panelGrid>
          </h:panelGroup>
          <h:panelGroup>
            <h:panelGrid columns="1" rowClasses="labelText,labelTextInfo">
              <h:outputText value="Esclerosis  lateral amiotr�fica "/>
              <h:outputText value="#{(consultarFoliosCitologiaBean.antepatol.hapcescllatamio== \'N\' ? \'No\' : \'Si\')}" />
            </h:panelGrid>
          </h:panelGroup>
          <h:panelGroup>
            <h:panelGrid columns="1" rowClasses="labelText,labelTextInfo">
              <h:outputText value="Nefropat�a "/>
              <h:outputText value="#{(consultarFoliosCitologiaBean.antepatol.hapcnefropa== \'N\' ? \'No\' : \'Si\')}" />
            </h:panelGrid>
          </h:panelGroup>
          <h:panelGroup>
            <h:panelGrid columns="1" rowClasses="labelText,labelTextInfo">
              <h:outputText value="Migra�a"/>
              <h:outputText value="#{(consultarFoliosCitologiaBean.antepatol.hapcmigrana== \'N\' ? \'No\' : \'Si\')}" />
            </h:panelGrid>
          </h:panelGroup>
          <h:panelGroup>
            <h:panelGrid columns="1" rowClasses="labelText,labelTextInfo">
              <h:outputText value="Fibromialgia "/>
              <h:outputText value="#{(consultarFoliosCitologiaBean.antepatol.hapcfibromi== \'N\' ? \'No\' : \'Si\')}" />
            </h:panelGrid>
          </h:panelGroup>
          <h:panelGroup>
            <h:panelGrid columns="1" rowClasses="labelText,labelTextInfo">
              <h:outputText value="Otra"/>
              <h:outputText value="#{(consultarFoliosCitologiaBean.antepatol.hapcotra == \'N\' ? \'No\' : \'Si\')}" />
            </h:panelGrid>
          </h:panelGroup>
          <h:panelGroup rendered="#{(consultarFoliosCitologiaBean.antepatol.hapcotra == \'N\' ? false : true)}">
            <h:panelGrid columns="1" rowClasses="labelText,labelTextInfo">
              <h:outputText value="Cual"/>
              <h:outputText value="#{consultarFoliosCitologiaBean.antepatol.hapccual}" />
            </h:panelGrid>
          </h:panelGroup>
        </h:panelGrid>
      </s:fieldset>
      <s:fieldset legend="Antecedentes Farmacol�gicos Actuales" id="fieldSetInfoAnteceFarma" styleClass="fieldset">
        <h:panelGrid columns="3" border="0" cellpadding="0" cellspacing="0" width="100%" id="panelRegionInfoAnteceFarma" rowClasses="labelTextInfo">
          <h:panelGroup>
            <h:panelGrid columns="1" rowClasses="labelText,labelTextInfo">
              <h:outputText value="AINES (Ibuprofeno, naproxeno, ASA, Diclofenaco, Indometacina, Piroxican, Etericoxib)"/>
              <h:outputText value="#{(consultarFoliosCitologiaBean.antefarma.hafcaines== \'N\' ? \'No\' : \'Si\')}" />
            </h:panelGrid>
          </h:panelGroup>
          <h:panelGroup rendered="#{(consultarFoliosCitologiaBean.antefarma.hafcaines == \'N\' ? false : true)}">
            <h:panelGrid columns="1" rowClasses="labelText,labelTextInfo">
              <h:outputText value="Cual?"/>
              <h:outputText value="#{consultarFoliosCitologiaBean.antefarma.hafcainecual}" />
            </h:panelGrid>
          </h:panelGroup>
          <h:panelGroup rendered="#{(consultarFoliosCitologiaBean.antefarma.hafcaines == \'N\' ? false : true)}">
            <h:panelGrid columns="1" rowClasses="labelText,labelTextInfo">
              <h:outputText value="Frecuencia"/>
              <h:outputText value="#{consultarFoliosCitologiaBean.antefarma.hafcainefrecu}" />
            </h:panelGrid>
          </h:panelGroup>
          <h:panelGroup>
            <h:panelGrid columns="1" rowClasses="labelText,labelTextInfo">
              <h:outputText value="Antiagregantes (ASA, Clopidrogel, Triflusal, Sulfinpirazona, Dipiramol, Proaciclina, Triclopidina)"/>
              <h:outputText value="#{(consultarFoliosCitologiaBean.antefarma.hafcantiagre== \'N\' ? \'No\' : \'Si\')}" />
            </h:panelGrid>
          </h:panelGroup>
          <h:panelGroup rendered="#{(consultarFoliosCitologiaBean.antefarma.hafcantiagre == \'N\' ? false : true)}">
            <h:panelGrid columns="1" rowClasses="labelText,labelTextInfo">
              <h:outputText value="Cu�l?"/>
              <h:outputText value="#{consultarFoliosCitologiaBean.antefarma.hafcaagrecual}" />
            </h:panelGrid>
          </h:panelGroup>
          <h:panelGroup rendered="#{(consultarFoliosCitologiaBean.antefarma.hafcantiagre == \'N\' ? false : true)}">
            <h:panelGrid columns="1" rowClasses="labelText,labelTextInfo">
              <h:outputText value="Frecuencia "/>
              <h:outputText value="#{consultarFoliosCitologiaBean.antefarma.hafcaagrefrecu}" />
            </h:panelGrid>
          </h:panelGroup>
          <h:panelGroup>
            <h:panelGrid columns="1" rowClasses="labelText,labelTextInfo">
              <h:outputText value="Anticoagulantes (Heparina, Enoxaparina, Nadroparina, Deltaparina, Fondaniparinux S�dico, Rivaroxaban, Dabigatran, Warfarina)"/>
              <h:outputText value="#{(consultarFoliosCitologiaBean.antefarma.hafcanticoag== \'N\' ? \'No\' : \'Si\')}" />
            </h:panelGrid>
          </h:panelGroup>
          <h:panelGroup rendered="#{(consultarFoliosCitologiaBean.antefarma.hafcanticoag == \'N\' ? false : true)}">
            <h:panelGrid columns="1" rowClasses="labelText,labelTextInfo">
              <h:outputText value="Cu�l"/>
              <h:outputText value="#{consultarFoliosCitologiaBean.antefarma.hafcacoagcual}" />
            </h:panelGrid>
          </h:panelGroup>
          <h:panelGroup rendered="#{(consultarFoliosCitologiaBean.antefarma.hafcanticoag == \'N\' ? false : true)}">
            <h:panelGrid columns="1" rowClasses="labelText,labelTextInfo">
              <h:outputText value="Frecuencia"/>
              <h:outputText value="#{consultarFoliosCitologiaBean.antefarma.hafcacoagfrec}" />
            </h:panelGrid>
          </h:panelGroup>
        </h:panelGrid>
        <h:panelGrid columns="2" border="0" cellpadding="0" cellspacing="0" width="100%" id="panelRegionInfoAnteceFarmac" rowClasses="labelTextInfo">
          <h:panelGroup>
            <h:panelGrid columns="1" rowClasses="labelText,labelTextInfo">
              <h:outputText value="Se ha aplicado alg�n medicamento en los �ltimos tres d�as ?"/>
              <h:outputText value="#{(consultarFoliosCitologiaBean.antefarma.hafcaplimedic== \'N\' ? \'No\' : \'Si\')}" />
            </h:panelGrid>
          </h:panelGroup>
          <h:panelGroup rendered="#{(consultarFoliosCitologiaBean.antefarma.hafcaplimedic == \'N\' ? false : true)}">
            <h:panelGrid columns="1" rowClasses="labelText,labelTextInfo">
              <h:outputText value="Cual"/>
              <h:outputText value="#{consultarFoliosCitologiaBean.antefarma.hafcaplmedcual}" />
            </h:panelGrid>
          </h:panelGroup>
        </h:panelGrid>
        <h:panelGrid columns="3" border="0" cellpadding="0" cellspacing="0" width="100%" id="panelRegionInfoAnteceFarmaco" rowClasses="labelText">
          <h:panelGroup>
            <h:panelGrid columns="1" rowClasses="labelText,labelTextInfo">
              <h:outputText value="Se ha aplicado alguna vacuna ?"/>
              <h:outputText value="#{(consultarFoliosCitologiaBean.antefarma.hafcaplivacu== \'N\' ? \'No\' : \'Si\')}" />
            </h:panelGrid>
          </h:panelGroup>
          <h:panelGroup rendered="#{(consultarFoliosCitologiaBean.antefarma.hafcaplivacu == \'N\' ? false : true)}">
            <h:panelGrid columns="1" rowClasses="labelText,labelTextInfo">
              <h:outputText value="Cual"/>
              <h:outputText value="#{consultarFoliosCitologiaBean.antefarma.hafcapvacucual}" />
            </h:panelGrid>
          </h:panelGroup>
          <h:panelGroup rendered="#{(consultarFoliosCitologiaBean.antefarma.hafcaplivacu == \'N\' ? false : true)}">
            <h:panelGrid columns="1" rowClasses="labelText,labelTextInfo">
              <h:outputText value="�Hace cu�ntos d�as?"/>
              <h:outputText value="#{consultarFoliosCitologiaBean.antefarma.haflapvacudias}" />
            </h:panelGrid>
          </h:panelGroup>
        </h:panelGrid>
       </s:fieldset>
       
      <s:fieldset legend="Resultado" id="fieldSetInfoConsultarUsuario" styleClass="fieldset">
        <h:panelGrid columns="2" border="0" cellpadding="0" cellspacing="0" width="100%" id="panelRegionInfoConsulta" rowClasses="labelText,labelTextInfo">
          <h:panelGroup>
            <h:outputText value="Resultado "/>
            <h:inputTextarea value="#{consultarFoliosCitologiaBean.chlecttuber.hltcresultado}"/>
          </h:panelGroup>
          <h:panelGroup>
            <h:outputText value="Observaciones "/>
            <h:inputTextarea value="#{consultarFoliosCitologiaBean.chlecttuber.hltcobservac}"/>
          </h:panelGroup>
        </h:panelGrid>
        <h:commandButton value="Guardar" action="#{consultarFoliosCitologiaBean.guardarLectura}" styleClass="boton_fieldset" id="idButtonUsuario"/>
      </s:fieldset>
    </h:panelGrid>
    <h:panelGrid>
      <h:panelGroup>
        <a4j:outputPanel id="ajaxRegionMsgFolioCito" ajaxRendered="true">
          <t:htmlTag value="br"/>
          <t:messages id="msgInformationMsgFolioCito" showSummary="true" errorClass="error" globalOnly="true" layout="table" infoClass="informacion"/>
        </a4j:outputPanel>
      </h:panelGroup>
      <f:subview id="generarTuberculina" rendered="#{consultarFoliosCitologiaBean.generoTuberculina}">
        <f:verbatim>
          <script type="text/javascript" language="JavaScript">
           window.open("<%=request.getSession().getAttribute(PdfServlet.DOCUMENT_NAME_ATTRIBUTE_NAME)%>", "Documento" , "width=800,height=600");
        </script>
        </f:verbatim>
      </f:subview>
    </h:panelGrid>
  </a4j:region>
</a4j:form>