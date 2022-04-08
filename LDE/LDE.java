package LDE;

public class LDE {

    private Node ultimo;
    private Node primeiro;
    private int qtd;

    public boolean isEmpty() {

        if (this.primeiro == null && qtd == 0 && this.ultimo == null) {
            return true;
        } else {
            return false;
        }
    }

    public void inserirOrdenadoDecrescente(Cliente c) {
        Node novo = new Node(c);
        if (this.isEmpty() == true) { // inserção na lista vazia
            this.primeiro = novo;
            this.ultimo = novo;
            this.qtd++;
        }

        else if (c.compareTo(this.primeiro.getInfo()) > 0) { // inserção antes do primeiro
            novo.setProx(this.primeiro);
            this.primeiro.setAnt(novo);
            this.primeiro = novo;
            this.qtd++;
        } else if (c.compareTo(this.ultimo.getInfo()) < 0) { // inserção após o último
            this.ultimo.setProx(novo);
            novo.setAnt(this.ultimo);
            this.ultimo = novo;
            this.qtd++;
        } else {
            Node aux = this.primeiro;
            int result;
            while (aux != null) {
                result = c.compareTo(aux.getInfo());

                if (result == 0) {
                    System.out.println("O numero já está na lista");
                    return;
                } else if (result > 0) {
                    novo.setAnt(aux.getAnt());
                    novo.setProx(aux);
                    aux.getAnt().setProx(novo);
                    aux.setAnt(novo);
                    this.qtd++;
                    return;
                }
                aux = aux.getProx();
            }
        }
    }

    public void inserirOrdenado(Cliente c) {
        Node novo = new Node(c);
        if (this.isEmpty() == true) { // inserção na lista vazia
            this.primeiro = novo;
            this.ultimo = novo;
            this.qtd++;
        } else if (c.compareTo(this.primeiro.getInfo()) < 0) { // inserção antes do primeiro
            novo.setProx(this.primeiro);
            this.primeiro.setAnt(novo);
            this.primeiro = novo;
            this.qtd++;
        } else if (c.compareTo(this.ultimo.getInfo()) > 0) { // inserção após o último
            this.ultimo.setProx(novo);
            novo.setAnt(this.ultimo);
            this.ultimo = novo;
            this.qtd++;
        } else {
            Node aux = this.primeiro;
            int result;
            while (aux != null) {
                result = c.compareTo(aux.getInfo());

                if (result == 0) {
                    novo.setAnt(aux.getAnt());
                    novo.setProx(aux);
                    aux.getAnt().setProx(novo);
                    aux.setAnt(novo);
                    this.qtd++;
                    return;
                } else if (result < 0) {
                    novo.setAnt(aux.getAnt());
                    novo.setProx(aux);
                    aux.getAnt().setProx(novo);
                    aux.setAnt(novo);
                    this.qtd++;
                    return;
                }
                aux = aux.getProx();
            }
        }
    }

    public Node buscaMelhorada(Cliente n) {
        Node aux = this.primeiro;
        int result;

        while (aux != null) {
            result = aux.getInfo().compareTo(n);
            if (result > 0) {
                System.out.println("Valor não encontrado");
                return null;
            } else if (result == 0) {
                return aux;
            } else {
                aux = aux.getProx();
            }
        }

        return null;
    }

    public void remocaoOC(Cliente c) {

        if (isEmpty()) {
            System.out.println("Nada pra remover po");
            return;
        } else if (qtd == 1) {
            this.primeiro = null;
            this.ultimo = null;
        } else {
            Node aux = buscaMelhorada(c);

            if (aux == null) {
                System.out.println("Cliente não encontrado");
            } else {
                Node aux1;
                if (aux == this.primeiro) {
                    aux1 = this.primeiro.getProx();
                    aux1.setAnt(null);
                    this.primeiro = aux;
                } else if (aux == this.ultimo) {
                    aux1 = ultimo.getAnt();
                    aux.setProx(null);
                } else {
                    Node anterior = aux.getAnt();
                    Node proximo = aux.getProx();
                    anterior.setProx(proximo);
                    proximo.setAnt(anterior);
                    qtd--;
                    System.out.println("O Cliente que possui o cpf " + c.getCpf() + "Foi removido da lsita");
                }
            }
        }

        this.qtd--;
    }

    public void inserirInicio(Cliente c) {

        Node novo = new Node(c);

        if (this.isEmpty()) {
            this.primeiro = novo;
            this.ultimo = novo;
            System.out.println("Primeira inserção.");
        } else {
            novo.setProx(this.primeiro);
            this.primeiro.setAnt(novo);
            this.primeiro = novo;
        }
        System.out.println("Cliente inserido");
        qtd++;
    }

    public void inserirFinal(Cliente c) {
        Node novo = new Node(c);
        if (isEmpty()) {
            this.primeiro = novo;
            this.ultimo = novo;
            System.out.println("Primeira inserção.");
        } else if (qtd == 1) {
            this.primeiro.setProx(novo);
            novo.setAnt(this.primeiro);
            this.ultimo = novo;
        } else {
            Node aux = ultimo;
            aux.setProx(novo);
            novo.setAnt(aux);
            this.ultimo = novo;
        }
        System.out.println("Cliente inserido");
        this.qtd++;
    }

    public void removerInicio() {
        if (isEmpty()) {
            System.out.println("Nada pra remover po");
            return;
        } else if (qtd == 1) {
            this.primeiro = null;
            this.ultimo = null;
        } else {
            Node aux = this.primeiro.getProx();
            aux.setAnt(null);
            this.primeiro = aux;
        }

        this.qtd--;
    }

    public void removerFinal() {
        if (isEmpty()) {
            System.out.println("A lista ta vazia po");
            return;
        } else if (qtd == 1) {
            this.primeiro = null;
            this.ultimo = null;
        } else {
            Node aux = ultimo.getAnt();
            aux.setProx(null);
        }

        System.out.println("Cliente removido.");

        this.qtd--;
    }

    public void exibirLista() {

        Node aux;
        if (this.isEmpty() == true) {
            System.out.println("Não existem clientes cadastrados!");
        } else {
            aux = this.primeiro;
            while (aux != null) {
                System.out.println(aux.getInfo());
                aux = aux.getProx();
            }
        }
    }

    public void exibirContrario() {
        Node aux;
        if (this.isEmpty() == true) {
            System.out.println("Não existem clientes cadastrados!");
        } else {
            aux = this.ultimo;
            while (aux != null) {
                System.out.println(aux.getInfo());
                aux = aux.getAnt();
            }
        }
    }
}