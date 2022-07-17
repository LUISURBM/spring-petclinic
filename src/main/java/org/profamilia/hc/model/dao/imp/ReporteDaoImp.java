package org.profamilia.hc.model.dao.imp;

import java.math.BigDecimal;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.hibernate.HibernateException;
import org.hibernate.Query;
import org.hibernate.Session;
import org.profamilia.hc.model.dao.ReporteDao;
import org.profamilia.hc.model.dto.ReporteCervixDTO;
import org.profamilia.hc.model.exceptions.ModelException;
import org.springframework.orm.hibernate3.HibernateCallback;
import org.springframework.orm.hibernate3.support.HibernateDaoSupport;


public class ReporteDaoImp extends HibernateDaoSupport implements ReporteDao {
    public ReporteDaoImp() {
        super();
    }
    public List<ReporteCervixDTO> reporteSaludTotal(final Long numeroClinica, 
                                                       final Date fechaInicial, 
                                                       final Date fechaFinal, 
                                                       final Long numeroContrato) throws ModelException {
           List<ReporteCervixDTO> resultList = null;
         
           List<ReporteCervixDTO> pis = 
               (List<ReporteCervixDTO>)getHibernateTemplate().execute(new HibernateCallback() {
                       public Object doInHibernate(Session session) throws HibernateException {
                           StringBuffer sb = new StringBuffer();
                           List<ReporteCervixDTO> resultList = new ArrayList<ReporteCervixDTO>();
                           try{
                               sb.append("  select * from (");
                               sb.append("  select USUARIO,CONTRATO_SELEC,TIPO_IDEN,NUMERO_IDENTIFICACION,PRIMER_NOMBRE,SEGUNDO_NOMBRE,PRIMER_APELLIDO,SEGUNDO_APELLIDO,CLINICA,NOMBRE_CLINCIA,CODIGO_HABILITA ");
                               sb.append("  ,FECHA_NAC ,AILIACION ,FECHA_REGISTRO,FECHA_TOMA,RESULTADO_VPH,CASE1,CASE2,CASE3,CASE4,CASE5,CASE6,CASE7,CASE8,CASE9,CASE10,FECHA_LECTURA,CELULAS_ESCAMOSAS,DESCRIPCION_CELULAS,");
                               sb.append(" FECHA_COLPOSCOPIA,CASE11,CASE12,CASE13,CASE14,CASE15,CASE16,CASE17,CASE18,TOMO_BIOPSA,SERVICIO,FECHA_REG1,RESULTADO_BIOP,RESULTADO_PATOL,DESCRIPCION_RES  from ( ");
                               sb.append(" Select  chus.HUSLNUMERO USUARIO, chsa.CONTRATO CONTRATO_SELEC , chus.HUSETIPOIDEN TIPO_IDEN, chus.HUSANUMEIDEN NUMERO_IDENTIFICACION, ");
                               sb.append("  chus.HUSCPRIMERNOMB PRIMER_NOMBRE,chus.HUSCSEGUNDNOMB SEGUNDO_NOMBRE,chus.HUSCPRIMERAPEL PRIMER_APELLIDO,chus.HUSCSEGUNDAPEL SEGUNDO_APELLIDO,");
                               sb.append("  cnci.CCINCLINIC CLINICA,cpcl.CCLCNOMBRE NOMBRE_CLINCIA,cpcl.CCLCCODSGS CODIGO_HABILITA,chus.husdfechanacim FECHA_NAC,chus.husetipoafilia AILIACION, ");                         
                               sb.append("  cnco.CCODFECREG FECHA_REGISTRO,cnct.CTMDFECTOM FECHA_TOMA, case when cncl.CCVCGENONEG = 'N' then '19' when  cncl.CCVCGENONEG  = 'S' then '20' when  cncl.CCVCGENONEG  = 'NS' then 'No satisfactoria' else ");                      
                               sb.append(" '21' end RESULTADO_VPH, case when cncl.CCVCGENONEG = 'N' then 'Detectable' else '' end CASE1 ,case when  cncl.CCVCGT16  = 'S' then '16' else '' end CASE2 ,case when cncl.CCVCGT18 ='S' then '18' else '' end CASE3, ");                     
                               sb.append(" case when cncl.CCVCGT31 ='S' then '31' else '' end CASE4, case when cncl.CCVCGT45 ='S' then '45' else '' end CASE5, case when cncl.CCVCGT51 ='S' then '51' else '' end CASE6, case when cncl.CCVCGT52 ='S' then '52' else '' end CASE7, ");                       
                               
                               sb.append(" case when cncl.CCVCGT3858 ='S' then 'Grupo 1(33,58)' else '' end CASE8,case when cncl.CCVCGT565966 ='S' then 'Grupo 2(56,59,66)' else '' end CASE9, case when cncl.CCVCGT353968 ='S' then 'Grupo 3(35,39,68)' else '' end CASE10, ");
                               sb.append("  cncle.CLCDFECREG FECHA_LECTURA, cncle.CLCCANOESC CELULAS_ESCAMOSAS,cnde.CDICDESCRI DESCRIPCION_CELULAS");                         
                               sb.append(" from clinico.cncitologi cnci ");
                               sb.append(" INNER JOIN historia.chusuario chus ON chus.HUSLNUMERO = cnci.CCILUSUARIO");
                               sb.append("  JOIN clinico.cncitotoma cnct  ON  cnci.ccinconsec = cnct.ctmnconsec");
                               sb.append(" LEFT JOIN  clinico.cncitovphlect cncl ON cnci.ccinconsec = cncl.ccvnconsec  "); 
                               sb.append(" INNER JOIN  clinico.CNCONSCLIN cnco ON cnco.CCONNUMERO = cnci.CCILCONCLI");
                               sb.append(" INNER JOIN  CLINICO.CFADMISION cfad ON cfad.CANNUMERO = cnci.CCINNUMDOC");
                               sb.append("  LEFT JOIN  CLINICO.CNCITOLECT cncle ON cncle.CLCNCONSEC = cnct.CTMNCONSEC");
                               
                               sb.append(" LEFT JOIN  CLINICO.CNDESCCITO cnde ON cncle.CLCCANOESC = cnde.CDICVALOR");
                               sb.append("  LEFT JOIN historia.CHSALUDTOTAL chsa ON chus.HUSETIPOIDEN=chsa.TIPOIDEN and chus.HUSANUMEIDEN=chsa.NUMIDEN");                      
                               sb.append("  INNER JOIN  clinico.cpclinica cpcl on cpcl.CCLNCODIGO = cnci.CCINCLINIC");
                               sb.append("   where cnco.CCODFECREG BETWEEN :fechaInicial AND :fechaFinal");
                               if(numeroClinica!=0){
                                   sb.append(" and  cnci.ccinclinic =:clinica");
                               }
                               if(numeroContrato!=0){
                                   sb.append(" and cnco.cconcontra =:contrato)");
                               }
                               else{
                                   sb.append(" and cnco.cconcontra  in (41001374,41001375))"); 
                               }
                               sb.append("  LEFT JOIN");                       
                               sb.append("  (SELECT USUARIO7, CASE11, CASE12,CASE13,CASE14,CASE15,CASE16,CASE17,CASE18 ,TOMO_BIOPSA,FECHA_COLPOSCOPIA from");                      
                               sb.append("  (Select  chus.HUSLNUMERO USUARIO7 , chsa.CONTRATO contra , chus.HUSETIPOIDEN TIPO_IDEN , chus.HUSANUMEIDEN NUMERO_IDENTIFICACION,  ");                         
                               sb.append("   chus.HUSCPRIMERNOMB PRIMER_NOMBRE,chus.HUSCSEGUNDNOMB SEGUNDO_NOMBRE,chus.HUSCPRIMERAPEL PRIMER_APELLIDO,chus.HUSCSEGUNDAPEL SEGUNDO_APELLIDO,");
                               sb.append("   cnco.CCONCLINIC CLINICA,cpcl.CCLCNOMBRE NOMBRE_CLINCIA,cpcl.CCLCCODSGS CODIGO_HABILITA,chus.husdfechanacim FECHA_NAC,chus.husetipoafilia AILIACION, ");                    
                               sb.append(" chid.HIDDFECREGISTR FECHA_COLPOSCOPIA,case when chid.HIDCIMPRENORMA ='S' then 'Normal' else '' end CASE11  ");                     
                               sb.append("  ,case when chid.HIDCIMPRESUGES ='S' then 'Sugestiva de VPH' else '' end CASE12,case when chid.HIDCIMPREINFLA ='S' then 'Inflamatoria' else '' end CASE13,");                       
                               sb.append("  case when chid.HIDCIMPRELEYBA ='S' then 'LEI de bajo grado' else '' end CASE14, case when chid.HIDCIMPREATROF ='S' then 'Atr�fica' else '' end CASE15, ");                                                             
                               sb.append("  case when chid.HIDCIMPRELEYAL ='S' then 'LEI de alto grado ' else '' end CASE16, case when chid.HIDCIMPRECARCI ='S' then 'Carcinoma invasivo' else '' end CASE17,");
                               sb.append("   case when chid.HIDCIMPREOTRO ='S' then 'Otros' else '' end CASE18, chcol.HCLCTOMOBIOP TOMO_BIOPSA,");
                               sb.append("  cnco.CCONCONTRA CONTRATO");
                               sb.append("   from clinico.CNCONSCLIN cnco");
                               sb.append("   LEFT JOIN historia.CHCONSULTA chco ON chco.HCOLNUMERO = cnco.cconnumero ");
                               sb.append(" INNER JOIN historia.chusuario chus ON chus.HUSLNUMERO = cnco.ccolusuario ");
                               sb.append(" INNER JOIN  clinico.cpclinica cpcl on cpcl.CCLNCODIGO = cnco.CCONCLINIC ");
                               sb.append(" INNER JOIN historia.Chcolposcopia chcol ON chcol.hcllconsulta = chco.HCOLNUMERO");
                               sb.append("  INNER JOIN historia.CHIMPRDIAG chid ON  chco.HCOLNUMERO = chid.HIDLCONSULTA");
                               sb.append(" INNER JOIN clinico.cpservicio cpse ON cpse.CSVCCODIGO = cnco.CCOCSERVIC and cpse.CSVNTIPHIS = 11 ");                                                                            
                               sb.append("  LEFT JOIN historia.CHSALUDTOTAL chsa ON chus.HUSETIPOIDEN=chsa.TIPOIDEN and chus.HUSANUMEIDEN=chsa.NUMIDEN");                          
                               sb.append("  where cnco.ccocestado = 'VG' AND cnco.CCODFECREG BETWEEN :fechaInicial AND :fechaFinal");                            
                               if(numeroClinica!=0){
                                   sb.append(" and  cnco.CCONCLINIC =:clinica");
                               }
                               if(numeroContrato!=0){
                                   sb.append(" and cnco.cconcontra =:contrato))");
                               }
                               else{
                                   sb.append(" and cnco.cconcontra  in (41001374,41001375)))"); 
                               }
                               sb.append("   ON USUARIO7 = USUARIO");
                               sb.append("  LEFT JOIN");
                               sb.append("   (select USUARIO2 , CLINICA1,SERVICIO,FECHA_REG1 from");
                               sb.append(" (select chus.HUSLNUMERO USUARIO2, chsa.CONTRATO , chus.HUSETIPOIDEN TIPO_IDEN, chus.HUSANUMEIDEN NUMERO_IDENTIFICACION,   ");
                               sb.append("   chus.HUSCPRIMERNOMB PRIMER_NOMBRE,chus.HUSCSEGUNDNOMB SEGUNDO_NOMBRE,chus.HUSCPRIMERAPEL PRIMER_APELLIDO,chus.HUSCSEGUNDAPEL SEGUNDO_APELLIDO,");                                   
                               sb.append("  cnco.CCONCLINIC CLINICA1,cpcl.CCLCNOMBRE NOMBRE_CLINCIA,cpcl.CCLCCODSGS CODIGO_HABILITA,chus.husdfechanacim FECHA_NAC,chus.husetipoafilia AILIACION,");                       
                               sb.append(" cnco.CCODFECREG FECHA_REG1,cnco.CCOCSERVIC SERVICIO ");                        
                               sb.append("  from clinico.CNCONSCLIN cnco");
                               sb.append("  LEFT JOIN historia.CHCONSULTA chco ON chco.HCOLNUMERO = cnco.cconnumero");
                               sb.append("  INNER JOIN historia.chusuario chus ON chus.HUSLNUMERO = cnco.ccolusuario");
                               sb.append(" INNER JOIN  clinico.cpclinica cpcl on cpcl.CCLNCODIGO = cnco.CCONCLINIC ");
                               sb.append("  LEFT JOIN historia.CHSALUDTOTAL chsa ON chus.HUSETIPOIDEN=chsa.TIPOIDEN and chus.HUSANUMEIDEN=chsa.NUMIDEN");
                               sb.append("  where cnco.CCOCSERVIC IN('898101','S684020','672001') AND cnco.CCODFECREG BETWEEN :fechaInicial AND :fechaFinal");
                               if(numeroClinica!=0){
                                   sb.append(" and  cnco.CCONCLINIC =:clinica");
                               }
                               if(numeroContrato!=0){
                                   sb.append(" and cnco.cconcontra =:contrato");
                               }
                               else{
                                   sb.append(" and cnco.cconcontra  in (41001374,41001375)"); 
                               }
                               sb.append(" )) ON USUARIO = USUARIO2 ");                                    
                               sb.append("  LEFT JOIN");
                               sb.append(" (SELECT USUARIO3,RESULTADO_BIOP,RESULTADO_PATOL,DESCRIPCION_RES FROM( ");
                               sb.append("   (  select chus.HUSLNUMERO USUARIO3, chsa.CONTRATO , chus.HUSETIPOIDEN TIPO_IDEN, chus.HUSANUMEIDEN NUMERO_IDENTIFICACION, ");
                               sb.append("   chus.HUSCPRIMERNOMB PRIMER_NOMBRE,chus.HUSCSEGUNDNOMB SEGUNDO_NOMBRE,chus.HUSCPRIMERAPEL PRIMER_APELLIDO,chus.HUSCSEGUNDAPEL SEGUNDO_APELLIDO,");                                  
                               sb.append("  cnco.CCONCLINIC CLINICA,cpcl.CCLCNOMBRE NOMBRE_CLINCIA,cpcl.CCLCCODSGS CODIGO_HABILITA,chus.husdfechanacim FECHA_NAC,chus.husetipoafilia AILIACION, ");                           
                               sb.append("  chmo.HMCCRESBIOP RESULTADO_BIOP,chmo.HMCCRESPATOL RESULTADO_PATOL ,chmo.HMCCDESRES DESCRIPCION_RES");                     
                               sb.append("   from clinico.CNCONSCLIN cnco");
                               sb.append("  LEFT JOIN historia.CHCONSULTA chco ON chco.HCOLNUMERO = cnco.cconnumero");
                               sb.append("   INNER JOIN historia.chusuario chus ON chus.HUSLNUMERO = cnco.ccolusuario");
                               sb.append("  INNER JOIN  clinico.cpclinica cpcl on cpcl.CCLNCODIGO = cnco.CCONCLINIC");
                               sb.append("  LEFT JOIN historia.CHSALUDTOTAL chsa ON chus.HUSETIPOIDEN=chsa.TIPOIDEN and chus.HUSANUMEIDEN=chsa.NUMIDEN");                       
                               sb.append("  INNER JOIN historia.CHMOTIVOCONS chmo ON  chco.HCOLNUMERO = chmo.HMCLCONSULTA");           
                               sb.append("  where chmo.HMCCTIPPATOL='CX'");
                               sb.append("  and chco.HCODFECREGISTR BETWEEN :fechaInicial AND :fechaFinal and chco.HCOLUSUARIO=chus.HUSLNUMERO ");
                               if(numeroClinica!=0){
                                   sb.append(" and  cnco.CCONCLINIC =:clinica");
                               }
                               if(numeroContrato!=0){
                                   sb.append(" and cnco.cconcontra =:contrato");
                               }
                               else{
                                   sb.append(" and cnco.cconcontra  in (41001374,41001375)"); 
                               }
                               sb.append("  and chco.HCOLNUMERO = chmo.HMCLCONSULTA )))ON USUARIO = USUARIO3)");
                               String hql = sb.toString();
                               Query query = session.createQuery(hql);
                               query.setParameter("fechaInicial",fechaInicial);
                               query.setParameter("fechaFinal",fechaFinal);
                               if(numeroClinica!=0){
                                   query.setParameter("clinica",numeroClinica);
                               }
                               if(numeroContrato!=0){
                                   query.setParameter("contrato",numeroContrato);
                               }
                               List<Object[]> vph;
                               vph = query.list();
                               ReporteCervixDTO auxCervix ;
                               if(vph!= null && !vph.isEmpty()){ 
                                       for (int i = 0;i<vph.size();i++){
                                           Object[] aux = vph.get(i);
                                           auxCervix = new ReporteCervixDTO();
                                           auxCervix.setNumeroUsuario(((BigDecimal)aux[0]).longValue());
                                           if(aux[1]!=null){
                                               auxCervix.setNumeroContrato(aux[1].toString());
                                           }
                                                                         
                                           auxCervix.setTipoIden(aux[2].toString());
                                           auxCervix.setNumeroIden((""+aux[3]));
                                           auxCervix.setPrimerNombre((aux[4]).toString());  
                                           if(aux[5]!=null){
                                                   auxCervix.setSegundoNombre(aux[5].toString());
                                           }
                                           auxCervix.setPrimerApellido(aux[6].toString());
                                           if(aux[7]!=null){
                                                   auxCervix.setSegundoApellido(aux[7].toString());
                                           }
                                           auxCervix.setClincia(""+aux[8]+" "+aux[9]);
                                           auxCervix.setCodigoAutClin(""+(aux[10]));
                                           auxCervix.setFechaNacimiento((Date)(aux[11]));
                                           auxCervix.setTipoAfiliacion(aux[12].toString());
                                           auxCervix.setFechaAdmisionVPH((Date)aux[13]);
                                           auxCervix.setFechaTomaVPH((Date)aux[14]);
                                           auxCervix.setResultadoVPH(""+aux[15]);
                                           if(aux[16]!=null){
                                               auxCervix.setGenotipificacion("Se detectaron los Genotipos ");
                                           if(aux[17]!=null){
                                                       auxCervix.setGenotipificacion(auxCervix.getGenotipificacion()+" "+aux[17]);
                                           }
                                           if(aux[18]!=null){
                                               auxCervix.setGenotipificacion(auxCervix.getGenotipificacion()+" "+aux[18]);
                                           }
                                           if(aux[19]!=null){
                                               auxCervix.setGenotipificacion(auxCervix.getGenotipificacion()+" "+aux[19]);
                                           }
                                           if(aux[20]!=null){
                                               auxCervix.setGenotipificacion(auxCervix.getGenotipificacion()+" "+aux[20]);
                                           }
                                           if(aux[21]!=null){
                                               auxCervix.setGenotipificacion(auxCervix.getGenotipificacion()+" "+aux[21]);
                                           }
                                           if(aux[22]!=null){
                                                   auxCervix.setGenotipificacion(auxCervix.getGenotipificacion()+" "+aux[22]);
                                           }
                                           if(aux[23]!=null){
                                                   auxCervix.setGenotipificacion(auxCervix.getGenotipificacion()+" "+aux[23]);
                                           }
                                           if(aux[24]!=null){
                                                   auxCervix.setGenotipificacion(auxCervix.getGenotipificacion()+" "+aux[24]);
                                           }
                                           if(aux[25]!=null){
                                                   auxCervix.setGenotipificacion(auxCervix.getGenotipificacion()+" "+aux[25]);
                                           }
                                                                              
                                           }
                                           if(aux[26]!=null){
                                               auxCervix.setFechaCitoLiquida((Date)aux[26]);
                                           }
                                           if(aux[27]!=null){
                                                   auxCervix.setCelulasEscamosas(""+aux[27]+" "+aux[28]); 
                                           }
                                           if(aux[29]!=null){
                                               auxCervix.setFechaColposcopia((Date)aux[29]);
                                           }
                                           auxCervix.setImpresionColposcopia("");
                                           if(aux[30]!=null){
                                                auxCervix.setImpresionColposcopia(auxCervix.getImpresionColposcopia()+" "+aux[30].toString());
                                            }
                                            if(aux[31]!=null){
                                                auxCervix.setImpresionColposcopia(auxCervix.getImpresionColposcopia()+" "+aux[31].toString());
                                            }
                                            if(aux[32]!=null){
                                                auxCervix.setImpresionColposcopia(auxCervix.getImpresionColposcopia()+" "+aux[32].toString());
                                            }
                                            if(aux[33]!=null){
                                                auxCervix.setImpresionColposcopia(auxCervix.getImpresionColposcopia()+" "+aux[33].toString());
                                            }
                                            if(aux[34]!=null){
                                                auxCervix.setImpresionColposcopia(auxCervix.getImpresionColposcopia()+" "+aux[34].toString());
                                            }
                                            if(aux[35]!=null){
                                                auxCervix.setImpresionColposcopia(auxCervix.getImpresionColposcopia()+" "+aux[35].toString());
                                            }
                                            if(aux[36]!=null){
                                                auxCervix.setImpresionColposcopia(auxCervix.getImpresionColposcopia()+" "+aux[36].toString());
                                            }
                                            if(aux[37]!=null){
                                                auxCervix.setImpresionColposcopia(auxCervix.getImpresionColposcopia()+""+aux[37].toString());
                                            }
                                           if(aux[38]!=null){
                                                    if(("S").equals(aux[38]))
                                                            auxCervix.setFechaTomaColposcopia((Date)aux[29]);
                                            }
                                            if(aux[39]!=null){
                                                if(aux[39].equals("898101")){
                                                    auxCervix.setFechaConizacion((Date)aux[40]);
                                                }
                                                else if(aux[39].equals("S684020")){
                                                    auxCervix.setFechaHistero((Date)aux[40]);
                                                }
                                                else{
                                                    auxCervix.setFechaCrio((Date)aux[40]);
                                                }
                                            }
                                           if(aux[41]!=null){
                                                auxCervix.setResultadoBiopsia(""+aux[41]);
                                            }
                                            if(aux[42]!=null){
                                                auxCervix.setResultadoPatologia(""+aux[42]);
                                            }
                                            if(aux[43]!=null){
                                                auxCervix.setDescripcionPatologia(""+aux[43]);
                                            }
                                           auxCervix.setBdSaludTotal("NO");
                                           if(auxCervix.getNumeroContrato()!=null){
                                                       auxCervix.setBdSaludTotal("SI");
                                           }
                                                                            
                                                       resultList.add(auxCervix);
                                       }
                                       }
                           }catch(Exception e){
                               e.printStackTrace();
                           }
                           return resultList;
                       }
                    
                   });
           return pis;
          
        
       }
       
    /**
     * @param fechaInicial
     * @param fechaFinal
     * @return
     * @throws ModelException
     */
    public List<Object[]> getReporteEnvioEmail(Date fechaInicial, Date fechaFinal) throws ModelException {
        List resultList = null;

        String HORA_INICIAL = " 00:00";
        String HORA_FINAL = " 23:59";
        String fechaI = null;
        String fechaF = null;

        Date fechaCompara = new Date();
        if (fechaInicial != null && fechaFinal != null) {
            SimpleDateFormat dateFormat = new SimpleDateFormat("dd/MM/yyyy");

            fechaI = dateFormat.format(fechaInicial) + HORA_INICIAL;
            fechaF = dateFormat.format(fechaFinal) + HORA_FINAL;
        }

        fechaCompara = fechaInicial;
        try {
            if (fechaInicial != null && fechaFinal != null) {
                StringBuffer sb = new StringBuffer();
                sb.append(" SELECT hcennumero, hcenconsul, hcodfecregistr, hcocservicio, csvcnombre, hconclinica, cclcnombre, " +
                          " hceccorreoelec, hcectipo, hcecetapa, hcecerror, hcedfecreg, hcecusureg, hcedfecenv, hcecusuenv " + 
                          " from historia.chcorrelec " + 
                          " inner join historia.chconsulta on hcolnumero = hcenconsul " + 
                          " inner join clinico.cpclinica on cclncodigo = hconclinica " + 
                          " inner join clinico.cpservicio on csvccodigo = hcocservicio " + 
                          " where hcedfecreg between TO_DATE(:fechaI,'dd/MM/yyyy hh24:mi') and TO_DATE(:fechaF,'dd/MM/yyyy hh24:mi') ");
                Query sqlquery = 
                    this.getHibernateTemplate().getSessionFactory().getCurrentSession().createQuery(sb.toString());
                sqlquery.setParameter("fechaI", fechaI);
                sqlquery.setParameter("fechaF", fechaF);

                resultList = sqlquery.list();

                if (!resultList.isEmpty()) {
                    return resultList;
                }
            }
            return null;

        } catch (HibernateException e) {
            throw new ModelException("Error consultando Reporte Envio de Correos : " + e.getMessage(), e);
        } catch (Exception e) {
            throw new ModelException("Error consultando Reporte Envio de Correos : " + e.getMessage(), e);
        }

    }
    
    public List<Object[]> getReporteDiscapacidad(Date fechaInicial, Date fechaFinal) throws ModelException {
        List resultList = null;

        String HORA_INICIAL = " 00:00";
        String HORA_FINAL = " 23:59";
        String fechaI = null;
        String fechaF = null;

        Date fechaCompara = new Date();
        if (fechaInicial != null && fechaFinal != null) {
            SimpleDateFormat dateFormat = new SimpleDateFormat("dd/MM/yyyy");

            fechaI = dateFormat.format(fechaInicial) + HORA_INICIAL;
            fechaF = dateFormat.format(fechaFinal) + HORA_FINAL;
        }

        fechaCompara = fechaInicial;
        try {
            if (fechaInicial != null && fechaFinal != null) {
                StringBuffer sb = new StringBuffer();
                sb.append(" select chco.hconclinica CLINICA, to_char(chco.hcodfecregistr,'dd/mm/yyyy') FECHA_REGISTRO, chus.husetipoiden TIPO_IDENT,  ");
                sb.append(" chus.husanumeiden NUMERP_IDEN, chus.husdfechanacim, (extract(year from sysdate) - extract(year from chus.husdfechanacim) ) EDAD, ");
                sb.append(" chus.husesexo SEXO, chco.hcocservicio, cpse.csvcnombre, chex.hefcdiscaselec, case when chex.hefcdiscaselec = 'VI' then 'Visual'  ");
                sb.append(" when chex.hefcdiscaselec = 'AU' then 'Auditiva' when chex.hefcdiscaselec = 'MO' then 'Motriz'  ");
                sb.append(" when chex.hefcdiscaselec = 'CO' then 'Cogntivia' when chex.hefcdiscaselec = 'PS' then 'Psicosocial' ");
                sb.append(" when chex.hefcdiscaselec = 'MU' then 'Multiple' else 'No definida' end ");
                sb.append(" from historia.chconsulta chco, historia.chusuario chus, historia.chexamfisico chex, clinico.cpservicio cpse ");
                sb.append(" where chco.hcodfecregistr between TO_DATE(:fechaI, 'dd/MM/yyyy hh24:mi') AND TO_DATE(:fechaF, 'dd/MM/yyyy hh24:mi') ");
                sb.append(" and chus.huslnumero = chco.hcolusuario  ");
                sb.append(" and chex.heflconsulta = chco.hcolnumero and chex.hefcdiscapadid = 'S'  ");
                sb.append(" and cpse.csvccodigo = chco.hcocservicio ");
                
                Query sqlquery = 
                    this.getHibernateTemplate().getSessionFactory().getCurrentSession().createQuery(sb.toString());
                sqlquery.setParameter("fechaI", fechaI);
                sqlquery.setParameter("fechaF", fechaF);

                resultList = sqlquery.list();

                if (!resultList.isEmpty()) {
                    return resultList;
                }
            }
            return null;

        } catch (HibernateException e) {
            throw new ModelException("Error consultando Reporte Discapacidad : " + e.getMessage(), e);
        } catch (Exception e) {
            throw new ModelException("Error consultando Reporte Discapacidad : " + e.getMessage(), e);
        }

    }
    
    
    public List<Object[]> getReporteIdentidadGenero(Date fechaInicial, Date fechaFinal) throws ModelException {
        List resultList = null;

        String HORA_INICIAL = " 00:00";
        String HORA_FINAL = " 23:59";
        String fechaI = null;
        String fechaF = null;

        Date fechaCompara = new Date();
        if (fechaInicial != null && fechaFinal != null) {
            SimpleDateFormat dateFormat = new SimpleDateFormat("dd/MM/yyyy");

            fechaI = dateFormat.format(fechaInicial) + HORA_INICIAL;
            fechaF = dateFormat.format(fechaFinal) + HORA_FINAL;
        }

        fechaCompara = fechaInicial;
        try {
            if (fechaInicial != null && fechaFinal != null) {
                StringBuffer sb = new StringBuffer();
                sb.append(" select * from (  ");
                sb.append(" select unique cnco.cconclinic CLINICA,cpcl.cclcnombre NOMBRE_CLINICA,  chus.husdfechanacim FECHA_NACIMIENTO, ");
                sb.append("  chus.huscidengene IDENTIDAD_GENERO,cppa.cpcdescrip IDEN_GENERO, chus.husanumeiden NUMERO_IDEN, cnco.ccocservic SERVICIO, ");
                sb.append(" cpse.csvcnombre NOMBRE_SERVICIO, chco.hcodfecregistr FECHA_CONSULTA, (EXTRACT(YEAR FROM chco.HCODFECREGISTR)- ");
                sb.append("  EXTRACT(YEAR FROM chus.HUSDFECHANACIM)) EDAD, cpco.ccncdescri PAGADOR ");
                sb.append(" from clinico.Cnconsclin cnco, historia.chusuario chus, clinico.Cpservicio cpse, historia.Chconsulta chco, ");
                sb.append(" clinico.Cpclinica cpcl, clinico.Cpparametr cppa, CLINICO.cpcontrato cpco ");
                sb.append(" where cppa.cpccampo = 'identidadgen' and cppa.cpcvalor = chus.huscidengene and chco.hcolnumero = cnco.cconnumero  ");
                sb.append(" and chus.huscidengene is not null and chus.huslnumero = cnco.ccolusuario ");
                sb.append(" and trunc(cnco.ccodfeccon) between TO_DATE(:fechaI, 'dd/MM/yyyy hh24:mi') AND TO_DATE(:fechaF, 'dd/MM/yyyy hh24:mi')  ");
                sb.append(" and cpse.csvccodigo = cnco.ccocservic and cpcl.cclncodigo = cnco.cconclinic ");
                sb.append(" and cpco.ccnnnumero = cnco.cconcontra and chus.huscidengene not in ('M','F') and chus.huscidengene is not null ");
                sb.append("  ) sub1 order by 9 asc ");
                Query sqlquery = 
                    this.getHibernateTemplate().getSessionFactory().getCurrentSession().createQuery(sb.toString());
                sqlquery.setParameter("fechaI", fechaI);
                sqlquery.setParameter("fechaF", fechaF);

                resultList = sqlquery.list();

                if (!resultList.isEmpty()) {
                    return resultList;
                }
            }
            return null;

        } catch (HibernateException e) {
            throw new ModelException("Error consultando Reporte Identidad de genero : " + e.getMessage(), e);
        } catch (Exception e) {
            throw new ModelException("Error consultando Reporte Identidad de genero : " + e.getMessage(), e);
        }

    }
    
    public List<Object[]> getReporteITS(Date fechaInicial, Date fechaFinal) throws ModelException {
        List resultList = null;

        String HORA_INICIAL = " 00:00";
        String HORA_FINAL = " 23:59";
        String fechaI = null;
        String fechaF = null;

        Date fechaCompara = new Date();
        if (fechaInicial != null && fechaFinal != null) {
            SimpleDateFormat dateFormat = new SimpleDateFormat("dd/MM/yyyy");

            fechaI = dateFormat.format(fechaInicial) + HORA_INICIAL;
            fechaF = dateFormat.format(fechaFinal) + HORA_FINAL;
        }

        fechaCompara = fechaInicial;
        try {
            if (fechaInicial != null && fechaFinal != null) {
                StringBuffer sb = new StringBuffer();                
                sb.append(" select to_char(hcodfecregistr,'dd/mm/yyyy') fecha, hconclinica clinica, cclcnombre nombre_clinica, hcolusuario ");
                sb.append("    usuario, to_number(to_char(hcodfecregistr,'YYYY')) - to_number(to_char(husdfechanacim,'YYYY')) - case when  ");
                sb.append("    to_char(hcodfecregistr,'MMDD') < to_char(husdfechanacim,'MMDD') then 1 else 0 end edad, husesexo sexo, hcocservicio ");
                sb.append("    servicio, csvcnombre nombre_servicio, hidcdiagprin diag_principal, pr.cdccdescri nombre_diag_principal, hidcdiagrela1 ");
                sb.append("    diag_relacionado_1, d1.cdccdescri nombre_diag_relacionado_1, hidcdiagrela2 diag_relacionado_2, d2.cdccdescri ");
                sb.append("    nombre_diag_relacionado_2, hidcdiagrela3 diag_relacionado_3, d3.cdccdescri nombre_diag_relacionado_3 ");
                sb.append(" from historia.chconsulta ");
                sb.append(" inner join clinico.cpclinica on cclncodigo = hconclinica ");
                sb.append(" inner join clinico.cpservicio on csvccodigo = hcocservicio ");
                sb.append(" inner join historia.chusuario on huslnumero = hcolusuario ");
                sb.append(" inner join historia.chimprdiag on hidlconsulta = hcolnumero ");
                sb.append(" left join clinico.crdgncie10 pr on pr.cdcccodigo = hidcdiagprin ");
                sb.append(" left join clinico.crdgncie10 d1 on d1.cdcccodigo = hidcdiagrela1 ");
                sb.append(" left join clinico.crdgncie10 d2 on d2.cdcccodigo = hidcdiagrela2 ");
                sb.append(" left join clinico.crdgncie10 d3 on d3.cdcccodigo = hidcdiagrela3 ");
                sb.append(" where trunc(hcodfecregistr) between TO_DATE(:fechaI, 'dd/MM/yyyy hh24:mi') AND TO_DATE(:fechaF, 'dd/MM/yyyy hh24:mi') ");
                sb.append(" and (hidcdiagprin in ('A500','A501','A502','A503','A504','A505','A506','A507','A509','A510','A511','A512','A513','A514', ");
                sb.append(" 'A515','A519','A520','A521','A522','A523','A527','A528','A529','A530','A539','A540','A541','A542','A543','A544','A545', ");
                sb.append(" 'A546','A548','A549','A560','A561','A562','A563','A564','A568','A590','A598','A599','A600','A601','A609','A630','A638', ");
                sb.append(" 'A740','A748','A749','B000','B001','B002','B003','B004','B005','B007','B008','B009','B160','B161','B162','B169','B170', ");
                sb.append(" 'B171','B180','B181','B182','B188','B189','B200','B201','B202','B203','B204','B205','B206','B207','B208','B209','B210', ");
                sb.append(" 'B211','B212','B213','B217','B218','B219','B220','B221','B222','B227','B230','B231','B232','B238','C460','C461','C462', ");
                sb.append(" 'C463','C467','C468','C469') or hidcdiagprin like 'A55%' or hidcdiagprin like 'A57%' or hidcdiagprin like 'A58%'  ");
                sb.append(" or hidcdiagprin like 'A64%' or hidcdiagprin like 'A65%' or hidcdiagprin like 'B24%' or  ");
                sb.append(" hidcdiagrela1 in ('A500','A501','A502','A503','A504','A505','A506','A507','A509','A510','A511','A512','A513','A514','A515', ");
                sb.append(" 'A519','A520','A521','A522','A523','A527','A528','A529','A530','A539','A540','A541','A542','A543','A544','A545','A546', ");
                sb.append(" 'A548','A549','A560','A561','A562','A563','A564','A568','A590','A598','A599','A600','A601','A609','A630','A638','A740', ");
                sb.append(" 'A748','A749','B000','B001','B002','B003','B004','B005','B007','B008','B009','B160','B161','B162','B169','B170','B171', ");
                sb.append(" 'B180','B181','B182','B188','B189','B200','B201','B202','B203','B204','B205','B206','B207','B208','B209','B210','B211', ");
                sb.append(" 'B212','B213','B217','B218','B219','B220','B221','B222','B227','B230','B231','B232','B238','C460','C461','C462','C463', ");
                sb.append(" 'C467','C468','C469') or hidcdiagrela1 like 'A55%' or hidcdiagrela1 like 'A57%' or hidcdiagrela1 like 'A58%'  ");
                sb.append(" or hidcdiagrela1 like 'A64%' or hidcdiagrela1 like 'A65%' or hidcdiagrela1 like 'B24%' or  ");
                sb.append(" hidcdiagrela2 in  ");
                sb.append(" ('A500','A501','A502','A503','A504','A505','A506','A507','A509','A510','A511','A512','A513','A514','A515', ");                
                sb.append(" 'A519','A520','A521','A522','A523','A527','A528','A529','A530','A539','A540','A541','A542','A543','A544','A545','A546', ");
                sb.append(" 'A548','A549','A560','A561','A562','A563','A564','A568','A590','A598','A599','A600','A601','A609','A630','A638','A740', ");
                sb.append(" 'A748','A749','B000','B001','B002','B003','B004','B005','B007','B008','B009','B160','B161','B162','B169','B170','B171', ");
                sb.append(" 'B180','B181','B182','B188','B189','B200','B201','B202','B203','B204','B205','B206','B207','B208','B209','B210','B211', ");
                sb.append(" 'B212','B213','B217','B218','B219','B220','B221','B222','B227','B230','B231','B232','B238','C460','C461','C462','C463', ");
                sb.append(" 'C467','C468','C469') or hidcdiagrela2 like 'A55%' or hidcdiagrela2 like 'A57%' or hidcdiagrela2 like 'A58%'  ");
                sb.append(" or hidcdiagrela2 like 'A64%' or hidcdiagrela2 like 'A65%' or hidcdiagrela2 like 'B24%' or  ");
                sb.append(" hidcdiagrela3 in  ");
                sb.append(" ('A500','A501','A502','A503','A504','A505','A506','A507','A509','A510','A511','A512','A513','A514','A515', ");                
                sb.append(" 'A519','A520','A521','A522','A523','A527','A528','A529','A530','A539','A540','A541','A542','A543','A544','A545','A546', ");
                sb.append(" 'A548','A549','A560','A561','A562','A563','A564','A568','A590','A598','A599','A600','A601','A609','A630','A638','A740', ");
                sb.append(" 'A748','A749','B000','B001','B002','B003','B004','B005','B007','B008','B009','B160','B161','B162','B169','B170','B171', ");
                sb.append(" 'B180','B181','B182','B188','B189','B200','B201','B202','B203','B204','B205','B206','B207','B208','B209','B210','B211', ");
                sb.append(" 'B212','B213','B217','B218','B219','B220','B221','B222','B227','B230','B231','B232','B238','C460','C461','C462','C463', ");
                sb.append(" 'C467','C468','C469') or hidcdiagrela3 like 'A55%' or hidcdiagrela3 like 'A57%' or hidcdiagrela3 like 'A58%'  ");
                sb.append(" or hidcdiagrela3 like 'A64%' or hidcdiagrela3 like 'A65%' or hidcdiagrela3 like 'B24%') ");
                Query sqlquery = 
                    this.getHibernateTemplate().getSessionFactory().getCurrentSession().createQuery(sb.toString());
                sqlquery.setParameter("fechaI", fechaI);
                sqlquery.setParameter("fechaF", fechaF);

                resultList = sqlquery.list();

                if (!resultList.isEmpty()) {
                    return resultList;
                }
            }
            return null;

        } catch (HibernateException e) {
            throw new ModelException("Error consultando Reporte ITS : " + e.getMessage(), e);
        } catch (Exception e) {
            throw new ModelException("Error consultando Reporte ITS : " + e.getMessage(), e);
        }
    }
    
    public List<Object[]> getReporteVBG(Date fechaInicial, Date fechaFinal) throws ModelException {
        List resultList = null;

        String HORA_INICIAL = " 00:00";
        String HORA_FINAL = " 23:59";
        String fechaI = null;
        String fechaF = null;

        Date fechaCompara = new Date();
        if (fechaInicial != null && fechaFinal != null) {
            SimpleDateFormat dateFormat = new SimpleDateFormat("dd/MM/yyyy");

            fechaI = dateFormat.format(fechaInicial) + HORA_INICIAL;
            fechaF = dateFormat.format(fechaFinal) + HORA_FINAL;
        }

        fechaCompara = fechaInicial;
        try {
            if (fechaInicial != null && fechaFinal != null) {
                StringBuffer sb = new StringBuffer();                
                sb.append(" select chco.hcodfecregistr FECHA_ATENCION, cnco.ccocservic, cpse.csvcnombre,chus.huslnumero NUMERO_USUARIO, chco.hconclinica CLINICA,  ");
                sb.append(" cpcl.cclcnombre NOMBRE_CLINICA, chvi.hvieviofisica VIOLENCIA_FISICA, (case chvi.hvintiemfisi when 1 THEN 'Menor de 24 Horas'  ");
                sb.append(" when 2 THEN 'Entre 24 y 72 Horas' when 3 THEN 'Entre 72 y 120 Horas' when 4 THEN 'Entre 5 d�as y un ano' when 5  ");
                sb.append(" THEN 'Mayor a un ano' ELSE '' END )TIEMPO_VIOLENCIA_FISICA, chvi.hvieviopsicol VIOLENCIA_PSICOLOGICA,(case chvi.hvintiempsic when 1  ");
                sb.append(" THEN 'Menor de 24 Horas' when 2 THEN 'Entre 24 y 72 Horas' when 3 THEN 'Entre 72 y 120 Horas' when 4 THEN 'Entre 5 d�as y un ano'  ");
                sb.append(" when 5 THEN 'Mayor a un ano' ELSE '' END ) TIEMPO_VIOLENCIA_PSICOLOGICA, chvi.hvieviosexual VIOLENCIA_SEXUAL,(case chvi.hvintiemsexu  ");
                sb.append(" when 1 THEN 'Menor de 24 Horas' when 2 THEN 'Entre 24 y 72 Horas' when 3 THEN 'Entre 72 y 120 Horas' when 4 THEN 'Entre 5 d�as y un ano'  ");
                sb.append(" when 5 THEN 'Mayor a un ano' ELSE '' END ) TIEMPO_VIOLENCIA_SEXUAL, chvi.hvieviocoerci COERCION_REPORDUCTIVA,(case  chvi.hvintiemcoer  ");
                sb.append(" when 1 THEN 'Menor de 24 Horas' when 2 THEN 'Entre 24 y 72 Horas' when 3 THEN 'Entre 72 y 120 Horas' when 4 THEN 'Entre 5 d�as y un ano'  ");
                sb.append(" when 5 THEN 'Mayor a un ano' ELSE '' END )TIEMPO_VIOLENCIA_COERCION, chvi.hvievioeconom VIOLENCIA_ECONOMICA,(case  chvi.hvintiemecon  ");
                sb.append(" when 1 THEN 'Menor de 24 Horas' when 2 THEN 'Entre 24 y 72 Horas' when 3 THEN 'Entre 72 y 120 Horas' when 4 THEN 'Entre 5 d�as y un ano'  ");
                sb.append(" when 5 THEN 'Mayor a un ano' ELSE '' END )TIEMPO_VIOLENCIA_ECONOMICA, chvr.hvrcdescripcio REMITIDO_A, chvi.hvilcualremisi CUAL_REMISION,  ");
                sb.append(" cnco.cconcontra CONTRATO, chus.husesexo SEXO, chus.husdfechanacim FECHA_NACIMIENTO, EXTRACT(YEAR FROM sysdate)- ");
                sb.append(" EXTRACT(YEAR FROM chus.HUSDFECHANACIM)Edad ");
                sb.append(" from historia.chviolencia chvi  ");
                sb.append(" left join historia.chconsulta chco on chco.HCOLNUMERO = chvi.HVILCONSULTA  ");
                sb.append(" left join clinico.cnconsclin cnco ON  cnco.CCONNUMERO =  chco.HCOLNUMERO ");
                sb.append(" left join historia.chusuario chus on chco.HCOLUSUARIO = chus.HUSLNUMERO  ");
                sb.append(" left join clinico.cpclinica cpcl  on chco.HCONCLINICA = cpcl.CCLNCODIGO ");
                sb.append(" left join historia.Chviolenremi  chvr ON chvi.hvicremitidoa = chvr.hvrccodigo ");
                sb.append(" left join clinico.cpservicio cpse ON cpse.csvccodigo = cnco.ccocservic ");
                sb.append(" where chvi.HVIESUFREVIOL = 'S' ");
                sb.append(" and chco.HCODFECREGISTR between TO_DATE(:fechaI, 'dd/MM/yyyy hh24:mi') AND TO_DATE(:fechaF, 'dd/MM/yyyy hh24:mi') ");                
                Query sqlquery = 
                    this.getHibernateTemplate().getSessionFactory().getCurrentSession().createQuery(sb.toString());
                sqlquery.setParameter("fechaI", fechaI);
                sqlquery.setParameter("fechaF", fechaF);

                resultList = sqlquery.list();

                if (!resultList.isEmpty()) {
                    return resultList;
                }
            }
            return null;

        } catch (HibernateException e) {
            throw new ModelException("Error consultando Reporte VBG : " + e.getMessage(), e);
        } catch (Exception e) {
            throw new ModelException("Error consultando Reporte VBG : " + e.getMessage(), e);
        }

    }
    
    public List<Object[]> getReporteVBGDiagnosticos(Date fechaInicial, Date fechaFinal) throws ModelException {
        List resultList = null;

        String HORA_INICIAL = " 00:00";
        String HORA_FINAL = " 23:59";
        String fechaI = null;
        String fechaF = null;

        Date fechaCompara = new Date();
        if (fechaInicial != null && fechaFinal != null) {
            SimpleDateFormat dateFormat = new SimpleDateFormat("dd/MM/yyyy");

            fechaI = dateFormat.format(fechaInicial) + HORA_INICIAL;
            fechaF = dateFormat.format(fechaFinal) + HORA_FINAL;
        }

        fechaCompara = fechaInicial;
        try {
            if (fechaInicial != null && fechaFinal != null) {
                StringBuffer sb = new StringBuffer();                
                sb.append(" select to_char(hcodfecregistr,'dd/mm/yyyy') fecha, hconclinica clinica, cclcnombre nombre_clinica, hcolusuario   ");
                sb.append(" usuario, to_number(to_char(hcodfecregistr,'YYYY')) - to_number(to_char(husdfechanacim,'YYYY')) - case when   ");
                sb.append(" to_char(hcodfecregistr,'MMDD') < to_char(husdfechanacim,'MMDD') then 1 else 0 end edad, husesexo sexo, hcocservicio   ");
                sb.append(" servicio, csvcnombre nombre_servicio, hidcdiagprin diag_principal, pr.cdccdescri nombre_diag_principal, hidcdiagrela1   ");
                sb.append(" diag_relacionado_1, d1.cdccdescri nombre_diag_relacionado_1, hidcdiagrela2 diag_relacionado_2, d2.cdccdescri  ");
                sb.append(" nombre_diag_relacionado_2, hidcdiagrela3 diag_relacionado_3, d3.cdccdescri nombre_diag_relacionado_3  ");
                sb.append(" from historia.chconsulta  ");
                sb.append(" inner join clinico.cpclinica on cclncodigo = hconclinica  ");
                sb.append("  inner join clinico.cpservicio on csvccodigo = hcocservicio ");
                sb.append("  inner join historia.chusuario on huslnumero = hcolusuario ");
                sb.append(" inner join historia.chimprdiag on hidlconsulta = hcolnumero  ");
                sb.append(" left join clinico.crdgncie10 pr on pr.cdcccodigo = hidcdiagprin  ");
                sb.append(" left join clinico.crdgncie10 d1 on d1.cdcccodigo = hidcdiagrela1  ");
                sb.append(" left join clinico.crdgncie10 d2 on d2.cdcccodigo = hidcdiagrela2  ");
                sb.append(" left join clinico.crdgncie10 d3 on d3.cdcccodigo = hidcdiagrela3  ");
                sb.append(" where hcodfecregistr between TO_DATE(:fechaI, 'dd/MM/yyyy hh24:mi') AND TO_DATE(:fechaF, 'dd/MM/yyyy hh24:mi')  ");
                sb.append(" and (hidcdiagprin in ('T740','T741','T742','T743','T748','T749','Y050','Y051','Y052','Y053','Y054','Y055','Y056  ");
                sb.append(" ','Y057','Y058','Y059','Y060','Y061','Y062','Y068','Y069','Y070','Y071','Y072','Y073','Y078','Y079','Y080') or   ");
                sb.append(" hidcdiagrela1 in ('T740','T741','T742','T743','T748','T749','Y050','Y051','Y052','Y053','Y054','Y055','Y056  ");
                sb.append(" ','Y057','Y058','Y059','Y060','Y061','Y062','Y068','Y069','Y070','Y071','Y072','Y073','Y078','Y079','Y080') or   ");
                sb.append(" hidcdiagrela2 in ('T740','T741','T742','T743','T748','T749','Y050','Y051','Y052','Y053','Y054','Y055','Y056  ");
                sb.append(" ','Y057','Y058','Y059','Y060','Y061','Y062','Y068','Y069','Y070','Y071','Y072','Y073','Y078','Y079','Y080') or   ");
                sb.append(" hidcdiagrela3 in ('T740','T741','T742','T743','T748','T749','Y050','Y051','Y052','Y053','Y054','Y055','Y056  ");
                sb.append(" ','Y057','Y058','Y059','Y060','Y061','Y062','Y068','Y069','Y070','Y071','Y072','Y073','Y078','Y079','Y080'))  ");                
                Query sqlquery = 
                    this.getHibernateTemplate().getSessionFactory().getCurrentSession().createQuery(sb.toString());
                sqlquery.setParameter("fechaI", fechaI);
                sqlquery.setParameter("fechaF", fechaF);

                resultList = sqlquery.list();

                if (!resultList.isEmpty()) {
                    return resultList;
                }
            }
            return null;

        } catch (HibernateException e) {
            throw new ModelException("Error consultando Reporte VBG diagnosticos : " + e.getMessage(), e);
        } catch (Exception e) {
            throw new ModelException("Error consultando Reporte VBG diagnosticos : " + e.getMessage(), e);
        }

    }
    
    public List<Object[]> getReportePrep(Date fechaInicial, Date fechaFinal) throws ModelException {
        List resultList = null;

        String HORA_INICIAL = " 00:00";
        String HORA_FINAL = " 23:59";
        String fechaI = null;
        String fechaF = null;

        Date fechaCompara = new Date();
        if (fechaInicial != null && fechaFinal != null) {
            SimpleDateFormat dateFormat = new SimpleDateFormat("dd/MM/yyyy");

            fechaI = dateFormat.format(fechaInicial) + HORA_INICIAL;
            fechaF = dateFormat.format(fechaFinal) + HORA_FINAL;
        }

        fechaCompara = fechaInicial;
        try {
            if (fechaInicial != null && fechaFinal != null) {
                StringBuffer sb = new StringBuffer();                
                sb.append(" select to_char(cfsdfecreg,'dd/mm/yyyy') fecha_factura, cfsnclinic clinica, cclcnombre nombre_clinica, ");
                sb.append(" cdfcservic servicio, csvcnombre nombre_servicio, husetipoiden tipo_id, husanumeiden numero_id,  ");
                sb.append(" to_number(to_char(cfsdfecreg,'YYYY')) - to_number(to_char(husdfechanacim,'YYYY')) ");
                sb.append(" - case when to_char(cfsdfecreg,'MMDD') < to_char(husdfechanacim,'MMDD') then 1 else 0 end edad ");
                sb.append(" from clinico.ccfactsap ");
                sb.append(" inner join clinico.cpclinica on cclncodigo = cfsnclinic ");
                sb.append(" inner join historia.chusuario on huslnumero = cfslusuario ");
                sb.append(" inner join clinico.ccdetasap on cdfnnumero = cfsnnumero ");
                sb.append(" inner join clinico.cpservicio on csvccodigo = cdfcservic ");
                sb.append(" where cfsdfecreg between TO_DATE(:fechaI, 'dd/MM/yyyy hh24:mi') AND TO_DATE(:fechaF, 'dd/MM/yyyy hh24:mi') and cfsnestado = 1 ");
                sb.append(" and cdfcservic in ('PQ018','PQ019','PQ020','PQ021','PQ022','PQ028','PQ029','PQ031','PQ032','PQ033','PQ034','1000001436') ");                
                Query sqlquery = 
                    this.getHibernateTemplate().getSessionFactory().getCurrentSession().createQuery(sb.toString());
                sqlquery.setParameter("fechaI", fechaI);
                sqlquery.setParameter("fechaF", fechaF);

                resultList = sqlquery.list();

                if (!resultList.isEmpty()) {
                    return resultList;
                }
            }
            return null;

        } catch (HibernateException e) {
            throw new ModelException("Error consultando Reporte prep : " + e.getMessage(), e);
        } catch (Exception e) {
            throw new ModelException("Error consultando Reporte prep : " + e.getMessage(), e);
        }

    }
       
    public List<Object[]> getReporteVPHHC(Date fechaInicial, Date fechaFinal) throws ModelException {
        List resultList = null;

        String HORA_INICIAL = " 00:00";
        String HORA_FINAL = " 23:59";
        String fechaI = null;
        String fechaF = null;

        Date fechaCompara = new Date();
        if (fechaInicial != null && fechaFinal != null) {
            SimpleDateFormat dateFormat = new SimpleDateFormat("dd/MM/yyyy");

            fechaI = dateFormat.format(fechaInicial) + HORA_INICIAL;
            fechaF = dateFormat.format(fechaFinal) + HORA_FINAL;
        }

        fechaCompara = fechaInicial;
        try {
            if (fechaInicial != null && fechaFinal != null) {
                StringBuffer sb = new StringBuffer();    
                sb.append(" select ci.ccictipide tipo_id, ci.ccianumide numero_id, ci.ccintiphis tipo_historia, th.hthcdescripcio nombre_tipo_historia,  ");                
                sb.append(" ci.ccinclinic clinica, cl.cclcnombre nombre_clinica, tm.ctmdfectom fecha_toma, ci.ccinedad edad, ci.ccicasegur aseguradora,  "); 
                sb.append(" ci.ccicidengen identidad_genero, ci.ccicvulnera vulnerabilidad, tm.ctmcesquem esquema_citologia, tm.CTMCOTRESQ otro_esquema_citologia,  "); 
                sb.append(" tm.CTMCPNINGU procedimiento_ninguno, tm.CTMCPCAUTE cauterizacion, tm.CTMDPCAUTE fecha_cauterizacion, tm.CTMCPHISTE histerectomia,  "); 
                sb.append(" tm.CTMDPHISTE fecha_histerectomia, tm.CTMCPCONIZ conizacion, tm.CTMDPCONIZ fecha_conizacion, tm.CTMCPRADIO radioterapia,  "); 
                sb.append(" tm.CTMDPRADIO fecha_radioterapia, tm.CTMCPBIOPS biopsia, tm.CTMDPBIOPS fecha_biopsia, tm.CTMCPCRIOT crioterapia, tm.CTMDPCRIOT  "); 
                sb.append(" fecha_crioterapia, tm.CTMCPATA ATA, tm.CTMDPATA fecha_ATA, tm.CTMCPOTRO otro_Procedimiento, tm.CTMDPOTRO fecha_otroProcedimiento, "); 
                sb.append(" tm.CTMCPDOTRO descripcion_otro, tm.CTMCPVAPOR vaporizacion, tm.CTMDPVAPOR fecha_vaporizacion, tm.CTMCPHORMO hormonal, tm.CTMDPHORMO  "); 
                sb.append(" fecha_hormonal, tm.CTMCTIPIFI Tipificacion, tm.CTMDTIPIFI fecha_tipificacion, tm.CTMCPCOLPO colposcopia, tm.CTMDPCOLPO fecha_colposcopia, "); 
                sb.append(" tm.CTMCESQVPH esquema_vph, tm.CTMCOTRESQVPH otro_esquema_vph, vp.CCVDFECLEC, vp.CCVCNUMTAR, vp.CCVCGENONEG, vp.CCVCGENOTIP, "); 
                sb.append(" vp.CCVCGT16, vp.CCVCGT18,  vp.CCVCGT31, vp.CCVCGT45, vp.CCVCGT51, vp.CCVCGT52, vp.CCVCGT3858, vp.CCVCGT353968, vp.CCVCGT565966,  "); 
                sb.append(" vp.CCVCCONDUC, vp.CCVCINTERPRE, co.hcocservicio, tm.ctmccomvph completo_esquema_vph, tm.ctmnnudoad numero_dosis_admin, "); 
                sb.append(" husezonareside zona_residencia, cancontra contrato, ccncdescri nombre_contrato  "); 
                sb.append(" FROM clinico.cncitologi ci "); 
                sb.append(" inner join historia.chusuario on huslnumero = ccilusuario "); 
                sb.append(" left join historia.Chtipohistor th on th.hthncodigo = ci.ccintiphis "); 
                sb.append(" left join clinico.cpclinica cl on cl.cclncodigo = ci.ccinclinic "); 
                sb.append(" left join clinico.cncitotoma tm on tm.ctmnconsec = ci.ccinconsec "); 
                sb.append(" left join clinico.cncitovphlect vp on vp.ccvnconsec = ci.ccinconsec "); 
                sb.append(" left join historia.Chconsulta co on co.hcolnumero = ci.ccilconcli  "); 
                sb.append(" left join clinico.cfadmision on cannumero = ccinnumdoc "); 
                sb.append(" left join clinico.cpcontrato on ccnnclinic = canclinic and ccnnnumero = cancontra "); 
                sb.append(" where ci.ccidfeccit between TO_DATE(:fechaI, 'dd/MM/yyyy hh24:mi') AND TO_DATE(:fechaF, 'dd/MM/yyyy hh24:mi') ");                 
                Query sqlquery = 
                    this.getHibernateTemplate().getSessionFactory().getCurrentSession().createQuery(sb.toString());
                sqlquery.setParameter("fechaI", fechaI);
                sqlquery.setParameter("fechaF", fechaF);

                resultList = sqlquery.list();

                if (!resultList.isEmpty()) {
                    return resultList;
                }
            }
            return null;

        } catch (HibernateException e) {
            throw new ModelException("Error consultando Reporte VPH HC : " + e.getMessage(), e);
        } catch (Exception e) {
            throw new ModelException("Error consultando Reporte VPH HC : " + e.getMessage(), e);
        }

    }
    
    public List<Object[]> getReporteConflictoArmado(Date fechaInicial, Date fechaFinal) throws ModelException {
        List resultList = null;

        String HORA_INICIAL = " 00:00";
        String HORA_FINAL = " 23:59";
        String fechaI = null;
        String fechaF = null;

        Date fechaCompara = new Date();
        if (fechaInicial != null && fechaFinal != null) {
            SimpleDateFormat dateFormat = new SimpleDateFormat("dd/MM/yyyy");

            fechaI = dateFormat.format(fechaInicial) + HORA_INICIAL;
            fechaF = dateFormat.format(fechaFinal) + HORA_FINAL;
        }

        fechaCompara = fechaInicial;
        try {
            if (fechaInicial != null && fechaFinal != null) {
                StringBuffer sb = new StringBuffer();    
                sb.append(" select distinct fecha_atencion, usuario, tipo_id, numero_id, servicio, nombre_servicio, clinica, nombre_clinica,  ");  
                sb.append(" enfermedad_actual, motivo_consulta from ( "); 
                sb.append(" select to_char(hcodfecregistr,'dd/mm/yyyy') fecha_atencion, hcolusuario usuario, husetipoiden tipo_id, husanumeiden numero_id, "); 
                sb.append(" hcocservicio servicio, csvcnombre nombre_servicio, hconclinica clinica, cclcnombre nombre_clinica,  "); 
                sb.append(" DBMS_LOB.substr(HMCTENFERACTAL,4000) enfermedad_actual, DBMS_LOB.substr(hmctdescripcio,4000) motivo_consulta "); 
                sb.append(" from historia.chconsulta "); 
                sb.append(" inner join historia.chmotivocons on hmclconsulta = hcolnumero "); 
                sb.append(" inner join historia.chusuario on huslnumero = hcolusuario "); 
                sb.append(" inner join clinico.cpservicio on csvccodigo = hcocservicio "); 
                sb.append(" inner join clinico.cpclinica on cclncodigo = hconclinica "); 
                sb.append(" where trunc(hcodfecregistr) between TO_DATE(:fechaI, 'dd/MM/yyyy hh24:mi') AND TO_DATE(:fechaF, 'dd/MM/yyyy hh24:mi') and UPPER(HMCTENFERACTAL) like '%ARMADO%'  "); 
                sb.append(" and UPPER(HMCTENFERACTAL) like '%CONFLICTO%' "); 
                sb.append(" union all "); 
                sb.append(" select to_char(hcodfecregistr,'dd/mm/yyyy') fecha_atencion, hcolusuario usuario, husetipoiden tipo_id, husanumeiden numero_id, "); 
                sb.append(" hcocservicio servicio, csvcnombre nombre_servicio, hconclinica clinica, cclcnombre nombre_clinica,  "); 
                sb.append(" DBMS_LOB.substr(HMCTENFERACTAL,4000) enfermedad_actual, DBMS_LOB.substr(hmctdescripcio,4000) motivo_consulta "); 
                sb.append(" from historia.chconsulta "); 
                sb.append(" inner join historia.chmotivocons on hmclconsulta = hcolnumero "); 
                sb.append(" inner join historia.chusuario on huslnumero = hcolusuario "); 
                sb.append(" inner join clinico.cpservicio on csvccodigo = hcocservicio "); 
                sb.append(" inner join clinico.cpclinica on cclncodigo = hconclinica "); 
                sb.append(" where hcodfecregistr between TO_DATE(:fechaI, 'dd/MM/yyyy hh24:mi') AND TO_DATE(:fechaF, 'dd/MM/yyyy hh24:mi') and UPPER(HMCTDESCRIPCIO) like '%ARMADO%'  "); 
                sb.append(" and UPPER(HMCTDESCRIPCIO) like '%CONFLICTO%') ");                 
                Query sqlquery = 
                    this.getHibernateTemplate().getSessionFactory().getCurrentSession().createQuery(sb.toString());
                sqlquery.setParameter("fechaI", fechaI);
                sqlquery.setParameter("fechaF", fechaF);

                resultList = sqlquery.list();

                if (!resultList.isEmpty()) {
                    return resultList;
                }
            }
            return null;

        } catch (HibernateException e) {
            throw new ModelException("Error consultando Reporte conflicto armado : " + e.getMessage(), e);
        } catch (Exception e) {
            throw new ModelException("Error consultando Reporte conflicto armado : " + e.getMessage(), e);
        }

    }
    
    public List<Object[]> getReporteColposcopia(Date fechaInicial, Date fechaFinal) throws ModelException {
        List resultList = null;

        String HORA_INICIAL = " 00:00";
        String HORA_FINAL = " 23:59";
        String fechaI = null;
        String fechaF = null;
        String wanoini = null;

        Date fechaCompara = new Date();
        if (fechaInicial != null && fechaFinal != null) {
            SimpleDateFormat dateFormat = new SimpleDateFormat("dd/MM/yyyy");

            fechaI = dateFormat.format(fechaInicial) + HORA_INICIAL;
            fechaF = dateFormat.format(fechaFinal) + HORA_FINAL;
            
        }

        fechaCompara = fechaInicial;
        try {
            if (fechaInicial != null && fechaFinal != null) {
                StringBuffer sb = new StringBuffer();    
                sb.append(" select to_char(hcodfecregistr,'dd/mm/yyyy') fecha_colposcopia, hcolusuario usuario_colposcopia, hconclinica clinica_colposcopia, ");  
                sb.append(" cclcnombre nombre_clinica_colposcopia, hcocservicio servicio_colposcopia, csvcnombre nombre_servicio_colposcopia,  ");
                sb.append(" fecha_patologia, usuario_patologia, clinica_patologia, nombre_clinica_patologia, servicio_patologia, nombre_servicio_patologia, ");
                sb.append(" trae_patologia, tipo_patologia, resultado_patologia, desc_resultado_patologia, fecha_conizacion, usuario_conizacion,  ");
                sb.append(" clinica_conizacion, nombre_clinica_conizacion, servicio_conizacion, nombre_servicio_conizacion, fecha_citologia ");
                sb.append(" from historia.chconsulta ");
                sb.append(" inner join clinico.cpclinica on cclncodigo = hconclinica ");
                sb.append(" inner join clinico.cpservicio on csvccodigo = hcocservicio ");
                sb.append(" left join (select to_char(hcodfecregistr,'dd/mm/yyyy') fecha_patologia, hcolusuario usuario_patologia, hconclinica clinica_patologia, ");
                sb.append(" cclcnombre nombre_clinica_patologia, hcocservicio servicio_patologia, csvcnombre nombre_servicio_patologia,  ");
                sb.append(" hmcctrapatol trae_patologia, case hmcctippatol when 'PR' then 'Prostata' when 'PE' then 'Pene' when 'PI' then  ");
                sb.append(" 'Piel' when 'TI' then 'Tiroides' when 'GN' then 'Ganglio' when 'CX' then 'C�rvix' when 'EN' then 'Endometrio'  ");
                sb.append(" when 'VU' then 'Vulva' when 'MA' then 'Mama' else hmcctippatol end tipo_patologia, hmccrespatol resultado_patologia,  ");
                sb.append(" hmccdesres desc_resultado_patologia   ");
                sb.append(" from historia.chconsulta ");
                sb.append(" inner join clinico.cpclinica on cclncodigo = hconclinica ");
                sb.append(" inner join clinico.cpservicio on csvccodigo = hcocservicio ");
                sb.append(" inner join historia.chmotivocons on hmclconsulta = hcolnumero ");
                sb.append(" where hcodfecregistr between TO_DATE(:fechaI, 'dd/MM/yyyy hh24:mi') AND TO_DATE(:fechaF, 'dd/MM/yyyy hh24:mi') and hcocservicio = 'S890250'  ");
                sb.append(" and hmcctrapatol = 'S' and hmcctippatol in ('CX','EN','VU')) on usuario_patologia = hcolusuario ");
                sb.append(" left join (select to_char(hcodfecregistr,'dd/mm/yyyy') fecha_conizacion, hcolusuario usuario_conizacion, hconclinica  ");
                sb.append(" clinica_conizacion, cclcnombre nombre_clinica_conizacion, hcocservicio servicio_conizacion, csvcnombre  ");
                sb.append(" nombre_servicio_conizacion ");
                sb.append(" from historia.chconsulta ");
                sb.append(" inner join clinico.cpclinica on cclncodigo = hconclinica ");
                sb.append(" inner join clinico.cpservicio on csvccodigo = hcocservicio ");
                sb.append(" where hcodfecregistr between TO_DATE(:fechaI, 'dd/MM/yyyy hh24:mi') AND TO_DATE(:fechaF, 'dd/MM/yyyy hh24:mi') and hcocservicio in ('S672001','S672001.0')) ");
                sb.append(" on usuario_conizacion = hcolusuario ");
                sb.append(" left join (select to_char(ccidfeccit,'dd/mm/yyyy') fecha_citologia, ccilusuario usuario_citologia  ");
                sb.append(" from clinico.cncitologi ");
                sb.append(" where ccidfeccit between TO_DATE(:fechaI, 'dd/MM/yyyy hh24:mi') AND TO_DATE(:fechaF, 'dd/MM/yyyy hh24:mi')) on usuario_citologia = hcolusuario ");
                sb.append(" where hcodfecregistr between TO_DATE(:fechaI, 'dd/MM/yyyy hh24:mi') AND TO_DATE(:fechaF, 'dd/MM/yyyy hh24:mi') and hcocservicio in ('S702203','S702201') ");
                Query sqlquery = 
                    this.getHibernateTemplate().getSessionFactory().getCurrentSession().createQuery(sb.toString());
                sqlquery.setParameter("fechaI", fechaI);
                sqlquery.setParameter("fechaF", fechaF);
                

                resultList = sqlquery.list();

                if (!resultList.isEmpty()) {
                    return resultList;
                }
            }
            return null;

        } catch (HibernateException e) {
            throw new ModelException("Error consultando Reporte colposcopia : " + e.getMessage(), e);
        } catch (Exception e) {
            throw new ModelException("Error consultando Reporte colposcopia : " + e.getMessage(), e);
        }

    }
    
    public List<Object[]> getReporteCitologia(Date fechaInicial, Date fechaFinal) throws ModelException {
        List resultList = null;

        String HORA_INICIAL = " 00:00";
        String HORA_FINAL = " 23:59";
        String fechaI = null;
        String fechaF = null;        

        Date fechaCompara = new Date();
        if (fechaInicial != null && fechaFinal != null) {
            SimpleDateFormat dateFormat = new SimpleDateFormat("dd/MM/yyyy");

            fechaI = dateFormat.format(fechaInicial) + HORA_INICIAL;
            fechaF = dateFormat.format(fechaFinal) + HORA_FINAL;
        }

        fechaCompara = fechaInicial;
        try {
            if (fechaInicial != null && fechaFinal != null) {
                StringBuffer sb = new StringBuffer();    
                sb.append(" select to_char(clcdprilec,'dd/mm/yyyy') fecha_lectura, clccanoesc CELULAS_ESCAMOSAS, (select cdicdescri from clinico.cndesccito  ");  
                sb.append(" where cdictabla = 'cncitolect' and cdiccampo = 'clccanoesc' and cdicvalor = clccanoesc) NOMBRE_CELULAS_ESCAMOSAS,  ");
                sb.append(" clccanogla ANORMALIDADES_GLANDULARES, (select cdicdescri from clinico.cndesccito where cdictabla = 'cncitolect'  ");
                sb.append(" and cdiccampo = 'clccanogla' and cdicvalor = clccanogla) NOM_ANORMALIDADES_GLANDULARES, ccinclinic clinica, cclcnombre  ");
                sb.append(" nombre_clinica, ccictipide tipo_id, ccianumide numero_id, ccilusuario usuario, to_number(to_char(ccidfeccit,'YYYY')) -  ");
                sb.append(" to_number(to_char(husdfechanacim,'YYYY')) - case when to_char(ccidfeccit,'MMDD') < to_char(husdfechanacim,'MMDD')  ");
                sb.append(" then 1 else 0 end edad, fecha_colposcopia, usuario_colposcopia, clinica_colposcopia, nombre_clinica_colposcopia,  ");
                sb.append(" servicio_colposcopia, nombre_servicio_colposcopia ");
                sb.append(" from clinico.cncitologi ");
                sb.append(" inner join clinico.cncitolect on clcnconsec = ccinconsec ");
                sb.append(" inner join clinico.cpclinica on cclncodigo = ccinclinic ");
                sb.append(" inner join historia.chusuario on huslnumero = ccilusuario ");
                sb.append(" left join (select to_char(hcodfecregistr,'dd/mm/yyyy') fecha_colposcopia, hcolusuario usuario_colposcopia, hconclinica clinica_colposcopia, ");
                sb.append(" cclcnombre nombre_clinica_colposcopia, hcocservicio servicio_colposcopia, csvcnombre nombre_servicio_colposcopia ");
                sb.append(" from historia.chconsulta ");
                sb.append(" inner join clinico.cpclinica on cclncodigo = hconclinica ");
                sb.append(" inner join clinico.cpservicio on csvccodigo = hcocservicio ");
                sb.append(" where hcodfecregistr between TO_DATE(:fechaI, 'dd/MM/yyyy hh24:mi') AND TO_DATE(:fechaF, 'dd/MM/yyyy hh24:mi') and hcocservicio in ('S702203','S702201'))  ");
                sb.append(" on usuario_colposcopia = ccilusuario ");
                sb.append(" where ccidfeccit between TO_DATE(:fechaI, 'dd/MM/yyyy hh24:mi') AND TO_DATE(:fechaF, 'dd/MM/yyyy hh24:mi')  ");
                sb.append(" and ((clccanoesc is not null and clccanoesc <> '8.0' and clccanoesc <> '_') or  ");
                sb.append(" (clccanogla is not null and clccanogla <> '9.0' and clccanogla <> '_')) ");                               
                Query sqlquery = 
                    this.getHibernateTemplate().getSessionFactory().getCurrentSession().createQuery(sb.toString());
                sqlquery.setParameter("fechaI", fechaI);
                sqlquery.setParameter("fechaF", fechaF);                

                resultList = sqlquery.list();

                if (!resultList.isEmpty()) {
                    return resultList;
                }
            }
            return null;

        } catch (HibernateException e) {
            throw new ModelException("Error consultando Reporte citologia : " + e.getMessage(), e);
        } catch (Exception e) {
            throw new ModelException("Error consultando Reporte citologia : " + e.getMessage(), e);
        }

    }
    
    public List<Object[]> getReporteEntregaVPH(Date fechaInicial, Date fechaFinal) throws ModelException {
        List resultList = null;

        String HORA_INICIAL = " 00:00";
        String HORA_FINAL = " 23:59";
        String fechaI = null;
        String fechaF = null;        

        Date fechaCompara = new Date();
        if (fechaInicial != null && fechaFinal != null) {
            SimpleDateFormat dateFormat = new SimpleDateFormat("dd/MM/yyyy");

            fechaI = dateFormat.format(fechaInicial) + HORA_INICIAL;
            fechaF = dateFormat.format(fechaFinal) + HORA_FINAL;
        }

        fechaCompara = fechaInicial;
        try {
            if (fechaInicial != null && fechaFinal != null) {
                StringBuffer sb = new StringBuffer();                
                sb.append(" select to_char(hcodfecregistr,'dd/mm/yyyy') fecha, hconclinica clinica, cclcnombre nombre_clinica, hcolusuario  ");                
                sb.append(" numero_usuario, husetipoiden tipo_id, husanumeiden numero_id, to_number(to_char(hcodfecregistr,'YYYY')) - ");
                sb.append(" to_number(to_char(husdfechanacim,'YYYY')) - case when to_char(hcodfecregistr,'MMDD') < to_char(husdfechanacim,'MMDD')  ");
                sb.append(" then 1 else 0 end edad, hcocservicio servicio, csvcnombre nombre_servicio, fecha_entrega, usuario_entrega,  ");
                sb.append(" clinica_entrega, nombre_clinica_entrega, servicio_entrega, nombre_servicio_entrega ");
                sb.append(" from historia.chconsulta ");
                sb.append(" inner join clinico.cpclinica on cclncodigo = hconclinica ");
                sb.append(" inner join historia.chusuario on huslnumero = hcolusuario ");
                sb.append(" inner join clinico.cpservicio on csvccodigo = hcocservicio ");
                sb.append(" left join (select to_char(hcodfecregistr,'dd/mm/yyyy') fecha_entrega, hcolusuario usuario_entrega, hconclinica clinica_entrega, ");
                sb.append(" cclcnombre nombre_clinica_entrega, hcocservicio servicio_entrega, csvcnombre nombre_servicio_entrega ");
                sb.append(" from historia.chconsulta ");
                sb.append(" inner join clinico.cpclinica on cclncodigo = hconclinica ");
                sb.append(" inner join clinico.cpservicio on csvccodigo = hcocservicio ");
                sb.append(" where hcodfecregistr between TO_DATE(:fechaI, 'dd/MM/yyyy hh24:mi') AND TO_DATE(:fechaF, 'dd/MM/yyyy hh24:mi') and hcocservicio = 'S890205.0')  ");
                sb.append(" on usuario_entrega = hcolusuario ");
                sb.append(" where hcodfecregistr between TO_DATE(:fechaI, 'dd/MM/yyyy hh24:mi') AND TO_DATE(:fechaF, 'dd/MM/yyyy hh24:mi') and hcocservicio = 'S908436' ");                
                Query sqlquery = 
                    this.getHibernateTemplate().getSessionFactory().getCurrentSession().createQuery(sb.toString());
                sqlquery.setParameter("fechaI", fechaI);
                sqlquery.setParameter("fechaF", fechaF);                

                resultList = sqlquery.list();

                if (!resultList.isEmpty()) {
                    return resultList;
                }
            }
            return null;

        } catch (HibernateException e) {
            throw new ModelException("Error consultando Reporte entrega VPH : " + e.getMessage(), e);
        } catch (Exception e) {
            throw new ModelException("Error consultando Reporte entrega VPH : " + e.getMessage(), e);
        }

    }
    
    public List<Object[]> getReporteExtranjeros(Date fechaInicial, Date fechaFinal) throws ModelException {
        List resultList = null;

        String HORA_INICIAL = " 00:00";
        String HORA_FINAL = " 23:59";
        String fechaI = null;
        String fechaF = null;        

        Date fechaCompara = new Date();
        if (fechaInicial != null && fechaFinal != null) {
            SimpleDateFormat dateFormat = new SimpleDateFormat("dd/MM/yyyy");

            fechaI = dateFormat.format(fechaInicial) + HORA_INICIAL;
            fechaF = dateFormat.format(fechaFinal) + HORA_FINAL;
        }

        fechaCompara = fechaInicial;
        try {
            if (fechaInicial != null && fechaFinal != null) {
                StringBuffer sb = new StringBuffer();                
                sb.append(" select to_char(cadfecreg,'dd/mm/yyyy') fecha, canclinic clinica, cclcnombre nombre_clinica, cactipide tipo_id,  ");                
                sb.append(" cannumide numerio_id, to_number(to_char(cadfecreg,'YYYY')) - to_number(to_char(husdfechanacim,'YYYY')) -  ");
                sb.append(" case when to_char(cadfecreg,'MMDD') < to_char(husdfechanacim,'MMDD') then 1 else 0 end edad, husesexo  ");
                sb.append(" sexo, HUSCCODINACI nacionalidad, cancontra contrato, ccncdescri nombre_contrato, ccnanit nit, cdacservic  ");
                sb.append(" servicio, csvcnombre nombre_servicio, cdacswpaqu paquete, cdancantid cantidad ");
                sb.append(" from clinico.cfadmision ");
                sb.append(" inner join historia.chusuario on huslnumero = cannumpaci and husccodinaci is not null and husccodinaci <> 'COL' ");
                sb.append(" inner join clinico.cpclinica on cclncodigo = canclinic ");
                sb.append(" inner join clinico.cpcontrato on ccnnclinic = canclinic and ccnnnumero = cancontra ");
                sb.append(" inner join clinico.cfdetaadmision on cdannumadm = cannumero ");
                sb.append(" inner join clinico.cpservicio on csvccodigo = cdacservic ");
                sb.append(" where cadfecreg between TO_DATE(:fechaI, 'dd/MM/yyyy hh24:mi') AND TO_DATE(:fechaF, 'dd/MM/yyyy hh24:mi') and canestado = 'VG' ");                
                Query sqlquery = 
                    this.getHibernateTemplate().getSessionFactory().getCurrentSession().createQuery(sb.toString());
                sqlquery.setParameter("fechaI", fechaI);
                sqlquery.setParameter("fechaF", fechaF);                

                resultList = sqlquery.list();

                if (!resultList.isEmpty()) {
                    return resultList;
                }
            }
            return null;

        } catch (HibernateException e) {
            throw new ModelException("Error consultando Reporte extranjeros : " + e.getMessage(), e);
        } catch (Exception e) {
            throw new ModelException("Error consultando Reporte extranjeros : " + e.getMessage(), e);
        }

    }
}
