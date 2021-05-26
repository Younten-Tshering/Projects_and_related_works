/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package src;

/**
 * It is mainly composed of two members variables, value which is of type Object 
 * so as to store the value of any given data type, and the type member variable
 * to store the type of the value that is stored.
 * @author Younten
 */
public class TypeValue {
    private Object value;
    private Type type;
    
    public TypeValue()
    {
        
    }

    public TypeValue(int value)
    {
        type = Type.integer();
        this.value = (Object) value;
    }
    
    public TypeValue(float value)
    {
        type = Type.floating_point();
        this.value = (Object) value;
    }
    
     public TypeValue(String value)
    {
        type = Type.string();
        this.value = (Object) value;
    }

    public TypeValue (boolean mutex)
    {
        type = Type.bool();
        this.value = (Object) mutex;
    }

    public Type getType()
    {
        return type;
    }

    public Object getValue()
    {
        return value;
    }
}
