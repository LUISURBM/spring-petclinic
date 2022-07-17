 package org.profamilia.hc.model.dao.imp;

import java.math.BigDecimal;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Collections;
import java.util.Comparator;
import java.util.Date;
import java.util.Iterator;
import java.util.List;
import java.util.Set;
import java.util.StringTokenizer;

import org.hibernate.Hibernate;
import org.hibernate.HibernateException;

import org.hibernate.Query;
import org.hibernate.Session;
import org.profamilia.hc.model.dao.CirugiaDao;
import org.profamilia.hc.model.dto.Ccfactvent;
import org.profamilia.hc.model.dto.Cfadmision;
import org.profamilia.hc.model.dto.Cfdetaadmision;
import org.profamilia.hc.model.dto.Chaldrete;
import org.profamilia.hc.model.dto.Chanestesia;
import org.profamilia.hc.model.dto.Chantalerg;
import org.profamilia.hc.model.dto.Chantecegene;
import org.profamilia.hc.model.dto.Chantegineco;
import org.profamilia.hc.model.dto.Chantfami;
import org.profamilia.hc.model.dto.Chantfarma;
import org.profamilia.hc.model.dto.Chantit;
import org.profamilia.hc.model.dto.Chantox;
import org.profamilia.hc.model.dto.Chantpatol;
import org.profamilia.hc.model.dto.Chantquir;
import org.profamilia.hc.model.dto.Chanttrans;
import org.profamilia.hc.model.dto.Chanttrauma;
import org.profamilia.hc.model.dto.Chautoinfopsic;
import org.profamilia.hc.model.dto.Chautordescr;
import org.profamilia.hc.model.dto.Chautorepicr;
import org.profamilia.hc.model.dto.Chautornota;
import org.profamilia.hc.model.dto.Chcanalivena;
import org.profamilia.hc.model.dto.Chcierreanest;
import org.profamilia.hc.model.dto.Chcirdetdesc;
import org.profamilia.hc.model.dto.Chciruganula;
import org.profamilia.hc.model.dto.Chcirugprogr;
import org.profamilia.hc.model.dto.Chconducta;
import org.profamilia.hc.model.dto.Chconsulta;
import org.profamilia.hc.model.dto.Chconsultori;
import org.profamilia.hc.model.dto.Chcontmedane;
import org.profamilia.hc.model.dto.Chcontrmedic;
import org.profamilia.hc.model.dto.Chcontroliqu;
import org.profamilia.hc.model.dto.Chcontroorden;
import org.profamilia.hc.model.dto.Chcuestpamec;
import org.profamilia.hc.model.dto.Chdescrquiru;
import org.profamilia.hc.model.dto.Chdetacirpro;
import org.profamilia.hc.model.dto.Chdetaldescr;
import org.profamilia.hc.model.dto.Chepicrisi;
import org.profamilia.hc.model.dto.Chescvalcai;
import org.profamilia.hc.model.dto.Chevolucion;
import org.profamilia.hc.model.dto.Chexamfisico;
import org.profamilia.hc.model.dto.Chformulaesp;
import org.profamilia.hc.model.dto.ChformulaespPK;
import org.profamilia.hc.model.dto.Chformulahos;
import org.profamilia.hc.model.dto.ChformulahosPK;
import org.profamilia.hc.model.dto.Chformulaliq;
import org.profamilia.hc.model.dto.ChformulaliqPK;
import org.profamilia.hc.model.dto.Chformulamed;
import org.profamilia.hc.model.dto.ChformulamedPK;
import org.profamilia.hc.model.dto.Chhallahistero;
import org.profamilia.hc.model.dto.Chhisteroscopia;
import org.profamilia.hc.model.dto.Chimprdiag;
import org.profamilia.hc.model.dto.Chincapacida;
import org.profamilia.hc.model.dto.Chingresoenf;
import org.profamilia.hc.model.dto.Chinstrument;
import org.profamilia.hc.model.dto.Chitemmater;
import org.profamilia.hc.model.dto.Chitempaque;
import org.profamilia.hc.model.dto.Chitemvrquir;
import org.profamilia.hc.model.dto.ChitemvrquirPK;
import org.profamilia.hc.model.dto.Chmaterinstr;
import org.profamilia.hc.model.dto.Chmotivocon;
import org.profamilia.hc.model.dto.Chnotaenferm;
import org.profamilia.hc.model.dto.Chotraorden;
import org.profamilia.hc.model.dto.Chpamecindic;
import org.profamilia.hc.model.dto.Chpamecpregu;
import org.profamilia.hc.model.dto.Chpamectema;
import org.profamilia.hc.model.dto.Chpaqueester;
import org.profamilia.hc.model.dto.Chparavrqui;
import org.profamilia.hc.model.dto.Chpermitema;
import org.profamilia.hc.model.dto.Chrefepaci;
import org.profamilia.hc.model.dto.Chregicirpro;
import org.profamilia.hc.model.dto.Chregiconpro;
import org.profamilia.hc.model.dto.Chrevissiste;
import org.profamilia.hc.model.dto.Chsalaxprofe;
import org.profamilia.hc.model.dto.Chsegutelefo;
import org.profamilia.hc.model.dto.Chsignovital;
import org.profamilia.hc.model.dto.Chusuario;
import org.profamilia.hc.model.dto.Chvademecum;
import org.profamilia.hc.model.dto.Chvademprof;
import org.profamilia.hc.model.dto.Chverquirofa;
import org.profamilia.hc.model.dto.Cnconsclin;
import org.profamilia.hc.model.dto.Cnprofxcon;
import org.profamilia.hc.model.dto.Cpcontrato;
import org.profamilia.hc.model.dto.Cppaquserv;
import org.profamilia.hc.model.dto.Cpprofesio;
import org.profamilia.hc.model.dto.Cpservicio;
import org.profamilia.hc.model.dto.Cptarxprof;
import org.profamilia.hc.model.dto.Cptipconcl;
import org.profamilia.hc.model.dto.Cptipocont;
import org.profamilia.hc.model.dto.Cptipodocu;
import org.profamilia.hc.model.dto.Cpusuario;
import org.profamilia.hc.model.dto.Crarcproce;
import org.profamilia.hc.model.dto.CrarcproceId;
import org.profamilia.hc.model.dto.Crcausaext;
import org.profamilia.hc.model.dto.Crfinalcon;
import org.profamilia.hc.model.dto.Crripsserv;
import org.profamilia.hc.model.dto.CrripsservId;
import org.profamilia.hc.model.dto.Crripxclin;
import org.profamilia.hc.model.exceptions.ModelException;
import org.profamilia.hc.view.constantes.IConstantes;
import org.springframework.orm.hibernate3.HibernateCallback;
import org.springframework.orm.hibernate3.support.HibernateDaoSupport;


public class CirugiaDaoImp extends HibernateDaoSupport implements CirugiaDao {

    public CirugiaDaoImp() {
        super();
    }
    /**
     * @param tema
     * @throws ModelException
     */
    public void saveTema(final Chpamectema tema) throws ModelException {
        try {
            this.getHibernateTemplate().execute(new HibernateCallback() {
                        public Object doInHibernate(Session session) {
                            Integer consecutivo = null;
                            if (tema != null) {


                                if (tema.getHptncodigo() == null) {
                                    StringBuffer sb1 = new StringBuffer();
                                    sb1.append(" select max(chpt.hptncodigo) from " + 
                                               Chpamectema.class.getName() + 
                                               " chpt  ");
                                    Query query1 = 
                                        session.createQuery(sb1.toString());

                                    Integer secuenciaActual = 
                                        (Integer)query1.uniqueResult();

                                    if (secuenciaActual != null) {
                                        consecutivo = 
                                                secuenciaActual.intValue() + 1;
                                    } else {
                                        consecutivo = 1;
                                    }
                                    if (consecutivo != null) {
                                        tema.setHptncodigo(consecutivo);
                                    }
                                }


                                session.saveOrUpdate(tema);

                            }


                            return tema;
                        }
                    });
        } catch (HibernateException e) {
            throw new ModelException("Error Insertando :" + e.getMessage(), e);
        } catch (Exception e) {
            throw new ModelException("Error Insertando :" + e.getMessage(), e);
        }
    }


    /**
     * @return
     * @throws ModelException
     */
    public List<Chpamectema> getListaTemasPamec() throws ModelException {
        List<Chpamectema> resultList = null;
        List parametros = new ArrayList();

        try {

            StringBuffer sb = new StringBuffer();
            sb.append(" select chpt from " + Chpamectema.class.getName() + 
                      " chpt  where chpt.hptcestado  in ('AC', 'IN') order by  chpt.hptncodigo ");


            resultList = 
                    (List<Chpamectema>) this.getHibernateTemplate().find(sb.toString(), parametros.toArray());


            if (!resultList.isEmpty()) {
                return resultList;
            }


            return null;

        } catch (HibernateException e) {
            throw new ModelException("Error consultando temas PAMEC:" + 
                                     e.getMessage(), e);
        } catch (Exception e) {
            throw new ModelException("Error consultando temas PAMEC:" + 
                                     e.getMessage(), e);
        }

    }


    /**
     * @param tema
     * @throws ModelException
     */

    /**
     * @param tema
     * @throws ModelException
     */
    public void deleteTemaPamec(Chpamectema tema) throws ModelException {
        try {
            this.getHibernateTemplate().delete(tema);
        } catch (HibernateException e) {
            throw new ModelException("Error Eliminando tema:" + e.getMessage(), 
                                     e);
        } catch (Exception e) {
            throw new ModelException("Error Eliminando tema:" + e.getMessage(), 
                                     e);
        }
    }


    /**
     * @param tema
     * @throws ModelException
     */
    public void updateTemaPamec(Chpamectema tema) throws ModelException {
        try {
            this.getHibernateTemplate().update(tema);
        } catch (HibernateException e) {
            throw new ModelException("Error actualizando tema:" + 
                                     e.getMessage(), e);
        } catch (Exception e) {
            throw new ModelException("Error actualizando tema:" + 
                                     e.getMessage(), e);
        }
    }


    /**
     * @param indicador
     * @throws ModelException
     */
    public void saveIndicador(final Chpamecindic indicador) throws ModelException {
        try {
            this.getHibernateTemplate().execute(new HibernateCallback() {
                        public Object doInHibernate(Session session) {
                            Integer consecutivo = null;
                            if (indicador != null) {


                                if (indicador.getId().getHpincodigo() == 
                                    null) {


                                    StringBuffer sb1 = new StringBuffer();
                                    sb1.append(" select max(chpi.id.hpincodigo) from " + 
                                               Chpamecindic.class.getName() + 
                                               " chpi where chpi.id.hpincodigtema = :hpincodigtema ");
                                    Query query1 = 
                                        session.createQuery(sb1.toString());
                                    query1.setParameter("hpincodigtema", 
                                                        indicador.getId().getHpincodigtema());

                                    Integer secuenciaActual = 
                                        (Integer)query1.uniqueResult();

                                    if (secuenciaActual != null) {
                                        consecutivo = 
                                                secuenciaActual.intValue() + 1;
                                    } else {
                                        consecutivo = 1;
                                    }
                                    if (consecutivo != null) {
                                        indicador.getId().setHpincodigo(consecutivo);
                                    }
                                }


                                session.saveOrUpdate(indicador);

                            }


                            return indicador;
                        }
                    });
        } catch (HibernateException e) {
            throw new ModelException("Error Insertando :" + e.getMessage(), e);
        } catch (Exception e) {
            throw new ModelException("Error Insertando :" + e.getMessage(), e);
        }
    }


    /**
     * @return
     * @throws ModelException
     */
    public List<Chpamecindic> getListaIndicadorPamec(Integer codigtema) throws ModelException {
        List<Chpamecindic> resultList = null;
        List parametros = new ArrayList();

        try {

            if (codigtema != null) {
                StringBuffer sb = new StringBuffer();
                sb.append(" select chpi from " + Chpamecindic.class.getName() + 
                          " chpi  where chpi.hpicestado in ('AC', 'IN')  ");
                sb.append(" and chpi.id.hpincodigtema = ? ");
                sb.append(" order by  chpi.id.hpincodigo ");
                parametros.add(codigtema);


                resultList = 
                        (List<Chpamecindic>) this.getHibernateTemplate().find(sb.toString(), parametros.toArray());


                if (!resultList.isEmpty()) {
                    return resultList;
                }
            }


            return null;

        } catch (HibernateException e) {
            throw new ModelException("Error consultando indicadores x tema PAMEC:" + 
                                     e.getMessage(), e);
        } catch (Exception e) {
            throw new ModelException("Error consultando indicadores x tema PAMEC:" + 
                                     e.getMessage(), e);
        }

    }


    /**
     * @param indicador
     * @throws ModelException
     */
    public void deleteIndicadorPamec(Chpamecindic indicador) throws ModelException {
        try {
            this.getHibernateTemplate().delete(indicador);
        } catch (HibernateException e) {
            throw new ModelException("Error Eliminando indicador:" + 
                                     e.getMessage(), e);
        } catch (Exception e) {
            throw new ModelException("Error Eliminando indicador:" + 
                                     e.getMessage(), e);
        }
    }


    /**
     * @param indicador
     * @throws ModelException
     */
    public void updateIndicadorPamec(Chpamecindic indicador) throws ModelException {
        try {
            this.getHibernateTemplate().update(indicador);
        } catch (HibernateException e) {
            throw new ModelException("Error actualizando Indicador:" + 
                                     e.getMessage(), e);
        } catch (Exception e) {
            throw new ModelException("Error actualizando Indicador:" + 
                                     e.getMessage(), e);
        }
    }


    /**
     * @param pregunta
     * @throws ModelException
     */
    public void savePregunta(final Chpamecpregu pregunta) throws ModelException {
        try {
            this.getHibernateTemplate().execute(new HibernateCallback() {
                        public Object doInHibernate(Session session) {
                            Integer consecutivo = null;
                            if (pregunta != null) {


                                if (pregunta.getId().getHppncodigo() == null) {


                                    StringBuffer sb1 = new StringBuffer();
                                    sb1.append(" select max(chpp.id.hppncodigo) from " + 
                                               Chpamecpregu.class.getName() + 
                                               " chpp where chpp.id.hppncodigtema = :hppncodigtema and chpp.id.hppncodigindic = :hppncodigindic  ");
                                    Query query1 = 
                                        session.createQuery(sb1.toString());
                                    query1.setParameter("hppncodigtema", 
                                                        pregunta.getId().getHppncodigtema());
                                    query1.setParameter("hppncodigindic", 
                                                        pregunta.getId().getHppncodigindic());

                                    Integer secuenciaActual = 
                                        (Integer)query1.uniqueResult();

                                    if (secuenciaActual != null) {
                                        consecutivo = 
                                                secuenciaActual.intValue() + 1;
                                    } else {
                                        consecutivo = 1;
                                    }
                                    if (consecutivo != null) {
                                        pregunta.getId().setHppncodigo(consecutivo);
                                    }
                                }


                                session.saveOrUpdate(pregunta);

                            }


                            return pregunta;
                        }
                    });
        } catch (HibernateException e) {
            throw new ModelException("Error Insertando :" + e.getMessage(), e);
        } catch (Exception e) {
            throw new ModelException("Error Insertando :" + e.getMessage(), e);
        }
    }


    /**
     * @return
     * @throws ModelException
     */
    public List<Chpamecpregu> getListaPreguntaPamec(Integer codigtema, 
                                                    Integer codigindi) throws ModelException {
        List<Chpamecpregu> resultList = null;
        List parametros = new ArrayList();

        try {

            if (codigtema != null && codigindi != null) {
                StringBuffer sb = new StringBuffer();
                sb.append(" select chpp from " + Chpamecpregu.class.getName() + 
                          " chpp  where chpp.hppcestado in ('AC', 'IN')  ");
                sb.append(" and chpp.id.hppncodigtema = ? and chpp.id.hppncodigindic = ?  ");
                sb.append(" order by  chpp.id.hppncodigo ");

                parametros.add(codigtema);
                parametros.add(codigindi);


                resultList = 
                        (List<Chpamecpregu>) this.getHibernateTemplate().find(sb.toString(), parametros.toArray());


                if (!resultList.isEmpty()) {
                    return resultList;
                }
            }


            return null;

        } catch (HibernateException e) {
            throw new ModelException("Error consultando preguntas x indicador PAMEC:" + 
                                     e.getMessage(), e);
        } catch (Exception e) {
            throw new ModelException("Error consultando preguntas x indicador PAMEC:" + 
                                     e.getMessage(), e);
        }

    }


    /**
     * @param pregunta
     * @throws ModelException
     */
    public void deletePreguntaPamec(Chpamecpregu pregunta) throws ModelException {
        try {
            this.getHibernateTemplate().delete(pregunta);
        } catch (HibernateException e) {
            throw new ModelException("Error Eliminando pregunta:" + 
                                     e.getMessage(), e);
        } catch (Exception e) {
            throw new ModelException("Error Eliminando pregunta:" + 
                                     e.getMessage(), e);
        }
    }


    /**
     * @param pregunta
     * @throws ModelException
     */
    public void updatePreguntaPamec(Chpamecpregu pregunta) throws ModelException {
        try {
            this.getHibernateTemplate().update(pregunta);
        } catch (HibernateException e) {
            throw new ModelException("Error actualizando Pregunta:" + 
                                     e.getMessage(), e);
        } catch (Exception e) {
            throw new ModelException("Error actualizando Pregunta:" + 
                                     e.getMessage(), e);
        }
    }


    /**
     * @param wcodclin
     * @param wanno
     * @param wcodtema
     * @param wcodind
     * @return
     * @throws ModelException
     */
    public List<Object[]> getCuestionarioPreguntaPamec(Integer wcodclin, 
                                                       Integer wanno, 
                                                       Integer wcodtema, 
                                                       Integer wcodind) throws ModelException {
        List resultList = null;


        try {
            if (wcodclin != null && wanno != null && wcodtema != null && 
                wcodind != null) {
                StringBuffer sb = new StringBuffer();
                sb.append(" select chpp.hppncodigo, chpp.hppncodigtema, chpp.hppncodigindic, chpp.hppcdescripcio, chcp.hcpnmesenero, ");
                sb.append(" chcp.hcpnmesfebre,chcp.hcpnmesmarzo,chcp.hcpnmesabril,chcp.hcpnmesmayo,chcp.hcpnmesjunio,chcp.hcpnmesjulio, ");
                sb.append(" chcp.hcpnmesagost,chcp.hcpnmessepti,chcp.hcpnmesoctub,chcp.hcpnmesnovie,chcp.hcpnmesdicie ");
                sb.append(" from historia.chpamecpregu chpp ");
                sb.append(" left join historia.chcuestpamec chcp ON chcp.hcpncodigpregu = chpp.hppncodigo and chcp.hcpncodigtema = chpp.hppncodigtema ");
                sb.append(" and chcp.hcpncodigindic = chpp.hppncodigindic and chcp.hcpncodigclini = :wcodclin and chcp.hcpnanno = :wanno ");
                sb.append(" where chpp.hppncodigtema = :wcodtema and chpp.hppncodigindic = :wcodind and chpp.hppcestado = 'AC' ");
                sb.append(" order by chpp.hppncodigo ");

                Query sqlquery = 
                    this.getHibernateTemplate().getSessionFactory().getCurrentSession().createQuery(sb.toString());
                sqlquery.setParameter("wcodclin", wcodclin);
                sqlquery.setParameter("wanno", wanno);
                sqlquery.setParameter("wcodtema", wcodtema);
                sqlquery.setParameter("wcodind", wcodind);

                resultList = sqlquery.list();

                if (!resultList.isEmpty()) {
                    return resultList;
                }
            }
            return null;

        } catch (HibernateException e) {
            throw new ModelException("Error consultando Cuestionario PAMEC :" + 
                                     e.getMessage(), e);
        } catch (Exception e) {
            throw new ModelException("Error consultando Cuestionario PAMEC : " + 
                                     e.getMessage(), e);
        }

    }


    /**
     * @param lstPregunta
     * @throws ModelException
     */
    public void saveCuestionario(final List<Chcuestpamec> lstPregunta) throws ModelException {
        try {
            this.getHibernateTemplate().execute(new HibernateCallback() {
                        public Object doInHibernate(Session session) {

                            if (lstPregunta != null) {
                                for (Chcuestpamec cuestpamec: lstPregunta) {
                                    Chcuestpamec cuestpamecAux = null;

                                    StringBuffer sb = new StringBuffer();
                                    sb.append(" select chcp from Chcuestpamec");
                                    sb.append(" chcp  where chcp.id.hcpncodigpregu = :hcpncodigpregu ");
                                    sb.append(" AND chcp.id.hcpncodigtema = :hcpncodigtema ");
                                    sb.append(" AND chcp.id.hcpncodigindic = :hcpncodigindic ");
                                    sb.append(" AND chcp.id.hcpncodigclini = :hcpncodigclini ");
                                    sb.append(" AND chcp.id.hcpnanno = :hcpnanno ");
                                    Query query = 
                                        session.createQuery(sb.toString());
                                    query.setParameter("hcpncodigpregu", 
                                                       cuestpamec.getId().getHcpncodigpregu());
                                    query.setParameter("hcpncodigtema", 
                                                       cuestpamec.getId().getHcpncodigtema());
                                    query.setParameter("hcpncodigindic", 
                                                       cuestpamec.getId().getHcpncodigindic());
                                    query.setParameter("hcpncodigclini", 
                                                       cuestpamec.getId().getHcpncodigclini());
                                    query.setParameter("hcpnanno", 
                                                       cuestpamec.getId().getHcpnanno());

                                    cuestpamecAux = 
                                            (Chcuestpamec)query.uniqueResult();

                                    if (cuestpamecAux == null) {
                                        cuestpamecAux = new Chcuestpamec();
                                    }

                                    if (cuestpamecAux != null) {
                                        cuestpamecAux.getId().setHcpnanno(cuestpamec.getId().getHcpnanno());
                                        cuestpamecAux.getId().setHcpncodigclini(cuestpamec.getId().getHcpncodigclini());
                                        cuestpamecAux.getId().setHcpncodigindic(cuestpamec.getId().getHcpncodigindic());
                                        cuestpamecAux.getId().setHcpncodigpregu(cuestpamec.getId().getHcpncodigpregu());
                                        cuestpamecAux.getId().setHcpncodigtema(cuestpamec.getId().getHcpncodigtema());
                                        cuestpamecAux.setHcpnmesenero(cuestpamec.getHcpnmesenero());
                                        cuestpamecAux.setHcpnmesfebre(cuestpamec.getHcpnmesfebre());
                                        cuestpamecAux.setHcpnmesmarzo(cuestpamec.getHcpnmesmarzo());
                                        cuestpamecAux.setHcpnmesabril(cuestpamec.getHcpnmesabril());
                                        cuestpamecAux.setHcpnmesmayo(cuestpamec.getHcpnmesmayo());
                                        cuestpamecAux.setHcpnmesjunio(cuestpamec.getHcpnmesjunio());
                                        cuestpamecAux.setHcpnmesjulio(cuestpamec.getHcpnmesjulio());
                                        cuestpamecAux.setHcpnmesagost(cuestpamec.getHcpnmesagost());
                                        cuestpamecAux.setHcpnmessepti(cuestpamec.getHcpnmessepti());
                                        cuestpamecAux.setHcpnmesoctub(cuestpamec.getHcpnmesoctub());
                                        cuestpamecAux.setHcpnmesnovie(cuestpamec.getHcpnmesnovie());
                                        cuestpamecAux.setHcpnmesdicie(cuestpamec.getHcpnmesdicie());

                                        cuestpamecAux.setHppcestado(cuestpamec.getHppcestado());
                                        cuestpamecAux.setHppcoperador(cuestpamec.getHppcoperador());
                                        cuestpamecAux.setHppdfecregistr(cuestpamec.getHppdfecregistr());

                                        session.saveOrUpdate(cuestpamecAux);
                                    }

                                }
                            }


                            return lstPregunta;
                        }
                    });
        } catch (HibernateException e) {
            throw new ModelException("Error Insertando :" + e.getMessage(), e);
        } catch (Exception e) {
            throw new ModelException("Error Insertando :" + e.getMessage(), e);
        }
    }


    /**
     * @return
     * @throws ModelException
     */
    public List<Object[]> getCuestionarioTemasPamec(String wusuario, 
                                                    Integer wclinica) throws ModelException {
        List resultList = null;

        try {


            StringBuffer sb = new StringBuffer();
            sb.append("  select chpt.hptncodigo, chpt.hptcdescripcio from historia.chpamectema chpt ");
            sb.append("  where chpt.hptcestado = 'AC' ");
            sb.append(" and chpt.hptncodigo in (select hptncodigtema from historia.chpermitema where hptcusuarpamec = :wusuario and hptncodigclini = :wclinica) ");
            sb.append("  order by chpt.hptncodigo ");

            Query sqlquery = 
                this.getHibernateTemplate().getSessionFactory().getCurrentSession().createQuery(sb.toString());
            sqlquery.setParameter("wusuario", wusuario);
            sqlquery.setParameter("wclinica", wclinica);

            resultList = sqlquery.list();


            if (!resultList.isEmpty()) {
                return resultList;
            }


            return null;

        } catch (HibernateException e) {
            throw new ModelException("Error consultando indicadores x tema PAMEC:" + 
                                     e.getMessage(), e);
        } catch (Exception e) {
            throw new ModelException("Error consultando indicadores x tema PAMEC:" + 
                                     e.getMessage(), e);
        }

    }


    /**
     * @return
     * @throws ModelException
     */
    public List<Object[]> getCuestionarioIndicadorPamec(Integer wcodtema) throws ModelException {
        List resultList = null;
        List parametros = new ArrayList();

        try {

            if (wcodtema != null) {


                StringBuffer sb = new StringBuffer();
                sb.append("  select chpi.hpincodigo, chpi.hpincodigtema, chpi.hpicdescripcio from historia.chpamecindic  chpi ");
                sb.append("  where chpi.hpicestado =  'AC' and chpi.hpincodigtema = :wcodtema ");
                sb.append("  order by chpi.hpincodigo ");


                Query sqlquery = 
                    this.getHibernateTemplate().getSessionFactory().getCurrentSession().createQuery(sb.toString());
                sqlquery.setParameter("wcodtema", wcodtema);


                resultList = sqlquery.list();


                if (!resultList.isEmpty()) {
                    return resultList;
                }
            }


            return null;

        } catch (HibernateException e) {
            throw new ModelException("Error consultando indicadores x tema PAMEC:" + 
                                     e.getMessage(), e);
        } catch (Exception e) {
            throw new ModelException("Error consultando indicadores x tema PAMEC:" + 
                                     e.getMessage(), e);
        }

    }


    /**
     * @param wcoditema
     * @param wanno
     * @param wmes
     * @param wcodclin
     * @return
     * @throws ModelException
     */
    public boolean verificarTema(final Integer wcoditema, final Integer wanno, 
                                 final Integer wmes, 
                                 final Integer wcodclin) throws ModelException {
        Boolean pis = 
            (Boolean)getHibernateTemplate().execute(new HibernateCallback() {
                    public Object doInHibernate(Session session) throws HibernateException {

                        String sqlmes = "";

                        if (wmes != null) {
                            if (wmes.intValue() == 1) {
                                sqlmes = "chcp.hcpnmesenero";
                            } else if (wmes.intValue() == 2) {
                                sqlmes = "chcp.hcpnmesfebre";
                            } else if (wmes.intValue() == 3) {
                                sqlmes = "chcp.hcpnmesmarzo";
                            } else if (wmes.intValue() == 4) {
                                sqlmes = "chcp.hcpnmesabril";
                            } else if (wmes.intValue() == 5) {
                                sqlmes = "chcp.hcpnmesmayo";
                            } else if (wmes.intValue() == 6) {
                                sqlmes = "chcp.hcpnmesjunio";
                            } else if (wmes.intValue() == 7) {
                                sqlmes = "chcp.hcpnmesjulio";
                            } else if (wmes.intValue() == 8) {
                                sqlmes = "chcp.hcpnmesagost";
                            } else if (wmes.intValue() == 9) {
                                sqlmes = "chcp.hcpnmessepti";
                            } else if (wmes.intValue() == 10) {
                                sqlmes = "chcp.hcpnmesoctub";
                            } else if (wmes.intValue() == 11) {
                                sqlmes = "chcp.hcpnmesnovie";
                            } else if (wmes.intValue() == 12) {
                                sqlmes = "chcp.hcpnmesdicie";
                            }
                        }


                        if (wcoditema != null && wanno != null && 
                            wmes != null) {
                            StringBuffer sb = new StringBuffer();

                            sb.append(" select count(tema)  from( ");
                            sb.append(" select ").append(sqlmes).append(" mes, chpp.hppncodigtema tema  ");
                            sb.append(" from historia.chpamecpregu chpp  ");
                            sb.append(" LEFT JOIN historia.chcuestpamec chcp  ");
                            sb.append(" ON chcp.hcpncodigpregu = chpp.hppncodigo ");
                            sb.append(" AND chcp.hcpncodigtema = chpp.hppncodigtema ");
                            sb.append(" AND chcp.hcpncodigindic = chpp.hppncodigindic  ");
                            sb.append(" AND chcp.hcpncodigclini = :wcodclin AND chcp.hcpnanno = :wanno ");
                            sb.append(" where chpp.hppncodigtema = :wcoditema and chpp.hppcestado = 'AC') ");
                            sb.append(" where mes is null  ");
                            String hql = sb.toString();

                            Query query = session.createQuery(hql);

                            query.setParameter("wcodclin", wcodclin);
                            query.setParameter("wcoditema", wcoditema);
                            query.setParameter("wanno", wanno);

                            BigDecimal wtotal;
                            wtotal = null;

                            wtotal = (BigDecimal)query.uniqueResult();

                            if (wtotal.intValue() == 0) {
                                return true;
                            } else {
                                return false;
                            }


                        }
                        return false;
                    }
                });
        return pis;
    }


    /**
     * @param wcoditema
     * @param wcodigindic
     * @param wanno
     * @param wmes
     * @param wcodclin
     * @return
     * @throws ModelException
     */
    public boolean verificarIndicador(final Integer wcoditema, 
                                      final Integer wcodigindic, 
                                      final Integer wanno, final Integer wmes, 
                                      final Integer wcodclin) throws ModelException {
        Boolean pis = 
            (Boolean)getHibernateTemplate().execute(new HibernateCallback() {
                    public Object doInHibernate(Session session) throws HibernateException {

                        String sqlmes = "";

                        if (wmes != null) {
                            if (wmes.intValue() == 1) {
                                sqlmes = "chcp.hcpnmesenero";
                            } else if (wmes.intValue() == 2) {
                                sqlmes = "chcp.hcpnmesfebre";
                            } else if (wmes.intValue() == 3) {
                                sqlmes = "chcp.hcpnmesmarzo";
                            } else if (wmes.intValue() == 4) {
                                sqlmes = "chcp.hcpnmesabril";
                            } else if (wmes.intValue() == 5) {
                                sqlmes = "chcp.hcpnmesmayo";
                            } else if (wmes.intValue() == 6) {
                                sqlmes = "chcp.hcpnmesjunio";
                            } else if (wmes.intValue() == 7) {
                                sqlmes = "chcp.hcpnmesjulio";
                            } else if (wmes.intValue() == 8) {
                                sqlmes = "chcp.hcpnmesagost";
                            } else if (wmes.intValue() == 9) {
                                sqlmes = "chcp.hcpnmessepti";
                            } else if (wmes.intValue() == 10) {
                                sqlmes = "chcp.hcpnmesoctub";
                            } else if (wmes.intValue() == 11) {
                                sqlmes = "chcp.hcpnmesnovie";
                            } else if (wmes.intValue() == 12) {
                                sqlmes = "chcp.hcpnmesdicie";
                            }
                        }


                        if (wcoditema != null && wanno != null && 
                            wmes != null) {
                            StringBuffer sb = new StringBuffer();

                            sb.append(" select count(tema)  from( ");
                            sb.append(" select ").append(sqlmes).append(" mes, chpp.hppncodigtema tema  ");
                            sb.append(" from historia.chpamecpregu chpp  ");
                            sb.append(" LEFT JOIN historia.chcuestpamec chcp  ");
                            sb.append(" ON chcp.hcpncodigpregu = chpp.hppncodigo ");
                            sb.append(" AND chcp.hcpncodigtema = chpp.hppncodigtema ");
                            sb.append(" AND chcp.hcpncodigindic = chpp.hppncodigindic  ");
                            sb.append(" AND chcp.hcpncodigclini = :wcodclin AND chcp.hcpnanno = :wanno ");
                            sb.append(" where chpp.hppncodigtema = :wcoditema AND chpp.hppncodigindic = :wcodigindic and chpp.hppcestado = 'AC') ");
                            sb.append(" where mes is null  ");
                            String hql = sb.toString();

                            Query query = session.createQuery(hql);

                            query.setParameter("wcodclin", wcodclin);
                            query.setParameter("wcoditema", wcoditema);
                            query.setParameter("wanno", wanno);
                            query.setParameter("wcodigindic", wcodigindic);

                            BigDecimal wtotal;
                            wtotal = null;

                            wtotal = (BigDecimal)query.uniqueResult();

                            if (wtotal.intValue() == 0) {
                                return true;
                            } else {
                                return false;
                            }


                        }
                        return false;
                    }
                });
        return pis;
    }


    /**
     * @param wcodclin
     * @param wcodigoTema
     * @param wanno
     * @return
     * @throws ModelException
     */
    public List<Object[]> getReportePamec(Integer wcodclin, 
                                          Integer wcodigoTema, 
                                          Integer wanno) throws ModelException {
        List resultList = null;
        List parametros = new ArrayList();

        try {

            if (wcodclin != null && wcodigoTema != null && wanno != null) {


                StringBuffer sb = new StringBuffer();
                sb.append("  select chpt.hptncodigo, chpt.hptcdescripcio, chpi.hpincodigo, chpi.hpicdescripcio,  ");
                sb.append("  chpp.hppncodigo, chpp.hppcdescripcio, chcp.hcpncodigclini, chcp.hcpnanno, chcp.hcpnmesenero, ");
                sb.append("  chcp.hcpnmesfebre, chcp.hcpnmesmarzo, chcp.hcpnmesabril, chcp.hcpnmesmayo, chcp.hcpnmesjunio, ");
                sb.append("  chcp.hcpnmesjulio, chcp.hcpnmesagost, chcp.hcpnmessepti, chcp.hcpnmesoctub, chcp.hcpnmesnovie, chcp.hcpnmesdicie ");
                sb.append("  from historia.chcuestpamec chcp, historia.chpamectema chpt, historia.chpamecindic chpi, historia.chpamecpregu chpp ");
                sb.append("  where chcp.hcpncodigtema = chpt.hptncodigo ");
                sb.append("  and chcp.hcpncodigtema = chpi.hpincodigtema and chcp.hcpncodigindic = chpi.hpincodigo ");
                sb.append("  and chcp.hcpncodigtema = chpp.hppncodigtema and chcp.hcpncodigindic = chpp.hppncodigindic and chcp.hcpncodigpregu = chpp.hppncodigo ");
                sb.append("  and chpt.hptcestado = 'AC' and chpi.hpicestado = 'AC' and chpp.hppcestado = 'AC'  ");
                sb.append("  and chcp.hcpnanno = :wanno  ");
                if (wcodclin != 0) {
                    sb.append(" and chcp.hcpncodigclini = :wcodclin ");
                }


                if (wcodigoTema != 0) {
                    sb.append("  and chcp.hcpncodigtema = :wcodigoTema  ");
                }

                sb.append("  order by chcp.hcpncodigtema, chcp.hcpncodigindic, chcp.hcpncodigpregu ");


                Query sqlquery = 
                    this.getHibernateTemplate().getSessionFactory().getCurrentSession().createQuery(sb.toString());
                sqlquery.setParameter("wanno", wanno);
                if (wcodclin != 0) {
                    sqlquery.setParameter("wcodclin", wcodclin);
                }

                if (wcodigoTema != 0) {
                    sqlquery.setParameter("wcodigoTema", wcodigoTema);
                }


                resultList = sqlquery.list();


                if (!resultList.isEmpty()) {
                    return resultList;
                }
            }


            return null;

        } catch (HibernateException e) {
            throw new ModelException("Error consultando reporte PAMEC:" + 
                                     e.getMessage(), e);
        } catch (Exception e) {
            throw new ModelException("Error consultando reporte PAMEC:" + 
                                     e.getMessage(), e);
        }

    }


    /**
     * @param codClinica
     * @return
     * @throws ModelException
     */
    public List<Object[]> getListaUsuariosPorClinica(Integer codClinica) throws ModelException {
        List resultList = null;
        List parametros = new ArrayList();

        try {

            if (codClinica != null) {


                StringBuffer sb = new StringBuffer();
                sb.append("select cpus.curcusuari, curcnombre  ");
                sb.append(" from clinico.Cpusuario cpus ");
                sb.append(" where cpus.curnclinic = :codClinica and cpus.curcactivo = 'S' ");
                sb.append(" order by cpus.curcnombre ");

                Query sqlquery = 
                    this.getHibernateTemplate().getSessionFactory().getCurrentSession().createQuery(sb.toString());
                sqlquery.setParameter("codClinica", codClinica);
                resultList = sqlquery.list();


                if (!resultList.isEmpty()) {
                    return resultList;
                }
            }

            return null;

        } catch (HibernateException e) {
            throw new ModelException("Error consultando usuarios por clinica:" + 
                                     e.getMessage(), e);
        } catch (Exception e) {
            throw new ModelException("Error consultando usuarios por clinica:" + 
                                     e.getMessage(), e);
        }

    }


    /**
     * @param tema
     * @throws ModelException
     */
    public void savePermisoTemaPamec(Chpermitema tema) throws ModelException {
        try {
            this.getHibernateTemplate().saveOrUpdate(tema);
        } catch (HibernateException e) {
            throw new ModelException("Error insertando permisos tema:" + 
                                     e.getMessage(), e);
        } catch (Exception e) {
            throw new ModelException("Error insertando permisos tema:" + 
                                     e.getMessage(), e);
        }
    }


    /**
     * @param codigtema
     * @param codclinica
     * @param usuario
     * @return
     * @throws ModelException
     */
    public Chpermitema getPermisoTemaPamec(Integer codigtema, 
                                           Integer codclinica, 
                                           String usuario) throws ModelException {
        List<Chpermitema> resultList = null;
        List parametros = new ArrayList();

        try {

            if (codigtema != null) {
                StringBuffer sb = new StringBuffer();
                sb.append(" select chpt from " + Chpermitema.class.getName() + 
                          " chpt  where chpt.id.hptncodigtema = ? ");
                sb.append(" and chpt.id.hptncodigclini = ? ");
                sb.append(" and chpt.id.hptcusuarpamec = ? ");
                parametros.add(codigtema);
                parametros.add(codclinica);
                parametros.add(usuario);


                resultList = 
                        (List<Chpermitema>) this.getHibernateTemplate().find(sb.toString(), parametros.toArray());


                if (!resultList.isEmpty()) {
                    return resultList.get(0);
                }
            }


            return null;

        } catch (HibernateException e) {
            throw new ModelException("Error consultando permiso PAMEC:" + 
                                     e.getMessage(), e);
        } catch (Exception e) {
            throw new ModelException("Error consultando permiso PAMEC:" + 
                                     e.getMessage(), e);
        }

    }


    /**
     * @param codigtema
     * @param codclinica
     * @return
     * @throws ModelException
     */
    public List<Object[]> getListaPermisoTemaPamec(Integer codigtema, 
                                                   Integer codclinica) throws ModelException {
        List resultList = null;
        List parametros = new ArrayList();

        try {

            if (codclinica != null) {


                StringBuffer sb = new StringBuffer();
                sb.append(" select chpa.hptncodigo, chpa.hptcdescripcio, chpt.hptcusuarpamec, cpus.curcnombre, chpt.hptncodigclini  ");
                sb.append(" from historia.chpermitema chpt, historia.chpamectema chpa, clinico.cpusuario cpus ");
                sb.append(" where chpa.hptncodigo = chpt.hptncodigtema ");
                sb.append(" and cpus.curcusuari = chpt.hptcusuarpamec ");
                sb.append(" and chpt.hptncodigclini  = :codclinica ");

                Query sqlquery = 
                    this.getHibernateTemplate().getSessionFactory().getCurrentSession().createQuery(sb.toString());
                sqlquery.setParameter("codclinica", codclinica);
                resultList = sqlquery.list();


                if (!resultList.isEmpty()) {
                    return resultList;
                }
            }

            return null;

        } catch (HibernateException e) {
            throw new ModelException("Error consultando lista permisos pamec:" + 
                                     e.getMessage(), e);
        } catch (Exception e) {
            throw new ModelException("Error consultando lista permisos pamec:" + 
                                     e.getMessage(), e);
        }

    }


    /**
     * @param tema
     * @throws ModelException
     */
    public void deletePermisoTemaPamec(Chpermitema tema) throws ModelException {
        try {
            this.getHibernateTemplate().delete(tema);
        } catch (HibernateException e) {
            throw new ModelException("Error eliminando permisos tema:" + 
                                     e.getMessage(), e);
        } catch (Exception e) {
            throw new ModelException("Error eliminando permisos tema:" + 
                                     e.getMessage(), e);
        }
    }


    /**
     * @param idTipoDocumento
     * @param numeroDocumento
     * @return
     * @throws ModelException
     */
    public List<Cnconsclin> getConsultasCirugia(final Integer idTipoDocumento, 
                                                final BigDecimal numeroDocumento, 
                                                final Chusuario usuario) throws ModelException {
        List<Cnconsclin> pis = 
            (List<Cnconsclin>)getHibernateTemplate().execute(new HibernateCallback() {
                    public Object doInHibernate(Session session) throws HibernateException {


                        if (idTipoDocumento != null && 
                            numeroDocumento != null && usuario != null && 
                            usuario.getHuslnumero() != null) {
                            StringBuffer sb = new StringBuffer();
                            sb.append(" select  cncl from ");
                            sb.append(Cnconsclin.class.getName()).append("  cncl ");
                            sb.append(" where cncl.ccocetapa = :ccocetapa ");
                            sb.append(" and cncl.ccocestado  = :ccocestado  ");
                            sb.append(" and cncl.ccontipdoc  = :ccontipdoc  ");
                            sb.append(" and cncl.ccoanumide  = :cconnumdoc  ");
                            sb.append(" and cncl.cconnumero  not in (select chdc.hdclconsuasoci from Chdetacirpro chdc where chdc.hdclusuario = :ccolusuario )  ");
                            sb.append(" and cncl.ccolusuario.huslnumero  = :ccolusuario  ");
                            sb.append(" and cncl.ccocservic.csvntipcon in (2,7,11)   ");


                            String hql = sb.toString();

                            Query query = session.createQuery(hql);
                            query.setParameter("ccocetapa", 
                                               IConstantes.ETAPA_ESPERA);
                            query.setParameter("ccocestado", 
                                               IConstantes.ESTADO_VIGENTE);
                            query.setParameter("ccontipdoc", idTipoDocumento);
                            query.setParameter("cconnumdoc", numeroDocumento);
                            query.setParameter("ccolusuario", 
                                               usuario.getHuslnumero());
                            List<Cnconsclin> pis;
                            pis = query.list();

                            for (Cnconsclin co: pis) {
                                Cpservicio servicio = co.getCcocservic();
                                Hibernate.initialize(servicio);

                                Cptipodocu tipoDoc = co.getCcontipdoc();
                                Hibernate.initialize(tipoDoc);


                            }

                            return pis;
                        }
                        return null;
                    }
                });
        return pis;
    }


    /**
     * @param tipoConsultorio
     * @param clinica
     * @return
     * @throws ModelException
     */
    public List<Chconsultori> getConsultoriosXClinica(Integer tipoConsultorio, 
                                                      Integer clinica) throws ModelException {
        List<Chconsultori> resultList = null;
        List parametros = new ArrayList();


        try {
            if (tipoConsultorio != null && clinica != null) {
                StringBuffer sb = new StringBuffer();
                sb.append(" select chcl from " + Chconsultori.class.getName());
                sb.append(" chcl  where chcl.id.hcoctipoconsu = ? ");
                sb.append(" and chcl.id.hconclinica = ? ");
                parametros.add(tipoConsultorio);
                parametros.add(clinica);

                resultList = 
                        (List<Chconsultori>) this.getHibernateTemplate().find(sb.toString(), parametros.toArray());


                if (!resultList.isEmpty()) {
                    return resultList;
                }

            }

            return null;

        } catch (HibernateException e) {
            throw new ModelException("Error consultando Salas de Cirugia - Clonica:" + 
                                     e.getMessage(), e);
        } catch (Exception e) {
            throw new ModelException("Error consultando Salas de Cirugia - Clonica:" + 
                                     e.getMessage(), e);
        }

    }


    /**
     * @param tipoConsultorio
     * @return
     * @throws ModelException
     */
    public Chconsultori getConsultoriosXId(Integer tipoConsultorio) throws ModelException {
        List<Chconsultori> resultList = null;
        List parametros = new ArrayList();
        try {
            if (tipoConsultorio != null) {
                StringBuffer sb = new StringBuffer();
                sb.append(" select chcl from " + Chconsultori.class.getName());
                sb.append(" chcl  where chcl.id.hconnumero = ? ");
                parametros.add(tipoConsultorio);
                resultList = 
                        (List<Chconsultori>) this.getHibernateTemplate().find(sb.toString(), parametros.toArray());


                if (!resultList.isEmpty()) {
                    return resultList.get(0);
                }

            }

            return null;

        } catch (HibernateException e) {
            throw new ModelException("Error consultando Salas de Cirugia - Clonica:" + 
                                     e.getMessage(), e);
        } catch (Exception e) {
            throw new ModelException("Error consultando Salas de Cirugia - Clonica:" + 
                                     e.getMessage(), e);
        }

    }


    /**
     * @param codclin
     * @return
     * @throws ModelException
     */
    public List<Cpprofesio> getListaMedicosClinica(Integer codclin) throws ModelException {
        List<Cpprofesio> resultList = null;
        List parametros = new ArrayList();

        try {
            if (codclin != null) {
                StringBuffer sb = new StringBuffer();
                sb.append(" select cppr from " + 
                          Cpprofesio.class.getName()).append(" cppr ");
                sb.append(" where  cppr.id.cpfnclinic = ? and cppr.cpfcestado = ? ");
                sb.append(" and  cppr.cpfntippro in (?,?,?,?,?,?) ");
                sb.append(" order by cppr.cpfcnombre ");
                parametros.add(codclin);
                parametros.add(IConstantes.ESTADO_VIGENTE);
                parametros.add(IConstantes.TIPO_MEDICO_ESPECIALISTA);
                parametros.add(IConstantes.TIPO_MEDICO_GENERAL);
                parametros.add(IConstantes.TIPO_MEDICO_CIRUJANO_PLASTICO);
                parametros.add(IConstantes.TIPO_CIRUJANO_GENERAL);
                parametros.add(IConstantes.TIPO_MEDICO_UROLOGO);
                parametros.add(IConstantes.TIPO_RESIDENTE);


                resultList = 
                        (List<Cpprofesio>) this.getHibernateTemplate().find(sb.toString(), parametros.toArray());


                if (!resultList.isEmpty()) {
                    return resultList;
                }

            }

            return null;

        } catch (HibernateException e) {
            throw new ModelException("Error consultando Lista de Profesionales por clinica:" + 
                                     e.getMessage(), e);
        } catch (Exception e) {
            throw new ModelException("Error consultando Lista de Profesionales por clinica:" + 
                                     e.getMessage(), e);
        }

    }

    /**
     * @param clinica
     * @param sala
     * @param fecha
     * @param duracion
     * @return
     * @throws ModelException
     */
    public boolean verificarDisponibilidadSala(Integer clinica, Integer sala, 
                                               Date fecha, Integer duracion, 
                                               Long numeroCirugia) throws ModelException {
        List<Chcirugprogr> resultList = null;
        List parametros = new ArrayList();
        Date fechafinal = null;

        Calendar fechaAuxInicial = Calendar.getInstance();
        fechaAuxInicial.setTime(fecha);
        // Le sumamos un minuto a la fecha inicial porque el between no es excluyente

        fechaAuxInicial.add(Calendar.MINUTE, 1);
        fecha = fechaAuxInicial.getTime();

        Calendar fechaAuxFinal = Calendar.getInstance();
        fechaAuxFinal.setTime(fecha);
        // Le restamos un minuto a la fecha final porque el between no es excluyente
        fechaAuxFinal.add(Calendar.MINUTE, duracion - 2);
        fechafinal = fechaAuxFinal.getTime();
        try {
            if (sala != null && clinica != null && fecha != null && 
                duracion != null) {
                StringBuffer sb = new StringBuffer();
                sb.append(" select chcp from " + Chcirugprogr.class.getName());
                sb.append(" chcp  where chcp.hcpnsalainterv = ? ");
                sb.append(" and chcp.hcpnclinica = ? ");
                sb.append(" and chcp.hcpcestado <> 'XX'");
                sb.append(" and (( ?  between chcp.hcpdfechacirug  and chcp.hcpdfechfincir  ");
                sb.append(" or  ?  between chcp.hcpdfechacirug  and chcp.hcpdfechfincir ) ");
                sb.append(" or  ( chcp.hcpdfechacirug between ? and ?  or  chcp.hcpdfechfincir  between ? and ? )) ");


                parametros.add(sala);
                parametros.add(clinica);
                parametros.add(fecha);
                parametros.add(fechafinal);
                parametros.add(fecha);
                parametros.add(fechafinal);
                parametros.add(fecha);
                parametros.add(fechafinal);

                if (numeroCirugia != null) {
                    sb.append(" and chcp.hcplnumero != ? ");
                    parametros.add(numeroCirugia);
                }

                resultList = 
                        (List<Chcirugprogr>) this.getHibernateTemplate().find(sb.toString(), parametros.toArray());


                if (!resultList.isEmpty() || resultList == null) {
                    return false;
                } else {
                    return true;
                }

            }

            return false;

        } catch (HibernateException e) {
            throw new ModelException("Error consultando Disponibilidad de Salas:" + 
                                     e.getMessage(), e);
        } catch (Exception e) {
            throw new ModelException("Error consultando Disponibilidad de Salas:" + 
                                     e.getMessage(), e);
        }

    }
    
    
    public boolean verificarProgramacionCirugia(Long numeroCirugia) throws ModelException {
        List<Chcirugprogr> resultList = null;
        List parametros = new ArrayList();
        Date fechafinal = null;

        
        try {
            if (numeroCirugia != null) {
                StringBuffer sb = new StringBuffer();
                sb.append(" select chcp from " + Chcirugprogr.class.getName());
                sb.append(" chcp  where chcp.hcplnumero = ? and chcp.hcpcestado <> 'XX' ");
               

                parametros.add(numeroCirugia);
                resultList = 
                        (List<Chcirugprogr>) this.getHibernateTemplate().find(sb.toString(), parametros.toArray());


                if (!resultList.isEmpty() || resultList == null) {
                    return true;
                } else {
                    return false;
                }

            }

            return false;

        } catch (HibernateException e) {
            throw new ModelException("Error consultando Disponibilidad de Salas:" + 
                                     e.getMessage(), e);
        } catch (Exception e) {
            throw new ModelException("Error consultando Disponibilidad de Salas:" + 
                                     e.getMessage(), e);
        }

    }



    /**
     * @param programar
     * @param lstConsclin
     * @throws ModelException
     */
    public void saveProgramarCirugia(final Chcirugprogr programar, 
                                     final List<Cnconsclin> lstConsclin, 
                                     final String userName, 
                                     final Chusuario usuario) throws ModelException {
        try {
            this.getHibernateTemplate().execute(new HibernateCallback() {
                        public Object doInHibernate(Session session) {
                            Chconsulta consulta;
                            consulta = null;
                            Cnconsclin consprin = null;
                            Integer consecutivo = null;
                            Chcirugprogr cirugia = null;

                            // Ordenamos la lista por el valor del servicio, se toma la de mator valor como la consulta principal 
                            Collections.sort(lstConsclin, new Comparator() {

                                        public int compare(Object object1, 
                                                           Object object2) {
                                            Cnconsclin cncl1 = 
                                                (Cnconsclin)object1;
                                            Cnconsclin cncl2 = 
                                                (Cnconsclin)object2;
                                            return (cncl1.getCcoavalser()).compareTo(cncl2.getCcoavalser());
                                        }

                                    });

                            consprin = lstConsclin.get(lstConsclin.size() - 1);

                            if (consprin != null) {
                                consecutivo = consprin.getCconnumero();
                            }
                            
                            // CREAMOS LA CONSULTA 

                            
                            
                            
                           
                            
                            
                            if(consecutivo != null){
                            
                                StringBuffer sb4 = new StringBuffer();
                                sb4.append("SELECT c from ");
                                sb4.append(Chconsulta.class.getName()).append(" c ");
                                sb4.append("WHERE  c.hcolnumero = :hcolnumero  ");
                                
                                String hql22 = sb4.toString();
                                Query query12 = session.createQuery(hql22);
                                query12.setParameter("hcolnumero", consecutivo);
                                
                                
                                consulta = (Chconsulta)query12.uniqueResult();
                                
                                if(consulta == null){
                                    consulta = new Chconsulta();
                                }
                                
                                
                                
                                
                                if (consprin != null) {
                                    consulta.setHcolnumero(new Long(consprin.getCconnumero()));
                                    consulta.setHcolconsuclini(new Long(consprin.getCconnumero()));
                                }

                                consulta.setHcoctiposervi(IConstantes.TIPO_HOSPITALIZACION);
                                consulta.setHcocentidadadm(usuario.getHuscentidadadm());
                                consulta.setHcolusuario(usuario);
                                consulta.setHcocservicio(consprin.getCcocservic());
                                consulta.setHcontipoconsu(consprin.getCcontconcl());
                                consulta.setHcoeetapa(IConstantes.ETAPA_ABIERTO);
                                consulta.setHcocnombacompa(usuario.getHuscnomacompana());
                                consulta.setHcocteleacompa(usuario.getHusctelacompana());
                                consulta.setHcocnombrespo(usuario.getHuscnomresponsa());
                                consulta.setHcoctelerespo(usuario.getHusctelresponsa());
                                consulta.setHcocoperador(userName);
                                consulta.setHcodfecregistr(new Date());
                                consulta.setHconnumdoc(consprin.getCconnumdoc());
                                consulta.setHcontipdoc(consprin.getCcontipdoc());
                                consulta.setHconclinica(consprin.getCconclinic());
                                session.saveOrUpdate(consulta);
                            
                                StringBuffer sb1 = new StringBuffer();
                                sb1.append(" select chcp from  " + 
                                           Chcirugprogr.class.getName() + 
                                           " chcp  where chcp.hcplnumero = :hcplnumero ");
                                Query query1 = 
                                    session.createQuery(sb1.toString());
                                query1.setParameter("hcplnumero", consecutivo);
                                cirugia = (Chcirugprogr)query1.uniqueResult();
                                
                                if(cirugia != null){
                                    cirugia.setHcpdfechacirug(programar.getHcpdfechacirug());
                                    cirugia.setHcpntiempointe(programar.getHcpntiempointe());
                                    cirugia.setHcpnsalainterv(programar.getHcpnsalainterv());
                                    cirugia.setHcplusuario(programar.getHcplusuario());
                                    cirugia.setHcpcentidadadm(programar.getHcpcentidadadm());
                                    cirugia.setHcpcanestesiol(programar.getHcpcanestesiol());
                                    cirugia.setHcpcestado(programar.getHcpcestado());
                                    cirugia.setHcpdfecregistr(programar.getHcpdfecregistr());
                                    cirugia.setHcpdfechamodif(programar.getHcpdfechamodif());
                                    cirugia.setHcpcoperador(programar.getHcpcoperador());
                                    cirugia.setHcpcoperamodif(programar.getHcpcoperamodif());
                                    cirugia.setHcpnclinica(programar.getHcpnclinica());
                                    cirugia.setHcpcetapa(programar.getHcpcetapa());
                                    cirugia.setHcpdfechfincir(programar.getHcpdfechfincir());
                                    cirugia.setHcpctipoaneste(programar.getHcpctipoaneste());
                                    cirugia.setHcpctipoayudan(programar.getHcpctipoayudan());
                                    cirugia.setHcpcprofeayuda(programar.getHcpcprofeayuda());
                                    cirugia.setHcpctipoestanc(programar.getHcpctipoestanc());
                                    cirugia.setHcpeayudantia(programar.getHcpeayudantia());
                                    cirugia.setHcpndiasestanc(programar.getHcpndiasestanc());
                                    cirugia.setHcpcdescranest(programar.getHcpcdescranest());
                                    cirugia.setHcpcdescrestan(programar.getHcpcdescrestan());
                                    cirugia.setHcpcingremedic(programar.getHcpcingremedic());
                                    cirugia.setHcpcingreenfer(programar.getHcpcingreenfer());
                                    cirugia.setHcpcsalidenfer(programar.getHcpcsalidenfer());
                                    cirugia.setHcpcsalidmedic(programar.getHcpcsalidmedic());
                                    cirugia.setHcpcopersalmed(programar.getHcpcopersalmed());
                                    cirugia.setHcpcopersalenf(programar.getHcpcopersalenf());
                                    cirugia.setHcpdfechsalmed(programar.getHcpdfechsalmed());
                                    cirugia.setHcpdfechsalenf(programar.getHcpdfechsalenf());
                                    cirugia.setHcpdfechingmed(programar.getHcpdfechingmed());
                                    cirugia.setHcpdfechingenf(programar.getHcpdfechingenf());
                                    cirugia.setHcpcoperingmed(programar.getHcpcoperingmed());
                                    cirugia.setHcpcoperingenf(programar.getHcpcoperingenf());
                                    cirugia.setHcpcregisepicr(programar.getHcpcregisepicr());
                                    cirugia.setHcpcregisanest(programar.getHcpcregisanest());
                                    cirugia.setHcpcoperaepicr(programar.getHcpcoperaepicr());
                                    cirugia.setHcpcoperaanula(programar.getHcpcoperaanula());
                                    cirugia.setHcpcmotivanula(programar.getHcpcmotivanula()); 
                                    cirugia.setHcpcobseranula(programar.getHcpcobseranula()); 
                                    cirugia.setHcpdfechaanula(programar.getHcpdfechaanula());
                                    cirugia.setHcpcregisinstr(programar.getHcpcregisinstr()); 
                                    cirugia.setHcpcoperainstr(programar.getHcpcoperainstr()); 
                                    cirugia.setHcpcminutdurac(programar.getHcpcminutdurac()); 
                                    cirugia.setHcpchoradurac(programar.getHcpchoradurac()); 
                                    cirugia.setHcpcressangre(programar.getHcpcressangre());
                                    cirugia.setHcpcobserv(programar.getHcpcobserv());
                                    cirugia.setHcpctipohemoco(programar.getHcpctipohemoco());
                                    cirugia.setHcpnnumerounid(programar.getHcpnnumerounid());
                                    session.saveOrUpdate(cirugia);
                                    
                                StringBuffer sb = new StringBuffer();
                                sb.append(" delete  historia.Chdetacirpro ");
                                sb.append(" where hdclconsuprinc = :numeroConsulta ");
                                                                   
                                
                                Query query = 
                                    session.createQuery(sb.toString());
                                query.setParameter("numeroConsulta", 
                                                  consecutivo);
                                
                                
                                query.executeUpdate();
                            }else {
                                if (consecutivo != null) {
                                    programar.setHcplnumero(new Long(consecutivo));
                                    session.saveOrUpdate(programar);
                                }
                            }

                                                  

                            if (consprin != null && 
                                consprin.getCconnumero() != null) {
                                for (Cnconsclin cirugias: lstConsclin) {
                                    Chdetacirpro detalle = new Chdetacirpro();
                                    detalle.setHdclconsuasoci(new Long(cirugias.getCconnumero()));
                                    detalle.getId().setHdclconsuprinc(new Long(consprin.getCconnumero()));
                                    detalle.setHdccoperaregis(userName);
                                    detalle.getId().setHdccservicio(cirugias.getCcocservic().getCsvccodigo());
                                    detalle.setHdcnmedicatien(cirugias.getCirujanoSelect());
                                    detalle.setHdcdfecharegis(new Date());
                                    detalle.setHdccestado(IConstantes.ESTADO_VIGENTE);
                                    detalle.setHdcnclinica(cirugias.getCconclinic());
                                    detalle.setHdclusuario(usuario.getHuslnumero());
                                    session.saveOrUpdate(detalle);
                                }

                             
                            }
                            
                            }   
                            return programar;
                        }
                    });
        } catch (HibernateException e) {
            throw new ModelException("Error Insertando :" + e.getMessage(), e);
        } catch (Exception e) {
            throw new ModelException("Error Insertando :" + e.getMessage(), e);
        }
    }


    /**
     * @param usuario
     * @return
     * @throws ModelException
     */
    public List<Chcirugprogr> getCirugiasModificarProgramadas(final Chusuario usuario) throws ModelException {
        List<Chcirugprogr> pis = 
            (List<Chcirugprogr>)getHibernateTemplate().execute(new HibernateCallback() {
                    public Object doInHibernate(Session session) throws HibernateException {


                        StringBuffer sb = new StringBuffer();
                        sb.append("select chcp from ");
                        sb.append(Chcirugprogr.class.getName()).append(" chcp ");
                        sb.append("WHERE chcp.hcpcestado = 'VG' ");
                        sb.append("  and chcp.hcpcetapa in('IE','ES','PQ','EQ','ER') ");
                       


                        if (usuario.getHusetipoiden() != null && 
                            !usuario.getHusetipoiden().equals("")) {
                            sb.append(" AND chcp.hcplusuario.husetipoiden =  ").append("'" + 
                                                                                       usuario.getHusetipoiden() + 
                                                                                       "'");

                        }

                        if (usuario.getHusanumeiden() != null && 
                            !usuario.getHusanumeiden().equals("")) {
                            sb.append(" and chcp.hcplusuario.husanumeiden =   ").append(usuario.getHusanumeiden());
                        }

                        if (usuario.getHuscprimernomb() != null && 
                            !usuario.getHuscprimernomb().equals("")) {
                            sb.append(" and chcp.hcplusuario.huscprimernomb like   ").append("'%" + 
                                                                                             usuario.getHuscprimernomb().toUpperCase() + 
                                                                                             "%'");
                        }

                        if (usuario.getHuscsegundnomb() != null && 
                            !usuario.getHuscsegundnomb().equals("")) {
                            sb.append(" and chcp.hcplusuario.huscsegundnomb like   ").append("'%" + 
                                                                                             usuario.getHuscsegundnomb().toUpperCase() + 
                                                                                             "%'");

                        }

                        if (usuario.getHuscprimerapel() != null && 
                            !usuario.getHuscprimerapel().equals("")) {
                            sb.append(" and chcp.hcplusuario.huscprimerapel like   ").append("'%" + 
                                                                                             usuario.getHuscprimerapel().toUpperCase() + 
                                                                                             "%'");
                        }

                        if (usuario.getHuscsegundapel() != null && 
                            !usuario.getHuscsegundapel().equals("")) {
                            sb.append(" and chcp.hcplusuario.huscsegundapel like   ").append("'%" + 
                                                                                             usuario.getHuscsegundapel().toUpperCase() + 
                                                                                             "%'");
                        }
                        sb.append(" order by chcp.hcpdfechacirug DESC");


                        String hql = sb.toString();

                        Query query = session.createQuery(hql);
                        List<Chcirugprogr> pis;
                        pis = query.list();

                        for (Chcirugprogr co: pis) {
                            Chusuario usuario = co.getHcplusuario();
                            Hibernate.initialize(usuario);

                            Set cirugias = co.getChdetacirpros();
                            Hibernate.initialize(cirugias);

                        }

                        return pis;
                    }
                });
        return pis;
    }


    /**
     * 
     * @param
     */
    public Chcirugprogr getOrdenAtencion(final Integer sala, 
                                         final Date wfecha) throws ModelException {
        Chcirugprogr resultList = 
            (Chcirugprogr)getHibernateTemplate().execute(new HibernateCallback() {
                    public Object doInHibernate(Session session) throws HibernateException {

                        Date fecha = new Date();
                        Calendar fechaI = Calendar.getInstance();
                        fechaI.setTime(wfecha);
                        fechaI.set(Calendar.DATE, -1);
                        fecha = fechaI.getTime();


                        if (sala != null && wfecha != null) {
                            StringBuffer sb = new StringBuffer();
                            sb.append(" select chci from Chcirugprogr chci");
                            sb.append(" where chci.hcpnsalainterv = :sala ");
                            sb.append(" and chci.hcpdfechacirug > :fecha ");

                            sb.append(" order by chci.hcpnordenllega ");
                            Query query = session.createQuery(sb.toString());
                            query.setParameter("sala", sala);
                            query.setParameter("fecha", fecha);

                            List<Chcirugprogr> resultList;
                            resultList = query.list();

                            for (Chcirugprogr co: resultList) {
                                Chusuario usuario = co.getHcplusuario();
                                Hibernate.initialize(usuario);

                            }

                            if (!resultList.isEmpty()) {
                                return resultList.get(0);
                            }


                            return resultList;
                        }

                        return null;


                    }
                });
        return resultList;
    }


    /**
     * @param descripcion
     * @param detalleDescripcion
     * @param lstDetalleCirugias
     * @param userName
     * @throws ModelException
     */
    public void saveDescripcionQuirurgica(final Chdescrquiru descripcion, 
                                          final Chdetaldescr detalleDescripcion, 
                                          final List<Chdetacirpro> lstDetalleCirugias, 
                                          final List<Cpservicio> lstCirugias, 
                                          final String userName, 
                                          final String etapaCirugia, final Long numeroConsulta) throws ModelException {
        try {
            this.getHibernateTemplate().execute(new HibernateCallback() {
                        public Object doInHibernate(Session session) {

                            Integer consecutivo = null;
                            
                            

                            if (descripcion != null) {
                                StringBuffer sb1 = new StringBuffer();
                                sb1.append(" select max(chdd.id.hddnconsec) from " + 
                                           Chdetaldescr.class.getName() + 
                                           " chdd  where chdd.id.hddlnumero = :hddlnumero ");
                                Query query1 = 
                                    session.createQuery(sb1.toString());

                                query1.setParameter("hddlnumero", 
                                                    descripcion.getHdqlnumero());


                                Integer secuenciaActual = 
                                    (Integer)query1.uniqueResult();


                                if (secuenciaActual != null) {
                                    consecutivo = 
                                            secuenciaActual.intValue() + 1;
                                } else {
                                    consecutivo = 1;
                                }

                            }

                            if (consecutivo != null && detalleDescripcion != null && detalleDescripcion.getId()!= null
                            && detalleDescripcion.getId().getHddnconsec() == null) {
                                detalleDescripcion.getId().setHddnconsec(consecutivo);
                                session.saveOrUpdate(detalleDescripcion);
                                
                                if (lstDetalleCirugias != null && 
                                    !lstDetalleCirugias.isEmpty()) {
                                    for (Chdetacirpro detalle: 
                                         lstDetalleCirugias) {

                                        Chcirdetdesc detalleCirugiasDQx = 
                                            new Chcirdetdesc();
                                        detalleCirugiasDQx.getId().setHcdlnumero(detalle.getId().getHdclconsuprinc());
                                        detalleCirugiasDQx.getId().setHcdcintervenci(detalle.getId().getHdccservicio());
                                        detalleCirugiasDQx.getId().setHcdnconsec(consecutivo);
                                        detalleCirugiasDQx.setHcdcestado(IConstantes.ETAPA_PROGRAMACION_CIRUGIA);
                                      
                                        if(lstCirugias .isEmpty()){
                                            detalleCirugiasDQx.setHcdcintervepra(detalle.getId().getHdccservicio());
                                        }
                                        
                                        
                                        if (lstCirugias != null && 
                                            !lstCirugias.isEmpty()) {
                                            for (Cpservicio cpserv: lstCirugias) {
                                                detalleCirugiasDQx.setHcdcintervepra(cpserv.getCsvccodigo());
                                            }
                                        }
                                        // TODO: ACA VERIFICAR 
                                           
                                        session.saveOrUpdate(detalleCirugiasDQx);
                                        /*generarRipsProcedimiento(session, detalle,userName);*/

                                
                                   
                                        // DESCRIPCION QUIRURGICA 
                                        StringBuffer sb = new StringBuffer();
                                        sb.append(" select chdc from  ");
                                        sb.append(" from Chdetacirpro chdc ");
                                        sb.append(" where chdc.id.hdclconsuprinc = :hdclconsuprinc AND  chdc.id.hdccservicio = :hdccservicio   ");

                                        Query query = 
                                            session.createQuery(sb.toString());
                                        query.setParameter("hdclconsuprinc", 
                                                           detalle.getId().getHdclconsuprinc());
                                        query.setParameter("hdccservicio", 
                                                           detalle.getId().getHdccservicio());

                                        Chdetacirpro detalleAux = 
                                            (Chdetacirpro)query.uniqueResult();


                                        if (detalleAux != null) {

                                            detalleAux.setHdcdfechamodif(new Date());
                                            detalleAux.setHdccoperamodif(userName);
                                            detalleAux.setHdccdescrquiru("S");
                                            detalleAux.setHdcnmedicatien(detalle.getHdcnmedicatien());
                                            detalleAux.setHdcnconsedescr(consecutivo);
                                            session.saveOrUpdate(detalleAux);
                                        }



                                 
                                     
                                        detalle.getId().getHdccservicio();
                                        detalle.getId().getHdclconsuprinc();

                                        generarRipsProcedimientoDescripcion(session, detalle, 
                                                                 userName,detalleDescripcion,descripcion);
                                        

                                    }
                                }
                              
                              
                                // DESCRIPCION QUIRURGICA 
                                StringBuffer sb1 = new StringBuffer();
                                sb1.append(" select chdc from  ");
                                sb1.append(" from Chdescrquiru chdc ");
                                sb1.append(" where chdc.hdqlnumero = :numero  ");

                                Query query = session.createQuery(sb1.toString());
                                query.setParameter("numero", 
                                                   descripcion.getHdqlnumero());


                                Chdescrquiru descriencabezado = 
                                    (Chdescrquiru)query.uniqueResult();

                                if (descriencabezado == null) {
                                    descriencabezado = new Chdescrquiru();
                                }

                                descriencabezado.setHdqcestado(descripcion.getHdqcestado());
                                descriencabezado.setHdqcoperador(descripcion.getHdqcoperador());
                                descriencabezado.setHdqdfechaproce(descripcion.getHdqdfechaproce());
                                descriencabezado.setHdqdfecregistr(descripcion.getHdqdfecregistr());
                                descriencabezado.setHdqlnumero(descripcion.getHdqlnumero());
                                descriencabezado.setHdqlusuario(descripcion.getHdqlusuario());
                                descriencabezado.setHdqnambito(descripcion.getHdqnambito());
                                descriencabezado.setHdqnclinica(descripcion.getHdqnclinica());
                                descriencabezado.setHdqnformareali(descripcion.getHdqnformareali());
                                descriencabezado.setHdqnsalacirugi(descripcion.getHdqnsalacirugi());


                                session.saveOrUpdate(descriencabezado);
                                
                                
                                if (numeroConsulta != null) {
                                    
                                    
                                    StringBuffer sb2 = new StringBuffer();
                                    sb2.append(" update historia.chcirugprogr set hcpcetapa = :etapa " + 
                                              "   where hcplnumero = :numeroCirugia ");
                                    Query query2 = 
                                        session.createQuery(sb2.toString());

                                    query2.setParameter("etapa", 
                                                       IConstantes.ETAPA_CIRUGIA_EN_RECUPERACION);
                                    query2.setParameter("numeroCirugia", 
                                                       numeroConsulta);
                                    query2.executeUpdate();

                                 }
  
                            }
                            
                            // Modificamos la fecha de las consultas clinicas asociadas y se asignann los honorarios
                            if(lstDetalleCirugias != null && !lstDetalleCirugias.isEmpty()){
                               
                                Chdetacirpro detaCirugia = lstDetalleCirugias.get(0);
                                if(detaCirugia != null && detaCirugia.getId() != null && detaCirugia.getId().getHdclconsuprinc() != null ){
                                   Cnconsclin consultaAsociada = null;
                                   StringBuffer sb1 = new StringBuffer();
                                   sb1.append("SELECT cncl from ");
                                   sb1.append(Cnconsclin.class.getName()).append(" cncl ");
                                   sb1.append("WHERE cncl.cconnumero = ? ");
                                   String hql2 = sb1.toString();
                                   Query query1 = session.createQuery(hql2);
                                   query1.setParameter(0, numeroConsulta);
                                   consultaAsociada = (Cnconsclin)query1.uniqueResult();
                                            
                                   if(consultaAsociada != null){
                                       consultaAsociada.setCcodfeccon(new Date());
                                       consultaAsociada.setCcothorate(new Date());
                                       consultaAsociada.setCcocetapa(IConstantes.ETAPA_ATENDIDO);
                                       consultaAsociada.setCcocusumod(userName);
                                       session.saveOrUpdate(consultaAsociada);
                                                
                                       generarHonorariosProfesional(session,consultaAsociada, userName, null);
                                       /* para asignar el anestesiologo */
                                        Chanestesia anestesia = null;
                                        StringBuffer sban = new StringBuffer();
                                        sban.append("SELECT chan from ");
                                        sban.append(Chanestesia.class.getName()).append(" chan ");
                                        sban.append("WHERE chan.hanlnumero = ? ");
                                        String hqan = sban.toString();
                                        Query queryan = session.createQuery(hqan);
                                        queryan.setParameter(0, numeroConsulta);
                                        anestesia = (Chanestesia)queryan.uniqueResult();
                                        if(anestesia != null && anestesia.getHannanestesiol() != null) {
                                             generarHonorariosProfesional(session,consultaAsociada, userName, anestesia.getHannanestesiol().toString());
                                        }
                                   }
                                }
                            }
                         
                            return descripcion;
                        }
                    });
        } catch (HibernateException e) {
            throw new ModelException("Error Insertando :" + e.getMessage(), e);
        } catch (Exception e) {
            throw new ModelException("Error Insertando :" + e.getMessage(), e);
        }
    }

    /**
     * @param numeroConsulta
     * @return
     * @throws ModelException
     */
    public Chdescrquiru getDescripcionQuirurgica(Long numeroConsulta) throws ModelException {
        List<Chdescrquiru> resultList = null;
        List parametros = new ArrayList();


        try {
            if (numeroConsulta != null) {

                StringBuffer sb = new StringBuffer();
                sb.append(" select chdc from " + Chdescrquiru.class.getName() + 
                          " chdc  where chdc.hdqlnumero = ? ");

                parametros.add(numeroConsulta);

                resultList = 
                        (List<Chdescrquiru>) this.getHibernateTemplate().find(sb.toString(), parametros.toArray());

                if (!resultList.isEmpty()) {
                    return resultList.get(0);
                }

            }
            return null;

        } catch (HibernateException e) {
            throw new ModelException("Error consultando descripcion quirurgica" + 
                                     e.getMessage(), e);
        } catch (Exception e) {
            throw new ModelException("Error consultando descripcion quirurgica:" + 
                                     e.getMessage(), e);
        }

    }


    /**
     * @return
     * @throws ModelException
     */
    public List<Chcirugprogr> getCirugiasProgramadasDescripcionQuirurgica(final Integer codclin, 
                                                                          final Date fechaHoy, 
                                                                          boolean registro, 
                                                                          final BigDecimal wcodmed, final String wetapa) throws ModelException {
        List<Chcirugprogr> pis = 
            (List<Chcirugprogr>)getHibernateTemplate().execute(new HibernateCallback() {
                    public Object doInHibernate(Session session) throws HibernateException {

                        String DATE_FORMAT = "dd/MM/yyyy";
                        SimpleDateFormat sdf = 
                            new SimpleDateFormat(DATE_FORMAT);
                        String diaCons = sdf.format(fechaHoy);
                        boolean tieneSala = false; 
                        
                        
                        if (wcodmed != null) {
                            StringBuffer hql = new StringBuffer();
                            hql.append(" select chps from " + 
                                      Chsalaxprofe.class.getName());
                            hql.append(" chps  where chps.id.hspnnumero = :wcodmed and chps.id.hspnclinica = :codclin ");

                            Query query = session.createQuery(hql.toString());
                            query.setParameter("codclin", codclin);
                            query.setParameter("wcodmed", wcodmed);

                            List<Chcirugprogr> pis;
                            pis = query.list();
                            
                            if(pis != null && !pis.isEmpty()){
                                tieneSala = true;
                            }

                        }


                        StringBuffer sb = new StringBuffer();
                        sb.append("select chcp from ");
                        sb.append(Chcirugprogr.class.getName()).append(" chcp ");
                        sb.append("where to_char(chcp.hcpdfechacirug,'dd/MM/yyyy') = :diaCons ");
                        sb.append("and chcp.hcpcsalidenfer != 'S' ");
                        sb.append("and chcp.hcpcestado <> 'XX' ");
                        sb.append("and chcp.hcpcetapa = :wetapa ");
                        sb.append("and chcp.hcpnclinica = :codclin ");
                        if(tieneSala){
                            sb.append("and chcp.hcpnsalainterv in (select chps.id.hspnsala from Chsalaxprofe chps where chps.id.hspnnumero = :wcodmed )");    
                        }
                        


                        String hql = sb.toString();

                        Query query = session.createQuery(hql);
                        query.setParameter("codclin", codclin);
                        query.setParameter("diaCons", diaCons);
                        query.setParameter("wetapa", wetapa);
                        if(tieneSala){
                        query.setParameter("wcodmed", wcodmed);
                        }
                        List<Chcirugprogr> pis;
                        pis = query.list();

                        for (Chcirugprogr co: pis) {
                            Chusuario usuario = co.getHcplusuario();
                            Hibernate.initialize(usuario);

                            Set chdetacirpros = co.getChdetacirpros();
                            Hibernate.initialize(chdetacirpros);


                        }

                        return pis;
                    }
                });
        return pis;
    }


    /**
     * @return
     * @throws ModelException
     */
    public List<Chcirugprogr> getCirugiasProgramadasDescripcionQuirurgicaAnteriores(final Integer codclin, 
                                                                                    final Date fechaHoy, 
                                                                                    boolean registro) throws ModelException {
        List<Chcirugprogr> pis = 
            (List<Chcirugprogr>)getHibernateTemplate().execute(new HibernateCallback() {
                    public Object doInHibernate(Session session) throws HibernateException {

                        String DATE_FORMAT = "dd/MM/yyyy";
                        SimpleDateFormat sdf = 
                            new SimpleDateFormat(DATE_FORMAT);
                        String diaCons = sdf.format(fechaHoy);


                        StringBuffer sb = new StringBuffer();
                        sb.append("select chcp from ");
                        sb.append(Chcirugprogr.class.getName()).append(" chcp ");
                        sb.append("where to_char(chcp.hcpdfechacirug,'dd/MM/yyyy') = :diaCons ");
                        sb.append("and chcp.hcpcsalidenfer != 'S' ");
                        sb.append("and chcp.hcpcestado <> 'XX' ");
                        //sb.append("and chcp.hcpcetapa = 'EQ' ");
                        sb.append("and chcp.hcpnclinica = :codclin ");

                        String hql = sb.toString();

                        Query query = session.createQuery(hql);
                        query.setParameter("codclin", codclin);
                        query.setParameter("diaCons", diaCons);
                        List<Chcirugprogr> pis;
                        pis = query.list();

                        for (Chcirugprogr co: pis) {
                            Chusuario usuario = co.getHcplusuario();
                            Hibernate.initialize(usuario);

                            Set chdetacirpros = co.getChdetacirpros();
                            Hibernate.initialize(chdetacirpros);


                        }

                        return pis;
                    }
                });
        return pis;
    }


    /**
     * @return
     * @throws ModelException
     */
    public List<Chcirugprogr> getCirugiasProgramadasInstrumentador(final Integer codclin) throws ModelException {
        List<Chcirugprogr> pis = 
            (List<Chcirugprogr>)getHibernateTemplate().execute(new HibernateCallback() {
                    public Object doInHibernate(Session session) throws HibernateException {


                        StringBuffer sb = new StringBuffer();
                        sb.append("select chcp from ");
                        sb.append(Chcirugprogr.class.getName()).append(" chcp ");
                        sb.append("where chcp.hcpnclinica = :codclin and (chcp.hcpcregisinstr = 'N' OR chcp.hcpcregisinstr is null) ");
                        sb.append("and chcp.hcpcestado <> 'XX' ");

                        String hql = sb.toString();

                        Query query = session.createQuery(hql);
                        query.setParameter("codclin", codclin);
                        List<Chcirugprogr> pis;
                        pis = query.list();

                        for (Chcirugprogr co: pis) {
                            Chusuario usuario = co.getHcplusuario();
                            Hibernate.initialize(usuario);

                            Set chdetacirpros = co.getChdetacirpros();
                            Hibernate.initialize(chdetacirpros);


                        }

                        return pis;
                    }
                });
        return pis;
    }


    /**
     * @return
     * @throws ModelException
     */
    public Chcirugprogr getCirugiaPorId(final Long codcir) throws ModelException {
        Chcirugprogr pis = 
            (Chcirugprogr)getHibernateTemplate().execute(new HibernateCallback() {
                    public Object doInHibernate(Session session) throws HibernateException {


                        StringBuffer sb = new StringBuffer();
                        sb.append("select chcp from ");
                        sb.append(Chcirugprogr.class.getName()).append(" chcp ");
                        sb.append("where chcp.hcplnumero = :codcir  ");


                        String hql = sb.toString();

                        Query query = session.createQuery(hql);
                        query.setParameter("codcir", codcir);
                        Chcirugprogr pis;
                        pis = (Chcirugprogr)query.uniqueResult();

                        if (pis != null) {
                            Chusuario usuario = pis.getHcplusuario();
                            Hibernate.initialize(usuario);

                            Set chdetacirpros = pis.getChdetacirpros();
                            Hibernate.initialize(chdetacirpros);
                        }


                        return pis;
                    }
                });
        return pis;
    }


    /**
     * @param usuario
     * @return
     * @throws ModelException
     */
    public List<Chingresoenf> getPacientesIngresados(final Chusuario usuario) throws ModelException {
        List<Chingresoenf> pis = 
            (List<Chingresoenf>)getHibernateTemplate().execute(new HibernateCallback() {
                    public Object doInHibernate(Session session) throws HibernateException {


                        StringBuffer sb = new StringBuffer();
                        sb.append("SELECT chie from ");
                        sb.append(Chingresoenf.class.getName()).append(" chie ");
                        sb.append("WHERE chie.hiecetapa in ('IG','IM') ");

                        if (usuario != null) {

                            if (usuario.getHuscprimerapel() != null && 
                                !usuario.getHuscprimerapel().equals("")) {
                                sb.append(" AND chie.hielusuario.huscprimerapel = ").append("'" + 
                                                                                            usuario.getHuscprimerapel().toUpperCase() + 
                                                                                            "'");
                            }
                            if (usuario.getHuscprimernomb() != null && 
                                !usuario.getHuscprimernomb().equals("")) {
                                sb.append(" AND chie.hielusuario.huscprimernomb = ").append("'" + 
                                                                                            usuario.getHuscprimernomb().toUpperCase() + 
                                                                                            "'");
                            }

                            if (usuario.getHuscsegundapel() != null && 
                                !usuario.getHuscsegundapel().equals("")) {
                                sb.append(" AND chie.hielusuario.huscsegundapel = ").append("'" + 
                                                                                            usuario.getHuscsegundapel().toUpperCase() + 
                                                                                            "'");
                            }
                            if (usuario.getHuscsegundnomb() != null && 
                                !usuario.getHuscsegundnomb().equals("")) {
                                sb.append(" AND  chie.hielusuario.huscsegundnomb =  ").append("'" + 
                                                                                              usuario.getHuscsegundnomb().toUpperCase() + 
                                                                                              "'");
                            }
                            if (usuario.getHusanumeiden() != null) {
                                sb.append(" AND chie.hielusuario.husanumeiden = ").append(usuario.getHusanumeiden());
                            }

                            if (usuario.getHusetipoiden() != null && 
                                !usuario.getHusetipoiden().equals("")) {
                                sb.append(" AND chie.hielusuario.husetipoiden = ").append("'" + 
                                                                                          usuario.getHusetipoiden().toUpperCase() + 
                                                                                          "'");
                            }
                        }


                        String hql = sb.toString();

                        Query query = session.createQuery(hql);
                        List<Chingresoenf> pis;
                        pis = query.list();

                        for (Chingresoenf ie: pis) {
                            Chusuario usuario = ie.getHielusuario();
                            Hibernate.initialize(usuario);

                        }

                        return pis;
                    }
                });
        return pis;
    }

    /**
     * @param usuario
     * @return
     * @throws ModelException
     */
    public List<Chingresoenf> getPacientesIngresadosMedico(final Chusuario usuario) throws ModelException {
        List<Chingresoenf> pis = 
            (List<Chingresoenf>)getHibernateTemplate().execute(new HibernateCallback() {
                    public Object doInHibernate(Session session) throws HibernateException {


                        StringBuffer sb = new StringBuffer();
                        sb.append("SELECT chie from ");
                        sb.append(Chingresoenf.class.getName()).append(" chie ");
                        sb.append("WHERE chie.hiecetapa = 'IG' ");

                        if (usuario != null) {

                            if (usuario.getHuscprimerapel() != null && 
                                !usuario.getHuscprimerapel().equals("")) {
                                sb.append(" AND chie.hielusuario.huscprimerapel = ").append("'" + 
                                                                                            usuario.getHuscprimerapel().toUpperCase() + 
                                                                                            "'");
                            }
                            if (usuario.getHuscprimernomb() != null && 
                                !usuario.getHuscprimernomb().equals("")) {
                                sb.append(" AND chie.hielusuario.huscprimernomb = ").append("'" + 
                                                                                            usuario.getHuscprimernomb().toUpperCase() + 
                                                                                            "'");
                            }

                            if (usuario.getHuscsegundapel() != null && 
                                !usuario.getHuscsegundapel().equals("")) {
                                sb.append(" AND chie.hielusuario.huscsegundapel = ").append("'" + 
                                                                                            usuario.getHuscsegundapel().toUpperCase() + 
                                                                                            "'");
                            }
                            if (usuario.getHuscsegundnomb() != null && 
                                !usuario.getHuscsegundnomb().equals("")) {
                                sb.append(" AND  chie.hielusuario.huscsegundnomb =  ").append("'" + 
                                                                                              usuario.getHuscsegundnomb().toUpperCase() + 
                                                                                              "'");
                            }
                            if (usuario.getHusanumeiden() != null) {
                                sb.append(" AND chie.hielusuario.husanumeiden = ").append(usuario.getHusanumeiden());
                            }

                            if (usuario.getHusetipoiden() != null && 
                                !usuario.getHusetipoiden().equals("")) {
                                sb.append(" AND chie.hielusuario.husetipoiden = ").append("'" + 
                                                                                          usuario.getHusetipoiden().toUpperCase() + 
                                                                                          "'");
                            }
                        }


                        String hql = sb.toString();

                        Query query = session.createQuery(hql);
                        List<Chingresoenf> pis;
                        pis = query.list();

                        for (Chingresoenf ie: pis) {
                            Chusuario usuario = ie.getHielusuario();
                            Hibernate.initialize(usuario);

                        }

                        return pis;
                    }
                });
        return pis;
    }


    /**
     * @param numeroCirugia
     * @param codClinica
     * @param userName
     * @throws ModelException
     */
    public void saveConductaDarAltaEnfermeria(final Long numeroCirugia, 
                                              final Integer codClinica, 
                                              final String userName, 
                                              final Chconducta conducta, 
                                              final Date fechaSalida, final List lstCirugia) throws ModelException {
        try {
            this.getHibernateTemplate().execute(new HibernateCallback() {
                        public Object doInHibernate(Session session) {

                            if (numeroCirugia != null && codClinica != null && 
                                userName != null) {


                                StringBuffer sb = new StringBuffer();
                                sb.append(" update historia.chcirugprogr set hcpcopersalenf = :userName, hcpdfechsalenf = :fechasal, hcpcsalidenfer = 'S' " + 
                                          "   where hcplnumero = :numeroCirugia ");
                                Query query = 
                                    session.createQuery(sb.toString());
                                query.setParameter("numeroCirugia", 
                                                   numeroCirugia);
                                query.setParameter("userName", userName);
                                query.setParameter("fechasal", fechaSalida);

                                query.executeUpdate();
                                
                                
                                StringBuffer sbAda = new StringBuffer();
                                sbAda.append(" update clinico.CFDETAFACTURA ccdf1  set ccdf1.CDFCETAPA = 'AT' ");
                                sbAda.append(" where (ccdf1.CDFNCONSFACT, ccdf1.CDFNNUMITEM) in( ");
                                sbAda.append(" select ccdf.CDFNCONSFACT, ccdf.CDFNNUMITEM ");
                                sbAda.append(" from clinico.CFFACTURA ccfa, clinico.CFDETAFACTURA ccdf ");
                                sbAda.append(" where ccfa.CFNCONSFACT = ccdf.CDFNCONSFACT ");
                                sbAda.append(" and ccfa.CFNADMISION = :wadmision ");
                                sbAda.append(" and ccdf.CDFCSERVICIO = :wservicio ) ");


                          /*      Query queryAda =
                                session.createQuery(sbAda.toString());
                                queryAda.setParameter("wadmision",
                                      consulta.getCconnumdoc());
                                queryAda.setParameter("wservicio",
                                      consulta.getCcocservic().getCsvccodigo());
                                queryAda.executeUpdate();*/


                                session.saveOrUpdate(conducta);

                            }

                            return numeroCirugia;
                        }
                    });
        } catch (HibernateException e) {
            throw new ModelException("Error Insertando :" + e.getMessage(), e);
        } catch (Exception e) {
            throw new ModelException("Error Insertando :" + e.getMessage(), e);
        }
    }


    /**
     * @param numeroCirugia
     * @param codClinica
     * @throws ModelException
     */
    public void closeAnestesia(final Long numeroCirugia, 
                               final Integer codClinica, 
                               final Chcierreanest cierreanestesia) throws ModelException {
        try {
            this.getHibernateTemplate().execute(new HibernateCallback() {
                        public Object doInHibernate(Session session) {

                            if (numeroCirugia != null && codClinica != null && 
                                cierreanestesia != null) {

                                session.saveOrUpdate(cierreanestesia);


                                StringBuffer sb = new StringBuffer();
                                sb.append(" update historia.chcirugprogr set hcpcregisanest = 'S', hcpcetapa = :etapa " + 
                                          "   where hcplnumero = :numeroCirugia ");
                                Query query = 
                                    session.createQuery(sb.toString());

                                query.setParameter("etapa", 
                                                   IConstantes.ETAPA_CIRUGIA_EN_RECUPERACION);
                                query.setParameter("numeroCirugia", 
                                                   numeroCirugia);
                                query.executeUpdate();

                            }

                            return numeroCirugia;
                        }
                    });
        } catch (HibernateException e) {
            throw new ModelException("Error Insertando :" + e.getMessage(), e);
        } catch (Exception e) {
            throw new ModelException("Error Insertando :" + e.getMessage(), e);
        }
    }


    /**
     * @param numeroCirugia
     * @param codClinica
     * @param userName
     * @param conducta
     * @throws ModelException
     */
    public void saveConductaDarAltaMedico(final Long numeroCirugia, 
                                          final Integer codClinica, 
                                          final String userName, 
                                          final Chconducta conducta, 
                                          final Date fechaSalida) throws ModelException {
        try {
            this.getHibernateTemplate().execute(new HibernateCallback() {
                        public Object doInHibernate(Session session) {

                            if (numeroCirugia != null && codClinica != null && 
                                userName != null) {

                                StringBuffer sb = new StringBuffer();
                                sb.append(" update historia.chcirugprogr set hcpcopersalmed = :userName, hcpdfechsalmed = :fechasal, hcpcsalidmedic = 'S'  " + 
                                          "   where hcplnumero = :numeroCirugia ");
                                Query query = 
                                    session.createQuery(sb.toString());
                                query.setParameter("numeroCirugia", 
                                                   numeroCirugia);
                                query.setParameter("userName", userName);
                                query.setParameter("fechasal", fechaSalida);
                                query.executeUpdate();


                                session.saveOrUpdate(conducta);

                            }

                            return numeroCirugia;
                        }
                    });
        } catch (HibernateException e) {
            throw new ModelException("Error Insertando :" + e.getMessage(), e);
        } catch (Exception e) {
            throw new ModelException("Error Insertando :" + e.getMessage(), e);
        }
    }


    /**
     * @param lstFormula
     * @param numeroCirugia
     * @param tipoServicio
     * @throws ModelException
     */
    public void saveListFormulaMedicaEspecial(final List<Chformulaesp> lstFormula, 
                                              final Long numeroCirugia, 
                                              final String tipoServicio) throws ModelException {

        try {
            this.getHibernateTemplate().execute(new HibernateCallback() {
                        public Object doInHibernate(Session session) {

                            if (lstFormula != null && !lstFormula.isEmpty()) {
                                Chformulaesp formula;
                                ChformulaespPK idformula;
                                int consec = 0;
                                Iterator it = lstFormula.iterator();
                                while (it.hasNext()) {
                                    it.next();
                                    formula = lstFormula.get(consec);
                                    idformula = new ChformulaespPK();
                                    if (numeroCirugia != null && 
                                        tipoServicio != null) {
                                        idformula.setHfelconsulta(numeroCirugia);
                                        idformula.setHfectiposerv(tipoServicio);
                                        idformula.setHfenllave(1);
                                    }
                                    idformula.setHfenconsecut(new Integer(consec + 
                                                                          1));
                                    formula.setId(idformula);
                                    formula.setHfedfecregistr(new Date());
                                    consec++;
                                    session.saveOrUpdate(formula);


                                }

                            }


                            return numeroCirugia;
                        }
                    });
        } catch (HibernateException e) {
            throw new ModelException("Error Insertando :" + e.getMessage(), e);
        } catch (Exception e) {
            throw new ModelException("Error Insertando :" + e.getMessage(), e);
        }
    }


    /**
     * @param lstFormula
     * @param numeroCirugia
     * @param tipoServicio
     * @param consecutivo
     * @throws ModelException
     */
    public void saveListFormulaMedicaCirugia(final List<Chformulamed> lstFormula, 
                                             final Long numeroCirugia, 
                                             final String tipoServicio, 
                                             final Integer consecutivo) throws ModelException {
        try {
            this.getHibernateTemplate().execute(new HibernateCallback() {
                        public Object doInHibernate(Session session) {

                            if (lstFormula != null && !lstFormula.isEmpty()) {
                                Chformulamed formula;
                                ChformulamedPK idformula;
                                int consec = 0;
                                Iterator it = lstFormula.iterator();
                                while (it.hasNext()) {
                                    it.next();
                                    formula = lstFormula.get(consec);
                                    idformula = new ChformulamedPK();
                                    if (numeroCirugia != null && 
                                        tipoServicio != null && 
                                        consecutivo != null) {
                                        idformula.setHfolconsulta(numeroCirugia);
                                        formula.setHfonllave(consecutivo);
                                    }
                                    idformula.setHfonconsecut(new Integer(consec + 
                                                                          1));
                                    formula.setHfoctiposerv(tipoServicio);
                                    formula.setId(idformula);
                                    formula.setHfodfecregistr(new Date());
                                    consec++;
                                    session.saveOrUpdate(formula);


                                }

                            }


                            return lstFormula;
                        }
                    });
        } catch (HibernateException e) {
            throw new ModelException("Error Insertando :" + e.getMessage(), e);
        } catch (Exception e) {
            throw new ModelException("Error Insertando :" + e.getMessage(), e);
        }
    }


    /**
     * @param lstFormula
     * @param evolucion
     * @throws ModelException
     */
    public void saveListFormulaMedicaCirugia(final List<Chformulamed> lstFormula, 
                                             final Chevolucion evolucion) throws ModelException {

        try {
            this.getHibernateTemplate().execute(new HibernateCallback() {
                        public Object doInHibernate(Session session) {
                            if (lstFormula != null && !lstFormula.isEmpty()) {
                                Chformulamed formula;
                                ChformulamedPK idformula;
                                int consec = 0;
                                Iterator it = lstFormula.iterator();
                                while (it.hasNext()) {
                                    it.next();
                                    formula = lstFormula.get(consec);
                                    idformula = new ChformulamedPK();
                                    if (evolucion != null && 
                                        evolucion.getId() != null && 
                                        evolucion.getId().getHevlnumero() != 
                                        null) {
                                        idformula.setHfolconsulta(evolucion.getId().getHevlnumero());

                                        formula.setHfonllave(evolucion.getId().getHevnconsecutiv());
                                    }
                                    idformula.setHfonconsecut(new Integer(consec + 
                                                                          1));
                                    formula.setId(idformula);
                                    formula.setHfoctiposerv(evolucion.getId().getHevctiposervi());
                                    formula.setHfodfecregistr(new Date());
                                    consec++;
                                    session.saveOrUpdate(formula);


                                }

                            }


                            return lstFormula;
                        }
                    });
        } catch (HibernateException e) {
            throw new ModelException("Error Insertando :" + e.getMessage(), e);
        } catch (Exception e) {
            throw new ModelException("Error Insertando :" + e.getMessage(), e);
        }
    }


    /**
     * @param formula
     * @throws ModelException
     */
    public void saveFormulaMedicamentoEspecial(Chformulaesp formula) throws ModelException {
        try {
            this.getHibernateTemplate().saveOrUpdate(formula);
        } catch (HibernateException e) {
            throw new ModelException("Error Insertando Formula Medicamento Especial:" + 
                                     e.getMessage(), e);
        } catch (Exception e) {
            throw new ModelException("Error Insertando Formula Medicamento Especial :" + 
                                     e.getMessage(), e);
        }
    }


    /**
     * @param lstFormula
     * @param numeroCirugia
     * @param tipoServicio
     * @param consecutivo
     * @throws ModelException
     */
    public void saveListFormulaMedicamentoEspecialCirugia(final List<Chformulaesp> lstFormula, 
                                                          final Long numeroCirugia, 
                                                          final String tipoServicio, 
                                                          final Integer consecutivo) throws ModelException {

        try {
            this.getHibernateTemplate().execute(new HibernateCallback() {
                        public Object doInHibernate(Session session) {


                            if (lstFormula != null && !lstFormula.isEmpty()) {
                                Chformulaesp formula;
                                ChformulaespPK idformula;
                                int consec = 0;
                                Iterator it = lstFormula.iterator();
                                while (it.hasNext()) {
                                    it.next();
                                    formula = lstFormula.get(consec);
                                    idformula = new ChformulaespPK();
                                    if (numeroCirugia != null && 
                                        tipoServicio != null && 
                                        consecutivo != null) {
                                        idformula.setHfelconsulta(numeroCirugia);
                                        idformula.setHfectiposerv(tipoServicio);
                                        idformula.setHfenllave(consecutivo);
                                    }
                                    idformula.setHfenconsecut(new Integer(consec + 
                                                                          1));
                                    formula.setId(idformula);
                                    formula.setHfedfecregistr(new Date());
                                    consec++;
                                    session.saveOrUpdate(formula);


                                }

                            }


                            return lstFormula;
                        }
                    });
        } catch (HibernateException e) {
            throw new ModelException("Error Insertando :" + e.getMessage(), e);
        } catch (Exception e) {
            throw new ModelException("Error Insertando :" + e.getMessage(), e);
        }
    }


    /**
     * @param lstFormula
     * @param numeroCirugia
     * @param tipoServicio
     * @param consecutivo
     * @throws ModelException
     */
    public void saveListFormulaLiquidosCirugia(final List<Chformulaliq> lstFormula, 
                                               final Long numeroCirugia, 
                                               final String tipoServicio, 
                                               final Integer consecutivo, 
                                               final List<Chformulaliq> lstFormulaSuspender) throws ModelException {
        try {
            this.getHibernateTemplate().execute(new HibernateCallback() {
                        public Object doInHibernate(Session session) {

                            if (lstFormulaSuspender != null && 
                                !lstFormulaSuspender.isEmpty()) {
                                for (Chformulaliq forsup: 
                                     lstFormulaSuspender) {
                                    forsup.setHflcestado(IConstantes.ETAPA_SUSPENDER);
                                    session.update(forsup);
                                }
                            }

                            if (numeroCirugia != null) {
                                session.createQuery(" delete  historia.Chformulaliq   where hfllconsulta = " + 
                                                       numeroCirugia + "" + 
                                                       " AND hflnllave =  " + 
                                                       consecutivo).executeUpdate();
                            }

                            if (lstFormula != null && !lstFormula.isEmpty()) {
                                Chformulaliq formula;
                                ChformulaliqPK idformula;
                                int consec = 0;
                                Iterator it = lstFormula.iterator();
                                while (it.hasNext()) {
                                    it.next();
                                    formula = lstFormula.get(consec);
                                    idformula = new ChformulaliqPK();
                                    if (numeroCirugia != null && 
                                        tipoServicio != null && 
                                        consecutivo != null) {
                                        idformula.setHfllconsulta(numeroCirugia);
                                        idformula.setHflnllave(consecutivo);
                                    }
                                    idformula.setHflnconsecutiv(new Integer(consec + 
                                                                            1));
                                    formula.setId(idformula);
                                    formula.setHflctiposerv(tipoServicio);
                                    formula.setHfldfecregistr(new Date());
                                    consec++;
                                    session.saveOrUpdate(formula);

                                }

                            }

                            return lstFormula;
                        }
                    });
        } catch (HibernateException e) {
            throw new ModelException("Error Insertando :" + e.getMessage(), e);
        } catch (Exception e) {
            throw new ModelException("Error Insertando :" + e.getMessage(), e);
        }
    }


    /**
     * @param lstFormula
     * @param numeroCirugia
     * @param tipoServicio
     * @param consecutivo
     * @throws ModelException
     */
    public void saveListFormulaMedicamentosCirugia(final List<Chformulahos> lstFormula, 
                                                   final Long numeroCirugia, 
                                                   final String tipoServicio, 
                                                   final Integer consecutivo, 
                                                   final List<Chformulahos> lstFormulaSuspender) throws ModelException {
        try {
            this.getHibernateTemplate().execute(new HibernateCallback() {
                        public Object doInHibernate(Session session) {

                            if (lstFormulaSuspender != null && 
                                !lstFormulaSuspender.isEmpty()) {
                                for (Chformulahos forsup: 
                                     lstFormulaSuspender) {
                                    forsup.setHfhcetapa(IConstantes.ETAPA_SUSPENDER);
                                    forsup.setHfhdfechamodif(new Date());
                                    forsup.setHfhnevolususp(consecutivo);
                                    forsup.setHfhdhorasusp(new Date());
                                    session.update(forsup);
                                }
                            }

                            if (numeroCirugia != null && 
                                tipoServicio != null && consecutivo != null) {
                                session.createQuery(" delete  historia.Chformulahos   where hfhlconsulta = " + 
                                                       numeroCirugia + "" + 
                                                       " AND hfhctiposerv = " + 
                                                       "'" + tipoServicio + 
                                                       "'" + 
                                                       " AND hfhnevoluconse =  " + 
                                                       consecutivo).executeUpdate();
                            }

                            if (lstFormula != null && !lstFormula.isEmpty()) {
                                Chformulahos formula;
                                ChformulahosPK idformula;
                                int consec = 0;
                                Iterator it = lstFormula.iterator();
                                while (it.hasNext()) {
                                    it.next();
                                    formula = lstFormula.get(consec);
                                    idformula = new ChformulahosPK();
                                    if (numeroCirugia != null && 
                                        tipoServicio != null && 
                                        consecutivo != null) {
                                        idformula.setHfhlconsulta(numeroCirugia);

                                        idformula.setHfhnevoluconse(consecutivo);
                                    }
                                    idformula.setHfhnconsecut(new Integer(consec + 
                                                                          1));
                                    formula.setId(idformula);
                                    formula.setHfhctiposerv(tipoServicio);
                                    formula.setHfhdfecregistr(new Date());
                                    consec++;
                                    session.saveOrUpdate(formula);
                                }
                            }

                            return lstFormula;
                        }
                    });
        } catch (HibernateException e) {
            throw new ModelException("Error Insertando :" + e.getMessage(), e);
        } catch (Exception e) {
            throw new ModelException("Error Insertando :" + e.getMessage(), e);
        }
    }


    /**
     * @param formula
     * @throws ModelException
     */
    public void saveFormulaMedicamentosCirugia(Chformulahos formula) throws ModelException {
        try {
            this.getHibernateTemplate().saveOrUpdate(formula);
        } catch (HibernateException e) {
            throw new ModelException("Error Insertando Formula Medicamentos Cirugia:" + 
                                     e.getMessage(), e);
        } catch (Exception e) {
            throw new ModelException("Error Insertando Formula Medicamentos Cirugia :" + 
                                     e.getMessage(), e);
        }
    }


    /**
     * @param numeroConsulta
     * @return
     * @throws ModelException
     */
    public List<Chformulahos> getFormulaMedicamentosCirugia(Long numeroConsulta, 
                                                            Integer consecutivo) throws ModelException {
        List<Chformulahos> resultList = null;
        List parametros = new ArrayList<Chformulahos>();

        try {
            if (numeroConsulta != null) {
                StringBuffer sb = new StringBuffer();
                sb.append(" select chfh from " + Chformulahos.class.getName() + 
                          " chfh  where chfh.id.hfhlconsulta = ?  and chfh.hfhcetapa in (?,?) ");
                if (consecutivo != null) {
                    sb.append(" and  chfh.id.hfhnevoluconse != ? ");
                }
                parametros.add(numeroConsulta);
                parametros.add(IConstantes.ETAPA_VIGENTE);
                parametros.add(IConstantes.ETAPA_PARCIAL);
                if (consecutivo != null) {
                    parametros.add(consecutivo);
                }

                resultList = 
                        (List<Chformulahos>) this.getHibernateTemplate().find(sb.toString(), parametros.toArray());

                if (!resultList.isEmpty()) {
                    return resultList;
                }
            }

            return null;

        } catch (HibernateException e) {
            throw new ModelException("Error consultando Formula Medicamentos :" + 
                                     e.getMessage(), e);
        } catch (Exception e) {
            throw new ModelException("Error consultando Formula Medicamentos : " + 
                                     e.getMessage(), e);
        }

    }

    /**
     * @param numeroUsuario
     * @param numeroConsulta
     * @return
     * @throws ModelException
     */
    public List<Chformulahos> getFormulaMedicamentosConsultaExterna(Long numeroUsuario, 
                                                                    Long numeroConsulta) throws ModelException {
        List<Chformulahos> resultList = null;
        List parametros = new ArrayList<Chformulahos>();

        try {
            if (numeroConsulta != null && numeroUsuario != null) {
                StringBuffer sb = new StringBuffer();
                sb.append(" select chfh from " + Chformulahos.class.getName() + 
                          " chfh  where chfh.id.hfhlconsulta != ? and chfh.hfhlusuario = ?  and chfh.hfhcetapa in (?,?)  ");

                parametros.add(numeroConsulta);
                parametros.add(numeroUsuario);
                parametros.add(IConstantes.ETAPA_VIGENTE);
                parametros.add(IConstantes.ETAPA_PARCIAL);


                resultList = 
                        (List<Chformulahos>) this.getHibernateTemplate().find(sb.toString(), parametros.toArray());

                if (!resultList.isEmpty()) {
                    return resultList;
                }
            }


            return null;

        } catch (HibernateException e) {
            throw new ModelException("Error consultando Formula Medicamentos :" + 
                                     e.getMessage(), e);
        } catch (Exception e) {
            throw new ModelException("Error consultando Formula Medicamentos : " + 
                                     e.getMessage(), e);
        }

    }


    /**
     * @param numeroConsulta
     * @return
     * @throws ModelException
     */
    public List<Chcontrmedic> getFormulaMedicamentosCirugiaSuministrados(Long numeroConsulta) throws ModelException {
        List<Chcontrmedic> resultList = null;
        List parametros = new ArrayList<Chformulahos>();

        try {
            if (numeroConsulta != null) {
                StringBuffer sb = new StringBuffer();
                sb.append(" select chcm from " + Chcontrmedic.class.getName() + 
                          " chcm  where chcm.id.hcmlconsulta = ?  and chcm.hcmcetapa = ? ");
                parametros.add(numeroConsulta);
                parametros.add(IConstantes.ETAPA_ATENDIDO);


                resultList = 
                        (List<Chcontrmedic>) this.getHibernateTemplate().find(sb.toString(), parametros.toArray());

                if (!resultList.isEmpty()) {
                    return resultList;
                }
            }
            return null;

        } catch (HibernateException e) {
            throw new ModelException("Error consultando Formula Medicamentos Suministrados:" + 
                                     e.getMessage(), e);
        } catch (Exception e) {
            throw new ModelException("Error consultando Formula Medicamentos Suministrados: " + 
                                     e.getMessage(), e);
        }

    }


    /**
     * @param formula
     * @throws ModelException
     */
    public void saveFormulaLiquidos(Chformulaliq formula) throws ModelException {
        try {
            this.getHibernateTemplate().saveOrUpdate(formula);
        } catch (HibernateException e) {
            throw new ModelException("Error Insertando Formula Liquidos:" + 
                                     e.getMessage(), e);
        } catch (Exception e) {
            throw new ModelException("Error Insertando Formula Liquidos :" + 
                                     e.getMessage(), e);
        }
    }


    /**
     * @param cirugia
     * @return
     * @throws ModelException
     */
    public List<Cnconsclin> getCirugiasPorFactura(final Chcirugprogr cirugia) throws ModelException {
        List<Cnconsclin> pis = 
            (List<Cnconsclin>)getHibernateTemplate().execute(new HibernateCallback() {
                    public Object doInHibernate(Session session) throws HibernateException {

                        String idConsulta = null;


                        StringBuffer sb = new StringBuffer();
                        sb.append(" select cncl from " + 
                                  Cnconsclin.class.getName() + 
                                  " cncl  where cncl.cconnumero in  ").append(idConsulta);

                        sb.append(" order by cncl.cconnumero desc ");

                        String hql = sb.toString();

                        Query query = session.createQuery(hql);
                        List<Cnconsclin> pis;
                        pis = query.list();

                        for (Cnconsclin co: pis) {
                            Cpservicio servicio = co.getCcocservic();
                            Hibernate.initialize(servicio);


                        }

                        return pis;
                    }
                });
        return pis;
    }


    /**
     * @param factura
     * @return
     * @throws ModelException
     */
    public List<Cnconsclin> getCirugiasPorFactura(final Ccfactvent factura) throws ModelException {
        List<Cnconsclin> pis = 
            (List<Cnconsclin>)getHibernateTemplate().execute(new HibernateCallback() {
                    public Object doInHibernate(Session session) throws HibernateException {

                        if (factura != null) {
                            StringBuffer sb = new StringBuffer();
                            sb.append(" select cncl from " + 
                                      Cnconsclin.class.getName() + 
                                      " cncl  where cncl.ccontipdoc.ctdnnumero =   ").append(factura.getCfvntipdoc());
                            sb.append(" and cncl.ccocestado = 'VG' ");
                            sb.append(" and ((cncl.ccocservic.csvngrupo in (61,62,63,64,65) and cncl.ccocservic.csvnsubgru between 5 and 14 ) ");
                            sb.append(" or (cncl.ccocservic.csvngrupo = 69 and cncl.ccocservic.csvnsubgru = 3 )) ");
                            sb.append(" and cncl.cconnumdoc =   ").append(factura.getCfvnnumero());
                            sb.append(" order by cncl.cconnumero desc ");

                            String hql = sb.toString();

                            Query query = session.createQuery(hql);
                            List<Cnconsclin> pis;
                            pis = query.list();

                            for (Cnconsclin co: pis) {
                                Cpservicio servicio = co.getCcocservic();
                                Hibernate.initialize(servicio);


                            }

                            return pis;

                        }

                        return null;
                    }
                });
        return pis;
    }


    /**
     * @param cconnumdoc
     * @param ccontipdoc
     * @return
     * @throws ModelException
     */
    public List<Cnconsclin> getCirugiasPorFactura(final Integer cconnumdoc, 
                                                  final Integer ccontipdoc) throws ModelException {
        List<Cnconsclin> pis = 
            (List<Cnconsclin>)getHibernateTemplate().execute(new HibernateCallback() {
                    public Object doInHibernate(Session session) throws HibernateException {


                        StringBuffer sb = new StringBuffer();
                        sb.append(" select cncl from " + 
                                  Cnconsclin.class.getName() + 
                                  " cncl  where cncl.ccontipdoc.ctdnnumero =   ").append(ccontipdoc);
                        sb.append(" and cncl.ccocestado = 'PR' ");
                        sb.append(" and ((cncl.ccocservic.csvngrupo in (61,62,63,64,65) and cncl.ccocservic.csvnsubgru between 5 and 14 ) ");
                        sb.append(" or (cncl.ccocservic.csvngrupo = 69 and cncl.ccocservic.csvnsubgru = 3 )) ");
                        sb.append(" and cncl.cconnumdoc =   ").append(cconnumdoc);
                        sb.append(" order by cncl.cconnumero desc ");

                        String hql = sb.toString();

                        Query query = session.createQuery(hql);
                        List<Cnconsclin> pis;
                        pis = query.list();

                        for (Cnconsclin co: pis) {
                            Cpservicio servicio = co.getCcocservic();
                            Hibernate.initialize(servicio);


                        }

                        return pis;
                    }
                });
        return pis;
    }


    /**
     * @param usuario
     * @return
     * @throws ModelException
     */
    public List<Ccfactvent> getFacturasCirugia(Chusuario usuario) throws ModelException {
        List<Ccfactvent> resultList = null;
        List parametros = new ArrayList();
        try {
            //TODO: FALTA FILTRAR QUE NADA MAS MUESTRE LAS CIRUGIAS; FALTA SABER CUAL ES EL GRUPO Y SUBGRUPO QUE ME MUESTRAN LAS CIRUGIAS
            StringBuffer sb = new StringBuffer();
            sb.append(" select distinct ccfv from " + 
                      Ccfactvent.class.getName() + 
                      " ccfv, Cnconsclin cncl  where ccfv.cfvnestado = ? ");
            sb.append(" and ccfv.cfvntipdoc = cncl.ccontipdoc and ccfv.cfvnnumero = cncl.cconnumdoc ");
            sb.append(" and cncl.ccocetapa = ? and cncl.ccocestado  = ? and cncl.ccolusuario = ccfv.cfvlusuario  ");
            sb.append(" and ((cncl.ccocservic.csvngrupo in (61,62,63,64,65) and cncl.ccocservic.csvnsubgru between 5 and 14 ) ");
            sb.append(" or (cncl.ccocservic.csvngrupo = 69 and cncl.ccocservic.csvnsubgru = 3 )) ");
            parametros.add(IConstantes.CASENTADO);
            parametros.add(IConstantes.ETAPA_ESPERA);
            parametros.add(IConstantes.ESTADO_VIGENTE);


            if (usuario.getHusetipoiden() != null && 
                !usuario.getHusetipoiden().equals("")) {
                sb.append(" AND ccfv.cfvctipide = ? ");
                parametros.add(usuario.getHusetipoiden());
            }

            if (usuario.getHusanumeiden() != null && 
                !usuario.getHusanumeiden().equals("")) {
                sb.append(" and ccfv.cfvanumide =  ? ");
                parametros.add(usuario.getHusanumeiden());
            }

            if (usuario.getHuscprimernomb() != null && 
                !usuario.getHuscprimernomb().equals("")) {
                sb.append(" and ccfv.cfvcprinom = ?  ");
                parametros.add(usuario.getHuscprimernomb().toUpperCase());
            }

            if (usuario.getHuscsegundnomb() != null && 
                !usuario.getHuscsegundnomb().equals("")) {
                sb.append(" and ccfv.cfvcsegnom = ?  ");
                parametros.add(usuario.getHuscsegundnomb().toUpperCase());
            }

            if (usuario.getHuscprimerapel() != null && 
                !usuario.getHuscprimerapel().equals("")) {
                sb.append(" and ccfv.cfvcpriape = ?  ");
                parametros.add(usuario.getHuscprimerapel().toUpperCase());
            }

            if (usuario.getHuscsegundapel() != null && 
                !usuario.getHuscsegundapel().equals("")) {
                sb.append(" and ccfv.cfvcsegape = ?  ");
                parametros.add(usuario.getHuscsegundapel().toUpperCase());
            }

            sb.append(" order by ccfv.cfvnconsec desc ");


            resultList = 
                    (List<Ccfactvent>) this.getHibernateTemplate().find(sb.toString(), parametros.toArray());

            if (!resultList.isEmpty()) {
                return resultList;
            }

            return null;

        } catch (HibernateException e) {
            throw new ModelException("Error consultando Facturas de Cirugia:" + 
                                     e.getMessage(), e);
        } catch (Exception e) {
            throw new ModelException("Error consultando Facturas de Cirugia:" + 
                                     e.getMessage(), e);
        }

    }


    /**
     * @param usuario
     * @return
     * @throws ModelException
     */
    public List<Chusuario> getUsuarioCirugia(Chusuario usuario) throws ModelException {
        List<Chusuario> resultList = null;
        List parametros = new ArrayList();
        try {
            StringBuffer sb = new StringBuffer();
            sb.append(" select distinct chus from ");
            sb.append(Chusuario.class.getName()).append("  chus, ");
            sb.append(Ccfactvent.class.getName()).append("  ccfv, ");
            sb.append(Cnconsclin.class.getName()).append("  cncl ");
            sb.append(" where ccfv.cfvnestado = ? ");
            sb.append(" and  chus.huslnumero = ccfv.cfvlusuario ");
            sb.append(" and ccfv.cfvntipdoc = cncl.ccontipdoc and ccfv.cfvnnumero = cncl.cconnumdoc ");
            sb.append(" and cncl.ccocetapa = ? and cncl.ccocestado  = ? and cncl.ccolusuario = ccfv.cfvlusuario  ");
            sb.append(" and ((cncl.ccocservic.csvngrupo in (61,62,63,64,65) and cncl.ccocservic.csvnsubgru between 5 and 14 ) ");
            sb.append(" or (cncl.ccocservic.csvngrupo = 69 and cncl.ccocservic.csvnsubgru = 3 )) ");
            parametros.add(IConstantes.CASENTADO);
            parametros.add(IConstantes.ETAPA_ESPERA);
            parametros.add(IConstantes.ESTADO_VIGENTE);


            if (usuario.getHusetipoiden() != null && 
                !usuario.getHusetipoiden().equals("")) {
                sb.append(" AND ccfv.cfvctipide = ? ");
                parametros.add(usuario.getHusetipoiden());
            }

            if (usuario.getHusanumeiden() != null && 
                !usuario.getHusanumeiden().equals("")) {
                sb.append(" and ccfv.cfvanumide =  ? ");
                parametros.add(usuario.getHusanumeiden());
            }

            if (usuario.getHuscprimernomb() != null && 
                !usuario.getHuscprimernomb().equals("")) {
                sb.append(" and ccfv.cfvcprinom = ?  ");
                parametros.add(usuario.getHuscprimernomb().toUpperCase());
            }

            if (usuario.getHuscsegundnomb() != null && 
                !usuario.getHuscsegundnomb().equals("")) {
                sb.append(" and ccfv.cfvcsegnom = ?  ");
                parametros.add(usuario.getHuscsegundnomb().toUpperCase());
            }

            if (usuario.getHuscprimerapel() != null && 
                !usuario.getHuscprimerapel().equals("")) {
                sb.append(" and ccfv.cfvcpriape = ?  ");
                parametros.add(usuario.getHuscprimerapel().toUpperCase());
            }

            if (usuario.getHuscsegundapel() != null && 
                !usuario.getHuscsegundapel().equals("")) {
                sb.append(" and ccfv.cfvcsegape = ?  ");
                parametros.add(usuario.getHuscsegundapel().toUpperCase());
            }


            resultList = 
                    (List<Chusuario>) this.getHibernateTemplate().find(sb.toString(), parametros.toArray());

            if (!resultList.isEmpty()) {
                return resultList;
            }

            return null;

        } catch (HibernateException e) {
            throw new ModelException("Error consultando Facturas de Cirugia:" + 
                                     e.getMessage(), e);
        } catch (Exception e) {
            throw new ModelException("Error consultando Facturas de Cirugia:" + 
                                     e.getMessage(), e);
        }

    }


    /**
     * @param programar
     * @throws ModelException
     */
    public void updateChcirugprogr(final Chcirugprogr programar, 
                                   final Chregicirpro regicipro, 
                                   final Chciruganula ciruanula) throws ModelException {

        try {
            this.getHibernateTemplate().execute(new HibernateCallback() {
                        public Object doInHibernate(Session session) {


                            Integer consecutivo = null;

                            if (ciruanula != null) {
                                StringBuffer sb1 = new StringBuffer();
                                sb1.append(" select max(chci.id.hcanconsec) from " + 
                                           Chciruganula.class.getName() + 
                                           " chci where chci.id.hcalnumero = :hcalnumero ");
                                Query query1 = 
                                    session.createQuery(sb1.toString());

                                query1.setParameter("hcalnumero", 
                                                    ciruanula.getId().getHcalnumero());


                                Integer secuenciaActual = 
                                    (Integer)query1.uniqueResult();


                                if (secuenciaActual != null) {
                                    consecutivo = 
                                            secuenciaActual.intValue() + 1;
                                } else {
                                    consecutivo = 1;
                                }

                            }
                            if (consecutivo != null) {
                                ciruanula.getId().setHcanconsec(consecutivo);
                                session.saveOrUpdate(ciruanula);
                            }


                            session.saveOrUpdate(programar);

                            if (regicipro != null && !regicipro.equals("")) {
                                session.saveOrUpdate(regicipro);
                            }
                            if (ciruanula != null && !ciruanula.equals("")) {
                                session.saveOrUpdate(ciruanula);
                            }


                            return programar;
                        }
                    });

        } catch (HibernateException e) {
            throw new ModelException("Error actualizando :" + e.getMessage(), 
                                     e);
        } catch (Exception e) {
            throw new ModelException("Error actualizando :" + e.getMessage(), 
                                     e);
        }
    }

    /**
     * @param programar
     * @param lstCirugias
     * @throws ModelException
     */
    public void updateProgramarCirugia(final Chcirugprogr programar, 
                                       final List<Chdetacirpro> lstCirugias) throws ModelException {
        try {
            this.getHibernateTemplate().execute(new HibernateCallback() {
                        public Object doInHibernate(Session session) {

                            String servicio = "("; 
                            session.saveOrUpdate(programar);
                            
                            List<String> lstServicios = new ArrayList<String>();
                            
                           


                            for (Chdetacirpro detalle: lstCirugias) {
                                if (programar != null && 
                                    programar.getHcplnumero() != null) {
                                    if (detalle.getId().getHdclconsuprinc() == 
                                        null) {
                                        detalle.getId().setHdclconsuprinc(programar.getHcplnumero());
                                        lstServicios.add(detalle.getId().getHdccservicio());
                                        session.saveOrUpdate(detalle);
                                        servicio = servicio +"'"+ detalle.getId().getHdccservicio()+"'" +",";
                                    } else {
                                        Chdetacirpro detalleActual = null;

                                        StringBuffer sb1 = new StringBuffer();
                                        sb1.append(" select chdc from Chdetacirpro" + 
                                                  " chdc  where chdc.id.hdclconsuprinc = :hdclconsuprinc  AND chdc.id.hdccservicio = :hdccservicio ");
                                        Query query1 = 
                                            session.createQuery(sb1.toString());
                                        query1.setParameter("hdclconsuprinc", 
                                                           detalle.getId().getHdclconsuprinc());
                                        query1.setParameter("hdccservicio", 
                                                           detalle.getId().getHdccservicio());

                                        detalleActual = 
                                                (Chdetacirpro)query1.uniqueResult();

                                        detalleActual.setHdcnmedicatien(detalle.getHdcnmedicatien());
                                        
                                        lstServicios.add(detalleActual.getId().getHdccservicio());
                                        
                                        servicio = servicio +"'"+ detalle.getId().getHdccservicio()+"'" +",";

                                        session.saveOrUpdate(detalleActual);
                                        
                                    }
                                    
                             }
                             
                            }
                                
                            servicio = servicio + "'0' )";
                            
                            StringBuffer sb = new StringBuffer();
                            sb.append(" delete  historia.Chdetacirpro ");
                            sb.append(" where hdclconsuprinc = :numeroConsulta ");
                            sb.append(" and hdccservicio not in   ").append(servicio);
                            
                            
                            Query query = 
                                session.createQuery(sb.toString());
                            query.setParameter("numeroConsulta", 
                                               programar.getHcplnumero());
                          
                            
                            query.executeUpdate();

                                                       
                               
                            return programar;
                        }
                    });
        } catch (HibernateException e) {
            throw new ModelException("Error Insertando :" + e.getMessage(), e);
        } catch (Exception e) {
            throw new ModelException("Error Insertando :" + e.getMessage(), e);
        }
    }


 

    /**
     * @param numeroCirugia
     * @return
     * @throws ModelException
     */
    public List<Object[]> getListaDescripcionQuirurgicaByUsuario(Long numeroCirugia) throws ModelException {
        List resultList = null;
        try {
            if (numeroCirugia != null) {
                StringBuffer sb = new StringBuffer();
                    sb.append("SELECT chdd.hddlnumero, "); //0
                    sb.append(" chdd.hddnconsec, ");       //1
                    sb.append(" chdd.hdddfecregistr, ");   //2
                    sb.append(" chcd.hcdcintervenci, ");   //3
                    sb.append(" cpse.csvcnombre, ");       //4
                    sb.append(" chdd.hddccirujano, ");     //5
                    sb.append(" chdd.hddcanestesiol, ");   //6
                    sb.append(" chdd.hddctipoaneste, ");   //7
                    sb.append(" chdd.hddninstrument, ");   //8
                    sb.append(" chdd.hddncirculante, ");   //9
                    sb.append(" chdd.hddlusuario, ");      //10
                    sb.append(" chdd.hddntiempohora, ");   //11
                    sb.append(" chdd.hddntiempominu, ");   //12
                    sb.append(" chdd.hddcdiagnprinc, ");   //13
                    sb.append(" chdd.hddcdiagnrelac, ");   //14
                    sb.append(" chdd.hddcpiezapatol, ");   //15
                    sb.append(" chdd.hddchallazgos, ");    //16
                    sb.append(" chdd.hddcdescripcio, ");   //17
                    sb.append(" cpse.csvccodcups, ");      //18
                    sb.append(" chcd.hcdcintervepra, ");   //19
                    sb.append(" cpse.csvcnombre,  ");      //20
                    sb.append(" chdd.hddcayudante1, ");    //21
                    sb.append(" chdd.hddcayudante2, ");    //22
                    sb.append(" chcd.hcdcestado, ");       //23
                    sb.append(" chdd.hddcanotardiur, ");   //24
                    sb.append(" chdd.hddncantidadiu, ");   //25
                    sb.append(" chdd.hddcaspectodiu, ");   //26
                    sb.append(" chdd.hddctienesangr, ");   //27
                    sb.append(" chdd.hddnsangraprox, ");   //28
                    sb.append(" chdd.hddctienecompl, ");   //29
                    sb.append(" chdd.hddcdescrcompl,  ");    //30 
                    sb.append(" chdd.hddcmediayud1,  ");    //31
                    sb.append(" chdd.hddcmediayud2,  ");    //32
                    sb.append(" chdd.hddcnomresiden1,  ");    //33
                    sb.append(" chdd.hddcnomresiden2 , ");    //34
                    sb.append(" chus.husdfechanacim,  "); // 35
                   sb.append(" EXTRACT(YEAR FROM chdd.hdddfecregistr)-EXTRACT(YEAR FROM chus.HUSDFECHANACIM) edad, "); // 36
                    sb.append(" chdd.hddcdiagncompl,  "); // 37
                    sb.append(" chdd.hddccuantifi,  "); // 38
                    sb.append(" chdd.hddccuantidiure,  "); // 39
                    sb.append(" chdd.hddcgradohemar  "); // 40
                    sb.append("FROM historia.chdetaldescr chdd, ");
                    sb.append(" historia.chcirdetdesc chcd, ");
                    sb.append(" clinico.cpservicio cpse, ");
                    sb.append(" historia.chusuario chus ");
                    sb.append("WHERE chdd.hddlnumero = chcd.hcdlnumero and ");
                    sb.append("  chdd.hddnconsec = chcd.hcdnconsec ");
                    sb.append("  and cpse.csvccodigo = chcd.hcdcintervenci ");
                    sb.append("  and chdd.hddlnumero = :numeroCirugia ");
                    sb.append(" and chus.huslnumero = chdd.hddlusuario ");
                    sb.append("  and chdd.hddcestado = 'VG' ");
                    sb.append(" order by chdd.hddnconsec ");

                Query sqlquery = 
                    this.getHibernateTemplate().getSessionFactory().getCurrentSession().createQuery(sb.toString());
                sqlquery.setParameter("numeroCirugia", numeroCirugia);

                resultList = sqlquery.list();

                if (!resultList.isEmpty()) {
                    return resultList;
                }

            }
            return null;

        } catch (HibernateException e) {
            throw new ModelException("Error consultando DescripcionQuirurgica por Usuario :" + 
                                     e.getMessage(), e);
        } catch (Exception e) {
            throw new ModelException("Error consultando DescripcionQuirurgica por Usuario: " + 
                                     e.getMessage(), e);
        }

    }




     
    /**
     * @param usuario
     * @return
     * @throws ModelException
     */
    /* public List<Chdetacirpro> getListaDescripcionQuirurgicaByUsuarioo(Long usuario) throws ModelException {
        List<Cnconsclin> resultList = null;


        try {
            if (usuario != null) {
                StringBuffer sb = new StringBuffer();
                sb.append("SELECT chdd.hddlnumero, ");
                sb.append(" chdd.hddnconsec, ");
                sb.append(" chdd.hdddfecregistr, ");
                sb.append(" chcd.hcdcintervenci, ");
                sb.append(" cpse.csvcnombre, ");
                sb.append(" chdd.hddccirujano, ");
                sb.append(" chdd.hddcanestesiol, ");
                sb.append(" chdd.hddctipoaneste, ");
                sb.append(" chdd.hddninstrument, ");
                sb.append(" chdd.hddncirculante, ");
                sb.append(" chdd.hddlusuario, ");
                sb.append(" chdd.hddntiempohora, ");
                sb.append(" chdd.hddntiempominu, ");
                sb.append(" chdd.hddcdiagnprinc, ");
                sb.append(" chdd.hddcdiagnrelac, ");
                sb.append(" chdd.hddcpiezapatol, ");
                sb.append(" chdd.hddchallazgos, ");
                sb.append(" chdd.hddcdescripcio ");
                sb.append("FROM historia.chdetaldescr chdd, ");
                sb.append(" historia.chcirdetdesc chcd, ");
                sb.append(" clinico.cpservicio cpse ");
                sb.append("WHERE chdd.hddlnumero = chcd.hcdlnumero and ");
                sb.append("  chdd.hddnconsec = chcd.hcdnconsec ");
                sb.append("  and cpse.csvccodigo = chcd.hcdcintervenci ");
                sb.append("  and chdd.hddlusuario = :usuario ");
                sb.append("  and chdd.hddcestado = 'VG' ");
                sb.append(" order by chdd.hdddfecregistr desc ");

                Query sqlquery =
                    this.getHibernateTemplate().getSessionFactory().getCurrentSession().createQuery(sb.toString());
                sqlquery.setParameter("usuario", usuario);

                resultList = sqlquery.list();

                if (!resultList.isEmpty()) {
                    return resultList;
                }
            }
            return null;

        } catch (HibernateException e) {
            throw new ModelException("Error consultando DescripcionQuirurgica por Usuario :" +
                                     e.getMessage(), e);
        } catch (Exception e) {
            throw new ModelException("Error consultando DescripcionQuirurgica por Usuario: " +
                                     e.getMessage(), e);
        }

    }



    */


    /**
     * @param usuario
     * @return
     * @throws ModelException
     */
    public List<Object[]> getListaDescripcionQuirurgicaByAclaracion(Long usuario) throws ModelException {
        List resultList = null;

        String HORA_INICIAL = " 00:00";
        String HORA_FINAL = " 23:59";
        String fechaI = null;
        String fechaF = null;

        int diferenciaEnDias = 1;
        Date fechaActual = Calendar.getInstance().getTime();
        long tiempoActual = fechaActual.getTime();
        long unDia = diferenciaEnDias * 24 * 60 * 60 * 1000 * 7;
        Date fechaAyer = new Date(tiempoActual - unDia);

        Date fechaFinal = new Date();


        if (fechaAyer != null && fechaFinal != null) {
            SimpleDateFormat dateFormat = new SimpleDateFormat("dd/MM/yyyy");

            fechaI = dateFormat.format(fechaAyer) + HORA_INICIAL;

            fechaF = dateFormat.format(fechaFinal) + HORA_FINAL;

        }


        try {
            if (usuario != null) {
                StringBuffer sb = new StringBuffer();
                sb.append(" SELECT chdd.hddlnumero,chdd.hddnconsec,chdd.hdddfecregistr, chcd.hcdcintervenci, cpse.csvcnombre, chdd.hddlusuario ");
                sb.append("     FROM historia.chdetaldescr chdd, historia.chcirdetdesc chcd, clinico.cpservicio cpse ");
                sb.append("  where chdd.hddlnumero = chcd.hcdlnumero and chdd.hddnconsec = chcd.hcdnconsec  ");
                sb.append("  and cpse.csvccodigo = chcd.hcdcintervenci ");
                sb.append("   and chdd.hddlusuario = :usuario and chdd.hddcestado != 'XX' ");
                sb.append(" AND (chdd.hdddfecregistr BETWEEN TO_DATE(:fechaI,'dd/MM/yyyy hh24:mi') AND TO_DATE(:fechaF,'dd/MM/yyyy hh24:mi'))");
                sb.append(" order by chdd.hdddfecregistr desc   ");


                Query sqlquery = 
                    this.getHibernateTemplate().getSessionFactory().getCurrentSession().createQuery(sb.toString());
                sqlquery.setParameter("usuario", usuario);
                sqlquery.setParameter("fechaI", fechaI);
                sqlquery.setParameter("fechaF", fechaF);


                resultList = sqlquery.list();

                if (!resultList.isEmpty()) {
                    return resultList;
                }
            }
            return null;

        } catch (HibernateException e) {
            throw new ModelException("Error consultando DescripcionQuirurgica por Usuario :" + 
                                     e.getMessage(), e);
        } catch (Exception e) {
            throw new ModelException("Error consultando DescripcionQuirurgica por Usuario: " + 
                                     e.getMessage(), e);
        }

    }


    /**
     * @param autoriza
     * @throws ModelException
     */
    public void saveAutorizacionDescripcion(final Chautordescr autoriza) throws ModelException {

        try {
            this.getHibernateTemplate().execute(new HibernateCallback() {
                        public Object doInHibernate(Session session) {
                            Integer consecutivo = null;
                            if (autoriza != null) {
                                Long huslnumero = null;

                                if (autoriza != null && 
                                    autoriza.getHadlnumero() == null) {

                                    StringBuffer sb1 = new StringBuffer();
                                    sb1.append(" select max(chad.hadlnumero) from " + 
                                               Chautordescr.class.getName() + 
                                               " chad  ");
                                    Query query1 = 
                                        session.createQuery(sb1.toString());

                                    Long secuenciaActual = 
                                        (Long)query1.uniqueResult();

                                    if (secuenciaActual != null) {
                                        consecutivo = 
                                                secuenciaActual.intValue() + 1;
                                    } else {
                                        consecutivo = 1;
                                    }

                                    if (consecutivo != null) {
                                        autoriza.setHadlnumero(new Long(consecutivo));
                                    }
                                }

                                session.saveOrUpdate(autoriza);
                            }


                            return autoriza;
                        }
                    });
        } catch (HibernateException e) {
            throw new ModelException("Error Insertando Autorizacion Descripcion:" + 
                                     e.getMessage(), e);
        } catch (Exception e) {
            throw new ModelException("Error Insertando Autorizacion Descripcion:" + 
                                     e.getMessage(), e);
        }
    }




    /*
 * detalle de la descripcion quirurgica
 */

    /**
     * @return
     * @throws ModelException
     */
    public Chdetaldescr getDetalleDescripcion(final Long numeroCirugia) throws ModelException {
        List<Chdetaldescr> resultList = null;
        List parametros = new ArrayList();
        try {
            if (numeroCirugia != null) {
                StringBuffer sb = new StringBuffer();
                sb.append(" select chde from " + Chdetaldescr.class.getName());
                sb.append(" chde  where chde.id.hddlnumero = ? ");
                parametros.add(numeroCirugia);


                resultList = 
                        (List<Chdetaldescr>) this.getHibernateTemplate().find(sb.toString(), parametros.toArray());


                if (!resultList.isEmpty()) {
                    return resultList.get(0);
                }

            }


            return null;

        } catch (HibernateException e) {
            throw new ModelException("Error consultando Detalle Descripcion:" + 
                                     e.getMessage(), e);
        } catch (Exception e) {
            throw new ModelException("Error consultando Detalle Descripcion :" + 
                                     e.getMessage(), e);
        }

    }


    /**
     * @return
     * @throws ModelException
     */
    public List<Chautordescr> getSolicitudesPorAprobar(Integer codClinica) throws ModelException {
        List<Chautordescr> resultList = null;
        List parametros = new ArrayList();

        try {

            StringBuffer sb = new StringBuffer();
            sb.append(" select chad from " + Chautordescr.class.getName() + 
                      " chad  where chad.hadnclinica = ? and chad.hadcaceptsolic is null   ");
            parametros.add(codClinica);

            resultList = 
                    (List<Chautordescr>) this.getHibernateTemplate().find(sb.toString(), parametros.toArray());


            if (!resultList.isEmpty()) {
                return resultList;
            }


            return null;

        } catch (HibernateException e) {
            throw new ModelException("Error consultando Solicitudes Por Aprobar:" + 
                                     e.getMessage(), e);
        } catch (Exception e) {
            throw new ModelException("Error consultando Solicitudes Por Aprobar:" + 
                                     e.getMessage(), e);
        }

    }


    /**
     * @param autoriza
     * @param userName
     * @throws ModelException
     */
    public void aprobarAutorizacionDescripcion(final Chautordescr autoriza, 
                                               final String userName) throws ModelException {

        try {
            this.getHibernateTemplate().execute(new HibernateCallback() {
                        public Object doInHibernate(Session session) {
                            if (autoriza != null) {

                                // MODIFICAMOS LA ETAPA DE DESCRIPCION QUIRURGICA


                                if (autoriza.getHadcaceptsolic().equals("S")) {
                                    StringBuffer sb2 = new StringBuffer();
                                    sb2.append(" update historia.chdetaldescr set hddcestado = 'XX' " + 
                                               "  where hddlnumero = :numero and hddnconsec = :consecutivo ");
                                    Query query2 = 
                                        session.createQuery(sb2.toString());
                                    query2.setParameter("numero", 
                                                        autoriza.getHadlnumerdescr());

                                    query2.setParameter("consecutivo", 
                                                        autoriza.getHadnconsedescr());


                                    query2.executeUpdate();

                                }

                                // MODIFICAMOS LAS CIRUGIAS PARA QUE QUEDEN DISPONIBLES PARA REALIZAR LA NUEVA DESCRIPCION QUIRURGICA


                                StringBuffer sb3 = new StringBuffer();
                                sb3.append(" update  historia.chdetacirpro set hdccdescrquiru = 'N', hdcdfechamodif = :fecha, hdccoperamodif = :userName ");
                                sb3.append("  where hdclconsuprinc = :numeroCirugia and hdccservicio in ");
                                sb3.append(" (select hcdcintervenci from historia.chcirdetdesc where hcdlnumero = :numeroCirugia and hcdnconsec = :wconsec) ");
                                Query query3 = 
                                    session.createQuery(sb3.toString());
                                query3.setParameter("fecha", new Date());
                                query3.setParameter("userName", userName);
                                query3.setParameter("numeroCirugia", 
                                                    autoriza.getHadlnumerdescr());
                                query3.setParameter("wconsec", 
                                                    autoriza.getHadnconsedescr());


                                query3.executeUpdate();


                                session.saveOrUpdate(autoriza);
                            }


                            return autoriza;
                        }
                    });
        } catch (HibernateException e) {
            throw new ModelException("Error Autorizando Descripcion:" + 
                                     e.getMessage(), e);
        } catch (Exception e) {
            throw new ModelException("Error Autorizando Descripcion:" + 
                                     e.getMessage(), e);
        }
    }


    /**
     * @param Long usuario
     * @return List<Chepicrisi> 
     * @throws ModelException
     */
    public List<Chepicrisi> getLstEpicrisisByUser(Long usuario) throws ModelException {
        List<Chepicrisi> resultList = null;

        try {
            if (usuario != null) {
                StringBuffer sb = new StringBuffer();
                sb.append(" select chep from " + Chepicrisi.class.getName() + 
                          " chep  where chep.heplusuario = ? and chep.hepcestado = 'VG' ");

                resultList = 
                        (List<Chepicrisi>) this.getHibernateTemplate().find(sb.toString(), usuario);
            }

            if (resultList != null && !resultList.isEmpty()) {
                return resultList;
            }

            return null;

        } catch (HibernateException e) {
            throw new ModelException("Error consultando Epicrisis:" + 
                                     e.getMessage(), e);
        } catch (Exception e) {
            throw new ModelException("Error consultando Epicrisis: " + 
                                     e.getMessage(), e);
        }
    }


    /**
     * @param epicrisis
     * @throws ModelException
     */
    public void saveEpicrisis(final Chepicrisi epicrisis) throws ModelException {
        try {
            this.getHibernateTemplate().execute(new HibernateCallback() {
                        Integer consecutivo = null;

                        public Object doInHibernate(Session session) {


                            if (epicrisis.getId().getHepnconsec() == null && 
                                epicrisis.getId().getHeplnumero() != null) {

                                // Obtenemos el n�mero de 
                                StringBuffer sb1 = new StringBuffer();
                                sb1.append(" select max(chep.id.hepnconsec) from " + 
                                           Chepicrisi.class.getName() + 
                                           " chep where chep.id.heplnumero = :heplnumero  ");
                                Query query1 = 
                                    session.createQuery(sb1.toString());
                                query1.setParameter("heplnumero", 
                                                    epicrisis.getId().getHeplnumero());

                                Integer secuenciaActual = 
                                    (Integer)query1.uniqueResult();

                                if (secuenciaActual != null) {
                                    consecutivo = 
                                            secuenciaActual.intValue() + 1;
                                } else {
                                    consecutivo = 1;
                                }

                                if (consecutivo != null) {
                                    epicrisis.getId().setHepnconsec(consecutivo);
                                }

                            }

                            if (epicrisis != null && 
                                epicrisis.getId() != null) {

                                StringBuffer sb = new StringBuffer();
                                sb.append(" update historia.Chcirugprogr set hcpcestado = 'CE',  hcpcregisepicr = 'S', hcpcoperaepicr = :hcpcoperaepicr " + 
                                          "   where hcplnumero = :numeroCirugia ");
                                Query query = 
                                    session.createQuery(sb.toString());
                                query.setParameter("numeroCirugia", 
                                                   epicrisis.getId().getHeplnumero());
                                query.setParameter("hcpcoperaepicr", 
                                                   epicrisis.getHepcoperador());
                                query.executeUpdate();

                                session.saveOrUpdate(epicrisis);


                            }


                            return epicrisis;
                        }
                    });
        } catch (HibernateException e) {
            throw new ModelException("Error Insertando :" + e.getMessage(), e);
        } catch (Exception e) {
            throw new ModelException("Error Insertando :" + e.getMessage(), e);
        }
    }


    /**
     * @param usuario
     * @return
     * @throws ModelException
     */
    public List<Chepicrisi> getListaEpicrisisByAclaracion(Long usuario) throws ModelException {
        List<Chepicrisi> resultList = null;
        List parametros = new ArrayList<Chformulaesp>();
        try {
            if (usuario != null) {
                StringBuffer sb = new StringBuffer();
                sb.append(" select chep from " + Chepicrisi.class.getName() + 
                          " chep  where chep.heplusuario = ? ");
                sb.append(" and chep.hepcestado = 'VG' ");
                parametros.add(usuario);

                resultList = 
                        (List<Chepicrisi>) this.getHibernateTemplate().find(sb.toString(), parametros.toArray());
            }

            if (resultList != null && !resultList.isEmpty()) {
                return resultList;
            }

            return null;

        } catch (HibernateException e) {
            throw new ModelException("Error consultando Epicrisis:" + 
                                     e.getMessage(), e);
        } catch (Exception e) {
            throw new ModelException("Error consultando Epicrisis: " + 
                                     e.getMessage(), e);
        }
    }


    /**
     * @return
     * @throws ModelException
     */
    public Chautorepicr getAutorizacionEpicrisis(final Chautorepicr autorizacion) throws ModelException {
        List<Chautorepicr> resultList = null;
        List parametros = new ArrayList();
        try {
            if (autorizacion != null) {
                StringBuffer sb = new StringBuffer();
                sb.append(" select chae from " + Chautorepicr.class.getName());
                sb.append(" chae  where chae.haelnumerepicr  = ? ");
                sb.append(" and chae.haenconseepicr  = ? ");
                sb.append(" and chae.haecaceptsolic is null ");

                parametros.add(autorizacion.getHaelnumerepicr());
                parametros.add(autorizacion.getHaenconseepicr());


                resultList = 
                        (List<Chautorepicr>) this.getHibernateTemplate().find(sb.toString(), parametros.toArray());


                if (!resultList.isEmpty()) {
                    return resultList.get(0);
                }

            }


            return null;

        } catch (HibernateException e) {
            throw new ModelException("Error consultando Autorizacion Epicrisis:" + 
                                     e.getMessage(), e);
        } catch (Exception e) {
            throw new ModelException("Error consultando Autorizacion Epicrisis :" + 
                                     e.getMessage(), e);
        }

    }


    /**
     * @param autoriza
     * @throws ModelException
     */
    public void saveAutorizacionEpicrisis(final Chautorepicr autoriza) throws ModelException {

        try {
            this.getHibernateTemplate().execute(new HibernateCallback() {
                        public Object doInHibernate(Session session) {
                            Integer consecutivo = null;
                            if (autoriza != null) {


                                if (autoriza != null && 
                                    autoriza.getHaelnumero() == null) {

                                    StringBuffer sb1 = new StringBuffer();
                                    sb1.append(" select max(chae.haelnumero) from " + 
                                               Chautorepicr.class.getName() + 
                                               " chae  ");
                                    Query query1 = 
                                        session.createQuery(sb1.toString());

                                    Long secuenciaActual = 
                                        (Long)query1.uniqueResult();

                                    if (secuenciaActual != null) {
                                        consecutivo = 
                                                secuenciaActual.intValue() + 1;
                                    } else {
                                        consecutivo = 1;
                                    }

                                    if (consecutivo != null) {
                                        autoriza.setHaelnumero(new Long(consecutivo));
                                    }
                                }

                                session.saveOrUpdate(autoriza);
                            }


                            return autoriza;
                        }
                    });
        } catch (HibernateException e) {
            throw new ModelException("Error Insertando Autorizacion Epicrisis:" + 
                                     e.getMessage(), e);
        } catch (Exception e) {
            throw new ModelException("Error Insertando Autorizacion Epicrisis:" + 
                                     e.getMessage(), e);
        }
    }


    /**
     * @return
     * @throws ModelException
     */
    public List<Chautorepicr> getEpicrisisPorAprobar(Integer codClinica) throws ModelException {
        List<Chautorepicr> resultList = null;
        List parametros = new ArrayList();

        try {

            StringBuffer sb = new StringBuffer();
            sb.append(" select chae from " + Chautorepicr.class.getName() + 
                      " chae  where chae.haenclinica = ? and chae.haecaceptsolic is null   ");
            parametros.add(codClinica);

            resultList = 
                    (List<Chautorepicr>) this.getHibernateTemplate().find(sb.toString(), parametros.toArray());


            if (!resultList.isEmpty()) {
                return resultList;
            }


            return null;

        } catch (HibernateException e) {
            throw new ModelException("Error consultando Epicrisis Por Aprobar:" + 
                                     e.getMessage(), e);
        } catch (Exception e) {
            throw new ModelException("Error consultando Epicrisis Por Aprobar:" + 
                                     e.getMessage(), e);
        }

    }


    /**
     * @param autoriza
     * @param userName
     * @throws ModelException
     */
    public void aprobarAutorizacionEpicrisis(final Chautorepicr autoriza, 
                                             final String userName) throws ModelException {

        try {
            this.getHibernateTemplate().execute(new HibernateCallback() {
                        public Object doInHibernate(Session session) {
                            if (autoriza != null) {

                                // MODIFICAMOS LA ETAPA DE DESCRIPCION QUIRURGICA


                                if (autoriza.getHaecaceptsolic().equals("S")) {
                                    StringBuffer sb2 = new StringBuffer();
                                    sb2.append(" update historia.chepicrisis set hepcestado = 'XX' " + 
                                               "  where heplnumero = :numero and hepnconsec = :consecutivo ");
                                    Query query2 = 
                                        session.createQuery(sb2.toString());
                                    query2.setParameter("numero", 
                                                        autoriza.getHaelnumerepicr());

                                    query2.setParameter("consecutivo", 
                                                        autoriza.getHaenconseepicr());


                                    query2.executeUpdate();

                                }

                                // MODIFICAMOS LAS CIRUGIAS PARA QUE QUEDEN DISPONIBLES PARA REALIZAR LA NUEVA EPICRISIS


                                StringBuffer sb3 = new StringBuffer();
                                sb3.append(" update historia.chcirugprogr set hcpcregisepicr = 'N', hcpdfechamodif = :fecha, hcpcoperamodif = :userName  ");
                                sb3.append(" where hcplnumero = :wnumero ");
                                sb3.append(" ");
                                Query query3 = 
                                    session.createQuery(sb3.toString());
                                query3.setParameter("wnumero", 
                                                    autoriza.getHaelnumerepicr());
                                query3.setParameter("fecha", new Date());
                                query3.setParameter("userName", userName);


                                query3.executeUpdate();


                                session.saveOrUpdate(autoriza);
                            }


                            return autoriza;
                        }
                    });
        } catch (HibernateException e) {
            throw new ModelException("Error Autorizando Descripcion:" + 
                                     e.getMessage(), e);
        } catch (Exception e) {
            throw new ModelException("Error Autorizando Descripcion:" + 
                                     e.getMessage(), e);
        }
    }


    /**
     * @param signos
     * @throws ModelException
     */
    public void saveSignosVitales(final Chsignovital signos) throws ModelException {
        try {
            this.getHibernateTemplate().execute(new HibernateCallback() {
                        public Object doInHibernate(Session session) {
                            Integer consecutivo = null;
                            if (signos != null) {


                                if (signos.getId().getHsvlconsecutiv() == 
                                    null) {
                                    StringBuffer sb1 = new StringBuffer();
                                    sb1.append(" select max(chsv.id.hsvlconsecutiv) from " + 
                                               Chsignovital.class.getName() + 
                                               " chsv where chsv.id.hsvlconsulta = :numero ");

                                    Query query1 = 
                                        session.createQuery(sb1.toString());
                                    query1.setParameter("numero", 
                                                        signos.getId().getHsvlconsulta());

                                    Integer secuenciaActual = 
                                        (Integer)query1.uniqueResult();

                                    if (secuenciaActual != null) {
                                        consecutivo = 
                                                secuenciaActual.intValue() + 1;
                                    } else {
                                        consecutivo = 1;
                                    }
                                    if (consecutivo != null) {
                                        signos.getId().setHsvlconsecutiv(consecutivo);
                                    }
                                }


                                session.saveOrUpdate(signos);

                            }


                            return signos;
                        }
                    });
        } catch (HibernateException e) {
            throw new ModelException("Error Insertando signos vitales: " + 
                                     e.getMessage(), e);
        } catch (Exception e) {
            throw new ModelException("Error Insertando signos vitales: " + 
                                     e.getMessage(), e);
        }
    }


    /**
     * @param aldrete
     * @throws ModelException
     */
    public void saveAldrete(final Chaldrete aldrete) throws ModelException {
        try {
            this.getHibernateTemplate().execute(new HibernateCallback() {
                        public Object doInHibernate(Session session) {
                            Integer consecutivo = null;
                            if (aldrete != null) {


                                if (aldrete.getId().getHallconsecutiv() == 
                                    null) {
                                    StringBuffer sb1 = new StringBuffer();
                                    sb1.append(" select max(chal.id.hallconsecutiv) from " + 
                                               Chaldrete.class.getName() + 
                                               " chal where chal.id.hallconsulta = :numero ");

                                    Query query1 = 
                                        session.createQuery(sb1.toString());
                                    query1.setParameter("numero", 
                                                        aldrete.getId().getHallconsulta());

                                    Integer secuenciaActual = 
                                        (Integer)query1.uniqueResult();

                                    if (secuenciaActual != null) {
                                        consecutivo = 
                                                secuenciaActual.intValue() + 1;
                                    } else {
                                        consecutivo = 1;
                                    }
                                    if (consecutivo != null) {
                                        aldrete.getId().setHallconsecutiv(consecutivo);
                                    }
                                }


                                session.saveOrUpdate(aldrete);

                            }


                            return aldrete;
                        }
                    });
        } catch (HibernateException e) {
            throw new ModelException("Error Insertando Escala de Aldrete: " + 
                                     e.getMessage(), e);
        } catch (Exception e) {
            throw new ModelException("Error Insertando Escala de Aldrete: " + 
                                     e.getMessage(), e);
        }
    }


    /**
     * @param numero
     * @return
     * @throws ModelException
     */
    public Chsignovital getSignosVitales(Long numero) throws ModelException {
        List<Chsignovital> resultList = null;
        List parametros = new ArrayList<Chsignovital>();

        try {

            StringBuffer sb = new StringBuffer();
            sb.append(" select chsv from " + Chsignovital.class.getName() + 
                      " chsv  where chsv.id.hsvlconsulta = ?   order by chsv.id.hsvlconsecutiv ");
            parametros.add(numero);


            resultList = 
                    (List<Chsignovital>) this.getHibernateTemplate().find(sb.toString(), parametros.toArray());

            if (!resultList.isEmpty()) {
                return resultList.get(0);
            }

            return null;

        } catch (HibernateException e) {
            throw new ModelException("Error consultando Signos Vitales:" + 
                                     e.getMessage(), e);
        } catch (Exception e) {
            throw new ModelException("Error consultando Signos Vitales: " + 
                                     e.getMessage(), e);
        }

    }


    /**
     * @param numero
     * @return
     * @throws ModelException
     */
    public List<Chsignovital> getSignosVitalesAnestesia(Long numero) throws ModelException {
        List<Chsignovital> resultList = null;
        List parametros = new ArrayList<Chsignovital>();

        try {

            StringBuffer sb = new StringBuffer();
            sb.append(" select chsv from " + Chsignovital.class.getName() + 
                      " chsv  where chsv.id.hsvlconsulta = ?   AND chsv.hsvctipoproced = ?  order by chsv.id.hsvlconsecutiv ");
            parametros.add(numero);
            parametros.add(IConstantes.TIPO_PROCEDIMIENTO_ANESTESIA);

            resultList = 
                    (List<Chsignovital>) this.getHibernateTemplate().find(sb.toString(), parametros.toArray());

            if (!resultList.isEmpty()) {
                return resultList;
            }

            return null;

        } catch (HibernateException e) {
            throw new ModelException("Error consultando Signos Vitales:" + 
                                     e.getMessage(), e);
        } catch (Exception e) {
            throw new ModelException("Error consultando Signos Vitales: " + 
                                     e.getMessage(), e);
        }

    }


    /**
     * @param nota
     * @param signo
     * @throws ModelException
     */
    public void saveSignosNotaEnfermeria(final Chnotaenferm nota, 
                                         final Chsignovital signo) throws ModelException {
        try {
            this.getHibernateTemplate().execute(new HibernateCallback() {
                        public Object doInHibernate(Session session) {

                            if (nota != null && nota.getId() != null && 
                                nota.getId().getHnelconsecutiv() == null) {
                                Integer consecutivo = null;
                                StringBuffer sb = new StringBuffer();
                                sb.append(" select max(chne.id.hnelconsecutiv) from  ");
                                sb.append(" from Chnotaenferm chne ");
                                sb.append(" where chne.id.hnelnumero = :hnelnumero AND  chne.id.hnectiposervi = :hnectiposervi   ");

                                Query query = 
                                    session.createQuery(sb.toString());
                                query.setParameter("hnelnumero", 
                                                   nota.getId().getHnelnumero());
                                query.setParameter("hnectiposervi", 
                                                   nota.getId().getHnectiposervi());

                                Integer secuenciaActual = 
                                    (Integer)query.uniqueResult();


                                if (secuenciaActual != null) {
                                    consecutivo = 
                                            secuenciaActual.intValue() + 1;
                                } else {
                                    consecutivo = 1;
                                }

                                nota.getId().setHnelconsecutiv(consecutivo);
                            }


                            if (signo.getHsvatemperatu() != null || 
                                (signo.getHsvnpresart1() != null) || 
                                (signo.getHsvnpresart2() != null) || 
                                (signo.getHsvctipoproced() != null && 
                                 !signo.getHsvctipoproced().equals("")) || 
                                (signo.getHsvctiporespir() != null && 
                                 !signo.getHsvctiporespir().equals("")) || 
                                (signo.getHsvetipotemper() != null && 
                                 !signo.getHsvetipotemper().equals("")) || 
                                (signo.getHsvnfreccard() != null) || 
                                (signo.getHsvnfrecresp() != null) || 
                                (signo.getHsvnpresioxido() != null) || 
                                (signo.getHsvnsatuoxihe() != null)) {

                                if (signo != null && signo.getId() != null && 
                                    signo.getId().getHsvlconsecutiv() == 
                                    null) {
                                    Integer consec = null;
                                    StringBuffer sb1 = new StringBuffer();
                                    sb1.append(" select max(chsv.id.hsvlconsecutiv) from  ");
                                    sb1.append(" from Chsignovital chsv ");
                                    sb1.append(" where chsv.id.hsvlconsulta = :hsvlconsulta    ");

                                    Query query1 = 
                                        session.createQuery(sb1.toString());
                                    query1.setParameter("hsvlconsulta", 
                                                        nota.getId().getHnelnumero());


                                    Integer secActual = 
                                        (Integer)query1.uniqueResult();


                                    if (secActual != null) {
                                        consec = secActual.intValue() + 1;
                                    } else {
                                        consec = 1;
                                    }

                                    signo.getId().setHsvlconsecutiv(consec);

                                }
                                session.saveOrUpdate(signo);
                            }


                            session.saveOrUpdate(nota);
                            return nota;
                        }
                    });
        } catch (HibernateException e) {
            throw new ModelException("Error Insertando :" + e.getMessage(), e);
        } catch (Exception e) {
            throw new ModelException("Error Insertando :" + e.getMessage(), e);
        }
    }


    /**
     * @param nota
     * @param signo
     * @param lstCanalizacion
     * @throws ModelException
     */
    public void saveSignosNotaCanalizacionEnfermeria(final Chnotaenferm nota, 
                                                     final Chsignovital signo, 
                                                     final List<Chcanalivena> lstCanalizacion, 
                                                     final List<Chcanalivena> lstCanalizacionSuspender,
                                                     final Chrefepaci referenciaPaciente) throws ModelException {
        try {
            this.getHibernateTemplate().execute(new HibernateCallback() {
                        public Object doInHibernate(Session session) {

                            Integer consecutivo = null;
                            Date fechaRegistro = new Date();

                            if (lstCanalizacionSuspender != null && 
                                !lstCanalizacionSuspender.isEmpty()) {
                                for (Chcanalivena canasusp: 
                                     lstCanalizacionSuspender) {
                                    session.update(canasusp);
                                }
                            }

                            if (nota != null && nota.getId() != null && 
                                nota.getId().getHnelconsecutiv() == null) {

                                StringBuffer sb = new StringBuffer();
                                sb.append(" select max(chne.id.hnelconsecutiv) from  ");
                                sb.append(" from Chnotaenferm chne ");
                                sb.append(" where chne.id.hnelnumero = :hnelnumero AND  chne.id.hnectiposervi = :hnectiposervi   ");

                                Query query = 
                                    session.createQuery(sb.toString());
                                query.setParameter("hnelnumero", 
                                                   nota.getId().getHnelnumero());
                                query.setParameter("hnectiposervi", 
                                                   nota.getId().getHnectiposervi());

                                Integer secuenciaActual = 
                                    (Integer)query.uniqueResult();


                                if (secuenciaActual != null) {
                                    consecutivo = 
                                            secuenciaActual.intValue() + 1;
                                } else {
                                    consecutivo = 1;
                                }

                                nota.getId().setHnelconsecutiv(consecutivo);
                                nota.setHnedfecregistr(fechaRegistro);
                            }

                            if (signo != null) {
                                if (signo.getHsvatemperatu() != null || 
                                    (signo.getHsvnpresart1() != null && 
                                     !signo.getHsvnpresart1().equals("")) || 
                                    (signo.getHsvnpresart2() != null && 
                                     !signo.getHsvnpresart2().equals("")) || 
                                    (signo.getHsvctipoproced() != null && 
                                     !signo.getHsvctipoproced().equals("")) || 
                                    (signo.getHsvctiporespir() != null && 
                                     !signo.getHsvctiporespir().equals("")) || 
                                    (signo.getHsvetipotemper() != null && 
                                     !signo.getHsvetipotemper().equals("")) || 
                                    (signo.getHsvnfreccard() != null) || 
                                    (signo.getHsvnfrecresp() != null) || 
                                    (signo.getHsvnpresioxido() != null) || 
                                    (signo.getHsvnsatuoxihe() != null)) {

                                    if (signo != null && 
                                        signo.getId() != null && 
                                        signo.getId().getHsvlconsecutiv() == 
                                        null) {
                                        Integer consec = null;
                                        StringBuffer sb1 = new StringBuffer();
                                        sb1.append(" select max(chsv.id.hsvlconsecutiv) from  ");
                                        sb1.append(" from Chsignovital chsv ");
                                        sb1.append(" where chsv.id.hsvlconsulta = :hsvlconsulta   ");

                                        Query query1 = 
                                            session.createQuery(sb1.toString());
                                        query1.setParameter("hsvlconsulta", 
                                                            nota.getId().getHnelnumero());


                                        Integer secActual = 
                                            (Integer)query1.uniqueResult();


                                        if (secActual != null) {
                                            consec = secActual.intValue() + 1;
                                        } else {
                                            consec = 1;
                                        }

                                        signo.getId().setHsvlconsecutiv(consec);
                                        signo.setHsvdfecregistr(fechaRegistro);

                                    }
                                    session.saveOrUpdate(signo);
                                }
                            }


                            session.saveOrUpdate(nota);


                            if (lstCanalizacion != null && 
                                !lstCanalizacion.isEmpty() && nota != null && 
                                nota.getId() != null) {
                                int i = 0;

                                StringBuffer sb = new StringBuffer();

                                sb.append(" delete  historia.Chcanalivena ");
                                sb.append(" where hcvlnumero = :numeroConsulta ");
                                sb.append(" and hcvctiposervi = :tipoServicio ");
                                sb.append(" and hcvnllave = :llave ");
                                Query query = 
                                    session.createQuery(sb.toString());
                                query.setParameter("numeroConsulta", 
                                                   nota.getId().getHnelnumero());
                                query.setParameter("tipoServicio", 
                                                   nota.getId().getHnectiposervi());
                                query.setParameter("llave", 
                                                   nota.getId().getHnelconsecutiv());
                                query.executeUpdate();


                                for (Chcanalivena canalizacion: 
                                     lstCanalizacion) {
                                    i++;
                                    canalizacion.getId().setHcvnllave(nota.getId().getHnelconsecutiv());
                                    canalizacion.getId().setHcvlconsecutiv(i);
                                    canalizacion.setHcvdfecregistr(fechaRegistro);
                                    session.saveOrUpdate(canalizacion);
                                }

                            }

                            if (referenciaPaciente != null && 
                                referenciaPaciente.getId() != null && 
                                referenciaPaciente.getId().getHrpnconsecuti() == 
                                null) {

                                StringBuffer sb = new StringBuffer();
                                sb.append(" select max(chre.id.hrpnconsecuti) from  ");
                                sb.append(" from Chrefepaci chre ");
                                sb.append(" where chre.id.hrplconsulta = :numeroConsulta");

                                Query query = 
                                    session.createQuery(sb.toString());
                                query.setParameter("numeroConsulta", 
                                                   referenciaPaciente.getId().getHrplconsulta());

                                Integer secuenciaActual = 
                                    (Integer)query.uniqueResult();


                                if (secuenciaActual != null) {
                                    consecutivo = 
                                            secuenciaActual.intValue() + 1;
                                } else {
                                    consecutivo = 1;
                                }

                                referenciaPaciente.getId().setHrpnconsecuti(consecutivo);

                                session.saveOrUpdate(referenciaPaciente);
                            }
                            
                            if(nota!= null && nota.getFechaEmbarazo() != null){
                                                           StringBuffer sb = new StringBuffer();
                                                           sb.append(" update historia.Chingresoenf set  hiecresulpruemb = :resultado, hiedfechapremb = :fechaPrueba " + 
                                                                     "   where hielnumero = :numeroCirugia ");
                                                           Query query = 
                                                               session.createQuery(sb.toString());
                                                           query.setParameter("numeroCirugia",  nota.getId().getHnelnumero());
                                                           query.setParameter("resultado", nota.getResultadoPrueba());
                                                           query.setParameter("fechaPrueba",  nota.getFechaEmbarazo());
                                                           query.executeUpdate();
                                                       }


                            return nota;
                        }
                    });
        } catch (HibernateException e) {
            throw new ModelException("Error Insertando :" + e.getMessage(), e);
        } catch (Exception e) {

            throw new ModelException("Error Insertando :" + e.getMessage(), e);
        }
    }


    /**
     * @param nota
     * @param signo
     * @throws ModelException
     */
    public void saveDarAltaEnfermeria(final Chnotaenferm nota, 
                                      final Chsignovital signo, 
                                      final Chcirugprogr programacion, 
                                      final Date fechaSalida, final List lstCirugias) throws ModelException {
        try {
            this.getHibernateTemplate().execute(new HibernateCallback() {
                        public Object doInHibernate(Session session) {
                            Date fechaRegistro = new Date();
                            Cnconsclin cnconsclin = new Cnconsclin();

                            if (nota != null && nota.getId() != null && 
                                nota.getId().getHnelconsecutiv() == null) {
                                Integer consecutivo = null;
                                StringBuffer sb = new StringBuffer();
                                sb.append(" select max(chne.id.hnelconsecutiv) from  ");
                                sb.append(" from Chnotaenferm chne ");
                                sb.append(" where chne.id.hnelnumero = :hnelnumero AND  chne.id.hnectiposervi = :hnectiposervi   ");

                                Query query = 
                                    session.createQuery(sb.toString());
                                query.setParameter("hnelnumero", 
                                                   nota.getId().getHnelnumero());
                                query.setParameter("hnectiposervi", 
                                                   nota.getId().getHnectiposervi());

                                Integer secuenciaActual = 
                                    (Integer)query.uniqueResult();


                                if (secuenciaActual != null) {
                                    consecutivo = 
                                            secuenciaActual.intValue() + 1;
                                } else {
                                    consecutivo = 1;
                                }

                                nota.getId().setHnelconsecutiv(consecutivo);
                                nota.setHnedfecregistr(fechaRegistro);
                            }


                            if (programacion != null) {

                                StringBuffer sb = new StringBuffer();
                                sb.append(" update historia.chcirugprogr set hcpcopersalenf = :userName, hcpdfechsalenf = :fechasal, hcpcsalidenfer = 'S', hcpcetapa = :cerrada " + 
                                          "   where hcplnumero = :numeroCirugia ");
                                Query query = 
                                    session.createQuery(sb.toString());
                                query.setParameter("numeroCirugia", 
                                                   programacion.getHcplnumero());
                                query.setParameter("userName", 
                                                   nota.getHnecoperador());
                                query.setParameter("fechasal", fechaSalida);
                                query.setParameter("cerrada", 
                                                   IConstantes.ETAPA_CIRUGIA_ATENDIDA);
                                query.executeUpdate();
                                
                                StringBuffer sbch = new StringBuffer();
                                sbch.append(" update historia.chconsulta set hcocoperador = :userName, hcodfeccierre = :fechasal, hcoeetapa = :cerrada " + 
                                          "   where hcolnumero = :numeroCirugia ");
                                Query querych = session.createQuery(sbch.toString());
                                querych.setParameter("numeroCirugia", programacion.getHcplnumero());
                                querych.setParameter("userName", nota.getHnecoperador());
                                querych.setParameter("fechasal", fechaSalida);
                                querych.setParameter("cerrada", IConstantes.ETAPA_CERRADA);
                                querych.executeUpdate();
                                
                                StringBuffer sbep = new StringBuffer();
                                sbep.append(" update historia.chepicrisis set hepcoperador = :userName, hepdfechaegres = :fechasal " + 
                                          "   where heplnumero = :numeroCirugia ");
                                Query queryep = session.createQuery(sbep.toString());
                                queryep.setParameter("numeroCirugia", programacion.getHcplnumero());
                                queryep.setParameter("userName", nota.getHnecoperador());
                                queryep.setParameter("fechasal", fechaSalida);
                                queryep.executeUpdate();
                                                              
                            }
                            
                            StringBuffer sbCon = new StringBuffer();
                            sbCon.append(" select cncl from " + 
                                              Cnconsclin.class.getName() + 
                                              " cncl  where  cncl.cconnumero = :numeroConsulta ");
                            Query query = 
                                session.createQuery(sbCon.toString());
                            query.setParameter("numeroConsulta", 
                                               programacion.getHcplnumero());
                            cnconsclin = (Cnconsclin)query.uniqueResult();
                            
                            Chdetacirpro chdetacirpro = new Chdetacirpro();
                            StringBuffer sbDetaCir = new StringBuffer();
                            sbDetaCir.append(" select detacir from " +  Chdetacirpro.class.getName() + 
                                            " detacir  where detacir.id.hdclconsuprinc = :codigoPrincipal and detacir.id.hdccservicio = :codigoServicio ");
                            Query queryDetaCir = session.createQuery(sbDetaCir.toString());
                            queryDetaCir.setParameter("codigoPrincipal",
                                  cnconsclin.getCconnumero());
                            queryDetaCir.setParameter("codigoServicio",
                                  cnconsclin.getCcocservic());
                                  
                            chdetacirpro = (Chdetacirpro)queryDetaCir.uniqueResult();
                            
                            if(cnconsclin.getCcontipdoc().getCtdnnumero()== 100 && "S".equals(chdetacirpro.getHdccdescrquiru())){
                            
                            StringBuffer sbAda = new StringBuffer();
                            sbAda.append(" update clinico.CFDETAFACTURA ccdf1  set ccdf1.CDFCETAPA = 'AT' ");
                            sbAda.append(" where (ccdf1.CDFNCONSFACT, ccdf1.CDFNNUMITEM) in( ");
                            sbAda.append(" select ccdf.CDFNCONSFACT, ccdf.CDFNNUMITEM ");
                            sbAda.append(" from clinico.CFFACTURA ccfa, clinico.CFDETAFACTURA ccdf ");
                            sbAda.append(" where ccfa.CFNCONSFACT = ccdf.CDFNCONSFACT ");
                            sbAda.append(" and ccfa.CFNADMISION = :wadmision ");
                            sbAda.append(" and ccdf.CDFCSERVICIO in(select detcir.HDCCSERVICIO from historia.CHDETACIRPRO detcir where detcir.HDCLCONSUPRINC = :codigoPrincipal)) ");


                            Query queryAda =
                            session.createQuery(sbAda.toString());
                            queryAda.setParameter("wadmision",
                                  cnconsclin.getCconnumdoc());
                            queryAda.setParameter("codigoPrincipal",
                                  cnconsclin.getCconnumero());
                            queryAda.executeUpdate();
                            } 

                            if (signo != null) {
                                if (signo.getHsvatemperatu() != null || 
                                    (signo.getHsvnpresart1() != null) || 
                                    (signo.getHsvnpresart2() != null) || 
                                    (signo.getHsvctipoproced() != null && 
                                     !signo.getHsvctipoproced().equals("")) || 
                                    (signo.getHsvctiporespir() != null && 
                                     !signo.getHsvctiporespir().equals("")) || 
                                    (signo.getHsvetipotemper() != null && 
                                     !signo.getHsvetipotemper().equals("")) || 
                                    (signo.getHsvnfreccard() != null) || 
                                    (signo.getHsvnfrecresp() != null) || 
                                    (signo.getHsvnpresioxido() != null) || 
                                    (signo.getHsvnsatuoxihe() != null)) {

                                    if (signo != null && 
                                        signo.getId() != null && 
                                        signo.getId().getHsvlconsecutiv() == 
                                        null) {
                                        Integer consec = null;
                                        StringBuffer sb1 = new StringBuffer();
                                        sb1.append(" select max(chsv.id.hsvlconsecutiv) from  ");
                                        sb1.append(" from Chsignovital chsv ");
                                        sb1.append(" where chsv.id.hsvlconsulta = :hsvlconsulta    ");

                                        Query query1 = 
                                            session.createQuery(sb1.toString());
                                        query1.setParameter("hsvlconsulta", 
                                                            nota.getId().getHnelnumero());


                                        Integer secActual = 
                                            (Integer)query1.uniqueResult();


                                        if (secActual != null) {
                                            consec = secActual.intValue() + 1;
                                        } else {
                                            consec = 1;
                                        }

                                        signo.getId().setHsvlconsecutiv(consec);
                                        signo.setHsvdfecregistr(fechaRegistro);

                                    }
                                    session.saveOrUpdate(signo);
                                }
                            }
                            
                            
                            session.saveOrUpdate(nota);
                            return nota;
  
                        }
                    });
        } catch (HibernateException e) {
            throw new ModelException("Error Insertando :" + e.getMessage(), e);
        } catch (Exception e) {
            throw new ModelException("Error Insertando :" + e.getMessage(), e);
        }
    }


    /**
     * @param numero
     * @return
     * @throws ModelException
     */
    public Chnotaenferm getNotaEnfermeriaUltima(Long numero) throws ModelException {
        List<Chnotaenferm> resultList = null;
        List parametros = new ArrayList<Chnotaenferm>();

        try {

            StringBuffer sb = new StringBuffer();
            sb.append(" select chne from " + Chnotaenferm.class.getName() + 
                      " chne  where chne.id.hnelnumero = ? AND chne.id.hnectiposervi = ? order by chne.id.hnelconsecutiv desc ");
            parametros.add(numero);
            parametros.add(IConstantes.TIPO_HOSPITALIZACION);


            resultList = 
                    (List<Chnotaenferm>) this.getHibernateTemplate().find(sb.toString(), parametros.toArray());

            if (!resultList.isEmpty()) {
                return resultList.get(0);
            }

            return null;

        } catch (HibernateException e) {
            throw new ModelException("Error consultando nota enfermeria:" + 
                                     e.getMessage(), e);
        } catch (Exception e) {
            throw new ModelException("Error consultando nota enfermeria: " + 
                                     e.getMessage(), e);
        }

    }


    /* ultima nota de enfermeria
     *
     * */

    /**
     * @param numero
     * @return
     * @throws ModelException
     */
    public Chnotaenferm getNotaEnfermeriaIngreso(Long numero) throws ModelException {
        List<Chnotaenferm> resultList = null;
        List parametros = new ArrayList<Chnotaenferm>();

        try {

            StringBuffer sb = new StringBuffer();
            sb.append(" select chne from " + Chnotaenferm.class.getName() + 
                      " chne  where chne.id.hnelnumero = ? AND chne.id.hnectiposervi = ? order by chne.id.hnelconsecutiv ");
            parametros.add(numero);
            parametros.add(IConstantes.TIPO_HOSPITALIZACION);


            resultList = 
                    (List<Chnotaenferm>) this.getHibernateTemplate().find(sb.toString(), parametros.toArray());

            if (!resultList.isEmpty()) {
                return resultList.get(0);
            }

            return null;

        } catch (HibernateException e) {
            throw new ModelException("Error consultando nota enfermeria:" + 
                                     e.getMessage(), e);
        } catch (Exception e) {
            throw new ModelException("Error consultando nota enfermeria: " + 
                                     e.getMessage(), e);
        }

    }


    /**
     * @param numero
     * @return
     * @throws ModelException
     */
    public List<Chnotaenferm> getNotasEnfermeriaIngreso(Long numero) throws ModelException {
        List<Chnotaenferm> resultList = null;
        List parametros = new ArrayList<Chnotaenferm>();

        try {

            StringBuffer sb = new StringBuffer();
            sb.append(" select chne from " + Chnotaenferm.class.getName() + 
                      " chne  where chne.id.hnelnumero = ? order by chne.id.hnelconsecutiv ");
            parametros.add(numero);


            resultList = 
                    (List<Chnotaenferm>) this.getHibernateTemplate().find(sb.toString(), parametros.toArray());

            if (!resultList.isEmpty()) {
                return resultList;
            }

            return null;

        } catch (HibernateException e) {
            throw new ModelException("Error consultando nota enfermeria:" + 
                                     e.getMessage(), e);
        } catch (Exception e) {
            throw new ModelException("Error consultando nota enfermeria: " + 
                                     e.getMessage(), e);
        }

    }


    /**
     * @param numero
     * @return
     * @throws ModelException
     */
    public

    List<Chsignovital> getSignosVitalesTomados(Long numero) throws ModelException {
        List<Chsignovital> resultList = null;
        List parametros = new ArrayList<Chsignovital>();

        try {

            StringBuffer sb = new StringBuffer();
            sb.append(" select chsv from " + Chsignovital.class.getName() + 
                      " chsv  where chsv.id.hsvlconsulta = ? AND chsv.hsvctipoproced = ? order by chsv.id.hsvlconsecutiv ");
            parametros.add(numero);
            parametros.add(IConstantes.TIPO_PROCEDIMIENTO_ENFERMERIA);


            resultList = 
                    (List<Chsignovital>) this.getHibernateTemplate().find(sb.toString(), parametros.toArray());

            if (!resultList.isEmpty()) {
                return resultList;
            }

            return null;

        } catch (HibernateException e) {
            throw new ModelException("Error consultando signos vitales:" + 
                                     e.getMessage(), e);
        } catch (Exception e) {
            throw new ModelException("Error consultando signos vitales: " + 
                                     e.getMessage(), e);
        }

    }


    /**
     * @param numeroCirugia
     * @return
     * @throws ModelException
     */
    public Integer getCamaUsuario(Long numeroCirugia) throws ModelException {
        List<Integer> resultList = null;
        List parametros = new ArrayList();

        try {
            if (numeroCirugia != null) {
                StringBuffer sb = new StringBuffer();
                sb.append(" select chne.hnencama from " + 
                          Chnotaenferm.class.getName() + 
                          " chne  where chne.id.hnelnumero = ? order by chne.id.hnelconsecutiv desc ");
                parametros.add(numeroCirugia);
                resultList = 
                        (List<Integer>) this.getHibernateTemplate().find(sb.toString(), parametros.toArray());

                if (!resultList.isEmpty()) {
                    return resultList.get(0);
                }

                return null;
            } else {
                return null;
            }

        } catch (HibernateException e) {
            throw new ModelException("Error Obteniendo Cama Usuario  :" + 
                                     e.getMessage(), e);
        } catch (Exception e) {
            throw new ModelException("Error Obteniendo Cama Usuario :" + 
                                     e.getMessage(), e);
        }

    }


    /**
     * @param numero
     * @throws ModelException
     */
    public void closeIngresoEnfermeria(final Long numero, 
                                       final String userName, 
                                       final Date fechaIngreso, 
                                       final Integer sala) throws ModelException {
        try {
            this.getHibernateTemplate().execute(new HibernateCallback() {
                        public Object doInHibernate(Session session) {

                            Chingresoenf ingreso = null;
                            Integer orden = null;
                            Date fecha = new Date();
                            Calendar fechaI = Calendar.getInstance();
                            fechaI.setTime(fechaIngreso);
                            fechaI.set(Calendar.DATE, -1);
                            fecha = fechaI.getTime();

                            if (numero != null) {

                                StringBuffer sb = new StringBuffer();
                                sb.append(" select chie from " + 
                                          Chingresoenf.class.getName() + 
                                          " chie  where chie.id.hielnumero = :hielnumero AND chie.id.hiectiposervi = :hiectiposervi ");
                                Query query = 
                                    session.createQuery(sb.toString());
                                query.setParameter("hielnumero", numero);
                                query.setParameter("hiectiposervi", 
                                                   IConstantes.TIPO_HOSPITALIZACION);
                                ingreso = (Chingresoenf)query.uniqueResult();

                            }


                            Chcirugprogr cirugia = null;

                            if (numero != null) {

                                StringBuffer sb1 = new StringBuffer();
                                sb1.append(" select chcp from  " + 
                                           Chcirugprogr.class.getName() + 
                                           " chcp  where chcp.hcplnumero = :hcplnumero ");
                                Query query1 = 
                                    session.createQuery(sb1.toString());
                                query1.setParameter("hcplnumero", numero);
                                cirugia = (Chcirugprogr)query1.uniqueResult();

                            }

                            if (numero != null) {

                                StringBuffer sb1 = new StringBuffer();
                                sb1.append(" select max(chcp.hcpnordenllega + 1 ) from  " + 
                                           Chcirugprogr.class.getName() + 
                                           " chcp  where chcp.hcpdfechacirug > :wfecha and chcp.hcpnsalainterv = :wsala ");

                                Query query1 = 
                                    session.createQuery(sb1.toString());
                                query1.setParameter("wfecha", fecha);
                                query1.setParameter("wsala", sala);

                                orden = (Integer)query1.uniqueResult();

                                if (orden == null) {
                                    orden = 1;
                                }

                            }


                            if (ingreso != null) {

                                ingreso.setHiecetapa(IConstantes.ETAPA_CIRUGIA_PENDIENTE_QUIROFANO);
                                session.saveOrUpdate(ingreso);
                            }
                            
                            if(cirugia != null){
                                cirugia.setHcpcetapa(IConstantes.ETAPA_CIRUGIA_PENDIENTE_QUIROFANO);
                            }

                            if (cirugia != null && 
                                !cirugia.getHcpctipoaneste().equals("6")) {
                                cirugia.setHcpcetapa(IConstantes.ETAPA_CIRUGIA_PENDIENTE_QUIROFANO);
                                cirugia.setHcpcingreenfer("S");
                                cirugia.setHcpdfechingenf(fechaIngreso);
                                cirugia.setHcpcoperingenf(userName);
                                cirugia.setHcpnordenllega(orden);
                                session.saveOrUpdate(cirugia);
                            } else {
                                cirugia.setHcpcetapa(IConstantes.ETAPA_CIRUGIA_EN_QUIROFANO);
                                cirugia.setHcpcingreenfer("S");
                                cirugia.setHcpdfechingenf(fechaIngreso);
                                cirugia.setHcpcoperingenf(userName);
                                cirugia.setHcpnordenllega(orden);
                                session.saveOrUpdate(cirugia);
                            }


                            return numero;
                        }
                    });
        } catch (HibernateException e) {
            throw new ModelException("Error Insertando :" + e.getMessage(), e);
        } catch (Exception e) {
            throw new ModelException("Error Insertando :" + e.getMessage(), e);
        }
    }


    /**
     * @param numeroCirugia
     * @param userName
     * @param fechaIngreso
     * @throws ModelException
     */
    public void closeIngresoMedico(final Long numeroCirugia, 
                                   final String userName, 
                                   final Date fechaIngreso) throws ModelException {

        try {
            this.getHibernateTemplate().execute(new HibernateCallback() {
                        public Object doInHibernate(Session session) {

                            if (numeroCirugia != null) {

                                StringBuffer sb = new StringBuffer();
                                sb.append(" update historia.chcirugprogr set hcpcingremedic = 'S', hcpcoperingmed = :userName, hcpdfechingmed = :fechaIngreso " + 
                                          "   where hcplnumero = :numeroCirugia ");
                                Query query = 
                                    session.createQuery(sb.toString());
                                query.setParameter("numeroCirugia", 
                                                   numeroCirugia);
                                query.setParameter("userName", userName);
                                query.setParameter("fechaIngreso", 
                                                   fechaIngreso);
                                query.executeUpdate();

                            }

                            return numeroCirugia;
                        }
                    });
        } catch (HibernateException e) {
            throw new ModelException("Error Insertando :" + e.getMessage(), e);
        } catch (Exception e) {
            throw new ModelException("Error Insertando :" + e.getMessage(), e);
        }
    }


    /**
     * @param numeroUsuario
     * @return
     * @throws ModelException
     */
    public List<Chconsulta> getFoliosUsuarioCirugia(final Long numeroUsuario) throws ModelException {
        List<Chconsulta> pis = 
            (List<Chconsulta>)getHibernateTemplate().execute(new HibernateCallback() {
                    public Object doInHibernate(Session session) throws HibernateException {

                        StringBuffer sb = new StringBuffer();
                        sb.append("select chco from ");
                        sb.append(Chconsulta.class.getName()).append(" chco ");
                        sb.append("WHERE chco.hcolusuario.huslnumero =  ").append(numeroUsuario);
                        //sb.append(" AND chco.hcoeetapa = 'CE' ");
                        sb.append(" AND chco.hcocservicio.csvntipcon  in (2,7,3,11) ");
                        sb.append("  order by  chco.hcodfecregistr desc ");


                        String hql = sb.toString();

                        Query query = session.createQuery(hql);
                        List<Chconsulta> pis;
                        pis = query.list();

                        for (Chconsulta co: pis) {
                            Cpservicio servicio = co.getHcocservicio();
                            Hibernate.initialize(servicio);

                            Chusuario usu = co.getHcolusuario();
                            Hibernate.initialize(usu);


                        }

                        return pis;
                    }
                });
        return pis;
    }


    /**
     * @param numeroConsulta
     * @return
     * @throws ModelException
     */
    public Chcirugprogr getFolioCirugiaCompleto(final Long numeroConsulta) throws ModelException {
        Chcirugprogr pis = 
            (Chcirugprogr)getHibernateTemplate().execute(new HibernateCallback() {
                    public Object doInHibernate(Session session) throws HibernateException {


                        StringBuffer sb = new StringBuffer();
                        sb.append("SELECT chcp from ");
                        sb.append(Chcirugprogr.class.getName()).append(" chcp ");
                        sb.append("WHERE  chcp.hcplnumero = :hcolnumero  ");
                        String hql = sb.toString();
                        Query query = session.createQuery(hql);
                        query.setParameter("hcolnumero", numeroConsulta);


                        Chcirugprogr cp;
                        cp = (Chcirugprogr)query.uniqueResult();

                        if (cp != null) {

                            Chdescrquiru descrip = cp.getChdescrquiru();
                            Hibernate.initialize(descrip);

                            Chusuario usuar = cp.getHcplusuario();
                            Hibernate.initialize(usuar);

                            if (cp.getChdescrquiru() != null && 
                                cp.getChdescrquiru().getChdetaldescrs() != 
                                null) {
                                Set chdetaldescr = 
                                    cp.getChdescrquiru().getChdetaldescrs();
                                Hibernate.initialize(chdetaldescr);
                            }

                            Set epicrisis = cp.getChepicrisis();
                            Hibernate.initialize(epicrisis);

                            Set chcontrmedics = cp.getChcontrmedics();
                            Hibernate.initialize(chcontrmedics);

                            Set chnotaenferms = cp.getChnotaenferms();
                            Hibernate.initialize(chnotaenferms);

                            Set chcontroliqus = cp.getChcontroliqus();
                            Hibernate.initialize(chcontroliqus);

                            Set chcanalivenas = cp.getChcanalivenas();
                            Hibernate.initialize(chcanalivenas);

                            Set chsignovitals = cp.getChsignovitals();
                            Hibernate.initialize(chsignovitals);

                            Set chventiaerea = cp.getChventiaerea();
                            Hibernate.initialize(chventiaerea);

                            Set chevolucion = cp.getChevolucions();

                            Hibernate.initialize(chevolucion);

                            Set chingreso = cp.getChingresoenfs();
                            Hibernate.initialize(chingreso);

                            Set chanestesia = cp.getChanestesia();
                            Hibernate.initialize(chanestesia);


                            Set chposicanest = cp.getChposicanest();
                            Hibernate.initialize(chposicanest);

                            Set chmonitoria = cp.getChmonitoria();
                            Hibernate.initialize(chmonitoria);


                            Set chcontmedane = cp.getChcontmedane();
                            Hibernate.initialize(chcontmedane);

                            Set chcierreanest = cp.getChcierreanest();
                            Hibernate.initialize(chcierreanest);

                            Set chciruganula = cp.getChciruganula();
                            Hibernate.initialize(chciruganula);

                            Set chconducta = cp.getChconductas();
                            Hibernate.initialize(chconducta);

                           Set anatomia = cp.getChanatopatols();
                           Hibernate.initialize(anatomia);
                           
                           //Registro Escala de valoracion de Caidas
                           Set chescvalcai = cp.getChescvalcai();
                           Hibernate.initialize(chescvalcai);
                           
                        }
                        return cp;
                    }
                });
        return pis;
    }


    /**
     * @param numero
     * @return
     * @throws ModelException
     */
    public List<Chdetacirpro> getCirugiaDetalle(Long numero) throws ModelException {
        List<Chdetacirpro> resultList = null;
        List parametros = new ArrayList();


        try {

            StringBuffer sb = new StringBuffer();
            sb.append(" select chde from " + Chdetacirpro.class.getName() + 
                      " chde  where chde.id.hdclconsuprinc = ? ");
            parametros.add(numero);


            resultList = 
                    (List<Chdetacirpro>) this.getHibernateTemplate().find(sb.toString(), parametros.toArray());

            if (!resultList.isEmpty()) {
                return resultList;
            }

            return null;

        } catch (HibernateException e) {
            throw new ModelException("Error consultando cirugias detalle:" + 
                                     e.getMessage(), e);
        } catch (Exception e) {
            throw new ModelException("Error consultando cirugias detalle: " + 
                                     e.getMessage(), e);
        }

    }


    /**
     * @param numero
     * @return
     * @throws ModelException
     */
    public List<Chcirdetdesc> getCirugiasDescripcion(Long numero, 
                                                     Integer consecutivo) throws ModelException {
        List<Chcirdetdesc> resultList = null;
        List parametros = new ArrayList();

        try {

            StringBuffer sb = new StringBuffer();
            sb.append(" select chcd from " + Chcirdetdesc.class.getName() + 
                      " chcd  where chcd.id.hcdlnumero = ? AND chcd.id.hcdnconsec = ? ");
            parametros.add(numero);
            parametros.add(consecutivo);


            resultList = 
                    (List<Chcirdetdesc>) this.getHibernateTemplate().find(sb.toString(), parametros.toArray());

            if (!resultList.isEmpty()) {
                return resultList;
            }

            return null;

        } catch (HibernateException e) {
            throw new ModelException("Error consultando cirugias descripcion:" + 
                                     e.getMessage(), e);
        } catch (Exception e) {
            throw new ModelException("Error consultando cirugias descripcion: " + 
                                     e.getMessage(), e);
        }

    }


    /**
     * @param numeroCirugia
     * @param tipoServicio
     * @return
     * @throws ModelException
     */
    public List<Chformulaliq> getLstLiquidosFormulados(Long numeroCirugia, 
                                                       String tipoServicio, 
                                                       Integer wllave , Integer consecutivo) throws ModelException {
        List<Chformulaliq> resultList = null;
        List parametros = new ArrayList();
        try {
            if (numeroCirugia != null && tipoServicio != null) {
                StringBuffer sb = new StringBuffer();
                sb.append(" select chfl from " + Chformulaliq.class.getName());
                sb.append(" chfl  where chfl.id.hfllconsulta = ?  AND chfl.hflcestado = ?  ");
               
                if (wllave != null) {
                    sb.append(" and chfl.id.hflnllave != ? ");
                }
                
                if (consecutivo != null) {
                    sb.append(" and chfl.id.hflnconsecutiv != ? ");
                }
                parametros.add(numeroCirugia);
                parametros.add(IConstantes.ESTADO_VIGENTE);
                
                if (wllave != null) {
                    parametros.add(wllave);
                }
                
                if (consecutivo != null) {
                    parametros.add(consecutivo);
                }
                resultList = 
                        (List<Chformulaliq>) this.getHibernateTemplate().find(sb.toString(), parametros.toArray());
            }
            if (resultList != null && !resultList.isEmpty()) {
                return resultList;
            }

            return null;

        } catch (HibernateException e) {
            throw new ModelException("Error consultando Liquidos Formulados:" + 
                                     e.getMessage(), e);
        } catch (Exception e) {
            throw new ModelException("Error consultando Liquidos Formulados:" + 
                                     e.getMessage(), e);
        }

    }
    
    /**
     * @param numeroCirugia
     * @param tipoServicio
     * @return
     * @throws ModelException
     */
    public List<Chformulaliq> getLstLiquidosFormuladosReporte(Long numeroCirugia, 
                                                       String tipoServicio, 
                                                       Integer wllave) throws ModelException {
        List<Chformulaliq> resultList = null;
        List parametros = new ArrayList();
        try {
            if (numeroCirugia != null && tipoServicio != null) {
                StringBuffer sb = new StringBuffer();
                sb.append(" select chfl from " + Chformulaliq.class.getName());
                sb.append(" chfl  where chfl.id.hfllconsulta = ?  ");
               
                if (wllave != null) {
                    sb.append(" and chfl.id.hflnllave = ? ");
                }
                
                parametros.add(numeroCirugia);
                
                if (wllave != null) {
                    parametros.add(wllave);
                }

                resultList = 
                        (List<Chformulaliq>) this.getHibernateTemplate().find(sb.toString(), parametros.toArray());
            }
            if (resultList != null && !resultList.isEmpty()) {
                return resultList;
            }

            return null;

        } catch (HibernateException e) {
            throw new ModelException("Error consultando Liquidos Formulados:" + 
                                     e.getMessage(), e);
        } catch (Exception e) {
            throw new ModelException("Error consultando Liquidos Formulados:" + 
                                     e.getMessage(), e);
        }

    }



    /**
     * @param numeroCirugia
     * 
     * @return
     * @throws ModelException
     */
    public List<Chcontroliqu> getLstLiquidosFormuladosAnestesia(Long numeroCirugia) throws ModelException {
        List<Chcontroliqu> resultList = null;
        List parametros = new ArrayList();
        try {
            if (numeroCirugia != null) {
                StringBuffer sb = new StringBuffer();
                sb.append(" select chco from " + Chcontroliqu.class.getName());
                sb.append(" chco  where chco.id.hcllnumero = ? AND chco.hclcestado = ? AND chco.hclcetapa = ? AND chco.hclcetapcontro = ? ");

                parametros.add(numeroCirugia);
                parametros.add(IConstantes.ESTADO_VIGENTE);
                parametros.add(IConstantes.ETAPA_ESPERA);
                parametros.add(IConstantes.ANESTESIA);


                resultList = 
                        (List<Chcontroliqu>) this.getHibernateTemplate().find(sb.toString(), parametros.toArray());
            }
            if (resultList != null && !resultList.isEmpty()) {
                return resultList;
            }

            return null;

        } catch (HibernateException e) {
            throw new ModelException("Error consultando Liquidos Formulados:" + 
                                     e.getMessage(), e);
        } catch (Exception e) {
            throw new ModelException("Error consultando Liquidos Formulados:" + 
                                     e.getMessage(), e);
        }

    }


    /**
     * @param numeroUsuario
     * @param numeroCirugia
     * @return
     * @throws ModelException
     */
    public List<Chformulaliq> getLstLiquidosFormuladosConsultaExterna(Long numeroUsuario, 
                                                                      Long numeroCirugia) throws ModelException {
        List<Chformulaliq> resultList = null;
        List parametros = new ArrayList();
        try {
            if (numeroCirugia != null && numeroUsuario != null) {
                StringBuffer sb = new StringBuffer();
                sb.append(" select chfl from " + Chformulaliq.class.getName());
                sb.append(" chfl  where chfl.id.hfllconsulta != ?  AND chfl.hflcestado = ? and  chfl.hfllusuario = ? ");

                parametros.add(numeroCirugia);
                parametros.add(IConstantes.ESTADO_VIGENTE);
                parametros.add(numeroUsuario);

                resultList = 
                        (List<Chformulaliq>) this.getHibernateTemplate().find(sb.toString(), parametros.toArray());
            }
            if (resultList != null && !resultList.isEmpty()) {
                return resultList;
            }

            return null;

        } catch (HibernateException e) {
            throw new ModelException("Error consultando Liquidos Formulados:" + 
                                     e.getMessage(), e);
        } catch (Exception e) {
            throw new ModelException("Error consultando Liquidos Formulados:" + 
                                     e.getMessage(), e);
        }

    }


    /**
     * @param numero
     * @param tipoServicio
     * @return
     * @throws ModelException
     */
    public List<Chcanalivena> getLstCanalizacion(Long numero, 
                                                 String tipoServicio, 
                                                 Integer consecutivo) throws ModelException {
        List<Chcanalivena> resultList = null;
        List parametros = new ArrayList<Chcanalivena>();

        try {
            if (numero != null && tipoServicio != null) {
                StringBuffer sb = new StringBuffer();
                sb.append(" select chcv from " + Chcanalivena.class.getName());
                sb.append(" chcv  where chcv.id.hcvlnumero = ? ");
                sb.append("AND   chcv.id.hcvctiposervi =  ? ");
                if (consecutivo != null) {
                    sb.append(" and chcv.idhcvnllave != ? ");
                }
                sb.append(" order by chcv.id.hcvlconsecutiv ");
                parametros.add(numero);
                parametros.add(tipoServicio);
                if (consecutivo != null) {
                    parametros.add(consecutivo);
                }


                resultList = 
                        (List<Chcanalivena>) this.getHibernateTemplate().find(sb.toString(), parametros.toArray());

                if (!resultList.isEmpty()) {
                    return resultList;
                }


            }


            return null;

        } catch (HibernateException e) {
            throw new ModelException("Error consultando Canalizacion Vena:" + 
                                     e.getMessage(), e);
        } catch (Exception e) {
            throw new ModelException("Error consultando Canalizacion Vena: " + 
                                     e.getMessage(), e);
        }

    }


    /**
     * @param numeroCirugia
     * @return
     * @throws ModelException
     */
    public String getEtapaNotaEnfermeria(Long numeroCirugia) throws ModelException {
        List<String> resultList = null;
        List parametros = new ArrayList();

        try {
            if (numeroCirugia != null) {
                StringBuffer sb = new StringBuffer();
                sb.append(" select chne.hnecetapa from " + 
                          Chnotaenferm.class.getName());
                sb.append(" chne  where chne.id.hnelnumero = ? ");
                sb.append(" order by chne.id.hnelconsecutiv desc ");
                parametros.add(numeroCirugia);


                resultList = 
                        (List<String>) this.getHibernateTemplate().find(sb.toString(), parametros.toArray());

                if (!resultList.isEmpty()) {
                    return resultList.get(0);
                }


            }


            return null;

        } catch (HibernateException e) {
            throw new ModelException("Error consultando Etapa Nota enfermeria :" + 
                                     e.getMessage(), e);
        } catch (Exception e) {
            throw new ModelException("Error consultando Etapa Nota enfermeria : " + 
                                     e.getMessage(), e);
        }

    }


    /**
     * @param material
     * @throws ModelException
     */
    public void saveMaterialInstrumental(final Chmaterinstr material) throws ModelException {
        try {
            this.getHibernateTemplate().execute(new HibernateCallback() {
                        public Object doInHibernate(Session session) {
                            Integer consecutivo = null;
                            if (material != null) {


                                if (material.getHmincodigo() == null) {


                                    StringBuffer sb1 = new StringBuffer();
                                    sb1.append(" select max(chmi.hmincodigo) from " + 
                                               Chmaterinstr.class.getName() + 
                                               " chmi   ");
                                    Query query1 = 
                                        session.createQuery(sb1.toString());


                                    Integer secuenciaActual = 
                                        (Integer)query1.uniqueResult();

                                    if (secuenciaActual != null) {
                                        consecutivo = 
                                                secuenciaActual.intValue() + 1;
                                    } else {
                                        consecutivo = 1;
                                    }
                                    if (consecutivo != null) {
                                        material.setHmincodigo(consecutivo);
                                    }
                                }


                                session.saveOrUpdate(material);

                            }


                            return material;
                        }
                    });
        } catch (HibernateException e) {
            throw new ModelException("Error Insertando material instrumental :" + 
                                     e.getMessage(), e);
        } catch (Exception e) {
            throw new ModelException("Error Insertando material instrumental :" + 
                                     e.getMessage(), e);
        }
    }


    /**
     * @return
     * @throws ModelException
     */
    public List<Chmaterinstr> getListaMaterialInstrumental() throws ModelException {
        List<Chmaterinstr> resultList = null;
        List parametros = new ArrayList();

        try {


            StringBuffer sb = new StringBuffer();
            sb.append(" select chmi from " + Chmaterinstr.class.getName() + 
                      " chmi  where chmi.hmicestado in ('AC', 'IN')  ");
            sb.append(" order by  chmi.hmincodigo ");


            resultList = 
                    (List<Chmaterinstr>) this.getHibernateTemplate().find(sb.toString(), parametros.toArray());


            if (!resultList.isEmpty()) {
                return resultList;
            }


            return null;

        } catch (HibernateException e) {
            throw new ModelException("Error consultando Lista de Material Instrumental:" + 
                                     e.getMessage(), e);
        } catch (Exception e) {
            throw new ModelException("Error consultando Lista de Material Instrumental:" + 
                                     e.getMessage(), e);
        }

    }


    /**
     * @param material
     * @throws ModelException
     */
    public void updateMaterialInstrumental(Chmaterinstr material) throws ModelException {
        try {
            this.getHibernateTemplate().update(material);
        } catch (HibernateException e) {
            throw new ModelException("Error actualizando material instrumental:" + 
                                     e.getMessage(), e);
        } catch (Exception e) {
            throw new ModelException("Error actualizando material instrumental:" + 
                                     e.getMessage(), e);
        }
    }


    /**
     * @param material
     * @throws ModelException
     */
    public void deleteMaterialInstrumental(Chmaterinstr material) throws ModelException {
        try {
            this.getHibernateTemplate().delete(material);
        } catch (HibernateException e) {
            throw new ModelException("Error Eliminando pregunta:" + 
                                     e.getMessage(), e);
        } catch (Exception e) {
            throw new ModelException("Error Eliminando pregunta:" + 
                                     e.getMessage(), e);
        }
    }


    /**
     * @return
     * @throws ModelException
     */
    public List<Chpaqueester> getListaPaqueteInstrumental() throws ModelException {
        List<Chpaqueester> resultList = null;
        List parametros = new ArrayList();

        try {


            StringBuffer sb = new StringBuffer();
            sb.append(" select chpe from " + Chpaqueester.class.getName() + 
                      " chpe  where chpe.hpecestado in ('AC', 'IN')  ");
            sb.append(" order by  chpe.hpencodigo ");


            resultList = 
                    (List<Chpaqueester>) this.getHibernateTemplate().find(sb.toString(), parametros.toArray());


            if (!resultList.isEmpty()) {
                return resultList;
            }


            return null;

        } catch (HibernateException e) {
            throw new ModelException("Error consultando Lista de Paquete Instrumental:" + 
                                     e.getMessage(), e);
        } catch (Exception e) {
            throw new ModelException("Error consultando Lista de Paquete Instrumental:" + 
                                     e.getMessage(), e);
        }

    }


    /**
     * @param paquete
     * @throws ModelException
     */
    public void updatePaqueteInstrumental(Chpaqueester paquete) throws ModelException {
        try {
            this.getHibernateTemplate().update(paquete);
        } catch (HibernateException e) {
            throw new ModelException("Error actualizando paquete instrumental:" + 
                                     e.getMessage(), e);
        } catch (Exception e) {
            throw new ModelException("Error actualizando paquete instrumental:" + 
                                     e.getMessage(), e);
        }
    }


    /**
     * @param paquete
     * @throws ModelException
     */
    public void deletePaqueteInstrumental(Chpaqueester paquete) throws ModelException {
        try {
            this.getHibernateTemplate().delete(paquete);
        } catch (HibernateException e) {
            throw new ModelException("Error Eliminando paquete:" + 
                                     e.getMessage(), e);
        } catch (Exception e) {
            throw new ModelException("Error Eliminando paquete:" + 
                                     e.getMessage(), e);
        }
    }


    /**
     * @param paquete
     * @throws ModelException
     */
    public void savePaqueteInstrumental(final Chpaqueester paquete) throws ModelException {
        try {
            this.getHibernateTemplate().execute(new HibernateCallback() {
                        public Object doInHibernate(Session session) {
                            Integer consecutivo = null;
                            if (paquete != null) {


                                if (paquete.getHpencodigo() == null) {


                                    StringBuffer sb1 = new StringBuffer();
                                    sb1.append(" select max(chpe.hpencodigo) from " + 
                                               Chpaqueester.class.getName() + 
                                               " chpe   ");
                                    Query query1 = 
                                        session.createQuery(sb1.toString());


                                    Integer secuenciaActual = 
                                        (Integer)query1.uniqueResult();

                                    if (secuenciaActual != null) {
                                        consecutivo = 
                                                secuenciaActual.intValue() + 1;
                                    } else {
                                        consecutivo = 1;
                                    }
                                    if (consecutivo != null) {
                                        paquete.setHpencodigo(consecutivo);
                                    }
                                }


                                session.saveOrUpdate(paquete);

                            }


                            return paquete;
                        }
                    });
        } catch (HibernateException e) {
            throw new ModelException("Error Insertando paquete instrumental :" + 
                                     e.getMessage(), e);
        } catch (Exception e) {
            throw new ModelException("Error Insertando paquete instrumental :" + 
                                     e.getMessage(), e);
        }
    }


    /**
     * @param estado
     * @return
     * @throws ModelException
     */
    public List<Chpaqueester> getListaPaqueteInstrumentalByEstado(String estado) throws ModelException {
        List<Chpaqueester> resultList = null;
        List parametros = new ArrayList();

        try {


            StringBuffer sb = new StringBuffer();
            sb.append(" select chpe from " + Chpaqueester.class.getName() + 
                      " chpe  where chpe.hpecestado  = ?  ");
            sb.append(" order by  chpe.hpencodigo ");
            parametros.add(estado);


            resultList = 
                    (List<Chpaqueester>) this.getHibernateTemplate().find(sb.toString(), parametros.toArray());


            if (!resultList.isEmpty()) {
                return resultList;
            }


            return null;

        } catch (HibernateException e) {
            throw new ModelException("Error consultando Lista de Paquete Instrumental:" + 
                                     e.getMessage(), e);
        } catch (Exception e) {
            throw new ModelException("Error consultando Lista de Paquete Instrumental:" + 
                                     e.getMessage(), e);
        }

    }


    /**
     * @param estado
     * @return
     * @throws ModelException
     */
    public List<Chmaterinstr> getListaMaterialInstrumentalByEstado(String estado) throws ModelException {
        List<Chmaterinstr> resultList = null;
        List parametros = new ArrayList();

        try {


            StringBuffer sb = new StringBuffer();
            sb.append(" select chmi from " + Chmaterinstr.class.getName() + 
                      " chmi  where chmi.hmicestado  = ?  ");
            sb.append(" order by  chmi.hmincodigo ");
            parametros.add(estado);


            resultList = 
                    (List<Chmaterinstr>) this.getHibernateTemplate().find(sb.toString(), parametros.toArray());


            if (!resultList.isEmpty()) {
                return resultList;
            }


            return null;

        } catch (HibernateException e) {
            throw new ModelException("Error consultando Lista de Material Instrumental:" + 
                                     e.getMessage(), e);
        } catch (Exception e) {
            throw new ModelException("Error consultando Lista de Material Instrumental:" + 
                                     e.getMessage(), e);
        }

    }


    /**
     * @param instrumental
     * @param lstItemMaterial
     * @param lstItemPaquete
     * @throws ModelException
     */
    public void saveInstrumental(final Chinstrument instrumental, 
                                 final List<Chitemmater> lstItemMaterial, 
                                 final List<Chitempaque> lstItemPaquete) throws ModelException {
        try {
            this.getHibernateTemplate().execute(new HibernateCallback() {
                        public Object doInHibernate(Session session) {
                            Integer consecutivo = null;
                            if (instrumental != null) {

                                session.saveOrUpdate(instrumental);


                                //  Eliminamos la lista de materiales                     
                                StringBuffer sb = new StringBuffer();
                                sb.append(" delete  historia.Chitemmater ");
                                sb.append(" where himlcodiginstr = :numeroCirugia ");
                                Query query = 
                                    session.createQuery(sb.toString());
                                query.setParameter("numeroCirugia", 
                                                   instrumental.getHinlcirugia());
                                query.executeUpdate();

                                //  Eliminamos la lista de paquetes         

                                StringBuffer sb1 = new StringBuffer();
                                sb1.append(" delete  historia.Chitempaque ");
                                sb1.append(" where hiplcodiginstr = :numeroCirugia ");
                                Query query1 = 
                                    session.createQuery(sb1.toString());
                                query1.setParameter("numeroCirugia", 
                                                    instrumental.getHinlcirugia());
                                query1.executeUpdate();

                                // Guardamos la lista de materiales quirurgicos utilizados en la cirugia
                                if (lstItemMaterial != null && 
                                    !lstItemMaterial.isEmpty()) {
                                    for (Chitemmater material: 
                                         lstItemMaterial) {
                                        session.saveOrUpdate(material);
                                    }
                                }


                                // Guardamos la lista de paquetes quirurgicos utilizados en la cirugia
                                if (lstItemPaquete != null && 
                                    !lstItemPaquete.isEmpty()) {
                                    for (Chitempaque paquete: lstItemPaquete) {
                                        session.saveOrUpdate(paquete);
                                    }
                                }


                            }


                            return instrumental;
                        }
                    });
        } catch (HibernateException e) {
            throw new ModelException("Error Insertando Instrumental Quirurgico:" + 
                                     e.getMessage(), e);
        } catch (Exception e) {
            throw new ModelException("Error Insertando Instrumental Quirurgico:" + 
                                     e.getMessage(), e);
        }
    }


    /**
     * @param numeroCirugia
     * @return
     * @throws ModelException
     */
    public Chinstrument getInstrumentalByCirugia(Long numeroCirugia) throws ModelException {
        List<Chinstrument> resultList = null;
        List parametros = new ArrayList();

        try {


            StringBuffer sb = new StringBuffer();
            sb.append(" select chin from " + Chinstrument.class.getName() + 
                      " chin  where chin.hinlcirugia  = ?  ");
            parametros.add(numeroCirugia);


            resultList = 
                    (List<Chinstrument>) this.getHibernateTemplate().find(sb.toString(), parametros.toArray());


            if (!resultList.isEmpty()) {
                return resultList.get(0);
            }


            return null;

        } catch (HibernateException e) {
            throw new ModelException("Error consultando Lista de Paquete Instrumental:" + 
                                     e.getMessage(), e);
        } catch (Exception e) {
            throw new ModelException("Error consultando Lista de Paquete Instrumental:" + 
                                     e.getMessage(), e);
        }

    }


    /**
     * @param numeroCirugia
     * @return
     * @throws ModelException
     */
    public List<Chitemmater> getListaItemMaterialInstrumentalByCirugia(Long numeroCirugia) throws ModelException {
        List<Chitemmater> resultList = null;
        List parametros = new ArrayList();

        try {


            StringBuffer sb = new StringBuffer();
            sb.append(" select chim from " + Chitemmater.class.getName() + 
                      " chim  where chim.id.himlcodiginstr  = ?  ");
            sb.append(" order by  chim.id.himncodigmater ");
            parametros.add(numeroCirugia);


            resultList = 
                    (List<Chitemmater>) this.getHibernateTemplate().find(sb.toString(), parametros.toArray());


            if (!resultList.isEmpty()) {
                return resultList;
            }


            return null;

        } catch (HibernateException e) {
            throw new ModelException("Error consultando Item Material Instrumental:" + 
                                     e.getMessage(), e);
        } catch (Exception e) {
            throw new ModelException("Error consultando Item Material Instrumental:" + 
                                     e.getMessage(), e);
        }

    }


    /**
     * @param numeroCirugia
     * @return
     * @throws ModelException
     */
    public List<Chitempaque> getListaItemPaqueteInstrumentalByCirugia(Long numeroCirugia) throws ModelException {
        List<Chitempaque> resultList = null;
        List parametros = new ArrayList();

        try {


            StringBuffer sb = new StringBuffer();
            sb.append(" select chip from " + Chitempaque.class.getName() + 
                      " chip  where chip.id.hiplcodiginstr  = ?  ");
            sb.append(" order by  chip.id.hipncodigpaque ");
            parametros.add(numeroCirugia);


            resultList = 
                    (List<Chitempaque>) this.getHibernateTemplate().find(sb.toString(), parametros.toArray());


            if (!resultList.isEmpty()) {
                return resultList;
            }


            return null;

        } catch (HibernateException e) {
            throw new ModelException("Error consultando Item Paquete Instrumental:" + 
                                     e.getMessage(), e);
        } catch (Exception e) {
            throw new ModelException("Error consultando Item Paquete Instrumental:" + 
                                     e.getMessage(), e);
        }

    }


    public List<Chvademecum> getVademecum(String esAnestesia) throws ModelException {
        List<Chvademecum> resultList = null;
        List parametros = new ArrayList();
    
        try {

            if (esAnestesia != null && !esAnestesia.equals("")) {
                StringBuffer sb = new StringBuffer();
                sb.append(" select chvd from " + Chvademecum.class.getName() + 
                          " chvd  where chvd.hvdcanestesia  = ?  ");
                sb.append(" order by  chvd.hvdcprincactiv ");
                parametros.add(esAnestesia);

                resultList = 
                        (List<Chvademecum>) this.getHibernateTemplate().find(sb.toString(), parametros.toArray());


                if (!resultList.isEmpty()) {
                    return resultList;
                }

            }

            return null;

        } catch (HibernateException e) {
            throw new ModelException("Error consultando Vademecum:" + 
                                     e.getMessage(), e);
        } catch (Exception e) {
            throw new ModelException("Error consultando Vademecum:" + 
                                     e.getMessage(), e);
        }

    }
    
    public List<Chvademprof> getVademProf(String esAnestesia) throws ModelException {
        List<Chvademprof> resultList = null;
        List parametros = new ArrayList();
    
        try {

            if (esAnestesia != null && !esAnestesia.equals("")) {
                StringBuffer sb = new StringBuffer();
                sb.append(" select chvf from " + Chvademprof.class.getName() + 
                          " chvf  where chvf.hvdcanestesia  = ?  ");
                sb.append(" order by  chvf.hvdcprincactiv ");
                parametros.add(esAnestesia);

                resultList = 
                        (List<Chvademprof>) this.getHibernateTemplate().find(sb.toString(), parametros.toArray());


                if (!resultList.isEmpty()) {
                    return resultList;
                }

            }

            return null;

        } catch (HibernateException e) {
            throw new ModelException("Error consultando Vademecum:" + 
                                     e.getMessage(), e);
        } catch (Exception e) {
            throw new ModelException("Error consultando Vademecum:" + 
                                     e.getMessage(), e);
        }

    }


    /**
     * @return
     * @throws ModelException
     */
    public List<Chvademecum> getIniciaVademecumAnestesia() throws ModelException {
        List<Chvademecum> resultList = null;
        List parametros = new ArrayList();

        try {


            StringBuffer sb = new StringBuffer();
            sb.append(" select chvd from " + Chvademecum.class.getName() + 
                      " chvd  where chvd.hvdcanestesia  = 'S' and chvd.hvdcinicianest = 'S'  ");
            sb.append(" order by  chvd.hvdcprincactiv ");


            resultList = 
                    (List<Chvademecum>) this.getHibernateTemplate().find(sb.toString(), parametros.toArray());


            if (!resultList.isEmpty()) {
                return resultList;
            }


            return null;

        } catch (HibernateException e) {
            throw new ModelException("Error consultando Vademecum Inicial Anestesia:" + 
                                     e.getMessage(), e);
        } catch (Exception e) {
            throw new ModelException("Error consultando Vademecum Inicial Anestesia:" + 
                                     e.getMessage(), e);
        }

    }


    /**
     * @return
     * @throws ModelException
     */
    public List<Chvademecum> getVademecumAnestesia() throws ModelException {
        List<Chvademecum> resultList = null;
        List parametros = new ArrayList();

        try {


            StringBuffer sb = new StringBuffer();
            sb.append(" select chvd from " + Chvademecum.class.getName() + 
                      " chvd  where chvd.hvdcanestesia  = 'S' and chvd.hvdcinicianest = 'N'  ");
            sb.append(" order by  chvd.hvdcprincactiv ");


            resultList = 
                    (List<Chvademecum>) this.getHibernateTemplate().find(sb.toString(), parametros.toArray());


            if (!resultList.isEmpty()) {
                return resultList;
            }


            return null;

        } catch (HibernateException e) {
            throw new ModelException("Error consultando Vademecum Anestesia:" + 
                                     e.getMessage(), e);
        } catch (Exception e) {
            throw new ModelException("Error consultando Vademecum Anestesia:" + 
                                     e.getMessage(), e);
        }

    }


    /**
     * 
     * @param codigo
     * @return
     * @throws ModelException
     */
    public List<Chvademecum> getVademecumCodigo(Integer codigo) throws ModelException {
        List<Chvademecum> resultList = null;
        List parametros = new ArrayList();

        try {

            if (codigo != null && !codigo.equals("")) {
                StringBuffer sb = new StringBuffer();
                sb.append(" select chvd from " + Chvademecum.class.getName() + 
                          " chvd  where chvd.hvdnconsecutiv  = ?  ");

                parametros.add(codigo);

                resultList = 
                        (List<Chvademecum>) this.getHibernateTemplate().find(sb.toString(), parametros.toArray());


                if (!resultList.isEmpty()) {
                    return resultList;
                }

            }

            return null;

        } catch (HibernateException e) {
            throw new ModelException("Error consultando Vademecum Anestesia:" + 
                                     e.getMessage(), e);
        } catch (Exception e) {
            throw new ModelException("Error consultando Vademecum Anestesia:" + 
                                     e.getMessage(), e);
        }

    }


    /**
     * @return
     * @throws ModelException
     */
    public List<Chvademecum> getVademecumAnestesiaTotal() throws ModelException {
        List<Chvademecum> resultList = null;
        List parametros = new ArrayList();

        try {


            StringBuffer sb = new StringBuffer();
            sb.append(" select chvd from " + Chvademecum.class.getName() + 
                      " chvd  where chvd.hvdcanestesia  = 'S'   ");
            sb.append(" order by  chvd.hvdcprincactiv ");


            resultList = 
                    (List<Chvademecum>) this.getHibernateTemplate().find(sb.toString(), parametros.toArray());


            if (!resultList.isEmpty()) {
                return resultList;
            }


            return null;

        } catch (HibernateException e) {
            throw new ModelException("Error consultando Vademecum Anestesia:" + 
                                     e.getMessage(), e);
        } catch (Exception e) {
            throw new ModelException("Error consultando Vademecum Anestesia:" + 
                                     e.getMessage(), e);
        }

    }


    /**
     * @return
     * @throws ModelException
     */
    public List<Chvademecum> getVademecumTotal() throws ModelException {
        List<Chvademecum> resultList = null;
        List parametros = new ArrayList();

        try {


            StringBuffer sb = new StringBuffer();
            sb.append(" select chvd from " + Chvademecum.class.getName() + 
                      " chvd ");
            sb.append(" order by  chvd.hvdcanestesia ");


            resultList = 
                    (List<Chvademecum>) this.getHibernateTemplate().find(sb.toString(), parametros.toArray());


            if (!resultList.isEmpty()) {
                return resultList;
            }


            return null;

        } catch (HibernateException e) {
            throw new ModelException("Error consultando Vademecum Anestesia:" + 
                                     e.getMessage(), e);
        } catch (Exception e) {
            throw new ModelException("Error consultando Vademecum Anestesia:" + 
                                     e.getMessage(), e);
        }

    }


    /**
     * @param numero
     * @return
     * @throws ModelException
     */
    public

    List<Chcontmedane> getControlMedicamentosAnestesia(Long numero) throws ModelException {
        List<Chcontmedane> resultList = null;
        List parametros = new ArrayList<Chcontmedane>();

        try {

            StringBuffer sb = new StringBuffer();
            sb.append(" select chma from " + Chcontmedane.class.getName() + 
                      " chma  where chma.id.hmalconsulta = ? order by chma.id.hmanconsecut ");
            parametros.add(numero);

            resultList = 
                    (List<Chcontmedane>) this.getHibernateTemplate().find(sb.toString(), parametros.toArray());

            if (!resultList.isEmpty()) {
                return resultList;
            }

            return null;

        } catch (HibernateException e) {
            throw new ModelException("Error consultando control liquidos anestesia:" + 
                                     e.getMessage(), e);
        } catch (Exception e) {
            throw new ModelException("Error consultando control liquidos anestesia: " + 
                                     e.getMessage(), e);
        }

    }


    /**
     * @param numero
     * @return
     * @throws ModelException
     */
    public

    List<Chaldrete> getAldrete(Long numero) throws ModelException {
        List<Chaldrete> resultList = null;
        List parametros = new ArrayList<Chaldrete>();

        try {

            StringBuffer sb = new StringBuffer();
            sb.append(" select chal from " + Chaldrete.class.getName() + 
                      " chal  where chal.id.hallconsulta = ? order by chal.id.hallconsecutiv ");
            parametros.add(numero);

            resultList = 
                    (List<Chaldrete>) this.getHibernateTemplate().find(sb.toString(), parametros.toArray());

            if (!resultList.isEmpty()) {
                return resultList;
            }

            return null;

        } catch (HibernateException e) {
            throw new ModelException("Error consultando control liquidos anestesia:" + 
                                     e.getMessage(), e);
        } catch (Exception e) {
            throw new ModelException("Error consultando control liquidos anestesia: " + 
                                     e.getMessage(), e);
        }

    }


    /**
     * @param segtelefo
     * @throws ModelException
     */
    public Chsegutelefo saveSeguimientoTelefonico(final Chsegutelefo segtelefo) throws ModelException {
        try {
            this.getHibernateTemplate().execute(new HibernateCallback() {
                        public Object doInHibernate(Session session) {

                            if (segtelefo != null && 
                                segtelefo.getId() != null && 
                                segtelefo.getId().getHstlconsecutiv() == 
                                null) {
                                Integer consecutivo = null;
                                StringBuffer sb = new StringBuffer();
                                sb.append(" select max(chse.id.hstlconsecutiv) from  ");
                                sb.append(" from Chsegutelefo chse ");
                                sb.append(" where chse.id.hstlnumero = :hstlnumero AND  chse.id.hstctiposervi = :hstctiposervi   ");

                                Query query = 
                                    session.createQuery(sb.toString());
                                query.setParameter("hstlnumero", 
                                                   segtelefo.getId().getHstlnumero());
                                query.setParameter("hstctiposervi", 
                                                   segtelefo.getId().getHstctiposervi());

                                Integer secuenciaActual = 
                                    (Integer)query.uniqueResult();


                                if (secuenciaActual != null) {
                                    consecutivo = 
                                            secuenciaActual.intValue() + 1;
                                } else {
                                    consecutivo = 1;
                                }

                                segtelefo.getId().setHstlconsecutiv(consecutivo);
                            }


                            session.saveOrUpdate(segtelefo);
                            return segtelefo;
                        }
                    }                 
                    );
            return segtelefo;
        } catch (HibernateException e) {
            throw new ModelException("Error Insertando :" + e.getMessage(), e);
        } catch (Exception e) {
            throw new ModelException("Error Insertando :" + e.getMessage(), e);
        }
    }

    /**
     * @param numero
     * @return
     * @throws ModelException
     */
    public List<Chsegutelefo> getSeguimientoTelefonico(Long numero) throws ModelException {
        List<Chsegutelefo> resultList = null;
        List parametros = new ArrayList<Chsegutelefo>();

        try {
            StringBuffer sb = new StringBuffer();
            sb.append(" select chse from " + Chsegutelefo.class.getName() + 
                      " chse where chse.id.hstlnumero = ? order by chse.id.hstlconsecutiv ");
            parametros.add(numero);

            resultList = 
                    (List<Chsegutelefo>) this.getHibernateTemplate().find(sb.toString(), parametros.toArray());

            if (!resultList.isEmpty()) {
                return resultList;
            }

            return null;

        } catch (HibernateException e) {
            throw new ModelException("Error consultando seguimiento telefonico:" + 
                                     e.getMessage(), e);
        } catch (Exception e) {
            throw new ModelException("Error consultando seguimiento telefonico: " + 
                                     e.getMessage(), e);
        }

    }


    public List<Chcirugprogr> getFoliosUsuarioSeguimientoTelefonico(final Long numeroUsuario) throws ModelException {
        List<Chcirugprogr> pis = 
            (List<Chcirugprogr>)getHibernateTemplate().execute(new HibernateCallback() {
                    public Object doInHibernate(Session session) throws HibernateException {

                        String HORA_INICIAL = " 00:00";
                        String HORA_FINAL = " 23:59";
                        String fechaI = null;
                        String fechaF = null;

                        int diferenciaEnDias = 1;
                        Date fechaActual = Calendar.getInstance().getTime();
                        long tiempoActual = fechaActual.getTime();
                        long unDia = diferenciaEnDias * 24 * 60 * 60 * 1000;
                        Date fechaAyer = new Date(tiempoActual - unDia);
                        Date fechaFinal = new Date();

                        if (fechaAyer != null && fechaFinal != null) {
                            SimpleDateFormat dateFormat = 
                                new SimpleDateFormat("dd/MM/yyyy");
                            fechaI = 
                                    dateFormat.format(fechaAyer) + HORA_INICIAL;
                            fechaF = 
                                    dateFormat.format(fechaFinal) + HORA_FINAL;
                        }

                        StringBuffer sb = new StringBuffer();
                        sb.append("select chci from ");
                        sb.append(Chcirugprogr.class.getName()).append(" chci ");
                        sb.append("WHERE chci.hcplusuario.huslnumero = :numeroUsuario ");
                        sb.append(" AND chci.hcpcetapa in ('CE','AT') ");
                        //                       sb.append(" AND (chci.hcpdfechsalmed BETWEEN TO_DATE(:fechaI,'dd/MM/yyyy hh24:mi') AND TO_DATE(:fechaF,'dd/MM/yyyy hh24:mi'))");
                        sb.append(" order by  chci.hcpdfechsalmed desc ");

                        String hql = sb.toString();

                        Query query = session.createQuery(hql);
                        query.setParameter("numeroUsuario", numeroUsuario);
                        //                        query.setParameter("fechaI", fechaI);
                        //                       query.setParameter("fechaF", fechaF);
                        List<Chcirugprogr> pis;
                        pis = query.list();

                        for (Chcirugprogr co: pis) {
                            Chusuario usu = co.getHcplusuario();
                            Hibernate.initialize(usu);
                        }

                        return pis;
                    }
                });
        return pis;
    }


    /**
     * @param numero
     * @param tipoServicio
     * @return
     * @throws ModelException
     */
    public List<Chcanalivena> getLstVenaCanalizada(Long numero, 
                                                   String tipoServicio) throws ModelException {
        List<Chcanalivena> resultList = null;
        List parametros = new ArrayList<Chcanalivena>();

        try {
            if (numero != null && tipoServicio != null) {
                StringBuffer sb = new StringBuffer();
                sb.append(" select chcv from " + Chcanalivena.class.getName());
                sb.append(" chcv  where chcv.id.hcvlnumero = ? ");
                sb.append(" AND   chcv.id.hcvctiposervi =  ? ");
                sb.append(" AND   chcv.hcvcestado = 'VG' ");
                sb.append(" order by chcv.id.hcvlconsecutiv ");
                parametros.add(numero);
                parametros.add(tipoServicio);

                resultList = 
                        (List<Chcanalivena>) this.getHibernateTemplate().find(sb.toString(), parametros.toArray());

                if (!resultList.isEmpty()) {
                    return resultList;
                }
            }
            return null;

        } catch (HibernateException e) {
            throw new ModelException("Error consultando Venas Canalizadas:" + 
                                     e.getMessage(), e);
        } catch (Exception e) {
            throw new ModelException("Error consultando Venas Canalizadas: " + 
                                     e.getMessage(), e);
        }

    }


    /**
     * @param numero
     * @param tipoServicio
     * @return
     * @throws ModelException
     */
    public List<Chcontroliqu> getLstLiquidosPorAdministrar(Long numero, 
                                                           String tipoServicio) throws ModelException {
        List<Chcontroliqu> resultList = null;
        List parametros = new ArrayList<Chcontroliqu>();

        try {
            if (numero != null && tipoServicio != null) {
                StringBuffer sb = new StringBuffer();
                sb.append(" select chcl from " + Chcontroliqu.class.getName());
                sb.append(" chcl  where chcl.id.hcllnumero = ? ");
                sb.append(" AND   chcl.id.hclctiposervi =  ? ");
                sb.append(" AND   chcl.hclcetapa NOT IN ('AT','SP','DL') ");
                sb.append(" order by chcl.id.hclnconsecutiv ");
                parametros.add(numero);
                parametros.add(tipoServicio);

                resultList = 
                        (List<Chcontroliqu>) this.getHibernateTemplate().find(sb.toString(), parametros.toArray());

                if (!resultList.isEmpty()) {
                    return resultList;
                }
            }
            return null;

        } catch (HibernateException e) {
            throw new ModelException("Error consultando Liquidos Por Administrar:" + 
                                     e.getMessage(), e);
        } catch (Exception e) {
            throw new ModelException("Error consultando Liquidos Por Administrar: " + 
                                     e.getMessage(), e);
        }

    }

    /**
     * @param usuario
     * @return
     * @throws ModelException
     */
    public List<Chregiconpro> getConsultasCirugiaSinFactura(final Chusuario usuario) throws ModelException {
        List<Chregiconpro> pis = 
            (List<Chregiconpro>)getHibernateTemplate().execute(new HibernateCallback() {
                    public Object doInHibernate(Session session) throws HibernateException {


                        if (usuario.getHuslnumero() != null) {
                            //                            Date fechafinal = null;
                            //                            Date fechainicial = null;

                            //                            Calendar fechaAux = Calendar.getInstance();
                            //                            fechafinal = fechaAux.getTime();
                            //                            fechaAux.add(Calendar.DAY_OF_YEAR, -60);
                            //                            fechainicial = fechaAux.getTime();

                            StringBuffer sb = new StringBuffer();
                            sb.append(" select  chre from ");
                            sb.append(Chregiconpro.class.getName()).append(" chre ");
                            sb.append(" where chre.hrclusuario.huslnumero  = :hrclusuario  ");
                            sb.append(" and chre.hrccetapa = :hrccetapa ");
                            sb.append(" and chre.hrccestado = :hrccestado ");
                            //                            sb.append(" and chre.hrcdfeccirpro between :fechainicial and :fechafinal ");
                            sb.append(" order by chre.hrcnnumero desc ");
                            String hql = sb.toString();

                            Query query = session.createQuery(hql);
                            query.setParameter("hrccetapa", 
                                               IConstantes.ETAPA_REGISTRO);
                            query.setParameter("hrccestado", 
                                               IConstantes.ESTADO_VIGENTE);
                            query.setParameter("hrclusuario", 
                                               usuario.getHuslnumero());
                            //                            query.setParameter("fechainicial", fechainicial);
                            //                            query.setParameter("fechafinal", fechafinal);
                            List<Chregicirpro> pis;
                            pis = query.list();

                            for (Chregicirpro ci: pis) {
                                Cpservicio servicio = ci.getHrccservic();
                                Hibernate.initialize(servicio);
                            }


                            return pis;
                        }
                        return null;
                    }
                });
        return pis;
        }


    /**
     * @param usuario
     * @return
     * @throws ModelException
     */
    public List<Chregicirpro> getCirugiasSinFactura(final Chusuario usuario) throws ModelException {
        List<Chregicirpro> pis = 
            (List<Chregicirpro>)getHibernateTemplate().execute(new HibernateCallback() {
                    public Object doInHibernate(Session session) throws HibernateException {


                        if (usuario.getHuslnumero() != null) {
                            //                            Date fechafinal = null;
                            //                            Date fechainicial = null;

                            //                            Calendar fechaAux = Calendar.getInstance();
                            //                            fechafinal = fechaAux.getTime();
                            //                            fechaAux.add(Calendar.DAY_OF_YEAR, -60);
                            //                            fechainicial = fechaAux.getTime();

                            StringBuffer sb = new StringBuffer();
                            sb.append(" select  chre from ");
                            sb.append(Chregicirpro.class.getName()).append(" chre ");
                            sb.append(" where chre.hrclusuario.huslnumero  = :hrclusuario  ");
                            sb.append(" and chre.hrccetapa = :hrccetapa ");
                            sb.append(" and chre.hrccestado = :hrccestado ");
                            //                            sb.append(" and chre.hrcdfeccirpro between :fechainicial and :fechafinal ");
                            sb.append(" order by chre.hrcnnumero desc ");
                            String hql = sb.toString();

                            Query query = session.createQuery(hql);
                            query.setParameter("hrccetapa", 
                                               IConstantes.ETAPA_REGISTRO);
                            query.setParameter("hrccestado", 
                                               IConstantes.ESTADO_VIGENTE);
                            query.setParameter("hrclusuario", 
                                               usuario.getHuslnumero());
                            //                            query.setParameter("fechainicial", fechainicial);
                            //                            query.setParameter("fechafinal", fechafinal);
                            List<Chregicirpro> pis;
                            pis = query.list();

                            for (Chregicirpro ci: pis) {
                                Cpservicio servicio = ci.getHrccservic();
                                Hibernate.initialize(servicio);
                            }


                            return pis;
                        }
                        return null;
                    }
                });
        return pis;
    }
    
    
    

        /**
         * @param usuario
         * @return
         * @throws ModelException
         */
        public List<Chregiconpro> getConsultasSinFactura(final Chusuario usuario) throws ModelException {
            List<Chregiconpro> pis = 
                (List<Chregiconpro>)getHibernateTemplate().execute(new HibernateCallback() {
                        public Object doInHibernate(Session session) throws HibernateException {


                            if (usuario.getHuslnumero() != null) {
                                //                            Date fechafinal = null;
                                //                            Date fechainicial = null;

                                //                            Calendar fechaAux = Calendar.getInstance();
                                //                            fechafinal = fechaAux.getTime();
                                //                            fechaAux.add(Calendar.DAY_OF_YEAR, -60);
                                //                            fechainicial = fechaAux.getTime();

                                StringBuffer sb = new StringBuffer();
                                sb.append(" select  chre from ");
                                sb.append(Chregiconpro.class.getName()).append(" chre ");
                                sb.append(" where chre.hrclusuario.huslnumero  = :hrclusuario  ");
                                sb.append(" and chre.hrccetapa = :hrccetapa ");
                                sb.append(" and chre.hrccestado = :hrccestado ");
                                //                            sb.append(" and chre.hrcdfeccirpro between :fechainicial and :fechafinal ");
                                sb.append(" order by chre.hrcnnumero desc ");
                                String hql = sb.toString();

                                Query query = session.createQuery(hql);
                                query.setParameter("hrccetapa", 
                                                   IConstantes.ETAPA_REGISTRO);
                                query.setParameter("hrccestado", 
                                                   IConstantes.ESTADO_VIGENTE);
                                query.setParameter("hrclusuario", 
                                                   usuario.getHuslnumero());
                                //                            query.setParameter("fechainicial", fechainicial);
                                //                            query.setParameter("fechafinal", fechafinal);
                                List<Chregicirpro> pis;
                                pis = query.list();

                                for (Chregicirpro ci: pis) {
                                    Cpservicio servicio = ci.getHrccservic();
                                    Hibernate.initialize(servicio);
                                }


                                return pis;
                            }
                            return null;
                        }
                    });
            return pis;
        }



    /**
     * @param regcirpro
     * @throws ModelException
     */
    public void saveCirugiaSinFactura(final Chregicirpro regcirpro, 
                                      final Chusuario usuario, 
                                      final Cpservicio servicio, 
                                      final Cptipodocu tipodocu, 
                                      final String userName) throws ModelException {
        try {
            this.getHibernateTemplate().execute(new HibernateCallback() {
                        public Object doInHibernate(Session session) {
                            Cnconsclin consulta = new Cnconsclin();

                            if (regcirpro != null && 
                                regcirpro.getHrcnnumero() == null) {
//                                Long hrcnconini = null;
/*                                BigDecimal secuenciaConsulta = 
                                    (BigDecimal)session.createQuery("SELECT cpco.connnumero FROM clinico.Cpconsec cpco where cpco.conncodigo = " + 
                                                                       IConstantes.CCONCNCL + 
                                                                       " FOR UPDATE nowait").uniqueResult();

                                if (secuenciaConsulta != null) {
                                    hrcnconini = secuenciaConsulta.longValue();
                                }

                                session.createQuery("update clinico.Cpconsec set connnumero = connnumero + 1  where conncodigo = " + 
                                                       IConstantes.CCONCNCL + 
                                                       " ").executeUpdate();
*/
                                BigDecimal secuenciaCirugia = 
                                    (BigDecimal)session.createQuery("SELECT cpco.connnumero FROM clinico.Cpconsec cpco where cpco.conncodigo = " + 
                                                                       IConstantes.CCONCGSF + 
                                                                       " FOR UPDATE nowait").uniqueResult();

                                if (secuenciaCirugia != null) {
                                    regcirpro.setHrcnnumero(secuenciaCirugia.longValue());
                                }

                                session.createQuery("update clinico.Cpconsec set connnumero = connnumero + 1  where conncodigo = " + 
                                                       IConstantes.CCONCGSF + 
                                                       " ").executeUpdate();
                            }
//                                consulta.setCconnumero(regcirpro.getHrcnconini().intValue());
                                consulta.setCconclinic(regcirpro.getHrcnclinic().getCclncodigo());
                                consulta.setCconclidoc(regcirpro.getHrcnclinic().getCclncodigo());
                                consulta.setCconsalesp(new Integer(0));
                                consulta.setCconconsul(new Integer(0));
                                consulta.setCcontconcl(servicio.getCsvntipcon());
                                consulta.setCcodfeccon(regcirpro.getHrcdfeccirpro());
                                consulta.setCconhistor(new Integer(0));
                                consulta.setCcoctipide(regcirpro.getHrcctipide());
                                consulta.setCcoanumide(regcirpro.getHrcanumide());
                                consulta.setCcocprinom(usuario.getHuscprimernomb());
                                consulta.setCcocsegnom(usuario.getHuscsegundnomb());
                                consulta.setCcocpriape(usuario.getHuscprimerapel());
                                consulta.setCcocsegape(usuario.getHuscsegundapel());
                                consulta.setCcontipdoc(tipodocu);
                                consulta.setCconnumdoc(new BigDecimal(regcirpro.getHrcnnumero()));
                                consulta.setCconprogra(regcirpro.getHrcnprogra());
                                consulta.setCconcontra(regcirpro.getHrcntipusu());
                                consulta.setCcocservic(servicio);
                                consulta.setCconcantid(new Integer(1));
                                consulta.setCcoavalser(new BigDecimal(0));
                                consulta.setCcodfecreg(regcirpro.getHrctfecreg());
                                consulta.setCcothorcon(regcirpro.getHrctfecreg());
                                consulta.setCcocusureg(userName);
                                consulta.setCcocetapa(IConstantes.CEN_SALA);
                                consulta.setCcocestado(IConstantes.ESTADO_VIGENTE);
                                consulta.setCcondonant(regcirpro.getHrcndonant());
                                consulta.setCcocgenero(usuario.getHusesexo());
                                consulta.setCcolusuario(regcirpro.getHrclusuario());
                                consulta.setCcocintext("I");

                                session.saveOrUpdate(consulta);

//                                regcirpro.setHrcnconini(hrcnconini.intValue());
                                regcirpro.setHrcnconini(consulta.getCconnumero());
                                regcirpro.setHrcnconfac(new Integer(0));
                                regcirpro.setHrcnnumfac(new BigDecimal(0));

                                session.saveOrUpdate(regcirpro);


                          

                            return regcirpro;
                        }
                    });
        } catch (HibernateException e) {
            throw new ModelException("Error Insertando :" + e.getMessage(), e);
        } catch (Exception e) {
            throw new ModelException("Error Insertando :" + e.getMessage(), e);
        }
    }


    /**
     * @param codigo
     * @return
     * @throws ModelException
     */
    public Cptipodocu getTipoDocuPorId(Integer codigo) throws ModelException {
        List<Cptipodocu> resultList = null;
        List parametros = new ArrayList();


        try {
            if (codigo != null) {

                StringBuffer sb = new StringBuffer();
                sb.append(" select cpti from " + Cptipodocu.class.getName() + 
                          " cpti  where cpti.ctdnnumero = ? ");
                parametros.add(codigo);

                resultList = 
                        (List<Cptipodocu>) this.getHibernateTemplate().find(sb.toString(), parametros.toArray());


                if (!resultList.isEmpty()) {
                    return resultList.get(0);
                }
            }

            return null;

        } catch (HibernateException e) {
            throw new ModelException("Error consultando Tipo de Documento :" + 
                                     e.getMessage(), e);
        } catch (Exception e) {
            throw new ModelException("Error consultando Tipo de Documento:" + 
                                     e.getMessage(), e);
        }

    }


    /**
     * @param regcirpro
     * @throws ModelException
     */
    public void confirmarCirugiaSinFactura(final Chregicirpro regcirpro) throws ModelException {
        try {
            this.getHibernateTemplate().execute(new HibernateCallback() {
                        public Object doInHibernate(Session session) {

                            session.createQuery("UPDATE clinico.Cnconsclin " + 
                                                   " SET ccocestado = '" + 
                                                   IConstantes.ESTADO_ANULADO + 
                                                   "'" + 
                                                   " WHERE cconnumero = " + 
                                                   regcirpro.getHrcnconfac() + 
                                                   " AND cconclinic = " + 
                                                   regcirpro.getHrcnclinic().getCclncodigo() + 
                                                   " AND ccontipdoc = " + 
                                                   IConstantes.CDOC_FACSAP + 
                                                   " AND cconnumdoc = " + 
                                                   regcirpro.getHrcnnumfac() + 
                                                   " AND ccocservic = '" + 
                                                   regcirpro.getHrccservic().getCsvccodigo() + 
                                                   "'" + 
                                                   " AND ccocestado = '" + 
                                                   IConstantes.ESTADO_VIGENTE + 
                                                   "'").executeUpdate();

                            session.createQuery("UPDATE clinico.Cnconsclin " + 
                                                   " SET ccontipdoc = " + 
                                                   IConstantes.CDOC_FACSAP + 
                                                   " , cconnumdoc = " + 
                                                   regcirpro.getHrcnnumfac() + 
                                                   " WHERE ccontipdoc = " + 
                                                   IConstantes.CDOC_CISFAC + 
                                                   " AND cconnumero = " + 
                                                   regcirpro.getHrcnconini() + 
                                                   " AND cconclinic = " + 
                                                   regcirpro.getHrcnclinic().getCclncodigo() + 
                                                   " AND ccocestado = '" + 
                                                   IConstantes.ESTADO_VIGENTE + 
                                                   "'" + 
                                                   " AND ccocservic = '" + 
                                                   regcirpro.getHrccservic().getCsvccodigo() + 
                                                   "'").executeUpdate();

                            session.update(regcirpro);

                            return regcirpro;
                        }
                    });
        } catch (HibernateException e) {
            throw new ModelException("Error Actualizando Cirugia sin Factura :" + 
                                     e.getMessage(), e);
        } catch (Exception e) {
            throw new ModelException("Error Actualizando Cirugia sin Factura :" + 
                                     e.getMessage(), e);
        }
    }
    
    
    /**
     * @param regcirpro
     * @throws ModelException
     */
     public void confirmarConsultaSinFactura(final Chregiconpro regcirpro) throws ModelException {
           try {
               this.getHibernateTemplate().execute(new HibernateCallback() {
                           public Object doInHibernate(Session session) {

                               session.createQuery("UPDATE clinico.Cnconsclin " + 
                                                      " SET ccocestado = '" + 
                                                      IConstantes.ESTADO_ANULADO + 
                                                      "'" + 
                                                      " WHERE cconnumero = " + 
                                                      regcirpro.getHrcnconfac() + 
                                                      " AND cconclinic = " + 
                                                      regcirpro.getHrcnclinic().getCclncodigo() + 
                                                      " AND ccontipdoc = " + 
                                                      IConstantes.CDOC_FACSAP +
                                                       " AND ccocservic = '" + 
                                                        regcirpro.getWservic() + "'"+ 
                                                      " AND cconnumdoc = " + 
                                                      regcirpro.getHrcnnumfac() + 
                                                      " AND ccocestado = '" + 
                                                      IConstantes.ESTADO_VIGENTE + 
                                                      "'").executeUpdate();
                                                      
                                                      System.out.println("servicio:: " +  regcirpro.getHrccservic().getCsvccodigo());

                               session.createQuery("UPDATE clinico.Cnconsclin " + 
                                                      " SET ccontipdoc = " + 
                                                      IConstantes.CDOC_FACSAP + 
                                                      " , cconnumdoc = " + 
                                                      regcirpro.getHrcnnumfac() +
                                                       " , ccocservic = '" + 
                                                       regcirpro.getWservic()+ 
                                                      "'" + 
                                                      
                                                      " WHERE ccontipdoc = " + 
                                                      IConstantes.CDOC_IVEFAC + 
                                                      " AND cconnumero = " + 
                                                      regcirpro.getHrcnconini() + 
                                                      " AND cconclinic = " + 
                                                      regcirpro.getHrcnclinic().getCclncodigo() + 
                                                      " AND ccocestado = '" + 
                                                      IConstantes.ESTADO_VIGENTE + 
                                                      "'" ).executeUpdate();

                               session.update(regcirpro);

                               return regcirpro;
                           }
                       });
           } catch (HibernateException e) {
               throw new ModelException("Error Actualizando Consulta sin Factura :" + 
                                        e.getMessage(), e);
           } catch (Exception e) {
               throw new ModelException("Error Actualizando Consulta sin Factura :" + 
                                        e.getMessage(), e);
           }
           }
           
    /**
     * @param clinica
     * @param tipoDocumento
     * @param numeroDocumento
     * @param servicio
     * @return
     * @throws ModelException
     */
    public Integer getNumeroConsultaClinicaPorDocumento(Integer clinica, 
                                                        Integer tipoDocumento, 
                                                        BigDecimal numeroDocumento, 
                                                        String servicio) throws ModelException {
        List<Integer> resultList = null;
        List parametros = new ArrayList();

        try {
            if (clinica != null && tipoDocumento != null && 
                numeroDocumento != null && servicio != null) {
                StringBuffer sb = new StringBuffer();
                sb.append(" select cnco.cconnumero from " + 
                          Cnconsclin.class.getName());
                sb.append(" cnco where cnco.cconclinic = ? ");
                sb.append(" and cnco.ccontipdoc = ? ");
                sb.append(" and cnco.cconnumdoc = ? ");
                sb.append(" and cnco.ccocservic = ? ");
                sb.append(" and cnco.ccocestado = ? ");
                parametros.add(clinica);
                parametros.add(tipoDocumento);
                parametros.add(numeroDocumento);
                parametros.add(servicio);
                parametros.add(IConstantes.ESTADO_VIGENTE);

                resultList = 
                        (List<Integer>) this.getHibernateTemplate().find(sb.toString(), parametros.toArray());

                if (!resultList.isEmpty()) {
                    return resultList.get(0);
                }
            }
            return null;

        } catch (HibernateException e) {
            throw new ModelException("Error no selecciono Consulta Clinica :" + 
                                     e.getMessage(), e);
        } catch (Exception e) {
            throw new ModelException("Error no selecciono Consulta Clinica : " + 
                                     e.getMessage(), e);
        }

    }

    /**
     * @param clinica
     * @param tipoDocumento
     * @param numeroDocumento
     * @param servicio
     * @return
     * @throws ModelException
     */
    public Cnconsclin getNumeroConsultaClinicaIVEPorDocumento(final Integer clinica, 
                                                       final Integer tipoDocumento, 
                                                       final BigDecimal numeroDocumento, 
                                                       final String servicio) throws ModelException {
                    Cnconsclin pis = 
                        (Cnconsclin)getHibernateTemplate().execute(new HibernateCallback() {
                                public Object doInHibernate(Session session) throws HibernateException {


                                    if (clinica != null && 
                                        tipoDocumento != null && numeroDocumento != null && 
                                        servicio != null) {
                                        StringBuffer sb = new StringBuffer();
                                        
                                        sb.append(" select cnco from " + 
                                        Cnconsclin.class.getName());
                                        sb.append(" cnco where cnco.cconclinic = :clinica ");
                                        sb.append(" and cnco.ccontipdoc = :tipoDocumento ");
                                        sb.append(" and cnco.cconnumdoc = :numeroDocumento ");
                                        if(servicio != null && servicio.equals("S890202.19")){
                                            sb.append(" and cnco.ccocservic  in (select chst.comp_id.hstccodiserv from Chserxtipo chst where chst.comp_id.hstncoditipo = 84) ");    
                                        } else if (servicio != null && servicio.equals("S881401.2")){
                                            sb.append(" and cnco.ccocservic  in (select chst.comp_id.hstccodiserv from Chserxtipo chst where chst.comp_id.hstncoditipo = 144) ");    
                                        }else{
                                            sb.append(" and cnco.ccocservic  = :servicio ");
                                        }
                                        
                                        sb.append(" and cnco.ccocestado = :estado ");

                                        String hql = sb.toString();

                                        Query query = session.createQuery(hql);
                                        query.setParameter("clinica", clinica);
                                        query.setParameter("tipoDocumento",  tipoDocumento);
                                        query.setParameter("numeroDocumento", numeroDocumento);
                                         query.setParameter("estado", 
                                                           IConstantes.ESTADO_VIGENTE);
                                                           
                                        if(servicio == null || (!servicio.equals("S890202.19") && !servicio.equals("S881401.2"))){
                                            query.setParameter("servicio",  servicio);
                                        }
                                                           
                                        List<Cnconsclin> pis;
                                        pis = query.list();

                                        for (Cnconsclin co: pis) {
                                            Cpservicio servicio = co.getCcocservic();
                                            Hibernate.initialize(servicio);

                                            Cptipodocu tipoDoc = co.getCcontipdoc();
                                            Hibernate.initialize(tipoDoc);


                                        }
                                        if(pis == null || pis.isEmpty())  {
                                            return null;
                                        }else{
                                            return pis.get(0);
                                        }
                                    }
                                    return null;
                                }
                            });
                    return pis;
                    }

                

    /**
     * @param parametro
     * @throws ModelException
     */
    public void saveParametroVerificacionQuirofano(final Chparavrqui parametro) throws ModelException {
        try {
            this.getHibernateTemplate().execute(new HibernateCallback() {
                        public Object doInHibernate(Session session) {
                            Integer consecutivo = null;
                            if (parametro != null) {


                                if (parametro.getHpqnconsec() == null) {
                                    StringBuffer sb1 = new StringBuffer();
                                    sb1.append(" select max(chpa.hpqnconsec) from " + 
                                               Chparavrqui.class.getName() + 
                                               " chpa  ");
                                    Query query1 = 
                                        session.createQuery(sb1.toString());

                                    Integer secuenciaActual = 
                                        (Integer)query1.uniqueResult();

                                    if (secuenciaActual != null) {
                                        consecutivo = 
                                                secuenciaActual.intValue() + 1;
                                    } else {
                                        consecutivo = 1;
                                    }
                                    if (consecutivo != null) {
                                        parametro.setHpqnconsec(consecutivo);
                                    }
                                }


                                session.saveOrUpdate(parametro);

                            }


                            return parametro;
                        }
                    });
        } catch (HibernateException e) {
            throw new ModelException("Error Insertando parametro verificacion quirofano :" + 
                                     e.getMessage(), e);
        } catch (Exception e) {
            throw new ModelException("Error Insertando parametro verificacion quirofano :" + 
                                     e.getMessage(), e);
        }
    }


    /**
     * @return
     * @throws ModelException
     */
    public List<Chparavrqui> getListaParametroVerificacionQuirofano() throws ModelException {
        List<Chparavrqui> resultList = null;
        List parametros = new ArrayList();

        try {
            StringBuffer sb = new StringBuffer();
            sb.append(" select chpa from " + Chparavrqui.class.getName() + 
                      " chpa  where chpa.hpqcestado in ('AC', 'IN')  ");
            sb.append(" order by  chpa.hpqcliteral, chpa.hpqnnumeral ");

            resultList = 
                    (List<Chparavrqui>) this.getHibernateTemplate().find(sb.toString(), parametros.toArray());

            if (!resultList.isEmpty()) {
                return resultList;
            }

            return null;

        } catch (HibernateException e) {
            throw new ModelException("Error consultando Parametros Verificacion Quirofano :" + 
                                     e.getMessage(), e);
        } catch (Exception e) {
            throw new ModelException("Error consultando Parametros Verificacion Quirofano :" + 
                                     e.getMessage(), e);
        }

    }


    /**
     * @param numeroCirugia
     * @return
     * @throws ModelException
     */
    public Chverquirofa getChverquirofa(Long numeroCirugia) throws ModelException {
        List<Chverquirofa> resultList = null;
        List parametros = new ArrayList();


        try {
            if (numeroCirugia != null) {

                StringBuffer sb = new StringBuffer();
                sb.append(" select chve from " + Chverquirofa.class.getName() + 
                          " chve  where chve.hvqlcirugia = ? ");
                parametros.add(numeroCirugia);

                resultList = 
                        (List<Chverquirofa>) this.getHibernateTemplate().find(sb.toString(), parametros.toArray());

                if (!resultList.isEmpty()) {
                    return resultList.get(0);
                }

            }
            return null;

        } catch (HibernateException e) {
            throw new ModelException("Error consultando Verificacion Quirofano" + 
                                     e.getMessage(), e);
        } catch (Exception e) {
            throw new ModelException("Error consultando Verificacion Quirofano:" + 
                                     e.getMessage(), e);
        }

    }

    /**
     * @return
     * @throws ModelException
     */
    public List<Chitemvrquir> getItemVerificadosQuirofano(Long numeroCirugia) throws ModelException {
        List<Chitemvrquir> resultList = null;
        List parametros = new ArrayList();

        try {
            StringBuffer sb = new StringBuffer();
            sb.append(" select chit from " + Chitemvrquir.class.getName() + 
                      " chit  where chit.id.hiqlcirugia = ? ");
            sb.append(" order by  chit.id.hiqcliteral, chit.id.hiqnnumeral ");
            parametros.add(numeroCirugia);

            resultList = 
                    (List<Chitemvrquir>) this.getHibernateTemplate().find(sb.toString(), parametros.toArray());

            if (!resultList.isEmpty()) {
                return resultList;
            }

            return null;

        } catch (HibernateException e) {
            throw new ModelException("Error consultando Item Verificados Quirofano :" + 
                                     e.getMessage(), e);
        } catch (Exception e) {
            throw new ModelException("Error consultando Item Verificados Quirofano :" + 
                                     e.getMessage(), e);
        }

    }

    /**
     * @return
     * @throws ModelException
     */
    public List<Chitemvrquir> getItemPorVerificarQuirofano(final Long numeroCirugia, 
                                                           final String registra, 
                                                           final String tipoAnestesia, 
                                                           final String etapa, 
                                                           final String usuario) throws ModelException {
        try {
            List<Chitemvrquir> resultList = new ArrayList();
            List<Chparavrqui> parametroVerificacion = null;

            StringBuffer sb = new StringBuffer();
            sb.append(" select chpa from " + Chparavrqui.class.getName() + 
                      " chpa where chpa.hpqcestado = 'AC' " + 
                      " and (chpa.hpqnnumeral = 0 or ( chpa.hpqcetapa = '" + 
                      etapa + "' ");
            if (tipoAnestesia.equals("3")) /* local la enfermera registra lo del anestesiologo*/ {
                if (registra.equals("E")) {
                    sb.append(" AND chpa.hpqcreganeste in ('S','N') ");
                } else {
                    sb.append(" AND chpa.hpqcreganeste = 'S' ");
                }
            } else {
                if (registra.equals("E"))
                    sb.append(" AND chpa.hpqcreganeste = 'N' ");
                else
                    sb.append(" AND chpa.hpqcreganeste = 'S' ");
            }
            if (tipoAnestesia.equals("2")) /* general */
                sb.append(" AND chpa.hpqcanesgen = 'S' ");
            if (tipoAnestesia.equals("3")) /* local */
                sb.append(" AND chpa.hpqcanesloc = 'S' ");
            if (tipoAnestesia.equals("4")) /* regional */
                sb.append(" AND chpa.hpqcanesreg = 'S' ");
            sb.append(" ) ) order by  chpa.hpqcliteral, chpa.hpqnnumeral ");

            parametroVerificacion = 
                    (List<Chparavrqui>) this.getHibernateTemplate().find(sb.toString());

            if (!parametroVerificacion.isEmpty()) {
                List respuesta;
                Chitemvrquir itemvrquir;
                ChitemvrquirPK itemvrquirPK;

                for (Chparavrqui paravrqui: parametroVerificacion) {
                    List parametros = new ArrayList();
                    itemvrquir = new Chitemvrquir();
                    if (paravrqui.getHpqnnumeral().intValue() == 0) {
                        itemvrquirPK = new ChitemvrquirPK();
                        itemvrquirPK.setHiqlcirugia(numeroCirugia);
                        itemvrquirPK.setHiqcliteral(paravrqui.getHpqcliteral());
                        itemvrquirPK.setHiqnnumeral(paravrqui.getHpqnnumeral());
                        itemvrquir.setId(itemvrquirPK);
                        itemvrquir.setHiqcdescri(paravrqui.getHpqcdescri());
                        itemvrquir.setHiqdfecreg(new Date());
                        itemvrquir.setHiqcgrabad(usuario);
                        itemvrquir.setHiqcrespuesta(" ");
                        itemvrquir.setHiqcetapa(paravrqui.getHpqcetapa());
                        if (paravrqui.getHpqnnumeral().intValue() == 0) {
                            itemvrquir.setHiqcnoaplica(" ");
                        } else {
                            itemvrquir.setHiqcnoaplica(paravrqui.getHpqcnoaplica());
                        }
                        resultList.add(itemvrquir);

                    } else {
                        StringBuffer sitem = new StringBuffer();
                        sitem.append("select chit.hiqcrespuesta from " + 
                                     Chitemvrquir.class.getName() + 
                                     " chit where chit.id.hiqlcirugia = ? " + 
                                     " and chit.id.hiqcliteral = ? " + 
                                     " and chit.id.hiqnnumeral = ? ");

                        parametros.add(numeroCirugia);
                        parametros.add(paravrqui.getHpqcliteral());
                        parametros.add(paravrqui.getHpqnnumeral());

                        respuesta = 
                                this.getHibernateTemplate().find(sitem.toString(), 
                                                                 parametros.toArray());

                        if (respuesta.isEmpty()) {
                            itemvrquirPK = new ChitemvrquirPK();
                            itemvrquirPK.setHiqlcirugia(numeroCirugia);
                            itemvrquirPK.setHiqcliteral(paravrqui.getHpqcliteral());
                            itemvrquirPK.setHiqnnumeral(paravrqui.getHpqnnumeral());
                            itemvrquir.setId(itemvrquirPK);
                            itemvrquir.setHiqcdescri(paravrqui.getHpqcdescri());
                            itemvrquir.setHiqdfecreg(new Date());
                            itemvrquir.setHiqcgrabad(usuario);
                            itemvrquir.setHiqcrespuesta(" ");
                            itemvrquir.setHiqcetapa(paravrqui.getHpqcetapa());
                            if (paravrqui.getHpqnnumeral().intValue() == 0) {
                                itemvrquir.setHiqcnoaplica(" ");
                            } else {
                                itemvrquir.setHiqcnoaplica(paravrqui.getHpqcnoaplica());
                            }

                            resultList.add(itemvrquir);
                        }
                    }
                }
            }
            return resultList;
        } catch (HibernateException e) {
            e.printStackTrace();
            throw new ModelException("Error registrando verificacion quirofano :" + 
                                     e.getMessage(), e);
        } catch (Exception e) {
            e.printStackTrace();
            throw new ModelException("Error registrando verificacion quirofano :" + 
                                     e.getMessage(), e);
        }
    }


    /**
     * @param verquirofa
     * @param lstItemvrquir
     * @throws ModelException
     */
    public void saveVerificacionQuirofano(final Chverquirofa verquirofa, 
                                          final List<Chitemvrquir> lstItemvrquir) throws ModelException {
        try {
            this.getHibernateTemplate().execute(new HibernateCallback() {
                        public Object doInHibernate(Session session) {
                            session.saveOrUpdate(verquirofa);

                            String respuesta;
                            for (Chitemvrquir item: lstItemvrquir) {
                                StringBuffer sitem = new StringBuffer();
                                sitem.append("select chit.hiqcrespuesta from " + 
                                             Chitemvrquir.class.getName() + 
                                             " chit where chit.id.hiqlcirugia = " + 
                                             item.getId().getHiqlcirugia().intValue() + 
                                             " and chit.id.hiqcliteral = '" + 
                                             item.getId().getHiqcliteral() + 
                                             "'" + 
                                             " and chit.id.hiqnnumeral = " + 
                                             item.getId().getHiqnnumeral() + 
                                             " ");

                                Query query1 = 
                                    session.createQuery(sitem.toString());

                                respuesta = (String)query1.uniqueResult();

                                if (respuesta == null) {
                                    item.getId().setHiqlcirugia(new Long(verquirofa.getHvqlcirugia()));
                                    item.setHiqdfecreg(verquirofa.getHvqdfecreg());
                                    item.setHiqcgrabad(verquirofa.getHvqcgrabador());
                                    session.saveOrUpdate(item);
                                }
                            }
                            return verquirofa;
                        }
                    });
        } catch (HibernateException e) {
            throw new ModelException("Error Insertando :" + e.getMessage(), e);
        } catch (Exception e) {
            throw new ModelException("Error Insertando :" + e.getMessage(), e);
        }
    }

    /**
     * @param numero
     * @param tipoServicio
     * @return
     * @throws ModelException
     */
    public List<Chformulaliq> getLstLiquidosFormuladosPorAdministrar(Long numero, 
                                                                     String tipoServicio) throws ModelException {
        List<Chformulaliq> resultList = null;
        List parametros = new ArrayList<Chcontroliqu>();

        try {
            if (numero != null && tipoServicio != null) {
                StringBuffer sb = new StringBuffer();
                sb.append(" select chfo from " + Chformulaliq.class.getName());
                sb.append(" chfo  where chfo.id.hfllconsulta = ? ");
                sb.append(" AND   chfo.hflctiposerv =  ? ");
                sb.append(" AND   chfo.hflcestado NOT IN ('AT','SP') ");
                sb.append(" order by chfo.id.hflnconsecutiv ");
                parametros.add(numero);
                parametros.add(tipoServicio);

                resultList = 
                        (List<Chformulaliq>) this.getHibernateTemplate().find(sb.toString(), parametros.toArray());

                if (!resultList.isEmpty()) {
                    return resultList;
                }
            }
            return null;

        } catch (HibernateException e) {
            throw new ModelException("Error consultando Liquidos Formulados Por Administrar:" + 
                                     e.getMessage(), e);
        } catch (Exception e) {
            throw new ModelException("Error consultando Liquidos Formulados Por Administrar: " + 
                                     e.getMessage(), e);
        }

    }

    /**
     * @param codclin
     * @param especialidad
     * * @return
     * @throws ModelException
     */
    public List<Cpprofesio> getListaProfesionalPorEspecialidad(Integer codclin, 
                                                               Integer especialidad) throws ModelException {
        List<Cpprofesio> resultList = null;
        List parametros = new ArrayList();

        try {
            if (codclin != null) {
                StringBuffer sb = new StringBuffer();
                sb.append(" select cppr from " + 
                          Cpprofesio.class.getName()).append(" cppr ");
                sb.append(" where  cppr.id.cpfnclinic = ? and cppr.cpfcestado = ? ");
                sb.append(" and  cppr.cpfntipoespe = ? ");
                sb.append(" order by cppr.cpfcnombre ");
                parametros.add(codclin);
                parametros.add(IConstantes.ESTADO_VIGENTE);
                parametros.add(especialidad);

                resultList = 
                        (List<Cpprofesio>) this.getHibernateTemplate().find(sb.toString(), parametros.toArray());


                if (!resultList.isEmpty()) {
                    return resultList;
                }

            }

            return null;

        } catch (HibernateException e) {
            throw new ModelException("Error consultando Lista de Profesionales por Especialidad:" + 
                                     e.getMessage(), e);
        } catch (Exception e) {
            throw new ModelException("Error consultando Lista de Profesionales por Especialidad:" + 
                                     e.getMessage(), e);
        }

    }

    /**
     * @param usuario
     * @return
     * @throws ModelException
     */
    public List<Chregicirpro> getCirugiasSinFacturaPorConfirmar(final Integer clinica) throws ModelException {
        List<Chregicirpro> pis = 
            (List<Chregicirpro>)getHibernateTemplate().execute(new HibernateCallback() {
                    public Object doInHibernate(Session session) throws HibernateException {


                        if (clinica != null) {

                            StringBuffer sb = new StringBuffer();
                            sb.append(" select  chre from ");
                            sb.append(Chregicirpro.class.getName()).append(" chre ");
                            sb.append(" where chre.hrcnclinic = :clinica ");
                            sb.append(" and chre.hrccetapa = :etapa ");
                            sb.append(" and chre.hrccestado = :estado ");
                            sb.append(" order by chre.hrcnnumero desc ");
                            String hql = sb.toString();

                            Query query = session.createQuery(hql);
                            query.setParameter("etapa", 
                                               IConstantes.ETAPA_REGISTRO);
                            query.setParameter("estado", 
                                               IConstantes.ESTADO_VIGENTE);
                            query.setParameter("clinica", clinica);
                            List<Chregicirpro> pis;
                            pis = query.list();

                            for (Chregicirpro ci: pis) {
                                Cpservicio sv = ci.getHrccservic();
                                Hibernate.initialize(sv);

                                Chusuario usu = ci.getHrclusuario();
                                Hibernate.initialize(usu);

                            }

                            return pis;
                        }
                        return null;
                    }
                });
        return pis;
    }

    /**
     * @param numero
     * @return
     * @throws ModelException
     */
    public Chregicirpro getCirsinfacByNumero(Long numero) throws ModelException {
        List<Chregicirpro> resultList = null;
        List parametros = new ArrayList();

        try {


            StringBuffer sb = new StringBuffer();
            sb.append(" select chre from " + Chregicirpro.class.getName() + 
                      " chre  where chre.hrcnnumero  = ?  ");
            parametros.add(numero);


            resultList = 
                    (List<Chregicirpro>) this.getHibernateTemplate().find(sb.toString(), parametros.toArray());


            if (!resultList.isEmpty()) {
                return resultList.get(0);
            }


            return null;

        } catch (HibernateException e) {
            throw new ModelException("Error consultando Cirugia sin factura:" + 
                                     e.getMessage(), e);
        } catch (Exception e) {
            throw new ModelException("Error consultando Cirugia sin factura:" + 
                                     e.getMessage(), e);
        }

    }
    
    
    /**
     * @param numero
     * @return
     * @throws ModelException
     */
    public Chregiconpro getConsultasinfacByNumero(Long numero) throws ModelException {
        List<Chregiconpro> resultList = null;
        List parametros = new ArrayList();

        try {


            StringBuffer sb = new StringBuffer();
            sb.append(" select chre from " + Chregiconpro.class.getName() + 
                      " chre  where chre.hrcnnumero  = ?  ");
            parametros.add(numero);


            resultList = 
                    (List<Chregiconpro>) this.getHibernateTemplate().find(sb.toString(), parametros.toArray());


            if (!resultList.isEmpty()) {
                return resultList.get(0);
            }


            return null;

        } catch (HibernateException e) {
            throw new ModelException("Error consultando Consulta sin factura:" + 
                                     e.getMessage(), e);
        } catch (Exception e) {
            throw new ModelException("Error consultando Consulta sin factura:" + 
                                     e.getMessage(), e);
        }

    }

    /**
     * @param numeroUsuario
     * @return
     * @throws ModelException
     */
    public Object[] getUltimaValoracionPreUsuario(Long numeroUsuario) throws ModelException {
        List<Object[]> resultList = null;

        try {
            if (numeroUsuario != null) {

                StringBuffer sb = new StringBuffer();
                sb.append(" select chim.hidcdiagprin, chim.hidcdiagrela1 ");
                sb.append(" from historia.Chimprdiag chim, historia.Chconsulta chco, Clinico.Cpservicio cpse ");
                sb.append(" where chco.hcolnumero = chim.hidlconsulta");
                sb.append(" and chco.hcolusuario = :numeroUsuario  ");
                sb.append(" and chco.hcoctiposervi = 'C' and  chco.hcoeetapa = 'CE' ");
                sb.append("  and chco.hcocservicio = cpse.csvccodigo and cpse.csvntipcon  not in (98) ");
                sb.append(" order by chco.hcodfecregistr DESC ");
              

                Query sqlquery = 
                    this.getHibernateTemplate().getSessionFactory().getCurrentSession().createQuery(sb.toString());
                sqlquery.setParameter("numeroUsuario", numeroUsuario);

                resultList = sqlquery.list();


                if (!resultList.isEmpty()) {
                    return resultList.get(0);
                }
            }
            return null;
        } catch (HibernateException e) {
            throw new ModelException("Error consultando Ultima Consulta Externa :" + 
                                     e.getMessage(), e);
        } catch (Exception e) {
            throw new ModelException("Error consultando Ultima Consulta Externa :" + 
                                     e.getMessage(), e);
        }

    }


    /**
     * @param numeroUsuario
     * @return
     * @throws ModelException
     */
    public Object[] getUltimaValoracionPreAnesUsuario(Long numeroUsuario) throws ModelException {
        List<Object[]> resultList = null;

        try {
            if (numeroUsuario != null) {

                StringBuffer sb = new StringBuffer();
                sb.append(" select chim.hidcdiagprin, chim.hidcdiagrela1, chim.hidngradoasa ");
                sb.append(" from historia.Chimprdiag chim, historia.Chconsulta chco , Clinico.Cpservicio cpse");
                sb.append(" where chco.hcolnumero = chim.hidlconsulta");
                sb.append(" and chco.hcolusuario = :numeroUsuario ");
                sb.append(" and chco.hcoctiposervi = 'C' and  chco.hcoeetapa = 'CE' ");
                sb.append(" and chco.hcocservicio = cpse.csvccodigo and cpse.csvntipcon  not in (98) ");
                sb.append(" order by chco.hcodfecregistr DESC ");

                Query sqlquery = 
                    this.getHibernateTemplate().getSessionFactory().getCurrentSession().createQuery(sb.toString());
                sqlquery.setParameter("numeroUsuario", numeroUsuario);

                resultList = sqlquery.list();


                if (!resultList.isEmpty()) {
                    return resultList.get(0);
                }
            }
            return null;
        } catch (HibernateException e) {
            throw new ModelException("Error consultando Ultima Consulta Externa :" + 
                                     e.getMessage(), e);
        } catch (Exception e) {
            throw new ModelException("Error consultando Ultima Consulta Externa :" + 
                                     e.getMessage(), e);
        }

    }


    /*
   Ultimo examen fisico de la valoracion prequirurgica
     */


    /**
     * @param numeroUsuario
     * @return
     * @throws ModelException
     */
    public Object[] getUltimaValoracionPreExamUsuario(Long numeroUsuario) throws ModelException {
        List<Object[]> resultList = null;

        try {
            if (numeroUsuario != null) {

                StringBuffer sb = new StringBuffer();
                sb.append(" select chex.hefapeso, chex.heflconsulta, chex.hefatalla ");
                sb.append(" from historia.Chexamfisico chex, historia.Chconsulta chco, Clinico.Cpservicio cpse  ");
                sb.append(" where chco.hcolnumero = chex.heflconsulta");
                sb.append(" and chco.hcolusuario = :numeroUsuario  ");
                sb.append(" and chco.hcoctiposervi = 'C' and  chco.hcoeetapa = 'CE' ");
                sb.append(" and chco.hcocservicio = cpse.csvccodigo and cpse.csvntipcon  not in (98)  ");
                sb.append(" order by chco.hcodfecregistr DESC ");

                Query sqlquery = 
                    this.getHibernateTemplate().getSessionFactory().getCurrentSession().createQuery(sb.toString());
                sqlquery.setParameter("numeroUsuario", numeroUsuario);

                resultList = sqlquery.list();


                if (!resultList.isEmpty()) {
                    return resultList.get(0);
                }
            }
            return null;
        } catch (HibernateException e) {
            throw new ModelException("Error consultando Ultima Consulta Externa :" + 
                                     e.getMessage(), e);
        } catch (Exception e) {
            throw new ModelException("Error consultando Ultima Consulta Externa :" + 
                                     e.getMessage(), e);
        }

    }


    /**
     * @param numeroUsuario
     * @return
     * @throws ModelException
     */
    public Object[] getUltimaValoracionPreExamAnesUsuario(Long numeroUsuario) throws ModelException {
        List<Object[]> resultList = null;

        try {
            if (numeroUsuario != null) {

                StringBuffer sb = new StringBuffer();
                sb.append(" select chex.hefapeso, chex.heflconsulta, chex.hefatalla ");
                sb.append(" from historia.Chexamfisico chex, historia.Chconsulta chco, Clinico.Cpservicio cpse ");
                sb.append(" where chco.hcolnumero = chex.heflconsulta");
                sb.append(" and chco.hcolusuario = :numeroUsuario  ");
                sb.append(" and chco.hcoctiposervi = 'C' and  chco.hcoeetapa = 'CE' ");
                sb.append(" and chco.hcocservicio = cpse.csvccodigo and cpse.csvntipcon not in (98) ");
                sb.append(" order by chco.hcodfecregistr DESC ");

                Query sqlquery = 
                    this.getHibernateTemplate().getSessionFactory().getCurrentSession().createQuery(sb.toString());
                sqlquery.setParameter("numeroUsuario", numeroUsuario);

                resultList = sqlquery.list();


                if (!resultList.isEmpty()) {
                    return resultList.get(0);
                }
            }
            return null;
        } catch (HibernateException e) {
            throw new ModelException("Error consultando Ultima Consulta Externa :" + 
                                     e.getMessage(), e);
        } catch (Exception e) {
            throw new ModelException("Error consultando Ultima Consulta Externa :" + 
                                     e.getMessage(), e);
        }

    }


    /**
     * @param numeroUsuario
     * @return
     * @throws ModelException
     */
    public Object[] getUltimaValoracionPreUsuarioMotivo(Long numeroUsuario) throws ModelException {
        List<Object[]> resultList = null;

        try {
            if (numeroUsuario != null) {

                
                StringBuffer sb = new StringBuffer();
                             sb.append(" select chim.hidcdiagprin, chim.hidcdiagrela1 ");
                             sb.append(" from historia.Chimprdiag chim, historia.Chconsulta chco, Clinico.Cpservicio cpse ");
                             sb.append(" where chco.hcolnumero = chim.hidlconsulta");
                             sb.append(" and chco.hcolusuario = :numeroUsuario  ");
                             sb.append(" and chco.hcoctiposervi = 'C' and  chco.hcoeetapa = 'CE' ");
                             sb.append("  and chco.hcocservicio = cpse.csvccodigo and cpse.csvntipcon not in (98) ");
                             sb.append(" order by chco.hcodfecregistr DESC ");

                Query sqlquery = 
                    this.getHibernateTemplate().getSessionFactory().getCurrentSession().createQuery(sb.toString());
                sqlquery.setParameter("numeroUsuario", numeroUsuario);

                resultList = sqlquery.list();


                if (!resultList.isEmpty()) {
                    return resultList.get(0);
                }
            }
            return null;
        } catch (HibernateException e) {
            throw new ModelException("Error consultando Ultima Consulta Prequirurgica :" + 
                                     e.getMessage(), e);
        } catch (Exception e) {
            throw new ModelException("Error consultando Ultima Consulta Prequirurgica :" + 
                                     e.getMessage(), e);
        }

    }


    /**
     * 
     * @param numeroConsulta
     * @return
     * @throws ModelException
     */
    public BigDecimal getMedicoProgramacion(Long numeroConsulta) throws ModelException {
        List<BigDecimal> resultList = null;
        List parametros = new ArrayList();

        try {
            if (numeroConsulta != null) {
                StringBuffer sb = new StringBuffer();
                sb.append(" select chde.hdcnmedicatien from " + 
                          Chdetacirpro.class.getName());
                sb.append(" chde where chde.hdclconsuasoci = ? ");

                parametros.add(numeroConsulta);

                resultList = 
                        (List<BigDecimal>) this.getHibernateTemplate().find(sb.toString(), parametros.toArray());

                if (!resultList.isEmpty()) {
                    return resultList.get(0);
                }
            }
            return null;

        } catch (HibernateException e) {
            throw new ModelException("Error no selecciono Consulta Clinica :" + 
                                     e.getMessage(), e);
        } catch (Exception e) {
            throw new ModelException("Error no selecciono Consulta Clinica : " + 
                                     e.getMessage(), e);
        }


    }

    /**
     * 
     * @param username
     *
     */
    public Cpusuario getAnestesiologosAnestesia(final String username) throws ModelException {

        List<Cpusuario> resultList = null;
        List parametros = new ArrayList();


        try {


            StringBuffer sb = new StringBuffer();
            sb.append(" select cpus from " + Cpusuario.class.getName() + 
                      " cpus  where cpus.curcusuari = ?  ");
            parametros.add(username);


            resultList = 
                    (List<Cpusuario>) this.getHibernateTemplate().find(sb.toString(), parametros.toArray());


            if (!resultList.isEmpty()) {
                return resultList.get(0);
            }


            return null;

        } catch (HibernateException e) {
            throw new ModelException("Error consultando Anestesiologos en programacion:" + 
                                     e.getMessage(), e);
        } catch (Exception e) {
            throw new ModelException("Error consultando Anestesiologos en programacion:" + 
                                     e.getMessage(), e);
        }

    }


    /**
     * 
     * @param numeroConsulta
     *
     */
    public Chdetacirpro getServicioDetalle(final Long numeroConsulta) throws ModelException {

        List<Chdetacirpro> resultList = null;
        List parametros = new ArrayList();


        try {


            StringBuffer sb = new StringBuffer();
            sb.append(" select chde from " + Chdetacirpro.class.getName() + 
                      " chde  where chde.id.hdclconsuprinc = ?  ");
            parametros.add(numeroConsulta);


            resultList = 
                    (List<Chdetacirpro>) this.getHibernateTemplate().find(sb.toString(), parametros.toArray());


            if (!resultList.isEmpty()) {
                return resultList.get(0);
            }


            return null;

        } catch (HibernateException e) {
            throw new ModelException("Error consultando Servicio en programacion:" + 
                                     e.getMessage(), e);
        } catch (Exception e) {
            throw new ModelException("Error consultando Servicio en programacion:" + 
                                     e.getMessage(), e);
        }

    }
    
  
    
    
    /**
     * 
     * @param numeroConsulta
     *
     */
    public List<Chdetacirpro> getServicioDetalleLista(final Long numeroConsulta) throws ModelException {

        List<Chdetacirpro> resultList = null;
        List parametros = new ArrayList();


        try {


            StringBuffer sb = new StringBuffer();
            sb.append(" select chde from " + Chdetacirpro.class.getName() + 
                      " chde  where chde.id.hdclconsuprinc = ?  ");
            parametros.add(numeroConsulta);


            resultList = 
                    (List<Chdetacirpro>) this.getHibernateTemplate().find(sb.toString(), parametros.toArray());


          
         

        } catch (HibernateException e) {
            throw new ModelException("Error consultando Servicio en programacion:" + 
                                     e.getMessage(), e);
        } catch (Exception e) {
            throw new ModelException("Error consultando Servicio en programacion:" + 
                                     e.getMessage(), e);
        }
        return resultList;
    }
    
    
    
    /**
     * @param codigo
     * @return
     * @throws ModelException
     */
    public List<Cpservicio> getServicioPorId(String codigo) throws ModelException {
        List<Cpservicio> resultList = null;
        List parametros = new ArrayList();


        try {
            if (codigo != null && !codigo.equals("")) {

                StringBuffer sb = new StringBuffer();
                sb.append(" select cups from " + Cpservicio.class.getName() + 
                          " cups  where cups.csvccodigo = ? ");
                parametros.add(codigo);


                resultList = 
                        (List<Cpservicio>) this.getHibernateTemplate().find(sb.toString(), parametros.toArray());


             
            }

         

        } catch (HibernateException e) {
            throw new ModelException("Error consultando servicio :" + 
                                     e.getMessage(), e);
        } catch (Exception e) {
            throw new ModelException("Error consultando servicio:" + 
                                     e.getMessage(), e);
        }
        return resultList;

    }

    
    


    /**
     * @return
     * @throws ModelException
     */
    public List<Crcausaext> getCausaExterna() throws ModelException {
        List<Crcausaext> resultList;
        List parametros = new ArrayList();
        resultList = null;
        try {

            StringBuffer sb = new StringBuffer();
            sb.append("select cex from " + 
                      Crcausaext.class.getName()).append(" cex ");
            sb.append(" order by cex.ccacdescri  ");

            resultList = 
                    (List<Crcausaext>) this.getHibernateTemplate().find(sb.toString(), parametros.toArray());

        } catch (HibernateException e) {
            throw new ModelException("Error consultando Causa Externa:" + 
                                     e.getMessage(), e);
        } catch (Exception e) {
            throw new ModelException("Error consultando causa Externa :" + 
                                     e.getMessage(), e);
        }


        return resultList;
    }

    /**
     * @return
     * @throws ModelException
     */
    public List<Crcausaext> getCausaExternaVG() throws ModelException {
        List<Crcausaext> resultList;
        List parametros = new ArrayList();
        resultList = null;
        try {

            StringBuffer sb = new StringBuffer();
            sb.append("select cex from " + 
                      Crcausaext.class.getName()).append(" cex ");
            sb.append("WHERE cex.ccacestado = 'VG' order by cex.ccacdescri  ");

            resultList = 
                    (List<Crcausaext>) this.getHibernateTemplate().find(sb.toString(), parametros.toArray());

        } catch (HibernateException e) {
            throw new ModelException("Error consultando Causa Externa:" + 
                                     e.getMessage(), e);
        } catch (Exception e) {
            throw new ModelException("Error consultando causa Externa :" + 
                                     e.getMessage(), e);
        }


        return resultList;
    }


    /**
     * @return
     * @throws ModelException
     */
    public List<Crfinalcon> getFinalidad() throws ModelException {
        List<Crfinalcon> resultList;
        List parametros = new ArrayList();
        resultList = null;
        try {

            StringBuffer sb = new StringBuffer();
            sb.append("select crf from " + 
                      Crfinalcon.class.getName()).append(" crf ");


            sb.append(" order by crf.cfccdescri  ");

            resultList = 
                    (List<Crfinalcon>) this.getHibernateTemplate().find(sb.toString(), parametros.toArray());

        } catch (HibernateException e) {
            throw new ModelException("Error consultando Finalidad:" + 
                                     e.getMessage(), e);
        } catch (Exception e) {
            throw new ModelException("Error consultando Finalidad :" + 
                                     e.getMessage(), e);
        }


        return resultList;
    }

    /**
     * @return
     * @throws ModelException
     */
    public List<Crfinalcon> getFinalidadVG() throws ModelException {
        List<Crfinalcon> resultList;
        List parametros = new ArrayList();
        resultList = null;
        try {

            StringBuffer sb = new StringBuffer();
            sb.append("select crf from " + 
                      Crfinalcon.class.getName()).append(" crf ");
            sb.append(" where crf.cfccestado = 'VG'  order by crf.cfccdescri  ");

            resultList = 
                    (List<Crfinalcon>) this.getHibernateTemplate().find(sb.toString(), parametros.toArray());

        } catch (HibernateException e) {
            throw new ModelException("Error consultando Finalidad:" + 
                                     e.getMessage(), e);
        } catch (Exception e) {
            throw new ModelException("Error consultando Finalidad :" + 
                                     e.getMessage(), e);
        }


        return resultList;
    }


    /**
     * @param numero
     * @return
     * @throws ModelException
     */
    public Chregicirpro getCirsinfacNumero(Long numero) throws ModelException {
        List<Chregicirpro> resultList = null;
        List parametros = new ArrayList();

        try {


            StringBuffer sb = new StringBuffer();
            sb.append(" select chre from " + Chregicirpro.class.getName() + 
                      " chre  where chre.hrcnconini  = ?  ");
            parametros.add(numero);


            resultList = 
                    (List<Chregicirpro>) this.getHibernateTemplate().find(sb.toString(), parametros.toArray());


            if (!resultList.isEmpty()) {
                return resultList.get(0);
            }


            return null;

        } catch (HibernateException e) {
            throw new ModelException("Error consultando Cirugia sin factura:" + 
                                     e.getMessage(), e);
        } catch (Exception e) {
            throw new ModelException("Error consultando Cirugia sin factura:" + 
                                     e.getMessage(), e);
        }

    }


    /**
     * @param numero
     * @throws ModelException
     */
    public void updateIngresoCirugia(final Long numero) throws ModelException {
        try {
            this.getHibernateTemplate().execute(new HibernateCallback() {
                        public Object doInHibernate(Session session) {


                            Chcirugprogr cirugia = null;

                            if (numero != null) {

                                StringBuffer sb1 = new StringBuffer();
                                sb1.append(" select chcp from  " + 
                                           Chcirugprogr.class.getName() + 
                                           " chcp  where chcp.hcplnumero = :hcplnumero ");
                                Query query1 = 
                                    session.createQuery(sb1.toString());
                                query1.setParameter("hcplnumero", numero);
                                cirugia = (Chcirugprogr)query1.uniqueResult();

                            }

                            if (cirugia != null) {
                                cirugia.setHcpcetapa(IConstantes.ETAPA_INGRESO_ENFERMERIA);
                            }

                            session.saveOrUpdate(cirugia);


                            return numero;
                        }
                    });
        } catch (HibernateException e) {
            throw new ModelException("Error Insertando :" + e.getMessage(), e);
        } catch (Exception e) {
            throw new ModelException("Error Insertando :" + e.getMessage(), e);
        }
    }


    /**
     * @param numero
     * @throws ModelException
     */
    public void updateIngresoQuirofano(final Long numero) throws ModelException {
        try {
            this.getHibernateTemplate().execute(new HibernateCallback() {
                        public Object doInHibernate(Session session) {


                            Chcirugprogr cirugia = null;

                            if (numero != null) {

                                StringBuffer sb1 = new StringBuffer();
                                sb1.append(" select chcp from  " + 
                                           Chcirugprogr.class.getName() + 
                                           " chcp  where chcp.hcplnumero = :hcplnumero ");
                                Query query1 = 
                                    session.createQuery(sb1.toString());
                                query1.setParameter("hcplnumero", numero);
                                cirugia = (Chcirugprogr)query1.uniqueResult();

                            }

                            if (cirugia != null) {
                                cirugia.setHcpcetapa(IConstantes.ETAPA_CIRUGIA_EN_QUIROFANO);
                            }

                            session.saveOrUpdate(cirugia);


                            return numero;
                        }
                    });
        } catch (HibernateException e) {
            throw new ModelException("Error Insertando :" + e.getMessage(), e);
        } catch (Exception e) {
            throw new ModelException("Error Insertando :" + e.getMessage(), e);
        }
    }


    /**
     * @param numero
     * @throws ModelException
     */
    public void updateIngresoRecuperacion(final Long numero) throws ModelException {
        try {
            this.getHibernateTemplate().execute(new HibernateCallback() {
                        public Object doInHibernate(Session session) {


                            Chcirugprogr cirugia = null;

                            if (numero != null) {

                                StringBuffer sb1 = new StringBuffer();
                                sb1.append(" select chcp from  " + 
                                           Chcirugprogr.class.getName() + 
                                           " chcp  where chcp.hcplnumero = :hcplnumero ");
                                Query query1 = 
                                    session.createQuery(sb1.toString());
                                query1.setParameter("hcplnumero", numero);
                                cirugia = (Chcirugprogr)query1.uniqueResult();

                            }

                            if (cirugia != null) {
                                cirugia.setHcpcetapa(IConstantes.ETAPA_CIRUGIA_EN_RECUPERACION);
                            }

                            session.saveOrUpdate(cirugia);


                            return numero;
                        }
                    });
        } catch (HibernateException e) {
            throw new ModelException("Error Insertando :" + e.getMessage(), e);
        } catch (Exception e) {
            throw new ModelException("Error Insertando :" + e.getMessage(), e);
        }
    }


    /**
     * @param consclin
     * @return
     * @throws ModelException
     */
    public Chconducta getConducta(Cnconsclin consclin) throws ModelException {
        List<Chconducta> resultList = null;
        List parametros = new ArrayList();

        try {
            if (consclin != null) {
                StringBuffer sb = new StringBuffer();
                sb.append(" select chcd from " + Chconducta.class.getName() + 
                          " chcd  where chcd.id.hcnlconsulta = ? AND chcd.id.hcnctiposervi = ? ");
                parametros.add(consclin.getCconnumero());
                parametros.add(IConstantes.TIPO_HOSPITALIZACION);


                resultList = 
                        (List<Chconducta>) this.getHibernateTemplate().find(sb.toString(), parametros.toArray());

                if (!resultList.isEmpty()) {
                    return resultList.get(0);
                }
            }
            return null;

        } catch (HibernateException e) {
            throw new ModelException("Error consultando Conducta:" + 
                                     e.getMessage(), e);
        } catch (Exception e) {
            throw new ModelException("Error consultando Conducta :" + 
                                     e.getMessage(), e);
        }

    }


    public List<Chciruganula> getCirugiasCanceladas(Date fechaInicial, 
                                                    Date fechaFinal, 
                                                    Integer codClinica) throws ModelException {
        List<Chciruganula> resultList = null;
        List parametros = new ArrayList();
        try {

            String HORA_INICIAL = " 00:00";
            String HORA_FINAL = " 23:59";
            String fechaI = null;
            String fechaF = null;
            if (fechaInicial != null && fechaFinal != null) {
                SimpleDateFormat dateFormat = 
                    new SimpleDateFormat("dd/MM/yyyy");

                fechaI = dateFormat.format(fechaInicial) + HORA_INICIAL;
                fechaF = dateFormat.format(fechaFinal) + HORA_FINAL;
            }

            if (fechaInicial != null && fechaFinal != null) {
                StringBuffer sb = new StringBuffer();
                sb.append(" select chca from " + Chciruganula.class.getName());
                sb.append(" chca where  (chca.hcadfechaanula BETWEEN TO_DATE(?,'dd/MM/yyyy hh24:mi') AND TO_DATE(?,'dd/MM/yyyy hh24:mi'))  ");


                parametros.add(fechaI);
                parametros.add(fechaF);


                resultList = 
                        (List<Chciruganula>) this.getHibernateTemplate().find(sb.toString(), parametros.toArray());


                if (!resultList.isEmpty()) {
                    return resultList;
                }
            }


            return null;

        } catch (HibernateException e) {
            throw new ModelException("Error consultando Otras Asesorias:" + 
                                     e.getMessage(), e);
        } catch (Exception e) {
            throw new ModelException("Error consultando Otras Asesorias:" + 
                                     e.getMessage(), e);
        }

    }


    /**
     * @param numeroContrato
     * @return
     * @throws ModelException
     */
    public String getNombreContrato(String numeroContrato) throws ModelException {
        List<String> resultList = null;
        List parametros = new ArrayList();

        try {
            if (numeroContrato != null) {
                StringBuffer sb = new StringBuffer();
                sb.append(" select cpco.ccncdescri from " + 
                          Cpcontrato.class.getName());
                sb.append(" cpco  where cpco.id.ccnnnumero = ? ");

                parametros.add(numeroContrato);


                resultList = 
                        (List<String>) this.getHibernateTemplate().find(sb.toString(), parametros.toArray());

                if (!resultList.isEmpty()) {
                    return resultList.get(0);
                }


            }


            return null;

        } catch (HibernateException e) {
            throw new ModelException("Error consultando Etapa Nota enfermeria :" + 
                                     e.getMessage(), e);
        } catch (Exception e) {
            throw new ModelException("Error consultando Etapa Nota enfermeria : " + 
                                     e.getMessage(), e);
        }

    }


        
        
    /**
     * @param wcodmed
     * @return
     * @throws ModelException
     */
    public Chsalaxprofe getSalaXProfesional(BigDecimal wcodmed, Integer wcodcli, Integer wsala) throws ModelException {
            List<Chsalaxprofe> resultList = null;
            List parametros = new ArrayList();

            try {
                if (wcodmed != null) {
                    StringBuffer sb = new StringBuffer();
                    sb.append(" select chps from " + 
                              Chsalaxprofe.class.getName());
                    sb.append(" chps  where chps.id.hspnnumero = ? and chps.id.hspnclinica = ? and  chps.id.hspnsala = ? ");

                    parametros.add(wcodmed);
                    parametros.add(wcodcli);
                    parametros.add(wsala);


                    resultList = 
                            (List<Chsalaxprofe>) this.getHibernateTemplate().find(sb.toString(), parametros.toArray());

                    if (!resultList.isEmpty()) {
                        return resultList.get(0);
                    }


                }


                return null;

            } catch (HibernateException e) {
                throw new ModelException("Error consultando profesional x sala :" + 
                                         e.getMessage(), e);
            } catch (Exception e) {
                throw new ModelException("Error consultando profesional x sala : " + 
                                         e.getMessage(), e);
            }

        }
        
        
    /**
     * @param wcodcli
     * @return
     * @throws ModelException
     */
    public String  getNombreSalaXCodigo(Integer wcodcli, Integer wsala) throws ModelException {
            List<String> resultList = null;
            List parametros = new ArrayList();

            try {
                if (wsala != null) {
                    StringBuffer sb = new StringBuffer();
                    sb.append(" select chps.hcocdescripcio from " + 
                              Chconsultori.class.getName());
                    sb.append(" chps  where chps.id.hconnumero = ? and chps.id.hconclinica = ?  ");

                    parametros.add(wsala);
                    parametros.add(wcodcli);
                   


                    resultList = 
                            (List<String>) this.getHibernateTemplate().find(sb.toString(), parametros.toArray());

                    if (!resultList.isEmpty()) {
                        return resultList.get(0);
                    }


                }


                return null;

            } catch (HibernateException e) {
                throw new ModelException("Error consultando NombreSalaXCodigo :" + 
                                         e.getMessage(), e);
            } catch (Exception e) {
                throw new ModelException("Error consultando NombreSalaXCodigo: " + 
                                         e.getMessage(), e);
            }

        }

        

        /**
         * @param wcodmed
         * @return
         * @throws ModelException
         */
        public List<Chsalaxprofe> getListaSalasXProfesional(BigDecimal wcodmed, Integer wcodcli) throws ModelException {
                List<Chsalaxprofe> resultList = null;
                List parametros = new ArrayList();

                try {
                    if (wcodmed != null) {
                        StringBuffer sb = new StringBuffer();
                        sb.append(" select chps from " + 
                                  Chsalaxprofe.class.getName());
                        sb.append(" chps  where chps.id.hspnnumero = ? and chps.id.hspnclinica = ? ");

                        parametros.add(wcodmed);
                        parametros.add(wcodcli);


                        resultList = 
                                (List<Chsalaxprofe>) this.getHibernateTemplate().find(sb.toString(), parametros.toArray());

                        if (!resultList.isEmpty()) {
                            return resultList;
                        }


                    }


                    return null;

                } catch (HibernateException e) {
                    throw new ModelException("Error consultando profesional x sala :" + 
                                             e.getMessage(), e);
                } catch (Exception e) {
                    throw new ModelException("Error consultando profesional x sala : " + 
                                             e.getMessage(), e);
                }

            }
            
            
    /**
     * @param sala
     * @throws ModelException
     */
    public void deleteSalaXProfesional(Chsalaxprofe sala) throws ModelException {
        try {
            this.getHibernateTemplate().delete(sala);
        } catch (HibernateException e) {
            throw new ModelException("Error Eliminando sala:" + e.getMessage(), 
                                     e);
        } catch (Exception e) {
            throw new ModelException("Error Eliminando sala:" + e.getMessage(), 
                                     e);
        }
    }
    
    
    /**
     * @param sala
     * @throws ModelException
     */
    public void saveSalaXProfesional(Chsalaxprofe sala) throws ModelException {
        try {
            this.getHibernateTemplate().saveOrUpdate(sala);
        } catch (HibernateException e) {
            throw new ModelException("Error Eliminando sala:" + e.getMessage(), 
                                     e);
        } catch (Exception e) {
            throw new ModelException("Error Eliminando sala:" + e.getMessage(), 
                                     e);
        }
    }



  

    private void generarRipsProcedimiento(Session session, 
                                          Chdetacirpro detalle, 
                                          String userName) {
        // Ingresamos el RIPS del procedimiento 
        Crripsserv ripsNac = null;

        Crarcproce crarcproce = null;
        Cpservicio servicio = null;
        Chusuario usuario = null;
        CrarcproceId idRips = null;
        String autorizacion = "";
        BigDecimal wvalneto = new BigDecimal(0);
        BigDecimal wvalcuota = new BigDecimal(0);

        if (detalle != null) {
            StringBuffer sb = new StringBuffer();
            sb.append(" select crap from " + 
                      Crarcproce.class.getName()).append(" crap ");
            sb.append(" where crap.id.capnconcli = :cpnnconcli ");
            sb.append(" and crap.id.capnconsec = :cpnnconsec ");
            Query query = session.createQuery(sb.toString());
            query.setParameter("cpnnconcli", 
                               detalle.getId().getHdclconsuprinc());
            query.setParameter("cpnnconsec", new Integer(0));
            crarcproce = (Crarcproce)query.uniqueResult();


            StringBuffer sb0 = new StringBuffer();
            sb0.append(" select cpse from ").append(Cpservicio.class.getName()).append(" cpse ");
            sb0.append(" WHERE cpse.csvccodigo = :codigo ");
            Query query0 = session.createQuery(sb0.toString());
            query0.setParameter("codigo", detalle.getId().getHdccservicio());
            servicio = (Cpservicio)query0.uniqueResult();

            StringBuffer sb10 = new StringBuffer();
            sb10.append(" select crri from ").append(Crripsserv.class.getName()).append(" crri ");
            sb10.append(" WHERE crri.id.crscservic = :codigoServicio and crri.id.crsngrupo = :grupoServ ");
            sb10.append(" and crri.id.crsnsubgru = :subGrupoServ and crri.crscestado = 'VG' ");
            Query query10 = session.createQuery(sb10.toString());
            query10.setParameter("codigoServicio", servicio.getCsvccodigo());
            query10.setParameter("grupoServ", servicio.getCsvngrupo().intValue());
            query10.setParameter("subGrupoServ", servicio.getCsvnsubgru().intValue());
            ripsNac = (Crripsserv)query10.uniqueResult();

            if (ripsNac == null) {
                Crripxclin rips = null;
                StringBuffer sb1 = new StringBuffer();
                sb1.append(" select crri from ").append(Crripxclin.class.getName()).append(" crri ");
                sb1.append(" WHERE crri.id.crinclinic = :clinica AND crri.id.cricservic = :codigoServicio  ");
                sb1.append("  and crri.id.cringrupo = :grupoServ and crri.id.crinsubgru = :subGrupoServ ");
                Query query1 = session.createQuery(sb1.toString());
                query1.setParameter("clinica", detalle.getHdcnclinica().intValue());
                query1.setParameter("codigoServicio", servicio.getCsvccodigo());
                query1.setParameter("grupoServ", servicio.getCsvngrupo().intValue());
                query1.setParameter("subGrupoServ", servicio.getCsvnsubgru().intValue());
                rips = (Crripxclin)query1.uniqueResult();
                
                if (rips != null) {
                    ripsNac = new Crripsserv(new CrripsservId());
                    ripsNac.setCrsnconcep(rips.getCrinconcep());
                    ripsNac.setCrsnambito(rips.getCrinambito());
                    ripsNac.setCrsnfinali(rips.getCrinfinali());
                    ripsNac.setCrscperate(rips.getCricperate());
                    ripsNac.setCrscdiagpr(rips.getCricdiagpr());
                    ripsNac.setCrscdiagre(rips.getCricdiagre());
                    ripsNac.setCrsnrealiz(rips.getCrinrealiz());
                }
            }

            StringBuffer sb2 = new StringBuffer();
            sb2.append(" select chus from ").append(Chusuario.class.getName()).append(" chus ");
            sb2.append(" WHERE chus.huslnumero = :usuario ");
            Query query2 = session.createQuery(sb2.toString());
            query2.setParameter("usuario", detalle.getHdclusuario());
            usuario = (Chusuario)query2.uniqueResult();
            
            Cnconsclin consulta;
            StringBuffer sb3 = new StringBuffer();
            sb3.append(" select cnco from ").append(Cnconsclin.class.getName()).append(" cnco ");
            sb3.append(" WHERE cnco.cconnumero = :consulta ");
            Query query3 = session.createQuery(sb3.toString());
            query3.setParameter("consulta", detalle.getId().getHdclconsuprinc());
            consulta = (Cnconsclin)query3.uniqueResult();

            if (consulta != null && consulta.getCcontipdoc() != null 
               && consulta.getCcontipdoc().getCtdnnumero().equals(IConstantes.CDOC_ADMISION)) {
                Cfadmision admision = null;
                Cfdetaadmision detadmi = null;
                List<Cfdetaadmision> lstDetadm;
                StringBuffer sb1 = new StringBuffer();
                sb1.append("select cfad from Cfadmision " + 
                            " cfad  where cfad.cannumero = :numdoc ");
                Query query1 = session.createQuery(sb1.toString());
                query1.setParameter("numdoc", consulta.getCconnumdoc());
                admision = (Cfadmision)query1.uniqueResult();

                if (admision != null && consulta.getCcocservic() != null) {
                    StringBuffer sb21 = new StringBuffer();
                    sb21.append(" select cfde from " + Cfdetaadmision.class.getName() + 
                               " cfde  where cfde.id.cdannumadm = :cdannumadm AND cfde.cdacservic = :cdacservic ");
                    Query query21 = session.createQuery(sb21.toString());
                    query21.setParameter("cdannumadm", admision.getCannumero());
                    query21.setParameter("cdacservic", consulta.getCcocservic().getCsvccodigo());
                    lstDetadm = (List<Cfdetaadmision>)query21.list();

                    if (lstDetadm != null && !lstDetadm.isEmpty()) {
                        detadmi = lstDetadm.get(0);
                    }

                    if (detadmi != null && detadmi.getCdacpaquet() != null && !detadmi.getCdacpaquet().equals("0")) {
                        StringBuffer sb11 = new StringBuffer();
                        sb11.append("select cppa.cpecserpri from " + Cppaquserv.class.getName() + " cppa  " +
                                "where cppa.id.cpecpaquet = :wpaquet AND cppa.id.cpecservic = :wservic " +
                                "AND cppa.cpecestado = 'VG' ");
                        Query query11 = session.createQuery(sb11.toString());
                        query11.setParameter("wpaquet", detadmi.getCdacpaquet());
                        query11.setParameter("wservic", consulta.getCcocservic().getCsvccodigo());
                        List<String> principal = (List<String>)query11.list();
                        if (principal != null && !principal.isEmpty() && "S".equals(principal.get(0))) {
                            StringBuffer sb20 = new StringBuffer();
                            sb20.append(" select cfde from " + Cfdetaadmision.class.getName() + 
                                      " cfde  where cfde.id.cdannumadm = :cdannumadm AND cfde.cdacservic = :wpaquete ");
                            Query query20 = session.createQuery(sb20.toString());
                            query20.setParameter("cdannumadm", admision.getCannumero());
                            query20.setParameter("wpaquete", detadmi.getCdacpaquet());
                            lstDetadm = (List<Cfdetaadmision>)query20.list();

                            if (lstDetadm != null &&  !lstDetadm.isEmpty()) {
                                detadmi = lstDetadm.get(0);
                            }
                        }
                    }

                    if (admision != null) {
                        autorizacion = admision.getCacnumrem();
                        if (autorizacion != null && autorizacion.length() > 15) {
                            autorizacion = autorizacion.substring(0,14);
                        }
                    }

                    if (detadmi != null && detadmi.getCdanvalser() != null && 
                        detadmi.getCdanvalent() != null) {
                        wvalneto = new BigDecimal(detadmi.getCdanvalser());
                        wvalcuota = wvalneto.subtract(new BigDecimal(detadmi.getCdanvalent()));
                    }
                }
            }
        }
        
        if (crarcproce == null) {
            crarcproce = new Crarcproce();
        }

        if (ripsNac != null && detalle != null && userName != null) {
            if (crarcproce.getId() == null || 
                crarcproce.getId().getCapnconcli() == null || 
                crarcproce.getId().getCapnconsec() == null) {
                idRips = new CrarcproceId();
                idRips.setCapnconcli(detalle.getId().getHdclconsuprinc().intValue());
                idRips.setCapnconsec(0);
                crarcproce.setId(idRips);
            }

            crarcproce.setCapdfecpro(new Date());
            crarcproce.setCapctipide(usuario.getHusetipoiden());
            crarcproce.setCapanumide(new BigDecimal(usuario.getHusanumeiden()));
            crarcproce.setCapnconcep(ripsNac.getCrsnconcep());
            crarcproce.setCapcautori(autorizacion);
            if (servicio.getCsvccodigo() != null)
                if (servicio.getCsvccodigo() != null && 
                    servicio.getCsvccodcups() != null && 
                    servicio.getCsvccodcups().equals("0")) {
                    crarcproce.setCapccodpro(cfcocups(servicio.getCsvccodigo()));
                } else {
                    crarcproce.setCapccodpro(cfcocups(servicio.getCsvccodcups()));
                }

            crarcproce.setCapnambito(ripsNac.getCrsnambito());
            crarcproce.setCapnfinpro(ripsNac.getCrsnfinali());
            crarcproce.setCapcperate(ripsNac.getCrscperate());
            crarcproce.setCapcdiagpr(ripsNac.getCrscdiagpr());
            crarcproce.setCapcdiagre(ripsNac.getCrscdiagre());
            crarcproce.setCapccompli(" ");
            crarcproce.setCapnrealiz(ripsNac.getCrsnrealiz());
            crarcproce.setCapavalpro(wvalneto);
            crarcproce.setCapdfecreg(new Date());
            crarcproce.setCapcusuari(userName);
            if (usuario != null && usuario.getHuslnumero() != null )
                crarcproce.setCaplusuario(new BigDecimal(detalle.getHdclusuario().intValue()));
            crarcproce.setCapnclinic(detalle.getHdcnclinica());

            session.saveOrUpdate(crarcproce);
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
    
    /**
       * 
       * @param numeroConsulta
       *
       */
      public List<Chcontroorden> getOtrasOrdenesPendientes(final Long numeroConsulta) throws ModelException {

          List<Chcontroorden> resultList = null;
          List parametros = new ArrayList();


          try {


              StringBuffer sb = new StringBuffer();
              sb.append(" select chco from " + Chcontroorden.class.getName() + 
                        " chco  where chco.id.hcolnumero = ?  and chco.hcocetapa = 'RG' and chco.hcocestado = 'VG' ");
              parametros.add(numeroConsulta);


              resultList = 
                      (List<Chcontroorden>) this.getHibernateTemplate().find(sb.toString(), parametros.toArray());


              if (!resultList.isEmpty()) {
                  return resultList;
              }


              return null;

          } catch (HibernateException e) {
              throw new ModelException("Error consultando Servicio en programacion:" + 
                                       e.getMessage(), e);
          } catch (Exception e) {
              throw new ModelException("Error consultando Servicio en programacion:" + 
                                       e.getMessage(), e);
          }

      }
      
          
          
       /**
       * 
       * @param numeroConsulta
       *
       */
      public List<Chcontroorden> getOtrasOrdenesPendientesRealizadas(final Long numeroConsulta) throws ModelException {

          List<Chcontroorden> resultList = null;
          List parametros = new ArrayList();


          try {


              StringBuffer sb = new StringBuffer();
              sb.append(" select chco from " + Chcontroorden.class.getName() + 
                        " chco  where chco.id.hcolnumero = ?  and chco.hcocetapa = 'AD'  and chco.hcocestado = 'VG' ");
              parametros.add(numeroConsulta);


              resultList = 
                      (List<Chcontroorden>) this.getHibernateTemplate().find(sb.toString(), parametros.toArray());


              if (!resultList.isEmpty()) {
                  return resultList;
              }


              return null;

          } catch (HibernateException e) {
              throw new ModelException("Error consultando Servicio en programacion:" + 
                                       e.getMessage(), e);
          } catch (Exception e) {
              throw new ModelException("Error consultando Servicio en programacion:" + 
                                       e.getMessage(), e);
          }

      }

    /**
     *
     * @param numeroConsulta
     *  
     */
    public List<Chcontroorden> getOtrasOrdenesPorEvolucion(final Long numeroConsulta, final Long evolucion) throws ModelException {

        List<Chcontroorden> resultList = null;
        List parametros = new ArrayList();


        try {


            StringBuffer sb = new StringBuffer();
            sb.append(" select chco from " + Chcontroorden.class.getName() + 
                      " chco  where chco.id.hcolnumero = ?  and chco.hconevoluconse = ? ");
            parametros.add(numeroConsulta);
            parametros.add(evolucion);

            resultList = 
                    (List<Chcontroorden>) this.getHibernateTemplate().find(sb.toString(), parametros.toArray());


            if (!resultList.isEmpty()) {
                return resultList;
            }


            return null;

        } catch (HibernateException e) {
            throw new ModelException("Error consultando Servicio en programacion:" + 
                                     e.getMessage(), e);
        } catch (Exception e) {
            throw new ModelException("Error consultando Servicio en programacion:" + 
                                     e.getMessage(), e);
        }

    }

    /**
     * @param usuario
     * @return
     * @throws ModelException
     */
    public List<Chcirugprogr> getCirugiasPendientes(final Chusuario usuario) throws ModelException {
        List<Chcirugprogr> pis = 
            (List<Chcirugprogr>)getHibernateTemplate().execute(new HibernateCallback() {
                    public Object doInHibernate(Session session) throws HibernateException {

                       StringBuffer sb = new StringBuffer();
                        sb.append("select chcp from ");
                        sb.append(Chcirugprogr.class.getName()).append(" chcp ");
                        sb.append("WHERE chcp.hcpcestado = 'VG' ");
                        sb.append("  and chcp.hcpcetapa in('IE','ES','PQ','EQ','ER') ");
                       
                        if (usuario.getHusetipoiden() != null && 
                            !usuario.getHusetipoiden().equals("")) {
                            sb.append(" AND chcp.hcplusuario.husetipoiden =  ").append("'" + 
                                                                                       usuario.getHusetipoiden() + "'");
                        }

                        if (usuario.getHusanumeiden() != null && 
                            !usuario.getHusanumeiden().equals("")) {
                            sb.append(" and chcp.hcplusuario.husanumeiden =   ").append(usuario.getHusanumeiden());
                        }

                        if (usuario.getHuscprimernomb() != null && 
                            !usuario.getHuscprimernomb().equals("")) {
                            sb.append(" and chcp.hcplusuario.huscprimernomb like   ").append("'%" + 
                                                                                             usuario.getHuscprimernomb().toUpperCase() + 
                                                                                             "%'");
                        }

                        if (usuario.getHuscsegundnomb() != null && 
                            !usuario.getHuscsegundnomb().equals("")) {
                            sb.append(" and chcp.hcplusuario.huscsegundnomb like   ").append("'%" + 
                                                                                             usuario.getHuscsegundnomb().toUpperCase() + 
                                                                                             "%'");
                        }

                        if (usuario.getHuscprimerapel() != null && 
                            !usuario.getHuscprimerapel().equals("")) {
                            sb.append(" and chcp.hcplusuario.huscprimerapel like   ").append("'%" + 
                                                                                             usuario.getHuscprimerapel().toUpperCase() + 
                                                                                             "%'");
                        }

                        if (usuario.getHuscsegundapel() != null && 
                            !usuario.getHuscsegundapel().equals("")) {
                            sb.append(" and chcp.hcplusuario.huscsegundapel like   ").append("'%" + 
                                                                                             usuario.getHuscsegundapel().toUpperCase() + 
                                                                                             "%'");
                        }
                        sb.append(" order by chcp.hcpdfechacirug DESC");

                        String hql = sb.toString();

                        Query query = session.createQuery(hql);
                        List<Chcirugprogr> pis;
                        List<Chcirugprogr> pis2;
                        pis = query.list();

                        pis2 = new ArrayList<Chcirugprogr>();

                        for (Chcirugprogr co: pis) {
                            String nombreServicio = "";
                            String servicio1 = "";
                            String servicio2 = "";

                            Chusuario usuario = co.getHcplusuario();
                            Hibernate.initialize(usuario);

                            Set chdetacirpros = co.getChdetacirpros();
                            Hibernate.initialize(chdetacirpros);
                            StringBuffer sb1 = new StringBuffer();
                            sb1.append(" select chdc.hdccservicio || ' ' || (cpse.csvcnombre) "); 
                            sb1.append(" from Historia.Chdetacirpro chdc, Clinico.cpservicio cpse ");
                            sb1.append(" where cpse.csvccodigo = chdc.hdccservicio AND  chdc.hdclconsuprinc = :numeroConsulta  ");
                            Query query1 = 
                                session.createQuery(sb1.toString());
                            query1.setParameter("numeroConsulta", 
                                                co.getHcplnumero());

                            List pis3;
                            pis3 = new ArrayList();

                            pis3 = query1.list();

                            if (pis3.size() == 1) {
                                for (int x = 0; x < pis3.size(); x++) {
                                    servicio1 = (String)pis3.get(x);
                                    nombreServicio = servicio1;
                                }
                            } else {
                                for (int x = 0; x < pis3.size(); x++) {
                                    servicio2 = servicio2 + " - " + (String)pis3.get(x);
                                    nombreServicio = servicio2;
                                }
                            }

                            co.setNombreServicio(nombreServicio);

                            pis2.add(co);

                            }
                            return pis2;
                    }
                });
        return pis;
    }

    /**
     * @param numeroConsulta
     * @param consecutivoEvolucion
     * @return
     * @throws ModelException
     */
    public List<Chformulahos> getFormulaMedicamentosEvolucion(Long numeroConsulta, 
                                                            Integer consecutivo) throws ModelException {
        List<Chformulahos> resultList = null;
        List parametros = new ArrayList<Chformulahos>();

        try {
            if (numeroConsulta != null && consecutivo != null) {
                StringBuffer sb = new StringBuffer();
                sb.append(" select chfh from " + Chformulahos.class.getName() + 
                          " chfh  where chfh.id.hfhlconsulta = ? and chfh.id.hfhnevoluconse = ? ");
                parametros.add(numeroConsulta);
                parametros.add(consecutivo);

                resultList = 
                      (List<Chformulahos>) this.getHibernateTemplate().find(sb.toString(), parametros.toArray());

                if (!resultList.isEmpty()) {
                    return resultList;
                }
            }
            return null;
        } catch (HibernateException e) {
            throw new ModelException("Error consultando Formula Medicamentos :" + 
                                     e.getMessage(), e);
        } catch (Exception e) {
            throw new ModelException("Error consultando Formula Medicamentos : " + 
                                     e.getMessage(), e);
        }

    }

    /**
     * @param numeroConsulta
     * @param consecutivoEvolucion
     * @return
     * @throws ModelException
     */
    public List<Chformulahos> getSuspendeMedicamentosEvolucion(Long numeroConsulta, 
                                                            Integer consecutivo) throws ModelException {
        List<Chformulahos> resultList = null;
        List parametros = new ArrayList<Chformulahos>();

        try {
            if (numeroConsulta != null && consecutivo != null) {
                StringBuffer sb = new StringBuffer();
                sb.append(" select chfh from " + Chformulahos.class.getName() + 
                          " chfh  where chfh.id.hfhlconsulta = ? and chfh.hfhnevolususp = ? ");
                parametros.add(numeroConsulta);
                parametros.add(consecutivo);

                resultList = 
                      (List<Chformulahos>) this.getHibernateTemplate().find(sb.toString(), parametros.toArray());

                if (!resultList.isEmpty()) {
                    return resultList;
                }
            }
            return null;
        } catch (HibernateException e) {
            throw new ModelException("Error consultando Suspende Medicamentos :" + 
                                     e.getMessage(), e);
        } catch (Exception e) {
            throw new ModelException("Error consultando Suspende Medicamentos : " + 
                                     e.getMessage(), e);
        }

    }
    
    /**
     * @param numero
     * @return
     * @throws ModelException
     */
    public List<Chnotaenferm> getNotasEnfermeriaIngresoProcedimientos(Long numero) throws ModelException {
        List<Chnotaenferm> resultList = null;
        List parametros = new ArrayList<Chnotaenferm>();

        try {

            StringBuffer sb = new StringBuffer();
            sb.append(" select chne from " + Chnotaenferm.class.getName() + 
                      " chne  where chne.id.hnelnumero = ? AND chne.id.hnectiposervi = ? order by chne.id.hnelconsecutiv ");
            parametros.add(numero);
            parametros.add(IConstantes.TIPO_PROCEDIMIENTO);


            resultList = 
                    (List<Chnotaenferm>) this.getHibernateTemplate().find(sb.toString(), parametros.toArray());

            if (!resultList.isEmpty()) {
                return resultList;
            }

            return null;

        } catch (HibernateException e) {
            throw new ModelException("Error consultando nota enfermeria:" + 
                                     e.getMessage(), e);
        } catch (Exception e) {
            throw new ModelException("Error consultando nota enfermeria: " + 
                                     e.getMessage(), e);
        }

    }
    
    
    
    /**
     * @param numero
     * @return
     * @throws ModelException
     */
    public List<Chcontroorden> getNotasEnfermeriaOxigenoSuministrado(Long numero) throws ModelException {
        List<Chcontroorden> resultList = null;
        List parametros = new ArrayList<Chcontroorden>();

        try {

            StringBuffer sb = new StringBuffer();
            sb.append(" select o from " + Chcontroorden.class.getName() + 
                      " o  where o.id.hcolnumero = ? order by o.id.hcolnumero ");
            parametros.add(numero);
            resultList = 
                    (List<Chcontroorden>) this.getHibernateTemplate().find(sb.toString(), parametros.toArray());

            if (!resultList.isEmpty()) {
                return resultList;
            }

            return null;

        } catch (HibernateException e) {
            throw new ModelException("Error consultando nota enfermeria oxigeno:" + 
                                     e.getMessage(), e);
        } catch (Exception e) {
            throw new ModelException("Error consultando nota enfermeria oxigeno: " + 
                                     e.getMessage(), e);
        }

    }
    
    public List<Chconsulta> getSolicitudFoliosNotaAclaratoria(final Long numeroUsuario, 
                                                            final String userName) throws ModelException {
        List<Chconsulta> pis = 
            (List<Chconsulta>)getHibernateTemplate().execute(new HibernateCallback() {
                    public Object doInHibernate(Session session) throws HibernateException {

                        String HORA_INICIAL = " 00:00";
                        String HORA_FINAL = " 23:59";
                        String fechaI = null;
                        String fechaF = null;

                        int diferenciaEnDias = 1;
                        Date fechaActual = Calendar.getInstance().getTime();
                        long tiempoActual = fechaActual.getTime();
                        long unDia = diferenciaEnDias * 24 * 60 * 60 * 1000;
                        Date fechaAyer = new Date(tiempoActual - unDia);

                        Date fechaFinal = new Date();


                        if (fechaAyer != null && fechaFinal != null) {
                            SimpleDateFormat dateFormat = 
                                new SimpleDateFormat("dd/MM/yyyy");

                            fechaI = 
                                    dateFormat.format(fechaAyer) + HORA_INICIAL;

                            fechaF = 
                                    dateFormat.format(fechaFinal) + HORA_FINAL;

                        }

                        StringBuffer sb = new StringBuffer();
                        sb.append("select chco from ");
                        sb.append(Chconsulta.class.getName()).append(" chco ");
                        sb.append("WHERE chco.hcolusuario.huslnumero = :numeroUsuario ");
                        sb.append(" AND chco.hcoeetapa = 'CE' ");
                        sb.append(" AND chco.hcocservicio.csvntiphis  not in (:wtiphistoma, :wtiphislectura, :wtiphiscero ) ");
                 //       sb.append(" AND (chco.hcodfeccierre BETWEEN TO_DATE(:fechaI,'dd/MM/yyyy hh24:mi') AND TO_DATE(:fechaF,'dd/MM/yyyy hh24:mi'))");
                        sb.append(" order by  chco.hcodfecregistr desc ");


                        String hql = sb.toString();

                        Query query = session.createQuery(hql);
                        query.setParameter("numeroUsuario", numeroUsuario);
                        query.setParameter("wtiphistoma", 
                                           IConstantes.HISTORIA_PROCEDIMIENTO_CITOLOGIA_TOMA);
                        query.setParameter("wtiphislectura",                                IConstantes.HISTORIA_PROCEDIMIENTO_CITOLOGIA_LECTURA);
                                           
                        query.setParameter("wtiphiscero", 
                                           IConstantes.HISTORIA_TODAS);

                        //query.setParameter("fechaI", fechaI);
                       // query.setParameter("fechaF", fechaF);
                        List<Chconsulta> pis;
                        pis = query.list();

                        for (Chconsulta co: pis) {
                            Cpservicio servicio = co.getHcocservicio();
                            Hibernate.initialize(servicio);

                            Chusuario usu = co.getHcolusuario();
                            Hibernate.initialize(usu);


                        }

                        return pis;
                    }
                });
        return pis;
    }
    

    
    /**
     * @param autoriza
     * @throws ModelException
     */
    public void saveAutorizacionNotaAclaratoria(final Chautornota autoriza) throws ModelException {

        try {
            this.getHibernateTemplate().execute(new HibernateCallback() {
                        public Object doInHibernate(Session session) {
                            Integer consecutivo = null;
                            if (autoriza != null) {
                              



                                session.saveOrUpdate(autoriza);
                            }


                            return autoriza;
                        }
                    });
        } catch (HibernateException e) {
            throw new ModelException("Error Insertando Autorizacion Descripcion:" + 
                                     e.getMessage(), e);
        } catch (Exception e) {
            throw new ModelException("Error Insertando Autorizacion Descripcion:" + 
                                     e.getMessage(), e);
        }
    }
    
    
    
    /**
     * @return
     * @throws ModelException
     */
    public Chautornota getAutorizacionNotaAclaratoria(final Chautornota autorizacion) throws ModelException {
        List<Chautornota> resultList = null;
        List parametros = new ArrayList();
        try {
            if (autorizacion != null) {
                StringBuffer sb = new StringBuffer();
                sb.append(" select chan from " + Chautornota.class.getName());
                sb.append(" chan  where chan.hannnumerconsu  = ? ");
                sb.append(" and chan.hancaceptsolic is null ");

                parametros.add(autorizacion.getHannnumerconsu());
         


                resultList = 
                        (List<Chautornota>) this.getHibernateTemplate().find(sb.toString(), parametros.toArray());


                if (!resultList.isEmpty()) {
                    return resultList.get(0);
                }

            }


            return null;

        } catch (HibernateException e) {
            throw new ModelException("Error consultando Autorizacion Nota Aclratoria:" + 
                                     e.getMessage(), e);
        } catch (Exception e) {
            throw new ModelException("Error consultando Autorizacion Nota Aclaratoria :" + 
                                     e.getMessage(), e);
        }

    }
    
    

        /**
         * @return
         * @throws ModelException
         */
        public List<Chautornota> getSolicitudesNotaAclaratoriaPorAprobar() throws ModelException {
            List<Chautornota> resultList = null;
            List parametros = new ArrayList();

            try {

                StringBuffer sb = new StringBuffer();
                sb.append(" select chan from " + Chautornota.class.getName() + 
                          " chan  where  chan.hancaceptsolic is null   ");
            

                resultList = 
                        (List<Chautornota>) this.getHibernateTemplate().find(sb.toString(), parametros.toArray());


                if (!resultList.isEmpty()) {
                    return resultList;
                }


                return null;

            } catch (HibernateException e) {
                throw new ModelException("Error consultando Solicitudes Por Aprobar:" + 
                                         e.getMessage(), e);
            } catch (Exception e) {
                throw new ModelException("Error consultando Solicitudes Por Aprobar:" + 
                                         e.getMessage(), e);
            }

        }
        
        
    /**
     * @param autoriza
     * @param userName
     * @throws ModelException
     */
    public void aprobarAutorizacionNotaAclratoria(final Chautornota autoriza,  final String userName) throws ModelException {

        try {
            this.getHibernateTemplate().execute(new HibernateCallback() {
                        public Object doInHibernate(Session session) {
                            if (autoriza != null) {

                                session.saveOrUpdate(autoriza);
                            }


                            return autoriza;
                        }
                    });
        } catch (HibernateException e) {
            throw new ModelException("Error Autorizando Nota Aclaratoria:" + 
                                     e.getMessage(), e);
        } catch (Exception e) {
            throw new ModelException("Error Autorizando Nota Aclaratoria:" + 
                                     e.getMessage(), e);
        }
    }
    
    
    private void generarHonorariosProfesional(Session session, 
                                              Cnconsclin consulta, 
                                              String userName,String codigoProfesional ) {
        // Ingresamos los honorarios del profesional 

        Cnprofxcon honorarios = null;
        Cptarxprof tarifas = null;
        Cpcontrato contrato = null;
        Integer wswcont = null;
        BigDecimal wtarpar = null;
        BigDecimal wtarcre = null;

        Cpprofesio profesional = null;
        String wregnod = null;
        BigDecimal wvalpag = null;
        BigDecimal wvalser = null;
        wvalpag = new BigDecimal("0");


        if (consulta != null && userName != null && 
            consulta.getCconclinic()!= null) {
            StringBuffer sb4 = new StringBuffer();
            if (codigoProfesional == null) {
                sb4.append(" select cppr from " + Cpprofesio.class.getName() + 
                           " cppr  where cppr.id.cpfnclinic = :cpfnclinic " + 
                           " and cppr.id.cpfncodigo = (select cppu.curnprofes from Cpusuario cppu where cppu.curcusuari = :curcusuari ) ");
                Query query4 = session.createQuery(sb4.toString());
                query4.setParameter("cpfnclinic", 
                                   consulta.getCconclinic());
                query4.setParameter("curcusuari", userName);

                profesional = (Cpprofesio)query4.uniqueResult();

            } else {
                sb4.append(" select cppr from " + Cpprofesio.class.getName() + 
                           " cppr  where cppr.id.cpfnclinic = :cpfnclinic " + 
                           " and cppr.id.cpfncodigo = :cpfncodigo ");
                Query query4 = session.createQuery(sb4.toString());
                query4.setParameter("cpfnclinic", 
                                    consulta.getCconclinic());
                query4.setParameter("cpfncodigo", codigoProfesional);

                profesional = (Cpprofesio)query4.uniqueResult();

            }

        }

        if (consulta != null && profesional != null) {

            StringBuffer sb5 = new StringBuffer();
            sb5.append(" select cnpc from " + Cnprofxcon.class.getName() + 
                       " cnpc  where cnpc.id.cpnnconcli = :cpnnconcli AND cnpc.id.cpnnprofes = :cpnnprofes  ");
            Query query5 = session.createQuery(sb5.toString());
            query5.setParameter("cpnnconcli", consulta.getCconnumero());
            query5.setParameter("cpnnprofes", 
                                profesional.getId().getCpfncodigo());

            honorarios = (Cnprofxcon)query5.uniqueResult();

        }


        if (consulta != null && profesional != null && 
            profesional.getId() != null && consulta != null && 
            consulta.getCcocservic() != null) {

            StringBuffer sb6 = new StringBuffer();
            sb6.append(" SELECT cpta from " + Cptarxprof.class.getName() + 
                       " cpta  WHERE cpta.id.ctanclinic = :ctanclinic ");
            sb6.append(" AND cpta.id.ctanprofes = :ctanprofes  ");
            sb6.append(" AND cpta.id.ctacservic = :ctacservic  ");
            Query query6 = session.createQuery(sb6.toString());
            query6.setParameter("ctanclinic", consulta.getCconclinic());
            query6.setParameter("ctanprofes", 
                                profesional.getId().getCpfncodigo());
            query6.setParameter("ctacservic", 
                                consulta.getCcocservic().getCsvccodigo());
            tarifas = (Cptarxprof)query6.uniqueResult();
        }


        if (consulta != null) {

            List lstConsulta;
            StringBuffer sb7 = new StringBuffer();
            sb7.append(" SELECT cpco from " + 
                       Cpcontrato.class.getName()).append(" cpco  ");
            sb7.append(" WHERE cpco.id.ccnnnumero = :ccnnnumero  ");
            sb7.append(" AND cpco.id.ccnnclinic = :ccnnclinic  ");
            Query query7 = session.createQuery(sb7.toString());
            query7.setParameter("ccnnnumero", consulta.getCconcontra());
            query7.setParameter("ccnnclinic", consulta.getCconclinic());
            lstConsulta = query7.list();

            if (lstConsulta != null && !lstConsulta.isEmpty()) {
                contrato = (Cpcontrato)lstConsulta.get(0);
            }
        }

        if (tarifas != null && contrato != null) {
            wswcont = contrato.getCcnnswcont();
            wtarpar = tarifas.getCtaatarpar();
            wtarcre = tarifas.getCtaatarcre();
            wvalser = consulta.getCcoavalser();
            if (wswcont == 0 || contrato.getId().getCcnnnumero().intValue() == 1000) {
                wvalpag = (wtarpar);
            } else {
                wvalpag = (wtarcre);
            }

            if (wvalpag != null && wvalpag.floatValue() < 1) {
                if (wvalser != null) {
                    wvalpag = wvalser.multiply(wvalpag);
                }

            }

        }

        if (honorarios == null) {
            honorarios = new Cnprofxcon();
        }
        Cptipocont tipocon;

        tipocon = null;
        boolean wok_funcion;
        wok_funcion = true;

        if (profesional != null) {
            wregnod = 
                    cfpagnod(session, profesional.getCpfnclinic(), profesional.getCpfncodigo(), 
                             consulta.getCcocservic().getCsvccodigo());
        }


        honorarios.setCpnnconcli(consulta.getCconnumero());
        if (profesional != null && profesional.getId() != null) {
            honorarios.setCpnnprofes(profesional.getId().getCpfncodigo());


            honorarios.setCpncregnod(wregnod);
            honorarios.setCpncmodnod(" ");
            honorarios.setCpnccalnod(" ");
            honorarios.setCpnctomnod(wregnod);
            honorarios.setCpncpagada("N");
            honorarios.setCpnavalpag(wvalpag);
            honorarios.setCpndfeccon(consulta.getCcodfeccon());
            honorarios.setCpndfecreg(new Date());
            honorarios.setCpndfecmod(null);
            honorarios.setCpndfeccal(null);
            honorarios.setCpncusureg(userName);
            honorarios.setCpncusumod(null);
            honorarios.setCpncusucal(null);
            honorarios.setCpnnclinic(consulta.getCconclinic());
            honorarios.setCpncestado(IConstantes.ESTADO_VIGENTE);
            session.saveOrUpdate(honorarios);

        }


    }
    
    
    private String cfpagnod(Session session, Integer wclipro, 
                            BigDecimal wcodpro, String wcodser) {


        /** Variable object. */
        boolean wok_funcion;
        wok_funcion = true;
        String wpagnom = null;
        String wconnom = null;
        String wdestaj = null;
        String wsumcuo = null;

        List resultList = null;
        Cptipocont tipocon = null;

        StringBuffer sb6 = new StringBuffer();
        sb6.append(" select cpti  from " + 
                   Cpprofesio.class.getName()).append(" cppr, ");
        sb6.append(Cptipocont.class.getName()).append(" cpti ");
        sb6.append(" where cpti.ctcnnumero = cppr.cpfntipcon ");
        sb6.append(" AND cppr.id.cpfnclinic = :cpfnclinic ");
        sb6.append(" AND cppr.id.cpfncodigo = :cpfncodigo ");
        Query query6 = session.createQuery(sb6.toString());
        query6.setParameter("cpfnclinic", wclipro);
        query6.setParameter("cpfncodigo", wcodpro);
        resultList = query6.list();


        if (!resultList.isEmpty()) {
            tipocon = (Cptipocont)resultList.get(0);
        } else {
            wok_funcion = false;
        }

        if (tipocon != null) {
            wpagnom = tipocon.getCtccpagnom();
            wconnom = tipocon.getCtccconnom();
            wdestaj = tipocon.getCtccdestaj();
        }


        if (wok_funcion) {
            if (wpagnom != null && wpagnom.equals("N")) {
                return ("D");
            }
            if (wdestaj != null && wdestaj.equals("N")) {
                return ("N");
            }
            if (wconnom != null && wconnom.equals("N")) {
                return ("D");
            }

            List resultList2 = null;

            StringBuffer sb7 = new StringBuffer();
            sb7.append("select cpti.ctlcsumcuo  from " + 
                       Cpservicio.class.getName()).append(" cpse, ");
            sb7.append(Cptipconcl.class.getName()).append(" cpti ");
            sb7.append(" where  cpti.ctlncodigo = cpse.csvntipcon ");
            sb7.append(" AND  cpse.csvccodigo = :csvccodigo ");
            Query query7 = session.createQuery(sb7.toString());

            query7.setParameter("csvccodigo", wcodser);
            resultList2 = query7.list();

            if (!resultList2.isEmpty()) {
                wsumcuo = (String)resultList2.get(0);
                if (wsumcuo != null && wsumcuo.equals("S")) {
                    return ("N");
                } else {
                    //TODO: TEMPORAL
                    if (wcodser != null && wcodser.equals("898001.0") && 
                        wcodser.equals("S898001.0") && wclipro != null) {
                        if (wclipro.equals(1) || wclipro.equals(2) || 
                            wclipro.equals(6)) {
                            return ("N");
                        }
                    }
                    return ("D");
                }
            } else {
                wok_funcion = false;
            }

        }
        return ("O");
    }




        public void actualizarMinutosSignosVitales(final Long numeroCirugia, final long numeroMinutos) throws ModelException {
            try {
                this.getHibernateTemplate().execute(new HibernateCallback() {
                            public Object doInHibernate(Session session) {

                            
                               if (numeroCirugia != null) {
                                        
                                        
                                        StringBuffer sb2 = new StringBuffer();
                                        sb2.append(" update historia.Chsignovital set hsvdfechaactiv = hsvdfechaactiv + (:numeroMinutos/1440)  " + 
                                                  "   where hsvlconsulta = :numeroCirugia ");
                                        Query query2 = 
                                            session.createQuery(sb2.toString());

                                         query2.setParameter("numeroMinutos", numeroMinutos);
                                        query2.setParameter("numeroCirugia", numeroCirugia);
                                         
                                        query2.executeUpdate();

                                     }
                            
                           
                             
                                return numeroCirugia;
                            }
                        });
            } catch (HibernateException e) {
                throw new ModelException("Error Insertando :" + e.getMessage(), e);
            } catch (Exception e) {
                throw new ModelException("Error Insertando :" + e.getMessage(), e);
            }
        }
        
        
        
        
    /**
     * @param numeroConsulta
     * @return
     * @throws ModelException
     */
    public List<Chotraorden> getOtrasOrdenesCE(Long numeroConsulta) throws ModelException {
        List<Chotraorden> resultList = null;
        List parametros = new ArrayList();
        try {
            if (numeroConsulta != null) {
                StringBuffer sb = new StringBuffer();
                sb.append(" select choo from " + 
                          Chotraorden.class.getName());
                sb.append(" choo where choo.id.hoolnumero = ? ");
                parametros.add(numeroConsulta);


                resultList = 
                        (List<Chotraorden>) this.getHibernateTemplate().find(sb.toString(), parametros.toArray());

                if (!resultList.isEmpty()) {
                    return resultList;

                }

            }
            return null;
        } catch (HibernateException e) {
            throw new ModelException("Error consultando Otras Ordenes Cirugia " + 
                                     e.getMessage(), e);
        } catch (Exception e) {
            throw new ModelException("Error consultando Otras Ordenes Cirugia" + 
                                     e.getMessage(), e);
        }
    }
 

    /**
     * @param otrasOrdenes
     * @param numeroConsulta
     * @throws ModelException
     */
    public void saveOtrasOrdenesCE(final List<Chotraorden> otrasOrdenes, 
                                 final Long numeroConsulta, 
                                 final String usuario, 
                                 final List<Chotraorden> ordenesSuspender) throws ModelException {
        try {
            this.getHibernateTemplate().execute(new HibernateCallback() {
                        public Object doInHibernate(Session session) {

                            if (numeroConsulta != null) {

                                if (ordenesSuspender != null && 
                                    !ordenesSuspender.isEmpty()) {
                                    for (Chotraorden forsup: 
                                         ordenesSuspender) {
                                        forsup.setHoocetapa(IConstantes.ETAPA_SUSPENDER);
                                        forsup.setHoocestado(IConstantes.ESTADO_ANULADO);
                                        forsup.setHoodfechamodif(new Date());
                                        session.update(forsup);
                                    }
                                }

                                /* StringBuffer sb = new StringBuffer();

                                sb.append(" delete  historia.Chotraorden ");
                                sb.append(" where hpglconsulta = :numeroConsulta ");
                                sb.append("  ");
                                Query query =
                                    session.createQuery(sb.toString());
                                query.setParameter("numeroConsulta",
                                                   numeroConsulta);
                                query.executeUpdate();*/
                                Integer consecutivo = null;
                                BigDecimal secuenciaActual = 
                                    (BigDecimal)session.createQuery("SELECT max(chco.hoonconsecutiv) FROM HISTORIA.Chotraorden chco where chco.hoolnumero = " + 
                                                                       numeroConsulta).uniqueResult();


                                if (secuenciaActual != null) {
                                    consecutivo = 
                                            secuenciaActual.intValue() + 1;
                                } else {
                                    consecutivo = 1;
                                }


                                if (otrasOrdenes != null && 
                                    !otrasOrdenes.isEmpty()) {
                                    Chotraorden otrasOrdeness;
                                    int i = 0;
                                    Iterator it = otrasOrdenes.iterator();
                                    while (it.hasNext()) {
                                        it.next();

                                        Chotraorden ordenObject = 
                                            new Chotraorden();
                                        otrasOrdeness = otrasOrdenes.get(i);
                                        ordenObject.getId().setHoolnumero(numeroConsulta);
                                        ordenObject.getId().setHoonconsecutiv(consecutivo);
                                        ordenObject.setHoocnombreord(otrasOrdeness.getHoocnombreord());
                                        ordenObject.setHoocordenenvi(otrasOrdeness.getHoocordenenvi());
                                        ordenObject.setHoodfechaasig(new Date());
                                        ordenObject.setHoocoperaasig(usuario);
                                        ordenObject.setHoocestado(IConstantes.ESTADO_VIGENTE);
                                        ordenObject.setHoocetapa(IConstantes.ETAPA_REGISTRO);
                                        ordenObject.setHoonevoluconse(otrasOrdeness.getHoonevoluconse());
                                        ordenObject.setHoocsistoxige(otrasOrdeness.getHoocnombreord());
                                        if(otrasOrdeness.getHoocnombreord().equals("OX")){
                                            ordenObject.setHooccantlitros(otrasOrdeness.getHooccantlitros());
                                            ordenObject.setHooccantminutos(new Long(otrasOrdeness.getHooccantminutos().toString()));
                                            ordenObject.setHooccduracion(otrasOrdeness.getHooccduracion());
                                            ordenObject.setHooccadminisoxig(otrasOrdeness.getHooccadminisoxig());
                                            ordenObject.setHoocdfechadminis(new Date());
                                            ordenObject.setHooccadminoxigdesc(otrasOrdeness.getHooccadminoxigdesc());
                                            ordenObject.setHooccestadoadminox(otrasOrdeness.getHooccestadoadminox());
                                        }
                                       
                                        consecutivo++;
                                        i++;
                                        session.saveOrUpdate(ordenObject);
                                    }
                                }


                            }

                            return otrasOrdenes;
                        }
                    });
        } catch (HibernateException e) {
            throw new ModelException("Error Insertando :" + e.getMessage(), e);
        } catch (Exception e) {
            throw new ModelException("Error Insertando :" + e.getMessage(), e);
        }
    }
    
    /**
     * @param numero
     * @return
     * @throws ModelException
     */
    public List<Chescvalcai> getEscalaValoracionCaidas(Long numero) throws ModelException {
        List<Chescvalcai> resultList = null;
        List parametros = new ArrayList<Chescvalcai>();

        try {

            StringBuffer sb = new StringBuffer();
            sb.append(" select chesc from " + Chescvalcai.class.getName() + 
                      " chesc  where chesc.comp_id.hevclconsulta = ? order by chesc.comp_id.hevcnconsecuti ");
            parametros.add(numero);

            resultList = 
                    (List<Chescvalcai>) this.getHibernateTemplate().find(sb.toString(), parametros.toArray());

            if (!resultList.isEmpty()) {
                return resultList;
            }

            return null;

        } catch (HibernateException e) {
            throw new ModelException("Error consultando Escala de Valoracion Caidas:" + 
                                     e.getMessage(), e);
        } catch (Exception e) {
            throw new ModelException("Error consultando Escala de Valoracion Caidas: " + 
                                     e.getMessage(), e);
        }

    }
    
    /**
     * @param List<Chescvalcai>
     * @throws ModelException
     */
    public void saveEscalaValoracionCaidas(final List<Chescvalcai> escala) throws ModelException {
        try {
            this.getHibernateTemplate().execute(new HibernateCallback() {
                        public Object doInHibernate(Session session) {
                            if (escala != null && !escala.isEmpty()) {
                                for (Chescvalcai esc: escala) {
                                    if (esc.isEditable()) {
                                        session.saveOrUpdate(esc);
                                    }
                                }
                            }
                            return escala;
                        }
                    });
        } catch (HibernateException e) {
            throw new ModelException("Error Insertando Escala de Valoracion Caidas: " + 
                                     e.getMessage(), e);
        } catch (Exception e) {
            throw new ModelException("Error Insertando Escala de Valoracion Caidas: " + 
                                     e.getMessage(), e);
        }
    }
    
    /**
     * @param numeroUsuario
     * @param numeroCirugia
     * @return
     * @throws ModelException
     */
    public List<Chcontroorden> getLstOtrasOrdenesConsultaExterna(Long numeroUsuario, 
                                                                      Long numeroCirugia) throws ModelException {
           List<Chcontroorden> resultList = null;
        List parametros = new ArrayList();
        try {
            if (numeroCirugia != null && numeroUsuario != null) {
                StringBuffer sb = new StringBuffer();
                sb.append(" select chot from " + Chcontroorden.class.getName());
                sb.append(" chot  where chot.id.hcolnumero != ?  AND chot.hcocestado = ? and  chot.hcolusuario = ? ");

                parametros.add(numeroCirugia);
                parametros.add(IConstantes.ESTADO_VIGENTE);
                parametros.add(numeroUsuario);

                resultList = 
                        (List<Chcontroorden>) this.getHibernateTemplate().find(sb.toString(), parametros.toArray());
            }
            if (resultList != null && !resultList.isEmpty()) {
                return resultList;
            }

            return null;

        } catch (HibernateException e) {
            throw new ModelException("Error consultando Otras Ordenes Consulta Externa:" + 
                                     e.getMessage(), e);
        } catch (Exception e) {
            throw new ModelException("Error consultando Liquidos Formulados:" + 
                                     e.getMessage(), e);
        }

    }
    
    /**
       * 
       * @param numeroConsulta
       * @param numeroUsuario
       *
       */
      public List<Chcontroorden> getOtrasOrdenesPendientesCE(final Long numeroConsulta,final Long numeroUsuario) throws ModelException {

          List<Chcontroorden> resultList = null;
          List parametros = new ArrayList();


          try {


              StringBuffer sb = new StringBuffer();
              sb.append(" select chco from " + Chcontroorden.class.getName() + 
                        " chco  where chco.id.hcolnumero != ?  and chco.hcocetapa = 'RG' and chco.hcocestado = 'VG' and  chco.hcolusuario = ? ");
              parametros.add(numeroConsulta);
              parametros.add(numeroUsuario);


              resultList = 
                      (List<Chcontroorden>) this.getHibernateTemplate().find(sb.toString(), parametros.toArray());


              if (!resultList.isEmpty()) {
                  return resultList;
              }


              return null;

          } catch (HibernateException e) {
              throw new ModelException("Error consultando Otras Ordenes Consulta Externa:" + 
                                       e.getMessage(), e);
          } catch (Exception e) {
              throw new ModelException("Error consultando Otras Ordenes Consulta Externa:" + 
                                       e.getMessage(), e);
          }

      }
      
    /**
    * 
    * @param numeroConsulta
    * @param numeroUsuario
    *
    */
    public List<Chcontroorden> getOtrasOrdenesPendientesRealizadasCE(final Long numeroConsulta,final Long numeroUsuario) throws ModelException {

       List<Chcontroorden> resultList = null;
       List parametros = new ArrayList();


       try {


           StringBuffer sb = new StringBuffer();
           sb.append(" select chco from " + Chcontroorden.class.getName() + 
                     " chco  where chco.id.hcolnumero != ?  and chco.hcocetapa = 'AD'  and chco.hcocestado = 'VG' and  chco.hcolusuario = ? ");
           parametros.add(numeroConsulta);
           parametros.add(numeroUsuario);


           resultList = 
                   (List<Chcontroorden>) this.getHibernateTemplate().find(sb.toString(), parametros.toArray());


           if (!resultList.isEmpty()) {
               return resultList;
           }


           return null;

       } catch (HibernateException e) {
           throw new ModelException("Error consultando Servicio en programacion:" + 
                                    e.getMessage(), e);
       } catch (Exception e) {
           throw new ModelException("Error consultando Servicio en programacion:" + 
                                    e.getMessage(), e);
       }

    }
    
    /**
     * @param autoriza
     * @throws ModelException
     */
    public void saveAutorizacionInformePsicologico(final Chautoinfopsic autoriza) throws ModelException {

        try {
            this.getHibernateTemplate().execute(new HibernateCallback() {
                        public Object doInHibernate(Session session) {
                            Integer consecutivo = null;
                            if (autoriza != null) {
                              



                                session.saveOrUpdate(autoriza);
                            }


                            return autoriza;
                        }
                    });
        } catch (HibernateException e) {
            throw new ModelException("Error Insertando Autorizacion Informe Psicologico:" + 
                                     e.getMessage(), e);
        } catch (Exception e) {
            throw new ModelException("Error Insertando Autorizacion Informe Psicologico:" + 
                                     e.getMessage(), e);
        }
    }
    
    /**
     * @return
     * @throws ModelException
     */
    public Chautornota getAutorizacionInformePsicologico(final Chautoinfopsic autorizacion) throws ModelException {
        List<Chautornota> resultList = null;
        List parametros = new ArrayList();
        try {
            if (autorizacion != null) {
                StringBuffer sb = new StringBuffer();
                sb.append(" select chan from " + Chautoinfopsic.class.getName());
                sb.append(" chan  where chan.haipnnumerconsu  = ? ");
                sb.append(" and chan.haipcaceptsolic is null ");

                parametros.add(autorizacion.getHaipnnumerconsu());
         


                resultList = 
                        (List<Chautornota>) this.getHibernateTemplate().find(sb.toString(), parametros.toArray());


                if (!resultList.isEmpty()) {
                    return resultList.get(0);
                }

            }


            return null;

        } catch (HibernateException e) {
            throw new ModelException("Error consultando Autorizacion Nota Aclratoria:" + 
                                     e.getMessage(), e);
        } catch (Exception e) {
            throw new ModelException("Error consultando Autorizacion Nota Aclaratoria :" + 
                                     e.getMessage(), e);
        }

    }
    
    public List<Chconsulta> getSolicitudFoliosInformePsicologico(final Long numeroUsuario, 
                                                            final String userName) throws ModelException {
        List<Chconsulta> pis = 
            (List<Chconsulta>)getHibernateTemplate().execute(new HibernateCallback() {
                    public Object doInHibernate(Session session) throws HibernateException {

                        String HORA_INICIAL = " 00:00";
                        String HORA_FINAL = " 23:59";
                        String fechaI = null;
                        String fechaF = null;

                        int diferenciaEnDias = 1;
                        Date fechaActual = Calendar.getInstance().getTime();
                        long tiempoActual = fechaActual.getTime();
                        long unDia = diferenciaEnDias * 24 * 60 * 60 * 1000;
                        Date fechaAyer = new Date(tiempoActual - unDia);

                        Date fechaFinal = new Date();


                        if (fechaAyer != null && fechaFinal != null) {
                            SimpleDateFormat dateFormat = 
                                new SimpleDateFormat("dd/MM/yyyy");

                            fechaI = 
                                    dateFormat.format(fechaAyer) + HORA_INICIAL;

                            fechaF = 
                                    dateFormat.format(fechaFinal) + HORA_FINAL;

                        }

                        StringBuffer sb = new StringBuffer();
                        sb.append("select chco from ");
                        sb.append(Chconsulta.class.getName()).append(" chco ");
                        sb.append("WHERE chco.hcolusuario.huslnumero = :numeroUsuario ");
                        sb.append(" AND chco.hcoeetapa = 'CE' ");
                        sb.append(" AND chco.hcocservicio.csvntiphis in (:wtippsicologia,:wtippsicologiaControl) ");
                 //       sb.append(" AND (chco.hcodfeccierre BETWEEN TO_DATE(:fechaI,'dd/MM/yyyy hh24:mi') AND TO_DATE(:fechaF,'dd/MM/yyyy hh24:mi'))");
                        sb.append(" order by  chco.hcodfecregistr desc ");


                        String hql = sb.toString();

                        Query query = session.createQuery(hql);
                        query.setParameter("numeroUsuario", numeroUsuario);
                        query.setParameter("wtippsicologia", 
                                           IConstantes.HISTORIA_PSICOLOGICA);
                        query.setParameter("wtippsicologiaControl", 
                                           IConstantes.HISTORIA_PSICOLOGICA_CONTROL);

                        //query.setParameter("fechaI", fechaI);
                       // query.setParameter("fechaF", fechaF);
                        List<Chconsulta> pis;
                        pis = query.list();

                        for (Chconsulta co: pis) {
                            Cpservicio servicio = co.getHcocservicio();
                            Hibernate.initialize(servicio);

                            Chusuario usu = co.getHcolusuario();
                            Hibernate.initialize(usu);


                        }

                        return pis;
                    }
                });
        return pis;
    }
    
    /**
     * @return
     * @throws ModelException
     */
    public List<Chautoinfopsic> getSolicitudesInformePsicologicoPorAprobar() throws ModelException {
        List<Chautoinfopsic> resultList = null;
        List parametros = new ArrayList();

        try {

            StringBuffer sb = new StringBuffer();
            sb.append(" select chan from " + Chautoinfopsic.class.getName() + 
                      " chan  where  chan.haipcaceptsolic is null   ");
        

            resultList = 
                    (List<Chautoinfopsic>) this.getHibernateTemplate().find(sb.toString(), parametros.toArray());


            if (!resultList.isEmpty()) {
                return resultList;
            }


            return null;

        } catch (HibernateException e) {
            throw new ModelException("Error consultando Solicitudes Por Aprobar:" + 
                                     e.getMessage(), e);
        } catch (Exception e) {
            throw new ModelException("Error consultando Solicitudes Por Aprobar:" + 
                                     e.getMessage(), e);
        }

    }
    
    /**
    * @param autoriza
    * @param userName
    * @throws ModelException
    */
    public void aprobarAutorizacionInformePsicologico(final Chautoinfopsic autoriza) throws ModelException {

    try {
        this.getHibernateTemplate().execute(new HibernateCallback() {
                    public Object doInHibernate(Session session) {
                        if (autoriza != null) {

                            session.saveOrUpdate(autoriza);
                        }


                        return autoriza;
                    }
                });
    } catch (HibernateException e) {
        throw new ModelException("Error Autorizando Informe Psicologico:" + 
                                 e.getMessage(), e);
    } catch (Exception e) {
        throw new ModelException("Error Autorizando Informe Psicologico:" + 
                                 e.getMessage(), e);
    }
    }
    
    /**
     * @return
     * @throws ModelException
     */
    public Chautoinfopsic getSolicitudInformePsicologicoByNumero(Long numeroConsulta) throws ModelException {
        List<Chautoinfopsic> resultList = null;
        List parametros = new ArrayList();

        try {

            StringBuffer sb = new StringBuffer();
            sb.append(" select chan from " + Chautoinfopsic.class.getName() + 
                      " chan  where  chan.haipnnumerconsu = ?  ");
            
            parametros.add(numeroConsulta);

            resultList = 
                    (List<Chautoinfopsic>) this.getHibernateTemplate().find(sb.toString(), parametros.toArray());


            if (!resultList.isEmpty()) {
                return resultList.get(0);
            }


            return null;

        } catch (HibernateException e) {
            throw new ModelException("Error consultando Solicitudes Por Numero:" + 
                                     e.getMessage(), e);
        } catch (Exception e) {
            throw new ModelException("Error consultando Solicitudes Por Numero:" + 
                                     e.getMessage(), e);
        }

    }
    
    private void generarRipsProcedimientoDescripcion(Session session, 
                                          Chdetacirpro detalle, 
                                          String userName, Chdetaldescr detalleDescripcion,Chdescrquiru descripcion) {
        // Ingresamos el RIPS del procedimiento 
        Crripsserv ripsNac = null;

        Crarcproce crarcproce = null;
        Cpservicio servicio = null;
        Chusuario usuario = null;
        CrarcproceId idRips = null;
        String autorizacion = "";
        BigDecimal wvalneto = new BigDecimal(0);
        BigDecimal wvalcuota = new BigDecimal(0);
        Cpprofesio profesional = null;

        if (detalle != null) {
            StringBuffer sb = new StringBuffer();
            sb.append(" select crap from " + 
                      Crarcproce.class.getName()).append(" crap ");
            sb.append(" where crap.id.capnconcli = :cpnnconcli ");
            sb.append(" and crap.id.capnconsec = :cpnnconsec ");
            Query query = session.createQuery(sb.toString());
            query.setParameter("cpnnconcli", 
                               detalle.getId().getHdclconsuprinc());
            query.setParameter("cpnnconsec", new Integer(0));
            crarcproce = (Crarcproce)query.uniqueResult();


            StringBuffer sb0 = new StringBuffer();
            sb0.append(" select cpse from ").append(Cpservicio.class.getName()).append(" cpse ");
            sb0.append(" WHERE cpse.csvccodigo = :codigo ");
            Query query0 = session.createQuery(sb0.toString());
            query0.setParameter("codigo", detalle.getId().getHdccservicio());
            servicio = (Cpservicio)query0.uniqueResult();

            StringBuffer sb10 = new StringBuffer();
            sb10.append(" select crri from ").append(Crripsserv.class.getName()).append(" crri ");
            sb10.append(" WHERE crri.id.crscservic = :codigoServicio and crri.id.crsngrupo = :grupoServ ");
            sb10.append(" and crri.id.crsnsubgru = :subGrupoServ and crri.crscestado = 'VG' ");
            Query query10 = session.createQuery(sb10.toString());
            query10.setParameter("codigoServicio", servicio.getCsvccodigo());
            query10.setParameter("grupoServ", servicio.getCsvngrupo().intValue());
            query10.setParameter("subGrupoServ", servicio.getCsvnsubgru().intValue());
            ripsNac = (Crripsserv)query10.uniqueResult();

            if (ripsNac == null) {
                Crripxclin rips = null;
                StringBuffer sb1 = new StringBuffer();
                sb1.append(" select crri from ").append(Crripxclin.class.getName()).append(" crri ");
                sb1.append(" WHERE crri.id.crinclinic = :clinica AND crri.id.cricservic = :codigoServicio  ");
                sb1.append("  and crri.id.cringrupo = :grupoServ and crri.id.crinsubgru = :subGrupoServ ");
                Query query1 = session.createQuery(sb1.toString());
                query1.setParameter("clinica", detalle.getHdcnclinica().intValue());
                query1.setParameter("codigoServicio", servicio.getCsvccodigo());
                query1.setParameter("grupoServ", servicio.getCsvngrupo().intValue());
                query1.setParameter("subGrupoServ", servicio.getCsvnsubgru().intValue());
                rips = (Crripxclin)query1.uniqueResult();
                
                if (rips != null) {
                    ripsNac = new Crripsserv(new CrripsservId());
                    ripsNac.setCrsnconcep(rips.getCrinconcep());
                    ripsNac.setCrsnambito(rips.getCrinambito());
                    ripsNac.setCrsnfinali(rips.getCrinfinali());
                    ripsNac.setCrscperate(rips.getCricperate());
                    ripsNac.setCrscdiagpr(rips.getCricdiagpr());
                    ripsNac.setCrscdiagre(rips.getCricdiagre());
                    ripsNac.setCrsnrealiz(rips.getCrinrealiz());
                }
            }

            StringBuffer sb2 = new StringBuffer();
            sb2.append(" select chus from ").append(Chusuario.class.getName()).append(" chus ");
            sb2.append(" WHERE chus.huslnumero = :usuario ");
            Query query2 = session.createQuery(sb2.toString());
            query2.setParameter("usuario", detalle.getHdclusuario());
            usuario = (Chusuario)query2.uniqueResult();
            
            Cnconsclin consulta;
            StringBuffer sb3 = new StringBuffer();
            sb3.append(" select cnco from ").append(Cnconsclin.class.getName()).append(" cnco ");
            sb3.append(" WHERE cnco.cconnumero = :consulta ");
            Query query3 = session.createQuery(sb3.toString());
            query3.setParameter("consulta", detalle.getId().getHdclconsuprinc());
            consulta = (Cnconsclin)query3.uniqueResult();

            if (consulta != null && consulta.getCcontipdoc() != null 
               && consulta.getCcontipdoc().getCtdnnumero().equals(IConstantes.CDOC_ADMISION)) {
                Cfadmision admision = null;
                Cfdetaadmision detadmi = null;
                List<Cfdetaadmision> lstDetadm;
                StringBuffer sb1 = new StringBuffer();
                sb1.append("select cfad from Cfadmision " + 
                            " cfad  where cfad.cannumero = :numdoc ");
                Query query1 = session.createQuery(sb1.toString());
                query1.setParameter("numdoc", consulta.getCconnumdoc());
                admision = (Cfadmision)query1.uniqueResult();

                if (admision != null && consulta.getCcocservic() != null) {
                    StringBuffer sb21 = new StringBuffer();
                    sb21.append(" select cfde from " + Cfdetaadmision.class.getName() + 
                               " cfde  where cfde.id.cdannumadm = :cdannumadm AND cfde.cdacservic = :cdacservic ");
                    Query query21 = session.createQuery(sb21.toString());
                    query21.setParameter("cdannumadm", admision.getCannumero());
                    query21.setParameter("cdacservic", consulta.getCcocservic().getCsvccodigo());
                    lstDetadm = (List<Cfdetaadmision>)query21.list();

                    if (lstDetadm != null && !lstDetadm.isEmpty()) {
                        detadmi = lstDetadm.get(0);
                    }

                    if (detadmi != null && detadmi.getCdacpaquet() != null && !detadmi.getCdacpaquet().equals("0")) {
                        StringBuffer sb11 = new StringBuffer();
                        sb11.append("select cppa.cpecserpri from " + Cppaquserv.class.getName() + " cppa  " +
                                "where cppa.id.cpecpaquet = :wpaquet AND cppa.id.cpecservic = :wservic " +
                                "AND cppa.cpecestado = 'VG' ");
                        Query query11 = session.createQuery(sb11.toString());
                        query11.setParameter("wpaquet", detadmi.getCdacpaquet());
                        query11.setParameter("wservic", consulta.getCcocservic().getCsvccodigo());
                        List<String> principal = (List<String>)query11.list();
                        if (principal != null && !principal.isEmpty() && "S".equals(principal.get(0))) {
                            StringBuffer sb20 = new StringBuffer();
                            sb20.append(" select cfde from " + Cfdetaadmision.class.getName() + 
                                      " cfde  where cfde.id.cdannumadm = :cdannumadm AND cfde.cdacservic = :wpaquete ");
                            Query query20 = session.createQuery(sb20.toString());
                            query20.setParameter("cdannumadm", admision.getCannumero());
                            query20.setParameter("wpaquete", detadmi.getCdacpaquet());
                            lstDetadm = (List<Cfdetaadmision>)query20.list();

                            if (lstDetadm != null &&  !lstDetadm.isEmpty()) {
                                detadmi = lstDetadm.get(0);
                            }
                        }
                    }

                    if (admision != null) {
                        autorizacion = admision.getCacnumrem();
                        if (autorizacion != null && autorizacion.length() > 15) {
                            autorizacion = autorizacion.substring(0,14);
                        }
                    }

                    if (detadmi != null && detadmi.getCdanvalser() != null && 
                        detadmi.getCdanvalent() != null) {
                        wvalneto = new BigDecimal(detadmi.getCdanvalser());
                        wvalcuota = wvalneto.subtract(new BigDecimal(detadmi.getCdanvalent()));
                    }
                }
            }
        }
        
        if (crarcproce == null) {
            crarcproce = new Crarcproce();
        }

        if (detalle != null && userName != null) {
        
            if (detalle != null && detalle.getHdcnclinica() != null && 
                userName != null) {
                StringBuffer sb4 = new StringBuffer();
                sb4.append(" select cppr from " + Cpprofesio.class.getName() + 
                           " cppr  where cppr.id.cpfnclinic = :cpfnclinic " + 
                           " and cppr.id.cpfncodigo = (select cppu.curnprofes from Cpusuario cppu where cppu.curcusuari = :curcusuari ) ");
                Query query4 = session.createQuery(sb4.toString());
                query4.setParameter("cpfnclinic", detalle.getHdcnclinica());
                query4.setParameter("curcusuari", userName);

                profesional = (Cpprofesio)query4.uniqueResult();

            }
            if (crarcproce.getId() == null || 
                crarcproce.getId().getCapnconcli() == null || 
                crarcproce.getId().getCapnconsec() == null) {
                idRips = new CrarcproceId();
                idRips.setCapnconcli(detalle.getId().getHdclconsuprinc().intValue());
                idRips.setCapnconsec(0);
                crarcproce.setId(idRips);
            }

            crarcproce.setCapdfecpro(new Date());
            crarcproce.setCapctipide(usuario.getHusetipoiden());
            crarcproce.setCapanumide(new BigDecimal(usuario.getHusanumeiden()));
            crarcproce.setCapnconcep(2);
            crarcproce.setCapcautori(autorizacion);
            if (servicio.getCsvccodigo() != null)
                if (servicio.getCsvccodigo() != null && 
                    servicio.getCsvccodcups() != null && 
                    servicio.getCsvccodcups().equals("0")) {
                    crarcproce.setCapccodpro(cfcocups(servicio.getCsvccodigo()));
                } else {
                    crarcproce.setCapccodpro(cfcocups(servicio.getCsvccodcups()));
                }

            if (detalleDescripcion != null) {
                if (descripcion != null) {
                    crarcproce.setCapnambito(descripcion.getHdqnambito());
                    crarcproce.setCapnrealiz(descripcion.getHdqnformareali());
                }
                crarcproce.setCapnfinpro(detalleDescripcion.getHddnfinalidad());
                crarcproce.setCapcperate(profesional.getCpfntippro().toString());
                crarcproce.setCapcdiagpr(detalleDescripcion.getHddcdiagnprinc());
                crarcproce.setCapcdiagre(detalleDescripcion.getHddcdiagnrelac());
                if ("S".equals(detalleDescripcion.getHddctienecompl())) {
                    crarcproce.setCapccompli(detalleDescripcion.getHddcdiagncompl());
                } else {
                    crarcproce.setCapccompli(" ");
                }
                crarcproce.setCapavalpro(wvalneto);
                crarcproce.setCapdfecreg(new Date());
                crarcproce.setCapcusuari(userName);
            }
            if (usuario != null && usuario.getHuslnumero() != null )
                crarcproce.setCaplusuario(new BigDecimal(detalle.getHdclusuario().intValue()));
            crarcproce.setCapnclinic(detalle.getHdcnclinica());

            session.saveOrUpdate(crarcproce);
        }
    }


    public void getSaveHisteroscopia(final Chhisteroscopia histeroscopia) throws ModelException {
    
        try {
            this.getHibernateTemplate().execute(new HibernateCallback() {
                        public Object doInHibernate(Session session) {
                            if (histeroscopia != null) {

                                session.saveOrUpdate(histeroscopia);
                            }


                            return histeroscopia;
                        }
                    });
        } catch (HibernateException e) {
            throw new ModelException("Error Guradando Datos Histeroscopia:" + 
                                     e.getMessage(), e);
        } catch (Exception e) {
            throw new ModelException("Error Guradando Datos Histeroscopia:" + 
                                     e.getMessage(), e);
        }
    }
   
    public void getSaveHallazgoHisteroscopia(final Chhallahistero hallazgoHis) throws ModelException {
    
        try {
            this.getHibernateTemplate().execute(new HibernateCallback() {
                        public Object doInHibernate(Session session) {
                            if (hallazgoHis != null) {

                                session.saveOrUpdate(hallazgoHis);
                            }


                            return hallazgoHis;
                        }
                    });
        } catch (HibernateException e) {
            throw new ModelException("Error Guradando Datos Hallazgo Histeroscopia:" + 
                                     e.getMessage(), e);
        } catch (Exception e) {
            throw new ModelException("Error Guradando Datos Hallazgo Histeroscopia:" + 
                                     e.getMessage(), e);
        }
    }
    
    /**
     * @param numero
     * @return
     * @throws ModelException
     */
    public List<Chrefepaci> getReferenciaPaciente(Long numero) throws ModelException {
        List<Chrefepaci> resultList = null;
        List parametros = new ArrayList();

        try {
            StringBuffer sb = new StringBuffer();
            sb.append(" select chre from " + Chrefepaci.class.getName() + 
                      " chre  where chre.id.hrplconsulta = ?  ");
            parametros.add(numero);

            resultList = 
                    (List<Chrefepaci>) this.getHibernateTemplate().find(sb.toString(), parametros.toArray());

            if (!resultList.isEmpty()) {
                return resultList;
            }

            return null;

        } catch (HibernateException e) {
            throw new ModelException("Error consultando referencia paciente:" + 
                                     e.getMessage(), e);
        } catch (Exception e) {
            throw new ModelException("Error consultando referencia paciente: " + 
                                     e.getMessage(), e);
        }

    }

    public boolean getAplicaTipoHistoria(String codigoServicio) throws ModelException {
        List<Cpservicio> resultList = null;
        List parametros = new ArrayList();
        int historia1 = 5;
        int historia2=17;

        try {
            StringBuffer sb = new StringBuffer();
            sb.append(" select cpse.csvccodigo from " + Cpservicio.class.getName() + 
                      " cpse  where csvntiphis not in(?,?) and CSVCCODIGO = ?  ");
            parametros.add(historia1);
            parametros.add(historia2);
            parametros.add(codigoServicio);

            resultList = 
                    (List<Cpservicio>) this.getHibernateTemplate().find(sb.toString(), parametros.toArray());

            if (!resultList.isEmpty()) {
                return true;
            }

            return false;

        } catch (HibernateException e) {
            throw new ModelException("Error consultando servicio de eipicrisis:" + 
                                     e.getMessage(), e);
        } catch (Exception e) {
            throw new ModelException("Error consultando servicio de epicrisis: " + 
                                     e.getMessage(), e);
        }

    }

    public Chmotivocon getMotivoConsultaEpicrisis(Long numeroConsulta) throws ModelException {
        List<Chmotivocon> resultList = null;
        List parametros = new ArrayList();

        try {
            StringBuffer sb = new StringBuffer();
            sb.append("  select chmo from  " + Chmotivocon.class.getName() + 
                      " chmo WHERE (hmcdfecregistr) > SYSDATE - 90 And hmclconsulta = ?  ");
            parametros.add(numeroConsulta);
            resultList = 
                    (List<Chmotivocon>) this.getHibernateTemplate().find(sb.toString(), parametros.toArray());

            if (!resultList.isEmpty()) {
                return resultList.get(0);
            }

            return null;

        } catch (HibernateException e) {
            throw new ModelException("Error obteniendo motivo de consulta epicrisis:" + 
                                     e.getMessage(), e);
        } catch (Exception e) {
            throw new ModelException("Error obteniendo motivo de consutla epicrisis: " + 
                                     e.getMessage(), e);
        }

    }

    

    public Chantegineco getAntecedentesGinecoEpicrisis(Long numeroConsulta) throws ModelException {
        List<Chantegineco> resultList = null;
        List parametros = new ArrayList();
        try {
                StringBuffer sb = new StringBuffer();
                sb.append(" select chag from " + Chantegineco.class.getName() + 
                          " chag  where chag.id.haglconsulta = ? AND chag.id.hagctiposervi = ? " +
                          " And (hagdfecregistr) > SYSDATE - 90 ");
                          
                parametros.add(numeroConsulta);
                parametros.add(IConstantes.TIPO_CONSULTA);


                resultList = 
                        (List<Chantegineco>) this.getHibernateTemplate().find(sb.toString(), parametros.toArray());

                if (!resultList.isEmpty()) {
                    return resultList.get(0);
                }
            return null;

        } catch (HibernateException e) {
            throw new ModelException("Error consultando Antecedentes Ginecologico:" + 
                                     e.getMessage(), e);
        } catch (Exception e) {
            throw new ModelException("Error consultando Antecedentes Ginecologicos:" + 
                                     e.getMessage(), e);
        }
    }

    public String getAntecedentesGeneralesEpicrisis(Long numeroConsulta) throws ModelException {
        String antegeneral = "";
        List<Chantecegene> lstAntegeneral = null;
        Chconsulta consulta = null;

        try {
            lstAntegeneral = getLstAntecedentesGeneralesEpicrisis(numeroConsulta);
            consulta = getConsultaAntecedentesGeneralesEpicrisis(numeroConsulta);
            
        } catch (HibernateException e) {
            throw new ModelException("Error consultando Antecedentes Generales:" + 
                                     e.getMessage(), e);
        } catch (Exception e) {
            throw new ModelException("Error consultando Antecedentes Generales :" + 
                                     e.getMessage(), e);
        }

        if (lstAntegeneral != null && !lstAntegeneral.isEmpty()) {
            Iterator it = lstAntegeneral.iterator();


            int i = 0;
            String alergicos = "";
            String familiares = "";
            String its = "";
            String patologicos = "";
            String quirurgicos = "";
            String toxicos = "";
            String transfucionales = "";
            String traumaticos = "";
            String farmacologicos = "";
            while (it.hasNext()) {
                Chantecegene antecedente = (Chantecegene)it.next();
                i++;
                if (antecedente != null) {
                    if (antecedente.getHanntipoante().equals(IConstantes.CODIGO_ANTECEDENTE_ALERGICOS)) {
                        alergicos = "ANTECEDENTES ALERGICOS: ";
                        alergicos = 
                                alergicos + antecedente.getHantdescripcio() + 
                                " \n";
                              
                    } else if (antecedente.getHanntipoante().equals(IConstantes.CODIGO_ANTECEDENTE_FAMILIARES)) {
                        familiares = "ANTECEDENTES FAMILIARES: ";
                        familiares = 
                                familiares + antecedente.getHantdescripcio() + 
                                " \n";
                       
                    } else if (antecedente.getHanntipoante().equals(IConstantes.CODIGO_ANTECEDENTE_ITS)) {
                        its = "ANTECEDENTES ITS: ";
                        its = its + antecedente.getHantdescripcio() + " \n";
                    } else if (antecedente.getHanntipoante().equals(IConstantes.CODIGO_ANTECEDENTE_PATOLOGICOS)) {
                        patologicos = "ANTECEDENTES PATOLOGICOS: ";
                        patologicos = 
                                patologicos + antecedente.getHantdescripcio() + 
                                " \n";
                    } else if (antecedente.getHanntipoante().equals(IConstantes.CODIGO_ANTECEDENTE_QUIRURGICOS)) {
                        quirurgicos = "ANTECEDENTES QUIRURGICOS: ";
                        quirurgicos = 
                                quirurgicos + antecedente.getHantdescripcio() + 
                                " \n";
                    } else if (antecedente.getHanntipoante().equals(IConstantes.CODIGO_ANTECEDENTE_TOXICOS)) {
                        toxicos = "ANTECEDENTES TOXICOS: ";
                        toxicos = 
                                toxicos + antecedente.getHantdescripcio() + " \n";
                    } else if (antecedente.getHanntipoante().equals(IConstantes.CODIGO_ANTECEDENTE_TRASNFUSIONALES)) {
                        transfucionales = "ANTECEDENTES TRANSFUNCIONALES: ";
                        transfucionales = 
                                transfucionales + antecedente.getHantdescripcio() + 
                                " \n";
                    } else if (antecedente.getHanntipoante().equals(IConstantes.CODIGO_ANTECEDENTE_TRAUMATICOS)) {
                        traumaticos = "ANTECEDENTES TRAUMATICOS: ";
                        traumaticos = 
                                traumaticos + antecedente.getHantdescripcio() + 
                                " \n";
                    } else if (antecedente.getHanntipoante().equals(IConstantes.CODIGO_ANTECEDENTE_FARMACOLOGICO)) {
                        farmacologicos = "ANTECEDENTES FARMACOLOGICOS: ";
                        farmacologicos = 
                                farmacologicos + antecedente.getHantdescripcio() + 
                                " \n";
                    }
                }
               
           
        }
            Iterator it1 ;
            if(consulta!=null){
              Chantox toxicos1 =null;
              Chantfami familiares1=null;
              Chantalerg alergicos1=null;
              Chantfarma farmacologicos1=null;
              Chantit its1=null;
              Chanttrans transfusionales1=null;
              Chantpatol patologicos1=null;
              Chantquir quirurgicos1=null;
              Chanttrauma traumacologicos1=null;
                if(consulta.getChantox()!=null){
                    it1 = consulta.getChantox().iterator();
                    while(it1.hasNext())
                    toxicos1 = (Chantox)it1.next();
                        if(toxicos1!=null){
                    toxicos = "ANTECEDENTES TOXICOS: ";
                   
                    toxicos = 
                            toxicos + toxicos1.getHantcdesc() + " \n";
                    }
                }
              
                if(consulta.getChantalerg()!=null){
                    it1 = consulta.getChantalerg().iterator();
                    while(it1.hasNext())
                    alergicos1 = (Chantalerg)it1.next();
                        if(alergicos1!=null){
                    alergicos = "ANTECEDENTES ALERGICOS: ";
                   
                    alergicos = 
                            alergicos + alergicos1.getHanacdesc() + 
                            " \n";
                    }
                }
              
                if(consulta.getChantfami()!=null){
                    it1 = consulta.getChantfami().iterator();
                    while(it1.hasNext())
                    familiares1 = (Chantfami)it1.next();
                        if(familiares1!=null){
                    familiares = "ANTECEDENTES FAMILIARES: ";
                    
                    familiares = 
                            familiares + familiares1.getHanfcdesc() + 
                            " \n";
                    }
                }
              
                if(consulta.getChantquir()!=null){
                    it1 = consulta.getChantquir().iterator();
                    while(it1.hasNext())
                    quirurgicos1 = (Chantquir)it1.next();
                    if(quirurgicos1!=null){
                    quirurgicos = "ANTECEDENTES QUIRURGICOS: ";
                    
                    quirurgicos = 
                            quirurgicos + quirurgicos1.getHanqcdesc() + 
                            " \n";
                    }
                }
               
                if(consulta.getChantpatol()!=null){
                    it1 = consulta.getChantpatol().iterator();
                    while(it1.hasNext())
                    patologicos1 = (Chantpatol)it1.next();
                        if(patologicos1!=null){
                    patologicos = "ANTECEDENTES PATOLOGICOS: ";
                   
                    patologicos = 
                            patologicos + patologicos1.getHagcdescri() + 
                            " \n";
                    }
                }
               
                if(consulta.getChantfarma()!=null){
                    it1 = consulta.getChantfarma().iterator();
                    while(it1.hasNext())
                    farmacologicos1 = (Chantfarma)it1.next();
                        if(farmacologicos1!=null){
                    farmacologicos = "ANTECEDENTES FARMACOLOGICOS: ";
                  
                    farmacologicos = 
                            farmacologicos + farmacologicos1.getHanfcdesc() + 
                            " \n";
                    }
                }
               
                if(consulta.getChanttrauma()!=null){
                    it1 = consulta.getChanttrauma().iterator();
                    while(it1.hasNext())
                    traumacologicos1 = (Chanttrauma)it1.next();
                        if(traumacologicos1!=null){
                    traumaticos = "ANTECEDENTES TRAUMATICOS: ";
                   
                    traumaticos = 
                            traumaticos + traumacologicos1.getHantcdesc() + 
                            " \n";
                    }
                }
               
                if(consulta.getChantit()!=null){
                    it1 = consulta.getChantit().iterator();
                    while(it1.hasNext())
                    its1 = (Chantit)it1.next();
                        if(its1!=null){
                    its = "ANTECEDENTES ITS: ";
                   
                        its = its + its1.getHanicdesc() + " \n";
                    }
                }
               
                if(consulta.getChanttrans()!=null){
                    it1 = consulta.getChanttrans().iterator();
                    while(it1.hasNext())
                    transfusionales1 = (Chanttrans)it1.next();
                        if(transfusionales1!=null){
                    transfucionales = "ANTECEDENTES TRANSFUNCIONALES: ";
                    
                    transfucionales = 
                            transfucionales + transfusionales1.getHantcdesc() + 
                            " \n";
                    }
                }
              
            }
        antegeneral = 
                alergicos + familiares + its + patologicos + quirurgicos + 
                toxicos + transfucionales + traumaticos + farmacologicos;
        }
        return antegeneral;
    
    }
    
    public List<Chantecegene> getLstAntecedentesGeneralesEpicrisis(Long numeroConsulta) throws ModelException {
        List<Chantecegene> resultList = null;
        List parametros = new ArrayList();


        try {
            if (numeroConsulta != null) {
                StringBuffer sb = new StringBuffer();
                sb.append(" select chag from " + Chantecegene.class.getName() + 
                          " chag  where chag.id.hanlconsulta = ? AND chag.id.hanctiposervi = ? " +
                          " And (handfecregistr) > SYSDATE - 90");
                parametros.add(numeroConsulta);
                parametros.add(IConstantes.TIPO_CONSULTA);


                resultList = 
                        (List<Chantecegene>) this.getHibernateTemplate().find(sb.toString(), parametros.toArray());


                if (!resultList.isEmpty()) {
                    return resultList;
                }

            }

            return null;

        } catch (HibernateException e) {
            throw new ModelException("Error consultando Antecedentes Generales:" + 
                                     e.getMessage(), e);
        } catch (Exception e) {
            throw new ModelException("Error consultando Antecedentes Generales :" + 
                                     e.getMessage(), e);
        }

    }

    public String getRevisionSistemasEpicrisis(Long numeroConsulta) throws ModelException {
        Chrevissiste revision = null;
        String revisiste = "";

        try {
            revision = getObjRevisionSistemasEpicrisis(numeroConsulta);
        } catch (HibernateException e) {
            throw new ModelException("Error consultando Revision por Sistemas Epicrisis:" + 
                                     e.getMessage(), e);
        } catch (Exception e) {
            throw new ModelException("Error consultando Revision por Sistemas Epicrisis:" + 
                                     e.getMessage(), e);
        }

        if (revision != null) {
            if (revision.getHrserefiecabez() == null || 
                revision.getHrserefiecabez().equals("N")) {
                revisiste = 
                        "Cabeza : " + formatearCampoRevision(revision.getHrserefiecabez()) + 
                        "\n";
            } else {
                revisiste = "Cabeza : " + revision.getHrscrefiecabez() + "\n";
            }

            if (revision.getHrserefieojos() == null || 
                revision.getHrserefieojos().equals("N")) {
                revisiste = 
                        revisiste + "Ojos : " + formatearCampoRevision(revision.getHrserefieojos()) + 
                        "\n";
            } else {
                revisiste = 
                        revisiste + "Ojos : " + revision.getHrscrefieojos() + 
                        "\n";
            }

            if (revision.getHrserefieoidos() == null || 
                revision.getHrserefieoidos().equals("N")) {
                revisiste = 
                        revisiste + "O�dos : " + formatearCampoRevision(revision.getHrserefieoidos()) + 
                        "\n";
            } else {
                revisiste = 
                        revisiste + "O�dos : " + revision.getHrscrefieoidos() + 
                        "\n";
            }

            if (revision.getHrserefienariz() == null || 
                revision.getHrserefienariz().equals("N")) {
                revisiste = 
                        revisiste + "Nariz : " + formatearCampoRevision(revision.getHrserefienariz()) + 
                        "\n";
            } else {
                revisiste = 
                        revisiste + "Nariz : " + revision.getHrscrefienariz() + 
                        "\n";
            }

            if (revision.getHrserefieboca() == null || 
                revision.getHrserefieboca().equals("N")) {
                revisiste = 
                        revisiste + "Boca : " + formatearCampoRevision(revision.getHrserefieboca()) + 
                        "\n";
            } else {
                revisiste = 
                        revisiste + "Boca : " + revision.getHrscrefieboca() + 
                        "\n";
            }

            if (revision.getHrserefiegarga() == null || 
                revision.getHrserefiegarga().equals("N")) {
                revisiste = 
                        revisiste + "Garganta : " + formatearCampoRevision(revision.getHrserefiegarga()) + 
                        "\n";
            } else {
                revisiste = 
                        revisiste + "Garganta : " + revision.getHrscrefiegarga() + 
                        "\n";
            }

            if (revision.getHrserefiecuell() == null || 
                revision.getHrserefiecuell().equals("N")) {
                revisiste = 
                        revisiste + "Cuello : " + formatearCampoRevision(revision.getHrserefiecuell()) + 
                        "\n";
            } else {
                revisiste = 
                        revisiste + "Cuello : " + revision.getHrscrefiecuell() + 
                        "\n";
            }

            if (revision.getHrserefiecardi() == null || 
                revision.getHrserefiecardi().equals("N")) {
                revisiste = 
                        revisiste + "Cardiorrespiratorio : " + formatearCampoRevision(revision.getHrserefiecardi()) + 
                        "\n";
            } else {
                revisiste = 
                        revisiste + "Cardiorrespiratorio : " + revision.getHrscrefiecardi() + 
                        "\n";
            }

            if (revision.getHrserefiemamas() == null || 
                revision.getHrserefiemamas().equals("N")) {
                revisiste = 
                        revisiste + "Mamas : " + formatearCampoRevision(revision.getHrserefiemamas()) + 
                        "\n";
            } else {
                revisiste = 
                        revisiste + "Mamas : " + revision.getHrscrefiemamas() + 
                        "\n";
            }

            if (revision.getHrserefiegastr() == null || 
                revision.getHrserefiegastr().equals("N")) {
                revisiste = 
                        revisiste + "Gastrointestinal : " + formatearCampoRevision(revision.getHrserefiegastr()) + 
                        "\n";
            } else {
                revisiste = 
                        revisiste + "Gastrointestinal : " + revision.getHrscrefiegastr() + 
                        "\n";
            }

            if (revision.getHrserefiegenit() == null || 
                revision.getHrserefiegenit().equals("N")) {
                revisiste = 
                        revisiste + "Genitourinario : " + formatearCampoRevision(revision.getHrserefiegenit()) + 
                        "\n";
            } else {
                revisiste = 
                        revisiste + "Genitourinario : " + revision.getHrscrefiegenit() + 
                        "\n";
            }


            if (revision.getHrserefielocom() == null || 
                revision.getHrserefielocom().equals("N")) {
                revisiste = 
                        revisiste + "Locomotor : " + formatearCampoRevision(revision.getHrserefielocom()) + 
                        "\n";
            } else {
                revisiste = 
                        revisiste + "Locomotor : " + revision.getHrscrefielocom() + 
                        "\n";
            }

          

            if (revision.getHrserefieneups() == null || 
                revision.getHrserefieneups().equals("N")) {
                revisiste = 
                        revisiste + "Neuropsiqui�trico : " + formatearCampoRevision(revision.getHrserefieneups()) + 
                        "\n";
            } else {
                revisiste = 
                        revisiste + "Neuropsiqui�trico : " + revision.getHrscrefieneups() + 
                        "\n";
            }

            if (revision.getHrserefieneumu() == null || 
                revision.getHrserefieneumu().equals("N")) {
                revisiste = 
                        revisiste + "Neuromuscular : " + formatearCampoRevision(revision.getHrserefieneumu()) + 
                        "\n";
            } else {
                revisiste = 
                        revisiste + "Neuromuscular : " + formatearCampoRevision(revision.getHrserefieneumu()) + 
                        "\n";
            }

            if (revision.getHrserefiepiel() == null || 
                revision.getHrserefiepiel().equals("N")) {
                revisiste = 
                        revisiste + "Piel y anexos : " + formatearCampoRevision(revision.getHrserefiepiel()) + 
                        "\n";
            } else {
                revisiste = 
                        revisiste + "Piel y anexos : " + revision.getHrserefiepiel() + 
                        "\n";
            }

        }
        return revisiste;
    }
    public String formatearCampoRevision(String campo) {
        if (campo == null) {
            campo = "";
        } else {
            if (campo.equals("R")) {
                campo = "Refiere";
            }
            if (campo.equals("N")) {
                campo = "No Refiere";
            }
            campo.trim();
        }
        return campo;
    }

    public Chconducta getConductaEpicrisis(Long numeroConsulta) throws ModelException {
        List<Chconducta> resultList = null;
        List parametros = new ArrayList();
        try {
            if (numeroConsulta != null) {

                StringBuffer sb = new StringBuffer();
                sb.append(" select chco from ").append(Chconducta.class.getName()).append(" chco ");
                sb.append(" where chco.id.hcnlconsulta = ? and (hcndfecregistr) > SYSDATE - 90  ");
                sb.append(" order by chco.hcndfecregistr DESC ");
                parametros.add(numeroConsulta);

                resultList = 
                        (List<Chconducta>) this.getHibernateTemplate().find(sb.toString(), parametros.toArray());

                if (!resultList.isEmpty()) {
                    return resultList.get(0);
                }
            }

            return null;

        } catch (HibernateException e) {
            throw new ModelException("Error consultando Ultima Conducta Consulta Epicrisis :" + 
                                     e.getMessage(), e);
        } catch (Exception e) {
            throw new ModelException("Error consultando Ultima Conducta Consulta Epicrisis :" + 
                                     e.getMessage(), e);
        }

    }

    public Chimprdiag getDiagnosticosIngEpicrisis(Long numeroConsulta) throws ModelException {
        List<Chimprdiag> resultList = null;
        List parametros = new ArrayList();
        try {
            if (numeroConsulta != null) {

                StringBuffer sb = new StringBuffer();
                sb.append(" select chid from ").append(Chimprdiag.class.getName()).append(" chid, ");
                sb.append(Chconsulta.class.getName()).append(" chco ");
                sb.append(" where chid.id.hidlconsulta = chco.hcolnumero ");
                sb.append(" and  chco.hcoeetapa = 'CE' ");
                sb.append(" and  chco.hcolnumero = ? and (hiddfecregistr) > SYSDATE - 90  ");
                sb.append(" order by chid.hiddfecregistr DESC ");
                parametros.add(numeroConsulta);

                resultList = 
                        (List<Chimprdiag>) this.getHibernateTemplate().find(sb.toString(), parametros.toArray());

                if (!resultList.isEmpty()) {
                    return resultList.get(0);
                }
            }

            return null;

        } catch (HibernateException e) {
            throw new ModelException("Error consultando Ultimo Impresion Diagnostica Usuario Epicrisis :" + 
                                     e.getMessage(), e);
        } catch (Exception e) {
            throw new ModelException("Error consultando Ultimo Impresion Diagnostica Usuario Epicrisis :" + 
                                     e.getMessage(), e);
        }

    }

    public Chevolucion getEvolucionEpicrisis(Long numeroConsuta) throws ModelException {
        List<Chevolucion> resultList = null;
        List parametros = new ArrayList();
        try {
            if (numeroConsuta != null) {

                StringBuffer sb = new StringBuffer();
                sb.append(" select chev from ").append(Chevolucion.class.getName()).append(" chev ");
                sb.append(" where chev.id.hevlnumero = ? ");
                sb.append("  and (hevdfecregistr) > SYSDATE - 90 ");
                sb.append(" order by chev.hevdfecregistr DESC ");
                parametros.add(numeroConsuta);

                resultList = 
                        (List<Chevolucion>) this.getHibernateTemplate().find(sb.toString(), parametros.toArray());

                if (!resultList.isEmpty()) {
                    return resultList.get(0);
                }
            }

            return null;

        } catch (HibernateException e) {
            throw new ModelException("Error consultando Ultima Evolucion Consulta Epicrisis :" + 
                                     e.getMessage(), e);
        } catch (Exception e) {
            throw new ModelException("Error consultando Ultima Evolucion Consulta Epicrisis :" + 
                                     e.getMessage(), e);
        }
    }

    public Chdetaldescr getDiagnosticosEgrEpicrisis(Long numeroConsulta) throws ModelException {
        List<Chdetaldescr> resultList = null;
        List parametros = new ArrayList();
        try {
            if (numeroConsulta != null) {

                StringBuffer sb = new StringBuffer();
                sb.append(" select chde from ").append(Chdetaldescr.class.getName()).append(" chde ");
                sb.append(" where chde.id.hddlnumero = ? and (hdddfecregistr) > SYSDATE - 90  ");
                sb.append(" order by chde.id.hddnconsec ASC ");
                parametros.add(numeroConsulta);

                resultList = 
                        (List<Chdetaldescr>) this.getHibernateTemplate().find(sb.toString(), parametros.toArray());

                if (!resultList.isEmpty()) {
                    return resultList.get(0);
                }
            }

            return null;

        } catch (HibernateException e) {
            throw new ModelException("Error consultando Diagnosticos Egreso Epicrisis :" + 
                                     e.getMessage(), e);
        } catch (Exception e) {
            throw new ModelException("Error consultando Diagnsoticos Egreso Epicrisis :" + 
                                     e.getMessage(), e);
        }
    }

    public Chrevissiste getObjRevisionSistemasEpicrisis(Long numeroConsulta) throws ModelException {
        List<Chrevissiste> resultList = null;
        List parametros = new ArrayList();


        try {
            if (numeroConsulta != null) {
                StringBuffer sb = new StringBuffer();
                sb.append(" select chrs from " + Chrevissiste.class.getName() + 
                          " chrs  where chrs.id.hrslconsulta = ? AND chrs.id.hrsctiposervi = ? " +
                          " And (hrsdfecregistr) > SYSDATE - 90 ");
                parametros.add(numeroConsulta);
                parametros.add(IConstantes.TIPO_CONSULTA);


                resultList = 
                        (List<Chrevissiste>) this.getHibernateTemplate().find(sb.toString(), parametros.toArray());

                if (!resultList.isEmpty()) {
                    return resultList.get(0);
                }
            }
            return null;

        } catch (HibernateException e) {
            throw new ModelException("Error consultando Revision por Sistemas Epicrisis:" + 
                                     e.getMessage(), e);
        } catch (Exception e) {
            throw new ModelException("Error consultando Revision por Sistemas Epicrisis:" + 
                                     e.getMessage(), e);
        }
    }

    public Chincapacida getIncapacidadEpicrisis(Long numeroConsulta) throws ModelException {
        List<Chincapacida> resultList = null;
        List parametros = new ArrayList();


        try {
            if (numeroConsulta != null) {
                StringBuffer sb = new StringBuffer();
                sb.append(" select chin from " + Chincapacida.class.getName() + 
                          " chin  where chin.id.hinlconsulta = ?  " );
                parametros.add(numeroConsulta);


                resultList = 
                        (List<Chincapacida>) this.getHibernateTemplate().find(sb.toString(), parametros.toArray());

                if (!resultList.isEmpty()) {
                    return resultList.get(0);
                }
            }
            return null;

        } catch (HibernateException e) {
            throw new ModelException("Error consultando Incapacidad Epicrisis:" + 
                                     e.getMessage(), e);
        } catch (Exception e) {
            throw new ModelException("Error consultando Incapacidad Epicrisis:" + 
                                     e.getMessage(), e);
        }
    }

    public Chdetaldescr getMasDescripcionQuirByUsuario(Long numeroUsuario, 
                                                  Date fechaDescripcion) throws ModelException {
        List<Chdetaldescr> resultList = null;
        List parametros = new ArrayList();
        try {
            if (numeroUsuario != null) {
                SimpleDateFormat dt1 = new SimpleDateFormat("dd-MM-yyyy");
                String fecha = dt1.format(fechaDescripcion);
                StringBuffer sb = new StringBuffer();
                sb.append(" select chde from ").append(Chdetaldescr.class.getName()).append(" chde ");
                sb.append(" where chde.hddlusuario = ? and trunc(chde.hdddfecregistr) = ?  ");
                sb.append(" order by chde.id.hddnconsec DESC ");
                parametros.add(numeroUsuario);
                parametros.add(fecha);

                resultList = 
                        (List<Chdetaldescr>) this.getHibernateTemplate().find(sb.toString(), parametros.toArray());

                if ( resultList!=null && !resultList.isEmpty()) {
                    if(resultList.size()>1){
                        return resultList.get(0) ;
                    }
                    else{
                        return null;
                    }
                   
                }
            }

            return null;

        } catch (HibernateException e) {
            throw new ModelException("Error consultando Detalle mismo dia Epicrisis :" + 
                                     e.getMessage(), e);
        } catch (Exception e) {
            throw new ModelException("Error consultando Detalle mismo Epicrisis :" + 
                                     e.getMessage(), e);
        }
       
    }

    public boolean existeEpicrisis(Long numeroCirugia) throws ModelException {
        List<Chepicrisi> resultList = null;
        List parametros = new ArrayList();
        try {
            if (numeroCirugia != null) {

                StringBuffer sb = new StringBuffer();
                sb.append(" select chep from ").append(Chepicrisi.class.getName()).append(" chep ");
                sb.append(" where chep.id.heplnumero = ?  ");
                sb.append(" order by chep.hepdfecregistr DESC ");
                parametros.add(numeroCirugia);

                resultList = 
                        (List<Chepicrisi>) this.getHibernateTemplate().find(sb.toString(), parametros.toArray());

                if (!resultList.isEmpty()) {
                    return true;
                }
            }

            return false;

        } catch (HibernateException e) {
            throw new ModelException("Error consultando Epicrisis :" + 
                                     e.getMessage(), e);
        } catch (Exception e) {
            throw new ModelException("Error consultando Epicrisis :" + 
                                     e.getMessage(), e);
        }
    }
    public Chexamfisico getExamenFisicoEpicrisis(Long numeroConsulta) throws ModelException {
        List<Chexamfisico> resultList = null;
        List parametros = new ArrayList();
        try {
            if (numeroConsulta != null) {

                StringBuffer sb = new StringBuffer();
                sb.append(" select chex from ").append(Chexamfisico.class.getName()).append(" chex ");
                sb.append(" where chex.id.heflconsulta = ? and (hefdfecregistr) > SYSDATE - 90  ");
                sb.append(" order by chex.hefdfecregistr DESC ");
                parametros.add(numeroConsulta);

                resultList = 
                        (List<Chexamfisico>) this.getHibernateTemplate().find(sb.toString(), parametros.toArray());

                if (!resultList.isEmpty()) {
                    return resultList.get(0);
                }
            }

            return null;

        } catch (HibernateException e) {
            throw new ModelException("Error consultando Ultimo examen medico Epicrisis :" + 
                                     e.getMessage(), e);
        } catch (Exception e) {
            throw new ModelException("Error consultando Ultimo examen medico Epicrisis :" + 
                                     e.getMessage(), e);
        }

    }
    public List<Object[]> getRegistroSegTelefonico(Long numConsulta, 
                                                     Integer consecutivo 
                                                     ) throws ModelException {
         List<Object[]> resultList = null;
         try {
             StringBuffer sb = new StringBuffer();
             sb.append("select clc.cclcnombre,usua.huscprimernomb,usua.huscsegundnomb,usua.huscprimerapel,");
             sb.append("  usua.huscsegundapel,seg.*,usua.husetipoiden,usua.husanumeiden ");
             sb.append("  from historia.chsegutelefo seg,historia.chusuario usua,clinico.cpclinica clc ");
             sb.append(" where seg.HSTLUSUARIO = usua.huslnumero ");
             sb.append(" and seg.HSTNCLINICA = clc.cclncodigo");
             sb.append(" and seg.hstlnumero= :numConsulta and seg.hstlconsecutiv = :consecutivo");
             Query sqlquery = 
                 this.getHibernateTemplate().getSessionFactory().getCurrentSession().createQuery(sb.toString());
             sqlquery.setParameter("numConsulta", numConsulta);
             sqlquery.setParameter("consecutivo", consecutivo);
             resultList = sqlquery.list();
             return resultList;

         } catch (HibernateException e) {
             throw new ModelException("Error consultando el registro de seguimiento telefonico:" + 
                                      e.getMessage(), e);
         } catch (Exception e) {
             throw new ModelException("Error consultando el registro de seguimiento telefonico:" + 
                                      e.getMessage(), e);
         }

     }
    public List<Chsegutelefo> getOneRegistroSegTelefonico(final Long numConsulta,final Integer consec) throws ModelException {
        List<Chsegutelefo> pis = 
            (List<Chsegutelefo>)getHibernateTemplate().execute(new HibernateCallback() {
                    public Object doInHibernate(Session session) throws HibernateException {


                        StringBuffer sb = new StringBuffer();
                        sb.append(" select seg from " + 
                                  Chsegutelefo.class.getName());
                        sb.append(" seg  ");
                        sb.append(" where seg.hstlnumero = :numConsulta and seg.hstlconsecutiv = :consec  ");
                        String hql = sb.toString();

                        Query query = session.createQuery(hql);
                        query.setParameter("numConsulta", numConsulta);
                        query.setParameter("consec", consec);
                        List<Chsegutelefo> pis;
                        pis = query.list();
                        return pis;
                    }
                });
        return pis;
    }
   
    public Chconsulta getConsultaAntecedentesGeneralesEpicrisis(final Long numeroConsulta) throws ModelException {
        Chconsulta pis = 
            (Chconsulta)getHibernateTemplate().execute(new HibernateCallback() {
                    public Object doInHibernate(Session session) throws HibernateException {


                        if (numeroConsulta != null) {
                            StringBuffer sb = new StringBuffer();
                            sb.append(" select chco from " + 
                                      Chconsulta.class.getName() + 
                                      " chco  where chco.hcolnumero = :numeroConsulta   And (hcodfecregistr) > SYSDATE - 90  ");

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

	public Chautordescr getAutorizacionDescripcion(Chautordescr autorizacion) throws ModelException {
		// TODO Auto-generated method stub
		return null;
	}
}
