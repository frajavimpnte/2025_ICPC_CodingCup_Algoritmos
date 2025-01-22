/*
*   ITESS-TICS 2025
*   ICPC-CP SRPING JAKARTA
*   by FJMP
*   Array example
*   Programmer: FJMP
*   22/enero/2025
*
*  javac E01Array.java
*        cmd: java E01Array
*         ps: java E01Array
*  linux mac: java E01Array
*/

public class E01Array {
    public static void main(String[] args) {
        int[] arr = new int[10];

        arr[0] = 1;
        System.out.println("First element:" + arr[0]);

        int[] arr2 = {1,2,3,4};
        System.out.println("Elements in second array:");
        for (int i = 0; i < arr2.length; i++)
            System.out.print(arr2[i] + " ");
        System.out.println();

        try {
            int a = arr2[4];
            int b = arr2[5];
        } catch (Exception ex) {
            System.out.println("EXCEPTION: " + ex.getMessage());
        }
    }
}