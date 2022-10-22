import java.util.Arrays;
import java.util.Comparator;

public class Term implements Comparable<Term> {

    /// <summary>
    /// Create a new Term object.
    /// </summary>
    public String query;
    public Long weight;

    /// <summary>
    /// Initializes a term with the given query string and weight.
    /// </summary>
    /// <param name="query">The query string.</param>
    /// <param name="weight">The weight.</param>
    public Term(String query, long weight) {
        this.query = query;
        this.weight = weight;
    }

    /// <summary>
    /// Compares two terms in descending order by weight.
    /// </summary>
    /// <param name="v">First term.</param>
    /// <param name="w">Second term.</param>
    /// <returns the result of comparing the first r characters of the query
    /// strings.</returns>
    public static Comparator<Term> byReverseWeightOrder() {
        return new Comparator<Term>() {
            public int compare(Term v, Term w) {
                return Long.compare(w.weight, v.weight);
            }

        };
    }

    /// <summary>
    /// Compares two terms in lexicographic order but using only the first r
    /// characters of each query.
    /// </summary>
    /// <param name="v">First term.</param>
    /// <param name="w">Second term.</param>
    /// <returns the result of comparing the first r characters of the query
    /// strings.</returns>
    public static Comparator<Term> byPrefixOrder(int r) {
        return new Comparator<Term>() {
            public int compare(Term v, Term w) {

                // add edge cases for when r is greater than or equal to the length of the query
                if (r >= v.query.length()) {
                    String wQuery = w.query.substring(0, r);
                    return v.query.compareTo(wQuery);
                }
                if (r >= w.query.length()) {
                    String vQuery = v.query.substring(0, r);
                    return vQuery.compareTo(w.query);
                } else {
                    String vQuery = v.query.substring(0, r);
                    String wQuery = w.query.substring(0, r);
                    return vQuery.compareTo(wQuery);
                }
            }
        };
    }

    /// <summary>
    /// Compares the two terms in lexicographic order by query.
    /// </summary>
    /// <param name="that">Term to compare to.</param>
    /// <returns the result of comparing the query strings.</returns>
    public int compareTo(Term that) {
        return this.query.compareTo(that.query);
    }

    /// <summary>
    /// Returns a string representation of this term in the following format:
    /// the weight, followed by a tab, followed by the query.
    /// </summary>
    /// <returns>String representation of this term.</returns>
    public String toString() {
        return weight + "\t" + query;
    }

    // unit testing (you should have some Unit Testing here to confirm that your
    // methods work); for example...
    public static void main(String[] args) {
        Term[] terms = new Term[5];
        terms[0] = new Term("Trevor", 45);
        terms[1] = new Term("Trenton", 43);
        terms[2] = new Term("Tasha", 11);
        terms[3] = new Term("Tilly", 9);
        terms[4] = new Term("Tappp", 1);

        Arrays.sort(terms);
        for (Term t : terms) {
            StdOut.println(t);
        }

        StdOut.println("");
        Arrays.sort(terms, Term.byReverseWeightOrder());
        for (Term t : terms) {
            StdOut.println(t);
        }

        StdOut.println("");
        Arrays.sort(terms, Term.byPrefixOrder(1));
        for (Term t : terms) {
            StdOut.println(t);
        }

        Term[] terms2 = new Term[7];
        terms2[0] = new Term("Billy", 45);
        terms2[1] = new Term("Brent", 43);
        terms2[2] = new Term("Ken", 42);
        terms2[3] = new Term("Barbie", 22);
        terms2[4] = new Term("Tarper", 11);
        terms2[5] = new Term("Mike", 9);
        terms2[6] = new Term("Caleb", 3);

        // add unit testing for toString method
        System.out.println(Arrays.toString(terms2));

        // unit testing for compareTo method
        System.out.println(terms2[0].compareTo(terms2[1]));
        System.out.println(terms2[1].compareTo(terms2[0]));
        System.out.println(terms2[0].compareTo(terms2[0]));

        // unit testing for byReverseWeightOrder method and print results for each term
        Arrays.sort(terms2, Term.byReverseWeightOrder());
        System.out.println(Arrays.toString(terms));

        // unit testing for byPrefixOrder method and print results for each term
        Arrays.sort(terms2, Term.byPrefixOrder(3));
        System.out.println(Arrays.toString(terms2));
    }
}