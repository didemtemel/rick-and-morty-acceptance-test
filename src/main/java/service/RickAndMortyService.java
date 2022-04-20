package service;


import util.QueryParam;
import util.ReadableResponse;

import java.util.List;

public class RickAndMortyService extends BaseService{

    public ReadableResponse getAllCharacters() { return getRequest("/characters"); }

    public ReadableResponse getASingleCharacter(Integer id) { return getRequest("/characters/" + id); }
    
    public ReadableResponse getMultipleCharacters(List<Integer> ids) { return getRequest("/characters/" + ids); }

    public ReadableResponse filterCharacters(List<QueryParam> queryParams) { return getRequest("/characters/" + queryParams); }


}
