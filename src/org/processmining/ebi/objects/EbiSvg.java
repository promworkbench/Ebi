package org.processmining.ebi.objects;

import java.io.ByteArrayInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.net.URI;
import java.nio.charset.StandardCharsets;

import com.kitfox.svg.SVGDiagram;
import com.kitfox.svg.SVGUniverse;

public class EbiSvg {

	public static SVGDiagram fromEbiString(String value) {
		SVGUniverse universe = new SVGUniverse();
		InputStream stream = new ByteArrayInputStream(value.getBytes(StandardCharsets.UTF_8));
		URI uri;
		try {
			uri = universe.loadSVG(stream, "hoi");
		} catch (IOException e) {
			return null;
		}

		SVGDiagram diagram = universe.getDiagram(uri);

		if (diagram == null) {
			throw new RuntimeException("the svg-structure given is not valid");
		}
		return diagram;
	}

}
