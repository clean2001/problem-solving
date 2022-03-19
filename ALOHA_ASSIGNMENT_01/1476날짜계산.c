#include <stdio.h>

int main(void)
{
	int E, S, M;
	int e, s, m;
	int year = 0;

	scanf("%d %d %d", &E, &S, &M);
	e = E;
	s = S;
	m = M;

	if (E == 15)	e = 0;
	if (S == 28)	s = 0;
	if (M == 19)	m = 0;

	while (1)
	{

		if (E == 15 && S == 28 && M == 19)
		{
			year = 7980;
			break;
		}

		if (year % 15 == e && year % 28 == s && year % 19 == m)
			break;

		year++;
	}

	printf("%d\n", year);
}