package com.add;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class TestList01 {

  public static void main(String[] args) {
    int[] in = {1, 2, 2, 3, 2, 4, 5, 6, 7, 8, 9};
    String str1 = "a,e,b,c,g,d";
    String str2 = "a,e,b,c,d";
    String[] str21 = findStr2(str1, str2);
    for (String s : str21) {
      System.out.print(s+",");
    }

    //divide(-7,3);
    //removeStr("sadlinesad","sad");
    //findReplace(in, 0);
    //Arrays.stream(in).forEach(System.out::println);
  }

  /**
   * 交换链表两两相邻元素
   * @param head
   * @return
   */
  public ListNode swapPairs(ListNode head) {
    ListNode pre = new ListNode(0);
    pre.next = head;
    ListNode temp = pre;
    while (temp.next != null && temp.next.next != null) {
      ListNode start = temp.next;
      ListNode end = temp.next.next;
      temp.next = end;
      start.next = end.next;
      end.next = start;
      temp = start;
    }
    return pre.next;
  }

  /**
   * 给你两个整数，被除数 dividend 和除数 divisor。将两数相除，
   * 要求 不使用 乘法、除法和取余运算。
   * @param dividend
   * @param divisor
   */
  public static void divide(int dividend, int divisor){
    int de = math(dividend);
    int ds = math(divisor);
    int res = 0;
    while(de >= ds){
      de = de - ds;
      res++;
    }
  }

  private static int sub(int dividend, int divisor) {
    if((dividend <= 0 && divisor < 0)){

    }
    return 0;
  }

  public static void remove(){

  }
  /**
   * 给你一个数组 nums 和一个值 val，你需要 原地 移除所有数值等于 val 的元素，并返回移除后数组的新长度
   * @param old
   * @param noOld
   * @return
   */
  public static List<String> findStr(String old, String noOld){
    List<String> list = new ArrayList<>();
    String[] split2Old = old.split(",");
    String[] split2noOld = noOld.split(",");
    int i = 0;
    while (i < split2noOld.length){
      String s = split2noOld[i];
      for (int j = 0; j < split2Old.length; j++) {
        if (s.equals(split2Old[j])) {
          list.add(split2Old[j]);
        }else {
          list.add("''");
        }
      }
      i++;
    }
    return list;
  }

  public static String[] findStr2(String old, String noOld){
    List<Integer> list = new ArrayList<>();
    List<Integer> list1 = new ArrayList<>();

    String[] split2Old = old.split(",");
    String[] split2noOld = noOld.split(",");
    for (int i = 0; i < split2Old.length; i++) {
      list1.add(i);
    }
    int i = 0;
    while (i < split2noOld.length){
      String s = split2noOld[i];
      for (int j = 0; j < split2Old.length; j++) {
        if (s.trim().toLowerCase().equals(split2Old[j].trim().toLowerCase())) {
          list.add(j);
        }
      }
      i++;
    }
    int k = 0;
    while (k < list.size()){
      Integer s = list.get(k);
      for (int j = 0; j < list1.size(); j++) {
        if (s == list1.get(j)) {
          list1.remove(j);
        }
      }
      k++;
    }
    for (int j = 0; j < list1.size() ; j++) {
      split2Old[list1.get(j)] = "''";
    }
    return split2Old;
  }

  /**
   * 比较两个字符串
   * @param old
   * @param noOld
   * @return
   */
  public static List<String> compareStr(String old, String noOld){
    List<String> list = new ArrayList<>();
    String[] split2Old = old.split(",");
    String[] split2noOld = noOld.split(",");
    for (int i = 0; i < split2Old.length; i++) {
      if (!split2noOld[i].equals(humpToUnderline(split2Old[i]))) {
        list.add(split2Old[i]);
      }
    }
    return list;
  }
  /**
   * 驼峰转下划线
   * @param str
   * @return
   */
  public static String humpToUnderline(String str) {
    String regex = "([A-Z])";
    Matcher matcher = Pattern.compile(regex).matcher(str);
    while (matcher.find()) {
      String target = matcher.group();
      str = str.replaceAll(target, "_"+target.toLowerCase());
    }
    return str;
  }

  /**
   * 下划线转驼峰
   * @param str
   * @return
   */
  public static String underlineToHump(String str) {
    String regex = "_(.)";
    Matcher matcher = Pattern.compile(regex).matcher(str);
    while (matcher.find()) {
      String target = matcher.group(1);
      str = str.replaceAll("_"+target, target.toUpperCase());
    }
    return str;
  }

  private static int math(int i){
    return Math.abs(i);
  }

  /**
   * 递归查重
   * @param i
   * @param index
   */
  private static void findReplace(int[] i, int index) {
    if (index == i.length - 1) {
      return;
    }
    for (int j = index; j < i.length - index; j++) {
      if (j != i.length - 1) {
        if(i[index] == i[j+1]){
          i[j+1] = 0;
        }
      }
    }
    findReplace(i, ++index);
  }

  /**
   * 给你两个字符串 haystack 和 needle ，
   * 请你在 haystack 字符串中找出 needle 字符串的第一个匹配项的下标（下标从 0 开始）。
   * 如果 needle 不是 haystack 的一部分，则返回 -1
   * @param haystack
   * @param needle
   * @return
   */
  public static int removeStr(String haystack , String needle){
    List<Integer> list = new ArrayList<>();
    findStr(haystack, needle,0, list);
    System.out.println(list);
    return 0;
  }

  private static void findStr(String haystack, String needle, int index, List<Integer> list) {
    int len = needle.length();
    int leh = haystack.length();

    if(index == leh - len + 1){
      return;
    }

    for (int i = index; i < leh - len + 1; i++) {
      if(haystack.substring(i,i+len).equals(needle)){
        list.add(index);
      }
    }
    index = index + 1;
    findStr(haystack, needle, index, list);
  }

  //全排列
  private List<List<String>> extracted(String[] words, List<String> list) {
    List<String> temp = new ArrayList<>(list);
    if (words.length == list.size()){
      res.add(list);
    }
    for (int i = 0; i < words.length; i++) {
      if(temp.contains(words[i])){
        continue;
      }
      temp.add(words[i]);
      extracted(words,temp);
      temp.remove(temp.size() - 1);
    }

    return res;
  }

  public static void perm(int[] array, Stack<Integer> stack) {
    if(array.length <= 0) {
      //进入了叶子节点，输出栈中内容
      System.out.println(stack);
    } else {
      for (int i = 0; i < array.length; i++) {
        //tmepArray是一个临时数组，用于就是Ri
        //eg：1，2，3的全排列，先取出1，那么这时tempArray中就是2，3
        int[] tempArray = new int[array.length-1];
        System.arraycopy(array,0,tempArray,0,i);
        System.arraycopy(array,i+1,tempArray,i,array.length-i-1);
        stack.push(array[i]);
        perm(tempArray,stack);
        stack.pop();
      }
    }
  }
}
