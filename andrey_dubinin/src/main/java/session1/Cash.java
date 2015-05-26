package session1;

/**
 * Created by jax on 26.05.15.
 */
public class Cash {
    private String name;
    private double kurs;
    private double kolichestvo;
    private boolean nalichie;

    public Cash(String name, double kurs, double kolichestvo, boolean nalichie){
        this.name=name;
        this.kurs=kurs;
        this.kolichestvo=kolichestvo;
        this.nalichie=nalichie;
    }
    @Override
    public boolean equals(Object obj){
        if(obj==null){
            return false;
        }
        if(obj==this){
            return true;
        }
        if(obj.getClass()!=getClass()){
            return false;
        }
        Cash o = (Cash)obj;
        if(name!=null&&name==o.name && kurs==o.kurs && kolichestvo==o.kolichestvo && nalichie==o.nalichie){
            return true;
        }else{
            return false;
        }
    }
}
