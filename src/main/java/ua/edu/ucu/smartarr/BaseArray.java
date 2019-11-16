package ua.edu.ucu.smartarr;

// Base array for decorators
public class BaseArray implements SmartArray
{
    public Object[] arr;

    public BaseArray(Object[] initArray)
    {
        this.arr = initArray.clone(); //clone is fine for arrays.
    }

    @Override
    public Object[] toArray()
    {
        return this.arr.clone(); //ensure immutability.
    }

    @Override
    public int size()
    {
        return this.arr.length;
    }

    @Override
    public String operationDescription()
    {
        return "No operations have been invoked on this array.";
    }
}
