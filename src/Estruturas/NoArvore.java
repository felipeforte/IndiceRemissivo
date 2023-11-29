package Estruturas;

public class NoArvore {
    public Object valor;
    public int altura;
    public int fator;
    private ListaDinamica incidencias = new ListaDinamica();
    public NoArvore esquerda, direita;

    public NoArvore(Object valor, int linha) {
        this.valor = valor;
        this.altura = 0;
        this.fator = 0;
        incidencias.adiciona(linha);
    }

    public void addLinha(int linha) {
        if (!incidencias.contem(linha)) {
            incidencias.adiciona(linha);
        }
    }

    @Override
    public String toString() {
        return valor.toString() + " " + incidencias;
    }
}
