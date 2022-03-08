package se.lexicon.Recipe_project.service.interfaces;


import java.util.Collection;

public interface GenericServiceCRUD <T, FORM,ID> {
    T create(FORM form);
    Collection<T> findAll();
    T findById(ID id);
    T update(ID id, FORM form);
    void delete(ID id);
}