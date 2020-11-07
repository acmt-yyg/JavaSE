package banyuan;

import java.util.Map;

/**
 * @author YangYonggang on 2020/10/12 6:56 下午
 * @Description: 枚举类：响应状态
 */
public enum RespStatus {
		OK("200 OK"),
		BAD_REQUEST("400 Bad request"),
		REDIRECT("302 Found"),
		INTERNAL_SERVER_ERROR("500 Internal Server Error"),
		;

		private String msg;

		public String getMsg() {
				return "HTTP/1.1" + msg + "\n";
		}

		RespStatus(String msg) {
				this.msg = msg;
		}

}
