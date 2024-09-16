package mate.academy.rickandmorty.external.dto;

public record InfoDto(
        Long count,
        Integer pages,
        String next,
        String prev
) {
}
