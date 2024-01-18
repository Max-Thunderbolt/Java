public class ArrayProcessor {

    public int[] reverseArray(int[] array){
        //Check to see if array passed in is populated
        if(array == null){
            throw new NullPointerException("Array is null");
        }

        int[] reversedArray = new int[array.length];
        for (int i = 0; i < array.length; i++){
            reversedArray[i] = array[array.length - 1 - i];
        }
        return reversedArray;
    }

    public int getElementAtIndex(int index, int[] array){
        if (array == null){
            throw new NullPointerException("Array is null");
        }
        //Check to see if index is out of bounds
        if(index >= array.length || index < 0){
            throw new IndexOutOfBoundsException("Index is out of bounds");
        }


        return array[index];
    }
}
