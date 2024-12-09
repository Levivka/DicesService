package com.example.tools.Controllers;

import com.example.tools.Models.Dto.DiceDto;
import com.example.tools.Models.Dto.DiceRollDto;
import com.example.tools.Services.DiceService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/dices")
@RequiredArgsConstructor
@Slf4j
public class DiceController {
    private final DiceService diceService;

    @PostMapping()
    public ResponseEntity<?> createDice(@RequestBody DiceDto diceDto) {
        return diceService.createDice(diceDto);
    }

    @GetMapping("/{id}/rolls")
    public ResponseEntity<?> ClearRoll(@PathVariable long id) {
        return diceService.rollDice(id);
    }

    @PostMapping("/{id}/rolls")
    public ResponseEntity<?> ModifiersRoll(@RequestBody int[] modifiers, @PathVariable long id) {
        return diceService.rollDiceWithMod(modifiers, id);
    }
}
