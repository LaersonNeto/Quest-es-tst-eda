import java.util.*;

class TabelaEncadeada{ 

    private ArrayList<Pair>[] tabela;
    
    public TabelaEncadeada(int capacity){
        this.tabela = new ArrayList[capacity];
    }

    private int hash(Integer chave){
        return chave % tabela.length;
    }

    public void put(Integer key, Pair value){
        int hash = hash(key);
        ArrayList<Pair> list = this.tabela[hash];

        if(list == null){
            list = new ArrayList<Pair>();
            this.tabela[hash] = list;
            list.add(value);
        } else {
            for(Pair p: list){
                if(p.key.equals(key)){
                    p.value = value.value;
                    return;
                }
            }
            list.add(value);
        }
    }

    public Pair get(Integer key){
        int hash = hash(key);
        ArrayList<Pair> list = this.tabela[hash];

        if(list == null)
            return null;
        
        for(Pair p: list)
            if(p.key.equals(key))
                return p;
        
        return null;
    }

    public Pair remove(Integer key){
        int hash = hash(key);
        ArrayList<Pair> list = this.tabela[hash];
        
        if(list == null)
            return null;

        for(Pair p: list){
            if(p.key.equals(key)){
                Pair removido = p;
                list.remove(removido);
                return removido;
            }
        } 
        return null;
    }
    
    @Override
    public String toString(){
        String out = "[";

        for(int i = 0; i < tabela.length; i++){
            out += "[";
            if(tabela[i] != null && tabela[i].size() != 0){
                for(Pair p: tabela[i]){
                    out += p.toString();
                    if(tabela[i].indexOf(p) != tabela[i].size() - 1)
                        out += ", ";
                }
            }
            out += "]"; 
            if(i != tabela.length - 1)
                out += ", ";
        }
        out += "]";
        return out; 
    }

    public String ordenaValues(){
        String[] aux = new String[size()];
        int k = 0;

        for(int i = 0; i < tabela.length; i++){
            if(tabela[i] != null){
                for(Pair p : tabela[i]){
                    aux[k++] = p.value;
                }
            }
        }
        Arrays.sort(aux);
        return Arrays.toString(aux);
    }

    public String ordenaKeys(){
        Integer[] aux = new Integer[size()];
        int k = 0;

        for(int i = 0; i < tabela.length; i++){
            if(tabela[i] != null){
                for(Pair p : tabela[i]){
                    aux[k++] = p.key;
                }
            }
        }
        Arrays.sort(aux);
        return Arrays.toString(aux);
    }

    private int size(){
        int count = 0;
        for(int i = 0; i < tabela.length; i++)
            if(tabela[i] != null)
                count += tabela[i].size();
        return count;
    }


    static class Pair{

        Integer key;
        String value;

        public Pair(Integer key, String value){
            this.key = key;
            this.value = value;
        }

        public String toString(){
            String out = "<" + this.key + ", " + this.value + ">";
            return out;
        }
    }

    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        int capacity = sc.nextInt();

        TabelaEncadeada th = new TabelaEncadeada(capacity);

        while(true){
            String[] entrada = sc.nextLine().split(" ");

            if(entrada[0].equals("end"))
                break;
            if(entrada[0].equals("keys"))
                System.out.println(th.ordenaKeys());
            if(entrada[0].equals("values"))
                System.out.println(th.ordenaValues());
            if(entrada[0].equals("put")){
                Integer key = Integer.parseInt(entrada[1]);
                th.put(key, new Pair(key, entrada[2]));
                System.out.println(th.toString());
            }
            if(entrada[0].equals("remove")){
                th.remove(Integer.parseInt(entrada[1]));
                System.out.println(th.toString());
            }
        }        
    }
}
