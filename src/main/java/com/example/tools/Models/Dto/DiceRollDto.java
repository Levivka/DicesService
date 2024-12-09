package com.example.tools.Models.Dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.ArrayList;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class DiceRollDto {
    private int edges;
    private ArrayList<Integer> modifiers;
}
