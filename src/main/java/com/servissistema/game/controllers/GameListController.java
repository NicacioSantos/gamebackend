package com.servissistema.game.controllers;

import com.servissistema.game.dtos.GameListDTO;
import com.servissistema.game.entities.GameList;
import com.servissistema.game.services.GameListService;
import com.servissistema.game.services.GameService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(value = "/category")
public class GameListController {

    @Autowired
    private GameListService gameListService;

    @Autowired
    private GameService gameService;

    @PostMapping
    public ResponseEntity<GameList> save(@RequestBody GameList gameList) {
        GameList gameList1 = gameListService.save(gameList);

        return new ResponseEntity<GameList>(gameList1, HttpStatus.CREATED);
    }

    @GetMapping
    public List<GameListDTO> findAll() {
        List<GameListDTO> result = gameListService.findall();
        return result;
    }

    @GetMapping(value = "/{listId}/games")
    public GameList findGames(@PathVariable Long listId) {
        GameList result = gameListService.findByList(listId);
        return result;
    }

    @GetMapping(value = "/{id}")
    public ResponseEntity<GameList> gameListById(@PathVariable Long id) {
        GameList result = gameListService.findByIdSemDTO(id);
        return new ResponseEntity<GameList>(result, HttpStatus.CREATED);
    }

    @PutMapping(value = "/{id}")
    public GameList update(@PathVariable Long id, @RequestBody GameList gameList) {

        return gameListService.update(id, gameList);

    }

    @DeleteMapping
    public ResponseEntity<String> delete(@RequestParam Long id) {

        gameListService.delete(id);
        return new ResponseEntity<String>("GameList deletado", HttpStatus.CREATED);

    }
}
