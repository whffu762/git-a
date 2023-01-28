#include<stdio.h>
#include<string.h>

int main() {
	int i;
	char str[100] = { "a barking dogs never bites" };
	char asc[127] = { 0, };

	for (i = 0; str[i]; i++) 
	{
		asc[str[i]]++;
	}

	for (i = 0; str[i]; i++) 
	{
		if (asc[str[i]] == 0)
		{
			continue;
		}
		else 
		{
			printf("%c문자가 %d번 등장하였음!\n", str[i], asc[str[i]]);
			asc[str[i]] = 0;
		}
	}
}