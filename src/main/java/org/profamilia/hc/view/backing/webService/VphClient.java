/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package org.profamilia.hc.view.backing.webService;


import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;
import java.io.IOException;
import java.security.SecureRandom;
import javax.net.ssl.SSLContext;
import javax.net.ssl.TrustManager;
import javax.net.ssl.X509TrustManager;
import org.apache.http.client.HttpClient;
import org.springframework.stereotype.Service;
import java.security.cert.X509Certificate;
import java.util.ArrayList;
import java.util.List;
import javax.faces.model.SelectItem;
import org.apache.http.HttpResponse;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.conn.ssl.SSLConnectionSocketFactory;
import org.apache.http.entity.StringEntity;
import org.apache.http.impl.client.HttpClientBuilder;
import org.apache.http.util.EntityUtils;

/**
 *
 * @author Daniel Ochoa
 */
@Service("vphClient")
public class VphClient {

    private List<SelectItem> listTipoWebService;

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

    public RegistraEpicienterResult registrarTomaVph(RegistroTomaVph registroTomaVph) throws IOException {
        List<RegistraEpicienterResult> registroTomaVphResult = new ArrayList();
        RegistraEpicienterResult registraEpicienterResult = new RegistraEpicienterResult();
        HttpClient httpclient = getHttpClient();
        //HttpPost requestPost = new HttpPost("http://profamilia.azurewebsites.net/ProfamiliaCG.svc/RegistroInformacion");
        HttpPost requestPost = new HttpPost("http://labvph/CG.WCF.Servicio/ProfamiliaCG.svc/RegistroInformacion");
        Gson gson = new Gson();
        String json = gson.toJson(registroTomaVph);
        StringEntity entity = new StringEntity(json);
        entity.setContentType("application/json");

        requestPost.setEntity(entity);
        HttpResponse response = httpclient.execute(requestPost);
        String respuesta = EntityUtils.toString(response.getEntity());
        
         String[] parts = respuesta.split("\\{");
        String resulado = parts[2];
        String jsonResultado="{"+resulado.substring(0,resulado.length()-1);

        Gson gson2 = new Gson();
        registraEpicienterResult = gson2.fromJson(jsonResultado, RegistraEpicienterResult.class);
//        registroTomaVphResult = gson2.fromJson(respuesta, new TypeToken<List<RegistraEpicienterResult>>() {
//        }.getType());
        registroTomaVphResult.add(registraEpicienterResult);
        return registraEpicienterResult;
    }

    public List<ConsultaEpicenterResult> consultaTomaVph(ConsultaTomaVph consultaTomaVph) throws IOException {
        ConsultaEpicenterResult consultaEpicenterResult = new ConsultaEpicenterResult();
        List<ConsultaEpicenterResult> consultaTomaVphResultList = new ArrayList();
        //ConsultaEpicenterResult consultaTomaVphR = new ConsultaEpicenterResult();
        HttpClient httpclient = getHttpClient();
        HttpPost requestPost = new HttpPost("http://labvph/CG.WCF.Servicio/ProfamiliaCG.svc/RetornaEpicenter");
        Gson gson = new Gson();
        String json = gson.toJson(consultaTomaVph);
        StringEntity entity = new StringEntity(json);
        entity.setContentType("application/json");

        requestPost.setEntity(entity);
        HttpResponse response = httpclient.execute(requestPost);
        String respuesta = EntityUtils.toString(response.getEntity());
        String[] parts = respuesta.split("\\{");
        String resulado = parts[2];
        String jsonResultado="{"+resulado.substring(0,resulado.length()-1);

        Gson gson2 = new Gson();
        /*consultaTomaVphResultList  =(List<ConsultaEpicenterResult>) gson2.fromJson(jsonResultado, new TypeToken<List<ConsultaEpicenterResult>>() {
       }.getType());*/
        consultaEpicenterResult = gson2.fromJson(jsonResultado, ConsultaEpicenterResult.class);

        consultaTomaVphResultList.add(consultaEpicenterResult);

        return consultaTomaVphResultList;
    }

    public List<SelectItem> getListTipoWebService() {
        if (listTipoWebService == null || listTipoWebService.isEmpty()) {
            listTipoWebService = new ArrayList();
            listTipoWebService.add(new SelectItem("R", "Registro Toma"));
            listTipoWebService.add(new SelectItem("C", "Consulta Toma"));
        }
        return listTipoWebService;
    }

}
