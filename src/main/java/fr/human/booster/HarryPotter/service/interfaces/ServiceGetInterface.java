package fr.human.booster.HarryPotter.service.interfaces;

public interface ServiceGetInterface<T, ID>{

    T findOneById(ID id);
}
