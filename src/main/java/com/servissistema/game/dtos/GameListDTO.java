package com.servissistema.game.dtos;

import com.servissistema.game.entities.GameList;
import lombok.Data;
import org.springframework.beans.BeanUtils;

@Data
public class GameListDTO {

    private Long id;
    private String name;

    public GameListDTO() {
    }

    public GameListDTO(GameList gameList) {

        BeanUtils.copyProperties(gameList, this);


    }
}
