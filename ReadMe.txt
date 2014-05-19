IntArrays.java contains methods for manipulating int arrays --searching, sorting, copying,
including linear search, binary search, selection sort, insertion sort, quick sort, and merge sort.

IntArraysTester.java contains methods for testing the IntArrays methods --IntArraysTester
  is a JUnit testing class, so to run all the tests, just select this file in the Eclipse
  Package Explorer and choose menu item Run -> Run
This testing class was invaluable for finding small errors --typos, like < for >.

ComparableArrays.java contains methods for manipulating Comparable arrays --the same methods
that are in IntArrays. This set of methods was created by revising a copy of IntArrays.java

ComparableArraysTester.java contains methods for testing the ComparableArrays methods --it
  is a JUnit testing class. When revising the copy of IntArrays to handle ComparableArrays,
  small mistakes were made which had to be found. It was easy to revise a copy of
  IntArraysTester to test the Comparable[] methods --we just used arrays Integer[] instead of
  int[], since Integer implements Comparable. For example, we changed something like
  
      int[] b= new int[]{5, 6, 7};
  to
      Integer[] b= new Integer{5, 6, 7};
      
  and autoboxing took over in creating the array of Integers. Neat.
