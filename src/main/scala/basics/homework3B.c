/*
 * program to do GCD
 */
#include <stdio.h>

long gcd(long a, long b) {
    if (b == 0) {
        return a;
    } 
    else{
       return gcd(b, a % b);
    }

    

}


int main(void) {
	printf("enter 2 non-negative integers\n");
	long a = 0;
	long b = 0;

    if(scanf("%ld %ld", &a,&b) != 2) {
        printf("One of your inputs is not an integer.");
        return 0;
    }

     if(a < 0 && b < 0) {
        printf("One of your inputs is not positive.");
        return 0;
     }
        else if(a == 0 && b == 0) {
            printf("Both inputs are 0.");
        return 0;
        }


    long final = gcd(a,b);
    printf("The Greatest Common Denominator of %ld and %ld is %ld", a,b,final);
}



/*
 * program to doGCD
 
// def gcd(a: Int,b: Int):Int = {
//     if (b == 0) a
    
//     else 

//     gcd(b, a % b)

// 
    pledged, Christian Tatu
    This assignment is entirely my own work. 
*/