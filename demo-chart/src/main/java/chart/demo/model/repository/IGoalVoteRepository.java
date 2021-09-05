package chart.demo.model.repository;

import chart.demo.model.entity.GoalBeatyfullVote;
import org.springframework.data.jpa.repository.JpaRepository;

public interface IGoalVoteRepository extends JpaRepository<GoalBeatyfullVote, Integer> {
}
