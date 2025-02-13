# 🚀 Automação de Testes Web com Java, Playwright e Screenplay Pattern

Recentemente, desenvolvi um projeto de **automação de testes web** utilizando **Java**, **Playwright** e a abordagem **Screenplay Pattern**. O objetivo principal foi construir uma estrutura escalável, reutilizável e fácil de manter para quem trabalha com automação web.

---

## 🎯 Desafios e Soluções
- Adotei o **padrão Screenplay**, organizando o projeto em **atores, tarefas e interações**, o que trouxe mais clareza e extensibilidade ao código.
- Utilizei **Playwright para Java**, garantindo testes rápidos e precisos em múltiplos navegadores.
- Centralizei as configurações no arquivo **`config.properties`**, facilitando a parametrização de URLs, timeouts e modos de execução (headless ou não).

---

## 📂 Estrutura do Projeto
- **`hooks`**: Gerenciamento do ciclo de vida do Playwright.
- **`actors`**: Definição dos atores que realizam ações nos testes.
- **`tasks`**: Ações maiores, como navegar para uma URL específica.
- **`interactions`**: Ações específicas, como clicar em botões e preencher campos.
- **`questions`**: Perguntas para validar informações, como o título da página.

---

## 🛠️ Exemplo de Código com Screenplay
```java
Actor testActor = new Actor();

// Preencher um campo de texto
testActor.attemptsTo(Fill.field("#name", "Jameson"));

// Clicar em um botão
testActor.attemptsTo(Click.on("#submit"));
```

---

## ✨ Benefícios do Projeto
- Código mais legível e próximo da linguagem natural.
- Redução significativa de código repetido.
- Organização modular e escalável, pronta para crescer junto com as necessidades do projeto.

---

## 🔗 Referências
- [Playwright para Java](https://playwright.dev/java/docs/intro)
- [JUnit 5](https://junit.org/junit5/docs/current/user-guide/)
- [Screenplay Pattern](https://serenity-bdd.github.io/theserenitybook/latest/screenplay-tutorial.html)

---

Se quiser mais detalhes, confira o repositório completo no GitHub! 😊

