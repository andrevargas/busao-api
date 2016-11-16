
package br.univali.sisnet.domain.BusCompany;

import br.univali.sisnet.domain.BusLine.BusLine;
import br.univali.sisnet.domain.EntityBase;
import java.io.Serializable;
import java.util.List;
import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table(name = "bus_company")
public class BusCompany extends EntityBase implements Serializable {

    private static final long serialVersionUID = -3625179172214178003L;

    private String name;

    @OneToMany(mappedBy = "busCompany", cascade = CascadeType.ALL)
    private List<BusLine> lines;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public List<BusLine> getLines() {
        return lines;
    }

    public void setLines(List<BusLine> lines) {
        this.lines = lines;
    }

}
