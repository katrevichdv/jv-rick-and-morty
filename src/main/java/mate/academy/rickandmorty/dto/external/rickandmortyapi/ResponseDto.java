package mate.academy.rickandmorty.dto.external.rickandmortyapi;

import java.util.List;

public record ResponseDto(
        InfoDto info,
        List<CharacterDto> results
) {
}
