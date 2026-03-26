public class Graph {
    Bag<Integer>[] adj;
    private int V; // number of vertices
    private int E; //number ofedges 

    public Graph(int V) { // Her bir Graph objesi oluşturulduğunda vertex sayısı kadar elemana sahip bir
                          // Bag List oluşması lazım, ve her bir vertex komuşu vertexlerini tutan Bag'ler
                          // olmalı

        this.V = V;
        adj = (Bag<Integer>[]) new Bag[V]; // new Bag<Integer>[] yazamamamızın sebebi tamamen Java'nın eskiden kalan
                                           // "Type Erasure" mimarisidir ve dünyadaki en profesyonel Java projelerinde
                                           // bile (Java'nın kendi ArrayList kaynak kodunda dahil) bu "Casting" yöntemi
                                           // mecburen kullanılır.

        for (int i = 0; i < V; i++) {
            adj[i] = new Bag<Integer>(); // her bir dizi elemanına bag tanımlaması yapıyoruz, V tane Bag oluşturuluyor
        }

    }

    public int V(){return V;}
    public int E(){return E;}



    public void addEdge(int v,int w){ //yani v nolu vertex ile w nolu vertexi komuşu yap, yani komşu listelerine(bag) ekle
        adj[v].add(w);
        adj[w].add(v);
        E++;

    }

    public Iterable<Integer> adj(int v){ //v nolu vertexin listelerini getir
      return adj[v];
    }

    public int deg(int v){
        // Bag sınıfındaki size() metodu sayesinde O(1) sürede
        return adj[v].size();

    }

    public int maxDegree(){
        int max=0;

        for(int i=0;i<V;i++){
            if(deg(i)>max)
                max=deg(i);
        }

        return max;
    }

}
