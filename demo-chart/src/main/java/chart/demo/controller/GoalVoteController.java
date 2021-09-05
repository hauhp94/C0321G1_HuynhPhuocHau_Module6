package chart.demo.controller;

import chart.demo.model.entity.GoalBeatyfullVote;
import chart.demo.model.service.IGoalVoteService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("vote")
@CrossOrigin(origins = "*", allowedHeaders = "*")
public class GoalVoteController {
    @Autowired
    private IGoalVoteService goalVoteService;

    @GetMapping
    public ResponseEntity<List<GoalBeatyfullVote>> findAllSaving() {
        List<GoalBeatyfullVote> voteList = goalVoteService.findAll();
        if (voteList.isEmpty()) {
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        }
        return new ResponseEntity<>(voteList, HttpStatus.OK);
    }
}
