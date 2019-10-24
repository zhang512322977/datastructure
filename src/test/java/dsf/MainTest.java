package dsf;

import java.lang.reflect.InvocationTargetException;
import java.util.Date;

public class MainTest
{
    public static void main(String[] args)
        throws InvocationTargetException, IllegalAccessException
    {
        GetPaperBookInfoResponse getPaperBookInfoResponse = new GetPaperBookInfoResponse();

        dsf.server.GetPaperBookInfoResponse response = new dsf.server.GetPaperBookInfoResponse();

        dsf.server.PaperBookRelation paperBookRelation = new dsf.server.PaperBookRelation();
        paperBookRelation.setBookId("111111");
        paperBookRelation.setCreateTime(new Date());
        //response.setPaperBookRelation(paperBookRelation);

        //BeanUtils.copyProperties(getPaperBookInfoResponse,paperBookRelation);

        System.out.println(getPaperBookInfoResponse);

    }

}
