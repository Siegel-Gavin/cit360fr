package code;

import java.util.*;

public class collections {

    public void mapEx(Map brands) {
        System.out.println("Brands: " + brands);

        //Find brand number from brand name
        System.out.println("The Brand with Honda" + brands.get("Honda"));
    }

    public void listEx(ArrayList<String> cars, LinkedList<String> carsLinked) {
        //Array list are for a simple or fast list
        System.out.println("Array List: " + cars);
        System.out.println("Linked List: " + carsLinked);

        //Array List can only add but can't chose the order
        cars.add("toyota");
        //Linkedlist can add in to the start or end
        carsLinked.addFirst("toyota");

        System.out.println("New Array List: " + cars);

        //LinkedList I can choose elements to be first or last making it easier to organize, however it is more memory intensive.
        System.out.println("New Linked List: " + carsLinked);
    }

    private void setEx(LinkedHashSet<String> cars) {
        //Print out the cars list
        System.out.println(cars);

        //Check for ford
        System.out.println("Do we have a ford \n Answer: " + cars.contains("ford"));


        //How many brands do we have
        System.out.println("There are " + cars.size() + "brands");

        //Lets remove honda
        cars.remove("honda");

        System.out.println("Brands: " + cars);
    }

    public void treeEx(TreeMap<Integer, String> brands) {
        //Trees are used to put things in order
        System.out.println("Brands in order: " + brands);
        System.out.println("Brands in reverse order" + brands.descendingMap());
    }

    public void main() {
        //collections
        Map brands = new HashMap();
        ArrayList<String> itemArrayList = new ArrayList<>();
        LinkedList<String> itemLinkedList = new LinkedList<>();
        LinkedHashSet<String> cars = new LinkedHashSet<>();
        TreeMap<Integer, String> carsTree = new TreeMap<>();

        //adding items for hash map
        brands.put("ford", "Brand 1");
        brands.put("toyota", "Brand 2");
        brands.put("chevy", "Brand 3");
        brands.put("honda", "Brand 4");
        brands.put("subaru", "Brand 5");

        //strings for list
        itemArrayList.add("toyota");
        itemArrayList.add("ford");
        itemArrayList.add("chevy");
        itemLinkedList.add("toyota");
        itemLinkedList.add("ford");
        itemLinkedList.add("chevy");

        //add objects to the hash set
        cars.add("toyota");
        cars.add("ford");
        cars.add("chevy");
        cars.add("honda");
        cars.add("subaru");

        //Adding items to the tree map. This is similar to the map but all items will be ordered automatically
        carsTree.put(2, "toyota");
        carsTree.put(1, "ford");
        carsTree.put(4, "honda");
        carsTree.put(5, "subaru");
        carsTree.put(3, "chevy");

        //Print
        System.out.println("\n*********************************\n");
        System.out.println("Brands in a map: \n");
        mapEx(brands);

        System.out.println("\n*********************************\n");
        System.out.println("cars in a list: \n");
        listEx(itemArrayList, itemLinkedList);

        System.out.println("\n*********************************\n");
        System.out.println("Brands in a set: \n");
        setEx(cars);

        System.out.println("\n*********************************\n");
        System.out.println("Brands in a tree: \n");
        treeEx(carsTree);


    }
}