package com.servissistema.game.dtos;

import com.servissistema.game.entities.Game;
import com.servissistema.game.projections.GameMinProjection;
import lombok.Data;
import org.springframework.beans.BeanUtils;

import java.util.List;

@Data
public class GameDtoId {
    private Long id;
    private String title;
    private Integer year;
    private String imgUrl;
    private String shortDescription;


    public GameDtoId() {

    }

    public GameDtoId(Game game) {

        BeanUtils.copyProperties(game, this);


    }


}
