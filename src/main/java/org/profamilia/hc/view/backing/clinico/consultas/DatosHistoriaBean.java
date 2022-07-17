package org.profamilia.hc.view.backing.clinico.consultas;

import java.math.BigDecimal;
import java.text.DecimalFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.Iterator;
import java.util.List;
import java.util.StringTokenizer;

import org.profamilia.hc.model.dto.Chantecdetal;
import org.profamilia.hc.model.dto.Chantecemama;
import org.profamilia.hc.model.dto.Chanteceobst;
import org.profamilia.hc.model.dto.Chantecolpo;
import org.profamilia.hc.model.dto.Chantecprena;
import org.profamilia.hc.model.dto.Chantecpsico;
import org.profamilia.hc.model.dto.Chantegineco;
import org.profamilia.hc.model.dto.Chasesoriaive;
import org.profamilia.hc.model.dto.Chcancecervi;
import org.profamilia.hc.model.dto.Chcertmedico;
import org.profamilia.hc.model.dto.Chcervaaplic;
import org.profamilia.hc.model.dto.Chcolposcopia;
import org.profamilia.hc.model.dto.Chconinfxcon;
import org.profamilia.hc.model.dto.Chconsulta;
import org.profamilia.hc.model.dto.Chcontrolcon;
import org.profamilia.hc.model.dto.Chcontrolpre;
import org.profamilia.hc.model.dto.Chcontrvasec;
import org.profamilia.hc.model.dto.Chcuestanest;
import org.profamilia.hc.model.dto.Chcuestester;
import org.profamilia.hc.model.dto.Chcuestplani;
import org.profamilia.hc.model.dto.Chdatosadvacuna;
import org.profamilia.hc.model.dto.Chdispoaplic;
import org.profamilia.hc.model.dto.Chescvalcai;
import org.profamilia.hc.model.dto.Chespervasec;
import org.profamilia.hc.model.dto.Chestadpsico;
import org.profamilia.hc.model.dto.Chestermascu;
import org.profamilia.hc.model.dto.Chevalugener;
import org.profamilia.hc.model.dto.Chexafisane;
import org.profamilia.hc.model.dto.Chexafismama;
import org.profamilia.hc.model.dto.Chexamediagn;
import org.profamilia.hc.model.dto.Chexameelect;
import org.profamilia.hc.model.dto.Chexameimage;
import org.profamilia.hc.model.dto.Chexamelabor;
import org.profamilia.hc.model.dto.Chexamfisico;
import org.profamilia.hc.model.dto.Chfertdato;
import org.profamilia.hc.model.dto.Chfertecog;
import org.profamilia.hc.model.dto.Chformulahos;
import org.profamilia.hc.model.dto.Chformulaliq;
import org.profamilia.hc.model.dto.Chformulamed;
import org.profamilia.hc.model.dto.Chgestacion;
import org.profamilia.hc.model.dto.Chidentiriesgo;
import org.profamilia.hc.model.dto.Chinfomamogr;
import org.profamilia.hc.model.dto.Chinfopsico;
import org.profamilia.hc.model.dto.Chmedicament;
import org.profamilia.hc.model.dto.Chmotivocon;
import org.profamilia.hc.model.dto.Chordecirugi;
import org.profamilia.hc.model.dto.Chpediexamen;
import org.profamilia.hc.model.dto.Chproceconsu;
import org.profamilia.hc.model.dto.Chpruecovidanticu;
import org.profamilia.hc.model.dto.Chpruecovidantige;
import org.profamilia.hc.model.dto.Chpsicoantec;
import org.profamilia.hc.model.dto.Chrefepaci;
import org.profamilia.hc.model.dto.Chregcomenf;
import org.profamilia.hc.model.dto.Chregisexame;
import org.profamilia.hc.model.dto.Chremihospit;
import org.profamilia.hc.model.dto.Chremision;
import org.profamilia.hc.model.dto.Chreporte;
import org.profamilia.hc.model.dto.Chresersangr;
import org.profamilia.hc.model.dto.Chresulparac;
import org.profamilia.hc.model.dto.Chrevissiste;
import org.profamilia.hc.model.dto.Chriesgomama;
import org.profamilia.hc.model.dto.Chtamizalapr;
import org.profamilia.hc.model.dto.Chtipointerc;
import org.profamilia.hc.model.dto.Chusuario;
import org.profamilia.hc.model.dto.Chvacunacion;
import org.profamilia.hc.model.dto.Chvalorabiopsi;
import org.profamilia.hc.model.dto.Chvalorprean;
import org.profamilia.hc.model.dto.Chviolencia;
import org.profamilia.hc.model.dto.Cpmunidane;
import org.profamilia.hc.model.dto.Cpprofesio;
import org.profamilia.hc.model.exceptions.ModelException;
import org.profamilia.hc.view.backing.BaseBean;
import org.profamilia.hc.view.constantes.IConstantes;
import org.profamilia.hc.view.util.ConverterTextoNumero;

public class DatosHistoriaBean extends BaseBean {

	protected List<Chreporte> lstReporte;

	/** Almacenan los datos de la historia clinica */
	protected String TIPO_DOCUMENTO;
	protected Long NUMERO_DOCUMENTO;
	protected String IMPRIMIO;
	protected String NOMBRE;
	protected Date FECHA_NACIMIENTO;
	protected Integer EDAD;
	protected String SEXO;
	protected String DIRECCION;
	protected String TELEFONO;
	protected String CIUDAD;
	protected String OCUPACION;
	protected String ZONA;
	protected String CONTRATO;
	protected Integer ESTRATO;
	protected String BARRIO;
	protected String NIVELEDUCATIVO;
	protected String ETNIA;
	protected String ESTADO_CIVIL;
	protected String RESPONSABLE;
	protected String PARENTESCO_RESPONSABLE;
	protected String TELEFONO_RESPONSABLE;
	protected String FECHA_CONSULTA;
	protected String NOMBRE_PROFESIONAL;
	protected String REGISTRO_MEDICO;
	protected String PROFESION;
	protected String CENTRO;
	protected String DES_MOTIVO_CONSULTA;
	protected String TIPO_CONTACTO;
	protected String CUAL_CONTACTO;
	protected String MOTIVO_CONSULTA;
	protected String FINALIDAD;
	protected String MANIOBRAS;
	protected String OBSMANIOBRAS;
	protected String INTERRUPCION;
	protected String OBSINTERRUPCION;
	protected String ENFERMEDAD_ACTUAL;
	protected String NOMBRE_ACOMPANANTE;
	protected String TELEFONO_ACOMPANANTE;
	protected String EPS;
	protected String TIPO_AFILIACION;

	protected String TIPOID_PROFESIONAL;

	protected BigDecimal NUMID_PROFESIONAL;
	// control Ive
	protected String TIPO_CONTROL;
	protected String CAUSA_EXTERNA;
	protected String FINALIDAD_IVE;
	protected String EFECTOS_SECUNDARIOS;
	protected String ESCALA_DOLOR;
	protected String DURACION_DOLOR;
	protected String DOLOR_MEDICO;
	protected String SANGRO;
	protected String TIEMPO_SANGRO;
	protected String SANGRO_MEDICO;
	protected String PRESENTO_EXPULSION;
	protected String PRESENTO_POSTERIOR;
	protected String HORAS_EXPULSION;
	protected String REPORTE_ECOGRAFIA;
	protected String GROSOR_ENDOMETRIAL;
	protected String DOPPLER;
	protected String DOPPLER_PN;
	protected String COMPLICACIONES;
	protected String PLANIFICACION;
	protected String INICIAR_PLANI;
	protected String METODO_ANTICO;
	protected String METODO_ANTICONCEPTIVO;
	protected String TOLERANCIA_METODO;
	protected String SANGRADO_MESTRU;
	protected String DURACION_SANGRADO;
	protected String SANGRADO_MEDICO;

	protected String ANTECEDENTE_ALERGICOS = "";
	protected String SIN_ANTECEDENTES = "";
	protected String ANTECEDENTES_FAMILIARES = "";
	protected String ANTECEDENTES_ITS = "";
	protected String ANTECEDENTES_PATOLOGICOS = "";
	protected String ANTECEDENTES_QUIRURGICOS = "";
	protected String ANTECEDENTES_TOXICOS = "";
	protected String ANTECEDENTES_TRANSFUNCIONALES = "";
	protected String ANTECEDENTES_TRAUMATICOS = "";
	protected String ANTECEDENTES_FARMACOLOGICOS = "";
	protected String ANTECEDENTES_MEDICACION = "";
	protected String ANTECEDENTES_PARTO = "";
	protected String ANTECEDENTES_COMPLICACIONES = "";
	protected String ANTECEDENTES_INMUNIZACIONES = "";
	protected String ANTECEDENTES_SICOMOTOR = "";
	protected String ANTECEDENTES_ALIMENTACION = "";
	protected String ANTECEDENTES_HOSPITALIZACIONES = "";
	// CUALES ANTECEDENTES ALERGICOS
	protected String CUALES_MEDICAMENTOS;
	protected String CUALES_ALIMENTOS;
	protected String CUALES_SAMBIENTE;
	protected String CUALES_SPIEL;
	protected String CUALES_PINSECTO;
	protected String CUALES_OTRA;

	protected Integer GESTACIONES;
	protected Integer PARTOS;
	protected Integer ABORTOS;
	protected Integer CESAREAS;
	protected Integer HIJOS_VIVOS;
	protected Integer HIJOS_ECTOPICOS;
	protected Integer HIJOS_MUERTOS;
	protected Integer MORTINATOS;
	protected Integer HIJOS_NACIDOS_VIVOS;
	protected String TIPO_CICLO;
	protected String FRECUENCIA_CICLO;
	protected String DURACION_CICLO;
	protected Integer MENARQUIA;
	protected Integer EDAD_PRIMERA_RELACION;
	protected String FUR;
	protected String FUP;
	protected String FUC;
	protected String ULTIMA_CITOLOGIA;
	protected String HA_SUFRIDO_VIOLENCIA;
	protected String VIOLENCIA_FISICA;
	protected String VIOLENCIA_PSICOLOGICA;
	protected String VIOLENCIA_SEXUAL;
	protected String RIESGO_PERSONA_MALTRATA;
	protected String ASESORIA_HABLAR;
	protected String OBSERVACIONES_VIOLENCIA;
	protected String PRESION_ARTERIAL;
	protected String TIPO_TEMPERATURA;
	protected String LUGAR_TEMPERATURA;
	protected String FRECUENCIA_CARDIACA;
	protected String FRECUENCIA_RESPIRATORIA;
	protected String TALLA;
	protected String PESO;
	protected String TEMPERATURA;
	protected String HALLAZGOS_EXAMEN_FISICO;
	protected String RECOMENDACIONES_IMPRESION;
	protected String TIPO_DIAGNOSTICO;
	protected String DIAGNOSTICO_PRINCIPAL;
	protected Integer GRADO_EXAMEN_ASA;
	protected String DIAGNOSTICO_RELACIONADO1;
	protected String DIAGNOSTICO_RELACIONADO2;
	protected String DIAGNOSTICO_RELACIONADO3;
	protected Double SEMANAS_EMBARAZO;
	protected Double SEMANAS_EMBARAZO_GESTACIONAL;
	protected String CONFIRMA_SEMANAS_EMBARAZO;
	protected String RECOMENDACIONES_CONDUCTA;
	protected String RECOMENDACIONES_PLANMANEJO;
	protected String FECHA_INICIAL_INCAPACIDAD;
	protected String FECHA_FINAL_INCAPACIDAD;
	protected String TIPO_INCAPACIDAD;
	protected String ORIGEN_INCAPACIDAD;
	protected Integer DIAS_INCAPACIDAD;
	protected String FECHA_CIRUGIA1;
	protected String HORA_CIRUGIA1;
	protected String FECHA_CIRUGIA2;
	protected String HORA_CIRUGIA2;
	protected String ANESTESIA_SOLICITADA;
	protected String INTERVENCIONES_PROPUESTAS;
	protected String OBSERVACIONES_ORDEN;
	protected String PACIENTE_ACEPTA_ORDEN;
	protected String LUGAR_CIRUGIA;
	protected String AYUDANTIA;
	protected String ESTANCIA;
	protected Integer NUMERO_DIAS_ESTANCIA;
	protected String RESERVA_SANGRE;
	protected Integer UNIDADES_SANGRE;
	protected String PATOLOGIA;
	protected String PROGRAMAR_ANESTESIOLOGO;
	// Atributos examenes paraclinicos
	protected String FISIOLOGICOS;
	protected String IMAGENES;
	protected String LABORATORIOS;

	// HISTORIA PSICOLOGIA
	// Atributos para los Antecedentes Psicologicos

	protected String SE_SIENTE_ENFERMO;
	protected String DESCRIPCION_ENFERMO;
	protected String ALTERACION_FISICA;
	protected String CUAL_ALTERACION;
	protected String NUNCA_FISICA;
	protected String OCASIONALMENTE_FISICA;
	protected String TRES_ALIMENTOS;
	protected String MAS_ALIMENTOS;
	protected String TIPO_ALIMENTOS_CONSUME;
	protected String MEDICAMENTOS_FORMULADOS;
	protected String CUAL_MEDICAMENTO;
	protected String HABITOS_SALUD;
	protected String CUAL_HABITO;
	protected String ORIENTACION_SEXUAL;
	protected String CUAL_ORIENTACION;
	protected String TIENE_PAREJA;
	protected String TIPO_VINCULO;
	protected String VIDA_SEXUAL;
	protected String RELACIONES_SATISFACTORIAS;
	protected String DIFICULTADES_RELACIONES;
	protected String CUALES_DIFICULTADES;
	protected String TRASTORNOS_PSIQUICOS;
	protected String CUAL_TRASTORNO;
	protected String TIPO_FAMILIA;
	protected String COMPOSICION_FAMILIAR;
	protected String TIPO_VINCULO_FAMILIAR;
	protected String RELACION_FAMILIA;

	// Atributos para EvaluaciNn General (Psicologia)

	protected String AREA_COGNITIVA;
	protected String AREA_AFECTIVA;
	protected String APOYO_FAMILIAR;
	protected String CUAL_APOYO;
	protected String CANALES_COMUNICACION;
	protected String CUAL_CANAL;
	protected String LABORAL_ESTUDIOS;
	protected String SERVICIOS_APOYO;
	protected String RELACIONES_FAMILIARES;
	protected String CUAL_PROBLEMA;
	protected String CUAL_RELACION;

	// Atributos para Plan de Tratamiento (Psicologia)

	protected String TIPO_INTERVENCION_PSICO;
	protected String NUMERO_SESIONES;
	protected String COMPROMISOS_PSCIO;

	// Atributos referencia

	protected String TIPO_SERVICIO;
	protected String NOMBRE_RESPONSABLE_REFERENCIA;
	protected String DIRECCION_RESPONSABLE_REFERENCIA;
	protected String TELEFONO_RESPONSABLE_REFERENCIA;
	protected String ANAMNESIS;
	protected String APOYO_DIAGNOSTICO;
	protected String JUSTIFICACION_REFERENCIA;

	// Atributos de VacunaciNn de CNrvix

	protected String FECHA_VACUNACION;
	protected String NUMERO_DOSIS;
	protected String OBSERVACIONES_VACUNA;

	// Atributos ANATOMIA PATOLOGICA
	protected String ORIGEN_PIEZA;

	// ATRIBUTOS PARA PROCEDIMIENTO EN CONSULTORIO

	protected String AMBITO_PROCEDIMIENTO;
	protected String FINALIDAD_PROCEDIMIENTO;
	protected String DIAGNOSTICO_PREVIO;
	protected String DESCRIPCION_PROCEDIMIENTO;
	protected String NOMBRE_PROCEDIMIENTO;
	protected String TIENE_COMPLICACIONES;
	protected String DIAGNOSTICO_COMPLICACION;
	protected String DESCRIPCION_COMPLICACION;
	protected String DIAGNOSTICO_POSTERIOR;
	protected String REALIZACION_PROCEDIMIENTO;

	// Atributos de control

	protected String NOTA_ACLARATORIA;

	protected String EVOLUCION;

	int total = 0;

	protected int index = -1;

	List<String> datos = new ArrayList<String>();

	protected boolean print;

	protected boolean encabezado;

	static final int ACTIVAR_BEAN = 0;

	static final int ACTIVAR_BUSCADOR = 1;

	// Datos del Reporte Esterilizacion Femenina
	protected String HCECENFERMO;
	protected String HCECENFERGRAV;
	protected String HCECOPERADO;
	protected String HCECTRANSFUSION;
	protected String HCECPRESIONALTA;
	protected String HCECEJERCICIO;
	protected String HCECPALPITACION;
	protected String HCECSOPLO;
	protected String HCECASMA;
	protected String HCECTOS;
	protected String HCECGRIPA;
	protected String HCECFUMA;
	protected String HCECPROBANESTESIA;
	protected String HCECALERGIA;
	protected String HCECDROGAS;
	protected String HCECCONVULSION;
	protected String HCECENFERMENTAL;
	protected String HCECDIABETES;
	protected String HCECHEPATITIS;
	protected String HCECOTRAENFER;
	protected String HCECEMBARAZO;
	protected String HCEDFECHULTMES;
	protected String HCECUTILMETPLAN;
	protected String HCEDFECHAPARTO;
	protected String HCECINFOMET;
	protected String HCECMETDEF;
	protected String HCECLIGFALLA;
	protected String HCECINSESTER;

	protected String HCECANENFERMO;
	protected String HCECANENFERGRAV;
	protected String HCECANOPERADO;
	protected String HCECANTRANSFUSION;
	protected String HCECANPRESIONALTA;
	protected String HCECANEJERCICIO;
	protected String HCECANPALPITACION;
	protected String HCECANSOPLO;
	protected String HCECANASMA;
	protected String HCECANTOS;
	protected String HCECANGRIPA;
	protected String FUMA_DIA_FEMENINA;
	protected String HCECANFUMA;
	protected String HCECANPROBANESTESIA;
	protected String HCECANALERGIA;
	protected String HCECANDROGAS;
	protected String HCECANCONVULSION;
	protected String HCECANENFERMENTAL;
	protected String HCECANDIABETES;
	protected String HCECANHEPATITIS;
	protected String HCECANOTRAENFER;
	protected String HCECANEMBARAZO;
	protected String HCECANMESNORM;
	protected String HCECANMETPLAN;
	protected String HCECANINFOMET;
	protected String HCECANMETDEF;
	protected String HCECANLIGFALLA;
	protected String HCECANINSESTER;
	protected String HCECMESNORM;
	protected String HCECESPARTO;
	protected String HCECMETPLAN;
	protected String HCECOBSERV;

	// Datos del Reporte Esterilizacion Masculina

	protected String HEMCINFORMETOD;
	protected String HEMCVASECDEFIN;
	protected String HEMCVASECFALLA;
	protected String HEMCVASECFALLANUEVO;
	protected String HEMCACLARFALLANUEVO;
	protected String HEMCEXITOESPER;
	protected String HEMCINFORSUFIC;
	protected String HEMCACLARINFOR;
	protected String HEMCACLARDEFIN;
	protected String HEMCACLARFALLA;
	protected String HEMCACLAREXITO;
	protected String HEMCACLARSUFIC;

	// Datos ILVE

	protected String AREA_AFECTIVA_INTERRUPCION;
	protected String AREA_COGNITIVA_INTERRUPCION;
	protected String AREA_SOMATICA_INTERRUPCION;
	protected String AREA_RELACIONAL_INTERRUPCION;
	protected String OBSERVACIONES_INTERRUPCION;
	protected String OTRO_SOMATICO;
	protected String OTRO_RELACIONAL;
	protected String OTRO_COGNITIVO;
	protected String TIPO_REMISION_ILVE;
	protected String CUAL_REMISION_ILVE;
	protected String CERTIFICACION_MEDICA_ILVE;
	protected String CUAL_FOBIA;
	protected String ESCOGE_VOLUNTARIAMENTE;
	protected String DESCRIPCION_ESCOGE_VOLUNTARIAMENTE;
	protected String PSICOSOCIAL;
	protected String DESCRIPCION_PSICOSOCIAL;
	protected String ANTECEDENTES_MEDICOS;
	protected String DESCRIPCION_ANTECEDENTES_MEDICOS;

	// APLICACION RETIRO PF

	protected String DESCRIPCION_PROCEDIMIENTO_PF;
	protected String AMBITO_PF;
	protected String FINALIDAD_PF;
	protected String TIENE_COMPLICACIONES_PF;
	protected String DIAGNOSTICO_COMPLICACION_PF;
	protected String DESCRIPCION_COMPLICACION_PF;
	protected String DIAGNOSTICO_POSTERIOR_PF;
	protected String REALIZACION_PROCEDIMIENTO_PF;

	// HISTORIA PRENATAL Antecedentes

	protected String TIENE_HTA_FAMILIAR;
	protected String TIENE_DIABETES_FAMILIAR;
	protected String TIENE_PREECLAMPSIA_FAMILIAR;
	protected String TIENE_ECLAMPSIA_FAMILIAR;
	protected String TIENE_GEMELARES_FAMILIAR;
	protected String TIENE_CARDIOPATIA_FAMILIAR;
	protected String TIENE_TUBERCULOSIS_FAMILIAR;
	protected String TIENE_OTROS_FAMILIAR;

	protected String HTA_FAMILIAR;
	protected String DIABETES_FAMILIAR;
	protected String PREECLAMPSIA_FAMILIAR;
	protected String ECLAMPSIA_FAMILIAR;
	protected String GEMELARES_FAMILIAR;
	protected String CARDIOPATIA_FAMILIAR;
	protected String TUBERCULOSIS_FAMILIAR;
	protected String OTROS_FAMILIAR;

	protected String TIENE_HTA_PERSONAL;
	protected String TIENE_DIABETES_PERSONAL;
	protected String TIENE_PREECLAMPSIA_PERSONAL;
	protected String TIENE_ECLAMPSIA_PERSONAL;
	protected String TIENE_GEMELARES_PERSONAL;
	protected String TIENE_CARDIOPATIA_PERSONAL;
	protected String TIENE_TUBERCULOSIS_PERSONAL;
	protected String TIENE_CIRUGIA_PELVICO_PERSONAL;
	protected String TIENE_ALERGICOS_PERSONAL;
	protected String TIENE_TABAQUISMO_PERSONAL;
	protected String TIENE_ANTITETANICA_PERSONAL;
	protected String TIENE_OTROS_PERSONAL;

	protected String HTA_PERSONAL;
	protected String DIABETES_PERSONAL;
	protected String PREECLAMPSIA_PERSONAL;
	protected String ECLAMPSIA_PERSONAL;
	protected String GEMELARES_PERSONAL;
	protected String CARDIOPATIA_PERSONAL;
	protected String TUBERCULOSIS_PERSONAL;
	protected String CIRUGIA_PELVICO_PERSONAL;
	protected String ALERGICOS_PERSONAL;
	protected String TABAQUISMO_PERSONAL;
	protected String ANTITETANICA_PERSONAL;
	protected String OTROS_PERSONAL;

	// Antecedentes Gineco - Obstetricos

	protected String LEUCORREAS;
	protected String ITS;
	protected String CITOLOGIA;
	protected String COLPOSCOPIA;
	protected String PERIODO_INTERGENESICO;
	protected String HISTORIA_INFERTILIDAD;
	protected String RPM;
	protected String RCIU;
	protected String TRATAMIENTOS_RECIBIDOS;
	protected String CUAL_TRATAMIENTO;
	protected String AMENAZA_PARTO;
	protected String PARTO_PREMATURO;
	protected String GEMELAR;
	protected String POLHIDRAMNIOS;
	protected String OLIGOHIDRAMNIOS;
	protected String MALFORMACIONES;
	protected String CUAL_MALFORMACION;
	protected String EMBARAZO_PROLONGADO;
	protected String AMENAZA_ABORTO;
	protected String OTROS_OBSTETRICOS;
	protected String CUALES_OBSTETRICOS;

	// HISTORIA VASECTOMIA Antecedentes Vasectomia
	protected Integer HIJOS_BIOLOGICOS_PACIENTE;
	protected Integer HIJOS_BIOLOGICOS_PAREJA;
	protected Integer HIJOS_BIOLOGICOS_JUNTOS;
	protected String METODOS_PLANIFICACION;

	// GESTACION PRENATAL

	protected String ANTITETANICA_PREVIA;
	protected String ANTITETANICA_ACTUAL_PRIMERA_DOSIS;
	protected String FECHA_ANTITETANICA_PRIMERA_DOSIS;
	protected String ANTITETANICA_ACTUAL_SEGUNDA_DOSIS;
	protected String FECHA_ANTITETANICA_SEGUNDA_DOSIS;
	protected String ANTIRUBEOLA_PREVIA;
	protected String ANTIRUBEOLA_ACTUAL;
	protected String FECHA_ANTIRUBEOLA_ACTUAL;
	protected String GRUPO_RH_PACIENTE;
	protected String GRUPO_RH_ESPOSO;
	protected String SENSIBILIZACION;
	protected String SOLICITO_VIH;
	protected String REALIZO_VIH;
	protected String ESTADO_GESTION_PROBABLE;
	protected String METODO_CONFIRMACION_EDAD_GESTIONAL;
	protected String SIGNOS_SNTOMAS_GESTACION;

	// EXAMEN FISICO_PRENATAL

	protected String PRESION_ARTERIAL_PRENATAL;
	protected String TIPO_TEMPERATURA_PRENATAL;
	protected String FRECUENCIA_CARDIACA_PRENATAL;
	protected String FRECUENCIA_RESPIRATORIA_PRENATAL;
	protected String TALLA_PRENATAL;
	protected String PESO_PRENATAL;
	protected String TEMPERATURA_PRENATAL;
	protected String EXAMEN_CLINICO_PRENATAL;
	protected String EXAMEN_MAMAS_PRENATAL;
	protected String EXAMEN_ODONTOLOGICO_PRENATAL;
	protected String PELVIS_PRENATAL;
	protected String CITOLOGIA_PRENATAL;
	protected String CERVIX_PRENATAL;
	protected String ALTURA_UTERINA;
	protected String FRECUENCIA_CARDIACA_FETAL;
	protected String MOVIMIENTO_FETAL;
	protected String PRESENTACION_FETAL;
	protected String EDEMAS_PRENATAL;
	protected String VALORACION_CUELLO_UTERINO;
	protected String ORL_PRENATAL;
	protected String CARDIO_PULMONAR_PRENATAL;
	protected String EXTREMIDADES_PRENATAL;
	protected String SISTEMA_NERVIOSO_PRENATAL;
	protected String DESCRIPCION_ORL_PRENATAL;
	protected String DESCRIPCION_CARDIO_PULMONAR_PRENATAL;
	protected String DESCRIPCION_EXTREMIDADES_PRENATAL;
	protected String DESCRIPCION_SISTEMA_NERVIOSO_PRENATAL;
	// Nuevo Prenatal
	protected String ESTADO_NUTRICIONAL_PRENATAL;
	protected String GENITURINARIO_PRENATAL;
	protected String DESCRIPCION_GENITURINARIO_PRENATAL;
	protected String GASTROINTESTINAL_PRENATAL;
	protected String DESCRIPCION_GASTROINTESTINAL_PRENATAL;

	// TAMIZAJE PRENATAL

	protected String TOXOPLASMA_IGG;
	protected String RESULTADO_IGG;
	protected String FECHA_IGG;
	protected String TOXOPLASMA_IGM;
	protected String RESULTADO_IGM;
	protected String FECHA_IGM;
	protected String TEST_SULLIVAN;
	protected String RESULTADO_TEST_SULLIVAN;
	protected String FECHA_TEST_SULLIVAN;
	protected String HEMOGLOBINA;
	protected String RESULTADO_HEMOGLOBINA;
	protected String FECHA_HEMOGLOBINA;
	protected String GLUCOSA;
	protected String RESULTADO_GLUCOSA;
	protected String FECHA_GLUCOSA;
	protected String SEROLOGIA;
	protected String RESULTADO_SEROLOGIA;
	protected String FECHA_SEROLOGIA;
	protected String ECOGRAFIA;
	protected String DESCRIPCION_ECOGRAFIA;
	protected String MICRONUTRIENTES;
	protected String PARCIAL_ORINA;
	protected String BACTERIURIA;
	protected String PROTEINURIA;
	protected String HEMATIES;
	protected String LEUCOCITOS;

	// INFORME ECOGRAFICO

	protected String INDICACION_EXAMEN_ECOGRAFIA;
	protected String TRASNDUCTOR_UTILIZADO_ECOGRAFIA;
	protected String INFORME_ECOGRAFIA;
	protected String CONCLUSION_ECOGRAFIA;

	// INFORME MAMOGRAFIA

	protected String NUMERO_MAMOGRAFIA;
	protected String MEDICO_REMITE;
	protected String DATOS_CLINICOS_RELEVANTES;
	protected String INFORME_MAMOGRAFICO;
	protected String DOSIS_SUPERFICIE;
	protected String INFORME_COMO_TAL_MAMOGRAFIA;
	protected String OPINION_MAMOGRAFIA;
	protected String TIPO_BIRADS;
	protected String RECOMENDACIONES_MAMOGRAFIA;

	// DATOS ECOGRAFIA

	protected Integer GESTACIONES_ECOGRAFIA;
	protected Integer PARTOS_ECOGRAFIA;
	protected Integer ABORTOS_ECOGRAFIA;
	protected Integer CESAREAS_ECOGRAFIA;
	protected Integer HIJOS_ECTOPICOS_ECOGRAFIA;
	protected Date FUR_ECOGRAFIA;
	protected BigDecimal EDAD_GESTACIONAL_MENSTRUAL;
	protected Integer DIAS_EDAD_GESTACIONAL;

	// DATOS CERVARIX

	protected String ASESOCANCE;
	protected String RECOMPREVE;
	protected String VPHCOMPPRE;
	protected String OTROSTIPOS;
	protected String CIENVIRUS;
	protected String DOSVACUCOL;
	protected String VPHCAUSANT;
	protected String TRESDOSIS;
	protected String INFOCERVA;
	protected String ANORMCITOL;
	protected String ANTECALERG;
	protected String REACIVACUN;
	protected String ENFERGRIPA;
	protected String ESTAEMBAR;
	protected String AMAMANTAND;
	protected String MESTRNORMA;
	protected String TIENEPARTO;
	protected String METODPLANI;
	protected String PIENSEMBAR;
	protected String MEDIAHORA;
	protected String INFORCONSE;
	protected String CONSUPROFA;
	protected String FUR_CERVIX;
	protected String FUP_CERVIX;
	protected String CUALANORMALIDAD;
	protected String INFORGARDA;

	// VALORACION PREANESTESIA

	protected String INTERVENCION_PREANESTESIA;
	protected String MEDICOS_ANESTESIA;

	// EXAMEN FISICO PREANESTESIA

	protected String APERTURA_ORAL_PREANESTESIA;
	protected String MALLAMPATI_PREANESTESIA;
	protected String DISTANCIA_MENTOTIROIDEA;
	protected String MOVILIDAD_MANDIBULA;
	protected String MOVILIDAD_ATLANTO_OCCIPITAL;
	protected String EVALUACION_GLOBAL_VIA_AEREA;
	protected String PROTESIS_DENTAL;
	protected String PROTESIS_INFERIOR;
	protected String GRADO_PROTESIS_INFERIOR;
	protected String MOVILIDAD_PROTESIS_INFERIOR;
	protected String PROTESIS_SUPERIOR;
	protected String GRADO_PROTESIS_SUPERIOR;
	protected String MOVILIDAD_PROTESIS_SUPERIOR;
	protected String HALLAZGOS_EXAMEN_FISICO_PREANESTESIA;

	// DATOS EXAMENES PARACLINICOS

	protected String HEMOGLOBINA_PREANESTESIA;
	protected String HEMATOCRITO_PREANESTESIA;
	protected String LEUCOCITOS_PREANESTESIA;
	protected String PT_PREANESTESIA;
	protected String INR_PREANESTESIA;
	protected String PTT_PREANESTESIA;
	protected String PLAQUETAS_PREANESTESIA;
	protected String PARCIAL_ORINA_PREANESTESIA;
	protected String GLICEMIA_PRE_PREANESTESIA;
	protected String GLICEMIA_POST_PREANESTESIA;
	protected String NITROGENO_PREANESTESIA;
	protected String CREATININA_PREANESTESIA;
	protected String ELECTROCARDIOGRAMA_PREANESTESIA;
	protected String RAYOS_X_PREANESTESIA;
	protected String ECOGRAFIAS_PREANESTESIA;
	protected String OTROS_RESULTADOS_PREANESTESIA;

	// DATOS DEL REGISTRO DE LOS EXAMENES CLINICOS

	protected String EXAMEN_APOYO_DIAGNOSTICO;
	protected String EXAMEN_LABORATORIO_CLINICO;
	protected String EXAMEN_IMAGENES;
	protected String EXAMEN_ESTUDIO_PATOLOGIA;
	protected String EXAMEN_PRUEBA_EMBARAZO;
	protected String EXAMEN_CITOLOGIA;
	protected String EXAMEN_COLPOSCOPIA;
	protected String EXAMEN_OTROS_EXAMENES;

	protected String TIENE_LABORATORIO_CLINICO;
	protected String TIENE_IMAGENES;
	protected String TIENE_ESTUDIO_PATOLOGIA;
	protected String TIENE_PRUEBA_EMBARAZO;
	protected String TIENE_CITOLOGIA;
	protected String TIENE_COLPOSCOPIA;
	protected String TIENE_OTROS_EXAMENES;

	// REVISION POR SISTEMAS

	protected String REVISION_CABEZA_DES;
	protected String REVISION_OJOS_DES;
	protected String REVISION_OIDOS_DES;
	protected String REVISION_NARIZ_DES;
	protected String REVISION_BOCA_DES;
	protected String REVISION_GARGANTA_DES;
	protected String REVISION_CUELLO_DES;
	protected String REVISION_CARDIO_DES;
	protected String REVISION_MAMAS_DES;
	protected String REVISION_GASTRO_DES;
	protected String REVISION_GENITO_DES;
	protected String REVISION_VENEREOS_DES;
	protected String REVISION_ENDOCRINO_DES;
	protected String REVISION_LOCOMOTOR_DES;
	protected String REVISION_NEUROMUSCULAR_DES;
	protected String REVISION_NEUROMUSCULAR_D;
	protected String REVISION_NEUROSIQUIATRICO_DES;

	protected String REVISION_PIEL_DES;

	// ANTECEDENTES DETALLADOS FERTILIDAD

	protected String REVISION_PATOLOGICOS_DES;

	// IDENTIFICA RIESGOS IVE

	protected String DISCRASIA_SANGUNNEA;
	protected String MANEJO_CON_ANTICOAGULANTES;
	protected String PATOLOGIAS_DESCOMPENSADAS;
	protected String PACIENTE_CON_ACRETISMO;
	protected String SOSPECHA_DE_CORIOAMNIONITIS;
	protected String PACIENTE_CON_UNA_CESAREA;
	protected String PACIENTE_CON_DOS_CESAREAS;
	protected String PACIENTE_CON_ALTERACIONES_ANATOMICAS;
	protected String PRESENCIA_DE_UNA_MALFORMACION;
	protected String PLACENTA_PREVIA;
	protected String PACIENTE_CON_ANEMIA;
	protected String RIESGO_HEMORRAGIA;
	protected String RIESGO_HEMORRAGIA_VAL;
	protected String RIESGO_HEMORRAGIA_OBS;
	protected String PATOLOGIA_CRONICA;
	protected String INFECCION_ACTUAL;
	protected String INFECCION_ACTUAL_VAL;
	protected String INFECCION_ACTUAL_OBS;
	protected String MALFORMACION_MULLERIANA;
	protected String MALFORMACION_MULLERIANA_OBS;
	protected String SEROLOGIA_VIH;
	protected String SEROLOGIA_VIH_OBS;
	protected String SOSPECHA_ANEMIA;
	protected String VIH_RECIENTE;
	protected String VIH_RECIENTE_OBS;

	// impresion Diagnostica Colposcopia
	protected String IMPRESION_DIAG_COLPOS;
	protected String OTRO_DIAG_COLPOS;

	// Orden de Impresion
	static Integer imp_datos_consulta = 1;
	static Integer imp_procedimiento_consultorio = 2;
	static Integer imp_esterilizacion = 3;
	static Integer imp_cuestionario_cervix = 4;
	static Integer imp_motivo_consulta = 5;
	static Integer imp_resultado_patologia = 6;
	static Integer imp_datos_fertilidad = 7;
	static Integer imp_asesoria_ive = 8;
	static Integer imp_valoracion_preanestesia = 9;
	static Integer imp_cuestionario_preanestesia = 10;

	static Integer imp_resultados_paraclinicos_preanestesia = 11;
	static Integer imp_revision_sistemas = 12;
	static Integer imp_cuestionario_masculino = 13;
	static Integer imp_cuestionario_planificacion = 14;
	static Integer imp_antecedentes = 15;
	static Integer imp_antecendes_detallado = 16;
	static Integer imp_antecedentes_vasectomia = 17;
	static Integer imp_cuestionario_femenina = 18;
	static Integer imp_antecedentes_psicologia = 19;
	static Integer imp_antecedentes_prenatal_familiares = 20;
	static Integer imp_antecedentes_prenatal_personales = 21;
	static Integer imp_antecedentes_ginecologicos = 22;
	static Integer imp_antecedentes_obstetricos = 23;
	static Integer imp_gestacion_prenatal = 24;
	static Integer imp_gestacion_prenatal_actual = 25;
	static Integer imp_valoracion_biopsicosocial = 26;
	static Integer imp_antecedentes_mama = 27;
	static Integer imp_antecedente_colposcopia = 28;
	static Integer imp_evaluacion_general = 29;
	static Integer imp_antecentes_psicologia = 30;
	static Integer imp_identificacion_Riesgos = 31;
	static Integer imp_encuesta_violencia = 32;
	static Integer imp_colposcopia = 33;
	static Integer imp_estado_psicoemocional = 34;
	static Integer imp_riesgo_mama = 35;
	static Integer imp_examen_mama = 36;
	static Integer imp_examen_fisico = 37;
	static Integer imp_examen_fisico_preanestesia = 38;
	static Integer imp_examen_fisico_prenatal = 39;
	static Integer imp_examen_pediatria = 40;
	static Integer imp_ecografia_fertilidad = 41;
	static Integer imp_control = 42;

	static Integer imp_remision_ilve = 43;
	static Integer imp_impresion_diagnostica = 44;
	static Integer imp_informe_ecografia = 45;
	static Integer imp_informe_histerosonografia = 46;
	static Integer imp_informe_mamografia = 47;
	static Integer imp_informe_marcacion_seno = 48;
	static Integer imp_informe_citopuncion_seno = 49;
	static Integer imp_tamizaje_prenatal = 50;
	static Integer imp_plan_tratamiento_psico = 51;
	static Integer imp_apoyo_diagnostico = 52;
	static Integer imp_aplicacion_retiro_pf = 53;
	static Integer imp_conducta = 54;
	static Integer imp_incapacidad = 55;
	static Integer imp_orden_cirugia = 56;
	static Integer imp_examenes_paraclinicos = 57;
	static Integer imp_referencia = 58;
	static Integer imp_anatomia_patologica = 59;
	static Integer imp_prescripcion_medica = 60;
	static Integer imp_control_sin_costo = 61;
	static Integer imp_examenes_imagenes = 62;
	static Integer imp_examenes_electrofisiologicos = 63;
	static Integer imp_examenes_laboratorios = 64;
	static Integer imp_interconsulta = 65;
	static Integer imp_certificado_medico = 66;
	static Integer imp_certificado_asistencia = 67;
	static Integer imp_remision_hospitalizacion = 68;
	static Integer imp_reserva_sangre = 69;
	static Integer imp_vacunacion_cervix = 70;
	static Integer imp_administrar_medicamento = 71;
	static Integer imp_aplicar_vacunacion = 72;
	static Integer imp_registro_complementario_enfermeria = 73;
	static Integer imp_referencia_paciente = 74;
	static Integer imp_signos_vitales = 90;
	static Integer imp_canalizacion_vena = 91;
	static Integer imp_nota_enfermeria = 92;
	static Integer imp_registro_examenes = 98;
	static Integer imp_nota_medica = 99;
	static Integer imp_evolucion = 100;
	static Integer imp_informe_psicologico = 101;
	static Integer imp_escala_valoracion_caidas = 102;
	static Integer imp_informe_anticuerposcovid = 103;
	static Integer imp_informe_antigenoscovid = 104;
	static Integer imp_consentimiento_informado = 105;
	static Integer imp_datos_adicionales_vacunacion = 106;

	protected String PRESENTA_DISCAPACIDAD;
	protected String CUAL_DISCAPACIDAD;
	protected String TOMA_MEDICAMENTO;
	protected String CUAL_MEDICAMENT;
	protected String TRASTORNO_MENTAL;
	protected String CUAL_TRASTOR;
	protected String ENFERME_DIAG;
	protected String CUAL_ENFERDIAG;
	protected String VIDA_SEXACTIVA;
	protected String TIENE_RELASEXUALES;
	protected String HABITO_SALUDABLE;
	protected String CUALES_HABITOS;
	protected String INTENTO_QUITARSEVIDA;
	protected String MANERAS_QUITARSEVIDA;
	protected String TIPO_VIOLENCIA_SEXUAL;
	protected String TIPO_VIOLENCIA_FISICA;
	protected String TIPO_VIOLENCIA_ECONOMICA;
	protected String TIPO_VIOLENCIA_PSICOLOGICA;
	protected String SUSTANCIA_PSICOACTIVA;
	protected String CUAL_SUSTANCIA;
	protected String VICTIMA_CONFARMADO;
	protected String EDAD_HABLO;
	protected String EDAD_GATEO;
	protected String EDAD_CAMINO;
	protected String HORAS_DUERME;
	protected String DIFICULTAD_APRENDE;
	protected String CUALES_DISFICULTAD;
	protected String SOCIALIZA;
	protected String OBSERVACIONES_SOCIALIZA;
	protected String RUTINA;
	protected String CUAL_RUTINA;
	protected String TEMPERAMENTO;
	protected String OBSE_TEMPERAMENTO;
	protected String APOYO_FAMILIARAMIGO;
	protected String CUAL_APOYOFAMILIAR;
	protected String RELACION_SOCIAL;
	protected String COMPOSICIONDINA_FAMILIAR;
	protected String DESARROLLO_SESION;
	protected Integer tipoHistoria;
	protected String INICIA_METODO_HOY;
	protected String CONFIRMA_EMBARAZO;

	static Integer imp_firma = 9999;

	public DatosHistoriaBean() {
	}

	public void setDatos(Chconsulta consulta) {

		if (consulta == null) {
			Chreporte report = new Chreporte();
			String s = "No se encontrarNn folios ";

			report.setHrecdescripcio(s);
			report.setHrencodigo(0);
			lstReporte.add(report);

		}

		validarConsulta(consulta);

		datosMedicamento(consulta);
		datosVacunacion(consulta);

		if (lstReporte == null || lstReporte.isEmpty()) {

			Chreporte report = new Chreporte();
			String s = "No se encontrarNn Registros  ";

			report.setHrecdescripcio(s);
			report.setHrencodigo(0);
			lstReporte.add(report);

		}
	}

	public void validarConsulta(Chconsulta consulta) {
		if (consulta != null) {
			boolean medicamentos = true;

			if (tipoHistoria != null && (tipoHistoria.equals(IConstantes.HISTORIA_ADMINISTRAR_MEDICAMENTO)
					|| tipoHistoria.equals(IConstantes.HISTORIA_VACUNACION))) {
				medicamentos = false;
				if (tipoHistoria.equals(IConstantes.HISTORIA_VACUNACION)) {
					imprimirDatosAdicionalesVacunacion(consulta);
				}
			}
			String d = "";
			String d2 = "";
			d = "";
			d2 = "";
			String wlabeldatos = "";

			if (medicamentos) {
				d = (new StringBuilder()).append("Consulta:         ")
						.append(formatearCampo(consulta.getHcocservicio().getCsvcnombre())).toString();
			} else {
				d =

						(new StringBuilder()).append("Servicio:         ")
								.append(formatearCampo(consulta.getHcocservicio().getCsvcnombre())).toString();
			}

			StringBuffer sb = new StringBuffer();
			if (medicamentos) {
				sb.append("Fecha Consulta: ").append(formatearCampo(consulta.getHcodfecregistr())).append(" Hora: ")
						.append(formatearCampoHoraSimple(consulta.getHcodfecregistr()));
				wlabeldatos = "Datos Consulta";
			} else {
				sb.append("Fecha Servicio: ").append(formatearCampo(consulta.getHcodfecregistr())).append(" Hora: ")
						.append(formatearCampoHoraSimple(consulta.getHcodfecregistr()));
				wlabeldatos = "Datos Servicio";
			}

			Chreporte reportInfo = new Chreporte();
			reportInfo.setHrecdescripcio(d);
			reportInfo.setHrecdescripcio2(sb.toString());
			reportInfo.setHrentipoimpres(Integer.valueOf(2));
			reportInfo.setHrectipodescri(wlabeldatos);
			reportInfo.setHrencodigo(imp_datos_consulta);
			reportInfo.setHrenconsulta(consulta.getHcolnumero());
			reportInfo.setHredfecharegis(consulta.getHcodfecregistr());
			lstReporte.add(reportInfo);
			d = "";
			d2 = "";
			d = "Nombre del profesional: " + formatearCampo(NOMBRE_PROFESIONAL);
			d2 = "Registro Profesional: " + formatearCampo(REGISTRO_MEDICO);
			reportInfo = new Chreporte();
			reportInfo.setHrecdescripcio(d);
			reportInfo.setHrecdescripcio2(d2);
			reportInfo.setHrentipoimpres(Integer.valueOf(2));
			reportInfo.setHrectipodescri(wlabeldatos);
			reportInfo.setHrencodigo(imp_datos_consulta);
			reportInfo.setHrenconsulta(consulta.getHcolnumero());
			reportInfo.setHredfecharegis(consulta.getHcodfecregistr());
			lstReporte.add(reportInfo);

			d = "";
			d2 = "";
			d = "Firma: " + formatearCampo(NOMBRE_PROFESIONAL) + " R.P.: " + formatearCampo(REGISTRO_MEDICO) + " "
					+ TIPOID_PROFESIONAL + " " + NUMID_PROFESIONAL;
			reportInfo = new Chreporte();
			reportInfo.setHrecdescripcio(d);
			reportInfo.setHrentipoimpres(11);
			reportInfo.setHrectipodescri("");
			reportInfo.setHrencodigo(imp_firma);
			reportInfo.setHrenconsulta(consulta.getHcolnumero());
			reportInfo.setHredfecharegis(consulta.getHcodfecregistr());
			lstReporte.add(reportInfo);

			d = "";
			d2 = "";
			d = (new StringBuilder()).append("Tipo de Especialidad:  ").append(formatearCampo(PROFESION)).toString();
			reportInfo = new Chreporte();
			reportInfo.setHrecdescripcio(d);
			reportInfo.setHrecdescripcio2(d2);
			reportInfo.setHrentipoimpres(Integer.valueOf(1));
			reportInfo.setHrectipodescri(wlabeldatos);
			reportInfo.setHrencodigo(imp_datos_consulta);
			reportInfo.setHrenconsulta(consulta.getHcolnumero());
			reportInfo.setHredfecharegis(consulta.getHcodfecregistr());
			lstReporte.add(reportInfo);

			d = "";
			d2 = "";
			d = (new StringBuilder()).append("Centro:         ").append(formatearCampo(CENTRO)).toString();
			reportInfo = new Chreporte();
			reportInfo.setHrecdescripcio(d);
			reportInfo.setHrecdescripcio2(d2);
			reportInfo.setHrentipoimpres(Integer.valueOf(1));
			reportInfo.setHrectipodescri(wlabeldatos);
			reportInfo.setHrencodigo(imp_datos_consulta);
			reportInfo.setHrenconsulta(consulta.getHcolnumero());
			reportInfo.setHredfecharegis(consulta.getHcodfecregistr());
			lstReporte.add(reportInfo);

			d = "";
			d2 = "";
			d = (new StringBuilder()).append("Nombre AcompaNante:             ")
					.append(formatearCampo(NOMBRE_ACOMPANANTE)).toString();
			d2 = (new StringBuilder()).append("TNlefono AcompaNante: ").append(formatearCampo(TELEFONO_ACOMPANANTE))
					.toString();
			reportInfo = new Chreporte();
			reportInfo.setHrecdescripcio(d);
			reportInfo.setHrecdescripcio2(d2);
			reportInfo.setHrectipodescri(wlabeldatos);
			reportInfo.setHrencodigo(imp_datos_consulta);
			reportInfo.setHrentipoimpres(Integer.valueOf(2));
			reportInfo.setHrenconsulta(consulta.getHcolnumero());
			reportInfo.setHredfecharegis(consulta.getHcodfecregistr());
			lstReporte.add(reportInfo);

			if (consulta.getChcontrvasec() != null && !consulta.getChcontrvasec().isEmpty()) {

				Chcontrvasec vasectomia = null;

				Iterator it = consulta.getChcontrvasec().iterator();
				if (it.hasNext()) {
					vasectomia = (Chcontrvasec) it.next();

					if (vasectomia != null) {
						String s = "Resultado: " + formatearCampo(vasectomia.getHcvcdescripcio());
						Chreporte report = new Chreporte();
						report.setHrecdescripcio(s);
						report.setHrentipoimpres(1);
						report.setHrectipodescri("Espermograma - Posvasectomia");
						report.setHrenconsulta(consulta.getHcolnumero());
						report.setHredfecharegis(consulta.getHcodfecregistr());
						report.setHrencodigo(imp_esterilizacion);
						lstReporte.add(report);
					}
				}
			}

			espermograma(consulta);
			procedimientosconocimientos(consulta);

			if (consulta.getChcancecervi() != null && !consulta.getChcancecervi().isEmpty()) {
				Chcancecervi cancerCervix = null;
				Iterator it = consulta.getChcancecervi().iterator();
				if (it.hasNext()) {
					cancerCervix = (Chcancecervi) it.next();
				}

				if (cancerCervix != null) {

					Chreporte report = new Chreporte();

					String s = "";
					String s2 = "";
					String s3 = "";

					if (ASESOCANCE != null && !ASESOCANCE.equals("")) {

						s = " NRecibiN usted informaciNn o asesorNa sobre el cNncer de cuello uterino y sus formas de prevenciNn?";
						s2 = ASESOCANCE;
						s3 = "";

						report = new Chreporte();
						report.setHrecdescripcio(s);
						report.setHrecdescripcio2(s2);
						report.setHrectipodescri("Cuestionario Cervarix");
						report.setHrentipoimpres(7);
						report.setHrencodigo(imp_cuestionario_cervix);
						report.setHrenconsulta(consulta.getHcolnumero());
						report.setHredfecharegis(consulta.getHcodfecregistr());
						lstReporte.add(report);
					}

					if (RECOMPREVE != null && !RECOMPREVE.equals("")) {
						s = " Se le informN que dentro de las recomendaciones para prevenir o diagnosticar oportunamente el cNncer de cNrvix estNn: asistir a consulta ginecolNgica; tomarse una citologNa vaginal y reclamar el resultado; usar de manera consistente el condNn y aplicarse de forma adecuada un esquema de la vacuna contra VPH?";
						s2 = RECOMPREVE;
						s3 = "";

						report = new Chreporte();
						report.setHrecdescripcio(s);
						report.setHrecdescripcio2(s2);
						report.setHrectipodescri("Cuestionario Cervarix");
						report.setHrentipoimpres(7);
						report.setHrencodigo(imp_cuestionario_cervix);
						report.setHrenconsulta(consulta.getHcolnumero());
						report.setHredfecharegis(consulta.getHcodfecregistr());
						lstReporte.add(report);
					}

					if (VPHCOMPPRE != null && !VPHCOMPPRE.equals("")) {
						s = " NSe le informN que la vacuna contra el VPH complementa y hace parte del programa de prevenciNn del cNncer de cNrvix, pero no reemplaza las otras recomendaciones para la protecciNn o diagnNstico oportuno?";
						s2 = VPHCOMPPRE;
						s3 = "";

						report = new Chreporte();
						report.setHrecdescripcio(s);
						report.setHrecdescripcio2(s2);
						report.setHrectipodescri("Cuestionario Cervarix");
						report.setHrentipoimpres(7);
						report.setHrencodigo(imp_cuestionario_cervix);
						report.setHrenconsulta(consulta.getHcolnumero());
						report.setHredfecharegis(consulta.getHcodfecregistr());
						lstReporte.add(report);

					}

					if (OTROSTIPOS != null && !OTROSTIPOS.equals("")) {
						s = " NSabe usted que estar vacunada no significa que no vaya a desarrollar cNncer de cuello uterino por otros tipos de virus y que es improbable que la vacuna la beneficie si ya ha  estado expuesta a un tipo de virus que previene la vacuna?";
						s2 = OTROSTIPOS;
						s3 = "";

						report = new Chreporte();
						report.setHrecdescripcio(s);
						report.setHrecdescripcio2(s2);
						report.setHrectipodescri("Cuestionario Cervarix");
						report.setHrentipoimpres(7);
						report.setHrencodigo(imp_cuestionario_cervix);
						report.setHrenconsulta(consulta.getHcolnumero());
						report.setHredfecharegis(consulta.getHcodfecregistr());
						lstReporte.add(report);
					}

					if (CIENVIRUS != null && !CIENVIRUS.equals("")) {
						s = " NSe le informN que existen mNs de cien tipos del virus del papiloma humano (VPH), que es  transmitido sexualmente y es reconocido como causa del 99% del cNncer cervical y puede tardar aNos en manifestarse a travNs de una lesiNn?";
						s2 = CIENVIRUS;
						s3 = "";

						report = new Chreporte();
						report.setHrecdescripcio(s);
						report.setHrecdescripcio2(s2);
						report.setHrectipodescri("Cuestionario Cervarix");
						report.setHrentipoimpres(7);
						report.setHrencodigo(imp_cuestionario_cervix);
						report.setHrenconsulta(consulta.getHcolnumero());
						report.setHredfecharegis(consulta.getHcodfecregistr());
						lstReporte.add(report);

					}

					if (VPHCAUSANT != null && !VPHCAUSANT.equals("")) {
						s = " NSabe usted que el virus VPH tipos 16, 18, 31 y 45 son los causantes del 80% del cNncer de cuello uterino?";
						s2 = VPHCAUSANT;
						s3 = "";
						report = new Chreporte();
						report.setHrecdescripcio(s);
						report.setHrecdescripcio2(s2);
						report.setHrectipodescri("Cuestionario Cervarix");
						report.setHrentipoimpres(7);
						report.setHrencodigo(imp_cuestionario_cervix);
						report.setHrenconsulta(consulta.getHcolnumero());
						report.setHredfecharegis(consulta.getHcodfecregistr());
						lstReporte.add(report);
					}

					if (DOSVACUCOL != null && !DOSVACUCOL.equals("")) {

						s = " NSabe usted que existe en Colombia dos tipos de vacunas  contra el VPH que no son terapNuticas ni infecciosas y que disponibles en Profamilia, la bivalente previene directamente contra la infecciNn del VPH tipo 16,18 y de forma cruzada contra el VPH tipo 31,45 y comercialmente es el CERVARIX. La otra es tetravalente previene directamente contra la infecciNn del VPH tipo 6,11,16,18 y se conoce comercialmente con el nombre de GARDASIL";
						s2 = DOSVACUCOL;
						s3 = "";
						report = new Chreporte();
						report.setHrecdescripcio(s);
						report.setHrecdescripcio2(s2);
						report.setHrectipodescri("Cuestionario Cervarix");
						report.setHrentipoimpres(7);
						report.setHrencodigo(imp_cuestionario_cervix);
						report.setHrenconsulta(consulta.getHcolnumero());
						report.setHredfecharegis(consulta.getHcodfecregistr());
						lstReporte.add(report);
					}

					if (INFORGARDA != null && !INFORGARDA.equals("")) {

						s = " Se le informN que para que GARDASIL estN indicada en niNos de 9 a 17 aNos para la prevenciNn de lesiones en genitales externos e infecciNn causada por VPH tipos 6,11,16,18 ";
						s2 = INFORGARDA;
						s3 = "";
						report = new Chreporte();
						report.setHrecdescripcio(s);
						report.setHrecdescripcio2(s2);
						report.setHrectipodescri("Cuestionario Cervarix");
						report.setHrentipoimpres(7);
						report.setHrencodigo(imp_cuestionario_cervix);
						report.setHrenconsulta(consulta.getHcolnumero());
						report.setHredfecharegis(consulta.getHcodfecregistr());
						lstReporte.add(report);

					}

					if (TRESDOSIS != null && !TRESDOSIS.equals("")) {

						s = " NSe le informN que para que la vacuna alcance  una eficacia mNnima del 95% se debe aplicar tres dosis de acuerdo con un esquema, no haber estado en contacto con el VPH y tener entre 9 y 55 aNos?";
						s2 = TRESDOSIS;
						s3 = "";
						report = new Chreporte();
						report.setHrecdescripcio(s);
						report.setHrecdescripcio2(s2);
						report.setHrectipodescri("Cuestionario Cervarix");
						report.setHrentipoimpres(7);
						report.setHrencodigo(imp_cuestionario_cervix);
						report.setHrenconsulta(consulta.getHcolnumero());
						report.setHredfecharegis(consulta.getHcodfecregistr());
						lstReporte.add(report);

					}

					if (INFOCERVA != null && !INFOCERVA.equals("")) {

						s = " NRecibiN usted informaciNn sobre todos los beneficios, eficacia y efectos colaterales de cada vacuna?";
						s2 = INFOCERVA;
						s3 = "";
						report = new Chreporte();
						report.setHrecdescripcio(s);
						report.setHrecdescripcio2(s2);
						report.setHrectipodescri("Cuestionario Cervarix");
						report.setHrentipoimpres(7);
						report.setHrencodigo(imp_cuestionario_cervix);
						report.setHrenconsulta(consulta.getHcolnumero());
						report.setHredfecharegis(consulta.getHcodfecregistr());
						lstReporte.add(report);
					}

					if (ANORMCITOL != null && !ANORMCITOL.equals("")) {
						s = " NHa tenido resultados anormales de la citologNa?";
						s2 = ANORMCITOL;
						s3 = CUALANORMALIDAD;
						report = new Chreporte();
						report.setHrecdescripcio(s);
						report.setHrecdescripcio2(s2);
						if (CUALANORMALIDAD != null && !CUALANORMALIDAD.equals("")) {
							report.setHrecdescripcio3(s3);
						}
						report.setHrectipodescri("Cuestionario Cervarix");
						report.setHrentipoimpres(7);
						report.setHrencodigo(imp_cuestionario_cervix);
						report.setHrenconsulta(consulta.getHcolnumero());
						report.setHredfecharegis(consulta.getHcodfecregistr());
						lstReporte.add(report);
					}

					if (ANTECALERG != null && !ANTECALERG.equals("")) {
						s = " NHa sufrido de alteraciones en la coagulaciNn, de  antecedentes de alergias u otras patologNas crNnicas o catastrNficas?";
						s2 = ANTECALERG;
						s3 = "";
						report = new Chreporte();
						report.setHrecdescripcio(s);
						report.setHrecdescripcio2(s2);
						report.setHrectipodescri("Cuestionario Cervarix");
						report.setHrentipoimpres(7);
						report.setHrencodigo(imp_cuestionario_cervix);
						report.setHrenconsulta(consulta.getHcolnumero());
						report.setHredfecharegis(consulta.getHcodfecregistr());
						lstReporte.add(report);
					}

					if (REACIVACUN != null && !REACIVACUN.equals("")) {
						s = " NHa tenido alguna reacciNn alNrgica a la aplicaciNn de alguna vacuna?";
						s2 = REACIVACUN;
						s3 = "";
						report = new Chreporte();
						report.setHrecdescripcio(s);
						report.setHrecdescripcio2(s2);
						report.setHrectipodescri("Cuestionario Cervarix");
						report.setHrentipoimpres(7);
						report.setHrencodigo(imp_cuestionario_cervix);
						report.setHrenconsulta(consulta.getHcolnumero());
						report.setHredfecharegis(consulta.getHcodfecregistr());
						lstReporte.add(report);
					}

					if (ENFERGRIPA != null && !ENFERGRIPA.equals("")) {
						s = " NEstN Usted enferma/o - gripa o cualquier otra patologNa -  o cree que lo estN?";
						s2 = ENFERGRIPA;
						s3 = "";
						report = new Chreporte();
						report.setHrecdescripcio(s);
						report.setHrecdescripcio2(s2);
						report.setHrectipodescri("Cuestionario Cervarix");
						report.setHrentipoimpres(7);
						report.setHrencodigo(imp_cuestionario_cervix);
						report.setHrenconsulta(consulta.getHcolnumero());
						report.setHredfecharegis(consulta.getHcodfecregistr());
						lstReporte.add(report);
					}

					if (ESTAEMBAR != null && !ESTAEMBAR.equals("")) {

						s = " NEstN Usted embarazada o cree que lo estN?";
						s2 = ESTAEMBAR;
						s3 = "";
						report = new Chreporte();
						report.setHrecdescripcio(s);
						report.setHrecdescripcio2(s2);
						report.setHrectipodescri("Cuestionario Cervarix");
						report.setHrentipoimpres(7);
						report.setHrencodigo(imp_cuestionario_cervix);
						report.setHrenconsulta(consulta.getHcolnumero());
						report.setHredfecharegis(consulta.getHcodfecregistr());
						lstReporte.add(report);
					}

					if (MESTRNORMA != null && !MESTRNORMA.equals("")) {
						s = " NSu Nltima menstruaciNn fue normal?";
						s2 = MESTRNORMA;
						s3 = FUR_CERVIX;
						report = new Chreporte();
						report.setHrecdescripcio(s);
						report.setHrecdescripcio2(s2);
						if (FUR_CERVIX != null && !FUR_CERVIX.equals("")) {
							report.setHrecdescripcio3(s3);
						}
						report.setHrectipodescri("Cuestionario Cervarix");
						report.setHrentipoimpres(7);
						report.setHrencodigo(imp_cuestionario_cervix);
						report.setHrenconsulta(consulta.getHcolnumero());
						report.setHredfecharegis(consulta.getHcodfecregistr());
						lstReporte.add(report);

					}

					if (TIENEPARTO != null && !TIENEPARTO.equals("")) {
						s = " NFecha Nltimo parto/aborto";
						s2 = TIENEPARTO;
						s3 = FUP_CERVIX;
						report = new Chreporte();
						report.setHrecdescripcio(s);
						report.setHrecdescripcio2(s2);
						if (FUP_CERVIX != null && !FUP_CERVIX.equals("")) {
							report.setHrecdescripcio3(s3);
						}
						report.setHrectipodescri("Cuestionario Cervarix");
						report.setHrentipoimpres(7);
						report.setHrencodigo(imp_cuestionario_cervix);
						report.setHrenconsulta(consulta.getHcolnumero());
						report.setHredfecharegis(consulta.getHcodfecregistr());
						lstReporte.add(report);
					}

					if (METODPLANI != null && !METODPLANI.equals("")) {
						s = " NUsted o su pareja utiliza(n) de manera consistente en la actualidad un mNtodo de planificaciNn familiar?";
						s2 = METODPLANI;
						s3 = "";

						report = new Chreporte();
						report.setHrecdescripcio(s);
						report.setHrecdescripcio2(s2);
						report.setHrectipodescri("Cuestionario Cervarix");
						report.setHrentipoimpres(7);
						report.setHrencodigo(imp_cuestionario_cervix);
						report.setHrenconsulta(consulta.getHcolnumero());
						report.setHredfecharegis(consulta.getHcodfecregistr());
						lstReporte.add(report);
					}

					if (PIENSEMBAR != null && !PIENSEMBAR.equals("")) {
						s = " NSabe usted que si estN embarazada o piensa embarazarse en los prNximos seis meses no debe colocarse la vacuna?";
						s2 = PIENSEMBAR;
						s3 = "";
						report = new Chreporte();
						report.setHrecdescripcio(s);
						report.setHrecdescripcio2(s2);
						report.setHrectipodescri("Cuestionario Cervarix");
						report.setHrentipoimpres(7);
						report.setHrencodigo(imp_cuestionario_cervix);
						report.setHrenconsulta(consulta.getHcolnumero());
						report.setHredfecharegis(consulta.getHcodfecregistr());
						lstReporte.add(report);
					}

					if (MEDIAHORA != null && !MEDIAHORA.equals("")) {
						s = " NSabe usted que despuNs de aplicada cada dosis de la vacuna debe permanecer en nuestras instalaciones por media hora?";
						s2 = MEDIAHORA;
						s3 = "";
						report = new Chreporte();
						report.setHrecdescripcio(s);
						report.setHrecdescripcio2(s2);
						report.setHrectipodescri("Cuestionario Cervarix");
						report.setHrentipoimpres(7);
						report.setHrencodigo(imp_cuestionario_cervix);
						report.setHrenconsulta(consulta.getHcolnumero());
						report.setHredfecharegis(consulta.getHcodfecregistr());
						lstReporte.add(report);

					}

					if (INFORCONSE != null && !INFORCONSE.equals("")) {
						s = " NRecibiN informaciNn suficiente para suscribir el consentimiento informado para la aplicaciNn de la vacuna?";
						s2 = INFORCONSE;
						s3 = "";
						report = new Chreporte();
						report.setHrecdescripcio(s);
						report.setHrecdescripcio2(s2);
						report.setHrectipodescri("Cuestionario Cervarix");
						report.setHrentipoimpres(7);
						report.setHrencodigo(imp_cuestionario_cervix);
						report.setHrenconsulta(consulta.getHcolnumero());
						report.setHredfecharegis(consulta.getHcodfecregistr());
						lstReporte.add(report);
					}

					if (CONSUPROFA != null && !CONSUPROFA.equals("")) {
						s = " NSabe usted que si llegare a presentarse una situaciNn imprevista o que no se considere normal de acuerdo con la  informaciNn, las instrucciones o las explicaciones que a usted se le han brindado en forma verbal y personal, como usuaria/o o como responsable DEBE CONSULTAR EN Profamilia DE MANERA INMEDIATA?";
						s2 = CONSUPROFA;
						s3 = "";
						report = new Chreporte();
						report.setHrecdescripcio(s);
						report.setHrecdescripcio2(s2);
						report.setHrectipodescri("Cuestionario Cervarix");
						report.setHrentipoimpres(7);
						report.setHrencodigo(imp_cuestionario_cervix);
						report.setHrenconsulta(consulta.getHcolnumero());
						report.setHredfecharegis(consulta.getHcodfecregistr());
						lstReporte.add(report);
					}

				}
			}

			if (consulta.getChmotivocons() != null && !consulta.getChmotivocons().isEmpty()) {
				Chmotivocon motivo = null;
				Iterator it = consulta.getChmotivocons().iterator();
				if (it.hasNext())
					motivo = (Chmotivocon) it.next();
				if (motivo != null) {
					Chreporte report = new Chreporte();

					NOMBRE_PROFESIONAL = formatearCampo(NOMBRE_PROFESIONAL);
					CENTRO = formatearCampo(CENTRO);
					DES_MOTIVO_CONSULTA = formatearCampo(DES_MOTIVO_CONSULTA);
					TIPO_CONTACTO = formatearCampo(TIPO_CONTACTO);
					CUAL_CONTACTO = formatearCampo(CUAL_CONTACTO);
					MOTIVO_CONSULTA = formatearCampo(MOTIVO_CONSULTA);
					MANIOBRAS = formatearCampo(MANIOBRAS);
					OBSMANIOBRAS = formatearCampo(OBSMANIOBRAS);
					INTERRUPCION = formatearCampo(INTERRUPCION);
					OBSINTERRUPCION = formatearCampo(OBSINTERRUPCION);
					FINALIDAD = formatearCampo(FINALIDAD);
					TIPO_CONTROL = formatearCampo(TIPO_CONTROL);
					ENFERMEDAD_ACTUAL = formatearCampo(ENFERMEDAD_ACTUAL);
					NOMBRE_ACOMPANANTE = formatearCampo(NOMBRE_ACOMPANANTE);
					TELEFONO_ACOMPANANTE = formatearCampo(TELEFONO_ACOMPANANTE);
					CAUSA_EXTERNA = formatearCampo(CAUSA_EXTERNA);
					FINALIDAD_IVE = formatearCampo(FINALIDAD_IVE);
					EFECTOS_SECUNDARIOS = formatearCampo(EFECTOS_SECUNDARIOS);
					ESCALA_DOLOR = formatearCampo(ESCALA_DOLOR);
					DURACION_DOLOR = formatearCampo(DURACION_DOLOR);
					DOLOR_MEDICO = formatearCampo(DOLOR_MEDICO);
					SANGRO = formatearCampo(SANGRO);
					TIEMPO_SANGRO = formatearCampo(TIEMPO_SANGRO);
					SANGRO_MEDICO = formatearCampo(SANGRO_MEDICO);
					PRESENTO_EXPULSION = formatearCampo(PRESENTO_EXPULSION);
					PRESENTO_POSTERIOR = formatearCampo(PRESENTO_POSTERIOR);
					HORAS_EXPULSION = formatearCampo(HORAS_EXPULSION);
					REPORTE_ECOGRAFIA = formatearCampo(REPORTE_ECOGRAFIA);
					GROSOR_ENDOMETRIAL = formatearCampo(GROSOR_ENDOMETRIAL);
					DOPPLER = formatearCampo(DOPPLER);
					DOPPLER_PN = formatearCampo(DOPPLER_PN);
					COMPLICACIONES = formatearCampo(COMPLICACIONES);
					PLANIFICACION = formatearCampo(PLANIFICACION);
					INICIAR_PLANI = formatearCampo(INICIAR_PLANI);
					METODO_ANTICO = formatearCampo(METODO_ANTICO);

					String s = "";
					String s2 = "";
					String s3 = "";
					String s4 = "";

					s = "";
					s2 = "";
					s3 = "";

					if (CAUSA_EXTERNA != null && !CAUSA_EXTERNA.equals("")) {
						s = (new StringBuilder()).append("Causa Externa :  ").append(formatearCampo(CAUSA_EXTERNA))
								.toString();
					}
					if (FINALIDAD_IVE != null && !FINALIDAD_IVE.equals("")) {
						s2 = (new StringBuilder()).append("Finalidad :  ").append(formatearCampo(FINALIDAD_IVE))
								.toString();
					}
					if (TIPO_CONTROL != null && !TIPO_CONTROL.equals("")) {
						s3 = (new StringBuilder()).append("Tipo de control :  ").append(formatearCampo(TIPO_CONTROL))
								.toString();
					}
					report = new Chreporte();
					if (TIPO_CONTROL != null && !TIPO_CONTROL.equals("")) {
						report.setHrecdescripcio(s3);
					}
					if (CAUSA_EXTERNA != null && !CAUSA_EXTERNA.equals("")) {
						report.setHrecdescripcio2(s);
					}
					if (FINALIDAD_IVE != null && !FINALIDAD_IVE.equals("")) {
						report.setHrecdescripcio3(s2);
					}
					report.setHrectipodescri("Motivo de Consulta");
					report.setHrentipoimpres(5);
					report.setHrencodigo(imp_motivo_consulta);
					report.setHrenconsulta(consulta.getHcolnumero());
					report.setHredfecharegis(consulta.getHcodfecregistr());
					lstReporte.add(report);

					s = "";
					s2 = "";
					s3 = "";
					report = new Chreporte();
					if (MOTIVO_CONSULTA != null && !MOTIVO_CONSULTA.equals("")) {
						s = (new StringBuilder()).append("Motivo de Consulta :  ")
								.append(formatearCampo(MOTIVO_CONSULTA)).toString();

					}

					report = new Chreporte();
					if (MOTIVO_CONSULTA != null && !MOTIVO_CONSULTA.equals("")) {
						report.setHrecdescripcio(s);
					}

					report.setHrectipodescri("Motivo de Consulta");
					report.setHrentipoimpres(1);
					report.setHrencodigo(imp_motivo_consulta);
					report.setHrenconsulta(consulta.getHcolnumero());
					report.setHredfecharegis(consulta.getHcodfecregistr());
					lstReporte.add(report);

					cargarDatosMotivo(consulta);

					s = "";
					s2 = "";
					s3 = "";
					report = new Chreporte();
					if (ENFERMEDAD_ACTUAL != null && !ENFERMEDAD_ACTUAL.equals("")) {

						if (consulta.getChpsicoantec() != null && !consulta.getChpsicoantec().isEmpty()) {

							s = (new StringBuilder())
									.append("Factores relacionados o asociados con la situaciNn actual :  ")
									.append(formatearCampo(ENFERMEDAD_ACTUAL)).toString();
						} else {
							s = (new StringBuilder()).append("Enfermedad Actual :  ")
									.append(formatearCampo(ENFERMEDAD_ACTUAL)).toString();
						}
					}

					if (ENFERMEDAD_ACTUAL != null && !ENFERMEDAD_ACTUAL.equals("")) {
						report.setHrecdescripcio(s);
					}

					report.setHrectipodescri("Motivo de Consulta");
					report.setHrentipoimpres(1);
					report.setHrencodigo(imp_motivo_consulta);
					report.setHrenconsulta(consulta.getHcolnumero());
					report.setHredfecharegis(consulta.getHcodfecregistr());
					lstReporte.add(report);

					imprimirCamposPatologia(consulta);
					s = "";
					s2 = "";
					s3 = "";
					report = new Chreporte();
					if (EFECTOS_SECUNDARIOS != null && !EFECTOS_SECUNDARIOS.equals("")) {
						s = (new StringBuilder()).append("Efectos Secundarios :  ")
								.append(formatearCampo(EFECTOS_SECUNDARIOS)).toString();
					}

					if (EFECTOS_SECUNDARIOS != null && !EFECTOS_SECUNDARIOS.equals("")) {
						report.setHrecdescripcio(s);
					}
					report.setHrectipodescri("Motivo de Consulta");
					report.setHrentipoimpres(1);
					report.setHrencodigo(imp_motivo_consulta);
					report.setHrenconsulta(consulta.getHcolnumero());
					report.setHredfecharegis(consulta.getHcodfecregistr());
					lstReporte.add(report);

					s = "";
					s2 = "";
					s3 = "";
					report = new Chreporte();
					if (ESCALA_DOLOR != null && !ESCALA_DOLOR.equals("")) {
						s = (new StringBuilder()).append("Escala de Dolor/10 :  ").append(formatearCampo(ESCALA_DOLOR))
								.toString();
						s2 = (new StringBuilder()).append("DuraciNn del Dolor :  ")
								.append(formatearCampo(DURACION_DOLOR)).toString();
						s3 = (new StringBuilder()).append("Dolor Obligo a consultar MNdico :  ")
								.append(formatearCampo(DOLOR_MEDICO)).toString();
						report = new Chreporte();
						report.setHrecdescripcio(s);
						report.setHrecdescripcio2(s2);
						report.setHrecdescripcio3(s3);
						report.setHrectipodescri("Motivo de Consulta");
						report.setHrentipoimpres(5);
						report.setHrencodigo(imp_motivo_consulta);
						report.setHrenconsulta(consulta.getHcolnumero());
						report.setHredfecharegis(consulta.getHcodfecregistr());
						lstReporte.add(report);
					}

					s = "";
					s2 = "";
					s3 = "";
					report = new Chreporte();
					if (TIPO_CONTROL != null && !TIPO_CONTROL.equals("")
							&& TIPO_CONTROL.equals("IVE QuirNrgico por Bloqueo")
							|| TIPO_CONTROL.equals("IVE QuirNrgico por Anestesia General")) {
						s = (new StringBuilder()).append("Su sangrado fue comparado con una mestruaciNn :  ")
								.append(formatearCampo(SANGRADO_MESTRU)).toString();
						s2 = (new StringBuilder()).append("Cuanto Tiempo durN con sangrado? :  ")
								.append(formatearCampo(DURACION_SANGRADO)).toString();
						s3 = (new StringBuilder()).append("Sangrado obligo a consultar servicio medico :  ")
								.append(formatearCampo(SANGRADO_MEDICO)).toString();
						report = new Chreporte();
						report.setHrecdescripcio(s);
						report.setHrecdescripcio2(s2);
						report.setHrecdescripcio3(s3);
						report.setHrectipodescri("Motivo de Consulta");
						report.setHrentipoimpres(5);
						report.setHrencodigo(imp_motivo_consulta);
						report.setHrenconsulta(consulta.getHcolnumero());
						report.setHredfecharegis(consulta.getHcodfecregistr());
						lstReporte.add(report);
					}

					s = "";
					s2 = "";
					s3 = "";
					report = new Chreporte();
					if (SANGRO != null && !SANGRO.equals("")) {
						s = (new StringBuilder()).append("SangrN? :  ").append(formatearCampo(SANGRO)).toString();
						report = new Chreporte();
						report.setHrecdescripcio(s);
						report.setHrectipodescri("Motivo de Consulta");
						report.setHrentipoimpres(5);
						report.setHrencodigo(imp_motivo_consulta);
						report.setHrenconsulta(consulta.getHcolnumero());
						report.setHredfecharegis(consulta.getHcodfecregistr());
						lstReporte.add(report);
						if (SANGRO.equals("Si")) {
							s2 = (new StringBuilder())
									.append("Horas de Sangrado despues de iniciada la primera Dosis :  ")
									.append(formatearCampo(TIEMPO_SANGRO)).toString();
							s3 = (new StringBuilder()).append("Sangrado Obligo a consultar MNdico :  ")
									.append(formatearCampo(SANGRO_MEDICO)).toString();
							report = new Chreporte();

							report.setHrecdescripcio2(s2);
							report.setHrecdescripcio3(s3);
							report.setHrectipodescri("Motivo de Consulta");
							report.setHrentipoimpres(5);
							report.setHrencodigo(imp_motivo_consulta);
							report.setHrenconsulta(consulta.getHcolnumero());
							report.setHredfecharegis(consulta.getHcodfecregistr());
							lstReporte.add(report);
						}

					}

					s = "";
					s2 = "";
					s3 = "";
					report = new Chreporte();
					if (PRESENTO_EXPULSION != null && !PRESENTO_EXPULSION.equals("")) {
						s = (new StringBuilder()).append("Presento ExpulsiNn? :  ")
								.append(formatearCampo(PRESENTO_EXPULSION)).toString();
						report = new Chreporte();
						report.setHrecdescripcio(s);

						report.setHrectipodescri("Motivo de Consulta");
						report.setHrentipoimpres(5);
						report.setHrencodigo(imp_motivo_consulta);
						report.setHrenconsulta(consulta.getHcolnumero());
						report.setHredfecharegis(consulta.getHcodfecregistr());
						lstReporte.add(report);

						if (PRESENTO_EXPULSION.equals("Si")) {

							s2 = (new StringBuilder()).append("Se presento posterior a :  ")
									.append(formatearCampo(PRESENTO_POSTERIOR)).toString();
							s3 = (new StringBuilder())
									.append("Cuantas Horas pasaron desde la primera dosis hasta la expulsiNn :  ")
									.append(formatearCampo(HORAS_EXPULSION)).toString();

							report = new Chreporte();

							report.setHrecdescripcio2(s2);
							report.setHrecdescripcio3(s3);
							report.setHrectipodescri("Motivo de Consulta");
							report.setHrentipoimpres(5);
							report.setHrencodigo(imp_motivo_consulta);
							report.setHrenconsulta(consulta.getHcolnumero());
							report.setHredfecharegis(consulta.getHcodfecregistr());
							lstReporte.add(report);
						}

					}

					s = "";
					s2 = "";
					s3 = "";
					s4 = "";
					report = new Chreporte();

					if (REPORTE_ECOGRAFIA != null && !REPORTE_ECOGRAFIA.equals("")) {
						s = (new StringBuilder()).append("Reporta EcografNa? :  ")
								.append(formatearCampo(REPORTE_ECOGRAFIA)).toString();
						report = new Chreporte();
						report.setHrecdescripcio(s);

						report.setHrectipodescri("Motivo de Consulta");
						report.setHrentipoimpres(5);
						report.setHrencodigo(imp_motivo_consulta);
						report.setHrenconsulta(consulta.getHcolnumero());
						report.setHredfecharegis(consulta.getHcodfecregistr());
						lstReporte.add(report);
						if (REPORTE_ECOGRAFIA.equals("Si")) {
							s2 = (new StringBuilder()).append("Grosor Endometrial :  ")
									.append(formatearCampo(GROSOR_ENDOMETRIAL)).toString();
							s3 = (new StringBuilder()).append("Doppler :  ")
									.append(formatearCampo(DOPPLER + " / " + DOPPLER_PN)).toString();

							report = new Chreporte();
							report.setHrecdescripcio2(s2);
							report.setHrecdescripcio3(s3);

							report.setHrectipodescri("Motivo de Consulta");
							report.setHrentipoimpres(5);
							report.setHrencodigo(imp_motivo_consulta);
							report.setHrenconsulta(consulta.getHcolnumero());
							report.setHredfecharegis(consulta.getHcodfecregistr());
							lstReporte.add(report);

							s = "";
							if (COMPLICACIONES != null && !COMPLICACIONES.equals("")) {
								s = (new StringBuilder()).append("Complicaciones :  ")
										.append(formatearCampo(COMPLICACIONES)).toString();
								report = new Chreporte();
								report.setHrecdescripcio(s);

								report.setHrectipodescri("Motivo de Consulta");
								report.setHrentipoimpres(5);
								report.setHrencodigo(imp_motivo_consulta);
								report.setHrenconsulta(consulta.getHcolnumero());
								report.setHredfecharegis(consulta.getHcodfecregistr());
								lstReporte.add(report);
							}

						}

					}

					s = "";
					s2 = "";
					s3 = "";
					s4 = "";
					report = new Chreporte();

					if (PLANIFICACION != null && !PLANIFICACION.equals("")) {

						s = (new StringBuilder()).append("Ya esta planificando? :  ")
								.append(formatearCampo(PLANIFICACION)).toString();
						report = new Chreporte();
						report.setHrecdescripcio(s);
						report.setHrectipodescri("Motivo de Consulta");
						report.setHrentipoimpres(1);
						report.setHrencodigo(imp_motivo_consulta);
						report.setHrenconsulta(consulta.getHcolnumero());
						report.setHredfecharegis(consulta.getHcodfecregistr());
						lstReporte.add(report);
						if (PLANIFICACION.equals("No")) {

							s2 = (new StringBuilder()).append("Iniciar AnticoncepciNn en este Control? :  ")
									.append(formatearCampo(INICIAR_PLANI)).toString();
							s3 = (new StringBuilder()).append("Metodo Anticonceptivo :  ")
									.append(formatearCampo(METODO_ANTICO)).toString();
							report = new Chreporte();
							report.setHrecdescripcio2(s2);
							report.setHrecdescripcio3(s3);
							report.setHrectipodescri("Motivo de Consulta");
							report.setHrentipoimpres(5);
							report.setHrencodigo(imp_motivo_consulta);
							report.setHrenconsulta(consulta.getHcolnumero());
							report.setHredfecharegis(consulta.getHcodfecregistr());
							lstReporte.add(report);
						} else if (PLANIFICACION.equals("Si")) {
							s = "";
							s2 = "";
							s3 = "";
							s = (new StringBuilder()).append("Metodo Anticonceptivo :  ")
									.append(formatearCampo(METODO_ANTICONCEPTIVO)).toString();
							s2 = (new StringBuilder()).append("Tolerancia al metodo actual es :  ")
									.append(formatearCampo(TOLERANCIA_METODO)).toString();
							report = new Chreporte();
							report.setHrecdescripcio(s);
							report.setHrecdescripcio2(s2);
							report.setHrectipodescri("Motivo de Consulta");
							report.setHrentipoimpres(5);
							report.setHrencodigo(imp_motivo_consulta);
							report.setHrenconsulta(consulta.getHcolnumero());
							report.setHredfecharegis(consulta.getHcodfecregistr());
							lstReporte.add(report);
						}

					}

					s = "";
					s2 = "";
					report = new Chreporte();
					if (motivo.getHmccrevisistem() != null && !motivo.getHmccrevisistem().equals("")) {
						s = "";
						s = (new StringBuilder()).append("Revision por Sistemas:             ")
								.append(formatearCampo(motivo.getHmccrevisistem())).toString();
						report = new Chreporte();
						report.setHrecdescripcio(s);
						report.setHrectipodescri("Revision por Sistemas");
						report.setHrencodigo(imp_revision_sistemas);
						report.setHrentipoimpres(Integer.valueOf(1));
						report.setHrenconsulta(consulta.getHcolnumero());
						report.setHredfecharegis(consulta.getHcodfecregistr());
						lstReporte.add(report);
					}
					if (motivo.getHmccgrupsangre() != null && motivo.getHmccfactosangre() != null) {
						s = "";
						s2 = "";
						String descRH = "";
						s = (new StringBuilder()).append("G.S. RH:             ")
								.append(formatearCampo(motivo.getHmccgrupsangre())).toString();
						if (motivo.getHmccfactosangre() != null) {
							if (motivo.getHmccfactosangre().equals("P"))
								descRH = "Positivo (+) ";
							if (motivo.getHmccfactosangre().equals("N"))
								descRH = "Negativo (-) ";
							s = (new StringBuilder()).append(s).append(" ").append(descRH).toString();
						}
						report = new Chreporte();
						report.setHrecdescripcio(s);
						report.setHrectipodescri("Revision por Sistemas");
						report.setHrencodigo(imp_revision_sistemas);
						report.setHrentipoimpres(Integer.valueOf(1));
						report.setHrenconsulta(consulta.getHcolnumero());
						report.setHredfecharegis(consulta.getHcodfecregistr());
						lstReporte.add(report);
					}
					if (motivo.getHmccecografia() != null && !motivo.getHmccecografia().equals("")) {
						s = "";
						s = (new StringBuilder()).append("Ecografia:             ")
								.append(formatearCampo(motivo.getHmccecografia())).toString();
						report = new Chreporte();
						report.setHrecdescripcio(s);
						report.setHrectipodescri("Revision por Sistemas");
						report.setHrencodigo(imp_revision_sistemas);
						report.setHrentipoimpres(Integer.valueOf(1));
						report.setHrenconsulta(consulta.getHcolnumero());
						report.setHredfecharegis(consulta.getHcodfecregistr());
						lstReporte.add(report);
					}

					if (motivo.getHmnencuestaphq9() != null) {
						report = new Chreporte();
						report.setHrectipodescri("Motivo de Consulta");
						report.setHrecdescripcio(
								"Resultado encuesta salud PHQ9:  " + motivo.getHmnencuestaphq9().toString());
						report.setHrencodigo(imp_motivo_consulta);
						report.setHrentipoimpres(1);
						report.setHrenconsulta(consulta.getHcolnumero());
						report.setHredfecharegis(consulta.getHcodfecregistr());
						lstReporte.add(report);
					}
				}
			}

			if (consulta.getChrevissiste() != null && !consulta.getChrevissiste().isEmpty()) {
				Chrevissiste revision = null;
				Iterator it = consulta.getChrevissiste().iterator();
				if (it.hasNext()) {
					revision = (Chrevissiste) it.next();
				}

				if (revision != null) {

					String s = "";
					String s2 = "";
					Chreporte report = new Chreporte();

					s = "Cabeza:  ";
					if (revision.getHrserefiecabez() == null || revision.getHrserefiecabez().equals("N")) {
						s2 = formatearCampoRevision(revision.getHrserefiecabez());
					} else {
						s2 = REVISION_CABEZA_DES;
					}

					report = new Chreporte();
					report.setHrecdescripcio(s);
					report.setHrecdescripcio2(s2);
					report.setHrectipodescri("Revision por Sistemas");
					report.setHrencodigo(imp_revision_sistemas);
					report.setHrentipoimpres(3);
					report.setHrenconsulta(consulta.getHcolnumero());
					report.setHredfecharegis(consulta.getHcodfecregistr());
					if (revision.getHrserefiecabez() != null) {
						lstReporte.add(report);
					}

					s = "Ojos :  ";

					if (revision.getHrserefieojos() == null || revision.getHrserefieojos().equals("N")) {
						s2 = formatearCampoRevision(revision.getHrserefieojos());
					} else {
						s2 = REVISION_OJOS_DES;
					}

					report = new Chreporte();
					report.setHrecdescripcio(s);
					report.setHrecdescripcio2(s2);
					report.setHrectipodescri("Revision por Sistemas");
					report.setHrencodigo(imp_revision_sistemas);
					report.setHrentipoimpres(3);
					report.setHrenconsulta(consulta.getHcolnumero());
					report.setHredfecharegis(consulta.getHcodfecregistr());
					if (revision.getHrserefieojos() != null) {
						lstReporte.add(report);
					}

					s = "ONdos :  ";

					if (revision.getHrserefieoidos() == null || revision.getHrserefieoidos().equals("N")) {
						s2 = formatearCampoRevision(revision.getHrserefieoidos());
					} else {
						s2 = REVISION_OIDOS_DES;
					}

					report = new Chreporte();
					report.setHrecdescripcio(s);
					report.setHrecdescripcio2(s2);
					report.setHrectipodescri("Revision por Sistemas");
					report.setHrencodigo(imp_revision_sistemas);
					report.setHrentipoimpres(3);
					report.setHrenconsulta(consulta.getHcolnumero());
					report.setHredfecharegis(consulta.getHcodfecregistr());
					if (revision.getHrserefieoidos() != null) {
						lstReporte.add(report);
					}

					s = "Nariz:   ";

					if (revision.getHrserefienariz() == null || revision.getHrserefienariz().equals("N")) {
						s2 = formatearCampoRevision(revision.getHrserefienariz());
					} else {
						s2 = REVISION_NARIZ_DES;
					}

					report = new Chreporte();
					report.setHrecdescripcio(s);
					report.setHrecdescripcio2(s2);
					report.setHrectipodescri("Revision por Sistemas");
					report.setHrencodigo(imp_revision_sistemas);
					report.setHrentipoimpres(3);
					report.setHrenconsulta(consulta.getHcolnumero());
					report.setHredfecharegis(consulta.getHcodfecregistr());
					if (revision.getHrserefienariz() != null) {
						lstReporte.add(report);
					}

					s = "Boca:  ";

					if (revision.getHrserefieboca() == null || revision.getHrserefieboca().equals("N")) {
						s2 = formatearCampoRevision(revision.getHrserefieboca());
					} else {
						s2 = REVISION_BOCA_DES;
					}

					report = new Chreporte();
					report.setHrecdescripcio(s);
					report.setHrecdescripcio2(s2);
					report.setHrectipodescri("Revision por Sistemas");
					report.setHrencodigo(imp_revision_sistemas);
					report.setHrentipoimpres(3);
					report.setHrenconsulta(consulta.getHcolnumero());
					report.setHredfecharegis(consulta.getHcodfecregistr());
					if (revision.getHrserefieboca() != null) {
						lstReporte.add(report);
					}

					s = "Garganta:  ";

					if (revision.getHrserefiegarga() == null || revision.getHrserefiegarga().equals("N")) {
						s2 = formatearCampoRevision(revision.getHrserefiegarga());
					} else {
						s2 = REVISION_GARGANTA_DES;
					}

					report = new Chreporte();
					report.setHrecdescripcio(s);
					report.setHrecdescripcio2(s2);
					report.setHrectipodescri("Revision por Sistemas");
					report.setHrencodigo(imp_revision_sistemas);
					report.setHrentipoimpres(3);
					report.setHrenconsulta(consulta.getHcolnumero());
					report.setHredfecharegis(consulta.getHcodfecregistr());
					if (revision.getHrserefiegarga() != null) {
						lstReporte.add(report);
					}

					s = "Cuello:  ";

					if (revision.getHrserefiecuell() == null || revision.getHrserefiecuell().equals("N")) {
						s2 = formatearCampoRevision(revision.getHrserefiecuell());
					} else {
						s2 = REVISION_CUELLO_DES;
					}

					report = new Chreporte();
					report.setHrecdescripcio(s);
					report.setHrecdescripcio2(s2);
					report.setHrectipodescri("Revision por Sistemas");
					report.setHrencodigo(imp_revision_sistemas);
					report.setHrentipoimpres(3);
					report.setHrenconsulta(consulta.getHcolnumero());
					report.setHredfecharegis(consulta.getHcodfecregistr());
					if (revision.getHrserefiecuell() != null) {
						lstReporte.add(report);
					}

					s = "Cardiorrespiratorio:  ";

					if (revision.getHrserefiecardi() == null || revision.getHrserefiecardi().equals("N")) {
						s2 = formatearCampoRevision(revision.getHrserefiecardi());
					} else {
						s2 = REVISION_CARDIO_DES;
					}

					report = new Chreporte();
					report.setHrecdescripcio(s);
					report.setHrecdescripcio2(s2);
					report.setHrectipodescri("Revision por Sistemas");
					report.setHrencodigo(imp_revision_sistemas);
					report.setHrentipoimpres(3);
					report.setHrenconsulta(consulta.getHcolnumero());
					report.setHredfecharegis(consulta.getHcodfecregistr());
					if (revision.getHrserefiecardi() != null) {
						lstReporte.add(report);
					}

					s = "Mamas:   ";

					if (revision.getHrserefiemamas() == null || revision.getHrserefiemamas().equals("N")) {
						s2 = formatearCampoRevision(revision.getHrserefiemamas());
					} else {
						s2 = REVISION_MAMAS_DES;
					}

					report = new Chreporte();
					report.setHrecdescripcio(s);
					report.setHrecdescripcio2(s2);
					report.setHrectipodescri("Revision por Sistemas");
					report.setHrencodigo(imp_revision_sistemas);
					report.setHrentipoimpres(3);
					report.setHrenconsulta(consulta.getHcolnumero());
					report.setHredfecharegis(consulta.getHcodfecregistr());
					if (revision.getHrserefiemamas() != null) {
						lstReporte.add(report);
					}

					s = "Gastrointestinal:  ";

					if (revision.getHrserefiegastr() == null || revision.getHrserefiegastr().equals("N")) {
						s2 = formatearCampoRevision(revision.getHrserefiegastr());
					} else {
						s2 = REVISION_GASTRO_DES;
					}

					report = new Chreporte();
					report.setHrecdescripcio(s);
					report.setHrecdescripcio2(s2);
					report.setHrectipodescri("Revision por Sistemas");
					report.setHrencodigo(imp_revision_sistemas);
					report.setHrentipoimpres(3);
					report.setHrenconsulta(consulta.getHcolnumero());
					report.setHredfecharegis(consulta.getHcodfecregistr());
					if (revision.getHrserefiegastr() != null) {
						lstReporte.add(report);
					}

					s = "Genitourinario:  ";

					if (revision.getHrserefiegenit() == null || revision.getHrserefiegenit().equals("N")) {
						s2 = formatearCampoRevision(revision.getHrserefiegenit());
					} else {
						s2 = REVISION_GENITO_DES;
					}

					report = new Chreporte();
					report.setHrecdescripcio(s);
					report.setHrecdescripcio2(s2);
					report.setHrectipodescri("Revision por Sistemas");
					report.setHrencodigo(imp_revision_sistemas);
					report.setHrentipoimpres(3);
					report.setHrenconsulta(consulta.getHcolnumero());
					report.setHredfecharegis(consulta.getHcodfecregistr());

					if (revision.getHrserefiegenit() != null) {
						lstReporte.add(report);
					}

					s = "VenNreos:   ";

					if (revision.getHrserefievener() == null || revision.getHrserefievener().equals("N")) {
						s2 = formatearCampoRevision(revision.getHrserefievener());
					} else {
						s2 = REVISION_VENEREOS_DES;
					}

					report = new Chreporte();
					report.setHrecdescripcio(s);
					report.setHrecdescripcio2(s2);
					report.setHrectipodescri("Revision por Sistemas");
					report.setHrencodigo(imp_revision_sistemas);
					report.setHrentipoimpres(3);
					report.setHrenconsulta(consulta.getHcolnumero());
					report.setHredfecharegis(consulta.getHcodfecregistr());
					if (revision.getHrserefievener() != null) {
						lstReporte.add(report);
					}

					s = "Endocrino:  ";

					if (revision.getHrserefieendoc() == null || revision.getHrserefieendoc().equals("N")) {
						s2 = formatearCampoRevision(revision.getHrserefieendoc());
					} else {
						s2 = REVISION_ENDOCRINO_DES;
					}

					report = new Chreporte();
					report.setHrecdescripcio(s);
					report.setHrecdescripcio2(s2);
					report.setHrectipodescri("Revision por Sistemas");
					report.setHrencodigo(imp_revision_sistemas);
					report.setHrentipoimpres(3);
					report.setHrenconsulta(consulta.getHcolnumero());
					report.setHredfecharegis(consulta.getHcodfecregistr());
					if (revision.getHrserefieendoc() != null) {
						lstReporte.add(report);
					}

					s = "Locomotor:  ";

					if (revision.getHrserefielocom() == null || revision.getHrserefielocom().equals("N")) {
						s2 = formatearCampoRevision(revision.getHrserefielocom());
					} else {
						s2 = REVISION_LOCOMOTOR_DES;
					}

					report = new Chreporte();
					report.setHrecdescripcio(s);
					report.setHrecdescripcio2(s2);
					report.setHrectipodescri("Revision por Sistemas");
					report.setHrencodigo(imp_revision_sistemas);
					report.setHrentipoimpres(3);
					report.setHrenconsulta(consulta.getHcolnumero());
					report.setHredfecharegis(consulta.getHcodfecregistr());
					if (revision.getHrserefielocom() != null) {
						lstReporte.add(report);
					}

					s = "Neuromuscular y neuropsiquiNtrico:  ";

					if (revision.getHrserefieneuro() == null || revision.getHrserefieneuro().equals("N")) {
						s2 = formatearCampoRevision(revision.getHrserefieneuro());
					} else {
						s2 = REVISION_NEUROMUSCULAR_DES;
					}

					report = new Chreporte();
					report.setHrecdescripcio(s);
					report.setHrecdescripcio2(s2);
					report.setHrectipodescri("Revision por Sistemas");
					report.setHrencodigo(imp_revision_sistemas);
					report.setHrentipoimpres(3);
					report.setHrenconsulta(consulta.getHcolnumero());
					report.setHredfecharegis(consulta.getHcodfecregistr());
					if (revision.getHrserefieneuro() != null) {
						lstReporte.add(report);
					}

					s = "NeuropsiquiNtrico:  ";

					if (revision.getHrserefieneups() == null || revision.getHrserefieneups().equals("N")) {
						s2 = formatearCampoRevision(revision.getHrserefieneups());
					} else {
						s2 = REVISION_NEUROSIQUIATRICO_DES;
					}

					report = new Chreporte();
					report.setHrecdescripcio(s);
					report.setHrecdescripcio2(s2);
					report.setHrectipodescri("Revision por Sistemas");
					report.setHrencodigo(imp_revision_sistemas);
					report.setHrentipoimpres(3);
					report.setHrenconsulta(consulta.getHcolnumero());
					report.setHredfecharegis(consulta.getHcodfecregistr());
					if (revision.getHrserefieneups() != null) {
						lstReporte.add(report);
					}

					s = "Neuromuscular:  ";

					if (revision.getHrserefieneumu() == null || revision.getHrserefieneumu().equals("N")) {
						s2 = formatearCampoRevision(revision.getHrserefieneumu());
					} else {
						s2 = REVISION_NEUROMUSCULAR_D;
					}

					report = new Chreporte();
					report.setHrecdescripcio(s);
					report.setHrecdescripcio2(s2);
					report.setHrectipodescri("Revision por Sistemas");
					report.setHrencodigo(imp_revision_sistemas);
					report.setHrentipoimpres(3);
					report.setHrenconsulta(consulta.getHcolnumero());
					report.setHredfecharegis(consulta.getHcodfecregistr());
					if (revision.getHrserefieneumu() != null) {
						lstReporte.add(report);
					}

					s = "Piel y anexos:  ";

					if (revision.getHrserefiepiel() == null || revision.getHrserefiepiel().equals("N")) {
						s2 = formatearCampoRevision(revision.getHrserefiepiel());
					} else {
						s2 = REVISION_PIEL_DES;
					}

					report = new Chreporte();
					report.setHrecdescripcio(s);
					report.setHrecdescripcio2(s2);
					report.setHrectipodescri("Revision por Sistemas");
					report.setHrencodigo(imp_revision_sistemas);
					report.setHrentipoimpres(3);
					report.setHrenconsulta(consulta.getHcolnumero());
					report.setHredfecharegis(consulta.getHcodfecregistr());
					if (revision.getHrserefiepiel() != null) {
						lstReporte.add(report);
					}

					if (revision.getHrserefielepra() != null) {
						s = "Usuario Es sintomNtico respiratorio (Tuberculosis):  ";

						if (revision.getHrserefietuber() == null || revision.getHrserefietuber().equals("N")) {
							s2 = formatearCampoRevision(revision.getHrserefietuber());
						} else {
							s2 = revision.getHrscrefietuber();
						}

						report = new Chreporte();
						report.setHrecdescripcio(s);
						report.setHrecdescripcio2(s2);
						report.setHrectipodescri("Revision por Sistemas");
						report.setHrencodigo(imp_revision_sistemas);
						report.setHrentipoimpres(3);
						report.setHrenconsulta(consulta.getHcolnumero());
						report.setHredfecharegis(consulta.getHcodfecregistr());
						if (revision.getHrserefietuber() != null) {
							lstReporte.add(report);
						}

					}

					if (revision.getHrserefielepra() != null) {
						s = "Usuario es sintomNtico de piel (Lepra):  ";

						if (revision.getHrserefielepra() == null || revision.getHrserefielepra().equals("N")) {
							s2 = formatearCampoRevision(revision.getHrserefielepra());
						} else {
							s2 = revision.getHrscrefielepra();
						}

						report = new Chreporte();
						report.setHrecdescripcio(s);
						report.setHrecdescripcio2(s2);
						report.setHrectipodescri("Revision por Sistemas");
						report.setHrencodigo(imp_revision_sistemas);
						report.setHrentipoimpres(3);
						report.setHrenconsulta(consulta.getHcolnumero());
						report.setHredfecharegis(consulta.getHcodfecregistr());

						lstReporte.add(report);

					}

					if (revision.getHrserefiedismeno() != null || revision.getHrserefiedispar() != null) {
						String dismeno = "No Refiere";
						String dispar = "No Refiere";
						if (revision.getHrscrefiedismeno() != null && revision.getHrserefiedismeno().equals("R")) {
							dismeno = revision.getHrscrefiedismeno();
						}
						if (revision.getHrscrefiedispar() != null && revision.getHrserefiedispar().equals("R")) {
							dispar = revision.getHrscrefiedispar();
						}
						report = new Chreporte();
						report.setHrecdescripcio("Dismenorrea: ");
						report.setHrecdescripcio2(dismeno);
						report.setHrectipodescri("Revision por Sistemas");
						report.setHrencodigo(imp_revision_sistemas);
						report.setHrentipoimpres(3);
						report.setHrenconsulta(consulta.getHcolnumero());
						report.setHredfecharegis(consulta.getHcodfecregistr());

						lstReporte.add(report);

						report = new Chreporte();
						report.setHrecdescripcio("Dispareunia: ");
						report.setHrecdescripcio2(dispar);
						report.setHrectipodescri("Revision por Sistemas");
						report.setHrencodigo(imp_revision_sistemas);
						report.setHrentipoimpres(3);
						report.setHrenconsulta(consulta.getHcolnumero());
						report.setHredfecharegis(consulta.getHcodfecregistr());

						lstReporte.add(report);

					}

				}

			}

			if (consulta.getChvalorprean() != null && !consulta.getChvalorprean().isEmpty()) {
				Chvalorprean valorprean = null;
				Iterator it = consulta.getChvalorprean().iterator();
				if (it.hasNext()) {
					valorprean = (Chvalorprean) it.next();
				}

				if (valorprean != null) {

					Chreporte report = new Chreporte();
					String s = null;

					if (valorprean.getHvpcintervenci() != null) {
						s = "IntervenciNn(es) Propuesta(s) " + INTERVENCION_PREANESTESIA;
					} else {
						s = "IntervenciNn(es) Propuesta(s) " + valorprean.getHvpcinterpopue();
					}

					String s2 = "";
					String s3 = "";

					report = new Chreporte();
					report.setHrecdescripcio(s);
					report.setHrecdescripcio2("");
					report.setHrecdescripcio3("");
					report.setHrectipodescri("Valoracion Preanestesia ");
					report.setHrencodigo(imp_valoracion_preanestesia);
					report.setHrentipoimpres(1);
					report.setHrenconsulta(consulta.getHcolnumero());
					report.setHredfecharegis(consulta.getHcodfecregistr());
					lstReporte.add(report);

					s = "Cirujano(s) " + MEDICOS_ANESTESIA;
					s2 = "";
					s3 = "";

					if (valorprean.getHvpccirujano() != null) {
						report = new Chreporte();
						report.setHrecdescripcio(s);
						report.setHrecdescripcio2("");
						report.setHrecdescripcio3("");
						report.setHrectipodescri("Valoracion Preanestesia ");
						report.setHrencodigo(imp_valoracion_preanestesia);
						report.setHrentipoimpres(1);
						report.setHrenconsulta(consulta.getHcolnumero());
						report.setHredfecharegis(consulta.getHcodfecregistr());
						lstReporte.add(report);
					}

				}

			}

			if (consulta.getChcuestanest() != null && !consulta.getChcuestanest().isEmpty()) {
				Chcuestanest cuestionario = null;
				Iterator it = consulta.getChcuestanest().iterator();

				while (it.hasNext()) {
					cuestionario = (Chcuestanest) it.next();

					if (cuestionario != null) {

						Chreporte report = new Chreporte();

						String s = "";

						try {
							s = cuestionario.getHcanpregunta() + "-   " + this.serviceLocator.getClinicoService()
									.getDescripcionCuestionarioAnestesia(cuestionario.getHcanpregunta());
						} catch (ModelException e) {
							e.printStackTrace();
						}

						String s3 = "";

						s3 = formatearCampo(cuestionario.getHcacanotacion());

						String s2 = formatearCampo(cuestionario.getHcacrespuesta());

						report.setHrecdescripcio(s);
						report.setHrecdescripcio2(s2);
						report.setHrecdescripcio3(s3);
						report.setHrentipoimpres(7);
						report.setHrectipodescri("Cuestionario Preanestesia");
						report.setHrencodigo(imp_cuestionario_preanestesia);
						report.setHrenconsulta(consulta.getHcolnumero());
						report.setHredfecharegis(consulta.getHcodfecregistr());
						lstReporte.add(report);

					}

				}

				if (cuestionario.getHcacobservacio() != null) {
					Chreporte report = new Chreporte();

					String s = "Obervaciones: " + cuestionario.getHcacobservacio();
					String s3 = "";
					String s2 = "";

					report.setHrecdescripcio(s);
					report.setHrecdescripcio2(s2);
					report.setHrecdescripcio3(s3);
					report.setHrentipoimpres(7);
					report.setHrectipodescri("Cuestionario Preanestesia");
					report.setHrencodigo(imp_cuestionario_preanestesia);
					report.setHrenconsulta(consulta.getHcolnumero());
					report.setHredfecharegis(consulta.getHcodfecregistr());
					lstReporte.add(report);
				}
			}

			if (consulta.getChestermascu() != null && !consulta.getChestermascu().isEmpty()) {

				Chestermascu esterilizacion = null;
				Iterator it = consulta.getChestermascu().iterator();
				if (it.hasNext()) {
					esterilizacion = (Chestermascu) it.next();
				}

				if (esterilizacion != null) {

					Chreporte report = new Chreporte();
					String s = "";
					String s2 = "";
					String s3 = "";

					s = "";
					s = "1. RecibiN usted informaciNn o asesorNa sobre todos los mNtodos temporales de planificaciNn familiar? ";
					s2 = HEMCINFORMETOD;
					s3 = HEMCACLARINFOR;
					report = new Chreporte();
					report.setHrecdescripcio(s);
					report.setHrecdescripcio2(s2);
					report.setHrecdescripcio3(s3);
					report.setHrentipoimpres(7);
					report.setHrectipodescri("Cuestionario EsterilizaciNn Masculina");
					report.setHrencodigo(imp_cuestionario_masculino);
					report.setHrenconsulta(consulta.getHcolnumero());
					report.setHredfecharegis(consulta.getHcodfecregistr());
					lstReporte.add(report);

					s = "";
					s = "2. Sabe usted que la vasectomNa es un mNtodo definitivo de planificaciNn familiar para el hombre? ";
					s2 = HEMCVASECDEFIN;
					s3 = HEMCACLARDEFIN;
					report = new Chreporte();
					report.setHrecdescripcio(s);
					report.setHrecdescripcio2(s2);
					report.setHrecdescripcio3(s3);
					report.setHrentipoimpres(7);
					report.setHrectipodescri("Cuestionario EsterilizaciNn Masculina");
					report.setHrencodigo(imp_cuestionario_masculino);
					report.setHrenconsulta(consulta.getHcolnumero());
					report.setHredfecharegis(consulta.getHcodfecregistr());
					lstReporte.add(report);

					s = "";
					s = "3. Sabe usted que la vasectomNa puede fallar, aun aNos despuNs, en uno de cada 500 operados?  ";
					s2 = HEMCVASECFALLA;
					s3 = HEMCACLARFALLA;
					report = new Chreporte();
					report.setHrecdescripcio(s);
					report.setHrecdescripcio2(s2);
					report.setHrecdescripcio3(s3);
					report.setHrentipoimpres(7);
					report.setHrectipodescri("Cuestionario EsterilizaciNn Masculina");
					report.setHrencodigo(imp_cuestionario_masculino);
					report.setHrenconsulta(consulta.getHcolnumero());
					report.setHredfecharegis(consulta.getHcodfecregistr());
					if (HEMCVASECFALLA != null && !HEMCVASECFALLA.equals("")) {
						lstReporte.add(report);
					}

					s = "";
					s = "3. Sabe usted que la vasectomNa puede fallar, aun aNos despuNs, entre 1 y 5 de cada 100  ?  ";
					s2 = HEMCVASECFALLANUEVO;
					s3 = HEMCACLARFALLANUEVO;
					report = new Chreporte();
					report.setHrecdescripcio(s);
					report.setHrecdescripcio2(s2);
					report.setHrecdescripcio3(s3);
					report.setHrentipoimpres(7);
					report.setHrectipodescri("Cuestionario EsterilizaciNn Masculina");
					report.setHrencodigo(imp_cuestionario_masculino);
					report.setHrenconsulta(consulta.getHcolnumero());
					report.setHredfecharegis(consulta.getHcodfecregistr());
					if (HEMCVASECFALLANUEVO != null && !HEMCVASECFALLANUEVO.equals("")) {
						lstReporte.add(report);
					}

					s = "";
					s = "4. Sabe usted que es necesario comprobar el Nxito de la vasectomNa, realizNndose un espermograma de control a los tres meses de operado? ";
					s2 = HEMCEXITOESPER;
					s3 = HEMCACLAREXITO;
					report = new Chreporte();
					report.setHrecdescripcio(s);
					report.setHrecdescripcio2(s2);
					report.setHrecdescripcio3(s3);
					report.setHrentipoimpres(7);
					report.setHrectipodescri("Cuestionario EsterilizaciNn Masculina");
					report.setHrencodigo(imp_cuestionario_masculino);
					report.setHrenconsulta(consulta.getHcolnumero());
					report.setHredfecharegis(consulta.getHcodfecregistr());
					lstReporte.add(report);

					s = "";
					s = "5. RecibiN informaciNn suficiente para suscribir el consentimiento informado para vasectomNa? ";
					s2 = HEMCINFORSUFIC;
					s3 = HEMCACLARSUFIC;
					report = new Chreporte();
					report.setHrecdescripcio(s);
					report.setHrecdescripcio2(s2);
					report.setHrecdescripcio3(s3);
					report.setHrentipoimpres(7);
					report.setHrectipodescri("Cuestionario EsterilizaciNn Masculina");
					report.setHrencodigo(imp_cuestionario_masculino);
					report.setHrenconsulta(consulta.getHcolnumero());
					report.setHredfecharegis(consulta.getHcodfecregistr());
					lstReporte.add(report);

				}
			}

			if (consulta.getChcuestplanis() != null && !consulta.getChcuestplanis().isEmpty()) {

				String descripcionMetodo = "";
				Chcuestplani cuestionarioplani = null;
				Iterator it = consulta.getChcuestplanis().iterator();
				if (it.hasNext()) {
					cuestionarioplani = (Chcuestplani) it.next();
				}

				if (cuestionarioplani != null) {

					if (cuestionarioplani.getHcpcmetodoplan() != null) {
						try {
							descripcionMetodo = this.serviceLocator.getClinicoService()
									.getDescripcionMetodo(cuestionarioplani.getHcpcmetodoplan());
						} catch (ModelException e) {
							e.printStackTrace();
						}
					}

					Chreporte report = new Chreporte();
					report = new Chreporte();
					report.setHrecdescripcio(
							"RecibiN usted informaciNn o asesorNa sobre todos los mNtodos temporales de planificaciNn familiar?  ");
					report.setHrecdescripcio2(formatearCampo(cuestionarioplani.getHcpcmetotempla()));
					report.setHrecdescripcio3("");
					report.setHrectipodescri("Cuestionario PlanificaciNn ");
					report.setHrencodigo(imp_cuestionario_planificacion);
					report.setHrentipoimpres(10);
					report.setHrenconsulta(consulta.getHcolnumero());
					report.setHredfecharegis(consulta.getHcodfecregistr());
					lstReporte.add(report);

					report = new Chreporte();
					report.setHrecdescripcio(
							"RecibiN usted informaciNn o asesorNa sobre todos los mNtodos definitivos de  planificaciNn familiar? ");
					report.setHrecdescripcio2(formatearCampo(cuestionarioplani.getHcpcmetodefpla()));
					report.setHrecdescripcio3("");
					report.setHrectipodescri("Cuestionario PlanificaciNn ");
					report.setHrencodigo(imp_cuestionario_planificacion);
					report.setHrentipoimpres(10);
					report.setHrenconsulta(consulta.getHcolnumero());
					report.setHredfecharegis(consulta.getHcodfecregistr());
					lstReporte.add(report);

					report = new Chreporte();
					report.setHrecdescripcio("EstN usted embarazada o cree que lo estN? ");
					report.setHrecdescripcio2(formatearCampo(cuestionarioplani.getHcpcembarazada()));
					report.setHrecdescripcio3("");
					report.setHrectipodescri("Cuestionario PlanificaciNn ");
					report.setHrencodigo(imp_cuestionario_planificacion);
					report.setHrentipoimpres(10);
					report.setHrenconsulta(consulta.getHcolnumero());
					report.setHredfecharegis(consulta.getHcodfecregistr());
					lstReporte.add(report);

					if (cuestionarioplani.getHcpcmestnormal() != null
							&& !cuestionarioplani.getHcpcmestnormal().equals("")) {
						report = new Chreporte();
						report.setHrecdescripcio("Su Nltima mestruaciNn fue normal? ");
						report.setHrecdescripcio2(formatearCampo(cuestionarioplani.getHcpcmestnormal()));
						report.setHrecdescripcio3("");
						if (cuestionarioplani.getHcpdfechultmes() != null) {
							report.setHrecdescripcio3(
									"F.U.R. : " + formatearCampo(cuestionarioplani.getHcpdfechultmes()));
						}
					}

					report.setHrectipodescri("Cuestionario PlanificaciNn ");
					report.setHrencodigo(imp_cuestionario_planificacion);
					report.setHrentipoimpres(10);
					report.setHrenconsulta(consulta.getHcolnumero());
					report.setHredfecharegis(consulta.getHcodfecregistr());
					lstReporte.add(report);

					report = new Chreporte();
					report.setHrecdescripcio(
							"Sabe usted que los mNtodos temporales pueden fallar aun usNndolos consistentemente? ");
					report.setHrecdescripcio2(formatearCampo(cuestionarioplani.getHcpcfallametem()));
					report.setHrecdescripcio3("");
					report.setHrectipodescri("Cuestionario PlanificaciNn ");
					report.setHrencodigo(imp_cuestionario_planificacion);
					report.setHrentipoimpres(10);
					report.setHrenconsulta(consulta.getHcolnumero());
					report.setHredfecharegis(consulta.getHcodfecregistr());
					lstReporte.add(report);

					report = new Chreporte();
					report.setHrecdescripcio(
							"Sabe usted que los mNtodos de anticoncepciNn no se emplean como mNtodo para interrupciNn del embarazo? ");
					report.setHrecdescripcio2(formatearCampo(cuestionarioplani.getHcpcmetintemb()));
					report.setHrecdescripcio3("");
					report.setHrectipodescri("Cuestionario PlanificaciNn ");
					report.setHrencodigo(imp_cuestionario_planificacion);
					report.setHrentipoimpres(10);
					report.setHrenconsulta(consulta.getHcolnumero());
					report.setHredfecharegis(consulta.getHcodfecregistr());
					lstReporte.add(report);

					report = new Chreporte();
					report.setHrecdescripcio(
							"RecibiN informaciNn suficiente para suscribir el consentimiento informado para el mNtodo  temporal solicitado ");
					report.setHrecdescripcio2(formatearCampo(cuestionarioplani.getHcpcinfometoso()));
					report.setHrecdescripcio3("");
					report.setHrectipodescri("Cuestionario PlanificaciNn ");
					report.setHrencodigo(imp_cuestionario_planificacion);
					report.setHrentipoimpres(10);
					report.setHrenconsulta(consulta.getHcolnumero());
					report.setHredfecharegis(consulta.getHcodfecregistr());
					lstReporte.add(report);

					if (cuestionarioplani.getHcpcusametopla() != null
							&& !cuestionarioplani.getHcpcusametopla().equals("")) {
						report = new Chreporte();

						report.setHrecdescripcio(
								"Usted o su pareja utilizan actualmente un mNtodo de planificaciNn familiar? ");
						report.setHrecdescripcio2(formatearCampo(cuestionarioplani.getHcpcusametopla()));
						report.setHrecdescripcio3("");
						if (cuestionarioplani.getHcpcmetodoplan() != null) {
							report.setHrecdescripcio3("Cual? " + descripcionMetodo);
						}
						report.setHrectipodescri("Cuestionario PlanificaciNn ");
						report.setHrencodigo(imp_cuestionario_planificacion);
						report.setHrentipoimpres(10);
						report.setHrenconsulta(consulta.getHcolnumero());
						report.setHredfecharegis(consulta.getHcodfecregistr());
						lstReporte.add(report);
					}

					if (cuestionarioplani.getHcpcpartoabort() != null
							&& !cuestionarioplani.getHcpcpartoabort().equals("")) {
						report = new Chreporte();
						report.setHrecdescripcio("Ha tenido partos y/o Abortos ");
						report.setHrecdescripcio2(formatearCampo(cuestionarioplani.getHcpcpartoabort()));
						report.setHrecdescripcio3("");
						if (cuestionarioplani.getHcpdfechaparto() != null) {
							report.setHrecdescripcio3(
									"F.U.P. : " + formatearCampo(cuestionarioplani.getHcpdfechaparto()));
						}
						report.setHrectipodescri("Cuestionario PlanificaciNn ");
						report.setHrencodigo(imp_cuestionario_planificacion);
						report.setHrentipoimpres(10);
						report.setHrenconsulta(consulta.getHcolnumero());
						report.setHredfecharegis(consulta.getHcodfecregistr());
						lstReporte.add(report);
					}

				}

			}

			if (consulta.getChantecegenes() != null && !consulta.getChantecegenes().isEmpty()) {

				Chreporte report = new Chreporte();

				if (SIN_ANTECEDENTES != null && !SIN_ANTECEDENTES.equals("")) {
					report = new Chreporte();
					report.setHrectipodescri("Antecedentes");
					report.setHrecdescripcio("Sin Antecedentes Nuevos ");
					report.setHrecdescripcio2(formatearCampo(SIN_ANTECEDENTES));
					report.setHrencodigo(imp_antecedentes);
					report.setHrentipoimpres(3);
					report.setHrenconsulta(consulta.getHcolnumero());
					report.setHredfecharegis(consulta.getHcodfecregistr());
					lstReporte.add(report);
				}

				if (ANTECEDENTE_ALERGICOS != null && !ANTECEDENTE_ALERGICOS.equals("")) {
					report = new Chreporte();
					report.setHrectipodescri("Antecedentes");
					report.setHrecdescripcio("Antecedentes Alergicos ");
					report.setHrecdescripcio2(formatearCampo(ANTECEDENTE_ALERGICOS));
					report.setHrencodigo(imp_antecedentes);
					report.setHrentipoimpres(3);
					report.setHrenconsulta(consulta.getHcolnumero());
					report.setHredfecharegis(consulta.getHcodfecregistr());
					lstReporte.add(report);
				}
				if (CUALES_MEDICAMENTOS != null && !CUALES_MEDICAMENTOS.equals("")) {
					report = new Chreporte();
					report.setHrectipodescri("Antecedentes");
					report.setHrecdescripcio("Antecedentes Alergicos(MEDICAMENTO) ");
					report.setHrecdescripcio2(formatearCampo(CUALES_MEDICAMENTOS));
					report.setHrencodigo(imp_antecedentes);
					report.setHrentipoimpres(3);
					report.setHrenconsulta(consulta.getHcolnumero());
					report.setHredfecharegis(consulta.getHcodfecregistr());
					lstReporte.add(report);
				}
				if (CUALES_ALIMENTOS != null && !CUALES_ALIMENTOS.equals("")) {
					report = new Chreporte();
					report.setHrectipodescri("Antecedentes");
					report.setHrecdescripcio("Antecedentes Alergicos(ALIMENTO) ");
					report.setHrecdescripcio2(formatearCampo(CUALES_ALIMENTOS));
					report.setHrencodigo(imp_antecedentes);
					report.setHrentipoimpres(3);
					report.setHrenconsulta(consulta.getHcolnumero());
					report.setHredfecharegis(consulta.getHcodfecregistr());
					lstReporte.add(report);
				}
				if (CUALES_SAMBIENTE != null && !CUALES_SAMBIENTE.equals("")) {
					report = new Chreporte();
					report.setHrectipodescri("Antecedentes");
					report.setHrecdescripcio("Antecedentes Alergicos(SUSTANCIA DEL AMBIENTE) ");
					report.setHrecdescripcio2(formatearCampo(CUALES_SAMBIENTE));
					report.setHrencodigo(imp_antecedentes);
					report.setHrentipoimpres(3);
					report.setHrenconsulta(consulta.getHcolnumero());
					report.setHredfecharegis(consulta.getHcodfecregistr());
					lstReporte.add(report);
				}
				if (CUALES_SPIEL != null && !CUALES_SPIEL.equals("")) {
					report = new Chreporte();
					report.setHrectipodescri("Antecedentes");
					report.setHrecdescripcio("Antecedentes Alergicos(SUSTANCIA QUE ENTRA EN CONTACTO CON LA PIEL ) ");
					report.setHrecdescripcio2(formatearCampo(CUALES_SPIEL));
					report.setHrencodigo(imp_antecedentes);
					report.setHrentipoimpres(3);
					report.setHrenconsulta(consulta.getHcolnumero());
					report.setHredfecharegis(consulta.getHcodfecregistr());
					lstReporte.add(report);
				}
				if (CUALES_PINSECTO != null && !CUALES_PINSECTO.equals("")) {
					report = new Chreporte();
					report.setHrectipodescri("Antecedentes");
					report.setHrecdescripcio("Antecedentes Alergicos(PICADURA DE INSECTO) ");
					report.setHrecdescripcio2(formatearCampo(CUALES_PINSECTO));
					report.setHrencodigo(imp_antecedentes);
					report.setHrentipoimpres(3);
					report.setHrenconsulta(consulta.getHcolnumero());
					report.setHredfecharegis(consulta.getHcodfecregistr());
					lstReporte.add(report);
				}
				if (CUALES_OTRA != null && !CUALES_OTRA.equals("")) {
					report = new Chreporte();
					report.setHrectipodescri("Antecedentes");
					report.setHrecdescripcio("Antecedentes Alergicos(OTRA) ");
					report.setHrecdescripcio2(formatearCampo(CUALES_OTRA));
					report.setHrencodigo(imp_antecedentes);
					report.setHrentipoimpres(3);
					report.setHrenconsulta(consulta.getHcolnumero());
					report.setHredfecharegis(consulta.getHcodfecregistr());
					lstReporte.add(report);
				}

				if (ANTECEDENTES_FAMILIARES != null && !ANTECEDENTES_FAMILIARES.equals("")) {
					report = new Chreporte();
					report.setHrectipodescri("Antecedentes");
					report.setHrecdescripcio("Antecedentes Familiares");
					report.setHrecdescripcio2(formatearCampo(ANTECEDENTES_FAMILIARES));
					report.setHrencodigo(imp_antecedentes);
					report.setHrentipoimpres(3);
					report.setHrenconsulta(consulta.getHcolnumero());
					report.setHredfecharegis(consulta.getHcodfecregistr());
					lstReporte.add(report);
				}

				if (ANTECEDENTES_ITS != null && !ANTECEDENTES_ITS.equals("")) {

					report = new Chreporte();
					report.setHrectipodescri("Antecedentes");
					report.setHrecdescripcio("Antecedentes ITS");
					report.setHrecdescripcio2(formatearCampo(ANTECEDENTES_ITS));
					report.setHrencodigo(imp_antecedentes);
					report.setHrentipoimpres(3);
					report.setHrenconsulta(consulta.getHcolnumero());
					report.setHredfecharegis(consulta.getHcodfecregistr());
					lstReporte.add(report);
				}

				if (ANTECEDENTES_PATOLOGICOS != null && !ANTECEDENTES_PATOLOGICOS.equals("")) {
					report = new Chreporte();
					report.setHrectipodescri("Antecedentes");
					report.setHrecdescripcio("Antecedentes Patologicos");
					report.setHrecdescripcio2(formatearCampo(ANTECEDENTES_PATOLOGICOS));
					report.setHrencodigo(imp_antecedentes);
					report.setHrentipoimpres(3);
					report.setHrenconsulta(consulta.getHcolnumero());
					report.setHredfecharegis(consulta.getHcodfecregistr());
					lstReporte.add(report);
				}

				if (ANTECEDENTES_QUIRURGICOS != null && !ANTECEDENTES_QUIRURGICOS.equals("")) {
					report = new Chreporte();
					report.setHrectipodescri("Antecedentes");
					report.setHrecdescripcio("Antecedentes Quirurgicos ");
					report.setHrecdescripcio2(formatearCampo(ANTECEDENTES_QUIRURGICOS));
					report.setHrencodigo(imp_antecedentes);
					report.setHrentipoimpres(3);
					report.setHrenconsulta(consulta.getHcolnumero());
					report.setHredfecharegis(consulta.getHcodfecregistr());
					lstReporte.add(report);

				}
				if (ANTECEDENTES_TOXICOS != null && !ANTECEDENTES_TOXICOS.equals("")) {
					report = new Chreporte();
					report.setHrectipodescri("Antecedentes");
					report.setHrecdescripcio("Antecedentes Toxicos");
					report.setHrecdescripcio2(formatearCampo(ANTECEDENTES_TOXICOS));
					report.setHrencodigo(imp_antecedentes);
					report.setHrentipoimpres(3);
					report.setHrenconsulta(consulta.getHcolnumero());
					report.setHredfecharegis(consulta.getHcodfecregistr());
					lstReporte.add(report);
				}

				if (ANTECEDENTES_TRANSFUNCIONALES != null && !ANTECEDENTES_TRANSFUNCIONALES.equals("")) {
					report = new Chreporte();
					report.setHrectipodescri("Antecedentes");
					report.setHrecdescripcio("Antecedentes Tranfusionales");
					report.setHrecdescripcio2(formatearCampo(ANTECEDENTES_TRANSFUNCIONALES));
					report.setHrencodigo(imp_antecedentes);
					report.setHrentipoimpres(3);
					report.setHrenconsulta(consulta.getHcolnumero());
					report.setHredfecharegis(consulta.getHcodfecregistr());
					lstReporte.add(report);
				}
				if (ANTECEDENTES_TRAUMATICOS != null && !ANTECEDENTES_TRAUMATICOS.equals("")) {
					report = new Chreporte();
					report.setHrectipodescri("Antecedentes");
					report.setHrecdescripcio2(formatearCampo(ANTECEDENTES_TRAUMATICOS));
					report.setHrecdescripcio("Antecedentes Traumaticos ");
					report.setHrencodigo(imp_antecedentes);
					report.setHrentipoimpres(3);
					report.setHrenconsulta(consulta.getHcolnumero());
					report.setHredfecharegis(consulta.getHcodfecregistr());
					lstReporte.add(report);
				}

				if (ANTECEDENTES_FARMACOLOGICOS != null && !ANTECEDENTES_FARMACOLOGICOS.equals("")) {
					report = new Chreporte();
					report.setHrectipodescri("Antecedentes");
					report.setHrecdescripcio("Antecedentes Farmacologicos:");
					report.setHrecdescripcio2(formatearCampo(ANTECEDENTES_FARMACOLOGICOS));
					report.setHrencodigo(imp_antecedentes);
					report.setHrentipoimpres(3);
					report.setHrenconsulta(consulta.getHcolnumero());
					report.setHredfecharegis(consulta.getHcodfecregistr());
					lstReporte.add(report);
				}

				if (ANTECEDENTES_MEDICACION != null && !ANTECEDENTES_MEDICACION.equals("")) {
					report = new Chreporte();
					report.setHrectipodescri("Antecedentes");
					report.setHrecdescripcio("Antecedentes MedicaciNn Embarazo:");
					report.setHrecdescripcio2(formatearCampo(ANTECEDENTES_MEDICACION));
					report.setHrencodigo(imp_antecedentes);
					report.setHrentipoimpres(3);
					report.setHrenconsulta(consulta.getHcolnumero());
					report.setHredfecharegis(consulta.getHcodfecregistr());
					lstReporte.add(report);
				}

				if (ANTECEDENTES_PARTO != null && !ANTECEDENTES_PARTO.equals("")) {
					report = new Chreporte();
					report.setHrectipodescri("Antecedentes");
					report.setHrecdescripcio("Antecedentes parto:");
					report.setHrecdescripcio2(formatearCampo(ANTECEDENTES_PARTO));
					report.setHrencodigo(imp_antecedentes);
					report.setHrentipoimpres(3);
					report.setHrenconsulta(consulta.getHcolnumero());
					report.setHredfecharegis(consulta.getHcodfecregistr());
					lstReporte.add(report);
				}

				if (ANTECEDENTES_COMPLICACIONES != null && !ANTECEDENTES_COMPLICACIONES.equals("")) {
					report = new Chreporte();
					report.setHrectipodescri("Antecedentes");
					report.setHrecdescripcio("Antecedentes complicaciones perinatales:");
					report.setHrecdescripcio2(formatearCampo(ANTECEDENTES_COMPLICACIONES));
					report.setHrencodigo(imp_antecedentes);
					report.setHrentipoimpres(3);
					report.setHrenconsulta(consulta.getHcolnumero());
					report.setHredfecharegis(consulta.getHcodfecregistr());
					lstReporte.add(report);
				}

				if (ANTECEDENTES_INMUNIZACIONES != null && !ANTECEDENTES_INMUNIZACIONES.equals("")) {
					report = new Chreporte();
					report.setHrectipodescri("Antecedentes");
					report.setHrecdescripcio("Antecedentes Inmunizacion:");
					report.setHrecdescripcio2(formatearCampo(ANTECEDENTES_INMUNIZACIONES));
					report.setHrencodigo(imp_antecedentes);
					report.setHrentipoimpres(3);
					report.setHrenconsulta(consulta.getHcolnumero());
					report.setHredfecharegis(consulta.getHcodfecregistr());
					lstReporte.add(report);
				}

				if (ANTECEDENTES_SICOMOTOR != null && !ANTECEDENTES_SICOMOTOR.equals("")) {
					report = new Chreporte();
					report.setHrectipodescri("Antecedentes");
					report.setHrecdescripcio("Antecedentes Desarrollo Sicomotor:");
					report.setHrecdescripcio2(formatearCampo(ANTECEDENTES_SICOMOTOR));
					report.setHrencodigo(imp_antecedentes);
					report.setHrentipoimpres(3);
					report.setHrenconsulta(consulta.getHcolnumero());
					report.setHredfecharegis(consulta.getHcodfecregistr());
					lstReporte.add(report);
				}

				if (ANTECEDENTES_ALIMENTACION != null && !ANTECEDENTES_ALIMENTACION.equals("")) {
					report = new Chreporte();
					report.setHrectipodescri("Antecedentes");
					report.setHrecdescripcio("Antecedentes Alimentacion:");
					report.setHrecdescripcio2(formatearCampo(ANTECEDENTES_ALIMENTACION));
					report.setHrencodigo(imp_antecedentes);
					report.setHrentipoimpres(3);
					report.setHrenconsulta(consulta.getHcolnumero());
					report.setHredfecharegis(consulta.getHcodfecregistr());
					lstReporte.add(report);
				}

				if (ANTECEDENTES_HOSPITALIZACIONES != null && !ANTECEDENTES_HOSPITALIZACIONES.equals("")) {
					report = new Chreporte();
					report.setHrectipodescri("Antecedentes");
					report.setHrecdescripcio("Antecedentes Hospitalizacion:");
					report.setHrecdescripcio2(formatearCampo(ANTECEDENTES_HOSPITALIZACIONES));
					report.setHrencodigo(imp_antecedentes);
					report.setHrentipoimpres(3);
					report.setHrenconsulta(consulta.getHcolnumero());
					report.setHredfecharegis(consulta.getHcodfecregistr());
					lstReporte.add(report);
				}

			}

			setDatoAntecedentesVacec(consulta);

			if (consulta.getChantecpsico() != null && !consulta.getChantecpsico().isEmpty()) {

				Chantecpsico antecpsico = null;
				Iterator it = consulta.getChantecpsico().iterator();
				if (it.hasNext()) {
					antecpsico = (Chantecpsico) it.next();
				}

				if (antecpsico != null) {
					Chreporte report = new Chreporte();

					report = new Chreporte();
					report.setHrecdescripcio("Se siente enfermo:  " + SE_SIENTE_ENFERMO);
					if (DESCRIPCION_ENFERMO != null && !DESCRIPCION_ENFERMO.equals("")) {
						report.setHrecdescripcio2("Descripcion: " + DESCRIPCION_ENFERMO);
					}

					report.setHrecdescripcio3("");
					report.setHrecdescripcio4("");
					report.setHrectipodescri("Antecedentes Psicologicos");
					report.setHrencodigo(imp_antecedentes_psicologia);
					report.setHrentipoimpres(4);
					report.setHrenconsulta(consulta.getHcolnumero());
					report.setHredfecharegis(consulta.getHcodfecregistr());
					lstReporte.add(report);

					report = new Chreporte();
					report.setHrecdescripcio("Considera  que tiene alguna alteraciNn fNsica:  " + ALTERACION_FISICA);
					if (CUAL_ALTERACION != null && !CUAL_ALTERACION.equals("")) {
						report.setHrecdescripcio2("Cual? : " + CUAL_ALTERACION);
					}
					report.setHrectipodescri("Antecedentes Psicologicos");
					report.setHrencodigo(imp_antecedentes_psicologia);
					report.setHrentipoimpres(6);
					report.setHrenconsulta(consulta.getHcolnumero());
					report.setHredfecharegis(consulta.getHcodfecregistr());
					lstReporte.add(report);

					report = new Chreporte();
					report.setHrecdescripcio("Frecuente mente realiza actividad fNsica (mNnimo 3 veces por semana)?");
					report.setHrectipodescri("Antecedentes Psicologicos");
					report.setHrencodigo(imp_antecedentes_psicologia);
					report.setHrentipoimpres(1);
					report.setHrenconsulta(consulta.getHcolnumero());
					report.setHredfecharegis(consulta.getHcodfecregistr());
					lstReporte.add(report);

					report = new Chreporte();
					report.setHrecdescripcio("Nunca realiza actividad fNsica?:  " + NUNCA_FISICA);
					report.setHrecdescripcio2("Ocasionalmente realiza actividad fNsica? : " + OCASIONALMENTE_FISICA);
					report.setHrectipodescri("Antecedentes Psicologicos");
					report.setHrencodigo(imp_antecedentes_psicologia);
					report.setHrentipoimpres(6);
					report.setHrenconsulta(consulta.getHcolnumero());
					report.setHredfecharegis(consulta.getHcodfecregistr());
					lstReporte.add(report);

					report = new Chreporte();
					report.setHrecdescripcio("Consume alimentos 3 veces al dNa?:  " + TRES_ALIMENTOS);
					report.setHrecdescripcio2("Consume alimentos   mNs de 3 veces al dNa? : " + MAS_ALIMENTOS);
					report.setHrectipodescri("Antecedentes Psicologicos");
					report.setHrencodigo(imp_antecedentes_psicologia);
					report.setHrentipoimpres(6);
					report.setHrenconsulta(consulta.getHcolnumero());
					report.setHredfecharegis(consulta.getHcodfecregistr());
					lstReporte.add(report);

					if (TIPO_ALIMENTOS_CONSUME != null && !TIPO_ALIMENTOS_CONSUME.equals("")) {
						report = new Chreporte();
						report.setHrecdescripcio("Que tipo de alimentos consume?:  " + TIPO_ALIMENTOS_CONSUME);
						report.setHrectipodescri("Antecedentes Psicologicos");
						report.setHrencodigo(imp_antecedentes_psicologia);
						report.setHrentipoimpres(1);
						report.setHrenconsulta(consulta.getHcolnumero());
						report.setHredfecharegis(consulta.getHcodfecregistr());
						lstReporte.add(report);

					}

					report = new Chreporte();
					report.setHrecdescripcio(
							"Medicamentos formulados  durante los Nltimos seis meses?:  " + MEDICAMENTOS_FORMULADOS);
					if (CUAL_MEDICAMENTO != null && !CUAL_MEDICAMENTO.equals("")) {
						report.setHrecdescripcio2("CuNl? : " + CUAL_MEDICAMENTO);
					}
					report.setHrectipodescri("Antecedentes Psicologicos");
					report.setHrencodigo(imp_antecedentes_psicologia);
					report.setHrentipoimpres(6);
					report.setHrenconsulta(consulta.getHcolnumero());
					report.setHredfecharegis(consulta.getHcodfecregistr());
					lstReporte.add(report);

					report = new Chreporte();
					report.setHrecdescripcio(
							"Problemas de hNbitos de salud: Ejercicio, dieta, peso, tabaco, alcohol o otras drogas?:  "
									+ HABITOS_SALUD);
					if (CUAL_HABITO != null && !CUAL_HABITO.equals("")) {
						report.setHrecdescripcio2("CuNl? : " + CUAL_HABITO);
					}
					report.setHrectipodescri("Antecedentes Psicologicos");
					report.setHrencodigo(imp_antecedentes_psicologia);
					report.setHrentipoimpres(2);
					report.setHrenconsulta(consulta.getHcolnumero());
					report.setHredfecharegis(consulta.getHcodfecregistr());
					lstReporte.add(report);

					report = new Chreporte();
					if (ORIENTACION_SEXUAL != null && !ORIENTACION_SEXUAL.equals("")) {
						report.setHrecdescripcio("OrientaciNn sexual: " + ORIENTACION_SEXUAL);
					}

					if (CUAL_ORIENTACION != null && !CUAL_ORIENTACION.equals("")) {
						report.setHrecdescripcio2("Cual?" + CUAL_ORIENTACION);
					}
					if (TIENE_PAREJA != null && !TIENE_PAREJA.equals("")) {
						report.setHrecdescripcio3("Actualmente tiene pareja:  " + TIENE_PAREJA);
					}
					if (TIPO_VINCULO != null && !TIPO_VINCULO.equals("")) {
						report.setHrecdescripcio4("Tipo vinculo: " + TIPO_VINCULO);
					}

					report.setHrectipodescri("Antecedentes Psicologicos");
					report.setHrencodigo(imp_antecedentes_psicologia);
					report.setHrentipoimpres(4);
					report.setHrenconsulta(consulta.getHcolnumero());
					report.setHredfecharegis(consulta.getHcodfecregistr());
					lstReporte.add(report);

					report = new Chreporte();
					if (VIDA_SEXUAL != null && !VIDA_SEXUAL.equals("")) {
						report.setHrecdescripcio("Tiene actualmente vida sexual activa: " + VIDA_SEXUAL);
					}

					if (RELACIONES_SATISFACTORIAS != null && !RELACIONES_SATISFACTORIAS.equals("")) {
						report.setHrecdescripcio2(
								"Tiene relaciones sexuales satisfactorias: " + RELACIONES_SATISFACTORIAS);
					}

					report.setHrectipodescri("Antecedentes Psicologicos");
					report.setHrencodigo(imp_antecedentes_psicologia);
					report.setHrentipoimpres(6);
					report.setHrenconsulta(consulta.getHcolnumero());
					report.setHredfecharegis(consulta.getHcodfecregistr());
					lstReporte.add(report);

					report = new Chreporte();
					if (DIFICULTADES_RELACIONES != null && !DIFICULTADES_RELACIONES.equals("")) {
						report.setHrecdescripcio(
								"Tiene  dificultades en las relaciones sexuales:  " + DIFICULTADES_RELACIONES);
					}
					if (CUALES_DIFICULTADES != null && !CUALES_DIFICULTADES.equals("")) {
						report.setHrecdescripcio2("Cuales: " + CUALES_DIFICULTADES);
					}

					report.setHrectipodescri("Antecedentes Psicologicos");
					report.setHrencodigo(imp_antecedentes_psicologia);
					report.setHrentipoimpres(6);
					report.setHrenconsulta(consulta.getHcolnumero());
					report.setHredfecharegis(consulta.getHcodfecregistr());
					lstReporte.add(report);

					report = new Chreporte();
					if (TRASTORNOS_PSIQUICOS != null && !TRASTORNOS_PSIQUICOS.equals("")) {
						report.setHrecdescripcio("Antecedentes de trastornos psNquicos: " + TRASTORNOS_PSIQUICOS);
					}

					if (CUAL_TRASTORNO != null && !CUAL_TRASTORNO.equals("")) {
						report.setHrecdescripcio2("CNal?" + CUAL_TRASTOR);
					}
					report.setHrectipodescri("Antecedentes Psicologicos");
					report.setHrencodigo(imp_antecedentes_psicologia);
					report.setHrentipoimpres(6);
					report.setHrenconsulta(consulta.getHcolnumero());
					report.setHredfecharegis(consulta.getHcodfecregistr());
					lstReporte.add(report);

					report = new Chreporte();
					if (TIPO_FAMILIA != null && !TIPO_FAMILIA.equals("")) {
						report.setHrecdescripcio("Tipo de Familia: " + TIPO_FAMILIA);
					}

					if (COMPOSICION_FAMILIAR != null && !COMPOSICION_FAMILIAR.equals("")) {
						report.setHrecdescripcio2("ComposiciNn familiar:" + COMPOSICION_FAMILIAR);
					}

					report.setHrectipodescri("Antecedentes Psicologicos");
					report.setHrencodigo(imp_antecedentes_psicologia);
					report.setHrentipoimpres(6);
					report.setHrenconsulta(consulta.getHcolnumero());
					report.setHredfecharegis(consulta.getHcodfecregistr());
					lstReporte.add(report);

					report = new Chreporte();
					if (TIPO_VINCULO_FAMILIAR != null && !TIPO_VINCULO_FAMILIAR.equals("")) {
						report.setHrecdescripcio("Tipo de vinculo Familiar: " + TIPO_VINCULO_FAMILIAR);
					}

					if (RELACION_FAMILIA != null && !RELACION_FAMILIA.equals("")) {
						report.setHrecdescripcio2("RelaciNn entre los miembros de la familia:" + RELACION_FAMILIA);
					}

					report.setHrectipodescri("Antecedentes Psicologicos");
					report.setHrencodigo(imp_antecedentes_psicologia);
					report.setHrentipoimpres(6);
					report.setHrenconsulta(consulta.getHcolnumero());
					report.setHredfecharegis(consulta.getHcodfecregistr());
					lstReporte.add(report);

				}

			}

			if (consulta.getChantecprena() != null && !consulta.getChantecprena().isEmpty()) {

				Chantecprena anteceprena = null;

				Iterator it = consulta.getChantecprena().iterator();
				if (it.hasNext()) {
					anteceprena = (Chantecprena) it.next();
				}

				if (anteceprena != null) {

					Chreporte report = new Chreporte();

					report = new Chreporte();
					report.setHrecdescripcio("Antecedentes familiares de HTA Cronica:  " + TIENE_HTA_FAMILIAR);
					if (HTA_FAMILIAR != null && !HTA_FAMILIAR.equals("")) {
						report.setHrecdescripcio2("DescripciNn:  " + HTA_FAMILIAR);
					} else {
						report.setHrecdescripcio2("");
					}

					report.setHrectipodescri("Antecedentes Familiares ");
					report.setHrencodigo(imp_antecedentes_prenatal_familiares);
					report.setHrentipoimpres(3);
					report.setHrenconsulta(consulta.getHcolnumero());
					report.setHredfecharegis(consulta.getHcodfecregistr());
					lstReporte.add(report);

					report = new Chreporte();
					report.setHrecdescripcio("Antecedentes familiares de Diabetes:   " + TIENE_DIABETES_FAMILIAR);

					if (DIABETES_FAMILIAR != null && !DIABETES_FAMILIAR.equals("")) {
						report.setHrecdescripcio2("DescripciNn:  " + DIABETES_FAMILIAR);
					} else {
						report.setHrecdescripcio2("");
					}

					report.setHrectipodescri("Antecedentes Familiares ");
					report.setHrencodigo(imp_antecedentes_prenatal_familiares);
					report.setHrentipoimpres(3);
					report.setHrenconsulta(consulta.getHcolnumero());
					report.setHredfecharegis(consulta.getHcodfecregistr());
					lstReporte.add(report);

					report = new Chreporte();
					report.setHrecdescripcio(
							"Antecedentes familiares de Preeclampsia:  " + TIENE_PREECLAMPSIA_FAMILIAR);

					if (PREECLAMPSIA_FAMILIAR != null && !PREECLAMPSIA_FAMILIAR.equals("")) {
						report.setHrecdescripcio2("DescripciNn:  " + PREECLAMPSIA_FAMILIAR);
					} else {
						report.setHrecdescripcio2("");
					}

					report.setHrectipodescri("Antecedentes Familiares ");
					report.setHrencodigo(imp_antecedentes_prenatal_familiares);
					report.setHrentipoimpres(3);
					report.setHrenconsulta(consulta.getHcolnumero());
					report.setHredfecharegis(consulta.getHcodfecregistr());
					lstReporte.add(report);

					report = new Chreporte();
					report.setHrecdescripcio("Antecedentes familiares de Eclampsia:  " + TIENE_ECLAMPSIA_FAMILIAR);
					if (ECLAMPSIA_FAMILIAR != null && !ECLAMPSIA_FAMILIAR.equals("")) {
						report.setHrecdescripcio2("DescripciNn:  " + ECLAMPSIA_FAMILIAR);
					} else {
						report.setHrecdescripcio2("");
					}

					report.setHrectipodescri("Antecedentes Familiares ");
					report.setHrencodigo(imp_antecedentes_prenatal_familiares);
					report.setHrentipoimpres(3);
					report.setHrenconsulta(consulta.getHcolnumero());
					report.setHredfecharegis(consulta.getHcodfecregistr());
					lstReporte.add(report);

					report = new Chreporte();
					report.setHrecdescripcio("Antecedentes familiares Gemelares :  " + TIENE_GEMELARES_FAMILIAR);
					if (GEMELARES_FAMILIAR != null && !GEMELARES_FAMILIAR.equals("")) {
						report.setHrecdescripcio2("DescripciNn:  " + GEMELARES_FAMILIAR);
					} else {
						report.setHrecdescripcio2("");
					}

					report.setHrectipodescri("Antecedentes Familiares ");
					report.setHrencodigo(imp_antecedentes_prenatal_familiares);
					report.setHrentipoimpres(3);
					report.setHrenconsulta(consulta.getHcolnumero());
					report.setHredfecharegis(consulta.getHcodfecregistr());
					lstReporte.add(report);

					report = new Chreporte();
					report.setHrecdescripcio("Antecedentes familiares de Cardiopatia :  " + TIENE_CARDIOPATIA_FAMILIAR);

					if (CARDIOPATIA_FAMILIAR != null && !CARDIOPATIA_FAMILIAR.equals("")) {
						report.setHrecdescripcio2("DescripciNn:  " + CARDIOPATIA_FAMILIAR);
					} else {
						report.setHrecdescripcio2("");
					}

					report.setHrectipodescri("Antecedentes Familiares ");
					report.setHrencodigo(imp_antecedentes_prenatal_familiares);
					report.setHrentipoimpres(3);
					report.setHrenconsulta(consulta.getHcolnumero());
					report.setHredfecharegis(consulta.getHcodfecregistr());
					lstReporte.add(report);

					report = new Chreporte();
					report.setHrecdescripcio(
							"Antecedentes familiares de Tuberculosis :  " + TIENE_TUBERCULOSIS_FAMILIAR);

					if (TUBERCULOSIS_FAMILIAR != null && !TUBERCULOSIS_FAMILIAR.equals("")) {
						report.setHrecdescripcio2("DescripciNn:  " + TUBERCULOSIS_FAMILIAR);
					} else {
						report.setHrecdescripcio2("");
					}

					report.setHrectipodescri("Antecedentes Familiares ");
					report.setHrencodigo(imp_antecedentes_prenatal_familiares);
					report.setHrentipoimpres(3);
					report.setHrenconsulta(consulta.getHcolnumero());
					report.setHredfecharegis(consulta.getHcodfecregistr());
					lstReporte.add(report);

					report = new Chreporte();
					report.setHrecdescripcio("Otros antecedentes familiares:  " + TIENE_OTROS_FAMILIAR);
					if (OTROS_FAMILIAR != null && !OTROS_FAMILIAR.equals("")) {
						report.setHrecdescripcio2("Cuales?:  " + OTROS_FAMILIAR);
					} else {
						report.setHrecdescripcio2("");
					}

					report.setHrectipodescri("Antecedentes Familiares ");
					report.setHrencodigo(imp_antecedentes_prenatal_familiares);
					report.setHrentipoimpres(3);
					report.setHrenconsulta(consulta.getHcolnumero());
					report.setHredfecharegis(consulta.getHcodfecregistr());
					lstReporte.add(report);

					report = new Chreporte();
					report.setHrecdescripcio("Tiene antecedentes de HTA Cronica:  " + TIENE_HTA_PERSONAL);
					if (HTA_PERSONAL != null && !HTA_PERSONAL.equals("")) {
						report.setHrecdescripcio2("DescripciNn:  " + HTA_PERSONAL);
					} else {
						report.setHrecdescripcio2("");
					}

					report.setHrectipodescri("Antecedentes Personales");
					report.setHrencodigo(imp_antecedentes_prenatal_personales);
					report.setHrentipoimpres(3);
					report.setHrenconsulta(consulta.getHcolnumero());
					report.setHredfecharegis(consulta.getHcodfecregistr());
					lstReporte.add(report);

					report = new Chreporte();
					report.setHrecdescripcio("Tiene antecedentes de Diabetes:  " + TIENE_DIABETES_PERSONAL);
					if (DIABETES_PERSONAL != null && !DIABETES_PERSONAL.equals("")) {
						report.setHrecdescripcio2("DescripciNn:  " + DIABETES_PERSONAL);
					} else {
						report.setHrecdescripcio2("");
					}

					report.setHrectipodescri("Antecedentes Personales");
					report.setHrencodigo(imp_antecedentes_prenatal_personales);
					report.setHrentipoimpres(3);
					report.setHrenconsulta(consulta.getHcolnumero());
					report.setHredfecharegis(consulta.getHcodfecregistr());
					lstReporte.add(report);

					report = new Chreporte();
					report.setHrecdescripcio("Tiene antecedentes de Preeclampsia:  " + TIENE_PREECLAMPSIA_PERSONAL);
					if (PREECLAMPSIA_PERSONAL != null && !PREECLAMPSIA_PERSONAL.equals("")) {
						report.setHrecdescripcio2("DescripciNn:  " + PREECLAMPSIA_PERSONAL);
					} else {
						report.setHrecdescripcio2("");
					}

					report.setHrectipodescri("Antecedentes Personales");
					report.setHrencodigo(imp_antecedentes_prenatal_personales);
					report.setHrentipoimpres(3);
					report.setHrenconsulta(consulta.getHcolnumero());
					report.setHredfecharegis(consulta.getHcodfecregistr());
					lstReporte.add(report);

					report = new Chreporte();
					report.setHrecdescripcio("Tiene antecedentes de Eclampsia:  " + TIENE_ECLAMPSIA_PERSONAL);
					if (ECLAMPSIA_PERSONAL != null && !ECLAMPSIA_PERSONAL.equals("")) {
						report.setHrecdescripcio2("DescripciNn:  " + ECLAMPSIA_PERSONAL);
					} else {
						report.setHrecdescripcio2("");
					}

					report.setHrectipodescri("Antecedentes Personales");
					report.setHrencodigo(imp_antecedentes_prenatal_personales);
					report.setHrentipoimpres(3);
					report.setHrenconsulta(consulta.getHcolnumero());
					report.setHredfecharegis(consulta.getHcodfecregistr());
					lstReporte.add(report);

					report = new Chreporte();
					report.setHrecdescripcio("Tiene antecedentes  Gemelares:  " + TIENE_GEMELARES_PERSONAL);
					if (GEMELARES_PERSONAL != null && !GEMELARES_PERSONAL.equals("")) {
						report.setHrecdescripcio2("DescripciNn:  " + GEMELARES_PERSONAL);
					} else {
						report.setHrecdescripcio2("");
					}

					report.setHrectipodescri("Antecedentes Personales");
					report.setHrencodigo(imp_antecedentes_prenatal_personales);
					report.setHrentipoimpres(3);
					report.setHrenconsulta(consulta.getHcolnumero());
					report.setHredfecharegis(consulta.getHcodfecregistr());
					lstReporte.add(report);

					report = new Chreporte();
					report.setHrecdescripcio("Tiene antecedentes de Cardiopatia :  " + TIENE_CARDIOPATIA_PERSONAL);
					if (CARDIOPATIA_PERSONAL != null && !CARDIOPATIA_PERSONAL.equals("")) {
						report.setHrecdescripcio2("DescripciNn:  " + CARDIOPATIA_PERSONAL);
					} else {
						report.setHrecdescripcio2("");
					}

					report.setHrectipodescri("Antecedentes Personales");
					report.setHrencodigo(imp_antecedentes_prenatal_personales);
					report.setHrentipoimpres(3);
					report.setHrenconsulta(consulta.getHcolnumero());
					report.setHredfecharegis(consulta.getHcodfecregistr());
					lstReporte.add(report);

					report = new Chreporte();
					report.setHrecdescripcio("Tiene antecedentes de Tuberculosis :  " + TIENE_TUBERCULOSIS_PERSONAL);
					if (TUBERCULOSIS_PERSONAL != null && !TUBERCULOSIS_PERSONAL.equals("")) {
						report.setHrecdescripcio2("DescripciNn:  " + TUBERCULOSIS_PERSONAL);
					} else {
						report.setHrecdescripcio2("");
					}

					report.setHrectipodescri("Antecedentes Personales");
					report.setHrencodigo(imp_antecedentes_prenatal_personales);
					report.setHrentipoimpres(3);
					report.setHrenconsulta(consulta.getHcolnumero());
					report.setHredfecharegis(consulta.getHcodfecregistr());
					lstReporte.add(report);

					report = new Chreporte();
					report.setHrecdescripcio("Tiene Cirugias Pelvico-Uterina:  " + TIENE_CIRUGIA_PELVICO_PERSONAL);
					if (CIRUGIA_PELVICO_PERSONAL != null && !CIRUGIA_PELVICO_PERSONAL.equals("")) {
						report.setHrecdescripcio2("DescripciNn:  " + CIRUGIA_PELVICO_PERSONAL);
					} else {
						report.setHrecdescripcio2("");
					}

					report.setHrectipodescri("Antecedentes Personales");
					report.setHrencodigo(imp_antecedentes_prenatal_personales);
					report.setHrentipoimpres(3);
					report.setHrenconsulta(consulta.getHcolnumero());
					report.setHredfecharegis(consulta.getHcodfecregistr());
					lstReporte.add(report);

					report = new Chreporte();
					report.setHrecdescripcio("Tiene  Alergias :  " + TIENE_ALERGICOS_PERSONAL);
					if (ALERGICOS_PERSONAL != null && !ALERGICOS_PERSONAL.equals("")) {
						report.setHrecdescripcio2("DescripciNn:  " + ALERGICOS_PERSONAL);
					} else {
						report.setHrecdescripcio2("");
					}

					report.setHrectipodescri("Antecedentes Personales");
					report.setHrencodigo(imp_antecedentes_prenatal_personales);
					report.setHrentipoimpres(3);
					report.setHrenconsulta(consulta.getHcolnumero());
					report.setHredfecharegis(consulta.getHcodfecregistr());
					lstReporte.add(report);

					report = new Chreporte();
					report.setHrecdescripcio("Tiene antecedentes de Tabaquismo:  " + TIENE_TABAQUISMO_PERSONAL);
					if (TABAQUISMO_PERSONAL != null && !TABAQUISMO_PERSONAL.equals("")) {
						report.setHrecdescripcio2("DescripciNn:  " + TABAQUISMO_PERSONAL);
					} else {
						report.setHrecdescripcio2("");
					}

					report.setHrectipodescri("Antecedentes Personales");
					report.setHrencodigo(imp_antecedentes_prenatal_personales);
					report.setHrentipoimpres(3);
					report.setHrenconsulta(consulta.getHcolnumero());
					report.setHredfecharegis(consulta.getHcodfecregistr());
					lstReporte.add(report);

					report = new Chreporte();
					report.setHrecdescripcio(
							"Tiene antecedentes de Antitetanica Previa:  " + TIENE_ANTITETANICA_PERSONAL);
					if (ANTITETANICA_PERSONAL != null && !ANTITETANICA_PERSONAL.equals("")) {
						report.setHrecdescripcio2("DescripciNn:  " + ANTITETANICA_PERSONAL);
					} else {
						report.setHrecdescripcio2("");
					}

					report.setHrectipodescri("Antecedentes Personales");
					report.setHrencodigo(imp_antecedentes_prenatal_personales);
					report.setHrentipoimpres(3);
					report.setHrenconsulta(consulta.getHcolnumero());
					report.setHredfecharegis(consulta.getHcodfecregistr());
					lstReporte.add(report);

					report = new Chreporte();
					report.setHrecdescripcio("Otros Antecedentes Personales:  " + TIENE_OTROS_PERSONAL);
					if (OTROS_PERSONAL != null && !OTROS_PERSONAL.equals("")) {
						report.setHrecdescripcio2("Cuales?:  " + OTROS_PERSONAL);
					} else {
						report.setHrecdescripcio2("");
					}

					report.setHrectipodescri("Antecedentes Personales");
					report.setHrencodigo(imp_antecedentes_prenatal_personales);
					report.setHrentipoimpres(3);
					report.setHrenconsulta(consulta.getHcolnumero());
					report.setHredfecharegis(consulta.getHcodfecregistr());
					lstReporte.add(report);

				}

			}

			if (consulta.getChevalugener() != null && !consulta.getChevalugener().isEmpty()) {
				Chevalugener evaluacion = null;

				Iterator it = consulta.getChevalugener().iterator();
				if (it.hasNext()) {
					evaluacion = (Chevalugener) it.next();
				}

				if (evaluacion != null) {
					Chreporte report = new Chreporte();

					report = new Chreporte();

					if (AREA_COGNITIVA != null && !AREA_COGNITIVA.equals("")) {
						report.setHrecdescripcio("Nrea cognitiva:  " + AREA_COGNITIVA);
						report.setHrectipodescri("EvaluaciNn General");
						report.setHrencodigo(imp_evaluacion_general);
						report.setHrentipoimpres(1);
						report.setHrenconsulta(consulta.getHcolnumero());
						report.setHredfecharegis(consulta.getHcodfecregistr());
						lstReporte.add(report);

					}

					if (AREA_AFECTIVA != null && !AREA_AFECTIVA.equals("")) {
						report = new Chreporte();
						report.setHrecdescripcio("Nrea afectiva:  " + AREA_AFECTIVA);
						report.setHrectipodescri("EvaluaciNn General");
						report.setHrencodigo(imp_evaluacion_general);
						report.setHrentipoimpres(1);
						report.setHrenconsulta(consulta.getHcolnumero());
						report.setHredfecharegis(consulta.getHcodfecregistr());
						lstReporte.add(report);
					}

					if (AREA_AFECTIVA != null && !AREA_AFECTIVA.equals("")) {
						report = new Chreporte();
						report.setHrecdescripcio("Nrea afectiva:  " + AREA_AFECTIVA);
						report.setHrectipodescri("EvaluaciNn General");
						report.setHrencodigo(imp_evaluacion_general);
						report.setHrentipoimpres(1);
						report.setHrenconsulta(consulta.getHcolnumero());
						report.setHredfecharegis(consulta.getHcodfecregistr());
						lstReporte.add(report);
					}

					String s = "";
					String s1 = "";

					if (APOYO_FAMILIAR != null && !APOYO_FAMILIAR.equals("")) {
						s = "Cuenta con apoyo familiar/amigos: " + APOYO_FAMILIAR;
						s1 = "Cual? " + CUAL_APOYO;
						report = new Chreporte();
						report.setHrecdescripcio(s);
						if (CUAL_APOYO != null && !CUAL_APOYO.equals("")) {
							report.setHrecdescripcio2(s1);
						}
						report.setHrectipodescri("EvaluaciNn General");
						report.setHrencodigo(imp_evaluacion_general);
						report.setHrentipoimpres(6);
						report.setHrenconsulta(consulta.getHcolnumero());
						report.setHredfecharegis(consulta.getHcodfecregistr());
						lstReporte.add(report);
					}

					if (RELACION_SOCIAL != null && !RELACION_SOCIAL.equals("")) {
						s = "Cuenta con apoyo familiar/amigos: " + RELACION_SOCIAL;
						s1 = "Cual? " + CUAL_RELACION;
						report = new Chreporte();
						report.setHrecdescripcio(s);
						if (CUAL_RELACION != null && !RELACION_SOCIAL.equals("Si")) {
							report.setHrecdescripcio2(s1);
						}
						report.setHrectipodescri("EvaluaciNn General");
						report.setHrencodigo(imp_evaluacion_general);
						report.setHrentipoimpres(2);
						report.setHrenconsulta(consulta.getHcolnumero());
						report.setHredfecharegis(consulta.getHcodfecregistr());
						lstReporte.add(report);
					}

					if (CANALES_COMUNICACION != null && !CANALES_COMUNICACION.equals("")) {

						s = "";
						s1 = "";
						s = "Establece adecuados canales de comunicaciNn: " + CANALES_COMUNICACION;
						s1 = "Cual? " + CUAL_CANAL;

						report = new Chreporte();
						report.setHrecdescripcio(s);
						if (CUAL_CANAL != null && !CUAL_CANAL.equals("")) {
							report.setHrecdescripcio2(s1);
						}
						report.setHrectipodescri("EvaluaciNn General");
						report.setHrencodigo(imp_evaluacion_general);
						report.setHrentipoimpres(6);
						report.setHrenconsulta(consulta.getHcolnumero());
						report.setHredfecharegis(consulta.getHcodfecregistr());
						lstReporte.add(report);
					}

					if (LABORAL_ESTUDIOS != null && !LABORAL_ESTUDIOS.equals("")) {
						s = "";
						s1 = "";
						s = "Problemas y satisfacciNn laboral-estudios: " + LABORAL_ESTUDIOS;
						s1 = "Cual? " + CUAL_PROBLEMA;

						report = new Chreporte();
						report.setHrecdescripcio(s);
						if (CUAL_PROBLEMA != null && !CUAL_PROBLEMA.equals("")) {
							report.setHrecdescripcio2(s1);
						}
						report.setHrectipodescri("EvaluaciNn General");
						report.setHrencodigo(imp_evaluacion_general);
						report.setHrentipoimpres(6);
						report.setHrenconsulta(consulta.getHcolnumero());
						report.setHredfecharegis(consulta.getHcodfecregistr());
						lstReporte.add(report);
					}

					if (SERVICIOS_APOYO != null && !SERVICIOS_APOYO.equals("")) {
						s = "";
						s1 = "";
						s = "Relaciones con servicios de apoyo: " + SERVICIOS_APOYO;
						s1 = "Cual? " + CUAL_RELACION;

						report = new Chreporte();
						report.setHrecdescripcio(s);
						if (CUAL_RELACION != null && !CUAL_RELACION.equals("")) {
							report.setHrecdescripcio2(s1);
						}
						report.setHrectipodescri("EvaluaciNn General");
						report.setHrencodigo(imp_evaluacion_general);
						report.setHrentipoimpres(6);
						report.setHrenconsulta(consulta.getHcolnumero());
						report.setHredfecharegis(consulta.getHcodfecregistr());
						lstReporte.add(report);
					}

					if (RELACIONES_FAMILIARES != null && !RELACIONES_FAMILIARES.equals("")) {

						s = "";

						s = "DescripciNn Relaciones sociales: " + RELACIONES_FAMILIARES;

						report = new Chreporte();
						report.setHrecdescripcio(s);
						if (CUAL_RELACION != null && !CUAL_RELACION.equals("")) {
							report.setHrecdescripcio2(CUAL_RELACION);
						}
						report.setHrectipodescri("EvaluaciNn General");
						report.setHrencodigo(imp_evaluacion_general);
						report.setHrentipoimpres(2);
						report.setHrenconsulta(consulta.getHcolnumero());
						report.setHredfecharegis(consulta.getHcodfecregistr());
						lstReporte.add(report);
					}

					if (COMPOSICIONDINA_FAMILIAR != null && !COMPOSICIONDINA_FAMILIAR.equals("")) {

						s = "";

						s = "COMPOSICION FAMILIAR Y DINAMICA FAMILIAR: " + COMPOSICIONDINA_FAMILIAR;

						report = new Chreporte();
						report.setHrecdescripcio(s);
						report.setHrectipodescri("EvaluaciNn General");
						report.setHrencodigo(imp_evaluacion_general);
						report.setHrentipoimpres(1);
						report.setHrenconsulta(consulta.getHcolnumero());
						report.setHredfecharegis(consulta.getHcodfecregistr());
						lstReporte.add(report);
					}

					if (DESARROLLO_SESION != null && !DESARROLLO_SESION.equals("")) {

						s = "";

						s = "Desarrollo de la sesion: " + DESARROLLO_SESION;

						report = new Chreporte();
						report.setHrecdescripcio(s);
						report.setHrectipodescri("EvaluaciNn General");
						report.setHrencodigo(imp_evaluacion_general);
						report.setHrentipoimpres(1);
						report.setHrenconsulta(consulta.getHcolnumero());
						report.setHredfecharegis(consulta.getHcodfecregistr());
						lstReporte.add(report);
					}

				}

			}

			if (consulta.getChcuestester() != null && !consulta.getChcuestester().isEmpty()) {

				Chcuestester cuestEsterilizacion = null;
				Iterator it = consulta.getChcuestester().iterator();
				if (it.hasNext()) {
					cuestEsterilizacion = (Chcuestester) it.next();
				}

				if (cuestEsterilizacion != null) {

					Chreporte report = new Chreporte();
					String s = "";
					String s2 = "";
					String s3 = "";
					String s4 = "";
					s = "";
					s = "1.  Se siente Usted actualmente enferma? ";
					s2 = HCECENFERMO;
					s3 = HCECANENFERMO;
					report = new Chreporte();
					report.setHrecdescripcio(s);
					report.setHrecdescripcio2(s2);
					report.setHrecdescripcio3(s3);
					report.setHrentipoimpres(7);
					report.setHrectipodescri("Cuestionario Esterilizacion");
					report.setHrencodigo(imp_cuestionario_femenina);
					report.setHrenconsulta(consulta.getHcolnumero());
					report.setHredfecharegis(consulta.getHcodfecregistr());
					lstReporte.add(report);

					s = "2.  Ha tenido enfermedades graves en el pasado? ";
					s2 = HCECENFERGRAV;
					s3 = HCECANENFERGRAV;

					report = new Chreporte();
					report.setHrecdescripcio(s);
					report.setHrecdescripcio2(s2);
					report.setHrecdescripcio3(s3);
					report.setHrentipoimpres(7);
					report.setHrectipodescri("Cuestionario Esterilizacion");
					report.setHrencodigo(imp_cuestionario_femenina);
					report.setHrenconsulta(consulta.getHcolnumero());
					report.setHredfecharegis(consulta.getHcodfecregistr());
					lstReporte.add(report);

					s = "3.  Ha sido operada o anestesiada alguna vez?";
					s2 = HCECOPERADO;
					s3 = HCECANOPERADO;

					report = new Chreporte();
					report.setHrecdescripcio(s);
					report.setHrecdescripcio2(s2);
					report.setHrecdescripcio3(s3);
					report.setHrentipoimpres(7);
					report.setHrectipodescri("Cuestionario Esterilizacion");
					report.setHrencodigo(imp_cuestionario_femenina);
					report.setHrenconsulta(consulta.getHcolnumero());
					report.setHredfecharegis(consulta.getHcodfecregistr());
					lstReporte.add(report);

					s = "4.  Ha recibido transfusiones de sangre?";
					s2 = HCECTRANSFUSION;
					s3 = HCECANTRANSFUSION;
					report = new Chreporte();
					report.setHrecdescripcio(s);
					report.setHrecdescripcio2(s2);
					report.setHrecdescripcio3(s3);
					report.setHrentipoimpres(7);
					report.setHrectipodescri("Cuestionario Esterilizacion");
					report.setHrencodigo(imp_cuestionario_femenina);
					report.setHrenconsulta(consulta.getHcolnumero());
					report.setHredfecharegis(consulta.getHcodfecregistr());
					lstReporte.add(report);

					s = "5.  Ha tenido o tiene la presion arterial alta?";
					s2 = HCECPRESIONALTA;
					s3 = HCECANPRESIONALTA;
					report = new Chreporte();
					report.setHrecdescripcio(s);
					report.setHrecdescripcio2(s2);
					report.setHrecdescripcio3(s3);
					report.setHrentipoimpres(7);
					report.setHrectipodescri("Cuestionario Esterilizacion");
					report.setHrencodigo(imp_cuestionario_femenina);
					report.setHrenconsulta(consulta.getHcolnumero());
					report.setHredfecharegis(consulta.getHcodfecregistr());
					lstReporte.add(report);

					s = "6.  Al hacer ejercicio o subir escaleras siente usted: palpitaciones, ahogo o  dolor en el pecho?";
					s2 = HCECEJERCICIO;
					s3 = HCECANEJERCICIO;
					report = new Chreporte();
					report.setHrecdescripcio(s);
					report.setHrecdescripcio2(s2);
					report.setHrecdescripcio3(s3);
					report.setHrentipoimpres(7);
					report.setHrectipodescri("Cuestionario Esterilizacion");
					report.setHrencodigo(imp_cuestionario_femenina);
					report.setHrenconsulta(consulta.getHcolnumero());
					report.setHredfecharegis(consulta.getHcodfecregistr());
					lstReporte.add(report);

					s = "7.  Ha tenido alguna vez palpitaciones, dolor en el pecho o taquicardia?";
					s2 = HCECPALPITACION;
					s3 = HCECANPALPITACION;
					report = new Chreporte();
					report.setHrecdescripcio(s);
					report.setHrecdescripcio2(s2);
					report.setHrecdescripcio3(s3);
					report.setHrentipoimpres(7);
					report.setHrectipodescri("Cuestionario Esterilizacion");
					report.setHrencodigo(imp_cuestionario_femenina);
					report.setHrenconsulta(consulta.getHcolnumero());
					report.setHredfecharegis(consulta.getHcodfecregistr());
					lstReporte.add(report);

					s = "8.  Alguna vez en un examen medico le han encontrado un soplo en el corazon?";
					s2 = HCECSOPLO;
					s3 = HCECANSOPLO;
					report = new Chreporte();
					report.setHrecdescripcio(s);
					report.setHrecdescripcio2(s2);
					report.setHrecdescripcio3(s3);
					report.setHrentipoimpres(7);
					report.setHrectipodescri("Cuestionario Esterilizacion");
					report.setHrencodigo(imp_cuestionario_femenina);
					report.setHrenconsulta(consulta.getHcolnumero());
					report.setHredfecharegis(consulta.getHcodfecregistr());
					lstReporte.add(report);

					s = "9.  Ha tenido o tiene asma o bronquitis?";
					s2 = HCECASMA;
					s3 = HCECANASMA;
					report = new Chreporte();
					report.setHrecdescripcio(s);
					report.setHrecdescripcio2(s2);
					report.setHrecdescripcio3(s3);
					report.setHrentipoimpres(7);
					report.setHrectipodescri("Cuestionario Esterilizacion");
					report.setHrencodigo(imp_cuestionario_femenina);
					report.setHrenconsulta(consulta.getHcolnumero());
					report.setHredfecharegis(consulta.getHcodfecregistr());
					lstReporte.add(report);

					s = "10. Tose con frecuencia?";
					s2 = HCECTOS;
					s3 = HCECANTOS;
					report = new Chreporte();
					report.setHrecdescripcio(s);
					report.setHrecdescripcio2(s2);
					report.setHrecdescripcio3(s3);
					report.setHrentipoimpres(7);
					report.setHrectipodescri("Cuestionario Esterilizacion");
					report.setHrencodigo(imp_cuestionario_femenina);
					report.setHrenconsulta(consulta.getHcolnumero());
					report.setHredfecharegis(consulta.getHcodfecregistr());
					lstReporte.add(report);

					s = "11. Tiene actualmente gripa?";
					s2 = HCECGRIPA;
					s3 = HCECANGRIPA;
					report = new Chreporte();
					report.setHrecdescripcio(s);
					report.setHrecdescripcio2(s2);
					report.setHrecdescripcio3(s3);
					report.setHrentipoimpres(7);
					report.setHrectipodescri("Cuestionario Esterilizacion");
					report.setHrencodigo(imp_cuestionario_femenina);
					report.setHrenconsulta(consulta.getHcolnumero());
					report.setHredfecharegis(consulta.getHcodfecregistr());
					lstReporte.add(report);

					s = "12. Usted fuma o fumo?";
					s2 = HCECFUMA;
					if (cuestEsterilizacion != null && cuestEsterilizacion.getHcecfuma() != null
							&& cuestEsterilizacion.getHcecfuma().equals("S")) {
						s3 = "Cuantos al dia: " + FUMA_DIA_FEMENINA;
					} else {
						s3 = "";
					}

					s4 = HCECANFUMA;

					report = new Chreporte();
					report.setHrecdescripcio(s);
					report.setHrecdescripcio2(s2);
					report.setHrecdescripcio3(s3);
					report.setHrecdescripcio4(s4);
					report.setHrentipoimpres(8);
					report.setHrectipodescri("Cuestionario Esterilizacion");
					report.setHrencodigo(imp_cuestionario_femenina);
					report.setHrenconsulta(consulta.getHcolnumero());
					report.setHredfecharegis(consulta.getHcodfecregistr());
					lstReporte.add(report);

					s = "13. Ha tenido Usted o algun familiar problemas cuando han recibido anestesia?";
					s2 = HCECPROBANESTESIA;
					s3 = HCECANPROBANESTESIA;
					report = new Chreporte();
					report.setHrecdescripcio(s);
					report.setHrecdescripcio2(s2);
					report.setHrecdescripcio3(s3);
					report.setHrentipoimpres(7);
					report.setHrectipodescri("Cuestionario Esterilizacion");
					report.setHrencodigo(imp_cuestionario_femenina);
					report.setHrenconsulta(consulta.getHcolnumero());
					report.setHredfecharegis(consulta.getHcodfecregistr());
					lstReporte.add(report);

					s = "14. Ha tenido o tiene alergia a alguna droga?";
					s2 = HCECALERGIA;
					s3 = HCECANALERGIA;
					report = new Chreporte();
					report.setHrecdescripcio(s);
					report.setHrecdescripcio2(s2);
					report.setHrecdescripcio3(s3);
					report.setHrentipoimpres(7);
					report.setHrectipodescri("Cuestionario Esterilizacion");
					report.setHrencodigo(imp_cuestionario_femenina);
					report.setHrenconsulta(consulta.getHcolnumero());
					report.setHredfecharegis(consulta.getHcodfecregistr());
					lstReporte.add(report);

					s = "15. Ha tomado alguna droga en los ultimos 6 meses?";
					s2 = HCECDROGAS;
					s3 = HCECANDROGAS;
					report = new Chreporte();
					report.setHrecdescripcio(s);
					report.setHrecdescripcio2(s2);
					report.setHrecdescripcio3(s3);
					report.setHrentipoimpres(7);
					report.setHrectipodescri("Cuestionario Esterilizacion");
					report.setHrencodigo(imp_cuestionario_femenina);
					report.setHrenconsulta(consulta.getHcolnumero());
					report.setHredfecharegis(consulta.getHcodfecregistr());
					lstReporte.add(report);

					s = "16. Ha tenido alguna vez una convulsion? (Epilepsia)";
					s2 = HCECCONVULSION;
					s3 = HCECANCONVULSION;
					report = new Chreporte();
					report.setHrecdescripcio(s);
					report.setHrecdescripcio2(s2);
					report.setHrecdescripcio3(s3);
					report.setHrentipoimpres(7);
					report.setHrectipodescri("Cuestionario Esterilizacion");
					report.setHrencodigo(imp_cuestionario_femenina);
					report.setHrenconsulta(consulta.getHcolnumero());
					report.setHredfecharegis(consulta.getHcodfecregistr());
					lstReporte.add(report);

					s = "17. Ha tenido o tiene enfermedades mentales?";
					s2 = HCECENFERMENTAL;
					s3 = HCECANENFERMENTAL;
					report = new Chreporte();
					report.setHrecdescripcio(s);
					report.setHrecdescripcio2(s2);
					report.setHrecdescripcio3(s3);
					report.setHrentipoimpres(7);
					report.setHrectipodescri("Cuestionario Esterilizacion");
					report.setHrencodigo(imp_cuestionario_femenina);
					report.setHrenconsulta(consulta.getHcolnumero());
					report.setHredfecharegis(consulta.getHcodfecregistr());
					lstReporte.add(report);

					s = "18. Ha tenido o tiene diabetes o hipoglicemia? (Problemas con los niveles de azucar en la sangre)";
					s2 = HCECDIABETES;
					s3 = HCECANDIABETES;
					report = new Chreporte();
					report.setHrecdescripcio(s);
					report.setHrecdescripcio2(s2);
					report.setHrecdescripcio3(s3);
					report.setHrentipoimpres(7);
					report.setHrectipodescri("Cuestionario Esterilizacion");
					report.setHrencodigo(imp_cuestionario_femenina);
					report.setHrenconsulta(consulta.getHcolnumero());
					report.setHredfecharegis(consulta.getHcodfecregistr());
					lstReporte.add(report);

					s = "19. Ha tenido hepatitis?";
					s2 = HCECHEPATITIS;
					s3 = HCECANHEPATITIS;
					report = new Chreporte();
					report.setHrecdescripcio(s);
					report.setHrecdescripcio2(s2);
					report.setHrecdescripcio3(s3);
					report.setHrentipoimpres(7);
					report.setHrectipodescri("Cuestionario Esterilizacion");
					report.setHrencodigo(imp_cuestionario_femenina);
					report.setHrenconsulta(consulta.getHcolnumero());
					report.setHredfecharegis(consulta.getHcodfecregistr());
					lstReporte.add(report);

					s = "20. Ha tenido o tiene otra enfermedad o alteracion en su salud no  mencionada anteriormente?";
					s2 = HCECOTRAENFER;
					s3 = HCECANOTRAENFER;
					report = new Chreporte();
					report.setHrecdescripcio(s);
					report.setHrecdescripcio2(s2);
					report.setHrecdescripcio3(s3);
					report.setHrentipoimpres(7);
					report.setHrectipodescri("Cuestionario Esterilizacion");
					report.setHrencodigo(imp_cuestionario_femenina);
					report.setHrenconsulta(consulta.getHcolnumero());
					report.setHredfecharegis(consulta.getHcodfecregistr());
					lstReporte.add(report);

					s = "21. Piensa Usted que esta embarazada?";
					s2 = HCECEMBARAZO;
					s3 = HCECANEMBARAZO;
					report = new Chreporte();
					report.setHrecdescripcio(s);
					report.setHrecdescripcio2(s2);
					report.setHrecdescripcio3(s3);
					report.setHrentipoimpres(7);
					report.setHrectipodescri("Cuestionario Esterilizacion");
					report.setHrencodigo(imp_cuestionario_femenina);
					report.setHrenconsulta(consulta.getHcolnumero());
					report.setHredfecharegis(consulta.getHcodfecregistr());
					lstReporte.add(report);

					s = "22. Fecha de la ultima menstruaciNn ";
					s2 = HCEDFECHULTMES;
					s3 = "Fue normal? " + HCECMESNORM;
					s4 = HCECANMESNORM;
					report = new Chreporte();
					report.setHrecdescripcio(s);
					report.setHrecdescripcio2(s2);
					report.setHrecdescripcio3(s3);
					report.setHrecdescripcio4(s4);
					report.setHrentipoimpres(8);
					report.setHrectipodescri("Cuestionario Esterilizacion");
					report.setHrencodigo(imp_cuestionario_femenina);
					report.setHrenconsulta(consulta.getHcolnumero());
					report.setHredfecharegis(consulta.getHcodfecregistr());
					lstReporte.add(report);

					s = "23. Usted o su pareja utiliza(n) actualmente algNn mNtodo de planificaciNn? "
							+ HCECUTILMETPLAN;
					if (cuestEsterilizacion != null && cuestEsterilizacion.getHcecutilmetplan() != null
							&& cuestEsterilizacion.getHcecutilmetplan().equals("S")) {
						s2 = "Cual? " + formatearCampo(HCECMETPLAN);
					} else {
						s2 = "";
					}

					s3 = HCECANMETPLAN;

					report = new Chreporte();
					report.setHrecdescripcio(s);
					report.setHrecdescripcio2(s2);
					report.setHrecdescripcio3(s3);
					report.setHrecdescripcio4(s4);
					report.setHrentipoimpres(9);
					report.setHrectipodescri("Cuestionario Esterilizacion");
					report.setHrencodigo(imp_cuestionario_femenina);
					report.setHrenconsulta(consulta.getHcolnumero());
					report.setHredfecharegis(consulta.getHcodfecregistr());
					lstReporte.add(report);

					s = "24. Fecha del ultimo parto/aborto";
					s2 = HCEDFECHAPARTO;
					if (cuestEsterilizacion.getHcecesparto() != null) {
						s3 = "Fue? " + HCECESPARTO;
					} else {
						s3 = "";
					}

					report = new Chreporte();
					report.setHrecdescripcio(s);
					report.setHrecdescripcio2(s2);
					report.setHrecdescripcio3(s3);
					report.setHrentipoimpres(5);
					report.setHrectipodescri("Cuestionario Esterilizacion");
					report.setHrencodigo(imp_cuestionario_femenina);
					report.setHrenconsulta(consulta.getHcolnumero());
					report.setHredfecharegis(consulta.getHcodfecregistr());
					lstReporte.add(report);

					s = "25. Recibio Usted informacion o asesoria sobre los metodos temporales de planificacion?";
					s2 = HCECINFOMET;
					s3 = HCECANINFOMET;
					report = new Chreporte();
					report.setHrecdescripcio(s);
					report.setHrecdescripcio2(s2);
					report.setHrecdescripcio3(s3);
					report.setHrentipoimpres(7);
					report.setHrectipodescri("Cuestionario Esterilizacion");
					report.setHrencodigo(imp_cuestionario_femenina);
					report.setHrenconsulta(consulta.getHcolnumero());
					report.setHredfecharegis(consulta.getHcodfecregistr());
					lstReporte.add(report);

					s = "26. Sabe usted que la ligadura de trompas es un metodo definitivo de planificacion?";
					s2 = HCECMETDEF;
					s3 = HCECANMETDEF;
					report = new Chreporte();
					report.setHrecdescripcio(s);
					report.setHrecdescripcio2(s2);
					report.setHrecdescripcio3(s3);
					report.setHrentipoimpres(7);
					report.setHrectipodescri("Cuestionario Esterilizacion");
					report.setHrencodigo(imp_cuestionario_femenina);
					report.setHrenconsulta(consulta.getHcolnumero());
					report.setHredfecharegis(consulta.getHcodfecregistr());
					lstReporte.add(report);

					s = "27. Sabe usted que la ligadura de trompas puede fallar en una de cada 500 mujeres operadas?";
					s2 = HCECLIGFALLA;
					s3 = HCECANLIGFALLA;
					report = new Chreporte();
					report.setHrecdescripcio(s);
					report.setHrecdescripcio2(s2);
					report.setHrecdescripcio3(s3);
					report.setHrentipoimpres(7);
					report.setHrectipodescri("Cuestionario Esterilizacion");
					report.setHrencodigo(imp_cuestionario_femenina);
					report.setHrenconsulta(consulta.getHcolnumero());
					report.setHredfecharegis(consulta.getHcodfecregistr());
					lstReporte.add(report);

					s = "28. Recibio Usted las instrucciones y el consentimiento informado para esterilizacion femenina?";
					s2 = HCECINSESTER;
					s3 = HCECANINSESTER;
					report = new Chreporte();
					report.setHrecdescripcio(s);
					report.setHrecdescripcio2(s2);
					report.setHrecdescripcio3(s3);
					report.setHrentipoimpres(7);
					report.setHrectipodescri("Cuestionario Esterilizacion");
					report.setHrencodigo(imp_cuestionario_femenina);
					report.setHrenconsulta(consulta.getHcolnumero());
					report.setHredfecharegis(consulta.getHcodfecregistr());
					lstReporte.add(report);

					if (cuestEsterilizacion.getHcecobserv() != null) {
						s = "OBSERVACIONES ADICIONALES";

						report = new Chreporte();
						report.setHrecdescripcio(s);
						report.setHrentipoimpres(1);
						report.setHrectipodescri("Cuestionario Esterilizacion");
						report.setHrencodigo(imp_cuestionario_femenina);
						report.setHrenconsulta(consulta.getHcolnumero());
						report.setHredfecharegis(consulta.getHcodfecregistr());
						lstReporte.add(report);

						s = HCECOBSERV;

						report = new Chreporte();
						report.setHrecdescripcio(s);
						report.setHrentipoimpres(1);
						report.setHrectipodescri("Cuestionario Esterilizacion");
						report.setHrencodigo(imp_cuestionario_femenina);
						report.setHrenconsulta(consulta.getHcolnumero());
						report.setHredfecharegis(consulta.getHcodfecregistr());
						lstReporte.add(report);
					}

				}

			}

			imprimirAntecedentesGinecologicos(consulta);
			imprimirAntecedentesColposcopia(consulta);
			imprimirColposcopia(consulta);
			imprimirValoracionBiopsicosocial(consulta);

			if (consulta.getChanteceobst() != null && !consulta.getChanteceobst().isEmpty()) {
				Chanteceobst obstetricos = null;
				Iterator it = consulta.getChanteceobst().iterator();
				if (it.hasNext()) {
					obstetricos = (Chanteceobst) it.next();
				}

				if (obstetricos != null) {
					Chreporte report = new Chreporte();

					report = new Chreporte();
					report.setHrecdescripcio("Leucorreas: " + LEUCORREAS);
					report.setHrecdescripcio2("ITS: " + ITS);
					report.setHrecdescripcio3("Citologia: " + CITOLOGIA);
					report.setHrecdescripcio4("");
					report.setHrectipodescri("Antecedentes Obstetricos");
					report.setHrentipoimpres(4);
					report.setHrencodigo(imp_antecedentes_obstetricos);
					report.setHrenconsulta(consulta.getHcolnumero());
					report.setHredfecharegis(consulta.getHcodfecregistr());
					lstReporte.add(report);

					report = new Chreporte();
					report.setHrecdescripcio("Colposcopia: " + COLPOSCOPIA);
					report.setHrecdescripcio2("Periodo IntergenNsico: " + PERIODO_INTERGENESICO);
					report.setHrecdescripcio3("Historia Infertilidad: " + HISTORIA_INFERTILIDAD);
					report.setHrecdescripcio4("");
					report.setHrectipodescri("Antecedentes Obstetricos");
					report.setHrentipoimpres(4);
					report.setHrencodigo(imp_antecedentes_obstetricos);
					report.setHrenconsulta(consulta.getHcolnumero());
					report.setHredfecharegis(consulta.getHcodfecregistr());
					lstReporte.add(report);

					report = new Chreporte();
					report.setHrecdescripcio("RPM: " + RPM);
					report.setHrecdescripcio2("RCIU: " + RCIU);
					report.setHrecdescripcio3("Tratamientos Recibidos: " + TRATAMIENTOS_RECIBIDOS);
					if (CUAL_TRATAMIENTO != null && !CUAL_TRATAMIENTO.equals("")) {
						report.setHrecdescripcio4("Cual?: " + CUAL_TRATAMIENTO);
					} else {
						report.setHrecdescripcio4(null);
					}

					report.setHrectipodescri("Antecedentes Obstetricos");
					report.setHrentipoimpres(4);
					report.setHrencodigo(imp_antecedentes_obstetricos);
					report.setHrenconsulta(consulta.getHcolnumero());
					report.setHredfecharegis(consulta.getHcodfecregistr());
					lstReporte.add(report);

					report = new Chreporte();
					report.setHrecdescripcio("Amenaza de parto: " + AMENAZA_PARTO);
					report.setHrecdescripcio2("Parto prematuro: " + PARTO_PREMATURO);
					report.setHrecdescripcio3("Gemelar: " + GEMELAR);
					report.setHrecdescripcio4("");
					report.setHrectipodescri("Antecedentes Obstetricos");
					report.setHrentipoimpres(4);
					report.setHrencodigo(imp_antecedentes_obstetricos);
					report.setHrenconsulta(consulta.getHcolnumero());
					report.setHredfecharegis(consulta.getHcodfecregistr());
					lstReporte.add(report);

					report = new Chreporte();
					report.setHrecdescripcio("Polhidramnios: " + POLHIDRAMNIOS);
					report.setHrecdescripcio2("Oligohidramnios: " + OLIGOHIDRAMNIOS);
					report.setHrecdescripcio3("Malformaciones: " + MALFORMACIONES);
					if (CUAL_MALFORMACION != null && !CUAL_MALFORMACION.equals("")) {
						report.setHrecdescripcio4("Cual?: " + CUAL_MALFORMACION);
					} else {
						report.setHrecdescripcio4("");
					}

					report.setHrectipodescri("Antecedentes Obstetricos");
					report.setHrentipoimpres(4);
					report.setHrencodigo(imp_antecedentes_obstetricos);
					report.setHrenconsulta(consulta.getHcolnumero());
					report.setHredfecharegis(consulta.getHcodfecregistr());
					lstReporte.add(report);

					report = new Chreporte();
					report.setHrecdescripcio("Embarazo Prolongado: " + EMBARAZO_PROLONGADO);
					report.setHrecdescripcio2("Amenaza de Aborto: " + AMENAZA_ABORTO);
					report.setHrecdescripcio3("Otros: " + OTROS_OBSTETRICOS);
					if (CUALES_OBSTETRICOS != null && !CUALES_OBSTETRICOS.equals("")) {
						report.setHrecdescripcio4("Cual?: " + CUALES_OBSTETRICOS);
					} else {
						report.setHrecdescripcio4(null);
					}

					report.setHrectipodescri("Antecedentes Obstetricos");
					report.setHrentipoimpres(4);
					report.setHrencodigo(imp_antecedentes_obstetricos);
					report.setHrenconsulta(consulta.getHcolnumero());
					report.setHredfecharegis(consulta.getHcodfecregistr());
					lstReporte.add(report);

				}
			}

			if (consulta.getChgestacion() != null && !consulta.getChgestacion().isEmpty()) {
				Chgestacion gestacion = null;
				Iterator it = consulta.getChgestacion().iterator();
				if (it.hasNext()) {
					gestacion = (Chgestacion) it.next();
				}

				if (gestacion != null) {
					Chreporte report = new Chreporte();
					report = new Chreporte();
					report.setHrecdescripcio("Antitetanica Previa : " + ANTITETANICA_PREVIA);
					report.setHrecdescripcio2("Antitetanica Actual 1ra Dosis: " + ANTITETANICA_ACTUAL_PRIMERA_DOSIS);
					report.setHrecdescripcio3("Fecha 1ra Dosis: " + FECHA_ANTITETANICA_PRIMERA_DOSIS);

					report.setHrectipodescri("GestaciNn Prenatal");
					report.setHrentipoimpres(5);
					report.setHrencodigo(imp_gestacion_prenatal);
					report.setHrenconsulta(consulta.getHcolnumero());
					report.setHredfecharegis(consulta.getHcodfecregistr());
					lstReporte.add(report);

					report = new Chreporte();
					report.setHrecdescripcio("Antitetanica Actual 2da dosis : " + ANTITETANICA_ACTUAL_SEGUNDA_DOSIS);
					report.setHrecdescripcio2("Fecha 2da f: " + FECHA_ANTITETANICA_SEGUNDA_DOSIS);
					report.setHrecdescripcio3(null);

					report.setHrectipodescri("GestaciNn Prenatal");
					report.setHrentipoimpres(5);
					report.setHrencodigo(imp_gestacion_prenatal);
					report.setHrenconsulta(consulta.getHcolnumero());
					report.setHredfecharegis(consulta.getHcodfecregistr());
					lstReporte.add(report);

					report = new Chreporte();
					report.setHrecdescripcio("Antirubeola previa  : " + ANTIRUBEOLA_PREVIA);
					report.setHrecdescripcio2("Antirubeola actual: " + ANTIRUBEOLA_ACTUAL);
					report.setHrecdescripcio3("Fecha antirubeola actual: " + FECHA_ANTIRUBEOLA_ACTUAL);

					report.setHrectipodescri("GestaciNn Prenatal");
					report.setHrentipoimpres(5);
					report.setHrencodigo(imp_gestacion_prenatal);
					report.setHrenconsulta(consulta.getHcolnumero());
					report.setHredfecharegis(consulta.getHcodfecregistr());
					lstReporte.add(report);

					report = new Chreporte();
					report.setHrecdescripcio("Grupo/RH paciente  : " + GRUPO_RH_PACIENTE);
					report.setHrecdescripcio2("Grupo/RH Esposo: " + GRUPO_RH_ESPOSO);
					report.setHrecdescripcio3("SensibilizaciNn: " + SENSIBILIZACION);

					report.setHrectipodescri("GestaciNn Prenatal");
					report.setHrentipoimpres(5);
					report.setHrencodigo(imp_gestacion_prenatal);
					report.setHrenconsulta(consulta.getHcolnumero());
					report.setHredfecharegis(consulta.getHcodfecregistr());
					lstReporte.add(report);

					report = new Chreporte();
					report.setHrecdescripcio("Solicito VIH  : " + SOLICITO_VIH);
					report.setHrecdescripcio2("Realizo VIH: " + REALIZO_VIH);
					report.setHrecdescripcio3("");

					report.setHrectipodescri("GestaciNn Prenatal");
					report.setHrentipoimpres(5);
					report.setHrencodigo(imp_gestacion_prenatal);
					report.setHrenconsulta(consulta.getHcolnumero());
					report.setHredfecharegis(consulta.getHcodfecregistr());
					lstReporte.add(report);

					report = new Chreporte();
					report.setHrecdescripcio("Edad gestaciona probable :" + ESTADO_GESTION_PROBABLE);
					report.setHrecdescripcio2(
							"Metodo de confirmacion edad gestacional : " + METODO_CONFIRMACION_EDAD_GESTIONAL);
					report.setHrectipodescri("GestaciNn Actual");
					report.setHrentipoimpres(2);
					report.setHrencodigo(imp_gestacion_prenatal_actual);
					report.setHrenconsulta(consulta.getHcolnumero());
					report.setHredfecharegis(consulta.getHcodfecregistr());
					lstReporte.add(report);

					report = new Chreporte();
					report.setHrecdescripcio("Signos y sintomas de la gestaciNn: " + SIGNOS_SNTOMAS_GESTACION);
					if (gestacion.getHgecmovimfetal() != null) {
						report.setHrecdescripcio2("Presencia o Ausencia de movimientos fetales : "
								+ formatearCampo(gestacion.getHgecmovimfetal()));
					} else {
						report.setHrecdescripcio2("");
					}
					report.setHrectipodescri("GestaciNn Actual");
					report.setHrentipoimpres(2);
					report.setHrencodigo(imp_gestacion_prenatal_actual);
					report.setHrenconsulta(consulta.getHcolnumero());
					report.setHredfecharegis(consulta.getHcodfecregistr());
					lstReporte.add(report);

				}
			}

			if ((consulta.getChantecemamas() != null && !consulta.getChantecemamas().isEmpty())) {

				Chantecemama antecemama = null;
				Iterator it = consulta.getChantecemamas().iterator();
				if (it.hasNext()) {
					antecemama = (Chantecemama) it.next();
				}

				if (antecemama != null) {
					boolean mostrarValoracion = false;

					Chreporte report = new Chreporte();
					if (antecemama.getHamevalorant() != null && antecemama.getHamevalorant().equals("S")) {
						mostrarValoracion = true;
						report.setHrecdescripcio("Valoracion Clinica Anterior: Si ");
						if (antecemama.getHamdfecvalant() != null) {
							report.setHrecdescripcio2(
									"Fecha Valoracion Anterior: " + formatearCampo(antecemama.getHamdfecvalant()));
						}

					} else {
						report.setHrecdescripcio("Valoracion Clinica Anterior: No ");
						report.setHrecdescripcio2("");
					}
					report.setHrectipodescri("Antecedentes Mama");
					report.setHrentipoimpres(6);
					report.setHrencodigo(imp_antecedentes_mama);
					report.setHrenconsulta(consulta.getHcolnumero());
					report.setHrenconsulta(consulta.getHcolnumero());
					report.setHredfecharegis(consulta.getHcodfecregistr());
					lstReporte.add(report);

					if (mostrarValoracion) {
						report = new Chreporte();
						report.setHrecdescripcio("Resultado:  ");
						report.setHrecdescripcio2(formatearCampo(antecemama.getHamcresultado()));
						report.setHrectipodescri("Antecedentes Mama");
						report.setHrentipoimpres(4);
						report.setHrencodigo(imp_antecedentes_mama);
						report.setHrenconsulta(consulta.getHcolnumero());
						report.setHredfecharegis(consulta.getHcodfecregistr());
						lstReporte.add(report);
					}

					boolean mostrarOtro = false;
					String metodo = "";
					String lactancia = "";
					if (antecemama.getHamcmetodo() != null && antecemama.getHamcmetodo().equals("0")) {
						mostrarOtro = true;
						try {
							metodo = serviceLocator.getClinicoService()
									.getDescripcionMetodo(antecemama.getHamcmetodo());
						} catch (ModelException e) {
							e.printStackTrace();
						}
					}
					if (antecemama.getHamnlactacum() != null) {
						if (antecemama.getHamnlactacum().equals(1)) {
							lactancia = " 1 a 5 meses ";
						}
						if (antecemama.getHamnlactacum().equals(2)) {
							lactancia = "6 a 11 meses";
						}
						if (antecemama.getHamnlactacum().equals(3)) {
							lactancia = " 1 a 2 aNos";
						}
						if (antecemama.getHamnlactacum().equals(4)) {
							lactancia = ">2 aNos";
						}
						if (antecemama.getHamnlactacum().equals(5)) {
							lactancia = " N/A";
						}
					}

					report = new Chreporte();
					report.setHrecdescripcio("Metodo:  " + formatearCampo(metodo));
					report.setHrecdescripcio2("Lactancia Acumulada: " + formatearCampo(lactancia));
					report.setHrectipodescri("Antecedentes Mama");
					report.setHrentipoimpres(6);
					report.setHrencodigo(imp_antecedentes_mama);
					report.setHrenconsulta(consulta.getHcolnumero());
					report.setHredfecharegis(consulta.getHcodfecregistr());
					lstReporte.add(report);

					if (mostrarOtro) {
						report = new Chreporte();
						report.setHrecdescripcio("Otro:  " + formatearCampo(antecemama.getHamcotrometod()));
						report.setHrecdescripcio2("");
						report.setHrectipodescri("Antecedentes Mama");
						report.setHrentipoimpres(6);
						report.setHrencodigo(imp_antecedentes_mama);
						report.setHrenconsulta(consulta.getHcolnumero());
						report.setHredfecharegis(consulta.getHcodfecregistr());
						lstReporte.add(report);
					}
				}

			}

			imprimirViolencia(consulta);
			imprimirIdentificaRiesgos(consulta);
			imprimirEstadoPsicoemocional(consulta);
			imprimirOrdenesMedicas(consulta);
			imprimirAsesoriaIve(consulta);
			imprimirAntecedenteDetallado(consulta);
			impresionEcografiaFertilidad(consulta);
			impresionDatosFertilidad(consulta);
			// imprimirAntecedenteDetalladoFertilidad(consulta);
			imprimirAntecedentePsicologia(consulta);
			imprimirInformePsicologico(consulta);
			imprimirEscalaValoracionCaidas(consulta);
			generarReferenciaPaciente(consulta);
			imprimirInformeCovidAnticuerpos(consulta);
			imprimirInformeCovidAntigenos(consulta);
			if ("S".equals(consulta.getHcocreaconinf())) {
				imprimirConsentimientosInformados(consulta);
			}

			if (consulta.getChriesgomamas() != null && !consulta.getChriesgomamas().isEmpty()) {

				Chriesgomama riesgo = null;
				Iterator it = consulta.getChriesgomamas().iterator();
				if (it.hasNext()) {
					riesgo = (Chriesgomama) it.next();
				}

				if (riesgo != null) {
					Chreporte report = new Chreporte();
					report.setHrecdescripcio(
							"Menarquia antes de los 12 aNos:  " + formatearCampo(riesgo.getHrmemenarantes()));
					report.setHrectipodescri("Riesgo de Mama");
					report.setHrencodigo(imp_riesgo_mama);
					report.setHrentipoimpres(1);
					report.setHrenconsulta(consulta.getHcolnumero());
					report.setHredfecharegis(consulta.getHcodfecregistr());
					lstReporte.add(report);

					report = new Chreporte();
					report.setHrecdescripcio(
							"Menopausia despues de los 50 aNos:  " + formatearCampo(riesgo.getHrmemenopadesp()));
					report.setHrectipodescri("Riesgo de Mama");
					report.setHrencodigo(imp_riesgo_mama);
					report.setHrentipoimpres(1);
					report.setHrenconsulta(consulta.getHcolnumero());
					report.setHredfecharegis(consulta.getHcodfecregistr());
					lstReporte.add(report);

					report = new Chreporte();
					report.setHrecdescripcio(
							"Primer Embarazo despues de los 30 aNos:   " + formatearCampo(riesgo.getHrmeembaradesp()));
					report.setHrectipodescri("Riesgo de Mama");
					report.setHrencodigo(imp_riesgo_mama);
					report.setHrentipoimpres(1);
					report.setHrenconsulta(consulta.getHcolnumero());
					report.setHredfecharegis(consulta.getHcodfecregistr());
					lstReporte.add(report);

					report = new Chreporte();
					report.setHrecdescripcio(
							"Terapia de reemplazo hormonal:    " + formatearCampo(riesgo.getHrmeterahormon()));
					if (riesgo.getHrmeterahormon() != null && riesgo.getHrmeterahormon().equals("S")) {
						report.setHrecdescripcio2("CuNntos ANos?:   " + formatearCampo(riesgo.getHrmnanosterap()));
					} else {
						report.setHrecdescripcio2("");
					}
					report.setHrectipodescri("Riesgo de Mama");
					report.setHrencodigo(imp_riesgo_mama);
					report.setHrentipoimpres(6);
					report.setHrenconsulta(consulta.getHcolnumero());
					report.setHredfecharegis(consulta.getHcodfecregistr());
					lstReporte.add(report);

					report = new Chreporte();
					report.setHrecdescripcio(".");
					report.setHrectipodescri("Riesgo de Mama");
					report.setHrencodigo(imp_riesgo_mama);
					report.setHrentipoimpres(6);
					report.setHrenconsulta(consulta.getHcolnumero());
					report.setHredfecharegis(consulta.getHcodfecregistr());
					lstReporte.add(report);

					report = new Chreporte();
					report.setHrecdescripcio(
							"Antecedente personal de cancer:    " + formatearCampo(riesgo.getHrmeantecancer()));
					if (riesgo.getHrmccancerpers() != null && riesgo.getHrmccancerpers().equals("S")) {
						report.setHrecdescripcio2("Tipo Cancer:    " + formatearCampo(riesgo.getHrmccancerpers()));

					}
					report.setHrectipodescri("Riesgo de Mama");
					report.setHrencodigo(imp_riesgo_mama);
					report.setHrentipoimpres(5);
					report.setHrenconsulta(consulta.getHcolnumero());
					report.setHredfecharegis(consulta.getHcodfecregistr());
					lstReporte.add(report);

					report = new Chreporte();
					report.setHrecdescripcio(
							"Familiar con CA de mama:    " + formatearCampo(riesgo.getHrmefamicancer()));
					if (riesgo.getHrmefamicancer() != null && riesgo.getHrmefamicancer().equals("S")) {
						report.setHrecdescripcio2("Cual(es):    " + formatearCampo(riesgo.getHrmccancerfami()));

					}
					report.setHrectipodescri("Riesgo de Mama");
					report.setHrencodigo(imp_riesgo_mama);
					report.setHrentipoimpres(5);
					report.setHrenconsulta(consulta.getHcolnumero());
					report.setHredfecharegis(consulta.getHcodfecregistr());
					lstReporte.add(report);

					report.setHrectipodescri("Riesgo de Mama");
					report.setHrencodigo(imp_riesgo_mama);
					report.setHrentipoimpres(4);
					report.setHrenconsulta(consulta.getHcolnumero());
					report.setHredfecharegis(consulta.getHcodfecregistr());
					lstReporte.add(report);

					report = new Chreporte();
					boolean mostrarAntecedenteBiopsa = false;
					String tieneAntecedenteBiopsa;
					String naturalezaBiopsa = "";
					if (riesgo.getHrmnantebiopma() != null) {
						tieneAntecedenteBiopsa = "S";
						mostrarAntecedenteBiopsa = true;
						if (riesgo.getHrmnantebiopma().equals(1)) {
							naturalezaBiopsa = "Benigno";
						}
						if (riesgo.getHrmnantebiopma().equals(2)) {
							naturalezaBiopsa = "CDIS";
						}
						if (riesgo.getHrmnantebiopma().equals(3)) {
							naturalezaBiopsa = "CLIS";
						}
						if (riesgo.getHrmnantebiopma().equals(4)) {
							naturalezaBiopsa = "Maligno";
						}
						if (riesgo.getHrmnantebiopma().equals(5)) {
							naturalezaBiopsa = "Hiperplasia ductal o lobulillar";
						}

						if (riesgo.getHrmnantebiopma().equals(6)) {
							naturalezaBiopsa = "No recuerda";
						}

					} else {
						tieneAntecedenteBiopsa = "N";
					}
					report.setHrecdescripcio("Antecedentes biopsa de mama:  " + formatearCampo(tieneAntecedenteBiopsa));
					if (mostrarAntecedenteBiopsa) {
						report.setHrecdescripcio2("Naturaleza Biopsa:  " + formatearCampo(naturalezaBiopsa));
					}
					report.setHrectipodescri("Riesgo de Mama");
					report.setHrencodigo(imp_riesgo_mama);
					report.setHrentipoimpres(6);
					report.setHrenconsulta(consulta.getHcolnumero());
					report.setHredfecharegis(consulta.getHcodfecregistr());
					lstReporte.add(report);

					report = new Chreporte();
					String lactanciaAcumulada;
					lactanciaAcumulada = "";
					if (riesgo.getHrmnlactacum() != null) {

						if (riesgo.getHrmnlactacum().equals(1)) {
							lactanciaAcumulada = " 1 a 5 meses ";
						}
						if (riesgo.getHrmnlactacum().equals(2)) {
							lactanciaAcumulada = " 6 a 11 meses ";
						}
						if (riesgo.getHrmnlactacum().equals(3)) {
							lactanciaAcumulada = " 1 a 2 aNos ";
						}
						if (riesgo.getHrmnlactacum().equals(4)) {
							lactanciaAcumulada = " >2 aNos ";
						}
						if (riesgo.getHrmnlactacum().equals(5)) {
							lactanciaAcumulada = " N/A ";
						}

						report.setHrecdescripcio("Lactancia Acumulada: " + formatearCampo(lactanciaAcumulada));
						report.setHrectipodescri("Riesgo de Mama");
						report.setHrencodigo(imp_riesgo_mama);
						report.setHrentipoimpres(1);
						report.setHrenconsulta(consulta.getHcolnumero());
						report.setHredfecharegis(consulta.getHcodfecregistr());
						lstReporte.add(report);
					}
				}

			}

			// Examen Fisico Mama
			if (consulta.getChexafismamas() != null && !consulta.getChexafismamas().isEmpty()) {
				boolean mostrarAnormalDerecha = false;
				boolean mostrarAnormalIzquierda = false;

				Chexafismama examen = null;
				Iterator it = consulta.getChexafismamas().iterator();
				if (it.hasNext()) {
					examen = (Chexafismama) it.next();
				}

				if (examen != null) {

					Chreporte report = new Chreporte();
					String examenMamaDer = "";
					report.setHrectipodescri("Examen Mama");
					if (examen.getHemeexamamader() != null) {
						if (examen.getHemeexamamader().equals("A")) {
							examenMamaDer = "Anormal";
							mostrarAnormalDerecha = true;
						} else if (examen.getHemeexamamader().equals("N")) {
							mostrarAnormalDerecha = false;
							examenMamaDer = "Normal";
						}
					}
					report.setHrecdescripcio("Examen de Mama Derecha:  " + formatearCampo(examenMamaDer));
					report.setHrencodigo(imp_examen_mama);
					report.setHrentipoimpres(1);
					report.setHrenconsulta(consulta.getHcolnumero());
					report.setHredfecharegis(consulta.getHcodfecregistr());
					lstReporte.add(report);

					if (mostrarAnormalDerecha) {

						report = new Chreporte();
						boolean mostrarPezonDerecho = false;
						boolean mostrarAxilaDerecha = false;
						if (examen.getHemelespezonde() != null && examen.getHemelespezonde().equals("S")) {
							mostrarPezonDerecho = true;
						}

						if (examen.getHemelesionaxde() != null && examen.getHemelesionaxde().equals("S")) {
							mostrarAxilaDerecha = true;
						}

						report.setHrectipodescri("Examen Mama");
						report.setHrecdescripcio("PezNn:  " + formatearCampo(examen.getHemelespezonde()));
						report.setHrencodigo(imp_examen_mama);
						report.setHrentipoimpres(1);
						report.setHrenconsulta(consulta.getHcolnumero());
						report.setHredfecharegis(consulta.getHcodfecregistr());
						lstReporte.add(report);

						if (mostrarPezonDerecho) {
							report = new Chreporte();
							report.setHrectipodescri("Examen Mama");
							report.setHrecdescripcio(
									"Tipo LesiNn PezNn:  " + formatearCampo(examen.getHemctipolepede()));
							report.setHrencodigo(imp_examen_mama);
							report.setHrentipoimpres(1);
							report.setHrenconsulta(consulta.getHcolnumero());
							report.setHredfecharegis(consulta.getHcodfecregistr());
							lstReporte.add(report);
						}

						report = new Chreporte();
						report.setHrectipodescri("Examen Mama");
						report.setHrecdescripcio("Mama:  " + formatearCampo(examen.getHemelesimamade()));
						report.setHrencodigo(imp_examen_mama);
						report.setHrentipoimpres(1);
						report.setHrenconsulta(consulta.getHcolnumero());
						report.setHredfecharegis(consulta.getHcodfecregistr());
						lstReporte.add(report);

						report = new Chreporte();
						report.setHrectipodescri("Examen Mama");
						report.setHrecdescripcio("Axila:  " + formatearCampo(examen.getHemelesionaxde()));
						report.setHrencodigo(imp_examen_mama);
						report.setHrentipoimpres(1);
						report.setHrenconsulta(consulta.getHcolnumero());
						report.setHredfecharegis(consulta.getHcodfecregistr());
						lstReporte.add(report);

						if (mostrarAxilaDerecha) {
							report = new Chreporte();
							report.setHrectipodescri("Examen Mama");
							report.setHrecdescripcio(
									"Tipo LesiNn Axila:  " + formatearCampo(examen.getHemctipolesaxde()));
							report.setHrencodigo(imp_examen_mama);
							report.setHrentipoimpres(1);
							report.setHrenconsulta(consulta.getHcolnumero());
							report.setHredfecharegis(consulta.getHcodfecregistr());
							lstReporte.add(report);
						}

						report = new Chreporte();
						String lesionpielDerecha = "";
						report.setHrectipodescri("Examen Mama");
						report.setHrecdescripcio("LesiNn en piel:  " + formatearCampo(examen.getHemelesipielde()));
						if (examen.getHemelesipielde() != null && examen.getHemelesipielde().equals("S")) {
							if (examen.getHemetipolepide() != null && !examen.getHemetipolepide().equals("")) {
								if (examen.getHemetipolepide().equals("E")) {
									lesionpielDerecha = "Edema";
								}
								if (examen.getHemetipolepide().equals("R")) {
									lesionpielDerecha = "RetracciNn";
								}
								if (examen.getHemetipolepide().equals("U")) {
									lesionpielDerecha = "Ulcera";
								}
								report.setHrecdescripcio2("Tipo LesiNn : " + formatearCampo(lesionpielDerecha));
							}
						}
						report.setHrencodigo(imp_examen_mama);
						report.setHrentipoimpres(6);
						report.setHrenconsulta(consulta.getHcolnumero());
						report.setHredfecharegis(consulta.getHcodfecregistr());
						lstReporte.add(report);

						report = new Chreporte();
						String secrecionDerecha = "";
						String tipoSecrecionDerecha = "";
						report.setHrectipodescri("Examen Mama");
						if (examen.getHemesecreciode() != null) {
							report.setHrecdescripcio("Tiene SecreciNn: Si ");
							if (examen.getHemesecreciode().equals("P")) {
								secrecionDerecha = "PresiNn";
							}
							if (examen.getHemesecreciode().equals("E")) {
								secrecionDerecha = "Espontanea";
							}

							if (examen.getHemetiposecrde().equals("C")) {
								tipoSecrecionDerecha = "Cristalina";
							}
							if (examen.getHemetiposecrde().equals("A")) {
								tipoSecrecionDerecha = "Amarillenta";
							}
							if (examen.getHemetiposecrde().equals("S")) {
								tipoSecrecionDerecha = "Sanguinolenta";
							}
							if (examen.getHemetiposecrde().equals("V")) {
								tipoSecrecionDerecha = "Verdosa";
							}
							report.setHrecdescripcio2("SecreciNn:  " + formatearCampo(secrecionDerecha));
							report.setHrecdescripcio3("Tipo SecreciNn:  " + formatearCampo(tipoSecrecionDerecha));
						} else {
							report.setHrecdescripcio("Tiene SecreciNn: No");
						}
						report.setHrencodigo(imp_examen_mama);
						report.setHrentipoimpres(5);
						report.setHrenconsulta(consulta.getHcolnumero());
						report.setHredfecharegis(consulta.getHcodfecregistr());
						lstReporte.add(report);

						report = new Chreporte();
						report.setHrectipodescri("Examen Mama");
						report.setHrecdescripcio("Masa:  " + formatearCampo(examen.getHememasaderech()));
						if (examen.getHememasaderech() != null && examen.getHememasaderech().equals("S")) {
							report.setHrecdescripcio2(
									"Diametro apx en mm : " + formatearCampo(examen.getHemndiammasade()));
						}
						report.setHrencodigo(imp_examen_mama);
						report.setHrentipoimpres(6);
						report.setHrenconsulta(consulta.getHcolnumero());
						report.setHredfecharegis(consulta.getHcodfecregistr());
						lstReporte.add(report);

						report = new Chreporte();
						report.setHrectipodescri("Examen Mama");
						report.setHrecdescripcio("Dolorosa:  " + formatearCampo(examen.getHemedolorosade()));
						report.setHrencodigo(imp_examen_mama);
						report.setHrentipoimpres(1);
						report.setHrenconsulta(consulta.getHcolnumero());
						report.setHredfecharegis(consulta.getHcodfecregistr());
						lstReporte.add(report);

						if (examen.getHemedolorosade() != null && examen.getHemedolorosade().equals("S")) {

							report = new Chreporte();
							report.setHrectipodescri("Examen Mama");
							report.setHrecdescripcio("Tipo Dolor:  " + formatearCampo(examen.getHemctipodolode()));
							report.setHrencodigo(imp_examen_mama);
							report.setHrentipoimpres(1);
							report.setHrenconsulta(consulta.getHcolnumero());
							report.setHredfecharegis(consulta.getHcodfecregistr());
							lstReporte.add(report);

						}

					}

					report = new Chreporte();
					String examenMamaIzq = "";
					report.setHrectipodescri("Examen Mama");
					if (examen.getHemeexamamaizq() != null) {
						if (examen.getHemeexamamaizq().equals("A")) {
							examenMamaIzq = "Anormal";
							mostrarAnormalIzquierda = true;
						} else if (examen.getHemeexamamaizq().equals("N")) {
							examenMamaIzq = "Normal";
							mostrarAnormalIzquierda = false;
						}
					}
					report.setHrecdescripcio("Examen de Mama Izquierda:  " + formatearCampo(examenMamaIzq));
					report.setHrencodigo(imp_examen_mama);
					report.setHrentipoimpres(1);
					report.setHrenconsulta(consulta.getHcolnumero());
					report.setHredfecharegis(consulta.getHcodfecregistr());
					lstReporte.add(report);

					if (mostrarAnormalIzquierda) {
						report = new Chreporte();
						boolean mostrarPezonIzquierdo = false;
						boolean mostrarAxilaIzquierda = false;
						if (examen.getHemelespezoniz() != null && examen.getHemelespezoniz().equals("S")) {
							mostrarPezonIzquierdo = true;
						}

						if (examen.getHemelesionaxiz() != null && examen.getHemelesionaxiz().equals("S")) {
							mostrarAxilaIzquierda = true;
						}

						report.setHrectipodescri("Examen Mama");
						report.setHrecdescripcio("PezNn:  " + formatearCampo(examen.getHemelespezoniz()));
						report.setHrencodigo(imp_examen_mama);
						report.setHrentipoimpres(1);
						report.setHrenconsulta(consulta.getHcolnumero());
						report.setHredfecharegis(consulta.getHcodfecregistr());
						lstReporte.add(report);

						if (mostrarPezonIzquierdo) {
							report = new Chreporte();
							report.setHrectipodescri("Examen Mama");
							report.setHrecdescripcio(
									"Tipo LesiNn PezNn:  " + formatearCampo(examen.getHemctipolepeiz()));
							report.setHrencodigo(imp_examen_mama);
							report.setHrentipoimpres(1);
							report.setHrenconsulta(consulta.getHcolnumero());
							report.setHredfecharegis(consulta.getHcodfecregistr());
							lstReporte.add(report);
						}

						report = new Chreporte();
						report.setHrectipodescri("Examen Mama");
						report.setHrecdescripcio("Mama:  " + formatearCampo(examen.getHemelesimamaiz()));
						report.setHrencodigo(imp_examen_mama);
						report.setHrentipoimpres(1);
						report.setHrenconsulta(consulta.getHcolnumero());
						report.setHredfecharegis(consulta.getHcodfecregistr());
						lstReporte.add(report);

						report = new Chreporte();
						report.setHrectipodescri("Examen Mama");
						report.setHrecdescripcio("Axila:  " + formatearCampo(examen.getHemelesionaxiz()));
						report.setHrencodigo(imp_examen_mama);
						report.setHrentipoimpres(1);
						report.setHrenconsulta(consulta.getHcolnumero());
						report.setHredfecharegis(consulta.getHcodfecregistr());
						lstReporte.add(report);

						if (mostrarAxilaIzquierda) {
							report = new Chreporte();
							report.setHrectipodescri("Examen Mama");
							report.setHrecdescripcio(
									"Tipo LesiNn Axila:  " + formatearCampo(examen.getHemctipolesaxiz()));
							report.setHrencodigo(imp_examen_mama);
							report.setHrentipoimpres(1);
							report.setHrenconsulta(consulta.getHcolnumero());
							report.setHredfecharegis(consulta.getHcodfecregistr());
							lstReporte.add(report);
						}

						report = new Chreporte();
						String lesionpielIzquierda = "";
						report.setHrectipodescri("Examen Mama");
						report.setHrecdescripcio("LesiNn en piel:  " + formatearCampo(examen.getHemelesipieliz()));
						if (examen.getHemelesipieliz() != null && examen.getHemelesipieliz().equals("S")) {
							if (examen.getHemetipolepiiz() != null && !examen.getHemetipolepiiz().equals("")) {
								if (examen.getHemetipolepiiz().equals("E")) {
									lesionpielIzquierda = "Edema";
								}
								if (examen.getHemetipolepiiz().equals("R")) {
									lesionpielIzquierda = "RetracciNn";
								}
								if (examen.getHemetipolepiiz().equals("U")) {
									lesionpielIzquierda = "Ulcera";
								}
								report.setHrecdescripcio2("Tipo LesiNn : " + formatearCampo(lesionpielIzquierda));
							}
						}
						report.setHrencodigo(imp_examen_mama);
						report.setHrentipoimpres(6);
						report.setHrenconsulta(consulta.getHcolnumero());
						report.setHredfecharegis(consulta.getHcodfecregistr());
						lstReporte.add(report);

						report = new Chreporte();
						String secrecionIzquierda = "";
						String tipoSecrecionIzquierda = "";
						report.setHrectipodescri("Examen Mama");
						if (examen.getHemesecrecioiz() != null) {
							report.setHrecdescripcio("Tiene SecreciNn: Si ");
							if (examen.getHemesecrecioiz().equals("P")) {
								secrecionIzquierda = "PresiNn";
							}
							if (examen.getHemesecrecioiz().equals("E")) {
								secrecionIzquierda = "Espontanea";
							}

							if (examen.getHemetiposecriz().equals("C")) {
								tipoSecrecionIzquierda = "Cristalina";
							}
							if (examen.getHemetiposecriz().equals("A")) {
								tipoSecrecionIzquierda = "Amarillenta";
							}
							if (examen.getHemetiposecriz().equals("S")) {
								tipoSecrecionIzquierda = "Sanguinolenta";
							}
							if (examen.getHemetiposecriz().equals("V")) {
								tipoSecrecionIzquierda = "Verdosa";
							}
							report.setHrecdescripcio2("SecreciNn:  " + formatearCampo(secrecionIzquierda));
							report.setHrecdescripcio3("Tipo SecreciNn:  " + formatearCampo(tipoSecrecionIzquierda));
						} else {
							report.setHrecdescripcio("Tiene SecreciNn: No");
						}
						report.setHrencodigo(imp_examen_mama);
						report.setHrentipoimpres(5);
						report.setHrenconsulta(consulta.getHcolnumero());
						report.setHredfecharegis(consulta.getHcodfecregistr());
						lstReporte.add(report);

						report = new Chreporte();
						report.setHrectipodescri("Examen Mama");
						report.setHrecdescripcio("Masa:  " + formatearCampo(examen.getHememasaizquie()));
						if (examen.getHememasaizquie() != null && examen.getHememasaizquie().equals("S")) {
							report.setHrecdescripcio2(
									"Diametro apx en cm : " + formatearCampo(examen.getHemndiammasaiz()));
						}
						report.setHrencodigo(imp_examen_mama);
						report.setHrentipoimpres(6);
						report.setHrenconsulta(consulta.getHcolnumero());
						report.setHredfecharegis(consulta.getHcodfecregistr());
						lstReporte.add(report);

						report = new Chreporte();
						report.setHrectipodescri("Examen Mama");
						report.setHrecdescripcio("Dolorosa:  " + formatearCampo(examen.getHemedolorosaiz()));
						report.setHrencodigo(imp_examen_mama);
						report.setHrentipoimpres(1);
						report.setHrenconsulta(consulta.getHcolnumero());
						report.setHredfecharegis(consulta.getHcodfecregistr());
						lstReporte.add(report);

						if (examen.getHemedolorosaiz() != null && examen.getHemedolorosaiz().equals("S")) {

							report = new Chreporte();
							report.setHrectipodescri("Examen Mama");
							report.setHrecdescripcio("Tipo Dolor:  " + formatearCampo(examen.getHemctipodoloiz()));
							report.setHrencodigo(imp_examen_mama);
							report.setHrentipoimpres(1);
							report.setHrenconsulta(consulta.getHcolnumero());
							report.setHredfecharegis(consulta.getHcodfecregistr());
							lstReporte.add(report);

						}

					}
				}

			}

			// Datos Examen Fisico Preanestesia

			if (consulta.getChexafisane() != null && !consulta.getChexafisane().isEmpty()) {

				Chexafisane examen = null;
				Iterator it = consulta.getChexafisane().iterator();
				if (it.hasNext()) {
					examen = (Chexafisane) it.next();
				}

				Chreporte report = new Chreporte();
				report.setHrectipodescri("Examen Fisico Preanestesia");

				report = new Chreporte();
				report.setHrectipodescri("Examen Fisico Preanestesia");
				if (APERTURA_ORAL_PREANESTESIA != null && !APERTURA_ORAL_PREANESTESIA.equals("")) {
					report.setHrecdescripcio("Apertura Oral: " + formatearCampo(APERTURA_ORAL_PREANESTESIA));
				} else {
					report.setHrecdescripcio("");
				}
				report.setHrencodigo(imp_examen_fisico_preanestesia);
				report.setHrentipoimpres(1);
				report.setHrenconsulta(consulta.getHcolnumero());
				report.setHredfecharegis(consulta.getHcodfecregistr());
				lstReporte.add(report);

				report = new Chreporte();
				report.setHrectipodescri("Examen Fisico Preanestesia");
				if (MALLAMPATI_PREANESTESIA != null && !MALLAMPATI_PREANESTESIA.equals("")) {
					report.setHrecdescripcio("Mallampati: " + formatearCampo(MALLAMPATI_PREANESTESIA));
				} else {
					report.setHrecdescripcio("");
				}

				if (DISTANCIA_MENTOTIROIDEA != null && !DISTANCIA_MENTOTIROIDEA.equals("")) {
					report.setHrecdescripcio2(
							"Distancia Mento - Tiroidea (cm) : " + formatearCampo(DISTANCIA_MENTOTIROIDEA));
				} else {
					report.setHrecdescripcio2("");
				}

				report.setHrencodigo(imp_examen_fisico_preanestesia);
				report.setHrentipoimpres(2);
				report.setHrenconsulta(consulta.getHcolnumero());
				report.setHredfecharegis(consulta.getHcodfecregistr());
				lstReporte.add(report);

				report = new Chreporte();
				report.setHrectipodescri("Examen Fisico Preanestesia");
				if (MOVILIDAD_MANDIBULA != null && !MOVILIDAD_MANDIBULA.equals("")) {
					report.setHrecdescripcio(
							"Movilidad anterior de la mandNbula : " + formatearCampo(MOVILIDAD_MANDIBULA));
				} else {
					report.setHrecdescripcio("");
				}
				report.setHrencodigo(imp_examen_fisico_preanestesia);
				report.setHrentipoimpres(1);
				report.setHrenconsulta(consulta.getHcolnumero());
				report.setHredfecharegis(consulta.getHcodfecregistr());
				lstReporte.add(report);

				report = new Chreporte();
				report.setHrectipodescri("Examen Fisico Preanestesia");
				if (MOVILIDAD_ATLANTO_OCCIPITAL != null && !MOVILIDAD_ATLANTO_OCCIPITAL.equals("")) {
					report.setHrecdescripcio(
							"Movilidad atlanto - occipital: " + formatearCampo(MOVILIDAD_ATLANTO_OCCIPITAL));
				} else {
					report.setHrecdescripcio("");
				}

				if (EVALUACION_GLOBAL_VIA_AEREA != null && !EVALUACION_GLOBAL_VIA_AEREA.equals("")) {
					report.setHrecdescripcio2(
							"EvaluaciNn global vNa aNrea : " + formatearCampo(EVALUACION_GLOBAL_VIA_AEREA));
				} else {
					report.setHrecdescripcio2("");
				}

				report.setHrencodigo(imp_examen_fisico_preanestesia);
				report.setHrentipoimpres(2);
				report.setHrenconsulta(consulta.getHcolnumero());
				report.setHredfecharegis(consulta.getHcodfecregistr());
				lstReporte.add(report);

				report = new Chreporte();
				report.setHrectipodescri("Examen Fisico Preanestesia");
				if (PROTESIS_DENTAL != null && !PROTESIS_DENTAL.equals("")) {
					report.setHrecdescripcio("Protesis dental : " + formatearCampo(PROTESIS_DENTAL));
				} else {
					report.setHrecdescripcio("");
				}
				report.setHrencodigo(imp_examen_fisico_preanestesia);
				report.setHrentipoimpres(1);
				report.setHrenconsulta(consulta.getHcolnumero());
				report.setHredfecharegis(consulta.getHcodfecregistr());
				lstReporte.add(report);

				if (examen.getHeactieneprote() != null && examen.getHeactieneprote().equals("S")) {

					if (examen.getHeactieneproin() != null && examen.getHeactieneproin().equals("S")) {
						report = new Chreporte();
						report.setHrectipodescri("Examen Fisico Preanestesia");
						report.setHrecdescripcio("Protesis Inferior " + PROTESIS_INFERIOR);
						report.setHrecdescripcio2("Grado Protesis " + GRADO_PROTESIS_INFERIOR);
						report.setHrecdescripcio3("Movilidad Protesis " + MOVILIDAD_PROTESIS_INFERIOR);
						report.setHrencodigo(imp_examen_fisico_preanestesia);
						report.setHrentipoimpres(5);
						report.setHrenconsulta(consulta.getHcolnumero());
						report.setHredfecharegis(consulta.getHcodfecregistr());
						lstReporte.add(report);
					}

					if (examen.getHeactieneprosu() != null && examen.getHeactieneprosu().equals("S")) {
						report = new Chreporte();
						report.setHrectipodescri("Examen Fisico Preanestesia");
						report.setHrecdescripcio("Protesis Superior  " + PROTESIS_SUPERIOR);
						report.setHrecdescripcio2("Grado Superior " + GRADO_PROTESIS_SUPERIOR);
						report.setHrecdescripcio3("Movilidad Superior " + MOVILIDAD_PROTESIS_SUPERIOR);
						report.setHrencodigo(imp_examen_fisico_preanestesia);
						report.setHrentipoimpres(5);
						report.setHrenconsulta(consulta.getHcolnumero());
						report.setHredfecharegis(consulta.getHcodfecregistr());
						lstReporte.add(report);
					}

				}

			}

			// DATOS RESULTADOS EXAMENES PARACLINICOS PRE ANESTESIA

			if (consulta.getChresulparac() != null && !consulta.getChresulparac().isEmpty()) {

				Chresulparac resultado = null;
				Iterator it = consulta.getChresulparac().iterator();
				if (it.hasNext()) {
					resultado = (Chresulparac) it.next();
				}

				if (resultado != null) {

					Chreporte report = new Chreporte();
					report.setHrectipodescri("Resultado Examenes");

					if (HEMOGLOBINA_PREANESTESIA != null && !HEMOGLOBINA_PREANESTESIA.equals("")) {
						report.setHrecdescripcio("Hemoglobina (gr/dl)  " + formatearCampo(HEMOGLOBINA_PREANESTESIA));
					} else {
						report.setHrecdescripcio("");
					}

					if (HEMATOCRITO_PREANESTESIA != null && !HEMATOCRITO_PREANESTESIA.equals("")) {
						report.setHrecdescripcio2("Hematocrito(%): " + formatearCampo(HEMATOCRITO_PREANESTESIA));
					} else {
						report.setHrecdescripcio2("");
					}

					if (LEUCOCITOS_PREANESTESIA != null && !LEUCOCITOS_PREANESTESIA.equals("")) {
						report.setHrecdescripcio3(
								"Leucocitos Nl(microlitros): " + formatearCampo(LEUCOCITOS_PREANESTESIA));
					} else {
						report.setHrecdescripcio3("");
					}

					if (PT_PREANESTESIA != null && !PT_PREANESTESIA.equals("")) {
						report.setHrecdescripcio4("PT(segundos): " + formatearCampo(PT_PREANESTESIA));
					} else {
						report.setHrecdescripcio4("");
					}

					report.setHrencodigo(imp_resultados_paraclinicos_preanestesia);
					report.setHrentipoimpres(4);
					report.setHrenconsulta(consulta.getHcolnumero());
					report.setHredfecharegis(consulta.getHcodfecregistr());
					lstReporte.add(report);

					report = new Chreporte();
					report.setHrectipodescri("Resultado Examenes");

					if (INR_PREANESTESIA != null && !INR_PREANESTESIA.equals("")) {
						report.setHrecdescripcio("INR  " + formatearCampo(INR_PREANESTESIA));
					} else {
						report.setHrecdescripcio("");
					}

					if (PTT_PREANESTESIA != null && !PTT_PREANESTESIA.equals("")) {
						report.setHrecdescripcio2("PTT(segundos): " + formatearCampo(PTT_PREANESTESIA));
					} else {
						report.setHrecdescripcio2("");
					}

					if (PLAQUETAS_PREANESTESIA != null && !PLAQUETAS_PREANESTESIA.equals("")) {
						report.setHrecdescripcio3(
								"Plaquetas Nl(microlitros): " + formatearCampo(PLAQUETAS_PREANESTESIA));
					} else {
						report.setHrecdescripcio3("");
					}

					report.setHrecdescripcio4("");

					report.setHrencodigo(imp_resultados_paraclinicos_preanestesia);
					report.setHrentipoimpres(4);
					report.setHrenconsulta(consulta.getHcolnumero());
					report.setHredfecharegis(consulta.getHcodfecregistr());
					lstReporte.add(report);

					report = new Chreporte();
					report.setHrectipodescri("Resultado Examenes");

					if (PARCIAL_ORINA_PREANESTESIA != null && !PARCIAL_ORINA_PREANESTESIA.equals("")) {
						report.setHrecdescripcio("Parcial de orina  " + PARCIAL_ORINA_PREANESTESIA);
					} else {
						report.setHrecdescripcio("");
					}
					report.setHrencodigo(imp_resultados_paraclinicos_preanestesia);
					report.setHrentipoimpres(1);
					report.setHrenconsulta(consulta.getHcolnumero());
					report.setHredfecharegis(consulta.getHcodfecregistr());
					lstReporte.add(report);

					report = new Chreporte();
					report.setHrectipodescri("Resultado Examenes");

					if (GLICEMIA_PRE_PREANESTESIA != null && !GLICEMIA_PRE_PREANESTESIA.equals("")) {
						report.setHrecdescripcio("Glicemia Pre (mg/dl)  " + formatearCampo(GLICEMIA_PRE_PREANESTESIA));
					} else {
						report.setHrecdescripcio("");
					}

					if (GLICEMIA_POST_PREANESTESIA != null && !GLICEMIA_POST_PREANESTESIA.equals("")) {
						report.setHrecdescripcio2(
								"Glicemia Post (mg/dl): " + formatearCampo(GLICEMIA_POST_PREANESTESIA));
					} else {
						report.setHrecdescripcio2("");
					}

					if (NITROGENO_PREANESTESIA != null && !NITROGENO_PREANESTESIA.equals("")) {
						report.setHrecdescripcio3("NitrNgeno ureNco(mg/dl): " + formatearCampo(NITROGENO_PREANESTESIA));
					} else {
						report.setHrecdescripcio3("");
					}

					if (CREATININA_PREANESTESIA != null && !CREATININA_PREANESTESIA.equals("")) {
						report.setHrecdescripcio4("Creatinina(mg/dl) : " + formatearCampo(CREATININA_PREANESTESIA));
					} else {
						report.setHrecdescripcio4("");
					}

					report.setHrencodigo(imp_resultados_paraclinicos_preanestesia);
					report.setHrentipoimpres(4);
					report.setHrenconsulta(consulta.getHcolnumero());
					report.setHredfecharegis(consulta.getHcodfecregistr());
					lstReporte.add(report);

					report = new Chreporte();
					report.setHrectipodescri("Resultado Examenes");

					if (ELECTROCARDIOGRAMA_PREANESTESIA != null && !ELECTROCARDIOGRAMA_PREANESTESIA.equals("")) {
						report.setHrecdescripcio(
								"Electrocardiograma  " + formatearCampo(ELECTROCARDIOGRAMA_PREANESTESIA));
					} else {
						report.setHrecdescripcio("");
					}
					report.setHrencodigo(imp_resultados_paraclinicos_preanestesia);
					report.setHrentipoimpres(1);
					report.setHrenconsulta(consulta.getHcolnumero());
					report.setHredfecharegis(consulta.getHcodfecregistr());
					lstReporte.add(report);

					report = new Chreporte();
					report.setHrectipodescri("Resultado Examenes");

					if (RAYOS_X_PREANESTESIA != null && !RAYOS_X_PREANESTESIA.equals("")) {
						report.setHrecdescripcio("Rayos X de TNrax  " + formatearCampo(RAYOS_X_PREANESTESIA));
					} else {
						report.setHrecdescripcio("");
					}
					report.setHrencodigo(imp_resultados_paraclinicos_preanestesia);
					report.setHrentipoimpres(1);
					report.setHrenconsulta(consulta.getHcolnumero());
					report.setHredfecharegis(consulta.getHcodfecregistr());
					lstReporte.add(report);

					report = new Chreporte();
					report.setHrectipodescri("Resultado Examenes");

					if (ECOGRAFIAS_PREANESTESIA != null && !ECOGRAFIAS_PREANESTESIA.equals("")) {
						report.setHrecdescripcio("EcografNas  " + formatearCampo(ECOGRAFIAS_PREANESTESIA));
					} else {
						report.setHrecdescripcio("");
					}
					report.setHrencodigo(imp_resultados_paraclinicos_preanestesia);
					report.setHrentipoimpres(1);
					report.setHrenconsulta(consulta.getHcolnumero());
					report.setHredfecharegis(consulta.getHcodfecregistr());
					lstReporte.add(report);

					report = new Chreporte();
					report.setHrectipodescri("Resultado Examenes");

					if (OTROS_RESULTADOS_PREANESTESIA != null && !OTROS_RESULTADOS_PREANESTESIA.equals("")) {
						report.setHrecdescripcio(
								"Otros resultados de laboratorio  " + formatearCampo(OTROS_RESULTADOS_PREANESTESIA));
					} else {
						report.setHrecdescripcio("");
					}
					report.setHrencodigo(imp_resultados_paraclinicos_preanestesia);
					report.setHrentipoimpres(1);
					report.setHrenconsulta(consulta.getHcolnumero());
					report.setHredfecharegis(consulta.getHcodfecregistr());
					lstReporte.add(report);

				}
			}

			// Datos Examen Fisico

			if (consulta.getChexamfisicos() != null && !consulta.getChexamfisicos().isEmpty()) {
				Chexamfisico examen = null;
				Iterator it = consulta.getChexamfisicos().iterator();
				if (it.hasNext()) {
					examen = (Chexamfisico) it.next();
				}

				Chreporte report = new Chreporte();
				report.setHrectipodescri("Examen Fisico");

				if (examen.getHefcpresart1() != null && examen.getHefcpresart2() != null) {
					report.setHrecdescripcio("PresiNn Arterial:  " + formatearCampo(PRESION_ARTERIAL));
				} else {
					report.setHrecdescripcio("");
				}

				if (examen.getHefnfreccard() != null) {
					report.setHrecdescripcio2("Frecuencia Cardiaca: " + formatearCampo(FRECUENCIA_CARDIACA));
				} else {
					report.setHrecdescripcio2("");
				}

				if (examen.getHefnfrecresp() != null) {
					report.setHrecdescripcio3("Frecuencia Respiratoria: " + formatearCampo(FRECUENCIA_RESPIRATORIA));
				} else {
					report.setHrecdescripcio3("");
				}

				report.setHrencodigo(imp_examen_fisico);
				report.setHrentipoimpres(5);
				report.setHrenconsulta(consulta.getHcolnumero());
				report.setHredfecharegis(consulta.getHcodfecregistr());
				lstReporte.add(report);

				if (examen != null) {
					report = new Chreporte();
					report.setHrectipodescri("Examen Fisico");
					if (examen.getHefapeso() != null) {
						report.setHrecdescripcio("Peso:  " + formatearCampo(PESO));
					} else {
						report.setHrecdescripcio("");
					}

					if (examen.getHefatalla() != null) {
						report.setHrecdescripcio2("Talla : " + formatearCampo(TALLA));
					} else {
						report.setHrecdescripcio2("");
					}

					if (examen.getHefaimc() != null) {
						report.setHrecdescripcio3("IMC: " + formatearCampo(examen.getHefaimc()));
					} else {
						report.setHrecdescripcio3("");
					}

					report.setHrencodigo(imp_examen_fisico);
					report.setHrentipoimpres(5);
					report.setHrenconsulta(consulta.getHcolnumero());
					report.setHredfecharegis(consulta.getHcodfecregistr());
					lstReporte.add(report);
				}

				report = new Chreporte();
				report.setHrectipodescri("Examen Fisico");
				if (examen.getHefelugartemp() != null) {
					report.setHrecdescripcio("Tipo Temperatura: " + formatearCampo(LUGAR_TEMPERATURA));

					if (examen.getHefetipotemper() != null && !examen.getHefetipotemper().equals("")) {
						report.setHrecdescripcio2("Resultado: " + formatearCampo(TIPO_TEMPERATURA));
					} else {
						report.setHrecdescripcio2("");
					}

					if (examen.getHefatemperatu() != null) {
						report.setHrecdescripcio3("Temperatura: " + formatearCampo(TEMPERATURA));
					} else {
						report.setHrecdescripcio3("");
					}

				} else {
					if (examen.getHefetipotemper() != null && !examen.getHefetipotemper().equals("")) {
						report.setHrecdescripcio("Tipo Temperatura: " + formatearCampo(TIPO_TEMPERATURA));
					} else {
						report.setHrecdescripcio("");
					}

					if (examen.getHefatemperatu() != null) {
						report.setHrecdescripcio2("Temperatura : " + formatearCampo(TEMPERATURA));
					} else {
						report.setHrecdescripcio2("");
					}
				}
				report.setHrencodigo(imp_examen_fisico);
				report.setHrentipoimpres(5);
				report.setHrenconsulta(consulta.getHcolnumero());
				report.setHredfecharegis(consulta.getHcodfecregistr());
				lstReporte.add(report);

				if (examen.getHefcdiscapadid() != null && !examen.getHefcdiscapadid().equals("")) {
					report = new Chreporte();
					report.setHrectipodescri("Examen Fisico");
					if (examen.getHefapeso() != null) {
						report.setHrecdescripcio(
								"CondiciNn de Discapacidad:  " + formatearCampo(examen.getHefcdiscapadid()));
					}

					if (examen.getHefcdiscapadid().equals("S")) {
						report.setHrecdescripcio2("Cual?: " + formatearCampoDiscapacidad(examen.getHefcdiscaselec()));
					} else {
						report.setHrecdescripcio2("");
					}

					report.setHrecdescripcio3("");

					report.setHrencodigo(imp_examen_fisico);
					report.setHrentipoimpres(5);
					report.setHrenconsulta(consulta.getHcolnumero());
					report.setHredfecharegis(consulta.getHcodfecregistr());
					lstReporte.add(report);
				}

				if (examen.getHefnspo2() != null) {
					report = new Chreporte();
					report.setHrectipodescri("Examen Fisico");
					report.setHrecdescripcio("Spo2:  " + examen.getHefnspo2().toString() + " %");
					report.setHrencodigo(imp_examen_fisico);
					report.setHrentipoimpres(1);
					report.setHrenconsulta(consulta.getHcolnumero());
					report.setHredfecharegis(consulta.getHcodfecregistr());
					lstReporte.add(report);
				}

				if (examen.getHefthallazgo() != null && !examen.getHefthallazgo().equals("")) {
					report = new Chreporte();
					report.setHrectipodescri("Examen Fisico");
					report.setHrecdescripcio("Estado del paciente al ingreso");
					report.setHrecdescripcio2(formatearCampo(HALLAZGOS_EXAMEN_FISICO));
					report.setHrencodigo(imp_examen_fisico);
					report.setHrentipoimpres(3);
					report.setHrenconsulta(consulta.getHcolnumero());
					report.setHredfecharegis(consulta.getHcodfecregistr());
					lstReporte.add(report);

				}

				if (examen.getHefnescadolor() != null) {
					report = new Chreporte();
					report.setHrectipodescri("Examen Fisico");
					report.setHrecdescripcio("Escala del Dolor ");
					report.setHrecdescripcio2(formatearCampo(examen.getHefnescadolor()));
					report.setHrencodigo(imp_examen_fisico);
					report.setHrentipoimpres(3);
					report.setHrenconsulta(consulta.getHcolnumero());
					report.setHredfecharegis(consulta.getHcodfecregistr());
					lstReporte.add(report);

					report = new Chreporte();
					report.setHrectipodescri("Examen Fisico");
					report.setHrecdescripcio("DuraciNn del dolor Intenso         ");
					report.setHrecdescripcio2(formatearCampo(examen.getHefnduradolor()) + " "
							+ formatearCampoTipoDuracion(examen.getHefcdudointen()));
					report.setHrencodigo(imp_examen_fisico);
					report.setHrentipoimpres(3);
					report.setHrenconsulta(consulta.getHcolnumero());
					report.setHredfecharegis(consulta.getHcodfecregistr());
					lstReporte.add(report);

				}

				if (examen.getHeferefiepiel() != null && !examen.getHeferefiepiel().equals("")) {
					report = new Chreporte();
					report.setHrectipodescri("Examen Fisico");
					report.setHrecdescripcio("Piel y faneras: ");

					if (examen.getHeferefiepiel().equals("A")) {
						report.setHrecdescripcio2("Sin Alteraciones aparentes");
					} else if (examen.getHeferefiepiel().equals("H")) {
						report.setHrecdescripcio2(formatearCampo(examen.getHefcrefiepiel()));
					} else if (examen.getHeferefiepiel().equals("N")) {
						report.setHrecdescripcio2("No evaluado");
					} else if (examen.getHeferefiepiel().equals("S")) {
						report.setHrecdescripcio2("Sin Alteraciones aparentes");
					} else if (examen.getHeferefiepiel().equals("E")) {
						report.setHrecdescripcio2("Evaluado - Sin hallazgo aparente");
					}
					report.setHrencodigo(imp_examen_fisico);
					report.setHrentipoimpres(3);
					report.setHrenconsulta(consulta.getHcolnumero());
					report.setHredfecharegis(consulta.getHcodfecregistr());
					lstReporte.add(report);
				}

				if (examen.getHeferefiecrane() != null && !examen.getHeferefiecrane().equals("")) {
					report = new Chreporte();
					report.setHrectipodescri("Examen Fisico");
					report.setHrecdescripcio("Craneo: ");

					if (examen.getHeferefiecrane().equals("A")) {
						report.setHrecdescripcio2("Sin Alteraciones aparentes");
					} else if (examen.getHeferefiecrane().equals("H")) {
						report.setHrecdescripcio2(formatearCampo(examen.getHefcrefiecrane()));
					} else if (examen.getHeferefiecrane().equals("N")) {
						report.setHrecdescripcio2("No evaluado");
					} else if (examen.getHeferefiecrane().equals("S")) {
						report.setHrecdescripcio2("Sin Alteraciones aparentes");
					} else if (examen.getHeferefiecrane().equals("E")) {
						report.setHrecdescripcio2("Evaluado - Sin hallazgo aparente");
					}

					report.setHrencodigo(imp_examen_fisico);
					report.setHrentipoimpres(3);
					report.setHrenconsulta(consulta.getHcolnumero());
					report.setHredfecharegis(consulta.getHcodfecregistr());
					lstReporte.add(report);
				}

				if (examen.getHeferefieojos() != null && !examen.getHeferefieojos().equals("")) {
					report = new Chreporte();
					report.setHrectipodescri("Examen Fisico");
					report.setHrecdescripcio("Ojos: ");

					if (examen.getHeferefieojos().equals("A")) {
						report.setHrecdescripcio2("Sin Alteraciones aparentes");
					} else if (examen.getHeferefieojos().equals("H")) {
						report.setHrecdescripcio2(formatearCampo(examen.getHefcrefieojos()));
					} else if (examen.getHeferefieojos().equals("N")) {
						report.setHrecdescripcio2("No evaluado");
					} else if (examen.getHeferefieojos().equals("S")) {
						report.setHrecdescripcio2("Sin Alteraciones aparentes");
					} else if (examen.getHeferefieojos().equals("E")) {
						report.setHrecdescripcio2("Evaluado - Sin hallazgo aparente");
					}

					report.setHrencodigo(imp_examen_fisico);
					report.setHrentipoimpres(3);
					report.setHrenconsulta(consulta.getHcolnumero());
					report.setHredfecharegis(consulta.getHcodfecregistr());
					lstReporte.add(report);
				}

				if (examen.getHeferefieoidos() != null && !examen.getHeferefieoidos().equals("")) {
					report = new Chreporte();
					report.setHrectipodescri("Examen Fisico");
					report.setHrecdescripcio("ONdos: ");

					if (examen.getHeferefieoidos().equals("A")) {
						report.setHrecdescripcio2("Sin Alteraciones aparentes");
					} else if (examen.getHeferefieoidos().equals("H")) {
						report.setHrecdescripcio2(formatearCampo(examen.getHefcrefieoidos()));
					} else if (examen.getHeferefieoidos().equals("N")) {
						report.setHrecdescripcio2("No evaluado");
					} else if (examen.getHeferefieoidos().equals("S")) {
						report.setHrecdescripcio2("Sin Alteraciones aparentes");
					} else if (examen.getHeferefieoidos().equals("E")) {
						report.setHrecdescripcio2("Evaluado - Sin hallazgo aparente");
					}

					report.setHrencodigo(imp_examen_fisico);
					report.setHrentipoimpres(3);
					report.setHrenconsulta(consulta.getHcolnumero());
					report.setHredfecharegis(consulta.getHcodfecregistr());
					lstReporte.add(report);
				}

				if (examen.getHeferefienariz() != null && !examen.getHeferefienariz().equals("")) {
					report = new Chreporte();
					report.setHrectipodescri("Examen Fisico");
					report.setHrecdescripcio("Nariz: ");

					if (examen.getHeferefienariz().equals("A")) {
						report.setHrecdescripcio2("Sin Alteraciones aparentes");
					} else if (examen.getHeferefienariz().equals("H")) {
						report.setHrecdescripcio2(formatearCampo(examen.getHefcrefienariz()));
					} else if (examen.getHeferefienariz().equals("N")) {
						report.setHrecdescripcio2("No evaluado");
					} else if (examen.getHeferefienariz().equals("S")) {
						report.setHrecdescripcio2("Sin Alteraciones aparentes");
					} else if (examen.getHeferefienariz().equals("E")) {
						report.setHrecdescripcio2("Evaluado - Sin hallazgo aparente");
					}

					report.setHrencodigo(imp_examen_fisico);
					report.setHrentipoimpres(3);
					report.setHrenconsulta(consulta.getHcolnumero());
					report.setHredfecharegis(consulta.getHcodfecregistr());
					lstReporte.add(report);
				}

				if (examen.getHeferefieboca() != null && !examen.getHeferefieboca().equals("")) {
					report = new Chreporte();
					report.setHrectipodescri("Examen Fisico");
					report.setHrecdescripcio("Boca: ");

					if (examen.getHeferefieboca().equals("A")) {
						report.setHrecdescripcio2("Sin Alteraciones aparentes");
					} else if (examen.getHeferefieboca().equals("H")) {
						report.setHrecdescripcio2(formatearCampo(examen.getHefcrefieboca()));
					} else if (examen.getHeferefieboca().equals("N")) {
						report.setHrecdescripcio2("No evaluado");
					} else if (examen.getHeferefieboca().equals("S")) {
						report.setHrecdescripcio2("Sin Alteraciones aparentes");
					} else if (examen.getHeferefieboca().equals("E")) {
						report.setHrecdescripcio2("Evaluado - Sin hallazgo aparente");
					}

					report.setHrencodigo(imp_examen_fisico);
					report.setHrentipoimpres(3);
					report.setHrenconsulta(consulta.getHcolnumero());
					report.setHredfecharegis(consulta.getHcodfecregistr());
					lstReporte.add(report);
				}

				if (examen.getHeferefiecuell() != null && !examen.getHeferefiecuell().equals("")) {
					report = new Chreporte();
					report.setHrectipodescri("Examen Fisico");
					report.setHrecdescripcio("Cuello: ");

					if (examen.getHeferefiecuell().equals("A")) {
						report.setHrecdescripcio2("Sin Alteraciones aparentes");
					} else if (examen.getHeferefiecuell().equals("H")) {
						report.setHrecdescripcio2(formatearCampo(examen.getHefcrefiecuell()));
					} else if (examen.getHeferefiecuell().equals("N")) {
						report.setHrecdescripcio2("No evaluado");
					} else if (examen.getHeferefiecuell().equals("S")) {
						report.setHrecdescripcio2("Sin Alteraciones aparentes");
					} else if (examen.getHeferefiecuell().equals("E")) {
						report.setHrecdescripcio2("Evaluado - Sin hallazgo aparente");
					}

					report.setHrencodigo(imp_examen_fisico);
					report.setHrentipoimpres(3);
					report.setHrenconsulta(consulta.getHcolnumero());
					report.setHredfecharegis(consulta.getHcodfecregistr());
					lstReporte.add(report);
				}

				if (examen.getHeferefietorax() != null && !examen.getHeferefietorax().equals("")) {
					report = new Chreporte();
					report.setHrectipodescri("Examen Fisico");
					report.setHrecdescripcio("TNrax y pulmones: ");

					if (examen.getHeferefietorax().equals("A")) {
						report.setHrecdescripcio2("Sin Alteraciones aparentes");
					} else if (examen.getHeferefietorax().equals("H")) {
						report.setHrecdescripcio2(formatearCampo(examen.getHefcrefietorax()));
					} else if (examen.getHeferefietorax().equals("N")) {
						report.setHrecdescripcio2("No evaluado");
					} else if (examen.getHeferefietorax().equals("S")) {
						report.setHrecdescripcio2("Sin Alteraciones aparentes");
					} else if (examen.getHeferefietorax().equals("E")) {
						report.setHrecdescripcio2("Evaluado - Sin hallazgo aparente");
					}

					report.setHrencodigo(imp_examen_fisico);
					report.setHrentipoimpres(3);
					report.setHrenconsulta(consulta.getHcolnumero());
					report.setHredfecharegis(consulta.getHcodfecregistr());
					lstReporte.add(report);
				}

				if (examen.getHeferefiecoraz() != null && !examen.getHeferefiecoraz().equals("")) {
					report = new Chreporte();
					report.setHrectipodescri("Examen Fisico");
					report.setHrecdescripcio("CorazNn: ");

					if (examen.getHeferefiecoraz().equals("A")) {
						report.setHrecdescripcio2("Sin Alteraciones aparentes");
					} else if (examen.getHeferefiecoraz().equals("H")) {
						report.setHrecdescripcio2(formatearCampo(examen.getHefcrefiecoraz()));
					} else if (examen.getHeferefiecoraz().equals("N")) {
						report.setHrecdescripcio2("No evaluado");
					} else if (examen.getHeferefiecoraz().equals("S")) {
						report.setHrecdescripcio2("Sin Alteraciones aparentes");
					} else if (examen.getHeferefiecoraz().equals("E")) {
						report.setHrecdescripcio2("Evaluado - Sin hallazgo aparente");
					}

					report.setHrencodigo(imp_examen_fisico);
					report.setHrentipoimpres(3);
					report.setHrenconsulta(consulta.getHcolnumero());
					report.setHredfecharegis(consulta.getHcodfecregistr());
					lstReporte.add(report);
				}

				if (examen.getHeferefiesenos() != null && !examen.getHeferefiesenos().equals("")) {
					report = new Chreporte();
					report.setHrectipodescri("Examen Fisico");
					report.setHrecdescripcio("Mamas: ");

					if (examen.getHeferefiesenos().equals("A")) {
						report.setHrecdescripcio2("Sin Alteraciones aparentes");
					} else if (examen.getHeferefiesenos().equals("H")) {
						report.setHrecdescripcio2(formatearCampo(examen.getHefcrefiesenos()));
					} else if (examen.getHeferefiesenos().equals("N")) {
						report.setHrecdescripcio2("No evaluado");
					} else if (examen.getHeferefiesenos().equals("S")) {
						report.setHrecdescripcio2("Sin Alteraciones aparentes");
					} else if (examen.getHeferefiesenos().equals("E")) {
						report.setHrecdescripcio2("Evaluado - Sin hallazgo aparente");
					}

					report.setHrencodigo(imp_examen_fisico);
					report.setHrentipoimpres(3);
					report.setHrenconsulta(consulta.getHcolnumero());
					report.setHredfecharegis(consulta.getHcodfecregistr());
					lstReporte.add(report);
					// TODO: CAMBIO
				} else if (examen.getHeferefiepiel() != null && examen.getHeferefiepiel().equals("S")) {
					report.setHrecdescripcio2("Sin Alteraciones aparentes");
				}

				if (examen.getHeferefieabdom() != null && !examen.getHeferefieabdom().equals("")) {
					report = new Chreporte();
					report.setHrectipodescri("Examen Fisico");
					report.setHrecdescripcio("Abdomen: ");

					if (examen.getHeferefieabdom().equals("A")) {
						report.setHrecdescripcio2("Sin Alteraciones aparentes");
					} else if (examen.getHeferefieabdom().equals("H")) {
						report.setHrecdescripcio2(formatearCampo(examen.getHefcrefieabdom()));
					} else if (examen.getHeferefieabdom().equals("N")) {
						report.setHrecdescripcio2("No evaluado");
					} else if (examen.getHeferefieabdom().equals("S")) {
						report.setHrecdescripcio2("Sin Alteraciones aparentes");
					} else if (examen.getHeferefieabdom().equals("E")) {
						report.setHrecdescripcio2("Evaluado - Sin hallazgo aparente");
					}

					report.setHrencodigo(imp_examen_fisico);
					report.setHrentipoimpres(3);
					report.setHrenconsulta(consulta.getHcolnumero());
					report.setHredfecharegis(consulta.getHcodfecregistr());
					lstReporte.add(report);
				}

				if (examen.getHeferefiegenit() != null && !examen.getHeferefiegenit().equals("")) {
					report = new Chreporte();
					report.setHrectipodescri("Examen Fisico");
					report.setHrecdescripcio("Genitales: ");

					if (examen.getHeferefiegenit().equals("A")) {
						report.setHrecdescripcio2("Sin Alteraciones aparentes");
					} else if (examen.getHeferefiegenit().equals("H")) {
						report.setHrecdescripcio2(formatearCampo(examen.getHefcrefiegenit()));
					} else if (examen.getHeferefiegenit().equals("N")) {
						report.setHrecdescripcio2("No evaluado");
					} else if (examen.getHeferefiegenit().equals("S")) {
						report.setHrecdescripcio2("Sin Alteraciones aparentes");
					} else if (examen.getHeferefiegenit().equals("E")) {
						report.setHrecdescripcio2("Evaluado - Sin hallazgo aparente");
					}

					report.setHrencodigo(imp_examen_fisico);
					report.setHrentipoimpres(3);
					report.setHrenconsulta(consulta.getHcolnumero());
					report.setHredfecharegis(consulta.getHcodfecregistr());
					lstReporte.add(report);
				}

				if (examen.getHeferefietacto() != null && !examen.getHeferefietacto().equals("")) {
					report = new Chreporte();
					report.setHrectipodescri("Examen Fisico");
					report.setHrecdescripcio("Tacto vaginal: ");

					if (examen.getHeferefietacto().equals("A")) {
						report.setHrecdescripcio2("Sin Alteraciones aparentes");
					} else if (examen.getHeferefietacto().equals("H")) {
						report.setHrecdescripcio2(formatearCampo(examen.getHefcrefietacto()));
					} else if (examen.getHeferefietacto().equals("N")) {
						report.setHrecdescripcio2("No evaluado");
					} else if (examen.getHeferefietacto().equals("S")) {
						report.setHrecdescripcio2("Sin Alteraciones aparentes");
					} else if (examen.getHeferefietacto().equals("E")) {
						report.setHrecdescripcio2("Evaluado - Sin hallazgo aparente");
					}

					report.setHrencodigo(imp_examen_fisico);
					report.setHrentipoimpres(3);
					report.setHrenconsulta(consulta.getHcolnumero());
					report.setHredfecharegis(consulta.getHcodfecregistr());
					lstReporte.add(report);
				}

				if (examen.getHeferefieextre() != null && !examen.getHeferefieextre().equals("")) {
					report = new Chreporte();
					report.setHrectipodescri("Examen Fisico");
					report.setHrecdescripcio("Extremidades: ");

					if (examen.getHeferefieextre().equals("A")) {
						report.setHrecdescripcio2("Sin Alteraciones aparentes");
					} else if (examen.getHeferefieextre().equals("H")) {
						report.setHrecdescripcio2(formatearCampo(examen.getHefcrefieextre()));
					} else if (examen.getHeferefieextre().equals("N")) {
						report.setHrecdescripcio2("No evaluado");
					} else if (examen.getHeferefieextre().equals("S")) {
						report.setHrecdescripcio2("Sin Alteraciones aparentes");
					} else if (examen.getHeferefieextre().equals("E")) {
						report.setHrecdescripcio2("Evaluado - Sin hallazgo aparente");
					}

					report.setHrencodigo(imp_examen_fisico);
					report.setHrentipoimpres(3);
					report.setHrenconsulta(consulta.getHcolnumero());
					report.setHredfecharegis(consulta.getHcodfecregistr());
					lstReporte.add(report);
				}

				if (examen.getHeferefieneuro() != null && !examen.getHeferefieneuro().equals("")) {
					report = new Chreporte();
					report.setHrectipodescri("Examen Fisico");
					report.setHrecdescripcio("Neuromuscular: ");

					if (examen.getHeferefieneuro().equals("A")) {
						report.setHrecdescripcio2("Sin Alteraciones aparentes");
					} else if (examen.getHeferefieneuro().equals("H")) {
						report.setHrecdescripcio2(formatearCampo(examen.getHefcrefieneuro()));
					} else if (examen.getHeferefieneuro().equals("N")) {
						report.setHrecdescripcio2("No evaluado");
					} else if (examen.getHeferefieneuro().equals("S")) {
						report.setHrecdescripcio2("Sin Alteraciones aparentes");
					} else if (examen.getHeferefieneuro().equals("E")) {
						report.setHrecdescripcio2("Evaluado - Sin hallazgo aparente");
					}

					report.setHrencodigo(imp_examen_fisico);
					report.setHrentipoimpres(3);
					report.setHrenconsulta(consulta.getHcolnumero());
					report.setHredfecharegis(consulta.getHcodfecregistr());
					lstReporte.add(report);
				}

				if (examen.getHefcevalupelvi() != null && !examen.getHefcevalupelvi().equals("")) {
					String posicion = "";

					report = new Chreporte();
					report.setHrectipodescri("Examen Fisico");
					report.setHrecdescripcio(
							"Examen pNlvico bimanual evaluado	:  " + formatearCampo(examen.getHefcevalupelvi()));
					report.setHrencodigo(imp_examen_fisico);
					report.setHrentipoimpres(1);
					report.setHrenconsulta(consulta.getHcolnumero());
					report.setHredfecharegis(consulta.getHcodfecregistr());
					lstReporte.add(report);

				}

				if (examen.getHefcposiutero() != null && !examen.getHefcposiutero().equals("")) {
					String posicion = "";

					if ("A".equals(examen.getHefcposiutero())) {
						posicion = "Anterior";
					} else if ("M".equals(examen.getHefcposiutero())) {
						posicion = "Medio";
					} else if ("P".equals(examen.getHefcposiutero())) {
						posicion = "Posterior";
					}
					report = new Chreporte();
					report.setHrectipodescri("Examen Fisico");
					report.setHrecdescripcio("PosiciNn del Ntero:" + posicion);
					report.setHrencodigo(imp_examen_fisico);
					report.setHrentipoimpres(1);
					report.setHrenconsulta(consulta.getHcolnumero());
					report.setHredfecharegis(consulta.getHcodfecregistr());
					lstReporte.add(report);

				}

				if (examen.getHefcdesviautero() != null && !examen.getHefcdesviautero().equals("")) {
					String desviacion = "";

					if ("N".equals(examen.getHefcdesviautero())) {
						desviacion = "No";
					} else if ("D".equals(examen.getHefcdesviautero())) {
						desviacion = "Derecha";
					} else if ("I".equals(examen.getHefcdesviautero())) {
						desviacion = "Izquierda";
					}
					report = new Chreporte();
					report.setHrectipodescri("Examen Fisico");
					report.setHrecdescripcio("DesviaciNn del Ntero de la lNnea media:" + desviacion);
					report.setHrencodigo(imp_examen_fisico);
					report.setHrentipoimpres(1);
					report.setHrenconsulta(consulta.getHcolnumero());
					report.setHredfecharegis(consulta.getHcodfecregistr());
					lstReporte.add(report);

				}

				if (examen.getHefccuellocerra() != null && !examen.getHefccuellocerra().equals("")) {

					report = new Chreporte();
					report.setHrectipodescri("Examen Fisico");
					report.setHrecdescripcio("Cuello cerrado:" + formatearCampo(examen.getHefccuellocerra()));
					report.setHrencodigo(imp_examen_fisico);
					report.setHrentipoimpres(1);
					report.setHrenconsulta(consulta.getHcolnumero());
					report.setHredfecharegis(consulta.getHcodfecregistr());
					lstReporte.add(report);

					if ("N".equals(examen.getHefccuellocerra())) {
						report = new Chreporte();
						report.setHrectipodescri("Examen Fisico");
						report.setHrecdescripcio("Hallazgo:" + examen.getHefcobscuecerra());
						report.setHrencodigo(imp_examen_fisico);
						report.setHrentipoimpres(1);
						report.setHrenconsulta(consulta.getHcolnumero());
						report.setHredfecharegis(consulta.getHcodfecregistr());
						lstReporte.add(report);
					}
				}

				if (examen.getHefcdolormovcuello() != null && !examen.getHefcdolormovcuello().equals("")) {
					report = new Chreporte();
					report.setHrectipodescri("Examen Fisico");
					report.setHrecdescripcio(
							"Dolor al movilizar el cuello:" + formatearCampo(examen.getHefcdolormovcuello()));
					report.setHrencodigo(imp_examen_fisico);
					report.setHrentipoimpres(1);
					report.setHrenconsulta(consulta.getHcolnumero());
					report.setHredfecharegis(consulta.getHcodfecregistr());
					lstReporte.add(report);

				}

				if (examen.getHefcsangrado() != null && !examen.getHefcsangrado().equals("")) {
					report = new Chreporte();
					report.setHrectipodescri("Examen Fisico");
					report.setHrecdescripcio("Sangrado:" + formatearCampo(examen.getHefcsangrado()));
					report.setHrencodigo(imp_examen_fisico);
					report.setHrentipoimpres(1);
					report.setHrenconsulta(consulta.getHcolnumero());
					report.setHredfecharegis(consulta.getHcodfecregistr());
					lstReporte.add(report);

				}

				if (examen.getHefcecoespecialis() != null && !examen.getHefcecoespecialis().equals("")) {
					report = new Chreporte();
					report.setHrectipodescri("Examen Fisico");
					report.setHrecdescripcio(
							"Hallazgos ecogrNficos por:  " + formatearCampoEcografia(examen.getHefcecoespecialis()));
					report.setHrencodigo(imp_examen_fisico);
					report.setHrentipoimpres(1);
					report.setHrenconsulta(consulta.getHcolnumero());
					report.setHredfecharegis(consulta.getHcodfecregistr());
					lstReporte.add(report);

					if ("R".equals(examen.getHefcecoespecialis())) {
						report = new Chreporte();
						report.setHrectipodescri("Examen Fisico");
						report.setHrecdescripcio(
								"Edad gestacional en semanas: " + formatearCampo(examen.getHefnedadsem())
										+ " Semanas + " + formatearCampo(examen.getHefnedaddia()) + " Dias");
						report.setHrencodigo(imp_examen_fisico);
						report.setHrentipoimpres(1);
						report.setHrenconsulta(consulta.getHcolnumero());
						report.setHredfecharegis(consulta.getHcodfecregistr());
						lstReporte.add(report);

						report = new Chreporte();
						report.setHrectipodescri("Examen Fisico");
						report.setHrecdescripcio("Observaciones: " + formatearCampo(examen.getHefcobsereco()));
						report.setHrencodigo(imp_examen_fisico);
						report.setHrentipoimpres(1);
						report.setHrenconsulta(consulta.getHcolnumero());
						report.setHredfecharegis(consulta.getHcodfecregistr());
						lstReporte.add(report);
					}

					if ("E".equals(examen.getHefcecoespecialis())) {
						report = new Chreporte();
						report.setHrectipodescri("Examen Fisico");
						report.setHrecdescripcio(
								"Edad gestacional en semanas: " + formatearCampo(examen.getHefnedadsem())
										+ " Semanas + " + formatearCampo(examen.getHefnedaddia()) + " Dias");
						report.setHrencodigo(imp_examen_fisico);
						report.setHrentipoimpres(1);
						report.setHrenconsulta(consulta.getHcolnumero());
						report.setHredfecharegis(consulta.getHcodfecregistr());
						lstReporte.add(report);

						report = new Chreporte();
						report.setHrectipodescri("Examen Fisico");
						report.setHrecdescripcio("TamaNo del Ntero: " + examen.getHefntamauterocm() + "  , "
								+ examen.getHefntamauteroml());
						report.setHrencodigo(imp_examen_fisico);
						report.setHrentipoimpres(1);
						report.setHrenconsulta(consulta.getHcolnumero());
						report.setHredfecharegis(consulta.getHcodfecregistr());
						lstReporte.add(report);

						report = new Chreporte();
						report.setHrectipodescri("Examen Fisico");
						report.setHrecdescripcio("Observacion :" + examen.getHefcobsereco());
						report.setHrencodigo(imp_examen_fisico);
						report.setHrentipoimpres(1);
						report.setHrenconsulta(consulta.getHcolnumero());
						report.setHredfecharegis(consulta.getHcodfecregistr());
						lstReporte.add(report);
					}

				}

				if (examen.getHefcconfiembar() != null && !examen.getHefcconfiembar().equals("")) {
					String posicion = "";

					report = new Chreporte();
					report.setHrectipodescri("Examen Fisico");
					report.setHrecdescripcio(
							"Se confirma embarazo en la consulta:  " + formatearCampo(examen.getHefcconfiembar()));
					CONFIRMA_EMBARAZO = examen.getHefcconfiembar();
					if (examen.getHefcdesccfemb() != null) {
						report.setHrecdescripcio2("DescripciNn:  " + formatearCampo(examen.getHefcdesccfemb()));
					} else {
						report.setHrecdescripcio2(" ");
					}

					report.setHrencodigo(imp_examen_fisico);
					report.setHrentipoimpres(2);
					report.setHrenconsulta(consulta.getHcolnumero());
					report.setHredfecharegis(consulta.getHcodfecregistr());
					lstReporte.add(report);

				}

			}

			// Datos Examen Fisico Prenatal

			if (consulta.getChcontrolpre() != null && !consulta.getChcontrolpre().isEmpty()) {
				Chcontrolpre controlprenatal = null;
				Iterator it = consulta.getChcontrolpre().iterator();
				if (it.hasNext()) {
					controlprenatal = (Chcontrolpre) it.next();
				}

				if (controlprenatal != null) {

					Chreporte report = new Chreporte();
					/*
					 * report.setHrectipodescri("Examen Fisico Prenatal");
					 * 
					 * if (controlprenatal.getHcpcpresart1() != null &&
					 * controlprenatal.getHcpcpresart2() != null) {
					 * report.setHrecdescripcio("PresiNn Arterial:  " + PRESION_ARTERIAL_PRENATAL);
					 * } else { report.setHrecdescripcio(""); }
					 * 
					 * if (controlprenatal.getHcpnfreccard() != null) {
					 * report.setHrecdescripcio2("Frecuencia Cardiaca: " +
					 * formatearCampo(FRECUENCIA_CARDIACA_PRENATAL)); } else {
					 * report.setHrecdescripcio2(""); }
					 * 
					 * if (controlprenatal.getHcpnfrecresp() != null) {
					 * report.setHrecdescripcio3("Frecuencia Respiratoria: " +
					 * formatearCampo(FRECUENCIA_RESPIRATORIA_PRENATAL)); } else {
					 * report.setHrecdescripcio3(""); }
					 * 
					 * report.setHrencodigo(imp_examen_fisico_prenatal);
					 * report.setHrentipoimpres(5);
					 * report.setHrenconsulta(consulta.getHcolnumero());
					 * report.setHredfecharegis(consulta.getHcodfecregistr());
					 * lstReporte.add(report);
					 * 
					 * 
					 * report = new Chreporte(); report.setHrectipodescri("Examen Fisico Prenatal");
					 * if (controlprenatal.getHcpapeso() != null) {
					 * report.setHrecdescripcio("Peso:  " + formatearCampo(PESO_PRENATAL)); } else {
					 * report.setHrecdescripcio(""); }
					 * 
					 * if (controlprenatal.getHcpatalla() != null) {
					 * report.setHrecdescripcio2("Talla : " + formatearCampo(TALLA_PRENATAL)); }
					 * else { report.setHrecdescripcio2(""); }
					 * 
					 * if (controlprenatal.getHcpaimc() != null) { report.setHrecdescripcio3("IMC: "
					 * + formatearCampo(controlprenatal.getHcpaimc())); } else {
					 * report.setHrecdescripcio3(""); }
					 * 
					 * report.setHrencodigo(imp_examen_fisico_prenatal);
					 * report.setHrentipoimpres(5);
					 * report.setHrenconsulta(consulta.getHcolnumero());
					 * report.setHredfecharegis(consulta.getHcodfecregistr());
					 * lstReporte.add(report);
					 * 
					 * 
					 * report = new Chreporte(); report.setHrectipodescri("Examen Fisico Prenatal");
					 * if (controlprenatal.getHcpetipotemper() != null &&
					 * !controlprenatal.getHcpetipotemper().equals("")) {
					 * report.setHrecdescripcio("Tipo Temperatura: " +
					 * formatearCampo(TIPO_TEMPERATURA_PRENATAL)); } else {
					 * report.setHrecdescripcio(""); }
					 * 
					 * 
					 * if (controlprenatal.getHcpatemperatu() != null) {
					 * report.setHrecdescripcio2("Temperatura : " +
					 * formatearCampo(TEMPERATURA_PRENATAL)); } else {
					 * report.setHrecdescripcio2(""); }
					 * report.setHrencodigo(imp_examen_fisico_prenatal);
					 * report.setHrentipoimpres(5);
					 * report.setHrenconsulta(consulta.getHcolnumero());
					 * report.setHredfecharegis(consulta.getHcodfecregistr());
					 * lstReporte.add(report);
					 * 
					 */

					report = new Chreporte();
					report.setHrectipodescri("Examen Fisico Prenatal");
					report.setHrecdescripcio("Examen Clinico:  " + EXAMEN_CLINICO_PRENATAL);
					report.setHrecdescripcio2("Examen de mamas:  " + EXAMEN_MAMAS_PRENATAL);
					report.setHrecdescripcio3("Examen Odontologico  " + EXAMEN_ODONTOLOGICO_PRENATAL);
					report.setHrencodigo(imp_examen_fisico_prenatal);
					report.setHrentipoimpres(5);
					report.setHrenconsulta(consulta.getHcolnumero());
					report.setHredfecharegis(consulta.getHcodfecregistr());
					lstReporte.add(report);

					report = new Chreporte();
					report.setHrectipodescri("Examen Fisico Prenatal");
					report.setHrecdescripcio("Pelvis:  " + PELVIS_PRENATAL);
					report.setHrecdescripcio2("Citologia:  " + CITOLOGIA_PRENATAL);
					report.setHrecdescripcio3("Cervix  " + CERVIX_PRENATAL);
					report.setHrencodigo(imp_examen_fisico_prenatal);
					report.setHrentipoimpres(5);
					report.setHrenconsulta(consulta.getHcolnumero());
					report.setHredfecharegis(consulta.getHcodfecregistr());
					lstReporte.add(report);

					report = new Chreporte();
					report.setHrectipodescri("Examen Fisico Prenatal");
					report.setHrecdescripcio("Altura uterina:  " + ALTURA_UTERINA);
					report.setHrecdescripcio2("Frecuencia cardiaca fetal:  " + FRECUENCIA_CARDIACA_FETAL);
					// report.setHrecdescripcio3("Movimiento Fetal " +
					// MOVIMIENTO_FETAL);
					report.setHrecdescripcio3("");
					report.setHrencodigo(imp_examen_fisico_prenatal);
					report.setHrentipoimpres(5);
					report.setHrenconsulta(consulta.getHcolnumero());
					report.setHredfecharegis(consulta.getHcodfecregistr());
					lstReporte.add(report);

					report = new Chreporte();
					report.setHrectipodescri("Examen Fisico Prenatal");
					if (!"".equals(PRESENTACION_FETAL)) {
						report.setHrecdescripcio("PresentaciNn Fetal:  " + PRESENTACION_FETAL);
					} else {
						report.setHrecdescripcio("");
					}

					report.setHrecdescripcio2("Edemas:  " + EDEMAS_PRENATAL);
					report.setHrecdescripcio3("ValoraciNn cuello uterino  " + VALORACION_CUELLO_UTERINO);
					report.setHrencodigo(imp_examen_fisico_prenatal);
					report.setHrentipoimpres(5);
					report.setHrenconsulta(consulta.getHcolnumero());
					report.setHredfecharegis(consulta.getHcodfecregistr());
					lstReporte.add(report);

					report = new Chreporte();
					report.setHrectipodescri("Examen Fisico Prenatal");
					report.setHrecdescripcio("Estado Nutricional:  " + ESTADO_NUTRICIONAL_PRENATAL);
					report.setHrencodigo(imp_examen_fisico_prenatal);
					report.setHrentipoimpres(1);
					report.setHrenconsulta(consulta.getHcolnumero());
					report.setHredfecharegis(consulta.getHcodfecregistr());
					lstReporte.add(report);

					report = new Chreporte();
					report.setHrectipodescri("Examen Fisico Prenatal");
					report.setHrecdescripcio("ORL:  " + ORL_PRENATAL);
					if (DESCRIPCION_ORL_PRENATAL != null && !DESCRIPCION_ORL_PRENATAL.equals("")) {
						report.setHrecdescripcio2("DescripciNn:  " + DESCRIPCION_ORL_PRENATAL);
					} else {
						report.setHrecdescripcio2(null);
					}

					report.setHrencodigo(imp_examen_fisico_prenatal);
					report.setHrentipoimpres(3);
					report.setHrenconsulta(consulta.getHcolnumero());
					report.setHredfecharegis(consulta.getHcodfecregistr());
					lstReporte.add(report);

					report = new Chreporte();
					report.setHrectipodescri("Examen Fisico Prenatal");
					report.setHrecdescripcio("Cardio pulmonar:  " + CARDIO_PULMONAR_PRENATAL);
					if (DESCRIPCION_CARDIO_PULMONAR_PRENATAL != null
							&& !DESCRIPCION_CARDIO_PULMONAR_PRENATAL.equals("")) {
						report.setHrecdescripcio2("DescripciNn:  " + DESCRIPCION_CARDIO_PULMONAR_PRENATAL);
					} else {
						report.setHrecdescripcio2(null);
					}
					report.setHrencodigo(imp_examen_fisico_prenatal);
					report.setHrentipoimpres(3);
					report.setHrenconsulta(consulta.getHcolnumero());
					report.setHredfecharegis(consulta.getHcodfecregistr());
					lstReporte.add(report);

					report = new Chreporte();
					report.setHrectipodescri("Examen Fisico Prenatal");
					report.setHrecdescripcio("Extremidades:  " + EXTREMIDADES_PRENATAL);

					if (DESCRIPCION_EXTREMIDADES_PRENATAL != null && !DESCRIPCION_EXTREMIDADES_PRENATAL.equals("")) {
						report.setHrecdescripcio2("DescripciNn:  " + DESCRIPCION_EXTREMIDADES_PRENATAL);
					} else {
						report.setHrecdescripcio2(null);
					}

					report.setHrencodigo(imp_examen_fisico_prenatal);
					report.setHrentipoimpres(3);
					report.setHrenconsulta(consulta.getHcolnumero());
					report.setHredfecharegis(consulta.getHcodfecregistr());
					lstReporte.add(report);

					report = new Chreporte();
					report.setHrectipodescri("Examen Fisico Prenatal");
					report.setHrecdescripcio("Sistema nervioso central:  " + SISTEMA_NERVIOSO_PRENATAL);
					if (DESCRIPCION_SISTEMA_NERVIOSO_PRENATAL != null
							&& !DESCRIPCION_SISTEMA_NERVIOSO_PRENATAL.equals("")) {
						report.setHrecdescripcio2("DescripciNn:  " + DESCRIPCION_SISTEMA_NERVIOSO_PRENATAL);
					} else {
						report.setHrecdescripcio2(null);
					}

					report.setHrencodigo(imp_examen_fisico_prenatal);
					report.setHrentipoimpres(3);
					report.setHrenconsulta(consulta.getHcolnumero());
					report.setHredfecharegis(consulta.getHcodfecregistr());
					lstReporte.add(report);

					report = new Chreporte();
					report.setHrectipodescri("Examen Fisico Prenatal");
					report.setHrecdescripcio("Geniturinario:  " + GENITURINARIO_PRENATAL);
					if (DESCRIPCION_GENITURINARIO_PRENATAL != null && !DESCRIPCION_GENITURINARIO_PRENATAL.equals("")) {
						report.setHrecdescripcio2("DescripciNn:  " + DESCRIPCION_GENITURINARIO_PRENATAL);
					} else {
						report.setHrecdescripcio2(null);
					}

					report.setHrencodigo(imp_examen_fisico_prenatal);
					report.setHrentipoimpres(3);
					report.setHrenconsulta(consulta.getHcolnumero());
					report.setHredfecharegis(consulta.getHcodfecregistr());
					lstReporte.add(report);

					report = new Chreporte();
					report.setHrectipodescri("Examen Fisico Prenatal");
					report.setHrecdescripcio("Gastrointestinal:  " + GASTROINTESTINAL_PRENATAL);
					if (DESCRIPCION_GASTROINTESTINAL_PRENATAL != null
							&& !DESCRIPCION_GASTROINTESTINAL_PRENATAL.equals("")) {
						report.setHrecdescripcio2("DescripciNn:  " + DESCRIPCION_GASTROINTESTINAL_PRENATAL);
					} else {
						report.setHrecdescripcio2(null);
					}

					report.setHrencodigo(imp_examen_fisico_prenatal);
					report.setHrentipoimpres(3);
					report.setHrenconsulta(consulta.getHcolnumero());
					report.setHredfecharegis(consulta.getHcodfecregistr());
					lstReporte.add(report);

				}

			}

			// Datos Examen Fisico Pediatria

			if (consulta.getChpediexamens() != null && !consulta.getChpediexamens().isEmpty()) {

				Chpediexamen examenPediatria = null;
				Iterator it = consulta.getChpediexamens().iterator();
				if (it.hasNext()) {
					examenPediatria = (Chpediexamen) it.next();
				}

				if (examenPediatria != null) {
					Chreporte report = new Chreporte();
					report.setHrectipodescri("Examen Pediatria");
					report.setHrecdescripcio(
							"ComposiciNn Familiar:  " + formatearCampo(examenPediatria.getHpeccompofamil()));
					report.setHrencodigo(imp_examen_pediatria);
					report.setHrentipoimpres(1);
					report.setHrenconsulta(consulta.getHcolnumero());
					report.setHredfecharegis(consulta.getHcodfecregistr());
					lstReporte.add(report);

					report = new Chreporte();
					String estadoGeneral = "";
					if (examenPediatria.getHpeeestadogene() != null) {
						if (examenPediatria.getHpeeestadogene().equals("B")) {
							estadoGeneral = "Bueno";
						}
						if (examenPediatria.getHpeeestadogene().equals("R")) {
							estadoGeneral = "Regular";
						}
						if (examenPediatria.getHpeeestadogene().equals("M")) {
							estadoGeneral = "Malo";
						}
					}
					report.setHrectipodescri("Examen Pediatria");
					report.setHrecdescripcio("Estado General:  " + formatearCampo(estadoGeneral));
					report.setHrecdescripcio2(
							"Estado Respiratorio Dificultad:  " + formatearCampo(examenPediatria.getHpeeestadoresp()));
					report.setHrencodigo(imp_examen_pediatria);
					report.setHrentipoimpres(6);
					report.setHrenconsulta(consulta.getHcolnumero());
					report.setHredfecharegis(consulta.getHcodfecregistr());
					lstReporte.add(report);

					report = new Chreporte();
					String estadoHidratacion = "";
					String estadoConciencia = "";
					if (examenPediatria.getHpeeestadohidr() != null) {
						if (examenPediatria.getHpeeestadohidr().equals("H")) {
							estadoHidratacion = "Hidratado";
						}
						if (examenPediatria.getHpeeestadohidr().equals("D")) {
							estadoHidratacion = "Deshidratado";
						}
					}

					if (examenPediatria.getHpeeestadoconc() != null) {
						if (examenPediatria.getHpeeestadoconc().equals("N")) {
							estadoConciencia = "Normal";
						}
						if (examenPediatria.getHpeeestadoconc().equals("A")) {
							estadoConciencia = "Alterado";
						}
					}
					report.setHrectipodescri("Examen Pediatria");
					report.setHrecdescripcio("Estado de HidrataciNn:  " + formatearCampo(estadoHidratacion));
					report.setHrecdescripcio2("Estado de Conciencia:  " + formatearCampo(estadoConciencia));
					report.setHrencodigo(imp_examen_pediatria);
					report.setHrentipoimpres(6);
					report.setHrenconsulta(consulta.getHcolnumero());
					report.setHredfecharegis(consulta.getHcodfecregistr());
					lstReporte.add(report);

					report = new Chreporte();
					report.setHrectipodescri("Examen Pediatria");
					report.setHrecdescripcio("Observaciones:  " + formatearCampo(examenPediatria.getHpecobservacio()));
					report.setHrencodigo(imp_examen_pediatria);
					report.setHrentipoimpres(1);
					report.setHrenconsulta(consulta.getHcolnumero());
					report.setHredfecharegis(consulta.getHcodfecregistr());
					lstReporte.add(report);
				}

			}

			// DATOS DEL CONTROL

			if (consulta.getChcontrolcon() != null && !consulta.getChcontrolcon().isEmpty()) {

				Chcontrolcon control = null;

				Iterator it = consulta.getChcontrolcon().iterator();
				if (it.hasNext()) {
					control = (Chcontrolcon) it.next();
				}

				Chreporte report = new Chreporte();

				String s = "";
				s = "Seguimiento:  " + formatearCampo(control.getHcccdescripcio());
				report = new Chreporte();
				report.setHrecdescripcio(s);
				report.setHrectipodescri("Seguimiento");
				report.setHrencodigo(imp_control);
				report.setHrentipoimpres(1);
				report.setHrenconsulta(consulta.getHcolnumero());
				report.setHredfecharegis(consulta.getHcodfecregistr());
				lstReporte.add(report);
			}

			// Datos ImpresiNn Diagnostica

			if (consulta.getChimprdiags() != null && !consulta.getChimprdiags().isEmpty()) {

				Chreporte report = new Chreporte();

				String s = "";
				String s2 = "";

				String s3 = "";

				if (TIPO_DIAGNOSTICO != null && !TIPO_DIAGNOSTICO.equals("")) {
					s = "Tipo de Diagnostico:  " + TIPO_DIAGNOSTICO;
					report = new Chreporte();
					report.setHrecdescripcio(s);
					report.setHrectipodescri("ImpresiNn Diagnostica");
					report.setHrencodigo(imp_impresion_diagnostica);
					report.setHrentipoimpres(1);
					report.setHrenconsulta(consulta.getHcolnumero());
					report.setHredfecharegis(consulta.getHcodfecregistr());
					lstReporte.add(report);
				}

				s = "Diagnostico Principal:  " + formatearCampo(DIAGNOSTICO_PRINCIPAL);
				report = new Chreporte();
				report.setHrecdescripcio(s);
				report.setHrectipodescri("ImpresiNn Diagnostica");
				report.setHrencodigo(imp_impresion_diagnostica);
				report.setHrentipoimpres(1);
				report.setHrenconsulta(consulta.getHcolnumero());
				report.setHredfecharegis(consulta.getHcodfecregistr());
				lstReporte.add(report);

				if (GRADO_EXAMEN_ASA != null && GRADO_EXAMEN_ASA > 0) {
					s = "Grado Examen ASA   :  " + formatearCampo(GRADO_EXAMEN_ASA);
					report = new Chreporte();
					report.setHrecdescripcio(s);
					report.setHrectipodescri("ImpresiNn Diagnostica");
					report.setHrencodigo(imp_impresion_diagnostica);
					report.setHrentipoimpres(1);
					report.setHrenconsulta(consulta.getHcolnumero());
					report.setHredfecharegis(consulta.getHcodfecregistr());
					lstReporte.add(report);
				}

				if ((SEMANAS_EMBARAZO != null && SEMANAS_EMBARAZO.doubleValue() > 0)
						|| (SEMANAS_EMBARAZO_GESTACIONAL != null && SEMANAS_EMBARAZO_GESTACIONAL.doubleValue() > 0)) {
					s = "Edad gestacional por amenorrea:  " + formatearCampo(SEMANAS_EMBARAZO_GESTACIONAL);

					s2 = "Confirma semanas: " + CONFIRMA_SEMANAS_EMBARAZO;

					s3 = "Semanas de Embarazo: " + SEMANAS_EMBARAZO;

					report = new Chreporte();
					report.setHrecdescripcio(s);
					report.setHrecdescripcio2(s2);
					report.setHrecdescripcio3(s3);
					report.setHrectipodescri("ImpresiNn Diagnostica");
					report.setHrencodigo(imp_impresion_diagnostica);
					report.setHrentipoimpres(5);
					report.setHrenconsulta(consulta.getHcolnumero());
					report.setHredfecharegis(consulta.getHcodfecregistr());
					lstReporte.add(report);
				}

				if (DIAGNOSTICO_RELACIONADO1 != null && !DIAGNOSTICO_RELACIONADO1.equals("")) {
					s = "Diagnostico Relacionado 1:  " + formatearCampo(DIAGNOSTICO_RELACIONADO1);
					report = new Chreporte();
					report.setHrecdescripcio(s);
					report.setHrectipodescri("ImpresiNn Diagnostica");
					report.setHrencodigo(imp_impresion_diagnostica);
					report.setHrentipoimpres(1);
					report.setHrenconsulta(consulta.getHcolnumero());
					report.setHredfecharegis(consulta.getHcodfecregistr());
					lstReporte.add(report);
				}

				if (DIAGNOSTICO_RELACIONADO2 != null && !DIAGNOSTICO_RELACIONADO2.equals("")) {
					s = "Diagnostico Relacionado 2:  " + formatearCampo(DIAGNOSTICO_RELACIONADO2);
					report = new Chreporte();
					report.setHrecdescripcio(s);
					report.setHrectipodescri("ImpresiNn Diagnostica");
					report.setHrencodigo(imp_impresion_diagnostica);
					report.setHrentipoimpres(1);
					report.setHrenconsulta(consulta.getHcolnumero());
					report.setHredfecharegis(consulta.getHcodfecregistr());
					lstReporte.add(report);
				}

				if (DIAGNOSTICO_RELACIONADO3 != null && !DIAGNOSTICO_RELACIONADO3.equals("")) {
					s = "Diagnostico Relacionado 3:  " + formatearCampo(DIAGNOSTICO_RELACIONADO3);
					report = new Chreporte();
					report.setHrecdescripcio(s);
					report.setHrectipodescri("ImpresiNn Diagnostica");
					report.setHrencodigo(imp_impresion_diagnostica);
					report.setHrentipoimpres(1);
					report.setHrenconsulta(consulta.getHcolnumero());
					report.setHredfecharegis(consulta.getHcodfecregistr());
					lstReporte.add(report);

				}

				if (RECOMENDACIONES_IMPRESION != null && !RECOMENDACIONES_IMPRESION.equals("")) {
					s = "Observaciones:  " + RECOMENDACIONES_IMPRESION;
					report = new Chreporte();
					report.setHrecdescripcio(s);
					report.setHrectipodescri("ImpresiNn Diagnostica");
					report.setHrencodigo(imp_impresion_diagnostica);
					report.setHrentipoimpres(1);
					report.setHrenconsulta(consulta.getHcolnumero());
					report.setHredfecharegis(consulta.getHcodfecregistr());
					lstReporte.add(report);
				}

				if (IMPRESION_DIAG_COLPOS != null && !IMPRESION_DIAG_COLPOS.equals("")) {

					s = "Impresion Diagnostica Colposcopia:  " + IMPRESION_DIAG_COLPOS;
					report = new Chreporte();
					report.setHrecdescripcio(formatearCampo(s.substring(0, s.length() - 2)));
					report.setHrectipodescri("ImpresiNn Diagnostica");
					report.setHrencodigo(imp_impresion_diagnostica);
					report.setHrentipoimpres(1);
					report.setHrenconsulta(consulta.getHcolnumero());
					report.setHredfecharegis(consulta.getHcodfecregistr());
					lstReporte.add(report);
				}

				if (OTRO_DIAG_COLPOS != null && !OTRO_DIAG_COLPOS.equals("")) {
					s = "Otra Impresion Diagnostica Colposcopia:  " + OTRO_DIAG_COLPOS;
					report = new Chreporte();
					report.setHrecdescripcio(s);
					report.setHrectipodescri("ImpresiNn Diagnostica");
					report.setHrencodigo(imp_impresion_diagnostica);
					report.setHrentipoimpres(1);
					report.setHrenconsulta(consulta.getHcolnumero());
					report.setHredfecharegis(consulta.getHcodfecregistr());
					lstReporte.add(report);
				}
			}

			opcionesNuevasTamizajeLaboratorios(consulta);

			if (consulta.getChpladetrat() != null && !consulta.getChpladetrat().isEmpty()) {

				Chreporte report = new Chreporte();

				String s = "";
				String s2 = "";

				s = "Tipo de IntervenciNn:  " + TIPO_INTERVENCION_PSICO;
				s2 = "NNmero de sesiones:  " + NUMERO_SESIONES;
				report = new Chreporte();
				report.setHrecdescripcio(s);
				report.setHrecdescripcio2(s2);
				report.setHrectipodescri("Plan de Tratamiento");
				report.setHrencodigo(imp_plan_tratamiento_psico);
				report.setHrentipoimpres(6);
				report.setHrenconsulta(consulta.getHcolnumero());
				report.setHredfecharegis(consulta.getHcodfecregistr());
				lstReporte.add(report);

				s = "";
				s = "Compromisos:  " + COMPROMISOS_PSCIO;

				report = new Chreporte();
				report.setHrecdescripcio(s);

				report.setHrectipodescri("Plan de Tratamiento");
				report.setHrencodigo(imp_plan_tratamiento_psico);
				report.setHrentipoimpres(1);
				report.setHrenconsulta(consulta.getHcolnumero());
				report.setHredfecharegis(consulta.getHcodfecregistr());
				lstReporte.add(report);

			}

			if (consulta.getChexamediagns() != null && !consulta.getChexamediagns().isEmpty()
					&& (INICIA_METODO_HOY == null || "SI".equals(INICIA_METODO_HOY))
					&& (CONFIRMA_EMBARAZO == null || "S".equals(CONFIRMA_EMBARAZO))) {

				Chexamediagn examendiag = null;
				Iterator it = consulta.getChexamediagns().iterator();
				if (it.hasNext()) {
					examendiag = (Chexamediagn) it.next();
				}

				if (examendiag != null) {

					Chreporte report = new Chreporte();
					String metodoPaciente = "";
					String metodoSugerido = "";
					String metodoAUsar = "";
					String primerMetodo = "No";
					try {
						metodoPaciente = serviceLocator.getClinicoService()
								.getDescripcionMetodo(examendiag.getHedcmetodopaci());
					} catch (ModelException e) {
						e.printStackTrace();
					}
					try {
						metodoSugerido = serviceLocator.getClinicoService()
								.getDescripcionMetodo(examendiag.getHedcmetodosuge());
					} catch (ModelException e) {
						e.printStackTrace();
					}
					try {
						metodoAUsar = serviceLocator.getClinicoService()
								.getDescripcionMetodo(examendiag.getHedcmetodosoli());
					} catch (ModelException e) {
						e.printStackTrace();
					}
					if ("S".equals(examendiag.getHedcprimmet())) {
						primerMetodo = "Si";
					}
					if (examendiag.getHedcprimmet() != null) {
						report = new Chreporte();
						report.setHrecdescripcio(
								"NEs el primer mNtodo que utiliza en su vida?: " + formatearCampo(primerMetodo));
						report.setHrectipodescri("MNtodo de PlanificaciNn");
						report.setHrencodigo(imp_apoyo_diagnostico);
						report.setHrentipoimpres(1);
						report.setHrenconsulta(consulta.getHcolnumero());
						report.setHredfecharegis(consulta.getHcodfecregistr());
						lstReporte.add(report);
					}

					if (metodoPaciente != null && !metodoPaciente.equals("")) {
						report = new Chreporte();
						report.setHrecdescripcio(
								"Metodo que el Paciente desea usar: " + formatearCampo(metodoPaciente));
						report.setHrectipodescri("MNtodo de PlanificaciNn");
						report.setHrencodigo(imp_apoyo_diagnostico);
						report.setHrentipoimpres(1);
						report.setHrenconsulta(consulta.getHcolnumero());
						report.setHredfecharegis(consulta.getHcodfecregistr());
						lstReporte.add(report);
					}

					if (examendiag.getHedccontraindi() != null) {
						report = new Chreporte();
						report.setHrecdescripcio("Contraindicaciones a MNtodos Anticonceptivos -Especificar: "
								+ formatearCampo(examendiag.getHedccontraindi()));
						report.setHrectipodescri("MNtodo de PlanificaciNn");
						report.setHrencodigo(imp_apoyo_diagnostico);
						report.setHrentipoimpres(1);
						report.setHrenconsulta(consulta.getHcolnumero());
						report.setHredfecharegis(consulta.getHcodfecregistr());
						lstReporte.add(report);

					}

					if (metodoSugerido != null && !metodoSugerido.equals("")) {
						report = new Chreporte();
						report.setHrecdescripcio("Metodo sugerido: " + formatearCampo(metodoSugerido));
						report.setHrectipodescri("MNtodo de PlanificaciNn");
						report.setHrencodigo(imp_apoyo_diagnostico);
						report.setHrentipoimpres(1);
						report.setHrenconsulta(consulta.getHcolnumero());
						report.setHredfecharegis(consulta.getHcodfecregistr());
						lstReporte.add(report);
					}

					if (metodoAUsar != null && !metodoAUsar.equals("")) {
						report = new Chreporte();

						report.setHrecdescripcio(
								"Dentro de los metodos anticonceptivos no contraindicados la paciente escoge libremente: "
										+ formatearCampo(metodoAUsar));
						report.setHrencodigo(imp_apoyo_diagnostico);
						report.setHrectipodescri("MNtodo de PlanificaciNn");
						report.setHrentipoimpres(1);
						report.setHrenconsulta(consulta.getHcolnumero());
						report.setHredfecharegis(consulta.getHcodfecregistr());
						lstReporte.add(report);
					}

				}

			}

			if (consulta.getChdispoaplic() != null && !consulta.getChdispoaplic().isEmpty()
					&& (INICIA_METODO_HOY == null || "SI".equals(INICIA_METODO_HOY))
					&& (CONFIRMA_EMBARAZO == null || "S".equals(CONFIRMA_EMBARAZO))) {

				Chdispoaplic dispositivo = null;
				Iterator it = consulta.getChdispoaplic().iterator();
				if (it.hasNext()) {
					dispositivo = (Chdispoaplic) it.next();
				}

				if (dispositivo != null) {

					String s = "Ambito de realizacion: " + AMBITO_PF;
					String s2 = "Finalidad: " + FINALIDAD_PF;
					Chreporte report = new Chreporte();
					report.setHrecdescripcio(s);
					report.setHrecdescripcio2(s2);
					report.setHrentipoimpres(2);
					report.setHrectipodescri("AplicaciNn Retiro PF");
					report.setHrenconsulta(consulta.getHcolnumero());
					report.setHredfecharegis(consulta.getHcodfecregistr());
					report.setHrencodigo(imp_aplicacion_retiro_pf);
					lstReporte.add(report);

					report = new Chreporte();
					String insercion = "";
					if (dispositivo.getHdacinsercion() != null && dispositivo.getHdacinsercion().equals("S")) {

						if (dispositivo.getHdacdispoinser() != null) {
							if (dispositivo.getHdacdispoinser().equals("DI")) {
								insercion = "DIU";
							} else if (dispositivo.getHdacdispoinser().equals("MI")) {
								insercion = "Mirena";
							} else if (dispositivo.getHdacdispoinser().equals("JA")) {
								insercion = "Jadelle";
							} else if (dispositivo.getHdacdispoinser().equals("IM")) {
								insercion = "ImplanNn";
							} else if (dispositivo.getHdacdispoinser().equals("NP")) {
								insercion = "Norplant";
							} else if (dispositivo.getHdacdispoinser().equals("JY")) {
								insercion = "Jaydess";
							} else if (dispositivo.getHdacdispoinser().equals("KY")) {
								insercion = "Kyleena";
							}
						}

						report = new Chreporte();
						report.setHrecdescripcio("Se realizo inseciNn de: " + insercion);
						report.setHrencodigo(imp_aplicacion_retiro_pf);
						report.setHrectipodescri("AplicaciNn Retiro PF");
						report.setHrentipoimpres(1);
						report.setHrenconsulta(consulta.getHcolnumero());
						report.setHredfecharegis(consulta.getHcodfecregistr());
						lstReporte.add(report);

					}

					if (dispositivo.getHdacretiro() != null && dispositivo.getHdacretiro().equals("S")) {
						String retiro = "";
						if (dispositivo.getHdacdisporetir() != null) {
							if (dispositivo.getHdacdisporetir().equals("DI")) {
								retiro = "DIU";
							} else if (dispositivo.getHdacdisporetir().equals("MI")) {
								retiro = "Mirena";
							} else if (dispositivo.getHdacdisporetir().equals("JA")) {
								retiro = "Jadelle";
							} else if (dispositivo.getHdacdisporetir().equals("IM")) {
								retiro = "ImplanNn";
							} else if (dispositivo.getHdacdisporetir().equals("NP")) {
								retiro = "Norplant";
							} else if (dispositivo.getHdacdisporetir().equals("KY")) {
								retiro = "Kyleena";
							} else if (dispositivo.getHdacdisporetir().equals("SI")) {
								retiro = "Sino Implant";
							} else if (dispositivo.getHdacdisporetir().equals("JY")) {
								retiro = "Jaydess";
							}
						}

						report = new Chreporte();
						report.setHrecdescripcio("Se realizo retiro de: " + retiro);
						report.setHrencodigo(imp_aplicacion_retiro_pf);
						report.setHrectipodescri("AplicaciNn Retiro PF");
						report.setHrentipoimpres(1);
						report.setHrenconsulta(consulta.getHcolnumero());
						report.setHredfecharegis(consulta.getHcodfecregistr());
						lstReporte.add(report);

						if (dispositivo.getHdacmotivretir() != null) {
							String motivoRetiro = "";

							try {
								motivoRetiro = this.serviceLocator.getClinicoService()
										.getDescripcionRetiroImplante(dispositivo.getHdacmotivretir());
							} catch (ModelException e) {
								e.printStackTrace();
							}
							report = new Chreporte();
							report.setHrecdescripcio("Motivo del Retiro: " + motivoRetiro);
							report.setHrencodigo(imp_aplicacion_retiro_pf);
							report.setHrectipodescri("AplicaciNn Retiro PF");
							report.setHrentipoimpres(1);
							report.setHrenconsulta(consulta.getHcolnumero());
							report.setHredfecharegis(consulta.getHcodfecregistr());
							lstReporte.add(report);

						}

					}

					if (dispositivo != null && dispositivo.getHdacdeslugmar() != null) {
						report = new Chreporte();
						report.setHrecdescripcio("DescripciNn del lugar de marcaciNn del procedimiento	: "
								+ formatearCampo(dispositivo.getHdacdeslugmar()));
						report.setHrencodigo(imp_aplicacion_retiro_pf);
						report.setHrectipodescri("AplicaciNn Retiro PF");
						report.setHrentipoimpres(1);
						report.setHrenconsulta(consulta.getHcolnumero());
						report.setHredfecharegis(consulta.getHcodfecregistr());
						lstReporte.add(report);
					}

					if (DESCRIPCION_PROCEDIMIENTO_PF != null && !DESCRIPCION_PROCEDIMIENTO_PF.equals("")) {
						report = new Chreporte();
						report.setHrecdescripcio(
								"Descripcion del procedimiento: " + formatearCampoCLOB(DESCRIPCION_PROCEDIMIENTO_PF));
						report.setHrencodigo(imp_aplicacion_retiro_pf);
						report.setHrectipodescri("AplicaciNn Retiro PF");
						report.setHrentipoimpres(1);
						report.setHrenconsulta(consulta.getHcolnumero());
						report.setHredfecharegis(consulta.getHcodfecregistr());
						lstReporte.add(report);
					}

					if (DIAGNOSTICO_COMPLICACION_PF != null) {
						report = new Chreporte();
						s = "Tiene Complicaciones : " + TIENE_COMPLICACIONES_PF;
						s2 = "Diagnostico Complicacion: " + DIAGNOSTICO_COMPLICACION_PF;
						report = new Chreporte();
						report.setHrecdescripcio(s);
						if ("SI".equals(TIENE_COMPLICACIONES_PF)) {
							report.setHrecdescripcio2(s2);
						} else {
							report.setHrecdescripcio2("");
						}
						report.setHrentipoimpres(2);
						report.setHrectipodescri("AplicaciNn Retiro PF");
						report.setHrenconsulta(consulta.getHcolnumero());
						report.setHredfecharegis(consulta.getHcodfecregistr());
						report.setHrencodigo(imp_aplicacion_retiro_pf);
						lstReporte.add(report);
						if ("SI".equals(TIENE_COMPLICACIONES_PF)) {
							report = new Chreporte();
							s = "Descripcion de la complicaciNn: " + DESCRIPCION_COMPLICACION_PF;
							report.setHrecdescripcio(s);
							report.setHrentipoimpres(1);
							report.setHrectipodescri("AplicaciNn Retiro PF");
							report.setHrenconsulta(consulta.getHcolnumero());
							report.setHredfecharegis(consulta.getHcodfecregistr());
							report.setHrencodigo(imp_aplicacion_retiro_pf);
							lstReporte.add(report);
						}
					}

					report = new Chreporte();
					s = "Diagnostico Posterior: " + DIAGNOSTICO_POSTERIOR_PF;
					report.setHrecdescripcio(s);
					report.setHrentipoimpres(1);
					report.setHrectipodescri("AplicaciNn Retiro PF");
					report.setHrenconsulta(consulta.getHcolnumero());
					report.setHredfecharegis(consulta.getHcodfecregistr());
					report.setHrencodigo(imp_aplicacion_retiro_pf);
					lstReporte.add(report);

					if (REALIZACION_PROCEDIMIENTO_PF != null && !REALIZACION_PROCEDIMIENTO_PF.equals("")) {
						report = new Chreporte();
						s = "Realizacion: " + REALIZACION_PROCEDIMIENTO_PF;
						report.setHrecdescripcio(s);
						report.setHrentipoimpres(1);
						report.setHrectipodescri("AplicaciNn Retiro PF");
						report.setHrenconsulta(consulta.getHcolnumero());
						report.setHredfecharegis(consulta.getHcodfecregistr());
						report.setHrencodigo(imp_aplicacion_retiro_pf);
						lstReporte.add(report);

					}

				}

			}

			// Vacunacion

			if (consulta.getChcervaaplic() != null && !consulta.getChcervaaplic().isEmpty()) {
				for (Chcervaaplic aplicacion : consulta.getChcervaaplic()) {
					if (aplicacion != null) {

						FECHA_VACUNACION = formatearCampoHora(aplicacion.getHcadfecregistr());
						NUMERO_DOSIS = formatearCampo(aplicacion.getHcacnumerdosis());
						OBSERVACIONES_VACUNA = formatearCampo(aplicacion.getHcacobservacio());

					}
				}
			}

			// Datos Conducta

			if (consulta.getChconductas() != null && !consulta.getChconductas().isEmpty()) {
				Chreporte report = new Chreporte();
				RECOMENDACIONES_CONDUCTA = formatearCampo(RECOMENDACIONES_CONDUCTA);
				report = new Chreporte();
				report.setHrecdescripcio("Recomendaciones: " + formatearCampoCLOB(RECOMENDACIONES_CONDUCTA));
				report.setHrectipodescri("Conducta ");
				report.setHrencodigo(imp_conducta);
				report.setHrentipoimpres(1);
				report.setHrenconsulta(consulta.getHcolnumero());
				report.setHredfecharegis(consulta.getHcodfecregistr());
				lstReporte.add(report);

				if (RECOMENDACIONES_PLANMANEJO != null && !RECOMENDACIONES_PLANMANEJO.equals("")) {
					report = new Chreporte();
					RECOMENDACIONES_PLANMANEJO = formatearCampo(RECOMENDACIONES_PLANMANEJO);
					report = new Chreporte();
					report.setHrecdescripcio("Plan de Manejo: " + formatearCampoCLOB(RECOMENDACIONES_PLANMANEJO));
					report.setHrectipodescri("Conducta ");
					report.setHrencodigo(imp_conducta);
					report.setHrentipoimpres(1);
					report.setHrenconsulta(consulta.getHcolnumero());
					report.setHredfecharegis(consulta.getHcodfecregistr());
					lstReporte.add(report);
				}
			}

			if (consulta.getChinfomamogrs() != null && !consulta.getChinfomamogrs().isEmpty()) {

				Chinfomamogr informe = null;
				Iterator it = consulta.getChinfomamogrs().iterator();
				if (it.hasNext()) {
					informe = (Chinfomamogr) it.next();
				}

				if (informe.getId().getHimctipoinform() != null && informe.getId().getHimctipoinform().equals("1")) {

					Chreporte report = new Chreporte();
					report = new Chreporte();
					report.setHrecdescripcio("NNmero de Mamografia:  " + formatearCampo(NUMERO_MAMOGRAFIA));

					report.setHrecdescripcio2("Medico que remite:  " + MEDICO_REMITE);
					report.setHrectipodescri("Informe Mamografia");
					report.setHrencodigo(imp_informe_mamografia);
					report.setHrentipoimpres(6);
					report.setHrenconsulta(consulta.getHcolnumero());
					report.setHredfecharegis(consulta.getHcodfecregistr());
					lstReporte.add(report);

					report = new Chreporte();
					report.setHrecdescripcio("Datos Clinicos Relevantes: " + formatearCampo(DATOS_CLINICOS_RELEVANTES));
					report.setHrectipodescri("Informe Mamografia");
					report.setHrencodigo(imp_informe_mamografia);
					report.setHrentipoimpres(1);
					report.setHrenconsulta(consulta.getHcolnumero());
					report.setHredfecharegis(consulta.getHcodfecregistr());
					lstReporte.add(report);

					report = new Chreporte();
					report.setHrecdescripcio("Informe MamografNa: " + formatearCampo(INFORME_MAMOGRAFICO));
					report.setHrectipodescri("Informe Mamografia");
					report.setHrencodigo(imp_informe_mamografia);
					report.setHrentipoimpres(1);
					report.setHrenconsulta(consulta.getHcolnumero());
					report.setHredfecharegis(consulta.getHcodfecregistr());
					lstReporte.add(report);

					report = new Chreporte();
					report.setHrecdescripcio("Dosis Entrada a superficie: " + formatearCampo(DOSIS_SUPERFICIE));
					report.setHrectipodescri("Informe Mamografia");
					report.setHrencodigo(imp_informe_mamografia);
					report.setHrentipoimpres(1);
					report.setHrenconsulta(consulta.getHcolnumero());
					report.setHredfecharegis(consulta.getHcodfecregistr());
					lstReporte.add(report);

					report = new Chreporte();
					report.setHrecdescripcio("Dosis Entrada a superficie: " + formatearCampo(DOSIS_SUPERFICIE));
					report.setHrectipodescri("Informe Mamografia");
					report.setHrencodigo(imp_informe_mamografia);
					report.setHrentipoimpres(1);
					report.setHrenconsulta(consulta.getHcolnumero());
					report.setHredfecharegis(consulta.getHcodfecregistr());
					lstReporte.add(report);

					report = new Chreporte();
					report.setHrecdescripcio("Informe como tal: " + formatearCampo(INFORME_COMO_TAL_MAMOGRAFIA));
					report.setHrectipodescri("Informe Mamografia");
					report.setHrencodigo(imp_informe_mamografia);
					report.setHrentipoimpres(1);
					report.setHrenconsulta(consulta.getHcolnumero());
					report.setHredfecharegis(consulta.getHcodfecregistr());
					lstReporte.add(report);

					report = new Chreporte();
					report.setHrecdescripcio("OpiniNn: " + formatearCampo(OPINION_MAMOGRAFIA));
					report.setHrectipodescri("Informe Mamografia");
					report.setHrencodigo(imp_informe_mamografia);
					report.setHrentipoimpres(1);
					report.setHrenconsulta(consulta.getHcolnumero());
					report.setHredfecharegis(consulta.getHcodfecregistr());
					lstReporte.add(report);

					report = new Chreporte();
					report.setHrecdescripcio("Tipo Birads: " + formatearCampo(TIPO_BIRADS));
					report.setHrectipodescri("Informe Mamografia");
					report.setHrencodigo(imp_informe_mamografia);
					report.setHrentipoimpres(1);
					report.setHrenconsulta(consulta.getHcolnumero());
					report.setHredfecharegis(consulta.getHcodfecregistr());
					lstReporte.add(report);

					report = new Chreporte();
					report.setHrecdescripcio("Recomendaciones: " + formatearCampo(RECOMENDACIONES_MAMOGRAFIA));
					report.setHrectipodescri("Informe Mamografia");
					report.setHrencodigo(imp_informe_mamografia);
					report.setHrentipoimpres(1);
					report.setHrenconsulta(consulta.getHcolnumero());
					report.setHredfecharegis(consulta.getHcodfecregistr());
					lstReporte.add(report);

				}

				if (informe.getId().getHimctipoinform() != null && informe.getId().getHimctipoinform().equals("4")) {
					Chreporte report = new Chreporte();

					report = new Chreporte();
					if (GESTACIONES_ECOGRAFIA != null && !GESTACIONES_ECOGRAFIA.equals("")) {
						report.setHrecdescripcio("Gestaciones:  " + formatearCampo(GESTACIONES_ECOGRAFIA));
					}

					if (PARTOS_ECOGRAFIA != null && !PARTOS_ECOGRAFIA.equals("")) {
						report.setHrecdescripcio2("Partos:  " + formatearCampo(PARTOS_ECOGRAFIA));
					}

					if (ABORTOS_ECOGRAFIA != null && !ABORTOS_ECOGRAFIA.equals("")) {
						report.setHrecdescripcio3("Abortos:  " + formatearCampo(ABORTOS_ECOGRAFIA));
					}
					if (CESAREAS_ECOGRAFIA != null && !CESAREAS_ECOGRAFIA.equals("")) {
						report.setHrecdescripcio4("Cesareas:  " + formatearCampo(CESAREAS_ECOGRAFIA));
					}
					report.setHrectipodescri("Informe Ecografia");
					report.setHrentipoimpres(4);
					report.setHrencodigo(imp_informe_ecografia);
					report.setHrenconsulta(consulta.getHcolnumero());
					report.setHredfecharegis(consulta.getHcodfecregistr());
					lstReporte.add(report);

					report = new Chreporte();

					if (HIJOS_ECTOPICOS_ECOGRAFIA != null && !HIJOS_ECTOPICOS_ECOGRAFIA.equals("")) {
						report.setHrecdescripcio("Ectopicos: " + formatearCampo(HIJOS_ECTOPICOS_ECOGRAFIA));
					}

					report.setHrectipodescri("Informe Ecografia");
					report.setHrencodigo(imp_informe_ecografia);
					report.setHrentipoimpres(4);
					report.setHrenconsulta(consulta.getHcolnumero());
					report.setHredfecharegis(consulta.getHcodfecregistr());
					lstReporte.add(report);

					if (FUR_ECOGRAFIA != null) {
						report = new Chreporte();
						if (informe.getHimdfur() != null) {
							report.setHrecdescripcio("F.U.R. " + formatearCampo(FUR_ECOGRAFIA));

							report.setHrectipodescri("Informe Ecografia");
							report.setHrencodigo(imp_informe_ecografia);
							report.setHrentipoimpres(1);
							report.setHrenconsulta(consulta.getHcolnumero());
							report.setHredfecharegis(consulta.getHcodfecregistr());
							lstReporte.add(report);
						}
					}

					if (EDAD_GESTACIONAL_MENSTRUAL != null) {
						report = new Chreporte();

						report.setHrecdescripcio("Edad Gestacional menstrual. "
								+ formatearCampo(EDAD_GESTACIONAL_MENSTRUAL) + " Semanas");

						if (DIAS_EDAD_GESTACIONAL != null) {
							report.setHrecdescripcio(
									"Edad Gestacional menstrual. " + formatearCampo(EDAD_GESTACIONAL_MENSTRUAL)
											+ " Semanas " + DIAS_EDAD_GESTACIONAL + " dNas");
						}

						report.setHrectipodescri("Informe Ecografia");
						report.setHrencodigo(imp_informe_ecografia);
						report.setHrentipoimpres(1);
						report.setHrenconsulta(consulta.getHcolnumero());
						report.setHredfecharegis(consulta.getHcodfecregistr());
						lstReporte.add(report);

					}

					report = new Chreporte();
					report.setHrecdescripcio("Informe: " + formatearCampo(INFORME_ECOGRAFIA));
					report.setHrectipodescri("Informe Ecografia");
					report.setHrencodigo(imp_informe_ecografia);
					report.setHrentipoimpres(1);
					report.setHrenconsulta(consulta.getHcolnumero());
					report.setHredfecharegis(consulta.getHcodfecregistr());
					lstReporte.add(report);

					report = new Chreporte();
					report.setHrecdescripcio("Conclusiones ");
					report.setHrectipodescri("Informe Ecografia");
					report.setHrencodigo(imp_informe_ecografia);
					report.setHrentipoimpres(1);
					report.setHrenconsulta(consulta.getHcolnumero());
					report.setHredfecharegis(consulta.getHcodfecregistr());
					lstReporte.add(report);

					report = new Chreporte();
					report.setHrecdescripcio(formatearCampo(CONCLUSION_ECOGRAFIA));
					report.setHrectipodescri("Informe Ecografia");
					report.setHrencodigo(imp_informe_ecografia);
					report.setHrentipoimpres(1);
					report.setHrenconsulta(consulta.getHcolnumero());
					report.setHredfecharegis(consulta.getHcodfecregistr());
					lstReporte.add(report);
				}

				if (informe.getId().getHimctipoinform() != null && informe.getId().getHimctipoinform().equals("5")) {
					Chreporte report = new Chreporte();
					report = new Chreporte();
					report.setHrecdescripcio("IndicaciNn del Examen: " + formatearCampo(INDICACION_EXAMEN_ECOGRAFIA));
					report.setHrectipodescri("Informe HisterosonografNa");
					report.setHrencodigo(imp_informe_histerosonografia);
					report.setHrentipoimpres(1);
					report.setHrenconsulta(consulta.getHcolnumero());
					report.setHredfecharegis(consulta.getHcodfecregistr());
					lstReporte.add(report);

					report = new Chreporte();
					report.setHrecdescripcio(
							"Transductor utilizado: " + formatearCampo(TRASNDUCTOR_UTILIZADO_ECOGRAFIA));
					report.setHrectipodescri("Informe HisterosonografNa");
					report.setHrencodigo(imp_informe_histerosonografia);
					report.setHrentipoimpres(1);
					report.setHrenconsulta(consulta.getHcolnumero());
					report.setHredfecharegis(consulta.getHcodfecregistr());
					lstReporte.add(report);

					report = new Chreporte();
					report.setHrecdescripcio(
							"Transductor utilizado: " + formatearCampo(TRASNDUCTOR_UTILIZADO_ECOGRAFIA));
					report.setHrectipodescri("Informe HisterosonografNa");
					report.setHrencodigo(imp_informe_histerosonografia);
					report.setHrentipoimpres(1);
					report.setHrenconsulta(consulta.getHcolnumero());
					report.setHredfecharegis(consulta.getHcodfecregistr());
					lstReporte.add(report);

					report = new Chreporte();
					report.setHrecdescripcio("Informe: " + formatearCampo(INFORME_ECOGRAFIA));
					report.setHrectipodescri("Informe HisterosonografNa");
					report.setHrencodigo(imp_informe_histerosonografia);
					report.setHrentipoimpres(1);
					report.setHrenconsulta(consulta.getHcolnumero());
					report.setHredfecharegis(consulta.getHcodfecregistr());
					lstReporte.add(report);

					report = new Chreporte();
					report.setHrecdescripcio("ConclusiNn: " + formatearCampo(CONCLUSION_ECOGRAFIA));
					report.setHrectipodescri("Informe HisterosonografNa");
					report.setHrencodigo(imp_informe_histerosonografia);
					report.setHrentipoimpres(1);
					report.setHrenconsulta(consulta.getHcolnumero());
					report.setHredfecharegis(consulta.getHcodfecregistr());
					lstReporte.add(report);
				}

			}

			if (consulta.getChincapacidas() != null && !consulta.getChincapacidas().isEmpty()) {
				Chreporte report = new Chreporte();
				report = new Chreporte();
				report.setHrecdescripcio("Fecha Inicial: " + formatearCampo(FECHA_INICIAL_INCAPACIDAD));
				report.setHrecdescripcio2("Fecha Final: " + formatearCampo(FECHA_FINAL_INCAPACIDAD));
				report.setHrectipodescri("Incapacidad ");
				report.setHrencodigo(imp_incapacidad);
				report.setHrentipoimpres(6);
				report.setHrenconsulta(consulta.getHcolnumero());
				report.setHredfecharegis(consulta.getHcodfecregistr());
				lstReporte.add(report);

				report = new Chreporte();
				report = new Chreporte();
				report.setHrecdescripcio("Tipo Incapacidad: " + formatearCampo(TIPO_INCAPACIDAD));
				report.setHrecdescripcio2("Origen Incapacidad: " + formatearCampo(ORIGEN_INCAPACIDAD));
				report.setHrectipodescri("Incapacidad ");
				report.setHrencodigo(imp_incapacidad);
				report.setHrentipoimpres(6);
				report.setHrenconsulta(consulta.getHcolnumero());
				report.setHredfecharegis(consulta.getHcodfecregistr());
				lstReporte.add(report);

			}

			// Datos Orden Cirugia

			if (consulta.getChordecirugis() != null && !consulta.getChordecirugis().isEmpty()) {

				Chordecirugi ordenCirugia = null;
				Iterator it = consulta.getChordecirugis().iterator();
				if (it.hasNext()) {
					ordenCirugia = (Chordecirugi) it.next();
				}

				if (ordenCirugia != null) {
					Chreporte report = new Chreporte();
					report = new Chreporte();
					report.setHrecdescripcio("IntervenciNn Propuesta : " + formatearCampo(INTERVENCIONES_PROPUESTAS));
					if (ordenCirugia.getHocntiempointe() != null) {
						report.setHrecdescripcio2("Tiempo Qx: " + formatearCampo(ordenCirugia.getHocntiempointe()));
					} else {
						report.setHrecdescripcio2("");
					}

					report.setHrectipodescri("CirugNas y procedimientos ");
					report.setHrencodigo(imp_orden_cirugia);
					report.setHrentipoimpres(2);
					report.setHrenconsulta(consulta.getHcolnumero());
					report.setHredfecharegis(consulta.getHcodfecregistr());
					lstReporte.add(report);

					report = new Chreporte();
					report.setHrecdescripcio("Observaciones: " + OBSERVACIONES_ORDEN);
					report.setHrectipodescri("CirugNas y procedimientos ");
					report.setHrencodigo(imp_orden_cirugia);
					report.setHrentipoimpres(1);
					report.setHrenconsulta(consulta.getHcolnumero());
					report.setHredfecharegis(consulta.getHcodfecregistr());
					lstReporte.add(report);

					report = new Chreporte();
					report.setHrecdescripcio("La Paciente acepta y entiende el procedimiento : "
							+ formatearCampo(PACIENTE_ACEPTA_ORDEN));
					report.setHrecdescripcio2(
							"Lugar de realizaciNn del procedimiento: " + formatearCampo(LUGAR_CIRUGIA));
					report.setHrectipodescri("CirugNas y procedimientos ");
					report.setHrencodigo(imp_orden_cirugia);
					report.setHrentipoimpres(2);
					report.setHrenconsulta(consulta.getHcolnumero());
					report.setHredfecharegis(consulta.getHcodfecregistr());
					lstReporte.add(report);

					report = new Chreporte();
					if (ANESTESIA_SOLICITADA != null && !ANESTESIA_SOLICITADA.equals("")) {
						report.setHrecdescripcio("Anestesia Solicitada : " + formatearCampo(ANESTESIA_SOLICITADA));
					} else {
						report.setHrecdescripcio("");
					}

					if (AYUDANTIA != null && !AYUDANTIA.equals("")) {
						report.setHrecdescripcio2("Ayudantia :" + formatearCampo(AYUDANTIA));
					} else {
						report.setHrecdescripcio2("");
					}

					report.setHrectipodescri("CirugNas y procedimientos ");
					report.setHrencodigo(imp_orden_cirugia);
					report.setHrentipoimpres(2);
					report.setHrenconsulta(consulta.getHcolnumero());
					report.setHredfecharegis(consulta.getHcodfecregistr());
					lstReporte.add(report);

					report = new Chreporte();
					if (ESTANCIA != null && !ESTANCIA.equals("")) {
						report.setHrecdescripcio("Estancia : " + formatearCampo(ESTANCIA));
					} else {
						report.setHrecdescripcio("");
					}

					if (NUMERO_DIAS_ESTANCIA != null) {
						report.setHrecdescripcio2("Numero de Dias :" + formatearCampo(NUMERO_DIAS_ESTANCIA));
					} else {
						report.setHrecdescripcio2("");
					}

					report.setHrectipodescri("CirugNas y procedimientos ");
					report.setHrencodigo(imp_orden_cirugia);
					report.setHrentipoimpres(2);
					report.setHrenconsulta(consulta.getHcolnumero());
					report.setHredfecharegis(consulta.getHcodfecregistr());
					lstReporte.add(report);

					report = new Chreporte();
					if (RESERVA_SANGRE != null && !RESERVA_SANGRE.equals("")) {
						report.setHrecdescripcio("Reserva de sangre : " + formatearCampo(RESERVA_SANGRE));
					} else {
						report.setHrecdescripcio("");
					}
					if (UNIDADES_SANGRE != null) {
						report.setHrecdescripcio2("Unidades :" + formatearCampo(UNIDADES_SANGRE));
					} else {
						report.setHrecdescripcio2("");
					}

					report.setHrectipodescri("CirugNas y procedimientos ");
					report.setHrencodigo(imp_orden_cirugia);
					report.setHrentipoimpres(2);
					report.setHrenconsulta(consulta.getHcolnumero());
					report.setHredfecharegis(consulta.getHcodfecregistr());
					lstReporte.add(report);

					report = new Chreporte();
					if (PATOLOGIA != null && !PATOLOGIA.equals("")) {
						report.setHrecdescripcio("Patologia : " + formatearCampo(PATOLOGIA));
					} else {
						report.setHrecdescripcio("");
					}
					if (PROGRAMAR_ANESTESIOLOGO != null && !PROGRAMAR_ANESTESIOLOGO.equals("")) {
						report.setHrecdescripcio2(
								"Programar Anestesiologo :" + formatearCampo(PROGRAMAR_ANESTESIOLOGO));
					} else {
						report.setHrecdescripcio2("");
					}

					report.setHrectipodescri("CirugNas y procedimientos ");
					report.setHrencodigo(imp_orden_cirugia);
					report.setHrentipoimpres(2);
					report.setHrenconsulta(consulta.getHcolnumero());
					report.setHredfecharegis(consulta.getHcodfecregistr());
					lstReporte.add(report);
				}

			}

			// Datos examenes Paraclinicos
			if (consulta.getChexameparacs() != null && !consulta.getChexameparacs().isEmpty()) {

				Chreporte report = new Chreporte();

				if (FISIOLOGICOS != null && !FISIOLOGICOS.equals("")) {
					report = new Chreporte();
					report.setHrectipodescri("Examenes Paraclinicos");
					report.setHrecdescripcio("Electrofisiologicos:");
					report.setHrecdescripcio2(formatearCampo(FISIOLOGICOS));
					report.setHrencodigo(imp_examenes_paraclinicos);
					report.setHrentipoimpres(3);
					report.setHrenconsulta(consulta.getHcolnumero());
					report.setHredfecharegis(consulta.getHcodfecregistr());
					lstReporte.add(report);
				}

				if (IMAGENES != null && !IMAGENES.equals("")) {
					report = new Chreporte();
					report.setHrectipodescri("Examenes Paraclinicos");
					report.setHrecdescripcio("Imagenes:");
					report.setHrecdescripcio2(formatearCampo(IMAGENES));
					report.setHrencodigo(imp_examenes_paraclinicos);
					report.setHrentipoimpres(3);
					report.setHrenconsulta(consulta.getHcolnumero());
					report.setHredfecharegis(consulta.getHcodfecregistr());
					lstReporte.add(report);
				}

				if (LABORATORIOS != null && !LABORATORIOS.equals("")) {
					report = new Chreporte();
					report.setHrectipodescri("Examenes Paraclinicos");
					report.setHrecdescripcio("Laboratorios:");
					report.setHrecdescripcio2(formatearCampo(LABORATORIOS));
					report.setHrencodigo(imp_examenes_paraclinicos);
					report.setHrentipoimpres(3);
					report.setHrenconsulta(consulta.getHcolnumero());
					report.setHredfecharegis(consulta.getHcodfecregistr());
					lstReporte.add(report);
				}

			}
			// Datos Referencia
			if (consulta.getChreferencias() != null && !consulta.getChreferencias().isEmpty()) {

				Chreporte report = new Chreporte();
				report = new Chreporte();
				report.setHrectipodescri("Referencia");
				report.setHrecdescripcio("Tipo de Servicio: " + formatearCampo(TIPO_SERVICIO));
				report.setHrencodigo(imp_referencia);
				report.setHrentipoimpres(1);
				report.setHrenconsulta(consulta.getHcolnumero());
				report.setHredfecharegis(consulta.getHcodfecregistr());
				lstReporte.add(report);

				report = new Chreporte();
				report.setHrectipodescri("Referencia");
				report.setHrecdescripcio("Nombre Responsable: " + formatearCampo(NOMBRE_RESPONSABLE_REFERENCIA));
				report.setHrencodigo(imp_referencia);
				report.setHrentipoimpres(1);
				report.setHrenconsulta(consulta.getHcolnumero());
				report.setHredfecharegis(consulta.getHcodfecregistr());
				lstReporte.add(report);

				report = new Chreporte();
				report.setHrectipodescri("Referencia");
				report.setHrecdescripcio("Direccion Responsable: " + formatearCampo(DIRECCION_RESPONSABLE_REFERENCIA));
				report.setHrecdescripcio2("Telefono Responsable: " + formatearCampo(TELEFONO_RESPONSABLE_REFERENCIA));
				report.setHrencodigo(imp_referencia);
				report.setHrentipoimpres(6);
				report.setHrenconsulta(consulta.getHcolnumero());
				report.setHredfecharegis(consulta.getHcodfecregistr());
				lstReporte.add(report);

				report = new Chreporte();
				report.setHrectipodescri("Referencia");
				report.setHrecdescripcio("Anamnesis : " + formatearCampo(ANAMNESIS));
				report.setHrencodigo(imp_referencia);
				report.setHrentipoimpres(1);
				report.setHrenconsulta(consulta.getHcolnumero());
				report.setHredfecharegis(consulta.getHcodfecregistr());
				lstReporte.add(report);

				report = new Chreporte();
				report.setHrectipodescri("Referencia");
				report.setHrecdescripcio("Apoyo Diagnostico : " + formatearCampo(APOYO_DIAGNOSTICO));
				report.setHrencodigo(imp_referencia);
				report.setHrentipoimpres(1);
				report.setHrenconsulta(consulta.getHcolnumero());
				report.setHredfecharegis(consulta.getHcodfecregistr());
				lstReporte.add(report);

				report = new Chreporte();
				report.setHrectipodescri("Referencia");
				report.setHrecdescripcio(
						"JustificaciNn de la referencia  : " + formatearCampo(JUSTIFICACION_REFERENCIA));
				report.setHrencodigo(imp_referencia);
				report.setHrentipoimpres(1);
				report.setHrenconsulta(consulta.getHcolnumero());
				report.setHredfecharegis(consulta.getHcodfecregistr());
				lstReporte.add(report);
			}

			// Datos Anatomia Patologica

			if (consulta.getChanatopatols() != null && !consulta.getChanatopatols().isEmpty()) {
				Chreporte report = new Chreporte();
				report = new Chreporte();
				report.setHrectipodescri("Anatomia Patologica");
				report.setHrecdescripcio("Origen de la pieza : " + formatearCampo(ORIGEN_PIEZA));
				report.setHrencodigo(imp_anatomia_patologica);
				report.setHrentipoimpres(1);
				report.setHrenconsulta(consulta.getHcolnumero());
				report.setHredfecharegis(consulta.getHcodfecregistr());
				lstReporte.add(report);

			}

			// Datos Formula Medica

			if (consulta.getChformulameds() != null && !consulta.getChformulameds().isEmpty()) {

				Iterator cm = consulta.getChformulameds().iterator();
				String conciliaciNnMedicamentosa = null;
				while (cm.hasNext()) {
					Chformulamed formula = (Chformulamed) cm.next();
					if (formula.getHfocconcimedic() != null) {
						conciliaciNnMedicamentosa = formula.getHfocconcimedic();
					}
				}
				if (conciliaciNnMedicamentosa != null) {
					Chreporte report = new Chreporte();
					report.setHrectipodescri("PrescripciNn MNdica");
					report.setHrecdescripcio(
							"Se realizo reconciliaciNn medicamentosa?: " + formatearCampo(conciliaciNnMedicamentosa));
					report.setHrencodigo(imp_prescripcion_medica);
					report.setHrentipoimpres(1);
					report.setHrenconsulta(consulta.getHcolnumero());
					report.setHredfecharegis(consulta.getHcodfecregistr());
					lstReporte.add(report);
				}
				Iterator it = consulta.getChformulameds().iterator();
				while (it.hasNext()) {
					Chformulamed formula = (Chformulamed) it.next();
					imprimirFormulaMedica(formula, consulta);
				}

			}

			// Datos Notas Medicas

			if (consulta.getChnotamedicas() != null && !consulta.getChnotamedicas().isEmpty()) {

				Chreporte report = new Chreporte();
				report = new Chreporte();
				report.setHrectipodescri("Nota Aclaratoria");
				report.setHrecdescripcio("Notas Aclaratoria : " + formatearCampo(NOTA_ACLARATORIA));
				report.setHrencodigo(imp_nota_medica);
				report.setHrentipoimpres(1);
				report.setHrenconsulta(consulta.getHcolnumero());
				report.setHredfecharegis(consulta.getHcodfecregistr());
				lstReporte.add(report);
			}

			// Datos Evoluciones

			if (consulta.getChevoluconsu() != null && !consulta.getChevoluconsu().isEmpty()) {

				Chreporte report = new Chreporte();
				report = new Chreporte();
				report.setHrectipodescri("EvoluciNn Consulta");
				report.setHrecdescripcio("Evolucion : " + formatearCampo(EVOLUCION));
				report.setHrencodigo(imp_evolucion);
				report.setHrentipoimpres(1);
				report.setHrenconsulta(consulta.getHcolnumero());
				report.setHredfecharegis(consulta.getHcodfecregistr());
				lstReporte.add(report);
			}

			// MUESTRA EL REGISTRO DE EXAMENES CLINICOS
			registroExamenesClinicos(consulta);

		}
	}

	public void registroExamenesClinicos(Chconsulta consulta) {

		if (consulta.getChregisexame() != null && !consulta.getChregisexame().isEmpty()) {

			Iterator it = consulta.getChregisexame().iterator();

			while (it.hasNext()) {
				Chregisexame registro = (Chregisexame) it.next();
				TIENE_LABORATORIO_CLINICO = formatearCampo(registro.getHreelaborclini());
				TIENE_IMAGENES = formatearCampo(registro.getHreeimagediagn());
				TIENE_ESTUDIO_PATOLOGIA = formatearCampo(registro.getHreeestudpatol());
				TIENE_PRUEBA_EMBARAZO = formatearCampo(registro.getHreepruebembar());
				TIENE_CITOLOGIA = formatearCampo(registro.getHreecitologia());
				TIENE_COLPOSCOPIA = formatearCampo(registro.getHreecolposcopi());
				TIENE_OTROS_EXAMENES = formatearCampo(registro.getHreecualexame());

				Chreporte report = new Chreporte();

				report = new Chreporte();
				report.setHrectipodescri("Resultado ExNmenes ClNnicos");
				report.setHrecdescripcio("Fecha de Registro: " + formatearCampo(registro.getHredfecregistr())
						+ "   Hora: " + formatearCampoHoraSimple(registro.getHredfecregistr()));
				report.setHrencodigo(imp_registro_examenes);
				report.setHrentipoimpres(1);
				report.setHrenconsulta(consulta.getHcolnumero());
				report.setHredfecharegis(consulta.getHcodfecregistr());
				lstReporte.add(report);

				Cpprofesio profesional = null;

				try {
					profesional = serviceLocator.getClinicoService()
							.getProfesionalPorUsuario(registro.getHrecoperador(), registro.getHrenclinica());
				} catch (ModelException e) {
					e.printStackTrace();
				}
				report = new Chreporte();
				report.setHrectipodescri("Resultado ExNmenes ClNnicos");
				report.setHrecdescripcio("Usuario que registro: " + profesional.getCpfcnombre());
				report.setHrencodigo(imp_registro_examenes);
				report.setHrentipoimpres(1);
				report.setHrenconsulta(consulta.getHcolnumero());
				report.setHredfecharegis(consulta.getHcodfecregistr());
				lstReporte.add(report);

				report = new Chreporte();
				report.setHrectipodescri("Resultado ExNmenes ClNnicos");
				report.setHrecdescripcio(" Laboratorio ClNnico : " + TIENE_LABORATORIO_CLINICO);
				if (registro.getHreclaborclini() != null && !registro.getHreclaborclini().equals("")) {
					report.setHrecdescripcio2(registro.getHreclaborclini());
				} else {
					report.setHrecdescripcio2("");
				}
				report.setHrencodigo(imp_registro_examenes);
				report.setHrentipoimpres(3);
				report.setHrenconsulta(consulta.getHcolnumero());
				report.setHredfecharegis(consulta.getHcodfecregistr());
				lstReporte.add(report);

				report = new Chreporte();
				report.setHrectipodescri("Resultado ExNmenes ClNnicos");
				report.setHrecdescripcio(" Imagenes Diagnosticas : " + TIENE_IMAGENES);
				if (registro.getHrecimagediagn() != null && !registro.getHrecimagediagn().equals("")) {
					report.setHrecdescripcio2(registro.getHrecimagediagn());
				} else {
					report.setHrecdescripcio2("");
				}
				report.setHrencodigo(imp_registro_examenes);
				report.setHrentipoimpres(3);
				report.setHrenconsulta(consulta.getHcolnumero());
				report.setHredfecharegis(consulta.getHcodfecregistr());
				lstReporte.add(report);

				report = new Chreporte();
				report.setHrectipodescri("Resultado ExNmenes ClNnicos");
				report.setHrecdescripcio(" Estudio de patologia : " + TIENE_ESTUDIO_PATOLOGIA);
				if (registro.getHrecestudpatol() != null && !registro.getHrecestudpatol().equals("")) {
					report.setHrecdescripcio2(registro.getHrecestudpatol());
				} else {
					report.setHrecdescripcio2("");
				}
				report.setHrencodigo(imp_registro_examenes);
				report.setHrentipoimpres(3);
				report.setHrenconsulta(consulta.getHcolnumero());
				report.setHredfecharegis(consulta.getHcodfecregistr());
				lstReporte.add(report);

				report = new Chreporte();
				report.setHrectipodescri("Resultado ExNmenes ClNnicos");
				report.setHrecdescripcio(" Prueba de Embarazo : " + TIENE_PRUEBA_EMBARAZO);
				if (registro.getHrecpruebembar() != null && !registro.getHrecpruebembar().equals("")) {
					report.setHrecdescripcio2(registro.getHrecpruebembar());
				} else {
					report.setHrecdescripcio2("");
				}
				report.setHrencodigo(imp_registro_examenes);
				report.setHrentipoimpres(3);
				report.setHrenconsulta(consulta.getHcolnumero());
				report.setHredfecharegis(consulta.getHcodfecregistr());
				lstReporte.add(report);

				report = new Chreporte();
				report.setHrectipodescri("Resultado ExNmenes ClNnicos");
				report.setHrecdescripcio(" Citologia : " + TIENE_CITOLOGIA);
				if (registro.getHreccitologia() != null && !registro.getHreccitologia().equals("")) {
					report.setHrecdescripcio2(registro.getHreccitologia());
				} else {
					report.setHrecdescripcio2("");
				}
				report.setHrencodigo(imp_registro_examenes);
				report.setHrentipoimpres(3);
				report.setHrenconsulta(consulta.getHcolnumero());
				report.setHredfecharegis(consulta.getHcodfecregistr());
				lstReporte.add(report);

				report = new Chreporte();
				report.setHrectipodescri("Resultado ExNmenes ClNnicos");
				report.setHrecdescripcio(" Colposcopia : " + TIENE_COLPOSCOPIA);
				if (registro.getHreccolposcopi() != null && !registro.getHreccolposcopi().equals("")) {
					report.setHrecdescripcio2(registro.getHreccolposcopi());
				} else {
					report.setHrecdescripcio2("");
				}
				report.setHrencodigo(imp_registro_examenes);
				report.setHrentipoimpres(3);
				report.setHrenconsulta(consulta.getHcolnumero());
				report.setHredfecharegis(consulta.getHcodfecregistr());
				lstReporte.add(report);

				report = new Chreporte();
				report.setHrectipodescri("Resultado ExNmenes ClNnicos");
				report.setHrecdescripcio(" Otros Examenes : " + TIENE_OTROS_EXAMENES);
				if (registro.getHreccualexame() != null && !registro.getHreccualexame().equals("")) {
					report.setHrecdescripcio2(registro.getHreccualexame());
				} else {
					report.setHrecdescripcio2("");
				}
				report.setHrencodigo(imp_registro_examenes);
				report.setHrentipoimpres(3);
				report.setHrenconsulta(consulta.getHcolnumero());
				report.setHredfecharegis(consulta.getHcodfecregistr());
				lstReporte.add(report);

				report = new Chreporte();
				report.setHrectipodescri("Resultado ExNmenes ClNnicos");
				report.setHrecdescripcio("");
				report.setHrencodigo(imp_registro_examenes);
				report.setHrentipoimpres(1);
				report.setHrenconsulta(consulta.getHcolnumero());
				report.setHredfecharegis(consulta.getHcodfecregistr());
				lstReporte.add(report);

				report = new Chreporte();
				report.setHrectipodescri("Resultado ExNmenes ClNnicos");
				report.setHrecdescripcio("**************************************************************************"
						+ "***************************************************************************************************");
				report.setHrencodigo(imp_registro_examenes);
				report.setHrentipoimpres(1);
				report.setHrenconsulta(consulta.getHcolnumero());
				report.setHredfecharegis(consulta.getHcodfecregistr());
				lstReporte.add(report);

			}
		}

		if (consulta.getChexameimages() != null && !consulta.getChexameimages().isEmpty()) {
			List<Chexameimage> lstExamenesImagenes;
			lstExamenesImagenes = new ArrayList<Chexameimage>();
			lstExamenesImagenes.addAll(consulta.getChexameimages());

			if (lstExamenesImagenes != null && !lstExamenesImagenes.isEmpty()) {
				Chexameimage imagenes = null;
				String observaciones = null;
				Iterator it = lstExamenesImagenes.iterator();

				while (it.hasNext()) {
					imagenes = (Chexameimage) it.next();
					observaciones = imagenes.getHeicobservacio();
					Chreporte report = new Chreporte();
					report = new Chreporte();
					report.setHrectipodescri("Examenes Imagenes");
					report.setHrecdescripcio(" " + imagenes.getCpservicio().getCsvcnombre());
					report.setHrencodigo(imp_examenes_imagenes);
					report.setHrenconsulta(consulta.getHcolnumero());
					report.setHredfecharegis(consulta.getHcodfecregistr());
					report.setHrentipoimpres(1);
					lstReporte.add(report);
				}

				if (observaciones != null) {
					Chreporte report = new Chreporte();
					report = new Chreporte();
					report.setHrectipodescri("Examenes Imagenes");
					report.setHrecdescripcio("Observaciones: " + observaciones);
					report.setHrencodigo(imp_examenes_imagenes);
					report.setHrentipoimpres(1);
					report.setHrenconsulta(consulta.getHcolnumero());
					report.setHredfecharegis(consulta.getHcodfecregistr());
					lstReporte.add(report);
				}

			}

		}

		if (consulta.getChexameelects() != null && !consulta.getChexameelects().isEmpty()) {
			List<Chexameelect> lstExamenesElectrofisiologicos;
			lstExamenesElectrofisiologicos = new ArrayList<Chexameelect>();
			lstExamenesElectrofisiologicos.addAll(consulta.getChexameelects());

			if (lstExamenesElectrofisiologicos != null && !lstExamenesElectrofisiologicos.isEmpty()) {
				Chexameelect electrofisiologicos = null;
				String observaciones = null;
				Iterator it = lstExamenesElectrofisiologicos.iterator();

				while (it.hasNext()) {
					electrofisiologicos = (Chexameelect) it.next();
					observaciones = electrofisiologicos.getHeecobservacio();
					Chreporte report = new Chreporte();
					report = new Chreporte();
					report.setHrectipodescri("Examenes Electrofisiologicos");
					report.setHrecdescripcio(" " + electrofisiologicos.getCpservicio().getCsvcnombre());
					report.setHrencodigo(imp_examenes_electrofisiologicos);
					report.setHrenconsulta(consulta.getHcolnumero());
					report.setHredfecharegis(consulta.getHcodfecregistr());
					report.setHrentipoimpres(1);
					lstReporte.add(report);
				}

				if (observaciones != null) {
					Chreporte report = new Chreporte();
					report = new Chreporte();
					report.setHrectipodescri("Examenes Electrofisiologicos");
					report.setHrecdescripcio("Observaciones: " + observaciones);
					report.setHrencodigo(imp_examenes_electrofisiologicos);
					report.setHrentipoimpres(1);
					report.setHrenconsulta(consulta.getHcolnumero());
					report.setHredfecharegis(consulta.getHcodfecregistr());
					lstReporte.add(report);
				}

			}

		}

		if (consulta.getChexamelabors() != null && !consulta.getChexamelabors().isEmpty()) {
			List<Chexamelabor> lstExamenesLaboratorios;
			lstExamenesLaboratorios = new ArrayList<Chexamelabor>();
			lstExamenesLaboratorios.addAll(consulta.getChexamelabors());

			if (lstExamenesLaboratorios != null && !lstExamenesLaboratorios.isEmpty()) {
				Chexamelabor laboratorios = null;
				String observaciones = null;
				Iterator it = lstExamenesLaboratorios.iterator();

				while (it.hasNext()) {
					laboratorios = (Chexamelabor) it.next();
					observaciones = laboratorios.getHelcobservacio();
					Chreporte report = new Chreporte();
					report = new Chreporte();
					report.setHrectipodescri("Examenes Laboratorios");
					report.setHrecdescripcio(" " + laboratorios.getCpservicio().getCsvcnombre());
					report.setHrencodigo(imp_examenes_laboratorios);
					report.setHrentipoimpres(1);
					report.setHrenconsulta(consulta.getHcolnumero());
					report.setHredfecharegis(consulta.getHcodfecregistr());
					lstReporte.add(report);
				}

				if (observaciones != null) {
					Chreporte report = new Chreporte();
					report = new Chreporte();
					report.setHrectipodescri("Examenes Laboratorios");
					report.setHrecdescripcio("Observaciones: " + observaciones);
					report.setHrencodigo(imp_examenes_laboratorios);
					report.setHrentipoimpres(1);
					report.setHrenconsulta(consulta.getHcolnumero());
					report.setHredfecharegis(consulta.getHcodfecregistr());
					lstReporte.add(report);
				}

			}
		}

		if (consulta.getChremisions() != null && !consulta.getChremisions().isEmpty()) {
			List<Chremision> lstInterconsulta;
			lstInterconsulta = new ArrayList<Chremision>();
			lstInterconsulta.addAll(consulta.getChremisions());

			if (lstInterconsulta != null && !lstInterconsulta.isEmpty()) {
				Chremision interconsulta = null;

				Iterator it = lstInterconsulta.iterator();

				while (it.hasNext()) {
					interconsulta = (Chremision) it.next();
					Chreporte report = new Chreporte();
					Chtipointerc tipoAux = null;
					String tipoRemision = null;
					try {
						tipoAux = this.getServiceLocator().getClinicoService()
								.getInterconsultaPorCriterios(interconsulta.getHrecservicio());
					} catch (ModelException e) {
						e.printStackTrace();
					}
					if (tipoAux == null || tipoAux.getHticdescripcio() == null) {
						tipoRemision = "Servicio no encontrado";
					} else {
						tipoRemision = tipoAux.getHticdescripcio();
					}
					report = new Chreporte();
					report.setHrectipodescri("Interconsulta");
					report.setHrecdescripcio("Tipo: " + tipoRemision);
					report.setHrecdescripcio2("Descripcion: " + interconsulta.getHrecdescripcio());
					report.setHrencodigo(imp_interconsulta);
					report.setHrentipoimpres(6);
					report.setHrenconsulta(consulta.getHcolnumero());
					report.setHredfecharegis(consulta.getHcodfecregistr());
					lstReporte.add(report);
				}

			}

		}

		if (consulta.getChcertmedicos() != null && !consulta.getChcertmedicos().isEmpty()) {
			for (Chcertmedico certificado : consulta.getChcertmedicos()) {
				if (certificado != null && certificado.getId() != null) {
					if (certificado.getId().getHcmctipocert().equals("M")) {
						Chreporte report = new Chreporte();
						report = new Chreporte();
						report.setHrectipodescri("Certificado MNdico");
						report.setHrecdescripcio(certificado.getHcmccertifica());
						report.setHrencodigo(imp_certificado_medico);
						report.setHrentipoimpres(1);
						report.setHrenconsulta(consulta.getHcolnumero());
						report.setHredfecharegis(consulta.getHcodfecregistr());
						lstReporte.add(report);
					} else if (certificado.getId().getHcmctipocert().equals("A")) {
						Chreporte report = new Chreporte();

						report.setHrectipodescri("Certificado Asistencia");
						report.setHrecdescripcio(obtenerCertificadoAsistencia(consulta, certificado));
						report.setHrencodigo(imp_certificado_asistencia);
						report.setHrentipoimpres(1);
						report.setHrenconsulta(consulta.getHcolnumero());
						report.setHredfecharegis(consulta.getHcodfecregistr());
						lstReporte.add(report);
					}
				}

			}

		}

		if (consulta.getChremihospits() != null && !consulta.getChremihospits().isEmpty()) {
			for (Chremihospit hospitalizacion : consulta.getChremihospits()) {
				if (hospitalizacion != null) {
					Chreporte report = new Chreporte();
					report = new Chreporte();
					report.setHrectipodescri("RemisiNn HospitalizaciNn");
					report.setHrecdescripcio("Motivo de la HospitalizaciNn: " + hospitalizacion.getHrhcmotivhospi());
					report.setHrencodigo(imp_remision_hospitalizacion);
					report.setHrenconsulta(consulta.getHcolnumero());
					report.setHredfecharegis(consulta.getHcodfecregistr());
					report.setHrentipoimpres(1);
					lstReporte.add(report);

					report = new Chreporte();
					report.setHrectipodescri("RemisiNn HospitalizaciNn");
					report.setHrecdescripcio("Plan de Manejo: " + hospitalizacion.getHrhcplanmanejo());
					report.setHrencodigo(imp_remision_hospitalizacion);
					report.setHrenconsulta(consulta.getHcolnumero());
					report.setHredfecharegis(consulta.getHcodfecregistr());
					report.setHrentipoimpres(1);
					lstReporte.add(report);
				}

			}
		}

		if (consulta.getChresersangrs() != null && !consulta.getChresersangrs().isEmpty()) {
			for (Chresersangr reserva : consulta.getChresersangrs()) {
				if (reserva != null) {
					Chreporte report = new Chreporte();
					report = new Chreporte();

					report = new Chreporte();
					String tipoReserva;
					tipoReserva = null;
					if (reserva.getHrsetiporeserv() != null && reserva.getHrsetiporeserv().equals("A")) {
						tipoReserva = "AutodonaciNn";
					}
					if (reserva.getHrsetiporeserv() != null && reserva.getHrsetiporeserv().equals("H")) {
						tipoReserva = "Homologa";
					}
					report.setHrectipodescri("Reserva de Sangre");
					report.setHrecdescripcio("Tipo de Reserva: " + formatearCampo(tipoReserva));
					report.setHrecdescripcio2("Componente a Reservar: " + formatearCampo(reserva.getHrsecompreserv()));
					report.setHrecdescripcio3("Unidades: " + reserva.getHrsncantidadre());
					report.setHrencodigo(imp_reserva_sangre);
					report.setHrenconsulta(consulta.getHcolnumero());
					report.setHredfecharegis(consulta.getHcodfecregistr());
					report.setHrentipoimpres(5);
					lstReporte.add(report);

					report = new Chreporte();
					report.setHrectipodescri("Reserva de Sangre");
					report.setHrecdescripcio(
							"Otros Componentes Sanguineos: " + formatearCampo(reserva.getHrseotrcompsan()));
					if (reserva.getHrseotrcompsan() != null && reserva.getHrseotrcompsan().equals("S")) {
						report.setHrecdescripcio2("Cuales: " + formatearCampo(reserva.getHrsccuales()));
					}
					report.setHrecdescripcio3("Solicitud al Banco de Sangre: " + reserva.getHrscsolbancsan());
					report.setHrencodigo(imp_reserva_sangre);
					report.setHrentipoimpres(5);
					report.setHrenconsulta(consulta.getHcolnumero());
					report.setHredfecharegis(consulta.getHcodfecregistr());
					lstReporte.add(report);
				}
			}
		}

		if (consulta.getChcervaaplic() != null && !consulta.getChcervaaplic().isEmpty()) {
			for (Chcervaaplic aplicacion : consulta.getChcervaaplic()) {
				if (aplicacion != null) {

					Chreporte report = new Chreporte();
					report = new Chreporte();
					report.setHrectipodescri("VacunaciNn CNrvix");
					report.setHrecdescripcio("Fecha y hora de aplicaciNn: " + FECHA_VACUNACION);
					report.setHrecdescripcio2("Numero de Dosis: " + NUMERO_DOSIS);
					report.setHrencodigo(imp_vacunacion_cervix);
					report.setHrenconsulta(consulta.getHcolnumero());
					report.setHredfecharegis(consulta.getHcodfecregistr());
					report.setHrentipoimpres(6);
					lstReporte.add(report);

					report = new Chreporte();
					report.setHrectipodescri("VacunaciNn CNrvix");
					report.setHrecdescripcio("Observaciones: " + OBSERVACIONES_VACUNA);
					report.setHrencodigo(imp_vacunacion_cervix);
					report.setHrenconsulta(consulta.getHcolnumero());
					report.setHredfecharegis(consulta.getHcodfecregistr());
					report.setHrentipoimpres(1);
					lstReporte.add(report);

				}
			}
		}

		if (consulta.getChregcomenf() != null && !consulta.getChregcomenf().isEmpty()) {
			int contador = 0;
			for (Chregcomenf registroComplementario : consulta.getChregcomenf()) {
				if (registroComplementario != null) {
					contador++;
					Chreporte report = new Chreporte();
					report = new Chreporte();
					report.setHrectipodescri("Registros Complementarios Enfermeria");
					report.setHrecdescripcio("Registro " + contador + " :");
					report.setHrencodigo(imp_registro_complementario_enfermeria);
					report.setHrenconsulta(consulta.getHcolnumero());
					report.setHredfecharegis(consulta.getHcodfecregistr());
					report.setHrentipoimpres(1);
					lstReporte.add(report);

					report = new Chreporte();
					report.setHrectipodescri("Registros Complementarios Enfermeria");
					report.setHrecdescripcio(registroComplementario.gethrcecdescripc() + "  Usuario: "
							+ registroComplementario.gethrcecoperador());
					report.setHrencodigo(imp_registro_complementario_enfermeria);
					report.setHrenconsulta(consulta.getHcolnumero());
					report.setHredfecharegis(consulta.getHcodfecregistr());
					report.setHrentipoimpres(1);
					lstReporte.add(report);

				}
			}
		}
	}

	public void setDatoAntecedentesVacec(Chconsulta consulta) {
		if (consulta.getChantecvasec() != null && !consulta.getChantecvasec().isEmpty()) {

			Chreporte report = new Chreporte();

			if (HIJOS_BIOLOGICOS_PACIENTE != null && !HIJOS_BIOLOGICOS_PACIENTE.equals("")) {
				report = new Chreporte();
				report.setHrectipodescri("Antecedentes Vasectomia");
				report.setHrecdescripcio("Hijos Biologicos Paciente ");
				report.setHrecdescripcio2(formatearCampo(HIJOS_BIOLOGICOS_PACIENTE));
				report.setHrencodigo(imp_antecedentes_vasectomia);
				report.setHrentipoimpres(3);
				report.setHrenconsulta(consulta.getHcolnumero());
				report.setHredfecharegis(consulta.getHcodfecregistr());
				lstReporte.add(report);
			}

			if (HIJOS_BIOLOGICOS_PAREJA != null && !HIJOS_BIOLOGICOS_PAREJA.equals("")) {
				report = new Chreporte();
				report.setHrectipodescri("Antecedentes Vasectomia");
				report.setHrecdescripcio("Hijos Biologicos Pareja ");
				report.setHrecdescripcio2(formatearCampo(HIJOS_BIOLOGICOS_PAREJA));
				report.setHrencodigo(imp_antecedentes_vasectomia);
				report.setHrentipoimpres(3);
				report.setHrenconsulta(consulta.getHcolnumero());
				report.setHredfecharegis(consulta.getHcodfecregistr());
				lstReporte.add(report);
			}

			if (HIJOS_BIOLOGICOS_JUNTOS != null && !HIJOS_BIOLOGICOS_JUNTOS.equals("")) {
				report = new Chreporte();
				report.setHrectipodescri("Antecedentes Vasectomia");
				report.setHrecdescripcio("Hijos Biologicos Juntos");
				report.setHrecdescripcio2(formatearCampo(HIJOS_BIOLOGICOS_JUNTOS));
				report.setHrencodigo(imp_antecedentes_vasectomia);
				report.setHrentipoimpres(3);
				report.setHrenconsulta(consulta.getHcolnumero());
				report.setHredfecharegis(consulta.getHcodfecregistr());
				lstReporte.add(report);
			}

			if (METODOS_PLANIFICACION != null && !METODOS_PLANIFICACION.equals("")) {
				report = new Chreporte();
				report.setHrectipodescri("Antecedentes Vasectomia");
				report.setHrecdescripcio("Metodos PlanificaciNn ");
				report.setHrecdescripcio2(formatearCampo(METODOS_PLANIFICACION));
				report.setHrencodigo(imp_antecedentes_vasectomia);
				report.setHrentipoimpres(3);
				report.setHrenconsulta(consulta.getHcolnumero());
				report.setHredfecharegis(consulta.getHcodfecregistr());
				lstReporte.add(report);
			}
		}

	}

	private void datosMedicamento(Chconsulta consulta) {
		// MEDICAMENTOS
		List<Chmedicament> medicamentos = new ArrayList();

		if (consulta.getChmedicament() != null && !consulta.getChmedicament().isEmpty()) {
			for (Chmedicament medicamento : consulta.getChmedicament()) {
				medicamentos.add(medicamento);
			}
		} else {
			Chmedicament medAux;
			try {
				medAux = this.serviceLocator.getClinicoService()
						.getMedicamentoByConsultaAsociada(consulta.getHcolnumero());
				if (medAux != null) {
					medicamentos = this.serviceLocator.getClinicoService()
							.getMedicamentoByConsulta(medAux.getId().getHmelconsulta());
				}
			} catch (ModelException e) {
				e.printStackTrace();
			}
		}
		if (medicamentos != null && !medicamentos.isEmpty()) {
			for (Chmedicament medicamento : medicamentos) {
				if (medicamento != null) {

					if (medicamento.getHmentipohisto() != null
							&& medicamento.getHmentipohisto().equals(HISTORIA_ADMINISTRAR_MEDICAMENTO)) {
						Chreporte report = new Chreporte();

						if (null != medicamento.getHmelcregiacti()) {
							if (medicamento.getHmelcregiacti().equals("A")) {
								report = new Chreporte();
								report.setHrectipodescri("AdministraciNn/Entrega de Medicamentos");
								report.setHrecdescripcio("AdministraciNn de medicamentos:");
								report.setHrencodigo(imp_administrar_medicamento);
								report.setHrenconsulta(consulta.getHcolnumero());
								report.setHredfecharegis(consulta.getHcodfecregistr());
								report.setHrentipoimpres(6);
								lstReporte.add(report);
							} else if (medicamento.getHmelcregiacti().equals("D")) {
								report = new Chreporte();
								report.setHrectipodescri("AdministraciNn/Entrega de Medicamentos");
								report.setHrecdescripcio("Entrega Medicamento: " + medicamento.getHmecmedicament());
								report.setHrencodigo(imp_administrar_medicamento);
								report.setHrenconsulta(consulta.getHcolnumero());
								report.setHredfecharegis(consulta.getHcodfecregistr());
								report.setHrentipoimpres(6);
								lstReporte.add(report);
							}

							else if (medicamento.getHmelcregiacti().equals("E")) {
								report = new Chreporte();
								report.setHrectipodescri("AdministraciNn/Entrega de Medicamentos");
								report.setHrecdescripcio("Entrega Medicamento: " + medicamento.getHmecmedicament());
								report.setHrencodigo(imp_administrar_medicamento);
								report.setHrenconsulta(consulta.getHcolnumero());
								report.setHredfecharegis(consulta.getHcodfecregistr());
								report.setHrentipoimpres(6);
								lstReporte.add(report);
							}
						}

						if (null != medicamento.getHmelcregiacti()) {

							if (medicamento.getHmelcregiacti().equals("A")) {

								report = new Chreporte();
								report.setHrectipodescri("AdministraciNn/Entrega de Medicamentos /Vacuna");
								report.setHrecdescripcio("Medicamento: " + medicamento.getHmecmedicament());

								report.setHrecdescripcio2("Presentacion: "
										+ formatearCampoPresentacionVademecum(medicamento.getHmecpresentaci()));
								report.setHrencodigo(imp_administrar_medicamento);
								report.setHrenconsulta(consulta.getHcolnumero());
								report.setHredfecharegis(consulta.getHcodfecregistr());
								report.setHrentipoimpres(6);
								lstReporte.add(report);

								report = new Chreporte();
								report.setHrectipodescri("AdministraciNn/Entrega de Medicamentos");
								if (medicamento != null && medicamento.getHmecadosis() != null) {
									report.setHrecdescripcio("Dosis: " +

											formatearCampoDosis(medicamento.getHmecunidmedi()));
								} else {
									report.setHrecdescripcio("");

								}

								report.setHrecdescripcio2("Lote: " + medicamento.getHmeclotemedic());
								report.setHrencodigo(imp_administrar_medicamento);
								report.setHrenconsulta(consulta.getHcolnumero());
								report.setHredfecharegis(consulta.getHcodfecregistr());
								report.setHrentipoimpres(6);
								lstReporte.add(report);

								report = new Chreporte();
								report.setHrectipodescri("AdministraciNn/Entrega de Medicamentos");
								report.setHrecdescripcio(
										"Fecha Vencimiento: " + formatearCampo(medicamento.getHmedfechavenci()));

								report.setHrecdescripcio2("Via Administracion: "
										+ formatearCampoViaAdministracionMedicamento(medicamento.getHmecviadministr()));
								report.setHrencodigo(imp_administrar_medicamento);
								report.setHrenconsulta(consulta.getHcolnumero());
								report.setHredfecharegis(consulta.getHcodfecregistr());
								report.setHrentipoimpres(6);
								lstReporte.add(report);

								report = new Chreporte();
								report.setHrectipodescri("AdministraciNn/Entrega de Medicamentos");
								report.setHrecdescripcio("Sitio AplicaciNn: "
										+ formatearCampoSitioAplicacionMedicamento(medicamento.getHmecsitioaplic()));

								report.setHrecdescripcio2("");
								report.setHrencodigo(imp_administrar_medicamento);
								report.setHrenconsulta(consulta.getHcolnumero());
								report.setHredfecharegis(consulta.getHcodfecregistr());
								report.setHrentipoimpres(6);
								lstReporte.add(report);
								if (medicamento != null && medicamento.getHmelcgrusangu() != null) {

									report = new Chreporte();
									report.setHrectipodescri("AdministraciNn/Entrega de Medicamentos");
									report.setHrecdescripcio("Grupo Sanguineo: " + medicamento.getHmelcgrusangu());

									report.setHrecdescripcio2("");
									report.setHrencodigo(imp_administrar_medicamento);
									report.setHrenconsulta(consulta.getHcolnumero());
									report.setHredfecharegis(consulta.getHcodfecregistr());
									report.setHrentipoimpres(6);
									lstReporte.add(report);

								}

								if (medicamento != null && medicamento.getHmelcrh() != null) {

									report = new Chreporte();
									report.setHrectipodescri("AdministraciNn/Entrega de Medicamentos");
									report.setHrecdescripcio("RH: " + formatearCampoRH(medicamento.getHmelcrh()));

									report.setHrecdescripcio2("");
									report.setHrencodigo(imp_administrar_medicamento);
									report.setHrenconsulta(consulta.getHcolnumero());
									report.setHredfecharegis(consulta.getHcodfecregistr());
									report.setHrentipoimpres(6);
									lstReporte.add(report);
								}
							}
						}

						report = new Chreporte();
						report.setHrectipodescri("AdministraciNn/Entrega de Medicamentos");
						report.setHrecdescripcio(
								"Nota de Enfermeria: " + formatearCampo(medicamento.getHmecobservac()));

						report.setHrecdescripcio2("");
						report.setHrencodigo(imp_administrar_medicamento);
						report.setHrenconsulta(consulta.getHcolnumero());
						report.setHredfecharegis(consulta.getHcodfecregistr());
						report.setHrentipoimpres(1);
						lstReporte.add(report);
					} else if (medicamento.getHmentipohisto() != null
							&& medicamento.getHmentipohisto().equals(HISTORIA_VACUNACION)) {
						Chreporte report = new Chreporte();

						report = new Chreporte();
						report.setHrectipodescri("AdministraciNn/Entrega de Medicamentos/Vacuna");
						report.setHrecdescripcio("Vacuna " + medicamento.getHmecmedicament());

						if (medicamento.getHmecpresentaci() != null) {
							report.setHrecdescripcio2("Presentacion: " + medicamento.getHmecpresentaci());
						} else {
							report.setHrecdescripcio2("");
						}
						report.setHrencodigo(imp_administrar_medicamento);
						report.setHrenconsulta(consulta.getHcolnumero());
						report.setHredfecharegis(consulta.getHcodfecregistr());
						report.setHrentipoimpres(6);
						lstReporte.add(report);

						if (medicamento.getHmennumervacun() != null) {
							report = new Chreporte();
							report.setHrectipodescri("Vacunacion");
							report.setHrecdescripcio("Numero de Dosis: "
									+ formatearCampoDosisVacunacion(medicamento.getHmennumervacun()));

							report.setHrecdescripcio2("Lote: " + medicamento.getHmeclotemedic());
							report.setHrencodigo(imp_administrar_medicamento);
							report.setHrenconsulta(consulta.getHcolnumero());
							report.setHredfecharegis(consulta.getHcodfecregistr());
							report.setHrentipoimpres(6);
							lstReporte.add(report);
						}

						if (medicamento.getHmedfechavenci() != null) {
							report = new Chreporte();
							report.setHrectipodescri("Vacunacion");
							report.setHrecdescripcio(
									"Fecha Vencimiento: " + formatearCampo(medicamento.getHmedfechavenci()));

							report.setHrecdescripcio2("Via Administracion: "
									+ formatearCampoViaAdministracionMedicamento(medicamento.getHmecviadministr()));
							report.setHrencodigo(imp_administrar_medicamento);
							report.setHrenconsulta(consulta.getHcolnumero());
							report.setHredfecharegis(consulta.getHcodfecregistr());
							report.setHrentipoimpres(6);
							lstReporte.add(report);
						}

						if (medicamento.getHmecsitioaplic() != null) {
							report = new Chreporte();
							report.setHrectipodescri("Vacunacion");
							report.setHrecdescripcio("Sitio AplicaciNn: "
									+ formatearCampoSitioAplicacionMedicamento(medicamento.getHmecsitioaplic()));

							report.setHrecdescripcio2("");
							report.setHrencodigo(imp_administrar_medicamento);
							report.setHrenconsulta(consulta.getHcolnumero());
							report.setHredfecharegis(consulta.getHcodfecregistr());
							report.setHrentipoimpres(6);
							lstReporte.add(report);
						}

						if (medicamento.getHmelcgrusangu() != null) {
							report = new Chreporte();
							report.setHrectipodescri("Vacunacion");
							report.setHrecdescripcio("Grupo Sanguineo: " + medicamento.getHmelcgrusangu());

							report.setHrecdescripcio2("");
							report.setHrencodigo(imp_administrar_medicamento);
							report.setHrenconsulta(consulta.getHcolnumero());
							report.setHredfecharegis(consulta.getHcodfecregistr());
							report.setHrentipoimpres(6);
							lstReporte.add(report);
						}

						if (medicamento.getHmelcrh() != null) {
							report = new Chreporte();
							report.setHrectipodescri("Vacunacion");
							report.setHrecdescripcio("RH: " + formatearCampoRH(medicamento.getHmelcrh()));

							report.setHrecdescripcio2("");
							report.setHrencodigo(imp_administrar_medicamento);
							report.setHrenconsulta(consulta.getHcolnumero());
							report.setHredfecharegis(consulta.getHcodfecregistr());
							report.setHrentipoimpres(6);
							lstReporte.add(report);
						}

						report = new Chreporte();
						report.setHrectipodescri("Vacunacion");
						report.setHrecdescripcio(
								"Nota de Enfermeria: " + formatearCampo(medicamento.getHmecobservac()));

						report.setHrecdescripcio2("");
						report.setHrencodigo(imp_administrar_medicamento);
						report.setHrenconsulta(consulta.getHcolnumero());
						report.setHredfecharegis(consulta.getHcodfecregistr());
						report.setHrentipoimpres(1);
						lstReporte.add(report);
					}

				}
			}
		}
	}

	private void datosVacunacion(Chconsulta consulta) {
		// VACUNACION
		if (consulta.getChvacunacion() != null && !consulta.getChvacunacion().isEmpty()) {
			for (Chvacunacion vacunacion : consulta.getChvacunacion()) {
				if (vacunacion != null) {

					Chreporte report = new Chreporte();
					report = new Chreporte();
					report.setHrectipodescri("AplicaciNn Vacuna");
					report.setHrecdescripcio("Vacuna: " + vacunacion.getHvaccodigservi());

					report.setHrecdescripcio2(
							"Numero de Dosis: " + formatearCampoDosisVacunacion(vacunacion.getHvacnumervacun()));
					report.setHrencodigo(imp_aplicar_vacunacion);
					report.setHrenconsulta(consulta.getHcolnumero());
					report.setHredfecharegis(consulta.getHcodfecregistr());
					report.setHrentipoimpres(6);
					lstReporte.add(report);

					report = new Chreporte();
					report.setHrectipodescri("AplicaciNn Vacuna");
					report.setHrecdescripcio("Lote: " + vacunacion.getHvacnumerlote());

					report.setHrecdescripcio2(
							"Fecha de Vencimiento: " + formatearCampo(vacunacion.getHvadfechavenci()));
					report.setHrencodigo(imp_aplicar_vacunacion);
					report.setHrenconsulta(consulta.getHcolnumero());
					report.setHredfecharegis(consulta.getHcodfecregistr());
					report.setHrentipoimpres(6);
					lstReporte.add(report);

					report = new Chreporte();
					report.setHrectipodescri("AplicaciNn Vacuna");
					report.setHrecdescripcio("Via Administracion: "
							+ formatearCampoViaAdministracionMedicamento(vacunacion.getHvacviaadmin()));

					report.setHrecdescripcio2("Sitio de AplicaciNn : "
							+ formatearCampoSitioAplicacionMedicamento(vacunacion.getHvacsitioaplic()));
					report.setHrencodigo(imp_aplicar_vacunacion);
					report.setHrenconsulta(consulta.getHcolnumero());
					report.setHredfecharegis(consulta.getHcodfecregistr());
					report.setHrentipoimpres(6);
					lstReporte.add(report);

					report = new Chreporte();
					report.setHrectipodescri("AplicaciNn Vacuna");
					report.setHrecdescripcio("Ha presentado reacciones con anteriores vacunas?: "
							+ formatearCampo(vacunacion.getHvacpresereacc()));

					if (vacunacion.getHvacpresereacc() != null && vacunacion.getHvacpresereacc().equals("S")) {
						report.setHrecdescripcio2("Cuales? : " + vacunacion.getHvaccualreacc());
					} else {
						report.setHrecdescripcio2("");
					}

					report.setHrencodigo(imp_aplicar_vacunacion);
					report.setHrenconsulta(consulta.getHcolnumero());
					report.setHredfecharegis(consulta.getHcodfecregistr());
					report.setHrentipoimpres(6);
					lstReporte.add(report);

					report = new Chreporte();
					report.setHrectipodescri("AplicaciNn Vacuna");
					report.setHrecdescripcio("Presento complicacion en la actual aplicaciNn?    : "
							+ formatearCampo(vacunacion.getHvacpresecompl()));

					if (vacunacion.getHvacpresecompl() != null && vacunacion.getHvacpresecompl().equals("S")) {
						report.setHrecdescripcio2("Cuales? : " + vacunacion.getHvaccualcompl());
					} else {
						report.setHrecdescripcio2("");
					}

					report.setHrencodigo(imp_aplicar_vacunacion);
					report.setHrenconsulta(consulta.getHcolnumero());
					report.setHredfecharegis(consulta.getHcodfecregistr());
					report.setHrentipoimpres(6);
					lstReporte.add(report);
				}
			}
		}
	}

	private String obtenerCertificadoAsistencia(Chconsulta consulta, Chcertmedico certificado) {
		Chusuario usuario = consulta.getHcolusuario();
		String nombre1 = (usuario.getHuscprimernomb() != null) ? usuario.getHuscprimernomb() : " ";
		String nombre2 = (usuario.getHuscsegundnomb() != null) ? usuario.getHuscsegundnomb() : " ";
		String ape1 = (usuario.getHuscprimerapel() != null) ? usuario.getHuscprimerapel() : " ";
		String ape2 = (usuario.getHuscsegundapel() != null) ? usuario.getHuscsegundapel() : " ";

		StringBuffer msj = new StringBuffer();
		msj.append(" A quiNn corresponda ");
		msj.append("\n");
		msj.append(" El suscrito mNdico certifica: ");
		msj.append("\n");
		msj.append(" Que ").append(nombre1).append(" ").append(nombre2).append(" ").append(ape1).append(" ")
				.append(ape2).append(" ");
		msj.append(" Identificado con  ").append(usuario.getHusetipoiden()).append(" ")
				.append(usuario.getHusanumeiden());
		msj.append(" Se encontraba hoy ").append(formatearCampo(certificado.getHcmdfechareg()));
		msj.append(" a las  ").append(formatearCampoHoraSimple(certificado.getHcmdfechareg()));
		msj.append("  en consulta medica");
		if (certificado.getHcmcnombreacom() != null && certificado.getHcmetipoideaco() != null
				&& certificado.getHcmanumideacom() != null) {
			msj.append(" , Se encontraba acompaNado en consulta por ").append(certificado.getHcmcnombreacom());
			msj.append("  identificado con ").append(certificado.getHcmetipoideaco()).append(" ")
					.append(certificado.getHcmanumideacom());

		}
		return msj.toString();
	}

	private String formatearCampoNumeroDosis(Integer numero) {

		String dosis = "";
		if (numero != null) {
			if (numero.equals(1)) {
				dosis = "Primera Dosis";
			} else if (numero.equals(2)) {
				dosis = "Segunda Dosis";
			} else if (numero.equals(3)) {
				dosis = "Tercera Dosis";
			} else if (numero.equals(4)) {
				dosis = "Cuarta Dosis";
			} else if (numero.equals(5)) {
				dosis = "Quinta Dosis";
			} else if (numero.equals(6)) {
				dosis = "Refuerzo 1";
			} else if (numero.equals(7)) {
				dosis = "Refuerzo 2";
			} else if (numero.equals(8)) {
				dosis = "Dosis Unica";
			}
		}

		return dosis;

	}

	private void imprimirFormulaMedica(Chformulamed formula, Chconsulta consulta) {

		Chreporte report = new Chreporte();
		if (formula.getHfonduracion() != null && !formula.getHfocduracion().equals("")) {

			report = new Chreporte();
			report.setHrectipodescri("PrescripciNn MNdica");
			report.setHrecdescripcio("Nombre Generico del Medicamento: " + obtenerNombreMedicamento(formula));
			report.setHrencodigo(imp_prescripcion_medica);
			report.setHrentipoimpres(1);
			report.setHrenconsulta(consulta.getHcolnumero());
			report.setHredfecharegis(consulta.getHcodfecregistr());
			lstReporte.add(report);

			report = new Chreporte();
			report.setHrectipodescri("PrescripciNn MNdica");
			report.setHrecdescripcio("Dosis : " + obtenerNombreTratamiento(formula));
			report.setHrencodigo(imp_prescripcion_medica);
			report.setHrentipoimpres(1);
			report.setHrenconsulta(consulta.getHcolnumero());
			report.setHredfecharegis(consulta.getHcodfecregistr());
			lstReporte.add(report);

			report = new Chreporte();
			Integer cantidad = 0;
			String cantidadLetras = "";
			report.setHrectipodescri("PrescripciNn MNdica");
			report.setHrecdescripcio(
					"Via de administraciNn : " + formatearCampoViaAdministracion(formula.getHfocviadministr()));
			cantidad = calcularCantidad(formula.getHfocadosis(), formula.getHfonfrecuenc(), formula.getHfonduracion(),
					formula.getHfocfrecuenc(), formula.getHfocduracion());
			ConverterTextoNumero texto = new ConverterTextoNumero();
			if (cantidad != null) {
				cantidadLetras = texto.getStringOfNumber(cantidad);
			}

			report.setHrecdescripcio2("Cantidad Requerida : " + cantidad + " " + cantidadLetras);
			report.setHrencodigo(imp_prescripcion_medica);
			report.setHrentipoimpres(6);
			report.setHrenconsulta(consulta.getHcolnumero());
			report.setHredfecharegis(consulta.getHcodfecregistr());
			lstReporte.add(report);

			report = new Chreporte();
			report.setHrectipodescri("PrescripciNn MNdica");
			report.setHrecdescripcio(
					"Contraindicaciones/Observaciones : " + formatearCampo(formula.getHfoccontraindi()));
			report.setHrencodigo(imp_prescripcion_medica);
			report.setHrentipoimpres(1);
			report.setHrenconsulta(consulta.getHcolnumero());
			report.setHredfecharegis(consulta.getHcodfecregistr());
			lstReporte.add(report);

		} else {

			report = new Chreporte();
			report.setHrectipodescri("PrescripciNn MNdica");
			report.setHrecdescripcio("Nombre Generico del Medicamento ConcentraciNn/ forma farmacNutica : "
					+ obtenerNombreMedicamento(formula));
			report.setHrencodigo(imp_prescripcion_medica);
			report.setHrentipoimpres(1);
			report.setHrenconsulta(consulta.getHcolnumero());
			report.setHredfecharegis(consulta.getHcodfecregistr());
			lstReporte.add(report);

			report = new Chreporte();
			report.setHrectipodescri("PrescripciNn MNdica");
			report.setHrecdescripcio("Dosis, frecuencia de administraciNn y duraciNn del tratamiento : "
					+ formatearCampo(formula.getHfoctratramien()));
			report.setHrencodigo(imp_prescripcion_medica);
			report.setHrentipoimpres(1);
			report.setHrenconsulta(consulta.getHcolnumero());
			report.setHredfecharegis(consulta.getHcodfecregistr());
			lstReporte.add(report);

			report = new Chreporte();
			report.setHrectipodescri("PrescripciNn MNdica");
			report.setHrecdescripcio("Via de administraciNn : " + formatearCampo(formula.getHfocviadministr()));
			report.setHrecdescripcio2("Cantidad Requerida : " + formatearCampo(formula.getHfocadosis()));
			report.setHrencodigo(imp_prescripcion_medica);
			report.setHrentipoimpres(6);
			report.setHrenconsulta(consulta.getHcolnumero());
			report.setHredfecharegis(consulta.getHcodfecregistr());
			lstReporte.add(report);

			report = new Chreporte();
			report.setHrectipodescri("PrescripciNn MNdica");
			report.setHrecdescripcio(
					"Contraindicaciones/Observaciones : " + formatearCampo(formula.getHfoccontraindi()));
			report.setHrencodigo(imp_prescripcion_medica);
			report.setHrentipoimpres(1);
			report.setHrenconsulta(consulta.getHcolnumero());
			report.setHredfecharegis(consulta.getHcodfecregistr());
			lstReporte.add(report);
		}
	}

	public void cargarDatosMotivo(Chconsulta consulta) {
		String s = "";
		Chreporte report = new Chreporte();
		if (MANIOBRAS != null && !MANIOBRAS.equals("")) {
			s = (new StringBuilder()).append("Maniobras previas para intentar interrumpir el actual embarazo : ")
					.append(formatearCampo(MANIOBRAS)).toString();
			report.setHrecdescripcio(s);
			report.setHrectipodescri("Motivo de Consulta");
			report.setHrentipoimpres(1);
			report.setHrencodigo(imp_motivo_consulta);
			report.setHrenconsulta(consulta.getHcolnumero());
			report.setHredfecharegis(consulta.getHcodfecregistr());
			lstReporte.add(report);
		}

		s = "";
		report = new Chreporte();
		if (OBSMANIOBRAS != null && !OBSMANIOBRAS.equals("")) {
			s = (new StringBuilder()).append("Observacion de maniobras previas : ").append(formatearCampo(OBSMANIOBRAS))
					.toString();
			report.setHrecdescripcio(s);

			report.setHrectipodescri("Motivo de Consulta");
			report.setHrentipoimpres(1);
			report.setHrencodigo(imp_motivo_consulta);
			report.setHrenconsulta(consulta.getHcolnumero());
			report.setHredfecharegis(consulta.getHcodfecregistr());
			lstReporte.add(report);
		}

		s = "";
		report = new Chreporte();
		if (INTERRUPCION != null && !INTERRUPCION.equals("")) {
			s = (new StringBuilder()).append("Ha realizado solicitud de interrupciNn del embarazo previamente : ")
					.append(formatearCampo(INTERRUPCION)).toString();
			report.setHrecdescripcio(s);

			report.setHrectipodescri("Motivo de Consulta");
			report.setHrentipoimpres(1);
			report.setHrencodigo(imp_motivo_consulta);
			report.setHrenconsulta(consulta.getHcolnumero());
			report.setHredfecharegis(consulta.getHcodfecregistr());
			lstReporte.add(report);
		}

		s = "";
		report = new Chreporte();
		if (OBSINTERRUPCION != null && !OBSINTERRUPCION.equals("")) {
			s = (new StringBuilder()).append("ObservaciNn de interrupciNn : ").append(formatearCampo(OBSINTERRUPCION))
					.toString();
			report.setHrecdescripcio(s);

			report.setHrectipodescri("Motivo de Consulta");
			report.setHrentipoimpres(1);
			report.setHrencodigo(imp_motivo_consulta);
			report.setHrenconsulta(consulta.getHcolnumero());
			report.setHredfecharegis(consulta.getHcodfecregistr());
			lstReporte.add(report);
		}
	}

	public void imprimirEstadoPsicoemocional(Chconsulta consulta) {

		if (consulta.getChestadpsico() != null && !consulta.getChestadpsico().isEmpty()
				&& consulta.getChestadpsico() != null && !consulta.getChestadpsico().isEmpty()) {
			Chestadpsico estado = null;
			Iterator it = consulta.getChestadpsico().iterator();
			if (it.hasNext())
				estado = (Chestadpsico) it.next();
			if (estado != null) {
				Chreporte report = new Chreporte();
				report.setHrecdescripcio((new StringBuilder()).append("Area Afectiva:    ")
						.append(AREA_AFECTIVA_INTERRUPCION).toString());
				report.setHrectipodescri("Estado Psicoemocional");
				report.setHrencodigo(imp_estado_psicoemocional);
				report.setHrentipoimpres(Integer.valueOf(1));
				report.setHrenconsulta(consulta.getHcolnumero());
				report.setHredfecharegis(consulta.getHcodfecregistr());
				lstReporte.add(report);
				report = new Chreporte();
				report.setHrecdescripcio((new StringBuilder()).append("Area Somatica:    ")
						.append(AREA_SOMATICA_INTERRUPCION).toString());
				if (OTRO_SOMATICO != null && !OTRO_SOMATICO.equals("")) {
					report.setHrecdescripcio2(
							(new StringBuilder()).append("Cual?:    ").append(OTRO_SOMATICO).toString());
				} else {
					report.setHrecdescripcio2("");
				}
				report.setHrectipodescri("Estado Psicoemocional");
				report.setHrencodigo(imp_estado_psicoemocional);
				report.setHrentipoimpres(Integer.valueOf(2));
				report.setHrenconsulta(consulta.getHcolnumero());
				report.setHredfecharegis(consulta.getHcodfecregistr());
				lstReporte.add(report);
				report = new Chreporte();
				report.setHrecdescripcio((new StringBuilder()).append("Area Relacional:  ")
						.append(AREA_RELACIONAL_INTERRUPCION).toString());

				if (CUAL_FOBIA != null && !CUAL_FOBIA.equals("")) {
					report.setHrecdescripcio2(
							(new StringBuilder()).append("CNal fobia?:  ").append(CUAL_FOBIA).toString());
				} else {
					report.setHrecdescripcio2("");
				}

				if (OTRO_RELACIONAL != null && !OTRO_RELACIONAL.equals("")) {
					report.setHrecdescripcio3(
							(new StringBuilder()).append("CNal(Otro) ?:  ").append(OTRO_RELACIONAL).toString());
				} else {
					report.setHrecdescripcio3("");
				}

				report.setHrectipodescri("Estado Psicoemocional");
				report.setHrencodigo(imp_estado_psicoemocional);
				report.setHrentipoimpres(Integer.valueOf(5));
				report.setHrenconsulta(consulta.getHcolnumero());
				report.setHredfecharegis(consulta.getHcodfecregistr());
				lstReporte.add(report);

				report = new Chreporte();
				report.setHrecdescripcio((new StringBuilder()).append("Area Cognitiva:   ")
						.append(AREA_COGNITIVA_INTERRUPCION).toString());
				if (OTRO_COGNITIVO != null && !OTRO_COGNITIVO.equals(""))
					report.setHrecdescripcio2(
							(new StringBuilder()).append("Cual?:   ").append(OTRO_COGNITIVO).toString());
				else
					report.setHrecdescripcio2("");
				report.setHrectipodescri("Estado Psicoemocional");
				report.setHrencodigo(imp_estado_psicoemocional);
				report.setHrentipoimpres(Integer.valueOf(2));
				report.setHrenconsulta(consulta.getHcolnumero());
				report.setHredfecharegis(consulta.getHcodfecregistr());
				lstReporte.add(report);

				report = new Chreporte();
				report.setHrecdescripcio((new StringBuilder()).append("Observaciones:    ")
						.append(OBSERVACIONES_INTERRUPCION).toString());
				report.setHrectipodescri("Estado Psicoemocional");
				report.setHrencodigo(imp_estado_psicoemocional);
				report.setHrentipoimpres(Integer.valueOf(1));
				report.setHrenconsulta(consulta.getHcolnumero());
				report.setHredfecharegis(consulta.getHcodfecregistr());

				if (OBSERVACIONES_INTERRUPCION != null && !OBSERVACIONES_INTERRUPCION.equals("")) {
					lstReporte.add(report);
				}

			}
		}
	}

	public void imprimirViolencia(Chconsulta consulta) {

		if (consulta.getChviolencias() != null && !consulta.getChviolencias().isEmpty()) {
			Chreporte report = new Chreporte();

			if (consulta.getChviolencias() != null && !consulta.getChviolencias().isEmpty()) {

				Chviolencia violencia = null;
				Iterator it = consulta.getChviolencias().iterator();
				if (it.hasNext()) {
					violencia = (Chviolencia) it.next();
				}

				String s = "";

				s = "Ha sufrido de violencia:  " + formatearCampo(HA_SUFRIDO_VIOLENCIA);
				report = new Chreporte();
				report.setHrecdescripcio(s);
				report.setHrectipodescri("Encuesta Violencia");
				report.setHrencodigo(imp_encuesta_violencia);
				report.setHrentipoimpres(1);
				report.setHrenconsulta(consulta.getHcolnumero());
				report.setHredfecharegis(consulta.getHcodfecregistr());
				lstReporte.add(report);

				if (HA_SUFRIDO_VIOLENCIA != null && HA_SUFRIDO_VIOLENCIA.equals("S")) {
					VIOLENCIA_FISICA = formatearCampo(VIOLENCIA_FISICA);
					VIOLENCIA_PSICOLOGICA = formatearCampo(VIOLENCIA_PSICOLOGICA);
					VIOLENCIA_SEXUAL = formatearCampo(VIOLENCIA_SEXUAL);
					RIESGO_PERSONA_MALTRATA = formatearCampo(RIESGO_PERSONA_MALTRATA);
					ASESORIA_HABLAR = formatearCampo(ASESORIA_HABLAR);
					OBSERVACIONES_VIOLENCIA = formatearCampo(OBSERVACIONES_VIOLENCIA);

					if (violencia.getHvieviofisica() != null) {
						report = new Chreporte();
						report.setHrecdescripcio("Fisica:  " + formatearCampo(violencia.getHvieviofisica()));

						if (violencia.getHvicfisiquien() != null) {
							report.setHrecdescripcio2("Por quien? : " + formatearCampo(violencia.getHvicfisiquien()));
						} else {
							report.setHrecdescripcio2("");
						}

						if (violencia.getHvintiemfisi() != null) {
							report.setHrecdescripcio3("NTiempo de ocurrencia del evento?\n: "
									+ formatearCampoTiempoOcurrencia(violencia.getHvintiemfisi()));
						} else {
							report.setHrecdescripcio3("");
						}

						report.setHrectipodescri("Encuesta Violencia");
						report.setHrencodigo(imp_encuesta_violencia);
						report.setHrentipoimpres(4);
						report.setHrenconsulta(consulta.getHcolnumero());
						report.setHredfecharegis(consulta.getHcodfecregistr());
						lstReporte.add(report);
					}

					if (violencia.getHvieviopsicol() != null) {
						report = new Chreporte();
						report.setHrecdescripcio("Psicologica:  " + formatearCampo(violencia.getHvieviopsicol()));

						if (violencia.getHvicpsicquien() != null) {
							report.setHrecdescripcio2("Por quien? : " + formatearCampo(violencia.getHvicpsicquien()));
						} else {
							report.setHrecdescripcio2("");
						}

						if (violencia.getHvintiempsic() != null) {
							report.setHrecdescripcio3("NTiempo de ocurrencia del evento?\n: "
									+ formatearCampoTiempoOcurrencia(violencia.getHvintiempsic()));
						} else {
							report.setHrecdescripcio3("");
						}

						report.setHrectipodescri("Encuesta Violencia");
						report.setHrencodigo(imp_encuesta_violencia);
						report.setHrentipoimpres(4);
						report.setHrenconsulta(consulta.getHcolnumero());
						report.setHredfecharegis(consulta.getHcodfecregistr());
						lstReporte.add(report);
					}

					if (violencia.getHvieviosexual() != null) {
						report = new Chreporte();
						report.setHrecdescripcio("Sexual:  " + formatearCampo(violencia.getHvieviosexual()));

						if (violencia.getHvicsexuquien() != null) {
							report.setHrecdescripcio2("Por quien? : " + formatearCampo(violencia.getHvicsexuquien()));
						} else {
							report.setHrecdescripcio2(" ");
						}

						if (violencia.getHvintiemsexu() != null) {
							report.setHrecdescripcio3("NTiempo de ocurrencia del evento?\n: "
									+ formatearCampoTiempoOcurrencia(violencia.getHvintiemsexu()));
						} else {
							report.setHrecdescripcio3("");
						}

						report.setHrectipodescri("Encuesta Violencia");
						report.setHrencodigo(imp_encuesta_violencia);
						report.setHrentipoimpres(4);
						report.setHrenconsulta(consulta.getHcolnumero());
						report.setHredfecharegis(consulta.getHcodfecregistr());
						lstReporte.add(report);
					}

					if (violencia.getHvievioeconom() != null) {
						report = new Chreporte();
						report.setHrecdescripcio("EconNmica:  " + formatearCampo(violencia.getHvievioeconom()));

						if (violencia.getHviceconquien() != null) {
							report.setHrecdescripcio2("Por quien? : " + formatearCampo(violencia.getHviceconquien()));
						} else {
							report.setHrecdescripcio2("");
						}
						if (violencia.getHvintiemecon() != null) {
							report.setHrecdescripcio3("NTiempo de ocurrencia del evento?\n: "
									+ formatearCampoTiempoOcurrencia(violencia.getHvintiemecon()));
						} else {
							report.setHrecdescripcio3("");
						}

						report.setHrectipodescri("Encuesta Violencia");
						report.setHrencodigo(imp_encuesta_violencia);
						report.setHrentipoimpres(4);
						report.setHrenconsulta(consulta.getHcolnumero());
						report.setHredfecharegis(consulta.getHcodfecregistr());
						lstReporte.add(report);
					}

					if (violencia.getHvieviocoerci() != null) {
						report = new Chreporte();
						report.setHrecdescripcio(
								"CoerciNn reproductiva :  " + formatearCampo(violencia.getHvieviocoerci()));
						if (violencia.getHviccoerquien() != null) {
							report.setHrecdescripcio2("Por quien? : " + formatearCampo(violencia.getHviccoerquien()));
						} else {
							report.setHrecdescripcio2("");
						}

						if (violencia.getHvintiemcoer() != null) {
							report.setHrecdescripcio3("NTiempo de ocurrencia del evento?\n: "
									+ formatearCampoTiempoOcurrencia(violencia.getHvintiemcoer()));
						} else {
							report.setHrecdescripcio3("");
						}

						report.setHrectipodescri("Encuesta Violencia");
						report.setHrencodigo(imp_encuesta_violencia);
						report.setHrentipoimpres(4);
						report.setHrenconsulta(consulta.getHcolnumero());
						report.setHredfecharegis(consulta.getHcodfecregistr());
						lstReporte.add(report);

					}

					if (violencia.getHvicamenpare() != null) {
						s = "Factores de Riesgo ";

						report = new Chreporte();
						report.setHrecdescripcio(s);
						report.setHrectipodescri("Encuesta Violencia");
						report.setHrencodigo(imp_encuesta_violencia);
						report.setHrentipoimpres(1);
						report.setHrenconsulta(consulta.getHcolnumero());
						report.setHredfecharegis(consulta.getHcodfecregistr());
						lstReporte.add(report);

						s = "NAlguna vez su pareja ha amenazado con hacerse daNo y hacerle daNo si usted lo deja?  	 "
								+ formatearCampo(violencia.getHvicamenpare());
						report = new Chreporte();
						report.setHrecdescripcio(s);
						report.setHrectipodescri("Encuesta Violencia");
						report.setHrencodigo(imp_encuesta_violencia);
						report.setHrentipoimpres(1);
						report.setHrenconsulta(consulta.getHcolnumero());
						report.setHredfecharegis(consulta.getHcodfecregistr());
						lstReporte.add(report);

						s = "NAlguna vez usted ha pensado o intentado hacerse daNo?	"
								+ formatearCampo(violencia.getHvicintedano());
						report = new Chreporte();
						report.setHrecdescripcio(s);
						report.setHrectipodescri("Encuesta Violencia");
						report.setHrencodigo(imp_encuesta_violencia);
						report.setHrentipoimpres(1);
						report.setHrenconsulta(consulta.getHcolnumero());
						report.setHredfecharegis(consulta.getHcodfecregistr());
						lstReporte.add(report);

						s = "NEl agresor/a es parte de la familia inmediata?	 "
								+ formatearCampo(violencia.getHvicagrefami());
						report = new Chreporte();
						report.setHrecdescripcio(s);
						report.setHrectipodescri("Encuesta Violencia");
						report.setHrencodigo(imp_encuesta_violencia);
						report.setHrentipoimpres(1);
						report.setHrenconsulta(consulta.getHcolnumero());
						report.setHredfecharegis(consulta.getHcodfecregistr());
						lstReporte.add(report);

						s = "NEl agresor/a convive en la misma casa?	        "
								+ formatearCampo(violencia.getHvicagrecasa());
						report = new Chreporte();
						report.setHrecdescripcio(s);
						report.setHrectipodescri("Encuesta Violencia");
						report.setHrencodigo(imp_encuesta_violencia);
						report.setHrentipoimpres(1);
						report.setHrenconsulta(consulta.getHcolnumero());
						report.setHredfecharegis(consulta.getHcodfecregistr());
						lstReporte.add(report);

						s = "NLa red familiar conoce la situaciNn?	                "
								+ formatearCampo(violencia.getHvicfamicono());
						report = new Chreporte();
						report.setHrecdescripcio(s);
						report.setHrectipodescri("Encuesta Violencia");
						report.setHrencodigo(imp_encuesta_violencia);
						report.setHrentipoimpres(1);
						report.setHrenconsulta(consulta.getHcolnumero());
						report.setHredfecharegis(consulta.getHcodfecregistr());
						lstReporte.add(report);
						if (violencia.getHvichumeinam() != null) {
							s = "NDURANTE EL ULTIMO ANO, ha sido humillada, menospreciada, insultada o amenazada por su pareja?     "
									+ formatearCampo(violencia.getHvichumeinam());
							report = new Chreporte();
							report.setHrecdescripcio(s);
							report.setHrectipodescri("Encuesta Violencia");
							report.setHrencodigo(imp_encuesta_violencia);
							report.setHrentipoimpres(1);
							report.setHrenconsulta(consulta.getHcolnumero());
							report.setHredfecharegis(consulta.getHcodfecregistr());
							lstReporte.add(report);
						}
						if (violencia.getHvicgobopalaul() != null) {
							s = "NDURANTE EL NLTIMO ANO, fue golpeada, bofeteada, pateada, o lastimada fNsicamente de otra manera?     "
									+ formatearCampo(violencia.getHvicgobopalaul());
							report = new Chreporte();
							report.setHrecdescripcio(s);
							report.setHrectipodescri("Encuesta Violencia");
							report.setHrencodigo(imp_encuesta_violencia);
							report.setHrentipoimpres(1);
							report.setHrenconsulta(consulta.getHcolnumero());
							report.setHredfecharegis(consulta.getHcodfecregistr());
							lstReporte.add(report);
						}
						if (violencia.getHvicgobopalage() != null) {
							s = "NDESDE QUE ESTN EN GESTACINN, ha sido golpeada, bofeteada, pateada, o lastimada fNsicamente de alguna manera?     "
									+ formatearCampo(violencia.getHvicgobopalage());
							report = new Chreporte();
							report.setHrecdescripcio(s);
							report.setHrectipodescri("Encuesta Violencia");
							report.setHrencodigo(imp_encuesta_violencia);
							report.setHrentipoimpres(1);
							report.setHrenconsulta(consulta.getHcolnumero());
							report.setHredfecharegis(consulta.getHcodfecregistr());
							lstReporte.add(report);
						}
						if (violencia.getHvicforrelsex() != null) {
							s = "NDURANTE EL NLTIMO ANO, fue forzada a tener relaciones sexuales?     "
									+ formatearCampo(violencia.getHvicforrelsex());
							report = new Chreporte();
							report.setHrecdescripcio(s);
							report.setHrectipodescri("Encuesta Violencia");
							report.setHrencodigo(imp_encuesta_violencia);
							report.setHrentipoimpres(1);
							report.setHrenconsulta(consulta.getHcolnumero());
							report.setHredfecharegis(consulta.getHcodfecregistr());
							lstReporte.add(report);
						}

					} else {
						if (RIESGO_PERSONA_MALTRATA != null && !RIESGO_PERSONA_MALTRATA.equals("")) {
							s = "NSe Siente en riesgo por la persona que lo maltrata :  "
									+ formatearCampo(RIESGO_PERSONA_MALTRATA);
							report = new Chreporte();
							report.setHrecdescripcio(s);
							report.setHrectipodescri("Encuesta Violencia");
							report.setHrencodigo(imp_encuesta_violencia);
							report.setHrentipoimpres(1);
							report.setHrenconsulta(consulta.getHcolnumero());
							report.setHredfecharegis(consulta.getHcodfecregistr());
							lstReporte.add(report);

							if (violencia.getHvicrsgxquien() != null) {
								s = "NPor Quien :  " + formatearCampo(violencia.getHvicrsgxquien());
								report = new Chreporte();
								report.setHrecdescripcio(s);
								report.setHrectipodescri("Encuesta Violencia");
								report.setHrencodigo(imp_encuesta_violencia);
								report.setHrentipoimpres(1);
								report.setHrenconsulta(consulta.getHcolnumero());
								report.setHredfecharegis(consulta.getHcodfecregistr());
								lstReporte.add(report);

							}

							s = "NDesea asesorNa para hablar mas sobre el asunto  :  "
									+ formatearCampo(ASESORIA_HABLAR);
							report = new Chreporte();
							report.setHrecdescripcio(s);
							report.setHrectipodescri("Encuesta Violencia");
							report.setHrencodigo(imp_encuesta_violencia);
							report.setHrentipoimpres(1);
							report.setHrenconsulta(consulta.getHcolnumero());
							report.setHredfecharegis(consulta.getHcodfecregistr());
							lstReporte.add(report);
						}
					}

					if (violencia.getHvictienrein() != null) {
						report = new Chreporte();
						report.setHrecdescripcio(
								"Se realiza remision Interna	:  " + formatearCampo(violencia.getHvictienrein()));

						if (violencia.getHvictienrein().equals("S")) {
							report.setHrecdescripcio2("Tipo de Remision Interna	 "
									+ formatearCampoTipoViolencia(violencia.getHvicremiinte()));
						} else {
							report.setHrecdescripcio2(" ");
						}

						report.setHrecdescripcio3("");

						report.setHrectipodescri("Encuesta Violencia");
						report.setHrencodigo(imp_encuesta_violencia);
						report.setHrentipoimpres(4);
						report.setHrenconsulta(consulta.getHcolnumero());
						report.setHredfecharegis(consulta.getHcodfecregistr());
						lstReporte.add(report);
					}

					if (violencia.getHvictienreex() != null) {
						report = new Chreporte();
						report.setHrecdescripcio(
								"Se realiza remision Externa       :  " + formatearCampo(violencia.getHvictienreex()));

						if (violencia.getHvictienreex().equals("S")) {
							report.setHrecdescripcio2("Tipo de Remision Externa      "
									+ formatearCampoTipoViolencia(violencia.getHvicremiexte()));
						} else {
							report.setHrecdescripcio2(" ");
						}

						if (violencia.getHvicremiexte() != null && violencia.getHvicremiexte().equals("0")) {
							report.setHrecdescripcio3("Cual ? " + violencia.getHvilcualremisi());
						} else {
							report.setHrecdescripcio3("");
						}

						report.setHrectipodescri("Encuesta Violencia");
						report.setHrencodigo(imp_encuesta_violencia);
						report.setHrentipoimpres(4);
						report.setHrenconsulta(consulta.getHcolnumero());
						report.setHredfecharegis(consulta.getHcodfecregistr());
						lstReporte.add(report);
					}

					s = "Observaciones  :  " + formatearCampo(OBSERVACIONES_VIOLENCIA);
					report = new Chreporte();
					report.setHrecdescripcio(s);
					report.setHrectipodescri("Encuesta Violencia");
					report.setHrencodigo(imp_encuesta_violencia);
					report.setHrentipoimpres(1);
					report.setHrenconsulta(consulta.getHcolnumero());
					report.setHredfecharegis(consulta.getHcodfecregistr());
					lstReporte.add(report);

				}

			}

		}
	}

	public void imprimirIdentificaRiesgos(Chconsulta consulta) {
		if (consulta.getChidentiriesgo() != null && !consulta.getChidentiriesgo().isEmpty()) {
			Chreporte report = new Chreporte();

			if (consulta.getChidentiriesgo() != null && !consulta.getChidentiriesgo().isEmpty()) {

				Chidentiriesgo identiriesgo = null;
				Iterator it = consulta.getChidentiriesgo().iterator();
				if (it.hasNext()) {
					identiriesgo = (Chidentiriesgo) it.next();
				}

				String s = "";

				if (DISCRASIA_SANGUNNEA != null) {
					s = "Discrasia sanguNnea  :  " + formatearCampo(DISCRASIA_SANGUNNEA);
					report = new Chreporte();
					report.setHrecdescripcio(s);
					report.setHrectipodescri("IdentificaciNn de Riesgos");
					report.setHrencodigo(imp_identificacion_Riesgos);
					report.setHrentipoimpres(1);
					report.setHrenconsulta(consulta.getHcolnumero());
					report.setHredfecharegis(consulta.getHcodfecregistr());
					lstReporte.add(report);
				}

				/*
				 * if (MANEJO_CON_ANTICOAGULANTES != null) { s =
				 * "En manejo con anticoagulantes que no se puedan suspender o revertir :  " +
				 * formatearCampo(MANEJO_CON_ANTICOAGULANTES); report = new Chreporte();
				 * report.setHrecdescripcio(s);
				 * report.setHrectipodescri("IdentificaciNn de Riesgos");
				 * report.setHrencodigo(imp_identificacion_Riesgos);
				 * report.setHrentipoimpres(1);
				 * report.setHrenconsulta(consulta.getHcolnumero());
				 * report.setHredfecharegis(consulta.getHcodfecregistr());
				 * lstReporte.add(report); }
				 */

				if (PATOLOGIAS_DESCOMPENSADAS != null) {
					s = "PatologNas descompensadas (incluyendo hipertensiNn arterial inducida por el embarazo) y que sea catalogada como ASA III. :  "
							+ formatearCampo(PATOLOGIAS_DESCOMPENSADAS);
					report = new Chreporte();
					report.setHrecdescripcio(s);
					report.setHrectipodescri("IdentificaciNn de Riesgos");
					report.setHrencodigo(imp_identificacion_Riesgos);
					report.setHrentipoimpres(1);
					report.setHrenconsulta(consulta.getHcolnumero());
					report.setHredfecharegis(consulta.getHcodfecregistr());
					lstReporte.add(report);
				}

				/*
				 * if (PACIENTE_CON_ACRETISMO != null) { s =
				 * "Paciente con acretismo placentario, confirmada en embarazo mayor a 12 semanas.	:  "
				 * + formatearCampo(PACIENTE_CON_ACRETISMO); report = new Chreporte();
				 * report.setHrecdescripcio(s);
				 * report.setHrectipodescri("IdentificaciNn de Riesgos");
				 * report.setHrencodigo(imp_identificacion_Riesgos);
				 * report.setHrentipoimpres(1);
				 * report.setHrenconsulta(consulta.getHcolnumero());
				 * report.setHredfecharegis(consulta.getHcodfecregistr());
				 * lstReporte.add(report); }
				 */

				/*
				 * if (SOSPECHA_DE_CORIOAMNIONITIS != null) { s =
				 * "Sospecha de corioamnionitis     :  " +
				 * formatearCampo(SOSPECHA_DE_CORIOAMNIONITIS); report = new Chreporte();
				 * report.setHrecdescripcio(s);
				 * report.setHrectipodescri("IdentificaciNn de Riesgos");
				 * report.setHrencodigo(imp_identificacion_Riesgos);
				 * report.setHrentipoimpres(1);
				 * report.setHrenconsulta(consulta.getHcolnumero());
				 * report.setHredfecharegis(consulta.getHcodfecregistr());
				 * lstReporte.add(report); }
				 */

				if (PACIENTE_CON_UNA_CESAREA != null) {
					s = "Paciente con una (1) cesNrea anterior y antecedente de infecciNn postoperatoria  :  "
							+ formatearCampo(PACIENTE_CON_UNA_CESAREA);
					report = new Chreporte();
					report.setHrecdescripcio(s);
					report.setHrectipodescri("IdentificaciNn de Riesgos");
					report.setHrencodigo(imp_identificacion_Riesgos);
					report.setHrentipoimpres(1);
					report.setHrenconsulta(consulta.getHcolnumero());
					report.setHredfecharegis(consulta.getHcodfecregistr());
					lstReporte.add(report);
				}

				if (PACIENTE_CON_DOS_CESAREAS != null) {
					s = "Paciente con dos (2) o mNs cesNreas     :  " + formatearCampo(PACIENTE_CON_DOS_CESAREAS);
					report = new Chreporte();
					report.setHrecdescripcio(s);
					report.setHrectipodescri("IdentificaciNn de Riesgos");
					report.setHrencodigo(imp_identificacion_Riesgos);
					report.setHrentipoimpres(1);
					report.setHrenconsulta(consulta.getHcolnumero());
					report.setHredfecharegis(consulta.getHcodfecregistr());
					lstReporte.add(report);
				}

				if (PACIENTE_CON_ALTERACIONES_ANATOMICAS != null) {
					s = "Paciente con alteraciones anatNmicas (itsmocele, entre otras) confirmada por ecografNa.  :  "
							+ formatearCampo(PACIENTE_CON_ALTERACIONES_ANATOMICAS);
					report = new Chreporte();
					report.setHrecdescripcio(s);
					report.setHrectipodescri("IdentificaciNn de Riesgos");
					report.setHrencodigo(imp_identificacion_Riesgos);
					report.setHrentipoimpres(1);
					report.setHrenconsulta(consulta.getHcolnumero());
					report.setHredfecharegis(consulta.getHcodfecregistr());
					lstReporte.add(report);
				}

				/*
				 * if (PRESENCIA_DE_UNA_MALFORMACION != null) { s =
				 * "Presencia de una malformaciNn mNlleriana confirmada por ecografNa     :  " +
				 * formatearCampo(PRESENCIA_DE_UNA_MALFORMACION); report = new Chreporte();
				 * report.setHrecdescripcio(s);
				 * report.setHrectipodescri("IdentificaciNn de Riesgos");
				 * report.setHrencodigo(imp_identificacion_Riesgos);
				 * report.setHrentipoimpres(1);
				 * report.setHrenconsulta(consulta.getHcolnumero());
				 * report.setHredfecharegis(consulta.getHcodfecregistr());
				 * lstReporte.add(report); }
				 * 
				 * if (PLACENTA_PREVIA != null) { s = "Placenta previa mayor a 12 semanas  :  "
				 * + formatearCampo(PLACENTA_PREVIA); report = new Chreporte();
				 * report.setHrecdescripcio(s);
				 * report.setHrectipodescri("IdentificaciNn de Riesgos");
				 * report.setHrencodigo(imp_identificacion_Riesgos);
				 * report.setHrentipoimpres(1);
				 * report.setHrenconsulta(consulta.getHcolnumero());
				 * report.setHredfecharegis(consulta.getHcodfecregistr());
				 * lstReporte.add(report); }
				 * 
				 * if (PACIENTE_CON_ANEMIA != null) { s =
				 * "Paciente con anemia actual grave (hemoglobina menor a 8 mg/dl)         :  "
				 * + formatearCampo(PACIENTE_CON_ANEMIA); report = new Chreporte();
				 * report.setHrecdescripcio(s);
				 * report.setHrectipodescri("IdentificaciNn de Riesgos");
				 * report.setHrencodigo(imp_identificacion_Riesgos);
				 * report.setHrentipoimpres(1);
				 * report.setHrenconsulta(consulta.getHcolnumero());
				 * report.setHredfecharegis(consulta.getHcodfecregistr());
				 * lstReporte.add(report); }
				 */

				if (RIESGO_HEMORRAGIA != null) {
					s = "Existe riesgo de hemorragia  :  " + formatearCampo(RIESGO_HEMORRAGIA) + "   "
							+ formatearCampo(RIESGO_HEMORRAGIA_VAL);
					report = new Chreporte();
					report.setHrecdescripcio(s);
					report.setHrectipodescri("IdentificaciNn de Riesgos");
					report.setHrencodigo(imp_identificacion_Riesgos);
					report.setHrentipoimpres(1);
					report.setHrenconsulta(consulta.getHcolnumero());
					report.setHredfecharegis(consulta.getHcodfecregistr());
					lstReporte.add(report);
				}
				if (RIESGO_HEMORRAGIA_OBS != null) {
					s = "DescripciNn riesgo de hemorragia :  " + formatearCampo(RIESGO_HEMORRAGIA_OBS);
					report = new Chreporte();
					report.setHrecdescripcio(s);
					report.setHrectipodescri("IdentificaciNn de Riesgos");
					report.setHrencodigo(imp_identificacion_Riesgos);
					report.setHrentipoimpres(1);
					report.setHrenconsulta(consulta.getHcolnumero());
					report.setHredfecharegis(consulta.getHcodfecregistr());
					lstReporte.add(report);
				}

				if (PATOLOGIA_CRONICA != null) {
					s = "Existen patologNas crNnicas  :  " + formatearCampo(PATOLOGIA_CRONICA);
					report = new Chreporte();
					report.setHrecdescripcio(s);
					report.setHrectipodescri("IdentificaciNn de Riesgos");
					report.setHrencodigo(imp_identificacion_Riesgos);
					report.setHrentipoimpres(1);
					report.setHrenconsulta(consulta.getHcolnumero());
					report.setHredfecharegis(consulta.getHcodfecregistr());
					lstReporte.add(report);
				}

				if (INFECCION_ACTUAL != null) {
					s = "InfecciNn actual  :  " + formatearCampo(INFECCION_ACTUAL) + "   "
							+ formatearCampo(INFECCION_ACTUAL_VAL);
					report = new Chreporte();
					report.setHrecdescripcio(s);
					report.setHrectipodescri("IdentificaciNn de Riesgos");
					report.setHrencodigo(imp_identificacion_Riesgos);
					report.setHrentipoimpres(1);
					report.setHrenconsulta(consulta.getHcolnumero());
					report.setHredfecharegis(consulta.getHcodfecregistr());
					lstReporte.add(report);
				}
				if (INFECCION_ACTUAL_OBS != null) {
					s = "DescripciNn infecciNn actual :  " + formatearCampo(INFECCION_ACTUAL_OBS);
					report = new Chreporte();
					report.setHrecdescripcio(s);
					report.setHrectipodescri("IdentificaciNn de Riesgos");
					report.setHrencodigo(imp_identificacion_Riesgos);
					report.setHrentipoimpres(1);
					report.setHrenconsulta(consulta.getHcolnumero());
					report.setHredfecharegis(consulta.getHcodfecregistr());
					lstReporte.add(report);
				}

				if (MALFORMACION_MULLERIANA != null) {
					s = "Antecedente de malformaciNn mulleriana  :  " + formatearCampo(MALFORMACION_MULLERIANA);
					report = new Chreporte();
					report.setHrecdescripcio(s);
					report.setHrectipodescri("IdentificaciNn de Riesgos");
					report.setHrencodigo(imp_identificacion_Riesgos);
					report.setHrentipoimpres(1);
					report.setHrenconsulta(consulta.getHcolnumero());
					report.setHredfecharegis(consulta.getHcodfecregistr());
					lstReporte.add(report);
				}
				if (MALFORMACION_MULLERIANA_OBS != null) {
					s = "DescripciNn antecedente de malformaciNn mulleriana :  "
							+ formatearCampo(MALFORMACION_MULLERIANA_OBS);
					report = new Chreporte();
					report.setHrecdescripcio(s);
					report.setHrectipodescri("IdentificaciNn de Riesgos");
					report.setHrencodigo(imp_identificacion_Riesgos);
					report.setHrentipoimpres(1);
					report.setHrenconsulta(consulta.getHcolnumero());
					report.setHredfecharegis(consulta.getHcodfecregistr());
					lstReporte.add(report);
				}

				if (SEROLOGIA_VIH != null) {
					s = "SerologNa Reciente:  " + formatearCampo(SEROLOGIA_VIH);
					report = new Chreporte();
					report.setHrecdescripcio(s);
					report.setHrectipodescri("IdentificaciNn de Riesgos");
					report.setHrencodigo(imp_identificacion_Riesgos);
					report.setHrentipoimpres(1);
					report.setHrenconsulta(consulta.getHcolnumero());
					report.setHredfecharegis(consulta.getHcodfecregistr());
					lstReporte.add(report);
				}
				if (SEROLOGIA_VIH_OBS != null) {
					s = "DescripciNn SerologNa Reciente:  " + formatearCampo(SEROLOGIA_VIH_OBS);
					report = new Chreporte();
					report.setHrecdescripcio(s);
					report.setHrectipodescri("IdentificaciNn de Riesgos");
					report.setHrencodigo(imp_identificacion_Riesgos);
					report.setHrentipoimpres(1);
					report.setHrenconsulta(consulta.getHcolnumero());
					report.setHredfecharegis(consulta.getHcodfecregistr());
					lstReporte.add(report);
				}

				if (VIH_RECIENTE != null) {
					s = " VIH Recientes  :  " + formatearCampo(VIH_RECIENTE);
					report = new Chreporte();
					report.setHrecdescripcio(s);
					report.setHrectipodescri("IdentificaciNn de Riesgos");
					report.setHrencodigo(imp_identificacion_Riesgos);
					report.setHrentipoimpres(1);
					report.setHrenconsulta(consulta.getHcolnumero());
					report.setHredfecharegis(consulta.getHcodfecregistr());
					lstReporte.add(report);
				}
				if (VIH_RECIENTE_OBS != null) {
					s = "DescripciNn VIH Recientes :  " + formatearCampo(VIH_RECIENTE_OBS);
					report = new Chreporte();
					report.setHrecdescripcio(s);
					report.setHrectipodescri("IdentificaciNn de Riesgos");
					report.setHrencodigo(imp_identificacion_Riesgos);
					report.setHrentipoimpres(1);
					report.setHrenconsulta(consulta.getHcolnumero());
					report.setHredfecharegis(consulta.getHcodfecregistr());
					lstReporte.add(report);
				}

				if (SOSPECHA_ANEMIA != null) {
					s = "Sospecha clNnica de anemia  :  " + formatearCampo(SOSPECHA_ANEMIA);
					report = new Chreporte();
					report.setHrecdescripcio(s);
					report.setHrectipodescri("IdentificaciNn de Riesgos");
					report.setHrencodigo(imp_identificacion_Riesgos);
					report.setHrentipoimpres(1);
					report.setHrenconsulta(consulta.getHcolnumero());
					report.setHredfecharegis(consulta.getHcodfecregistr());
					lstReporte.add(report);
				}

				if (identiriesgo.getHidecmaansure() != null) {
					s = "Manejo con anticoagulantes que no se puedan suspender o revertir  :  "
							+ formatearCampo(identiriesgo.getHidecmaansure());
					report = new Chreporte();
					report.setHrecdescripcio(s);
					report.setHrectipodescri("IdentificaciNn de Riesgos");
					report.setHrencodigo(imp_identificacion_Riesgos);
					report.setHrentipoimpres(1);
					report.setHrenconsulta(consulta.getHcolnumero());
					report.setHredfecharegis(consulta.getHcodfecregistr());
					lstReporte.add(report);

				}

				if (identiriesgo.getHidecantpatdes() != null) {
					s = "Antecedentes de patologNas descompensadas (incluyendo hipertensiNn arterial inducida por el embarazo) y que sea catalogada como ASA III.  :  "
							+ formatearCampo(identiriesgo.getHidecantpatdes());
					report = new Chreporte();
					report.setHrecdescripcio(s);
					report.setHrectipodescri("IdentificaciNn de Riesgos");
					report.setHrencodigo(imp_identificacion_Riesgos);
					report.setHrentipoimpres(1);
					report.setHrenconsulta(consulta.getHcolnumero());
					report.setHredfecharegis(consulta.getHcodfecregistr());
					lstReporte.add(report);

				}

				if (identiriesgo.getHidecacrplacon() != null) {
					s = "Acretismo placentario, confirmada en embarazo mayor a 12 semanas.  :  "
							+ formatearCampo(identiriesgo.getHidecacrplacon());
					report = new Chreporte();
					report.setHrecdescripcio(s);
					report.setHrectipodescri("IdentificaciNn de Riesgos");
					report.setHrencodigo(imp_identificacion_Riesgos);
					report.setHrentipoimpres(1);
					report.setHrenconsulta(consulta.getHcolnumero());
					report.setHredfecharegis(consulta.getHcodfecregistr());
					lstReporte.add(report);

				}

				if (identiriesgo.getHidecsospcori() != null) {
					s = "Sospecha de corioamnionitis.  :  " + formatearCampo(identiriesgo.getHidecsospcori());
					report = new Chreporte();
					report.setHrecdescripcio(s);
					report.setHrectipodescri("IdentificaciNn de Riesgos");
					report.setHrencodigo(imp_identificacion_Riesgos);
					report.setHrentipoimpres(1);
					report.setHrenconsulta(consulta.getHcolnumero());
					report.setHredfecharegis(consulta.getHcodfecregistr());
					lstReporte.add(report);

				}

				if (identiriesgo.getHidecunceananin() != null) {
					s = "Una (1) cesNrea anterior y antecedente de infecciNn postoperatoria.  :  "
							+ formatearCampo(identiriesgo.getHidecunceananin());
					report = new Chreporte();
					report.setHrecdescripcio(s);
					report.setHrectipodescri("IdentificaciNn de Riesgos");
					report.setHrencodigo(imp_identificacion_Riesgos);
					report.setHrentipoimpres(1);
					report.setHrenconsulta(consulta.getHcolnumero());
					report.setHredfecharegis(consulta.getHcodfecregistr());
					lstReporte.add(report);

				}

				if (identiriesgo.getHidecdosmasces() != null) {
					s = "Dos (2) o mNs cesNreas  :  " + formatearCampo(identiriesgo.getHidecdosmasces());
					report = new Chreporte();
					report.setHrecdescripcio(s);
					report.setHrectipodescri("IdentificaciNn de Riesgos");
					report.setHrencodigo(imp_identificacion_Riesgos);
					report.setHrentipoimpres(1);
					report.setHrenconsulta(consulta.getHcolnumero());
					report.setHredfecharegis(consulta.getHcodfecregistr());
					lstReporte.add(report);

				}

				if (identiriesgo.getHidecalancoec() != null) {
					s = "Alteraciones anatNmicas (itsmocele, entre otras) confirmada por ecografNa.  :  "
							+ formatearCampo(identiriesgo.getHidecalancoec());
					report = new Chreporte();
					report.setHrecdescripcio(s);
					report.setHrectipodescri("IdentificaciNn de Riesgos");
					report.setHrencodigo(imp_identificacion_Riesgos);
					report.setHrentipoimpres(1);
					report.setHrenconsulta(consulta.getHcolnumero());
					report.setHredfecharegis(consulta.getHcodfecregistr());
					lstReporte.add(report);

				}

				if (identiriesgo.getHidecgemamucoec() != null) {
					s = "Una gestaciNn con malformaciNn mNlleriana confirmada por ecografNa.  :  "
							+ formatearCampo(identiriesgo.getHidecgemamucoec());
					report = new Chreporte();
					report.setHrecdescripcio(s);
					report.setHrectipodescri("IdentificaciNn de Riesgos");
					report.setHrencodigo(imp_identificacion_Riesgos);
					report.setHrentipoimpres(1);
					report.setHrenconsulta(consulta.getHcolnumero());
					report.setHredfecharegis(consulta.getHcodfecregistr());
					lstReporte.add(report);

				}

				if (identiriesgo.getHidecplapremay() != null) {
					s = "Placenta previa mayor a 12 semanas.  :  " + formatearCampo(identiriesgo.getHidecplapremay());
					report = new Chreporte();
					report.setHrecdescripcio(s);
					report.setHrectipodescri("IdentificaciNn de Riesgos");
					report.setHrencodigo(imp_identificacion_Riesgos);
					report.setHrentipoimpres(1);
					report.setHrenconsulta(consulta.getHcolnumero());
					report.setHredfecharegis(consulta.getHcodfecregistr());
					lstReporte.add(report);

				}

				if (identiriesgo.getHidecanemiagrave() != null) {
					s = "Anemia grave (hemoglobina menor a 8 mg/dl).  :  "
							+ formatearCampo(identiriesgo.getHidecplapremay());
					report = new Chreporte();
					report.setHrecdescripcio(s);
					report.setHrectipodescri("IdentificaciNn de Riesgos");
					report.setHrencodigo(imp_identificacion_Riesgos);
					report.setHrentipoimpres(1);
					report.setHrenconsulta(consulta.getHcolnumero());
					report.setHredfecharegis(consulta.getHcodfecregistr());
					lstReporte.add(report);

				}

			}
		}
	}

	public void imprimirAntecedentesGinecologicos(Chconsulta consulta) {

		if (consulta.getChanteginecos() != null && !consulta.getChanteginecos().isEmpty()) {

			Chantegineco antecedente = null;
			Iterator it = consulta.getChanteginecos().iterator();
			if (it.hasNext()) {
				antecedente = (Chantegineco) it.next();
			}

			if (antecedente != null) {
				Chreporte report = new Chreporte();

				report = new Chreporte();
				report.setHrecdescripcio("Gestaciones:  " + formatearCampo(GESTACIONES));
				report.setHrecdescripcio2("Partos:  " + formatearCampo(PARTOS));
				report.setHrecdescripcio3("Abortos:  " + formatearCampo(ABORTOS));
				report.setHrecdescripcio4("Cesareas:  " + formatearCampo(CESAREAS));
				report.setHrectipodescri("Antecedentes Ginecologicos");
				report.setHrentipoimpres(4);
				report.setHrencodigo(imp_antecedentes_ginecologicos);
				report.setHrenconsulta(consulta.getHcolnumero());
				report.setHredfecharegis(consulta.getHcodfecregistr());
				lstReporte.add(report);

				report = new Chreporte();
				report.setHrecdescripcio("Hijos Vivos:  " + formatearCampo(HIJOS_VIVOS));
				report.setHrecdescripcio2("Ectopicos: " + formatearCampo(HIJOS_ECTOPICOS));
				report.setHrecdescripcio3("Hijos Muertos: " + formatearCampo(HIJOS_MUERTOS));
				report.setHrecdescripcio4("Mortinatos: " + MORTINATOS);
				report.setHrectipodescri("Antecedentes Ginecologicos");
				report.setHrencodigo(imp_antecedentes_ginecologicos);
				report.setHrentipoimpres(4);
				report.setHrenconsulta(consulta.getHcolnumero());
				report.setHredfecharegis(consulta.getHcodfecregistr());
				lstReporte.add(report);

				if (HIJOS_NACIDOS_VIVOS != null) {
					report = new Chreporte();
					report.setHrecdescripcio("Hijos Nacidos Vivos:  " + formatearCampo(HIJOS_NACIDOS_VIVOS));
					report.setHrecdescripcio2("");
					report.setHrecdescripcio3("");
					report.setHrecdescripcio4("");
					report.setHrectipodescri("Antecedentes Ginecologicos");
					report.setHrencodigo(imp_antecedentes_ginecologicos);
					report.setHrentipoimpres(4);
					report.setHrenconsulta(consulta.getHcolnumero());
					report.setHredfecharegis(consulta.getHcodfecregistr());
					lstReporte.add(report);

				}

				report = new Chreporte();

				report.setHrecdescripcio("Tipo Ciclo: " + formatearCampo(TIPO_CICLO));

				if (!TIPO_CICLO.equals("Irregular")) {
					if (FRECUENCIA_CICLO != null) {
						String string = FRECUENCIA_CICLO;
						String[] parts = string.split("-");
						if (parts.length > 2) {
							String part1 = parts[0];
							String part2 = parts[1];

							if (part1 == null && part2 == null) {
								FRECUENCIA_CICLO = "";
							} else if (part1 != null && part2 == null) {
								FRECUENCIA_CICLO = formatearCampo(part1);
							} else if (part1 == null && part2 != null) {
								FRECUENCIA_CICLO = formatearCampo(part2);
							} else if (part1 != null && part2 != null) {
								FRECUENCIA_CICLO = formatearCampo(part1) + "-" + formatearCampo(part2);
							}
						}

						report.setHrecdescripcio2("Frecuencia: " + formatearCampo(FRECUENCIA_CICLO));
					} else {
						if (DURACION_CICLO != null) {
							String string = DURACION_CICLO;
							String[] parts = string.split("-");
							if (parts.length > 2) {
								String part1 = parts[0];
								String part2 = parts[1];

								if (part1 == null && part2 == null) {
									DURACION_CICLO = "";
								} else if (part1 != null && part2.equals(" null")) {
									DURACION_CICLO = formatearCampo(part1);
								} else if (part1 == null && !part2.equals(" null")) {
									DURACION_CICLO = formatearCampo(part2);
								} else if (part1 != null && !part2.equals(" null")) {
									DURACION_CICLO = formatearCampo(part1) + "-" + formatearCampo(part2);
								}
							}
						}
						report.setHrecdescripcio2("DuraciNn:  " + formatearCampo(DURACION_CICLO));
					}

				}
				if (DURACION_CICLO != null) {
					String string = DURACION_CICLO;
					String[] parts = string.split("-");
					if (parts.length > 2) {
						String part1 = parts[0];
						String part2 = parts[1];

						if (part1 == null && part2 == null) {
							DURACION_CICLO = "";
						} else if (part1 != null && part2.equals(" null")) {
							DURACION_CICLO = part1;
						} else if (part1 == null && !part2.equals(" null")) {
							DURACION_CICLO = part2;
						} else if (part1 != null && !part2.equals(" null")) {
							DURACION_CICLO = part1 + "-" + part2;
						}
					}

					report.setHrecdescripcio3("DuraciNn:  " + formatearCampo(DURACION_CICLO));
				}

				report.setHrectipodescri("Antecedentes Ginecologicos");
				report.setHrencodigo(imp_antecedentes_ginecologicos);
				report.setHrentipoimpres(4);
				report.setHrenconsulta(consulta.getHcolnumero());
				report.setHredfecharegis(consulta.getHcodfecregistr());
				lstReporte.add(report);

				report = new Chreporte();
				report.setHrecdescripcio("Menarquia:  " + formatearCampo(MENARQUIA));
				if (EDAD_PRIMERA_RELACION != null && EDAD_PRIMERA_RELACION.intValue() > 0) {
					report.setHrecdescripcio2("Edad primera relaciNn : " + formatearCampo(EDAD_PRIMERA_RELACION));
				} else {
					report.setHrecdescripcio2("");
				}
				report.setHrecdescripcio3("");
				report.setHrecdescripcio4("");
				report.setHrectipodescri("Antecedentes Ginecologicos");
				report.setHrencodigo(imp_antecedentes_ginecologicos);
				report.setHrentipoimpres(4);
				report.setHrenconsulta(consulta.getHcolnumero());
				report.setHredfecharegis(consulta.getHcodfecregistr());
				lstReporte.add(report);

				report = new Chreporte();
				if (antecedente.getHagcconoceufm() != null && !antecedente.getHagcconoceufm().equals("")) {
					report = new Chreporte();
					report.setHrecdescripcio("NConoce la fecha de la Nltima menstruaciNn?:  "
							+ formatearCampo(antecedente.getHagcconoceufm()));
					report.setHrecdescripcio3("");
					report.setHrecdescripcio4("");
					report.setHrectipodescri("Antecedentes Ginecologicos");
					report.setHrencodigo(imp_antecedentes_ginecologicos);
					report.setHrentipoimpres(1);
					report.setHrenconsulta(consulta.getHcolnumero());
					report.setHredfecharegis(consulta.getHcodfecregistr());
					lstReporte.add(report);

				}

				report = new Chreporte();
				if (FUR != null && !FUR.equals("")) {
					report.setHrecdescripcio("FUR normal :  " + formatearCampo(FUR));
				}
				report.setHrecdescripcio3("");
				report.setHrecdescripcio4("");
				report.setHrectipodescri("Antecedentes Ginecologicos");
				report.setHrencodigo(imp_antecedentes_ginecologicos);
				report.setHrentipoimpres(4);
				report.setHrenconsulta(consulta.getHcolnumero());
				report.setHredfecharegis(consulta.getHcodfecregistr());
				lstReporte.add(report);

				report = new Chreporte();
				if (FUP != null && !FUP.equals("")) {
					report.setHrecdescripcio("FUP N Aborto : " + formatearCampo(FUP));
				}

				report.setHrecdescripcio3("");
				report.setHrecdescripcio4("");
				report.setHrectipodescri("Antecedentes Ginecologicos");
				report.setHrencodigo(imp_antecedentes_ginecologicos);
				report.setHrentipoimpres(4);
				report.setHrenconsulta(consulta.getHcolnumero());
				report.setHredfecharegis(consulta.getHcodfecregistr());
				lstReporte.add(report);

				report = new Chreporte();
				if (FUC != null && !FUC.equals("")) {
					report.setHrecdescripcio("F.U.Citologia : " + formatearCampo(FUC));
				}
				if (ULTIMA_CITOLOGIA != null && !ULTIMA_CITOLOGIA.equals("")) {
					report.setHrecdescripcio("F.U.Citologia : " + formatearCampo(ULTIMA_CITOLOGIA));
				}

				report.setHrecdescripcio2("");
				if (antecedente.getHagcresulcitol() != null && !antecedente.getHagcresulcitol().equals("")) {
					report.setHrecdescripcio2(
							"Resultado citologia: " + obtenerResultadoCitologia(antecedente.getHagcresulcitol()));
				}
				report.setHrecdescripcio3("");
				if (antecedente.getHagcotroresul() != null) {
					report.setHrecdescripcio3("Cual? " + antecedente.getHagcotroresul());
				}

				report.setHrecdescripcio4("");
				report.setHrectipodescri("Antecedentes Ginecologicos");
				report.setHrencodigo(imp_antecedentes_ginecologicos);
				report.setHrentipoimpres(4);
				report.setHrenconsulta(consulta.getHcolnumero());
				report.setHredfecharegis(consulta.getHcodfecregistr());
				lstReporte.add(report);

				if (antecedente.getHagcmetodoplan() != null) {
					report = new Chreporte();
					String metodo = "";

					try {
						metodo = serviceLocator.getClinicoService()
								.getDescripcionMetodo(antecedente.getHagcmetodoplan());
					} catch (ModelException e) {
						e.printStackTrace();
					}
					if (antecedente.getHagcmetodoplan().equals("0")) {
						metodo = "OTRO: " + antecedente.getHagcotrometodo();
					}

					report.setHrecdescripcio("MNtodo PlanificaciNn:  " + formatearCampo(metodo));
					report.setHrecdescripcio4("");
					report.setHrectipodescri("Antecedentes Ginecologicos");
					report.setHrencodigo(imp_antecedentes_ginecologicos);
					report.setHrentipoimpres(1);
					report.setHrenconsulta(consulta.getHcolnumero());
					report.setHredfecharegis(consulta.getHcodfecregistr());
					lstReporte.add(report);

					if (antecedente.getHagdfeultiapl() != null) {
						report = new Chreporte();
						report.setHrecdescripcio(
								"Fecha de la Nltima aplicaciNn:  " + formatearCampo(antecedente.getHagdfeultiapl()));
						report.setHrecdescripcio4("");
						report.setHrectipodescri("Antecedentes Ginecologicos");
						report.setHrencodigo(imp_antecedentes_ginecologicos);
						report.setHrentipoimpres(1);
						report.setHrenconsulta(consulta.getHcolnumero());
						report.setHredfecharegis(consulta.getHcodfecregistr());
						lstReporte.add(report);
					}
				}

				if (antecedente.getHagclactaexclu() != null && !antecedente.getHagclactaexclu().equals("")) {
					report = new Chreporte();
					report.setHrecdescripcio(
							"Lactancia exclusiva actual?:  " + formatearCampo(antecedente.getHagclactaexclu()));
					report.setHrectipodescri("Antecedentes Ginecologicos");
					report.setHrencodigo(imp_antecedentes_ginecologicos);
					report.setHrentipoimpres(1);
					report.setHrenconsulta(consulta.getHcolnumero());
					report.setHredfecharegis(consulta.getHcodfecregistr());
					lstReporte.add(report);

				}

				if (antecedente.getHagcrelacsexua() != null && !antecedente.getHagcrelacsexua().equals("")) {
					report = new Chreporte();
					report.setHrecdescripcio("Ha tenido relaciones sexuales en los Nltimos 15 dNas?:  "
							+ formatearCampo(antecedente.getHagcrelacsexua()));
					report.setHrectipodescri("Antecedentes Ginecologicos");
					report.setHrencodigo(imp_antecedentes_ginecologicos);
					report.setHrentipoimpres(1);
					report.setHrenconsulta(consulta.getHcolnumero());
					report.setHredfecharegis(consulta.getHcodfecregistr());
					lstReporte.add(report);

				}

				if (antecedente.getHagcmetodanter() != null && !antecedente.getHagcmetodanter().equals("")) {
					report = new Chreporte();
					report.setHrecdescripcio("Ha usado algNn mNtodo de planificaciNn familiar con anterioridad ?:  "
							+ formatearCampo(antecedente.getHagcmetodanter()));
					report.setHrectipodescri("Antecedentes Ginecologicos");
					report.setHrencodigo(imp_antecedentes_ginecologicos);
					report.setHrentipoimpres(1);
					report.setHrenconsulta(consulta.getHcolnumero());
					report.setHredfecharegis(consulta.getHcodfecregistr());
					lstReporte.add(report);

				}

				if (antecedente.getHagcplanemba() != null && !antecedente.getHagcplanemba().equals("")) {
					report = new Chreporte();
					report.setHrecdescripcio("Planea embarazo en el lapso de este prNximo aNo?:  "
							+ formatearCampo(antecedente.getHagcplanemba()));
					report.setHrectipodescri("Antecedentes Ginecologicos");
					report.setHrencodigo(imp_antecedentes_ginecologicos);
					report.setHrentipoimpres(1);
					report.setHrenconsulta(consulta.getHcolnumero());
					report.setHredfecharegis(consulta.getHcodfecregistr());
					lstReporte.add(report);

				}

				if (antecedente.getHagcobservacio() != null) {
					report = new Chreporte();
					report.setHrecdescripcio("Observaciones:  " + formatearCampo(antecedente.getHagcobservacio()));
					report.setHrectipodescri("Antecedentes Ginecologicos");
					report.setHrencodigo(imp_antecedentes_ginecologicos);
					report.setHrentipoimpres(1);
					report.setHrenconsulta(consulta.getHcolnumero());
					report.setHredfecharegis(consulta.getHcodfecregistr());
					lstReporte.add(report);

				}

				if (antecedente.getHagcembplan() != null) {
					report = new Chreporte();
					report.setHrecdescripcio(
							"Embarazo actual planeado:  " + formatearCampo(antecedente.getHagcembplan()));
					report.setHrectipodescri("Antecedentes Ginecologicos");
					report.setHrencodigo(imp_antecedentes_ginecologicos);
					report.setHrentipoimpres(1);
					report.setHrenconsulta(consulta.getHcolnumero());
					report.setHredfecharegis(consulta.getHcodfecregistr());
					lstReporte.add(report);

				}

				if (antecedente.getHagnnumembmulti() != null) {
					report = new Chreporte();
					report.setHrecdescripcio("Embarazos mNltiples:  " + antecedente.getHagnnumembmulti());
					report.setHrectipodescri("Antecedentes Ginecologicos");
					report.setHrencodigo(imp_antecedentes_ginecologicos);
					report.setHrentipoimpres(1);
					report.setHrenconsulta(consulta.getHcolnumero());
					report.setHredfecharegis(consulta.getHcodfecregistr());
					lstReporte.add(report);

				}

				if (antecedente.getHagnabortoprevio() != null) {
					report = new Chreporte();
					report.setHrecdescripcio("NNmero de Abortos Previos:  " + antecedente.getHagnabortoprevio());
					report.setHrectipodescri("Antecedentes Ginecologicos");
					report.setHrencodigo(imp_antecedentes_ginecologicos);
					report.setHrentipoimpres(1);
					report.setHrenconsulta(consulta.getHcolnumero());
					report.setHredfecharegis(consulta.getHcodfecregistr());
					lstReporte.add(report);

					if (antecedente.getHagnabortoprevio().intValue() > 0) {

						report = new Chreporte();
						report.setHrecdescripcio(
								"NNmero de abortos espontNneos:  " + antecedente.getHagnabortesponta());
						report.setHrectipodescri("Antecedentes Ginecologicos");
						report.setHrencodigo(imp_antecedentes_ginecologicos);
						report.setHrentipoimpres(1);
						report.setHrenconsulta(consulta.getHcolnumero());
						report.setHredfecharegis(consulta.getHcodfecregistr());
						lstReporte.add(report);

						report = new Chreporte();
						report.setHrecdescripcio("NNmero de abortos inducidos:  " + antecedente.getHagnabortinduc());
						report.setHrectipodescri("Antecedentes Ginecologicos");
						report.setHrencodigo(imp_antecedentes_ginecologicos);
						report.setHrentipoimpres(1);
						report.setHrenconsulta(consulta.getHcolnumero());
						report.setHredfecharegis(consulta.getHcodfecregistr());
						lstReporte.add(report);

						if (antecedente.getHagnabortoprevio().intValue() >= 3) {
							report = new Chreporte();
							report.setHrecdescripcio(
									"3 o mNs abortos seguidos:  " + formatearCampo(antecedente.getHagcabortseguido()));
							report.setHrectipodescri("Antecedentes Ginecologicos");
							report.setHrencodigo(imp_antecedentes_ginecologicos);
							report.setHrentipoimpres(1);
							report.setHrenconsulta(consulta.getHcolnumero());
							report.setHredfecharegis(consulta.getHcodfecregistr());
							lstReporte.add(report);
						}
					}

				}

				if (antecedente.getHagcfeabopar() != null) {
					report = new Chreporte();
					report.setHrecdescripcio(
							"Fecha de Nltimo parto o aborto:  " + formatearCampo(antecedente.getHagcfeabopar()));
					report.setHrectipodescri("Antecedentes Ginecologicos");
					report.setHrencodigo(imp_antecedentes_ginecologicos);
					report.setHrentipoimpres(1);
					report.setHrenconsulta(consulta.getHcolnumero());
					report.setHredfecharegis(consulta.getHcodfecregistr());
					lstReporte.add(report);

					if ("S".equals(antecedente.getHagcfeabopar())) {
						report = new Chreporte();
						report.setHrecdescripcio(
								"Fecha de Nltimo parto/Aborto:  " + formatearCampo(antecedente.getHagdfecultabopar()));
						report.setHrectipodescri("Antecedentes Ginecologicos");
						report.setHrencodigo(imp_antecedentes_ginecologicos);
						report.setHrentipoimpres(1);
						report.setHrenconsulta(consulta.getHcolnumero());
						report.setHredfecharegis(consulta.getHcodfecregistr());
						lstReporte.add(report);

						if (antecedente.getHagcpesorn() != null) {
							report = new Chreporte();
							report.setHrecdescripcio("Peso RN:  " + antecedente.getHagcpesorn());
							report.setHrectipodescri("Antecedentes Ginecologicos");
							report.setHrencodigo(imp_antecedentes_ginecologicos);
							report.setHrentipoimpres(1);
							report.setHrenconsulta(consulta.getHcolnumero());
							report.setHredfecharegis(consulta.getHcodfecregistr());
							lstReporte.add(report);
						}

					}

				}
				if (antecedente.getHagcevitemba() != null) {
					report = new Chreporte();
					report.setHrecdescripcio(
							"Al enterarse de este embarazo, Nestaba usando algNn mNtodo para evitar el embarazo?:  "
									+ formatearCampo(antecedente.getHagcevitemba()));
					report.setHrectipodescri("Antecedentes Ginecologicos");
					report.setHrencodigo(imp_antecedentes_ginecologicos);
					report.setHrentipoimpres(1);
					report.setHrenconsulta(consulta.getHcolnumero());
					report.setHredfecharegis(consulta.getHcodfecregistr());
					lstReporte.add(report);

					if ("S".equals(antecedente.getHagcevitemba())) {
						String metodo = "";

						try {
							metodo = serviceLocator.getClinicoService()
									.getDescripcionMetodo(antecedente.getHagcmetoevitemba());
						} catch (ModelException e) {
							e.printStackTrace();
						}
						report = new Chreporte();
						report.setHrecdescripcio("Metodo de PlanificaciNn:  " + formatearCampo(metodo));
						report.setHrectipodescri("Antecedentes Ginecologicos");
						report.setHrencodigo(imp_antecedentes_ginecologicos);
						report.setHrentipoimpres(1);
						report.setHrenconsulta(consulta.getHcolnumero());
						report.setHredfecharegis(consulta.getHcodfecregistr());
						lstReporte.add(report);

						if (antecedente.getHagcevitotro() != null) {
							report = new Chreporte();
							report.setHrecdescripcio("Aclaracion:  " + antecedente.getHagcevitotro());
							report.setHrectipodescri("Antecedentes Ginecologicos");
							report.setHrencodigo(imp_antecedentes_ginecologicos);
							report.setHrentipoimpres(1);
							report.setHrenconsulta(consulta.getHcolnumero());
							report.setHredfecharegis(consulta.getHcodfecregistr());
							lstReporte.add(report);
						}
						if (antecedente.getHagcevitotro() != null) {
							report = new Chreporte();
							report.setHrecdescripcio(
									"Fecha de aplicaciNn:  " + formatearCampo(antecedente.getHagdfeultiapl()));
							report.setHrectipodescri("Antecedentes Ginecologicos");
							report.setHrencodigo(imp_antecedentes_ginecologicos);
							report.setHrentipoimpres(1);
							report.setHrenconsulta(consulta.getHcolnumero());
							report.setHredfecharegis(consulta.getHcodfecregistr());
							lstReporte.add(report);
						}

						if (antecedente.getHagceviembusomet() != null) {
							report = new Chreporte();
							report.setHrecdescripcio("Verifica el uso correcto del mNtodo?:  "
									+ formatearCampo(antecedente.getHagceviembusomet()));
							report.setHrectipodescri("Antecedentes Ginecologicos");
							report.setHrencodigo(imp_antecedentes_ginecologicos);
							report.setHrentipoimpres(1);
							report.setHrenconsulta(consulta.getHcolnumero());
							report.setHredfecharegis(consulta.getHcodfecregistr());
							lstReporte.add(report);
						}

						if (antecedente.getHagcbusometobs() != null) {
							report = new Chreporte();
							report.setHrecdescripcio("AclaraciNn:  " + antecedente.getHagcbusometobs());
							report.setHrectipodescri("Antecedentes Ginecologicos");
							report.setHrencodigo(imp_antecedentes_ginecologicos);
							report.setHrentipoimpres(1);
							report.setHrenconsulta(consulta.getHcolnumero());
							report.setHredfecharegis(consulta.getHcodfecregistr());
							lstReporte.add(report);
						}
					}

				}

			}
			if (IConstantes.HISTORIA_ANTICONCEPCION_INSERCION.equals(tipoHistoria)
					|| IConstantes.HISTORIA_ANTICONCEPCION_TEMPORAL.equals(tipoHistoria)) {
				if (antecedente.getHagdfecpruemb() != null) {
					Chreporte report = new Chreporte();
					report.setHrecdescripcio("Se realizo prueba de embarazo: Si");
					report.setHrecdescripcio2("Fecha de la toma:  " + formatearCampo(antecedente.getHagdfecpruemb()));
					String resultadoEMbarazo = "Negativo";
					if ("S".equals(antecedente.getHagcrespruemb())) {
						resultadoEMbarazo = "Positivo";
					}
					report.setHrecdescripcio3("Resultado Prueba:  " + resultadoEMbarazo);
					report.setHrectipodescri("Antecedentes Ginecologicos");
					report.setHrencodigo(imp_antecedentes_ginecologicos);
					report.setHrentipoimpres(4);
					report.setHrenconsulta(consulta.getHcolnumero());
					report.setHredfecharegis(consulta.getHcodfecregistr());
					lstReporte.add(report);
				} else {
					Chreporte report = new Chreporte();
					report.setHrecdescripcio("Se realizo prueba de embarazo: No");
					report.setHrectipodescri("Antecedentes Ginecologicos");
					report.setHrencodigo(imp_antecedentes_ginecologicos);
					report.setHrentipoimpres(3);
					report.setHrenconsulta(consulta.getHcolnumero());
					report.setHredfecharegis(consulta.getHcodfecregistr());
					lstReporte.add(report);
				}
			}
		}

	}

	public void imprimirOrdenesMedicas(Chconsulta consulta) {
		// Nuevo para formulaciNn medicamentos
		List<Chformulahos> lstPrescripciones = new ArrayList<Chformulahos>();
		try {
			lstPrescripciones = this.serviceLocator.getCirugiaService()
					.getFormulaMedicamentosCirugia(consulta.getHcolnumero(), null);
		} catch (ModelException e) {
			e.printStackTrace();
		}

		if (lstPrescripciones != null && !lstPrescripciones.isEmpty()) {
			String MEDICAMENTO = "";
			String FORMULA = "";
			Chreporte report = new Chreporte();
			report.setHrectipodescri("Ordenes Medicas");
			report.setHrecdescripcio("Medicamentos Formulados");
			report.setHrencodigo(imp_evolucion);
			report.setHrentipoimpres(1);
			report.setHrenconsulta(consulta.getHcolnumero());
			report.setHredfecharegis(consulta.getHcodfecregistr());
			lstReporte.add(report);

			Iterator itpr = lstPrescripciones.iterator();
			while (itpr.hasNext()) {
				Chformulahos formula = (Chformulahos) itpr.next();
				if (formula != null) {
					String via = "";
					if (formula.getHfhcviadministr().equals("VO")) {
						via = "Via Oral";
					} else if (formula.getHfhcviadministr().equals("IV")) {
						via = "Via Intravenosa";
					} else if (formula.getHfhcviadministr().equals("IM")) {
						via = "Via Intramuscular";
					} else if (formula.getHfhcviadministr().equals("VA")) {
						via = "Via Intravaginal";
					} else if (formula.getHfhcviadministr().equals("SC")) {
						via = "SubcutNnea";
					} else {
						via = "Otra";
					}

					MEDICAMENTO = "Medicamento: " + formula.getHfhcmedicament();
					FORMULA = "PresentaciNn: " + formula.getHfhcpresentaci() + "  Dosis: "
							+ formula.getHfhcadosis().toString() + " " + formula.getHfhcunidad()
							+ "  Frecuencia (Horas): " + formula.getHfhnfrecuadmin() + "  VNa AdministraciNn: " + via;
					report = new Chreporte();
					report.setHrectipodescri("Medicamentos");
					report.setHrecdescripcio(formatearCampo(MEDICAMENTO));
					report.setHrencodigo(imp_evolucion);
					report.setHrentipoimpres(1);
					report.setHrenconsulta(consulta.getHcolnumero());
					report.setHredfecharegis(consulta.getHcodfecregistr());
					lstReporte.add(report);

					report = new Chreporte();
					report.setHrectipodescri("Medicamentos");
					report.setHrecdescripcio(formatearCampo(FORMULA));
					report.setHrencodigo(imp_evolucion);
					report.setHrentipoimpres(1);
					report.setHrenconsulta(consulta.getHcolnumero());
					report.setHredfecharegis(consulta.getHcodfecregistr());
					lstReporte.add(report);
				}
			}
		}

		// Nuevo para formulaciNn liquidos
		List<Chformulaliq> lstLiquidos = new ArrayList<Chformulaliq>();
		try {
			lstLiquidos = this.serviceLocator.getCirugiaService().getLstLiquidosFormulados(consulta.getHcolnumero(),
					"NA", null, null);
		} catch (ModelException e) {
			e.printStackTrace();
		}
		if (lstLiquidos != null && !lstLiquidos.isEmpty()) {
			String LIQUIDO = "";
			Chreporte report = new Chreporte();
			report.setHrecdescripcio("Liquidos Formulados");
			report.setHrencodigo(imp_evolucion);
			report.setHrentipoimpres(1);
			report.setHrenconsulta(consulta.getHcolnumero());
			report.setHredfecharegis(consulta.getHcodfecregistr());
			lstReporte.add(report);

			Iterator itlq = lstLiquidos.iterator();
			while (itlq.hasNext()) {
				Chformulaliq liquido = (Chformulaliq) itlq.next();
				if (liquido != null) {
					String liqui = "";

					if (liquido.getHflcnombreliqu().equals("01")) {
						liqui = "Lactato de Ringer";
					} else if (liquido.getHflcnombreliqu().equals("02")) {
						liqui = "Haemacell";
					} else if (liquido.getHflcnombreliqu().equals("03")) {
						liqui = "Dextranes";
					} else if (liquido.getHflcnombreliqu().equals("04")) {
						liqui = "Globulos Rojos";
					} else if (liquido.getHflcnombreliqu().equals("05")) {
						liqui = "Sangre total";
					} else if (liquido.getHflcnombreliqu().equals("06")) {
						liqui = "Plasma";
					} else if (liquido.getHflcnombreliqu().equals("07")) {
						liqui = "Plaquetas";
					}

					String via = "";
					if (liquido.getHflcviadminist() != null) {
						if (liquido.getHflcviadminist().equals("IV")) {
							via = "Intravenosa";
						} else if (liquido.getHflcviadminist().equals("SL")) {
							via = "Sublingual";
						}
					}
					String forma = "";
					if (liquido.getHflcformadmins() != null) {
						if (liquido.getHflcformadmins().equals("L")) {
							forma = "En Bolo";
						} else if (liquido.getHflcformadmins().equals("I")) {
							forma = "En infusiNn";
						}
					}

					LIQUIDO = "Liquido: " + liqui + "  Dosis: " + liquido.getHflncantidad() + "  Via: " + via
							+ "  Forma: " + forma + "  Velocidad Adm.: " + liquido.getHflnvelocidadm();
					report = new Chreporte();
					report.setHrecdescripcio(formatearCampo(LIQUIDO));
					report.setHrencodigo(imp_evolucion);
					report.setHrentipoimpres(1);
					report.setHrenconsulta(consulta.getHcolnumero());
					report.setHredfecharegis(consulta.getHcodfecregistr());
					lstReporte.add(report);

				}
			}
		}
	}

	public void procedimientosconocimientos(Chconsulta consulta) {
		if (consulta.getChproceconsu() != null && !consulta.getChproceconsu().isEmpty()) {

			Chproceconsu procedimiento = null;

			Iterator it = consulta.getChproceconsu().iterator();
			if (it.hasNext()) {
				procedimiento = (Chproceconsu) it.next();

				if (procedimiento != null) {
					String s = "Ambito de realizacion: " + AMBITO_PROCEDIMIENTO;
					String s2 = "Finalidad: " + FINALIDAD_PROCEDIMIENTO;
					Chreporte report = new Chreporte();
					report.setHrecdescripcio(s);
					report.setHrecdescripcio2(s2);
					report.setHrentipoimpres(2);
					report.setHrectipodescri("Procedimiento en Consultorio");
					report.setHrenconsulta(consulta.getHcolnumero());
					report.setHredfecharegis(consulta.getHcodfecregistr());
					report.setHrencodigo(imp_procedimiento_consultorio);
					lstReporte.add(report);

					report = new Chreporte();
					s = "Diagnostico Previo: " + DIAGNOSTICO_PREVIO;
					report.setHrecdescripcio(s);
					report.setHrentipoimpres(1);
					report.setHrectipodescri("Procedimiento en Consultorio");
					report.setHrenconsulta(consulta.getHcolnumero());
					report.setHredfecharegis(consulta.getHcodfecregistr());
					report.setHrencodigo(imp_procedimiento_consultorio);
					lstReporte.add(report);

					report = new Chreporte();
					s = "Descripcion del Procedimiento: " + DESCRIPCION_PROCEDIMIENTO;
					report.setHrecdescripcio(s);
					report.setHrentipoimpres(1);
					report.setHrectipodescri("Procedimiento en Consultorio");
					report.setHrenconsulta(consulta.getHcolnumero());
					report.setHredfecharegis(consulta.getHcodfecregistr());
					report.setHrencodigo(imp_procedimiento_consultorio);
					lstReporte.add(report);

					if (DIAGNOSTICO_COMPLICACION != null) {
						report = new Chreporte();
						s = "Tiene Complicaciones : " + TIENE_COMPLICACIONES;
						s2 = "Diagnostico Complicacion: " + DIAGNOSTICO_COMPLICACION;
						report = new Chreporte();
						report.setHrecdescripcio(s);
						report.setHrecdescripcio2(s2);
						report.setHrentipoimpres(2);
						report.setHrectipodescri("Procedimiento en Consultorio");
						report.setHrenconsulta(consulta.getHcolnumero());
						report.setHredfecharegis(consulta.getHcodfecregistr());
						report.setHrencodigo(imp_procedimiento_consultorio);
						lstReporte.add(report);

						report = new Chreporte();
						s = "Descripcion de la complicaciNn: " + DESCRIPCION_COMPLICACION;
						report.setHrecdescripcio(s);
						report.setHrentipoimpres(1);
						report.setHrectipodescri("Procedimiento en Consultorio");
						report.setHrenconsulta(consulta.getHcolnumero());
						report.setHredfecharegis(consulta.getHcodfecregistr());
						report.setHrencodigo(imp_procedimiento_consultorio);
						lstReporte.add(report);
					}

					report = new Chreporte();
					s = "Diagnostico Posterior: " + DIAGNOSTICO_POSTERIOR;
					report.setHrecdescripcio(s);
					report.setHrentipoimpres(1);
					report.setHrectipodescri("Procedimiento en Consultorio");
					report.setHrenconsulta(consulta.getHcolnumero());
					report.setHredfecharegis(consulta.getHcodfecregistr());
					report.setHrencodigo(imp_procedimiento_consultorio);
					lstReporte.add(report);

					if (REALIZACION_PROCEDIMIENTO != null && !REALIZACION_PROCEDIMIENTO.equals("")) {
						report = new Chreporte();
						s = "Realizacion: " + REALIZACION_PROCEDIMIENTO;
						report.setHrecdescripcio(s);
						report.setHrentipoimpres(1);
						report.setHrectipodescri("Procedimiento en Consultorio");
						report.setHrenconsulta(consulta.getHcolnumero());
						report.setHredfecharegis(consulta.getHcodfecregistr());
						report.setHrencodigo(imp_procedimiento_consultorio);
						lstReporte.add(report);

					}

					if (procedimiento.getHpcnescaladolor() != null) {
						report = new Chreporte();
						report.setHrectipodescri("Examen Fisico");
						report.setHrecdescripcio("Escala del Dolor ");
						report.setHrecdescripcio2(formatearCampo(procedimiento.getHpcnescaladolor()));
						report.setHrencodigo(imp_procedimiento_consultorio);
						report.setHrentipoimpres(3);
						report.setHrenconsulta(consulta.getHcolnumero());
						report.setHredfecharegis(consulta.getHcodfecregistr());
						lstReporte.add(report);

						report = new Chreporte();
						report.setHrectipodescri("Examen Fisico");
						report.setHrecdescripcio("DuraciNn del dolor Intenso         ");
						report.setHrecdescripcio2(formatearCampo(procedimiento.getHpcnduracidolor()) + " "
								+ formatearCampoTipoDuracion(procedimiento.getHpccdudointen()));
						report.setHrencodigo(imp_procedimiento_consultorio);
						report.setHrentipoimpres(3);
						report.setHrenconsulta(consulta.getHcolnumero());
						report.setHredfecharegis(consulta.getHcodfecregistr());
						lstReporte.add(report);

					}
				}
			}
		}
	}

	public void espermograma(Chconsulta consulta) {
		if (consulta.getChespervasec() != null && !consulta.getChespervasec().isEmpty()) {
			Chespervasec espervasec = null;
			Iterator it = consulta.getChespervasec().iterator();
			if (it.hasNext()) {
				espervasec = (Chespervasec) it.next();

				if (espervasec != null) {
					String s = "Resultado: ";
					if (espervasec.getHevcesperpostv() != null && espervasec.getHevcesperpostv().equals("1")) {
						s = s + "NEGATIVO";
					} else if (espervasec.getHevcesperpostv() != null && espervasec.getHevcesperpostv().equals("2")) {
						s = s + "POSITIVO";
					} else {
						s = s + "REGISTRO NO VALIDO";
					}
					Chreporte report = new Chreporte();
					report.setHrecdescripcio(s);
					report.setHrentipoimpres(1);
					report.setHrectipodescri("Espermograma - Posvasectomia");
					report.setHrenconsulta(consulta.getHcolnumero());
					report.setHredfecharegis(consulta.getHcodfecregistr());
					report.setHrencodigo(imp_esterilizacion);
					lstReporte.add(report);

					s = "Recuento: ";
					if (espervasec.getHevarecueesper() != null) {
						DecimalFormat formateador = new DecimalFormat("###,###,##0");
						s = s + formateador.format(espervasec.getHevarecueesper()) + "/ml";
					}
					report = new Chreporte();
					report.setHrecdescripcio(s);
					report.setHrentipoimpres(1);
					report.setHrectipodescri("Espermograma - Posvasectomia");
					report.setHrenconsulta(consulta.getHcolnumero());
					report.setHredfecharegis(consulta.getHcodfecregistr());
					report.setHrencodigo(imp_esterilizacion);
					lstReporte.add(report);

					s = "Observaciones: ";
					if (espervasec.getHevcresulesper() != null) {
						s = s + espervasec.getHevcresulesper();
					}
					report = new Chreporte();
					report.setHrecdescripcio(s);
					report.setHrentipoimpres(1);
					report.setHrectipodescri("Espermograma - Posvasectomia");
					report.setHrenconsulta(consulta.getHcolnumero());
					report.setHredfecharegis(consulta.getHcodfecregistr());
					report.setHrencodigo(imp_esterilizacion);
					lstReporte.add(report);

				}
			}
		}
	}

	public void imprimirAntecedentesColposcopia(Chconsulta consulta) {

		if (consulta.getChantecolpo() != null && !consulta.getChantecolpo().isEmpty()) {

			Chantecolpo antecedente = null;
			Iterator it = consulta.getChantecolpo().iterator();
			if (it.hasNext()) {
				antecedente = (Chantecolpo) it.next();
			}

			if (antecedente != null) {
				Chreporte report = new Chreporte();

				report = new Chreporte();
				report.setHrecdescripcio("Gestaciones:  " + formatearCampo(antecedente.getHacnnumgesta()));
				report.setHrecdescripcio2("Partos:  " + formatearCampo(antecedente.getHacnnumparto()));
				report.setHrecdescripcio3("Abortos:  " + formatearCampo(antecedente.getHacnnumaborto()));
				report.setHrecdescripcio4("Cesareas:  " + formatearCampo(antecedente.getHacnnumcesare()));
				report.setHrectipodescri("Antecedentes Colposcopia");
				report.setHrentipoimpres(4);
				report.setHrencodigo(imp_antecedente_colposcopia);
				report.setHrenconsulta(consulta.getHcolnumero());
				report.setHredfecharegis(consulta.getHcodfecregistr());
				lstReporte.add(report);

				report = new Chreporte();
				report.setHrecdescripcio("Hijos Vivos:  " + formatearCampo(antecedente.getHacnnumvivo()));
				report.setHrecdescripcio2("Ectopicos: " + formatearCampo(antecedente.getHacnectopico()));
				report.setHrecdescripcio3("Hijos Muertos: " + formatearCampo(antecedente.getHacnmolas()));
				report.setHrecdescripcio4("Mortinatos: " + formatearCampo(antecedente.getHacnmortina()));
				report.setHrectipodescri("Antecedentes Colposcopia");
				report.setHrencodigo(imp_antecedente_colposcopia);
				report.setHrentipoimpres(4);
				report.setHrenconsulta(consulta.getHcolnumero());
				report.setHredfecharegis(consulta.getHcodfecregistr());
				lstReporte.add(report);

				/*
				 * if(HIJOS_NACIDOS_VIVOS != null ){ report = new Chreporte();
				 * report.setHrecdescripcio("Hijos Nacidos Vivos:  " +
				 * formatearCampo(HIJOS_NACIDOS_VIVOS)); report.setHrecdescripcio2("");
				 * report.setHrecdescripcio3(""); report.setHrecdescripcio4("");
				 * report.setHrectipodescri("Antecedentes Ginecologicos");
				 * report.setHrencodigo(imp_antecedentes_ginecologicos);
				 * report.setHrentipoimpres(4);
				 * report.setHrenconsulta(consulta.getHcolnumero());
				 * report.setHredfecharegis(consulta.getHcodfecregistr());
				 * lstReporte.add(report);
				 * 
				 * }
				 */

				if (antecedente.getHacncompasexua() != null) {
					report = new Chreporte();
					report.setHrecdescripcio(
							"No CompaNeros Sexuales:  " + formatearCampo(antecedente.getHacncompasexua()));

					report.setHrecdescripcio2(
							"Edad Inicio de Relacionaes Sexuales:  " + formatearCampo(antecedente.getHacnedadrelac()));

					report.setHrectipodescri("Antecedentes Colposcopia");
					report.setHrencodigo(imp_antecedente_colposcopia);
					report.setHrentipoimpres(2);
					report.setHrenconsulta(consulta.getHcolnumero());
					report.setHredfecharegis(consulta.getHcodfecregistr());
					lstReporte.add(report);

					report = new Chreporte();
					report.setHrecdescripcio("Diabetes:  " + formatearCampo(antecedente.getHacediabetes()));
					report.setHrecdescripcio2("VIH:  " + formatearCampo(antecedente.getHacevih()));
					report.setHrectipodescri("Antecedentes Colposcopia");
					report.setHrencodigo(imp_antecedente_colposcopia);
					report.setHrentipoimpres(2);
					report.setHrenconsulta(consulta.getHcolnumero());
					report.setHredfecharegis(consulta.getHcodfecregistr());
					lstReporte.add(report);

					report = new Chreporte();
					report.setHrecdescripcio("ETS:  " + formatearCampo(antecedente.getHaceets()));

					report.setHrecdescripcio2("Fuma:  " + formatearCampo(antecedente.getHacefuma()));
					report.setHrectipodescri("Antecedentes Colposcopia");
					report.setHrencodigo(imp_antecedente_colposcopia);
					report.setHrentipoimpres(2);
					report.setHrenconsulta(consulta.getHcolnumero());
					report.setHredfecharegis(consulta.getHcodfecregistr());
					lstReporte.add(report);

					report = new Chreporte();
					report.setHrecdescripcio("VacunaciNn de VPH:  " + formatearCampo(antecedente.getHacevacunvph()));
					if ("S".equals(antecedente.getHacevacunvph())) {
						report.setHrecdescripcio2("Numero de Dosis:  " + formatearCampo(antecedente.getHacnnumervph()));

					} else {
						report.setHrecdescripcio("");
					}

					report.setHrectipodescri("Antecedentes Colposcopia");
					report.setHrencodigo(imp_antecedente_colposcopia);
					report.setHrentipoimpres(2);
					report.setHrenconsulta(consulta.getHcolnumero());
					report.setHredfecharegis(consulta.getHcodfecregistr());
					lstReporte.add(report);

					report = new Chreporte();
					report.setHrecdescripcio("Tipificacion VPH:  " + formatearCampoVPH(antecedente.getHacetipifvph()));

					if ("S".equals(antecedente.getHacetipifvph())) {
						report.setHrecdescripcio2(
								"GenotificaciNn:  " + formatearCampo(antecedente.getHaccgenotipifi()));
					} else {
						report.setHrecdescripcio2("");
					}
					report.setHrecdescripcio3("");

					report.setHrecdescripcio4("");

					report.setHrectipodescri("Antecedentes Colposcopia");
					report.setHrencodigo(imp_antecedente_colposcopia);
					report.setHrentipoimpres(4);
					report.setHrenconsulta(consulta.getHcolnumero());
					report.setHredfecharegis(consulta.getHcodfecregistr());
					lstReporte.add(report);

					report = new Chreporte();
					report.setHrecdescripcio("Antecedentes de procedimientos de cuello uterino:  "
							+ formatearCampoVPH(antecedente.getHaccantecprevi()));

					if ("S".equals(antecedente.getHaccantecprevi())) {
						report.setHrecdescripcio2(
								"Resultado del procedimiento:  " + formatearCampo(antecedente.getHaccgenotipifi()));
					} else {
						report.setHrecdescripcio2("");
					}

					report.setHrectipodescri("Antecedentes Colposcopia");
					report.setHrencodigo(imp_antecedente_colposcopia);
					report.setHrentipoimpres(2);
					report.setHrenconsulta(consulta.getHcolnumero());
					report.setHredfecharegis(consulta.getHcodfecregistr());
					lstReporte.add(report);

				}

				report = new Chreporte();

				String TIPO_CICLO_COLPO = "";
				String FRECUENCIA_CICLO_COLPO = null;
				String DURACION_CICLO_COLPO = null;
				String ULTIMA_CITOLOGIA_COLPO = null;

				if (antecedente.getHacetipciclo() != null) {
					if (antecedente.getHacetipciclo().equals("I")) {
						TIPO_CICLO_COLPO = "Irregular";
					} else if (antecedente.getHacetipciclo().equals("R")) {
						TIPO_CICLO_COLPO = "Regular";
					} else if (antecedente.getHacetipciclo().equals("N")) {
						TIPO_CICLO_COLPO = "No ha Tenido Menarquia";
					} else if (antecedente.getHacetipciclo().equals("A")) {
						TIPO_CICLO_COLPO = "Amenorrea";
					}

				}

				report.setHrecdescripcio("Tipo Ciclo: " + formatearCampo(TIPO_CICLO_COLPO));

				if (antecedente.getHacetipciclo() != null && antecedente.getHacetipciclo().equals("I")) {

					FRECUENCIA_CICLO_COLPO = antecedente.getHacnfreciclo() + " - " + antecedente.getHacnfrefincicl();

					DURACION_CICLO_COLPO = antecedente.getHacndurciclo() + " - " + antecedente.getHacndurfincicl();

				} else {
					FRECUENCIA_CICLO_COLPO = formatearCampo(antecedente.getHacnfreciclo());
					DURACION_CICLO_COLPO = formatearCampo(antecedente.getHacndurciclo());
				}

				if (FRECUENCIA_CICLO_COLPO != null && !"".equals(FRECUENCIA_CICLO_COLPO)) {
					report.setHrecdescripcio2("Frecuencia: " + formatearCampo(FRECUENCIA_CICLO_COLPO));
				} else {
					report.setHrecdescripcio2("");
				}
				if (DURACION_CICLO_COLPO != null && !"".equals(DURACION_CICLO_COLPO)) {
					report.setHrecdescripcio3("DuraciNn:  " + formatearCampo(DURACION_CICLO_COLPO));
				} else {
					report.setHrecdescripcio3("");
				}

				report.setHrectipodescri("Antecedentes Colposcopia");
				report.setHrencodigo(imp_antecedente_colposcopia);
				report.setHrentipoimpres(4);
				report.setHrenconsulta(consulta.getHcolnumero());
				report.setHredfecharegis(consulta.getHcodfecregistr());
				lstReporte.add(report);

				if (antecedente.getHacnmenarquia() != null) {
					report = new Chreporte();
					report.setHrecdescripcio("Menarquia:  " + formatearCampo(antecedente.getHacnmenarquia()));

					report.setHrecdescripcio2("");
					report.setHrecdescripcio3("");
					report.setHrecdescripcio4("");
					report.setHrectipodescri("Antecedentes Colposcopia");
					report.setHrencodigo(imp_antecedente_colposcopia);
					report.setHrentipoimpres(4);
					report.setHrenconsulta(consulta.getHcolnumero());
					report.setHredfecharegis(consulta.getHcodfecregistr());
					lstReporte.add(report);
				}

				report = new Chreporte();
				if (antecedente.getHacdfur() != null && !antecedente.getHacdfur().equals("")) {
					report.setHrecdescripcio("FUR normal :  " + formatearCampo(antecedente.getHacdfur()));
				}
				if (antecedente.getHacdfup() != null && !antecedente.getHacdfup().equals("")) {
					report.setHrecdescripcio2("FUP N Aborto : " + formatearCampo(antecedente.getHacdfup()));
				}

				report.setHrecdescripcio3("");
				report.setHrecdescripcio4("");
				report.setHrectipodescri("Antecedentes Colposcopia");
				report.setHrencodigo(imp_antecedente_colposcopia);
				report.setHrentipoimpres(4);
				report.setHrenconsulta(consulta.getHcolnumero());
				report.setHredfecharegis(consulta.getHcodfecregistr());
				lstReporte.add(report);

				report = new Chreporte();

				if (antecedente.getHaccultcitolo() != null) {
					if (antecedente.getHaccultcitolo().equals("NO")) {
						ULTIMA_CITOLOGIA_COLPO = "Nunca";
					} else if (antecedente.getHaccultcitolo().equals("-1")) {
						ULTIMA_CITOLOGIA_COLPO = "Hace menos de un aNo";
					} else if (antecedente.getHaccultcitolo().equals("+1")) {
						ULTIMA_CITOLOGIA_COLPO = "Hace mas de un aNo";
					} else if (antecedente.getHaccultcitolo().equals("NR")) {
						ULTIMA_CITOLOGIA_COLPO = "No recuerda";
					}
				}

				if (antecedente.getHaccultcitolo() != null && !antecedente.getHaccultcitolo().equals("")) {
					report.setHrecdescripcio("F.U.Citologia : " + formatearCampo(ULTIMA_CITOLOGIA_COLPO));
				}

				report.setHrecdescripcio2("");
				if (antecedente.getHaccresulcitol() != null && !antecedente.getHaccresulcitol().equals("")) {
					report.setHrecdescripcio2(
							"Resultado citologia: " + obtenerResultadoCitologia(antecedente.getHaccresulcitol()));
				}
				report.setHrecdescripcio3("");
				if (antecedente.getHaccotroresul() != null) {
					report.setHrecdescripcio3("Cual? " + antecedente.getHaccotroresul());
				}

				report.setHrectipodescri("Antecedentes Colposcopia");
				report.setHrencodigo(imp_antecedente_colposcopia);
				report.setHrentipoimpres(3);
				report.setHrenconsulta(consulta.getHcolnumero());
				report.setHredfecharegis(consulta.getHcodfecregistr());
				lstReporte.add(report);

				if (antecedente.getHaccmetodoplan() != null) {
					report = new Chreporte();
					String metodo = "";

					try {
						metodo = serviceLocator.getClinicoService()
								.getDescripcionMetodo(antecedente.getHaccmetodoplan());
					} catch (ModelException e) {
						e.printStackTrace();
					}
					if (antecedente.getHaccmetodoplan().equals("0")) {
						metodo = "OTRO: " + antecedente.getHaccotrometodo();
					}

					report.setHrecdescripcio("MNtodo PlanificaciNn:  " + formatearCampo(metodo));
					report.setHrecdescripcio4("");
					report.setHrectipodescri("Antecedentes Colposcopia");
					report.setHrencodigo(imp_antecedente_colposcopia);
					report.setHrentipoimpres(1);
					report.setHrenconsulta(consulta.getHcolnumero());
					report.setHredfecharegis(consulta.getHcodfecregistr());
					lstReporte.add(report);

					if (antecedente.getHacdfeultiapl() != null) {
						report = new Chreporte();
						report.setHrecdescripcio(
								"Fecha de la Nltima aplicaciNn:  " + formatearCampo(antecedente.getHacdfeultiapl()));
						report.setHrecdescripcio4("");
						report.setHrectipodescri("Antecedentes Colposcopia");
						report.setHrencodigo(imp_antecedente_colposcopia);
						report.setHrentipoimpres(1);
						report.setHrenconsulta(consulta.getHcolnumero());
						report.setHredfecharegis(consulta.getHcodfecregistr());
						lstReporte.add(report);
					}
				}

			}

		}

	}

	public void imprimirColposcopia(Chconsulta consulta) {

		if (consulta.getChcolposcopia() != null && !consulta.getChcolposcopia().isEmpty()) {

			Chcolposcopia colposcopia = null;
			Iterator it = consulta.getChcolposcopia().iterator();
			if (it.hasNext()) {
				colposcopia = (Chcolposcopia) it.next();
			}

			if (colposcopia != null) {
				Chreporte report = new Chreporte();

				String evaluacionGeneral = null;
				String visibilidadEscamo = null;

				if ("A".equals(colposcopia.getHclcevalugener())) {
					evaluacionGeneral = "Adecuada";
				} else {
					evaluacionGeneral = "Inadecuada";
				}

				if ("CV".equals(colposcopia.getHclcvisioescam())) {
					visibilidadEscamo = "Completamente visible";
				} else if ("PV".equals(colposcopia.getHclcvisioescam())) {
					visibilidadEscamo = "Parcialmente visible";
				} else if ("NV".equals(colposcopia.getHclcvisioescam())) {
					visibilidadEscamo = "No visible";
				}

				report = new Chreporte();
				report.setHrecdescripcio("Evaluacion General:  " + formatearCampo(evaluacionGeneral));
				report.setHrecdescripcio2("Visibilidad de union escamoculumna:  " + formatearCampo(visibilidadEscamo));
				report.setHrectipodescri("Colposcopia");
				report.setHrentipoimpres(2);
				report.setHrencodigo(imp_colposcopia);
				report.setHrenconsulta(consulta.getHcolnumero());
				report.setHredfecharegis(consulta.getHcodfecregistr());
				lstReporte.add(report);

				report = new Chreporte();
				report.setHrecdescripcio(
						"Zona de transformacion tipo:  " + formatearCampo(colposcopia.getHclczonatrans()));
				report.setHrectipodescri("Colposcopia");
				report.setHrentipoimpres(1);
				report.setHrencodigo(imp_colposcopia);
				report.setHrenconsulta(consulta.getHcolnumero());
				report.setHredfecharegis(consulta.getHcodfecregistr());
				lstReporte.add(report);

				if ("I".equals(colposcopia.getHclcevalugener())) {
					report = new Chreporte();
					String evaluacionInadecuada = "";

					if ("S".equals(colposcopia.getHclcinadeinfla())) {
						evaluacionInadecuada = evaluacionInadecuada + " Por Inflamacion " + " - ";
					}

					if ("S".equals(colposcopia.getHclcinadesangr())) {
						evaluacionInadecuada = evaluacionInadecuada + " Por Sangrado " + " - ";
					}

					if ("S".equals(colposcopia.getHclcinadecicat())) {
						evaluacionInadecuada = evaluacionInadecuada + " Por Cicatriz " + " - ";
					}

					if ("S".equals(colposcopia.getHclcinadeotro())) {
						evaluacionInadecuada = evaluacionInadecuada + " Otros " + " - ";
					}

					if (evaluacionInadecuada != null && evaluacionInadecuada.length() > 1) {
						report.setHrecdescripcio("Evaluacion Inadecuada:  "
								+ formatearCampo(evaluacionInadecuada.substring(0, evaluacionInadecuada.length() - 2)));
						report.setHrecdescripcio3("CNal?:  " + formatearCampo(colposcopia.getHclcinadecual()));
						report.setHrectipodescri("Colposcopia");
						report.setHrentipoimpres(2);
						report.setHrencodigo(imp_colposcopia);
						report.setHrenconsulta(consulta.getHcolnumero());
						report.setHredfecharegis(consulta.getHcodfecregistr());
						lstReporte.add(report);

					}

				}

				report = new Chreporte();
				String hallazgoColpoNormal = "";

				if ("S".equals(colposcopia.getHclchallamadur())) {
					hallazgoColpoNormal = hallazgoColpoNormal + " Maduro " + " - ";
				}

				if ("S".equals(colposcopia.getHclchallaatrof())) {
					hallazgoColpoNormal = hallazgoColpoNormal + " AtrNfico " + " - ";
				}

				if ("S".equals(colposcopia.getHclchallaquiste())) {
					hallazgoColpoNormal = hallazgoColpoNormal + " Quistes de Naboth " + " - ";
				}

				if ("S".equals(colposcopia.getHclchallagland())) {
					hallazgoColpoNormal = hallazgoColpoNormal + " Aberturas Glandulares " + " - ";
				}

				if ("S".equals(colposcopia.getHclchallaectop())) {
					hallazgoColpoNormal = hallazgoColpoNormal + " Ectopia " + " - ";
				}

				if ("S".equals(colposcopia.getHclchalladecid())) {
					hallazgoColpoNormal = hallazgoColpoNormal + " Deciduosis en el embarazo " + " - ";
				}

				if (!"".equals(hallazgoColpoNormal)) {
					report.setHrecdescripcio("Hallazgo colposcNpico normal:  "
							+ formatearCampo(hallazgoColpoNormal.substring(0, hallazgoColpoNormal.length() - 2)));
					report.setHrecdescripcio2("");
					report.setHrectipodescri("Colposcopia");
					report.setHrentipoimpres(2);
					report.setHrencodigo(imp_colposcopia);
					report.setHrenconsulta(consulta.getHcolnumero());
					report.setHredfecharegis(consulta.getHcodfecregistr());
					lstReporte.add(report);
				}

				report = new Chreporte();
				String hallazgosVarios = "";

				if ("S".equals(colposcopia.getHclchallazona())) {
					hallazgosVarios = hallazgosVarios + " Zona de transformaciNn congenita " + " - ";
				}

				if ("S".equals(colposcopia.getHclchallacondi())) {
					hallazgosVarios = hallazgosVarios + " Condiloma " + " - ";
				}

				if ("S".equals(colposcopia.getHclchallainfla())) {
					hallazgosVarios = hallazgosVarios + " InflamaciNn " + " - ";
				}

				if ("S".equals(colposcopia.getHclchallaesten())) {
					hallazgosVarios = hallazgosVarios + " Estenosis " + " - ";
				}

				if ("S".equals(colposcopia.getHclchallaconge())) {
					hallazgosVarios = hallazgosVarios + " AnomalNa CongNnita " + " - ";
				}

				if ("S".equals(colposcopia.getHclchallapost())) {
					hallazgosVarios = hallazgosVarios + " AnomalNas post tratamiento " + " - ";
				}

				if ("S".equals(colposcopia.getHclchallapolip())) {
					hallazgosVarios = hallazgosVarios + " PNlipo (endocervical-exocervical) " + " - ";
				}

				if ("S".equals(colposcopia.getHclchallaendom())) {
					hallazgosVarios = hallazgosVarios + " Endometriosis " + " - ";
				}

				if ("S".equals(colposcopia.getHclchallaotro())) {
					hallazgosVarios = hallazgosVarios + " Otros " + " - ";
				}

				if (!"".equals(hallazgosVarios)) {
					report.setHrecdescripcio("Hallazgo colposcNpico normal:  "
							+ formatearCampo(hallazgosVarios.substring(0, hallazgosVarios.length() - 2)));
					if ("S".equals(colposcopia.getHclchallaotro())) {
						report.setHrecdescripcio2("CNal?:  " + formatearCampo(colposcopia.getHclchallacual()));
					} else {
						report.setHrecdescripcio2("");
					}
					report.setHrectipodescri("Colposcopia");
					report.setHrentipoimpres(2);
					report.setHrencodigo(imp_colposcopia);
					report.setHrenconsulta(consulta.getHcolnumero());
					report.setHredfecharegis(consulta.getHcodfecregistr());
					lstReporte.add(report);

				}

				report = new Chreporte();
				report.setHrecdescripcio("               ");
				report.setHrectipodescri("Colposcopia");
				report.setHrentipoimpres(1);
				report.setHrencodigo(imp_colposcopia);
				report.setHrenconsulta(consulta.getHcolnumero());
				report.setHredfecharegis(consulta.getHcodfecregistr());
				lstReporte.add(report);

				report = new Chreporte();
				report.setHrecdescripcio(" Hallazgos colposcopicos anormales: ");
				report.setHrectipodescri("Colposcopia");
				report.setHrentipoimpres(1);
				report.setHrencodigo(imp_colposcopia);
				report.setHrenconsulta(consulta.getHcolnumero());
				report.setHredfecharegis(consulta.getHcodfecregistr());
				lstReporte.add(report);

				String detalleGrado = "";
				String grado = "";

				if (colposcopia.getHclcgradohalla() != null) {
					if (colposcopia.getHclcgradohalla().equals("1")) {
						grado = "Grado 1 (Menor):";
						if (colposcopia.getHclcgrad1epite() != null && colposcopia.getHclcgrad1epite().equals("S")) {
							detalleGrado = detalleGrado + " Epitelio acetoblanco " + " - ";
						}
						if (colposcopia.getHclcgrad1borde() != null && colposcopia.getHclcgrad1borde().equals("S")) {
							detalleGrado = detalleGrado + " Borde irregular " + " - ";
						}
						if (colposcopia.getHclcgrad1mosai() != null && colposcopia.getHclcgrad1mosai().equals("S")) {
							detalleGrado = detalleGrado + " Mosaico fino " + " - ";
						}
						if (colposcopia.getHclcgrad1punte() != null && colposcopia.getHclcgrad1punte().equals("S")) {
							detalleGrado = detalleGrado + " Punteado fino " + " - ";
						}

					}
					if (colposcopia.getHclcgradohalla().equals("2")) {
						grado = "Grado 2 (Mayor):";
						if (colposcopia.getHclcgrad2mosai() != null && colposcopia.getHclcgrad2mosai().equals("S")) {
							detalleGrado = detalleGrado + "  Mosaico Grueso " + " - ";
						}
						if (colposcopia.getHclcgrad2borde() != null && colposcopia.getHclcgrad2borde().equals("S")) {
							detalleGrado = detalleGrado + "  Bordes delimitados " + " - ";
						}
						if (colposcopia.getHclcgrad2signo() != null && colposcopia.getHclcgrad2signo().equals("S")) {
							detalleGrado = detalleGrado + "  Signo del borde interno " + " - ";
						}
						if (colposcopia.getHclcgrad2aceta() != null && colposcopia.getHclcgrad2aceta().equals("S")) {
							detalleGrado = detalleGrado + "  ApariciNn rNpida epitelio acetablanco " + " - ";
						}
						if (colposcopia.getHclcgrad2crest() != null && colposcopia.getHclcgrad2crest().equals("S")) {
							detalleGrado = detalleGrado + "  Signo de la Crest. " + " - ";
						}
						if (colposcopia.getHclcgrad2orifi() != null && colposcopia.getHclcgrad2orifi().equals("S")) {
							detalleGrado = detalleGrado + " Orificio glandular abierto con borde engrosado " + " - ";
						}

						if (colposcopia.getHclcgrad2puntil() != null && colposcopia.getHclcgrad2puntil().equals("S")) {
							detalleGrado = detalleGrado + " Puntillado grueso " + " - ";
						}

						if (colposcopia.getHclcgrad2epacde() != null && colposcopia.getHclcgrad2epacde().equals("S")) {
							detalleGrado = detalleGrado + " Epitelio acetoblanco denso " + " - ";
						}

					}
					if (colposcopia.getHclcgradohalla().equals("0")) {
						if ("P".equals(colposcopia.getHclcgrad3test())) {
							detalleGrado = detalleGrado + " Test de Shiller: Positivo(+) " + " - ";
						}

						if ("N".equals(colposcopia.getHclcgrad3test())) {
							detalleGrado = detalleGrado + " Test de Shiller: Negativo(-) " + " - ";
						}

						if ("S".equals(colposcopia.getHclchallaleuco())) {
							detalleGrado = detalleGrado + " Leucoplasia " + " - ";
						}

						if ("S".equals(colposcopia.getHclcgrad3erosi())) {
							detalleGrado = detalleGrado + "ErosiNn " + " - ";
						}
						grado = "Grado : No Especifico";
					}

					if (!"".equals(detalleGrado)) {
						report = new Chreporte();
						report.setHrecdescripcio(formatearCampo(grado));
						report.setHrecdescripcio2(formatearCampo(detalleGrado.substring(0, detalleGrado.length() - 2)));
						report.setHrectipodescri("Colposcopia");
						report.setHrentipoimpres(2);
						report.setHrencodigo(imp_colposcopia);
						report.setHrenconsulta(consulta.getHcolnumero());
						report.setHredfecharegis(consulta.getHcodfecregistr());
						lstReporte.add(report);
					}

				}

				report = new Chreporte();

				String sospechaInvacion = "";

				if (colposcopia.getHclcvasosatipi() != null && colposcopia.getHclcvasosatipi().equals("S")) {
					sospechaInvacion = sospechaInvacion + " Vasos AtNpicos " + " - ";
				}
				if (colposcopia.getHclcnecrosis() != null && colposcopia.getHclcnecrosis().equals("S")) {
					sospechaInvacion = sospechaInvacion + " Necrosis " + " - ";
				}

				if (colposcopia.getHclcvasosdelga() != null && colposcopia.getHclcvasosdelga().equals("S")) {
					sospechaInvacion = sospechaInvacion + " Vasos Delgados " + " - ";
				}

				if (colposcopia.getHclcnulcera() != null && colposcopia.getHclcnulcera().equals("S")) {
					sospechaInvacion = sospechaInvacion + " Ulcera (NecrNtica) " + " - ";
				}

				if (colposcopia.getHclcsupirreg() != null && colposcopia.getHclcsupirreg().equals("S")) {
					sospechaInvacion = sospechaInvacion + " Sup. Irregular " + " - ";
				}

				if (colposcopia.getHclctumornudol() != null && colposcopia.getHclctumornudol().equals("S")) {
					sospechaInvacion = sospechaInvacion + " Tumor Nodular " + " - ";
				}
				if (colposcopia.getHclclesioexofi() != null && colposcopia.getHclclesioexofi().equals("S")) {
					sospechaInvacion = sospechaInvacion + " LesiNn Exofitica " + " - ";
				}
				if (colposcopia.getHclcsospeotro() != null && colposcopia.getHclcsospeotro().equals("S")) {
					sospechaInvacion = sospechaInvacion + " Otros " + " - ";
				}

				if (!"".equals(sospechaInvacion)) {
					report.setHrecdescripcio("Sospecha de InvasiNn:  "
							+ formatearCampo(sospechaInvacion.substring(0, sospechaInvacion.length() - 2)));
					if ("S".equals(colposcopia.getHclchallaotro())) {
						report.setHrecdescripcio2("CNal?:  " + formatearCampo(colposcopia.getHclchallaotro()));
					} else {
						report.setHrecdescripcio2("");
					}
					report.setHrectipodescri("Colposcopia");
					report.setHrentipoimpres(2);
					report.setHrencodigo(imp_colposcopia);
					report.setHrenconsulta(consulta.getHcolnumero());
					report.setHredfecharegis(consulta.getHcodfecregistr());
					lstReporte.add(report);
				}

				report = new Chreporte();
				report.setHrecdescripcio("                     ");
				report.setHrectipodescri("Colposcopia");
				report.setHrentipoimpres(1);
				report.setHrencodigo(imp_colposcopia);
				report.setHrenconsulta(consulta.getHcolnumero());
				report.setHredfecharegis(consulta.getHcodfecregistr());
				lstReporte.add(report);

				if (colposcopia.getHclcubicacuadr() != null) {

					report = new Chreporte();
					report.setHrecdescripcio(" UbicaciNn de la lesiNn: ");
					report.setHrectipodescri("Colposcopia");
					report.setHrentipoimpres(1);
					report.setHrencodigo(imp_colposcopia);
					report.setHrenconsulta(consulta.getHcolnumero());
					report.setHredfecharegis(consulta.getHcodfecregistr());
					lstReporte.add(report);
				}
				report = new Chreporte();
				String horaDentro = "";

				if (colposcopia.getHclcubicadentr() != null) {
					horaDentro = "Hora:" + colposcopia.getHclcubicadentr();
				}

				if (colposcopia.getHclcubicadentr2() != null) {
					horaDentro = horaDentro + " - Hora:" + colposcopia.getHclcubicadentr2();
				}

				if (colposcopia.getHclclimident() != null && !"".equals(horaDentro)) {

					report.setHrecdescripcio("Dentro de la zona de transformaciNn :" + formatearCampo(horaDentro));
					report.setHrecdescripcio2("Con lNmite visible :" + formatearCampo(colposcopia.getHclclimident()));
					report.setHrectipodescri("Colposcopia");
					report.setHrentipoimpres(2);
					report.setHrencodigo(imp_colposcopia);
					report.setHrenconsulta(consulta.getHcolnumero());
					report.setHredfecharegis(consulta.getHcodfecregistr());
					lstReporte.add(report);
				}

				report = new Chreporte();
				String horaFuera = "";

				if (colposcopia.getHclcubicafuera() != null) {
					horaFuera = "Hora:" + colposcopia.getHclcubicafuera();
				}

				if (colposcopia.getHclcubicafuera2() != null) {
					horaFuera = horaFuera + " - Hora:" + colposcopia.getHclcubicafuera2();
				}

				if (colposcopia.getHclclimifuer() != null && !"".equals(horaFuera)) {
					report.setHrecdescripcio("Fuera de la zona de transformaciNn :" + formatearCampo(horaFuera));
					report.setHrecdescripcio2("Con lNmite visible :" + formatearCampo(colposcopia.getHclclimifuer()));
					report.setHrectipodescri("Colposcopia");
					report.setHrentipoimpres(2);
					report.setHrencodigo(imp_colposcopia);
					report.setHrenconsulta(consulta.getHcolnumero());
					report.setHredfecharegis(consulta.getHcodfecregistr());
					lstReporte.add(report);
				}

				report = new Chreporte();
				if (colposcopia.getHclcubicacuadr() != null && colposcopia.getHclcubicaporce() != null) {
					report.setHrecdescripcio("NN de cuadrantes :" + formatearCampo(colposcopia.getHclcubicacuadr()));
					report.setHrecdescripcio2(
							"Porcentaje del cuello Uterino :" + formatearCampo(colposcopia.getHclcubicaporce()));
					report.setHrectipodescri("Colposcopia");
					report.setHrentipoimpres(2);
					report.setHrencodigo(imp_colposcopia);
					report.setHrenconsulta(consulta.getHcolnumero());
					report.setHredfecharegis(consulta.getHcodfecregistr());
					lstReporte.add(report);
				}

				if (colposcopia.getHclcobservacio() != null) {
					report = new Chreporte();
					report.setHrecdescripcio("Observaciones :" + formatearCampo(colposcopia.getHclcobservacio()));
					report.setHrectipodescri("Colposcopia");
					report.setHrentipoimpres(1);
					report.setHrencodigo(imp_colposcopia);
					report.setHrenconsulta(consulta.getHcolnumero());
					report.setHredfecharegis(consulta.getHcodfecregistr());
					lstReporte.add(report);
				}

			}
		}

	}

	public void imprimirValoracionBiopsicosocial(Chconsulta consulta) {

		if (consulta.getChvalorabiopsi() != null && !consulta.getChvalorabiopsi().isEmpty()) {

			Chvalorabiopsi valoracionBiopsicosocial = null;
			Iterator it = consulta.getChvalorabiopsi().iterator();
			if (it.hasNext()) {
				valoracionBiopsicosocial = (Chvalorabiopsi) it.next();
			}

			if (valoracionBiopsicosocial != null) {
				Chreporte report = new Chreporte();

				report = new Chreporte();
				report.setHrecdescripcio("Historia Reproductiva");
				report.setHrectipodescri("ValoraciNn Biopsicosocial");
				report.setHrencodigo(imp_valoracion_biopsicosocial);
				report.setHrentipoimpres(1);
				report.setHrenconsulta(consulta.getHcolnumero());
				report.setHredfecharegis(consulta.getHcodfecregistr());
				lstReporte.add(report);

				report = new Chreporte();
				report.setHrecdescripcio("Edad:  " + formatearCampo(valoracionBiopsicosocial.getHvbnedad()));
				report.setHrecdescripcio2("Paridad:   " + formatearCampo(valoracionBiopsicosocial.getHvbnparidad()));
				report.setHrectipodescri("ValoraciNn Biopsicosocial");
				report.setHrencodigo(imp_valoracion_biopsicosocial);
				report.setHrentipoimpres(2);
				report.setHrenconsulta(consulta.getHcolnumero());
				report.setHredfecharegis(consulta.getHcodfecregistr());
				lstReporte.add(report);

				report = new Chreporte();
				report.setHrecdescripcio(
						"CesNria Previa:   " + formatearCampo(valoracionBiopsicosocial.getHvbccesaprev()));
				report.setHrecdescripcio2(
						"Preeclampsia o HipertensiNn:   " + formatearCampo(valoracionBiopsicosocial.getHvbcpreehipe()));
				report.setHrectipodescri("ValoraciNn Biopsicosocial");
				report.setHrencodigo(imp_valoracion_biopsicosocial);
				report.setHrentipoimpres(2);
				report.setHrenconsulta(consulta.getHcolnumero());
				report.setHredfecharegis(consulta.getHcodfecregistr());
				lstReporte.add(report);

				report = new Chreporte();
				report.setHrecdescripcio("Abortos recurrentes o infertilidad:   "
						+ formatearCampo(valoracionBiopsicosocial.getHvbcaborinfe()));
				report.setHrecdescripcio2("Hemorragia porstparto o remociNn:   "
						+ formatearCampo(valoracionBiopsicosocial.getHvbchemposrem()));
				report.setHrectipodescri("ValoraciNn Biopsicosocial");
				report.setHrencodigo(imp_valoracion_biopsicosocial);
				report.setHrentipoimpres(2);
				report.setHrenconsulta(consulta.getHcolnumero());
				report.setHredfecharegis(consulta.getHcodfecregistr());
				lstReporte.add(report);

				report = new Chreporte();
				report.setHrecdescripcio(
						"Manual de placenta:   " + formatearCampo(valoracionBiopsicosocial.getHvbcmanuplac()));
				report.setHrecdescripcio2(
						"Peso del reciNn nacido:   " + formatearCampo(valoracionBiopsicosocial.getHvbnpesrecnac()));
				report.setHrectipodescri("ValoraciNn Biopsicosocial");
				report.setHrencodigo(imp_valoracion_biopsicosocial);
				report.setHrentipoimpres(2);
				report.setHrenconsulta(consulta.getHcolnumero());
				report.setHredfecharegis(consulta.getHcodfecregistr());
				lstReporte.add(report);

				report = new Chreporte();
				report.setHrecdescripcio("Mortalidad fetal tardNa o neonatal temprana:   "
						+ formatearCampo(valoracionBiopsicosocial.getHvbcmorfetneo()));
				report.setHrecdescripcio2("Trabajo de parto anormal o dificultoso:   "
						+ formatearCampo(valoracionBiopsicosocial.getHvbcparanodifi()));
				report.setHrectipodescri("ValoraciNn Biopsicosocial");
				report.setHrencodigo(imp_valoracion_biopsicosocial);
				report.setHrentipoimpres(2);
				report.setHrenconsulta(consulta.getHcolnumero());
				report.setHredfecharegis(consulta.getHcodfecregistr());
				lstReporte.add(report);

				report = new Chreporte();
				report.setHrecdescripcio("Cirugia ginecolNgica previa:   "
						+ formatearCampo(valoracionBiopsicosocial.getHvbccirginpre()));
				report.setHrectipodescri("ValoraciNn Biopsicosocial");
				report.setHrencodigo(imp_valoracion_biopsicosocial);
				report.setHrentipoimpres(1);
				report.setHrenconsulta(consulta.getHcolnumero());
				report.setHredfecharegis(consulta.getHcodfecregistr());
				lstReporte.add(report);

				report = new Chreporte();
				report.setHrecdescripcio("Embarazo actual");
				report.setHrectipodescri("ValoraciNn Biopsicosocial");
				report.setHrencodigo(imp_valoracion_biopsicosocial);
				report.setHrentipoimpres(1);
				report.setHrenconsulta(consulta.getHcolnumero());
				report.setHredfecharegis(consulta.getHcodfecregistr());
				lstReporte.add(report);

				report = new Chreporte();
				report.setHrecdescripcio(
						"Enfermedad renal crNnica:   " + formatearCampo(valoracionBiopsicosocial.getHvbcenfrencro()));
				report.setHrecdescripcio2(
						"Diabetes gestacional:   " + formatearCampo(valoracionBiopsicosocial.getHvbcdiabgest()));
				report.setHrectipodescri("ValoraciNn Biopsicosocial");
				report.setHrencodigo(imp_valoracion_biopsicosocial);
				report.setHrentipoimpres(2);
				report.setHrenconsulta(consulta.getHcolnumero());
				report.setHredfecharegis(consulta.getHcodfecregistr());
				lstReporte.add(report);

				report = new Chreporte();
				report.setHrecdescripcio(
						"Diabetes preconcepcional:   " + formatearCampo(valoracionBiopsicosocial.getHvbcdiabprec()));
				report.setHrecdescripcio2(
						"Hemorragia:   " + formatearCampo(valoracionBiopsicosocial.getHvbnhemorragia()));
				report.setHrectipodescri("ValoraciNn Biopsicosocial");
				report.setHrencodigo(imp_valoracion_biopsicosocial);
				report.setHrentipoimpres(2);
				report.setHrenconsulta(consulta.getHcolnumero());
				report.setHredfecharegis(consulta.getHcodfecregistr());
				lstReporte.add(report);

				report = new Chreporte();
				report.setHrecdescripcio("Anemia:   " + formatearCampo(valoracionBiopsicosocial.getHvbcanemia()));
				report.setHrecdescripcio2(
						"Embarazo prolongado:   " + formatearCampo(valoracionBiopsicosocial.getHvbnembpro()));
				report.setHrectipodescri("ValoraciNn Biopsicosocial");
				report.setHrencodigo(imp_valoracion_biopsicosocial);
				report.setHrentipoimpres(2);
				report.setHrenconsulta(consulta.getHcolnumero());
				report.setHredfecharegis(consulta.getHcodfecregistr());
				lstReporte.add(report);

				report = new Chreporte();
				report.setHrecdescripcio(
						"HipertensiNn arterial:   " + formatearCampo(valoracionBiopsicosocial.getHvbchipearte()));
				report.setHrecdescripcio2(
						"Polihidramnios:   " + formatearCampo(valoracionBiopsicosocial.getHvbcpolihidra()));
				report.setHrectipodescri("ValoraciNn Biopsicosocial");
				report.setHrencodigo(imp_valoracion_biopsicosocial);
				report.setHrentipoimpres(2);
				report.setHrenconsulta(consulta.getHcolnumero());
				report.setHredfecharegis(consulta.getHcodfecregistr());
				lstReporte.add(report);

				report = new Chreporte();
				report.setHrecdescripcio(
						"Embarazo Multiple:   " + formatearCampo(valoracionBiopsicosocial.getHvbcembmult()));
				report.setHrecdescripcio2("PresentaciNn de frente o transversa:   "
						+ formatearCampo(valoracionBiopsicosocial.getHvbcprefretra()));
				report.setHrectipodescri("ValoraciNn Biopsicosocial");
				report.setHrencodigo(imp_valoracion_biopsicosocial);
				report.setHrentipoimpres(2);
				report.setHrenconsulta(consulta.getHcolnumero());
				report.setHredfecharegis(consulta.getHcodfecregistr());
				lstReporte.add(report);

				report = new Chreporte();
				report.setHrecdescripcio(
						"IsoinnmunizaciNn:   " + formatearCampo(valoracionBiopsicosocial.getHvbcisoinnmu()));
				report.setHrectipodescri("ValoraciNn Biopsicosocial");
				report.setHrencodigo(imp_valoracion_biopsicosocial);
				report.setHrentipoimpres(1);
				report.setHrenconsulta(consulta.getHcolnumero());
				report.setHredfecharegis(consulta.getHcodfecregistr());
				lstReporte.add(report);

				report = new Chreporte();
				report.setHrecdescripcio("Riesgo Psicosocial");
				report.setHrectipodescri("ValoraciNn Biopsicosocial");
				report.setHrencodigo(imp_valoracion_biopsicosocial);
				report.setHrentipoimpres(1);
				report.setHrenconsulta(consulta.getHcolnumero());
				report.setHredfecharegis(consulta.getHcodfecregistr());
				lstReporte.add(report);

				report = new Chreporte();
				report.setHrecdescripcio(
						"Ansiedad Severa:   " + formatearCampo(valoracionBiopsicosocial.getHvbcansiseve()));
				report.setHrecdescripcio2("Soporte social familiar indadecuado	:   "
						+ formatearCampo(valoracionBiopsicosocial.getHvbcsosofain()));
				report.setHrectipodescri("ValoraciNn Biopsicosocial");
				report.setHrencodigo(imp_valoracion_biopsicosocial);
				report.setHrentipoimpres(2);
				report.setHrenconsulta(consulta.getHcolnumero());
				report.setHredfecharegis(consulta.getHcodfecregistr());
				lstReporte.add(report);

				report = new Chreporte();
				report.setHrecdescripcio("Puntos");
				report.setHrectipodescri("ValoraciNn Biopsicosocial");
				report.setHrencodigo(imp_valoracion_biopsicosocial);
				report.setHrentipoimpres(1);
				report.setHrenconsulta(consulta.getHcolnumero());
				report.setHredfecharegis(consulta.getHcodfecregistr());
				lstReporte.add(report);

				report = new Chreporte();
				report.setHrecdescripcio(
						"Puntos Totales:   " + formatearCampo(valoracionBiopsicosocial.getHvbnpuntos()));
				report.setHrectipodescri("ValoraciNn Biopsicosocial");
				report.setHrencodigo(imp_valoracion_biopsicosocial);
				report.setHrentipoimpres(1);
				report.setHrenconsulta(consulta.getHcolnumero());
				report.setHredfecharegis(consulta.getHcodfecregistr());
				lstReporte.add(report);

			}
		}
	}

	public void imprimirAsesoriaIve(Chconsulta consulta) {

		if (consulta.getChasesoriaive() != null && !consulta.getChasesoriaive().isEmpty()) {

			Chasesoriaive asesoriaIve = null;
			Iterator it = consulta.getChasesoriaive().iterator();
			if (it.hasNext()) {
				asesoriaIve = (Chasesoriaive) it.next();
			}

			if (asesoriaIve != null) {
				Chreporte report = new Chreporte();
				if (asesoriaIve.getHailconsulta() != null) {
					report = new Chreporte();
					report.setHrecdescripcio("Se Informa Sobre");
					report.setHrectipodescri("Asesoria");
					report.setHrencodigo(imp_asesoria_ive);
					report.setHrentipoimpres(1);
					report.setHrenconsulta(consulta.getHcolnumero());
					report.setHredfecharegis(consulta.getHcodfecregistr());
					lstReporte.add(report);

				}

				if (asesoriaIve.getHaicderecho() != null) {
					report = new Chreporte();
					report.setHrecdescripcio("Derechos: " + formatearCampo(asesoriaIve.getHaicderecho()));
					report.setHrectipodescri("Asesoria");
					report.setHrencodigo(imp_asesoria_ive);
					report.setHrentipoimpres(1);
					report.setHrenconsulta(consulta.getHcolnumero());
					report.setHredfecharegis(consulta.getHcodfecregistr());
					lstReporte.add(report);
				}

				if (asesoriaIve.getHaicrespdeci() != null) {
					report = new Chreporte();
					report.setHrecdescripcio(
							"Respeto de su decisiNn: " + formatearCampo(asesoriaIve.getHaicrespdeci()));
					report.setHrectipodescri("Asesoria");
					report.setHrencodigo(imp_asesoria_ive);
					report.setHrentipoimpres(1);
					report.setHrenconsulta(consulta.getHcolnumero());
					report.setHredfecharegis(consulta.getHcodfecregistr());
					lstReporte.add(report);
				}

				if (asesoriaIve.getHaicautodeci() != null) {
					report = new Chreporte();
					report.setHrecdescripcio(
							"AutonomNa de su decisiNn: " + formatearCampo(asesoriaIve.getHaicautodeci()));
					report.setHrectipodescri("Asesoria");
					report.setHrencodigo(imp_asesoria_ive);
					report.setHrentipoimpres(1);
					report.setHrenconsulta(consulta.getHcolnumero());
					report.setHredfecharegis(consulta.getHcodfecregistr());
					lstReporte.add(report);
				}

				if (asesoriaIve.getHaiccontgest() != null) {
					report = new Chreporte();
					report.setHrecdescripcio(
							"Continuar la gestaciNn: " + formatearCampo(asesoriaIve.getHaiccontgest()));
					report.setHrectipodescri("Asesoria");
					report.setHrencodigo(imp_asesoria_ive);
					report.setHrentipoimpres(1);
					report.setHrenconsulta(consulta.getHcolnumero());
					report.setHredfecharegis(consulta.getHcodfecregistr());
					lstReporte.add(report);
				}

				if (asesoriaIve.getHaicadopcion() != null) {
					report = new Chreporte();
					report.setHrecdescripcio("AdopciNn: " + formatearCampo(asesoriaIve.getHaicadopcion()));
					report.setHrectipodescri("Asesoria");
					report.setHrencodigo(imp_asesoria_ive);
					report.setHrentipoimpres(1);
					report.setHrenconsulta(consulta.getHcolnumero());
					report.setHredfecharegis(consulta.getHcodfecregistr());
					lstReporte.add(report);
				}

				if (asesoriaIve.getHaicintvolemb() != null) {
					report = new Chreporte();
					report.setHrecdescripcio(
							"InterrupciNn voluntaria del embarazo: " + formatearCampo(asesoriaIve.getHaicintvolemb()));
					report.setHrectipodescri("Asesoria");
					report.setHrencodigo(imp_asesoria_ive);
					report.setHrentipoimpres(1);
					report.setHrenconsulta(consulta.getHcolnumero());
					report.setHredfecharegis(consulta.getHcodfecregistr());
					lstReporte.add(report);
				}
				if (asesoriaIve.getHailconsulta() != null) {
					report = new Chreporte();
					report.setHrecdescripcio("ObservaciNn");
					report.setHrectipodescri("Asesoria");
					report.setHrencodigo(imp_asesoria_ive);
					report.setHrentipoimpres(1);
					report.setHrenconsulta(consulta.getHcolnumero());
					report.setHredfecharegis(consulta.getHcodfecregistr());
					lstReporte.add(report);
				}
				if (asesoriaIve.getHaicobservacion() != null) {
					report = new Chreporte();
					report.setHrecdescripcio(formatearCampo(asesoriaIve.getHaicobservacion()));
					report.setHrectipodescri("Asesoria");
					report.setHrencodigo(imp_asesoria_ive);
					report.setHrentipoimpres(1);
					report.setHrenconsulta(consulta.getHcolnumero());
					report.setHredfecharegis(consulta.getHcodfecregistr());
					lstReporte.add(report);
				}
			}
		}
	}

	public void imprimirAntecedenteDetallado(Chconsulta consulta) {

		if (consulta.getChantecdetal() != null && !consulta.getChantecdetal().isEmpty()) {

			Chantecdetal antecedentesIve = null;
			Iterator it = consulta.getChantecdetal().iterator();
			if (it.hasNext()) {
				antecedentesIve = (Chantecdetal) it.next();
			}

			if (antecedentesIve != null) {
				Chreporte report = new Chreporte();
				if (antecedentesIve.getHadcgrupsang() != null) {

					report = new Chreporte();
					report.setHrecdescripcio("Grupo Sangineo");
					report.setHrectipodescri("Antecedetes Generales");
					report.setHrencodigo(imp_antecendes_detallado);
					report.setHrentipoimpres(1);
					report.setHrenconsulta(consulta.getHcolnumero());
					report.setHredfecharegis(consulta.getHcodfecregistr());
					lstReporte.add(report);

					if (antecedentesIve.getHadcgrupsang() != null) {
						String rh = "";
						report = new Chreporte();
						if ("NS".equals(antecedentesIve.getHadcgrupsang())) {
							report.setHrecdescripcio("Grupo Sanguineo: " + "No Sabe");
							report.setHrecdescripcio2("");
							report.setHrecdescripcio3("");
						} else {
							report.setHrecdescripcio("Grupo Sanguineo: " + antecedentesIve.getHadcgrupsang());
							if ("P".equals(antecedentesIve.getHadcrh())) {
								rh = "Positivo";
							} else {
								rh = "Negativo";
							}
							report.setHrecdescripcio2("RH: " + rh);
							if ("N".equals(antecedentesIve.getHadcrh())) {
								report.setHrecdescripcio3("IsoinmunizaciNn en parto o aborto anterior: "
										+ formatearCampo(antecedentesIve.getHadcisoinabort()));
							} else {
								report.setHrecdescripcio3("");
							}
						}
						report.setHrectipodescri("Antecedetes Generales");
						report.setHrencodigo(imp_antecendes_detallado);
						report.setHrentipoimpres(5);
						report.setHrenconsulta(consulta.getHcolnumero());
						report.setHredfecharegis(consulta.getHcodfecregistr());
						lstReporte.add(report);
					}

					report = new Chreporte();
					report.setHrecdescripcio("Antecedentes especNficos");
					report.setHrecdescripcio2(formatearCampo(antecedentesIve.getHadcantenuev()));
					report.setHrecdescripcio3("");
					report.setHrectipodescri("Antecedetes Generales");
					report.setHrencodigo(imp_antecendes_detallado);
					report.setHrentipoimpres(5);
					report.setHrenconsulta(consulta.getHcolnumero());
					report.setHredfecharegis(consulta.getHcodfecregistr());
					lstReporte.add(report);

					if (antecedentesIve.getHadcantepato() != null) {
						report = new Chreporte();
						report.setHrecdescripcio(
								"Antecedentes Patologicos: " + formatearCampo(antecedentesIve.getHadcantepato()));
						if ("S".equals(antecedentesIve.getHadcantepato())) {
							report.setHrecdescripcio2(
									"DescripciNn: " + formatearCampo(antecedentesIve.getHadcpatdes()));
						} else {
							report.setHrecdescripcio2("");
						}
						report.setHrectipodescri("Antecedetes Generales");
						report.setHrencodigo(imp_antecendes_detallado);
						report.setHrentipoimpres(2);
						report.setHrenconsulta(consulta.getHcolnumero());
						report.setHredfecharegis(consulta.getHcodfecregistr());
						lstReporte.add(report);

						if ("S".equals(antecedentesIve.getHadcantepato())) {
							report = new Chreporte();
							report.setHrecdescripcio(
									"Tuberculosis : " + formatearCampo(antecedentesIve.getHadctbcpato()));
							report.setHrectipodescri("Antecedetes Generales");
							report.setHrencodigo(imp_antecendes_detallado);
							report.setHrentipoimpres(1);
							report.setHrenconsulta(consulta.getHcolnumero());
							report.setHredfecharegis(consulta.getHcodfecregistr());
							lstReporte.add(report);

							report = new Chreporte();
							report.setHrecdescripcio(
									"Diabetes mellitus: " + formatearCampo(antecedentesIve.getHadcdiabpato()));
							report.setHrectipodescri("Antecedetes Generales");
							report.setHrencodigo(imp_antecendes_detallado);
							report.setHrentipoimpres(1);
							report.setHrenconsulta(consulta.getHcolnumero());
							report.setHredfecharegis(consulta.getHcodfecregistr());
							lstReporte.add(report);

							report = new Chreporte();
							report.setHrecdescripcio(
									"HipertensiNn arterial : " + formatearCampo(antecedentesIve.getHadchipepato()));
							report.setHrectipodescri("Antecedetes Generales");
							report.setHrencodigo(imp_antecendes_detallado);
							report.setHrentipoimpres(1);
							report.setHrenconsulta(consulta.getHcolnumero());
							report.setHredfecharegis(consulta.getHcodfecregistr());
							lstReporte.add(report);

							report = new Chreporte();
							report.setHrecdescripcio(
									"Preclampsia : " + formatearCampo(antecedentesIve.getHadcprecpato()));
							report.setHrectipodescri("Antecedetes Generales");
							report.setHrencodigo(imp_antecendes_detallado);
							report.setHrentipoimpres(1);
							report.setHrenconsulta(consulta.getHcolnumero());
							report.setHredfecharegis(consulta.getHcodfecregistr());
							lstReporte.add(report);

							report = new Chreporte();
							report.setHrecdescripcio(
									"Eclampsia : " + formatearCampo(antecedentesIve.getHadceclapato()));
							report.setHrectipodescri("Antecedetes Generales");
							report.setHrencodigo(imp_antecendes_detallado);
							report.setHrentipoimpres(1);
							report.setHrenconsulta(consulta.getHcolnumero());
							report.setHredfecharegis(consulta.getHcodfecregistr());
							lstReporte.add(report);

							report = new Chreporte();
							report.setHrecdescripcio(
									"Infertilidad : " + formatearCampo(antecedentesIve.getHadciferpato()));
							report.setHrectipodescri("Antecedetes Generales");
							report.setHrencodigo(imp_antecendes_detallado);
							report.setHrentipoimpres(1);
							report.setHrenconsulta(consulta.getHcolnumero());
							report.setHredfecharegis(consulta.getHcodfecregistr());
							lstReporte.add(report);

							report = new Chreporte();
							report.setHrecdescripcio(
									"CardiopatNa : " + formatearCampo(antecedentesIve.getHadccardpato()));
							report.setHrectipodescri("Antecedetes Generales");
							report.setHrencodigo(imp_antecendes_detallado);
							report.setHrentipoimpres(1);
							report.setHrenconsulta(consulta.getHcolnumero());
							report.setHredfecharegis(consulta.getHcodfecregistr());
							lstReporte.add(report);

							report = new Chreporte();
							report.setHrecdescripcio(
									"NefropatNa : " + formatearCampo(antecedentesIve.getHadcnefrpato()));
							report.setHrectipodescri("Antecedetes Generales");
							report.setHrencodigo(imp_antecendes_detallado);
							report.setHrentipoimpres(1);
							report.setHrenconsulta(consulta.getHcolnumero());
							report.setHredfecharegis(consulta.getHcodfecregistr());
							lstReporte.add(report);

						}

					}

					if (antecedentesIve.getHadcanteqx() != null) {
						if (antecedentesIve.getHadcanteqx() != null) {
							report = new Chreporte();
							report.setHrecdescripcio(
									"Antecedentes Quirurgico: " + formatearCampo(antecedentesIve.getHadcanteqx()));
							if ("S".equals(antecedentesIve.getHadcanteqx())) {
								report.setHrecdescripcio2(
										"DescripciNn: " + formatearCampo(antecedentesIve.getHadcquirdes()));
							} else {
								report.setHrecdescripcio2("");
							}
							report.setHrectipodescri("Antecedetes Generales");
							report.setHrencodigo(imp_antecendes_detallado);
							report.setHrentipoimpres(2);
							report.setHrenconsulta(consulta.getHcolnumero());
							report.setHredfecharegis(consulta.getHcodfecregistr());
							lstReporte.add(report);

							if ("S".equals(antecedentesIve.getHadcanteqx())) {
								report = new Chreporte();
								report.setHrecdescripcio(
										"CirugNa genitourinaria: " + formatearCampo(antecedentesIve.getHadcgeurqx()));
								report.setHrectipodescri("Antecedetes Generales");
								report.setHrencodigo(imp_antecendes_detallado);
								report.setHrentipoimpres(1);
								report.setHrenconsulta(consulta.getHcolnumero());
								report.setHredfecharegis(consulta.getHcodfecregistr());
								lstReporte.add(report);
							}
						}
					}

					if (antecedentesIve.getHadcantetoxi() != null) {
						report = new Chreporte();
						report.setHrecdescripcio(
								"Antecedentes TNxicos: " + formatearCampo(antecedentesIve.getHadcantetoxi()));
						if ("S".equals(antecedentesIve.getHadcantetoxi())) {
							report.setHrecdescripcio2(
									"DescripciNn: " + formatearCampo(antecedentesIve.getHadctoxdes()));
						} else {
							report.setHrecdescripcio2("");
						}
						report.setHrectipodescri("Antecedetes Generales");
						report.setHrencodigo(imp_antecendes_detallado);
						report.setHrentipoimpres(2);
						report.setHrenconsulta(consulta.getHcolnumero());
						report.setHredfecharegis(consulta.getHcodfecregistr());
						lstReporte.add(report);
						if ("S".equals(antecedentesIve.getHadcantetoxi())) {
							report = new Chreporte();
							report.setHrecdescripcio(
									"Fumadora activas: " + formatearCampo(antecedentesIve.getHadcfumacttox()));
							report.setHrectipodescri("Antecedetes Generales");
							report.setHrencodigo(imp_antecendes_detallado);
							report.setHrentipoimpres(2);
							report.setHrenconsulta(consulta.getHcolnumero());
							report.setHredfecharegis(consulta.getHcodfecregistr());
							lstReporte.add(report);

							report = new Chreporte();
							report.setHrecdescripcio(
									"Fumadora pasiva: " + formatearCampo(antecedentesIve.getHadcfumpastox()));
							report.setHrectipodescri("Antecedetes Generales");
							report.setHrencodigo(imp_antecendes_detallado);
							report.setHrentipoimpres(1);
							report.setHrenconsulta(consulta.getHcolnumero());
							report.setHredfecharegis(consulta.getHcodfecregistr());
							lstReporte.add(report);

							report = new Chreporte();
							report.setHrecdescripcio(
									"Sustancias Psicoactivas: " + formatearCampo(antecedentesIve.getHadcsuspsitox()));
							report.setHrectipodescri("Antecedetes Generales");
							report.setHrencodigo(imp_antecendes_detallado);
							report.setHrentipoimpres(1);
							report.setHrenconsulta(consulta.getHcolnumero());
							report.setHredfecharegis(consulta.getHcodfecregistr());
							lstReporte.add(report);

							report = new Chreporte();
							report.setHrecdescripcio("Alcohol: " + formatearCampo(antecedentesIve.getHadcalctox()));
							report.setHrectipodescri("Antecedetes Generales");
							report.setHrencodigo(imp_antecendes_detallado);
							report.setHrentipoimpres(1);
							report.setHrenconsulta(consulta.getHcolnumero());
							report.setHredfecharegis(consulta.getHcodfecregistr());
							lstReporte.add(report);

						}

					}

					if (antecedentesIve.getHadcantealer() != null) {
						report = new Chreporte();
						report.setHrecdescripcio(
								"Antecedentes AlNrgicos: " + formatearCampo(antecedentesIve.getHadcantealer()));
						if ("S".equals(antecedentesIve.getHadcantealer())) {
							report.setHrecdescripcio2(
									"DescripciNn: " + formatearCampo(antecedentesIve.getHadcantaledes()));
						} else {
							report.setHrecdescripcio2("");
						}
						report.setHrectipodescri("Antecedetes Generales");
						report.setHrencodigo(imp_antecendes_detallado);
						report.setHrentipoimpres(2);
						report.setHrenconsulta(consulta.getHcolnumero());
						report.setHredfecharegis(consulta.getHcodfecregistr());
						lstReporte.add(report);

					}

					if (antecedentesIve.getHadcantetran() != null) {
						report = new Chreporte();
						report.setHrecdescripcio(
								"Antecedentes Transfusionales:" + formatearCampo(antecedentesIve.getHadcantetran()));
						if ("S".equals(antecedentesIve.getHadcantetran())) {
							report.setHrecdescripcio2(
									"DescripciNn: " + formatearCampo(antecedentesIve.getHadcanttrades()));
						} else {
							report.setHrecdescripcio2("");
						}
						report.setHrectipodescri("Antecedetes Generales");
						report.setHrencodigo(imp_antecendes_detallado);
						report.setHrentipoimpres(2);
						report.setHrenconsulta(consulta.getHcolnumero());
						report.setHredfecharegis(consulta.getHcodfecregistr());
						lstReporte.add(report);

					}

					if (antecedentesIve.getHadcantits() != null) {
						report = new Chreporte();
						report.setHrecdescripcio("Antecedentes ITS:" + formatearCampo(antecedentesIve.getHadcantits()));
						if ("S".equals(antecedentesIve.getHadcantits())) {
							report.setHrecdescripcio2(
									"DescripciNn: " + formatearCampo(antecedentesIve.getHadcantitsdes()));
						} else {
							report.setHrecdescripcio2("");
						}
						report.setHrectipodescri("Antecedetes Generales");
						report.setHrencodigo(imp_antecendes_detallado);
						report.setHrentipoimpres(2);
						report.setHrenconsulta(consulta.getHcolnumero());
						report.setHredfecharegis(consulta.getHcodfecregistr());
						lstReporte.add(report);

					}

					if (antecedentesIve.getHadcantefarm() != null) {
						report = new Chreporte();
						report.setHrecdescripcio(
								"Antecedentes FarmacolNgicos:" + formatearCampo(antecedentesIve.getHadcantefarm()));
						if ("S".equals(antecedentesIve.getHadcantefarm())) {
							report.setHrecdescripcio2(
									"DescripciNn: " + formatearCampo(antecedentesIve.getHadcantfardes()));
						} else {
							report.setHrecdescripcio2("");
						}
						report.setHrectipodescri("Antecedetes Generales");
						report.setHrencodigo(imp_antecendes_detallado);
						report.setHrentipoimpres(2);
						report.setHrenconsulta(consulta.getHcolnumero());
						report.setHredfecharegis(consulta.getHcodfecregistr());
						lstReporte.add(report);

					}

					if (antecedentesIve.getHadcantetrau() != null) {
						report = new Chreporte();
						report.setHrecdescripcio(
								"Antecedentes TraumNticos:" + formatearCampo(antecedentesIve.getHadcantetrau()));
						if ("S".equals(antecedentesIve.getHadcantetrau())) {
							report.setHrecdescripcio2(
									"DescripciNn: " + formatearCampo(antecedentesIve.getHadctraantdesc()));

						} else {
							report.setHrecdescripcio2("");
						}
						report.setHrectipodescri("Antecedetes Generales");
						report.setHrencodigo(imp_antecendes_detallado);
						report.setHrentipoimpres(2);
						report.setHrenconsulta(consulta.getHcolnumero());
						report.setHredfecharegis(consulta.getHcodfecregistr());
						lstReporte.add(report);

					}

					if (antecedentesIve.getHadcantefami() != null) {
						report = new Chreporte();
						report.setHrecdescripcio(
								"Antecedentes Familiares: " + formatearCampo(antecedentesIve.getHadcantefami()));
						if ("S".equals(antecedentesIve.getHadcantefami())) {
							report.setHrecdescripcio2(
									"DescripciNn: " + formatearCampo(antecedentesIve.getHadcfamdes()));
						} else {
							report.setHrecdescripcio2("");
						}
						report.setHrectipodescri("Antecedetes Generales");
						report.setHrencodigo(imp_antecendes_detallado);
						report.setHrentipoimpres(2);
						report.setHrenconsulta(consulta.getHcolnumero());
						report.setHredfecharegis(consulta.getHcodfecregistr());
						lstReporte.add(report);

						if ("S".equals(antecedentesIve.getHadcantefami())) {
							report = new Chreporte();
							report.setHrecdescripcio("TBC: " + formatearCampo(antecedentesIve.getHadctbcfami()));
							report.setHrectipodescri("Antecedetes Generales");
							report.setHrencodigo(imp_antecendes_detallado);
							report.setHrentipoimpres(1);
							report.setHrenconsulta(consulta.getHcolnumero());
							report.setHredfecharegis(consulta.getHcodfecregistr());
							lstReporte.add(report);

							report = new Chreporte();
							report.setHrecdescripcio("Diabetes: " + formatearCampo(antecedentesIve.getHadcdiabfami()));
							report.setHrectipodescri("Antecedetes Generales");
							report.setHrencodigo(imp_antecendes_detallado);
							report.setHrentipoimpres(1);
							report.setHrenconsulta(consulta.getHcolnumero());
							report.setHredfecharegis(consulta.getHcodfecregistr());
							lstReporte.add(report);

							report = new Chreporte();
							report.setHrecdescripcio(
									"HipertensiNn : " + formatearCampo(antecedentesIve.getHadchipefami()));
							report.setHrectipodescri("Antecedetes Generales");
							report.setHrencodigo(imp_antecendes_detallado);
							report.setHrentipoimpres(1);
							report.setHrenconsulta(consulta.getHcolnumero());
							report.setHredfecharegis(consulta.getHcodfecregistr());
							lstReporte.add(report);

							report = new Chreporte();
							report.setHrecdescripcio(
									"Preclampsia : " + formatearCampo(antecedentesIve.getHadcprecfami()));
							report.setHrectipodescri("Antecedetes Generales");
							report.setHrencodigo(imp_antecendes_detallado);
							report.setHrentipoimpres(1);
							report.setHrenconsulta(consulta.getHcolnumero());
							report.setHredfecharegis(consulta.getHcodfecregistr());
							lstReporte.add(report);

							report = new Chreporte();
							report.setHrecdescripcio(
									"Eclampsia : " + formatearCampo(antecedentesIve.getHadceclafami()));
							report.setHrectipodescri("Antecedetes Generales");
							report.setHrencodigo(imp_antecendes_detallado);
							report.setHrentipoimpres(1);
							report.setHrenconsulta(consulta.getHcolnumero());
							report.setHredfecharegis(consulta.getHcodfecregistr());
							lstReporte.add(report);

						}
					}

					if (antecedentesIve.getHadcultpruvih() != null && antecedentesIve.getHadcultprusif() != null) {
						String fechaUltPruebaVIH = "";
						String opcionesVPH = "";
						String fechaUltPruebaSifilis = "";
						String opcionesSifilis = "";
						if ("NU".equals(antecedentesIve.getHadcultpruvih())) {
							fechaUltPruebaVIH = "Nunca";
						} else if ("HMEA".equals(antecedentesIve.getHadcultpruvih())) {
							fechaUltPruebaVIH = "Hace menos de un aNo";
						} else if ("HMAA".equals(antecedentesIve.getHadcultpruvih())) {
							fechaUltPruebaVIH = "Hace mNs de un aNo";
						} else if ("NR".equals(antecedentesIve.getHadcultpruvih())) {
							fechaUltPruebaVIH = "No Recuerda\"";
						}

						if ("RE".equals(antecedentesIve.getHadcresultpruvih())) {
							opcionesVPH = "Reactivo";
						} else if ("NR".equals(antecedentesIve.getHadcresultpruvih())) {
							opcionesVPH = "No Reactivo";
						} else if ("IN".equals(antecedentesIve.getHadcresultpruvih())) {
							opcionesVPH = "Indeterminado";
						}

						if ("NU".equals(antecedentesIve.getHadcultprusif())) {
							fechaUltPruebaSifilis = "Nunca";
						} else if ("HMEA".equals(antecedentesIve.getHadcultprusif())) {
							fechaUltPruebaSifilis = "Hace menos de un aNo";
						} else if ("HMAA".equals(antecedentesIve.getHadcultprusif())) {
							fechaUltPruebaSifilis = "Hace mNs de un aNo";
						} else if ("NR".equals(antecedentesIve.getHadcultprusif())) {
							fechaUltPruebaSifilis = "No Recuerda\"";
						}

						if ("RE".equals(antecedentesIve.getHadcresultprusif())) {
							opcionesSifilis = "Reactivo";
						} else if ("NR".equals(antecedentesIve.getHadcresultprusif())) {
							opcionesSifilis = "No Reactivo";
						} else if ("IN".equals(antecedentesIve.getHadcresultprusif())) {
							opcionesSifilis = "Indeterminado";
						}

						report = new Chreporte();
						report.setHrecdescripcio("Fecha ultima prueba de VIH : " + fechaUltPruebaVIH);
						if ("HMEA".equals(antecedentesIve.getHadcultpruvih())
								|| "HMAA".equals(antecedentesIve.getHadcultpruvih())) {
							report.setHrecdescripcio2("Opciones:" + opcionesVPH);
						} else {
							report.setHrecdescripcio2("");
						}
						report.setHrectipodescri("Antecedetes Generales");
						report.setHrencodigo(imp_antecendes_detallado);
						report.setHrentipoimpres(2);
						report.setHrenconsulta(consulta.getHcolnumero());
						report.setHredfecharegis(consulta.getHcodfecregistr());
						lstReporte.add(report);

						report = new Chreporte();
						report.setHrecdescripcio("Fecha Nltima prueba sNfilis : " + fechaUltPruebaSifilis);
						if ("HMEA".equals(antecedentesIve.getHadcultprusif())
								|| "HMAA".equals(antecedentesIve.getHadcultprusif())) {
							report.setHrecdescripcio2("Opciones:" + opcionesSifilis);
						} else {
							report.setHrecdescripcio2("");
						}
						report.setHrectipodescri("Antecedetes Generales");
						report.setHrencodigo(imp_antecendes_detallado);
						report.setHrentipoimpres(2);
						report.setHrenconsulta(consulta.getHcolnumero());
						report.setHredfecharegis(consulta.getHcodfecregistr());
						lstReporte.add(report);

					}

					if (antecedentesIve.getHadcprurapcon() != null) {
						report = new Chreporte();
						report.setHrecdescripcio("Se realizan pruebas rNpidas en la consulta: "
								+ formatearCampo(antecedentesIve.getHadcprurapcon()));
						report.setHrectipodescri("Antecedetes Generales");
						report.setHrencodigo(imp_antecendes_detallado);
						report.setHrentipoimpres(1);
						report.setHrenconsulta(consulta.getHcolnumero());
						report.setHredfecharegis(consulta.getHcodfecregistr());
						lstReporte.add(report);
					}

					if (antecedentesIve.getHadcembarazo() != null) {
						String embarazo = "";
						if (antecedentesIve.getHadcembarazo().equals("P")) {
							embarazo = "Positivo";
						}
						if (antecedentesIve.getHadcembarazo().equals("N")) {
							embarazo = "Negativo";
						}

						report = new Chreporte();
						report.setHrecdescripcio("Embarazo : " + embarazo);
						report.setHrectipodescri("Antecedetes Generales");
						report.setHrencodigo(imp_antecendes_detallado);
						report.setHrentipoimpres(1);
						report.setHrenconsulta(consulta.getHcolnumero());
						report.setHredfecharegis(consulta.getHcodfecregistr());
						lstReporte.add(report);
					}

					if (antecedentesIve.getHadcsifilis() != null) {
						String sifilis = "";
						if (antecedentesIve.getHadcsifilis().equals("P")) {
							sifilis = "Reactivo";
						}
						if (antecedentesIve.getHadcsifilis().equals("N")) {
							sifilis = "No Reactivo";
						}

						report = new Chreporte();
						report.setHrecdescripcio("Sifilis : " + sifilis);
						report.setHrectipodescri("Antecedetes Generales");
						report.setHrencodigo(imp_antecendes_detallado);
						report.setHrentipoimpres(1);
						report.setHrenconsulta(consulta.getHcolnumero());
						report.setHredfecharegis(consulta.getHcodfecregistr());
						lstReporte.add(report);
					}

					if (antecedentesIve.getHadcvih() != null) {
						String vih = "";
						if (antecedentesIve.getHadcvih().equals("P")) {
							vih = "Reactivo";
						}
						if (antecedentesIve.getHadcvih().equals("N")) {
							vih = "No Reactivo";
						}

						report = new Chreporte();
						report.setHrecdescripcio("Vih : " + vih);
						report.setHrectipodescri("Antecedetes Generales");
						report.setHrencodigo(imp_antecendes_detallado);
						report.setHrentipoimpres(1);
						report.setHrenconsulta(consulta.getHcolnumero());
						report.setHredfecharegis(consulta.getHcodfecregistr());
						lstReporte.add(report);
					}

				}

				else {
					if (antecedentesIve.getHadcantenuev() != null) {
						report = new Chreporte();
						String valor = "No";
						if (antecedentesIve.getHadcantenuev().equals("S")) {
							valor = "Si";

						}
						report.setHrecdescripcio("Tiene Antecedentes Nuevos : " + valor);
						report.setHrectipodescri("Antecedetes Detallados");
						report.setHrencodigo(imp_antecendes_detallado);
						report.setHrentipoimpres(1);
						report.setHrenconsulta(consulta.getHcolnumero());
						report.setHredfecharegis(consulta.getHcodfecregistr());
						lstReporte.add(report);
					}
					if (antecedentesIve.getHadcantenuev() == null || "S".equals(antecedentesIve.getHadcantenuev())) {

						if (antecedentesIve.getHadcantepato() != null) {

							report = new Chreporte();
							String refiere = "No Refiere";
							if (antecedentesIve.getHadcantepato().equals("S")) {
								report.setHrecdescripcio("Patologicos : " + antecedentesIve.getHadcpatdes());
							} else {
								report.setHrecdescripcio("Patologicos : " + refiere);
							}

							report.setHrectipodescri("Antecedetes Detallados");
							report.setHrencodigo(imp_antecendes_detallado);
							report.setHrentipoimpres(1);
							report.setHrenconsulta(consulta.getHcolnumero());
							report.setHredfecharegis(consulta.getHcodfecregistr());
							lstReporte.add(report);

							report = new Chreporte();
							String endoundo = "No";
							String endotrecua = "No";
							String epi = "No";
							if (antecedentesIve.getHadcendoundo() != null) {
								endoundo = "Si";
							}
							if (antecedentesIve.getHadcendotrcu() != null) {
								endotrecua = "Si";
							}
							if (antecedentesIve.getHadcepi() != null) {
								epi = "Si";
							}
							report.setHrecdescripcio("Endometriosis I N II : " + endoundo);
							report.setHrecdescripcio2("Endometriosis III N IV : " + endotrecua);
							report.setHrecdescripcio3("EPI (Enfermedad PNlvica Inflamatoria) : " + epi);
							report.setHrectipodescri("Antecedetes Detallados");
							report.setHrencodigo(imp_antecendes_detallado);
							report.setHrentipoimpres(5);
							report.setHrenconsulta(consulta.getHcolnumero());
							report.setHredfecharegis(consulta.getHcodfecregistr());
							lstReporte.add(report);

						}
						if (antecedentesIve.getHadcanteqx() != null) {

							report = new Chreporte();
							if (antecedentesIve.getHadcanteqx().equals("S")) {
								report.setHrecdescripcio("QuirNrgicos : " + antecedentesIve.getHadcquirdes());
							} else {
								report.setHrecdescripcio("QuirNrgicos : No Refiere");
							}

							report.setHrectipodescri("Antecedetes Detallados");
							report.setHrencodigo(imp_antecendes_detallado);
							report.setHrentipoimpres(1);
							report.setHrenconsulta(consulta.getHcolnumero());
							report.setHredfecharegis(consulta.getHcodfecregistr());
							lstReporte.add(report);

							report = new Chreporte();
							String ciruAbd = "No";
							String laparoscopia = "No";
							if (antecedentesIve.getHadccirabd() != null) {
								ciruAbd = "Si";
							}
							if (antecedentesIve.getHadclapparosc() != null) {
								laparoscopia = "Si";
							}
							report.setHrecdescripcio("CirugNa Abdominal : " + ciruAbd);
							report.setHrecdescripcio2("Laparoscopia : " + laparoscopia);
							report.setHrectipodescri("Antecedetes Detallados");
							report.setHrencodigo(imp_antecendes_detallado);
							report.setHrentipoimpres(5);
							report.setHrenconsulta(consulta.getHcolnumero());
							report.setHredfecharegis(consulta.getHcodfecregistr());
							lstReporte.add(report);

						}
						if (antecedentesIve.getHadcantetoxi() != null) {

							report = new Chreporte();
							if (antecedentesIve.getHadcantetoxi().equals("S")) {
								report.setHrecdescripcio("TNxicos : " + antecedentesIve.getHadctoxdes());
							} else {
								report.setHrecdescripcio("TNxicos : No Refiere");
							}
							report.setHrectipodescri("Antecedetes Detallados");
							report.setHrencodigo(imp_antecendes_detallado);
							report.setHrentipoimpres(1);
							report.setHrenconsulta(consulta.getHcolnumero());
							report.setHredfecharegis(consulta.getHcodfecregistr());
							lstReporte.add(report);

						}
						if (antecedentesIve.getHadcantealer() != null) {

							report = new Chreporte();
							if (antecedentesIve.getHadcantealer().equals("S")) {
								report.setHrecdescripcio("AlNrgicos : " + antecedentesIve.getHadcaledes());
							} else {
								report.setHrecdescripcio("AlNrgicos : No Refiere");
							}

							report.setHrectipodescri("Antecedetes Detallados");
							report.setHrencodigo(imp_antecendes_detallado);
							report.setHrentipoimpres(1);
							report.setHrenconsulta(consulta.getHcolnumero());
							report.setHredfecharegis(consulta.getHcodfecregistr());
							lstReporte.add(report);

						}
						if (antecedentesIve.getHadcantefami() != null) {

							report = new Chreporte();
							if (antecedentesIve.getHadcantefami().equals("S")) {
								report.setHrecdescripcio("Familiares : " + antecedentesIve.getHadcfamdes());
							} else {
								report.setHrecdescripcio("Familiares : No Refiere");
							}

							report.setHrectipodescri("Antecedetes Detallados");
							report.setHrencodigo(imp_antecendes_detallado);
							report.setHrentipoimpres(1);
							report.setHrenconsulta(consulta.getHcolnumero());
							report.setHredfecharegis(consulta.getHcodfecregistr());
							lstReporte.add(report);

							report = new Chreporte();
							String infFami = "No";
							String problemasGenerales = "No";
							if (antecedentesIve.getHadcinffam() != null) {
								infFami = "Si";
							}
							if (antecedentesIve.getHadcprogenfa() != null) {
								problemasGenerales = "Si";
							}
							report.setHrecdescripcio("Infertilidad familiar : " + infFami);
							report.setHrecdescripcio2("Problemas genNticos Familiares : " + problemasGenerales);
							report.setHrectipodescri("Antecedetes Detallados");
							report.setHrencodigo(imp_antecendes_detallado);
							report.setHrentipoimpres(5);
							report.setHrenconsulta(consulta.getHcolnumero());
							report.setHredfecharegis(consulta.getHcodfecregistr());
							lstReporte.add(report);

						}
						if (antecedentesIve.getHadcantetran() != null) {

							report = new Chreporte();
							if (antecedentesIve.getHadcantetran().equals("S")) {
								report.setHrecdescripcio("Transfusionales : " + antecedentesIve.getHadctransdes());
							} else {
								report.setHrecdescripcio("Transfusionales : No Refiere");
							}

							report.setHrectipodescri("Antecedetes Detallados");
							report.setHrencodigo(imp_antecendes_detallado);
							report.setHrentipoimpres(1);
							report.setHrenconsulta(consulta.getHcolnumero());
							report.setHredfecharegis(consulta.getHcodfecregistr());
							lstReporte.add(report);

						}
						if (antecedentesIve.getHadcantits() != null) {

							report = new Chreporte();
							if (antecedentesIve.getHadcantits().equals("S")) {
								report.setHrecdescripcio("ITS : " + antecedentesIve.getHadcitsdes());
							} else {
								report.setHrecdescripcio("ITS : No Refiere");
							}

							report.setHrectipodescri("Antecedetes Detallados");
							report.setHrencodigo(imp_antecendes_detallado);
							report.setHrentipoimpres(1);
							report.setHrenconsulta(consulta.getHcolnumero());
							report.setHredfecharegis(consulta.getHcodfecregistr());
							lstReporte.add(report);

						}
						if (antecedentesIve.getHadcantefarm() != null) {

							report = new Chreporte();
							if (antecedentesIve.getHadcantefarm().equals("S")) {
								report.setHrecdescripcio("FarmacolNgicos : " + antecedentesIve.getHadcfarmdes());
							} else {
								report.setHrecdescripcio("FarmacolNgicos : No Refiere");
							}

							report.setHrectipodescri("Antecedetes Detallados");
							report.setHrencodigo(imp_antecendes_detallado);
							report.setHrentipoimpres(1);
							report.setHrenconsulta(consulta.getHcolnumero());
							report.setHredfecharegis(consulta.getHcodfecregistr());
							lstReporte.add(report);

						}
						if (antecedentesIve.getHadcantetrau() != null) {

							report = new Chreporte();
							if (antecedentesIve.getHadcantetrau().equals("S")) {
								report.setHrecdescripcio("TraumNticos : " + antecedentesIve.getHadctraudes());
							} else {
								report.setHrecdescripcio("TraumNticos : No Refiere");
							}

							report.setHrectipodescri("Antecedetes Detallados");
							report.setHrencodigo(imp_antecendes_detallado);
							report.setHrentipoimpres(1);
							report.setHrenconsulta(consulta.getHcolnumero());
							report.setHredfecharegis(consulta.getHcodfecregistr());
							lstReporte.add(report);

						}
						if (antecedentesIve.getHadcantegen() != null) {

							report = new Chreporte();
							if (antecedentesIve.getHadcantegen().equals("S")) {
								report.setHrecdescripcio("Geneticos : " + antecedentesIve.getHadcgendes());
							} else {
								report.setHrecdescripcio("Geneticos : No Refiere");
							}

							report.setHrectipodescri("Antecedetes Detallados");
							report.setHrencodigo(imp_antecendes_detallado);
							report.setHrentipoimpres(1);
							report.setHrenconsulta(consulta.getHcolnumero());
							report.setHredfecharegis(consulta.getHcodfecregistr());
							lstReporte.add(report);

						}
						if (antecedentesIve.getHadcantemas() != null) {

							report = new Chreporte();
							if (antecedentesIve.getHadcantemas().equals("S")) {
								report.setHrecdescripcio("Masculinos : " + antecedentesIve.getHadcmasdes());
							} else {
								report.setHrecdescripcio("Masculinos : No Refiere");
							}

							report.setHrectipodescri("Antecedetes Detallados");
							report.setHrencodigo(imp_antecendes_detallado);
							report.setHrentipoimpres(1);
							report.setHrenconsulta(consulta.getHcolnumero());
							report.setHredfecharegis(consulta.getHcodfecregistr());
							lstReporte.add(report);

							report = new Chreporte();
							String paternidad = "No";
							String orquitis = "No";
							String cripto = "No";
							String traumaTes = "No";
							String cirTes = "No";
							String quim = "No";
							String ITS = "No";
							String ocupac = "No";
							String disEre = "No";
							String eyaPres = "No";
							if (antecedentesIve.getHadcpaternidad() != null) {
								paternidad = "Si";
							}
							if (antecedentesIve.getHadcorquitis() != null) {
								orquitis = "Si";
							}
							if (antecedentesIve.getHadccriporquidea() != null) {
								cripto = "Si";
							}
							if (antecedentesIve.getHadctrautest() != null) {
								traumaTes = "Si";
							}
							if (antecedentesIve.getHadccirtest() != null) {
								cirTes = "Si";
							}
							if (antecedentesIve.getHadcquimrad() != null) {
								quim = "Si";
							}
							if (antecedentesIve.getHadcitsmas() != null) {
								ITS = "Si";
							}
							if (antecedentesIve.getHadcocuparies() != null) {
								ocupac = "Si";
							}
							if (antecedentesIve.getHadcdiserectil() != null) {
								disEre = "Si";
							}
							if (antecedentesIve.getHadceyaprecoz() != null) {
								eyaPres = "Si";
							}

							report.setHrecdescripcio("Paternidad : " + paternidad);
							report.setHrecdescripcio2("Orquitis : " + orquitis);
							report.setHrecdescripcio3("Criptorquidia : " + cripto);
							report.setHrecdescripcio4("Trauma Testicular : " + traumaTes);
							report.setHrectipodescri("Antecedetes Detallados");
							report.setHrencodigo(imp_antecendes_detallado);
							report.setHrentipoimpres(4);
							report.setHrenconsulta(consulta.getHcolnumero());
							report.setHredfecharegis(consulta.getHcodfecregistr());
							lstReporte.add(report);

							report = new Chreporte();

							report.setHrecdescripcio("CirugNa Testicular : " + cirTes);
							report.setHrecdescripcio2("ITS : " + ITS);
							report.setHrecdescripcio3("Quimio / Radioterapia : " + quim);
							report.setHrecdescripcio4("Ocupacionales de riesgo : " + ocupac);
							report.setHrectipodescri("Antecedetes Detallados");
							report.setHrencodigo(imp_antecendes_detallado);
							report.setHrentipoimpres(4);
							report.setHrenconsulta(consulta.getHcolnumero());
							report.setHredfecharegis(consulta.getHcodfecregistr());
							lstReporte.add(report);

							report = new Chreporte();

							report.setHrecdescripcio("DisfunciNn erNctil : " + disEre);
							report.setHrecdescripcio2("EyaculaciNn precoz : " + eyaPres);
							report.setHrectipodescri("Antecedetes Detallados");
							report.setHrencodigo(imp_antecendes_detallado);
							report.setHrentipoimpres(4);
							report.setHrenconsulta(consulta.getHcolnumero());
							report.setHredfecharegis(consulta.getHcodfecregistr());
							lstReporte.add(report);

						}
					}
				}
			}
		}
	}

	public void imprimirAntecedenteDetalladoFertilidad(Chconsulta consulta) {

		if (consulta.getChantecdetal() != null && !consulta.getChantecdetal().isEmpty()) {

			Chantecdetal antecedentesFertilidad = null;
			Iterator it = consulta.getChantecdetal().iterator();
			if (it.hasNext()) {
				antecedentesFertilidad = (Chantecdetal) it.next();
			}

			if (antecedentesFertilidad != null) {
				Chreporte report = new Chreporte();

				report = new Chreporte();
				report.setHrecdescripcio("Grupo Sangineo");
				report.setHrectipodescri("Antecedetes Detallados");
				report.setHrencodigo(imp_antecendes_detallado);
				report.setHrentipoimpres(1);
				report.setHrenconsulta(consulta.getHcolnumero());
				report.setHredfecharegis(consulta.getHcodfecregistr());
				lstReporte.add(report);

				if (antecedentesFertilidad.getHadcgrupsang() != null) {
					String rh = "";
					report = new Chreporte();
					if ("NS".equals(antecedentesFertilidad.getHadcgrupsang())) {
						report.setHrecdescripcio("Grupo Sanguineo: " + "No Sabe");
						report.setHrecdescripcio2("");
						report.setHrecdescripcio3("");
					} else {
						report.setHrecdescripcio("Grupo Sanguineo: " + antecedentesFertilidad.getHadcgrupsang());
						if ("P".equals(antecedentesFertilidad.getHadcrh())) {
							rh = "Positivo";
						} else {
							rh = "Negativo";
						}
						report.setHrecdescripcio2("RH: " + rh);
						if ("N".equals(antecedentesFertilidad.getHadcrh())) {
							report.setHrecdescripcio3("IsoinmunizaciNn en parto o aborto anterior: "
									+ formatearCampo(antecedentesFertilidad.getHadcisoinabort()));
						} else {
							report.setHrecdescripcio3("");
						}
					}
					report.setHrectipodescri("Antecedetes Generales");
					report.setHrencodigo(imp_antecendes_detallado);
					report.setHrentipoimpres(5);
					report.setHrenconsulta(consulta.getHcolnumero());
					report.setHredfecharegis(consulta.getHcodfecregistr());
					lstReporte.add(report);
				}

				report = new Chreporte();
				report.setHrecdescripcio("Antecedentes personales - familiares especNficos");
				report.setHrectipodescri("Antecedetes Generales");
				report.setHrencodigo(imp_antecendes_detallado);
				report.setHrentipoimpres(1);
				report.setHrenconsulta(consulta.getHcolnumero());
				report.setHredfecharegis(consulta.getHcodfecregistr());
				lstReporte.add(report);

				if (antecedentesFertilidad.getHadcantepato() != null) {
					report = new Chreporte();
					report.setHrecdescripcio("Tiene Antecedentes Personales: "
							+ formatearCampo(antecedentesFertilidad.getHadcantepato()));
					report.setHrectipodescri("Antecedetes Generales");
					report.setHrencodigo(imp_antecendes_detallado);
					report.setHrentipoimpres(1);
					report.setHrenconsulta(consulta.getHcolnumero());
					report.setHredfecharegis(consulta.getHcodfecregistr());
					lstReporte.add(report);

					if ("S".equals(antecedentesFertilidad.getHadcantepato())) {
						report = new Chreporte();
						report.setHrecdescripcio(
								"TBC(Personal): " + formatearCampo(antecedentesFertilidad.getHadctbcpato()));
						if ("S".equals(antecedentesFertilidad.getHadctbcpato())) {
							report.setHrecdescripcio2(
									"DescripciNn: " + formatearCampo(antecedentesFertilidad.getHadctbcpatdes()));
						} else {
							report.setHrecdescripcio2("");
						}
						report.setHrectipodescri("Antecedetes Generales");
						report.setHrencodigo(imp_antecendes_detallado);
						report.setHrentipoimpres(2);
						report.setHrenconsulta(consulta.getHcolnumero());
						report.setHredfecharegis(consulta.getHcodfecregistr());
						lstReporte.add(report);

						report = new Chreporte();
						report.setHrecdescripcio(
								"Diabetes(Personal): " + formatearCampo(antecedentesFertilidad.getHadcdiabpato()));
						if ("S".equals(antecedentesFertilidad.getHadcdiabpato())) {
							report.setHrecdescripcio2(
									"DescripciNn: " + formatearCampo(antecedentesFertilidad.getHadcdiapatdes()));
						} else {
							report.setHrecdescripcio2("");
						}
						report.setHrectipodescri("Antecedetes Generales");
						report.setHrencodigo(imp_antecendes_detallado);
						report.setHrentipoimpres(2);
						report.setHrenconsulta(consulta.getHcolnumero());
						report.setHredfecharegis(consulta.getHcodfecregistr());
						lstReporte.add(report);

						report = new Chreporte();
						report.setHrecdescripcio(
								"HipertensiNn (Personal): " + formatearCampo(antecedentesFertilidad.getHadchipepato()));
						if ("S".equals(antecedentesFertilidad.getHadchipepato())) {
							report.setHrecdescripcio2(
									"DescripciNn: " + formatearCampo(antecedentesFertilidad.getHadchippatdes()));
						} else {
							report.setHrecdescripcio2("");
						}
						report.setHrectipodescri("Antecedetes Generales");
						report.setHrencodigo(imp_antecendes_detallado);
						report.setHrentipoimpres(2);
						report.setHrenconsulta(consulta.getHcolnumero());
						report.setHredfecharegis(consulta.getHcodfecregistr());
						lstReporte.add(report);

						report = new Chreporte();
						report.setHrecdescripcio(
								"Preclampsia  (Personal): " + formatearCampo(antecedentesFertilidad.getHadcprecpato()));
						if ("S".equals(antecedentesFertilidad.getHadcprecpato())) {
							report.setHrecdescripcio2(
									"DescripciNn: " + formatearCampo(antecedentesFertilidad.getHadcprepatdes()));
						} else {
							report.setHrecdescripcio2("");
						}
						report.setHrectipodescri("Antecedetes Generales");
						report.setHrencodigo(imp_antecendes_detallado);
						report.setHrentipoimpres(2);
						report.setHrenconsulta(consulta.getHcolnumero());
						report.setHredfecharegis(consulta.getHcodfecregistr());
						lstReporte.add(report);

						report = new Chreporte();
						report.setHrecdescripcio(
								"Eclampsia  (Personal): " + formatearCampo(antecedentesFertilidad.getHadceclapato()));
						if ("S".equals(antecedentesFertilidad.getHadceclapato())) {
							report.setHrecdescripcio2(
									"DescripciNn: " + formatearCampo(antecedentesFertilidad.getHadceclpatdes()));
						} else {
							report.setHrecdescripcio2("");
						}
						report.setHrectipodescri("Antecedetes Generales");
						report.setHrencodigo(imp_antecendes_detallado);
						report.setHrentipoimpres(2);
						report.setHrenconsulta(consulta.getHcolnumero());
						report.setHredfecharegis(consulta.getHcodfecregistr());
						lstReporte.add(report);

						report = new Chreporte();
						report.setHrecdescripcio(
								"Infertilidad (Personal): " + formatearCampo(antecedentesFertilidad.getHadciferpato()));
						if ("S".equals(antecedentesFertilidad.getHadciferpato())) {
							report.setHrecdescripcio2(
									"DescripciNn: " + formatearCampo(antecedentesFertilidad.getHadcifepatdes()));
						} else {
							report.setHrecdescripcio2("");
						}
						report.setHrectipodescri("Antecedetes Generales");
						report.setHrencodigo(imp_antecendes_detallado);
						report.setHrentipoimpres(2);
						report.setHrenconsulta(consulta.getHcolnumero());
						report.setHredfecharegis(consulta.getHcodfecregistr());
						lstReporte.add(report);

						report = new Chreporte();
						report.setHrecdescripcio(
								"CardiopatNa (Personal): " + formatearCampo(antecedentesFertilidad.getHadccardpato()));
						if ("S".equals(antecedentesFertilidad.getHadccardpato())) {
							report.setHrecdescripcio2(
									"DescripciNn: " + formatearCampo(antecedentesFertilidad.getHadccarpatdes()));
						} else {
							report.setHrecdescripcio2("");
						}
						report.setHrectipodescri("Antecedetes Generales");
						report.setHrencodigo(imp_antecendes_detallado);
						report.setHrentipoimpres(2);
						report.setHrenconsulta(consulta.getHcolnumero());
						report.setHredfecharegis(consulta.getHcodfecregistr());
						lstReporte.add(report);

						report = new Chreporte();
						report.setHrecdescripcio(
								"NefropatNa (Personal): " + formatearCampo(antecedentesFertilidad.getHadcnefrpato()));
						if ("S".equals(antecedentesFertilidad.getHadcnefrpato())) {
							report.setHrecdescripcio2(
									"DescripciNn: " + formatearCampo(antecedentesFertilidad.getHadcnefpatdes()));
						} else {
							report.setHrecdescripcio2("");
						}
						report.setHrectipodescri("Antecedetes Generales");
						report.setHrencodigo(imp_antecendes_detallado);
						report.setHrentipoimpres(2);
						report.setHrenconsulta(consulta.getHcolnumero());
						report.setHredfecharegis(consulta.getHcodfecregistr());
						lstReporte.add(report);

						report = new Chreporte();
						report.setHrecdescripcio("CirugNa genito-urinaria (Personal): "
								+ formatearCampo(antecedentesFertilidad.getHadcgeurqx()));
						if ("S".equals(antecedentesFertilidad.getHadcgeurqx())) {
							report.setHrecdescripcio2(
									"DescripciNn: " + formatearCampo(antecedentesFertilidad.getHadcgeurqxdes()));
						} else {
							report.setHrecdescripcio2("");
						}
						report.setHrectipodescri("Antecedetes Generales");
						report.setHrencodigo(imp_antecendes_detallado);
						report.setHrentipoimpres(2);
						report.setHrenconsulta(consulta.getHcolnumero());
						report.setHredfecharegis(consulta.getHcodfecregistr());
						lstReporte.add(report);
					}

				}

				if (antecedentesFertilidad.getHadcantefami() != null) {
					report = new Chreporte();
					report.setHrecdescripcio("Tiene Antecedentes Familiares: "
							+ formatearCampo(antecedentesFertilidad.getHadcantefami()));
					report.setHrectipodescri("Antecedetes Generales");
					report.setHrencodigo(imp_antecendes_detallado);
					report.setHrentipoimpres(1);
					report.setHrenconsulta(consulta.getHcolnumero());
					report.setHredfecharegis(consulta.getHcodfecregistr());
					lstReporte.add(report);

					if ("S".equals(antecedentesFertilidad.getHadcantefami())) {
						report = new Chreporte();
						report.setHrecdescripcio(
								"TBC(Familiar): " + formatearCampo(antecedentesFertilidad.getHadctbcfami()));
						if ("S".equals(antecedentesFertilidad.getHadctbcfami())) {
							report.setHrecdescripcio2(
									"DescripciNn: " + formatearCampo(antecedentesFertilidad.getHadctbcfamdes()));
						} else {
							report.setHrecdescripcio2("");
						}
						report.setHrectipodescri("Antecedetes Generales");
						report.setHrencodigo(imp_antecendes_detallado);
						report.setHrentipoimpres(2);
						report.setHrenconsulta(consulta.getHcolnumero());
						report.setHredfecharegis(consulta.getHcodfecregistr());
						lstReporte.add(report);

						report = new Chreporte();
						report.setHrecdescripcio(
								"Diabetes(Familiar): " + formatearCampo(antecedentesFertilidad.getHadcdiabfami()));
						if ("S".equals(antecedentesFertilidad.getHadcdiabfami())) {
							report.setHrecdescripcio2(
									"DescripciNn: " + formatearCampo(antecedentesFertilidad.getHadcdiafamdes()));
						} else {
							report.setHrecdescripcio2("");
						}
						report.setHrectipodescri("Antecedetes Generales");
						report.setHrencodigo(imp_antecendes_detallado);
						report.setHrentipoimpres(2);
						report.setHrenconsulta(consulta.getHcolnumero());
						report.setHredfecharegis(consulta.getHcodfecregistr());
						lstReporte.add(report);

						report = new Chreporte();
						report.setHrecdescripcio(
								"HipertensiNn (Familiar): " + formatearCampo(antecedentesFertilidad.getHadchipefami()));
						if ("S".equals(antecedentesFertilidad.getHadchipefami())) {
							report.setHrecdescripcio2(
									"DescripciNn: " + formatearCampo(antecedentesFertilidad.getHadchipfamdes()));
						} else {
							report.setHrecdescripcio2("");
						}
						report.setHrectipodescri("Antecedetes Generales");
						report.setHrencodigo(imp_antecendes_detallado);
						report.setHrentipoimpres(2);
						report.setHrenconsulta(consulta.getHcolnumero());
						report.setHredfecharegis(consulta.getHcodfecregistr());
						lstReporte.add(report);

						report = new Chreporte();
						report.setHrecdescripcio(
								"Preclampsia  (Familiar): " + formatearCampo(antecedentesFertilidad.getHadcprecfami()));
						if ("S".equals(antecedentesFertilidad.getHadcprecfami())) {
							report.setHrecdescripcio2(
									"DescripciNn: " + formatearCampo(antecedentesFertilidad.getHadcprefamdes()));
						} else {
							report.setHrecdescripcio2("");
						}
						report.setHrectipodescri("Antecedetes Generales");
						report.setHrencodigo(imp_antecendes_detallado);
						report.setHrentipoimpres(2);
						report.setHrenconsulta(consulta.getHcolnumero());
						report.setHredfecharegis(consulta.getHcodfecregistr());
						lstReporte.add(report);

						report = new Chreporte();
						report.setHrecdescripcio(
								"Eclampsia  (Familiar): " + formatearCampo(antecedentesFertilidad.getHadceclafami()));
						if ("S".equals(antecedentesFertilidad.getHadceclafami())) {
							report.setHrecdescripcio2(
									"DescripciNn: " + formatearCampo(antecedentesFertilidad.getHadceclfamdes()));
						} else {
							report.setHrecdescripcio2("");
						}
						report.setHrectipodescri("Antecedetes Generales");
						report.setHrencodigo(imp_antecendes_detallado);
						report.setHrentipoimpres(2);
						report.setHrenconsulta(consulta.getHcolnumero());
						report.setHredfecharegis(consulta.getHcodfecregistr());
						lstReporte.add(report);

					}
				}

				if (antecedentesFertilidad.getHadcantetoxi() != null) {
					report = new Chreporte();
					report.setHrecdescripcio("Tiene Antecedentes Toxicologicos: "
							+ formatearCampo(antecedentesFertilidad.getHadcantetoxi()));
					report.setHrectipodescri("Antecedetes Generales");
					report.setHrencodigo(imp_antecendes_detallado);
					report.setHrentipoimpres(1);
					report.setHrenconsulta(consulta.getHcolnumero());
					report.setHredfecharegis(consulta.getHcodfecregistr());
					lstReporte.add(report);
					if ("S".equals(antecedentesFertilidad.getHadcantetoxi())) {

						if ("S".equals(antecedentesFertilidad.getHadcfumacttox())) {
							report = new Chreporte();
							report.setHrecdescripcio(
									"Fumadora activas: " + formatearCampo(antecedentesFertilidad.getHadcfumacttox()));
							report.setHrectipodescri("Antecedetes Generales");
							report.setHrencodigo(imp_antecendes_detallado);
							report.setHrentipoimpres(1);
							report.setHrenconsulta(consulta.getHcolnumero());
							report.setHredfecharegis(consulta.getHcodfecregistr());
							lstReporte.add(report);
						}

						if ("S".equals(antecedentesFertilidad.getHadcfumpastox())) {
							report = new Chreporte();
							report.setHrecdescripcio(
									"Fumadora pasiva: " + formatearCampo(antecedentesFertilidad.getHadcfumpastox()));
							report.setHrectipodescri("Antecedetes Generales");
							report.setHrencodigo(imp_antecendes_detallado);
							report.setHrentipoimpres(1);
							report.setHrenconsulta(consulta.getHcolnumero());
							report.setHredfecharegis(consulta.getHcodfecregistr());
							lstReporte.add(report);
						}

						if ("S".equals(antecedentesFertilidad.getHadcsuspsitox())) {
							report = new Chreporte();
							report.setHrecdescripcio("Sustancias Psicoactivas: "
									+ formatearCampo(antecedentesFertilidad.getHadcsuspsitox()));
							report.setHrectipodescri("Antecedetes Generales");
							report.setHrencodigo(imp_antecendes_detallado);
							report.setHrentipoimpres(1);
							report.setHrenconsulta(consulta.getHcolnumero());
							report.setHredfecharegis(consulta.getHcodfecregistr());
							lstReporte.add(report);
						}

						if ("S".equals(antecedentesFertilidad.getHadcalctox())) {

							report = new Chreporte();
							report.setHrecdescripcio(
									"Alcohol: " + formatearCampo(antecedentesFertilidad.getHadcalctox()));
							report.setHrectipodescri("Antecedetes Generales");
							report.setHrencodigo(imp_antecendes_detallado);
							report.setHrentipoimpres(1);
							report.setHrenconsulta(consulta.getHcolnumero());
							report.setHredfecharegis(consulta.getHcodfecregistr());
							lstReporte.add(report);
						}

					}

				}

				if (antecedentesFertilidad.getHadcultpruvih() != null
						&& antecedentesFertilidad.getHadcultprusif() != null) {
					String fechaUltPruebaVIH = "";
					String opcionesVPH = "";
					String fechaUltPruebaSifilis = "";
					String opcionesSifilis = "";
					if ("NU".equals(antecedentesFertilidad.getHadcultpruvih())) {
						fechaUltPruebaVIH = "Nunca";
					} else if ("HMEA".equals(antecedentesFertilidad.getHadcultpruvih())) {
						fechaUltPruebaVIH = "Hace menos de un aNo";
					} else if ("HMAA".equals(antecedentesFertilidad.getHadcultpruvih())) {
						fechaUltPruebaVIH = "Hace mNs de un aNo";
					} else if ("NR".equals(antecedentesFertilidad.getHadcultpruvih())) {
						fechaUltPruebaVIH = "No Recuerda\"";
					}

					if ("RE".equals(antecedentesFertilidad.getHadcresultpruvih())) {
						opcionesVPH = "Reactivo";
					} else if ("NR".equals(antecedentesFertilidad.getHadcresultpruvih())) {
						opcionesVPH = "No Reactivo";
					} else if ("IN".equals(antecedentesFertilidad.getHadcresultpruvih())) {
						opcionesVPH = "Indeterminado";
					}

					if ("NU".equals(antecedentesFertilidad.getHadcultprusif())) {
						fechaUltPruebaSifilis = "Nunca";
					} else if ("HMEA".equals(antecedentesFertilidad.getHadcultprusif())) {
						fechaUltPruebaSifilis = "Hace menos de un aNo";
					} else if ("HMAA".equals(antecedentesFertilidad.getHadcultprusif())) {
						fechaUltPruebaSifilis = "Hace mNs de un aNo";
					} else if ("NR".equals(antecedentesFertilidad.getHadcultprusif())) {
						fechaUltPruebaSifilis = "No Recuerda\"";
					}

					if ("RE".equals(antecedentesFertilidad.getHadcresultprusif())) {
						opcionesSifilis = "Reactivo";
					} else if ("NR".equals(antecedentesFertilidad.getHadcresultprusif())) {
						opcionesSifilis = "No Reactivo";
					} else if ("IN".equals(antecedentesFertilidad.getHadcresultprusif())) {
						opcionesSifilis = "Indeterminado";
					}

					report = new Chreporte();
					report.setHrecdescripcio("Fecha ultima prueba de VIH : " + fechaUltPruebaVIH);
					if ("HMEA".equals(antecedentesFertilidad.getHadcultpruvih())
							|| "HMAA".equals(antecedentesFertilidad.getHadcultpruvih())) {
						report.setHrecdescripcio2("Opciones:" + opcionesVPH);
					} else {
						report.setHrecdescripcio2("");
					}
					report.setHrectipodescri("Antecedetes Generales");
					report.setHrencodigo(imp_antecendes_detallado);
					report.setHrentipoimpres(2);
					report.setHrenconsulta(consulta.getHcolnumero());
					report.setHredfecharegis(consulta.getHcodfecregistr());
					lstReporte.add(report);

					report = new Chreporte();
					report.setHrecdescripcio("Fecha Nltima prueba sNfilis : " + fechaUltPruebaSifilis);
					if ("HMEA".equals(antecedentesFertilidad.getHadcultprusif())
							|| "HMAA".equals(antecedentesFertilidad.getHadcultprusif())) {
						report.setHrecdescripcio2("Opciones:" + opcionesSifilis);
					} else {
						report.setHrecdescripcio2("");
					}
					report.setHrectipodescri("Antecedetes Generales");
					report.setHrencodigo(imp_antecendes_detallado);
					report.setHrentipoimpres(2);
					report.setHrenconsulta(consulta.getHcolnumero());
					report.setHredfecharegis(consulta.getHcodfecregistr());
					lstReporte.add(report);

				}

				if (antecedentesFertilidad.getHadcprurapcon() != null) {
					report = new Chreporte();
					report.setHrecdescripcio("Se realizan pruebas rNpidas en la consulta: "
							+ formatearCampo(antecedentesFertilidad.getHadcprurapcon()));
					report.setHrectipodescri("Antecedetes Generales");
					report.setHrencodigo(imp_antecendes_detallado);
					report.setHrentipoimpres(1);
					report.setHrenconsulta(consulta.getHcolnumero());
					report.setHredfecharegis(consulta.getHcodfecregistr());
					lstReporte.add(report);
				}

				if (antecedentesFertilidad.getHadcembarazo() != null) {
					String embarazo = "";
					if (antecedentesFertilidad.getHadcembarazo().equals("P")) {
						embarazo = "Positivo";
					}
					if (antecedentesFertilidad.getHadcembarazo().equals("N")) {
						embarazo = "Negativo";
					}

					report = new Chreporte();
					report.setHrecdescripcio("Embarazo : " + embarazo);
					report.setHrectipodescri("Antecedetes Generales");
					report.setHrencodigo(imp_antecendes_detallado);
					report.setHrentipoimpres(1);
					report.setHrenconsulta(consulta.getHcolnumero());
					report.setHredfecharegis(consulta.getHcodfecregistr());
					lstReporte.add(report);
				}

				if (antecedentesFertilidad.getHadcsifilis() != null) {
					String sifilis = "";
					if (antecedentesFertilidad.getHadcsifilis().equals("P")) {
						sifilis = "Positivo";
					}
					if (antecedentesFertilidad.getHadcsifilis().equals("N")) {
						sifilis = "Negativo";
					}

					report = new Chreporte();
					report.setHrecdescripcio("Sifilis : " + sifilis);
					report.setHrectipodescri("Antecedetes Generales");
					report.setHrencodigo(imp_antecendes_detallado);
					report.setHrentipoimpres(1);
					report.setHrenconsulta(consulta.getHcolnumero());
					report.setHredfecharegis(consulta.getHcodfecregistr());
					lstReporte.add(report);
				}

				if (antecedentesFertilidad.getHadcvih() != null) {
					String vih = "";
					if (antecedentesFertilidad.getHadcvih().equals("P")) {
						vih = "Positivo";
					}
					if (antecedentesFertilidad.getHadcvih().equals("N")) {
						vih = "Negativo";
					}

					report = new Chreporte();
					report.setHrecdescripcio("Vih : " + vih);
					report.setHrectipodescri("Antecedetes Generales");
					report.setHrencodigo(imp_antecendes_detallado);
					report.setHrentipoimpres(1);
					report.setHrenconsulta(consulta.getHcolnumero());
					report.setHredfecharegis(consulta.getHcodfecregistr());
					lstReporte.add(report);
				}

			}

		}
	}

	public void opcionesNuevasTamizajeLaboratorios(Chconsulta consulta) {

		if (consulta.getChtamizalapr() != null && !consulta.getChtamizalapr().isEmpty()) {
			Chtamizalapr tamizaje = null;
			Iterator it = consulta.getChtamizalapr().iterator();
			if (it.hasNext()) {
				tamizaje = (Chtamizalapr) it.next();
			}

			if (tamizaje != null) {

				Chreporte report = new Chreporte();

				String s = "";
				String s2 = " ";
				String s3 = " ";

				s = "Toxoplasma IGG:   " + TOXOPLASMA_IGG;
				if (RESULTADO_IGG != null && !RESULTADO_IGG.equals("")) {
					s2 = "Resultado IGG:  " + RESULTADO_IGG;
				} else {
					s2 = "";
				}
				if (FECHA_IGG != null && !FECHA_IGG.equals("")) {
					s3 = "Fecha IGG: " + FECHA_IGG;
				}

				report = new Chreporte();
				report.setHrecdescripcio(s);
				report.setHrecdescripcio2(s2);
				report.setHrecdescripcio3(s3);
				report.setHrectipodescri("Tamizaje Laboratorios");
				report.setHrencodigo(imp_tamizaje_prenatal);
				report.setHrentipoimpres(5);
				report.setHrenconsulta(consulta.getHcolnumero());
				report.setHredfecharegis(consulta.getHcodfecregistr());
				lstReporte.add(report);

				s = "Toxoplasma IGM:  " + TOXOPLASMA_IGM;
				if (RESULTADO_IGM != null && !RESULTADO_IGM.equals("")) {
					s2 = "Resultado IGM:  " + RESULTADO_IGM;
				} else {
					s2 = "";
				}
				if (FECHA_IGM != null && !FECHA_IGM.equals("")) {
					s3 = "Fecha IGM: " + FECHA_IGM;
				} else {
					s3 = "";
				}

				report = new Chreporte();
				report.setHrecdescripcio(s);
				report.setHrecdescripcio2(s2);
				report.setHrecdescripcio3(s3);
				report.setHrectipodescri("Tamizaje Laboratorios");
				report.setHrencodigo(imp_tamizaje_prenatal);
				report.setHrentipoimpres(5);
				report.setHrenconsulta(consulta.getHcolnumero());
				report.setHredfecharegis(consulta.getHcodfecregistr());
				lstReporte.add(report);

				s = "Test ONSullivan:  " + TEST_SULLIVAN;
				if (RESULTADO_TEST_SULLIVAN != null && !RESULTADO_TEST_SULLIVAN.equals("")) {
					s2 = "Resultado Test ONSullivan:  " + RESULTADO_TEST_SULLIVAN;
				} else {
					s2 = "";
				}
				if (FECHA_TEST_SULLIVAN != null && !FECHA_TEST_SULLIVAN.equals("")) {
					s3 = "Fecha Test ONSullivan: " + FECHA_TEST_SULLIVAN;
				} else {
					s3 = "";
				}

				report = new Chreporte();
				report.setHrecdescripcio(s);
				report.setHrecdescripcio2(s2);
				report.setHrecdescripcio3(s3);
				report.setHrectipodescri("Tamizaje Laboratorios");
				report.setHrencodigo(imp_tamizaje_prenatal);
				report.setHrentipoimpres(5);
				report.setHrenconsulta(consulta.getHcolnumero());
				report.setHredfecharegis(consulta.getHcodfecregistr());
				lstReporte.add(report);

				s = "Hemoglobina:  " + HEMOGLOBINA;
				if (RESULTADO_HEMOGLOBINA != null && !RESULTADO_HEMOGLOBINA.equals("")) {
					s2 = "Resultado Hemoglobina:  " + RESULTADO_HEMOGLOBINA;
				} else {
					s2 = "";
				}

				if (FECHA_HEMOGLOBINA != null && !FECHA_HEMOGLOBINA.equals("")) {
					s3 = "Fecha Hemoglobina: " + FECHA_HEMOGLOBINA;
				} else {
					s3 = "";
				}

				report = new Chreporte();
				report.setHrecdescripcio(s);
				report.setHrecdescripcio2(s2);
				report.setHrecdescripcio3(s3);
				report.setHrectipodescri("Tamizaje Laboratorios");
				report.setHrencodigo(imp_tamizaje_prenatal);
				report.setHrentipoimpres(5);
				report.setHrenconsulta(consulta.getHcolnumero());
				report.setHredfecharegis(consulta.getHcodfecregistr());
				lstReporte.add(report);

				s = "Glucosa:  " + GLUCOSA;
				if (RESULTADO_GLUCOSA != null && !RESULTADO_GLUCOSA.equals("")) {
					s2 = "Resultado Glucosa:  " + RESULTADO_GLUCOSA;
				} else {
					s2 = "";
				}

				if (FECHA_GLUCOSA != null && !FECHA_GLUCOSA.equals("")) {
					s3 = "Fecha Glucosa: " + FECHA_GLUCOSA;
				} else {
					s3 = "";
				}

				report = new Chreporte();
				report.setHrecdescripcio(s);
				report.setHrecdescripcio2(s2);
				report.setHrecdescripcio3(s3);
				report.setHrectipodescri("Tamizaje Laboratorios");
				report.setHrencodigo(imp_tamizaje_prenatal);
				report.setHrentipoimpres(5);
				report.setHrenconsulta(consulta.getHcolnumero());
				report.setHredfecharegis(consulta.getHcodfecregistr());
				lstReporte.add(report);

				s = "Serologia:  " + SEROLOGIA;
				if (RESULTADO_SEROLOGIA != null && !RESULTADO_SEROLOGIA.equals("")) {
					s2 = "Resultado serologia:  " + RESULTADO_SEROLOGIA;
				} else {
					s2 = "";
				}

				if (FECHA_SEROLOGIA != null && !FECHA_SEROLOGIA.equals("")) {
					s3 = "Fecha serologia" + FECHA_SEROLOGIA;
				} else {
					s3 = "";
				}

				report = new Chreporte();
				report.setHrecdescripcio(s);
				report.setHrecdescripcio2(s2);
				report.setHrecdescripcio3(s3);
				report.setHrectipodescri("Tamizaje Laboratorios");
				report.setHrencodigo(imp_tamizaje_prenatal);
				report.setHrentipoimpres(5);
				report.setHrenconsulta(consulta.getHcolnumero());
				report.setHredfecharegis(consulta.getHcodfecregistr());
				lstReporte.add(report);

				s = "Urocultivo:  " + formatearCampo(tamizaje.getHtleurocultivo());
				if (tamizaje.getHtlcresulurocu() != null && !tamizaje.getHtlcresulurocu().equals("")) {
					s2 = "Resultado urocultivo:  " + tamizaje.getHtlcresulurocu();
				} else {
					s2 = "";
				}

				if (tamizaje.getHtldfechaurocu() != null && !tamizaje.getHtldfechaurocu().equals("")) {
					s3 = "Fecha u|rocultivo:" + tamizaje.getHtldfechaurocu();
				} else {
					s3 = "";
				}

				report = new Chreporte();
				report.setHrecdescripcio(s);
				report.setHrecdescripcio2(s2);
				report.setHrecdescripcio3(s3);
				report.setHrectipodescri("Tamizaje Laboratorios");
				report.setHrencodigo(imp_tamizaje_prenatal);
				report.setHrentipoimpres(5);
				report.setHrenconsulta(consulta.getHcolnumero());
				report.setHredfecharegis(consulta.getHcodfecregistr());
				lstReporte.add(report);

				s = "Antibiograma:  " + formatearCampo(tamizaje.getHtleantibiogra());
				if (tamizaje.getHtlcresulantib() != null && !tamizaje.getHtlcresulantib().equals("")) {
					s2 = "Resultado antibiograma:  " + tamizaje.getHtlcresulantib();
				} else {
					s2 = "";
				}

				if (tamizaje.getHtldfechaantib() != null && !tamizaje.getHtldfechaantib().equals("")) {
					s3 = "Fecha antibiograma:" + tamizaje.getHtldfechaantib();
				} else {
					s3 = "";
				}

				report = new Chreporte();
				report.setHrecdescripcio(s);
				report.setHrecdescripcio2(s2);
				report.setHrecdescripcio3(s3);
				report.setHrectipodescri("Tamizaje Laboratorios");
				report.setHrencodigo(imp_tamizaje_prenatal);
				report.setHrentipoimpres(5);
				report.setHrenconsulta(consulta.getHcolnumero());
				report.setHredfecharegis(consulta.getHcodfecregistr());
				lstReporte.add(report);

				s = "Hemograma:  " + formatearCampo(tamizaje.getHtlehemograma());
				if (tamizaje.getHtlcresulhemog() != null && !tamizaje.getHtlcresulhemog().equals("")) {
					s2 = "Resultado hemograma:  " + tamizaje.getHtlcresulhemog();
				} else {
					s2 = "";
				}

				if (tamizaje.getHtldfechahemog() != null && !tamizaje.getHtldfechahemog().equals("")) {
					s3 = "Fecha hemograma:" + tamizaje.getHtldfechahemog();
				} else {
					s3 = "";
				}

				report = new Chreporte();
				report.setHrecdescripcio(s);
				report.setHrecdescripcio2(s2);
				report.setHrecdescripcio3(s3);
				report.setHrectipodescri("Tamizaje Laboratorios");
				report.setHrencodigo(imp_tamizaje_prenatal);
				report.setHrentipoimpres(5);
				report.setHrenconsulta(consulta.getHcolnumero());
				report.setHredfecharegis(consulta.getHcodfecregistr());
				lstReporte.add(report);

				s = "HemoclasificaciNn:  " + formatearCampo(tamizaje.getHtlehemoclasif());
				if (tamizaje.getHtlcresulhemoc() != null && !tamizaje.getHtlcresulhemoc().equals("")) {
					s2 = "Resultado hemoclasificaciNn:  " + tamizaje.getHtlcresulhemoc();
				} else {
					s2 = "";
				}

				if (tamizaje.getHtldfechahemoc() != null && !tamizaje.getHtldfechahemoc().equals("")) {
					s3 = "Fecha hemoclasificaciNn:" + tamizaje.getHtldfechahemoc();
				} else {
					s3 = "";
				}

				report = new Chreporte();
				report.setHrecdescripcio(s);
				report.setHrecdescripcio2(s2);
				report.setHrecdescripcio3(s3);
				report.setHrectipodescri("Tamizaje Laboratorios");
				report.setHrencodigo(imp_tamizaje_prenatal);
				report.setHrentipoimpres(5);
				report.setHrenconsulta(consulta.getHcolnumero());
				report.setHredfecharegis(consulta.getHcodfecregistr());
				lstReporte.add(report);

				s = "Prueba rNpida para VIH (VIH 1-VIH 2):  " + formatearCampo(tamizaje.getHtleprurapvih());
				if (tamizaje.getHtlcresulprravi() != null && !tamizaje.getHtlcresulprravi().equals("")) {
					s2 = "Resultado prueba rNpida para VIH (VIH 1-VIH 2):  " + tamizaje.getHtlcresulprravi();
				} else {
					s2 = "";
				}

				if (tamizaje.getHtldfechaprravi() != null && !tamizaje.getHtldfechaprravi().equals("")) {
					s3 = "Fecha prueba rNpida para VIH (VIH 1-VIH 2):" + tamizaje.getHtldfechaprravi();
				} else {
					s3 = "";
				}

				report = new Chreporte();
				report.setHrecdescripcio(s);
				report.setHrecdescripcio2(s2);
				report.setHrecdescripcio3(s3);
				report.setHrectipodescri("Tamizaje Laboratorios");
				report.setHrencodigo(imp_tamizaje_prenatal);
				report.setHrentipoimpres(5);
				report.setHrenconsulta(consulta.getHcolnumero());
				report.setHredfecharegis(consulta.getHcodfecregistr());
				lstReporte.add(report);

				s = "AntNgeno de superficie para Hepatitis B - HbsAg:  "
						+ formatearCampo(tamizaje.getHtleantisupehepa());
				if (tamizaje.getHtlcresulansuhe() != null && !tamizaje.getHtlcresulansuhe().equals("")) {
					s2 = "Resultado antNgeno de superficie para Hepatitis B - HbsAg:  " + tamizaje.getHtlcresulansuhe();
				} else {
					s2 = "";
				}

				if (tamizaje.getHtldfechaansuhe() != null && !tamizaje.getHtldfechaansuhe().equals("")) {
					s3 = "Fecha antNgeno de superficie para Hepatitis B - HbsAg:" + tamizaje.getHtldfechaansuhe();
				} else {
					s3 = "";
				}

				report = new Chreporte();
				report.setHrecdescripcio(s);
				report.setHrecdescripcio2(s2);
				report.setHrecdescripcio3(s3);
				report.setHrectipodescri("Tamizaje Laboratorios");
				report.setHrencodigo(imp_tamizaje_prenatal);
				report.setHrentipoimpres(5);
				report.setHrenconsulta(consulta.getHcolnumero());
				report.setHredfecharegis(consulta.getHcodfecregistr());
				lstReporte.add(report);

				s = "Tamizaje de cNncer de cuello:  " + formatearCampo(tamizaje.getHtletamcancue());
				if (tamizaje.getHtlcresultacacu() != null && !tamizaje.getHtlcresultacacu().equals("")) {
					s2 = "Resultado tamizaje de cNncer de cuello:  " + tamizaje.getHtlcresultacacu();
				} else {
					s2 = "";
				}

				if (tamizaje.getHtldfechatacacu() != null && !tamizaje.getHtldfechatacacu().equals("")) {
					s3 = "Fecha tamizaje de cNncer de cuello:" + tamizaje.getHtldfechatacacu();
				} else {
					s3 = "";
				}

				report = new Chreporte();
				report.setHrecdescripcio(s);
				report.setHrecdescripcio2(s2);
				report.setHrecdescripcio3(s3);
				report.setHrectipodescri("Tamizaje Laboratorios");
				report.setHrencodigo(imp_tamizaje_prenatal);
				report.setHrentipoimpres(5);
				report.setHrenconsulta(consulta.getHcolnumero());
				report.setHredfecharegis(consulta.getHcodfecregistr());
				lstReporte.add(report);

				s = "Pruebas de IgG para Rubeola en mujeres no vacunadas:  " + formatearCampo(tamizaje.getHtlepruigg());
				if (tamizaje.getHtlcresulpruigg() != null && !tamizaje.getHtlcresulpruigg().equals("")) {
					s2 = "Resultado pruebas de IgG para Rubeola en mujeres no vacunadas:  "
							+ tamizaje.getHtlcresulpruigg();
				} else {
					s2 = "";
				}

				if (tamizaje.getHtldfechpruigg() != null && !tamizaje.getHtldfechpruigg().equals("")) {
					s3 = "Fecha pruebas de IgG para Rubeola en mujeres no vacunadas:" + tamizaje.getHtldfechpruigg();
				} else {
					s3 = "";
				}

				report = new Chreporte();
				report.setHrecdescripcio(s);
				report.setHrecdescripcio2(s2);
				report.setHrecdescripcio3(s3);
				report.setHrectipodescri("Tamizaje Laboratorios");
				report.setHrencodigo(imp_tamizaje_prenatal);
				report.setHrentipoimpres(5);
				report.setHrenconsulta(consulta.getHcolnumero());
				report.setHredfecharegis(consulta.getHcodfecregistr());
				lstReporte.add(report);

				s = "Pruebas de IgA para toxoplasma:  " + formatearCampo(tamizaje.getHtlepruigatox());
				if (tamizaje.getHtlcresulprigto() != null && !tamizaje.getHtlcresulprigto().equals("")) {
					s2 = "Resultado pruebas de IgA para toxoplasma:  " + tamizaje.getHtlcresulprigto();
				} else {
					s2 = "";
				}

				if (tamizaje.getHtldfechprigto() != null && !tamizaje.getHtldfechprigto().equals("")) {
					s3 = "Fecha pruebas de IgA para toxoplasma:" + tamizaje.getHtldfechprigto();
				} else {
					s3 = "";
				}

				report = new Chreporte();
				report.setHrecdescripcio(s);
				report.setHrecdescripcio2(s2);
				report.setHrecdescripcio3(s3);
				report.setHrectipodescri("Tamizaje Laboratorios");
				report.setHrencodigo(imp_tamizaje_prenatal);
				report.setHrentipoimpres(5);
				report.setHrenconsulta(consulta.getHcolnumero());
				report.setHredfecharegis(consulta.getHcodfecregistr());
				lstReporte.add(report);

				s = "TamizaciNn para estreptococo del grupo B con cultivo rectal y vaginal:  "
						+ formatearCampo(tamizaje.getHtletamizestre());
				if (tamizaje.getHtlcresultamest() != null && !tamizaje.getHtlcresultamest().equals("")) {
					s2 = "Resultado tamizaciNn para estreptococo del grupo B con cultivo rectal y vaginal:  "
							+ tamizaje.getHtlcresultamest();
				} else {
					s2 = "";
				}

				if (tamizaje.getHtldfechtamest() != null && !tamizaje.getHtldfechtamest().equals("")) {
					s3 = "Fecha tamizaciNn para estreptococo del grupo B con cultivo rectal y vaginal:"
							+ tamizaje.getHtldfechtamest();
				} else {
					s3 = "";
				}

				report = new Chreporte();
				report.setHrecdescripcio(s);
				report.setHrecdescripcio2(s2);
				report.setHrecdescripcio3(s3);
				report.setHrectipodescri("Tamizaje Laboratorios");
				report.setHrencodigo(imp_tamizaje_prenatal);
				report.setHrentipoimpres(5);
				report.setHrenconsulta(consulta.getHcolnumero());
				report.setHredfecharegis(consulta.getHcodfecregistr());
				lstReporte.add(report);

				s = "Prueba de tolerancia oral a la glucosa (PTOG):  " + formatearCampo(tamizaje.getHtleprutoloraglu());
				if (tamizaje.getHtlcresulprtoorgl() != null && !tamizaje.getHtlcresulprtoorgl().equals("")) {
					s2 = "Resultado prueba de tolerancia oral a la glucosa (PTOG):  " + tamizaje.getHtlcresulprtoorgl();
				} else {
					s2 = "";
				}

				if (tamizaje.getHtldfechprtoorgl() != null && !tamizaje.getHtldfechprtoorgl().equals("")) {
					s3 = "Fecha prueba de tolerancia oral a la glucosa (PTOG):" + tamizaje.getHtldfechprtoorgl();
				} else {
					s3 = "";
				}

				report = new Chreporte();
				report.setHrecdescripcio(s);
				report.setHrecdescripcio2(s2);
				report.setHrecdescripcio3(s3);
				report.setHrectipodescri("Tamizaje Laboratorios");
				report.setHrencodigo(imp_tamizaje_prenatal);
				report.setHrentipoimpres(5);
				report.setHrenconsulta(consulta.getHcolnumero());
				report.setHredfecharegis(consulta.getHcodfecregistr());
				lstReporte.add(report);

				s = "Tamizaje con gota gruesa:  " + formatearCampo(tamizaje.getHtletamgotgru());
				if (tamizaje.getHtlcresultagogr() != null && !tamizaje.getHtlcresultagogr().equals("")) {
					s2 = "Resultado Tamizaje con gota gruesa:  " + tamizaje.getHtlcresultagogr();
				} else {
					s2 = "";
				}

				if (tamizaje.getHtldfechtagogr() != null && !tamizaje.getHtldfechtagogr().equals("")) {
					s3 = "Fecha Tamizaje con gota gruesa:" + tamizaje.getHtldfechtagogr();
				} else {
					s3 = "";
				}

				report = new Chreporte();
				report.setHrecdescripcio(s);
				report.setHrecdescripcio2(s2);
				report.setHrecdescripcio3(s3);
				report.setHrectipodescri("Tamizaje Laboratorios");
				report.setHrencodigo(imp_tamizaje_prenatal);
				report.setHrentipoimpres(5);
				report.setHrenconsulta(consulta.getHcolnumero());
				report.setHredfecharegis(consulta.getHcodfecregistr());
				lstReporte.add(report);

				s = "Tamizaje con gota gruesa:  " + formatearCampo(tamizaje.getHtletamgotgru());
				if (tamizaje.getHtlcresultagogr() != null && !tamizaje.getHtlcresultagogr().equals("")) {
					s2 = "Resultado Tamizaje con gota gruesa:  " + tamizaje.getHtlcresultagogr();
				} else {
					s2 = "";
				}

				if (tamizaje.getHtldfechtagogr() != null && !tamizaje.getHtldfechtagogr().equals("")) {
					s3 = "Fecha Tamizaje con gota gruesa:" + tamizaje.getHtldfechtagogr();
				} else {
					s3 = "";
				}

				report = new Chreporte();
				report.setHrecdescripcio(s);
				report.setHrecdescripcio2(s2);
				report.setHrecdescripcio3(s3);
				report.setHrectipodescri("Tamizaje Laboratorios");
				report.setHrencodigo(imp_tamizaje_prenatal);
				report.setHrentipoimpres(5);
				report.setHrenconsulta(consulta.getHcolnumero());
				report.setHredfecharegis(consulta.getHcodfecregistr());
				lstReporte.add(report);

				s = "ElISA para enfermedad de chagas        :  " + formatearCampo(tamizaje.getHtleelisa());
				if (tamizaje.getHtlcresulelisa() != null && !tamizaje.getHtlcresulelisa().equals("")) {
					s2 = "Resultado ElISA para enfermedad de chagas:  " + tamizaje.getHtlcresulelisa();
				} else {
					s2 = "";
				}

				if (tamizaje.getHtldfechelisa() != null && !tamizaje.getHtldfechelisa().equals("")) {
					s3 = "Fecha ElISA para enfermedad de chagas:" + tamizaje.getHtldfechelisa();
				} else {
					s3 = "";
				}

				report = new Chreporte();
				report.setHrecdescripcio(s);
				report.setHrecdescripcio2(s2);
				report.setHrecdescripcio3(s3);
				report.setHrectipodescri("Tamizaje Laboratorios");
				report.setHrencodigo(imp_tamizaje_prenatal);
				report.setHrentipoimpres(5);
				report.setHrenconsulta(consulta.getHcolnumero());
				report.setHredfecharegis(consulta.getHcodfecregistr());
				lstReporte.add(report);

				s = "EcografNa:  " + ECOGRAFIA;
				if (DESCRIPCION_ECOGRAFIA != null && !DESCRIPCION_ECOGRAFIA.equals("")) {
					s2 = "DescripciNn EcografNa:  " + DESCRIPCION_ECOGRAFIA;
				} else {
					s2 = "";
				}

				s3 = "";

				report = new Chreporte();
				report.setHrecdescripcio(s);
				report.setHrecdescripcio2(s2);
				report.setHrecdescripcio3(s3);
				report.setHrectipodescri("Tamizaje Laboratorios");
				report.setHrencodigo(imp_tamizaje_prenatal);
				report.setHrentipoimpres(3);
				report.setHrenconsulta(consulta.getHcolnumero());
				report.setHredfecharegis(consulta.getHcodfecregistr());
				lstReporte.add(report);

				if (MICRONUTRIENTES != null && !MICRONUTRIENTES.equals("")) {
					s = "Micronutrientes: " + MICRONUTRIENTES;
				} else {
					s = "";
				}

				s2 = "Parcial Orina:  " + PARCIAL_ORINA;
				if (BACTERIURIA != null && !BACTERIURIA.equals("")) {
					s3 = "Bacteriuria:  " + BACTERIURIA;
				} else {
					s3 = "";
				}

				report = new Chreporte();
				report.setHrecdescripcio(s);
				report.setHrecdescripcio2(s2);
				report.setHrecdescripcio3(s3);
				report.setHrectipodescri("Tamizaje Laboratorios");
				report.setHrencodigo(imp_tamizaje_prenatal);
				report.setHrentipoimpres(5);
				report.setHrenconsulta(consulta.getHcolnumero());
				report.setHredfecharegis(consulta.getHcodfecregistr());
				lstReporte.add(report);

				if (PROTEINURIA != null && !PROTEINURIA.equals("")) {
					s = "Proteinuria: " + PROTEINURIA;
				} else {
					s = "";
				}
				if (HEMATIES != null && !HEMATIES.equals("")) {
					s2 = "Hematies:  " + HEMATIES;
				} else {
					s2 = "";
				}

				if (LEUCOCITOS != null && !LEUCOCITOS.equals("")) {
					s3 = "Leucocitos:  " + LEUCOCITOS;
				} else {
					s3 = "";
				}

				report = new Chreporte();
				report.setHrecdescripcio(s);
				report.setHrecdescripcio2(s2);
				report.setHrecdescripcio3(s3);
				report.setHrectipodescri("Tamizaje Laboratorios");
				report.setHrencodigo(imp_tamizaje_prenatal);
				report.setHrentipoimpres(5);
				report.setHrenconsulta(consulta.getHcolnumero());
				report.setHredfecharegis(consulta.getHcodfecregistr());
				lstReporte.add(report);

				if (tamizaje.getHtlcparorides() != null) {

					report = new Chreporte();
					report.setHrecdescripcio("DescripciNn Parcial Orina:  " + tamizaje.getHtlcparorides());
					report.setHrectipodescri("Tamizaje Laboratorios");
					report.setHrencodigo(imp_tamizaje_prenatal);
					report.setHrentipoimpres(1);
					report.setHrenconsulta(consulta.getHcolnumero());
					report.setHredfecharegis(consulta.getHcodfecregistr());
					lstReporte.add(report);
				}

			}
		}
	}

	public void imprimirAntecedentePsicologia(Chconsulta consulta) {

		if (consulta.getChpsicoantec() != null && !consulta.getChpsicoantec().isEmpty()) {

			Chpsicoantec antecedentesPsico = null;
			Iterator it = consulta.getChpsicoantec().iterator();
			if (it.hasNext()) {
				antecedentesPsico = (Chpsicoantec) it.next();
			}

			if (antecedentesPsico != null) {
				Chreporte report = new Chreporte();

				if (antecedentesPsico.getHpacpresedisca() != null) {
					report = new Chreporte();
					report.setHrecdescripcio("NPresenta algNn tipo de discapacidad?: " + PRESENTA_DISCAPACIDAD);
					if ("S".equals(antecedentesPsico.getHpacpresedisca())) {
						report.setHrecdescripcio2("Cual:" + CUAL_DISCAPACIDAD);
					} else {
						report.setHrecdescripcio2("");

					}
					report.setHrectipodescri("Antecedentes Psicologia");
					report.setHrencodigo(imp_antecedentes_psicologia);
					report.setHrentipoimpres(2);
					report.setHrenconsulta(consulta.getHcolnumero());
					report.setHredfecharegis(consulta.getHcodfecregistr());
					lstReporte.add(report);
				}

				if (antecedentesPsico.getHpactomamedi() != null) {
					report = new Chreporte();
					report.setHrecdescripcio("NActualmente toma algNn medicamento?: " + TOMA_MEDICAMENTO);
					if ("Si".equals(TOMA_MEDICAMENTO)) {
						report.setHrecdescripcio2("Cual:" + CUAL_MEDICAMENT);
					} else {
						report.setHrecdescripcio2("");

					}
					report.setHrectipodescri("Antecedetes Psicologia");
					report.setHrencodigo(imp_antecedentes_psicologia);
					report.setHrentipoimpres(2);
					report.setHrenconsulta(consulta.getHcolnumero());
					report.setHredfecharegis(consulta.getHcodfecregistr());
					lstReporte.add(report);
				}

				if (antecedentesPsico.getHpactrastmenta() != null) {
					report = new Chreporte();
					report.setHrecdescripcio("NPresenta algNn trastorno mental?: " + TRASTORNO_MENTAL);
					if ("Si".equals(TRASTORNO_MENTAL)) {
						report.setHrecdescripcio2("Cual:" + CUAL_TRASTOR);
					} else {
						report.setHrecdescripcio2("");

					}

					report.setHrectipodescri("Antecedentes Psicologia");
					report.setHrencodigo(imp_antecedentes_psicologia);
					report.setHrentipoimpres(2);
					report.setHrenconsulta(consulta.getHcolnumero());
					report.setHredfecharegis(consulta.getHcodfecregistr());
					lstReporte.add(report);
				}

				if (antecedentesPsico.getHpacenfediag() != null) {
					report = new Chreporte();
					report.setHrecdescripcio(
							"NActualmente tiene alguna enfermedad mNdica diagnosticada?: " + ENFERME_DIAG);
					if ("Si".equals(ENFERME_DIAG)) {
						report.setHrecdescripcio2("Cual:" + CUAL_ENFERDIAG);
					} else {
						report.setHrecdescripcio2("");

					}

					report.setHrectipodescri("Antecedentes Psicologia");
					report.setHrencodigo(imp_antecedentes_psicologia);
					report.setHrentipoimpres(2);
					report.setHrenconsulta(consulta.getHcolnumero());
					report.setHredfecharegis(consulta.getHcodfecregistr());
					lstReporte.add(report);
				}

				if (antecedentesPsico.getHpacvidasexac() != null) {
					report = new Chreporte();
					report.setHrecdescripcio("NTiene vida sexual activa?: " + VIDA_SEXACTIVA);
					report.setHrectipodescri("Antecedentes Psicologia");
					report.setHrencodigo(imp_antecedentes_psicologia);
					report.setHrentipoimpres(1);
					report.setHrenconsulta(consulta.getHcolnumero());
					report.setHredfecharegis(consulta.getHcodfecregistr());
					lstReporte.add(report);
				}

				if (antecedentesPsico.getHpacrelacsatis() != null) {
					report = new Chreporte();
					report.setHrecdescripcio("NTiene relaciones sexuales satisfactorias?: " + TIENE_RELASEXUALES);
					report.setHrectipodescri("Antecedentes Psicologia");
					report.setHrencodigo(imp_antecedentes_psicologia);
					report.setHrentipoimpres(1);
					report.setHrenconsulta(consulta.getHcolnumero());
					report.setHredfecharegis(consulta.getHcodfecregistr());
					lstReporte.add(report);
				}

				if (antecedentesPsico.getHpachabitsalud() != null) {
					report = new Chreporte();
					report.setHrecdescripcio("NTiene hNbitos de vida saludable?: " + HABITO_SALUDABLE);

					if ("Si".equals(HABITO_SALUDABLE)) {
						report.setHrecdescripcio2("Cual:" + CUALES_HABITOS);
					} else {
						report.setHrecdescripcio2("");

					}
					report.setHrectipodescri("Antecedentes Psicologia");
					report.setHrencodigo(imp_antecedentes_psicologia);
					report.setHrentipoimpres(2);
					report.setHrenconsulta(consulta.getHcolnumero());
					report.setHredfecharegis(consulta.getHcodfecregistr());
					lstReporte.add(report);
				}

				if (antecedentesPsico.getHpacquitavida() != null) {
					report = new Chreporte();
					report.setHrecdescripcio("NHa intentado quitarse la vida?: " + INTENTO_QUITARSEVIDA);

					if ("Si".equals(INTENTO_QUITARSEVIDA)) {
						report.setHrecdescripcio2("Cual:" + MANERAS_QUITARSEVIDA);
					} else {
						report.setHrecdescripcio2("");

					}
					report.setHrectipodescri("Antecedentes Psicologia");
					report.setHrencodigo(imp_antecedentes_psicologia);
					report.setHrentipoimpres(2);
					report.setHrenconsulta(consulta.getHcolnumero());
					report.setHredfecharegis(consulta.getHcodfecregistr());
					lstReporte.add(report);
				}

				if (antecedentesPsico.getHpacviolesexual() != null) {
					report = new Chreporte();
					report.setHrecdescripcio("NHa experimentado algNn tipo de violencia Sexual?: ");

					if ("S".equals(TIPO_VIOLENCIA_SEXUAL)) {
						report.setHrecdescripcio2("SI");
					} else {
						report.setHrecdescripcio2("NO");

					}
					report.setHrectipodescri("Antecedentes Psicologia");
					report.setHrencodigo(imp_antecedentes_psicologia);
					report.setHrentipoimpres(2);
					report.setHrenconsulta(consulta.getHcolnumero());
					report.setHredfecharegis(consulta.getHcodfecregistr());
					lstReporte.add(report);
				}

				if (antecedentesPsico.getHpacviolefisic() != null) {
					report = new Chreporte();
					report.setHrecdescripcio("NHa experimentado algNn tipo de violencia Fisica?: ");

					if ("F".equals(TIPO_VIOLENCIA_FISICA)) {
						report.setHrecdescripcio2("SI");
					} else {
						report.setHrecdescripcio2("NO");

					}
					report.setHrectipodescri("Antecedetes Psicologia");
					report.setHrencodigo(imp_antecedentes_psicologia);
					report.setHrentipoimpres(2);
					report.setHrenconsulta(consulta.getHcolnumero());
					report.setHredfecharegis(consulta.getHcodfecregistr());
					lstReporte.add(report);
				}

				if (antecedentesPsico.getHpacvioleecono() != null) {
					report = new Chreporte();
					report.setHrecdescripcio("NHa experimentado algNn tipo de violencia Economica?: ");

					if ("E".equals(antecedentesPsico.getHpacvioleecono())) {
						report.setHrecdescripcio2("SI");
					} else {
						report.setHrecdescripcio2("");

					}
					report.setHrectipodescri("Antecedentes Psicologia");
					report.setHrencodigo(imp_antecedentes_psicologia);
					report.setHrentipoimpres(2);
					report.setHrenconsulta(consulta.getHcolnumero());
					report.setHredfecharegis(consulta.getHcodfecregistr());
					lstReporte.add(report);
				}

				if (antecedentesPsico.getHpacviolepsico() != null) {
					report = new Chreporte();
					report.setHrecdescripcio("NHa experimentado algNn tipo de violencia Psicologica?: ");

					if ("P".equals(TIPO_VIOLENCIA_PSICOLOGICA)) {
						report.setHrecdescripcio2("SI");
					} else {
						report.setHrecdescripcio2("");

					}
					report.setHrectipodescri("Antecedentes Psicologia");
					report.setHrencodigo(imp_antecedentes_psicologia);
					report.setHrentipoimpres(2);
					report.setHrenconsulta(consulta.getHcolnumero());
					report.setHredfecharegis(consulta.getHcodfecregistr());
					lstReporte.add(report);
				}

				if (antecedentesPsico.getHpacsustapsico() != null) {
					report = new Chreporte();
					report.setHrecdescripcio("NHa consumido o consume algNn tipo de sustancia psicoactiva?: ");

					if ("Si".equals(SUSTANCIA_PSICOACTIVA)) {
						report.setHrecdescripcio2("Cual:" + CUAL_SUSTANCIA);
					} else {
						report.setHrecdescripcio2("");

					}
					report.setHrectipodescri("Antecedentes Psicologia");
					report.setHrencodigo(imp_antecedentes_psicologia);
					report.setHrentipoimpres(2);
					report.setHrenconsulta(consulta.getHcolnumero());
					report.setHredfecharegis(consulta.getHcodfecregistr());
					lstReporte.add(report);
				}

				if (antecedentesPsico.getHpacvicconfarm() != null) {
					report = new Chreporte();
					report.setHrecdescripcio("NEs vNctima de conflicto armado?: " + VICTIMA_CONFARMADO);

					if ("Si".equals(VICTIMA_CONFARMADO)) {
						report.setHrecdescripcio2("Si");
					} else {
						report.setHrecdescripcio2("");

					}
					report.setHrectipodescri("Antecedetes Psicologia");
					report.setHrencodigo(imp_antecedentes_psicologia);
					report.setHrentipoimpres(2);
					report.setHrenconsulta(consulta.getHcolnumero());
					report.setHredfecharegis(consulta.getHcodfecregistr());
					lstReporte.add(report);
				}

				Chusuario usu = null;
				int edad;
				try {
					usu = this.getServiceLocator().getClinicoService()
							.getUsuarioPorPk(consulta.getHcolusuario().getHuslnumero());
				} catch (ModelException e) {
					e.printStackTrace();
				}
				if (null != usu && null != usu.getHusanumeiden()) {
					edad = calcularEdad(usu.getHusdfechanacim(), new Date());

					if (edad <= 12) {
						if (antecedentesPsico.getHpanedadhabla() != null) {
							report = new Chreporte();
							report.setHrecdescripcio("NA quN edad hablo?: ");

							if (EDAD_HABLO != null) {
								report.setHrecdescripcio2(EDAD_HABLO);
							} else {
								report.setHrecdescripcio2("");

							}
							report.setHrectipodescri("Antecedetes Psicologia");
							report.setHrencodigo(imp_antecedentes_psicologia);
							report.setHrentipoimpres(2);
							report.setHrenconsulta(consulta.getHcolnumero());
							report.setHredfecharegis(consulta.getHcodfecregistr());
							lstReporte.add(report);
						}

						if (antecedentesPsico.getHpanedadgateo() != null) {
							report = new Chreporte();
							report.setHrecdescripcio("NA quN edad gateo?: ");

							if (EDAD_GATEO != null) {
								report.setHrecdescripcio2(EDAD_GATEO);
							} else {
								report.setHrecdescripcio2("");

							}
							report.setHrectipodescri("Antecedetes Psicologia");
							report.setHrencodigo(imp_antecedentes_psicologia);
							report.setHrentipoimpres(2);
							report.setHrenconsulta(consulta.getHcolnumero());
							report.setHredfecharegis(consulta.getHcodfecregistr());
							lstReporte.add(report);
						}

						if (antecedentesPsico.getHpanedadcamino() != null) {
							report = new Chreporte();
							report.setHrecdescripcio("NA quN edad camino?: ");

							if (EDAD_CAMINO != null) {
								report.setHrecdescripcio2(EDAD_CAMINO);
							} else {
								report.setHrecdescripcio2("");

							}
							report.setHrectipodescri("Antecedetes Psicologia");
							report.setHrencodigo(imp_antecedentes_psicologia);
							report.setHrentipoimpres(2);
							report.setHrenconsulta(consulta.getHcolnumero());
							report.setHredfecharegis(consulta.getHcodfecregistr());
							lstReporte.add(report);
						}

						if (antecedentesPsico.getHpanhorasduerm() != null) {
							report = new Chreporte();
							report.setHrecdescripcio("NCuNntas horas duerme?: ");

							if (HORAS_DUERME != null) {
								report.setHrecdescripcio2(HORAS_DUERME);
							} else {
								report.setHrecdescripcio2("");

							}
							report.setHrectipodescri("Antecedetes Psicologia");
							report.setHrencodigo(imp_antecedentes_psicologia);
							report.setHrentipoimpres(2);
							report.setHrenconsulta(consulta.getHcolnumero());
							report.setHredfecharegis(consulta.getHcodfecregistr());
							lstReporte.add(report);
						}

						if (antecedentesPsico.getHpacdificapren() != null) {
							report = new Chreporte();
							report.setHrecdescripcio(
									"NHa presentado dificultades de aprendizaje?: " + DIFICULTAD_APRENDE);

							if ("Si".equals(DIFICULTAD_APRENDE)) {
								report.setHrecdescripcio2("Cual:" + CUALES_DISFICULTAD);
							} else {
								report.setHrecdescripcio2("");

							}
							report.setHrectipodescri("Antecedetes Psicologia");
							report.setHrencodigo(imp_antecedentes_psicologia);
							report.setHrentipoimpres(2);
							report.setHrenconsulta(consulta.getHcolnumero());
							report.setHredfecharegis(consulta.getHcodfecregistr());
							lstReporte.add(report);
						}

						if (antecedentesPsico.getHpacsociapare() != null) {
							report = new Chreporte();
							report.setHrecdescripcio("NSocializa fNcilmente con pares?: " + SOCIALIZA);

							if ("Si".equals(SOCIALIZA)) {
								report.setHrecdescripcio2("Cual:" + OBSERVACIONES_SOCIALIZA);
							} else {
								report.setHrecdescripcio2("");

							}
							report.setHrectipodescri("Antecedetes Psicologia");
							report.setHrencodigo(imp_antecedentes_psicologia);
							report.setHrentipoimpres(2);
							report.setHrenconsulta(consulta.getHcolnumero());
							report.setHredfecharegis(consulta.getHcodfecregistr());
							lstReporte.add(report);
						}

						if (antecedentesPsico.getHpacrutiesta() != null) {
							report = new Chreporte();
							report.setHrecdescripcio("NTienen rutinas establecidas?: " + RUTINA);

							if ("Si".equals(RUTINA)) {
								report.setHrecdescripcio2("Cual:" + CUAL_RUTINA);
							} else {
								report.setHrecdescripcio2("");

							}
							report.setHrectipodescri("Antecedetes Psicologia");
							report.setHrencodigo(imp_antecedentes_psicologia);
							report.setHrentipoimpres(2);
							report.setHrenconsulta(consulta.getHcolnumero());
							report.setHredfecharegis(consulta.getHcodfecregistr());
							lstReporte.add(report);
						}

						if (antecedentesPsico.getHpactemppred() != null) {
							report = new Chreporte();
							report.setHrecdescripcio("NCNal es el temperamento predominante?: " + TEMPERAMENTO);

							if ("Si".equals(TEMPERAMENTO)) {
								report.setHrecdescripcio2("Cual:" + OBSE_TEMPERAMENTO);
							} else {
								report.setHrecdescripcio2("");

							}
							report.setHrectipodescri("Antecedetes Psicologia");
							report.setHrencodigo(imp_antecedentes_psicologia);
							report.setHrentipoimpres(2);
							report.setHrenconsulta(consulta.getHcolnumero());
							report.setHredfecharegis(consulta.getHcodfecregistr());
							lstReporte.add(report);
						}
					}
				}
			}

		}
	}

	public void imprimirInformePsicologico(Chconsulta consulta) {

		if (consulta.getChinfopsico() != null && !consulta.getChinfopsico().isEmpty()) {

			Chinfopsico informePsicologico = null;
			Iterator it = consulta.getChinfopsico().iterator();
			if (it.hasNext()) {
				informePsicologico = (Chinfopsico) it.next();
			}

			if (informePsicologico != null) {
				Chreporte report = new Chreporte();

				report = new Chreporte();
				report.setHrecdescripcio(
						"Motivo de Informe: " + formatearCampo(informePsicologico.getHipcmotivinfor()));
				report.setHrectipodescri("Informe Psicologico");
				report.setHrencodigo(imp_informe_psicologico);
				report.setHrentipoimpres(1);
				report.setHrenconsulta(consulta.getHcolnumero());
				report.setHredfecharegis(consulta.getHcodfecregistr());
				lstReporte.add(report);

				report = new Chreporte();
				report.setHrecdescripcio(
						"TNcnicas e Instrumentos Utilizados: " + formatearCampo(informePsicologico.getHipctecinsutl()));
				report.setHrectipodescri("Informe Psicologico");
				report.setHrencodigo(imp_informe_psicologico);
				report.setHrentipoimpres(1);
				report.setHrenconsulta(consulta.getHcolnumero());
				report.setHredfecharegis(consulta.getHcodfecregistr());
				lstReporte.add(report);

				report = new Chreporte();
				report.setHrecdescripcio(
						"DescripciNn del Caso: " + formatearCampo(informePsicologico.getHipcdesccaso()));
				report.setHrectipodescri("Informe Psicologico");
				report.setHrencodigo(imp_informe_psicologico);
				report.setHrentipoimpres(1);
				report.setHrenconsulta(consulta.getHcolnumero());
				report.setHredfecharegis(consulta.getHcodfecregistr());
				lstReporte.add(report);

				report = new Chreporte();
				report.setHrecdescripcio(
						"Conclusiones y Recomendaciones: " + formatearCampo(informePsicologico.getHipcconcreco()));
				report.setHrectipodescri("Informe Psicologico");
				report.setHrencodigo(imp_informe_psicologico);
				report.setHrentipoimpres(1);
				report.setHrenconsulta(consulta.getHcolnumero());
				report.setHredfecharegis(consulta.getHcodfecregistr());
				lstReporte.add(report);
			}
		}
	}

	public void imprimirEscalaValoracionCaidas(Chconsulta consulta) {

		if (consulta != null && consulta.getChescvalcai() != null && !consulta.getChescvalcai().isEmpty()) {

			String caidasPreviasSeleccionados;

			String medicamentosSeleccionados;

			String deficitSensorialSeleccionados;

			String estadoMentalSeleccionados;

			String deambulacionSeleccionados;

			Iterator it = consulta.getChescvalcai().iterator();
			while (it.hasNext()) {
				Chescvalcai escalaValoracionCaidas = null;
				escalaValoracionCaidas = (Chescvalcai) it.next();
				Chreporte report = new Chreporte();

				if (escalaValoracionCaidas != null) {

					caidasPreviasSeleccionados = "";

					medicamentosSeleccionados = "";

					deficitSensorialSeleccionados = "";

					estadoMentalSeleccionados = "";

					deambulacionSeleccionados = "";

					report = new Chreporte();
					report.setHrecdescripcio(
							"Fecha: " + formatearCampoHora(escalaValoracionCaidas.getHevcdfecregistr()));
					report.setHrectipodescri("Escala de Valoracion de Caidas");
					report.setHrencodigo(imp_escala_valoracion_caidas);
					report.setHrentipoimpres(1);
					report.setHrenconsulta(consulta.getHcolnumero());
					report.setHredfecharegis(consulta.getHcodfecregistr());
					lstReporte.add(report);

					report = new Chreporte();
					report.setHrecdescripcio(
							"Usuario Registro: " + formatearCampo(escalaValoracionCaidas.getHevccoperador()));
					report.setHrectipodescri("Escala de Valoracion de Caidas");
					report.setHrencodigo(imp_escala_valoracion_caidas);
					report.setHrentipoimpres(1);
					report.setHrenconsulta(consulta.getHcolnumero());
					report.setHredfecharegis(consulta.getHcodfecregistr());
					lstReporte.add(report);

					if (escalaValoracionCaidas.getHevccaidprev() != null) {
						if ("S".equals(escalaValoracionCaidas.getHevccaidprev())) {
							caidasPreviasSeleccionados = "Si";
						} else if ("N".equals(escalaValoracionCaidas.getHevccaidprev())) {
							caidasPreviasSeleccionados = "No";
						}

						if (!"".equals(caidasPreviasSeleccionados)) {
							report = new Chreporte();
							report.setHrecdescripcio("Caidas Previas: " + formatearCampo(caidasPreviasSeleccionados));
							report.setHrectipodescri("Escala de Valoracion de Caidas");
							report.setHrencodigo(imp_escala_valoracion_caidas);
							report.setHrentipoimpres(1);
							report.setHrenconsulta(consulta.getHcolnumero());
							report.setHredfecharegis(consulta.getHcodfecregistr());
							lstReporte.add(report);
						}
					}

					if (escalaValoracionCaidas.getHevccmedicamen() != null) {

						StringTokenizer st = new StringTokenizer(escalaValoracionCaidas.getHevccmedicamen(), ",");
						while (st.hasMoreTokens()) {
							String medicamento = st.nextToken();

							if (medicamento.equals("NI")) {
								medicamentosSeleccionados = medicamentosSeleccionados + "Ninguno,";
							}
							if (medicamento.equals("DI")) {
								medicamentosSeleccionados = medicamentosSeleccionados + "DiurNticos,";
							}
							if (medicamento.equals("AN")) {
								medicamentosSeleccionados = medicamentosSeleccionados + "Antiparkinsonianos,";
							}
							if (medicamento.equals("TS")) {
								medicamentosSeleccionados = medicamentosSeleccionados + "Tranquilizantes, sedantes,";
							}
							if (medicamento.equals("HND")) {
								medicamentosSeleccionados = medicamentosSeleccionados + "Hipotensores no diurNticos,";
							}
							if (medicamento.equals("AD")) {
								medicamentosSeleccionados = medicamentosSeleccionados + "Antidepresivos,";
							}
							if (medicamento.equals("AO")) {
								medicamentosSeleccionados = medicamentosSeleccionados + "AnalgNsicos Opioides,";
							}
						}
						if (!"".equals(medicamentosSeleccionados)) {
							report = new Chreporte();
							report.setHrecdescripcio("Medicamentos: " + formatearCampo(
									medicamentosSeleccionados.substring(0, (medicamentosSeleccionados.length() - 1))));
							report.setHrectipodescri("Escala de Valoracion de Caidas");
							report.setHrencodigo(imp_escala_valoracion_caidas);
							report.setHrentipoimpres(1);
							report.setHrenconsulta(consulta.getHcolnumero());
							report.setHredfecharegis(consulta.getHcodfecregistr());
							lstReporte.add(report);
						}
					}

					if (escalaValoracionCaidas.getHevccdefisens() != null) {

						StringTokenizer st = new StringTokenizer(escalaValoracionCaidas.getHevccdefisens(), ",");
						while (st.hasMoreTokens()) {
							String medicamento = st.nextToken();

							if (medicamento.equals("NI")) {
								deficitSensorialSeleccionados = deficitSensorialSeleccionados + "Ninguno,";
							}
							if (medicamento.equals("AV")) {
								deficitSensorialSeleccionados = deficitSensorialSeleccionados
										+ "Alteraciones visuales,";
							}
							if (medicamento.equals("AA")) {
								deficitSensorialSeleccionados = deficitSensorialSeleccionados
										+ "Alteraciones auditivas,";
							}
							if (medicamento.equals("DM")) {
								deficitSensorialSeleccionados = deficitSensorialSeleccionados + "DNficit de miembros,";
							}
						}

						if (!"".equals(deficitSensorialSeleccionados)) {
							report = new Chreporte();
							report.setHrecdescripcio(
									"DNficit sensorial: " + formatearCampo(deficitSensorialSeleccionados.substring(0,
											(deficitSensorialSeleccionados.length() - 1))));
							report.setHrectipodescri("Escala de Valoracion de Caidas");
							report.setHrencodigo(imp_escala_valoracion_caidas);
							report.setHrentipoimpres(1);
							report.setHrenconsulta(consulta.getHcolnumero());
							report.setHredfecharegis(consulta.getHcodfecregistr());
							lstReporte.add(report);
						}
					}

					if (escalaValoracionCaidas.getHevccestament() != null) {

						if ("OR".equals(escalaValoracionCaidas.getHevccestament())) {
							estadoMentalSeleccionados = "Orientado";
						} else if ("CO".equals(escalaValoracionCaidas.getHevccestament())) {
							estadoMentalSeleccionados = "Confuso";
						}
						if (!"".equals(estadoMentalSeleccionados)) {
							report = new Chreporte();
							report.setHrecdescripcio("Estado Mental: " + formatearCampo(estadoMentalSeleccionados));
							report.setHrectipodescri("Escala de Valoracion de Caidas");
							report.setHrencodigo(imp_escala_valoracion_caidas);
							report.setHrentipoimpres(1);
							report.setHrenconsulta(consulta.getHcolnumero());
							report.setHredfecharegis(consulta.getHcodfecregistr());
							lstReporte.add(report);
						}
					}

					if (escalaValoracionCaidas.getHevccdeambula() != null) {

						StringTokenizer st = new StringTokenizer(escalaValoracionCaidas.getHevccdeambula(), ",");
						while (st.hasMoreTokens()) {
							String deambulacion = st.nextToken();

							if (deambulacion.equals("NO")) {
								deambulacionSeleccionados = deambulacionSeleccionados + "Normal,";
							}
							if (deambulacion.equals("SSA")) {
								deambulacionSeleccionados = deambulacionSeleccionados + "Segura sin ayuda,";
							}
							if (deambulacion.equals("AEA")) {
								deambulacionSeleccionados = deambulacionSeleccionados
										+ "Asistida con elementos de apoyo,";
							}
							if (deambulacion.equals("RAI")) {
								deambulacionSeleccionados = deambulacionSeleccionados + "Reposo absoluto o imposible,";
							}
						}

						if (!"".equals(deambulacionSeleccionados)) {
							report = new Chreporte();
							report.setHrecdescripcio2("DeambulaciNn: " + formatearCampo(
									deambulacionSeleccionados.substring(0, (deambulacionSeleccionados.length() - 1))));
							report.setHrectipodescri("Escala de Valoracion de Caidas");
							report.setHrencodigo(imp_escala_valoracion_caidas);
							report.setHrentipoimpres(1);
							report.setHrenconsulta(consulta.getHcolnumero());
							report.setHredfecharegis(consulta.getHcodfecregistr());
							lstReporte.add(report);
						}
					}

					report = new Chreporte();
					report.setHrecdescripcio("Puntos: " + formatearCampo(escalaValoracionCaidas.getHevccpuntos()));
					report.setHrectipodescri("Escala de Valoracion de Caidas");
					report.setHrencodigo(imp_escala_valoracion_caidas);
					report.setHrentipoimpres(1);
					report.setHrenconsulta(consulta.getHcolnumero());
					report.setHredfecharegis(consulta.getHcodfecregistr());
					lstReporte.add(report);

					report = new Chreporte();
					report.setHrecdescripcio(
							"****************************************************************************************************************************************************************");
					report.setHrectipodescri("Escala de Valoracion de Caidas");
					report.setHrencodigo(imp_escala_valoracion_caidas);
					report.setHrentipoimpres(1);
					report.setHrenconsulta(consulta.getHcolnumero());
					report.setHredfecharegis(consulta.getHcodfecregistr());
					lstReporte.add(report);

				}
			}
		}
	}

	public void impresionEcografiaFertilidad(Chconsulta consulta) {
		if (consulta.getChfertecog() != null && !consulta.getChfertecog().isEmpty()) {

			Chfertecog ecografia = null;
			Iterator it = consulta.getChfertecog().iterator();
			if (it.hasNext()) {
				ecografia = (Chfertecog) it.next();
			}
			if (ecografia != null) {
				Chreporte report = new Chreporte();
				String valor = "No";
				if (ecografia.getHfectomaecog() != null && ecografia.getHfectomaecog().equals("S")) {
					valor = "Si";
				}
				report.setHrecdescripcio("Se tomo EcografNa : " + valor);
				report.setHrectipodescri("Ecografia Fertilidad");
				report.setHrencodigo(imp_ecografia_fertilidad);
				report.setHrentipoimpres(1);
				report.setHrenconsulta(consulta.getHcolnumero());
				report.setHredfecharegis(consulta.getHcodfecregistr());
				lstReporte.add(report);

				report = new Chreporte();

				report.setHrecdescripcio("Utero : " + ecografia.getHfexutero());
				report.setHrecdescripcio2("Anexos : " + ecografia.getHfecanexos());
				report.setHrectipodescri("Ecografia Fertilidad");
				report.setHrencodigo(imp_ecografia_fertilidad);
				report.setHrentipoimpres(3);
				report.setHrenconsulta(consulta.getHcolnumero());
				report.setHredfecharegis(consulta.getHcodfecregistr());
				lstReporte.add(report);

				report = new Chreporte();

				report.setHrecdescripcio("Endometrio : " + ecografia.getHfecendometrio());
				report.setHrectipodescri("Ecografia Fertilidad");
				report.setHrencodigo(imp_ecografia_fertilidad);
				report.setHrentipoimpres(1);
				report.setHrenconsulta(consulta.getHcolnumero());
				report.setHredfecharegis(consulta.getHcodfecregistr());
				lstReporte.add(report);

				report = new Chreporte();
				valor = "No";
				if ("S".equals(ecografia.getHfecmultifol())) {
					valor = "Si";
				}
				report.setHrecdescripcio("Multifolicular : " + valor);
				report.setHrectipodescri("Ecografia Fertilidad");
				report.setHrencodigo(imp_ecografia_fertilidad);
				report.setHrentipoimpres(1);
				report.setHrenconsulta(consulta.getHcolnumero());
				report.setHredfecharegis(consulta.getHcodfecregistr());
				lstReporte.add(report);

				if ("N".equals(ecografia.getHfecmultifol())) {
					report = new Chreporte();
					report.setHrecdescripcio("Ovario Derecho : " + ecografia.getHfecovarioder());
					report.setHrecdescripcio2("Ovario Izquierdo : " + ecografia.getHfecovarioizq());
					report.setHrectipodescri("Ecografia Fertilidad");
					report.setHrencodigo(imp_ecografia_fertilidad);
					report.setHrentipoimpres(3);
					report.setHrenconsulta(consulta.getHcolnumero());
					report.setHredfecharegis(consulta.getHcodfecregistr());
					lstReporte.add(report);
				}
				report = new Chreporte();
				report.setHrecdescripcio("Observaciones : " + ecografia.getHfecobservac());
				report.setHrectipodescri("Ecografia Fertilidad");
				report.setHrencodigo(imp_ecografia_fertilidad);
				report.setHrentipoimpres(1);
				report.setHrenconsulta(consulta.getHcolnumero());
				report.setHredfecharegis(consulta.getHcodfecregistr());
				lstReporte.add(report);
			}

		}
	}

	public void impresionDatosFertilidad(Chconsulta consulta) {
		if (consulta.getChfertdato() != null && !consulta.getChfertdato().isEmpty()) {

			Chfertdato fertilidad = null;
			Iterator it = consulta.getChfertdato().iterator();
			if (it.hasNext()) {
				fertilidad = (Chfertdato) it.next();
			}
			if (fertilidad != null) {
				Chreporte report = new Chreporte();
				String valor = "No";
				if ("S".equals(fertilidad.getHfdcdonant())) {
					valor = "Si";
				}
				report.setHrecdescripcio("Donante de Gametos : " + valor);
				valor = "No";
				if ("S".equals(fertilidad.getHfdcpareja())) {
					valor = "Si";
				}
				report.setHrecdescripcio2("Tiene Pareja : " + valor);
				report.setHrectipodescri("Datos Fertilidad");
				report.setHrencodigo(imp_datos_fertilidad);
				report.setHrentipoimpres(3);
				report.setHrenconsulta(consulta.getHcolnumero());
				report.setHredfecharegis(consulta.getHcodfecregistr());
				lstReporte.add(report);

				report = new Chreporte();
				valor = "No";
				if ("S".equals(fertilidad.getHfdcnumpareja())) {
					valor = "Si";
				}
				report.setHrecdescripcio("Conoce el nNmero de identificaciNn de su pareja : " + valor);
				report.setHrectipodescri("Datos Fertilidad");
				report.setHrencodigo(imp_datos_fertilidad);
				report.setHrentipoimpres(1);
				report.setHrenconsulta(consulta.getHcolnumero());
				report.setHredfecharegis(consulta.getHcodfecregistr());
				lstReporte.add(report);
			}
			if (fertilidad.getHfdctipide() != null) {
				Chreporte report = new Chreporte();
				String valor = "ADULTO SIN IDENTIFICACION";
				if ("CC".equals(fertilidad.getHfdctipide())) {
					valor = "CEDULA DE CIUDADANIA";
				} else if ("TI".equals(fertilidad.getHfdctipide())) {
					valor = "TARJETA DE IDENTIDAD";
				} else if ("RC".equals(fertilidad.getHfdctipide())) {
					valor = "REGISTRO CIVIL";
				} else if ("CE".equals(fertilidad.getHfdctipide())) {
					valor = "CEDULA DE EXTRANJERIA";
				} else if ("PA".equals(fertilidad.getHfdctipide())) {
					valor = "PASAPORTE";
				} else if ("MS".equals(fertilidad.getHfdctipide())) {
					valor = "MENOR SIN IDENTIFICACION";
				} else if ("NI".equals(fertilidad.getHfdctipide())) {
					valor = "NIT";
				} else if ("PE".equals(fertilidad.getHfdctipide())) {
					valor = "PERMISO ESPECIAL PERMANENCIA";
				} else if ("SC".equals(fertilidad.getHfdctipide())) {
					valor = "SALVOCONDUCTO";
				}
				report.setHrecdescripcio("Tipo de IdentificaciNn : " + valor);

				report.setHrecdescripcio2("Numero de Identificacion : " + fertilidad.getHfdanumide());
				report.setHrectipodescri("Datos Fertilidad");
				report.setHrencodigo(imp_datos_fertilidad);
				report.setHrentipoimpres(2);
				report.setHrenconsulta(consulta.getHcolnumero());
				report.setHredfecharegis(consulta.getHcodfecregistr());
				lstReporte.add(report);

				report = new Chreporte();
				report.setHrecdescripcio("Primer Nombre : " + fertilidad.getHfdcprinom());
				if (fertilidad.getHfdcsegnom() != null) {
					report.setHrecdescripcio2("Segundo Nombre: " + fertilidad.getHfdcsegnom());
				}

				report.setHrectipodescri("Datos Fertilidad");
				report.setHrencodigo(imp_datos_fertilidad);
				report.setHrentipoimpres(3);
				report.setHrenconsulta(consulta.getHcolnumero());
				report.setHredfecharegis(consulta.getHcodfecregistr());
				lstReporte.add(report);

				report = new Chreporte();
				report.setHrecdescripcio("Primer Apellido : " + fertilidad.getHfdcpriape());
				if (fertilidad.getHfdcsegape() != null) {
					report.setHrecdescripcio2("Segundo Apellido: " + fertilidad.getHfdcsegape());
				}

				report.setHrectipodescri("Datos Fertilidad");
				report.setHrencodigo(imp_datos_fertilidad);
				report.setHrentipoimpres(3);
				report.setHrenconsulta(consulta.getHcolnumero());
				report.setHredfecharegis(consulta.getHcodfecregistr());
				lstReporte.add(report);

				report = new Chreporte();
				report.setHrecdescripcio("Fecha de Nacimiento : " + fertilidad.getHfddfecnac());

				report.setHrecdescripcio2("OcupaciNn : " + fertilidad.getHfdcocupac());

				report.setHrectipodescri("Datos Fertilidad");
				report.setHrencodigo(imp_datos_fertilidad);
				report.setHrentipoimpres(3);
				report.setHrenconsulta(consulta.getHcolnumero());
				report.setHredfecharegis(consulta.getHcodfecregistr());
				lstReporte.add(report);
			}

		}
	}

	public void generarReferenciaPaciente(Chconsulta consulta) {
		if (consulta.getChrefepaci() != null && !consulta.getChrefepaci().isEmpty()) {

			Chrefepaci referenciaPaciente = null;
			Iterator it = consulta.getChrefepaci().iterator();
			if (it.hasNext()) {
				referenciaPaciente = (Chrefepaci) it.next();
			}

			if (referenciaPaciente != null) {
				Chreporte report = new Chreporte();

				report = new Chreporte();
				report.setHrecdescripcio("Fecha Registro: " + formatearCampo(consulta.getHcodfecregistr()));
				report.setHrencodigo(imp_referencia_paciente);
				report.setHrectipodescri("Referencia Paciente");
				report.setHrentipoimpres(1);
				report.setHrenconsulta(consulta.getHcolnumero());
				report.setHredfecharegis(consulta.getHcodfecregistr());
				lstReporte.add(report);

				report = new Chreporte();
				report.setHrecdescripcio(
						"Referencia Paciente: " + formatearCampo(referenciaPaciente.getHrpcrefepaci()));
				report.setHrencodigo(imp_referencia_paciente);
				report.setHrectipodescri("Referencia Paciente");
				report.setHrentipoimpres(1);
				report.setHrenconsulta(consulta.getHcolnumero());
				report.setHredfecharegis(consulta.getHcodfecregistr());
				lstReporte.add(report);

				if ("S".equals(referenciaPaciente.getHrpcrefepaci())) {

					report = new Chreporte();
					report.setHrecdescripcio("Datos de IPS receptora");
					report.setHrencodigo(imp_referencia_paciente);
					report.setHrectipodescri("Referencia Paciente");
					report.setHrentipoimpres(1);
					report.setHrenconsulta(consulta.getHcolnumero());
					report.setHredfecharegis(consulta.getHcodfecregistr());
					lstReporte.add(report);

					if (referenciaPaciente.getHrpcinstrece() != null) {
						report = new Chreporte();
						report.setHrecdescripcio(
								"InstituciNn Receptora: " + formatearCampo(referenciaPaciente.getHrpcinstrece()));
						report.setHrencodigo(imp_referencia_paciente);
						report.setHrectipodescri("Referencia Paciente");
						report.setHrentipoimpres(1);
						report.setHrenconsulta(consulta.getHcolnumero());
						report.setHredfecharegis(consulta.getHcodfecregistr());
						lstReporte.add(report);
					}

					report = new Chreporte();
					report.setHrecdescripcio("Hora de confirmaciNn de la remisiNn: "
							+ formatearCampo(referenciaPaciente.getHrpchoraconf()) + ":"
							+ formatearCampo(referenciaPaciente.getHrpcminuconf()));
					report.setHrencodigo(imp_referencia_paciente);
					report.setHrectipodescri("Ingreso EnfermerNa");
					report.setHrentipoimpres(1);
					report.setHrenconsulta(consulta.getHcolnumero());
					report.setHredfecharegis(consulta.getHcodfecregistr());
					lstReporte.add(report);

					report = new Chreporte();
					report.setHrecdescripcio("Datos del trasporte ambulatorio");
					report.setHrencodigo(imp_referencia_paciente);
					report.setHrectipodescri("Referencia Paciente");
					report.setHrentipoimpres(1);
					report.setHrenconsulta(consulta.getHcolnumero());
					report.setHredfecharegis(consulta.getHcodfecregistr());
					lstReporte.add(report);

					if (referenciaPaciente.getHrpcpresambu() != null) {
						report = new Chreporte();
						report.setHrecdescripcio(
								"Prestador de ambulancia: " + formatearCampo(referenciaPaciente.getHrpcpresambu()));
						report.setHrencodigo(imp_referencia_paciente);
						report.setHrectipodescri("Referencia Paciente");
						report.setHrentipoimpres(1);
						report.setHrenconsulta(consulta.getHcolnumero());
						report.setHredfecharegis(consulta.getHcodfecregistr());
						lstReporte.add(report);

					}
					report = new Chreporte();
					String tipoAmbulancia = null;

					if ("BA".equals(referenciaPaciente.getHrpctipoambu())) {
						tipoAmbulancia = "BNsica";
					} else if ("ME".equals(referenciaPaciente.getHrpctipoambu())) {
						tipoAmbulancia = "Medicalizada";
					}
					report.setHrecdescripcio("Tipo de ambulancia: " + formatearCampo(tipoAmbulancia));
					report.setHrencodigo(imp_referencia_paciente);
					report.setHrectipodescri("Referencia Paciente");
					report.setHrentipoimpres(1);
					report.setHrenconsulta(consulta.getHcolnumero());
					report.setHredfecharegis(consulta.getHcodfecregistr());
					lstReporte.add(report);

					report = new Chreporte();
					report.setHrecdescripcio("Hora de llegada de la ambulancia a Profamilia: "
							+ formatearCampo(referenciaPaciente.getHrpchorallega() + ":"
									+ formatearCampo(referenciaPaciente.getHrpcminullega())));
					report.setHrencodigo(imp_referencia_paciente);
					report.setHrectipodescri("Referencia Paciente");
					report.setHrentipoimpres(1);
					report.setHrenconsulta(consulta.getHcolnumero());
					report.setHredfecharegis(consulta.getHcodfecregistr());
					lstReporte.add(report);

					if (referenciaPaciente.getHrpctripurecib() != null) {
						report = new Chreporte();
						report.setHrecdescripcio("Tripulante de ambulancia que recibe el paciente: "
								+ formatearCampo(referenciaPaciente.getHrpctripurecib()));
						report.setHrencodigo(imp_referencia_paciente);
						report.setHrectipodescri("Referencia Paciente");
						report.setHrentipoimpres(1);
						report.setHrenconsulta(consulta.getHcolnumero());
						report.setHredfecharegis(consulta.getHcodfecregistr());
						lstReporte.add(report);

					}

					report = new Chreporte();
					report.setHrecdescripcio(
							"Hora de salida de paciente: " + formatearCampo(referenciaPaciente.getHrpchorasali() + ":"
									+ formatearCampo(referenciaPaciente.getHrpcminusali())));
					report.setHrencodigo(imp_referencia_paciente);
					report.setHrectipodescri("Referencia Paciente");
					report.setHrentipoimpres(1);
					report.setHrenconsulta(consulta.getHcolnumero());
					report.setHredfecharegis(consulta.getHcodfecregistr());
					lstReporte.add(report);

					report = new Chreporte();
					report.setHrecdescripcio("Seguimiento");
					report.setHrencodigo(imp_referencia_paciente);
					report.setHrectipodescri("Referencia Paciente");
					report.setHrentipoimpres(1);
					report.setHrenconsulta(consulta.getHcolnumero());
					report.setHredfecharegis(consulta.getHcodfecregistr());
					lstReporte.add(report);

					report = new Chreporte();
					report.setHrecdescripcio("Hora de ingreso del paciente a la IPS receptora: "
							+ formatearCampo(referenciaPaciente.getHrpchorallega() + ":"
									+ formatearCampo(referenciaPaciente.getHrpcminullega())));
					report.setHrencodigo(imp_referencia_paciente);
					report.setHrectipodescri("Referencia Paciente");
					report.setHrentipoimpres(1);
					report.setHrenconsulta(consulta.getHcolnumero());
					report.setHredfecharegis(consulta.getHcodfecregistr());
					lstReporte.add(report);

					if (referenciaPaciente.getHrpcnomfunges() != null) {
						report = new Chreporte();
						report.setHrecdescripcio("Nombre del funcionario que gestionN la remisiNn: "
								+ formatearCampo(referenciaPaciente.getHrpcnomfunges()));
						report.setHrencodigo(imp_referencia_paciente);
						report.setHrectipodescri("Referencia Paciente");
						report.setHrentipoimpres(1);
						report.setHrenconsulta(consulta.getHcolnumero());
						report.setHredfecharegis(consulta.getHcodfecregistr());
						lstReporte.add(report);
					}

					report = new Chreporte();
					report.setHrecdescripcio(
							"****************************************************************************************************************************************************************");
					report.setHrencodigo(imp_referencia_paciente);
					report.setHrectipodescri("Referencia Paciente");
					report.setHrentipoimpres(1);
					report.setHrenconsulta(consulta.getHcolnumero());
					report.setHredfecharegis(consulta.getHcodfecregistr());
					lstReporte.add(report);
				}
			}
		}
	}

	public void imprimirCamposPatologia(Chconsulta consulta) {
		// para patologia
		if (consulta.getChmotivocons() != null && !consulta.getChmotivocons().isEmpty()) {
			Chmotivocon motivo = null;
			Iterator it = consulta.getChmotivocons().iterator();
			if (it.hasNext())
				motivo = (Chmotivocon) it.next();
			Chreporte report = new Chreporte();
			if (motivo != null && motivo.getHmcctrapatol() != null) {
				String traePatologia = "No";
				String tipoPatologia = "";
				String resultado = "Negativo";
				String biposia = "";
				String clasiHistol = "";
				String gradoTumor = "";
				if (motivo.getHmcctrapatol().equals("S")) {
					traePatologia = "Si";
				}
				report = new Chreporte();
				report.setHrectipodescri("Resultado de Patologia");
				report.setHrentipoimpres(1);
				report.setHrencodigo(imp_resultado_patologia);
				report.setHrenconsulta(consulta.getHcolnumero());
				report.setHredfecharegis(consulta.getHcodfecregistr());
				report.setHrecdescripcio("Trae PatologNa: " + traePatologia + "");
				lstReporte.add(report);
				if (!motivo.getHmcctrapatol().equals("N")) {
					if (("PR").equals(motivo.getHmcctippatol())) {
						tipoPatologia = "Prostata";
					} else if (("PE").equals(motivo.getHmcctippatol())) {
						tipoPatologia = "Pene";
					} else if (("PI").equals(motivo.getHmcctippatol())) {
						tipoPatologia = "Piel";
					} else if (("TI").equals(motivo.getHmcctippatol())) {
						tipoPatologia = "Tiroides";
					} else if (("GN").equals(motivo.getHmcctippatol())) {
						tipoPatologia = "Ganglio";
					} else if (("CX").equals(motivo.getHmcctippatol())) {
						tipoPatologia = "CNrvix";
					} else if (("EN").equals(motivo.getHmcctippatol())) {
						tipoPatologia = "Endometrio";
					} else if (("VU").equals(motivo.getHmcctippatol())) {
						tipoPatologia = "Vulva";
					} else if (("MA").equals(motivo.getHmcctippatol())) {
						tipoPatologia = "Mama";
					} else {
						tipoPatologia = "Otro";
					}
					report = new Chreporte();
					report.setHrectipodescri("Resultado de Patologia");
					report.setHrentipoimpres(1);
					report.setHrencodigo(imp_resultado_patologia);
					report.setHrenconsulta(consulta.getHcolnumero());
					report.setHredfecharegis(consulta.getHcodfecregistr());
					report.setHrecdescripcio("Tipo de PatologNa: " + tipoPatologia + "");
					lstReporte.add(report);

					if (tipoPatologia.equals("Otro")) {
						report = new Chreporte();
						report.setHrectipodescri("Resultado de Patologia");
						report.setHrentipoimpres(1);
						report.setHrencodigo(imp_resultado_patologia);
						report.setHrenconsulta(consulta.getHcolnumero());
						report.setHredfecharegis(consulta.getHcodfecregistr());
						report.setHrecdescripcio("NCual?: " + motivo.getHmcccualpat() + "");
						lstReporte.add(report);
					}
					if (motivo.getHmccdesres() != null) {
						report = new Chreporte();
						report.setHrectipodescri("Resultado de Patologia");
						report.setHrentipoimpres(1);
						report.setHrencodigo(imp_resultado_patologia);
						report.setHrenconsulta(consulta.getHcolnumero());
						report.setHredfecharegis(consulta.getHcodfecregistr());
						report.setHrecdescripcio("DescripciNn del Resultado: " + motivo.getHmccdesres() + "");
						lstReporte.add(report);
					} else {
						if (("NN").equals(motivo.getHmccresbiop())) {
							biposia = "Negativo para neoplasia";
						} else if (("DI").equals(motivo.getHmccresbiop())) {
							biposia = "Displasia";
						} else if (("NB").equals(motivo.getHmccresbiop())) {
							biposia = "NIC de bajo grado (NIC) I";
						} else if (("NA").equals(motivo.getHmccresbiop())) {
							biposia = "NIC de alto grado: (NIC II - NIC III)";
						} else if (("NM").equals(motivo.getHmccresbiop())) {
							biposia = "Neoplasia micro infiltrante: escamocelular o adenocarcinoma";
						} else if (("NI").equals(motivo.getHmccresbiop())) {
							biposia = "Neoplasia Infiltrante: escamocelular o adenocarcinoma";
						} else if (("BE").equals(motivo.getHmccresbiop())) {
							biposia = "Benigna";
						} else if (("AT").equals(motivo.getHmccresbiop())) {
							biposia = "AtNpica (Indeterminada)";
						} else if (("MS").equals(motivo.getHmccresbiop())) {
							biposia = "Malignidad sospechosa/probable";
						} else if (("MA").equals(motivo.getHmccresbiop())) {
							biposia = "Maligna";
						} else if (("NS").equals(motivo.getHmccresbiop())) {
							biposia = "No Satisfactoria";
						}
						report = new Chreporte();
						report.setHrectipodescri("Resultado de Patologia");
						report.setHrentipoimpres(1);
						report.setHrencodigo(imp_resultado_patologia);
						report.setHrenconsulta(consulta.getHcolnumero());
						report.setHredfecharegis(consulta.getHcodfecregistr());
						report.setHrecdescripcio("Resultado de biopsia: " + biposia + "");
						lstReporte.add(report);

					}
					if ("P".equals(motivo.getHmccrespatol())) {
						resultado = "Maligno";
					}
					report = new Chreporte();
					report.setHrectipodescri("Resultado de Patologia");
					report.setHrentipoimpres(1);
					report.setHrencodigo(imp_resultado_patologia);
					report.setHrenconsulta(consulta.getHcolnumero());
					report.setHredfecharegis(consulta.getHcodfecregistr());
					report.setHrecdescripcio("Resultado: " + resultado + "");
					lstReporte.add(report);

					if ("P".equals(motivo.getHmccrespatol()) && motivo.getHmnclashisto() != null) {

						if (motivo.getHmnclashisto() == 1) {
							clasiHistol = "1= Adenocarcinoma, con o sin otra especificaciNn";
						} else if (motivo.getHmnclashisto() == 2) {
							clasiHistol = "2= Carcinoma escamocelular (epidermoide), con o sin otra especificaciNn";
						} else if (motivo.getHmnclashisto() == 3) {
							clasiHistol = "3= Carcinoma de cNlulas basales (basocelular";
						} else if (motivo.getHmnclashisto() == 4) {
							clasiHistol = "4= Carcinoma, con o sin otra especificaciNn diferentes a las anteriores";
						} else if (motivo.getHmnclashisto() == 5) {
							clasiHistol = "5= Oligodendroglioma, con o sin otra especificaciNn";
						} else if (motivo.getHmnclashisto() == 6) {
							clasiHistol = "6= Astrocitoma, con o sin otra especificaciNn";
						} else if (motivo.getHmnclashisto() == 7) {
							clasiHistol = "7= Ependimoma, con o sin otra especificaciNn";
						} else if (motivo.getHmnclashisto() == 8) {
							clasiHistol = "8= Neuroblastoma, con o sin otra especificaciNn";
						} else if (motivo.getHmnclashisto() == 9) {
							clasiHistol = "9= Meduloblastoma, con o sin otra especificaciNn";
						} else if (motivo.getHmnclashisto() == 10) {
							clasiHistol = "10= Hepatoblastoma, con o sin otra especificaciNn";
						} else if (motivo.getHmnclashisto() == 11) {
							clasiHistol = "11= Rabdomiosarcoma, con o sin otra especificaciN";
						} else if (motivo.getHmnclashisto() == 12) {
							clasiHistol = "12= Leiomiosarcoma, con o sin otra especificaciNn";
						} else if (motivo.getHmnclashisto() == 13) {
							clasiHistol = "13= Osteosarcoma, con o sin otra especificaciNn";
						} else if (motivo.getHmnclashisto() == 14) {
							clasiHistol = "14= Fibrosarcoma, con o sin otra especificaciNn";
						} else if (motivo.getHmnclashisto() == 15) {
							clasiHistol = "15= Angiosarcoma, con o sin otra especificaciNn";
						} else if (motivo.getHmnclashisto() == 16) {
							clasiHistol = "16= Condrosarcoma, con o sin otra especificaciNn";
						} else if (motivo.getHmnclashisto() == 17) {
							clasiHistol = "17= Otros sarcomas, con o sin otra especificaciNn";
						} else if (motivo.getHmnclashisto() == 18) {
							clasiHistol = "18= Pancreatoblastoma, con o sin otra especificaciNn";
						} else if (motivo.getHmnclashisto() == 19) {
							clasiHistol = "19= Blastoma pleuropulmonar, con o sin otra especificaciNn";
						} else if (motivo.getHmnclashisto() == 20) {
							clasiHistol = "20= Otros tipos histolNgicos no mencionados";
						} else if (motivo.getHmnclashisto() == 21) {
							clasiHistol = "23= Melanoma";
						} else if (motivo.getHmnclashisto() == 22) {
							clasiHistol = "24= Carcinoma papilar de tiroides";
						}

						report = new Chreporte();
						report.setHrectipodescri("Resultado de Patologia");
						report.setHrentipoimpres(1);
						report.setHrencodigo(imp_resultado_patologia);
						report.setHrenconsulta(consulta.getHcolnumero());
						report.setHredfecharegis(consulta.getHcodfecregistr());
						report.setHrecdescripcio("ClasificaciNn histolNgica: " + clasiHistol + "");
						lstReporte.add(report);

						if (motivo.getHmngradtumor() == 1) {
							gradoTumor = "1= Bien diferenciado (grado1-GRADO BAJO)";
						} else if (motivo.getHmngradtumor() == 2) {
							gradoTumor = "2= Moderadamente diferenciado (grado 2 GRADO INTERMEDIO)";
						} else if (motivo.getHmngradtumor() == 3) {
							gradoTumor = "3= Mal diferenciado (grado 3 GRADO ALTO)";
						} else if (motivo.getHmngradtumor() == 4) {
							gradoTumor = "4= AnaplNsico o indiferenciado (grado 4)";
						}

						report = new Chreporte();
						report.setHrectipodescri("Resultado de Patologia");
						report.setHrentipoimpres(1);
						report.setHrencodigo(imp_resultado_patologia);
						report.setHrenconsulta(consulta.getHcolnumero());
						report.setHredfecharegis(consulta.getHcodfecregistr());
						report.setHrecdescripcio("Grado de diferenciaciNn del tumor: " + gradoTumor + "");
						lstReporte.add(report);

					}

				}
			}
		}
	}

	public void imprimirInformeCovidAnticuerpos(Chconsulta consulta) {

		if (consulta.getChpruecovidanticu() != null && !consulta.getChpruecovidanticu().isEmpty()) {

			Chpruecovidanticu informeAnticuerposCovid = null;
			Iterator it = consulta.getChpruecovidanticu().iterator();
			if (it.hasNext()) {
				informeAnticuerposCovid = (Chpruecovidanticu) it.next();
			}

			if (informeAnticuerposCovid != null) {
				Chreporte report = new Chreporte();

				report = new Chreporte();
				report.setHrecdescripcio(
						"Cerco epidemiolNgico : " + formatearCampo(informeAnticuerposCovid.getHpaccercepid()));
				report.setHrectipodescri("Prueba Covid Anticuerpos");
				report.setHrencodigo(imp_informe_anticuerposcovid);
				report.setHrentipoimpres(2);
				report.setHrenconsulta(consulta.getHcolnumero());
				report.setHredfecharegis(consulta.getHcodfecregistr());
				lstReporte.add(report);

				report = new Chreporte();
				report.setHrecdescripcio(
						"Trabajador de la salud : " + formatearCampo(informeAnticuerposCovid.getHpactrabsalud()));
				report.setHrectipodescri("Prueba Covid Anticuerpos");
				report.setHrencodigo(imp_informe_anticuerposcovid);
				report.setHrentipoimpres(2);
				report.setHrenconsulta(consulta.getHcolnumero());
				report.setHredfecharegis(consulta.getHcodfecregistr());

				lstReporte.add(report);

				report = new Chreporte();
				report.setHrecdescripcio("Nha tenido contacto estrecho en los Nltimos 14 dNas? : "
						+ formatearCampo(informeAnticuerposCovid.getHpaccontadias()));
				report.setHrectipodescri("Prueba Covid Anticuerpos");
				report.setHrencodigo(imp_informe_anticuerposcovid);
				report.setHrentipoimpres(2);
				report.setHrenconsulta(consulta.getHcolnumero());
				report.setHredfecharegis(consulta.getHcodfecregistr());

				lstReporte.add(report);

				report = new Chreporte();
				report.setHrecdescripcio("NEl paciente ha tenido sNntomas? : "
						+ formatearCampo(informeAnticuerposCovid.getHpacsintopaci()));
				report.setHrectipodescri("Prueba Covid Anticuerpos");
				report.setHrencodigo(imp_informe_anticuerposcovid);
				report.setHrentipoimpres(2);
				report.setHrenconsulta(consulta.getHcolnumero());
				report.setHredfecharegis(consulta.getHcodfecregistr());

				lstReporte.add(report);

				if (informeAnticuerposCovid.getHpadfecsinto() != null) {
					report = new Chreporte();
					report.setHrecdescripcio("Fecha de inicio de sNntomas:	 "
							+ formatearCampo(informeAnticuerposCovid.getHpadfecsinto()));
					report.setHrectipodescri("Prueba Covid Anticuerpos");
					report.setHrencodigo(imp_informe_anticuerposcovid);
					report.setHrentipoimpres(2);
					report.setHrenconsulta(consulta.getHcolnumero());
					report.setHredfecharegis(consulta.getHcodfecregistr());

					lstReporte.add(report);
				}

				if (informeAnticuerposCovid.getHpannumesintevol() != null) {
					report = new Chreporte();
					report.setHrecdescripcio("NNmero de dNas de evoluciNn de los sNntomas:   "
							+ informeAnticuerposCovid.getHpannumesintevol() + " Dias");
					report.setHrectipodescri("Prueba Covid Anticuerpos");
					report.setHrencodigo(imp_informe_anticuerposcovid);
					report.setHrentipoimpres(2);
					report.setHrenconsulta(consulta.getHcolnumero());
					report.setHredfecharegis(consulta.getHcodfecregistr());

					lstReporte.add(report);
				}

				report = new Chreporte();
				report.setHrecdescripcio("Lugar donde se toma la muestra:   "
						+ formatearLugarToma(informeAnticuerposCovid.getHpaclugatoma()));
				report.setHrectipodescri("Prueba Covid Anticuerpos");
				report.setHrencodigo(imp_informe_anticuerposcovid);
				report.setHrentipoimpres(2);
				report.setHrenconsulta(consulta.getHcolnumero());
				report.setHredfecharegis(consulta.getHcodfecregistr());

				lstReporte.add(report);

				report = new Chreporte();
				report.setHrecdescripcio(
						"Temperatura ambiental:   " + informeAnticuerposCovid.getHpantempambi() + " CN");
				report.setHrectipodescri("Prueba Covid Anticuerpos");
				report.setHrencodigo(imp_informe_anticuerposcovid);
				report.setHrentipoimpres(2);
				report.setHrenconsulta(consulta.getHcolnumero());
				report.setHredfecharegis(consulta.getHcodfecregistr());

				lstReporte.add(report);

				report = new Chreporte();
				report.setHrecdescripcio("Marca:   ONSITE RAPID TEST CTK BIOTECH");
				report.setHrectipodescri("Prueba Covid Anticuerpos");
				report.setHrencodigo(imp_informe_anticuerposcovid);
				report.setHrentipoimpres(2);
				report.setHrenconsulta(consulta.getHcolnumero());
				report.setHredfecharegis(consulta.getHcodfecregistr());

				lstReporte.add(report);

				report = new Chreporte();
				report.setHrecdescripcio("Lote:   " + informeAnticuerposCovid.getHpaclote());
				report.setHrectipodescri("Prueba Covid Anticuerpos");
				report.setHrencodigo(imp_informe_anticuerposcovid);
				report.setHrentipoimpres(2);
				report.setHrenconsulta(consulta.getHcolnumero());
				report.setHredfecharegis(consulta.getHcodfecregistr());

				lstReporte.add(report);

				report = new Chreporte();
				report.setHrecdescripcio("Registro Invima:   INVIMA 2020RD-0006148");
				report.setHrectipodescri("Prueba Covid Anticuerpos");
				report.setHrencodigo(imp_informe_anticuerposcovid);
				report.setHrentipoimpres(2);
				report.setHrenconsulta(consulta.getHcolnumero());
				report.setHredfecharegis(consulta.getHcodfecregistr());

				lstReporte.add(report);

				report = new Chreporte();
				report.setHrecdescripcio(
						"Fecha de fabricaciNn:   " + formatearCampo(informeAnticuerposCovid.getHpadfechfabr()));
				report.setHrectipodescri("Prueba Covid Anticuerpos");
				report.setHrencodigo(imp_informe_anticuerposcovid);
				report.setHrentipoimpres(2);
				report.setHrenconsulta(consulta.getHcolnumero());
				report.setHredfecharegis(consulta.getHcodfecregistr());

				lstReporte.add(report);

				report = new Chreporte();
				report.setHrecdescripcio(
						"Fecha de vencimiento:   " + formatearCampo(informeAnticuerposCovid.getHpadfechvenci()));
				report.setHrectipodescri("Prueba Covid Anticuerpos");
				report.setHrencodigo(imp_informe_anticuerposcovid);
				report.setHrentipoimpres(2);
				report.setHrenconsulta(consulta.getHcolnumero());
				report.setHredfecharegis(consulta.getHcodfecregistr());

				lstReporte.add(report);

				report = new Chreporte();
				report.setHrecdescripcio(
						"Resultado:   " + formatearCampoRH(informeAnticuerposCovid.getHpacresultado()));
				report.setHrectipodescri("Prueba Covid Anticuerpos");
				report.setHrencodigo(imp_informe_anticuerposcovid);
				report.setHrentipoimpres(2);
				report.setHrenconsulta(consulta.getHcolnumero());
				report.setHredfecharegis(consulta.getHcodfecregistr());
				lstReporte.add(report);

				if (informeAnticuerposCovid.getHpactipoantig() != null) {
					report = new Chreporte();
					if (informeAnticuerposCovid.getHpactipoantig().equals("Ig2")) {
						report.setHrecdescripcio("Tipo Antigeno:  IgG e IgM ");
					} else {
						report.setHrecdescripcio("Tipo Antigeno:   " + informeAnticuerposCovid.getHpactipoantig());
						report.setHrectipodescri("Prueba Covid Anticuerpos");
						report.setHrencodigo(imp_informe_anticuerposcovid);
						report.setHrentipoimpres(2);
						report.setHrenconsulta(consulta.getHcolnumero());
						report.setHredfecharegis(consulta.getHcodfecregistr());
						lstReporte.add(report);
					}

					report = new Chreporte();
					if (informeAnticuerposCovid.getHpacobserv() == null) {
						report.setHrecdescripcio("Observaciones:   ");
					} else {
						report.setHrecdescripcio("Observaciones:   " + informeAnticuerposCovid.getHpacobserv());
					}
					report.setHrectipodescri("Prueba Covid Anticuerpos");
					report.setHrencodigo(imp_informe_anticuerposcovid);
					report.setHrentipoimpres(2);
					report.setHrenconsulta(consulta.getHcolnumero());
					report.setHredfecharegis(consulta.getHcodfecregistr());

					lstReporte.add(report);

				}
			}
		}
	}

	public void imprimirInformeCovidAntigenos(Chconsulta consulta) {

		if (consulta.getChpruecovidantige() != null && !consulta.getChpruecovidantige().isEmpty()) {

			Chpruecovidantige informeAntigenosCovid = null;
			Iterator it = consulta.getChpruecovidantige().iterator();
			if (it.hasNext()) {
				informeAntigenosCovid = (Chpruecovidantige) it.next();
			}

			if (informeAntigenosCovid != null) {
				Chreporte report = new Chreporte();

				report = new Chreporte();
				report.setHrecdescripcio(
						"Trabajador de la salud : " + formatearCampo(informeAntigenosCovid.getHpgctrabsalud()));
				report.setHrectipodescri("Prueba Covid Antigenos");
				report.setHrencodigo(imp_informe_antigenoscovid);
				report.setHrentipoimpres(2);
				report.setHrenconsulta(consulta.getHcolnumero());
				report.setHredfecharegis(consulta.getHcodfecregistr());

				lstReporte.add(report);

				report = new Chreporte();
				report.setHrecdescripcio("Nha tenido contacto estrecho en los Nltimos 14 dNas? : "
						+ formatearCampo(informeAntigenosCovid.getHpgccontadias()));
				report.setHrectipodescri("Prueba Covid Antigenos");
				report.setHrencodigo(imp_informe_antigenoscovid);
				report.setHrentipoimpres(2);
				report.setHrenconsulta(consulta.getHcolnumero());
				report.setHredfecharegis(consulta.getHcodfecregistr());

				lstReporte.add(report);

				if (informeAntigenosCovid.getHpgdfecsinto() != null) {
					report = new Chreporte();
					report.setHrecdescripcio("Fecha de inicio de sNntomas:   "
							+ formatearCampo(informeAntigenosCovid.getHpgdfecsinto()));
					report.setHrectipodescri("Prueba Covid Antigenos");
					report.setHrencodigo(imp_informe_antigenoscovid);
					report.setHrentipoimpres(2);
					report.setHrenconsulta(consulta.getHcolnumero());
					report.setHredfecharegis(consulta.getHcodfecregistr());

					lstReporte.add(report);
				}

				report = new Chreporte();
				report.setHrecdescripcio("NEl paciente ha tenido sNntomas? : "
						+ formatearCampo(informeAntigenosCovid.getHpgcsintopaci()));
				report.setHrectipodescri("Prueba Covid Antigenos");
				report.setHrencodigo(imp_informe_antigenoscovid);
				report.setHrentipoimpres(2);
				report.setHrenconsulta(consulta.getHcolnumero());
				report.setHredfecharegis(consulta.getHcodfecregistr());

				lstReporte.add(report);

				if (informeAntigenosCovid.getHpgnnumesinto() != null) {
					report = new Chreporte();
					report.setHrecdescripcio("NNmero de dNas de inicio de sintomatologia:   "
							+ informeAntigenosCovid.getHpgnnumesinto() + " Dias");
					report.setHrectipodescri("Prueba Covid Antigenos");
					report.setHrencodigo(imp_informe_antigenoscovid);
					report.setHrentipoimpres(2);
					report.setHrenconsulta(consulta.getHcolnumero());
					report.setHredfecharegis(consulta.getHcodfecregistr());

					lstReporte.add(report);
				}

				report = new Chreporte();
				report.setHrecdescripcio("Lugar donde se toma la muestra:   "
						+ formatearLugarToma(informeAntigenosCovid.getHpgclugatoma()));
				report.setHrectipodescri("Prueba Covid Antigenos");
				report.setHrencodigo(imp_informe_antigenoscovid);
				report.setHrentipoimpres(2);
				report.setHrenconsulta(consulta.getHcolnumero());
				report.setHredfecharegis(consulta.getHcodfecregistr());

				lstReporte.add(report);

				report = new Chreporte();
				report.setHrecdescripcio("Lugar donde se procesa la muestra:   "
						+ formatearLugarToma(informeAntigenosCovid.getHpgclugaproc()));
				report.setHrectipodescri("Prueba Covid Antigenos");
				report.setHrencodigo(imp_informe_antigenoscovid);
				report.setHrentipoimpres(2);
				report.setHrenconsulta(consulta.getHcolnumero());
				report.setHredfecharegis(consulta.getHcodfecregistr());

				lstReporte.add(report);

				report = new Chreporte();
				report.setHrecdescripcio("Temperatura ambiental durante el procesamiento:   "
						+ informeAntigenosCovid.getHpgntempambi() + " CN");
				report.setHrectipodescri("Prueba Covid Antigenos");
				report.setHrencodigo(imp_informe_antigenoscovid);
				report.setHrentipoimpres(2);
				report.setHrenconsulta(consulta.getHcolnumero());
				report.setHredfecharegis(consulta.getHcodfecregistr());

				lstReporte.add(report);

				report = new Chreporte();
				report.setHrecdescripcio("Marca:   STANDAR Q COVID 19 SD BIOSENSOR INC.");
				report.setHrectipodescri("Prueba Covid Antigenos");
				report.setHrencodigo(imp_informe_antigenoscovid);
				report.setHrentipoimpres(2);
				report.setHrenconsulta(consulta.getHcolnumero());
				report.setHredfecharegis(consulta.getHcodfecregistr());

				lstReporte.add(report);

				report = new Chreporte();
				report.setHrecdescripcio("Lote:   " + informeAntigenosCovid.getHpgclote());
				report.setHrectipodescri("Prueba Covid Antigenos");
				report.setHrencodigo(imp_informe_antigenoscovid);
				report.setHrentipoimpres(2);
				report.setHrenconsulta(consulta.getHcolnumero());
				report.setHredfecharegis(consulta.getHcodfecregistr());

				lstReporte.add(report);

				report = new Chreporte();
				report.setHrecdescripcio("Registro Invima:   INVIMA 2020RD-0006130");
				report.setHrectipodescri("Prueba Covid Antigenos");
				report.setHrencodigo(imp_informe_antigenoscovid);
				report.setHrentipoimpres(2);
				report.setHrenconsulta(consulta.getHcolnumero());
				report.setHredfecharegis(consulta.getHcodfecregistr());

				lstReporte.add(report);

				report = new Chreporte();
				report.setHrecdescripcio(
						"Fecha de fabricaciNn:   " + formatearCampo(informeAntigenosCovid.getHpgdfechfabr()));
				report.setHrectipodescri("Prueba Covid Antigenos");
				report.setHrencodigo(imp_informe_antigenoscovid);
				report.setHrentipoimpres(2);
				report.setHrenconsulta(consulta.getHcolnumero());
				report.setHredfecharegis(consulta.getHcodfecregistr());

				lstReporte.add(report);

				report = new Chreporte();
				report.setHrecdescripcio(
						"Fecha de vencimiento:   " + formatearCampo(informeAntigenosCovid.getHpgdfechvenci()));
				report.setHrectipodescri("Prueba Covid Antigenos");
				report.setHrencodigo(imp_informe_antigenoscovid);
				report.setHrentipoimpres(2);
				report.setHrenconsulta(consulta.getHcolnumero());
				report.setHredfecharegis(consulta.getHcodfecregistr());

				lstReporte.add(report);

				report = new Chreporte();
				report.setHrecdescripcio("Resultado:   " + formatearCampoRH(informeAntigenosCovid.getHpgcresultado()));
				report.setHrectipodescri("Prueba Covid Antigenos");
				report.setHrencodigo(imp_informe_antigenoscovid);
				report.setHrentipoimpres(2);
				report.setHrenconsulta(consulta.getHcolnumero());
				report.setHredfecharegis(consulta.getHcodfecregistr());
				lstReporte.add(report);

				report = new Chreporte();
				if (informeAntigenosCovid.getHpgcobserv() == null) {
					report.setHrecdescripcio("Observaciones:   ");
				} else {
					report.setHrecdescripcio("Observaciones:   " + informeAntigenosCovid.getHpgcobserv());
				}
				report.setHrectipodescri("Prueba Covid Antigenos");
				report.setHrencodigo(imp_informe_antigenoscovid);
				report.setHrentipoimpres(2);
				report.setHrenconsulta(consulta.getHcolnumero());
				report.setHredfecharegis(consulta.getHcodfecregistr());

				lstReporte.add(report);

			}
		}
	}

	public String formatearCampoDosisVacunacion(int campo) {
		String respuesta = "";
		if (campo == 0) {
			respuesta = "";
		} else {

			if (campo == 1) {
				respuesta = "Primera Dosis";
			}
			if (campo == 2) {
				respuesta = "Segunda Dosis";
			}
			if (campo == 3) {
				respuesta = "Tercera Dosis";
			}

			if (campo == 6) {
				respuesta = "Refuerzo";
			}
			if (campo == 8) {
				respuesta = "Dosis Unica";
			}

		}

		return respuesta;
	}

	public String formatearCampoMedicamento(Chconsulta consulta) {

		String wnombremedicamento = "";
		if (consulta.getChmedicament() != null && !consulta.getChmedicament().isEmpty()) {

			for (Chmedicament medicamento : consulta.getChmedicament()) {
				if (medicamento != null) {

					if (medicamento.getHmentipohisto() != null
							&& medicamento.getHmentipohisto().equals(HISTORIA_ADMINISTRAR_MEDICAMENTO)
							|| tipoHistoria.equals(IConstantes.HISTORIA_VACUNACION)) {

						if (null != medicamento.getHmelcregiacti()) {

							wnombremedicamento = wnombremedicamento + " " + medicamento.getHmecmedicament();

						}

					}

				}

			}

		}

		return wnombremedicamento;
	}

	public void imprimirConsentimientosInformados(Chconsulta consulta) {

		if (consulta.getChconinfxcon() != null && !consulta.getChconinfxcon().isEmpty()) {
			for (Chconinfxcon conseninfo : consulta.getChconinfxcon()) {

				Chreporte report = new Chreporte();

				report = new Chreporte();
				report.setHrecdescripcio(conseninfo.getHcicnnucoin().getHpciccodigo() + " "
						+ conseninfo.getHcicnnucoin().getHpcicnombre());
				report.setHrectipodescri("Consentimientos Informados");
				report.setHrencodigo(imp_consentimiento_informado);
				report.setHrentipoimpres(1);
				report.setHrenconsulta(consulta.getHcolnumero());
				report.setHredfecharegis(consulta.getHcodfecregistr());

				lstReporte.add(report);
			}

		}
	}

	public void imprimirDatosAdicionalesVacunacion(Chconsulta consulta) {

		if (consulta.getHcolusuario() != null) {
			Chdatosadvacuna datosAdicionales;
			try {
				datosAdicionales = this.serviceLocator.getHistoriaService()
						.readDatosADVacunaByConsulta((int) (long) consulta.getHcolnumero());
				if (datosAdicionales != null) {

					Cpmunidane n = new Cpmunidane();
					try {
						n = this.getServiceLocator().getClinicoService().getMunicipio(datosAdicionales.getHdavnmuni(),
								datosAdicionales.getHdavndepart());
					} catch (ModelException e) {
						e.printStackTrace();
					}
					if (n != null) {
						Chreporte report = new Chreporte();

						report.setHrecdescripcio("Departamento nacimiento: " + n.getCmdcnomdpt());
						report.setHrecdescripcio2("Municipio nacimiento: " + n.getCmdcnommun());
						if (datosAdicionales.getHdavnumcom() != null) {
							report.setHrecdescripcio3("NNmero comuna: " + datosAdicionales.getHdavnumcom());
						}
						report.setHrectipodescri("Datos bNsicos adicionales");
						report.setHrencodigo(imp_datos_adicionales_vacunacion);
						report.setHrentipoimpres(5);
						report.setHrenconsulta(consulta.getHcolnumero());
						report.setHredfecharegis(consulta.getHcodfecregistr());

						lstReporte.add(report);
						report = new Chreporte();
						String booleano = "No";
						if (("S").equals(datosAdicionales.getHdavccondesplaz())) {
							booleano = "Si";
						}
						report.setHrecdescripcio("CondiciNn de desplazamiento: " + booleano);
						booleano = "No";
						if (("S").equals(datosAdicionales.getHdavcvicconflic())) {
							booleano = "Si";
						}

						report.setHrecdescripcio2("VNctima de conflicto: " + booleano);
						booleano = "No";
						if (("S").equals(datosAdicionales.getHdavcestuact())) {
							booleano = "Si";
						}
						report.setHrecdescripcio3("Estudia Actualmente: " + booleano);

						report.setHrectipodescri("Datos bNsicos adicionales");
						report.setHrencodigo(imp_datos_adicionales_vacunacion);
						report.setHrentipoimpres(5);
						report.setHrenconsulta(consulta.getHcolnumero());
						report.setHredfecharegis(consulta.getHcodfecregistr());

						lstReporte.add(report);

						if (datosAdicionales.getHdavcinstitucion() != null || datosAdicionales.getHdavdfur() != null)
							report = new Chreporte();
						if (datosAdicionales.getHdavcinstitucion() != null) {
							report.setHrecdescripcio(
									"InstituciNn donde estudia: " + datosAdicionales.getHdavcinstitucion());
						}
						if (datosAdicionales.getHdavdfur() != null) {
							report.setHrecdescripcio2(
									"F.U.R. normal: " + formatearCampo(datosAdicionales.getHdavdfur()));
						}
						report.setHrectipodescri("Datos bNsicos adicionales");
						report.setHrencodigo(imp_datos_adicionales_vacunacion);
						report.setHrentipoimpres(5);
						report.setHrenconsulta(consulta.getHcolnumero());
						report.setHredfecharegis(consulta.getHcodfecregistr());

						lstReporte.add(report);
					}
					if (datosAdicionales.getHdavccondusua() != null) {
						String condicionEmbarazo = "No embarazada";
						if (("EM").equals(datosAdicionales.getHdavccondusua())) {
							condicionEmbarazo = "Embarazada";
						}
						Chreporte report = new Chreporte();
						report.setHrecdescripcio("CondiciNn de usuaria: " + condicionEmbarazo);
						if (("EM").equals(datosAdicionales.getHdavccondusua())) {
							report.setHrecdescripcio2("NNmero embarazo actual: " + datosAdicionales.getHdavcembact());
							report.setHrecdescripcio3(
									"Fecha probable de parto: " + formatearCampo(datosAdicionales.getHdavdfecpart()));
						}
						report.setHrectipodescri("Datos bNsicos adicionales");
						report.setHrencodigo(imp_datos_adicionales_vacunacion);
						report.setHrentipoimpres(5);
						report.setHrenconsulta(consulta.getHcolnumero());
						report.setHredfecharegis(consulta.getHcodfecregistr());
						lstReporte.add(report);
					}

					if (datosAdicionales != null && datosAdicionales.getHdacdiscapadid() != null) {

						Chreporte report = new Chreporte();

						report.setHrecdescripcio(
								"Discapacidad: " + formatearCampo(datosAdicionales.getHdacdiscapadid()));
						if (datosAdicionales.getHdacdiscapadid().equals("S")) {
							report.setHrecdescripcio2("Tipo de Discapacidad "
									+ formatearCampoDiscapacidad(datosAdicionales.getHdacdiscaselec()));
						} else {
							report.setHrecdescripcio2("");
						}
						report.setHrecdescripcio3("");
						report.setHrectipodescri("Datos bNsicos adicionales");
						report.setHrencodigo(imp_datos_adicionales_vacunacion);
						report.setHrentipoimpres(5);
						report.setHrenconsulta(consulta.getHcolnumero());
						report.setHredfecharegis(consulta.getHcodfecregistr());

						lstReporte.add(report);
					}

				}
			} catch (ModelException e) {
				e.printStackTrace();
			}

		}
	}
}
