/*
 * Memory Hardware Class - 256 kB
 *
 * Created By wilsonjj 11/14/2016
 */
 
 public class MEMORY {
                    private int SIZE = 256;
                    private int[] MemoryArray = new int[SIZE]; //maybe make this an array of strings? the directions say we need that
                    public void PUT(int data, int index){
                                   MemoryArray[index] = data;
                    }                                         //these are system operations that will be called by the I/O class
                    public int GET(int index){
                                  return MemoryArray[index];
                    }
 }
