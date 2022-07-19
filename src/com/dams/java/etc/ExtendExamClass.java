package com.dams.java.etc;

public class ExtendExamClass {
    
    private String seo = "";
    private String dong = "";
    private String chan = "";

    public String getSeo() {
        return seo;
    }

    public void setSeo(String seo) {
        this.seo = seo;
    }

    public String getDong() {
        return dong;
    }

    public void setDong(String dong) {
        this.dong = dong;
    }

    public String getChan() {
        return chan;
    }

    public void setChan(String chan) {
        this.chan = chan;
    }
    public void doIt(){
        System.out.println("this.getSeo() = " + this.getSeo());
    }

}
