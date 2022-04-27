package service;

import util.QueryParam;
import util.ReadableResponse;

import java.util.List;

public class RickAndMortyService extends BaseService {

    public ReadableResponse getAllCharacters() {
        return getRequest("/character");
    }

    public ReadableResponse getASingleCharacter(Integer id) {
        return getRequest("/character/" + id);
    }

    public ReadableResponse getMultipleCharacters(List<Integer> ids) {
        return getRequest("/character/" + ids);
    }

    public ReadableResponse filterCharacters(List<QueryParam> queryParams) {
        return getRequest(queryParams, "/character/");
    }

}
