#include <stdio.h>

void reverseStr(char *str) {
	char *end = str;
	// 找出字符串末尾
	if (str) {
		while (*end != NULL) {
			end++;
		}
	}
	// 回退一个字符，最后一个为null字符
	--end;  
	while (str < end) {
		char temp = *str;
		*str = *end;
		*end = temp;
		str++;
		end--;
	}
}

void main() {
	char s[] = "abcdefgn";
	reverseStr(s);
	printf("%s\n", s);
}
