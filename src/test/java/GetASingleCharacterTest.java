import lombok.var;
import model.Gender;
import model.Status;
import model.response.CharacterResponse;
import model.response.ErrorResponse;
import org.testng.annotations.Test;

import static org.assertj.core.api.Assertions.assertThat;

public class GetASingleCharacterTest extends BaseTest {

    @Test
    public void it_should_get_character_by_id() {

        //Given: prepare requirements
        Integer id = 2;

        //When: send request
        var readableResponse = rickAndMortyService.getASingleCharacter(id);
        var characterResponse = readableResponse.getResponse().as(CharacterResponse.class);

        //Then: make assertions
        assertThat(readableResponse.getStatusCode()).isEqualTo(200);
        assertThat(characterResponse.getId()).isEqualTo(2);
        assertThat(characterResponse.getName()).isEqualTo("Morty Smith");
        assertThat(characterResponse.getStatus()).isEqualTo(Status.Alive);
        assertThat(characterResponse.getSpecies()).isEqualTo("Human");
        assertThat(characterResponse.getGender()).isEqualTo(Gender.Male);
        assertThat(characterResponse.getOrigin().getName()).isEqualTo("unknown");
        assertThat(characterResponse.getLocation().getName()).isEqualTo("Citadel of Ricks");
        assertThat(characterResponse.getLocation().getUrl()).isEqualTo("https://rickandmortyapi.com/api/location/3");
        assertThat(characterResponse.getImage()).isEqualTo("https://rickandmortyapi.com/api/character/avatar/2.jpeg");
        assertThat(characterResponse.getUrl()).isEqualTo("https://rickandmortyapi.com/api/character/2");
        assertThat(characterResponse.getCreated()).isEqualTo("2017-11-04T18:50:21.651Z");
    }

    @Test
    public void it_should_return_404_when_character_not_found() {

        //Given: prepare requirements
        Integer id = 999;

        //When: send request
        var readableResponse = rickAndMortyService.getASingleCharacter(id);
        var errorResponse = readableResponse.getResponse().as(ErrorResponse.class);

        //Then: make assertions
        assertThat(readableResponse.getStatusCode()).isEqualTo(404);
        assertThat(errorResponse.getError()).isEqualTo("Character not found");

    }
}
