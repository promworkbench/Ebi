package org.processmining.ebi.objects;

import java.io.IOException;
import java.io.InputStream;

import org.apache.commons.io.IOUtils;
import org.apache.commons.io.output.ByteArrayOutputStream;
import org.deckfour.xes.model.XLog;
import org.deckfour.xes.out.XSerializer;
import org.deckfour.xes.out.XesXmlSerializer;
import org.processmining.framework.plugin.PluginContext;
import org.xeslite.parser.XesLiteXmlParser;

public class EbiEventLog {

	public static String XLogToEbiString(PluginContext context, XLog log) throws IOException {
		ByteArrayOutputStream stream = new ByteArrayOutputStream();
		XSerializer logSerializer = new XesXmlSerializer();
		logSerializer.serialize(log, stream);
		stream.close();
		return stream.toString("UTF-8");
	}

	public static XLog EbiStringToXLog(PluginContext context, String value) throws Exception {
		InputStream stream = IOUtils.toInputStream(value, "UTF-8");
		XesLiteXmlParser parser = new XesLiteXmlParser(false);
		return parser.parse(stream).get(0);
	}
}