import java.util.Iterator; //interface
import java.util.NoSuchElementException;

public class Bag<Item> implements Iterable<Item> {

    // DÜZELTME 1: Dışarıdan kimse erişemesin diye private yaptık
    private Node<Item> head;// her bir Bag'in başı
    private int size;

    // DÜZELTME 1: Sadece Bag sınıfı görsün diye private yaptık
    private static class Node<Item>{ //Dış dünyadaki hiçbir sınıf (Graph, Main vs.) bu Node'un varlığından haberdar değil. Sadece ve sadece Bag sınıfı bu düğümleri görebilir. Node sınıfı Bag'in özel malı olduğu için, Bag sınıfı onun içindeki item ve next değişkenlerine (private olsalar bile) doğrudan erişme yetkisine sahiptir.
        Node<Item> next;
        Item item;
    }

    public Bag(){
        head=null;
        size=0;
        
    }

    public boolean isEmpty(){
        return head==null;
    }

    public int size(){
        return size;
    }

    public void add(Item item){ //addFirst O(1)
        Node<Item> oldHead=head;
        head= new Node<Item>();
        head.item=item;
        head.next=oldHead;
        size++;

    }

    // DÜZELTME 2: Java'ya verdiğimiz sözü tutuyoruz ve Tur Rehberini (Iterator) dışarıya veren o zorunlu metodu ekliyoruz!
    public Iterator<Item> iterator() {
        return new LinkedIterator(head); // Rehbere başlangıç noktası olarak head'i veriyoruz
    }

    private class LinkedIterator implements Iterator<Item> { //for each döngüsü için bir Iterator, for each döngüsünü kullanmamız için şart kendimiz yazsaydık for each tanımazdı(next hasNext şart fonksiyonlar)
        // while ile de gezebilirdin ama Node sınıfını private yaptık, encapsulation, Iterator ile sadece verileri veriyoruz
        private Node<Item> current;

        public LinkedIterator(Node<Item> head) { //constructor
            current = head;
        }

        // Gidecek başka eleman var mı?
        public boolean hasNext() {
            return current != null;
        }

        // Silme işlemi Bag'de desteklenmez, bu yüzden boş bırakıyoruz
        public void remove() {
            throw new UnsupportedOperationException();
        }

        // Sıradaki elemanı ver ve bir sonrakine geç
        public Item next() { 
            if (!hasNext()) throw new NoSuchElementException();

            //hasNext true ise veriyi gönder
            Item item = current.item; // Şu anki veriyi al
            current = current.next;   // Ok'u bir sonrakine kaydır
            return item;              // Veriyi döndür, 15i for each döngüsüne gönder
        }
    }
    
}
