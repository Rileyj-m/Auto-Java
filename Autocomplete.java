import java.util.Arrays;

public class Autocomplete {
    private Term[] terms;

    /// <summary>
    /// Initializes the data structure from the given array of terms.
    /// </summary>
    /// <param name="terms">The terms.</param>
    public Autocomplete(Term[] terms) {
        this.terms = terms;
        Arrays.sort(terms);
    }

    /// <summary>
    /// Returns all terms that start with the given prefix, in descending order of
    /// weight.
    /// </summary>
    /// <param name="prefix">The prefix</param>
    /// <returns>An array of terms</returns>
    public Term[] allMatches(String prefix) {
        Term[] resultMatches = new Term[numberOfMatches(prefix)];
        int forLoopLength = numberOfMatches(prefix);
        int index = BinarySearchDeluxe.firstIndexOf(terms, new Term(prefix, 0), Term.byPrefixOrder(prefix.length()));
        for (int i = 0; i < forLoopLength; i++) {
            resultMatches[i] = terms[index];
            index++;
        }
        Arrays.sort(resultMatches, Term.byReverseWeightOrder());
        return resultMatches;
    }

    /// <summary>
    /// Returns the number of terms that start with the given prefix.
    /// </summary>
    /// <param name="prefix">The prefix</param>
    /// <returns>The number of terms</returns>
    public int numberOfMatches(String prefix) {
        // int index = BinarySearchDeluxe.firstIndexOf(terms, new Term(prefix, 0),
        // Term.byPrefixOrder(prefix.length()));
        // if (index == -1) return 0;
        // int count = 0;
        // while (index < terms.length && terms[index].query.startsWith(prefix)) {
        // count++;
        // index++;
        // }
        // return count;
        int firstIndexCount = BinarySearchDeluxe.firstIndexOf(terms, new Term(prefix, 0),
                Term.byPrefixOrder(prefix.length()));
        int lastIndexCount = BinarySearchDeluxe.lastIndexOf(terms, new Term(prefix, 0),
                Term.byPrefixOrder(prefix.length()));
        return lastIndexCount - firstIndexCount + 1;
    }

    // A sample client for unit testing
    public static void main(String[] args) {

        // read in the terms from a file
        String filename = args[0];
        In in = new In(filename);
        int N = in.readInt();
        Term[] terms = new Term[N];
        int i;
        for (i = 0; i < N; i++) {
            long weight = in.readLong(); // read the next weight
            in.readChar(); // scan past the tab
            String query = in.readLine(); // read the next query
            terms[i] = new Term(query, weight); // construct the term
        }

        // read in queries from standard input and print out the top k matching terms
        int k = Integer.parseInt(args[1]);
        Autocomplete autocomplete = new Autocomplete(terms);
        while (StdIn.hasNextLine()) {
            String prefix = StdIn.readLine();
            Term[] results = autocomplete.allMatches(prefix);
            for (i = 0; i < Math.min(k, results.length); i++)
                StdOut.println(results[i]);
        }

        // // testing all matches with a small prefix
        // String prefix = "a";
        // Term[] results = autocomplete.allMatches(prefix);
        // for ( i = 0; i < Math.min(k, results.length); i++)
        // StdOut.println(results[i]);

        // // testing number of matches with a small prefix
        // int count = autocomplete.numberOfMatches(prefix);
        // StdOut.println(count);

        // // testing all matches with a large prefix
        // prefix = "ab";
        // results = autocomplete.allMatches(prefix);
        // for ( i = 0; i < Math.min(k, results.length); i++)
        // StdOut.println(results[i]);

        // // testing number of matches with a large prefix
        // count = autocomplete.numberOfMatches(prefix);
        // StdOut.println(count);

        // // testing all matches with a prefix longer than the longest query
        // prefix = "abcdefghijklmnopqrstuvwxyz";
        // results = autocomplete.allMatches(prefix);
        // for ( i = 0; i < Math.min(k, results.length); i++)
        // StdOut.println(results[i]);

        // // testing number of matches with a prefix longer than the longest query
        // count = autocomplete.numberOfMatches(prefix);
        // StdOut.println(count);

        // // testing all matches with a prefix that has no matches (empty string)
        // prefix = "";
        // results = autocomplete.allMatches(prefix);
        // for ( i = 0; i < Math.min(k, results.length); i++)
        // StdOut.println(results[i]);

    }
}