package com.controller;

import com.model.entity.BusRoute;
import com.model.entity.TicketMonth;
import com.model.service.BusRouteService;
import com.model.service.TicketMonthService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.sql.SQLException;
import java.util.List;

@RestController
@RequestMapping("api/ticket")
@CrossOrigin(origins = "*", allowedHeaders = "*")
public class TicketMonthRestController {
    @Autowired
    private TicketMonthService ticketMonthService;

    @GetMapping
    public ResponseEntity<List<TicketMonth>> findAll() {
        List<TicketMonth> ticketMonthList = ticketMonthService.findAll();
        if (ticketMonthList.isEmpty()) {
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        }
        return new ResponseEntity<>(ticketMonthList, HttpStatus.OK);
    }

    @GetMapping("{id}")
    public ResponseEntity<TicketMonth> findById(@PathVariable Integer id) {
        TicketMonth ticketMonth = ticketMonthService.findById(id);
        if (ticketMonth == null) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
        return new ResponseEntity<>(ticketMonth, HttpStatus.OK);
    }
    @PostMapping()
    public ResponseEntity<TicketMonth> save(@RequestBody TicketMonth ticketMonth) throws Exception {
        ticketMonthService.save(ticketMonth);
        return new ResponseEntity(HttpStatus.CREATED);
    }
    @DeleteMapping("/{id}")
    public ResponseEntity delete(@PathVariable Integer id) throws SQLException {
        TicketMonth ticketMonth = ticketMonthService.findById(id);
        if(ticketMonth==null){
            return new ResponseEntity(HttpStatus.NOT_FOUND);
        }

        ticketMonthService.remove(id);
        return new ResponseEntity(HttpStatus.OK);
    }

    @PutMapping("/{id}")
    public ResponseEntity updateBlog(@PathVariable Integer id,@RequestBody TicketMonth ticketMonth) throws Exception {
        TicketMonth currentTicketMonth = ticketMonthService.findById(id);
        if(currentTicketMonth==null){
            return new ResponseEntity(HttpStatus.NOT_FOUND);
        }

        ticketMonthService.save(ticketMonth);
        return new ResponseEntity(HttpStatus.OK);
    }
}
