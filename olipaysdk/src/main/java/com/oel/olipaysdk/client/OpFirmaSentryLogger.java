package com.oel.olipaysdk.client;

import com.oel.olipaysdk.utils.Convert;
import com.oel.olipaysdk.utils.StringUtils;

import io.sentry.SentryClient;
import io.sentry.event.BreadcrumbBuilder;

class OpFirmaSentryLogger {

    static OpFirmaRequest logBreadcrumbRequest(OpFirmaRequest request, String url, SentryClient sentry) {
        sentry.getContext().recordBreadcrumb(new BreadcrumbBuilder()
                .setMessage("OpFirma request")
                .withData("url", url)
                .withData("comercioId", Convert.toString(request.comercioId))
                .withData("contrasena", StringUtils.mask(request.contrasena))
                .withData("transaccionId", request.transaccionId)
                .withData("monto", Convert.toString(request.monto))
                .withData("codigoAprobacion", request.codigoAprobacion)
                .withData("referencia", request.referenciaBanco)
                .withData("firma", StringUtils.mask(request.firma))
                .withData("version", request.version)
                .build());
        return request;
    }

    static OpFirmaResponse logBreadcrumbResponse(OpFirmaResponse response, String url, SentryClient sentry) {
        sentry.getContext().recordBreadcrumb(new BreadcrumbBuilder()
                .setMessage("OpFirma response")
                .withData("url", url)
                .withData("comercioId", Convert.toString(response.comercioId))
                .withData("transaccionId", response.transaccionId)
                .withData("codigoAprobacion", response.codigoAprobacion)
                .withData("codigoRespuesta", Convert.toString(response.codigoRespuesta))
                .withData("procReturnMsg", response.procReturnMsg)
                .withData("ccErrorCode", Convert.toString(response.ccErrorCode))
                .withData("ccReturnMsg", response.ccReturnMsg)
                .build());
        return response;
    }

}
