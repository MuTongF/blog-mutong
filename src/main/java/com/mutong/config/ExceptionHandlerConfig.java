package com.mutong.config;

import com.alibaba.fastjson.JSONObject;
import com.mutong.common.LayuiJson;
import com.mutong.exception.MuTongException;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.HashMap;
import java.util.Map;
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
		String header = request.getContentType();
		System.out.println(header);
		System.out.println(request.getContextPath());
		if (header == null) {
			request.setAttribute("msg", "请联系管理人员检查站点错误");
			response.sendRedirect("/error/");
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

	@ExceptionHandler(value = MuTongException.class)
	public void MuTong(HttpServletResponse response, HttpServletRequest request, MuTongException e)
			throws IOException, ServletException {
		e.printStackTrace();
		response.setStatus(e.getCode());
		Map<String, Object> map = new HashMap<>();
		map.put("code", e.getCode());
		map.put("msg", e.getMsg());
		// 设置浏览器字符集编码.
		response.setHeader("Content-Type", "text/html;charset=UTF-8");
		// 设置response的缓冲区的编码.
		response.setCharacterEncoding("UTF-8");
		PrintWriter writer = response.getWriter();

		writer.write(JSONObject.toJSONString(map));
	}
}
