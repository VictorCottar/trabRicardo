package src;

public class ArvoreBinaria {
    private No raiz;

    public ArvoreBinaria() {
        this.raiz = null;
    }

    public void inserir(int valor) {
        No novoNo = new No(valor);
        if (this.raiz == null) {
            this.raiz = novoNo;
        } else {
            No atual = this.raiz;
            No pai = null;
            boolean esquerda = false;
            while (atual != null) {
                if (novoNo.getValor() < atual.getValor()) {
                    pai = atual;
                    atual = atual.getEsq();
                    esquerda = true;
                } else {
                    pai = atual;
                    atual = atual.getDir();
                    esquerda = false;
                }
            }
            if (esquerda) {
                pai.setEsq(novoNo);
            } else {
                pai.setDir(novoNo);
            }
        }
    }

    public boolean remover(int valor) {
        No atual = this.raiz;
        No pai = this.raiz;
        boolean filhoEsquerda = true;

        // busca pelo nó
        while (atual.getValor() != valor) {
            pai = atual;
            if (valor < atual.getValor()) {
                filhoEsquerda = true;
                atual = atual.getEsq();
            } else {
                filhoEsquerda = false;
                atual = atual.getDir();
            }
            if (atual == null) {
                return false;
            }
        }

        if (atual.getEsq() == null && atual.getDir() == null) {
            if (atual == this.raiz) {
                this.raiz = null;
            } else if (filhoEsquerda) {
                pai.setEsq(null);
            } else
                pai.setDir(null);
        }

        else if (atual.getDir() == null) {
            if (atual == this.raiz) {
                this.raiz = atual.getEsq();
            } else if (filhoEsquerda) {
                pai.setEsq(atual.getEsq());
            } else
                pai.setDir(atual.getEsq());
        }

        else if (atual.getEsq() == null) {
            if (atual == this.raiz) {
                this.raiz = atual.getDir();
            } else if (filhoEsquerda) {
                pai.setEsq(atual.getDir());
            } else
                pai.setDir(atual.getDir());
        }

        else {
            No sucessor = obterSucessor(atual);

            if (atual == raiz) {
                raiz = sucessor;
            } else if (filhoEsquerda) {
                pai.setEsq(sucessor);
            } else {
                pai.setDir(sucessor);
            }
            sucessor.setEsq(atual.getEsq());
            System.out.println("Nó com dois filhos removido.");
        }
        return true;
    }

    public No obterSucessor(No no) {
        No paiSucessor = no;
        No sucessor = no;
        No atual = no.getDir();

        while (atual != null) {
            paiSucessor = sucessor;
            sucessor = atual;
            atual = atual.getEsq();
        }

        if (sucessor != no.getDir()) {
            paiSucessor.setEsq(sucessor.getDir());
            sucessor.setDir(no.getDir());
        }

        return sucessor;
    }

    public void preOrdem(No no) {
        if (no == null) {
            return;
        }
        System.out.println(no.getValor());
        preOrdem(no.getEsq());
        preOrdem(no.getDir());
    }

    public void emOrdem(No no) {
        if (no == null) {
            return;
        }
        emOrdem(no.getEsq());
        System.out.println(no.getValor());
        emOrdem(no.getDir());
    }

    public void posOrdem(No no) {
        if (no == null) {
            return;
        }
        posOrdem(no.getEsq());
        posOrdem(no.getDir());
        System.out.println(no.getValor());
    }

    public No getRaiz() {
        return this.raiz;
    }

}
