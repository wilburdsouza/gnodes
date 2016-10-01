import org.junit.Assert;
import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by wilbur on 10/1/16.
 */
public class GNodeWalkerTest {

    String input = "A,{B,{E,F}, C, {G, H, I}, D, {J}}";


    @Test
    public void testWalkGraph() {

        GNodeWalker walker = new GNodeWalker();

        List<GNode> expectedGnodes = new ArrayList<GNode>();

        GNode eNode = new CustomGNode("E", new CustomGNode[0]);
        GNode fNode = new CustomGNode("F", new CustomGNode[0]);
        GNode gNode = new CustomGNode("G", new CustomGNode[0]);
        GNode hNode = new CustomGNode("H", new CustomGNode[0]);
        GNode iNode = new CustomGNode("I", new CustomGNode[0]);
        GNode jNode = new CustomGNode("J", new CustomGNode[0]);

        GNode bNode = new CustomGNode("B", new GNode[]{eNode, fNode});
        GNode cNode = new CustomGNode("C", new GNode[]{gNode, hNode, iNode});
        GNode dNode = new CustomGNode("D", new GNode[]{jNode});

        GNode aNode = new CustomGNode("A", new GNode[]{bNode, cNode, dNode});

        expectedGnodes.add(aNode);
        expectedGnodes.add(bNode);
        expectedGnodes.add(eNode);
        expectedGnodes.add(fNode);
        expectedGnodes.add(cNode);
        expectedGnodes.add(gNode);
        expectedGnodes.add(hNode);
        expectedGnodes.add(iNode);
        expectedGnodes.add(dNode);
        expectedGnodes.add(jNode);


        List<GNode> gNodes = walker.walkGraph(aNode);

        System.out.println("actual = "+gNodes);
        System.out.println("expected = "+expectedGnodes);

        Assert.assertEquals(expectedGnodes, gNodes);

    }

    @Test
    public void testPaths() {

        GNodeWalker walker = new GNodeWalker();

        GNode eNode = new CustomGNode("E", new CustomGNode[0]);
        GNode fNode = new CustomGNode("F", new CustomGNode[0]);
        GNode gNode = new CustomGNode("G", new CustomGNode[0]);
        GNode hNode = new CustomGNode("H", new CustomGNode[0]);
        GNode iNode = new CustomGNode("I", new CustomGNode[0]);
        GNode jNode = new CustomGNode("J", new CustomGNode[0]);

        GNode bNode = new CustomGNode("B", new GNode[]{eNode, fNode});
        GNode cNode = new CustomGNode("C", new GNode[]{gNode, hNode, iNode});
        GNode dNode = new CustomGNode("D", new GNode[]{jNode});

        GNode aNode = new CustomGNode("A", new GNode[]{bNode, cNode, dNode});

        List<List<String>> expectedPaths = new ArrayList<List<String>>();

        List path1 = new ArrayList();
        path1.add("A");
        path1.add("B");
        path1.add("E");

        List path2 = new ArrayList();
        path2.add("A");
        path2.add("B");
        path2.add("F");

        List path3 = new ArrayList();
        path3.add("A");
        path3.add("C");
        path3.add("G");

        List path4 = new ArrayList();
        path4.add("A");
        path4.add("C");
        path4.add("H");

        List path5 = new ArrayList();
        path5.add("A");
        path5.add("C");
        path5.add("I");

        List path6 = new ArrayList();
        path6.add("A");
        path6.add("D");
        path6.add("J");

        expectedPaths.add(path1);
        expectedPaths.add(path2);
        expectedPaths.add(path3);
        expectedPaths.add(path4);
        expectedPaths.add(path5);
        expectedPaths.add(path6);

        List actualPaths = walker.paths(aNode);

        System.out.println("actual paths = "+actualPaths);
        System.out.println("expected paths = "+expectedPaths);

        Assert.assertEquals(expectedPaths, actualPaths);

    }
}
