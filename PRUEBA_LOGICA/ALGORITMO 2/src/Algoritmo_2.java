//Prueba Logica - Algoritmo 2 Freya Lopez

import java.lang.reflect.Array;
import java.util.Arrays;

public class Algoritmo_2 {
    public static  int triplet(int[] nums){
        Arrays.sort(nums);
        int n=nums.length;
        int one = nums[n-1] * nums[n-2] * nums[n-3];
        int two = nums[0] * nums[1] * nums[n-1];

        return Math.max(one, two);
    }
}
