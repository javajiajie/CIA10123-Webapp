package com.product.servlet;

import java.io.*;
import java.util.*;

import javax.servlet.*;
import javax.servlet.http.*;

import com.product.model.*;

public class ProductServlet {

		public void doGet(HttpServletRequest req, HttpServletResponse res)
				throws ServletException, IOException {
			doPost(req, res);
		}

		public void doPost(HttpServletRequest req, HttpServletResponse res)
				throws ServletException, IOException {

			req.setCharacterEncoding("UTF-8");
			String action = req.getParameter("action");

			if ("getAll".equals(action)) {
				/***************************開始查詢資料 ****************************************/
				ProductJDBCDAO dao = new ProductJDBCDAO();
				List<ProductVO> list = dao.getAll();

				/***************************查詢完成,準備轉交(Send the Success view)*************/
				HttpSession session = req.getSession();
				session.setAttribute("list", list);    // 資料庫取出的list物件,存入session
				// Send the Success view
				String url = "/product/listAllProduct_getFromSession.jsp";
				RequestDispatcher successView = req.getRequestDispatcher(url);// 成功轉交listAllProduct_getFromSession.jsp
				successView.forward(req, res);
				return;
			}


			if ("getOne_For_Display".equals(action)) { // 來自select_page.jsp的請求

				List<String> errorMsgs = new LinkedList<String>();
				// Store this set in the request scope, in case we need to
				// send the ErrorPage view.
				req.setAttribute("errorMsgs", errorMsgs);

					/***************************1.接收請求參數 - 輸入格式的錯誤處理**********************/
					String str = req.getParameter("empno");
					if (str == null || (str.trim()).length() == 0) {  //(str.trim()).length() == 0 P60  // str == null 防呆用，好除錯，可以不用寫
						errorMsgs.add("請輸入員工編號");
					}
					// ● Send the use back to the form, if there were errors
					if (!errorMsgs.isEmpty()) {
						RequestDispatcher failureView = req
								.getRequestDispatcher("/emp/select_page.jsp");
						failureView.forward(req, res);
						return;//程式中斷
					}
					
					Integer productId = null;
					try {
						productId = Integer.valueOf(str);  //把輸入員工編號的字串轉乘Integer存入empno
					} catch (Exception e) {  //存不了捕捉拋出錯誤
						errorMsgs.add("員工編號格式不正確");
					}
					// ● Send the use back to the form, if there were errors
					if (!errorMsgs.isEmpty()) {
						RequestDispatcher failureView = req
								.getRequestDispatcher("/emp/select_page.jsp");
						failureView.forward(req, res);
						return;//程式中斷
					}
					
					/***************************2.開始查詢資料*****************************************/
					ProductJDBCDAO dao = new ProductJDBCDAO();
					ProductVO productVO = dao.indByPrimaryKey(productId);
					if (productVO == null) {
						errorMsgs.add("查無資料");
					}
					// ● Send the use back to the form, if there were errors
					if (!errorMsgs.isEmpty()) {
						RequestDispatcher failureView = req
								.getRequestDispatcher("/emp/select_page.jsp");
						failureView.forward(req, res);
						return;//程式中斷
					}
					
					/***************************3.查詢完成,準備轉交(Send the Success view)*************/
					req.setAttribute("productVO", productVO);
					String url = "/product/listOneProduct.jsp";
					RequestDispatcher successView = req.getRequestDispatcher(url); // 成功轉交 listOneProduct.jsp P225 .195
					successView.forward(req, res);
			}
		}
	}
