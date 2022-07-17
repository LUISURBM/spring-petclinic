package org.profamilia.hc.view.constantes;

public interface IMsg {

    // CONSTANTES MENSAGES VALIDACIONES

    String MSG_SIN_CONSULTAR = "Sin Consultar.";
    String MSG_SIN_CIRUGIAS_ADMITIDAS = "No existen admisiones a Cirugia, favor realizar la admision y volver a intentar.";
    String MSG_VALIDACION_REQUERIDO = "El Valor es necesario.";
    String MSG_VALIDACION_NUMERICO = "El campo debe ser numerico.";
    String MSG_VALIDACION_FECHA = "Formato de fecha incorrecta.";
    String MSG_ERROR_CONSECUTIVO = "Error obteniendo consecutivo";
    String MSG_VALIDACION_ANO = 
        "Formato de A�o incorrecto (tamano 4 digitos).";
    String MSG_VALIDACION_EMAIL = "Formato de email incorrecto.";
    String MSG_SIN_DATOS = "No se encontrar�n registros";
    String MSG_VALIDACION_SELECCION_REQUERIDO = "Seleccione por lo menos un dato.";
    String MSG_VALIDACION_FECHA_MENOR = "La Fecha Final debe ser mayor  o igual a la fecha inicial ";
    String MSG_VALIDACION_INCAPACIDA_DIAS = "La Incapacidad maxima debe ser de 20 dias ";
    String MSG_VALIDACION_FECHA_ACTUAL =  "La Fecha debe ser posterior a la fecha actual";    
    String MSG_VAL_FECHA_ACTUAL =  "La Fecha debe ser mayor o igual a la fecha actual";    
    String MSG_VALIDACION_PATOLOGOS = "Es necesario ingresar los laboratorios o patologos a enviar. ";
     
    // CONSTANTES MENSAGES ACCIONES

    String MSG_ADICION = "Se ingreso la informaci�n satisfactoriamente.";
    String MSG_ELIMINACION = "Se elimino satisfactoriamente";
    String MSG_ACTUALIZACION = 
        "La actualizaci�n se ha realizado satisfactoriamente.";
    String MSG_CAMBIO_INTERNO = 
        "El cambio interno se ha realizado satisfactoriamente";
    String MSG_DESVINCULACION = 
        "La desvinculaci�n se ha realizado satisfactoriamente";
    String MSG_NO_ADICION = "Adicion no realizada";
    String MSG_NO_ELIMINACION = "Eliminacion no realizada";
    String MSG_NO_ACTUALIZACION = "Actualizacion no realizada";
    String MSG_NO_APERTURA = "Apertura no realizada";
    String MSG_NO_CONSULTA = "No se pudo consultar";
    String MSG_CONSULTA_POR_FILTROS = 
        "Agregue al menos un campo para filtrar la consulta.";
    String MSG_NO_RESULTADO_CONSULTA = 
        "No hay resultados para la consulta especificada.";
    String MSG_NO_TIENE_VALORACION_PREOPERATORIA =
        "Este usuario no tiene valoraci�n preoperatoria";
    String MSG_NO_TIENE_VALORACION_PREANESTESICA =
        "Este usuario no tiene valoraci�n preanestesica";
        
    String MSG_CODIGO_EXISTE = "El codigo especificado ya existe.";
    String MSG_NO_RESULTADOS = 
        "No existen resultados con esos criterios de busqueda";
    String MSG_NO_ANTECEDENTES = "No existen Antecedentes para este Usuario";
    String MSG_NO_RESUMEN_ENCABEZADO = 
        "No existen registros Historia Clinica Electronica para este usuario";
    String MSG_NO_RESUMEN = 
        "No existe Historia Clinica Electronica para estos criterios de Busqueda";
    String MSG_ANULACION = "Anulaci�n realizada satisfactoriamente.";
    String MSG_NO_ANULACION = "Anulaci�n no realizada.";
    String MSG_OBJETO_NO_EXISTE = "No existe.";
    String MSG_VALIDACION_ANTECEDENTES = 
        "Por favor Ingrese el nuevo antecedente";
    String MSG_VALIDACION_LISTA_VACIA_PRESCRIPCION = 
        "Debe Registrar por lo menos un Medicamento para generar la Prescripci�n Medica";
    String MSG_NO_SELECCIONO_VIOLENCIA = 
        "Debe seleccionar el tipo de violencia que sufre el usuario";
    String MSG_NO_EXISTEN_EXAMENES = 
        "No existen examenes para generar la remision  ";
    String MSG_NO_EXISTEN_CONSULTAS = 
        "No existen consultas para generar la remision  ";
    String MSG_NO_ACTUALIZO_DATOS_USUARIO = 
        "No actualizo los datos del usuario";
    String MSG_NO_REGISTRO_ANTECEDENTES = 
        "No Registro los antecedentes Generales";
    String MSG_NO_REGISTRO_RIESGO_MAMA = "No Registro Riesgo Mama";
    String MSG_NO_REGISTRO_ANTECEDENTES_PRENATAL = 
        "No Registro los antecedentes Prenatales";
    String MSG_NO_REGISTRO_ANTECEDENTES_MAMA = 
        "No Registro los antecedentes de Mama";
    String MSG_NO_REGISTRO_ANTECEDENTES_TEMPORALES = 
        "No Registro antecedentes Temporales";
    String MSG_NO_REGISTRO_MOTIVO_CONSULTA = 
        "No Registro el Motivo de la consulta";
    String MSG_NO_REGISTRO_GINECOLOGICOS = 
        "No Registro antecedentes ginecologicos";
    String MSG_NO_REGISTRO_GESTACION_ACTUAL = "No Registro Gestaci�n Actual";
    String MSG_NO_REGISTRO_ENCUESTA = "No Registro Encuesta de violencia";
    String MSG_NO_REGISTRO_EXAMEN = "No Registro Examen Fisico";
    String MSG_NO_REGISTRO_EXAMEN_FISICO_MAMA = 
        "No Registro Examen Fisico Mama";
    String MSG_NO_REGISTRO_EXAMEN_PRENATAL = 
        "No Registro Examen Fisico Prenatal";
    String MSG_NO_REGISTRO_EXAMEN_PEDIATRIA = 
        "No Registro Examen Fisico Pediatria";
    String MSG_NO_REGISTRO_EXAMEN_APOYO_DIAGNOSTICO = 
        "No Registro Examen de Apoyo Diagnostico";
    String MSG_NO_REGISTRO_CONDUCTA = "No Registro Conducta";
    String MSG_ERROR_AL_CERRAR_CONSULTA = 
        "Error al cerrar la consulta intente de nuevo";
    String MSG_NO_REGISTRO_IMPRESION = "No Registro Impresion Diagnostica";
    String MSG_NO_REGISTRO_CONTROL = "No Registro Control ";
    String MSG_TALLA_MAX_NO_VALIDA = 
        "Error La talla no es valida, La talla debe ser menor de 2.50 m ";
    String MSG_PESO_MAX_NO_VALIDO = 
        "Error El peso no es valido , El peso  debe ser menor de 300 Kg ";
    String MSG_TALLA_MIN_NO_VALIDA = 
        "Error La talla no es valida, La talla debe ser mayor de 0.99 m ";
    String MSG_PESO_MIN_NO_VALIDO = 
        "Error El peso no es valido , El peso  debe ser mayor de 9 Kg ";
        
    String MSG_EXAMEN_FISICO_ = 
        "Debe realizar los hallazgos del examen fisico";
        
    String MSG_SPO2_NO_VALIDA = 
        "Error Este dato no corresponde a la SPO2 ";
    String MSG_TEMPERATURA_NO_VALIDA = 
        "Error La temperatura no es valida , La temperatura debe ser menor de 45 �C ";
    String MSG_PRESION_ARTERIAL_MENOR = 
        "La presion arterial no se encuentra dentro de los par�metros normales, revise el dato o t�ngalo en cuenta para su diagn�stico.";
    String MSG_FRECUENCIA_CARDIACA_NO_VALIDA = 
        "La frecuencia cardiaca no se encuentra dentro de loa par�metros normales, revise el dato o t�ngalo en cuenta para su diagn�stico";
    String MSG_FRECUENCIA_RESPIRATORIA_NO_VALIDA = 
        "La frecuencia respiratoria no se encuentra dentro de loa par�metros normales, revise el dato o t�ngalo en cuenta para su diagn�stico";
    String MSG_EMBARAZO = 
        "Cerci�rese  que la usuaria  no est� en embarazo o solicite prueba de embarazo";
    String MSG_TIPO_HISTORIO_MUJER = 
        "El tipo de historia aplica solamente al sexo femenino";
    String MSG_DIAGNOSTICO_PRINCIPAL_NO_VALIDO = 
        "Error el codigo del diagnostico principal no es reconocido ";
    String MSG_DIAGNOSTICO_PRINCIPAL = "Diagnostico Principal:  ";
    String MSG_DIAGNOSTICO_RELACIONADO1_NO_VALIDO = 
        "Error el codigo del diagnostico relacionado 1 no es reconocido ";
        
    String MSG_DIAGNOSTICO_PREOPERATORIO_NO_VALIDO = 
        "Error el codigo del diagnostico preoperatorio no es reconocido ";
    String MSG_DIAGNOSTICO_POSTOPERATORIO_NO_VALIDO = 
        "Error el codigo del diagnostico postoperatorio no es reconocido ";
        
    String MSG_DIAGNOSTICO_COMPLICACION_NO_VALIDO = 
        "Error el codigo del diagnostico complicaci�n 1 no es reconocido ";
    String MSG_DIAGNOSTICO_RELACIONADO1 = "Diagnostico Relacionado 1:  ";
    
    String MSG_DIAGNOSTICO_PREOPERATORIO = "Diagnostico Preoperatorio :  ";
    String MSG_DIAGNOSTICO_POSTOPERATORIO = "Diagnostico Postoperatorio :  ";

    
    String MSG_DIAGNOSTICO_COMPLICACION = "Diagnostico Complicaci�n :  ";


    String MSG_DIAGNOSTICO_RELACIONADO2_NO_VALIDO = 
        "Error el codigo del diagnostico relacionado 2 no es reconocido ";
    
    String MSG_DIAGNOSTICO_RELACIONADO2 = "Diagnostico Relacionado 2: ";
    String MSG_DIAGNOSTICO_RELACIONADO3_NO_VALIDO = 
        "Error el codigo del diagnostico relacionado 3 no es reconocido ";
    String MSG_DIAGNOSTICO_RELACIONADO3 = "Diagnostico Relacionado 3: ";
    String MSG_FECHA_ULTIMA_REGLA_NO_VALIDA = 
        "La fecha de la ultima regla debe ser menor o igual a la fecha actual";
    String MSG_FECHA_ULTIMO_PARTO_NO_VALIDA = 
        "La fecha del ultimo parto debe ser mayor o igual a la fecha actual";
    String MSG_FECHA_ULTIMA_CITOLOGIA_NO_VALIDA = 
        "La fecha de la ultima Citologia debe ser menor o igual a la fecha actual";
    String MSG_NO_EXISTE_LECTURA_CITOLOGIA = 
        "No se ha registrado la lectura de la citologia";
    String MSG_NO_EXISTE_LECTURA_VPH = 
        "No se ha registrado la lectura del Vph";
    String MSG_NO_EXISTE_NOTA_OPERATORIA = 
        "No se encontro nota operatoria para este Usuario";
    String MSG_NO_EXISTE_DESCRIPCION_QUIRURGICA = 
        "No se encontro Descripci�n Quirurgica para realizar la nota operatoria";
    String MSG_CLAVE_CAMBIADA = "La clave se cambio exitosamente.";
    String MSG_CLAVE_NO_CAMBIADA = "La clave No fue cambiada.";
    String MSG_CLAVES = "La clave nueva no coincide con su confirmaci�n.";
    String MSG_VALOR_CAMPO_INCORRECTO = "El Valor del campo no es Correcto";
    String MSG_CAMPO_OBLIGATORIO = "El campo es obligatorio";
    String MSG_NO_CUMPLE_AYUNO = "No cumple el tiempo de ayuno requerido. Informe al m�dico inmediatamente";
    String MSG_CARACTER_INVALIDO = "Se detecto carater invalido '|' � '_'";
    String MSG_CAMPO_OBLIGATORIO_TIPO_DOCUMENTO = "El campo es Tipo Documento es obligatorio";
    String MSG_CAMPO_OBLIGATORIO_NUMERO_DOCUMENTO = "El campo es Numero de Documento es obligatorio";
    String MSG_ANESTESIOLOGO_OBLIGATORIO = "Debe agregar por lo menos un anestesiologo";
    String MSG_PREGUNTA_OBLIGATORIA = "Aclarar la Respuesta";
    String MSG_FECHA_INCORRECTA_CITOLOGIA = "Error Fecha segunda lectura";
    String MSG_TABLA_VACIA = "Error.. No existen registros para guardar";

    String MSG_VALIDACION_MEDICO_REQUERIDO = "El Medico(s) es Requerido.";
    String MSG_RESULTADOS_INGRESADOS = 
        "Debe registrar los resultados de todas las patologias.";
    String MSG_RESULTADOS_ENVIO = 
        "Debe registrar los resultados de todas las citologia a enviar.";

    String MSG_TIPO_PROCEDIMIENTO_REQUERIDO = 
        "El tipo de procedimiento es requerido ";

    String MSG_PLANTILLA_VACIAS = "Debe registrar minimo una plantilla";
    
    String MSG_FACTURA_EXISTE = "N�mero de factura ya se encuentra registrado.";
    String MSG_DOC_NO_EXISTE = "Tipo de documento no existe.";
    
    
    String MSG_SELECCIONAR_SERVICIO = "Debe seleccionar un servicio.";
    String MSG_SERVICIO_PATOLOGO = "El Servicio no tiene parametrizado un patologo.";
    
    String MSG_SIN_AUTORIZACION_CONTACTO = "Debe seleccionar por lo menos un tipo de contacto"; 
    
    // Vacunacion
    
    String MSG_NUMERO_DOSIS_NO_ASIGNADO = "El N�mero de Dosis, no esta asignado, por favor comuniquese con el Departamento de Sistemas"; 
    
    
    String MSG_NO_CONFIRMACION_PATOLOGIAS = "El usuario no pude confirmar recibido, solo un usuario del centro.";
    String MSG_NO_RESULTADOS_PATOLOGIAS = "No se han registrado los resultados de las patologias.";
    
    
    String MSG_ADICIONAR_CONSULTA_ANULACION = "Debe seleccionar la consulta que desea Solicitar la anulaci�n"; 
    
    String MSG_CONSULTAS_ABIERTAS = "Las siguiente consultas no se cerraron, Por favor Verificar"; 
    
    String MSG_CONSULTAS_ABIERTAS_HOY = "Las siguientes consultas son del d�a de hoy y no se cerraron, Por favor Cerrarlas o no se veran reflejado en la Historia Clinica del Paciente"; 
    
    //String MSG_EVALUACION_NORMAL = "La Evaluaci�n psicoemocional es normal no aplica para ILVE"; 
    
    String MSG_SELECCIONE_PROCEDIMIENTO_CUELLO_UTERINO = "Favor seleccione el procedimiento anterior en el cuello uterino"; 
    
    // Mensajes Asesoria 
    
     String MSG_CAMPO_OBLIGATORIO_ACCION = "Debe seleccionar una acci�n previa";
     
    String MSG_CAMPO_OBLIGATORIO_DOCUMENTO_PRESENTADO = "Debe seleccionar un documento";
    
    
    String MSG_CIRUGIA_EXISTE = "La cirugia ya esta adicionada"; 
    
    String MSG_CIRUGIA_NO_EXISTE = "No existen resultados para la b�squeda, por favor verifique los datos e intente nuevamente"; 
    
    String MSG_NO_DATOS_CITOLOGIA= "No se encontraron datos para cargar a este usuario";

    String PROFESIONAL_NO_EXISTE_CLINICA = "El profesional no esta creado en el sistema clinico! No puede registrar asesorias comunicarse con la administradora"; 
    
    String PROFESIONAL_NO_TIENE_CODIGO = "El profesional no tiene codigo de usuario asignado favor comunicarse con el departamento de sistemas"; 
    
    
    String MSG_SIN_DATOS_REPROGRAMAR_CIRUGIA = 
        "El usuario no tiene programaciones de cirugias vigentes.";
        
    String MSG_CIRUGIA_SIN_MEDICO = 
        "Todas las cirugias deben tener medico asignado.";
        
    String MSG_CRITERIOS_BUSQUEDA = "Debe ingresar por lo menos un criterio de busqueda"; 
    String MSG_SELECCIONE_CIRUGIAS_DQX = "Debe seleccionar la cirugia a la cual le va a registrar la Descripci�n Quirurgica";
    
    String MSG_EVOLUCION_SIN_CERRAR = "Usted tiene una evoluci�n sin cerrar debe cerrar la evoluci�n para poder realizar otra"; 

    String MSG_EXISTE_PERMISO = "El permiso que desea ingresar ya lo tiene el usuario"; 
    
    String MSG_SOLICITUD_ACLARACION_EM_PROCESO = "La solicitud de aclaraci�n ya se encuentra en proceso de autorizaci�n para esta descripci�n quirurgica"; 
    
    String MSG_SOLICITUD_NOTA_ACLARACION_EN_PROCESO = "La solicitud de Nota de aclaraci�n ya se encuentra en proceso de autorizaci�n para este registro medico";
    
    String MSG_SOLICITUD_INFORME_PSICOLOGICO_EN_PROCESO = "La solicitud de Informe Psicologico ya se encuentra en proceso de autorizaci�n para este registro medico"; 

    
    String MSG_SOLICITUD_ACLARACION_EPICRISIS_EN_PROCESO = "La solicitud de aclaraci�n ya se encuentra en proceso de autorizaci�n para esta epicrisis"; 
    
    String MSG_ADICION_PROFILAXIS = "Se adiciono el registro satisfactoriamente.";
    
    String MSG_EXISTE_PAQUETE_INSTRUMENTAL = "El paquete instrumental ya existe, por favor verifique"; 
    
    String MSG_EXISTE_MATERIAL_INSTRUMENTAL = "El material instrumental ya existe, por favor verifique"; 

    
    String MSG_RANGO_NUMERO_CARGA = "El numero de carga esta entre 1 a 10, Favor verificar"; 
    
    String MSG_RANGO_NUMERO_AUTOCLAVE = "El numero de auto clave esta entre 1 a 5, Favor verificar"; 
    
    
    String MSG_RANGO_CONTEO_INSTRUMENTAL = "El numero del conteo esta entre 1 a 100, Favor verificar"; 

    String MSG_FRECUENCIA_OBLIGATORIA = "Seleccione el valor de la Frecuencia Cardiaca";  
    
    String MSG_PRESION_SISTOLE_OBLIGATORIA = "Seleccione el valor de la Presion Arterial sistole";  
    
    String MSG_PRESION_DIASTOLE_OBLIGATORIA = "Seleccione el valor de la Presion Arterial diastole";  
    
    String MSG_PECO2_OBLIGATORIA = "Seleccione el valor de PEC02";  
    
    String MSG_SATURACION_OBLIGATORIA = "Seleccione el valor de la saturaci�n "; 
    
    String MSG_TIPO_RESPIRACION = "Seleccione el tipo de respiraci�n";  

    
    
    String MSG_FRECUENCIA_UNICA = "Seleccione solo un valor de la Frecuencia Cardiaca";  
    
    String MSG_PRESION_SISTOLE_UNICA = "Seleccione solo un  valor de la Presion Arterial sistole";  
    
    String MSG_PRESION_DIASTOLE_UNICA = "Seleccione solo un  valor de la Presion Arterial diastole";  
    
    String MSG_PECO2_UNICA = "Seleccione solo un  valor de PEC02";  
    
    String MSG_SATURACION_UNICA = "Seleccione solo un  valor de la saturaci�n "; 
    
    String MSG_VENA_CANALIZADA = "No se puede Cerrar - Existen venas canalizadas";

    String MSG_LIQUIDOS_POR_ADMINISTRAR = "Existen liquidos en Administraci�n o por Administrar";

    String MSG_LIQUIDOS_FORMULADOS_POR_ADMINISTRAR = "Existen liquidos formulados en Administraci�n o por Administrar";
    
    String MSG_PRESION_ARTERIAL_SISTOLICA = "La Presi�n Arterial sist�lica esta fuera del rango 90mm - 150mm : ";
    
    String MSG_PRESION_ARTERIAL_DIASTOLICA = "La Presi�n Arterial diast�lica esta fuera del rango 60Hg - 120Hg : ";
    
    String MSG_FRECUENCIA_CARDIACA = "La Frecuencia Cardiaca esta fuera del rango 50 - 100 lpm : ";
    
    String MSG_FRECUENCIA_RESPIRATORIA = "Frecuencia Respiratoria esta fuera de rango 12 - 20 rpm : ";
    
    String MSG_TEMPERATURA_ALTA = "La temperatura excede los 37.4�C  : ";
    
    String MSG_TEMPERATURA_BAJA = "La temperatura esta bajo los 36�C : ";
    
    String MSG_TEMPERATURA = "Temperatura fuera de Rango: 36�C   : 37.4�C  ";

    // Mensajes carga archivo citologias
    
     String MSG_INVALIDO_DATO_EN_clcnclinic = "Dato invalido en la columna clcnclinic";
     String MSG_INVALIDO_DATO_EN_clcnnumero = "Dato invalido en la columna clcnnumero";
     String MSG_INVALIDO_DATO_EN_clccprilec = "Dato invalido en la columna clccprilec";
     String MSG_INVALIDO_DATO_EN_clcdprilec = "Dato invalido en la columna clcdprilec";
     String MSG_INVALIDO_DATO_EN_clccnompri = "Dato invalido en la columna clccnompri";
     String MSG_INVALIDO_DATO_EN_clcdseglec = "Dato invalido en la columna clcdseglec";
     String MSG_INVALIDO_DATO_EN_clccseglec = "Dato invalido en la columna clccseglec";
     String MSG_INVALIDO_DATO_EN_clccnomseg = "Dato invalido en la columna clccnomseg";
     String MSG_INVALIDO_DATO_EN_clcccalmue = "Dato invalido en la columna clcccalmue";
     String MSG_INVALIDO_DATO_EN_clccmicorg = "Dato invalido en la columna clccmicorg";
     String MSG_INVALIDO_DATO_EN_clccotrmic = "Dato invalido en la columna clccotrmic";
     String MSG_INVALIDO_DATO_EN_clcccatego = "Dato invalido en la columna clcccatego";
     String MSG_INVALIDO_DATO_EN_clccotrhal = "Dato invalido en la columna clccotrhal";
     String MSG_INVALIDO_DATO_EN_clccanoesc = "Dato invalido en la columna clccanoesc";
     String MSG_INVALIDO_DATO_EN_clccanogla = "Dato invalido en la columna clccanogla";
     String MSG_INVALIDO_DATO_EN_clccotrneo = "Dato invalido en la columna clccotrneo";
     String MSG_INVALIDO_DATO_EN_clccobserv = "Dato invalido en la columna clccobserv";
     String MSG_INVALIDO_DATO_EN_clccusureg = "Dato invalido en la columna clccusureg";
     String MSG_INVALIDO_DATO_EN_clcdfecreg = "Dato invalido en la columna clcdfecreg";
     String MSG_INVALIDO_DATO_EN_version = "Dato invalido en la columna version";
     String MSG_INVALIDO_DATO_EN_clcnconsec = "Dato invalido en la columna clcnconsec";
     String MSG_INVALIDO_DATO_EN_clccnumpri = "Dato invalido en la columna clccnumpri";
     String MSG_INVALIDO_DATO_EN_clccnumseg = "Dato invalido en la columna clccnumseg";
     
     String MSG_CARGA_VALIDA = "Datos cargados satisfactoriamente";
     String MSG_CARGA_NO_VALIDA = "Por favor verifique, la informaci�n ya fue cargada";
     String MSG_NO_EXISTE_CONSULTA = "No existe consulta clinica para el documento";
     
     
     String MSG_TERMINA_ETAPA_TRANSOPERATORIA = "Termina etapa transoperatoria"; 
     
     String MSG_TRANS_FALTA_RECORD_ANESTESIA = "El registro de Anestesia no se ha realizado";
     
     String MSG_SERVICIO_ANEXO_NO_EXISTE = "No selecciono Servicio control";
     String MSG_CONTROL_MAYOR_FECHA_LIMITE = "Fecha control mayor a fecha limite";
     String MSG_EXCEDE_NUMERO_CONTROLES = "Excede el n�mero m�ximo de controles";
     String MSG_NO_REGISTROS_ATENCION = 
        "No existen registros de Historia Cl�nica Electr�nica para esta atenci�n";
     String MSG_NO_GUARDO_ESPERMOGRAMA = "Debe guardar primero el espermograma";
    String MSG_FALTAN_DATOS_ECO_FERTILIDAD = "Debe registrar todos los campos de la ecografia";

}
