public class ListaDinamica {
    private No primeiro;
    private No ultimo;
    private int tamanho;

    public ListaDinamica() {
        primeiro = null;
        ultimo = null;
        tamanho = 0;
    }

    public int tamanho() {
        return tamanho;
    }

    public void adiciona(Object objeto) {
        No novo = new No(objeto);

        if (primeiro == null) {
            primeiro = novo;
            ultimo = novo;
        } else {
            novo.anterior = ultimo;
            ultimo.proximo = novo;
            ultimo = novo;
        }
        tamanho++;
    }

    public void adiciona(int indice, Object objeto) {
        if (indice>tamanho) {
            throw new IndexOutOfBoundsException();
        } else {
            No atual = primeiro;
            for (int i=0;i<indice;i++) {
                atual = atual.proximo;
            }
            No novo = new No(objeto);
            if (atual == primeiro) {
                novo.proximo = atual;
                atual.anterior = novo;
                primeiro = novo;
            } else if (indice == tamanho) {
                novo.anterior = ultimo;
                ultimo.proximo = novo;
                ultimo = novo;
            } else {
                novo.anterior = atual.anterior;
                atual.anterior.proximo = novo;
                atual.anterior = novo;
                novo.proximo = atual;
            }
            tamanho++;
        }
    }

    public void limpar() {
        primeiro = null;
        ultimo = null;
        tamanho = 0;
    }

    public boolean contem(Object objeto) {
        No atual = primeiro;
        for (int i=0;i<tamanho;i++) {
            if (objeto.equals(atual.valor)) {
                return true;
            }
            atual = atual.proximo;
        }
        return false;
    }

    public void remover(Object objeto) {
        No atual = primeiro;
        for (int i=0;i<tamanho;i++) {
            if (objeto.equals(atual)) {
                atual.anterior.proximo = atual.proximo;
                tamanho--;
                return;
            }
            atual = atual.proximo;
        }
    }

    public void remover(int indice) {
        if (indice>tamanho) {
            throw new IndexOutOfBoundsException();
        } else {
            No atual = primeiro;
            for (int i=0;i<indice;i++) {
                atual = atual.proximo;
            }
            if (atual == primeiro) {
                primeiro = atual.proximo;
            } else if (atual == ultimo) {
                atual.anterior.proximo = null;
                ultimo = atual.anterior;
            } else {
                atual.proximo.anterior = atual.anterior;
                atual.anterior.proximo = atual.proximo;
            }
        }
        tamanho--;
    }

    public Object get(int indice) {
        No atual = primeiro;
        for (int i=0;i<indice;i++) {
            atual = atual.proximo;
        }
        return atual.valor;
    }

    public int indexOf(Object objeto) {
        No atual = primeiro;
        for (int i=0;i<tamanho;i++) {
            if (objeto == atual.valor) {
                return i;
            }
            atual = atual.proximo;
        }
        return -1;
    }

    @Override
    public String toString() {
        No atual = primeiro;
        String str = "[ ";
        for (int i=0;i<tamanho;i++) {
            str += atual.valor + " ";
            atual = atual.proximo;
        }
        return str + "]";
    }
}