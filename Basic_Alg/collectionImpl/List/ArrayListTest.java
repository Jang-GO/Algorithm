package collectionImpl.List;

public class ArrayListTest {
    public static void main(String[] args) throws CloneNotSupportedException{
        ArrayList<Integer> original = new ArrayList<>();
        original.add(10);


        ArrayList<Integer> copy = original;
        ArrayList<Integer> clone = (ArrayList<Integer>) original.clone();

        copy.add(20);
        clone.add(30);

        System.out.println(original.toString());
        System.out.println(copy.toString());
        System.out.println(clone.toString());

        System.out.println(original.hashCode());
        System.out.println(copy.hashCode());
        System.out.println(clone.hashCode());
    }
}
