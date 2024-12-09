package com.example.tools.Models;

import jakarta.persistence.*;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.JdbcTypeCode;
import org.hibernate.type.SqlTypes;

import java.util.LinkedList;
import java.util.List;

@Entity
@Data
@NoArgsConstructor
@Table(name = "dices")
public class Dice {
    @Id
    @Column(name = "id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    @Column(name = "edges")
    private int edges;

    @Column(name = "roll_history")
    @JdbcTypeCode(SqlTypes.ARRAY)
    private List<Integer> rollHistory;

    @Column(name = "owner_id")
    private long ownerId;
}
