#include <stdio.h> 
 
void swap(int *a, int *b) { 
    int temp = *a;   /* save the value at a */ 
    *a = *b;         /* put b's value into a's location */ 
    *b = temp;       /* put saved value into b's location */ 
} 
 void broken_swap(int a, int b) {
    int temp = a;
    a = b;
    b = temp;

    /* This does not change the original variables because
       the function receives copies of the values, not their addresses. */
}
int main() {
    int x = 10;
    int y = 20;

    printf("Before swap: x = %d, y = %d\n", x, y);

    swap(&x, &y);

    printf("After swap:  x = %d, y = %d\n", x, y);

    int a = 10;
    int b = 20;

    printf("Before broken_swap: a = %d, b = %d\n", a, b);

    broken_swap(a, b);

    printf("After broken_swap:  a = %d, b = %d\n", a, b);

    return 0;
}