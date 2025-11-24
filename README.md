# Análise Forense Avançada de Logs (Trabalho Final AED)

**Aluno:** João Ricardo de Brito Melo Santos
**Turma:** Engenharia de Software Allen - Tarde

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

├── pom.xml
├── arquivo_logs.csv        # Arquivo de logs para análise
├── run.sh                  # Script de execução automatizada
└── src/
└── main/
└── java/
└── br/edu/icev/aed/forense/
├── Alerta.java
├── AnaliseForenseAvancada.java
├── LogEntry.java
├── LogParser.java          # Contém a otimização de streaming
├── SolucaoForense.java     # Implementação dos 5 desafios
└── TesteExecucao.java      # Classe principal para teste

## 💡 Otimização de Memória (Streaming)

Para lidar com arquivos de logs muito grandes (milhões de linhas), o `LogParser.java` foi modificado para incluir o método `processarLogs()`, que lê o arquivo em *streaming* (linha por linha).

O método **`SolucaoForense.encontrarSessoesInvalidas` (Desafio 1)** foi refatorado para usar essa abordagem, garantindo que ele possa processar arquivos de qualquer tamanho sem esgotar a memória RAM.

### Robustez para Novos Logs

Você pode substituir o arquivo `arquivo_logs.csv` por qualquer outro arquivo de logs, desde que ele mantenha o seguinte formato:

*   **Separador:** Vírgula (`,`).
*   **Cabeçalho:** A primeira linha deve ser o cabeçalho.
*   **Ordem das Colunas:** `TIMESTAMP`, `USER_ID`, `SESSION_ID`, `ACTION_TYPE`, `TARGET_RESOURCE`, `SEVERITY_LEVEL`, `BYTES_TRANSFERRED`.

**Atenção:** Os Desafios 2, 3, 4 e 5 ainda carregam todos os logs para a memória. Para arquivos extremamente grandes, apenas o Desafio 1 é totalmente otimizado contra problemas de `OutOfMemoryError`.
