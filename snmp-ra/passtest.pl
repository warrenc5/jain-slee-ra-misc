#!/usr/bin/perl
#print ".1.3.6.1.4.1.8711.101.13.1.3.8.0\n";
#print "string\n";
#print "ok\n";
$cmd = shift;
$oid = shift;
$type = shift;
$value = shift;


open (FH, '>>','/code/snmp/log.out');
print (FH "$oid $type $value \n");
