package study.springboot.config;

import org.springframework.util.StringUtils;
import org.springframework.web.servlet.LocaleResolver;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.Locale;

/**
 * @author dhl
 * @datetime 2021/8/2  17:00
 */
public class MyLocaleResolver implements LocaleResolver {
    @Override
    public Locale resolveLocale(HttpServletRequest request) {
        // 获取请求中的语言参数
        String language = request.getParameter("l");
        // 将其设置为默认配置
        Locale locale = Locale.getDefault();
        // 如果语言不为空，则解析传入的语言，达到修改语言的条件
        if (!StringUtils.isEmpty(language)) {
            // zh_CN语言，对语言的参数进行分割
            String[] split = language.split("_");
            // 解析国家和地区然后将其赋值并返回
            locale = new Locale(split[0], split[1]);
        }
        return locale;
    }

    @Override
    public void setLocale(HttpServletRequest request, HttpServletResponse response, Locale locale) {

    }
}