package ua.edu.ucu.smartarr;

import java.util.Arrays;
import ua.edu.ucu.functions.MyComparator;

// Sorts elements using MyComparator to compare them
public class SortDecorator extends SmartArrayDecorator
{
    private MyComparator compare;

    public SortDecorator(SmartArray array, MyComparator compare)
    {
        super(array);
        this.compare = compare;
    }

    @Override
    public Object[] toArray()
    {
        return Arrays.stream(super.toArray()).sorted(compare).toArray();
    }
    @Override
    public String operationDescription()
    {
        return "Array has been sorted using the sorting decorator";
    }
    
}
