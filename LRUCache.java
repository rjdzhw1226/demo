import java.io.IOException;
import java.io.InputStreamReader;
import java.net.URL;
import java.net.URLConnection;
import java.util.LinkedList;
import java.util.Queue;

class LRUCache {
  class Node{
    int hash;
    int key;
    int value;
    Node next;
    public Node(int hash, int key, int value, Node next) {
      this.hash = hash;
      this.key = key;
      this.value = value;
      this.next = next;
    }
  }
  int size = 0;
  Node[] queue = new Node[size];

  public LRUCache(int capacity) {
    queue = new Node[capacity];
  }

  public int getHash(int key){
    return key & (queue.length - 1);
  }

  public int get(int key) {
    if(queue.length == 0){
      return -1;
    } else {
      if(queue[getHash(key)] == null){
        return -1;
      }
      Node node = queue[getHash(key)];
      Node prev = null;
      while (node != null){
        if(node.key == key){
          int value = node.value;
          if(node.next != null){
            if(prev == null){
              queue[getHash(key)] = node.next;
            } else {
              prev.next = node.next;
            }
            size--;
          }
          return value;
        }
        prev = node;
        node = node.next;
      }
    }
    return -1;
  }

  public void put(int key, int value) {
    int hash = getHash(key);
    if(size >= queue.length){

    }
    if(queue[hash] == null){
      queue[hash] = new Node(hash,key,value,null);
    } else {
      Node node = queue[hash];
      while (true){
        if(node.key == key){
          node.value = value;
          return;
        }
        if(node.next == null){
          break;
        }
        node = node.next;
      }
      node.next = new Node(hash,key,value,null);
    }
    size++;
  }

  public static void main(String[] args) throws IOException {
    StringBuilder sb = new StringBuilder();
    String net = "";
    URL url = new URL(net);
    URLConnection urlConnection = url.openConnection();
    InputStreamReader isr = new InputStreamReader(urlConnection.getInputStream());
    int ch;
    while((ch = isr.read()) != -1){
      sb.append((char) ch);
    }
    isr.close();
    System.out.println(sb.toString());
  }


}