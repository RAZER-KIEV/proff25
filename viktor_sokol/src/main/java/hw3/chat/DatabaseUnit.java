
package hw3.chat;

import java.io.EOFException;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.FilenameFilter;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;
import java.util.HashSet;
import java.util.List;
import java.util.LinkedList;

// класс отвечает за хранение инфы типа: логин, IP, история переписки в одном обьекте
public class DatabaseUnit implements Serializable{
    private static final long serialVersionUID = 1L;
    public String login=null;
    public String IP=null;
    public List<String> SmsList= new LinkedList<String>();
    static String path=getPath();

    public static final String getPath(){
        switch (OsUtils.getOsName()){
            case"Windows": path=System.getProperty("user.dir")+"\\"; return path;
            case"Linux": path=System.getProperty("user.dir")+"/"; return path;
            default: path=System.getProperty("user.dir")+"\\"; System.out.println(path); return path;
        }
    }

    public DatabaseUnit(String login, String IP){
        this.login=login;
        this.IP=IP;
    }

    public boolean equals(Object ob){
        DatabaseUnit unit = (DatabaseUnit) ob;
        if (this.login.equals(unit.login))
            if(this.IP.equals(unit.IP))
                return true;
        return false;
    }

    public int hashCode(){
        int sum1=0;
        int sum2=0;
        int loginLength = login.getBytes().length;
        int IPLength = IP.getBytes().length;
        for(int i=0; i<loginLength; i++)
            sum1+=login.getBytes()[i];
        for(int i=0; i<IPLength; i++)
            sum2+=IP.getBytes()[i];
        return sum1+10*sum2;
    }

    //для сериализации обьекта, рабочая папка по умолчанию
    public void saveUnit(){
        try{
            FileOutputStream fout = new FileOutputStream(path+login+".unit");
            ObjectOutputStream ob = new ObjectOutputStream(fout);
            ob.writeObject(this);
            ob.flush();
            ob.close();
        } catch(IOException ex){
            System.out.println(ex);
        }
    }

    //для физического удаления файла абонента с папки
    public void deleteUnit(){
        File file = new File(path+login+".unit");
        file.delete();
    }

    //для десериализации всех обьектов из рабочей папки по умолчанию с окончанием .unit
    public static HashSet<DatabaseUnit> loadUnits(){
        HashSet<DatabaseUnit> set = new HashSet<DatabaseUnit>();
        File dir = new File(path);
        File[] fileList = dir.listFiles(new FilenameFilter() {

            @Override
            public boolean accept(File dir, String name) {
                return name.endsWith(".unit");
            }
        });
        FileInputStream fin=null;
        ObjectInputStream ob=null;
        try{
            for(File file : fileList){
                fin = new FileInputStream(file);
                ob = new ObjectInputStream(fin);
                try{
                    while(true){
                        DatabaseUnit unit = (DatabaseUnit) ob.readObject();
                        set.add(unit);
                    }
                }catch (EOFException eof){
                    ob.close();
                }
            }
        } catch(IOException ex){
            System.out.println(ex);
        } catch(ClassNotFoundException c){
            System.out.println(c);
        }
        return set;
    }
}
