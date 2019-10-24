package dsf.server;

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
public class PaperBookRelation {
    private String bookId;

    private String paperBookId;

    private PaperBookInfo paperBookInfo;

    private Date createTime;

    private Date lastUpdateTime;

    public PaperBookRelation() {
    }

    public String getBookId() {
        return this.bookId;
    }

    public void setBookId(String bookId) {
        this.bookId = bookId;
    }

    public String getPaperBookId() {
        return this.paperBookId;
    }

    public void setPaperBookId(String paperBookId) {
        this.paperBookId = paperBookId;
    }

    public PaperBookInfo getPaperBookInfo() {
        return this.paperBookInfo;
    }

    public void setPaperBookInfo(PaperBookInfo paperBookInfo) {
        this.paperBookInfo = paperBookInfo;
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
        return "PaperBookRelation(bookId=" + this.getBookId() + ", paperBookId=" + this.getPaperBookId() + ", paperBookInfo=" + this.getPaperBookInfo() + ", createTime=" + this.getCreateTime() + ", lastUpdateTime=" + this.getLastUpdateTime() + ")";
    }
}
