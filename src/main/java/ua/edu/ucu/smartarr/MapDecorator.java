package ua.edu.ucu.smartarr;

import java.util.Arrays;

import ua.edu.ucu.functions.MyFunction;

// Map every element to another object using MyFunction
public class MapDecorator extends SmartArrayDecorator 
{
    private MyFunction func;

    public MapDecorator(SmartArray array, MyFunction func)
    {
        super(array);
        this.func = func;
    }

    @Override
    public String operationDescription() {

        return "A function has been applied to the array";
    }

    @Override
    public int size() {
        
        return this.toArray().length;
    }

    @Override
    public Object[] toArray() {

        return Arrays.stream(super.toArray()).map(func::apply).toArray();
    }

}
