<%@ page contentType="text/html;charset=iso-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsf/html" prefix="h"%>
<%@ taglib uri="http://java.sun.com/jsf/core" prefix="f"%>
<%@ taglib uri="http://richfaces.org/a4j" prefix="a4j"%>
<%@ taglib uri="http://myfaces.apache.org/tomahawk" prefix="t"%>
<%@ taglib uri="http://myfaces.apache.org/sandbox" prefix="s"%>
<%@ taglib uri="http://myfaces.apache.org/tomahawk" prefix="t"%>
<h:panelGrid columns="1" border="0" cellpadding="0" cellspacing="0" width="100%" id="panelGridCierreTuberculinaTab" styleClass="tabContainer">
  <jsp:include page="/pages/clinico/comunes/encabezadoDatosUsuario.jsp" flush="true"/>
  <t:panelTabbedPane border="0" cellpadding="0" cellspacing="0" serverSideTabSwitch="false" activePanelTabVar="true" width="100%" id="panelTabbedPaneCierreTuberculina"
                     styleClass="tabbedPane" activeTabStyleClass="activeTab" inactiveTabStyleClass="inactiveTab" disabledTabStyleClass="disabledTab" activeSubStyleClass="activeSub"
                     inactiveSubStyleClass="inactiveSub" tabContentStyleClass="tabContent">
    <t:panelTab id="panelTabCierreTuberculina" label="Pre-visualizar Tuberculina">
      <h:panelGrid columns="1" border="0" cellpadding="0" cellspacing="0" width="100%" id="tableContentTabsCierreTuberculina" styleClass="tabContainer">
       <s:fieldset legend="Antecedentes Especificos" id="fieldSetInfoAnteceEspe" styleClass="fieldset">
        <h:panelGrid columns="2" border="0" cellpadding="0" cellspacing="0" width="100%" id="panelRegionInfoAnteceEspe" rowClasses="labelTextInfo">
          <h:panelGroup>
            <h:panelGrid columns="1" rowClasses="labelText,labelTextInfo">
              <h:outputText value="Presenta o ha presentado tuberculosis  "/>
              <h:outputText value="#{(cierreTuberculinaBean.antecedespec.haecprestuber == \'N\' ? \'No\' : \'Si\')}" />
            </h:panelGrid>
          </h:panelGroup>
          <h:panelGroup rendered="#{(cierreTuberculinaBean.antecedespec.haecprestuber == \'N\' ? false : true)}">
            <h:panelGrid columns="1" rowClasses="labelText,labelTextInfo">
              <h:outputText value="Cuando?  "/>
              <h:outputText value="#{cierreTuberculinaBean.antecedespec.haeccuantuber}" />
            </h:panelGrid>
          </h:panelGroup>
          <h:panelGroup >
            <h:panelGrid columns="1" rowClasses="labelText,labelTextInfo">
              <h:outputText value="Recibió tratamiento?"/>
              <h:outputText value="#{(cierreTuberculinaBean.antecedespec.haecrecibtrata== \'N\' ? \'No\' : \'Si\')}" />
            </h:panelGrid>
          </h:panelGroup>
          <h:panelGroup rendered="#{(cierreTuberculinaBean.antecedespec.haecrecibtrata == \'N\' ? false : true)}">
            <h:panelGrid columns="1" rowClasses="labelText,labelTextInfo">
              <h:outputText value="¿Por cuánto tiempo ? "/>
              <h:outputText value="#{cierreTuberculinaBean.antecedespec.haectiemptrata}" />
            </h:panelGrid>
          </h:panelGroup>
          <h:panelGroup>
            <h:panelGrid columns="1" rowClasses="labelText,labelTextInfo">
              <h:outputText value="Ha estado en contacto con alguien que tenga o hay tenido tuberculosis?"/>
              <h:outputText value="#{(cierreTuberculinaBean.antecedespec.haeccontactubercu== \'N\' ? \'No\' : \'Si\')}" />
            </h:panelGrid>
          </h:panelGroup>
          <h:panelGroup rendered="#{(cierreTuberculinaBean.antecedespec.haeccontactubercu == \'N\' ? false : true)}">
            <h:panelGrid columns="1" rowClasses="labelText,labelTextInfo">
              <h:outputText value="¿Quién?"/>
              <h:outputText value="#{cierreTuberculinaBean.antecedespec.haecquiencontac}" />
            </h:panelGrid>
          </h:panelGroup>
          <h:panelGroup>
            <h:panelGrid columns="1" rowClasses="labelText,labelTextInfo">
              <h:outputText value="Vive con el? "/>
              <h:outputText value="#{(cierreTuberculinaBean.antecedespec.haecviveconel== \'N\' ? \'No\' : \'Si\')}" />
            </h:panelGrid>
          </h:panelGroup>
          <h:panelGroup rendered="#{(cierreTuberculinaBean.antecedespec.haecviveconel == \'N\' ? false : true)}">
            <h:panelGrid columns="1" rowClasses="labelText,labelTextInfo">
              <h:outputText value="¿Cuanto tiempo compartió con el?:  "/>
              <h:outputText value="#{cierreTuberculinaBean.antecedespec.haectiempocompart}" />
            </h:panelGrid>
          </h:panelGroup>
        </h:panelGrid>
      </s:fieldset>
      <s:fieldset legend="Antecedentes Patológicos" id="fieldSetInfoAntecePatol" styleClass="fieldset">
        <h:panelGrid columns="2" border="0" cellpadding="0" cellspacing="0" width="100%" id="panelRegionInfoAntecePatol" rowClasses="labelTextInfo">
          <h:panelGroup>
            <h:panelGrid columns="1" rowClasses="labelText,labelTextInfo">
              <h:outputText value="VIH/SIDA"/>
              <h:outputText value="#{(cierreTuberculinaBean.antecedpatol.hapcvih== \'N\' ? \'No\' : \'Si\')}" />
            </h:panelGrid>
          </h:panelGroup>
          <h:panelGroup>
            <h:panelGrid columns="1" rowClasses="labelText,labelTextInfo">
              <h:outputText value="Diabetes Mellitus "/>
              <h:outputText value="#{(cierreTuberculinaBean.antecedpatol.hapcdiabmelli== \'N\' ? \'No\' : \'Si\')}" />
            </h:panelGrid>
          </h:panelGroup>
          <h:panelGroup>
            <h:panelGrid columns="1" rowClasses="labelText,labelTextInfo">
              <h:outputText value="Artritis  Reumatoide"/>
              <h:outputText value="#{(cierreTuberculinaBean.antecedpatol.hapcartrireuma== \'N\' ? \'No\' : \'Si\')}" />
            </h:panelGrid>
          </h:panelGroup>
          <h:panelGroup>
            <h:panelGrid columns="1" rowClasses="labelText,labelTextInfo">
              <h:outputText value="Esclerosis múltiple "/>
              <h:outputText value="#{(cierreTuberculinaBean.antecedpatol.hapcesclmult== \'N\' ? \'No\' : \'Si\')}" />
            </h:panelGrid>
          </h:panelGroup>
          <h:panelGroup>
            <h:panelGrid columns="1" rowClasses="labelText,labelTextInfo">
              <h:outputText value="Cáncer"/>
              <h:outputText value="#{(cierreTuberculinaBean.antecedpatol.hapccancer== \'N\' ? \'No\' : \'Si\')}" />
            </h:panelGrid>
          </h:panelGroup>
          <h:panelGroup>
            <h:panelGrid columns="1" rowClasses="labelText,labelTextInfo">
              <h:outputText value="Esclerosis  lateral amiotrófica "/>
              <h:outputText value="#{(cierreTuberculinaBean.antecedpatol.hapcescllatamio== \'N\' ? \'No\' : \'Si\')}" />
            </h:panelGrid>
          </h:panelGroup>
          <h:panelGroup>
            <h:panelGrid columns="1" rowClasses="labelText,labelTextInfo">
              <h:outputText value="Nefropatía "/>
              <h:outputText value="#{(cierreTuberculinaBean.antecedpatol.hapcnefropa== \'N\' ? \'No\' : \'Si\')}" />
            </h:panelGrid>
          </h:panelGroup>
          <h:panelGroup>
            <h:panelGrid columns="1" rowClasses="labelText,labelTextInfo">
              <h:outputText value="Migraña"/>
                <h:outputText value="#{(cierreTuberculinaBean.antecedpatol.hapcmigrana== \'N\' ? \'No\' : \'Si\')}"/>
              </h:panelGrid>
          </h:panelGroup>
          <h:panelGroup>
            <h:panelGrid columns="1" rowClasses="labelText,labelTextInfo">
              <h:outputText value="Fibromialgia "/>
              <h:outputText value="#{(cierreTuberculinaBean.antecedpatol.hapcfibromi== \'N\' ? \'No\' : \'Si\')}" />
            </h:panelGrid>
          </h:panelGroup>
          <h:panelGroup>
            <h:panelGrid columns="1" rowClasses="labelText,labelTextInfo">
              <h:outputText value="Otra"/>
              <h:outputText value="#{(cierreTuberculinaBean.antecedpatol.hapcotra == \'N\' ? \'No\' : \'Si\')}" />
            </h:panelGrid>
          </h:panelGroup>
          <h:panelGroup rendered="#{(cierreTuberculinaBean.antecedpatol.hapcotra == \'N\' ? false : true)}">
            <h:panelGrid columns="1" rowClasses="labelText,labelTextInfo">
              <h:outputText value="Cual"/>
              <h:outputText value="#{cierreTuberculinaBean.antecedpatol.hapccual}" />
            </h:panelGrid>
          </h:panelGroup>
         </h:panelGrid>
     </s:fieldset>
      <s:fieldset legend="Antecedentes Farmacológicos" id="fieldSetInfoAnteceFarma" styleClass="fieldset">
       <h:panelGrid columns="4" border="0" cellpadding="0" cellspacing="0" width="100%" id="panelRegionInfoAnteceFarma" rowClasses="labelTextInfo">
             <h:panelGroup>
            <h:panelGrid columns="1" rowClasses="labelText,labelTextInfo">
              <h:outputText value="AINES (Ibuprofeno, naproxeno, ASA, Diclofenaco, Indometacina, Piroxican, Etericoxib)"/>
              <h:outputText value="#{(cierreTuberculinaBean.antecedfarmacologicos.hafcaines == \'N\' ? \'No\' : \'Si\')}" />
            </h:panelGrid>
          </h:panelGroup>
          <h:panelGroup rendered="#{(cierreTuberculinaBean.antecedfarmacologicos.hafcaines == \'N\' ? false : true)}">
            <h:panelGrid columns="1" rowClasses="labelText,labelTextInfo">
              <h:outputText value="Cual?"/>
              <h:outputText value="#{cierreTuberculinaBean.antecedfarmacologicos.hafcainecual}" />
            </h:panelGrid>
          </h:panelGroup>
          <h:panelGroup rendered="#{(cierreTuberculinaBean.antecedfarmacologicos.hafcaines == \'N\' ? false : true)}">
            <h:panelGrid columns="1" rowClasses="labelText,labelTextInfo">
              <h:outputText value="Frecuencia"/>
              <h:outputText value="#{cierreTuberculinaBean.antecedfarmacologicos.hafcainefrecu}" />
            </h:panelGrid>
          </h:panelGroup>
          <h:panelGroup>
          </h:panelGroup>
         
       
 
 <h:panelGroup>
            <h:panelGrid columns="1" rowClasses="labelText,labelTextInfo">
              <h:outputText value="Antiagregantes (ASA, Clopidrogel, Triflusal, Sulfinpirazona, Dipiramol, Proaciclina, Triclopidina)"/>
              <h:outputText value="#{(cierreTuberculinaBean.antecedfarmacologicos.hafcantiagre== \'N\' ? \'No\' : \'Si\')} " />
            </h:panelGrid>
          </h:panelGroup>
          <h:panelGroup rendered="#{(cierreTuberculinaBean.antecedfarmacologicos.hafcantiagre == \'N\' ? false : true)}">
            <h:panelGrid columns="1" rowClasses="labelText,labelTextInfo">
              <h:outputText value="Cuál?"/>
              <h:outputText value="#{cierreTuberculinaBean.antecedfarmacologicos.hafcaagrecual}" />
            </h:panelGrid>
          </h:panelGroup>
          <h:panelGroup rendered="#{(cierreTuberculinaBean.antecedfarmacologicos.hafcantiagre == \'N\' ? false : true)}">
            <h:panelGrid columns="1" rowClasses="labelText,labelTextInfo">
              <h:outputText value="Frecuencia "/>
              <h:outputText value="#{cierreTuberculinaBean.antecedfarmacologicos.hafcaagrefrecu}" />
            </h:panelGrid>
          </h:panelGroup>
          <h:panelGroup>
          </h:panelGroup>
        
         
          <h:panelGroup>
            <h:panelGrid columns="1" rowClasses="labelText,labelTextInfo">
              <h:outputText value="Anticoagulantes (Heparina, Enoxaparina, Nadroparina, Deltaparina, Fondaniparinux Sódico, Rivaroxaban, Dabigatran, Warfarina)"/>
              <h:outputText value="#{(cierreTuberculinaBean.antecedfarmacologicos.hafcanticoag== \'N\' ? \'No\' : \'Si\')}" />
            </h:panelGrid>
          </h:panelGroup>
          <h:panelGroup rendered="#{(cierreTuberculinaBean.antecedfarmacologicos.hafcanticoag == \'N\' ? false : true)}">
            <h:panelGrid columns="1" rowClasses="labelText,labelTextInfo">
              <h:outputText value="Cuál"/>
              <h:outputText value="#{cierreTuberculinaBean.antecedfarmacologicos.hafcacoagcual}" />
            </h:panelGrid>
          </h:panelGroup>
          <h:panelGroup rendered="#{(cierreTuberculinaBean.antecedfarmacologicos.hafcanticoag == \'N\' ? false : true)}">
            <h:panelGrid columns="1" rowClasses="labelText,labelTextInfo">
              <h:outputText value="Frecuencia"/>
              <h:outputText value="#{cierreTuberculinaBean.antecedfarmacologicos.hafcacoagfrec}" />
            </h:panelGrid>
          </h:panelGroup>
          <h:panelGroup>
            <h:panelGrid columns="1" rowClasses="labelText,labelTextInfo">
              <h:outputText value="Se ha aplicado algún medicamento en los últimos tres días ?"/>
              <h:outputText value="#{(cierreTuberculinaBean.antecedfarmacologicos.hafcaplimedic== \'N\' ? \'No\' : \'Si\')}" />
            </h:panelGrid>
          </h:panelGroup>
          <h:panelGroup rendered="#{(cierreTuberculinaBean.antecedfarmacologicos.hafcaplimedic == \'N\' ? false : true)}">
            <h:panelGrid columns="1" rowClasses="labelText,labelTextInfo">
              <h:outputText value="Cual"/>
              <h:outputText value="#{cierreTuberculinaBean.antecedfarmacologicos.hafcaplmedcual}" />
            </h:panelGrid>
          </h:panelGroup>
          <h:panelGroup>
            <h:panelGrid columns="1" rowClasses="labelText,labelTextInfo">
              <h:outputText value="Se ha aplicado alguna vacuna ?"/>
              <h:outputText value="#{(cierreTuberculinaBean.antecedfarmacologicos.hafcaplivacu== \'N\' ? \'No\' : \'Si\')}" />
            </h:panelGrid>
          </h:panelGroup>
          <h:panelGroup rendered="#{(cierreTuberculinaBean.antecedfarmacologicos.hafcaplivacu == \'N\' ? false : true)}">
            <h:panelGrid columns="1" rowClasses="labelText,labelTextInfo">
              <h:outputText value="Cual"/>
              <h:outputText value="#{cierreTuberculinaBean.antecedfarmacologicos.hafcapvacucual}" />
            </h:panelGrid>
          </h:panelGroup>
          <h:panelGroup rendered="#{(cierreTuberculinaBean.antecedfarmacologicos.hafcaplivacu == \'N\' ? false : true)}">
            <h:panelGrid columns="1" rowClasses="labelText,labelTextInfo">
              <h:outputText value="¿Hace cuántos días?"/>
              <h:outputText value="#{cierreTuberculinaBean.antecedfarmacologicos.haflapvacudias}" />
            </h:panelGrid>
          </h:panelGroup>
		  
		   </h:panelGrid>
      </s:fieldset>
      </h:panelGrid>
    </t:panelTab>
    <h:panelGrid columns="1" border="0" cellpadding="0" cellspacing="0" width="100%" id="panelBotonGuardarCierreTuberculina" columnClasses="panelGridBotones">
      <h:panelGroup>
        <h:commandButton value="Guardar" styleClass="boton_fieldset" action="#{cierreTuberculinaBean.aceptar}">
          <a4j:support event="onclick" status="statusButton" reRender="panelTabCierreTuberculina"/>
        </h:commandButton>
      </h:panelGroup>
    </h:panelGrid>
  </t:panelTabbedPane>
  <script language="javascript" type="text/javascript">
        document.forms[1].elements[6].focus()
</script>
</h:panelGrid>