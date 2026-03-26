//hazır test alanı  

public class Main {
    public static void main(String[] args) {
        
        // 1. 5 düğümlü (0'dan 4'e kadar) boş bir graph yaratıyoruz
        int vertexSayisi = 5;
        Graph G = new Graph(vertexSayisi);
        
        // 2. Kenarları (bağlantıları) ekliyoruz
        // 0 numaralı düğümü çok sosyal yapalım
        G.addEdge(0, 1);
        G.addEdge(0, 2);
        G.addEdge(0, 3);
        
        // Diğerleri arasında da birkaç yol olsun
        G.addEdge(1, 2); 
        G.addEdge(3, 4); 
        
        // 3. Graph'ın genel durumunu yazdıralım
        System.out.println("Graph oluşturuldu!");
        System.out.println("Toplam Düğüm (V): " + G.V());
        System.out.println("Toplam Kenar (E): " + G.E());
        System.out.println("-------------------------");
        
        // 4. 0 numaralı düğümün komşularını senin o yazdığın Iterator ile gezelim!
        System.out.print("0 numaralı düğümün komşuları: ");
        for (int komsu : G.adj(0)) {
            System.out.print(komsu + " ");
        }
        System.out.println("\n-------------------------");
        
        // 5. maxDegree test edelim
        System.out.println("En yüksek komşu sayısı (maxDegree): " + G.maxDegree());
        
        // İsteğe bağlı: Hangi düğümün en yüksek dereceye sahip olduğunu da bulabiliriz
        int enPopulerDugum = 0;
        for (int i = 0; i < G.V(); i++) {
            if (G.deg(i) == G.maxDegree()) {
                enPopulerDugum = i;
                break; // İlk bulduğumuzu alalım
            }
        }
        System.out.println("Bu rekora sahip düğüm: " + enPopulerDugum);


        //----------DFS TEST-----------//
        System.out.println("----------DFS TEST-----------");
        Graph G2 = new Graph(6);
        
        // 2. Yolları çiziyoruz
        G2.addEdge(0, 1);
        G2.addEdge(0, 2);
        G2.addEdge(1, 3);
        G2.addEdge(1, 4);
        G2.addEdge(3, 2);
        G2.addEdge(vertexSayisi, enPopulerDugum);
        
        // Dikkat: 5 numaralı odayı bilerek KİMSESİZ bıraktık, hiçbir yere bağlamadık!
        
        // 3. DFS Macerasını 0 numaralı odadan BAŞLAT!

        int baslangicNoktasi = 0;
        DFS dfsMacerasi = new DFS(G2, baslangicNoktasi);
        
        System.out.println("--- DFS ROTASI TESTİ ---");
        
        // 4 numaralı hedefe gidelim
        int hedef1 = 4;
        if (dfsMacerasi.hasPathTo(hedef1)) {
            System.out.print(baslangicNoktasi + " noktasından " + hedef1 + " noktasına yol: ");
            for (int x : dfsMacerasi.pathTo(hedef1)) {
                if (x == baslangicNoktasi) System.out.print(x);
                else System.out.print(" -> " + x);
            }
            System.out.println();
        } else {
            System.out.println(hedef1 + " numaralı odaya yol YOK!");
        }

        // 5 numaralı kimsesiz hedefe gitmeyi deneyelim
        int hedef2 = 5;
        if (dfsMacerasi.hasPathTo(hedef2)) {
            System.out.println("İnanılmaz ama 5'e yol var!");
        } else {
            System.out.println(hedef2 + " numaralı oda kimsesiz, oraya yol YOK!");
        }
    }
}
