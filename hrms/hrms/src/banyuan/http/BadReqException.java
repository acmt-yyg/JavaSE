package banyuan;

/**
 * @author YangYonggang on 2020/10/28 7:31 下午
 * @Description:do
 */
public class BadReqException extends RuntimeException{
		public BadReqException() {
		}

		public BadReqException(String message) {
				super(message);
		}

		public BadReqException(String message, Throwable cause) {
				super(message, cause);
		}

		public BadReqException(Throwable cause) {
				super(cause);
		}

		public BadReqException(String message, Throwable cause, boolean enableSuppression, boolean writableStackTrace) {
				super(message, cause, enableSuppression, writableStackTrace);
		}
}
