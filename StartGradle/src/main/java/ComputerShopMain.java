import com.google.common.collect.ArrayListMultimap;
import com.google.common.collect.Multimap;

public class ComputerShopMain {
    public static void main(String[] args){

        System.out.println("Exemplu Multimap de la google.guava");
        Multimap<String,String> map= ArrayListMultimap.create();
        map.put("cheia1", "valoarea 1");
        map.put("cheia1", "valoarea 2");
        map.put("cheia2", "valoare noua");
        System.out.println(map);
    }

}
