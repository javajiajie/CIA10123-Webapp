package com.product.servlet;

import java.io.*;
import java.util.*;
import javax.servlet.*;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.*;
import com.product.model.*;

@WebServlet("/product/product.do")

public class ProductServlet extends HttpServlet {

	public void doGet(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
		doPost(req, res);
	}

	public void doPost(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {

		req.setCharacterEncoding("UTF-8");
		String action = req.getParameter("action");

		if ("getOne_For_Display".equals(action)) { // 來自select_page.jsp的請求

			List<String> errorMsgs = new LinkedList<String>();
			// Store this set in the request scope, in case we need to
			// send the ErrorPage view.
			req.setAttribute("errorMsgs", errorMsgs);

			/*************************** 1.接收請求參數 - 輸入格式的錯誤處理 **********************/
			String str = req.getParameter("productId");
			if (str == null || (str.trim()).length() == 0) {
				errorMsgs.add("請輸入商品編號");
			}
			// Send the use back to the form, if there were errors
			if (!errorMsgs.isEmpty()) {
				RequestDispatcher failureView = req.getRequestDispatcher("/product/select_page.jsp");
				failureView.forward(req, res);
				return;// 程式中斷
			}

			Integer productId = null;
			try {
				productId = Integer.valueOf(str);
			} catch (Exception e) {
				errorMsgs.add("商品編號格式不正確");
			}
			// Send the use back to the form, if there were errors
			if (!errorMsgs.isEmpty()) {
				RequestDispatcher failureView = req.getRequestDispatcher("/product/select_page.jsp");
				failureView.forward(req, res);
				return;// 程式中斷
			}

			/*************************** 2.開始查詢資料 *****************************************/
			ProductService productSvc = new ProductService();
			ProductVO productone = productSvc.getOneProduct(productId);
			if (productone == null) {
				errorMsgs.add("查無資料");
			}
			// Send the use back to the form, if there were errors
			if (!errorMsgs.isEmpty()) {
				RequestDispatcher failureView = req.getRequestDispatcher("/product/select_page.jsp");
				failureView.forward(req, res);
				return;// 程式中斷
			}

			/*************************** 3.查詢完成,準備轉交(Send the Success view) *************/
			req.setAttribute("productVO", productone); // ●資料庫取出的empVO物件,存入req 放
			String url = "/product/listOneProduct.jsp"; // 取
			RequestDispatcher successView = req.getRequestDispatcher(url); // 成功轉交 listOneEmp.jsp
			successView.forward(req, res);
		}

//		if ("getOne_For_Update".equals(action)) { // 來自listAllEmp.jsp的請求 修改是單一查詢跟新增的綜合體
//
//			List<String> errorMsgs = new LinkedList<String>();
//			// Store this set in the request scope, in case we need to
//			// send the ErrorPage view.
//			req.setAttribute("errorMsgs", errorMsgs);
//
//			/*************************** 1.接收請求參數 ****************************************/
//			Integer productId = Integer.valueOf(req.getParameter("productId"));
//
//			/*************************** 2.開始查詢資料 ****************************************/
//			ProductService productSvc = new ProductService();
//			ProductVO productVO = productSvc.getOneProduct(productId);
//
//			/*************************** 3.查詢完成,準備轉交(Send the Success view) ************/
//			req.setAttribute("productVO", productVO); // ●資料庫取出的empVO物件,存入req
//			String url = "/product/update_product_input.jsp";
//			RequestDispatcher successView = req.getRequestDispatcher(url);// 成功轉交 update_emp_input.jsp
//			successView.forward(req, res);
//		}
//
//		if ("update".equals(action)) { // 來自update_emp_input.jsp的請求
//
//			List<String> errorMsgs = new LinkedList<String>();
//			// Store this set in the request scope, in case we need to
//			// send the ErrorPage view.
//			req.setAttribute("errorMsgs", errorMsgs);
//
//			/*************************** 1.接收請求參數 - 輸入格式的錯誤處理 **********************/
//			Integer productId = Integer.valueOf(req.getParameter("productId").trim());
//
//			String name = req.getParameter("name");
//			String nameReg = "^[(\u4e00-\u9fa5)(a-zA-Z0-9_)]{2,10}$";
//			if (name == null || name.trim().length() == 0) {
//				errorMsgs.add("商品名稱: 請勿空白");
//			} else if (!name.trim().matches(nameReg)) { // 以下練習正則(規)表示式(regular-expression)
//				errorMsgs.add("商品名稱: 只能是中、英文字母、數字和_ , 且長度必需在2到10之間");
//			}
//
//			String sellerId = req.getParameter("sellerId").trim();
//			if (sellerId == null || sellerId.trim().length() == 0) {
//				errorMsgs.add("職位請勿空白");
//			}
//			
//			String categoryId = req.getParameter("categoryId").trim();
//			if (categoryId == null || categoryId.trim().length() == 0) {
//				errorMsgs.add("職位請勿空白");
//			}
//
//			Integer price = null;
//			try {
//				price = Integer.valueOf(req.getParameter("price").trim());
//			} catch (NumberFormatException e) {
//				price = 0;
//				errorMsgs.add("價格請填數字.");
//			}
//
//			Integer quantity = null;
//			try {
//				quantity = Integer.valueOf(req.getParameter("quantity").trim());
//			} catch (NumberFormatException e) {
//				quantity = 0;
//				errorMsgs.add("數量請填數字.");
//			}
//
////			Integer deptno = Integer.valueOf(req.getParameter("deptno").trim());
//
//			ProductVO productVO = new ProductVO();
//			productVO.setProductId(productId);
//			productVO.setName(name);
////			productVO.setSellerId(sellerId);
////			productVO.setCategoryId(categoryId);
//			productVO.setPrice(price);
//			productVO.setQuantity(quantity);
////			productVO.setReviewStatus(reviewStatus);
//
//			// Send the use back to the form, if there were errors
//			if (!errorMsgs.isEmpty()) {
//				req.setAttribute("productVO", productVO); // 含有輸入格式錯誤的empVO物件,也存入req
//				RequestDispatcher failureView = req.getRequestDispatcher("/product/update_Product_input.jsp");
//				failureView.forward(req, res);
//				return; // 程式中斷
//			}
//
//			/*************************** 2.開始修改資料 *****************************************/
//			ProductService productSvc = new ProductService();
//			productVO = productSvc.updateProduct(productId, name, sellerId, categoryId, price, quantity, deptno);
////				empVO = empSvc.用Alt+/可以呼叫方法;
//
//			/*************************** 3.修改完成,準備轉交(Send the Success view) *************/
//			req.setAttribute("productVO", productVO); // 資料庫update成功後,正確的的empVO物件,存入req
//			String url = "/product/listOneProduct.jsp";
//			RequestDispatcher successView = req.getRequestDispatcher(url); // 修改成功後,轉交listOneEmp.jsp
//			successView.forward(req, res);
//		}
		
		
		
		if ("getOne_For_Update".equals(action)) { // 來自listAllEmp.jsp的請求

			Map<String,String> errorMsgs = new LinkedHashMap<String,String>();
			req.setAttribute("errorMsgs", errorMsgs);
			
				/***************************1.接收請求參數****************************************/
				Integer productId = Integer.valueOf(req.getParameter("productId"));
				
				/***************************2.開始查詢資料****************************************/
				ProductService productSvc = new ProductService();
				ProductVO productVO = productSvc.getOneProduct(productId);
								
				/***************************3.查詢完成,準備轉交(Send the Success view)************/
				String param = "?productId="  +productVO.getProductId()+
						       "&name="  +productVO.getName()+
						       "&sellerId="    +productVO.getSellerId()+
						       "&categoryId="+productVO.getCategoryId()+
						       "&price="    +productVO.getPrice()+
						       "&quantity="   +productVO.getQuantity()+
						       "&description="   +productVO.getDescription()+
						       "&reviewStatus="   +productVO.getReviewStatus()+
						       "&productStatus=" +productVO.getProductStatus();
				String url = "/product/update_product_input.jsp"+param;
				RequestDispatcher successView = req.getRequestDispatcher(url);// 成功轉交 update_emp_input.jsp
				successView.forward(req, res);
		}
		
		if ("update".equals(action)) { 
			Map<String,String> errorMsgs = new LinkedHashMap<String,String>();
			req.setAttribute("errorMsgs", errorMsgs);

			/*********************** 1.接收請求參數 - 輸入格式的錯誤處理 *************************/
			Integer productId = Integer.valueOf(req.getParameter("productId").trim());
			
			String name = req.getParameter("name");
			String nameReg = "^[(\u4e00-\u9fa5)(a-zA-Z0-9_)]{2,10}$"; // 是中、英文字母、數字和_ , 且長度必需在2到10之間
			if (name == null || name.trim().length() == 0) {
				errorMsgs.put("商品名稱","請勿空白");
			} else if (!name.trim().matches(nameReg)) { // 以下練習正則(規)表示式(regular-expression)matches匹配
				errorMsgs.put("商品名稱","只能是中、英文字母、數字和_ , 且長度必需在2到10之間");
			}
			Integer sellerId = null;
			try {
				sellerId = Integer.valueOf(req.getParameter("sellerId").trim());
			} catch (NumberFormatException e) { // 可以直接拋Exception就好//父類別java.lang.Number及IllegalArgumentException
				sellerId = 0; // 前端介面預設顯示
				errorMsgs.put("賣家編號","請勿空白");
			}
			
			Integer categoryId = null;
			try {
				categoryId = Integer.valueOf(req.getParameter("categoryId").trim());
			} catch (NumberFormatException e) { // 可以直接拋Exception就好//父類別java.lang.Number及IllegalArgumentException
				categoryId = 0; // 前端介面預設顯示
				errorMsgs.put("商品編號","請勿空白");
			}

			Integer price = null;
			try {
				price = Integer.valueOf(req.getParameter("price").trim());
			} catch (NumberFormatException e) { // 可以直接拋Exception就好//父類別java.lang.Number及IllegalArgumentException
				price = 0; // 前端介面預設顯示
				errorMsgs.put("價格","請填數字.");
			}

			Integer quantity = null;
			try {
				quantity = Integer.valueOf(req.getParameter("quantity").trim());
			} catch (NumberFormatException e) {
				quantity = 0;
				errorMsgs.put("數量","請填數字.");
			}

			String description = req.getParameter("description");
			String descriptionReg = "^[(\u4e00-\u9fa5)(a-zA-Z0-9_)]{2,10}$"; // 是中、英文字母、數字和_ , 且長度必需在2到10之間
			if (description == null || description.trim().length() == 0) {
				errorMsgs.put("無商品描述","請寫:無");
			} else if (!description.trim().matches(descriptionReg)) { // 以下練習正則(規)表示式(regular-expression)matches匹配
				errorMsgs.put("商品描述","只能是中、英文字母、數字和_ , 且長度必需在2到10之間");
			}
			
			Integer reviewStatus;
			try {
				reviewStatus = Integer.valueOf(req.getParameter("reviewStatus").trim());
			} catch (NumberFormatException e) { // 可以直接拋Exception就好//父類別java.lang.Number及IllegalArgumentException
				reviewStatus = 0; // 前端介面預設顯示
				errorMsgs.put("請填寫","審核狀態");
			}

			Integer productStatus;
			try {
				productStatus = Integer.valueOf(req.getParameter("productStatus").trim());
			} catch (NumberFormatException e) { // 可以直接拋Exception就好//父類別java.lang.Number及IllegalArgumentException
				productStatus = 0; // 前端介面預設顯示
				errorMsgs.put("請填寫","上架狀態");
			}

			ProductVO productVO = new ProductVO();
			productVO.setProductId(productId);
			productVO.setName(name);
			productVO.setSellerId(sellerId);
			productVO.setCategoryId(categoryId);
			productVO.setPrice(price);
			productVO.setQuantity(quantity);
			productVO.setDescription(descriptionReg);
			productVO.setReviewStatus(reviewStatus);
			productVO.setProductStatus(productStatus);

			if (!errorMsgs.isEmpty()) { // errorMsgs上面有錯誤訊息時就會進入
				req.setAttribute("productVO", productVO); // 含有輸入格式錯誤的empVO物件,也存入req //保持錯誤時填寫正確的資料 addEmp.java [6]
				RequestDispatcher failureView = req.getRequestDispatcher("/product/update_product_input.jsp");
				failureView.forward(req, res);
				return;
			}

			/*************************** 2.開始新增資料 ***************************************/
			ProductService productSvc = new ProductService();
			productVO = productSvc.updateProduct(productId, name, sellerId, categoryId, price, quantity, description, reviewStatus,
					productStatus);

			/***************************3.修改完成,準備轉交(Send the Success view)*************/
			req.setAttribute("productVO", productVO); // 資料庫update成功後,正確的的empVO物件,存入req
			String url = "/product/listOneProduct.jsp";
			RequestDispatcher successView = req.getRequestDispatcher(url); // 修改成功後,轉交listOneEmp.jsp
			successView.forward(req, res);
		}
		
//		
		
		if ("insert".equals(action)) { // 來自addEmp.jsp的請求

//			List<String> errorMsgs = new LinkedList<String>();
			// Store this set in the request scope, in case we need to
			// send the ErrorPage view.
//			req.setAttribute("errorMsgs", errorMsgs);
			
			Map<String,String> errorMsgs = new LinkedHashMap<String,String>();
			req.setAttribute("errorMsgs", errorMsgs);

			/*********************** 1.接收請求參數 - 輸入格式的錯誤處理 *************************/
			String name = req.getParameter("name");
			String nameReg = "^[(\u4e00-\u9fa5)(a-zA-Z0-9_)]{2,10}$"; // 是中、英文字母、數字和_ , 且長度必需在2到10之間
			if (name == null || name.trim().length() == 0) {
				errorMsgs.put("商品名稱","請勿空白");
			} else if (!name.trim().matches(nameReg)) { // 以下練習正則(規)表示式(regular-expression)matches匹配
				errorMsgs.put("商品名稱","只能是中、英文字母、數字和_ , 且長度必需在2到10之間");
			}

//			String sellerId = req.getParameter("sellerId").trim();
//			if (sellerId == null || sellerId.trim().length() == 0) {
//				errorMsgs.add("賣家編號請勿空白");
//			}
			Integer sellerId = null;
			try {
				sellerId = Integer.valueOf(req.getParameter("sellerId").trim());
			} catch (NumberFormatException e) { // 可以直接拋Exception就好//父類別java.lang.Number及IllegalArgumentException
				sellerId = 0; // 前端介面預設顯示
				errorMsgs.put("賣家編號","請勿空白");
			}

//			String categoryId = req.getParameter("categoryId").trim();
//			if (categoryId == null || categoryId.trim().length() == 0) {
//				errorMsgs.add("分類編號請勿空白");
//			}
			Integer categoryId = null;
			try {
				categoryId = Integer.valueOf(req.getParameter("categoryId").trim());
			} catch (NumberFormatException e) { // 可以直接拋Exception就好//父類別java.lang.Number及IllegalArgumentException
				categoryId = 0; // 前端介面預設顯示
				errorMsgs.put("商品編號","請勿空白");
			}

			Integer price = null;
			try {
				price = Integer.valueOf(req.getParameter("price").trim());
			} catch (NumberFormatException e) { // 可以直接拋Exception就好//父類別java.lang.Number及IllegalArgumentException
				price = 0; // 前端介面預設顯示
				errorMsgs.put("價格","請填數字.");
			}

			Integer quantity = null;
			try {
				quantity = Integer.valueOf(req.getParameter("quantity").trim());
			} catch (NumberFormatException e) {
				quantity = 0;
				errorMsgs.put("數量","請填數字.");
			}

			String description = req.getParameter("description");
			String descriptionReg = "^[(\u4e00-\u9fa5)(a-zA-Z0-9_)]{2,10}$"; // 是中、英文字母、數字和_ , 且長度必需在2到10之間
			if (description == null || description.trim().length() == 0) {
				errorMsgs.put("無商品描述","請寫:無");
			} else if (!description.trim().matches(descriptionReg)) { // 以下練習正則(規)表示式(regular-expression)matches匹配
				errorMsgs.put("商品描述","只能是中、英文字母、數字和_ , 且長度必需在2到10之間");
			}

//			Integer deptno = Integer.valueOf(req.getParameter("deptno").trim());

//			Integer reviewStatus = null;
			Integer reviewStatus;
			try {
				reviewStatus = Integer.valueOf(req.getParameter("reviewStatus").trim());
			} catch (NumberFormatException e) { // 可以直接拋Exception就好//父類別java.lang.Number及IllegalArgumentException
				reviewStatus = 0; // 前端介面預設顯示
				errorMsgs.put("請填寫","審核狀態");
			}

			Integer productStatus;
			try {
				productStatus = Integer.valueOf(req.getParameter("productStatus").trim());
			} catch (NumberFormatException e) { // 可以直接拋Exception就好//父類別java.lang.Number及IllegalArgumentException
				productStatus = 0; // 前端介面預設顯示
				errorMsgs.put("請填寫","上架狀態");
			}

			ProductVO productVO = new ProductVO();
			productVO.setName(name);
			productVO.setSellerId(sellerId);
			productVO.setCategoryId(categoryId);
			productVO.setPrice(price);
			productVO.setQuantity(quantity);
			productVO.setDescription(descriptionReg);
			productVO.setReviewStatus(reviewStatus);
			productVO.setProductStatus(productStatus);

			// Send the use back to the form, if there were errors
			if (!errorMsgs.isEmpty()) { // errorMsgs上面有錯誤訊息時就會進入
				req.setAttribute("productVO", productVO); // 含有輸入格式錯誤的empVO物件,也存入req //保持錯誤時填寫正確的資料 addEmp.java [6]
				RequestDispatcher failureView = req.getRequestDispatcher("/product/addProduct.jsp");
				failureView.forward(req, res);
				return;
			}

			/*************************** 2.開始新增資料 ***************************************/
			ProductService productSvc = new ProductService();
			productVO = productSvc.addProduct(name, sellerId, categoryId, price, quantity, description, reviewStatus,
					productStatus);

			/*************************** 3.新增完成,準備轉交(Send the Success view) ***********/
			String url = "/product/listAllProduct_byDAO.jsp";
			RequestDispatcher successView = req.getRequestDispatcher(url); // 新增成功後轉交listAllEmp.jsp
			successView.forward(req, res);
		}
//
////		if ("delete".equals(action)) { // 來自listAllEmp.jsp
////
////			List<String> errorMsgs = new LinkedList<String>();
////			// Store this set in the request scope, in case we need to
////			// send the ErrorPage view.
////			req.setAttribute("errorMsgs", errorMsgs);
//
////			/*************************** 1.接收請求參數 ***************************************/
////			Integer empno = Integer.valueOf(req.getParameter("empno"));
////
////			/*************************** 2.開始刪除資料 ***************************************/
////			EmpService empSvc = new EmpService();
////			empSvc.deleteEmp(empno);
////
////			/*************************** 3.刪除完成,準備轉交(Send the Success view) ***********/
////			String url = "/emp/listAllEmp.jsp";
////			RequestDispatcher successView = req.getRequestDispatcher(url);// 刪除成功後,轉交回送出刪除的來源網頁
////			successView.forward(req, res);
////		}
	}
}
