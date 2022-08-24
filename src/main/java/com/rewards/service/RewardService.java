package com.rewards.service;

import com.rewards.model.Transaction;
import com.rewards.repository.RewardsRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class RewardService {

    RewardsRepository rewardsRepository;

    public RewardService(RewardsRepository rewardsRepository){
        this.rewardsRepository = rewardsRepository;
    }

    public int calculate(int amt){
        int points = 0;
        if(amt>=100) {
            points = (amt - 100) * 2;
            points += 50;
        }else if(amt>50 && amt<100){
            points += (amt-50);
        }
        return points;
    }

    public void save(Transaction transaction){
        transaction.setAmountOfRewards(calculate(transaction.getAmountOfTransaction()));
        rewardsRepository.save(transaction);

    }

    public List<Transaction> findAll(){
        List<Transaction> list = (List<Transaction>) rewardsRepository.findAll();
        return list;
    }

    public void deleteById(Long id){
        rewardsRepository.deleteById(id);
    }


}
