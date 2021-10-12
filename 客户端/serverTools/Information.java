package serverTools;

import java.io.Serializable;

public class Information implements Serializable {
    private String inforType;
    private String srcName;
    private String dstName;
    private String info;


    public Information(String inforType,String srcName,String dstName,String info){
        this.inforType = inforType;
        this.srcName = srcName;
        this.dstName = dstName;
        this.info = info;
    }

    public String getSrc(){
        return srcName;
    }

    public String getDst(){
        return dstName;
    }

    public String getType(){
        return inforType;
    }

    public String getInfo(){
        return info;
    }

    public void setSrc(String src) {
        this.srcName = src;
    }

    public void setDst(String dst) {
        this.dstName = dst;
    }

    public void setType(String flag) {
        this.inforType = flag;
    }

    public void setInfo(String info){
        this.info = info;
    }
}

