
package br.univali.sisnet.infra.repository.DevicePosition;

import br.univali.sisnet.domain.DevicePosition.DevicePosition;
import br.univali.sisnet.infra.repository.HibernateRepository;


public class DevicePositionHibernateRepository
        extends HibernateRepository<DevicePosition>
        implements DevicePositionRepository {

    public DevicePositionHibernateRepository() {
        super(DevicePosition.class);
    }

}
