# spring-boot-ai-ollama-sample

[![Java CI with Gradle](https://github.com/hendisantika/spring-boot-ai-ollama-sample/actions/workflows/gradle.yml/badge.svg)](https://github.com/hendisantika/spring-boot-ai-ollama-sample/actions/workflows/gradle.yml)

A simple Spring Boot REST API that generates text with a local LLM through [Spring AI](https://spring.io/projects/spring-ai)
and [Ollama](https://ollama.com/).

### Tech Stack

- Java 25 (Gradle toolchain)
- Spring Boot 4.1.1
- Spring AI 2.0.1 (`spring-ai-starter-model-ollama`)
- Gradle 9.8.1 (wrapper)
- Ollama (via Docker Compose) running the `llama3.2:3b` model
- Lombok

### Prerequisites

- JDK 25
- Docker (to run Ollama through `compose.yml`) or a locally installed Ollama

### How to Run

1. Clone the repository

   ```shell
   git clone https://github.com/hendisantika/spring-boot-ai-ollama-sample.git
   cd spring-boot-ai-ollama-sample
   ```

2. Run the application. Spring Boot Docker Compose support starts the Ollama container from `compose.yml` automatically.

   ```shell
   ./gradlew bootRun
   ```

3. Pull the model into Ollama (first run only)

   ```shell
   docker exec -it ollama ollama pull llama3.2:3b
   ```

4. Call the endpoints below.

The Ollama base URL and model can be changed in `src/main/resources/application.yml`.

### Build & Test

```shell
./gradlew build
```

### AI Concepts

Spring recommends reading about [AI Concepts](https://docs.spring.io/spring-ai/reference/concepts.html) closely to
understand the ideas behind how Spring AI is implemented.

### What is Spring AI Project?

The Spring AI project aims to streamline the development of applications that incorporate artificial intelligence
functionality without unnecessary complexity.

The project draws inspiration from notable Python projects, such as LangChain and LlamaIndex, but Spring AI is not a
direct port of those projects. The project was founded with the belief that the next wave of Generative AI applications
will not be only for Python developers but will be ubiquitous across many programming languages.

At its core, Spring AI provides abstractions that serve as the foundation for developing AI applications. These
abstractions have multiple implementations, enabling easy component swapping with minimal code changes. For example,
Spring AI introduces the ChatClient interface with implementations for OpenAI and Azure OpenAI.

In addition to these core abstractions, Spring AI aims to provide higher-level functionalities to address common use
cases such as “Q&A over your documentation” or “Chat with your documentation.” As the complexity of the use cases
increases, the Spring AI project will integrate with other projects in the Spring Ecosystem, such as Spring Integration,
Spring Batch, and Spring Data.

### What is Ollama?

[Ollama](https://ollama.com/) is a streamlined tool for running
open-source [LLMs](https://klu.ai/glossary/large-language-model) locally, including Mistral and Llama 2. Ollama bundles
model weights, configurations, and datasets into a unified package managed by a Modelfile. Ollama supports a variety of
LLMs including LLaMA-2, uncensored LLaMA, CodeLLaMA, Falcon, Mistral, Vicuna model, WizardCoder, and Wizard uncensored.
Ollama supports a variety of models, including Llama 2, Code Llama, and others, and it bundles model weights,
configuration, and data into a single package, defined by a Modelfile.

### What is Llama 2?

[Llama2](https://www.llama.com/#inside-the-model) is Meta’s open source large language model (LLM). It’s basically the
Facebook parent company’s response to OpenAI’s GPT models and Google’s AI models like PaLM 2 — but with one key
difference: it’s freely available for almost anyone to use for research and commercial purposes.

### API Endpoints

| Method | Endpoint                             | Description                                     |
|--------|--------------------------------------|-------------------------------------------------|
| GET    | `/api/v1/ai/generate?prompt={text}`  | Generate a response for the given prompt        |
| GET    | `/api/v1/ai/generate/joke/{topic}`   | Generate a joke about the given topic           |

REQUEST -->

```shell
curl --location 'http://localhost:8080/api/v1/ai/generate?prompt=create%20a%20catchy%20headline%20for%20%22motivation%22'
```

RESPONSE <--

```json
{
  "message": "Unleash Your Inner Rockstar: Find Your Motivation Today!\n\nThis headline uses a playful and attention-grabbing approach to motivate readers to take action and find their inner drive. The use of the phrase 'inner rockstar' suggests that everyone has the potential to be a star in their own life, and that finding motivation is the key to unlocking that potential. The word 'today' adds a sense of urgency and encourages readers to take action immediately. Overall, this headline is designed to inspire and energize readers to start their journey towards success."
}
```

REQUEST -->

```shell
curl --location 'http://localhost:8080/api/v1/ai/generate/joke/teacher'
```

RESPONSE <--

```json
{
  "message": "Why did the teacher wear sunglasses in class?\n\nBecause her students were so bright! (get it?)"
}
```

REQUEST -->

```shell
curl --location 'http://localhost:8080/api/v1/ai/generate?prompt=Spring%20Boot'
```

RESPONSE <--

```json
{
  "message": "**Spring Boot Overview**\n\nSpring Boot is a popular Java framework for building web applications and microservices. It provides an opinionated set of defaults to simplify the process of creating new Spring-based projects.\n\n**Key Features**\n\n1. **Auto-Configuration**: Spring Boot automatically configures the application based on the dependencies in the `pom.xml` file or `build.gradle` file.\n2. **Embedded Server**: Spring Boot comes with an embedded server, such as Tomcat or Jetty, which simplifies the process of running a web application.\n3. **Simplified Dependencies**: Spring Boot reduces the number of dependencies required to create a new project by providing a set of default dependencies.\n4. **Production Readiness**: Spring Boot includes features that make it easier to deploy applications to production environments.\n\n**Spring Boot Architecture**\n\n1. **Boot Runner**: The `boot.run` class is responsible for running the application.\n2. **Application Context**: The `ApplicationContext` is created by the Boot Runner and provides a central location for dependencies.\n3. **Configurations**: Spring Boot automatically configures the application based on the dependencies in the `pom.xml` file or `build.gradle` file.\n\n**Spring Boot Best Practices**\n\n1. **Keep it Simple**: Avoid overcomplicating your configuration files.\n2. **Use Defaults**: Use the default configurations provided by Spring Boot whenever possible.\n3. **Use Dependency Injection**: Use dependency injection to manage dependencies between components.\n4. **Test Thoroughly**: Write comprehensive unit tests and integration tests.\n\n**Common Spring Boot Applications**\n\n1. **Web Applications**: Using Spring MVC or Spring WebFlux for building web applications.\n2. **Microservices**: Using Spring Cloud for building microservices-based architectures.\n3. **RESTful APIs**: Using Spring Boot to build RESTful APIs.\n\n**Spring Boot Tools and Extensions**\n\n1. **IntelliJ IDEA**: Provides excellent support for Spring Boot development, including code completion and debugging tools.\n2. **Eclipse**: Also provides good support for Spring Boot development.\n3. **Docker**: Can be used to containerize Spring Boot applications for easy deployment.\n\n**Common Challenges in Spring Boot Development**\n\n1. **Configuration Overload**: Managing the large number of configuration options provided by Spring Boot can be overwhelming.\n2. **Performance Issues**: Optimizing performance in a Spring Boot application can be challenging due to the complexity of the framework.\n3. **Security Risks**: Mitigating security risks, such as SQL injection and cross-site scripting (XSS), is essential when building web applications with Spring Boot.\n\n**Best Resources for Learning Spring Boot**\n\n1. **Official Spring Documentation**: Provides comprehensive documentation on Spring Boot, including tutorials and guides.\n2. **Udemy Courses**: Offers a wide range of courses on Spring Boot development.\n3. **Spring Boot Blog**: A great resource for staying up-to-date with the latest trends and best practices in Spring Boot development.\n\nI hope this information helps! Do you have any specific questions about Spring Boot or would you like me to elaborate on any of these points?"
}
```
