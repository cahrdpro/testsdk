package com.oel.olipaysdk.client;

import com.oel.olipaysdk.utils.Convert;
import com.oel.olipaysdk.utils.StringUtils;

import io.sentry.SentryClient;
import io.sentry.event.BreadcrumbBuilder;

public class OpEstadoCuentaSentryLogger {

    static OpEstadoCuentaRequest logBreadcrumbRequest(OpEstadoCuentaRequest request, String url, SentryClient sentry) {
        sentry.getContext().recordBreadcrumb(new BreadcrumbBuilder()
                .setMessage("OpEstadoCuenta request")
                .withData("url", url)
                .withData("comercioId", Convert.toString(request.comercioId))
                .withData("contrasena", StringUtils.mask(request.contrasena))
                .withData("periodo", Convert.toString(request.periodo))
                .withData("version", request.version)
                .build());
        return request;
    }

    static OpEstadoCuentaResponse logBreadcrumbResponse(OpEstadoCuentaResponse response, String url, SentryClient sentry) {
        sentry.getContext().recordBreadcrumb(new BreadcrumbBuilder()
                .setMessage("OpEstadoCuenta response")
                .withData("url", url)
                .build());
        return response;
    }

}
