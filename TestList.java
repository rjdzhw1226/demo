
import com.sun.org.apache.bcel.internal.generic.I2C;

import java.util.*;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class TestList {
  public static void main(String[] args) {
    TestList t =new TestList();
    int[] i = new int[]{0,1,2,3,4,5,6,7,8,9,10};
    int[] i1 = new int[]{0,1,2,3,4,5,6,7,8};
    String s1 = "(){}[]]";
    String[] s = new String[]{"fcy","flight","flv"};
    boolean valid = isValid(s1);
//    List<String> strings = t.letterCombinations("23");
//    Integer[] integers = twoSum(i, 12);
//    SortString("abccc12334456");
//    List<Integer> collect = Arrays.stream(integers).collect(Collectors.toList());
//    int i1 = arithmeticTriplets(i, 2);
//    ExcelNumber(124);
//    t.threeSumClosest(i,14);
//    List<Integer> list = t.SortNums(i1, 15);
//    int i1 = t.myAtoi("   -00123   ");
//    t.intToRoman(1346);
//    t.longestCommonPrefix(s);
//    t.romanToInt("MCCCXLVI");
//    int i1 = t.maxArea(i);
//    t.reverse(123);
//    String paypalishring = t.convert("PAYPALISHIRING", 3);
//    List<String> strings = t.childrenString("abcddcba");
//    TenetString(strings);
//    ListNode l = new ListNode(2);
//    ListNode l1 = new ListNode(4);
//    ListNode l2 = new ListNode(3);
//    l.next = l1;
//    l1.next = l2;
//    ListNode l3 = new ListNode(5);
//    ListNode l4 = new ListNode(6);
//    ListNode l5 = new ListNode(4);
//    l3.next =l4;
//    l4.next =l5;
//    ListNode listNode = TestList.addList(l, l3);
    System.out.println(valid);
  }

  public static ListNode addList(ListNode l1,ListNode l2){
    ListNode listResultCur = new ListNode(0);
    ListNode listResult = listResultCur;
    ListNode list1 = l1;
    ListNode list2 = l2;
    int sum = 0;
    while (l1 != null || l2 != null){
      if(l1 == null){
        l1.val = 0;
      }
      if(l2 == null){
        l2.val = 0;
      }
      int carry = (l1.val + l2.val) + sum;
      sum = carry / 10;
      carry = carry % 10;

      listResult.next = new ListNode(carry + sum);
      listResult = listResult.next;
      if(l1 != null){
        l1 = l1.next;
      }
      if(l2 != null){
        l2 = l2.next;
      }
    }
    if(sum == 1){
      listResult.next = new ListNode(sum);
    }
    return listResultCur.next;

  }

  /**
   * 合并两个有序链表
   * @param list1
   * @param list2
   * @return
   */
  public ListNode mergeTwoLists(ListNode list1, ListNode list2) {
    // TODO 链表合并
    return new ListNode(0);
  }

  /**
   * 数字 n 代表生成括号的对数，请你设计一个函数，用于能够生成所有可能的并且 有效的 括号组合。
   * @param n
   * @return
   */
  public List<String> kuoHao(int n){
    List<String> res = new ArrayList<>();
    if (n <= 0) {
      return res;
    }
    kuoHaoDiGui(n,"",res,0,0);
    System.out.println(res);
    return res;
  }
  private static void kuoHaoDiGui(int n, String s, List<String> res, int i, int i1) {
    if(i > n || i1 > i){
      return;
    }
    if(s.length() == 2 * n){
      res.add(s);
      return;
    }
    kuoHaoDiGui(n,s+"(",res,i+1,i1);
    kuoHaoDiGui(n,s+")",res,i,i1+1);
  }
  /**
   * 删除链表的倒数第n个结点
   * @param head
   * @param n
   * @return
   */
  public ListNode removeNthFromEnd(ListNode head, int n) {
    ListNode pre = new ListNode(0);
    pre.next = head;
    ListNode start = pre, end = pre;
    while(n != 0) {
      start = start.next;
      n--;
    }
    while(start.next != null) {
      start = start.next;
      end = end.next;
    }
    end.next = end.next.next;
    return pre.next;
  }

  /**
   * 对字符串中字符出现的次数排序输出
   * @param str
   * @return
   */
  public static String SortString(String str){
    List<Character> collect = str.chars().mapToObj(item -> (char) item).distinct().collect(Collectors.toList());
    List<String> list = new ArrayList<>();
    char[] chars = str.toCharArray();
    for (Character character : collect) {
      int i = 0;
      for (char aChar : chars) {
        if(aChar == character){
          i++;
        }
      }
      list.add(character+"/"+String.valueOf(i)+"");
    }
    Collections.sort(list, new Comparator<String>() {
      @Override
      public int compare(String o1, String o2) {
        int sc = 0;
        int i = Integer.valueOf(o2.split("/")[1]) - Integer.valueOf(o1.split("/")[1]);
        if(i != 0){
          sc = (i > 0) ? 2 : -2;
        }else{
          i = o1.split("/")[0].charAt(0) - o2.split("/")[0].charAt(0);
          if(i != 0){
            sc = (i > 0) ? 1 : -3;
          }
        }
        return sc;
      }
    });
    StringBuilder s1 = new StringBuilder();
    for (String s : list) {
      s1.append(s.split("/")[0]);
    }
    return s1.toString();
  }

  /**
   * 对map里的char排序
   * @param map
   * @return
   */
  public static List<Character> Map2Max(Map<Character,Integer> map){
    List<Character> list = new ArrayList<>();
    while (!map.isEmpty()){
      int maxValue = 0;
      Character maxNumber = null;
      Set<Character> characters = map.keySet();
      for (Character character : characters) {
        Integer integer = map.get(character);
        if(integer > maxValue){
          maxNumber = character;
          maxValue = integer;
        }
      }
      list.add(maxNumber);
      map.remove(maxNumber);
    }
    return list;
  }

  /**
   * 最长回文子串
   * @param s
   * @return
   */
  public String longestPalindrome(String s) {
    if(s.length() <= 1){
      return s;
    }
    for(int i = s.length();i > 0; i--){
      for (int j = 0; j <= s.length() - i; j++) {
        String sub = s.substring(i , i + j);
        int count = 0;
        for(int k = 0; k < sub.length() / 2; k++){
          if(sub.charAt(k) == sub.charAt(sub.length() - k - 1)){
            count++;
          }
        }
        if(count == sub.length() / 2){
          return sub;
        }
      }
    }
    return "";
  }

  public int myAtoi(String s) {
    Boolean flag = false;
    Character fg = null;
    String trim = s.trim();
    char[] chars = trim.toCharArray();
    if(chars[0] == '-' || chars[0] == '+'){
      fg = chars[0];
      flag = true;
    }
    if(flag == true){
      int length = 0;
      for (int i = 1; i < chars.length; i++) {
        if(chars[i] < 48 || chars[i] > 57){
          break;
        }
        length++;
      }
      StringBuilder sc = new StringBuilder();
      for (int i = 1; i <= length; i++) {
        sc.append(chars[i]);
      }
      String st = new String(sc);
      if(st.isEmpty()){
        return 0;
      }
      Integer integer = Integer.valueOf(fg + sc.toString());
      if(integer > 2147483647  || integer < -2147483647){
        return Integer.valueOf(fg + "2147483647");
      }
      return integer;
    }else{
      int length = 0;
      for (int i = 0; i < chars.length; i++) {
        if(chars[i] < 48 || chars[i] > 57){
          break;
        }
        length++;
      }
      StringBuilder sc = new StringBuilder();
      for (int i = 0; i <= length; i++) {
        sc.append(chars[i]);
      }
      String st = new String(sc);
      if(st.isEmpty()){
        return 0;
      }
      Integer integer = Integer.valueOf(sc.toString());
      if(integer > 2147483647){
        return Integer.valueOf("2147483647");
      }
      return integer;
    }
  }

  /**
   * 回文数
   * @param x
   * @return
   */
  public boolean isPalindrome(int x) {
    String s = String.valueOf(x);
    StringBuilder sb = new StringBuilder(s);
    StringBuilder sr = sb.reverse();
    if(s.equals(sr)){
      return true;
    }
    return false;
  }

  /**
   * 最大盛水容积
   * @param height
   * @return
   */
  public int maxArea(int[] height) {
    int fir = 0;
    int las = height.length - 1;
    int result = 0;
    int tempSqr = 0;
    while(fir != las){
      result = Math.max(result, Math.abs(fir - las) * Math.min(height[fir], height[las]));
      if(height[fir] < height[las]){
        fir = fir + 1;
      }
      if(height[fir] > height[las]){
        las = las - 1;
      }
    }
    return result;
  }

  /**
   * 寻找字符串数组中的最长公共前缀
   * {"fly","flight","flv"}
   * @param strs
   * @return
   */
  public String longestCommonPrefix(String[] strs) {
    List<Integer> count = new ArrayList<>();
    for (int i = 0; i < strs.length; i++) {
      for (int j = 0; j < strs.length; j++) {
        String str1 = strs[i];
        String str2 = strs[j];
        char[] chars1 = str1.toCharArray();
        char[] chars2 = str2.toCharArray();
        if(i < j){
          int k = 0;
          while(chars1[k] == chars2[k]){
            k++;
          }
          count.add(k);
        }
      }
    }
    System.out.println(count);
    return "";
  }

  /**
   * 罗马数字转整数
   * @param s
   * @return
   */
  //MCCCXLVI
  public int romanToInt(String s) {
    char[] chars = s.toCharArray();
    int sc = 0;
    for (int i = 0; i < chars.length; i++) {
      int value = getValue(chars[i]);
      if(i != chars.length - 1){
        if (getValue(chars[i]) < getValue(chars[i+1])) {
          sc = sc - value;
        }else {
          sc = sc + value;
        }
      }else {
        sc = sc + getValue(chars[i]);
      }
    }
    System.out.println(sc);
    return sc;
  }

  private int getValue(char ch) {
    switch (ch) {
      case 'I':
        return 1;
      case 'V':
        return 5;
      case 'X':
        return 10;
      case 'L':
        return 50;
      case 'C':
        return 100;
      case 'D':
        return 500;
      case 'M':
        return 1000;
      default:
        return 0;
    }
  }
  /**
   * 整数转罗马数字
   * @param num
   * @return
   */
  public String intToRoman(int num) {
    List<Integer> list = new ArrayList<>();
    List<String> listC = new ArrayList<>();
    int i = 0;
    while (num != 0) {
      int sc = num % 10;
      list.add((int)(sc * Math.pow(10.0,i)));
      num = num / 10;
      i++;
    }
    for (Integer integer : list) {
      if(integer == 4 || integer == 9){
        listC.add(integer == 4 ? "IV" : "IX");
      } else if (integer == 40 || integer == 90){
        listC.add(integer == 40 ? "XL" : "XC");
      } else if (integer == 400 || integer == 900) {
        listC.add(integer == 400 ? "CD" : "CM");
      } else if (5 > integer) {
        StringBuilder sb = new StringBuilder();
        for (int j = 0; j < integer; j++) {
          sb.append("I");
        }
        listC.add(sb.toString());
      } else if (5 <= integer && integer < 10) {
        StringBuilder sb = new StringBuilder();
        sb.append("V");
        for (int j = 0; j < integer - 5; j++) {
          sb.append("I");
        }
        listC.add(sb.toString());
      } else if (10 <= integer && integer < 50) {
        StringBuilder sb = new StringBuilder();
        int sub = integer / 10;
        for (int j = 0; j < sub; j++) {
          sb.append("X");
        }
        listC.add(sb.toString());
      } else if (50 <= integer && integer < 100) {
        StringBuilder sb = new StringBuilder();
        int min = integer - 50;
        int sub = min / 10;
        sb.append("L");
        for (int j = 0; j < sub; j++) {
          sb.append("X");
        }
        listC.add(sb.toString());
      } else if (100 <= integer && integer < 500) {
        StringBuilder sb = new StringBuilder();
        int sub = integer / 100;
        for (int j = 0; j < sub; j++) {
          sb.append("C");
        }
        listC.add(sb.toString());
      } else if (500 <= integer && integer < 1000) {
        StringBuilder sb = new StringBuilder();
        int min = integer - 500;
        int sub = min / 100;
        sb.append("D");
        for (int j = 0; j < sub; j++) {
          sb.append("C");
        }
        listC.add(sb.toString());
      } else {
        StringBuilder sb = new StringBuilder();
        int sub = integer / 1000;
        for (int j = 0; j < sub; j++) {
          sb.append("M");
        }
        listC.add(sb.toString());
      }
    }
    System.out.println(list);
    System.out.println(listC);
    return "";
  }
  /**
   * 两个字符串每个字符出现频率都一样 称为异位字符串
   */
  public Boolean TwoString(String str1, String str2){
    char[] chars1 = str1.toCharArray();
    char[] chars2 = str2.toCharArray();
    Arrays.sort(chars1);
    Arrays.sort(chars2);
    int length = chars1.length >= chars1.length?chars2.length: chars1.length;
    if(chars1.length != chars2.length){
      return false;
    }else{
      for (int i = 0; i < length; i++) {
        if(chars1[i] != chars2[i]){
          return false;
        }
      }
    }
    return true;
  }

  /**
   * 数字反转
   * @param x
   * @return
   */
  public int reverse(int x) {
    List<Integer> list = new ArrayList<>();
    int sc = 0;
    int y = 0;
    while(x!=0){
      sc = x % 10;
      list.add(sc);
      x = x / 10;
    }
    for (int i = 0; i < list.size(); i++) {
      if((y == 214748364 && list.get(i) > 7)|| (y <= -214748364 && list.get(i) < -8)){
        return 0;
      }
      if(y > 214748364 || y <= -214748364){
        return 0;
      }
      y = (int) (list.get(i) * Math.pow(10.0, (list.size() - i - 1))) + y;
    }
    return y;
  }

  /**
   * N字回转字符串
   * @param s
   * @param numRows
   * @return
   */
  public String convert(String s, int numRows) {
    char[] chars = s.toCharArray();
    List<StringBuilder> list = new ArrayList<>();
    for (int i = 0; i < numRows; i++) {
      list.add(i,new StringBuilder());
    }
      int i=0 ,sc = -1;
      for (char aChar : chars) {
        list.get(i).append(aChar);
        if(i == 0 || i == numRows - 1){
          sc = -sc;
        }
        i = i + sc;
      }
      String s1 = "";
    for (StringBuilder stringBuilder : list) {
      s1 = s1 + stringBuilder;
    }

    return s1;
  }

  /**
   * 单次循环 寻找等于目标值的数组两数之和
   * @param num
   * @param target
   * @return
   */
  public List<Integer> SortNums(int[] num , int target){
    Map<Integer,Integer> map = new HashMap<>();
    for (int i = 0; i < num.length; i++) {
      if(map.containsKey(num[i])){
        return Arrays.asList(map.get(num[i]),num[i]);
      }
      map.put(target - num[i],i);
    }
    return null;
  }

  /**
   * 给定一个仅包含数字 2-9 的字符串，返回所有它能表示的字母组合。答案可以按 任意顺序 返回。
   * 给出数字到字母的映射如下（与电话按键相同）。注意 1 不对应任何字母
   * 2 abc 3 def 4 ghi
   * 5 jkl 6 mno 7 pqrs
   * 8 tuv 9 wxyz
   * @param digits
   * @return
   */

  public List<String> letterCombinations(String digits) {
    List<String> list = new ArrayList<>();
    Map<Integer,List<Character>> map = new HashMap<>();
    map.put(0,Arrays.asList());
    map.put(1,Arrays.asList());
    map.put(2,Arrays.asList('a','b','c'));
    map.put(3,Arrays.asList('d','e','f'));
    map.put(4,Arrays.asList('g','h','i'));
    map.put(5,Arrays.asList('j','k','l'));
    map.put(6,Arrays.asList('m','n','o'));
    map.put(7,Arrays.asList('p','q','r','s'));
    map.put(8,Arrays.asList('t','u','v'));
    map.put(9,Arrays.asList('w','x','y','z'));

    if(digits.equals("")){
      return new ArrayList<String>();
    }

    letterContinue(digits, 0, "", list, map);
    return list;
  }

  private void letterContinue(String digits, int i, String s, List<String> list, Map<Integer,List<Character>> map) {
    if(i == digits.length()){
      list.add(s);
      return;
    }

    Character c = digits.charAt(i);
    Integer sc = c - '0';
    List<Character> ChaGet = map.get(sc);
    //先2的循环 再3的循环
    for (int j = 0; j < ChaGet.size(); j++) {
      letterContinue(digits, i+1, s + ChaGet.get(j), list, map);
    }
    return;
  }


  /**
   * 给你一个由 n 个整数组成的数组 nums ，和一个目标值 target 。
   * 请你找出并返回满足下述全部条件且不重复的四元组 [nums[a], nums[b], nums[c], nums[d]]
   *（若两个四元组元素一一对应，则认为两个四元组重复）
   * 0 <= a, b, c, d < n
   * a、b、c 和 d 互不相同
   * nums[a] + nums[b] + nums[c] + nums[d] == target
   * @param nums
   * @param target
   * @return
   */
  public List<List<Integer>> fourSum(int[] nums, int target) {
    if(nums.length <= 4){
      return new ArrayList<>();
    }
    for (int i = 0; i < nums.length; i++) {
      if(i != nums.length - 1){
        for (int j = i + 1; j < nums.length - i - 1; j++) {
          int fir = j + 1;
          int las = nums.length - 1;

        }
      }

    }
    return null;
  }

  /**
   * 给定一个只包括 '('，')'，'{'，'}'，'['，']' 的字符串 s ，判断字符串是否有效。
   * 有效字符串需满足：
   * 左括号必须用相同类型的右括号闭合。
   * 左括号必须以正确的顺序闭合。
   * 每个右括号都有一个对应的相同类型的左括号。
   * @param s
   * @return
   */
  public static boolean isValid(String s){
    List<Character> charsList = s.chars().mapToObj(item -> (char) item).collect(Collectors.toList());
    int fir = 0;
    System.out.println(charsList);
    while(fir < charsList.size()){
      if(charsList.get(fir) == '('){
        for (int i = charsList.size() - 1; i > 0; i--) {
          if (charsList.get(i) == ')') {
            charsList.remove(fir);
            charsList.remove(i-1);
            break;
          }
        }
      }
      if (charsList.get(fir) == '{') {
        for (int i = charsList.size() - 1; i > 0; i--) {
          if (charsList.get(i) == '}') {
            charsList.remove(fir);
            charsList.remove(i-1);
            break;
          }
        }
      }
      if (charsList.get(fir) == '[') {
        for (int i = charsList.size() - 1; i > 0; i--) {
          if (charsList.get(i) == ']') {
            charsList.remove(fir);
            charsList.remove(i-1);
            break;
          }
        }
      }
      fir++;
    }
    if(charsList.size() != 0){
      System.out.println(charsList);
      return false;
    }else{
      return true;
    }
  }
  /**
   * 给你一个长度为 n 的整数数组 nums 和 一个目标值 target。请你从 nums 中选出三个整数，使它们的和与 target 最接近
   * {0,1,2,3,4,5,6,7,8,9,10}
   * @param nums
   * @param target
   * @return
   */
  public int threeSumClosest(int[] nums, int target) {
    Map<Integer,Integer> map = new HashMap<>();
    for (int i = 0; i < nums.length; i++) {
      int sign = i;

      int las = nums.length - 1;
      int beg = i + 1;
      if(sign != nums.length - 1 && sign <= nums.length - 3){
        while (las != beg){
          map.put(Math.abs(target - (nums[sign] + nums[las] + nums[beg])),(nums[sign] + nums[las] + nums[beg]));
          las--;
        }
      }
    }
    //List<Integer> collect = map.keySet().stream().sorted().collect(Collectors.toList());
    System.out.println(map);
    return 0;
  }


  /**
   * i!=j!=k && nums[i]==nums[j]==nums[k]
   * @param nums
   * @return
   */
  public List<List<Integer>> threeSum(int[] nums) {
    List<List<Integer>> res = new ArrayList<>();
    int length = nums.length;
    for(int fir = 0; fir < length; fir++){
      for(int sec = 0; sec  < length; sec++){
        for(int trd = 0; trd < length; trd++){
          if(nums[fir] + nums[sec] + nums[trd] == 0){
            List<Integer> list = new ArrayList<>(Arrays.asList(nums[fir],nums[sec],nums[trd]));
            res.add(list);
            while(trd + 1 < length && nums[trd] == nums[trd + 1]){
              trd++;
            }
          }
        }
        while(sec + 1 < length && nums[sec] == nums[sec + 1]){
          sec++;
        }
      }
      while(fir + 1 < length && nums[fir] == nums[fir + 1]){
        fir++;
      }
    }
    return res;
  }

  //找子串 不包含空
  public List<String> childrenString(String s){
    if(s.isEmpty() || s.length() < 1){
      return new ArrayList<>();
    }
    List<String> list = new ArrayList<>();
    for (int i = 0; i < s.length(); i++) {
      for(int j = s.length() - i - 1; j > 0; j--){
        list.add(s.substring(i,i+j));
      }
    }

    return list;
  }

  //回文字符串
  public static void TenetString(List<String> str){
    List<String> list = new ArrayList<>();
    for (String s : str) {
      if(s.length() == 1){
        list.add(s);
      }else {
        StringBuilder sb =new StringBuilder(s);
        String st = sb.reverse().toString();
        if (st.equals(s)){
          list.add(s);
        }
      }
    }
    System.out.println(list.stream().distinct().collect(Collectors.toList()));
  }

  /**
   * 三元组
   * @param nums
   * @param diff
   * @return
   */
  public static int arithmeticTripletsTest(int[] nums, int diff) {
    int count = 0;
    if (nums.length < 3) {
      return -1;
    } else if (nums.length == 3) {
      if(diff == nums[1] - nums[2] && diff == nums[1] - nums[0]){
        return 1;
      }else {
        return 0;
      }
    } else {
      for (int j = nums.length - 2; j >= 1; j--) {
        for (int i = 0; i < j; i++) {
          for (int k = nums.length - 1; k > j ; k--) {
            if(diff == nums[j] - nums[i] && diff == nums[k] - nums[j]){
                count++;
            }
          }
        }
      }
      return count;
    }
  }

  /**
   * 输出Excel下标
   * @param n
   * @return
   */
  public static int ExcelNumber(int n){
    List<Character> list = new ArrayList<>(); //初始化
    Character ch = new Character('A');
    for (int i = 0; i < 26; i++) {
      list.add((char)(i + ch));
    }
    StringBuilder sb = new StringBuilder();
    while(n != 0){
      int min = n % 26;//最后一位
      if(n / 26 == 0){
        sb.append(list.get(min));
      }else{
        if(min == 0){
          sb.append(list.get(25));
        }else{
          sb.append(list.get(min - 1));
        }
      }
      n = n / 26;
    }
    System.out.println(list);
    System.out.println(sb.reverse());
    return 0;
  }

  /**
   * 三元组
   * @param nums
   * @param diff
   * @return
   */
  public static int arithmeticTriplets(int[] nums, int diff) {
    //用数组实现哈希映射 arr[i]为1表示i在数组nums中出现过
    int[] arr = new int[201];
    for (int i = 0; i < nums.length; i++) {
      arr[nums[i]] = 1;
    }
    // 记录三元组的数量
    int count = 0;
    for (int i = 0; i < nums.length; i++) {
      //排除两种极端情况，超出数组边界 不会存在三元组
      if (nums[i] - diff < 0 || (nums[i] + diff) >= arr.length) {
        continue;
      }
      // 满足情况 num[i]和nums[i]-diff，nums[i]+diff都出现过
      if (arr[nums[i] - diff] > 0 && arr[nums[i] + diff] > 0) {
        count++;
      }
    }
    // 返回数量
    return count;
  }

  /**
   * 数组里两两相加等于target的数对
   * @param nums
   * @param target
   * @return
   */
  public static Integer[] twoSum(int[] nums, int target) {
    List<Integer> sc = new ArrayList<>();
    List<Integer> scSame = new ArrayList<>();
    for (int i = 0; i < nums.length; i++) {
      int rest = target - nums[i];
      for (int j = 0; j < nums.length; j++) {
        if (rest == nums[j]) {
          if (i == j) {
            scSame.add(i);
            scSame.add(j);
          } else {
            sc.add(i);
            sc.add(j);
          }
        }
      }
    }
    sc = sc.stream().distinct().collect(Collectors.toList());
    sc.addAll(scSame);
    return sc.toArray(new Integer[0]);
  }
}
