package fr.human.booster.HarryPotter.service.interfaces;

import java.util.List;

public interface ServiceInterface <T, ID, DTO>{

    T create(DTO dto);

    T update(DTO dto, ID ID);

    void delete(T object);

    T findOneById(ID ID);

    List<T> list();
}
