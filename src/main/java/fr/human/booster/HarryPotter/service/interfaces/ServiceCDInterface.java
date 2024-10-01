package fr.human.booster.HarryPotter.service.interfaces;

public interface ServiceCDInterface <T, DTO> {

    T create(DTO dto);

    void delete(T object);
}
