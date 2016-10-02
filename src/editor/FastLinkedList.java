package editor;

import org.w3c.dom.*;
import javax.xml.soap.SOAPElement;
import javax.xml.soap.SOAPException;
import javax.xml.soap.Text;

/**
 * Created by Yao on 2016/10/1.
 */
public class FastLinkedList {
    private class FastLinkedListNode {
        private Text item;
        private FastLinkedListNode prev;
        private FastLinkedListNode next;

        public FastLinkedListNode(Text text, FastLinkedListNode p, FastLinkedListNode n) {
            item = text;
            prev = p;
            next = n;
        }
        public Text getItem() {
            return item;
        }
        public FastLinkedListNode getPrev() {
            return prev;
        }
        public FastLinkedListNode getNext() {
            return next;
        }
    }
    private FastLinkedListNode sentinel;
    private int currentIndex;
    private int curX;
    private int curY;
    private FastLinkedListNode currentNode;
    private int fontSize = 12;
    private String fontName = "Verdana";

    public FastLinkedList() {

    }
    public void add(FastLinkedListNode f) {
        return;
    }
    public void remove() {
        return;
    }
    public int getCurX() {
        return curX;
    }
    public int getCurY() {
        return curY;
    }
}
