public class Main {
    public static void main(String[] args) {

        ArrayStack<Integer> list1 = new ArrayStack<>();
        ArrayStack<Integer> list2 = new ArrayStack<>();

        list1.push(1);
        list1.push(1);
        list1.push(1);

        list1.push(1);
        list1.push(2);
        list1.push(2);

        ArrayStack<Integer> mergedArray = new ArrayStack<>();
        mergedArray.merge(list1,list2);
        mergedArray.display();
    }
}