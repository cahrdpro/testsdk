package com.oel.olipaysdk.client;

import com.oel.olipaysdk.utils.Convert;
import com.oel.olipaysdk.utils.StringUtils;

import io.sentry.SentryClient;
import io.sentry.event.BreadcrumbBuilder;

public class OpTransaccionesSentryLogger {

    static OpTransaccionesRequest logBreadcrumbRequest(OpTransaccionesRequest request, String url, SentryClient sentry) {
        sentry.getContext().recordBreadcrumb(new BreadcrumbBuilder()
                .setMessage("OpTransacciones request")
                .withData("url", url)
                .withData("comercioId", Convert.toString(request.comercioId))
                .withData("contrasena", StringUtils.mask(request.contrasena))
                .withData("transaccionId", request.transaccionId)
                .withData("fechaInicio", Convert.toString(request.fechaInicio))
                .withData("fechaFin", Convert.toString(request.fechaFin))
                .withData("version", request.version)
                .build());
        return request;
    }

    static OpTransaccionesResponse logBreadcrumbResponse(OpTransaccionesResponse response, String url, SentryClient sentry) {
        sentry.getContext().recordBreadcrumb(new BreadcrumbBuilder()
                .setMessage("OpTransacciones response")
                .withData("url", url)
                .withData("transacciones", "***" + Convert.toString(response.arrayOfTransaccion.size()) + "***")
                .build());
        return response;
    }

}
