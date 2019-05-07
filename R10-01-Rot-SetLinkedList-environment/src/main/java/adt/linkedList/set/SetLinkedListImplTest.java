package adt.linkedList.set;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

import java.util.Arrays;

public class SetLinkedListImplTest {

   private SetLinkedListImpl<Integer> i1;
   private SetLinkedListImpl<Integer> i2;

   @Before
   public void setup() {
      this.i1 = new SetLinkedListImpl();
      this.i2 = new SetLinkedListImpl();
      this.i1.insert(2);
      this.i1.insert(3);
      this.i1.insert(7);
      this.i2.insert(0);

   }

   @Test
   public void testUnion() {
      SetLinkedList<Integer> k = this.i1.union(this.i2);
      Integer[] arr = new Integer[4];
      arr[0] = 2;
      arr[1] = 3;
      arr[2] = 7;
      arr[3] = 0;
      assertEquals(arr, k.toArray());
   }

   @Test
   public void testIntercetion() {
      SetLinkedList<Integer> k = this.i1.intersection(this.i2);
      Integer[] arr = new Integer[0];
      assertEquals(arr, k.toArray());
   }

   @Test
   public void testConcatenete() {
      this.i1.concatenate(this.i2);
      Integer[] arr = { 2, 3, 7, 0 };
      assertEquals(arr, this.i1.toArray());
   }

   @Test
   public void testRemoveDupl() {
      this.i1.insert(7);
      this.i1.insert(7);
      this.i1.insert(7);
      this.i1.insert(7);
      this.i1.insert(3);
      this.i1.insert(3);
      this.i1.insert(3);
      this.i1.insert(3);
      this.i1.insert(3);
      this.i1.removeDuplicates();

      SetLinkedListImpl<Integer> i3 = new SetLinkedListImpl<>();
      //i3.insert(9);
      SetLinkedListImpl<Integer> i4 = new SetLinkedListImpl<>();
      i4.insert(8);

      i4.concatenate(i3);
      //System.out.println(Arrays.toString(.toArray()));
      System.out.println(Arrays.toString(i4.toArray()));

      Integer[] arr = { 2, 3, 7 };
      System.out.println(Arrays.toString(arr));
      System.out.println(Arrays.toString(this.i1.toArray()));
      assertEquals(arr, this.i1.toArray());
   }

}
