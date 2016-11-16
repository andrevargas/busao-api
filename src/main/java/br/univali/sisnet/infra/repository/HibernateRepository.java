
package br.univali.sisnet.infra.repository;

import br.univali.sisnet.infra.hibernate.SessionUtil;
import java.io.Serializable;
import java.util.List;
import org.hibernate.Session;
import org.hibernate.SessionFactory;

public class HibernateRepository<T> implements Repository<T> {

    private final Class<T> persistentClass;
    private final SessionFactory sessionFactory;

    public HibernateRepository(Class<T> persistentClass) {
        this.persistentClass = persistentClass;
        this.sessionFactory = SessionUtil.getSessionFactory();
    }

    @Override
    @SuppressWarnings("unchecked")
    public List<T> findAll() {

        final Session session = sessionFactory.openSession();
        List<T> list = session.createCriteria(persistentClass.getName()).list();
        session.close();

        return list;

    }

    @Override
    @SuppressWarnings("unchecked")
    public T findById(Serializable id) {

        final Session session = sessionFactory.getCurrentSession();
        T entity = (T) session.get(persistentClass.getName(), id);
        session.close();

        return entity;

    }

    @Override
    public void persist(T entity) {

        final Session session = sessionFactory.openSession();

        session.beginTransaction();
        session.saveOrUpdate(entity);
        session.getTransaction().commit();

        session.close();

    }

    @Override
    public void remove(T entity) {

        final Session session = sessionFactory.openSession();

        session.beginTransaction();
        session.delete(entity);
        session.getTransaction().commit();

        session.close();

    }

}