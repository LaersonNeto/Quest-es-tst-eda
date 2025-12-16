import java.util.*;

class MaxPilhaIndex{

    private int[] pilha;
    private int topo;

    public MaxPilhaIndex(int capacidade){
        this. topo = -1;
        this.pilha = new int[capacidade];
    } 

    public boolean isEmpty() {
        return this.topo == -1;
    }

    public boolean isFull() {
        return this.topo == this.pilha.length - 1;
    }

    public void push(int valor){
        if (isFull()) throw new RuntimeException("pilha cheia");
        this.pilha[++this.topo] = valor;
    }

    public int pop(){
        if (isEmpty()) throw new NoSuchElementException();
        return this.pilha[this.topo--];
    }

    public int peek(){
        if (isEmpty()) throw new NoSuchElementException();
        return this.pilha[this.topo];
    }

    public int size(){
        return this.topo + 1;
    }

    public int maior(int index){
        MaxPilhaIndex aux = new MaxPilhaIndex(this.topo + 1);
        aux.push(pop());
        int max = aux.peek();
        
        for(int i = 1; i <= index; i++){
            aux.push(pop());
            if(aux.peek() > max) 
                max = aux.peek();
        }

        while(!aux.isEmpty())
            push(aux.pop());

        return max;
    }

    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        String[] input = sc.nextLine().split(" ");
        MaxPilhaIndex pilha = new MaxPilhaIndex(input.length);
        
        for(int i = 0; i < input.length; i++)
            pilha.push(Integer.parseInt(input[i]));
            
        int index = sc.nextInt();
        System.out.println(pilha.maior(index));
    }
}  
