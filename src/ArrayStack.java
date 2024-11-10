import java.util.Arrays;
import java.util.EmptyStackException;


// ID: C1220270
// Name : Mos'ab Bashir Hassan

    public class ArrayStack <T> {
        private final static int DEFAULT_CAPACITY = 2;
        private int top;
        private T[] stack;

        ArrayStack(int capacity){
            stack = (T[]) new Object[capacity];
            top = 0;
        }

        ArrayStack(){
            this(DEFAULT_CAPACITY);
        }

        int size(){
            return top;
        }

        boolean isEmpty(){
            return stack.length == 0;
        }

        void push(T element){
            if (size() == stack.length){
                expand();
            }
            stack[top] = element;
            top++;
        }

        T pop() throws EmptyStackException {
            if (isEmpty()){
                throw new EmptyStackException();
            }
            top--;
            T result = stack[top];
            stack[top] = null;
            return result;
        }

        T peek() throws EmptyStackException{
            if (isEmpty())
                throw new EmptyStackException();
            return stack[top - 1];
        }

        void expand(){
            stack = Arrays.copyOf(stack, stack.length * 2);
        }

        void display(){
            for (int i = top -1 ; i >= 0; i--){
                System.out.println(stack[i]);
            }
        }

        private Boolean Duplicate(ArrayStack list , T element){

            for (int i = 0; i < list.size(); i++){
                if (list.stack[i].equals(element))
                    return true;
            }

            return false;
        }

        public void merge(ArrayStack<T> list1 , ArrayStack<T> list2){

            // how many elements are in the lists :
            int size = list1.size() + list2.size();

//      checking if stack is less than the size
            if (stack.length < size)
                stack = Arrays.copyOf(stack,size);

//      check if list 1 is in duplicates values

            for (int i = 0; i < list1.size(); i++){
//          check if Duplicate is in the list 1
                if (!Duplicate(this, list1.stack[i]))
                    this.push(list1.stack[i]);

            }

//        checking if list 2 is in duplicates values

            for (int i = 0; i < list2.size(); i++){
//            check if duplicate is in the list 2
                if (!Duplicate(this,list2.stack[i]))
                    this.push(list2.stack[i]);
            }
        }
    }


