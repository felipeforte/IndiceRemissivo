package Estruturas;

public class NoArvore {
    public Object valor;
    public int altura;
    public int fator;
    public ListaDinamica incidencias = new ListaDinamica();
    public NoArvore esquerda, direita;

    public NoArvore(Object valor) {
        this.valor = valor;
        this.altura = 0;
        this.fator = 0;
    }
}
