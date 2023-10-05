import java.time.LocalDateTime;
import java.time.temporal.ChronoUnit;
import java.util.Arrays;
import java.util.List;
import java.util.Objects;
import java.util.Random;
import java.util.function.Supplier;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class Main {
    public static void main(String[] args) {
        Random random = new Random();

        List<Integer> list = Stream.generate(()->random.nextInt(100000)).distinct().limit(100000).collect(Collectors.toList());
//        System.out.println(arr);
//
//        int index = findIndex(arr,100);
//        int index1 = findIndex(arr,1000);
//        int index2 = findIndex(arr,190);
//        int index3 = findIndex(arr,200);
//        int index4 = findIndex(arr,500);
//        System.out.println(index);
        Integer[] arr = list.toArray(new Integer[100000]);
        Arrays.sort(arr);

        System.out.println(Arrays.toString(arr));
        int index = binarySearch(arr,99994);
        System.out.println(index);





    }

    public static int findIndex(List<Integer> list,Integer value){
        // thuật toán tìm kiếm tuyến tính  (tuần tự)
        int index = -1;
//        long t1 = System.currentTimeMillis();
        for (int i = 0; i < list.size(); i++) {
            if(Objects.equals(list.get(i), value)){
                 index = i;
                 break;
            }
        }
//        long t2 = System.currentTimeMillis();
//        long mili = t2-t1;
//        System.out.println(index);
//        System.out.println("Thời gian thực hiẹn thuật toán tìm kiếm là "+mili);
        return index;
    }

    public static int binarySearch(Integer[] arr , int value){ // ko đệ qui
        int low = 0;
        int high = arr.length-1;
        while (low<=high){
            int mid = low + (high-low)/2; // vị trí chính giữa
            if(value == arr[mid]){
                return mid;
            }
            if (value > arr[mid]){
                low = mid+1;
            }else {
                high = mid-1;
            }
        }
        return -1;
    }
    public static int binarySearchDQ(Integer[] arr,int low, int high , int value){ // có đệ qui
            if(low<=high) {
                int mid = low+ (high-low)/2; // vị trí chính giữa
                if (value == arr[mid]) {
                    return mid;
                }
                if (value > arr[mid]) {
                    return binarySearchDQ(arr, mid + 1, high, value);
                } else {
                    return binarySearchDQ(arr, low, mid - 1, value);
                }
            }
            return -1;
    }

// xây dựng giải thuật tìm kiếm tuyến tính và nhị phân trên 1 Array kiểu dữ liệu Generic
}