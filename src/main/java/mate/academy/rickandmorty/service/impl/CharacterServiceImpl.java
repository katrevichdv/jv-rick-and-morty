package mate.academy.rickandmorty.service.impl;

import java.util.List;
import java.util.Random;
import mate.academy.rickandmorty.dto.CharacterResponseDto;
import mate.academy.rickandmorty.mapper.CharacterResponseDtoMapper;
import mate.academy.rickandmorty.repository.CharacterRepository;
import mate.academy.rickandmorty.service.CharacterService;
import org.springframework.stereotype.Service;

@Service
public class CharacterServiceImpl implements CharacterService {
    private final CharacterRepository repository;
    private final CharacterResponseDtoMapper mapper;
    private final Random random = new Random();

    public CharacterServiceImpl(CharacterRepository repository, CharacterResponseDtoMapper mapper) {
        this.repository = repository;
        this.mapper = mapper;
    }

    @Override
    public CharacterResponseDto getRandom() {
        return mapper.toDto(repository.getReferenceById(getRandomId()));
    }

    @Override
    public List<CharacterResponseDto> search(String name) {
        return repository.findByNameContainsIgnoreCase(name)
                .stream()
                .map(mapper::toDto)
                .toList();
    }

    private long getRandomId() {
        return random.nextLong(repository.count()) + 1;
    }
}
