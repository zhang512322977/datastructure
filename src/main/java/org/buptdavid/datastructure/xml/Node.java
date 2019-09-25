package org.buptdavid.datastructure.xml;

public class Node
{
    String nodeId;
    Node child;

    public Node getChild()
    {
        return child;
    }

    public void setChild(Node child)
    {
        this.child = child;
    }

    public String getNodeId()
    {
        return nodeId;
    }

    public void setNodeId(String nodeId)
    {
        this.nodeId = nodeId;
    }

    @Override
    public String toString()
    {
        final StringBuffer sb = new StringBuffer("Node{");
        sb.append("nodeId='").append(nodeId).append('\'');
        sb.append(", child=").append(child.nodeId);
        sb.append('}');
        return sb.toString();
    }
}
