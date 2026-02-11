class ContaNosInternos{

    class Node

        int value;
        Node parent;
        Node left;
        Node right;

        public Node(int v){
            this.value = v;
        }
    }

    private Node root;

    public boolean isEmpty(){
        return root == null;
    }    

    public void add(int element){
        if(isEmpty()) {
            this.root = new Node(element);
            return;
        add(element, this.root)
    }

    private void add(int element, Node no){
        if(element < no.value){
            if(no.left == null){
                no.left = new Node(element);
                no.left.parent = no;
                return;
            }
            add(element, no.left);
        } else {
            if(no.right == null){
                no.right = new Node(element);
                no.right.parent = no;
                return;
            }
            add(element,no.right);
        }
    }

    public int countNosInternos(){
        if(isEmpty()) return 0;
        countNosInternos(this.root)
    }

    private int countNosInternos(){
        if(aux.left == null && aux.rigth == null)
            return 0;
        else if(aux.left != null && aux.rigth == null)
            return 1 + countNosInternos(aux.left);
        else if(aux.left == null && aux.right != null)
            return 1+ countNosInternos(aux.right);
        else
            return 1 + countNosInternos(aux.left) + countNosInternos(aux.right);
    }


}
