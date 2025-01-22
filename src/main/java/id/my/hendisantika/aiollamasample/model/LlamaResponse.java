package id.my.hendisantika.aiollamasample.model;

import lombok.Data;
import lombok.experimental.Accessors;

/**
 * Created by IntelliJ IDEA.
 * Project : ai-ollama-sample
 * User: hendisantika
 * Email: hendisantika@gmail.com
 * Telegram : @hendisantika34
 * Date: 22/01/25
 * Time: 09.13
 * To change this template use File | Settings | File Templates.
 */
@Data
@Accessors(chain = true)
public class LlamaResponse {
    private String message;
}
