/*
 * Jihad Shehadeh G00986964
 * CS 262, Lab Section 212
 * Lab 3
 */

#include <stdio.h>
#include <stdlib.h>

char enterChar();
int numValue();
void rectOne(int N, char C);
void rectTwo(int N, char C);

int main()
{
	int N = 0;
	char C = ' ';

	while(1){
	printf("Change Character Enter 'C'\n");
	printf("Change Number Enter 'N'\n");
	printf("Print Rectangle Type 1 (Border Only) Enter '1'\n");
	printf("Print Rectangle Type 2 (Filled In) Enter '2'\n");
	printf("Quit Program Enter 'Q'\n");
	printf("\n");

	char Buffer[100];
	char userChoice;
	printf("Enter a Choice: ");
	fgets(Buffer,100,stdin);
	sscanf(Buffer, "%c", &userChoice);
	printf("\n");

	switch (userChoice)
	{

		case 'C':
		case 'c':
			C = enterChar();
			printf("\n");
			break;
		case 'N':
		case 'n':
			N = numValue();
			printf("\n");
			break;
		case '1':
			rectOne(N,C);
			printf("\n");
			break;
		case '2':
			rectTwo(N,C);
			printf("\n");
			break;
		case 'Q':
		case 'q':
			fprintf(stdout,"Exiting the program...\n\n");
			exit(1);
		default:
			break;

		}
	
	}  
}
char enterChar()
{
	char character = ' ';
	fprintf(stdout,"Enter a Character: ");
	scanf("%c", &character);
	return character;
}

int numValue()
{
	
	int num = 0;
	fprintf(stdout,"Enter a number between 1 and 15\n");
	scanf("%d",&num);

	while(num <= 1 || num >= 15)
	{
	fprintf(stdout,"You have enter an invalid number\n");
	fprintf(stdout,"Please try again\n");
	fprintf(stdout,"Enter a number between 1 and 15\n");
	scanf("%d",&num);
	}
	return num;
}

void rectOne(int N, char C)
{
	int i,j;
	i=0;
	while(i < N)
	{
		j=0;
		while(j < N)
		{
			if(i==0 || i == N -1|| j == 0 || j == N-1)
			{
				printf("%c", C);
			}
			else
			{
				printf(" ");
			}
			j++;
		}
		printf("\n");
		i++;
	}
}

void rectTwo(int N, char C)
{
	//int number;
	int i,j;
	// obtain input
	//printf("enter number: ");
	//scanf("%d", &number);
	
	for(i=1; i <= N; i++)
	{
		for(j=1; j <= N; j++)
		{
			printf("%c", C);
		}
		printf("\n");
	}
}

