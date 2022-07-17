/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package org.profamilia.hc.view.backing.webService.saludTotal;


import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;
import java.io.IOException;
import java.security.SecureRandom;
import javax.net.ssl.SSLContext;
import javax.net.ssl.TrustManager;
import javax.net.ssl.X509TrustManager;
import org.apache.http.client.HttpClient;

import org.profamilia.hc.view.backing.webService.ConsultaEpicenterResult;
import org.profamilia.hc.view.backing.webService.ConsultaTomaVph;
import org.profamilia.hc.view.backing.webService.RegistraEpicienterResult;

import org.profamilia.hc.view.backing.webService.RegistroTomaVph;

import org.profamilia.hc.view.backing.webService.saludTotal.dto.request.IPS;

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

import org.profamilia.hc.view.backing.webService.saludTotal.dto.response.ResultadosLCResponse;

/**
 *
 * @author Daniel Ochoa
 */
@Service("saludTotalClient")
public class SaludTotalClient {

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

    public ResultadosLCResponse registrarResultadoLC(IPS ips,String urlConsumo) throws IOException {
        ResultadosLCResponse resultadosLCResponse = new ResultadosLCResponse();
        HttpClient httpclient = getHttpClient();
        HttpPost requestPost = new HttpPost(urlConsumo);
        Gson gson = new Gson();
        String json = gson.toJson(ips);
        StringEntity entity = new StringEntity(json,"UTF-8");
        entity.setContentType("application/json;charset=UTF-8");

        requestPost.setEntity(entity);
        HttpResponse response = httpclient.execute(requestPost);
        String respuesta = EntityUtils.toString(response.getEntity());
        
        Gson gson2 = new Gson();
        resultadosLCResponse = gson2.fromJson(respuesta, ResultadosLCResponse.class);
        return resultadosLCResponse;
    }


}
