
package br.univali.sisnet.util;

import com.vividsolutions.jts.geom.Coordinate;
import com.vividsolutions.jts.geom.GeometryFactory;
import com.vividsolutions.jts.geom.Point;


public class GeometryUtil {

    private static final GeometryFactory geometryFactory = new GeometryFactory();

    public static Point latLongToPoint (Float latitude, Float longitude) {

        Coordinate coordinate = new Coordinate(latitude, longitude);

        Point point = geometryFactory.createPoint(coordinate);

        return point;

    }

}
