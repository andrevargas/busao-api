
package br.univali.sisnet.api;

import br.univali.sisnet.api.schema.DevicePositionSchema;
import br.univali.sisnet.model.DevicePosition;
import br.univali.sisnet.persistence.DevicePositionDAO;
import br.univali.sisnet.util.GeometryUtil;
import com.vividsolutions.jts.geom.Point;
import java.util.Calendar;
import java.util.List;
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
    public Response savePosition (DevicePositionSchema data) {

        if (data.latitude == null && data.longitude == null) {
            throw new IllegalArgumentException("Latitude ou longitude inválidas.");
        }

        DevicePosition position = new DevicePosition();

        position.setDeviceId(data.deviceId);
        position.setDate(Calendar.getInstance());

        Point point = GeometryUtil.latLongToPoint(
            data.latitude,
            data.longitude
        );

        position.setLocation(point);

        DevicePositionDAO dao = DevicePositionDAO.getInstance();
        dao.persist(position);

        return Response.ok().build();

    }

    @GET
    @Produces(MediaType.APPLICATION_JSON)
    public Response getPositions () {

        DevicePositionDAO dao = DevicePositionDAO.getInstance();

        List<DevicePosition> list = dao.findAll();

        for (DevicePosition devicePosition : list) {
            System.out.println(devicePosition.getId());
        }

        return Response.ok(list).build();

    }

}
