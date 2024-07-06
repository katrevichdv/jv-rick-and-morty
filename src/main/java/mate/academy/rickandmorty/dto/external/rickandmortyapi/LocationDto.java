package mate.academy.rickandmorty.dto.external.rickandmortyapi;

import java.net.URL;

public record LocationDto(
        String name,
        URL url
) {
}
