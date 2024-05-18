package com.vuktales.springai.springopenai.controller;

import com.vuktales.springai.springopenai.service.MovieAIService;
import org.springframework.ai.chat.ChatClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.Map;


@RestController
@RequestMapping("/movies")
public class MovieController {

    private final MovieAIService movieAIService;

    MovieController(MovieAIService movieAIService) {
        this.movieAIService = movieAIService;
    }

    @GetMapping("/ai/chat")
    List<String> chat(@RequestParam String aboutMovie) {
        return movieAIService.getAboutMovie(aboutMovie);
    }
}
