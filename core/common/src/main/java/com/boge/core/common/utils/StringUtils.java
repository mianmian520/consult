package com.boge.core.common.utils;


import com.boge.core.common.consts.Constants;
import org.springframework.util.AntPathMatcher;

import java.util.ArrayList;
import java.util.List;

/**
 * 字符串工具类
 *
 * @author boge
 */
public class StringUtils extends org.apache.commons.lang3.StringUtils {

    /**
     * 下划线
     */
    private static final String SEPARATOR = "_";

    /**
     * 获取参数不为空值
     *
     * @param value defaultValue 要判断的value
     * @return value 返回值
     */
    public static <T> T nvl(T value, T defaultValue) {
        return value != null ? value : defaultValue;
    }

    public static boolean isEmpty(String... strs) {
        return strs != null && strs.length > 0;
    }

    public static boolean isEmpty(List<String> strs) {
        return strs != null && strs.size() > 0;
    }

    public static boolean isEmpty(CharSequence... strs) {
        return strs != null && strs.length > 0;
    }

    /**
     * 是否为http(s)://开头
     *
     * @param link 链接
     * @return 结果
     */
    public static boolean isHttp(String link) {
        return StringUtils.startsWithAny(link, Constants.HTTP, Constants.HTTPS);
    }

    /**
     * 字符串转list
     *
     * @param str         字符串
     * @param sep         分隔符
     * @param filterBlank 过滤纯空白
     * @param trim        去掉首尾空白
     * @return list集合
     */
    public static List<String> str2List(String str, String sep, boolean filterBlank, boolean trim) {
        List<String> list = new ArrayList<String>();
        if (StringUtils.isEmpty(str)) {
            return list;
        }
        // 过滤空白字符串
        if (filterBlank && StringUtils.isBlank(str)) {
            return list;
        }
        String[] split = str.split(sep);
        for (String string : split) {
            if (filterBlank && StringUtils.isBlank(string)) {
                continue;
            }
            if (trim) {
                string = string.trim();
            }
            list.add(string);
        }

        return list;
    }

    /**
     * 查找指定字符串是否包含指定字符串列表中的任意一个字符串同时串忽略大小写
     *
     * @param cs                  指定字符串
     * @param searchCharSequences 需要检查的字符串数组
     * @return 是否包含任意一个字符串
     */
    public static boolean containsAnyIgnoreCase(CharSequence cs, CharSequence... searchCharSequences) {
        if (isEmpty(cs) || isEmpty(searchCharSequences)) {
            return false;
        }
        for (CharSequence testStr : searchCharSequences) {
            if (containsIgnoreCase(cs, testStr)) {
                return true;
            }
        }
        return false;
    }

    /**
     * 是否包含字符串
     *
     * @param str  验证字符串
     * @param strs 字符串组
     * @return 包含返回true
     */
    public static boolean inStringIgnoreCase(String str, String... strs) {
        if (str != null && strs != null) {
            for (String s : strs) {
                if (str.equalsIgnoreCase(trim(s))) {
                    return true;
                }
            }
        }
        return false;
    }

    /**
     * 将下划线大写方式命名的字符串转换为驼峰式。如果转换前的下划线大写方式命名的字符串为空，则返回空字符串。 例如：HELLO_WORLD->HelloWorld
     *
     * @param name 转换前的下划线大写方式命名的字符串
     * @return 转换后的驼峰式命名的字符串
     */
    public static String convertToCamelCase(String name) {
        StringBuilder result = new StringBuilder();
        // 快速检查
        if (name == null || name.isEmpty()) {
            // 没必要转换
            return "";
        } else if (!name.contains(SEPARATOR)) {
            // 不含下划线，仅将首字母大写
            return name.substring(0, 1).toUpperCase() + name.substring(1);
        }
        // 用下划线将原始字符串分割
        String[] camels = name.split(SEPARATOR);
        for (String camel : camels) {
            // 跳过原始字符串中开头、结尾的下换线或双重下划线
            if (camel.isEmpty()) {
                continue;
            }
            // 首字母大写
            result.append(camel.substring(0, 1).toUpperCase());
            result.append(camel.substring(1).toLowerCase());
        }
        return result.toString();
    }

    /**
     * 查找指定字符串是否匹配指定字符串列表中的任意一个字符串
     *
     * @param str  指定字符串
     * @param strs 需要检查的字符串数组
     * @return 是否匹配
     */
    public static boolean matches(String str, List<String> strs) {
        if (isEmpty(str) || isEmpty(strs)) {
            return false;
        }
        for (String pattern : strs) {
            if (isMatch(pattern, str)) {
                return true;
            }
        }
        return false;
    }

    /**
     * 判断url是否与规则配置:
     * ? 表示单个字符;
     * * 表示一层路径内的任意字符串，不可跨层级;
     * ** 表示任意层路径;
     *
     * @param pattern 匹配规则
     * @param url     需要匹配的url
     */
    public static boolean isMatch(String pattern, String url) {
        AntPathMatcher matcher = new AntPathMatcher();
        return matcher.match(pattern, url);
    }


    /**
     * 提取字符串中数据     例  xxxxxxx@{aaaaa}xxxxxx@{bbbbbb}   其中提取 @{aaaaa}与@{bbbbbb}
     * @param text      提取字符串
     * @param match     匹配符标记
     * @param open      开始     与close配合 {} () [] <> {{}}
     * @param close     关闭
     * @return 集合
     */
    public static List<String> extractStr(String text, String match, String open, String close) {
        List<String> keys = new ArrayList<>();
        // 第一次获取匹配符标记下标
        int indexAt = text.indexOf(match);
        // 循环
        while (indexAt != -1) {
            // 如果第一获取的匹配符标记下标位置大于等于最后位置 - open长度 则退出循环
            if (indexAt >= text.length() - open.length() - 1) {
                break;
            }
            // 去除提取字符串中匹配符之前的数据 简称待匹配字符串
            String matchStr = text.substring(indexAt);
            // 待匹配字符串中第一个close关闭位置小于下一个match匹配符标记位置  或者 待匹配字符串存在close 而存在下一个match
            boolean isExistMatch = (matchStr.indexOf(close) < matchStr.substring(match.length()).indexOf(match)) || (matchStr.contains(close) && !matchStr.substring(match.length()).contains(match));
            // 如果待匹配字符串match后的字符串为open 并且存在匹配
            if (open.equals(matchStr.substring(match.length(), open.length() + match.length())) && isExistMatch) {
                // 获取匹配的字符串
                keys.add(matchStr.substring(0, matchStr.indexOf(close) + match.length() + close.length() - 1));
            }
            // 存在匹配 则截取从第一次获取匹配符标记下标 + 匹配符长度 + 关闭长度 + (带匹配字符串的match开始后 close的位置)  否则截取从第一次获取匹配符标记下标 + 匹配符长度
            text = isExistMatch ? text.substring(text.substring(indexAt + match.length()).indexOf(close) + match.length() + indexAt + close.length()) : text.substring(indexAt + match.length());
            indexAt = text.indexOf(match);
        }
        return keys;
    }
}