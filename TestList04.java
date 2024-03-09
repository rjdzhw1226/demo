import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class TestList04 {
    public static void main(String[] args) {
//        double y;
//        for (double i = -100.00; i < 100.00; i = i + 0.01) {
//            y = Math.pow(i,2);
//        }
        TestList04 ts = new TestList04();
        //int[] ints = {1, 2, 3, 4, 1, 2, 3, 4};
        //ts.findCar(2, ints, ints[0]);
        List<String> list = new ArrayList<>();
        list.add("1 2");
        list.add("1 3");
        list.add("1 4");
        list.add("1 6");
        list.add("2 3");
        list.add("3 4");
        list.add("4 5");
        list.add("4 6");
        list.add("5 6");
        ts.findWorkFace(1,1,list);

    }

    /**
     *
     * @param n 车的数量
     * @param num 小朋友 1 2 3 1 3 2
     */
    public void findCar1(double n, int[] num){
        int i = 0;
        while (n > 0){
            int temp = num[i];
            for (int j = 0; j < num.length; j++) {
                if(temp == num[j]){
                    Move(num, j);
                    n -= 0.5;
                }
            }
            i++;
        }

    }

    public void findCar(double n, int[] num, int temp){
        if(n <= 0){
            int[] res = num == null ? new int[]{0} : num;
            System.out.println(Arrays.toString(res));
            return;
        }
        for (int j = 1; j < num.length; j++) {
            if(temp == num[j]){
                n -= 0.5;
                int[] ans = Move(num, j);
                if (ans == null) {
                    findCar(n, null, 0);
                } else {
                    findCar(n, ans, ans[0]);
                }
            }
        }
    }

    private int[] Move(int[] num, int j) {
        int[] check = Arrays.stream(num).filter(x -> x != num[j]).toArray();
        if(check.length == 0){
            return null;
        } else {
            return check;
        }
    }

    /*
     * 1 2
     * 2 3
     * 2 4
     * 3 4*/
    public void findWorkFace(int k, int n, List<String> list){
        List<int[]> result = new ArrayList<>();
        List<int[]> ans = new ArrayList<>();
        for (String s : list) {
            int[] num = new int[2];
            num[0] = Integer.parseInt(s.split(" ")[0]);
            num[1] = Integer.parseInt(s.split(" ")[1]);
            result.add(num);
            ans.add(num);
        }
        // 0 1
        findNo(result);
        //diguiFind(result, result.get(0), 1);
    }

//    private void findNo(List<int[]> result, List<int[]> ans) {
//        for (int i = 0; i < result.size(); i++) {
//
//        }
//    }

    class faceWorker{
        public int count;

        public boolean checkCount(){
            if(this.count >= 2){
                return false;
            } else {
                return true;
            }
        }
    }
    private void Printmin(List<int[]> list){
        List<String> list1 = new ArrayList<>();
        for (int[] ints : list) {
            list1.add(ints[0] + "," + ints[1]);
        }
        System.out.println(list1);
    }
    private List<int[]> findNo(List<int[]> result) {
        List<String> caList = new ArrayList<>();
        List<String> reList = new ArrayList<>();
        List<int[]> ans = new ArrayList<>();
        ans.addAll(result);
        if(result.size() == 1){
            Printmin(result);
            return result;
        }
        for (int i = 0; i < result.size(); i++) {
            int[] temp = result.get(i);
            if(i == result.size() - 1){

            } else{
                for (int j = i + 1; j < ans.size(); j++) {
                    if(temp[0] <= ans.get(j)[0] && temp[1] > ans.get(j)[0]){
                        int[] ints = Math.max((temp[1] - temp[0]), (ans.get(j)[1] - ans.get(j)[0])) > (temp[1] - temp[0]) ? temp : ans.get(j);
                        int[] intm = Math.max((temp[1] - temp[0]), (ans.get(j)[1] - ans.get(j)[0])) > (temp[1] - temp[0]) ? ans.get(j) : temp;
                        caList.add(ints[0] +","+ ints[1]);
                        reList.add(intm[0] +","+ intm[1]);
                    }
                }
            }
        }
        List<String> collect1 = reList.stream().distinct().collect(Collectors.toList());
        List<String> collect = caList.stream().distinct().collect(Collectors.toList());
        for (int i = 0; i < collect.size(); i++) {
            for (int j = 0; j < collect1.size(); j++) {
                if(collect.get(i).equals(collect1.get(j))){
                    collect.remove(i);
                }
            }
        }
        System.out.println(collect);
        List<int[]> digui = new ArrayList<>();
        for (String s : collect1) {
            int[] nums = new int[2];
            nums[0] = Integer.parseInt(s.split(",")[0]);
            nums[1] = Integer.parseInt(s.split(",")[1]);
            digui.add(nums);
        }
        return findNo(digui);
    }

    private void diguiFind(List<int[]> result, int[] ints, int index) {
        for (int i = index; i < result.size(); i++) {
            if(result.get(i)[0] <= ints[1] && result.get(i)[1] > ints[1]){
                index = i;
            }
        }
    }

    // 0 1 2 3 4 5 6 7 8 9 2
    // ^         ^         ^
    //
    public void findDuplicateOneBetter(int[] n){
        int left = 1;
        int right = n.length - 1;
        while(right > left){
            int mid = (left + right) >> 1;
            int count = 0;
            for (int i : n) {
                if(mid >= i){
                    count++;
                }
            }
            if(count > mid){
                right = mid;
            } else {
                left = mid  +1;
            }
        }
        System.out.println(right);
    }

    public void findDuplicateTwoBetter(int[] n){
        int slow = 0;
        int fast =0;
        slow = n[slow];
        fast = n[n[fast]];
        while(slow != fast){
            slow = n[slow];
            fast = n[n[fast]];
        }
        int b = fast;
        int a = 0;
        while (a != b){
            a = n[a];
            b = n[b];
        }
        System.out.println(a);
    }


}
