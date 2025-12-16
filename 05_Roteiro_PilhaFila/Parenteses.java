import java.util.*;

class Parenteses {

    private String[] pilha;
    private int topo;

    public Parenteses(int capacidade){
        this.pilha = new String[capacidade];
        this.topo = -1;
    }
    
    public boolean isEmpty(){
        return this.topo == -1;
    }

    public boolean isFull(){
        return this.topo == this.pilha.length -1;
    }

    public void push(String elemento){
        if(isFull()) resize(this.pilha.length * 2);
        this.pilha[++this.topo] = elemento;
    }

    public String pop(){
        if(isEmpty()) throw new NoSuchElementException();
        return this.pilha[this.topo--];
    }

    public String peek(){
        if(isEmpty()) throw new NoSuchElementException();
        return this.pilha[this.topo];
    }

    public void resize(int newCapacidade){
        if (newCapacidade < pilha.length * 2)
            newCapacidade = pilha.length * 2;

        Parenteses aux = new Parenteses(this.topo + 1);

        while(!isEmpty())
            aux.push(pop());

        this.pilha = new String[newCapacidade];
        this.topo = -1;

        while(!aux.isEmpty())
            push(aux.pop());
    }

    public boolean analisa() {
        Parenteses aux = new Parenteses(this.topo + 1);
        int aberto = 0;

        while (!isEmpty()) {
            String c = pop();
            aux.push(c);

            if (c.equals("(")) {
                aberto++;
            } else if (c.equals(")")) {
                if (aberto == 0) {
                    while (!aux.isEmpty()) push(aux.pop());
                    return false;
                }
                aberto--;
            }
        }

        while (!aux.isEmpty()) {
            push(aux.pop());
        }

        return aberto == 0;
    }

    public void carregarPalavra(String palavra) {
        int i = palavra.length() - 1;
        while (i >= 0) {
            push(String.valueOf(palavra.charAt(i)));
            i--;
        }
    }

    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        String palavra = sc.nextLine();
        Parenteses p = new Parenteses(palavra.length());
        p.carregarPalavra(palavra);
        boolean resposta = p.analisa();
        if (resposta) System.out.println("S");
        if(!resposta) System.out.println("N");
    }
}
