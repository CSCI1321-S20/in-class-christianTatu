/*
 * program to compare 3 ints, then print in order of lowest to highest
 */
#include <stdio.h>

int main(void) {
	printf("enter 3 integers\n");
	int a = 0;
	int b = 0;
    int c = 0;
    int largest = 0;
    int middle = 0;
    int smallest = 0;

	//scanf("%d %d %d", &a,&b,&c);
    if(scanf("%d %d %d", &a,&b,&c) != 3) {
        printf("One of your inputs is not valid.");
        return 0;
    }

   if (a >= b && a >= c) {
        largest = a; 
        if(b > c) {
            middle = b;
            smallest = c;
            } else {
                middle = c;
                smallest = b;
            }
       
   
    }else if(a <= b && a <= c) {
        smallest = a;
        if( b >= c) {
            largest = b;
            middle = c;
        } else {
            middle = b ;
            largest = c;
        }
    }else if (a <= b && a >= c ) {
        largest = b;
        middle = a;
        smallest = c;
        } else {
        largest = c;
        middle = b;
        smallest = a;
        }

    printf("largest is %d\n middle is %d\n smallest is %d\n", largest, middle, smallest);	

    /*
 * I got help with this assignment from ACM Tutoring (Kenny)
 * I found this to be extremley tedious, as i couldn't store the values into an array and just sort it.
 */
}


