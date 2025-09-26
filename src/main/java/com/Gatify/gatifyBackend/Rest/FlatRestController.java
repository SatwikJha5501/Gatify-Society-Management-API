package com.Gatify.gatifyBackend.Rest;

import com.Gatify.gatifyBackend.Entity.Block;
import com.Gatify.gatifyBackend.Entity.Flat;
import com.Gatify.gatifyBackend.Entity.Society;
import com.Gatify.gatifyBackend.Service.BlockService;
import com.Gatify.gatifyBackend.Service.FlatService;
import com.Gatify.gatifyBackend.Service.SocietyService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/flats")
public class FlatRestController {

    private final FlatService flatService;
    private final BlockService blockService;
    private final SocietyService societyService;

    @Autowired
    public FlatRestController(FlatService flatService,
                              BlockService blockService,
                              SocietyService societyService) {
        this.flatService = flatService;
        this.blockService = blockService;
        this.societyService = societyService;
    }

    @GetMapping
    public List<Flat> findAll() {
        return flatService.findAll();
    }

    @GetMapping("/{flatId}")
    public Flat getFlat(@PathVariable int flatId) {
        Flat flat = flatService.findById(flatId);
        if (flat == null) {
            throw new RuntimeException("Flat id not found - " + flatId);
        }
        return flat;
    }

    @PostMapping
    public Flat addFlat(@RequestBody Flat flat) {
        flat.setFlatId(0);

        // Resolve Block association
        if(flat.getBlock() != null) {
            Block managedBlock = blockService.findById(flat.getBlock().getId());
            if(managedBlock == null) {
                throw new RuntimeException("Block not found with ID: " + flat.getBlock().getId());
            }
            flat.setBlock(managedBlock);
        }

        // Resolve Society association
        if(flat.getSociety() != null) {
            Society managedSociety = societyService.findById(flat.getSociety().getId());
            if(managedSociety == null) {
                throw new RuntimeException("Society not found with ID: " + flat.getSociety().getId());
            }
            flat.setSociety(managedSociety);
        }

        return flatService.save(flat);
    }

    @PutMapping
    public Flat updateFlat(@RequestBody Flat flat) {
        // Resolve associations same as POST
        if(flat.getBlock() != null) {
            Block managedBlock = blockService.findById(flat.getBlock().getId());
            flat.setBlock(managedBlock);
        }

        if(flat.getSociety() != null) {
            Society managedSociety = societyService.findById(flat.getSociety().getId());
            flat.setSociety(managedSociety);
        }

        return flatService.save(flat);
    }

    @DeleteMapping("/{flatId}")
    public String deleteFlat(@PathVariable int flatId) {
        Flat flat = flatService.findById(flatId);
        if (flat == null) {
            throw new RuntimeException("Flat id not found - " + flatId);
        }
        flatService.deleteById(flatId);
        return "Deleted flat id - " + flatId;
    }
}