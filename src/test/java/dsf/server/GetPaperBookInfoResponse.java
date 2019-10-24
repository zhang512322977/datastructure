package dsf.server;


public class GetPaperBookInfoResponse {
    private PaperBookRelation paperBookRelation;

    public GetPaperBookInfoResponse() {
    }

    public PaperBookRelation getPaperBookRelation() {
        return this.paperBookRelation;
    }

    public void setPaperBookRelation(PaperBookRelation paperBookRelation) {
        this.paperBookRelation = paperBookRelation;
    }

    public String toString() {
        return "GetPaperBookInfoResponse(super=" + super.toString() + ", paperBookRelation=" + this.getPaperBookRelation() + ")";
    }

}
