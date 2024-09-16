package mate.academy.rickandmorty.external.dto;

import java.net.URL;
import java.time.Instant;
import java.util.List;

public record CharacterDto(
        Long id,
        String name,
        String status,
        String species,
        String type,
        String gender,
        LocationDto origin,
        LocationDto location,
        URL image,
        List<String> episode,
        String url,
        Instant created
) {
}
