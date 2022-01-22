public class Problem5 {
    public static int findNumber(int[] arrayInt, int target, int start, int end){
        if (start > end){
            return -1;
        }
        else{
            int mid = (start + end) / 2;
            if (arrayInt[mid] == target){
                return mid;
            }
            else{
                if (arrayInt[mid] > target){
                    return findNumber(arrayInt, target, mid + 1, end);
                }
                else{
                    return findNumber(arrayInt, target, start, mid - 1);
                }
            }
        }
    }

    public static void main(String[] args){
        int[] arrayInt = {33,23,22,21,30,10,9,8,7,6,3,2,1};
        System.out.println(findNumber(arrayInt, 3, 0, arrayInt.length-1));
        System.out.println(findNumber(arrayInt, -4, 0, arrayInt.length-1));
    }
}
