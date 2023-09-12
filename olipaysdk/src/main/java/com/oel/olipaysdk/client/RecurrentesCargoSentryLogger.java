package com.oel.olipaysdk.client;

import com.oel.olipaysdk.utils.Convert;
import com.oel.olipaysdk.utils.StringUtils;

import io.sentry.SentryClient;
import io.sentry.event.BreadcrumbBuilder;

class RecurrentesCargoSentryLogger {

    static RecurrentesCargoRequest logBreadcrumbRequest(RecurrentesCargoRequest request, String url, SentryClient sentry) {
        sentry.getContext().recordBreadcrumb(new BreadcrumbBuilder()
                .setMessage("RecurrentesCargo request")
                .withData("url", url)
                .withData("comercioId", Convert.toString(request.comercioId))
                .withData("contrasena", StringUtils.mask(request.contrasena))
                .withData("modo", request.modo)
                .withData("monto", Convert.toString(request.monto))
                .withData("transaccionId", request.transaccionId)
                .withData("referencia", request.referencia)
                .withData("tarjeta", StringUtils.maskCardNumber(request.tarjeta))
                .withData("tipo", request.tipo)
                .withData("mes", request.mes)
                .withData("anio", request.anio)
                .withData("digitos", request.digitos)
                .withData("titular", request.titular)
                .withData("dirIp", request.dirIp)
                .withData("posEntryMode", request.posEntryMode)
                .withData("track2", StringUtils.mask(request.track2))
                .withData("emvTags", StringUtils.mask(request.emvTags))
                .withData("diferimiento", request.diferimiento)
                .withData("numeroPagos", request.numeroPagos)
                .withData("plan", request.plan)
                .withData("version", request.version)
                .build());
        return request;
    }

    static RecurrentesCargoResponse logBreadcrumbResponse(RecurrentesCargoResponse response, String url, SentryClient sentry) {
        sentry.getContext().recordBreadcrumb(new BreadcrumbBuilder()
                .setMessage("RecurrentesCargo response")
                .withData("url", url)
                .withData("comercioId", Convert.toString(response.comercioId))
                .withData("transaccionId", response.transaccionId)
                .withData("fechaTransaccion", response.fechaTransaccion)
                .withData("horaTransaccion", response.horaTransaccion)
                .withData("monto", Convert.toString(response.monto))
                .withData("codigoRespuesta", Convert.toString(response.codigoRespuesta))
                .withData("procReturnMsg", response.procReturnMsg)
                .withData("ccErrorCode", Convert.toString(response.ccErrorCode))
                .withData("ccReturnMsg", response.ccReturnMsg)
                .withData("codigoAprobacion", response.codigoAprobacion)
                .withData("afiliacion", response.afiliacion)
                .withData("emvData", response.emvData)
                .withData("operType", response.operType)
                .withData("cardType", response.cardType)
                .withData("issuerData", response.issuerData)
                .withData("issuingBank", response.issuingBank)
                .build());
        return response;
    }

}
