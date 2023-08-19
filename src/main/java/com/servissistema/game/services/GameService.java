package com.servissistema.game.services;

import com.servissistema.game.dtos.GameDto;
import com.servissistema.game.dtos.GameDtoId;
import com.servissistema.game.dtos.GameListDTO;
import com.servissistema.game.dtos.GameMinDTO;
import com.servissistema.game.entities.Game;
import com.servissistema.game.projections.GameMinProjection;
import com.servissistema.game.repositories.GameRepository;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
public class GameService {


    @Autowired
    private GameRepository gameRepository;


    @Transactional(readOnly = true)
    public List<GameDtoId> findallGame() {

        List<Game> gamesList = gameRepository.findAll();
        List<GameDtoId> gameDtoIds = gamesList.stream().map(x -> new GameDtoId(x)).toList();

        return gameDtoIds;
    }

    @Transactional(readOnly = true)
    public GameDto findById(Long id) {

        Game game = gameRepository.findById(id).get();
        return new GameDto(game);


    }

    @Transactional(readOnly = true)
    public List<GameMinDTO> findByList(Long listId) {

        List<GameMinProjection> result = gameRepository.searchByList(listId);

        List<GameMinDTO> list = result.stream().map(x -> new GameMinDTO(x)).toList();
        return list;


    }


    public GameDto save(GameDto gameDto) {

        Game game = new Game(gameDto);
        gameRepository.save(game);
        return new GameDto(game);
    }

    public GameDto update(Long id, GameDto gameDto) {

        Game game1 = gameRepository.findById(id).get();

        BeanUtils.copyProperties(new Game(gameDto), game1, "id");
        Game game = gameRepository.save(game1);

        return new GameDto(game);
    }

    public void delete(Long id) {
        gameRepository.deleteById(id);

    }
}
