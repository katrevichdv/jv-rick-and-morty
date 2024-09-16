package mate.academy.rickandmorty.controller;

import java.util.List;
import mate.academy.rickandmorty.dto.CharacterResponseDto;
import mate.academy.rickandmorty.service.CharacterService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/character")
public class CharacterController {
    private final CharacterService characterService;

    public CharacterController(CharacterService characterService) {
        this.characterService = characterService;
    }

    @GetMapping()
    public CharacterResponseDto getRandom() {
        return characterService.getRandom();
    }

    @GetMapping("/search")
    public List<CharacterResponseDto> searchByName(String name) {
        return characterService.search(name);
    }
}
