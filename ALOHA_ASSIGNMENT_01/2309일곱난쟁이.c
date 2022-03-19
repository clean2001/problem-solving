#define _CRT_SECURE_NO_WARNINGS

#include <stdio.h>
int main(void)
{
	int height[9];
	int total = 0, twoSum = 0;
	int i, j, temp;
	int num1, num2;

	for (i = 0; i < 9; i++)
	{
		scanf("%d", &height[i]);
		total += height[i];
	}
	
	for (i = 0; i < 8; i++)
	{
		for (j = 0; j < 8-i; j++)
			if (height[j] > height[j+1])
			{
				temp = height[j];
				height[j] = height[j+1];
				height[j+1] = temp;
			}
	}
		

	// 여기 다시 공부!!
	for (i = 0; i < 9; i++)
	{
		for (j = i+1; j < 9; j++)
		{
			twoSum = height[i] + height[j];

			if (total - twoSum == 100)
			{
				num1 = i;
				num2 = j;
				break;
			}
		}

		if (total - twoSum == 100)
			break;
	}

	for (i = 0; i < 9; i++)
		if (i != num1 && i != num2)
			printf("%d\n", height[i]);

	return 0;

}
