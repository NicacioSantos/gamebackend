package com.servissistema.game.entities;

import com.servissistema.game.dtos.GameDto;
import com.servissistema.game.dtos.GameDtoId;
import jakarta.persistence.*;
import lombok.Data;
import org.springframework.beans.BeanUtils;

@Data
@Entity
@Table(name = "tb_game")
public class Game {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String title;
    @Column(name = "game_year")
    private Integer year; // year palavra reservado postgres
    private String genre;
    private String platforms;
    private Double score;
    private String imgUrl;
    @Column(columnDefinition = "TEXT")
    private String shortDescription;
    @Column(columnDefinition = "TEXT")
    private String longDescription;

    public Game() {

    }

    public Game(Long id, String title, Integer year, String genre, String platforms, Double score, String imgUrl, String shortDescription, String longDescription) {
        this.id = id;
        this.title = title;
        this.year = year;
        this.genre = genre;
        this.platforms = platforms;
        this.score = score;
        this.imgUrl = imgUrl;
        this.shortDescription = shortDescription;
        this.longDescription = longDescription;
    }

    public Game(GameDto gameDto) {

        BeanUtils.copyProperties(gameDto, this);

    }

    public Game(GameDtoId gameDtoId) {

        BeanUtils.copyProperties(gameDtoId, this);

    }


}
