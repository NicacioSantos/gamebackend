package com.servissistema.game.controllers;

import com.servissistema.game.dtos.GameDto;
import com.servissistema.game.dtos.GameDtoId;
import com.servissistema.game.entities.Game;
import com.servissistema.game.services.GameService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

import static org.springframework.http.HttpStatus.OK;

@RestController
@RequestMapping(value = "/games")
public class GameController {

    @Autowired
    private GameService gameService;


    @PostMapping
    public ResponseEntity<GameDto> save(@RequestBody GameDto gameDto) {

        GameDto gameDto1 = gameService.save(gameDto);

        return new ResponseEntity<GameDto>(gameDto1, HttpStatus.CREATED);
    }

    @GetMapping(value = "/{id}")
    public ResponseEntity<GameDto> findById(@PathVariable Long id) {

           GameDto  gameDto1 = gameService.findById(id);

        return new ResponseEntity<GameDto>(gameDto1, OK);

    }

    @GetMapping
    public ResponseEntity<List<GameDtoId>> findallGames() {

        List<GameDtoId> gameDto = gameService.findallGame();

        return new ResponseEntity<List<GameDtoId>>(gameDto, OK);


    }


    @PutMapping(value = "/{id}")
    public ResponseEntity<GameDto> update(@PathVariable Long id, @RequestBody GameDto gameDto) {

        GameDto gameDto1 = gameService.update(id, gameDto);

        return new ResponseEntity<GameDto>(gameDto1, OK);

    }

    @DeleteMapping
    public ResponseEntity<String> delete(@RequestParam Long id) {

        gameService.delete(id);

        return new ResponseEntity<String>("Game deletado", HttpStatus.CREATED);
    }
}
