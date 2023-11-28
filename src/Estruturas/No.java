package Estruturas;

public class No {
    public Object valor;
    public int altura;
    public int fator;
    public No esquerda, direita;

    public No(Object valor) {
        this.valor = valor;
        this.altura = 0;
        this.fator = 0;
    }
}
