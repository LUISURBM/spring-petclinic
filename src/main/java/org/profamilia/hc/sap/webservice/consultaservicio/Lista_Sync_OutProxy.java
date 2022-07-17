 package org.profamilia.hc.sap.webservice.consultaservicio;

public class Lista_Sync_OutProxy implements Lista_Sync_Out {
  private String _endpoint = null;
  private Lista_Sync_Out lista_Sync_Out = null;
  
  public Lista_Sync_OutProxy() {
    _initLista_Sync_OutProxy();
  }
  
  public Lista_Sync_OutProxy(String endpoint) {
    _endpoint = endpoint;
    _initLista_Sync_OutProxy();
  }
  
  private void _initLista_Sync_OutProxy() {
    try {
     // lista_Sync_Out = (new Lista_Sync_OutServiceLocator()).getHTTPS_Port();
        lista_Sync_Out = (new Lista_Sync_OutServiceLocator()).getHTTP_Port();
      if (lista_Sync_Out != null) {
        if (_endpoint != null)
          ((javax.xml.rpc.Stub)lista_Sync_Out)._setProperty("javax.xml.rpc.service.endpoint.address", _endpoint);
        else
          _endpoint = (String)((javax.xml.rpc.Stub)lista_Sync_Out)._getProperty("javax.xml.rpc.service.endpoint.address");
      }
      
    }
    catch (javax.xml.rpc.ServiceException serviceException) {}
  }
  
  public String getEndpoint() {
    return _endpoint;
  }
  
  public void setEndpoint(String endpoint) {
    _endpoint = endpoint;
    if (lista_Sync_Out != null)
      ((javax.xml.rpc.Stub)lista_Sync_Out)._setProperty("javax.xml.rpc.service.endpoint.address", _endpoint);
    
  }
  
  public Lista_Sync_Out getLista_Sync_Out() {
    if (lista_Sync_Out == null)
      _initLista_Sync_OutProxy();
    return lista_Sync_Out;
  }
  
  public ListaResp lista_Sync_Out(ListaReq messageRequest) throws java.rmi.RemoteException{
    if (lista_Sync_Out == null)
      _initLista_Sync_OutProxy();
    return lista_Sync_Out.lista_Sync_Out(messageRequest);
  }
  
  
}