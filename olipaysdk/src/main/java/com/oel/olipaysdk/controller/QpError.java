package com.oel.olipaysdk.controller;

public enum QpError {

    UNKNOWN_ERROR(90001, "Unknown error.", "Error, reintente nuevamente."),
    TIMEOUT(90009, "Reading card timed out.", "Tarjeta no insertada a tiempo, reintente."),
    TRANSACTION_CANCELLED(90010, "Transaction cancelled.", "Operación cancelada."),
    INCORRECT_LAST_FOUR_DIGITS(90011, "Incorrect last four digits.", "Últimos cuatro dígitos incorrectos."),
    CARD_HAS_EXPIRED(90012, "Card has expired.", "Tarjeta expirada."),
    PIN_TRIES_EXCEEDED(90013, "Pin blocked.", "PIN Bloqueado."),
    APPLICATION_BLOCKED(90014, "Application Blocked.", "Aplicación Bloqueada."),

    NFC_MULTI_CARD_USED(90015, "Make sure to approach with only one card.", "Asegúrate de acercar sólo una tarjeta."),
    QPAY_CLIENT_GENERAL_ERROR(90100, "Connection error.", "Error de conexión."),
    QPAY_CLIENT_SOAP_FAULT_ERROR(90101, "Connection error.", "Error de conexión."),
    NO_CONNECTION_ERROR(90102, "No connection.", "Sin conexión"),
    CONNECTION_LOST_ERROR(90103, "Connection lost.", "Conexión perdida"),
    DECLINED_BY_TERMINAL_AND_REVERSED(90203, "Declined by terminal and reversed.", "Declinada por la terminal, reversa aplicada."),
    DECLINED_BY_TERMINAL_REVERSE_MANUALLY(90204, "Declined by terminal reverse manually.", "Declinada por la terminal, revise reversa."),
    PREVIOUS_TRANSACTION_WAS_DECLINED_BY_TERMINAL(90205, "Previous transaction was declined by terminal.", "La transacción anterior fue declinada por la terminal"),
    PREVIOUS_TRANSACTION_WAS_DECLINED_BY_TERMINAL_AND_REVERSED(90206, "Previous transaction was declined by terminal and reversed.", "La transacción anterior fue declinada por la terminal y fue reversada"),
    PREVIOUS_TRANSACTION_WAS_DECLINED_BY_TERMINAL_REVERSE_MANUALLY(90207, "Previous transaction was declined by terminal, reverse manually.", "La transacción anterior fue declinada por la terminal, reversar manualmente"),
    PRINTER_PAPERENDED(90301, "Out of paper.", "Sin papel"),
    PRINTER_HARDERR(90302, "Printer error.", "Error de impresión"),
    PRINTER_OVERHEAT(90303, "Printer overheated.", "Impresora sobre calentada"),
    PRINTER_LOWVOL(90304, "Printer lowvol.", "Nivel bajo de impresora"),
    PRINTER_MOTORERR(90305, "Printer motor error.", "Error de motor de impresión"),
    PRINTER_BUSY(90306, "Printer busy.", "Impresora ocupada"),
    PRINTER_UNKNOWN_ERROR(90307, "Printer unkown error.", "Error desconocido en impresora");
//    REVERSING_PREVIOUSLY_FAILED_TRANSACTION_FAILED(90205, "Reversing previously failed transaction failed.", "Reversing previously failed transaction failed.");

    // Qpay Client error codes
//    APPROVED(1, "Approved.", "Aprobada"),
//    REFERRAL_GENERAL(2, "Referral.", "Referencias"),
//    REFERRAL_CALL_BANK_FOR_MANUAL_APPROVAL(3, "Referral - Call bank for manual approval.", "Remisión - Convocatoria banco para su aprobación manual."),
//    DECLINED_GENERAL(50, "Declined.", "Rehusó"),
//    CONNECTION_TIMED_OUT(51, "Connection timed-out.", "Conexión de tiempo de espera."),
//    ERROR_CONNECTING_TO_PROCESSOR_OR_SENDING_DATA(52, "Error connecting to processor or sending data.", "Error al conectar con el procesador o el envío de datos."),
//    DUPLICATE(200, "Duplicated transaction.", "Duplicated transaction."),
//    DECLINED_TRANSACTION_CONSIDERED_FRAUDULENT_BY_FRAUD_COMPONENT(500, "Declined - Transaction considered fraudulent by Fraud component.", "Rehusó - Transacción considerada fraudulenta por componente Fraude."),
//    THE_TRANSACTION_WAS_APPROVED_BY_THE_PROCESSOR_HOWEVER_IT_FAILED_A_POST_PROCESSING_FRAUD_RULE_AND_HAS_BEEN_VOIDED(501, "The transaction was Approved by the processor. However, it failed a post-processing fraud rule and has been voided.", "La operación fue aprobada por el procesador. Sin embargo, no una regla fraude post-proceso y tiene sido anulado."),
//    THE_TRANSACTION_WAS_APPROVED_BY_THE_PROCESSOR_HOWEVER_IT_FAILED_A_FRAUD_RULE_AND_HAS_BEEN_MARKED_FOR_REVIEW(502, "The transaction was Approved by the processor. However, it failed a fraud rule and has been marked for review.", "La operación fue aprobada por el procesador. Sin embargo, no logró una regla fraude y ha sido marcada para revisión."),
//    AMOUNT_NOT_VALID(1002, "Amount not valid.", "La cantidad no válida."),
//    INTERCHANGE_OR_PAYMENT_SERVICE_DATA_SUBMITTED_IS_NOT_VALID(1003, "Interchange or Payment Service data submitted is not valid.", "Intercambio de datos o servicios de pago presentados no son válidos."),
//    CURRENCY_IS_NOT_VALID(1005, "Currency is not valid.", "La moneda no es válida."),
//    BIN_IS_NOT_VALID(1006, "BIN is not valid.", "BIN no es válida."),
//    CARD_NUMBER_IS_NOT_VALID(1007, "Card number is not valid.", "Número de tarjeta no es válida."),
//    MAGNETIC_STRIPE_DATA_IS_NOT_VALID(1010, "Magnetic stripe data is not valid.", "Datos de banda magnética no es válida."),
//    CARD_EXPIRATION_DATE_IS_NOT_VALID(1011, "Card expiration date is not valid.", "Fecha de caducidad de la tarjeta no es válida."),
//    TRANSACTION_DATE_OR_TIME_IS_NOT_VALID(1012, "Transaction date or time is not valid.", "Fecha o la hora de transacción no es válida."),
//    DATE_IS_NOT_VALID(1013, "Date is not valid.", "La fecha no es válida."),
//    TRANSACTION_IS_NOT_VALID(1014, "Transaction is not valid.", "La transacción no es válida."),
//    PIN_IS_NOT_CORRECT(1015, "PIN is not correct.", "PIN no es correcto."),
//    MERCHANT_ID_IS_NOT_VALID(1016, "Merchant ID is not valid.", "Identificación del comerciante no es válida."),
//    ACCOUNT_IS_NOT_VALID(1017, "Account is not valid.", "Cuenta no es válida."),
//    ENCRYPTION_ERROR(1018, "Encryption Error.", "Error de cifrado."),
//    CHECK_DIGIT_ERROR(1019, "Check Digit Error.", "Dígito Verificador de error."),
//    VERIFICATION_ERROR(1020, "Verification Error.", "Error de verificación."),
//    DESTINATION_NOT_FOUND(1021, "Destination not found.", "Destino no encontrado."),
//    SERVICE_CODE_IS_NOT_VALID_OR_IS_RESTRICTED(1022, "Service code is not valid or is restricted.", "Código del servicio no es válida o está restringido."),
//    VIOLATION_CANNOT_COMPLETE(1023, "Violation, cannot complete.", "Violación, no se puede completar."),
//    ERROR_RESPONSE_TEXT_FROM_CHECK_SERVICE(1024, "Error response text from check service.", "Error texto de respuesta del servicio de verificación."),
//    NO_ACCOUNT(1025, "No account.", "¿No tienes cuenta."),
//    NO_SUCH_ISSUER(1026, "No such issuer.", "No existe el emisor."),
//    PIN_TRIES_EXCEEDED(1027, "PIN tries exceeded.", "Tries PIN superaron."),
//    TRANSACTION_NOT_PERMITTED(1028, "Transaction not permitted.", "La transacción no permitida."),
//    SECURITY_VIOLATION(1029, "Security Violation.", "Violación de Seguridad."),
//    UNABLE_TO_BACK_OUT_TRANSACTION(1030, "Unable to back out transaction.", "No puede retirarse de la transacción."),
//    UNABLE_TO_LOCATE_NO_MATCH_WAS_FOUND(1031, "Unable to locate. No match was found.", "No se puede localizar. No se encontró coincidencia."),
//    TERMINAL_ID_IS_NOT_VALID(1035, "Terminal ID is not valid.", "ID del terminal no es válida."),
//    MESSAGE_FORMAT_ERROR(1036, "Message format error.", "Error de formato de mensaje."),
//    TRACK_2_DATA_IS_NOT_VALID(1037, "Track 2 data is not valid.", "Datos de la pista 2 no es válido."),
//    DECLINED_INSUFFICIENT_FUNDS(1050, "Declined - Insufficient funds.", "Rehusó - La insuficiencia de fondos."),
//    CUSTOMER_CARD_IS_EXPIRED(1051, "Customer card is expired.", "Tarjeta de cliente ha caducado."),
//    LOST_OR_STOLEN_CARD(1052, "Lost or stolen card.", "Pérdida o robo de la tarjeta."),
//    PICK_UP_CARD_ISSUER_WANTS_CARD_RETURNED(1053, "Pick up card. Issuer wants card returned.", "Recoge tarjeta. Emisor quiere tarjeta regresó."),
//    RESPONSE_IS_NOT_VALID(1054, "Response is not valid.", "La respuesta no es válida."),
//    CVV_FAILURE_OR_CVV_VALUE_SUPPLIED_IS_NOT_VALID(1055, "CVV failure or CVV Value supplied is not valid.", "CVV fracaso o CVV valor proporcionado no es válido."),
//    TRANSACTION_TYPE_OR_CODE_IS_NOT_VALID(1056, "Transaction type or code is not valid.", "Tipo de transacción o código no es válido."),
//    DECLINED_DO_NOT_HONOR(1057, "Declined - Do not honor.", "Rehusó - No honrar."),
//    DECLINED_EXCEEDS_ISSUER_WITHDRAWAL_LIMIT(1058, "Declined – Exceeds issuer withdrawal limit.", "Rehusó - Excede límite de retiro emisor."),
//    DECLINED_EXCEEDS_WITHDRAWAL_LIMIT(1059, "Declined – Exceeds withdrawal limit.", "Rehusó - Excede límite de retiro."),
//    DECLINED_ACTIVITY_LIMIT_EXCEEDED(1060, "Declined – Activity limit exceeded.", "Rehusó - ha superado el límite de actividad."),
//    RESEND_BATCH(1063, "Resend Batch.", "Vuelva a enviar lotes."),
//    DOWNLOAD_FAILED(1064, "Download failed.", "Error en la descarga."),
//    SWITCH_OR_ISSUER_SYSTEM_ERROR(1065, "Switch or issuer system error.", "Cambie o error del sistema emisor."),
//    UNABLE_TO_ROUTE_TRANSACTION(1066, "Unable to route transaction.", "Incapaz de transacción ruta."),
//    SYSTEM_ERROR(1067, "System error.", "Error del sistema."),
//    HONOR_WITH_IDENTIFICATION(1069, "Honor with identification.", "Honra con la identificación."),
//    PERIODIC_TRANSACTION_NEW_ACCOUNT_INFORMATION_AVAILABLE(1071, "Periodic transaction - new account information available.", "Transacción periódica - nueva cuenta la información disponible."),
//    UNABLE_TO_COMPLETE_TRANSACTION(1076, "Unable to complete transaction.", "No se puede completar la transacción."),
//    CHECKING_ACCOUNT_IS_NOT_VALID(1500, "Checking account is not valid.", "Comprobación de cuenta no es válido."),
//    PROCESS_CODE_AUTHORIZATION_TYPE_OR_CARD_TYPE_IS_NOT_VALID(2003, "Process code, authorization type, or card type is not valid.", "Código de proceso, tipo de autorización, o el tipo de tarjeta no es válida."),
//    SOURCE_ID_IS_NOT_VALID(2005, "Source ID is not valid.", "ID de origen no es válido."),
//    FILE_ACCESS_ERROR_OCCURRED_IN_THE_PROCESSOR_HOST_DATABASE(2009, "File access error occurred in the processor host database.", "Se produjo un error de acceso a archivos en la base local del procesador."),
//    MERCHANT_ID_AND_TERMINAL_ID_COMBINATION_IS_NOT_VALID(2011, "Merchant ID and terminal ID combination is not valid.", "Identificación del comerciante y la combinación de ID del terminal no es válida."),
//    ACCOUNT_NUMBER_FOUND_BY_AUTHORIZATION_PROCESS_IS_NOT_VALID(2019, "Account number found by authorization process is not valid.", "Número de cuenta encontrado por proceso de autorización no es válida."),
//    LOST_OR_STOLEN_CARD_CARD_ISSUER_WANTS_THE_CARD_RETURNED(2026, "Lost or stolen card. Card issuer wants the card returned.", "Pérdida o robo de la tarjeta. Emisor de la tarjeta quiere la tarjeta devuelta."),
//    TERMINAL_IS_NOT_PROGRAMMED_FOR_THIS_SERVICE(2028, "Terminal is not programmed for this service.", "El terminal no está programado para este servicio."),
//    CREDIT_CARD_NUMBER_DOES_NOT_MATCH_THE_METHOD_OF_PAYMENT(2052, "Credit card number does not match the method of payment.", "Número de tarjeta de crédito no coincide con la forma de pago."),
//    ISSUER_REQUIRES_MORE_INFORMATION(2055, "Issuer requires more information.", "Emisor requiere más información."),
//    RESTRICTED_CARD(2056, "Restricted card.", "Tarjeta Restringido."),
//    CHECK_MERCHANT_ENTITLEMENT(2058, "Check merchant entitlement", "Compruebe derecho mercantil"),
//    CAPTURE_NOT_ALLOWED(2059, "Capture not allowed.", "Capture no permitido."),
//    COMMUNICATION_ERROR_RESEND(2060, "Communication error - resend.", "Error de comunicación - reenvío."),
//    RETAIN_CARD(2062, "Retain card.", "Conserve la tarjeta."),
//    NO_ACTION_TAKEN(2063, "No action taken.", "Ninguna medida adoptada."),
//    SUSPICION_OF_MANIPULATION(2064, "Suspicion of manipulation.", "La sospecha de manipulación."),
//    REQUESTED_FUNCTION_NOT_SUPPORTED(2065, "Requested function not supported.", "Función solicitada no es compatible."),
//    SECONDARY_TRANSACTION_WAS_NOT_CARRIED_OUT_WITH_THE_CARD_WHICH_WAS_USED_FOR_THE_ORIGINAL_TRANSACTION(2066, "Secondary transaction was not carried out with the card which was used for the original transaction.", "Transacción secundario no se llevó a cabo con la tarjeta que se utilizó para la transacción original."),
//    THE_TRANSACTION_AMOUNT_OF_THE_SECONDARY_TRANSACTION_IS_HIGHER_THAN_ORIGINAL_TRANSACTION_AMOUNT(2067, "The transaction amount of the secondary transaction is higher than original transaction amount.", "El monto de la transacción de la negociación secundaria es mayor que la cantidad de transacción original."),
//    CARD_ISSUER_TEMPORARILY_NOT_REACHABLE(2068, "Card issuer temporarily not reachable.", "Emisor temporalmente sin cobertura tarjeta."),
//    THE_CARD_TYPE_IS_NOT_PROCESSED_BY_THE_AUTHORIZATION_CENTER(2069, "The card type is not processed by the authorization center.", "El tipo de tarjeta no es procesada por el centro de autorización."),
//    PROCESSING_TEMPORARILY_NOT_POSSIBLE(2070, "Processing temporarily not possible.", "Procesamiento temporalmente no es posible."),
//    DECLINED_DATA_ENTRY_ERROR(2073, "Declined - data entry error.", "Rehusó - Error de entrada de datos."),
//    DECLINED_NEGATIVE_DATA(2074, "Declined – negative data.", "Rehusó - datos negativos."),
//    DECLINED_SCORING_DECLINE(2075, "Declined - scoring decline.", "Rehusó - anotando declive."),
//    DECLINED_NO_RESPONSE_FROM_HOST(2076, "Declined - no response from host.", "Rehusó - no hay respuesta del host."),
//    INSTITUTION_IS_NO_LONGER_VALID(2077, "Institution is no longer valid.", "Institución ya no es válido."),
//    CARD_NOT_ACTIVE_EFFECTIVE_DATE_NOT_VALID(2078, "Card not active. Effective date not valid.", "La tarjeta no activo. Fecha de vigencia no es válida.");

    private final int code;
    private final String description;
    private final String descriptionEs;

    QpError(int code, String description, String descriptionEs) {
        this.code = code;
        this.description = description;
        this.descriptionEs = descriptionEs;
    }

    public int code() {
        return code;
    }

    public String description(QpLocale qpLocale) {
        if (qpLocale == QpLocale.SPANISH) {
            return descriptionEs;
        } else {
            return description;
        }
    }


    public static QpError fromCode(Integer code) {
        if (code == null) {
            return null;
        }
        for (QpError value : values()) {
            if (value.code == code) {
                return value;
            }
        }
        return null;
    }

}
