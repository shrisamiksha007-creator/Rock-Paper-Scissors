package com.example.demo;

import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import java.util.Random;

@RestController
@CrossOrigin(origins = "*")
public class RockPaperScissors {

    Random rand = new Random();
    String[] choices = {"Rock", "Paper", "Scissors"};

    @GetMapping("/play")
    public String play(@RequestParam int user) {
        if (user < 0 || user > 2) {
            return "Invalid|Invalid choice!";
        }
        int comp = rand.nextInt(3);
        String result;
        if (user == comp) {
            result = "Draw!";
        } else if ((user==0&&comp==2)||(user==1&&comp==0)||(user==2&&comp==1)) {
            result = "You win!";
        } else {
            result = "Computer wins!";
        }
        return choices[comp] + "|" + result;
    }
}