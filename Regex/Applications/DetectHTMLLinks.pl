# Charlie has been given an assignment by his Professor to strip the links and
# the text name from the html pages. Help Charlie in listing all the links and
# the text name of the links.
#
# Input Format: The first line contains the number of lines in the fragment (N).
#               This is followed by N lines from a valid HTML document or
#               fragment.
#
# Output Format: If there are N links in the document, display each of them in a
#                new line. The link and the text name must be separated by a ","
#                (comma) with no spaces between them. Strip out any extra spaces
#                at the start and end position of both the link and the text
#                name before printing.
#
# link-1,text name-1
# link-2,text name-2
# link-3,text name-3
# ....
# link-n,text name-n

#!/usr/bin/perl

$N     = <STDIN>;
$links = "";

while ($N--) {
   chomp($links .= <STDIN>);
}

# Links will always will always begin with <a href=", and we must be wary of any
# potential spaces between the =.
# 1.) Our first capture group will be the link itelf, which will always be
#     surrounded by two quotation marks and followed by a closing caret.
# 2.) Our second capture group will be the text name of the link, which will
#     always be surrounded by the aforementioned closing caret as well as an
#     opening caret.
while ($links =~ /<a\s+href\s?=\s?\"(.*?)\".*?>(.*?)<\/a>/gs) {

   # We need to strip any extra spaces at the start and end position of both
   # the link and text name before printing.
   $link           = $1;
   $link           =~ s/^\s+|\s+$//g;
   $link_text_name = $2;
   $link_text_name =~ s/^\s+|\s+$//g;

   # Certain test cases don't have text names and/or have additional attributes
   # like title, lang, hreflang. We must clear out those attributes while only
   # preserving the text name.
   $link_text_name =~ s/<.*?>//g;

   print "$link,$link_text_name\n";
}
