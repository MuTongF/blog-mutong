package com.mutong.config;

import com.mutong.common.LayuiJson;
import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import org.springframework.web.HttpRequestMethodNotSupportedException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;

/**
 * 统一异常处理类
 */
@ControllerAdvice
public class ExceptionHandlerConfig {

	@ExceptionHandler(value = Exception.class)
	@ResponseBody
	public LayuiJson error(HttpServletResponse response, HttpServletRequest request, Exception e)
			throws IOException, ServletException {
		e.printStackTrace();
		if (request.getContentType().contains("text/html")) {
			request.setAttribute("msg", "请联系管理人员检查站点错误");
			request.getRequestDispatcher("/error").forward(request, response);
		}
		return LayuiJson.newErrorInstance(9001, "系统繁忙", e.getMessage());
	}

	@ExceptionHandler(value = HttpRequestMethodNotSupportedException.class)
	public void httpError(HttpServletResponse response, HttpServletRequest request, Exception e)
			throws IOException, ServletException {
		e.printStackTrace();
		System.out.println(e.getMessage());
		response.setStatus(404);
		response.addHeader("msg", "HttpRequestMethodNotSupported");
		request.setAttribute("msg", "请求方法错误:HttpRequestMethodNotSupported");
		request.getRequestDispatcher("/error/404").forward(request, response);
	}
}
