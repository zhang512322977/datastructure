package dsf;

import java.io.Serializable;
import java.util.Date;

/**
 *
 * 纸质图书关系实体类
 *
 * @author     wangzejun
 * @version CMR191009 2019年9月19日
 * @since SDP V300R003C10
 */
public class PaperBookRelation implements Serializable
{
    /**
     * 序列化
     */
    private static final long serialVersionUID = 1L;

    /**
     * 图书ID
     */
    private String bookId;

    /**
     * 书籍ID
     */
    private String paperBookId;

    /**
     * 创建时间
     */
    private Date createTime;

    /**
     * 最后更新时间
     */
    private Date lastUpdateTime;

    /**
     * 书籍信息
     */
    private PaperBookInfo paperBookInfo;

    public String getBookId()
    {
        return bookId;
    }

    public String getPaperBookId()
    {
        return paperBookId;
    }

    public Date getCreateTime()
    {
        return createTime;
    }

    public Date getLastUpdateTime()
    {
        return lastUpdateTime;
    }

    public PaperBookInfo getPaperBookInfo()
    {
        return paperBookInfo;
    }

    public void setBookId(String bookId)
    {
        this.bookId = bookId;
    }

    public void setPaperBookId(String paperBookId)
    {
        this.paperBookId = paperBookId;
    }

    public void setCreateTime(Date createTime)
    {
        this.createTime = createTime;
    }

    public void setLastUpdateTime(Date lastUpdateTime)
    {
        this.lastUpdateTime = lastUpdateTime;
    }

    public void setPaperBookInfo(PaperBookInfo paperBookInfo)
    {
        this.paperBookInfo = paperBookInfo;
    }

    @Override
    public String toString()
    {
        StringBuilder builder = new StringBuilder();
        builder.append("PaperBookRelation [bookId=");
        builder.append(bookId);
        builder.append(", paperBookId=");
        builder.append(paperBookId);
        builder.append(", createTime=");
        builder.append(createTime);
        builder.append(", lastUpdateTime=");
        builder.append(lastUpdateTime);
        builder.append(", paperBookInfo=");
        builder.append(paperBookInfo);
        builder.append("]");
        return builder.toString();
    }

}
