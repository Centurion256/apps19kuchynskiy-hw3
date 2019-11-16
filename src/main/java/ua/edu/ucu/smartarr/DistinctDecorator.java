package ua.edu.ucu.smartarr;

import java.util.Arrays;
import java.util.HashSet;
import java.util.stream.Collector;
import java.util.stream.Collectors;

// Remove duplicates from SmartArray. Use method equals() to compare objects
public class DistinctDecorator extends SmartArrayDecorator {
    public DistinctDecorator(SmartArray array) {
        super(array);
    }

    @Override
    public String operationDescription() 
    {
        return "All duplicates have been removed from the array.";
    }

    @Override
    public int size() 
    {

        return this.toArray().length;
    }

    @Override
    public Object[] toArray() 
    {
        //curr_super.toArray();
        //Method distinct() from StreamAPI uses equals() to compare items.
        // return Arrays.asList(super.toArray()).stream().distinct()
        // .collect(Collectors.toList()).toArray();
        return new HashSet<Object>(Arrays.asList(super.toArray())).toArray();
    }

}
