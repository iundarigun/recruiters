package br.com.devcave.recruiters.common;

import org.apache.commons.lang3.StringUtils;

/**
 * Created by s2it_ocanalias on 1/18/17.
 */
public class RecruitersUtil {

    public static String helloworld(String nome) {
        if (StringUtils.isNotBlank(nome)) {
            return "Hello " + nome;
        }
        return "Hello world";
    }
}
