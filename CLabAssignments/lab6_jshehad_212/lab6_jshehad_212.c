/*
 * Jihad Shehadeh G00986964
 * CS 262, Lab Section 212
 * Lab 6
 */

#include <stdlib.h>
#include <stdio.h>
#include <string.h>

#define BYTETOBINARYPATTERN "%d%d%d%d%d%d%d%d"
#define BYTETOBINARY(byte) \
(byte & 0x80 ? 1 : 0), \
(byte & 0x40 ? 1 : 0), \
(byte & 0x20 ? 1 : 0), \
(byte & 0x10 ? 1 : 0), \
(byte & 0x08 ? 1 : 0), \
(byte & 0x04 ? 1 : 0), \
(byte & 0x02 ? 1 : 0), \
(byte & 0x01 ? 1 : 0)
#define PRINTBIN(x) printf(BYTETOBINARYPATTERN, BYTETOBINARY(x));

unsigned char unsetBit(unsigned char a, int i){
	unsigned char msk = ~(1 << i);
	return a & msk;
}

unsigned char setBit(unsigned char a, int i, int b){
	return a | (b << i);
}

void setlsbs(unsigned char *p, unsigned char b0){
	for(int i = 0; i < 8; i++){
		p[i] = unsetBit(p[i], 0);
		p[i] = setBit(p[i], 0, (b0 >> i) & 1);
	}
}

unsigned char getlsbs(unsigned char* p){
	unsigned char ret = 0;
	for(int i = 0; i < 8; i++)
		ret |= ((p[i] & 1) << i);
	return ret;
}

void printArray(unsigned char* p){
	for(int i = 0; i < 8; i++) {
		printf("p[%d]: %d\n", i, p[i]);
		PRINTBIN(p[i]);
		printf("\n\n");
	}
}

int main(int argc, char* argv[]){
	if(argc > 2) {

		printf("Too many arguments. Expected 1, found %d\n", argc - 1);
		return 0;
	}
	if(argc < 2) {

		printf("Too few arguments. Expected 1, found %d\n", argc - 1);
		return 0;
	}
	
	int seed;
	sscanf(argv[1], "%d", &seed);
	srandom(seed);

	unsigned char p[8];
	for(int i = 0; i < 8; i++) 
		p[i] = random();
	
	unsigned char byte0 = random();
	
	printf("byte0: %d\n", byte0);
	PRINTBIN(byte0);
	printf("\n\n");
	printf("Before modification:\n\n");
	
	printArray(p);

	setlsbs(p, byte0);
	
	printf("After modification\n\n");
		
	printArray(p);

	unsigned char byte1 = getlsbs(p);
	printf("byte1: %d\n", byte1);
	PRINTBIN(byte1);
	printf("\n\n");

	if(byte0 == byte1) puts("MATCH");
	else puts("WRONG");
}
