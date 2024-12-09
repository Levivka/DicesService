package com.example.tools.Repository;

import com.example.tools.Models.Dice;
import org.springframework.data.repository.CrudRepository;

import java.util.Optional;

public interface DiceRepository extends CrudRepository<Dice, Long> {
    Optional<Dice> findById(Long aLong);
}
