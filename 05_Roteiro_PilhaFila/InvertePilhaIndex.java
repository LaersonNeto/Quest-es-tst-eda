import java.util.*;

class InvertePilhaIndex{

    public static void inverte(Pilha pilha, int index){
        Pilha aux = new Pilha(index + 1);
        System.out.println("-");

        while(!aux.isFull())
            aux.push(pilha.pop());
        
        while(!aux.isEmpty())
            System.out.println(aux.pop());

        while(!pilha.isEmpty())
            System.out.println(pilha.pop());
    }

    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        int tamanho = sc.nextInt();
        sc.nextLine();
        String[] input = sc.nextLine().split(" ");
        Pilha pilha = new Pilha(tamanho);
        for(int i = 0; i < tamanho; i++)
            pilha.push(Integer.parseInt(input[i]));
        int index = sc.nextInt();
        inverte(pilha, index);
    }
}

class Pilha {
    
    private int[] pilha;
    private int topo;
    private int size;
    
    public Pilha(int tamanho){
        this.pilha = new int[tamanho];
        this.topo = -1;
        this.size = 0;
    }

    public boolean isEmpty(){
        return this.topo == -1;
    }

    public boolean isFull(){
        return this.topo == this.pilha.length - 1;
    }

    public void push(int valor){
        if(isFull()) throw new RuntimeException("pilha vazia");
        this.pilha[++this.topo] = valor;
        size++;
    }
    
    public int pop(){
        if(isEmpty()) throw new RuntimeException("pilha vazia");
        size--;
        return this.pilha[this.topo--];
    }

    public int size(){
        return this.size;
    }
}
