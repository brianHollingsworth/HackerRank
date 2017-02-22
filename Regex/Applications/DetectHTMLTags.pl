# Given N lines of HTML, find the tag names (ignore any attributes) and print
# them as a single line of lexicographically ordered semicolon-separated values.
#
# Input Format: The first line contains an integer, N, the number of HTML
#               fragments. Each of the N subsequent lines contains a fragment of
#               an HTML document.
#
# Output Format: Print a single line containing all of the unique tag names
#                found in the input. Your output tags should be semicolon-
#                separated and ordered lexicographically (i.e.: alphabetically).
#                Do not print the same tag name more than once.
#
# Sample Input:
#
# 2
# <p><a href="http://www.quackit.com/html/tutorial/html_links.cfm">Example Link</a></p>
# <div class="more-info"><a href="http://www.quackit.com/html/examples/html_links_examples.cfm">More Link Examples...</a></div>
#
# Sample Output:
#
# a;div;p

#!/usr/bin/perl

@tags;
@unique_tags;
while(<>) {

   # I thought it would be easy to simply search for the closing tag of each
   # tag; however, a few test cases involved self-closing break tags with style
   # attributes (<br style="clear:both;" />). Thus, I needed to consider cases
   # like the aforementioned while also keeping my regex generic enough to
   # successfully complete all test cases. Fortunately, we can utilize the
   # negated character class: [^>]*. This will prevent backtracking from
   # occurring when we're parsing HTML tags.
   # Since, a single line may contain more than one HTML tag, we want to parse
   # every tag into an array, which we will sift through in the next step.
   @tags = $_ =~ /<([a-z0-9]+)[^>]*>/g;

   # For each individual HTML tag in the array of tags...
   foreach $tag (@tags) {

      # If the current tag does not exist in the array of unique tags, place
      # place the tag in said array.
      if (!grep(/^$tag$/, @unique_tags)) {
         push(@unique_tags, $tag);
      }
   }
}

# Lexicographically sort the unique HTML tags and separate each tag by a
# semicolon.
@unique_tags = join(";", sort(@unique_tags));
print("@unique_tags");
