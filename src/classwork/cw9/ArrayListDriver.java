package classwork.cw9;

public class ArrayListDriver {

    public static void main(String[] args) {
        Integer[] integerArray1 = {2, 3, 4, 5, 6, 7, 8};
        Integer[] integerArray2 = {4, 5, 6};
        Integer[] integerArray3 = {2, 3, 4, 5, 6, 7, 8};
        ArrayList<Integer> integerList1 = new ArrayList<Integer>(integerArray1);
        ArrayList<Integer> integerList2 = new ArrayList<Integer>(integerArray2);
        ArrayList<Integer> integerList3 = new ArrayList<Integer>(integerArray3);

        System.out.println("integerList1: " + integerList1.toString());
        System.out.println("integerList2: " + integerList2.toString());
        System.out.println("integerList3: " + integerList3.toString());
        System.out.println("\tintegerList1.equals(integerList3) -> " + integerList1.equals(integerList3));
        integerList1.addAll(integerList2);
        System.out.println("\tintegerList1.addAll(integerList2) -> " + integerList1.toString());
        System.out.println("\tintegerList1.containsAll(integerList3) -> " + integerList1.containsAll(integerList3));
        System.out.println("\tintegerList1.lastIndexOf(4) -> " + integerList1.lastIndexOf(4));
        System.out.println("\tintegerList1.lastIndexOf(16) -> " + integerList1.lastIndexOf(16));
        integerList1.remove(7);
        System.out.println("\tintegerList1.remove(7) -> " + integerList1.toString());
        integerList1.removeAll(integerList2);
        System.out.println("\tintegerList1.removeAll(integerList2) -> " + integerList1.toString());
        integerList1.addAll(2, integerList2);
        System.out.println("\tintegerList1.addAll(2, integerList2) -> " + integerList1.toString());
        integerList1.retainAll(integerList2);
        System.out.println("\tintegerList1.retainAll(integerList2) -> " + integerList1.toString());
        System.out.println("\tintegerList1.equals(integerList2) -> " + integerList1.equals(integerList2));
    }
}
