import lombok.var;
import model.Gender;
import model.Status;
import model.response.CharacterResponse;
import model.response.ErrorResponse;
import org.testng.annotations.Test;

import java.util.ArrayList;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

public class GetMultipleCharactersTest extends BaseTest {

    @Test
    public void it_should_get_multiple_characters_by_ids() {

        //Given: prepare requirements
        List<Integer> ids = new ArrayList<Integer>();
        ids.add(1);
        ids.add(2);

        //When: send request
        var readableResponse = rickAndMortyService.getMultipleCharacters(ids);
        var characterResponse = readableResponse.getResponse().as(CharacterResponse[].class);

        //Then: make assertions
        assertThat(readableResponse.getStatusCode()).isEqualTo(200);
        assertThat(characterResponse.length).isEqualTo(2);
        assertThat(characterResponse[0].getId()).isEqualTo(1);
        assertThat(characterResponse[0].getName()).isEqualTo("Rick Sanchez");
        assertThat(characterResponse[0].getStatus()).isEqualTo(Status.Alive);
        assertThat(characterResponse[0].getSpecies()).isEqualTo("Human");
        assertThat(characterResponse[0].getGender()).isEqualTo(Gender.Male);
        assertThat(characterResponse[0].getOrigin().getName()).isEqualTo("Earth (C-137)");
        assertThat(characterResponse[0].getOrigin().getUrl()).isEqualTo("https://rickandmortyapi.com/api/location/1");
        assertThat(characterResponse[0].getLocation().getName()).isEqualTo("Citadel of Ricks");
        assertThat(characterResponse[0].getLocation().getUrl()).isEqualTo("https://rickandmortyapi.com/api/location/3");
        assertThat(characterResponse[0].getImage()).isEqualTo("https://rickandmortyapi.com/api/character/avatar/1.jpeg");
        assertThat(characterResponse[0].getUrl()).isEqualTo("https://rickandmortyapi.com/api/character/1");
        assertThat(characterResponse[0].getCreated()).isEqualTo("2017-11-04T18:48:46.250Z");
        assertThat(characterResponse[1].getId()).isEqualTo(2);
        assertThat(characterResponse[1].getName()).isEqualTo("Morty Smith");
        assertThat(characterResponse[1].getStatus()).isEqualTo(Status.Alive);
        assertThat(characterResponse[1].getSpecies()).isEqualTo("Human");
        assertThat(characterResponse[1].getGender()).isEqualTo(Gender.Male);
        assertThat(characterResponse[1].getOrigin().getName()).isEqualTo("unknown");
        assertThat(characterResponse[1].getLocation().getName()).isEqualTo("Citadel of Ricks");
        assertThat(characterResponse[1].getLocation().getUrl()).isEqualTo("https://rickandmortyapi.com/api/location/3");
        assertThat(characterResponse[1].getImage()).isEqualTo("https://rickandmortyapi.com/api/character/avatar/2.jpeg");
        assertThat(characterResponse[1].getUrl()).isEqualTo("https://rickandmortyapi.com/api/character/2");
        assertThat(characterResponse[1].getCreated()).isEqualTo("2017-11-04T18:50:21.651Z");
    }

    @Test
    public void it_should_get_one_character_when_one_of_the_id_is_not_found_in_ids_list_while_getting_multiple_characters() {

        //Given: prepare requirements
        List<Integer> ids = new ArrayList<Integer>();
        ids.add(1);
        ids.add(999);

        //When: send request
        var readableResponse = rickAndMortyService.getMultipleCharacters(ids);
        var characterResponse = readableResponse.getResponse().as(CharacterResponse[].class);

        //Then: make assertions
        assertThat(readableResponse.getStatusCode()).isEqualTo(200);
        assertThat(characterResponse.length).isEqualTo(1);
        assertThat(characterResponse[0].getId()).isEqualTo(1);
        assertThat(characterResponse[0].getName()).isEqualTo("Rick Sanchez");
        assertThat(characterResponse[0].getStatus()).isEqualTo(Status.Alive);
        assertThat(characterResponse[0].getSpecies()).isEqualTo("Human");
        assertThat(characterResponse[0].getGender()).isEqualTo(Gender.Male);
        assertThat(characterResponse[0].getOrigin().getName()).isEqualTo("Earth (C-137)");
        assertThat(characterResponse[0].getOrigin().getUrl()).isEqualTo("https://rickandmortyapi.com/api/location/1");
        assertThat(characterResponse[0].getLocation().getName()).isEqualTo("Citadel of Ricks");
        assertThat(characterResponse[0].getLocation().getUrl()).isEqualTo("https://rickandmortyapi.com/api/location/3");
        assertThat(characterResponse[0].getImage()).isEqualTo("https://rickandmortyapi.com/api/character/avatar/1.jpeg");
        assertThat(characterResponse[0].getUrl()).isEqualTo("https://rickandmortyapi.com/api/character/1");
        assertThat(characterResponse[0].getCreated()).isEqualTo("2017-11-04T18:48:46.250Z");
    }

    @Test
    public void it_should_get_empty_list_when_ids_are_not_found_in_ids_list_while_getting_multiple_characters() {

        //Given: prepare requirements
        List<Integer> ids = new ArrayList<Integer>();
        ids.add(998);
        ids.add(999);

        //When: send request
        var readableResponse = rickAndMortyService.getMultipleCharacters(ids);
        var characterResponse = readableResponse.getResponse().as(CharacterResponse[].class);

        //Then: make assertions
        assertThat(readableResponse.getStatusCode()).isEqualTo(200);
        assertThat(characterResponse.length).isEqualTo(0);
    }
}
