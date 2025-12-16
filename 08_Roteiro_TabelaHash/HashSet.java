import java.util.*;

class HashSet{

    private Integer[] set;
    private final int apagado = Integer.MIN_VALUE;
    private int size;

    public HashSet(int capacidade){
        this.set = new Integer[capacidade];
        this.size = 0;
    }

    public int hash(int valor){
        return valor % set.length;
    }

    public void put(int valor){
        int hash;
        int sondagem = 0;        

        while(size < set.length && sondagem < set.length){
            hash = (hash(valor) + sondagem) % set.length;
            if(set[hash] == null || set[hash] == apagado || set[hash] == valor){
                set[hash] = valor;
                size++;
                return;
            }
            sondagem++;
        }
    }

    public Integer remove(Integer valor){
        int sondagem = 0;
        int hash;

        while(sondagem < set.length){
            hash = (hash(valor) + sondagem) % set.length;
            if(set[hash] == valor){
                set[hash] = apagado;
                size--;
                return valor;
            }
            sondagem++;
        }
        return null;
    }    
    
    public boolean contains(int valor){
        int sondagem = 0;
        int hash;

        while(sondagem < set.length){
            hash = (hash(valor) + sondagem) % set.length;
            if(set[hash] == valor)
                return true;
            if(set[hash] == apagado)
                return false;
            sondagem++;
        }
        return false;
    }

    @Override
    public String toString(){
        StringBuilder sb = new StringBuilder();
        sb.append("[");

        for(int i = 0; i < set.length; i++){
            if(set[i] == null || set[i] == apagado)
                sb.append("null");
            else 
                sb.append(set[i]);
            if(i < set.length - 1)
                sb.append(", ");
        }
        sb.append("]");
        return sb.toString();
    } 
    
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        int size = sc.nextInt();
        HashSet set = new HashSet(size);

        String[] comando = sc.nextLine().split(" ");
        while(!comando[0].equals("end")){
            if(comando[0].equals("put")){
                set.put(Integer.parseInt(comando[1]));
                System.out.println(set);
            } else if(comando[0].equals("remove")){
                set.remove(Integer.parseInt(comando[1]));
                System.out.println(set);
            } else if(comando[0].equals("contains")){
                System.out.println(set.contains(Integer.parseInt(comando[1])));
            }
            comando = sc.nextLine().split(" ");
        }
    }        
}
