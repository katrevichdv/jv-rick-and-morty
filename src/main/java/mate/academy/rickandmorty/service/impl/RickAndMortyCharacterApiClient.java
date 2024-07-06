package mate.academy.rickandmorty.service.impl;

import java.util.List;
import java.util.Objects;
import java.util.stream.IntStream;
import java.util.stream.Stream;
import mate.academy.rickandmorty.dto.external.rickandmortyapi.CharacterDto;
import mate.academy.rickandmorty.dto.external.rickandmortyapi.ResponseDto;
import mate.academy.rickandmorty.repository.CharacterRepository;
import mate.academy.rickandmorty.service.CharacterClient;
import org.springframework.stereotype.Service;

@Service
public class RickAndMortyCharacterApiClient implements CharacterClient {
    private final CharacterRepository repository;

    public RickAndMortyCharacterApiClient(CharacterRepository repository) {
        this.repository = repository;
    }

    @Override
    public void fetchUpdates() {
        long count = repository.count();
        ResponseDto responseDto = makeRequest(1);
        long available = responseDto.info().count();

        if (available == count) {
            return;
        }

        if (count == 0) {

            Stream.concat(responseDto.results().stream(),
                    makeRequest(2, responseDto.info().pages()).stream());

        }

    }

    private ResponseDto makeRequest(int page) {
        return null;
    }

    private List<List<CharacterDto>> makeRequest(int fromPage, int toPage) {
        return IntStream.rangeClosed(fromPage, toPage)
                .mapToObj(this::makeRequest)
                .filter(Objects::nonNull)
                .map(ResponseDto::results)
                .toList();
    }
}
