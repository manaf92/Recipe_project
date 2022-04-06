package se.lexicon.Recipe_project.service.entity.interfaces;


import java.util.Collection;

public interface GenericServiceCRUD <T, FORM,ID> {
    T create(FORM form);
    Collection<T> findAll();
    T findById(ID id);
    T update(FORM form);
    boolean delete(ID id);
}