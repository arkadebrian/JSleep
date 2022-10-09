package ArkaBrianJSleepRJ;

/**This class will be the parent of a lot of other classes*/
public class Serializable {
    /**To identify anything, something must have an ID*/
    public int id;
    
    /**So, ID will be inherited to a lot of other classes*/
    public Serializable(int id) {
        this.id = id;
    }
}
