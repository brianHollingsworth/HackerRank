# Given n sentences consisting of one or more words separated by non-word
# characters, process q queries where each query consists of a single string, s.
# To process each query, count the number of occurrences of s as a sub-word in
# all n sentences, then print the number of occurrences on a new line.
#
# Input Format: The first line contains an integer, n, denoting the number of
#               sentences. Each of the n subsequent lines contains a sentence
#               consisting of words separated by non-word characters. The next
#               line contains an integer, q, denoting the number of queries.
#               Each line i of the q subsequent lines contains a string, si, to
#               check.
#
# Output Format: For each query string, si, print the total number of times it
#                occurs as a sub-word within all words in all n sentences.
#
# Sample Input:
#
# 1
# existing pessimist optimist this is
# 1
# is
#
# Sample Output:
#
# 3

#!/usr/bin/perl

@sentences;
for (chomp($n = <STDIN>); $n > 0; $n--) {
   chomp($sentence = <STDIN>);
   push(@sentences, $sentence);
}

@queries;
for (chomp($q = <STDIN>); $q > 0; $q--) {
   chomp($s = <STDIN>);
   push(@queries, $s);
}

foreach $query (@queries) {
   my $total_occurrences = 0;
   foreach $sentence (@sentences) {
      # In the example above, 'is' is a substring of the word 'this';
      # however, it's followed by a blank space. Because a blank space is
      # non-alphabetic, non-numeric, and not an underscore, we do not count
      # it as a sub-word occurrence. Thus, we need to add '\w' to only
      # capture sub-words WITHIN a word.
      # Also, some of the test cases have more than one occurrence of a query,
      # so we have to force a list context with '= ()=' and the 'g' anchor. 
      my $occurrences = ()= $sentence =~ /\w$query\w/g;
      $total_occurrences += $occurrences;
      print("$total_occurrences\n");
   }
}
