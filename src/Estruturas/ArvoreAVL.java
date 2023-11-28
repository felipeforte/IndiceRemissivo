package Estruturas;

public class ArvoreAVL {
    public No raiz;

    public ArvoreAVL() {
        raiz = null;
    }

    public void adicionar(Object valor) {
        if (raiz == null) {
            raiz = new No(valor);
        } else {
            raiz = adicionar(valor, raiz);
        }
    }

    private No adicionar(Object valor, No no) {
        if (valor.toString().compareTo(no.valor.toString()) < 0) {
            if (no.esquerda == null) {
                no.esquerda = new No(valor);
            } else {
                adicionar(valor,no.esquerda);
            }
        } else if (valor.toString().compareTo(no.valor.toString()) > 0) {
            if (no.direita == null) {
                no.direita = new No(valor);
            } else {
                adicionar(valor,no.direita);
            }
        }
        atualizar(no);
        return balancear(no);
    }

    private void atualizar(No no) {
        int alturaEsquerda = (no.esquerda == null) ? -1 : no.esquerda.altura;
        int alturaDireita = (no.direita == null) ? -1 : no.direita.altura;

        no.altura = 1 + Math.max(alturaEsquerda, alturaDireita);

        no.fator = alturaEsquerda - alturaDireita;
    }

    private No balancear(No no) {
        // Pendendo pra direita
        if (no.fator == -2) {
            if (no.direita.fator <= 0) {
                return res(no);
            } else {
                return rde(no);
            }
        // Pendendo pra esquerda
        } else if (no.fator == 2) {
            if (no.esquerda.fator >= 0) {
                return rds(no);
            } else {
                return rdd(no);
            }
        }
        // O fator é 0, +1 ou -1, retorna o nó sem mudanças
        return no;
    }

    private No res(No no) {
        System.out.println("Rotação esquerda simples");
        No subDir = no.direita;
        no.direita = subDir.esquerda;
        subDir.esquerda = no;
        atualizar(no);
        atualizar(subDir);
        return subDir;
    }

    private No rds(No no) {
        System.out.println("Rotação direita simples");
        No subEsq = no.esquerda;
        no.esquerda = subEsq.direita;
        subEsq.direita = no;
        atualizar(no);
        atualizar(subEsq);
        return subEsq;
    }

    private No rde(No no) {
        System.out.println("Rotação dupla a esquerda");
        no.direita = rds(no.direita);
        return res(no);
    }

    private No rdd(No no) {
        System.out.println("Rotação dupla a direita");
        no.esquerda = res(no.esquerda);
        return rds(no);
    }

    public void preOrdem() {
        if (raiz != null) {
            preOrdem(raiz);
            System.out.println();
        }
    }

    private void preOrdem(No no) {
        System.out.print(no.valor + " ");
        if (no.esquerda != null) {
            preOrdem(no.esquerda);
        }
        if (no.direita != null) {
            preOrdem(no.direita);
        }
    }

    public void emOrdem() {
        if (raiz != null) {
            emOrdem(raiz);
            System.out.println();
        }
    }

    private void emOrdem(No no) {
        if (no.esquerda != null) {
            emOrdem(no.esquerda);
        }
        System.out.print(no.valor + " ");
        if (no.direita != null) {
            emOrdem(no.direita);
        }
    }

    public void posOrdem() {
        if (raiz != null) {
            posOrdem(raiz);
            System.out.println();
        }
    }

    private void posOrdem(No no) {
        if (no.esquerda != null) {
            posOrdem(no.esquerda);
        }
        if (no.direita != null) {
            posOrdem(no.direita);
        }
        System.out.print(no.valor + " ");
    }
}
