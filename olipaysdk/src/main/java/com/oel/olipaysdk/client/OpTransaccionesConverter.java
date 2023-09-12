package com.oel.olipaysdk.client;

import static com.oel.olipaysdk.client.QpayClient.NAMESPACE;

import org.ksoap2.serialization.SoapObject;

public class OpTransaccionesConverter {

    static SoapObject requestPojoToSoapObject(OpTransaccionesRequest request) {
        SoapObject soapObject = new SoapObject(NAMESPACE, "OpTransacciones");
        SoapObject cTransaccionesReq = new SoapObject(NAMESPACE, "cTransaccionesReq");
        cTransaccionesReq.addProperty(NAMESPACE, "comercioId", request.comercioId);
        cTransaccionesReq.addProperty(NAMESPACE, "contrasena", request.contrasena);
        cTransaccionesReq.addProperty(NAMESPACE, "transaccionId", request.transaccionId);
        cTransaccionesReq.addProperty(NAMESPACE, "FechaInicio", request.fechaInicio);
        cTransaccionesReq.addProperty(NAMESPACE, "FechaFin", request.fechaFin);
        cTransaccionesReq.addProperty(NAMESPACE, "deviceId", request.deviceId);
        cTransaccionesReq.addProperty(NAMESPACE, "version", request.version);
        soapObject.addProperty(NAMESPACE, "request", cTransaccionesReq);
        return soapObject;
    }

    static OpTransaccionesResponse soapObjectToResponsePojo(SoapObject soapObject) {
        OpTransaccionesResponse response = new OpTransaccionesResponse();
        SoapObject arrayOfTransaccion = (SoapObject) soapObject.getProperty(0);
        for (int i = 0; i < arrayOfTransaccion.getPropertyCount(); i++) {
            OpTransaccionesResponse.Transaccion transaccion = new OpTransaccionesResponse.Transaccion();
            SoapObject transaccionProperty = (SoapObject) arrayOfTransaccion.getProperty(i);
            transaccion.comercioId = SoapObjectUtils.getIntegerByName(transaccionProperty, "comercioId");
            transaccion.comercio = SoapObjectUtils.getStringByName(transaccionProperty, "comercio");
            transaccion.tipoMovimiento = SoapObjectUtils.getStringByName(transaccionProperty, "tipoMovimiento");
            transaccion.origenTransaccion = SoapObjectUtils.getStringByName(transaccionProperty, "origenTransaccion");
            transaccion.CanalTransaccion = SoapObjectUtils.getStringByName(transaccionProperty, "CanalTransaccion");
            transaccion.transaccionId = SoapObjectUtils.getStringByName(transaccionProperty, "transaccionId");
            transaccion.monto = SoapObjectUtils.getBigDecimalByName(transaccionProperty, "monto");
            transaccion.codigoRespuesta = SoapObjectUtils.getIntegerByName(transaccionProperty, "codigoRespuesta");
            transaccion.resultado = SoapObjectUtils.getStringByName(transaccionProperty, "resultado");
            transaccion.referenciaBanco = SoapObjectUtils.getStringByName(transaccionProperty, "referencia");
            transaccion.codigoAprobacion = SoapObjectUtils.getStringByName(transaccionProperty, "codigoAprobacion");
            transaccion.afiliacion = SoapObjectUtils.getStringByName(transaccionProperty, "afiliacion");
            transaccion.fechaTransaccion = SoapObjectUtils.getStringByName(transaccionProperty, "fechaTransaccion");
            transaccion.horaTransaccion = SoapObjectUtils.getStringByName(transaccionProperty, "horaTransaccion");
            transaccion.fechaRegistro = SoapObjectUtils.getDateByName(transaccionProperty, "fechaRegistro");
            transaccion.tarjeta = SoapObjectUtils.getStringByName(transaccionProperty, "tarjeta");
            transaccion.titular = SoapObjectUtils.getStringByName(transaccionProperty, "titular");
            transaccion.mes = SoapObjectUtils.getStringByName(transaccionProperty, "mes");
            transaccion.anio = SoapObjectUtils.getStringByName(transaccionProperty, "anio");
            transaccion.emisor = SoapObjectUtils.getStringByName(transaccionProperty, "emisor");
            transaccion.marca = SoapObjectUtils.getStringByName(transaccionProperty, "marca");
            transaccion.tipo = SoapObjectUtils.getStringByName(transaccionProperty, "tipo");
            transaccion.ARQC = SoapObjectUtils.getStringByName(transaccionProperty, "ARQC");
            transaccion.AID = SoapObjectUtils.getStringByName(transaccionProperty, "AID");
            transaccion.TSI = SoapObjectUtils.getStringByName(transaccionProperty, "TSI");
            transaccion.TVR = SoapObjectUtils.getStringByName(transaccionProperty, "TVR");
            transaccion.APN = SoapObjectUtils.getStringByName(transaccionProperty, "APN");
            transaccion.AL = SoapObjectUtils.getStringByName(transaccionProperty, "AL");
            transaccion.firmado = SoapObjectUtils.getIntegerByName(transaccionProperty, "firmado");
            transaccion.usurio = SoapObjectUtils.getStringByName(transaccionProperty, "usurio");
            transaccion.serieLector = SoapObjectUtils.getStringByName(transaccionProperty, "serieLector");
            response.arrayOfTransaccion.add(transaccion);
        }
        return response;
    }

}
