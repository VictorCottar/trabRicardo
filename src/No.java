package src;

public class No {
    private No dir;
    private No esq;
    private int valor;

    public No(int valor) {
        this.valor = valor;
        this.esq = null;
        this.dir = null;
    }


    private No maiorValor(No no) {
        while (no.getDir() != null ) {
            no = no.getDir();
        }

        return no;
    }

    public void setValor(int valor) {
        this.valor = valor;
    }

    public int getValor() {
        return valor;
    }

    public No getEsq() {
        return esq;
    }

    public void setEsq(No esq) {
        this.esq = esq;
    }

    public No getDir() {
        return dir;
    }

    public void setDir(No dir) {
        this.dir = dir;
    }
}
