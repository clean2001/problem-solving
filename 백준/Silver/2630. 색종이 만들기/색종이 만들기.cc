//2630 색종이 만들기
#include <iostream>
#define max 128
int graph[max][max];
int wcnt = 0;
int bcnt = 0;
using namespace std;

int whatcolor(int startRow, int startCol, int n);
void divide(int startRow, int startCol, int n);

int main(void)
{
	int n = 0;

	cin >> n;

	for (int i = 0; i < n; i++)
		for (int j = 0; j < n; j++)
			cin >> graph[i][j];

	divide(0, 0, n);

	cout << wcnt << "\n" << bcnt << endl;

	return 0;
}

void divide(int startRow, int startCol, int n)
{
	int color = whatcolor(startRow, startCol, n);

	if (color == -1)
	{
		divide(startRow, startCol, n / 2);
		divide(startRow+n/2 , startCol, n / 2);
		divide(startRow, startCol+n/2, n / 2);
		divide(startRow +n/2, startCol+n/2, n / 2);
	}
	else if (color == 0)
	{
		wcnt++;
		return;
	}
	else
	{
		bcnt++;
		return;
	}
}

int whatcolor(int startRow, int startCol, int n) //0이면 흰, 1이면 파, 다르면 -1
{
	int color = graph[startRow][startCol];
	for (int i = startRow; i < n+ startRow; i++)
	{
		for (int j = startCol; j < n+ startCol; j++)
		{
			if (graph[i][j] != color)
				return -1;
		}
	}

	return color;
}

