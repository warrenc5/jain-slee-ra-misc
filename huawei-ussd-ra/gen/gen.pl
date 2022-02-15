#!/usr/bin/perl
use XML::Xerces;
XML::Xerces::XMLPlatformUtils::Initialize();
my $impl = XML::Xerces::DOMImplementationRegistry::getDOMImplementation('LS');
my $doc = eval{$impl->createDocument('', 'spec',$dt)};
my $root = $doc->getDocumentElement(); 

open FH, 'test.txt';

%types = ('C-Octet String'=> 'java.lang.String','Octet String'=> 'java.lang.String','Integer'=>'int');

$EOL="\n";
$state = 0;
$s_unknown = 0;
$s_table = 5;
$s_value = 6;
$s_header = 1;
$s_body = 2;
$s_doc = 3;
$p=0;
%class = ();
%map = ();
%header = ();
%body = ();
$target = 'test.xml';
$vnode; 
$cnode; 
$fnode;
while (<FH>){
  chop;
  if ( /\-\-/){
    add_text($cnode,'doc',$class{'doc'});
      $class{'fields'}=();
    %class = ();
    break;
  } elsif ( /^(Table)? ?([0-9\.]+)\ +(Syntax of )?([A-Za-z]+)/){
    if (defined($class{'name'}) && $class{'name'} == $4 && defined($3) ){
      if (defined($1)){
        $state = $s_table;
      } else {
        $state = $s_doc;
      }
      next;
    }
    if ($state == $s_doc && length($class{'doc'})>0) {
      add_text($cnode,'doc',$class{'doc'});
      $class{'fields'}=();
      %class = ();
    }
    if (length($1)==0) {
#print $2.$4.$EOL;
      $class{'name'}= $4;
      $class{'fields'}=();

      $cnode = new_node('class');
      $cnode->setAttribute('name', $4);
      $root->appendChild($cnode);

      $state = $s_doc;
    } else {
#print $1;
      $state = $s_table;
    }
    $p=0;
  } elsif (/^HEADER ?$/) {
    $state = $s_header;
    $class{'fields'}{'header'} = ();
  } elsif (/^BODY ?$/) {
    $state = $s_body;
    $class{'fields'}{'body'} = ();
  } elsif ($state == $s_header || $state == $s_body){
    if (! /^\ *$/) {
      $p++;

      if($state == $s_body){
        $class{'fields'}{'body'}{$p} = $_;

        $fn = $class{'fields'}{'body'}{'1'};
        $len = $class{'fields'}{'body'}{'2'};
        $type = $class{'fields'}{'body'}{'3'};
        $doc2 = $class{'fields'}{'body'}{'4'};
        $ref = $class{'fields'}{'body'}{'5'};

        $header = 0;

      }elsif ($state == $s_header) {
        $class{'fields'}{'header'}{$p} = $_;

        $fn = $class{'fields'}{'header'}{'1'};
        $len = $class{'fields'}{'header'}{'2'};
        $type = $class{'fields'}{'header'}{'3'};
        $doc2 = $class{'fields'}{'header'}{'4'};
        $ref = $class{'fields'}{'header'}{'5'};

        $header = 1;
      }

#print '=='.$p.'='.$_;  
      if(/^[0-9]+\.[0-9\.]+$/) {
        $p=0;

#process map
        $fnode = new_node('field');
        $fnode->setAttribute('name', $fn);
        if ($len =~ /Var. max ([0-9]*)/){
          $fnode->setAttribute('var',true);
          $len = $1;
        }

        $fnode->setAttribute('len', $len);
        $fnode->setAttribute('otype', $type);
        if (defined($types{$type})) {
          $type = $types{$type};
        }
        $fnode->setAttribute('type', $type);
        $fnode->setAttribute('ref', $ref);

        add_text($fnode,'doc',$doc2);

        if (length($class{'doc'})>0){
          add_text($cnode,'doc',$class{'doc'});
        }

        if($header == 1) {
          $fnode->setAttribute('header', 'true');
        }
        $cnode->appendChild($fnode);
        %class = ();
      }
    }
  } elsif ($state == $s_table) {
    if ( /^Value$/ ){
      $state = $s_value;
    } else {
    #  $class{'doc'} = $class{'doc'}.$_."\n";
    }
  } elsif ($state == $s_value ){ 
    if($v%2==0){ 
      s/ /_/g;
      s/\+/_PLUS/g;
      $vnode = new_node('value',$_);
      $cnode->appendChild($vnode);
    } else {
      $vnode->setAttribute('value', $_);
    }
    $v ++ ;
  } elsif ($state == $s_doc) {
    $class{'doc'} = $class{'doc'}.$_."\n";
  }
}

my $writer = $impl->createDOMWriter();
if ($writer->canSetFeature('format-pretty-print',1)) {
  $writer->setFeature('format-pretty-print',1);
}
my $target = XML::Xerces::StdOutFormatTarget->new();
$writer->writeNode($target,$doc);

END {
# NOTICE: We must now explicitly call XMLPlatformUtils::Terminate()
#   when the module is unloaded. Xerces.pm no longer does this for us
#
#
  XML::Xerces::XMLPlatformUtils::Terminate();
}

sub new_node {
  my ($name,$name_attr) = @_;
  $n = $doc->createElement($name);
  if (defined($name_attr)) {
    $n->setAttribute('name',$name_attr);
  }
  return $n;
}
sub add_text {
  my ($node,$name,$text) = @_;
  $node1 = $doc->createElement($name);
  $t = join (".\n*",split (/\./,$text));
  $node2 = $doc->createTextNode($t);
  $node1->appendChild($node2);
  $node->appendChild($node1);
  return $node;
}
