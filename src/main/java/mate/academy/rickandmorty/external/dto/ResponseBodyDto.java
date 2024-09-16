package mate.academy.rickandmorty.external.dto;

import java.util.List;

public record ResponseBodyDto(
        InfoDto info,
        List<CharacterDto> results
) {
}
