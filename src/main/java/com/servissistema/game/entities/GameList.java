package com.servissistema.game.entities;

import jakarta.persistence.*;
import lombok.Data;
import org.springframework.beans.BeanUtils;

@Data
@Entity
@Table(name = "tb_game_list")
public class GameList {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String name;

    public GameList() {
    }

    public GameList(Game game) {

        BeanUtils.copyProperties(game, this);


    }
}
