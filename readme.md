# Playwright Screenplay Framework

Este projeto é um exemplo de automação de testes utilizando **Java**, **Playwright** e o modelo **Screenplay**. O objetivo é fornecer uma estrutura robusta, reutilizável e fácil de manter para testes de interface web.

## 🚀 Tecnologias Utilizadas
- **Java 17**
- **Playwright**
- **JUnit 5**
- **ExtentReports** para relatórios
- **Modelo Screenplay**

---

## 📋 Requisitos
Antes de começar, você precisa ter instalado:
- **Java 17**
- **Maven**
- **Node.js** (para o Playwright)
- Navegadores compatíveis com o Playwright

---

## 🔧 Instalação
1. Clone este repositório:
   ```bash
   git clone https://github.com/seu-usuario/seu-repositorio.git
   ```
2. Navegue até a pasta do projeto:
   ```bash
   cd seu-repositorio
   ```

3. Compile o projeto com Maven:
   ```bash
   mvn clean install
   ```
---
4. Execute o código com handless true e gere relatório

   ```bash
    mvn  clean compile
   ```

   ```bash
    mvn test
   ```
   
   ```bash
   open target/ExtentReport.html
   ```

   ```bash
   mvn test && open target/ExtentReport.html
   ```
   
`Execute com headless no modo true`

```bash
mvn test -DsetHeadless=true
```
```bash
mvn test -DsetHeadless=true && open target/ExtentReport.html

```


## 📂 Estrutura do Projeto
```
├── hooks
│   └── PlaywrightTestLifecycle.java   # Gerencia o ciclo de vida do Playwright
├── interactions
│   ├── Click.java                    # Task para clicar em um elemento
│   ├── Fill.java                     # Task para preencher um campo
│   └── NavigateTo.java               # Task para navegar até uma URL
├── listeners
│   └── ExtentReportListener.java     # Gera relatórios detalhados
├── pages
│   └── Login.java                    # Task para executar o login
├── screen
│   ├── Actor.java                    # Representa o ator no modelo Screenplay
│   ├── Task.java                     # Interface para definir Tasks
│   └── Question.java                 # Métodos para consulta de informações na página
├── utils
│   └── ConfigManager.java            # Gerencia as configurações do projeto
└── config.properties                  # Arquivo de configuração
```
---

## ▶️ Como Executar os Testes

1. Compile o projeto:
   ```bash
   mvn clean compile
   ```
2. Execute os testes:
   ```bash
   mvn test
   ```
3. Após a execução, o relatório estará disponível em `target/ExtentReport.html`.
---

## 📊 Relatórios
Este projeto utiliza **ExtentReports** para gerar relatórios detalhados.
- O relatório será gerado automaticamente após a execução dos testes.
- Você pode encontrá-lo em: `target/ExtentReport.html`
- Exemplo de relatório:
  ![Exemplo de Relatório](https://i.imgur.com/example.png)
---

## 🛠 Configuração
O arquivo `config.properties` contém as configurações principais:
```properties
baseUrl=https://jamesonbatista.github.io/projectqatesterweb/index.html
setHeadless=true
```
### Alterando Configurações
- **baseUrl**: URL base da aplicação a ser testada.
- **setHeadless**: Define se o navegador será executado em modo headless (`true` ou `false`).

---

## 💡 Exemplos de Uso
### Exemplo de Login:
```java
Actor test = new Actor(page);
test.attemptsTo(
        NavigateTo.theUrl("https://example.com/login"),
    Login.withDefaultCredentials()
);
```
### Verificação de Texto:
```java
String message = Question.text(test, "#message");
System.out.println("Mensagem exibida: " + message);
```
---

## 🔄 Personalização
Você pode adicionar novas Tasks e Questions seguindo o padrão existente:
- **Task**: Implementa a interface `Task` e define a ação a ser realizada.
- **Question**: Fornece consultas específicas sobre o estado da página.

---

## 📝 Contribuindo
Contribuições são sempre bem-vindas! Sinta-se à vontade para abrir issues e enviar pull requests.

---

## 📄 Licença
Este projeto está sob a licença MIT. Consulte o arquivo LICENSE para mais informações.

---
