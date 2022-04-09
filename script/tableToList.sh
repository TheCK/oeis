wget $1 -O tmp.txt;

cat tmp.txt | cut -d' ' -f2 

rm tmp.txt;
