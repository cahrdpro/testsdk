package com.oel.olipaysdk.client;

import com.oel.olipaysdk.utils.Convert;
import com.oel.olipaysdk.utils.StringUtils;

import io.sentry.SentryClient;
import io.sentry.event.BreadcrumbBuilder;

public class OpDevolucionSentryLogger {

    static OpDevolucionRequest logBreadcrumbRequest(OpDevolucionRequest request, String url, SentryClient sentry) {
        sentry.getContext().recordBreadcrumb(new BreadcrumbBuilder()
                .setMessage("OpDevolucion request")
                .withData("url", url)
                .withData("comercioId", Convert.toString(request.comercioId))
                .withData("contrasena", StringUtils.mask(request.contrasena))
                .withData("modo", request.modo)
                .withData("monto", Convert.toString(request.monto))
                .withData("transaccionId", request.transaccionId)
                .withData("codigoAprobacion", request.codigoAprobacion)
                .withData("referenciaBanco", request.referenciaBanco)
                .withData("firma", request.firma)
                .withData("dirIp", request.dirIp)
                .withData("version", request.version)
                .build());
        return request;
    }

    static OpDevolucionResponse logBreadcrumbResponse(OpDevolucionResponse response, String url, SentryClient sentry) {
        sentry.getContext().recordBreadcrumb(new BreadcrumbBuilder()
                .setMessage("OpDevolucion response")
                .withData("url", url)
                .withData("comercioId", Convert.toString(response.comercioId))
                .withData("transaccionId", response.transaccionId)
                .withData("fechaTransaccion", response.fechaTransaccion)
                .withData("horaTransaccion", response.horaTransaccion)
                .withData("monto", Convert.toString(response.monto))
                .withData("referencia", response.referencia)
                .withData("codigoRespuesta", Convert.toString(response.codigoRespuesta))
                .withData("procReturnMsg", response.procReturnMsg)
                .withData("ccErrorCode", Convert.toString(response.ccErrorCode))
                .withData("ccReturnMsg", response.ccReturnMsg)
                .withData("codigoAprobacion", response.codigoAprobacion)
                .withData("afiliacion", response.afiliacion)
                .build());
        return response;
    }

}
