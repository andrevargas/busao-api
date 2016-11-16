
package br.univali.sisnet.infra.repository;

import java.io.Serializable;
import java.util.List;


public interface Repository<T> {

    List<T> findAll ();
    T findById (Serializable id);
    void persist (T entity);
    void remove (T entity);

}
