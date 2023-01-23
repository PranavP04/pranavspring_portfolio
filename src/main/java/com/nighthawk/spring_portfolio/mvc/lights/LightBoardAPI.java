package com.nighthawk.spring_portfolio.mvc.lights;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.JsonMappingException;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;

import java.util.*;

@RestController
@RequestMapping("/api/lights/")
public class LightBoardAPI {

    private LightBoard lightBoard;
    private JsonNode json;

    @GetMapping("/create/{rows}/{cols}")
    public ResponseEntity<JsonNode> createLightBoard(@PathVariable int rows, @PathVariable int cols) throws JsonMappingException, JsonProcessingException {
        lightBoard = new LightBoard(rows, cols);

        ObjectMapper mapper = new ObjectMapper(); 
        json = mapper.readTree(lightBoard.toString()); 

        return ResponseEntity.ok(json);
    }

    @PostMapping("/allOn")
    public ResponseEntity<JsonNode> allOn() throws JsonMappingException, JsonProcessingException {
        lightBoard.allOn();

        ObjectMapper mapper = new ObjectMapper(); 
        json = mapper.readTree(lightBoard.toString()); 

        return ResponseEntity.ok(json);
    }

    @PostMapping("/allOff")
    public ResponseEntity<JsonNode> allOff() throws JsonMappingException, JsonProcessingException {
        lightBoard.allOff();

        ObjectMapper mapper = new ObjectMapper(); 
        json = mapper.readTree(lightBoard.toString()); 

        return ResponseEntity.ok(json);
    }

    @PostMapping("/toggleLight/{row}/{col}")
    public ResponseEntity<JsonNode> getLight(@PathVariable int row, @PathVariable int col) throws JsonMappingException, JsonProcessingException {
        lightBoard.lightToggle(row, col);

        ObjectMapper mapper = new ObjectMapper(); 
        json = mapper.readTree(lightBoard.toString()); 

        return ResponseEntity.ok(json);
    }
    
}