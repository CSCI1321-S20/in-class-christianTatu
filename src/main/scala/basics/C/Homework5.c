/*
 * Program to check a palindrome
 */
#include <stdio.h>
#include <string.h>
#include <ctype.h>

int isPal(char line[], int start, int end)
{
    while (start <= end)
    {
        if (tolower(line[start]) == tolower(line[end]))
        {
            start++;
            end--;
        }
        else
            return 0;
    }
    return 1;
}


int main(void)
{
    printf("enter a line of text: \n");
    char line[1000];
    fgets(line, sizeof line, stdin);
    char *nl = strchr(line, '\n');
    if (nl == NULL)
    {
        printf("line too long\n");
        return 1;
    }
    else
    {
        int i = 0;
        int j = 0;
        char lineCP[1000];
        while (i < strlen(line))
        {
            if (isalnum(line[i]))
            {
                lineCP[j] = line[i];
                i++;
                j++;
            }
            else
            {
                i++;
            }
        }
        int start = 0;
        int end = j;
        printf("input %s", line);
        if (isPal(lineCP, start, end-1) == 1)
            printf("a palindrome");
        else
            printf("not a palindrome");
    }
    return 0;
}

/*
This assignment was straight forward. The only issue I had was the import statements, and then figuring out how to deal with C taking enter
isPal was easy enough to write, but the entering a line of textwas a littlebit messy.

I was helped (a little) by ACM tutors on this assignment

Pledged, Christian Tatu */



