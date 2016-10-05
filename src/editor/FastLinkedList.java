package editor;


import javafx.scene.text.Text;

/**
 * Created by Yao on 2016/10/1.
 */
public class FastLinkedList {
    private FastLinkedListNode sentinel;
    private int currentIndex;
    private int curX;
    private int curY;
    private FastLinkedListNode currentNode;
    private int size;
    private int fontSize = 12;
    private String fontName = "Verdana";

    public FastLinkedList() {
        sentinel = new FastLinkedListNode();
        currentIndex = 0;
        curX = 0;
        curY = 0;
        currentNode = sentinel;
        size = 0;
    }
    //get methods
    public FastLinkedListNode getSentinel(){return sentinel;}
    public FastLinkedListNode getCurrentNode() {return currentNode;}
    public int getCurrentIndex() {return currentIndex;}
    public int getCurX() {
        return curX;
    }
    public int getCurY() {
        return curY;
    }
    // update current x,y
    public void updateCurXY(int curX, int curY) {
        this.curX = curX;
        this.curY = curY;
    }
    public void updateCurrentNode(FastLinkedListNode node) {
        currentNode = node;
        updateCurXY(node.getXPos(), node.getYPos());
    }
    public int getSize(){return  size;}
    //add a node
    public void add(FastLinkedListNode node) {
        if (currentIndex == size) {
            currentNode.setNext(node);
            node.setPrev(currentNode);
            node.setNext(null);
            currentNode = node;
        } else {
            node.setNext(currentNode.getNext());
            currentNode.getNext().setPrev(node);
            currentNode.setNext(node);
            node.setPrev(currentNode);
            currentNode = node;
        }
        size++;
        currentIndex++;
        int charWidth = (int) Math.round(node.getItem().getLayoutBounds().getWidth());
        int charHeight = (int) Math.round(node.getItem().getLayoutBounds().getHeight());

        ///////how to update cur x, y? need to be improved
        updateCurXY(curX + charWidth, curY);
    }
    //remove the current node
    public FastLinkedListNode remove() {
        if (getSize() == 0) {return null;}
        FastLinkedListNode ret = currentNode;
        int charWidth = (int) Math.round(currentNode.getItem().getLayoutBounds().getWidth());
        int charHeight = (int) Math.round(currentNode.getItem().getLayoutBounds().getHeight());
        System.out.println(charHeight);
        if (currentIndex == size) {
            currentNode = currentNode.getPrev();
            currentNode.setNext(null);
        } else {
            currentNode.getNext().setPrev(currentNode.getPrev());
            currentNode.getPrev().setNext(currentNode.getNext());
            currentNode = currentNode.getPrev();
        }
        size--;
        currentIndex--;
        ///////how to update cur x, y?? need to be improved
        updateCurXY(curX - charWidth, curY);
        return ret;
    }
    public FastLinkedListNode findNodewithXYForUpAndLeft(int x, int y) {
        if (y > currentNode.getYPos()) {
            return null;
        }
        FastLinkedListNode ptr = getCurrentNode();
        FastLinkedListNode rst = getCurrentNode();
        while (ptr != getSentinel()) {
            if (ptr.getYPos() > y) {
                ptr = ptr.getPrev();
                rst = ptr;
                continue;
            } else {
                if (x <= ptr.getXPos()) {
                    rst = ptr;
                    ptr = ptr.getPrev();
                } else {
                    return rst;
                }
            }
        }
        updateCurrentNode(rst);
        return rst;
    }
    public FastLinkedListNode findNodewithXYForDownAndRight(int x, int y) {
        if (y < currentNode.getYPos()) {
            return null;
        }
        FastLinkedListNode ptr = getCurrentNode();
        FastLinkedListNode rst = getCurrentNode();
        while (ptr != null && ptr.getNext() != null) {
            if (ptr.getYPos() < y) {
                ptr = ptr.getNext();
                rst = ptr;
                continue;
            } else {
                if (x >= ptr.getXPos()) {
                    rst = ptr;
                    ptr = ptr.getNext();
                } else {
                    return rst;
                }
            }
        }
        updateCurrentNode(rst);
        return rst;
    }
    public static void main(String[] args) {
        FastLinkedList f = new FastLinkedList();
        f.add(new FastLinkedListNode(new Text("a")));
        System.out.println(f.getCurrentNode().getItem().getText() + " " + f.getCurX() + " " + f.getCurY() + " " + f.getCurrentIndex());
        System.out.println(f.size);
        f.add(new FastLinkedListNode(new Text("b")));
        System.out.println(f.getCurrentNode().getItem().getText() + " " + f.getCurX() + " " + f.getCurY() + " " + f.getCurrentIndex());
        System.out.println(f.size);
        f.add(new FastLinkedListNode(new Text("c")));
        System.out.println(f.getCurrentNode().getItem().getText() + " " + f.getCurX() + " " + f.getCurY() + " " + f.getCurrentIndex());
        System.out.println(f.size);
        f.add(new FastLinkedListNode(new Text("d")));
        System.out.println(f.getCurrentNode().getItem().getText() + " " + f.getCurX() + " " + f.getCurY() + " " + f.getCurrentIndex());
        System.out.println(f.size);
        f.remove();
        System.out.println(f.getCurrentNode().getItem().getText() + " " + f.getCurX() + " " + f.getCurY() + " " + f.getCurrentIndex());
        System.out.println(f.size);
    }
}
