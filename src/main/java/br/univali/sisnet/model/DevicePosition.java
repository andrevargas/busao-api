
package br.univali.sisnet.model;

import br.univali.sisnet.persistence.PointToJsonSerializer;
import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import com.vividsolutions.jts.geom.Point;
import java.io.Serializable;
import java.util.Calendar;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import org.hibernate.annotations.Type;

@Entity
@Table(name = "device_position")
public class DevicePosition implements Serializable {

    private static final long serialVersionUID = 2897509549093274789L;

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    private Long id;

    @Column(name = "device_id", nullable = true)
    private String deviceId;


    @Column(nullable = false)
    @Type(type = "org.hibernate.spatial.GeometryType")
    @JsonSerialize(using = PointToJsonSerializer.class)
    private Point location;

    @Column(name = "send_date", nullable = false)
    @Temporal(TemporalType.TIMESTAMP)
    private Calendar sendDate;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getDeviceId() {
        return deviceId;
    }

    public void setDeviceId(String deviceId) {
        this.deviceId = deviceId;
    }

    public Point getLocation() {
        return location;
    }

    public void setLocation(Point location) {
        this.location = location;
    }

    public Calendar getDate() {
        return sendDate;
    }

    public void setDate(Calendar date) {
        this.sendDate = date;
    }

}
