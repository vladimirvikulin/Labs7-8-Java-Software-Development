import list.MyList;
import java.util.Arrays;

import sweets.Candy;
import sweets.Lollipop;
import sweets.Sweet;
import sweets.Waffle;
public class App {
    public static void main(String[] args) {
        MyList list = new MyList();
        Candy sweet1 = new Candy("Candy1", 50.0, 1, 50, "Sweet", 30.0, true);
        Waffle sweet2 = new Waffle("Candy2", 40.0, 2, 0, "Chocolate", 50.0, "American");

        list.add(sweet1);
        list.add(sweet2);
        list.add(new Lollipop("Candy3", 60.0, 3, 75, "Fruity", 20.0, "Star"));
        list.add(new Sweet("Candy4", 45.0, 2, 25, "Sweet", 40.0));

        System.out.println("List contents:");
        for (Sweet sweet : list) {
            System.out.println(sweet.getDescription());
        }

        Sweet[] sweetsArray = {sweet1, sweet2};

        System.out.println("Contains all sweetsArray: " + list.containsAll(Arrays.asList(sweetsArray)));

        System.out.println("Array representation: " + Arrays.toString(list.toArray()));
        System.out.println("Element at index 0: " + list.get(0).getDescription());
    }
}
