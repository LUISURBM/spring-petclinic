<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<%@ page contentType="text/html;charset=iso-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsf/core" prefix="f"%>
<%@ taglib uri="http://richfaces.org/a4j" prefix="a4j"%>
<%@ taglib uri="http://jakarta.apache.org/struts/tags-tiles" prefix="tiles"%>
<f:loadBundle basename="org.profamilia.hc.view.bundle.Messages" var="msg"/>
<html>
   <f:view>
      <head>
      <meta http-equiv="X-UA-Compatible" content="IE =EmulateIE6"/>
         <title>:: PROFAMILIA ** HISTORIAS CLINICAS ::</title>
                       <link rel="stylesheet" type="text/css" href="<%=request.getContextPath()%>/comun/css/estilos.css"/>
    <link rel="stylesheet" type="text/css" href="<%=request.getContextPath()%>/comun/css/estilos2.css"/>
    <link rel="stylesheet" type="text/css" href="<%=request.getContextPath()%>/comun/css/bootstrap.css"/>
    <link rel="stylesheet" type="text/css" href="<%=request.getContextPath()%>/comun/css/bootstrap.min.css"/>
    <link rel="stylesheet" type="text/css" href="<%=request.getContextPath()%>/comun/css/bootstrap-responsive.css"/>
    <link rel="stylesheet" type="text/css" href="<%=request.getContextPath()%>/comun/css/bootstrap-responsive.min.css"/>
    <script language="javascript" src="<%=request.getContextPath()%>/comun/js/common.js" type="text/javascript"></script>
    <script language="javascript" src="<%=request.getContextPath()%>/comun/js/effects.js" type="text/javascript"></script>
         
         <script language="javascript" type="text/javascript">
            document.forms['body:formMotivoConsulta'].elements[5].focus(); 
        </script>
        </head>
      <body><a4j:page id="completePage">
            <tiles:insert definition="layout" flush="false">
               <tiles:put name="body" value="/pages/clinico/registro/historiaSaludSexual/motivoConsultaSaludSexuaBody.jsp"/>
            </tiles:insert>
         </a4j:page></body>
   </f:view>
</html>