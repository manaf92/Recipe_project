package se.lexicon.Recipe_project.service.entity.interfaces;

import java.util.List;

public interface GenericServiceCRUD <T, FORM,ID> {
    T create(FORM form);
    List<T> findAll();
    T findById(ID id);
    T update(FORM form);
    boolean delete(ID id);
}