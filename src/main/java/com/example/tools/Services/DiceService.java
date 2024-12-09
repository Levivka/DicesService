package com.example.tools.Services;

import com.example.tools.Models.Dto.DiceDto;
import com.example.tools.Models.Dto.DiceRollDto;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

@Service
public interface DiceService {
    ResponseEntity<?> createDice(DiceDto diceDto);
    ResponseEntity<?> rollDice(long id);
    ResponseEntity<?> rollDiceWithMod(int[] modifiers, long id);
}
