package chart.demo.model.service;

import chart.demo.model.entity.GoalBeatyfullVote;
import chart.demo.model.repository.IGoalVoteRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public class GoalVoteServiceImpl implements IGoalVoteService {
    @Autowired
    private IGoalVoteRepository goalVoteRepository;

    @Override
    public List<GoalBeatyfullVote> findAll() {
        return goalVoteRepository.findAll();
    }
}
