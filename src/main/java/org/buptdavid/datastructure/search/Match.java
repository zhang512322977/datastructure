package org.buptdavid.datastructure.search;

/**
 * @Auther: zhangdong
 * @Date: 2019/5/17 22:54
 * @Description:
 */
interface MatchHander{
    boolean compare(int a,int b);
}


public class Match {

    /**
     * 百分之多少之内匹配错误可以接受
     * a与ab匹配为百分之50的错误率。
     * @param percent 设置匹配百分比
     * @param src 字符串1
     * @param dest 字符串2
     * @param hander 匹配规则
     * @return
     */
    public static boolean match(double percent,String src,String dest,MatchHander hander){
        char[] csrc = src.toCharArray();
        char[] cdest = dest.toCharArray();
        double score = 0;
        int max = csrc.length>cdest.length?csrc.length:cdest.length;
        score = cal(csrc,0,cdest,0,hander,0,(int)Math.ceil((1-percent)*max));
        System.out.println("最小匹配百分比："+percent+"，成功匹配百分比："+score / max);
        return score / max > percent;
    }

    /**
     * 几个错误的字符可以接受
     * a与ab为1个字符错误可以接受
     * @param percent 设置匹配百分比
     * @param src 字符串1
     * @param dest 字符串2
     * @param hander 匹配规则
     * @return
     */
    public static boolean match(int errorNum,String src,String dest,MatchHander hander){
        char[] csrc = src.toCharArray();
        char[] cdest = dest.toCharArray();
        int score = 0;
        score = cal(csrc,0,cdest,0,hander,0,errorNum);
        int max = csrc.length>cdest.length?csrc.length:cdest.length;
        System.out.println("可以接受错误数："+errorNum+"，发现错误数："+(max - score) );
        return max - score  <= errorNum;
    }
    /**
     * 2个字符串75%匹配成功返回true
     * @param src
     * @param dest
     * @return
     */
    public static boolean match(double percent,String src,String dest){
        return match(percent,src,dest,new MatchHander(){

            @Override
            public boolean compare(int a, int b) {
                return a==b;
            }});
    }
    /**
     * 2个字符串错几个字符可以接受
     * @param errorNum
     * @param src
     * @param dest
     * @return
     */
    public static boolean match(int errorNum,String src,String dest){
        return match(errorNum,src,dest,new MatchHander(){

            @Override
            public boolean compare(int a, int b) {
                return a==b;
            }});
    }

    /**
     * 使用递归方法匹配字符串
     * @param csrc
     * @param i
     * @param cdest
     * @param j
     * @param hander
     * @return
     */
    private static int cal(char[] csrc, int i, char[] cdest, int j, MatchHander hander,int curdeep,int maxdeep) {
        int score = 0;
        if( curdeep > maxdeep ||i >= csrc.length || j >= cdest.length)
        { return 0;}
        boolean ismatch = hander.compare(csrc[i], cdest[j]);
        if(ismatch){
            score++;
            if(i+1<csrc.length && j+1<cdest.length) {
                score +=  cal(csrc, i+1, cdest, j+1, hander,0,maxdeep) ;
            }
        }else{
            int temp1 = 0;
            int temp2 = 0;
            int temp3 = 0;
            temp1 +=  cal(csrc, i, cdest, j+1, hander,curdeep+1,maxdeep) ;
            temp2 +=  cal(csrc, i+1, cdest, j, hander,curdeep+1,maxdeep) ;
            temp3 +=  cal(csrc, i+1, cdest, j+1, hander,curdeep+1,maxdeep) ;
            int temp4 = Math.max(temp1, temp2);
            score += Math.max(temp3, temp4);
        }
        return score;
    }
    public static void main(String[] args) {
        //三个字符错误可以接受
        //System.out.println(match(3,"N55-8P-SSK9=【产品描述：附件|Nexus 5500 存储附件(8端口)】","N55-8P-SSK9=【产品描述：配件|Nexus 5500 存储配件(8端口)】"));
        //75%匹配可以接受
        String a="3HE03619\"AA【产品描述(4档):IOM - 7750 SR IOM3-XP|7750 SR 50G IOM3-XP,每块IOM3可以插两块MDA或MDA-XP。注意：当安装使用IOM3-XP时，在空IOM槽位上必须使用新型空面板：3HE04147AA或3HE04148AA】";
        String b="3HE03619AA【产品描述(4档):IOM - 7750 SR IOM3-XP|7750 SR 50G IOM3-XP,每块IOM3可以插两块MDA或MDA-XP。\n注意：当安装使用IOM3-XP时，在空IOM槽位上必须使用新型空面板：3HE04147AA或3HE04148AA】";
        System.out.println(match(4,a,b));
    }
}