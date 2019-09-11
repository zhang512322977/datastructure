package org.buptdavid.datastructure.tomcat.v1;

import javax.servlet.ServletOutputStream;
import java.io.IOException;
import java.io.OutputStream;

public class ServletOutputStreamImpl extends ServletOutputStream
{
    OutputStream outputStream;

    public ServletOutputStreamImpl(OutputStream outputStream)
    {
        this.outputStream = outputStream;
    }

    @Override
    public void write(int b)
        throws IOException
    {
        outputStream.write(b);
    }
}
