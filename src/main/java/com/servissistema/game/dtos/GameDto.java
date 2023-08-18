package com.servissistema.game.dtos;

import com.servissistema.game.entities.Game;
import lombok.Data;
import org.springframework.beans.BeanUtils;
@Data
public class GameDto {

    private Long id;
    private String title;
    private Integer year;
    private String genre;
    private String platforms;
    private Double score;
    private String imgUrl;
    private String shortDescription;
    private String longDescription;

    public GameDto() {
    }

    public GameDto(Game game) {

        BeanUtils.copyProperties(game, this);


    }
}
