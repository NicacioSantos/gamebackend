package com.servissistema.game.services;

import com.servissistema.game.dtos.GameDto;
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
    public List<GameMinDTO> findall() {

        List<Game> games = gameRepository.findAll();
        List<GameMinDTO> gameMinDTO = games.stream().map(x -> new GameMinDTO(x)).toList();
        return gameMinDTO;
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


    public Game save(Game game) {


        return   gameRepository.save(game);
    }

    public Game update( Long id ,Game game) {

        Game game1 = gameRepository.findById(id).get();
        BeanUtils.copyProperties(game,game1, "id");
        return  gameRepository.save(game1);
    }

    public void delete(Long id) {
        gameRepository.deleteById(id);

    }
}
