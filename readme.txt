/******************************************************************************
 *  Name: Riley Marsden
 *
 *  Hours to complete assignment (optional): around 10 hours 
 *
 ******************************************************************************/

Programming Assignment 2: Autocomplete


/******************************************************************************
 *  Describe how your firstIndexOf() method in BinarySearchDeluxe.java
 *  finds the first index of a key that equals the search key.
 *****************************************************************************/

First, I create a variable  ‘lo’ to hold the first element in the array. Then I 
created a variable to hold the index of the last element in the array, and a variable 
to hold the index of the middle element in the array that will eventually equal 
the search key.  Then I create the fourth variable compCompare that compares the 
search key with the middle of the array. I used a while loop to check the edge cases 
in a couple of if statements. This helped me return -1 if the key was not found, 
and it returns the index of the first occurrence of the key if it is found. It does 
this by comparing the search key to the current key in the array. If the search key 
is greater than the current key, it will continue to the next index in a binary search fashion, 
setting the low to be in the middle of the array. If the search key is less than the current key, 
it will continue to the next index similar to if it is greater than the current key, only now 
the hi is set to mid. Finally, if the search key is equal to the current key, it will 
return the index of the current key. If it’s not equal to zero, then it can’t be equal to the
search key, and I check if the previous compare is equal to zero to decide 
if I have found the first occurrence of that element or not.

/******************************************************************************
 *  What is the order of growth of the number of compares (in the
 *  worst case) that each of the operations in the Autocomplete
 *  data type make, as a function of the number of terms n and the
 *  number of matching terms m?  (Big-Oh notation)
 *
 *  Recall that with order-of-growth notation, you should discard
 *  leading coefficients and lower-order terms, e.g., m^2 + m log n.
 *****************************************************************************/

constructor: O(n log n)

allMatches(): O(log n + M log M) 

numberOfMatches(): O(log n)




/******************************************************************************
 *  Known bugs / limitations.
 *****************************************************************************/
None.

/******************************************************************************
 *  Describe whatever help (if any) that you received.
 *  Don't include readings or lectures, but do include
 *  any help from people (including course staff, lab TAs,
 *  classmates, and friends) and attribute them by name.
 *
 *  Also include any resources (including the web) that you may
 *  may have used in creating your design.
 *****************************************************************************/
Derrick and I trouble shooted quite often about things that werent working for either
of us. We both helped each other overcome the issues. For example, I hadn't considered
the runtime of numberOfMatches, and actually left number of matches out when coding allMatches.
It was working, but it was a slow while loop that could have been made faster. He suggested using
a binary search to find the first occurrence of the key, and then using a binary search to find
the last occurrence of the key. And managing my count via that. I did this, and it worked much
faster.

/******************************************************************************
 *  Describe any serious problems you encountered.
 *****************************************************************************/


My biggest issue was acutally with lastindexof. I was trying to find the last index of a key,
but I couldn't get the byprefix order to work. Come to find out sometimes r is going to be <= to 
the term. This took me hours to figure out because of how everything works together. I thought it was
and issue in AllMatches, then I thought it was an issue in numberOfMatches. But before I made numberOfMatches
faster I was only using firstIndexOf to find the count. So I had never tested lastindexof with those sort of parameters.


/******************************************************************************
 *  List any other comments here. Feel free to provide any feedback
 *  on how much you learned from doing the assignment, and whether
 *  you enjoyed doing it.
 *****************************************************************************/


