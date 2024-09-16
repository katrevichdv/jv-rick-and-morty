package mate.academy.rickandmorty.external;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import mate.academy.rickandmorty.external.dto.ResponseBodyDto;
import mate.academy.rickandmorty.external.mapper.CharacterDtoMapper;
import mate.academy.rickandmorty.model.Character;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestClient;

@Service
public class RickAndMortyCharacterClientImpl implements CharacterClient {
    private final static String BASE_URL = "https://rickandmortyapi.com/api/character";

    private final RestClient restClient;
    private final CharacterDtoMapper mapper;

    public RickAndMortyCharacterClientImpl(RestClient.Builder builder, CharacterDtoMapper mapper) {
        this.restClient = builder.build();
        this.mapper = mapper;
    }

    @Override
    public Long getCount() {
        return getPage(BASE_URL).info().count();
    }

    @Override
    public List<Character> getAllCharacters() {
        List<ResponseBodyDto> list = new ArrayList<>();
        String nextUrl = BASE_URL;
        while (nextUrl != null) {
            ResponseBodyDto temp = getPage(nextUrl);
            list.add(temp);
            nextUrl = temp.info().next();
        }
        return list.stream()
                .map(ResponseBodyDto::results)
                .flatMap(Collection::stream)
                .map(mapper::toModel)
                .toList();
    }

    private ResponseBodyDto getPage(String pageUrl) {
        return restClient.get().uri(pageUrl).retrieve().body(ResponseBodyDto.class);
    }
}
