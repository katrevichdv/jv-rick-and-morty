package mate.academy.rickandmorty.dto.external.rickandmortyapi;

import java.net.URL;
import java.time.Instant;
import java.util.List;

public record CharacterDto(
        Integer id,
        String name,
        String status,
        String species,
        String type,
        String gender,
        LocationDto origin,
        LocationDto location,
        URL image,
        List<URL> episode,
        URL url,
        Instant created
) {
}
