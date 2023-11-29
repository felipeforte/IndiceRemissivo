package Estruturas;

public class TabelaHash {
    private int tamanho = 26;
    private Hash[] tabela;

    public TabelaHash(int tamanho) {
        this.tamanho = tamanho;
        tabela = new Hash[tamanho];
    }

    public int hash(Object chave) {
        return chave.hashCode() % tamanho;
    }

    public void adicionar(Object valor) {
        String chave = valor.toString().split("")[0].toLowerCase();
        int pos = hash(chave);
        if (tabela[pos] == null) {
            Hash newHash = new Hash(new ArvoreAVL());
            tabela[pos] = newHash;
            tabela[pos].adicionar(valor);
        } else {
            tabela[pos].adicionar(valor);
        }
    }
}
