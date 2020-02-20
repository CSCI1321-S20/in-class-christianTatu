/*
 * Programc omputing the square root of a non-negative number $x$
 */
#include <stdio.h>
#include <math.h>
/* main program */
int main(void) {
    int x, iterations, iter;
    double threshold, result, comp;
    float diff;
    printf("enter values for input, threshold, maximum iterations\n");
    scanf( "%d %lf %d", &x, &threshold, &iterations);
    iter = 0;
    diff = 1000;
    comp = sqrt(x);
    result = x;

        while(iterations >= iter && diff >= threshold) {
            result = (result + (x / result)) / 2.0;
            iter += 1;
            diff = fabs(result*result) - x;
	    }
    /*
     printf("\n %d %lf %d\n", x, threshold, iterations);
    */

    printf("square root of %d:\n", x);
    printf("with newton's method (threshold %lf): %lf (%d iterations)\n", threshold, result, iter);
    printf("using library function:     %lf\n", comp);
    printf("difference:     %lf\n", diff);

}


/*
 * Pledged, Christian Tatu
 * 
 * This work is entirely my own work
 * 
 * I found this assigment initally confusing, but once
 *  I configured the wile loop, it was much more managable. I originally coded it
 * in scala then re-wrote it into C, and found that C was better for this assigment
 * compared to scala. yay!
 */

