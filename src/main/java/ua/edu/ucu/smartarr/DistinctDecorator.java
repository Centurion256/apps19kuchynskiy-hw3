package ua.edu.ucu.smartarr;

import java.util.Arrays;

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
        return Arrays.stream(super.toArray()).distinct().toArray();
        // Same function but with list conversion:
        // return Arrays.asList(super.toArray()).stream().distinct()
        // .collect(Collectors.toList()).toArray();
        
        //Same function, but with HashSet:
        // HashSet<Object> studentSet = new 
        //                LinkedHashSet<Object>(Arrays.asList(super.toArray()));

    }

}
