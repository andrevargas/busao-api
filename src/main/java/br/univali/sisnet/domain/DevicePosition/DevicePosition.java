
package br.univali.sisnet.domain.DevicePosition;

import br.univali.sisnet.domain.EntityBase;
import br.univali.sisnet.infra.serialization.PointToJsonSerializer;
import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import com.vividsolutions.jts.geom.Point;
import java.io.Serializable;
import java.util.Calendar;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import org.hibernate.annotations.Type;

@Entity
@Table(name = "device_position")
public class DevicePosition extends EntityBase implements Serializable {

    private static final long serialVersionUID = -2119205480067319519L;

    @Column(name = "device_id", nullable = true)
    private String deviceId;


    @Column(nullable = false)
    @Type(type = "org.hibernate.spatial.GeometryType")
    @JsonSerialize(using = PointToJsonSerializer.class)
    private Point coordinates;

    @Column(name = "send_date", nullable = false)
    @Temporal(TemporalType.TIMESTAMP)
    private Calendar sendDate;
    
    public String getDeviceId() {
        return deviceId;
    }

    public void setDeviceId(String deviceId) {
        this.deviceId = deviceId;
    }

    public Point getCoordinates() {
        return coordinates;
    }

    public void setCoordinates(Point coordinates) {
        this.coordinates = coordinates;
    }

    public Calendar getDate() {
        return sendDate;
    }

    public void setDate(Calendar date) {
        this.sendDate = date;
    }

}
