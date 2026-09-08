package com.devops.game;
import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.Test;
class GameControllerTest {
 @Test void validGameWorks() {
   var result = new GameController().play("rock");
   assertTrue(result.containsKey("computer"));
   assertTrue(result.containsKey("result"));
 }
 @Test void invalidMoveFails() {
   assertThrows(IllegalArgumentException.class, () -> new GameController().play("invalid"));
 }
}
