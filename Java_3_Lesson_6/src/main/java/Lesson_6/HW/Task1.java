package Lesson_6.HW;

public class Task1 {
    public int[] checkArray(int[] array) throws RuntimeException {
        int[] newArray;
        boolean done = false;
        int i;
        i = array.length - 1;
        int j = 0;
        while (i >= 0 && !done) {
            done = array[i] == 4;
            j = i;
            i--;
        }
        if(done) {
            newArray = new int[array.length - j - 1];
            for (i = j + 1; i < array.length; i++) {
                newArray[i - j - 1] = array[i];
            }
        } else {
            throw new RuntimeException("Array doesn't contain '4' ");
        }
        return  newArray;
    }
}

