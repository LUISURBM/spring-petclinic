<%@ taglib uri="http://java.sun.com/jsf/core" prefix="f"%>
<%@ taglib uri="http://jakarta.apache.org/struts/tags-tiles" prefix="tiles"%>
<%@ taglib uri="http://java.sun.com/jsf/html" prefix="h"%>

<table cellspacing="0" cellpadding="0" border="0" width="100%" id="tableLayout">
  <tr>
    <td style="vertical-align:top;">
      <h:graphicImage url="/comun/imagenes/logo-50-años.png"/>
    </td>
  </tr>
  <tr>
    <td style="vertical-align:top;">
      <f:subview id="body">
        <tiles:insert attribute="body" flush="false"/>
      </f:subview>
    </td>
  </tr>
  <tr>
    <td style="vertical-align:top;" class="td_footer_login">
      <f:subview id="footer">
        <tiles:insert attribute="footer" flush="false"/>
      </f:subview>
    </td>
  </tr>
</table>