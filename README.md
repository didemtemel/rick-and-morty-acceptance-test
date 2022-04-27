## Rick And Morty Acceptance Test

This project was created to test [Rick And Morty API](https://rickandmortyapi.com/) using Rest-Assured. If you want to take a look at my medium post, link is [here](https://medium.com/@didemtemel/api-testing-with-rest-assured-bbfad02135a6).


## Required software
* Java JDK 11+
* Maven installed and in your classpath

## How to execute the tests
You can open each test class under `src\test\java` and execute them, or you can run `test.xml` under `src\test\resources`.

## Test cases
GetASingleCharacterTest
- it_should_get_character_by_id()
- it_should_return_404_when_character_not_found()

GetMultipleCharactersTest
- it_should_get_multiple_characters_by_ids()
- it_should_get_one_character_when_one_of_the_id_is_not_found_in_ids_list_while_getting_multiple_characters()
- it_should_get_empty_list_when_ids_are_not_found_in_ids_list_while_getting_multiple_characters()

GetAllCharactersTest
- it_should_get_all_characters()

FilterCharactersTest
- it_should_filter_by_the_given_name()
- it_should_filter_by_the_given_name_and_status()
- it_should_filter_by_the_given_gender_and_status()
- it_should_return_404_when_character_not_found_while_filtering_characters()
