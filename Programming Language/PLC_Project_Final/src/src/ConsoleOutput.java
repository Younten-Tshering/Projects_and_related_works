/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package src;

/**
 *
 * @author Younten
 */
public class ConsoleOutput {
    
    private static volatile ConsoleOutput instance = null;
    
    private ConsoleOutput() {};
    
    private String output = "";
    private OutputType outputType = OutputType.OUTPUT;
    
    public static ConsoleOutput getInstance(){
        if(instance == null){
            synchronized(ConsoleOutput.class){
                if(instance == null){
                    instance = new ConsoleOutput();
                }
            }
        }
        return instance;
    }
    
    public void setText(String text) {
        this.output = output + text + "\n";
    }
    
    public void setText(String text, OutputType type) {
        
        this.output = output + text + "\n";
        this.outputType = type;
    }
    
    public String getText() {
        return this.output;
    }
    
    public OutputType getOutputType() {
        return this.outputType;
    }
    
    public void clear() {
        this.output = "";
    }
    
    public enum OutputType {
        OUTPUT,
        ERROR
    }
}

