//Prueba Logica - Algoritmo 1 Freya Lopez

public class Algoritmo_1 {

    public static int sumSub(int[] nums) {
        int sumBest = nums[0];
        int sumTotal = nums[0];
        for (int i = 1; i < nums.length; i++) {
            sumTotal = Math.max(nums[i], sumTotal + nums[i]);
            sumBest = Math.max(sumBest, sumTotal);
        }
        return sumBest;
    }
}
