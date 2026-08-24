#include <stdio.h>

void print_math(int a, int b) {
    printf("Sum: %d\n", a + b);
    printf("Product: %d\n", a * b);
}

int main() {
    int num1;
    int num2;

    printf("Enter two integers: ");
    scanf("%d %d", &num1, &num2);

    print_math(num1, num2);

    return 0;
}