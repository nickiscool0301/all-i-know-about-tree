import java.util.ArrayList;
import java.util.List;

public class SpecialTreeNode {
    String name;
    List<SpecialTreeNode> childList;

    SpecialTreeNode(String name) {
        this.name = name;
        this.childList = new ArrayList<>();
    }

}
