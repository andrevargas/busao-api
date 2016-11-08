
package br.univali.sisnet.api;

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
import org.json.JSONObject;

@Path("/position")
public class DevicePositionResource {

    @POST
    @Consumes(MediaType.APPLICATION_JSON)
    public Response savePosition (String data) {

        JSONObject json = new JSONObject(data);

        DevicePosition position = new DevicePosition();

        position.setDeviceId(json.getString("deviceId"));
        position.setDate(Calendar.getInstance());

        Point point = GeometryUtil.latLongToPoint(
            json.getDouble("latitude"),
            json.getDouble("longitude")
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
