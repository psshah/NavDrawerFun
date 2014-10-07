package com.psshah.navdrawerdemo;

public class NewDrawerItem {
    private String mTitle;
    private int mIcon;
    
    public NewDrawerItem(){}

    public NewDrawerItem(String title, int icon){
        this.mTitle = title;
        this.mIcon = icon;
    }

    public String getTitle(){
        return this.mTitle;
    }

    public int getIcon(){
        return this.mIcon;
    }

    public void setTitle(String title){
        this.mTitle = title;
    }

    public void setIcon(int icon){
        this.mIcon = icon;
    }     


}
