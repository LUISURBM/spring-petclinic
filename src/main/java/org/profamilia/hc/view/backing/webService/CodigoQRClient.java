package org.profamilia.hc.view.backing.webService;

import com.google.gson.Gson;

import java.io.IOException;

import java.security.SecureRandom;
import java.security.cert.X509Certificate;

import java.text.SimpleDateFormat;

import java.util.ArrayList;

import java.util.List;

import javax.net.ssl.SSLContext;
import javax.net.ssl.TrustManager;
import javax.net.ssl.X509TrustManager;

import org.apache.http.HttpResponse;
import org.apache.http.NameValuePair;
import org.apache.http.client.HttpClient;
import org.apache.http.client.entity.UrlEncodedFormEntity;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.conn.ssl.SSLConnectionSocketFactory;
import org.apache.http.entity.StringEntity;
import org.apache.http.impl.client.HttpClientBuilder;
import org.apache.http.message.BasicNameValuePair;
import org.apache.http.util.EntityUtils;

import org.profamilia.hc.model.dto.Cncitologi;
import org.profamilia.hc.model.dto.Cncitotoma;
import org.profamilia.hc.view.backing.BaseBean;
import org.profamilia.hc.view.util.ModuleConfig;

public class CodigoQRClient extends BaseBean{
    
    private static HttpClient getHttpClient() {

        try {
            SSLContext sslContext = SSLContext.getInstance("SSL");

            sslContext.init(null,
                    new TrustManager[]{new X509TrustManager() {
                    public X509Certificate[] getAcceptedIssuers() {

                        return null;
                    }

                    public void checkClientTrusted(
                            X509Certificate[] certs, String authType) {

                    }

                    public void checkServerTrusted(
                            X509Certificate[] certs, String authType) {

                    }
                }}, new SecureRandom());

            SSLConnectionSocketFactory socketFactory = new SSLConnectionSocketFactory(sslContext, SSLConnectionSocketFactory.ALLOW_ALL_HOSTNAME_VERIFIER);

            HttpClient httpClient = HttpClientBuilder.create().setSSLSocketFactory(socketFactory).build();

            return httpClient;

        } catch (Exception e) {
            e.printStackTrace();
            return HttpClientBuilder.create().build();
        }
    }
    
    public String generarCodigoQR(Cncitologi citologia, Cncitotoma toma, 
                                  String clinica) throws IOException {
        HttpClient httpclient = getHttpClient();
        ModuleConfig config = new ModuleConfig();
        HttpPost requestPost = 
            new HttpPost(config.getDireccionCodigoQR());
        SimpleDateFormat df = new SimpleDateFormat ("dd/MM/yyyy");
        
        DatosCodigoQRDTO datosCodigoQRDTO = new DatosCodigoQRDTO();
        
        datosCodigoQRDTO.setNombre(formatearNombreCitologia(citologia.getCcicprinom())+" "+formatearNombreCitologia(citologia.getCcicsegnom())+" "+formatearNombreCitologia(citologia.getCcicpriape())+" "+formatearNombreCitologia(citologia.getCcicsegape()));
        datosCodigoQRDTO.setTipoIdentificacion(citologia.getCcictipide());
        datosCodigoQRDTO.setNumeroIdentificacion(citologia.getCcianumide());
        datosCodigoQRDTO.setFechaToma(df.format(toma.getCtmdfecreg()));
        datosCodigoQRDTO.setNumeroCitologia(citologia.getCcinconsec().toString());
        datosCodigoQRDTO.setClinica(clinica);
        
        Gson gson = new Gson();
        String json = gson.toJson(datosCodigoQRDTO);
        StringEntity entity = new StringEntity(json);
        entity.setContentType("application/json");

        requestPost.setEntity(entity);
        HttpResponse response = httpclient.execute(requestPost);
        String respuesta = EntityUtils.toString(response.getEntity());
        
        return respuesta;
    }
    
    
    public String generarCodigoQRLista(List<Object[]> consecutivoLista) throws IOException {
        HttpClient httpclient = getHttpClient();
        ModuleConfig config = new ModuleConfig();
        HttpPost requestPost = 
            new HttpPost(config.getDireccionCodigoQRLista());
        SimpleDateFormat df = new SimpleDateFormat ("dd/MM/yyyy");
        
        DatosCodigoQRListDTO datosCodigoQRListDTO = new DatosCodigoQRListDTO();
        
        datosCodigoQRListDTO.setListatoma(consecutivoLista);
        
        Gson gson = new Gson();
        String json = gson.toJson(datosCodigoQRListDTO);
        StringEntity entity = new StringEntity(json,"UTF-8");
        entity.setContentType("application/json; charset=UTF-8");

        requestPost.setEntity(entity);
        HttpResponse response = httpclient.execute(requestPost);
        String respuesta = EntityUtils.toString(response.getEntity());
        
        return respuesta;
    }
}
