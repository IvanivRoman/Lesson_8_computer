package org.example;

public class App {

  public static void main(String[] args) {
    Computer c = new Computer();
    c.findText(null, " ");
  }

  public static int[] deleteElement(int[] arr, int number) {
    int count = 0;

    for (int i = 0; i < arr.length; i++) {
      if (arr[i] == number) {
        count++;
      }
    }

    int[] result = new int[arr.length - count];

    for (int i = 0, j = 0; i < arr.length; i++) {
      if (arr[i] != number) {
        result[j] = arr[i];
        j++;
      }
    }

    return result;
  }

}

