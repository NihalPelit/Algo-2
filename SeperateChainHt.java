public class SeperateChainHt {

    Node[] list= new Node[10];

    public void put(String key,int val){
        Node n= new Node(key, val);
        int index= hash(key);

        if(list[index]==null){
            list[index]=n;
        }
        else{
            Node curr=list[index];
            while(curr.next!=null){
                curr=curr.next;
            }
            curr.next=n;
        }

        
    }

    public void displayAll(){

        for(int i=0;i<list.length;i++){

            Node curr=list[i];
            System.out.println("-------The "+i+". List-------");

            while(curr!=null){
                
                System.out.println(
                  "The city name is: " + curr.key+". The value is: " +hash(curr.key)
                );
                curr=curr.next;
            }
        }
    }
    
    public int hash(String key){
     int code=key.hashCode();
     return Math.abs(code)%list.length;

    }

    /*public Node searchItem(String key){
        int h= hash(key);

        if(list[h]==null){

        }
    }*/

    public void delete(String item){

        int h=hash(item);

        if(list[h]==null){ //if list is empty
            System.out.println("There is no such an item called "+ item);
        }
        else{ //if list is not empty
            Node pre=list[h];
            Node target= pre.next;

            if(pre.key.equals(item)){ //if head is target
                pre=null;
                list[h]=target;
            }
            else{ //if head is not target
                while(target!=null&& !target.key.equals(item)){ //until find the target
                    pre=pre.next;
                    target=target.next;
                    
                }
                if(target==null){ //if all nodes are visited and target  is not found
                    System.out.println("There is no such an item called "+ item);
                    return; //to quit from method
                }
                
                pre.next=target.next; //if target is found
                target=null;
            }

        }

    }


}

//Ya bu kodda ben hashcodeu görebilir miyim?