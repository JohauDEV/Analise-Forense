package br.edu.icev.aed.forense;

import java.io.*;
import java.util.*;
import java.util.function.Consumer;

/**
 * Faz a leitura do arquivo forensic_logs.csv e converte em lista de LogEntry.
 */
public class LogParser {

    /**
     * Processa o arquivo de logs linha por linha, aplicando o consumidor a cada LogEntry.
     * Esta é a forma recomendada para evitar problemas de memória com arquivos grandes.
     * @param caminho Caminho para o arquivo CSV de logs
     * @param consumidor Ação a ser executada para cada LogEntry lida
     * @throws IOException Se houver erro ao ler o arquivo
     */
    public static void processarLogs(String caminho, Consumer<LogEntry> consumidor) throws IOException {
        try (BufferedReader br = new BufferedReader(new FileReader(caminho))) {
            // Pula a linha de cabeçalho
            br.readLine(); 
            
            String linha;
            while ((linha = br.readLine()) != null) {
                String[] p = linha.split(",");
                if (p.length < 7) continue;

                try {
                    long timestamp = Long.parseLong(p[0]);
                    String userId = p[1];
                    String sessionId = p[2];
                    String actionType = p[3];
                    String target = p[4];
                    int severity = Integer.parseInt(p[5]);
                    long bytes = Long.parseLong(p[6]);

                    LogEntry logEntry = new LogEntry(timestamp, userId, sessionId, actionType, target, severity, bytes);
                    consumidor.accept(logEntry);
                } catch (NumberFormatException e) {
                    // Ignora linhas mal formatadas, como o cabeçalho que pode ter sido lido
                    // ou dados inválidos, para evitar a interrupção do processamento.
                    System.err.println("Aviso: Linha mal formatada ignorada: " + linha);
                }
            }
        }
    }

    public static List<LogEntry> lerLogs(String caminho) throws IOException {
        List<LogEntry> lista = new ArrayList<>();

        // Usa o novo método de processamento para carregar todos os logs na lista
        processarLogs(caminho, lista::add);

        return lista;
    }
}
