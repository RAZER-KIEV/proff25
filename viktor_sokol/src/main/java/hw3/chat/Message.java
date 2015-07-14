package hw3.chat;

import java.io.*;
import java.util.Date;

public class Message implements Serializable {
    private static final long serialVersionUID = 1L;

    public Date date = new Date();
    public String from;
    public String to;
    public String text;

    @Override
    public String toString() {
        return new StringBuilder()
                .append("[")
                .append(date.toString())
                .append(", From: ")
                .append(from)
                .append(", To: ")
                .append(to)
                .append("] ")
                .append(text)
                .toString();
    }


    public void writeToStream(OutputStream out)
            throws IOException
    {
        ByteArrayOutputStream bs = new ByteArrayOutputStream();
        ObjectOutputStream os = new ObjectOutputStream(bs);
        try {
            os.writeObject(this);
        } finally {
            os.flush();
            os.close();
        }

        byte[] packet = bs.toByteArray();

        DataOutputStream ds = new DataOutputStream(out);
        ds.writeInt(packet.length);
        ds.write(packet);
        ds.flush();
    }

    public static Message readFromStream(InputStream in)
            throws IOException, ClassNotFoundException
    {
        if (in.available() <= 0)
            return null;

        DataInputStream ds = new DataInputStream(in);
        int len = ds.readInt();
        byte[] packet = new byte[len];
        ds.read(packet);

        ByteArrayInputStream bs = new ByteArrayInputStream(packet);
        ObjectInputStream os = new ObjectInputStream(bs);
        try {
            Message msg = (Message) os.readObject();
            return msg;
        } finally {
            os.close();
        }
    }
}
