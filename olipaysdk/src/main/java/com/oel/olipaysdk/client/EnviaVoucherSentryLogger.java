package com.oel.olipaysdk.client;

import com.oel.olipaysdk.utils.Convert;
import com.oel.olipaysdk.utils.StringUtils;

import io.sentry.SentryClient;
import io.sentry.event.BreadcrumbBuilder;

class EnviaVoucherSentryLogger {

    static EnviaVoucherRequest logBreadcrumbRequest(EnviaVoucherRequest request, String url, SentryClient sentry) {
        sentry.getContext().recordBreadcrumb(new BreadcrumbBuilder()
                .setMessage("EnviaVoucher request")
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

    static EnviaVoucherResponse logBreadcrumbResponse(EnviaVoucherResponse response, String url, SentryClient sentry) {
        sentry.getContext().recordBreadcrumb(new BreadcrumbBuilder()
                .setMessage("EnviaVoucher response")
                .withData("url", url)
                .withData("codigoRespuesta", Convert.toString(response.codigoRespuesta))
                .withData("procReturnMsg", response.procReturnMsg)
                .withData("ccErrorCode", Convert.toString(response.ccErrorCode))
                .withData("ccReturnMsg", response.ccReturnMsg)
                .build());
        return response;
    }

}
