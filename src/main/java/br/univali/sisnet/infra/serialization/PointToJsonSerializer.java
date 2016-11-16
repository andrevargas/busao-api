
package br.univali.sisnet.infra.serialization;

import com.fasterxml.jackson.core.JsonGenerator;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.JsonSerializer;
import com.fasterxml.jackson.databind.SerializerProvider;
import com.vividsolutions.jts.geom.Point;
import java.io.IOException;


public class PointToJsonSerializer extends JsonSerializer<Point> {

    @Override
    public void serialize(Point point, JsonGenerator jg, SerializerProvider sp)
            throws IOException, JsonProcessingException {

        Double y = null;
        Double x = null;

        if (point != null) {
            y = point.getY();
            x = point.getX();
        }

        jg.writeStartObject();

        jg.writeNumberField("latitude", y);
        jg.writeNumberField("longitude", x);

        jg.writeEndObject();

    }

}
