echo "word counts for "$1

cat $1 | tr ' ' '\n' | sort | uniq -c 

