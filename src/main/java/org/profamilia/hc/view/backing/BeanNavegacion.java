package org.profamilia.hc.view.backing;

public interface BeanNavegacion {

    // Indica la ruta asociada cuando recarga la misma p�gina

    String RUTA_ACTUAL = "actual";

    String PAGINAS = "paginas";

    String SUCCESS = "success";

    String RUTA_REGRESAR = "volver";

    String RUTA_EDITAR = "editar";

    String RUTA_ELIMINAR = "eliminar";

    String RUTA_ADICIONAR = "adicionar";

    String RUTA_HOME = "home";

    String RUTA_SALIR_CLINICA = "irSalirClinica";

    String RUTA_MOSTRAR_ANTECEDENTES = "mostrarAntecedentes";

    String RUTA_MOSTRAR_RESUMEN = "mostrarResumen";

    String RUTA_MOSTRAR_RESUMEN_HISTORIA = "mostrarResumenHistoria";

    String RUTA_INGRESO = "ingreso";

    String RUTA_LOGOUT = "logout";

    //MENU PRINCIPAL   

    String RUTA_TIPO_SERVICIOS = "tiposervicio";

    String RUTA_SERVICIOS = "servicio";

    String RUTA_DIRECTORIO = "directorio";

    String RUTA_TIPOS_CONTACTO = "tiposContacto";

    String RUTA_INFO_CLINICA = "infoClinica";

    String RUTA_INFO_CONSULTAS_PENDIENTES = "irConsultasPendientes";

    String RUTA_INFO_CENTRO = "infoCentro";

    String RUTA_CONSULTA_LAB = "consultaLab";

    String RUTA_HORARIOS = "horarios";

    String RUTA_CONSULTA_HORARIOS = "consultaHorarios";

    String RUTA_ATENDER_HISTORIA_SEXUAL = "atender_sexual";

    String RUTA_ATENDER_HISTORIA_ANTICONCEPCION = "atender_anticoncepcion";

    String RUTA_IR_METODO_PLANIFICACION_ANTICONCEPCION = 
        "irMetodoPlanificacionAnticoncepcion";

    String RUTA_IR_REFERENCIA_ANTICONCEPCION = "irReferenciaAnticoncepcion";

    String RUTA_IR_AUTORIZACION_SERVICIO_ANTICONCEPCION = 
        "irAutorizacionServicioAnticoncepcion";

    String RUTA_ATENDER_HISTORIA_PEDIATRIA = "atender_pediatria";

    String RUTA_ATENDER_HISTORIA_MAMA = "atender_mama";

    String RUTA_ATENDER_HISTORIA_PSICOLOGICA = "atender_psicologica";

    String RUTA_ATENDER_HISTORIA_PRENATAL = "atender_prenatal";

    String RUTA_ATENDER_HISTORIA_CONTROL = "atender_control";

    String RUTA_ATENDER_HISTORIA_CONTROL_PRENATAL = "atender_control_prenatal";

    String RUTA_LISTA = "irLista";

    String RUTA_LISTA_TODOS_LOS_USUARIOS = "irregistrarHistoria";
    
    String RUTA_LISTA_TODOS_LOS_LABORATORIO = "irListaLaboratorio";
    
    String RUTA_REGISTRAR_LABORATORIO = "irregistrarLaboratorio";

    String RUTA_LISTA_TODOS_LOS_USUARIOS_ENFERMERIA = 
        "irregistrarHistoriaEnfermeria";

    String RUTA_IR_NOTA_MEDICA = "irregistrarNotaMedica";

    String RUTA_IR_EVOLUCION_CONSULTA_MEDICA = 
        "irregistrarEvolucionConsultaMedica";

    String RUTA_IR_REGISTRAR_EXAMENES_LABORATORIO = 
        "irconsultarExamenesLaboratorio";

    String RUTA_IR_CONSULTAR_EXAMENES_LABORATORIO = 
        "irconsultarExamenesLaboratorio";


    String RUTA_IR_CONSULTA_HISTORIA = "irconsultarHistoria";

    String RUTA_IR_DATOS_USUARIO = "irDatosUsuario";


    String RUTA_IR_CERTIFICADO_MEDICO = "irCertificadoMedico";

    String RUTA_IR_CERTIFICADO_MEDICO_EVOLUCION = 
        "irCertificadoMedicoEvolucion";

    String RUTA_IR_CERTIFICADO_ASISTENCIA = "irCertificadoAsistencia";

    String RUTA_IR_CERTIFICADO_ASISTENCIA_EVOLUCION = 
        "irCertificadoAsistenciaEvolucion";

    String RUTA_IR_MODIFICAR_DATOS_USUARIO = "irModificarUsuario";

    String RUTA_IR_CONSULTAR_FOLIOS_DOCUMENTO = "irConsultarFoliosDocumento";

    String RUTA_IR_MOTIVO_CONSULTA = "irMotivoConsulta";

    String RUTA_IR_ANTECEDENTES = "irAntecedentes";

    String RUTA_IR_ANTECEDENTES_GENERALES = "irAntecedentesGenerales";

    String RUTA_IR_TAMIZAJE_PRENATAL = "irTamizajePrenatal";

    String RUTA_IR_TAMIZAJE_CONTROL_PRENATAL = "irTamizajeControlPrenatal";

    String RUTA_IR_ANTECEDENTES_GINECOLOGICOS = "irAntecedentesGinecologicos";

    String RUTA_IR_ANTECEDENTES_GINECOOBSTETRICOS = 
        "irAntecedentesGinecoobstetricos";

    String RUTA_IR_ANTECEDENTES_TEMPORALES = "irAntecedentesTemporales";

    String RUTA_IR_INFORME_CITOPUNCION_SENO = "irInformeCitopuncionSeno";

    String RUTA_IR_INFORME_ECOGRAFICO = "irInformeEcografia";

    String RUTA_IR_INFORME_HISTEROSONOGRAFICO = "irInformeHisterosonografia";

    String RUTA_IR_GESTACION = "irGestacion";

    String RUTA_IR_GESTACION_CONTROL = "irGestacionControl";

    String RUTA_IR_ENCUESTA_VIOLENCIA = "irEncuestaViolencia";

    String RUTA_IR_RIESGO_MAMA = "irRiesgoMama";

    String RUTA_IR_EXAMEN_FISICO_PRENATAL = "irExamenFisicoPrenatal";

    String RUTA_IR_EXAMEN_FISICO_CONTROL_PRENATAL = 
        "irExamenFisicoControlPrenatal";

    String RUTA_IR_EXAMEN_FISICO_PEDIATRIA = "irExamenFisicoPediatria";

    String RUTA_IR_EXAMEN_FISICO = "irExamenFisico";

    String RUTA_IR_EXAMEN_FISICO_MAMA = "irExamenFisicoMama";

    String RUTA_IR_IMPRESION_DIAGNOSTICA = "irImpresionDiagnostica";

    String RUTA_IR_APOYO_DIAGNOSTICO = "irApoyoDiagnostico";

    String RUTA_IR_CONDUCTA = "irConducta";

    String RUTA_IR_CONDUCTA_EVOLUCION = "irConductaEvolucion";

    String RUTA_IR_PROCEDIMIENTO_CONSULTORIO = "irProcedimientoConsultorio";

    String RUTA_IR_ANATOMIA_PATOLOGICA = "irAnatomiaPatologica";

    String RUTA_IR_ANATOMIA_PATOLOGICA_EVOLUCION = 
        "irAnatomiaPatologicaEvolucion";

    String RUTA_IR_REMISION_HOSPITALIZACION = "irRemisionHospitalizacion";

    String RUTA_IR_REMISION_HOSPITALIZACION_EVOLUCION = 
        "irRemisionHospitalizacionEvolucion";


    String RUTA_IR_REFERENCIA = "irReferencia";

    String RUTA_IR_REFERENCIA_EVOLUCION = "irReferenciaEvolucion";

    String RUTA_IR_ORDEN_CIRUGIA = "irOrdenCirugia";

    String RUTA_IR_ORDEN_CIRUGIA_EVOLUCION = "irOrdenCirugiaEvolucion";

    String RUTA_IR_BUSCADOR_CIRUGIAS = "irBuscadorCirugias";

    String RUTA_IR_FORMULA_MEDICA = "irFormulaMedica";

    String RUTA_IR_FORMULA_MEDICA_EVOLUCION = "irFormulaMedicaEvolucion";

    String RUTA_IR_FORMULA_LIQUIDOS = "irFormulaLiquidos";

    String RUTA_IR_INCAPACIDAD = "irIncapacidad";

    String RUTA_IR_INCAPACIDAD_EVOLUCION = "irIncapacidadEvolucion";

    String RUTA_IR_EXAMENES_PARACLINICOS = "irExamenesParaclinicos";

    String RUTA_IR_EXAMENES_LABORATORIOS = "irExamenesLaboratorios";

    String RUTA_IR_EXAMENES_LABORATORIOS_EVOLUCION = 
        "irExamenesLaboratoriosEvolucion";

    String RUTA_IR_EXAMENES_IMAGENES_EVOLUCION = "irExamenesImagenesEvolucion";

    String RUTA_IR_EXAMENES_FISIOLOGICOS = "irExamenesFisiologicos";

    String RUTA_IR_EXAMENES_FISIOLOGICOS_EVOLUCION = 
        "irExamenesFisiologicosEvolucion";

    String RUTA_IR_CONTROL_SIN_COSTO = "irControlSinCosto";

    String RUTA_IR_CONTROL_SIN_COSTO_EVOLUCION = "irControlSinCostoEvolucion";

    String RUTA_IR_REMISION = "irRemision";

    String RUTA_IR_REMISION_EVOLUCION = "irRemisionEvolucion";

    String RUTA_IR_RESERVA_SANGRE = "irReservaSangre";

    String RUTA_IR_RESERVA_SANGRE_EVOLUCION = "irReservaSangreEvolucion";

    String RUTA_IR_HISTORIA_CONTROL = "irHistoriaControl";

    String RUTA_IR_CONSULTAR_ANTECEDENTE = "irconsultarAntecedente";

    String RUTA_IR_CONSULTAR_RESUMEN = "irconsultarResumen";

    String RUTA_IR_CONSULTAR_USUARIO = "irconsultarUsuario";
    
    String RUTA_IR_CONSULTAR_LECTURA_CITOLOGIA = "irConsultarLecturaCitologia";
    
    String RUTA_IR_CONSULTAR_MODIFICAR_CITOLOGIA = "irconsultarModificacionCitologia";
    
    String RUTA_IR_CONSULTAR_USUARIO_PROGRAMACION_CIRUGIA = 
        "irconsultarUsuarioProgramacionCirugia";

    String RUTA_IR_CONSULTAR_USUARIO_MODIFICAR_PROGRAMACION_CIRUGIA = 
        "irconsultarUsuarioModificarProgramacionCirugia";

    String RUTA_IR_CONSULTAR_USUARIO_REPROGRAMAR_PROGRAMACION_CIRUGIA = 
        "irconsultarUsuarioReprogramarProgramacionCirugia";

    String RUTA_IR_CONSULTAR_USUARIO_ADICIONAR_CIRUGIA = 
        "irconsultarUsuarioCirugia";

    String RUTA_IR_ADMINISTRAR_MEDICOS_POR_SALA = "iradministraMedicoSala";

    String RUTA_IR_MODIFICAR_PROGRAMACION = "irModificarProgramacion";

    String RUTA_IR_ADICIONAR_CIRUGIA = "irAdicionarCirugia";

    String RUTA_IR_REPROGRAMACION_CIRUGIA = "irReprogramaCirugia";

    String RUTA_IR_PROGRAMACION_CIRUGIA = "irProgramarCirugia";

    String RUTA_IR_MODIFICAR_CIRUGIA = "irModificarCirugia";

    String RUTA_IR_NOTA_ENFERMERIA_CONTROL = "irNotasEnfermeriaControl";

    String RUTA_IR_LISTA_CIRUGIAS_PROGRAMADAS = "irListaCirugiasProgramadas";

    String RUTA_IR_LISTA_CIRUGIAS_PROGRAMADAS_CHECK = 
        "irListaCirugiasProgramadasCheck";

    String RUTA_IR_LISTA_CIRUGIAS_DESCRIPCION_QUIRURGICA = 
        "irListaCirugiasDescripcionQuirurgica";

    String RUTA_IR_LISTA_CIRUGIAS_EPICRISIS = "irListaCirugiasEpicrisis";

    String RUTA_IR_LISTA_CIRUGIAS_NOTA_OPERATORIA = 
        "irListaCirugiasNotasOperatoria";

    String RUTA_IR_LISTA_CIRUGIAS_MEDICOS = "irListaCirugiasMedicos";

    String RUTA_IR_REIMPRIMIR_DOCUMENTOS = "irReimprimirDocumentos";

    String RUTA_IR_OTRAS_ORDENES_PENDIENTE = "irOtrasOrdenesPendientes";

    //FIXME CITOLOGIAS

    String RUTA_IR_REGISTRAR_LECTURA_CITOLOGIA = "irregistrarLecturaCitologia";
    
    String RUTA_IR_MODIFICAR_LECTURA_CITOLOGIA = "irmodificarLecturaCitologia";

    String RUTA_IR_REGISTRAR_LECTURA_VPH = "irregistrarLecturaVph";
    
    String RUTA_IR_MODIFICAR_LECTURA_VPH = "irmodificarLecturaVph";

    String RUTA_IR_REGISTRAR_LECTURA_VPH_CITOLOGIA = "irregistrarLecturaVphCitologia";

    String RUTA_IR_REGISTRAR_ENTREGA_CITOLOGIA = "irregistrarEntregaCitologia";

    String RUTA_IR_REGISTRAR_ENTREGA_VPH = "irregistrarEntregaVph";

    String RUTA_IR_BUSCAR_CITOLOGIAS = "irbuscarCitologias";
    
    String RUTA_IR_BUSCAR_VPHS = "irbuscarVphs";

    String RUTA_IR_LECTURA_CITOLOGIA = "irLecturaCitologia";
    
    String RUTA_IR_MODIFICAR_CITOLOGIA = "irModificarCitologia";

    String RUTA_IR_LECTURA_VPH = "irLecturaVph";
    
    String RUTA_IR_MODIFICAR_VPH = "irModificarVph";

    String RUTA_IR_LECTURA_VPH_CITOLOGIA = "irLecturaVphCitologia";

    String RUTA_IR_TOMA_CITOLOGIA = "irTomaCitologia";
    
    String RUTA_IR_CUESTIONARIO_COVID_TOMA_CITOLOGIA = "irCuestionarioCovidTomaCitologia"; 
    
    String RUTA_IR_TOMA_VPH = "irTomaVph";
    
    String RUTA_IR_CUESTIONARIO_COVID_TOMA_VPH = "irCuestionarioCovidTomaVph"; 

    String RUTA_IR_DATOS_USUARIO_CITOLOGIA = "irDatosUsuarioCitologia";

    String RUTA_LISTA_CITOLOGIAS_PROGRAMADAS = "irCitologiasProgramadas";
    
    String RUTA_LISTA_VPH_PROGRAMADAS = "irVphProgramadas";

    String RUTA_LISTA_IMPRIMIR_CITOLOGIA = "irListaImprimirCitologias";

    String RUTA_IR_CONSULTAR_USUARIO_CITOLOGIA = "irconsultarUsuarioCitologia";

    String RUTA_IR_CONTROL_ENTREGA_CITOLOGIA = "irsegCitologia";

    String RUTA_IR_CONTROL_ENTREGA_VPH = "irsegVph";

    String RUTA_IR_RESULTADO_LECTURA_UNO = "irresLecturaUno";

    String RUTA_IR_ENVIO_LECTURA_DOS = "irenvioLecturaDos";

    String RUTA_IR_REPORTE_ENTREGA_CITOL = "irregEntregaCitol";

    String RUTA_IR_ADMIN_PATOLOGOS = "adminPatologos";

    String RUTA_IR_OTRAS_PATOLGIAS = "irotrasPatologias";

    String RUTA_IR_ENV_OTRAS_PATOLGIAS = "irenvioOtrasPatologias";

    String RUTA_IR_ADMIN_GEN_PATOLOGOS = "adminGenPatologos";

    String RUTA_IR_RESULTADO_PATOLOGIAS = "irresultadoPatologia";

    String RUTA_IR_CONFIRMACION_PATOLOGIAS = "irconfirmacionPatologia";

    String RUTA_IR_DATOS_ENVIO = "irdatosEnvio";

    String RUTA_IR_ENTREGA_PATOLOGIAS = "irentregaPatologia";

    String RUTA_IR_SEGUIMINETO_PATOLOGIAS = "irseguimientoPatologia";


    //FIN CITOLOGIAS


    String RUTA_VER_FOLIOS_USUARIO = "ver_folios_usuario";

    String RUTA_IMP_FOLIOS = "imp_folios_usuario";

    String RUTA_VER_COPIA_CITOLOGIA = "ver_copia_citologia";
    
    String RUTA_COPIA_TUBERCULINA = "irCopiaTuberculina";

    String RUTA_VER_COPIA_VPH = "ver_copia_vph";

    String RUTA_VER_ESTADO_CITOLOGIA = "ver_estado_citologia";

    String RUTA_VER_DETALLE_CITOLOGIA = "ver_detalle_citologia";


    String RUTA_VER_ANTECEDENTES_USUARIO = "ver_Antecedentes_Usuario";

    String RUTA_VOLVER_CONSULTA_ANTECEDENTES = "volverAntecedentes";

    String RUTA_REGISTRAR_NOTA_MEDICA = "ver_nota_medica";

    String RUTA_REGISTRAR_SEGUIMIENTO_CONSULTA_EXTERNA = 
        "ver_seguimiento_consulta_externa";


    String RUTA_REGISTRAR_EXAMENES_CLINICOS = "irRegistrarExamenesClinicos";

    String RUTA_REGISTRAR_DESCRIPCION_QUIRURGICA = "irDescripcionQuirurgica";


    // DATOS DESCRIPCION QUIRURGICA


    String RUTA_IR_CONTROL_SIN_COSTO_DESCRIPCION_QX = 
        "irControlSinCostoDescripcionQuirurgica";

    String RUTA_IR_FORMULA_MEDICA_DESCRIPCION_QX = 
        "irFormulaMedicaDescripcionQuirurgica";

    String RUTA_IR_INCAPACIDAD_DESCRIPCION_QX = 
        "irIncapacidadDescripcionQuirurgica";


    String RUTA_REGISTRAR_DETALLE_DESCRIPCION_QUIRURGICA = 
        "irDetalleDescripcionQuirurgica";


    String RUTA_IR_INICIO = "ir_inicio";

    String RUTA_CONSULTAR_FOLIOS = "ver_folios_nota_medica";

    String RUTA_CONSULTAR_FOLIOS_SEGUIMIENTO = "ver_folios_seguimiento";

    String RUTA_CONSULTAR_FOLIOS_EXAMENES_CLINICOS = 
        "ver_folios_examenes_clinicos";

    String RUTA_IR_SIGNOS_VITALES = "irSignosVitales";

    String RUTA_IR_SIGNOS_VITALES_CONTROL = "irSignosVitalesControl";

    String RUTA_IR_CANALIZACION = "irCanalizacion";

    String RUTA_IR_CANALIZACION_CONTROL = "irCanalizacionControl";

    String RUTA_IR_ALDRETE_CONTROL = "irAldreteControl";

    String RUTA_IR_BROMAGE_CONTROL = "irBromageControl";

    String RUTA_IR_NOTAS_ENFERMERIA = "irNotasEnfermeria";

    String RUTA_IR_REGISTRO_MEDICAMENTOS = "irRegistrarMedicamentos";

    String RUTA_IR_LISTA_NOTAS_ENFERMERIA = "irListaNotasEnfermeria";

    String RUTA_IR_CONSULTAR_USUARIOS_INGRESADOS = 
        "irconsultarUsuariosIngresados";

    String RUTA_IR_CONSULTAR_USUARIOS_INGRESADOS_MEDICO = 
        "irconsultarUsuariosIngresadosMedico";


    String RUTA_IR_CERRAR_CONSULTA = "irCerrarConsulta";


    String RUTA_IR_FORMULA_MEDIAMENTOS_ESPECIALES = "irFormulaEspeciales";

    String RUTA_IR_REGISTRAR_RESULTADO_PARACLINICOS = 
        "irResultadosParaclinicos";

    String RUTA_IR_CONTROL_MEDICAMENTOS = "irControlMedicamentos";

    String RUTA_IR_CONTROL_LIQUIDOS = "irControlLiquidos";

    String RUTA_IR_ADMINISTRAR_LIQUIDOS = "irAdministrarLiquidos";

    String RUTA_IR_REGISTRAR_EPICRISIS = "irRegistrarEpicrisis";

    String RUTA_IR_CONSULTAR_USUARIOS_EPICRISIS = 
        "irconsultarUsuariosEpicrisis";


    // FIXME ESTERILIZACION FEMENINA

    String RUTA_IR_CUESTIONARIO_ESTERILIZACION = 
        "irCuestionarioEsterilizacion";

    String RUTA_IR_ANTICONCEPCION_FEMENINA = "iranticoncepcionFemenina";

    String RUTA_IR_CONSULTAR_ANTICONCEPCION_FEMENINA = 
        "irconsultarAnticoncepcionFemenina";

    String RUTA_IR_MOTIVO_SALUD_SEXUAL = "irMotivoSaludSexual";

    String RUTA_IR_DATOS_SALUD_SEXUAL = "irDatosSaludSexual";

    String RUTA_IR_INTERCONSULTA_SALUD_SEXUAL = "irInterConsultaSaludSexual";

    String RUTA_IR_ORDENCIRUGIA_SALUD_SEXUAL = "irOrdenCirugiaSaludSexual";


    String RUTA_IR_INCAPACIDAD_SALUD_SEXUAL = "irIncapacidadSaludSexual";

    String RUTA_IR_HOSPITALZACION_SALUD_SEXUAL = 
        "irRemHospitalizacionSaludSexual";

    String RUTA_IR_FORMULAMEDICA_SALUD_SEXUAL = "irFormulaMedicaSaludSexual";


    String RUTA_IR_VADEMCUM_SALUD_SEXUAL = "irVademecumMedicoSaludSexual";


    String RUTA_IR_CONTOLSINCOSTO_SALUD_SEXUAL = 
        "irControlSinCostoSaludSexual";

    String RUTA_IR_ANATOMIAPATOLOGICA_SALUD_SEXUAL = 
        "irAnatPatologicaSaludSexual";

    String RUTA_IR_IMPRESION_DIAGNOSTICA_SALUD_SEXUAL = 
        "irImpDiagnosticaSaludSexual";

    String RUTA_IR_ENCUESTA_VIOLENCIA_SALUD_SEXUAL = 
        "irEncuestaViolenciaSaludSexual";


    String RUTA_IR_ENCUESTA_VIOLENCIA_SIVIGILA_SALUD_SEXUAL = 
        "irEncuestaViolenciaSivigilaSaludSexual";

    String RUTA_IR_EXAMENFISICO_SALUD_SEXUAL = "irExamenFisicoSaludSexual";

    String RUTA_IR_ANTECEDENTES_SALUD_SEXUAL = "irAntecedentesSaludSexual";

    String RUTA_IR_PARACLINICOS_SALUD_SEXUAL = "irParaclinicosSaludSexual";

    String RUTA_IR_ANTECEDENTES_GENERALES_SALUD_SEXUAL = 
        "irAntecedentesGeneralesSaludSexual";

    String RUTA_IR_ANTECEDENTES_GINECOLOGICOS_SALUD_SEXUAL = 
        "irAntecedentesGinecologicosSaludSexual";

    String RUTA_IR_CERTIFICADO_ASISTENCIA_SALUD_SEXUAL = 
        "irCertificadoAsistenciaSaludSexual";

    String RUTA_IR_CERTIFICADOMEDICO_SALUD_SEXUAL = 
        "irCertificadoMedicoSaludSexual";

    String RUTA_IR_ELECTROFISIOLOGICO_SALUD_SEXUAL = 
        "irExamenElectrofisiologicosSaludSexual";

    String RUTA_IR_IMAGENES_SALUD_SEXUAL = "irExamenImagenesSaludSexual";

    String RUTA_IR_LABORATORIO_SALUD_SEXUAL = "irExamenLaboratorioSaludSexual";

    String RUTA_IR_RECOMENDACIONES_SALUD_SEXUAL = 
        "irRecomendacionesSaludSexual";

    String RUTA_IR_REFERENCIA_SALUD_SEXUAL = "irReferenciaSaludSexual";

    String RUTA_IR_RESERVA_SANGRE_SALUD_SEXUAL = "irReservaSangreSaludSexual";

    String RUTA_IR_CERRAR_CONSULTA_SALUD_SEXUAL = 
        "irCerrarConsultaSaludSexual";

    String RUTA_IR_RESUMEN_HISTORIA_ESPECIFICA_SALUD_SEXUAL = 
        "irResumenHistoriaEspecificaSaludSexual";

    String RUTA_IR_RESUMEN_HISTORIA_SALUD_SEXUAL = 
        "irResumenHistoriaSaludSexual";


    String RUTA_IR_ORDEN_LIQUIDOS_SALUD_SEXUAL = "irOrdenLiquidosSaludSexual";
    
    String RUTA_IR_OTRAS_ORDENES_SALUD_SEXUAL = "irOtrasOrdenesSaludSexual"; 

    String RUTA_IR_ORDEN_MEDICAMENTOS_SALUD_SEXUAL = "irOrdenMedicamentosSaludSexual";
    
    String RUTA_IR_CUESTIONARIO_COVID_SALUD_SEXUAL = "irCuestionarioCovidSaludSexual";

    // HISTORIA DE OTRAS ESPECIALIDADES


    String RUTA_IR_MOTIVO_OTRAS_ESPECIALIDADES = "irMotivoOtrasEspecialidades";
    
    String RUTA_IR_CUESTIONARIO_COVID_OTRAS_ESPECIALIDADES = "irCuestionarioCovidOtrasEspecialidades";

    String RUTA_IR_DATOS_OTRAS_ESPECIALIDADES = "irDatosOtrasEspecialidades";

    String RUTA_IR_INTERCONSULTA_OTRAS_ESPECIALIDADES = 
        "irInterConsultaOtrasEspecialidades";

    String RUTA_IR_ORDENCIRUGIA_OTRAS_ESPECIALIDADES = 
        "irOrdenCirugiaOtrasEspecialidades";

    String RUTA_IR_INCAPACIDAD_OTRAS_ESPECIALIDADES = 
        "irIncapacidadOtrasEspecialidades";

    String RUTA_IR_HOSPITALZACION_OTRAS_ESPECIALIDADES = 
        "irRemHospitalizacionOtrasEspecialidades";

    String RUTA_IR_FORMULAMEDICA_OTRAS_ESPECIALIDADES = 
        "irFormulaMedicaOtrasEspecialidades";

    String RUTA_IR_VADEMCUM_OTRAS_ESPECIALIDADES = 
        "irVademecumOtrasEspecialidades";


    String RUTA_IR_CONTOLSINCOSTO_OTRAS_ESPECIALIDADES = 
        "irControlSinCostoOtrasEspecialidades";

    String RUTA_IR_ANATOMIAPATOLOGICA_OTRAS_ESPECIALIDADES = 
        "irAnatPatologicaOtrasEspecialidades";

    String RUTA_IR_IMPRESION_DIAGNOSTICA_OTRAS_ESPECIALIDADES = 
        "irImpDiagnosticaOtrasEspecialidades";

    String RUTA_IR_ENCUESTA_VIOLENCIA_OTRAS_ESPECIALIDADES = 
        "irEncuestaViolenciaOtrasEspecialidades";

    String RUTA_IR_EXAMENFISICO_OTRAS_ESPECIALIDADES = 
        "irExamenFisicoOtrasEspecialidades";

    String RUTA_IR_ANTECEDENTES_OTRAS_ESPECIALIDADES = 
        "irAntecedentesOtrasEspecialidades";

    String RUTA_IR_ANTECEDENTES_GENERALES_OTRAS_ESPECIALIDADES = 
        "irAntecedentesGeneralesOtrasEspecialidades";

    String RUTA_IR_CERTIFICADO_ASISTENCIA_OTRAS_ESPECIALIDADES = 
        "irCertificadoAsistenciaOtrasEspecialidades";

    String RUTA_IR_CERTIFICADOMEDICO_OTRAS_ESPECIALIDADES = 
        "irCertificadoMedicoOtrasEspecialidades";

    String RUTA_IR_ELECTROFISIOLOGICO_OTRAS_ESPECIALIDADES = 
        "irExamenElectrofisiologicosOtrasEspecialidades";

    String RUTA_IR_IMAGENES_OTRAS_ESPECIALIDADES = 
        "irExamenImagenesOtrasEspecialidades";

    String RUTA_IR_LABORATORIO_OTRAS_ESPECIALIDADES = 
        "irExamenLaboratorioOtrasEspecialidades";

    String RUTA_IR_RECOMENDACIONES_OTRAS_ESPECIALIDADES = 
        "irRecomendacionesOtrasEspecialidades";

    String RUTA_IR_REFERENCIA_OTRAS_ESPECIALIDADES = 
        "irReferenciaOtrasEspecialidades";

    String RUTA_IR_AUTORIZACION_SERVICIO_OTRAS_ESPECIALIDADES = 
        "irAutorizacionServicioDermatologia";

    String RUTA_IR_RESERVA_SANGRE_OTRAS_ESPECIALIDADES = 
        "irReservaSangreOtrasEspecialidades";

    String RUTA_IR_CERRAR_CONSULTA_OTRAS_ESPECIALIDADES = 
        "irCerrarConsultaOtrasEspecialidades";

    String RUTA_IR_RESUMEN_HISTORIA_ESPECIFICA_OTRAS_ESPECIALIDADES = 
        "irResumenHistoriaEspecificaOtrasEspecialidades";

    String RUTA_IR_RESUMEN_HISTORIA_OTRAS_ESPECIALIDADES = 
        "irResumenHistoriaOtrasEspecialidades";
        
    String RUTA_IR_ORDEN_LIQUIDOS_OTRAS_ESPECIALIDADES = "irOrdenLiquidosOtrasEspecialidades";
    
    String RUTA_IR_OTRAS_ORDENES_OTRAS_ESPECIALIDADES = "irOtrasOrdenesOtrasEspecialidades"; 

    String RUTA_IR_ORDEN_MEDICAMENTOS_OTRAS_ESPECIALIDADES = "irOrdenMedicamentosOtrasEspecialidades";

    // INICIO ANTICONCEPCION TEMPORAL

    String RUTA_IR_MOTIVO_ANTICONCEPCION = "irMotivoAnticoncepcion";
    
   // String RUTA_IR_CUESTIONARIO_ANTICONCEPCION = "irCuestionarioCovidAnticoncepcion";
    
    String RUTA_IR_CUESTIONARIO_COVID_ANTICONCEPCION = "irCuestionarioCovidAnticoncepcion";


    String RUTA_IR_DATOS_ANTICONCEPCION = "irDatosAnticoncepcion";

    String RUTA_IR_INTERCONSULTA_ANTICONCEPCION = 
        "irInterConsultaAnticoncepcion";

    String RUTA_IR_ORDENCIRUGIA_ANTICONCEPCION = 
        "irOrdenCirugiaAnticoncepcion";

    String RUTA_IR_INCAPACIDAD_ANTICONCEPCION = "irIncapacidadAnticoncepcion";

    String RUTA_IR_HOSPITALZACION_ANTICONCEPCION = 
        "irRemHospitalizacionAnticoncepcion";

    String RUTA_IR_FORMULAMEDICA_ANTICONCEPCION = 
        "irFormulaMedicaAnticoncepcion";

    String RUTA_IR_VADEMCUM_ANTICONCEPCION = "irVademecumAnticoncepcion";

    String RUTA_IR_CONTOLSINCOSTO_ANTICONCEPCION = 
        "irControlSinCostoAnticoncepcion";

    String RUTA_IR_ANATOMIAPATOLOGICA_ANTICONCEPCION = 
        "irAnatPatologicaAnticoncepcion";

    String RUTA_IR_APLICACION_RETITO_ANTICONCEPCION = 
        "irAplicacionRetiroAnticoncepcion";

    String RUTA_IR_IMPRESION_DIAGNOSTICA_ANTICONCEPCION = 
        "irImpDiagnosticaAnticoncepcion";

    String RUTA_IR_ENCUESTA_VIOLENCIA_ANTICONCEPCION = 
        "irEncuestaViolenciaAnticoncepcion";

    String RUTA_IR_EXAMENFISICO_ANTICONCEPCION = 
        "irExamenFisicoAnticoncepcion";

    String RUTA_IR_ANTECEDENTES_GENERALES_ANTICONCEPCION = 
        "irAntecedentesGeneralesAnticoncepcion";

    String RUTA_IR_ANTECEDENTES_GINECOLOGICOS_ANTICONCEPCION = 
        "irAntecedentesGinecologicosAnticoncepcion";

    String RUTA_IR_CERTIFICADO_ASISTENCIA_ANTICONCEPCION = 
        "irCertificadoAsistenciaAnticoncepcion";

    String RUTA_IR_CERTIFICADOMEDICO_ANTICONCEPCION = 
        "irCertificadoMedicoAnticoncepcion";

    String RUTA_IR_ELECTROFISIOLOGICO__ANTICONCEPCION = 
        "irExamenElectrofisiologicosAnticoncepcion";

    String RUTA_IR_IMAGENES_ANTICONCEPCION = "irExamenImagenesAnticoncepcion";

    String RUTA_IR_LABORATORIO_ANTICONCEPCION = 
        "irExamenLaboratorioAnticoncepcion";

    String RUTA_IR_RECOMENDACIONES_ANTICONCEPCION = 
        "irRecomendacionesAnticoncepcion";

    String RUTA_IR_REFERENCIA_ANTICONCEPCIONL = "irReferenciaAnticoncepcion";

    String RUTA_IR_RESERVA_SANGRE_ANTICONCEPCION = 
        "irReservaSangreAnticoncepcion";

    String RUTA_IR_CERRAR_CONSULTA_ANTICONCEPCION = 
        "irCerrarConsultaAnticoncepcion";

    String RUTA_IR_RESUMEN_ESPECIFICO_ANTICONCEPCION = 
        "irResumenHistoriaEspecificaAnticoncepcion";

    String RUTA_IR_RESUMEN_ANTICONCEPCION = "irResumenHistoriaAnticoncepcion";

    // ESTERILIZACION

    String RUTA_IR_DATOS_ESTERILIZACION = "irDatosEsterilizacion";

    String RUTA_IR_MOTIVO_ESTERILIZACION = "irMotivoEsterilizacion";
    
    String RUTA_IR_CUESTIONARIO_COVID_ESTERILIZACION = "irCuestionarioCovidEsterilizacion"; 

    String RUTA_IR_ANTECEDENTES_ESTERILIZACION = 
        "irAntecedentesEsterilizacionFemenina";

    String RUTA_IR_ANTECEDENTES_GENERALES_ESTERILIZACION = 
        "irAntecedentesGeneralesEsterilizacionFemenina";


    String RUTA_IR_EXAMEN_FISICO_ESTERILIZACION = 
        "irExamenFisicoEsterilizacion";

    String RUTA_IR_ENCUESTA_VIOLENCIA_ESTERILIZACION = 
        "irEncuestaViolenciaEsterilizacion";

    String RUTA_IR_IMP_DIAGNOSTICA_ESTERILIZACION = 
        "irImpDiagnosticaEsterilizacion";

    String RUTA_IR_ANAT_PATOLOGICA_ESTERILIZACION = 
        "irAnatPatologicaEsterilizacion";

    String RUTA_IR_CONTROL_SIN_COSTO_ESTERILIZACION = 
        "irControlSinCostoEsterilizacion";

    String RUTA_IR_FORMULA_MEDICA_ESTERILIZACION = 
        "irFormulaMedicaEsterilizacion";

    String RUTA_IR_REM_HOSPITALIZACION_ESTERILIZACION = 
        "irRemHospitalizacionEsterilizacion";

    String RUTA_IR_ORDEN_CIRUGIA_ESTERILIZACION = 
        "irOrdenCirugiaEsterilizacion";

    String RUTA_IR_ORDEN_LIQUIDOS_ESTERILIZACION = 
        "irOrdenLiquidosEsterilizacion";
        
    String RUTA_IR_OTRAS_ORDENES_ESTERILIZACION = "irOtrasOrdenesEsterilizacion"; 

    String RUTA_IR_ORDEN_MEDICAMENTOS_ESTERILIZACION = 
        "irOrdenMedicamentosEsterilizacion";

    String RUTA_IR_INTERCONSULTA_ESTERILIZACION = 
        "irInterConsultaEsterilizacion";

    String RUTA_IR_INCAPACIDAD_ESTERILIZACION = "irIncapacidadEsterilizacion";

    String RUTA_IR_RECOMENDACIONES_ESTERILIZACION = 
        "irRecomedacionEsterilizacion";

    String RUTA_IR_REFERENCIA_ESTERILIZACION = "irReferenciaEsterilizacion";

    String RUTA_IR_RESERVA_SANGRE_ESTERILIZACION = 
        "irReservaSangreEsterilizacion";

    String RUTA_IR_CERT_MEDICO_ESTERILIZACION = "irCertMedicoEsterilizacion";

    String RUTA_IR_CERT_ASISTENCIA_ESTERILIZACION = 
        "irCertAsistenciaEsterilizacion";

    String RUTA_IR_EXAM_ELECTROFISIOLOGICO_ESTERILIZACION = 
        "irExamElectrofisiologicoEsterilizacion";

    String RUTA_IR_EXAM_IMAGEN_ESTERILIZACION = "irExamImagenEsterilizacion";

    String RUTA_IR_EXAM_LABORATORIO_ESTERILIZACION = 
        "irExamLaboratorioEsterilizacion";


    String RUTA_IR_FORMULA_HOSPITALIZACION = "irFormulaHospitalizacion";

    String RUTA_IR_MEDIDAS_APOYO = "irMedidasApoyo";

    String RUTA_IR_LIQUIDOS_ANESTESIA = "irRegistrarLiquidosAnestesia";

    String RUTA_IR_MEDICAMENTOS_ANESTESIA = "irRegistrarMedicamentosAnestesia";

    String RUTA_IR_ANT_GINECOLOGICOS_ESTERILIZACION = "irAntGinecologicos";

    String RUTA_IR_CERRAR_CONSULTA_ESTERILIZACION = "irCerrarEsterilizacion";


    // HISTORIA EXAMEN MAMA

    String RUTA_IR_DATOS_MAMA = "irDatosMama";

    String RUTA_IR_MOTIVO_MAMA = "irMotivoMama";
    
    String RUTA_IR_CUESTIONARIO_COVID_MAMA = "irCuestionarioCovidMama";

    String RUTA_IR_INTERCONSULTA_MAMA = "irInterConsultaMama";

    String RUTA_IR_ORDENCIRUGIA_MAMA = "irOrdenCirugiaMama";

    String RUTA_IR_INCAPACIDAD_MAMA = "irIncapacidadMama";

    String RUTA_IR_HOSPITALZACION_MAMA = "irRemHospitalizacionMama";

    String RUTA_IR_FORMULAMEDICA_MAMA = "irFormulaMedicaMama";

    String RUTA_IR_VADEMCUM_MAMA = "irFormulaMedicaMama";

    String RUTA_IR_CONTOLSINCOSTO_MAMA = "irControlSinCostoMama";

    String RUTA_IR_ANATOMIAPATOLOGICA_MAMA = "irAnatPatologicaMama";

    String RUTA_IR_IMPRESION_DIAGNOSTICA_MAMA = "irImpDiagnosticaMama";

    String RUTA_IR_ENCUESTA_VIOLENCIA_MAMA = "irEncuestaViolenciaMama";

    String RUTA_IR_EXAMENFISICO_MAMA = "irExamenFisicoMama";

    String RUTA_IR_ANTECEDENTES_MAMA = "irAntecedentesMama";

    String RUTA_IR_ANTECEDENTES_GENERALES_MAMA = "irAntecedentesGeneralesMama";

    String RUTA_IR_RIESGO_EXAMEN_MAMA = "irRiesgoExamenMama";

    String RUTA_IR_CERTIFICADO_ASISTENCIA_MAMA = "irCertificadoAsistenciaMama";

    String RUTA_IR_CERTIFICADOMEDICO_MAMA = "irCertificadoMedicoMama";

    String RUTA_IR_ELECTROFISIOLOGICO_MAMA = "irExamenElectrofisiologicosMama";

    String RUTA_IR_IMAGENES_MAMA = "irExamenImagenesMama";

    String RUTA_IR_LABORATORIO_MAMA = "irExamenLaboratorioMama";

    String RUTA_IR_RECOMENDACIONES_MAMA = "irRecomendacionesMama";

    String RUTA_IR_REFERENCIA_MAMA = "irReferenciaMama";

    String RUTA_IR_RESERVA_SANGRE_MAMA = "irReservaSangreMama";

    String RUTA_IR_EXAMEN_FISICO_EXAMEN_MAMA = "irExamenFisicoExamenMama";

    String RUTA_IR_CERRAR_CONSULTA_EXAMEN_MAMA = "irCerrarConsultaMama";

    String RUTA_IR_RESUMEN_HISTORIA_ESPECIFICA_MAMA = 
        "irResumenHistoriaEspecificaMama";

    String RUTA_IR_RESUMEN_HISTORIA_MAMA = "irResumenHistoriaMama";


    // HISTORIA PEDIATRIA

    String RUTA_IR_DATOS_PEDIATRIA = "irDatosPediatria";

    String RUTA_IR_MOTIVO_PEDIATRIA = "irMotivoPediatria";
    
    String RUTA_IR_CUESTIONARIO_COVID_PEDIATRIA = "irCuestionarioCovidPediatria";

    String RUTA_IR_INTERCONSULTA_PEDIATRIA = "irInterConsultaPediatria";

    String RUTA_IR_ORDENCIRUGIA_PEDIATRIA = "irOrdenCirugiaPediatria";

    String RUTA_IR_INCAPACIDAD_PEDIATRIA = "irIncapacidadPediatria";

    String RUTA_IR_HOSPITALZACION_PEDIATRIA = "irRemHospitalizacionPediatria";

    String RUTA_IR_FORMULAMEDICA_PEDIATRIA = "irFormulaMedicaPediatria";

    String RUTA_IR_VADEMCUM_PEDIATRIA = "irVademecumPediatria";

    String RUTA_IR_CONTOLSINCOSTO_PEDIATRIA = "irControlSinCostoPediatria";

    String RUTA_IR_ANATOMIAPATOLOGICA_PEDIATRIA = "irAnatPatologicaPediatria";

    String RUTA_IR_IMPRESION_DIAGNOSTICA_PEDIATRIA = 
        "irImpDiagnosticaPediatria";

    String RUTA_IR_ENCUESTA_VIOLENCIA_PEDIATRIA = 
        "irEncuestaViolenciaPediatria";

    String RUTA_IR_EXAMEN_FISICO_PEDIATRIA_USUARIO = 
        "irExamenFisicoPediatriaUsuario";

    String RUTA_IR_EXAMEN_PEDIATRIA = "irExamenPediatria";

    String RUTA_IR_ANTECEDENTES_PEDIATRIA = "irAntecedentesPediatria";

    String RUTA_IR_ANTECEDENTES_GENERALES_PEDIATRIA = 
        "irAntecedentesGeneralesPediatria";

    String RUTA_IR_ANTECEDENTES_GINECOLOGICOS_PEDIATRIA = 
        "irAntecedentesGinecologicosPediatria";

    String RUTA_IR_CERTIFICADO_ASISTENCIA_PEDIATRIA = 
        "irCertificadoAsistenciaPediatria";

    String RUTA_IR_CERTIFICADOMEDICO_PEDIATRIA = 
        "irCertificadoMedicoPediatria";

    String RUTA_IR_ELECTROFISIOLOGICO_PEDIATRIA = 
        "irExamenElectrofisiologicosPediatria";

    String RUTA_IR_IMAGENES_PEDIATRIA = "irExamenImagenesPediatria";

    String RUTA_IR_LABORATORIO_PEDIATRIA = "irExamenLaboratorioPediatria";

    String RUTA_IR_RECOMENDACIONES_PEDIATRIA = "irRecomendacionesPediatria";

    String RUTA_IR_REFERENCIA_PEDIATRIA = "irReferenciaPediatria";

    String RUTA_IR_AUTORIZACION_SERVICIO_PEDIATRIA = 
        "irAutorizacionServicioPediatria";

    String RUTA_IR_RESERVA_SANGRE_PEDIATRIA = "irReservaSangrePediatria";

    String RUTA_IR_CERRAR_CONSULTA_PEDIATRIA = "irCerrarConsultaPediatria";

    String RUTA_IR_RESUMEN_HISTORIA_ESPECIFICA_PEDIATRIA = 
        "irResumenHistoriaEspecificaPediatria";

    String RUTA_IR_RESUMEN_HISTORIA_PEDIATRIA = "irResumenHistoriaPediatria";


    // HISTORIA PRENATAL

    String RUTA_IR_DATOS_PRENATAL = "irDatosPrenatal";

    String RUTA_IR_MOTIVO_PRENATAL = "irMotivoPrenatal";
    
    String RUTA_IR_CUESTIONARIO_COVID_PRENATAL = "irCuestionarioCovidPrenatal"; 

    String RUTA_IR_INTERCONSULTA_PRENATAL = "irInterConsultaPrenatal";

    String RUTA_IR_ORDENCIRUGIA_PRENATAL = "irOrdenCirugiaPrenatal";

    String RUTA_IR_INCAPACIDAD_PRENATAL = "irIncapacidadPrenatal";

    String RUTA_IR_HOSPITALZACION_PRENATAL = "irRemHospitalizacionPrenatal";

    String RUTA_IR_FORMULAMEDICA_PRENATAL = "irFormulaMedicaPrenatal";

    String RUTA_IR_VADEMECUM_PRENATAL = "irVademecumPrenatal";


    String RUTA_IR_CONTOLSINCOSTO_PRENATAL = "irControlSinCostoPrenatal";

    String RUTA_IR_ANATOMIAPATOLOGICA_PRENATAL = "irAnatPatologicaPrenatal";

    String RUTA_IR_IMPRESION_DIAGNOSTICA_PRENATAL = "irImpDiagnosticaPrenatal";

    String RUTA_IR_ENCUESTA_VIOLENCIA_PRENATAL = "irEncuestaViolenciaPrenatal";

    String RUTA_IR_EXAMENFISICO_PRENATAL = "irExamenFisicoPrenatal";

    String RUTA_IR_ANTECEDENTES_PRENATAL = "irAntecedentesPrenatal";

    String RUTA_IR_ANTECEDENTES_ESPECIFICOS_PRENATAL = 
        "irAntecedentesEspecificosPrenatal";

    String RUTA_IR_GESTACION_PRENATAL = "irGestacionPrenatal";

    String RUTA_IR_GESTACION_CONTROL_PRENATAL = "irGestacionControlPrenatal";

    String RUTA_IR_ANTECEDENTES_GENERALES_PRENATAL = 
        "irAntecedentesGeneralesPrenatal";

    String RUTA_IR_ANTECEDENTES_GINECOLOGICOS_PRENATAL = 
        "irAntecedentesGinecologicosPrenatal";

    String RUTA_IR_ANTECEDENTES_OBSTETRICOS_PRENATAL = 
        "irAntecedentesObstetricosPrenatal";

    String RUTA_IR_CERTIFICADO_ASISTENCIA_PRENATAL = 
        "irCertificadoAsistenciaPrenatal";

    String RUTA_IR_CERTIFICADOMEDICO_PRENATAL = "irCertificadoMedicoPrenatal";

    String RUTA_IR_ELECTROFISIOLOGICO_PRENATAL = 
        "irExamenElectrofisiologicosPrenatal";

    String RUTA_IR_IMAGENES_PRENATAL = "irExamenImagenesPrenatal";

    String RUTA_IR_LABORATORIO_PRENATAL = "irExamenLaboratorioPrenatal";

    String RUTA_IR_RECOMENDACIONES_PRENATAL = "irRecomendacionesPrenatal";

    String RUTA_IR_REFERENCIA_PRENATAL = "irReferenciaPrenatal";

    String RUTA_IR_RESERVA_SANGRE_PRENATAL = "irReservaSangrePrenatal";

    String RUTA_IR_CERRAR_CONSULTA_PRENATAL = "irCerrarConsultaPrenatal";

    String RUTA_IR_RESUMEN_HISTORIA_ESPECIFICA_PRENATAL = 
        "irResumenHistoriaEspecificaPrenatal";

    String RUTA_IR_RESUMEN_HISTORIA_PRENATAL = "irResumenHistoriaPrenatal";

    // HISTORIA CONTROL PRENATAL

    String RUTA_IR_DATOS_CONTROL_PRENATAL = "irDatosControlPrenatal";

    String RUTA_IR_MOTIVO_CONTROL_PRENATAL = "irMotivoControlPrenatal";
    
    String RUTA_IR_CUESTIONARIO_COVID_CONTROL_PRENATAL = "irCuestionarioCovidControlPrenatal";

    String RUTA_IR_INTERCONSULTA_CONTROL_PRENATAL = 
        "irInterConsultaControlPrenatal";

    String RUTA_IR_ORDENCIRUGIA_CONTROL_PRENATAL = 
        "irOrdenCirugiaControlPrenatal";

    String RUTA_IR_INCAPACIDAD_CONTROL_PRENATAL = 
        "irIncapacidadControlPrenatal";

    String RUTA_IR_HOSPITALZACION_CONTROL_PRENATAL = 
        "irRemHospitalizacionControlPrenatal";

    String RUTA_IR_FORMULAMEDICA_CONTROL_PRENATAL = 
        "irFormulaMedicaControlPrenatal";

    String RUTA_IR_VADEMCUM_PRENATAL = "irVademecumControlPrenatal";


    String RUTA_IR_CONTOLSINCOSTO_CONTROL_PRENATAL = 
        "irControlSinCostoControlPrenatal";

    String RUTA_IR_ANATOMIAPATOLOGICA_CONTROL_PRENATAL = 
        "irAnatPatologicaControlPrenatal";

    String RUTA_IR_IMPRESION_DIAGNOSTICA_CONTROL_PRENATAL = 
        "irImpDiagnosticaControlPrenatal";

    String RUTA_IR_ENCUESTA_VIOLENCIA_CONTROL_PRENATAL = 
        "irEncuestaViolenciaControlPrenatal";

    String RUTA_IR_EXAMENFISICO_CONTROL_PRENATAL = 
        "irExamenFisicoControlPrenatal";

    String RUTA_IR_ANTECEDENTES_CONTROL_PRENATAL = 
        "irAntecedentesControlPrenatal";

    String RUTA_IR_ANTECEDENTES_GENERALES_CONTROL_PRENATAL = 
        "irAntecedentesGeneralesControlPrenatal";

    String RUTA_IR_ANTECEDENTES_GINECOLOGICOS_CONTROL_PRENATAL = 
        "irAntecedentesGinecologicosControlPrenatal";

    String RUTA_IR_CERTIFICADO_ASISTENCIA_CONTROL_PRENATAL = 
        "irCertificadoAsistenciaControlPrenatal";

    String RUTA_IR_CERTIFICADOMEDICO_CONTROL_PRENATAL = 
        "irCertificadoMedicoControlPrenatal";

    String RUTA_IR_ELECTROFISIOLOGICO_CONTROL_PRENATAL = 
        "irExamenElectrofisiologicosControlPrenatal";

    String RUTA_IR_IMAGENES_CONTROL_PRENATAL = 
        "irExamenImagenesControlPrenatal";

    String RUTA_IR_LABORATORIO_CONTROL_PRENATAL = 
        "irExamenLaboratorioControlPrenatal";

    String RUTA_IR_RECOMENDACIONES_CONTROL_PRENATAL = 
        "irRecomendacionesControlPrenatal";

    String RUTA_IR_REFERENCIA_CONTROL_PRENATAL = "irReferenciaControlPrenatal";

    String RUTA_IR_RESERVA_SANGRE_CONTROL_PRENATAL = 
        "irReservaSangreControlPrenatal";

    String RUTA_IR_CERRAR_CONSULTA_CONTROL_PRENATAL = 
        "irCerrarConsultaControlPrenatal";

    String RUTA_IR_RESUMEN_HISTORIA_ESPECIFICA_CONTROL_PRENATAL = 
        "irResumenHistoriaEspecificaControlPrenatal";

    String RUTA_IR_RESUMEN_HISTORIA_CONTROL_PRENATAL = 
        "irResumenHistoriaControlPrenatal";

    // HISTORIA CONTROL


    String RUTA_IR_DATOS_CONTROL = "irDatosControl";

    String RUTA_IR_MOTIVO_CONTROL = "irMotivoControl";

    String RUTA_IR_EXAMEN_FISICO_CONTROL = "irExamenFisicoControl";

    String RUTA_IR_INTERCONSULTA_CONTROL = "irInterConsultaControl";

    String RUTA_IR_ORDENCIRUGIA_CONTROL = "irOrdenCirugiaControl";

    String RUTA_IR_INCAPACIDAD_CONTROL = "irIncapacidadControl";

    String RUTA_IR_HOSPITALZACION_CONTROL = "irRemHospitalizacionControl";

    String RUTA_IR_AUTORIZACION_SERVICIOS_CONTROL = 
        "irAutorizacionServicioControl";

    String RUTA_IR_FORMULAMEDICA_CONTROL = "irFormulaMedicaControl";

    String RUTA_IR_VADEMCUM_CONTROL = "irVademecumControl";


    String RUTA_IR_CONTOLSINCOSTO_CONTROL = "irControlSinCostoControl";

    String RUTA_IR_ANATOMIAPATOLOGICA_CONTROL = "irAnatPatologicaControl";

    String RUTA_IR_APLICACION_RETITO_CONTROL = "irAplicacionRetiroControl";

    String RUTA_IR_IMPRESION_DIAGNOSTICA_CONTROL = "irImpDiagnosticaControl";

    String RUTA_IR_CONTROL_USUARIO = "irControlUsuario";
    
    String RUTA_IR_CUESTIONARIO_COVID_CONTROL = "irCuestionarioCovidControl";


    String RUTA_IR_ANTECEDENTES_CONTROL = "irAntecedentesControl";

    String RUTA_IR_ANTECEDENTES_GENERALES_CONTROL = 
        "irAntecedentesGeneralesControl";

    String RUTA_IR_CERTIFICADO_ASISTENCIA_CONTROL = 
        "irCertificadoAsistenciaControl";

    String RUTA_IR_CERTIFICADOMEDICO_CONTROL = "irCertificadoMedicoControl";

    String RUTA_IR_ELECTROFISIOLOGICO_CONTROL = 
        "irExamenElectrofisiologicosControl";

    String RUTA_IR_IMAGENES_CONTROL = "irExamenImagenesControl";

    String RUTA_IR_LABORATORIO_CONTROL = "irExamenLaboratorioControl";

    String RUTA_IR_RECOMENDACIONES_CONTROL = "irRecomendacionesControl";

    String RUTA_IR_REFERENCIA_CONTROL = "irReferenciaControl";

    String RUTA_IR_RESERVA_SANGRE_CONTROL = "irReservaSangreControl";

    String RUTA_IR_CERRAR_CONTROL = "irCerrarConsultaControl";

    String RUTA_IR_RESUMEN_HISTORIA_ESPECIFICA_CONTROL = 
        "irResumenHistoriaEspecificaControl";

    String RUTA_IR_RESUMEN_HISTORIA_CONTROL = "irResumenHistoriaControl";


    // HISTORIA CONTROL _FERTILIDAD 


    String RUTA_IR_DATOS_CONTROL_FERTILIDAD = "irDatosControlFertilidad";

    String RUTA_IR_MOTIVO_CONTROL_FERTILIDAD = "irMotivoControlFertilidad";

    String RUTA_IR_EXAMEN_FISICO_CONTROL_FERTILIDAD = 
        "irExamenFisicoControlFertilidad";

    String RUTA_IR_INTERCONSULTA_CONTROL_FERTILIDAD = 
        "irInterConsultaControlFertilidad";

    String RUTA_IR_ORDENCIRUGIA_CONTROL_FERTILIDAD = 
        "irOrdenCirugiaControlFertilidad";

    String RUTA_IR_INCAPACIDAD_CONTROL_FERTILIDAD = 
        "irIncapacidadControlFertilidad";

    String RUTA_IR_HOSPITALZACION_CONTROL_FERTILIDAD = 
        "irRemHospitalizacionControlFertilidad";

    String RUTA_IR_AUTORIZACION_SERVICIOS_CONTROL_FERTILIDAD = 
        "irAutorizacionServicioControlFertilidad";

    String RUTA_IR_FORMULAMEDICA_CONTROL_FERTILIDAD = 
        "irFormulaMedicaControlFertilidad";

    String RUTA_IR_VADEMCUM_CONTROL_FERTILIDAD = 
        "irVademecumControlFertilidad";


    String RUTA_IR_CONTOLSINCOSTO_CONTROL_FERTILIDAD = 
        "irControlSinCostoControlFertilidad";

    String RUTA_IR_ANATOMIAPATOLOGICA_CONTROL_FERTILIDAD = 
        "irAnatPatologicaControlFertilidad";

    String RUTA_IR_APLICACION_RETITO_CONTROL_FERTILIDAD = 
        "irAplicacionRetiroControlFertilidad";

    String RUTA_IR_IMPRESION_DIAGNOSTICA_CONTROL_FERTILIDAD = 
        "irImpDiagnosticaControlFertilidad";

    String RUTA_IR_CONTROL_USUARIO_FERTILIDAD = "irControlUsuarioFertilidad";
    
    String RUTA_IR_CUESTIONARIO_COVID_CONTROL_FERTILIDAD = "irCuestionarioCovidControlFertilidad";


    String RUTA_IR_ANTECEDENTES_CONTROL_FERTILIDAD = 
        "irAntecedentesControlFertilidad";

    String RUTA_IR_ANTECEDENTES_GENERALES_CONTROL_FERTILIDAD = 
        "irAntecedentesGeneralesControlFertilidad";

    String RUTA_IR_CERTIFICADO_ASISTENCIA_CONTROL_FERTILIDAD = 
        "irCertificadoAsistenciaControlFertilidad";

    String RUTA_IR_CERTIFICADOMEDICO_CONTROL_FERTILIDAD = 
        "irCertificadoMedicoControlFertilidad";

    String RUTA_IR_ELECTROFISIOLOGICO_CONTROL_FERTILIDAD = 
        "irExamenElectrofisiologicosControlFertilidad";

    String RUTA_IR_IMAGENES_CONTROL_FERTILIDAD = 
        "irExamenImagenesControlFertilidad";

    String RUTA_IR_LABORATORIO_CONTROL_FERTILIDAD = 
        "irExamenLaboratorioControlFertilidad";

    String RUTA_IR_RECOMENDACIONES_CONTROL_FERTILIDAD = 
        "irRecomendacionesControlFertilidad";

    String RUTA_IR_REFERENCIA_CONTROL_FERTILIDAD = 
        "irReferenciaControlFertilidad";

    String RUTA_IR_RESERVA_SANGRE_CONTROL_FERTILIDAD = 
        "irReservaSangreControlFertilidad";

    String RUTA_IR_CERRAR_CONTROL_FERTILIDAD = 
        "irCerrarConsultaControlFertilidad";

    String RUTA_IR_RESUMEN_HISTORIA_ESPECIFICA_CONTROL_FERTILIDAD = 
        "irResumenHistoriaEspecificaControlFertilidad";

    String RUTA_IR_RESUMEN_HISTORIA_CONTROL_FERTILIDAD = 
        "irResumenHistoriaControlFertilidad";

    String RUTA_IR_ECOGRAFIA_CONTROL_FERTILIDAD = 
        "irEcografiaControlFertilidad";


    // HISTORIA CONTROL


    String RUTA_IR_DATOS_CONTROL_ILVE = "irDatosIlveControl";

    String RUTA_IR_MOTIVO_CONTROL_ILVE = "irMotivoControlIlve";

    String RUTA_IR_EXAMEN_FISICO_CONTROL_ILVE = "irExamenFisicoControlIlve";

    String RUTA_IR_IMPRESION_DIAGNOSTICA_ILVE = 
        "irImpresionDiagnosticaControlIlve";

    String RUTA_IR_INTERCONSULTA_CONTROL_ILVE = "irInterConsultaControlIlve";

    String RUTA_IR_ORDENCIRUGIA_CONTROL_ILVE = "irOrdenCirugiaControlIlve";

    String RUTA_IR_INCAPACIDAD_CONTROL_ILVE = "irIncapacidadControlIlve";

    String RUTA_IR_HOSPITALZACION_CONTROL_ILVE = 
        "irRemHospitalizacionControlIlve";

    String RUTA_IR_FORMULAMEDICA_CONTROL_ILVE = "irFormulaMedicaControlIlve";

    String RUTA_IR_VADEMCUM_CONTROL_ILVE = "irVademecumControlIlve";

    String RUTA_IR_CONTOLSINCOSTO_CONTROL_ILVE = 
        "irControlSinCostoControlIlve";

    String RUTA_IR_ANATOMIAPATOLOGICA_CONTROL_ILVE = 
        "irAnatPatologicaControlIlve";

    String RUTA_IR_APLICACION_RETITO_CONTROL_ILVE = 
        "irAplicacionRetiroControlIlve";

    String RUTA_IR_IMPRESION_DIAGNOSTICA_CONTROL_ILVE = 
        "irImpDiagnosticaControlIlve";

    String RUTA_IR_AUTORIZACION_SERVICIOS_CONTROL_ILVE = 
        "irAutorizacionServicioControlIlve";


    String RUTA_IR_CONTROL_USUARIO_ILVE = "irControlIlveUsuario";
    

    String RUTA_IR_CUESTIONARIO_COVID_CONTROL_ILVE = "irCuestionarioCovidControlIlve";


    String RUTA_IR_ANTECEDENTES_CONTROL_ILVE = "irAntecedentesControlIlve";

    String RUTA_IR_ANTECEDENTES_GENERALES_CONTROL_ILVE = 
        "irAntecedentesGeneralesControlIlve";

    String RUTA_IR_CERTIFICADO_ASISTENCIA_CONTROL_ILVE = 
        "irCertificadoAsistenciaControlIlve";

    String RUTA_IR_CERTIFICADOMEDICO_CONTROL_ILVE = 
        "irCertificadoMedicoControlIlve";

    String RUTA_IR_ELECTROFISIOLOGICO_CONTROL_ILVE = 
        "irExamenElectrofisiologicosControlIlve";

    String RUTA_IR_IMAGENES_CONTROL_ILVE = "irExamenImagenesControlIlve";

    String RUTA_IR_LABORATORIO_CONTROL_ILVE = "irExamenLaboratorioControlIlve";

    String RUTA_IR_RECOMENDACIONES_CONTROL_ILVE = 
        "irRecomendacionesControlIlve";

    String RUTA_IR_REFERENCIA_CONTROL_ILVE = "irReferenciaControlIlve";

    String RUTA_IR_RESERVA_SANGRE_CONTROL_ILVE = "irReservaSangreControlIlve";

    String RUTA_IR_CERRAR_CONTROL_ILVE = "irCerrarConsultaControlIlve";

    String RUTA_IR_RESUMEN_HISTORIA_ESPECIFICA_CONTROL_ILVE = 
        "irResumenHistoriaEspecificaControlIlve";

    String RUTA_IR_RESUMEN_HISTORIA_CONTROL_ILVE = 
        "irResumenHistoriaControlIlve";
        
    String RUTA_IR_IDENTIFICACION_RIESGOS_CONTROL_ILVE = 
        "irIdentificacionControlRiesgoInterrupcion";

    String RUTA_IR_CERTIFICADO_CONTROL_ILVE = 
        "irRemisionControlIlveInterrupcion";

    // HISTORIA PROCEDIMIENTOS EN CONSULTORIO


    String RUTA_IR_DATOS_PROCEDIMIENTO_CONSULTORIO = 
        "irDatosProcedimientoConsultorio";

    String RUTA_IR_INTERCONSULTA_PROCEDIMIENTO_CONSULTORIO = 
        "irInterConsultaProcedimientoConsultorio";

    String RUTA_IR_ORDENCIRUGIA_PROCEDIMIENTO_CONSULTORIO = 
        "irOrdenCirugiaProcedimientoConsultorio";

    String RUTA_IR_INCAPACIDAD_PROCEDIMIENTO_CONSULTORIO = 
        "irIncapacidadProcedimientoConsultorio";

    String RUTA_IR_HOSPITALZACION_PROCEDIMIENTO_CONSULTORIO = 
        "irRemHospitalizacionProcedimientoConsultorio";

    String RUTA_IR_FORMULAMEDICA_PROCEDIMIENTO_CONSULTORIO = 
        "irFormulaMedicaProcedimientoConsultorio";

    String RUTA_IR_VADEMCUM_PROCEDIMIENTO_CONSULTORIO = 
        "irVademecumProcedimientoConsultorio";


    String RUTA_IR_CONTOLSINCOSTO_PROCEDIMIENTO_CONSULTORIO = 
        "irControlSinCostoProcedimientoConsultorio";

    String RUTA_IR_ANATOMIAPATOLOGICA_PROCEDIMIENTO_CONSULTORIO = 
        "irAnatPatologicaProcedimientoConsultorio";

    String RUTA_IR_CERTIFICADO_ASISTENCIA_PROCEDIMIENTO_CONSULTORIO = 
        "irCertificadoAsistenciaProcedimientoConsultorio";

    String RUTA_IR_CERTIFICADOMEDICO_PROCEDIMIENTO_CONSULTORIO = 
        "irCertificadoMedicoProcedimientoConsultorio";

    String RUTA_IR_ELECTROFISIOLOGICO_PROCEDIMIENTO_CONSULTORIO = 
        "irExamenElectrofisiologicosProcedimientoConsultorio";

    String RUTA_IR_IMAGENES_PROCEDIMIENTO_CONSULTORIO = 
        "irExamenImagenesProcedimientoConsultorio";

    String RUTA_IR_LABORATORIO_PROCEDIMIENTO_CONSULTORIO = 
        "irExamenLaboratorioProcedimientoConsultorio";

    String RUTA_IR_RECOMENDACIONES_PROCEDIMIENTO_CONSULTORIO = 
        "irRecomendacionesProcedimientoConsultorio";

    String RUTA_IR_REFERENCIA_PROCEDIMIENTO_CONSULTORIO = 
        "irReferenciaProcedimientoConsultorio";

    String RUTA_IR_RESERVA_SANGRE_PROCEDIMIENTO_CONSULTORIO = 
        "irReservaSangreProcedimientoConsultorio";

    String RUTA_IR_PROCEDIMIENTO_CONSULTORIO_USUARIO = "irProcedimientoConsultorioUsuario";
    
    String RUTA_IR_CUESTIONARIO_COVID_PROCEDIMIENTO_CONSULTORIO = "irCuestionarioCovidProcedimientoConsultorio"; 

    String RUTA_IR_ANTECEDENTES_TEMPORALES_USUARIO = 
        "irAntecedentesTemporalesUsuario";

    String RUTA_IR_ANTECEDENTES_ANTICONCEPCION = 
        "irAntecedentesAnticoncepcion";

    String RUTA_IR_ANTECEDENTES_TEMPORALES_ANTICONCEPCION = 
        "irAntecedentesTemporalesAnticoncepcion";

    String RUTA_IR_CERRAR_CONSULTA_PROCEDIMIENTO_CONSULTORIO = 
        "irCerrarConsultaProcedimientoConsultorio";


    // HISTORIA CONTROL ANTICONCEPCION

    String RUTA_IR_DATOS_CONTROL_ANTICONCEPCION = 
        "irDatosControlAnticoncepcion";

    String RUTA_IR_MOTIVO_CONTROL_ANTICONCEPCION =   "irMotivoControlAnticoncepcion";
    
    String RUTA_IR_CUESTIONARIO_COVID_CONTROL_ANTICONCEPCION = "irCuestionarioCovidControlAnticoncepcion";


    String RUTA_IR_INTERCONSULTA_CONTROL_ANTICONCEPCION = 
        "irInterConsultaControlAnticoncepcion";

    String RUTA_IR_ORDENCIRUGIA_CONTROL_ANTICONCEPCION = 
        "irOrdenCirugiaControlAnticoncepcion";

    String RUTA_IR_INCAPACIDAD_CONTROL_ANTICONCEPCION = 
        "irIncapacidadControlAnticoncepcion";

    String RUTA_IR_HOSPITALZACION_CONTROL_ANTICONCEPCION = 
        "irRemHospitalizacionControlAnticoncepcion";

    String RUTA_IR_FORMULAMEDICA_CONTROL_ANTICONCEPCION = 
        "irFormulaMedicaControlAnticoncepcion";

    String RUTA_IR_VADEMCUM_CONTROL_ANTICONCEPCION = 
        "irVademecumControlAnticoncepcion";


    String RUTA_IR_CONTOLSINCOSTO_CONTROL_ANTICONCEPCION = 
        "irControlSinCostoControlAnticoncepcion";

    String RUTA_IR_ANATOMIAPATOLOGICA_CONTROL_ANTICONCEPCION = 
        "irAnatPatologicaControlAnticoncepcion";

    String RUTA_IR_APLICACION_RETITO_CONTROL_ANTICONCEPCION = 
        "irAplicacionRetiroControlAnticoncepcion";


    String RUTA_IR_IMPRESION_DIAGNOSTICA_CONTROL_ANTICONCEPCION = 
        "irImpDiagnosticaControlAnticoncepcion";

    String RUTA_IR_ENCUESTA_VIOLENCIA_CONTROL_ANTICONCEPCION = 
        "irEncuestaViolenciaControlAnticoncepcion";

    String RUTA_IR_EXAMENFISICO_CONTROL_ANTICONCEPCION = 
        "irExamenFisicoControlAnticoncepcion";

    String RUTA_IR_ANTECEDENTES_CONTROL_ANTICONCEPCION = 
        "irAntecedentesControlAnticoncepcion";

    String RUTA_IR_ANTECEDENTES_GENERALES_CONTROL_ANTICONCEPCION = 
        "irAntecedentesGeneralesControlAnticoncepcion";

    String RUTA_IR_ANTECEDENTES_GINECOLOGICOS_CONTROL_ANTICONCEPCION = 
        "irAntecedentesGinecologicosControlAnticoncepcion";

    String RUTA_IR_CERTIFICADO_ASISTENCIA_CONTROL_ANTICONCEPCION = 
        "irCertificadoAsistenciaControlAnticoncepcion";

    String RUTA_IR_CERTIFICADOMEDICO_CONTROL_ANTICONCEPCION = 
        "irCertificadoMedicoControlAnticoncepcion";

    String RUTA_IR_ELECTROFISIOLOGICO_CONTROL_ANTICONCEPCION = 
        "irExamenElectrofisiologicosControlAnticoncepcion";

    String RUTA_IR_IMAGENES_CONTROL_ANTICONCEPCION = 
        "irExamenImagenesControlAnticoncepcion";

    String RUTA_IR_LABORATORIO_CONTROL_ANTICONCEPCION = 
        "irExamenLaboratorioControlAnticoncepcion";

    String RUTA_IR_RECOMENDACIONES_CONTROL_ANTICONCEPCION = 
        "irRecomendacionesControlAnticoncepcion";

    String RUTA_IR_REFERENCIA_CONTROL_ANTICONCEPCION = 
        "irReferenciaControlAnticoncepcion";

    String RUTA_IR_RESERVA_SANGRE_CONTROL_ANTICONCEPCION = 
        "irReservaSangreControlAnticoncepcion";

    String RUTA_IR_METODO_PLANIFICACION_CONTROL_ANTICONCEPCION = 
        "irMetodoPlanificacionControlAnticoncepcion";

    String RUTA_IR_CERRAR_CONSULTA_CONTROL_ANTICONCEPCION = 
        "irCerrarConsultaControlAnticoncepcion";

    String RUTA_IR_RESUMEN_HISTORIA_ESPECIFICA_CONTROL_ANTICONCEPCION = 
        "irResumenHistoriaEspecificaControlAnticoncepcion";

    String RUTA_IR_RESUMEN_HISTORIA_CONTROL_ANTICONCEPCION = 
        "irResumenHistoriaControlAnticoncepcion";


    String RUTA_IR_DATOS_CITOPUNCION = "irDatosCitopuncion";

    String RUTA_IR_INFORME_CITOPUNCION = "irInformeCitopuncion";

    String RUTA_IR_CERRAR_CITOPUNCION = "irCerrarCitopuncion";

    String RUTA_IR_RESUMEN_HISTORIA_ESPECIFICA_CITOPUNCION = 
        "irResumenHistoriaEspecificaCitopuncion";

    String RUTA_IR_RESUMEN_HISTORIA_CITOPUNCION = 
        "irResumenHistoriaCitopuncion";

    String RUTA_IR_DATOS_ECOGRAFIA = "irDatosEcografia";

    String RUTA_IR_INFORME_ECOGRAFIA = "irInformeEcografia";
    
    String RUTA_IR_CUESTIONARIO_COVID_ECOGRAFIA = "irCuestionarioCovidEcografia"; 


    String RUTA_IR_CARGA_IMAGEN = "irCargarImagen";

    String RUTA_IR_CERRAR_ECOGRAFIA = "irCerrarEcografia";

    String RUTA_IR_RESUMEN_HISTORIA_ESPECIFICA_ECOGRAFIA = 
        "irResumenHistoriaEspecificaEcografia";

    String RUTA_IR_RESUMEN_HISTORIA_ECOGRAFIA = "irResumenHistoriaEcografia";

    String RUTA_IR_DATOS_HISTEROSONOGRAFIA = "irDatosHisterosonografia";

    String RUTA_IR_INFORME_HISTEROSONOGRAFIA = "irInformeHisterosonografia";
    
    String RUTA_IR_CUESTIONARIO_COVID_HISTEROSONOGRAFIA = "irCuestionarioCovidHisterosonografia"; 

    String RUTA_IR_CERRAR_HISTEROSONOGRAFIA = "irCerrarHisterosonografia";

    String RUTA_IR_RESUMEN_HISTORIA_ESPECIFICA_HISTEROSONOGRAFIA = 
        "irResumenHistoriaEspecificaHisterosonografia";

    String RUTA_IR_RESUMEN_HISTORIA_HISTEROSONOGRAFIA = 
        "irResumenHistoriaHisterosonografia";

    String RUTA_IR_DATOS_MAMOGRAFIA = "irDatosMamografia";


    String RUTA_IR_CERRAR_MAMOGRAFIA = "irCerrarMamografia";

    String RUTA_IR_RESUMEN_HISTORIA_ESPECIFICA_MAMOGRAFIA = 
        "irResumenHistoriaEspecificaMamografia";

    String RUTA_IR_RESUMEN_HISTORIA_MAMOGRAFIA = "irResumenHistoriaMamografia";

    String RUTA_IR_DATOS_MARCACION_SENO = "irDatosMarcacionSeno";


    String RUTA_IR_CERRAR_MARCACION_SENO = "irCerrarMarcacionSeno";

    String RUTA_IR_RESUMEN_HISTORIA_ESPECIFICA_MARCACION = 
        "irResumenHistoriaEspecificaMarcacion";

    String RUTA_IR_RESUMEN_HISTORIA_MARCACION = "irResumenHistoriaMarcacion";

    String RUTA_IR_DATOS_CITOLOGIA = "irDatosCitologia";
    
    String RUTA_IR_DATOS_VPH = "irDatosVph";


    String RUTA_IR_CERRAR_CITOLOGIA = "irCerrarCitologia";


    // HISTORIA PREANESTESIA


    String RUTA_IR_DATOS_PREANESTESIA = "irDatosPreanestesia";

    String RUTA_IR_MOTIVO_PREANESTESIA = "irMotivoPreanestesia";
    
    String RUTA_IR_CUESTIONARIO_COVID_PREANESTESIA = "irCuestionarioCovidPreanestesia"; 

    String RUTA_IR_VALORACION_PREANESTESIA = "irValoracionPreanestesia";

    String RUTA_IR_CUESTIONARIO_PREANESTESIA = "irCuestionarioPreanestesia";

    String RUTA_IR_RESULTADOS_PREANESTESIA = "irResultadosPreanestesia";

    String RUTA_IR_INTERCONSULTA_PREANESTESIA = "irInterConsultaPreanestesia";

    String RUTA_IR_EXAMEN_PREANESTESIA = "irExamenPreanestesia";

    String RUTA_IR_EXAMEN_FISICO_PREANESTESIA = "irExamenFisicoPreanestesia";

    String RUTA_IR_ORDENCIRUGIA_PREANESTESIA = "irOrdenCirugiaPreanestesia";

    String RUTA_IR_ORDENLIQUIDOS_PREANESTESIA = "irOrdenLiquidosPreanestesia";
    
    String RUTA_IR_OTRAS_ORDENES_PREANESTESIA = "irOtrasOrdenesPreanestesia"; 

    String RUTA_IR_ORDENMEDICAMENTOS_PREANESTESIA = 
        "irOrdenMedicamentosPreanestesia";

    String RUTA_IR_INCAPACIDAD_PREANESTESIA = "irIncapacidadPreanestesia";

    String RUTA_IR_HOSPITALZACION_PREANESTESIA = 
        "irRemHospitalizacionPreanestesia";

    String RUTA_IR_FORMULAMEDICA_PREANESTESIA = "irFormulaMedicaPreanestesia";

    String RUTA_IR_VADEMCUM_PREANESTESIA = "irVademecumPreanestesia";


    String RUTA_IR_CONTOLSINCOSTO_PREANESTESIA = 
        "irControlSinCostoPreanestesia";

    String RUTA_IR_ANATOMIAPATOLOGICA_PREANESTESIA = 
        "irAnatPatologicaPreanestesia";

    String RUTA_IR_IMPRESION_DIAGNOSTICA_PREANESTESIA = 
        "irImpDiagnosticaPreanestesia";

    String RUTA_IR_CERTIFICADO_ASISTENCIA_PREANESTESIA = 
        "irCertificadoAsistenciaPreanestesia";

    String RUTA_IR_CERTIFICADOMEDICO_PREANESTESIA = 
        "irCertificadoMedicoPreanestesia";

    String RUTA_IR_ELECTROFISIOLOGICO_PREANESTESIA = 
        "irExamenElectrofisiologicosPreanestesia";

    String RUTA_IR_IMAGENES_PREANESTESIA = "irExamenImagenesPreanestesia";

    String RUTA_IR_LABORATORIO_PREANESTESIA = 
        "irExamenLaboratorioPreanestesia";

    String RUTA_IR_RECOMENDACIONES_PREANESTESIA = 
        "irRecomendacionesPreanestesia";

    String RUTA_IR_REFERENCIA_PREANESTESIA = "irReferenciaPreanestesia";

    String RUTA_IR_AUTORIZACION_SERVICIO_PREANESTESIA = 
        "irAutorizacionServicioPreanestesia";

    String RUTA_IR_RESERVA_SANGRE_PREANESTESIA = "irReservaSangrePreanestesia";

    String RUTA_IR_CERRAR_PREANESTESIA = "irCerrarConsultaPreanestesia";

    String RUTA_IR_RESUMEN_HISTORIA_ESPECIFICA_PREANTESTESIA = 
        "irResumenHistoriaEspecificaPreanestesia";

    String RUTA_IR_RESUMEN_HISTORIA_PREANTESTESIA = 
        "irResumenHistoriaPreanestesia";

    // HISTORIA CONTROL PREANESTESIA

    String RUTA_IR_DATOS_CONTROL_PREANESTESIA = "irDatosControlPreanestesia";

    String RUTA_IR_MOTIVO_CONTROL_PREANESTESIA = "irMotivoControlPreanestesia";
    
    String RUTA_IR_CUESTIONARIO_COVID_CONTROL_PREANESTESIA = "irCuestionarioCovidControlPreanestesia";

    String RUTA_IR_CONTROL_PREANESTESIA = "irControlPreanestesia";

    String RUTA_IR_VALORACION_CONTROL_PREANESTESIA = 
        "irValoracionControlPreanestesia";

    String RUTA_IR_CUESTIONARIO_CONTROL_PREANESTESIA = 
        "irCuestionarioControlPreanestesia";

    String RUTA_IR_RESULTADOS_CONTROL_PREANESTESIA = 
        "irResultadosControlPreanestesia";

    String RUTA_IR_INTERCONSULTA_CONTROL_PREANESTESIA = 
        "irInterConsultaControlPreanestesia";

    String RUTA_IR_EXAMEN_CONTROL_PREANESTESIA = "irExamenControlPreanestesia";

    String RUTA_IR_EXAMEN_FISICO_CONTROL_PREANESTESIA = 
        "irExamenFisicoControlPreanestesia";


    String RUTA_IR_ORDENCIRUGIA_CONTROL_PREANESTESIA = 
        "irOrdenCirugiaControlPreanestesia";

    String RUTA_IR_ORDENLIQUIDOS__CONTROL_PREANESTESIA = 
        "irOrdenLiquidosControlPreanestesia";
        
    String RUTA_IR_OTRAS_ORDENES_CONTROL_PREANESTESIA = "irOtrasOrdenesControlPreanestesia"; 

    String RUTA_IR_ORDENMEDICAMENTOS_CONTROL_PREANESTESIA = 
        "irOrdenMedicamentosControlPreanestesia";

    String RUTA_IR_INCAPACIDAD_CONTROL_PREANESTESIA = 
        "irIncapacidadControlPreanestesia";

    String RUTA_IR_HOSPITALZACION_CONTROL_PREANESTESIA = 
        "irRemHospitalizacionControlPreanestesia";

    String RUTA_IR_FORMULAMEDICA_CONTROL_PREANESTESIA = 
        "irFormulaMedicaControlPreanestesia";

    String RUTA_IR_VADEMCUM_CONTROL_PREANESTESIA = 
        "irVademecumControlPreanestesia";


    String RUTA_IR_CONTOLSINCOSTO_CONTROL_PREANESTESIA = 
        "irControlSinCostoControlPreanestesia";

    String RUTA_IR_ANATOMIAPATOLOGICA_CONTROL_PREANESTESIA = 
        "irAnatPatologicaControlPreanestesia";

    String RUTA_IR_IMPRESION_DIAGNOSTICA_CONTROL_PREANESTESIA = 
        "irImpDiagnosticaControlPreanestesia";

    String RUTA_IR_CERTIFICADO_ASISTENCIA_CONTROL_PREANESTESIA = 
        "irCertificadoAsistenciaControlPreanestesia";

    String RUTA_IR_CERTIFICADOMEDICO_CONTROL_PREANESTESIA = 
        "irCertificadoMedicoControlPreanestesia";

    String RUTA_IR_ELECTROFISIOLOGICO_CONTROL_PREANESTESIA = 
        "irExamenElectrofisiologicosControlPreanestesia";

    String RUTA_IR_IMAGENES_CONTROL_PREANESTESIA = 
        "irExamenImagenesControlPreanestesia";

    String RUTA_IR_LABORATORIO_CONTROL_PREANESTESIA = 
        "irExamenLaboratorioControlPreanestesia";

    String RUTA_IR_RECOMENDACIONES_CONTROL_PREANESTESIA = 
        "irRecomendacionesControlPreanestesia";

    String RUTA_IR_REFERENCIA_CONTROL_PREANESTESIA = 
        "irReferenciaControlPreanestesia";

    String RUTA_IR_RESERVA_SANGRE_CONTROL_PREANESTESIA = 
        "irReservaSangreControlPreanestesia";

    String RUTA_IR_CERRAR_CONTROL_PREANESTESIA = 
        "irCerrarConsultaControlPreanestesia";

    String RUTA_IR_RESUMEN_HISTORIA_ESPECIFICA_CONTROL_PREANTESTESIA = 
        "irResumenHistoriaEspecificaControlPreanestesia";

    String RUTA_IR_RESUMEN_HISTORIA_CONTROL_PREANTESTESIA = 
        "irResumenHistoriaControlPreanestesia";

    String RUTA_IR_INFORME_MAMOGRAFIA = "irInformeMamografia";
    
    String RUTA_IR_CUESTIONARIO_COVID_MAMOGRAFIA = "irCuestionarioCovidMamografia"; 

    String RUTA_IR_INFORME_MARCACION_SENO = "irInformeMarcacionSeno";
    
    String RUTA_IR_CUESTIONARIO_COVID_MARCACION_SENO = "irCuestionarioCovidMarcacionSeno"; 


    String RUTA_IR_ADMINISTRAR_PLANTILLAS = "irAdministrarPlantillas";

    String RUTA_IR_MODIFICAR_PLANTILLAS = "irModificarPlantillas";

    String RUTA_IR_CONSULTAR_PROGRAMACION = "irConsultarProgramacion";

    String RUTA_IR_REPORTE_PROGRAMACION = "irReporteProgramacion";

    String RUTA_IR_REPORTE_HONORARIOS_CIRUGIA = "irReporteHonorariosCirugia";


    //FIXME ENFERMERIA NUEVO

    String RUTA_IR_INGRESO_ENFERMERIA = "irIngresoEnfermeria";

    String RUTA_IR_INGRESO_MEDICAMENTOS = "irIngresosMedicamentos";

    String RUTA_IR_INGRESO_SIGNOS_VITALES = "irIngresosSignosVitales";

    String RUTA_IR_NOTA_ENFERMERIA_INGRESO = "irNotaEnfermeriaIngreso";

    String RUTA_IR_LIQUIDOS_INGRESO_ENFERMERIA = "irLiquidosIngresoEnfermeria";

    String RUTA_IR_CONSULTAR_NOTAS_ENFERMERIA = "irConsultarNotasEnfermeria";

    String RUTA_IR_SALIDA_ENFERMERIA = "irRegistrarSalidaEnfermeria";
    
    String RUTA_IR_RESUMEN_HISTORIA_ENFERMERIA =   "irResumenCirugiaEnfermeria";
    
    String RUTA_IR_CUESTIONARIO_COVID_INGRESO_ENFERMERIA = "irCuestionarioCovidIngresoEnfermeria";


    //FIXME INGRESO MEDICO NUEVO

    String RUTA_IR_INGRESO_MEDICO = "irIngresoMedicoUsuario";

    String RUTA_IR_EXAMEN_FISICO_INGRESO_MEDICO = 
        "irExamenFisicoIngresoMedico";

    String RUTA_IR_INTERCONSULTA_INGRESO_MEDICO = 
        "irInterConsultaIngresoMedico";

    String RUTA_IR_ORDEN_CIRUGIA_INGRESO_MEDICO = 
        "irOrdenCirugiaIngresoMedico";

    String RUTA_IR_INCAPACIDAD_INGRESO_MEDICO = "irIncapacidadIngresoMedico";

    String RUTA_IR_HOSPITALIZACION_INGRESO_MEDICO = 
        "irRemHospitalizacionIngresoMedico";

    String RUTA_IR_FORMULA_MEDICA_INGRESO_MEDICO = 
        "irFormulaMedicaIngresoMedico";

    String RUTA_IR_CONTROL_SIN_COSTO_INGRESO_MEDICO = 
        "irControlSinCostoIngresoMedico";

    String RUTA_IR_ANATOMIA_PATOLOGICA_INGRESO_MEDICO = 
        "irAnatPatologicaIngresoMedico";

    String RUTA_IR_IMPRESION_DIAGNOSTICA_INGRESO_MEDICO = 
        "irImpDiagnosticaIngresoMedico";

    String RUTA_IR_CERTIFICADO_ASISTENCIA_INGRESO_MEDICO = 
        "irCertificadoAsistenciaIngresoMedico";

    String RUTA_IR_CERTIFICADO_MEDICO_INGRESO_MEDICO = 
        "irCertificadoMedicoIngresoMedico";

    String RUTA_IR_EXAMEN_ELECTROFISIOLOGICO_INGRESO_MEDICO = 
        "irExamenElectrofisiologicosIngresoMedico";

    String RUTA_IR_EXAMEN_IMAGENES_INGRESO_MEDICO = 
        "irExamenImagenesIngresoMedico";

    String RUTA_IR_EXAMEN_LABORATORIOS_INGRESO_MEDICO = 
        "irExamenLaboratorioIngresoMedico";

    String RUTA_IR_RECOMENDACIONES_INGRESO_MEDICO = 
        "irRecomendacionesIngresoMedico";

    String RUTA_IR_REFERENCIA_INGRESO_MEDICO = "irReferenciaIngresoMedico";

    String RUTA_IR_RESERVA_SANGRE_INGRESO_MEDICO = 
        "irReservaSangreIngresoMedico";

    String RUTA_IR_CERRAR_CONSULTA_INGRESO_MEDICO = 
        "irCerrarConsultaIngresoMedico";

    String RUTA_IR_RESUMEN_HISTORIA_INGRESO_MEDICO = 
        "irResumenHistoriaEspecificaIngresoMedico";

    String RUTA_IR_FORMULA_LIQUIDOS_INGRESO_MEDICO = 
        "irFormulaLiquidosIngresoMedico";

    String RUTA_IR_FORMULA_HOSPITALIZACION_INGRESO_MEDICO = 
        "irFormulaHospitalizacionIngresoMedico";

    String RUTA_IR_MEDIDAS_APOYO_INGRESO_MEDICO = 
        "irMedidasApoyoIngresoMedico";

    String RUTA_IR_FORMULA_ESPECIALES_INGRESO_MEDICO = 
        "irFormulaEspecialesIngresoMedico";


    //FIXME EVOLUCION MEDICO NUEVO

    String RUTA_IR_OTRAS_ORDENES = "irRegistrarOtrasOrdenes";
    String RUTA_IR_EVOLUCION_MEDICO = "irEvolucionMedicoUsuario";
    String RUTA_IR_EXAMEN_FISICO_EVOLUCION_MEDICO = 
        "irExamenFisicoEvolucionMedico";
    String RUTA_IR_INTERCONSULTA_EVOLUCION_MEDICO = 
        "irInterConsultaEvolucionMedico";
    String RUTA_IR_ORDEN_CIRUGIA_EVOLUCION_MEDICO = 
        "irOrdenCirugiaEvolucionMedico";
    String RUTA_IR_INCAPACIDAD_EVOLUCION_MEDICO = 
        "irIncapacidadEvolucionMedico";
    String RUTA_IR_HOSPITALIZACION_EVOLUCION_MEDICO = 
        "irRemHospitalizacionEvolucionMedico";
    String RUTA_IR_FORMULA_MEDICA_EVOLUCION_MEDICO = 
        "irFormulaMedicaEvolucionMedico";
    String RUTA_IR_CONTROL_SIN_COSTO_EVOLUCION_MEDICO = 
        "irControlSinCostoEvolucionMedico";
    String RUTA_IR_ANATOMIA_PATOLOGICA_EVOLUCION_MEDICO = 
        "irAnatPatologicaEvolucionMedico";
    String RUTA_IR_IMPRESION_DIAGNOSTICA_EVOLUCION_MEDICO = 
        "irImpDiagnosticaEvolucionMedico";
    String RUTA_IR_CERTIFICADO_ASISTENCIA_EVOLUCION_MEDICO = 
        "irCertificadoAsistenciaEvolucionMedico";
    String RUTA_IR_CERTIFICADO_MEDICO_EVOLUCION_MEDICO = 
        "irCertificadoMedicoEvolucionMedico";
    String RUTA_IR_EXAMEN_ELECTROFISIOLOGICO_EVOLUCION_MEDICO = 
        "irExamenElectrofisiologicosEvolucionMedico";
    String RUTA_IR_EXAMEN_IMAGENES_EVOLUCION_MEDICO = 
        "irExamenImagenesEvolucionMedico";
    String RUTA_IR_EXAMEN_LABORATORIOS_EVOLUCION_MEDICO = 
        "irExamenLaboratorioEvolucionMedico";
    String RUTA_IR_RECOMENDACIONES_EVOLUCION_MEDICO = 
        "irRecomendacionesEvolucionMedico";
    String RUTA_IR_REFERENCIA_EVOLUCION_MEDICO = "irReferenciaEvolucionMedico";
    String RUTA_IR_RESERVA_SANGRE_EVOLUCION_MEDICO = 
        "irReservaSangreEvolucionMedico";
    String RUTA_IR_CERRAR_CONSULTA_EVOLUCION_MEDICO = 
        "irCerrarConsultaEvolucionMedico";
    String RUTA_IR_RESUMEN_HISTORIA_EVOLUCION_MEDICO = 
        "irResumenHistoriaEspecificaEvolucionMedico";
    String RUTA_IR_FORMULA_LIQUIDOS_EVOLUCION_MEDICO = 
        "irFormulaLiquidosEvolucionMedico";
    String RUTA_IR_FORMULA_HOSPITALIZACION_EVOLUCION_MEDICO = 
        "irFormulaHospitalizacionEvolucionMedico";

    String RUTA_IR_FORMULA_LIQUIDOS_DESCRIPCION_MEDICO = 
        "irFormulaLiquidosDescripcionMedico";
    String RUTA_IR_FORMULA_HOSPITALIZACION_DESCRIPCION_MEDICO = 
        "irFormulaHospitalizacionDescripcionMedico";

    String RUTA_IR_OTRAS_ORDENES_DESCRIPCION_MEDICO = 
        "irOtrasOrdenesDescripcionMedico";

    String RUTA_IR_MEDIDAS_APOYO_EVOLUCION_MEDICO = 
        "irMedidasApoyoEvolucionMedico";
        
    String RUTA_IR_AUTORIZACION_SERVICIOS_EVOLUCION_MEDICO = 
        "irAutorizacionServiciosEvolucionMedico";
        
    String RUTA_IR_FORMULA_ESPECIALES_EVOLUCION_MEDICO = 
        "irFormulaEspecialesEvolucionMedico";
    String RUTA_IR_GESTION_PRIORIDAD = "irGestionPrioridad";
    String RUTA_IR_GESTION_SERVICIOS = "irGestionServicios";

    //FIXME HISTORIA PSICOLOGIA


    String RUTA_IR_DATOS_PSICOLOGIA = "irDatosPsicologia";
    String RUTA_IR_MOTIVO_PSICOLOGIA = "irMotivoPsicologia";
    String RUTA_IR_CUESTIONARIO_COVID_PSICOLOGIA = "irCuestionarioCovidPsicologia"; 
    String RUTA_IR_VIOLENCIA_SIVIGILA_PSICOLOGIA = "irViolenciaSivigilaPsicologia";
    String RUTA_IR_INTERCONSULTA_PSICOLOGIA = "irInterConsultaPsicologia";
    String RUTA_IR_CONTOLSINCOSTO_PSICOLOGIA = "irControlSinCostoPsicologia";
    String RUTA_IR_IMPRESION_DIAGNOSTICA_PSICOLOGIA = 
        "irImpDiagnosticaPsicologia";
    String RUTA_IR_EVALUACION_GENERAL_PSICOLOGIA = "irEvaluacionPsicologica";
    String RUTA_IR_PLAN_TRATAMIENTO_PSICOLOGIA = "irPlanTratamientoPsicologia";
    String RUTA_IR_ANTECEDENTES_PSICOLOGIA = "irAntecedentesPsicologia";
    String RUTA_IR_ANTECEDENTES_GENERALES_PSICOLOGIA = 
        "irAntecedentesGeneralesPsicologia";
    String RUTA_IR_CERTIFICADO_ASISTENCIA_PSICOLOGIA = 
        "irCertificadoAsistenciaPsicologia";
    String RUTA_IR_CERTIFICADOMEDICO_PSICOLOGIA = 
        "irCertificadoMedicoPsicologia";
    String RUTA_IR_RECOMENDACIONES_PSICOLOGIA = "irRecomendacionesPsicologia";
    String RUTA_IR_CERRAR_PSICOLOGIA = "irCerrarConsultaPsicologia";
    String RUTA_IR_RESUMEN_HISTORIA_PSICOLOGIA = "irResumenHistoriaPsicologia";
    String RUTA_IR_CERTIFICADO_PSICOLOGIA = "irConsultaCertificadoPsicologia";
    String RUTA_IR_REFERENCIA_PSICOLOGIA = 
        "irReferenciaPsicologia";
    String RUTA_IR_ENCUESTA_VIOLENCIA_PSICOLOGICA =  "irEncuestaViolenciaPsicologica";


    //FIXME HISTORIA PSICOLOGIA SEGUIMIENTO

    String RUTA_IR_DATOS_PSICOLOGIA_CONTROL = "irDatosPsicologiaControl";
    String RUTA_IR_MOTIVO_PSICOLOGIA_CONTROL = "irMotivoPsicologiaControl";
    String RUTA_IR_CUESTIONARIO_COVID_PSICOLOGIA_CONTROL = "irCuestionarioCovidPsicologiaControl"; 
    
    String RUTA_IR_INTERCONSULTA_PSICOLOGIA_CONTROL = 
        "irInterConsultaPsicologiaControl";
    String RUTA_IR_CONTOLSINCOSTO_PSICOLOGIA_CONTROL = 
        "irControlSinCostoPsicologiaControl";
    String RUTA_IR_IMPRESION_DIAGNOSTICA_PSICOLOGIA_CONTROL = 
        "irImpDiagnosticaPsicologiaControl";
    String RUTA_IR_EVALUACION_GENERAL_PSICOLOGIA_CONTROL = 
        "irEvaluacionPsicologicaControl";
    String RUTA_IR_SEGUIMIENTO_PSICOLOGIA = "irSeguimientoPsicologia";
    String RUTA_IR_PLAN_TRATAMIENTO_PSICOLOGIA_CONTROL = 
        "irPlanTratamientoPsicologiaControl";
    String RUTA_IR_CERTIFICADO_ASISTENCIA_PSICOLOGIA_CONTROL = 
        "irCertificadoAsistenciaPsicologiaControl";
    String RUTA_IR_CERTIFICADOMEDICO_PSICOLOGIA_CONTROL = 
        "irCertificadoMedicoPsicologiaControl";
    String RUTA_IR_RECOMENDACIONES_PSICOLOGIA_CONTROL = 
        "irRecomendacionesPsicologiaControl";
    String RUTA_IR_CERRAR_PSICOLOGIA_CONTROL = 
        "irCerrarConsultaControlPsicologia";
    String RUTA_IR_RESUMEN_PSICOLOGIA_CONTROL = 
        "irResumenHistoriaControlPsicologia";

    String RUTA_IR_CERTIFICADO_PSICOLOGIA_CONTROL = 
        "irConsultaCertificadoControlPsicologia";


    String RUTA_IR_RESUMEN_CONTROL_PSICOLOGIA = "irResumenHistoriaCervix";


    // TODO: HISTORIA CERVIX

    String RUTA_IR_DATOS_CERVIX = "irDatosCervix";
    String RUTA_IR_CUESTIONARIO_CERVIX = "irCuestionarioCervix";
    String RUTA_IR_CUESTIONARIO_COVID_CERVIX = "irCuestionarioCovidCervix";
    
    String RUTA_IR_MOTIVO_CERVIX = "irMotivoCervix";
    String RUTA_IR_ANTECEDENTES_GENERALES_CERVIX = 
        "irAntecedentesGeneralesCervix";
    String RUTA_IR_ANTECEDENTES_CERVIX = "irAntecedentesCervix";
    String RUTA_IR_ANTECEDENTES_GINECOLOGICOS_CERVIX = 
        "irAntecedentesGinecologicosCervix";
    String RUTA_IR_EXAMENFISICO_CERVIX = "irExamenFisicoCervix";
    String RUTA_IR_ENCUESTA_VIOLENCIA_CERVIX = "irEncuestaViolenciaCervix";
    String RUTA_IR_IMPRESION_DIAGNOSTICA_CERVIX = "irImpDiagnosticaCervix";
    String RUTA_IR_ANATOMIAPATOLOGICA_CERVIX = "irAnatPatologicaCervix";
    String RUTA_IR_CONTOLSINCOSTO_CERVIX = "irControlSinCostoCervix";
    String RUTA_IR_FORMULAMEDICA_CERVIX = "irFormulaMedicaCervix";
    String RUTA_IR_VADEMCUM_CERVIX = "irVademecumCervix";
    String RUTA_IR_HOSPITALZACION_CERVIX = "irRemHospitalizacionCervix";
    String RUTA_IR_INCAPACIDAD_CERVIX = "irIncapacidadCervix";
    String RUTA_IR_INTERCONSULTA_CERVIX = "irInterConsultaCervix";
    String RUTA_IR_ORDENCIRUGIA_CERVIX = "irOrdenCirugiaCervix";
    String RUTA_IR_REFERENCIA_CERVIX = "irReferenciaCervix";
    String RUTA_IR_AUTORIZACION_CERVIX = "irAutorizacionServicioCervix";
    String RUTA_IR_RESERVA_SANGRE_CERVIX = "irReservaSangreCervix";
    String RUTA_IR_RECOMENDACIONES_CERVIX = "irRecomendacionesCervix";
    String RUTA_IR_CERTIFICADOMEDICO_CERVIX = "irCertificadoMedicoCervix";
    String RUTA_IR_CERTIFICADO_ASISTENCIA_CERVIX = 
        "irCertificadoAsistenciaCervix";
    String RUTA_IR_ELECTROFISIOLOGICO_CERVIX = 
        "irExamenElectrofisiologicosCervix";
    String RUTA_IR_IMAGENES_CERVIX = "irExamenImagenesCervix";
    String RUTA_IR_LABORATORIO_CERVIX = "irExamenLaboratorioCervix";
    String RUTA_IR_CERRAR_CONSULTA_CERVIX = "irCerrarConsultaCervix";
    String RUTA_IR_RESUMEN_HISTORIA_ESPECIFICA_CERVIX = 
        "irResumenHistoriaEspecificaCervix";
    String RUTA_IR_RESUMEN_HISTORIA_CERVIX = "irResumenHistoriaCervix";

    // FIXME VACUNACION CERVIX

    String RUTA_IR_LISTA_VACUNACION = "irListaVacunacion";


    String RUTA_IR_DATOS_VACUNACION_CERVIX = "irDatosCervixVacunacion";
    String RUTA_IR_CERRAR_CONSULTA_VACUNACION_CERVIX = 
        "irCerrarConsultaCervixVacunacion";
    String RUTA_IR_VACUNACION_CERVIX = "irAplicacionCervixVacunacion";


    // FIXME VACUNACION ESPERMOGRAMA

    String RUTA_IR_LISTA_ESPERMOGRAMA = "irListaEspermograma";
    String RUTA_IR_ESPERMOGRAMA = "irAplicacionEspermograma";
    String RUTA_IR_CERRAR_ESPERMOGRAMA = "irCerrarEspermograma";
    String RUTA_IR_CONTROL_VASECTOMIA = "irControlVasectomia";
    String RUTA_IR_DATOS_ESPERMOGRAMA = "irDatosEspermograma";
    String RUTA_IR_CERRAR_CONSULTA_ESPERMOGRAMA = "irCerrarConsultaEspermograma";


    // FIXME VACUNACION NORMAL


    String RUTA_IR_DATOS_VACUNACION_NORMAL = "irDatosVacunacion";
    String RUTA_IR_CERRAR_CONSULTA_VACUNACION_NORMAL = 
        "irCerrarConsultaVacunacion";
    String RUTA_IR_VACUNACION_NORMAL = "irAplicacionVacunacion";


    // FIXME ESTERILIZACION MASCULINA
    String RUTA_IR_MOTIVO_ESTERILIZACION_MASCULINA = "irMotivoEsterilizacionMasculina";
    
    String RUTA_IR_CUESTIONARIO_COVID_ESTERILIZACION_MASCULINA = "irCuestionarioCovidEsterilizacionMasculina";

    String RUTA_IR_DATOS_ESTERILIZACION_MASCULINA = 
        "irDatosEsterilizacionMasculina";

    String RUTA_IR_INTERCONSULTA_ESTERILIZACION_MASCULINA = 
        "irInterConsultaEsterilizacionMasculina";

    String RUTA_IR_ORDENCIRUGIA_ESTERILIZACION_MASCULINA = 
        "irOrdenCirugiaEsterilizacionMasculina";

    String RUTA_IR_INCAPACIDAD_ESTERILIZACION_MASCULINA = 
        "irIncapacidadEsterilizacionMasculina";

    String RUTA_IR_HOSPITALZACION_ESTERILIZACION_MASCULINA = 
        "irRemHospitalizacionEsterilizacionMasculina";

    String RUTA_IR_FORMULAMEDICA_ESTERILIZACION_MASCULINA = 
        "irFormulaMedicaEsterilizacionMasculina";


    String RUTA_IR_VADEMCUM_ESTERILIZACION_MASCULINA = 
        "irVademecumEsterilizacionMasculina";


    String RUTA_IR_CONTOLSINCOSTO_ESTERILIZACION_MASCULINA = 
        "irControlSinCostoEsterilizacionMasculina";

    String RUTA_IR_ANATOMIAPATOLOGICA_ESTERILIZACION_MASCULINA = 
        "irAnatPatologicaEsterilizacionMasculina";

    String RUTA_IR_IMPRESION_DIAGNOSTICA_ESTERILIZACION_MASCULINA = 
        "irImpDiagnosticaEsterilizacionMasculina";

    String RUTA_IR_ENCUESTA_VIOLENCIA_ESTERILIZACION_MASCULINA = 
        "irEncuestaViolenciaEsterilizacionMasculina";

    String RUTA_IR_EXAMENFISICO_ESTERILIZACION_MASCULINA = 
        "irExamenFisicoEsterilizacionMasculina";

    String RUTA_IR_ANTECEDENTES_ESTERILIZACION_MASCULINA = 
        "irAntecedentesEsterilizacionMasculina";

    String RUTA_IR_OTROS_ANTECEDENTES_ESTERILIZACION = 
        "irOtrosAntecedentesEsterilizacionMasculina";

    String RUTA_IR_ANTECEDENTES_GENERALES_ESTERILIZACION_MASCULINA = 
        "irAntecedentesGeneralesEsterilizacionMasculina";


    String RUTA_IR_CERTIFICADO_ASISTENCIA_ESTERILIZACION_MASCULINA = 
        "irCertificadoAsistenciaEsterilizacionMasculina";

    String RUTA_IR_CERTIFICADOMEDICO_ESTERILIZACION_MASCULINA = 
        "irCertificadoMedicoEsterilizacionMasculina";

    String RUTA_IR_ELECTROFISIOLOGICO_ESTERILIZACION_MASCULINA = 
        "irExamenElectrofisiologicosEsterilizacionMasculina";

    String RUTA_IR_IMAGENES_ESTERILIZACION_MASCULINA = 
        "irExamenImagenesEsterilizacionMasculina";

    String RUTA_IR_LABORATORIO_ESTERILIZACION_MASCULINA = 
        "irExamenLaboratorioEsterilizacionMasculina";

    String RUTA_IR_RECOMENDACIONES_ESTERILIZACION_MASCULINA = 
        "irRecomendacionesEsterilizacionMasculina";

    String RUTA_IR_REFERENCIA_ESTERILIZACION_MASCULINA = 
        "irReferenciaEsterilizacionMasculina";

    String RUTA_IR_AUTORIZACION_SERVICIO_ESTERILIZACION_MASCULINA = 
        "irAutorizacionServicioEsterilizacionMasculina";

    String RUTA_IR_RESERVA_SANGRE_ESTERILIZACION_MASCULINA = 
        "irReservaSangreEsterilizacionMasculina";

    String RUTA_IR_CERRAR_CONSULTA_ESTERILIZACION_MASCULINA = 
        "irCerrarConsultaEsterilizacionMasculina";

    String RUTA_IR_RESUMEN_HISTORIA_ESPECIFICA_ESTERILIZACION_MASCULINA = 
        "irResumenHistoriaEspecificaEsterilizacionMasculina";

    String RUTA_IR_RESUMEN_HISTORIA_ESTERILIZACION_MASCULINA = 
        "irResumenHistoriaEsterilizacionMasculina";

    String RUTA_IR_METODO_ANTICONCEPTIVO_ESTERILIZACION_MASCULINA = 
        "irMetodoAntconceptivoEsterilizacionMasculina";

    String RUTA_IR_CUESTIONARIO_ESTERILIZACION_MASCULINA = 
        "irCuestionarioEsterilizacionMasculina";
    
    String RUTA_IR_OTRAS_ORDENES_ESTERILIZACION_MASCULINA = "irOtrasOrdenesEsterilizacionMasculina";    

    // TODO: ADMININISTRACION CLINICAS

    String RUTA_IR_ADMINISTRAR_CLINICA = "irAdministrarClinicaUsuario";

    String RUTA_IR_LIBERAR_CONSULTAS = "irLiberarConsultas";

    String RUTA_IR_SOLICITAR_ANULACION = "irRutaSolicitarAnulacion";

    String RUTA_IR_AUTORIZAR_ANULACION = "irRutaAutorizarAnulacion";

    String RUTA_IR_IMPRIMIR_FOLIOS = "irImprimirFolios";

    String RUTA_IR_ASIGNAR_SALA_MEDICO = "irAsignarSalaMedico";

    String RUTA_IR_IMPRIMIR_HISTORIAS = "irImprimirHistorias";

    // TODO: HISTORIA INTERRUPCION 

    String RUTA_IR_PSICOEMOCIONAL_INTERRUPCION = 
        "irPsicoemocionalInterrupcion";

    String RUTA_IR_INTERRUPCION_ILVE = "irInterrupcionIlve";

    String RUTA_IR_MOTIVO_INTERRUPCION = "irMotivoInterrupcion";
    
    String RUTA_IR_CUESTIONARIO_INTERRUPCION = "irCuestionarioCovidInterrupcion";

    String RUTA_IR_DATOS_INTERRUPCION = "irDatosInterrupcion";

    String RUTA_IR_INTERCONSULTA_INTERRUPCION = "irInterConsultaInterrupcion";

    String RUTA_IR_ORDENCIRUGIA_INTERRUPCION = "irOrdenCirugiaInterrupcion";

    String RUTA_IR_INCAPACIDAD_INTERRUPCION = "irIncapacidadInterrupcion";

    String RUTA_IR_HOSPITALZACION_INTERRUPCION = 
        "irRemHospitalizacionInterrupcion";

    String RUTA_IR_FORMULAMEDICA_INTERRUPCION = "irFormulaMedicaInterrupcion";

    String RUTA_IR_VADEMCUM_INTERRUPCION = "irVademecumInterrupcion";

    String RUTA_IR_CONTOLSINCOSTO_INTERRUPCION = 
        "irControlSinCostoInterrupcion";

    String RUTA_IR_ANATOMIAPATOLOGICA_INTERRUPCION = 
        "irAnatPatologicaInterrupcion";

    String RUTA_IR_IMPRESION_DIAGNOSTICA_INTERRUPCION =  "irImpDiagnosticaInterrupcion";
    
    String RUTA_IR_IMPRESION_DIAGNOSTICA_IVE_INTERRUPCION =  "irImpDiagnosticaIveInterrupcion";

    String RUTA_IR_ENCUESTA_VIOLENCIA_INTERRUPCION = 
        "irEncuestaViolenciaInterrupcion";

    String RUTA_IR_EXAMENFISICO_INTERRUPCION = "irExamenFisicoInterrupcion";

    String RUTA_IR_ANTECEDENTES_DETALLADOS_INTERRUPCION = "irAntecedentesDetalladosInterrupcion";

    String RUTA_IR_ANTECEDENTES_GENERALES_INTERRUPCION = 
        "irAntecedentesGeneralesInterrupcion";
        
    String RUTA_IR_ANTECEDENTES_INTERRUPCION = 
        "irAntecedentesInterrupcion";

    String RUTA_IR_ANTECEDENTES_GINECOLOGICOS_INTERRUPCION = 
        "irAntecedentesGinecologicosInterrupcion";

    String RUTA_IR_CERTIFICADO_ASISTENCIA_INTERRUPCION = 
        "irCertificadoAsistenciaInterrupcion";

    String RUTA_IR_CERTIFICADOMEDICO_INTERRUPCION = 
        "irCertificadoMedicoInterrupcion";

    String RUTA_IR_ELECTROFISIOLOGICO_INTERRUPCION = 
        "irExamenElectrofisiologicosInterrupcion";

    String RUTA_IR_IMAGENES_INTERRUPCION = "irExamenImagenesInterrupcion";

    String RUTA_IR_LABORATORIO_INTERRUPCION = 
        "irExamenLaboratorioInterrupcion";

    String RUTA_IR_RECOMENDACIONES_INTERRUPCION = 
        "irRecomendacionesInterrupcion";

    String RUTA_IR_REFERENCIA_INTERRUPCION = "irReferenciaInterrupcion";

    String RUTA_IR_AUTORIZACION_SERVICIOS_INTERRUPCION = 
        "irAutorizacionServicioInterrupcion";

    String RUTA_IR_IDENTIFICACION_RIESGOS_INTERRUPCION = 
        "irIdentificacionRiesgoInterrupcion";

    String RUTA_IR_AUTORIZACION_SERVICIOS_SALUD_SEXUAL = 
        "irAutorizacionServicioSaludSexual";

    String RUTA_IR_RESERVA_SANGRE_INTERRUPCION = "irReservaSangreInterrupcion";

    String RUTA_IR_CERRAR_CONSULTA_INTERRUPCION = 
        "irCerrarConsultaInterrupcion";

    String RUTA_IR_RESUMEN_HISTORIA_ESPECIFICA_INTERRUPCION = 
        "irResumenHistoriaEspecificaInterrupcion";

    String RUTA_IR_RESUMEN_HISTORIA_INTERRUPCION = 
        "irResumenHistoriaInterrupcion";
   
    String RUTA_IR_ORDEN_LIQUIDOS_INTERRUPCION = "irOrdenLiquidosInterrupcion";
    
    String RUTA_IR_OTRAS_ORDENES_INTERRUPCION = "irOtrasOrdenesInterrupcion"; 

    String RUTA_IR_ORDEN_MEDICAMENTOS_INTERRUPCION = "irOrdenMedicamentosInterrupcion";
    
    
    //TODO: REPORTES

    String RUTA_IR_REPORTE_GESTACIONES = "irReporteGestaciones";

    String RUTA_IR_REPORTE_ACTIVIDADES_EDUCATIVAS = "irRepEducativas";

    String RUTA_IR_REPORTE_OPORTUNIDAD_ENTREGA = "irReporteOportunidadEntrega";

    String RUTA_IR_REPORTE_PORCENTAJE_MANUALES = "irReportePorcentajeManual";

    String RUTA_IR_REPORTE_RADICACION_FACTURAS = "irReporteRadicacionFacturas";

    String RUTA_IR_REPORTE_SERVICIOS_SIN_FACTURA = 
        "irReporteServiciosSinFactura";

    String RUTA_IR_REPORTE_SERVICIOS_IPPF = "irReporteServiciosIPPF";

    String RUTA_IR_REPORTE_USUARIOS_IPPF = "irReporteUsuariosIPPF";

    String RUTA_IR_REPORTE_FACTURACION_CONTRATO = 
        "irReporteFacturacionContrato";

    String RUTA_IR_REPORTE_DIAG_SERVICIO_HABILITADO = 
        "irReporteDiagSrvHabilitado";
        
    String RUTA_IR_REPORTE_VARIOS = 
        "irRepGestionClinl";    

    String RUTA_IR_REPORTE_MEDICAMENTO_VACUNA = "irReporteMedVacuna";

    String RUTA_IR_REPORTE_INFORMACION_ABORTO_1 = 
        "irReporteInformacionAborto1";

    String RUTA_IR_REPORTE_INFROMACION_ABORTO_2 = 
        "irReporteInformacionAborto2";

    String RUTA_IR_REPORTE_EPICRISIS = "irReporteEpicrisis";

    String RUTA_IR_REPORTE_PORCENTAJE_MANUALES_NACIONAL = 
        "irReportePorcentajeManualNacional";

    String RUTA_IR_REPORTE_CONSULTAS_ATENDIDAS = "irReporteConsultasAtendidas";

    String RUTA_IR_REPORTE_CONSULTAS_ABIERTAS = "irReporteConsultasAbiertas";

    String RUTA_IR_REPORTE_CONSULTAS_ABIERTAS_NACIONAL = 
        "irReporteConsultasAbiertasNacional";

    String RUTA_IR_REPORTE_DATOS_RIPS = "irReporteDatosRips";

    String RUTA_IR_CONSULTAR_FOLIOS_INCOMPLETOS = "ver_folios_incompleto";

    String RUTA_IR_REPORTE_OTRAS_ASESORIAS = "irReporteOtrasAsesorias";

    String RUTA_IR_REPORTE_OTRAS_ASESORIAS_NAL = "irReporteOtrasAsesoriasNal";


    String RUTA_IR_REPORTE_MIS_ASESORIAS_ILVE = "irReporteMisAsesoriasIlve";
    
    String RUTA_IR_REPORTE_REGISTRO_COMPL_ENFERMERIA = "irReporteRegistroComplementarioEnfer";
    
    String RUTA_IR_REPORTE_REFERENCIA = "irReporteReferencia";

    String RUTA_IR_REPORTE_ENVIO_EMAIL = "irReporteEnvioEmail";

    // TODO: ENFERMERIA


    String RUTA_IR_MOTIVO_ANTICONCEPCION_ENFERMERIA =  "irMotivoAnticoncepcionEnfermeria";
    
    String RUTA_IR_CUESTIONARIO_COVID_ANTICONCEPCION_ENFERMERIA = "irCuestionarioCovidAnticoncepcionEnfermeria";

    String RUTA_IR_DATOS_ANTICONCEPCION_ENFERMERIA = 
        "irDatosAnticoncepcionEnfermeria";


    String RUTA_IR_APLICACION_RETITO_ANTICONCEPCION_ENFERMERIA = 
        "irAplicacionRetiroAnticoncepcionEnfermeria";

    String RUTA_IR_IMPRESION_DIAGNOSTICA_ANTICONCEPCION_ENFERMERIA = 
        "irImpDiagnosticaAnticoncepcionEnfermeria";

    String RUTA_IR_ENCUESTA_VIOLENCIA_ANTICONCEPCION_ENFERMERIA = 
        "irEncuestaViolenciaAnticoncepcionEnfermeria";

    String RUTA_IR_EXAMENFISICO_ANTICONCEPCION_ENFERMERIA = 
        "irExamenFisicoAnticoncepcionEnfermeria";

    String RUTA_IR_FORMULAMEDICA_ANTICONCEPCION_ENFERMERIA = 
        "irFormulaMedicaAnticoncepcionEnfermeria";

    String RUTA_IR_ANTECEDENTES_GENERALES_ANTICONCEPCION_ENFERMERIA = 
        "irAntecedentesGeneralesAnticoncepcionEnfermeria";

    String RUTA_IR_ANTECEDENTES_TEMPORALES_ANTICONCEPCION_ENFERMERIA = 
        "irAntecedentesTemporalesAnticoncepcionEnfermeria";

    String RUTA_IR_ANTECEDENTES_ANTICONCEPCION_ENFERMERIA = 
        "irAntecedentesAnticoncepcionEnfermeria";

    String RUTA_IR_ANTECEDENTES_GINECOLOGICOS_ANTICONCEPCION_ENFERMERIA = 
        "irAntecedentesGinecologicosAnticoncepcionEnfermeria";

    String RUTA_IR_RECOMENDACIONES_ANTICONCEPCION_ENFERMERIA = 
        "irRecomendacionesAnticoncepcionEnfermeria";

    String RUTA_IR_CERRAR_CONSULTA_ANTICONCEPCION_ENFERMERIA = 
        "irCerrarConsultaAnticoncepcionEnfermeria";

    String RUTA_IR_RESUMEN_ESPECIFICO_ANTICONCEPCION_ENFERMERIA = 
        "irResumenHistoriaEspecificaAnticoncepcionEnfermeria";

    String RUTA_IR_RESUMEN_ANTICONCEPCION_ENFERMERIA = 
        "irResumenHistoriaAnticoncepcionEnfermeria";

    String RUTA_IR_METODO_PLANIFICACION_ANTICONCEPCION_ENFERMERIA = 
        "irMetodoPlanificacionAnticoncepcionEnfermeria";

    String RUTA_IR_ELECTROFISIOLOGICO_ANTICONCEPCION_ENFERMERIA_RETIRO = 
         "irExamenElectrofisiologicosAnticoncepcionEnfermeriaRetiro";
         
    String RUTA_IR_INTERCONSULTA_ANTICONCEPCION_ENFERMERIA = 
        "irInterConsultaAnticoncepcionEnfermeria";

    String RUTA_IR_ORDENCIRUGIA_ANTICONCEPCION_ENFERMERIA = 
        "irOrdenCirugiaAnticoncepcionEnfermeria";

    String RUTA_IR_INCAPACIDAD_ANTICONCEPCION_ENFERMERIA = 
        "irIncapacidadAnticoncepcionEnfermeria";

    String RUTA_IR_HOSPITALZACION_ANTICONCEPCION_ENFERMERIA = 
        "irRemHospitalizacionAnticoncepcionEnfermeria";

    String RUTA_IR_CONTOLSINCOSTO_ANTICONCEPCION_ENFERMERIA = 
        "irControlSinCostoAnticoncepcionEnfermeria";

    String RUTA_IR_ANATOMIAPATOLOGICA_ANTICONCEPCION_ENFERMERIA = 
        "irAnatPatologicaAnticoncepcionEnfermeria";

    String RUTA_IR_CERTIFICADO_ASISTENCIA_ANTICONCEPCION_ENFERMERIA = 
        "irCertificadoAsistenciaAnticoncepcionEnfermeria";

    String RUTA_IR_CERTIFICADOMEDICO_ANTICONCEPCION_ENFERMERIA = 
        "irCertificadoMedicoAnticoncepcionEnfermeria";

    String RUTA_IR_ELECTROFISIOLOGICO_ANTICONCEPCION_ENFERMERIA = 
        "irExamenElectrofisiologicosAnticoncepcionEnfermeria";

    String RUTA_IR_IMAGENES_ANTICONCEPCION_ENFERMERIA = 
        "irExamenImagenesAnticoncepcionEnfermeria";

    String RUTA_IR_LABORATORIO_ANTICONCEPCION_ENFERMERIA = 
        "irExamenLaboratorioAnticoncepcionEnfermeria";


    String RUTA_IR_REFERENCIA_ANTICONCEPCION_ENFERMERIA = 
        "irReferenciaAnticoncepcionEnfermeria";

    String RUTA_IR_AUTORIZACION_SERVICIO_ANTICONCEPCION_ENFERMERIA = 
        "irAutorizacionServicioAnticoncepcionEnfermeria";

    String RUTA_IR_RESERVA_SANGRE_ANTICONCEPCION_ENFERMERIA = 
                "irReservaSangreAnticoncepcionEnfermeria";


    //HISTORIA INSERCION

    String RUTA_IR_MOTIVO_ANTICONCEPCION_ENFERMERIA_INSERCION =  "irMotivoAnticoncepcionEnfermeriaInsercion";
    
    String RUTA_IR_CUESTIONARIO_COVID_ENFERMERIA_INSERCION = "irCuestionarioCovidEnfermeriaInsercion";

    String RUTA_IR_DATOS_ANTICONCEPCION_ENFERMERIA_INSERCION = 
        "irDatosAnticoncepcionEnfermeriaInsercion";


    String RUTA_IR_APLICACION_RETITO_ANTICONCEPCION_ENFERMERIA_INSERCION = 
        "irAplicacionRetiroAnticoncepcionEnfermeriaInsercion";

    String RUTA_IR_IMPRESION_DIAGNOSTICA_ANTICONCEPCION_ENFERMERIA_INSERCION = 
        "irImpDiagnosticaAnticoncepcionEnfermeriaInsercion";

    String RUTA_IR_ENCUESTA_VIOLENCIA_ANTICONCEPCION_ENFERMERIA_INSERCION = 
        "irEncuestaViolenciaAnticoncepcionEnfermeriaInsercion";

    String RUTA_IR_EXAMENFISICO_ANTICONCEPCION_ENFERMERIA_INSERCION = 
        "irExamenFisicoAnticoncepcionEnfermeriaInsercion";

    String RUTA_IR_ANTECEDENTES_GENERALES_ANTICONCEPCION_ENFERMERIA_INSERCION = 
        "irAntecedentesGeneralesAnticoncepcionEnfermeriaInsercion";

    String RUTA_IR_ANTECEDENTES_TEMPORALES_ANTICONCEPCION_ENFERMERIA_INSERCION = 
        "irAntecedentesTemporalesAnticoncepcionEnfermeriaInsercion";

    String RUTA_IR_ANTECEDENTES_ANTICONCEPCION_ENFERMERIA_INSERCION = 
        "irAntecedentesAnticoncepcionEnfermeriaInsercion";

    String RUTA_IR_ANTECEDENTES_GINECOLOGICOS_ANTICONCEPCION_ENFERMERIA_INSERCION = 
        "irAntecedentesGinecologicosAnticoncepcionEnfermeriaInsercion";

    String RUTA_IR_RECOMENDACIONES_ANTICONCEPCION_ENFERMERIA_INSERCION = 
        "irRecomendacionesAnticoncepcionEnfermeriaInsercion";

    String RUTA_IR_FORMULAMEDICA_ANTICONCEPCION_ENFERMERIA_INSERCION = 
        "irFormulaMedicaAnticoncepcionEnfermeriaInsercion";


    String RUTA_IR_VADEMCUM_ANTICONCEPCION_ENFERMERIA_INSERCION = 
        "irVademecumAnticoncepcionEnfermeriaInsercion";


    String RUTA_IR_CERRAR_CONSULTA_ANTICONCEPCION_ENFERMERIA_INSERCION = 
        "irCerrarConsultaAnticoncepcionEnfermeriaInsercion";

    String RUTA_IR_RESUMEN_ESPECIFICO_ANTICONCEPCION_ENFERMERIA_INSERCION = 
        "irResumenHistoriaEspecificaAnticoncepcionEnfermeriaInsercion";

    String RUTA_IR_RESUMEN_ANTICONCEPCION_ENFERMERIA_INSERCION = 
        "irResumenHistoriaAnticoncepcionEnfermeriaInsercion";

    String RUTA_IR_METODO_PLANIFICACION_ANTICONCEPCION_ENFERMERIA_INSERCION = 
        "irMetodoPlanificacionAnticoncepcionEnfermeriaInsercion";
        
    String RUTA_IR_INTERCONSULTA_ANTICONCEPCION_ENFERMERIA_INSERCION = 
        "irInterConsultaAnticoncepcionEnfermeriaInsercion";

    String RUTA_IR_ORDENCIRUGIA_ANTICONCEPCION_ENFERMERIA_INSERCION = 
        "irOrdenCirugiaAnticoncepcionEnfermeriaInsercion";

    String RUTA_IR_INCAPACIDAD_ANTICONCEPCION_ENFERMERIA_INSERCION = 
        "irIncapacidadAnticoncepcionEnfermeriaInsercion";

    String RUTA_IR_HOSPITALZACION_ANTICONCEPCION_ENFERMERIA_INSERCION = 
        "irRemHospitalizacionAnticoncepcionEnfermeriaInsercion";

    String RUTA_IR_CONTOLSINCOSTO_ANTICONCEPCION_ENFERMERIA_INSERCION = 
        "irControlSinCostoAnticoncepcionEnfermeriaInsercion";

    String RUTA_IR_ANATOMIAPATOLOGICA_ANTICONCEPCION_ENFERMERIA_INSERCION = 
        "irAnatPatologicaAnticoncepcionEnfermeriaInsercion";

    String RUTA_IR_CERTIFICADO_ASISTENCIA_ANTICONCEPCION_ENFERMERIA_INSERCION = 
        "irCertificadoAsistenciaAnticoncepcionEnfermeriaInsercion";

    String RUTA_IR_CERTIFICADOMEDICO_ANTICONCEPCION_ENFERMERIA_INSERCION = 
        "irCertificadoMedicoAnticoncepcionEnfermeriaInsercion";

    String RUTA_IR_ELECTROFISIOLOGICO_ANTICONCEPCION_ENFERMERIA_INSERCION = 
        "irExamenElectrofisiologicosAnticoncepcionEnfermeriaInsercion";

    String RUTA_IR_IMAGENES_ANTICONCEPCION_ENFERMERIA_INSERCION = 
        "irExamenImagenesAnticoncepcionEnfermeriaInsercion";

    String RUTA_IR_LABORATORIO_ANTICONCEPCION_ENFERMERIA_INSERCION = 
        "irExamenLaboratorioAnticoncepcionEnfermeriaInsercion";


    String RUTA_IR_REFERENCIA_ANTICONCEPCION_ENFERMERIA_INSERCION = 
        "irReferenciaAnticoncepcionEnfermeriaInsercion";

    String RUTA_IR_REFERENCIA_AUTORIZACION_SERVICIO_ANTICONCEPCION_ENFERMERIA_INSERCION = 
        "irAutorizacionServicioAnticoncepcionEnfermeriaInsercion";

    String RUTA_IR_RESERVA_SANGRE_ANTICONCEPCION_ENFERMERIA_INSERCION = 
        "irReservaSangreAnticoncepcionEnfermeriaInsercion";


    // HISTORIA RETIRO

    String RUTA_IR_VADEMCUM_ANTICONCEPCION_ENFERMERIA_RETIRO = 
        "irVademecumAnticoncepcionEnfermeriaRetiro";

    String RUTA_IR_MOTIVO_ANTICONCEPCION_ENFERMERIA_RETIRO =  "irMotivoAnticoncepcionEnfermeriaRetiro";
    
      
    String RUTA_IR_CUESTIONARIO_COVID_ENFERMERIA_RETIRO = "irCuestionarioCovidEnfermeriaRetiro";

    String RUTA_IR_DATOS_ANTICONCEPCION_ENFERMERIA_RETIRO = 
        "irDatosAnticoncepcionEnfermeriaRetiro";


    String RUTA_IR_APLICACION_RETITO_ANTICONCEPCION_ENFERMERIA_RETIRO = 
        "irAplicacionRetiroAnticoncepcionEnfermeriaRetiro";

    String RUTA_IR_IMPRESION_DIAGNOSTICA_ANTICONCEPCION_ENFERMERIA_RETIRO = 
        "irImpDiagnosticaAnticoncepcionEnfermeriaRetiro";

    String RUTA_IR_ENCUESTA_VIOLENCIA_ANTICONCEPCION_ENFERMERIA_RETIRO = 
        "irEncuestaViolenciaAnticoncepcionEnfermeriaRetiro";

    String RUTA_IR_EXAMENFISICO_ANTICONCEPCION_ENFERMERIA_RETIRO = 
        "irExamenFisicoAnticoncepcionEnfermeriaRetiro";

    String RUTA_IR_ANTECEDENTES_GENERALES_ANTICONCEPCION_ENFERMERIA_RETIRO = 
        "irAntecedentesGeneralesAnticoncepcionEnfermeriaRetiro";

    String RUTA_IR_FORMULAMEDICA_ANTICONCEPCION_ENFERMERIA_RETIRO = 
        "irFormulaMedicaAnticoncepcionEnfermeriaRetiro";

    String RUTA_IR_ANTECEDENTES_TEMPORALES_ANTICONCEPCION_ENFERMERIA_RETIRO = 
        "irAntecedentesTemporalesAnticoncepcionEnfermeriaRetiro";

    String RUTA_IR_ANTECEDENTES_ANTICONCEPCION_ENFERMERIA_RETIRO = 
        "irAntecedentesAnticoncepcionEnfermeriaRetiro";

    String RUTA_IR_ANTECEDENTES_GINECOLOGICOS_ANTICONCEPCION_ENFERMERIA_RETIRO = 
        "irAntecedentesGinecologicosAnticoncepcionEnfermeriaRetiro";

    String RUTA_IR_RECOMENDACIONES_ANTICONCEPCION_ENFERMERIA_RETIRO = 
        "irRecomendacionesAnticoncepcionEnfermeriaRetiro";

    String RUTA_IR_CERRAR_CONSULTA_ANTICONCEPCION_ENFERMERIA_RETIRO = 
        "irCerrarConsultaAnticoncepcionEnfermeriaRetiro";

    String RUTA_IR_RESUMEN_ESPECIFICO_ANTICONCEPCION_ENFERMERIA_RETIRO = 
        "irResumenHistoriaEspecificaAnticoncepcionEnfermeriaRetiro";

    String RUTA_IR_RESUMEN_ANTICONCEPCION_ENFERMERIA_RETIRO = 
        "irResumenHistoriaAnticoncepcionEnfermeriaRetiro";

    String RUTA_IR_METODO_PLANIFICACION_ANTICONCEPCION_ENFERMERIA_RETIRO = 
        "irMetodoPlanificacionAnticoncepcionEnfermeriaRetiro";
    
    String RUTA_IR_INTERCONSULTA_ANTICONCEPCION_ENFERMERIA_RETIRO = 
        "irInterConsultaAnticoncepcionEnfermeriaRetiro";

    String RUTA_IR_ORDENCIRUGIA_ANTICONCEPCION_ENFERMERIA_RETIRO = 
        "irOrdenCirugiaAnticoncepcionEnfermeriaRetiro";

    String RUTA_IR_INCAPACIDAD_ANTICONCEPCION_ENFERMERIA_RETIRO = 
        "irIncapacidadAnticoncepcionEnfermeriaRetiro";

    String RUTA_IR_HOSPITALZACION_ANTICONCEPCION_ENFERMERIA_RETIRO = 
        "irRemHospitalizacionAnticoncepcionEnfermeriaRetiro";

    String RUTA_IR_CONTOLSINCOSTO_ANTICONCEPCION_ENFERMERIA_RETIRO = 
        "irControlSinCostoAnticoncepcionEnfermeriaRetiro";

    String RUTA_IR_ANATOMIAPATOLOGICA_ANTICONCEPCION_ENFERMERIA_RETIRO = 
        "irAnatPatologicaAnticoncepcionEnfermeriaRetiro";


    String RUTA_IR_CERTIFICADO_ASISTENCIA_ANTICONCEPCION_ENFERMERIA_RETIRO = 
        "irCertificadoAsistenciaAnticoncepcionEnfermeriaRetiro";

    String RUTA_IR_CERTIFICADOMEDICO_ANTICONCEPCION_ENFERMERIA_RETIRO = 
        "irCertificadoMedicoAnticoncepcionEnfermeriaRetiro";

    String RUTA_IR_ELECTROFISIOLOGICO__ANTICONCEPCION_ENFERMERIA_RETIRO = 
        "irExamenElectrofisiologicosAnticoncepcionEnfermeriaRetiro";

    String RUTA_IR_IMAGENES_ANTICONCEPCION_ENFERMERIA_RETIRO = 
        "irExamenImagenesAnticoncepcionEnfermeriaRetiro";

    String RUTA_IR_LABORATORIO_ANTICONCEPCION_ENFERMERIA_RETIRO = 
        "irExamenLaboratorioAnticoncepcionEnfermeriaRetiro";

    String RUTA_IR_REFERENCIA_ANTICONCEPCION_ENFERMERIA_RETIRO = 
        "irReferenciaAnticoncepcionEnfermeriaRetiro";

    String RUTA_IR_REFERENCIA_AUTORIZACION_SERVICIO_ANTICONCEPCION_ENFERMERIA_RETIRO = 
        "irAutorizacionServicioAnticoncepcionEnfermeriaRetiro";

    String RUTA_IR_RESERVA_SANGRE_ANTICONCEPCION_ENFERMERIA_RETIRO = 
        "irReservaSangreAnticoncepcionEnfermeriaRetiro";


    // HISTORIA CONTROL ANTICONCEPCION

    String RUTA_IR_DATOS_CONTROL_ANTICONCEPCION_ENFERMERIA = 
        "irDatosControlAnticoncepcionEnfermeria";

    String RUTA_IR_MOTIVO_CONTROL_ANTICONCEPCION_ENFERMERIA = "irMotivoControlAnticoncepcionEnfermeria";
    
    String RUTA_IR_CUESTIONARIO_COVID_CONTROL_ANTICONCEPCION_ENFERMERIA = "irCuestionarioCovidControlAnticoncepcionEnfermeria";

    String RUTA_IR_APLICACION_RETITO_CONTROL_ANTICONCEPCION_ENFERMERIA = 
        "irAplicacionRetiroControlAnticoncepcionEnfermeria";

    String RUTA_IR_IMPRESION_DIAGNOSTICA_CONTROL_ANTICONCEPCION_ENFERMERIA = 
        "irImpDiagnosticaControlAnticoncepcionEnfermeria";

    String RUTA_IR_ENCUESTA_VIOLENCIA_CONTROL_ANTICONCEPCION_ENFERMERIA = 
        "irEncuestaViolenciaControlAnticoncepcionEnfermeria";

    String RUTA_IR_EXAMENFISICO_CONTROL_ANTICONCEPCION_ENFERMERIA = 
        "irExamenFisicoControlAnticoncepcionEnfermeria";

    String RUTA_IR_ANTECEDENTES_CONTROL_ANTICONCEPCION_ENFERMERIA = 
        "irAntecedentesControlAnticoncepcionEnfermeria";

    String RUTA_IR_ANTECEDENTES_GENERALES_CONTROL_ANTICONCEPCION_ENFERMERIA = 
        "irAntecedentesGeneralesControlAnticoncepcionEnfermeria";

    String RUTA_IR_ANTECEDENTES_GINECOLOGICOS_CONTROL_ANTICONCEPCION_ENFERMERIA = 
        "irAntecedentesGinecologicosControlAnticoncepcionEnfermeria";

    String RUTA_IR_RECOMENDACIONES_CONTROL_ANTICONCEPCION_ENFERMERIA = 
        "irRecomendacionesControlAnticoncepcionEnfermeria";


    String RUTA_IR_METODO_PLANIFICACION_CONTROL_ANTICONCEPCION_ENFERMERIA = 
        "irMetodoPlanificacionControlAnticoncepcionEnfermeria";

    String RUTA_IR_CERRAR_CONSULTA_CONTROL_ANTICONCEPCION_ENFERMERIA = 
        "irCerrarConsultaControlAnticoncepcionEnfermeria";

    String RUTA_IR_FORMULAMEDICA_CONTROL_ANTICONCEPCION_ENFERMERIA = 
        "irFormulaMedicaControlAnticoncepcionEnfermeria";


    String RUTA_IR_VADEMCUM_CONTROL_ANTICONCEPCION_ENFERMERIA = 
        "irVademecumControlAnticoncepcionEnfermeria";


    String RUTA_IR_RESUMEN_HISTORIA_ESPECIFICA_CONTROL_ANTICONCEPCION_ENFERMERIA = 
        "irResumenHistoriaEspecificaControlAnticoncepcionEnfermeria";

    String RUTA_IR_RESUMEN_HISTORIA_CONTROL_ANTICONCEPCION_ENFERMERIA = 
        "irResumenHistoriaControlAnticoncepcionEnfermeria";
    
    String RUTA_IR_INTERCONSULTA_ANTICONCEPCION_CONTROL_ENFERMERIA = 
        "irInterConsultaAnticoncepcionControlEnfermeria";

    String RUTA_IR_ORDENCIRUGIA_ANTICONCEPCION_CONTROL_ENFERMERIA = 
        "irOrdenCirugiaAnticoncepcionControlEnfermeria";

    String RUTA_IR_INCAPACIDAD_ANTICONCEPCION_CONTROL_ENFERMERIA = 
        "irIncapacidadAnticoncepcionControlEnfermeria";

    String RUTA_IR_HOSPITALZACION_ANTICONCEPCION_CONTROL_ENFERMERIA = 
        "irRemHospitalizacionAnticoncepcionControlEnfermeria";

    String RUTA_IR_CONTOLSINCOSTO_ANTICONCEPCION_CONTROL_ENFERMERIA = 
        "irControlSinCostoAnticoncepcionControlEnfermeria";

    String RUTA_IR_ANATOMIAPATOLOGICA_ANTICONCEPCION_CONTROL_ENFERMERIA = 
        "irAnatPatologicaAnticoncepcionControlEnfermeria";

    String RUTA_IR_CERTIFICADO_ASISTENCIA_ANTICONCEPCION_CONTROL_ENFERMERIA = 
        "irCertificadoAsistenciaAnticoncepcionControlEnfermeria";

    String RUTA_IR_CERTIFICADOMEDICO_ANTICONCEPCION_CONTROL_ENFERMERIA = 
        "irCertificadoMedicoAnticoncepcionControlEnfermeria";

    String RUTA_IR_ELECTROFISIOLOGICO_ANTICONCEPCION_CONTROL_ENFERMERIA = 
        "irExamenElectrofisiologicosAnticoncepcionControlEnfermeria";

    String RUTA_IR_IMAGENES_ANTICONCEPCION_CONTROL_ENFERMERIA = 
        "irExamenImagenesAnticoncepcionControlEnfermeria";

    String RUTA_IR_LABORATORIO_ANTICONCEPCION_CONTROL_ENFERMERIA = 
        "irExamenLaboratorioAnticoncepcionControlEnfermeria";


    String RUTA_IR_REFERENCIA_ANTICONCEPCION_CONTROL_ENFERMERIA = 
        "irReferenciaAnticoncepcionControlEnfermeria";

    String RUTA_IR_AUTORIZACION_SERVICIO_ANTICONCEPCION_CONTROL_ENFERMERIA = 
        "irAutorizacionServicioAnticoncepcionControlEnfermeria";

    String RUTA_IR_RESERVA_SANGRE_ANTICONCEPCION_CONTROL_ENFERMERIA =  "irReservaSangreAnticoncepcionControlEnfermeria";


    //ANTICONCEPCION INSERCION 


    // INICIO ANTICONCEPCION TEMPORAL INSERCION

    String RUTA_IR_MOTIVO_ANTICONCEPCION_INSERCION =  "irMotivoAnticoncepcionInsercion";
    
    String RUTA_IR_CUESTIONARIO_COVID_INSERCION = "irCuestionarioCovidInsercion";

    String RUTA_IR_DATOS_ANTICONCEPCION_INSERCION = 
        "irDatosAnticoncepcionInsercion";

    String RUTA_IR_INTERCONSULTA_ANTICONCEPCION_INSERCION = 
        "irInterConsultaAnticoncepcionInsercion";

    String RUTA_IR_ORDENCIRUGIA_ANTICONCEPCION_INSERCION = 
        "irOrdenCirugiaAnticoncepcionInsercion";

    String RUTA_IR_INCAPACIDAD_ANTICONCEPCION_INSERCION = 
        "irIncapacidadAnticoncepcionInsercion";

    String RUTA_IR_HOSPITALZACION_ANTICONCEPCION_INSERCION = 
        "irRemHospitalizacionAnticoncepcionInsercion";

    String RUTA_IR_FORMULAMEDICA_ANTICONCEPCION_INSERCION = 
        "irFormulaMedicaAnticoncepcionInsercion";

    String RUTA_IR_VADEMCUM_ANTICONCEPCION_INSERCION = 
        "irVademecumAnticoncepcionInsercion";


    String RUTA_IR_CONTOLSINCOSTO_ANTICONCEPCION_INSERCION = 
        "irControlSinCostoAnticoncepcionInsercion";

    String RUTA_IR_ANATOMIAPATOLOGICA_ANTICONCEPCION_INSERCION = 
        "irAnatPatologicaAnticoncepcionInsercion";

    String RUTA_IR_APLICACION_RETITO_ANTICONCEPCION_INSERCION = 
        "irAplicacionRetiroAnticoncepcionInsercion";

    String RUTA_IR_IMPRESION_DIAGNOSTICA_ANTICONCEPCION_INSERCION = 
        "irImpDiagnosticaAnticoncepcionInsercion";

    String RUTA_IR_METODO_PLANIFICACION_ANTICONCEPCION_INSERCION = 
        "irMetodoPlanificacionAnticoncepcionInsercion";

    String RUTA_IR_ENCUESTA_VIOLENCIA_ANTICONCEPCION_INSERCION = 
        "irEncuestaViolenciaAnticoncepcionInsercion";

    String RUTA_IR_EXAMENFISICO_ANTICONCEPCION_INSERCION = 
        "irExamenFisicoAnticoncepcionInsercion";


    String RUTA_IR_ANTECEDENTES_ANTICONCEPCION_INSERCION = 
        "irAntecedentesAnticoncepcionInsercion";

    String RUTA_IR_ANTECEDENTES_GENERALES_ANTICONCEPCION_INSERCION = 
        "irAntecedentesGeneralesAnticoncepcionInsercion";

    String RUTA_IR_ANTECEDENTES_GINECOLOGICOS_ANTICONCEPCION_INSERCION = 
        "irAntecedentesGinecologicosAnticoncepcionInsercion";

    String RUTA_IR_ANTECEDENTES_TEMPORALES_ANTICONCEPCION_INSERCION = 
        "irAntecedentesTemporalesAnticoncepcionInsercion";

    String RUTA_IR_CERTIFICADO_ASISTENCIA_ANTICONCEPCION_INSERCION = 
        "irCertificadoAsistenciaAnticoncepcionInsercion";

    String RUTA_IR_CERTIFICADOMEDICO_ANTICONCEPCION_INSERCION = 
        "irCertificadoMedicoAnticoncepcionInsercion";

    String RUTA_IR_ELECTROFISIOLOGICO__ANTICONCEPCION_INSERCION = 
        "irExamenElectrofisiologicosAnticoncepcionInsercion";

    String RUTA_IR_IMAGENES_ANTICONCEPCION_INSERCION = 
        "irExamenImagenesAnticoncepcionInsercion";

    String RUTA_IR_LABORATORIO_ANTICONCEPCION_INSERCION = 
        "irExamenLaboratorioAnticoncepcionInsercion";

    String RUTA_IR_RECOMENDACIONES_ANTICONCEPCION_INSERCION = 
        "irRecomendacionesAnticoncepcionInsercion";

    String RUTA_IR_REFERENCIA_ANTICONCEPCION_INSERCION = 
        "irReferenciaAnticoncepcionInsercion";

    String RUTA_IR_REFERENCIA_AUTORIZACION_SERVICIO_ANTICONCEPCION_INSERCION = 
        "irAutorizacionServicioAnticoncepcion";

    String RUTA_IR_RESERVA_SANGRE_ANTICONCEPCION_INSERCION = 
        "irReservaSangreAnticoncepcionInsercion";

    String RUTA_IR_CERRAR_CONSULTA_ANTICONCEPCION_INSERCION = 
        "irCerrarConsultaAnticoncepcionInsercion";

    String RUTA_IR_RESUMEN_ESPECIFICO_ANTICONCEPCION_INSERCION = 
        "irResumenHistoriaEspecificaAnticoncepcionInsercion";

    String RUTA_IR_RESUMEN_ANTICONCEPCION_INSERCION = 
        "irResumenHistoriaAnticoncepcionInsercion";


    // INICIO ANTICONCEPCION TEMPORAL RETIRO

    String RUTA_IR_MOTIVO_ANTICONCEPCION_RETIRO =    "irMotivoAnticoncepcionRetiro";
    
    String RUTA_IR_CUESTIONARIO_COVID_ANTICONCEPCION_RETIRO =    "irCuestionarioCovidAnticoncepcionRetiro";

    String RUTA_IR_DATOS_ANTICONCEPCION_RETIRO = "irDatosAnticoncepcionRetiro";

    String RUTA_IR_INTERCONSULTA_ANTICONCEPCION_RETIRO = 
        "irInterConsultaAnticoncepcionRetiro";

    String RUTA_IR_ORDENCIRUGIA_ANTICONCEPCION_RETIRO = 
        "irOrdenCirugiaAnticoncepcionRetiro";

    String RUTA_IR_INCAPACIDAD_ANTICONCEPCION_RETIRO = 
        "irIncapacidadAnticoncepcionRetiro";

    String RUTA_IR_HOSPITALZACION_ANTICONCEPCION_RETIRO = 
        "irRemHospitalizacionAnticoncepcionRetiro";

    String RUTA_IR_FORMULAMEDICA_ANTICONCEPCION_RETIRO = 
        "irFormulaMedicaAnticoncepcionRetiro";

    String RUTA_IR_VADEMCUM_ANTICONCEPCION_RETIRO = 
        "irVademecumAnticoncepcionRetiro";

    String RUTA_IR_CONTOLSINCOSTO_ANTICONCEPCION_RETIRO = 
        "irControlSinCostoAnticoncepcionRetiro";

    String RUTA_IR_ANATOMIAPATOLOGICA_ANTICONCEPCION_RETIRO = 
        "irAnatPatologicaAnticoncepcionRetiro";

    String RUTA_IR_APLICACION_RETITO_ANTICONCEPCION_RETIRO = 
        "irAplicacionRetiroAnticoncepcionRetiro";

    String RUTA_IR_IMPRESION_DIAGNOSTICA_ANTICONCEPCION_RETIRO = 
        "irImpDiagnosticaAnticoncepcionRetiro";

    String RUTA_IR_ENCUESTA_VIOLENCIA_ANTICONCEPCION_RETIRO = 
        "irEncuestaViolenciaAnticoncepcionRetiro";

    String RUTA_IR_EXAMENFISICO_ANTICONCEPCION_RETIRO = 
        "irExamenFisicoAnticoncepcionRetiro";


    String RUTA_IR_ANTECEDENTES_ANTICONCEPCION_RETIRO = 
        "irAntecedentesAnticoncepcionRetiro";

    String RUTA_IR_ANTECEDENTES_GENERALES_ANTICONCEPCION_RETIRO = 
        "irAntecedentesGeneralesAnticoncepcionRetiro";

    String RUTA_IR_ANTECEDENTES_GINECOLOGICOS_ANTICONCEPCION_RETIRO = 
        "irAntecedentesGinecologicosAnticoncepcionRetiro";

    String RUTA_IR_ANTECEDENTES_TEMPORALES_ANTICONCEPCION_RETIRO = 
        "irAntecedentesTemporalesAnticoncepcionRetiro";

    String RUTA_IR_CERTIFICADO_ASISTENCIA_ANTICONCEPCION_RETIRO = 
        "irCertificadoAsistenciaAnticoncepcionRetiro";

    String RUTA_IR_CERTIFICADOMEDICO_ANTICONCEPCION_RETIRO = 
        "irCertificadoMedicoAnticoncepcionRetiro";

    String RUTA_IR_ELECTROFISIOLOGICO__ANTICONCEPCION_RETIRO = 
        "irExamenElectrofisiologicosAnticoncepcionRetiro";

    String RUTA_IR_IMAGENES_ANTICONCEPCION_RETIRO = 
        "irExamenImagenesAnticoncepcionRetiro";

    String RUTA_IR_LABORATORIO_ANTICONCEPCION_RETIRO = 
        "irExamenLaboratorioAnticoncepcionRetiro";

    String RUTA_IR_RECOMENDACIONES_ANTICONCEPCION_RETIRO = 
        "irRecomendacionesAnticoncepcionRetiro";

    String RUTA_IR_REFERENCIA_ANTICONCEPCION_RETIRO = 
        "irReferenciaAnticoncepcionRetiro";

    String RUTA_IR_AUTORIZACION_ANTICONCEPCION_RETIRO = 
        "irAutorizacionServicioAnticoncepcion";

    String RUTA_IR_RESERVA_SANGRE_ANTICONCEPCION_RETIRO = 
        "irReservaSangreAnticoncepcionRetiro";

    String RUTA_IR_CERRAR_CONSULTA_ANTICONCEPCION_RETIRO = 
        "irCerrarConsultaAnticoncepcionRetiro";

    String RUTA_IR_RESUMEN_ESPECIFICO_ANTICONCEPCION_RETIRO = 
        "irResumenHistoriaEspecificaAnticoncepcionRetiro";

    String RUTA_IR_RESUMEN_ANTICONCEPCION_RETIRO = 
        "irResumenhistoriaAnticoncepcionRetiro";


    // HISTORIA CONTROL ENFERMERIA


    String RUTA_IR_DATOS_CONTROL_ENFERMERIA = "irDatosControlEnfermeria";

    String RUTA_IR_MOTIVO_CONTROL_ENFERMERIA = "irMotivoControlEnfermeria";

    String RUTA_IR_EXAMEN_FISICO_CONTROL_ENFERMERIA = 
        "irExamenFisicoControlEnfermeria";

    String RUTA_IR_APLICACION_RETITO_CONTROL_ENFERMERIA = 
        "irAplicacionRetiroControlEnfermeria";

    String RUTA_IR_CONTROL_USUARIO_ENFERMERIA = "irControlUsuarioEnfermeria";
    
    String RUTA_IR_CUESTIONARIO_COVID_CONTROL_ENFERMERIA = "irCuestionarioCovidControlEnfermeria";


    String RUTA_IR_ANTECEDENTES_CONTROL_ENFERMERIA = 
        "irAntecedentesControlEnfermeria";

    String RUTA_IR_ANTECEDENTES_GENERALES_CONTROL_ENFERMERIA = 
        "irAntecedentesGeneralesControlEnfermeria";

    String RUTA_IR_RECOMENDACIONES_CONTROL_ENFERMERIA = 
        "irRecomendacionesControlEnfermeria";

    String RUTA_IR_CERRAR_CONTROL_ENFERMERIA = 
        "irCerrarConsultaControlEnfermeria";

    String RUTA_IR_RESUMEN_HISTORIA_ESPECIFICA_CONTROL_ENFERMERIA = 
        "irResumenHistoriaEspecificaControlEnfermeria";

    String RUTA_IR_RESUMEN_HISTORIA_CONTROL_ENFERMERIA = 
        "irResumenHistoriaControlEnfermeria";


    String RUTA_IR_FORMULAMEDICA_CONTROL_ENFERMERIA = 
        "irFormulaMedicaControlEnfermeria";

    String RUTA_IR_VADEMCUM_CONTROL_ENFERMERIA = 
        "irVademecumControlEnfermeria";
        
    String RUTA_IR_INTERCONSULTA_CONTROL_ENFERMERIA = 
        "irInterConsultaControlEnfermeria";

    String RUTA_IR_ORDENCIRUGIA_CONTROL_ENFERMERIA = 
        "irOrdenCirugiaControlEnfermeria";

    String RUTA_IR_INCAPACIDAD_CONTROL_ENFERMERIA = 
        "irIncapacidadControlEnfermeria";

    String RUTA_IR_HOSPITALZACION_CONTROL_ENFERMERIA = 
        "irRemHospitalizacionControlEnfermeria";

    String RUTA_IR_CONTOLSINCOSTO_CONTROL_ENFERMERIA = 
        "irControlSinCostoControlEnfermeria";

    String RUTA_IR_ANATOMIAPATOLOGICA_CONTROL_ENFERMERIA = 
        "irAnatPatologicaControlEnfermeria";

    String RUTA_IR_CERTIFICADO_ASISTENCIA_CONTROL_ENFERMERIA = 
        "irCertificadoAsistenciaControlEnfermeria";

    String RUTA_IR_CERTIFICADOMEDICO_CONTROL_ENFERMERIA = 
        "irCertificadoMedicoControlEnfermeria";

    String RUTA_IR_ELECTROFISIOLOGICO_CONTROL_ENFERMERIA = 
        "irExamenElectrofisiologicosControlEnfermeria";

    String RUTA_IR_IMAGENES_CONTROL_ENFERMERIA = 
        "irExamenImagenesControlEnfermeria";

    String RUTA_IR_LABORATORIO_CONTROL_ENFERMERIA = 
        "irExamenLaboratorioControlEnfermeria";


    String RUTA_IR_REFERENCIA_CONTROL_ENFERMERIA = 
        "irReferenciaControlEnfermeria";

    String RUTA_IR_REFERENCIA_AUTORIZACION_SERVICIO_CONTROL_ENFERMERIA = 
        "irAutorizacionServicioControlEnfermeria";

    String RUTA_IR_RESERVA_SANGRE_CONTROL_ENFERMERIA = 
                "irReservaControlEnfermeria";


    // HISTORIA COLPOSCOPIA 

    String RUTA_IR_DATOS_COLPOSCOPIA = "irDatosColposcopia";

    String RUTA_IR_MOTIVO_COLPOSCOPIA = "irMotivoColposcopia";
    
    
    String RUTA_IR_CUESTIONARIO_COVID_COLPOSCOPIA = "irCuestionarioCovidColposcopia"; 

    String RUTA_IR_INTERCONSULTA_COLPOSCOPIA = "irInterConsultaColposcopia";

    String RUTA_IR_ORDENCIRUGIA_COLPOSCOPIA = "irOrdenCirugiaColposcopia";

    String RUTA_IR_INCAPACIDAD_COLPOSCOPIA = "irIncapacidadColposcopia";

    String RUTA_IR_HOSPITALZACION_COLPOSCOPIA = 
        "irRemHospitalizacionColposcopia";

    String RUTA_IR_FORMULAMEDICA_COLPOSCOPIA = "irFormulaMedicaColposcopia";

    String RUTA_IR_VADEMCUM_COLPOSCOPIA = "irFormulaMedicaColposcopia";

    String RUTA_IR_CONTOLSINCOSTO_COLPOSCOPIA = "irControlSinCostoColposcopia";

    String RUTA_IR_ANATOMIAPATOLOGICA_COLPOSCOPIA = 
        "irAnatPatologicaColposcopia";

    String RUTA_IR_IMPRESION_DIAGNOSTICA_COLPOSCOPIA = 
        "irImpDiagnosticaColposcopia";

    String RUTA_IR_REGISTRAR_COLPOSCOPIA = "irRegistroColposcopia";

    String RUTA_IR_ENCUESTA_VIOLENCIA_COLPOSCOPIA = 
        "irEncuestaViolenciaColposcopia";

    String RUTA_IR_EXAMENFISICO_COLPOSCOPIA = "irExamenFisicoColposcopia";

    String RUTA_IR_ANTECEDENTES_GENERALES_COLPOSCOPIA = 
        "irAntecedentesGeneralesColposcopia";

    String RUTA_IR_ANTECEDENTES_COLPOSCOPIA = "irAntecedentesColposcopia";

    String RUTA_IR_ANTECEDENTES_GINECOLOGICOS_COLPOSCOPIA = 
        "irAntecedentesGinecologicosColposcopia";

    String RUTA_IR_CERTIFICADO_ASISTENCIA_COLPOSCOPIA = 
        "irCertificadoAsistenciaColposcopia";

    String RUTA_IR_CERTIFICADOMEDICO_COLPOSCOPIA = 
        "irCertificadoMedicoColposcopia";

    String RUTA_IR_ELECTROFISIOLOGICO_COLPOSCOPIA = 
        "irExamenElectrofisiologicosColposcopia";

    String RUTA_IR_IMAGENES_COLPOSCOPIA = "irExamenImagenesColposcopia";

    String RUTA_IR_LABORATORIO_COLPOSCOPIA = "irExamenLaboratorioColposcopia";

    String RUTA_IR_RECOMENDACIONES_COLPOSCOPIA = 
        "irRecomendacionesColposcopia";

    String RUTA_IR_REFERENCIA_COLPOSCOPIA = "irReferenciaColposcopia";

    String RUTA_IR_RESERVA_SANGRE_COLPOSCOPIA = "irReservaSangreColposcopia";

    String RUTA_IR_CERRAR_CONSULTA_COLPOSCOPIA = "irCerrarConsultaColposcopia";

    String RUTA_IR_RESUMEN_HISTORIA_ESPECIFICA_COLPOSCOPIA = 
        "irResumenHistoriaEspecificaColposcopia";

    String RUTA_IR_RESUMEN_HISTORIA_COLPOSCOPIA = 
        "irResumenHistoriaColposcopia";

    // ASESORIA

    String RUTA_IR_REGISTRAR_ASESORIA = "irRegistrarUsuarioAsesoria";


    String RUTA_REGISTRAR_ASESORIA_AVISE = "irRegistrarAsesoriaAvise";

    String RUTA_REGISTRAR_SEGUIMIENTO_AVISE = "irRegistrarSeguimientoAvise";

    String RUTA_IR_CONSULTAR_ASESORIA_OPCIONES = "irConsultarAsesoriaOpciones";

    String RUTA_IR_CONSULTAR_ASESORIA = "irConsultarUsuarioAsesoria";


    // OTRAS ASESORIA 

    String RUTA_IR_REGISTRAR_OTRAS_ASESORIAS = "irRegistrarOtrasAsesorias";

    String RUTA_IR_REGISTRAR_ASESORIAS_HUMANITARIA = 
        "irRegistrarAsesoriasHumanitaria";

    String RUTA_IR_REGISTRAR_USUARIO_NUEVA_ASESORIA = 
        "irRegistrarUsuarioNuevaAsesoria";

    String RUTA_IR_REGISTRAR_ASESORIAS_NUEVA = "irRegistrarNuevaAsesoria";

    // REPORTE CITOLOGIA

    String RUTA_IR_REPORTE_CONTRO_CITOLOGIA = "irReporteControlCitologia";

    String RUTA_IR_REPORTE_CONTRO_CITOLOGIA_NACIONAL = 
        "irReporteControlCitologiaNal";

    // REPORTE ASESORIA 

    String RUTA_IR_REPORTE_ASESORIA_ILVE = "irReporteAsesoriaIlve";
    String RUTA_IR_REPORTE_CLINIC_ASESORIA_ILVE = 
        "irReporteClinicAsesoriaIlve";


    // REPORTE AUTORIZACION SERVICIOS

    String RUTA_IR_REPORTE_AUTORIZACION_SERVICIOS = 
        "irReporteAutorizacionServicios";


    // PAMEC

    String RUTA_IR_REGISTRAR_TEMA_PAMEC = "irRegistrarTemaPamec";

    String RUTA_IR_EDITAR_TEMA_PAMEC = "irEditarTemaPamec";


    String RUTA_IR_REGISTRAR_INDICADOR_PAMEC = "irRegistrarIndicadorPamec";

    String RUTA_IR_EDITAR_INDICADOR_PAMEC = "irEditarIndicadorPamec";

    String RUTA_IR_REGISTRAR_PREGUNTAS_PAMEC = "irRegistrarPreguntasPamec";

    String RUTA_IR_EDITAR_PREGUNTA_PAMEC = "irEditarPreguntaPamec";

    String RUTA_IR_CUESTIONARIO_TEMA_PAMEC = "irCuestionarioTemaPamec";

    String RUTA_IR_CUESTIONARIO_INDICADOR_PAMEC = 
        "irCuestionarioIndicadorPamec";

    String RUTA_IR_CUESTIONARIO_PREGUNTA_PAMEC = "irCuestionarioPreguntaPamec";

    String RUTA_IR_REPORTE_PAMEC = "irReportePamec";

    String RUTA_IR_PERMISOS_TEMA_PAMEC = "irPermisosTemaPamec";


    // ESTERILIZACION 

    String RUTA_IR_MOTIVO_FERTILIDAD = "irMotivoFertilidad";

    String RUTA_IR_PARACLINICOS_FERTILIDAD = "irParaclinicosFertilidad";


    String RUTA_IR_DATOS_FERTILIDAD = "irDatosFertilidad";
    
    String RUTA_IR_CUESTIONARIO_COVID_FERTILIDAD = "irCuestionarioCovidFertilidad";

    String RUTA_IR_USUARIO_FERTILIDAD = "irUsuarioFertilidad";

    String RUTA_IR_ECOGRAFIA_FERTILIDAD = "irEcografiaFertilidad";

    String RUTA_IR_INTERCONSULTA_FERTILIDAD = "irInterConsultaFertilidad";

    String RUTA_IR_ORDENCIRUGIA_FERTILIDAD = "irOrdenCirugiaFertilidad";

    String RUTA_IR_INCAPACIDAD_FERTILIDAD = "irIncapacidadFertilidad";

    String RUTA_IR_HOSPITALZACION_FERTILIDAD = 
        "irRemHospitalizacionFertilidad";

    String RUTA_IR_FORMULAMEDICA_FERTILIDAD = "irFormulaMedicaFertilidad";

    String RUTA_IR_VADEMCUM_FERTILIDAD = "irVademecumFertilidad";


    String RUTA_IR_CONTOLSINCOSTO_FERTILIDAD = "irControlSinCostoFertilidad";

    String RUTA_IR_ANATOMIAPATOLOGICA_FERTILIDAD = 
        "irAnatPatologicaFertilidad";

    String RUTA_IR_IMPRESION_DIAGNOSTICA_FERTILIDAD = 
        "irImpDiagnosticaFertilidad";

    String RUTA_IR_ENCUESTA_VIOLENCIA_FERTILIDAD = 
        "irEncuestaViolenciaFertilidad";

    String RUTA_IR_EXAMENFISICO_FERTILIDAD = "irExamenFisicoFertilidad";

    String RUTA_IR_ANTECEDENTES_FERTILIDAD = "irAntecedentesFertilidad";
    
    String RUTA_IR_ANTECEDENTES_DETALLADOS_FERTILIDAD = "irAntecedentesDetalladosFertilidad";

    String RUTA_IR_ANTECEDENTES_GENERALES_FERTILIDAD = 
        "irAntecedentesGeneralesFertilidad";

    String RUTA_IR_ANTECEDENTES_GINECOLOGICOS_FERTILIDAD = 
        "irAntecedentesGinecologicosFertilidad";

    String RUTA_IR_CERTIFICADO_ASISTENCIA_FERTILIDAD = 
        "irCertificadoAsistenciaFertilidad";

    String RUTA_IR_CERTIFICADOMEDICO_FERTILIDAD = 
        "irCertificadoMedicoFertilidad";

    String RUTA_IR_ELECTROFISIOLOGICO_FERTILIDAD = 
        "irExamenElectrofisiologicosFertilidad";

    String RUTA_IR_IMAGENES_FERTILIDAD = "irExamenImagenesFertilidad";

    String RUTA_IR_LABORATORIO_FERTILIDAD = "irExamenLaboratorioFertilidad";

    String RUTA_IR_RECOMENDACIONES_FERTILIDAD = "irRecomendacionesFertilidad";

    String RUTA_IR_REFERENCIA_FERTILIDAD = "irReferenciaFertilidad";

    String RUTA_IR_AUTORIZACION_SERVICIO_FERTILIDAD = 
        "irAutorizacionServicioFertilidad";

    String RUTA_IR_RESERVA_SANGRE_FERTILIDAD = "irReservaSangreFertilidad";

    String RUTA_IR_CERRAR_CONSULTA_FERTILIDAD = "irCerrarConsultaFertilidad";

    String RUTA_IR_RESUMEN_HISTORIA_ESPECIFICA_FERTILIDAD = 
        "irResumenHistoriaEspecificaFertilidad";

    String RUTA_IR_RESUMEN_HISTORIA_FERTILIDAD = "irResumenHistoriaFertilidad";


    // VASECTOMIA    

    String RUTA_IR_DATOS_VASECTOMIA = "irDatosVasectomia";

    String RUTA_IR_CONTROL_ESPERMOGRAMA = "irAplicacionEspermogramaControl";

    String RUTA_IR_RECOMENDACIONES_VASECTOMIA = "irRecomendacionesVasectomia";

    String RUTA_IR_CERRAR_VASECTOMIA = "irCerrarConsultaVasectomia";

    String RUTA_IR_RESUMEN_HISTORIA_CONTROL_VASECTOMIA = 
        "irResumenHistoriaControlVasectomia";

    String RUTA_IR_MEDICO_ESPERMOGRAMA = "irAplicacionEspermogramaMedico";

    // ESPERMOGRAMA FERTILIDAD    

    String RUTA_IR_DATOS_ESPERMOGRAMA_FERTILIDAD = 
        "irDatosEspermogramaFertilidad";

    String RUTA_IR_ESPERMOGRAMA_FERTILIDAD = "irEspermogramaFertilidad";

    // CONFIRMAR CIRUGIA

    String RUTA_IR_DATOS_CONFIRMACION_HISTORIA = 
        "irDatosUsuarioConfirmarCirugia";

    String RUTA_IR_CONFIRMACION_PRESTACION = "irConfirmacionPrestacion";

    String RUTA_IR_CERRAR_CONSULTA_CONFIRMACION = 
        "irCerrarConsultaConfirmacion";


 // SOLICITUD Y ACLARACION NOTA ACLARATORIA
 
  String RUTA_IR_AUTORIZACION_NOTA_ACLARATORIA= "irAutorizacionNotaAcalaratoria";

  String RUTA_IR_SOLICITUD_NOTA_ACLARATORIA=  "irSolicitudNotaAclaratoria";

  String RUTA_SOLICITAR_NOTA_ACLARATORIA = "irSolicitarNotaAclaratoria";
  
  String RUTA_APROBAR_NOTA_ACLARATORIA = "irAprobarNotaAclaratoria";


    //  SOLICITUD Y AUTORIZACION 

    String RUTA_IR_AUTORIZAR_REGISTROS = "irAutorizacionRegistros";

    String RUTA_IR_SOLICITUD_AUTORIZACION_REGISTROS =  "irSolicitudAutorizacionRegistros";

    String RUTA_SOLICITAR_ACLARACION_DQX = "irSolicitarAclaracionDescripcion";
    
    String RUTA_APROBAR_ACLARACION_DQX = "irAprobarAclaracionDescripcion";

    String RUTA_SOLICITAR_ACLARACION_EPICRISIS = 
        "irSolicitarAclaracionEpicrisis";


    

    String RUTA_IR_SOLICITUD_AUTORIZACION_EPICRISIS = 
        "irSolicitudAutorizacionEpicrisis";

    String RUTA_APROBAR_ACLARACION_EPICRISIS = "irAprobarAclaracionEpicrisis";
    
    String RUTA_IR_CERTIFICADO_ASISTENCIA_ADMIN = "irgenerarCertAsisAdm";

    // CARGAR DATOS

    String RUTA_IR_UPLOAD = "irUpload";


    // INFORMACION SERVICIOS SAP

    String RUTA_IR_INFORMACION_SERVICIO = "irinformacionServicios";


    // CREACION DE SALAS DE CIRUGIA

    String RUTA_IR_REGISTRAR_SALAS_CIRUGIA = "irRegistrarSalaCirugia";


    // RESUMEN CIRUGIA

    String RUTA_IR_CONSULTAR_FOLIOS_CIRUGIA = "irConsultarFoliosCirugia";

    String RUTA_IR_CONSULTAR_FOLIOS_USUARIO_CIRUGIA = 
        "irConsultarFoliosUsuarioCirugia";

    String RUTA_IR_CONSULTAR_FOLIOS_USUARIO_CIRUGIA_DQX = 
        "irConsultarFoliosUsuarioCirugiaDqx";


    String RUTA_IR_CONSULTAR_USUARIO_FOLIOS_CIRUGIA = 
        "irConsultarUsuarioFoliosCirugia";

    String RUTA_IR_CONS_CANCELACION_CIRUGIA = "irConsultarCancelacionCirugia";


    String RUTA_IR_GENERAR_FOLIOS_CIRUGIA = "irGenerarFoliosUsuario";

    String RUTA_IR_GENERAR_RESUMEN_FOLIOS_CIRUGIA_MEDICO = 
        "irConsultaResumenFoliosMedico";

    String RUTA_IR_GENERAR_RESUMEN_FOLIOS_CIRUGIA_ANESTESIA = 
        "irConsultaResumenFoliosAnestesia";

    String RUTA_IR_GENERAR_RESUMEN_FOLIOS_CIRUGIA_ENFERMERIA = 
        "irConsultaResumenFoliosEnfermera";

    String RUTA_IR_CONSULTAR_FOLIOS_CIRUGIA_MEDICO = 
        "irConsultarFoliosUsuarioCirugiaMedico";

    String RUTA_IR_GENERAR_RESUMEN_FOLIOS_CIRUGIA_ENFERMERA = 
        "irConsultarFoliosUsuarioCirugiaEnfermera";

    String RUTA_IR_GENERAR_RESUMEN_FOLIOS_CIRUGIA_INGRESO_ENFERMERIA = 
        "irConsultarFoliosUsuarioCirugiaIngresoEnfermeria";

    String RUTA_IR_GENERAR_FOLIOS_INGRESO_ENFERMERIA = 
        "irConsultaResumenFoliosIngresoEnfermeria";


    // INSTRUMENTADOR

    String RUTA_IR_INSTRUMENTADOR = "irInstrumentadorCirugia";

    String RUTA_REGISTRAR_DETALLE_INSTRUMENTADOR = "irDetalleInstrumentador";


    String RUTA_IR_REGISTRAR_PAQUETE_INSTRUMENTAL = 
        "irRegistrarPaqueteInstrumental";

    String RUTA_IR_REGISTRAR_MATERIAL_INSTRUMENTAL = 
        "irRegistrarMaterialInstrumental";


    String RUTA_IR_EDITAR_MATERIAL_INSTRUMENTAL = 
        "irEditarMaterialInstrumental";

    String RUTA_IR_EDITAR_PAQUETE_INSTRUMENTAL = "irEditarPaqueteInstrumental";

    // MODULO DE ANESTESIA


    String RUTA_IR_REGISTRAR_ANESTESIA = "irRegistrarAnestesia";

    String RUTA_IR_REGISTRAR_SIGNOS_VITALES_ANESTESIA = 
        "irRegistrarSignosVitalesAnestesia";

    String RUTA_IR_REGISTRAR_MONITORIA_ANESTESIA = 
        "irRegistrarMonitoriaAnestesia";

    String RUTA_IR_REGISTRAR_BALANCE_LIQUIDOS_ANESTESIA = 
        "irRegistrarBalanceLiquidosAnestesia";

    String RUTA_IR_REGISTRAR_CONTROL_MEDICAMENTOS_ANESTESIA = 
        "irRegistrarControlMedicamentosAnestesia";

    String RUTA_IR_REGISTRAR_TECNICA_ANESTESIA = "irRegistrarTecnicaAnestesia";

    String RUTA_IR_REGISTRAR_VIA_AEREA_ANESTESIA = 
        "irRegistrarViaAereaAnestesia";

    String RUTA_IR_REGISTRAR_MEDIDAS_PROTECCION_ANESTESIA = 
        "irRegistrarMedidasProteccionAnestesia";

    String RUTA_IR_CERRAR_ANESTESIA = "irCerrarAnestesia";

    String RUTA_IR_RESUMEN_HISTORIA_ANESTESIA_CIRUGIA = 
        "irResumenCirugiaAnestesia";

    String RUTA_IR_RESUMEN_HISTORIA_DESCRIPCION_CIRUGIA =   "irResumenCirugiaDescripcion";

    String RUTA_IR_FORMULA_LIQUIDOS_ANESTESIA = "irFormulaLiquidosAnestesia";

    String RUTA_IR_FORMULA_HOSPITALIZACION_ANESTESIA = 
        "irFormulaHospitalizacionAnestesia";

    String RUTA_IR_OTRAS_ORDENES_ANESTESIA = "irOtrasOrdenesAnestesia";


    /*  String RUTA_IR_REGISTRAR_MEDIDA_PROFILACTICA =
        "irRegistrarMedidaProfilactica";

    String RUTA_IR_REGISTRAR_MONITORIZACION = "irRegistrarMonitorizacion";

    String RUTA_IR_REGISTRAR_TECNICA_ANESTESIA = "irRegistrarTecnicaAnestesia";

    String RUTA_IR_REGISTRAR_CONTROL_VIA_AEREA = "irRegistrarControlViaAerea";

    String RUTA_IR_REGISTRAR_SIGNOS_VITALES =
        "irRegistrarSignosVitalesAnestesia";*/


    String RUTA_IR_MOTIVO_EFECTO_JOVEN = "irMotivoEfectoJoven";
    
    String RUTA_IR_CUESTIONARIO_COVID_EFECTO_JOVEN = "irCuestionarioCovidEfectoJoven";


    String RUTA_IR_DATOS_EFECTO_JOVEN = "irDatosEfectoJoven";

    String RUTA_IR_INTERCONSULTA_EFECTO_JOVEN = "irInterConsultaEfectoJoven";


    String RUTA_IR_FORMULAMEDICA_EFECTO_JOVEN = "irFormulaMedicaEfectoJoven";

    String RUTA_IR_VADEMCUM_EFECTO_JOVEN = "irVademecumEfectoJoven";


    String RUTA_IR_IMPRESION_DIAGNOSTICA_EFECTO_JOVEN = 
        "irImpDiagnosticaEfectoJoven";

    String RUTA_IR_ENCUESTA_VIOLENCIA_EFECTO_JOVEN = 
        "irEncuestaViolenciaEfectoJoven";

    String RUTA_IR_EXAMENFISICO_EFECTO_JOVEN = "irExamenFisicoEfectoJoven";

    String RUTA_IR_ANTECEDENTES_EFECTO_JOVEN = "irAntecedentesEfectoJoven";

    String RUTA_IR_ANTECEDENTES_GENERALES_EFECTO_JOVEN = 
        "irAntecedentesGeneralesEfectoJoven";

    String RUTA_IR_ANTECEDENTES_GINECOLOGICOS_EFECTO_JOVEN = 
        "irAntecedentesGinecologicosEfectoJoven";


    String RUTA_IR_RECOMENDACIONES_EFECTO_JOVEN = 
        "irRecomendacionesEfectoJoven";


    String RUTA_IR_CERRAR_CONSULTA_EFECTO_JOVEN = 
        "irCerrarConsultaEfectoJoven";

    String RUTA_IR_RESUMEN_HISTORIA_EFECTO_JOVEN = 
        "irResumenHistoriaEfectoJoven";


    String REGISTRAR_USUARIO_SAP = "irRegistrarUsuarioSAP";


    String RUTA_IR_SEGUIMIENTO_TELEFONICO = "irSeguimientoTelefonico";

    String RUTA_IR_CONSULTA_SEGUIMIENTO_TELEFONICO = 
        "irconsultarSeguimientoTelefonico";

    String RUTA_IR_CONSULTA_USUARIO_SEGUIMIENTO_TELEFONICO = 
        "irconsultaUsuarioSeguimientoTelefonico";

    String RUTA_IR_REGISTRAR_CIRUGIA_SIN_FACTURA = 
        "irregistrarCirugiaSinFactura";

    String RUTA_IR_CONSULTA_USUARIO_CIRUGIA_SIN_FACTURA = 
        "irconsultaUsuarioCirugiaSinFactura";


    String RUTA_IR_ACTIVIDAD_EDUCTAIVA = "irRegistrarActividadEducativa";

    String RUTA_IR_REPORTE_ILVE = "irReporteIlve";

    String RUTA_IR_REPORTE_ILVE_NACIONAL = "irReporteIlveNacional";

    String RUTA_IR_REPORTE_RESOLUCION_256 = "irReporteResolucion256";


    /* Reporte Verificaci�n Quirofano */

    String RUTA_IR_REGISTRAR_PARAMETRO_VERIFICACION_QUIROFANO = 
        "irRegistrarParametroVerificacionQuirofano";

    String RUTA_IR_REGISTRAR_SALA_CIRUGIA = "irRegistrarSalaCirugia";

    String RUTA_IR_REGISTRAR_VERIFICACION_QUIROFANO_ENFERMERA = 
        "irVerificarQuirofanoEnfermera";

    String RUTA_IR_LISTA_VERIFICACION_QUIROFANO_ENFERMERA = 
        "irListaVerificarQuirofanoEnfermera";

    String RUTA_IR_LISTA_VERIFICACION_QUIROFANO_MEDICO = 
        "irListaVerificarQuirofanoMedico";

    String RUTA_IR_REGISTRAR_VERIFICACION_QUIROFANO_MEDICO = 
        "irVerificarQuirofanoMedico";

    String RUTA_IR_LISTA_CIRUGIA_SIN_FACTURA = "irListaCirugiaSinFactura";

    String RUTA_IR_CONFIRMAR_CIRUGIA_SIN_FACTURA = 
        "irConfirmarCirugiaSinFactura";

    String RUTA_IR_CONFIRMAR_REFERENCIA = "irConfirmarReferencia";

    String RUTA_IR_LISTA_CONFIRMAR_REFERENCIA = "irListaConfirmarReferencia";


    String RUTA_IR_REGISTRAR_TIPO_SERVICIO = "irRegistrarTipoServicio";

    String RUTA_ASIGNAR_SERVICIO_X_TIPO = "irAsignarServicioXTipo";
    

    // DATOS DE LA HISTORIA DE APLICACION DE MEDICAMENTOS

    String RUTA_IR_LISTA_MEDICAMENTO = "irListaMedicamento";
    String RUTA_IR_DATOS_MEDICAMENTO = "irDatosMedicamento";
    String RUTA_IR_CERRAR_CONSULTA_MEDICAMENTO = "irCerrarConsultaMedicamento";
    String RUTA_IR_APLICACION_MEDICAMENTO = "irAplicacionMedicamento";
    String RUTA_IR_ANTECEDENTES_MEDICAMENTO = "irAntecedentesMedicamento";
    String RUTA_IR_ANTECEDENTES_GENERALES_MEDICAMENTO = 
        "irAntecedentesGeneralesMedicamento";
    String RUTA_IR_ACTIVIDAD_MEDICAMENTO = "irActividadMedicamento";
    String RUTA_IR_DATOS_ADICIONALES_MEDICAMENTO = "irDatosAdicionalesMedicamento";

    // VADEMECUM

    String RUTA_IR_REGISTRAR_VADEMECUM = "irRegistrarVademecum";


    // CONSULTA IVE SIN FACTURA

    String RUTA_IR_CONSULTA_SIN_FACTURA = "irConsultaSinFactura";
    String RUTA_IR_REGISTRAR_CONSULTA_SIN_FACTURA = 
        "irRegistrarConsultaSinFactura";
    String RUTA_IR_CONFIRMAR_CONSULTA_SIN_FACTURA = "irConfirmarSinFactura";
    String RUTA_IR_LISTA_CONSULTA_SIN_FACTURA = "irListaSinFactura";
   

    // HISTORIA PROCEDIMIENTOS EN CONSULTORIO IVE


    String RUTA_IR_DATOS_PROCEDIMIENTO_IVE = "irDatosProcedimientoIve";

    String RUTA_IR_INTERCONSULTA_PROCEDIMIENTO_IVE = 
        "irInterConsultaProcedimientoIve";

    String RUTA_IR_ORDENCIRUGIA_PROCEDIMIENTO_IVE = 
        "irOrdenCirugiaProcedimientoIve";

    String RUTA_IR_INCAPACIDAD_PROCEDIMIENTO_IVE = 
        "irIncapacidadProcedimientoIve";

    String RUTA_IR_HOSPITALZACION_PROCEDIMIENTO_IVE = 
        "irRemHospitalizacionProcedimientoIve";

    String RUTA_IR_FORMULAMEDICA_PROCEDIMIENTO_IVE = 
        "irFormulaMedicaProcedimientoIve";

    String RUTA_IR_VADEMCUM_PROCEDIMIENTO_IVE = "irVademecumProcedimientoIve";


    String RUTA_IR_CONTOLSINCOSTO_PROCEDIMIENTO_IVE = 
        "irControlSinCostoProcedimientoIve";

    String RUTA_IR_ANATOMIAPATOLOGICA_PROCEDIMIENTO_IVE = 
        "irAnatPatologicaProcedimientoIve";

    String RUTA_IR_CERTIFICADO_ASISTENCIA_PROCEDIMIENTO_IVE = 
        "irCertificadoAsistenciaProcedimientoIve";

    String RUTA_IR_CERTIFICADOMEDICO_PROCEDIMIENTO_IVE = 
        "irCertificadoMedicoProcedimientoIve";

    String RUTA_IR_ELECTROFISIOLOGICO_PROCEDIMIENTO_IVE = 
        "irExamenElectrofisiologicosProcedimientoIve";

    String RUTA_IR_IMAGENES_PROCEDIMIENTO_IVE = 
        "irExamenImagenesProcedimientoIve";

    String RUTA_IR_LABORATORIO_PROCEDIMIENTO_IVE = 
        "irExamenLaboratorioProcedimientoIve";

    String RUTA_IR_RECOMENDACIONES_PROCEDIMIENTO_IVE = 
        "irRecomendacionesProcedimientoIve";

    String RUTA_IR_REFERENCIA_PROCEDIMIENTO_IVE = 
        "irReferenciaProcedimientoIve";

    String RUTA_IR_RESERVA_SANGRE_PROCEDIMIENTO_IVE = 
        "irReservaSangreProcedimientoIve";

    String RUTA_IR_PROCEDIMIENTO_IVE = "irProcedimientoIveUsuario";
    
    String RUTA_IR_CUESTIONARIO_COVIDPROCEDIMIENTO_IVE = "irCuestionarioCovidProcedimientoIve"; 

    String RUTA_IR_ANTECEDENTES_TEMPORALES_IVE = 
        "irAntecedentesTemporalesIveUsuario";
        
    String RUTA_IR_CERRAR_CONSULTA_PROCEDIMIENTO_IVE = 
        "irCerrarConsultaProcedimientoIve";
        
        
    String RUTA_IR_ORDEN_MEDICAMENTOS_PROCEDIMIENTO_IVE    = "irOrdenMedicamentosProcedimientoIve";
    
    String RUTA_IR_ORDEN_LIQUIDOS_PROCEDIMIENTO_IVE    = "irOrdenLiquidosProcedimientoIve";
    
    String RUTA_IR_OTRAS_ORDENES_PROCEDIMIENTO_IVE = "irOtrasOrdenesProcedimientoIve"; 
            
        
    String RUTA_IR_REGISTRO_USUARIO_COMPLEMENTARIO = "irRegistroUsuarioComplementario";

    String RUTA_IR_REGISTRAR_COMPLEMENTARIO = "irRegistrarComplementario";
        
    String RUTA_IR_REGISTRO_USUARIO_TELEFONICO = "irRegistroUsuarioTelefonico";

    String RUTA_IR_REGISTRAR_TELEFONICO = "irRegistrarTelefonico";
    
    String RUTA_IR_CONFIRMAR_INSUMOS_SALUD_SEXUAL = "irConsultarInsumosSaludSexual";
    
    String RUTA_IR_PAUSAR_CONSULTA_ANTICONCEPCION_ENFERMERIA = "irPausarConsultaAnticoncepcionEnfermeria";
    String RUTA_IR_PAUSAR_CONSULTA_ANTICONCEPCION_ENFERMERIA_INSERCION = "irPausarConsultaAnticoncepcionEnfermeriaInsercion";
    String RUTA_IR_PAUSAR_CONSULTA_ANTICONCEPCION_ENFERMERIA_RETIRO = "irPausarConsultaAnticoncepcionEnfermeriaRetiro";
    String RUTA_IR_PAUSAR_CONSULTA_CONTROL_ANTICONCEPCION_ENFERMERIA = "irPausarConsultaControlAnticoncepcionEnfermeria";
    String RUTA_IR_PAUSAR_CONSULTA_CONTROL_ENFERMERIA = "irPausarConsultaControlEnfermeria";
    
    String RUTA_IR_PAUSAR_CONSULTA_ANTICONCEPCION_INSERCION = "irPausarConsultaAnticoncepcionInsercion";
    String RUTA_IR_PAUSAR_CONSULTA_ANTICONCEPCION_RETIRO = "irPausarConsultaAnticoncepcionRetiro";
    String RUTA_IR_PAUSAR_CONSULTA_ANTICONCEPCION_TEMPORAL = "irPausarConsultaAnticoncepcionTemporal";
    String RUTA_IR_PAUSAR_CONSULTA_CERVIX = "irPausarConsultaCervix";
    String RUTA_IR_PAUSAR_CONSULTA_CERVIX_VACUNACION = "irPausarConsultaCervixVacunacion";
    String RUTA_IR_PAUSAR_CONSULTA_COLPOSCOPIA = "irPausarConsultaColposcopia";
    String RUTA_IR_PAUSAR_CONSULTA_CONFIRMACION = "irPausarConsultaConfirmacion";
    
    String RUTA_IR_PAUSAR_CONSULTA_CONTROL = "irPausarConsultaControl";
    String RUTA_IR_PAUSAR_CONSULTA_CONTROL_EXAMEN_MAMA = "irPausarConsultaControlExamenMama";
    String RUTA_IR_PAUSAR_CONSULTA_CONTROL_DERMATOLOGIA = "irPausarConsultaControlDermatologia";
    String RUTA_IR_PAUSAR_CONSULTA_CONTROL_ANTICONCEPCION_TEMPORAL = "irPausarConsultaControlAnticoncepcionTemporal";
    String RUTA_IR_PAUSAR_CONSULTA_CONTROL_FERTILIDAD = "irPausarConsultaControlFertilidad";
    String RUTA_IR_PAUSAR_CONSULTA_CONTROL_PREANESTESIA = "irPausarConsultaControlPreanestesia";
    String RUTA_IR_PAUSAR_CONSULTA_CONTROL_PRENATAL = "irPausarConsultaControlPrenatal";
    String RUTA_IR_PAUSAR_CONSULTA_CONTROL_VASECTOMIA = "irPausarConsultaControlVasectomia";
    
    String RUTA_IR_PAUSAR_CONSULTA_EFECTO_JOVEN = "irPausarConsultaControlEfectoJoven";
    String RUTA_IR_PAUSAR_CONSULTA_ESPERMOGRAMA = "irPausarConsultaEspermograma";
    String RUTA_IR_PAUSAR_CONSULTA_ESPERMOGRAMA_FERTILIDAD = "irPausarConsultaEspermogramaFertilidad";
    String RUTA_IR_PAUSAR_CONSULTA_ESTERILIZACION_FEMENINA = "irPausarConsultaEsterilizacionFemenina";
    String RUTA_IR_PAUSAR_CONSULTA_ESTERILIZACION_MASCULINA = "irPausarConsultaEsterilizacionMasculina";
    String RUTA_IR_PAUSAR_CONSULTA_EXAMEN_MAMA = "irPausarConsultaExamenMama";
    String RUTA_IR_PAUSAR_CONSULTA_FERTILIDAD = "irPausarConsultaFertilidad";
    
    String RUTA_IR_PAUSAR_CONSULTA_INTERRUPCION = "irPausarConsultaInterrupcion";
    String RUTA_IR_PAUSAR_CONSULTA_INTERRUPCION_CONTROL = "irPausarConsultaInterrupcionControl";
    String RUTA_IR_PAUSAR_CONSULTA_MEDICAMENTOS = "irPausarConsultaMedicamentos";
    String RUTA_IR_PAUSAR_CONSULTA_OTRAS_ESPECIALIDADES = "irPausarConsultaOtrasEspecialidades";
    
    String RUTA_IR_PAUSAR_CONSULTA_PEDIATRIA = "irPausarConsultaPediatria";    
    String RUTA_IR_PAUSAR_CONSULTA_PREANESTESIA = "irPausarConsultaPreanestesia";
    String RUTA_IR_PAUSAR_CONSULTA_PRENATAL = "irPausarConsultaPrenatal";
    String RUTA_IR_PAUSAR_CONSULTA_NUEVO_PRENATAL = "irPausarConsultaPrenatal";
    String RUTA_IR_PAUSAR_CONSULTA_PROCEDIMIENTOS_CONSULTORIO = "irPausarConsultaProcedimientosConsultorio";
    String RUTA_IR_PAUSAR_CONSULTA_PROCEDIMIENTOS_IVE = "irPausarConsultaProcedimientosIve";
    String RUTA_IR_PAUSAR_CONSULTA_PSICOLOGICA = "irPausarConsultaPsicologica";
    String RUTA_IR_PAUSAR_CONSULTA_PSICOLOGICA_CONTROL = "irPausarConsultaPsicologicaControl";
    
    String RUTA_IR_PAUSAR_CONSULTA_SALUD_SEXUAL = "irPausarConsultaSaludSexual";
    String RUTA_IR_PAUSAR_CONSULTA_VACUNACION = "irPausarConsultaVacunacion";
    
    String RUTA_IR_PAUSAR_CONSULTA_CITOPUNCION = "irPausarConsultaCitopuncion";
    String RUTA_IR_PAUSAR_CONSULTA_ECOGRAFIA = "irPausarConsultaEcografia";
    String RUTA_IR_PAUSAR_CONSULTA_HISTEROSONOGRAFIA = "irPausarConsultaHisterosonografia";
    String RUTA_IR_PAUSAR_CONSULTA_MAMOGRAFIA = "irPausarConsultaMamografia";
    String RUTA_IR_PAUSAR_CONSULTA_MARCACION_SENO = "irPausarConsultaMarcacionSeno";
    
    String RUTA_IR_SERVICIOS_ADMISION_SALUD_SEXUAL = "irServiciosAdmisionSaludSexual";
    
    String RUTA_IR_SERVICIOS_ADMISION_ANTICONCEPCION_ENFERMERIA = "irServiciosAdmisionAnticoncepcionEnfermeria";
    String RUTA_IR_SERVICIOS_ADMISION_ANTICONCEPCION_ENFERMERIA_INSERCION = "irServiciosAdmisionAnticoncepcionEnfermeriaInsercion";
    String RUTA_IR_SERVICIOS_ADMISION_ANTICONCEPCION_ENFERMERIA_RETIRO = "irServiciosAdmisionAnticoncepcionEnfermeriaRetiro";
    String RUTA_IR_SERVICIOS_ADMISION_CONTROL_ANTICONCEPCION_ENFERMERIA = "irServiciosAdmisionControlAnticoncepcionEnfermeria";
    String RUTA_IR_SERVICIOS_ADMISION_CONTROL_ENFERMERIA = "irServiciosAdmisionControlEnfermeria";
    
    String RUTA_IR_SERVICIOS_ADMISION_ANTICONCEPCION_INSERCION = "irServiciosAdmisionAnticoncepcionInsercion";
    String RUTA_IR_SERVICIOS_ADMISION_ANTICONCEPCION_RETIRO = "irServiciosAdmisionAnticoncepcionRetiro";
    String RUTA_IR_SERVICIOS_ADMISION_ANTICONCEPCION_TEMPORAL = "irServiciosAdmisionAnticoncepcionTemporal";
    String RUTA_IR_SERVICIOS_ADMISION_CERVIX = "irServiciosAdmisionCervix";
    String RUTA_IR_SERVICIOS_ADMISION_CERVIX_VACUNACION = "irServiciosAdmisionCervixVacunacion";
    String RUTA_IR_SERVICIOS_ADMISION_COLPOSCOPIA = "irServiciosAdmisionColposcopia";
    String RUTA_IR_SERVICIOS_ADMISION_CONFIRMACION = "irServiciosAdmisionConfirmacion";
    
    String RUTA_IR_SERVICIOS_ADMISION_CONTROL = "irServiciosAdmisionControl";
    String RUTA_IR_SERVICIOS_ADMISION_CONTROL_DERMATOLOGIA = "irServiciosAdmisionControlDermatologia";
    String RUTA_IR_SERVICIOS_ADMISION_CONTROL_EXAMEN_MAMA = "irServiciosAdmisionControlExamenMama";
    String RUTA_IR_SERVICIOS_ADMISION_CONTROL_ANTICONCEPCION_TEMPORAL = "irServiciosAdmisionControlAnticoncepcionTemporal";
    String RUTA_IR_SERVICIOS_ADMISION_CONTROL_FERTILIDAD = "irServiciosAdmisionControlFertilidad";
    String RUTA_IR_SERVICIOS_ADMISION_CONTROL_GINECOLOGIA = "irServiciosAdmisionControlGinecologia";
    String RUTA_IR_SERVICIOS_ADMISION_CONTROL_UROLOGIA = "irServiciosAdmisionControlUrologia";
    String RUTA_IR_SERVICIOS_ADMISION_CONTROL_PREANESTESIA = "irServiciosAdmisionControlPreanestesia";
    String RUTA_IR_SERVICIOS_ADMISION_CONTROL_PRENATAL = "irServiciosAdmisionControlPrenatal";
    String RUTA_IR_SERVICIOS_ADMISION_CONTROL_VASECTOMIA = "irServiciosAdmisionControlVasectomia";
    
    String RUTA_IR_SERVICIOS_ADMISION_EFECTO_JOVEN = "irServiciosAdmisionControlEfectoJoven";
    String RUTA_IR_SERVICIOS_ADMISION_ESPERMOGRAMA = "irServiciosAdmisionEspermograma";
    String RUTA_IR_SERVICIOS_ADMISION_ESPERMOGRAMA_FERTILIDAD = "irServiciosAdmisionEspermogramaFertilidad";
    String RUTA_IR_SERVICIOS_ADMISION_ESTERILIZACION_FEMENINA = "irServiciosAdmisionEsterilizacionFemenina";
    String RUTA_IR_SERVICIOS_ADMISION_ESTERILIZACION_MASCULINA = "irServiciosAdmisionEsterilizacionMasculina";
    String RUTA_IR_SERVICIOS_ADMISION_EXAMEN_MAMA = "irServiciosAdmisionExamenMama";
    String RUTA_IR_SERVICIOS_ADMISION_FERTILIDAD = "irServiciosAdmisionFertilidad";
    
    String RUTA_IR_SERVICIOS_ADMISION_INTERRUPCION = "irServiciosAdmisionInterrupcion";
    String RUTA_IR_SERVICIOS_ADMISION_INTERRUPCION_CONTROL = "irServiciosAdmisionInterrupcionControl";
    String RUTA_IR_SERVICIOS_ADMISION_MEDICAMENTOS = "irServiciosAdmisionMedicamentos";
    String RUTA_IR_SERVICIOS_ADMISION_PRUEBAS_RAPIDAS = "irServiciosAdmisionPruebasRapidas";
    String RUTA_IR_SERVICIOS_ADMISION_OTRAS_ESPECIALIDADES = "irServiciosAdmisionOtrasEspecialidades";
    
    String RUTA_IR_SERVICIOS_ADMISION_PEDIATRIA = "irServiciosAdmisionPediatria";    
    String RUTA_IR_SERVICIOS_ADMISION_PREANESTESIA = "irServiciosAdmisionPreanestesia";
    String RUTA_IR_SERVICIOS_ADMISION_PRENATAL = "irServiciosAdmisionPrenatal";
    String RUTA_IR_SERVICIOS_ADMISION_PROCEDIMIENTOS_CONSULTORIO = "irServiciosAdmisionProcedimientosConsultorio";
    String RUTA_IR_SERVICIOS_ADMISION_PROCEDIMIENTOS_IVE = "irServiciosAdmisionProcedimientosIve";
    String RUTA_IR_SERVICIOS_ADMISION_PSICOLOGICA = "irServiciosAdmisionPsicologica";
    String RUTA_IR_SERVICIOS_ADMISION_PSICOLOGICA_CONTROL = "irServiciosAdmisionPsicologicaControl";

    String RUTA_IR_SERVICIOS_ADMISION_VACUNACION = "irServiciosAdmisionVacunacion";
    String RUTA_IR_SERVICIOS_ADMISION_CITOPUNCION = "irServiciosAdmisionCitopuncion";
    String RUTA_IR_SERVICIOS_ADMISION_ECOGRAFIA = "irServiciosAdmisionEcografia";
    String RUTA_IR_SERVICIOS_ADMISION_HISTEROSONOGRAFIA = "irServiciosAdmisionHisterosonografia";
    String RUTA_IR_SERVICIOS_ADMISION_MAMOGRAFIA = "irServiciosAdmisionMamografia";
    String RUTA_IR_SERVICIOS_ADMISION_MARCACION_SENO = "irServiciosAdmisionMarcacionSeno";
    
    String RUTA_IR_ORDEN_LIQUIDOS_CONTROL = "irOrdenLiquidosControl";
    String RUTA_IR_OTRAS_ORDENES_CONTROL = "irOtrasOrdenesControl"; 
    String RUTA_IR_ORDEN_MEDICAMENTOS_CONTROL = "irOrdenMedicamentosControl";
    String RUTA_IR_GESTION_LABORATORIO = "irgestionLaboratorio";
    
    String RUTA_IR_LISTA_USUARIO_NOTA_ENFERMERIA = "irListaUsuarioNotaEnfermeria";
    
    String RUTA_IR_REPORTE_VINISO = "irReporteViniso";
    
    String RUTA_IR_CERRAR_NOTA_ENFERMERIA_PROCEDIMIENTO = "irCerrarNotaEnfermeria";
    
    
    // HISTORIA CONTROL ENTREGA RESULTADO


       String RUTA_IR_DATOS_CONTROL_ENTREGA_RESULTADO= "irDatosControlEntregaResultado";

       String RUTA_IR_MOTIVO_CONTROL_ENTREGA_RESULTADO = "irMotivoControlEntregaResultado";

       String RUTA_IR_EXAMEN_FISICO_CONTROL_ENTREGA_RESULTADO = "irExamenFisicoControlEntregaResultado";

       String RUTA_IR_INTERCONSULTA_CONTROL_ENTREGA_RESULTADO = "irInterConsultaControlEntregaResultado";

       String RUTA_IR_ORDENCIRUGIA_CONTROL_ENTREGA_RESULTADO = "irOrdenCirugiaControlEntregaResultado";

       String RUTA_IR_INCAPACIDAD_CONTROL_ENTREGA_RESULTADO = "irIncapacidadControlEntregaResultado";

       String RUTA_IR_HOSPITALZACION_CONTROL_ENTREGA_RESULTADO = "irRemHospitalizacionControlEntregaResultado";

       String RUTA_IR_AUTORIZACION_SERVICIOS_CONTROL_ENTREGA_RESULTADO = "irAutorizacionServicioControlEntregaResultado";

       String RUTA_IR_FORMULAMEDICA_CONTROL_ENTREGA_RESULTADO = "irFormulaMedicaControlEntregaResultado";

       String RUTA_IR_VADEMCUM_CONTROL_ENTREGA_RESULTADO = "irVademecumControlEntregaResultado";


       String RUTA_IR_CONTOLSINCOSTO_CONTROL_ENTREGA_RESULTADO = "irControlSinCostoControlEntregaResultado";

       String RUTA_IR_ANATOMIAPATOLOGICA_CONTROL_ENTREGA_RESULTADO = "irAnatPatologicaControlEntregaResultado";

       String RUTA_IR_APLICACION_RETITO_CONTROL_ENTREGA_RESULTADO = "irAplicacionRetiroControlEntregaResultado";

       String RUTA_IR_IMPRESION_DIAGNOSTICA_CONTROL_ENTREGA_RESULTADO = "irImpDiagnosticaControlEntregaResultado";

       String RUTA_IR_CONTROL_USUARIO_ENTREGA_RESULTADO = "irControlUsuarioEntregaResultado";

       String RUTA_IR_ANTECEDENTES_CONTROL_ENTREGA_RESULTADO = "irAntecedentesControlEntregaResultado";

       String RUTA_IR_ANTECEDENTES_GENERALES_CONTROL_ENTREGA_RESULTADO = "irAntecedentesGeneralesControlEntregaResultado";

       String RUTA_IR_CERTIFICADO_ASISTENCIA_CONTROL_ENTREGA_RESULTADO = "irCertificadoAsistenciaControlEntregaResultado";

       String RUTA_IR_CERTIFICADOMEDICO_CONTROL_ENTREGA_RESULTADO = "irCertificadoMedicoControlEntregaResultado";

       String RUTA_IR_ELECTROFISIOLOGICO_CONTROL_ENTREGA_RESULTADO = "irExamenElectrofisiologicosControlEntregaResultado";

       String RUTA_IR_IMAGENES_CONTROL_ENTREGA_RESULTADO = "irExamenImagenesControlEntregaResultado";

       String RUTA_IR_LABORATORIO_CONTROL_ENTREGA_RESULTADO = "irExamenLaboratorioControlEntregaResultado";

       String RUTA_IR_RECOMENDACIONES_CONTROL_ENTREGA_RESULTADO = "irRecomendacionesControlEntregaResultado";

       String RUTA_IR_REFERENCIA_CONTROL_ENTREGA_RESULTADO = "irReferenciaControlEntregaResultado";

       String RUTA_IR_RESERVA_SANGRE_CONTROL_ENTREGA_RESULTADO = "irReservaSangreControlEntregaResultado";

       String RUTA_IR_CERRAR_CONTROL_ENTREGA_RESULTADO = "irCerrarConsultaControlEntregaResultado";

       String RUTA_IR_RESUMEN_HISTORIA_ESPECIFICA_CONTROL_ENTREGA_RESULTADO = "irResumenHistoriaEspecificaControlEntregaResultado";

       String RUTA_IR_RESUMEN_HISTORIA_CONTROL_ENTREGA_RESULTADO = "irResumenHistoriaControlEntregaResultado";
       
       String RUTA_IR_SERVICIOS_ADMISION_CONTROL_ENTREGA_RESULTADO = "irServiciosAdmisionControlEntregaResultado";
       
       String RUTA_IR_ORDEN_LIQUIDOS_CONTROL_ENTREGA_RESULTADO = "irOrdenLiquidosControlEntregaResultado";
       
       String RUTA_IR_ORDEN_MEDICAMENTOS_CONTROL_ENTREGA_RESULTADO = "irOrdenMedicamentosControlEntregaResultado";
       
       
       // Fin Historia Control Entrega Resultados

        String RUTA_IR_GENERAR_FOLIOS_INGRESO_ENFERMERIA_PROCEDIMIENTO = "irConsultaResumenFoliosIngresoEnfermeriaProcedimiento";
        
    String RUTA_IR_CONSULTA_ETQUETA_VPH = "irConsultaEtiquetaVph";
    
    
    // HISTORIA NUEVO PRENATAL

    String RUTA_IR_DATOS_NUEVO_PRENATAL = "irDatosNuevoPrenatal";

    String RUTA_IR_MOTIVO_NUEVO_PRENATAL = "irMotivoNuevoPrenatal";
    
    String RUTA_IR_CUESTIONARIO_COVID_NUEVO_PRENATAL = "irCuestionarioCovidNuevoPrenatal";

    String RUTA_IR_INTERCONSULTA_NUEVO_PRENATAL = "irInterConsultaNuevoPrenatal";

    String RUTA_IR_ORDENCIRUGIA_NUEVO_PRENATAL= "irOrdenCirugiaNuevoPrenatal";

    String RUTA_IR_INCAPACIDAD_NUEVO_PRENATAL = "irIncapacidadNuevoPrenatal";

    String RUTA_IR_HOSPITALZACION_NUEVO_PRENATAL = "irRemHospitalizacionNuevoPrenatal";

    String RUTA_IR_FORMULAMEDICA_NUEVO_PRENATAL = "irFormulaMedicaNuevoPrenatal";

    String RUTA_IR_VADEMECUM_NUEVO_PRENATAL = "irVademecumNuevoPrenatal";


    String RUTA_IR_CONTOLSINCOSTO_NUEVO_PRENATAL = "irControlSinCostoNuevoPrenatal";

    String RUTA_IR_ANATOMIAPATOLOGICA_NUEVO_PRENATAL = "irAnatPatologicaNuevoPrenatal";

    String RUTA_IR_IMPRESION_DIAGNOSTICA_NUEVO_PRENATAL = "irImpDiagnosticaNuevoPrenatal";

    String RUTA_IR_ENCUESTA_VIOLENCIA_NUEVO_PRENATAL = "irEncuestaViolenciaNuevoPrenatal";

    String RUTA_IR_EXAMENFISICO_NUEVO_PRENATAL = "irExamenFisicoNuevoPrenatal";

    String RUTA_IR_ANTECEDENTES_NUEVO_PRENATAL = "irAntecedentesNuevoPrenatal";

    String RUTA_IR_ANTECEDENTES_FAMILIARES_NUEVO_PRENATAL = 
        "irAntecedentesEspecificosNuevoPrenatal";

    String RUTA_IR_GESTACION_NUEVO_PRENATAL = "irGestacionNuevoPrenatal";

    String RUTA_IR_GESTACION_CONTROL_NUEVO_PRENATAL = "irGestacionControlNuevoPrenatal";

    String RUTA_IR_ANTECEDENTES_GENERALES_NUEVO_PRENATAL = 
        "irAntecedentesGeneralesNuevoPrenatal";

    String RUTA_IR_ANTECEDENTES_GINECOLOGICOS_NUEVO_PRENATAL = 
        "irAntecedentesGinecologicosNuevoPrenatal";

    String RUTA_IR_ANTECEDENTES_OBSTETRICOS_NUEVO_PRENATAL = 
        "irAntecedentesObstetricosNuevoPrenatal";

    String RUTA_IR_CERTIFICADO_ASISTENCIA_NUEVO_PRENATAL = 
        "irCertificadoAsistenciaNuevoPrenatal";

    String RUTA_IR_CERTIFICADOMEDICO_NUEVO_PRENATAL = "irCertificadoMedicoNuevoPrenatal";

    String RUTA_IR_ELECTROFISIOLOGICO_NUEVO_PRENATAL = 
        "irExamenElectrofisiologicosNuevoPrenatal";

    String RUTA_IR_IMAGENES_NUEVO_PRENATAL = "irExamenImagenesNuevoPrenatal";

    String RUTA_IR_LABORATORIO_NUEVO_PRENATAL = "irExamenLaboratorioNuevoPrenatal";

    String RUTA_IR_RECOMENDACIONES_NUEVO_PRENATAL = "irRecomendacionesNuevoPrenatal";

    String RUTA_IR_REFERENCIA_NUEVO_PRENATAL = "irReferenciaNuevoPrenatal";

    String RUTA_IR_RESERVA_SANGRE_NUEVO_PRENATAL = "irReservaSangreNuevoPrenatal";

    String RUTA_IR_CERRAR_CONSULTA_NUEVO_PRENATAL = "irCerrarConsultaNuevoPrenatal";

    String RUTA_IR_RESUMEN_HISTORIA_ESPECIFICA_NUEVO_PRENATAL = 
        "irResumenHistoriaEspecificaNuevoPrenatal";

    String RUTA_IR_RESUMEN_HISTORIA_NUEVO_PRENATAL= "irResumenHistoriaNuevoPrenatal";
    
    String RUTA_IR_TAMIZAJE_NUEVO_PRENATAL = "irTamizajeNuevoPrenatal";
    
    String RUTA_IR_VALORACION_BIOPSICOSOCIAL_NUEVO_PRENATAL = "irValoracionBiopsicosocialNuevoPrenatal";
    
    String RUTA_IR_EXAMEN_FISICO_GENERAL_NUEVO_PRENATAL = "irExamenFisicoGeneralNuevoPrenatal";
    

    
    String RUTA_IR_ASESORIA_INTERRUPCION = "irAsesoriaInterrupcion";
    
    String RUTA_IR_REGISTRO_ESCALA_VALORACION_CAIDAS = "irEscalaValoracionCaidasEnfermeria";
    
    String RUTA_IR_REGISTRO_ESCALA_VALORACION_CAIDAS_PROCEDIMIENTO = "irEscalaValoracionCaidasEnfermeriaProcedimiento";
    
    String RUTA_IR_INGRESO_OTRAS_ORDENES_PROCEDIMIENTO = "irOtrasOrdenesIngresoEnfermeriaProcedimiento";
    
    String RUTA_IR_AUTORIZACION_SERVICIOS_NUEVO_PRENATAL = "irAutorizacionServiciosNuevoPrenatal";
    

    
    //HISTORIA TUNERCULINA
    
    String RUTA_IR_TOMA_TUBERCULINA = "irTomaTuberculina";
    
    String RUTA_IR_DATOS_TUBERCULINA= "irDatosTuberculina";
    
    String RUTA_IR_ANTECEDENTES_GENERALES_TUBERCULINA= "irAntecedentesGeneralesTuberculina";
    
    String RUTA_IR_ANTECEDENTES_PATOLOGICOS_TUBERCULINA= "irAntecedentesPatologicosTuberculina";

    String RUTA_IR_ANTECEDENTES_FARMACOLOGICO_TUBERCULINA= "irAntecedentesFarmacologicosTuberculina";
    
    String RUTA_IR_CIERRE_TUBERCULINA= "irCierreTuberculina";
    
    String RUTA_IR_CUESTIONARIO_COVID_TUBERCULINA = "irCuestionarioCovidTuberculina";    
    
    String RUTA_IR_LECTURA_TUBERCULINA = "irLecturaTuberculina";
    
    String RUTA_IR_MODIFICAR_DATOS_USUARIO_TUBERCULINA = "irDatosLecturaTuberculina";
    
    String RUTA_IR_LECTURA_TUBERCULINA_DILIGENCIAR= "irFormatoLecturaTuberculina";
    //FIN 

    
    String RUTA_IR_NOTA_COMPLEMENTARIA_ENFEMERIA = "irNotaComplementariaEnfermeria";
    
    String RUTA_CONSULTAR_FOLIOS_NOTA_COMPLEMENTARIA = "ver_folios_nota_complementaria_Enfermeria";
    
    String RUTA_REGISTRAR_NOTA_COMPLEMENTARIA_ENFERMERIA = "ver_nota_complementaria_enfemeria";
    
    
    // SOLICITUD Y ACLARACION INFORME PSICOLOGICO
    
     String RUTA_IR_AUTORIZACION_INFORME_PSICOLOGICO= "irAutorizacionInformePsicologico";

     String RUTA_IR_SOLICITUD_INFORME_PSICOLOGICO=  "irSolicitudInformePsicologico";

     String RUTA_SOLICITAR_INFORME_PSICOLOGICO = "irSolicitarInformePsicologico";
     
     String RUTA_APROBAR_INFORME_PSICOLOGICO = "irAprobarInformePsicologico";
     
    String RUTA_IR_INFORME_PSICOLOGICO = "irRegistrarInfoPsicologico";
    
    String RUTA_CONSULTAR_FOLIOS_INFORME_PSICOLOGICO = "ver_folios_informe_psicologico";
    
    String RUTA_REGISTRAR_INFORME_PSICOLOGICO = "ver_informe_psicologico";
    
    String RUTA_IR_OTRAS_ORDENES_CONTROL_ANESTE = "irOtrasOrdenesAnes"; 
    
    //HISTORIA HISTEROSCOPIA

    String RUTA_REGISTRAR_DESCRIPCION_QUIRURGICA_HISTE = "irDescripcionQuirurgicaHisteroscopia";
    
    // HISTORIA NUEVO PRENATAL ENFERMERIA

    String RUTA_IR_DATOS_NUEVO_PRENATAL_ENFERMERIA = "irDatosNuevoPrenatalEnfermeria";

    String RUTA_IR_MOTIVO_NUEVO_PRENATAL_ENFERMERIA = "irMotivoNuevoPrenatalEnfermeria";
 
    String RUTA_IR_CUESTIONARIO_COVID_NUEVO_PRENATAL_ENFERMERIA = "irCuestionarioCovidNuevoPrenatalEnfermeria";

    String RUTA_IR_INTERCONSULTA_NUEVO_PRENATAL_ENFERMERIA = "irInterConsultaNuevoPrenatalEnfermeria";

    String RUTA_IR_ORDENCIRUGIA_NUEVO_PRENATAL_ENFERMERIA= "irOrdenCirugiaNuevoPrenatalEnfermeria";

    String RUTA_IR_INCAPACIDAD_NUEVO_PRENATAL_ENFERMERIA = "irIncapacidadNuevoPrenatalEnfermeria";

    String RUTA_IR_HOSPITALZACION_NUEVO_PRENATAL_ENFERMERIA = "irRemHospitalizacionNuevoPrenatalEnfermeria";

    String RUTA_IR_FORMULAMEDICA_NUEVO_PRENATAL_ENFERMERIA = "irFormulaMedicaNuevoPrenatalEnfermeria";

    String RUTA_IR_VADEMECUM_NUEVO_PRENATAL_ENFERMERIA = "irVademecumNuevoPrenatalEnfermeria";
    
    


    String RUTA_IR_CONTOLSINCOSTO_NUEVO_PRENATAL_ENFERMERIA = "irControlSinCostoNuevoPrenatalEnfermeria";

    String RUTA_IR_ANATOMIAPATOLOGICA_NUEVO_PRENATAL_ENFERMERIA = "irAnatPatologicaNuevoPrenatalEnfermeria";

    String RUTA_IR_IMPRESION_DIAGNOSTICA_NUEVO_PRENATAL_ENFERMERIA = "irImpDiagnosticaNuevoPrenatalEnfermeria";

    String RUTA_IR_ENCUESTA_VIOLENCIA_NUEVO_PRENATAL_ENFERMERIA = "irEncuestaViolenciaNuevoPrenatalEnfermeria";

    String RUTA_IR_EXAMENFISICO_NUEVO_PRENATAL_ENFERMERIA = "irExamenFisicoNuevoPrenatalEnfermeria";

    String RUTA_IR_ANTECEDENTES_NUEVO_PRENATAL_ENFERMERIA = "irAntecedentesNuevoPrenatalEnfermeria";

    String RUTA_IR_ANTECEDENTES_FAMILIARES_NUEVO_PRENATAL_ENFERMERIA = 
        "irAntecedentesEspecificosNuevoPrenatalEnfermeria";

    String RUTA_IR_GESTACION_NUEVO_PRENATAL_ENFERMERIA = "irGestacionNuevoPrenatalEnfermeria";

    String RUTA_IR_GESTACION_CONTROL_NUEVO_PRENATAL_ENFERMERIA = "irGestacionControlNuevoPrenatalEnfermeria";

    String RUTA_IR_ANTECEDENTES_GENERALES_NUEVO_PRENATAL_ENFERMERIA = 
        "irAntecedentesGeneralesNuevoPrenatalEnfermeria";

    String RUTA_IR_ANTECEDENTES_GINECOLOGICOS_NUEVO_PRENATAL_ENFERMERIA = 
        "irAntecedentesGinecologicosNuevoPrenatalEnfermeria";

    String RUTA_IR_ANTECEDENTES_OBSTETRICOS_NUEVO_PRENATAL_ENFERMERIA = 
        "irAntecedentesObstetricosNuevoPrenatalEnfermeria";

    String RUTA_IR_CERTIFICADO_ASISTENCIA_NUEVO_PRENATAL_ENFERMERIA = 
        "irCertificadoAsistenciaNuevoPrenatalEnfermeria";

    String RUTA_IR_CERTIFICADOMEDICO_NUEVO_PRENATAL_ENFERMERIA = "irCertificadoMedicoNuevoPrenatalEnfermeria";

    String RUTA_IR_ELECTROFISIOLOGICO_NUEVO_PRENATAL_ENFERMERIA = 
        "irExamenElectrofisiologicosNuevoPrenatalEnfermeria";

    String RUTA_IR_IMAGENES_NUEVO_PRENATAL_ENFERMERIA = "irExamenImagenesNuevoPrenatalEnfermeria";

    String RUTA_IR_LABORATORIO_NUEVO_PRENATAL_ENFERMERIA = "irExamenLaboratorioNuevoPrenatalEnfermeria";

    String RUTA_IR_RECOMENDACIONES_NUEVO_PRENATAL_ENFERMERIA = "irRecomendacionesNuevoPrenatalEnfermeria";

    String RUTA_IR_REFERENCIA_NUEVO_PRENATAL_ENFERMERIA = "irReferenciaNuevoPrenatalEnfermeria";

    String RUTA_IR_RESERVA_SANGRE_NUEVO_PRENATAL_ENFERMERIA = "irReservaSangreNuevoPrenatalEnfermeria";

    String RUTA_IR_CERRAR_CONSULTA_NUEVO_PRENATAL_ENFERMERIA = "irCerrarConsultaNuevoPrenatalEnfermeria";

    String RUTA_IR_RESUMEN_HISTORIA_ESPECIFICA_NUEVO_PRENATAL_ENFERMERIA = 
        "irResumenHistoriaEspecificaNuevoPrenatalEnfermeria";

    String RUTA_IR_RESUMEN_HISTORIA_NUEVO_PRENATAL_ENFERMERIA= "irResumenHistoriaNuevoPrenatalEnfermeria";
    
    String RUTA_IR_TAMIZAJE_NUEVO_PRENATAL_ENFERMERIA = "irTamizajeNuevoPrenatalEnfermeria";
    
    String RUTA_IR_VALORACION_BIOPSICOSOCIAL_NUEVO_PRENATAL_ENFERMERIA = "irValoracionBiopsicosocialNuevoPrenatalEnfermeria";
    
    String RUTA_IR_RIPS_SALUDTOOLS = "irRipsSaludtools" ;
    
    String RUTA_IR_NOTICIAS = "irgesNoticia" ;
    
    String RUTA_IR_EXAMEN_FISICO_GENERAL_NUEVO_PRENATAL_ENFERMERIA = "irExamenFisicoGeneralNuevoPrenatalEnfermeria";
    
    String RUTA_IR_AUTORIZACION_SERVICIOS_NUEVO_PRENATAL_ENFERMERIA = "irAutorizacionServiciosNuevoPrenatalEnfermeria";
    
    // CONDUCTA NOTA ACLARATORIA
    
     String RUTA_IR_ANATOMIAPATOLOGICA_NOTA_ACLARATORIA = "irAnatPatologicaNotaAclaratoria";
     String RUTA_IR_CONTOLSINCOSTO_NOTA_ACLARATORIA = "irControlSinCostoNotaAclaratoria";
     String RUTA_IR_FORMULAMEDICA_NOTA_ACLARATORIA = "irFormulaMedicaNotaAclaratoria";
     String RUTA_IR_VADEMCUM_NOTA_ACLARATORIA = "irVademecumMedicoNotaAclaratoria";
     String RUTA_IR_HOSPITALZACION_NOTA_ACLARATORIA = "irRemHospitalizacionNotaAclaratoria";
     String RUTA_IR_AUTORIZACION_SERVICIOS_NOTA_ACLARATORIA = "irAutorizacionServicioNotaAclaratoria";
     String RUTA_IR_INCAPACIDAD_NOTA_ACLARATORIA = "irIncapacidadNotaAclaratoria";
     String RUTA_IR_INTERCONSULTA_NOTA_ACLARATORIA = "irInterConsultaNotaAclaratoria";
     String RUTA_IR_ORDENCIRUGIA_NOTA_ACLARATORIA = "irOrdenCirugiaNotaAclaratoria";
     String RUTA_IR_REFERENCIA_NOTA_ACLARATORIA = "irReferenciaNotaAclaratoria";
     String RUTA_IR_RESERVA_SANGRE_NOTA_ACLARATORIA = "irReservaSangreNotaAclaratoria";
     String RUTA_IR_RECOMENDACIONES_NOTA_ACLARATORIA = "irRecomedacionNotaAclaratoria";
     String RUTA_IR_CERTIFICADOMEDICO_NOTA_ACLARATORIA = "irCertMedicoNotaAclaratoria";
     String RUTA_IR_CERTIFICADO_ASISTENCIA_NOTA_ACLARATORIA = "irCertAsistenciaNotaAclaratoria";
     String RUTA_IR_ELECTROFISIOLOGICO_NOTA_ACLARATORIA = "irExamElectrofisiologicoNotaAclaratoria";
     String RUTA_IR_IMAGENES_NOTA_ACLARATORIA = "irExamImagenNotaAclaratoria";
     String RUTA_IR_LABORATORIO_NOTA_ACLARATORIA = "irExamLaboratorioNotaAclaratoria";
     String RUTA_IR_RESUMEN_HISTORIA_ESPECIFICA_NOTA_ACLARATORIA = "";
     String RUTA_IR_ORDEN_LIQUIDOS_NOTA_ACLARATORIA = "";
     String RUTA_IR_RESUMEN_HISTORIA_NOTA_ACLARATORIA = "irResumenHistoriaNotaAclaratoria";
     String RUTA_IR_OTRAS_ORDENES_NOTA_ACLARATORIA = "irRegistrarOtrasOrdenesNotaAclaratoria";
     String RUTA_IR_ORDEN_MEDICAMENTOS_NOTA_ACLARATORIA = "irOrdenCirugiaNotaAclaratoria";
     String RUTA_IR_ENCUESTA_VIOLENCIA_SIVIGILA_NOTA_ACLARATORIA = "irEncuestaViolenciaSivigilaNotaAclaratoria";
     
    
    //Reporte Log Impresion
    String RUTA_IR_REPORTE_LOG_IMPRESION = "irReporteLogImpresion";
    
    //Escala de valoracion de caidas
    
    String RUTA_IR_REGISTRO_ESCALA_VALORACION_CAIDAS_SALUD_SEXUAL = "irEscalaValoracionCaidasSaludSexual"; 
    String RUTA_IR_ESCALA_VALORACION_CAIDAS_ANTICONCEPCION_TEMPORAL = "irEscalaValoracionCaidasAnticoncepcionTemporal";
    String RUTA_IR_ESCALA_VALORACION_CAIDAS_ANTICONCEPCION_INSERCION = "irEscalaValoracionCaidasAnticoncepcionInsercion";
    String RUTA_IR_ESCALA_VALORACION_CAIDAS_ANTICONCEPCION_RETIRO = "irEscalaValoracionCaidasAnticoncepcionRetiro";
    String RUTA_IR_ESCALA_VALORACION_CAIDAS_CERVIX = "irEscalaValoracionCaidasCervix";
    String RUTA_IR_ESCALA_VALORACION_CAIDAS_CERVIX_VACUNACION = "irEscalaValoracionCaidasCervixVacunacion";
    String RUTA_IR_ESCALA_VALORACION_CAIDAS_COLPOSCOPIA = "irEscalaValoracionCaidasColposcopia";
    String RUTA_IR_ESCALA_VALORACION_CAIDAS_CONFIRMACION = "irEscalaValoracionCaidasConfirmacion";
    String RUTA_IR_ESCALA_VALORACION_CAIDAS_CONTROL = "irEscalaValoracionCaidasControl";
    String RUTA_IR_ESCALA_VALORACION_CAIDAS_CONTROL_DERMATOLOGIA = "irEscalaValoracionCaidasControlDermatologia";
    String RUTA_IR_ESCALA_VALORACION_CAIDAS_CONTROL_EXAMEN_MAMA = "irEscalaValoracionCaidasControlExamenMama";
    String RUTA_IR_ESCALA_VALORACION_CAIDAS_CONTROL_GINECOLOGIA = "irEscalaValoracionCaidasControlGinecologia";
    String RUTA_IR_ESCALA_VALORACION_CAIDAS_CONTROL_UROLOGIA = "irEscalaValoracionCaidasControlUrologia";
    String RUTA_IR_ESCALA_VALORACION_CAIDAS_UROLOGIA = "irEscalaValoracionCaidasUrologia";
    String RUTA_IR_ESCALA_VALORACION_CAIDAS_CONTROL_ANTICONCEPCION_TEMPORAL = "irEscalaValoracionCaidasControlAnticoncepcionTemporal";
    String RUTA_IR_ESCALA_VALORACION_CAIDAS_CONTROL_FERTILIDAD = "irEscalaValoracionCaidasControlFertilidad";
    String RUTA_IR_ESCALA_VALORACION_CAIDAS_CONTROL_PREANESTESIA = "irEscalaValoracionCaidasControlPreanestesia";
    String RUTA_IR_ESCALA_VALORACION_CAIDAS_CONTROL_PRENATAL = "irEscalaValoracionCaidasControlPrenatal";
    String RUTA_IR_ESCALA_VALORACION_CAIDAS_CONTROL_VASECTOMIA = "irEscalaValoracionCaidasControlVasectomia";
    String RUTA_IR_ESCALA_VALORACION_CAIDAS_FERTILIDAD = "irEscalaValoracionCaidasFertilidad";    
    String RUTA_IR_ESCALA_VALORACION_CAIDAS_INTERRUPCION = "irEscalaValoracionCaidasInterrupcion";
    String RUTA_IR_ESCALA_VALORACION_CAIDAS_INTERRUPCION_CONTROL = "irEscalaValoracionCaidasInterrupcionControl";
    String RUTA_IR_ESCALA_VALORACION_CAIDAS_OTRAS_ESPECIALIDADES = "irEscalaValoracionCaidasOtrasEspecialidades";  
    String RUTA_IR_ESCALA_VALORACION_CAIDAS_PEDIATRIA = "irEscalaValoracionCaidasPediatria";    
    String RUTA_IR_ESCALA_VALORACION_CAIDAS_PREANESTESIA = "irEscalaValoracionCaidasPreanestesia";
    String RUTA_IR_ESCALA_VALORACION_CAIDAS_PRENATAL = "irEscalaValoracionCaidasPrenatal";
    String RUTA_IR_ESCALA_VALORACION_CAIDAS_NUEVO_PRENATAL = "irEscalaValoracionCaidasNuevoPrenatal";
    String RUTA_IR_ESCALA_VALORACION_CAIDAS_PROCEDIMIENTOS_CONSULTORIO = "irEscalaValoracionCaidasProcedimientosConsultorio";
    String RUTA_IR_ESCALA_VALORACION_CAIDAS_PROCEDIMIENTOS_IVE = "irEscalaValoracionCaidasProcedimientosIve";
    String RUTA_IR_ESCALA_VALORACION_CAIDAS_EXAMEN_MAMA = "irEscalaValoracionCaidasExamenMama";
    String RUTA_IR_ESCALA_VALORACION_CAIDAS_CITOLOGIA = "irEscalaValoracionCaidasCitologia";
    String RUTA_IR_ESCALA_VALORACION_CAIDAS_ESTERILIZACION_FEMENINA = "irEscalaValoracionCaidasEsterilizacionFemenina";
    String RUTA_IR_ESCALA_VALORACION_CAIDAS_ESTERILIZACION_MASCULINA = "irEscalaValoracionCaidasEsterilizacionMasculina";
    String RUTA_IR_ESCALA_VALORACION_CAIDAS_CONTROL_IVE = "irEscalaValoracionCaidasControlIlve";
    String RUTA_IR_ESCALA_VALORACION_CAIDAS_MEDICAMENTOS = "irEscalaValoracionCaidasMedicamentos";
    String RUTA_IR_REGISTRO_ESCALA_VALORACION_CAIDAS_GINECOLOGIA = "irEscalaValoracionCaidasGinecologia";
    String RUTA_IR_REGISTRO_ESCALA_VALORACION_CAIDAS_PSICOLOGIA = "irEscalaValoracionCaidasPsicologia";
    String RUTA_IR_REGISTRO_ESCALA_VALORACION_CAIDAS_CONTROL_PSICOLOGIA = "irEscalaValoracionCaidasControlPsicologia";
    
    String RUTA_IR_PRIMEROSAUX_PSICOLOGIA=  "irPrimerosAuxPsicologia";
    
    String RUTA_CONSULTAR_FOLIOS_PAPSICOLOGIA = "ver_folios_pa_psicologia"; 
    
    //HISTORIA GINECOLOG�A
     String RUTA_IR_MOTIVO_GINECOLOGIA = "irMotivoGinecologia";

     String RUTA_IR_DATOS_GINECOLOGIA = "irDatosGinecologia";

     String RUTA_IR_INTERCONSULTA_GINECOLOGIA = "irInterConsultaGinecologia";

     String RUTA_IR_ORDENCIRUGIA_GINECOLOGIA = "irOrdenCirugiaGinecologia";


     String RUTA_IR_INCAPACIDAD_GINECOLOGIA = "irIncapacidadGinecologia";

     String RUTA_IR_HOSPITALZACION_GINECOLOGIA = 
         "irRemHospitalizacionGinecologia";

     String RUTA_IR_FORMULAMEDICA_GINECOLOGIA = "irFormulaMedicaGinecologia";


     String RUTA_IR_VADEMCUM_GINECOLOGIA = "irVademecumMedicoGinecologia";


     String RUTA_IR_CONTOLSINCOSTO_GINECOLOGIA = 
         "irControlSinCostoGinecologia";

     String RUTA_IR_ANATOMIAPATOLOGICA_GINECOLOGIA = 
         "irAnatPatologicaGinecologia";

     String RUTA_IR_IMPRESION_DIAGNOSTICA_GINECOLOGIA = 
         "irImpDiagnosticaGinecologia";

     String RUTA_IR_ENCUESTA_VIOLENCIA_GINECOLOGIA = 
         "irEncuestaViolenciaGinecologia";


     String RUTA_IR_ENCUESTA_VIOLENCIA_SIVIGILA_GINECOLOGIA = 
         "irEncuestaViolenciaSivigilaGinecologia";

     String RUTA_IR_EXAMENFISICO_GINECOLOGIA = "irExamenFisicoGinecologia";

     String RUTA_IR_ANTECEDENTES_GINECOLOGIA = "irAntecedentesGinecologia";

     String RUTA_IR_PARACLINICOS_GINECOLOGIA = "irParaclinicosGinecologia";

     String RUTA_IR_ANTECEDENTES_GENERALES_GINECOLOGIA = 
         "irAntecedentesGeneralesGinecologia";

     String RUTA_IR_ANTECEDENTES_GINECOLOGICOS_GINECOLOGIA = 
         "irAntecedentesGinecologicosGinecologia";

     String RUTA_IR_CERTIFICADO_ASISTENCIA_GINECOLOGIA = 
         "irCertificadoAsistenciaGinecologia";

     String RUTA_IR_CERTIFICADOMEDICO_GINECOLOGIA = 
         "irCertificadoMedicoGinecologia";

     String RUTA_IR_ELECTROFISIOLOGICO_GINECOLOGIA = 
         "irExamenElectrofisiologicosGinecologia";

     String RUTA_IR_IMAGENES_GINECOLOGIA = "irExamenImagenesGinecologia";

     String RUTA_IR_LABORATORIO_GINECOLOGIA = "irExamenLaboratorioGinecologia";

     String RUTA_IR_RECOMENDACIONES_GINECOLOGIA = 
         "irRecomendacionesGinecologia";

     String RUTA_IR_REFERENCIA_GINECOLOGIA = "irReferenciaGinecologia";

     String RUTA_IR_RESERVA_SANGRE_GINECOLOGIA = "irReservaSangreGinecologia";

     String RUTA_IR_CERRAR_CONSULTA_GINECOLOGIA = 
         "irCerrarConsultaGinecologia";

     String RUTA_IR_RESUMEN_HISTORIA_ESPECIFICA_GINECOLOGIA = 
         "irResumenHistoriaEspecificaGinecologia";

     String RUTA_IR_RESUMEN_HISTORIA_GINECOLOGIA = 
         "irResumenHistoriaGinecologia";


     String RUTA_IR_ORDEN_LIQUIDOS_GINECOLOGIA = "irOrdenLiquidosGinecologia";
     
     String RUTA_IR_OTRAS_ORDENES_GINECOLOGIA = "irOtrasOrdenesGinecologia"; 

     String RUTA_IR_ORDEN_MEDICAMENTOS_GINECOLOGIA = "irOrdenMedicamentosGinecologia";
     
     String RUTA_IR_CUESTIONARIO_COVID_GINECOLOGIA = "irCuestionarioCovidGinecologia";
     
     String RUTA_IR_CONFIRMAR_INSUMOS_GINECOLOGIA = "irConsultarInsumosGinecologia";
     
     String RUTA_IR_PAUSAR_CONSULTA_GINECOLOGIA = "irPausarConsultaGinecologial";
     
    String RUTA_IR_AUTORIZACION_SERVICIOS_GINECOLOGIA = "irAutorizacionServicioGinecologia";
    
    String RUTA_IR_SERVICIOS_ADMISION_GINECOLOGIA = "irServiciosAdmisionGinecologia";
    
    //CONTROL GINECOLOGIA
     String RUTA_IR_CUESTIONARIO_COVID_CONTROL_GINECOLOGIA = "irCuestionarioCovidControlGinecologia";
     String RUTA_IR_CONTROL_USUARIO_GINECOLOGIA = "irControlUsuarioGinecologia";
     String RUTA_IR_PAUSAR_CONSULTA_CONTROL_GINECOLOGIA = "irPausarConsultaControlGinecologia";
    String RUTA_IR_DATOS_CONTROL_GINECOLOGIA = "irDatosControlGinecologia";

    String RUTA_IR_MOTIVO_CONTROL_GINECOLOGIA = "irMotivoControlGinecologia";

    String RUTA_IR_EXAMEN_FISICO_CONTROL_GINECOLOGIA = 
        "irExamenFisicoControlGinecologia";

    String RUTA_IR_INTERCONSULTA_CONTROL_GINECOLOGIA = 
        "irInterConsultaControlGinecologia";

    String RUTA_IR_ORDENCIRUGIA_CONTROL_GINECOLOGIA = 
        "irOrdenCirugiaControlGinecologia";

    String RUTA_IR_INCAPACIDAD_CONTROL_GINECOLOGIA = 
        "irIncapacidadControlGinecologia";

    String RUTA_IR_HOSPITALZACION_CONTROL_GINECOLOGIA = 
        "irRemHospitalizacionControlGinecologia";

    String RUTA_IR_AUTORIZACION_SERVICIOS_CONTROL_GINECOLOGIA = 
        "irAutorizacionServicioControlGinecologia";

    String RUTA_IR_FORMULAMEDICA_CONTROL_GINECOLOGIA = 
        "irFormulaMedicaControlGinecologia";

    String RUTA_IR_VADEMCUM_CONTROL_GINECOLOGIA = 
        "irVademecumControlGinecologia";


    String RUTA_IR_CONTOLSINCOSTO_CONTROL_GINECOLOGIA = 
        "irControlSinCostoControlGinecologia";

    String RUTA_IR_ANATOMIAPATOLOGICA_CONTROL_GINECOLOGIA = 
        "irAnatPatologicaControlGinecologia";

    String RUTA_IR_APLICACION_RETITO_CONTROL_GINECOLOGIA = 
        "irAplicacionRetiroControlGinecologia";

    String RUTA_IR_IMPRESION_DIAGNOSTICA_CONTROL_GINECOLOGIA = 
        "irImpDiagnosticaControlGinecologia";


    String RUTA_IR_ANTECEDENTES_CONTROL_GINECOLOGIA = 
        "irAntecedentesControlGinecologia";

    String RUTA_IR_ANTECEDENTES_GENERALES_CONTROL_GINECOLOGIA = 
        "irAntecedentesGeneralesControlGinecologia";

    String RUTA_IR_CERTIFICADO_ASISTENCIA_CONTROL_GINECOLOGIA = 
        "irCertificadoAsistenciaControlGinecologia";

    String RUTA_IR_CERTIFICADOMEDICO_CONTROL_GINECOLOGIA = 
        "irCertificadoMedicoControlGinecologia";

    String RUTA_IR_ELECTROFISIOLOGICO_CONTROL_GINECOLOGIA = 
        "irExamenElectrofisiologicosControlGinecologia";

    String RUTA_IR_IMAGENES_CONTROL_GINECOLOGIA = 
        "irExamenImagenesControlGinecologia";

    String RUTA_IR_LABORATORIO_CONTROL_GINECOLOGIA = 
        "irExamenLaboratorioControlGinecologia";

    String RUTA_IR_RECOMENDACIONES_CONTROL_GINECOLOGIA = 
        "irRecomendacionesControlGinecologia";

    String RUTA_IR_REFERENCIA_CONTROL_GINECOLOGIA = 
        "irReferenciaControlGinecologia";

    String RUTA_IR_RESERVA_SANGRE_CONTROL_GINECOLOGIA = 
        "irReservaSangreControlGinecologia";

    String RUTA_IR_CERRAR_CONTROL_GINECOLOGIA = 
        "irCerrarConsultaControlGinecologia";

    String RUTA_IR_RESUMEN_HISTORIA_ESPECIFICA_CONTROL_GINECOLOGIA = 
        "irResumenHistoriaEspecificaControlGinecologia";

    String RUTA_IR_RESUMEN_HISTORIA_CONTROL_GINECOLOGIA = 
        "irResumenHistoriaControlGinecologia";

    String RUTA_IR_ECOGRAFIA_CONTROL_GINECOLOGIA = 
        "irEcografiaControlGinecologia";
    String RUTA_IR_ORDEN_LIQUIDOS_CONTROL_GINECOLOGIA = "irOrdenLiquidosControlGinecologia";
    String RUTA_IR_OTRAS_ORDENES_CONTROL_GINECOLOGIA = "irOtrasOrdenesControlGinecologia"; 
    String RUTA_IR_ORDEN_MEDICAMENTOS_CONTROL_GINECOLOGIA = "irOrdenMedicamentosControlGinecologia";


    
    
    String RUTA_REGISTRAR_PAPSICOLOGIA = "registrar_folios_pa_psicologia";
    
    String RUTA_IMPRIMIR_PAPSICOLOGIA = "irCopiaPapsicologia";
    
    String RUTA_USUARIOS_COVD_ANTICUERPOS = "irlistaUsuCovidAnticuerpos";
    
    //Pruebas rapidas
    String RUTA_LISTA_PRUEBAS_RAPIDAS = "irConsultasPruebasRapidas";
    
    String RUTA_IR_PRUEBAS_RAPIDAS= "irPruebasRapidas";
    
    String RUTA_IR_IMPRESION_PRUEBAS_RAPIDAS= "irimpPruebasRapidas";
    
    String RUTA_IR_DATOS_USUARIO_PRUEBAS_RAPIDAS = "irDatosUsuarioPruebasRapidas";
    
    String RUTA_IR_REGISTRO_TOMA_PRUEBAS_RAPIDAS = "irRegistroTomaPruebasRapidas"; 
    
    String RUTA_DATOS_USUARIO_COVID_ANTICUERPOS = "irUsuarioCovidAnticuerpos";
    
    String RUTA_PRUEBA_COVID_ANTICUERPOS = "irPruebaCovidAnticuerpos";
    
    //HISTORIA GINECOLOG�A
     String RUTA_IR_MOTIVO_UROLOGIA = "irMotivoUrologia";

     String RUTA_IR_DATOS_UROLOGIA = "irDatosUrologia";

     String RUTA_IR_INTERCONSULTA_UROLOGIA = "irInterConsultaUrologia";

     String RUTA_IR_ORDENCIRUGIA_UROLOGIA = "irOrdenCirugiaUrologia";


     String RUTA_IR_INCAPACIDAD_UROLOGIA = "irIncapacidadUrologia";

     String RUTA_IR_HOSPITALZACION_UROLOGIA = 
         "irRemHospitalizacionUrologia";

     String RUTA_IR_FORMULAMEDICA_UROLOGIA = "irFormulaMedicaUrologia";


     String RUTA_IR_VADEMCUM_UROLOGIA = "irVademecumMedicoUrologia";


     String RUTA_IR_CONTOLSINCOSTO_UROLOGIA = 
         "irControlSinCostoUrologia";

     String RUTA_IR_ANATOMIAPATOLOGICA_UROLOGIA = 
         "irAnatPatologicaUrologia";

     String RUTA_IR_IMPRESION_DIAGNOSTICA_UROLOGIA = 
         "irImpDiagnosticaUrologia";

     String RUTA_IR_ENCUESTA_VIOLENCIA_UROLOGIA = 
         "irEncuestaViolenciaUrologia";


     String RUTA_IR_ENCUESTA_VIOLENCIA_SIVIGILA_UROLOGIA = 
         "irEncuestaViolenciaSivigilaUrologia";

     String RUTA_IR_EXAMENFISICO_UROLOGIA = "irExamenFisicoUrologia";

     String RUTA_IR_ANTECEDENTES_UROLOGIA = "irAntecedentesUrologia";

     String RUTA_IR_PARACLINICOS_UROLOGIA = "irParaclinicosUrologia";

     String RUTA_IR_ANTECEDENTES_GENERALES_UROLOGIA = 
         "irAntecedentesGeneralesUrologia";

     String RUTA_IR_ANTECEDENTES_GINECOLOGICOS_UROLOGIA = 
         "irAntecedentesGinecologicosUrologia";

     String RUTA_IR_CERTIFICADO_ASISTENCIA_UROLOGIA = 
         "irCertificadoAsistenciaUrologia";

     String RUTA_IR_CERTIFICADOMEDICO_UROLOGIA = 
         "irCertificadoMedicoUrologia";

     String RUTA_IR_ELECTROFISIOLOGICO_UROLOGIA = 
         "irExamenElectrofisiologicosUrologia";

     String RUTA_IR_IMAGENES_UROLOGIA = "irExamenImagenesUrologia";

     String RUTA_IR_LABORATORIO_UROLOGIA = "irExamenLaboratorioUrologia";

     String RUTA_IR_RECOMENDACIONES_UROLOGIA = 
         "irRecomendacionesUrologia";

     String RUTA_IR_REFERENCIA_UROLOGIA = "irReferenciaUrologia";

     String RUTA_IR_RESERVA_SANGRE_UROLOGIA = "irReservaSangreUrologia";

     String RUTA_IR_CERRAR_CONSULTA_UROLOGIA = 
         "irCerrarConsultaUrologia";

     String RUTA_IR_RESUMEN_HISTORIA_ESPECIFICA_UROLOGIA = 
         "irResumenHistoriaEspecificaUrologia";

     String RUTA_IR_RESUMEN_HISTORIA_UROLOGIA = 
         "irResumenHistoriaUrologia";


     String RUTA_IR_ORDEN_LIQUIDOS_UROLOGIA = "irOrdenLiquidosUrologia";
     
     String RUTA_IR_OTRAS_ORDENES_UROLOGIA = "irOtrasOrdenesUrologia"; 

     String RUTA_IR_ORDEN_MEDICAMENTOS_UROLOGIA = "irOrdenMedicamentosUrologia";
     
     String RUTA_IR_CUESTIONARIO_COVID_UROLOGIA = "irCuestionarioCovidUrologia";
     
     String RUTA_IR_CONFIRMAR_INSUMOS_UROLOGIA = "irConsultarInsumosUrologia";
     
     String RUTA_IR_PAUSAR_CONSULTA_UROLOGIA = "irPausarConsultaUrologial";
     
    String RUTA_IR_AUTORIZACION_SERVICIOS_UROLOGIA = "irAutorizacionServicioUrologia";
    
    String RUTA_IR_SERVICIOS_ADMISION_UROLOGIA = "irServiciosAdmisionUrologia";
    
    //CONTROL UROLOGIA
     //CONTROL UROLOGIA
      String RUTA_IR_CUESTIONARIO_COVID_CONTROL_UROLOGIA = "irCuestionarioCovidControlUrologia";
      String RUTA_IR_CONTROL_USUARIO_UROLOGIA = "irControlUsuarioUrologia";
      String RUTA_IR_PAUSAR_CONSULTA_CONTROL_UROLOGIA = "irPausarConsultaControlUrologia";
     String RUTA_IR_DATOS_CONTROL_UROLOGIA = "irDatosControlUrologia";

     String RUTA_IR_MOTIVO_CONTROL_UROLOGIA = "irMotivoControlUrologia";

     String RUTA_IR_EXAMEN_FISICO_CONTROL_UROLOGIA = 
         "irExamenFisicoControlUrologia";

     String RUTA_IR_INTERCONSULTA_CONTROL_UROLOGIA = 
         "irInterConsultaControlUrologia";

     String RUTA_IR_ORDENCIRUGIA_CONTROL_UROLOGIA = 
         "irOrdenCirugiaControlUrologia";

     String RUTA_IR_INCAPACIDAD_CONTROL_UROLOGIA = 
         "irIncapacidadControlUrologia";

     String RUTA_IR_HOSPITALZACION_CONTROL_UROLOGIA = 
         "irRemHospitalizacionControlUrologia";

     String RUTA_IR_AUTORIZACION_SERVICIOS_CONTROL_UROLOGIA = 
         "irAutorizacionServicioControlUrologia";

     String RUTA_IR_FORMULAMEDICA_CONTROL_UROLOGIA = 
         "irFormulaMedicaControlUrologia";

     String RUTA_IR_VADEMCUM_CONTROL_UROLOGIA = 
         "irVademecumControlUrologia";


     String RUTA_IR_CONTOLSINCOSTO_CONTROL_UROLOGIA = 
         "irControlSinCostoControlUrologia";

     String RUTA_IR_ANATOMIAPATOLOGICA_CONTROL_UROLOGIA = 
         "irAnatPatologicaControlUrologia";

     String RUTA_IR_APLICACION_RETITO_CONTROL_UROLOGIA = 
         "irAplicacionRetiroControlUrologia";

     String RUTA_IR_IMPRESION_DIAGNOSTICA_CONTROL_UROLOGIA = 
         "irImpDiagnosticaControlUrologia";


     String RUTA_IR_ANTECEDENTES_CONTROL_UROLOGIA = 
         "irAntecedentesControlUrologia";

     String RUTA_IR_ANTECEDENTES_GENERALES_CONTROL_UROLOGIA = 
         "irAntecedentesGeneralesControlUrologia";

     String RUTA_IR_CERTIFICADO_ASISTENCIA_CONTROL_UROLOGIA = 
         "irCertificadoAsistenciaControlUrologia";

     String RUTA_IR_CERTIFICADOMEDICO_CONTROL_UROLOGIA = 
         "irCertificadoMedicoControlUrologia";

     String RUTA_IR_ELECTROFISIOLOGICO_CONTROL_UROLOGIA = 
         "irExamenElectrofisiologicosControlUrologia";

     String RUTA_IR_IMAGENES_CONTROL_UROLOGIA = 
         "irExamenImagenesControlUrologia";

     String RUTA_IR_LABORATORIO_CONTROL_UROLOGIA = 
         "irExamenLaboratorioControlUrologia";

     String RUTA_IR_RECOMENDACIONES_CONTROL_UROLOGIA = 
         "irRecomendacionesControlUrologia";

     String RUTA_IR_REFERENCIA_CONTROL_UROLOGIA = 
         "irReferenciaControlUrologia";

     String RUTA_IR_RESERVA_SANGRE_CONTROL_UROLOGIA = 
         "irReservaSangreControlUrologia";

     String RUTA_IR_CERRAR_CONTROL_UROLOGIA = 
         "irCerrarConsultaControlUrologia";

     String RUTA_IR_RESUMEN_HISTORIA_ESPECIFICA_CONTROL_UROLOGIA = 
         "irResumenHistoriaEspecificaControlUrologia";

     String RUTA_IR_RESUMEN_HISTORIA_CONTROL_UROLOGIA = 
         "irResumenHistoriaControlUrologia";

     String RUTA_IR_ECOGRAFIA_CONTROL_UROLOGIA = 
         "irEcografiaControlUrologia";
     String RUTA_IR_ORDEN_LIQUIDOS_CONTROL_UROLOGIA = "irOrdenLiquidosControlUrologia";
     String RUTA_IR_OTRAS_ORDENES_CONTROL_UROLOGIA = "irOtrasOrdenesControlUrologia"; 
     String RUTA_IR_ORDEN_MEDICAMENTOS_CONTROL_UROLOGIA = "irOrdenMedicamentosControlUrologia";
     //FIN CONTROL UROLOGIA
    
    
    
      String RUTA_IMPRIMIR_COVID_ANTICUERPOS = "irImprimirCovidAnticuerpos";
      
      String RUTA_USUARIOS_COVD_ANTIGENOS = "irlistaUsuCovidAntigenos";
      
      String RUTA_DATOS_USUARIO_COVID_ANTIGENOS = "irUsuarioCovidAntigenos";
      
      String RUTA_PRUEBA_COVID_ANTIGENOS = "irPruebaCovidAntigenos";
      
      String RUTA_IMPRIMIR_COVID_ANTIGENOS = "irImprimirCovidAntigenos";
      
      String RUTA_IR_REPORTE_ANTICUERPOS_COVID = "irRepAnticuerpoCovid";
      
      String RUTA_IR_REPORTE_ANTIGENOS_COVID = "irRepAntigenoCovid";    
      
      String  RUTA_IR_RESUMEN_HISTORIA_ESPECIFICA_ESTERILIZACION_FEMENINA = "irResumenHistoriaEsterilizacionFemenina";
       
      String  RUTA_IR_RESUMEN_HISTORIA_ESTERILIZACION_FEMENINA = "irResumenHistoriaEsterilizacionFemenina"; 
      
      //CONTROL EXAMEN MAMA
      
       String RUTA_IR_DATOS_CONTROL_EXAMEN_MAMA = "irDatosControlExamenMama";

       String RUTA_IR_MOTIVO_CONTROL_EXAMEN_MAMA = "irMotivoControlExamenMama";

       String RUTA_IR_EXAMEN_FISICO_CONTROL_EXAMEN_MAMA = "irExamenFisicoControlExamenMama";

       String RUTA_IR_INTERCONSULTA_CONTROL_EXAMEN_MAMA = "irInterConsultaControlExamenMama";

       String RUTA_IR_ORDENCIRUGIA_CONTROL_EXAMEN_MAMA = "irOrdenCirugiaControlExamenMama";

       String RUTA_IR_INCAPACIDAD_CONTROL_EXAMEN_MAMA = "irIncapacidadControlExamenMama";

       String RUTA_IR_HOSPITALZACION_CONTROL_EXAMEN_MAMA = "irRemHospitalizacionControlExamenMama";

       String RUTA_IR_AUTORIZACION_SERVICIOS_CONTROL_EXAMEN_MAMA = 
           "irAutorizacionServicioControlExamenMama";

       String RUTA_IR_FORMULAMEDICA_CONTROL_EXAMEN_MAMA = "irFormulaMedicaControlExamenMama";

       String RUTA_IR_VADEMCUM_CONTROL_EXAMEN_MAMA = "irVademecumControlExamenMama";

       String RUTA_IR_CONTOL_SIN_COSTO_CONTROL_EXAMEN_MAMA = "irControlSinCostoControlExamenMama";

       String RUTA_IR_ANATOMIAPATOLOGICA_CONTROL_EXAMEN_MAMA = "irAnatPatologicaControlExamenMama";

       String RUTA_IR_APLICACION_RETITO_CONTROL_EXAMEN_MAMA = "irAplicacionRetiroControlExamenMama";

       String RUTA_IR_IMPRESION_DIAGNOSTICA_CONTROL_EXAMEN_MAMA = "irImpDiagnosticaControlExamenMama";

       String RUTA_IR_CONTROL_USUARIO_EXAMEN_MAMA = "irControlUsuarioExamenMama";
       
       String RUTA_IR_CUESTIONARIO_COVID_CONTROL_EXAMEN_MAMA = "irCuestionarioCovidControlExamenMama";


       String RUTA_IR_ANTECEDENTES_CONTROL_EXAMEN_MAMA = "irAntecedentesControlExamenMama";

       String RUTA_IR_ANTECEDENTES_GENERALES_CONTROL_EXAMEN_MAMA = 
           "irAntecedentesGeneralesControlExamenMama";

       String RUTA_IR_CERTIFICADO_ASISTENCIA_CONTROL_EXAMEN_MAMA = 
           "irCertificadoAsistenciaControlExamenMama";

       String RUTA_IR_CERTIFICADOMEDICO_CONTROL_EXAMEN_MAMA = "irCertificadoMedicoControlExamenMama";

       String RUTA_IR_ELECTROFISIOLOGICO_CONTROL_EXAMEN_MAMA = 
           "irExamenElectrofisiologicosControlExamenMama";

       String RUTA_IR_IMAGENES_CONTROL_EXAMEN_MAMA = "irExamenImagenesControlExamenMama";

       String RUTA_IR_LABORATORIO_CONTROL_EXAMEN_MAMA = "irExamenLaboratorioControlExamenMama";

       String RUTA_IR_RECOMENDACIONES_CONTROL_EXAMEN_MAMA = "irRecomendacionesControlExamenMama";

       String RUTA_IR_REFERENCIA_CONTROL_EXAMEN_MAMA = "irReferenciaControlExamenMama";

       String RUTA_IR_RESERVA_SANGRE_CONTROL_EXAMEN_MAMA = "irReservaSangreControlExamenMama";

       String RUTA_IR_CERRAR_CONTROL_EXAMEN_MAMA = "irCerrarConsultaControlExamenMama";

       String RUTA_IR_RESUMEN_HISTORIA_ESPECIFICA_CONTROL_EXAMEN_MAMA = 
           "irResumenHistoriaEspecificaControlExamenMama";

       String RUTA_IR_RESUMEN_HISTORIA_CONTROL_EXAMEN_MAMA = "irResumenHistoriaControlExamenMama";
       
        String RUTA_IR_ORDEN_LIQUIDOS_CONTROL_EXAMEN_MAMA = "irOrdenLiquidosControlExamenMama";
        
        String RUTA_IR_OTRAS_ORDENES_CONTROL_EXAMEN_MAMA = "irOtrasOrdenesControlExamenMama";
        
        String RUTA_IR_ORDEN_MEDICAMENTOS_CONTROL_EXAMEN_MAMA = "irOrdenMedicamentosControlExamenMama";
        
        String RUTA_IR_OTRAS_ORDENES_CONTROL_EXAMEN_MAMA_ANESTE = "irOtrasOrdenesControlExamenMama";
        
    //CONTROL EXAMEN MAMA
    
     String RUTA_IR_DATOS_CONTROL_DERMATOLOGIA = "irDatosControlDermatologia";

     String RUTA_IR_MOTIVO_CONTROL_DERMATOLOGIA = "irMotivoControlDermatologia";

     String RUTA_IR_EXAMEN_FISICO_CONTROL_DERMATOLOGIA = "irExamenFisicoControlDermatologia";

     String RUTA_IR_INTERCONSULTA_CONTROL_DERMATOLOGIA = "irInterConsultaControlDermatologia";

     String RUTA_IR_ORDENCIRUGIA_CONTROL_DERMATOLOGIA = "irOrdenCirugiaControlDermatologia";

     String RUTA_IR_INCAPACIDAD_CONTROL_DERMATOLOGIA = "irIncapacidadControlDermatologia";

     String RUTA_IR_HOSPITALZACION_CONTROL_DERMATOLOGIA = "irRemHospitalizacionControlDermatologia";

     String RUTA_IR_AUTORIZACION_SERVICIOS_CONTROL_DERMATOLOGIA = 
         "irAutorizacionServicioControlDermatologia";

     String RUTA_IR_FORMULAMEDICA_CONTROL_DERMATOLOGIA = "irFormulaMedicaControlDermatologia";

     String RUTA_IR_VADEMCUM_CONTROL_DERMATOLOGIA = "irVademecumControlDermatologia";


     String RUTA_IR_CONTOL_SIN_COSTO_CONTROL_DERMATOLOGIA = "irControlSinCostoControlDermatologia";

     String RUTA_IR_ANATOMIAPATOLOGICA_CONTROL_DERMATOLOGIA = "irAnatPatologicaControlDermatologia";

     String RUTA_IR_APLICACION_RETITO_CONTROL_DERMATOLOGIA = "irAplicacionRetiroControlDermatologia";

     String RUTA_IR_IMPRESION_DIAGNOSTICA_CONTROL_DERMATOLOGIA = "irImpDiagnosticaControlDermatologia";

     String RUTA_IR_CONTROL_USUARIO_DERMATOLOGIA = "irControlUsuarioDermatologia";
     
     String RUTA_IR_CUESTIONARIO_COVID_CONTROL_DERMATOLOGIA = "irCuestionarioCovidControlDermatologia";


     String RUTA_IR_ANTECEDENTES_CONTROL_DERMATOLOGIA = "irAntecedentesControlDermatologia";

     String RUTA_IR_ANTECEDENTES_GENERALES_CONTROL_DERMATOLOGIA = 
         "irAntecedentesGeneralesControlDermatologia";

     String RUTA_IR_CERTIFICADO_ASISTENCIA_CONTROL_DERMATOLOGIA = 
         "irCertificadoAsistenciaControlDermatologia";

     String RUTA_IR_CERTIFICADOMEDICO_CONTROL_DERMATOLOGIA = "irCertificadoMedicoControlDermatologia";

     String RUTA_IR_ELECTROFISIOLOGICO_CONTROL_DERMATOLOGIA = 
         "irExamenElectrofisiologicosControlDermatologia";

     String RUTA_IR_IMAGENES_CONTROL_DERMATOLOGIA = "irExamenImagenesControlDermatologia";

     String RUTA_IR_LABORATORIO_CONTROL_DERMATOLOGIA = "irExamenLaboratorioControlDermatologia";

     String RUTA_IR_RECOMENDACIONES_CONTROL_DERMATOLOGIA = "irRecomendacionesControlDermatologia";

     String RUTA_IR_REFERENCIA_CONTROL_DERMATOLOGIA = "irReferenciaControlDermatologia";

     String RUTA_IR_RESERVA_SANGRE_CONTROL_DERMATOLOGIA = "irReservaSangreControlDermatologia";

     String RUTA_IR_CERRAR_CONTROL_DERMATOLOGIA = "irCerrarConsultaControlDermatologia";

     String RUTA_IR_RESUMEN_HISTORIA_ESPECIFICA_CONTROL_DERMATOLOGIA = 
         "irResumenHistoriaEspecificaControlDermatologia";

     String RUTA_IR_RESUMEN_HISTORIA_CONTROL_DERMATOLOGIA = "irResumenHistoriaControlDermatologia";
     
      String RUTA_IR_ORDEN_LIQUIDOS_CONTROL_DERMATOLOGIA = "irOrdenLiquidosControlDermatologia";
      
      String RUTA_IR_OTRAS_ORDENES_CONTROL_DERMATOLOGIA = "irOtrasOrdenesControlDermatologia";
      
      String RUTA_IR_ORDEN_MEDICAMENTOS_CONTROL_DERMATOLOGIA = "irOrdenMedicamentosControlDermatologia";
      
      String RUTA_IR_OTRAS_ORDENES_CONTROL_DERMATOLOGIA_ANESTE = "irOtrasOrdenesControlDermatologia";
      
    String RUTA_IR_REPORTE_VPH = "irReporteVph";

    String RUTA_IR_REPORTE_PRUEBAS_RAPIDAS = "irReportePruebasRapidas";
    
    String RUTA_IR_DATOS_MEDICAMENTO_SELECCION = "irDatosSeleccionMedicamento";

    String RUTA_IR_DATOS_PRUEBAS_RAPIDAS_SELECCION = "irDatosSeleccionPruebasRapidas";
    
    //ENFERMERIA ENTREGA DE RESULTADOS
     String RUTA_IR_MOTIVO_ENTREGA_RESULTADOS_ENFERMERIA =  "irMotivoEntregaResultadosEnfermeria";
     
     String RUTA_IR_CUESTIONARIO_COVID_ENTREGA_RESULTADOS_ENFERMERIA = "irCuestionarioCovidEntregaResultadosEnfermeria";

     String RUTA_IR_DATOS_ENTREGA_RESULTADOS_ENFERMERIA = 
         "irDatosEntregaResultadosEnfermeria";


     String RUTA_IR_APLICACION_RETITO_ENTREGA_RESULTADOS_ENFERMERIA = 
         "irAplicacionRetiroEntregaResultadosEnfermeria";

     String RUTA_IR_IMPRESION_DIAGNOSTICA_ENTREGA_RESULTADOS_ENFERMERIA = 
         "irImpDiagnosticaEntregaResultadosEnfermeria";

     String RUTA_IR_ENCUESTA_VIOLENCIA_ENTREGA_RESULTADOS_ENFERMERIA = 
         "irEncuestaViolenciaEntregaResultadosEnfermeria";

     String RUTA_IR_EXAMEN_FISICO_ENTREGA_RESULTADOS_ENFERMERIA = 
         "irExamenFisicoEntregaResultadosEnfermeria";

     String RUTA_IR_ANTECEDENTES_GENERALES_ENTREGA_RESULTADOS_ENFERMERIA = 
         "irAntecedentesGeneralesEntregaResultadosEnfermeria";

     String RUTA_IR_ANTECEDENTES_TEMPORALES_ENTREGA_RESULTADOS_ENFERMERIA = 
         "irAntecedentesTemporalesEntregaResultadosEnfermeria";

     String RUTA_IR_ANTECEDENTES_ENTREGA_RESULTADOS_ENFERMERIA = 
         "irAntecedentesEntregaResultadosEnfermeria";

     String RUTA_IR_ANTECEDENTES_GINECOLOGICOS_ENTREGA_RESULTADOS_ENFERMERIA = 
         "irAntecedentesGinecologicosEntregaResultadosEnfermeria";

     String RUTA_IR_RECOMENDACIONES_ENTREGA_RESULTADOS_ENFERMERIA = 
         "irRecomendacionesEntregaResultadosEnfermeria";

     String RUTA_IR_FORMULAMEDICA_ENTREGA_RESULTADOS_ENFERMERIA = 
         "irFormulaMedicaEntregaResultadosEnfermeria";


     String RUTA_IR_VADEMCUM_ENTREGA_RESULTADOS_ENFERMERIA = 
         "irVademecumEntregaResultadosEnfermeria";


     String RUTA_IR_CERRAR_CONSULTA_ENTREGA_RESULTADOS_ENFERMERIA = 
         "irCerrarConsultaEntregaResultadosEnfermeria";

     String RUTA_IR_RESUMEN_ESPECIFICO_ENTREGA_RESULTADOS_ENFERMERIA = 
         "irResumenHistoriaEspecificaEntregaResultadosEnfermeria";

     String RUTA_IR_RESUMEN_ENTREGA_RESULTADOS_ENFERMERIA = 
         "irResumenHistoriaEntregaResultadosEnfermeria";

     String RUTA_IR_METODO_PLANIFICACION_ENTREGA_RESULTADOS_ENFERMERIA = 
         "irMetodoPlanificacionEntregaResultadosEnfermeria";
         
     String RUTA_IR_INTERCONSULTA_ENTREGA_RESULTADOS_ENFERMERIA = 
         "irInterConsultaEntregaResultadosEnfermeria";

     String RUTA_IR_ORDENCIRUGIA_ENTREGA_RESULTADOS_ENFERMERIA = 
         "irOrdenCirugiaEntregaResultadosEnfermeria";

     String RUTA_IR_INCAPACIDAD_ENTREGA_RESULTADOS_ENFERMERIA = 
         "irIncapacidadEntregaResultadosEnfermeria";

     String RUTA_IR_HOSPITALZACION_ENTREGA_RESULTADOS_ENFERMERIA = 
         "irRemHospitalizacionEntregaResultadosEnfermeria";

     String RUTA_IR_CONTOLSINCOSTO_ENTREGA_RESULTADOS_ENFERMERIA = 
         "irControlSinCostoEntregaResultadosEnfermeria";

     String RUTA_IR_ANATOMIAPATOLOGICA_ENTREGA_RESULTADOS_ENFERMERIA = 
         "irAnatPatologicaEntregaResultadosEnfermeria";

     String RUTA_IR_CERTIFICADO_ASISTENCIA_ENTREGA_RESULTADOS_ENFERMERIA = 
         "irCertificadoAsistenciaEntregaResultadosEnfermeria";

     String RUTA_IR_CERTIFICADOMEDICO_ENTREGA_RESULTADOS_ENFERMERIA = 
         "irCertificadoMedicoEntregaResultadosEnfermeria";

     String RUTA_IR_ELECTROFISIOLOGICO_ENTREGA_RESULTADOS_ENFERMERIA = 
         "irExamenElectrofisiologicosEntregaResultadosEnfermeria";

     String RUTA_IR_IMAGENES_ENTREGA_RESULTADOS_ENFERMERIA = 
         "irExamenImagenesEntregaResultadosEnfermeria";

     String RUTA_IR_LABORATORIO_ENTREGA_RESULTADOS_ENFERMERIA = 
         "irExamenLaboratorioEntregaResultadosEnfermeria";


     String RUTA_IR_REFERENCIA_ENTREGA_RESULTADOS_ENFERMERIA = 
         "irReferenciaEntregaResultadosEnfermeria";

     String RUTA_IR_AUTORIZACION_SERVICIO_ENTREGA_RESULTADOS_ENFERMERIA = 
         "irAutorizacionServicioEntregaResultadosEnfermeria";

     String RUTA_IR_RESERVA_SANGRE_ENTREGA_RESULTADOS_ENFERMERIA = 
         "irReservaSangreEntregaResultadosEnfermeria";
         
    String RUTA_IR_PAUSAR_CONSULTA_ENTREGA_RESULTADOS_ENFERMERIA = "irPausarConsultaEntregaResultadosEnfermeria";
    
    String RUTA_IR_SERVICIOS_ADMISION_ENTREGA_RESULTADOS_ENFERMERIA = "irServiciosAdmisionEntregaResultadosEnfermeria";
    
    String RUTA_IR_ORDEN_LIQUIDOS_ENTREGA_RESULTADOS_ENFERMERIA = "irOrdenLiquidosEntregaResultadosEnfermeria";
    
    String RUTA_IR_ORDEN_MEDICAMENTOS_ENTREGA_RESULTADOS_ENFERMERIA = "irOrdenMedicamentosEntregaResultadosEnfermeria";
    
    String RUTA_IR_CONTROL_USUARIO_ENTREGA_RESULTADO_ENFERMERIA = "irControlUsuarioEntregaResultadoEnfermeria";
    
    String RUTA_IR_REPORTE_CANCER_CERVIX = "irReporteCancerCervix";
    
    String RUTA_IR_PARAMETRIZACION_CORREOS = "irParametrizacionCorreos";

    String RUTA_IR_FRAGMENTACION_ESPERMA = "irFragmentacionEsperma";
    
    String RUTA_IR_IMPRESION_PRUEBAS_COVID = "irImpresionPruebasCovid";
    
    String RUTA_IR_APLICACION_RETITO_INTERRUPCION_ILVE = "irAplicacionRetiroInterrupcion";
    
    String RUTA_IR_METODO_INTERRUPCION = "irMetodoInterrupcion";


    String RUTA_IR_DATOS_FRAGMENTACION_ESPERMA= "irDatosFragmentacionEsperma";
   
    String RUTA_IR_CUESTIONARIO_COVID_FRAGMENTACION = "irCuestionarioCovidFragmentacion";    
    
    String RUTA_IR_TEST_FRAGMENTACION_ESPERMA = "irTestFragmentacion";   

    String RUTA_IR_CIERRE_FRAGMENTACION_ESPERMA = "irCierreFragmentacion"; 
    
    String RUTA_IR_MOSTRAR_ERROR = "irMostrarError";
    
    String RUTA_COPIA_TEST_FRAGMENTACION_ESPERMA= "irCopiaTestFragmentacionE";
    
    String RUTA_IR_CONSENTIMIENTO_INFORMADO = "irConsentimientoInformado";
    
    String RUTA_IR_REP_WS_SALUD_TOTAL= "irReprocesoWSSaludTotal";
    
    String RURA_IR_INTERCONSULTA_APOYO_DIAGNOSTICO ="irInterConsultaApoyoDiag";
}
