import java.util.Arrays;
import java.util.Comparator;
import java.util.Collections;

public class BinarySearchDeluxe {

    /// <summary>
    /// Returns the index of the first key in a[] that equals the search key, or -1
    /// if no such key.
    /// </summary>
    /// <param name="a">the array of integers, must be sorted in ascending
    /// order</param>
    /// <param name="key">the search key</param>
    /// <returns> the index of the search key, if it is contained in the array;
    /// otherwise, -1</returns>
    public static <Key> int firstIndexOf(Key[] a, Key key, Comparator<Key> comparator) {
        int lo = 0;
        int hi = a.length - 1;
        while (lo <= hi) {
            if (comparator.compare(a[lo], key) == 0) {
                return lo;
            }
            int mid = lo + (hi - lo) / 2;
            int compCompare = comparator.compare(key, a[mid]);

            // check edge cases
            if (compCompare == 0) {
                if (mid == 0 || comparator.compare(a[mid - 1], key) != 0) {
                    return mid;
                } else {
                    hi = mid - 1;
                }
            } else if (compCompare < 0) {
                hi = mid - 1;
            } else {
                lo = mid + 1;
            }
        }
        return -1;
    }

    /// <summary>
    /// Returns the index of the last key in a[] that equals the search key, or -1
    /// if no such key.
    /// </summary>
    /// <param name="a">the array of integers, must be sorted in ascending
    /// order</param>
    /// <param name="key">the search key</param>
    /// <returns> the index of the search key, if it is contained in the array;
    /// otherwise, -1</returns>
    public static <Key> int lastIndexOf(Key[] a, Key key, Comparator<Key> comparator) {
        int lo = 0;
        int hi = a.length - 1;
        while (lo <= hi) {
            if (comparator.compare(a[hi], key) == 0) {
                return hi;
            }
            int mid = lo + (hi - lo) / 2;
            int compCompare = comparator.compare(key, a[mid]);

            // check edge cases
            if (compCompare == 0) {
                if (mid == a.length - 1 || comparator.compare(a[mid + 1], key) != 0) {
                    return mid;
                } else {
                    lo = mid + 1;
                }
            } else if (compCompare < 0) {
                hi = mid - 1;
            } else {
                lo = mid + 1;
            }
        }
        return -1;
    }

    // unit testing (you should have some Unit Testing here to confirm that your
    // methods work); for example...
    public static void main(String[] args) {

        Term[] terms = new Term[5];
        terms[0] = new Term("Trevor", 45);
        terms[1] = new Term("Kathy", 43);
        terms[2] = new Term("Ellie", 11);
        terms[3] = new Term("Allen", 9);
        terms[4] = new Term("Eva", 1);
        Arrays.sort(terms);

        Term searchme = new Term("J", 0);
        int first = BinarySearchDeluxe.firstIndexOf(terms, searchme, Term.byPrefixOrder(1));
        int last = BinarySearchDeluxe.lastIndexOf(terms, searchme, Term.byPrefixOrder(1));
        StdOut.println("J: " + first + " to " + last);

        searchme = new Term("A", 0);
        first = BinarySearchDeluxe.firstIndexOf(terms, searchme, Term.byPrefixOrder(1));
        last = BinarySearchDeluxe.lastIndexOf(terms, searchme, Term.byPrefixOrder(1));
        StdOut.println("A: " + first + " to " + last);

        searchme = new Term("E", 0);
        first = BinarySearchDeluxe.firstIndexOf(terms, searchme, Term.byPrefixOrder(1));
        last = BinarySearchDeluxe.lastIndexOf(terms, searchme, Term.byPrefixOrder(1));
        StdOut.println("E: " + first + " to " + last);

        searchme = new Term("T", 0);
        first = BinarySearchDeluxe.firstIndexOf(terms, searchme, Term.byPrefixOrder(1));
        last = BinarySearchDeluxe.lastIndexOf(terms, searchme, Term.byPrefixOrder(1));
        StdOut.println("T: " + first + " to " + last);

        // additional unit testing.

        String[] a = { "a", "b", "c", "d", "e", "f", "g", "h", "i", "j", "k", "l", "m", "n", "o", "p", "q", "r", "s",
                "t", "u", "v", "w", "x", "y", "z" };
        Arrays.sort(a);

        // testing firstIndexOf with assert
        assert (BinarySearchDeluxe.firstIndexOf(a, "a", String.CASE_INSENSITIVE_ORDER) == 0);
        assert (BinarySearchDeluxe.firstIndexOf(a, "b", String.CASE_INSENSITIVE_ORDER) == 1);
        assert (BinarySearchDeluxe.firstIndexOf(a, "c", String.CASE_INSENSITIVE_ORDER) == 2);
        assert (BinarySearchDeluxe.firstIndexOf(a, "d", String.CASE_INSENSITIVE_ORDER) == 3);
        assert (BinarySearchDeluxe.firstIndexOf(a, "e", String.CASE_INSENSITIVE_ORDER) == 4);
        assert (BinarySearchDeluxe.firstIndexOf(a, "f", String.CASE_INSENSITIVE_ORDER) == 5);
        assert (BinarySearchDeluxe.firstIndexOf(a, "g", String.CASE_INSENSITIVE_ORDER) == 6);
        assert (BinarySearchDeluxe.firstIndexOf(a, "h", String.CASE_INSENSITIVE_ORDER) == 7);
        assert (BinarySearchDeluxe.firstIndexOf(a, "i", String.CASE_INSENSITIVE_ORDER) == 8);
        assert (BinarySearchDeluxe.firstIndexOf(a, "j", String.CASE_INSENSITIVE_ORDER) == 9);
        assert (BinarySearchDeluxe.firstIndexOf(a, "k", String.CASE_INSENSITIVE_ORDER) == 10);

        // checking the return of first index through print statments
        StdOut.println(BinarySearchDeluxe.firstIndexOf(a, "a", String.CASE_INSENSITIVE_ORDER));
        StdOut.println(BinarySearchDeluxe.firstIndexOf(a, "A", String.CASE_INSENSITIVE_ORDER));
        StdOut.println(BinarySearchDeluxe.firstIndexOf(a, "z", String.CASE_INSENSITIVE_ORDER));
        StdOut.println(BinarySearchDeluxe.firstIndexOf(a, "Z", String.CASE_INSENSITIVE_ORDER));
        StdOut.println(BinarySearchDeluxe.firstIndexOf(a, "aa", String.CASE_INSENSITIVE_ORDER)); // should return -1
        StdOut.println(BinarySearchDeluxe.firstIndexOf(a, "AA", String.CASE_INSENSITIVE_ORDER)); // should return -1

        // test lastIndexOf with assert
        assert (BinarySearchDeluxe.lastIndexOf(a, "a", String.CASE_INSENSITIVE_ORDER) == 0);
        assert (BinarySearchDeluxe.lastIndexOf(a, "b", String.CASE_INSENSITIVE_ORDER) == 1);
        assert (BinarySearchDeluxe.lastIndexOf(a, "c", String.CASE_INSENSITIVE_ORDER) == 2);
        assert (BinarySearchDeluxe.lastIndexOf(a, "d", String.CASE_INSENSITIVE_ORDER) == 3);
        assert (BinarySearchDeluxe.lastIndexOf(a, "e", String.CASE_INSENSITIVE_ORDER) == 4);
        assert (BinarySearchDeluxe.lastIndexOf(a, "f", String.CASE_INSENSITIVE_ORDER) == 5);
        assert (BinarySearchDeluxe.lastIndexOf(a, "g", String.CASE_INSENSITIVE_ORDER) == 6);
        assert (BinarySearchDeluxe.lastIndexOf(a, "h", String.CASE_INSENSITIVE_ORDER) == 7);
        assert (BinarySearchDeluxe.lastIndexOf(a, "i", String.CASE_INSENSITIVE_ORDER) == 8);
        assert (BinarySearchDeluxe.lastIndexOf(a, "j", String.CASE_INSENSITIVE_ORDER) == 9);
        assert (BinarySearchDeluxe.lastIndexOf(a, "k", String.CASE_INSENSITIVE_ORDER) == 10);

        // checking the return of last index through print statments
        StdOut.println(BinarySearchDeluxe.lastIndexOf(a, "a", String.CASE_INSENSITIVE_ORDER));
        StdOut.println(BinarySearchDeluxe.lastIndexOf(a, "A", String.CASE_INSENSITIVE_ORDER));
        StdOut.println(BinarySearchDeluxe.lastIndexOf(a, "z", String.CASE_INSENSITIVE_ORDER));
        StdOut.println(BinarySearchDeluxe.lastIndexOf(a, "Z", String.CASE_INSENSITIVE_ORDER));
        StdOut.println(BinarySearchDeluxe.lastIndexOf(a, "aa", String.CASE_INSENSITIVE_ORDER)); // should return -1
        StdOut.println(BinarySearchDeluxe.lastIndexOf(a, "AA", String.CASE_INSENSITIVE_ORDER)); // should return -1

    }
}