package slh.code;

public class SortDemo {

    //冒泡排序
    public static void bubbleSort(int[] numbers){
        int temp;
        int length = numbers.length;
        for (int i = 0; i < length; i++) {
            for (int j = 0; j < length-1; j++) {
                if(numbers[j]>numbers[j+1]){
                    temp = numbers[j+1];
                    numbers[j+1] = numbers[j];
                    numbers[j] = temp;
                }

            }
        }
    }

    //选择排序

    public static void main(String[] args) {
        int[] ints = {2, 4, 5, 1, 6, 3,23,55,25,7,9};
        bubbleSort(ints);
        System.out.println(ints);
    }
}
