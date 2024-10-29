package org.mock;

import org.mock.persistence.entity.Player;
import org.mock.persistence.entity.repository.PlayerRepositoryImpl;
import org.mock.persistence.entity.service.PlayerServiceImpl;

public class Main {
    public static void main(String[] args) {

        PlayerRepositoryImpl playerRepository = new PlayerRepositoryImpl(); //dependencia
        PlayerServiceImpl playerService = new PlayerServiceImpl(playerRepository); //depende del repositorio

        //System.out.println(playerService.findAll());
        //System.out.println(playerService.findById(2L));
        //playerService.deleteById(1l); System.out.println(playerService.findAll());
        //playerService.save(new Player(7L, "Luis Diaz", "Delantero", "Liverpool")); System.out.println(playerService.findAll());


    }
}