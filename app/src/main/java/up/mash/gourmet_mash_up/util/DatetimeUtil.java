package up.mash.gourmet_mash_up.util;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Locale;

public class DatetimeUtil {

    static public Date String2DateTime(String strDate) throws ParseException {
        SimpleDateFormat dt = new SimpleDateFormat("yyyyy-mm-dd'T'hh:mm:ss", Locale.KOREAN);
        return dt.parse(strDate);
    }

    static public String DateTime2String(Date date) {
        return new SimpleDateFormat("yyyyy-mm-dd'T'hh:mm:ss", Locale.KOREAN).format(date);
    }
}
