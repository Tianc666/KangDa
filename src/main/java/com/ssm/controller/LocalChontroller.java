package com.ssm.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.i18n.SessionLocaleResolver;

import javax.servlet.http.HttpServletRequest;
import java.util.Locale;

@Controller
public class LocalChontroller {
    @RequestMapping("/changeLocal")
    public String changeLocal(@RequestParam(value = "request_locale") String request_locale, HttpServletRequest req) {
        if ("zh_CN".equals(request_locale)) {
            Locale zh = new Locale("zh", "CN");
            req.getSession().setAttribute(SessionLocaleResolver.LOCALE_SESSION_ATTRIBUTE_NAME, zh);
        } else {
            Locale en = new Locale("en", "US");
            req.getSession().setAttribute(SessionLocaleResolver.LOCALE_SESSION_ATTRIBUTE_NAME, en);
        }
        return "login2";
    }
}
