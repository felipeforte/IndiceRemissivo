package Estruturas;

public class TabelaHash {
    private int tamanho = 26;
    public Hash[] tabela = new Hash[tamanho];

    public int hash(Object chave) {
        return chave.hashCode() % tamanho;
    }

    public void adicionar(Object valor, int linha) {
        String chave = valor.toString().split("")[0].toLowerCase();
        int pos = hash(chave);
        if (tabela[pos] == null) {
            Hash newHash = new Hash(new ArvoreAVL());
            tabela[pos] = newHash;
            tabela[pos].adicionar(valor,linha);
        } else {
            tabela[pos].adicionar(valor,linha);
        }
    }

    @Override
    public String toString() {
        String saida = "";
        for (int i=97;i<123;i++) {
            int chave = i%26;
            if (tabela[chave] != null) {
                saida += tabela[chave].toString();
            }
        }
        return saida;
    }
}
