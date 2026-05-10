# Getting Started with Embabel: Simplifying AI for JVM Developers

For Java and Kotlin developers, integrating Large Language Models (LLMs) often involves managing complex prompts, handling asynchronous API calls, and parsing unpredictable text outputs. **Embabel** is a dedicated SDK designed to streamline this process, providing a clean abstraction layer for interacting with both remote models (like OpenAI) and local instances running on your infrastructure.

## Why Use Embabel?

Interfacing directly with AI models often leads to boilerplate-heavy code. Embabel abstracts the orchestration logic, error handling, and prompt engineering, allowing you to focus on application logic rather than the underlying LLM mechanics. It keeps your codebase clean, maintainable, and type-safe.

## Quick Start: Basic Inference

Executing a basic task is straightforward. Here is how you can perform a simple natural language query in Kotlin:

```kotlin
val embabel = Embabel.create()
val response = embabel.ask("What is the capital of France?")

println(response) // Output: Paris
```

By using the SDK, you decouple your business logic from specific API requirements, such as HTTP headers or provider-specific message formatting.

## Extracting Structured Data

One of Embabel's most powerful features is its ability to map unstructured text directly into JVM objects. This eliminates the need for manual regex or complex custom parsing logic.

First, define a data class for your schema:

```kotlin
data class Person(val name: String, val age: Int)
```

Then, instruct Embabel to extract the entity from the text:

```kotlin
val text = "John is 25 years old."
val person = embabel.asEntity<Person>(text)

println(person.name) // Output: John
```

## Key Benefits

1. **Type Safety:** Leverage Kotlin and Java's strong typing to ensure data integrity when receiving LLM responses.
2. **Model Agnostic:** Easily switch between different providers (e.g., OpenAI, Anthropic, or local models) without rewriting your core logic.
3. **Clean Architecture:** Maintain a strict separation of concerns by keeping AI prompt management separate from your UI and business layers.

## Conclusion

Embabel bridges the gap between sophisticated AI capabilities and the robust ecosystem of the JVM. By turning complex AI interactions into standard function calls, it enables developers to build intelligent applications faster and with greater confidence.

Give Embabel a try in your next project and start leveraging the power of LLMs within a familiar development workflow.