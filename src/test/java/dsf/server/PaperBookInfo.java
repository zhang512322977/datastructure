package dsf.server;

import java.util.Date;

public class PaperBookInfo {

    private String paperBookId;
    private String bookName;
    private String author;
    private String originalPrice;
    private String sellingPrice;
    private String isbn;
    private Integer status;
    private String bookUrl;
    private Date createTime;
    private Date lastUpdateTime;

    public PaperBookInfo() {
    }

    public String getPaperBookId() {
        return this.paperBookId;
    }

    public void setPaperBookId(String paperBookId) {
        this.paperBookId = paperBookId;
    }

    public String getBookName() {
        return this.bookName;
    }

    public void setBookName(String bookName) {
        this.bookName = bookName;
    }

    public String getAuthor() {
        return this.author;
    }

    public void setAuthor(String author) {
        this.author = author;
    }

    public String getOriginalPrice() {
        return this.originalPrice;
    }

    public void setOriginalPrice(String originalPrice) {
        this.originalPrice = originalPrice;
    }

    public String getSellingPrice() {
        return this.sellingPrice;
    }

    public void setSellingPrice(String sellingPrice) {
        this.sellingPrice = sellingPrice;
    }

    public String getIsbn() {
        return this.isbn;
    }

    public void setIsbn(String isbn) {
        this.isbn = isbn;
    }

    public Integer getStatus() {
        return this.status;
    }

    public void setStatus(Integer status) {
        this.status = status;
    }

    public String getBookUrl() {
        return this.bookUrl;
    }

    public void setBookUrl(String bookUrl) {
        this.bookUrl = bookUrl;
    }

    public Date getCreateTime() {
        return this.createTime;
    }

    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }

    public Date getLastUpdateTime() {
        return this.lastUpdateTime;
    }

    public void setLastUpdateTime(Date lastUpdateTime) {
        this.lastUpdateTime = lastUpdateTime;
    }

    public String toString() {
        return "PaperBookInfo(paperBookId=" + this.getPaperBookId() + ", bookName=" + this.getBookName() + ", author=" + this.getAuthor() + ", originalPrice=" + this.getOriginalPrice() + ", sellingPrice=" + this.getSellingPrice() + ", isbn=" + this.getIsbn() + ", status=" + this.getStatus() + ", bookUrl=" + this.getBookUrl() + ", createTime=" + this.getCreateTime() + ", lastUpdateTime=" + this.getLastUpdateTime() + ")";
    }
}