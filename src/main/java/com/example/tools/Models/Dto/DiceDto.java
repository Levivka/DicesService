package com.example.tools.Models.Dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.ArrayList;
import java.util.LinkedList;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class DiceDto {
    private int edges;
    private ArrayList<Integer> modifiers;
    private LinkedList<Integer> rollHistory;
    private long ownerId;
}
