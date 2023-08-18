package com.servissistema.game.controllers;

import com.servissistema.game.dtos.GameDto;
import com.servissistema.game.dtos.GameMinDTO;
import com.servissistema.game.entities.Game;
import com.servissistema.game.services.GameService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
@RestController
@RequestMapping(value = "/games")
public class GameController {

    @Autowired
    private GameService gameService;




    @PostMapping
    public ResponseEntity<Game> save(@RequestBody Game game) {

        Game g = gameService.save(game);

        return  new ResponseEntity<Game>(g, HttpStatus.CREATED);
    }

    @GetMapping(value = "/{id}")
    public GameDto findById(@PathVariable Long id){

        return gameService.findById(id);

    }
    @GetMapping
    public List<GameMinDTO> findall(){

        return gameService.findall();

    }
    @PutMapping(value = "/{id}")
    public Game update(@PathVariable Long id ,@RequestBody Game game) {

        return  gameService.update(id,game);

    }
    @DeleteMapping
    public ResponseEntity<String> delete(@RequestParam Long id) {

        gameService.delete(id);

        return  new ResponseEntity<String>("Game deletado", HttpStatus.CREATED);
    }
}
