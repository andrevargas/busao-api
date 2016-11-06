
package br.univali.sisnet.api.schema;

import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement
public class DevicePositionSchema {

    @XmlElement
    public Float latitude;

    @XmlElement
    public Float longitude;

    @XmlElement
    public String deviceId;

}
