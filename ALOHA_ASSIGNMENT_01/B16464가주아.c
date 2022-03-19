#define _CRT_SECURE_NO_WARNINGS
#include <stdio.h>
//가주아 블랙잭
int main(void)
{
	int testCase;
	int i = 0;
	int num;

	scanf("%d", &testCase);

	i = 0;
	while (i < testCase)
	{
		scanf("%d", &num);

		while (num % 2 == 0)
			num /= 2;

		if (num != 1)
			printf("Gazua\n");
		else
			printf("GoHanGang\n");

		i++;

	}
	return 0;
}