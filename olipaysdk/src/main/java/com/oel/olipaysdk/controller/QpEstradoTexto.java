package com.oel.olipaysdk.controller;

public enum QpEstradoTexto {

    LOADING(102, "Loading", "Cargando"),
    EXECUTING_HISTORY_REQUEST(103, "Executing history request", "Solicitando historial"),
    PROCESSING_SIGNATURE(104, "Processing signature", "Procesando firma"),
    PERFORMING_ECOMMERCE_TRANSACTION(106, "Performing e-commerce transaction", "Realizando transacción e-commerce"),
    OBTAINING_INFORMATION_FROM_THE_READER(107, "Obtaining information from the reader", "Obteniendo información"), // 2
    PERFORMING_SEND_VOUCHER(108, "Emailing voucher", "Enviando voucher de pago"),
    PERFORMING_CANCELLATION(109, "Performing cancellation", "Realizando cancelación"),
    PERFORMING_ECOMMERCE_CANCELLATION(110, "Performing e-commerce Cancellation", "Realizando cancelación de e-commerce"),
    PERFORMING_PRINT_VOUCHER(111, "Printing voucher", "Imprimiendo voucher"),
    APPROACH_INSERT_SLIDE_CARD(115, "Approach, insert or slide", "Acerque, inserte o deslice"),// 1
    CONTACTING_THE_BANK(116, "Contacting the bank", "Contactando al banco"),
    PERFORMING_REVERSE(117, "Performing reverse", "Realizando reversa"),
    PERFORMING_POST_AUTORIZACION(118, "Performing post-authorization", "Realizando post autorización"),
    PERFORMING_RE_AUTORIZACION(119, "Performing re-authorization", "Realizando re authorización"),
    PERFORMING_CANCELLATION_PRE_AUTORIZACION(120, "Performing cancelation of pre-authorization", "Realizando cancelación de pre autorización"),
    USE_ICC_CARD(121, "Insert card", "Inserte tarjeta"),
    BAD_SWIPE(122, "Try again or insert chip", "Deslice de nuevo o inserte tarjeta"),
    NOT_ICC(123, "Try again", "Error en chip, intente de nuevo"),
    NEED_FALLBACK(124, "Try again or slide", "Error en chip, intente de nuevo o deslice"),
    PLEASE_SIGN(125, "Please sign", "Por favor firme"),
    SEE_PHONE_REMOVE_AND_PRESENT_CARD(126, "See Phone, Remove And Present Card", "Vea teléfono, retire y presente tarjeta"),
    CARD_READ_OK(127, "Card Read Ok", "Lectura correcta de tarjeta"),
    PLEASE_REMOVE_CARD(128, "Pls remove card", "Puede retirar la tarjeta"),
    SEE_PHONE(129, "See phone", "Ver teléfono"),
    NFC_MESSAGE(130, "", ""),
    PERFORMING_DEVOLUCION(131, "Performing refund", "Realizando devolución"),
    PERFORMING_ECOMMERCE_DEVOLUCION(132, "Performing e-commerce refund", "Realizando devolución e-commerce"),
    NO_CONNECTION_RETRYING_IN_1_SECONDS(133, "No connection, retrying in 1 seconds.", "Sin conexión, intentando en 1 segundo."),
    NO_CONNECTION_RETRYING_IN_2_SECONDS(134, "No connection, retrying in 2 seconds.", "Sin conexión, intentando en 2 segundos."),
    NO_CONNECTION_RETRYING_IN_3_SECONDS(135, "No connection, retrying in 3 seconds.", "Sin conexión, intentando en 3 segundos."),
    NO_CONNECTION_RETRYING_IN_4_SECONDS(136, "No connection, retrying in 4 seconds.", "Sin conexión, intentando en 4 segundos."),
    NO_CONNECTION_RETRYING_IN_5_SECONDS(137, "No connection, retrying in 5 seconds.", "Sin conexión, intentando en 5 segundos."),
    USE_ICC_CARD_FOR_AMOUNTS_GREATER_THAN_ALLOWED_CONTACTLESS_AMOUNT(138, "Insert card for amounts greater than $" + EmvConfig.CONTACTLESS_MAX_AMOUNT + ".00.", "Para montos mayores a $" + EmvConfig.CONTACTLESS_MAX_AMOUNT +  ".00 insertar tarjeta"),
    ERROR_TRY_AGAIN(139, "Error try again", "Error intente de nuevo"),
    PLS_USE_CONTACT_IC_CARD(140, "Insert card", "Inserte Tarjeta"),
    NEED_SIGNATURE(141, "Need signature", "Necesita Firma"),
    END_APPLICATION(142, "End application", "Fin de Aplicativo"),
    DISPLAY_BALANCE(143, "Display balance", "Mostrar Balance"),
    APPLICATION_BLOCKED(144, "Application blocked", "Aplicación Bloqueada"),
    TRY_AGAIN_RESENT_CARD(145, "Try again", "Acerque Nuevamente"),
    USE_MAG_STRIPE(146, "Swipe card", "Deslice Tarjeta"),
    NFC_MULTI_CARD_USED(147, "Make sure to approach with only one card.", "Asegúrate de acercar sólo una tarjeta.");

    private final int code;
    private final String description;
    private final String descriptionEs;

    QpEstradoTexto(int code, String description, String descriptionEs) {
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
}

