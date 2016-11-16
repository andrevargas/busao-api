
package br.univali.sisnet.infra.repository.BusLine;

import br.univali.sisnet.domain.BusLine.BusLine;
import br.univali.sisnet.infra.repository.HibernateRepository;


public class BusLineHibernateRepository
    extends HibernateRepository<BusLine>
    implements BusLineRepository {

    public BusLineHibernateRepository() {
        super(BusLine.class);
    }

}
