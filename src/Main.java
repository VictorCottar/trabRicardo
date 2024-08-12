package src;

public class Main {
    public static void main(String[] args) {
        ArvoreBinaria arvoreBinaria = new ArvoreBinaria();
        arvoreBinaria.inserir(50);
        arvoreBinaria.inserir(45);
        arvoreBinaria.inserir(46);
        arvoreBinaria.inserir(43);
        arvoreBinaria.inserir(42);
        arvoreBinaria.inserir(60);
        arvoreBinaria.inserir(65);
        arvoreBinaria.inserir(64);
        arvoreBinaria.inserir(63);

        arvoreBinaria.remover(60);
        System.out.println("Pré-ordem: ");
        arvoreBinaria.preOrdem(arvoreBinaria.getRaiz());
        System.out.println("Em ordem: ");
        arvoreBinaria.emOrdem(arvoreBinaria.getRaiz());
        System.out.println("Pós ordem: ");
        arvoreBinaria.posOrdem(arvoreBinaria.getRaiz());
    }
}