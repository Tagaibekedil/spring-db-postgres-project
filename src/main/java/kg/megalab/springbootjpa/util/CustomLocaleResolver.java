package kg.megalab.springbootjpa.util;

import jakarta.servlet.http.HttpServletRequest;
import org.springframework.util.StringUtils;
import org.springframework.web.servlet.i18n.AcceptHeaderLocaleResolver;

import java.util.Arrays;
import java.util.List;
import java.util.Locale;

public class CustomLocaleResolver extends AcceptHeaderLocaleResolver {
    List<Locale>LOCALES= Arrays.asList(new Locale("ru"),new Locale("en"),new Locale("ky"));
    @Override
    public Locale resolveLocale(HttpServletRequest request){
        if (StringUtils.isEmpty(request.getHeader("Language"))){
            return Locale.getDefault();
        }
        List<Locale.LanguageRange>list=Locale.LanguageRange.parse(request.getHeader("Language"));
        return Locale.lookup(list,LOCALES);
    }
}
