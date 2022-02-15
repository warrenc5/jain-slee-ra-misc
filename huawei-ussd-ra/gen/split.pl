#!/usr/bin/perl
use File::Path;
my $t;
my $bdir = shift;
my $bdir2 = shift;
my $dir;
my $file;
my $bbdir;

print $ext;

while (<>) {
  if(/\<\?xml/) {
    next;
  }
  if (/^ *$/) {
    next;
  }
  if(/.*package ([0-9A-Za-z.]+);/){
    $fuck = $1;
    $fuck =~ s/\./\//g;
    $dir = $fuck;
    if (/\.om/ && defined($bdir2)) {
      $bbdir = $bdir2;
    }else {
      $bbdir = $bdir;
    }

  }elsif(/---START +([0-9A-Za-z.]+)/){
    $file =$1.'.java';
    $t='';
    next;
  }elsif(/---END/) {
    $fdir = $bbdir.'/src/main/java/'.$dir;
    
    mkpath $fdir;

    $f = $fdir.'/'.$file;
    open (FH,'>',$f);
    print FH $t; 
    close FH;
    $t='';
    next;
  }
  $t=$t.$_;

}
