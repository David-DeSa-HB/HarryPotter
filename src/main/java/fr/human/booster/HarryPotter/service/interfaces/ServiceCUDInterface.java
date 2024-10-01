package fr.human.booster.HarryPotter.service.interfaces;

public interface ServiceCUDInterface <T, DTO, DTOU, ID> extends ServiceCDInterface <T, DTO>{

    T update(DTOU dto, ID id);
}
