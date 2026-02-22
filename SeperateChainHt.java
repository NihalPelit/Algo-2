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


}

//Ya bu kodda ben hashcodeu görebilir miyim?