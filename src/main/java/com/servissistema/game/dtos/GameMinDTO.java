package com.servissistema.game.dtos;

import com.servissistema.game.entities.Game;
import com.servissistema.game.projections.GameMinProjection;
import lombok.Data;
import org.springframework.beans.BeanUtils;

@Data
public class GameMinDTO {

    private Long id;
    private String title;
    private Integer year;
    private String imgUrl;
    private String shortDescription;

    public GameMinDTO() {

    }

    public GameMinDTO(Game entity) {

        id = entity.getId();
        title = entity.getTitle();
        year = entity.getYear();
        imgUrl = entity.getImgUrl();
        shortDescription = entity.getShortDescription();
    }

    public GameMinDTO(GameMinProjection projection) {

        BeanUtils.copyProperties(projection,this);
    }


}
