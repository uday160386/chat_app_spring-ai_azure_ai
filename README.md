## Developed a ChatBot using Spring AI and Open API

### BuzzWords..
```agsl
        - Prompt Enigneering
        - ChatBot
        - Open AI
```

### Pre-requisites:
- Export Open API key 
  - export OPENAI_API_KEY=<KEY>
### How to run?
    mvn clean install spring-boot:run

### How to test chatBot?
     curl --location 'http://localhost:9190/movies/ai/chat?aboutMovie=lordofthering'
