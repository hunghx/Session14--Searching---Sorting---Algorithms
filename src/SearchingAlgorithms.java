import java.util.Arrays;
import java.util.Comparator;
import java.util.Objects;

public class SearchingAlgorithms {
    public static void main(String[] args) {
        Person[] people = new Person[10];
        Person search = null;
        for (int i = 0; i < 10; i++) {
            Person p = new Person("hung "+(i+1));
            people[i] = p;
        }
        search = people[5];
        Comparator<Person> com = (a,b)->a.getName().compareTo(b.getName());

        int index = binarySearch(people,search); // 5

    }


    public static <T> int linearSearch(T[] array ,T value ){
        for (int i = 0; i < array.length; i++) {
            if (Objects.equals(array[i],value)){
                return  i;
            }
        }
        return -1;
    }
    public static <T extends Comparable<T>> int binarySearch(T[] arr, T value){
        // sắp  xếp
//        Arrays.sort(arr,comparator);
        Arrays.sort(arr);
        System.out.println(Arrays.toString(arr));

        int low = 0;
        int high = arr.length-1;
        while (low<=high){
            int mid = low + (high-low)/2; // vị trí chính giữa
            if(Objects.equals(arr[mid],value)){
                return mid;
            }
            if (arr[mid].compareTo(value)<0){
                low = mid+1;
            }else {
                high = mid-1;
            }
        }
        return -1;
    }
}
