package Estruturas;

public class TabelaHash {
    private int size = 26;
    private Hash[] tabela;

    public TabelaHash(int size) {
        this.size = size;
        tabela = new Hash[size];
    }

    public int hash(Object chave) {
        return chave.hashCode() % size;
    }

    public void mostrar() {
        Hash aux;
        for (int i = 0; i < size; i++) {
            aux = tabela[i];
            System.out.print(i + " -> ");
            while (aux != null) {
                System.out.print(aux.chave + " -> ");
                aux = aux.proximo;
            }
            System.out.println("\\");
        }
    }

    public void adicionar(Object chave) {
        int pos = hash(chave);
        Hash aux = tabela[pos];
        Hash newHash = new Hash();
        newHash.chave = Integer.parseInt(chave.toString());
        newHash.valor = chave;
        newHash.proximo = null;
        if (aux == null) {
            tabela[pos] = newHash;
        } else {
            while (aux.proximo != null) {
                aux = aux.proximo;
            }
            aux.proximo = newHash;
        }
    }

    public void adicionar(Object chave, Object valor) {
        int pos = hash(chave);
        Hash aux = tabela[pos];
        Hash newHash = new Hash();
        newHash.chave = Integer.parseInt(chave.toString());
        newHash.valor = valor;
        newHash.proximo = null;
        if (aux == null) {
            tabela[pos] = newHash;
        } else {
            while (aux.proximo != null) {
                aux = aux.proximo;
            }
            aux.proximo = newHash;
        }
    }

    public void remove(Object key) {
        int pos = hash(key);
        Hash aux = tabela[pos];
        if (aux != null) {
            if (aux.chave == Integer.parseInt(key.toString())) {
                tabela[pos] = aux.proximo;
            } else {
                while (aux.proximo != null && aux.proximo.chave != Integer.parseInt(key.toString())) {
                    aux = aux.proximo;
                }
                if (aux.proximo != null) {
                    aux.proximo = aux.proximo.proximo;
                }
            }
        }
    }
}
