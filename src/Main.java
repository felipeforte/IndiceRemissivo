import Estruturas.ArvoreAVL;

public class Main {
    public static void main(String[] args) {
        ArvoreAVL avl = new ArvoreAVL();
        // RES
//        avl.adicionar("1");
//        avl.adicionar("0");
//        avl.adicionar("3");
//        avl.adicionar("2");
//        avl.adicionar("4");
//        avl.adicionar("5");


        // RDS
//        avl.adicionar("4");
//        avl.adicionar("5");
//        avl.adicionar("2");
//        avl.adicionar("3");
//        avl.adicionar("1");
//        avl.adicionar("0");

        // RDE
        avl.adicionar("1");
        avl.adicionar("0");
        avl.adicionar("4");
        avl.adicionar("5");
        avl.adicionar("3");
        avl.adicionar("2");
        // RDD



        System.out.println(avl.raiz.esquerda.esquerda.valor);
    }
}