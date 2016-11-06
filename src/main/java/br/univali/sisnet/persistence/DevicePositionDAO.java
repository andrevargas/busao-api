
package br.univali.sisnet.persistence;

import br.univali.sisnet.model.DevicePosition;
import br.univali.sisnet.util.HibernateUtil;
import java.util.List;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;

public class DevicePositionDAO {

    private static DevicePositionDAO instance;
    private final SessionFactory sessionFactory;

    public static DevicePositionDAO getInstance () {
        if (instance == null) {
            instance = new DevicePositionDAO();
        }
        return instance;
    }

    public DevicePositionDAO() {
        sessionFactory = HibernateUtil.getSessionFactory();
    }

    public void persist (DevicePosition devicePosition) {

        final Session session = sessionFactory.openSession();

        session.beginTransaction();
        session.persist(devicePosition);
        session.getTransaction().commit();

        session.close();

    }

    public List<DevicePosition> findAll() {

        final Session session = sessionFactory.openSession();

        Query query = session.createQuery("From " + DevicePosition.class.getName());
        List<DevicePosition> results = query.list();

        session.close();

        return results;

    }

}
