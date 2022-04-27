package model;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class Info {
    private Integer count;
    private Integer pages;
    private String next;
    private String prev;
}
