package com.Gatify.gatifyBackend.Rest;

import com.Gatify.gatifyBackend.Entity.Block;
import com.Gatify.gatifyBackend.Service.BlockService;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.node.ObjectNode;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/api/blocks")
public class BlockRestController {
    private final BlockService blockService;
    private final ObjectMapper objectMapper;

    @Autowired
    public BlockRestController(BlockService blockService, ObjectMapper objectMapper) {
        this.blockService = blockService;
        this.objectMapper = objectMapper;
    }

    @GetMapping
    public List<Block> findAll() {
        return blockService.findAll();
    }

    @GetMapping("/{blockId}")
    public Block getBlock(@PathVariable int blockId) {
        Block block = blockService.findById(blockId);
        if (block == null) {
            throw new RuntimeException("Block id not found - " + blockId);
        }
        return block;
    }

    @PostMapping
    public Block addBlock(@RequestBody Block block) {
        block.setId(0);
        return blockService.save(block);
    }

    @PutMapping
    public Block updateBlock(@RequestBody Block block) {
        return blockService.save(block);
    }

    @PatchMapping("/{blockId}")
    public Block patchBlock(@PathVariable int blockId, @RequestBody Map<String, Object> patchPayload) {
        Block tempBlock = blockService.findById(blockId);
        if (tempBlock == null) {
            throw new RuntimeException("Block id not found - " + blockId);
        }
        if (patchPayload.containsKey("id")) {
            throw new RuntimeException("Block id not allowed in request body - " + blockId);
        }
        Block patchedBlock = apply(patchPayload, tempBlock);
        return blockService.save(patchedBlock);
    }

    @DeleteMapping("/{blockId}")
    public String deleteBlock(@PathVariable int blockId) {
        Block tempBlock = blockService.findById(blockId);
        if (tempBlock == null) {
            throw new RuntimeException("Block id not found - " + blockId);
        }
        blockService.deleteById(blockId);
        return "Deleted block id - " + blockId;
    }

    private Block apply(Map<String, Object> patchPayload, Block tempBlock) {
        ObjectNode blockNode = objectMapper.convertValue(tempBlock, ObjectNode.class);
        ObjectNode patchNode = objectMapper.convertValue(patchPayload, ObjectNode.class);
        blockNode.setAll(patchNode);
        return objectMapper.convertValue(blockNode, Block.class);
    }
}