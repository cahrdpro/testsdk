package com.oel.olipaysdk.client;

import org.ksoap2.serialization.Marshal;
import org.ksoap2.serialization.PropertyInfo;
import org.ksoap2.serialization.SoapSerializationEnvelope;
import org.xmlpull.v1.XmlPullParser;
import org.xmlpull.v1.XmlPullParserException;
import org.xmlpull.v1.XmlSerializer;

import java.io.IOException;

public class MarshalString implements Marshal {

    public Object readInstance(XmlPullParser parser, String namespace, String name, PropertyInfo expected)
            throws IOException, XmlPullParserException {
        return parser.nextText();
    }

    public void writeInstance(XmlSerializer writer, Object obj) throws IOException {
        writer.text(obj.toString().replaceAll("\u0003", ""));
    }

    public void register(SoapSerializationEnvelope cm) {
        cm.addMapping(cm.xsd, "string", String.class, this);
    }
}
