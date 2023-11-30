import Estruturas.ListaDinamica;
import Estruturas.TabelaHash;

import java.io.*;
import java.util.Arrays;

public class Main {

    public static void main(String[] args) {
        TabelaHash tabela = new TabelaHash();
        ListaDinamica palavras = new ListaDinamica();



        // Ler palavras-chave
        String arqPalavras = "/home/felipeforte/Documentos/Java/IndiceRemissivo/src/palavras-chave.txt";
        try (BufferedReader br = new BufferedReader(new FileReader(arqPalavras))) {
            String linha;

            // Lê cada linha do arquivo
            while ((linha = br.readLine()) != null) {
                palavras.adiciona(linha.toLowerCase());
            }
        } catch (IOException e) {
            e.printStackTrace();
        }

        String nomeArquivo = "/home/felipeforte/Documentos/Java/IndiceRemissivo/src/texto.txt";
        try (BufferedReader br = new BufferedReader(new FileReader(nomeArquivo))) {
            String linha;
            int cont = 1;

            // Lê cada linha do arquivo
            while ((linha = br.readLine()) != null) {
                // Faça o processamento necessário com cada linha
                String[] split = linha.split(" ");
                for (int i=0;i < split.length;i++) {
                    String palavra = split[i].replaceAll("[^a-zA-Zà-úÀ-Ú-]","");
                    if (palavras.contem(palavra.toLowerCase())) {
                        tabela.adicionar(palavra.toLowerCase(),cont);
                    }
                }
                cont++;
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        // Escrever no arquivo
        try {
            FileWriter arq = new FileWriter("/home/felipeforte/Documentos/Java/IndiceRemissivo/src/indice.txt");
            PrintWriter gravarArq = new PrintWriter(arq);
            gravarArq.print(tabela);
            arq.close();
        } catch (IOException e) {
            e.printStackTrace();
        }


        System.out.println(tabela);
    }
}