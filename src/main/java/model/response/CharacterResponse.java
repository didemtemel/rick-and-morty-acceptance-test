package model.response;

import lombok.Getter;
import lombok.Setter;
import model.Gender;
import model.Location;
import model.Origin;
import model.Status;

import java.util.List;

@Getter
@Setter
public class CharacterResponse {

    public Integer id;
    public String name;
    public Status status;
    public String species;
    public String type;
    public Gender gender;
    public Origin origin;
    public Location location;
    public String image;
    public List<String> episode;
    public String url;
    public String created;

}