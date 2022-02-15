cd `dirname $0`
PORT=8989
#curl -D - --retry 0 -H "Content-Type:text/xml" --data-binary "@test-request.http" -uadmin:admin http://localhost:${PORT}/xmlrpc-www-1.0-SNAPSHOT/XMLRPCValidatingServlet
curl -D - --retry 0 -H "Content-Type:text/xml" --data-binary "@test-request.http" http://localhost:${PORT}/xmlrpc-www-1.0-SNAPSHOT/XMLRPCValidatingServlet[0-500]
