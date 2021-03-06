package com.game.kriegsspiel.controller;

import com.game.kriegsspiel.play.GameManager;
import com.game.kriegsspiel.dto.GameInformation;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.Set;

@Controller
public class PlayController {
    private GameManager gameManager;

    public PlayController() {
        gameManager = new GameManager();
    }

    @GetMapping("addPlayer")
    @ResponseBody
    public GameInformation addPlayer(String name) {
        return gameManager.addPlayer(name);
    }

    @ResponseBody
    @GetMapping("startGame")
    public GameInformation startGame() {
        return gameManager.startGame();
    }

    @ResponseBody
    @GetMapping("getVision")
    public GameInformation getVision(String name) {
        return gameManager.getVision(name);
    }

    @ResponseBody
    @PostMapping("move")
    public GameInformation move(String name, int x1, int y1, int x2, int y2) {
        return gameManager.move(name, x1, y1, x2, y2);
    }

    @ResponseBody
    @GetMapping("getPlayers")
    public Set<String> getPlayers() {
        return gameManager.getPlayers();
    }

    @ResponseBody
    @GetMapping("whoIsTurn")
    public String whoIsTurn() {
        return gameManager.whoIsTurn();
    }
}
