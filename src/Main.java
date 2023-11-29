import Estruturas.ListaDinamica;
import Estruturas.TabelaHash;
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

public class Main {

    public static void main(String[] args) {
        TabelaHash tabela = new TabelaHash();
        ListaDinamica palavras = new ListaDinamica();

        // Ler palavras-chave
        String arqPalavras = "/home/felipeforte/Downloads/exemplo_palavras-chave.txt";
        try (BufferedReader br = new BufferedReader(new FileReader(arqPalavras))) {
            String linha;

            // Lê cada linha do arquivo
            while ((linha = br.readLine()) != null) {
                palavras.adiciona(linha.toLowerCase());
            }
        } catch (IOException e) {
            e.printStackTrace();
        }

        String nomeArquivo = "/home/felipeforte/Downloads/exemplo_texto.txt";
        try (BufferedReader br = new BufferedReader(new FileReader(nomeArquivo))) {
            String linha;
            int cont = 1;

            // Lê cada linha do arquivo
            while ((linha = br.readLine()) != null) {
                // Faça o processamento necessário com cada linha
                String[] split = linha.split(" ");
                for (int i=0;i < split.length;i++) {
                    if (palavras.contem(split[i].toLowerCase())) {
                        tabela.adicionar(split[i].toLowerCase(),cont);
                    }
                }
                cont++;
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        System.out.println(tabela);
    }
}