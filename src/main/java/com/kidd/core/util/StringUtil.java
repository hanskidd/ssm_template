package com.kidd.core.util;


import java.util.ArrayList;
import java.util.List;

import org.apache.log4j.Logger;

/**
 * 字符串工具类
 * @author kidd
 * @since 2016-11-15 11:10
 */
public class StringUtil {
	private static Logger logger = Logger.getLogger(StringUtil.class);

	public StringUtil() {
	}


	public static boolean isBlankString(String str) {
		return ((str == null) || ("".equals(str)));
	}


	/**
	 * 判断字符串是否非空并且非""
	 * 
	 * @param str
	 * @return boolean
	 */
	public static boolean judgeStr(String str) {
		return str != null && str.trim() != null && !"".equals(str.trim());
	}

	/**
	 * 判断字符串是否为null或""
	 * 
	 * @param str
	 * @return boolean
	 */
	public static boolean isNullStr(String str) {
		return str == null || "".equals(str.trim()) || str.trim() == null;
	}

	public static String formatString(String str, String pattern) {

		String s[] = str.split(pattern);
		StringBuffer result = new StringBuffer();

		for (String r : s) {
			result.append(",'").append(r).append("'");
		}

		return result.substring(1);
	}

	public static int[] string2Int(String str[]) {
		int num[] = new int[str.length];
		for (int i = 0; i < num.length; i++) {
			num[i] = Integer.parseInt(str[i]);
		}
		return num;
	}

	public static Integer[] string2Integer(String str[]) {
		Integer num[] = new Integer[str.length];
		for (int i = 0; i < num.length; i++) {
			num[i] = Integer.parseInt(str[i]);
		}
		return num;
	}

	/**
	 * 将字符串按照指定字符分割，并转化为整型数值
	 * 
	 * @param str
	 *            要进行处理的字符串
	 * @param regex
	 *            进行分割字符的正则表达式
	 * @return 整型List列表
	 */
	public static List<Integer> stringSplitInteger(String str, String regex) {
		List<Integer> list = new ArrayList<Integer>();

		if (!isNullStr(str)) {
			try {
				for (String num : str.split(regex)) {
					list.add(Integer.parseInt(num));
				}
			} catch (NumberFormatException e) {
				logger.error("字符串转换为整型List出错：" + e.getMessage());
			}
		}

		return list;
	}


}
