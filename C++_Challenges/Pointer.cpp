/**
 * Pointer.cpp
 *
 * - In this problem, I am to complete the function 'update(int *a, int *b)',
 *   which reads two integers as an argument, to set 'a' with the sum of the two
 *   and set 'b' with the absolute difference of them,
 * - Input: Two integers, 'a' and 'b', separated by a newline.
 * - Output: The updated value of 'a' and 'b' on two different lines.
 */

#include <stdio.h>
#include <stdlib.h>

void update(int *a,int *b) {
    int tempA = *a;
    int tempB = *b;

    *a = *a + *b;
    *b = abs(tempA - tempB);
}

int main() {
    int a, b;
    int *pa = &a, *pb = &b;

    scanf("%d %d", &a, &b);
    update(pa, pb);
    printf("%d\n%d", a, b);

    return 0;
}
