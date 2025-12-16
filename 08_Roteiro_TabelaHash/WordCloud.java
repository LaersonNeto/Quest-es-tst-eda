import java.util.*;

class WordCloud{

    private Palavra[] tabela;
    private int size;
        
    public WordCloud(int size){
        this.tabela = new Palavra[size];
        this.size = size;
    }

    private int hash(String chave){
        return Math.abs(chave.hashCode()) % size;
    }

    public void add(String chave){
        int hash = hash(chave);    
    
        for(int i = 0; i < this.size; i++){
            
            int pos = (hash + i) % this.size;
            
            if(tabela[pos] == null){
                tabela[pos] = new Palavra(chave);
                return;
            }
      
            if(tabela[pos].palavra.equals(chave)){
                tabela[pos].rec++;
                return;
            }
        }
    }

    public int frequencia(String chave){
        int hash = hash(chave);

        for(int i = 0; i < this.size; i++){
            int pos = (hash + i) % size;
            
            if(tabela[pos] == null)
                return 0;

            if(tabela[pos].palavra.equals(chave))
                return tabela[pos].rec;
        }

        return 0;
    }

    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        String[] frase = sc.nextLine().split(" ");
        WordCloud wc = new WordCloud(frase.length);    
    
        for(int i = 0; i < frase.length; i++)
            wc.add(frase[i]);        

        while(true){
            String palavra = sc.nextLine().trim();
            
            if(palavra.equals("fim"))
                break;
            
            System.out.println(wc.frequencia(palavra));
        }
    }

    class Palavra {

        private String palavra;
        private int rec;
    
        public Palavra(String palavra){
            this.palavra = palavra;
            this.rec = 1;
        }
    }
}
