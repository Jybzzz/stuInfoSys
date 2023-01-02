package util;

//该工具类StringUtil是用于处理字符串的相关操作的
public class StringUtil {
	//定义一个布尔类型的类方法isEmpty()用于判断字符串是否为空
	public static boolean isEmpty(String str) {
		if("".equals(str) || str==null) {
			return true;
		}
		 return false;
	}
}
