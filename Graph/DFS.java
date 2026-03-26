import java.util.LinkedList;
public class DFS {
    private boolean[] marked;
    private int[] edgeTo;
    private final int s; // starting vertex

    public DFS(Graph g, int s) {
        this.s = s;

        marked = new boolean[g.V()];
        edgeTo = new int[g.V()];

        dfs(g, s);
    }

    public void dfs(Graph g, int v){//verilerle gerekli kısımları doldurdu

        marked[v]=true;//1.şu an üstünde olduğumuz vertexi(v) marked True

        for(int i: g.adj(v)){ //tek tek v'nin komşularını kontrol et
        if(!marked[i]){//eğer komşuya gidilmemişse önce i'ye nerden gidildiğini(v) yaz ve komşu için fonksiyonu tekrar çağır
            edgeTo[i]=v;

            dfs(g, i);
        } }
        //visited ise iterator ile diğer komşuyu kontrol et
        }

    // Hedefe gidilecek yol var mı
    public boolean hasPathTo(int v) {
        return marked[v];
    }

    // Hedefe giden rotayı (path) ver
    public Iterable<Integer> pathTo(int v) { //v target

        if (!hasPathTo(v))
            return null; // Yol yoksa null 

        LinkedList<Integer> path = new LinkedList<>();

        // Hedef 'v' den başla, 'edgeTo' dizisine baka baka başlangıç noktası 's' ye
        // kadar geriye git!
        for (int x = v; x != s; x = edgeTo[x]) {//yani v'ye gidilen noktayı x'e ata
        path.addFirst(x); // Geçtiğin odaları yığına at
        }
        path.addFirst(s); // En son başlangıç noktasını da at

        return path; // Stack'i döndür (Stack LIFO olduğu için rotayı bize baştan sona doğru verecek)
        //yani ilk önce visit ettiğim node dan target'a kadar
    }
}
