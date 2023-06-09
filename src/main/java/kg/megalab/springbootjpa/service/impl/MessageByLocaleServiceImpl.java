package kg.megalab.springbootjpa.service.impl;

import kg.megalab.springbootjpa.service.serv.MessageByLocaleService;
import lombok.RequiredArgsConstructor;
import org.springframework.context.MessageSource;
import org.springframework.context.i18n.LocaleContextHolder;
import org.springframework.stereotype.Component;
import java.util.Locale;

@Component
@RequiredArgsConstructor
public class MessageByLocaleServiceImpl implements MessageByLocaleService {

    private final MessageSource messageSource;

    @Override
    public String getMessage(String id, int a) {
        Locale locale = LocaleContextHolder.getLocale();
        return messageSource.getMessage(id, new Object[]{a}, locale);
    }

    @Override
    public String getMessage(String id) {
        Locale locale = LocaleContextHolder.getLocale();
        return messageSource.getMessage(id, null, locale);

    }
}