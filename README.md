# Análise Forense Avançada de Logs (Trabalho Final AED)

Este projeto contém a solução para o trabalho final de Análise de Estruturas de Dados (AED), implementado em Java e gerenciado com Maven. O código foi otimizado para processar grandes volumes de logs usando uma abordagem de *streaming* para o Desafio 1, prevenindo problemas de memória.

## 🚀 Como Executar o Projeto

Para compilar e executar o projeto, você precisará ter o **Java Development Kit (JDK)** e o **Apache Maven** instalados.

### Pré-requisitos

*   **Java JDK 21** ou superior
*   **Apache Maven**

### 1. Compilação e Execução (Recomendado: Script)

O projeto inclui um script `run.sh` que automatiza todo o processo de compilação e execução do teste principal (`TesteExecucao.java`).

1.  **Navegue** até o diretório raiz do projeto no terminal.
2.  **Execute o script:**
    ```bash
    ./run.sh
    ```

### 2. Execução Manual (Windows/Terminal)

Se você estiver no Windows e não puder usar o script `.sh`, siga estes passos:

1.  **Compilar o Projeto com Maven:**
    ```bash
    mvn clean install
    ```
    Isso irá gerar o arquivo JAR da sua solução em `target/trabalho-final-aed-1.0-SNAPSHOT.jar`.

2.  **Compilar a Classe de Teste:**
    ```bash
    # Use ponto e vírgula (;) como separador de classpath no Windows
    javac -cp target\trabalho-final-aed-1.0-SNAPSHOT.jar;. TesteExecucao.java
    ```

3.  **Executar a Classe de Teste:**
    ```bash
    # Use ponto e vírgula (;) como separador de classpath no Windows
    java -cp target\trabalho-final-aed-1.0-SNAPSHOT.jar;. TesteExecucao
    ```

## 📂 Estrutura do Projeto

O projeto segue a estrutura padrão do Maven:

