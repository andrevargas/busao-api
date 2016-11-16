
package br.univali.sisnet.infra.repository.BusCompany;

import br.univali.sisnet.domain.BusCompany.BusCompany;
import br.univali.sisnet.infra.repository.HibernateRepository;


public class BusCompanyHibernateRepository
        extends HibernateRepository<BusCompany>
        implements BusCompanyRepository {

    public BusCompanyHibernateRepository() {
        super(BusCompany.class);
    }

}
