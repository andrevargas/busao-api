
package br.univali.sisnet.util;

import com.vividsolutions.jts.geom.Coordinate;
import com.vividsolutions.jts.geom.GeometryFactory;
import com.vividsolutions.jts.geom.Point;
import com.vividsolutions.jts.geom.PrecisionModel;


public class GeometryUtil {

    private static final GeometryFactory geometryFactory =
            new GeometryFactory(new PrecisionModel(), 4674);

    public static Point latLongToPoint (Double latitude, Double longitude) {

        Coordinate coordinate = new Coordinate(longitude, latitude);

        Point point = geometryFactory.createPoint(coordinate);

        return point;

    }

}
