package org.profamilia.hc.model.dao.imp;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import java.util.Set;

import org.hibernate.Hibernate;
import org.hibernate.HibernateException;


import org.hibernate.Query;
import org.hibernate.Session;

import org.profamilia.hc.model.dto.Chantalerg;
import org.profamilia.hc.model.dto.Chantecegene;
import org.profamilia.hc.model.dto.Chantfami;
import org.profamilia.hc.model.dto.Chantfarma;
import org.profamilia.hc.model.dto.Chantit;
import org.profamilia.hc.model.dto.Chantox;
import org.profamilia.hc.model.dto.Chantpatol;
import org.profamilia.hc.model.dto.Chantquir;
import org.profamilia.hc.model.dto.Chanttrans;
import org.profamilia.hc.model.dto.Chanttrauma;
import org.profamilia.hc.model.dto.Chconsulta;
import org.profamilia.hc.model.dto.Chdatosadvacuna;
import org.profamilia.hc.model.dto.Chplanconsinfo;
import org.profamilia.hc.model.dto.Chusuario;

import org.profamilia.hc.model.dto.Crcup;

import org.profamilia.hc.model.dto.Cnregferti;

import org.profamilia.hc.model.exceptions.ModelException;
import org.profamilia.hc.model.dao.HistoriaDao;

import org.profamilia.hc.view.constantes.IConstantes;
import org.springframework.orm.hibernate3.HibernateCallback;
import org.springframework.orm.hibernate3.support.HibernateDaoSupport;


public class HistoriaDaoImp extends HibernateDaoSupport implements HistoriaDao {
    public HistoriaDaoImp() {
        super();
    }

    public void save(Chdatosadvacuna datosAdicionales) throws ModelException {
        try {    
            this.getHibernateTemplate().saveOrUpdate(datosAdicionales);
        } catch (HibernateException e) {
            throw new ModelException("Error Insertando datos Adicionales :" + 
                                     e.getMessage(), e);
        } catch (Exception e) {
            throw new ModelException("Error Insertando datos Adicionales:" + 
                                     e.getMessage(), e);
        }
    }

    public Chdatosadvacuna readDatosADVacunaByConsulta(Integer consulta) throws ModelException {
        List<?> resultList = null;
        List parametros = new ArrayList();
        try {
        if(consulta !=null ){
                StringBuffer sb = new StringBuffer();
                sb.append(" select c from ").append(Chdatosadvacuna.class.getName()).append(" c ");
                sb.append("where c.hdavnconsulta = ? ");
                parametros.add(consulta);
                resultList = 
                        this.getHibernateTemplate().find(sb.toString(), parametros.toArray());
                if (!resultList.isEmpty()) {
                    return (Chdatosadvacuna) resultList.get(0);
                }
            }
            return null;
        }
       

        catch (HibernateException e) {
            throw new ModelException("Error consultando noticias :" + 
                                     e.getMessage(), e);
        } catch (Exception e) {
            throw new ModelException("Error consultando noticias: " + 
                                     e.getMessage(), e);
        }
    }

    public Chdatosadvacuna readDatosADVacunaByUsuario(Chusuario usuario) throws ModelException {
        List<Chdatosadvacuna> resultList = null;
        List parametros = new ArrayList();
        try {
        if(usuario !=null && usuario.getHuslnumero()!=null ){
                StringBuffer sb = new StringBuffer();
                sb.append(" select c from ").append(Chdatosadvacuna.class.getName()).append(" c ");
                sb.append("where c.hdavnusuario = ? order by c.hdavdfecreg desc ");
                parametros.add(usuario.getHuslnumero());
                resultList = 
                        (List<Chdatosadvacuna>) this.getHibernateTemplate().find(sb.toString(), parametros.toArray());
                if (!resultList.isEmpty()) {
                    return resultList.get(0);
                }
            }
            return null;
        }
        

        catch (HibernateException e) {
            throw new ModelException("Error consultando datos adicionales por usuario :" + 
                                     e.getMessage(), e);
        } catch (Exception e) {
            throw new ModelException("Error consultando datos adicionales por usuario: " + 
                                     e.getMessage(), e);
        }
    }
    public Chconsulta getConsultaAntecedentes(final Long numeroConsulta) throws ModelException {
        Chconsulta pis = 
            (Chconsulta)getHibernateTemplate().execute(new HibernateCallback() {
                    public Object doInHibernate(Session session) throws HibernateException {


                        if (numeroConsulta != null) {
                            StringBuffer sb = new StringBuffer();
                            sb.append(" select chco from " + 
                                      Chconsulta.class.getName() + 
                                      " chco  where chco.hcolnumero = :numeroConsulta   ");

                            String hql = sb.toString();

                            Query query = session.createQuery(hql);
                            query.setParameter("numeroConsulta", 
                                               numeroConsulta);
                            Chconsulta pis;
                            pis = (Chconsulta)query.uniqueResult();

                            if (pis != null) {
                                Set toxicos = pis.getChantox();
                                Hibernate.initialize(toxicos);
                                Set familiares = pis.getChantfami();
                                Hibernate.initialize(familiares);
                                Set patologicos = pis.getChantpatol();
                                Hibernate.initialize(patologicos);
                                Set quirurgicos = pis.getChantquir();
                                Hibernate.initialize(quirurgicos);
                                Set traumaticos = pis.getChanttrauma();
                                Hibernate.initialize(traumaticos);
                                Set transfusionales = pis.getChanttrans();
                                Hibernate.initialize(transfusionales);
                                Set farmacologicos = pis.getChantfarma();
                                Hibernate.initialize(farmacologicos);
                                Set its = pis.getChantit();
                                Hibernate.initialize(its);
                                Set alergicos = pis.getChantalerg();
                                Hibernate.initialize(alergicos);
                            }

                            return pis;
                        }
                        return null;
                    }
                });
        return pis;
    }
    /**
     * @param Antecedentes
     * @throws ModelException
     */
    public void saveAntecedentesGenerales(Chantox toxicos,Chantalerg alergicos,Chantfarma farmacologicos
    ,Chantit its,Chanttrans transfusionales, Chantfami familiares,Chantpatol patologicos,Chantquir quirurgicos,Chanttrauma traumacologicos) throws ModelException {
        try {          
            this.getHibernateTemplate().saveOrUpdate(toxicos);
            this.getHibernateTemplate().saveOrUpdate(alergicos);
            this.getHibernateTemplate().saveOrUpdate(farmacologicos);
            this.getHibernateTemplate().saveOrUpdate(its);
            this.getHibernateTemplate().saveOrUpdate(transfusionales);
            this.getHibernateTemplate().saveOrUpdate(familiares);
            this.getHibernateTemplate().saveOrUpdate(patologicos);
            this.getHibernateTemplate().saveOrUpdate(quirurgicos);
            this.getHibernateTemplate().saveOrUpdate(traumacologicos);
        } catch (HibernateException e) {
            throw new ModelException("Error Insertando Antecedentes Generales:" + 
                                     e.getMessage(), e);
        } catch (Exception e) {
            throw new ModelException("Error Insertando Antecedentes Generales:" + 
                                     e.getMessage(), e);
        }
    }
    public List <Chconsulta> getConsultasHistoricoAntecedentes(final Long numeroUsuario,final boolean conEtapa) throws ModelException {
        List<Chconsulta> pis = 
            (List<Chconsulta>)getHibernateTemplate().execute(new HibernateCallback() {
                    public Object doInHibernate(Session session) throws HibernateException {


                        if (numeroUsuario != null) {
                            StringBuffer sb = new StringBuffer();
                            sb.append(" select chco from " + 
                                      Chconsulta.class.getName() + 
                                      " chco where chco.hcolusuario.huslnumero = :numeroUsuario    ");
                            if(conEtapa){
                                sb.append(" and chco.hcoeetapa = :etapa"  );
                            }

                            String hql = sb.toString();

                            Query query = session.createQuery(hql);
                            query.setParameter("numeroUsuario", 
                                               numeroUsuario);
                            if(conEtapa){
                            query.setParameter("etapa", 
                                               IConstantes.ETAPA_CERRADA);
                            }
                            List<Chconsulta> pis;
                            pis = query.list();

                            if (pis != null && !pis.isEmpty()) {
                            for(int i = 0;i<pis.size();i++){
                                Set toxicos = pis.get(i).getChantox();
                                Hibernate.initialize(toxicos);
                                Set familiares = pis.get(i).getChantfami();
                                Hibernate.initialize(familiares);
                                Set patologicos = pis.get(i).getChantpatol();
                                Hibernate.initialize(patologicos);
                                Set quirurgicos = pis.get(i).getChantquir();
                                Hibernate.initialize(quirurgicos);
                                Set traumaticos = pis.get(i).getChanttrauma();
                                Hibernate.initialize(traumaticos);
                                Set transfusionales = pis.get(i).getChanttrans();
                                Hibernate.initialize(transfusionales);
                                Set farmacologicos = pis.get(i).getChantfarma();
                                Hibernate.initialize(farmacologicos);
                                Set its = pis.get(i).getChantit();
                                Hibernate.initialize(its);
                                Set alergicos = pis.get(i).getChantalerg();
                                Hibernate.initialize(alergicos);
                            }
                            }

                            return pis;
                        }
                        return null;
                    }
                });
        return pis;
    }
    public Chplanconsinfo getConsentimientoInformadoActivo(String codigo) throws ModelException {
        List<Chplanconsinfo> resultList = null;
        List parametros = new ArrayList();

        try {
                StringBuffer sb = new StringBuffer();
                sb.append(" select chpci from " + Chplanconsinfo.class.getName() + 
                          " chpci  where chpci.hpcicestado = 'AC'");       
                sb.append(" and trim (chpci.hpciccodigo) = ? ");
                parametros.add(codigo.trim());
                resultList = 
                        (List<Chplanconsinfo>) this.getHibernateTemplate().find(sb.toString(), parametros.toArray());
                if (!resultList.isEmpty()) {
                    return resultList.get(0);
                }

            return null;

        } catch (HibernateException e) {
            throw new ModelException("Error consultando Consentimiento Informado - Usuario:" + 
                                     e.getMessage(), e);
        } catch (Exception e) {
            throw new ModelException("Error consultando Consentimientos Informado  - Usuario:" + 
                                     e.getMessage(), e);
        }

    }

    /**
     * @param crcups
     * @return
     * @throws ModelException
     */
    public List<Crcup>getCupsXCriterios(Crcup crcups,String capitulo) throws ModelException {
        List<Crcup> resultList = null;
        List parametros = new ArrayList();


        try {

                StringBuffer sb = new StringBuffer();
                sb.append(" select crcu from " + Crcup.class.getName() + 
                          " crcu  where crcu.crcuvestado = 'VG'");
                sb.append(" and crcu.crcucexsecc !='00' ");
                          
            if (crcups.getCrcuvcodigo() != null && 
                !crcups.getCrcuvcodigo().equals("")) {
                sb.append(" and crcu.crcuvcodigo like ? ");
                parametros.add("%" + 
                               crcups.getCrcuvcodigo() + 
                               "%");
            }
            
            if (crcups.getCrcuvdescrip() != null && 
                !crcups.getCrcuvdescrip().equals("")) {
                sb.append(" and crcu.crcuvdescrip like ? ");
                parametros.add("%" + 
                               crcups.getCrcuvdescrip() + 
                               "%");
            }
            
            if (capitulo != null && 
                !capitulo.equals("")) {
                sb.append(" and crcu.crcuccapitu = ? ");
                parametros.add(capitulo);
            }    

                resultList = 
                        (List<Crcup>) this.getHibernateTemplate().find(sb.toString(), parametros.toArray());


                if (!resultList.isEmpty()) {
                    return resultList;
                }
                return null;
        }catch(HibernateException e){
            throw new ModelException("Error consultando Cups" + 
                                     e.getMessage(), e);
        }
         catch (Exception e) {
            throw new ModelException("Error consultando Cups" +  e.getMessage(), e);


         }
    }
    /**
     * @param clinica
     * @param tipoid
     * @param numeroid
     * @return
     * @throws ModelException
     */
    public Cnregferti getRegistroFertilidad(Integer clinica, String tipoid, Long numeroid) throws ModelException {
        List<Cnregferti> resultList = null;
        List parametros = new ArrayList();

        try {
            if (clinica != null && tipoid != null && numeroid != null) {
                StringBuffer sb = new StringBuffer();
                sb.append(" select dat from " + Cnregferti.class.getName() + 
                          " dat  where dat.id.crfnclinic = ? and dat.id.crfctipide = ? " +
                          " and dat.id.crfanumide = ? ");
                parametros.add(clinica);
                parametros.add(tipoid);
                parametros.add(numeroid);
                resultList = (List<Cnregferti>) this.getHibernateTemplate().find(sb.toString(), parametros.toArray());
                if (!resultList.isEmpty()) {
                    return resultList.get(0);
                }
            }

            return null;

        } catch (HibernateException e) {

            throw new ModelException("Error consultando Registro de Fertilidad:" + 
                                     e.getMessage(), e);
        } catch (Exception e) {
            throw new ModelException("Error consultando Registro de Fertilidad:" + 
                                     e.getMessage(), e);
        }

    }
    /**
     * @return
     * @throws ModelException
     */
    public List<String>getCapitulosCups() throws ModelException {
        List<String> resultList = null;
        List parametros = new ArrayList();


        try {

                StringBuffer sb = new StringBuffer();
                sb.append("select CRCUCCAPITU from CLINICO.crcups where CRCUVESTADO ='VG' group by CRCUCCAPITU");
                          
            
            Query sqlquery = 
                this.getHibernateTemplate().getSessionFactory().getCurrentSession().createQuery(sb.toString());


            resultList = sqlquery.list();
           
                if (!resultList.isEmpty()) {
                    return resultList;
                }

            return null;

        } catch (HibernateException e) {
            throw new ModelException("Error consultando capitulos Cups" + 
                                     e.getMessage(), e);
        } catch (Exception e) {
            throw new ModelException("Error consultando capitulos Cups" + 
                                     e.getMessage(), e);
        }

    }
    /**
     * @param crcups
     * @return
     * @throws ModelException
     */
    public Crcup getCupByCodigo(String codigo) throws ModelException {
        List<Crcup> resultList = null;
        List parametros = new ArrayList();


        try {

                StringBuffer sb = new StringBuffer();
                sb.append(" select crcu from " + Crcup.class.getName() + 
                          " crcu  where crcu.crcuvestado = 'VG'");
                sb.append(" and crcu.crcuvcodigo = ? and crcu.crcucexsecc !='00'  ");
                
                parametros.add(codigo);

                resultList = 
                        (List<Crcup>) this.getHibernateTemplate().find(sb.toString(), parametros.toArray());


                if (!resultList.isEmpty()) {
                    return resultList.get(0);
                }
                return null;
        }catch(HibernateException e){
            throw new ModelException("Error consultando Cups por C�digo" + 
                                     e.getMessage(), e);
        }
         catch (Exception e) {
            throw new ModelException("Error consultando Cups por C�digo" +  e.getMessage(), e);


         }
    }
}
