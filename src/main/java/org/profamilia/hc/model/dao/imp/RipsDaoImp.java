package org.profamilia.hc.model.dao.imp;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

import org.hibernate.HibernateException;

import org.hibernate.Query;
import org.hibernate.Session;
import org.profamilia.hc.model.dao.RipsDao;
import org.profamilia.hc.model.dto.Cfadmision;
import org.profamilia.hc.model.dto.Cisaludtool;
import org.profamilia.hc.model.dto.Cnconsclin;
import org.profamilia.hc.model.dto.Cpservicio;
import org.profamilia.hc.model.dto.Crarcconsu;
import org.profamilia.hc.model.dto.Crcausaext;
import org.profamilia.hc.model.dto.RipsSaludtoolsDTO;
import org.profamilia.hc.model.exceptions.ModelException;
import org.springframework.orm.hibernate3.HibernateCallback;
import org.springframework.orm.hibernate3.support.HibernateDaoSupport;

public class RipsDaoImp extends HibernateDaoSupport implements RipsDao {
    public RipsDaoImp() {
    }

    public void savelstRipsSaludTools(List<Cisaludtool> lstRips) throws ModelException {
        try {
            this.getHibernateTemplate().saveOrUpdate(lstRips);
        } catch (HibernateException e) {
            throw new ModelException("Error insertando rips:" + 
                                     e.getMessage(), e);
        } catch (Exception e) {
            throw new ModelException("Error insertando rips:" + 
                                     e.getMessage(), e);
        }

    }


    public Integer getCodigoConsultaExterna(String descripcion) throws ModelException {
        List<Crcausaext> resultList = null;
        Integer codigo = null;
        try {
            StringBuffer sb = new StringBuffer();
            sb.append("select CCANCODIGO from clinico.crcausaext where CCACDESCRI = :descripcion");


            Query sqlquery = 
                this.getHibernateTemplate().getSessionFactory().getCurrentSession().createQuery(sb.toString());
            sqlquery.setParameter("descripcion", descripcion);
            resultList = sqlquery.list();

            if (!resultList.isEmpty()) {
                return resultList.get(0).getCcancodigo();
            }
        }

        catch (HibernateException e) {
            throw new ModelException("Error consultando codigo de consulta externa :" + 
                                     e.getMessage(), e);
        } catch (Exception e) {
            throw new ModelException("Error consultando codigo de consulta externa: " + 
                                     e.getMessage(), e);
        }
        return null;

    }

    public void updateLstRipsByTipNum() throws ModelException {
        try {
            StringBuffer sb = new StringBuffer();
            Session session = getSessionFactory().getCurrentSession();
            sb.append("update clinico.Cisaludtools c set c.cstcestado = 'XX', c.cstcerror='TIPO DE IDENTIFICACI�N NO VALIDO' where (c.cstcestado is null and c.cstctipide is null )OR (c.cstcestado is null and c.cstctipide not in(select distinct tip.cticcodigo from Clinico.cptipoiden tip) ) ");

            Query query = session.createQuery(sb.toString());

            query.executeUpdate();


        }

        catch (HibernateException e) {
            throw new ModelException("Error Actualizando Rip por Tipo de Actualizaci�n :" + e.getMessage(), 
                                     e);
        } catch (Exception e) {
            throw new ModelException("Error Actualizando Rip por Tipo de Actualizaci�n :" + e.getMessage(), 
                                     e);
        }
    }

    public void updateLstRipsNum() throws ModelException {
        try {
            StringBuffer sb = new StringBuffer();
            Session session = getSessionFactory().getCurrentSession();
            sb.append("update clinico.Cisaludtools c set c.cstcestado = 'XX', c.cstcerror='N�MERO DE IDENTIFICACI�N NO VALIDO' where (c.cstcestado is null and c.cstanumide is null) OR (c.cstcestado is null and c.cstanumide not in(select distinct chu.husanumeiden from Historia.chusuario chu) ) ");

            Query query = session.createQuery(sb.toString());

            query.executeUpdate();


        }

        catch (HibernateException e) {
            throw new ModelException("Error Actualizando rip por N�mero de Identificaci�n :" + e.getMessage(), 
                                     e);
        } catch (Exception e) {
            throw new ModelException("Error Actualizando rip por N�mero de Identificaci�n :" + e.getMessage(), 
                                     e);
        }
    }

    public void updateLstRipsCausaE() throws ModelException {
        try {
            StringBuffer sb = new StringBuffer();
            Session session = getSessionFactory().getCurrentSession();
            sb.append("update clinico.Cisaludtools c set c.cstcestado = 'XX', c.cstcerror='CAUSA EXTERNA NO VALIDA' where (c.CSTCCAUSAE is null and c.cstcestado is null)OR ( c.cstcestado is null and UPPER(c.cstccausae) not in(select distinct UPPER(ccacdescri) from clinico.crcausaext ))   ");

            Query query = session.createQuery(sb.toString());

            query.executeUpdate();


        }

        catch (HibernateException e) {
            throw new ModelException("Error Actualizando rip por Causa Externa :" + e.getMessage(), 
                                     e);
        } catch (Exception e) {
            throw new ModelException("Error Actualizando rip por Causa Externa :" + e.getMessage(), 
                                     e);
        }
    }

    public void updateLstRipsServi() throws ModelException {
        try {
            StringBuffer sb = new StringBuffer();
            Session session = getSessionFactory().getCurrentSession();
            sb.append("update clinico.Cisaludtools c set c.cstcestado = 'XX', c.cstcerror='TIPO DE SERVICIO NO VALIDO' where (c.cstcestado is null and c.cstcservic is null) OR (c.cstcestado is null and  c.cstcservic not in(select distinct ser.csvccodigo from Clinico.cpservicio ser where ser.csvcestado = 'VG') ) ");

            Query query = session.createQuery(sb.toString());

            query.executeUpdate();


        }

        catch (HibernateException e) {
            throw new ModelException("Error Actualizando rip por Tipo Servicio :" + e.getMessage(), 
                                     e);
        } catch (Exception e) {
            throw new ModelException("Error Actualizando rip por Tipo Servicio :" + e.getMessage(), 
                                     e);
        }
    }

    public void updateLstRipsCIE10() throws ModelException {
        try {
            StringBuffer sb = new StringBuffer();
            Session session = getSessionFactory().getCurrentSession();
            sb.append("update clinico.Cisaludtools c set c.cstcestado = 'XX', c.cstcerror='CODIGO  CIE10 NO VALIDO' where (c.cstcestado is null and c.cstcciepri is null) OR ( c.cstcestado is null and  c.cstcciepri not in(select distinct cie.cdcccodigo from Clinico.crdgncie10 cie) ) ");

            Query query = session.createQuery(sb.toString());

            query.executeUpdate();


        }

        catch (HibernateException e) {
            throw new ModelException("Error Actualizando rip Por CIE10 :" + e.getMessage(), 
                                     e);
        } catch (Exception e) {
            throw new ModelException("Error Actualizando rip Por CIE10 :" + e.getMessage(), 
                                     e);
        }
    }

    public void updateLstRipsSCIE10() throws ModelException {
        try {
            StringBuffer sb = new StringBuffer();
            Session session = getSessionFactory().getCurrentSession();
            sb.append("update clinico.Cisaludtools c set c.cstcestado = 'XX', c.cstcerror='CODIGO SECUNDARIO CIE10 NO VALIDO' where c.cstcestado is null and c.cstcciesec <> null and  c.cstcciesec not in(select distinct cie.cdcccodigo from Clinico.crdgncie10 cie)  ");

            Query query = session.createQuery(sb.toString());

            query.executeUpdate();


        }

        catch (HibernateException e) {
            throw new ModelException("Error Actualizando rip Por CIE10 Secundario :" + e.getMessage(), 
                                     e);
        } catch (Exception e) {
            throw new ModelException("Error Actualizando rip Por CIE10 Secundario :" + e.getMessage(), 
                                     e);
        }
    }

    public void updateLstRipsByAdm() throws ModelException {
        try {
            StringBuffer sb = new StringBuffer();
            Session session = getSessionFactory().getCurrentSession();
            sb.append("update clinico.Cisaludtools c set c.cstcestado = 'XX', c.cstcerror='NO EXISTE ADMISION POR DOC. IDENTIDAD' where c.cstcestado is null and c.cstctipide <> null and c.cstanumide <> null and  (c.cstctipide,c.cstanumide) not in(select distinct adm.cactipide, to_char(adm.cannumide) from Clinico.cfadmision adm " + 
                      "  where adm.cadfecreg > '01/03/2020')  ");

            Query query = session.createQuery(sb.toString());

            query.executeUpdate();


        }

        catch (HibernateException e) {
            throw new ModelException("Error Actualizando rip Por Admisi�n :" + e.getMessage(), 
                                     e);
        } catch (Exception e) {
            throw new ModelException("Error Actualizando rip Por Admisi�n :" + e.getMessage(), 
                                     e);
        }
    }

    public RipsSaludtoolsDTO updateLstRipsByAdminDatos(Cisaludtool rips, 
                                                       int valor,String fecha) throws ModelException {
        try {
            List<RipsSaludtoolsDTO> resultado = null;
            List<Object[]> objRes = null;
            RipsSaludtoolsDTO dto = null;
            StringBuffer sb = new StringBuffer();
            Session session = getSessionFactory().getCurrentSession();
            if (valor == 1) {
                sb.append(" select cannumero, cadfecreg, cactipide, cannumide, substr(cacnumrem,1,15), cdacservic, canclinic," + 
                          "          nvl(cdanvaltot,0), cdancantid, case when nvl(cdanvalent,0) = 0 then nvl(cdanvaltot,0) else cdanvalent end, " +
                          "          case when nvl(cdanvalent,0) = 0 then 0 else cdanvaltot - cdanvalent end, cdandiaate, cdacpaquet from clinico.cfadmision, clinico.cfdetaadmision " + 
                          "          where cadfecreg > '01/01/2020' and canestado <> 'XX' and cdannumadm = cannumero and cactipide = :tipide " + 
                          "          and cannumide = :numide and cdacservic = :servicio and trunc(cadfecreg) = trunc (to_date (:fecha)) and cannumero is not null and (cdandiaate is null or cdandiaate = 0) order by cadfecreg " + 
                          "          ");
            } else if (valor == 2) {
                sb.append(" select cannumero, cadfecreg, cactipide, cannumide, substr(cacnumrem,1,15), cdacservic, canclinic," + 
                          "           nvl(cdanvaltot,0), cdancantid, case when nvl(cdanvalent,0) = 0 then nvl(cdanvaltot,0) else cdanvalent end, " +
                          "          case when nvl(cdanvalent,0) = 0 then 0 else cdanvaltot - cdanvalent end, cdandiaate, cdacpaquet from clinico.cfadmision, clinico.cfdetaadmision " + 
                          "          where cadfecreg > '01/01/2020' and canestado <> 'XX' and cdannumadm = cannumero and cactipide = :tipide " + 
                          "          and cannumide = :numide and cdacservic = :servicio and trunc(cadfecreg) between trunc (to_date(:fecha)) - 5 and trunc (to_date(:fecha)) + 5 and cannumero is not null and (cdandiaate is null or cdandiaate = 0) order by cadfecreg " + 
                          "          ");
            } else if (valor == 3) {
                sb.append(" select cannumero, cadfecreg, cactipide, cannumide, substr(cacnumrem,1,15), cdacservic, canclinic," + 
                          "           nvl(cdanvaltot,0), cdancantid, case when nvl(cdanvalent,0) = 0 then nvl(cdanvaltot,0) else cdanvalent end, " +
                          "          case when nvl(cdanvalent,0) = 0 then 0 else cdanvaltot - cdanvalent end, cdandiaate, cdacpaquet from clinico.cfadmision, clinico.cfdetaadmision " + 
                          "          where cadfecreg > '01/01/2020' and canestado <> 'XX' and cdannumadm = cannumero and cactipide = :tipide " + 
                          "          and cannumide = :numide and substr(cdacservic,1,7) = substr(:servicio,1,7)  and trunc(cadfecreg) = trunc (to_date (:fecha)) and cannumero is not null and (cdandiaate is null or cdandiaate = 0) order by cadfecreg " + 
                          "          ");
            } else if (valor == 4) {
                sb.append(" select cannumero, cadfecreg, cactipide, cannumide, substr(cacnumrem,1,15), cdacservic, canclinic," + 
                          "           nvl(cdanvaltot,0), cdancantid, case when nvl(cdanvalent,0) = 0 then nvl(cdanvaltot,0) else cdanvalent end, " +
                          "          case when nvl(cdanvalent,0) = 0 then 0 else cdanvaltot - cdanvalent end, cdandiaate, cdacpaquet from clinico.cfadmision, clinico.cfdetaadmision " + 
                          "          where cadfecreg > '01/01/2020' and canestado <> 'XX' and cdannumadm = cannumero and cactipide = :tipide " + 
                          "          and cannumide = :numide and substr(cdacservic,1,7) = substr(:servicio,1,7) and trunc(cadfecreg) between trunc (to_date(:fecha)) - 5 and trunc (to_date(:fecha)) + 5 and cannumero is not null and (cdandiaate is null or cdandiaate = 0) order by cadfecreg " + 
                          "          ");
            } else if (valor == 5) {
                sb.append(" select cannumero, cadfecreg, cactipide, cannumide, substr(cacnumrem,1,15), cdacservic, canclinic," + 
                          "          nvl(cdanvaltot,0), cdancantid, case when nvl(cdanvalent,0) = 0 then nvl(cdanvaltot,0) else cdanvalent end, " +
                          "          case when nvl(cdanvalent,0) = 0 then 0 else cdanvaltot - cdanvalent end, cdandiaate, cdacpaquet from clinico.cfadmision, clinico.cfdetaadmision " + 
                          "          where cadfecreg > '01/01/2020' and canestado <> 'XX' and cdannumadm = cannumero and cactipide = :tipide " + 
                          "          and cannumide = :numide and substr(cdacservic,1,7) = substr(:servicio,1,7) and trunc(cadfecreg) between trunc (to_date(:fecha)) - 10 and trunc (to_date(:fecha)) + 15 and cannumero is not null and (cdandiaate is null or cdandiaate = 0) order by cadfecreg " + 
                          "          ");
            }


            Query query = session.createQuery(sb.toString());
            query.setParameter("tipide", rips.getCstctipide());
            query.setParameter("numide", rips.getCstanumide());
            query.setParameter("servicio", rips.getCstcservic());
            query.setParameter("fecha", fecha);
            objRes = query.list();

            //Object [] axu = resultado.get(0);
            // dto.setCstnadmisi((Long)(axu[0]));
            if (objRes != null && !objRes.isEmpty()) {
                Object[] aux = objRes.get(0);
                dto = new RipsSaludtoolsDTO();
                dto.setCstnadmisi(((BigDecimal)aux[0]).longValue());
                dto.setCstcautori((String)aux[4]);
                dto.setCstavalcon((BigDecimal)aux[7]);
                dto.setCstavalcuo((BigDecimal)aux[10]);
                dto.setCstavalnet((BigDecimal)aux[9]);
                dto.setCstcsrvadm((String)aux[5]);
            }


            //List<RipsSaludtoolsDTO>aux =null;


            if (objRes != null && !objRes.isEmpty()) {
                return dto;
            }

            return null;

        } catch (HibernateException e) {
            throw new ModelException("Error En la consulta de validacion de rips :" + e.getMessage(), 
                                     e);
        } catch (Exception e) {
            throw new ModelException("Error En la consulta de validacion de rips :" + e.getMessage(), 
                                     e);
        }

    }

    public List<Cisaludtool> getLstRips() throws ModelException {
        try {

            List<Cisaludtool> resultado = new ArrayList<Cisaludtool>();
            List<Object[]> objRes = null;
            StringBuffer sb = new StringBuffer();
            Session session = getSessionFactory().getCurrentSession();
            sb.append("select * from  clinico.cisaludtools order by CSTANUMIDE ");
            String hql = sb.toString();
            Query query = session.createQuery(hql);
            objRes = query.list();
            if (objRes != null) {
                for (int i = 0; i < objRes.size(); i++) {
                    Cisaludtool dto = new Cisaludtool();
                    Object[] aux = objRes.get(i);
                    dto.setCstctipide((String)aux[0]);
                    dto.setCstanumide((String)aux[1]);
                    dto.setCstcnombre((String)aux[2]);
                    dto.setCstcapelli((String)aux[3]);
                    dto.setCstcfecate((String)aux[4]);
                    dto.setCstcservic((String)aux[5]);
                    dto.setCstctipoci((String)aux[6]);
                    dto.setCstccausae((String)aux[7]);
                    dto.setCstcciepri((String)aux[8]);
                    dto.setCstcdespri((String)aux[9]);
                    dto.setCstcciesec((String)aux[10]);
                    dto.setCstcdessec((String)aux[11]);
                    dto.setCstcclinic((String)aux[12]);
                    dto.setCstcprofes((String)aux[13]);
                    dto.setCstcdepart((String)aux[14]);
                    dto.setCstcciudad((String)aux[15]);
                    dto.setCstcsexo((String)aux[16]);
                    dto.setCstcedad((String)aux[17]);
                    dto.setCstcestado((String)aux[18]);
                    dto.setCstcerror((String)aux[19]);
                    dto.setCstnsecuencia(((BigDecimal)aux[38]).intValue());

                    resultado.add(dto);
                }
            }
            if (resultado != null && !resultado.isEmpty()) {
                return resultado;
            }
            return null;
        } catch (HibernateException e) {
            throw new ModelException("Error Obteniendo lista de rips :" + e.getMessage(), 
                                     e);
        } catch (Exception e) {
            throw new ModelException("Error Obteniendo lista de rips :" + e.getMessage(), 
                                     e);
        }
    }

    public Cnconsclin getConsultaClinica(Cisaludtool rip, 
                                         int valor) throws ModelException {
        try {


            List<Cnconsclin> resultado = null;
            Cnconsclin dto = null;
            StringBuffer sb = new StringBuffer();
            Session session = getSessionFactory().getCurrentSession();
            if (valor == 1) {
                sb.append("select c from  Cnconsclin c where c.ccontipdoc = 100 and c.cconnumdoc = :admis and c.ccocservic = :servicio" + 
                          "        and c.ccocestado = 'VG' ");
            } else {
                sb.append("select c from Cnconsclin c" + 
                          " where c.cconnumero = :clinica");


            }


            String hql = sb.toString();
            Query query = session.createQuery(hql);
            if (valor == 1) {
                query.setParameter("admis", rip.getCstnadmisi());
                query.setParameter("servicio", rip.getCstcsrvadm());
            } else {
                query.setParameter("clinica", rip.getCstnnomcli());
            }

            resultado = query.list();
            if (resultado != null && !resultado.isEmpty()) {
                dto = resultado.get(0);
                return dto;
            }
            return null;
        } catch (HibernateException e) {
            throw new ModelException("Error En la consulta Clinica :" + e.getMessage(), 
                                     e);
        } catch (Exception e) {
            throw new ModelException("Error En la consulta Clinica :" + e.getMessage(), 
                                     e);
        }


    }

    public Cfadmision getUsuarioAdmision(Cisaludtool rip) throws ModelException {
        try {


            List<Cfadmision> resultado = null;
            Cfadmision dto = null;
            StringBuffer sb = new StringBuffer();
            Session session = getSessionFactory().getCurrentSession();

            sb.append("select c from  Cfadmision c " + 
                      "where c.cannumero = :admis");


            String hql = sb.toString();
            Query query = session.createQuery(hql);

            query.setParameter("admis", rip.getCstnadmisi());


            resultado = query.list();
            if (resultado != null && !resultado.isEmpty()) {
                dto = resultado.get(0);
                return dto;
            }
            return null;
        } catch (HibernateException e) {
            throw new ModelException("Error en la consulta de admision :" + e.getMessage(), 
                                     e);
        } catch (Exception e) {
            throw new ModelException("Error en la consulta de admision :" + e.getMessage(), 
                                     e);
        }
    }

    public Cpservicio getCodigoCups(Cisaludtool rip) throws ModelException {
        try {


            List<Cpservicio> resultado = null;
            Cpservicio dto = null;
            StringBuffer sb = new StringBuffer();
            Session session = getSessionFactory().getCurrentSession();

            sb.append("select c from Cpservicio c " + 
                      "where c.csvccodigo = :codigo");


            String hql = sb.toString();
            Query query = session.createQuery(hql);
            query.setParameter("codigo", rip.getCstcsrvadm());


            resultado = query.list();
            if (resultado != null && !resultado.isEmpty()) {
                dto = resultado.get(0);
                return dto;
            }
            return null;
        } catch (HibernateException e) {
            throw new ModelException("Error en la consulta del setvicio :" + e.getMessage(), 
                                     e);
        } catch (Exception e) {
            throw new ModelException("Error en la consulta del servicio :" + e.getMessage(), 
                                     e);
        }
    }

    public boolean validarRipsDuplicados2(Cisaludtool rip) throws ModelException {
        try {


            List<Crarcconsu> resultado = null;
            StringBuffer sb = new StringBuffer();
            Session session = getSessionFactory().getCurrentSession();

            sb.append("select  cr.cstnconcli from  Crarcconsu cr" + 
                      "where cr.cacnconcli = :clincia and cacnconsec = :consec");


            String hql = sb.toString();
            Query query = session.createQuery(hql);
            query.setParameter("clinica", rip.getCstnnomcli());
            query.setParameter("consec", rip.getCstnconsec());


            resultado = query.list();
            if (resultado != null && !resultado.isEmpty()) {

                return true;
            }
            return false;
        } catch (HibernateException e) {
            throw new ModelException("Error Actualizando :" + e.getMessage(), 
                                     e);
        } catch (Exception e) {
            throw new ModelException("Error Actualizando :" + e.getMessage(), 
                                     e);
        }
    }

    public boolean validarRipsDuplicados(Cisaludtool rip) throws ModelException {
        List parametros;
        List lstConsulta;

        try {

            parametros = new ArrayList();
            StringBuffer sb = new StringBuffer();
            sb.append(" select cr from ").append(Crarcconsu.class.getName()).append(" cr ");
            sb.append("where cr.id.cacnconcli = ? and cr.id.cacnconsec = ?");
            parametros.add(rip.getCstnnomcli());
            parametros.add(rip.getCstnconsec());


            lstConsulta = 
                    getHibernateTemplate().find(sb.toString(), parametros.toArray());

            if (lstConsulta != null && !lstConsulta.isEmpty()) {
                return true;
            }

            return false;


        } catch (HibernateException e) {
            throw new ModelException("Error validando rips duplicados :" + e.getMessage(), 
                                     e);
        } catch (Exception e) {
            throw new ModelException("Error validando rips :" + e.getMessage(), 
                                     e);
        }

    }


    public void savelstRipsCrarcconsu(final List<Crarcconsu> lstRips) throws ModelException {
        try {
            this.getHibernateTemplate().execute(new HibernateCallback() {
                        public Object doInHibernate(Session session) {

                            for (Crarcconsu rips: lstRips) {
                                session.saveOrUpdate(rips);
                            }

                            return lstRips;

                        }

                    });
        } catch (HibernateException e) {
            throw new ModelException("Error Insertando :" + e.getMessage(), e);
        } catch (Exception e) {
            throw new ModelException("Error Insertando :" + e.getMessage(), e);
        }
    }

    public void deleteSaludtools() throws ModelException {
        try {
            this.getHibernateTemplate().execute(new HibernateCallback() {
                public Object doInHibernate(Session session) {
                       session.createQuery(" delete clinico.cisaludtools").executeUpdate();
                       return null;
                   }
            });
        } catch (HibernateException e) {
            throw new ModelException("Error Eliminando :" + e.getMessage(), e);
        } catch (Exception e) {
            throw new ModelException("Error Eliminando :" + e.getMessage(), e);
        }
    }

    public void updateLstRipsBySexo() throws ModelException {
        try {
            StringBuffer sb = new StringBuffer();
            Session session = getSessionFactory().getCurrentSession();
            sb.append("update clinico.Cisaludtools c set c.cstcestado = 'XX', c.cstcerror='SEXO NO VALIDO' where (c.cstcestado is null and c.cstcsexo is null )OR (c.cstcsexo is null and c.cstcsexo not in('F','M'))  ");

            Query query = session.createQuery(sb.toString());

            query.executeUpdate();


        }

        catch (HibernateException e) {
            throw new ModelException("Error Actualizando rip Por Sexo :" + e.getMessage(), 
                                     e);
        } catch (Exception e) {
            throw new ModelException("Error Actualizando rip Por Sexo :" + e.getMessage(), 
                                     e);
        }
    }
    
  



        /**
         * @param pwservic
         * @return
         */
        private String cfcocups(final String pwservic) {
            String servicio = null;
            if (pwservic != null && pwservic.length() > 0) {
                StringTokenizer st = new StringTokenizer(pwservic, ".");

                servicio = st.nextToken();
            }
            return servicio;

        }
        
    
    
   


}
