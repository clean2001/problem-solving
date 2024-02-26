#define _CRT_SECURE_NO_WARNINGS

#include <stdio.h>
#include <stdlib.h>
int main(void)
{
	int N, M, B;
	int i, j;
	int h = 0, rightH = 0;
	int time = 0, minTime = -1;
	int BCopy;
	int gap;

	scanf("%d %d %d", &N, &M, &B);

	int** land = (int**)malloc(sizeof(int*) * N);
	int** init = (int**)malloc(sizeof(int*) * N);
	for (i = 0; i < N; i++)
		land[i] = (int*)malloc(sizeof(int) * M);

	for (i = 0; i < N; i++)
		init[i] = (int*)malloc(sizeof(int) * M);

	for (i = 0; i < N; i++)
		for (j = 0; j < M; j++)
			scanf("%d", &init[i][j]);

	//��� ���̿� ���ؼ� �� �غ���.
	for (h = 0; h <= 256; h++)
	{
		time = 0;
		BCopy = B;
		for (i = 0; i < N; i++)
			for (j = 0; j < M; j++)
				land[i][j] = init[i][j];

		for (i = 0; i < N; i++)
		{
			for (j = 0; j < M; j++)
			{
				if (land[i][j] > h) //��� ���� 2��
				{
					gap = (land[i][j] - h);
					BCopy += gap;
					land[i][j] = h;
					time += gap * 2;
				}
				else if (land[i][j] < h) //�ױ� 1��
				{
					gap = (h - land[i][j]);
					BCopy -= gap;
					land[i][j] = h;
					time += gap;
				}
			}


		}
		
		if (BCopy < 0)
			continue;

		if (minTime < 0 && BCopy >= 0)
			minTime = time;
		else if (minTime > time && BCopy >=0)
		{
			minTime = time;
			rightH = h;
		}
		else if(minTime == time && rightH < h)
		{
			rightH = h;
		}

	}

	printf("%d %d\n", minTime, rightH);

	free(land);
	free(init);

	return 0;
}
