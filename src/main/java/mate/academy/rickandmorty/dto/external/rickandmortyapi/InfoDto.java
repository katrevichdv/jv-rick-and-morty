package mate.academy.rickandmorty.dto.external.rickandmortyapi;

import java.net.URL;

public record InfoDto(
        Integer count,
        Integer pages,
        URL next,
        URL prev
) {
}
