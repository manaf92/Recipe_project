package se.lexicon.Recipe_project.dao.interfaces;

import java.util.List;
import java.util.Optional;

public interface CRUD<T,ID> {
    T create(T t);
    T findById (ID id);
    List<T> findAll();
    T update(T t);
    void delete(ID id);
}
