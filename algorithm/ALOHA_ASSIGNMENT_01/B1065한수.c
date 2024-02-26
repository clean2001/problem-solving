#define _CRT_SECURE_NO_WARNINGS

//1065 한수
/*
어떤 양의 정수 X의 각 자리가 등차수열을 이룬다면, 그 수를 한수라고 한다.
N을 받았을 때, 1보다 크거나 같고, N보다 작거나 같은 한수의 개수를 출력
*/
#include <stdio.h>
void saveDigit(int num, int* digit);

int main(void)
{
	int N;
	int i, j;
	int digit[4] = { 0 };
	int tmp1, tmp2, tmp3;
	int cnt = 0;

	scanf("%d", &N);

	i = 1;
	while (i <= N)
	{
		if (i >= 100 && i <= 999)
		{
			for (j = 0; j < 4; j++)
				digit[j] = 0;

			saveDigit(i, digit);

			tmp1 = digit[0] - digit[1];
			tmp2 = digit[1] - digit[2];

			if (tmp1 == tmp2)
				cnt++;
		}
		else if (i == 1000)
			break;
		else
			cnt++;
		

		i++;
	}

	printf("%d\n", cnt);

	return 0;
}

void saveDigit(int num, int* digit)
{
	int i = 0;
	while (num>0)
	{
		digit[i] = num % 10;

		num /= 10;
		
		i++;
	}

	return;
}