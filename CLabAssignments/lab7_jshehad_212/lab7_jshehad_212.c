#include <stdio.h>
#include <stdlib.h>
#include <string.h>

int findNextSpace(char* s, int len, int st) {
	int i;
	for (i = st + 1; i < len; ++i)
		if (s[i] == ' ')
			return i;
	return i;
}

void printString(char* s) {
	int len = strlen(s), line = 0;
	for (int i = 0; i < len;) {
		int j = findNextSpace(s, len, i);
		if (line + j - i + 1 > 80) {
			printf("\n"), line = 0;
			if (s[i] == ' ')
				++i;
		}
		line += j - i;
		while (i < j)
			printf("%c", s[i++]);
	}
}

void printInfo(char* name, char* labSection) {
	printString("Name: ");
	printString(name);
	puts("");
	printf("Lab Section: ");
	printString(labSection);
	puts("");
}

void progDescription() {
	printString("This program creates an array of numbers and prints it, a"
			" permutation of that array and prints that, and sorts the array"
			" descendigly using qsort function and prints the sorted array");
	puts("");
}

void initializeArray(int* s, const int N) {
	for (int i = 0; i < N; ++i)
		s[i] = i + 1;
}

int numDigit(int x) {
	int ret = 0;
	while (x) {
		ret++;
		x /= 10;
	}
	return ret;
}

void printArray(int* s, const int N) {
	int line = 0;
	for (int i = 0; i < N; ++i) {
		int nd = numDigit(s[i]);
		if (line + nd + 1 > 80) {
			printf("\n");
			line = 0;
		}
		line += nd + 1;
		printf("%d ", s[i]);
	}
}

void shuffleArray(int* a, int n) {
	for (int i = n - 1; i; --i) {
		int di = random() % (i + 1);
		// swapping
		int tmp = a[di];
		a[di] = a[i];
		a[i] = tmp;
	}
}

int compare(const void* a, const void* b) {
	return (*(int*) b - *(int*) a);
}

int main(int argc, char* argv[]) {
	if (argc != 3) {
		printf("\n%s <seed> <N>\n", argv[0]);
		exit(1);
	}

	int seed, N;
	sscanf(argv[1], "%d", &seed);
	sscanf(argv[2], "%d", &N);

	//pass your name and lab section
	printInfo("Jihad", "212");
	progDescription();

	int* numArray = (int*) malloc(sizeof(int) * N);
	srandom(seed);

	puts("\n------------------------------------------\n");
	for (int i = 0; i < 10; ++i) {
		printf("Iteration: %d\n\n", i+1);
		puts("PRE SHUFFLING: ");
		initializeArray(numArray, N);
		printArray(numArray, N);
		puts("");
		puts("");

		puts("POST SHUFFLING: ");
		shuffleArray(numArray, N);
		printArray(numArray, N);
		puts("");
		puts("");

		puts("POST SORTING: ");
		qsort(numArray, N, sizeof(int), compare);
		printArray(numArray, N);
		puts("");
		puts("");
		puts("------------------------------------------");
	}
}
