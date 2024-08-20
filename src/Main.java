package src;

public class Main {
    public static void main(String[] args) {
        ArvoreBinaria arvoreBinaria = new ArvoreBinaria();
        arvoreBinaria.inserir(10);
        arvoreBinaria.inserir(4);
        arvoreBinaria.inserir(2);
        arvoreBinaria.inserir(7);
        arvoreBinaria.inserir(5);
        arvoreBinaria.inserir(9);
        arvoreBinaria.inserir(6);
        arvoreBinaria.inserir(15);
        arvoreBinaria.inserir(21);


        //arvoreBinaria.remover();
        System.out.println("Pre-ordem:" );
        arvoreBinaria.preOrdem(arvoreBinaria.getRaiz());

    }
}