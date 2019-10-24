package dsf;

import java.io.Serializable;
import java.util.Date;

/**
 *
 * 书籍信息
 *
 * @author     wangzejun
 * @version CMR191009 2019年9月19日
 * @since SDP V300R003C10
 */
public class PaperBookInfo implements Serializable
{
    /**
     * 序列化
     */
    private static final long serialVersionUID = 1L;

    /**
     * 书籍ID
     */
    private String paperBookId;

    /**
     * 书籍名称
     */
    private String bookName;

    /**
     * 作者
     */
    private String author;

    /**
     * 原价
     */
    private String originalPrice;

    /**
     * 销售价格
     */
    private String sellingPrice;

    /**
     * 书籍地址
     */
    private String bookUrl;

    /**
     * 书籍状态
     */
    private Integer status;

    /**
     * 创建时间
     */
    private Date createTime;

    /**
     * 最后更新时间
     */
    private Date lastUpdateTime;

    private String isbn;

    public String getPaperBookId()
    {
        return paperBookId;
    }

    public String getBookName()
    {
        return bookName;
    }

    public String getAuthor()
    {
        return author;
    }

    public String getOriginalPrice()
    {
        return originalPrice;
    }

    public String getSellingPrice()
    {
        return sellingPrice;
    }

    public String getBookUrl()
    {
        return bookUrl;
    }

    public Integer getStatus()
    {
        return status;
    }

    public Date getCreateTime()
    {
        return createTime;
    }

    public Date getLastUpdateTime()
    {
        return lastUpdateTime;
    }

    public String getIsbn()
    {
        return isbn;
    }

    public void setPaperBookId(String paperBookId)
    {
        this.paperBookId = paperBookId;
    }

    public void setBookName(String bookName)
    {
        this.bookName = bookName;
    }

    public void setAuthor(String author)
    {
        this.author = author;
    }

    public void setOriginalPrice(String originalPrice)
    {
        this.originalPrice = originalPrice;
    }

    public void setSellingPrice(String sellingPrice)
    {
        this.sellingPrice = sellingPrice;
    }

    public void setBookUrl(String bookUrl)
    {
        this.bookUrl = bookUrl;
    }

    public void setStatus(Integer status)
    {
        this.status = status;
    }

    public void setCreateTime(Date createTime)
    {
        this.createTime = createTime;
    }

    public void setLastUpdateTime(Date lastUpdateTime)
    {
        this.lastUpdateTime = lastUpdateTime;
    }

    public void setIsbn(String isbn)
    {
        this.isbn = isbn;
    }

    @Override
    public String toString()
    {
        StringBuilder builder = new StringBuilder();
        builder.append("PaperBookInfo [paperBookId=");
        builder.append(paperBookId);
        builder.append(", bookName=");
        builder.append(bookName);
        builder.append(", author=");
        builder.append(author);
        builder.append(", originalPrice=");
        builder.append(originalPrice);
        builder.append(", sellingPrice=");
        builder.append(sellingPrice);
        builder.append(", bookUrl=");
        builder.append(bookUrl);
        builder.append(", status=");
        builder.append(status);
        builder.append(", createTime=");
        builder.append(createTime);
        builder.append(", lastUpdateTime=");
        builder.append(lastUpdateTime);
        builder.append(", isbn=");
        builder.append(isbn);
        builder.append("]");
        return builder.toString();
    }

}
