package org.profamilia.hc.sap.webservice.usuariosSapWSService;

import java.rmi.RemoteException;

import org.profamilia.hc.model.dto.Chusuario;
import org.profamilia.hc.model.dao.*;
import org.profamilia.hc.model.dto.Cpmunidane;
import org.profamilia.hc.sap.webservice.creacliente.CreaCliReq;
import org.profamilia.hc.sap.webservice.creacliente.CreaCliente_Sync_OutProxy;
import org.profamilia.hc.sap.webservice.creacliente.Resp;
import org.profamilia.hc.sap.webservice.creacliente.Respuesta;
import org.profamilia.hc.sap.webservice.modcliente.ModCliReq;
import org.profamilia.hc.sap.webservice.modcliente.ModCliResp;
import org.profamilia.hc.sap.webservice.modcliente.ModCliRespT_Resp;
import org.profamilia.hc.sap.webservice.modcliente.ModClientes_Sync_OutProxy;

public class UsuarioWsSap {

    //Variables    
        static final int ACTIVAR_SELECCIONAR_USUARIO = 1;
        static final String TIPO_VINCULACION_ONE = "Cotizante";
        static final String TIPO_VINCULACION_TWO = "Beneficiario";
        final String DATOS_GENERAL_CLAVE_PAIS = "CO";
        final String DATOS_LIS = "PN";
        final String DATOS_GENERAL_PERSONA_FISICA = "X";
        final String DATOS_GENERAL_CLASIFICACION_DEUDOR = "1";
        final String DATOS_SOCIEDAD_SOCIEDAD = "PRFI";
        final String DATOS_SOCIEDAD_CLAVE_COND_PAGO = "D01A";
        final String DATOS_SOCIEDAD_CUENTA_ASOCIADA = "1302250505";
        final String DATOS_SOCIEDAD_GRUPO_TESORERIA = "5101";
        final String DATOS_SOCIEDAD_CLAVE_ASIG = "031";
        final String DATOS_COMERCIAL_ORG_VENTAS = "1100";
        final String DATOS_COMERCIAL_CANALDIST = "00";
        final String DATOS_COMERCIAL_SECTOR = "00";
        final String DATOS_COMERCIAL_ESQUEMA_CLIENTE = "1";
        final String DATOS_COMERCIAL_COND_EXPEDICION = "01";
        final String DATOS_COMERCIAL_GRUP_IMPUT_CLIENTE = "01";
        final String DATOS_COMERCIAL_CLAVE_COND_PAGO = "D01A";
        final String DATOS_COMERCIAL_GRUPO_CLIENTES = "17";
        final String DATOS_COMERCIAL_CLAVE_MONEDA = "COP";
        final String CLIENTE_CONTACTO_FUNCION_CONTACTO = "00";
        private String respuestaWS;

    public UsuarioWsSap() {

    }
    //********************************************
        //Metodos   

        public String saveUsuarioSap(Chusuario datosUsuario, Cpmunidane auxMuni) throws Exception {
            Respuesta result;
            String mensajeRespuesta = null;
            
            try {
                CreaCliente_Sync_OutProxy service
                        = new CreaCliente_Sync_OutProxy();

                CreaCliReq creaclient = new CreaCliReq();
                creaclient.setNombre1(datosUsuario.getHuscprimernomb());
                creaclient.setNombre2(datosUsuario.getHuscsegundnomb());
                creaclient.setNombre3(datosUsuario.getHuscprimerapel());
                if (datosUsuario.getHuscsegundapel() == null || datosUsuario.getHuscsegundapel().equals("")) {
                    creaclient.setNombre4("-");
                } else {
                    creaclient.setNombre4(datosUsuario.getHuscsegundapel());
                }

                if (datosUsuario.getHuscsegundnomb() == null || datosUsuario.getHuscsegundnomb().equals("")) {
                    creaclient.setNombre2("-");
                } else {
                    creaclient.setNombre2(datosUsuario.getHuscsegundnomb());
                }
                creaclient.setCampoClasific(datosUsuario.getHusanumeiden().toString());

                creaclient.setGrupoCtasDeudor("ZPAR");
                if (datosUsuario.getHusesexo() != null
                        && datosUsuario.getHusesexo().equals("F")) {
                    creaclient.setTratamiento("SE�ORA");
                } else if (datosUsuario.getHusesexo() != null
                        && datosUsuario.getHusesexo().equals("M")) {
                    creaclient.setTratamiento("SE�OR");
                } else if (datosUsuario.getHusesexo() != null
                        && datosUsuario.getHusesexo().equals("I")) {
                    creaclient.setTratamiento("SE�OR Y SE�ORA");
                }
                creaclient.setCallenum(datosUsuario.getHuscdireccion());
              
                if (datosUsuario.getHusndepartamen() != null
                        && datosUsuario.getHusndepartamen() == 11L) {
                    creaclient.setPoblacion("BOGOTA");
                } else {
                    creaclient.setPoblacion(auxMuni.getCmdcnommun());
                }
                creaclient.setClavePais(DATOS_GENERAL_CLAVE_PAIS);
                creaclient.setRegion(datosUsuario.getHusndepartamen().toString());
                creaclient.setTel(datosUsuario.getHusctelefono());
                creaclient.setTelMovil(datosUsuario.getHusccelular());
                creaclient.setFax("0");
                if (datosUsuario.getHusetipcliente() != null
                        && datosUsuario.getHusetipcliente().equals("F")) {
                    creaclient.setRamoIndust("Z002");
                } else {
                    creaclient.setRamoIndust("");
                }
                creaclient.setNumFiscal(datosUsuario.getHusanumeiden().toString());
                creaclient.setTipoNumFiscal(obtenerTipoIdentificacionSAP(datosUsuario.getHusetipoiden()));

                creaclient.setLIS(DATOS_LIS);
                creaclient.setPerFisica(DATOS_GENERAL_PERSONA_FISICA);
                creaclient.setClasificacionDeudor(DATOS_GENERAL_CLASIFICACION_DEUDOR);
                creaclient.setSociedad(DATOS_SOCIEDAD_SOCIEDAD);
                creaclient.setCuentaAsoc(DATOS_SOCIEDAD_CUENTA_ASOCIADA);
                creaclient.setClaveAsig(DATOS_SOCIEDAD_CLAVE_ASIG);
                creaclient.setGrupTesorera(DATOS_SOCIEDAD_GRUPO_TESORERIA);
                creaclient.setClaveCondPago(DATOS_SOCIEDAD_CLAVE_COND_PAGO);
                creaclient.setOrgVentas(DATOS_COMERCIAL_ORG_VENTAS);
                creaclient.setCanalDist(DATOS_COMERCIAL_CANALDIST);
                creaclient.setSector(DATOS_COMERCIAL_SECTOR);
                creaclient.setGrupoClientes(DATOS_COMERCIAL_GRUPO_CLIENTES);
                creaclient.setClaveMoneda(DATOS_COMERCIAL_CLAVE_MONEDA);
                creaclient.setEsqCliente(DATOS_COMERCIAL_ESQUEMA_CLIENTE);
                creaclient.setCondExped(DATOS_COMERCIAL_COND_EXPEDICION);
                creaclient.setClaveCondPago(DATOS_COMERCIAL_CLAVE_COND_PAGO);
                creaclient.setGrupImputClient(DATOS_COMERCIAL_GRUP_IMPUT_CLIENTE);
                if (datosUsuario.getHuscnomacompana() == null
                        || datosUsuario.getHuscnomacompana().equals("")) {
                    creaclient.setNombreCompl("-");
                } else {
                    creaclient.setNombreCompl(datosUsuario.getHuscnomacompana());
                }
                creaclient.setFechaNacim((datosUsuario.getHusdfechanacim()));
                creaclient.setFuncionPersona(CLIENTE_CONTACTO_FUNCION_CONTACTO);
                if (datosUsuario.getHusesexo() != null
                        && datosUsuario.getHusesexo().equals("M")) {
                    creaclient.setGenero("1");
                } else if (datosUsuario.getHusesexo() != null
                        && datosUsuario.getHusesexo().equals("F")) {
                    creaclient.setGenero("2");
                } else if (datosUsuario.getHusesexo() != null
                        && datosUsuario.getHusesexo().equals("I")) {
                    creaclient.setGenero("0");
                }

                Respuesta respuesta
                        = service.creaCliente_Sync_Out(creaclient);
                result = respuesta;
                Resp[] resp;
                resp = respuesta.getResp();

                for (Resp auxi : resp) {
                    mensajeRespuesta = auxi.getMessage();
                    //logger.info("" + auxi.getMessage());
                }

            } catch (RemoteException e) {
                respuestaWS = "Error almacenando usuario";
                throw new Exception("Error almacenando usuario ServicioWeb - invokeCreaCLienteWS:" + datosUsuario.getHusanumeiden() + "" + e.getMessage(), e);
            }
            return mensajeRespuesta;
        }

        public String modificarUsuarioSap(Chusuario datosUsuario,Long numeroIden, Cpmunidane auxMuni) throws Exception {
            ModCliResp result;
            String tipoRespuesta = null;
            try {
                ModClientes_Sync_OutProxy service
                        = new ModClientes_Sync_OutProxy();

                ModCliReq modifclient = new ModCliReq();
                modifclient.setNombre1(datosUsuario.getHuscprimernomb());
                modifclient.setNombre2(datosUsuario.getHuscsegundnomb());
                modifclient.setNombre3(datosUsuario.getHuscprimerapel());
                if (datosUsuario.getHuscsegundapel() == null || datosUsuario.getHuscsegundapel().equals("")) {
                    modifclient.setNombre4("-");
                } else {
                    modifclient.setNombre4(datosUsuario.getHuscsegundapel());
                }

                if (datosUsuario.getHuscsegundnomb() == null || datosUsuario.getHuscsegundnomb().equals("")) {
                    modifclient.setNombre2("-");
                } else {
                    modifclient.setNombre2(datosUsuario.getHuscsegundnomb());
                }
                //Numero Nuevo Cedula->SAP->SORTL
                modifclient.setCamposClasif(datosUsuario.getHusanumeiden().toString());
                modifclient.setGrupoCuentDeudor("ZPAR");
                if (datosUsuario.getHusesexo() != null
                        && datosUsuario.getHusesexo().equals("F")) {
                    modifclient.setTratamiento("SE�ORA");
                } else if (datosUsuario.getHusesexo() != null
                        && datosUsuario.getHusesexo().equals("M")) {
                    modifclient.setTratamiento("SE�OR");
                } else if (datosUsuario.getHusesexo() != null
                        && datosUsuario.getHusesexo().equals("I")) {
                    modifclient.setTratamiento("SE�OR");
                }
                modifclient.setCalleNum(datosUsuario.getHuscdireccion());
                modifclient.setTratamiento("SE�OR");
                
                if (datosUsuario.getHusndepartamen() != null
                        && datosUsuario.getHusndepartamen() == 11L) {
                    modifclient.setPoblacion("BOGOTA");
                } else {
                    modifclient.setPoblacion(auxMuni.getCmdcnommun());
                }
                modifclient.setPais(DATOS_GENERAL_CLAVE_PAIS);
                modifclient.setRegion(datosUsuario.getHusndepartamen().toString());
                modifclient.setTelefono(datosUsuario.getHusctelefono());
                modifclient.setNumMob(datosUsuario.getHusccelular());
                modifclient.setNumeroFax("0");
                if (datosUsuario.getHusetipcliente() != null
                        && datosUsuario.getHusetipcliente().equals("F")) {
                    modifclient.setClaveRamoInd("Z002");
                } else {
                    modifclient.setClaveRamoInd("");
                }
                //Numero Anterior Cedula->SAP->STCD1
                modifclient.setNumIdFiscal(numeroIden.toString());
                
                modifclient.setTipoIdFiscal(obtenerTipoIdentificacionSAP(datosUsuario.getHusetipoiden()));
                
                //TODO: Verificar este campo
                modifclient.setGrupoAct(DATOS_LIS);
                modifclient.setPersonaFisica(DATOS_GENERAL_PERSONA_FISICA);
                modifclient.setClasfFiscalDeud(DATOS_GENERAL_CLASIFICACION_DEUDOR);
                modifclient.setSociedad(DATOS_SOCIEDAD_SOCIEDAD);
                modifclient.setCuentaSoc(DATOS_SOCIEDAD_CUENTA_ASOCIADA);
                modifclient.setClaveNumAsig(DATOS_SOCIEDAD_CLAVE_ASIG);
                modifclient.setGrupoTesoreria(DATOS_SOCIEDAD_GRUPO_TESORERIA);
                modifclient.setClaveCondPago(DATOS_SOCIEDAD_CLAVE_COND_PAGO);
                modifclient.setOrgVentas(DATOS_COMERCIAL_ORG_VENTAS);
                modifclient.setCanalDist(DATOS_COMERCIAL_CANALDIST);
                modifclient.setSector(DATOS_COMERCIAL_SECTOR);
                modifclient.setGrupoCli(DATOS_COMERCIAL_GRUPO_CLIENTES);
                modifclient.setClaveMoneda(DATOS_COMERCIAL_CLAVE_MONEDA);
                modifclient.setEsquemaCli(DATOS_COMERCIAL_ESQUEMA_CLIENTE);
                modifclient.setCondExpd(DATOS_COMERCIAL_COND_EXPEDICION);
                modifclient.setClaveCondPago(DATOS_COMERCIAL_CLAVE_COND_PAGO);
                modifclient.setGrupoImpCli(DATOS_COMERCIAL_GRUP_IMPUT_CLIENTE);

                if (datosUsuario.getHuscnomacompana() == null
                        || datosUsuario.getHuscnomacompana().equals("")) {
                    modifclient.setNombreComplet("-");
                } else {
                    modifclient.setNombreComplet(datosUsuario.getHuscnomacompana());
                }

                modifclient.setFechaNacimiento((datosUsuario.getHusdfechanacim()));
                modifclient.setFuncionPers(CLIENTE_CONTACTO_FUNCION_CONTACTO);

                if (datosUsuario.getHusesexo() != null
                        && datosUsuario.getHusesexo().equals("M")) {
                    modifclient.setGeneroInt("1");
                } else if (datosUsuario.getHusesexo() != null
                        && datosUsuario.getHusesexo().equals("F")) {
                    modifclient.setGeneroInt("2");
                } else if (datosUsuario.getHusesexo() != null
                        && datosUsuario.getHusesexo().equals("I")) {
                    modifclient.setGeneroInt("0");
                }

                ModCliResp respuesta
                        = service.modClientes_Sync_Out(modifclient);
                result = respuesta;

                ModCliRespT_Resp[] resp;
                resp = respuesta.getT_Resp();

                for (ModCliRespT_Resp auxi : resp) {
                    tipoRespuesta = auxi.getTipo();
                    //logger.info("" + auxi.getMensaje());
                }

            } catch (RemoteException e) {
                throw new Exception("Error almacenando usuario ServicioWeb - invokeCreaCLienteWS:" + datosUsuario.getHusanumeiden() + "" + e.getMessage(), e);
            }
            return tipoRespuesta;
        }
        
    public  String obtenerTipoIdentificacionSAP(String tipoIdentificacion) {
        String tipoNumFiscal = null;
        if (tipoIdentificacion != null) {
            if (tipoIdentificacion.equals("CC")) {
                tipoNumFiscal = "13";
            } else if (tipoIdentificacion.equals("TI")) {
                tipoNumFiscal = "12";
            } else if (tipoIdentificacion.equals("RC")) {
                tipoNumFiscal = "11";
            } else if (tipoIdentificacion.equals("CE")) {
                tipoNumFiscal = "22";
            } else if (tipoIdentificacion.equals("AS")) {
                tipoNumFiscal = "51";
            } else if (tipoIdentificacion.equals("PA")) {
                tipoNumFiscal = "41";
            } else if (tipoIdentificacion.equals("PE")) {
                tipoNumFiscal = "46";
            } else if (tipoIdentificacion.equals("MS")) {
                tipoNumFiscal = "52";
            } else if (tipoIdentificacion.equals("NI")) {
                tipoNumFiscal = "31";
            }
        }
        return tipoNumFiscal;
    }

        public String getRespuestaWS() {
            return respuestaWS;
        }

        public void setRespuestaWS(String respuestaWS) {
            this.respuestaWS = respuestaWS;
        }
}