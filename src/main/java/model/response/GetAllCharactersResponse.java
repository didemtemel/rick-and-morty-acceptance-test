package model.response;

import lombok.Getter;
import lombok.Setter;
import model.Info;

import java.util.List;

@Getter
@Setter
public class GetAllCharactersResponse {
    private Info info;
    private List<CharacterResponse> results;
}
