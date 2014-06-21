#include <stdio.h>
#include <string.h>

int main() {
  char buf[256];
  while (true) {
    scanf("%s", &buf);
    if (strcmp(buf,"exit") == 0) {
      return 0;
    }
    printf("echo %s\n", buf);
  }
  return 0;
}
