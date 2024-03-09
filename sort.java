public class sort {
    public static void insert(int[] a, int low){
        if(low == a.length){
            return;
        }

        int t = a[low];
        int i = low - 1;

        while(i >= 0 && a[i] > t){
            a[i + 1] = a[i];
            i --;
        }

        a[i + 1] = t;
        insert(a, low + 1);
    }
}
