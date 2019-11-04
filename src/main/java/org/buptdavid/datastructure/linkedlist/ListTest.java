package org.buptdavid.datastructure.linkedlist;


import org.buptdavid.datastructure.Node;

import javax.sound.midi.SoundbankResource;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Vector;

public class ListTest {


    public static void main(String[] args) {

        Vector vector = new Vector();

        Node<String> node = new Node<>("data");
        Node n = node;
        vector.add(n);
        vector.add(node);

        n.data = "11";
        System.out.println(vector);

        System.out.println(node);



    }


}
