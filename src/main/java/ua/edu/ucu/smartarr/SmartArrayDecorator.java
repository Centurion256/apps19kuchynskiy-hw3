package ua.edu.ucu.smartarr;

abstract class SmartArrayDecorator implements SmartArray {

    protected SmartArray wrapped;

    SmartArrayDecorator(SmartArray smartArray) {
        this.wrapped = smartArray;
    }

    @Override
    public int size() {
        return this.wrapped.size();
    }

    @Override
    public String operationDescription() 
    {
        
        return this.wrapped.operationDescription();
    }

    @Override
    public Object[] toArray() 
    {

        return this.wrapped.toArray();
    }

}
