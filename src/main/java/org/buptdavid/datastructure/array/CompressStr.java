package org.buptdavid.datastructure.array;

import junit.framework.Assert;

import org.junit.Test;

/**
 * 压缩字符串,如果压缩后的字符串长度大于等于原字符串长度,则返回原字符串
 * @author weijielu
 *
 *  压缩字符串:
 *  压缩规则：
 *  相邻的两个字符串相同使用数组统计
 *  压缩之后的字符串大于或者等于原字符串长度那么返回原来的字符串
 *  算法：
 *  1.遍历字符串：
 *  2.从下一个字符开始比较如果和当前相同那么继续，并且记录下当前相同字符的数量
 *  3.若下一个字符不相同了从下一个字符开始继续比较，并且把当前字符存储
 *
 */
public class CompressStr {
    public static String compress(String s){
        StringBuffer sb = new StringBuffer();
        
        int i,j;
        for(i = 0; i < s.length(); i++){
            j = i + 1;
            while(j < s.length() && s.charAt(j) == s.charAt(i)){
                j++;
            }
            
            sb.append(s.charAt(i));
            sb.append(j - i);
            
            i = j - 1;
        }
        
        String sbString = sb.toString();
        return sbString.length() <= s.length()? sbString.toString() : s;
    }
    
    @Test
    public void test(){
        String s1 = "aabcccaaaa";
        String expectedS1 = "a2b1c3a4";
        
        String s2 = "aaaaaaaaaaaa";
        String expectedS2 = "a12";
        
        String s3 = "abcdefg";
        String expectedS3 = "abcdefg";
        
        String s4 = "aabbccdd";
        String expectedS4 = "aabbccdd";
        
        Assert.assertEquals(expectedS1, compress(s1));
        Assert.assertEquals(expectedS2, compress(s2));
        Assert.assertEquals(expectedS3, compress(s3));
        Assert.assertEquals(expectedS4, s4);
    }
}
