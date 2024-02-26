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

	//모든 높이에 대해서 다 해보기.
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
				if (land[i][j] > h) //블록 제거 2초
				{
					gap = (land[i][j] - h);
					BCopy += gap;
					land[i][j] = h;
					time += gap * 2;
				}
				else if (land[i][j] < h) //쌓기 1초
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
