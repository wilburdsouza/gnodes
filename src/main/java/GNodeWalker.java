import java.util.ArrayList;
import java.util.List;

/**
 * Created by wilbur on 10/1/16.
 */
public class GNodeWalker {

    public List<GNode> walkGraph(GNode gnode) {

        List<GNode> gNodes = new ArrayList<GNode>();
        int length = gnode.getChildren().length;

        gNodes.add(gnode);

        for (int count = 0; count < length; count++) {
            gNodes.addAll(walkGraph(gnode.getChildren()[count]));
        }

        return gNodes;
    }

    public List paths(GNode node) {

        List retList = new ArrayList();

        int length = node.getChildren().length;

        if(length == 0) {
            retList.add(node.getName());
        } else {

            for (int count = 0; count < length; count++) {
                List tempList = new ArrayList();
                List returnedList = paths(node.getChildren()[count]);

                if(returnedList.size() == 1 && returnedList.get(0) instanceof String) {
                    tempList.add(node.getName());
                    tempList.add((String) returnedList.get(0));
                    retList.add(tempList);
                } else {
                    for(Object object : returnedList) {
                        tempList = new ArrayList();
                        tempList.add(node.getName());
                        tempList.addAll((List)object);
                        retList.add(tempList);
                    }
                }
            }
        }


        return retList;
    }
}
