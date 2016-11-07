
package br.univali.sisnet.api;

import br.univali.sisnet.model.DevicePosition;
import br.univali.sisnet.persistence.DevicePositionDAO;
import br.univali.sisnet.util.GeometryUtil;
import com.vividsolutions.jts.geom.Point;
import java.util.Calendar;
import java.util.List;
import java.util.Map;
import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

@Path("/position")
public class DevicePositionResource {

    @POST
    @Consumes(MediaType.APPLICATION_JSON)
    public Response savePosition (Map<String, String> data) {

        if (data.get("latitude") == null || data.get("longitude") == null) {
            throw new IllegalArgumentException("Latitude ou longitude inválidas.");
        }

        DevicePosition position = new DevicePosition();

        position.setDeviceId(data.get("deviceId"));
        position.setDate(Calendar.getInstance());

        Point point = GeometryUtil.latLongToPoint(
            Float.parseFloat(data.get("latitude")),
            Float.parseFloat(data.get("longitude"))
        );

        position.setCoordinates(point);

        DevicePositionDAO dao = DevicePositionDAO.getInstance();
        dao.persist(position);

        return Response.ok().build();

    }

    @GET
    @Produces(MediaType.APPLICATION_JSON)
    public Response getPositions () {

        DevicePositionDAO dao = DevicePositionDAO.getInstance();

        List<DevicePosition> list = dao.findAll();
        
        return Response.ok(list).build();

    }

}
