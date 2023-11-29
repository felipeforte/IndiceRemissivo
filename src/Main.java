import Estruturas.ArvoreAVL;
import Estruturas.TabelaHash;

public class Main {
    public static void main(String[] args) {
        TabelaHash tabela = new TabelaHash();
        // RES
        // RDS
        // RDE
        // RDD
        tabela.adicionar("and",3);
        tabela.adicionar("amo",3);
        tabela.adicionar("and",4);
        tabela.adicionar("and",5);
        tabela.adicionar("bolha",11);
        tabela.adicionar("xpto",2);
        tabela.adicionar("tchonga",6);
        tabela.adicionar("fonga",12);
        tabela.adicionar("momo",1);
        tabela.adicionar("caralho",7);
        tabela.adicionar("teucu",9);


        System.out.println(tabela);
    }
}