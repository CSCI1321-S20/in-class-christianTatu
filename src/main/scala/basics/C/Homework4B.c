#include <stdio.h>
#include <stdlib.h> /* has rand(), srand(), RAND_MAX */

int main(void) {

	int seed;
	int num_bins;
    int num_samples;

	printf("seed?\n");
	if (scanf("%d", &seed) != 1) {
		printf("invalid input\n");
		return 1;
	}
	if (seed <= 0) {
		printf("invalid input\n");
		return 1;
	}

    printf("number of bins?\n");
	if (scanf("%d", &num_bins) != 1) {
		printf("invalid input\n");
		return 1;
	}
	if (num_bins <= 0) {
		printf("invalid input\n");
		return 1;
	}


    printf("how many samples?\n");
	if (scanf("%d", &num_samples) != 1) {
		printf("invalid input\n");
		return 1;
	}
	if (num_samples <= 0) {
		printf("invalid input\n");
		return 1;
	}

	

	/* FIXME:  
	 * replace the rest of this code with your code (but okay to keep
	 * anything you think will help).
	 */
    srand(seed);
    int arr[num_bins];
 

   /* remainder method */
    for (int i = 0; i < num_bins; i++) {
        arr[i] = 0;
    }

	for( int i = 0; i < num_samples; i++) {
        int x = rand();
        int ind= x % num_bins;
        arr[ind] = arr[ind] +1; 
    }

    printf("counts using remainder method: \n");
    for( int i = 0; i < num_bins; i++)  {
        printf("(%d) %d\n",i,arr[i]); 
    }

	/* quotient method */

    for (int i = 0; i < num_bins; i++) {
        arr[i] = 0;
    }
	    
	srand(seed);

	for( int i = 0; i < num_samples; i++) {
        int x = rand();
        int ind= (int) ((((double) num_bins) * x)/(RAND_MAX+1.0));
        arr[ind] = arr[ind] +1;
    }
	
    printf("counts using quotient method: \n");
    for( int i = 0; i < num_bins; i++)  {
        printf("(%d) %d\n",i,arr[i]); 
    
    }

	/*
	AAAAAAAAAAAAAAAAAAAAAAAAAAAAAAa
	This assignment was weird, I didn't relaly understand the problem until I went to ACM and the concept was explained to me.
	The code itself wasn't too challenging, but I had several small errors that took a while to figure out */
}