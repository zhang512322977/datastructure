package org.buptdavid.datastructure.string;

public class Demo
{

    public static void main(String[] args)
    {
        System.out.println(getAdaptationsNum("1.5", 2000));//3000
        System.out.println(getAdaptationsNum("1.3", 2001));//2601
        System.out.println(getAdaptationsNum("3", 2000));//6000
        //System.out.println(getAdaptationsNum("1.5",null));
        System.out.println(getAdaptationsNum("1.5#", 2000));//3000册+
        System.out.println(getAdaptationsNum("#", 2000));//2000册+
        System.out.println(getAdaptationsNum("@3471", 2000));//3471册
        System.out.println(getAdaptationsNum("@3471#", 2000));//3000册+
        System.out.println(getAdaptationsNum("1.5@3471#", 2000));//空
        System.out.println(getAdaptationsNum("@1#", 2000));//100册+
        System.out.println(getAdaptationsNum("@199#", 2000));//100册+
        System.out.println(getAdaptationsNum("@201#", 2000));//200册+
        System.out.println(getAdaptationsNum("@10001#", 2000));//1万册+
        System.out.println(getAdaptationsNum("@100001#", 2000));//10万册+
        System.out.println(getAdaptationsNum("@101001#", 2000));//10.1万册+
        System.out.println(getAdaptationsNum("@99999#", 2000));//10.1万册+

        System.out.println(getAdaptationsNum("3#", 13666));//10.1万册+


        //System.out.println(String.format("%.1f", 4.0998));
       // System.out.println(40998 % 10000);
        // System.out.println(100001/100%10);

    }

    public static boolean isEmpty(String str)
    {
        return ((str == null) || (str.trim().length() == 0));
    }

    public static boolean isNotEmpty(String str)
    {
        return !isEmpty(str);
    }

    /**
     * 图书单位
     */
    public static final String BOOK_UNIT = "册";

    /**
     * 专区倍数和真实数据分割符
     */
    public static final String DESC_SPLITTER = "@";

    /**
     * 模糊规则标识符号
     */
    public static final String DESC_FUZZY_SYMBOL = "#";

    public static final String DESC_WAN_CE_UNIT = "万";

    public static final String DESC_SYMBOL_ADD = "+";
    /**
     * 根据适配规则获取总数 展示数据配置规则中有倍数和是否模糊展示的规则。如分类配置1.5@3417#，
     * 其中1.5代表专区图书数量的倍数，3417代表希望展示的实际数量，#号表示是否模糊展示
     *
     * @param dataUrlDesc
     * @param total
     * @return
     */
    public static String getAdaptationsNum(String dataUrlDesc, Integer total)
    {

        if (isEmpty(dataUrlDesc))
        {
            return "";
        }
        String adaptationsResult = "";
        if (dataUrlDesc.contains(DESC_FUZZY_SYMBOL))
        {
            adaptationsResult += BOOK_UNIT;
            adaptationsResult += DESC_SYMBOL_ADD;
            dataUrlDesc = dataUrlDesc.replace(DESC_FUZZY_SYMBOL, "");
        }
        long tempTotal = 0;
        if (dataUrlDesc.contains(DESC_SPLITTER))
        {
            tempTotal = getTotalWithDesc(dataUrlDesc, total);
        }
        else
        {
            // 没有连接符且没有倍数
            if (isEmpty(dataUrlDesc))
            {
                tempTotal = total;
            }
            else
            {
                // 没有连接符有倍数
                Double tempMultiple = Double.valueOf(dataUrlDesc);
                tempTotal = Math.round(tempMultiple * total);
            }
        }
        if (isNotEmpty(adaptationsResult))
        {
            return getResultWithFuzzySymbol(tempTotal, adaptationsResult);
        }
        else
        {
            adaptationsResult += tempTotal + BOOK_UNIT;
        }
        return adaptationsResult;
    }

    /**
     * 根据规则获取模糊匹配结果
     * 展示数量为3417的模糊数量，3000+册；
     * 模糊展示规则：不足200册展示100册+，高于200不足300展示200册+，300册+，
     * 400册+……1000册+，2000册+，……1万册+，1.1万册+，3.2万册+，10万册+，
     * 10.1万册+，11万册+，11.5万册+……。多余1万最多展示1位小数。
     *
     * @param tempTotal
     * @param adaptationsResult
     * @return
     */
    private static String getResultWithFuzzySymbol(long tempTotal,
        String adaptationsResult)
    {

        if (0 < tempTotal && tempTotal < 200)
        {
            return 100 + adaptationsResult;
        }
        if (200 <= tempTotal && tempTotal < 1000)
        {
            long a = tempTotal / 100;
            return a * 100 + adaptationsResult;
        }
        if (1000 <= tempTotal && tempTotal < 10000)
        {
            long a = tempTotal / 1000;
            return a * 1000 + adaptationsResult;
        }
        if (10000 <= tempTotal)
        {
            double a = tempTotal / 10000.0;
            // 是整万的数不要小数点
            if (tempTotal % 10000 == 0)
            {
                //1010
                return (tempTotal/10000) + DESC_WAN_CE_UNIT
                    + adaptationsResult;
            }
            // 非整万的数要保留小数点一位
            return String.format("%.1f", a).replace(".0","") + DESC_WAN_CE_UNIT
                + adaptationsResult;
        }
        return "";
    }

    /**
     * 根据带连接符的规则获取总数
     *
     * @param dataUrlDesc
     * @param total
     * @return
     */
    private static long getTotalWithDesc(String dataUrlDesc, Integer total)
    {
        String descTemp[] = dataUrlDesc.split(DESC_SPLITTER);
        String multiple = descTemp[0];
        String basic = descTemp[1];
        // 没有倍数只有基数
        if (isEmpty(multiple) && isNotEmpty(basic))
        {
            return Integer.valueOf(basic);
        }
        else if (isNotEmpty(multiple) && isNotEmpty(basic))
        {
            return 0;
        }
        if (isEmpty(basic) && isNotEmpty(multiple))
        {
            // 只有倍数，没有基数--一般不会出现
            Double tempMultiple = Double.valueOf(multiple);
            return Math.round(tempMultiple * total);
        }
        return 0;
    }

}