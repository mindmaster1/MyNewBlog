package com.xhd.component;

import org.springframework.stereotype.Component;

/**
 * @author:xinghaodong
 * @Date:2021 - 9 - 05 - 10:05
 * @Description: 字符串和字符串数组之间的转换
 * @version:
 */
@Component
public class StringAndArray {
    /**
     * 将字符串转换成字符串数组
     * @param str 字符串
     * @return 转换后的字符串数组
     */
    public static String[] stringToArray(String str){
        //spilt()方法会按照指定的分隔符将字符串分割为字符数组
        String[] array = str.split(",");
        for(int i=0;i<array.length;i++){
            //trim()方法会移除字符串起始及结尾处的空白单元
            array[i] = array[i].trim();
        }
        return array;
    }

    /**
     * 将字符串数组拼接为字符串
     * @param articleTags 字符串数组
     * @return 拼接后的字符串
     */
    public static String arraytoString(String[] articleTags){
        //StringBuilder,相较于String,是一个可变对象，可以预先分配缓冲区，在往StringBuider中新增字符时，不会创建新的字符串对象
        StringBuilder sb = new StringBuilder();
        for(String s: articleTags){
            if(sb.length()==0){
                sb.append(s.trim());
            }else{
                sb.append(",").append(s.trim());
            }
        }
        return sb.toString();
    }
}
