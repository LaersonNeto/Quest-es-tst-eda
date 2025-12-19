import java.util.*;

class TabelaHash{

    private Pair[] tabela;
    private Integer[] keys;
    private String[] values;
    private int size;
    private int capacity;
    private final Pair APAGADO = new Pair(Integer.MIN_VALUE, "APAGADO");

    public TabelaHash(int capacity){
        this.tabela = new Pair[capacity];
        this.keys = new Integer[capacity];
        this.values = new String[capacity];
        this.size = 0;
        this.capacity = capacity;
    }

    public int hash(Integer key){
        return key % this.capacity;
    }

    public void put(Integer key, String value){
        int hash;
        int sondagem = 0;

        Pair novo = new Pair(key, value);
        while(sondagem < this.capacity){
            hash = (hash(key) + sondagem) % this.capacity;
            if(tabela[hash] == null || tabela[hash] == APAGADO){
                tabela[hash] = novo;
                values[hash] = value;
                keys[hash] = key;
                this.size++;
                return;
            }
            if(tabela[hash].key.equals(key)){ 
                values[hash] = value;
                tabela[hash].value = value;
                return;
            } 
            sondagem++;
        }        
    }

    public Pair remove(Integer key){
        int hash;
        int sondagem = 0;
    
        while(sondagem < this.capacity){
            hash = (hash(key) + sondagem) % this.capacity;
            if(tabela[hash] != null && tabela[hash].key.equals(key)){
                Pair apagado = this.tabela[hash];
                this.tabela[hash] = this.APAGADO;
                this.values[hash] = null;
                this.keys[hash] = null;
                this.size--;
                return apagado;
            }
            sondagem++;
        }
        return null;
    }

    public String ordenaValues(){
        String[] ordenado = new String[this.size];
    
        int tamanho = 0;
        for(int i = 0; i < capacity; i++)
            if(values[i] != null)
                ordenado[tamanho++] = this.values[i];

        Arrays.sort(ordenado);
        return Arrays.toString(ordenado);
    }    

    public String ordenaKeys(){
        Integer[] ordenado = new Integer[this.size];
        
        int tamanho = 0;
        for(int i = 0; i < this.capacity; i++)
            if (keys[i] != null)
               ordenado[tamanho++] = keys[i]; 
       
        Arrays.sort(ordenado);
        return Arrays.toString(ordenado);
    }

    @Override
    public String toString(){
        String out = "[";
        
        for(int i = 0; i < this.capacity; i++){
            if(tabela[i] == null || tabela[i] == APAGADO)
                out += "null";
            else 
                out += "<" + tabela[i].key + ", " + tabela[i].value + ">";
            if(i != this.capacity - 1)
                out += ", ";
            else
                out += "]";
        }
        return out;
    }

    public Pair get(int key){
        int hash;
        int sondagem = 0;
        
        while(sondagem < this.capacity){
            hash = (hash(key) + sondagem) % this.capacity; 
            
            if(tabela[hash] == null)
                return null;            
            if(tabela[hash].key.equals(key))
                return tabela[hash];
            
            sondagem++;
        }       
        return null;
    }

    class Pair{

        Integer key;
        String value;

        public Pair(Integer key, String value){
            this.key = key;
            this.value = value;
        }
    }

    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        int capacity = sc.nextInt();

        TabelaHash th = new TabelaHash(capacity);   

        while(true){
            String[] entrada = sc.nextLine().split(" ");
            
            if(entrada[0].equals("end"))
                break;
            if(entrada[0].equals("keys"))
                System.out.println(th.ordenaKeys());
            if(entrada[0].equals("values"))
                System.out.println(th.ordenaValues());
            if(entrada[0].equals("put")){
                th.put(Integer.parseInt(entrada[1]), entrada[2]);
                System.out.println(th.toString());    
            }
            if(entrada[0].equals("remove")){
                th.remove(Integer.parseInt(entrada[1]));
                System.out.println(th.toString());
            }
        }
    }
}
