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
        boolean filhoEsquerda = true; //verifica se o no atual é filho a esquerda do pai.

        // busca pelo nó que vai ser removido
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
                System.out.println("O valor a ser removido não está presente na árvore.");
                return false;
            }
        }

        // nó folha, o pai seta o filho como null.
        if (atual.getEsq() == null && atual.getDir() == null) {
            if (atual == this.raiz) {
                this.raiz = null;
            } else if (filhoEsquerda) {
                pai.setEsq(null);
                System.out.println("Nó folha a esquerda do pai foi removido.");
            } else
                System.out.println("Nó folha a direita do pai foi removido.");
                pai.setDir(null);
        }

        // nó com 1 filho, o pai seta o filho do nó removido no lugar do nó removido.
        else if (atual.getDir() == null) {
            if (atual == this.raiz) {
                this.raiz = atual.getEsq();
            } else if (filhoEsquerda) {
                pai.setEsq(atual.getEsq()); // valor do filho do nó que foi removido
            } else {
                pai.setDir(atual.getEsq());
            }
            System.out.println("Nó removido com 1 filho");
        }

        // filho direito do atual
        else if (atual.getEsq() == null) {
            if (atual == this.raiz) {
                this.raiz = atual.getDir();
            } else if (filhoEsquerda) {
                pai.setEsq(atual.getDir()); // valor do filho do nó que foi removido
            } else {
                pai.setDir(atual.getDir());
            }
            System.out.println("Nó removido com 1 filho");
        }

        // nó 2 filhos / remoção raiz
        else {
            // chama o metodo para encontrar o sucessor
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

        // encontrar o menor valor da sub-arvore da direita
        while (atual != null) {
            paiSucessor = sucessor;
            sucessor = atual;
            atual = atual.getEsq();
        }

        // filho direto
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



    public No obterSucessorb(No no) {
        // Inicializa a variável paiSucessor com o nó atual que está sendo considerado para remoção.
        // Esta variável irá rastrear o pai do sucessor encontrado.
        No paiSucessor = no;

        // Inicializa a variável sucessor com o nó atual. Esta variável será usada para encontrar
        // e armazenar o sucessor do nó que será removido.
        No sucessor = no;

        // Inicializa a variável atual para começar a busca pelo menor valor na subárvore direita.
        // O primeiro nó a ser examinado é o filho direito do nó que está sendo removido.
        No atual = no.getDir();

        // Enquanto houver um nó à esquerda na subárvore direita,
        // continue descendo pela árvore.
        while (atual != null) {
            // Atualiza paiSucessor para ser o sucessor atual antes de avançar.
            paiSucessor = sucessor;

            // Avança para o próximo nó à esquerda, que pode ser o novo sucessor.
            sucessor = atual;

            // Continua descendo à esquerda para encontrar o menor valor,
            // que será o sucessor do nó que está sendo removido.
            atual = atual.getEsq();
        }

        // Verifica se o sucessor encontrado não é o filho direito imediato do nó que está sendo removido.
        // Isso acontece se o sucessor estiver mais profundo na subárvore.
        if (sucessor != no.getDir()) {
            // Conecta o filho esquerdo do pai do sucessor ao filho direito do sucessor.
            // Isso remove o sucessor da sua posição original.
            paiSucessor.setEsq(sucessor.getDir());

            // Conecta o filho direito original do nó a ser removido ao sucessor.
            // Isso assegura que a subárvore direita de 'no' permaneça conectada.
            sucessor.setDir(no.getDir());
        }

        // Retorna o sucessor encontrado, que substituirá o nó que está sendo removido.
        return sucessor;
    }

}
