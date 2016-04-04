package com.databasefullfilment.model;

/**
 * Created by Саша on 21.03.2015.
 */
public class Course extends BasicCourse {
    private int startDay = -1;
    private int startMonth = -1;
    private int startYear = -1;
    private String duration = "";

    public Course(BasicCourse bCourse){
        super();
        this.setId(bCourse.getId());
        this.setName(bCourse.getName());
        this.setDescription(bCourse.getDescription());
        this.setLang(bCourse.getLang());
        this.setLink(bCourse.getLink());
        this.setLinks(bCourse.getLinks());
    }
    public void setStartDay(int startDay) {
        this.startDay = startDay;
    }

    public void setStartMonth(int startMonth) {
        this.startMonth = startMonth;
    }

    public void setStartYear(int startYear) {
        this.startYear = startYear;
    }

    public void setDuration(String duration) {
        this.duration = duration;
    }

    public int getStartDay() {
        return startDay;
    }

    public int getStartMonth() {
        return startMonth;
    }

    public int getStartYear() {
        return startYear;
    }

    public String getBeginDate(){
        if(startDay>0)
            return getStartYear()+"-"+getStartMonth()+"-"+getStartDay();
        else
            return null;
    }
    public String getEndDate(){
        if(duration == null || duration.equals(""))
            return null;
        int i=0;
        String res="";
        while(Character.isDigit(duration.charAt(i))){
            ++i;
        }
        return duration.substring(0,i);
    }

    public String getDuration() {
        return duration;
    }
}
