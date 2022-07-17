<%@ page contentType="text/html;charset=iso-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsf/html" prefix="h"%>
<%@ taglib uri="http://java.sun.com/jsf/core" prefix="f"%>
<%@ taglib uri="http://richfaces.org/a4j" prefix="a4j"%>
<%@ taglib uri="http://myfaces.apache.org/tomahawk" prefix="t"%>
<f:loadBundle basename="org.profamilia.hc.view.bundle.Messages" var="msg"/>
<a4j:form>
    <h:panelGrid columns="1" cellpadding="0" border="0" cellspacing="0" id="tableHeaderMenuHistorias" width="100%"
                 columnClasses="td_menu,td_menu">
        <t:jscookMenu layout="vbr" theme="ThemeTwo" styleLocation="/comun/css/jscookmenu" id="jsCookMenuBasicHistorias2"
                      javascriptLocation="/comun/js/jscookmenu" immediate="true"
                      rendered="#{!empty MenuCirugiaBean.menuAdmin}">
            <t:navigationMenuItems value="#{MenuCirugiaBean.menuAdmin}"/>
        </t:jscookMenu>
        
    </h:panelGrid>
</a4j:form>