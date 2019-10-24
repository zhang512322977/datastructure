package dsf;

public class GetPaperBookInfoResponse
{

    /**
     * 序列化UID
     */
    private static final long serialVersionUID = 1L;

    /**
     * 纸质图书关系
     */
    private PaperBookRelation paperBookRelation;


    public PaperBookRelation getPaperBookRelation()
    {
        return paperBookRelation;
    }


    public void setPaperBookRelation(PaperBookRelation paperBookRelation)
    {
        this.paperBookRelation = paperBookRelation;
    }


    @Override
    public String toString()
    {
        StringBuilder builder = new StringBuilder();
        builder.append("GetPaperBookInfoResponse [paperBookRelation=");
        builder.append(paperBookRelation);
        builder.append("]");
        return builder.toString();
    }
}
