package tienich;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;

public class docGhiFile {
	public static Object readObject(String duongdan) throws FileNotFoundException, IOException, ClassNotFoundException
    {
        try(
                FileInputStream fis = new FileInputStream(duongdan);
                ObjectInputStream ois = new ObjectInputStream(fis);
            )
        {
            return ois.readObject();
        }
    }
    public static void writeObject(String duongdan ,Object duLieu) throws FileNotFoundException, IOException
    {
        try(
                FileOutputStream fos = new FileOutputStream(duongdan);
                ObjectOutputStream oos = new ObjectOutputStream(fos);
            )
        {
            oos.writeObject(duLieu);
        }
    }
}
