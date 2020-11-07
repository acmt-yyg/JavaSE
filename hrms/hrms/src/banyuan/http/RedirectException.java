package banyuan;

/**
 * @author YangYonggang on 2020/10/28 8:07 下午
 * @Description:do
 */
public class RedirectException extends RuntimeException{

		public RedirectException() {
		}

		public RedirectException(String message) {
				super(message);
		}

		public RedirectException(String message, Throwable cause) {
				super(message, cause);
		}

		public RedirectException(Throwable cause) {
				super(cause);
		}

		public RedirectException(String message, Throwable cause, boolean enableSuppression, boolean writableStackTrace) {
				super(message, cause, enableSuppression, writableStackTrace);
		}
}
