package Estruturas;

public class NoLista implements Comparable<NoLista> {
    public Object valor;
    public NoLista proximo;
    public NoLista anterior;

    public NoLista(Object valor) {
        this.valor = valor;
        proximo = null;
        anterior = null;
    }

    @Override
    public int compareTo(NoLista outro) {
        if (valor instanceof Integer && outro.valor instanceof Integer) {
            if ((Integer) valor > (Integer) outro.valor) {
                return 1;
            } else if ((Integer) valor < (Integer) outro.valor) {
                return -1;
            } else {
                return 0;
            }
        }
        return valor.toString().compareTo(outro.valor.toString());
    }
}
