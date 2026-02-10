import java.util.*;

class Predecessor{

    private Node root;
    private int size;

    public boolean isEmpty(){
        return this.root == null;
    }

    public void add(int element){
        if(isEmpty()) this.root = new Node(element);
        else{
            Node aux = this.root;            
            while(aux != null){
                if(element < aux.value){
                    if(aux.left == null){
                        aux.left = new Node(element);
                        aux.left.parent = aux;
                        return;  
                    }
                    aux = aux.left;
                } else {
                    if(aux.right == null){
                        aux.right = new Node(element);
                        aux.right.parent = aux;
                        return;
                    }
                    aux = aux.right;
                }
            }
        }
        this.size++;
    }

    public Node max(Node node){
        if(isEmpty()) return null;
        Node aux = node;
        while(aux.right != null)
            aux = node.right;
        return aux;
    }

    public Node search(int value){
        return search(this.root, value);
    }

    private Node search(Node node, int value){
        if(node == null) return null;
        if(node.value == value) return node;
        if(node.value > value) return search(node.left, value);
        return search(node.right, value);
    }

    public String predecessor(int value){
        Node node = search(value);
        ArrayList<Integer> caminho = new ArrayList<>();
        if(isEmpty()) return caminho.toString();
        caminho.add(value);
        if(node.left != null){
            Node aux = node.left;
            caminho.add(aux.value);
            while(aux.right != null){
                aux = aux.right;
                caminho.add(aux.value);
                }
        }else{
            Node aux = node.parent;
            caminho.add(aux.value);
            while(aux != null && aux.value > node.value){
                aux = aux.parent;
                caminho.add(aux.value);
            }
        }
        return caminho.toString();
    }

    static class Node{

        int value;
        Node parent;
        Node left;
        Node right;

        public Node(int value){
            this.value = value;
        }
    }

    public static void main(String[] args){ 
        Predecessor tree = new Predecessor();
        Scanner sc = new Scanner(System.in);
        String[] bst = sc.nextLine().split(" ");
        for(int i = 0; i < bst.length; i++)
            tree.add(Integer.parseInt(bst[i]));
        int num = sc.nextInt();
        sc.nextLine();
        System.out.println(tree.predecessor(num));
    }
}
