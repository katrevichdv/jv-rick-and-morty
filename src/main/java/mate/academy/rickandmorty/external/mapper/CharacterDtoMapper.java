package mate.academy.rickandmorty.external.mapper;

import mate.academy.rickandmorty.config.MapperConfig;
import mate.academy.rickandmorty.external.dto.CharacterDto;
import mate.academy.rickandmorty.model.Character;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

@Mapper(config = MapperConfig.class)
public interface CharacterDtoMapper {
    @Mapping(source = "id", target = "externalId")
    @Mapping(target = "id", ignore = true)
    Character toModel(CharacterDto dto);
}
