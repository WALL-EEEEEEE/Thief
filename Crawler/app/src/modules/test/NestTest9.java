public class NestTest9{


     public static void main(String args[]){

          Link link = new Link();
          link.add("A");
          link.add("B");
          link.add("C");
          link.add("D");
          link.add("E");
          link.print();

     }




};


class Link{

     class Node{

          private String name;
          private Node next;

          public Node(String name){
               this.name = name;


          }


          public void addNode(Node newNode){

               if(this.next ==null){

                    this.next = newNode;//保存节点

               }else{

                    this.next.addNode(newNode);
               }

          }

          public void printNode(){

               System.out.println(this.name);
               if(this.next!=null){
                   this.next.printNode();
               }

          }



     };



private Node root;//链表的头

public void add(String name){

     Node newNode = new Node(name);

     if(this.root == null){

         this.root = newNode;
     }else{

         this.root.addNode(newNode);
     }

    }



public void print(){
     if(this.root!=null) { //如果根节点为空

          this.root.printNode();
     }

}

};



