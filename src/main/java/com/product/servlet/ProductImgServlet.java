package com.product.servlet;

import java.io.IOException;
import java.util.Arrays;
import java.util.List;
import java.util.Map;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import entity.ProductImg;
import com.product.service.*;

@WebServlet("/product/productImg.do")
public class ProductImgServlet extends HttpServlet {
	// 一個 servlet 實體對應一個 service 實體
	private ProductImgService productImgService;

	@Override
	public void init() throws ServletException {
		productImgService = new ProductImgServiceImpl();
	}

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
		req.setCharacterEncoding("UTF-8");
		String action = req.getParameter("action");
		String forwardPath = "";
		switch (action) {
		case "getAll":
			forwardPath = getAllProductImgs(req, res);
			break;
		case "compositeQuery":
			forwardPath = getProductImgsByCompositeQuery(req, res);
			break;
		default:
			forwardPath = "/index.jsp";
		}

		res.setContentType("text/html; charset=UTF-8");
		RequestDispatcher dispatcher = req.getRequestDispatcher(forwardPath);
		dispatcher.forward(req, res);
	}

	private String getAllProductImgs(HttpServletRequest req, HttpServletResponse res) {
		String page = req.getParameter("page");
		int currentPage = (page == null) ? 1 : Integer.parseInt(page); // 因為第一頁不會有page的字串，所以拿這個來判斷是在第幾頁

		List<ProductImg> productImgList = productImgService.getAllProductImgs(currentPage); // currentPage當前頁面

		if (req.getSession().getAttribute("productImgPageQty") == null) {
			int productImgPageQty = productImgService.getPageTotal();
			req.getSession().setAttribute("productImgPageQty", productImgPageQty);
		}

		req.setAttribute("productImgList", productImgList);
		req.setAttribute("currentPage", currentPage);

		return "/product/listAllProductImg.jsp";
	}

	private String getProductImgsByCompositeQuery(HttpServletRequest req, HttpServletResponse res) {
		Map<String, String[]> map = req.getParameterMap();

		if (map != null) {
			List<ProductImg> productImgList = productImgService.getProductImgsByCompositeQuery(map);
			req.setAttribute("productImgList", productImgList);
		} else {
			return "/index.jsp";
		}
		return "/product/listCompositeQueryProductImg.jsp";
	}

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
		doPost(req, res);
	}
}
