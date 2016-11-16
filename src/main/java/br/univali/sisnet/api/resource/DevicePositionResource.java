
package br.univali.sisnet.api.resource;

import br.univali.sisnet.domain.DevicePosition.DevicePosition;
import br.univali.sisnet.infra.repository.DevicePosition.DevicePositionHibernateRepository;
import br.univali.sisnet.infra.repository.DevicePosition.DevicePositionRepository;
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

        if (!json.has("latitude") || !json.has("longitude")) {
            throw new IllegalArgumentException("Latitude e longitude não podem ser nulas.");
        }

        DevicePosition position = new DevicePosition();

        position.setDeviceId(json.getString("deviceId"));
        position.setDate(Calendar.getInstance());

        Point point = GeometryUtil.latLongToPoint(
            json.getDouble("latitude"),
            json.getDouble("longitude")
        );

        position.setCoordinates(point);

        DevicePositionRepository repository =
                new DevicePositionHibernateRepository();

        repository.persist(position);

        return Response.ok().build();

    }

    @GET
    @Produces(MediaType.APPLICATION_JSON)
    public Response getPositions () {

        DevicePositionRepository repository =
                new DevicePositionHibernateRepository();

        List<DevicePosition> list = repository.findAll();

        return Response.ok(list).build();

    }

}
