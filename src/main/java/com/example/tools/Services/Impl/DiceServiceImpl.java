package com.example.tools.Services.Impl;

import com.example.tools.Models.Dice;
import com.example.tools.Models.Dto.DiceDto;
import com.example.tools.Models.Dto.DiceRollDto;
import com.example.tools.Repository.DiceRepository;
import com.example.tools.Services.DiceService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.Random;

@Slf4j
@Service
@RequiredArgsConstructor
public class DiceServiceImpl implements DiceService {
    private final DiceRepository diceRepository;

    public ResponseEntity<?> createDice(DiceDto diceDto) {
        if (diceDto != null) {
            Dice dice = new Dice();
            dice.setEdges(diceDto.getEdges());
            dice.setOwnerId(diceDto.getOwnerId());
            dice.setRollHistory(diceDto.getRollHistory());
            log.info("Dice: {} {} {}", dice.getEdges(), dice.getRollHistory(), dice.getOwnerId() );
            diceRepository.save(dice);
            return ResponseEntity.status(HttpStatus.CREATED).body(dice);
        }
        else {
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body("Dice is not valid");
        }
    }


    public ResponseEntity<?> rollDice(long id) {
        Dice dice = diceRepository.findById(id).isPresent() ? diceRepository.findById(id).get() : null;
        if (dice == null) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Dice not found");
        }
        Random random = new Random();
        int roll = random.nextInt(1, dice.getEdges());

        dice.getRollHistory().add(roll);
        diceRepository.save(dice);

        return ResponseEntity.ok(roll);
    }

    @Override
    public ResponseEntity<?> rollDiceWithMod(int[] modifiers, long id) {
        Dice dice = diceRepository.findById(id).isPresent() ? diceRepository.findById(id).get() : null;
        if (dice == null) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Dice not found");
        }
        log.info("Get a dice with {} edges", dice.getEdges());

        Random random = new Random();
        int roll = random.nextInt(1, dice.getEdges());
        log.info("Dice roll: {}", roll);

        for (int modifier : modifiers) {
            roll += modifier;
            log.info("Modifier is {}", modifier);
        }

        dice.getRollHistory().add(roll);
        diceRepository.save(dice);
        return ResponseEntity.ok(roll);
    }
}
