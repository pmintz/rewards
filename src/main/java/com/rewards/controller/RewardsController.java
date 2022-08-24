package com.rewards.controller;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.rewards.model.Transaction;
import com.rewards.service.RewardService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@CrossOrigin(origins="http://localhost:3000")
@RestController
@RequestMapping("rewards")
public class RewardsController {

    RewardService rewardService;

    public RewardsController(RewardService rewardService){
        this.rewardService = rewardService;
    }

    @GetMapping("/points")
    public List<Transaction> getTransactions() {
        return rewardService.findAll();
    }

    @GetMapping("/calculate")
    public int calculatePoints(@RequestParam(value = "points") int amt) {

        return rewardService.calculate(amt);

    }

    @PostMapping("/add")
    public void saveTransaction(@RequestBody Transaction transaction) {

        rewardService.save(transaction);

    }

    @DeleteMapping("/delete/{id}")
    public void deleteClient(@PathVariable Long id) {
        rewardService.deleteById(id);
    }

}
