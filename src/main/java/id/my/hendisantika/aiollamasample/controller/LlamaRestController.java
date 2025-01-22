package id.my.hendisantika.aiollamasample.controller;

import id.my.hendisantika.aiollamasample.model.LlamaResponse;
import id.my.hendisantika.aiollamasample.service.LlamaAiService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

/**
 * Created by IntelliJ IDEA.
 * Project : ai-ollama-sample
 * User: hendisantika
 * Email: hendisantika@gmail.com
 * Telegram : @hendisantika34
 * Date: 22/01/25
 * Time: 09.15
 * To change this template use File | Settings | File Templates.
 */
@RestController
@RequiredArgsConstructor
public class LlamaRestController {

    private final LlamaAiService llamaAiService;

    @GetMapping("api/v1/ai/generate")
    public ResponseEntity<LlamaResponse> generate(
            @RequestParam(value = "prompt", defaultValue = "Why is the sky blue?")
            String prompt) {
        final LlamaResponse aiResponse = llamaAiService.generateMessage(prompt);
        return ResponseEntity.status(HttpStatus.OK).body(aiResponse);
    }
}
