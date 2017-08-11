package util;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.UnknownFormatConversionException;

/**
 * Created by vdabcursist on 08/08/2017.
 */
public class DateBuilder  {
    public static Date createDate (String date){
        try {
            return new SimpleDateFormat("yyyy-MM-dd").parse(date);  //Hoofdletter MM is months, kleine letter m is minuten
        } catch (ParseException e) {
            throw new UnknownFormatConversionException("Wrong data");
        }
    }
}
