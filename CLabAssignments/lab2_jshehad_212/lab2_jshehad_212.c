/* Jihad Shehadeh G00986964
 * CS 262, Lab Section 212
 * Lab 2
 */

#include <stdio.h>
#include <stdlib.h>
#include <math.h>

int main(){
	char Buffer[100];
	int ftemp = 0;
	double wind = 0.0;
	double wChill = 0.0;

	printf("Enter the Temp: \n");
	fgets(Buffer, 100, stdin);
	sscanf(Buffer, "%d",  &ftemp);
	if(ftemp > 50){
		printf("error, Number Should NOT exceed Above 50F\n");
		return 0;
	}
	printf("Enter the wind speed: \n");
	fgets(Buffer, 100, stdin);
	sscanf(Buffer, "%lf", &wind);
	if(wind < 3){
		printf("error, Number Should NOT exceed Below 3mph\n");
		return 0;
	}
	
	wChill = (35.74+0.6215*(ftemp)-35.75*pow(wind,0.16)+0.4275*(ftemp)*pow(wind,0.16));
	printf("Temperature: %d degrees Fahrenheit\n", ftemp);
	printf("Wind Speed: %.1lf mph\n", wind);
	printf("Wind Chill Index: %.1lf degrees Fahrenheit\n", wChill);
	return 0;

	return 0;
}

