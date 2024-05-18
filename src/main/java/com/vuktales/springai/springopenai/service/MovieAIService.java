package com.vuktales.springai.springopenai.service;

import org.springframework.ai.chat.ChatClient;
import org.springframework.ai.chat.ChatResponse;
import org.springframework.ai.chat.messages.SystemMessage;
import org.springframework.ai.chat.prompt.Prompt;
import org.springframework.ai.chat.prompt.PromptTemplate;
import org.springframework.ai.parser.ListOutputParser;
import org.springframework.core.convert.support.DefaultConversionService;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;

record MovieResponse( List<String> movies) {}

@Service
public class MovieAIService {
    private final ChatClient chatClient;

    MovieAIService(ChatClient chatClient) {
        this.chatClient = chatClient;
    }

    public List<String> getAboutMovie(String subject) {
        SystemMessage systemMessage = new SystemMessage("a useful chat bot from open ai");
        var outputParser = new ListOutputParser(new DefaultConversionService());

        PromptTemplate promptTemplate = new PromptTemplate("Tell me about movie {subject}");
        Prompt prompt = promptTemplate.create(Map.of("subject", subject));
        ChatResponse response = chatClient.call(prompt);
        return outputParser.parse(response.getResult().getOutput().getContent());
    }
}
