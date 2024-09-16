package mate.academy.rickandmorty.external;

import java.util.List;
import mate.academy.rickandmorty.model.Character;

public interface CharacterClient {
    Long getCount();

    List<Character> getAllCharacters();
}
