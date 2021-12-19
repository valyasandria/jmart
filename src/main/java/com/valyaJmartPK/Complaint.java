package com.valyaJmartPK;
import com.valyaJmartPK.dbjson.Serializable;

import java.util.Date;
import java.text.SimpleDateFormat;

/**
 * Class Complaint to represents complaint products from buyer
 *
 * @author Valya Sandria Akiela
 * @version 1.0
 */
public class Complaint extends Serializable
{
    public Date date ;
    public String desc;

    Complaint(String desc)
    {
        this.desc = desc;
        this.date = new Date();
    }

    public boolean validate()
    {
        return false;
    }

    public String toString(){
        SimpleDateFormat SDformat = new SimpleDateFormat("dd/MM/yyyy");
        String formatDate = SDformat.format(this.date);
        return "{date = " + formatDate + "desc = '" + this.desc + "'}";
    }

}
