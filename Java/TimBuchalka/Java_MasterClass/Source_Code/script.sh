find /Users/Production/Tharpa/VARIOS/Github/Java_Udemy_TimBuchalka_Source_Code/Eclipse -depth -name '*__*' \
    -execdir bash -c 'mv "$1" "${1//__/_}"' _ {} \;
