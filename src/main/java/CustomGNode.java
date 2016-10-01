/**
 * Created by wilbur on 10/1/16.
 */
public class CustomGNode implements GNode {

    private String name;
    private GNode[] children;

    public CustomGNode(String name, GNode[] children) {
        this.name = name;
        this.children = children;
    }

//    public CustomGNode() {
//
//    }

    public String getName() {
        return name;
    }

    public GNode[] getChildren() {
        return children;
    }

    @Override
    public String toString() {
        return name;
    }


}
