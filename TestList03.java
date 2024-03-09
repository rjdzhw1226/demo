public class TestList03 {

    /**
     * <p>平衡版二分查找</p>
     * @param a
     * @param target
     * @return
     */
    public int search(int[] a, int target){
        int i = 0, j = a.length;
        while(1 < j - i){
            int m = (i + j) >>> 1;
            if(target < a[m]){
                j = m;
            }else{
                i = m;
            }
        }
        return (a[i] == target) ? i : -1;
    }

    public int search01(int[] a, int target){
        int i = 0, j = a.length - 1;
        while(i <= j){
            int m = (i + j) >>> 1;
            if(target < a[m]){
                j = m - 1;
            } else if (a[m] < target) {
                i = m + 1;
            }else {
                return m;
            }
        }
        return -1;
    }

    public int search02(int[] a, int target){
        int i = 0, j = a.length - 1;
        while(i < j){
            int m = (i + j) >>> 1;
            if(target < a[m]){
                j = m;
            } else if (a[m] < target) {
                i = m + 1;
            }else {
                return m;
            }
        }
        return -1;
    }


    public int searchInsert(int[] a, int target){
        int low = 0;
        int height = a.length - 1;
        while (low <= height){
            int mid = (low + height) >>> 1;
            int midVal = a[mid];
            if(midVal < target){
                low = mid + 1;
            } else if (midVal > target) {
                height = mid - 1;
            }else {
                return mid;
            }
        }
        return low;
    }


    /**
     * <p>最左索引</p>
     * @param a
     * @param target
     * @return
     */
    public int searchInsert01(int[] a, int target){
        int i = 0, j = a.length - 1;
        while (i <= j){
            int m = (i + j) >>> 1;
            if(target <= a[m]){
                j = m - 1;
            }else {
                i = m + 1;
            }
        }
        return i;
    }

    public void climb(int[][] TwoInts, int x, int y, int m, int n, int k){
        int[][] check = new int[][]{{1,0},{-1,0},{0,1},{0,-1}};
        int value = TwoInts[x][y];
        for (int i = 0; i < check.length; i++) {
            int xc = x + check[i][0];
            int yc = y + check[i][1];
            if(TwoInts[xc][yc] > value){

            }
        }

        if(x < 0 || x > m || y < 0 || y > n){
            return;
        }


    }



}
