# This is a bash shell command to update the file content.

In the Problem 2 statement, problem was given as  :

Given a CSV file where each row contains the name of a city and its state separated by a comma, your task is to keep city name only
and replace the newlines in the file with semicolons as demonstrated in the sample.
Note: Use only native shell commands

Sample Input:

Atlanta, Ga.
Atlantic City, N.J.
Austin, Texas
Baltimore, Md.
Baton Rouge, La.
Billings, Mont.
Birmingham, Ala.
Bismarck, N.D.
Boise, Idaho
Boston, Mass.
Bridgeport, Conn.

Sample Output:

Atlanta;Atlantic City;Austin;Baltimore;Baton Rouge;Billings;Birmingham;Bismarck;Boise;Boston;BridgepoAtlanta;Atlantic City;Austin;Baltimore;Baton Rouge;Billings;Birmingham;Bismarck;Boise;Boston;Bridgeport

Solution:

I have used linux standard "SED" to parse the file content.

Format: 

sed -e 's/<old content>//<new content>/g' <file_name>

e = expression
s = substitute
g = global

my input : input.csv 
my output : output.csv

command used: 
echo $(echo $(echo $(sed -e 's/,.*/;/' input.csv)|sed 's/.$//')|sed -e 's/ //g') > output.csv 