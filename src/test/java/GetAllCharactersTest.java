import lombok.var;
import model.response.GetAllCharactersResponse;
import org.testng.annotations.Test;

import static org.assertj.core.api.Assertions.assertThat;

public class GetAllCharactersTest extends BaseTest {

    @Test
    public void it_should_get_all_characters() {

        //Given: prepare requirements

        //When: send request
        var readableResponse = rickAndMortyService.getAllCharacters();
        var allCharactersResponse = readableResponse.getResponse().as(GetAllCharactersResponse.class);

        //Then: make assertions
        assertThat(readableResponse.getStatusCode()).isEqualTo(200);
        assertThat(allCharactersResponse.getInfo().getCount()).isEqualTo(826);
        assertThat(allCharactersResponse.getInfo().getPages()).isEqualTo(42);
        assertThat(allCharactersResponse.getInfo().getNext()).isEqualTo("https://rickandmortyapi.com/api/character?page=2");
        assertThat(allCharactersResponse.getResults()).isNotEmpty();

    }
}
