package banyuan;

import java.lang.reflect.Field;

/**
 * @author YangYonggang on 2020/10/29 2:03 下午
 * @Description:do 验证是否合法
 */
public class ValidateUtil {

		/**
		 * 传入一个Object对象，根据对象中定义的 EntityValidate 注解，
		 * 取出正则与对象中保存的属性值进行匹配，如果不匹配抛出异常
		 *
		 * @param o
		 */
		public static void validate(Object o) {
				// 获取o对象
				Class<?> aClass = o.getClass();
				// 获取变量列表，遍历变量列表找出被特定注解修饰的一批成员变量对象
				Field[] declaredFields = aClass.getDeclaredFields();
				for (Field declaredField : declaredFields) {
						EntityValidate validate = declaredField.getDeclaredAnnotation(EntityValidate.class);
						if (validate != null) {
								declaredField.setAccessible(true);

								// 先判断是否为空
								Object value = null;
								try {
										value = declaredField.get(o);
								} catch (IllegalAccessException e) {
										throw new RuntimeException(e);
								}
								if (value == null) {
										if (!validate.isBlank()) {
												throw new BadReqException(declaredField.getName() + "值不能为空");
										}
										// 值是null，并且配置值允许为null，不做正则的判断
										continue;
								}
								// 到这里，value一定不是null，进行正则校验
								if (!validate.toString().matches(validate.regex())) {
										throw new BadReqException(validate.mag());
								}
						}
				}
		}
}
