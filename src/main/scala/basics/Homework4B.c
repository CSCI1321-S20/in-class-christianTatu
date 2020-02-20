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

	for( int i = 0; i < num_samples; i++) {
        int x = rand();
        int ind= x / num_bins;
        if(ind < 1* (RAND_MAX/6)){
            arr[0] = arr[0] +1;
        }        
        if(ind < 2* (RAND_MAX/6)){
            arr[1] = arr[1] +1;
        }        
        if(ind < 3* (RAND_MAX/6)){
            arr[2] = arr[2] +1;
        }
        if(ind < 4* (RAND_MAX/6)){
            arr[3] = arr[3] +1;
        }
        if(ind < 5* (RAND_MAX/6)){
            arr[4] = arr[4] +1;
        }
        if(ind < 6* (RAND_MAX/6)){
            arr[5] = arr[5] +1;
        }        
    }

    printf("counts using quotient method: ");
    for( int i = 0; i < num_bins; i++)  {
        printf("(%d) %d\n",i,arr[i]); 
    }


}