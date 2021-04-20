package com.sampleCache.servelet;

import java.io.PrintWriter;

import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.config.AutowireCapableBeanFactory;
import org.springframework.web.context.WebApplicationContext;
import org.springframework.web.context.support.WebApplicationContextUtils;

import com.sampleCache.firstcache.simpleCache;

@WebServlet(urlPatterns = "/cacheAPI.do")
public class cacheApiServelet extends HttpServlet {

	@Autowired
	private simpleCache cacheImplementation;

	private WebApplicationContext springContext;

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, java.io.IOException {
		PrintWriter out = response.getWriter();
		String key = request.getParameter("key");
		String value = request.getParameter("value");
		System.out.println(cacheImplementation);
		out.println("check");
		if (value != null && key != null) {
			cacheImplementation.add(key, value, 10000);
			out.println("key: " + key + ", value: " + value + ", item added to cache");
		} else if (key != null && value == null) {
			Object retrieved = cacheImplementation.get(key);
			if (retrieved == null) {
				out.println("key " + key + " has retrieved nothing");
			} else {
				out.println("key: " + key + " has retrieved value: " + retrieved.toString());
			}
		} else {
			out.println("invalid request");
		}
	}

	@Override
	public void init(final ServletConfig config) throws ServletException {
		super.init(config);
		springContext = WebApplicationContextUtils.getRequiredWebApplicationContext(config.getServletContext());
		final AutowireCapableBeanFactory beanFactory = springContext.getAutowireCapableBeanFactory();
		beanFactory.autowireBean(this);
	}
}
