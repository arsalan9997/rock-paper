package com.devops.game;

import java.util.Map;
import java.util.concurrent.ThreadLocalRandom;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api")
public class GameController {
    private static final String[] MOVES = {"rock", "paper", "scissors"};

    @GetMapping("/play")
    public Map<String, String> play(@RequestParam String move) {
        String player = move.toLowerCase();
        if (!java.util.Arrays.asList(MOVES).contains(player)) {
            throw new IllegalArgumentException("Move must be rock, paper, or scissors");
        }
        String computer = MOVES[ThreadLocalRandom.current().nextInt(MOVES.length)];
        String result = player.equals(computer) ? "DRAW" :
            (player.equals("rock") && computer.equals("scissors")) ||
            (player.equals("paper") && computer.equals("rock")) ||
            (player.equals("scissors") && computer.equals("paper")) ? "YOU WIN" : "COMPUTER WINS";
        return Map.of("player", player, "computer", computer, "result", result);
    }
}
