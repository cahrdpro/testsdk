package com.oel.olipaysdk.client;

import com.oel.olipaysdk.utils.Convert;
import com.oel.olipaysdk.utils.StringUtils;

import io.sentry.SentryClient;
import io.sentry.event.BreadcrumbBuilder;

public class OpReAutorizacionSentryLogger {

    static OpReAutorizacionRequest logBreadcrumbRequest(OpReAutorizacionRequest request, String url, SentryClient sentry) {
        sentry.getContext().recordBreadcrumb(new BreadcrumbBuilder()
                .setMessage("OpReAutorizacion request")
                .withData("url", url)
                .withData("comercioId", Convert.toString(request.comercioId))
                .withData("contrasena", StringUtils.mask(request.contrasena))
                .withData("modo", request.modo)
                .withData("monto", Convert.toString(request.monto))
                .withData("transaccionId", request.transaccionId)
                .withData("codigoAprobacion", request.codigoAprobacion)
                .withData("referenciaBanco", request.referenciaBanco)
                .withData("dirIp", request.dirIp)
                .withData("version", request.version)
                .build());
        return request;
    }

    static OpReAutorizacionResponse logBreadcrumbResponse(OpReAutorizacionResponse response, String url, SentryClient sentry) {
        sentry.getContext().recordBreadcrumb(new BreadcrumbBuilder()
                .setMessage("OpReAutorizacion response")
                .withData("url", url)
                .withData("comercioId", Convert.toString(response.comercioId))
                .withData("terminalId", response.terminalId)
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
                .withData("afiliacionEmpresa", response.afiliacionEmpresa)
                .build());
        return response;
    }

}
