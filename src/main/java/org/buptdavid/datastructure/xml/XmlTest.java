package org.buptdavid.datastructure.xml;

import com.thoughtworks.xstream.XStream;

public class XmlTest
{
    public static void main(String[] args)
    {
        Node node = new Node();
        node.setNodeId("11111");
        Node child = new Node();
        child.setChild(node);
        node.setChild(child);
        child.setNodeId("11111");

        XStream xs = new XStream();
        xs.alias("node",Node.class);
        String xml = xs.toXML(node);
        System.out.println(xml);

        String xlm = "<node>\n" +
            "  <nodeId>11111</nodeId>\n" +
            "  <child>\n" +
            "    <nodeId>11111</nodeId>\n" +
            "    <child reference=\"../..\"/>\n" +
            "  </child>\n" +
            "</node>";

        Node o =(Node)xs.fromXML(xlm);
        System.out.println(o);

    }

}
