package fr.human.booster.HarryPotter.controllerRest;

import com.fasterxml.jackson.annotation.JsonView;
import fr.human.booster.HarryPotter.dto.HouseDTO;
import fr.human.booster.HarryPotter.entity.House;
import fr.human.booster.HarryPotter.service.HouseService;
import fr.human.booster.HarryPotter.utils.JsonViews;
import jakarta.validation.Valid;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/house")
@AllArgsConstructor
public class HouseController {

    private final HouseService houseService;

    @GetMapping
    @JsonView(JsonViews.ViewsHouse.class)
    public List<House> HouseList(){
        return houseService.list();
    }

    @GetMapping("/{search}")
    @JsonView(JsonViews.ViewsHouse.class)
    public House findHouseBySearch(@PathVariable String  search){
        return houseService.findBySearch(search);
    }

    @PostMapping
    @JsonView(JsonViews.ViewsHouse.class)
    public House houseService(@Valid @RequestBody HouseDTO houseDTO){
        return houseService.create(houseDTO);
    }

    @PutMapping("/{id}")
    @JsonView(JsonViews.ViewsHouse.class)
    public void updateHouseById(
            @PathVariable Integer id,
            @Valid @RequestBody HouseDTO houseDTO){
        if (id != null){
            houseService.update(houseDTO, id);
        }
    }

    @DeleteMapping("/{id}")
    public void deleteHouseById(@PathVariable Integer id){
        if (id != null){
            houseService.delete(houseService.findOneById(id));
        }
    }
}
