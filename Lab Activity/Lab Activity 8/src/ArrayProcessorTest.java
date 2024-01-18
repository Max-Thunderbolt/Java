import org.junit.Assert;
import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class ArrayProcessorTest {
    ArrayProcessor arrayProcessor = new ArrayProcessor();

    @Test
    public void testReverseArray() throws Exception {
        int[] result = arrayProcessor.reverseArray(new int[]{0});
        Assert.assertArrayEquals(new int[]{0}, result);
    }

    @Test
    public void testReverseArray_NullArray() throws Exception {
        try {
            arrayProcessor.reverseArray(null);
            Assert.fail("Expected NullPointerException to be thrown");
        } catch (NullPointerException ex) {
            assertEquals("Array is null", ex.getMessage());
        }
    }

    @Test
    public void testGetElementAtIndex() throws Exception {
        int result = arrayProcessor.getElementAtIndex(0, new int[]{0});
        assertEquals(0, result);
    }

    @Test
    public void testGetElementAtIndex_OutOfBoundsIndex() throws Exception{
        int index = -1;
        int[] array = new int[]{0};
        try {
            arrayProcessor.getElementAtIndex(index, array);
            Assert.fail("Expected IndexOutOfBoundsException to be thrown");
        } catch (IndexOutOfBoundsException ex) {
            assertEquals("Index is out of bounds", ex.getMessage());
        }
    }

    @Test
    public void testGetElementAtIndex_NullArray() throws Exception{
        int index = 0;
        int[] array = null;
        try {
            arrayProcessor.getElementAtIndex(index, array);
            Assert.fail("Expected NullPointerException to be thrown");
        } catch (NullPointerException ex) {
            assertEquals("Array is null", ex.getMessage());
        }
    }
}

//Generated with love by TestMe :) Please report issues and submit feature requests at: https://weirddev.com/forum#!/testme