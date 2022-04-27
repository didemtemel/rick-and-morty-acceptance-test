import lombok.var;
import model.Gender;
import model.Status;
import model.response.ErrorResponse;
import model.response.FilterCharactersResponse;
import org.assertj.core.internal.bytebuddy.utility.RandomString;
import org.testng.annotations.Test;
import util.QueryParam;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

public class FilterCharactersTest extends BaseTest {

    @Test
    public void it_should_filter_by_the_given_name() {

        //Given: prepare requirements
        String name = "Rick";

        //When: send request
        var readableResponse = rickAndMortyService.filterCharacters(List.of(new QueryParam("name", name)));
        var charactersResponse = readableResponse.getResponse().as(FilterCharactersResponse.class);

        //Then: make assertions
        assertThat(readableResponse.getStatusCode()).isEqualTo(200);
        assertThat(charactersResponse.getInfo().getCount()).isEqualTo(107);
        assertThat(charactersResponse.getInfo().getPages()).isEqualTo(6);
        assertThat(charactersResponse.getResults().stream().allMatch(ch -> ch.getName().contains(name)));

    }

    @Test
    public void it_should_filter_by_the_given_name_and_status() {

        //Given: prepare requirements
        String name = "Rick";
        String status = "Alive";

        //When: send request
        var readableResponse = rickAndMortyService.filterCharacters(List.of(new QueryParam("name", name), new QueryParam("status", status)));
        var charactersResponse = readableResponse.getResponse().as(FilterCharactersResponse.class);

        //Then: make assertions
        assertThat(readableResponse.getStatusCode()).isEqualTo(200);
        assertThat(charactersResponse.getInfo().getCount()).isEqualTo(29);
        assertThat(charactersResponse.getInfo().getPages()).isEqualTo(2);
        assertThat(charactersResponse.getResults().stream().allMatch(ch -> ch.getName().contains(name)));
        assertThat(charactersResponse.getResults().stream().allMatch(ch -> ch.getStatus().equals(Status.Alive)));

    }

    @Test
    public void it_should_filter_by_the_given_gender_and_status() {

        //Given: prepare requirements
        String gender = "Genderless";
        String species = "Human";

        //When: send request
        var readableResponse = rickAndMortyService.filterCharacters(List.of(new QueryParam("species", species), new QueryParam("gender", gender)));
        var charactersResponse = readableResponse.getResponse().as(FilterCharactersResponse.class);

        //Then: make assertions
        assertThat(readableResponse.getStatusCode()).isEqualTo(200);
        assertThat(charactersResponse.getInfo().getCount()).isEqualTo(3);
        assertThat(charactersResponse.getInfo().getPages()).isEqualTo(1);
        assertThat(charactersResponse.getResults().stream().allMatch(ch -> ch.getGender().equals(Gender.Genderless)));
        assertThat(charactersResponse.getResults().stream().allMatch(ch -> ch.getSpecies().equals(species)));

    }

    @Test
    public void it_should_return_404_when_character_not_found_while_filtering_characters() {

        //Given: prepare requirements
        RandomString name = new RandomString(10);

        //When: send request
        var readableResponse = rickAndMortyService.filterCharacters(List.of(new QueryParam("name", name.toString())));
        var error = readableResponse.getResponse().as(ErrorResponse.class);

        //Then: make assertions
        assertThat(readableResponse.getStatusCode()).isEqualTo(404);
        assertThat(error.getError()).isEqualTo("There is nothing here");

    }
}
