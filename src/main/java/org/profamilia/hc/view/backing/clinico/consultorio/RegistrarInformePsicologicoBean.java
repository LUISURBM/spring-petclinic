package org.profamilia.hc.view.backing.clinico.consultorio;

import java.math.BigDecimal;

import java.net.URL;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;

import java.util.HashMap;
import java.util.Iterator;

import java.util.Map;

import javax.faces.component.UIInput;
import javax.faces.event.ValueChangeEvent;

import net.sf.jasperreports.engine.JRDataSource;
import net.sf.jasperreports.engine.JRField;

import net.sf.jasperreports.engine.JasperReport;
import net.sf.jasperreports.engine.JasperRunManager;
import net.sf.jasperreports.engine.util.JRLoader;

import org.profamilia.hc.model.dto.Chautoinfopsic;
import org.profamilia.hc.model.dto.Chconsulta;
import org.profamilia.hc.model.dto.Chinfopsico;
import org.profamilia.hc.model.dto.ChinfopsicoPK;
import org.profamilia.hc.model.dto.Chnotamedica;
import org.profamilia.hc.model.dto.ChnotamedicaPK;
import org.profamilia.hc.model.dto.Chtipoafilia;
import org.profamilia.hc.model.dto.Chusuario;
import org.profamilia.hc.model.dto.Cpestadciv;
import org.profamilia.hc.model.dto.Cpmunidane;
import org.profamilia.hc.model.dto.Cpprofesio;
import org.profamilia.hc.model.exceptions.ModelException;
import org.profamilia.hc.view.backing.BaseBean;
import org.profamilia.hc.view.backing.BeanNavegacion;
import org.profamilia.hc.view.backing.comun.buscador.BuscadorProfesionalBean;
import org.profamilia.hc.view.backing.comun.buscador.BuscadorUsuariosBean;
import org.profamilia.hc.view.constantes.IMsg;
import org.profamilia.hc.view.util.FacesUtils;
import org.profamilia.hc.view.util.PdfServletUtils;

public class RegistrarInformePsicologicoBean extends BaseBean implements JRDataSource {

	/**
	 * Almacena la descripcion de la informe Medica
	 */
	private String informePsicologico;

	/**
	 * Alamcena la consulta a la cual se le esta haciendo la informe medica
	 */
	private Chconsulta consulta;

	/**
	 * Almacena la informe medica a persistir
	 */
	private Chinfopsico informe;

	/** Almacena el bean de navegacion */
	private String nextAction;

	private Cpprofesio profesionalAct;

	private Cpprofesio profesionalCambio;

	static final int ACTIVAR_BUSCADOR = 1;

	static final int ACTIVAR_BEAN = 0;

	private int selectedIndex;

	private boolean renderBuscador;

	private BuscadorProfesionalBean buscadorProfesionalBean;

	private String NOMBRES;

	private Date FECHA;

	private String CIUDAD;

	private String NUM_IDENTIFICACION;

	private Date FECHA_NACIMIENTO;

	private String EDAD;

	private String TIPO_AFILIACION;

	private String ASEGURADORA;

	private String DIRECCION;

	private String TELEFONO;

	private String ESTADO_CIVIL;

	private String OCUPACION;

	private String MOTIVO_INFORME;

	private String TECNICAS_INSTRUMENTOS;

	private String DESCRIPCION_CASO;

	private String CONCLUSIONES;

	private String NOMBRE_PROFESIONAL;

	private String REGISTRO_PROFESIONAL;

	private int index = -1;

	private static int NUMERO_COPIAS = 1;

	private Boolean generoReporte;

	private Boolean visualizar;

	private UIInput motivoInforme;

	private UIInput tecnicaInstrumento;

	private UIInput descripcionCaso;

	private UIInput conclusiones;

	public RegistrarInformePsicologicoBean() {
	}

	public void init() {
		informe = new Chinfopsico();
		profesionalAct = new Cpprofesio();
		profesionalCambio = new Cpprofesio();
		visualizar = false;
		generoReporte = false;
		String cargoProfesional = "";

		if (consulta != null) {
			try {
				profesionalAct = serviceLocator.getClinicoService().getProfesionalPorUsuario(consulta.getHcocoperador(),
						consulta.getHconclinica());
			} catch (ModelException e) {
				e.printStackTrace();
			}

			if (profesionalAct != null) {
				try {
					cargoProfesional = serviceLocator.getClinicoService()
							.getDescripcionTipoEspecialidad(profesionalAct.getCpfntipoespe());
				} catch (ModelException e) {
					e.printStackTrace();
				}

				informe.setHipccargprof(cargoProfesional);
				informe.setHipcregiprof(profesionalAct.getCpfcregmedic());
				informe.setHipcnombprof(profesionalAct.getCpfcnombre());
			}
		}
	}

	/**
	 * @param informePsicologico
	 */
	public void setInformePsicologico(String informePsicologico) {
		this.informePsicologico = informePsicologico;
	}

	/**
	 * @return
	 */
	public String getInformePsicologico() {
		return informePsicologico;
	}

	/**
	 * @param consulta
	 */
	public void setConsulta(Chconsulta consulta) {
		this.consulta = consulta;
	}

	/**
	 * @return
	 */
	public Chconsulta getConsulta() {
		return consulta;
	}

	/**
	 * @param nextAction
	 */
	public void setNextAction(String nextAction) {
		this.nextAction = nextAction;
	}

	/**
	 * @return
	 */
	public String getNextAction() {
		return nextAction;
	}

	/**
	 * @return
	 */
	public String aceptar() {

		ChinfopsicoPK id = new ChinfopsicoPK();
		Chautoinfopsic autoriza = new Chautoinfopsic();
		id.setHiplconsulta(consulta.getHcolnumero());
		nextAction = "";
		informe.setHipcoperador(userName());
		informe.setHipdfecregistr(new Date());
		informe.setId(id);

		if (informe.getHipcregiprof() == null) {
			informe.setHipcregiprof("0");
		}

		try {
			autoriza = this.serviceLocator.getCirugiaService()
					.getSolicitudInformePsicologicoByNumero(consulta.getHcolnumero());
			autoriza.setHaipcetapa("FN");
			this.serviceLocator.getClinicoService().saveInformePsicologico(informe, autoriza);
			visualizar = true;
			nextAction = BeanNavegacion.RUTA_ACTUAL;
			FacesUtils.addInfoMessage(IMsg.MSG_ADICION);
		} catch (ModelException e) {
			FacesUtils.addErrorMessage(MSG_NO_ADICION);
			nextAction = BeanNavegacion.RUTA_ACTUAL;
			e.printStackTrace();
			visualizar = false;
		}
		/*
		 * FacesUtils.resetManagedBean("registrarInformePsicologicoBean");
		 * FacesUtils.resetManagedBean("consultarFoliosInformePsicologicoBean");
		 * FacesUtils.resetManagedBean("consultarUsuarioInformePsicologicoBean");
		 */

		return nextAction;
	}

	/**
	 * @return
	 */
	public void aceptarProfesional() {
		selectedIndex = ACTIVAR_BEAN;

		profesionalCambio = new Cpprofesio();
		String cargoProfesional = "";

		buscadorProfesionalBean = (BuscadorProfesionalBean) FacesUtils.getManagedBean("buscadorProfesionalBean");
		profesionalCambio = buscadorProfesionalBean.getProfesionalSelect();

		if (profesionalCambio != null) {
			try {
				cargoProfesional = serviceLocator.getClinicoService()
						.getDescripcionTipoEspecialidad(profesionalCambio.getCpfntipoespe());
			} catch (ModelException e) {
				e.printStackTrace();
			}
			informe.setHipccargprof(cargoProfesional);
			informe.setHipcregiprof(profesionalCambio.getCpfcregmedic());
			informe.setHipcnombprof(profesionalCambio.getCpfcnombre());
		}
		renderBuscador = false;

	}

	public void mostrarBuscadorProfesional() {
		FacesUtils.resetManagedBean("buscadorProfesionalBean");
		buscadorProfesionalBean = (BuscadorProfesionalBean) FacesUtils.getManagedBean("buscadorProfesionalBean");
		buscadorProfesionalBean.setConsulta(consulta);
		selectedIndex = ACTIVAR_BUSCADOR;
		renderBuscador = true;
	}

	public boolean next() {
		index++;
		return (index < NUMERO_COPIAS);
	}

	public Object getFieldValue(JRField jrField) {
		Object value = null;
		String fieldName = jrField.getName();
		if (fieldName.equals("NOMBRES")) {
			value = NOMBRES;
		} else if (fieldName.equals("FECHA")) {
			value = FECHA;
		} else if (fieldName.equals("CIUDAD")) {
			value = CIUDAD;
		} else if (fieldName.equals("NUM_IDENTIFICACION")) {
			value = NUM_IDENTIFICACION;
		} else if (fieldName.equals("FECHA_NACIMIENTO")) {
			value = FECHA_NACIMIENTO;
		} else if (fieldName.equals("EDAD")) {
			value = EDAD;
		} else if (fieldName.equals("TIPO_AFILIACION")) {
			value = TIPO_AFILIACION;
		} else if (fieldName.equals("ASEGURADORA")) {
			value = ASEGURADORA;
		} else if (fieldName.equals("DIRECCION")) {
			value = DIRECCION;
		} else if (fieldName.equals("TELEFONO")) {
			value = TELEFONO;
		} else if (fieldName.equals("ESTADO_CIVIL")) {
			value = ESTADO_CIVIL;
		} else if (fieldName.equals("OCUPACION")) {
			value = OCUPACION;
		} else if (fieldName.equals("MOTIVO_INFORME")) {
			value = MOTIVO_INFORME;
		} else if (fieldName.equals("TECNICAS_INSTRUMENTOS")) {
			value = TECNICAS_INSTRUMENTOS;
		} else if (fieldName.equals("DESCRIPCION_CASO")) {
			value = DESCRIPCION_CASO;
		} else if (fieldName.equals("CONCLUSIONES")) {
			value = CONCLUSIONES;
		} else if (fieldName.equals("NOMBRE_PROFESIONAL")) {
			value = NOMBRE_PROFESIONAL;
		} else if (fieldName.equals("REGISTRO_PROFESIONAL")) {
			value = REGISTRO_PROFESIONAL;
		}
		return value;
	}

	public void obtenerDatosReporte() {

		if (consulta != null && consulta.getHcolusuario() != null) {
			Chusuario usuario = consulta.getHcolusuario();
			if (usuario.getHuscprimerapel() != null) {
				NOMBRES = usuario.getHuscprimerapel() + " ";
			}
			if (usuario.getHuscsegundapel() != null && !usuario.getHuscsegundapel().equals("_")) {
				NOMBRES = NOMBRES + usuario.getHuscsegundapel() + " ";
			}

			if (usuario.getHuscprimernomb() != null) {
				NOMBRES = NOMBRES + usuario.getHuscprimernomb() + " ";
			}
			if (usuario.getHuscsegundnomb() != null && !usuario.getHuscsegundnomb().equals("_")) {
				NOMBRES = NOMBRES + usuario.getHuscsegundnomb();
			}

			NUM_IDENTIFICACION = usuario.getHusanumeiden().toString();
			FECHA_NACIMIENTO = usuario.getHusdfechanacim();
			Integer edadCal = calcularEdad(usuario.getHusdfechanacim(), new Date());
			EDAD = edadCal.toString();
			if (usuario.getHusetipoafilia() != null) {

				ArrayList<Chtipoafilia> listTipoAfiliacionAux = null;
				try {
					listTipoAfiliacionAux = (ArrayList<Chtipoafilia>) this.getServiceLocator().getClinicoService()
							.getTipoafiliado();
				} catch (ModelException e) {
					e.printStackTrace();
				}

				if (!listTipoAfiliacionAux.isEmpty()) {

					Iterator it = listTipoAfiliacionAux.iterator();
					int i = 0;
					while (it.hasNext()) {
						it.next();
						if (usuario.getHusetipoafilia()
								.equals(listTipoAfiliacionAux.get(i).getCtaecodigo().toString())) {
							TIPO_AFILIACION = listTipoAfiliacionAux.get(i).getCtacdescripcio();
						}
						i++;
					}
				}
			}

			Integer idCiudad = usuario.getHusnciudad();
			Integer idDepartamento = usuario.getHusndepartamen();
			Cpmunidane ciudadObject = null;

			try {
				ciudadObject = this.serviceLocator.getClinicoService().getMunicipio(idCiudad, idDepartamento);
			} catch (ModelException e) {
				e.printStackTrace();
			}
			if (ciudadObject != null) {
				CIUDAD = ciudadObject.getCmdcnommun();
			}

			if (usuario.getHuscentidadadm() != null) {
				try {
					ASEGURADORA = serviceLocator.getClinicoService()
							.getDescripcionEntidadByCodigo(usuario.getHuscentidadadm());
				} catch (ModelException e) {
					e.printStackTrace();
				}
			}

			DIRECCION = usuario.getHuscdireccion();
			TELEFONO = usuario.getHusctelefono();
			ArrayList<Cpestadciv> estadosCiviles = null;
			try {
				estadosCiviles = (ArrayList<Cpestadciv>) this.serviceLocator.getClinicoService().getEstadosCiviles();
			} catch (ModelException e) {
				e.printStackTrace();
			}

			if (estadosCiviles != null && usuario.getHuseestadcivil() != null) {
				for (Cpestadciv cpestadciv : estadosCiviles) {
					if (cpestadciv.getCecccodigo().equals(usuario.getHuseestadcivil())) {
						ESTADO_CIVIL = cpestadciv.getCeccdescri();
					}
				}
			}

			Integer ocupacion = usuario.getHusnocupacion();

			try {
				OCUPACION = serviceLocator.getClinicoService().getDescripcionOcupacion(ocupacion);
			} catch (ModelException e) {
				e.printStackTrace();
			}
			FECHA = consulta.getHcodfecregistr();
		}
		if (informe != null) {
			MOTIVO_INFORME = informe.getHipcmotivinfor();
			TECNICAS_INSTRUMENTOS = informe.getHipctecinsutl();
			DESCRIPCION_CASO = informe.getHipcdesccaso();
			CONCLUSIONES = informe.getHipcconcreco();
			NOMBRE_PROFESIONAL = informe.getHipcnombprof();
			REGISTRO_PROFESIONAL = informe.getHipcregiprof();
		}
	}

	public void clearReporte() {
		NOMBRES = "";
		FECHA = null;
		CIUDAD = "";
		NUM_IDENTIFICACION = "";
		FECHA_NACIMIENTO = null;
		EDAD = "";
		TIPO_AFILIACION = "";
		ASEGURADORA = "";
		DIRECCION = "";
		TELEFONO = "";
		ESTADO_CIVIL = "";
		OCUPACION = "";
		MOTIVO_INFORME = "";
		TECNICAS_INSTRUMENTOS = "";
		DESCRIPCION_CASO = "";
		CONCLUSIONES = "";
		NOMBRE_PROFESIONAL = "";
		REGISTRO_PROFESIONAL = "";
	}

	public void generarCopiaLectura() {
		generoReporte = false;
		clearReporte();
		URL url = null;
		URL url_profamilia = null;

		try {
			url = FacesUtils.getFacesContext().getExternalContext().getResource("/reports/informePsicologico.jasper");

			url_profamilia = FacesUtils.getFacesContext().getExternalContext().getResource(IMAGE_PROFAMILIA_NEW);
			obtenerDatosReporte();

			if (url != null) {
				Map parameters = new HashMap();
				parameters.put("IMAGEN", url_profamilia);

				byte[] bytes;

				JasperReport report = (JasperReport) JRLoader.loadObject(url);

				bytes = JasperRunManager.runReportToPdf(report, parameters, (JRDataSource) this);
				PdfServletUtils.showPdfDocument(bytes, "Documento" + Calendar.getInstance().getTimeInMillis() + ".pdf",
						false);
				generoReporte = true;
			}
		} catch (Exception e) {
			e.printStackTrace();
			FacesUtils.addErrorMessage("No pudo generar el reporte " + e.getMessage());
		}
	}

	public void setInforme(Chinfopsico informe) {
		this.informe = informe;
	}

	public Chinfopsico getInforme() {
		return informe;
	}

	public void setProfesionalAct(Cpprofesio profesionalAct) {
		this.profesionalAct = profesionalAct;
	}

	public Cpprofesio getProfesionalAct() {
		return profesionalAct;
	}

	public void setProfesionalCambio(Cpprofesio profesionalCambio) {
		this.profesionalCambio = profesionalCambio;
	}

	public Cpprofesio getProfesionalCambio() {
		return profesionalCambio;
	}

	public void setSelectedIndex(int selectedIndex) {
		this.selectedIndex = selectedIndex;
	}

	public int getSelectedIndex() {
		return selectedIndex;
	}

	public void setRenderBuscador(boolean renderBuscador) {
		this.renderBuscador = renderBuscador;
	}

	public boolean isRenderBuscador() {
		return renderBuscador;
	}

	public void setBuscadorProfesionalBean(BuscadorProfesionalBean buscadorProfesionalBean) {
		this.buscadorProfesionalBean = buscadorProfesionalBean;
	}

	public BuscadorProfesionalBean getBuscadorProfesionalBean() {
		return buscadorProfesionalBean;
	}

	public void setGeneroReporte(Boolean generoReporte) {
		this.generoReporte = generoReporte;
	}

	public Boolean getGeneroReporte() {
		return generoReporte;
	}

	public void setVisualizar(Boolean visualizar) {
		this.visualizar = visualizar;
	}

	public Boolean getVisualizar() {
		return visualizar;
	}

	public void setMotivoInforme(UIInput motivoInforme) {
		this.motivoInforme = motivoInforme;
	}

	public UIInput getMotivoInforme() {
		return motivoInforme;
	}

	public void setTecnicaInstrumento(UIInput tecnicaInstrumento) {
		this.tecnicaInstrumento = tecnicaInstrumento;
	}

	public UIInput getTecnicaInstrumento() {
		return tecnicaInstrumento;
	}

	public void setDescripcionCaso(UIInput descripcionCaso) {
		this.descripcionCaso = descripcionCaso;
	}

	public UIInput getDescripcionCaso() {
		return descripcionCaso;
	}

	public void setConclusiones(UIInput conclusiones) {
		this.conclusiones = conclusiones;
	}

	public UIInput getConclusiones() {
		return conclusiones;
	}
}
