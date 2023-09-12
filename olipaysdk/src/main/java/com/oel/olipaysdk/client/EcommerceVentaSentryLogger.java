package com.oel.olipaysdk.client;

import com.oel.olipaysdk.utils.Convert;
import com.oel.olipaysdk.utils.StringUtils;

import io.sentry.SentryClient;
import io.sentry.event.BreadcrumbBuilder;

public class EcommerceVentaSentryLogger {

    static EcommerceVentaRequest logBreadcrumbRequest(EcommerceVentaRequest request, String url, SentryClient sentry) {
        sentry.getContext().recordBreadcrumb(new BreadcrumbBuilder()
                .setMessage("EcommerceVenta request")
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
                .withData("diferimiento", request.diferimiento)
                .withData("numeroPagos", request.numeroPagos)
                .withData("plan", request.plan)
                .withData("xid", request.xid)
                .withData("cavv", request.cavv)
                .withData("eci", request.eci)
                .withData("status3d", request.status_3d)
                .build());
        return request;
    }

    static EcommerceVentaResponse logBreadcrumbResponse(EcommerceVentaResponse response, String url, SentryClient sentry) {
        sentry.getContext().recordBreadcrumb(new BreadcrumbBuilder()
                .setMessage("EcommerceVenta response")
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
                .build());
        return response;
    }

}
