package id.my.hendisantika.aiollamasample.service;

import id.my.hendisantika.aiollamasample.model.LlamaResponse;
import lombok.RequiredArgsConstructor;
import org.springframework.ai.ollama.OllamaChatModel;
import org.springframework.stereotype.Service;

/**
 * Created by IntelliJ IDEA.
 * Project : ai-ollama-sample
 * User: hendisantika
 * Email: hendisantika@gmail.com
 * Telegram : @hendisantika34
 * Date: 22/01/25
 * Time: 09.14
 * To change this template use File | Settings | File Templates.
 */
@Service
@RequiredArgsConstructor
public class LlamaAiService {
    private final OllamaChatModel ollamaChatModel;

    public LlamaResponse generateMessage(String promptMessage) {
        final String llamaMessage = ollamaChatModel.call(promptMessage);
        return new LlamaResponse().setMessage(llamaMessage);
    }

}
