/*package array;

import java.util.HashMap;

public class NumberToChineseVoice {
	static String[] voiceTable = new String[]{"零", "一", "二", "三", "四", "五", "六", "七", "八", "九"};
	static HashMap<Long, String> units = new HashMap<Long, String>();
	static {
		units.put(1L, "");
		units.put(10L, "十");
		units.put(100L, "百");
		units.put(1000L, "千");
		units.put(10000L, "万");
		units.put(100000000L, "亿");
	}
	
	public static void main(String[] args) {
//		System.out.println(NumberToChineseVoice.translate(3000L));
//		System.out.println(NumberToChineseVoice.translate(32120512340L));
		System.out.println(NumberToChineseVoice.translate(3010002023L));
//		System.out.println(NumberToChineseVoice.translate(300000001L));
//		System.out.println(NumberToChineseVoice.translate(300000L));
//		System.out.println(NumberToChineseVoice.translate(3000000L));
//		System.out.println(NumberToChineseVoice.translate(30000000L));
//		System.out.println(NumberToChineseVoice.translate(300000000L));
//		System.out.println(NumberToChineseVoice.translate(3000000000L));

	}
	
	public static String translate(long number) {
		String voice = "";
		long unit = 1;
		long sepUnit = 1;
		// 1050000 尾部全０的特殊处理
		while (number != 0) {
			long r = number % 10;
			if (r == 0) {
				number /= 10;
				unit *= 10;
				sepUnit *= 10;
				if (unit == 10000 || unit == 100000000) {
					unit = 1;
					long sep;
					if (sepUnit > 0 && sepUnit < 100000) {
						sep = 10000L;
					}
					else {
						sep = 100000000L;
					}
					voice = units.get(sep);
				}
			} else {
				break;
			}
		}
		
		while (number != 0) {
			long r = number % 10;
			// 中间连续的０必须读出来，但是只能读一次
			while (r == 0) {
				r = number % 10;
				if (r == 0) {
					if (unit == 10000) {
						unit = 1;
						long sep;
						if (sepUnit > 0 && sepUnit < 100000) {
							sep = 10000L;
						}
						else {
							sep = 100000000L;
						}
						voice = units.get(sep) + voice;
						System.out.println("---------" + voice);

					}
					System.out.println("r==0 " + voice);
					number /= 10;
					unit *= 10;
					sepUnit *= 10;
				} else {
					voice = voiceTable[0] + voice;
					break;
				}
			}
			if (unit == 10000) {
				unit = 1;
				long sep;
				if (sepUnit > 0 && sepUnit < 100000) {
					sep = 10000L;
				}
				else {
					sep = 100000000L;
				}
				voice = voiceTable[(int)r] + units.get(sep) + voice;
				System.out.println(voice);

			}
			else {
				voice = voiceTable[(int)r] + units.get(unit) + voice;
				System.out.println(voice);

			}
			number /= 10;
			unit *= 10;
			sepUnit *= 10;
		}
		return voice;
	}
}
*/

package array;

import java.util.HashMap;

public class NumberToChineseVoice {
	static String[] voiceTable = new String[] { "零", "一", "二", "三", "四", "五", "六", "七", "八", "九" };
	static HashMap<Long, String> units = new HashMap<Long, String>();
	static {
		units.put(1L, "");
		units.put(10L, "十");
		units.put(100L, "百");
		units.put(1000L, "千");
		units.put(10000L, "万");
		units.put(100000000L, "亿");
		units.put(1000000000000L, "兆");
	}

	public static void main(String[] args) {
		System.out.println(NumberToChineseVoice.translate(3000L));
		System.out.println(NumberToChineseVoice.translate(32120512340L));
		System.out.println(NumberToChineseVoice.translate(3010002023L));
		System.out.println(NumberToChineseVoice.translate(300000001L));
		System.out.println(NumberToChineseVoice.translate(300000010L));
		System.out.println(NumberToChineseVoice.translate(300000100L));
		System.out.println(NumberToChineseVoice.translate(300001000L));
		System.out.println(NumberToChineseVoice.translate(300010000L));
		System.out.println(NumberToChineseVoice.translate(300000L));
		System.out.println(NumberToChineseVoice.translate(3000000L));
		System.out.println(NumberToChineseVoice.translate(30000000L));
		System.out.println(NumberToChineseVoice.translate(300000000L));
		System.out.println(NumberToChineseVoice.translate(3000000000L));

	}

	public static String translate(long number) {
		String voice = "";
		long unit = 1;
		// 四位一组分组，一组是一个量级单位，万，亿，兆， 区别英文，英文的分组单位是三位一组，thousand, million, billion
		long d1 = number % 10000;
		System.out.println(d1);
		long d2 = number / 10000 % 10000;
		System.out.println(d2);
		long d3 = number / 100000000 % 10000;
		System.out.println(d3);
		long d4 = number / 1000000000000L % 10000;
		System.out.println(d4);

		if (d4 != 0L) {
			voice += translateGroup((int) d4, units.get(1000000000000L));
		}

		if (d3 != 0L) {
			String groupVoice = translateGroup((int) d3, units.get(100000000L));
			if ( d4 != 0 && d3 / 1000 == 0) {
				voice += voiceTable[0] + groupVoice;
			} else {
				voice += groupVoice; 
			}
		}
		if (d2 != 0) {
			String groupVoice = translateGroup((int) d2, units.get(10000L));
			if ((d4 != 0 || d3 != 0) && d2 / 1000 == 0 || (d4 != 0 && d3 == 0)) {
				voice += voiceTable[0] + groupVoice;
			} else {
				voice += groupVoice; 
			}
		}
		if (d1 != 0) {
			String groupVoice = translateGroup((int) d1, units.get(1L));
			if ((d4 != 0 || d3 != 0 || d2 != 0) && d1 / 1000 == 0 || ((d4 != 0 || d3 != 0) && d2 == 0)) {
				voice += voiceTable[0] + groupVoice;
			} else {
				voice += groupVoice; 
			}
		}
		return voice;
	}

	public static String translateGroup(int number, String unit) {
		String voice = "";
		long level = 1;
		while (number != 0) {
			int r = number % 10;
			if (r == 0) {
				number /= 10;
				level *= 10;
			} else {
				break;
			}
		}
		while (number != 0) {
			int r = number % 10;
			while (r == 0) {
				r = number % 10;
				if (r == 0) {
					number /= 10;
					level *= 10;
				} else {
					voice = "零" + voice;
				}
			}
			voice = voiceTable[r] + units.get(level) + voice;
			number /= 10;
			level *= 10;
		}
		return voice + unit;
	}
}
