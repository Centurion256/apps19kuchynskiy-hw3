package ua.edu.ucu.smartarr;

import java.util.Arrays;

import ua.edu.ucu.functions.MyPredicate;

// Tests every element and removes it if it doesn't satisfy MyPredicate
public class FilterDecorator extends SmartArrayDecorator {

    private MyPredicate filter;

    public FilterDecorator(SmartArray array, MyPredicate predicate)
    {
        super(array);
        this.filter = predicate;
    }

    @Override
    public String operationDescription() 
    {
        return "Array has been filtered via filter decorator";
    }

    @Override
    public int size() 
    {
        return this.toArray().length;
    }

    @Override
    public Object[] toArray() {
        
        return Arrays.stream(super.toArray()).filter(filter::test).toArray();
    }
   
}
