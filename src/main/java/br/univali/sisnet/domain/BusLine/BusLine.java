
package br.univali.sisnet.domain.BusLine;

import br.univali.sisnet.domain.BusCompany.BusCompany;
import br.univali.sisnet.domain.EntityBase;
import java.io.Serializable;
import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name = "bus_line")
public class BusLine extends EntityBase implements Serializable {

    private static final long serialVersionUID = -8099323615585550694L;

    private String name;

    @ManyToOne(optional = false)
    @JoinColumn(name = "bus_company_id")
    private BusCompany busCompany;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public BusCompany getBusCompany() {
        return busCompany;
    }

    public void setBusCompany(BusCompany busCompany) {
        this.busCompany = busCompany;
    }

}
