package org.profamilia.hc.view.constantes;

import java.math.BigDecimal;


public interface IConstantes extends IMsg {


    /* Contantes Negocio*/

    // Ubicaci�n del sistema    
    String COUNTRY = "CO";
    String LANGUAGE = "es";
    String VARIANT = "";

    // Zona Horaria del sistema    
    String TIME_ZONE = "America/Bogota";


    // Clinicas

    Integer CLINICA_PILOTO = 1;

    //DATA TABLES    
    Integer SIZE_DATATABLE = 30;

    // CLSERVICIO    
    Integer SERVICIO_NIVEL_DE_USO_ALTO = 0;
    Long SERVICIO_TIPO_DE_SERVICIO_LABORATORIO = 150L;

    //CPSERVXCON    
    Integer TIPO_USUARIO_PARTICULAR = 1;

    //CPSERVICIO    
    Integer TIPO_SERVICIO = 1;
    String ETAPA_CERRADA = "CE";
    String ETAPA_ABIERTO = "AB";
    String ETAPA_ATENDIDO = "AT";
    String ETAPA_SUSPENDER = 
        "SP"; // CIRUGIA ANESTESIA SUSPENDIDO LIQUIDO ANTES DE PASAR TODO
    String ETAPA_ESPERA = 
        "ES"; // CIRUGIA ANESTESIA ESPERA DE SER ADMINISTRADO EL LIQUIDO
    String ETAPA_INGRESADO = "IG"; // CIRUGIA ANESTESIA INICIALIZADO EL LIQUIDO
    String ETAPA_NO_APLICA = "NA";
    String ETAPA_DELETE = "DL";

    // ANESTESIA
    String ANESTESIA = "AN";
    // CIRUGIA ANESTESIA LIQUIDO ADMINISTRADO
    String ETAPA_ADMINISTRADO = "AD";
    // CIRUGIA ANESTESIA INICIAR LIQUIDO
    String ETAPA_INICIADO_LIQUIDO = "IL";


    // ETAPA CONTROL DE LIQUIDOS (CIRUGIA)

    String ETAPA_INGRESO = "I";
    String ETAPA_SALAS = "S";
    String ETAPA_RECUPERACION = "R";
    String ESTADO_VIGENTE = "VG";
    String ESTADO_SIN_MOVIMIENTO = "SM";
    String ESTADO_CON_MOVIMIENTO = "CM";
    String ESTADO_SUSPENDER = "SP";
    String ESTADO_REGISTRO = "RG";
    String ESTADO_ANULADO = "XX";
    String ESTADO_PROGRAMADO = "PR";
    String ESTADO_INACTIVO = "IN";
    String ESTADO_ACTIVO = "AC";
    String ESTADO_CERRADO = "CE";


    String CEN_REGISTRO = "ER";
    String CEN_SALA = "ES";
    String CEN_CONSULTA = "EC";
    String CATENDIDA = "AT";


    // Alerta de Signos Vitales
    Integer presion_mmmin = 90;
    Integer presion_mmmax = 150;
    Integer presion_Hgmin = 60;
    Integer presion_Hgmax = 120;
    Integer frec_cardmax = 100;
    Integer frec_cardmin = 50;
    Integer frec_respmin = 12;
    Integer frec_respmax = 20;
    BigDecimal febril_cent = new BigDecimal(37.4);
    BigDecimal febril_min = new BigDecimal(36);
    Integer saturacion = 90;
    Integer saturacion_maxima = 100;
    Integer rango_edad = 18;


    // Etapas de Control de Medicamentos

    String ETAPA_VIGENTE = "VG";
    String ETAPA_PARCIAL = "PA";

    //CPCONTRATO    
    Integer TIPO_PARTICULAR = 0;

    /* Tipos de Historia */
    Integer HISTORIA_TODAS = 0;
    Integer HISTORIA_SALUD_SEXUAL = 1;
    Integer HISTORIA_ANTICONCEPCION_TEMPORAL = 2;
    Integer HISTORIA_PEDIATRIA = 3;
    Integer HISTORIA_EXAMEN_MAMA = 4;
    Integer HISTORIA_PSICOLOGICA = 5;
    Integer HISTORIA_PRENATAL = 6;
    Integer HISTORIA_CONTROL = 7;
    Integer HISTORIA_CONTROL_PRENATAL = 8;
    Integer HISTORIA_PROCEDIMIENTOS_CONSULTORIO = 9;
    Integer HISTORIA_PROCEDIMIENTO_CITOLOGIA_TOMA = 10;
    Integer HISTORIA_PROCEDIMIENTO_VPH_TOMA = 50;
    Integer HISTORIA_CONTROL_FERTILIDAD = 48;
    Integer HISTORIA_PROCEDIMIENTO_CITOLOGIA_TOMA_BASELIQUIDA = 51;
    Integer HISTORIA_LECTURA_CITOLOGIA_CONVENCIONAL = 47;
    Integer HISTORIA_LECTURA_CITOLOGIA_BASE_LIQUIDA = 52;
    Integer HISTORIA_LECTURA_VPH_BASE_LIQUIDA = 53;
    Integer HISTORIA_ENTREGA_RESULTADO = 54;
    Integer HISTORIA_TOMA_TUBERCULINA = 55;
    Integer HISTORIA_LECTURA_TUBERCULINA = 56;
    Integer HISTORIA_TOMA_HISTEROSCOPIA = 57;

    Integer HISTORIA_PROCEDIMIENTO_COLPOSCOPIA = 11;
    Integer APOYO_INFORME_MAMOGRAFIA = 12;
    Integer APOYO_INFORME_MARCACION_SENO = 13;
    Integer APOYO_INFORME_CITOPUNCION = 14;
    Integer APOYO_INFORME_ECOGRAFIA = 15;
    Integer APOYO_INFORME_HISTEROSONOGRAFIA = 16;
    Integer HISTORIA_PREANESTESIA = 17;
    Integer HISTORIA_CONTROL_PREANESTESIA = 18;
    Integer HISTORIA_ESTERILIZACION_FEMENINA = 19;
    Integer HISTORIA_ESTERILIZACION_MASCULINA = 20;
    Integer HISTORIA_CONTROL_ANTICONCEPCION_TEMPORAL = 21;
    Integer HISTORIA_CERVIX = 22;
    Integer HISTORIA_CERVIX_VACUNACION = 23;
    Integer HISTORIA_PSICOLOGICA_CONTROL = 24;
    Integer HISTORIA_PROCEDIMIENTO_CITOLOGIA_LECTURA = 25;


    Integer HISTORIA_INTERRUPCION = 26;
    Integer HISTORIA_OTRAS_ESPECIALIDADES = 27;
    Integer HISTORIA_ANTICONCEPCION_INSERCION = 28;
    Integer HISTORIA_ANTICONCEPCION_RETIRO = 29;
    Integer HISTORIA_FERTILIDAD = 30;
    Integer HISTORIA_CONTROL_VASECTOMIA = 31;
    Integer HISTORIA_EFECTO_JOVEN = 32;
    Integer HISTORIA_CONTROL_INTERRUPCION = 33;
    Integer CIRUGIA_LIGADURA_POR_BIPOLAR = 34;
    Integer CIRUGIA_PROCEDIMIENTO_CONSULTORIO_IVE = 35;
    Integer HISTORIA_ESPERMOGRAMA_FERTILIDAD = 42;
    Integer CIRUGIA_VASECTOMIA = 44;
    Integer CIRUGA_DIVERSIFICACION = 45;
    Integer CIRUGIA_IVE = 46;
    Integer HISTORIA_GINECOLOGIA = 62;
    Integer HISTORIA_CONTROL_GINECOLOGIA = 63;
    Integer HISTORIA_UROLOGIA = 64;
    Integer HISTORIA_CONTROL_UROLOGIA = 65;
    Integer HISTORIA_CONTROL_EXAMEN_MAMA = 66;
    Integer HISTORIA_CONTROL_DERMATOLOGIA = 67;
    Integer HISTORIA_TEST_FRAGMENTACION_ESPERMA = 68;
    


    Integer HISTORIA_MANUAL = 99;
    Integer HISTORIA_LABORATORIOS = 98;


    /* Historias Medicamentos y Vacunacion */
    Integer HISTORIA_ADMINISTRAR_MEDICAMENTO = 40;
    Integer HISTORIA_VACUNACION = 41;

    /* Contantes Negocio*/

    String OTRO_METODO = "0";
    String ANTECEDENTES_GENERALES = "G";
    String ANTECEDENTES_PEDIATRICOS = "P";
    String ANTECEDENTES_PRENATAL = "PN";
    String AMBOS_ANTECEDENTES = "A";
    String NO_EXISTEN_CONSULTAS_PARA_LA_FECHA = "No existen consultas para: ";
    String NO_EXISTEN_LABORATORIOS_PARA_LA_FECHA = 
        "No existen laboratorios para: ";
    String NO_EXISTEN_ESPERMOGRAMAS_PARA_LA_FECHA = 
        "No existen consultas para: ";

    String NO_EXITEN_CIRUGIAS_PARA_EL_DIA = 
        "No existen Cirugias para el D�a:  ";

    String NO_EXISTEN_CONSULTAS_EN_CONSULTORIO_PARA_LA_FECHA = 
        "No existen consultas en consultorio para: ";

    String NO_EXISTEN_CITOLOGIAS_PARA_LA_FECHA = 
        "No existen Citologias para: ";

    String NO_EXISTEN_VPH_PARA_LA_FECHA = "No existen Vph para: ";

    /*Constantes Cuestionario Antecedentes Temporales */

    Integer UTILIZA_METODO_PLANIFICACION = 5;

    /*Constantes tipo documento */

    Integer DOCUMENTO_CONSULTA_CLINICA = 60;
    Integer CONSECUTIVO_CONTROL = 16;
    Integer CONSECUTIVO_ASESORIA = 17;


    /*Constantes de sexo */

    String SEXO_MASCULINO = "M";
    String SEXO_FEMENINO = "F";
    String SEXO_AMBIGUO = "A";
    String SEXO_TRANSEXUAL = "T";
    String SEXO_AMBOS = "A";

    /* Variable que almacena  */

    Integer OFFSET_DATATABLE = 0;

    /* Contantes Negocio*/

    String ANTECEDENTE_NIEGA_DESCRIPCION = 
        "El Usuario niega tener nuevos antecedentes";
    String ANTECEDENTE_TIENE_DESCRIPCION = 
        "El Usuario tiene nuevos antecedentes";

    /* Codigo del servicio de Control Prenatal */

    String SERVICIO_PRENATAL = "890202.5";

    // Tipos de examenes Paraclinicos

    String EXAMENES_ELECTROFISIOLOGICOS = "1";
    String EXAMENES_IMAGENES = "2";
    String EXAMENES_LABORATORIOS = "3";
    Integer MENU_MODIFICAR_DATOS_USUARIO = 0;
    Integer MENU_REIMPRIMIR_DOCUMENTOS = 1;
    Integer MENU_LECTURA_CITOLOGIA = 2;
    Integer MENU_ENTREGA_CITOLOGIA = 3;
    Integer MENU_PROGRAMAR_CIRUGIA = 4;
    Integer MENU_LECTURA_VPH = 5;
    Integer MENU_MODIFICAR_VPH = 23;
    Integer MENU_ENTREGA_VPH = 6;
    Integer MENU_LECTURA_VPH_CITOLOGIA = 7;
    Integer MENU_LECTURA_CITOLOGIA_VPH = 8;
    Integer MENU_MODIFICAR_CITOLOGIA = 22;

    String CONDUCTA_ANATOMIA_PATOLOGICA = "1";
    String CONDUCTA_REFERENCIA = "2";
    String CONDUCTA_ORDEN_CIRUGIA = "3";
    String CONDUCTA_FORMULA_MEDICA = "4";
    String CONDUCTA_INCAPACIDAD = "5";
    String CONDUCTA_EXAMENES_ELECTROFISIOLOGICOS = "6";
    String CONDUCTA_EXAMENES_IMAGENES = "7";
    String CONDUCTA_EXAMENES_LABORATORIOS = "8";
    String CONDUCTA_CONTROL_SIN_COSTO = "9";
    String CONDUCTA_INTERCONSULTA = "10";
    String CONDUCTA_CERTIFICADO_ASISTENCIA = "11";
    String CONDUCTA_CERTIFICADO_MEDICO = "12";
    String CONDUCTA_REMISION_HOSPITALIZACION = "13";
    String CONDUCTA_RESERVA_SANGRE = "14";
    String CONDUCTA_RECOMENDACIONES = "15";
    //    String CONDUCTA_ESPERMOGRAMA = "11";
    String CONDUCTA_FORMULA_MEDICA_CIRUGIA = "16";
    String CONDUCTA_AUTORIZACION_SERVICIO = "17";


    // Causas Seleccionadas

    String CAUSA_ACCIDENTE_TRABAJO = "1";
    String CAUSA_ACCIDENTE_TRANSITO = "2";
    String CAUSA_ACCIDENTE_RABICO = "3";
    String CAUSA_ACCIDENTE_OFIDICO = "4";
    String CAUSA_OTRO_TIPO_ACCIDENTE = "5";
    String CAUSA_EVENTO_CATASTROFICO = "6";
    String CAUSA_LESION_POR_AGRESION = "7";
    String CAUSA_LESION_AUTO_INFLIGIDA = "8";
    String CAUSA_SOSPECHA_MALTRATO_FISICO = "9";
    String CAUSA_SOSPECHA_ABUSO_SEXUAL = "10";
    String CAUSA_SOSPECHA_VIOLENCIA_SEXUAL = "11";
    String CAUSA_SOSPECHA_MALTRATO_EMOCIONAL = "12";
    String CAUSA_ENFERMEDAD_GENERAL = "13";
    String CAUSA_ENFERMEDAD_PROFESIONAL = "14";
    String CAUSA_OTRA = "15";

    // TIPO DIAGNOSTICO

    Integer TIPO_IMPRESION_DIAGNOSTICA = 1;
    Integer TIPO_IMPRESION_CONFIRMADO_NUEVO = 2;
    Integer TIPO_IMPRESION_CONFIRMADO_REPETIDO = 3;

    // DIAGNOSTICO PRINCIPAL

    String DIAGNOSTICO_EXAMEN_MEDICO_GENERAL = "Z000";
    String DIAGNOSTICO_OTROS_CUIDADOS_POSTERIORES_CIRUGIA = "Z488";
    String DIAGNOSTICO_CIRUGIA_POMEROY_VASECTOMIA = "Z302";

    // Finalidades Consulta

    String FINALIDAD_PROCEDIMIENTO_DIAGNOSTICO = "1";
    // Finalidades Consulta

    String FINALIDAD_CONSULTA_ATENCION_PARTO = "1";
    String FINALIDAD_CONSULTA_ATENCION_RECIEN_NACIDO = "2";
    String FINALIDAD_CONSULTA_PLANIFICACION = "3";
    String FINALIDAD_CONSULTA_DET_ALTERACIONES_CREC = "4";
    String FINALIDAD_CONSULTA_DET_ALTERACIONES_DESARROLLO_JOVEN = "5";
    String FINALIDAD_CONSULTA_DET_ALTERACIONES_EMBARAZO = "6";
    String FINALIDAD_CONSULTA_DET_ALTERACIONES_ADULTO = "7";
    String FINALIDAD_CONSULTA_DET_ALTERACIONES_AGUDEZA_VISUAL = "8";
    String FINALIDAD_DET_ENFERMEDAD_PROFESIONAL = "9";
    String FINALIDAD_CONSULTA_NO_APLICA = "10";
    int CCONCITO = 13;
    int CCONUSUA = 15;
    int CCONCNCL = 4;
    int CCONCGSF = 19;
    int CCAUTSER = 20;
    int CCONCOSF = 21;
    int CCONVPH = 30;


    // Caso de Uso de Citologias

    String CALIDAD_DE_MUESTRA_OTROS = "5.6";
    String ANORMALIDADES_CELULARES_EPTITELIALES = "6.2";
    String CERTIFICADO_MEDICO = "M";
    String CERTIFICADO_ASISTENCIA = "A";
    String SIN_CIRUGIA = "Debe Seleccionar la Cirugia Programada";

    // Tipo de Reportes 

    String INFORME_MAMOGRAFIA = "1";
    String INFORME_MARCACION_SENO = "2";
    String INFORME_CITOPUNCION_SENO = "3";
    String INFORME_ECOGRAFIA = "4";
    String INFORME_HISTEROSONOGRAFIA = "5";

    // Posibles Estados de Ccfactvent

    int CENPROCESO = 0;
    int CASENTADO = 1;
    int CANULADO = 2;
    int CAPLICADO = 3;
    int CNOTACRED = 4;

    // Codigos Profesionales


    Integer CODIGO_SIN_ANTECEDENTES = 0;
    Integer CODIGO_ANTECEDENTE_ALERGICOS = 1;
    Integer CODIGO_ANTECEDENTE_ITS = 2;
    Integer CODIGO_ANTECEDENTE_FAMILIARES = 3;
    Integer CODIGO_ANTECEDENTE_PATOLOGICOS = 4;
    Integer CODIGO_ANTECEDENTE_QUIRURGICOS = 5;
    Integer CODIGO_ANTECEDENTE_FARMACOLOGICO = 6;
    Integer CODIGO_ANTECEDENTE_TRASNFUSIONALES = 7;
    Integer CODIGO_ANTECEDENTE_TRAUMATICOS = 8;
    Integer CODIGO_ANTECEDENTE_TOXICOS = 9;
    Integer CODIGO_ANTECEDENTE_MEDICACION_EMBARAZO = 10;
    Integer CODIGO_ANTECEDENTE_PARTO = 11;
    Integer CODIGO_ANTECEDENTE_PERINATALES = 12;
    Integer CODIGO_ANTECEDENTE_INMUNIZACIONES = 13;
    Integer CODIGO_ANTECEDENTE_SICOMOTOR = 14;
    Integer CODIGO_ANTECEDENTE_ALIMENTACION = 15;
    Integer CODIGO_ANTECEDENTE_HOSPITALIZACIONES = 16;
    Integer CODIGO_ANTECEDENTE_NIEGA = 0;
    Integer CODIGO_ANTECEDENTE_NUEVOS_ANTECEDENTES = 99;
    Integer CODIGO_EXAMEN_ELECTROFISIOLOGICO = 1;
    Integer CODIGO_EXAMEN_IMAGENES = 2;
    Integer CODIGO_EXAMEN_LABORATORIOS = 3;
    Integer CONCEPTO_RIPS_CONSULTA_EXTERNA = 1;
    Integer CONCEPTO_RIPS_PROCEDIMIENTO = 1;

    // Constantes de Tipo de Documento

    int CDOC_FACTURA = 2;
    int CDOC_RECMAN = 20;
    int CDOC_FACVEN = 51;
    int CDOC_CISFAC = 30;
    int CDOC_FACSAP = 90;
    int CDOC_IVEFAC = 31;
    int CDOC_ADMISION = 100;

    // Codigos de los Grupos

    Integer GRUPO_ANTICONCEPCION = 61;
    Integer GRUPO_SALUD_SEXUAL_REPRODUCTIVA = 65;


    // Codigos de los SubGrupos

    Integer SUBGRUPO_CONSULTAS_CLINICAS = 1;
    Integer SUBGRUPO_CIRUGIAS_TIPO1 = 5;
    Integer SUBGRUPO_PLANIFICACION_TEMPORAL = 4;

    Integer SUBGRUPO_PSICOLOGIA = 2;
    // Tipos

    String TIPO_CONSULTA = "C";
    String TIPO_PROCEDIMIENTO = "P";
    String TIPO_HOSPITALIZACION = "H";

    // Tipos de Usuario segun profesion

    Integer MEDICO = 1;

    // Tipos de Consultas para Buscar los usuarios y navegue a la opcion necesitada

    Integer CONSULTAR_USUARIO_DESCRIPCION = 1;
    Integer CONSULTAR_USUARIO_NOTA_OPERATORIA = 2;
    Integer CONSULTAR_USUARIO_REGISTRO_NOTA_OPERATORIA = 3;

    // En Signo vital se pide de donde se esta generando el signo vital si es de Enfermeria, o es de Anestesia

    String TIPO_PROCEDIMIENTO_ENFERMERIA = "E";
    String TIPO_PROCEDIMIENTO_ANESTESIA = "A";

    // ANTICONCEPCION FEMENINA

    Integer HISTORIA_ANTICONCEPCION_QUIRURGICA_FEMENINA = 19;
    String REGISTRAR_LIQUIDO_ADMINISTRADO = "A";
    String REGISTRAR_LIQUIDO_ELIMINADO = "E";
    String OTRO_LIQUIDO_PARENTAL = "07";


    // Estados de las citologias

    String CITOLOGIA_ENV_LECTURA_UNO = "ELU";
    String CITOLOGIA_REG_LECTURA_UNO = "RLU";
    String CITOLOGIA_ENV_LECTURA_DOS = "ELD";
    String CITOLOGIA_REG_LECTURA_DOS = "RLD";
    String CITOLOGIA_ENTREGADA_USUARIO = "EU";

    String VPH_ENV_LECTURA = "ELE";
    String VPH_REG_LECTURA = "RLE";
    String VPH_ENTREGADA_USUARIO = "EU";

    String PATOLOGIA_ENV_LAB = "EL";
    String PATOLOGIA_REG_DIA = "RD";
    String PATOLOGIA_ENT_USU = "EU";

    // Estado de resultados 

    String POSITIVO = "P";
    String NEGATIVO = "N";
    String NO_RECIBIDO = "NR";

    // Tipos de Lecturas para Citologias

    String PRIMERA_LECTURA = "PL";
    String SEGUNDA_LECTURA = "SL";


    String PRIMERA_LECTURA_MOD = "PLM";
    String SEGUNDA_LECTURA_MOD = "SLM";

    // Tipos de Consultorios 

    String TIPO_SALA = "S";


    String ERROR_SERICIO_NO_ASOCIADO = 
        "El servicio no tiene un Tipo de Historia Asociado, Por Favor comun�quese con la Gerencia de Salud, Contrataci�n ";


    String ERROR_SERICIO_NO_HABILITADO = 
        "El servicio no tiene un Tipo de Historia Asociado,� el servicio no esta en las consultas que puede prestar, Por Favor comun�quese con el Departamento de Sistemas";

    // PRIORIDAD SERVICIOS

    String TIENE_PRIORIDAD = "S";
    String NO_TIENE_PRIORIDAD = "N";


    // IMAGENES

    String IMAGE_PROFAMILIA = "/comun/imagenes/profamilia_negro.gif";
    String IMAGE_FIRMA_KAREN_MARROQUIN = 
        "/comun/imagenes/firmaKarenMarroquin.jpg";
    String IMAGE_FIRMA_LAURA_HERRERA = "/comun/imagenes/firmaLauraHerrera.png";
    String IMAGE_FIRMA_DIANA_SALCEDO = 
        "/comun/imagenes/firmaDianaAlessaSalcedoGomez.jpg";
    String IMAGE_FIRMA_KAREN_MEDINA  = "/comun/imagenes/firmaKarenMedina.png";
    String IMAGE_PROFAMILIA_VERDE = "/comun/imagenes/profamilia.gif";
    String IMAGE_PROFAMILIA_NEW = "/comun/imagenes/profamilia-nuevo.jpg";

    String IMAGE_PROFAMILIA_FERTILIDAD = 
        "/comun/imagenes/profa_fertilidad.jpg";
    String IMAGE_PROFAMILIA_PRINCIPAL = 
        "/comun/imagenes/versionprincipal_3.jpg";
    String IMAGE_COLPOSCOPIA = "/comun/imagenes/colposcopiaImpresion.jpg";

    String IMAGE_PROFAMILIA_POLICIA = "/comun/imagenes/policiaNacional.png";
    String IMAGE_SUPER_HORIZONTAL = 
        "/comun/imagenes/logosupersalud_horizontal.gif";
    String IMAGE_SUPER_VERTICAL = "/comun/imagenes/logosupersalud.gif";
    String IMAGE_INS = "/comun/imagenes/ins.gif";
    String IMAGE_REPCOL = "/comun/imagenes/republicadecolombia.gif";
    String IMAGE_ESCUDO_COLOMBIA = "/comun/imagenes/Escudo_Colombia.jpg";

    String IMAGE_ESP_NORMAL = "/comun/imagenes/Esperm_Normal.jpg";
    String IMAGE_ESP_LIGELO = "/comun/imagenes/Esperm_LigElongado.jpg";
    String IMAGE_ESP_MARELO = "/comun/imagenes/Esperm_MarElongado.jpg";
    String IMAGE_ESP_ANOACR = "/comun/imagenes/Esperm_AnoAcrosoma.jpg";
    String IMAGE_ESP_MACRO = "/comun/imagenes/Esperm_Macrocefalo.jpg";
    String IMAGE_ESP_MICRO = "/comun/imagenes/Esperm_Microcefalo.jpg";
    String IMAGE_ESP_DOBCAB = "/comun/imagenes/Esperm_DobCabeza.jpg";
    String IMAGE_ESP_ANGUL = "/comun/imagenes/Esperm_Angulado.jpg";
    String IMAGE_ESP_FLAENR = "/comun/imagenes/Esperm_FlaEnrollado.jpg";
    String IMAGE_ESP_DOBFLA = "/comun/imagenes/Esperm_DobFlagelojpg";


    //CODIGOS VACUNACION VPH

    String CODIGO_VACUNACION_CERVIX_PRIMERA_TOMA = "2008078";
    String CODIGO_VACUNACION_CERVIX_SEGUNDA_TOMA = "2008079";
    String CODIGO_VACUNACION_CERVIX_TERCERA_TOMA = "2008080";


    String CODIGO_VACUNACION_CERVIX_PRIMERA_TOMA_PAQUETE = "PVAC001";
    String CODIGO_VACUNACION_CERVIX_SEGUNDA_TOMA_PAQUETE = "PVAC002";
    String CODIGO_VACUNACION_CERVIX_TERCERA_TOMA_PAQUETE = "PVAC003";


    String CODIGO_VACUNACION_GARDASIL_PRIMERA_TOMA = "2008081";
    String CODIGO_VACUNACION_GARDASIL_SEGUNDA_TOMA = "2008082";
    String CODIGO_VACUNACION_GARDASIL_TERCERA_TOMA = "2008083";

    String CODIGO_VACUNACION_GARDASIL_PRIMERA_TOMA_PAQUETE = "PVAC004";
    String CODIGO_VACUNACION_GARDASIL_SEGUNDA_TOMA_PAQUETE = "PVAC005";
    String CODIGO_VACUNACION_GARDASIL_TERCERA_TOMA_PAQUETE = "PVAC006";

    String GENERO_RESUMEN_HISTORIA = "G";
    String IMPRIMIO_RESUMEN_HISTORIA = "I";


    String APLICACION_HISTORIAS_CLINICAS = "HISTORIAS";


    // CODIGO CIE10 EMBARAZO CONFIRMADO

    //    String CODIGO_EMBARAZO_CONFIRMADO = "Z321";

    // String CODIGO_PROBLEMAS_CON_EMBARAZADO_NO_DESEADO = "Z640";

    String CODIGO_PRINCIPAL_ABORTO_MEDICO = "O049";

    String CODIGO_PRINCIPAL_CONSULTA_ILVE = "F412";

    String CODIGO_REL1_EXTRACCION_MENSUAL = "Z303";

    String CODIGO_REL2_ASESORAMIENTO_GENERAL_ANTICONCEPCION = "Z300";

    String CODIGO_REL3_ASESORAMIENTO_GENERAL_ANTICONCEPCION = "Z300";

    String CODIGO_REL3_PROBLEMAS_EMBARAZO_NO_DESEADO = "Z640";

    String CODIGO_RELACIONADO2_CONSULTA_ILVE = "Z359";


    String CODIGO_NINGUN_METODO = "9999";

    String CODIGO_DIAGNOSTICO_RELACIONADO1 = "Z303";

    String CODIGO_DIAGNOSTICO_RALACIONADO2 = "Z300";

    String CODIGO_DIAGNOSTICO_RELACIONADO3 = "Z640";


    // TIPOS DE INTERVENCION EN ASESORIA

    int INTERVENCION_CRISIS = 1;

    int EMBARAZO_NO_PLANEADO = 2;

    int REALIZACION_IVE = 3;

    int ABORTO_INCOMPLETO = 4;

    int RIESGO_VIDA_SALUD = 5;

    int VIOLENCIA_SEXUAL = 6;

    int MALFORMACIONES_FETALES = 7;

    int METODO_EMERGENCIA_ABUSO_SEXUAL = 8;

    int VIOLENCIA_FISICA = 9;

    int VIOLENCIA_SICOLOGICA = 10;


    // TIPOS DE PROFESIONAL 

    int TIPO_MEDICO_ESPECIALISTA = 1;

    int TIPO_MEDICO_GENERAL = 2;

    int TIPO_MEDICO_CIRUJANO_PLASTICO = 10;

    int TIPO_CIRUJANO_GENERAL = 11;

    int TIPO_MEDICO_UROLOGO = 17;

    int TIPO_RESIDENTE = 5;

    BigDecimal CODIGO_LABORATORIO_CITOPATOLOGIA = new BigDecimal(11399);

    String CODIGO_CONSULTA_ANESTESIA = "890202.15";


    // ETAPAS NOTA ENFERMERIA ENFERMERIA

    //String ETAPA_NOTA_INGRESO = "IG";
    //String ETAPA_NOTA_RECUPERACION_INMEDIATA = "RI";
    //String ETAPA_NOTA_RECUPERACION_MEDIATA = "RM";
    String ETAPA_NOTA_RECUPERACION_FINAL = "RF";


    //CONSTANTES PARA WEBSERVICE SAP CREACION CLIENTE 

    String DATOS_GENERAL_CLASIFICACION_DEUDOR = "1";
    String DATOS_GENERAL_PERSONA_FISICA = "X";
    String DATOS_GENERAL_CLAVE_PAIS = "CO";
    String DATOS_LIS = "PN";
    String DATOS_SOCIEDAD_SOCIEDAD = "PRFI";
    String DATOS_SOCIEDAD_CLAVE_COND_PAGO = "D01A";
    String DATOS_SOCIEDAD_CUENTA_ASOCIADA = "1302250505";
    String DATOS_SOCIEDAD_GRUPO_TESORERIA = "5101";
    String DATOS_SOCIEDAD_CLAVE_ASIG = "031";
    String DATOS_COMERCIAL_ORG_VENTAS = "1100";
    String DATOS_COMERCIAL_CANALDIST = "00";
    String DATOS_COMERCIAL_SECTOR = "00";
    String DATOS_COMERCIAL_ESQUEMA_CLIENTE = "1";
    String DATOS_COMERCIAL_COND_EXPEDICION = "01";
    String DATOS_COMERCIAL_GRUP_IMPUT_CLIENTE = "01";
    String DATOS_COMERCIAL_CLAVE_COND_PAGO = "D01A";
    String DATOS_COMERCIAL_GRUPO_CLIENTES = "17";
    String DATOS_COMERCIAL_CLAVE_MONEDA = "COP";
    String CLIENTE_CONTACTO_FUNCION_CONTACTO = "00";


    Integer DIAGNOSTICO_PRINCIPAL = 0;
    Integer DIAGNOSTICO_RELACIONADO1 = 1;
    Integer DIAGNOSTICO_RELACIONADO2 = 2;
    Integer DIAGNOSTICO_RELACIONADO3 = 3;


    Integer CONTROL_ILVE_QUIRURGICO = 1;
    Integer CONTROL_ILVE_FARMACOLOGICO = 2;
    Integer CONTROL_ILVE_GENERAL = 3;


    // Etapa de Cirugias sin Factura 

    String ETAPA_REGISTRO = "RG";
    String ETAPA_CONFIRMADA = "CF";

    Integer ESPECIALIDAD_ANESTESIOLOGO = 1;
    Integer ESPECIALIDAD_CIRUJANO = 2;
    Integer ESPECIALIDAD_ENFERMERA = 3;
    Integer TIPO_PROFESIONAL_AUXILIARES = 9999;
    Integer ESPECIALIDAD_INSTRUMENTADOR = 4;


    String EDUCATIVA_ACTIVIDAD = "ACTIVIDAD";

    String EDUCATIVA_CONDICION = "CONDICION";

    String EDUCATIVA_EJES = "EJES";

    String EDUCATIVA_NATURALEZA = "NATURALEZA";

    String EDUCATIVA_POBLACION = "POBLACION";


    // TIPOS DE ESCALA

    String ESCALA_ADRETE = "A";

    String ESCALA_BROMAGE = "B";


    //ESTADOS DE SERVICIOS DESCRIPCION QUIRURGICA

    String ETAPA_PROGRAMACION_CIRUGIA = "PC";

    String ETAPA_SERVICIO_ADICIONAL = "AD";


    // ETAPAS DE CIRUGIA

    String ETAPA_PROGRAMADA_CIRUGIA = "PR";
    String ETAPA_INGRESO_ENFERMERIA = "IE";
    String ETAPA_CIRUGIA_PENDIENTE_QUIROFANO = "PQ";
    String ETAPA_CIRUGIA_EN_QUIROFANO = "EQ";
    String ETAPA_CIRUGIA_EN_RECUPERACION = "ER";
    String ETAPA_CIRUGIA_ATENDIDA = "AT";
    String ETAPA_INGRESO_ENFERMERIA_ESPERA = "ES";
    String MSG_NO_TIENE_DATOS_AYUNO = "NO_TIENE_DATOS_AYUNO";


    // TIPOS DE ESPECIALIDAD

    Integer TIPO_ESPECIALIDAD_ANESTESIOLOGO = 4;
    Integer TIPO_ESPECIALIDAD_INSTRUMENTADOR = 6;

    //PausarConsulta
    Boolean ACTIVAR_PAUSAR_CONSULTA = false;

    //Servicios Admision
    Boolean ACTIVAR_SERVICIOS_ADMISION = false;

    Long TIPO_DOCUMENTO_ADMISION = 100L;

    String BAD_REQUEST = "400";

    String OK_REQUEST = "200";

    String OPCIONCIRUGIAYPROCEDIMIENTO = "CYP";

    String OPCIONINTERCONSULTA = "IC";

    String ANTECEDENTES_IVE = "I";

    Integer HISTORIA_PROCEDIMIENTO_ASOCIADO = 60;

    String ETAPA_PROCEDIMIENTO_ASOCIADO = "CA";
    
    
    Integer HISTORIA_PRUEBAS_RAPIDAS = 57;
    
    Integer VIH_1_2 = 1;
    
    Integer HEPATITIS_B = 2;
    
    Integer HEPATITIS_C = 3;
    
    Integer SIFILIS = 4;
    
    Integer PRUEBA_EMBARAZO = 5;
    
    Integer HISTORIA_PAUXILIOS_PSICOLOGIA= 61;
    
    Integer HISTORIA_ANTICUERPOS_COVID=59;
    
    Integer HISTORIA_ANTIGENOS_COVID=58;
    
    //Web Service Salud Total
    
    String NIT_PROFAMILIA = "860013779";
    String NOMBRE_PROFAMILIA = "Profamilia";
    String CODIGO_PROFAMILIA = "11546";
    String ENCABEZADO_PROFAMILIA = "falc @cre @ t bil @db o l";
    //Produccion
     /*
    Integer NUM_CONTRATO_SALUDTOTAL1= 41001374;
    Integer NUM_CONTRATO_SALUDTOTAL2= 41001375;
      */
    //Calidad
     Integer NUM_CONTRATO_SALUDTOTAL1= 50000790;
     Integer NUM_CONTRATO_SALUDTOTAL2= 50000791;
     
     //MENSAJES DE ERROR
     String ERROR_CERRAR_CONSULTA ="ERROR CERRANDO CONSULTA CL�NCIA";
     String ERROR_CERRAR_CIRUGIA ="ERROR CERRANDO CIRUGIA";
     String ERROR_REPORTES ="ERROR GENERANDO REPORTE";
     String ERROR_ARCHIVOS ="ERROR GENERANDO ARCHIVO";
     String ERROR_PRUEBAS_RAPIDAS ="ERROR GUARDANDO PRUEBAS R�PIDAS";
     String ERROR_CERRAR_PRUEBAS_RAPIDAS ="ERROR GUARDANDO PRUEBAS R�PIDAS";
     String ERROR_EPICRISIS ="ERROR GUARDANDO EPICRISIS";
     String ERROR_GUARDADO ="ERROR GUARDANDO LA INFORMACI�N ";
     String ERROR_COSNULTA ="ERROR EN LA CONSULTA DE INFORMACI�N";
    
    String IMAGE_ESPERMASINFRAGMENTACION= "/comun/imagenes/espermasinfragmentacion.png";
    String IMAGE_ESPERMACONFRAGMENTACION = "/comun/imagenes/espermaconfragmentacion.png";
    String IMAGE_ENCUESTA_SATISFACCION = "/tmpaplic/historias/encuestasatisfaccionEmilia.png";
    BigDecimal CODIGO_LAB_BL=  new BigDecimal(3000019028L);
    
}

