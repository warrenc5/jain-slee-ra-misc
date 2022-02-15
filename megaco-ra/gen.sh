cat h248.txt h248-6.txt h248-7.txt h248-9.txt > megaco-api/src/test/resources/h248all.txt
grep "^.*I[dD]:" megaco-api/src/test/resources/h248all.txt | sed 's/^ *//' > megaco-api/src/test/resources/code
