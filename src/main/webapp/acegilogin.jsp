<%@ page contentType="text/html;charset=iso-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsf/core" prefix="f"%>
<%@ taglib uri="http://java.sun.com/jsf/html" prefix="h"%>
<%@ taglib uri="http://myfaces.apache.org/tomahawk" prefix="t"%>
<%@ page import="org.profamilia.hc.view.util.FacesUtils"%>
<%@ page import="org.profamilia.hc.view.backing.LoginBacking"%>
<f:loadBundle basename="org.profamilia.hc.view.bundle.Messages" var="msg"/>

<html>
  <head>
    <title>:: PROFAMILIA ** HISTORIAS CLINICAS::</title>
    <link rel="stylesheet" type="text/css" href="<%=request.getContextPath()%>/comun/css/estilos2.css"/>
    <link rel="stylesheet" type="text/css" href="<%=request.getContextPath()%>/comun/css/bootstrap.css"/>
    <link rel="stylesheet" type="text/css" href="<%=request.getContextPath()%>/comun/css/bootstrap.min.css"/>
    <link rel="stylesheet" type="text/css" href="<%=request.getContextPath()%>/comun/css/bootstrap-responsive.css"/>
    <link rel="stylesheet" type="text/css" href="<%=request.getContextPath()%>/comun/css/bootstrap-responsive.min.css"/>
    <script language="javascript" type="text/javascript">
                                      var ip = '<%=request.getRemoteAddr()%>';
                                      alert(ip);
                                 </script>
    <script language="javascript" type="text/javascript">
          <% if(false){  %>
              simwindow = window.open("pages/clinico/consulta/informacionUsuario.jsf","Profamilia","toolbar=no,location=no,status=no,menubar=no,resizable=yes,scrollbars=yes,width="+screen.width+",height="+screen.height);
              simwindow.moveTo(0,0); 
              //  simwindow = window.location = 'pages/clinico/consulta/informacionUsuario.jsf';
 <% } %>
          </script>
          <script language="javascript">
function checkKeyCode(evt)
{

var evt = (evt) ? evt : ((event) ? event : null);
var node = (evt.target) ? evt.target : ((evt.srcElement) ? evt.srcElement : null);
if(event.keyCode==116)
{
evt.keyCode=0;
alert('El F5 no esta habilitado')
return false
}
}
document.onkeydown=checkKeyCode;
</script>
         
    <meta name="viewport" content="width=device-width, initial-scale=1"></meta>
  </head>
  <f:view>
    <f:loadBundle basename="org.profamilia.hc.view.bundle.Messages" var="msg"/>
    <body><script language="javascript" type="text/javascript">
                                      var ip = '<%=request.getRemoteAddr()%>';
                                      alert(ip);
                                 </script><table cellspacing="0" cellpadding="0" border="0" align="center"
                                                 id="tableLayout" class="container">
        <t:htmlTag value="td" styleClass="form-signin">
          <table cellspacing="0" cellpadding="0" align="center">
            <h:form id="loginForm" styleClass="login-fields">
              <t:inputHidden forceId="true" id="itDireccionIP" value="#{loginBacking.direccionIP}"/>
              <t:htmlTag value="tbody">
                <t:htmlTag value="tr">
                </t:htmlTag>
                <t:htmlTag value="tr">
                  <t:htmlTag value="td">
                    <p class="p">Ingrese usuario y contrase&ntilde;a:</p>
                  </t:htmlTag>
                </t:htmlTag>
                <t:htmlTag value="tr">
                  <t:htmlTag value="td" styleClass="field">
                    <div class="input-prepend">
                      <t:inputText align="center" forceId="true" id="j_username"
                                   styleClass="login username-field input-xlarge" tabindex="1" required="true"/>
                    </div>
                    <t:message for="j_username" styleClass="alert alert-error"/>
                  </t:htmlTag>
                </t:htmlTag>
                <t:htmlTag value="tr">
                  <t:htmlTag value="td" styleClass="field">
                    <div class="input-prepend">
                      <t:inputSecret align="center" forceId="true" id="j_password"
                                     styleClass="login password-field input-xlarge" tabindex="2" required="true"/>
                    </div>
                    <t:message for="j_password" styleClass="alert alert-error"/>
                  </t:htmlTag>
                </t:htmlTag>
                <t:htmlTag value="tr">
                  <t:htmlTag value="td">&nbsp;</t:htmlTag>
                </t:htmlTag>
                <t:htmlTag value="tr">
                  <t:htmlTag value="td" style="text-align:center;">
                    <t:commandButton id="commandButton1" action="login" value="Ingresar"
                                     styleClass="btn btn btn-success" immediate="true"/>
                  </t:htmlTag>
                  <f:verbatim>
                    <br></br>
                    <br></br>
                    <br></br>
                    <a href="general/cerrarVentana.jsf" style="font-size:10.0px; font-weight:bold;">[ Cerrar ]</a>
                  </f:verbatim>
                </t:htmlTag>
              </t:htmlTag>
            </h:form>
          </table>
        </t:htmlTag>
        <t:htmlTag value="tr">
          <t:htmlTag value="td" styleClass="footer-login">
            <h:outputText value="Copyright � 2020 / Historias Clinicas V.2 | Marzo 1 | Profamilia | / Todos los derechos reservados"/>
          </t:htmlTag>
        </t:htmlTag>
      </table><f:verbatim>
        <script language="javascript" type="text/javascript">
      
      <%      
      String user =(String)FacesUtils.getRequestParameter("user");
      String password = (String)FacesUtils.getRequestParameter("password");      
      if (user != null && password != null){
      %>
      
      document.getElementById('j_username').value="<%= (String)FacesUtils.getRequestParameter("user") %>";
      document.getElementById('j_password').value="<%= (String)FacesUtils.getRequestParameter("password") %>";
     
     <%
     }
     %>
       document.getElementById('itDireccionIP').value= ip;

      </script>
      </f:verbatim></body>
  </f:view>
</html>