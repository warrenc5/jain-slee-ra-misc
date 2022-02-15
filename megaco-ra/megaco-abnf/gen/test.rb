require 'pp'
require 'abnf'

# URI-reference [RFC2396]
pp ABNF.regexp_tree(<<-'End')

digitMap = (digitString / LWSP "(" LWSP digitStringList LWSP ")" LWSP)

digitStringList = digitString *( LWSP "|" LWSP digitString )

digitString = 1*(digitStringElement)

digitStringElement = digitPosition [DOT]

digitPosition = digitMapLetter / digitMapRange

digitMapRange = ("x" / (LWSP "[" LWSP digitLetter LWSP "]" LWSP))

digitLetter = *((DIGIT "-" DIGIT) /digitMapLetter)

digitMapLetter = DIGIT           ;digits 0-9 / %x41-4B / %x61-6B    ;a-k and A-K / "L"/ "S"       ;Inter-event timers ;(long, short) / "Z"            

;Long duration event

DOT = %x2E ; "."

LWSP = *(WSP / COMMENT / EOL)

WSP = SP / HTAB

COMMENT = ";" *(SafeChar / RestChar / WSP) EOL

EOL = (CR [LF]) / LF

SP = %x20

HTAB = %x09

CR = %x0D

LF = %x0A

SafeChar = DIGIT / ALPHA / "+" / "-" / "&" / "!" / "_" / "/" / "'" / "?" / "@" / "^" / "`" / "~" / "*" / "$" / "\" / "(" / ")" / "%" / "."

RestChar = ";" / "[" / "]" / "{" / "}" / ":" / "," / "#" / "<" / ">" / "=" / %x22

DIGIT = %x30-39       

; digits 0 through 9

ALPHA = %x41-5A / %x61-7A; A-Z, a-z

End


