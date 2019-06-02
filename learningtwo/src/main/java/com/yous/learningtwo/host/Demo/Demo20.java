package com.yous.learningtwo.host.Demo;

import org.apache.commons.lang3.StringUtils;

import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import java.util.stream.Collectors;

/**
 * @author syou
 * @date 2019/2/14.
 */
public class Demo20 {

    private static Pattern patternReplyNickname = Pattern.compile("([\\u4e00-\\u9fa5a-zA-Z0-9]+)");

    public static void main(String[] args) {
        Timestamp timestamp=Timestamp.valueOf("0001-01-01 00:00:00");
        System.out.println(timestamp);


        String ss = "@ 茱蒂花 亲，建议提前2天哦";


        List<String> nick = getAtNicknameListByContent(ss);

        System.out.println(11);

    }

    private static boolean isMatchReplyAtNickname(String talkerNickname, List<String> replyAtNicknames) {
        if (StringUtils.isNotBlank(talkerNickname) && replyAtNicknames != null && !replyAtNicknames.isEmpty()) {
            Matcher matcher = patternReplyNickname.matcher(talkerNickname);
            if (matcher.find() && StringUtils.isNotBlank(matcher.group())) {
                return replyAtNicknames.stream().anyMatch(t -> StringUtils.isNotBlank(t) && t.contains(matcher.group()));
            }
        }
        return false;
    }


    public static List<String> getAtNicknameListByContent(String content) {
        if (StringUtils.isNotBlank(content)) {
            List<String> result = new ArrayList<>();
            String replacedContent =content;
            while (StringUtils.isNotBlank(replacedContent)) {
                String nickName = getFirstAtNicknameByContent(replacedContent);
                if (StringUtils.isBlank(nickName)) {
                    break;
                }
                result.add(nickName);
                replacedContent = replacedContent.replace(nickName, StringUtils.EMPTY).trim();
            }
            return result.stream().distinct().collect(Collectors.toList());
        }
        return Collections.emptyList();
    }


    /**
     * 话术中微信昵称
     *
     * @param content
     * @return
     */
    private static String getFirstAtNicknameByContent(String content) {
        List<String> nicknameKeyWords = Arrays.asList(" ", " ", " ");
        if (StringUtils.isNotBlank(content) && isContainAtMonitorKeyword(content)) {
            int beginIndex = content.indexOf("@");
            int endIndex = 0; //StringHelper.indexOfAnyExtension(content, nicknameKeyWords, beginIndex);
            if (endIndex < 1) {
                endIndex = content.length();
            }

            if (endIndex > beginIndex) {
                return content.substring(beginIndex, endIndex).trim();
            }
        }
        return StringUtils.EMPTY;
    }

    public static boolean isContainAtMonitorKeyword(String content) {
        return StringUtils.isNotBlank(content) && content.contains("@");
    }

}
