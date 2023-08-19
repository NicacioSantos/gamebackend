package com.servissistema.game.services;

import com.servissistema.game.dtos.GameListDTO;
import com.servissistema.game.entities.GameList;
import com.servissistema.game.repositories.GameListRepository;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
public class GameListService {

    @Autowired
    private GameListRepository gameListRepository;


    public GameList save(GameList gameList) {

        return gameListRepository.save(gameList);

    }

    @Transactional(readOnly = true)
    public List<GameListDTO> findall() {

        List<GameList> gameLists = gameListRepository.findAll();
        return gameLists.stream().map(x -> new GameListDTO(x)).toList();

    }

    public GameList findByList(Long listId) {

        GameList gameList = gameListRepository.findById(listId).get();
        return gameList;
    }

    public GameList findByIdSemDTO(Long id) {

        GameList gameList = gameListRepository.findById(id).get();
        return gameList;

    }


    @Transactional(readOnly = true)
    public GameListDTO findById(Long id) {

        GameList gameList = gameListRepository.findById(id).get();
        return new GameListDTO(gameList);


    }

    public GameList update(Long id, GameList gameList) {

        GameList gameList1 = gameListRepository.findById(id).get();
        BeanUtils.copyProperties(gameList, gameList1, "id");
        return gameListRepository.save(gameList1);
    }

    public void delete(Long id) {

        gameListRepository.deleteById(id);
    }
}
