package mate.academy.rickandmorty.service.impl;

import java.util.List;
import java.util.Random;
import mate.academy.rickandmorty.dto.internal.CharacterResponseDto;
import mate.academy.rickandmorty.mapper.CharacterMapper;
import mate.academy.rickandmorty.repository.CharacterRepository;
import mate.academy.rickandmorty.service.CharacterService;
import org.springframework.stereotype.Service;

@Service
public class CharacterServiceImpl implements CharacterService {
    private final CharacterMapper mapper;
    private final CharacterRepository repository;
    private final Random random = new Random();

    public CharacterServiceImpl(CharacterMapper mapper, CharacterRepository repository) {
        this.mapper = mapper;
        this.repository = repository;
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

    private int getRandomId() {
        return random.nextInt((int) repository.count()) + 1;
    }
}
