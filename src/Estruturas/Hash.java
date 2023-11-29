package Estruturas;

public class Hash {
    public ArvoreAVL arvore;

    public Hash(ArvoreAVL arvore) {
        this.arvore = arvore;
    }

    public void adicionar(Object valor, int linha) {
        arvore.adicionar(valor,linha);
    }

    public String toString() {
        return arvore.toString();
    }
}
