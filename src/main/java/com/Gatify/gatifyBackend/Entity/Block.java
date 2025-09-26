package com.Gatify.gatifyBackend.Entity;

import com.fasterxml.jackson.annotation.JsonAlias;
import jakarta.persistence.*;

@Entity
@Table(name = "block")
public class Block {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @JsonAlias({"blockId", "id"})
    private int id;

    @Column(name = "block_name")
    private String blockName;

    @ManyToOne
    @JoinColumn(name = "society_id")
    private Society society;

    public Block() {
    }

    public Block(String blockName, Society society) {
        this.blockName = blockName;
        this.society = society;
    }

    // Getters and Setters
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getBlockName() {
        return blockName;
    }

    public void setBlockName(String blockName) {
        this.blockName = blockName;
    }

    public Society getSociety() {
        return society;
    }

    public void setSociety(Society society) {
        this.society = society;
    }
}