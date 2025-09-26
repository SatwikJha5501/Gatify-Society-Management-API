package com.Gatify.gatifyBackend.Entity;

import jakarta.persistence.*;

@Entity
@Table(name="flat")
public class Flat {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name="flat_id")
    private int flatId;

    @Column(name="flat_number", length=3)
    private String flatNumber;

    @Column(name="type")
    private String type;

    @Column(name="carpet_area")
    private double carpetArea;

    @Column(name="block_area")
    private double blockArea;

    @ManyToOne
    @JoinColumn(name="block_id")
    private Block block;

    @ManyToOne
    @JoinColumn(name="society_id")
    private Society society;

    // Constructors
    public Flat() {}

    public Flat(String flatNumber, String type, double carpetArea, double blockArea) {
        this.flatNumber = flatNumber;
        this.type = type;
        this.carpetArea = carpetArea;
        this.blockArea = blockArea;
    }

    // Getters/Setters
    public int getFlatId() { return flatId; }
    public void setFlatId(int flatId) { this.flatId = flatId; }
    public String getFlatNumber() { return flatNumber; }
    public void setFlatNumber(String flatNumber) { this.flatNumber = flatNumber; }
    public String getType() { return type; }
    public void setType(String type) { this.type = type; }
    public double getCarpetArea() { return carpetArea; }
    public void setCarpetArea(double carpetArea) { this.carpetArea = carpetArea; }
    public double getBlockArea() { return blockArea; }
    public void setBlockArea(double blockArea) { this.blockArea = blockArea; }
    public Block getBlock() { return block; }
    public void setBlock(Block block) { this.block = block; }
    public Society getSociety() { return society; }
    public void setSociety(Society society) { this.society = society; }
}